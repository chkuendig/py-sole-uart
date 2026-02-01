package com.google.android.play.agesignals;

import android.os.Bundle;
import java.util.Date;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
public abstract class AgeSignalsResult {

    /* compiled from: com.google.android.play:age-signals@@0.0.2 */
    public static abstract class Builder {
        public abstract AgeSignalsResult build();

        public abstract Builder setAgeLower(Integer num);

        public abstract Builder setAgeUpper(Integer num);

        public abstract Builder setInstallId(String str);

        public abstract Builder setMostRecentApprovalDate(Date date);

        public abstract Builder setUserStatus(Integer num);
    }

    public static Builder builder() {
        return new zzh();
    }

    public static AgeSignalsResult zza(Bundle bundle) {
        if (!bundle.containsKey("user.status")) {
            return builder().build();
        }
        Builder builder = builder();
        builder.setUserStatus(zzb(bundle, "user.status"));
        builder.setAgeLower(zzb(bundle, "age.range.lower"));
        builder.setAgeUpper(zzb(bundle, "age.range.upper"));
        builder.setMostRecentApprovalDate(bundle.containsKey("most.recent.approval.date") ? new Date(bundle.getLong("most.recent.approval.date")) : null);
        builder.setInstallId(bundle.containsKey("install.id") ? bundle.getString("install.id") : null);
        return builder.build();
    }

    private static Integer zzb(Bundle bundle, String str) {
        if (bundle.containsKey(str)) {
            return Integer.valueOf(bundle.getInt(str));
        }
        return null;
    }

    public abstract Integer ageLower();

    public abstract Integer ageUpper();

    public abstract String installId();

    public abstract Date mostRecentApprovalDate();

    public abstract Integer userStatus();
}
