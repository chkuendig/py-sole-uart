package com.soletreadmills.sole_v2._data.api.classes;

import com.soletreadmills.sole_v2._data.api.classes.GetClassInstructorsApiData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetClassInstructorsApiData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/classes/SessionInstructorsData;", "Lcom/soletreadmills/sole_v2/_data/api/classes/ClassInstructorsDataBase;", "instructorsData", "Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ClassInstructorsData;", "isSelect", "", "(Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ClassInstructorsData;Z)V", "getInstructorsData", "()Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ClassInstructorsData;", "setInstructorsData", "(Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ClassInstructorsData;)V", "()Z", "setSelect", "(Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionInstructorsData implements ClassInstructorsDataBase {
    public static final int $stable = 8;
    private GetClassInstructorsApiData.ClassInstructorsData instructorsData;
    private boolean isSelect;

    public static /* synthetic */ SessionInstructorsData copy$default(SessionInstructorsData sessionInstructorsData, GetClassInstructorsApiData.ClassInstructorsData classInstructorsData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            classInstructorsData = sessionInstructorsData.instructorsData;
        }
        if ((i & 2) != 0) {
            z = sessionInstructorsData.isSelect;
        }
        return sessionInstructorsData.copy(classInstructorsData, z);
    }

    /* renamed from: component1, reason: from getter */
    public final GetClassInstructorsApiData.ClassInstructorsData getInstructorsData() {
        return this.instructorsData;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final SessionInstructorsData copy(GetClassInstructorsApiData.ClassInstructorsData instructorsData, boolean isSelect) {
        Intrinsics.checkNotNullParameter(instructorsData, "instructorsData");
        return new SessionInstructorsData(instructorsData, isSelect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionInstructorsData)) {
            return false;
        }
        SessionInstructorsData sessionInstructorsData = (SessionInstructorsData) other;
        return Intrinsics.areEqual(this.instructorsData, sessionInstructorsData.instructorsData) && this.isSelect == sessionInstructorsData.isSelect;
    }

    public int hashCode() {
        return (this.instructorsData.hashCode() * 31) + Boolean.hashCode(this.isSelect);
    }

    public String toString() {
        return "SessionInstructorsData(instructorsData=" + this.instructorsData + ", isSelect=" + this.isSelect + ')';
    }

    public SessionInstructorsData(GetClassInstructorsApiData.ClassInstructorsData instructorsData, boolean z) {
        Intrinsics.checkNotNullParameter(instructorsData, "instructorsData");
        this.instructorsData = instructorsData;
        this.isSelect = z;
    }

    public /* synthetic */ SessionInstructorsData(GetClassInstructorsApiData.ClassInstructorsData classInstructorsData, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(classInstructorsData, (i & 2) != 0 ? false : z);
    }

    @Override // com.soletreadmills.sole_v2._data.api.classes.ClassInstructorsDataBase
    public GetClassInstructorsApiData.ClassInstructorsData getInstructorsData() {
        return this.instructorsData;
    }

    @Override // com.soletreadmills.sole_v2._data.api.classes.ClassInstructorsDataBase
    public void setInstructorsData(GetClassInstructorsApiData.ClassInstructorsData classInstructorsData) {
        Intrinsics.checkNotNullParameter(classInstructorsData, "<set-?>");
        this.instructorsData = classInstructorsData;
    }

    @Override // com.soletreadmills.sole_v2._data.api.classes.ClassInstructorsDataBase
    public boolean isSelect() {
        return this.isSelect;
    }

    @Override // com.soletreadmills.sole_v2._data.api.classes.ClassInstructorsDataBase
    public void setSelect(boolean z) {
        this.isSelect = z;
    }
}
