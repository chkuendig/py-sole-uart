package com.soletreadmills.sole_v2._data.classes;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: CompletedClassEventRequest.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/CompletedClassEventRequest;", "", "()V", "RequestBodyData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CompletedClassEventRequest {
    public static final int $stable = 0;

    /* compiled from: CompletedClassEventRequest.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/CompletedClassEventRequest$RequestBodyData;", "", "actualTimeInSec", "", "durationTimeInSec", "elapsedTimeInSec", "(III)V", "getActualTimeInSec", "()I", "getDurationTimeInSec", "getElapsedTimeInSec", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 0;

        @SerializedName("actual_time_in_sec")
        private final int actualTimeInSec;

        @SerializedName("duration_time_in_sec")
        private final int durationTimeInSec;

        @SerializedName("elapsed_time_in_sec")
        private final int elapsedTimeInSec;

        public RequestBodyData(int i, int i2, int i3) {
            this.actualTimeInSec = i;
            this.durationTimeInSec = i2;
            this.elapsedTimeInSec = i3;
        }

        public final int getActualTimeInSec() {
            return this.actualTimeInSec;
        }

        public final int getDurationTimeInSec() {
            return this.durationTimeInSec;
        }

        public final int getElapsedTimeInSec() {
            return this.elapsedTimeInSec;
        }
    }
}
