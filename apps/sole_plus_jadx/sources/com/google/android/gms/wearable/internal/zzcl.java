package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzcl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcl> CREATOR = new zzcm();
    public final int zza;
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final boolean zze;
    public final List zzf;

    public zzcl(int i, boolean z, boolean z2, boolean z3, boolean z4, List list) {
        this.zza = i;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcl)) {
            return false;
        }
        zzcl zzclVar = (zzcl) obj;
        if (this.zza == zzclVar.zza && this.zzb == zzclVar.zzb && this.zzc == zzclVar.zzc && this.zzd == zzclVar.zzd && this.zze == zzclVar.zze) {
            List list = zzclVar.zzf;
            List list2 = this.zzf;
            if (list2 == null || list == null ? list2 == list : !(!list2.containsAll(list) || this.zzf.size() != list.size())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf);
    }

    public final String toString() {
        return "ConsentResponse {statusCode =" + this.zza + ", hasTosConsent =" + this.zzb + ", hasLoggingConsent =" + this.zzc + ", hasCloudSyncConsent =" + this.zzd + ", hasLocationConsent =" + this.zze + ", accountConsentRecords =" + String.valueOf(this.zzf) + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
