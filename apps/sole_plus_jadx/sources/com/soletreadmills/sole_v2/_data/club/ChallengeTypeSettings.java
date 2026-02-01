package com.soletreadmills.sole_v2._data.club;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ChallengeTypeSettings.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeTypeSettings;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "GOAL", "RANKING", "VIRTUAL_RACE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChallengeTypeSettings {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChallengeTypeSettings[] $VALUES;
    public static final ChallengeTypeSettings GOAL = new ChallengeTypeSettings("GOAL", 0, 1);
    public static final ChallengeTypeSettings RANKING = new ChallengeTypeSettings("RANKING", 1, 2);
    public static final ChallengeTypeSettings VIRTUAL_RACE = new ChallengeTypeSettings("VIRTUAL_RACE", 2, 3);
    private final int id;

    private static final /* synthetic */ ChallengeTypeSettings[] $values() {
        return new ChallengeTypeSettings[]{GOAL, RANKING, VIRTUAL_RACE};
    }

    public static EnumEntries<ChallengeTypeSettings> getEntries() {
        return $ENTRIES;
    }

    public static ChallengeTypeSettings valueOf(String str) {
        return (ChallengeTypeSettings) Enum.valueOf(ChallengeTypeSettings.class, str);
    }

    public static ChallengeTypeSettings[] values() {
        return (ChallengeTypeSettings[]) $VALUES.clone();
    }

    private ChallengeTypeSettings(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        ChallengeTypeSettings[] challengeTypeSettingsArr$values = $values();
        $VALUES = challengeTypeSettingsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(challengeTypeSettingsArr$values);
    }
}
