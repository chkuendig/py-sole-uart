package com.soletreadmills.sole_v2._data.classes;

import com.soletreadmills.sole_v2._type.ClassesCategoryType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassesCategoryData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/ClassesCategoryData;", "", "type", "Lcom/soletreadmills/sole_v2/_type/ClassesCategoryType;", "count", "", "select", "", "(Lcom/soletreadmills/sole_v2/_type/ClassesCategoryType;IZ)V", "getCount", "()I", "setCount", "(I)V", "getSelect", "()Z", "setSelect", "(Z)V", "getType", "()Lcom/soletreadmills/sole_v2/_type/ClassesCategoryType;", "setType", "(Lcom/soletreadmills/sole_v2/_type/ClassesCategoryType;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ClassesCategoryData {
    public static final int $stable = 8;
    private int count;
    private boolean select;
    private ClassesCategoryType type;

    public static /* synthetic */ ClassesCategoryData copy$default(ClassesCategoryData classesCategoryData, ClassesCategoryType classesCategoryType, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            classesCategoryType = classesCategoryData.type;
        }
        if ((i2 & 2) != 0) {
            i = classesCategoryData.count;
        }
        if ((i2 & 4) != 0) {
            z = classesCategoryData.select;
        }
        return classesCategoryData.copy(classesCategoryType, i, z);
    }

    /* renamed from: component1, reason: from getter */
    public final ClassesCategoryType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSelect() {
        return this.select;
    }

    public final ClassesCategoryData copy(ClassesCategoryType type, int count, boolean select) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ClassesCategoryData(type, count, select);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassesCategoryData)) {
            return false;
        }
        ClassesCategoryData classesCategoryData = (ClassesCategoryData) other;
        return this.type == classesCategoryData.type && this.count == classesCategoryData.count && this.select == classesCategoryData.select;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + Integer.hashCode(this.count)) * 31) + Boolean.hashCode(this.select);
    }

    public String toString() {
        return "ClassesCategoryData(type=" + this.type + ", count=" + this.count + ", select=" + this.select + ')';
    }

    public ClassesCategoryData(ClassesCategoryType type, int i, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.count = i;
        this.select = z;
    }

    public /* synthetic */ ClassesCategoryData(ClassesCategoryType classesCategoryType, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(classesCategoryType, (i2 & 2) != 0 ? 0 : i, z);
    }

    public final ClassesCategoryType getType() {
        return this.type;
    }

    public final void setType(ClassesCategoryType classesCategoryType) {
        Intrinsics.checkNotNullParameter(classesCategoryType, "<set-?>");
        this.type = classesCategoryType;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final boolean getSelect() {
        return this.select;
    }

    public final void setSelect(boolean z) {
        this.select = z;
    }
}
