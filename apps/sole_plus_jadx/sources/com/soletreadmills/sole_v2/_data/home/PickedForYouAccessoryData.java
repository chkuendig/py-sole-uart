package com.soletreadmills.sole_v2._data.home;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PickedForYouAccessoryData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/home/PickedForYouAccessoryData;", "", "type", "", "weightLevel", "amount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getType", "()Ljava/lang/String;", "getWeightLevel", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/soletreadmills/sole_v2/_data/home/PickedForYouAccessoryData;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PickedForYouAccessoryData {
    public static final int $stable = 0;

    @SerializedName("amount")
    private final Double amount;

    @SerializedName("type")
    private final String type;

    @SerializedName("weight_level")
    private final String weightLevel;

    public PickedForYouAccessoryData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PickedForYouAccessoryData copy$default(PickedForYouAccessoryData pickedForYouAccessoryData, String str, String str2, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pickedForYouAccessoryData.type;
        }
        if ((i & 2) != 0) {
            str2 = pickedForYouAccessoryData.weightLevel;
        }
        if ((i & 4) != 0) {
            d = pickedForYouAccessoryData.amount;
        }
        return pickedForYouAccessoryData.copy(str, str2, d);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getWeightLevel() {
        return this.weightLevel;
    }

    /* renamed from: component3, reason: from getter */
    public final Double getAmount() {
        return this.amount;
    }

    public final PickedForYouAccessoryData copy(String type, String weightLevel, Double amount) {
        return new PickedForYouAccessoryData(type, weightLevel, amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickedForYouAccessoryData)) {
            return false;
        }
        PickedForYouAccessoryData pickedForYouAccessoryData = (PickedForYouAccessoryData) other;
        return Intrinsics.areEqual(this.type, pickedForYouAccessoryData.type) && Intrinsics.areEqual(this.weightLevel, pickedForYouAccessoryData.weightLevel) && Intrinsics.areEqual((Object) this.amount, (Object) pickedForYouAccessoryData.amount);
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.weightLevel;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d = this.amount;
        return iHashCode2 + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "PickedForYouAccessoryData(type=" + this.type + ", weightLevel=" + this.weightLevel + ", amount=" + this.amount + ')';
    }

    public PickedForYouAccessoryData(String str, String str2, Double d) {
        this.type = str;
        this.weightLevel = str2;
        this.amount = d;
    }

    public /* synthetic */ PickedForYouAccessoryData(String str, String str2, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : d);
    }

    public final String getType() {
        return this.type;
    }

    public final String getWeightLevel() {
        return this.weightLevel;
    }

    public final Double getAmount() {
        return this.amount;
    }
}
