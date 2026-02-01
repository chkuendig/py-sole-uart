package com.samsung.android.sdk.internal.healthdata;

import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.samsung.android.sdk.healthdata.HealthData;
import com.samsung.android.sdk.healthdata.HealthDataStore;
import com.samsung.android.sdk.healthdata.IDataResolver;
import com.samsung.android.sdk.internal.interfaces.ParcelFdSupplier;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class StreamUtil {
    public static byte[] getByteArray(IDataResolver iDataResolver, String str, String str2) throws IOException {
        InputStream inputStream = getInputStream(iDataResolver, str, str2);
        try {
            if (inputStream == null) {
                return null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i <= 0) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            inputStream.close();
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static InputStream getInputStream(IDataResolver iDataResolver, String str, String str2) {
        try {
            return new ParcelFileDescriptor.AutoCloseInputStream(iDataResolver.requestFileDescriptor(HealthDataStore.getClientPackageName(), str, str2));
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void sendStreamIfPresent(ParcelFdSupplier parcelFdSupplier, List<HealthData> list, Handler handler) throws IOException {
        for (HealthData healthData : list) {
            Iterator<String> it = healthData.getBlobKeySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                byte[] blob = healthData.getBlob(next);
                if (blob != null) {
                    byte[] bArr = (byte[]) healthData.get(next);
                    a aVar = new a(new ByteArrayInputStream(blob), bArr != null ? new String(bArr, StandardCharsets.UTF_8) : null, parcelFdSupplier, next);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        handler.post(aVar);
                    } else {
                        aVar.run();
                    }
                }
            }
            for (String str : healthData.getInputStreamKeySet()) {
                byte[] bArr2 = (byte[]) healthData.get(str);
                a aVar2 = new a(healthData.getInputStream(str), bArr2 == null ? null : new String(bArr2, StandardCharsets.UTF_8), parcelFdSupplier, str);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    handler.post(aVar2);
                } else {
                    aVar2.run();
                }
            }
        }
    }
}
