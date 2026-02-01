package androidx.compose.material;

import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: AndroidAlertDialog.android.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aª\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", SdkConstants.TAG_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:108:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    /* renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1717AlertDialog6oU6zVQ(final kotlin.jvm.functions.Function0<kotlin.Unit> r31, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.ui.Modifier r33, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.graphics.Shape r37, long r38, long r40, androidx.compose.ui.window.DialogProperties r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidAlertDialog_androidKt.m1717AlertDialog6oU6zVQ(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.ui.window.DialogProperties, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0101  */
    /* renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1718AlertDialogwqdebIU(final kotlin.jvm.functions.Function0<kotlin.Unit> r19, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.ui.graphics.Shape r24, long r25, long r27, androidx.compose.ui.window.DialogProperties r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 575
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidAlertDialog_androidKt.m1718AlertDialogwqdebIU(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.ui.window.DialogProperties, androidx.compose.runtime.Composer, int, int):void");
    }
}
