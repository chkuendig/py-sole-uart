package com.google.ai.client.generativeai.common.client;

import com.android.SdkConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Types.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/google/ai/client/generativeai/common/client/Schema.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/ai/client/generativeai/common/client/Schema;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes3.dex */
public final class Schema$$serializer implements GeneratedSerializer<Schema> {
    public static final Schema$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Schema$$serializer schema$$serializer = new Schema$$serializer();
        INSTANCE = schema$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.ai.client.generativeai.common.client.Schema", schema$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("format", true);
        pluginGeneratedSerialDescriptor.addElement(SdkConstants.ATTR_NULLABLE, true);
        pluginGeneratedSerialDescriptor.addElement(SdkConstants.TAG_ENUM, true);
        pluginGeneratedSerialDescriptor.addElement("properties", true);
        pluginGeneratedSerialDescriptor.addElement("required", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.ITEMS, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Schema$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = Schema.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[4]), BuiltinSerializersKt.getNullable(kSerializerArr[5]), BuiltinSerializersKt.getNullable(kSerializerArr[6]), BuiltinSerializersKt.getNullable(INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Schema deserialize(Decoder decoder) {
        Object objDecodeNullableSerializableElement;
        int i;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        Object objDecodeNullableSerializableElement5;
        String str;
        Object objDecodeNullableSerializableElement6;
        Object objDecodeNullableSerializableElement7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = Schema.$childSerializers;
        int i2 = 7;
        int i3 = 6;
        String strDecodeStringElement = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            objDecodeNullableSerializableElement6 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement7 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            Object objDecodeNullableSerializableElement8 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            objDecodeNullableSerializableElement5 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, kSerializerArr[6], null);
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement8;
            str = strDecodeStringElement2;
            objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, INSTANCE, null);
            i = 255;
        } else {
            boolean z = true;
            int i4 = 0;
            Object objDecodeNullableSerializableElement9 = null;
            Object objDecodeNullableSerializableElement10 = null;
            Object objDecodeNullableSerializableElement11 = null;
            Object objDecodeNullableSerializableElement12 = null;
            Object objDecodeNullableSerializableElement13 = null;
            Object objDecodeNullableSerializableElement14 = null;
            objDecodeNullableSerializableElement = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                    case 0:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i4 |= 1;
                        i2 = 7;
                        i3 = 6;
                    case 1:
                        objDecodeNullableSerializableElement13 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, objDecodeNullableSerializableElement13);
                        i4 |= 2;
                        i2 = 7;
                        i3 = 6;
                    case 2:
                        objDecodeNullableSerializableElement14 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, objDecodeNullableSerializableElement14);
                        i4 |= 4;
                        i2 = 7;
                        i3 = 6;
                    case 3:
                        objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, objDecodeNullableSerializableElement);
                        i4 |= 8;
                        i2 = 7;
                        i3 = 6;
                    case 4:
                        objDecodeNullableSerializableElement12 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], objDecodeNullableSerializableElement12);
                        i4 |= 16;
                        i2 = 7;
                    case 5:
                        objDecodeNullableSerializableElement11 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], objDecodeNullableSerializableElement11);
                        i4 |= 32;
                    case 6:
                        objDecodeNullableSerializableElement10 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, kSerializerArr[i3], objDecodeNullableSerializableElement10);
                        i4 |= 64;
                    case 7:
                        objDecodeNullableSerializableElement9 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, INSTANCE, objDecodeNullableSerializableElement9);
                        i4 |= 128;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i4;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement9;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement10;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement11;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement12;
            str = strDecodeStringElement;
            objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement13;
            objDecodeNullableSerializableElement7 = objDecodeNullableSerializableElement14;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new Schema(i, str, (String) objDecodeNullableSerializableElement6, (String) objDecodeNullableSerializableElement7, (Boolean) objDecodeNullableSerializableElement, (List) objDecodeNullableSerializableElement5, (Map) objDecodeNullableSerializableElement4, (List) objDecodeNullableSerializableElement3, (Schema) objDecodeNullableSerializableElement2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Schema value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        Schema.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
