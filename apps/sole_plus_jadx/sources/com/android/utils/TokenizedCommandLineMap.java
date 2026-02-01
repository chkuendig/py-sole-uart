package com.android.utils;

import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TokenizedCommandLineMap.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00128\b\u0002\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\u0002\u0010\u0010J/\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020\u0006R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/android/utils/TokenizedCommandLineMap;", ExifInterface.GPS_DIRECTION_TRUE, "", SdkConstants.FD_RES_RAW, "", "platform", "", "normalize", "Lkotlin/Function2;", "Lcom/android/utils/TokenizedCommandLine;", "Lkotlin/ParameterName;", "name", "tokens", "", "sourceFile", "", "(ZILkotlin/jvm/functions/Function2;)V", "hashCodeMap", "", "hashFunction", "Lkotlin/Function1;", "getHashFunction", "()Lkotlin/jvm/functions/Function1;", "setHashFunction", "(Lkotlin/jvm/functions/Function1;)V", "indexes", "", "map", "getNormalize", "()Lkotlin/jvm/functions/Function2;", "getPlatform", "()I", "getRaw", "()Z", "computeIfAbsent", "commandLine", "compute", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", ContentDisposition.Parameters.Size, "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TokenizedCommandLineMap<T> {
    private final Map<String, Integer> hashCodeMap;
    private Function1<? super TokenizedCommandLine, Integer> hashFunction;
    private int[] indexes;
    private final Map<Integer, Map<String, T>> map;
    private final Function2<TokenizedCommandLine, String, Unit> normalize;
    private final int platform;
    private final boolean raw;

    /* JADX WARN: Multi-variable type inference failed */
    public TokenizedCommandLineMap(boolean z, int i, Function2<? super TokenizedCommandLine, ? super String, Unit> normalize) {
        Intrinsics.checkNotNullParameter(normalize, "normalize");
        this.raw = z;
        this.platform = i;
        this.normalize = normalize;
        this.indexes = new int[0];
        this.hashFunction = new Function1<TokenizedCommandLine, Integer>() { // from class: com.android.utils.TokenizedCommandLineMap$hashFunction$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(TokenizedCommandLine tokens) {
                Intrinsics.checkNotNullParameter(tokens, "tokens");
                return Integer.valueOf(tokens.computeNormalizedCommandLineHashCode());
            }
        };
        this.map = new LinkedHashMap();
        this.hashCodeMap = new LinkedHashMap();
    }

    public final boolean getRaw() {
        return this.raw;
    }

    public /* synthetic */ TokenizedCommandLineMap(boolean z, int i, AnonymousClass1 anonymousClass1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i2 & 2) != 0 ? SdkConstants.currentPlatform() : i, (i2 & 4) != 0 ? new Function2<TokenizedCommandLine, String, Unit>() { // from class: com.android.utils.TokenizedCommandLineMap.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TokenizedCommandLine noName_0, String noName_1) {
                Intrinsics.checkNotNullParameter(noName_0, "$noName_0");
                Intrinsics.checkNotNullParameter(noName_1, "$noName_1");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(TokenizedCommandLine tokenizedCommandLine, String str) {
                invoke2(tokenizedCommandLine, str);
                return Unit.INSTANCE;
            }
        } : anonymousClass1);
    }

    public final int getPlatform() {
        return this.platform;
    }

    public final Function2<TokenizedCommandLine, String, Unit> getNormalize() {
        return this.normalize;
    }

    public final Function1<TokenizedCommandLine, Integer> getHashFunction() {
        return this.hashFunction;
    }

    public final void setHashFunction(Function1<? super TokenizedCommandLine, Integer> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.hashFunction = function1;
    }

    public final T computeIfAbsent(String commandLine, String sourceFile, Function1<? super TokenizedCommandLine, ? extends T> compute) throws Exception {
        Intrinsics.checkNotNullParameter(commandLine, "commandLine");
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        Intrinsics.checkNotNullParameter(compute, "compute");
        if (this.indexes.length <= TokenizedCommandLineKt.minimumSizeOfTokenizeCommandLineBuffer(commandLine)) {
            this.indexes = TokenizedCommandLineKt.allocateTokenizeCommandLineBuffer(commandLine);
        }
        TokenizedCommandLine tokenizedCommandLine = new TokenizedCommandLine(commandLine, this.raw, this.platform, this.indexes);
        this.normalize.invoke(tokenizedCommandLine, sourceFile);
        int iIntValue = this.hashFunction.invoke(tokenizedCommandLine).intValue();
        Map<String, T> mapComputeIfAbsent = this.map.computeIfAbsent(Integer.valueOf(iIntValue), new Function() { // from class: com.android.utils.TokenizedCommandLineMap$computeIfAbsent$submap$1
            @Override // java.util.function.Function
            public final Map<String, T> apply(Integer it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new LinkedHashMap();
            }
        });
        Intrinsics.checkNotNullExpressionValue(mapComputeIfAbsent, "map.computeIfAbsent(hashCode) { mutableMapOf() }");
        Map<String, T> map = mapComputeIfAbsent;
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            T value = entry.getValue();
            if (tokenizedCommandLine.normalizedCommandLineEquals(key)) {
                return value;
            }
        }
        String string = tokenizedCommandLine.toString();
        map.containsKey(string);
        T tInvoke = compute.invoke(tokenizedCommandLine);
        map.put(string, tInvoke);
        this.hashCodeMap.put(string, Integer.valueOf(iIntValue));
        return tInvoke;
    }

    public final int size() {
        Map<Integer, Map<String, T>> map = this.map;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<Integer, Map<String, T>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().getValue().size()));
        }
        return CollectionsKt.sumOfInt(arrayList);
    }
}
