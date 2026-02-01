package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: ImageBitmap.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJL\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0014H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmap;", "", "width", "", "getWidth", "()I", "height", "getHeight", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "hasAlpha", "", "getHasAlpha", "()Z", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getConfig-_sVssgQ", "readPixels", "", "buffer", "", SdkConstants.ATTR_START_X, SdkConstants.ATTR_START_Y, "bufferOffset", "stride", "prepareToDraw", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ImageBitmap {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    ColorSpace getColorSpace();

    /* renamed from: getConfig-_sVssgQ */
    int mo4403getConfig_sVssgQ();

    boolean getHasAlpha();

    int getHeight();

    int getWidth();

    void prepareToDraw();

    void readPixels(int[] buffer, int startX, int startY, int width, int height, int bufferOffset, int stride);

    /* compiled from: ImageBitmap.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void readPixels$default(ImageBitmap imageBitmap, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readPixels");
        }
        int i8 = (i7 & 2) != 0 ? 0 : i;
        int i9 = (i7 & 4) != 0 ? 0 : i2;
        int width = (i7 & 8) != 0 ? imageBitmap.getWidth() : i3;
        imageBitmap.readPixels(iArr, i8, i9, width, (i7 & 16) != 0 ? imageBitmap.getHeight() : i4, (i7 & 32) == 0 ? i5 : 0, (i7 & 64) != 0 ? width : i6);
    }

    /* compiled from: ImageBitmap.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmap$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
