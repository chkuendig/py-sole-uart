package com.ua.sdk.internal;

import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.util.Streams;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class DebugJsonParser<T> implements JsonParser<T> {
    private final JsonParser<T> parser;

    public DebugJsonParser(JsonParser<T> jsonParser) throws NullPointerException {
        Precondition.isNotNull(jsonParser);
        this.parser = jsonParser;
    }

    @Override // com.ua.sdk.internal.JsonParser
    public T parse(InputStream inputStream) throws UaException {
        String fully = null;
        try {
            try {
                fully = Streams.readFully(inputStream);
                return this.parser.parse(new ByteArrayInputStream(fully.getBytes("UTF-8")));
            } catch (IOException e) {
                throw new UaException(e);
            }
        } finally {
            UaLog.debug("response=%s", fully);
        }
    }
}
