package com.ua.sdk.workout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.AccessToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ua.sdk.UaLog;
import com.ua.sdk.activitystory.SocialSettings;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.cache.database.definition.BooleanColumnDefinition;
import com.ua.sdk.cache.database.definition.ColumnDefinition;
import com.ua.sdk.cache.database.definition.DateColumnDefinition;
import com.ua.sdk.cache.database.definition.DoubleColumnDefinition;
import com.ua.sdk.cache.database.definition.IntegerColumnDefinition;
import com.ua.sdk.cache.database.definition.LocalIdColumnDefinition;
import com.ua.sdk.cache.database.definition.StringColumnDefinition;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.internal.AbstractEntityList;
import com.ua.sdk.internal.Link;
import com.ua.sdk.util.FileUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class WorkoutDatabase extends EntityDatabase<Workout> {
    public static final ColumnDefinition<Double> ACTIVE_TIME_TOTAL;
    private static final ColumnDefinition[] ALL_COLUMNS;
    public static final ColumnDefinition<Integer> CADENCE_AVG;
    public static final ColumnDefinition<Integer> CADENCE_MAX;
    public static final ColumnDefinition<Integer> CADENCE_MIN;
    public static final ColumnDefinition<Date> CREATED_DATETIME;
    public static final ColumnDefinition<Double> DISTANCE_TOTAL;
    public static final ColumnDefinition<Double> ELAPSED_TIME_TOTAL;
    private static final String ENTITY_NAME = "workout";
    public static final ColumnDefinition<Boolean> FACEBOOK;
    public static final ColumnDefinition<Boolean> HAS_TIME_SERIES;
    public static final ColumnDefinition<Integer> HEART_RATE_AVG;
    public static final ColumnDefinition<Integer> HEART_RATE_MAX;
    public static final ColumnDefinition<Integer> HEART_RATE_MIN;
    public static final ColumnDefinition<Boolean> IS_VERIFIED;
    public static final ColumnDefinition<Long> LOCAL_ID;
    public static final ColumnDefinition<Double> METABOLIC_ENERGY_TOTAL;
    public static final ColumnDefinition<String> NAME;
    public static final ColumnDefinition<String> NOTES;
    public static final ColumnDefinition<Double> POWER_AVG;
    public static final ColumnDefinition<Double> POWER_MAX;
    public static final ColumnDefinition<Double> POWER_MIN;
    public static final ColumnDefinition<String> REFERENCE_KEY;
    public static final ColumnDefinition<String> REMOTE_ID;
    public static final ColumnDefinition<String> SOURCE;
    public static final ColumnDefinition<Double> SPEED_AVG;
    public static final ColumnDefinition<Double> SPEED_MAX;
    public static final ColumnDefinition<Double> SPEED_MIN;
    public static final ColumnDefinition<Date> START_DATETIME;
    public static final ColumnDefinition<String> START_LOCALE_TIMEZONE;
    public static final ColumnDefinition<Integer> STEPS_TOTAL;
    public static final ColumnDefinition<Double> TORQUE_AVG;
    public static final ColumnDefinition<Double> TORQUE_MAX;
    public static final ColumnDefinition<Double> TORQUE_MIN;
    public static final ColumnDefinition<Boolean> TWITTER;
    public static final ColumnDefinition<Date> UPDATED_DATETIME;
    public static final ColumnDefinition<Double> WILLPOWER;
    protected static final String WORKOUT_DATABASE_NAME = "uasdk_workout";
    private static final int WORKOUT_DATABASE_VERSION = 2;
    private static final String WORKOUT_DIR_PATH = "workout";
    private static WorkoutTimeSeriesDataAdapter adapter;
    private static WorkoutDatabase instance;

    static {
        LocalIdColumnDefinition localIdColumnDefinition = new LocalIdColumnDefinition(0, "_id");
        LOCAL_ID = localIdColumnDefinition;
        StringColumnDefinition stringColumnDefinition = new StringColumnDefinition(1, EntityDatabase.LIST.COLS.REMOTE_ID);
        REMOTE_ID = stringColumnDefinition;
        StringColumnDefinition stringColumnDefinition2 = new StringColumnDefinition(2, "name");
        NAME = stringColumnDefinition2;
        DateColumnDefinition dateColumnDefinition = new DateColumnDefinition(3, "start_datetime");
        START_DATETIME = dateColumnDefinition;
        StringColumnDefinition stringColumnDefinition3 = new StringColumnDefinition(4, "start_locale_timezone");
        START_LOCALE_TIMEZONE = stringColumnDefinition3;
        DateColumnDefinition dateColumnDefinition2 = new DateColumnDefinition(5, "created_datetime");
        CREATED_DATETIME = dateColumnDefinition2;
        DateColumnDefinition dateColumnDefinition3 = new DateColumnDefinition(6, "updated_datetime");
        UPDATED_DATETIME = dateColumnDefinition3;
        StringColumnDefinition stringColumnDefinition4 = new StringColumnDefinition(7, "reference_key");
        REFERENCE_KEY = stringColumnDefinition4;
        StringColumnDefinition stringColumnDefinition5 = new StringColumnDefinition(8, "source");
        SOURCE = stringColumnDefinition5;
        StringColumnDefinition stringColumnDefinition6 = new StringColumnDefinition(9, "notes");
        NOTES = stringColumnDefinition6;
        DoubleColumnDefinition doubleColumnDefinition = new DoubleColumnDefinition(10, "distance_total");
        DISTANCE_TOTAL = doubleColumnDefinition;
        DoubleColumnDefinition doubleColumnDefinition2 = new DoubleColumnDefinition(11, "metabolic_energy_total");
        METABOLIC_ENERGY_TOTAL = doubleColumnDefinition2;
        DoubleColumnDefinition doubleColumnDefinition3 = new DoubleColumnDefinition(12, "active_time_total");
        ACTIVE_TIME_TOTAL = doubleColumnDefinition3;
        DoubleColumnDefinition doubleColumnDefinition4 = new DoubleColumnDefinition(13, "elapsed_time_total");
        ELAPSED_TIME_TOTAL = doubleColumnDefinition4;
        IntegerColumnDefinition integerColumnDefinition = new IntegerColumnDefinition(14, "steps_total");
        STEPS_TOTAL = integerColumnDefinition;
        IntegerColumnDefinition integerColumnDefinition2 = new IntegerColumnDefinition(15, "heartrate_min");
        HEART_RATE_MIN = integerColumnDefinition2;
        IntegerColumnDefinition integerColumnDefinition3 = new IntegerColumnDefinition(16, "heartrate_max");
        HEART_RATE_MAX = integerColumnDefinition3;
        IntegerColumnDefinition integerColumnDefinition4 = new IntegerColumnDefinition(17, "heartrate_avg");
        HEART_RATE_AVG = integerColumnDefinition4;
        DoubleColumnDefinition doubleColumnDefinition5 = new DoubleColumnDefinition(18, "speed_min");
        SPEED_MIN = doubleColumnDefinition5;
        DoubleColumnDefinition doubleColumnDefinition6 = new DoubleColumnDefinition(19, "speed_max");
        SPEED_MAX = doubleColumnDefinition6;
        DoubleColumnDefinition doubleColumnDefinition7 = new DoubleColumnDefinition(20, "speed_avg");
        SPEED_AVG = doubleColumnDefinition7;
        IntegerColumnDefinition integerColumnDefinition5 = new IntegerColumnDefinition(21, "cadence_min");
        CADENCE_MIN = integerColumnDefinition5;
        IntegerColumnDefinition integerColumnDefinition6 = new IntegerColumnDefinition(22, "cadence_max");
        CADENCE_MAX = integerColumnDefinition6;
        IntegerColumnDefinition integerColumnDefinition7 = new IntegerColumnDefinition(23, "cadence_avg");
        CADENCE_AVG = integerColumnDefinition7;
        DoubleColumnDefinition doubleColumnDefinition8 = new DoubleColumnDefinition(24, "power_min");
        POWER_MIN = doubleColumnDefinition8;
        DoubleColumnDefinition doubleColumnDefinition9 = new DoubleColumnDefinition(25, "power_max");
        POWER_MAX = doubleColumnDefinition9;
        DoubleColumnDefinition doubleColumnDefinition10 = new DoubleColumnDefinition(26, "power_avg");
        POWER_AVG = doubleColumnDefinition10;
        DoubleColumnDefinition doubleColumnDefinition11 = new DoubleColumnDefinition(27, "torque_min");
        TORQUE_MIN = doubleColumnDefinition11;
        DoubleColumnDefinition doubleColumnDefinition12 = new DoubleColumnDefinition(28, "torque_max");
        TORQUE_MAX = doubleColumnDefinition12;
        DoubleColumnDefinition doubleColumnDefinition13 = new DoubleColumnDefinition(29, "torque_avg");
        TORQUE_AVG = doubleColumnDefinition13;
        BooleanColumnDefinition booleanColumnDefinition = new BooleanColumnDefinition(30, "has_time_series");
        HAS_TIME_SERIES = booleanColumnDefinition;
        DoubleColumnDefinition doubleColumnDefinition14 = new DoubleColumnDefinition(31, BaseDataTypes.ID_WILLPOWER);
        WILLPOWER = doubleColumnDefinition14;
        BooleanColumnDefinition booleanColumnDefinition2 = new BooleanColumnDefinition(32, "is_verified");
        IS_VERIFIED = booleanColumnDefinition2;
        BooleanColumnDefinition booleanColumnDefinition3 = new BooleanColumnDefinition(33, AccessToken.DEFAULT_GRAPH_DOMAIN);
        FACEBOOK = booleanColumnDefinition3;
        BooleanColumnDefinition booleanColumnDefinition4 = new BooleanColumnDefinition(34, "twitter");
        TWITTER = booleanColumnDefinition4;
        ALL_COLUMNS = new ColumnDefinition[]{localIdColumnDefinition, stringColumnDefinition, stringColumnDefinition2, dateColumnDefinition, stringColumnDefinition3, dateColumnDefinition2, dateColumnDefinition3, stringColumnDefinition4, stringColumnDefinition5, stringColumnDefinition6, doubleColumnDefinition, doubleColumnDefinition2, doubleColumnDefinition3, doubleColumnDefinition4, integerColumnDefinition, integerColumnDefinition2, integerColumnDefinition3, integerColumnDefinition4, doubleColumnDefinition5, doubleColumnDefinition6, doubleColumnDefinition7, integerColumnDefinition5, integerColumnDefinition6, integerColumnDefinition7, doubleColumnDefinition8, doubleColumnDefinition9, doubleColumnDefinition10, doubleColumnDefinition11, doubleColumnDefinition12, doubleColumnDefinition13, booleanColumnDefinition, doubleColumnDefinition14, booleanColumnDefinition2, booleanColumnDefinition3, booleanColumnDefinition4};
    }

    protected WorkoutDatabase(Context context) {
        super(context, "workout", WORKOUT_DATABASE_NAME, buildColumnNames(ALL_COLUMNS), REMOTE_ID.getColumnName(), 2);
    }

    public static WorkoutDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new WorkoutDatabase(context.getApplicationContext());
        }
        return instance;
    }

    @Override // com.ua.sdk.cache.EntityDatabase
    protected void createEntityTable(SQLiteDatabase sQLiteDatabase) {
        executeSqlScript(sQLiteDatabase, "cache/workout/1_workout_create_table.sql", String.format("Fatal error, unable to initialize entity tables for %s database.", "workout"));
    }

    @Override // com.ua.sdk.cache.EntityDatabase
    public void onEntityUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        if (i == 0) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.mEntityTable);
            createEntityTable(sQLiteDatabase);
        } else if (i != 1) {
            return;
        }
        deleteEntitiesWithNullRemoteId(sQLiteDatabase);
        deleteAllLists(sQLiteDatabase);
    }

    @Override // com.ua.sdk.cache.EntityDatabase
    protected AbstractEntityList<Workout> createEntityList(long j, String str, int i) {
        WorkoutListImpl workoutListImpl = new WorkoutListImpl();
        workoutListImpl.setTotalCount(i);
        workoutListImpl.setLocalId(j);
        workoutListImpl.setLink("self", new Link(str));
        return workoutListImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.cache.EntityDatabase
    public WorkoutImpl getEntityFromCursor(Cursor cursor) {
        WorkoutImpl workoutImpl = new WorkoutImpl();
        workoutImpl.setLocalId(LOCAL_ID.read(cursor).longValue());
        workoutImpl.startTime = START_DATETIME.read(cursor);
        workoutImpl.updateTime = UPDATED_DATETIME.read(cursor);
        workoutImpl.createdTime = CREATED_DATETIME.read(cursor);
        workoutImpl.name = NAME.read(cursor);
        workoutImpl.notes = NOTES.read(cursor);
        workoutImpl.timeZone = TimeZone.getTimeZone(START_LOCALE_TIMEZONE.read(cursor));
        workoutImpl.source = SOURCE.read(cursor);
        workoutImpl.referenceKey = REFERENCE_KEY.read(cursor);
        workoutImpl.hasTimeSeries = HAS_TIME_SERIES.read(cursor);
        WorkoutAggregatesImpl workoutAggregatesImpl = new WorkoutAggregatesImpl();
        workoutAggregatesImpl.heartRateMin = HEART_RATE_MIN.read(cursor);
        workoutAggregatesImpl.heartRateMax = HEART_RATE_MAX.read(cursor);
        workoutAggregatesImpl.heartRateAvg = HEART_RATE_AVG.read(cursor);
        workoutAggregatesImpl.speedMin = SPEED_MIN.read(cursor);
        workoutAggregatesImpl.speedMax = SPEED_MAX.read(cursor);
        workoutAggregatesImpl.speedAvg = SPEED_AVG.read(cursor);
        workoutAggregatesImpl.cadenceMin = CADENCE_MIN.read(cursor);
        workoutAggregatesImpl.cadenceMax = CADENCE_MAX.read(cursor);
        workoutAggregatesImpl.cadenceAvg = CADENCE_AVG.read(cursor);
        workoutAggregatesImpl.powerMin = POWER_MIN.read(cursor);
        workoutAggregatesImpl.powerMax = POWER_MAX.read(cursor);
        workoutAggregatesImpl.powerAvg = POWER_AVG.read(cursor);
        workoutAggregatesImpl.torqueMin = TORQUE_MIN.read(cursor);
        workoutAggregatesImpl.torqueMax = TORQUE_MAX.read(cursor);
        workoutAggregatesImpl.torqueAvg = TORQUE_AVG.read(cursor);
        workoutAggregatesImpl.willPower = WILLPOWER.read(cursor);
        workoutAggregatesImpl.distanceTotal = DISTANCE_TOTAL.read(cursor);
        workoutAggregatesImpl.metabolicEnergyTotal = METABOLIC_ENERGY_TOTAL.read(cursor);
        workoutAggregatesImpl.activeTimeTotal = ACTIVE_TIME_TOTAL.read(cursor);
        workoutAggregatesImpl.elapsedTimeTotal = ELAPSED_TIME_TOTAL.read(cursor);
        workoutAggregatesImpl.stepsTotal = STEPS_TOTAL.read(cursor);
        workoutImpl.workoutAggregates = workoutAggregatesImpl;
        if (workoutImpl.hasTimeSeries != null && workoutImpl.hasTimeSeries.booleanValue()) {
            workoutImpl.timeSeries = fetchTimeSeriesData(workoutImpl.getLocalId());
        }
        Boolean bool = FACEBOOK.read(cursor);
        Boolean bool2 = TWITTER.read(cursor);
        if (bool != null || bool2 != null) {
            SocialSettings socialSettings = new SocialSettings();
            socialSettings.setFacebook(bool);
            socialSettings.setTwitter(bool2);
            workoutImpl.socialSettings = socialSettings;
        }
        return workoutImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.cache.EntityDatabase
    public ContentValues getContentValuesFromEntity(Workout workout) {
        ContentValues contentValues = new ContentValues();
        START_DATETIME.write(workout.getStartTime(), contentValues);
        UPDATED_DATETIME.write(workout.getUpdatedTime(), contentValues);
        CREATED_DATETIME.write(workout.getCreatedTime(), contentValues);
        NAME.write(workout.getName(), contentValues);
        NOTES.write(workout.getNotes(), contentValues);
        START_LOCALE_TIMEZONE.write(workout.getTimeZone().getID(), contentValues);
        SOURCE.write(workout.getSource(), contentValues);
        REFERENCE_KEY.write(workout.getReferenceKey(), contentValues);
        HAS_TIME_SERIES.write(workout.hasTimeSeries(), contentValues);
        WorkoutAggregates aggregates = workout.getAggregates();
        HEART_RATE_MAX.write(aggregates.getHeartRateMax(), contentValues);
        HEART_RATE_MIN.write(aggregates.getHeartRateMin(), contentValues);
        HEART_RATE_AVG.write(aggregates.getHeartRateAvg(), contentValues);
        SPEED_MAX.write(aggregates.getSpeedMax(), contentValues);
        SPEED_MIN.write(aggregates.getSpeedMin(), contentValues);
        SPEED_AVG.write(aggregates.getSpeedAvg(), contentValues);
        CADENCE_MAX.write(aggregates.getCadenceMax(), contentValues);
        CADENCE_MIN.write(aggregates.getCadenceMin(), contentValues);
        CADENCE_AVG.write(aggregates.getCadenceAvg(), contentValues);
        POWER_MAX.write(aggregates.getPowerMax(), contentValues);
        POWER_MIN.write(aggregates.getPowerMin(), contentValues);
        POWER_AVG.write(aggregates.getPowerAvg(), contentValues);
        TORQUE_MAX.write(aggregates.getTorqueMax(), contentValues);
        TORQUE_MIN.write(aggregates.getTorqueMin(), contentValues);
        TORQUE_AVG.write(aggregates.getTorqueAvg(), contentValues);
        WILLPOWER.write(aggregates.getWillPower(), contentValues);
        DISTANCE_TOTAL.write(aggregates.getDistanceTotal(), contentValues);
        METABOLIC_ENERGY_TOTAL.write(aggregates.getMetabolicEnergyTotal(), contentValues);
        ACTIVE_TIME_TOTAL.write(aggregates.getActiveTimeTotal(), contentValues);
        ELAPSED_TIME_TOTAL.write(aggregates.getElapsedTimeTotal(), contentValues);
        STEPS_TOTAL.write(aggregates.getStepsTotal(), contentValues);
        SocialSettings socialSettings = workout.getSocialSettings();
        FACEBOOK.write(socialSettings != null ? socialSettings.getFacebook() : null, contentValues);
        TWITTER.write(socialSettings != null ? socialSettings.getTwitter() : null, contentValues);
        return contentValues;
    }

    private List<Workout> fetchUnsyncedWorkouts(Integer num) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        StringBuilder sb = new StringBuilder("SELECT ");
        int i = 0;
        while (true) {
            ColumnDefinition[] columnDefinitionArr = ALL_COLUMNS;
            if (i >= columnDefinitionArr.length) {
                break;
            }
            sb.append("w.");
            sb.append(columnDefinitionArr[i].getColumnName());
            if (i < columnDefinitionArr.length - 1) {
                sb.append(",");
            }
            sb.append(StringUtils.SPACE);
            i++;
        }
        sb.append("FROM workout_entity w JOIN workout_meta wm ON w._id=wm.entity_id WHERE wm.pending_operation = ? AND wm.entity_list_id IS NULL;");
        Cursor cursorRawQuery = readableDatabase.rawQuery(sb.toString(), new String[]{String.valueOf(num)});
        ArrayList arrayList = new ArrayList();
        while (cursorRawQuery.moveToNext()) {
            WorkoutImpl entityFromCursor = getEntityFromCursor(cursorRawQuery);
            entityFromCursor.setLinkMap(getLinkMap(readableDatabase, "entity_id", cursorRawQuery.getLong(0)));
            arrayList.add(entityFromCursor);
        }
        return arrayList;
    }

    public List<Workout> fetchUnsyncedCreatedWorkouts() {
        return fetchUnsyncedWorkouts(STATE_CREATED);
    }

    private void overwriteWorkoutTimeSeriesJson(long j, Workout workout) throws Throwable {
        OutputStreamWriter outputStreamWriter;
        if (workout.getTimeSeriesData() != null) {
            if (adapter == null) {
                adapter = new WorkoutTimeSeriesDataAdapter();
            }
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                try {
                    outputStreamWriter = new OutputStreamWriter(FileUtil.openFileOutput(this.mContext, "workout", j + ".json"));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            }
            try {
                WorkoutTimeSeriesDataAdapter workoutTimeSeriesDataAdapter = adapter;
                JsonWriter jsonWriter = new JsonWriter(outputStreamWriter);
                WorkoutTimeSeriesImpl workoutTimeSeriesImpl = (WorkoutTimeSeriesImpl) workout.getTimeSeriesData();
                workoutTimeSeriesDataAdapter.write(jsonWriter, workoutTimeSeriesImpl);
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    UaLog.error("Caught exception closing out", (Throwable) e);
                }
            } catch (FileNotFoundException unused3) {
                throw new RuntimeException(String.format("Fatal error! Unable to open file to write JSON for workout with localId=%s.", Long.valueOf(j)));
            } catch (IOException unused4) {
                throw new RuntimeException(String.format("Fatal error! Unable to write JSON for workout with localId=%s.", Long.valueOf(j)));
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                if (outputStreamWriter2 != null) {
                    try {
                        outputStreamWriter2.close();
                    } catch (IOException e2) {
                        UaLog.error("Caught exception closing out", (Throwable) e2);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.cache.EntityDatabase
    public void postSaveEntity(long j, Workout workout) throws Throwable {
        overwriteWorkoutTimeSeriesJson(j, workout);
    }

    @Override // com.ua.sdk.cache.EntityDatabase
    protected void preDeleteEntity(long j) {
        deleteTimeSeriesData(j);
    }

    @Override // com.ua.sdk.cache.EntityDatabase
    protected void preDeleteAll(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = sQLiteDatabase.query(this.mEntityTable, new String[]{"_id"}, null, null, null, null, null);
        ArrayList arrayList = new ArrayList();
        while (cursorQuery.moveToNext()) {
            arrayList.add(Long.valueOf(cursorQuery.getLong(0)));
        }
        cursorQuery.close();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            deleteTimeSeriesData(((Long) it.next()).longValue());
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0083: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:27:0x0083 */
    public TimeSeriesData fetchTimeSeriesData(long j) throws Throwable {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        if (adapter == null) {
            adapter = new WorkoutTimeSeriesDataAdapter();
        }
        InputStreamReader inputStreamReader3 = null;
        try {
            try {
                try {
                    inputStreamReader = new InputStreamReader(FileUtil.openFileInput(this.mContext, "workout", j + ".json"));
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader3 = inputStreamReader2;
                    if (inputStreamReader3 != null) {
                        try {
                            inputStreamReader3.close();
                        } catch (IOException e) {
                            UaLog.error("Caught exception closing in", (Throwable) e);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused) {
                inputStreamReader = null;
            } catch (IOException unused2) {
            }
            try {
                WorkoutTimeSeriesImpl workoutTimeSeriesImpl = adapter.read(new JsonReader(inputStreamReader));
                try {
                    inputStreamReader.close();
                } catch (IOException e2) {
                    UaLog.error("Caught exception closing in", (Throwable) e2);
                }
                return workoutTimeSeriesImpl;
            } catch (FileNotFoundException unused3) {
                UaLog.debug("Didn't find time series for workout with localId=" + j);
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e3) {
                        UaLog.error("Caught exception closing in", (Throwable) e3);
                    }
                }
                return null;
            } catch (IOException unused4) {
                throw new RuntimeException(String.format("Fatal error! Unable to read JSON for workout with localId=" + j, new Object[0]));
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean deleteTimeSeriesData(long j) {
        try {
            return FileUtil.getFile(this.mContext, "workout", j + ".json").delete();
        } catch (FileNotFoundException unused) {
            return false;
        }
    }
}
