package com.google.android.play.agesignals;

import com.android.SdkConstants;
import java.util.Date;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
final class zzj extends AgeSignalsResult {
    private final Integer zza;
    private final Integer zzb;
    private final Integer zzc;
    private final Date zzd;
    private final String zze;

    /* synthetic */ zzj(Integer num, Integer num2, Integer num3, Date date, String str, zzi zziVar) {
        this.zza = num;
        this.zzb = num2;
        this.zzc = num3;
        this.zzd = date;
        this.zze = str;
    }

    @Override // com.google.android.play.agesignals.AgeSignalsResult
    public final Integer ageLower() {
        return this.zzb;
    }

    @Override // com.google.android.play.agesignals.AgeSignalsResult
    public final Integer ageUpper() {
        return this.zzc;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AgeSignalsResult) {
            AgeSignalsResult ageSignalsResult = (AgeSignalsResult) obj;
            Integer num = this.zza;
            if (num != null ? num.equals(ageSignalsResult.userStatus()) : ageSignalsResult.userStatus() == null) {
                Integer num2 = this.zzb;
                if (num2 != null ? num2.equals(ageSignalsResult.ageLower()) : ageSignalsResult.ageLower() == null) {
                    Integer num3 = this.zzc;
                    if (num3 != null ? num3.equals(ageSignalsResult.ageUpper()) : ageSignalsResult.ageUpper() == null) {
                        Date date = this.zzd;
                        if (date != null ? date.equals(ageSignalsResult.mostRecentApprovalDate()) : ageSignalsResult.mostRecentApprovalDate() == null) {
                            String str = this.zze;
                            if (str != null ? str.equals(ageSignalsResult.installId()) : ageSignalsResult.installId() == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.play.agesignals.AgeSignalsResult
    public final String installId() {
        return this.zze;
    }

    @Override // com.google.android.play.agesignals.AgeSignalsResult
    public final Date mostRecentApprovalDate() {
        return this.zzd;
    }

    public final String toString() {
        return "AgeSignalsResult{userStatus=" + this.zza + ", ageLower=" + this.zzb + ", ageUpper=" + this.zzc + ", mostRecentApprovalDate=" + String.valueOf(this.zzd) + ", installId=" + this.zze + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
    }

    @Override // com.google.android.play.agesignals.AgeSignalsResult
    public final Integer userStatus() {
        return this.zza;
    }

    public final int hashCode() {
        Integer num = this.zza;
        int iHashCode = num == null ? 0 : num.hashCode();
        Integer num2 = this.zzb;
        int iHashCode2 = num2 == null ? 0 : num2.hashCode();
        int i = iHashCode ^ 1000003;
        Integer num3 = this.zzc;
        int iHashCode3 = ((((i * 1000003) ^ iHashCode2) * 1000003) ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
        Date date = this.zzd;
        int iHashCode4 = (iHashCode3 ^ (date == null ? 0 : date.hashCode())) * 1000003;
        String str = this.zze;
        return iHashCode4 ^ (str != null ? str.hashCode() : 0);
    }
}
