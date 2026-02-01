package com.soletreadmills.sole_v2._data.goal;

import com.android.SdkConstants;
import com.facebook.share.internal.ShareConstants;
import com.soletreadmills.sole_v2.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GoalsMachineType.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB1\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/goal/GoalsMachineType;", "", "id", "", "formTitleTextId", "supportList", "", "Lcom/soletreadmills/sole_v2/_data/goal/GoalsStatsType;", "showAtForm", "", "(Ljava/lang/String;ILjava/lang/Integer;ILjava/util/List;Z)V", "getFormTitleTextId", "()I", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowAtForm", "()Z", "getSupportList", "()Ljava/util/List;", "ALL_MACHINE", "TREADMILL", "BIKE", "ELLIPTICAL", "STEPPER", "ROWER", "SRVO", ShareConstants.VIDEO_URL, "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalsMachineType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GoalsMachineType[] $VALUES;
    public static final GoalsMachineType BIKE;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final GoalsMachineType ELLIPTICAL;
    public static final GoalsMachineType ROWER;
    public static final GoalsMachineType STEPPER;
    public static final GoalsMachineType TREADMILL;
    private final int formTitleTextId;
    private final Integer id;
    private final boolean showAtForm;
    private final List<GoalsStatsType> supportList;
    public static final GoalsMachineType ALL_MACHINE = new GoalsMachineType("ALL_MACHINE", 0, null, R.string.any_device, CollectionsKt.listOf((Object[]) new GoalsStatsType[]{GoalsStatsType.ActiveMinutes, GoalsStatsType.TotalCalories}), false, 8, null);
    public static final GoalsMachineType SRVO = new GoalsMachineType("SRVO", 6, 5, R.string.srvo, CollectionsKt.listOf((Object[]) new GoalsStatsType[]{GoalsStatsType.ActiveMinutes, GoalsStatsType.WorkoutCounts, GoalsStatsType.TotalCalories, GoalsStatsType.SRVOSets, GoalsStatsType.SRVOReps, GoalsStatsType.SRVOPounds}), false);
    public static final GoalsMachineType VIDEO = new GoalsMachineType(ShareConstants.VIDEO_URL, 7, 6, R.string.video_classes, CollectionsKt.emptyList(), false);

    private static final /* synthetic */ GoalsMachineType[] $values() {
        return new GoalsMachineType[]{ALL_MACHINE, TREADMILL, BIKE, ELLIPTICAL, STEPPER, ROWER, SRVO, VIDEO};
    }

    public static EnumEntries<GoalsMachineType> getEntries() {
        return $ENTRIES;
    }

    public static GoalsMachineType valueOf(String str) {
        return (GoalsMachineType) Enum.valueOf(GoalsMachineType.class, str);
    }

    public static GoalsMachineType[] values() {
        return (GoalsMachineType[]) $VALUES.clone();
    }

    private GoalsMachineType(String str, int i, Integer num, int i2, List list, boolean z) {
        this.id = num;
        this.formTitleTextId = i2;
        this.supportList = list;
        this.showAtForm = z;
    }

    /* synthetic */ GoalsMachineType(String str, int i, Integer num, int i2, List list, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, num, i2, list, (i3 & 8) != 0 ? true : z);
    }

    public final Integer getId() {
        return this.id;
    }

    public final int getFormTitleTextId() {
        return this.formTitleTextId;
    }

    public final List<GoalsStatsType> getSupportList() {
        return this.supportList;
    }

    public final boolean getShowAtForm() {
        return this.showAtForm;
    }

    static {
        int i = 8;
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z = false;
        TREADMILL = new GoalsMachineType("TREADMILL", 1, 0, R.string.treadmill, CollectionsKt.listOf((Object[]) new GoalsStatsType[]{GoalsStatsType.TotalDistance, GoalsStatsType.ActiveMinutes, GoalsStatsType.WorkoutCounts, GoalsStatsType.TotalCalories}), z, i, defaultConstructorMarker);
        int i2 = 8;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        boolean z2 = false;
        BIKE = new GoalsMachineType("BIKE", 2, 1, R.string.bike, CollectionsKt.listOf((Object[]) new GoalsStatsType[]{GoalsStatsType.TotalDistance, GoalsStatsType.ActiveMinutes, GoalsStatsType.WorkoutCounts, GoalsStatsType.TotalCalories}), z2, i2, defaultConstructorMarker2);
        ELLIPTICAL = new GoalsMachineType("ELLIPTICAL", 3, 2, R.string.elliptical, CollectionsKt.listOf((Object[]) new GoalsStatsType[]{GoalsStatsType.TotalDistance, GoalsStatsType.ActiveMinutes, GoalsStatsType.WorkoutCounts, GoalsStatsType.TotalCalories}), z, i, defaultConstructorMarker);
        STEPPER = new GoalsMachineType("STEPPER", 4, 3, R.string.stepper, CollectionsKt.listOf((Object[]) new GoalsStatsType[]{GoalsStatsType.TotalDistance, GoalsStatsType.ActiveMinutes, GoalsStatsType.WorkoutCounts, GoalsStatsType.TotalCalories, GoalsStatsType.TotalSteps}), z2, i2, defaultConstructorMarker2);
        ROWER = new GoalsMachineType("ROWER", 5, 4, R.string.rower, CollectionsKt.listOf((Object[]) new GoalsStatsType[]{GoalsStatsType.TotalDistance, GoalsStatsType.ActiveMinutes, GoalsStatsType.WorkoutCounts, GoalsStatsType.TotalCalories, GoalsStatsType.TotalStrokes}), z, i, defaultConstructorMarker);
        GoalsMachineType[] goalsMachineTypeArr$values = $values();
        $VALUES = goalsMachineTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(goalsMachineTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: GoalsMachineType.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/goal/GoalsMachineType$Companion;", "", "()V", "findFirstSupportId", "Lcom/soletreadmills/sole_v2/_data/goal/GoalsMachineType;", "id", "", "(Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/goal/GoalsMachineType;", SdkConstants.ATTR_FROM_ID, "getSupportedGoalsStatsByMachineId", "", "Lcom/soletreadmills/sole_v2/_data/goal/GoalsStatsType;", "machineId", "(Ljava/lang/Integer;)Ljava/util/List;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GoalsMachineType findFirstSupportId(Integer id2) {
            if (id2 == null) {
                return null;
            }
            for (GoalsMachineType goalsMachineType : GoalsMachineType.values()) {
                List<GoalsStatsType> supportList = goalsMachineType.getSupportList();
                if (!(supportList instanceof Collection) || !supportList.isEmpty()) {
                    Iterator<T> it = supportList.iterator();
                    while (it.hasNext()) {
                        int id3 = ((GoalsStatsType) it.next()).getId();
                        if (id2 != null && id3 == id2.intValue()) {
                            return goalsMachineType;
                        }
                    }
                }
            }
            return null;
        }

        public final GoalsMachineType fromId(int id2) {
            for (GoalsMachineType goalsMachineType : GoalsMachineType.values()) {
                Integer id3 = goalsMachineType.getId();
                if (id3 != null && id3.intValue() == id2) {
                    return goalsMachineType;
                }
            }
            return null;
        }

        public final List<GoalsStatsType> getSupportedGoalsStatsByMachineId(Integer machineId) {
            List<GoalsStatsType> supportList;
            if (machineId == null) {
                return GoalsMachineType.ALL_MACHINE.getSupportList();
            }
            GoalsMachineType goalsMachineTypeFromId = fromId(machineId.intValue());
            return (goalsMachineTypeFromId == null || (supportList = goalsMachineTypeFromId.getSupportList()) == null) ? CollectionsKt.emptyList() : supportList;
        }
    }
}
