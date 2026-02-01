package com.ua.sdk.activitytype;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.ua.sdk.cache.database.LegacyEntityDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class ActivityTypeDatabase extends LegacyEntityDatabase<ActivityType> {
    private static final String ACTIVITY_DATABASE_NAME = "activity_database";
    private static final int ACTIVITY_DATABASE_VERSION = 4;
    private static final String ACTIVITY_TABLE = "activity";
    private static final String CACHED_TABLE = "activity_types_cached";
    private static final int COL_ACCESSED_DATE_MS = 5;
    private static final int COL_ACTIVITY_ID = 1;
    private static final int COL_HAS_CHILDREN = 6;
    private static final int COL_ID = 0;
    private static final int COL_METS = 7;
    private static final int COL_METS_SPEED = 8;
    private static final int COL_NAME = 2;
    private static final int COL_PARENT_ID = 4;
    private static final int COL_SHORT_NAME = 3;
    private static final String GET_CACHE_QUERY = "SELECT cached, cached_date FROM activity_types_cached WHERE _id = 1";
    private static final String KEY_ACTIVITY_ID = "id";
    private static final String KEY_CACHED = "cached";
    private static final String KEY_CACHED_DATE = "cached_date";
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final int ROW_ID = 1;
    private static ActivityTypeDatabase mInstance;
    private static final String KEY_SHORT_NAME = "short_name";
    private static final String KEY_PARENT_ID = "parent_id";
    private static final String KEY_ACCESSED_DATE_MS = "accessed_date_ms";
    private static final String KEY_HAS_CHILDREN = "has_children";
    private static final String KEY_METS = "mets";
    private static final String KEY_METS_SPEED = "mets_speed";
    private static final String[] COLUMNS = {"_id", "id", "name", KEY_SHORT_NAME, KEY_PARENT_ID, KEY_ACCESSED_DATE_MS, KEY_HAS_CHILDREN, KEY_METS, KEY_METS_SPEED};

    public static ActivityTypeDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ActivityTypeDatabase(context.getApplicationContext());
        }
        return mInstance;
    }

    ActivityTypeDatabase(Context context) {
        super(context, ACTIVITY_DATABASE_NAME, ACTIVITY_TABLE, COLUMNS, "id", 4);
    }

    @Override // com.ua.sdk.cache.database.LegacyEntityDatabase
    public void createEntityTable(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE activity(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,id NUMERIC KEY,parent_id NUMERIC,name TEXT,short_name TEXT,accessed_date_ms NUMERIC,has_children BOOLEAN,mets NUMERIC,mets_speed TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE activity_types_cached(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, cached INTEGER NOT NULL DEFAULT 0, cached_date INTEGER NOT NULL DEFAULT 0)");
    }

    @Override // com.ua.sdk.cache.database.LegacyEntityDatabase
    public void onEntityUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS activity");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS activity_types_cached");
        createEntityTable(sQLiteDatabase);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.cache.database.LegacyEntityDatabase
    public ContentValues getContentValuesFromEntity(ActivityType activityType) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", activityType.getActivityId());
        contentValues.put(KEY_PARENT_ID, activityType.getParentActivityId());
        contentValues.put("name", activityType.getName());
        contentValues.put(KEY_SHORT_NAME, activityType.getShortName());
        contentValues.put(KEY_METS, activityType.getMetsValue());
        contentValues.put(KEY_METS_SPEED, activityType.getMetsSpeed());
        Date accessedDate = activityType.getAccessedDate();
        if (accessedDate != null) {
            contentValues.put(KEY_ACCESSED_DATE_MS, Long.valueOf(accessedDate.getTime()));
        }
        contentValues.put(KEY_HAS_CHILDREN, Integer.valueOf(activityType.hasChildren() ? 1 : 0));
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.cache.database.LegacyEntityDatabase
    public ActivityTypeImpl getEntityFromCursor(Cursor cursor) {
        ActivityTypeImpl activityTypeImpl = new ActivityTypeImpl(cursor.getString(1), cursor.getString(4), cursor.getString(2), cursor.getString(3), Double.valueOf(cursor.getDouble(7)), cursor.getString(8), Boolean.valueOf(cursor.getInt(6) == 1), !cursor.isNull(5) ? new Date(cursor.getLong(5)) : null);
        activityTypeImpl.setLocalId(cursor.getLong(0));
        return activityTypeImpl;
    }

    private Cursor getReadOnlyCacheCursor() {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery(GET_CACHE_QUERY, null);
        if (cursorRawQuery.getCount() == 0) {
            return null;
        }
        return cursorRawQuery;
    }

    protected boolean isAllActivityTypeCacheSet() {
        Cursor readOnlyCacheCursor = getReadOnlyCacheCursor();
        if (readOnlyCacheCursor != null) {
            try {
                readOnlyCacheCursor.moveToNext();
                z = readOnlyCacheCursor.getInt(readOnlyCacheCursor.getColumnIndex(KEY_CACHED)) == 1;
            } finally {
                readOnlyCacheCursor.close();
            }
        }
        return z;
    }

    protected long getCacheAge() {
        Cursor readOnlyCacheCursor = getReadOnlyCacheCursor();
        if (readOnlyCacheCursor == null) {
            return -1L;
        }
        try {
            readOnlyCacheCursor.moveToNext();
            return System.currentTimeMillis() - readOnlyCacheCursor.getLong(readOnlyCacheCursor.getColumnIndex(KEY_CACHED_DATE));
        } finally {
            readOnlyCacheCursor.close();
        }
    }

    protected void setAllActivityTypesCached(boolean z) throws SQLException {
        getWritableDatabase().execSQL("INSERT OR REPLACE INTO activity_types_cached (_id, cached, cached_date) VALUES (1, " + (z ? 1 : 0) + ", " + System.currentTimeMillis() + ')');
        close();
    }

    protected List<ActivityType> getAllActivityTypes() {
        ArrayList arrayList = new ArrayList();
        if (!isAllActivityTypeCacheSet()) {
            return arrayList;
        }
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT _id, id, name, short_name, parent_id, accessed_date_ms, has_children, mets, mets_speed FROM activity ORDER BY _id ASC", null);
            ArrayList arrayList2 = new ArrayList();
            while (cursorRawQuery.moveToNext()) {
                arrayList2.add(getEntityFromCursor(cursorRawQuery));
            }
            setAllLinkMaps(readableDatabase, arrayList2);
            return new ArrayList(arrayList2);
        } finally {
            close();
        }
    }
}
