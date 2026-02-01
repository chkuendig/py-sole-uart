package com.digifly.dbapi.greeddao_gen;

import com.digifly.cloudapi.data.DCProgramGoalData;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.DCTrainingDetailData;
import com.digifly.cloudapi.data.MemberData;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class DaoSession extends AbstractDaoSession {
    private final DCProgramGoalDataDao dCProgramGoalDataDao;
    private final DaoConfig dCProgramGoalDataDaoConfig;
    private final DCTrainingDataDao dCTrainingDataDao;
    private final DaoConfig dCTrainingDataDaoConfig;
    private final DCTrainingDetailDataDao dCTrainingDetailDataDao;
    private final DaoConfig dCTrainingDetailDataDaoConfig;
    private final MemberDataDao memberDataDao;
    private final DaoConfig memberDataDaoConfig;

    public DaoSession(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig daoConfigClone = map.get(DCProgramGoalDataDao.class).clone();
        this.dCProgramGoalDataDaoConfig = daoConfigClone;
        daoConfigClone.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone2 = map.get(DCTrainingDataDao.class).clone();
        this.dCTrainingDataDaoConfig = daoConfigClone2;
        daoConfigClone2.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone3 = map.get(DCTrainingDetailDataDao.class).clone();
        this.dCTrainingDetailDataDaoConfig = daoConfigClone3;
        daoConfigClone3.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone4 = map.get(MemberDataDao.class).clone();
        this.memberDataDaoConfig = daoConfigClone4;
        daoConfigClone4.initIdentityScope(identityScopeType);
        DCProgramGoalDataDao dCProgramGoalDataDao = new DCProgramGoalDataDao(daoConfigClone, this);
        this.dCProgramGoalDataDao = dCProgramGoalDataDao;
        DCTrainingDataDao dCTrainingDataDao = new DCTrainingDataDao(daoConfigClone2, this);
        this.dCTrainingDataDao = dCTrainingDataDao;
        DCTrainingDetailDataDao dCTrainingDetailDataDao = new DCTrainingDetailDataDao(daoConfigClone3, this);
        this.dCTrainingDetailDataDao = dCTrainingDetailDataDao;
        MemberDataDao memberDataDao = new MemberDataDao(daoConfigClone4, this);
        this.memberDataDao = memberDataDao;
        registerDao(DCProgramGoalData.class, dCProgramGoalDataDao);
        registerDao(DCTrainingData.class, dCTrainingDataDao);
        registerDao(DCTrainingDetailData.class, dCTrainingDetailDataDao);
        registerDao(MemberData.class, memberDataDao);
    }

    public void clear() {
        this.dCProgramGoalDataDaoConfig.clearIdentityScope();
        this.dCTrainingDataDaoConfig.clearIdentityScope();
        this.dCTrainingDetailDataDaoConfig.clearIdentityScope();
        this.memberDataDaoConfig.clearIdentityScope();
    }

    public DCProgramGoalDataDao getDCProgramGoalDataDao() {
        return this.dCProgramGoalDataDao;
    }

    public DCTrainingDataDao getDCTrainingDataDao() {
        return this.dCTrainingDataDao;
    }

    public DCTrainingDetailDataDao getDCTrainingDetailDataDao() {
        return this.dCTrainingDetailDataDao;
    }

    public MemberDataDao getMemberDataDao() {
        return this.memberDataDao;
    }
}
