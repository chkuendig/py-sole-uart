package androidx.compose.runtime.snapshots;

import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Snapshot.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BO\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0002R\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", SdkConstants.ATTR_PARENT, SdkConstants.CONSTRUCTOR_NAME, "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "deactivated", "", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "dispose", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "deactivate", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedMutableSnapshot extends MutableSnapshot {
    public static final int $stable = 8;
    private boolean deactivated;
    private final MutableSnapshot parent;

    public final MutableSnapshot getParent() {
        return this.parent;
    }

    public NestedMutableSnapshot(long j, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12, MutableSnapshot mutableSnapshot) {
        super(j, snapshotIdSet, function1, function12);
        this.parent = mutableSnapshot;
        mutableSnapshot.mo3993nestedActivated$runtime(this);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this.parent.getRoot();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        super.dispose();
        deactivate();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0073 A[Catch: all -> 0x00de, TryCatch #0 {, blocks: (B:13:0x0038, B:15:0x0040, B:18:0x0047, B:22:0x0063, B:24:0x006b, B:28:0x0081, B:30:0x008d, B:31:0x0092, B:26:0x0073, B:27:0x007c), top: B:40:0x0038 }] */
    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            r11 = this;
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r11.parent
            boolean r0 = r0.getApplied()
            if (r0 != 0) goto Le1
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r11.parent
            boolean r0 = r0.getDisposed()
            if (r0 == 0) goto L12
            goto Le1
        L12:
            androidx.collection.MutableScatterSet r0 = r11.getModified$runtime()
            long r7 = r11.getSnapshotId()
            r9 = 0
            if (r0 == 0) goto L32
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent
            long r1 = r1.getSnapshotId()
            r3 = r11
            androidx.compose.runtime.snapshots.MutableSnapshot r3 = (androidx.compose.runtime.snapshots.MutableSnapshot) r3
            androidx.compose.runtime.snapshots.MutableSnapshot r4 = r11.parent
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = r4.getInvalid()
            java.util.Map r1 = androidx.compose.runtime.snapshots.SnapshotKt.access$optimisticMerges(r1, r3, r4)
            r5 = r1
            goto L33
        L32:
            r5 = r9
        L33:
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r10)
            r1 = r11
            androidx.compose.runtime.snapshots.Snapshot r1 = (androidx.compose.runtime.snapshots.Snapshot) r1     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.SnapshotKt.access$validateOpen(r1)     // Catch: java.lang.Throwable -> Lde
            if (r0 == 0) goto L7c
            int r1 = r0.get_size()     // Catch: java.lang.Throwable -> Lde
            if (r1 != 0) goto L47
            goto L7c
        L47:
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent     // Catch: java.lang.Throwable -> Lde
            long r2 = r1.getSnapshotId()     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r1.getInvalid()     // Catch: java.lang.Throwable -> Lde
            r1 = r11
            r4 = r0
            androidx.compose.runtime.snapshots.SnapshotApplyResult r1 = r1.innerApplyLocked$runtime(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r2 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE     // Catch: java.lang.Throwable -> Lde
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)     // Catch: java.lang.Throwable -> Lde
            if (r2 != 0) goto L63
            monitor-exit(r10)
            return r1
        L63:
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent     // Catch: java.lang.Throwable -> Lde
            androidx.collection.MutableScatterSet r1 = r1.getModified$runtime()     // Catch: java.lang.Throwable -> Lde
            if (r1 == 0) goto L73
            r2 = r0
            androidx.collection.ScatterSet r2 = (androidx.collection.ScatterSet) r2     // Catch: java.lang.Throwable -> Lde
            r1.addAll(r2)     // Catch: java.lang.Throwable -> Lde
            if (r1 != 0) goto L81
        L73:
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent     // Catch: java.lang.Throwable -> Lde
            r1.setModified$runtime(r0)     // Catch: java.lang.Throwable -> Lde
            r11.setModified$runtime(r9)     // Catch: java.lang.Throwable -> Lde
            goto L81
        L7c:
            r11.closeAndReleasePinning$runtime()     // Catch: java.lang.Throwable -> Lde
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lde
        L81:
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent     // Catch: java.lang.Throwable -> Lde
            long r1 = r1.getSnapshotId()     // Catch: java.lang.Throwable -> Lde
            int r1 = kotlin.jvm.internal.Intrinsics.compare(r1, r7)     // Catch: java.lang.Throwable -> Lde
            if (r1 >= 0) goto L92
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent     // Catch: java.lang.Throwable -> Lde
            r1.advance$runtime()     // Catch: java.lang.Throwable -> Lde
        L92:
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r1.getInvalid()     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.clear(r7)     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r11.getPreviousIds()     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.andNot(r3)     // Catch: java.lang.Throwable -> Lde
            r1.setInvalid$runtime(r2)     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent     // Catch: java.lang.Throwable -> Lde
            r1.recordPrevious$runtime(r7)     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent     // Catch: java.lang.Throwable -> Lde
            int r2 = r11.takeoverPinnedSnapshot$runtime()     // Catch: java.lang.Throwable -> Lde
            r1.recordPreviousPinnedSnapshot$runtime(r2)     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r11.getPreviousIds()     // Catch: java.lang.Throwable -> Lde
            r1.recordPreviousList$runtime(r2)     // Catch: java.lang.Throwable -> Lde
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r11.parent     // Catch: java.lang.Throwable -> Lde
            int[] r2 = r11.getPreviousPinnedSnapshots()     // Catch: java.lang.Throwable -> Lde
            r1.recordPreviousPinnedSnapshots$runtime(r2)     // Catch: java.lang.Throwable -> Lde
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lde
            monitor-exit(r10)
            r1 = 1
            r11.setApplied$runtime(r1)
            r11.deactivate()
            r1 = r11
            androidx.compose.runtime.snapshots.Snapshot r1 = (androidx.compose.runtime.snapshots.Snapshot) r1
            androidx.collection.ScatterSet r0 = (androidx.collection.ScatterSet) r0
            androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt.dispatchObserverOnApplied(r1, r0)
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r0 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            androidx.compose.runtime.snapshots.SnapshotApplyResult r0 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r0
            return r0
        Lde:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        Le1:
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure r0 = new androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure
            r1 = r11
            androidx.compose.runtime.snapshots.Snapshot r1 = (androidx.compose.runtime.snapshots.Snapshot) r1
            r0.<init>(r1)
            androidx.compose.runtime.snapshots.SnapshotApplyResult r0 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.NestedMutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    private final void deactivate() {
        if (this.deactivated) {
            return;
        }
        this.deactivated = true;
        this.parent.mo3994nestedDeactivated$runtime(this);
    }
}
