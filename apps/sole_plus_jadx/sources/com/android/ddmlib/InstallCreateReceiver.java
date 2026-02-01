package com.android.ddmlib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class InstallCreateReceiver extends InstallReceiver {
    private static final String LOG_TAG = "InstallCreateReceiver";
    private static final Pattern successPattern = Pattern.compile("Success: .*\\[(\\d*)\\]");
    private String mSessionId = null;

    public String getSessionId() {
        if (getSuccessMessage() == null) {
            return null;
        }
        String successMessage = getSuccessMessage();
        Matcher matcher = successPattern.matcher(successMessage);
        if (matcher.matches()) {
            this.mSessionId = matcher.group(1);
        } else {
            this.mSessionId = null;
            Log.e(LOG_TAG, String.format("Output '%s' doesn't provide session id", successMessage));
        }
        return this.mSessionId;
    }
}
