package com.soletreadmills.sole_v2._data.api.settings;

import com.soletreadmills.sole_v2._data._base.JwtNotificationApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetUnReadMessagesApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetUnReadMessagesApiData;", "", "()V", "ResponseData", "UnReadData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetUnReadMessagesApiData {
    public static final int $stable = 0;

    /* compiled from: GetUnReadMessagesApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetUnReadMessagesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtNotificationApiBaseData;", "()V", "result", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetUnReadMessagesApiData$UnReadData;", "getResult", "()Lcom/soletreadmills/sole_v2/_data/api/settings/GetUnReadMessagesApiData$UnReadData;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtNotificationApiBaseData {
        public static final int $stable = 8;
        private final UnReadData result;

        public final UnReadData getResult() {
            return this.result;
        }
    }

    /* compiled from: GetUnReadMessagesApiData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetUnReadMessagesApiData$UnReadData;", "", "unread_count", "", "(Ljava/lang/Integer;)V", "getUnread_count", "()Ljava/lang/Integer;", "setUnread_count", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/api/settings/GetUnReadMessagesApiData$UnReadData;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class UnReadData {
        public static final int $stable = 8;
        private Integer unread_count;

        /* JADX WARN: Multi-variable type inference failed */
        public UnReadData() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ UnReadData copy$default(UnReadData unReadData, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                num = unReadData.unread_count;
            }
            return unReadData.copy(num);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getUnread_count() {
            return this.unread_count;
        }

        public final UnReadData copy(Integer unread_count) {
            return new UnReadData(unread_count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UnReadData) && Intrinsics.areEqual(this.unread_count, ((UnReadData) other).unread_count);
        }

        public int hashCode() {
            Integer num = this.unread_count;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        public String toString() {
            return "UnReadData(unread_count=" + this.unread_count + ')';
        }

        public UnReadData(Integer num) {
            this.unread_count = num;
        }

        public /* synthetic */ UnReadData(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0 : num);
        }

        public final Integer getUnread_count() {
            return this.unread_count;
        }

        public final void setUnread_count(Integer num) {
            this.unread_count = num;
        }
    }
}
