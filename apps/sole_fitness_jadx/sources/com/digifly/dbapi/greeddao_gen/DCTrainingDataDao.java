package com.digifly.dbapi.greeddao_gen;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.digifly.cloudapi.data.DCTrainingData;
import com.dyaco.sole.database.MessageDB;
import com.dyaco.sole.database.WorkoutData;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class DCTrainingDataDao extends AbstractDao<DCTrainingData, Long> {
    public static final String TABLENAME = "TRAINING_DATA";

    public static class Properties {
        public static final Property TrainingId = new Property(0, Long.class, "trainingId", true, "TRAINING_ID");
        public static final Property Account = new Property(1, String.class, MessageDB.ACCOUNT, false, MessageDB.ACCOUNT);
        public static final Property Password = new Property(2, String.class, "password", false, "PASSWORD");
        public static final Property Account_no = new Property(3, Integer.TYPE, "account_no", false, "ACCOUNT_NO");
        public static final Property Training_timezone_hour = new Property(4, Integer.TYPE, "training_timezone_hour", false, "TRAINING_TIMEZONE_HOUR");
        public static final Property Training_timezone_name = new Property(5, String.class, "training_timezone_name", false, "TRAINING_TIMEZONE_NAME");
        public static final Property Brand_code = new Property(6, String.class, "brand_code", false, "BRAND_CODE");
        public static final Property Model_code = new Property(7, String.class, "model_code", false, "MODEL_CODE");
        public static final Property Category_code = new Property(8, String.class, "category_code", false, "CATEGORY_CODE");
        public static final Property Brand_type = new Property(9, String.class, "brand_type", false, "BRAND_TYPE");
        public static final Property In_out = new Property(10, String.class, "in_out", false, "IN_OUT");
        public static final Property Unit = new Property(11, String.class, "unit", false, "UNIT");
        public static final Property Sales_version = new Property(12, String.class, "sales_version", false, "SALES_VERSION");
        public static final Property Training_datetime = new Property(13, Date.class, "training_datetime", false, "TRAINING_DATETIME");
        public static final Property Program_name = new Property(14, String.class, "program_name", false, "PROGRAM_NAME");
        public static final Property ProgramNameRes = new Property(15, Integer.TYPE, "programNameRes", false, "PROGRAM_NAME_RES");
        public static final Property Goals = new Property(16, String.class, "goals", false, "GOALS");
        public static final Property Notes = new Property(17, String.class, "notes", false, "NOTES");
        public static final Property Total_time = new Property(18, Float.TYPE, "total_time", false, "TOTAL_TIME");
        public static final Property Total_distance = new Property(19, Float.TYPE, "total_distance", false, "TOTAL_DISTANCE");
        public static final Property Total_calories = new Property(20, Float.TYPE, "total_calories", false, "TOTAL_CALORIES");
        public static final Property Avg_hr = new Property(21, Float.TYPE, WorkoutData.AVG_HR, false, "AVG_HR");
        public static final Property Avg_rpm = new Property(22, Float.TYPE, WorkoutData.AVG_RPM, false, "AVG_RPM");
        public static final Property Avg_speed = new Property(23, Float.TYPE, WorkoutData.AVG_SPEED, false, "AVG_SPEED");
        public static final Property Avg_watt = new Property(24, Float.TYPE, "avg_watt", false, "AVG_WATT");
        public static final Property Avg_met = new Property(25, Float.TYPE, "avg_met", false, "AVG_MET");
        public static final Property Avg_level = new Property(26, Float.TYPE, WorkoutData.AVG_LEVEL, false, "AVG_LEVEL");
        public static final Property Avg_incline = new Property(27, Float.TYPE, "avg_incline", false, "AVG_INCLINE");
        public static final Property Trainh_no = new Property(28, String.class, "trainh_no", false, "TRAINH_NO");
        public static final Property Device_os_name = new Property(29, String.class, "device_os_name", false, "DEVICE_OS_NAME");
        public static final Property Device_os_version = new Property(30, String.class, "device_os_version", false, "DEVICE_OS_VERSION");
        public static final Property Device_model = new Property(31, String.class, "device_model", false, "DEVICE_MODEL");
        public static final Property Device_sno = new Property(32, String.class, "device_sno", false, "DEVICE_SNO");
        public static final Property Device_gps_lat = new Property(33, Float.TYPE, "device_gps_lat", false, "DEVICE_GPS_LAT");
        public static final Property Device_gps_lng = new Property(34, Float.TYPE, "device_gps_lng", false, "DEVICE_GPS_LNG");
        public static final Property Mac_address = new Property(35, String.class, "mac_address", false, "MAC_ADDRESS");
        public static final Property SportPathJsonStr = new Property(36, String.class, "sportPathJsonStr", false, "SPORT_PATH_JSON_STR");
    }

    @Override // org.greenrobot.greendao.AbstractDao
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public DCTrainingDataDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public DCTrainingDataDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"TRAINING_DATA\" (\"TRAINING_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"account\" TEXT,\"PASSWORD\" TEXT,\"ACCOUNT_NO\" INTEGER NOT NULL ,\"TRAINING_TIMEZONE_HOUR\" INTEGER NOT NULL ,\"TRAINING_TIMEZONE_NAME\" TEXT,\"BRAND_CODE\" TEXT,\"MODEL_CODE\" TEXT,\"CATEGORY_CODE\" TEXT,\"BRAND_TYPE\" TEXT,\"IN_OUT\" TEXT,\"UNIT\" TEXT,\"SALES_VERSION\" TEXT,\"TRAINING_DATETIME\" INTEGER,\"PROGRAM_NAME\" TEXT,\"PROGRAM_NAME_RES\" INTEGER NOT NULL ,\"GOALS\" TEXT,\"NOTES\" TEXT,\"TOTAL_TIME\" REAL NOT NULL ,\"TOTAL_DISTANCE\" REAL NOT NULL ,\"TOTAL_CALORIES\" REAL NOT NULL ,\"AVG_HR\" REAL NOT NULL ,\"AVG_RPM\" REAL NOT NULL ,\"AVG_SPEED\" REAL NOT NULL ,\"AVG_WATT\" REAL NOT NULL ,\"AVG_MET\" REAL NOT NULL ,\"AVG_LEVEL\" REAL NOT NULL ,\"AVG_INCLINE\" REAL NOT NULL ,\"TRAINH_NO\" TEXT,\"DEVICE_OS_NAME\" TEXT,\"DEVICE_OS_VERSION\" TEXT,\"DEVICE_MODEL\" TEXT,\"DEVICE_SNO\" TEXT,\"DEVICE_GPS_LAT\" REAL NOT NULL ,\"DEVICE_GPS_LNG\" REAL NOT NULL ,\"MAC_ADDRESS\" TEXT,\"SPORT_PATH_JSON_STR\" TEXT);");
    }

    public static void dropTable(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"TRAINING_DATA\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DCTrainingData dCTrainingData) {
        databaseStatement.clearBindings();
        Long trainingId = dCTrainingData.getTrainingId();
        if (trainingId != null) {
            databaseStatement.bindLong(1, trainingId.longValue());
        }
        String account = dCTrainingData.getAccount();
        if (account != null) {
            databaseStatement.bindString(2, account);
        }
        String password = dCTrainingData.getPassword();
        if (password != null) {
            databaseStatement.bindString(3, password);
        }
        databaseStatement.bindLong(4, dCTrainingData.getAccount_no());
        databaseStatement.bindLong(5, dCTrainingData.getTraining_timezone_hour());
        String training_timezone_name = dCTrainingData.getTraining_timezone_name();
        if (training_timezone_name != null) {
            databaseStatement.bindString(6, training_timezone_name);
        }
        String brand_code = dCTrainingData.getBrand_code();
        if (brand_code != null) {
            databaseStatement.bindString(7, brand_code);
        }
        String model_code = dCTrainingData.getModel_code();
        if (model_code != null) {
            databaseStatement.bindString(8, model_code);
        }
        String category_code = dCTrainingData.getCategory_code();
        if (category_code != null) {
            databaseStatement.bindString(9, category_code);
        }
        String brand_type = dCTrainingData.getBrand_type();
        if (brand_type != null) {
            databaseStatement.bindString(10, brand_type);
        }
        String in_out = dCTrainingData.getIn_out();
        if (in_out != null) {
            databaseStatement.bindString(11, in_out);
        }
        String unit = dCTrainingData.getUnit();
        if (unit != null) {
            databaseStatement.bindString(12, unit);
        }
        String sales_version = dCTrainingData.getSales_version();
        if (sales_version != null) {
            databaseStatement.bindString(13, sales_version);
        }
        Date training_datetime = dCTrainingData.getTraining_datetime();
        if (training_datetime != null) {
            databaseStatement.bindLong(14, training_datetime.getTime());
        }
        String program_name = dCTrainingData.getProgram_name();
        if (program_name != null) {
            databaseStatement.bindString(15, program_name);
        }
        databaseStatement.bindLong(16, dCTrainingData.getProgramNameRes());
        String goals = dCTrainingData.getGoals();
        if (goals != null) {
            databaseStatement.bindString(17, goals);
        }
        String notes = dCTrainingData.getNotes();
        if (notes != null) {
            databaseStatement.bindString(18, notes);
        }
        databaseStatement.bindDouble(19, dCTrainingData.getTotal_time());
        databaseStatement.bindDouble(20, dCTrainingData.getTotal_distance());
        databaseStatement.bindDouble(21, dCTrainingData.getTotal_calories());
        databaseStatement.bindDouble(22, dCTrainingData.getAvg_hr());
        databaseStatement.bindDouble(23, dCTrainingData.getAvg_rpm());
        databaseStatement.bindDouble(24, dCTrainingData.getAvg_speed());
        databaseStatement.bindDouble(25, dCTrainingData.getAvg_watt());
        databaseStatement.bindDouble(26, dCTrainingData.getAvg_met());
        databaseStatement.bindDouble(27, dCTrainingData.getAvg_level());
        databaseStatement.bindDouble(28, dCTrainingData.getAvg_incline());
        String trainh_no = dCTrainingData.getTrainh_no();
        if (trainh_no != null) {
            databaseStatement.bindString(29, trainh_no);
        }
        String device_os_name = dCTrainingData.getDevice_os_name();
        if (device_os_name != null) {
            databaseStatement.bindString(30, device_os_name);
        }
        String device_os_version = dCTrainingData.getDevice_os_version();
        if (device_os_version != null) {
            databaseStatement.bindString(31, device_os_version);
        }
        String device_model = dCTrainingData.getDevice_model();
        if (device_model != null) {
            databaseStatement.bindString(32, device_model);
        }
        String device_sno = dCTrainingData.getDevice_sno();
        if (device_sno != null) {
            databaseStatement.bindString(33, device_sno);
        }
        databaseStatement.bindDouble(34, dCTrainingData.getDevice_gps_lat());
        databaseStatement.bindDouble(35, dCTrainingData.getDevice_gps_lng());
        String mac_address = dCTrainingData.getMac_address();
        if (mac_address != null) {
            databaseStatement.bindString(36, mac_address);
        }
        String sportPathJsonStr = dCTrainingData.getSportPathJsonStr();
        if (sportPathJsonStr != null) {
            databaseStatement.bindString(37, sportPathJsonStr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DCTrainingData dCTrainingData) {
        sQLiteStatement.clearBindings();
        Long trainingId = dCTrainingData.getTrainingId();
        if (trainingId != null) {
            sQLiteStatement.bindLong(1, trainingId.longValue());
        }
        String account = dCTrainingData.getAccount();
        if (account != null) {
            sQLiteStatement.bindString(2, account);
        }
        String password = dCTrainingData.getPassword();
        if (password != null) {
            sQLiteStatement.bindString(3, password);
        }
        sQLiteStatement.bindLong(4, dCTrainingData.getAccount_no());
        sQLiteStatement.bindLong(5, dCTrainingData.getTraining_timezone_hour());
        String training_timezone_name = dCTrainingData.getTraining_timezone_name();
        if (training_timezone_name != null) {
            sQLiteStatement.bindString(6, training_timezone_name);
        }
        String brand_code = dCTrainingData.getBrand_code();
        if (brand_code != null) {
            sQLiteStatement.bindString(7, brand_code);
        }
        String model_code = dCTrainingData.getModel_code();
        if (model_code != null) {
            sQLiteStatement.bindString(8, model_code);
        }
        String category_code = dCTrainingData.getCategory_code();
        if (category_code != null) {
            sQLiteStatement.bindString(9, category_code);
        }
        String brand_type = dCTrainingData.getBrand_type();
        if (brand_type != null) {
            sQLiteStatement.bindString(10, brand_type);
        }
        String in_out = dCTrainingData.getIn_out();
        if (in_out != null) {
            sQLiteStatement.bindString(11, in_out);
        }
        String unit = dCTrainingData.getUnit();
        if (unit != null) {
            sQLiteStatement.bindString(12, unit);
        }
        String sales_version = dCTrainingData.getSales_version();
        if (sales_version != null) {
            sQLiteStatement.bindString(13, sales_version);
        }
        Date training_datetime = dCTrainingData.getTraining_datetime();
        if (training_datetime != null) {
            sQLiteStatement.bindLong(14, training_datetime.getTime());
        }
        String program_name = dCTrainingData.getProgram_name();
        if (program_name != null) {
            sQLiteStatement.bindString(15, program_name);
        }
        sQLiteStatement.bindLong(16, dCTrainingData.getProgramNameRes());
        String goals = dCTrainingData.getGoals();
        if (goals != null) {
            sQLiteStatement.bindString(17, goals);
        }
        String notes = dCTrainingData.getNotes();
        if (notes != null) {
            sQLiteStatement.bindString(18, notes);
        }
        sQLiteStatement.bindDouble(19, dCTrainingData.getTotal_time());
        sQLiteStatement.bindDouble(20, dCTrainingData.getTotal_distance());
        sQLiteStatement.bindDouble(21, dCTrainingData.getTotal_calories());
        sQLiteStatement.bindDouble(22, dCTrainingData.getAvg_hr());
        sQLiteStatement.bindDouble(23, dCTrainingData.getAvg_rpm());
        sQLiteStatement.bindDouble(24, dCTrainingData.getAvg_speed());
        sQLiteStatement.bindDouble(25, dCTrainingData.getAvg_watt());
        sQLiteStatement.bindDouble(26, dCTrainingData.getAvg_met());
        sQLiteStatement.bindDouble(27, dCTrainingData.getAvg_level());
        sQLiteStatement.bindDouble(28, dCTrainingData.getAvg_incline());
        String trainh_no = dCTrainingData.getTrainh_no();
        if (trainh_no != null) {
            sQLiteStatement.bindString(29, trainh_no);
        }
        String device_os_name = dCTrainingData.getDevice_os_name();
        if (device_os_name != null) {
            sQLiteStatement.bindString(30, device_os_name);
        }
        String device_os_version = dCTrainingData.getDevice_os_version();
        if (device_os_version != null) {
            sQLiteStatement.bindString(31, device_os_version);
        }
        String device_model = dCTrainingData.getDevice_model();
        if (device_model != null) {
            sQLiteStatement.bindString(32, device_model);
        }
        String device_sno = dCTrainingData.getDevice_sno();
        if (device_sno != null) {
            sQLiteStatement.bindString(33, device_sno);
        }
        sQLiteStatement.bindDouble(34, dCTrainingData.getDevice_gps_lat());
        sQLiteStatement.bindDouble(35, dCTrainingData.getDevice_gps_lng());
        String mac_address = dCTrainingData.getMac_address();
        if (mac_address != null) {
            sQLiteStatement.bindString(36, mac_address);
        }
        String sportPathJsonStr = dCTrainingData.getSportPathJsonStr();
        if (sportPathJsonStr != null) {
            sQLiteStatement.bindString(37, sportPathJsonStr);
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
    public DCTrainingData readEntity(Cursor cursor, int i) {
        String str;
        Date date;
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = cursor.getInt(i + 3);
        int i6 = cursor.getInt(i + 4);
        int i7 = i + 5;
        String string3 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 6;
        String string4 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 7;
        String string5 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 8;
        String string6 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = i + 9;
        String string7 = cursor.isNull(i11) ? null : cursor.getString(i11);
        int i12 = i + 10;
        String string8 = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = i + 11;
        String string9 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i + 12;
        String string10 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i + 13;
        if (cursor.isNull(i15)) {
            str = string10;
            date = null;
        } else {
            str = string10;
            date = new Date(cursor.getLong(i15));
        }
        int i16 = i + 14;
        String string11 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = cursor.getInt(i + 15);
        int i18 = i + 16;
        String string12 = cursor.isNull(i18) ? null : cursor.getString(i18);
        int i19 = i + 17;
        String string13 = cursor.isNull(i19) ? null : cursor.getString(i19);
        float f = cursor.getFloat(i + 18);
        float f2 = cursor.getFloat(i + 19);
        float f3 = cursor.getFloat(i + 20);
        float f4 = cursor.getFloat(i + 21);
        float f5 = cursor.getFloat(i + 22);
        float f6 = cursor.getFloat(i + 23);
        float f7 = cursor.getFloat(i + 24);
        float f8 = cursor.getFloat(i + 25);
        float f9 = cursor.getFloat(i + 26);
        float f10 = cursor.getFloat(i + 27);
        int i20 = i + 28;
        String string14 = cursor.isNull(i20) ? null : cursor.getString(i20);
        int i21 = i + 29;
        String string15 = cursor.isNull(i21) ? null : cursor.getString(i21);
        int i22 = i + 30;
        String string16 = cursor.isNull(i22) ? null : cursor.getString(i22);
        int i23 = i + 31;
        String string17 = cursor.isNull(i23) ? null : cursor.getString(i23);
        int i24 = i + 32;
        String string18 = cursor.isNull(i24) ? null : cursor.getString(i24);
        float f11 = cursor.getFloat(i + 33);
        float f12 = cursor.getFloat(i + 34);
        int i25 = i + 35;
        String string19 = cursor.isNull(i25) ? null : cursor.getString(i25);
        int i26 = i + 36;
        return new DCTrainingData(lValueOf, string, string2, i5, i6, string3, string4, string5, string6, string7, string8, string9, str, date, string11, i17, string12, string13, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, string14, string15, string16, string17, string18, f11, f12, string19, cursor.isNull(i26) ? null : cursor.getString(i26));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DCTrainingData dCTrainingData, int i) {
        int i2 = i + 0;
        dCTrainingData.setTrainingId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        dCTrainingData.setAccount(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        dCTrainingData.setPassword(cursor.isNull(i4) ? null : cursor.getString(i4));
        dCTrainingData.setAccount_no(cursor.getInt(i + 3));
        dCTrainingData.setTraining_timezone_hour(cursor.getInt(i + 4));
        int i5 = i + 5;
        dCTrainingData.setTraining_timezone_name(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 6;
        dCTrainingData.setBrand_code(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 7;
        dCTrainingData.setModel_code(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 8;
        dCTrainingData.setCategory_code(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 9;
        dCTrainingData.setBrand_type(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 10;
        dCTrainingData.setIn_out(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 11;
        dCTrainingData.setUnit(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 12;
        dCTrainingData.setSales_version(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 13;
        dCTrainingData.setTraining_datetime(cursor.isNull(i13) ? null : new Date(cursor.getLong(i13)));
        int i14 = i + 14;
        dCTrainingData.setProgram_name(cursor.isNull(i14) ? null : cursor.getString(i14));
        dCTrainingData.setProgramNameRes(cursor.getInt(i + 15));
        int i15 = i + 16;
        dCTrainingData.setGoals(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i + 17;
        dCTrainingData.setNotes(cursor.isNull(i16) ? null : cursor.getString(i16));
        dCTrainingData.setTotal_time(cursor.getFloat(i + 18));
        dCTrainingData.setTotal_distance(cursor.getFloat(i + 19));
        dCTrainingData.setTotal_calories(cursor.getFloat(i + 20));
        dCTrainingData.setAvg_hr(cursor.getFloat(i + 21));
        dCTrainingData.setAvg_rpm(cursor.getFloat(i + 22));
        dCTrainingData.setAvg_speed(cursor.getFloat(i + 23));
        dCTrainingData.setAvg_watt(cursor.getFloat(i + 24));
        dCTrainingData.setAvg_met(cursor.getFloat(i + 25));
        dCTrainingData.setAvg_level(cursor.getFloat(i + 26));
        dCTrainingData.setAvg_incline(cursor.getFloat(i + 27));
        int i17 = i + 28;
        dCTrainingData.setTrainh_no(cursor.isNull(i17) ? null : cursor.getString(i17));
        int i18 = i + 29;
        dCTrainingData.setDevice_os_name(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i + 30;
        dCTrainingData.setDevice_os_version(cursor.isNull(i19) ? null : cursor.getString(i19));
        int i20 = i + 31;
        dCTrainingData.setDevice_model(cursor.isNull(i20) ? null : cursor.getString(i20));
        int i21 = i + 32;
        dCTrainingData.setDevice_sno(cursor.isNull(i21) ? null : cursor.getString(i21));
        dCTrainingData.setDevice_gps_lat(cursor.getFloat(i + 33));
        dCTrainingData.setDevice_gps_lng(cursor.getFloat(i + 34));
        int i22 = i + 35;
        dCTrainingData.setMac_address(cursor.isNull(i22) ? null : cursor.getString(i22));
        int i23 = i + 36;
        dCTrainingData.setSportPathJsonStr(cursor.isNull(i23) ? null : cursor.getString(i23));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(DCTrainingData dCTrainingData, long j) {
        dCTrainingData.setTrainingId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DCTrainingData dCTrainingData) {
        if (dCTrainingData != null) {
            return dCTrainingData.getTrainingId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DCTrainingData dCTrainingData) {
        return dCTrainingData.getTrainingId() != null;
    }
}
