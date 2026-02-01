package com.android.ddmlib;

/* loaded from: classes3.dex */
public class InstallMetrics {
    private final long installFinishNs;
    private final long installStartNs;
    private final long uploadFinishNs;
    private final long uploadStartNs;

    public InstallMetrics(long uploadStartNs, long uploadFinishNs, long installStartNs, long installFinishNs) {
        this.uploadStartNs = uploadStartNs;
        this.uploadFinishNs = uploadFinishNs;
        this.installStartNs = installStartNs;
        this.installFinishNs = installFinishNs;
    }

    public long getUploadStartNs() {
        return this.uploadStartNs;
    }

    public long getUploadFinishNs() {
        return this.uploadFinishNs;
    }

    public long getInstallStartNs() {
        return this.installStartNs;
    }

    public long getInstallFinishNs() {
        return this.installFinishNs;
    }
}
