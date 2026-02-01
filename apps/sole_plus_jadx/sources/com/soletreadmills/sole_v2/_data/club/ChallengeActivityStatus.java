package com.soletreadmills.sole_v2._data.club;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ChallengeActivityStatus.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeActivityStatus;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "READY", "IN_PROGRESS_EARLY", "IN_PROGRESS", "FINISHED", "CANCELLED", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChallengeActivityStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChallengeActivityStatus[] $VALUES;
    private final int id;
    public static final ChallengeActivityStatus READY = new ChallengeActivityStatus("READY", 0, 3);
    public static final ChallengeActivityStatus IN_PROGRESS_EARLY = new ChallengeActivityStatus("IN_PROGRESS_EARLY", 1, 4);
    public static final ChallengeActivityStatus IN_PROGRESS = new ChallengeActivityStatus("IN_PROGRESS", 2, 5);
    public static final ChallengeActivityStatus FINISHED = new ChallengeActivityStatus("FINISHED", 3, 9);
    public static final ChallengeActivityStatus CANCELLED = new ChallengeActivityStatus("CANCELLED", 4, -9);

    private static final /* synthetic */ ChallengeActivityStatus[] $values() {
        return new ChallengeActivityStatus[]{READY, IN_PROGRESS_EARLY, IN_PROGRESS, FINISHED, CANCELLED};
    }

    public static EnumEntries<ChallengeActivityStatus> getEntries() {
        return $ENTRIES;
    }

    public static ChallengeActivityStatus valueOf(String str) {
        return (ChallengeActivityStatus) Enum.valueOf(ChallengeActivityStatus.class, str);
    }

    public static ChallengeActivityStatus[] values() {
        return (ChallengeActivityStatus[]) $VALUES.clone();
    }

    private ChallengeActivityStatus(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        ChallengeActivityStatus[] challengeActivityStatusArr$values = $values();
        $VALUES = challengeActivityStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(challengeActivityStatusArr$values);
    }
}
