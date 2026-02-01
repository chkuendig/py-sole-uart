package com.soletreadmills.sole_v2._tools;

import com.blankj.utilcode.constant.TimeConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: SrtParser.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/SrtParser;", "", "()V", "subtitles", "", "Lcom/soletreadmills/sole_v2/_tools/Subtitle;", "loadSubtitles", "", "urlStr", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseSRT", "content", "timeFromSRTTimestamp", "", SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP, "updateSubtitle", "currentTimeMs", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SrtParser {
    private List<Subtitle> subtitles = CollectionsKt.emptyList();

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final SrtParser shared = new SrtParser();

    /* compiled from: SrtParser.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/SrtParser$Companion;", "", "()V", "shared", "Lcom/soletreadmills/sole_v2/_tools/SrtParser;", "getShared", "()Lcom/soletreadmills/sole_v2/_tools/SrtParser;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SrtParser getShared() {
            return SrtParser.shared;
        }
    }

    /* compiled from: SrtParser.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._tools.SrtParser$loadSubtitles$2", f = "SrtParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._tools.SrtParser$loadSubtitles$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $urlStr;
        int label;
        final /* synthetic */ SrtParser this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, SrtParser srtParser, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$urlStr = str;
            this.this$0 = srtParser;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$urlStr, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                URL url = new URL(this.$urlStr);
                String str = new String(TextStreamsKt.readBytes(url), Charsets.UTF_8);
                SrtParser srtParser = this.this$0;
                srtParser.subtitles = srtParser.parseSRT(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
    }

    public final Object loadSubtitles(String str, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Subtitle> parseSRT(String content) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("(\\d+)\\s+([\\d:,]+) --> ([\\d:,]+)\\s+([\\s\\S]*?)(?=\\n\\n|$)", 8).matcher(content);
        while (matcher.find()) {
            if (matcher.groupCount() >= 4) {
                String strGroup = matcher.group(2);
                String strGroup2 = matcher.group(3);
                String strGroup3 = matcher.group(4);
                Intrinsics.checkNotNullExpressionValue(strGroup3, "group(...)");
                String string = StringsKt.trim((CharSequence) StringsKt.replace$default(strGroup3, "\n", " ", false, 4, (Object) null)).toString();
                Intrinsics.checkNotNull(strGroup);
                long jTimeFromSRTTimestamp = timeFromSRTTimestamp(strGroup);
                Intrinsics.checkNotNull(strGroup2);
                arrayList.add(new Subtitle(jTimeFromSRTTimestamp, timeFromSRTTimestamp(strGroup2), string));
            }
        }
        return arrayList;
    }

    private final long timeFromSRTTimestamp(String timestamp) {
        Long longOrNull;
        Long longOrNull2;
        List listSplit$default = StringsKt.split$default((CharSequence) timestamp, new String[]{":"}, false, 0, 6, (Object) null);
        long jLongValue = 0;
        if (listSplit$default.size() != 3) {
            return 0L;
        }
        Long longOrNull3 = StringsKt.toLongOrNull((String) listSplit$default.get(0));
        long jLongValue2 = longOrNull3 != null ? longOrNull3.longValue() : 0L;
        Long longOrNull4 = StringsKt.toLongOrNull((String) listSplit$default.get(1));
        long jLongValue3 = longOrNull4 != null ? longOrNull4.longValue() : 0L;
        List listSplit$default2 = StringsKt.split$default((CharSequence) listSplit$default.get(2), new String[]{","}, false, 0, 6, (Object) null);
        String str = (String) CollectionsKt.getOrNull(listSplit$default2, 0);
        long jLongValue4 = (str == null || (longOrNull2 = StringsKt.toLongOrNull(str)) == null) ? 0L : longOrNull2.longValue();
        String str2 = (String) CollectionsKt.getOrNull(listSplit$default2, 1);
        if (str2 != null && (longOrNull = StringsKt.toLongOrNull(str2)) != null) {
            jLongValue = longOrNull.longValue();
        }
        return (jLongValue2 * TimeConstants.HOUR) + (jLongValue3 * TimeConstants.MIN) + (jLongValue4 * 1000) + jLongValue;
    }

    public final String updateSubtitle(long currentTimeMs) {
        Object next;
        String text;
        Iterator<T> it = this.subtitles.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Subtitle subtitle = (Subtitle) next;
            long startTime = subtitle.getStartTime();
            if (currentTimeMs <= subtitle.getEndTime() && startTime <= currentTimeMs) {
                break;
            }
        }
        Subtitle subtitle2 = (Subtitle) next;
        return (subtitle2 == null || (text = subtitle2.getText()) == null) ? "" : text;
    }
}
