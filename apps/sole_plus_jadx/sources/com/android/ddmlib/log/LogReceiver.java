package com.android.ddmlib.log;

import com.android.ddmlib.utils.ArrayHelper;
import java.security.InvalidParameterException;

/* loaded from: classes3.dex */
public final class LogReceiver {
    private static final int ENTRY_HEADER_SIZE = 20;
    private LogEntry mCurrentEntry;
    private ILogListener mListener;
    private byte[] mEntryHeaderBuffer = new byte[20];
    private int mEntryHeaderOffset = 0;
    private int mEntryDataOffset = 0;
    private boolean mIsCancelled = false;

    public interface ILogListener {
        void newData(byte[] data, int offset, int length);

        void newEntry(LogEntry entry);
    }

    public static final class LogEntry {
        public byte[] data;
        public int len;
        public int nsec;
        public int pid;
        public int sec;
        public int tid;
    }

    public LogReceiver(ILogListener listener) {
        this.mListener = listener;
    }

    public void parseNewData(byte[] data, int offset, int length) {
        ILogListener iLogListener = this.mListener;
        if (iLogListener != null) {
            iLogListener.newData(data, offset, length);
        }
        while (length > 0 && !this.mIsCancelled) {
            if (this.mCurrentEntry == null) {
                int i = this.mEntryHeaderOffset;
                if (i + length < 20) {
                    System.arraycopy(data, offset, this.mEntryHeaderBuffer, i, length);
                    this.mEntryHeaderOffset += length;
                    return;
                } else if (i != 0) {
                    int i2 = 20 - i;
                    System.arraycopy(data, offset, this.mEntryHeaderBuffer, i, i2);
                    this.mCurrentEntry = createEntry(this.mEntryHeaderBuffer, 0);
                    this.mEntryHeaderOffset = 0;
                    offset += i2;
                    length -= i2;
                } else {
                    this.mCurrentEntry = createEntry(data, offset);
                    offset += 20;
                    length -= 20;
                }
            }
            if (length >= this.mCurrentEntry.len - this.mEntryDataOffset) {
                int i3 = this.mCurrentEntry.len - this.mEntryDataOffset;
                System.arraycopy(data, offset, this.mCurrentEntry.data, this.mEntryDataOffset, i3);
                ILogListener iLogListener2 = this.mListener;
                if (iLogListener2 != null) {
                    iLogListener2.newEntry(this.mCurrentEntry);
                }
                this.mEntryDataOffset = 0;
                this.mCurrentEntry = null;
                offset += i3;
                length -= i3;
            } else {
                System.arraycopy(data, offset, this.mCurrentEntry.data, this.mEntryDataOffset, length);
                this.mEntryDataOffset += length;
                return;
            }
        }
    }

    public boolean isCancelled() {
        return this.mIsCancelled;
    }

    public void cancel() {
        this.mIsCancelled = true;
    }

    private LogEntry createEntry(byte[] data, int offset) {
        if (data.length < offset + 20) {
            throw new InvalidParameterException("Buffer not big enough to hold full LoggerEntry header");
        }
        LogEntry logEntry = new LogEntry();
        logEntry.len = ArrayHelper.swapU16bitFromArray(data, offset);
        logEntry.pid = ArrayHelper.swap32bitFromArray(data, offset + 4);
        logEntry.tid = ArrayHelper.swap32bitFromArray(data, offset + 8);
        logEntry.sec = ArrayHelper.swap32bitFromArray(data, offset + 12);
        logEntry.nsec = ArrayHelper.swap32bitFromArray(data, offset + 16);
        logEntry.data = new byte[logEntry.len];
        return logEntry;
    }
}
