package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();
    private final List zza;
    private final List zzb;
    private final List zzc;

    public zzf(List list, List list2, List list3) {
        this.zza = list;
        this.zzb = list2;
        this.zzc = list3;
    }

    public final String toString() {
        com.google.android.gms.internal.wearable.zzad zzadVarZza = com.google.android.gms.internal.wearable.zzae.zza(this);
        zzadVarZza.zzb("allowedDataItemFilters", this.zza);
        zzadVarZza.zzb("allowedCapabilities", this.zzb);
        zzadVarZza.zzb("allowedPackages", this.zzc);
        return zzadVarZza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
