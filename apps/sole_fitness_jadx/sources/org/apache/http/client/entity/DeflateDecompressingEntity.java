package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;

/* loaded from: classes2.dex */
public class DeflateDecompressingEntity extends DecompressingEntity {
    public DeflateDecompressingEntity(HttpEntity httpEntity) {
        super(httpEntity, new InputStreamFactory() { // from class: org.apache.http.client.entity.DeflateDecompressingEntity.1
            @Override // org.apache.http.client.entity.InputStreamFactory
            public InputStream create(InputStream inputStream) throws IOException {
                return new DeflateInputStream(inputStream);
            }
        });
    }
}
