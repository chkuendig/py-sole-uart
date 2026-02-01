package no.nordicsemi.android.ble.ktx;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressIndicaton.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lno/nordicsemi/android/ble/ktx/ProgressIndication;", "", "index", "", "data", "", "(I[B)V", "getData", "()[B", "getIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class ProgressIndication {
    private final byte[] data;
    private final int index;

    public static /* synthetic */ ProgressIndication copy$default(ProgressIndication progressIndication, int i, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = progressIndication.index;
        }
        if ((i2 & 2) != 0) {
            bArr = progressIndication.data;
        }
        return progressIndication.copy(i, bArr);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    public final ProgressIndication copy(int index, byte[] data) {
        return new ProgressIndication(index, data);
    }

    public String toString() {
        return "ProgressIndication(index=" + this.index + ", data=" + Arrays.toString(this.data) + ")";
    }

    public ProgressIndication(int i, byte[] bArr) {
        this.index = i;
        this.data = bArr;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type no.nordicsemi.android.ble.ktx.ProgressIndication");
        ProgressIndication progressIndication = (ProgressIndication) other;
        if (this.index != progressIndication.index) {
            return false;
        }
        byte[] bArr = this.data;
        if (bArr != null) {
            byte[] bArr2 = progressIndication.data;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (progressIndication.data != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.index * 31;
        byte[] bArr = this.data;
        return i + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }
}
