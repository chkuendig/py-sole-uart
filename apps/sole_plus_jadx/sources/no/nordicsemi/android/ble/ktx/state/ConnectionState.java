package no.nordicsemi.android.ble.ktx.state;

import androidx.health.connect.client.records.metadata.DeviceTypes;
import com.google.zxing.client.android.Intents;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.ble.BleManager;

/* compiled from: ConnectionState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00072\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/ConnectionState;", "", "()V", "isConnected", "", "()Z", "isReady", "Companion", "Connecting", "Disconnected", "Disconnecting", "Initializing", "Ready", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Connecting;", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Disconnected;", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Disconnecting;", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Initializing;", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Ready;", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class ConnectionState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ ConnectionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ConnectionState() {
    }

    /* compiled from: ConnectionState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Connecting;", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Connecting extends ConnectionState {
        public static final Connecting INSTANCE = new Connecting();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Connecting)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 187301895;
        }

        public String toString() {
            return "Connecting";
        }

        private Connecting() {
            super(null);
        }
    }

    /* compiled from: ConnectionState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Initializing;", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Initializing extends ConnectionState {
        public static final Initializing INSTANCE = new Initializing();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Initializing)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1580314076;
        }

        public String toString() {
            return "Initializing";
        }

        private Initializing() {
            super(null);
        }
    }

    /* compiled from: ConnectionState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Ready;", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Ready extends ConnectionState {
        public static final Ready INSTANCE = new Ready();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ready)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -825589004;
        }

        public String toString() {
            return "Ready";
        }

        private Ready() {
            super(null);
        }
    }

    /* compiled from: ConnectionState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Disconnecting;", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Disconnecting extends ConnectionState {
        public static final Disconnecting INSTANCE = new Disconnecting();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Disconnecting)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1389294103;
        }

        public String toString() {
            return "Disconnecting";
        }

        private Disconnecting() {
            super(null);
        }
    }

    /* compiled from: ConnectionState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Disconnected;", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState;", "reason", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Disconnected$Reason;", "(Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Disconnected$Reason;)V", "isLinkLoss", "", "()Z", "isNotSupported", "isTimeout", "getReason", "()Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Disconnected$Reason;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Reason", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Disconnected extends ConnectionState {
        private final Reason reason;

        public static /* synthetic */ Disconnected copy$default(Disconnected disconnected, Reason reason, int i, Object obj) {
            if ((i & 1) != 0) {
                reason = disconnected.reason;
            }
            return disconnected.copy(reason);
        }

        /* renamed from: component1, reason: from getter */
        public final Reason getReason() {
            return this.reason;
        }

        public final Disconnected copy(Reason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Disconnected(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Disconnected) && this.reason == ((Disconnected) other).reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Disconnected(reason=" + this.reason + ")";
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: ConnectionState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Disconnected$Reason;", "", "(Ljava/lang/String;I)V", "SUCCESS", DeviceTypes.UNKNOWN, "TERMINATE_LOCAL_HOST", "TERMINATE_PEER_USER", "LINK_LOSS", "NOT_SUPPORTED", "CANCELLED", Intents.Scan.TIMEOUT, "Companion", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Reason {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Reason[] $VALUES;

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE;
            public static final Reason SUCCESS = new Reason("SUCCESS", 0);
            public static final Reason UNKNOWN = new Reason(DeviceTypes.UNKNOWN, 1);
            public static final Reason TERMINATE_LOCAL_HOST = new Reason("TERMINATE_LOCAL_HOST", 2);
            public static final Reason TERMINATE_PEER_USER = new Reason("TERMINATE_PEER_USER", 3);
            public static final Reason LINK_LOSS = new Reason("LINK_LOSS", 4);
            public static final Reason NOT_SUPPORTED = new Reason("NOT_SUPPORTED", 5);
            public static final Reason CANCELLED = new Reason("CANCELLED", 6);
            public static final Reason TIMEOUT = new Reason(Intents.Scan.TIMEOUT, 7);

            private static final /* synthetic */ Reason[] $values() {
                return new Reason[]{SUCCESS, UNKNOWN, TERMINATE_LOCAL_HOST, TERMINATE_PEER_USER, LINK_LOSS, NOT_SUPPORTED, CANCELLED, TIMEOUT};
            }

            public static EnumEntries<Reason> getEntries() {
                return $ENTRIES;
            }

            public static Reason valueOf(String str) {
                return (Reason) Enum.valueOf(Reason.class, str);
            }

            public static Reason[] values() {
                return (Reason[]) $VALUES.clone();
            }

            private Reason(String str, int i) {
            }

            static {
                Reason[] reasonArr$values = $values();
                $VALUES = reasonArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(reasonArr$values);
                INSTANCE = new Companion(null);
            }

            /* compiled from: ConnectionState.kt */
            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Disconnected$Reason$Companion;", "", "()V", "parse", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Disconnected$Reason;", "reason", "", "parse$ble_ktx_release", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Reason parse$ble_ktx_release(int reason) {
                    if (reason == 0) {
                        return Reason.SUCCESS;
                    }
                    if (reason == 1) {
                        return Reason.TERMINATE_LOCAL_HOST;
                    }
                    if (reason == 2) {
                        return Reason.TERMINATE_PEER_USER;
                    }
                    if (reason == 3) {
                        return Reason.LINK_LOSS;
                    }
                    if (reason == 4) {
                        return Reason.NOT_SUPPORTED;
                    }
                    if (reason == 5) {
                        return Reason.CANCELLED;
                    }
                    if (reason == 10) {
                        return Reason.TIMEOUT;
                    }
                    return Reason.UNKNOWN;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Disconnected(Reason reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final Reason getReason() {
            return this.reason;
        }

        public final boolean isLinkLoss() {
            return this.reason == Reason.LINK_LOSS;
        }

        public final boolean isNotSupported() {
            return this.reason == Reason.NOT_SUPPORTED;
        }

        public final boolean isTimeout() {
            return this.reason == Reason.TIMEOUT;
        }
    }

    public final boolean isConnected() {
        return (this instanceof Initializing) || (this instanceof Ready);
    }

    public final boolean isReady() {
        return this instanceof Ready;
    }

    /* compiled from: ConnectionState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/ConnectionState$Companion;", "", "()V", "of", "Lno/nordicsemi/android/ble/ktx/state/ConnectionState;", "manager", "Lno/nordicsemi/android/ble/BleManager;", "of$ble_ktx_release", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConnectionState of$ble_ktx_release(BleManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            int connectionState = manager.getConnectionState();
            if (connectionState == 1) {
                return Connecting.INSTANCE;
            }
            if (connectionState == 2) {
                return manager.isReady() ? Ready.INSTANCE : Initializing.INSTANCE;
            }
            if (connectionState == 3) {
                return Disconnecting.INSTANCE;
            }
            return new Disconnected(Disconnected.Reason.UNKNOWN);
        }
    }
}
