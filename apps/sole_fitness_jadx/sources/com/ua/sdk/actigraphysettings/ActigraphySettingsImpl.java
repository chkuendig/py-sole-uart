package com.ua.sdk.actigraphysettings;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.Reference;
import java.util.List;

/* loaded from: classes2.dex */
public class ActigraphySettingsImpl implements ActigraphySettings, Parcelable {
    public static Parcelable.Creator<ActigraphySettingsImpl> CREATOR = new Parcelable.Creator<ActigraphySettingsImpl>() { // from class: com.ua.sdk.actigraphysettings.ActigraphySettingsImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphySettingsImpl createFromParcel(Parcel parcel) {
            return new ActigraphySettingsImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphySettingsImpl[] newArray(int i) {
            return new ActigraphySettingsImpl[i];
        }
    };
    private List<String> activityPriority;
    private List<String> sleepPriority;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Resource
    public Reference getRef() {
        return null;
    }

    @Override // com.ua.sdk.actigraphysettings.ActigraphySettings
    public List<String> getSleepRecorderPriorities() {
        return this.sleepPriority;
    }

    @Override // com.ua.sdk.actigraphysettings.ActigraphySettings
    public List<String> getActivityRecorderPriorities() {
        return this.activityPriority;
    }

    public void setActivityPriority(List<String> list) {
        this.activityPriority = list;
    }

    public void setSleepPriority(List<String> list) {
        this.sleepPriority = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.activityPriority);
        parcel.writeStringList(this.sleepPriority);
    }

    public ActigraphySettingsImpl() {
    }

    private ActigraphySettingsImpl(Parcel parcel) {
        parcel.readStringList(this.activityPriority);
        parcel.readStringList(this.sleepPriority);
    }
}
