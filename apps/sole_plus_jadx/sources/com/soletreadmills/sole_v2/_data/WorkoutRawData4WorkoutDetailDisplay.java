package com.soletreadmills.sole_v2._data;

import com.sun.jna.platform.win32.Advapi32;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutRawData4WorkoutDetailDisplay.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ¶\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020:HÖ\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001e\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001f\u0010\u0014R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b \u0010\u0014R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b!\u0010\u001bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\"\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b$\u0010\u001b¨\u0006;"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/WorkoutRawData4WorkoutDetailDisplay;", "", "totalWorkoutTime", "", "nowHr", "", "totalDistance", "nowSpeed", "nowIncline", "nowLevel", "nowWatt", "avgSpmRower", "totalStrokes", "avgRpm", "totalFloor", "totalElevation", "totalSteps", "curSpmStepper", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;)V", "getAvgRpm", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAvgSpmRower", "getCurSpmStepper", "getNowHr", "getNowIncline", "getNowLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNowSpeed", "getNowWatt", "getTotalDistance", "getTotalElevation", "getTotalFloor", "getTotalSteps", "getTotalStrokes", "getTotalWorkoutTime", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/soletreadmills/sole_v2/_data/WorkoutRawData4WorkoutDetailDisplay;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class WorkoutRawData4WorkoutDetailDisplay {
    public static final int $stable = 0;
    private final Double avgRpm;
    private final Double avgSpmRower;
    private final Double curSpmStepper;
    private final Double nowHr;
    private final Double nowIncline;
    private final Integer nowLevel;
    private final Double nowSpeed;
    private final Double nowWatt;
    private final Double totalDistance;
    private final Double totalElevation;
    private final Integer totalFloor;
    private final Integer totalSteps;
    private final Integer totalStrokes;
    private final Integer totalWorkoutTime;

    public WorkoutRawData4WorkoutDetailDisplay() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, Advapi32.MAX_VALUE_NAME, null);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getTotalWorkoutTime() {
        return this.totalWorkoutTime;
    }

    /* renamed from: component10, reason: from getter */
    public final Double getAvgRpm() {
        return this.avgRpm;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getTotalFloor() {
        return this.totalFloor;
    }

    /* renamed from: component12, reason: from getter */
    public final Double getTotalElevation() {
        return this.totalElevation;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getTotalSteps() {
        return this.totalSteps;
    }

    /* renamed from: component14, reason: from getter */
    public final Double getCurSpmStepper() {
        return this.curSpmStepper;
    }

    /* renamed from: component2, reason: from getter */
    public final Double getNowHr() {
        return this.nowHr;
    }

    /* renamed from: component3, reason: from getter */
    public final Double getTotalDistance() {
        return this.totalDistance;
    }

    /* renamed from: component4, reason: from getter */
    public final Double getNowSpeed() {
        return this.nowSpeed;
    }

    /* renamed from: component5, reason: from getter */
    public final Double getNowIncline() {
        return this.nowIncline;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getNowLevel() {
        return this.nowLevel;
    }

    /* renamed from: component7, reason: from getter */
    public final Double getNowWatt() {
        return this.nowWatt;
    }

    /* renamed from: component8, reason: from getter */
    public final Double getAvgSpmRower() {
        return this.avgSpmRower;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getTotalStrokes() {
        return this.totalStrokes;
    }

    public final WorkoutRawData4WorkoutDetailDisplay copy(Integer totalWorkoutTime, Double nowHr, Double totalDistance, Double nowSpeed, Double nowIncline, Integer nowLevel, Double nowWatt, Double avgSpmRower, Integer totalStrokes, Double avgRpm, Integer totalFloor, Double totalElevation, Integer totalSteps, Double curSpmStepper) {
        return new WorkoutRawData4WorkoutDetailDisplay(totalWorkoutTime, nowHr, totalDistance, nowSpeed, nowIncline, nowLevel, nowWatt, avgSpmRower, totalStrokes, avgRpm, totalFloor, totalElevation, totalSteps, curSpmStepper);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkoutRawData4WorkoutDetailDisplay)) {
            return false;
        }
        WorkoutRawData4WorkoutDetailDisplay workoutRawData4WorkoutDetailDisplay = (WorkoutRawData4WorkoutDetailDisplay) other;
        return Intrinsics.areEqual(this.totalWorkoutTime, workoutRawData4WorkoutDetailDisplay.totalWorkoutTime) && Intrinsics.areEqual((Object) this.nowHr, (Object) workoutRawData4WorkoutDetailDisplay.nowHr) && Intrinsics.areEqual((Object) this.totalDistance, (Object) workoutRawData4WorkoutDetailDisplay.totalDistance) && Intrinsics.areEqual((Object) this.nowSpeed, (Object) workoutRawData4WorkoutDetailDisplay.nowSpeed) && Intrinsics.areEqual((Object) this.nowIncline, (Object) workoutRawData4WorkoutDetailDisplay.nowIncline) && Intrinsics.areEqual(this.nowLevel, workoutRawData4WorkoutDetailDisplay.nowLevel) && Intrinsics.areEqual((Object) this.nowWatt, (Object) workoutRawData4WorkoutDetailDisplay.nowWatt) && Intrinsics.areEqual((Object) this.avgSpmRower, (Object) workoutRawData4WorkoutDetailDisplay.avgSpmRower) && Intrinsics.areEqual(this.totalStrokes, workoutRawData4WorkoutDetailDisplay.totalStrokes) && Intrinsics.areEqual((Object) this.avgRpm, (Object) workoutRawData4WorkoutDetailDisplay.avgRpm) && Intrinsics.areEqual(this.totalFloor, workoutRawData4WorkoutDetailDisplay.totalFloor) && Intrinsics.areEqual((Object) this.totalElevation, (Object) workoutRawData4WorkoutDetailDisplay.totalElevation) && Intrinsics.areEqual(this.totalSteps, workoutRawData4WorkoutDetailDisplay.totalSteps) && Intrinsics.areEqual((Object) this.curSpmStepper, (Object) workoutRawData4WorkoutDetailDisplay.curSpmStepper);
    }

    public int hashCode() {
        Integer num = this.totalWorkoutTime;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Double d = this.nowHr;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.totalDistance;
        int iHashCode3 = (iHashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.nowSpeed;
        int iHashCode4 = (iHashCode3 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Double d4 = this.nowIncline;
        int iHashCode5 = (iHashCode4 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Integer num2 = this.nowLevel;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d5 = this.nowWatt;
        int iHashCode7 = (iHashCode6 + (d5 == null ? 0 : d5.hashCode())) * 31;
        Double d6 = this.avgSpmRower;
        int iHashCode8 = (iHashCode7 + (d6 == null ? 0 : d6.hashCode())) * 31;
        Integer num3 = this.totalStrokes;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Double d7 = this.avgRpm;
        int iHashCode10 = (iHashCode9 + (d7 == null ? 0 : d7.hashCode())) * 31;
        Integer num4 = this.totalFloor;
        int iHashCode11 = (iHashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Double d8 = this.totalElevation;
        int iHashCode12 = (iHashCode11 + (d8 == null ? 0 : d8.hashCode())) * 31;
        Integer num5 = this.totalSteps;
        int iHashCode13 = (iHashCode12 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Double d9 = this.curSpmStepper;
        return iHashCode13 + (d9 != null ? d9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WorkoutRawData4WorkoutDetailDisplay(totalWorkoutTime=");
        sb.append(this.totalWorkoutTime).append(", nowHr=").append(this.nowHr).append(", totalDistance=").append(this.totalDistance).append(", nowSpeed=").append(this.nowSpeed).append(", nowIncline=").append(this.nowIncline).append(", nowLevel=").append(this.nowLevel).append(", nowWatt=").append(this.nowWatt).append(", avgSpmRower=").append(this.avgSpmRower).append(", totalStrokes=").append(this.totalStrokes).append(", avgRpm=").append(this.avgRpm).append(", totalFloor=").append(this.totalFloor).append(", totalElevation=");
        sb.append(this.totalElevation).append(", totalSteps=").append(this.totalSteps).append(", curSpmStepper=").append(this.curSpmStepper).append(')');
        return sb.toString();
    }

    public WorkoutRawData4WorkoutDetailDisplay(Integer num, Double d, Double d2, Double d3, Double d4, Integer num2, Double d5, Double d6, Integer num3, Double d7, Integer num4, Double d8, Integer num5, Double d9) {
        this.totalWorkoutTime = num;
        this.nowHr = d;
        this.totalDistance = d2;
        this.nowSpeed = d3;
        this.nowIncline = d4;
        this.nowLevel = num2;
        this.nowWatt = d5;
        this.avgSpmRower = d6;
        this.totalStrokes = num3;
        this.avgRpm = d7;
        this.totalFloor = num4;
        this.totalElevation = d8;
        this.totalSteps = num5;
        this.curSpmStepper = d9;
    }

    public /* synthetic */ WorkoutRawData4WorkoutDetailDisplay(Integer num, Double d, Double d2, Double d3, Double d4, Integer num2, Double d5, Double d6, Integer num3, Double d7, Integer num4, Double d8, Integer num5, Double d9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : d2, (i & 8) != 0 ? null : d3, (i & 16) != 0 ? null : d4, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : d5, (i & 128) != 0 ? null : d6, (i & 256) != 0 ? null : num3, (i & 512) != 0 ? null : d7, (i & 1024) != 0 ? null : num4, (i & 2048) != 0 ? null : d8, (i & 4096) != 0 ? null : num5, (i & 8192) == 0 ? d9 : null);
    }

    public final Integer getTotalWorkoutTime() {
        return this.totalWorkoutTime;
    }

    public final Double getNowHr() {
        return this.nowHr;
    }

    public final Double getTotalDistance() {
        return this.totalDistance;
    }

    public final Double getNowSpeed() {
        return this.nowSpeed;
    }

    public final Double getNowIncline() {
        return this.nowIncline;
    }

    public final Integer getNowLevel() {
        return this.nowLevel;
    }

    public final Double getNowWatt() {
        return this.nowWatt;
    }

    public final Double getAvgSpmRower() {
        return this.avgSpmRower;
    }

    public final Integer getTotalStrokes() {
        return this.totalStrokes;
    }

    public final Double getAvgRpm() {
        return this.avgRpm;
    }

    public final Integer getTotalFloor() {
        return this.totalFloor;
    }

    public final Double getTotalElevation() {
        return this.totalElevation;
    }

    public final Integer getTotalSteps() {
        return this.totalSteps;
    }

    public final Double getCurSpmStepper() {
        return this.curSpmStepper;
    }
}
