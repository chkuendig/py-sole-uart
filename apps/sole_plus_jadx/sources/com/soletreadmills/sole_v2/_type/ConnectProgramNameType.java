package com.soletreadmills.sole_v2._type;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ConnectProgramNameType.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u001d\u001a\u00020\rJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u001d\u001a\u00020\rJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0007\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6¨\u00067"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;", "", "titleRes", "", "id", "descRes", "(Ljava/lang/String;IIII)V", "defaultIcon", "getDefaultIcon", "()I", "getDescRes", "equipmentSettingsMap", "", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "", "Lcom/soletreadmills/sole_v2/_type/ConnectProgramSettingsType;", "getEquipmentSettingsMap", "()Ljava/util/Map;", "getId", "getTitleRes", "type", "Lcom/soletreadmills/sole_v2/_type/ConnectProgramType;", "getType", "()Lcom/soletreadmills/sole_v2/_type/ConnectProgramType;", "getDesc", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "getInclineList", "machineType", "getResistList", "getSpeedList", "getTitle", "Manual", "Hill", "Fatburn", "Cardio", "Strength", "Interval", TypedValues.Custom.NAME, "AirForce", "Army", "CoastGuard", "Gerkin", "PEB", "MarineCorps", "Navy", "FitnessTests", "WFI", "Run_5k", "Run_10k", "Distance", "Calories", "HeartRate", "Ascent", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectProgramNameType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConnectProgramNameType[] $VALUES;
    private final int descRes;
    private final int id;
    private final int titleRes;
    public static final ConnectProgramNameType Manual = new ConnectProgramNameType("Manual", 0, R.string.program_manual, 1, R.string.desc_manual);
    public static final ConnectProgramNameType Hill = new ConnectProgramNameType("Hill", 1, R.string.program_hill, 2, R.string.desc_hill);
    public static final ConnectProgramNameType Fatburn = new ConnectProgramNameType("Fatburn", 2, R.string.program_fatburn, 3, R.string.desc_fatburn);
    public static final ConnectProgramNameType Cardio = new ConnectProgramNameType("Cardio", 3, R.string.program_cardio, 4, R.string.desc_cardio);
    public static final ConnectProgramNameType Strength = new ConnectProgramNameType("Strength", 4, R.string.program_strength, 5, R.string.desc_strength);
    public static final ConnectProgramNameType Interval = new ConnectProgramNameType("Interval", 5, R.string.program_interval, 6, R.string.desc_hiit);
    public static final ConnectProgramNameType Custom = new ConnectProgramNameType(TypedValues.Custom.NAME, 6, R.string.program_custom, 7, R.string.desc_custom);
    public static final ConnectProgramNameType AirForce = new ConnectProgramNameType("AirForce", 7, R.string.program_air_force, 25, R.string.desc_military_run);
    public static final ConnectProgramNameType Army = new ConnectProgramNameType("Army", 8, R.string.program_army, 23, R.string.desc_military_run);
    public static final ConnectProgramNameType CoastGuard = new ConnectProgramNameType("CoastGuard", 9, R.string.program_coast_guard, 28, R.string.desc_military_run);
    public static final ConnectProgramNameType Gerkin = new ConnectProgramNameType("Gerkin", 10, R.string.program_gerkin, 21, R.string.desc_gerkin);
    public static final ConnectProgramNameType PEB = new ConnectProgramNameType("PEB", 11, R.string.program_peb, 27, R.string.desc_military_run);
    public static final ConnectProgramNameType MarineCorps = new ConnectProgramNameType("MarineCorps", 12, R.string.program_marine_corps, 26, R.string.desc_military_run);
    public static final ConnectProgramNameType Navy = new ConnectProgramNameType("Navy", 13, R.string.program_navy, 24, R.string.desc_military_run);
    public static final ConnectProgramNameType FitnessTests = new ConnectProgramNameType("FitnessTests", 14, R.string.program_fitness_tests, 63, R.string.desc_gerkin);
    public static final ConnectProgramNameType WFI = new ConnectProgramNameType("WFI", 15, R.string.program_wfi, 22, R.string.desc_gerkin);
    public static final ConnectProgramNameType Run_5k = new ConnectProgramNameType("Run_5k", 16, R.string.program_5k_run, 61, R.string.desc_5k_run);
    public static final ConnectProgramNameType Run_10k = new ConnectProgramNameType("Run_10k", 17, R.string.program_10k_run, 62, R.string.desc_10k_run);
    public static final ConnectProgramNameType Distance = new ConnectProgramNameType("Distance", 18, R.string.program_distance, -1, R.string.desc_distance);
    public static final ConnectProgramNameType Calories = new ConnectProgramNameType("Calories", 19, R.string.program_calories, -1, R.string.desc_calories);
    public static final ConnectProgramNameType HeartRate = new ConnectProgramNameType("HeartRate", 20, R.string.program_heart_rate, 9, R.string.desc_heart_rate);
    public static final ConnectProgramNameType Ascent = new ConnectProgramNameType("Ascent", 21, R.string.program_ascent, -1, R.string.desc_ascent);

    /* compiled from: ConnectProgramNameType.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ConnectProgramNameType.values().length];
            try {
                iArr[ConnectProgramNameType.Run_5k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConnectProgramNameType.Run_10k.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConnectProgramNameType.HeartRate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConnectProgramNameType.Calories.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ConnectProgramNameType.Distance.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ConnectProgramNameType.Manual.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ConnectProgramNameType.Custom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ConnectProgramNameType.AirForce.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ConnectProgramNameType.Army.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ConnectProgramNameType.MarineCorps.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ConnectProgramNameType.Navy.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ConnectProgramNameType.PEB.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ConnectProgramNameType.Gerkin.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ConnectProgramNameType.CoastGuard.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ConnectProgramNameType.Hill.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ConnectProgramNameType.Strength.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ConnectProgramNameType.Fatburn.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ConnectProgramNameType.Cardio.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ConnectProgramNameType.Interval.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ConnectProgramNameType.WFI.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ConnectProgramNameType.Ascent.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ConnectProgramNameType.FitnessTests.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BleFtmsMachineType.values().length];
            try {
                iArr2[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[BleFtmsMachineType.BIKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[BleFtmsMachineType.ROWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused26) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private static final /* synthetic */ ConnectProgramNameType[] $values() {
        return new ConnectProgramNameType[]{Manual, Hill, Fatburn, Cardio, Strength, Interval, Custom, AirForce, Army, CoastGuard, Gerkin, PEB, MarineCorps, Navy, FitnessTests, WFI, Run_5k, Run_10k, Distance, Calories, HeartRate, Ascent};
    }

    public static EnumEntries<ConnectProgramNameType> getEntries() {
        return $ENTRIES;
    }

    public static ConnectProgramNameType valueOf(String str) {
        return (ConnectProgramNameType) Enum.valueOf(ConnectProgramNameType.class, str);
    }

    public static ConnectProgramNameType[] values() {
        return (ConnectProgramNameType[]) $VALUES.clone();
    }

    private ConnectProgramNameType(String str, int i, int i2, int i3, int i4) {
        this.titleRes = i2;
        this.id = i3;
        this.descRes = i4;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final int getId() {
        return this.id;
    }

    public final int getDescRes() {
        return this.descRes;
    }

    static {
        ConnectProgramNameType[] connectProgramNameTypeArr$values = $values();
        $VALUES = connectProgramNameTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(connectProgramNameTypeArr$values);
    }

    public final String getTitle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(this.titleRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String getDesc(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getString(this.descRes);
    }

    public final int getDefaultIcon() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return R.drawable.program_5k;
            case 2:
                return R.drawable.program_10k;
            case 3:
                return R.drawable.program_heart_rate;
            case 4:
                return R.drawable.program_calories;
            case 5:
                return R.drawable.program_distance;
            case 6:
                return R.drawable.program_timer;
            case 7:
                return R.drawable.program_custom;
            default:
                return R.drawable.ic_messages_sys_info;
        }
    }

    public final Map<BleFtmsMachineType, List<ConnectProgramSettingsType>> getEquipmentSettingsMap() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
                return MapsKt.mapOf(TuplesKt.to(BleFtmsMachineType.TREADMILL, CollectionsKt.listOf(ConnectProgramSettingsType.TargetSpeed)));
            case 3:
                return MapsKt.mapOf(TuplesKt.to(BleFtmsMachineType.TREADMILL, CollectionsKt.listOf(ConnectProgramSettingsType.TargetTime)), TuplesKt.to(BleFtmsMachineType.BIKE, CollectionsKt.listOf(ConnectProgramSettingsType.TargetTime)), TuplesKt.to(BleFtmsMachineType.ELLIPTICAL, CollectionsKt.listOf(ConnectProgramSettingsType.TargetTime)));
            case 4:
                return MapsKt.emptyMap();
            case 5:
                return MapsKt.emptyMap();
            case 6:
                return MapsKt.mapOf(TuplesKt.to(BleFtmsMachineType.TREADMILL, CollectionsKt.listOf(ConnectProgramSettingsType.TargetTime)), TuplesKt.to(BleFtmsMachineType.BIKE, CollectionsKt.listOf(ConnectProgramSettingsType.TargetTime)), TuplesKt.to(BleFtmsMachineType.ELLIPTICAL, CollectionsKt.listOf(ConnectProgramSettingsType.TargetTime)), TuplesKt.to(BleFtmsMachineType.ROWER, CollectionsKt.listOf(ConnectProgramSettingsType.TargetTime)), TuplesKt.to(BleFtmsMachineType.STEPPER, CollectionsKt.listOf(ConnectProgramSettingsType.TargetTime)));
            case 7:
                return MapsKt.mapOf(TuplesKt.to(BleFtmsMachineType.TREADMILL, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxSpeed, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.BIKE, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.ELLIPTICAL, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.ROWER, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})));
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return MapsKt.emptyMap();
            case 15:
                return MapsKt.mapOf(TuplesKt.to(BleFtmsMachineType.TREADMILL, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxSpeed, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.BIKE, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.ELLIPTICAL, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.STEPPER, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})));
            case 16:
                return MapsKt.mapOf(TuplesKt.to(BleFtmsMachineType.TREADMILL, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxSpeed, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.BIKE, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.ELLIPTICAL, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.ROWER, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})));
            case 17:
            case 18:
            case 19:
                return MapsKt.mapOf(TuplesKt.to(BleFtmsMachineType.TREADMILL, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxSpeed, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.BIKE, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.ELLIPTICAL, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.ROWER, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})), TuplesKt.to(BleFtmsMachineType.STEPPER, CollectionsKt.listOf((Object[]) new ConnectProgramSettingsType[]{ConnectProgramSettingsType.MaxResistance, ConnectProgramSettingsType.TargetTime})));
            case 20:
            case 21:
                return MapsKt.mapOf(TuplesKt.to(BleFtmsMachineType.STEPPER, CollectionsKt.listOf(ConnectProgramSettingsType.TargetTime)));
            case 22:
                return MapsKt.mapOf(TuplesKt.to(BleFtmsMachineType.BIKE, CollectionsKt.emptyList()), TuplesKt.to(BleFtmsMachineType.ELLIPTICAL, CollectionsKt.emptyList()));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final ConnectProgramType getType() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i != 6 && i != 7) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                default:
                    return ConnectProgramType.Targets;
            }
        }
        return ConnectProgramType.Preset;
    }

    public final List<Integer> getSpeedList(BleFtmsMachineType machineType) {
        Intrinsics.checkNotNullParameter(machineType, "machineType");
        if (WhenMappings.$EnumSwitchMapping$1[machineType.ordinal()] == 1) {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            }
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.emptyList();
    }

    public final List<Integer> getInclineList(BleFtmsMachineType machineType) {
        Intrinsics.checkNotNullParameter(machineType, "machineType");
        int i = WhenMappings.$EnumSwitchMapping$1[machineType.ordinal()];
        if (i == 1) {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 15:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 1, 2, 2, 3, 2, 3, 3, 3, 2, 3, 2, 3, 3, 2, 1, 1, 1});
                case 16:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 1, 2, 3, 4, 5, 4, 4, 3, 3, 2, 3, 3, 4, 4, 3, 1, 1});
                case 17:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 1, 2, 3, 3, 2, 3, 3, 2, 2, 2, 3, 3, 4, 3, 2, 1, 1});
                case 18:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 3, 2, 2, 1, 1, 1});
                case 19:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 1, 2, 2, 3, 2, 2, 4, 2, 2, 4, 2, 2, 5, 2, 2, 2, 1});
                default:
                    return CollectionsKt.emptyList();
            }
        }
        if (i == 2) {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 15:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 3, 3});
                case 16:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 3, 3, 3});
                case 17:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3});
                case 18:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 4, 4, 5, 2, 2, 2, 2, 5, 2, 2, 2, 2, 5, 1, 1, 1, 4});
                case 19:
                    return CollectionsKt.listOf((Object[]) new Integer[]{2, 5, 5, 2, 2, 5, 5, 2, 2, 5, 5, 2, 2, 5, 5, 2, 2, 5});
                default:
                    return CollectionsKt.emptyList();
            }
        }
        return CollectionsKt.emptyList();
    }

    public final List<Integer> getResistList(BleFtmsMachineType machineType) {
        Intrinsics.checkNotNullParameter(machineType, "machineType");
        int i = WhenMappings.$EnumSwitchMapping$1[machineType.ordinal()];
        if (i == 2) {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 15:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 3, 4, 4, 5, 5, 7, 7, 5, 5, 4, 4, 3, 3, 2, 1});
                case 16:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8, 8, 8, 8, 2, 1});
                case 17:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 1});
                case 18:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 5, 6, 7, 6, 5, 6, 7, 6, 5, 6, 7, 6, 5, 6, 2, 1});
                case 19:
                    return CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 7, 7, 2, 2, 7, 7, 2, 2, 7, 7, 2, 2, 7, 7, 2, 1});
                default:
                    return CollectionsKt.emptyList();
            }
        }
        if (i != 3) {
            if (i == 4) {
                switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                    case 16:
                        return CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8, 8, 8, 8, 6, 4, 1});
                    case 17:
                        return CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 2, 1});
                    case 18:
                        return CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 5, 6, 7, 6, 6, 6, 7, 6, 5, 6, 7, 6, 5, 6, 5, 2, 1});
                    default:
                        return CollectionsKt.emptyList();
                }
            }
            return CollectionsKt.emptyList();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 15:
                return CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 3, 4, 4, 5, 5, 7, 7, 5, 5, 4, 4, 3, 3, 2, 1});
            case 16:
                return CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8, 8, 8, 8, 2, 1});
            case 17:
                return CollectionsKt.listOf((Object[]) new Integer[]{1, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 1});
            case 18:
                return CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 5, 6, 7, 6, 5, 6, 7, 6, 5, 6, 7, 6, 5, 6, 2, 1});
            case 19:
                return CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 7, 7, 2, 2, 7, 7, 2, 2, 7, 7, 2, 2, 7, 7, 2, 1});
            default:
                return CollectionsKt.emptyList();
        }
    }
}
