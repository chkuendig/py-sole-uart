package com.google.ai.client.generativeai.common.util;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;
import org.objectweb.asm.Opcodes;

/* compiled from: ktor.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a#\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0006\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\b\u001a9\u0010\b\u001a\u00020\t*\u00020\u00072\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u00020\t*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"SSE_SEPARATOR", "", "decodeToFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/json/Json;", "channel", "Lio/ktor/utils/io/ByteReadChannel;", "onEachLine", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", "Lio/ktor/utils/io/ByteChannel;", "bytes", "", "(Lio/ktor/utils/io/ByteChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KtorKt {
    public static final String SSE_SEPARATOR = "\r\n\r\n";

    /* compiled from: ktor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.common.util.KtorKt", f = "ktor.kt", i = {0, 0, 1, 1, 2, 2}, l = {50, 51, 52}, m = "onEachLine", n = {"$this$onEachLine", "block", "$this$onEachLine", "block", "$this$onEachLine", "block"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    /* renamed from: com.google.ai.client.generativeai.common.util.KtorKt$onEachLine$1, reason: invalid class name and case insensitive filesystem */
    static final class C08311 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08311(Continuation<? super C08311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KtorKt.onEachLine(null, null, this);
        }
    }

    /* compiled from: ktor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.common.util.KtorKt", f = "ktor.kt", i = {0}, l = {96}, m = "send", n = {"$this$send"}, s = {"L$0"})
    /* renamed from: com.google.ai.client.generativeai.common.util.KtorKt$send$1, reason: invalid class name and case insensitive filesystem */
    static final class C08321 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08321(Continuation<? super C08321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KtorKt.send(null, null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0061, code lost:
    
        if (r9 != null) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0086 -> B:20:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x009f -> B:20:0x0061). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object onEachLine(io.ktor.utils.io.ByteReadChannel r7, kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof com.google.ai.client.generativeai.common.util.KtorKt.C08311
            if (r0 == 0) goto L14
            r0 = r9
            com.google.ai.client.generativeai.common.util.KtorKt$onEachLine$1 r0 = (com.google.ai.client.generativeai.common.util.KtorKt.C08311) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.google.ai.client.generativeai.common.util.KtorKt$onEachLine$1 r0 = new com.google.ai.client.generativeai.common.util.KtorKt$onEachLine$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5e
            if (r2 == r5) goto L52
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r8 = (io.ktor.utils.io.ByteReadChannel) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r8
            r8 = r7
            r7 = r6
            goto L61
        L3b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L43:
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r8 = (io.ktor.utils.io.ByteReadChannel) r8
            kotlin.ResultKt.throwOnFailure(r9)
        L4e:
            r6 = r8
            r8 = r7
            r7 = r6
            goto L84
        L52:
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r8 = (io.ktor.utils.io.ByteReadChannel) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L77
        L5e:
            kotlin.ResultKt.throwOnFailure(r9)
        L61:
            boolean r9 = r7.isClosedForRead()
            if (r9 != 0) goto La2
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r9 = r7.awaitContent(r0)
            if (r9 != r1) goto L74
            return r1
        L74:
            r6 = r8
            r8 = r7
            r7 = r6
        L77:
            r0.L$0 = r8
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannelKt.readUTF8Line(r8, r0)
            if (r9 != r1) goto L4e
            return r1
        L84:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L61
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L92
            r9 = 0
        L92:
            if (r9 != 0) goto L95
            goto L61
        L95:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r8.invoke(r9, r0)
            if (r9 != r1) goto L61
            return r1
        La2:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ai.client.generativeai.common.util.KtorKt.onEachLine(io.ktor.utils.io.ByteReadChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ktor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    @DebugMetadata(c = "com.google.ai.client.generativeai.common.util.KtorKt$decodeToFlow$1", f = "ktor.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.ai.client.generativeai.common.util.KtorKt$decodeToFlow$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteReadChannel $channel;
        final /* synthetic */ Json $this_decodeToFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteReadChannel byteReadChannel, Json json, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$channel = byteReadChannel;
            this.$this_decodeToFlow = json;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.needClassReification();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$channel, this.$this_decodeToFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ktor.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", ""}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
        @DebugMetadata(c = "com.google.ai.client.generativeai.common.util.KtorKt$decodeToFlow$1$1", f = "ktor.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.google.ai.client.generativeai.common.util.KtorKt$decodeToFlow$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01681 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProducerScope<T> $$this$channelFlow;
            final /* synthetic */ Json $this_decodeToFlow;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C01681(ProducerScope<? super T> producerScope, Json json, Continuation<? super C01681> continuation) {
                super(2, continuation);
                this.$$this$channelFlow = producerScope;
                this.$this_decodeToFlow = json;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01681 c01681 = new C01681(this.$$this$channelFlow, this.$this_decodeToFlow, continuation);
                c01681.L$0 = obj;
                return c01681;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(String str, Continuation<? super Unit> continuation) {
                return ((C01681) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String strRemovePrefix = StringsKt.removePrefix((String) this.L$0, (CharSequence) "data:");
                    ProducerScope<T> producerScope = this.$$this$channelFlow;
                    Json json = this.$this_decodeToFlow;
                    SerializersModule serializersModule = json.getSerializersModule();
                    Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                    this.label = 1;
                    if (producerScope.send(json.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), strRemovePrefix), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                ByteReadChannel byteReadChannel = this.$channel;
                Intrinsics.needClassReification();
                this.label = 1;
                if (KtorKt.onEachLine(byteReadChannel, new C01681(producerScope, this.$this_decodeToFlow, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ <T> Flow<T> decodeToFlow(Json json, ByteReadChannel channel) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.needClassReification();
        return FlowKt.channelFlow(new AnonymousClass1(channel, json, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object send(io.ktor.utils.io.ByteChannel r4, byte[] r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof com.google.ai.client.generativeai.common.util.KtorKt.C08321
            if (r0 == 0) goto L14
            r0 = r6
            com.google.ai.client.generativeai.common.util.KtorKt$send$1 r0 = (com.google.ai.client.generativeai.common.util.KtorKt.C08321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.google.ai.client.generativeai.common.util.KtorKt$send$1 r0 = new com.google.ai.client.generativeai.common.util.KtorKt$send$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannel r4 = (io.ktor.utils.io.ByteChannel) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r4
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r6, r5, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            io.ktor.utils.io.ByteWriteChannel r4 = (io.ktor.utils.io.ByteWriteChannel) r4
            io.ktor.utils.io.ByteWriteChannelKt.close(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ai.client.generativeai.common.util.KtorKt.send(io.ktor.utils.io.ByteChannel, byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }
}
