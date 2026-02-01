package no.nordicsemi.android.ble.livedata.state;

/* loaded from: classes6.dex */
public class BondState {
    protected final State state;

    public enum State {
        NOT_BONDED,
        BONDING,
        BONDED
    }

    public static final class NotBonded extends BondState {
        public static final NotBonded INSTANCE = new NotBonded();

        private NotBonded() {
            super(State.NOT_BONDED);
        }
    }

    public static final class Bonding extends BondState {
        public static final Bonding INSTANCE = new Bonding();

        private Bonding() {
            super(State.BONDING);
        }
    }

    public static final class Bonded extends BondState {
        public static final Bonded INSTANCE = new Bonded();

        private Bonded() {
            super(State.BONDED);
        }
    }

    private BondState(State state) {
        this.state = state;
    }

    public final State getState() {
        return this.state;
    }

    public final boolean isBonded() {
        return this.state == State.BONDED;
    }
}
