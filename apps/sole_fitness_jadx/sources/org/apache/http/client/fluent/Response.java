package org.apache.http.client.fluent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

/* loaded from: classes2.dex */
public class Response {
    private boolean consumed;
    private final HttpResponse response;

    Response(HttpResponse httpResponse) {
        this.response = httpResponse;
    }

    private void assertNotConsumed() {
        if (this.consumed) {
            throw new IllegalStateException("Response content has been already consumed");
        }
    }

    private void dispose() {
        if (this.consumed) {
            return;
        }
        try {
            InputStream content = this.response.getEntity().getContent();
            if (content != null) {
                content.close();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.consumed = true;
            throw th;
        }
        this.consumed = true;
    }

    public void discardContent() {
        dispose();
    }

    public <T> T handleResponse(ResponseHandler<T> responseHandler) throws IOException {
        assertNotConsumed();
        try {
            return responseHandler.handleResponse(this.response);
        } finally {
            dispose();
        }
    }

    public Content returnContent() throws IOException {
        return (Content) handleResponse(new ContentResponseHandler());
    }

    public HttpResponse returnResponse() throws IOException {
        assertNotConsumed();
        try {
            HttpEntity entity = this.response.getEntity();
            if (entity != null) {
                ByteArrayEntity byteArrayEntity = new ByteArrayEntity(EntityUtils.toByteArray(entity));
                byteArrayEntity.setContentType(ContentType.getOrDefault(entity).toString());
                this.response.setEntity(byteArrayEntity);
            }
            return this.response;
        } finally {
            this.consumed = true;
        }
    }

    public void saveContent(File file) throws IOException {
        assertNotConsumed();
        StatusLine statusLine = this.response.getStatusLine();
        if (statusLine.getStatusCode() >= 300) {
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            HttpEntity entity = this.response.getEntity();
            if (entity != null) {
                entity.writeTo(fileOutputStream);
            }
        } finally {
            this.consumed = true;
            fileOutputStream.close();
        }
    }
}
