package com.ua.sdk.gear.brand;

import android.os.Parcelable;
import com.ua.sdk.Entity;

/* loaded from: classes2.dex */
public interface GearBrand extends Entity, Parcelable {
    String getBrandName();

    String getGearTypeId();

    Boolean isPopular();
}
