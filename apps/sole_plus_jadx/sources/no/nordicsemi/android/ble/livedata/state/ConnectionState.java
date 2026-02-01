package no.nordicsemi.android.ble.livedata.state;

/* loaded from: classes6.dex */
public class ConnectionState {
    protected final State state;

    public enum State {
        CONNECTING,
        INITIALIZING,
        READY,
        DISCONNECTING,
        DISCONNECTED
    }

    public static final class Connecting extends ConnectionState {
        public static final Connecting INSTANCE = new Connecting();

        private Connecting() {
            super(State.CONNECTING);
        }
    }

    public static final class Initializing extends ConnectionState {
        public static final Initializing INSTANCE = new Initializing();

        private Initializing() {
            super(State.INITIALIZING);
        }
    }

    public static final class Ready extends ConnectionState {
        public static final Ready INSTANCE = new Ready();

        private Ready() {
            super(State.READY);
        }
    }

    public static final class Disconnecting extends ConnectionState {
        public static final Disconnecting INSTANCE = new Disconnecting();

        private Disconnecting() {
            super(State.DISCONNECTING);
        }
    }

    public static final class Disconnected extends ConnectionState {
        private final int reason;

        public Disconnected(int i) {
            super(State.DISCONNECTED);
            this.reason = i;
        }

        public int getReason() {
            return this.reason;
        }
    }

    private ConnectionState(State state) {
        this.state = state;
    }

    public final State getState() {
        return this.state;
    }

    public final boolean isConnected() {
        return this.state == State.INITIALIZING || this.state == State.READY;
    }

    public final boolean isReady() {
        return this.state == State.READY;
    }
}
