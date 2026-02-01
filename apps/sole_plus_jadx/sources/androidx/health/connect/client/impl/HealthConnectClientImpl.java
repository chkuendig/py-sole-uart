package androidx.health.connect.client.impl;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import androidx.exifinterface.media.ExifInterface;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.HealthConnectFeatures;
import androidx.health.connect.client.PermissionController;
import androidx.health.connect.client.feature.HealthConnectFeaturesApkImpl;
import androidx.health.connect.client.feature.HealthConnectFeaturesUnavailableImpl;
import androidx.health.connect.client.records.Record;
import androidx.health.platform.client.HealthDataAsyncClient;
import androidx.health.platform.client.HealthDataService;
import com.android.SdkConstants;
import com.sun.jna.platform.win32.WinError;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthConnectClientImpl.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00182\u0006\u0010\u0014\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ&\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J:\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00182\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0096@¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u000200H\u0096@¢\u0006\u0002\u00101J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u000603H\u0096@¢\u0006\u0002\u00104J\u001c\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00020$0\u0018H\u0096@¢\u0006\u0002\u00108J4\u00109\u001a\b\u0012\u0004\u0012\u0002H;0:\"\b\b\u0000\u0010;*\u00020$2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H;0#2\u0006\u0010<\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010=J,\u0010>\u001a\b\u0012\u0004\u0012\u0002H;0?\"\b\b\u0000\u0010;*\u00020$2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H;0@H\u0096@¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u00020!H\u0096@¢\u0006\u0002\u00104J\u001c\u0010C\u001a\u00020!2\f\u00107\u001a\b\u0012\u0004\u0012\u00020$0\u0018H\u0096@¢\u0006\u0002\u00108J\"\u0010D\u001a\u0002H;\"\u0004\b\u0000\u0010;2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002H;0FH\u0082\b¢\u0006\u0002\u0010GR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006H"}, d2 = {"Landroidx/health/connect/client/impl/HealthConnectClientImpl;", "Landroidx/health/connect/client/HealthConnectClient;", "Landroidx/health/connect/client/PermissionController;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "providerPackageName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "delegate", "Landroidx/health/platform/client/HealthDataAsyncClient;", "features", "Landroidx/health/connect/client/HealthConnectFeatures;", "(Landroidx/health/platform/client/HealthDataAsyncClient;Landroidx/health/connect/client/HealthConnectFeatures;)V", "getFeatures", "()Landroidx/health/connect/client/HealthConnectFeatures;", "permissionController", "getPermissionController", "()Landroidx/health/connect/client/PermissionController;", "aggregate", "Landroidx/health/connect/client/aggregate/AggregationResult;", "request", "Landroidx/health/connect/client/request/AggregateRequest;", "(Landroidx/health/connect/client/request/AggregateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateGroupByDuration", "", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "(Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateGroupByPeriod", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "(Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecords", "", "recordType", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordIdsList", "clientRecordIdsList", "(Lkotlin/reflect/KClass;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChanges", "Landroidx/health/connect/client/response/ChangesResponse;", "changesToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChangesToken", "Landroidx/health/connect/client/request/ChangesTokenRequest;", "(Landroidx/health/connect/client/request/ChangesTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGrantedPermissions", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRecords", "Landroidx/health/connect/client/response/InsertRecordsResponse;", "records", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecord", "Landroidx/health/connect/client/response/ReadRecordResponse;", ExifInterface.GPS_DIRECTION_TRUE, "recordId", "(Lkotlin/reflect/KClass;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecords", "Landroidx/health/connect/client/response/ReadRecordsResponse;", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "(Landroidx/health/connect/client/request/ReadRecordsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revokeAllPermissions", "updateRecords", "wrapRemoteException", "function", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HealthConnectClientImpl implements HealthConnectClient, PermissionController {
    private final HealthDataAsyncClient delegate;
    private final HealthConnectFeatures features;

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {}, l = {235}, m = "aggregate", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$aggregate$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.aggregate(null, this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {}, l = {245}, m = "aggregateGroupByDuration", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$aggregateGroupByDuration$1, reason: invalid class name and case insensitive filesystem */
    static final class C07721 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07721(Continuation<? super C07721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.aggregateGroupByDuration(null, this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {}, l = {257}, m = "aggregateGroupByPeriod", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$aggregateGroupByPeriod$1, reason: invalid class name and case insensitive filesystem */
    static final class C07731 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07731(Continuation<? super C07731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.aggregateGroupByPeriod(null, this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {0, 0}, l = {146}, m = "deleteRecords", n = {"recordIdsList", "clientRecordIdsList"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$deleteRecords$1, reason: invalid class name and case insensitive filesystem */
    static final class C07741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C07741(Continuation<? super C07741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.deleteRecords(null, null, null, this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {}, l = {161}, m = "deleteRecords", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$deleteRecords$3, reason: invalid class name */
    static final class AnonymousClass3 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.deleteRecords(null, null, this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {0}, l = {WinError.ERROR_INVALID_SIGNAL_NUMBER}, m = "getChanges", n = {"changesToken"}, s = {"L$0"})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$getChanges$1, reason: invalid class name and case insensitive filesystem */
    static final class C07751 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07751(Continuation<? super C07751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.getChanges(null, this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {}, l = {194}, m = "getChangesToken", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$getChangesToken$1, reason: invalid class name and case insensitive filesystem */
    static final class C07761 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07761(Continuation<? super C07761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.getChangesToken(null, this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {}, l = {103}, m = "getGrantedPermissions", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$getGrantedPermissions$1, reason: invalid class name and case insensitive filesystem */
    static final class C07771 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07771(Continuation<? super C07771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.getGrantedPermissions(this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {0}, l = {124}, m = "insertRecords", n = {"records"}, s = {"L$0"})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$insertRecords$1, reason: invalid class name and case insensitive filesystem */
    static final class C07781 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07781(Continuation<? super C07781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.insertRecords(null, this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {0}, l = {172}, m = "readRecord", n = {"recordId"}, s = {"L$0"})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$readRecord$1, reason: invalid class name and case insensitive filesystem */
    static final class C07791<T extends Record> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07791(Continuation<? super C07791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.readRecord(null, null, this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {}, l = {227}, m = "readRecords", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$readRecords$1, reason: invalid class name and case insensitive filesystem */
    static final class C07801<T extends Record> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07801(Continuation<? super C07801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.readRecords(null, this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {}, l = {115}, m = "revokeAllPermissions", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$revokeAllPermissions$1, reason: invalid class name and case insensitive filesystem */
    static final class C07811 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07811(Continuation<? super C07811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.revokeAllPermissions(this);
        }
    }

    /* compiled from: HealthConnectClientImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", i = {0}, l = {131}, m = "updateRecords", n = {"records"}, s = {"L$0"})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$updateRecords$1, reason: invalid class name and case insensitive filesystem */
    static final class C07821 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07821(Continuation<? super C07821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.updateRecords(null, this);
        }
    }

    public HealthConnectClientImpl(HealthDataAsyncClient delegate, HealthConnectFeatures features) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(features, "features");
        this.delegate = delegate;
        this.features = features;
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public HealthConnectFeatures getFeatures() {
        return this.features;
    }

    public HealthConnectClientImpl(Context context, String providerPackageName) {
        HealthConnectFeaturesUnavailableImpl healthConnectFeaturesApkImpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerPackageName, "providerPackageName");
        HealthDataAsyncClient client = HealthDataService.INSTANCE.getClient(context, providerPackageName);
        if (Intrinsics.areEqual(providerPackageName, "com.google.android.apps.healthdata")) {
            healthConnectFeaturesApkImpl = new HealthConnectFeaturesApkImpl(context, providerPackageName);
        } else {
            healthConnectFeaturesApkImpl = HealthConnectFeaturesUnavailableImpl.INSTANCE;
        }
        this(client, healthConnectFeaturesApkImpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.PermissionController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getGrantedPermissions(kotlin.coroutines.Continuation<? super java.util.Set<java.lang.String>> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.getGrantedPermissions(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.PermissionController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object revokeAllPermissions(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) throws android.os.RemoteException {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.health.connect.client.impl.HealthConnectClientImpl.C07811
            if (r0 == 0) goto L14
            r0 = r5
            androidx.health.connect.client.impl.HealthConnectClientImpl$revokeAllPermissions$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientImpl.C07811) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientImpl$revokeAllPermissions$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientImpl$revokeAllPermissions$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: android.os.RemoteException -> L4e
            goto L44
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.health.platform.client.HealthDataAsyncClient r5 = r4.delegate     // Catch: android.os.RemoteException -> L4e
            com.google.common.util.concurrent.ListenableFuture r5 = r5.revokeAllPermissions()     // Catch: android.os.RemoteException -> L4e
            r0.label = r3     // Catch: android.os.RemoteException -> L4e
            java.lang.Object r5 = kotlinx.coroutines.guava.ListenableFutureKt.await(r5, r0)     // Catch: android.os.RemoteException -> L4e
            if (r5 != r1) goto L44
            return r1
        L44:
            java.lang.String r5 = "HealthConnectClient"
            java.lang.String r0 = "Revoked all permissions."
            androidx.health.platform.client.impl.logger.Logger.debug(r5, r0)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L4e:
            r5 = move-exception
            boolean r0 = r5 instanceof android.os.DeadObjectException
            if (r0 != 0) goto L6d
            boolean r0 = r5 instanceof android.os.TransactionTooLargeException
            if (r0 == 0) goto L63
            android.os.TransactionTooLargeException r0 = new android.os.TransactionTooLargeException
            java.lang.String r1 = r5.getMessage()
            r0.<init>(r1)
            android.os.RemoteException r0 = (android.os.RemoteException) r0
            goto L78
        L63:
            android.os.RemoteException r0 = new android.os.RemoteException
            java.lang.String r1 = r5.getMessage()
            r0.<init>(r1)
            goto L78
        L6d:
            android.os.DeadObjectException r0 = new android.os.DeadObjectException
            java.lang.String r1 = r5.getMessage()
            r0.<init>(r1)
            android.os.RemoteException r0 = (android.os.RemoteException) r0
        L78:
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r0.initCause(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.revokeAllPermissions(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public PermissionController getPermissionController() {
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object insertRecords(java.util.List<? extends androidx.health.connect.client.records.Record> r7, kotlin.coroutines.Continuation<? super androidx.health.connect.client.response.InsertRecordsResponse> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.health.connect.client.impl.HealthConnectClientImpl.C07781
            if (r0 == 0) goto L14
            r0 = r8
            androidx.health.connect.client.impl.HealthConnectClientImpl$insertRecords$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientImpl.C07781) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientImpl$insertRecords$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientImpl$insertRecords$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r7 = r0.L$0
            java.util.List r7 = (java.util.List) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: android.os.RemoteException -> L98
            goto L74
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.health.platform.client.HealthDataAsyncClient r8 = r6.delegate     // Catch: android.os.RemoteException -> L98
            r2 = r7
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: android.os.RemoteException -> L98
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.os.RemoteException -> L98
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)     // Catch: android.os.RemoteException -> L98
            r4.<init>(r5)     // Catch: android.os.RemoteException -> L98
            java.util.Collection r4 = (java.util.Collection) r4     // Catch: android.os.RemoteException -> L98
            java.util.Iterator r2 = r2.iterator()     // Catch: android.os.RemoteException -> L98
        L4f:
            boolean r5 = r2.hasNext()     // Catch: android.os.RemoteException -> L98
            if (r5 == 0) goto L63
            java.lang.Object r5 = r2.next()     // Catch: android.os.RemoteException -> L98
            androidx.health.connect.client.records.Record r5 = (androidx.health.connect.client.records.Record) r5     // Catch: android.os.RemoteException -> L98
            androidx.health.platform.client.proto.DataProto$DataPoint r5 = androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt.toProto(r5)     // Catch: android.os.RemoteException -> L98
            r4.add(r5)     // Catch: android.os.RemoteException -> L98
            goto L4f
        L63:
            java.util.List r4 = (java.util.List) r4     // Catch: android.os.RemoteException -> L98
            com.google.common.util.concurrent.ListenableFuture r8 = r8.insertData(r4)     // Catch: android.os.RemoteException -> L98
            r0.L$0 = r7     // Catch: android.os.RemoteException -> L98
            r0.label = r3     // Catch: android.os.RemoteException -> L98
            java.lang.Object r8 = kotlinx.coroutines.guava.ListenableFutureKt.await(r8, r0)     // Catch: android.os.RemoteException -> L98
            if (r8 != r1) goto L74
            return r1
        L74:
            java.util.List r8 = (java.util.List) r8     // Catch: android.os.RemoteException -> L98
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r7 = r7.size()
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r0 = " records inserted."
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.String r0 = "HealthConnectClient"
            androidx.health.platform.client.impl.logger.Logger.debug(r0, r7)
            androidx.health.connect.client.response.InsertRecordsResponse r7 = new androidx.health.connect.client.response.InsertRecordsResponse
            r7.<init>(r8)
            return r7
        L98:
            r7 = move-exception
            boolean r8 = r7 instanceof android.os.DeadObjectException
            if (r8 != 0) goto Lb7
            boolean r8 = r7 instanceof android.os.TransactionTooLargeException
            if (r8 == 0) goto Lad
            android.os.TransactionTooLargeException r8 = new android.os.TransactionTooLargeException
            java.lang.String r0 = r7.getMessage()
            r8.<init>(r0)
            android.os.RemoteException r8 = (android.os.RemoteException) r8
            goto Lc2
        Lad:
            android.os.RemoteException r8 = new android.os.RemoteException
            java.lang.String r0 = r7.getMessage()
            r8.<init>(r0)
            goto Lc2
        Lb7:
            android.os.DeadObjectException r8 = new android.os.DeadObjectException
            java.lang.String r0 = r7.getMessage()
            r8.<init>(r0)
            android.os.RemoteException r8 = (android.os.RemoteException) r8
        Lc2:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r8.initCause(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.insertRecords(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object updateRecords(java.util.List<? extends androidx.health.connect.client.records.Record> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws android.os.RemoteException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.health.connect.client.impl.HealthConnectClientImpl.C07821
            if (r0 == 0) goto L14
            r0 = r8
            androidx.health.connect.client.impl.HealthConnectClientImpl$updateRecords$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientImpl.C07821) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientImpl$updateRecords$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientImpl$updateRecords$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r7 = r0.L$0
            java.util.List r7 = (java.util.List) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: android.os.RemoteException -> L93
            goto L74
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.health.platform.client.HealthDataAsyncClient r8 = r6.delegate     // Catch: android.os.RemoteException -> L93
            r2 = r7
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: android.os.RemoteException -> L93
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.os.RemoteException -> L93
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)     // Catch: android.os.RemoteException -> L93
            r4.<init>(r5)     // Catch: android.os.RemoteException -> L93
            java.util.Collection r4 = (java.util.Collection) r4     // Catch: android.os.RemoteException -> L93
            java.util.Iterator r2 = r2.iterator()     // Catch: android.os.RemoteException -> L93
        L4f:
            boolean r5 = r2.hasNext()     // Catch: android.os.RemoteException -> L93
            if (r5 == 0) goto L63
            java.lang.Object r5 = r2.next()     // Catch: android.os.RemoteException -> L93
            androidx.health.connect.client.records.Record r5 = (androidx.health.connect.client.records.Record) r5     // Catch: android.os.RemoteException -> L93
            androidx.health.platform.client.proto.DataProto$DataPoint r5 = androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt.toProto(r5)     // Catch: android.os.RemoteException -> L93
            r4.add(r5)     // Catch: android.os.RemoteException -> L93
            goto L4f
        L63:
            java.util.List r4 = (java.util.List) r4     // Catch: android.os.RemoteException -> L93
            com.google.common.util.concurrent.ListenableFuture r8 = r8.updateData(r4)     // Catch: android.os.RemoteException -> L93
            r0.L$0 = r7     // Catch: android.os.RemoteException -> L93
            r0.label = r3     // Catch: android.os.RemoteException -> L93
            java.lang.Object r8 = kotlinx.coroutines.guava.ListenableFutureKt.await(r8, r0)     // Catch: android.os.RemoteException -> L93
            if (r8 != r1) goto L74
            return r1
        L74:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r7 = r7.size()
            java.lang.StringBuilder r7 = r8.append(r7)
            java.lang.String r8 = " records updated."
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "HealthConnectClient"
            androidx.health.platform.client.impl.logger.Logger.debug(r8, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L93:
            r7 = move-exception
            boolean r8 = r7 instanceof android.os.DeadObjectException
            if (r8 != 0) goto Lb2
            boolean r8 = r7 instanceof android.os.TransactionTooLargeException
            if (r8 == 0) goto La8
            android.os.TransactionTooLargeException r8 = new android.os.TransactionTooLargeException
            java.lang.String r0 = r7.getMessage()
            r8.<init>(r0)
            android.os.RemoteException r8 = (android.os.RemoteException) r8
            goto Lbd
        La8:
            android.os.RemoteException r8 = new android.os.RemoteException
            java.lang.String r0 = r7.getMessage()
            r8.<init>(r0)
            goto Lbd
        Lb2:
            android.os.DeadObjectException r8 = new android.os.DeadObjectException
            java.lang.String r0 = r7.getMessage()
            r8.<init>(r0)
            android.os.RemoteException r8 = (android.os.RemoteException) r8
        Lbd:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r8.initCause(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.updateRecords(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object deleteRecords(kotlin.reflect.KClass<? extends androidx.health.connect.client.records.Record> r5, java.util.List<java.lang.String> r6, java.util.List<java.lang.String> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws android.os.RemoteException {
        /*
            r4 = this;
            boolean r0 = r8 instanceof androidx.health.connect.client.impl.HealthConnectClientImpl.C07741
            if (r0 == 0) goto L14
            r0 = r8
            androidx.health.connect.client.impl.HealthConnectClientImpl$deleteRecords$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientImpl.C07741) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientImpl$deleteRecords$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientImpl$deleteRecords$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.L$1
            r7 = r5
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: android.os.RemoteException -> L7e
            goto L5a
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.health.platform.client.HealthDataAsyncClient r8 = r4.delegate     // Catch: android.os.RemoteException -> L7e
            java.util.List r2 = androidx.health.connect.client.impl.converters.datatype.DataTypeIdPairConverterKt.toDataTypeIdPairProtoList(r5, r6)     // Catch: android.os.RemoteException -> L7e
            java.util.List r5 = androidx.health.connect.client.impl.converters.datatype.DataTypeIdPairConverterKt.toDataTypeIdPairProtoList(r5, r7)     // Catch: android.os.RemoteException -> L7e
            com.google.common.util.concurrent.ListenableFuture r5 = r8.deleteData(r2, r5)     // Catch: android.os.RemoteException -> L7e
            r0.L$0 = r6     // Catch: android.os.RemoteException -> L7e
            r0.L$1 = r7     // Catch: android.os.RemoteException -> L7e
            r0.label = r3     // Catch: android.os.RemoteException -> L7e
            java.lang.Object r5 = kotlinx.coroutines.guava.ListenableFutureKt.await(r5, r0)     // Catch: android.os.RemoteException -> L7e
            if (r5 != r1) goto L5a
            return r1
        L5a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r6.size()
            int r7 = r7.size()
            int r6 = r6 + r7
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = " records deleted."
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "HealthConnectClient"
            androidx.health.platform.client.impl.logger.Logger.debug(r6, r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L7e:
            r5 = move-exception
            boolean r6 = r5 instanceof android.os.DeadObjectException
            if (r6 != 0) goto L9d
            boolean r6 = r5 instanceof android.os.TransactionTooLargeException
            if (r6 == 0) goto L93
            android.os.TransactionTooLargeException r6 = new android.os.TransactionTooLargeException
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
            goto La8
        L93:
            android.os.RemoteException r6 = new android.os.RemoteException
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            goto La8
        L9d:
            android.os.DeadObjectException r6 = new android.os.DeadObjectException
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
        La8:
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.initCause(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.deleteRecords(kotlin.reflect.KClass, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object deleteRecords(kotlin.reflect.KClass<? extends androidx.health.connect.client.records.Record> r5, androidx.health.connect.client.time.TimeRangeFilter r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws android.os.RemoteException {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.health.connect.client.impl.HealthConnectClientImpl.AnonymousClass3
            if (r0 == 0) goto L14
            r0 = r7
            androidx.health.connect.client.impl.HealthConnectClientImpl$deleteRecords$3 r0 = (androidx.health.connect.client.impl.HealthConnectClientImpl.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientImpl$deleteRecords$3 r0 = new androidx.health.connect.client.impl.HealthConnectClientImpl$deleteRecords$3
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: android.os.RemoteException -> L52
            goto L48
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.health.platform.client.HealthDataAsyncClient r7 = r4.delegate     // Catch: android.os.RemoteException -> L52
            androidx.health.platform.client.proto.RequestProto$DeleteDataRangeRequest r5 = androidx.health.connect.client.impl.converters.request.DeleteDataRangeRequestToProtoKt.toDeleteDataRangeRequestProto(r5, r6)     // Catch: android.os.RemoteException -> L52
            com.google.common.util.concurrent.ListenableFuture r5 = r7.deleteDataRange(r5)     // Catch: android.os.RemoteException -> L52
            r0.label = r3     // Catch: android.os.RemoteException -> L52
            java.lang.Object r5 = kotlinx.coroutines.guava.ListenableFutureKt.await(r5, r0)     // Catch: android.os.RemoteException -> L52
            if (r5 != r1) goto L48
            return r1
        L48:
            java.lang.String r5 = "HealthConnectClient"
            java.lang.String r6 = "Records deletion successful."
            androidx.health.platform.client.impl.logger.Logger.debug(r5, r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L52:
            r5 = move-exception
            boolean r6 = r5 instanceof android.os.DeadObjectException
            if (r6 != 0) goto L71
            boolean r6 = r5 instanceof android.os.TransactionTooLargeException
            if (r6 == 0) goto L67
            android.os.TransactionTooLargeException r6 = new android.os.TransactionTooLargeException
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
            goto L7c
        L67:
            android.os.RemoteException r6 = new android.os.RemoteException
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            goto L7c
        L71:
            android.os.DeadObjectException r6 = new android.os.DeadObjectException
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
        L7c:
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.initCause(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.deleteRecords(kotlin.reflect.KClass, androidx.health.connect.client.time.TimeRangeFilter, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T extends androidx.health.connect.client.records.Record> java.lang.Object readRecord(kotlin.reflect.KClass<T> r5, java.lang.String r6, kotlin.coroutines.Continuation<? super androidx.health.connect.client.response.ReadRecordResponse<T>> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.health.connect.client.impl.HealthConnectClientImpl.C07791
            if (r0 == 0) goto L14
            r0 = r7
            androidx.health.connect.client.impl.HealthConnectClientImpl$readRecord$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientImpl.C07791) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientImpl$readRecord$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientImpl$readRecord$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: android.os.RemoteException -> L7a
            goto L4f
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.health.platform.client.HealthDataAsyncClient r7 = r4.delegate     // Catch: android.os.RemoteException -> L7a
            androidx.health.platform.client.proto.RequestProto$ReadDataRequest r5 = androidx.health.connect.client.impl.converters.request.ReadDataRequestToProtoKt.toReadDataRequestProto(r5, r6)     // Catch: android.os.RemoteException -> L7a
            com.google.common.util.concurrent.ListenableFuture r5 = r7.readData(r5)     // Catch: android.os.RemoteException -> L7a
            r0.L$0 = r6     // Catch: android.os.RemoteException -> L7a
            r0.label = r3     // Catch: android.os.RemoteException -> L7a
            java.lang.Object r7 = kotlinx.coroutines.guava.ListenableFutureKt.await(r5, r0)     // Catch: android.os.RemoteException -> L7a
            if (r7 != r1) goto L4f
            return r1
        L4f:
            androidx.health.platform.client.proto.DataProto$DataPoint r7 = (androidx.health.platform.client.proto.DataProto.DataPoint) r7     // Catch: android.os.RemoteException -> L7a
            androidx.health.connect.client.response.ReadRecordResponse r5 = new androidx.health.connect.client.response.ReadRecordResponse
            androidx.health.connect.client.records.Record r7 = androidx.health.connect.client.impl.converters.records.ProtoToRecordConvertersKt.toRecord(r7)
            java.lang.String r0 = "null cannot be cast to non-null type T of androidx.health.connect.client.impl.HealthConnectClientImpl.readRecord"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r0)
            r5.<init>(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Reading record of "
            r7.<init>(r0)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r7 = " successful."
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "HealthConnectClient"
            androidx.health.platform.client.impl.logger.Logger.debug(r7, r6)
            return r5
        L7a:
            r5 = move-exception
            boolean r6 = r5 instanceof android.os.DeadObjectException
            if (r6 != 0) goto L99
            boolean r6 = r5 instanceof android.os.TransactionTooLargeException
            if (r6 == 0) goto L8f
            android.os.TransactionTooLargeException r6 = new android.os.TransactionTooLargeException
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
            goto La4
        L8f:
            android.os.RemoteException r6 = new android.os.RemoteException
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            goto La4
        L99:
            android.os.DeadObjectException r6 = new android.os.DeadObjectException
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
        La4:
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.initCause(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.readRecord(kotlin.reflect.KClass, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getChangesToken(androidx.health.connect.client.request.ChangesTokenRequest r9, kotlin.coroutines.Continuation<? super java.lang.String> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.getChangesToken(androidx.health.connect.client.request.ChangesTokenRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getChanges(java.lang.String r6, kotlin.coroutines.Continuation<? super androidx.health.connect.client.response.ChangesResponse> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.health.connect.client.impl.HealthConnectClientImpl.C07751
            if (r0 == 0) goto L14
            r0 = r7
            androidx.health.connect.client.impl.HealthConnectClientImpl$getChanges$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientImpl.C07751) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientImpl$getChanges$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientImpl$getChanges$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: android.os.RemoteException -> L8c
            goto L5d
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.health.platform.client.HealthDataAsyncClient r7 = r5.delegate     // Catch: android.os.RemoteException -> L8c
            androidx.health.platform.client.proto.RequestProto$GetChangesRequest$Builder r2 = androidx.health.platform.client.proto.RequestProto.GetChangesRequest.newBuilder()     // Catch: android.os.RemoteException -> L8c
            androidx.health.platform.client.proto.RequestProto$GetChangesRequest$Builder r2 = r2.setChangesToken(r6)     // Catch: android.os.RemoteException -> L8c
            androidx.health.platform.client.proto.GeneratedMessageLite r2 = r2.build()     // Catch: android.os.RemoteException -> L8c
            java.lang.String r4 = "newBuilder()\n           …                 .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch: android.os.RemoteException -> L8c
            androidx.health.platform.client.proto.RequestProto$GetChangesRequest r2 = (androidx.health.platform.client.proto.RequestProto.GetChangesRequest) r2     // Catch: android.os.RemoteException -> L8c
            com.google.common.util.concurrent.ListenableFuture r7 = r7.getChanges(r2)     // Catch: android.os.RemoteException -> L8c
            r0.L$0 = r6     // Catch: android.os.RemoteException -> L8c
            r0.label = r3     // Catch: android.os.RemoteException -> L8c
            java.lang.Object r7 = kotlinx.coroutines.guava.ListenableFutureKt.await(r7, r0)     // Catch: android.os.RemoteException -> L8c
            if (r7 != r1) goto L5d
            return r1
        L5d:
            androidx.health.platform.client.proto.ResponseProto$GetChangesResponse r7 = (androidx.health.platform.client.proto.ResponseProto.GetChangesResponse) r7     // Catch: android.os.RemoteException -> L8c
            java.lang.String r0 = r7.getNextChangesToken()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Retrieved changes successful with "
            r1.<init>(r2)
            java.lang.StringBuilder r6 = r1.append(r6)
            java.lang.String r1 = ", next token "
            java.lang.StringBuilder r6 = r6.append(r1)
            java.lang.StringBuilder r6 = r6.append(r0)
            r0 = 46
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "HealthConnectClient"
            androidx.health.platform.client.impl.logger.Logger.debug(r0, r6)
            androidx.health.connect.client.response.ChangesResponse r6 = androidx.health.connect.client.impl.converters.response.ProtoToChangesResponseKt.toChangesResponse(r7)
            return r6
        L8c:
            r6 = move-exception
            boolean r7 = r6 instanceof android.os.DeadObjectException
            if (r7 != 0) goto Lab
            boolean r7 = r6 instanceof android.os.TransactionTooLargeException
            if (r7 == 0) goto La1
            android.os.TransactionTooLargeException r7 = new android.os.TransactionTooLargeException
            java.lang.String r0 = r6.getMessage()
            r7.<init>(r0)
            android.os.RemoteException r7 = (android.os.RemoteException) r7
            goto Lb6
        La1:
            android.os.RemoteException r7 = new android.os.RemoteException
            java.lang.String r0 = r6.getMessage()
            r7.<init>(r0)
            goto Lb6
        Lab:
            android.os.DeadObjectException r7 = new android.os.DeadObjectException
            java.lang.String r0 = r6.getMessage()
            r7.<init>(r0)
            android.os.RemoteException r7 = (android.os.RemoteException) r7
        Lb6:
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r7.initCause(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.getChanges(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T extends androidx.health.connect.client.records.Record> java.lang.Object readRecords(androidx.health.connect.client.request.ReadRecordsRequest<T> r5, kotlin.coroutines.Continuation<? super androidx.health.connect.client.response.ReadRecordsResponse<T>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.health.connect.client.impl.HealthConnectClientImpl.C07801
            if (r0 == 0) goto L14
            r0 = r6
            androidx.health.connect.client.impl.HealthConnectClientImpl$readRecords$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientImpl.C07801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientImpl$readRecords$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientImpl$readRecords$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: android.os.RemoteException -> L2a
            goto L50
        L2a:
            r5 = move-exception
            goto L5e
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            int r6 = r5.getDeduplicateStrategy()
            if (r6 != 0) goto L8d
            androidx.health.platform.client.HealthDataAsyncClient r6 = r4.delegate     // Catch: android.os.RemoteException -> L2a
            androidx.health.platform.client.proto.RequestProto$ReadDataRangeRequest r5 = androidx.health.connect.client.impl.converters.request.ReadDataRangeRequestToProtoKt.toReadDataRangeRequestProto(r5)     // Catch: android.os.RemoteException -> L2a
            com.google.common.util.concurrent.ListenableFuture r5 = r6.readDataRange(r5)     // Catch: android.os.RemoteException -> L2a
            r0.label = r3     // Catch: android.os.RemoteException -> L2a
            java.lang.Object r6 = kotlinx.coroutines.guava.ListenableFutureKt.await(r5, r0)     // Catch: android.os.RemoteException -> L2a
            if (r6 != r1) goto L50
            return r1
        L50:
            androidx.health.platform.client.proto.ResponseProto$ReadDataRangeResponse r6 = (androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponse) r6     // Catch: android.os.RemoteException -> L2a
            androidx.health.connect.client.response.ReadRecordsResponse r5 = androidx.health.connect.client.impl.converters.response.ProtoToReadRecordsResponseKt.toReadRecordsResponse(r6)
            java.lang.String r6 = "HealthConnectClient"
            java.lang.String r0 = "Retrieve records successful."
            androidx.health.platform.client.impl.logger.Logger.debug(r6, r0)
            return r5
        L5e:
            boolean r6 = r5 instanceof android.os.DeadObjectException
            if (r6 != 0) goto L7c
            boolean r6 = r5 instanceof android.os.TransactionTooLargeException
            if (r6 == 0) goto L72
            android.os.TransactionTooLargeException r6 = new android.os.TransactionTooLargeException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
            goto L87
        L72:
            android.os.RemoteException r6 = new android.os.RemoteException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            goto L87
        L7c:
            android.os.DeadObjectException r6 = new android.os.DeadObjectException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
        L87:
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.initCause(r5)
            throw r6
        L8d:
            kotlin.NotImplementedError r5 = new kotlin.NotImplementedError
            java.lang.String r6 = "An operation is not implemented: Not yet implemented"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.readRecords(androidx.health.connect.client.request.ReadRecordsRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object aggregate(androidx.health.connect.client.request.AggregateRequest r5, kotlin.coroutines.Continuation<? super androidx.health.connect.client.aggregate.AggregationResult> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.health.connect.client.impl.HealthConnectClientImpl.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.health.connect.client.impl.HealthConnectClientImpl$aggregate$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientImpl$aggregate$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientImpl$aggregate$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: android.os.RemoteException -> L8e
            goto L48
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.health.platform.client.HealthDataAsyncClient r6 = r4.delegate     // Catch: android.os.RemoteException -> L8e
            androidx.health.platform.client.proto.RequestProto$AggregateDataRequest r5 = androidx.health.connect.client.impl.converters.request.AggregateRequestToProtoKt.toProto(r5)     // Catch: android.os.RemoteException -> L8e
            com.google.common.util.concurrent.ListenableFuture r5 = r6.aggregate(r5)     // Catch: android.os.RemoteException -> L8e
            r0.label = r3     // Catch: android.os.RemoteException -> L8e
            java.lang.Object r6 = kotlinx.coroutines.guava.ListenableFutureKt.await(r5, r0)     // Catch: android.os.RemoteException -> L8e
            if (r6 != r1) goto L48
            return r1
        L48:
            androidx.health.platform.client.proto.ResponseProto$AggregateDataResponse r6 = (androidx.health.platform.client.proto.ResponseProto.AggregateDataResponse) r6     // Catch: android.os.RemoteException -> L8e
            java.util.List r5 = r6.getRowsList()
            java.lang.String r6 = "responseProto.rowsList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.Object r5 = kotlin.collections.CollectionsKt.first(r5)
            java.lang.String r6 = "responseProto.rowsList.first()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            androidx.health.platform.client.proto.DataProto$AggregateDataRow r5 = (androidx.health.platform.client.proto.DataProto.AggregateDataRow) r5
            androidx.health.connect.client.aggregate.AggregationResult r5 = androidx.health.connect.client.impl.converters.aggregate.ProtoToAggregateDataRowKt.retrieveAggregateDataRow(r5)
            java.util.Map r6 = r5.getLongValues()
            int r6 = r6.size()
            java.util.Map r0 = r5.getDoubleValues()
            int r0 = r0.size()
            int r6 = r6 + r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Retrieved "
            r0.<init>(r1)
            java.lang.StringBuilder r6 = r0.append(r6)
            java.lang.String r0 = " metrics."
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "HealthConnectClient"
            androidx.health.platform.client.impl.logger.Logger.debug(r0, r6)
            return r5
        L8e:
            r5 = move-exception
            boolean r6 = r5 instanceof android.os.DeadObjectException
            if (r6 != 0) goto Lad
            boolean r6 = r5 instanceof android.os.TransactionTooLargeException
            if (r6 == 0) goto La3
            android.os.TransactionTooLargeException r6 = new android.os.TransactionTooLargeException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
            goto Lb8
        La3:
            android.os.RemoteException r6 = new android.os.RemoteException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            goto Lb8
        Lad:
            android.os.DeadObjectException r6 = new android.os.DeadObjectException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
        Lb8:
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.initCause(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.aggregate(androidx.health.connect.client.request.AggregateRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object aggregateGroupByDuration(androidx.health.connect.client.request.AggregateGroupByDurationRequest r5, kotlin.coroutines.Continuation<? super java.util.List<androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.health.connect.client.impl.HealthConnectClientImpl.C07721
            if (r0 == 0) goto L14
            r0 = r6
            androidx.health.connect.client.impl.HealthConnectClientImpl$aggregateGroupByDuration$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientImpl.C07721) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientImpl$aggregateGroupByDuration$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientImpl$aggregateGroupByDuration$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: android.os.RemoteException -> La6
            goto L48
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.health.platform.client.HealthDataAsyncClient r6 = r4.delegate     // Catch: android.os.RemoteException -> La6
            androidx.health.platform.client.proto.RequestProto$AggregateDataRequest r5 = androidx.health.connect.client.impl.converters.request.AggregateRequestToProtoKt.toProto(r5)     // Catch: android.os.RemoteException -> La6
            com.google.common.util.concurrent.ListenableFuture r5 = r6.aggregate(r5)     // Catch: android.os.RemoteException -> La6
            r0.label = r3     // Catch: android.os.RemoteException -> La6
            java.lang.Object r6 = kotlinx.coroutines.guava.ListenableFutureKt.await(r5, r0)     // Catch: android.os.RemoteException -> La6
            if (r6 != r1) goto L48
            return r1
        L48:
            androidx.health.platform.client.proto.ResponseProto$AggregateDataResponse r6 = (androidx.health.platform.client.proto.ResponseProto.AggregateDataResponse) r6     // Catch: android.os.RemoteException -> La6
            java.util.List r5 = r6.getRowsList()
            java.lang.String r6 = "responseProto.rowsList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r0)
            r6.<init>(r0)
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L66:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L7f
            java.lang.Object r0 = r5.next()
            androidx.health.platform.client.proto.DataProto$AggregateDataRow r0 = (androidx.health.platform.client.proto.DataProto.AggregateDataRow) r0
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration r0 = androidx.health.connect.client.impl.converters.aggregate.ProtoToAggregateDataRowKt.toAggregateDataRowGroupByDuration(r0)
            r6.add(r0)
            goto L66
        L7f:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.List r5 = kotlin.collections.CollectionsKt.toList(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Retrieved "
            r6.<init>(r0)
            int r0 = r5.size()
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r0 = " duration aggregation buckets."
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "HealthConnectClient"
            androidx.health.platform.client.impl.logger.Logger.debug(r0, r6)
            return r5
        La6:
            r5 = move-exception
            boolean r6 = r5 instanceof android.os.DeadObjectException
            if (r6 != 0) goto Lc5
            boolean r6 = r5 instanceof android.os.TransactionTooLargeException
            if (r6 == 0) goto Lbb
            android.os.TransactionTooLargeException r6 = new android.os.TransactionTooLargeException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
            goto Ld0
        Lbb:
            android.os.RemoteException r6 = new android.os.RemoteException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            goto Ld0
        Lc5:
            android.os.DeadObjectException r6 = new android.os.DeadObjectException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
        Ld0:
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.initCause(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.aggregateGroupByDuration(androidx.health.connect.client.request.AggregateGroupByDurationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object aggregateGroupByPeriod(androidx.health.connect.client.request.AggregateGroupByPeriodRequest r5, kotlin.coroutines.Continuation<? super java.util.List<androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.health.connect.client.impl.HealthConnectClientImpl.C07731
            if (r0 == 0) goto L14
            r0 = r6
            androidx.health.connect.client.impl.HealthConnectClientImpl$aggregateGroupByPeriod$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientImpl.C07731) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientImpl$aggregateGroupByPeriod$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientImpl$aggregateGroupByPeriod$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: android.os.RemoteException -> La6
            goto L48
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.health.platform.client.HealthDataAsyncClient r6 = r4.delegate     // Catch: android.os.RemoteException -> La6
            androidx.health.platform.client.proto.RequestProto$AggregateDataRequest r5 = androidx.health.connect.client.impl.converters.request.AggregateRequestToProtoKt.toProto(r5)     // Catch: android.os.RemoteException -> La6
            com.google.common.util.concurrent.ListenableFuture r5 = r6.aggregate(r5)     // Catch: android.os.RemoteException -> La6
            r0.label = r3     // Catch: android.os.RemoteException -> La6
            java.lang.Object r6 = kotlinx.coroutines.guava.ListenableFutureKt.await(r5, r0)     // Catch: android.os.RemoteException -> La6
            if (r6 != r1) goto L48
            return r1
        L48:
            androidx.health.platform.client.proto.ResponseProto$AggregateDataResponse r6 = (androidx.health.platform.client.proto.ResponseProto.AggregateDataResponse) r6     // Catch: android.os.RemoteException -> La6
            java.util.List r5 = r6.getRowsList()
            java.lang.String r6 = "responseProto.rowsList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r0)
            r6.<init>(r0)
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L66:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L7f
            java.lang.Object r0 = r5.next()
            androidx.health.platform.client.proto.DataProto$AggregateDataRow r0 = (androidx.health.platform.client.proto.DataProto.AggregateDataRow) r0
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod r0 = androidx.health.connect.client.impl.converters.aggregate.ProtoToAggregateDataRowKt.toAggregateDataRowGroupByPeriod(r0)
            r6.add(r0)
            goto L66
        L7f:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.List r5 = kotlin.collections.CollectionsKt.toList(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Retrieved "
            r6.<init>(r0)
            int r0 = r5.size()
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r0 = " period aggregation buckets."
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "HealthConnectClient"
            androidx.health.platform.client.impl.logger.Logger.debug(r0, r6)
            return r5
        La6:
            r5 = move-exception
            boolean r6 = r5 instanceof android.os.DeadObjectException
            if (r6 != 0) goto Lc5
            boolean r6 = r5 instanceof android.os.TransactionTooLargeException
            if (r6 == 0) goto Lbb
            android.os.TransactionTooLargeException r6 = new android.os.TransactionTooLargeException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
            goto Ld0
        Lbb:
            android.os.RemoteException r6 = new android.os.RemoteException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            goto Ld0
        Lc5:
            android.os.DeadObjectException r6 = new android.os.DeadObjectException
            java.lang.String r0 = r5.getMessage()
            r6.<init>(r0)
            android.os.RemoteException r6 = (android.os.RemoteException) r6
        Ld0:
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.initCause(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientImpl.aggregateGroupByPeriod(androidx.health.connect.client.request.AggregateGroupByPeriodRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final <T> T wrapRemoteException(Function0<? extends T> function) throws RemoteException {
        DeadObjectException deadObjectException;
        try {
            return function.invoke();
        } catch (RemoteException e) {
            if (e instanceof DeadObjectException) {
                deadObjectException = new DeadObjectException(e.getMessage());
            } else {
                deadObjectException = e instanceof TransactionTooLargeException ? new TransactionTooLargeException(e.getMessage()) : new RemoteException(e.getMessage());
            }
            deadObjectException.initCause(e);
            throw deadObjectException;
        }
    }
}
