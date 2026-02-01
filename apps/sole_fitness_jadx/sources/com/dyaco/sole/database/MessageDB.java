package com.dyaco.sole.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.dyaco.sole.Bean.MessageBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MessageDB {
    public static final String ACCOUNT = "account";
    public static final String CREATE_TABLE = "CREATE TABLE message_db (_id INTEGER PRIMARY KEY AUTOINCREMENT, account TEXT NOT NULL, type TEXT NOT NULL, msg_content TEXT NOT NULL, msg_datetime TEXT NOT NULL)";
    public static final String KEY_ID = "_id";
    public static final String MSG_CONTENT = "msg_content";
    public static final String MSG_DATETIME = "msg_datetime";
    public static final String TABLE_NAME = "message_db";
    public static final String TYPE = "type";
    private SQLiteDatabase db;

    public MessageDB(Context context) {
        this.db = MessageDBHelper.getDatabase(context);
    }

    public void insert(ArrayList<MessageBean> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ACCOUNT, arrayList.get(i).getAccount());
            contentValues.put("type", arrayList.get(i).getType());
            contentValues.put(MSG_CONTENT, arrayList.get(i).getMsg_content());
            contentValues.put(MSG_DATETIME, arrayList.get(i).getMsg_datetime());
            this.db.insert(TABLE_NAME, null, contentValues);
        }
    }

    public boolean insert(MessageBean messageBean) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ACCOUNT, messageBean.getAccount());
        contentValues.put("type", messageBean.getType());
        contentValues.put(MSG_CONTENT, messageBean.getMsg_content());
        contentValues.put(MSG_DATETIME, messageBean.getMsg_datetime());
        return this.db.insert(TABLE_NAME, null, contentValues) > 0;
    }

    public boolean delete(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("account='");
        sb.append(str);
        sb.append("'");
        return this.db.delete(TABLE_NAME, sb.toString(), null) > 0;
    }

    public ArrayList<MessageBean> getAll(String str) {
        ArrayList<MessageBean> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.db.query(TABLE_NAME, null, "account='" + str + "'", null, null, null, null, null);
        int i = 0;
        while (cursorQuery.moveToNext()) {
            arrayList.add(i, getRecord(cursorQuery));
            i++;
        }
        cursorQuery.close();
        return arrayList;
    }

    public MessageBean getRecord(Cursor cursor) {
        MessageBean messageBean = new MessageBean();
        messageBean.setAccount(cursor.getString(cursor.getColumnIndex(ACCOUNT)));
        messageBean.setType(cursor.getString(cursor.getColumnIndex("type")));
        messageBean.setMsg_content(cursor.getString(cursor.getColumnIndex(MSG_CONTENT)));
        messageBean.setMsg_datetime(cursor.getString(cursor.getColumnIndex(MSG_DATETIME)));
        return messageBean;
    }
}
