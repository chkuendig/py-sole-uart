package com.google.ai.client.generativeai.common;

import com.android.utils.PositionXmlParser;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.ai.client.generativeai.common.client.GenerationConfig;
import com.google.ai.client.generativeai.common.client.GenerationConfig$$serializer;
import com.google.ai.client.generativeai.common.client.ToolConfig;
import com.google.ai.client.generativeai.common.client.ToolConfig$$serializer;
import com.google.ai.client.generativeai.common.shared.Content;
import com.google.ai.client.generativeai.common.shared.Content$$serializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Request.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/google/ai/client/generativeai/common/GenerateContentRequest.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/ai/client/generativeai/common/GenerateContentRequest;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes3.dex */
public final class GenerateContentRequest$$serializer implements GeneratedSerializer<GenerateContentRequest> {
    public static final GenerateContentRequest$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GenerateContentRequest$$serializer generateContentRequest$$serializer = new GenerateContentRequest$$serializer();
        INSTANCE = generateContentRequest$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.ai.client.generativeai.common.GenerateContentRequest", generateContentRequest$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement(DeviceRequestsHelper.DEVICE_INFO_MODEL, true);
        pluginGeneratedSerialDescriptor.addElement(PositionXmlParser.CONTENT_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("safety_settings", true);
        pluginGeneratedSerialDescriptor.addElement("generation_config", true);
        pluginGeneratedSerialDescriptor.addElement("tools", true);
        pluginGeneratedSerialDescriptor.addElement("tool_config", true);
        pluginGeneratedSerialDescriptor.addElement("system_instruction", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GenerateContentRequest$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = GenerateContentRequest.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), kSerializerArr[1], BuiltinSerializersKt.getNullable(kSerializerArr[2]), BuiltinSerializersKt.getNullable(GenerationConfig$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[4]), BuiltinSerializersKt.getNullable(ToolConfig$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Content$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public GenerateContentRequest deserialize(Decoder decoder) {
        Object objDecodeNullableSerializableElement;
        int i;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        Object objDecodeSerializableElement;
        Object objDecodeNullableSerializableElement5;
        Object objDecodeNullableSerializableElement6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = GenerateContentRequest.$childSerializers;
        int i2 = 6;
        int i3 = 5;
        Object objDecodeNullableSerializableElement7 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            Object objDecodeNullableSerializableElement8 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            objDecodeNullableSerializableElement5 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, GenerationConfig$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement6 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ToolConfig$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, Content$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement8;
            i = 127;
        } else {
            boolean z = true;
            int i4 = 0;
            Object objDecodeNullableSerializableElement9 = null;
            Object objDecodeNullableSerializableElement10 = null;
            Object objDecodeSerializableElement2 = null;
            objDecodeNullableSerializableElement = null;
            Object objDecodeNullableSerializableElement11 = null;
            Object objDecodeNullableSerializableElement12 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 6;
                    case 0:
                        objDecodeNullableSerializableElement7 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, objDecodeNullableSerializableElement7);
                        i4 |= 1;
                        i2 = 6;
                        i3 = 5;
                    case 1:
                        objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], objDecodeSerializableElement2);
                        i4 |= 2;
                        i2 = 6;
                        i3 = 5;
                    case 2:
                        objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], objDecodeNullableSerializableElement);
                        i4 |= 4;
                        i2 = 6;
                    case 3:
                        objDecodeNullableSerializableElement11 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, GenerationConfig$$serializer.INSTANCE, objDecodeNullableSerializableElement11);
                        i4 |= 8;
                    case 4:
                        objDecodeNullableSerializableElement12 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], objDecodeNullableSerializableElement12);
                        i4 |= 16;
                    case 5:
                        objDecodeNullableSerializableElement10 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, ToolConfig$$serializer.INSTANCE, objDecodeNullableSerializableElement10);
                        i4 |= 32;
                    case 6:
                        objDecodeNullableSerializableElement9 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, Content$$serializer.INSTANCE, objDecodeNullableSerializableElement9);
                        i4 |= 64;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i4;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement9;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement10;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement7;
            objDecodeSerializableElement = objDecodeSerializableElement2;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement11;
            objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement12;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new GenerateContentRequest(i, (String) objDecodeNullableSerializableElement4, (List) objDecodeSerializableElement, (List) objDecodeNullableSerializableElement, (GenerationConfig) objDecodeNullableSerializableElement5, (List) objDecodeNullableSerializableElement6, (ToolConfig) objDecodeNullableSerializableElement3, (Content) objDecodeNullableSerializableElement2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GenerateContentRequest value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        GenerateContentRequest.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
