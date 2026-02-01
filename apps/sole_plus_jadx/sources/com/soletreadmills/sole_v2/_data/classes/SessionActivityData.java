package com.soletreadmills.sole_v2._data.classes;

import com.soletreadmills.sole_v2._type.ActivityType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/SessionActivityData;", "Lcom/soletreadmills/sole_v2/_data/classes/ActivityDataBase;", "type", "Lcom/soletreadmills/sole_v2/_type/ActivityType;", "isSelect", "", "(Lcom/soletreadmills/sole_v2/_type/ActivityType;Z)V", "()Z", "setSelect", "(Z)V", "getType", "()Lcom/soletreadmills/sole_v2/_type/ActivityType;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionActivityData implements ActivityDataBase {
    public static final int $stable = 8;
    private boolean isSelect;
    private final ActivityType type;

    public static /* synthetic */ SessionActivityData copy$default(SessionActivityData sessionActivityData, ActivityType activityType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            activityType = sessionActivityData.type;
        }
        if ((i & 2) != 0) {
            z = sessionActivityData.isSelect;
        }
        return sessionActivityData.copy(activityType, z);
    }

    /* renamed from: component1, reason: from getter */
    public final ActivityType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final SessionActivityData copy(ActivityType type, boolean isSelect) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new SessionActivityData(type, isSelect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionActivityData)) {
            return false;
        }
        SessionActivityData sessionActivityData = (SessionActivityData) other;
        return this.type == sessionActivityData.type && this.isSelect == sessionActivityData.isSelect;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + Boolean.hashCode(this.isSelect);
    }

    public String toString() {
        return "SessionActivityData(type=" + this.type + ", isSelect=" + this.isSelect + ')';
    }

    public SessionActivityData(ActivityType type, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.isSelect = z;
    }

    public /* synthetic */ SessionActivityData(ActivityType activityType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activityType, (i & 2) != 0 ? false : z);
    }

    @Override // com.soletreadmills.sole_v2._data.classes.ActivityDataBase
    public ActivityType getType() {
        return this.type;
    }

    @Override // com.soletreadmills.sole_v2._data.classes.ActivityDataBase
    public boolean isSelect() {
        return this.isSelect;
    }

    @Override // com.soletreadmills.sole_v2._data.classes.ActivityDataBase
    public void setSelect(boolean z) {
        this.isSelect = z;
    }
}
