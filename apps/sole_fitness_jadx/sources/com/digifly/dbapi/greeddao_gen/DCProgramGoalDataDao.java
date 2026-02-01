package com.digifly.dbapi.greeddao_gen;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.digifly.cloudapi.data.DCProgramGoalData;
import com.dyaco.sole.database.MessageDB;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class DCProgramGoalDataDao extends AbstractDao<DCProgramGoalData, Long> {
    public static final String TABLENAME = "PROGRAMGOAL_DATA";

    public static class Properties {
        public static final Property GoalId = new Property(0, Long.class, "goalId", true, "GOAL_ID");
        public static final Property Account = new Property(1, String.class, MessageDB.ACCOUNT, false, MessageDB.ACCOUNT);
        public static final Property Account_no = new Property(2, Integer.TYPE, "account_no", false, "ACCOUNT_NO");
        public static final Property Goal_name = new Property(3, String.class, "goal_name", false, "GOAL_NAME");
        public static final Property Goal_duration = new Property(4, Integer.TYPE, "goal_duration", false, "GOAL_DURATION");
        public static final Property Goal_period_type = new Property(5, Integer.TYPE, "goal_period_type", false, "GOAL_PERIOD_TYPE");
        public static final Property Goal_start_date = new Property(6, Date.class, "goal_start_date", false, "GOAL_START_DATE");
        public static final Property Goal_end_date = new Property(7, Date.class, "goal_end_date", false, "GOAL_END_DATE");
        public static final Property Goal_type = new Property(8, Integer.TYPE, "goal_type", false, "GOAL_TYPE");
        public static final Property Goal_val = new Property(9, Integer.TYPE, "goal_val", false, "GOAL_VAL");
        public static final Property Goal_state = new Property(10, Integer.TYPE, "goal_state", false, "GOAL_STATE");
        public static final Property Elapsedays = new Property(11, Float.TYPE, "elapsedays", false, "ELAPSEDAYS");
        public static final Property Goal_pos_in_duration = new Property(12, Integer.TYPE, "goal_pos_in_duration", false, "GOAL_POS_IN_DURATION");
        public static final Property Goal_val_now = new Property(13, Float.TYPE, "goal_val_now", false, "GOAL_VAL_NOW");
        public static final Property Goal_percent = new Property(14, Integer.TYPE, "goal_percent", false, "GOAL_PERCENT");
        public static final Property Goal_no = new Property(15, String.class, "goal_no", false, "GOAL_NO");
        public static final Property Goal_timezone_hour = new Property(16, Integer.TYPE, "goal_timezone_hour", false, "GOAL_TIMEZONE_HOUR");
        public static final Property Goal_timezone_name = new Property(17, String.class, "goal_timezone_name", false, "GOAL_TIMEZONE_NAME");
        public static final Property Brand_code = new Property(18, String.class, "brand_code", false, "BRAND_CODE");
        public static final Property Device_os_name = new Property(19, String.class, "device_os_name", false, "DEVICE_OS_NAME");
        public static final Property Device_os_version = new Property(20, String.class, "device_os_version", false, "DEVICE_OS_VERSION");
        public static final Property Device_model = new Property(21, String.class, "device_model", false, "DEVICE_MODEL");
        public static final Property Device_sno = new Property(22, String.class, "device_sno", false, "DEVICE_SNO");
    }

    @Override // org.greenrobot.greendao.AbstractDao
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public DCProgramGoalDataDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public DCProgramGoalDataDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"PROGRAMGOAL_DATA\" (\"GOAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"account\" TEXT,\"ACCOUNT_NO\" INTEGER NOT NULL ,\"GOAL_NAME\" TEXT,\"GOAL_DURATION\" INTEGER NOT NULL ,\"GOAL_PERIOD_TYPE\" INTEGER NOT NULL ,\"GOAL_START_DATE\" INTEGER,\"GOAL_END_DATE\" INTEGER,\"GOAL_TYPE\" INTEGER NOT NULL ,\"GOAL_VAL\" INTEGER NOT NULL ,\"GOAL_STATE\" INTEGER NOT NULL ,\"ELAPSEDAYS\" REAL NOT NULL ,\"GOAL_POS_IN_DURATION\" INTEGER NOT NULL ,\"GOAL_VAL_NOW\" REAL NOT NULL ,\"GOAL_PERCENT\" INTEGER NOT NULL ,\"GOAL_NO\" TEXT,\"GOAL_TIMEZONE_HOUR\" INTEGER NOT NULL ,\"GOAL_TIMEZONE_NAME\" TEXT,\"BRAND_CODE\" TEXT,\"DEVICE_OS_NAME\" TEXT,\"DEVICE_OS_VERSION\" TEXT,\"DEVICE_MODEL\" TEXT,\"DEVICE_SNO\" TEXT);");
    }

    public static void dropTable(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"PROGRAMGOAL_DATA\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DCProgramGoalData dCProgramGoalData) {
        databaseStatement.clearBindings();
        Long goalId = dCProgramGoalData.getGoalId();
        if (goalId != null) {
            databaseStatement.bindLong(1, goalId.longValue());
        }
        String account = dCProgramGoalData.getAccount();
        if (account != null) {
            databaseStatement.bindString(2, account);
        }
        databaseStatement.bindLong(3, dCProgramGoalData.getAccount_no());
        String goal_name = dCProgramGoalData.getGoal_name();
        if (goal_name != null) {
            databaseStatement.bindString(4, goal_name);
        }
        databaseStatement.bindLong(5, dCProgramGoalData.getGoal_duration());
        databaseStatement.bindLong(6, dCProgramGoalData.getGoal_period_type());
        Date goal_start_date = dCProgramGoalData.getGoal_start_date();
        if (goal_start_date != null) {
            databaseStatement.bindLong(7, goal_start_date.getTime());
        }
        Date goal_end_date = dCProgramGoalData.getGoal_end_date();
        if (goal_end_date != null) {
            databaseStatement.bindLong(8, goal_end_date.getTime());
        }
        databaseStatement.bindLong(9, dCProgramGoalData.getGoal_type());
        databaseStatement.bindLong(10, dCProgramGoalData.getGoal_val());
        databaseStatement.bindLong(11, dCProgramGoalData.getGoal_state());
        databaseStatement.bindDouble(12, dCProgramGoalData.getElapsedays());
        databaseStatement.bindLong(13, dCProgramGoalData.getGoal_pos_in_duration());
        databaseStatement.bindDouble(14, dCProgramGoalData.getGoal_val_now());
        databaseStatement.bindLong(15, dCProgramGoalData.getGoal_percent());
        String goal_no = dCProgramGoalData.getGoal_no();
        if (goal_no != null) {
            databaseStatement.bindString(16, goal_no);
        }
        databaseStatement.bindLong(17, dCProgramGoalData.getGoal_timezone_hour());
        String goal_timezone_name = dCProgramGoalData.getGoal_timezone_name();
        if (goal_timezone_name != null) {
            databaseStatement.bindString(18, goal_timezone_name);
        }
        String brand_code = dCProgramGoalData.getBrand_code();
        if (brand_code != null) {
            databaseStatement.bindString(19, brand_code);
        }
        String device_os_name = dCProgramGoalData.getDevice_os_name();
        if (device_os_name != null) {
            databaseStatement.bindString(20, device_os_name);
        }
        String device_os_version = dCProgramGoalData.getDevice_os_version();
        if (device_os_version != null) {
            databaseStatement.bindString(21, device_os_version);
        }
        String device_model = dCProgramGoalData.getDevice_model();
        if (device_model != null) {
            databaseStatement.bindString(22, device_model);
        }
        String device_sno = dCProgramGoalData.getDevice_sno();
        if (device_sno != null) {
            databaseStatement.bindString(23, device_sno);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DCProgramGoalData dCProgramGoalData) {
        sQLiteStatement.clearBindings();
        Long goalId = dCProgramGoalData.getGoalId();
        if (goalId != null) {
            sQLiteStatement.bindLong(1, goalId.longValue());
        }
        String account = dCProgramGoalData.getAccount();
        if (account != null) {
            sQLiteStatement.bindString(2, account);
        }
        sQLiteStatement.bindLong(3, dCProgramGoalData.getAccount_no());
        String goal_name = dCProgramGoalData.getGoal_name();
        if (goal_name != null) {
            sQLiteStatement.bindString(4, goal_name);
        }
        sQLiteStatement.bindLong(5, dCProgramGoalData.getGoal_duration());
        sQLiteStatement.bindLong(6, dCProgramGoalData.getGoal_period_type());
        Date goal_start_date = dCProgramGoalData.getGoal_start_date();
        if (goal_start_date != null) {
            sQLiteStatement.bindLong(7, goal_start_date.getTime());
        }
        Date goal_end_date = dCProgramGoalData.getGoal_end_date();
        if (goal_end_date != null) {
            sQLiteStatement.bindLong(8, goal_end_date.getTime());
        }
        sQLiteStatement.bindLong(9, dCProgramGoalData.getGoal_type());
        sQLiteStatement.bindLong(10, dCProgramGoalData.getGoal_val());
        sQLiteStatement.bindLong(11, dCProgramGoalData.getGoal_state());
        sQLiteStatement.bindDouble(12, dCProgramGoalData.getElapsedays());
        sQLiteStatement.bindLong(13, dCProgramGoalData.getGoal_pos_in_duration());
        sQLiteStatement.bindDouble(14, dCProgramGoalData.getGoal_val_now());
        sQLiteStatement.bindLong(15, dCProgramGoalData.getGoal_percent());
        String goal_no = dCProgramGoalData.getGoal_no();
        if (goal_no != null) {
            sQLiteStatement.bindString(16, goal_no);
        }
        sQLiteStatement.bindLong(17, dCProgramGoalData.getGoal_timezone_hour());
        String goal_timezone_name = dCProgramGoalData.getGoal_timezone_name();
        if (goal_timezone_name != null) {
            sQLiteStatement.bindString(18, goal_timezone_name);
        }
        String brand_code = dCProgramGoalData.getBrand_code();
        if (brand_code != null) {
            sQLiteStatement.bindString(19, brand_code);
        }
        String device_os_name = dCProgramGoalData.getDevice_os_name();
        if (device_os_name != null) {
            sQLiteStatement.bindString(20, device_os_name);
        }
        String device_os_version = dCProgramGoalData.getDevice_os_version();
        if (device_os_version != null) {
            sQLiteStatement.bindString(21, device_os_version);
        }
        String device_model = dCProgramGoalData.getDevice_model();
        if (device_model != null) {
            sQLiteStatement.bindString(22, device_model);
        }
        String device_sno = dCProgramGoalData.getDevice_sno();
        if (device_sno != null) {
            sQLiteStatement.bindString(23, device_sno);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DCProgramGoalData readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = cursor.getInt(i + 2);
        int i5 = i + 3;
        String string2 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = cursor.getInt(i + 4);
        int i7 = cursor.getInt(i + 5);
        int i8 = i + 6;
        Date date = cursor.isNull(i8) ? null : new Date(cursor.getLong(i8));
        int i9 = i + 7;
        Date date2 = cursor.isNull(i9) ? null : new Date(cursor.getLong(i9));
        int i10 = cursor.getInt(i + 8);
        int i11 = cursor.getInt(i + 9);
        int i12 = cursor.getInt(i + 10);
        float f = cursor.getFloat(i + 11);
        int i13 = cursor.getInt(i + 12);
        float f2 = cursor.getFloat(i + 13);
        int i14 = cursor.getInt(i + 14);
        int i15 = i + 15;
        String string3 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = cursor.getInt(i + 16);
        int i17 = i + 17;
        String string4 = cursor.isNull(i17) ? null : cursor.getString(i17);
        int i18 = i + 18;
        String string5 = cursor.isNull(i18) ? null : cursor.getString(i18);
        int i19 = i + 19;
        String string6 = cursor.isNull(i19) ? null : cursor.getString(i19);
        int i20 = i + 20;
        String string7 = cursor.isNull(i20) ? null : cursor.getString(i20);
        int i21 = i + 21;
        String string8 = cursor.isNull(i21) ? null : cursor.getString(i21);
        int i22 = i + 22;
        return new DCProgramGoalData(lValueOf, string, i4, string2, i6, i7, date, date2, i10, i11, i12, f, i13, f2, i14, string3, i16, string4, string5, string6, string7, string8, cursor.isNull(i22) ? null : cursor.getString(i22));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DCProgramGoalData dCProgramGoalData, int i) {
        int i2 = i + 0;
        dCProgramGoalData.setGoalId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        dCProgramGoalData.setAccount(cursor.isNull(i3) ? null : cursor.getString(i3));
        dCProgramGoalData.setAccount_no(cursor.getInt(i + 2));
        int i4 = i + 3;
        dCProgramGoalData.setGoal_name(cursor.isNull(i4) ? null : cursor.getString(i4));
        dCProgramGoalData.setGoal_duration(cursor.getInt(i + 4));
        dCProgramGoalData.setGoal_period_type(cursor.getInt(i + 5));
        int i5 = i + 6;
        dCProgramGoalData.setGoal_start_date(cursor.isNull(i5) ? null : new Date(cursor.getLong(i5)));
        int i6 = i + 7;
        dCProgramGoalData.setGoal_end_date(cursor.isNull(i6) ? null : new Date(cursor.getLong(i6)));
        dCProgramGoalData.setGoal_type(cursor.getInt(i + 8));
        dCProgramGoalData.setGoal_val(cursor.getInt(i + 9));
        dCProgramGoalData.setGoal_state(cursor.getInt(i + 10));
        dCProgramGoalData.setElapsedays(cursor.getFloat(i + 11));
        dCProgramGoalData.setGoal_pos_in_duration(cursor.getInt(i + 12));
        dCProgramGoalData.setGoal_val_now(cursor.getFloat(i + 13));
        dCProgramGoalData.setGoal_percent(cursor.getInt(i + 14));
        int i7 = i + 15;
        dCProgramGoalData.setGoal_no(cursor.isNull(i7) ? null : cursor.getString(i7));
        dCProgramGoalData.setGoal_timezone_hour(cursor.getInt(i + 16));
        int i8 = i + 17;
        dCProgramGoalData.setGoal_timezone_name(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 18;
        dCProgramGoalData.setBrand_code(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 19;
        dCProgramGoalData.setDevice_os_name(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 20;
        dCProgramGoalData.setDevice_os_version(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 21;
        dCProgramGoalData.setDevice_model(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 22;
        dCProgramGoalData.setDevice_sno(cursor.isNull(i13) ? null : cursor.getString(i13));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(DCProgramGoalData dCProgramGoalData, long j) {
        dCProgramGoalData.setGoalId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DCProgramGoalData dCProgramGoalData) {
        if (dCProgramGoalData != null) {
            return dCProgramGoalData.getGoalId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DCProgramGoalData dCProgramGoalData) {
        return dCProgramGoalData.getGoalId() != null;
    }
}
