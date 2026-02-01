package com.ua.oss.org.apache.http.entity;

import com.ua.oss.org.apache.http.Consts;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.HeaderValueParser;
import org.apache.http.protocol.HTTP;

/* loaded from: classes2.dex */
public final class ContentType {
    public static final ContentType DEFAULT_TEXT;
    public static final ContentType TEXT_PLAIN;
    private final Charset charset;
    private final String mimeType;

    static {
        ContentType contentTypeCreate = create(HTTP.PLAIN_TEXT_TYPE, Consts.ISO_8859_1);
        TEXT_PLAIN = contentTypeCreate;
        DEFAULT_TEXT = contentTypeCreate;
    }

    ContentType(String str, Charset charset) {
        this.mimeType = str;
        this.charset = charset;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mimeType);
        if (this.charset != null) {
            sb.append(HTTP.CHARSET_PARAM);
            sb.append(this.charset.name());
        }
        return sb.toString();
    }

    private static boolean valid(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"' || cCharAt == ',' || cCharAt == ';') {
                return false;
            }
        }
        return true;
    }

    public static ContentType create(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        String lowerCase = str.trim().toLowerCase(Locale.US);
        if (lowerCase.length() == 0) {
            throw new IllegalArgumentException("MIME type may not be empty");
        }
        if (!valid(lowerCase)) {
            throw new IllegalArgumentException("MIME type may not contain reserved characters");
        }
        return new ContentType(lowerCase, charset);
    }

    public static ContentType create(String str) {
        return new ContentType(str, null);
    }

    public static ContentType create(String str, String str2) throws UnsupportedCharsetException {
        return create(str, str2 != null ? Charset.forName(str2) : null);
    }

    private static ContentType create(HeaderElement headerElement) {
        String name = headerElement.getName();
        NameValuePair parameterByName = headerElement.getParameterByName("charset");
        return create(name, parameterByName != null ? parameterByName.getValue() : null);
    }

    public static ContentType parse(String str) throws ParseException, UnsupportedCharsetException {
        if (str == null) {
            throw new IllegalArgumentException("Content type may not be null");
        }
        HeaderElement[] elements = BasicHeaderValueParser.parseElements(str, (HeaderValueParser) null);
        if (elements.length > 0) {
            return create(elements[0]);
        }
        throw new ParseException("Invalid content type: " + str);
    }

    public static ContentType get(HttpEntity httpEntity) throws ParseException, UnsupportedCharsetException {
        Header contentType;
        if (httpEntity != null && (contentType = httpEntity.getContentType()) != null) {
            HeaderElement[] elements = contentType.getElements();
            if (elements.length > 0) {
                return create(elements[0]);
            }
        }
        return null;
    }
}
