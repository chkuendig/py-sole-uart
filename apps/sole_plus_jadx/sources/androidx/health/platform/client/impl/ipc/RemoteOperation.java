package androidx.health.platform.client.impl.ipc;

import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface RemoteOperation<S, R> {
    R execute(S s) throws RemoteException;
}
