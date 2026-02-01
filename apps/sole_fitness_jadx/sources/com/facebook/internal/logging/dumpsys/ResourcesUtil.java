package com.facebook.internal.logging.dumpsys;

import android.content.res.Resources;
import com.facebook.internal.security.CertificateUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourcesUtil.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¨\u0006\r"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/ResourcesUtil;", "", "()V", "getFallbackIdString", "", "resourceId", "", "getIdString", "r", "Landroid/content/res/Resources;", "getIdStringQuietly", "getResourcePackageId", "id", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ResourcesUtil {
    public static final ResourcesUtil INSTANCE = new ResourcesUtil();

    private final int getResourcePackageId(int id) {
        return (id >>> 24) & 255;
    }

    private ResourcesUtil() {
    }

    @JvmStatic
    public static final String getIdStringQuietly(Resources r, int resourceId) {
        try {
            return getIdString(r, resourceId);
        } catch (Resources.NotFoundException unused) {
            return INSTANCE.getFallbackIdString(resourceId);
        }
    }

    @JvmStatic
    public static final String getIdString(Resources r, int resourceId) throws Resources.NotFoundException {
        String str;
        if (r == null) {
            return INSTANCE.getFallbackIdString(resourceId);
        }
        String resourcePackageName = "";
        if (INSTANCE.getResourcePackageId(resourceId) != 127) {
            resourcePackageName = r.getResourcePackageName(resourceId);
            Intrinsics.checkNotNullExpressionValue(resourcePackageName, "r.getResourcePackageName(resourceId)");
            str = CertificateUtil.DELIMITER;
        } else {
            str = "";
        }
        String resourceTypeName = r.getResourceTypeName(resourceId);
        String resourceEntryName = r.getResourceEntryName(resourceId);
        StringBuilder sb = new StringBuilder(resourcePackageName.length() + 1 + str.length() + resourceTypeName.length() + 1 + resourceEntryName.length());
        sb.append("@");
        sb.append(resourcePackageName);
        sb.append(str);
        sb.append(resourceTypeName);
        sb.append("/");
        sb.append(resourceEntryName);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    private final String getFallbackIdString(int resourceId) {
        return "#" + Integer.toHexString(resourceId);
    }
}
