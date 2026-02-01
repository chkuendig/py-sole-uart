package com.soletreadmills.sole_v2._roomDataBase.summaryTempData;

import java.util.List;
import kotlin.Metadata;

/* compiled from: SummaryTempDataDao.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H'J!\u0010\n\u001a\u00020\b2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\f\"\u00020\u0004H'¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H'J!\u0010\u0015\u001a\u00020\b2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\f\"\u00020\u0004H'¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H'J!\u0010\u0017\u001a\u00020\b2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\f\"\u00020\u0004H'¢\u0006\u0002\u0010\rR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/_roomDataBase/summaryTempData/SummaryTempDataDao;", "", "all", "", "Lcom/soletreadmills/sole_v2/_roomDataBase/summaryTempData/SummaryTempDataEntity;", "getAll", "()Ljava/util/List;", "delete", "", "summaryTempDataEntity", "deletes", "summaryTempDataEntities", "", "([Lcom/soletreadmills/sole_v2/_roomDataBase/summaryTempData/SummaryTempDataEntity;)V", "findById", "id", "", "findClassName", "className", "", "insert", "insertAll", "update", "updates", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SummaryTempDataDao {
    void delete(SummaryTempDataEntity summaryTempDataEntity);

    void deletes(SummaryTempDataEntity... summaryTempDataEntities);

    SummaryTempDataEntity findById(int id2);

    List<SummaryTempDataEntity> findClassName(String className);

    List<SummaryTempDataEntity> getAll();

    void insert(SummaryTempDataEntity summaryTempDataEntity);

    void insertAll(SummaryTempDataEntity... summaryTempDataEntities);

    void update(SummaryTempDataEntity summaryTempDataEntity);

    void updates(SummaryTempDataEntity... summaryTempDataEntities);
}
