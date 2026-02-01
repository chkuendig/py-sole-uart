package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: ViewLayerContainer.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0004¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/ViewLayerContainer;", "Landroidx/compose/ui/platform/DrawChildContainer;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", SdkConstants.CONSTRUCTOR_NAME, "(Landroid/content/Context;)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "dispatchGetDisplayList", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewLayerContainer extends DrawChildContainer {
    public static final int $stable = 8;

    @Override // androidx.compose.ui.platform.DrawChildContainer, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    protected final void dispatchGetDisplayList() {
    }

    public ViewLayerContainer(Context context) {
        super(context);
    }
}
