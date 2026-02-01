package com.soletreadmills.sole_v2.ble.listener;

import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public interface UploadSummaryDataListener {
    void onNoticeUpload(ArrayList<FtmsBaseData> summaryDataList, boolean isFromSqlite, Integer entityId, String clubTicket);
}
