package com.soletreadmills.sole_v2._type;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WearMsgDataType.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/MsgData;", "", "type", "Lcom/soletreadmills/sole_v2/_type/WearMsgDataType;", "value", "", "(Lcom/soletreadmills/sole_v2/_type/WearMsgDataType;Ljava/lang/String;)V", "getType", "()Lcom/soletreadmills/sole_v2/_type/WearMsgDataType;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MsgData {
    public static final int $stable = 0;
    private final WearMsgDataType type;
    private final String value;

    public static /* synthetic */ MsgData copy$default(MsgData msgData, WearMsgDataType wearMsgDataType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            wearMsgDataType = msgData.type;
        }
        if ((i & 2) != 0) {
            str = msgData.value;
        }
        return msgData.copy(wearMsgDataType, str);
    }

    /* renamed from: component1, reason: from getter */
    public final WearMsgDataType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final MsgData copy(WearMsgDataType type, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        return new MsgData(type, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgData)) {
            return false;
        }
        MsgData msgData = (MsgData) other;
        return this.type == msgData.type && Intrinsics.areEqual(this.value, msgData.value);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "MsgData(type=" + this.type + ", value=" + this.value + ')';
    }

    public MsgData(WearMsgDataType type, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        this.type = type;
        this.value = value;
    }

    public final WearMsgDataType getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }
}
