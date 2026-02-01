package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
/* loaded from: classes2.dex */
public final class zzo implements Parcelable.Creator<StreetViewPanoramaLink> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ StreetViewPanoramaLink createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        float f = 0.0f;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 2) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                f = SafeParcelReader.readFloat(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new StreetViewPanoramaLink(strCreateString, f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaLink[] newArray(int i) {
        return new StreetViewPanoramaLink[i];
    }
}
