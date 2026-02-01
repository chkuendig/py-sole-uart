package com.soletreadmills.sole_v2._data.api.history;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data.WorkoutViewVo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HistoryListData.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f¢\u0006\u0002\u0010\u0011J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u00101\u001a\u00020\fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J~\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0005HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0019\"\u0004\b\u001c\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010$R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b)\u0010\u001f¨\u0006:"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;", "", "id", "", "year", "", "month", "activeHours", "", "totalCalories", "totalSize", "isHeader", "", "workoutData", "Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "isEdit", "isBest", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/soletreadmills/sole_v2/_data/WorkoutViewVo;ZZ)V", "getActiveHours", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "()Z", "setBest", "(Z)V", "setEdit", "setHeader", "getMonth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalCalories", "getTotalSize", "setTotalSize", "(Ljava/lang/Integer;)V", "getWorkoutData", "()Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "setWorkoutData", "(Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;)V", "getYear", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/soletreadmills/sole_v2/_data/WorkoutViewVo;ZZ)Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HistoryListData {
    public static final int $stable = 8;

    @SerializedName("activeHours")
    private final Double activeHours;
    private String id;
    private boolean isBest;
    private boolean isEdit;
    private boolean isHeader;

    @SerializedName("month")
    private final Integer month;

    @SerializedName("totalCalories")
    private final Integer totalCalories;
    private Integer totalSize;
    private WorkoutViewVo workoutData;

    @SerializedName("year")
    private final Integer year;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsBest() {
        return this.isBest;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getYear() {
        return this.year;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getMonth() {
        return this.month;
    }

    /* renamed from: component4, reason: from getter */
    public final Double getActiveHours() {
        return this.activeHours;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getTotalCalories() {
        return this.totalCalories;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getTotalSize() {
        return this.totalSize;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsHeader() {
        return this.isHeader;
    }

    /* renamed from: component8, reason: from getter */
    public final WorkoutViewVo getWorkoutData() {
        return this.workoutData;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsEdit() {
        return this.isEdit;
    }

    public final HistoryListData copy(String id2, Integer year, Integer month, Double activeHours, Integer totalCalories, Integer totalSize, boolean isHeader, WorkoutViewVo workoutData, boolean isEdit, boolean isBest) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return new HistoryListData(id2, year, month, activeHours, totalCalories, totalSize, isHeader, workoutData, isEdit, isBest);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HistoryListData)) {
            return false;
        }
        HistoryListData historyListData = (HistoryListData) other;
        return Intrinsics.areEqual(this.id, historyListData.id) && Intrinsics.areEqual(this.year, historyListData.year) && Intrinsics.areEqual(this.month, historyListData.month) && Intrinsics.areEqual((Object) this.activeHours, (Object) historyListData.activeHours) && Intrinsics.areEqual(this.totalCalories, historyListData.totalCalories) && Intrinsics.areEqual(this.totalSize, historyListData.totalSize) && this.isHeader == historyListData.isHeader && Intrinsics.areEqual(this.workoutData, historyListData.workoutData) && this.isEdit == historyListData.isEdit && this.isBest == historyListData.isBest;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        Integer num = this.year;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.month;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d = this.activeHours;
        int iHashCode4 = (iHashCode3 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num3 = this.totalCalories;
        int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.totalSize;
        int iHashCode6 = (((iHashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31) + Boolean.hashCode(this.isHeader)) * 31;
        WorkoutViewVo workoutViewVo = this.workoutData;
        return ((((iHashCode6 + (workoutViewVo != null ? workoutViewVo.hashCode() : 0)) * 31) + Boolean.hashCode(this.isEdit)) * 31) + Boolean.hashCode(this.isBest);
    }

    public String toString() {
        return "HistoryListData(id=" + this.id + ", year=" + this.year + ", month=" + this.month + ", activeHours=" + this.activeHours + ", totalCalories=" + this.totalCalories + ", totalSize=" + this.totalSize + ", isHeader=" + this.isHeader + ", workoutData=" + this.workoutData + ", isEdit=" + this.isEdit + ", isBest=" + this.isBest + ')';
    }

    public HistoryListData(String id2, Integer num, Integer num2, Double d, Integer num3, Integer num4, boolean z, WorkoutViewVo workoutViewVo, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id2, "id");
        this.id = id2;
        this.year = num;
        this.month = num2;
        this.activeHours = d;
        this.totalCalories = num3;
        this.totalSize = num4;
        this.isHeader = z;
        this.workoutData = workoutViewVo;
        this.isEdit = z2;
        this.isBest = z3;
    }

    public /* synthetic */ HistoryListData(String str, Integer num, Integer num2, Double d, Integer num3, Integer num4, boolean z, WorkoutViewVo workoutViewVo, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : num4, z, (i & 128) != 0 ? null : workoutViewVo, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? false : z3);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final Integer getYear() {
        return this.year;
    }

    public final Integer getMonth() {
        return this.month;
    }

    public final Double getActiveHours() {
        return this.activeHours;
    }

    public final Integer getTotalCalories() {
        return this.totalCalories;
    }

    public final Integer getTotalSize() {
        return this.totalSize;
    }

    public final void setTotalSize(Integer num) {
        this.totalSize = num;
    }

    public final boolean isHeader() {
        return this.isHeader;
    }

    public final void setHeader(boolean z) {
        this.isHeader = z;
    }

    public final WorkoutViewVo getWorkoutData() {
        return this.workoutData;
    }

    public final void setWorkoutData(WorkoutViewVo workoutViewVo) {
        this.workoutData = workoutViewVo;
    }

    public final boolean isEdit() {
        return this.isEdit;
    }

    public final void setEdit(boolean z) {
        this.isEdit = z;
    }

    public final boolean isBest() {
        return this.isBest;
    }

    public final void setBest(boolean z) {
        this.isBest = z;
    }
}
