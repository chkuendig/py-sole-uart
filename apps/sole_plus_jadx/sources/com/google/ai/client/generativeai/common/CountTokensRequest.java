package com.google.ai.client.generativeai.common;

import com.android.utils.PositionXmlParser;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.ai.client.generativeai.common.client.Tool;
import com.google.ai.client.generativeai.common.client.Tool$$serializer;
import com.google.ai.client.generativeai.common.shared.Content;
import com.google.ai.client.generativeai.common.shared.Content$$serializer;
import com.google.ai.client.generativeai.common.util.UtilKt;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Request.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BY\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010BM\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001J!\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/HÇ\u0001R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u00062"}, d2 = {"Lcom/google/ai/client/generativeai/common/CountTokensRequest;", "Lcom/google/ai/client/generativeai/common/Request;", "seen1", "", "generateContentRequest", "Lcom/google/ai/client/generativeai/common/GenerateContentRequest;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", PositionXmlParser.CONTENT_KEY, "", "Lcom/google/ai/client/generativeai/common/shared/Content;", "tools", "Lcom/google/ai/client/generativeai/common/client/Tool;", "systemInstruction", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/ai/client/generativeai/common/GenerateContentRequest;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/google/ai/client/generativeai/common/shared/Content;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/google/ai/client/generativeai/common/GenerateContentRequest;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/google/ai/client/generativeai/common/shared/Content;)V", "getContents", "()Ljava/util/List;", "getGenerateContentRequest", "()Lcom/google/ai/client/generativeai/common/GenerateContentRequest;", "getModel", "()Ljava/lang/String;", "getSystemInstruction$annotations", "()V", "getSystemInstruction", "()Lcom/google/ai/client/generativeai/common/shared/Content;", "getTools", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class CountTokensRequest implements Request {
    private final List<Content> contents;
    private final GenerateContentRequest generateContentRequest;
    private final String model;
    private final Content systemInstruction;
    private final List<Tool> tools;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(Content$$serializer.INSTANCE), new ArrayListSerializer(Tool$$serializer.INSTANCE), null};

    public CountTokensRequest() {
        this((GenerateContentRequest) null, (String) null, (List) null, (List) null, (Content) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CountTokensRequest copy$default(CountTokensRequest countTokensRequest, GenerateContentRequest generateContentRequest, String str, List list, List list2, Content content, int i, Object obj) {
        if ((i & 1) != 0) {
            generateContentRequest = countTokensRequest.generateContentRequest;
        }
        if ((i & 2) != 0) {
            str = countTokensRequest.model;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            list = countTokensRequest.contents;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = countTokensRequest.tools;
        }
        List list4 = list2;
        if ((i & 16) != 0) {
            content = countTokensRequest.systemInstruction;
        }
        return countTokensRequest.copy(generateContentRequest, str2, list3, list4, content);
    }

    @SerialName("system_instruction")
    public static /* synthetic */ void getSystemInstruction$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final GenerateContentRequest getGenerateContentRequest() {
        return this.generateContentRequest;
    }

    /* renamed from: component2, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    public final List<Content> component3() {
        return this.contents;
    }

    public final List<Tool> component4() {
        return this.tools;
    }

    /* renamed from: component5, reason: from getter */
    public final Content getSystemInstruction() {
        return this.systemInstruction;
    }

    public final CountTokensRequest copy(GenerateContentRequest generateContentRequest, String model, List<Content> contents, List<Tool> tools, Content systemInstruction) {
        return new CountTokensRequest(generateContentRequest, model, contents, tools, systemInstruction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountTokensRequest)) {
            return false;
        }
        CountTokensRequest countTokensRequest = (CountTokensRequest) other;
        return Intrinsics.areEqual(this.generateContentRequest, countTokensRequest.generateContentRequest) && Intrinsics.areEqual(this.model, countTokensRequest.model) && Intrinsics.areEqual(this.contents, countTokensRequest.contents) && Intrinsics.areEqual(this.tools, countTokensRequest.tools) && Intrinsics.areEqual(this.systemInstruction, countTokensRequest.systemInstruction);
    }

    public int hashCode() {
        GenerateContentRequest generateContentRequest = this.generateContentRequest;
        int iHashCode = (generateContentRequest == null ? 0 : generateContentRequest.hashCode()) * 31;
        String str = this.model;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<Content> list = this.contents;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<Tool> list2 = this.tools;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Content content = this.systemInstruction;
        return iHashCode4 + (content != null ? content.hashCode() : 0);
    }

    public String toString() {
        return "CountTokensRequest(generateContentRequest=" + this.generateContentRequest + ", model=" + this.model + ", contents=" + this.contents + ", tools=" + this.tools + ", systemInstruction=" + this.systemInstruction + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CountTokensRequest(int i, GenerateContentRequest generateContentRequest, String str, List list, List list2, @SerialName("system_instruction") Content content, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.generateContentRequest = null;
        } else {
            this.generateContentRequest = generateContentRequest;
        }
        if ((i & 2) == 0) {
            this.model = null;
        } else {
            this.model = str;
        }
        if ((i & 4) == 0) {
            this.contents = null;
        } else {
            this.contents = list;
        }
        if ((i & 8) == 0) {
            this.tools = null;
        } else {
            this.tools = list2;
        }
        if ((i & 16) == 0) {
            this.systemInstruction = null;
        } else {
            this.systemInstruction = content;
        }
    }

    public CountTokensRequest(GenerateContentRequest generateContentRequest, String str, List<Content> list, List<Tool> list2, Content content) {
        this.generateContentRequest = generateContentRequest;
        this.model = str;
        this.contents = list;
        this.tools = list2;
        this.systemInstruction = content;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(CountTokensRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.generateContentRequest != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, GenerateContentRequest$$serializer.INSTANCE, self.generateContentRequest);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.model != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.model);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.contents != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.contents);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.tools != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.tools);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.systemInstruction == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, Content$$serializer.INSTANCE, self.systemInstruction);
    }

    public /* synthetic */ CountTokensRequest(GenerateContentRequest generateContentRequest, String str, List list, List list2, Content content, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : generateContentRequest, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : content);
    }

    public final GenerateContentRequest getGenerateContentRequest() {
        return this.generateContentRequest;
    }

    public final String getModel() {
        return this.model;
    }

    public final List<Content> getContents() {
        return this.contents;
    }

    public final List<Tool> getTools() {
        return this.tools;
    }

    public final Content getSystemInstruction() {
        return this.systemInstruction;
    }

    /* compiled from: Request.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tHÆ\u0001¨\u0006\n"}, d2 = {"Lcom/google/ai/client/generativeai/common/CountTokensRequest$Companion;", "", "()V", "forGenAI", "Lcom/google/ai/client/generativeai/common/CountTokensRequest;", "generateContentRequest", "Lcom/google/ai/client/generativeai/common/GenerateContentRequest;", "forVertexAI", "serializer", "Lkotlinx/serialization/KSerializer;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CountTokensRequest> serializer() {
            return CountTokensRequest$$serializer.INSTANCE;
        }

        public final CountTokensRequest forGenAI(GenerateContentRequest generateContentRequest) {
            GenerateContentRequest generateContentRequestCopy$default;
            Intrinsics.checkNotNullParameter(generateContentRequest, "generateContentRequest");
            String model = generateContentRequest.getModel();
            return new CountTokensRequest((model == null || (generateContentRequestCopy$default = GenerateContentRequest.copy$default(generateContentRequest, UtilKt.fullModelName(model), null, null, null, null, null, null, 126, null)) == null) ? generateContentRequest : generateContentRequestCopy$default, (String) null, (List) null, (List) null, (Content) null, 30, (DefaultConstructorMarker) null);
        }

        public final CountTokensRequest forVertexAI(GenerateContentRequest generateContentRequest) {
            Intrinsics.checkNotNullParameter(generateContentRequest, "generateContentRequest");
            String model = generateContentRequest.getModel();
            return new CountTokensRequest((GenerateContentRequest) null, model != null ? UtilKt.fullModelName(model) : null, generateContentRequest.getContents(), generateContentRequest.getTools(), generateContentRequest.getSystemInstruction(), 1, (DefaultConstructorMarker) null);
        }
    }
}
