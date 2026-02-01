package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
/* loaded from: classes2.dex */
public class PatternItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PatternItem> CREATOR = new zzj();
    private static final String zza = "PatternItem";
    private final int zzb;
    private final Float zzc;

    public PatternItem(int i, Float f) {
        boolean z = false;
        if (i == 1 || (f != null && f.floatValue() >= 0.0f)) {
            z = true;
        }
        String strValueOf = String.valueOf(f);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 45);
        sb.append("Invalid PatternItem: type=");
        sb.append(i);
        sb.append(" length=");
        sb.append(strValueOf);
        Preconditions.checkArgument(z, sb.toString());
        this.zzb = i;
        this.zzc = f;
    }

    static List<PatternItem> zza(List<PatternItem> list) {
        PatternItem dash;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (PatternItem dot : list) {
            if (dot == null) {
                dot = null;
            } else {
                int i = dot.zzb;
                if (i == 0) {
                    Preconditions.checkState(dot.zzc != null, "length must not be null.");
                    dash = new Dash(dot.zzc.floatValue());
                } else if (i == 1) {
                    dot = new Dot();
                } else if (i != 2) {
                    String str = zza;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Unknown PatternItem type: ");
                    sb.append(i);
                    Log.w(str, sb.toString());
                } else {
                    Preconditions.checkState(dot.zzc != null, "length must not be null.");
                    dash = new Gap(dot.zzc.floatValue());
                }
                dot = dash;
            }
            arrayList.add(dot);
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        return this.zzb == patternItem.zzb && Objects.equal(this.zzc, patternItem.zzc);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc);
    }

    public String toString() {
        int i = this.zzb;
        String strValueOf = String.valueOf(this.zzc);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 39);
        sb.append("[PatternItem: type=");
        sb.append(i);
        sb.append(" length=");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeFloatObject(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
