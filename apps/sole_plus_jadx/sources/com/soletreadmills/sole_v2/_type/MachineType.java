package com.soletreadmills.sole_v2._type;

import androidx.exifinterface.media.ExifInterface;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MachineType.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/MachineType;", "", "ftmsType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "apiCatalogType", "", "(Ljava/lang/String;ILcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;Ljava/lang/String;)V", "getApiCatalogType", "()Ljava/lang/String;", "getFtmsType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "TREADMILL", "ELLIPTICAL", "BIKE", "ROWER", "STEPPER", "ALL", "HR", "GARMIN", "SRVO", "NOFTMS", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MachineType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MachineType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String apiCatalogType;
    private final BleFtmsMachineType ftmsType;
    public static final MachineType TREADMILL = new MachineType("TREADMILL", 0, BleFtmsMachineType.TREADMILL, "0");
    public static final MachineType ELLIPTICAL = new MachineType("ELLIPTICAL", 1, BleFtmsMachineType.ELLIPTICAL, "2");
    public static final MachineType BIKE = new MachineType("BIKE", 2, BleFtmsMachineType.BIKE, "1");
    public static final MachineType ROWER = new MachineType("ROWER", 3, BleFtmsMachineType.ROWER, TlbConst.TYPELIB_MINOR_VERSION_WORD);
    public static final MachineType STEPPER = new MachineType("STEPPER", 4, BleFtmsMachineType.STEPPER, ExifInterface.GPS_MEASUREMENT_3D);
    public static final MachineType ALL = new MachineType("ALL", 5, null, "99");
    public static final MachineType HR = new MachineType("HR", 6, null, "-99");
    public static final MachineType GARMIN = new MachineType("GARMIN", 7, null, AppConfig.BRAND_CODE_GARMIN);
    public static final MachineType SRVO = new MachineType("SRVO", 8, null, TlbConst.TYPELIB_MINOR_VERSION_OFFICE);
    public static final MachineType NOFTMS = new MachineType("NOFTMS", 9, null, "6");

    private static final /* synthetic */ MachineType[] $values() {
        return new MachineType[]{TREADMILL, ELLIPTICAL, BIKE, ROWER, STEPPER, ALL, HR, GARMIN, SRVO, NOFTMS};
    }

    @JvmStatic
    public static final MachineType fromApiCatalogType(String str) {
        return INSTANCE.fromApiCatalogType(str);
    }

    public static EnumEntries<MachineType> getEntries() {
        return $ENTRIES;
    }

    public static MachineType valueOf(String str) {
        return (MachineType) Enum.valueOf(MachineType.class, str);
    }

    public static MachineType[] values() {
        return (MachineType[]) $VALUES.clone();
    }

    private MachineType(String str, int i, BleFtmsMachineType bleFtmsMachineType, String str2) {
        this.ftmsType = bleFtmsMachineType;
        this.apiCatalogType = str2;
    }

    public final BleFtmsMachineType getFtmsType() {
        return this.ftmsType;
    }

    public final String getApiCatalogType() {
        return this.apiCatalogType;
    }

    static {
        MachineType[] machineTypeArr$values = $values();
        $VALUES = machineTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(machineTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: MachineType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/MachineType$Companion;", "", "()V", "fromApiCatalogType", "Lcom/soletreadmills/sole_v2/_type/MachineType;", "type", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MachineType fromApiCatalogType(String type) {
            MachineType machineType = null;
            if (type == null) {
                return null;
            }
            Iterator<MachineType> it = MachineType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MachineType next = it.next();
                if (Intrinsics.areEqual(next.getApiCatalogType(), type)) {
                    machineType = next;
                    break;
                }
            }
            return machineType;
        }
    }
}
