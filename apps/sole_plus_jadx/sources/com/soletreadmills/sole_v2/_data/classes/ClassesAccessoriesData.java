package com.soletreadmills.sole_v2._data.classes;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassesData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/ClassesAccessoriesData;", "", "amount", "", "type", "", "weight_level", "Lcom/soletreadmills/sole_v2/_data/classes/DumbbellsLevelType;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/classes/DumbbellsLevelType;)V", "getAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "()Ljava/lang/String;", "getWeight_level", "()Lcom/soletreadmills/sole_v2/_data/classes/DumbbellsLevelType;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/classes/DumbbellsLevelType;)Lcom/soletreadmills/sole_v2/_data/classes/ClassesAccessoriesData;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ClassesAccessoriesData {
    public static final int $stable = 0;
    private final Integer amount;
    private final String type;
    private final DumbbellsLevelType weight_level;

    public ClassesAccessoriesData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ClassesAccessoriesData copy$default(ClassesAccessoriesData classesAccessoriesData, Integer num, String str, DumbbellsLevelType dumbbellsLevelType, int i, Object obj) {
        if ((i & 1) != 0) {
            num = classesAccessoriesData.amount;
        }
        if ((i & 2) != 0) {
            str = classesAccessoriesData.type;
        }
        if ((i & 4) != 0) {
            dumbbellsLevelType = classesAccessoriesData.weight_level;
        }
        return classesAccessoriesData.copy(num, str, dumbbellsLevelType);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getAmount() {
        return this.amount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final DumbbellsLevelType getWeight_level() {
        return this.weight_level;
    }

    public final ClassesAccessoriesData copy(Integer amount, String type, DumbbellsLevelType weight_level) {
        return new ClassesAccessoriesData(amount, type, weight_level);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassesAccessoriesData)) {
            return false;
        }
        ClassesAccessoriesData classesAccessoriesData = (ClassesAccessoriesData) other;
        return Intrinsics.areEqual(this.amount, classesAccessoriesData.amount) && Intrinsics.areEqual(this.type, classesAccessoriesData.type) && this.weight_level == classesAccessoriesData.weight_level;
    }

    public int hashCode() {
        Integer num = this.amount;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.type;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        DumbbellsLevelType dumbbellsLevelType = this.weight_level;
        return iHashCode2 + (dumbbellsLevelType != null ? dumbbellsLevelType.hashCode() : 0);
    }

    public String toString() {
        return "ClassesAccessoriesData(amount=" + this.amount + ", type=" + this.type + ", weight_level=" + this.weight_level + ')';
    }

    public ClassesAccessoriesData(Integer num, String str, DumbbellsLevelType dumbbellsLevelType) {
        this.amount = num;
        this.type = str;
        this.weight_level = dumbbellsLevelType;
    }

    public /* synthetic */ ClassesAccessoriesData(Integer num, String str, DumbbellsLevelType dumbbellsLevelType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : dumbbellsLevelType);
    }

    public final Integer getAmount() {
        return this.amount;
    }

    public final String getType() {
        return this.type;
    }

    public final DumbbellsLevelType getWeight_level() {
        return this.weight_level;
    }
}
