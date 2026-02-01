package com.ua.sdk.remoteconnection;

import com.ua.sdk.Entity;
import java.util.Date;

/* loaded from: classes2.dex */
public interface RemoteConnection extends Entity {
    Date getCreatedDateTime();

    Date getLastSyncTime();

    String getType();

    void setCreatedDateTime(Date date);

    void setLastSyncTime(Date date);

    void setType(String str);
}
