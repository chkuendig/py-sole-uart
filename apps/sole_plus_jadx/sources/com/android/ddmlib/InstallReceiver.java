package com.android.ddmlib;

import androidx.health.connect.client.records.metadata.DeviceTypes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class InstallReceiver extends MultiLineReceiver {
    private static final Pattern FAILURE_PATTERN = Pattern.compile("Failure\\s+\\[(([^:]*)(:.*)?)\\]");
    private static final String SUCCESS_OUTPUT = "Success";
    private String mErrorMessage = null;
    private String mSuccessMessage = null;
    private String mErrorCode = null;
    private boolean mSuccessfullyCompleted = false;

    @Override // com.android.ddmlib.IShellOutputReceiver
    public boolean isCancelled() {
        return false;
    }

    @Override // com.android.ddmlib.MultiLineReceiver
    public void processNewLines(String[] lines) {
        for (String str : lines) {
            if (!str.isEmpty()) {
                if (str.startsWith(SUCCESS_OUTPUT)) {
                    this.mSuccessfullyCompleted = true;
                    this.mErrorMessage = null;
                    this.mSuccessMessage = str;
                    return;
                }
                Matcher matcher = FAILURE_PATTERN.matcher(str);
                if (matcher.matches()) {
                    this.mErrorMessage = matcher.group(1);
                    this.mErrorCode = matcher.group(2);
                    this.mSuccessMessage = null;
                    this.mSuccessfullyCompleted = false;
                    return;
                }
                if (this.mErrorMessage == null) {
                    this.mErrorMessage = "Unknown failure: " + str;
                    this.mErrorCode = DeviceTypes.UNKNOWN;
                } else {
                    this.mErrorMessage += "\n" + str;
                }
            }
        }
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public String getSuccessMessage() {
        return this.mSuccessMessage;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public boolean isSuccessfullyCompleted() {
        return this.mSuccessfullyCompleted;
    }

    @Override // com.android.ddmlib.MultiLineReceiver
    public void done() {
        super.done();
        if (this.mErrorMessage == null) {
            this.mSuccessfullyCompleted = true;
        }
    }
}
