package com.ua.oss.org.apache.http.entity.mime.content;

import com.ua.oss.org.apache.http.entity.ContentType;
import com.ua.sdk.internal.Precondition;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public abstract class AbstractContentBody implements ContentBody {
    private final ContentType contentType;

    public AbstractContentBody(ContentType contentType) throws NullPointerException {
        Precondition.isNotNull(contentType, "Content type");
        this.contentType = contentType;
    }

    @Deprecated
    public AbstractContentBody(String str) {
        this(ContentType.parse(str));
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentDescriptor
    public String getMimeType() {
        return this.contentType.getMimeType();
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentDescriptor
    public String getMediaType() {
        String mimeType = this.contentType.getMimeType();
        int iIndexOf = mimeType.indexOf(47);
        return iIndexOf != -1 ? mimeType.substring(0, iIndexOf) : mimeType;
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentDescriptor
    public String getSubType() {
        String mimeType = this.contentType.getMimeType();
        int iIndexOf = mimeType.indexOf(47);
        if (iIndexOf != -1) {
            return mimeType.substring(iIndexOf + 1);
        }
        return null;
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentDescriptor
    public String getCharset() {
        Charset charset = this.contentType.getCharset();
        if (charset != null) {
            return charset.name();
        }
        return null;
    }
}
