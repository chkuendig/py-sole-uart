package com.mapbox.mapboxsdk.overlay;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import com.dyaco.sole.R2;
import com.mapbox.mapboxsdk.tileprovider.MapTile;
import com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase;
import com.mapbox.mapboxsdk.util.GeometryMath;
import com.mapbox.mapboxsdk.util.TileLooper;
import com.mapbox.mapboxsdk.util.constants.UtilConstants;
import com.mapbox.mapboxsdk.views.MapView;
import com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas;
import com.mapbox.mapboxsdk.views.safecanvas.SafePaint;
import com.mapbox.mapboxsdk.views.util.Projection;
import java.util.HashMap;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public class TilesOverlay extends SafeDrawOverlay {
    private static final String TAG = "TilesOverlay";
    protected Paint mLoadingPaint;
    protected final MapTileLayerBase mTileProvider;
    private int mWorldSize_2;
    public static final int MENU_OFFLINE = getSafeMenuId();
    protected static SafePaint mDebugPaint = null;
    protected static SafePaint mLoadingTilePaint = null;
    protected static Bitmap mLoadingTileBitmap = null;
    private final Rect mTileRect = new Rect();
    private final Rect mViewPort = new Rect();
    private final Rect mClipRect = new Rect();
    float mCurrentZoomFactor = 1.0f;
    private float mRescaleZoomDiffMax = 4.0f;
    private boolean isAnimating = false;
    private boolean mOptionsMenuEnabled = true;
    private int mLoadingBackgroundColor = Color.rgb(R2.attr.curveFit, R2.attr.contentPaddingLeft, R2.attr.contentPaddingLeft);
    private int mLoadingLineColor = Color.rgb(200, R2.attr.constraintSet, R2.attr.constraintSet);
    private final TileLooper mTileLooper = new TileLooper() { // from class: com.mapbox.mapboxsdk.overlay.TilesOverlay.1
        @Override // com.mapbox.mapboxsdk.util.TileLooper
        public void initializeLoop(float f, int i) {
            if (((int) Math.floor(f)) != f) {
                TilesOverlay.this.mCurrentZoomFactor = (Projection.mapSize(f) / (1 << r0)) / i;
            } else {
                TilesOverlay.this.mCurrentZoomFactor = 1.0f;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.mapbox.mapboxsdk.util.TileLooper
        public void handleTile(Canvas canvas, String str, int i, MapTile mapTile, int i2, int i3, Rect rect) {
            double d = i * TilesOverlay.this.mCurrentZoomFactor;
            double d2 = (i2 * d) - TilesOverlay.this.mWorldSize_2;
            double d3 = (i3 * d) - TilesOverlay.this.mWorldSize_2;
            TilesOverlay.this.mTileRect.set((int) d2, (int) d3, (int) (d2 + d), (int) (d3 + d));
            if (Rect.intersects(TilesOverlay.this.mTileRect, rect)) {
                mapTile.setTileRect(TilesOverlay.this.mTileRect);
                Drawable mapTile2 = TilesOverlay.this.mTileProvider.getMapTile(mapTile, !TilesOverlay.this.isAnimating);
                boolean z = mapTile2 instanceof CacheableBitmapDrawable;
                if (mapTile2 != null) {
                    if (z) {
                        this.mBeingUsedDrawables.add((CacheableBitmapDrawable) mapTile2);
                    }
                    mapTile2.setBounds(TilesOverlay.this.mTileRect);
                    mapTile2.draw(canvas);
                } else {
                    Log.w(TilesOverlay.TAG, "tile should have been drawn to canvas, but it was null.  tile = '" + mapTile + "'");
                }
                if (UtilConstants.DEBUGMODE) {
                    ISafeCanvas iSafeCanvas = (ISafeCanvas) canvas;
                    iSafeCanvas.drawText(mapTile.toString(), TilesOverlay.this.mTileRect.left + 1, TilesOverlay.this.mTileRect.top + TilesOverlay.mDebugPaint.getTextSize(), TilesOverlay.mDebugPaint);
                    iSafeCanvas.drawRect(TilesOverlay.this.mTileRect, TilesOverlay.mDebugPaint);
                }
            }
        }
    };

    public TilesOverlay(MapTileLayerBase mapTileLayerBase) {
        this.mLoadingPaint = null;
        if (mapTileLayerBase == null) {
            throw new IllegalArgumentException("You must pass a valid tile provider to the tiles overlay.");
        }
        this.mTileProvider = mapTileLayerBase;
        if (UtilConstants.DEBUGMODE && mDebugPaint == null) {
            SafePaint safePaint = new SafePaint();
            mDebugPaint = safePaint;
            safePaint.setAntiAlias(true);
            mDebugPaint.setFilterBitmap(true);
            mDebugPaint.setColor(SupportMenu.CATEGORY_MASK);
            mDebugPaint.setStyle(Paint.Style.STROKE);
        }
        Paint paint = new Paint();
        this.mLoadingPaint = paint;
        paint.setAntiAlias(true);
        this.mLoadingPaint.setFilterBitmap(true);
        this.mLoadingPaint.setColor(this.mLoadingLineColor);
        this.mLoadingPaint.setStrokeWidth(0.0f);
    }

    @Override // com.mapbox.mapboxsdk.overlay.Overlay
    public void onDetach(MapView mapView) {
        this.mTileProvider.detach();
    }

    public float getMinimumZoomLevel() {
        return this.mTileProvider.getMinimumZoomLevel();
    }

    public float getMaximumZoomLevel() {
        return this.mTileProvider.getMaximumZoomLevel();
    }

    public boolean useDataConnection() {
        return this.mTileProvider.useDataConnection();
    }

    public void setUseDataConnection(boolean z) {
        this.mTileProvider.setUseDataConnection(z);
    }

    @Override // com.mapbox.mapboxsdk.overlay.SafeDrawOverlay
    protected void drawSafe(ISafeCanvas iSafeCanvas, MapView mapView, boolean z) {
        Log.d(TAG, "drawSafe() called with shadow = '" + z + "'");
        if (z) {
            return;
        }
        this.isAnimating = mapView.isAnimating();
        Projection projection = mapView.getProjection();
        iSafeCanvas.getClipBounds(this.mClipRect);
        Math.log(mapView.getScale());
        Math.log(2.0d);
        float zoomLevel = projection.getZoomLevel();
        this.mWorldSize_2 = projection.getHalfWorldSize();
        GeometryMath.viewPortRectForTileDrawing(projection, this.mViewPort);
        int tileSize = Projection.getTileSize();
        if (tileSize > 0) {
            Log.d(TAG, "drawSafe(), start drawing tiles!");
            drawLoadingTile(iSafeCanvas.getSafeCanvas(), mapView, zoomLevel, this.mClipRect);
            drawTiles(iSafeCanvas.getSafeCanvas(), zoomLevel, tileSize, this.mViewPort, this.mClipRect);
            Log.d(TAG, "drawSafe(), done drawing tiles!");
        } else {
            Log.d(TAG, "tileSize is not > 0, so not drawing tiles.");
        }
        if (!UtilConstants.DEBUGMODE || mapView.getScrollableAreaLimit() == null) {
            return;
        }
        SafePaint safePaint = new SafePaint();
        safePaint.setColor(-16776961);
        safePaint.setStyle(Paint.Style.STROKE);
        Rect rect = new Rect();
        mapView.getScrollableAreaLimit().round(rect);
        if (mapView.getScrollableAreaLimit() != null) {
            iSafeCanvas.drawRect(rect, safePaint);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drawLoadingTile(Canvas canvas, MapView mapView, float f, Rect rect) {
        ISafeCanvas iSafeCanvas = (ISafeCanvas) canvas;
        iSafeCanvas.save();
        iSafeCanvas.translate(-mapView.getScrollX(), -mapView.getScrollY());
        iSafeCanvas.drawPaint(getLoadingTilePaint());
        iSafeCanvas.restore();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drawTiles(Canvas canvas, float f, int i, Rect rect, Rect rect2) {
        Log.d(TAG, "drawTiles() start.");
        this.mTileLooper.loop(canvas, this.mTileProvider.getCacheKey(), f, i, rect, rect2);
        if (UtilConstants.DEBUGMODE) {
            ISafeCanvas iSafeCanvas = (ISafeCanvas) canvas;
            Point point = new Point(rect.centerX() - this.mWorldSize_2, rect.centerY() - this.mWorldSize_2);
            iSafeCanvas.drawLine(point.x, point.y - 9, point.x, point.y + 9, mDebugPaint);
            iSafeCanvas.drawLine(point.x - 9, point.y, point.x + 9, point.y, mDebugPaint);
        }
        Log.d(TAG, "drawTiles() done.");
    }

    public int getLoadingBackgroundColor() {
        return this.mLoadingBackgroundColor;
    }

    public void setLoadingBackgroundColor(int i) {
        if (this.mLoadingBackgroundColor != i) {
            this.mLoadingBackgroundColor = i;
            clearLoadingTile();
        }
    }

    public int getLoadingLineColor() {
        return this.mLoadingLineColor;
    }

    public void setLoadingLineColor(int i) {
        if (this.mLoadingLineColor != i) {
            this.mLoadingLineColor = i;
            this.mLoadingPaint.setColor(i);
            clearLoadingTile();
        }
    }

    private SafePaint getLoadingTilePaint() {
        if (mLoadingTilePaint == null && this.mLoadingBackgroundColor != 0) {
            try {
                int tileSizePixels = this.mTileProvider.getTileSource() != null ? this.mTileProvider.getTileSource().getTileSizePixels() : 256;
                mLoadingTileBitmap = Bitmap.createBitmap(tileSizePixels, tileSizePixels, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(mLoadingTileBitmap);
                canvas.drawColor(this.mLoadingBackgroundColor);
                int i = tileSizePixels / 16;
                for (int i2 = 0; i2 < tileSizePixels; i2 += i) {
                    float f = i2;
                    float f2 = tileSizePixels;
                    canvas.drawLine(0.0f, f, f2, f, this.mLoadingPaint);
                    canvas.drawLine(f, 0.0f, f, f2, this.mLoadingPaint);
                }
                SafePaint safePaint = new SafePaint();
                mLoadingTilePaint = safePaint;
                safePaint.setShader(new BitmapShader(mLoadingTileBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
            } catch (OutOfMemoryError unused) {
                Log.e(TAG, "OutOfMemoryError getting loading tile");
                System.gc();
            }
        }
        return mLoadingTilePaint;
    }

    private void clearLoadingTile() {
        Bitmap bitmap;
        mLoadingTilePaint = null;
        if (Build.VERSION.SDK_INT >= 9 || (bitmap = mLoadingTileBitmap) == null) {
            return;
        }
        bitmap.recycle();
        mLoadingTileBitmap = null;
    }

    public void rescaleCache(float f, float f2, Projection projection) {
        if (this.mTileProvider.hasNoSource() || Math.floor(f) == Math.floor(f2) || projection == null || Math.abs(f2 - f) > this.mRescaleZoomDiffMax) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (UtilConstants.DEBUGMODE) {
            Log.d(TAG, "rescale tile cache from " + f2 + " to " + f);
        }
        (f > f2 ? new ZoomInTileLooper(f2) : new ZoomOutTileLooper(f2)).loop(null, this.mTileProvider.getCacheKey(), f, Projection.getTileSize(), GeometryMath.viewPortRectForTileDrawing(f, projection, null), null);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (UtilConstants.DEBUGMODE) {
            Log.d(TAG, "Finished rescale in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms");
        }
    }

    private abstract class ScaleTileLooper extends TileLooper {
        protected Paint mDebugPaint;
        protected Rect mDestRect;
        protected float mDiff;
        protected final HashMap<MapTile, Bitmap> mNewTiles;
        protected final int mOldTileUpperBound;
        protected final float mOldZoomLevel;
        protected final int mOldZoomRound;
        protected Rect mSrcRect;
        protected int mTileSize_2;

        protected abstract void handleScaleTile(String str, int i, MapTile mapTile, int i2, int i3);

        public ScaleTileLooper(float f) {
            this.mOldZoomLevel = f;
            int iFloor = (int) Math.floor(f);
            this.mOldZoomRound = iFloor;
            this.mOldTileUpperBound = 1 << iFloor;
            this.mNewTiles = new HashMap<>();
            this.mSrcRect = new Rect();
            this.mDestRect = new Rect();
            this.mDebugPaint = new Paint();
        }

        @Override // com.mapbox.mapboxsdk.util.TileLooper
        public void initializeLoop(float f, int i) {
            float fAbs = (float) Math.abs(Math.floor(f) - Math.floor(this.mOldZoomLevel));
            this.mDiff = fAbs;
            this.mTileSize_2 = (int) GeometryMath.rightShift(i, fAbs);
        }

        @Override // com.mapbox.mapboxsdk.util.TileLooper
        public void handleTile(Canvas canvas, String str, int i, MapTile mapTile, int i2, int i3, Rect rect) {
            if (TilesOverlay.this.mTileProvider.getMapTile(mapTile, !TilesOverlay.this.isAnimating) == null) {
                try {
                    handleScaleTile(str, i, mapTile, i2, i3);
                } catch (OutOfMemoryError unused) {
                    Log.e(TilesOverlay.TAG, "OutOfMemoryError rescaling cache");
                }
            }
        }

        @Override // com.mapbox.mapboxsdk.util.TileLooper
        public void finalizeLoop() {
            super.finalizeLoop();
            while (!this.mNewTiles.isEmpty()) {
                MapTile next = this.mNewTiles.keySet().iterator().next();
                TilesOverlay.this.mTileProvider.putExpiredTileIntoCache(next, this.mNewTiles.remove(next));
            }
        }
    }

    private class ZoomInTileLooper extends ScaleTileLooper {
        public ZoomInTileLooper(float f) {
            super(f);
        }

        @Override // com.mapbox.mapboxsdk.overlay.TilesOverlay.ScaleTileLooper
        public void handleScaleTile(String str, int i, MapTile mapTile, int i2, int i3) {
            CacheableBitmapDrawable mapTileFromMemory = TilesOverlay.this.mTileProvider.getMapTileFromMemory(new MapTile(str, this.mOldZoomRound, GeometryMath.mod((int) GeometryMath.rightShift(i2, this.mDiff), this.mOldTileUpperBound), GeometryMath.mod((int) GeometryMath.rightShift(i3, this.mDiff), this.mOldTileUpperBound)));
            if (mapTileFromMemory instanceof BitmapDrawable) {
                if (mapTileFromMemory instanceof CacheableBitmapDrawable) {
                    mapTileFromMemory.setBeingUsed(true);
                    this.mBeingUsedDrawables.add(mapTileFromMemory);
                }
                Bitmap bitmap = mapTileFromMemory.getBitmap();
                if (bitmap != null) {
                    int iLeftShift = (i2 % ((int) GeometryMath.leftShift(1.0f, this.mDiff))) * this.mTileSize_2;
                    int iLeftShift2 = (i3 % ((int) GeometryMath.leftShift(1.0f, this.mDiff))) * this.mTileSize_2;
                    this.mSrcRect.set(iLeftShift, iLeftShift2, this.mTileSize_2 + iLeftShift, this.mTileSize_2 + iLeftShift2);
                    this.mDestRect.set(0, 0, i, i);
                    Bitmap bitmapFromRemoved = TilesOverlay.this.mTileProvider.getBitmapFromRemoved(i, i);
                    if (bitmapFromRemoved == null) {
                        bitmapFromRemoved = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
                    }
                    new Canvas(bitmapFromRemoved).drawBitmap(bitmap, this.mSrcRect, this.mDestRect, (Paint) null);
                    this.mNewTiles.put(mapTile, bitmapFromRemoved);
                    Log.d(TilesOverlay.TAG, "rescaled new tile : " + mapTile);
                }
            }
        }
    }

    private class ZoomOutTileLooper extends ScaleTileLooper {
        private static final int MAX_ZOOM_OUT_DIFF = 8;

        public ZoomOutTileLooper(float f) {
            super(f);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
        @Override // com.mapbox.mapboxsdk.overlay.TilesOverlay.ScaleTileLooper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void handleScaleTile(String str, int i, MapTile mapTile, int i2, int i3) {
            if (this.mDiff >= 8.0f) {
                return;
            }
            int iLeftShift = (int) GeometryMath.leftShift(i2, this.mDiff);
            int iLeftShift2 = (int) GeometryMath.leftShift(i3, this.mDiff);
            int iLeftShift3 = (int) GeometryMath.leftShift(1.0f, this.mDiff);
            Bitmap bitmapFromRemoved = null;
            Canvas canvas = null;
            for (int i4 = 0; i4 < iLeftShift3; i4++) {
                for (int i5 = 0; i5 < iLeftShift3; i5++) {
                    CacheableBitmapDrawable mapTileFromMemory = TilesOverlay.this.mTileProvider.getMapTileFromMemory(new MapTile(str, this.mOldZoomRound, GeometryMath.mod(iLeftShift + i4, this.mOldTileUpperBound), GeometryMath.mod(iLeftShift2 + i5, this.mOldTileUpperBound)));
                    if (mapTileFromMemory instanceof BitmapDrawable) {
                        if (mapTileFromMemory instanceof CacheableBitmapDrawable) {
                            mapTileFromMemory.setBeingUsed(true);
                            this.mBeingUsedDrawables.add(mapTileFromMemory);
                        }
                        Bitmap bitmap = mapTileFromMemory.getBitmap();
                        if (bitmap != null) {
                            if (bitmapFromRemoved == null) {
                                bitmapFromRemoved = TilesOverlay.this.mTileProvider.getBitmapFromRemoved(i, i);
                                if (bitmapFromRemoved == null) {
                                    bitmapFromRemoved = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
                                }
                                canvas = new Canvas(bitmapFromRemoved);
                            }
                            this.mDestRect.set(this.mTileSize_2 * i4, this.mTileSize_2 * i5, this.mTileSize_2 * (i4 + 1), this.mTileSize_2 * (i5 + 1));
                            canvas.drawBitmap(bitmap, (Rect) null, this.mDestRect, (Paint) null);
                        }
                    }
                }
            }
            if (bitmapFromRemoved != null) {
                this.mNewTiles.put(mapTile, bitmapFromRemoved);
            }
        }
    }
}
