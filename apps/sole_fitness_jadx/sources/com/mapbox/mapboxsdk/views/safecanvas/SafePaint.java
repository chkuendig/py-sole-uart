package com.mapbox.mapboxsdk.views.safecanvas;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;

/* loaded from: classes2.dex */
public class SafePaint extends Paint {
    @Override // android.graphics.Paint
    public PathEffect setPathEffect(PathEffect pathEffect) {
        if (pathEffect instanceof DashPathEffect) {
            throw new RuntimeException("Do not use DashPathEffect. Use SafeDashPathEffect instead.");
        }
        return super.setPathEffect(pathEffect);
    }
}
