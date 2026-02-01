package com.ua.sdk.sleep;

import android.os.Parcelable;
import com.ua.sdk.Entity;
import com.ua.sdk.EntityRef;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public interface SleepMetric extends Entity<EntityRef<SleepMetric>> {
    public static final int AWAKE = 1;
    public static final int DEEP = 3;
    public static final int LIGHT = 2;

    public interface Aggregates extends Parcelable {
        int getTimeToSleep();

        int getTimesAwakened();

        int getTotalDeepSleep();

        int getTotalLightSleep();

        int getTotalSleep();

        int getTotalTimeAwake();
    }

    public interface TimeSeries extends Parcelable {
        long getEpoch(int i) throws IndexOutOfBoundsException;

        State getState(int i) throws IndexOutOfBoundsException;

        int size();
    }

    Aggregates getAggregates();

    Date getCreatedDateTime();

    Date getEndDateTime();

    String getRecorderTypeKey();

    @Override // com.ua.sdk.Entity, com.ua.sdk.Resource
    SleepRef getRef();

    String getReferenceKey();

    Date getStartDateTime();

    TimeZone getStartTimeZone();

    TimeSeries getTimeSeries();

    Date getUpdatedDateTime();

    public enum State {
        AWAKE(1),
        LIGHT_SLEEP(2),
        DEEP_SLEEP(3);

        public final int value;

        State(int i) {
            this.value = i;
        }

        public static final State getState(int i) {
            State state = AWAKE;
            if (i == state.value) {
                return state;
            }
            State state2 = LIGHT_SLEEP;
            if (i == state2.value) {
                return state2;
            }
            State state3 = DEEP_SLEEP;
            if (i == state3.value) {
                return state3;
            }
            return null;
        }
    }
}
