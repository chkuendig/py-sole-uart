package com.ua.sdk.actigraphy;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.LocalDate;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.user.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class ActigraphyImpl extends ApiTransferObject implements Actigraphy, Parcelable {
    public static Parcelable.Creator<ActigraphyImpl> CREATOR = new Parcelable.Creator<ActigraphyImpl>() { // from class: com.ua.sdk.actigraphy.ActigraphyImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyImpl createFromParcel(Parcel parcel) {
            return new ActigraphyImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyImpl[] newArray(int i) {
            return new ActigraphyImpl[i];
        }
    };
    protected static final String REF_USER = "user";
    private ActigraphyAggregatesImpl mActigraphyAggregatesImpl;
    private ActigraphyMetricsImpl mActigraphyMetricsImpl;
    private LocalDate mDate;
    private Date mEndDateTime;
    private Date mStartDateTime;
    private TimeZone mTimeZone;
    private WorkoutSummaryImpl[] mWorkoutSummaries;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected ActigraphyImpl() {
    }

    public void setAggregates(ActigraphyAggregatesImpl actigraphyAggregatesImpl) {
        this.mActigraphyAggregatesImpl = actigraphyAggregatesImpl;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<Actigraphy> getRef() {
        if (this.mStartDateTime != null) {
            return new LinkEntityRef(String.valueOf(this.mStartDateTime.getTime()), null);
        }
        return null;
    }

    @Override // com.ua.sdk.actigraphy.Actigraphy
    public EntityRef<User> getUserRef() {
        ArrayList<Link> links = getLinks("user");
        if (links == null || links.isEmpty()) {
            return null;
        }
        return new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
    }

    public void setMetrics(ActigraphyMetricsImpl actigraphyMetricsImpl) {
        this.mActigraphyMetricsImpl = actigraphyMetricsImpl;
    }

    public void setWorkoutSummaries(WorkoutSummaryImpl[] workoutSummaryImplArr) {
        this.mWorkoutSummaries = workoutSummaryImplArr;
    }

    public void setDate(LocalDate localDate) {
        this.mDate = localDate;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.mTimeZone = timeZone;
    }

    public void setStartDateTime(Date date) {
        this.mStartDateTime = date;
    }

    public void setEndDateTime(Date date) {
        this.mEndDateTime = date;
    }

    @Override // com.ua.sdk.actigraphy.Actigraphy
    public ActigraphyAggregatesImpl getActigraphyAggregates() {
        return this.mActigraphyAggregatesImpl;
    }

    @Override // com.ua.sdk.actigraphy.Actigraphy
    public ActigraphyMetricsImpl getMetrics() {
        return this.mActigraphyMetricsImpl;
    }

    @Override // com.ua.sdk.actigraphy.Actigraphy
    public WorkoutSummaryImpl[] getWorkoutSummaries() {
        return this.mWorkoutSummaries;
    }

    @Override // com.ua.sdk.actigraphy.Actigraphy
    public LocalDate getDate() {
        return this.mDate;
    }

    @Override // com.ua.sdk.actigraphy.Actigraphy
    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    @Override // com.ua.sdk.actigraphy.Actigraphy
    public Date getStartDateTime() {
        return this.mStartDateTime;
    }

    @Override // com.ua.sdk.actigraphy.Actigraphy
    public Date getEndDateTime() {
        return this.mEndDateTime;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mActigraphyAggregatesImpl, i);
        parcel.writeParcelable(this.mActigraphyMetricsImpl, i);
        parcel.writeParcelableArray(this.mWorkoutSummaries, i);
        parcel.writeParcelable(this.mDate, i);
        TimeZone timeZone = this.mTimeZone;
        parcel.writeString(timeZone != null ? timeZone.getID() : null);
        Date date = this.mStartDateTime;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        Date date2 = this.mEndDateTime;
        parcel.writeLong(date2 != null ? date2.getTime() : -1L);
    }

    private ActigraphyImpl(Parcel parcel) {
        super(parcel);
        this.mActigraphyAggregatesImpl = (ActigraphyAggregatesImpl) parcel.readParcelable(ActigraphyAggregatesImpl.class.getClassLoader());
        this.mActigraphyMetricsImpl = (ActigraphyMetricsImpl) parcel.readParcelable(ActigraphyMetricsImpl.class.getClassLoader());
        Parcelable[] parcelableArray = parcel.readParcelableArray(WorkoutSummaryImpl.class.getClassLoader());
        if (parcelableArray != null) {
            WorkoutSummaryImpl[] workoutSummaryImplArr = new WorkoutSummaryImpl[parcelableArray.length];
            this.mWorkoutSummaries = workoutSummaryImplArr;
            System.arraycopy(parcelableArray, 0, workoutSummaryImplArr, 0, parcelableArray.length);
        } else {
            this.mWorkoutSummaries = null;
        }
        this.mDate = (LocalDate) parcel.readParcelable(LocalDate.class.getClassLoader());
        String string = parcel.readString();
        this.mTimeZone = (string == null || string.length() == 0) ? null : TimeZone.getTimeZone(string);
        Long lValueOf = Long.valueOf(parcel.readLong());
        this.mStartDateTime = lValueOf.longValue() == -1 ? null : new Date(lValueOf.longValue());
        Long lValueOf2 = Long.valueOf(parcel.readLong());
        this.mEndDateTime = lValueOf2.longValue() != -1 ? new Date(lValueOf2.longValue()) : null;
    }
}
