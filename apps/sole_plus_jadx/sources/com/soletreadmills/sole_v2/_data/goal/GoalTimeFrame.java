package com.soletreadmills.sole_v2._data.goal;

import com.soletreadmills.sole_v2.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GoalTimeFrame.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/goal/GoalTimeFrame;", "", "id", "", "titleId", "unitId", "unitPluralId", "(Ljava/lang/String;IIIII)V", "getId", "()I", "getTitleId", "getUnitId", "getUnitPluralId", "Daily", "Weekly", "Monthly", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalTimeFrame {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GoalTimeFrame[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int id;
    private final int titleId;
    private final int unitId;
    private final int unitPluralId;
    public static final GoalTimeFrame Daily = new GoalTimeFrame("Daily", 0, 1, R.string.daily, R.string.day, R.string.days);
    public static final GoalTimeFrame Weekly = new GoalTimeFrame("Weekly", 1, 7, R.string.weekly, R.string.week, R.string.weeks);
    public static final GoalTimeFrame Monthly = new GoalTimeFrame("Monthly", 2, 30, R.string.monthly, R.string.month, R.string.months);

    private static final /* synthetic */ GoalTimeFrame[] $values() {
        return new GoalTimeFrame[]{Daily, Weekly, Monthly};
    }

    public static EnumEntries<GoalTimeFrame> getEntries() {
        return $ENTRIES;
    }

    public static GoalTimeFrame valueOf(String str) {
        return (GoalTimeFrame) Enum.valueOf(GoalTimeFrame.class, str);
    }

    public static GoalTimeFrame[] values() {
        return (GoalTimeFrame[]) $VALUES.clone();
    }

    private GoalTimeFrame(String str, int i, int i2, int i3, int i4, int i5) {
        this.id = i2;
        this.titleId = i3;
        this.unitId = i4;
        this.unitPluralId = i5;
    }

    public final int getId() {
        return this.id;
    }

    public final int getTitleId() {
        return this.titleId;
    }

    public final int getUnitId() {
        return this.unitId;
    }

    public final int getUnitPluralId() {
        return this.unitPluralId;
    }

    static {
        GoalTimeFrame[] goalTimeFrameArr$values = $values();
        $VALUES = goalTimeFrameArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(goalTimeFrameArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: GoalTimeFrame.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/goal/GoalTimeFrame$Companion;", "", "()V", "getTitleId", "", "id", "defaultStringId", "getUnitId", "isPlural", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ int getTitleId$default(Companion companion, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i2 = R.string.dashed_text;
            }
            return companion.getTitleId(i, i2);
        }

        public final int getTitleId(int id2, int defaultStringId) {
            GoalTimeFrame next;
            Iterator<GoalTimeFrame> it = GoalTimeFrame.getEntries().iterator();
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
            GoalTimeFrame goalTimeFrame = next;
            return goalTimeFrame != null ? goalTimeFrame.getTitleId() : defaultStringId;
        }

        public static /* synthetic */ int getUnitId$default(Companion companion, int i, boolean z, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i2 = R.string.dashed_text;
            }
            return companion.getUnitId(i, z, i2);
        }

        public final int getUnitId(int id2, boolean isPlural, int defaultStringId) {
            GoalTimeFrame next;
            Iterator<GoalTimeFrame> it = GoalTimeFrame.getEntries().iterator();
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
            GoalTimeFrame goalTimeFrame = next;
            if (goalTimeFrame == null) {
                return defaultStringId;
            }
            if (isPlural) {
                return goalTimeFrame.getUnitPluralId();
            }
            return goalTimeFrame.getUnitId();
        }
    }
}
