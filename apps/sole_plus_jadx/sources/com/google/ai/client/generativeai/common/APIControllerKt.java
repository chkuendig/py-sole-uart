package com.google.ai.client.generativeai.common;

import com.google.ai.client.generativeai.common.server.Candidate;
import com.google.ai.client.generativeai.common.server.FinishReason;
import com.google.ai.client.generativeai.common.server.PromptFeedback;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: APIController.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\f\u0010\t\u001a\u00020\n*\u00020\nH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"JSON", "Lkotlinx/serialization/json/Json;", "getJSON", "()Lkotlinx/serialization/json/Json;", "validateResponse", "", "response", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validate", "Lcom/google/ai/client/generativeai/common/GenerateContentResponse;", "common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class APIControllerKt {
    private static final Json JSON = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.google.ai.client.generativeai.common.APIControllerKt$JSON$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
            Json.setPrettyPrint(false);
            Json.setLenient(true);
        }
    }, 1, null);

    /* compiled from: APIController.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIControllerKt", f = "APIController.kt", i = {}, l = {WinError.ERROR_FILE_CHECKED_OUT}, m = "validateResponse", n = {}, s = {})
    /* renamed from: com.google.ai.client.generativeai.common.APIControllerKt$validateResponse$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return APIControllerKt.validateResponse(null, this);
        }
    }

    public static final Json getJSON() {
        return JSON;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object validateResponse(io.ktor.client.statement.HttpResponse r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ai.client.generativeai.common.APIControllerKt.validateResponse(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GenerateContentResponse validate(GenerateContentResponse generateContentResponse) {
        Object next;
        List<Candidate> candidates = generateContentResponse.getCandidates();
        if ((candidates == null || candidates.isEmpty()) && generateContentResponse.getPromptFeedback() == null) {
            throw new SerializationException("Error deserializing response, found no valid fields", null, 2, null);
        }
        PromptFeedback promptFeedback = generateContentResponse.getPromptFeedback();
        if (promptFeedback != null && promptFeedback.getBlockReason() != null) {
            throw new PromptBlockedException(generateContentResponse, null, 2, null);
        }
        List<Candidate> candidates2 = generateContentResponse.getCandidates();
        if (candidates2 != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = candidates2.iterator();
            while (it.hasNext()) {
                FinishReason finishReason = ((Candidate) it.next()).getFinishReason();
                if (finishReason != null) {
                    arrayList.add(finishReason);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (((FinishReason) next) != FinishReason.STOP) {
                    break;
                }
            }
            if (((FinishReason) next) != null) {
                throw new ResponseStoppedException(generateContentResponse, null, 2, null);
            }
        }
        return generateContentResponse;
    }
}
