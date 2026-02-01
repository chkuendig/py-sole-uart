package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public enum zzff {
    DOUBLE(zzfg.DOUBLE, 1),
    FLOAT(zzfg.FLOAT, 5),
    INT64(zzfg.LONG, 0),
    UINT64(zzfg.LONG, 0),
    INT32(zzfg.INT, 0),
    FIXED64(zzfg.LONG, 1),
    FIXED32(zzfg.INT, 5),
    BOOL(zzfg.BOOLEAN, 0),
    STRING(zzfg.STRING, 2),
    GROUP(zzfg.MESSAGE, 3),
    MESSAGE(zzfg.MESSAGE, 2),
    BYTES(zzfg.BYTE_STRING, 2),
    UINT32(zzfg.INT, 0),
    ENUM(zzfg.ENUM, 0),
    SFIXED32(zzfg.INT, 5),
    SFIXED64(zzfg.LONG, 1),
    SINT32(zzfg.INT, 0),
    SINT64(zzfg.LONG, 0);

    private final zzfg zzt;

    zzff(zzfg zzfgVar, int i) {
        this.zzt = zzfgVar;
    }

    public final zzfg zza() {
        return this.zzt;
    }
}
