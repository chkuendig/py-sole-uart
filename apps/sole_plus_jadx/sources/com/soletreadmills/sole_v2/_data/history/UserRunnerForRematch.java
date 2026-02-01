package com.soletreadmills.sole_v2._data.history;

import android.graphics.Bitmap;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2._data.WorkoutRawData4WorkoutDetailDisplay;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserRunnerForRematch.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003JW\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017¨\u0006."}, d2 = {"Lcom/soletreadmills/sole_v2/_data/history/UserRunnerForRematch;", "", "id", "", "color", "", "currentDistance", "", "speedKmh", "rawDataList", "", "Lcom/soletreadmills/sole_v2/_data/WorkoutRawData4WorkoutDetailDisplay;", "currentIndex", SdkConstants.TAG_BITMAP, "Landroid/graphics/Bitmap;", "(Ljava/lang/String;IFFLjava/util/List;ILandroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getColor", "()I", "getCurrentDistance", "()F", "setCurrentDistance", "(F)V", "getCurrentIndex", "setCurrentIndex", "(I)V", "getId", "()Ljava/lang/String;", "getRawDataList", "()Ljava/util/List;", "getSpeedKmh", "setSpeedKmh", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserRunnerForRematch {
    public static final int $stable = 8;
    private final Bitmap bitmap;
    private final int color;
    private float currentDistance;
    private int currentIndex;
    private final String id;
    private final List<WorkoutRawData4WorkoutDetailDisplay> rawDataList;
    private float speedKmh;

    public static /* synthetic */ UserRunnerForRematch copy$default(UserRunnerForRematch userRunnerForRematch, String str, int i, float f, float f2, List list, int i2, Bitmap bitmap, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = userRunnerForRematch.id;
        }
        if ((i3 & 2) != 0) {
            i = userRunnerForRematch.color;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            f = userRunnerForRematch.currentDistance;
        }
        float f3 = f;
        if ((i3 & 8) != 0) {
            f2 = userRunnerForRematch.speedKmh;
        }
        float f4 = f2;
        if ((i3 & 16) != 0) {
            list = userRunnerForRematch.rawDataList;
        }
        List list2 = list;
        if ((i3 & 32) != 0) {
            i2 = userRunnerForRematch.currentIndex;
        }
        int i5 = i2;
        if ((i3 & 64) != 0) {
            bitmap = userRunnerForRematch.bitmap;
        }
        return userRunnerForRematch.copy(str, i4, f3, f4, list2, i5, bitmap);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: component3, reason: from getter */
    public final float getCurrentDistance() {
        return this.currentDistance;
    }

    /* renamed from: component4, reason: from getter */
    public final float getSpeedKmh() {
        return this.speedKmh;
    }

    public final List<WorkoutRawData4WorkoutDetailDisplay> component5() {
        return this.rawDataList;
    }

    /* renamed from: component6, reason: from getter */
    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    /* renamed from: component7, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final UserRunnerForRematch copy(String id2, int color, float currentDistance, float speedKmh, List<WorkoutRawData4WorkoutDetailDisplay> rawDataList, int currentIndex, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(rawDataList, "rawDataList");
        return new UserRunnerForRematch(id2, color, currentDistance, speedKmh, rawDataList, currentIndex, bitmap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserRunnerForRematch)) {
            return false;
        }
        UserRunnerForRematch userRunnerForRematch = (UserRunnerForRematch) other;
        return Intrinsics.areEqual(this.id, userRunnerForRematch.id) && this.color == userRunnerForRematch.color && Float.compare(this.currentDistance, userRunnerForRematch.currentDistance) == 0 && Float.compare(this.speedKmh, userRunnerForRematch.speedKmh) == 0 && Intrinsics.areEqual(this.rawDataList, userRunnerForRematch.rawDataList) && this.currentIndex == userRunnerForRematch.currentIndex && Intrinsics.areEqual(this.bitmap, userRunnerForRematch.bitmap);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.color)) * 31) + Float.hashCode(this.currentDistance)) * 31) + Float.hashCode(this.speedKmh)) * 31) + this.rawDataList.hashCode()) * 31) + Integer.hashCode(this.currentIndex)) * 31;
        Bitmap bitmap = this.bitmap;
        return iHashCode + (bitmap == null ? 0 : bitmap.hashCode());
    }

    public String toString() {
        return "UserRunnerForRematch(id=" + this.id + ", color=" + this.color + ", currentDistance=" + this.currentDistance + ", speedKmh=" + this.speedKmh + ", rawDataList=" + this.rawDataList + ", currentIndex=" + this.currentIndex + ", bitmap=" + this.bitmap + ')';
    }

    public UserRunnerForRematch(String id2, int i, float f, float f2, List<WorkoutRawData4WorkoutDetailDisplay> rawDataList, int i2, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(rawDataList, "rawDataList");
        this.id = id2;
        this.color = i;
        this.currentDistance = f;
        this.speedKmh = f2;
        this.rawDataList = rawDataList;
        this.currentIndex = i2;
        this.bitmap = bitmap;
    }

    public /* synthetic */ UserRunnerForRematch(String str, int i, float f, float f2, List list, int i2, Bitmap bitmap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, f, f2, list, (i3 & 32) != 0 ? 0 : i2, (i3 & 64) != 0 ? null : bitmap);
    }

    public final String getId() {
        return this.id;
    }

    public final int getColor() {
        return this.color;
    }

    public final float getCurrentDistance() {
        return this.currentDistance;
    }

    public final void setCurrentDistance(float f) {
        this.currentDistance = f;
    }

    public final float getSpeedKmh() {
        return this.speedKmh;
    }

    public final void setSpeedKmh(float f) {
        this.speedKmh = f;
    }

    public final List<WorkoutRawData4WorkoutDetailDisplay> getRawDataList() {
        return this.rawDataList;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final void setCurrentIndex(int i) {
        this.currentIndex = i;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }
}
