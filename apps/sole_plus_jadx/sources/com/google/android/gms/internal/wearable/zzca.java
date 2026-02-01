package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public enum zzca {
    DOUBLE(0, 1, zzcr.DOUBLE),
    FLOAT(1, 1, zzcr.FLOAT),
    INT64(2, 1, zzcr.LONG),
    UINT64(3, 1, zzcr.LONG),
    INT32(4, 1, zzcr.INT),
    FIXED64(5, 1, zzcr.LONG),
    FIXED32(6, 1, zzcr.INT),
    BOOL(7, 1, zzcr.BOOLEAN),
    STRING(8, 1, zzcr.STRING),
    MESSAGE(9, 1, zzcr.MESSAGE),
    BYTES(10, 1, zzcr.BYTE_STRING),
    UINT32(11, 1, zzcr.INT),
    ENUM(12, 1, zzcr.ENUM),
    SFIXED32(13, 1, zzcr.INT),
    SFIXED64(14, 1, zzcr.LONG),
    SINT32(15, 1, zzcr.INT),
    SINT64(16, 1, zzcr.LONG),
    GROUP(17, 1, zzcr.MESSAGE),
    DOUBLE_LIST(18, 2, zzcr.DOUBLE),
    FLOAT_LIST(19, 2, zzcr.FLOAT),
    INT64_LIST(20, 2, zzcr.LONG),
    UINT64_LIST(21, 2, zzcr.LONG),
    INT32_LIST(22, 2, zzcr.INT),
    FIXED64_LIST(23, 2, zzcr.LONG),
    FIXED32_LIST(24, 2, zzcr.INT),
    BOOL_LIST(25, 2, zzcr.BOOLEAN),
    STRING_LIST(26, 2, zzcr.STRING),
    MESSAGE_LIST(27, 2, zzcr.MESSAGE),
    BYTES_LIST(28, 2, zzcr.BYTE_STRING),
    UINT32_LIST(29, 2, zzcr.INT),
    ENUM_LIST(30, 2, zzcr.ENUM),
    SFIXED32_LIST(31, 2, zzcr.INT),
    SFIXED64_LIST(32, 2, zzcr.LONG),
    SINT32_LIST(33, 2, zzcr.INT),
    SINT64_LIST(34, 2, zzcr.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzcr.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzcr.FLOAT),
    INT64_LIST_PACKED(37, 3, zzcr.LONG),
    UINT64_LIST_PACKED(38, 3, zzcr.LONG),
    INT32_LIST_PACKED(39, 3, zzcr.INT),
    FIXED64_LIST_PACKED(40, 3, zzcr.LONG),
    FIXED32_LIST_PACKED(41, 3, zzcr.INT),
    BOOL_LIST_PACKED(42, 3, zzcr.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzcr.INT),
    ENUM_LIST_PACKED(44, 3, zzcr.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzcr.INT),
    SFIXED64_LIST_PACKED(46, 3, zzcr.LONG),
    SINT32_LIST_PACKED(47, 3, zzcr.INT),
    SINT64_LIST_PACKED(48, 3, zzcr.LONG),
    GROUP_LIST(49, 2, zzcr.MESSAGE),
    MAP(50, 4, zzcr.VOID);

    private static final zzca[] zzZ;
    private final zzcr zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzca[] zzcaVarArrValues = values();
        zzZ = new zzca[zzcaVarArrValues.length];
        for (zzca zzcaVar : zzcaVarArrValues) {
            zzZ[zzcaVar.zzac] = zzcaVar;
        }
    }

    zzca(int i, int i2, zzcr zzcrVar) {
        this.zzac = i;
        this.zzab = zzcrVar;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            this.zzad = zzcrVar.zza();
        } else {
            this.zzad = null;
        }
        if (i2 == 1) {
            zzcr zzcrVar2 = zzcr.VOID;
            zzcrVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
