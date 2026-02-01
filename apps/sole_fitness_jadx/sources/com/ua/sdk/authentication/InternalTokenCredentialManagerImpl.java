package com.ua.sdk.authentication;

import com.ua.sdk.UaException;
import com.ua.sdk.authentication.InternalTokenCredentialManager;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class InternalTokenCredentialManagerImpl implements InternalTokenCredentialManager {
    private final ExecutorService executor;
    private final InternalTokenCredentialService service;

    public InternalTokenCredentialManagerImpl(InternalTokenCredentialService internalTokenCredentialService, ExecutorService executorService) {
        this.service = internalTokenCredentialService;
        this.executor = executorService;
    }

    @Override // com.ua.sdk.authentication.InternalTokenCredentialManager
    public OAuth2Credentials createForLogin(InternalTokenCredentialManager.TokenType tokenType, String str, String str2) throws UaException {
        InternalTokenCredentialImpl internalTokenCredentialImpl = new InternalTokenCredentialImpl();
        internalTokenCredentialImpl.setTokenType(tokenType.toString());
        internalTokenCredentialImpl.setToken(str);
        internalTokenCredentialImpl.setSecret(str2);
        return this.service.save(internalTokenCredentialImpl, false);
    }

    @Override // com.ua.sdk.authentication.InternalTokenCredentialManager
    public OAuth2Credentials updateForSync(InternalTokenCredentialManager.TokenType tokenType, String str, String str2) throws UaException {
        InternalTokenCredentialImpl internalTokenCredentialImpl = new InternalTokenCredentialImpl();
        internalTokenCredentialImpl.setTokenType(tokenType.toString());
        internalTokenCredentialImpl.setToken(str);
        internalTokenCredentialImpl.setSecret(str2);
        return this.service.save(internalTokenCredentialImpl, true);
    }
}
