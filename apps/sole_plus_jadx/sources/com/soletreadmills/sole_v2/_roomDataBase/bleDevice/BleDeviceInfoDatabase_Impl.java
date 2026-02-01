package com.soletreadmills.sole_v2._roomDataBase.bleDevice;

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
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class BleDeviceInfoDatabase_Impl extends BleDeviceInfoDatabase {
    private volatile BleDeviceInfoDao _bleDeviceInfoDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(4) { // from class: com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) throws SQLException {
                db.execSQL("CREATE TABLE IF NOT EXISTS `BLE_DEVICE_INFO_TABLE` (`address` TEXT, `ble_name` TEXT NOT NULL, `account_no` TEXT NOT NULL DEFAULT '', `machine_type` TEXT, `is_has_adv_0x16` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`ble_name`, `account_no`))");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '59acb1a24ca399e7f4c6d762c698c0d6')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) throws SQLException {
                db.execSQL("DROP TABLE IF EXISTS `BLE_DEVICE_INFO_TABLE`");
                List list = BleDeviceInfoDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List list = BleDeviceInfoDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                BleDeviceInfoDatabase_Impl.this.mDatabase = db;
                BleDeviceInfoDatabase_Impl.this.internalInitInvalidationTracker(db);
                List list = BleDeviceInfoDatabase_Impl.this.mCallbacks;
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
                HashMap map = new HashMap(5);
                map.put(IntegrityManager.INTEGRITY_TYPE_ADDRESS, new TableInfo.Column(IntegrityManager.INTEGRITY_TYPE_ADDRESS, "TEXT", false, 0, null, 1));
                map.put("ble_name", new TableInfo.Column("ble_name", "TEXT", true, 1, null, 1));
                map.put("account_no", new TableInfo.Column("account_no", "TEXT", true, 2, "''", 1));
                map.put("machine_type", new TableInfo.Column("machine_type", "TEXT", false, 0, null, 1));
                map.put("is_has_adv_0x16", new TableInfo.Column("is_has_adv_0x16", "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo = new TableInfo(BleDeviceInfoEntity.BLE_DEVICE_INFO_TABLE, map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(db, BleDeviceInfoEntity.BLE_DEVICE_INFO_TABLE);
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "BLE_DEVICE_INFO_TABLE(com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "59acb1a24ca399e7f4c6d762c698c0d6", "9e1a85c753532105c6a477767c5379a7")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), BleDeviceInfoEntity.BLE_DEVICE_INFO_TABLE);
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() throws SQLException {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `BLE_DEVICE_INFO_TABLE`");
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
        map.put(BleDeviceInfoDao.class, BleDeviceInfoDao_Impl.getRequiredConverters());
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

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDatabase
    public BleDeviceInfoDao bleDeviceInfoDao() {
        BleDeviceInfoDao bleDeviceInfoDao;
        if (this._bleDeviceInfoDao != null) {
            return this._bleDeviceInfoDao;
        }
        synchronized (this) {
            if (this._bleDeviceInfoDao == null) {
                this._bleDeviceInfoDao = new BleDeviceInfoDao_Impl(this);
            }
            bleDeviceInfoDao = this._bleDeviceInfoDao;
        }
        return bleDeviceInfoDao;
    }
}
