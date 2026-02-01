package com.dyaco.sole.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes.dex */
public class BaseDB extends SQLiteOpenHelper {
    public static final String DB_NAME = "SOLEDB";
    protected static final int DB_VERSION = 1;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public BaseDB(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        createUserDB(sQLiteDatabase);
        createProfileDB(sQLiteDatabase);
        createWorkoutDB(sQLiteDatabase);
        createPostDB(sQLiteDatabase);
    }

    private void createUserDB(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user(name CHAR(50) PRIMARY KEY,age INT,weight INT,gender INT,goals CHAR(100),notes CHAR(100))");
    }

    private void createProfileDB(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS profile(name CHAR(50),profile_id INT,profile_count INT,profile CHAR(100))");
    }

    private void createWorkoutDB(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS workout(name CHAR(50),start_date DATETIME,end_date DATETIME,duration INT,program_name_res INT,device_model_name CHAR(50),distance FLOAT,calories INT,goals TEXT,notes TEXT,avg_hr INT,avg_speed FLOAT,avg_rpm INT,avg_watts INT,avg_level INT,avg_mets FLOAT)");
    }

    private void createPostDB(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS post(post_id INTEGER PRIMARY KEY AUTOINCREMENT,post_type INT,post_data TEXT );");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
    }
}
