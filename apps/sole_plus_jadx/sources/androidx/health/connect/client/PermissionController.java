package androidx.health.connect.client;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.health.connect.client.contracts.HealthPermissionsRequestContract;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionController.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0003"}, d2 = {"Landroidx/health/connect/client/PermissionController;", "", "getGrantedPermissions", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revokeAllPermissions", "", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PermissionController {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    static ActivityResultContract<Set<String>, Set<String>> createRequestPermissionResultContract() {
        return INSTANCE.createRequestPermissionResultContract();
    }

    @JvmStatic
    static ActivityResultContract<Set<String>, Set<String>> createRequestPermissionResultContract(String str) {
        return INSTANCE.createRequestPermissionResultContract(str);
    }

    Object getGrantedPermissions(Continuation<? super Set<String>> continuation);

    Object revokeAllPermissions(Continuation<? super Unit> continuation);

    /* compiled from: PermissionController.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Landroidx/health/connect/client/PermissionController$Companion;", "", "()V", "createRequestPermissionResultContract", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "providerPackageName", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @JvmStatic
        public final ActivityResultContract<Set<String>, Set<String>> createRequestPermissionResultContract() {
            return createRequestPermissionResultContract$default(this, null, 1, null);
        }

        private Companion() {
        }

        public static /* synthetic */ ActivityResultContract createRequestPermissionResultContract$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.google.android.apps.healthdata";
            }
            return companion.createRequestPermissionResultContract(str);
        }

        @JvmStatic
        public final ActivityResultContract<Set<String>, Set<String>> createRequestPermissionResultContract(String providerPackageName) {
            Intrinsics.checkNotNullParameter(providerPackageName, "providerPackageName");
            return new HealthPermissionsRequestContract(providerPackageName);
        }
    }
}
