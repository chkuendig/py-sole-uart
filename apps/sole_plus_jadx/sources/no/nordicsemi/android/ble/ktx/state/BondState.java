package no.nordicsemi.android.ble.ktx.state;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BondState.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/BondState;", "", "()V", "isBonded", "", "()Z", "Bonded", "Bonding", "NotBonded", "Lno/nordicsemi/android/ble/ktx/state/BondState$Bonded;", "Lno/nordicsemi/android/ble/ktx/state/BondState$Bonding;", "Lno/nordicsemi/android/ble/ktx/state/BondState$NotBonded;", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class BondState {
    public /* synthetic */ BondState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BondState() {
    }

    /* compiled from: BondState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/BondState$NotBonded;", "Lno/nordicsemi/android/ble/ktx/state/BondState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NotBonded extends BondState {
        public static final NotBonded INSTANCE = new NotBonded();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotBonded)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 396496545;
        }

        public String toString() {
            return "NotBonded";
        }

        private NotBonded() {
            super(null);
        }
    }

    /* compiled from: BondState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/BondState$Bonding;", "Lno/nordicsemi/android/ble/ktx/state/BondState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Bonding extends BondState {
        public static final Bonding INSTANCE = new Bonding();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Bonding)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1506714763;
        }

        public String toString() {
            return "Bonding";
        }

        private Bonding() {
            super(null);
        }
    }

    /* compiled from: BondState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lno/nordicsemi/android/ble/ktx/state/BondState$Bonded;", "Lno/nordicsemi/android/ble/ktx/state/BondState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Bonded extends BondState {
        public static final Bonded INSTANCE = new Bonded();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Bonded)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1434076886;
        }

        public String toString() {
            return "Bonded";
        }

        private Bonded() {
            super(null);
        }
    }

    public final boolean isBonded() {
        return this instanceof Bonded;
    }
}
