package com.android.ddmlib.internal;

import com.android.ddmlib.DdmJdwpExtension;
import com.android.ddmlib.Log;
import com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import com.android.ddmlib.jdwp.JdwpExtension;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public final class MonitorThread extends Thread {
    private static MonitorThread sInstance;
    private final ArrayList<ClientImpl> mClientList;
    private final DdmJdwpExtension mDdmJdwpExtension;
    private final List<JdwpExtension> mJdwpExtensions;
    private volatile boolean mQuit;
    private Selector mSelector;

    public boolean getRetryOnBadHandshake() {
        return true;
    }

    private MonitorThread() {
        super("Monitor");
        this.mQuit = false;
        this.mClientList = new ArrayList<>();
        DdmJdwpExtension ddmJdwpExtension = new DdmJdwpExtension();
        this.mDdmJdwpExtension = ddmJdwpExtension;
        LinkedList linkedList = new LinkedList();
        this.mJdwpExtensions = linkedList;
        linkedList.add(ddmJdwpExtension);
    }

    public static MonitorThread createInstance() {
        MonitorThread monitorThread = new MonitorThread();
        sInstance = monitorThread;
        return monitorThread;
    }

    public static MonitorThread getInstance() {
        return sInstance;
    }

    ClientImpl[] getClients() {
        ClientImpl[] clientImplArr;
        synchronized (this.mClientList) {
            clientImplArr = (ClientImpl[]) this.mClientList.toArray(new ClientImpl[0]);
        }
        return clientImplArr;
    }

    public synchronized void registerChunkHandler(int type, ChunkHandler handler) {
        if (sInstance == null) {
            return;
        }
        this.mDdmJdwpExtension.registerHandler(type, handler);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Log.d("ddms", "Monitor is up");
        try {
            this.mSelector = Selector.open();
            while (!this.mQuit) {
                try {
                    synchronized (this.mClientList) {
                    }
                    try {
                        if (this.mSelector.select() != 0) {
                            Iterator<SelectionKey> it = this.mSelector.selectedKeys().iterator();
                            while (it.hasNext()) {
                                SelectionKey next = it.next();
                                it.remove();
                                try {
                                    if (next.attachment() instanceof ClientImpl) {
                                        processClientActivity(next);
                                    } else if (next.attachment() instanceof Debugger) {
                                        processDebuggerActivity(next);
                                    } else {
                                        Log.e("ddms", "unknown activity key");
                                    }
                                } catch (Exception e) {
                                    Log.e("ddms", "Exception during activity from Selector.");
                                    Log.e("ddms", e);
                                }
                            }
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    } catch (CancelledKeyException unused) {
                    }
                } catch (Exception e3) {
                    Log.e("ddms", "Exception MonitorThread.run()");
                    Log.e("ddms", e3);
                }
            }
        } catch (IOException e4) {
            Log.logAndDisplay(Log.LogLevel.ERROR, "ddms", "Failed to initialize Monitor Thread: " + e4.getMessage());
        }
    }

    private void processClientActivity(SelectionKey key) {
        ClientImpl clientImpl = (ClientImpl) key.attachment();
        try {
            if (key.isReadable() && key.isValid()) {
                clientImpl.read();
                for (JdwpPacket jdwpPacket = clientImpl.getJdwpPacket(); jdwpPacket != null; jdwpPacket = clientImpl.getJdwpPacket()) {
                    jdwpPacket.log("Client: received jdwp packet");
                    clientImpl.incoming(jdwpPacket, clientImpl.getDebugger());
                    jdwpPacket.consume();
                }
                return;
            }
            Log.d("ddms", "Invalid key from " + clientImpl + ". Dropping client.");
            dropClient(clientImpl, true);
        } catch (IOException unused) {
            dropClient(clientImpl, true);
        } catch (CancelledKeyException unused2) {
            dropClient(clientImpl, true);
        } catch (Exception e) {
            Log.e("ddms", e);
            dropClient(clientImpl, true);
            if (e instanceof BufferOverflowException) {
                Log.w("ddms", "Client data packet exceeded maximum buffer size " + clientImpl);
            } else {
                Log.e("ddms", e);
            }
        }
    }

    public synchronized void dropClient(ClientImpl client, boolean notify) {
        if (sInstance == null) {
            return;
        }
        synchronized (this.mClientList) {
            if (this.mClientList.remove(client)) {
                client.close(notify);
                this.mDdmJdwpExtension.broadcast(DdmJdwpExtension.Event.CLIENT_DISCONNECTED, client);
                wakeup();
            }
        }
    }

    public synchronized void dropClients(Collection<? extends ClientImpl> clients, boolean notify) {
        Iterator<? extends ClientImpl> it = clients.iterator();
        while (it.hasNext()) {
            dropClient(it.next(), notify);
        }
    }

    private void processDebuggerActivity(SelectionKey key) {
        Debugger debugger = (Debugger) key.attachment();
        try {
            if (key.isAcceptable()) {
                try {
                    acceptNewDebugger(debugger, null);
                } catch (IOException e) {
                    Log.w("ddms", "debugger accept() failed");
                    e.printStackTrace();
                }
            } else if (key.isReadable()) {
                processDebuggerData(key);
            } else {
                Log.d("ddm-debugger", "key in unknown state");
            }
        } catch (CancelledKeyException unused) {
        }
    }

    private void acceptNewDebugger(Debugger dbg, ServerSocketChannel acceptChan) throws IOException {
        SocketChannel socketChannelAccept;
        synchronized (this.mClientList) {
            if (acceptChan == null) {
                socketChannelAccept = dbg.accept();
            } else {
                socketChannelAccept = dbg.accept(acceptChan);
            }
            if (socketChannelAccept != null) {
                socketChannelAccept.socket().setTcpNoDelay(true);
                wakeup();
                try {
                    try {
                        socketChannelAccept.register(this.mSelector, 1, dbg);
                    } catch (IOException e) {
                        dbg.closeData();
                        throw e;
                    }
                } catch (RuntimeException e2) {
                    dbg.closeData();
                    throw e2;
                }
            } else {
                Log.w("ddms", "ignoring duplicate debugger");
            }
        }
    }

    private void processDebuggerData(SelectionKey key) {
        ((Debugger) key.attachment()).processChannelData();
    }

    private void wakeup() {
        Selector selector = this.mSelector;
        if (selector != null) {
            selector.wakeup();
        }
    }

    public synchronized void quit() {
        this.mQuit = true;
        wakeup();
        Log.d("ddms", "Waiting for Monitor thread");
        try {
            try {
                join();
                synchronized (this.mClientList) {
                    Iterator<ClientImpl> it = this.mClientList.iterator();
                    while (it.hasNext()) {
                        ClientImpl next = it.next();
                        next.close(false);
                        this.mDdmJdwpExtension.broadcast(DdmJdwpExtension.Event.CLIENT_DISCONNECTED, next);
                    }
                    this.mClientList.clear();
                }
                Selector selector = this.mSelector;
                if (selector != null) {
                    selector.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        sInstance = null;
    }

    public synchronized void addClient(ClientImpl client) {
        Debugger debugger;
        if (sInstance == null) {
            return;
        }
        Log.d("ddms", "Adding new client " + client);
        synchronized (this.mClientList) {
            this.mClientList.add(client);
            Iterator<JdwpExtension> it = this.mJdwpExtensions.iterator();
            while (it.hasNext()) {
                it.next().intercept(client);
            }
            try {
                wakeup();
                client.register(this.mSelector);
                debugger = client.getDebugger();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (debugger != null) {
                debugger.registerListener(this.mSelector);
            }
        }
    }

    public DdmJdwpExtension getDdmExtension() {
        return this.mDdmJdwpExtension;
    }
}
