package com.soletreadmills.sole_v2._manager;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/LogManager;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LogManager {
    public static final int $stable = 0;
    public static final String BRAND = "sole";
    private static final DateTimeFormatter LOG_TIME_FORMATTER;
    private static final ZoneId TW_ZONE;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String isDevText = "Prod";

    /* compiled from: LogManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/LogManager$Companion;", "", "()V", "BRAND", "", "LOG_TIME_FORMATTER", "Ljava/time/format/DateTimeFormatter;", "TW_ZONE", "Ljava/time/ZoneId;", "isDevText", "()Ljava/lang/String;", "generateUuid", "uploadLog", "", "logUuid", "apiMethod", "error", "bleInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String isDevText() {
            return LogManager.isDevText;
        }

        public final String generateUuid() {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object uploadLog(java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
            /*
                Method dump skipped, instructions count: 559
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.LogManager.Companion.uploadLog(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    static {
        ZoneId zoneIdOf = ZoneId.of("Asia/Taipei");
        Intrinsics.checkNotNullExpressionValue(zoneIdOf, "of(...)");
        TW_ZONE = zoneIdOf;
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS XXX", Locale.US);
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatterOfPattern, "ofPattern(...)");
        LOG_TIME_FORMATTER = dateTimeFormatterOfPattern;
    }
}
