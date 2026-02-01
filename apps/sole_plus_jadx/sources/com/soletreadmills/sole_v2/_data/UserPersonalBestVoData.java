package com.soletreadmills.sole_v2._data;

import androidx.camera.video.AudioStats;
import com.android.SdkConstants;
import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2._tools.ConvertUtils;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._type.CategoryType;
import com.soletreadmills.sole_v2._type.PersonalBestType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserPersonalBestVoData.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0006HÂ\u0003¢\u0006\u0002\u0010(J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003JV\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u00101\u001a\u00020\u0003J\u0006\u00102\u001a\u00020/J\u0006\u00103\u001a\u00020\u0003J\u0006\u00104\u001a\u00020/J\u0006\u00105\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u000208J\t\u00109\u001a\u00020\u0006HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001J\n\u0010;\u001a\u00020\u0003*\u00020\u0003R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006<"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/UserPersonalBestVoData;", "", "eventTime", "", "currentBestUserWorkoutUuid", "_machineCategoryType", "", "_personalBestItem", "currentBestValue", "", "measurementValue", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Number;)V", "Ljava/lang/Integer;", "getCurrentBestUserWorkoutUuid", "()Ljava/lang/String;", "setCurrentBestUserWorkoutUuid", "(Ljava/lang/String;)V", "getCurrentBestValue", "()Ljava/lang/Double;", "setCurrentBestValue", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getEventTime", "setEventTime", "machineCategoryType", "Lcom/soletreadmills/sole_v2/_type/CategoryType;", "getMachineCategoryType", "()Lcom/soletreadmills/sole_v2/_type/CategoryType;", "getMeasurementValue", "()Ljava/lang/Number;", "setMeasurementValue", "(Ljava/lang/Number;)V", "personalBestItem", "Lcom/soletreadmills/sole_v2/_type/PersonalBestType;", "getPersonalBestItem", "()Lcom/soletreadmills/sole_v2/_type/PersonalBestType;", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Number;)Lcom/soletreadmills/sole_v2/_data/UserPersonalBestVoData;", "equals", "", "other", "getAchieveDate", "getMainValueIsTime", "getMainValueStr", "getSubValueIsTime", "getSubValueStr", "getUnit", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "hashCode", "toString", "toDisplayDate", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserPersonalBestVoData {
    public static final int $stable = 8;

    @SerializedName("machineCategoryType")
    private final Integer _machineCategoryType;

    @SerializedName("personalBestItem")
    private final String _personalBestItem;
    private String currentBestUserWorkoutUuid;
    private Double currentBestValue;
    private String eventTime;
    private Number measurementValue;

    /* compiled from: UserPersonalBestVoData.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PersonalBestType.values().length];
            try {
                iArr[PersonalBestType.FARTHEST_RUN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PersonalBestType.FARTHEST_RIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PersonalBestType.FARTHEST_GLIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PersonalBestType.HIGHEST_CLIMB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PersonalBestType.FARTHEST_ROW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PersonalBestType.GLIDE_30M.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PersonalBestType.GLIDE_60M.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PersonalBestType.GLIDE_90M.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PersonalBestType.GLIDE_120M.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PersonalBestType.LONGEST_RUN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PersonalBestType.RUN_5K.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[PersonalBestType.RUN_10K.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[PersonalBestType.RUN_21K.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[PersonalBestType.RUN_42K.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[PersonalBestType.LONGEST_RIDE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[PersonalBestType.RIDE_20K.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[PersonalBestType.RIDE_40K.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[PersonalBestType.RIDE_80K.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[PersonalBestType.RIDE_160K.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[PersonalBestType.LONGEST_GLIDE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[PersonalBestType.LONGEST_CLIMB.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[PersonalBestType.CLIMB_100M.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[PersonalBestType.CLIMB_250M.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[PersonalBestType.CLIMB_500M.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[PersonalBestType.CLIMB_1000M.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[PersonalBestType.LONGEST_ROW.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[PersonalBestType.ROW_2K.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[PersonalBestType.ROW_5K.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[PersonalBestType.ROW_10K.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[PersonalBestType.ROW_21K.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public UserPersonalBestVoData() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* renamed from: component3, reason: from getter */
    private final Integer get_machineCategoryType() {
        return this._machineCategoryType;
    }

    /* renamed from: component4, reason: from getter */
    private final String get_personalBestItem() {
        return this._personalBestItem;
    }

    public static /* synthetic */ UserPersonalBestVoData copy$default(UserPersonalBestVoData userPersonalBestVoData, String str, String str2, Integer num, String str3, Double d, Number number, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userPersonalBestVoData.eventTime;
        }
        if ((i & 2) != 0) {
            str2 = userPersonalBestVoData.currentBestUserWorkoutUuid;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            num = userPersonalBestVoData._machineCategoryType;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            str3 = userPersonalBestVoData._personalBestItem;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            d = userPersonalBestVoData.currentBestValue;
        }
        Double d2 = d;
        if ((i & 32) != 0) {
            number = userPersonalBestVoData.measurementValue;
        }
        return userPersonalBestVoData.copy(str, str4, num2, str5, d2, number);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventTime() {
        return this.eventTime;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCurrentBestUserWorkoutUuid() {
        return this.currentBestUserWorkoutUuid;
    }

    /* renamed from: component5, reason: from getter */
    public final Double getCurrentBestValue() {
        return this.currentBestValue;
    }

    /* renamed from: component6, reason: from getter */
    public final Number getMeasurementValue() {
        return this.measurementValue;
    }

    public final UserPersonalBestVoData copy(String eventTime, String currentBestUserWorkoutUuid, Integer _machineCategoryType, String _personalBestItem, Double currentBestValue, Number measurementValue) {
        return new UserPersonalBestVoData(eventTime, currentBestUserWorkoutUuid, _machineCategoryType, _personalBestItem, currentBestValue, measurementValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserPersonalBestVoData)) {
            return false;
        }
        UserPersonalBestVoData userPersonalBestVoData = (UserPersonalBestVoData) other;
        return Intrinsics.areEqual(this.eventTime, userPersonalBestVoData.eventTime) && Intrinsics.areEqual(this.currentBestUserWorkoutUuid, userPersonalBestVoData.currentBestUserWorkoutUuid) && Intrinsics.areEqual(this._machineCategoryType, userPersonalBestVoData._machineCategoryType) && Intrinsics.areEqual(this._personalBestItem, userPersonalBestVoData._personalBestItem) && Intrinsics.areEqual((Object) this.currentBestValue, (Object) userPersonalBestVoData.currentBestValue) && Intrinsics.areEqual(this.measurementValue, userPersonalBestVoData.measurementValue);
    }

    public int hashCode() {
        String str = this.eventTime;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.currentBestUserWorkoutUuid;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this._machineCategoryType;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this._personalBestItem;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Double d = this.currentBestValue;
        int iHashCode5 = (iHashCode4 + (d == null ? 0 : d.hashCode())) * 31;
        Number number = this.measurementValue;
        return iHashCode5 + (number != null ? number.hashCode() : 0);
    }

    public String toString() {
        return "UserPersonalBestVoData(eventTime=" + this.eventTime + ", currentBestUserWorkoutUuid=" + this.currentBestUserWorkoutUuid + ", _machineCategoryType=" + this._machineCategoryType + ", _personalBestItem=" + this._personalBestItem + ", currentBestValue=" + this.currentBestValue + ", measurementValue=" + this.measurementValue + ')';
    }

    public UserPersonalBestVoData(String str, String str2, Integer num, String str3, Double d, Number number) {
        this.eventTime = str;
        this.currentBestUserWorkoutUuid = str2;
        this._machineCategoryType = num;
        this._personalBestItem = str3;
        this.currentBestValue = d;
        this.measurementValue = number;
    }

    public /* synthetic */ UserPersonalBestVoData(String str, String str2, Integer num, String str3, Double d, Number number, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : d, (i & 32) != 0 ? null : number);
    }

    public final String getEventTime() {
        return this.eventTime;
    }

    public final void setEventTime(String str) {
        this.eventTime = str;
    }

    public final String getCurrentBestUserWorkoutUuid() {
        return this.currentBestUserWorkoutUuid;
    }

    public final void setCurrentBestUserWorkoutUuid(String str) {
        this.currentBestUserWorkoutUuid = str;
    }

    public final Double getCurrentBestValue() {
        return this.currentBestValue;
    }

    public final void setCurrentBestValue(Double d) {
        this.currentBestValue = d;
    }

    public final Number getMeasurementValue() {
        return this.measurementValue;
    }

    public final void setMeasurementValue(Number number) {
        this.measurementValue = number;
    }

    public final CategoryType getMachineCategoryType() {
        Integer num = this._machineCategoryType;
        if (num != null) {
            CategoryType categoryTypeFromCode = CategoryType.INSTANCE.fromCode(num.intValue());
            if (categoryTypeFromCode != null) {
                return categoryTypeFromCode;
            }
        }
        return CategoryType.UNDEFINED;
    }

    public final PersonalBestType getPersonalBestItem() {
        PersonalBestType personalBestTypeFromRawValue;
        String str = this._personalBestItem;
        return (str == null || (personalBestTypeFromRawValue = PersonalBestType.INSTANCE.fromRawValue(str)) == null) ? PersonalBestType.UNDEFINED : personalBestTypeFromRawValue;
    }

    public final String getAchieveDate() {
        String displayDate;
        String str = this.eventTime;
        return (str == null || (displayDate = toDisplayDate(str)) == null) ? "--" : displayDate;
    }

    public final String getMainValueStr() {
        boolean unitType = Global.INSTANCE.getUnitType();
        switch (WhenMappings.$EnumSwitchMapping$0[getPersonalBestItem().ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (unitType) {
                    ConvertUtils convertUtils = ConvertUtils.INSTANCE;
                    UnitConversion unitConversion = UnitConversion.INSTANCE;
                    Object obj = this.currentBestValue;
                    return ConvertUtils.formatToTwoDecimalSmart$default(convertUtils, unitConversion.getMi(((Number) (obj != null ? obj : 0)).toString(), 2), null, 2, null);
                }
                StringBuilder sb = new StringBuilder("");
                ConvertUtils convertUtils2 = ConvertUtils.INSTANCE;
                Object obj2 = this.currentBestValue;
                return sb.append(ConvertUtils.formatToTwoDecimalSmart$default(convertUtils2, ((Number) (obj2 != null ? obj2 : 0)).toString(), null, 2, null)).toString();
            case 4:
                if (unitType) {
                    ConvertUtils convertUtils3 = ConvertUtils.INSTANCE;
                    UnitConversion unitConversion2 = UnitConversion.INSTANCE;
                    Object obj3 = this.currentBestValue;
                    return ConvertUtils.formatToOneDecimal02$default(convertUtils3, unitConversion2.getM_ToFt(((Number) (obj3 != null ? obj3 : 0)).toString(), 2), null, 2, null);
                }
                StringBuilder sb2 = new StringBuilder("");
                ConvertUtils convertUtils4 = ConvertUtils.INSTANCE;
                Object obj4 = this.currentBestValue;
                return sb2.append(ConvertUtils.formatToOneDecimal02$default(convertUtils4, ((Number) (obj4 != null ? obj4 : 0)).toString(), null, 2, null)).toString();
            case 5:
                StringBuilder sb3 = new StringBuilder("");
                ConvertUtils convertUtils5 = ConvertUtils.INSTANCE;
                Object obj5 = this.currentBestValue;
                return sb3.append(ConvertUtils.formatToOneDecimal02$default(convertUtils5, String.valueOf(((Number) (obj5 != null ? obj5 : 0)).doubleValue() * 1000), null, 2, null)).toString();
            case 6:
            case 7:
            case 8:
            case 9:
                StringBuilder sb4 = new StringBuilder("");
                ConvertUtils convertUtils6 = ConvertUtils.INSTANCE;
                Object obj6 = this.currentBestValue;
                return sb4.append(ConvertUtils.formatToOneDecimal02$default(convertUtils6, ((Number) (obj6 != null ? obj6 : 0)).toString(), null, 2, null)).toString();
            default:
                TimeTools timeTools = TimeTools.INSTANCE;
                Double d = this.currentBestValue;
                return TimeTools.secToTime02$default(timeTools, (long) (d != null ? d.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE), false, 2, null);
        }
    }

    public final boolean getMainValueIsTime() {
        Global.INSTANCE.getUnitType();
        switch (WhenMappings.$EnumSwitchMapping$0[getPersonalBestItem().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                return true;
        }
    }

    public final String getSubValueStr() {
        boolean unitType = Global.INSTANCE.getUnitType();
        int i = WhenMappings.$EnumSwitchMapping$0[getPersonalBestItem().ordinal()];
        Double dValueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                TimeTools timeTools = TimeTools.INSTANCE;
                Double d = this.measurementValue;
                if (d == null) {
                    d = dValueOf;
                }
                return TimeTools.secToTime02$default(timeTools, d.longValue(), false, 2, null);
            case 6:
            case 7:
            case 8:
            case 9:
                TimeTools timeTools2 = TimeTools.INSTANCE;
                Double d2 = this.measurementValue;
                if (d2 == null) {
                    d2 = dValueOf;
                }
                return TimeTools.secToTime02$default(timeTools2, d2.longValue(), false, 2, null);
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                if (unitType) {
                    ConvertUtils convertUtils = ConvertUtils.INSTANCE;
                    UnitConversion unitConversion = UnitConversion.INSTANCE;
                    Number number = this.measurementValue;
                    if (number == null) {
                        number = (Number) 0;
                    }
                    return ConvertUtils.formatToTwoDecimalSmart$default(convertUtils, unitConversion.getMi(number.toString(), 2), null, 2, null);
                }
                StringBuilder sb = new StringBuilder("");
                ConvertUtils convertUtils2 = ConvertUtils.INSTANCE;
                Number number2 = this.measurementValue;
                if (number2 == null) {
                    number2 = (Number) 0;
                }
                return sb.append(ConvertUtils.formatToTwoDecimalSmart$default(convertUtils2, number2.toString(), null, 2, null)).toString();
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                if (unitType) {
                    ConvertUtils convertUtils3 = ConvertUtils.INSTANCE;
                    UnitConversion unitConversion2 = UnitConversion.INSTANCE;
                    Number number3 = this.measurementValue;
                    if (number3 == null) {
                        number3 = (Number) 0;
                    }
                    return ConvertUtils.formatToTwoDecimalSmart$default(convertUtils3, unitConversion2.getMi(number3.toString(), 2), null, 2, null);
                }
                StringBuilder sb2 = new StringBuilder("");
                ConvertUtils convertUtils4 = ConvertUtils.INSTANCE;
                Number number4 = this.measurementValue;
                if (number4 == null) {
                    number4 = (Number) 0;
                }
                return sb2.append(ConvertUtils.formatToTwoDecimalSmart$default(convertUtils4, number4.toString(), null, 2, null)).toString();
            case 20:
                StringBuilder sb3 = new StringBuilder("");
                ConvertUtils convertUtils5 = ConvertUtils.INSTANCE;
                Number number5 = this.measurementValue;
                if (number5 == null) {
                    number5 = (Number) 0;
                }
                return sb3.append(ConvertUtils.formatToOneDecimal02$default(convertUtils5, number5.toString(), null, 2, null)).toString();
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                StringBuilder sb4 = new StringBuilder("");
                ConvertUtils convertUtils6 = ConvertUtils.INSTANCE;
                Number number6 = this.measurementValue;
                if (number6 == null) {
                    number6 = (Number) 0;
                }
                return sb4.append(ConvertUtils.formatToOneDecimal02$default(convertUtils6, number6.toString(), null, 2, null)).toString();
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
                StringBuilder sb5 = new StringBuilder("");
                ConvertUtils convertUtils7 = ConvertUtils.INSTANCE;
                Number number7 = this.measurementValue;
                if (number7 == null) {
                    number7 = (Number) 0;
                }
                return sb5.append(ConvertUtils.formatToIntegerRounded$default(convertUtils7, String.valueOf(number7.doubleValue() * 1000), null, 2, null)).toString();
            default:
                return "";
        }
    }

    public final boolean getSubValueIsTime() {
        Global.INSTANCE.getUnitType();
        switch (WhenMappings.$EnumSwitchMapping$0[getPersonalBestItem().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getUnit(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.soletreadmills.sole_v2.Global r0 = com.soletreadmills.sole_v2.Global.INSTANCE
            boolean r0 = r0.getUnitType()
            com.soletreadmills.sole_v2._type.PersonalBestType r1 = r3.getPersonalBestItem()
            int[] r2 = com.soletreadmills.sole_v2._data.UserPersonalBestVoData.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            java.lang.String r2 = "getString(...)"
            switch(r1) {
                case 4: goto L46;
                case 5: goto L3c;
                case 6: goto L32;
                case 7: goto L32;
                case 8: goto L32;
                case 9: goto L32;
                default: goto L1c;
            }
        L1c:
            switch(r1) {
                case 20: goto L32;
                case 21: goto L46;
                case 22: goto L46;
                case 23: goto L46;
                case 24: goto L46;
                case 25: goto L46;
                case 26: goto L3c;
                case 27: goto L3c;
                case 28: goto L3c;
                case 29: goto L3c;
                case 30: goto L3c;
                default: goto L1f;
            }
        L1f:
            if (r0 == 0) goto L28
            int r0 = com.soletreadmills.sole_v2.R.string.mi
            java.lang.String r4 = r4.getString(r0)
            goto L2e
        L28:
            int r0 = com.soletreadmills.sole_v2.R.string.km
            java.lang.String r4 = r4.getString(r0)
        L2e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            goto L4f
        L32:
            int r0 = com.soletreadmills.sole_v2.R.string.w
            java.lang.String r4 = r4.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            goto L4f
        L3c:
            int r0 = com.soletreadmills.sole_v2.R.string.m
            java.lang.String r4 = r4.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            goto L4f
        L46:
            int r0 = com.soletreadmills.sole_v2.R.string.m
            java.lang.String r4 = r4.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
        L4f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._data.UserPersonalBestVoData.getUnit(android.content.Context):java.lang.String");
    }

    public final String toDisplayDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            String str2 = LocalDateTime.parse(str, DateTimeFormatter.ofPattern(AppConfig.PATTERN_DATE_TIME)).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault()));
            Intrinsics.checkNotNull(str2);
            return str2;
        } catch (Exception unused) {
            return str;
        }
    }
}
