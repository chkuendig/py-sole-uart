package com.soletreadmills.sole_v2._data._base;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: JwtNotificationApiBaseData.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0017\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/_base/JwtNotificationApiBaseData;", "", "()V", "code", "", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class JwtNotificationApiBaseData {
    public static final String CODE_SUCCESS = "200";

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private String message;
    public static final int $stable = 8;

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
