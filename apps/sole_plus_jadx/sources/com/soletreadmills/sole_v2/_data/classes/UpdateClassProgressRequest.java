package com.soletreadmills.sole_v2._data.classes;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: UpdateClassProgressRequest.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/UpdateClassProgressRequest;", "", "()V", "RequestBodyData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpdateClassProgressRequest {
    public static final int $stable = 0;

    /* compiled from: UpdateClassProgressRequest.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/UpdateClassProgressRequest$RequestBodyData;", "", "isDone", "", "(Z)V", "()Z", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 0;

        @SerializedName("is_done")
        private final boolean isDone;

        public RequestBodyData(boolean z) {
            this.isDone = z;
        }

        /* renamed from: isDone, reason: from getter */
        public final boolean getIsDone() {
            return this.isDone;
        }
    }
}
