package com.ua.sdk.net.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ua.sdk.LocalDate;
import com.ua.sdk.MeasurementSystem;
import com.ua.sdk.Source;
import com.ua.sdk.activitystory.ActivityStory;
import com.ua.sdk.activitystory.ActivityStoryActor;
import com.ua.sdk.activitystory.ActivityStoryActorAdapter;
import com.ua.sdk.activitystory.ActivityStoryAdapter;
import com.ua.sdk.activitystory.ActivityStoryGroupLeaderboard;
import com.ua.sdk.activitystory.ActivityStoryGroupLeaderboardAdapter;
import com.ua.sdk.activitystory.ActivityStoryHighlight;
import com.ua.sdk.activitystory.ActivityStoryHighlightAdapter;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.activitystory.ActivityStoryObjectAdapter;
import com.ua.sdk.activitystory.ActivityStoryTarget;
import com.ua.sdk.activitystory.ActivityStoryTargetAdapter;
import com.ua.sdk.activitystory.ActivityStoryTemplate;
import com.ua.sdk.activitystory.ActivityStoryTemplateAdapter;
import com.ua.sdk.activitystory.ActivityStoryVerb;
import com.ua.sdk.activitystory.ActivityStoryVerbAdapter;
import com.ua.sdk.activitystory.Attachment;
import com.ua.sdk.activitystory.AttachmentAdapter;
import com.ua.sdk.activitystory.SourceAdapter;
import com.ua.sdk.activitytimeseries.ActivityTimeSeriesImpl;
import com.ua.sdk.activitytimeseries.ActivityTimeSeriesTypeAdapter;
import com.ua.sdk.activitytype.ActivityType;
import com.ua.sdk.activitytype.ActivityTypeAdapter;
import com.ua.sdk.aggregate.Aggregate;
import com.ua.sdk.aggregate.AggregateAdapter;
import com.ua.sdk.aggregate.AggregateSummary;
import com.ua.sdk.aggregate.AggregateSummaryAdapter;
import com.ua.sdk.authentication.FilemobileCredential;
import com.ua.sdk.authentication.FilemobileCredentialAdapter;
import com.ua.sdk.bodymass.BodyMass;
import com.ua.sdk.bodymass.BodyMassAdapter;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifierAdapter;
import com.ua.sdk.device.Device;
import com.ua.sdk.device.DeviceAdapter;
import com.ua.sdk.friendship.FriendshipStatus;
import com.ua.sdk.friendship.FriendshipStatusAdapter;
import com.ua.sdk.gear.Gear;
import com.ua.sdk.gear.GearAdapter;
import com.ua.sdk.gear.brand.GearBrand;
import com.ua.sdk.gear.brand.GearBrandAdapter;
import com.ua.sdk.gear.user.UserGear;
import com.ua.sdk.gear.user.UserGearAdapter;
import com.ua.sdk.group.Group;
import com.ua.sdk.group.GroupAdapter;
import com.ua.sdk.group.invite.GroupInvite;
import com.ua.sdk.group.invite.GroupInviteAdapter;
import com.ua.sdk.group.leaderboard.GroupLeaderboard;
import com.ua.sdk.group.leaderboard.GroupLeaderboardAdapter;
import com.ua.sdk.group.objective.Criteria;
import com.ua.sdk.group.objective.CriteriaGsonAdapter;
import com.ua.sdk.group.objective.GroupObjective;
import com.ua.sdk.group.objective.GroupObjectiveAdapter;
import com.ua.sdk.group.purpose.GroupPurpose;
import com.ua.sdk.group.purpose.GroupPurposeAdapter;
import com.ua.sdk.group.user.GroupUser;
import com.ua.sdk.group.user.GroupUserAdapter;
import com.ua.sdk.heartrate.HeartRateZones;
import com.ua.sdk.heartrate.HeartRateZonesGsonAdapter;
import com.ua.sdk.internal.Period;
import com.ua.sdk.location.Location;
import com.ua.sdk.location.LocationAdapter;
import com.ua.sdk.moderation.ModerationAction;
import com.ua.sdk.moderation.ModerationActionAdapter;
import com.ua.sdk.page.association.PageAssociation;
import com.ua.sdk.page.association.PageAssociationAdapter;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.privacy.PrivacyAdapter;
import com.ua.sdk.recorder.BluetoothSensorDataSourceConfiguration;
import com.ua.sdk.recorder.DerivedDataSourceConfiguration;
import com.ua.sdk.recorder.LocationSensorDataSourceConfiguration;
import com.ua.sdk.recorder.datasource.derived.DerivedDataSourceConfigurationAdapter;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothSensorDataSourceAdapter;
import com.ua.sdk.recorder.datasource.sensor.location.LocationSensorDataSourceAdapter;
import com.ua.sdk.sleep.SleepMetric;
import com.ua.sdk.sleep.SleepMetricAdapter;
import com.ua.sdk.sleep.SleepMetricImpl;
import com.ua.sdk.sleep.SleepTimeSeriesTypeAdapter;
import com.ua.sdk.suggestedfriends.SuggestedFriends;
import com.ua.sdk.suggestedfriends.SuggestedFriendsAdapter;
import com.ua.sdk.user.Gender;
import com.ua.sdk.user.stats.AggregatePeriod;
import com.ua.sdk.user.stats.AggregatePeriodAdapter;
import com.ua.sdk.user.stats.HeartRateTimesAggregate;
import com.ua.sdk.user.stats.HeartRateTimesAggregatesAdapter;
import com.ua.sdk.user.stats.Stats;
import com.ua.sdk.user.stats.StatsAdapter;
import com.ua.sdk.user.stats.UserStats;
import com.ua.sdk.user.stats.UserStatsAdapter;
import com.ua.sdk.workout.TimeSeriesData;
import com.ua.sdk.workout.Workout;
import com.ua.sdk.workout.WorkoutAdapter;
import com.ua.sdk.workout.WorkoutAggregates;
import com.ua.sdk.workout.WorkoutAggregatesAdapter;
import com.ua.sdk.workout.WorkoutTimeSeriesDataAdapter;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class GsonFactory {
    public static Gson newInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(Date.class, new DateAdapter());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        gsonBuilder.registerTypeAdapter(Gender.class, new Gender.GenderAdapter());
        gsonBuilder.registerTypeAdapter(FriendshipStatus.class, new FriendshipStatusAdapter());
        gsonBuilder.registerTypeAdapter(MeasurementSystem.class, new MeasurementSystem.MeasurementSystemAdapter());
        gsonBuilder.registerTypeAdapter(Attachment.class, new AttachmentAdapter());
        return gsonBuilder.create();
    }

    public static Gson newFilemobileCredentialInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(Date.class, new DateAdapter());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        gsonBuilder.registerTypeAdapter(FilemobileCredential.class, new FilemobileCredentialAdapter());
        return gsonBuilder.create();
    }

    public static Gson newActivityStoryInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(Date.class, new DateAdapter());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        gsonBuilder.registerTypeAdapter(Gender.class, new Gender.GenderAdapter());
        gsonBuilder.registerTypeAdapter(FriendshipStatus.class, new FriendshipStatusAdapter());
        gsonBuilder.registerTypeAdapter(MeasurementSystem.class, new MeasurementSystem.MeasurementSystemAdapter());
        gsonBuilder.registerTypeAdapter(ActivityStory.class, new ActivityStoryAdapter());
        gsonBuilder.registerTypeAdapter(ActivityStoryTarget.class, new ActivityStoryTargetAdapter());
        gsonBuilder.registerTypeAdapter(ActivityStoryActor.class, new ActivityStoryActorAdapter());
        gsonBuilder.registerTypeAdapter(ActivityStoryVerb.class, new ActivityStoryVerbAdapter());
        gsonBuilder.registerTypeAdapter(ActivityStoryObject.class, new ActivityStoryObjectAdapter());
        gsonBuilder.registerTypeAdapter(ActivityStoryHighlight.class, new ActivityStoryHighlightAdapter());
        gsonBuilder.registerTypeAdapter(ActivityStoryTemplate.class, new ActivityStoryTemplateAdapter());
        gsonBuilder.registerTypeAdapter(Privacy.class, new PrivacyAdapter());
        gsonBuilder.registerTypeAdapter(Location.class, new LocationAdapter());
        gsonBuilder.registerTypeAdapter(Attachment.class, new AttachmentAdapter());
        gsonBuilder.registerTypeAdapter(Source.class, new SourceAdapter());
        gsonBuilder.registerTypeAdapter(GroupLeaderboard.class, new GroupLeaderboardAdapter());
        gsonBuilder.registerTypeAdapter(Period.class, new Period.PeriodAdapter());
        gsonBuilder.registerTypeAdapter(ActivityStoryGroupLeaderboard.class, new ActivityStoryGroupLeaderboardAdapter());
        gsonBuilder.registerTypeAdapter(Criteria.class, new CriteriaGsonAdapter());
        return gsonBuilder.create();
    }

    public static Gson newSuggestedFriendsInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(Date.class, new DateAdapter());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        gsonBuilder.registerTypeAdapter(SuggestedFriends.class, new SuggestedFriendsAdapter());
        return gsonBuilder.create();
    }

    public static Gson newPageAssociationInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(PageAssociation.class, new PageAssociationAdapter());
        return gsonBuilder.create();
    }

    public static Gson newActivityTimeSeriesInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(ActivityTimeSeriesImpl.TimeSeries.class, new ActivityTimeSeriesTypeAdapter());
        return gsonBuilder.create();
    }

    public static Gson newUserStatsInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        gsonBuilder.registerTypeAdapter(UserStats.class, new UserStatsAdapter());
        gsonBuilder.registerTypeAdapter(AggregatePeriod.class, new AggregatePeriodAdapter());
        gsonBuilder.registerTypeAdapter(HeartRateTimesAggregate.class, new HeartRateTimesAggregatesAdapter());
        gsonBuilder.registerTypeAdapter(Stats.class, new StatsAdapter());
        return gsonBuilder.create();
    }

    public static Gson newGearInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(Gear.class, new GearAdapter());
        gsonBuilder.registerTypeAdapter(GearBrand.class, new GearBrandAdapter());
        gsonBuilder.registerTypeAdapter(UserGear.class, new UserGearAdapter());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        return gsonBuilder.create();
    }

    public static Gson newSleepInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(Date.class, new DateAdapter());
        gsonBuilder.registerTypeAdapter(SleepMetricImpl.TimeSeries.class, new SleepTimeSeriesTypeAdapter());
        gsonBuilder.registerTypeAdapter(SleepMetric.class, new SleepMetricAdapter());
        gsonBuilder.registerTypeAdapter(TimeZone.class, new TimeZoneTypeAdapter());
        return gsonBuilder.create();
    }

    public static Gson newActivityTypeInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(ActivityType.class, new ActivityTypeAdapter());
        return gsonBuilder.create();
    }

    public static Gson newWorkoutInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(TimeZone.class, new TimeZoneTypeAdapter());
        gsonBuilder.registerTypeAdapter(Date.class, new DateAdapter());
        gsonBuilder.registerTypeAdapter(Privacy.class, new PrivacyAdapter());
        gsonBuilder.registerTypeAdapter(Workout.class, new WorkoutAdapter());
        gsonBuilder.registerTypeAdapter(TimeSeriesData.class, new WorkoutTimeSeriesDataAdapter());
        gsonBuilder.registerTypeAdapter(WorkoutAggregates.class, new WorkoutAggregatesAdapter());
        gsonBuilder.registerTypeAdapter(Attachment.class, new AttachmentAdapter());
        return gsonBuilder.create();
    }

    public static Gson newModerationInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(ModerationAction.class, new ModerationActionAdapter());
        return gsonBuilder.create();
    }

    public static Gson newGroupInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(Aggregate.class, new AggregateAdapter());
        gsonBuilder.registerTypeAdapter(AggregateSummary.class, new AggregateSummaryAdapter());
        gsonBuilder.registerTypeAdapter(Date.class, new DateAdapter());
        gsonBuilder.registerTypeAdapter(Period.class, new Period.PeriodAdapter());
        gsonBuilder.registerTypeAdapter(Group.class, new GroupAdapter());
        gsonBuilder.registerTypeAdapter(GroupInvite.class, new GroupInviteAdapter());
        gsonBuilder.registerTypeAdapter(GroupUser.class, new GroupUserAdapter());
        gsonBuilder.registerTypeAdapter(GroupPurpose.class, new GroupPurposeAdapter());
        gsonBuilder.registerTypeAdapter(GroupObjective.class, new GroupObjectiveAdapter());
        gsonBuilder.registerTypeAdapter(GroupLeaderboard.class, new GroupLeaderboardAdapter());
        gsonBuilder.registerTypeAdapter(Criteria.class, new CriteriaGsonAdapter());
        return gsonBuilder.create();
    }

    public static Gson newAggregateInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(Date.class, new DateAdapter());
        gsonBuilder.registerTypeAdapter(Period.class, new Period.PeriodAdapter());
        gsonBuilder.registerTypeAdapter(Aggregate.class, new AggregateAdapter());
        gsonBuilder.registerTypeAdapter(AggregateSummary.class, new AggregateSummaryAdapter());
        return gsonBuilder.create();
    }

    public static Gson newBodyMassInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(Date.class, new DateAdapter());
        gsonBuilder.registerTypeAdapter(BodyMass.class, new BodyMassAdapter());
        return gsonBuilder.create();
    }

    public static Gson newRecorderConfigurationInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(BluetoothSensorDataSourceConfiguration.class, new BluetoothSensorDataSourceAdapter());
        gsonBuilder.registerTypeAdapter(LocationSensorDataSourceConfiguration.class, new LocationSensorDataSourceAdapter());
        gsonBuilder.registerTypeAdapter(DerivedDataSourceConfiguration.class, new DerivedDataSourceConfigurationAdapter());
        gsonBuilder.registerTypeAdapter(DataSourceIdentifier.class, new DataSourceIdentifierAdapter());
        gsonBuilder.registerTypeAdapter(Device.class, new DeviceAdapter());
        return gsonBuilder.create();
    }

    public static Gson newHeartRateInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(8, 128);
        gsonBuilder.registerTypeAdapter(HeartRateZones.class, new HeartRateZonesGsonAdapter());
        return gsonBuilder.create();
    }
}
