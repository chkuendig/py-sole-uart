package org.scribe.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.scribe.exceptions.OAuthException;

/* loaded from: classes2.dex */
public class OAuthEncoder {
    private static String CHARSET = "UTF-8";
    private static final Map<String, String> ENCODING_RULES;

    static {
        HashMap map = new HashMap();
        map.put("*", "%2A");
        map.put("+", "%20");
        map.put("%7E", "~");
        ENCODING_RULES = Collections.unmodifiableMap(map);
    }

    private OAuthEncoder() {
    }

    public static String encode(String str) throws UnsupportedEncodingException {
        Preconditions.checkNotNull(str, "Cannot encode null object");
        try {
            String strEncode = URLEncoder.encode(str, CHARSET);
            for (Map.Entry<String, String> entry : ENCODING_RULES.entrySet()) {
                strEncode = applyRule(strEncode, entry.getKey(), entry.getValue());
            }
            return strEncode;
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException("Charset not found while encoding string: " + CHARSET, e);
        }
    }

    private static String applyRule(String str, String str2, String str3) {
        return str.replaceAll(Pattern.quote(str2), str3);
    }

    public static String decode(String str) {
        Preconditions.checkNotNull(str, "Cannot decode null object");
        try {
            return URLDecoder.decode(str, CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException("Charset not found while decoding string: " + CHARSET, e);
        }
    }
}
