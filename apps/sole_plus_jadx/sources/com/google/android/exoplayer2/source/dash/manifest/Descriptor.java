package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;

@Deprecated
/* loaded from: classes4.dex */
public final class Descriptor {

    /* renamed from: id, reason: collision with root package name */
    public final String f172id;
    public final String schemeIdUri;
    public final String value;

    public Descriptor(String str, String str2, String str3) {
        this.schemeIdUri = str;
        this.value = str2;
        this.f172id = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Descriptor descriptor = (Descriptor) obj;
        return Util.areEqual(this.schemeIdUri, descriptor.schemeIdUri) && Util.areEqual(this.value, descriptor.value) && Util.areEqual(this.f172id, descriptor.f172id);
    }

    public int hashCode() {
        int iHashCode = this.schemeIdUri.hashCode() * 31;
        String str = this.value;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f172id;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
