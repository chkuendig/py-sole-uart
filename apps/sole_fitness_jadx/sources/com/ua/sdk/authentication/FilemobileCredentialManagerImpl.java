package com.ua.sdk.authentication;

import com.ua.sdk.UaException;

/* loaded from: classes2.dex */
public class FilemobileCredentialManagerImpl implements FilemobileCredentialManager {
    private final FilemobileCredentialService service;

    public FilemobileCredentialManagerImpl(FilemobileCredentialService filemobileCredentialService) {
        this.service = filemobileCredentialService;
    }

    @Override // com.ua.sdk.authentication.FilemobileCredentialManager
    public FilemobileCredential getFilemobileTokenCredentials() throws UaException {
        return this.service.fetchCredentials();
    }
}
