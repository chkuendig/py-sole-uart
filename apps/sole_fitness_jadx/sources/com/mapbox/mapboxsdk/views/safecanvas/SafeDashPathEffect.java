package com.mapbox.mapboxsdk.views.safecanvas;

import android.graphics.Path;
import android.graphics.PathDashPathEffect;

/* loaded from: classes2.dex */
public class SafeDashPathEffect extends PathDashPathEffect {
    public SafeDashPathEffect(float[] fArr, float f, float f2) {
        super(createSafeDashedPath(fArr, f, f2, null), floatSum(fArr), f, PathDashPathEffect.Style.MORPH);
    }

    public static Path createSafeDashedPath(float[] fArr, float f, float f2, Path path) {
        if (path == null) {
            path = new Path();
        }
        path.reset();
        path.moveTo(0.0f, 0.0f);
        for (int i = 0; i < fArr.length; i++) {
            if (i % 2 == 0) {
                float f3 = f2 / 2.0f;
                path.rMoveTo(0.0f, f3);
                path.rLineTo(fArr[i], 0.0f);
                path.rLineTo(0.0f, -f2);
                path.rLineTo(-fArr[i], 0.0f);
                path.rLineTo(0.0f, f3);
                path.rMoveTo(fArr[i], 0.0f);
            } else {
                path.rMoveTo(fArr[i], 0.0f);
            }
        }
        return path;
    }

    private static float floatSum(float[] fArr) {
        float f = 0.0f;
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }
}
