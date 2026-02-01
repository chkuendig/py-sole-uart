package com.ua.sdk.user;

import com.ua.sdk.internal.LinkEntityRef;

/* loaded from: classes2.dex */
public class CurrentUserRef extends LinkEntityRef<User> {
    @Override // com.ua.sdk.internal.LinkEntityRef
    public boolean checkCache() {
        return false;
    }

    public CurrentUserRef() {
        super("self", null);
    }
}
