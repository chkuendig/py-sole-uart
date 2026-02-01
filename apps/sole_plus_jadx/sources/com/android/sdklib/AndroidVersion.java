package com.android.sdklib;

import com.android.SdkConstants;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class AndroidVersion implements Comparable<AndroidVersion>, Serializable {
    public static final int MAX_32_BIT_API = 30;
    public static final int MIN_4K_TV_API = 31;
    public static final int MIN_FOLDABLE_DEVICE_API = 29;
    public static final int MIN_FREEFORM_DEVICE_API = 30;
    public static final int MIN_HINGE_FOLDABLE_DEVICE_API = 30;
    public static final int MIN_PIXEL_4A_DEVICE_API = 30;
    public static final int MIN_RECOMMENDED_API = 22;
    public static final int MIN_RECOMMENDED_WEAR_API = 25;
    public static final int MIN_RESIZABLE_DEVICE_API = 33;
    private static final long serialVersionUID = 1;
    private final int mApiLevel;
    private final String mCodename;
    private final Integer mExtensionLevel;
    private final boolean mIsBaseExtension;
    public static final Pattern PREVIEW_PATTERN = Pattern.compile("^[A-Z][0-9A-Za-z_]*$");
    public static final AndroidVersion DEFAULT = new AndroidVersion(1, null);
    public static final AndroidVersion ART_RUNTIME = new AndroidVersion(21, null);
    public static final AndroidVersion SUPPORTS_64_BIT = new AndroidVersion(21, null);
    public static final AndroidVersion BINDER_CMD_AVAILABLE = new AndroidVersion(24, null);
    public static final AndroidVersion ALLOW_SPLIT_APK_INSTALLATION = new AndroidVersion(21, null);
    public static final AndroidVersion SUPPORTS_MULTI_USER = new AndroidVersion(17, null);

    public static class VersionCodes {
        public static final int BASE = 1;
        public static final int BASE_1_1 = 2;
        public static final int CUPCAKE = 3;
        public static final int DONUT = 4;
        public static final int ECLAIR = 5;
        public static final int ECLAIR_0_1 = 6;
        public static final int ECLAIR_MR1 = 7;
        public static final int FROYO = 8;
        public static final int GINGERBREAD = 9;
        public static final int GINGERBREAD_MR1 = 10;
        public static final int HONEYCOMB = 11;
        public static final int HONEYCOMB_MR1 = 12;
        public static final int HONEYCOMB_MR2 = 13;
        public static final int ICE_CREAM_SANDWICH = 14;
        public static final int ICE_CREAM_SANDWICH_MR1 = 15;
        public static final int JELLY_BEAN = 16;
        public static final int JELLY_BEAN_MR1 = 17;
        public static final int JELLY_BEAN_MR2 = 18;
        public static final int KITKAT = 19;
        public static final int KITKAT_WATCH = 20;
        public static final int LOLLIPOP = 21;
        public static final int LOLLIPOP_MR1 = 22;
        public static final int M = 23;
        public static final int N = 24;
        public static final int N_MR1 = 25;
        public static final int O = 26;
        public static final int O_MR1 = 27;
        public static final int P = 28;
        public static final int Q = 29;
        public static final int R = 30;
        public static final int S = 31;
        public static final int UNDEFINED = 0;
    }

    public static final class AndroidVersionException extends Exception {
        private static final long serialVersionUID = 1;

        public AndroidVersionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public AndroidVersion(int apiLevel, String codename) {
        this.mApiLevel = apiLevel;
        this.mCodename = sanitizeCodename(codename);
        this.mExtensionLevel = null;
        this.mIsBaseExtension = true;
    }

    public AndroidVersion(int apiLevel) {
        this(apiLevel, null);
    }

    public AndroidVersion(String apiOrCodename) throws AndroidVersionException, NumberFormatException {
        int i;
        String str;
        try {
            i = Integer.parseInt(apiOrCodename);
        } catch (NumberFormatException unused) {
            if (SdkConstants.CODENAME_RELEASE.equals(apiOrCodename) || !PREVIEW_PATTERN.matcher(apiOrCodename).matches()) {
                i = 0;
            } else {
                i = 0;
                str = apiOrCodename;
            }
        }
        str = null;
        this.mApiLevel = i;
        this.mCodename = sanitizeCodename(str);
        this.mExtensionLevel = null;
        this.mIsBaseExtension = true;
        if (i <= 0 && str == null) {
            throw new AndroidVersionException("Invalid android API or codename " + apiOrCodename, null);
        }
    }

    public AndroidVersion(int apiLevel, String codename, Integer extensionLevel, boolean isBaseExtension) {
        this.mApiLevel = apiLevel;
        this.mCodename = sanitizeCodename(codename);
        this.mExtensionLevel = extensionLevel;
        this.mIsBaseExtension = isBaseExtension;
    }

    public int getApiLevel() {
        return this.mApiLevel;
    }

    public int getFeatureLevel() {
        return this.mCodename != null ? this.mApiLevel + 1 : this.mApiLevel;
    }

    public String getCodename() {
        return this.mCodename;
    }

    public String getApiString() {
        String str = this.mCodename;
        return str != null ? str : Integer.toString(this.mApiLevel);
    }

    public Integer getExtensionLevel() {
        return this.mExtensionLevel;
    }

    public boolean isBaseExtension() {
        return this.mIsBaseExtension;
    }

    public boolean isPreview() {
        return this.mCodename != null;
    }

    public boolean isLegacyMultidex() {
        return getFeatureLevel() < 21;
    }

    public boolean canRun(AndroidVersion appVersion) {
        String str = appVersion.mCodename;
        if (str != null) {
            return str.equals(this.mCodename);
        }
        return this.mApiLevel >= appVersion.mApiLevel;
    }

    public boolean equals(int apiLevel) {
        return this.mCodename == null && apiLevel == this.mApiLevel;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AndroidVersion)) {
            return false;
        }
        AndroidVersion androidVersion = (AndroidVersion) obj;
        if (this.mApiLevel == androidVersion.mApiLevel && Objects.equals(this.mCodename, androidVersion.mCodename)) {
            return (this.mIsBaseExtension && androidVersion.mIsBaseExtension) || Objects.equals(this.mExtensionLevel, androidVersion.mExtensionLevel);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mApiLevel), this.mCodename, Integer.valueOf(this.mIsBaseExtension ? 0 : this.mExtensionLevel.intValue()));
    }

    public String toString() {
        String str = String.format(Locale.US, "API %1$d", Integer.valueOf(this.mApiLevel));
        if (isPreview()) {
            str = str + String.format(Locale.US, ", %1$s preview", this.mCodename);
        }
        return this.mExtensionLevel != null ? str + String.format(Locale.US, ", extension level %1$s", this.mExtensionLevel) : str;
    }

    @Override // java.lang.Comparable
    public int compareTo(AndroidVersion o) {
        int iCompareTo = compareTo(o.getApiLevel(), o.getCodename());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (this.mIsBaseExtension && o.mIsBaseExtension) {
            return 0;
        }
        if (this.mExtensionLevel == null) {
            return o.getExtensionLevel() != null ? -1 : 0;
        }
        if (o.getExtensionLevel() != null) {
            return this.mExtensionLevel.intValue() - o.getExtensionLevel().intValue();
        }
        return 1;
    }

    public int compareTo(int apiLevel, String codename) {
        String str = this.mCodename;
        if (str == null) {
            if (codename == null || this.mApiLevel != apiLevel) {
                return this.mApiLevel - apiLevel;
            }
            return -1;
        }
        int i = this.mApiLevel;
        if (i != apiLevel) {
            return i - apiLevel;
        }
        if (codename == null) {
            return 1;
        }
        return str.compareTo(codename);
    }

    public boolean isGreaterOrEqualThan(int api) {
        return compareTo(api, null) >= 0;
    }

    public boolean isGreaterOrEqualThan(int api, int extensionLevel) {
        return compareTo(new AndroidVersion(api, null, Integer.valueOf(extensionLevel), true)) >= 0;
    }

    private static String sanitizeCodename(String codename) {
        if (codename == null) {
            return codename;
        }
        String strTrim = codename.trim();
        if (strTrim.isEmpty() || SdkConstants.CODENAME_RELEASE.equals(strTrim)) {
            return null;
        }
        return strTrim;
    }
}
