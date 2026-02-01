package com.facebook.internal;

import android.content.Intent;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.UUID;

/* loaded from: classes.dex */
public class AppCall {
    private static AppCall currentPendingCall;
    private UUID callId;
    private int requestCode;
    private Intent requestIntent;

    public static AppCall getCurrentPendingCall() {
        if (CrashShieldHandler.isObjectCrashing(AppCall.class)) {
            return null;
        }
        try {
            return currentPendingCall;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppCall.class);
            return null;
        }
    }

    public static synchronized AppCall finishPendingCall(UUID uuid, int i) {
        if (CrashShieldHandler.isObjectCrashing(AppCall.class)) {
            return null;
        }
        try {
            AppCall currentPendingCall2 = getCurrentPendingCall();
            if (currentPendingCall2 != null && currentPendingCall2.getCallId().equals(uuid) && currentPendingCall2.getRequestCode() == i) {
                setCurrentPendingCall(null);
                return currentPendingCall2;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppCall.class);
            return null;
        }
    }

    private static synchronized boolean setCurrentPendingCall(AppCall appCall) {
        if (CrashShieldHandler.isObjectCrashing(AppCall.class)) {
            return false;
        }
        try {
            AppCall currentPendingCall2 = getCurrentPendingCall();
            currentPendingCall = appCall;
            return currentPendingCall2 != null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppCall.class);
            return false;
        }
    }

    public AppCall(int i) {
        this(i, UUID.randomUUID());
    }

    public AppCall(int i, UUID uuid) {
        this.callId = uuid;
        this.requestCode = i;
    }

    public Intent getRequestIntent() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.requestIntent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public UUID getCallId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.callId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public int getRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.requestCode;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public void setRequestCode(int i) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.requestCode = i;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void setRequestIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.requestIntent = intent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public boolean setPending() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return setCurrentPendingCall(this);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
