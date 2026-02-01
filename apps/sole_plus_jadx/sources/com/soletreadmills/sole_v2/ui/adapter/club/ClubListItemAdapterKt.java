package com.soletreadmills.sole_v2.ui.adapter.club;

import android.content.Context;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.ChallengeMachineTypeItems;
import com.soletreadmills.sole_v2._tools.TimeTools;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClubListItemAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u001d\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015\u001aO\u0010\u0016\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"calcDaysBetween", "", "startMillis", "endMillis", "formatCountdownToEndLabel", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "endTimeMillis", "eventTimeZoneId", "deviceTimeZone", "Ljava/util/TimeZone;", "isVirtualRace", "", "formatDifferentTimeZoneLabel", "startTimeMillis", "timeZone", "formatStartLabel", "getChallengeEquipmentText", "machineTypeId", "", "(Landroid/content/Context;Ljava/lang/Integer;)Ljava/lang/String;", "getUnitText", "scoreItem", "isImperial", "isNotSingular", "challengeType", "isShowTimer", "isKeepMi", "(Landroid/content/Context;IZZLjava/lang/Integer;ZZ)Ljava/lang/String;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubListItemAdapterKt {
    private static final long calcDaysBetween(long j, long j2) {
        return TimeUnit.MILLISECONDS.toDays(j2 - j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatStartLabel(Context context, long j, boolean z) {
        String string;
        LocalDate localDateNow = LocalDate.now();
        LocalDate localDate = Instant.ofEpochMilli(j).atZone(ZoneId.systemDefault()).toLocalDate();
        if (localDate.isEqual(localDateNow)) {
            if (z) {
                string = context.getString(R.string.today);
            } else {
                string = context.getString(R.string.from_today);
            }
            Intrinsics.checkNotNull(string);
        } else if (localDate.isEqual(localDateNow.plusDays(1L))) {
            if (z) {
                string = context.getString(R.string.tomorrow);
            } else {
                string = context.getString(R.string.from_tomorrow);
            }
            Intrinsics.checkNotNull(string);
        } else {
            DateTimeFormatter dateTimeFormatterWithLocale = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault());
            String string2 = context.getString(R.string.from);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            if (z) {
                string = localDate.format(dateTimeFormatterWithLocale);
            } else {
                string = string2 + ' ' + localDate.format(dateTimeFormatterWithLocale);
            }
            Intrinsics.checkNotNull(string);
        }
        return string;
    }

    public static final String formatDifferentTimeZoneLabel(Context context, long j, TimeZone timeZone, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance(timeZone);
        boolean z2 = calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        Object objClone = calendar2.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar3 = (Calendar) objClone;
        calendar3.add(6, 1);
        boolean z3 = calendar.get(1) == calendar3.get(1) && calendar.get(6) == calendar3.get(6);
        String offsetTime02 = TimeTools.INSTANCE.formatOffsetTime02(j);
        if (z2) {
            String string = context.getString(R.string.today);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (z) {
                return context.getString(R.string.from) + ' ' + offsetTime02 + ' ' + string;
            }
            return context.getString(R.string.from) + ' ' + offsetTime02 + ' ' + string;
        }
        if (z3) {
            String string2 = context.getString(R.string.tomorrow);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            if (z) {
                return context.getString(R.string.from) + ' ' + offsetTime02 + ' ' + string2;
            }
            return context.getString(R.string.from) + ' ' + offsetTime02 + ' ' + string2;
        }
        String toTimeByTimeMillis05 = TimeTools.INSTANCE.formatToTimeByTimeMillis05(Long.valueOf(j));
        if (z) {
            return context.getString(R.string.from) + ' ' + offsetTime02 + ' ' + toTimeByTimeMillis05;
        }
        return context.getString(R.string.from) + ' ' + offsetTime02 + ' ' + toTimeByTimeMillis05;
    }

    public static final String formatCountdownToEndLabel(Context context, long j, String eventTimeZoneId, TimeZone deviceTimeZone, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventTimeZoneId, "eventTimeZoneId");
        Intrinsics.checkNotNullParameter(deviceTimeZone, "deviceTimeZone");
        TimeZone timeZone = TimeZone.getTimeZone(eventTimeZoneId);
        Calendar.getInstance(timeZone).setTimeInMillis(j);
        Calendar calendar = Calendar.getInstance(timeZone);
        if (j <= calendar.getTimeInMillis() || Intrinsics.areEqual(timeZone.getID(), deviceTimeZone.getID())) {
            return "11:59 PM";
        }
        calendar.getTimeInMillis();
        return String.valueOf(TimeTools.INSTANCE.formatOffsetTime(context, j));
    }

    public static /* synthetic */ String getUnitText$default(Context context, int i, boolean z, boolean z2, Integer num, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        boolean z5 = z2;
        if ((i2 & 16) != 0) {
            num = null;
        }
        return getUnitText(context, i, z, z5, num, (i2 & 32) != 0 ? false : z3, (i2 & 64) != 0 ? false : z4);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String getUnitText(android.content.Context r3, int r4, boolean r5, boolean r6, java.lang.Integer r7, boolean r8, boolean r9) {
        /*
            java.lang.String r0 = ""
            if (r3 != 0) goto L5
            return r0
        L5:
            com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings r1 = com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings.TOTAL_CALORIES
            int r1 = r1.getId()
            java.lang.String r2 = "getString(...)"
            if (r4 != r1) goto L1a
            int r4 = com.soletreadmills.sole_v2.R.string.kcal
            java.lang.String r0 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            goto L9c
        L1a:
            com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings r1 = com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings.TOTAL_DISTANCE
            int r1 = r1.getId()
            if (r4 != r1) goto L3a
            if (r5 != 0) goto L2e
            if (r9 == 0) goto L27
            goto L2e
        L27:
            int r4 = com.soletreadmills.sole_v2.R.string.km
            java.lang.String r3 = r3.getString(r4)
            goto L34
        L2e:
            int r4 = com.soletreadmills.sole_v2.R.string.mi
            java.lang.String r3 = r3.getString(r4)
        L34:
            r0 = r3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            goto L9c
        L3a:
            com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings r5 = com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings.TOTAL_TIME
            int r5 = r5.getId()
            if (r4 != r5) goto L77
            if (r8 == 0) goto L45
            goto L9c
        L45:
            com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings r4 = com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings.RANKING
            int r4 = r4.getId()
            if (r7 != 0) goto L4e
            goto L54
        L4e:
            int r5 = r7.intValue()
            if (r5 == r4) goto L63
        L54:
            com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings r4 = com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings.GOAL
            int r4 = r4.getId()
            if (r7 != 0) goto L5d
            goto L73
        L5d:
            int r5 = r7.intValue()
            if (r5 != r4) goto L73
        L63:
            if (r6 == 0) goto L6c
            int r4 = com.soletreadmills.sole_v2.R.string.hours
            java.lang.String r3 = r3.getString(r4)
            goto L72
        L6c:
            int r4 = com.soletreadmills.sole_v2.R.string.hour
            java.lang.String r3 = r3.getString(r4)
        L72:
            r0 = r3
        L73:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            goto L9c
        L77:
            com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings r5 = com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings.SESSION
            int r5 = r5.getId()
            if (r4 != r5) goto L93
            if (r6 == 0) goto L88
            int r4 = com.soletreadmills.sole_v2.R.string.sessions_title
            java.lang.String r3 = r3.getString(r4)
            goto L8e
        L88:
            int r4 = com.soletreadmills.sole_v2.R.string.session
            java.lang.String r3 = r3.getString(r4)
        L8e:
            r0 = r3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            goto L9c
        L93:
            int r4 = com.soletreadmills.sole_v2.R.string.virtual_race
            java.lang.String r0 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
        L9c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapterKt.getUnitText(android.content.Context, int, boolean, boolean, java.lang.Integer, boolean, boolean):java.lang.String");
    }

    public static final String getChallengeEquipmentText(Context context, Integer num) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(num, ChallengeMachineTypeItems.ALL_MACHINE.getId())) {
            String string = context.getString(R.string.any_device);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (Intrinsics.areEqual(num, ChallengeMachineTypeItems.TREADMILL.getId())) {
            String string2 = context.getString(R.string.treadmill);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (Intrinsics.areEqual(num, ChallengeMachineTypeItems.BIKE.getId())) {
            String string3 = context.getString(R.string.bike);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (Intrinsics.areEqual(num, ChallengeMachineTypeItems.CROSS_TRAINER.getId())) {
            String string4 = context.getString(R.string.elliptical);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        if (Intrinsics.areEqual(num, ChallengeMachineTypeItems.ROWER.getId())) {
            String string5 = context.getString(R.string.rower);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        }
        String string6 = context.getString(R.string.any_device);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        return string6;
    }
}
