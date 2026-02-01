package org.scribe.utils;

import java.util.regex.Pattern;
import org.scribe.model.OAuthConstants;

/* loaded from: classes2.dex */
public class Preconditions {
    private static final String DEFAULT_MESSAGE = "Received an invalid parameter";
    private static final Pattern URL_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");

    private Preconditions() {
    }

    public static void checkNotNull(Object obj, String str) {
        check(obj != null, str);
    }

    public static void checkEmptyString(String str, String str2) {
        check((str == null || str.trim().equals("")) ? false : true, str2);
    }

    public static void checkValidUrl(String str, String str2) {
        checkEmptyString(str, str2);
        check(isUrl(str), str2);
    }

    public static void checkValidOAuthCallback(String str, String str2) {
        checkEmptyString(str, str2);
        if (str.toLowerCase().compareToIgnoreCase(OAuthConstants.OUT_OF_BAND) != 0) {
            check(isUrl(str), str2);
        }
    }

    private static boolean isUrl(String str) {
        return URL_PATTERN.matcher(str).matches();
    }

    private static void check(boolean z, String str) {
        if (str == null || str.trim().length() <= 0) {
            str = DEFAULT_MESSAGE;
        }
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
