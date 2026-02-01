package com.android.ddmlib.internal;

import com.android.ddmlib.ProfileableClient;
import com.android.ddmlib.ProfileableClientData;

/* loaded from: classes3.dex */
public class ProfileableClientImpl implements ProfileableClient {
    private ProfileableClientData mClientData;

    ProfileableClientImpl(int pid, String processName, String abi) {
        this.mClientData = new ProfileableClientData(pid, processName, abi);
    }

    @Override // com.android.ddmlib.ProfileableClient
    public ProfileableClientData getProfileableClientData() {
        return this.mClientData;
    }
}
