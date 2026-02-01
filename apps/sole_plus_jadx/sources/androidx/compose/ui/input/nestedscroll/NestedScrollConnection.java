package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: NestedScrollModifier.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface NestedScrollConnection {
    /* renamed from: onPostFling-RZ2iAVY */
    default Object mo786onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        return m5696onPostFlingRZ2iAVY$suspendImpl(this, j, j2, continuation);
    }

    /* renamed from: onPreFling-QWom1Mo */
    default Object mo1060onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        return m5697onPreFlingQWom1Mo$suspendImpl(this, j, continuation);
    }

    /* compiled from: NestedScrollModifier.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public static long m5701onPreScrollOzD1aCk(NestedScrollConnection nestedScrollConnection, long j, int i) {
            return NestedScrollConnection.super.mo1061onPreScrollOzD1aCk(j, i);
        }

        @Deprecated
        /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public static long m5699onPostScrollDzOQY0M(NestedScrollConnection nestedScrollConnection, long j, long j2, int i) {
            return NestedScrollConnection.super.mo787onPostScrollDzOQY0M(j, j2, i);
        }

        @Deprecated
        /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public static Object m5700onPreFlingQWom1Mo(NestedScrollConnection nestedScrollConnection, long j, Continuation<? super Velocity> continuation) {
            return NestedScrollConnection.super.mo1060onPreFlingQWom1Mo(j, continuation);
        }

        @Deprecated
        /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public static Object m5698onPostFlingRZ2iAVY(NestedScrollConnection nestedScrollConnection, long j, long j2, Continuation<? super Velocity> continuation) {
            return NestedScrollConnection.super.mo786onPostFlingRZ2iAVY(j, j2, continuation);
        }
    }

    /* renamed from: onPreScroll-OzD1aCk */
    default long mo1061onPreScrollOzD1aCk(long available, int source) {
        return Offset.INSTANCE.m4310getZeroF1C5BW0();
    }

    /* renamed from: onPostScroll-DzOQY0M */
    default long mo787onPostScrollDzOQY0M(long consumed, long available, int source) {
        return Offset.INSTANCE.m4310getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m5697onPreFlingQWom1Mo$suspendImpl(NestedScrollConnection nestedScrollConnection, long j, Continuation<? super Velocity> continuation) {
        return Velocity.m7484boximpl(Velocity.INSTANCE.m7504getZero9UxMQ8M());
    }

    /* renamed from: onPostFling-RZ2iAVY$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m5696onPostFlingRZ2iAVY$suspendImpl(NestedScrollConnection nestedScrollConnection, long j, long j2, Continuation<? super Velocity> continuation) {
        return Velocity.m7484boximpl(Velocity.INSTANCE.m7504getZero9UxMQ8M());
    }
}
