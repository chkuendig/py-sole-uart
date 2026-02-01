package com.dyaco.sole.custom;

/* loaded from: classes.dex */
public class Event {
    public static final int EVENT_CONNECTED = 1;
    public static final int EVENT_GARMIN_ERROR = 2;
    public static final int EVENT_UNKNOWN_USER_TOKEN = 0;

    public static class GarminEvent {
        private int eventode;

        public GarminEvent(int i) {
            this.eventode = i;
        }

        public int getEventode() {
            return this.eventode;
        }
    }
}
