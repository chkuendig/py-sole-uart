package com.soletreadmills.sole_v2._manager;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LogoutManager.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/AuthState;", "", "()V", "Authenticated", "Unauthenticated", "Lcom/soletreadmills/sole_v2/_manager/AuthState$Authenticated;", "Lcom/soletreadmills/sole_v2/_manager/AuthState$Unauthenticated;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AuthState {
    public static final int $stable = 0;

    public /* synthetic */ AuthState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: LogoutManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/AuthState$Authenticated;", "Lcom/soletreadmills/sole_v2/_manager/AuthState;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Authenticated extends AuthState {
        public static final int $stable = 0;
        public static final Authenticated INSTANCE = new Authenticated();

        private Authenticated() {
            super(null);
        }
    }

    private AuthState() {
    }

    /* compiled from: LogoutManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/AuthState$Unauthenticated;", "Lcom/soletreadmills/sole_v2/_manager/AuthState;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Unauthenticated extends AuthState {
        public static final int $stable = 0;
        public static final Unauthenticated INSTANCE = new Unauthenticated();

        private Unauthenticated() {
            super(null);
        }
    }
}
