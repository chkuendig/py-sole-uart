package com.google.firebase.remoteconfig.interop;

import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;

/* loaded from: classes5.dex */
public interface FirebaseRemoteConfigInterop {
    void registerRolloutsStateSubscriber(String str, RolloutsStateSubscriber rolloutsStateSubscriber);
}
