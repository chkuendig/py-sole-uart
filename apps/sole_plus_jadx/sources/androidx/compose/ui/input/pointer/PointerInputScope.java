package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: SuspendingPointerInputFilter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J=\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172'\u0010\u0018\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\b\u001dH¦@¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8V@VX\u0097\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "_", "", "interceptOutOfBoundsChildEvents", "getInterceptOutOfBoundsChildEvents$annotations", "()V", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "awaitPointerEventScope", "R", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PointerInputScope extends Density {
    <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation);

    default boolean getInterceptOutOfBoundsChildEvents() {
        return false;
    }

    /* renamed from: getSize-YbymL2g */
    long mo669getSizeYbymL2g();

    ViewConfiguration getViewConfiguration();

    default void setInterceptOutOfBoundsChildEvents(boolean z) {
    }

    /* compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getInterceptOutOfBoundsChildEvents$annotations() {
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5867roundToPxR2X_6o(PointerInputScope pointerInputScope, long j) {
            return PointerInputScope.super.mo670roundToPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5868roundToPx0680j_4(PointerInputScope pointerInputScope, float f) {
            return PointerInputScope.super.mo671roundToPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5869toDpGaN1DYA(PointerInputScope pointerInputScope, long j) {
            return PointerInputScope.super.mo672toDpGaN1DYA(j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5870toDpu2uoSUM(PointerInputScope pointerInputScope, float f) {
            return PointerInputScope.super.mo673toDpu2uoSUM(f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5871toDpu2uoSUM(PointerInputScope pointerInputScope, int i) {
            return PointerInputScope.super.mo674toDpu2uoSUM(i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5872toDpSizekrfVVM(PointerInputScope pointerInputScope, long j) {
            return PointerInputScope.super.mo675toDpSizekrfVVM(j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5873toPxR2X_6o(PointerInputScope pointerInputScope, long j) {
            return PointerInputScope.super.mo676toPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5874toPx0680j_4(PointerInputScope pointerInputScope, float f) {
            return PointerInputScope.super.mo677toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(PointerInputScope pointerInputScope, DpRect dpRect) {
            return PointerInputScope.super.toRect(dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5875toSizeXkaWNTQ(PointerInputScope pointerInputScope, long j) {
            return PointerInputScope.super.mo678toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5876toSp0xMU5do(PointerInputScope pointerInputScope, float f) {
            return PointerInputScope.super.mo679toSp0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5877toSpkPz2Gy4(PointerInputScope pointerInputScope, float f) {
            return PointerInputScope.super.mo680toSpkPz2Gy4(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5878toSpkPz2Gy4(PointerInputScope pointerInputScope, int i) {
            return PointerInputScope.super.mo681toSpkPz2Gy4(i);
        }

        @Deprecated
        /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m5866getExtendedTouchPaddingNHjbRc(PointerInputScope pointerInputScope) {
            return PointerInputScope.super.mo668getExtendedTouchPaddingNHjbRc();
        }

        @Deprecated
        public static boolean getInterceptOutOfBoundsChildEvents(PointerInputScope pointerInputScope) {
            return PointerInputScope.super.getInterceptOutOfBoundsChildEvents();
        }

        @Deprecated
        public static void setInterceptOutOfBoundsChildEvents(PointerInputScope pointerInputScope, boolean z) {
            PointerInputScope.super.setInterceptOutOfBoundsChildEvents(z);
        }
    }

    /* renamed from: getExtendedTouchPadding-NH-jbRc */
    default long mo668getExtendedTouchPaddingNHjbRc() {
        return Size.INSTANCE.m4372getZeroNHjbRc();
    }
}
