package org.apache.http.client.fluent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

/* loaded from: classes2.dex */
class InternalInputStreamEntity extends AbstractHttpEntity {
    private final InputStream content;
    private final long length;

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return true;
    }

    public InternalInputStreamEntity(InputStream inputStream, long j, ContentType contentType) {
        this.content = (InputStream) Args.notNull(inputStream, "Source input stream");
        this.length = j;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.length;
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        return this.content;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        int i;
        Args.notNull(outputStream, "Output stream");
        InputStream inputStream = this.content;
        try {
            byte[] bArr = new byte[4096];
            long j = this.length;
            if (j < 0) {
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, i2);
                    }
                }
            } else {
                while (j > 0 && (i = inputStream.read(bArr, 0, (int) Math.min(4096L, j))) != -1) {
                    outputStream.write(bArr, 0, i);
                    j -= i;
                }
            }
        } finally {
            inputStream.close();
        }
    }
}
