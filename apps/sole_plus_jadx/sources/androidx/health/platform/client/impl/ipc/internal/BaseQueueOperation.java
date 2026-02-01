package androidx.health.platform.client.impl.ipc.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.common.base.Preconditions;

/* loaded from: classes2.dex */
public class BaseQueueOperation implements QueueOperation {
    private final ConnectionConfiguration mConnectionConfiguration;

    @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
    public void execute(IBinder iBinder) throws RemoteException {
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
    public void setException(Throwable th) {
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
    public QueueOperation trackExecution(ExecutionTracker executionTracker) {
        return this;
    }

    public BaseQueueOperation(ConnectionConfiguration connectionConfiguration) {
        this.mConnectionConfiguration = (ConnectionConfiguration) Preconditions.checkNotNull(connectionConfiguration);
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
    public ConnectionConfiguration getConnectionConfiguration() {
        return this.mConnectionConfiguration;
    }
}
