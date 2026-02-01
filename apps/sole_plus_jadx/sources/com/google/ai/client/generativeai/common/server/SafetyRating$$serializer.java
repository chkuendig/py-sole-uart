package com.google.ai.client.generativeai.common.server;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.ai.client.generativeai.common.shared.HarmCategory;
import com.google.ai.client.generativeai.common.shared.HarmCategorySerializer;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Types.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/google/ai/client/generativeai/common/server/SafetyRating.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/ai/client/generativeai/common/server/SafetyRating;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes3.dex */
public final class SafetyRating$$serializer implements GeneratedSerializer<SafetyRating> {
    public static final SafetyRating$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        SafetyRating$$serializer safetyRating$$serializer = new SafetyRating$$serializer();
        INSTANCE = safetyRating$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.ai.client.generativeai.common.server.SafetyRating", safetyRating$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("category", false);
        pluginGeneratedSerialDescriptor.addElement("probability", false);
        pluginGeneratedSerialDescriptor.addElement("blocked", true);
        pluginGeneratedSerialDescriptor.addElement("probabilityScore", true);
        pluginGeneratedSerialDescriptor.addElement(SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, true);
        pluginGeneratedSerialDescriptor.addElement("severityScore", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SafetyRating$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{HarmCategorySerializer.INSTANCE, HarmProbabilitySerializer.INSTANCE, BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(SafetyRating.$childSerializers[4]), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SafetyRating deserialize(Decoder decoder) {
        Object objDecodeSerializableElement;
        int i;
        Object objDecodeSerializableElement2;
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = SafetyRating.$childSerializers;
        int i2 = 5;
        Object objDecodeSerializableElement3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, HarmCategorySerializer.INSTANCE, null);
            Object objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, HarmProbabilitySerializer.INSTANCE, null);
            objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, FloatSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, FloatSerializer.INSTANCE, null);
            objDecodeSerializableElement = objDecodeSerializableElement4;
            i = 63;
        } else {
            boolean z = true;
            int i3 = 0;
            objDecodeSerializableElement = null;
            Object objDecodeNullableSerializableElement5 = null;
            Object objDecodeNullableSerializableElement6 = null;
            Object objDecodeNullableSerializableElement7 = null;
            Object objDecodeNullableSerializableElement8 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 5;
                    case 0:
                        objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, HarmCategorySerializer.INSTANCE, objDecodeSerializableElement3);
                        i3 |= 1;
                        i2 = 5;
                    case 1:
                        objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, HarmProbabilitySerializer.INSTANCE, objDecodeSerializableElement);
                        i3 |= 2;
                    case 2:
                        objDecodeNullableSerializableElement5 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, objDecodeNullableSerializableElement5);
                        i3 |= 4;
                    case 3:
                        objDecodeNullableSerializableElement6 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, FloatSerializer.INSTANCE, objDecodeNullableSerializableElement6);
                        i3 |= 8;
                    case 4:
                        objDecodeNullableSerializableElement7 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], objDecodeNullableSerializableElement7);
                        i3 |= 16;
                    case 5:
                        objDecodeNullableSerializableElement8 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, FloatSerializer.INSTANCE, objDecodeNullableSerializableElement8);
                        i3 |= 32;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i3;
            objDecodeSerializableElement2 = objDecodeSerializableElement3;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement5;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement6;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement7;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement8;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new SafetyRating(i, (HarmCategory) objDecodeSerializableElement2, (HarmProbability) objDecodeSerializableElement, (Boolean) objDecodeNullableSerializableElement, (Float) objDecodeNullableSerializableElement2, (HarmSeverity) objDecodeNullableSerializableElement3, (Float) objDecodeNullableSerializableElement4, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SafetyRating value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        SafetyRating.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
