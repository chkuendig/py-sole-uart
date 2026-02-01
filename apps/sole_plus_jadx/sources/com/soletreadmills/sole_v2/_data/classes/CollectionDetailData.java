package com.soletreadmills.sole_v2._data.classes;

import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._type.ClassType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CollectionDetailData.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&\b\u0087\b\u0018\u00002\u00020\u0001B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010-\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010.\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010(J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¼\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010;\u001a\u00020\u0014J\u0006\u0010<\u001a\u00020\u0003J\t\u0010=\u001a\u00020\u0014HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010&\u001a\u0004\b\u0010\u0010%R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010&\u001a\u0004\b\u0012\u0010%R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(¨\u0006?"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/CollectionDetailData;", "", "background_url", "", "class_types", "", SdkConstants.FD_CLASSES_OUTPUT, "Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "collection_description", "collection_id", "collection_name", "duration_max", "duration_min", "favorite_id", "instructors", "Lcom/soletreadmills/sole_v2/_data/classes/FollowedCollectionInstructorsData;", "is_favorite", "", "is_followed", "workout_amount", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getBackground_url", "()Ljava/lang/String;", "classTypes", "Lcom/soletreadmills/sole_v2/_type/ClassType;", "getClassTypes", "()Ljava/util/List;", "getClass_types", "getClasses", "getCollection_description", "getCollection_id", "getCollection_name", "getDuration_max", "getDuration_min", "getFavorite_id", "getInstructors", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getWorkout_amount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/classes/CollectionDetailData;", "equals", "other", "getClassTypeTitle", "getInstructorsName", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CollectionDetailData {
    public static final int $stable = 8;
    private final String background_url;
    private final List<String> class_types;
    private final List<ClassesData> classes;
    private final String collection_description;
    private final String collection_id;
    private final String collection_name;
    private final String duration_max;
    private final String duration_min;
    private final String favorite_id;
    private final List<FollowedCollectionInstructorsData> instructors;
    private final Boolean is_favorite;
    private final Boolean is_followed;
    private final Integer workout_amount;

    public CollectionDetailData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBackground_url() {
        return this.background_url;
    }

    public final List<FollowedCollectionInstructorsData> component10() {
        return this.instructors;
    }

    /* renamed from: component11, reason: from getter */
    public final Boolean getIs_favorite() {
        return this.is_favorite;
    }

    /* renamed from: component12, reason: from getter */
    public final Boolean getIs_followed() {
        return this.is_followed;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getWorkout_amount() {
        return this.workout_amount;
    }

    public final List<String> component2() {
        return this.class_types;
    }

    public final List<ClassesData> component3() {
        return this.classes;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCollection_description() {
        return this.collection_description;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCollection_id() {
        return this.collection_id;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCollection_name() {
        return this.collection_name;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDuration_max() {
        return this.duration_max;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDuration_min() {
        return this.duration_min;
    }

    /* renamed from: component9, reason: from getter */
    public final String getFavorite_id() {
        return this.favorite_id;
    }

    public final CollectionDetailData copy(String background_url, List<String> class_types, List<ClassesData> classes, String collection_description, String collection_id, String collection_name, String duration_max, String duration_min, String favorite_id, List<FollowedCollectionInstructorsData> instructors, Boolean is_favorite, Boolean is_followed, Integer workout_amount) {
        return new CollectionDetailData(background_url, class_types, classes, collection_description, collection_id, collection_name, duration_max, duration_min, favorite_id, instructors, is_favorite, is_followed, workout_amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionDetailData)) {
            return false;
        }
        CollectionDetailData collectionDetailData = (CollectionDetailData) other;
        return Intrinsics.areEqual(this.background_url, collectionDetailData.background_url) && Intrinsics.areEqual(this.class_types, collectionDetailData.class_types) && Intrinsics.areEqual(this.classes, collectionDetailData.classes) && Intrinsics.areEqual(this.collection_description, collectionDetailData.collection_description) && Intrinsics.areEqual(this.collection_id, collectionDetailData.collection_id) && Intrinsics.areEqual(this.collection_name, collectionDetailData.collection_name) && Intrinsics.areEqual(this.duration_max, collectionDetailData.duration_max) && Intrinsics.areEqual(this.duration_min, collectionDetailData.duration_min) && Intrinsics.areEqual(this.favorite_id, collectionDetailData.favorite_id) && Intrinsics.areEqual(this.instructors, collectionDetailData.instructors) && Intrinsics.areEqual(this.is_favorite, collectionDetailData.is_favorite) && Intrinsics.areEqual(this.is_followed, collectionDetailData.is_followed) && Intrinsics.areEqual(this.workout_amount, collectionDetailData.workout_amount);
    }

    public int hashCode() {
        String str = this.background_url;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.class_types;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<ClassesData> list2 = this.classes;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.collection_description;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.collection_id;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.collection_name;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.duration_max;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.duration_min;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.favorite_id;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<FollowedCollectionInstructorsData> list3 = this.instructors;
        int iHashCode10 = (iHashCode9 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Boolean bool = this.is_favorite;
        int iHashCode11 = (iHashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.is_followed;
        int iHashCode12 = (iHashCode11 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.workout_amount;
        return iHashCode12 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CollectionDetailData(background_url=");
        sb.append(this.background_url).append(", class_types=").append(this.class_types).append(", classes=").append(this.classes).append(", collection_description=").append(this.collection_description).append(", collection_id=").append(this.collection_id).append(", collection_name=").append(this.collection_name).append(", duration_max=").append(this.duration_max).append(", duration_min=").append(this.duration_min).append(", favorite_id=").append(this.favorite_id).append(", instructors=").append(this.instructors).append(", is_favorite=").append(this.is_favorite).append(", is_followed=");
        sb.append(this.is_followed).append(", workout_amount=").append(this.workout_amount).append(')');
        return sb.toString();
    }

    public CollectionDetailData(String str, List<String> list, List<ClassesData> list2, String str2, String str3, String str4, String str5, String str6, String str7, List<FollowedCollectionInstructorsData> list3, Boolean bool, Boolean bool2, Integer num) {
        this.background_url = str;
        this.class_types = list;
        this.classes = list2;
        this.collection_description = str2;
        this.collection_id = str3;
        this.collection_name = str4;
        this.duration_max = str5;
        this.duration_min = str6;
        this.favorite_id = str7;
        this.instructors = list3;
        this.is_favorite = bool;
        this.is_followed = bool2;
        this.workout_amount = num;
    }

    public /* synthetic */ CollectionDetailData(String str, List list, List list2, String str2, String str3, String str4, String str5, String str6, String str7, List list3, Boolean bool, Boolean bool2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : list3, (i & 1024) != 0 ? null : bool, (i & 2048) != 0 ? null : bool2, (i & 4096) == 0 ? num : null);
    }

    public final String getBackground_url() {
        return this.background_url;
    }

    public final List<String> getClass_types() {
        return this.class_types;
    }

    public final List<ClassesData> getClasses() {
        return this.classes;
    }

    public final String getCollection_description() {
        return this.collection_description;
    }

    public final String getCollection_id() {
        return this.collection_id;
    }

    public final String getCollection_name() {
        return this.collection_name;
    }

    public final String getDuration_max() {
        return this.duration_max;
    }

    public final String getDuration_min() {
        return this.duration_min;
    }

    public final String getFavorite_id() {
        return this.favorite_id;
    }

    public final List<FollowedCollectionInstructorsData> getInstructors() {
        return this.instructors;
    }

    public final Boolean is_favorite() {
        return this.is_favorite;
    }

    public final Boolean is_followed() {
        return this.is_followed;
    }

    public final Integer getWorkout_amount() {
        return this.workout_amount;
    }

    public final List<ClassType> getClassTypes() {
        List<String> list = this.class_types;
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(ClassType.INSTANCE.fromRaw((String) it.next()));
        }
        return arrayList;
    }

    public final int getClassTypeTitle() {
        ClassType classType = (ClassType) CollectionsKt.firstOrNull((List) getClassTypes());
        return classType != null ? classType.getClassCategory() : R.string.other;
    }

    public final String getInstructorsName() {
        FollowedCollectionInstructorsData followedCollectionInstructorsData;
        String name;
        List<FollowedCollectionInstructorsData> list = this.instructors;
        return (list == null || (followedCollectionInstructorsData = (FollowedCollectionInstructorsData) CollectionsKt.first((List) list)) == null || (name = followedCollectionInstructorsData.getName()) == null) ? "" : name;
    }
}
