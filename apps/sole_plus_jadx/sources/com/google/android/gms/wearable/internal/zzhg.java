package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.Node;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzhg extends AbstractSafeParcelable implements Node {
    public static final Parcelable.Creator<zzhg> CREATOR = new zzhh();
    private final String zza;
    private final String zzb;
    private final int zzc;
    private final boolean zzd;

    public zzhg(String str, String str2, int i, boolean z) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = z;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzhg) {
            return ((zzhg) obj).zza.equals(this.zza);
        }
        return false;
    }

    @Override // com.google.android.gms.wearable.Node
    public final String getDisplayName() {
        return this.zzb;
    }

    @Override // com.google.android.gms.wearable.Node
    public final String getId() {
        return this.zza;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.wearable.Node
    public final boolean isNearby() {
        return this.zzd;
    }

    public final String toString() {
        return "Node{" + this.zzb + ", id=" + this.zza + ", hops=" + this.zzc + ", isNearby=" + this.zzd + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
