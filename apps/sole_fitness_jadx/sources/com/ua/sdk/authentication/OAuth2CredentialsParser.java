package com.ua.sdk.authentication;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class OAuth2CredentialsParser implements JsonParser<OAuth2Credentials> {
    private Gson gson;

    public OAuth2CredentialsParser(Gson gson) {
        this.gson = gson;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.JsonParser
    public OAuth2Credentials parse(InputStream inputStream) throws UaException {
        try {
            return OAuth2CredentialsTO.toImpl((OAuth2CredentialsTO) this.gson.fromJson(new JsonReader(new InputStreamReader(inputStream)), OAuth2CredentialsTO.class));
        } catch (JsonIOException e) {
            throw new UaException("Parse error", e);
        } catch (JsonSyntaxException unused) {
            throw new UaException("Parse error");
        }
    }
}
