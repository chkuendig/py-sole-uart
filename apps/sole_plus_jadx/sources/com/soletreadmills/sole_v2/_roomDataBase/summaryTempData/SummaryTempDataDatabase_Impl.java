package com.soletreadmills.sole_v2._roomDataBase.summaryTempData;

import android.database.SQLException;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class SummaryTempDataDatabase_Impl extends SummaryTempDataDatabase {
    private volatile SummaryTempDataDao _summaryTempDataDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) { // from class: com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) throws SQLException {
                db.execSQL("CREATE TABLE IF NOT EXISTS `SUMMARY_TEMP_DATA_TABLE` (`summary_ftms_temp_list_data_json` TEXT NOT NULL, `ftms_data_class_name` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_SUMMARY_TEMP_DATA_TABLE_id` ON `SUMMARY_TEMP_DATA_TABLE` (`id`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_SUMMARY_TEMP_DATA_TABLE_id_summary_ftms_temp_list_data_json_ftms_data_class_name` ON `SUMMARY_TEMP_DATA_TABLE` (`id`, `summary_ftms_temp_list_data_json`, `ftms_data_class_name`)");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7de13bfa68c3b8018c66240bbc8de7b5')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) throws SQLException {
                db.execSQL("DROP TABLE IF EXISTS `SUMMARY_TEMP_DATA_TABLE`");
                List list = SummaryTempDataDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List list = SummaryTempDataDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                SummaryTempDataDatabase_Impl.this.mDatabase = db;
                SummaryTempDataDatabase_Impl.this.internalInitInvalidationTracker(db);
                List list = SummaryTempDataDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onOpen(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(final SupportSQLiteDatabase db) throws SQLException {
                DBUtil.dropFtsSyncTriggers(db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(final SupportSQLiteDatabase db) {
                HashMap map = new HashMap(3);
                map.put("summary_ftms_temp_list_data_json", new TableInfo.Column("summary_ftms_temp_list_data_json", "TEXT", true, 0, null, 1));
                map.put("ftms_data_class_name", new TableInfo.Column("ftms_data_class_name", "TEXT", true, 0, null, 1));
                map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new TableInfo.Index("index_SUMMARY_TEMP_DATA_TABLE_id", false, Arrays.asList("id"), Arrays.asList("ASC")));
                hashSet2.add(new TableInfo.Index("index_SUMMARY_TEMP_DATA_TABLE_id_summary_ftms_temp_list_data_json_ftms_data_class_name", false, Arrays.asList("id", "summary_ftms_temp_list_data_json", "ftms_data_class_name"), Arrays.asList("ASC", "ASC", "ASC")));
                TableInfo tableInfo = new TableInfo(SummaryTempDataEntity.SUMMARY_TEMP_DATA_TABLE, map, hashSet, hashSet2);
                TableInfo tableInfo2 = TableInfo.read(db, SummaryTempDataEntity.SUMMARY_TEMP_DATA_TABLE);
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "SUMMARY_TEMP_DATA_TABLE(com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "7de13bfa68c3b8018c66240bbc8de7b5", "ecd4f8eea7f5c52d0e5629669b3a02ef")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), SummaryTempDataEntity.SUMMARY_TEMP_DATA_TABLE);
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() throws SQLException {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `SUMMARY_TEMP_DATA_TABLE`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(SummaryTempDataDao.class, SummaryTempDataDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDatabase
    public SummaryTempDataDao summaryTempDataDao() {
        SummaryTempDataDao summaryTempDataDao;
        if (this._summaryTempDataDao != null) {
            return this._summaryTempDataDao;
        }
        synchronized (this) {
            if (this._summaryTempDataDao == null) {
                this._summaryTempDataDao = new SummaryTempDataDao_Impl(this);
            }
            summaryTempDataDao = this._summaryTempDataDao;
        }
        return summaryTempDataDao;
    }
}
