package com.soletreadmills.sole_v2._tools;

import android.content.Context;
import com.android.SdkConstants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.MessageClient;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.Wearable;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._tools.WearDataTool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import timber.log.Timber;

/* compiled from: WearDataTool.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/WearDataTool;", "", "()V", "MESSAGE_PATH", "", "TAG", "WEAR_CAPABILITY", "callWearCommand", "", "code", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "getConnectedNodes", "", "getReachableNodesWithCapability", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WearDataTool {
    public static final int $stable = 0;
    public static final WearDataTool INSTANCE = new WearDataTool();
    private static final String MESSAGE_PATH = "/wear-message";
    private static final String TAG = "WearDataTool";
    private static final String WEAR_CAPABILITY = "verify_remote_wear_app";

    private WearDataTool() {
    }

    public final void callWearCommand(String code, Context context) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (!MySharedPreferences.INSTANCE.getInstance().getIsSupportWearOS()) {
            Timber.INSTANCE.i("HRRR not support WearOS", new Object[0]);
        } else if (context == null) {
            Timber.INSTANCE.i("HRRR context==null", new Object[0]);
        } else {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), null, null, new AnonymousClass1(context.getApplicationContext(), code, null), 3, null);
        }
    }

    /* compiled from: WearDataTool.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._tools.WearDataTool$callWearCommand$1", f = "WearDataTool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._tools.WearDataTool$callWearCommand$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $appCtx;
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$appCtx = context;
            this.$code = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$appCtx, this.$code, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            WearDataTool wearDataTool = WearDataTool.INSTANCE;
            Context appCtx = this.$appCtx;
            Intrinsics.checkNotNullExpressionValue(appCtx, "$appCtx");
            List reachableNodesWithCapability = wearDataTool.getReachableNodesWithCapability(appCtx);
            Context context = this.$appCtx;
            if (reachableNodesWithCapability.isEmpty()) {
                Timber.INSTANCE.tag(WearDataTool.TAG).w("No reachable nodes with capability=verify_remote_wear_app, fallback to connectedNodes", new Object[0]);
                WearDataTool wearDataTool2 = WearDataTool.INSTANCE;
                Intrinsics.checkNotNull(context);
                reachableNodesWithCapability = wearDataTool2.getConnectedNodes(context);
            }
            List<String> list = reachableNodesWithCapability;
            if (list.isEmpty()) {
                Timber.INSTANCE.tag(WearDataTool.TAG).e("no exist node", new Object[0]);
                return Unit.INSTANCE;
            }
            Context context2 = this.$appCtx;
            String str = this.$code;
            for (final String str2 : list) {
                MessageClient messageClient = Wearable.getMessageClient(context2);
                byte[] bytes = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                Task<Integer> taskSendMessage = messageClient.sendMessage(str2, "/wear-message", bytes);
                final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.soletreadmills.sole_v2._tools.WearDataTool$callWearCommand$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke2(num);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Integer num) {
                        Timber.INSTANCE.tag("WearDataTool").d("OnSuccess nodeId=" + str2, new Object[0]);
                    }
                };
                taskSendMessage.addOnSuccessListener(new OnSuccessListener() { // from class: com.soletreadmills.sole_v2._tools.WearDataTool$callWearCommand$1$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj2) {
                        function1.invoke(obj2);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: com.soletreadmills.sole_v2._tools.WearDataTool$callWearCommand$1$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        WearDataTool.AnonymousClass1.invokeSuspend$lambda$3$lambda$2(str2, exc);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$3$lambda$2(String str, Exception exc) {
            Timber.INSTANCE.tag(WearDataTool.TAG).e(exc, "OnFailure nodeId=" + str, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> getReachableNodesWithCapability(Context context) {
        Object objM9087constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            WearDataTool wearDataTool = this;
            Set<Node> nodes = ((CapabilityInfo) Tasks.await(Wearable.getCapabilityClient(context).getCapability("verify_remote_wear_app", 1))).getNodes();
            Intrinsics.checkNotNullExpressionValue(nodes, "getNodes(...)");
            List list = CollectionsKt.toList(nodes);
            if (!list.isEmpty()) {
                Timber.INSTANCE.tag("WearCapability").d("1-1 Device has the capability: verify_remote_wear_app, nodes=" + list.size(), new Object[0]);
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Node node = (Node) obj;
                    Timber.INSTANCE.tag("WearCapability").d("  node[" + i + "] id=" + node.getId() + ", displayName=" + node.getDisplayName() + ", isNearby=" + node.isNearby(), new Object[0]);
                    i = i2;
                }
            } else {
                Timber.INSTANCE.tag("WearCapability").d("1-2 Device does not have the capability: verify_remote_wear_app (reachable=0)", new Object[0]);
            }
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((Node) it.next()).getId());
            }
            objM9087constructorimpl = Result.m9087constructorimpl(arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9090exceptionOrNullimpl = Result.m9090exceptionOrNullimpl(objM9087constructorimpl);
        if (thM9090exceptionOrNullimpl != null) {
            Timber.INSTANCE.tag(TAG).e(thM9090exceptionOrNullimpl, "getReachableNodesWithCapability failed", new Object[0]);
            objM9087constructorimpl = CollectionsKt.emptyList();
        }
        return (List) objM9087constructorimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> getConnectedNodes(Context context) {
        Object objM9087constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            WearDataTool wearDataTool = this;
            Object objAwait = Tasks.await(Wearable.getNodeClient(context).getConnectedNodes());
            Intrinsics.checkNotNullExpressionValue(objAwait, "await(...)");
            Iterable iterable = (Iterable) objAwait;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(((Node) it.next()).getId());
            }
            objM9087constructorimpl = Result.m9087constructorimpl(arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9090exceptionOrNullimpl = Result.m9090exceptionOrNullimpl(objM9087constructorimpl);
        if (thM9090exceptionOrNullimpl != null) {
            Timber.INSTANCE.tag(TAG).e(thM9090exceptionOrNullimpl, "getConnectedNodes failed", new Object[0]);
            objM9087constructorimpl = CollectionsKt.emptyList();
        }
        return (List) objM9087constructorimpl;
    }
}
