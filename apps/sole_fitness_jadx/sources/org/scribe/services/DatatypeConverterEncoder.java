package org.scribe.services;

import javax.xml.bind.DatatypeConverter;

/* loaded from: classes2.dex */
public class DatatypeConverterEncoder extends Base64Encoder {
    @Override // org.scribe.services.Base64Encoder
    public String getType() {
        return "DatatypeConverter";
    }

    @Override // org.scribe.services.Base64Encoder
    public String encode(byte[] bArr) {
        return DatatypeConverter.printBase64Binary(bArr);
    }
}
