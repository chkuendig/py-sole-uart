package com.ua.oss.org.apache.http.entity.mime.content;

import com.ua.oss.org.apache.http.entity.ContentType;
import com.ua.oss.org.apache.http.entity.mime.MIME;
import com.ua.sdk.internal.Precondition;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class FileBody extends AbstractContentBody {
    private final File file;
    private final String filename;

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    @Deprecated
    public FileBody(File file, String str, String str2, String str3) {
        this(file, ContentType.create(str2, str3), str);
    }

    public FileBody(File file, ContentType contentType, String str) throws NullPointerException {
        super(contentType);
        Precondition.isNotNull(file, "File");
        this.file = file;
        this.filename = str;
    }

    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException, NullPointerException {
        Precondition.isNotNull(outputStream, "Output stream");
        FileInputStream fileInputStream = new FileInputStream(this.file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            fileInputStream.close();
        }
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return this.file.length();
    }

    @Override // com.ua.oss.org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    public File getFile() {
        return this.file;
    }
}
