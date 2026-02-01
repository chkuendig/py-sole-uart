package com.dyaco.sole.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.dyaco.sole.custom.Global;
import com.facebook.appevents.AppEventsConstants;
import com.soletreadmills.sole.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class WorkoutDataDB {
    private Context context;
    private SQLiteDatabase db;
    private BaseDB dbHelper;

    public WorkoutDataDB(Context context) {
        this.context = context;
        BaseDB baseDB = new BaseDB(context);
        this.dbHelper = baseDB;
        this.db = baseDB.getReadableDatabase();
    }

    public void close() {
        this.db.close();
        this.dbHelper.close();
    }

    public boolean checkExistence(String str) {
        Cursor cursorQuery = this.db.query("workout", null, "start_date = ? ", new String[]{String.valueOf(str)}, null, null, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        boolean zMoveToFirst = cursorQuery.moveToFirst();
        cursorQuery.close();
        return zMoveToFirst;
    }

    public ArrayList<WorkoutData> getRangeOfDateData(String str, String str2, String str3, String str4) {
        String str5;
        ArrayList<WorkoutData> arrayList = new ArrayList<>();
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = "start_date " + str4;
        }
        SQLiteDatabase sQLiteDatabase = this.db;
        String str6 = ("name = '" + str + "' AND ") + "start_date BETWEEN ? AND ?";
        Cursor cursorQuery = sQLiteDatabase.query("workout", null, str6, new String[]{str2 + " 00:00:00", str3 + " 23:59:59"}, null, null, str5, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            WorkoutData workoutData = new WorkoutData();
            workoutData.setStartDate(cursorQuery.getString(cursorQuery.getColumnIndex("start_date")));
            workoutData.setEndDate(cursorQuery.getString(cursorQuery.getColumnIndex("end_date")));
            workoutData.setDuration(cursorQuery.getInt(cursorQuery.getColumnIndex("duration")));
            workoutData.setProgramNameRes(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.PROGRAM_NAME_RES)));
            workoutData.setDeviceModelName(cursorQuery.getString(cursorQuery.getColumnIndex(WorkoutData.DEVICE_MODEL_NAME)));
            workoutData.setDistance(cursorQuery.getFloat(cursorQuery.getColumnIndex("distance")));
            workoutData.setCalories(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.CALORIES)));
            workoutData.setGoals(cursorQuery.getString(cursorQuery.getColumnIndex("goals")));
            workoutData.setNotes(cursorQuery.getString(cursorQuery.getColumnIndex("notes")));
            workoutData.setAvgHR(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.AVG_HR)));
            workoutData.setAvgSpeed(cursorQuery.getFloat(cursorQuery.getColumnIndex(WorkoutData.AVG_SPEED)));
            workoutData.setAvgRPM(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.AVG_RPM)));
            workoutData.setAvgWatts(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.AVG_WATTS)));
            workoutData.setAvgLevel(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.AVG_LEVEL)));
            workoutData.setAvgMETs(cursorQuery.getFloat(cursorQuery.getColumnIndex(WorkoutData.AVG_METS)));
            arrayList.add(workoutData);
            cursorQuery.moveToNext();
        }
        cursorQuery.close();
        return arrayList;
    }

    public ArrayList<WorkoutData> getRangeOfDateAvgData(String str, String str2, String str3) {
        String str4;
        String[] strArr;
        ArrayList<WorkoutData> arrayList = new ArrayList<>();
        Log.d("WorkoutDataDB", "getRangeOfDateAvgData  startDate = " + str2 + " endDate = " + str3);
        if (str2 == null || str3 == null) {
            str4 = "name = '" + str + "'";
            strArr = null;
        } else {
            str4 = "name = '" + str + "' AND start_date BETWEEN ? AND ?";
            strArr = new String[]{str2 + " 00:00:00", str3 + " 23:59:59"};
        }
        String str5 = "start_date";
        Cursor cursorQuery = this.db.query("workout", new String[]{"name", "start_date", "end_date", "SUM(duration)", WorkoutData.PROGRAM_NAME_RES, WorkoutData.DEVICE_MODEL_NAME, "SUM(distance)", "SUM(calories)", "goals", "notes", "AVG(avg_hr)", "AVG(avg_speed)", "AVG(avg_rpm)", "AVG(avg_watts)", "AVG(avg_level)", "AVG(avg_mets)"}, str4, strArr, null, null, null, null);
        Log.d("WorkoutDataDB", "getRangeOfDateAvgData-------getCount = " + cursorQuery.getCount());
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            String str6 = str5;
            if (cursorQuery.getString(cursorQuery.getColumnIndex(str6)) == null) {
                cursorQuery.moveToNext();
            } else {
                WorkoutData workoutData = new WorkoutData();
                workoutData.setStartDate(cursorQuery.getString(cursorQuery.getColumnIndex(str6)));
                workoutData.setEndDate(cursorQuery.getString(cursorQuery.getColumnIndex("end_date")));
                workoutData.setDuration(cursorQuery.getInt(cursorQuery.getColumnIndex("SUM(duration)")));
                workoutData.setProgramNameRes(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.PROGRAM_NAME_RES)));
                workoutData.setDeviceModelName(cursorQuery.getString(cursorQuery.getColumnIndex(WorkoutData.DEVICE_MODEL_NAME)));
                workoutData.setDistance(cursorQuery.getFloat(cursorQuery.getColumnIndex("SUM(distance)")));
                workoutData.setCalories(cursorQuery.getInt(cursorQuery.getColumnIndex("SUM(calories)")));
                workoutData.setGoals(cursorQuery.getString(cursorQuery.getColumnIndex("goals")));
                workoutData.setNotes(cursorQuery.getString(cursorQuery.getColumnIndex("notes")));
                workoutData.setAvgHR(cursorQuery.getInt(cursorQuery.getColumnIndex("AVG(avg_hr)")));
                workoutData.setAvgSpeed(cursorQuery.getFloat(cursorQuery.getColumnIndex("AVG(avg_speed)")));
                workoutData.setAvgRPM(cursorQuery.getInt(cursorQuery.getColumnIndex("AVG(avg_rpm)")));
                workoutData.setAvgWatts(cursorQuery.getInt(cursorQuery.getColumnIndex("AVG(avg_watts)")));
                workoutData.setAvgLevel(cursorQuery.getInt(cursorQuery.getColumnIndex("AVG(avg_level)")));
                workoutData.setAvgMETs(cursorQuery.getFloat(cursorQuery.getColumnIndex("AVG(avg_mets)")));
                arrayList.add(workoutData);
                Log.d("WorkoutDataDB", "GET DATE -------" + cursorQuery.getString(cursorQuery.getColumnIndex(str6)));
                cursorQuery.moveToNext();
            }
            str5 = str6;
        }
        cursorQuery.close();
        return arrayList;
    }

    public ArrayList<WorkoutData> getAllAvgData(String str) {
        return getRangeOfDateAvgData(str, null, null);
    }

    public ArrayList<WorkoutData> getAllDateData(String str) {
        ArrayList<WorkoutData> arrayList = new ArrayList<>();
        String str2 = "";
        if (!str.equals("")) {
            str2 = "name = '" + str + "'";
        }
        Cursor cursorQuery = this.db.query("workout", null, str2, null, null, null, "start_date DESC", null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            WorkoutData workoutData = new WorkoutData();
            workoutData.setStartDate(cursorQuery.getString(cursorQuery.getColumnIndex("start_date")));
            workoutData.setEndDate(cursorQuery.getString(cursorQuery.getColumnIndex("end_date")));
            workoutData.setDuration(cursorQuery.getInt(cursorQuery.getColumnIndex("duration")));
            workoutData.setProgramNameRes(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.PROGRAM_NAME_RES)));
            workoutData.setDeviceModelName(cursorQuery.getString(cursorQuery.getColumnIndex(WorkoutData.DEVICE_MODEL_NAME)));
            workoutData.setDistance(cursorQuery.getFloat(cursorQuery.getColumnIndex("distance")));
            workoutData.setCalories(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.CALORIES)));
            workoutData.setGoals(cursorQuery.getString(cursorQuery.getColumnIndex("goals")));
            workoutData.setNotes(cursorQuery.getString(cursorQuery.getColumnIndex("notes")));
            workoutData.setAvgHR(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.AVG_HR)));
            workoutData.setAvgSpeed(cursorQuery.getFloat(cursorQuery.getColumnIndex(WorkoutData.AVG_SPEED)));
            workoutData.setAvgRPM(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.AVG_RPM)));
            workoutData.setAvgWatts(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.AVG_WATTS)));
            workoutData.setAvgLevel(cursorQuery.getInt(cursorQuery.getColumnIndex(WorkoutData.AVG_LEVEL)));
            workoutData.setAvgMETs(cursorQuery.getFloat(cursorQuery.getColumnIndex(WorkoutData.AVG_METS)));
            arrayList.add(workoutData);
            cursorQuery.moveToNext();
        }
        cursorQuery.close();
        return arrayList;
    }

    public boolean insertWorkoutData(WorkoutData workoutData) throws Resources.NotFoundException {
        ContentValues contentValues = new ContentValues();
        String name = workoutData.getName();
        if (name == null || name.equals("")) {
            name = this.context.getResources().getString(R.string.guest);
        }
        contentValues.put("name", name);
        contentValues.put("start_date", workoutData.getStartDate());
        contentValues.put("end_date", workoutData.getEndDate());
        contentValues.put("duration", Integer.valueOf(workoutData.getDuration()));
        contentValues.put(WorkoutData.PROGRAM_NAME_RES, Integer.valueOf(workoutData.getProgramNameRes()));
        contentValues.put(WorkoutData.DEVICE_MODEL_NAME, workoutData.getDeviceModelName());
        contentValues.put("distance", Float.valueOf(workoutData.getDistance()));
        contentValues.put(WorkoutData.CALORIES, Integer.valueOf(workoutData.getCalories()));
        contentValues.put("goals", workoutData.getGoals());
        contentValues.put("notes", workoutData.getNotes());
        contentValues.put(WorkoutData.AVG_HR, Integer.valueOf(workoutData.getAvgHR()));
        contentValues.put(WorkoutData.AVG_SPEED, Float.valueOf(workoutData.getAvgSpeed()));
        contentValues.put(WorkoutData.AVG_RPM, Integer.valueOf(workoutData.getAvgRPM()));
        contentValues.put(WorkoutData.AVG_WATTS, Integer.valueOf(workoutData.getAvgWatts()));
        contentValues.put(WorkoutData.AVG_LEVEL, Integer.valueOf(workoutData.getAvgLevel()));
        contentValues.put(WorkoutData.AVG_METS, Float.valueOf(workoutData.getAvgMETs()));
        long jInsert = this.db.insert("workout", null, contentValues);
        Global.printLog("d", "WorkoutDataDB  insertWorkoutData", jInsert + "");
        return jInsert != -1;
    }

    public Integer deleteWorkoutData(String str) {
        return Integer.valueOf(this.db.delete("workout", "start_date = ? ", new String[]{str}));
    }
}
