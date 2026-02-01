package com.android.ddmlib.internal.jdwp;

import com.google.common.base.Objects;

/* loaded from: classes3.dex */
class JdwpClientManagerId {
    String deviceSerial;
    int pid;

    JdwpClientManagerId(String deviceSerial, int pid) {
        this.deviceSerial = deviceSerial;
        this.pid = pid;
    }

    public int hashCode() {
        return Objects.hashCode(this.deviceSerial, Integer.valueOf(this.pid));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JdwpClientManagerId)) {
            return false;
        }
        JdwpClientManagerId jdwpClientManagerId = (JdwpClientManagerId) obj;
        return this.deviceSerial.equals(jdwpClientManagerId.deviceSerial) && this.pid == jdwpClientManagerId.pid;
    }
}
