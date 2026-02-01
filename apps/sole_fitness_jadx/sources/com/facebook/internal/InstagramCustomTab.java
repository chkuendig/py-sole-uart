package com.facebook.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.CustomTabLoginMethodHandler;

/* loaded from: classes.dex */
public class InstagramCustomTab extends CustomTab {
    public InstagramCustomTab(String str, Bundle bundle) {
        super(str, bundle);
        this.uri = getURIForAction(str, bundle == null ? new Bundle() : bundle);
    }

    public static Uri getURIForAction(String str, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(InstagramCustomTab.class)) {
            return null;
        }
        try {
            if (str.equals(CustomTabLoginMethodHandler.OAUTH_DIALOG)) {
                return Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), ServerProtocol.INSTAGRAM_OAUTH_PATH, bundle);
            }
            return Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/" + ServerProtocol.DIALOG_PATH + str, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InstagramCustomTab.class);
            return null;
        }
    }
}
