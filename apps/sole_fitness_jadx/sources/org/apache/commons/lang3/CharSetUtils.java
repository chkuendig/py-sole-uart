package org.apache.commons.lang3;

/* loaded from: classes2.dex */
public class CharSetUtils {
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e A[PHI: r5
      0x004e: PHI (r5v2 java.lang.Character) = (r5v1 java.lang.Character), (r5v4 java.lang.Character), (r5v1 java.lang.Character) binds: [B:10:0x002c, B:21:0x004a, B:17:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String squeeze(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return str;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c = charArray[0];
        sb.append(c);
        Character chValueOf = null;
        Character chValueOf2 = null;
        for (int i = 1; i < length; i++) {
            char c2 = charArray[i];
            if (c2 == c) {
                if (chValueOf == null || c2 != chValueOf.charValue()) {
                    if (chValueOf2 == null || c2 != chValueOf2.charValue()) {
                        if (charSet.contains(c2)) {
                            chValueOf = Character.valueOf(c2);
                        } else {
                            chValueOf2 = Character.valueOf(c2);
                            sb.append(c2);
                            c = c2;
                        }
                    }
                }
            } else {
                sb.append(c2);
                c = c2;
            }
        }
        return sb.toString();
    }

    public static boolean containsAny(String str, String... strArr) {
        if (!StringUtils.isEmpty(str) && !deepEmpty(strArr)) {
            CharSet charSet = CharSet.getInstance(strArr);
            for (char c : str.toCharArray()) {
                if (charSet.contains(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int count(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return 0;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        int i = 0;
        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) {
                i++;
            }
        }
        return i;
    }

    public static String keep(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        return (str.isEmpty() || deepEmpty(strArr)) ? "" : modify(str, strArr, true);
    }

    public static String delete(String str, String... strArr) {
        return (StringUtils.isEmpty(str) || deepEmpty(strArr)) ? str : modify(str, strArr, false);
    }

    private static String modify(String str, String[] strArr, boolean z) {
        CharSet charSet = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (charSet.contains(charArray[i]) == z) {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }

    private static boolean deepEmpty(String[] strArr) {
        if (strArr == null) {
            return true;
        }
        for (String str : strArr) {
            if (StringUtils.isNotEmpty(str)) {
                return false;
            }
        }
        return true;
    }
}
