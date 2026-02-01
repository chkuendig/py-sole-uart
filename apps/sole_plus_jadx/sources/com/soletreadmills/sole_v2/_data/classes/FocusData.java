package com.soletreadmills.sole_v2._data.classes;

import com.soletreadmills.sole_v2._type.FocusType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/FocusData;", "", "type", "Lcom/soletreadmills/sole_v2/_type/FocusType;", "isSelect", "", "(Lcom/soletreadmills/sole_v2/_type/FocusType;Z)V", "()Z", "setSelect", "(Z)V", "getType", "()Lcom/soletreadmills/sole_v2/_type/FocusType;", "setType", "(Lcom/soletreadmills/sole_v2/_type/FocusType;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FocusData {
    public static final int $stable = 8;
    private boolean isSelect;
    private FocusType type;

    public static /* synthetic */ FocusData copy$default(FocusData focusData, FocusType focusType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            focusType = focusData.type;
        }
        if ((i & 2) != 0) {
            z = focusData.isSelect;
        }
        return focusData.copy(focusType, z);
    }

    /* renamed from: component1, reason: from getter */
    public final FocusType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final FocusData copy(FocusType type, boolean isSelect) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new FocusData(type, isSelect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FocusData)) {
            return false;
        }
        FocusData focusData = (FocusData) other;
        return this.type == focusData.type && this.isSelect == focusData.isSelect;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + Boolean.hashCode(this.isSelect);
    }

    public String toString() {
        return "FocusData(type=" + this.type + ", isSelect=" + this.isSelect + ')';
    }

    public FocusData(FocusType type, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.isSelect = z;
    }

    public /* synthetic */ FocusData(FocusType focusType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(focusType, (i & 2) != 0 ? false : z);
    }

    public final FocusType getType() {
        return this.type;
    }

    public final void setType(FocusType focusType) {
        Intrinsics.checkNotNullParameter(focusType, "<set-?>");
        this.type = focusType;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
