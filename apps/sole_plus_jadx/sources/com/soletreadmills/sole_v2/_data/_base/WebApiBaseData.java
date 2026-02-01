package com.soletreadmills.sole_v2._data._base;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: WebApiBaseData.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0017\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "", "()V", "errorCode", "", "getErrorCode", "()Ljava/lang/String;", "setErrorCode", "(Ljava/lang/String;)V", "errorMessage", "getErrorMessage", "setErrorMessage", "errorUuid", "getErrorUuid", "setErrorUuid", "msg", "getMsg", "setMsg", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class WebApiBaseData {
    public static final String CODE_SUCCESS = "200";

    @SerializedName("errorCode")
    private String errorCode;

    @SerializedName("errorMessage")
    private String errorMessage;

    @SerializedName("errorUuid")
    private String errorUuid;

    @SerializedName("msg")
    private String msg;

    @SerializedName("success")
    private boolean success;
    public static final int $stable = 8;

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(String str) {
        this.errorCode = str;
    }

    public final String getErrorUuid() {
        return this.errorUuid;
    }

    public final void setErrorUuid(String str) {
        this.errorUuid = str;
    }
}
