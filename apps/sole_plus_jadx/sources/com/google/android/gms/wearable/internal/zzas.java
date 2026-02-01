package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzas extends AbstractSafeParcelable implements CapabilityInfo {
    public static final Parcelable.Creator<zzas> CREATOR = new zzat();
    private final String zzb;
    private final List zzc;
    private final Object zza = new Object();
    private Set zzd = null;

    public zzas(String str, List list) {
        this.zzb = str;
        this.zzc = list;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzas zzasVar = (zzas) obj;
        String str = this.zzb;
        if (str == null ? zzasVar.zzb != null : !str.equals(zzasVar.zzb)) {
            return false;
        }
        List list = this.zzc;
        return list == null ? zzasVar.zzc == null : list.equals(zzasVar.zzc);
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final String getName() {
        return this.zzb;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final Set<Node> getNodes() {
        Set<Node> set;
        synchronized (this.zza) {
            if (this.zzd == null) {
                this.zzd = new HashSet(this.zzc);
            }
            set = this.zzd;
        }
        return set;
    }

    public final int hashCode() {
        String str = this.zzb;
        int iHashCode = str != null ? str.hashCode() : 0;
        List list = this.zzc;
        return ((iHashCode + 31) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "CapabilityInfo{" + this.zzb + ", " + String.valueOf(this.zzc) + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
