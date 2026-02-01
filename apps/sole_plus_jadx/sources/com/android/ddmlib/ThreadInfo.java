package com.android.ddmlib;

/* loaded from: classes3.dex */
public final class ThreadInfo implements IStackTraceInfo {
    private boolean mIsDaemon;
    private int mStatus = -1;
    private int mStime;
    private int mThreadId;
    private String mThreadName;
    private int mTid;
    private StackTraceElement[] mTrace;
    private long mTraceTime;
    private int mUtime;

    ThreadInfo(int threadId, String threadName) {
        this.mThreadId = threadId;
        this.mThreadName = threadName;
    }

    public void updateThread(int status, int tid, int utime, int stime, boolean isDaemon) {
        this.mStatus = status;
        this.mTid = tid;
        this.mUtime = utime;
        this.mStime = stime;
        this.mIsDaemon = isDaemon;
    }

    public void setStackCall(StackTraceElement[] trace) {
        this.mTrace = trace;
        this.mTraceTime = System.currentTimeMillis();
    }

    public int getThreadId() {
        return this.mThreadId;
    }

    public String getThreadName() {
        return this.mThreadName;
    }

    public void setThreadName(String name) {
        this.mThreadName = name;
    }

    public int getTid() {
        return this.mTid;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getUtime() {
        return this.mUtime;
    }

    public int getStime() {
        return this.mStime;
    }

    public boolean isDaemon() {
        return this.mIsDaemon;
    }

    @Override // com.android.ddmlib.IStackTraceInfo
    public StackTraceElement[] getStackTrace() {
        return this.mTrace;
    }

    public long getStackCallTime() {
        return this.mTraceTime;
    }
}
