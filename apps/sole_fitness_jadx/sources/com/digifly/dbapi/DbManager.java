package com.digifly.dbapi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.digifly.dbapi.greeddao_gen.DCProgramGoalDataDao;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.digifly.dbapi.greeddao_gen.DCTrainingDetailDataDao;
import com.digifly.dbapi.greeddao_gen.DaoMaster;
import com.digifly.dbapi.greeddao_gen.DaoSession;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;

/* loaded from: classes.dex */
public class DbManager {
    private static final String DB_NAME = "digifly.db";
    public static final boolean ENCRYPTED = true;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private static DbManager mDbManager;
    private static DaoMaster.DevOpenHelper mDevOpenHelper;
    private Context mContext;

    private DbManager(Context context) {
        this.mContext = context;
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        getDaoMaster(context);
        getDaoSession(context);
    }

    public static DbManager getInstance(Context context) {
        if (mDbManager == null) {
            synchronized (DbManager.class) {
                if (mDbManager == null) {
                    mDbManager = new DbManager(context);
                }
            }
        }
        return mDbManager;
    }

    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (mDevOpenHelper == null) {
            getInstance(context);
        }
        return mDevOpenHelper.getReadableDatabase();
    }

    public static SQLiteDatabase getWritableDatabase(Context context) {
        if (mDevOpenHelper == null) {
            getInstance(context);
        }
        return mDevOpenHelper.getWritableDatabase();
    }

    public static DaoMaster getDaoMaster(Context context) {
        if (mDaoMaster == null) {
            synchronized (DbManager.class) {
                if (mDaoMaster == null) {
                    mDaoMaster = new DaoMaster(getWritableDatabase(context));
                }
            }
        }
        return mDaoMaster;
    }

    public static DaoSession getDaoSession(Context context) {
        if (mDaoSession == null) {
            synchronized (DbManager.class) {
                mDaoSession = getDaoMaster(context).newSession();
            }
        }
        return mDaoSession;
    }

    public static MemberDataDao getMemberDataDao() {
        return mDaoSession.getMemberDataDao();
    }

    public static DCTrainingDataDao getDCTrainingDataDao() {
        return mDaoSession.getDCTrainingDataDao();
    }

    public static DCTrainingDetailDataDao getDCTrainingDetailDataDao() {
        return mDaoSession.getDCTrainingDetailDataDao();
    }

    public static DCProgramGoalDataDao getDCProgramGoalDataDao() {
        return mDaoSession.getDCProgramGoalDataDao();
    }
}
