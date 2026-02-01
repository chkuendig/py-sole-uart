package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    public final String zza;
    public final String zzb;
    public final zzjs zzc;
    public final String zzd;
    public final String zze;
    public final Float zzf;
    public final zzu zzg;

    public zzq(String str, String str2, zzjs zzjsVar, String str3, String str4, Float f, zzu zzuVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzjsVar;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = f;
        this.zzg = zzuVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzq zzqVar = (zzq) obj;
            if (zzp.zza(this.zza, zzqVar.zza) && zzp.zza(this.zzb, zzqVar.zzb) && zzp.zza(this.zzc, zzqVar.zzc) && zzp.zza(this.zzd, zzqVar.zzd) && zzp.zza(this.zze, zzqVar.zze) && zzp.zza(this.zzf, zzqVar.zzf) && zzp.zza(this.zzg, zzqVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg});
    }

    public final String toString() {
        return "AppParcelable{title='" + this.zzb + "', developerName='" + this.zzd + "', formattedPrice='" + this.zze + "', starRating=" + this.zzf + ", wearDetails=" + String.valueOf(this.zzg) + ", deepLinkUri='" + this.zza + "', icon=" + String.valueOf(this.zzc) + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeFloatObject(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
