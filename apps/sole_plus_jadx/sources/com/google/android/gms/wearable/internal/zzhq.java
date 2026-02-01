package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzhq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhq> CREATOR = new zzhr();
    final int zza;
    public final zzfs zzb;

    zzhq(int i, IBinder iBinder) {
        this.zza = i;
        if (iBinder == null) {
            this.zzb = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            this.zzb = iInterfaceQueryLocalInterface instanceof zzfs ? (zzfs) iInterfaceQueryLocalInterface : new zzfq(iBinder);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        zzfs zzfsVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzfsVar == null ? null : zzfsVar.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzhq(zzfs zzfsVar) {
        this.zza = 1;
        this.zzb = zzfsVar;
    }
}
