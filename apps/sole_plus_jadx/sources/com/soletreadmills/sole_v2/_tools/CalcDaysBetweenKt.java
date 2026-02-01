package com.soletreadmills.sole_v2._tools;

import androidx.compose.material3.CalendarModelKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import timber.log.Timber;

/* compiled from: CalcDaysBetween.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001¨\u0006\b"}, d2 = {"calcDaysBetweenRound", "", "startMillis", "endMillis", "formatDurationText", "", "startTimeMillis", "endTimeMillis", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CalcDaysBetweenKt {
    public static final String formatDurationText(long j, long j2) {
        long j3 = j2 - j;
        long jCalcDaysBetweenRound = calcDaysBetweenRound(j, j2);
        Timber.INSTANCE.d("durationMillis:" + j3, new Object[0]);
        Timber.INSTANCE.d("formatDurationText:" + jCalcDaysBetweenRound, new Object[0]);
        if (j3 >= CalendarModelKt.MillisecondsIn24Hours) {
            return jCalcDaysBetweenRound == 1 ? "1 day left" : jCalcDaysBetweenRound + " days left";
        }
        long jMax = Math.max(1L, j3 / 3600000);
        return jMax == 1 ? "1 hour left" : jMax + " hours left";
    }

    public static final long calcDaysBetweenRound(long j, long j2) {
        long j3 = j2 - j;
        if (j3 <= 0) {
            return 1L;
        }
        long days = TimeUnit.MILLISECONDS.toDays(j3);
        return j3 % TimeUnit.DAYS.toMillis(1L) > 0 ? days + 1 : days;
    }
}
