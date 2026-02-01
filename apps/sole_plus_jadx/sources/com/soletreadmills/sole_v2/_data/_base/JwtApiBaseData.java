package com.soletreadmills.sole_v2._data._base;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JwtApiBaseData.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData;", "", "()V", "sysMsg", "Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData$SysResponseMessage;", "getSysMsg$annotations", "getSysMsg", "()Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData$SysResponseMessage;", "setSysMsg", "(Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData$SysResponseMessage;)V", "Companion", "SysResponseMessage", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class JwtApiBaseData {
    public static final String CODE_SUCCESS = "200";

    @SerializedName("sys_response_message")
    private SysResponseMessage sysMsg;
    public static final int $stable = 8;

    public static /* synthetic */ void getSysMsg$annotations() {
    }

    public final SysResponseMessage getSysMsg() {
        return this.sysMsg;
    }

    public final void setSysMsg(SysResponseMessage sysResponseMessage) {
        this.sysMsg = sysResponseMessage;
    }

    /* compiled from: JwtApiBaseData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData$SysResponseMessage;", "", "code", "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getMessage", "setMessage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SysResponseMessage {
        public static final int $stable = 8;

        @SerializedName("code")
        private String code;

        @SerializedName("message")
        private String message;

        /* JADX WARN: Multi-variable type inference failed */
        public SysResponseMessage() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SysResponseMessage copy$default(SysResponseMessage sysResponseMessage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sysResponseMessage.code;
            }
            if ((i & 2) != 0) {
                str2 = sysResponseMessage.message;
            }
            return sysResponseMessage.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final SysResponseMessage copy(String code, String message) {
            return new SysResponseMessage(code, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SysResponseMessage)) {
                return false;
            }
            SysResponseMessage sysResponseMessage = (SysResponseMessage) other;
            return Intrinsics.areEqual(this.code, sysResponseMessage.code) && Intrinsics.areEqual(this.message, sysResponseMessage.message);
        }

        public int hashCode() {
            String str = this.code;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.message;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "SysResponseMessage(code=" + this.code + ", message=" + this.message + ')';
        }

        public SysResponseMessage(String str, String str2) {
            this.code = str;
            this.message = str2;
        }

        public /* synthetic */ SysResponseMessage(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

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
}
