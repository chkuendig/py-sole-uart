package com.google.ai.client.generativeai.type;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: GenerateContentResponse.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001c\u0010%\u001a\u0004\u0018\u0001H&\"\n\b\u0000\u0010&\u0018\u0001*\u00020'H\u0082\b¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001fH\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR#\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010!R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006,"}, d2 = {"Lcom/google/ai/client/generativeai/type/GenerateContentResponse;", "", "candidates", "", "Lcom/google/ai/client/generativeai/type/Candidate;", "promptFeedback", "Lcom/google/ai/client/generativeai/type/PromptFeedback;", "usageMetadata", "Lcom/google/ai/client/generativeai/type/UsageMetadata;", "(Ljava/util/List;Lcom/google/ai/client/generativeai/type/PromptFeedback;Lcom/google/ai/client/generativeai/type/UsageMetadata;)V", "getCandidates", "()Ljava/util/List;", "functionCall", "Lcom/google/ai/client/generativeai/type/FunctionCallPart;", "getFunctionCall$annotations", "()V", "getFunctionCall", "()Lcom/google/ai/client/generativeai/type/FunctionCallPart;", "functionCall$delegate", "Lkotlin/Lazy;", "functionCalls", "getFunctionCalls", "functionCalls$delegate", "functionResponse", "Lcom/google/ai/client/generativeai/type/FunctionResponsePart;", "getFunctionResponse", "()Lcom/google/ai/client/generativeai/type/FunctionResponsePart;", "functionResponse$delegate", "getPromptFeedback", "()Lcom/google/ai/client/generativeai/type/PromptFeedback;", "text", "", "getText", "()Ljava/lang/String;", "text$delegate", "getUsageMetadata", "()Lcom/google/ai/client/generativeai/type/UsageMetadata;", "firstPartAs", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/ai/client/generativeai/type/Part;", "()Lcom/google/ai/client/generativeai/type/Part;", "warn", "", "message", "generativeai_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GenerateContentResponse {
    private final List<Candidate> candidates;

    /* renamed from: functionCall$delegate, reason: from kotlin metadata */
    private final Lazy functionCall;

    /* renamed from: functionCalls$delegate, reason: from kotlin metadata */
    private final Lazy functionCalls;

    /* renamed from: functionResponse$delegate, reason: from kotlin metadata */
    private final Lazy functionResponse;
    private final PromptFeedback promptFeedback;

    /* renamed from: text$delegate, reason: from kotlin metadata */
    private final Lazy text;
    private final UsageMetadata usageMetadata;

    @Deprecated(message = "Use functionCalls instead", replaceWith = @ReplaceWith(expression = "functionCalls", imports = {}))
    public static /* synthetic */ void getFunctionCall$annotations() {
    }

    public GenerateContentResponse(List<Candidate> candidates, PromptFeedback promptFeedback, UsageMetadata usageMetadata) {
        Intrinsics.checkNotNullParameter(candidates, "candidates");
        this.candidates = candidates;
        this.promptFeedback = promptFeedback;
        this.usageMetadata = usageMetadata;
        this.text = LazyKt.lazy(new Function0<String>() { // from class: com.google.ai.client.generativeai.type.GenerateContentResponse$text$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                List<Part> parts = ((Candidate) CollectionsKt.first((List) this.this$0.getCandidates())).getContent().getParts();
                ArrayList arrayList = new ArrayList();
                for (Object obj : parts) {
                    Part part = (Part) obj;
                    if ((part instanceof TextPart) || (part instanceof ExecutableCodePart) || (part instanceof CodeExecutionResultPart)) {
                        arrayList.add(obj);
                    }
                }
                return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, new Function1<Part, CharSequence>() { // from class: com.google.ai.client.generativeai.type.GenerateContentResponse$text$2.2
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(Part it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (it instanceof TextPart) {
                            return ((TextPart) it).getText();
                        }
                        if (!(it instanceof ExecutableCodePart)) {
                            if (!(it instanceof CodeExecutionResultPart)) {
                                throw new RuntimeException("unreachable");
                            }
                            return "\n```\n" + ((CodeExecutionResultPart) it).getOutput() + "\n```";
                        }
                        ExecutableCodePart executableCodePart = (ExecutableCodePart) it;
                        String lowerCase = executableCodePart.getLanguage().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                        return "\n```" + lowerCase + "\n" + executableCodePart.getCode() + "\n```";
                    }
                }, 30, null);
            }
        });
        this.functionCall = LazyKt.lazy(new Function0<FunctionCallPart>() { // from class: com.google.ai.client.generativeai.type.GenerateContentResponse$functionCall$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FunctionCallPart invoke() {
                GenerateContentResponse generateContentResponse = this.this$0;
                FunctionCallPart functionCallPart = null;
                if (generateContentResponse.getCandidates().isEmpty()) {
                    generateContentResponse.warn("No candidates were found, but was asked to get a candidate.");
                } else {
                    List<Part> parts = ((Candidate) CollectionsKt.first((List) generateContentResponse.getCandidates())).getContent().getParts();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : parts) {
                        if (((Part) obj) instanceof FunctionCallPart) {
                            arrayList.add(obj);
                        } else {
                            arrayList2.add(obj);
                        }
                    }
                    Pair pair = new Pair(arrayList, arrayList2);
                    List list = (List) pair.component1();
                    List list2 = (List) pair.component2();
                    String simpleName = Reflection.getOrCreateKotlinClass(FunctionCallPart.class).getSimpleName();
                    if (simpleName == null) {
                        simpleName = "of the part type you asked for";
                    }
                    if (list.isEmpty()) {
                        if (!list2.isEmpty()) {
                            generateContentResponse.warn("We didn't find any " + simpleName + ", but we did find other part types. Did you ask for the right type?");
                        }
                    } else {
                        if (list.size() > 1) {
                            generateContentResponse.warn("Multiple " + simpleName + " were found, returning the first one.");
                        } else if (!list2.isEmpty()) {
                            generateContentResponse.warn("Returning the only " + simpleName + " found, but other part types were present as well.");
                        }
                        Object objFirst = CollectionsKt.first((List<? extends Object>) list);
                        if (objFirst == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.google.ai.client.generativeai.type.FunctionCallPart");
                        }
                        functionCallPart = (FunctionCallPart) objFirst;
                    }
                }
                return functionCallPart;
            }
        });
        this.functionCalls = LazyKt.lazy(new Function0<List<? extends FunctionCallPart>>() { // from class: com.google.ai.client.generativeai.type.GenerateContentResponse$functionCalls$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends FunctionCallPart> invoke() {
                List<Part> parts = ((Candidate) CollectionsKt.first((List) this.this$0.getCandidates())).getContent().getParts();
                ArrayList arrayList = new ArrayList();
                for (Object obj : parts) {
                    if (obj instanceof FunctionCallPart) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        });
        this.functionResponse = LazyKt.lazy(new Function0<FunctionResponsePart>() { // from class: com.google.ai.client.generativeai.type.GenerateContentResponse$functionResponse$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FunctionResponsePart invoke() {
                GenerateContentResponse generateContentResponse = this.this$0;
                FunctionResponsePart functionResponsePart = null;
                if (generateContentResponse.getCandidates().isEmpty()) {
                    generateContentResponse.warn("No candidates were found, but was asked to get a candidate.");
                } else {
                    List<Part> parts = ((Candidate) CollectionsKt.first((List) generateContentResponse.getCandidates())).getContent().getParts();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : parts) {
                        if (((Part) obj) instanceof FunctionResponsePart) {
                            arrayList.add(obj);
                        } else {
                            arrayList2.add(obj);
                        }
                    }
                    Pair pair = new Pair(arrayList, arrayList2);
                    List list = (List) pair.component1();
                    List list2 = (List) pair.component2();
                    String simpleName = Reflection.getOrCreateKotlinClass(FunctionResponsePart.class).getSimpleName();
                    if (simpleName == null) {
                        simpleName = "of the part type you asked for";
                    }
                    if (list.isEmpty()) {
                        if (!list2.isEmpty()) {
                            generateContentResponse.warn("We didn't find any " + simpleName + ", but we did find other part types. Did you ask for the right type?");
                        }
                    } else {
                        if (list.size() > 1) {
                            generateContentResponse.warn("Multiple " + simpleName + " were found, returning the first one.");
                        } else if (!list2.isEmpty()) {
                            generateContentResponse.warn("Returning the only " + simpleName + " found, but other part types were present as well.");
                        }
                        Object objFirst = CollectionsKt.first((List<? extends Object>) list);
                        if (objFirst == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.google.ai.client.generativeai.type.FunctionResponsePart");
                        }
                        functionResponsePart = (FunctionResponsePart) objFirst;
                    }
                }
                return functionResponsePart;
            }
        });
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

    public final String getText() {
        return (String) this.text.getValue();
    }

    public final FunctionCallPart getFunctionCall() {
        return (FunctionCallPart) this.functionCall.getValue();
    }

    public final List<FunctionCallPart> getFunctionCalls() {
        return (List) this.functionCalls.getValue();
    }

    public final FunctionResponsePart getFunctionResponse() {
        return (FunctionResponsePart) this.functionResponse.getValue();
    }

    private final /* synthetic */ <T extends Part> T firstPartAs() {
        if (getCandidates().isEmpty()) {
            warn("No candidates were found, but was asked to get a candidate.");
            return null;
        }
        List<Part> parts = ((Candidate) CollectionsKt.first((List) getCandidates())).getContent().getParts();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : parts) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (((Part) obj) instanceof Part) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.component1();
        List list2 = (List) pair.component2();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String simpleName = Reflection.getOrCreateKotlinClass(Part.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "of the part type you asked for";
        }
        if (list.isEmpty()) {
            if (!list2.isEmpty()) {
                warn("We didn't find any " + simpleName + ", but we did find other part types. Did you ask for the right type?");
            }
            return null;
        }
        if (list.size() > 1) {
            warn("Multiple " + simpleName + " were found, returning the first one.");
        } else if (!list2.isEmpty()) {
            warn("Returning the only " + simpleName + " found, but other part types were present as well.");
        }
        Object objFirst = CollectionsKt.first((List<? extends Object>) list);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) objFirst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void warn(String message) {
        Log.w("GenerateContentResponse", message);
    }
}
