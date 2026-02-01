package com.android.ddmlib.logcat;

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.Log;
import com.android.ddmlib.MultiLineReceiver;
import com.android.ddmlib.ShellCommandUnresponsiveException;
import com.android.ddmlib.TimeoutException;
import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class LogCatReceiverTask implements Runnable {
    private static final int DEVICE_POLL_INTERVAL_MSEC = 1000;
    private static final String LOGCAT_COMMAND = "logcat -v long";
    private final IDevice mDevice;
    private static final LogCatMessage sDeviceDisconnectedMsg = newLogCatMessage("Device disconnected: 1");
    private static final LogCatMessage sConnectionTimeoutMsg = newLogCatMessage("LogCat Connection timed out");
    private static final LogCatMessage sConnectionErrorMsg = newLogCatMessage("LogCat Connection error");
    private final Set<LogCatListener> mListeners = new HashSet();
    private final LogCatOutputReceiver mReceiver = new LogCatOutputReceiver();
    private final LogCatMessageParser mParser = new LogCatMessageParser();
    private final AtomicBoolean mCancelled = new AtomicBoolean();

    public LogCatReceiverTask(IDevice device) {
        this.mDevice = device;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.mDevice.isOnline()) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused) {
                return;
            }
        }
        try {
            this.mDevice.executeShellCommand(LOGCAT_COMMAND, this.mReceiver, 0);
        } catch (AdbCommandRejectedException | ShellCommandUnresponsiveException unused2) {
        } catch (TimeoutException unused3) {
            notifyListeners(Collections.singletonList(sConnectionTimeoutMsg));
        } catch (IOException unused4) {
            notifyListeners(Collections.singletonList(sConnectionErrorMsg));
        }
        notifyListeners(Collections.singletonList(sDeviceDisconnectedMsg));
    }

    public void stop() {
        this.mCancelled.set(true);
    }

    private class LogCatOutputReceiver extends MultiLineReceiver {
        public LogCatOutputReceiver() {
            setTrimLine(false);
        }

        @Override // com.android.ddmlib.IShellOutputReceiver
        public boolean isCancelled() {
            return LogCatReceiverTask.this.mCancelled.get();
        }

        @Override // com.android.ddmlib.MultiLineReceiver
        public void processNewLines(String[] lines) {
            if (LogCatReceiverTask.this.mCancelled.get()) {
                return;
            }
            processLogLines(lines);
        }

        private void processLogLines(String[] lines) {
            List<LogCatMessage> listProcessLogLines = LogCatReceiverTask.this.mParser.processLogLines(lines, LogCatReceiverTask.this.mDevice);
            if (listProcessLogLines.isEmpty()) {
                return;
            }
            LogCatReceiverTask.this.notifyListeners(listProcessLogLines);
        }
    }

    public synchronized void addLogCatListener(LogCatListener l) {
        this.mListeners.add(l);
    }

    public synchronized void removeLogCatListener(LogCatListener l) {
        this.mListeners.remove(l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyListeners(List<LogCatMessage> messages) {
        Iterator<LogCatListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().log(messages);
        }
    }

    private static LogCatMessage newLogCatMessage(String message) {
        return new LogCatMessage(new LogCatHeader(Log.LogLevel.ERROR, -1, -1, "", "", Instant.EPOCH), message);
    }
}
