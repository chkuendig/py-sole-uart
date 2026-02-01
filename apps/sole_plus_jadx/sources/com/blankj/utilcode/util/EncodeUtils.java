package com.blankj.utilcode.util;

import android.text.Html;
import android.util.Base64;
import com.android.SdkConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* loaded from: classes3.dex */
public final class EncodeUtils {
    private EncodeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String urlEncode(String str) {
        return urlEncode(str, "UTF-8");
    }

    public static String urlEncode(String str, String str2) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String urlDecode(String str) {
        return urlDecode(str, "UTF-8");
    }

    public static String urlDecode(String str, String str2) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25").replaceAll("\\+", "%2B"), str2);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] base64Encode(String str) {
        return base64Encode(str.getBytes());
    }

    public static byte[] base64Encode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        return Base64.encode(bArr, 2);
    }

    public static String base64Encode2String(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        return Base64.encodeToString(bArr, 2);
    }

    public static byte[] base64Decode(String str) {
        if (str == null || str.length() == 0) {
            return new byte[0];
        }
        return Base64.decode(str, 2);
    }

    public static byte[] base64Decode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        return Base64.decode(bArr, 2);
    }

    public static String htmlEncode(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == '\"') {
                sb.append(SdkConstants.QUOT_ENTITY);
            } else if (cCharAt == '<') {
                sb.append(SdkConstants.LT_ENTITY);
            } else if (cCharAt == '>') {
                sb.append(SdkConstants.GT_ENTITY);
            } else if (cCharAt == '&') {
                sb.append(SdkConstants.AMP_ENTITY);
            } else if (cCharAt == '\'') {
                sb.append("&#39;");
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static CharSequence htmlDecode(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return Html.fromHtml(str, 0);
    }

    public static String binaryEncode(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(Integer.toBinaryString(c)).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String binaryDecode(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String[] strArrSplit = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            sb.append((char) Integer.parseInt(str2, 2));
        }
        return sb.toString();
    }
}
