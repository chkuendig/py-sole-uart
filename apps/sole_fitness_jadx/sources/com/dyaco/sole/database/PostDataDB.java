package com.dyaco.sole.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PostDataDB {
    private SQLiteDatabase db;
    private BaseDB dbHelper;

    public PostDataDB(Context context) {
        BaseDB baseDB = new BaseDB(context);
        this.dbHelper = baseDB;
        this.db = baseDB.getReadableDatabase();
    }

    public void close() {
        this.db.close();
        this.dbHelper.close();
    }

    public void insertPostData(int i, String str) {
        ContentValues contentValues = new ContentValues();
        Log.d("PostDB", "insertPostData  jsonStr = " + str);
        contentValues.put(PostData.POST_TYPE, Integer.valueOf(i));
        contentValues.put(PostData.POST_DATA, str);
        this.db.insert(PostData.POST_TB_NAME, null, contentValues);
        contentValues.clear();
    }

    public ArrayList<PostData> getAllPostData() {
        Cursor cursorQuery = this.db.query(PostData.POST_TB_NAME, null, null, null, null, null, "post_id DESC", null);
        ArrayList<PostData> arrayList = new ArrayList<>();
        PostData postData = new PostData();
        for (int i = 0; i < cursorQuery.getCount(); i++) {
            cursorQuery.moveToPosition(i);
            postData.setPostId(cursorQuery.getInt(cursorQuery.getColumnIndex("post_id")));
            postData.setPostType(cursorQuery.getInt(cursorQuery.getColumnIndex(PostData.POST_TYPE)));
            postData.setPostData(cursorQuery.getString(cursorQuery.getColumnIndex(PostData.POST_DATA)));
        }
        return arrayList;
    }

    public boolean isDataExist(String str) {
        Cursor cursorQuery = this.db.query(PostData.POST_TB_NAME, null, "post_id = " + str, null, null, null, null, null);
        if (cursorQuery.moveToFirst()) {
            cursorQuery.close();
            return true;
        }
        cursorQuery.close();
        return false;
    }

    public void deletePostData(String str) {
        this.db.delete(PostData.POST_TB_NAME, "post_id = " + str, null);
    }
}
