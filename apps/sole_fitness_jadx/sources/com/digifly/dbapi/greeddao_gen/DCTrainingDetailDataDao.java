package com.digifly.dbapi.greeddao_gen;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.digifly.cloudapi.data.DCTrainingDetailData;
import com.dyaco.sole.database.MessageDB;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class DCTrainingDetailDataDao extends AbstractDao<DCTrainingDetailData, Long> {
    public static final String TABLENAME = "TRAINING_DETAIL_DATA";

    public static class Properties {
        public static final Property TrainingDetailId = new Property(0, Long.class, "trainingDetailId", true, "TRAINING_DETAIL_ID");
        public static final Property TrainingId = new Property(1, Long.class, "trainingId", false, "TRAINING_ID");
        public static final Property Account = new Property(2, String.class, MessageDB.ACCOUNT, false, "ACCOUNT");
        public static final Property Password = new Property(3, String.class, "password", false, "PASSWORD");
        public static final Property Account_no = new Property(4, Integer.TYPE, "account_no", false, "ACCOUNT_NO");
        public static final Property Traning_datetime = new Property(5, Date.class, "traning_datetime", false, "TRANING_DATETIME");
        public static final Property D_time = new Property(6, Float.TYPE, "d_time", false, "D_TIME");
        public static final Property D_distance = new Property(7, Float.TYPE, "d_distance", false, "D_DISTANCE");
        public static final Property D_calories = new Property(8, Float.TYPE, "d_calories", false, "D_CALORIES");
        public static final Property D_hr = new Property(9, Float.TYPE, "d_hr", false, "D_HR");
        public static final Property D_rpm = new Property(10, Float.TYPE, "d_rpm", false, "D_RPM");
        public static final Property D_speed = new Property(11, Float.TYPE, "d_speed", false, "D_SPEED");
        public static final Property D_watt = new Property(12, Float.TYPE, "d_watt", false, "D_WATT");
        public static final Property D_met = new Property(13, Float.TYPE, "d_met", false, "D_MET");
        public static final Property D_level = new Property(14, Float.TYPE, "d_level", false, "D_LEVEL");
        public static final Property D_incline = new Property(15, Float.TYPE, "d_incline", false, "D_INCLINE");
        public static final Property Trainh_no = new Property(16, String.class, "trainh_no", false, "TRAINH_NO");
        public static final Property Trainh_detail_no = new Property(17, String.class, "trainh_detail_no", false, "TRAINH_DETAIL_NO");
        public static final Property D_heart_rate_type = new Property(18, String.class, "d_heart_rate_type", false, "D_HEART_RATE_TYPE");
        public static final Property D_fusion_interval_time = new Property(19, Float.TYPE, "d_fusion_interval_time", false, "D_FUSION_INTERVAL_TIME");
        public static final Property D_fusion_recovery_time = new Property(20, Float.TYPE, "d_fusion_recovery_time", false, "D_FUSION_RECOVERY_TIME");
        public static final Property D_program_row = new Property(21, Float.TYPE, "d_program_row", false, "D_PROGRAM_ROW");
        public static final Property D_program_height = new Property(22, Float.TYPE, "d_program_height", false, "D_PROGRAM_HEIGHT");
        public static final Property D_program_level = new Property(23, Float.TYPE, "d_program_level", false, "D_PROGRAM_LEVEL");
        public static final Property D_program_total_step = new Property(24, Float.TYPE, "d_program_total_step", false, "D_PROGRAM_TOTAL_STEP");
        public static final Property D_program_per_step = new Property(25, Float.TYPE, "d_program_per_step", false, "D_PROGRAM_PER_STEP");
        public static final Property D_program_vert = new Property(26, Float.TYPE, "d_program_vert", false, "D_PROGRAM_VERT");
        public static final Property D_program_step_height = new Property(27, Float.TYPE, "d_program_step_height", false, "D_PROGRAM_STEP_HEIGHT");
        public static final Property Device_gps_lat = new Property(28, Float.TYPE, "device_gps_lat", false, "DEVICE_GPS_LAT");
        public static final Property Device_gps_lng = new Property(29, Float.TYPE, "device_gps_lng", false, "DEVICE_GPS_LNG");
        public static final Property ORG_NO = new Property(30, String.class, "ORG_NO", false, "ORG__NO");
    }

    @Override // org.greenrobot.greendao.AbstractDao
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public DCTrainingDetailDataDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public DCTrainingDetailDataDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"TRAINING_DETAIL_DATA\" (\"TRAINING_DETAIL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TRAINING_ID\" INTEGER,\"ACCOUNT\" TEXT,\"PASSWORD\" TEXT,\"ACCOUNT_NO\" INTEGER NOT NULL ,\"TRANING_DATETIME\" INTEGER,\"D_TIME\" REAL NOT NULL ,\"D_DISTANCE\" REAL NOT NULL ,\"D_CALORIES\" REAL NOT NULL ,\"D_HR\" REAL NOT NULL ,\"D_RPM\" REAL NOT NULL ,\"D_SPEED\" REAL NOT NULL ,\"D_WATT\" REAL NOT NULL ,\"D_MET\" REAL NOT NULL ,\"D_LEVEL\" REAL NOT NULL ,\"D_INCLINE\" REAL NOT NULL ,\"TRAINH_NO\" TEXT,\"TRAINH_DETAIL_NO\" TEXT,\"D_HEART_RATE_TYPE\" TEXT,\"D_FUSION_INTERVAL_TIME\" REAL NOT NULL ,\"D_FUSION_RECOVERY_TIME\" REAL NOT NULL ,\"D_PROGRAM_ROW\" REAL NOT NULL ,\"D_PROGRAM_HEIGHT\" REAL NOT NULL ,\"D_PROGRAM_LEVEL\" REAL NOT NULL ,\"D_PROGRAM_TOTAL_STEP\" REAL NOT NULL ,\"D_PROGRAM_PER_STEP\" REAL NOT NULL ,\"D_PROGRAM_VERT\" REAL NOT NULL ,\"D_PROGRAM_STEP_HEIGHT\" REAL NOT NULL ,\"DEVICE_GPS_LAT\" REAL NOT NULL ,\"DEVICE_GPS_LNG\" REAL NOT NULL ,\"ORG__NO\" TEXT);");
    }

    public static void dropTable(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"TRAINING_DETAIL_DATA\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DCTrainingDetailData dCTrainingDetailData) {
        databaseStatement.clearBindings();
        Long trainingDetailId = dCTrainingDetailData.getTrainingDetailId();
        if (trainingDetailId != null) {
            databaseStatement.bindLong(1, trainingDetailId.longValue());
        }
        Long trainingId = dCTrainingDetailData.getTrainingId();
        if (trainingId != null) {
            databaseStatement.bindLong(2, trainingId.longValue());
        }
        String account = dCTrainingDetailData.getAccount();
        if (account != null) {
            databaseStatement.bindString(3, account);
        }
        String password = dCTrainingDetailData.getPassword();
        if (password != null) {
            databaseStatement.bindString(4, password);
        }
        databaseStatement.bindLong(5, dCTrainingDetailData.getAccount_no());
        Date traning_datetime = dCTrainingDetailData.getTraning_datetime();
        if (traning_datetime != null) {
            databaseStatement.bindLong(6, traning_datetime.getTime());
        }
        databaseStatement.bindDouble(7, dCTrainingDetailData.getD_time());
        databaseStatement.bindDouble(8, dCTrainingDetailData.getD_distance());
        databaseStatement.bindDouble(9, dCTrainingDetailData.getD_calories());
        databaseStatement.bindDouble(10, dCTrainingDetailData.getD_hr());
        databaseStatement.bindDouble(11, dCTrainingDetailData.getD_rpm());
        databaseStatement.bindDouble(12, dCTrainingDetailData.getD_speed());
        databaseStatement.bindDouble(13, dCTrainingDetailData.getD_watt());
        databaseStatement.bindDouble(14, dCTrainingDetailData.getD_met());
        databaseStatement.bindDouble(15, dCTrainingDetailData.getD_level());
        databaseStatement.bindDouble(16, dCTrainingDetailData.getD_incline());
        String trainh_no = dCTrainingDetailData.getTrainh_no();
        if (trainh_no != null) {
            databaseStatement.bindString(17, trainh_no);
        }
        String trainh_detail_no = dCTrainingDetailData.getTrainh_detail_no();
        if (trainh_detail_no != null) {
            databaseStatement.bindString(18, trainh_detail_no);
        }
        String d_heart_rate_type = dCTrainingDetailData.getD_heart_rate_type();
        if (d_heart_rate_type != null) {
            databaseStatement.bindString(19, d_heart_rate_type);
        }
        databaseStatement.bindDouble(20, dCTrainingDetailData.getD_fusion_interval_time());
        databaseStatement.bindDouble(21, dCTrainingDetailData.getD_fusion_recovery_time());
        databaseStatement.bindDouble(22, dCTrainingDetailData.getD_program_row());
        databaseStatement.bindDouble(23, dCTrainingDetailData.getD_program_height());
        databaseStatement.bindDouble(24, dCTrainingDetailData.getD_program_level());
        databaseStatement.bindDouble(25, dCTrainingDetailData.getD_program_total_step());
        databaseStatement.bindDouble(26, dCTrainingDetailData.getD_program_per_step());
        databaseStatement.bindDouble(27, dCTrainingDetailData.getD_program_vert());
        databaseStatement.bindDouble(28, dCTrainingDetailData.getD_program_step_height());
        databaseStatement.bindDouble(29, dCTrainingDetailData.getDevice_gps_lat());
        databaseStatement.bindDouble(30, dCTrainingDetailData.getDevice_gps_lng());
        String org_no = dCTrainingDetailData.getORG_NO();
        if (org_no != null) {
            databaseStatement.bindString(31, org_no);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DCTrainingDetailData dCTrainingDetailData) {
        sQLiteStatement.clearBindings();
        Long trainingDetailId = dCTrainingDetailData.getTrainingDetailId();
        if (trainingDetailId != null) {
            sQLiteStatement.bindLong(1, trainingDetailId.longValue());
        }
        Long trainingId = dCTrainingDetailData.getTrainingId();
        if (trainingId != null) {
            sQLiteStatement.bindLong(2, trainingId.longValue());
        }
        String account = dCTrainingDetailData.getAccount();
        if (account != null) {
            sQLiteStatement.bindString(3, account);
        }
        String password = dCTrainingDetailData.getPassword();
        if (password != null) {
            sQLiteStatement.bindString(4, password);
        }
        sQLiteStatement.bindLong(5, dCTrainingDetailData.getAccount_no());
        Date traning_datetime = dCTrainingDetailData.getTraning_datetime();
        if (traning_datetime != null) {
            sQLiteStatement.bindLong(6, traning_datetime.getTime());
        }
        sQLiteStatement.bindDouble(7, dCTrainingDetailData.getD_time());
        sQLiteStatement.bindDouble(8, dCTrainingDetailData.getD_distance());
        sQLiteStatement.bindDouble(9, dCTrainingDetailData.getD_calories());
        sQLiteStatement.bindDouble(10, dCTrainingDetailData.getD_hr());
        sQLiteStatement.bindDouble(11, dCTrainingDetailData.getD_rpm());
        sQLiteStatement.bindDouble(12, dCTrainingDetailData.getD_speed());
        sQLiteStatement.bindDouble(13, dCTrainingDetailData.getD_watt());
        sQLiteStatement.bindDouble(14, dCTrainingDetailData.getD_met());
        sQLiteStatement.bindDouble(15, dCTrainingDetailData.getD_level());
        sQLiteStatement.bindDouble(16, dCTrainingDetailData.getD_incline());
        String trainh_no = dCTrainingDetailData.getTrainh_no();
        if (trainh_no != null) {
            sQLiteStatement.bindString(17, trainh_no);
        }
        String trainh_detail_no = dCTrainingDetailData.getTrainh_detail_no();
        if (trainh_detail_no != null) {
            sQLiteStatement.bindString(18, trainh_detail_no);
        }
        String d_heart_rate_type = dCTrainingDetailData.getD_heart_rate_type();
        if (d_heart_rate_type != null) {
            sQLiteStatement.bindString(19, d_heart_rate_type);
        }
        sQLiteStatement.bindDouble(20, dCTrainingDetailData.getD_fusion_interval_time());
        sQLiteStatement.bindDouble(21, dCTrainingDetailData.getD_fusion_recovery_time());
        sQLiteStatement.bindDouble(22, dCTrainingDetailData.getD_program_row());
        sQLiteStatement.bindDouble(23, dCTrainingDetailData.getD_program_height());
        sQLiteStatement.bindDouble(24, dCTrainingDetailData.getD_program_level());
        sQLiteStatement.bindDouble(25, dCTrainingDetailData.getD_program_total_step());
        sQLiteStatement.bindDouble(26, dCTrainingDetailData.getD_program_per_step());
        sQLiteStatement.bindDouble(27, dCTrainingDetailData.getD_program_vert());
        sQLiteStatement.bindDouble(28, dCTrainingDetailData.getD_program_step_height());
        sQLiteStatement.bindDouble(29, dCTrainingDetailData.getDevice_gps_lat());
        sQLiteStatement.bindDouble(30, dCTrainingDetailData.getDevice_gps_lng());
        String org_no = dCTrainingDetailData.getORG_NO();
        if (org_no != null) {
            sQLiteStatement.bindString(31, org_no);
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
    public DCTrainingDetailData readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        Long lValueOf2 = cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3));
        int i4 = i + 2;
        String string = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        String string2 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = cursor.getInt(i + 4);
        int i7 = i + 5;
        Date date = cursor.isNull(i7) ? null : new Date(cursor.getLong(i7));
        float f = cursor.getFloat(i + 6);
        float f2 = cursor.getFloat(i + 7);
        float f3 = cursor.getFloat(i + 8);
        float f4 = cursor.getFloat(i + 9);
        float f5 = cursor.getFloat(i + 10);
        float f6 = cursor.getFloat(i + 11);
        float f7 = cursor.getFloat(i + 12);
        float f8 = cursor.getFloat(i + 13);
        float f9 = cursor.getFloat(i + 14);
        float f10 = cursor.getFloat(i + 15);
        int i8 = i + 16;
        String string3 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 17;
        String string4 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 18;
        String string5 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = i + 30;
        return new DCTrainingDetailData(lValueOf, lValueOf2, string, string2, i6, date, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, string3, string4, string5, cursor.getFloat(i + 19), cursor.getFloat(i + 20), cursor.getFloat(i + 21), cursor.getFloat(i + 22), cursor.getFloat(i + 23), cursor.getFloat(i + 24), cursor.getFloat(i + 25), cursor.getFloat(i + 26), cursor.getFloat(i + 27), cursor.getFloat(i + 28), cursor.getFloat(i + 29), cursor.isNull(i11) ? null : cursor.getString(i11));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DCTrainingDetailData dCTrainingDetailData, int i) {
        int i2 = i + 0;
        dCTrainingDetailData.setTrainingDetailId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        dCTrainingDetailData.setTrainingId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i4 = i + 2;
        dCTrainingDetailData.setAccount(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        dCTrainingDetailData.setPassword(cursor.isNull(i5) ? null : cursor.getString(i5));
        dCTrainingDetailData.setAccount_no(cursor.getInt(i + 4));
        int i6 = i + 5;
        dCTrainingDetailData.setTraning_datetime(cursor.isNull(i6) ? null : new Date(cursor.getLong(i6)));
        dCTrainingDetailData.setD_time(cursor.getFloat(i + 6));
        dCTrainingDetailData.setD_distance(cursor.getFloat(i + 7));
        dCTrainingDetailData.setD_calories(cursor.getFloat(i + 8));
        dCTrainingDetailData.setD_hr(cursor.getFloat(i + 9));
        dCTrainingDetailData.setD_rpm(cursor.getFloat(i + 10));
        dCTrainingDetailData.setD_speed(cursor.getFloat(i + 11));
        dCTrainingDetailData.setD_watt(cursor.getFloat(i + 12));
        dCTrainingDetailData.setD_met(cursor.getFloat(i + 13));
        dCTrainingDetailData.setD_level(cursor.getFloat(i + 14));
        dCTrainingDetailData.setD_incline(cursor.getFloat(i + 15));
        int i7 = i + 16;
        dCTrainingDetailData.setTrainh_no(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 17;
        dCTrainingDetailData.setTrainh_detail_no(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 18;
        dCTrainingDetailData.setD_heart_rate_type(cursor.isNull(i9) ? null : cursor.getString(i9));
        dCTrainingDetailData.setD_fusion_interval_time(cursor.getFloat(i + 19));
        dCTrainingDetailData.setD_fusion_recovery_time(cursor.getFloat(i + 20));
        dCTrainingDetailData.setD_program_row(cursor.getFloat(i + 21));
        dCTrainingDetailData.setD_program_height(cursor.getFloat(i + 22));
        dCTrainingDetailData.setD_program_level(cursor.getFloat(i + 23));
        dCTrainingDetailData.setD_program_total_step(cursor.getFloat(i + 24));
        dCTrainingDetailData.setD_program_per_step(cursor.getFloat(i + 25));
        dCTrainingDetailData.setD_program_vert(cursor.getFloat(i + 26));
        dCTrainingDetailData.setD_program_step_height(cursor.getFloat(i + 27));
        dCTrainingDetailData.setDevice_gps_lat(cursor.getFloat(i + 28));
        dCTrainingDetailData.setDevice_gps_lng(cursor.getFloat(i + 29));
        int i10 = i + 30;
        dCTrainingDetailData.setORG_NO(cursor.isNull(i10) ? null : cursor.getString(i10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(DCTrainingDetailData dCTrainingDetailData, long j) {
        dCTrainingDetailData.setTrainingDetailId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DCTrainingDetailData dCTrainingDetailData) {
        if (dCTrainingDetailData != null) {
            return dCTrainingDetailData.getTrainingDetailId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DCTrainingDetailData dCTrainingDetailData) {
        return dCTrainingDetailData.getTrainingDetailId() != null;
    }
}
