package com.soletreadmills.sole_v2._data.club;

import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ChallengePrivacyLevelSettings.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengePrivacyLevelSettings;", "", "id", "", "formTitleTextId", "(Ljava/lang/String;III)V", "getFormTitleTextId", "()I", "getId", "PUBLIC", "PRIVATE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChallengePrivacyLevelSettings {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChallengePrivacyLevelSettings[] $VALUES;
    private final int formTitleTextId;
    private final int id;
    public static final ChallengePrivacyLevelSettings PUBLIC = new ChallengePrivacyLevelSettings("PUBLIC", 0, 9, R.string.challenge_privacy_public);
    public static final ChallengePrivacyLevelSettings PRIVATE = new ChallengePrivacyLevelSettings("PRIVATE", 1, 1, R.string.challenge_privacy_private);

    private static final /* synthetic */ ChallengePrivacyLevelSettings[] $values() {
        return new ChallengePrivacyLevelSettings[]{PUBLIC, PRIVATE};
    }

    public static EnumEntries<ChallengePrivacyLevelSettings> getEntries() {
        return $ENTRIES;
    }

    public static ChallengePrivacyLevelSettings valueOf(String str) {
        return (ChallengePrivacyLevelSettings) Enum.valueOf(ChallengePrivacyLevelSettings.class, str);
    }

    public static ChallengePrivacyLevelSettings[] values() {
        return (ChallengePrivacyLevelSettings[]) $VALUES.clone();
    }

    private ChallengePrivacyLevelSettings(String str, int i, int i2, int i3) {
        this.id = i2;
        this.formTitleTextId = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final int getFormTitleTextId() {
        return this.formTitleTextId;
    }

    static {
        ChallengePrivacyLevelSettings[] challengePrivacyLevelSettingsArr$values = $values();
        $VALUES = challengePrivacyLevelSettingsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(challengePrivacyLevelSettingsArr$values);
    }
}
