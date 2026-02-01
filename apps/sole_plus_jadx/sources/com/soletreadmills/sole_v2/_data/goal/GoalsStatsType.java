package com.soletreadmills.sole_v2._data.goal;

import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import timber.log.Timber;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GoalsStatsType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/goal/GoalsStatsType;", "", "id", "", "stringTitleId", "stringUnitId", "stringFormTitleId", "(Ljava/lang/String;IIIII)V", "getId", "()I", "getStringFormTitleId", "getStringTitleId", "getStringUnitId", "TotalDistance", "ActiveMinutes", "WorkoutCounts", "TotalCalories", "TotalSteps", "TotalStrokes", "TotalElevation", "SRVOReps", "SRVOSets", "SRVOPounds", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalsStatsType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GoalsStatsType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int id;
    private final int stringFormTitleId;
    private final int stringTitleId;
    private final int stringUnitId;
    public static final GoalsStatsType TotalDistance = new GoalsStatsType("TotalDistance", 0, 1, R.string.distance, R.string.km, R.string.distance);
    public static final GoalsStatsType ActiveMinutes = new GoalsStatsType("ActiveMinutes", 1, 11, R.string.hours_title, R.string.hours, R.string.active_time);
    public static final GoalsStatsType WorkoutCounts = new GoalsStatsType("WorkoutCounts", 2, 21, R.string.sessions_title, R.string.sessions, R.string.sessions_title);
    public static final GoalsStatsType TotalCalories = new GoalsStatsType("TotalCalories", 3, 31, R.string.calories, R.string.kcal, R.string.calories);
    public static final GoalsStatsType TotalSteps = new GoalsStatsType("TotalSteps", 4, 51, R.string.steps, R.string.steps_02, R.string.steps);
    public static final GoalsStatsType TotalStrokes = new GoalsStatsType("TotalStrokes", 5, 61, R.string.strokes, R.string.strokes_02, R.string.strokes);
    public static final GoalsStatsType TotalElevation = new GoalsStatsType("TotalElevation", 6, 41, R.string.empty_text, R.string.empty_text, R.string.empty_text);
    public static final GoalsStatsType SRVOReps = new GoalsStatsType("SRVOReps", 7, 71, R.string.srvo, R.string.empty_text, R.string.empty_text);
    public static final GoalsStatsType SRVOSets = new GoalsStatsType("SRVOSets", 8, 72, R.string.srvo, R.string.empty_text, R.string.empty_text);
    public static final GoalsStatsType SRVOPounds = new GoalsStatsType("SRVOPounds", 9, 73, R.string.srvo, R.string.empty_text, R.string.empty_text);

    private static final /* synthetic */ GoalsStatsType[] $values() {
        return new GoalsStatsType[]{TotalDistance, ActiveMinutes, WorkoutCounts, TotalCalories, TotalSteps, TotalStrokes, TotalElevation, SRVOReps, SRVOSets, SRVOPounds};
    }

    public static EnumEntries<GoalsStatsType> getEntries() {
        return $ENTRIES;
    }

    public static GoalsStatsType valueOf(String str) {
        return (GoalsStatsType) Enum.valueOf(GoalsStatsType.class, str);
    }

    public static GoalsStatsType[] values() {
        return (GoalsStatsType[]) $VALUES.clone();
    }

    private GoalsStatsType(String str, int i, int i2, int i3, int i4, int i5) {
        this.id = i2;
        this.stringTitleId = i3;
        this.stringUnitId = i4;
        this.stringFormTitleId = i5;
    }

    public final int getId() {
        return this.id;
    }

    public final int getStringTitleId() {
        return this.stringTitleId;
    }

    public final int getStringUnitId() {
        return this.stringUnitId;
    }

    public final int getStringFormTitleId() {
        return this.stringFormTitleId;
    }

    static {
        GoalsStatsType[] goalsStatsTypeArr$values = $values();
        $VALUES = goalsStatsTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(goalsStatsTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: GoalsStatsType.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/goal/GoalsStatsType$Companion;", "", "()V", "getFormTitleId", "", "id", "defaultStringId", "getTitleUnitId", "goalTimeFrameId", "getUnitId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ int getFormTitleId$default(Companion companion, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i2 = R.string.dashed_text;
            }
            return companion.getFormTitleId(i, i2);
        }

        public final int getFormTitleId(int id2, int defaultStringId) {
            GoalsStatsType next;
            Iterator<GoalsStatsType> it = GoalsStatsType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getId() == id2) {
                    break;
                }
            }
            GoalsStatsType goalsStatsType = next;
            return goalsStatsType == null ? defaultStringId : goalsStatsType.getStringFormTitleId();
        }

        public static /* synthetic */ int getTitleUnitId$default(Companion companion, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                i3 = R.string.dashed_text;
            }
            return companion.getTitleUnitId(i, i2, i3);
        }

        public final int getTitleUnitId(int id2, int goalTimeFrameId, int defaultStringId) {
            GoalsStatsType next;
            Iterator<GoalsStatsType> it = GoalsStatsType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getId() == id2) {
                    break;
                }
            }
            GoalsStatsType goalsStatsType = next;
            if (goalsStatsType == null) {
                return defaultStringId;
            }
            if (goalsStatsType == GoalsStatsType.ActiveMinutes) {
                if (goalTimeFrameId == GoalTimeFrame.Daily.getId()) {
                    return R.string.minutes_title;
                }
                if (goalTimeFrameId != GoalTimeFrame.Weekly.getId() && goalTimeFrameId != GoalTimeFrame.Monthly.getId()) {
                    return R.string.hour;
                }
                return R.string.hours_title;
            }
            return goalsStatsType.getStringTitleId();
        }

        public static /* synthetic */ int getUnitId$default(Companion companion, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                i3 = R.string.dashed_text;
            }
            return companion.getUnitId(i, i2, i3);
        }

        public final int getUnitId(int id2, int goalTimeFrameId, int defaultStringId) {
            GoalsStatsType next;
            Timber.INSTANCE.d("GoalsStatsType:" + id2, new Object[0]);
            Timber.INSTANCE.d("goalTimeFrameId:" + goalTimeFrameId, new Object[0]);
            Iterator<GoalsStatsType> it = GoalsStatsType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getId() == id2) {
                    break;
                }
            }
            GoalsStatsType goalsStatsType = next;
            if (goalsStatsType == null) {
                return defaultStringId;
            }
            if (goalsStatsType == GoalsStatsType.ActiveMinutes) {
                if (goalTimeFrameId == GoalTimeFrame.Daily.getId()) {
                    return R.string.minutes;
                }
                if (goalTimeFrameId != GoalTimeFrame.Weekly.getId() && goalTimeFrameId != GoalTimeFrame.Monthly.getId()) {
                    return R.string.hour;
                }
                return R.string.hours;
            }
            if (goalsStatsType == GoalsStatsType.TotalDistance) {
                if (Global.INSTANCE.getUnitType()) {
                    return R.string.mi;
                }
                return R.string.km;
            }
            return goalsStatsType.getStringUnitId();
        }
    }
}
