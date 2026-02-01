package com.soletreadmills.sole_v2._roomDataBase.summaryTempData;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SummaryTempDataEntity.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\tHÖ\u0001J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/_roomDataBase/summaryTempData/SummaryTempDataEntity;", "", "jsonData", "", "className", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "id", "", "getId", "()I", "setId", "(I)V", "getJsonData", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SummaryTempDataEntity {
    public static final String SUMMARY_TEMP_DATA_TABLE = "SUMMARY_TEMP_DATA_TABLE";
    private final String className;
    private int id;
    private final String jsonData;
    public static final int $stable = 8;

    public static /* synthetic */ SummaryTempDataEntity copy$default(SummaryTempDataEntity summaryTempDataEntity, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = summaryTempDataEntity.jsonData;
        }
        if ((i & 2) != 0) {
            str2 = summaryTempDataEntity.className;
        }
        return summaryTempDataEntity.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getJsonData() {
        return this.jsonData;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    public final SummaryTempDataEntity copy(String jsonData, String className) {
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Intrinsics.checkNotNullParameter(className, "className");
        return new SummaryTempDataEntity(jsonData, className);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SummaryTempDataEntity)) {
            return false;
        }
        SummaryTempDataEntity summaryTempDataEntity = (SummaryTempDataEntity) other;
        return Intrinsics.areEqual(this.jsonData, summaryTempDataEntity.jsonData) && Intrinsics.areEqual(this.className, summaryTempDataEntity.className);
    }

    public int hashCode() {
        return (this.jsonData.hashCode() * 31) + this.className.hashCode();
    }

    public SummaryTempDataEntity(String jsonData, String className) {
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Intrinsics.checkNotNullParameter(className, "className");
        this.jsonData = jsonData;
        this.className = className;
    }

    public final String getJsonData() {
        return this.jsonData;
    }

    public final String getClassName() {
        return this.className;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public String toString() {
        return "SummaryTempDataEntity(id=" + this.id + ", jsonData='" + this.jsonData + "', className='" + this.className + "')";
    }
}
