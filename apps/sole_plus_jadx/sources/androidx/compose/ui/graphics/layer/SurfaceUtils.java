package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.view.Surface;
import com.android.SdkConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayerSnapshot.android.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0006\u0010\f\u001a\u00020\u0007J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0003J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/layer/SurfaceUtils;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "lockHardwareCanvasMethod", "Ljava/lang/reflect/Method;", "hasRetrievedMethod", "", "lockCanvas", "Landroid/graphics/Canvas;", "surface", "Landroid/view/Surface;", "isLockHardwareCanvasAvailable", "resolveLockHardwareCanvasMethod", "lockCanvasFallback", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SurfaceUtils {
    public static final SurfaceUtils INSTANCE = new SurfaceUtils();
    private static boolean hasRetrievedMethod;
    private static Method lockHardwareCanvasMethod;

    public final boolean isLockHardwareCanvasAvailable() {
        return true;
    }

    private SurfaceUtils() {
    }

    public final Canvas lockCanvas(Surface surface) {
        return SurfaceVerificationHelper.INSTANCE.lockHardwareCanvas(surface);
    }

    private final Method resolveLockHardwareCanvasMethod() {
        Method method;
        synchronized (this) {
            try {
                method = lockHardwareCanvasMethod;
                if (!hasRetrievedMethod) {
                    hasRetrievedMethod = true;
                    Method declaredMethod = Surface.class.getDeclaredMethod("lockHardwareCanvas", new Class[0]);
                    declaredMethod.setAccessible(true);
                    lockHardwareCanvasMethod = declaredMethod;
                    method = declaredMethod;
                }
            } finally {
                method = null;
                return method;
            }
        }
        return method;
    }

    private final Canvas lockCanvasFallback(Surface surface) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method methodResolveLockHardwareCanvasMethod = resolveLockHardwareCanvasMethod();
        if (methodResolveLockHardwareCanvasMethod != null) {
            Object objInvoke = methodResolveLockHardwareCanvasMethod.invoke(surface, new Object[0]);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.graphics.Canvas");
            return (Canvas) objInvoke;
        }
        return surface.lockCanvas(null);
    }
}
