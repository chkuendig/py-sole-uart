package com.google.ai.client.generativeai.common.shared;

import com.google.firebase.analytics.FirebaseAnalytics;
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

/* compiled from: Types.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/google/ai/client/generativeai/common/shared/SafetySetting.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/ai/client/generativeai/common/shared/SafetySetting;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes3.dex */
public final class SafetySetting$$serializer implements GeneratedSerializer<SafetySetting> {
    public static final SafetySetting$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        SafetySetting$$serializer safetySetting$$serializer = new SafetySetting$$serializer();
        INSTANCE = safetySetting$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.ai.client.generativeai.common.shared.SafetySetting", safetySetting$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("category", false);
        pluginGeneratedSerialDescriptor.addElement("threshold", false);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.METHOD, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SafetySetting$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = SafetySetting.$childSerializers;
        return new KSerializer[]{HarmCategorySerializer.INSTANCE, kSerializerArr[1], BuiltinSerializersKt.getNullable(kSerializerArr[2])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SafetySetting deserialize(Decoder decoder) {
        Object objDecodeSerializableElement;
        int i;
        Object objDecodeSerializableElement2;
        Object objDecodeNullableSerializableElement;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = SafetySetting.$childSerializers;
        Object objDecodeSerializableElement3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, HarmCategorySerializer.INSTANCE, null);
            Object objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            objDecodeSerializableElement = objDecodeSerializableElement4;
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            objDecodeSerializableElement = null;
            Object objDecodeNullableSerializableElement2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, HarmCategorySerializer.INSTANCE, objDecodeSerializableElement3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], objDecodeSerializableElement);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], objDecodeNullableSerializableElement2);
                    i2 |= 4;
                }
            }
            i = i2;
            objDecodeSerializableElement2 = objDecodeSerializableElement3;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new SafetySetting(i, (HarmCategory) objDecodeSerializableElement2, (HarmBlockThreshold) objDecodeSerializableElement, (HarmBlockMethod) objDecodeNullableSerializableElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SafetySetting value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        SafetySetting.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
