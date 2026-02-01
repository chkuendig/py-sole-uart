package com.soletreadmills.sole_v2.ble.cmd;

import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FitnessMachineControlHelper.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001f B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bJ \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006!"}, d2 = {"Lcom/soletreadmills/sole_v2/ble/cmd/FitnessMachineControlHelper;", "", "()V", "adjustIncline", "", IInstrumentationResultParser.StatusKeys.CURRENT, "", "delta", "adjustResistance", "adjustSpeed", "isMetric", "", "getConfig", "Lcom/soletreadmills/sole_v2/ble/cmd/FitnessMachineControlHelper$AdjustConfig;", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "position", "Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeAdjustCustomView$Position;", "minus", "controlType", "Lcom/soletreadmills/sole_v2/ble/cmd/FitnessMachineControlHelper$ControlType;", "currentValue", "plus", "sendInclineCmd", "incline", "sendResistanceCmd", "resistance", "sendSpeedCmd", "speedKm", "setValue", "targetValue", "AdjustConfig", "ControlType", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FitnessMachineControlHelper {
    public static final int $stable = 0;
    public static final FitnessMachineControlHelper INSTANCE = new FitnessMachineControlHelper();

    /* compiled from: FitnessMachineControlHelper.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DisplayModeAdjustCustomView.Position.values().length];
            try {
                iArr[DisplayModeAdjustCustomView.Position.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayModeAdjustCustomView.Position.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BleFtmsMachineType.values().length];
            try {
                iArr2[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[BleFtmsMachineType.BIKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[BleFtmsMachineType.ROWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[BleFtmsMachineType.STEPPER.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ControlType.values().length];
            try {
                iArr3[ControlType.SPEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ControlType.INCLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ControlType.RESISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    private FitnessMachineControlHelper() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: FitnessMachineControlHelper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/ble/cmd/FitnessMachineControlHelper$ControlType;", "", "(Ljava/lang/String;I)V", "SPEED", "INCLINE", "RESISTANCE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ControlType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ControlType[] $VALUES;
        public static final ControlType SPEED = new ControlType("SPEED", 0);
        public static final ControlType INCLINE = new ControlType("INCLINE", 1);
        public static final ControlType RESISTANCE = new ControlType("RESISTANCE", 2);

        private static final /* synthetic */ ControlType[] $values() {
            return new ControlType[]{SPEED, INCLINE, RESISTANCE};
        }

        public static EnumEntries<ControlType> getEntries() {
            return $ENTRIES;
        }

        public static ControlType valueOf(String str) {
            return (ControlType) Enum.valueOf(ControlType.class, str);
        }

        public static ControlType[] values() {
            return (ControlType[]) $VALUES.clone();
        }

        private ControlType(String str, int i) {
        }

        static {
            ControlType[] controlTypeArr$values = $values();
            $VALUES = controlTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(controlTypeArr$values);
        }
    }

    /* compiled from: FitnessMachineControlHelper.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u000bHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/soletreadmills/sole_v2/ble/cmd/FitnessMachineControlHelper$AdjustConfig;", "", "controlType", "Lcom/soletreadmills/sole_v2/ble/cmd/FitnessMachineControlHelper$ControlType;", "title", "", HealthConstants.FoodIntake.UNIT, "quickButtons", "", "", "isVisible", "", "(Lcom/soletreadmills/sole_v2/ble/cmd/FitnessMachineControlHelper$ControlType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getControlType", "()Lcom/soletreadmills/sole_v2/ble/cmd/FitnessMachineControlHelper$ControlType;", "()Z", "getQuickButtons", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getUnit", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AdjustConfig {
        public static final int $stable = 8;
        private final ControlType controlType;
        private final boolean isVisible;
        private final List<Integer> quickButtons;
        private final String title;
        private final String unit;

        public static /* synthetic */ AdjustConfig copy$default(AdjustConfig adjustConfig, ControlType controlType, String str, String str2, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                controlType = adjustConfig.controlType;
            }
            if ((i & 2) != 0) {
                str = adjustConfig.title;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = adjustConfig.unit;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                list = adjustConfig.quickButtons;
            }
            List list2 = list;
            if ((i & 16) != 0) {
                z = adjustConfig.isVisible;
            }
            return adjustConfig.copy(controlType, str3, str4, list2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final ControlType getControlType() {
            return this.controlType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final String getUnit() {
            return this.unit;
        }

        public final List<Integer> component4() {
            return this.quickButtons;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsVisible() {
            return this.isVisible;
        }

        public final AdjustConfig copy(ControlType controlType, String title, String unit, List<Integer> quickButtons, boolean isVisible) {
            Intrinsics.checkNotNullParameter(controlType, "controlType");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(unit, "unit");
            Intrinsics.checkNotNullParameter(quickButtons, "quickButtons");
            return new AdjustConfig(controlType, title, unit, quickButtons, isVisible);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdjustConfig)) {
                return false;
            }
            AdjustConfig adjustConfig = (AdjustConfig) other;
            return this.controlType == adjustConfig.controlType && Intrinsics.areEqual(this.title, adjustConfig.title) && Intrinsics.areEqual(this.unit, adjustConfig.unit) && Intrinsics.areEqual(this.quickButtons, adjustConfig.quickButtons) && this.isVisible == adjustConfig.isVisible;
        }

        public int hashCode() {
            return (((((((this.controlType.hashCode() * 31) + this.title.hashCode()) * 31) + this.unit.hashCode()) * 31) + this.quickButtons.hashCode()) * 31) + Boolean.hashCode(this.isVisible);
        }

        public String toString() {
            return "AdjustConfig(controlType=" + this.controlType + ", title=" + this.title + ", unit=" + this.unit + ", quickButtons=" + this.quickButtons + ", isVisible=" + this.isVisible + ')';
        }

        public AdjustConfig(ControlType controlType, String title, String unit, List<Integer> quickButtons, boolean z) {
            Intrinsics.checkNotNullParameter(controlType, "controlType");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(unit, "unit");
            Intrinsics.checkNotNullParameter(quickButtons, "quickButtons");
            this.controlType = controlType;
            this.title = title;
            this.unit = unit;
            this.quickButtons = quickButtons;
            this.isVisible = z;
        }

        public /* synthetic */ AdjustConfig(ControlType controlType, String str, String str2, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(controlType, str, str2, list, (i & 16) != 0 ? true : z);
        }

        public final ControlType getControlType() {
            return this.controlType;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUnit() {
            return this.unit;
        }

        public final List<Integer> getQuickButtons() {
            return this.quickButtons;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }
    }

    public final AdjustConfig getConfig(BleFtmsMachineType machineType, boolean isMetric, DisplayModeAdjustCustomView.Position position) {
        Intrinsics.checkNotNullParameter(machineType, "machineType");
        Intrinsics.checkNotNullParameter(position, "position");
        int i = WhenMappings.$EnumSwitchMapping$1[machineType.ordinal()];
        if (i == 1) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return new AdjustConfig(ControlType.INCLINE, "Incline", "%", CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15}), false, 16, null);
                }
                throw new NoWhenBranchMatchedException();
            }
            if (isMetric) {
                return new AdjustConfig(ControlType.SPEED, RtspHeaders.SPEED, "km/h", CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 6, 8, 10, 12, 14, 16, 18, 20}), false, 16, null);
            }
            return new AdjustConfig(ControlType.SPEED, RtspHeaders.SPEED, "mph", CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}), false, 16, null);
        }
        if (i == 2) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
            if (i3 == 1) {
                return new AdjustConfig(ControlType.RESISTANCE, "Resistance", "Level", CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 6, 8, 10, 12, 14, 16, 18, 20}), false, 16, null);
            }
            if (i3 == 2) {
                return new AdjustConfig(ControlType.INCLINE, "Incline", "%", CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15}), false, 16, null);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (i == 3) {
            int i4 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
            if (i4 == 1) {
                return new AdjustConfig(ControlType.RESISTANCE, "Resistance", "Level", CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 6, 8, 10, 12, 14, 16, 18, 20}), false, 16, null);
            }
            if (i4 == 2) {
                return new AdjustConfig(ControlType.RESISTANCE, "", "", CollectionsKt.emptyList(), false);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (i == 4) {
            int i5 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
            if (i5 == 1) {
                return new AdjustConfig(ControlType.RESISTANCE, "Resistance", "Level", CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 5, 6, 8, 10, 12, 14, 16}), false, 16, null);
            }
            if (i5 == 2) {
                return new AdjustConfig(ControlType.RESISTANCE, "", "", CollectionsKt.emptyList(), false);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (i == 5) {
            int i6 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
            if (i6 == 1) {
                return new AdjustConfig(ControlType.RESISTANCE, "Resistance", "Level", CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 6, 8, 10, 12, 14, 16, 18, 20}), false, 16, null);
            }
            if (i6 == 2) {
                return new AdjustConfig(ControlType.RESISTANCE, "", "", CollectionsKt.emptyList(), false);
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void plus$default(FitnessMachineControlHelper fitnessMachineControlHelper, ControlType controlType, float f, boolean z, int i, Object obj) throws NumberFormatException {
        if ((i & 4) != 0) {
            z = true;
        }
        fitnessMachineControlHelper.plus(controlType, f, z);
    }

    public final void plus(ControlType controlType, float currentValue, boolean isMetric) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(controlType, "controlType");
        int i = WhenMappings.$EnumSwitchMapping$2[controlType.ordinal()];
        if (i == 1) {
            adjustSpeed(currentValue, 0.1f, isMetric);
        } else if (i == 2) {
            adjustIncline(currentValue, 1.0f);
        } else {
            if (i != 3) {
                return;
            }
            adjustResistance(currentValue, 1.0f);
        }
    }

    public static /* synthetic */ void minus$default(FitnessMachineControlHelper fitnessMachineControlHelper, ControlType controlType, float f, boolean z, int i, Object obj) throws NumberFormatException {
        if ((i & 4) != 0) {
            z = true;
        }
        fitnessMachineControlHelper.minus(controlType, f, z);
    }

    public final void minus(ControlType controlType, float currentValue, boolean isMetric) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(controlType, "controlType");
        int i = WhenMappings.$EnumSwitchMapping$2[controlType.ordinal()];
        if (i == 1) {
            adjustSpeed(currentValue, -0.1f, isMetric);
        } else if (i == 2) {
            adjustIncline(currentValue, -1.0f);
        } else {
            if (i != 3) {
                return;
            }
            adjustResistance(currentValue, -1.0f);
        }
    }

    public static /* synthetic */ void setValue$default(FitnessMachineControlHelper fitnessMachineControlHelper, ControlType controlType, float f, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        fitnessMachineControlHelper.setValue(controlType, f, z);
    }

    public final void setValue(ControlType controlType, float targetValue, boolean isMetric) {
        Intrinsics.checkNotNullParameter(controlType, "controlType");
        if (targetValue == -99.0f) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$2[controlType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                sendInclineCmd(targetValue);
                return;
            } else {
                if (i != 3) {
                    return;
                }
                sendResistanceCmd(targetValue);
                return;
            }
        }
        if (!isMetric) {
            Float floatOrNull = StringsKt.toFloatOrNull(UnitConversion.INSTANCE.getKm(String.valueOf(targetValue), 2));
            if (floatOrNull == null) {
                return;
            } else {
                targetValue = floatOrNull.floatValue();
            }
        }
        sendSpeedCmd(targetValue);
    }

    private final void adjustSpeed(float current, float delta, boolean isMetric) throws NumberFormatException {
        float fFloatValue;
        if (current == -99.0f) {
            return;
        }
        if (isMetric) {
            fFloatValue = BigDecimal.valueOf(current).add(BigDecimal.valueOf(delta)).setScale(1, RoundingMode.HALF_UP).floatValue();
        } else {
            try {
                fFloatValue = Float.parseFloat(UnitConversion.INSTANCE.getKm(String.valueOf(BigDecimal.valueOf(Float.parseFloat(UnitConversion.INSTANCE.getMi(String.valueOf(current), 2))).add(BigDecimal.valueOf(delta)).setScale(1, RoundingMode.HALF_UP).floatValue()), 2));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        sendSpeedCmd(fFloatValue);
    }

    private final void adjustIncline(float current, float delta) {
        if (current == -99.0f) {
            return;
        }
        sendInclineCmd(current + delta);
    }

    private final void adjustResistance(float current, float delta) {
        if (current == -99.0f) {
            return;
        }
        sendResistanceCmd(current + delta);
    }

    private final void sendSpeedCmd(float speedKm) {
        BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.setTargetSpeed(speedKm));
    }

    private final void sendInclineCmd(float incline) {
        BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.setTargetInclination(incline));
    }

    private final void sendResistanceCmd(float resistance) {
        BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.setTargetResistanceLevel(resistance));
    }
}
