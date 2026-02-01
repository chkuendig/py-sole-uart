package com.google.ai.client.generativeai.common;

import com.google.ai.client.generativeai.common.server.Candidate;
import com.google.ai.client.generativeai.common.server.Candidate$$serializer;
import com.google.ai.client.generativeai.common.server.PromptFeedback;
import com.google.ai.client.generativeai.common.server.PromptFeedback$$serializer;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Response.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB/\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J!\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÇ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/google/ai/client/generativeai/common/GenerateContentResponse;", "Lcom/google/ai/client/generativeai/common/Response;", "seen1", "", "candidates", "", "Lcom/google/ai/client/generativeai/common/server/Candidate;", "promptFeedback", "Lcom/google/ai/client/generativeai/common/server/PromptFeedback;", "usageMetadata", "Lcom/google/ai/client/generativeai/common/UsageMetadata;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/google/ai/client/generativeai/common/server/PromptFeedback;Lcom/google/ai/client/generativeai/common/UsageMetadata;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Lcom/google/ai/client/generativeai/common/server/PromptFeedback;Lcom/google/ai/client/generativeai/common/UsageMetadata;)V", "getCandidates", "()Ljava/util/List;", "getPromptFeedback", "()Lcom/google/ai/client/generativeai/common/server/PromptFeedback;", "getUsageMetadata", "()Lcom/google/ai/client/generativeai/common/UsageMetadata;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class GenerateContentResponse implements Response {
    private final List<Candidate> candidates;
    private final PromptFeedback promptFeedback;
    private final UsageMetadata usageMetadata;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(Candidate$$serializer.INSTANCE), null, null};

    public GenerateContentResponse() {
        this((List) null, (PromptFeedback) null, (UsageMetadata) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GenerateContentResponse copy$default(GenerateContentResponse generateContentResponse, List list, PromptFeedback promptFeedback, UsageMetadata usageMetadata, int i, Object obj) {
        if ((i & 1) != 0) {
            list = generateContentResponse.candidates;
        }
        if ((i & 2) != 0) {
            promptFeedback = generateContentResponse.promptFeedback;
        }
        if ((i & 4) != 0) {
            usageMetadata = generateContentResponse.usageMetadata;
        }
        return generateContentResponse.copy(list, promptFeedback, usageMetadata);
    }

    public final List<Candidate> component1() {
        return this.candidates;
    }

    /* renamed from: component2, reason: from getter */
    public final PromptFeedback getPromptFeedback() {
        return this.promptFeedback;
    }

    /* renamed from: component3, reason: from getter */
    public final UsageMetadata getUsageMetadata() {
        return this.usageMetadata;
    }

    public final GenerateContentResponse copy(List<Candidate> candidates, PromptFeedback promptFeedback, UsageMetadata usageMetadata) {
        return new GenerateContentResponse(candidates, promptFeedback, usageMetadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GenerateContentResponse)) {
            return false;
        }
        GenerateContentResponse generateContentResponse = (GenerateContentResponse) other;
        return Intrinsics.areEqual(this.candidates, generateContentResponse.candidates) && Intrinsics.areEqual(this.promptFeedback, generateContentResponse.promptFeedback) && Intrinsics.areEqual(this.usageMetadata, generateContentResponse.usageMetadata);
    }

    public int hashCode() {
        List<Candidate> list = this.candidates;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        PromptFeedback promptFeedback = this.promptFeedback;
        int iHashCode2 = (iHashCode + (promptFeedback == null ? 0 : promptFeedback.hashCode())) * 31;
        UsageMetadata usageMetadata = this.usageMetadata;
        return iHashCode2 + (usageMetadata != null ? usageMetadata.hashCode() : 0);
    }

    public String toString() {
        return "GenerateContentResponse(candidates=" + this.candidates + ", promptFeedback=" + this.promptFeedback + ", usageMetadata=" + this.usageMetadata + ")";
    }

    /* compiled from: Response.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/google/ai/client/generativeai/common/GenerateContentResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/ai/client/generativeai/common/GenerateContentResponse;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GenerateContentResponse> serializer() {
            return GenerateContentResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ GenerateContentResponse(int i, List list, PromptFeedback promptFeedback, UsageMetadata usageMetadata, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.candidates = null;
        } else {
            this.candidates = list;
        }
        if ((i & 2) == 0) {
            this.promptFeedback = null;
        } else {
            this.promptFeedback = promptFeedback;
        }
        if ((i & 4) == 0) {
            this.usageMetadata = null;
        } else {
            this.usageMetadata = usageMetadata;
        }
    }

    public GenerateContentResponse(List<Candidate> list, PromptFeedback promptFeedback, UsageMetadata usageMetadata) {
        this.candidates = list;
        this.promptFeedback = promptFeedback;
        this.usageMetadata = usageMetadata;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(GenerateContentResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.candidates != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.candidates);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.promptFeedback != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, PromptFeedback$$serializer.INSTANCE, self.promptFeedback);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.usageMetadata == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, UsageMetadata$$serializer.INSTANCE, self.usageMetadata);
    }

    public /* synthetic */ GenerateContentResponse(List list, PromptFeedback promptFeedback, UsageMetadata usageMetadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : promptFeedback, (i & 4) != 0 ? null : usageMetadata);
    }

    public final List<Candidate> getCandidates() {
        return this.candidates;
    }

    public final PromptFeedback getPromptFeedback() {
        return this.promptFeedback;
    }

    public final UsageMetadata getUsageMetadata() {
        return this.usageMetadata;
    }
}
