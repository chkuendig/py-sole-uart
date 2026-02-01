package com.android.ddmlib;

/* loaded from: classes3.dex */
public class ProfileableClientData {
    private String mAbi;
    private final int mPid;
    private String mProcessName;

    public ProfileableClientData(int pid, String processName, String abi) {
        this.mPid = pid;
        this.mProcessName = processName;
        this.mAbi = abi;
    }

    public int getPid() {
        return this.mPid;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public String getAbi() {
        return this.mAbi;
    }

    public void setProcessName(String name) {
        this.mProcessName = name;
    }
}
