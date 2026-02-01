package com.soletreadmills.sole_v2._data.club;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ChallengeVirtualRaceFailReasonSettings.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeVirtualRaceFailReasonSettings;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "NOT_START_YET", "USER_DELETE_WORKOUT", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChallengeVirtualRaceFailReasonSettings {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChallengeVirtualRaceFailReasonSettings[] $VALUES;
    public static final ChallengeVirtualRaceFailReasonSettings NOT_START_YET = new ChallengeVirtualRaceFailReasonSettings("NOT_START_YET", 0, 5);
    public static final ChallengeVirtualRaceFailReasonSettings USER_DELETE_WORKOUT = new ChallengeVirtualRaceFailReasonSettings("USER_DELETE_WORKOUT", 1, 6);
    private final int id;

    private static final /* synthetic */ ChallengeVirtualRaceFailReasonSettings[] $values() {
        return new ChallengeVirtualRaceFailReasonSettings[]{NOT_START_YET, USER_DELETE_WORKOUT};
    }

    public static EnumEntries<ChallengeVirtualRaceFailReasonSettings> getEntries() {
        return $ENTRIES;
    }

    public static ChallengeVirtualRaceFailReasonSettings valueOf(String str) {
        return (ChallengeVirtualRaceFailReasonSettings) Enum.valueOf(ChallengeVirtualRaceFailReasonSettings.class, str);
    }

    public static ChallengeVirtualRaceFailReasonSettings[] values() {
        return (ChallengeVirtualRaceFailReasonSettings[]) $VALUES.clone();
    }

    private ChallengeVirtualRaceFailReasonSettings(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        ChallengeVirtualRaceFailReasonSettings[] challengeVirtualRaceFailReasonSettingsArr$values = $values();
        $VALUES = challengeVirtualRaceFailReasonSettingsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(challengeVirtualRaceFailReasonSettingsArr$values);
    }
}
