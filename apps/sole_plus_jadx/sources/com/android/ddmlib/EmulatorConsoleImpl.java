package com.android.ddmlib;

import com.android.prefs.AndroidLocationsSingleton;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class EmulatorConsoleImpl extends EmulatorConsole {
    private static final String COMMAND_AUTH = "auth %1$s\r\n";
    private static final String COMMAND_AVD_NAME = "avd name\r\n";
    private static final String COMMAND_AVD_PATH = "avd path\r\n";
    private static final String COMMAND_KILL = "kill\r\n";
    private static final String COMMAND_PING = "help\r\n";
    private static final String COMMAND_SCREENRECORD_START = "screenrecord start %1$s\r\n";
    private static final String COMMAND_SCREENRECORD_STOP = "screenrecord stop\r\n";
    private static final String DEFAULT_ENCODING = "ISO-8859-1";
    private static final String EMULATOR_CONSOLE_AUTH_TOKEN = ".emulator_console_auth_token";
    private static final String HOST = "127.0.0.1";
    private static final String LOG_TAG = "EmulatorConsole";
    private static final String RE_AUTH_REQUIRED = "Android Console: Authentication required";
    private static final int STD_TIMEOUT = 5000;
    private static final int WAIT_TIME = 5;
    private final byte[] mBuffer = new byte[8192];
    private final int mPort;
    private SocketChannel mSocketChannel;
    private static final Pattern RE_KO = Pattern.compile("KO:\\s+(.*)");
    public static final String RESULT_OK = null;
    private static final Pattern sEmulatorRegexp = Pattern.compile(IDevice.RE_EMULATOR_SN);
    private static final HashMap<Integer, EmulatorConsoleImpl> sEmulators = new HashMap<>();

    static EmulatorConsoleImpl createConsole(IDevice d) throws NumberFormatException {
        Integer emulatorPortFromSerialNumber = getEmulatorPortFromSerialNumber(d.getSerialNumber());
        if (emulatorPortFromSerialNumber == null) {
            Log.w(LOG_TAG, "Failed to find emulator port from serial: " + d.getSerialNumber());
            return null;
        }
        EmulatorConsoleImpl emulatorConsoleImplRetrieveConsole = retrieveConsole(emulatorPortFromSerialNumber.intValue());
        if (emulatorConsoleImplRetrieveConsole.checkConnection()) {
            return emulatorConsoleImplRetrieveConsole;
        }
        emulatorConsoleImplRetrieveConsole.close();
        return null;
    }

    static Integer getEmulatorPortFromSerialNumber(String serialNumber) throws NumberFormatException {
        Matcher matcher = sEmulatorRegexp.matcher(serialNumber);
        if (!matcher.matches()) {
            return null;
        }
        try {
            int i = Integer.parseInt(matcher.group(1));
            if (i > 0) {
                return Integer.valueOf(i);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static EmulatorConsoleImpl retrieveConsole(int port) {
        EmulatorConsoleImpl emulatorConsoleImpl;
        HashMap<Integer, EmulatorConsoleImpl> map = sEmulators;
        synchronized (map) {
            emulatorConsoleImpl = map.get(Integer.valueOf(port));
            if (emulatorConsoleImpl == null) {
                Log.v(LOG_TAG, "Creating emulator console for " + port);
                emulatorConsoleImpl = new EmulatorConsoleImpl(port);
                map.put(Integer.valueOf(port), emulatorConsoleImpl);
            }
        }
        return emulatorConsoleImpl;
    }

    @Override // com.android.ddmlib.EmulatorConsole
    public void close() {
        HashMap<Integer, EmulatorConsoleImpl> map = sEmulators;
        synchronized (map) {
            Log.v(LOG_TAG, "Removing emulator console for " + this.mPort);
            map.remove(Integer.valueOf(this.mPort));
        }
        try {
            SocketChannel socketChannel = this.mSocketChannel;
            if (socketChannel != null) {
                socketChannel.close();
            }
            this.mSocketChannel = null;
        } catch (IOException unused) {
            Log.w(LOG_TAG, "Failed to close EmulatorConsole channel");
        }
    }

    private EmulatorConsoleImpl(int port) {
        this.mPort = port;
    }

    private synchronized boolean checkConnection() {
        if (this.mSocketChannel == null) {
            try {
                SocketChannel socketChannelOpen = SocketChannel.open(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), this.mPort));
                this.mSocketChannel = socketChannelOpen;
                socketChannelOpen.configureBlocking(false);
                String[] lines = readLines();
                if (lines == null) {
                    return false;
                }
                if (lines[0].endsWith(RE_AUTH_REQUIRED) && RESULT_OK != sendAuthentication()) {
                    Log.w(LOG_TAG, "Emulator console auth failed (is the emulator running as a different user?)");
                    return false;
                }
            } catch (IOException unused) {
                Log.w(LOG_TAG, "Failed to start Emulator console for " + this.mPort);
                return false;
            } catch (Throwable unused2) {
                Log.w(LOG_TAG, "Failed to get emulator console auth token");
                return false;
            }
        }
        return ping();
    }

    private synchronized boolean ping() {
        if (sendCommand(COMMAND_PING)) {
            return readLines() != null;
        }
        return false;
    }

    @Override // com.android.ddmlib.EmulatorConsole
    public synchronized void kill() {
        sendCommand(COMMAND_KILL);
    }

    @Override // com.android.ddmlib.EmulatorConsole
    public synchronized String getAvdName() {
        try {
        } catch (CommandFailedException e) {
            return e.getMessage();
        } catch (Exception e2) {
            if (!(e2 instanceof InterruptedException)) {
                return null;
            }
            Thread.currentThread().interrupt();
            return null;
        }
        return getOutput(COMMAND_AVD_NAME);
    }

    @Override // com.android.ddmlib.EmulatorConsole
    public synchronized String getAvdPath() throws CommandFailedException {
        return getOutput(COMMAND_AVD_PATH);
    }

    private String getOutput(String command) throws CommandFailedException {
        if (!sendCommand(command)) {
            throw new CommandFailedException();
        }
        return processOutput((String[]) Objects.requireNonNull(readLines()));
    }

    static String processOutput(String[] lines) throws CommandFailedException {
        if (lines.length == 0) {
            throw new IllegalArgumentException();
        }
        Matcher matcher = RE_KO.matcher(lines[lines.length - 1]);
        if (matcher.matches()) {
            throw new CommandFailedException(matcher.group(1));
        }
        if (lines.length >= 2 && lines[lines.length - 1].equals("OK")) {
            return lines[lines.length - 2];
        }
        String strLineSeparator = System.lineSeparator();
        throw new IllegalArgumentException("The last line doesn't equal \"OK\" nor start with \"KO:  \". lines = " + ((Object) strLineSeparator) + String.join(strLineSeparator, lines));
    }

    public synchronized String sendAuthentication() throws IOException {
        return processCommand(String.format(COMMAND_AUTH, Files.asCharSource(AndroidLocationsSingleton.INSTANCE.getUserHomeLocation().resolve(EMULATOR_CONSOLE_AUTH_TOKEN).toFile(), Charsets.UTF_8).read().trim()));
    }

    @Override // com.android.ddmlib.EmulatorConsole
    public synchronized String startEmulatorScreenRecording(String args) {
        return processCommand(String.format(COMMAND_SCREENRECORD_START, args));
    }

    @Override // com.android.ddmlib.EmulatorConsole
    public synchronized String stopScreenRecording() {
        return processCommand(COMMAND_SCREENRECORD_STOP);
    }

    private boolean sendCommand(String command) throws UnsupportedEncodingException {
        try {
            try {
                byte[] bytes = command.getBytes(DEFAULT_ENCODING);
                AdbHelper.write(this.mSocketChannel, bytes, bytes.length, DdmPreferences.getTimeOut());
                return true;
            } catch (UnsupportedEncodingException unused) {
                Log.w(LOG_TAG, "wrong encoding when sending " + command + " to " + this.mPort);
                return false;
            }
        } catch (Exception unused2) {
            Log.d(LOG_TAG, "Exception sending command " + command + " to " + this.mPort);
            return false;
        }
    }

    private String processCommand(String command) throws InterruptedException, IOException {
        if (sendCommand(command)) {
            String[] lines = readLines();
            if (lines != null && lines.length > 0) {
                Matcher matcher = RE_KO.matcher(lines[lines.length - 1]);
                if (matcher.matches()) {
                    return matcher.group(1);
                }
                return RESULT_OK;
            }
            return "Unable to communicate with the emulator";
        }
        return "Unable to send command to the emulator";
    }

    private String[] readLines() throws InterruptedException, IOException {
        try {
            byte[] bArr = this.mBuffer;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, bArr.length);
            boolean z = false;
            int i = 0;
            while (byteBufferWrap.position() != byteBufferWrap.limit() && !z) {
                int i2 = this.mSocketChannel.read(byteBufferWrap);
                if (i2 < 0) {
                    return null;
                }
                if (i2 != 0) {
                    i = 0;
                } else {
                    if (i * 5 > 5000) {
                        return null;
                    }
                    try {
                        Thread.sleep(5L);
                    } catch (InterruptedException unused) {
                    }
                    i++;
                }
                if (byteBufferWrap.position() >= 4) {
                    int iPosition = byteBufferWrap.position();
                    if (endsWithOK(iPosition) || lastLineIsKO(iPosition)) {
                        z = true;
                    }
                }
            }
            return new String(this.mBuffer, 0, byteBufferWrap.position(), DEFAULT_ENCODING).split("\r\n");
        } catch (IOException unused2) {
            Log.d(LOG_TAG, "Exception reading lines for " + this.mPort);
            return null;
        }
    }

    private boolean endsWithOK(int currentPosition) {
        byte[] bArr = this.mBuffer;
        return bArr[currentPosition + (-1)] == 10 && bArr[currentPosition + (-2)] == 13 && bArr[currentPosition + (-3)] == 75 && bArr[currentPosition + (-4)] == 79;
    }

    private boolean lastLineIsKO(int currentPosition) {
        byte[] bArr = this.mBuffer;
        if (bArr[currentPosition - 1] == 10 && bArr[currentPosition - 2] == 13) {
            int i = currentPosition - 3;
            while (i >= 0) {
                byte[] bArr2 = this.mBuffer;
                if (bArr2[i] == 10 && i > 0 && bArr2[i - 1] == 13) {
                    break;
                }
                i--;
            }
            byte[] bArr3 = this.mBuffer;
            if (bArr3[i + 1] == 75 && bArr3[i + 2] == 79) {
                return true;
            }
        }
        return false;
    }
}
