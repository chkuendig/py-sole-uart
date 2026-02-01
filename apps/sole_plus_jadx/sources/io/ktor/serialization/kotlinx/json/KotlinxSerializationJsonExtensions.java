package io.ktor.serialization.kotlinx.json;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.ChannelWriterContent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.kotlinx.KotlinxSerializationExtension;
import io.ktor.serialization.kotlinx.SerializerLookupKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteWriteChannel;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
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
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: KotlinxSerializationJsonExtensions.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J/\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J9\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017JC\u0010\u0012\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00190\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001c2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lio/ktor/serialization/kotlinx/json/KotlinxSerializationJsonExtensions;", "Lio/ktor/serialization/kotlinx/KotlinxSerializationExtension;", "format", "Lkotlinx/serialization/json/Json;", "(Lkotlinx/serialization/json/Json;)V", "jsonArraySymbolsMap", "", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "Lio/ktor/serialization/kotlinx/json/JsonArraySymbols;", "deserialize", "", HttpAuthHeader.Parameters.Charset, "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serialize", "Lio/ktor/http/content/OutgoingContent;", "contentType", "Lio/ktor/http/ContentType;", "value", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "serializer", "Lkotlinx/serialization/KSerializer;", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/serialization/KSerializer;Ljava/nio/charset/Charset;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-serialization-kotlinx-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class KotlinxSerializationJsonExtensions implements KotlinxSerializationExtension {
    private final Json format;
    private final Map<Charset, JsonArraySymbols> jsonArraySymbolsMap;

    /* compiled from: KotlinxSerializationJsonExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions", f = "KotlinxSerializationJsonExtensions.kt", i = {}, l = {66}, m = "deserialize", n = {}, s = {})
    /* renamed from: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1, reason: invalid class name */
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
            return KotlinxSerializationJsonExtensions.this.deserialize(null, null, null, this);
        }
    }

    /* compiled from: KotlinxSerializationJsonExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions", f = "KotlinxSerializationJsonExtensions.kt", i = {0, 0, 0, 0, 0, 0, 1, 1}, l = {80, 121, 89}, m = "serialize", n = {"this", "$this$serialize", "serializer", HttpAuthHeader.Parameters.Charset, "channel", "jsonArraySymbols", "channel", "jsonArraySymbols"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1"})
    /* renamed from: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$3, reason: invalid class name */
    static final class AnonymousClass3<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationJsonExtensions.this.serialize((Flow) null, (KSerializer) null, (Charset) null, (ByteWriteChannel) null, this);
        }
    }

    public KotlinxSerializationJsonExtensions(Json format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        this.jsonArraySymbolsMap = new LinkedHashMap();
    }

    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtension
    public Object serialize(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super OutgoingContent> continuation) {
        if (!Intrinsics.areEqual(charset, Charsets.UTF_8) || !Intrinsics.areEqual(typeInfo.getType(), Reflection.getOrCreateKotlinClass(Flow.class))) {
            return null;
        }
        return new ChannelWriterContent(new AnonymousClass2(obj, SerializerLookupKt.serializerForTypeInfo(this.format.getSerializersModule(), KotlinxSerializationJsonExtensionsKt.argumentTypeInfo(typeInfo)), charset, null), ContentTypesKt.withCharsetIfNeeded(contentType, charset), null, null, 12, null);
    }

    /* compiled from: KotlinxSerializationJsonExtensions.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ByteWriteChannel;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$2", f = "KotlinxSerializationJsonExtensions.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ByteWriteChannel, Continuation<? super Unit>, Object> {
        final /* synthetic */ Charset $charset;
        final /* synthetic */ KSerializer<?> $serializer;
        final /* synthetic */ Object $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Object obj, KSerializer<?> kSerializer, Charset charset, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$value = obj;
            this.$serializer = kSerializer;
            this.$charset = charset;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = KotlinxSerializationJsonExtensions.this.new AnonymousClass2(this.$value, this.$serializer, this.$charset, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(byteWriteChannel, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ByteWriteChannel byteWriteChannel = (ByteWriteChannel) this.L$0;
                KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions = KotlinxSerializationJsonExtensions.this;
                Object obj2 = this.$value;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<*>");
                KSerializer<?> kSerializer = this.$serializer;
                Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
                this.label = 1;
                if (kotlinxSerializationJsonExtensions.serialize((Flow) obj2, kSerializer, this.$charset, byteWriteChannel, this) == coroutine_suspended) {
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object deserialize(java.nio.charset.Charset r5, io.ktor.util.reflect.TypeInfo r6, io.ktor.utils.io.ByteReadChannel r7, kotlin.coroutines.Continuation<java.lang.Object> r8) throws io.ktor.serialization.JsonConvertException {
        /*
            r4 = this;
            boolean r0 = r8 instanceof io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1 r0 = (io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1 r0 = new io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L2a
            goto L5b
        L2a:
            r5 = move-exception
            goto L5c
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            java.nio.charset.Charset r8 = kotlin.text.Charsets.UTF_8
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r8)
            if (r5 == 0) goto L75
            kotlin.reflect.KClass r5 = r6.getType()
            java.lang.Class<kotlin.sequences.Sequence> r8 = kotlin.sequences.Sequence.class
            kotlin.reflect.KClass r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r8)
            if (r5 != 0) goto L50
            goto L75
        L50:
            kotlinx.serialization.json.Json r5 = r4.format     // Catch: java.lang.Throwable -> L2a
            r0.label = r3     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r8 = io.ktor.serialization.kotlinx.json.JsonExtensionsJvmKt.deserializeSequence(r5, r7, r6, r0)     // Catch: java.lang.Throwable -> L2a
            if (r8 != r1) goto L5b
            return r1
        L5b:
            return r8
        L5c:
            io.ktor.serialization.JsonConvertException r6 = new io.ktor.serialization.JsonConvertException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Illegal input: "
            r7.<init>(r8)
            java.lang.String r8 = r5.getMessage()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7, r5)
            throw r6
        L75:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions.deserialize(java.nio.charset.Charset, io.ktor.util.reflect.TypeInfo, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object serialize(kotlinx.coroutines.flow.Flow<? extends T> r19, kotlinx.serialization.KSerializer<T> r20, java.nio.charset.Charset r21, io.ktor.utils.io.ByteWriteChannel r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions.serialize(kotlinx.coroutines.flow.Flow, kotlinx.serialization.KSerializer, java.nio.charset.Charset, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
