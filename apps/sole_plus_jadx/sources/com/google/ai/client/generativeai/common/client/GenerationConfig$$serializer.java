package com.google.ai.client.generativeai.common.client;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Types.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/google/ai/client/generativeai/common/client/GenerationConfig.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/ai/client/generativeai/common/client/GenerationConfig;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes3.dex */
public final class GenerationConfig$$serializer implements GeneratedSerializer<GenerationConfig> {
    public static final GenerationConfig$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GenerationConfig$$serializer generationConfig$$serializer = new GenerationConfig$$serializer();
        INSTANCE = generationConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.ai.client.generativeai.common.client.GenerationConfig", generationConfig$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("temperature", false);
        pluginGeneratedSerialDescriptor.addElement("top_p", false);
        pluginGeneratedSerialDescriptor.addElement("top_k", false);
        pluginGeneratedSerialDescriptor.addElement("candidate_count", false);
        pluginGeneratedSerialDescriptor.addElement("max_output_tokens", false);
        pluginGeneratedSerialDescriptor.addElement("stop_sequences", false);
        pluginGeneratedSerialDescriptor.addElement("response_mime_type", true);
        pluginGeneratedSerialDescriptor.addElement("presence_penalty", true);
        pluginGeneratedSerialDescriptor.addElement("frequency_penalty", true);
        pluginGeneratedSerialDescriptor.addElement("response_schema", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GenerationConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GenerationConfig.$childSerializers[5]), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(Schema$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public GenerationConfig deserialize(Decoder decoder) {
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        Object objDecodeNullableSerializableElement5;
        Object objDecodeNullableSerializableElement6;
        Object objDecodeNullableSerializableElement7;
        Object objDecodeNullableSerializableElement8;
        Object objDecodeNullableSerializableElement9;
        int i;
        Object objDecodeNullableSerializableElement10;
        KSerializer[] kSerializerArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr2 = GenerationConfig.$childSerializers;
        int i2 = 9;
        Object objDecodeNullableSerializableElement11 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            objDecodeNullableSerializableElement10 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, FloatSerializer.INSTANCE, null);
            Object objDecodeNullableSerializableElement12 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, FloatSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement9 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement8 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement6 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr2[5], null);
            objDecodeNullableSerializableElement5 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement7 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, FloatSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, FloatSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, Schema$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement12;
            i = 1023;
        } else {
            boolean z = true;
            int i3 = 0;
            Object objDecodeNullableSerializableElement13 = null;
            Object objDecodeNullableSerializableElement14 = null;
            Object objDecodeNullableSerializableElement15 = null;
            Object objDecodeNullableSerializableElement16 = null;
            Object objDecodeNullableSerializableElement17 = null;
            Object objDecodeNullableSerializableElement18 = null;
            Object objDecodeNullableSerializableElement19 = null;
            Object objDecodeNullableSerializableElement20 = null;
            objDecodeNullableSerializableElement = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        kSerializerArr2 = kSerializerArr2;
                    case 0:
                        kSerializerArr = kSerializerArr2;
                        objDecodeNullableSerializableElement11 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, FloatSerializer.INSTANCE, objDecodeNullableSerializableElement11);
                        i3 |= 1;
                        kSerializerArr2 = kSerializerArr;
                        i2 = 9;
                    case 1:
                        kSerializerArr = kSerializerArr2;
                        objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, FloatSerializer.INSTANCE, objDecodeNullableSerializableElement);
                        i3 |= 2;
                        kSerializerArr2 = kSerializerArr;
                        i2 = 9;
                    case 2:
                        kSerializerArr = kSerializerArr2;
                        objDecodeNullableSerializableElement20 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, objDecodeNullableSerializableElement20);
                        i3 |= 4;
                        kSerializerArr2 = kSerializerArr;
                        i2 = 9;
                    case 3:
                        kSerializerArr = kSerializerArr2;
                        objDecodeNullableSerializableElement19 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, objDecodeNullableSerializableElement19);
                        i3 |= 8;
                        kSerializerArr2 = kSerializerArr;
                        i2 = 9;
                    case 4:
                        kSerializerArr = kSerializerArr2;
                        objDecodeNullableSerializableElement17 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, objDecodeNullableSerializableElement17);
                        i3 |= 16;
                        kSerializerArr2 = kSerializerArr;
                        i2 = 9;
                    case 5:
                        objDecodeNullableSerializableElement15 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr2[5], objDecodeNullableSerializableElement15);
                        i3 |= 32;
                        i2 = 9;
                    case 6:
                        objDecodeNullableSerializableElement16 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, objDecodeNullableSerializableElement16);
                        i3 |= 64;
                        i2 = 9;
                    case 7:
                        objDecodeNullableSerializableElement18 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, FloatSerializer.INSTANCE, objDecodeNullableSerializableElement18);
                        i3 |= 128;
                        i2 = 9;
                    case 8:
                        objDecodeNullableSerializableElement14 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, FloatSerializer.INSTANCE, objDecodeNullableSerializableElement14);
                        i3 |= 256;
                        i2 = 9;
                    case 9:
                        objDecodeNullableSerializableElement13 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, Schema$$serializer.INSTANCE, objDecodeNullableSerializableElement13);
                        i3 |= 512;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement13;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement14;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement15;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement16;
            objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement17;
            objDecodeNullableSerializableElement7 = objDecodeNullableSerializableElement18;
            objDecodeNullableSerializableElement8 = objDecodeNullableSerializableElement19;
            objDecodeNullableSerializableElement9 = objDecodeNullableSerializableElement20;
            i = i3;
            objDecodeNullableSerializableElement10 = objDecodeNullableSerializableElement11;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new GenerationConfig(i, (Float) objDecodeNullableSerializableElement10, (Float) objDecodeNullableSerializableElement, (Integer) objDecodeNullableSerializableElement9, (Integer) objDecodeNullableSerializableElement8, (Integer) objDecodeNullableSerializableElement6, (List) objDecodeNullableSerializableElement4, (String) objDecodeNullableSerializableElement5, (Float) objDecodeNullableSerializableElement7, (Float) objDecodeNullableSerializableElement3, (Schema) objDecodeNullableSerializableElement2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GenerationConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        GenerationConfig.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
