package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzk extends AbstractSafeParcelable implements com.google.android.gms.wearable.zza {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();
    private final byte zza;
    private final byte zzb;
    private final String zzc;

    public zzk(byte b, byte b2, String str) {
        this.zza = b;
        this.zzb = b2;
        this.zzc = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzk zzkVar = (zzk) obj;
        return this.zza == zzkVar.zza && this.zzb == zzkVar.zzb && this.zzc.equals(zzkVar.zzc);
    }

    public final int hashCode() {
        return ((((this.zza + 31) * 31) + this.zzb) * 31) + this.zzc.hashCode();
    }

    public final String toString() {
        byte b = this.zza;
        byte b2 = this.zzb;
        return "AmsEntityUpdateParcelable{, mEntityId=" + ((int) b) + ", mAttributeId=" + ((int) b2) + ", mValue='" + this.zzc + "'}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, this.zza);
        SafeParcelWriter.writeByte(parcel, 3, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
