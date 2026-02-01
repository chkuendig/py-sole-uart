package kotlinx.serialization.json.internal;

import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonClassDiscriminator;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.objectweb.asm.Opcodes;

/* compiled from: Polymorphic.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u001ai\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u000226\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\bH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a(\u0010\u000f\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0000\u001a7\u0010\u0015\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u001aH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a\u0014\u0010\u0011\u001a\u00020\t*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a\u001a\u0010\u001f\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\"H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"encodePolymorphically", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/json/JsonEncoder;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "ifPolymorphic", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "discriminatorName", "serialName", "(Lkotlinx/serialization/json/JsonEncoder;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "validateIfSealed", "actualSerializer", "classDiscriminator", "checkKind", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "decodeSerializableValuePolymorphic", "Lkotlinx/serialization/json/JsonDecoder;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "path", "Lkotlin/Function0;", "(Lkotlinx/serialization/json/JsonDecoder;Lkotlinx/serialization/DeserializationStrategy;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", SdkConstants.EXT_JSON, "Lkotlinx/serialization/json/Json;", "throwJsonElementPolymorphicException", "", "element", "Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PolymorphicKt {

    /* compiled from: Polymorphic.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = Opcodes.ARETURN)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClassDiscriminatorMode.values().length];
            try {
                iArr[ClassDiscriminatorMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClassDiscriminatorMode.POLYMORPHIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClassDiscriminatorMode.ALL_JSON_OBJECTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> void encodePolymorphically(kotlinx.serialization.json.JsonEncoder r3, kotlinx.serialization.SerializationStrategy<? super T> r4, T r5, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "ifPolymorphic"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlinx.serialization.json.Json r0 = r3.getJson()
            kotlinx.serialization.json.JsonConfiguration r0 = r0.getConfiguration()
            boolean r0 = r0.getUseArrayPolymorphism()
            if (r0 == 0) goto L23
            kotlinx.serialization.encoding.Encoder r3 = (kotlinx.serialization.encoding.Encoder) r3
            r4.serialize(r3, r5)
            return
        L23:
            boolean r0 = r4 instanceof kotlinx.serialization.internal.AbstractPolymorphicSerializer
            if (r0 == 0) goto L38
            kotlinx.serialization.json.Json r1 = r3.getJson()
            kotlinx.serialization.json.JsonConfiguration r1 = r1.getConfiguration()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.getClassDiscriminatorMode()
            kotlinx.serialization.json.ClassDiscriminatorMode r2 = kotlinx.serialization.json.ClassDiscriminatorMode.NONE
            if (r1 == r2) goto L80
            goto L6d
        L38:
            kotlinx.serialization.json.Json r1 = r3.getJson()
            kotlinx.serialization.json.JsonConfiguration r1 = r1.getConfiguration()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.getClassDiscriminatorMode()
            int[] r2 = kotlinx.serialization.json.internal.PolymorphicKt.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L80
            r2 = 2
            if (r1 == r2) goto L80
            r2 = 3
            if (r1 != r2) goto L7a
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            kotlinx.serialization.descriptors.SerialKind r1 = r1.getKind()
            kotlinx.serialization.descriptors.StructureKind$CLASS r2 = kotlinx.serialization.descriptors.StructureKind.CLASS.INSTANCE
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r2 != 0) goto L6d
            kotlinx.serialization.descriptors.StructureKind$OBJECT r2 = kotlinx.serialization.descriptors.StructureKind.OBJECT.INSTANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L80
        L6d:
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            kotlinx.serialization.json.Json r2 = r3.getJson()
            java.lang.String r1 = classDiscriminator(r1, r2)
            goto L81
        L7a:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L80:
            r1 = 0
        L81:
            if (r0 == 0) goto Lc9
            r0 = r4
            kotlinx.serialization.internal.AbstractPolymorphicSerializer r0 = (kotlinx.serialization.internal.AbstractPolymorphicSerializer) r0
            if (r5 == 0) goto La6
            r2 = r3
            kotlinx.serialization.encoding.Encoder r2 = (kotlinx.serialization.encoding.Encoder) r2
            kotlinx.serialization.SerializationStrategy r0 = kotlinx.serialization.PolymorphicSerializerKt.findPolymorphicSerializer(r0, r2, r5)
            if (r1 == 0) goto L94
            access$validateIfSealed(r4, r0, r1)
        L94:
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r0.getDescriptor()
            kotlinx.serialization.descriptors.SerialKind r4 = r4.getKind()
            checkKind(r4)
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r4)
            r4 = r0
            goto Lc9
        La6:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Value for serializer "
            r3.<init>(r4)
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r0.getDescriptor()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = " should always be non-null. Please report issue to the kotlinx.serialization tracker."
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        Lc9:
            if (r1 == 0) goto Ld6
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r4.getDescriptor()
            java.lang.String r0 = r0.getSerialName()
            r6.invoke(r1, r0)
        Ld6:
            kotlinx.serialization.encoding.Encoder r3 = (kotlinx.serialization.encoding.Encoder) r3
            r4.serialize(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically(kotlinx.serialization.json.JsonEncoder, kotlinx.serialization.SerializationStrategy, java.lang.Object, kotlin.jvm.functions.Function2):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateIfSealed(SerializationStrategy<?> serializationStrategy, SerializationStrategy<?> serializationStrategy2, String str) {
        if ((serializationStrategy instanceof SealedClassSerializer) && JsonInternalDependenciesKt.jsonCachedSerialNames(serializationStrategy2.getDescriptor()).contains(str)) {
            throw new IllegalStateException(("Sealed class '" + serializationStrategy2.getDescriptor().getSerialName() + "' cannot be serialized as base class '" + ((SealedClassSerializer) serializationStrategy).getDescriptor().getSerialName() + "' because it has property name that conflicts with JSON class discriminator '" + str + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
        }
    }

    public static final void checkKind(SerialKind kind) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (kind instanceof SerialKind.ENUM) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        }
        if (kind instanceof PrimitiveKind) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        }
        if (kind instanceof PolymorphicKind) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
        }
    }

    public static final <T> T decodeSerializableValuePolymorphic(JsonDecoder jsonDecoder, DeserializationStrategy<? extends T> deserializer, Function0<String> path) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(jsonDecoder, "<this>");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(path, "path");
        if (!(deserializer instanceof AbstractPolymorphicSerializer) || jsonDecoder.getJson().getConfiguration().getUseArrayPolymorphism()) {
            return deserializer.deserialize(jsonDecoder);
        }
        AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) deserializer;
        String strClassDiscriminator = classDiscriminator(abstractPolymorphicSerializer.getDescriptor(), jsonDecoder.getJson());
        JsonElement jsonElementDecodeJsonElement = jsonDecoder.decodeJsonElement();
        String serialName = abstractPolymorphicSerializer.getDescriptor().getSerialName();
        if (jsonElementDecodeJsonElement instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) jsonElementDecodeJsonElement;
            JsonElement jsonElement = (JsonElement) jsonObject.get((Object) strClassDiscriminator);
            try {
                DeserializationStrategy deserializationStrategyFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializer, jsonDecoder, (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getContentOrNull(jsonPrimitive));
                Intrinsics.checkNotNull(deserializationStrategyFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                return (T) TreeJsonDecoderKt.readPolymorphicJson(jsonDecoder.getJson(), strClassDiscriminator, jsonObject, deserializationStrategyFindPolymorphicSerializer);
            } catch (SerializationException e) {
                String message = e.getMessage();
                Intrinsics.checkNotNull(message);
                throw JsonExceptionsKt.JsonDecodingException(-1, message, jsonObject.toString());
            }
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementDecodeJsonElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + path.invoke(), jsonElementDecodeJsonElement.toString());
    }

    public static final String classDiscriminator(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        for (Annotation annotation : serialDescriptor.getAnnotations()) {
            if (annotation instanceof JsonClassDiscriminator) {
                return ((JsonClassDiscriminator) annotation).discriminator();
            }
        }
        return json.getConfiguration().getClassDiscriminator();
    }

    public static final Void throwJsonElementPolymorphicException(String str, JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        throw new JsonEncodingException("Class with serial name " + str + " cannot be serialized polymorphically because it is represented as " + Reflection.getOrCreateKotlinClass(element.getClass()).getSimpleName() + ". Make sure that its JsonTransformingSerializer returns JsonObject, so class discriminator can be added to it.");
    }
}
