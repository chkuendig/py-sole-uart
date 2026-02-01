package com.google.ai.client.generativeai.internal.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.ai.client.generativeai.common.RequestOptions;
import com.google.ai.client.generativeai.common.client.FunctionCallingConfig;
import com.google.ai.client.generativeai.common.client.GenerationConfig;
import com.google.ai.client.generativeai.common.client.Tool;
import com.google.ai.client.generativeai.common.client.ToolConfig;
import com.google.ai.client.generativeai.common.server.BlockReason;
import com.google.ai.client.generativeai.common.server.CitationMetadata;
import com.google.ai.client.generativeai.common.server.CitationSources;
import com.google.ai.client.generativeai.common.server.FinishReason;
import com.google.ai.client.generativeai.common.server.HarmProbability;
import com.google.ai.client.generativeai.common.server.SafetyRating;
import com.google.ai.client.generativeai.common.shared.Blob;
import com.google.ai.client.generativeai.common.shared.BlobPart;
import com.google.ai.client.generativeai.common.shared.CodeExecutionResult;
import com.google.ai.client.generativeai.common.shared.Content;
import com.google.ai.client.generativeai.common.shared.ExecutableCode;
import com.google.ai.client.generativeai.common.shared.FileData;
import com.google.ai.client.generativeai.common.shared.FunctionCall;
import com.google.ai.client.generativeai.common.shared.FunctionResponse;
import com.google.ai.client.generativeai.common.shared.HarmBlockMethod;
import com.google.ai.client.generativeai.common.shared.HarmBlockThreshold;
import com.google.ai.client.generativeai.common.shared.Outcome;
import com.google.ai.client.generativeai.common.shared.SafetySetting;
import com.google.ai.client.generativeai.type.BlockThreshold;
import com.google.ai.client.generativeai.type.Candidate;
import com.google.ai.client.generativeai.type.CodeExecutionResultPart;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.ContentKt;
import com.google.ai.client.generativeai.type.CountTokensResponse;
import com.google.ai.client.generativeai.type.ExecutableCodePart;
import com.google.ai.client.generativeai.type.ExecutionOutcome;
import com.google.ai.client.generativeai.type.FileDataPart;
import com.google.ai.client.generativeai.type.FunctionCallPart;
import com.google.ai.client.generativeai.type.FunctionCallingConfig;
import com.google.ai.client.generativeai.type.FunctionDeclaration;
import com.google.ai.client.generativeai.type.FunctionResponsePart;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.ai.client.generativeai.type.HarmCategory;
import com.google.ai.client.generativeai.type.ImagePart;
import com.google.ai.client.generativeai.type.Part;
import com.google.ai.client.generativeai.type.PromptFeedback;
import com.google.ai.client.generativeai.type.Schema;
import com.google.ai.client.generativeai.type.SerializationException;
import com.google.ai.client.generativeai.type.TextPart;
import com.google.ai.client.generativeai.type.UsageMetadata;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* compiled from: conversions.kt */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0003H\u0002\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0000\u001a\f\u0010\t\u001a\u00020\f*\u00020\rH\u0000\u001a\f\u0010\t\u001a\u00020\u000e*\u00020\u000fH\u0000\u001a\f\u0010\t\u001a\u00020\u0010*\u00020\u0011H\u0000\u001a\f\u0010\t\u001a\u00020\u0012*\u00020\u0013H\u0000\u001a\f\u0010\t\u001a\u00020\u0014*\u00020\u0015H\u0000\u001a\f\u0010\t\u001a\u00020\u0016*\u00020\u0017H\u0000\u001a\f\u0010\t\u001a\u00020\u0018*\u00020\u0019H\u0000\u001a\f\u0010\t\u001a\u00020\u001a*\u00020\u001bH\u0000\u001a\u0018\u0010\t\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0\u001eH\u0000\u001a\f\u0010\t\u001a\u00020\u001f*\u00020 H\u0000\u001a\f\u0010\t\u001a\u00020!*\u00020\"H\u0000\u001a\f\u0010\t\u001a\u00020#*\u00020$H\u0000\u001a\f\u0010%\u001a\u00020&*\u00020'H\u0000\u001a\f\u0010%\u001a\u00020(*\u00020)H\u0000\u001a\f\u0010%\u001a\u00020**\u00020+H\u0000\u001a\f\u0010%\u001a\u00020,*\u00020-H\u0000\u001a\f\u0010%\u001a\u00020.*\u00020/H\u0000\u001a\f\u0010%\u001a\u000200*\u000201H\u0000\u001a\u0010\u0010%\u001a\u0004\u0018\u000102*\u0004\u0018\u000103H\u0000\u001a\f\u0010%\u001a\u000204*\u000205H\u0000\u001a\f\u0010%\u001a\u000206*\u000207H\u0000\u001a\f\u0010%\u001a\u000208*\u000209H\u0000\u001a\f\u0010%\u001a\u00020\r*\u00020\fH\u0000\u001a\f\u0010%\u001a\u00020\u0015*\u00020\u0014H\u0000\u001a\f\u0010%\u001a\u00020\u000f*\u00020\u000eH\u0000\u001a\f\u0010%\u001a\u00020\u0017*\u00020\u0016H\u0000\u001a\f\u0010%\u001a\u00020$*\u00020#H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"BASE_64_FLAGS", "", "decodeBitmapFromImage", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "input", "", "encodeBitmapToBase64Png", "", "toInternal", "Lcom/google/ai/client/generativeai/common/shared/HarmBlockThreshold;", "Lcom/google/ai/client/generativeai/type/BlockThreshold;", "Lcom/google/ai/client/generativeai/common/shared/Content;", "Lcom/google/ai/client/generativeai/type/Content;", "Lcom/google/ai/client/generativeai/common/shared/Outcome;", "Lcom/google/ai/client/generativeai/type/ExecutionOutcome;", "Lcom/google/ai/client/generativeai/common/client/FunctionDeclaration;", "Lcom/google/ai/client/generativeai/type/FunctionDeclaration;", "Lcom/google/ai/client/generativeai/common/client/GenerationConfig;", "Lcom/google/ai/client/generativeai/type/GenerationConfig;", "Lcom/google/ai/client/generativeai/common/shared/HarmCategory;", "Lcom/google/ai/client/generativeai/type/HarmCategory;", "Lcom/google/ai/client/generativeai/common/shared/Part;", "Lcom/google/ai/client/generativeai/type/Part;", "Lcom/google/ai/client/generativeai/common/RequestOptions;", "Lcom/google/ai/client/generativeai/type/RequestOptions;", "Lcom/google/ai/client/generativeai/common/shared/SafetySetting;", "Lcom/google/ai/client/generativeai/type/SafetySetting;", "Lcom/google/ai/client/generativeai/common/client/Schema;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/ai/client/generativeai/type/Schema;", "Lcom/google/ai/client/generativeai/common/client/Tool;", "Lcom/google/ai/client/generativeai/type/Tool;", "Lcom/google/ai/client/generativeai/common/client/ToolConfig;", "Lcom/google/ai/client/generativeai/type/ToolConfig;", "Lkotlinx/serialization/json/JsonObject;", "Lorg/json/JSONObject;", "toPublic", "Lcom/google/ai/client/generativeai/type/CountTokensResponse;", "Lcom/google/ai/client/generativeai/common/CountTokensResponse;", "Lcom/google/ai/client/generativeai/type/GenerateContentResponse;", "Lcom/google/ai/client/generativeai/common/GenerateContentResponse;", "Lcom/google/ai/client/generativeai/type/UsageMetadata;", "Lcom/google/ai/client/generativeai/common/UsageMetadata;", "Lcom/google/ai/client/generativeai/type/BlockReason;", "Lcom/google/ai/client/generativeai/common/server/BlockReason;", "Lcom/google/ai/client/generativeai/type/Candidate;", "Lcom/google/ai/client/generativeai/common/server/Candidate;", "Lcom/google/ai/client/generativeai/type/CitationMetadata;", "Lcom/google/ai/client/generativeai/common/server/CitationSources;", "Lcom/google/ai/client/generativeai/type/FinishReason;", "Lcom/google/ai/client/generativeai/common/server/FinishReason;", "Lcom/google/ai/client/generativeai/type/HarmProbability;", "Lcom/google/ai/client/generativeai/common/server/HarmProbability;", "Lcom/google/ai/client/generativeai/type/PromptFeedback;", "Lcom/google/ai/client/generativeai/common/server/PromptFeedback;", "Lcom/google/ai/client/generativeai/type/SafetyRating;", "Lcom/google/ai/client/generativeai/common/server/SafetyRating;", "generativeai_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConversionsKt {
    private static final int BASE_64_FLAGS = 2;

    /* compiled from: conversions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;
        public static final /* synthetic */ int[] $EnumSwitchMapping$8;

        static {
            int[] iArr = new int[HarmCategory.values().length];
            try {
                iArr[HarmCategory.HARASSMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HarmCategory.HATE_SPEECH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HarmCategory.SEXUALLY_EXPLICIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HarmCategory.DANGEROUS_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HarmCategory.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BlockThreshold.values().length];
            try {
                iArr2[BlockThreshold.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[BlockThreshold.ONLY_HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[BlockThreshold.MEDIUM_AND_ABOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[BlockThreshold.LOW_AND_ABOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[BlockThreshold.UNSPECIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ExecutionOutcome.values().length];
            try {
                iArr3[ExecutionOutcome.UNSPECIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[ExecutionOutcome.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[ExecutionOutcome.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[ExecutionOutcome.DEADLINE_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[FunctionCallingConfig.Mode.values().length];
            try {
                iArr4[FunctionCallingConfig.Mode.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr4[FunctionCallingConfig.Mode.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr4[FunctionCallingConfig.Mode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[FinishReason.values().length];
            try {
                iArr5[FinishReason.MAX_TOKENS.ordinal()] = 1;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr5[FinishReason.RECITATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr5[FinishReason.SAFETY.ordinal()] = 3;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr5[FinishReason.STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr5[FinishReason.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr5[FinishReason.UNSPECIFIED.ordinal()] = 6;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr5[FinishReason.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused24) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[com.google.ai.client.generativeai.common.shared.HarmCategory.values().length];
            try {
                iArr6[com.google.ai.client.generativeai.common.shared.HarmCategory.HARASSMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr6[com.google.ai.client.generativeai.common.shared.HarmCategory.HATE_SPEECH.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr6[com.google.ai.client.generativeai.common.shared.HarmCategory.SEXUALLY_EXPLICIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr6[com.google.ai.client.generativeai.common.shared.HarmCategory.DANGEROUS_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr6[com.google.ai.client.generativeai.common.shared.HarmCategory.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[HarmProbability.values().length];
            try {
                iArr7[HarmProbability.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr7[HarmProbability.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr7[HarmProbability.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr7[HarmProbability.NEGLIGIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr7[HarmProbability.UNSPECIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr7[HarmProbability.UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused35) {
            }
            $EnumSwitchMapping$6 = iArr7;
            int[] iArr8 = new int[BlockReason.values().length];
            try {
                iArr8[BlockReason.UNSPECIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr8[BlockReason.SAFETY.ordinal()] = 2;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr8[BlockReason.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr8[BlockReason.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused39) {
            }
            $EnumSwitchMapping$7 = iArr8;
            int[] iArr9 = new int[Outcome.values().length];
            try {
                iArr9[Outcome.UNSPECIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr9[Outcome.OUTCOME_OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr9[Outcome.OUTCOME_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr9[Outcome.OUTCOME_DEADLINE_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused43) {
            }
            $EnumSwitchMapping$8 = iArr9;
        }
    }

    public static final RequestOptions toInternal(com.google.ai.client.generativeai.type.RequestOptions requestOptions) {
        Intrinsics.checkNotNullParameter(requestOptions, "<this>");
        return new RequestOptions(requestOptions.getTimeout(), requestOptions.getApiVersion(), (String) null, 4, (DefaultConstructorMarker) null);
    }

    public static final Content toInternal(com.google.ai.client.generativeai.type.Content content) {
        Intrinsics.checkNotNullParameter(content, "<this>");
        String role = content.getRole();
        List<Part> parts = content.getParts();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parts, 10));
        Iterator<T> it = parts.iterator();
        while (it.hasNext()) {
            arrayList.add(toInternal((Part) it.next()));
        }
        return new Content(role, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final com.google.ai.client.generativeai.common.shared.Part toInternal(Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        if (part instanceof TextPart) {
            return new com.google.ai.client.generativeai.common.shared.TextPart(((TextPart) part).getText());
        }
        if (part instanceof ImagePart) {
            return new BlobPart(new Blob("image/jpeg", encodeBitmapToBase64Png(((ImagePart) part).getImage())));
        }
        int i = 2;
        if (part instanceof com.google.ai.client.generativeai.type.BlobPart) {
            com.google.ai.client.generativeai.type.BlobPart blobPart = (com.google.ai.client.generativeai.type.BlobPart) part;
            String mimeType = blobPart.getMimeType();
            String strEncodeToString = Base64.encodeToString(blobPart.getBlob(), 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(blob, BASE_64_FLAGS)");
            return new BlobPart(new Blob(mimeType, strEncodeToString));
        }
        if (part instanceof FunctionCallPart) {
            FunctionCallPart functionCallPart = (FunctionCallPart) part;
            return new com.google.ai.client.generativeai.common.shared.FunctionCallPart(new FunctionCall(functionCallPart.getName(), functionCallPart.getArgs()));
        }
        if (part instanceof FunctionResponsePart) {
            FunctionResponsePart functionResponsePart = (FunctionResponsePart) part;
            return new com.google.ai.client.generativeai.common.shared.FunctionResponsePart(new FunctionResponse(functionResponsePart.getName(), toInternal(functionResponsePart.getResponse())));
        }
        if (part instanceof FileDataPart) {
            FileDataPart fileDataPart = (FileDataPart) part;
            return new com.google.ai.client.generativeai.common.shared.FileDataPart(new FileData(fileDataPart.getMimeType(), fileDataPart.getUri()));
        }
        if (part instanceof ExecutableCodePart) {
            ExecutableCodePart executableCodePart = (ExecutableCodePart) part;
            return new com.google.ai.client.generativeai.common.shared.ExecutableCodePart(new ExecutableCode(executableCodePart.getLanguage(), executableCodePart.getCode()));
        }
        if (part instanceof CodeExecutionResultPart) {
            CodeExecutionResultPart codeExecutionResultPart = (CodeExecutionResultPart) part;
            return new com.google.ai.client.generativeai.common.shared.CodeExecutionResultPart(new CodeExecutionResult(toInternal(codeExecutionResultPart.getOutcome()), codeExecutionResultPart.getOutput()));
        }
        throw new SerializationException("The given subclass of Part (" + part.getClass().getSimpleName() + ") is not supported in the serialization yet.", null, i, 0 == true ? 1 : 0);
    }

    public static final SafetySetting toInternal(com.google.ai.client.generativeai.type.SafetySetting safetySetting) {
        Intrinsics.checkNotNullParameter(safetySetting, "<this>");
        return new SafetySetting(toInternal(safetySetting.getHarmCategory()), toInternal(safetySetting.getThreshold()), (HarmBlockMethod) null, 4, (DefaultConstructorMarker) null);
    }

    public static final GenerationConfig toInternal(com.google.ai.client.generativeai.type.GenerationConfig generationConfig) {
        Intrinsics.checkNotNullParameter(generationConfig, "<this>");
        Float temperature = generationConfig.getTemperature();
        Float topP = generationConfig.getTopP();
        Integer topK = generationConfig.getTopK();
        Integer candidateCount = generationConfig.getCandidateCount();
        Integer maxOutputTokens = generationConfig.getMaxOutputTokens();
        List<String> stopSequences = generationConfig.getStopSequences();
        String responseMimeType = generationConfig.getResponseMimeType();
        Schema<?> responseSchema = generationConfig.getResponseSchema();
        return new GenerationConfig(temperature, topP, topK, candidateCount, maxOutputTokens, stopSequences, responseMimeType, (Float) null, (Float) null, responseSchema != null ? toInternal(responseSchema) : null, 384, (DefaultConstructorMarker) null);
    }

    public static final com.google.ai.client.generativeai.common.shared.HarmCategory toInternal(HarmCategory harmCategory) {
        Intrinsics.checkNotNullParameter(harmCategory, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[harmCategory.ordinal()];
        if (i == 1) {
            return com.google.ai.client.generativeai.common.shared.HarmCategory.HARASSMENT;
        }
        if (i == 2) {
            return com.google.ai.client.generativeai.common.shared.HarmCategory.HATE_SPEECH;
        }
        if (i == 3) {
            return com.google.ai.client.generativeai.common.shared.HarmCategory.SEXUALLY_EXPLICIT;
        }
        if (i == 4) {
            return com.google.ai.client.generativeai.common.shared.HarmCategory.DANGEROUS_CONTENT;
        }
        if (i == 5) {
            return com.google.ai.client.generativeai.common.shared.HarmCategory.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final HarmBlockThreshold toInternal(BlockThreshold blockThreshold) {
        Intrinsics.checkNotNullParameter(blockThreshold, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[blockThreshold.ordinal()];
        if (i == 1) {
            return HarmBlockThreshold.BLOCK_NONE;
        }
        if (i == 2) {
            return HarmBlockThreshold.BLOCK_ONLY_HIGH;
        }
        if (i == 3) {
            return HarmBlockThreshold.BLOCK_MEDIUM_AND_ABOVE;
        }
        if (i == 4) {
            return HarmBlockThreshold.BLOCK_LOW_AND_ABOVE;
        }
        if (i == 5) {
            return HarmBlockThreshold.UNSPECIFIED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Outcome toInternal(ExecutionOutcome executionOutcome) {
        Intrinsics.checkNotNullParameter(executionOutcome, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$2[executionOutcome.ordinal()];
        if (i == 1) {
            return Outcome.UNSPECIFIED;
        }
        if (i == 2) {
            return Outcome.OUTCOME_OK;
        }
        if (i == 3) {
            return Outcome.OUTCOME_FAILED;
        }
        if (i == 4) {
            return Outcome.OUTCOME_DEADLINE_EXCEEDED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Tool toInternal(com.google.ai.client.generativeai.type.Tool tool) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(tool, "<this>");
        List<FunctionDeclaration> functionDeclarations = tool.getFunctionDeclarations();
        if (functionDeclarations != null) {
            List<FunctionDeclaration> list = functionDeclarations;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(toInternal((FunctionDeclaration) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        JSONObject codeExecution = tool.getCodeExecution();
        return new Tool(arrayList, codeExecution != null ? toInternal(codeExecution) : null);
    }

    public static final ToolConfig toInternal(com.google.ai.client.generativeai.type.ToolConfig toolConfig) {
        FunctionCallingConfig.Mode mode;
        Intrinsics.checkNotNullParameter(toolConfig, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$3[toolConfig.getFunctionCallingConfig().getMode().ordinal()];
        if (i == 1) {
            mode = FunctionCallingConfig.Mode.ANY;
        } else if (i == 2) {
            mode = FunctionCallingConfig.Mode.AUTO;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            mode = FunctionCallingConfig.Mode.NONE;
        }
        return new ToolConfig(new com.google.ai.client.generativeai.common.client.FunctionCallingConfig(mode));
    }

    public static final UsageMetadata toPublic(com.google.ai.client.generativeai.common.UsageMetadata usageMetadata) {
        Intrinsics.checkNotNullParameter(usageMetadata, "<this>");
        Integer promptTokenCount = usageMetadata.getPromptTokenCount();
        int iIntValue = promptTokenCount != null ? promptTokenCount.intValue() : 0;
        Integer candidatesTokenCount = usageMetadata.getCandidatesTokenCount();
        int iIntValue2 = candidatesTokenCount != null ? candidatesTokenCount.intValue() : 0;
        Integer totalTokenCount = usageMetadata.getTotalTokenCount();
        return new UsageMetadata(iIntValue, iIntValue2, totalTokenCount != null ? totalTokenCount.intValue() : 0);
    }

    public static final com.google.ai.client.generativeai.common.client.FunctionDeclaration toInternal(FunctionDeclaration functionDeclaration) {
        Intrinsics.checkNotNullParameter(functionDeclaration, "<this>");
        String name = functionDeclaration.getName();
        String description = functionDeclaration.getDescription();
        List<Schema<?>> parameters = functionDeclaration.getParameters();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(parameters, 10)), 16));
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            Schema schema = (Schema) it.next();
            Pair pair = TuplesKt.to(schema.getName(), toInternal(schema));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new com.google.ai.client.generativeai.common.client.FunctionDeclaration(name, description, new com.google.ai.client.generativeai.common.client.Schema("OBJECT", (String) null, (String) null, (Boolean) false, (List) null, (Map) linkedHashMap, (List) functionDeclaration.getRequiredParameters(), (com.google.ai.client.generativeai.common.client.Schema) null, 150, (DefaultConstructorMarker) null));
    }

    public static final <T> com.google.ai.client.generativeai.common.client.Schema toInternal(Schema<T> schema) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(schema, "<this>");
        String name = schema.getType().getName();
        String description = schema.getDescription();
        String format = schema.getFormat();
        Boolean nullable = schema.getNullable();
        List<String> list = schema.getEnum();
        Map<String, Schema<? extends Object>> properties = schema.getProperties();
        if (properties != null) {
            linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(properties.size()));
            Iterator<T> it = properties.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), toInternal((Schema) entry.getValue()));
            }
        } else {
            linkedHashMap = null;
        }
        List<String> required = schema.getRequired();
        Schema<? extends Object> items = schema.getItems();
        return new com.google.ai.client.generativeai.common.client.Schema(name, description, format, nullable, list, linkedHashMap, required, items != null ? toInternal(items) : null);
    }

    public static final JsonObject toInternal(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Json.Companion r0 = Json.INSTANCE;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        r0.getSerializersModule();
        return (JsonObject) r0.decodeFromString(JsonObject.INSTANCE.serializer(), string);
    }

    public static final Candidate toPublic(com.google.ai.client.generativeai.common.server.Candidate candidate) {
        ArrayList arrayListEmptyList;
        com.google.ai.client.generativeai.type.Content content;
        List<CitationSources> citationSources;
        Intrinsics.checkNotNullParameter(candidate, "<this>");
        List<SafetyRating> safetyRatings = candidate.getSafetyRatings();
        ArrayList arrayListEmptyList2 = null;
        if (safetyRatings != null) {
            List<SafetyRating> list = safetyRatings;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(toPublic((SafetyRating) it.next()));
            }
            arrayListEmptyList = arrayList;
        } else {
            arrayListEmptyList = null;
        }
        if (arrayListEmptyList == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        CitationMetadata citationMetadata = candidate.getCitationMetadata();
        if (citationMetadata != null && (citationSources = citationMetadata.getCitationSources()) != null) {
            List<CitationSources> list2 = citationSources;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(toPublic((CitationSources) it2.next()));
            }
            arrayListEmptyList2 = arrayList2;
        }
        if (arrayListEmptyList2 == null) {
            arrayListEmptyList2 = CollectionsKt.emptyList();
        }
        com.google.ai.client.generativeai.type.FinishReason finishReason = toPublic(candidate.getFinishReason());
        Content content2 = candidate.getContent();
        if (content2 == null || (content = toPublic(content2)) == null) {
            content = ContentKt.content(DeviceRequestsHelper.DEVICE_INFO_MODEL, new Function1<Content.Builder, Unit>() { // from class: com.google.ai.client.generativeai.internal.util.ConversionsKt.toPublic.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Content.Builder content3) {
                    Intrinsics.checkNotNullParameter(content3, "$this$content");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Content.Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }
            });
        }
        return new Candidate(content, arrayListEmptyList, arrayListEmptyList2, finishReason);
    }

    public static final com.google.ai.client.generativeai.type.Content toPublic(com.google.ai.client.generativeai.common.shared.Content content) {
        Intrinsics.checkNotNullParameter(content, "<this>");
        String role = content.getRole();
        List<com.google.ai.client.generativeai.common.shared.Part> parts = content.getParts();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parts, 10));
        Iterator<T> it = parts.iterator();
        while (it.hasNext()) {
            arrayList.add(toPublic((com.google.ai.client.generativeai.common.shared.Part) it.next()));
        }
        return new com.google.ai.client.generativeai.type.Content(role, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Part toPublic(com.google.ai.client.generativeai.common.shared.Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        if (part instanceof com.google.ai.client.generativeai.common.shared.TextPart) {
            return new TextPart(((com.google.ai.client.generativeai.common.shared.TextPart) part).getText());
        }
        Throwable th = null;
        Object[] objArr = 0;
        int i = 2;
        if (part instanceof BlobPart) {
            BlobPart blobPart = (BlobPart) part;
            byte[] data = Base64.decode(blobPart.getInlineData().getData(), 2);
            if (StringsKt.contains$default((CharSequence) blobPart.getInlineData().getMimeType(), (CharSequence) "image", false, 2, (Object) null)) {
                Intrinsics.checkNotNullExpressionValue(data, "data");
                Bitmap bitmapDecodeBitmapFromImage = decodeBitmapFromImage(data);
                Intrinsics.checkNotNullExpressionValue(bitmapDecodeBitmapFromImage, "decodeBitmapFromImage(data)");
                return new ImagePart(bitmapDecodeBitmapFromImage);
            }
            String mimeType = blobPart.getInlineData().getMimeType();
            Intrinsics.checkNotNullExpressionValue(data, "data");
            return new com.google.ai.client.generativeai.type.BlobPart(mimeType, data);
        }
        if (part instanceof com.google.ai.client.generativeai.common.shared.FunctionCallPart) {
            com.google.ai.client.generativeai.common.shared.FunctionCallPart functionCallPart = (com.google.ai.client.generativeai.common.shared.FunctionCallPart) part;
            return new FunctionCallPart(functionCallPart.getFunctionCall().getName(), functionCallPart.getFunctionCall().getArgs());
        }
        if (part instanceof com.google.ai.client.generativeai.common.shared.FunctionResponsePart) {
            com.google.ai.client.generativeai.common.shared.FunctionResponsePart functionResponsePart = (com.google.ai.client.generativeai.common.shared.FunctionResponsePart) part;
            return new FunctionResponsePart(functionResponsePart.getFunctionResponse().getName(), toPublic(functionResponsePart.getFunctionResponse().getResponse()));
        }
        if (part instanceof com.google.ai.client.generativeai.common.shared.FileDataPart) {
            com.google.ai.client.generativeai.common.shared.FileDataPart fileDataPart = (com.google.ai.client.generativeai.common.shared.FileDataPart) part;
            return new FileDataPart(fileDataPart.getFileData().getFileUri(), fileDataPart.getFileData().getMimeType());
        }
        if (part instanceof com.google.ai.client.generativeai.common.shared.ExecutableCodePart) {
            com.google.ai.client.generativeai.common.shared.ExecutableCodePart executableCodePart = (com.google.ai.client.generativeai.common.shared.ExecutableCodePart) part;
            return new ExecutableCodePart(executableCodePart.getExecutableCode().getLanguage(), executableCodePart.getExecutableCode().getCode());
        }
        if (part instanceof com.google.ai.client.generativeai.common.shared.CodeExecutionResultPart) {
            com.google.ai.client.generativeai.common.shared.CodeExecutionResultPart codeExecutionResultPart = (com.google.ai.client.generativeai.common.shared.CodeExecutionResultPart) part;
            return new CodeExecutionResultPart(toPublic(codeExecutionResultPart.getCodeExecutionResult().getOutcome()), codeExecutionResultPart.getCodeExecutionResult().getOutput());
        }
        throw new SerializationException("Unsupported part type \"" + part.getClass().getSimpleName() + "\" provided. This model may not be supported by this SDK.", th, i, objArr == true ? 1 : 0);
    }

    public static final com.google.ai.client.generativeai.type.CitationMetadata toPublic(CitationSources citationSources) {
        Intrinsics.checkNotNullParameter(citationSources, "<this>");
        return new com.google.ai.client.generativeai.type.CitationMetadata(citationSources.getStartIndex(), citationSources.getEndIndex(), citationSources.getUri(), citationSources.getLicense());
    }

    public static final com.google.ai.client.generativeai.type.SafetyRating toPublic(SafetyRating safetyRating) {
        Intrinsics.checkNotNullParameter(safetyRating, "<this>");
        return new com.google.ai.client.generativeai.type.SafetyRating(toPublic(safetyRating.getCategory()), toPublic(safetyRating.getProbability()));
    }

    public static final PromptFeedback toPublic(com.google.ai.client.generativeai.common.server.PromptFeedback promptFeedback) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(promptFeedback, "<this>");
        List<SafetyRating> safetyRatings = promptFeedback.getSafetyRatings();
        if (safetyRatings != null) {
            List<SafetyRating> list = safetyRatings;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(toPublic((SafetyRating) it.next()));
            }
            arrayListEmptyList = arrayList;
        } else {
            arrayListEmptyList = null;
        }
        if (arrayListEmptyList == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        BlockReason blockReason = promptFeedback.getBlockReason();
        return new PromptFeedback(blockReason != null ? toPublic(blockReason) : null, arrayListEmptyList);
    }

    public static final com.google.ai.client.generativeai.type.FinishReason toPublic(FinishReason finishReason) {
        switch (finishReason == null ? -1 : WhenMappings.$EnumSwitchMapping$4[finishReason.ordinal()]) {
            case -1:
                return null;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return com.google.ai.client.generativeai.type.FinishReason.MAX_TOKENS;
            case 2:
                return com.google.ai.client.generativeai.type.FinishReason.RECITATION;
            case 3:
                return com.google.ai.client.generativeai.type.FinishReason.SAFETY;
            case 4:
                return com.google.ai.client.generativeai.type.FinishReason.STOP;
            case 5:
                return com.google.ai.client.generativeai.type.FinishReason.OTHER;
            case 6:
                return com.google.ai.client.generativeai.type.FinishReason.UNSPECIFIED;
            case 7:
                return com.google.ai.client.generativeai.type.FinishReason.UNKNOWN;
        }
    }

    public static final HarmCategory toPublic(com.google.ai.client.generativeai.common.shared.HarmCategory harmCategory) {
        Intrinsics.checkNotNullParameter(harmCategory, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$5[harmCategory.ordinal()];
        if (i == 1) {
            return HarmCategory.HARASSMENT;
        }
        if (i == 2) {
            return HarmCategory.HATE_SPEECH;
        }
        if (i == 3) {
            return HarmCategory.SEXUALLY_EXPLICIT;
        }
        if (i == 4) {
            return HarmCategory.DANGEROUS_CONTENT;
        }
        if (i == 5) {
            return HarmCategory.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final com.google.ai.client.generativeai.type.HarmProbability toPublic(HarmProbability harmProbability) {
        Intrinsics.checkNotNullParameter(harmProbability, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$6[harmProbability.ordinal()]) {
            case 1:
                return com.google.ai.client.generativeai.type.HarmProbability.HIGH;
            case 2:
                return com.google.ai.client.generativeai.type.HarmProbability.MEDIUM;
            case 3:
                return com.google.ai.client.generativeai.type.HarmProbability.LOW;
            case 4:
                return com.google.ai.client.generativeai.type.HarmProbability.NEGLIGIBLE;
            case 5:
                return com.google.ai.client.generativeai.type.HarmProbability.UNSPECIFIED;
            case 6:
                return com.google.ai.client.generativeai.type.HarmProbability.UNKNOWN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final com.google.ai.client.generativeai.type.BlockReason toPublic(BlockReason blockReason) {
        Intrinsics.checkNotNullParameter(blockReason, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$7[blockReason.ordinal()];
        if (i == 1) {
            return com.google.ai.client.generativeai.type.BlockReason.UNSPECIFIED;
        }
        if (i == 2) {
            return com.google.ai.client.generativeai.type.BlockReason.SAFETY;
        }
        if (i == 3) {
            return com.google.ai.client.generativeai.type.BlockReason.OTHER;
        }
        if (i == 4) {
            return com.google.ai.client.generativeai.type.BlockReason.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ExecutionOutcome toPublic(Outcome outcome) {
        Intrinsics.checkNotNullParameter(outcome, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$8[outcome.ordinal()];
        if (i == 1) {
            return ExecutionOutcome.UNSPECIFIED;
        }
        if (i == 2) {
            return ExecutionOutcome.OK;
        }
        if (i == 3) {
            return ExecutionOutcome.FAILED;
        }
        if (i == 4) {
            return ExecutionOutcome.DEADLINE_EXCEEDED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final GenerateContentResponse toPublic(com.google.ai.client.generativeai.common.GenerateContentResponse generateContentResponse) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(generateContentResponse, "<this>");
        List<com.google.ai.client.generativeai.common.server.Candidate> candidates = generateContentResponse.getCandidates();
        if (candidates != null) {
            List<com.google.ai.client.generativeai.common.server.Candidate> list = candidates;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(toPublic((com.google.ai.client.generativeai.common.server.Candidate) it.next()));
            }
            arrayListEmptyList = arrayList;
        } else {
            arrayListEmptyList = null;
        }
        if (arrayListEmptyList == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        com.google.ai.client.generativeai.common.server.PromptFeedback promptFeedback = generateContentResponse.getPromptFeedback();
        PromptFeedback promptFeedback2 = promptFeedback != null ? toPublic(promptFeedback) : null;
        com.google.ai.client.generativeai.common.UsageMetadata usageMetadata = generateContentResponse.getUsageMetadata();
        return new GenerateContentResponse(arrayListEmptyList, promptFeedback2, usageMetadata != null ? toPublic(usageMetadata) : null);
    }

    public static final CountTokensResponse toPublic(com.google.ai.client.generativeai.common.CountTokensResponse countTokensResponse) {
        Intrinsics.checkNotNullParameter(countTokensResponse, "<this>");
        return new CountTokensResponse(countTokensResponse.getTotalTokens());
    }

    public static final JSONObject toPublic(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        return new JSONObject(jsonObject.toString());
    }

    private static final String encodeBitmapToBase64Png(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(it.toByteArray(), BASE_64_FLAGS)");
        return strEncodeToString;
    }

    private static final Bitmap decodeBitmapFromImage(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }
}
