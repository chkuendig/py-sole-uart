package com.soletreadmills.sole_v2.ui._base;

import kotlin.Metadata;

/* compiled from: BaseNavView.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a}\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"BaseNavView", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", "leftButtonIcon", "", "leftButtonText", "rightButtonIcon", "rightButtonText", "showBottomLine", "", "onLeftClick", "Lkotlin/Function0;", "onRightClick", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BaseNavViewKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x076d  */
    /* JADX WARN: Removed duplicated region for block: B:245:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BaseNavView(androidx.compose.ui.Modifier r40, final java.lang.String r41, java.lang.Integer r42, java.lang.String r43, java.lang.Integer r44, java.lang.String r45, boolean r46, kotlin.jvm.functions.Function0<kotlin.Unit> r47, kotlin.jvm.functions.Function0<kotlin.Unit> r48, androidx.compose.runtime.Composer r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 1919
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui._base.BaseNavViewKt.BaseNavView(androidx.compose.ui.Modifier, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
