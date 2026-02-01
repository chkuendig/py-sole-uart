package com.samsung.android.sdk.healthdata;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.internal.healthdata.ErrorUtil;
import com.samsung.android.sdk.internal.healthdata.HealthResultReceiver;
import com.samsung.android.sdk.internal.healthdata.IpcUtil;
import com.samsung.android.sdk.internal.healthdata.RemoteConnectionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class HealthPermissionManager {
    private final HealthDataStore a;

    public static class PermissionKey {
        private final String a;
        private final PermissionType b;

        public PermissionKey(String str, PermissionType permissionType) {
            this.a = str;
            this.b = permissionType;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj == null || !(obj instanceof PermissionKey)) {
                return false;
            }
            PermissionKey permissionKey = (PermissionKey) obj;
            String str2 = this.a;
            return str2 != null && (str = permissionKey.a) != null && str2.equals(str) && this.b.getValue() == permissionKey.b.getValue();
        }

        public String getDataType() {
            return this.a;
        }

        public PermissionType getPermissionType() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            if (str == null) {
                return 0;
            }
            return (str.hashCode() / 31) + this.b.getValue();
        }
    }

    public static class PermissionResult extends HealthResultHolder.BaseResult implements Parcelable {
        public static final Parcelable.Creator<PermissionResult> CREATOR = new a();
        private final Bundle d;

        static class a implements Parcelable.Creator<PermissionResult> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public PermissionResult createFromParcel(Parcel parcel) {
                return new PermissionResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public PermissionResult[] newArray(int i) {
                return new PermissionResult[i];
            }
        }

        @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Map<PermissionKey, Boolean> getResultMap() {
            return HealthPermissionManager.b(this.d);
        }

        @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.d);
        }

        public PermissionResult(Bundle bundle, int i) {
            super(1, i);
            this.d = bundle;
        }

        private PermissionResult(Parcel parcel) {
            super(parcel);
            this.d = parcel.readBundle();
        }
    }

    public enum PermissionType {
        READ(0),
        WRITE(1);

        private final int a;

        PermissionType(int i) {
            this.a = i;
        }

        public static PermissionType getType(int i) {
            PermissionType permissionType = READ;
            if (i == permissionType.getValue()) {
                return permissionType;
            }
            PermissionType permissionType2 = WRITE;
            if (i == permissionType2.getValue()) {
                return permissionType2;
            }
            throw new IllegalArgumentException("Unknown input value");
        }

        public int getValue() {
            return this.a;
        }
    }

    public HealthPermissionManager(HealthDataStore healthDataStore) {
        this.a = healthDataStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<PermissionKey, Boolean> b(Bundle bundle) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            int[] intArray = bundle.getIntArray(str);
            if (intArray != null) {
                for (PermissionType permissionType : PermissionType.values()) {
                    int i = intArray[permissionType.getValue()];
                    if (i == 0) {
                        map.put(new PermissionKey(str, permissionType), Boolean.FALSE);
                    } else if (i == 1) {
                        map.put(new PermissionKey(str, permissionType), Boolean.TRUE);
                    }
                }
            }
        }
        return map;
    }

    public Map<PermissionKey, Boolean> isPermissionAcquired(Set<PermissionKey> set) {
        if (set == null) {
            throw new IllegalArgumentException("The input argument is null");
        }
        if (set.isEmpty()) {
            throw new IllegalArgumentException("The input argument has no items");
        }
        IHealth iHealth = HealthDataStore.getInterface(this.a);
        Bundle bundleA = a(set);
        try {
            Log.d("Health.Permission", "Checking the health data permissions are acquired...");
            Bundle bundleIsHealthDataPermissionAcquired2 = iHealth.isHealthDataPermissionAcquired2(this.a.a().getPackageName(), bundleA);
            if (bundleIsHealthDataPermissionAcquired2 != null) {
                return b(bundleIsHealthDataPermissionAcquired2);
            }
            throw new IllegalStateException("Binder error occurs during getting the result");
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public HealthResultHolder<PermissionResult> requestPermissions(Set<PermissionKey> set) {
        return requestPermissions(set, null);
    }

    private static Bundle a(Set<PermissionKey> set) {
        HashMap map = new HashMap();
        for (PermissionKey permissionKey : set) {
            String dataType = permissionKey.getDataType();
            if (dataType == null) {
                throw new IllegalArgumentException("The input argument includes null as a dataType of PermissionKey");
            }
            ArrayList arrayList = (ArrayList) map.get(dataType);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(dataType, arrayList);
            }
            arrayList.add(Integer.valueOf(permissionKey.getPermissionType().getValue()));
        }
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            ArrayList arrayList2 = (ArrayList) entry.getValue();
            int[] iArr = new int[arrayList2.size()];
            Iterator it = arrayList2.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = ((Integer) it.next()).intValue();
                i++;
            }
            bundle.putIntArray((String) entry.getKey(), iArr);
        }
        return bundle;
    }

    public HealthResultHolder<PermissionResult> requestPermissions(Set<PermissionKey> set, Activity activity) {
        if (set == null) {
            throw new IllegalArgumentException("The input argument is null");
        }
        if (set.isEmpty()) {
            throw new IllegalArgumentException("The input argument has no items");
        }
        IHealth iHealth = HealthDataStore.getInterface(this.a);
        Bundle bundleA = a(set);
        Log.d("Health.Permission", "Trying to acquire the health data permissions...");
        try {
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
            HealthResultHolder<PermissionResult> healthResultHolderMakeResultHolder = IpcUtil.makeResultHolder(forwardAsync, Looper.myLooper());
            Intent intentRequestHealthDataPermissions2 = iHealth.requestHealthDataPermissions2(this.a.a().getPackageName(), forwardAsync, bundleA);
            if (intentRequestHealthDataPermissions2 != null) {
                if (activity != null) {
                    try {
                        activity.startActivity(intentRequestHealthDataPermissions2);
                    } catch (ActivityNotFoundException e) {
                        throw e;
                    } catch (Exception unused) {
                        throw new IllegalArgumentException("Invalid instance of Activity");
                    }
                } else {
                    Context contextA = this.a.a();
                    if (!(contextA instanceof Activity)) {
                        intentRequestHealthDataPermissions2.addFlags(268435456);
                    }
                    contextA.startActivity(intentRequestHealthDataPermissions2);
                }
            }
            return healthResultHolderMakeResultHolder;
        } catch (RemoteException e2) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e2));
        }
    }
}
