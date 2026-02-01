package androidx.health.platform.client.impl.sdkservice;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import androidx.health.platform.client.impl.permission.foregroundstate.ForegroundStateChecker;
import androidx.health.platform.client.impl.permission.token.PermissionTokenManager;
import androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* loaded from: classes2.dex */
final class HealthDataSdkServiceStubImpl extends IHealthDataSdkService.Stub {
    static final String ALLOWED_PACKAGE_NAME = "com.google.android.apps.healthdata";
    private static final String TAG = "HealthDataSdkServiceStubImpl";
    private final Context mContext;
    private final Executor mExecutor;

    HealthDataSdkServiceStubImpl(Context context, Executor executor) {
        this.mContext = context;
        this.mExecutor = executor;
    }

    @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
    public void setPermissionToken(String str, final String str2, final ISetPermissionTokenCallback iSetPermissionTokenCallback) {
        verifyPackageName(str);
        this.mExecutor.execute(new Runnable() { // from class: androidx.health.platform.client.impl.sdkservice.HealthDataSdkServiceStubImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m7584x8abba3dc(str2, iSetPermissionTokenCallback);
            }
        });
    }

    /* renamed from: lambda$setPermissionToken$0$androidx-health-platform-client-impl-sdkservice-HealthDataSdkServiceStubImpl, reason: not valid java name */
    /* synthetic */ void m7584x8abba3dc(String str, ISetPermissionTokenCallback iSetPermissionTokenCallback) {
        PermissionTokenManager.setCurrentToken(this.mContext, str);
        try {
            iSetPermissionTokenCallback.onSuccess();
        } catch (RemoteException e) {
            Log.e(TAG, String.format("HealthDataSdkService#setPermissionToken failed: %s", e.getMessage()));
        }
    }

    @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
    public void getPermissionToken(String str, final IGetPermissionTokenCallback iGetPermissionTokenCallback) {
        verifyPackageName(str);
        this.mExecutor.execute(new Runnable() { // from class: androidx.health.platform.client.impl.sdkservice.HealthDataSdkServiceStubImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m7583x6726856f(iGetPermissionTokenCallback);
            }
        });
    }

    /* renamed from: lambda$getPermissionToken$1$androidx-health-platform-client-impl-sdkservice-HealthDataSdkServiceStubImpl, reason: not valid java name */
    /* synthetic */ void m7583x6726856f(IGetPermissionTokenCallback iGetPermissionTokenCallback) {
        try {
            String currentToken = PermissionTokenManager.getCurrentToken(this.mContext);
            if (currentToken == null) {
                currentToken = "";
            }
            iGetPermissionTokenCallback.onSuccess(currentToken);
        } catch (RemoteException e) {
            Log.e(TAG, String.format("HealthDataSdkService#getPermissionToken failed: %s", e.getMessage()));
        }
    }

    @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
    public void getIsInForeground(String str, final IGetIsInForegroundCallback iGetIsInForegroundCallback) {
        verifyPackageName(str);
        this.mExecutor.execute(new Runnable() { // from class: androidx.health.platform.client.impl.sdkservice.HealthDataSdkServiceStubImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                HealthDataSdkServiceStubImpl.lambda$getIsInForeground$2(iGetIsInForegroundCallback);
            }
        });
    }

    static /* synthetic */ void lambda$getIsInForeground$2(IGetIsInForegroundCallback iGetIsInForegroundCallback) {
        try {
            iGetIsInForegroundCallback.onSuccess(ForegroundStateChecker.isInForeground());
        } catch (RemoteException e) {
            Log.e(TAG, String.format("HealthDataSdkService#getIsInForeground failed: %s", e.getMessage()));
        }
    }

    private void verifyPackageName(final String str) {
        String[] packagesForUid = this.mContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (str != null && packagesForUid != null) {
            Stream stream = Arrays.stream(packagesForUid);
            Objects.requireNonNull(str);
            if (!stream.noneMatch(new Predicate() { // from class: androidx.health.platform.client.impl.sdkservice.HealthDataSdkServiceStubImpl$$ExternalSyntheticLambda3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return str.equals((String) obj);
                }
            })) {
                if (!"com.google.android.apps.healthdata".equals(str)) {
                    throw new SecurityException("Not allowed!");
                }
                return;
            }
        }
        throw new SecurityException("Invalid package name!");
    }
}
