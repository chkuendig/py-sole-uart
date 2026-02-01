package com.google.android.gms.internal.mlkit_vision_text_common;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public final class zzvc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        Rect rect = null;
        ArrayList arrayListCreateTypedList = null;
        String strCreateString2 = null;
        ArrayList arrayListCreateTypedList2 = null;
        float f = 0.0f;
        float f2 = 0.0f;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 2:
                    rect = (Rect) SafeParcelReader.createParcelable(parcel, header, Rect.CREATOR);
                    break;
                case 3:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, Point.CREATOR);
                    break;
                case 4:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    f = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 6:
                    f2 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 7:
                    arrayListCreateTypedList2 = SafeParcelReader.createTypedList(parcel, header, zzvj.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzvb(strCreateString, rect, arrayListCreateTypedList, strCreateString2, f, f2, arrayListCreateTypedList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzvb[i];
    }
}
