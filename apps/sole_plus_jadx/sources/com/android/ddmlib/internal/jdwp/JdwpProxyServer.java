package com.android.ddmlib.internal.jdwp;

import com.android.ddmlib.Log;
import com.android.ddmlib.TimeoutException;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class JdwpProxyServer implements Runnable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long JOIN_TIMEOUT_MS = 5000;
    private static final long THROTTLE_TIMEOUT_MS = 1000;
    private final ConnectionState mConnectionStateChangedCallback;
    private JdwpClientManagerFactory mFactory;
    private SocketChannel mFallbackChannel;
    private long mLastAttemptTime;
    private ServerSocketChannel mListenChannel;
    private final int mListenPort;
    private Selector mSelector;
    private InetSocketAddress mServerAddress;
    private Thread myRunThread;
    private final Object myChannelLock = new Object();
    private boolean mQuit = false;
    private boolean mIsRunningAsServer = false;

    public interface ConnectionState {
        void changed();
    }

    public JdwpProxyServer(int listenPort, ConnectionState callback) {
        this.mListenPort = listenPort;
        this.mConnectionStateChangedCallback = callback;
    }

    public void start() throws IOException {
        this.mServerAddress = new InetSocketAddress(InetAddress.getByName("localhost"), this.mListenPort);
        try {
            startAsServer();
        } catch (BindException unused) {
            startAsClient();
        }
        Thread thread = new Thread(this, "JdwpProxyConnection");
        this.myRunThread = thread;
        thread.start();
    }

    boolean IsRunningAsServer() {
        return this.mIsRunningAsServer;
    }

    boolean IsConnectedOrListening() {
        SocketChannel socketChannel;
        boolean z;
        synchronized (this.myChannelLock) {
            ServerSocketChannel serverSocketChannel = this.mListenChannel;
            z = (serverSocketChannel != null && serverSocketChannel.socket().isBound()) || ((socketChannel = this.mFallbackChannel) != null && socketChannel.isConnected());
        }
        return z;
    }

    JdwpClientManagerFactory getFactory() {
        return this.mFactory;
    }

    private void startAsServer() throws IOException {
        synchronized (this.myChannelLock) {
            this.mListenChannel = ServerSocketChannel.open();
            this.mSelector = Selector.open();
            this.mFactory = new JdwpClientManagerFactory(this.mSelector);
            this.mListenChannel.socket().setReuseAddress(true);
            this.mListenChannel.socket().bind(this.mServerAddress);
            this.mListenChannel.configureBlocking(false);
            this.mListenChannel.register(this.mSelector, 16, this);
            this.mIsRunningAsServer = true;
        }
    }

    int getBindPort() {
        int localPort;
        synchronized (this.myChannelLock) {
            localPort = this.mListenChannel.socket().getLocalPort();
        }
        return localPort;
    }

    private void startAsClient() {
        this.mIsRunningAsServer = false;
    }

    public void stop() throws InterruptedException, IOException {
        this.mQuit = true;
        Selector selector = this.mSelector;
        if (selector != null) {
            selector.wakeup();
        }
        synchronized (this.myChannelLock) {
            SocketChannel socketChannel = this.mFallbackChannel;
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException unused) {
                }
            }
        }
        try {
            Selector selector2 = this.mSelector;
            if (selector2 != null) {
                if (!selector2.keys().isEmpty()) {
                    for (SelectionKey selectionKey : this.mSelector.keys()) {
                        if (selectionKey.attachment() instanceof JdwpSocketHandler) {
                            ((JdwpSocketHandler) selectionKey.attachment()).shutdown();
                        }
                    }
                }
                this.mSelector.close();
            }
        } catch (IOException unused2) {
        }
        Thread thread = this.myRunThread;
        if (thread != null) {
            try {
                thread.join(5000L);
                if (this.myRunThread.isAlive()) {
                    Log.e("ddms", "Run thread still alive after 5000ms");
                }
            } catch (InterruptedException unused3) {
            }
        }
        synchronized (this.myChannelLock) {
            ServerSocketChannel serverSocketChannel = this.mListenChannel;
            if (serverSocketChannel != null) {
                try {
                    serverSocketChannel.close();
                    this.mListenChannel.socket().close();
                } catch (IOException unused4) {
                }
            }
        }
        this.mSelector = null;
        synchronized (this.myChannelLock) {
            this.mListenChannel = null;
            this.mFallbackChannel = null;
        }
        this.myRunThread = null;
    }

    private void runAsFallbackServer() throws InterruptedException, IOException {
        try {
            if (System.currentTimeMillis() - this.mLastAttemptTime < 1000) {
                Thread.sleep(1000L);
            }
            this.mLastAttemptTime = System.currentTimeMillis();
            synchronized (this.myChannelLock) {
                if (this.mQuit) {
                    return;
                }
                if (this.mFallbackChannel == null) {
                    this.mFallbackChannel = SocketChannel.open(this.mServerAddress);
                }
                this.mFallbackChannel.read(ByteBuffer.allocate(1));
                retryAsServer();
            }
        } catch (IOException unused) {
            retryAsServer();
        }
    }

    private void retryAsServer() throws IOException {
        if (this.mQuit) {
            return;
        }
        synchronized (this.myChannelLock) {
            SocketChannel socketChannel = this.mFallbackChannel;
            if (socketChannel != null) {
                socketChannel.close();
                this.mFallbackChannel = null;
            }
        }
        Selector selector = this.mSelector;
        if (selector != null) {
            selector.close();
            this.mSelector = null;
        }
        if (this.mQuit) {
            return;
        }
        startAsServer();
        this.mConnectionStateChangedCallback.changed();
    }

    private void runAsServer() throws IOException {
        if (this.mSelector.select() == 0) {
            return;
        }
        Iterator<SelectionKey> it = this.mSelector.selectedKeys().iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            try {
                if (next.isAcceptable()) {
                    synchronized (this.myChannelLock) {
                        SocketChannel socketChannelAccept = this.mListenChannel.accept();
                        socketChannelAccept.configureBlocking(false);
                        socketChannelAccept.register(this.mSelector, 1, new JdwpProxyClient(socketChannelAccept, this.mFactory));
                    }
                } else if (next.attachment() instanceof JdwpSocketHandler) {
                    JdwpSocketHandler jdwpSocketHandler = (JdwpSocketHandler) next.attachment();
                    try {
                        jdwpSocketHandler.read();
                    } catch (TimeoutException | IOException | BufferOverflowException unused) {
                        jdwpSocketHandler.shutdown();
                    }
                } else {
                    Log.e("ddms", "unknown activity key");
                }
            } catch (Exception e) {
                Log.e("ddms", "Exception during activity from Selector.");
                Log.e("ddms", e);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.mQuit) {
            try {
                if (this.mIsRunningAsServer) {
                    runAsServer();
                } else {
                    runAsFallbackServer();
                }
            } catch (Exception e) {
                Log.e("JdwpProxyServer", e);
            }
        }
    }
}
