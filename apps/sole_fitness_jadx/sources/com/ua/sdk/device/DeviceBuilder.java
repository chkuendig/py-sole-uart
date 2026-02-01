package com.ua.sdk.device;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface DeviceBuilder extends Parcelable {
    Device build();

    DeviceBuilder setDescription(String str);

    DeviceBuilder setManufacturer(String str);

    DeviceBuilder setModel(String str);

    DeviceBuilder setName(String str);
}
