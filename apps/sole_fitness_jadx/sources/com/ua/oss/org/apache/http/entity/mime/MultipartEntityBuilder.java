package com.ua.oss.org.apache.http.entity.mime;

import com.ua.oss.org.apache.http.entity.ContentType;
import com.ua.oss.org.apache.http.entity.mime.content.ByteArrayBody;
import com.ua.oss.org.apache.http.entity.mime.content.ContentBody;
import com.ua.oss.org.apache.http.entity.mime.content.FileBody;
import com.ua.oss.org.apache.http.entity.mime.content.InputStreamBody;
import com.ua.oss.org.apache.http.entity.mime.content.StringBody;
import com.ua.sdk.internal.Precondition;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpEntity;
import org.apache.http.protocol.HTTP;

/* loaded from: classes2.dex */
public class MultipartEntityBuilder {
    private static final String DEFAULT_SUBTYPE = "form-data";
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String subType = DEFAULT_SUBTYPE;
    private HttpMultipartMode mode = HttpMultipartMode.BROWSER_COMPATIBLE;
    private String boundary = null;
    private Charset charset = null;
    private List<FormBodyPart> bodyParts = null;

    public static MultipartEntityBuilder create() {
        return new MultipartEntityBuilder();
    }

    MultipartEntityBuilder() {
    }

    public MultipartEntityBuilder setMode(HttpMultipartMode httpMultipartMode) {
        this.mode = httpMultipartMode;
        return this;
    }

    public MultipartEntityBuilder setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    MultipartEntityBuilder addPart(FormBodyPart formBodyPart) {
        if (formBodyPart == null) {
            return this;
        }
        if (this.bodyParts == null) {
            this.bodyParts = new ArrayList();
        }
        this.bodyParts.add(formBodyPart);
        return this;
    }

    public MultipartEntityBuilder addPart(String str, ContentBody contentBody) throws NullPointerException {
        Precondition.isNotNull(str, "Name");
        Precondition.isNotNull(contentBody, "Content body");
        return addPart(new FormBodyPart(str, contentBody));
    }

    public MultipartEntityBuilder addTextBody(String str, String str2, ContentType contentType) {
        return addPart(str, new StringBody(str2, contentType));
    }

    public MultipartEntityBuilder addTextBody(String str, String str2) {
        return addTextBody(str, str2, ContentType.DEFAULT_TEXT);
    }

    public MultipartEntityBuilder addBinaryBody(String str, byte[] bArr, ContentType contentType, String str2) {
        return addPart(str, new ByteArrayBody(bArr, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, File file, ContentType contentType, String str2) {
        return addPart(str, new FileBody(file, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, InputStream inputStream, ContentType contentType, String str2) {
        return addPart(str, new InputStreamBody(inputStream, contentType, str2));
    }

    private String generateContentType(String str, Charset charset) {
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data; boundary=");
        sb.append(str);
        if (charset != null) {
            sb.append(HTTP.CHARSET_PARAM);
            sb.append(charset.name());
        }
        return sb.toString();
    }

    private String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int iNextInt = random.nextInt(11) + 30;
        for (int i = 0; i < iNextInt; i++) {
            char[] cArr = MULTIPART_CHARS;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    MultipartFormEntity buildEntity() {
        HttpBrowserCompatibleMultipart httpBrowserCompatibleMultipart;
        String str = this.subType;
        if (str == null) {
            str = DEFAULT_SUBTYPE;
        }
        Charset charset = this.charset;
        String strGenerateBoundary = this.boundary;
        if (strGenerateBoundary == null) {
            strGenerateBoundary = generateBoundary();
        }
        List arrayList = this.bodyParts != null ? new ArrayList(this.bodyParts) : Collections.emptyList();
        HttpMultipartMode httpMultipartMode = this.mode;
        if (httpMultipartMode == null) {
            httpMultipartMode = HttpMultipartMode.BROWSER_COMPATIBLE;
        }
        if (AnonymousClass1.$SwitchMap$com$ua$oss$org$apache$http$entity$mime$HttpMultipartMode[httpMultipartMode.ordinal()] == 1) {
            httpBrowserCompatibleMultipart = new HttpBrowserCompatibleMultipart(str, charset, strGenerateBoundary, arrayList);
        } else {
            httpBrowserCompatibleMultipart = new HttpBrowserCompatibleMultipart(str, charset, strGenerateBoundary, arrayList);
        }
        return new MultipartFormEntity(httpBrowserCompatibleMultipart, generateContentType(strGenerateBoundary, charset), httpBrowserCompatibleMultipart.getTotalLength());
    }

    /* renamed from: com.ua.oss.org.apache.http.entity.mime.MultipartEntityBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$oss$org$apache$http$entity$mime$HttpMultipartMode;

        static {
            int[] iArr = new int[HttpMultipartMode.values().length];
            $SwitchMap$com$ua$oss$org$apache$http$entity$mime$HttpMultipartMode = iArr;
            try {
                iArr[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public HttpEntity build() {
        return buildEntity();
    }
}
