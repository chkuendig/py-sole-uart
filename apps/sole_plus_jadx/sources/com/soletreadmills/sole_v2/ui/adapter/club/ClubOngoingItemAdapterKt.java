package com.soletreadmills.sole_v2.ui.adapter.club;

import android.content.Context;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberData;
import com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeVirtualRaceFailReasonSettings;
import com.soletreadmills.sole_v2._data.club.VirtualRaceCodeType;
import com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragmentKt;
import java.text.DecimalFormat;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* compiled from: ClubOngoingItemAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b\u001aG\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b¢\u0006\u0002\u0010\u0012\u001a9\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0017\u001a$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\n\u001a\u0010\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\n\u001a\u0010\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001a\u001a\u000e\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0001¨\u0006#²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"calculateDaysDifference", "", "startTimeMillis", "", "endTimeMillis", "calculateHoursDifference", "calculateProgressPercent", "useHourly", "", "getCurrentScoreVal", "", "currentScore", "", "scoreItem", "challengeType", "isShowTimer", "isFixZero", "isKeepMi", "(Ljava/lang/Double;ILjava/lang/Integer;ZZZ)Ljava/lang/String;", "getGoalColors", "Lkotlin/Triple;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;ILjava/lang/Integer;)Lkotlin/Triple;", "getRankingList", "", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "list", "myGlobalId", "getVirtualRaceVal", "virtualRaceCode", "isRaceShowMemberList", "myData", "secToHours", "seconds", "app_release", "intFormat", "Ljava/text/DecimalFormat;", "doubleFormat"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubOngoingItemAdapterKt {
    public static final double secToHours(int i) {
        return i / 3600.0d;
    }

    public static /* synthetic */ String getCurrentScoreVal$default(Double d, int i, Integer num, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        return getCurrentScoreVal(d, i, num, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? false : z3);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String getCurrentScoreVal(java.lang.Double r6, int r7, java.lang.Integer r8, boolean r9, final boolean r10, boolean r11) {
        /*
            com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$intFormat$2 r0 = new kotlin.jvm.functions.Function0<java.text.DecimalFormat>() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$intFormat$2
                static {
                    /*
                        com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$intFormat$2 r0 = new com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$intFormat$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$intFormat$2) com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$intFormat$2.INSTANCE com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$intFormat$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$intFormat$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$intFormat$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.text.DecimalFormat invoke() {
                    /*
                        r1 = this;
                        java.text.DecimalFormat r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$intFormat$2.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.text.DecimalFormat invoke() {
                    /*
                        r3 = this;
                        java.text.DecimalFormat r0 = new java.text.DecimalFormat
                        java.util.Locale r1 = java.util.Locale.US
                        java.text.DecimalFormatSymbols r1 = java.text.DecimalFormatSymbols.getInstance(r1)
                        java.lang.String r2 = "#0"
                        r0.<init>(r2, r1)
                        java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP
                        r0.setRoundingMode(r1)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$intFormat$2.invoke():java.text.DecimalFormat");
                }
            }
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            kotlin.Lazy r0 = kotlin.LazyKt.lazy(r0)
            com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$doubleFormat$2 r1 = new com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt$getCurrentScoreVal$doubleFormat$2
            r1.<init>()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.Lazy r10 = kotlin.LazyKt.lazy(r1)
            r1 = 0
            if (r6 == 0) goto L1c
            double r3 = r6.doubleValue()
            goto L1d
        L1c:
            r3 = r1
        L1d:
            com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings r5 = com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings.TOTAL_CALORIES
            int r5 = r5.getId()
            if (r7 != r5) goto L26
            goto L2e
        L26:
            com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings r5 = com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings.SESSION
            int r5 = r5.getId()
            if (r7 != r5) goto L3b
        L2e:
            java.text.DecimalFormat r6 = getCurrentScoreVal$lambda$0(r0)
            java.lang.String r6 = r6.format(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            goto Le1
        L3b:
            com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings r0 = com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings.TOTAL_DISTANCE
            int r0 = r0.getId()
            if (r7 != r0) goto L8e
            com.soletreadmills.sole_v2.Global r6 = com.soletreadmills.sole_v2.Global.INSTANCE
            boolean r6 = r6.getUnitType()
            if (r6 != 0) goto L4d
            if (r11 == 0) goto L82
        L4d:
            kotlin.Result$Companion r6 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L66
            com.soletreadmills.sole_v2._tools.UnitConversion r6 = com.soletreadmills.sole_v2._tools.UnitConversion.INSTANCE     // Catch: java.lang.Throwable -> L66
            java.lang.String r7 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L66
            java.lang.String r6 = r6.getMi(r7)     // Catch: java.lang.Throwable -> L66
            double r6 = java.lang.Double.parseDouble(r6)     // Catch: java.lang.Throwable -> L66
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch: java.lang.Throwable -> L66
            java.lang.Object r6 = kotlin.Result.m9087constructorimpl(r6)     // Catch: java.lang.Throwable -> L66
            goto L71
        L66:
            r6 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m9087constructorimpl(r6)
        L71:
            java.lang.Double r7 = java.lang.Double.valueOf(r1)
            boolean r8 = kotlin.Result.m9093isFailureimpl(r6)
            if (r8 == 0) goto L7c
            r6 = r7
        L7c:
            java.lang.Number r6 = (java.lang.Number) r6
            double r3 = r6.doubleValue()
        L82:
            java.text.DecimalFormat r6 = getCurrentScoreVal$lambda$1(r10)
            java.lang.String r6 = r6.format(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            goto Le1
        L8e:
            com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings r11 = com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings.TOTAL_TIME
            int r11 = r11.getId()
            java.lang.String r0 = "-"
            if (r7 != r11) goto Le0
            if (r6 == 0) goto Ldb
            com.soletreadmills.sole_v2._tools.UnitConversion r7 = com.soletreadmills.sole_v2._tools.UnitConversion.INSTANCE
            double r0 = r6.doubleValue()
            int r11 = (int) r0
            java.lang.String r7 = r7.secToTimeMinute(r11)
            if (r9 == 0) goto La8
            goto Lc7
        La8:
            com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings r9 = com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings.RANKING
            int r9 = r9.getId()
            if (r8 != 0) goto Lb1
            goto Lb7
        Lb1:
            int r11 = r8.intValue()
            if (r11 == r9) goto Lc9
        Lb7:
            com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings r9 = com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings.GOAL
            int r9 = r9.getId()
            if (r8 != 0) goto Lc0
            goto Lc7
        Lc0:
            int r8 = r8.intValue()
            if (r8 != r9) goto Lc7
            goto Lc9
        Lc7:
            r6 = r7
            goto Ldc
        Lc9:
            double r6 = r6.doubleValue()
            int r6 = (int) r6
            double r6 = secToHours(r6)
            java.text.DecimalFormat r8 = getCurrentScoreVal$lambda$1(r10)
            java.lang.String r6 = r8.format(r6)
            goto Ldc
        Ldb:
            r6 = r0
        Ldc:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            goto Le1
        Le0:
            r6 = r0
        Le1:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt.getCurrentScoreVal(java.lang.Double, int, java.lang.Integer, boolean, boolean, boolean):java.lang.String");
    }

    private static final DecimalFormat getCurrentScoreVal$lambda$0(Lazy<? extends DecimalFormat> lazy) {
        return lazy.getValue();
    }

    private static final DecimalFormat getCurrentScoreVal$lambda$1(Lazy<? extends DecimalFormat> lazy) {
        return lazy.getValue();
    }

    public static final boolean isRaceShowMemberList(ChallengeMemberData challengeMemberData) {
        if (challengeMemberData != null && challengeMemberData.isPassForVirtualRace()) {
            Integer virtualRaceFailReason = challengeMemberData.getVirtualRaceFailReason();
            int id2 = ChallengeVirtualRaceFailReasonSettings.USER_DELETE_WORKOUT.getId();
            if (virtualRaceFailReason == null || virtualRaceFailReason.intValue() != id2) {
                return true;
            }
        }
        return false;
    }

    public static final int calculateDaysDifference(long j, long j2) {
        return (int) ChronoUnit.DAYS.between(new Date(j).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(j2).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public static final long calculateHoursDifference(long j, long j2) {
        return (j2 - j) / 3600000;
    }

    public static /* synthetic */ int calculateProgressPercent$default(long j, long j2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return calculateProgressPercent(j, j2, z);
    }

    public static final int calculateProgressPercent(long j, long j2, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z) {
            long jCalculateHoursDifference = calculateHoursDifference(j, j2) + 1;
            long jCalculateHoursDifference2 = calculateHoursDifference(j, jCurrentTimeMillis) + 1;
            if (jCalculateHoursDifference <= 0) {
                return 0;
            }
            return MathKt.roundToInt(RangesKt.coerceIn((jCalculateHoursDifference2 / jCalculateHoursDifference) * 100.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 100.0d));
        }
        int iCalculateDaysDifference = calculateDaysDifference(j, j2) + 1;
        int iCalculateDaysDifference2 = calculateDaysDifference(j, jCurrentTimeMillis) + 1;
        if (iCalculateDaysDifference <= 0) {
            return 0;
        }
        return MathKt.roundToInt(RangesKt.coerceIn((iCalculateDaysDifference2 / iCalculateDaysDifference) * 100.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 100.0d));
    }

    public static final List<ChallengeMemberData> getRankingList(List<ChallengeMemberData> list, String str) {
        Intrinsics.checkNotNullParameter(list, "list");
        int iCoerceAtLeast = 0;
        Timber.INSTANCE.d("list.take():" + list, new Object[0]);
        if (list.size() <= 3) {
            List<ChallengeMemberData> mutableList = CollectionsKt.toMutableList((Collection) list);
            while (mutableList.size() < 3) {
                mutableList.add(ClubEventDetailFragmentKt.createPlaceholderMember());
            }
            return mutableList;
        }
        Iterator<ChallengeMemberData> it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().getGlobalUserUuid(), str)) {
                break;
            }
            i++;
        }
        if (i == -1 || str == null || Intrinsics.areEqual(list.get(i).getCurrentScore(), AudioStats.AUDIO_AMPLITUDE_NONE)) {
            List<ChallengeMemberData> list2 = list;
            Timber.INSTANCE.d("list.take(3):" + CollectionsKt.take(list2, 3), new Object[0]);
            return CollectionsKt.take(list2, 3);
        }
        int i2 = i + 1;
        if (i2 < list.size() && Intrinsics.areEqual(list.get(i2).getCurrentScore(), AudioStats.AUDIO_AMPLITUDE_NONE) && i > 0) {
            i--;
        }
        int i3 = i - 1;
        if (i3 >= 0) {
            iCoerceAtLeast = i + 1 >= list.size() ? RangesKt.coerceAtLeast(list.size() - 3, 0) : i3;
        }
        return list.subList(iCoerceAtLeast, RangesKt.coerceAtMost(iCoerceAtLeast + 3, list.size()));
    }

    public static /* synthetic */ Triple getGoalColors$default(Context context, int i, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        return getGoalColors(context, i, num);
    }

    public static final Triple<Integer, Integer, Integer> getGoalColors(Context context, int i, Integer num) {
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(context, "context");
        int id2 = ChallengeTypeSettings.VIRTUAL_RACE.getId();
        if (num != null && num.intValue() == id2) {
            int i5 = R.color.colorStats_speed;
            int i6 = R.color.colorStats_speed25;
            int i7 = R.color.colorStats_speed66;
            return new Triple<>(Integer.valueOf(ContextCompat.getColor(context, i5)), Integer.valueOf(ContextCompat.getColor(context, i6)), Integer.valueOf(ContextCompat.getColor(context, i7)));
        }
        if (i == ChallengeScoreItemSettings.TOTAL_DISTANCE.getId()) {
            i2 = R.color.colorStats_distance;
            i3 = R.color.colorStats_distance25;
            i4 = R.color.colorStats_distance66;
        } else if (i == ChallengeScoreItemSettings.TOTAL_TIME.getId()) {
            i2 = R.color.colorStats_time;
            i3 = R.color.colorStats_time25;
            i4 = R.color.colorStats_time66;
        } else if (i == ChallengeScoreItemSettings.SESSION.getId()) {
            i2 = R.color.colorStats_speed;
            i3 = R.color.colorStats_speed25;
            i4 = R.color.colorStats_speed66;
        } else {
            i2 = R.color.colorStats_calories;
            i3 = R.color.colorStats_calories25;
            i4 = R.color.colorStats_calories66;
        }
        return new Triple<>(Integer.valueOf(ContextCompat.getColor(context, i2)), Integer.valueOf(ContextCompat.getColor(context, i3)), Integer.valueOf(ContextCompat.getColor(context, i4)));
    }

    public static final int getVirtualRaceVal(String str) {
        VirtualRaceCodeType virtualRaceCodeTypeFromCode = str != null ? VirtualRaceCodeType.INSTANCE.fromCode(str) : null;
        if (virtualRaceCodeTypeFromCode != null) {
            return virtualRaceCodeTypeFromCode.getDistanceKm();
        }
        return 0;
    }
}
