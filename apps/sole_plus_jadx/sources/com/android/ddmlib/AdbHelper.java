package com.android.ddmlib;

import com.android.annotations.concurrency.Slow;
import com.android.ddmlib.log.LogReceiver;
import com.google.common.base.Strings;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class AdbHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ADB_HEADER_SIZE = 4;
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final String HOST_TRANSPORT = "host:transport:";
    static final int WAIT_TIME = 5;

    public static class AdbResponse {
        public String message = "";
        public boolean okay;
    }

    public enum AdbService {
        SHELL,
        EXEC,
        ABB_EXEC
    }

    private AdbHelper() {
    }

    public static SocketChannel rawExec(InetSocketAddress socketAddress, IDevice device, String executable, String[] parameters) throws IOException, TimeoutException, AdbCommandRejectedException {
        StringBuilder sb = new StringBuilder(executable);
        for (String str : parameters) {
            sb.append(" ");
            sb.append(str);
        }
        return rawAdbService(socketAddress, device, sb.toString(), AdbService.EXEC);
    }

    public static SocketChannel rawAdbService(InetSocketAddress socketAddress, IDevice device, String command, AdbService service) throws Exception {
        SocketChannel socketChannelOpen = SocketChannel.open(socketAddress);
        try {
            socketChannelOpen.socket().setTcpNoDelay(true);
            socketChannelOpen.configureBlocking(false);
            socketChannelOpen.setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_KEEPALIVE, (SocketOption) true);
            setDevice(socketChannelOpen, device);
            write(socketChannelOpen, formAdbRequest(service, command));
            AdbResponse adbResponse = readAdbResponse(socketChannelOpen, false);
            if (adbResponse.okay) {
                return socketChannelOpen;
            }
            Log.e("ddms", "ADB rejected " + service.name().toLowerCase(Locale.US) + "command (" + command + "): " + adbResponse.message);
            throw new AdbCommandRejectedException(adbResponse.message);
        } catch (Exception e) {
            socketChannelOpen.close();
            throw e;
        }
    }

    @Slow
    public static SocketChannel open(InetSocketAddress adbSockAddr, IDevice device, int devicePort) throws IOException, TimeoutException, AdbCommandRejectedException {
        SocketChannel socketChannelOpen = SocketChannel.open(adbSockAddr);
        try {
            socketChannelOpen.socket().setTcpNoDelay(true);
            socketChannelOpen.configureBlocking(false);
            setDevice(socketChannelOpen, device);
            write(socketChannelOpen, createAdbForwardRequest(null, devicePort));
            AdbResponse adbResponse = readAdbResponse(socketChannelOpen, false);
            if (!adbResponse.okay) {
                throw new AdbCommandRejectedException(adbResponse.message);
            }
            socketChannelOpen.configureBlocking(true);
            return socketChannelOpen;
        } catch (AdbCommandRejectedException e) {
            socketChannelOpen.close();
            throw e;
        } catch (TimeoutException e2) {
            socketChannelOpen.close();
            throw e2;
        } catch (IOException e3) {
            socketChannelOpen.close();
            throw e3;
        }
    }

    @Slow
    public static SocketChannel createPassThroughConnection(InetSocketAddress adbSockAddr, String deviceSerialNumber, int pid) throws IOException, TimeoutException, AdbCommandRejectedException {
        SocketChannel socketChannelOpen = SocketChannel.open(adbSockAddr);
        try {
            socketChannelOpen.socket().setTcpNoDelay(true);
            socketChannelOpen.configureBlocking(false);
            setDevice(socketChannelOpen, deviceSerialNumber);
            write(socketChannelOpen, createJdwpForwardRequest(pid));
            AdbResponse adbResponse = readAdbResponse(socketChannelOpen, false);
            if (!adbResponse.okay) {
                throw new AdbCommandRejectedException(adbResponse.message);
            }
            socketChannelOpen.configureBlocking(true);
            return socketChannelOpen;
        } catch (AdbCommandRejectedException e) {
            socketChannelOpen.close();
            throw e;
        } catch (TimeoutException e2) {
            socketChannelOpen.close();
            throw e2;
        } catch (IOException e3) {
            socketChannelOpen.close();
            throw e3;
        }
    }

    private static byte[] createAdbForwardRequest(String addrStr, int port) {
        String str;
        if (addrStr == null) {
            str = "tcp:" + port;
        } else {
            str = "tcp:" + port + ":" + addrStr;
        }
        return formAdbRequest(str);
    }

    public static byte[] createJdwpForwardRequest(int pid) {
        return formAdbRequest(String.format("jdwp:%1$d", Integer.valueOf(pid)));
    }

    public static byte[] formAdbRequest(String payloadString) {
        byte[] bytes = payloadString.getBytes(DEFAULT_CHARSET);
        byte[] bytes2 = String.format("%04X", Integer.valueOf(bytes.length)).getBytes(StandardCharsets.US_ASCII);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes2.length + bytes.length);
        byteBufferAllocate.put(bytes2);
        byteBufferAllocate.put(bytes);
        return byteBufferAllocate.array();
    }

    static byte[] formAdbRequest(AdbService service, String cmd) {
        return formAdbRequest(service, cmd.split(" "));
    }

    static byte[] formAdbRequest(AdbService service, String[] cmd) {
        String str;
        String lowerCase = service.name().toLowerCase(Locale.US);
        int i = AnonymousClass1.$SwitchMap$com$android$ddmlib$AdbHelper$AdbService[service.ordinal()];
        if (i == 1 || i == 2) {
            str = String.format("%s:%s", lowerCase, String.join(" ", cmd));
        } else if (i == 3) {
            str = String.format("%s:%s", lowerCase, String.join("\u0000", cmd));
        } else {
            throw new IllegalArgumentException(String.format("Invalid AdbService value (%s)", service.name()));
        }
        return formAdbRequest(str);
    }

    /* renamed from: com.android.ddmlib.AdbHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$ddmlib$AdbHelper$AdbService;

        static {
            int[] iArr = new int[AdbService.values().length];
            $SwitchMap$com$android$ddmlib$AdbHelper$AdbService = iArr;
            try {
                iArr[AdbService.SHELL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$ddmlib$AdbHelper$AdbService[AdbService.EXEC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$ddmlib$AdbHelper$AdbService[AdbService.ABB_EXEC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static AdbResponse readAdbResponse(SocketChannel chan, boolean readDiagString) throws IOException, TimeoutException {
        return readAdbResponse(chan, readDiagString, DdmPreferences.getTimeOut());
    }

    private static AdbResponse readAdbResponse(SocketChannel chan, boolean readDiagString, long timeOutMs) throws IOException, TimeoutException {
        boolean z;
        Timeout timeout = new Timeout(timeOutMs);
        AdbResponse adbResponse = new AdbResponse();
        byte[] bArr = new byte[4];
        read(chan, bArr, -1, timeout.remaining());
        if (isOkay(bArr)) {
            adbResponse.okay = true;
            z = readDiagString;
        } else {
            adbResponse.okay = false;
            z = true;
        }
        if (z) {
            try {
                byte[] bArr2 = new byte[4];
                read(chan, bArr2, -1, timeout.remaining());
                String strReplyToString = replyToString(bArr2);
                try {
                    byte[] bArr3 = new byte[Integer.parseInt(strReplyToString, 16)];
                    read(chan, bArr3, -1, timeout.remaining());
                    adbResponse.message = replyToString(bArr3);
                    Log.v("ddms", "Got reply '" + replyToString(bArr) + "', diag='" + adbResponse.message + "'");
                } catch (NumberFormatException unused) {
                    Log.w("ddms", "Expected digits, got '" + strReplyToString + "': " + ((int) bArr2[0]) + " " + ((int) bArr2[1]) + " " + ((int) bArr2[2]) + " " + ((int) bArr2[3]));
                    Log.w("ddms", "reply was " + replyToString(bArr));
                }
            } catch (Exception unused2) {
            }
        }
        return adbResponse;
    }

    @Slow
    public static RawImage getFrameBuffer(InetSocketAddress adbSockAddr, IDevice device, long timeout, TimeUnit unit) throws Throwable {
        RawImage rawImage = new RawImage();
        byte[] bArrFormAdbRequest = formAdbRequest("framebuffer:");
        byte[] bArr = {0};
        SocketChannel socketChannel = null;
        try {
            SocketChannel socketChannelOpen = SocketChannel.open(adbSockAddr);
            try {
                socketChannelOpen.configureBlocking(false);
                setDevice(socketChannelOpen, device);
                write(socketChannelOpen, bArrFormAdbRequest);
                AdbResponse adbResponse = readAdbResponse(socketChannelOpen, false);
                if (!adbResponse.okay) {
                    throw new AdbCommandRejectedException(adbResponse.message);
                }
                byte[] bArr2 = new byte[4];
                read(socketChannelOpen, bArr2);
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr2);
                byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                int i = byteBufferWrap.getInt();
                byte[] bArr3 = new byte[RawImage.getHeaderSize(i) * 4];
                read(socketChannelOpen, bArr3);
                ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr3);
                byteBufferWrap2.order(ByteOrder.LITTLE_ENDIAN);
                if (!rawImage.readHeader(i, byteBufferWrap2)) {
                    Log.e("Screenshot", "Unsupported protocol: " + i);
                    if (socketChannelOpen != null) {
                        socketChannelOpen.close();
                    }
                    return null;
                }
                Log.d("ddms", "image params: bpp=" + rawImage.bpp + ", size=" + rawImage.size + ", width=" + rawImage.width + ", height=" + rawImage.height);
                write(socketChannelOpen, bArr);
                byte[] bArr4 = new byte[rawImage.size];
                read(socketChannelOpen, bArr4, rawImage.size, unit.toMillis(timeout));
                rawImage.data = bArr4;
                if (socketChannelOpen != null) {
                    socketChannelOpen.close();
                }
                return rawImage;
            } catch (Throwable th) {
                th = th;
                socketChannel = socketChannelOpen;
                if (socketChannel != null) {
                    socketChannel.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void executeRemoteCommand(InetSocketAddress adbSockAddr, String command, IDevice device, IShellOutputReceiver rcvr, long maxTimeout, long maxTimeToOutputResponse, TimeUnit maxTimeUnits) throws Throwable {
        executeRemoteCommand(adbSockAddr, AdbService.SHELL, command, device, rcvr, maxTimeout, maxTimeToOutputResponse, maxTimeUnits, null);
    }

    public static void executeRemoteCommand(InetSocketAddress adbSockAddr, String command, IDevice device, IShellOutputReceiver rcvr, long maxTimeToOutputResponse, TimeUnit maxTimeUnits) throws Throwable {
        executeRemoteCommand(adbSockAddr, AdbService.SHELL, command, device, rcvr, maxTimeToOutputResponse, maxTimeUnits, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0148, code lost:
    
        r29.flush();
        com.android.ddmlib.Log.v("ddms", "execute '" + r27 + "' on '" + r28 + "' : EOF hit. Read: " + r11);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x023d  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.nio.channels.SocketChannel] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.nio.channels.SocketChannel] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.nio.channels.SocketChannel] */
    /* JADX WARN: Type inference failed for: r7v9 */
    @com.android.annotations.concurrency.Slow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void executeRemoteCommand(java.net.InetSocketAddress r25, com.android.ddmlib.AdbHelper.AdbService r26, java.lang.String r27, com.android.ddmlib.IDevice r28, com.android.ddmlib.IShellOutputReceiver r29, long r30, long r32, java.util.concurrent.TimeUnit r34, java.io.InputStream r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ddmlib.AdbHelper.executeRemoteCommand(java.net.InetSocketAddress, com.android.ddmlib.AdbHelper$AdbService, java.lang.String, com.android.ddmlib.IDevice, com.android.ddmlib.IShellOutputReceiver, long, long, java.util.concurrent.TimeUnit, java.io.InputStream):void");
    }

    static void executeRemoteCommand(InetSocketAddress adbSockAddr, AdbService adbService, String command, IDevice device, IShellOutputReceiver rcvr, long maxTimeToOutputResponse, TimeUnit maxTimeUnits, InputStream is) throws Throwable {
        executeRemoteCommand(adbSockAddr, adbService, command, device, rcvr, 0L, maxTimeToOutputResponse, maxTimeUnits, is);
    }

    public static void runEventLogService(InetSocketAddress adbSockAddr, IDevice device, LogReceiver rcvr) throws Throwable {
        runLogService(adbSockAddr, device, "events", rcvr);
    }

    @Slow
    public static void runLogService(InetSocketAddress adbSockAddr, IDevice device, String logName, LogReceiver rcvr) throws Throwable {
        SocketChannel socketChannelOpen;
        try {
            socketChannelOpen = SocketChannel.open(adbSockAddr);
            try {
                socketChannelOpen.configureBlocking(false);
                setDevice(socketChannelOpen, device);
                write(socketChannelOpen, formAdbRequest("log:" + logName));
                AdbResponse adbResponse = readAdbResponse(socketChannelOpen, false);
                if (!adbResponse.okay) {
                    throw new AdbCommandRejectedException(adbResponse.message);
                }
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[16384]);
                while (true) {
                    if (rcvr != null && rcvr.isCancelled()) {
                        break;
                    }
                    int i = socketChannelOpen.read(byteBufferWrap);
                    if (i < 0) {
                        break;
                    }
                    if (i == 0) {
                        try {
                            Thread.sleep(25L);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new TimeoutException("runLogService interrupted with immediate timeout via interruption.");
                        }
                    } else {
                        if (rcvr != null) {
                            rcvr.parseNewData(byteBufferWrap.array(), byteBufferWrap.arrayOffset(), byteBufferWrap.position());
                        }
                        byteBufferWrap.rewind();
                    }
                }
                if (socketChannelOpen != null) {
                    socketChannelOpen.close();
                }
            } catch (Throwable th) {
                th = th;
                if (socketChannelOpen != null) {
                    socketChannelOpen.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            socketChannelOpen = null;
        }
    }

    @Slow
    public static void createForward(InetSocketAddress adbSockAddr, IDevice device, String localPortSpec, String remotePortSpec) throws Throwable {
        SocketChannel socketChannelOpen;
        try {
            socketChannelOpen = SocketChannel.open(adbSockAddr);
            try {
                socketChannelOpen.configureBlocking(false);
                write(socketChannelOpen, formAdbRequest(String.format("host-serial:%1$s:forward:%2$s;%3$s", device.getSerialNumber(), localPortSpec, remotePortSpec)));
                AdbResponse adbResponse = readAdbResponse(socketChannelOpen, false);
                if (!adbResponse.okay) {
                    Log.w("create-forward", "Error creating forward: " + adbResponse.message);
                    throw new AdbCommandRejectedException(adbResponse.message);
                }
                if (socketChannelOpen != null) {
                    socketChannelOpen.close();
                }
            } catch (Throwable th) {
                th = th;
                if (socketChannelOpen != null) {
                    socketChannelOpen.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            socketChannelOpen = null;
        }
    }

    @Slow
    public static void createReverse(InetSocketAddress adbSockAddr, IDevice device, String remotePortSpec, String localPortSpec) throws Throwable {
        SocketChannel socketChannelOpen;
        try {
            socketChannelOpen = SocketChannel.open(adbSockAddr);
            try {
                socketChannelOpen.configureBlocking(false);
                byte[] bArrFormAdbRequest = formAdbRequest(String.format("reverse:forward:%1$s;%2$s", localPortSpec, remotePortSpec));
                setDevice(socketChannelOpen, device.getSerialNumber());
                write(socketChannelOpen, bArrFormAdbRequest);
                AdbResponse adbResponse = readAdbResponse(socketChannelOpen, false);
                if (!adbResponse.okay) {
                    Log.w("create-reverse", "Error creating reverse: " + adbResponse.message);
                    throw new AdbCommandRejectedException(adbResponse.message);
                }
                if (socketChannelOpen != null) {
                    socketChannelOpen.close();
                }
            } catch (Throwable th) {
                th = th;
                if (socketChannelOpen != null) {
                    socketChannelOpen.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            socketChannelOpen = null;
        }
    }

    @Slow
    static String queryFeatures(String adbFeaturesRequest) throws IOException, TimeoutException, AdbCommandRejectedException {
        SocketChannel socketChannelOpenConnection = AndroidDebugBridge.openConnection();
        try {
            socketChannelOpenConnection.configureBlocking(false);
            write(socketChannelOpenConnection, formAdbRequest(adbFeaturesRequest));
            AdbResponse adbResponse = readAdbResponse(socketChannelOpenConnection, true);
            if (!adbResponse.okay) {
                Log.w("features", "Error querying features: " + adbResponse.message);
                throw new AdbCommandRejectedException(adbResponse.message);
            }
            String str = adbResponse.message;
            if (socketChannelOpenConnection != null) {
                socketChannelOpenConnection.close();
            }
            return str;
        } catch (Throwable th) {
            if (socketChannelOpenConnection != null) {
                try {
                    socketChannelOpenConnection.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Slow
    public static String getFeatures(IDevice device) throws IOException, TimeoutException, AdbCommandRejectedException {
        return queryFeatures(String.format("host-serial:%1$s:features", device.getSerialNumber()));
    }

    @Slow
    public static String getHostFeatures() throws IOException, TimeoutException, AdbCommandRejectedException {
        return queryFeatures("host:host-features");
    }

    @Slow
    public static void removeForward(InetSocketAddress adbSockAddr, IDevice device, String localPortSpec) throws Throwable {
        SocketChannel socketChannelOpen;
        try {
            socketChannelOpen = SocketChannel.open(adbSockAddr);
            try {
                socketChannelOpen.configureBlocking(false);
                write(socketChannelOpen, formAdbRequest(String.format("host-serial:%1$s:killforward:%2$s", device.getSerialNumber(), localPortSpec)));
                AdbResponse adbResponse = readAdbResponse(socketChannelOpen, false);
                if (!adbResponse.okay) {
                    Log.w("remove-forward", "Error removing forward: " + adbResponse.message);
                    throw new AdbCommandRejectedException(adbResponse.message);
                }
                if (socketChannelOpen != null) {
                    socketChannelOpen.close();
                }
            } catch (Throwable th) {
                th = th;
                if (socketChannelOpen != null) {
                    socketChannelOpen.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            socketChannelOpen = null;
        }
    }

    @Slow
    public static void removeReverse(InetSocketAddress adbSockAddr, IDevice device, String remotePortSpec) throws Throwable {
        SocketChannel socketChannelOpen;
        try {
            socketChannelOpen = SocketChannel.open(adbSockAddr);
        } catch (Throwable th) {
            th = th;
            socketChannelOpen = null;
        }
        try {
            socketChannelOpen.configureBlocking(false);
            byte[] bArrFormAdbRequest = formAdbRequest(String.format("reverse:killforward:%1$s", remotePortSpec));
            setDevice(socketChannelOpen, device.getSerialNumber());
            write(socketChannelOpen, bArrFormAdbRequest);
            AdbResponse adbResponse = readAdbResponse(socketChannelOpen, false);
            if (!adbResponse.okay) {
                Log.w("remove-reverse", "Error removing reverse: " + adbResponse.message);
                throw new AdbCommandRejectedException(adbResponse.message);
            }
            if (socketChannelOpen != null) {
                socketChannelOpen.close();
            }
        } catch (Throwable th2) {
            th = th2;
            if (socketChannelOpen != null) {
                socketChannelOpen.close();
            }
            throw th;
        }
    }

    static boolean isOkay(byte[] reply) {
        return reply[0] == 79 && reply[1] == 75 && reply[2] == 65 && reply[3] == 89;
    }

    static String replyToString(byte[] reply) {
        return new String(reply, DEFAULT_CHARSET);
    }

    static void read(SocketChannel chan, byte[] data) throws IOException, TimeoutException {
        read(chan, data, -1, DdmPreferences.getTimeOut());
    }

    @Slow
    static void read(SocketChannel chan, byte[] data, int length, long timeout) throws IOException, TimeoutException {
        if (length == -1) {
            length = data.length;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(data, 0, length);
        while (true) {
            int i = 0;
            while (byteBufferWrap.position() != byteBufferWrap.limit()) {
                int i2 = chan.read(byteBufferWrap);
                if (i2 < 0) {
                    Log.d("ddms", "read: channel EOF");
                    throw new EOFException("EOF");
                }
                if (i2 == 0) {
                    if (timeout != 0 && i * 5 > timeout) {
                        Log.d("ddms", "read: timeout");
                        throw new TimeoutException();
                    }
                    try {
                        Thread.sleep(5L);
                        i++;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new TimeoutException("Read interrupted with immediate timeout via interruption.");
                    }
                }
            }
            return;
        }
    }

    public static void write(SocketChannel chan, byte[] data) throws IOException, TimeoutException {
        write(chan, data, -1, DdmPreferences.getTimeOut());
    }

    @Slow
    public static void write(SocketChannel chan, byte[] data, int length, int timeout) throws IOException, TimeoutException {
        if (length == -1) {
            length = data.length;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(data, 0, length);
        while (true) {
            int i = 0;
            while (byteBufferWrap.position() != byteBufferWrap.limit()) {
                int iWrite = chan.write(byteBufferWrap);
                if (iWrite < 0) {
                    Log.d("ddms", "write: channel EOF");
                    throw new IOException("channel EOF");
                }
                if (iWrite == 0) {
                    if (timeout != 0 && i * 5 > timeout) {
                        Log.d("ddms", "write: timeout");
                        throw new TimeoutException();
                    }
                    try {
                        Thread.sleep(5L);
                        i++;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new TimeoutException("Write interrupted with immediate timeout via interruption.");
                    }
                }
            }
            return;
        }
    }

    public static void setDevice(SocketChannel adbChan, String deviceSerialNumber) throws IOException, TimeoutException, AdbCommandRejectedException {
        if (Strings.isNullOrEmpty(deviceSerialNumber)) {
            return;
        }
        write(adbChan, formAdbRequest(HOST_TRANSPORT + deviceSerialNumber));
        AdbResponse adbResponse = readAdbResponse(adbChan, false);
        if (!adbResponse.okay) {
            throw new AdbCommandRejectedException(adbResponse.message, true);
        }
    }

    public static void setDevice(SocketChannel adbChan, IDevice device) throws IOException, TimeoutException, AdbCommandRejectedException {
        if (device == null) {
            return;
        }
        setDevice(adbChan, device.getSerialNumber());
    }

    @Slow
    public static void reboot(String into, InetSocketAddress adbSockAddr, IDevice device) throws Throwable {
        byte[] bArrFormAdbRequest;
        SocketChannel socketChannelOpen;
        if (into == null) {
            bArrFormAdbRequest = formAdbRequest("reboot:");
        } else {
            bArrFormAdbRequest = formAdbRequest("reboot:" + into);
        }
        try {
            socketChannelOpen = SocketChannel.open(adbSockAddr);
        } catch (Throwable th) {
            th = th;
            socketChannelOpen = null;
        }
        try {
            socketChannelOpen.configureBlocking(false);
            setDevice(socketChannelOpen, device);
            write(socketChannelOpen, bArrFormAdbRequest);
            if (socketChannelOpen != null) {
                socketChannelOpen.close();
            }
        } catch (Throwable th2) {
            th = th2;
            if (socketChannelOpen != null) {
                socketChannelOpen.close();
            }
            throw th;
        }
    }

    @Slow
    public static void root(InetSocketAddress adbSockAddr, IDevice device) throws Throwable {
        SocketChannel socketChannelOpen;
        byte[] bArrFormAdbRequest = formAdbRequest("root:");
        try {
            socketChannelOpen = SocketChannel.open(adbSockAddr);
            try {
                socketChannelOpen.configureBlocking(false);
                setDevice(socketChannelOpen, device);
                write(socketChannelOpen, bArrFormAdbRequest);
                AdbResponse adbResponse = readAdbResponse(socketChannelOpen, false);
                if (!adbResponse.okay) {
                    Log.w("root", "Error setting root: " + adbResponse.message);
                    throw new AdbCommandRejectedException(adbResponse.message);
                }
                if (socketChannelOpen != null) {
                    socketChannelOpen.close();
                }
            } catch (Throwable th) {
                th = th;
                if (socketChannelOpen != null) {
                    socketChannelOpen.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            socketChannelOpen = null;
        }
    }

    public static void setAbbExecAllowed(boolean allowed) {
        SplitApkInstallerBase.setAbbExecAllowed(allowed);
    }
}
