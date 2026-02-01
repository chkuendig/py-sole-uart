package com.ua.sdk.recorder.persistence;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ua.sdk.UaLog;
import com.ua.sdk.cache.database.definition.ColumnDefinition;
import com.ua.sdk.recorder.DataSourceConfigurationList;
import com.ua.sdk.recorder.RecorderConfiguration;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class RecorderConfigurationDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "record_configuration";
    public static final String DB_TABLE = "recorders";
    private static final int DB_VERSION = 1;
    private static RecorderConfigurationDatabase instance;

    public static RecorderConfigurationDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new RecorderConfigurationDatabase(context);
        }
        return instance;
    }

    public RecorderConfigurationDatabase(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(buildCreateStatement(DB_TABLE, RecorderConfigurationDatabaseMapper.COLUMNS));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS recorders");
        onCreate(sQLiteDatabase);
    }

    public static String buildCreateStatement(String str, ColumnDefinition[] columnDefinitionArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append(" (");
        int i = 0;
        while (i < columnDefinitionArr.length) {
            ColumnDefinition columnDefinition = columnDefinitionArr[i];
            sb.append(columnDefinition.getColumnName());
            sb.append(StringUtils.SPACE);
            sb.append(columnDefinition.getDbType());
            i++;
            if (i < columnDefinitionArr.length) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static String[] buildColumnNames(ColumnDefinition[] columnDefinitionArr) {
        String[] strArr = new String[columnDefinitionArr.length];
        for (int i = 0; i < columnDefinitionArr.length; i++) {
            strArr[i] = columnDefinitionArr[i].getColumnName();
        }
        return strArr;
    }

    private static void endTransaction(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            UaLog.error("Failed to end transaction.", th);
        }
    }

    public void insert(String str, String str2, String str3, Date date, Date date2, DataSourceConfigurationList dataSourceConfigurationList) {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insertOrThrow(DB_TABLE, "_id", RecorderConfigurationDatabaseMapper.getContentValues(str, str2, str3, date, date2, dataSourceConfigurationList));
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase == null) {
                }
            } catch (Throwable th) {
                th = th;
                try {
                    UaLog.error("Unable to insert row into table", th);
                } finally {
                    if (writableDatabase != null) {
                        endTransaction(writableDatabase);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            writableDatabase = null;
        }
    }

    public void delete(String str) {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                if (str != null && writableDatabase.delete(DB_TABLE, "name = ?", new String[]{str}) == 0) {
                    UaLog.info("Failed to delete recorder with name " + str);
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase == null) {
                }
            } catch (Throwable th) {
                th = th;
                try {
                    UaLog.error("Unable to delete row", th);
                } finally {
                    if (writableDatabase != null) {
                        endTransaction(writableDatabase);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            writableDatabase = null;
        }
    }

    public void update(String str, Date date, DataSourceConfigurationList dataSourceConfigurationList) {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                if (str != null && date != null) {
                    writableDatabase.update(DB_TABLE, RecorderConfigurationDatabaseMapper.getUpdateValues(date, dataSourceConfigurationList), "name = ?", new String[]{str});
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase == null) {
                }
            } catch (Throwable th) {
                th = th;
                try {
                    UaLog.error("Unable to update entry", th);
                } finally {
                    if (writableDatabase != null) {
                        writableDatabase.endTransaction();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            writableDatabase = null;
        }
    }

    public List<RecorderConfiguration> getAllEntries(String str) {
        return RecorderConfigurationDatabaseMapper.getCachedConfigurations(getReadableDatabase().query(DB_TABLE, buildColumnNames(RecorderConfigurationDatabaseMapper.COLUMNS), "user_id = ?", new String[]{str}, null, null, null));
    }

    public RecorderConfiguration get(String str, String str2) {
        return RecorderConfigurationDatabaseMapper.getCachedConfigurations(getReadableDatabase().query(DB_TABLE, buildColumnNames(RecorderConfigurationDatabaseMapper.COLUMNS), "user_id = ? AND name = ?", new String[]{str, str2}, null, null, null)).get(0);
    }
}
