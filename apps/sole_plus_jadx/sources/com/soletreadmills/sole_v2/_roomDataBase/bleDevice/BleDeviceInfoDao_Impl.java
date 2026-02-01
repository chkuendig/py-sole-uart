package com.soletreadmills.sole_v2._roomDataBase.bleDevice;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class BleDeviceInfoDao_Impl implements BleDeviceInfoDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<BleDeviceInfoEntity> __deletionAdapterOfBleDeviceInfoEntity;
    private final EntityInsertionAdapter<BleDeviceInfoEntity> __insertionAdapterOfBleDeviceInfoEntity;
    private final EntityDeletionOrUpdateAdapter<BleDeviceInfoEntity> __updateAdapterOfBleDeviceInfoEntity;

    public BleDeviceInfoDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfBleDeviceInfoEntity = new EntityInsertionAdapter<BleDeviceInfoEntity>(__db) { // from class: com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `BLE_DEVICE_INFO_TABLE` (`address`,`ble_name`,`account_no`,`machine_type`,`is_has_adv_0x16`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, BleDeviceInfoEntity bleDeviceInfoEntity) {
                if (bleDeviceInfoEntity.getAddress() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, bleDeviceInfoEntity.getAddress());
                }
                if (bleDeviceInfoEntity.getBleName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, bleDeviceInfoEntity.getBleName());
                }
                if (bleDeviceInfoEntity.getAccountNo() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, bleDeviceInfoEntity.getAccountNo());
                }
                if (bleDeviceInfoEntity.getMachineType() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, bleDeviceInfoEntity.getMachineType());
                }
                supportSQLiteStatement.bindLong(5, bleDeviceInfoEntity.isHasAdv0x16() ? 1L : 0L);
            }
        };
        this.__deletionAdapterOfBleDeviceInfoEntity = new EntityDeletionOrUpdateAdapter<BleDeviceInfoEntity>(__db) { // from class: com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `BLE_DEVICE_INFO_TABLE` WHERE `ble_name` = ? AND `account_no` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final BleDeviceInfoEntity entity) {
                if (entity.getBleName() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getBleName());
                }
                if (entity.getAccountNo() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getAccountNo());
                }
            }
        };
        this.__updateAdapterOfBleDeviceInfoEntity = new EntityDeletionOrUpdateAdapter<BleDeviceInfoEntity>(__db) { // from class: com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `BLE_DEVICE_INFO_TABLE` SET `address` = ?,`ble_name` = ?,`account_no` = ?,`machine_type` = ?,`is_has_adv_0x16` = ? WHERE `ble_name` = ? AND `account_no` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, BleDeviceInfoEntity bleDeviceInfoEntity) {
                if (bleDeviceInfoEntity.getAddress() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, bleDeviceInfoEntity.getAddress());
                }
                if (bleDeviceInfoEntity.getBleName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, bleDeviceInfoEntity.getBleName());
                }
                if (bleDeviceInfoEntity.getAccountNo() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, bleDeviceInfoEntity.getAccountNo());
                }
                if (bleDeviceInfoEntity.getMachineType() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, bleDeviceInfoEntity.getMachineType());
                }
                supportSQLiteStatement.bindLong(5, bleDeviceInfoEntity.isHasAdv0x16() ? 1L : 0L);
                if (bleDeviceInfoEntity.getBleName() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, bleDeviceInfoEntity.getBleName());
                }
                if (bleDeviceInfoEntity.getAccountNo() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, bleDeviceInfoEntity.getAccountNo());
                }
            }
        };
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao
    public void insert(final BleDeviceInfoEntity bleDeviceInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfBleDeviceInfoEntity.insert((EntityInsertionAdapter<BleDeviceInfoEntity>) bleDeviceInfoEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao
    public void insertAll(final BleDeviceInfoEntity... bleDeviceInfoEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfBleDeviceInfoEntity.insert(bleDeviceInfoEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao
    public void delete(final BleDeviceInfoEntity bleDeviceInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfBleDeviceInfoEntity.handle(bleDeviceInfoEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao
    public void delete(final BleDeviceInfoEntity... bleDeviceInfoEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfBleDeviceInfoEntity.handleMultiple(bleDeviceInfoEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao
    public void update(final BleDeviceInfoEntity bleDeviceInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfBleDeviceInfoEntity.handle(bleDeviceInfoEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao
    public void update(final BleDeviceInfoEntity... bleDeviceInfoEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfBleDeviceInfoEntity.handleMultiple(bleDeviceInfoEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao
    public List<BleDeviceInfoEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BLE_DEVICE_INFO_TABLE", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ble_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "account_no");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "machine_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_has_adv_0x16");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new BleDeviceInfoEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5) != 0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao
    public List<BleDeviceInfoEntity> getAll(final String accountNo) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BLE_DEVICE_INFO_TABLE WHERE account_no = ?", 1);
        if (accountNo == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, accountNo);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ble_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "account_no");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "machine_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_has_adv_0x16");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new BleDeviceInfoEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5) != 0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao
    public List<BleDeviceInfoEntity> loadAllByBleName(final String bleName) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BLE_DEVICE_INFO_TABLE WHERE ble_name IN (?)", 1);
        if (bleName == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, bleName);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ble_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "account_no");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "machine_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_has_adv_0x16");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new BleDeviceInfoEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5) != 0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao
    public BleDeviceInfoEntity findByAddress(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BLE_DEVICE_INFO_TABLE WHERE address = ? AND account_no = ? LIMIT 1", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        BleDeviceInfoEntity bleDeviceInfoEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ble_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "account_no");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "machine_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_has_adv_0x16");
            if (cursorQuery.moveToFirst()) {
                bleDeviceInfoEntity = new BleDeviceInfoEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5) != 0);
            }
            return bleDeviceInfoEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao
    public BleDeviceInfoEntity findByBleName(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BLE_DEVICE_INFO_TABLE WHERE ble_name = ? AND account_no = ? LIMIT 1", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        BleDeviceInfoEntity bleDeviceInfoEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ble_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "account_no");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "machine_type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_has_adv_0x16");
            if (cursorQuery.moveToFirst()) {
                bleDeviceInfoEntity = new BleDeviceInfoEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5) != 0);
            }
            return bleDeviceInfoEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
