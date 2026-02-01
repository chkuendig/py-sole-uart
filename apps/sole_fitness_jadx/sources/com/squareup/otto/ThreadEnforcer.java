package com.squareup.otto;

import android.os.Looper;

/* loaded from: classes2.dex */
public interface ThreadEnforcer {
    public static final ThreadEnforcer ANY = new ThreadEnforcer() { // from class: com.squareup.otto.ThreadEnforcer.1
        @Override // com.squareup.otto.ThreadEnforcer
        public void enforce(Bus bus) {
        }
    };
    public static final ThreadEnforcer MAIN = new ThreadEnforcer() { // from class: com.squareup.otto.ThreadEnforcer.2
        @Override // com.squareup.otto.ThreadEnforcer
        public void enforce(Bus bus) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return;
            }
            throw new IllegalStateException("Event bus " + bus + " accessed from non-main thread " + Looper.myLooper());
        }
    };

    void enforce(Bus bus);
}
