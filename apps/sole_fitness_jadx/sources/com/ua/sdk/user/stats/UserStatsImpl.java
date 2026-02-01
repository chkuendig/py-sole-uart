package com.ua.sdk.user.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.user.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class UserStatsImpl extends ApiTransferObject implements UserStats {
    public static Parcelable.Creator<UserStatsImpl> CREATOR = new Parcelable.Creator<UserStatsImpl>() { // from class: com.ua.sdk.user.stats.UserStatsImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserStatsImpl createFromParcel(Parcel parcel) {
            return new UserStatsImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserStatsImpl[] newArray(int i) {
            return new UserStatsImpl[i];
        }
    };

    @SerializedName("_embedded")
    Map<String, ArrayList<Stats>> embeddedStats;
    transient ArrayList<Stats> stats;
    transient ArrayList<Stats> summaryStats;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserStatsImpl() {
    }

    @Override // com.ua.sdk.user.stats.UserStats
    public EntityRef<User> getUserRef() {
        Link link = getLink("user");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.user.stats.UserStats
    public List<Stats> getStats() {
        Map<String, ArrayList<Stats>> map = this.embeddedStats;
        if (map == null) {
            return null;
        }
        if (this.stats == null) {
            this.stats = map.get("stats");
        }
        return this.stats;
    }

    @Override // com.ua.sdk.user.stats.UserStats
    public boolean hasSummaryStats() {
        Map<String, ArrayList<Stats>> map = this.embeddedStats;
        if (map == null) {
            return false;
        }
        return map.containsKey("summary_stats");
    }

    @Override // com.ua.sdk.user.stats.UserStats
    public List<Stats> getSummaryStats() {
        if (!hasSummaryStats()) {
            return null;
        }
        if (this.summaryStats == null) {
            this.summaryStats = this.embeddedStats.get("summary_stats");
        }
        return this.summaryStats;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ArrayList<Stats> arrayList = this.stats;
        if (arrayList == null) {
            arrayList = new ArrayList<>(0);
        }
        parcel.writeList(arrayList);
        ArrayList<Stats> arrayList2 = this.summaryStats;
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>(0);
        }
        parcel.writeList(arrayList2);
    }

    private UserStatsImpl(Parcel parcel) {
        ArrayList<Stats> arrayList = new ArrayList<>();
        this.stats = arrayList;
        parcel.readList(arrayList, Stats.class.getClassLoader());
        this.stats = this.stats.size() == 0 ? null : this.stats;
        ArrayList<Stats> arrayList2 = new ArrayList<>();
        this.summaryStats = arrayList2;
        parcel.readList(arrayList2, Stats.class.getClassLoader());
        this.summaryStats = this.summaryStats.size() == 0 ? null : this.summaryStats;
        HashMap map = this.stats != null ? new HashMap() : null;
        this.embeddedStats = map;
        if (map != null) {
            map.put("stats", this.stats);
            ArrayList<Stats> arrayList3 = this.summaryStats;
            if (arrayList3 != null) {
                this.embeddedStats.put("summary_stats", arrayList3);
            }
        }
    }
}
