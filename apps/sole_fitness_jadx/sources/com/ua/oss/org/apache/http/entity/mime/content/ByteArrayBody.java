package com.ua.oss.org.apache.http.entity.mime.content;

import com.ua.oss.org.apache.http.entity.ContentType;
import com.ua.oss.org.apache.http.entity.mime.MIME;
import com.ua.sdk.internal.Precondition;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class ByteArrayBody extends AbstractContentBody {
    private final byte[] data;
    private final String filename;

    @Override // com.ua.oss.org.apache.http.entity.mime.content.AbstractContentBody, com.ua.oss.org.apache.http.entity.mime.content.ContentDescriptor
    public String getCharset() {
        return null;
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    @Deprecated
    public ByteArrayBody(byte[] bArr, String str, String str2) {
        this(bArr, ContentType.create(str), str2);
    }

    public ByteArrayBody(byte[] bArr, ContentType contentType, String str) throws NullPointerException {
        super(contentType);
        Precondition.isNotNull(bArr, "byte[]");
        this.data = bArr;
        this.filename = str;
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.data);
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return this.data.length;
    }
}
