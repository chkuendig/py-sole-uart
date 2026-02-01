package com.soletreadmills.sole_v2._data.api.club;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UploadWorkoutApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "VideoRefData", "WorkoutForm", "WorkoutRawData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UploadWorkoutApiData {
    public static final int $stable = 0;

    /* compiled from: UploadWorkoutApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$RequestBodyData;", "", "form", "Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$WorkoutForm;", "virtualRaceTicket", "", "(Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$WorkoutForm;Ljava/lang/String;)V", "getForm", "()Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$WorkoutForm;", "getVirtualRaceTicket", "()Ljava/lang/String;", "setVirtualRaceTicket", "(Ljava/lang/String;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;
        private final WorkoutForm form;
        private String virtualRaceTicket;

        public RequestBodyData(WorkoutForm form, String str) {
            Intrinsics.checkNotNullParameter(form, "form");
            this.form = form;
            this.virtualRaceTicket = str;
        }

        public /* synthetic */ RequestBodyData(WorkoutForm workoutForm, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(workoutForm, (i & 2) != 0 ? null : str);
        }

        public final WorkoutForm getForm() {
            return this.form;
        }

        public final String getVirtualRaceTicket() {
            return this.virtualRaceTicket;
        }

        public final void setVirtualRaceTicket(String str) {
            this.virtualRaceTicket = str;
        }
    }

    /* compiled from: UploadWorkoutApiData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR \u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$ResponseData;", "", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$DataMap;)V", "errorCode", "", "getErrorCode", "()Ljava/lang/String;", "setErrorCode", "(Ljava/lang/String;)V", "errorMessage", "getErrorMessage", "setErrorMessage", "errorUuid", "getErrorUuid", "setErrorUuid", "msg", "getMsg", "setMsg", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData {
        public static final int $stable = 8;

        @SerializedName("dataMap")
        private DataMap dataMap;

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

        public final DataMap getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(DataMap dataMap) {
            this.dataMap = dataMap;
        }
    }

    /* compiled from: UploadWorkoutApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$DataMap;", "", "data", "", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 0;
        private final String data;

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dataMap.data;
            }
            return dataMap.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getData() {
            return this.data;
        }

        public final DataMap copy(String data) {
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            String str = this.data;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(String str) {
            this.data = str;
        }

        public final String getData() {
            return this.data;
        }
    }

    /* compiled from: UploadWorkoutApiData.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bP\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BÏ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001f¢\u0006\u0002\u0010)J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010V\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010W\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010X\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010[\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010]\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010`\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00106J\u0011\u0010d\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010l\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010:J\u0098\u0003\u0010s\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fHÆ\u0001¢\u0006\u0002\u0010tJ\u0013\u0010u\u001a\u00020v2\b\u0010w\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010x\u001a\u00020\u0005HÖ\u0001J\t\u0010y\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010,\u001a\u0004\b.\u0010+R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010,\u001a\u0004\b/\u0010+R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010,\u001a\u0004\b0\u0010+R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010,\u001a\u0004\b1\u0010+R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010,\u001a\u0004\b2\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u00104R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00104R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u00104R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u00104R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00104R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010,\u001a\u0004\b@\u0010+R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u00104R\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u00104R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u00104R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010;\u001a\u0004\bF\u0010:R\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00104R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00107\u001a\u0004\bH\u00106R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010,\u001a\u0004\bI\u0010+R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010,\u001a\u0004\bJ\u0010+R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00107\u001a\u0004\bK\u00106R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00107\u001a\u0004\bL\u00106R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00107\u001a\u0004\bM\u00106R\u0019\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bN\u0010CR\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u00104R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u00104¨\u0006z"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$WorkoutForm;", "", "clientWorkoutUuid", "", "detailMachineCategoryType", "", "machinePairName", "machineMac", "modelNameFromMachine", "startTime", SDKConstants.PARAM_END_TIME, "startTimeMillis", "", "endTimeMillis", "programName", "avgIncline", "", "avgLevel", "avgHeartRate", "avgMet", "avgSpeed", "avgWatt", "avgCadence", "peakHeartRate", "totalElevation", "totalTime", "totalDistance", "totalCalories", "totalSteps", "totalStrokes", "rawDataList", "", "Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$WorkoutRawData;", "timeZone", "workoutType", "workoutDataSource", "videoRefData", "Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$VideoRefData;", "srvoRefData", "externalWorkoutUuid", "usedNoteItems", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$VideoRefData;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAvgCadence", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAvgHeartRate", "getAvgIncline", "getAvgLevel", "getAvgMet", "getAvgSpeed", "getAvgWatt", "getClientWorkoutUuid", "()Ljava/lang/String;", "getDetailMachineCategoryType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndTime", "getEndTimeMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExternalWorkoutUuid", "getMachineMac", "getMachinePairName", "getModelNameFromMachine", "getPeakHeartRate", "getProgramName", "getRawDataList", "()Ljava/util/List;", "getSrvoRefData", "getStartTime", "getStartTimeMillis", "getTimeZone", "getTotalCalories", "getTotalDistance", "getTotalElevation", "getTotalSteps", "getTotalStrokes", "getTotalTime", "getUsedNoteItems", "getVideoRefData", "()Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$VideoRefData;", "getWorkoutDataSource", "getWorkoutType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$VideoRefData;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$WorkoutForm;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class WorkoutForm {
        public static final int $stable = 8;
        private final Double avgCadence;
        private final Double avgHeartRate;
        private final Double avgIncline;
        private final Double avgLevel;
        private final Double avgMet;
        private final Double avgSpeed;
        private final Double avgWatt;
        private final String clientWorkoutUuid;
        private final Integer detailMachineCategoryType;
        private final String endTime;
        private final Long endTimeMillis;
        private final String externalWorkoutUuid;
        private final String machineMac;
        private final String machinePairName;
        private final String modelNameFromMachine;
        private final Double peakHeartRate;
        private final String programName;
        private final List<WorkoutRawData> rawDataList;
        private final String srvoRefData;
        private final String startTime;
        private final Long startTimeMillis;
        private final String timeZone;
        private final Integer totalCalories;
        private final Double totalDistance;
        private final Double totalElevation;
        private final Integer totalSteps;
        private final Integer totalStrokes;
        private final Integer totalTime;
        private final List<String> usedNoteItems;
        private final VideoRefData videoRefData;
        private final String workoutDataSource;
        private final String workoutType;

        /* renamed from: component1, reason: from getter */
        public final String getClientWorkoutUuid() {
            return this.clientWorkoutUuid;
        }

        /* renamed from: component10, reason: from getter */
        public final String getProgramName() {
            return this.programName;
        }

        /* renamed from: component11, reason: from getter */
        public final Double getAvgIncline() {
            return this.avgIncline;
        }

        /* renamed from: component12, reason: from getter */
        public final Double getAvgLevel() {
            return this.avgLevel;
        }

        /* renamed from: component13, reason: from getter */
        public final Double getAvgHeartRate() {
            return this.avgHeartRate;
        }

        /* renamed from: component14, reason: from getter */
        public final Double getAvgMet() {
            return this.avgMet;
        }

        /* renamed from: component15, reason: from getter */
        public final Double getAvgSpeed() {
            return this.avgSpeed;
        }

        /* renamed from: component16, reason: from getter */
        public final Double getAvgWatt() {
            return this.avgWatt;
        }

        /* renamed from: component17, reason: from getter */
        public final Double getAvgCadence() {
            return this.avgCadence;
        }

        /* renamed from: component18, reason: from getter */
        public final Double getPeakHeartRate() {
            return this.peakHeartRate;
        }

        /* renamed from: component19, reason: from getter */
        public final Double getTotalElevation() {
            return this.totalElevation;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getDetailMachineCategoryType() {
            return this.detailMachineCategoryType;
        }

        /* renamed from: component20, reason: from getter */
        public final Integer getTotalTime() {
            return this.totalTime;
        }

        /* renamed from: component21, reason: from getter */
        public final Double getTotalDistance() {
            return this.totalDistance;
        }

        /* renamed from: component22, reason: from getter */
        public final Integer getTotalCalories() {
            return this.totalCalories;
        }

        /* renamed from: component23, reason: from getter */
        public final Integer getTotalSteps() {
            return this.totalSteps;
        }

        /* renamed from: component24, reason: from getter */
        public final Integer getTotalStrokes() {
            return this.totalStrokes;
        }

        public final List<WorkoutRawData> component25() {
            return this.rawDataList;
        }

        /* renamed from: component26, reason: from getter */
        public final String getTimeZone() {
            return this.timeZone;
        }

        /* renamed from: component27, reason: from getter */
        public final String getWorkoutType() {
            return this.workoutType;
        }

        /* renamed from: component28, reason: from getter */
        public final String getWorkoutDataSource() {
            return this.workoutDataSource;
        }

        /* renamed from: component29, reason: from getter */
        public final VideoRefData getVideoRefData() {
            return this.videoRefData;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMachinePairName() {
            return this.machinePairName;
        }

        /* renamed from: component30, reason: from getter */
        public final String getSrvoRefData() {
            return this.srvoRefData;
        }

        /* renamed from: component31, reason: from getter */
        public final String getExternalWorkoutUuid() {
            return this.externalWorkoutUuid;
        }

        public final List<String> component32() {
            return this.usedNoteItems;
        }

        /* renamed from: component4, reason: from getter */
        public final String getMachineMac() {
            return this.machineMac;
        }

        /* renamed from: component5, reason: from getter */
        public final String getModelNameFromMachine() {
            return this.modelNameFromMachine;
        }

        /* renamed from: component6, reason: from getter */
        public final String getStartTime() {
            return this.startTime;
        }

        /* renamed from: component7, reason: from getter */
        public final String getEndTime() {
            return this.endTime;
        }

        /* renamed from: component8, reason: from getter */
        public final Long getStartTimeMillis() {
            return this.startTimeMillis;
        }

        /* renamed from: component9, reason: from getter */
        public final Long getEndTimeMillis() {
            return this.endTimeMillis;
        }

        public final WorkoutForm copy(String clientWorkoutUuid, Integer detailMachineCategoryType, String machinePairName, String machineMac, String modelNameFromMachine, String startTime, String endTime, Long startTimeMillis, Long endTimeMillis, String programName, Double avgIncline, Double avgLevel, Double avgHeartRate, Double avgMet, Double avgSpeed, Double avgWatt, Double avgCadence, Double peakHeartRate, Double totalElevation, Integer totalTime, Double totalDistance, Integer totalCalories, Integer totalSteps, Integer totalStrokes, List<WorkoutRawData> rawDataList, String timeZone, String workoutType, String workoutDataSource, VideoRefData videoRefData, String srvoRefData, String externalWorkoutUuid, List<String> usedNoteItems) {
            Intrinsics.checkNotNullParameter(clientWorkoutUuid, "clientWorkoutUuid");
            return new WorkoutForm(clientWorkoutUuid, detailMachineCategoryType, machinePairName, machineMac, modelNameFromMachine, startTime, endTime, startTimeMillis, endTimeMillis, programName, avgIncline, avgLevel, avgHeartRate, avgMet, avgSpeed, avgWatt, avgCadence, peakHeartRate, totalElevation, totalTime, totalDistance, totalCalories, totalSteps, totalStrokes, rawDataList, timeZone, workoutType, workoutDataSource, videoRefData, srvoRefData, externalWorkoutUuid, usedNoteItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WorkoutForm)) {
                return false;
            }
            WorkoutForm workoutForm = (WorkoutForm) other;
            return Intrinsics.areEqual(this.clientWorkoutUuid, workoutForm.clientWorkoutUuid) && Intrinsics.areEqual(this.detailMachineCategoryType, workoutForm.detailMachineCategoryType) && Intrinsics.areEqual(this.machinePairName, workoutForm.machinePairName) && Intrinsics.areEqual(this.machineMac, workoutForm.machineMac) && Intrinsics.areEqual(this.modelNameFromMachine, workoutForm.modelNameFromMachine) && Intrinsics.areEqual(this.startTime, workoutForm.startTime) && Intrinsics.areEqual(this.endTime, workoutForm.endTime) && Intrinsics.areEqual(this.startTimeMillis, workoutForm.startTimeMillis) && Intrinsics.areEqual(this.endTimeMillis, workoutForm.endTimeMillis) && Intrinsics.areEqual(this.programName, workoutForm.programName) && Intrinsics.areEqual((Object) this.avgIncline, (Object) workoutForm.avgIncline) && Intrinsics.areEqual((Object) this.avgLevel, (Object) workoutForm.avgLevel) && Intrinsics.areEqual((Object) this.avgHeartRate, (Object) workoutForm.avgHeartRate) && Intrinsics.areEqual((Object) this.avgMet, (Object) workoutForm.avgMet) && Intrinsics.areEqual((Object) this.avgSpeed, (Object) workoutForm.avgSpeed) && Intrinsics.areEqual((Object) this.avgWatt, (Object) workoutForm.avgWatt) && Intrinsics.areEqual((Object) this.avgCadence, (Object) workoutForm.avgCadence) && Intrinsics.areEqual((Object) this.peakHeartRate, (Object) workoutForm.peakHeartRate) && Intrinsics.areEqual((Object) this.totalElevation, (Object) workoutForm.totalElevation) && Intrinsics.areEqual(this.totalTime, workoutForm.totalTime) && Intrinsics.areEqual((Object) this.totalDistance, (Object) workoutForm.totalDistance) && Intrinsics.areEqual(this.totalCalories, workoutForm.totalCalories) && Intrinsics.areEqual(this.totalSteps, workoutForm.totalSteps) && Intrinsics.areEqual(this.totalStrokes, workoutForm.totalStrokes) && Intrinsics.areEqual(this.rawDataList, workoutForm.rawDataList) && Intrinsics.areEqual(this.timeZone, workoutForm.timeZone) && Intrinsics.areEqual(this.workoutType, workoutForm.workoutType) && Intrinsics.areEqual(this.workoutDataSource, workoutForm.workoutDataSource) && Intrinsics.areEqual(this.videoRefData, workoutForm.videoRefData) && Intrinsics.areEqual(this.srvoRefData, workoutForm.srvoRefData) && Intrinsics.areEqual(this.externalWorkoutUuid, workoutForm.externalWorkoutUuid) && Intrinsics.areEqual(this.usedNoteItems, workoutForm.usedNoteItems);
        }

        public int hashCode() {
            int iHashCode = this.clientWorkoutUuid.hashCode() * 31;
            Integer num = this.detailMachineCategoryType;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.machinePairName;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.machineMac;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.modelNameFromMachine;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.startTime;
            int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.endTime;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Long l = this.startTimeMillis;
            int iHashCode8 = (iHashCode7 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.endTimeMillis;
            int iHashCode9 = (iHashCode8 + (l2 == null ? 0 : l2.hashCode())) * 31;
            String str6 = this.programName;
            int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Double d = this.avgIncline;
            int iHashCode11 = (iHashCode10 + (d == null ? 0 : d.hashCode())) * 31;
            Double d2 = this.avgLevel;
            int iHashCode12 = (iHashCode11 + (d2 == null ? 0 : d2.hashCode())) * 31;
            Double d3 = this.avgHeartRate;
            int iHashCode13 = (iHashCode12 + (d3 == null ? 0 : d3.hashCode())) * 31;
            Double d4 = this.avgMet;
            int iHashCode14 = (iHashCode13 + (d4 == null ? 0 : d4.hashCode())) * 31;
            Double d5 = this.avgSpeed;
            int iHashCode15 = (iHashCode14 + (d5 == null ? 0 : d5.hashCode())) * 31;
            Double d6 = this.avgWatt;
            int iHashCode16 = (iHashCode15 + (d6 == null ? 0 : d6.hashCode())) * 31;
            Double d7 = this.avgCadence;
            int iHashCode17 = (iHashCode16 + (d7 == null ? 0 : d7.hashCode())) * 31;
            Double d8 = this.peakHeartRate;
            int iHashCode18 = (iHashCode17 + (d8 == null ? 0 : d8.hashCode())) * 31;
            Double d9 = this.totalElevation;
            int iHashCode19 = (iHashCode18 + (d9 == null ? 0 : d9.hashCode())) * 31;
            Integer num2 = this.totalTime;
            int iHashCode20 = (iHashCode19 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Double d10 = this.totalDistance;
            int iHashCode21 = (iHashCode20 + (d10 == null ? 0 : d10.hashCode())) * 31;
            Integer num3 = this.totalCalories;
            int iHashCode22 = (iHashCode21 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.totalSteps;
            int iHashCode23 = (iHashCode22 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.totalStrokes;
            int iHashCode24 = (iHashCode23 + (num5 == null ? 0 : num5.hashCode())) * 31;
            List<WorkoutRawData> list = this.rawDataList;
            int iHashCode25 = (iHashCode24 + (list == null ? 0 : list.hashCode())) * 31;
            String str7 = this.timeZone;
            int iHashCode26 = (iHashCode25 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.workoutType;
            int iHashCode27 = (iHashCode26 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.workoutDataSource;
            int iHashCode28 = (iHashCode27 + (str9 == null ? 0 : str9.hashCode())) * 31;
            VideoRefData videoRefData = this.videoRefData;
            int iHashCode29 = (iHashCode28 + (videoRefData == null ? 0 : videoRefData.hashCode())) * 31;
            String str10 = this.srvoRefData;
            int iHashCode30 = (iHashCode29 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.externalWorkoutUuid;
            int iHashCode31 = (iHashCode30 + (str11 == null ? 0 : str11.hashCode())) * 31;
            List<String> list2 = this.usedNoteItems;
            return iHashCode31 + (list2 != null ? list2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("WorkoutForm(clientWorkoutUuid=");
            sb.append(this.clientWorkoutUuid).append(", detailMachineCategoryType=").append(this.detailMachineCategoryType).append(", machinePairName=").append(this.machinePairName).append(", machineMac=").append(this.machineMac).append(", modelNameFromMachine=").append(this.modelNameFromMachine).append(", startTime=").append(this.startTime).append(", endTime=").append(this.endTime).append(", startTimeMillis=").append(this.startTimeMillis).append(", endTimeMillis=").append(this.endTimeMillis).append(", programName=").append(this.programName).append(", avgIncline=").append(this.avgIncline).append(", avgLevel=");
            sb.append(this.avgLevel).append(", avgHeartRate=").append(this.avgHeartRate).append(", avgMet=").append(this.avgMet).append(", avgSpeed=").append(this.avgSpeed).append(", avgWatt=").append(this.avgWatt).append(", avgCadence=").append(this.avgCadence).append(", peakHeartRate=").append(this.peakHeartRate).append(", totalElevation=").append(this.totalElevation).append(", totalTime=").append(this.totalTime).append(", totalDistance=").append(this.totalDistance).append(", totalCalories=").append(this.totalCalories).append(", totalSteps=").append(this.totalSteps);
            sb.append(", totalStrokes=").append(this.totalStrokes).append(", rawDataList=").append(this.rawDataList).append(", timeZone=").append(this.timeZone).append(", workoutType=").append(this.workoutType).append(", workoutDataSource=").append(this.workoutDataSource).append(", videoRefData=").append(this.videoRefData).append(", srvoRefData=").append(this.srvoRefData).append(", externalWorkoutUuid=").append(this.externalWorkoutUuid).append(", usedNoteItems=").append(this.usedNoteItems).append(')');
            return sb.toString();
        }

        public WorkoutForm(String clientWorkoutUuid, Integer num, String str, String str2, String str3, String str4, String str5, Long l, Long l2, String str6, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Integer num2, Double d10, Integer num3, Integer num4, Integer num5, List<WorkoutRawData> list, String str7, String str8, String str9, VideoRefData videoRefData, String str10, String str11, List<String> list2) {
            Intrinsics.checkNotNullParameter(clientWorkoutUuid, "clientWorkoutUuid");
            this.clientWorkoutUuid = clientWorkoutUuid;
            this.detailMachineCategoryType = num;
            this.machinePairName = str;
            this.machineMac = str2;
            this.modelNameFromMachine = str3;
            this.startTime = str4;
            this.endTime = str5;
            this.startTimeMillis = l;
            this.endTimeMillis = l2;
            this.programName = str6;
            this.avgIncline = d;
            this.avgLevel = d2;
            this.avgHeartRate = d3;
            this.avgMet = d4;
            this.avgSpeed = d5;
            this.avgWatt = d6;
            this.avgCadence = d7;
            this.peakHeartRate = d8;
            this.totalElevation = d9;
            this.totalTime = num2;
            this.totalDistance = d10;
            this.totalCalories = num3;
            this.totalSteps = num4;
            this.totalStrokes = num5;
            this.rawDataList = list;
            this.timeZone = str7;
            this.workoutType = str8;
            this.workoutDataSource = str9;
            this.videoRefData = videoRefData;
            this.srvoRefData = str10;
            this.externalWorkoutUuid = str11;
            this.usedNoteItems = list2;
        }

        public final String getClientWorkoutUuid() {
            return this.clientWorkoutUuid;
        }

        public final Integer getDetailMachineCategoryType() {
            return this.detailMachineCategoryType;
        }

        public final String getMachinePairName() {
            return this.machinePairName;
        }

        public final String getMachineMac() {
            return this.machineMac;
        }

        public final String getModelNameFromMachine() {
            return this.modelNameFromMachine;
        }

        public final String getStartTime() {
            return this.startTime;
        }

        public final String getEndTime() {
            return this.endTime;
        }

        public final Long getStartTimeMillis() {
            return this.startTimeMillis;
        }

        public final Long getEndTimeMillis() {
            return this.endTimeMillis;
        }

        public final String getProgramName() {
            return this.programName;
        }

        public final Double getAvgIncline() {
            return this.avgIncline;
        }

        public final Double getAvgLevel() {
            return this.avgLevel;
        }

        public final Double getAvgHeartRate() {
            return this.avgHeartRate;
        }

        public final Double getAvgMet() {
            return this.avgMet;
        }

        public final Double getAvgSpeed() {
            return this.avgSpeed;
        }

        public final Double getAvgWatt() {
            return this.avgWatt;
        }

        public final Double getAvgCadence() {
            return this.avgCadence;
        }

        public final Double getPeakHeartRate() {
            return this.peakHeartRate;
        }

        public final Double getTotalElevation() {
            return this.totalElevation;
        }

        public final Integer getTotalTime() {
            return this.totalTime;
        }

        public final Double getTotalDistance() {
            return this.totalDistance;
        }

        public final Integer getTotalCalories() {
            return this.totalCalories;
        }

        public final Integer getTotalSteps() {
            return this.totalSteps;
        }

        public final Integer getTotalStrokes() {
            return this.totalStrokes;
        }

        public final List<WorkoutRawData> getRawDataList() {
            return this.rawDataList;
        }

        public final String getTimeZone() {
            return this.timeZone;
        }

        public final String getWorkoutType() {
            return this.workoutType;
        }

        public final String getWorkoutDataSource() {
            return this.workoutDataSource;
        }

        public final VideoRefData getVideoRefData() {
            return this.videoRefData;
        }

        public final String getSrvoRefData() {
            return this.srvoRefData;
        }

        public final String getExternalWorkoutUuid() {
            return this.externalWorkoutUuid;
        }

        public final List<String> getUsedNoteItems() {
            return this.usedNoteItems;
        }
    }

    /* compiled from: UploadWorkoutApiData.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJæ\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0003HÖ\u0001J\t\u0010E\u001a\u00020FHÖ\u0001R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0018R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\"\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b#\u0010\u0018R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b$\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b%\u0010\u001eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b&\u0010\u0018R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b'\u0010\u0018R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b(\u0010\u001eR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b)\u0010\u001eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b+\u0010\u001eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b,\u0010\u001e¨\u0006G"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$WorkoutRawData;", "", "totalWorkoutTime", "", "totalTimeLeft", "nowHr", "totalDistance", "", "nowPace", "totalCalorie", "nowSpeed", "nowIncline", "nowLevel", "nowWatt", "avgSpmRower", "totalStrokes", "avgRpm", "totalFloor", "totalElevation", "totalSteps", "curSpmStepper", "avgSpmStepper", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)V", "getAvgRpm", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAvgSpmRower", "getAvgSpmStepper", "getCurSpmStepper", "getNowHr", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNowIncline", "getNowLevel", "getNowPace", "getNowSpeed", "getNowWatt", "getTotalCalorie", "getTotalDistance", "getTotalElevation", "getTotalFloor", "getTotalSteps", "getTotalStrokes", "getTotalTimeLeft", "getTotalWorkoutTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$WorkoutRawData;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class WorkoutRawData {
        public static final int $stable = 0;
        private final Double avgRpm;
        private final Double avgSpmRower;
        private final Double avgSpmStepper;
        private final Double curSpmStepper;
        private final Integer nowHr;
        private final Double nowIncline;
        private final Integer nowLevel;
        private final Integer nowPace;
        private final Double nowSpeed;
        private final Double nowWatt;
        private final Integer totalCalorie;
        private final Double totalDistance;
        private final Double totalElevation;
        private final Integer totalFloor;
        private final Integer totalSteps;
        private final Integer totalStrokes;
        private final Integer totalTimeLeft;
        private final Integer totalWorkoutTime;

        public WorkoutRawData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getTotalWorkoutTime() {
            return this.totalWorkoutTime;
        }

        /* renamed from: component10, reason: from getter */
        public final Double getNowWatt() {
            return this.nowWatt;
        }

        /* renamed from: component11, reason: from getter */
        public final Double getAvgSpmRower() {
            return this.avgSpmRower;
        }

        /* renamed from: component12, reason: from getter */
        public final Integer getTotalStrokes() {
            return this.totalStrokes;
        }

        /* renamed from: component13, reason: from getter */
        public final Double getAvgRpm() {
            return this.avgRpm;
        }

        /* renamed from: component14, reason: from getter */
        public final Integer getTotalFloor() {
            return this.totalFloor;
        }

        /* renamed from: component15, reason: from getter */
        public final Double getTotalElevation() {
            return this.totalElevation;
        }

        /* renamed from: component16, reason: from getter */
        public final Integer getTotalSteps() {
            return this.totalSteps;
        }

        /* renamed from: component17, reason: from getter */
        public final Double getCurSpmStepper() {
            return this.curSpmStepper;
        }

        /* renamed from: component18, reason: from getter */
        public final Double getAvgSpmStepper() {
            return this.avgSpmStepper;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getTotalTimeLeft() {
            return this.totalTimeLeft;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getNowHr() {
            return this.nowHr;
        }

        /* renamed from: component4, reason: from getter */
        public final Double getTotalDistance() {
            return this.totalDistance;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getNowPace() {
            return this.nowPace;
        }

        /* renamed from: component6, reason: from getter */
        public final Integer getTotalCalorie() {
            return this.totalCalorie;
        }

        /* renamed from: component7, reason: from getter */
        public final Double getNowSpeed() {
            return this.nowSpeed;
        }

        /* renamed from: component8, reason: from getter */
        public final Double getNowIncline() {
            return this.nowIncline;
        }

        /* renamed from: component9, reason: from getter */
        public final Integer getNowLevel() {
            return this.nowLevel;
        }

        public final WorkoutRawData copy(Integer totalWorkoutTime, Integer totalTimeLeft, Integer nowHr, Double totalDistance, Integer nowPace, Integer totalCalorie, Double nowSpeed, Double nowIncline, Integer nowLevel, Double nowWatt, Double avgSpmRower, Integer totalStrokes, Double avgRpm, Integer totalFloor, Double totalElevation, Integer totalSteps, Double curSpmStepper, Double avgSpmStepper) {
            return new WorkoutRawData(totalWorkoutTime, totalTimeLeft, nowHr, totalDistance, nowPace, totalCalorie, nowSpeed, nowIncline, nowLevel, nowWatt, avgSpmRower, totalStrokes, avgRpm, totalFloor, totalElevation, totalSteps, curSpmStepper, avgSpmStepper);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WorkoutRawData)) {
                return false;
            }
            WorkoutRawData workoutRawData = (WorkoutRawData) other;
            return Intrinsics.areEqual(this.totalWorkoutTime, workoutRawData.totalWorkoutTime) && Intrinsics.areEqual(this.totalTimeLeft, workoutRawData.totalTimeLeft) && Intrinsics.areEqual(this.nowHr, workoutRawData.nowHr) && Intrinsics.areEqual((Object) this.totalDistance, (Object) workoutRawData.totalDistance) && Intrinsics.areEqual(this.nowPace, workoutRawData.nowPace) && Intrinsics.areEqual(this.totalCalorie, workoutRawData.totalCalorie) && Intrinsics.areEqual((Object) this.nowSpeed, (Object) workoutRawData.nowSpeed) && Intrinsics.areEqual((Object) this.nowIncline, (Object) workoutRawData.nowIncline) && Intrinsics.areEqual(this.nowLevel, workoutRawData.nowLevel) && Intrinsics.areEqual((Object) this.nowWatt, (Object) workoutRawData.nowWatt) && Intrinsics.areEqual((Object) this.avgSpmRower, (Object) workoutRawData.avgSpmRower) && Intrinsics.areEqual(this.totalStrokes, workoutRawData.totalStrokes) && Intrinsics.areEqual((Object) this.avgRpm, (Object) workoutRawData.avgRpm) && Intrinsics.areEqual(this.totalFloor, workoutRawData.totalFloor) && Intrinsics.areEqual((Object) this.totalElevation, (Object) workoutRawData.totalElevation) && Intrinsics.areEqual(this.totalSteps, workoutRawData.totalSteps) && Intrinsics.areEqual((Object) this.curSpmStepper, (Object) workoutRawData.curSpmStepper) && Intrinsics.areEqual((Object) this.avgSpmStepper, (Object) workoutRawData.avgSpmStepper);
        }

        public int hashCode() {
            Integer num = this.totalWorkoutTime;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.totalTimeLeft;
            int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.nowHr;
            int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Double d = this.totalDistance;
            int iHashCode4 = (iHashCode3 + (d == null ? 0 : d.hashCode())) * 31;
            Integer num4 = this.nowPace;
            int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.totalCalorie;
            int iHashCode6 = (iHashCode5 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Double d2 = this.nowSpeed;
            int iHashCode7 = (iHashCode6 + (d2 == null ? 0 : d2.hashCode())) * 31;
            Double d3 = this.nowIncline;
            int iHashCode8 = (iHashCode7 + (d3 == null ? 0 : d3.hashCode())) * 31;
            Integer num6 = this.nowLevel;
            int iHashCode9 = (iHashCode8 + (num6 == null ? 0 : num6.hashCode())) * 31;
            Double d4 = this.nowWatt;
            int iHashCode10 = (iHashCode9 + (d4 == null ? 0 : d4.hashCode())) * 31;
            Double d5 = this.avgSpmRower;
            int iHashCode11 = (iHashCode10 + (d5 == null ? 0 : d5.hashCode())) * 31;
            Integer num7 = this.totalStrokes;
            int iHashCode12 = (iHashCode11 + (num7 == null ? 0 : num7.hashCode())) * 31;
            Double d6 = this.avgRpm;
            int iHashCode13 = (iHashCode12 + (d6 == null ? 0 : d6.hashCode())) * 31;
            Integer num8 = this.totalFloor;
            int iHashCode14 = (iHashCode13 + (num8 == null ? 0 : num8.hashCode())) * 31;
            Double d7 = this.totalElevation;
            int iHashCode15 = (iHashCode14 + (d7 == null ? 0 : d7.hashCode())) * 31;
            Integer num9 = this.totalSteps;
            int iHashCode16 = (iHashCode15 + (num9 == null ? 0 : num9.hashCode())) * 31;
            Double d8 = this.curSpmStepper;
            int iHashCode17 = (iHashCode16 + (d8 == null ? 0 : d8.hashCode())) * 31;
            Double d9 = this.avgSpmStepper;
            return iHashCode17 + (d9 != null ? d9.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("WorkoutRawData(totalWorkoutTime=");
            sb.append(this.totalWorkoutTime).append(", totalTimeLeft=").append(this.totalTimeLeft).append(", nowHr=").append(this.nowHr).append(", totalDistance=").append(this.totalDistance).append(", nowPace=").append(this.nowPace).append(", totalCalorie=").append(this.totalCalorie).append(", nowSpeed=").append(this.nowSpeed).append(", nowIncline=").append(this.nowIncline).append(", nowLevel=").append(this.nowLevel).append(", nowWatt=").append(this.nowWatt).append(", avgSpmRower=").append(this.avgSpmRower).append(", totalStrokes=");
            sb.append(this.totalStrokes).append(", avgRpm=").append(this.avgRpm).append(", totalFloor=").append(this.totalFloor).append(", totalElevation=").append(this.totalElevation).append(", totalSteps=").append(this.totalSteps).append(", curSpmStepper=").append(this.curSpmStepper).append(", avgSpmStepper=").append(this.avgSpmStepper).append(')');
            return sb.toString();
        }

        public WorkoutRawData(Integer num, Integer num2, Integer num3, Double d, Integer num4, Integer num5, Double d2, Double d3, Integer num6, Double d4, Double d5, Integer num7, Double d6, Integer num8, Double d7, Integer num9, Double d8, Double d9) {
            this.totalWorkoutTime = num;
            this.totalTimeLeft = num2;
            this.nowHr = num3;
            this.totalDistance = d;
            this.nowPace = num4;
            this.totalCalorie = num5;
            this.nowSpeed = d2;
            this.nowIncline = d3;
            this.nowLevel = num6;
            this.nowWatt = d4;
            this.avgSpmRower = d5;
            this.totalStrokes = num7;
            this.avgRpm = d6;
            this.totalFloor = num8;
            this.totalElevation = d7;
            this.totalSteps = num9;
            this.curSpmStepper = d8;
            this.avgSpmStepper = d9;
        }

        public /* synthetic */ WorkoutRawData(Integer num, Integer num2, Integer num3, Double d, Integer num4, Integer num5, Double d2, Double d3, Integer num6, Double d4, Double d5, Integer num7, Double d6, Integer num8, Double d7, Integer num9, Double d8, Double d9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : num5, (i & 64) != 0 ? null : d2, (i & 128) != 0 ? null : d3, (i & 256) != 0 ? null : num6, (i & 512) != 0 ? null : d4, (i & 1024) != 0 ? null : d5, (i & 2048) != 0 ? null : num7, (i & 4096) != 0 ? null : d6, (i & 8192) != 0 ? null : num8, (i & 16384) != 0 ? null : d7, (i & 32768) != 0 ? null : num9, (i & 65536) != 0 ? null : d8, (i & 131072) != 0 ? null : d9);
        }

        public final Integer getTotalWorkoutTime() {
            return this.totalWorkoutTime;
        }

        public final Integer getTotalTimeLeft() {
            return this.totalTimeLeft;
        }

        public final Integer getNowHr() {
            return this.nowHr;
        }

        public final Double getTotalDistance() {
            return this.totalDistance;
        }

        public final Integer getNowPace() {
            return this.nowPace;
        }

        public final Integer getTotalCalorie() {
            return this.totalCalorie;
        }

        public final Double getNowSpeed() {
            return this.nowSpeed;
        }

        public final Double getNowIncline() {
            return this.nowIncline;
        }

        public final Integer getNowLevel() {
            return this.nowLevel;
        }

        public final Double getNowWatt() {
            return this.nowWatt;
        }

        public final Double getAvgSpmRower() {
            return this.avgSpmRower;
        }

        public final Integer getTotalStrokes() {
            return this.totalStrokes;
        }

        public final Double getAvgRpm() {
            return this.avgRpm;
        }

        public final Integer getTotalFloor() {
            return this.totalFloor;
        }

        public final Double getTotalElevation() {
            return this.totalElevation;
        }

        public final Integer getTotalSteps() {
            return this.totalSteps;
        }

        public final Double getCurSpmStepper() {
            return this.curSpmStepper;
        }

        public final Double getAvgSpmStepper() {
            return this.avgSpmStepper;
        }
    }

    /* compiled from: UploadWorkoutApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$VideoRefData;", "", "classId", "", "className", "classType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClassId", "()Ljava/lang/String;", "getClassName", "getClassType", "setClassType", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class VideoRefData {
        public static final int $stable = 8;
        private final String classId;
        private final String className;
        private String classType;

        public static /* synthetic */ VideoRefData copy$default(VideoRefData videoRefData, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = videoRefData.classId;
            }
            if ((i & 2) != 0) {
                str2 = videoRefData.className;
            }
            if ((i & 4) != 0) {
                str3 = videoRefData.classType;
            }
            return videoRefData.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getClassId() {
            return this.classId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getClassName() {
            return this.className;
        }

        /* renamed from: component3, reason: from getter */
        public final String getClassType() {
            return this.classType;
        }

        public final VideoRefData copy(String classId, String className, String classType) {
            return new VideoRefData(classId, className, classType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoRefData)) {
                return false;
            }
            VideoRefData videoRefData = (VideoRefData) other;
            return Intrinsics.areEqual(this.classId, videoRefData.classId) && Intrinsics.areEqual(this.className, videoRefData.className) && Intrinsics.areEqual(this.classType, videoRefData.classType);
        }

        public int hashCode() {
            String str = this.classId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.className;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.classType;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "VideoRefData(classId=" + this.classId + ", className=" + this.className + ", classType=" + this.classType + ')';
        }

        public VideoRefData(String str, String str2, String str3) {
            this.classId = str;
            this.className = str2;
            this.classType = str3;
        }

        public final String getClassId() {
            return this.classId;
        }

        public final String getClassName() {
            return this.className;
        }

        public final String getClassType() {
            return this.classType;
        }

        public final void setClassType(String str) {
            this.classType = str;
        }
    }
}
