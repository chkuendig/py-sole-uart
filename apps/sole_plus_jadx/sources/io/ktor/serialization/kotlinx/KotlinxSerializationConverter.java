package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.ByteArrayContent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.serialization.ContentConverter;
import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.StringFormat;

/* compiled from: KotlinxSerializationConverter.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J/\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J5\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\tH\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J:\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002J7\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxSerializationConverter;", "Lio/ktor/serialization/ContentConverter;", "format", "Lkotlinx/serialization/SerialFormat;", "(Lkotlinx/serialization/SerialFormat;)V", "extensions", "", "Lio/ktor/serialization/kotlinx/KotlinxSerializationExtension;", "deserialize", "", HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serialize", "Lio/ktor/http/content/OutgoingContent;", "contentType", "Lio/ktor/http/ContentType;", "value", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serializeContent", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "serializer", "Lkotlinx/serialization/KSerializer;", "serializeNullable", "ktor-serialization-kotlinx"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class KotlinxSerializationConverter implements ContentConverter {
    private final List<KotlinxSerializationExtension> extensions;
    private final SerialFormat format;

    /* compiled from: KotlinxSerializationConverter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {74, 78}, m = "deserialize", n = {"this", HttpAuthHeader.Parameters.Charset, "typeInfo", "content", "this", HttpAuthHeader.Parameters.Charset, "serializer"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
    /* renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationConverter.this.deserialize(null, null, null, this);
        }
    }

    /* compiled from: KotlinxSerializationConverter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", i = {0, 0, 0, 0, 0}, l = {59}, m = "serializeNullable", n = {"this", "contentType", HttpAuthHeader.Parameters.Charset, "typeInfo", "value"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1, reason: invalid class name and case insensitive filesystem */
    static final class C11601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C11601(Continuation<? super C11601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationConverter.this.serializeNullable(null, null, null, null, this);
        }
    }

    public KotlinxSerializationConverter(SerialFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        this.extensions = ExtensionsKt.extensions(format);
        if (!(format instanceof BinaryFormat) && !(format instanceof StringFormat)) {
            throw new IllegalArgumentException(("Only binary and string formats are supported, " + format + " is not supported.").toString());
        }
    }

    @Override // io.ktor.serialization.ContentConverter
    @Deprecated(level = DeprecationLevel.WARNING, message = "Please override and use serializeNullable instead", replaceWith = @ReplaceWith(expression = "serializeNullable(charset, typeInfo, contentType, value)", imports = {}))
    public Object serialize(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super OutgoingContent> continuation) {
        return serializeNullable(contentType, charset, typeInfo, obj, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object serializeNullable(final io.ktor.http.ContentType r11, final java.nio.charset.Charset r12, final io.ktor.util.reflect.TypeInfo r13, final java.lang.Object r14, kotlin.coroutines.Continuation<? super io.ktor.http.content.OutgoingContent> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof io.ktor.serialization.kotlinx.KotlinxSerializationConverter.C11601
            if (r0 == 0) goto L14
            r0 = r15
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1 r0 = (io.ktor.serialization.kotlinx.KotlinxSerializationConverter.C11601) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1 r0 = new io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1
            r0.<init>(r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4a
            if (r2 != r3) goto L42
            java.lang.Object r14 = r0.L$4
            java.lang.Object r11 = r0.L$3
            r13 = r11
            io.ktor.util.reflect.TypeInfo r13 = (io.ktor.util.reflect.TypeInfo) r13
            java.lang.Object r11 = r0.L$2
            r12 = r11
            java.nio.charset.Charset r12 = (java.nio.charset.Charset) r12
            java.lang.Object r11 = r0.L$1
            io.ktor.http.ContentType r11 = (io.ktor.http.ContentType) r11
            java.lang.Object r0 = r0.L$0
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter r0 = (io.ktor.serialization.kotlinx.KotlinxSerializationConverter) r0
            kotlin.ResultKt.throwOnFailure(r15)
            r6 = r11
            r7 = r12
            r5 = r14
            r2 = r0
            goto L80
        L42:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L4a:
            kotlin.ResultKt.throwOnFailure(r15)
            java.util.List<io.ktor.serialization.kotlinx.KotlinxSerializationExtension> r15 = r10.extensions
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            kotlinx.coroutines.flow.Flow r5 = kotlinx.coroutines.flow.FlowKt.asFlow(r15)
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$$inlined$map$1 r15 = new io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$$inlined$map$1
            r4 = r15
            r6 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r4.<init>()
            kotlinx.coroutines.flow.Flow r15 = (kotlinx.coroutines.flow.Flow) r15
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$fromExtension$2 r2 = new io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$fromExtension$2
            r4 = 0
            r2.<init>(r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r13
            r0.L$4 = r14
            r0.label = r3
            java.lang.Object r15 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r15, r2, r0)
            if (r15 != r1) goto L7c
            return r1
        L7c:
            r2 = r10
            r6 = r11
            r7 = r12
            r5 = r14
        L80:
            io.ktor.http.content.OutgoingContent r15 = (io.ktor.http.content.OutgoingContent) r15
            if (r15 == 0) goto L85
            return r15
        L85:
            kotlinx.serialization.SerialFormat r11 = r2.format     // Catch: kotlinx.serialization.SerializationException -> L90
            kotlinx.serialization.modules.SerializersModule r11 = r11.getSerializersModule()     // Catch: kotlinx.serialization.SerializationException -> L90
            kotlinx.serialization.KSerializer r11 = io.ktor.serialization.kotlinx.SerializerLookupKt.serializerForTypeInfo(r11, r13)     // Catch: kotlinx.serialization.SerializationException -> L90
            goto L9a
        L90:
            kotlinx.serialization.SerialFormat r11 = r2.format
            kotlinx.serialization.modules.SerializersModule r11 = r11.getSerializersModule()
            kotlinx.serialization.KSerializer r11 = io.ktor.serialization.kotlinx.SerializerLookupKt.guessSerializer(r5, r11)
        L9a:
            r3 = r11
            kotlinx.serialization.SerialFormat r4 = r2.format
            io.ktor.http.content.OutgoingContent$ByteArrayContent r11 = r2.serializeContent(r3, r4, r5, r6, r7)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.KotlinxSerializationConverter.serializeNullable(io.ktor.http.ContentType, java.nio.charset.Charset, io.ktor.util.reflect.TypeInfo, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00cd A[Catch: all -> 0x010b, TryCatch #0 {all -> 0x010b, blocks: (B:29:0x00c6, B:31:0x00cd, B:32:0x00dc, B:34:0x00e0, B:36:0x00ed, B:37:0x010a), top: B:42:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc A[Catch: all -> 0x010b, TryCatch #0 {all -> 0x010b, blocks: (B:29:0x00c6, B:31:0x00cd, B:32:0x00dc, B:34:0x00e0, B:36:0x00ed, B:37:0x010a), top: B:42:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object deserialize(java.nio.charset.Charset r18, io.ktor.util.reflect.TypeInfo r19, final io.ktor.utils.io.ByteReadChannel r20, kotlin.coroutines.Continuation<java.lang.Object> r21) throws io.ktor.serialization.JsonConvertException {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.KotlinxSerializationConverter.deserialize(java.nio.charset.Charset, io.ktor.util.reflect.TypeInfo, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final OutgoingContent.ByteArrayContent serializeContent(KSerializer<?> serializer, SerialFormat format, Object value, ContentType contentType, Charset charset) {
        if (format instanceof StringFormat) {
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            return new TextContent(((StringFormat) format).encodeToString(serializer, value), ContentTypesKt.withCharsetIfNeeded(contentType, charset), null, 4, null);
        }
        if (format instanceof BinaryFormat) {
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            return new ByteArrayContent(((BinaryFormat) format).encodeToByteArray(serializer, value), contentType, null, 4, null);
        }
        throw new IllegalStateException(("Unsupported format " + format).toString());
    }
}
