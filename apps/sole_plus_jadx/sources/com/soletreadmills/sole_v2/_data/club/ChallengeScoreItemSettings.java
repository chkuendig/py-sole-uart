package com.soletreadmills.sole_v2._data.club;

import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ChallengeScoreItemSettings.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeScoreItemSettings;", "", "id", "", "formTitleTextId", "showAtForm", "", "(Ljava/lang/String;IILjava/lang/Integer;Z)V", "getFormTitleTextId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()I", "getShowAtForm", "()Z", "TOTAL_DISTANCE", "TOTAL_CALORIES", "TOTAL_TIME", "SESSION", "RACE", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChallengeScoreItemSettings {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChallengeScoreItemSettings[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final Integer formTitleTextId;
    private final int id;
    private final boolean showAtForm;
    public static final ChallengeScoreItemSettings TOTAL_DISTANCE = new ChallengeScoreItemSettings("TOTAL_DISTANCE", 0, 2, Integer.valueOf(R.string.club_form_title_distance), true);
    public static final ChallengeScoreItemSettings TOTAL_CALORIES = new ChallengeScoreItemSettings("TOTAL_CALORIES", 1, 3, Integer.valueOf(R.string.club_form_title_calories), true);
    public static final ChallengeScoreItemSettings TOTAL_TIME = new ChallengeScoreItemSettings("TOTAL_TIME", 2, 1, Integer.valueOf(R.string.club_form_title_active_time), true);
    public static final ChallengeScoreItemSettings SESSION = new ChallengeScoreItemSettings("SESSION", 3, 4, Integer.valueOf(R.string.club_form_title_sessions), true);
    public static final ChallengeScoreItemSettings RACE = new ChallengeScoreItemSettings("RACE", 4, 5, null, false);

    private static final /* synthetic */ ChallengeScoreItemSettings[] $values() {
        return new ChallengeScoreItemSettings[]{TOTAL_DISTANCE, TOTAL_CALORIES, TOTAL_TIME, SESSION, RACE};
    }

    public static EnumEntries<ChallengeScoreItemSettings> getEntries() {
        return $ENTRIES;
    }

    public static ChallengeScoreItemSettings valueOf(String str) {
        return (ChallengeScoreItemSettings) Enum.valueOf(ChallengeScoreItemSettings.class, str);
    }

    public static ChallengeScoreItemSettings[] values() {
        return (ChallengeScoreItemSettings[]) $VALUES.clone();
    }

    private ChallengeScoreItemSettings(String str, int i, int i2, Integer num, boolean z) {
        this.id = i2;
        this.formTitleTextId = num;
        this.showAtForm = z;
    }

    public final int getId() {
        return this.id;
    }

    public final Integer getFormTitleTextId() {
        return this.formTitleTextId;
    }

    public final boolean getShowAtForm() {
        return this.showAtForm;
    }

    static {
        ChallengeScoreItemSettings[] challengeScoreItemSettingsArr$values = $values();
        $VALUES = challengeScoreItemSettingsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(challengeScoreItemSettingsArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: ChallengeScoreItemSettings.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeScoreItemSettings$Companion;", "", "()V", SdkConstants.ATTR_FROM_ID, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeScoreItemSettings;", "id", "", "(Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/club/ChallengeScoreItemSettings;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChallengeScoreItemSettings fromId(Integer id2) {
            ChallengeScoreItemSettings challengeScoreItemSettings = null;
            if (id2 == null) {
                return null;
            }
            Iterator<ChallengeScoreItemSettings> it = ChallengeScoreItemSettings.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ChallengeScoreItemSettings next = it.next();
                int id3 = next.getId();
                if (id2 != null && id3 == id2.intValue()) {
                    challengeScoreItemSettings = next;
                    break;
                }
            }
            return challengeScoreItemSettings;
        }
    }
}
