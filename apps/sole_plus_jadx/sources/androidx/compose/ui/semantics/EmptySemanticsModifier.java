package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: SemanticsModifier.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", SdkConstants.CONSTRUCTOR_NAME, "()V", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EmptySemanticsModifier extends Modifier.Node implements SemanticsModifierNode {
    public static final int $stable = 8;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }
}
