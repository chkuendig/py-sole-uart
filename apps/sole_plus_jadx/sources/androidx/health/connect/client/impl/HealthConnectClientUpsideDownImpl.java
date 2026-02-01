package androidx.health.connect.client.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.health.connect.AggregateRecordsGroupedByDurationResponse;
import android.health.connect.AggregateRecordsGroupedByPeriodResponse;
import android.health.connect.HealthConnectManager;
import android.health.connect.RecordIdFilter;
import android.health.connect.changelog.ChangeLogTokenResponse;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.os.OutcomeReceiverKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.HealthConnectFeatures;
import androidx.health.connect.client.PermissionController;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.feature.HealthConnectFeaturesPlatformImpl;
import androidx.health.connect.client.impl.platform.aggregate.AggregationExtensionsKt;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.impl.platform.request.RequestConvertersKt;
import androidx.health.connect.client.permission.HealthPermission;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.ChangesTokenRequest;
import androidx.health.connect.client.time.TimeRangeFilter;
import com.android.SdkConstants;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: HealthConnectClientUpsideDownImpl.kt */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B)\b\u0011\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u0019\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001d2\u0006\u0010\u0019\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J&\u0010%\u001a\u00020\n2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J:\u0010%\u001a\u00020\n2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0'2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\u001dH\u0096@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\tH\u0096@¢\u0006\u0002\u00102J\u0016\u00103\u001a\u00020\t2\u0006\u0010\u0019\u001a\u000204H\u0096@¢\u0006\u0002\u00105J\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\t07H\u0096@¢\u0006\u0002\u00108J\u001c\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020(0\u001dH\u0096@¢\u0006\u0002\u0010<J4\u0010=\u001a\b\u0012\u0004\u0012\u0002H?0>\"\b\b\u0000\u0010?*\u00020(2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H?0'2\u0006\u0010@\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010AJ,\u0010B\u001a\b\u0012\u0004\u0012\u0002H?0C\"\b\b\u0000\u0010?*\u00020(2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H?0DH\u0096@¢\u0006\u0002\u0010EJ\u000e\u0010F\u001a\u00020\nH\u0096@¢\u0006\u0002\u00108J\u001c\u0010G\u001a\u00020\n2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020(0\u001dH\u0096@¢\u0006\u0002\u0010<J\u001a\u0010H\u001a\u00020\n2\u0010\u0010I\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030J07H\u0002J2\u0010K\u001a\u0002H?\"\u0004\b\u0000\u0010?2\u001c\u0010L\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H?0M\u0012\u0006\u0012\u0004\u0018\u00010N0\u0007H\u0082@¢\u0006\u0002\u0010OR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Landroidx/health/connect/client/impl/HealthConnectClientUpsideDownImpl;", "Landroidx/health/connect/client/HealthConnectClient;", "Landroidx/health/connect/client/PermissionController;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "revokePermissionsFunction", "Lkotlin/Function1;", "", "", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "executor", "Ljava/util/concurrent/Executor;", "features", "Landroidx/health/connect/client/HealthConnectFeatures;", "getFeatures", "()Landroidx/health/connect/client/HealthConnectFeatures;", "healthConnectManager", "Landroid/health/connect/HealthConnectManager;", "permissionController", "getPermissionController", "()Landroidx/health/connect/client/PermissionController;", "aggregate", "Landroidx/health/connect/client/aggregate/AggregationResult;", "request", "Landroidx/health/connect/client/request/AggregateRequest;", "(Landroidx/health/connect/client/request/AggregateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateGroupByDuration", "", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "(Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateGroupByPeriod", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "(Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecords", "recordType", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordIdsList", "clientRecordIdsList", "(Lkotlin/reflect/KClass;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChanges", "Landroidx/health/connect/client/response/ChangesResponse;", "changesToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChangesToken", "Landroidx/health/connect/client/request/ChangesTokenRequest;", "(Landroidx/health/connect/client/request/ChangesTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGrantedPermissions", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRecords", "Landroidx/health/connect/client/response/InsertRecordsResponse;", "records", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecord", "Landroidx/health/connect/client/response/ReadRecordResponse;", ExifInterface.GPS_DIRECTION_TRUE, "recordId", "(Lkotlin/reflect/KClass;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecords", "Landroidx/health/connect/client/response/ReadRecordsResponse;", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "(Landroidx/health/connect/client/request/ReadRecordsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revokeAllPermissions", "updateRecords", "verifyAggregationMetrics", "metrics", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "wrapPlatformException", "function", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HealthConnectClientUpsideDownImpl implements HealthConnectClient, PermissionController {
    private final Context context;
    private final Executor executor;
    private final HealthConnectFeatures features;
    private final HealthConnectManager healthConnectManager;
    private final Function1<Collection<String>, Unit> revokePermissionsFunction;

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", i = {0, 0, 1, 1}, l = {WinError.ERROR_FILE_TOO_LARGE, WinError.ERROR_BAD_PIPE}, m = "aggregate", n = {"this", "request", "request", "fallbackResponse"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregate$1, reason: invalid class name and case insensitive filesystem */
    static final class C07831 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C07831(Continuation<? super C07831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.aggregate(null, this);
        }
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", i = {0}, l = {249}, m = "aggregateGroupByDuration", n = {"request"}, s = {"L$0"})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$1, reason: invalid class name and case insensitive filesystem */
    static final class C07841 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07841(Continuation<? super C07841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.aggregateGroupByDuration(null, this);
        }
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", i = {0}, l = {WinError.ERROR_DIRECTORY}, m = "aggregateGroupByPeriod", n = {"request"}, s = {"L$0"})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1, reason: invalid class name and case insensitive filesystem */
    static final class C07851 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07851(Continuation<? super C07851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.aggregateGroupByPeriod(null, this);
        }
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", i = {0, 0}, l = {396}, m = "getChanges", n = {"this", "changesToken"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$getChanges$1, reason: invalid class name and case insensitive filesystem */
    static final class C07881 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C07881(Continuation<? super C07881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.getChanges(null, this);
        }
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {313}, m = "getChangesToken", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$getChangesToken$1, reason: invalid class name and case insensitive filesystem */
    static final class C07891 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07891(Continuation<? super C07891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.getChangesToken(null, this);
        }
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {107}, m = "insertRecords", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$insertRecords$1, reason: invalid class name and case insensitive filesystem */
    static final class C07911 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07911(Continuation<? super C07911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.insertRecords(null, this);
        }
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {180}, m = "readRecord", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecord$1, reason: invalid class name and case insensitive filesystem */
    static final class C07921<T extends Record> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07921(Continuation<? super C07921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.readRecord(null, null, this);
        }
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {205}, m = "readRecords", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecords$1, reason: invalid class name and case insensitive filesystem */
    static final class C07931<T extends Record> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07931(Continuation<? super C07931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.readRecords(null, this);
        }
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {389}, m = "wrapPlatformException", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$wrapPlatformException$1, reason: invalid class name and case insensitive filesystem */
    static final class C07951<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07951(Continuation<? super C07951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.wrapPlatformException(null, this);
        }
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Collection<String>, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, Context.class, "revokeSelfPermissionsOnKill", "revokeSelfPermissionsOnKill(Ljava/util/Collection;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Collection<String> collection) {
            invoke2(collection);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Collection<String> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((Context) this.receiver).revokeSelfPermissionsOnKill(p0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HealthConnectClientUpsideDownImpl(Context context) {
        this(context, new AnonymousClass1(context));
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HealthConnectClientUpsideDownImpl(Context context, Function1<? super Collection<String>, Unit> revokePermissionsFunction) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(revokePermissionsFunction, "revokePermissionsFunction");
        this.executor = ExecutorsKt.asExecutor(Dispatchers.getDefault());
        this.features = new HealthConnectFeaturesPlatformImpl();
        this.context = context;
        Object systemService = context.getSystemService("healthconnect");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.health.connect.HealthConnectManager");
        this.healthConnectManager = (HealthConnectManager) systemService;
        this.revokePermissionsFunction = revokePermissionsFunction;
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public PermissionController getPermissionController() {
        return this;
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public HealthConnectFeatures getFeatures() {
        return this.features;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object insertRecords(java.util.List<? extends androidx.health.connect.client.records.Record> r5, kotlin.coroutines.Continuation<? super androidx.health.connect.client.response.InsertRecordsResponse> r6) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07911
            if (r0 == 0) goto L14
            r0 = r6
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$insertRecords$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07911) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$insertRecords$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$insertRecords$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$insertRecords$response$1 r6 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$insertRecords$response$1
            r2 = 0
            r6.<init>(r4, r5, r2)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.label = r3
            java.lang.Object r6 = r4.wrapPlatformException(r6, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            android.health.connect.InsertRecordsResponse r6 = (android.health.connect.InsertRecordsResponse) r6
            java.lang.String r5 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            androidx.health.connect.client.response.InsertRecordsResponse r5 = androidx.health.connect.client.impl.platform.response.InsertRecordsResponseConverterKt.toKtResponse(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.insertRecords(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$updateRecords$2", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$updateRecords$2, reason: invalid class name and case insensitive filesystem */
    static final class C07942 extends SuspendLambda implements Function1<Continuation<? super Void>, Object> {
        final /* synthetic */ List<Record> $records;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07942(List<? extends Record> list, Continuation<? super C07942> continuation) {
            super(1, continuation);
            this.$records = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HealthConnectClientUpsideDownImpl.this.new C07942(this.$records, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Void> continuation) {
            return ((C07942) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl = HealthConnectClientUpsideDownImpl.this;
                List<Record> list = this.$records;
                this.L$0 = healthConnectClientUpsideDownImpl;
                this.L$1 = list;
                this.label = 1;
                C07942 c07942 = this;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c07942), 1);
                cancellableContinuationImpl.initCancellability();
                CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                HealthConnectManager healthConnectManager = healthConnectClientUpsideDownImpl.healthConnectManager;
                List<Record> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(RecordConvertersKt.toPlatformRecord((Record) it.next()));
                }
                healthConnectManager.updateRecords(arrayList, healthConnectClientUpsideDownImpl.executor, OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl2));
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c07942);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public Object updateRecords(List<? extends Record> list, Continuation<? super Unit> continuation) throws Exception {
        Object objWrapPlatformException = wrapPlatformException(new C07942(list, null), continuation);
        return objWrapPlatformException == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWrapPlatformException : Unit.INSTANCE;
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$deleteRecords$2", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$deleteRecords$2, reason: invalid class name and case insensitive filesystem */
    static final class C07872 extends SuspendLambda implements Function1<Continuation<? super Void>, Object> {
        final /* synthetic */ List<String> $clientRecordIdsList;
        final /* synthetic */ List<String> $recordIdsList;
        final /* synthetic */ KClass<? extends Record> $recordType;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07872(List<String> list, List<String> list2, KClass<? extends Record> kClass, Continuation<? super C07872> continuation) {
            super(1, continuation);
            this.$recordIdsList = list;
            this.$clientRecordIdsList = list2;
            this.$recordType = kClass;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HealthConnectClientUpsideDownImpl.this.new C07872(this.$recordIdsList, this.$clientRecordIdsList, this.$recordType, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Void> continuation) {
            return ((C07872) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl = HealthConnectClientUpsideDownImpl.this;
                List<String> list = this.$recordIdsList;
                List<String> list2 = this.$clientRecordIdsList;
                KClass<? extends Record> kClass = this.$recordType;
                this.L$0 = healthConnectClientUpsideDownImpl;
                this.L$1 = list;
                this.L$2 = list2;
                this.L$3 = kClass;
                this.label = 1;
                C07872 c07872 = this;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c07872), 1);
                cancellableContinuationImpl.initCancellability();
                CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                HealthConnectManager healthConnectManager = healthConnectClientUpsideDownImpl.healthConnectManager;
                List listCreateListBuilder = CollectionsKt.createListBuilder();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    listCreateListBuilder.add(RecordIdFilter.fromId(RecordConvertersKt.toPlatformRecordClass(kClass), (String) it.next()));
                }
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    listCreateListBuilder.add(RecordIdFilter.fromClientRecordId(RecordConvertersKt.toPlatformRecordClass(kClass), (String) it2.next()));
                }
                healthConnectManager.deleteRecords(CollectionsKt.build(listCreateListBuilder), healthConnectClientUpsideDownImpl.executor, OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl2));
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c07872);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public Object deleteRecords(KClass<? extends Record> kClass, List<String> list, List<String> list2, Continuation<? super Unit> continuation) throws Exception {
        Object objWrapPlatformException = wrapPlatformException(new C07872(list, list2, kClass, null), continuation);
        return objWrapPlatformException == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWrapPlatformException : Unit.INSTANCE;
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$deleteRecords$4", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$deleteRecords$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Void>, Object> {
        final /* synthetic */ KClass<? extends Record> $recordType;
        final /* synthetic */ TimeRangeFilter $timeRangeFilter;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(KClass<? extends Record> kClass, TimeRangeFilter timeRangeFilter, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$recordType = kClass;
            this.$timeRangeFilter = timeRangeFilter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HealthConnectClientUpsideDownImpl.this.new AnonymousClass4(this.$recordType, this.$timeRangeFilter, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Void> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl = HealthConnectClientUpsideDownImpl.this;
                KClass<? extends Record> kClass = this.$recordType;
                TimeRangeFilter timeRangeFilter = this.$timeRangeFilter;
                this.L$0 = healthConnectClientUpsideDownImpl;
                this.L$1 = kClass;
                this.L$2 = timeRangeFilter;
                this.label = 1;
                AnonymousClass4 anonymousClass4 = this;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(anonymousClass4), 1);
                cancellableContinuationImpl.initCancellability();
                healthConnectClientUpsideDownImpl.healthConnectManager.deleteRecords(RecordConvertersKt.toPlatformRecordClass(kClass), RequestConvertersKt.toPlatformTimeRangeFilter(timeRangeFilter), healthConnectClientUpsideDownImpl.executor, OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(anonymousClass4);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public Object deleteRecords(KClass<? extends Record> kClass, TimeRangeFilter timeRangeFilter, Continuation<? super Unit> continuation) throws Exception {
        Object objWrapPlatformException = wrapPlatformException(new AnonymousClass4(kClass, timeRangeFilter, null), continuation);
        return objWrapPlatformException == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWrapPlatformException : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T extends androidx.health.connect.client.records.Record> java.lang.Object readRecord(kotlin.reflect.KClass<T> r5, java.lang.String r6, kotlin.coroutines.Continuation<? super androidx.health.connect.client.response.ReadRecordResponse<T>> r7) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07921
            if (r0 == 0) goto L14
            r0 = r7
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecord$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07921) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecord$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecord$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L46
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecord$response$1 r7 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecord$response$1
            r2 = 0
            r7.<init>(r4, r5, r6, r2)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r0.label = r3
            java.lang.Object r7 = r4.wrapPlatformException(r7, r0)
            if (r7 != r1) goto L46
            return r1
        L46:
            android.health.connect.ReadRecordsResponse r7 = (android.health.connect.ReadRecordsResponse) r7
            java.util.List r5 = r7.getRecords()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L71
            androidx.health.connect.client.response.ReadRecordResponse r5 = new androidx.health.connect.client.response.ReadRecordResponse
            java.util.List r6 = r7.getRecords()
            r7 = 0
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r7 = "response.records[0]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            android.health.connect.datatypes.Record r6 = (android.health.connect.datatypes.Record) r6
            androidx.health.connect.client.records.Record r6 = androidx.health.connect.client.impl.platform.records.RecordConvertersKt.toSdkRecord(r6)
            java.lang.String r7 = "null cannot be cast to non-null type T of androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.readRecord"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            r5.<init>(r6)
            return r5
        L71:
            android.os.RemoteException r5 = new android.os.RemoteException
            java.lang.String r6 = "No records"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.readRecord(kotlin.reflect.KClass, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T extends androidx.health.connect.client.records.Record> java.lang.Object readRecords(androidx.health.connect.client.request.ReadRecordsRequest<T> r8, kotlin.coroutines.Continuation<? super androidx.health.connect.client.response.ReadRecordsResponse<T>> r9) throws java.lang.Exception {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07931
            if (r0 == 0) goto L14
            r0 = r9
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecords$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07931) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecords$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecords$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r9)
            goto L4c
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.ResultKt.throwOnFailure(r9)
            int r9 = r8.getDeduplicateStrategy()
            if (r9 != 0) goto Lac
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecords$response$1 r9 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecords$response$1
            r9.<init>(r7, r8, r4)
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r0.label = r3
            java.lang.Object r9 = r7.wrapPlatformException(r9, r0)
            if (r9 != r1) goto L4c
            return r1
        L4c:
            android.health.connect.ReadRecordsResponse r9 = (android.health.connect.ReadRecordsResponse) r9
            java.util.List r8 = r9.getRecords()
            java.lang.String r0 = "response.records"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r8 = r8.iterator()
        L6a:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L88
            java.lang.Object r1 = r8.next()
            android.health.connect.datatypes.Record r1 = (android.health.connect.datatypes.Record) r1
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            androidx.health.connect.client.records.Record r1 = androidx.health.connect.client.impl.platform.records.RecordConvertersKt.toSdkRecord(r1)
            java.lang.String r2 = "null cannot be cast to non-null type T of androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.readRecords$lambda$0"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            r0.add(r1)
            goto L6a
        L88:
            java.util.List r0 = (java.util.List) r0
            long r8 = r9.getNextPageToken()
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)
            r9 = r8
            java.lang.Number r9 = (java.lang.Number) r9
            long r1 = r9.longValue()
            r5 = -1
            int r9 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r9 != 0) goto La0
            r8 = r4
        La0:
            if (r8 == 0) goto La6
            java.lang.String r4 = r8.toString()
        La6:
            androidx.health.connect.client.response.ReadRecordsResponse r8 = new androidx.health.connect.client.response.ReadRecordsResponse
            r8.<init>(r0, r4)
            return r8
        Lac:
            kotlin.NotImplementedError r8 = new kotlin.NotImplementedError
            java.lang.String r9 = "An operation is not implemented: Not yet implemented"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.readRecords(androidx.health.connect.client.request.ReadRecordsRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object aggregate(androidx.health.connect.client.request.AggregateRequest r8, kotlin.coroutines.Continuation<? super androidx.health.connect.client.aggregate.AggregationResult> r9) throws java.lang.Exception {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07831
            if (r0 == 0) goto L14
            r0 = r9
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregate$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07831) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregate$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregate$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r8 = r0.L$1
            androidx.health.connect.client.aggregate.AggregationResult r8 = (androidx.health.connect.client.aggregate.AggregationResult) r8
            java.lang.Object r0 = r0.L$0
            androidx.health.connect.client.request.AggregateRequest r0 = (androidx.health.connect.client.request.AggregateRequest) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8a
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            java.lang.Object r8 = r0.L$1
            androidx.health.connect.client.request.AggregateRequest r8 = (androidx.health.connect.client.request.AggregateRequest) r8
            java.lang.Object r2 = r0.L$0
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl r2 = (androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L64
        L49:
            kotlin.ResultKt.throwOnFailure(r9)
            java.util.Set r9 = r8.getMetrics$connect_client_release()
            r7.verifyAggregationMetrics(r9)
            r9 = r7
            androidx.health.connect.client.HealthConnectClient r9 = (androidx.health.connect.client.HealthConnectClient) r9
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.aggregateFallback(r9, r8, r0)
            if (r9 != r1) goto L63
            return r1
        L63:
            r2 = r7
        L64:
            androidx.health.connect.client.aggregate.AggregationResult r9 = (androidx.health.connect.client.aggregate.AggregationResult) r9
            java.util.Set r4 = androidx.health.connect.client.impl.platform.aggregate.AggregationExtensionsKt.getPlatformMetrics(r8)
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L71
            return r9
        L71:
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregate$platformResponse$1 r4 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregate$platformResponse$1
            r5 = 0
            r4.<init>(r2, r8, r5)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r0 = r2.wrapPlatformException(r4, r0)
            if (r0 != r1) goto L86
            return r1
        L86:
            r6 = r0
            r0 = r8
            r8 = r9
            r9 = r6
        L8a:
            java.lang.String r1 = "override suspend fun agg… + fallbackResponse\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
            android.health.connect.AggregateRecordsResponse r9 = (android.health.connect.AggregateRecordsResponse) r9
            java.util.Set r0 = androidx.health.connect.client.impl.platform.aggregate.AggregationExtensionsKt.getPlatformMetrics(r0)
            androidx.health.connect.client.aggregate.AggregationResult r9 = androidx.health.connect.client.impl.platform.response.ResponseConvertersKt.toSdkResponse(r9, r0)
            androidx.health.connect.client.aggregate.AggregationResult r8 = androidx.health.connect.client.impl.platform.aggregate.AggregationExtensionsKt.plus(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.aggregate(androidx.health.connect.client.request.AggregateRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object aggregateGroupByDuration(androidx.health.connect.client.request.AggregateGroupByDurationRequest r5, kotlin.coroutines.Continuation<? super java.util.List<androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration>> r6) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07841
            if (r0 == 0) goto L14
            r0 = r6
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07841) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            androidx.health.connect.client.request.AggregateGroupByDurationRequest r5 = (androidx.health.connect.client.request.AggregateGroupByDurationRequest) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L53
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.Set r6 = r5.getMetrics$connect_client_release()
            r4.verifyAggregationMetrics(r6)
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$2 r6 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$2
            r2 = 0
            r6.<init>(r5, r2)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.wrapPlatformException(r6, r0)
            if (r6 != r1) goto L53
            return r1
        L53:
            java.lang.String r0 = "override suspend fun agg…(request.metrics) }\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r6 = r6.iterator()
        L6b:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L88
            java.lang.Object r1 = r6.next()
            android.health.connect.AggregateRecordsGroupedByDurationResponse r1 = (android.health.connect.AggregateRecordsGroupedByDurationResponse) r1
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.util.Set r2 = r5.getMetrics$connect_client_release()
            androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration r1 = androidx.health.connect.client.impl.platform.response.ResponseConvertersKt.toSdkResponse(r1, r2)
            r0.add(r1)
            goto L6b
        L88:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.aggregateGroupByDuration(androidx.health.connect.client.request.AggregateGroupByDurationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \u0010\u0000\u001a^\u0012(\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002 \u0004*.\u0012(\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00050\u0001H\u008a@"}, d2 = {"<anonymous>", "", "Landroid/health/connect/AggregateRecordsGroupedByDurationResponse;", "", "kotlin.jvm.PlatformType", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$2", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super List<AggregateRecordsGroupedByDurationResponse<Object>>>, Object> {
        final /* synthetic */ AggregateGroupByDurationRequest $request;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AggregateGroupByDurationRequest aggregateGroupByDurationRequest, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$request = aggregateGroupByDurationRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HealthConnectClientUpsideDownImpl.this.new AnonymousClass2(this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super List<AggregateRecordsGroupedByDurationResponse<Object>>> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl = HealthConnectClientUpsideDownImpl.this;
                AggregateGroupByDurationRequest aggregateGroupByDurationRequest = this.$request;
                this.L$0 = healthConnectClientUpsideDownImpl;
                this.L$1 = aggregateGroupByDurationRequest;
                this.label = 1;
                AnonymousClass2 anonymousClass2 = this;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(anonymousClass2), 1);
                cancellableContinuationImpl.initCancellability();
                healthConnectClientUpsideDownImpl.healthConnectManager.aggregateGroupByDuration(RequestConvertersKt.toPlatformRequest(aggregateGroupByDurationRequest), aggregateGroupByDurationRequest.getTimeRangeSlicer(), healthConnectClientUpsideDownImpl.executor, OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(anonymousClass2);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object aggregateGroupByPeriod(androidx.health.connect.client.request.AggregateGroupByPeriodRequest r11, kotlin.coroutines.Continuation<? super java.util.List<androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod>> r12) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.aggregateGroupByPeriod(androidx.health.connect.client.request.AggregateGroupByPeriodRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \u0010\u0000\u001a^\u0012(\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002 \u0004*.\u0012(\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00050\u0001H\u008a@"}, d2 = {"<anonymous>", "", "Landroid/health/connect/AggregateRecordsGroupedByPeriodResponse;", "", "kotlin.jvm.PlatformType", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByPeriod$2", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByPeriod$2, reason: invalid class name and case insensitive filesystem */
    static final class C07862 extends SuspendLambda implements Function1<Continuation<? super List<AggregateRecordsGroupedByPeriodResponse<Object>>>, Object> {
        final /* synthetic */ AggregateGroupByPeriodRequest $request;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07862(AggregateGroupByPeriodRequest aggregateGroupByPeriodRequest, Continuation<? super C07862> continuation) {
            super(1, continuation);
            this.$request = aggregateGroupByPeriodRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HealthConnectClientUpsideDownImpl.this.new C07862(this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super List<AggregateRecordsGroupedByPeriodResponse<Object>>> continuation) {
            return ((C07862) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl = HealthConnectClientUpsideDownImpl.this;
                AggregateGroupByPeriodRequest aggregateGroupByPeriodRequest = this.$request;
                this.L$0 = healthConnectClientUpsideDownImpl;
                this.L$1 = aggregateGroupByPeriodRequest;
                this.label = 1;
                C07862 c07862 = this;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c07862), 1);
                cancellableContinuationImpl.initCancellability();
                healthConnectClientUpsideDownImpl.healthConnectManager.aggregateGroupByPeriod(RequestConvertersKt.toPlatformRequest(aggregateGroupByPeriodRequest), aggregateGroupByPeriodRequest.getTimeRangeSlicer(), healthConnectClientUpsideDownImpl.executor, OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c07862);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    private final void verifyAggregationMetrics(Set<? extends AggregateMetric<?>> metrics) {
        AggregateMetric aggregateMetric = (AggregateMetric) CollectionsKt.firstOrNull(CollectionsKt.intersect(AggregationExtensionsKt.getAGGREGATE_METRICS_ADDED_IN_SDK_EXT_10(), metrics));
        if (aggregateMetric != null) {
            throw new UnsupportedOperationException("Unsupported metric type " + aggregateMetric.getMetricKey());
        }
    }

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroid/health/connect/changelog/ChangeLogTokenResponse;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$getChangesToken$2", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$getChangesToken$2, reason: invalid class name and case insensitive filesystem */
    static final class C07902 extends SuspendLambda implements Function1<Continuation<? super ChangeLogTokenResponse>, Object> {
        final /* synthetic */ ChangesTokenRequest $request;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07902(ChangesTokenRequest changesTokenRequest, Continuation<? super C07902> continuation) {
            super(1, continuation);
            this.$request = changesTokenRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HealthConnectClientUpsideDownImpl.this.new C07902(this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ChangeLogTokenResponse> continuation) {
            return ((C07902) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl = HealthConnectClientUpsideDownImpl.this;
                ChangesTokenRequest changesTokenRequest = this.$request;
                this.L$0 = healthConnectClientUpsideDownImpl;
                this.L$1 = changesTokenRequest;
                this.label = 1;
                C07902 c07902 = this;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c07902), 1);
                cancellableContinuationImpl.initCancellability();
                healthConnectClientUpsideDownImpl.healthConnectManager.getChangeLogToken(RequestConvertersKt.toPlatformRequest(changesTokenRequest), healthConnectClientUpsideDownImpl.executor, OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c07902);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getChangesToken(androidx.health.connect.client.request.ChangesTokenRequest r5, kotlin.coroutines.Continuation<? super java.lang.String> r6) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07891
            if (r0 == 0) goto L14
            r0 = r6
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$getChangesToken$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07891) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$getChangesToken$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$getChangesToken$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$getChangesToken$2 r6 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$getChangesToken$2
            r2 = 0
            r6.<init>(r5, r2)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.label = r3
            java.lang.Object r6 = r4.wrapPlatformException(r6, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            android.health.connect.changelog.ChangeLogTokenResponse r6 = (android.health.connect.changelog.ChangeLogTokenResponse) r6
            java.lang.String r5 = r6.getToken()
            java.lang.String r6 = "override suspend fun get…\n            .token\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.getChangesToken(androidx.health.connect.client.request.ChangesTokenRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getChanges(java.lang.String r8, kotlin.coroutines.Continuation<? super androidx.health.connect.client.response.ChangesResponse> r9) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.getChanges(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.health.connect.client.PermissionController
    public Object getGrantedPermissions(Continuation<? super Set<String>> continuation) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), PackageManager.PackageInfoFlags.of(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        String[] strArr = packageInfo.requestedPermissions;
        if (strArr == null) {
            strArr = new String[0];
        } else {
            Intrinsics.checkNotNullExpressionValue(strArr, "it.requestedPermissions ?: emptyArray()");
        }
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Intrinsics.checkNotNullExpressionValue(str, "requestedPermissions[i]");
            if (StringsKt.startsWith$default(str, HealthPermission.PERMISSION_PREFIX, false, 2, (Object) null)) {
                int[] iArr = packageInfo.requestedPermissionsFlags;
                Intrinsics.checkNotNull(iArr);
                if ((iArr[i] & 2) > 0) {
                    String str2 = strArr[i];
                    Intrinsics.checkNotNullExpressionValue(str2, "requestedPermissions[i]");
                    setCreateSetBuilder.add(str2);
                }
            }
        }
        return SetsKt.build(setCreateSetBuilder);
    }

    @Override // androidx.health.connect.client.PermissionController
    public Object revokeAllPermissions(Continuation<? super Unit> continuation) {
        String[] strArr = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), PackageManager.PackageInfoFlags.of(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)).requestedPermissions;
        if (strArr == null) {
            strArr = new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (String it : strArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (StringsKt.startsWith$default(it, HealthPermission.PERMISSION_PREFIX, false, 2, (Object) null)) {
                arrayList.add(it);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            this.revokePermissionsFunction.invoke(arrayList2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object wrapPlatformException(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super T> r6) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07951
            if (r0 == 0) goto L14
            r0 = r6
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$wrapPlatformException$1 r0 = (androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.C07951) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$wrapPlatformException$1 r0 = new androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$wrapPlatformException$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: android.health.connect.HealthConnectException -> L2a
            goto L40
        L2a:
            r5 = move-exception
            goto L41
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3     // Catch: android.health.connect.HealthConnectException -> L2a
            java.lang.Object r6 = r5.invoke(r0)     // Catch: android.health.connect.HealthConnectException -> L2a
            if (r6 != r1) goto L40
            return r1
        L40:
            return r6
        L41:
            java.lang.Exception r5 = androidx.health.connect.client.impl.platform.ExceptionConverterKt.toKtException(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.wrapPlatformException(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
