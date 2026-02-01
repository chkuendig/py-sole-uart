package com.soletreadmills.sole_v2._data.ble;

import com.soletreadmills.sole_v2._type.ConnectCategoryType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgramCategoryData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/ble/ProgramCategoryData;", "", "type", "Lcom/soletreadmills/sole_v2/_type/ConnectCategoryType;", "select", "", "(Lcom/soletreadmills/sole_v2/_type/ConnectCategoryType;Z)V", "getSelect", "()Z", "setSelect", "(Z)V", "getType", "()Lcom/soletreadmills/sole_v2/_type/ConnectCategoryType;", "setType", "(Lcom/soletreadmills/sole_v2/_type/ConnectCategoryType;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ProgramCategoryData {
    public static final int $stable = 8;
    private boolean select;
    private ConnectCategoryType type;

    public static /* synthetic */ ProgramCategoryData copy$default(ProgramCategoryData programCategoryData, ConnectCategoryType connectCategoryType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            connectCategoryType = programCategoryData.type;
        }
        if ((i & 2) != 0) {
            z = programCategoryData.select;
        }
        return programCategoryData.copy(connectCategoryType, z);
    }

    /* renamed from: component1, reason: from getter */
    public final ConnectCategoryType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSelect() {
        return this.select;
    }

    public final ProgramCategoryData copy(ConnectCategoryType type, boolean select) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ProgramCategoryData(type, select);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProgramCategoryData)) {
            return false;
        }
        ProgramCategoryData programCategoryData = (ProgramCategoryData) other;
        return this.type == programCategoryData.type && this.select == programCategoryData.select;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + Boolean.hashCode(this.select);
    }

    public String toString() {
        return "ProgramCategoryData(type=" + this.type + ", select=" + this.select + ')';
    }

    public ProgramCategoryData(ConnectCategoryType type, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.select = z;
    }

    public final ConnectCategoryType getType() {
        return this.type;
    }

    public final void setType(ConnectCategoryType connectCategoryType) {
        Intrinsics.checkNotNullParameter(connectCategoryType, "<set-?>");
        this.type = connectCategoryType;
    }

    public final boolean getSelect() {
        return this.select;
    }

    public final void setSelect(boolean z) {
        this.select = z;
    }
}
