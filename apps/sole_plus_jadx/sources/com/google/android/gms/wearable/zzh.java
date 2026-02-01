package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    private final Uri zza;
    private final int zzb;

    public zzh(Uri uri, int i) {
        this.zza = uri;
        this.zzb = i;
    }

    public final String toString() {
        com.google.android.gms.internal.wearable.zzad zzadVarZza = com.google.android.gms.internal.wearable.zzae.zza(this);
        zzadVarZza.zzb("uri", this.zza);
        zzadVarZza.zza("filterType", this.zzb);
        return zzadVarZza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
