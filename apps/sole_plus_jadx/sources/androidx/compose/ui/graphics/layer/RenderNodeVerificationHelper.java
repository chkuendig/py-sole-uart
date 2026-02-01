package androidx.compose.ui.graphics.layer;

import android.graphics.RenderNode;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: GraphicsLayerV29.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/layer/RenderNodeVerificationHelper;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "setRenderEffect", "", "renderNode", "Landroid/graphics/RenderNode;", TypedValues.AttributesType.S_TARGET, "Landroidx/compose/ui/graphics/RenderEffect;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RenderNodeVerificationHelper {
    public static final RenderNodeVerificationHelper INSTANCE = new RenderNodeVerificationHelper();

    private RenderNodeVerificationHelper() {
    }

    public final void setRenderEffect(RenderNode renderNode, RenderEffect target) {
        renderNode.setRenderEffect(target != null ? target.asAndroidRenderEffect() : null);
    }
}
