package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public class AppTheme extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AppTheme> CREATOR = new zzc();
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;

    public AppTheme() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppTheme)) {
            return false;
        }
        AppTheme appTheme = (AppTheme) obj;
        return this.zzb == appTheme.zzb && this.zza == appTheme.zza && this.zzc == appTheme.zzc && this.zzd == appTheme.zzd;
    }

    public final int hashCode() {
        return (((((this.zzb * 31) + this.zza) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final String toString() {
        return "AppTheme {dynamicColor =" + this.zzb + ", colorTheme =" + this.zza + ", screenAlignment =" + this.zzc + ", screenItemsSize =" + this.zzd + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        if (i2 == 0) {
            i2 = 1;
        }
        SafeParcelWriter.writeInt(parcel, 1, i2);
        int i3 = this.zzb;
        if (i3 == 0) {
            i3 = 1;
        }
        SafeParcelWriter.writeInt(parcel, 2, i3);
        int i4 = this.zzc;
        SafeParcelWriter.writeInt(parcel, 3, i4 != 0 ? i4 : 1);
        int i5 = this.zzd;
        SafeParcelWriter.writeInt(parcel, 4, i5 != 0 ? i5 : 3);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public AppTheme(int i, int i2, int i3, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
    }
}
