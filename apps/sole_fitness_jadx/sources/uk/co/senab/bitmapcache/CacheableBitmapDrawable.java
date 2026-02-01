package uk.co.senab.bitmapcache;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import uk.co.senab.bitmapcache.BitmapLruCache;

/* loaded from: classes3.dex */
public class CacheableBitmapDrawable extends BitmapDrawable {
    static final String LOG_TAG = "CacheableBitmapDrawable";
    public static final int SOURCE_INBITMAP = 1;
    public static final int SOURCE_NEW = 0;
    public static final int SOURCE_UNKNOWN = -1;
    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    private int mCacheCount;
    private Runnable mCheckStateRunnable;
    private int mDisplayingCount;
    private boolean mHasBeenDisplayed;
    private final int mMemorySize;
    private BitmapLruCache.RecyclePolicy mRecyclePolicy;
    private boolean mReused;
    private final int mSource;
    private Throwable mStackTraceWhenRecycled;
    private final String mUrl;

    public CacheableBitmapDrawable(String str, Resources resources, Bitmap bitmap, BitmapLruCache.RecyclePolicy recyclePolicy, int i) {
        super(resources, bitmap);
        this.mMemorySize = bitmap != null ? bitmap.getRowBytes() * bitmap.getHeight() : 0;
        this.mUrl = str;
        this.mRecyclePolicy = recyclePolicy;
        this.mDisplayingCount = 0;
        this.mHasBeenDisplayed = false;
        this.mCacheCount = 0;
        this.mSource = i;
        this.mReused = false;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mReused) {
            Log.e(LOG_TAG, "trying to draw a reused bitmap: " + this.mUrl);
            return;
        }
        try {
            super.draw(canvas);
        } catch (RuntimeException e) {
            if (this.mStackTraceWhenRecycled != null) {
                this.mStackTraceWhenRecycled.printStackTrace();
            }
            throw e;
        }
    }

    int getMemorySize() {
        return this.mMemorySize;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public int getSource() {
        return this.mSource;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isBitmapValid() {
        boolean z;
        Bitmap bitmap = getBitmap();
        if (this.mReused || bitmap == null) {
            z = false;
        } else if (!bitmap.isRecycled()) {
            z = true;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isBitmapMutable() {
        boolean z;
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            z = bitmap.isMutable();
        }
        return z;
    }

    public synchronized boolean isBeingDisplayed() {
        return this.mDisplayingCount > 0;
    }

    public synchronized boolean isReferencedByCache() {
        return this.mCacheCount > 0;
    }

    public synchronized void setBeingUsed(boolean z) {
        if (z) {
            this.mDisplayingCount++;
            this.mHasBeenDisplayed = true;
        } else {
            this.mDisplayingCount--;
        }
        checkState();
    }

    synchronized void setCached(boolean z) {
        if (z) {
            this.mCacheCount++;
        } else {
            this.mCacheCount--;
        }
        checkState();
    }

    synchronized void setReused() {
        if (!this.mReused) {
            this.mReused = true;
        }
    }

    private void tryRecycle() {
        checkState(false);
    }

    private void cancelCheckStateCallback() {
        if (this.mCheckStateRunnable != null) {
            if (Constants.DEBUG) {
                Log.d(LOG_TAG, "Cancelling checkState() callback for: " + this.mUrl);
            }
            sHandler.removeCallbacks(this.mCheckStateRunnable);
            this.mCheckStateRunnable = null;
        }
    }

    private void checkState() {
        checkState(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void checkState(boolean z) {
        if (Constants.DEBUG) {
            Log.d(LOG_TAG, String.format("checkState(). Been Displayed: %b, Displaying: %d, Caching: %d, URL: %s", Boolean.valueOf(this.mHasBeenDisplayed), Integer.valueOf(this.mDisplayingCount), Integer.valueOf(this.mCacheCount), this.mUrl));
        }
        if (this.mRecyclePolicy.canRecycle()) {
            cancelCheckStateCallback();
            if (this.mCacheCount <= 0 && this.mDisplayingCount <= 0 && (isBitmapValid() || this.mReused)) {
                if (this.mHasBeenDisplayed || z) {
                    if (Constants.DEBUG) {
                        Log.d(LOG_TAG, "Recycling bitmap with url: " + this.mUrl);
                    }
                    this.mStackTraceWhenRecycled = new Throwable("Recycled Bitmap Method Stack");
                    getBitmap().recycle();
                } else {
                    if (Constants.DEBUG) {
                        Log.d(LOG_TAG, "Unused Bitmap which hasn't been displayed, delaying recycle(): " + this.mUrl);
                    }
                    CheckStateRunnable checkStateRunnable = new CheckStateRunnable(this);
                    this.mCheckStateRunnable = checkStateRunnable;
                    sHandler.postDelayed(checkStateRunnable, 2000L);
                }
            }
        }
    }

    private static final class CheckStateRunnable extends WeakReferenceRunnable<CacheableBitmapDrawable> {
        public CheckStateRunnable(CacheableBitmapDrawable cacheableBitmapDrawable) {
            super(cacheableBitmapDrawable);
        }

        @Override // uk.co.senab.bitmapcache.WeakReferenceRunnable
        public void run(CacheableBitmapDrawable cacheableBitmapDrawable) {
            cacheableBitmapDrawable.checkState(true);
        }
    }
}
