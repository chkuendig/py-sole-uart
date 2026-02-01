package com.ua.sdk.datasourceidentifier;

import android.os.Parcelable;
import com.ua.sdk.device.Device;

/* loaded from: classes2.dex */
public interface DataSourceIdentifierBuilder extends Parcelable {
    DataSourceIdentifier build();

    DataSourceIdentifierBuilder setDevice(Device device);

    DataSourceIdentifierBuilder setName(String str);
}
