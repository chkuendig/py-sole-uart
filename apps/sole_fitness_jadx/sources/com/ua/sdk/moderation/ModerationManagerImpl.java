package com.ua.sdk.moderation;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.EntityRef;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;

/* loaded from: classes2.dex */
public class ModerationManagerImpl implements ModerationManager {
    private final ModerationActionManager actionManager;

    public ModerationManagerImpl(ModerationActionManager moderationActionManager) {
        this.actionManager = moderationActionManager;
    }

    @Override // com.ua.sdk.moderation.ModerationManager
    public ModerationAction flagEntity(EntityRef entityRef) throws UaException {
        return this.actionManager.flagEntity(entityRef);
    }

    @Override // com.ua.sdk.moderation.ModerationManager
    public Request flagEntity(EntityRef entityRef, CreateCallback<ModerationAction> createCallback) {
        return this.actionManager.flagEntity(entityRef, createCallback);
    }

    @Override // com.ua.sdk.moderation.ModerationManager
    public ModerationAction unflagEntity(EntityRef entityRef) throws UaException {
        return this.actionManager.unflagEntity(entityRef);
    }

    @Override // com.ua.sdk.moderation.ModerationManager
    public Request unflagEntity(EntityRef entityRef, CreateCallback<ModerationAction> createCallback) {
        return this.actionManager.unflagEntity(entityRef, createCallback);
    }
}
