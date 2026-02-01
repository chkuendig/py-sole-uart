package org.apache.http.client.fluent;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.http.Consts;
import org.apache.http.entity.ContentType;

/* loaded from: classes2.dex */
public class Content {
    public static final Content NO_CONTENT = new Content(new byte[0], ContentType.DEFAULT_BINARY);
    private final byte[] raw;
    private final ContentType type;

    Content(byte[] bArr, ContentType contentType) {
        this.raw = bArr;
        this.type = contentType;
    }

    public ContentType getType() {
        return this.type;
    }

    public byte[] asBytes() {
        return (byte[]) this.raw.clone();
    }

    public String asString() {
        Charset charset = this.type.getCharset();
        if (charset == null) {
            charset = Consts.ISO_8859_1;
        }
        return asString(charset);
    }

    public String asString(Charset charset) {
        return new String(this.raw, charset);
    }

    public InputStream asStream() {
        return new ByteArrayInputStream(this.raw);
    }

    public String toString() {
        return asString();
    }
}
