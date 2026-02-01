package com.soletreadmills.sole_v2._data.classes;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetFavoritesApiData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010'\u001a\u00020\u000eHÆ\u0003J~\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\fHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/FavoritesData;", "", "favoriteId", "", "objectBackgroundUrl", "objectClassTypeName", "", "objectId", "objectMachineTypeName", "objectName", "objectType", "objectWorkoutAmount", "", "isEdit", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V", "getFavoriteId", "()Ljava/lang/String;", "()Z", "setEdit", "(Z)V", "getObjectBackgroundUrl", "getObjectClassTypeName", "()Ljava/util/List;", "getObjectId", "getObjectMachineTypeName", "getObjectName", "getObjectType", "getObjectWorkoutAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)Lcom/soletreadmills/sole_v2/_data/classes/FavoritesData;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FavoritesData {
    public static final int $stable = 8;

    @SerializedName("favorite_id")
    private final String favoriteId;
    private boolean isEdit;

    @SerializedName("object_background_url")
    private final String objectBackgroundUrl;

    @SerializedName("object_class_type_name")
    private final List<String> objectClassTypeName;

    @SerializedName("object_id")
    private final String objectId;

    @SerializedName("object_machine_type_name")
    private final String objectMachineTypeName;

    @SerializedName("object_name")
    private final String objectName;

    @SerializedName("object_type")
    private final String objectType;

    @SerializedName("object_workout_amount")
    private final Integer objectWorkoutAmount;

    public FavoritesData() {
        this(null, null, null, null, null, null, null, null, false, 511, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFavoriteId() {
        return this.favoriteId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getObjectBackgroundUrl() {
        return this.objectBackgroundUrl;
    }

    public final List<String> component3() {
        return this.objectClassTypeName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getObjectId() {
        return this.objectId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getObjectMachineTypeName() {
        return this.objectMachineTypeName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getObjectName() {
        return this.objectName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getObjectType() {
        return this.objectType;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getObjectWorkoutAmount() {
        return this.objectWorkoutAmount;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsEdit() {
        return this.isEdit;
    }

    public final FavoritesData copy(String favoriteId, String objectBackgroundUrl, List<String> objectClassTypeName, String objectId, String objectMachineTypeName, String objectName, String objectType, Integer objectWorkoutAmount, boolean isEdit) {
        return new FavoritesData(favoriteId, objectBackgroundUrl, objectClassTypeName, objectId, objectMachineTypeName, objectName, objectType, objectWorkoutAmount, isEdit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FavoritesData)) {
            return false;
        }
        FavoritesData favoritesData = (FavoritesData) other;
        return Intrinsics.areEqual(this.favoriteId, favoritesData.favoriteId) && Intrinsics.areEqual(this.objectBackgroundUrl, favoritesData.objectBackgroundUrl) && Intrinsics.areEqual(this.objectClassTypeName, favoritesData.objectClassTypeName) && Intrinsics.areEqual(this.objectId, favoritesData.objectId) && Intrinsics.areEqual(this.objectMachineTypeName, favoritesData.objectMachineTypeName) && Intrinsics.areEqual(this.objectName, favoritesData.objectName) && Intrinsics.areEqual(this.objectType, favoritesData.objectType) && Intrinsics.areEqual(this.objectWorkoutAmount, favoritesData.objectWorkoutAmount) && this.isEdit == favoritesData.isEdit;
    }

    public int hashCode() {
        String str = this.favoriteId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.objectBackgroundUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.objectClassTypeName;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.objectId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.objectMachineTypeName;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.objectName;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.objectType;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.objectWorkoutAmount;
        return ((iHashCode7 + (num != null ? num.hashCode() : 0)) * 31) + Boolean.hashCode(this.isEdit);
    }

    public String toString() {
        return "FavoritesData(favoriteId=" + this.favoriteId + ", objectBackgroundUrl=" + this.objectBackgroundUrl + ", objectClassTypeName=" + this.objectClassTypeName + ", objectId=" + this.objectId + ", objectMachineTypeName=" + this.objectMachineTypeName + ", objectName=" + this.objectName + ", objectType=" + this.objectType + ", objectWorkoutAmount=" + this.objectWorkoutAmount + ", isEdit=" + this.isEdit + ')';
    }

    public FavoritesData(String str, String str2, List<String> list, String str3, String str4, String str5, String str6, Integer num, boolean z) {
        this.favoriteId = str;
        this.objectBackgroundUrl = str2;
        this.objectClassTypeName = list;
        this.objectId = str3;
        this.objectMachineTypeName = str4;
        this.objectName = str5;
        this.objectType = str6;
        this.objectWorkoutAmount = num;
        this.isEdit = z;
    }

    public /* synthetic */ FavoritesData(String str, String str2, List list, String str3, String str4, String str5, String str6, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) == 0 ? num : null, (i & 256) != 0 ? false : z);
    }

    public final String getFavoriteId() {
        return this.favoriteId;
    }

    public final String getObjectBackgroundUrl() {
        return this.objectBackgroundUrl;
    }

    public final List<String> getObjectClassTypeName() {
        return this.objectClassTypeName;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final String getObjectMachineTypeName() {
        return this.objectMachineTypeName;
    }

    public final String getObjectName() {
        return this.objectName;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final Integer getObjectWorkoutAmount() {
        return this.objectWorkoutAmount;
    }

    public final boolean isEdit() {
        return this.isEdit;
    }

    public final void setEdit(boolean z) {
        this.isEdit = z;
    }
}
