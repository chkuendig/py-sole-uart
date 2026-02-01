package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzjs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjs> CREATOR = new zzfu();
    public final String zza;
    public final int zzb;
    public final int zzc;

    public zzjs(String str, int i, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzjs zzjsVar = (zzjs) obj;
            if (this.zzb == zzjsVar.zzb && this.zzc == zzjsVar.zzc && ((str = this.zza) == (str2 = zzjsVar.zza) || (str != null && str.equals(str2)))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }

    public final String toString() {
        return String.format(Locale.US, "WebIconParcelable{%dx%d - %s}", Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
