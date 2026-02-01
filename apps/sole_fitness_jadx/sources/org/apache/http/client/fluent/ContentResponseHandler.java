package org.apache.http.client.fluent;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.AbstractResponseHandler;
import org.apache.http.util.EntityUtils;

/* loaded from: classes2.dex */
public class ContentResponseHandler extends AbstractResponseHandler<Content> {
    @Override // org.apache.http.impl.client.AbstractResponseHandler
    public Content handleEntity(HttpEntity httpEntity) throws IOException {
        return httpEntity != null ? new Content(EntityUtils.toByteArray(httpEntity), ContentType.getOrDefault(httpEntity)) : Content.NO_CONTENT;
    }
}
