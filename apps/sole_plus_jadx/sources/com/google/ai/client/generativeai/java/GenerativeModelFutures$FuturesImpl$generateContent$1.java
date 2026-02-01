package com.google.ai.client.generativeai.java;

import com.google.ai.client.generativeai.GenerativeModel;
import com.google.ai.client.generativeai.java.GenerativeModelFutures;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GenerativeModelFutures.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/google/ai/client/generativeai/type/GenerateContentResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.ai.client.generativeai.java.GenerativeModelFutures$FuturesImpl$generateContent$1", f = "GenerativeModelFutures.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class GenerativeModelFutures$FuturesImpl$generateContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GenerateContentResponse>, Object> {
    final /* synthetic */ Content[] $prompt;
    int label;
    final /* synthetic */ GenerativeModelFutures.FuturesImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GenerativeModelFutures$FuturesImpl$generateContent$1(GenerativeModelFutures.FuturesImpl futuresImpl, Content[] contentArr, Continuation<? super GenerativeModelFutures$FuturesImpl$generateContent$1> continuation) {
        super(2, continuation);
        this.this$0 = futuresImpl;
        this.$prompt = contentArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GenerativeModelFutures$FuturesImpl$generateContent$1(this.this$0, this.$prompt, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GenerateContentResponse> continuation) {
        return ((GenerativeModelFutures$FuturesImpl$generateContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GenerativeModel generativeModel = this.this$0.model;
            Content[] contentArr = this.$prompt;
            this.label = 1;
            obj = generativeModel.generateContent((Content[]) Arrays.copyOf(contentArr, contentArr.length), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
