package com.soletreadmills.sole_v2._data.ble;

import kotlin.Metadata;

/* compiled from: SelectProgramSeekbarData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/ble/SelectProgramSeekbarData;", "", "value", "", "seekbarType", "(II)V", "getSeekbarType", "()I", "setSeekbarType", "(I)V", "getValue", "setValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SelectProgramSeekbarData {
    public static final int $stable = 8;
    private int seekbarType;
    private int value;

    public static /* synthetic */ SelectProgramSeekbarData copy$default(SelectProgramSeekbarData selectProgramSeekbarData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = selectProgramSeekbarData.value;
        }
        if ((i3 & 2) != 0) {
            i2 = selectProgramSeekbarData.seekbarType;
        }
        return selectProgramSeekbarData.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSeekbarType() {
        return this.seekbarType;
    }

    public final SelectProgramSeekbarData copy(int value, int seekbarType) {
        return new SelectProgramSeekbarData(value, seekbarType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectProgramSeekbarData)) {
            return false;
        }
        SelectProgramSeekbarData selectProgramSeekbarData = (SelectProgramSeekbarData) other;
        return this.value == selectProgramSeekbarData.value && this.seekbarType == selectProgramSeekbarData.seekbarType;
    }

    public int hashCode() {
        return (Integer.hashCode(this.value) * 31) + Integer.hashCode(this.seekbarType);
    }

    public String toString() {
        return "SelectProgramSeekbarData(value=" + this.value + ", seekbarType=" + this.seekbarType + ')';
    }

    public SelectProgramSeekbarData(int i, int i2) {
        this.value = i;
        this.seekbarType = i2;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int i) {
        this.value = i;
    }

    public final int getSeekbarType() {
        return this.seekbarType;
    }

    public final void setSeekbarType(int i) {
        this.seekbarType = i;
    }
}
