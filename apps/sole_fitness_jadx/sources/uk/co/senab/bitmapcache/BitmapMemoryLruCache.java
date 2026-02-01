package uk.co.senab.bitmapcache;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import uk.co.senab.bitmapcache.BitmapLruCache;

/* loaded from: classes3.dex */
final class BitmapMemoryLruCache extends LruCache<String, CacheableBitmapDrawable> {
    private final BitmapLruCache.RecyclePolicy mRecyclePolicy;
    private final Set<SoftReference<CacheableBitmapDrawable>> mRemovedEntries;

    BitmapMemoryLruCache(int i, BitmapLruCache.RecyclePolicy recyclePolicy) {
        super(i);
        this.mRecyclePolicy = recyclePolicy;
        this.mRemovedEntries = recyclePolicy.canInBitmap() ? Collections.synchronizedSet(new HashSet()) : null;
    }

    CacheableBitmapDrawable put(CacheableBitmapDrawable cacheableBitmapDrawable) {
        if (cacheableBitmapDrawable == null) {
            return null;
        }
        cacheableBitmapDrawable.setCached(true);
        return put(cacheableBitmapDrawable.getUrl(), cacheableBitmapDrawable);
    }

    BitmapLruCache.RecyclePolicy getRecyclePolicy() {
        return this.mRecyclePolicy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.collection.LruCache
    public int sizeOf(String str, CacheableBitmapDrawable cacheableBitmapDrawable) {
        return cacheableBitmapDrawable.getMemorySize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.collection.LruCache
    public void entryRemoved(boolean z, String str, CacheableBitmapDrawable cacheableBitmapDrawable, CacheableBitmapDrawable cacheableBitmapDrawable2) {
        cacheableBitmapDrawable.setCached(false);
        if (this.mRemovedEntries == null || !canUseForInBitmap(cacheableBitmapDrawable)) {
            return;
        }
        synchronized (this.mRemovedEntries) {
            this.mRemovedEntries.add(new SoftReference<>(cacheableBitmapDrawable));
        }
    }

    public Bitmap getBitmapFromRemoved(int i, int i2) {
        Set<SoftReference<CacheableBitmapDrawable>> set = this.mRemovedEntries;
        Bitmap bitmap = null;
        if (set == null) {
            return null;
        }
        synchronized (set) {
            Iterator<SoftReference<CacheableBitmapDrawable>> it = this.mRemovedEntries.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CacheableBitmapDrawable cacheableBitmapDrawable = it.next().get();
                if (canUseForInBitmap(cacheableBitmapDrawable)) {
                    if (canUseForInBitmapForSize(cacheableBitmapDrawable, i, i2) && !cacheableBitmapDrawable.isBeingDisplayed() && !cacheableBitmapDrawable.isReferencedByCache()) {
                        bitmap = cacheableBitmapDrawable.getBitmap();
                        SDK12.setHasAlpha(bitmap, true);
                        bitmap.eraseColor(0);
                        cacheableBitmapDrawable.setReused();
                        it.remove();
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return bitmap;
    }

    private static boolean canUseForInBitmap(CacheableBitmapDrawable cacheableBitmapDrawable) {
        return cacheableBitmapDrawable != null && cacheableBitmapDrawable.isBitmapValid() && cacheableBitmapDrawable.isBitmapMutable();
    }

    private static boolean canUseForInBitmapForSize(CacheableBitmapDrawable cacheableBitmapDrawable, int i, int i2) {
        return cacheableBitmapDrawable.getIntrinsicWidth() == i && cacheableBitmapDrawable.getIntrinsicHeight() == i2;
    }

    void trimMemory() {
        for (Map.Entry<String, CacheableBitmapDrawable> entry : snapshot().entrySet()) {
            CacheableBitmapDrawable value = entry.getValue();
            if (value == null || !value.isBeingDisplayed()) {
                remove(entry.getKey());
            }
        }
        Set<SoftReference<CacheableBitmapDrawable>> set = this.mRemovedEntries;
        if (set != null) {
            synchronized (set) {
                this.mRemovedEntries.clear();
            }
        }
    }
}
