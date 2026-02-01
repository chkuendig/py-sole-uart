package com.soletreadmills.sole_v2._data.classes;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FollowCollectionRequest.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/FollowCollectionRequest;", "", "()V", "RequestBodyData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FollowCollectionRequest {
    public static final int $stable = 0;

    /* compiled from: FollowCollectionRequest.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/FollowCollectionRequest$RequestBodyData;", "", "collection_id", "", "(Ljava/lang/String;)V", "getCollection_id", "()Ljava/lang/String;", "setCollection_id", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("collection_id")
        private String collection_id;

        public RequestBodyData(String collection_id) {
            Intrinsics.checkNotNullParameter(collection_id, "collection_id");
            this.collection_id = collection_id;
        }

        public final String getCollection_id() {
            return this.collection_id;
        }

        public final void setCollection_id(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.collection_id = str;
        }
    }
}
