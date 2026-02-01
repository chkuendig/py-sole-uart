package com.soletreadmills.sole_v2._roomDataBase.bleDevice;

import com.facebook.appevents.integrity.IntegrityManager;
import java.util.List;
import kotlin.Metadata;

/* compiled from: BleDeviceInfoDao.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005H'¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH'J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH'J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\f\u001a\u00020\u000bH'J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u0012\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005H'¢\u0006\u0002\u0010\bJ\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u000e\u001a\u00020\u000bH'J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005H'¢\u0006\u0002\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_roomDataBase/bleDevice/BleDeviceInfoDao;", "", "delete", "", "bleDeviceInfoEntity", "Lcom/soletreadmills/sole_v2/_roomDataBase/bleDevice/BleDeviceInfoEntity;", "bleDeviceInfoEntities", "", "([Lcom/soletreadmills/sole_v2/_roomDataBase/bleDevice/BleDeviceInfoEntity;)V", "findByAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "", "accountNo", "findByBleName", "bleName", "getAll", "", "insert", "insertAll", "loadAllByBleName", "update", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface BleDeviceInfoDao {
    void delete(BleDeviceInfoEntity bleDeviceInfoEntity);

    void delete(BleDeviceInfoEntity... bleDeviceInfoEntities);

    BleDeviceInfoEntity findByAddress(String address, String accountNo);

    BleDeviceInfoEntity findByBleName(String bleName, String accountNo);

    List<BleDeviceInfoEntity> getAll();

    List<BleDeviceInfoEntity> getAll(String accountNo);

    void insert(BleDeviceInfoEntity bleDeviceInfoEntity);

    void insertAll(BleDeviceInfoEntity... bleDeviceInfoEntities);

    List<BleDeviceInfoEntity> loadAllByBleName(String bleName);

    void update(BleDeviceInfoEntity bleDeviceInfoEntity);

    void update(BleDeviceInfoEntity... bleDeviceInfoEntities);
}
