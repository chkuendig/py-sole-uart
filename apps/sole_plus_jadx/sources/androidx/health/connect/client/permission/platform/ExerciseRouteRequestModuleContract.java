package androidx.health.connect.client.permission.platform;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.platform.client.impl.logger.Logger;
import androidx.health.platform.client.service.HealthDataServiceConstants;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExerciseRouteRequestModuleContract.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Landroidx/health/connect/client/permission/platform/ExerciseRouteRequestModuleContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroidx/health/connect/client/records/ExerciseRoute;", "()V", "createIntent", "Landroid/content/Intent;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExerciseRouteRequestModuleContract extends ActivityResultContract<String, ExerciseRoute> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, String input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent intent = new Intent("android.health.connect.action.REQUEST_EXERCISE_ROUTE");
        intent.putExtra("android.health.connect.extra.SESSION_ID", input);
        return intent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    public ExerciseRoute parseResult(int resultCode, Intent intent) {
        android.health.connect.datatypes.ExerciseRoute exerciseRoute = intent != null ? (android.health.connect.datatypes.ExerciseRoute) intent.getParcelableExtra(HealthDataServiceConstants.EXTRA_EXERCISE_ROUTE, android.health.connect.datatypes.ExerciseRoute.class) : null;
        if (exerciseRoute == null) {
            Logger.debug("HealthConnectClient", "No route returned.");
            return null;
        }
        Logger.debug("HealthConnectClient", "Returned a route.");
        return RecordConvertersKt.toSdkExerciseRoute(exerciseRoute);
    }
}
