package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;

/* loaded from: classes2.dex */
public class GzipDecompressingEntity extends DecompressingEntity {
    public GzipDecompressingEntity(HttpEntity httpEntity) {
        super(httpEntity, new InputStreamFactory() { // from class: org.apache.http.client.entity.GzipDecompressingEntity.1
            @Override // org.apache.http.client.entity.InputStreamFactory
            public InputStream create(InputStream inputStream) throws IOException {
                return new GZIPInputStream(inputStream);
            }
        });
    }
}
