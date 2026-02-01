package com.ua.oss.org.apache.http.entity.mime;

import com.ua.oss.org.apache.http.entity.ContentType;
import com.ua.oss.org.apache.http.entity.mime.content.AbstractContentBody;
import com.ua.oss.org.apache.http.entity.mime.content.ContentBody;
import com.ua.sdk.internal.Precondition;
import org.apache.http.protocol.HTTP;

/* loaded from: classes2.dex */
public class FormBodyPart {
    private final ContentBody body;
    private final Header header;
    private final String name;

    public FormBodyPart(String str, ContentBody contentBody) throws NullPointerException {
        Precondition.isNotNull(str, "Name");
        Precondition.isNotNull(contentBody, "Body");
        this.name = str;
        this.body = contentBody;
        this.header = new Header();
        generateContentDisp(contentBody);
        generateContentType(contentBody);
        generateTransferEncoding(contentBody);
    }

    public String getName() {
        return this.name;
    }

    public ContentBody getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public void addField(String str, String str2) throws NullPointerException {
        Precondition.isNotNull(str, "Field name");
        this.header.addField(new MinimalField(str, str2));
    }

    protected void generateContentDisp(ContentBody contentBody) throws NullPointerException {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(getName());
        sb.append("\"");
        if (contentBody.getFilename() != null) {
            sb.append("; filename=\"");
            sb.append(contentBody.getFilename());
            sb.append("\"");
        }
        addField(MIME.CONTENT_DISPOSITION, sb.toString());
    }

    protected void generateContentType(ContentBody contentBody) throws NullPointerException {
        ContentType contentType = contentBody instanceof AbstractContentBody ? ((AbstractContentBody) contentBody).getContentType() : null;
        if (contentType != null) {
            addField("Content-Type", contentType.toString());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(contentBody.getMimeType());
        if (contentBody.getCharset() != null) {
            sb.append(HTTP.CHARSET_PARAM);
            sb.append(contentBody.getCharset());
        }
        addField("Content-Type", sb.toString());
    }

    protected void generateTransferEncoding(ContentBody contentBody) throws NullPointerException {
        addField(MIME.CONTENT_TRANSFER_ENC, contentBody.getTransferEncoding());
    }
}
