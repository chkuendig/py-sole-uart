package androidx.health.connect.client.impl.platform;

import android.health.connect.HealthConnectException;
import android.os.RemoteException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionConverter.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"toKtException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Landroid/health/connect/HealthConnectException;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExceptionConverterKt {
    public static final Exception toKtException(HealthConnectException healthConnectException) {
        Intrinsics.checkNotNullParameter(healthConnectException, "<this>");
        int errorCode = healthConnectException.getErrorCode();
        if (errorCode == 3) {
            return new IllegalArgumentException(healthConnectException);
        }
        if (errorCode == 4) {
            return new IOException(healthConnectException);
        }
        if (errorCode == 5) {
            return new SecurityException(healthConnectException);
        }
        if (errorCode == 6) {
            return new RemoteException(healthConnectException.getMessage());
        }
        return new IllegalStateException(healthConnectException);
    }
}
