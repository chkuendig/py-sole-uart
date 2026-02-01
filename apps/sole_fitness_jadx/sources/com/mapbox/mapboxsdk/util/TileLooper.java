package com.mapbox.mapboxsdk.util;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import com.mapbox.mapboxsdk.tileprovider.MapTile;
import com.mapbox.mapboxsdk.views.util.Projection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public abstract class TileLooper {
    protected final Point mUpperLeft = new Point();
    protected final Point mLowerRight = new Point();
    protected final Point center = new Point();
    protected List<CacheableBitmapDrawable> mBeingUsedDrawables = new ArrayList();

    public abstract void handleTile(Canvas canvas, String str, int i, MapTile mapTile, int i2, int i3, Rect rect);

    public abstract void initializeLoop(float f, int i);

    public final void loop(Canvas canvas, String str, float f, int i, Rect rect, Rect rect2) {
        Projection.pixelXYToTileXY(rect.left, rect.top, this.mUpperLeft);
        this.mUpperLeft.offset(-1, -1);
        Projection.pixelXYToTileXY(rect.right, rect.bottom, this.mLowerRight);
        this.mLowerRight.offset(1, 1);
        this.center.set((this.mUpperLeft.x + this.mLowerRight.x) / 2, (this.mUpperLeft.y + this.mLowerRight.y) / 2);
        int iFloor = (int) Math.floor(f);
        int i2 = 1 << iFloor;
        initializeLoop(f, i);
        for (int i3 = this.mUpperLeft.y; i3 <= this.mLowerRight.y; i3++) {
            for (int i4 = this.mUpperLeft.x; i4 <= this.mLowerRight.x; i4++) {
                handleTile(canvas, str, i, new MapTile(str, iFloor, GeometryMath.mod(i4, i2), GeometryMath.mod(i3, i2)), i4, i3, rect2);
            }
        }
        finalizeLoop();
    }

    public void finalizeLoop() {
        new Handler().postDelayed(new Runnable() { // from class: com.mapbox.mapboxsdk.util.TileLooper.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator<CacheableBitmapDrawable> it = TileLooper.this.mBeingUsedDrawables.iterator();
                while (it.hasNext()) {
                    it.next().setBeingUsed(false);
                }
                TileLooper.this.mBeingUsedDrawables.clear();
            }
        }, 1L);
    }
}
