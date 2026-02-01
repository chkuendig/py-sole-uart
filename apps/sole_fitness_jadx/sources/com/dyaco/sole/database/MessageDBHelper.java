package com.dyaco.sole.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes.dex */
public class MessageDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "message_db_helper";
    public static final int VERSION = 2;
    private static SQLiteDatabase database;

    public MessageDBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static SQLiteDatabase getDatabase(Context context) {
        SQLiteDatabase sQLiteDatabase = database;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            database = new MessageDBHelper(context, DATABASE_NAME, null, 2).getWritableDatabase();
        }
        return database;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(MessageDB.CREATE_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS message_db");
        onCreate(sQLiteDatabase);
    }
}
