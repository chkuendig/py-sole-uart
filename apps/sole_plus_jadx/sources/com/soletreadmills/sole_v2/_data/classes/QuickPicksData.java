package com.soletreadmills.sole_v2._data.classes;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._type.ClassType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetClassQuickPicksApiData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/QuickPicksData;", "", "filterItemId", "", "filterItemName", "filterTypeId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFilterItemId", "()Ljava/lang/String;", "getFilterItemName", "getFilterTypeId", "component1", "component2", "component3", "copy", "equals", "", "other", "getClassesFilterTagViewType", "Lcom/soletreadmills/sole_v2/_data/classes/ClassesFilterTagViewType;", "getIconName", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class QuickPicksData {
    public static final int $stable = 0;

    @SerializedName("filter_item_id")
    private final String filterItemId;

    @SerializedName("filter_item_name")
    private final String filterItemName;

    @SerializedName("filter_type_id")
    private final String filterTypeId;

    public QuickPicksData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ QuickPicksData copy$default(QuickPicksData quickPicksData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quickPicksData.filterItemId;
        }
        if ((i & 2) != 0) {
            str2 = quickPicksData.filterItemName;
        }
        if ((i & 4) != 0) {
            str3 = quickPicksData.filterTypeId;
        }
        return quickPicksData.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFilterItemId() {
        return this.filterItemId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFilterItemName() {
        return this.filterItemName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFilterTypeId() {
        return this.filterTypeId;
    }

    public final QuickPicksData copy(String filterItemId, String filterItemName, String filterTypeId) {
        return new QuickPicksData(filterItemId, filterItemName, filterTypeId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuickPicksData)) {
            return false;
        }
        QuickPicksData quickPicksData = (QuickPicksData) other;
        return Intrinsics.areEqual(this.filterItemId, quickPicksData.filterItemId) && Intrinsics.areEqual(this.filterItemName, quickPicksData.filterItemName) && Intrinsics.areEqual(this.filterTypeId, quickPicksData.filterTypeId);
    }

    public int hashCode() {
        String str = this.filterItemId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.filterItemName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.filterTypeId;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "QuickPicksData(filterItemId=" + this.filterItemId + ", filterItemName=" + this.filterItemName + ", filterTypeId=" + this.filterTypeId + ')';
    }

    public QuickPicksData(String str, String str2, String str3) {
        this.filterItemId = str;
        this.filterItemName = str2;
        this.filterTypeId = str3;
    }

    public /* synthetic */ QuickPicksData(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getFilterItemId() {
        return this.filterItemId;
    }

    public final String getFilterItemName() {
        return this.filterItemName;
    }

    public final String getFilterTypeId() {
        return this.filterTypeId;
    }

    public final int getIconName() {
        String str = this.filterItemId;
        String str2 = this.filterTypeId;
        if (str2 == null) {
            return 0;
        }
        int iHashCode = str2.hashCode();
        if (iHashCode == 2161) {
            if (str2.equals("CT")) {
                return ClassType.INSTANCE.fromRaw(str).getIconStr();
            }
            return 0;
        }
        if (iHashCode == 2781) {
            if (str2.equals("WT")) {
                return R.drawable.ic_m__focus;
            }
            return 0;
        }
        if (iHashCode == 68065) {
            if (str2.equals("DUR")) {
                return R.drawable.ic_machine_treadmill;
            }
            return 0;
        }
        if (iHashCode == 2098181) {
            if (str2.equals("DIFF")) {
                return DifficultyType.INSTANCE.fromRaw(str).getIconStr();
            }
            return 0;
        }
        if (iHashCode == 2252358 && str2.equals("INST")) {
            return R.drawable.ic_user;
        }
        return 0;
    }

    public final ClassesFilterTagViewType getClassesFilterTagViewType() {
        String str = this.filterTypeId;
        if (str == null) {
            return null;
        }
        int iHashCode = str.hashCode();
        if (iHashCode == 2161) {
            if (str.equals("CT")) {
                return ClassesFilterTagViewType.Activity;
            }
            return null;
        }
        if (iHashCode == 2781) {
            if (str.equals("WT")) {
                return ClassesFilterTagViewType.Focus;
            }
            return null;
        }
        if (iHashCode == 68065) {
            if (str.equals("DUR")) {
                return ClassesFilterTagViewType.Duration;
            }
            return null;
        }
        if (iHashCode == 2098181) {
            if (str.equals("DIFF")) {
                return ClassesFilterTagViewType.Level;
            }
            return null;
        }
        if (iHashCode == 2252358 && str.equals("INST")) {
            return ClassesFilterTagViewType.Instructors;
        }
        return null;
    }
}
