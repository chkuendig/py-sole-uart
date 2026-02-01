package com.soletreadmills.sole_v2._data.api.settings;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtNotificationApiBaseData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetMessagesApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData;", "", "()V", "MessageData", "RequestBody", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetMessagesApiData {
    public static final int $stable = 0;

    /* compiled from: GetMessagesApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$RequestBody;", "", "page", "", "(I)V", "getPage", "()I", "pageSize", "getPageSize", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBody {
        public static final int $stable = 0;

        @SerializedName("page")
        private final int page;

        @SerializedName("pageSize")
        private final int pageSize = 100;

        public RequestBody(int i) {
            this.page = i;
        }

        public final int getPage() {
            return this.page;
        }

        public final int getPageSize() {
            return this.pageSize;
        }
    }

    /* compiled from: GetMessagesApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtNotificationApiBaseData;", "()V", "result", "", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$MessageData;", "getResult", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtNotificationApiBaseData {
        public static final int $stable = 8;
        private final List<MessageData> result;

        public final List<MessageData> getResult() {
            return this.result;
        }
    }

    /* compiled from: GetMessagesApiData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0005\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006("}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$MessageData;", "", "body", "", "cover_url", "is_read", "", "message_category", "", Constants.MessagePayloadKeys.MSGID_SERVER, "message_url", "publish_date", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBody", "()Ljava/lang/String;", "getCover_url", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessage_category", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage_id", "getMessage_url", "getPublish_date", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$MessageData;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class MessageData {
        public static final int $stable = 0;
        private final String body;
        private final String cover_url;
        private final Boolean is_read;
        private final Integer message_category;
        private final String message_id;
        private final String message_url;
        private final String publish_date;
        private final String title;

        /* renamed from: component1, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCover_url() {
            return this.cover_url;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getIs_read() {
            return this.is_read;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getMessage_category() {
            return this.message_category;
        }

        /* renamed from: component5, reason: from getter */
        public final String getMessage_id() {
            return this.message_id;
        }

        /* renamed from: component6, reason: from getter */
        public final String getMessage_url() {
            return this.message_url;
        }

        /* renamed from: component7, reason: from getter */
        public final String getPublish_date() {
            return this.publish_date;
        }

        /* renamed from: component8, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final MessageData copy(String body, String cover_url, Boolean is_read, Integer message_category, String message_id, String message_url, String publish_date, String title) {
            return new MessageData(body, cover_url, is_read, message_category, message_id, message_url, publish_date, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageData)) {
                return false;
            }
            MessageData messageData = (MessageData) other;
            return Intrinsics.areEqual(this.body, messageData.body) && Intrinsics.areEqual(this.cover_url, messageData.cover_url) && Intrinsics.areEqual(this.is_read, messageData.is_read) && Intrinsics.areEqual(this.message_category, messageData.message_category) && Intrinsics.areEqual(this.message_id, messageData.message_id) && Intrinsics.areEqual(this.message_url, messageData.message_url) && Intrinsics.areEqual(this.publish_date, messageData.publish_date) && Intrinsics.areEqual(this.title, messageData.title);
        }

        public int hashCode() {
            String str = this.body;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.cover_url;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.is_read;
            int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            Integer num = this.message_category;
            int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            String str3 = this.message_id;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.message_url;
            int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.publish_date;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.title;
            return iHashCode7 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            return "MessageData(body=" + this.body + ", cover_url=" + this.cover_url + ", is_read=" + this.is_read + ", message_category=" + this.message_category + ", message_id=" + this.message_id + ", message_url=" + this.message_url + ", publish_date=" + this.publish_date + ", title=" + this.title + ')';
        }

        public MessageData(String str, String str2, Boolean bool, Integer num, String str3, String str4, String str5, String str6) {
            this.body = str;
            this.cover_url = str2;
            this.is_read = bool;
            this.message_category = num;
            this.message_id = str3;
            this.message_url = str4;
            this.publish_date = str5;
            this.title = str6;
        }

        public final String getBody() {
            return this.body;
        }

        public final String getCover_url() {
            return this.cover_url;
        }

        public final Boolean is_read() {
            return this.is_read;
        }

        public final Integer getMessage_category() {
            return this.message_category;
        }

        public final String getMessage_id() {
            return this.message_id;
        }

        public final String getMessage_url() {
            return this.message_url;
        }

        public final String getPublish_date() {
            return this.publish_date;
        }

        public final String getTitle() {
            return this.title;
        }
    }
}
