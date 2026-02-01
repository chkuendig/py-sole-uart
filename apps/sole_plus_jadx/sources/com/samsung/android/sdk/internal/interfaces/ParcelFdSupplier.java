package com.samsung.android.sdk.internal.interfaces;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public interface ParcelFdSupplier {
    ParcelFileDescriptor get(String str, String str2) throws RemoteException;
}
