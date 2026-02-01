package com.android.utils;

import com.android.utils.Environment;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import java.lang.reflect.Method;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ComputerArchUtils.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001\u001a\b\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\b\u0010\u0010\u001a\u00020\u0011H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"OS_LINUX_PREFIX", "", "OS_MAC_PREFIX", "OS_WIN_PREFIX", "TRANSLATED", "", "jvmArchitecture", "Lcom/android/utils/CpuArchitecture;", "getJvmArchitecture", "()Lcom/android/utils/CpuArchitecture;", "osArchitecture", "getOsArchitecture", "architectureFromString", "cpuArchName", "computeIsRosetta", "", "ensureInitialized", "", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ComputerArchUtilsKt {
    private static final String OS_LINUX_PREFIX = "linux";
    private static final String OS_MAC_PREFIX = "mac";
    private static final String OS_WIN_PREFIX = "win";
    private static final int TRANSLATED = 1;

    private static final void ensureInitialized() {
        if (!Environment.Companion.getInitialized()) {
            throw new IllegalStateException("Computer Architecture Environment not initialized properly.".toString());
        }
    }

    public static final CpuArchitecture getJvmArchitecture() {
        ensureInitialized();
        return architectureFromString(Environment.Companion.getInstance().getSystemProperty(Environment.SystemProperty.OS_ARCH));
    }

    public static final CpuArchitecture getOsArchitecture() {
        String lowerCase;
        CpuArchitecture jvmArchitecture = getJvmArchitecture();
        String systemProperty = Environment.Companion.getInstance().getSystemProperty(Environment.SystemProperty.OS_NAME);
        if (systemProperty == null) {
            lowerCase = null;
        } else {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            lowerCase = systemProperty.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        }
        if (lowerCase == null) {
            return jvmArchitecture;
        }
        if (jvmArchitecture == CpuArchitecture.X86) {
            if (StringsKt.startsWith$default(lowerCase, OS_WIN_PREFIX, false, 2, (Object) null)) {
                String variable = Environment.Companion.getInstance().getVariable(Environment.EnvironmentVariable.PROCESSOR_ARCHITEW6432);
                if (variable != null && StringsKt.contains$default((CharSequence) variable, (CharSequence) "64", false, 2, (Object) null)) {
                    return CpuArchitecture.X86_64;
                }
            } else if (StringsKt.startsWith$default(lowerCase, OS_LINUX_PREFIX, false, 2, (Object) null)) {
                return architectureFromString(Environment.Companion.getInstance().getVariable(Environment.EnvironmentVariable.HOST_TYPE));
            }
        }
        return (jvmArchitecture == CpuArchitecture.X86_64 && StringsKt.startsWith$default(lowerCase, OS_MAC_PREFIX, false, 2, (Object) null) && Environment.Companion.getInstance().isRosetta()) ? CpuArchitecture.X86_ON_ARM : jvmArchitecture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean computeIsRosetta() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        try {
            Class<?> cls = Class.forName("com.sun.jna.platform.mac.SystemB");
            if (!(cls instanceof Class)) {
                cls = null;
            }
            if (cls == null) {
                return false;
            }
            Object obj = cls.getField("INSTANCE").get(null);
            Method method = cls.getMethod("sysctlbyname", String.class, Pointer.class, IntByReference.class, Pointer.class, Integer.TYPE);
            Memory memory = new Memory(4L);
            return Intrinsics.areEqual(method.invoke(obj, "sysctl.proc_translated", memory, new IntByReference(4), null, 0), (Object) 0) && memory.getInt(0L) == 1;
        } catch (ClassNotFoundException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static final CpuArchitecture architectureFromString(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return CpuArchitecture.UNKNOWN;
        }
        if (!StringsKt.equals(str, "x86_64", true) && !StringsKt.equals(str, "ia64", true) && !StringsKt.equals(str, "amd64", true)) {
            return StringsKt.equals(str, "x86", true) ? CpuArchitecture.X86 : StringsKt.equals(str, "aarch64", true) ? CpuArchitecture.ARM : (str.length() == 4 && str.charAt(0) == 'i' && StringsKt.endsWith$default(str, "86", false, 2, (Object) null)) ? CpuArchitecture.X86 : CpuArchitecture.UNKNOWN;
        }
        return CpuArchitecture.X86_64;
    }
}
