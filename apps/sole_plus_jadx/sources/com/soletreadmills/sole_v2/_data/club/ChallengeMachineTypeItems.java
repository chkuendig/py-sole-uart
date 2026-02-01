package com.soletreadmills.sole_v2._data.club;

import com.soletreadmills.sole_v2.R;
import java.util.ArrayList;
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
/* compiled from: ChallengeMachineTypeItems.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B)\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeMachineTypeItems;", "", "id", "", "formTitleTextId", "supportList", "", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeScoreItemSettings;", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getFormTitleTextId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getSupportList", "()Ljava/util/List;", "ALL_MACHINE", "TREADMILL", "BIKE", "CROSS_TRAINER", "ROWER", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChallengeMachineTypeItems {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChallengeMachineTypeItems[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final Integer formTitleTextId;
    private final Integer id;
    private final List<ChallengeScoreItemSettings> supportList;
    public static final ChallengeMachineTypeItems ALL_MACHINE = new ChallengeMachineTypeItems("ALL_MACHINE", 0, null, Integer.valueOf(R.string.any_device), CollectionsKt.listOf((Object[]) new ChallengeScoreItemSettings[]{ChallengeScoreItemSettings.TOTAL_DISTANCE, ChallengeScoreItemSettings.TOTAL_CALORIES, ChallengeScoreItemSettings.TOTAL_TIME, ChallengeScoreItemSettings.SESSION}));
    public static final ChallengeMachineTypeItems TREADMILL = new ChallengeMachineTypeItems("TREADMILL", 1, 0, Integer.valueOf(R.string.treadmill), CollectionsKt.listOf((Object[]) new ChallengeScoreItemSettings[]{ChallengeScoreItemSettings.TOTAL_DISTANCE, ChallengeScoreItemSettings.TOTAL_CALORIES, ChallengeScoreItemSettings.TOTAL_TIME, ChallengeScoreItemSettings.SESSION}));
    public static final ChallengeMachineTypeItems BIKE = new ChallengeMachineTypeItems("BIKE", 2, 1, Integer.valueOf(R.string.bike), CollectionsKt.listOf((Object[]) new ChallengeScoreItemSettings[]{ChallengeScoreItemSettings.TOTAL_DISTANCE, ChallengeScoreItemSettings.TOTAL_CALORIES, ChallengeScoreItemSettings.TOTAL_TIME, ChallengeScoreItemSettings.SESSION}));
    public static final ChallengeMachineTypeItems CROSS_TRAINER = new ChallengeMachineTypeItems("CROSS_TRAINER", 3, 2, Integer.valueOf(R.string.elliptical), CollectionsKt.listOf((Object[]) new ChallengeScoreItemSettings[]{ChallengeScoreItemSettings.TOTAL_DISTANCE, ChallengeScoreItemSettings.TOTAL_CALORIES, ChallengeScoreItemSettings.TOTAL_TIME, ChallengeScoreItemSettings.SESSION}));
    public static final ChallengeMachineTypeItems ROWER = new ChallengeMachineTypeItems("ROWER", 4, 4, Integer.valueOf(R.string.rower), CollectionsKt.listOf((Object[]) new ChallengeScoreItemSettings[]{ChallengeScoreItemSettings.TOTAL_DISTANCE, ChallengeScoreItemSettings.TOTAL_CALORIES, ChallengeScoreItemSettings.TOTAL_TIME, ChallengeScoreItemSettings.SESSION}));

    private static final /* synthetic */ ChallengeMachineTypeItems[] $values() {
        return new ChallengeMachineTypeItems[]{ALL_MACHINE, TREADMILL, BIKE, CROSS_TRAINER, ROWER};
    }

    public static EnumEntries<ChallengeMachineTypeItems> getEntries() {
        return $ENTRIES;
    }

    public static ChallengeMachineTypeItems valueOf(String str) {
        return (ChallengeMachineTypeItems) Enum.valueOf(ChallengeMachineTypeItems.class, str);
    }

    public static ChallengeMachineTypeItems[] values() {
        return (ChallengeMachineTypeItems[]) $VALUES.clone();
    }

    private ChallengeMachineTypeItems(String str, int i, Integer num, Integer num2, List list) {
        this.id = num;
        this.formTitleTextId = num2;
        this.supportList = list;
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getFormTitleTextId() {
        return this.formTitleTextId;
    }

    public final List<ChallengeScoreItemSettings> getSupportList() {
        return this.supportList;
    }

    static {
        ChallengeMachineTypeItems[] challengeMachineTypeItemsArr$values = $values();
        $VALUES = challengeMachineTypeItemsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(challengeMachineTypeItemsArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: ChallengeMachineTypeItems.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeMachineTypeItems$Companion;", "", "()V", "findFirstSupportId", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMachineTypeItems;", "id", "", "(Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/club/ChallengeMachineTypeItems;", "getUsedMachineTypes", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChallengeMachineTypeItems findFirstSupportId(Integer id2) {
            if (id2 == null) {
                return null;
            }
            for (ChallengeMachineTypeItems challengeMachineTypeItems : ChallengeMachineTypeItems.values()) {
                List<ChallengeScoreItemSettings> supportList = challengeMachineTypeItems.getSupportList();
                if (!(supportList instanceof Collection) || !supportList.isEmpty()) {
                    Iterator<T> it = supportList.iterator();
                    while (it.hasNext()) {
                        int id3 = ((ChallengeScoreItemSettings) it.next()).getId();
                        if (id2 != null && id3 == id2.intValue()) {
                            return challengeMachineTypeItems;
                        }
                    }
                }
            }
            return null;
        }

        public final List<ChallengeMachineTypeItems> getUsedMachineTypes() {
            VirtualRaceCodeType[] virtualRaceCodeTypeArrValues = VirtualRaceCodeType.values();
            ArrayList arrayList = new ArrayList();
            for (VirtualRaceCodeType virtualRaceCodeType : virtualRaceCodeTypeArrValues) {
                Integer machineTypeId = virtualRaceCodeType.getMachineTypeId();
                ChallengeMachineTypeItems challengeMachineTypeItems = null;
                if (machineTypeId != null) {
                    int iIntValue = machineTypeId.intValue();
                    ChallengeMachineTypeItems[] challengeMachineTypeItemsArrValues = ChallengeMachineTypeItems.values();
                    int length = challengeMachineTypeItemsArrValues.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        ChallengeMachineTypeItems challengeMachineTypeItems2 = challengeMachineTypeItemsArrValues[i];
                        Integer id2 = challengeMachineTypeItems2.getId();
                        if (id2 != null && id2.intValue() == iIntValue) {
                            challengeMachineTypeItems = challengeMachineTypeItems2;
                            break;
                        }
                        i++;
                    }
                }
                if (challengeMachineTypeItems != null) {
                    arrayList.add(challengeMachineTypeItems);
                }
            }
            return CollectionsKt.distinct(arrayList);
        }
    }
}
