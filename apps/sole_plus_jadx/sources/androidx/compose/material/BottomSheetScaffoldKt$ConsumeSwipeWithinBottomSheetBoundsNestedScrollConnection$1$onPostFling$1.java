package androidx.compose.material;

import androidx.compose.material.BottomSheetScaffoldKt;
import com.sun.jna.platform.win32.WinError;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BottomSheetScaffold.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", f = "BottomSheetScaffold.kt", i = {0}, l = {WinError.ERROR_LOST_WRITEBEHIND_DATA_LOCAL_DISK_ERROR}, m = "onPostFling-RZ2iAVY", n = {"available"}, s = {"J$0"})
/* loaded from: classes.dex */
final class BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BottomSheetScaffoldKt.C05061 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(BottomSheetScaffoldKt.C05061 c05061, Continuation<? super BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = c05061;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo786onPostFlingRZ2iAVY(0L, 0L, this);
    }
}
