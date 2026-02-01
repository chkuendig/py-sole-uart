package com.soletreadmills.sole_v2._type;

import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PersonalBestType.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b.\b\u0086\u0081\u0002\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00014B;\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rj\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3¨\u00065"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/PersonalBestType;", "", "rawValue", "", "categoryType", "Lcom/soletreadmills/sole_v2/_type/CategoryType;", "titleResId", "", "captionResId", SdkConstants.ATTR_BACKGROUND, "icon", "(Ljava/lang/String;ILjava/lang/String;Lcom/soletreadmills/sole_v2/_type/CategoryType;IIII)V", "getBackground", "()I", "getCaptionResId", "getCategoryType", "()Lcom/soletreadmills/sole_v2/_type/CategoryType;", "getIcon", "getRawValue", "()Ljava/lang/String;", "getTitleResId", "UNDEFINED", "LONGEST_RUN", "FARTHEST_RUN", "RUN_5K", "RUN_10K", "RUN_21K", "RUN_42K", "LONGEST_RIDE", "FARTHEST_RIDE", "RIDE_20K", "RIDE_40K", "RIDE_80K", "RIDE_160K", "LONGEST_CLIMB", "HIGHEST_CLIMB", "CLIMB_100M", "CLIMB_250M", "CLIMB_500M", "CLIMB_1000M", "LONGEST_GLIDE", "FARTHEST_GLIDE", "GLIDE_30M", "GLIDE_60M", "GLIDE_90M", "GLIDE_120M", "LONGEST_ROW", "FARTHEST_ROW", "ROW_2K", "ROW_5K", "ROW_10K", "ROW_21K", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonalBestType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PersonalBestType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int background;
    private final int captionResId;
    private final CategoryType categoryType;
    private final int icon;
    private final String rawValue;
    private final int titleResId;
    public static final PersonalBestType UNDEFINED = new PersonalBestType("UNDEFINED", 0, "UNDEFINED", CategoryType.UNDEFINED, R.string.empty, R.string.empty, R.drawable.treadmill_max_time, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType LONGEST_RUN = new PersonalBestType("LONGEST_RUN", 1, "T001", CategoryType.TREADMILL, R.string.longest_run, R.string.longest_run_desc, R.drawable.treadmill_max_time, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType FARTHEST_RUN = new PersonalBestType("FARTHEST_RUN", 2, "T002", CategoryType.TREADMILL, R.string.farthest_run, R.string.farthest_run_desc, R.drawable.treadmill_max_distance, R.drawable.ic_stats_distance);
    public static final PersonalBestType RUN_5K = new PersonalBestType("RUN_5K", 3, "T003", CategoryType.TREADMILL, R.string.best_5k_run, R.string.best_5k_run_desc, R.drawable.treadmill_5k, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType RUN_10K = new PersonalBestType("RUN_10K", 4, "T004", CategoryType.TREADMILL, R.string.best_10k_run, R.string.best_10k_run_desc, R.drawable.treadmill_10k, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType RUN_21K = new PersonalBestType("RUN_21K", 5, "T005", CategoryType.TREADMILL, R.string.best_half_marathon_run, R.string.best_half_marathon_run_desc, R.drawable.treadmill_21k, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType RUN_42K = new PersonalBestType("RUN_42K", 6, "T006", CategoryType.TREADMILL, R.string.best_marathon_run, R.string.best_marathon_run_desc, R.drawable.treadmill_42k, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType LONGEST_RIDE = new PersonalBestType("LONGEST_RIDE", 7, "B001", CategoryType.BIKE, R.string.longest_ride, R.string.longest_ride_desc, R.drawable.bike_max_time, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType FARTHEST_RIDE = new PersonalBestType("FARTHEST_RIDE", 8, "B002", CategoryType.BIKE, R.string.farthest_ride, R.string.farthest_ride_desc, R.drawable.bike_max_distance, R.drawable.ic_stats_distance);
    public static final PersonalBestType RIDE_20K = new PersonalBestType("RIDE_20K", 9, "B013", CategoryType.BIKE, R.string.best_20k_ride, R.string.best_20k_ride_desc, R.drawable.bike_easy, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType RIDE_40K = new PersonalBestType("RIDE_40K", 10, "B014", CategoryType.BIKE, R.string.best_40k_ride, R.string.best_40k_ride_desc, R.drawable.bike_normal, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType RIDE_80K = new PersonalBestType("RIDE_80K", 11, "B015", CategoryType.BIKE, R.string.best_half_century_ride, R.string.best_half_century_ride_desc, R.drawable.bike_medium, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType RIDE_160K = new PersonalBestType("RIDE_160K", 12, "B016", CategoryType.BIKE, R.string.best_century_ride, R.string.best_century_ride_desc, R.drawable.bike_hard, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType LONGEST_CLIMB = new PersonalBestType("LONGEST_CLIMB", 13, "S001", CategoryType.STEPPER, R.string.longest_climb, R.string.longest_climb_desc, R.drawable.stepper_max_time, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType HIGHEST_CLIMB = new PersonalBestType("HIGHEST_CLIMB", 14, "S002", CategoryType.STEPPER, R.string.highest_climb, R.string.highest_climb_desc, R.drawable.stepper_max_distance, R.drawable.ic_stats_distance);
    public static final PersonalBestType CLIMB_100M = new PersonalBestType("CLIMB_100M", 15, "S003", CategoryType.STEPPER, R.string.best_100m_climb, R.string.best_100m_climb_desc, R.drawable.stepper_easy, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType CLIMB_250M = new PersonalBestType("CLIMB_250M", 16, "S004", CategoryType.STEPPER, R.string.best_250m_climb, R.string.best_250m_climb_desc, R.drawable.stepper_normal, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType CLIMB_500M = new PersonalBestType("CLIMB_500M", 17, "S005", CategoryType.STEPPER, R.string.best_500m_climb, R.string.best_500m_climb_desc, R.drawable.stepper_medium, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType CLIMB_1000M = new PersonalBestType("CLIMB_1000M", 18, "S006", CategoryType.STEPPER, R.string.best_1000m_climb, R.string.best_1000m_climb_desc, R.drawable.stepper_hard, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType LONGEST_GLIDE = new PersonalBestType("LONGEST_GLIDE", 19, "E001", CategoryType.ELLIPTICAL, R.string.longest_glide, R.string.longest_glide_desc, R.drawable.elliptical_max_time, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType FARTHEST_GLIDE = new PersonalBestType("FARTHEST_GLIDE", 20, "E002", CategoryType.ELLIPTICAL, R.string.farthest_glide, R.string.farthest_glide_desc, R.drawable.elliptical_max_distance, R.drawable.ic_stats_distance);
    public static final PersonalBestType GLIDE_30M = new PersonalBestType("GLIDE_30M", 21, "E003", CategoryType.ELLIPTICAL, R.string.best_30_minute_glide, R.string.best_30_minute_glide_desc, R.drawable.elliptical_easy, R.drawable.ic_stats_power);
    public static final PersonalBestType GLIDE_60M = new PersonalBestType("GLIDE_60M", 22, "E004", CategoryType.ELLIPTICAL, R.string.best_one_hour_glide, R.string.best_one_hour_glide_desc, R.drawable.elliptical_normal, R.drawable.ic_stats_power);
    public static final PersonalBestType GLIDE_90M = new PersonalBestType("GLIDE_90M", 23, "E005", CategoryType.ELLIPTICAL, R.string.best_90_minute_glide, R.string.best_90_minute_glide_desc, R.drawable.elliptical_medium, R.drawable.ic_stats_power);
    public static final PersonalBestType GLIDE_120M = new PersonalBestType("GLIDE_120M", 24, "E006", CategoryType.ELLIPTICAL, R.string.best_two_hour_glide, R.string.best_two_hour_glide_desc, R.drawable.elliptical_hard, R.drawable.ic_stats_power);
    public static final PersonalBestType LONGEST_ROW = new PersonalBestType("LONGEST_ROW", 25, "R001", CategoryType.ROWER, R.string.longest_row, R.string.longest_row_desc, R.drawable.rower_max_time, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType FARTHEST_ROW = new PersonalBestType("FARTHEST_ROW", 26, "R002", CategoryType.ROWER, R.string.farthest_row, R.string.farthest_row_desc, R.drawable.rower_max_distance, R.drawable.ic_stats_distance);
    public static final PersonalBestType ROW_2K = new PersonalBestType("ROW_2K", 27, "R004", CategoryType.ROWER, R.string.best_2k_row, R.string.best_2k_row_desc, R.drawable.rower_easy, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType ROW_5K = new PersonalBestType("ROW_5K", 28, "R007", CategoryType.ROWER, R.string.best_5k_row, R.string.best_5k_row_desc, R.drawable.rower_normal, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType ROW_10K = new PersonalBestType("ROW_10K", 29, "R008", CategoryType.ROWER, R.string.best_10k_row, R.string.best_10k_row_desc, R.drawable.rower_medium, R.drawable.ic_stats_timer_fill);
    public static final PersonalBestType ROW_21K = new PersonalBestType("ROW_21K", 30, "R009", CategoryType.ROWER, R.string.best_half_marathon_row, R.string.best_half_marathon_row_desc, R.drawable.rower_hard, R.drawable.ic_stats_timer_fill);

    private static final /* synthetic */ PersonalBestType[] $values() {
        return new PersonalBestType[]{UNDEFINED, LONGEST_RUN, FARTHEST_RUN, RUN_5K, RUN_10K, RUN_21K, RUN_42K, LONGEST_RIDE, FARTHEST_RIDE, RIDE_20K, RIDE_40K, RIDE_80K, RIDE_160K, LONGEST_CLIMB, HIGHEST_CLIMB, CLIMB_100M, CLIMB_250M, CLIMB_500M, CLIMB_1000M, LONGEST_GLIDE, FARTHEST_GLIDE, GLIDE_30M, GLIDE_60M, GLIDE_90M, GLIDE_120M, LONGEST_ROW, FARTHEST_ROW, ROW_2K, ROW_5K, ROW_10K, ROW_21K};
    }

    public static EnumEntries<PersonalBestType> getEntries() {
        return $ENTRIES;
    }

    public static PersonalBestType valueOf(String str) {
        return (PersonalBestType) Enum.valueOf(PersonalBestType.class, str);
    }

    public static PersonalBestType[] values() {
        return (PersonalBestType[]) $VALUES.clone();
    }

    private PersonalBestType(String str, int i, String str2, CategoryType categoryType, int i2, int i3, int i4, int i5) {
        this.rawValue = str2;
        this.categoryType = categoryType;
        this.titleResId = i2;
        this.captionResId = i3;
        this.background = i4;
        this.icon = i5;
    }

    /* synthetic */ PersonalBestType(String str, int i, String str2, CategoryType categoryType, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, categoryType, (i6 & 4) != 0 ? 0 : i2, (i6 & 8) != 0 ? 0 : i3, i4, i5);
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public final CategoryType getCategoryType() {
        return this.categoryType;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final int getCaptionResId() {
        return this.captionResId;
    }

    public final int getBackground() {
        return this.background;
    }

    public final int getIcon() {
        return this.icon;
    }

    static {
        PersonalBestType[] personalBestTypeArr$values = $values();
        $VALUES = personalBestTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(personalBestTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: PersonalBestType.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0011\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/PersonalBestType$Companion;", "", "()V", "fromRawValue", "Lcom/soletreadmills/sole_v2/_type/PersonalBestType;", "rawValue", "", "getAllCases", "", "()[Lcom/soletreadmills/sole_v2/_type/PersonalBestType;", "getByCategory", "", "categoryType", "Lcom/soletreadmills/sole_v2/_type/CategoryType;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PersonalBestType fromRawValue(String rawValue) {
            PersonalBestType personalBestType;
            Intrinsics.checkNotNullParameter(rawValue, "rawValue");
            PersonalBestType[] personalBestTypeArrValues = PersonalBestType.values();
            int length = personalBestTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    personalBestType = null;
                    break;
                }
                personalBestType = personalBestTypeArrValues[i];
                if (Intrinsics.areEqual(personalBestType.getRawValue(), rawValue)) {
                    break;
                }
                i++;
            }
            return personalBestType == null ? PersonalBestType.UNDEFINED : personalBestType;
        }

        public final PersonalBestType[] getAllCases() {
            return PersonalBestType.values();
        }

        public final List<PersonalBestType> getByCategory(CategoryType categoryType) {
            Intrinsics.checkNotNullParameter(categoryType, "categoryType");
            PersonalBestType[] personalBestTypeArrValues = PersonalBestType.values();
            ArrayList arrayList = new ArrayList();
            for (PersonalBestType personalBestType : personalBestTypeArrValues) {
                if (personalBestType.getCategoryType() == categoryType) {
                    arrayList.add(personalBestType);
                }
            }
            return arrayList;
        }
    }
}
