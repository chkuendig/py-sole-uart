package com.dyaco.sole.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.dyaco.sole.custom.Global;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class UserDataDB {
    public static String TAG = "UserDataDB";
    private SQLiteDatabase db;
    private BaseDB dbHelper;

    public UserDataDB(Context context) {
        BaseDB baseDB = new BaseDB(context);
        this.dbHelper = baseDB;
        this.db = baseDB.getReadableDatabase();
    }

    public void close() {
        this.db.close();
        this.dbHelper.close();
    }

    public boolean checkExistence(String str) {
        Cursor cursorQuery = this.db.query("user", null, "name = ? ", new String[]{str}, null, null, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        boolean zMoveToFirst = cursorQuery.moveToFirst();
        cursorQuery.close();
        Log.d("UserDataDB", "checkExistence = " + str + " , isExist = " + zMoveToFirst);
        return zMoveToFirst;
    }

    public ArrayList<UserData> getAllUserData() {
        ArrayList<UserData> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.db.query("user", null, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            UserData userData = new UserData();
            userData.setName(cursorQuery.getString(0));
            userData.setAge(cursorQuery.getInt(1));
            userData.setWeight(cursorQuery.getInt(2));
            userData.setGender(cursorQuery.getInt(3));
            userData.setGoals(cursorQuery.getString(4));
            userData.setNotes(cursorQuery.getString(5));
            arrayList.add(userData);
            Log.d("UserDataDB", "getAllUserData = " + cursorQuery.getString(0));
            cursorQuery.moveToNext();
        }
        cursorQuery.close();
        return arrayList;
    }

    public boolean saveUserData(UserData userData) {
        String name = userData.getName();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put(UserData.AGE, Integer.valueOf(userData.getAge()));
        contentValues.put(UserData.WEIGHT, Integer.valueOf(userData.getWeight()));
        contentValues.put(UserData.GENDER, Integer.valueOf(userData.getGender()));
        contentValues.put("goals", userData.getGoals());
        contentValues.put("notes", userData.getNotes());
        Log.d(TAG, "saveUserData = " + name);
        long jInsert = this.db.insert("user", null, contentValues);
        Global.printLog("d", "UserDataDB  saveUserData", jInsert + "");
        return jInsert != -1;
    }

    public boolean updateUserData(UserData userData) {
        String name = userData.getName();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put(UserData.AGE, Integer.valueOf(userData.getAge()));
        contentValues.put(UserData.WEIGHT, Integer.valueOf(userData.getWeight()));
        contentValues.put(UserData.GENDER, Integer.valueOf(userData.getGender()));
        contentValues.put("goals", userData.getGoals());
        contentValues.put("notes", userData.getNotes());
        Log.d(TAG, "updateUserData() UserData.NAME : " + name);
        Log.d(TAG, "updateUserData() UserData.AGE : " + userData.getAge());
        Log.d(TAG, "updateUserData() UserData.WEIGHT : " + userData.getWeight());
        Log.d(TAG, "updateUserData() UserData.GENDER : " + userData.getGender());
        Log.d(TAG, "updateUserData() UserData.GOALS : " + userData.getGoals());
        Log.d(TAG, "updateUserData() UserData.NOTES : " + userData.getNotes());
        long jUpdate = (long) this.db.update("user", contentValues, "name = ?", new String[]{Global.userName});
        Global.printLog("d", "UserDataDB  updateUserData", jUpdate + "");
        return jUpdate != -1;
    }

    public UserData getUserData(String str) {
        Cursor cursorQuery = this.db.query("user", null, "name = ? ", new String[]{str}, null, null, null);
        cursorQuery.moveToFirst();
        if (cursorQuery.isAfterLast()) {
            return null;
        }
        UserData userData = new UserData();
        userData.setName(cursorQuery.getString(0));
        userData.setAge(cursorQuery.getInt(1));
        userData.setWeight(cursorQuery.getInt(2));
        userData.setGender(cursorQuery.getInt(3));
        userData.setGoals(cursorQuery.getString(4));
        userData.setNotes(cursorQuery.getString(5));
        cursorQuery.close();
        return userData;
    }

    public Integer deleteUserData(String str) {
        return Integer.valueOf(this.db.delete("user", "name = ? ", new String[]{str}));
    }
}
