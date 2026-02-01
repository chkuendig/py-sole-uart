package io.ktor.util.debug;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.util.debug.plugins.PluginName;
import io.ktor.util.debug.plugins.PluginsTrace;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ContextUtils.kt */
@Metadata(d1 = {"\u0000.\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a5\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a=\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\f0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"addToContextInDebugMode", ExifInterface.GPS_DIRECTION_TRUE, "pluginName", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initContextInDebugMode", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useContextElementInDebugMode", "", "Element", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "action", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ContextUtilsKt {
    public static final <T> Object initContextInDebugMode(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        return !IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected() ? function1.invoke(continuation) : BuildersKt.withContext(continuation.getContext().plus(new PluginsTrace(null, 1, null)), new C11732(function1, null), continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ContextUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.debug.ContextUtilsKt$initContextInDebugMode$2", f = "ContextUtils.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.util.debug.ContextUtilsKt$initContextInDebugMode$2, reason: invalid class name and case insensitive filesystem */
    static final class C11732<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C11732(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super C11732> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C11732(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C11732) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super T>, Object> function1 = this.$block;
                this.label = 1;
                obj = function1.invoke(this);
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

    public static final <T> Object addToContextInDebugMode(String str, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        return !IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected() ? function1.invoke(continuation) : BuildersKt.withContext(continuation.getContext().plus(new PluginName(str)), new AnonymousClass2(function1, null), continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ContextUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.debug.ContextUtilsKt$addToContextInDebugMode$2", f = "ContextUtils.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.util.debug.ContextUtilsKt$addToContextInDebugMode$2, reason: invalid class name */
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super T>, Object> function1 = this.$block;
                this.label = 1;
                obj = function1.invoke(this);
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

    public static final <Element extends CoroutineContext.Element> Object useContextElementInDebugMode(CoroutineContext.Key<Element> key, Function1<? super Element, Unit> function1, Continuation<? super Unit> continuation) {
        if (!IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected()) {
            return Unit.INSTANCE;
        }
        CoroutineContext.Element element = continuation.getContext().get(key);
        if (element != null) {
            function1.invoke(element);
        }
        return Unit.INSTANCE;
    }
}
