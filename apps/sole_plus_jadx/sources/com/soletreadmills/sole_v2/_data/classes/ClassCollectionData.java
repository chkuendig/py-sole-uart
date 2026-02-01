package com.soletreadmills.sole_v2._data.classes;

import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._type.ClassType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassCollectionData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0086\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010.\u001a\u00020\nJ\t\u0010/\u001a\u00020\nHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\f\u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001b¨\u00061"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;", "", "background_url", "", "class_types", "", "collection_description", "collection_id", "collection_name", "instructor_amount", "", "instructor_names", "is_favorite", "", "workout_amount", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getBackground_url", "()Ljava/lang/String;", "classTypes", "Lcom/soletreadmills/sole_v2/_type/ClassType;", "getClassTypes", "()Ljava/util/List;", "getClass_types", "getCollection_description", "getCollection_id", "getCollection_name", "getInstructor_amount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInstructor_names", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getWorkout_amount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;", "equals", "other", "getClassTypeTitle", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ClassCollectionData {
    public static final int $stable = 8;
    private final String background_url;
    private final List<String> class_types;
    private final String collection_description;
    private final String collection_id;
    private final String collection_name;
    private final Integer instructor_amount;
    private final List<String> instructor_names;
    private final Boolean is_favorite;
    private final Integer workout_amount;

    public ClassCollectionData() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBackground_url() {
        return this.background_url;
    }

    public final List<String> component2() {
        return this.class_types;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCollection_description() {
        return this.collection_description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCollection_id() {
        return this.collection_id;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCollection_name() {
        return this.collection_name;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getInstructor_amount() {
        return this.instructor_amount;
    }

    public final List<String> component7() {
        return this.instructor_names;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getIs_favorite() {
        return this.is_favorite;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getWorkout_amount() {
        return this.workout_amount;
    }

    public final ClassCollectionData copy(String background_url, List<String> class_types, String collection_description, String collection_id, String collection_name, Integer instructor_amount, List<String> instructor_names, Boolean is_favorite, Integer workout_amount) {
        return new ClassCollectionData(background_url, class_types, collection_description, collection_id, collection_name, instructor_amount, instructor_names, is_favorite, workout_amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassCollectionData)) {
            return false;
        }
        ClassCollectionData classCollectionData = (ClassCollectionData) other;
        return Intrinsics.areEqual(this.background_url, classCollectionData.background_url) && Intrinsics.areEqual(this.class_types, classCollectionData.class_types) && Intrinsics.areEqual(this.collection_description, classCollectionData.collection_description) && Intrinsics.areEqual(this.collection_id, classCollectionData.collection_id) && Intrinsics.areEqual(this.collection_name, classCollectionData.collection_name) && Intrinsics.areEqual(this.instructor_amount, classCollectionData.instructor_amount) && Intrinsics.areEqual(this.instructor_names, classCollectionData.instructor_names) && Intrinsics.areEqual(this.is_favorite, classCollectionData.is_favorite) && Intrinsics.areEqual(this.workout_amount, classCollectionData.workout_amount);
    }

    public int hashCode() {
        String str = this.background_url;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.class_types;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.collection_description;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.collection_id;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.collection_name;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.instructor_amount;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        List<String> list2 = this.instructor_names;
        int iHashCode7 = (iHashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool = this.is_favorite;
        int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.workout_amount;
        return iHashCode8 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "ClassCollectionData(background_url=" + this.background_url + ", class_types=" + this.class_types + ", collection_description=" + this.collection_description + ", collection_id=" + this.collection_id + ", collection_name=" + this.collection_name + ", instructor_amount=" + this.instructor_amount + ", instructor_names=" + this.instructor_names + ", is_favorite=" + this.is_favorite + ", workout_amount=" + this.workout_amount + ')';
    }

    public ClassCollectionData(String str, List<String> list, String str2, String str3, String str4, Integer num, List<String> list2, Boolean bool, Integer num2) {
        this.background_url = str;
        this.class_types = list;
        this.collection_description = str2;
        this.collection_id = str3;
        this.collection_name = str4;
        this.instructor_amount = num;
        this.instructor_names = list2;
        this.is_favorite = bool;
        this.workout_amount = num2;
    }

    public /* synthetic */ ClassCollectionData(String str, List list, String str2, String str3, String str4, Integer num, List list2, Boolean bool, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : list2, (i & 128) != 0 ? null : bool, (i & 256) == 0 ? num2 : null);
    }

    public final String getBackground_url() {
        return this.background_url;
    }

    public final List<String> getClass_types() {
        return this.class_types;
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

    public final Integer getInstructor_amount() {
        return this.instructor_amount;
    }

    public final List<String> getInstructor_names() {
        return this.instructor_names;
    }

    public final Boolean is_favorite() {
        return this.is_favorite;
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
}
