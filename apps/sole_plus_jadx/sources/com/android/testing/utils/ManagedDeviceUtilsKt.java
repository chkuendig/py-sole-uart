package com.android.testing.utils;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ManagedDeviceUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004\u001a\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004\u001a\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004\u001a\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0004\u001a\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004\u001a\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0002\u0010\u0014\u001a\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"ABI_OFFSET", "", "API_OFFSET", "API_PREFIX", "", "SYSTEM_IMAGE_PREFIX", "VENDOR_OFFSET", "computeSystemImageHashFromDsl", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "imageSource", "abi", "computeVendorString", "computeVersionString", "isWearTvOrAutoDevice", "", "deviceName", "isWearTvOrAutoSource", "parseAbiFromHash", "systemImageHash", "parseApiFromHash", "(Ljava/lang/String;)Ljava/lang/Integer;", "parseVendorFromHash", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ManagedDeviceUtilsKt {
    private static final int ABI_OFFSET = 3;
    private static final int API_OFFSET = 1;
    private static final String API_PREFIX = "android-";
    private static final String SYSTEM_IMAGE_PREFIX = "system-images;";
    private static final int VENDOR_OFFSET = 2;

    public static final String computeSystemImageHashFromDsl(int i, String imageSource, String abi) {
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        Intrinsics.checkNotNullParameter(abi, "abi");
        return SYSTEM_IMAGE_PREFIX + computeVersionString(i) + ';' + computeVendorString(imageSource) + ';' + abi;
    }

    private static final String computeVersionString(int i) {
        return Intrinsics.stringPlus(API_PREFIX, Integer.valueOf(i));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    public static final String computeVendorString(String imageSource) {
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        switch (imageSource.hashCode()) {
            case -1536325379:
                if (!imageSource.equals("google-atd")) {
                }
                break;
            case -1240244679:
                if (!imageSource.equals("google")) {
                }
                break;
            case 3000075:
                if (!imageSource.equals("aosp")) {
                }
                break;
            case 379795663:
                if (!imageSource.equals("aosp-atd")) {
                }
                break;
        }
        return imageSource;
    }

    public static final boolean isWearTvOrAutoSource(String imageSource) {
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        String str = imageSource;
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "-wear", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "-tv", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "-auto", false, 2, (Object) null);
    }

    public static final boolean isWearTvOrAutoDevice(String deviceName) {
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        String str = deviceName;
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "Wear", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "TV", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "Auto", false, 2, (Object) null);
    }

    public static final Integer parseApiFromHash(String systemImageHash) {
        Intrinsics.checkNotNullParameter(systemImageHash, "systemImageHash");
        String str = (String) StringsKt.split$default((CharSequence) systemImageHash, new String[]{";"}, false, 0, 6, (Object) null).get(1);
        if (!StringsKt.startsWith$default(str, API_PREFIX, false, 2, (Object) null)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(StringsKt.substringAfter$default(str, API_PREFIX, (String) null, 2, (Object) null)));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final String parseVendorFromHash(String systemImageHash) {
        Intrinsics.checkNotNullParameter(systemImageHash, "systemImageHash");
        return (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) systemImageHash, new String[]{";"}, false, 0, 6, (Object) null), 2);
    }

    public static final String parseAbiFromHash(String systemImageHash) {
        Intrinsics.checkNotNullParameter(systemImageHash, "systemImageHash");
        return (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) systemImageHash, new String[]{";"}, false, 0, 6, (Object) null), 3);
    }
}
