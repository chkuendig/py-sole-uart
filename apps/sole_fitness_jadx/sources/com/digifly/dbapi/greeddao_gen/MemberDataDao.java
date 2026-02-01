package com.digifly.dbapi.greeddao_gen;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.digifly.cloudapi.data.MemberData;
import com.dyaco.sole.database.MessageDB;
import com.dyaco.sole.database.UserData;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class MemberDataDao extends AbstractDao<MemberData, Long> {
    public static final String TABLENAME = "MEMBER_DATA";

    public static class Properties {
        public static final Property MemberId = new Property(0, Long.class, "memberId", true, "MEMBER_ID");
        public static final Property Account = new Property(1, String.class, MessageDB.ACCOUNT, false, "ACCOUNT");
        public static final Property Password = new Property(2, String.class, "password", false, "PASSWORD");
        public static final Property Account_no = new Property(3, Integer.TYPE, "account_no", false, "ACCOUNT_NO");
        public static final Property Name = new Property(4, String.class, "name", false, "NAME");
        public static final Property Email = new Property(5, String.class, "email", false, "EMAIL");
        public static final Property Sex = new Property(6, String.class, "sex", false, "SEX");
        public static final Property Height = new Property(7, Integer.TYPE, "height", false, "HEIGHT");
        public static final Property Weight = new Property(8, Integer.TYPE, UserData.WEIGHT, false, "WEIGHT");
        public static final Property Birthday = new Property(9, String.class, "birthday", false, "BIRTHDAY");
        public static final Property Regist_type = new Property(10, String.class, "regist_type", false, "REGIST_TYPE");
        public static final Property Unit_type = new Property(11, String.class, "unit_type", false, "UNIT_TYPE");
        public static final Property ORG_NO = new Property(12, String.class, "ORG_NO", false, "ORG__NO");
    }

    @Override // org.greenrobot.greendao.AbstractDao
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public MemberDataDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public MemberDataDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"MEMBER_DATA\" (\"MEMBER_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ACCOUNT\" TEXT,\"PASSWORD\" TEXT,\"ACCOUNT_NO\" INTEGER NOT NULL ,\"NAME\" TEXT,\"EMAIL\" TEXT,\"SEX\" TEXT,\"HEIGHT\" INTEGER NOT NULL ,\"WEIGHT\" INTEGER NOT NULL ,\"BIRTHDAY\" TEXT,\"REGIST_TYPE\" TEXT,\"UNIT_TYPE\" TEXT,\"ORG__NO\" TEXT);");
    }

    public static void dropTable(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"MEMBER_DATA\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, MemberData memberData) {
        databaseStatement.clearBindings();
        Long memberId = memberData.getMemberId();
        if (memberId != null) {
            databaseStatement.bindLong(1, memberId.longValue());
        }
        String account = memberData.getAccount();
        if (account != null) {
            databaseStatement.bindString(2, account);
        }
        String password = memberData.getPassword();
        if (password != null) {
            databaseStatement.bindString(3, password);
        }
        databaseStatement.bindLong(4, memberData.getAccount_no());
        String name = memberData.getName();
        if (name != null) {
            databaseStatement.bindString(5, name);
        }
        String email = memberData.getEmail();
        if (email != null) {
            databaseStatement.bindString(6, email);
        }
        String sex = memberData.getSex();
        if (sex != null) {
            databaseStatement.bindString(7, sex);
        }
        databaseStatement.bindLong(8, memberData.getHeight());
        databaseStatement.bindLong(9, memberData.getWeight());
        String birthday = memberData.getBirthday();
        if (birthday != null) {
            databaseStatement.bindString(10, birthday);
        }
        String regist_type = memberData.getRegist_type();
        if (regist_type != null) {
            databaseStatement.bindString(11, regist_type);
        }
        String unit_type = memberData.getUnit_type();
        if (unit_type != null) {
            databaseStatement.bindString(12, unit_type);
        }
        String org_no = memberData.getORG_NO();
        if (org_no != null) {
            databaseStatement.bindString(13, org_no);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, MemberData memberData) {
        sQLiteStatement.clearBindings();
        Long memberId = memberData.getMemberId();
        if (memberId != null) {
            sQLiteStatement.bindLong(1, memberId.longValue());
        }
        String account = memberData.getAccount();
        if (account != null) {
            sQLiteStatement.bindString(2, account);
        }
        String password = memberData.getPassword();
        if (password != null) {
            sQLiteStatement.bindString(3, password);
        }
        sQLiteStatement.bindLong(4, memberData.getAccount_no());
        String name = memberData.getName();
        if (name != null) {
            sQLiteStatement.bindString(5, name);
        }
        String email = memberData.getEmail();
        if (email != null) {
            sQLiteStatement.bindString(6, email);
        }
        String sex = memberData.getSex();
        if (sex != null) {
            sQLiteStatement.bindString(7, sex);
        }
        sQLiteStatement.bindLong(8, memberData.getHeight());
        sQLiteStatement.bindLong(9, memberData.getWeight());
        String birthday = memberData.getBirthday();
        if (birthday != null) {
            sQLiteStatement.bindString(10, birthday);
        }
        String regist_type = memberData.getRegist_type();
        if (regist_type != null) {
            sQLiteStatement.bindString(11, regist_type);
        }
        String unit_type = memberData.getUnit_type();
        if (unit_type != null) {
            sQLiteStatement.bindString(12, unit_type);
        }
        String org_no = memberData.getORG_NO();
        if (org_no != null) {
            sQLiteStatement.bindString(13, org_no);
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
    public MemberData readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        int i3 = i + 1;
        int i4 = i + 2;
        int i5 = i + 4;
        int i6 = i + 5;
        int i7 = i + 6;
        int i8 = i + 9;
        int i9 = i + 10;
        int i10 = i + 11;
        int i11 = i + 12;
        return new MemberData(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.getInt(i + 3), cursor.isNull(i5) ? null : cursor.getString(i5), cursor.isNull(i6) ? null : cursor.getString(i6), cursor.isNull(i7) ? null : cursor.getString(i7), cursor.getInt(i + 7), cursor.getInt(i + 8), cursor.isNull(i8) ? null : cursor.getString(i8), cursor.isNull(i9) ? null : cursor.getString(i9), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, MemberData memberData, int i) {
        int i2 = i + 0;
        memberData.setMemberId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        memberData.setAccount(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        memberData.setPassword(cursor.isNull(i4) ? null : cursor.getString(i4));
        memberData.setAccount_no(cursor.getInt(i + 3));
        int i5 = i + 4;
        memberData.setName(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 5;
        memberData.setEmail(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 6;
        memberData.setSex(cursor.isNull(i7) ? null : cursor.getString(i7));
        memberData.setHeight(cursor.getInt(i + 7));
        memberData.setWeight(cursor.getInt(i + 8));
        int i8 = i + 9;
        memberData.setBirthday(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 10;
        memberData.setRegist_type(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 11;
        memberData.setUnit_type(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 12;
        memberData.setORG_NO(cursor.isNull(i11) ? null : cursor.getString(i11));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(MemberData memberData, long j) {
        memberData.setMemberId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(MemberData memberData) {
        if (memberData != null) {
            return memberData.getMemberId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(MemberData memberData) {
        return memberData.getMemberId() != null;
    }
}
