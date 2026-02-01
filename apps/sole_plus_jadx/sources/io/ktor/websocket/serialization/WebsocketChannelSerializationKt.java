package io.ktor.websocket.serialization;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.InternalAPI;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.websocket.WebSocketSession;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;

/* compiled from: WebsocketChannelSerialization.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\t\u001a3\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a;\u0010\r\u001a\u00020\u000e\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a;\u0010\r\u001a\u00020\u000e*\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"receiveDeserializedBase", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/websocket/WebSocketSession;", "converter", "Lio/ktor/serialization/WebsocketContentConverter;", HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSerializedBase", "", "data", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websocket-serialization"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WebsocketChannelSerializationKt {

    /* compiled from: WebsocketChannelSerialization.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", i = {0, 0, 0, 1, 1}, l = {95, 104}, m = "receiveDeserializedBase", n = {"typeInfo", "converter", HttpAuthHeader.Parameters.Charset, "typeInfo", TypedValues.AttributesType.S_FRAME}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    /* renamed from: io.ktor.websocket.serialization.WebsocketChannelSerializationKt$receiveDeserializedBase$2, reason: invalid class name */
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebsocketChannelSerializationKt.receiveDeserializedBase(null, null, null, null, this);
        }
    }

    /* compiled from: WebsocketChannelSerialization.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", i = {0}, l = {50, 55}, m = "sendSerializedBase", n = {"$this$sendSerializedBase"}, s = {"L$0"})
    /* renamed from: io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2, reason: invalid class name and case insensitive filesystem */
    static final class C12862 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12862(Continuation<? super C12862> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebsocketChannelSerializationKt.sendSerializedBase(null, null, null, null, null, this);
        }
    }

    @InternalAPI
    public static final /* synthetic */ <T> Object sendSerializedBase(WebSocketSession webSocketSession, Object obj, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<? super Unit> continuation) {
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null);
        InlineMarker.mark(0);
        sendSerializedBase(webSocketSession, obj, typeInfoTypeInfoImpl, websocketContentConverter, charset, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @io.ktor.util.InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object sendSerializedBase(io.ktor.websocket.WebSocketSession r5, java.lang.Object r6, io.ktor.util.reflect.TypeInfo r7, io.ktor.serialization.WebsocketContentConverter r8, java.nio.charset.Charset r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.websocket.serialization.WebsocketChannelSerializationKt.C12862
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2 r0 = (io.ktor.websocket.serialization.WebsocketChannelSerializationKt.C12862) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2 r0 = new io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L5d
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            java.lang.Object r5 = r0.L$0
            io.ktor.websocket.WebSocketSession r5 = (io.ktor.websocket.WebSocketSession) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L4b
        L3d:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r10 = r8.serializeNullable(r9, r7, r6, r0)
            if (r10 != r1) goto L4b
            return r1
        L4b:
            io.ktor.websocket.Frame r10 = (io.ktor.websocket.Frame) r10
            kotlinx.coroutines.channels.SendChannel r5 = r5.getOutgoing()
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.send(r10, r0)
            if (r5 != r1) goto L5d
            return r1
        L5d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.serialization.WebsocketChannelSerializationKt.sendSerializedBase(io.ktor.websocket.WebSocketSession, java.lang.Object, io.ktor.util.reflect.TypeInfo, io.ktor.serialization.WebsocketContentConverter, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @InternalAPI
    public static final /* synthetic */ <T> Object receiveDeserializedBase(WebSocketSession webSocketSession, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<Object> continuation) throws WebsocketDeserializeException {
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null);
        InlineMarker.mark(0);
        Object objReceiveDeserializedBase = receiveDeserializedBase(webSocketSession, typeInfoTypeInfoImpl, websocketContentConverter, charset, continuation);
        InlineMarker.mark(1);
        return objReceiveDeserializedBase;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @io.ktor.util.InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object receiveDeserializedBase(io.ktor.websocket.WebSocketSession r16, io.ktor.util.reflect.TypeInfo r17, io.ktor.serialization.WebsocketContentConverter r18, java.nio.charset.Charset r19, kotlin.coroutines.Continuation<java.lang.Object> r20) throws io.ktor.serialization.WebsocketDeserializeException {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.serialization.WebsocketChannelSerializationKt.receiveDeserializedBase(io.ktor.websocket.WebSocketSession, io.ktor.util.reflect.TypeInfo, io.ktor.serialization.WebsocketContentConverter, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
