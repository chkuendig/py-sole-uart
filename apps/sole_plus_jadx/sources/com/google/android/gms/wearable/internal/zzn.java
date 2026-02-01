package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzn extends AbstractSafeParcelable implements com.google.android.gms.wearable.zzb {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();
    private final int zza;
    private final String zzb;

    @Nullable
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    @Nullable
    private final String zzg;
    private final byte zzh;
    private final byte zzi;
    private final byte zzj;
    private final byte zzk;

    @Nullable
    private final String zzl;

    public zzn(int i, String str, @Nullable String str2, String str3, String str4, String str5, @Nullable String str6, byte b, byte b2, byte b3, byte b4, @Nullable String str7) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
        this.zzh = b;
        this.zzi = b2;
        this.zzj = b3;
        this.zzk = b4;
        this.zzl = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzn zznVar = (zzn) obj;
        if (this.zza != zznVar.zza || this.zzh != zznVar.zzh || this.zzi != zznVar.zzi || this.zzj != zznVar.zzj || this.zzk != zznVar.zzk || !this.zzb.equals(zznVar.zzb)) {
            return false;
        }
        String str = this.zzc;
        if (str == null ? zznVar.zzc != null : !str.equals(zznVar.zzc)) {
            return false;
        }
        if (!this.zzd.equals(zznVar.zzd) || !this.zze.equals(zznVar.zze) || !this.zzf.equals(zznVar.zzf)) {
            return false;
        }
        String str2 = this.zzg;
        if (str2 == null ? zznVar.zzg != null : !str2.equals(zznVar.zzg)) {
            return false;
        }
        String str3 = this.zzl;
        return str3 != null ? str3.equals(zznVar.zzl) : zznVar.zzl == null;
    }

    public final int hashCode() {
        int iHashCode = ((this.zza + 31) * 31) + this.zzb.hashCode();
        String str = this.zzc;
        int iHashCode2 = ((((((((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.zzd.hashCode()) * 31) + this.zze.hashCode()) * 31) + this.zzf.hashCode()) * 31;
        String str2 = this.zzg;
        int iHashCode3 = (((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.zzh) * 31) + this.zzi) * 31) + this.zzj) * 31) + this.zzk) * 31;
        String str3 = this.zzl;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        int i = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        byte b = this.zzh;
        byte b2 = this.zzi;
        byte b3 = this.zzj;
        byte b4 = this.zzk;
        return "AncsNotificationParcelable{, id=" + i + ", appId='" + str + "', dateTime='" + str2 + "', eventId=" + ((int) b) + ", eventFlags=" + ((int) b2) + ", categoryId=" + ((int) b3) + ", categoryCount=" + ((int) b4) + ", packageName='" + this.zzl + "'}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        String str = this.zzg;
        if (str == null) {
            str = this.zzb;
        }
        SafeParcelWriter.writeString(parcel, 8, str, false);
        SafeParcelWriter.writeByte(parcel, 9, this.zzh);
        SafeParcelWriter.writeByte(parcel, 10, this.zzi);
        SafeParcelWriter.writeByte(parcel, 11, this.zzj);
        SafeParcelWriter.writeByte(parcel, 12, this.zzk);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
