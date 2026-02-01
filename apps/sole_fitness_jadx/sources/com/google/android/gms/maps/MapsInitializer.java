package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.zzca;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
/* loaded from: classes2.dex */
public final class MapsInitializer {
    private static final String zza = "MapsInitializer";
    private static boolean zzb = false;
    private static Renderer zzc = Renderer.LEGACY;

    /* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
    public enum Renderer {
        LEGACY,
        LATEST
    }

    private MapsInitializer() {
    }

    public static synchronized int initialize(Context context) {
        return initialize(context, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a A[Catch: RemoteException -> 0x0066, all -> 0x009f, TryCatch #2 {RemoteException -> 0x0066, blocks: (B:21:0x0054, B:23:0x005a, B:24:0x005e), top: B:47:0x0054, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008c A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #3 {, blocks: (B:4:0x0003, B:7:0x0029, B:10:0x0030, B:11:0x0034, B:13:0x0043, B:15:0x0048, B:21:0x0054, B:23:0x005a, B:24:0x005e, B:28:0x006e, B:30:0x008c, B:27:0x0067, B:34:0x0094, B:35:0x0099, B:37:0x009b), top: B:49:0x0003, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized int initialize(Context context, Renderer renderer, OnMapsSdkInitializedCallback onMapsSdkInitializedCallback) {
        Preconditions.checkNotNull(context, "Context is null");
        String str = zza;
        String strValueOf = String.valueOf(renderer);
        String.valueOf(strValueOf).length();
        Log.d(str, "preferredRenderer: ".concat(String.valueOf(strValueOf)));
        if (zzb) {
            if (onMapsSdkInitializedCallback != null) {
                onMapsSdkInitializedCallback.onMapsSdkInitialized(zzc);
            }
            return 0;
        }
        try {
            com.google.android.gms.maps.internal.zzf zzfVarZza = zzca.zza(context, renderer);
            try {
                CameraUpdateFactory.zza(zzfVarZza.zze());
                BitmapDescriptorFactory.zza(zzfVarZza.zzj());
                int i = 1;
                zzb = true;
                if (renderer != null) {
                    int iOrdinal = renderer.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal == 1) {
                            i = 2;
                        }
                    }
                    if (zzfVarZza.zzd() == 2) {
                    }
                    zzfVarZza.zzl(ObjectWrapper.wrap(context), i);
                    String str2 = zza;
                    String strValueOf2 = String.valueOf(zzc);
                    String.valueOf(strValueOf2).length();
                    Log.d(str2, "loadedRenderer: ".concat(String.valueOf(strValueOf2)));
                    if (onMapsSdkInitializedCallback != null) {
                    }
                    return 0;
                }
                i = 0;
                try {
                    if (zzfVarZza.zzd() == 2) {
                        zzc = Renderer.LATEST;
                    }
                    zzfVarZza.zzl(ObjectWrapper.wrap(context), i);
                } catch (RemoteException e) {
                    Log.e(zza, "Failed to retrieve renderer type or log initialization.", e);
                }
                String str22 = zza;
                String strValueOf22 = String.valueOf(zzc);
                String.valueOf(strValueOf22).length();
                Log.d(str22, "loadedRenderer: ".concat(String.valueOf(strValueOf22)));
                if (onMapsSdkInitializedCallback != null) {
                    onMapsSdkInitializedCallback.onMapsSdkInitialized(zzc);
                }
                return 0;
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        } catch (GooglePlayServicesNotAvailableException e3) {
            return e3.errorCode;
        }
    }
}
