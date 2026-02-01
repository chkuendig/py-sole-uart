package com.soletreadmills.sole_v2._data.api.goal;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._data.goal.UserGoalCreateFormToUpload;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreateUserGoalApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateUserGoalApiData {
    public static final int $stable = 0;

    /* compiled from: CreateUserGoalApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$RequestBodyData;", "", "form", "Lcom/soletreadmills/sole_v2/_data/goal/UserGoalCreateFormToUpload;", "(Lcom/soletreadmills/sole_v2/_data/goal/UserGoalCreateFormToUpload;)V", "getForm", "()Lcom/soletreadmills/sole_v2/_data/goal/UserGoalCreateFormToUpload;", "setForm", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("form")
        private UserGoalCreateFormToUpload form;

        public RequestBodyData(UserGoalCreateFormToUpload form) {
            Intrinsics.checkNotNullParameter(form, "form");
            this.form = form;
        }

        public final UserGoalCreateFormToUpload getForm() {
            return this.form;
        }

        public final void setForm(UserGoalCreateFormToUpload userGoalCreateFormToUpload) {
            Intrinsics.checkNotNullParameter(userGoalCreateFormToUpload, "<set-?>");
            this.form = userGoalCreateFormToUpload;
        }
    }

    /* compiled from: CreateUserGoalApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 8;

        @SerializedName("dataMap")
        private DataMap dataMap;

        public final DataMap getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(DataMap dataMap) {
            this.dataMap = dataMap;
        }
    }

    /* compiled from: CreateUserGoalApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$DataMap;", "", "data", "", "userGoalUuid", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getUserGoalUuid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 0;

        @SerializedName("data")
        private final String data;

        @SerializedName("userGoalUuid")
        private final String userGoalUuid;

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dataMap.data;
            }
            if ((i & 2) != 0) {
                str2 = dataMap.userGoalUuid;
            }
            return dataMap.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getData() {
            return this.data;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUserGoalUuid() {
            return this.userGoalUuid;
        }

        public final DataMap copy(String data, String userGoalUuid) {
            return new DataMap(data, userGoalUuid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataMap)) {
                return false;
            }
            DataMap dataMap = (DataMap) other;
            return Intrinsics.areEqual(this.data, dataMap.data) && Intrinsics.areEqual(this.userGoalUuid, dataMap.userGoalUuid);
        }

        public int hashCode() {
            String str = this.data;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.userGoalUuid;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "DataMap(data=" + this.data + ", userGoalUuid=" + this.userGoalUuid + ')';
        }

        public DataMap(String str, String str2) {
            this.data = str;
            this.userGoalUuid = str2;
        }

        public /* synthetic */ DataMap(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, str2);
        }

        public final String getData() {
            return this.data;
        }

        public final String getUserGoalUuid() {
            return this.userGoalUuid;
        }
    }
}
