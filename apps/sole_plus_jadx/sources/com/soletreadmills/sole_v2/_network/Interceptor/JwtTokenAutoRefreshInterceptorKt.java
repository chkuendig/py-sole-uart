package com.soletreadmills.sole_v2._network.Interceptor;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* compiled from: JwtTokenAutoRefreshInterceptor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¨\u0006\u0003"}, d2 = {"extractJwtCode", "", "bodyString", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JwtTokenAutoRefreshInterceptorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractJwtCode(String str) {
        Object objM9087constructorimpl;
        String strOptString;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sys_response_message");
            if (jSONObjectOptJSONObject == null || (strOptString = jSONObjectOptJSONObject.optString("code")) == null || StringsKt.isBlank(strOptString) || Intrinsics.areEqual(strOptString, AbstractJsonLexerKt.NULL)) {
                strOptString = null;
            }
            if (strOptString == null) {
                strOptString = jSONObject.optString("code");
                Intrinsics.checkNotNull(strOptString);
                if (StringsKt.isBlank(strOptString) || Intrinsics.areEqual(strOptString, AbstractJsonLexerKt.NULL)) {
                    strOptString = null;
                }
            }
            objM9087constructorimpl = Result.m9087constructorimpl(strOptString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m9093isFailureimpl(objM9087constructorimpl) ? null : objM9087constructorimpl);
    }
}
