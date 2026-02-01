package com.google.android.play.agesignals;

import com.google.android.play.agesignals.AgeSignalsResult;
import java.util.Date;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
final class zzh extends AgeSignalsResult.Builder {
    private Integer zza;
    private Integer zzb;
    private Integer zzc;
    private Date zzd;
    private String zze;

    @Override // com.google.android.play.agesignals.AgeSignalsResult.Builder
    public final AgeSignalsResult build() {
        return new zzj(this.zza, this.zzb, this.zzc, this.zzd, this.zze, null);
    }

    @Override // com.google.android.play.agesignals.AgeSignalsResult.Builder
    public final AgeSignalsResult.Builder setAgeLower(Integer num) {
        this.zzb = num;
        return this;
    }

    @Override // com.google.android.play.agesignals.AgeSignalsResult.Builder
    public final AgeSignalsResult.Builder setAgeUpper(Integer num) {
        this.zzc = num;
        return this;
    }

    @Override // com.google.android.play.agesignals.AgeSignalsResult.Builder
    public final AgeSignalsResult.Builder setInstallId(String str) {
        this.zze = str;
        return this;
    }

    @Override // com.google.android.play.agesignals.AgeSignalsResult.Builder
    public final AgeSignalsResult.Builder setMostRecentApprovalDate(Date date) {
        this.zzd = date;
        return this;
    }

    @Override // com.google.android.play.agesignals.AgeSignalsResult.Builder
    public final AgeSignalsResult.Builder setUserStatus(Integer num) {
        this.zza = num;
        return this;
    }
}
