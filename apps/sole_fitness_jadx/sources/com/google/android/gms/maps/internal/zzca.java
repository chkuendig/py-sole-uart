package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
/* loaded from: classes2.dex */
public final class zzca {
    private static final String zza = "zzca";
    private static Context zzb;
    private static zzf zzc;

    public static zzf zza(Context context, MapsInitializer.Renderer renderer) throws GooglePlayServicesNotAvailableException {
        zzf zzeVar;
        Preconditions.checkNotNull(context);
        String str = zza;
        String strValueOf = String.valueOf(renderer);
        String.valueOf(strValueOf).length();
        Log.d(str, "preferredRenderer: ".concat(String.valueOf(strValueOf)));
        zzf zzfVar = zzc;
        if (zzfVar != null) {
            return zzfVar;
        }
        int iIsGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context, 13400000);
        if (iIsGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(iIsGooglePlayServicesAvailable);
        }
        Log.i(str, "Making Creator dynamically");
        try {
            IBinder iBinder = (IBinder) zzd(((ClassLoader) Preconditions.checkNotNull(zzc(context, renderer).getClassLoader())).loadClass("com.google.android.gms.maps.internal.CreatorImpl"));
            if (iBinder == null) {
                zzeVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                zzeVar = iInterfaceQueryLocalInterface instanceof zzf ? (zzf) iInterfaceQueryLocalInterface : new zze(iBinder);
            }
            zzc = zzeVar;
            try {
                Context contextZzc = zzc(context, renderer);
                contextZzc.getClass();
                zzeVar.zzk(ObjectWrapper.wrap(contextZzc.getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                return zzc;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl");
        }
    }

    private static Context zzb(Exception exc, Context context) {
        Log.e(zza, "Failed to load maps module, use pre-Chimera", exc);
        return GooglePlayServicesUtil.getRemoteContext(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Context zzc(Context context, MapsInitializer.Renderer renderer) {
        String str;
        Context contextZzb;
        Context context2 = zzb;
        if (context2 != null) {
            return context2;
        }
        context.getApplicationContext();
        if (renderer == null) {
            str = "com.google.android.gms.maps_dynamite";
        } else {
            int iOrdinal = renderer.ordinal();
            if (iOrdinal == 0) {
                str = "com.google.android.gms.maps_legacy_dynamite";
            } else if (iOrdinal == 1) {
                str = "com.google.android.gms.maps_core_dynamite";
            }
        }
        try {
            contextZzb = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, str).getModuleContext();
        } catch (Exception e) {
            if (str.equals("com.google.android.gms.maps_dynamite")) {
                contextZzb = zzb(e, context);
            } else {
                try {
                    Log.d(zza, "Attempting to load maps_dynamite again.");
                    contextZzb = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.maps_dynamite").getModuleContext();
                } catch (Exception e2) {
                    contextZzb = zzb(e2, context);
                }
            }
        }
        zzb = contextZzb;
        return contextZzb;
    }

    private static <T> T zzd(Class cls) {
        try {
            return (T) cls.newInstance();
        } catch (IllegalAccessException unused) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(strValueOf.length() != 0 ? "Unable to call the default constructor of ".concat(strValueOf) : new String("Unable to call the default constructor of "));
        } catch (InstantiationException unused2) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new IllegalStateException(strValueOf2.length() != 0 ? "Unable to instantiate the dynamic class ".concat(strValueOf2) : new String("Unable to instantiate the dynamic class "));
        }
    }
}
