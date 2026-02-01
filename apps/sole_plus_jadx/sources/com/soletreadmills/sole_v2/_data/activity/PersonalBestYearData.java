package com.soletreadmills.sole_v2._data.activity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersonalBestYearData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/activity/PersonalBestYearData;", "", "yearOrAll", "", "isSelect", "", "(Ljava/lang/String;Z)V", "()Z", "setSelect", "(Z)V", "getYearOrAll", "()Ljava/lang/String;", "setYearOrAll", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PersonalBestYearData {
    public static final int $stable = 8;
    private boolean isSelect;
    private String yearOrAll;

    public static /* synthetic */ PersonalBestYearData copy$default(PersonalBestYearData personalBestYearData, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = personalBestYearData.yearOrAll;
        }
        if ((i & 2) != 0) {
            z = personalBestYearData.isSelect;
        }
        return personalBestYearData.copy(str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getYearOrAll() {
        return this.yearOrAll;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final PersonalBestYearData copy(String yearOrAll, boolean isSelect) {
        Intrinsics.checkNotNullParameter(yearOrAll, "yearOrAll");
        return new PersonalBestYearData(yearOrAll, isSelect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersonalBestYearData)) {
            return false;
        }
        PersonalBestYearData personalBestYearData = (PersonalBestYearData) other;
        return Intrinsics.areEqual(this.yearOrAll, personalBestYearData.yearOrAll) && this.isSelect == personalBestYearData.isSelect;
    }

    public int hashCode() {
        return (this.yearOrAll.hashCode() * 31) + Boolean.hashCode(this.isSelect);
    }

    public String toString() {
        return "PersonalBestYearData(yearOrAll=" + this.yearOrAll + ", isSelect=" + this.isSelect + ')';
    }

    public PersonalBestYearData(String yearOrAll, boolean z) {
        Intrinsics.checkNotNullParameter(yearOrAll, "yearOrAll");
        this.yearOrAll = yearOrAll;
        this.isSelect = z;
    }

    public /* synthetic */ PersonalBestYearData(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    public final String getYearOrAll() {
        return this.yearOrAll;
    }

    public final void setYearOrAll(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.yearOrAll = str;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
