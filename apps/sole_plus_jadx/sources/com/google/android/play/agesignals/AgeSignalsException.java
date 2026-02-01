package com.google.android.play.agesignals;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
public class AgeSignalsException extends ApiException {
    public AgeSignalsException(int i) {
        super(new Status(i, String.format(Locale.getDefault(), "Age Signals Error: %d", Integer.valueOf(i))));
        if (i == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }

    public AgeSignalsException(Status status) {
        super(status);
    }
}
