package com.ua.oss.de.greenrobot.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.ua.sdk.UaLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class DbUtils {
    public static void vacuum(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("VACUUM");
    }

    public static int executeSqlScript(Context context, SQLiteDatabase sQLiteDatabase, String str, String str2) throws IOException {
        return executeSqlScript(context, sQLiteDatabase, str, str2, true);
    }

    public static int executeSqlScript(Context context, SQLiteDatabase sQLiteDatabase, String str, String str2, boolean z) throws IOException, SQLException {
        int iExecuteSqlStatements;
        String str3 = new String(readAsset(context, str2), "UTF-8");
        if (str != null) {
            str3 = str3.replace("<ENTITY>", str);
        }
        String[] strArrSplit = str3.split(";(\\s)*[\n\r]");
        if (z) {
            iExecuteSqlStatements = executeSqlStatementsInTx(sQLiteDatabase, strArrSplit);
        } else {
            iExecuteSqlStatements = executeSqlStatements(sQLiteDatabase, strArrSplit);
        }
        UaLog.info("Executed " + iExecuteSqlStatements + " statements from SQL script '" + str2 + "'");
        return iExecuteSqlStatements;
    }

    public static int executeSqlStatementsInTx(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        sQLiteDatabase.beginTransaction();
        try {
            int iExecuteSqlStatements = executeSqlStatements(sQLiteDatabase, strArr);
            sQLiteDatabase.setTransactionSuccessful();
            return iExecuteSqlStatements;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static int executeSqlStatements(SQLiteDatabase sQLiteDatabase, String[] strArr) throws SQLException {
        int i = 0;
        for (String str : strArr) {
            String strTrim = str.trim();
            if (strTrim.length() > 0) {
                sQLiteDatabase.execSQL(strTrim);
                i++;
            }
        }
        return i;
    }

    public static int copyAllBytes(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        int i = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return i;
            }
            outputStream.write(bArr, 0, i2);
            i += i2;
        }
    }

    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyAllBytes(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] readAsset(Context context, String str) throws IOException {
        InputStream inputStreamOpen = context.getResources().getAssets().open(str);
        try {
            return readAllBytes(inputStreamOpen);
        } finally {
            inputStreamOpen.close();
        }
    }

    public static void logTableDump(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query(str, null, null, null, null, null, null);
        try {
            UaLog.debug(DatabaseUtils.dumpCursorToString(cursorQuery));
        } finally {
            cursorQuery.close();
        }
    }
}
