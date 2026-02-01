package io.ktor.serialization.kotlinx;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketConverterNotFoundException;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import io.ktor.websocket.FrameCommonKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.StringFormat;

/* compiled from: KotlinxWebsocketSerializationConverter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016J&\u0010\u0012\u001a\u00020\r2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002J/\u0010\u0016\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxWebsocketSerializationConverter;", "Lio/ktor/serialization/WebsocketContentConverter;", "format", "Lkotlinx/serialization/SerialFormat;", "(Lkotlinx/serialization/SerialFormat;)V", "deserialize", "", HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "content", "Lio/ktor/websocket/Frame;", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isApplicable", "", TypedValues.AttributesType.S_FRAME, "serializeContent", "serializer", "Lkotlinx/serialization/KSerializer;", "value", "serializeNullable", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-serialization-kotlinx"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class KotlinxWebsocketSerializationConverter implements WebsocketContentConverter {
    private final SerialFormat format;

    public KotlinxWebsocketSerializationConverter(SerialFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        if (!(format instanceof BinaryFormat) && !(format instanceof StringFormat)) {
            throw new IllegalArgumentException(("Only binary and string formats are supported, " + format + " is not supported.").toString());
        }
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public Object serialize(Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super Frame> continuation) {
        return WebsocketContentConverter.DefaultImpls.serialize(this, charset, typeInfo, obj, continuation);
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public Object serializeNullable(Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super Frame> continuation) {
        KSerializer<?> kSerializerGuessSerializer;
        try {
            kSerializerGuessSerializer = SerializerLookupKt.serializerForTypeInfo(this.format.getSerializersModule(), typeInfo);
        } catch (SerializationException unused) {
            kSerializerGuessSerializer = SerializerLookupKt.guessSerializer(obj, this.format.getSerializersModule());
        }
        return serializeContent(kSerializerGuessSerializer, this.format, obj);
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public Object deserialize(Charset charset, TypeInfo typeInfo, Frame frame, Continuation<Object> continuation) throws WebsocketDeserializeException, WebsocketConverterNotFoundException {
        if (!isApplicable(frame)) {
            throw new WebsocketConverterNotFoundException("Unsupported frame " + frame.getFrameType().name(), null, 2, null);
        }
        KSerializer<?> kSerializerSerializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(this.format.getSerializersModule(), typeInfo);
        SerialFormat serialFormat = this.format;
        if (serialFormat instanceof StringFormat) {
            if (frame instanceof Frame.Text) {
                return ((StringFormat) serialFormat).decodeFromString(kSerializerSerializerForTypeInfo, FrameCommonKt.readText((Frame.Text) frame));
            }
            throw new WebsocketDeserializeException("Unsupported format " + this.format + " for " + frame.getFrameType().name(), null, frame, 2, null);
        }
        if (serialFormat instanceof BinaryFormat) {
            if (frame instanceof Frame.Binary) {
                return ((BinaryFormat) serialFormat).decodeFromByteArray(kSerializerSerializerForTypeInfo, FrameCommonKt.readBytes(frame));
            }
            throw new WebsocketDeserializeException("Unsupported format " + this.format + " for " + frame.getFrameType().name(), null, frame, 2, null);
        }
        throw new IllegalStateException(("Unsupported format " + this.format).toString());
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public boolean isApplicable(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        return (frame instanceof Frame.Text) || (frame instanceof Frame.Binary);
    }

    private final Frame serializeContent(KSerializer<?> serializer, SerialFormat format, Object value) {
        if (format instanceof StringFormat) {
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            return new Frame.Text(((StringFormat) format).encodeToString(serializer, value));
        }
        if (format instanceof BinaryFormat) {
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            return new Frame.Binary(true, ((BinaryFormat) format).encodeToByteArray(serializer, value));
        }
        throw new IllegalStateException(("Unsupported format " + format).toString());
    }
}
