package com.google.ai.client.generativeai.common;

import com.google.ai.client.generativeai.common.server.Candidate;
import com.google.ai.client.generativeai.common.server.FinishReason;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/ai/client/generativeai/common/ResponseStoppedException;", "Lcom/google/ai/client/generativeai/common/GoogleGenerativeAIException;", "response", "Lcom/google/ai/client/generativeai/common/GenerateContentResponse;", "cause", "", "(Lcom/google/ai/client/generativeai/common/GenerateContentResponse;Ljava/lang/Throwable;)V", "getResponse", "()Lcom/google/ai/client/generativeai/common/GenerateContentResponse;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResponseStoppedException extends GoogleGenerativeAIException {
    private final GenerateContentResponse response;

    public /* synthetic */ ResponseStoppedException(GenerateContentResponse generateContentResponse, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(generateContentResponse, (i & 2) != 0 ? null : th);
    }

    public final GenerateContentResponse getResponse() {
        return this.response;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ResponseStoppedException(GenerateContentResponse response, Throwable th) {
        Candidate candidate;
        FinishReason finishReason;
        Intrinsics.checkNotNullParameter(response, "response");
        List<Candidate> candidates = response.getCandidates();
        super("Content generation stopped. Reason: " + ((candidates == null || (candidate = (Candidate) CollectionsKt.first((List) candidates)) == null || (finishReason = candidate.getFinishReason()) == null) ? null : finishReason.name()), th, null);
        this.response = response;
    }
}
