package com.ua.oss.org.apache.http.entity.mime.content;

import com.ua.oss.org.apache.http.entity.ContentType;
import com.ua.oss.org.apache.http.entity.mime.MIME;
import com.ua.sdk.internal.Precondition;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class InputStreamBody extends AbstractContentBody {
    private final String filename;
    private final InputStream in;

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return -1L;
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public InputStreamBody(InputStream inputStream, ContentType contentType, String str) throws NullPointerException {
        super(contentType);
        Precondition.isNotNull(inputStream, "Input stream");
        this.in = inputStream;
        this.filename = str;
    }

    public InputStream getInputStream() {
        return this.in;
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException, NullPointerException {
        Precondition.isNotNull(outputStream, "Output stream");
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = this.in.read(bArr);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            this.in.close();
        }
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }
}
