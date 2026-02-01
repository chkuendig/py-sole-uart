package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();
    private final String zza;
    private final boolean zzb;

    public zzb(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzb)) {
            return false;
        }
        zzb zzbVar = (zzb) obj;
        return this.zza.equals(zzbVar.zza) && this.zzb == zzbVar.zzb;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Boolean.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeBoolean(parcel, 2, Boolean.valueOf(this.zzb).booleanValue());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
