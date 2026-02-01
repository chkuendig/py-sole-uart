package com.soletreadmills.sole_v2._roomDataBase.summaryTempData;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class SummaryTempDataDao_Impl implements SummaryTempDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SummaryTempDataEntity> __deletionAdapterOfSummaryTempDataEntity;
    private final EntityInsertionAdapter<SummaryTempDataEntity> __insertionAdapterOfSummaryTempDataEntity;
    private final EntityDeletionOrUpdateAdapter<SummaryTempDataEntity> __updateAdapterOfSummaryTempDataEntity;

    public SummaryTempDataDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSummaryTempDataEntity = new EntityInsertionAdapter<SummaryTempDataEntity>(__db) { // from class: com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `SUMMARY_TEMP_DATA_TABLE` (`summary_ftms_temp_list_data_json`,`ftms_data_class_name`,`id`) VALUES (?,?,nullif(?, 0))";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final SummaryTempDataEntity entity) {
                if (entity.getJsonData() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getJsonData());
                }
                if (entity.getClassName() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getClassName());
                }
                statement.bindLong(3, entity.getId());
            }
        };
        this.__deletionAdapterOfSummaryTempDataEntity = new EntityDeletionOrUpdateAdapter<SummaryTempDataEntity>(__db) { // from class: com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `SUMMARY_TEMP_DATA_TABLE` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final SummaryTempDataEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfSummaryTempDataEntity = new EntityDeletionOrUpdateAdapter<SummaryTempDataEntity>(__db) { // from class: com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `SUMMARY_TEMP_DATA_TABLE` SET `summary_ftms_temp_list_data_json` = ?,`ftms_data_class_name` = ?,`id` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final SummaryTempDataEntity entity) {
                if (entity.getJsonData() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getJsonData());
                }
                if (entity.getClassName() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getClassName());
                }
                statement.bindLong(3, entity.getId());
                statement.bindLong(4, entity.getId());
            }
        };
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao
    public void insert(final SummaryTempDataEntity summaryTempDataEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSummaryTempDataEntity.insert((EntityInsertionAdapter<SummaryTempDataEntity>) summaryTempDataEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao
    public void insertAll(final SummaryTempDataEntity... summaryTempDataEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSummaryTempDataEntity.insert(summaryTempDataEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao
    public void delete(final SummaryTempDataEntity summaryTempDataEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfSummaryTempDataEntity.handle(summaryTempDataEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao
    public void deletes(final SummaryTempDataEntity... summaryTempDataEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfSummaryTempDataEntity.handleMultiple(summaryTempDataEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao
    public void update(final SummaryTempDataEntity summaryTempDataEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfSummaryTempDataEntity.handle(summaryTempDataEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao
    public void updates(final SummaryTempDataEntity... summaryTempDataEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfSummaryTempDataEntity.handleMultiple(summaryTempDataEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao
    public List<SummaryTempDataEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM SUMMARY_TEMP_DATA_TABLE", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "summary_ftms_temp_list_data_json");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ftms_data_class_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                SummaryTempDataEntity summaryTempDataEntity = new SummaryTempDataEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                summaryTempDataEntity.setId(cursorQuery.getInt(columnIndexOrThrow3));
                arrayList.add(summaryTempDataEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao
    public SummaryTempDataEntity findById(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM SUMMARY_TEMP_DATA_TABLE WHERE id LIKE ? LIMIT 1", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        SummaryTempDataEntity summaryTempDataEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "summary_ftms_temp_list_data_json");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ftms_data_class_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            if (cursorQuery.moveToFirst()) {
                String string2 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                if (!cursorQuery.isNull(columnIndexOrThrow2)) {
                    string = cursorQuery.getString(columnIndexOrThrow2);
                }
                SummaryTempDataEntity summaryTempDataEntity2 = new SummaryTempDataEntity(string2, string);
                summaryTempDataEntity2.setId(cursorQuery.getInt(columnIndexOrThrow3));
                summaryTempDataEntity = summaryTempDataEntity2;
            }
            return summaryTempDataEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDao
    public List<SummaryTempDataEntity> findClassName(final String className) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM SUMMARY_TEMP_DATA_TABLE WHERE ftms_data_class_name = ?", 1);
        if (className == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, className);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "summary_ftms_temp_list_data_json");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ftms_data_class_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                SummaryTempDataEntity summaryTempDataEntity = new SummaryTempDataEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                summaryTempDataEntity.setId(cursorQuery.getInt(columnIndexOrThrow3));
                arrayList.add(summaryTempDataEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
