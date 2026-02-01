package com.google.android.gms.dynamite;

import com.android.SdkConstants;
import dalvik.system.PathClassLoader;

/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* loaded from: classes4.dex */
final class zzd extends PathClassLoader {
    zzd(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    @Override // java.lang.ClassLoader
    protected final Class loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith(SdkConstants.ANDROID_PKG_PREFIX)) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.loadClass(str, z);
    }
}
