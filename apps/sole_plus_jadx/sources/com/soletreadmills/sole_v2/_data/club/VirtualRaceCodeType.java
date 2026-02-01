package com.soletreadmills.sole_v2._data.club;

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
/* compiled from: VirtualRaceCode.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB;\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/VirtualRaceCodeType;", "", "code", "", "distanceKm", "", "assetsImgName", "imageResourceId", "machineTypeId", "pathID", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;I)V", "getAssetsImgName", "()Ljava/lang/String;", "getCode", "getDistanceKm", "()I", "getImageResourceId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMachineTypeId", "getPathID", "setPathID", "(I)V", "T_3K", "T_5K", "T_8K", "T_10K", "T_21K", "T_42K", "B_20K", "B_40K", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VirtualRaceCodeType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VirtualRaceCodeType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String assetsImgName;
    private final String code;
    private final int distanceKm;
    private final Integer imageResourceId;
    private final Integer machineTypeId;
    private int pathID;
    public static final VirtualRaceCodeType T_3K = new VirtualRaceCodeType("T_3K", 0, "T_3K", 3, "distance_3k.png", Integer.valueOf(R.drawable.t_3k), ChallengeMachineTypeItems.TREADMILL.getId(), R.string.path_3k);
    public static final VirtualRaceCodeType T_5K = new VirtualRaceCodeType("T_5K", 1, "T_5K", 5, "distance_5k.png", Integer.valueOf(R.drawable.t_5k), ChallengeMachineTypeItems.TREADMILL.getId(), R.string.path_5k);
    public static final VirtualRaceCodeType T_8K = new VirtualRaceCodeType("T_8K", 2, "T_8K", 8, "distance_8k.png", Integer.valueOf(R.drawable.t_8k), ChallengeMachineTypeItems.TREADMILL.getId(), R.string.path_8k);
    public static final VirtualRaceCodeType T_10K = new VirtualRaceCodeType("T_10K", 3, "T_10K", 10, "distance_10k.png", Integer.valueOf(R.drawable.t_10k), ChallengeMachineTypeItems.TREADMILL.getId(), R.string.path_10k);
    public static final VirtualRaceCodeType T_21K = new VirtualRaceCodeType("T_21K", 4, "T_21K", 21, "distance_21k.png", Integer.valueOf(R.drawable.t_21k), ChallengeMachineTypeItems.TREADMILL.getId(), R.string.path_21k);
    public static final VirtualRaceCodeType T_42K = new VirtualRaceCodeType("T_42K", 5, "T_42K", 42, "distance_42k.png", Integer.valueOf(R.drawable.t_42k), ChallengeMachineTypeItems.TREADMILL.getId(), R.string.path_42k);
    public static final VirtualRaceCodeType B_20K = new VirtualRaceCodeType("B_20K", 6, "B_20K", 20, "distance_21k.png", Integer.valueOf(R.drawable.t_21k), ChallengeMachineTypeItems.BIKE.getId(), R.string.path_21k);
    public static final VirtualRaceCodeType B_40K = new VirtualRaceCodeType("B_40K", 7, "B_40K", 40, "distance_42k.png", Integer.valueOf(R.drawable.t_42k), ChallengeMachineTypeItems.BIKE.getId(), R.string.path_42k);

    private static final /* synthetic */ VirtualRaceCodeType[] $values() {
        return new VirtualRaceCodeType[]{T_3K, T_5K, T_8K, T_10K, T_21K, T_42K, B_20K, B_40K};
    }

    public static EnumEntries<VirtualRaceCodeType> getEntries() {
        return $ENTRIES;
    }

    public static VirtualRaceCodeType valueOf(String str) {
        return (VirtualRaceCodeType) Enum.valueOf(VirtualRaceCodeType.class, str);
    }

    public static VirtualRaceCodeType[] values() {
        return (VirtualRaceCodeType[]) $VALUES.clone();
    }

    private VirtualRaceCodeType(String str, int i, String str2, int i2, String str3, Integer num, Integer num2, int i3) {
        this.code = str2;
        this.distanceKm = i2;
        this.assetsImgName = str3;
        this.imageResourceId = num;
        this.machineTypeId = num2;
        this.pathID = i3;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getDistanceKm() {
        return this.distanceKm;
    }

    public final String getAssetsImgName() {
        return this.assetsImgName;
    }

    public final Integer getImageResourceId() {
        return this.imageResourceId;
    }

    public final Integer getMachineTypeId() {
        return this.machineTypeId;
    }

    public final int getPathID() {
        return this.pathID;
    }

    public final void setPathID(int i) {
        this.pathID = i;
    }

    static {
        VirtualRaceCodeType[] virtualRaceCodeTypeArr$values = $values();
        $VALUES = virtualRaceCodeTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(virtualRaceCodeTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: VirtualRaceCode.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/VirtualRaceCodeType$Companion;", "", "()V", "findByMachineTypeId", "", "Lcom/soletreadmills/sole_v2/_data/club/VirtualRaceCodeType;", "machineTypeId", "", "fromCode", "code", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VirtualRaceCodeType fromCode(String code) {
            Intrinsics.checkNotNullParameter(code, "code");
            for (VirtualRaceCodeType virtualRaceCodeType : VirtualRaceCodeType.values()) {
                if (Intrinsics.areEqual(virtualRaceCodeType.getCode(), code)) {
                    return virtualRaceCodeType;
                }
            }
            return null;
        }

        public final List<VirtualRaceCodeType> findByMachineTypeId(int machineTypeId) {
            VirtualRaceCodeType[] virtualRaceCodeTypeArrValues = VirtualRaceCodeType.values();
            ArrayList arrayList = new ArrayList();
            for (VirtualRaceCodeType virtualRaceCodeType : virtualRaceCodeTypeArrValues) {
                Integer machineTypeId2 = virtualRaceCodeType.getMachineTypeId();
                if (machineTypeId2 != null && machineTypeId2.intValue() == machineTypeId) {
                    arrayList.add(virtualRaceCodeType);
                }
            }
            return arrayList;
        }
    }
}
