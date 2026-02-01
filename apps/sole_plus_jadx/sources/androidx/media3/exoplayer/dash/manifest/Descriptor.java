package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.Util;

/* loaded from: classes3.dex */
public final class Descriptor {

    /* renamed from: id, reason: collision with root package name */
    public final String f118id;
    public final String schemeIdUri;
    public final String value;

    public Descriptor(String str, String str2, String str3) {
        this.schemeIdUri = str;
        this.value = str2;
        this.f118id = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Descriptor descriptor = (Descriptor) obj;
        return Util.areEqual(this.schemeIdUri, descriptor.schemeIdUri) && Util.areEqual(this.value, descriptor.value) && Util.areEqual(this.f118id, descriptor.f118id);
    }

    public int hashCode() {
        int iHashCode = this.schemeIdUri.hashCode() * 31;
        String str = this.value;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f118id;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
