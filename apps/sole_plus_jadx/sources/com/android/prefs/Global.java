package com.android.prefs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ANDROID_PREFS_ROOT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: AbstractAndroidLocations.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B5\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/android/prefs/Global;", "", "propName", "", "isSysProp", "", "isEnvVar", "androidLeaf", "mustExist", "(Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;Z)V", "getAndroidLeaf", "()Ljava/lang/String;", "()Z", "getMustExist", "getPropName", "ANDROID_USER_HOME", "ANDROID_AVD_HOME", "ANDROID_SDK_HOME", AndroidLocation.ANDROID_PREFS_ROOT, "TEST_TMPDIR", "USER_HOME", "HOME", "XGD_CONFIG_HOME", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
final class Global {
    public static final Global ANDROID_PREFS_ROOT;
    public static final Global HOME;
    public static final Global TEST_TMPDIR;
    public static final Global USER_HOME;
    public static final Global XGD_CONFIG_HOME;
    private final String androidLeaf;
    private final boolean isEnvVar;
    private final boolean isSysProp;
    private final boolean mustExist;
    private final String propName;
    public static final Global ANDROID_USER_HOME = new Global("ANDROID_USER_HOME", 0, AbstractAndroidLocations.INSTANCE.getANDROID_USER_HOME(), true, true, null, false);
    public static final Global ANDROID_AVD_HOME = new Global("ANDROID_AVD_HOME", 1, "ANDROID_AVD_HOME", true, true, null, false, 16, null);
    public static final Global ANDROID_SDK_HOME = new Global("ANDROID_SDK_HOME", 2, "ANDROID_SDK_HOME", true, true, null, false, 24, null);
    private static final /* synthetic */ Global[] $VALUES = $values();

    private static final /* synthetic */ Global[] $values() {
        return new Global[]{ANDROID_USER_HOME, ANDROID_AVD_HOME, ANDROID_SDK_HOME, ANDROID_PREFS_ROOT, TEST_TMPDIR, USER_HOME, HOME, XGD_CONFIG_HOME};
    }

    public static Global valueOf(String str) {
        return (Global) Enum.valueOf(Global.class, str);
    }

    public static Global[] values() {
        return (Global[]) $VALUES.clone();
    }

    private Global(String str, int i, String str2, boolean z, boolean z2, String str3, boolean z3) {
        this.propName = str2;
        this.isSysProp = z;
        this.isEnvVar = z2;
        this.androidLeaf = str3;
        this.mustExist = z3;
    }

    public final String getPropName() {
        return this.propName;
    }

    /* renamed from: isSysProp, reason: from getter */
    public final boolean getIsSysProp() {
        return this.isSysProp;
    }

    /* renamed from: isEnvVar, reason: from getter */
    public final boolean getIsEnvVar() {
        return this.isEnvVar;
    }

    /* synthetic */ Global(String str, int i, String str2, boolean z, boolean z2, String str3, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, z, z2, (i2 & 8) != 0 ? AbstractAndroidLocations.FOLDER_DOT_ANDROID : str3, (i2 & 16) != 0 ? true : z3);
    }

    public final String getAndroidLeaf() {
        return this.androidLeaf;
    }

    public final boolean getMustExist() {
        return this.mustExist;
    }

    static {
        boolean z = true;
        int i = 24;
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str = null;
        boolean z2 = false;
        ANDROID_PREFS_ROOT = new Global(AndroidLocation.ANDROID_PREFS_ROOT, 3, AbstractAndroidLocations.ANDROID_PREFS_ROOT, z, true, str, z2, i, defaultConstructorMarker);
        int i2 = 24;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        boolean z3 = false;
        boolean z4 = true;
        String str2 = null;
        boolean z5 = false;
        TEST_TMPDIR = new Global("TEST_TMPDIR", 4, "TEST_TMPDIR", z3, z4, str2, z5, i2, defaultConstructorMarker2);
        USER_HOME = new Global("USER_HOME", 5, "user.home", z, false, str, z2, i, defaultConstructorMarker);
        HOME = new Global("HOME", 6, "HOME", z3, z4, str2, z5, i2, defaultConstructorMarker2);
        XGD_CONFIG_HOME = new Global("XGD_CONFIG_HOME", 7, "XGD_CONFIG_HOME", z, true, str, z2, i, defaultConstructorMarker);
    }
}
