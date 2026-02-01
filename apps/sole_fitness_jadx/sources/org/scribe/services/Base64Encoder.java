package org.scribe.services;

/* loaded from: classes2.dex */
public abstract class Base64Encoder {
    private static Base64Encoder instance;

    public abstract String encode(byte[] bArr);

    public abstract String getType();

    public static synchronized Base64Encoder getInstance() {
        if (instance == null) {
            instance = createEncoderInstance();
        }
        return instance;
    }

    private static Base64Encoder createEncoderInstance() {
        if (CommonsEncoder.isPresent()) {
            return new CommonsEncoder();
        }
        return new DatatypeConverterEncoder();
    }

    public static String type() {
        return getInstance().getType();
    }
}
