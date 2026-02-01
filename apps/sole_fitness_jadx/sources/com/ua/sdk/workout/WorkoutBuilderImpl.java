package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.activitystory.Attachment;
import com.ua.sdk.activitystory.Attachments;
import com.ua.sdk.activitystory.SocialSettings;
import com.ua.sdk.activitytype.ActivityTypeRef;
import com.ua.sdk.gear.user.UserGearRef;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.route.RouteRef;
import com.ua.sdk.user.User;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class WorkoutBuilderImpl implements WorkoutBuilder, Parcelable {
    public static final Parcelable.Creator<WorkoutBuilderImpl> CREATOR = new Parcelable.Creator<WorkoutBuilderImpl>() { // from class: com.ua.sdk.workout.WorkoutBuilderImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutBuilderImpl createFromParcel(Parcel parcel) {
            return new WorkoutBuilderImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutBuilderImpl[] newArray(int i) {
            return new WorkoutBuilderImpl[i];
        }
    };
    ActivityTypeRef activityTypeEntityRef;
    Attachments attachments;
    private boolean buildNewTimeSeries;
    Date createdTime;
    boolean hasTimeSeries;
    private boolean isUpdate;
    long localId;
    private double maxOffset;
    String name;
    String notes;
    Privacy.Level privacy;
    String referenceKey;
    RouteRef routeRef;
    SocialSettings socialSettings;
    String source;
    Date startTime;
    WorkoutTimeSeriesImpl timeSeries;
    TimeZone timeZone;
    Date updateTime;
    private boolean updatedCadence;
    private boolean updatedHeartRate;
    private boolean updatedPower;
    private boolean updatedSpeed;
    private boolean updatedTorque;
    UserGearRef userGearEntityRef;
    EntityRef<User> userRef;
    WorkoutAggregatesImpl workoutAggregates;
    TimeSeriesImpl<WorkoutCadenceEntry> workoutCadenceEntryTimeSeries;
    TimeSeriesImpl<WorkoutDistanceEntry> workoutDistanceTimeSeries;
    TimeSeriesImpl<WorkoutHeartRateEntry> workoutHeartRateEntryTimeSeries;
    TimeSeriesImpl<WorkoutPositionEntry> workoutPositionEntryTimeSeries;
    TimeSeriesImpl<WorkoutPowerEntry> workoutPowerEntryTimeSeries;
    WorkoutRef workoutRef;
    TimeSeriesImpl<WorkoutSpeedEntry> workoutSpeedEntryTimeSeries;
    TimeSeriesImpl<WorkoutStepsEntry> workoutStepsEntryTimeSeries;
    TimeSeriesImpl<WorkoutTimerStopEntry> workoutStopTimeEntryTimeSeries;
    TimeSeriesImpl<WorkoutTorqueEntry> workoutTorqueEntryTimeSeries;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WorkoutBuilderImpl() {
        this.maxOffset = 0.0d;
        this.buildNewTimeSeries = false;
        this.isUpdate = false;
        this.updatedHeartRate = false;
        this.updatedSpeed = false;
        this.updatedCadence = false;
        this.updatedPower = false;
        this.updatedTorque = false;
    }

    public WorkoutBuilderImpl(Workout workout, boolean z) {
        this.maxOffset = 0.0d;
        this.buildNewTimeSeries = false;
        this.isUpdate = false;
        this.updatedHeartRate = false;
        this.updatedSpeed = false;
        this.updatedCadence = false;
        this.updatedPower = false;
        this.updatedTorque = false;
        this.startTime = workout.getStartTime();
        this.updateTime = workout.getUpdatedTime();
        this.createdTime = workout.getCreatedTime();
        this.name = workout.getName();
        this.notes = workout.getNotes();
        this.timeZone = workout.getTimeZone();
        this.source = workout.getSource();
        this.referenceKey = workout.getReferenceKey();
        this.workoutAggregates = (WorkoutAggregatesImpl) workout.getAggregates();
        this.activityTypeEntityRef = workout.getActivityTypeRef();
        this.userGearEntityRef = workout.getUserGearRef();
        this.privacy = workout.getPrivacy().getLevel();
        this.socialSettings = workout.getSocialSettings();
        this.workoutRef = (WorkoutRef) workout.getRef();
        this.routeRef = workout.getRouteRef();
        this.userRef = workout.getUserRef();
        if (!z) {
            WorkoutTimeSeriesImpl workoutTimeSeriesImpl = (WorkoutTimeSeriesImpl) workout.getTimeSeriesData();
            this.timeSeries = workoutTimeSeriesImpl;
            if (workoutTimeSeriesImpl != null) {
                this.workoutHeartRateEntryTimeSeries = ((WorkoutTimeSeriesImpl) workout.getTimeSeriesData()).workoutHeartRateEntryTimeSeries;
                this.workoutSpeedEntryTimeSeries = ((WorkoutTimeSeriesImpl) workout.getTimeSeriesData()).workoutSpeedEntryTimeSeries;
                this.workoutCadenceEntryTimeSeries = ((WorkoutTimeSeriesImpl) workout.getTimeSeriesData()).workoutCadenceEntryTimeSeries;
                this.workoutPowerEntryTimeSeries = ((WorkoutTimeSeriesImpl) workout.getTimeSeriesData()).workoutPowerEntryTimeSeries;
                this.workoutTorqueEntryTimeSeries = ((WorkoutTimeSeriesImpl) workout.getTimeSeriesData()).workoutTorqueEntryTimeSeries;
                this.workoutDistanceTimeSeries = ((WorkoutTimeSeriesImpl) workout.getTimeSeriesData()).workoutDistanceTimeSeries;
                this.workoutStepsEntryTimeSeries = ((WorkoutTimeSeriesImpl) workout.getTimeSeriesData()).workoutStepsEntryTimeSeries;
                this.workoutPositionEntryTimeSeries = ((WorkoutTimeSeriesImpl) workout.getTimeSeriesData()).workoutPositionEntryTimeSeries;
                this.workoutStopTimeEntryTimeSeries = ((WorkoutTimeSeriesImpl) workout.getTimeSeriesData()).workoutStopTimeEntryTimeSeries;
            }
        }
        WorkoutAggregatesImpl workoutAggregatesImpl = this.workoutAggregates;
        if (workoutAggregatesImpl != null && workoutAggregatesImpl.getElapsedTimeTotal() != null) {
            this.maxOffset = this.workoutAggregates.getElapsedTimeTotal().doubleValue();
        }
        this.isUpdate = true;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setLocalId(Long l) {
        this.localId = l.longValue();
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setStartTime(Date date) {
        this.startTime = date;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setCreateTime(Date date) {
        this.createdTime = date;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setUpdateTime(Date date) {
        this.updateTime = date;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setName(String str) {
        this.name = str;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setNotes(String str) {
        this.notes = str;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setSource(String str) {
        this.source = str;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setReferenceKey(String str) {
        this.referenceKey = str;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setHasTimeSeries(Boolean bool) {
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        this.hasTimeSeries = bool.booleanValue();
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setActivityType(ActivityTypeRef activityTypeRef) {
        this.activityTypeEntityRef = activityTypeRef;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setUserGear(UserGearRef userGearRef) {
        this.userGearEntityRef = userGearRef;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setPrivacy(Privacy.Level level) {
        this.privacy = level;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setSocialSettings(SocialSettings socialSettings) {
        this.socialSettings = socialSettings;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setRouteRef(RouteRef routeRef) {
        this.routeRef = routeRef;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder addAttachment(Attachment.Type type) {
        if (this.attachments == null) {
            this.attachments = new Attachments();
        }
        this.attachments.addAttachment(type);
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setTotalTime(Double d, Double d2) {
        if (this.workoutAggregates == null) {
            this.workoutAggregates = new WorkoutAggregatesImpl();
        }
        this.workoutAggregates.activeTimeTotal = d;
        this.workoutAggregates.elapsedTimeTotal = d2;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setTotalDistance(Double d) {
        if (this.workoutAggregates == null) {
            this.workoutAggregates = new WorkoutAggregatesImpl();
        }
        this.workoutAggregates.distanceTotal = d;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setMetabolicEnergyTotal(Double d) {
        if (this.workoutAggregates == null) {
            this.workoutAggregates = new WorkoutAggregatesImpl();
        }
        this.workoutAggregates.metabolicEnergyTotal = d;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setWillPower(Double d) {
        if (this.workoutAggregates == null) {
            this.workoutAggregates = new WorkoutAggregatesImpl();
        }
        this.workoutAggregates.willPower = d;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setStepsTotal(Integer num) {
        if (this.workoutAggregates == null) {
            this.workoutAggregates = new WorkoutAggregatesImpl();
        }
        this.workoutAggregates.stepsTotal = num;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setHeartRateAggregates(Integer num, Integer num2, Integer num3) {
        if (this.workoutAggregates == null) {
            this.workoutAggregates = new WorkoutAggregatesImpl();
        }
        this.workoutAggregates.heartRateMax = num;
        this.workoutAggregates.heartRateMin = num2;
        this.workoutAggregates.heartRateAvg = num3;
        this.updatedHeartRate = true;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setSpeedAggregates(Double d, Double d2, Double d3) {
        if (this.workoutAggregates == null) {
            this.workoutAggregates = new WorkoutAggregatesImpl();
        }
        this.workoutAggregates.speedMax = d;
        this.workoutAggregates.speedMin = d2;
        this.workoutAggregates.speedAvg = d3;
        this.updatedSpeed = true;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setCadenceAggregates(Integer num, Integer num2, Integer num3) {
        if (this.workoutAggregates == null) {
            this.workoutAggregates = new WorkoutAggregatesImpl();
        }
        this.workoutAggregates.cadenceMax = num;
        this.workoutAggregates.cadenceMin = num2;
        this.workoutAggregates.cadenceAvg = num3;
        this.updatedCadence = true;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setPowerAggregates(Double d, Double d2, Double d3) {
        if (this.workoutAggregates == null) {
            this.workoutAggregates = new WorkoutAggregatesImpl();
        }
        this.workoutAggregates.powerMax = d;
        this.workoutAggregates.powerMin = d2;
        this.workoutAggregates.powerAvg = d3;
        this.updatedPower = true;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder setTorqueAggregates(Double d, Double d2, Double d3) {
        if (this.workoutAggregates == null) {
            this.workoutAggregates = new WorkoutAggregatesImpl();
        }
        this.workoutAggregates.torqueMax = d;
        this.workoutAggregates.torqueMin = d2;
        this.workoutAggregates.torqueAvg = d3;
        this.updatedTorque = true;
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder addHeartRateEvent(double d, int i) {
        WorkoutAggregatesImpl workoutAggregatesImpl;
        if (this.workoutHeartRateEntryTimeSeries == null) {
            this.workoutHeartRateEntryTimeSeries = new TimeSeriesImpl<>();
        }
        this.buildNewTimeSeries = true;
        if (this.isUpdate && !this.updatedHeartRate && (workoutAggregatesImpl = this.workoutAggregates) != null) {
            this.updatedHeartRate = true;
            workoutAggregatesImpl.heartRateAvg = null;
            this.workoutAggregates.heartRateMax = null;
            this.workoutAggregates.heartRateMin = null;
        }
        if (d > this.maxOffset) {
            this.maxOffset = d;
        }
        this.workoutHeartRateEntryTimeSeries.add(new WorkoutHeartRateEntryImpl(Double.valueOf(d), Integer.valueOf(i)));
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder addSpeedEvent(double d, double d2) {
        WorkoutAggregatesImpl workoutAggregatesImpl;
        if (this.workoutSpeedEntryTimeSeries == null) {
            this.workoutSpeedEntryTimeSeries = new TimeSeriesImpl<>();
        }
        this.buildNewTimeSeries = true;
        if (this.isUpdate && !this.updatedSpeed && (workoutAggregatesImpl = this.workoutAggregates) != null) {
            this.updatedSpeed = true;
            workoutAggregatesImpl.speedAvg = null;
            this.workoutAggregates.speedMax = null;
            this.workoutAggregates.speedMin = null;
        }
        if (d > this.maxOffset) {
            this.maxOffset = d;
        }
        this.workoutSpeedEntryTimeSeries.add(new WorkoutSpeedEntryImpl(Double.valueOf(d), Double.valueOf(d2)));
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder addCadenceEvent(double d, int i) {
        WorkoutAggregatesImpl workoutAggregatesImpl;
        if (this.workoutCadenceEntryTimeSeries == null) {
            this.workoutCadenceEntryTimeSeries = new TimeSeriesImpl<>();
        }
        this.buildNewTimeSeries = true;
        if (this.isUpdate && !this.updatedCadence && (workoutAggregatesImpl = this.workoutAggregates) != null) {
            this.updatedCadence = true;
            workoutAggregatesImpl.cadenceAvg = null;
            this.workoutAggregates.cadenceMax = null;
            this.workoutAggregates.cadenceMin = null;
        }
        if (d > this.maxOffset) {
            this.maxOffset = d;
        }
        this.workoutCadenceEntryTimeSeries.add(new WorkoutCadenceEntryImpl(Double.valueOf(d), Integer.valueOf(i)));
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder addPowerEvent(double d, double d2) {
        WorkoutAggregatesImpl workoutAggregatesImpl;
        if (this.workoutPowerEntryTimeSeries == null) {
            this.workoutPowerEntryTimeSeries = new TimeSeriesImpl<>();
        }
        this.buildNewTimeSeries = true;
        if (this.isUpdate && !this.updatedPower && (workoutAggregatesImpl = this.workoutAggregates) != null) {
            this.updatedPower = true;
            workoutAggregatesImpl.powerAvg = null;
            this.workoutAggregates.powerMax = null;
            this.workoutAggregates.powerMin = null;
        }
        if (d > this.maxOffset) {
            this.maxOffset = d;
        }
        this.workoutPowerEntryTimeSeries.add(new WorkoutPowerEntryImpl(Double.valueOf(d), Double.valueOf(d2)));
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder addTorqueEvent(double d, double d2) {
        WorkoutAggregatesImpl workoutAggregatesImpl;
        if (this.workoutTorqueEntryTimeSeries == null) {
            this.workoutTorqueEntryTimeSeries = new TimeSeriesImpl<>();
        }
        if (this.isUpdate && !this.updatedTorque && (workoutAggregatesImpl = this.workoutAggregates) != null) {
            this.updatedTorque = true;
            workoutAggregatesImpl.torqueAvg = null;
            this.workoutAggregates.torqueMax = null;
            this.workoutAggregates.torqueMin = null;
        }
        this.buildNewTimeSeries = true;
        if (d > this.maxOffset) {
            this.maxOffset = d;
        }
        this.workoutTorqueEntryTimeSeries.add(new WorkoutTorqueEntryImpl(Double.valueOf(d), Double.valueOf(d2)));
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder addDistanceEvent(double d, double d2) {
        if (this.workoutDistanceTimeSeries == null) {
            this.workoutDistanceTimeSeries = new TimeSeriesImpl<>();
        }
        this.buildNewTimeSeries = true;
        if (d > this.maxOffset) {
            this.maxOffset = d;
        }
        this.workoutDistanceTimeSeries.add(new WorkoutDistanceEntryImpl(Double.valueOf(d), Double.valueOf(d2)));
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder addStepsEvent(double d, int i) {
        if (this.workoutStepsEntryTimeSeries == null) {
            this.workoutStepsEntryTimeSeries = new TimeSeriesImpl<>();
        }
        this.buildNewTimeSeries = true;
        if (d > this.maxOffset) {
            this.maxOffset = d;
        }
        this.workoutStepsEntryTimeSeries.add(new WorkoutStepsEntryImpl(Double.valueOf(d), Integer.valueOf(i)));
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder addPositionEvent(double d, Double d2, Double d3, Double d4) {
        if (this.workoutPositionEntryTimeSeries == null) {
            this.workoutPositionEntryTimeSeries = new TimeSeriesImpl<>();
        }
        this.buildNewTimeSeries = true;
        if (d > this.maxOffset) {
            this.maxOffset = d;
        }
        this.workoutPositionEntryTimeSeries.add(new WorkoutPositionEntryImpl(Double.valueOf(d), d2, d3, d4));
        return this;
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public WorkoutBuilder addTimerStopEvent(double d, double d2) {
        if (this.workoutStopTimeEntryTimeSeries == null) {
            this.workoutStopTimeEntryTimeSeries = new TimeSeriesImpl<>();
        }
        this.buildNewTimeSeries = true;
        if (d > this.maxOffset) {
            this.maxOffset = d;
        }
        this.workoutStopTimeEntryTimeSeries.add(new WorkoutTimerStopEntryImpl(Double.valueOf(d), Double.valueOf(d2)));
        return this;
    }

    private void createHeartRateAggregates() {
        Iterator<T> it = this.workoutHeartRateEntryTimeSeries.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            int bpm = ((WorkoutHeartRateEntry) it.next()).getBpm();
            if (bpm < i3 || i3 == 0) {
                i3 = bpm;
            }
            if (bpm > i2) {
                i2 = bpm;
            }
            i += bpm;
        }
        double size = i / this.workoutHeartRateEntryTimeSeries.getSize();
        this.workoutAggregates.heartRateMax = Integer.valueOf(i2);
        this.workoutAggregates.heartRateMin = Integer.valueOf(i3);
        this.workoutAggregates.heartRateAvg = Integer.valueOf((int) size);
    }

    private void createSpeedAggregates() {
        Iterator<T> it = this.workoutSpeedEntryTimeSeries.iterator();
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (it.hasNext()) {
            double instantaneousSpeed = ((WorkoutSpeedEntry) it.next()).getInstantaneousSpeed();
            if (instantaneousSpeed < d2 || d2 == 0.0d) {
                d2 = instantaneousSpeed;
            }
            if (instantaneousSpeed > d) {
                d = instantaneousSpeed;
            }
            d3 += instantaneousSpeed;
        }
        this.workoutAggregates.speedMax = Double.valueOf(d);
        this.workoutAggregates.speedMin = Double.valueOf(d2);
        if (this.workoutAggregates.activeTimeTotal != null && this.workoutAggregates.distanceTotal != null) {
            WorkoutAggregatesImpl workoutAggregatesImpl = this.workoutAggregates;
            workoutAggregatesImpl.speedAvg = Double.valueOf(workoutAggregatesImpl.distanceTotal.doubleValue() / this.workoutAggregates.activeTimeTotal.doubleValue());
        } else {
            this.workoutAggregates.speedAvg = Double.valueOf(d3 / this.workoutSpeedEntryTimeSeries.getSize());
        }
    }

    private void createPowerAggregates() {
        Iterator<T> it = this.workoutPowerEntryTimeSeries.iterator();
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (it.hasNext()) {
            double instantaneousPower = ((WorkoutPowerEntry) it.next()).getInstantaneousPower();
            if (instantaneousPower < d3 || d3 == 0.0d) {
                d3 = instantaneousPower;
            }
            if (instantaneousPower > d2) {
                d2 = instantaneousPower;
            }
            d += instantaneousPower;
        }
        this.workoutAggregates.powerMax = Double.valueOf(d2);
        this.workoutAggregates.powerMin = Double.valueOf(d3);
        this.workoutAggregates.powerAvg = Double.valueOf(d / this.workoutPowerEntryTimeSeries.getSize());
    }

    private void createCadenceAggregates() {
        Iterator<T> it = this.workoutCadenceEntryTimeSeries.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            int instantaneousCadence = ((WorkoutCadenceEntry) it.next()).getInstantaneousCadence();
            if (instantaneousCadence < i3 || i3 == 0) {
                i3 = instantaneousCadence;
            }
            if (instantaneousCadence > i2) {
                i2 = instantaneousCadence;
            }
            i += instantaneousCadence;
        }
        int size = i / this.workoutCadenceEntryTimeSeries.getSize();
        this.workoutAggregates.cadenceMax = Integer.valueOf(i2);
        this.workoutAggregates.cadenceMin = Integer.valueOf(i3);
        this.workoutAggregates.cadenceAvg = Integer.valueOf(size);
    }

    private void createTorqueAggregates() {
        Iterator<T> it = this.workoutTorqueEntryTimeSeries.iterator();
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (it.hasNext()) {
            double instantaneousTorque = ((WorkoutTorqueEntry) it.next()).getInstantaneousTorque();
            if (instantaneousTorque < d3 || d3 == 0.0d) {
                d3 = instantaneousTorque;
            }
            if (instantaneousTorque > d2) {
                d2 = instantaneousTorque;
            }
            d += instantaneousTorque;
        }
        this.workoutAggregates.torqueMax = Double.valueOf(d2);
        this.workoutAggregates.torqueMin = Double.valueOf(d3);
        this.workoutAggregates.torqueAvg = Double.valueOf(d / this.workoutTorqueEntryTimeSeries.getSize());
    }

    private void createDistanceAggregate() {
        this.workoutAggregates.distanceTotal = Double.valueOf(((WorkoutDistanceEntry) this.timeSeries.workoutDistanceTimeSeries.get(this.timeSeries.workoutDistanceTimeSeries.getSize() - 1)).getDistance());
    }

    private void createTimeAggregates() {
        double d = this.maxOffset;
        double stoppedTime = 0.0d;
        if (d > 0.0d) {
            this.workoutAggregates.elapsedTimeTotal = Double.valueOf(d);
            TimeSeriesImpl<WorkoutTimerStopEntry> timeSeriesImpl = this.workoutStopTimeEntryTimeSeries;
            if (timeSeriesImpl != null) {
                Iterator<T> it = timeSeriesImpl.iterator();
                while (it.hasNext()) {
                    stoppedTime += ((WorkoutTimerStopEntry) it.next()).getStoppedTime();
                }
                this.workoutAggregates.activeTimeTotal = Double.valueOf(this.maxOffset - stoppedTime);
                return;
            }
            this.workoutAggregates.activeTimeTotal = Double.valueOf(this.maxOffset);
        }
    }

    @Override // com.ua.sdk.workout.WorkoutBuilder
    public Workout build() {
        WorkoutAggregatesImpl workoutAggregatesImpl;
        if (this.name == null) {
            throw new IllegalArgumentException("name must be set.");
        }
        if (this.startTime == null) {
            throw new IllegalArgumentException("startTime must be set.");
        }
        if (this.createdTime == null) {
            throw new IllegalArgumentException("createdTime must be set.");
        }
        if (this.timeZone == null) {
            throw new IllegalArgumentException("timeZone must be set.");
        }
        if (this.privacy == null) {
            throw new IllegalArgumentException("privacy must be set.");
        }
        if (this.activityTypeEntityRef == null) {
            throw new IllegalArgumentException("activity ref must be set.");
        }
        if (this.buildNewTimeSeries) {
            this.timeSeries = new WorkoutTimeSeriesImpl();
            if (this.workoutAggregates == null) {
                this.workoutAggregates = new WorkoutAggregatesImpl();
            }
            TimeSeriesImpl<WorkoutHeartRateEntry> timeSeriesImpl = this.workoutHeartRateEntryTimeSeries;
            if (timeSeriesImpl != null) {
                timeSeriesImpl.sort();
                this.timeSeries.workoutHeartRateEntryTimeSeries = this.workoutHeartRateEntryTimeSeries;
                if (this.workoutAggregates.heartRateAvg == null) {
                    createHeartRateAggregates();
                }
            }
            TimeSeriesImpl<WorkoutCadenceEntry> timeSeriesImpl2 = this.workoutCadenceEntryTimeSeries;
            if (timeSeriesImpl2 != null) {
                timeSeriesImpl2.sort();
                this.timeSeries.workoutCadenceEntryTimeSeries = this.workoutCadenceEntryTimeSeries;
                if (this.workoutAggregates.cadenceAvg == null) {
                    createCadenceAggregates();
                }
            }
            TimeSeriesImpl<WorkoutPowerEntry> timeSeriesImpl3 = this.workoutPowerEntryTimeSeries;
            if (timeSeriesImpl3 != null) {
                timeSeriesImpl3.sort();
                this.timeSeries.workoutPowerEntryTimeSeries = this.workoutPowerEntryTimeSeries;
                if (this.workoutAggregates.powerAvg == null) {
                    createPowerAggregates();
                }
            }
            TimeSeriesImpl<WorkoutTorqueEntry> timeSeriesImpl4 = this.workoutTorqueEntryTimeSeries;
            if (timeSeriesImpl4 != null) {
                timeSeriesImpl4.sort();
                this.timeSeries.workoutTorqueEntryTimeSeries = this.workoutTorqueEntryTimeSeries;
                if (this.workoutAggregates.torqueAvg == null) {
                    createTorqueAggregates();
                }
            }
            TimeSeriesImpl<WorkoutDistanceEntry> timeSeriesImpl5 = this.workoutDistanceTimeSeries;
            if (timeSeriesImpl5 != null) {
                timeSeriesImpl5.sort();
                this.timeSeries.workoutDistanceTimeSeries = this.workoutDistanceTimeSeries;
                createDistanceAggregate();
            }
            TimeSeriesImpl<WorkoutStepsEntry> timeSeriesImpl6 = this.workoutStepsEntryTimeSeries;
            if (timeSeriesImpl6 != null) {
                timeSeriesImpl6.sort();
                this.timeSeries.workoutStepsEntryTimeSeries = this.workoutStepsEntryTimeSeries;
            }
            TimeSeriesImpl<WorkoutPositionEntry> timeSeriesImpl7 = this.workoutPositionEntryTimeSeries;
            if (timeSeriesImpl7 != null) {
                timeSeriesImpl7.sort();
                this.timeSeries.workoutPositionEntryTimeSeries = this.workoutPositionEntryTimeSeries;
            }
            TimeSeriesImpl<WorkoutTimerStopEntry> timeSeriesImpl8 = this.workoutStopTimeEntryTimeSeries;
            if (timeSeriesImpl8 != null) {
                timeSeriesImpl8.sort();
                this.timeSeries.workoutStopTimeEntryTimeSeries = this.workoutStopTimeEntryTimeSeries;
            }
            createTimeAggregates();
            TimeSeriesImpl<WorkoutSpeedEntry> timeSeriesImpl9 = this.workoutSpeedEntryTimeSeries;
            if (timeSeriesImpl9 != null) {
                timeSeriesImpl9.sort();
                this.timeSeries.workoutSpeedEntryTimeSeries = this.workoutSpeedEntryTimeSeries;
                if (this.workoutAggregates.speedAvg == null) {
                    createSpeedAggregates();
                }
            }
            this.hasTimeSeries = true;
        }
        if (this.timeSeries == null && ((workoutAggregatesImpl = this.workoutAggregates) == null || workoutAggregatesImpl.activeTimeTotal == null)) {
            throw new IllegalArgumentException("a time series or total time must be provided.");
        }
        return new WorkoutImpl(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Date date = this.startTime;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        Date date2 = this.updateTime;
        parcel.writeLong(date2 != null ? date2.getTime() : -1L);
        Date date3 = this.createdTime;
        parcel.writeLong(date3 != null ? date3.getTime() : -1L);
        parcel.writeString(this.name);
        parcel.writeString(this.notes);
        parcel.writeSerializable(this.timeZone);
        parcel.writeString(this.source);
        parcel.writeString(this.referenceKey);
        parcel.writeParcelable(this.workoutAggregates, i);
        parcel.writeParcelable(this.timeSeries, i);
        parcel.writeParcelable(this.activityTypeEntityRef, i);
        parcel.writeParcelable(this.userGearEntityRef, i);
        Privacy.Level level = this.privacy;
        parcel.writeInt(level == null ? -1 : level.ordinal());
        parcel.writeParcelable(this.workoutHeartRateEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutSpeedEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutCadenceEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutPowerEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutTorqueEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutDistanceTimeSeries, i);
        parcel.writeParcelable(this.workoutStepsEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutPositionEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutStopTimeEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutRef, i);
        parcel.writeParcelable(this.routeRef, i);
        parcel.writeParcelable(this.userRef, i);
        parcel.writeDouble(this.maxOffset);
        parcel.writeByte(this.buildNewTimeSeries ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isUpdate ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.updatedHeartRate ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.updatedSpeed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.updatedCadence ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.updatedPower ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.updatedTorque ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.socialSettings, i);
        parcel.writeParcelable(this.attachments, i);
    }

    private WorkoutBuilderImpl(Parcel parcel) {
        this.maxOffset = 0.0d;
        this.buildNewTimeSeries = false;
        this.isUpdate = false;
        this.updatedHeartRate = false;
        this.updatedSpeed = false;
        this.updatedCadence = false;
        this.updatedPower = false;
        this.updatedTorque = false;
        long j = parcel.readLong();
        this.startTime = j == -1 ? null : new Date(j);
        long j2 = parcel.readLong();
        this.updateTime = j2 == -1 ? null : new Date(j2);
        long j3 = parcel.readLong();
        this.createdTime = j3 == -1 ? null : new Date(j3);
        this.name = parcel.readString();
        this.notes = parcel.readString();
        this.timeZone = (TimeZone) parcel.readSerializable();
        this.source = parcel.readString();
        this.referenceKey = parcel.readString();
        this.workoutAggregates = (WorkoutAggregatesImpl) parcel.readParcelable(WorkoutAggregatesImpl.class.getClassLoader());
        this.timeSeries = (WorkoutTimeSeriesImpl) parcel.readParcelable(WorkoutTimeSeriesImpl.class.getClassLoader());
        this.activityTypeEntityRef = (ActivityTypeRef) parcel.readParcelable(ActivityTypeRef.class.getClassLoader());
        this.userGearEntityRef = (UserGearRef) parcel.readParcelable(UserGearRef.class.getClassLoader());
        int i = parcel.readInt();
        this.privacy = i != -1 ? Privacy.Level.values()[i] : null;
        this.workoutHeartRateEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutSpeedEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutCadenceEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutPowerEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutTorqueEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutDistanceTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutStepsEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutPositionEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutStopTimeEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutRef = (WorkoutRef) parcel.readParcelable(WorkoutRef.class.getClassLoader());
        this.routeRef = (RouteRef) parcel.readParcelable(RouteRef.class.getClassLoader());
        this.userRef = (EntityRef) parcel.readParcelable(EntityRef.class.getClassLoader());
        this.maxOffset = parcel.readDouble();
        this.buildNewTimeSeries = parcel.readByte() != 0;
        this.isUpdate = parcel.readByte() != 0;
        this.updatedHeartRate = parcel.readByte() != 0;
        this.updatedSpeed = parcel.readByte() != 0;
        this.updatedCadence = parcel.readByte() != 0;
        this.updatedPower = parcel.readByte() != 0;
        this.updatedTorque = parcel.readByte() != 0;
        this.socialSettings = (SocialSettings) parcel.readParcelable(SocialSettings.class.getClassLoader());
        this.attachments = (Attachments) parcel.readParcelable(Attachments.class.getClassLoader());
    }
}
