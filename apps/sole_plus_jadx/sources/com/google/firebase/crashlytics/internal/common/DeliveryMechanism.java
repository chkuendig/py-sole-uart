package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes5.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* renamed from: id, reason: collision with root package name */
    private final int f185id;

    DeliveryMechanism(int i) {
        this.f185id = i;
    }

    public int getId() {
        return this.f185id;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f185id);
    }

    public static DeliveryMechanism determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }
}
