package com.soletreadmills.sole_v2._network.Interceptor;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Interceptor;

/* compiled from: JwtTokenAutoRefreshInterceptor.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_network/Interceptor/JwtTokenAutoRefreshInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shortToken", "", "t", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JwtTokenAutoRefreshInterceptor implements Interceptor {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private static final AtomicLong CALL_SEQ = new AtomicLong(1);

    /* compiled from: JwtTokenAutoRefreshInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_network/Interceptor/JwtTokenAutoRefreshInterceptor$Companion;", "", "()V", "CALL_SEQ", "Ljava/util/concurrent/atomic/AtomicLong;", "getCALL_SEQ", "()Ljava/util/concurrent/atomic/AtomicLong;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AtomicLong getCALL_SEQ() {
            return JwtTokenAutoRefreshInterceptor.CALL_SEQ;
        }
    }

    private final String shortToken(String t) {
        String str = t;
        if (str == null || str.length() == 0) {
            return AbstractJsonLexerKt.NULL;
        }
        return t.length() <= 10 ? t : StringsKt.take(t, 6) + Typography.ellipsis + StringsKt.takeLast(t, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0427  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1155
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._network.Interceptor.JwtTokenAutoRefreshInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
