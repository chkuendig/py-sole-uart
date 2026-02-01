package com.android.ddmlib.internal;

import com.android.ddmlib.Log;
import com.android.ddmlib.internal.commands.CommandResult;
import com.android.ddmlib.internal.commands.ICommand;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* compiled from: CommandService.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 )2\u00020\u0001:\u0002)*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0003J\b\u0010!\u001a\u00020\u0018H\u0016J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u0018J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\nH\u0002J\u0016\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u001dR\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/android/ddmlib/internal/CommandService;", "Ljava/lang/Runnable;", "mListenPort", "", "(I)V", "boundPort", "getBoundPort", "()I", "commandMap", "Ljava/util/HashMap;", "", "Lcom/android/ddmlib/internal/commands/ICommand;", "Lkotlin/collections/HashMap;", "listenChannel", "Ljava/nio/channels/ServerSocketChannel;", "quit", "", "runThread", "Ljava/lang/Thread;", "serverAddress", "Ljava/net/InetSocketAddress;", "startTimer", "Ljava/util/Timer;", "addCommand", "", "command", "handler", "processOneCommand", "client", "Ljava/nio/channels/SocketChannel;", "readExactly", "Ljava/nio/ByteBuffer;", "amount", "run", "start", "stop", "wrapString", "str", "write", "result", "Lcom/android/ddmlib/internal/commands/CommandResult;", "Companion", "ServerHostTimer", "ddmlib"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CommandService implements Runnable {
    private static final long JOIN_TIMEOUT_MS = 5000;
    private static final long RETRY_SERVER_MILLIS = 30000;
    private ServerSocketChannel listenChannel;
    private final int mListenPort;
    private Thread runThread;
    private InetSocketAddress serverAddress;
    private Timer startTimer;
    private boolean quit = true;
    private final HashMap<String, ICommand> commandMap = new HashMap<>();

    public CommandService(int i) {
        this.mListenPort = i;
    }

    public final int getBoundPort() {
        ServerSocket serverSocketSocket;
        ServerSocketChannel serverSocketChannel = this.listenChannel;
        if (serverSocketChannel == null || (serverSocketSocket = serverSocketChannel.socket()) == null) {
            return -1;
        }
        return serverSocketSocket.getLocalPort();
    }

    public final void addCommand(String command, ICommand handler) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.commandMap.put(command, handler);
    }

    public final void stop() throws InterruptedException, IOException {
        this.quit = true;
        ServerSocketChannel serverSocketChannel = this.listenChannel;
        if (serverSocketChannel != null) {
            try {
                Intrinsics.checkNotNull(serverSocketChannel);
                serverSocketChannel.close();
                ServerSocketChannel serverSocketChannel2 = this.listenChannel;
                Intrinsics.checkNotNull(serverSocketChannel2);
                serverSocketChannel2.socket().close();
            } catch (IOException e) {
                Log.w("CommandService", e);
            }
        }
        Thread thread = this.runThread;
        if (thread != null) {
            try {
                Intrinsics.checkNotNull(thread);
                thread.join(5000L);
                Thread thread2 = this.runThread;
                Intrinsics.checkNotNull(thread2);
                if (thread2.isAlive()) {
                    Log.e("CommandService", "Run thread still alive after 5000ms");
                }
            } catch (InterruptedException e2) {
                Log.w("CommandService", e2);
            }
        }
        this.listenChannel = null;
        this.runThread = null;
    }

    public final void start() {
        if (this.startTimer == null) {
            Timer timer = new Timer();
            this.startTimer = timer;
            Intrinsics.checkNotNull(timer);
            timer.schedule(new ServerHostTimer(this), 0L, 30000L);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.quit) {
            try {
                ServerSocketChannel serverSocketChannel = this.listenChannel;
                SocketChannel socketChannelAccept = serverSocketChannel == null ? null : serverSocketChannel.accept();
                if (socketChannelAccept != null) {
                    SocketChannel socketChannel = socketChannelAccept;
                    try {
                        processOneCommand(socketChannel);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(socketChannel, null);
                    } finally {
                    }
                }
            } catch (IOException e) {
                Log.e("CommandService", e);
                return;
            }
        }
    }

    public final void processOneCommand(SocketChannel client) throws IOException {
        Intrinsics.checkNotNullParameter(client, "client");
        String string = StandardCharsets.UTF_8.decode(readExactly(client, Integer.parseInt(StandardCharsets.UTF_8.decode(readExactly(client, 4)).toString(), 16))).toString();
        Intrinsics.checkNotNullExpressionValue(string, "UTF_8.decode(buffer).toString()");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) string, ":", 0, false, 6, (Object) null);
        if (iIndexOf$default == -1 && this.commandMap.containsKey(string)) {
            ICommand iCommand = this.commandMap.get(string);
            Intrinsics.checkNotNull(iCommand);
            CommandResult commandResultRun = iCommand.run(null);
            Intrinsics.checkNotNullExpressionValue(commandResultRun, "commandMap[data]!!.run(null)");
            write(commandResultRun, client);
            return;
        }
        if (iIndexOf$default == -1) {
            Log.w("CommandService", "Failed to find command");
            return;
        }
        String strSubstring = string.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strSubstring2 = string.substring(iIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        if (!this.commandMap.containsKey(strSubstring)) {
            Log.w("CommandService", "Unknown command received");
            return;
        }
        try {
            ICommand iCommand2 = this.commandMap.get(strSubstring);
            Intrinsics.checkNotNull(iCommand2);
            CommandResult commandResultRun2 = iCommand2.run(strSubstring2);
            Intrinsics.checkNotNullExpressionValue(commandResultRun2, "commandMap[command]!!.run(argsString)");
            write(commandResultRun2, client);
        } catch (Throwable th) {
            Log.w("CommandService", th);
        }
    }

    public final ByteBuffer readExactly(SocketChannel client, int amount) throws EOFException {
        Intrinsics.checkNotNullParameter(client, "client");
        ByteBuffer buffer = ByteBuffer.allocate(amount);
        while (buffer.hasRemaining()) {
            if (client.read(buffer) == -1) {
                throw new EOFException("Unexpected end of channel");
            }
        }
        buffer.position(0);
        Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
        return buffer;
    }

    public final void write(CommandResult result, SocketChannel client) throws IOException {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(client, "client");
        if (result.getSuccess()) {
            client.write(wrapString("OKAY"));
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("FAIL%04x%s", Arrays.copyOf(new Object[]{Integer.valueOf(result.getMessage().length()), result.getMessage()}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        client.write(wrapString(str));
    }

    private final ByteBuffer wrapString(String str) {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bytes);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(str.toByteArray(UTF_8))");
        return byteBufferWrap;
    }

    /* compiled from: CommandService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/android/ddmlib/internal/CommandService$ServerHostTimer;", "Ljava/util/TimerTask;", "(Lcom/android/ddmlib/internal/CommandService;)V", "run", "", "ddmlib"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class ServerHostTimer extends TimerTask {
        final /* synthetic */ CommandService this$0;

        public ServerHostTimer(CommandService this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws IOException {
            try {
                this.this$0.serverAddress = new InetSocketAddress(InetAddress.getByName("localhost"), this.this$0.mListenPort);
                this.this$0.listenChannel = ServerSocketChannel.open();
                ServerSocketChannel serverSocketChannel = this.this$0.listenChannel;
                Intrinsics.checkNotNull(serverSocketChannel);
                serverSocketChannel.socket().setReuseAddress(true);
                ServerSocketChannel serverSocketChannel2 = this.this$0.listenChannel;
                Intrinsics.checkNotNull(serverSocketChannel2);
                serverSocketChannel2.socket().bind(this.this$0.serverAddress);
                this.this$0.quit = false;
                this.this$0.runThread = new Thread(this.this$0, "CommandServiceConnection");
                Thread thread = this.this$0.runThread;
                Intrinsics.checkNotNull(thread);
                thread.start();
                Timer timer = this.this$0.startTimer;
                Intrinsics.checkNotNull(timer);
                timer.cancel();
                this.this$0.startTimer = null;
            } catch (BindException unused) {
                Log.i("CommandService", "Port is already bound");
            } catch (IOException e) {
                Log.e("CommandService", e);
            }
        }
    }
}
