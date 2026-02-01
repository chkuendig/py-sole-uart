package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new zzv();
    public final boolean zza;
    public final List zzb;

    public zzu(boolean z, List list) {
        this.zza = z;
        this.zzb = list;
    }

    public final boolean equals(Object obj) {
        List list;
        List list2;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzu zzuVar = (zzu) obj;
            if (this.zza == zzuVar.zza && ((list = this.zzb) == (list2 = zzuVar.zzb) || (list != null && list.equals(list2)))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        return "AppWearDetailsParcelable{isWatchface=" + this.zza + ", watchfaceCategories=" + String.valueOf(this.zzb) + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
