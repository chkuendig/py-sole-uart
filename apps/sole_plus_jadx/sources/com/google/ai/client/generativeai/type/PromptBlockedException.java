package com.google.ai.client.generativeai.type;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/ai/client/generativeai/type/PromptBlockedException;", "Lcom/google/ai/client/generativeai/type/GoogleGenerativeAIException;", "response", "Lcom/google/ai/client/generativeai/type/GenerateContentResponse;", "cause", "", "(Lcom/google/ai/client/generativeai/type/GenerateContentResponse;Ljava/lang/Throwable;)V", "getResponse", "()Lcom/google/ai/client/generativeai/type/GenerateContentResponse;", "generativeai_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PromptBlockedException extends GoogleGenerativeAIException {
    private final GenerateContentResponse response;

    public /* synthetic */ PromptBlockedException(GenerateContentResponse generateContentResponse, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(generateContentResponse, (i & 2) != 0 ? null : th);
    }

    public final GenerateContentResponse getResponse() {
        return this.response;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PromptBlockedException(GenerateContentResponse response, Throwable th) {
        BlockReason blockReason;
        Intrinsics.checkNotNullParameter(response, "response");
        PromptFeedback promptFeedback = response.getPromptFeedback();
        super("Prompt was blocked: " + ((promptFeedback == null || (blockReason = promptFeedback.getBlockReason()) == null) ? null : blockReason.name()), th, null);
        this.response = response;
    }
}
