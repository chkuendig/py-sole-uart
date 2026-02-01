package androidx.health.platform.client.impl.internal;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.health.platform.client.impl.ipc.internal.ConnectionManager;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProviderConnectionManager.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\tH\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/health/platform/client/impl/internal/ProviderConnectionManager;", "", "()V", "instance", "Landroidx/health/platform/client/impl/ipc/internal/ConnectionManager;", "getInstance", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "startHandlerThread", "Landroid/os/Looper;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProviderConnectionManager {
    public static final ProviderConnectionManager INSTANCE = new ProviderConnectionManager();
    private static ConnectionManager instance;

    private ProviderConnectionManager() {
    }

    public final ConnectionManager getInstance(Context context) {
        ConnectionManager connectionManager;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (this) {
            if (instance == null) {
                instance = new ConnectionManager(context.getApplicationContext(), INSTANCE.startHandlerThread());
            }
            connectionManager = instance;
            Intrinsics.checkNotNull(connectionManager);
        }
        return connectionManager;
    }

    private final Looper startHandlerThread() {
        HandlerThread handlerThread = new HandlerThread("ProviderConnectionManager", 9);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "handlerThread.getLooper()");
        return looper;
    }
}
