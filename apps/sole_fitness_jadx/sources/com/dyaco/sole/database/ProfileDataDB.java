package com.dyaco.sole.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.dyaco.sole.custom.Global;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ProfileDataDB {
    private SQLiteDatabase db;
    private BaseDB dbHelper;
    private int profileCount = 0;

    public ProfileDataDB(Context context) {
        BaseDB baseDB = new BaseDB(context);
        this.dbHelper = baseDB;
        this.db = baseDB.getReadableDatabase();
        initProfileData();
    }

    public void close() {
        this.db.close();
        this.dbHelper.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initProfileData() {
        int profileDataSize = getProfileDataSize();
        this.profileCount = profileDataSize;
        if (profileDataSize != 0 || Global.userName.equals("")) {
            return;
        }
        String[] strArr = new String[2];
        int i = Global.BRAND;
        if (i == 0) {
            strArr[0] = "1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1";
            strArr[1] = "1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1";
        } else if (i == 1) {
            strArr[0] = "1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1";
            strArr[1] = "1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1";
        } else if (i == 2 || i == 3) {
        }
        int i2 = 1;
        for (int i3 = 0; i3 < 2; i3++) {
            String str = strArr[i3];
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", Global.userName);
            contentValues.put(ProfileData.PROFILE_ID, Integer.valueOf(i2));
            contentValues.put(ProfileData.PROFILE_COUNT, Integer.valueOf(str.split(",").length));
            contentValues.put("profile", str);
            Global.printLog("d", "ProfileDataDB", "initProfileData uid = " + this.db.insert("profile", null, contentValues));
            i2++;
        }
        this.profileCount = getProfileDataSize();
    }

    public boolean updateProfileData(int i, ArrayList<Integer> arrayList) {
        ContentValues contentValues = new ContentValues();
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((it.next().intValue() + 1) + ",");
        }
        String strSubstring = sb.substring(0, sb.length() - 1);
        contentValues.put(ProfileData.PROFILE_COUNT, Integer.valueOf(strSubstring.split(",").length));
        contentValues.put("profile", strSubstring);
        long jUpdate = this.db.update("profile", contentValues, "name = ? AND profile_id = ?", new String[]{Global.userName, String.valueOf(i)});
        Global.printLog("d", "ProfileDataDB  updateProfileData", jUpdate + "");
        return jUpdate != -1;
    }

    public int getProfileDataSize() {
        Cursor cursorQuery = this.db.query("profile", null, "name = ? ", new String[]{Global.userName}, null, null, null);
        int count = cursorQuery.getCount();
        cursorQuery.close();
        return count;
    }

    public int[] getProfileData(int i, int i2) {
        Cursor cursorQuery = this.db.query("profile", null, "name = ? AND profile_id = ?", new String[]{Global.userName, String.valueOf(i)}, null, null, null);
        Log.e("ProfileDataDB", "getProfileData--->Global.userName = " + Global.userName + " , profileId = " + i + " , profileCount = " + i2);
        cursorQuery.moveToFirst();
        int[] iArr = null;
        if (!cursorQuery.isAfterLast() && i2 == cursorQuery.getInt(2)) {
            try {
                String[] strArrSplit = cursorQuery.getString(3).split(",");
                int length = strArrSplit.length;
                iArr = new int[length];
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = Integer.parseInt(strArrSplit[i3]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cursorQuery.close();
        return iArr;
    }
}
