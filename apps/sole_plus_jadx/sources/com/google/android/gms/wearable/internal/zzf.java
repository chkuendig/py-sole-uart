package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();
    public final zzfs zza;
    public final IntentFilter[] zzb;

    @Nullable
    public final String zzc;

    @Nullable
    public final String zzd;

    zzf(IBinder iBinder, IntentFilter[] intentFilterArr, @Nullable String str, @Nullable String str2) {
        if (iBinder != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            this.zza = iInterfaceQueryLocalInterface instanceof zzfs ? (zzfs) iInterfaceQueryLocalInterface : new zzfq(iBinder);
        } else {
            this.zza = null;
        }
        this.zzb = intentFilterArr;
        this.zzc = str;
        this.zzd = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzfs zzfsVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 2, zzfsVar == null ? null : zzfsVar.asBinder(), false);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzf(zzjq zzjqVar) {
        this.zza = zzjqVar;
        this.zzb = zzjqVar.zzu();
        this.zzc = zzjqVar.zzs();
        this.zzd = null;
    }
}
