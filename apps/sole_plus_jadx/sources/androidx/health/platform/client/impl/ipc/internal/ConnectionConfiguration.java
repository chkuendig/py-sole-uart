package androidx.health.platform.client.impl.ipc.internal;

import com.google.common.base.Preconditions;

/* loaded from: classes2.dex */
public final class ConnectionConfiguration {
    private final String mBindAction;
    private final String mClientName;
    private final String mPackageName;
    private final QueueOperation mRefreshVersionOperation;

    public ConnectionConfiguration(String str, String str2, String str3, QueueOperation queueOperation) {
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mClientName = (String) Preconditions.checkNotNull(str2);
        this.mBindAction = (String) Preconditions.checkNotNull(str3);
        this.mRefreshVersionOperation = (QueueOperation) Preconditions.checkNotNull(queueOperation);
    }

    String getKey() {
        return String.format("%s#%s#%s", this.mClientName, this.mPackageName, this.mBindAction);
    }

    String getClientName() {
        return this.mClientName;
    }

    String getBindAction() {
        return this.mBindAction;
    }

    String getPackageName() {
        return this.mPackageName;
    }

    QueueOperation getRefreshVersionOperation() {
        return this.mRefreshVersionOperation;
    }
}
