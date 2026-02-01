package com.google.firebase.messaging;

import java.util.Locale;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
public final class SendException extends Exception {
    public static final int ERROR_INVALID_PARAMETERS = 1;
    public static final int ERROR_SIZE = 2;
    public static final int ERROR_TOO_MANY_MESSAGES = 4;
    public static final int ERROR_TTL_EXCEEDED = 3;
    public static final int ERROR_UNKNOWN = 0;
    private final int errorCode;

    SendException(String str) {
        super(str);
        this.errorCode = parseErrorCode(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int parseErrorCode(String str) {
        char c;
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        switch (lowerCase.hashCode()) {
            case -1743242157:
                if (!lowerCase.equals("service_not_available")) {
                    c = 65535;
                    break;
                } else {
                    c = 3;
                    break;
                }
            case -1290953729:
                if (lowerCase.equals("toomanymessages")) {
                    c = 4;
                    break;
                }
                break;
            case -920906446:
                if (lowerCase.equals("invalid_parameters")) {
                    c = 0;
                    break;
                }
                break;
            case -617027085:
                if (lowerCase.equals("messagetoobig")) {
                    c = 2;
                    break;
                }
                break;
            case -95047692:
                if (lowerCase.equals("missing_to")) {
                    c = 1;
                    break;
                }
                break;
        }
        if (c == 0 || c == 1) {
            return 1;
        }
        if (c == 2) {
            return 2;
        }
        if (c != 3) {
            return c != 4 ? 0 : 4;
        }
        return 3;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
