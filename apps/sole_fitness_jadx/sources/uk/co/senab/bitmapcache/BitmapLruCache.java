package uk.co.senab.bitmapcache;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.jakewharton.disklrucache.DiskLruCache;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class BitmapLruCache {
    static final int DISK_CACHE_FLUSH_DELAY_SECS = 5;
    private DiskLruCache mDiskCache;
    private HashMap<String, ReentrantLock> mDiskCacheEditLocks;
    private ScheduledThreadPoolExecutor mDiskCacheFlusherExecutor;
    private DiskCacheFlushRunnable mDiskCacheFlusherRunnable;
    private ScheduledFuture<?> mDiskCacheFuture;
    private BitmapMemoryLruCache mMemoryCache;
    private RecyclePolicy mRecyclePolicy;
    private Resources mResources;
    private File mTempDir;

    public interface InputStreamProvider {
        InputStream getInputStream();
    }

    /* renamed from: uk.co.senab.bitmapcache.BitmapLruCache$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$uk$co$senab$bitmapcache$BitmapLruCache$RecyclePolicy;

        static {
            int[] iArr = new int[RecyclePolicy.values().length];
            $SwitchMap$uk$co$senab$bitmapcache$BitmapLruCache$RecyclePolicy = iArr;
            try {
                iArr[RecyclePolicy.PRE_HONEYCOMB_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$uk$co$senab$bitmapcache$BitmapLruCache$RecyclePolicy[RecyclePolicy.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$uk$co$senab$bitmapcache$BitmapLruCache$RecyclePolicy[RecyclePolicy.ALWAYS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum RecyclePolicy {
        DISABLED,
        PRE_HONEYCOMB_ONLY,
        ALWAYS;

        boolean canInBitmap() {
            int i = AnonymousClass1.$SwitchMap$uk$co$senab$bitmapcache$BitmapLruCache$RecyclePolicy[ordinal()];
            return (i == 1 || i == 2) && Build.VERSION.SDK_INT >= 11;
        }

        boolean canRecycle() {
            int i = AnonymousClass1.$SwitchMap$uk$co$senab$bitmapcache$BitmapLruCache$RecyclePolicy[ordinal()];
            return i != 1 ? i == 3 : Build.VERSION.SDK_INT < 11;
        }
    }

    private static void checkNotOnMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("This method should not be called from the main/UI thread.");
        }
    }

    private static String transformUrlForDiskCacheKey(String str) {
        return Md5.encode(str);
    }

    BitmapLruCache(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.mTempDir = applicationContext.getCacheDir();
            this.mResources = applicationContext.getResources();
        }
    }

    public boolean contains(String str) {
        return containsInMemoryCache(str) || containsInDiskCache(str);
    }

    public boolean containsInDiskCache(String str) {
        if (this.mDiskCache != null) {
            checkNotOnMainThread();
            try {
                return this.mDiskCache.get(transformUrlForDiskCacheKey(str)) != null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean containsInMemoryCache(String str) {
        BitmapMemoryLruCache bitmapMemoryLruCache = this.mMemoryCache;
        return (bitmapMemoryLruCache == null || bitmapMemoryLruCache.get(str) == null) ? false : true;
    }

    public CacheableBitmapDrawable get(String str) {
        return get(str, null);
    }

    public CacheableBitmapDrawable get(String str, BitmapFactory.Options options) {
        CacheableBitmapDrawable fromMemoryCache = getFromMemoryCache(str);
        return fromMemoryCache == null ? getFromDiskCache(str, options) : fromMemoryCache;
    }

    public CacheableBitmapDrawable getFromDiskCache(String str, BitmapFactory.Options options) {
        CacheableBitmapDrawable cacheableBitmapDrawableDecodeBitmapToDrawable = null;
        if (this.mDiskCache != null) {
            checkNotOnMainThread();
            try {
                String strTransformUrlForDiskCacheKey = transformUrlForDiskCacheKey(str);
                cacheableBitmapDrawableDecodeBitmapToDrawable = decodeBitmapToDrawable(new SnapshotInputStreamProvider(strTransformUrlForDiskCacheKey), str, options);
                if (cacheableBitmapDrawableDecodeBitmapToDrawable != null) {
                    BitmapMemoryLruCache bitmapMemoryLruCache = this.mMemoryCache;
                    if (bitmapMemoryLruCache != null) {
                        bitmapMemoryLruCache.put(cacheableBitmapDrawableDecodeBitmapToDrawable);
                    }
                } else {
                    this.mDiskCache.remove(strTransformUrlForDiskCacheKey);
                    scheduleDiskCacheFlush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cacheableBitmapDrawableDecodeBitmapToDrawable;
    }

    public CacheableBitmapDrawable getFromMemoryCache(String str) {
        BitmapMemoryLruCache bitmapMemoryLruCache = this.mMemoryCache;
        CacheableBitmapDrawable cacheableBitmapDrawable = null;
        if (bitmapMemoryLruCache != null) {
            synchronized (bitmapMemoryLruCache) {
                CacheableBitmapDrawable cacheableBitmapDrawable2 = this.mMemoryCache.get(str);
                if (cacheableBitmapDrawable2 == null || cacheableBitmapDrawable2.isBitmapValid()) {
                    cacheableBitmapDrawable = cacheableBitmapDrawable2;
                } else {
                    this.mMemoryCache.remove(str);
                }
            }
        }
        return cacheableBitmapDrawable;
    }

    public Bitmap getBitmapFromRemoved(int i, int i2) {
        Bitmap bitmapFromRemoved;
        BitmapMemoryLruCache bitmapMemoryLruCache = this.mMemoryCache;
        if (bitmapMemoryLruCache == null) {
            return null;
        }
        synchronized (bitmapMemoryLruCache) {
            bitmapFromRemoved = this.mMemoryCache.getBitmapFromRemoved(i, i2);
        }
        return bitmapFromRemoved;
    }

    public boolean isDiskCacheEnabled() {
        return this.mDiskCache != null;
    }

    public boolean isMemoryCacheEnabled() {
        return this.mMemoryCache != null;
    }

    public CacheableBitmapDrawable put(String str, Bitmap bitmap) {
        return put(str, bitmap, Bitmap.CompressFormat.PNG, 100);
    }

    public CacheableBitmapDrawable put(String str, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) throws IOException {
        CacheableBitmapDrawable cacheableBitmapDrawable = new CacheableBitmapDrawable(str, this.mResources, bitmap, this.mRecyclePolicy, -1);
        putInMemoryCache(str, cacheableBitmapDrawable, compressFormat, i);
        putInDiskCache(str, cacheableBitmapDrawable, compressFormat, i);
        return cacheableBitmapDrawable;
    }

    public CacheableBitmapDrawable putInMemoryCache(String str, Bitmap bitmap) {
        return putInMemoryCache(str, bitmap, Bitmap.CompressFormat.PNG, 100);
    }

    public CacheableBitmapDrawable putInMemoryCache(String str, CacheableBitmapDrawable cacheableBitmapDrawable) {
        return putInMemoryCache(str, cacheableBitmapDrawable, Bitmap.CompressFormat.PNG, 100);
    }

    public CacheableBitmapDrawable putInMemoryCache(String str, CacheableBitmapDrawable cacheableBitmapDrawable, Bitmap.CompressFormat compressFormat, int i) {
        BitmapMemoryLruCache bitmapMemoryLruCache = this.mMemoryCache;
        if (bitmapMemoryLruCache != null) {
            synchronized (bitmapMemoryLruCache) {
                this.mMemoryCache.put(cacheableBitmapDrawable);
            }
        }
        return cacheableBitmapDrawable;
    }

    public CacheableBitmapDrawable putInMemoryCache(String str, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        return putInMemoryCache(str, new CacheableBitmapDrawable(str, this.mResources, bitmap, this.mRecyclePolicy, -1), compressFormat, i);
    }

    public CacheableBitmapDrawable putInDiskCache(String str, Bitmap bitmap) {
        return putInDiskCache(str, bitmap, Bitmap.CompressFormat.PNG, 100);
    }

    public CacheableBitmapDrawable putInDiskCache(String str, CacheableBitmapDrawable cacheableBitmapDrawable) {
        return putInDiskCache(str, cacheableBitmapDrawable, Bitmap.CompressFormat.PNG, 100);
    }

    public CacheableBitmapDrawable putInDiskCache(String str, CacheableBitmapDrawable cacheableBitmapDrawable, Bitmap.CompressFormat compressFormat, int i) throws IOException {
        if (this.mDiskCache != null) {
            checkNotOnMainThread();
            String strTransformUrlForDiskCacheKey = transformUrlForDiskCacheKey(str);
            ReentrantLock lockForDiskCacheEdit = getLockForDiskCacheEdit(strTransformUrlForDiskCacheKey);
            lockForDiskCacheEdit.lock();
            OutputStream outputStreamNewOutputStream = null;
            try {
                try {
                    DiskLruCache.Editor editorEdit = this.mDiskCache.edit(strTransformUrlForDiskCacheKey);
                    outputStreamNewOutputStream = editorEdit.newOutputStream(0);
                    cacheableBitmapDrawable.getBitmap().compress(compressFormat, i, outputStreamNewOutputStream);
                    outputStreamNewOutputStream.flush();
                    editorEdit.commit();
                } catch (IOException e) {
                    Log.e(Constants.LOG_TAG, "Error while writing to disk cache", e);
                }
            } finally {
                IoUtils.closeStream(outputStreamNewOutputStream);
                lockForDiskCacheEdit.unlock();
                scheduleDiskCacheFlush();
            }
        }
        return cacheableBitmapDrawable;
    }

    public CacheableBitmapDrawable putInDiskCache(String str, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        return putInDiskCache(str, new CacheableBitmapDrawable(str, this.mResources, bitmap, this.mRecyclePolicy, -1), compressFormat, i);
    }

    public CacheableBitmapDrawable put(String str, InputStream inputStream) {
        return put(str, inputStream, (BitmapFactory.Options) null);
    }

    public CacheableBitmapDrawable put(String str, byte[] bArr, BitmapFactory.Options options) {
        CacheableBitmapDrawable cacheableBitmapDrawableDecodeBitmapToDrawable;
        checkNotOnMainThread();
        if (this.mDiskCache == null && (cacheableBitmapDrawableDecodeBitmapToDrawable = decodeBitmapToDrawable(new ByteArrayInputStreamProvider(bArr), str, options)) != null) {
            if (this.mMemoryCache != null) {
                cacheableBitmapDrawableDecodeBitmapToDrawable.setCached(true);
                this.mMemoryCache.put(cacheableBitmapDrawableDecodeBitmapToDrawable.getUrl(), cacheableBitmapDrawableDecodeBitmapToDrawable);
            }
            return cacheableBitmapDrawableDecodeBitmapToDrawable;
        }
        return put(str, new ByteArrayInputStream(bArr), options);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CacheableBitmapDrawable put(String str, InputStream inputStream, BitmapFactory.Options options) throws IOException {
        File fileCreateTempFile;
        CacheableBitmapDrawable cacheableBitmapDrawableDecodeBitmapToDrawable = null;
        if (inputStream == null) {
            return null;
        }
        checkNotOnMainThread();
        try {
            fileCreateTempFile = File.createTempFile("bitmapcache_", null, this.mTempDir);
        } catch (IOException e) {
            e = e;
            fileCreateTempFile = null;
        }
        try {
            IoUtils.copy(inputStream, fileCreateTempFile);
        } catch (IOException e2) {
            e = e2;
            Log.e(Constants.LOG_TAG, "Error writing to saving stream to temp file: " + str, e);
            if (fileCreateTempFile != null) {
            }
            return cacheableBitmapDrawableDecodeBitmapToDrawable;
        }
        if (fileCreateTempFile != null) {
            cacheableBitmapDrawableDecodeBitmapToDrawable = decodeBitmapToDrawable(new FileInputStreamProvider(fileCreateTempFile), str, options);
            if (cacheableBitmapDrawableDecodeBitmapToDrawable != null) {
                if (this.mMemoryCache != null) {
                    cacheableBitmapDrawableDecodeBitmapToDrawable.setCached(true);
                    synchronized (this.mMemoryCache) {
                        this.mMemoryCache.put(cacheableBitmapDrawableDecodeBitmapToDrawable.getUrl(), cacheableBitmapDrawableDecodeBitmapToDrawable);
                    }
                }
                if (this.mDiskCache != null) {
                    String strTransformUrlForDiskCacheKey = transformUrlForDiskCacheKey(str);
                    ReentrantLock lockForDiskCacheEdit = getLockForDiskCacheEdit(str);
                    lockForDiskCacheEdit.lock();
                    try {
                        try {
                            DiskLruCache.Editor editorEdit = this.mDiskCache.edit(strTransformUrlForDiskCacheKey);
                            IoUtils.copy(fileCreateTempFile, editorEdit.newOutputStream(0));
                            editorEdit.commit();
                        } catch (IOException e3) {
                            Log.e(Constants.LOG_TAG, "Error writing to disk cache. URL: " + str, e3);
                        }
                    } finally {
                        lockForDiskCacheEdit.unlock();
                        scheduleDiskCacheFlush();
                    }
                }
            }
            fileCreateTempFile.delete();
        }
        return cacheableBitmapDrawableDecodeBitmapToDrawable;
    }

    public void remove(String str) {
        BitmapMemoryLruCache bitmapMemoryLruCache = this.mMemoryCache;
        if (bitmapMemoryLruCache != null) {
            synchronized (bitmapMemoryLruCache) {
                this.mMemoryCache.remove(str);
            }
        }
        if (this.mDiskCache != null) {
            checkNotOnMainThread();
            try {
                this.mDiskCache.remove(transformUrlForDiskCacheKey(str));
                scheduleDiskCacheFlush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeFromMemoryCache(String str) {
        BitmapMemoryLruCache bitmapMemoryLruCache = this.mMemoryCache;
        if (bitmapMemoryLruCache != null) {
            synchronized (bitmapMemoryLruCache) {
                this.mMemoryCache.remove(str);
            }
        }
    }

    public void removeFromDiskCache(String str) {
        if (this.mDiskCache != null) {
            checkNotOnMainThread();
            try {
                this.mDiskCache.remove(transformUrlForDiskCacheKey(str));
                scheduleDiskCacheFlush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void trimMemory() {
        BitmapMemoryLruCache bitmapMemoryLruCache = this.mMemoryCache;
        if (bitmapMemoryLruCache != null) {
            synchronized (bitmapMemoryLruCache) {
                this.mMemoryCache.trimMemory();
            }
        }
    }

    public void purgeMemoryCache() {
        BitmapMemoryLruCache bitmapMemoryLruCache = this.mMemoryCache;
        if (bitmapMemoryLruCache != null) {
            synchronized (bitmapMemoryLruCache) {
                this.mMemoryCache.evictAll();
            }
        }
    }

    public void purgeDiskCache() {
        if (this.mDiskCache != null) {
            checkNotOnMainThread();
            try {
                this.mDiskCache.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void setDiskCache(DiskLruCache diskLruCache) {
        this.mDiskCache = diskLruCache;
        if (diskLruCache != null) {
            this.mDiskCacheEditLocks = new HashMap<>();
            this.mDiskCacheFlusherExecutor = new ScheduledThreadPoolExecutor(1);
            this.mDiskCacheFlusherRunnable = new DiskCacheFlushRunnable(diskLruCache);
        }
    }

    void setMemoryCache(BitmapMemoryLruCache bitmapMemoryLruCache) {
        this.mMemoryCache = bitmapMemoryLruCache;
        this.mRecyclePolicy = bitmapMemoryLruCache.getRecyclePolicy();
    }

    private ReentrantLock getLockForDiskCacheEdit(String str) {
        ReentrantLock reentrantLock;
        synchronized (this.mDiskCacheEditLocks) {
            reentrantLock = this.mDiskCacheEditLocks.get(str);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock();
                this.mDiskCacheEditLocks.put(str, reentrantLock);
            }
        }
        return reentrantLock;
    }

    private void scheduleDiskCacheFlush() {
        ScheduledFuture<?> scheduledFuture = this.mDiskCacheFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.mDiskCacheFuture = this.mDiskCacheFlusherExecutor.schedule(this.mDiskCacheFlusherRunnable, 5L, TimeUnit.SECONDS);
    }

    public CacheableBitmapDrawable createCacheableBitmapDrawable(Bitmap bitmap, String str, int i) {
        if (bitmap != null) {
            return new CacheableBitmapDrawable(str, this.mResources, bitmap, this.mRecyclePolicy, i);
        }
        return null;
    }

    private CacheableBitmapDrawable decodeBitmapToDrawable(InputStreamProvider inputStreamProvider, String str, BitmapFactory.Options options) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        return createCacheableBitmapDrawable(decodeBitmap(inputStreamProvider, options, atomicInteger), str, atomicInteger.get());
    }

    public Bitmap decodeBitmap(InputStreamProvider inputStreamProvider, BitmapFactory.Options options) {
        return decodeBitmap(inputStreamProvider, options, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c A[Catch: Exception -> 0x0042, all -> 0x0053, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:18:0x002e, B:20:0x0032, B:21:0x003c, B:29:0x0048), top: B:36:0x0007 }] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap decodeBitmap(InputStreamProvider inputStreamProvider, BitmapFactory.Options options, AtomicInteger atomicInteger) throws Throwable {
        InputStream inputStream;
        Bitmap bitmapDecodeByteArray;
        if (atomicInteger != null) {
            atomicInteger.set(0);
        }
        ?? r1 = 0;
        bitmap = null;
        Bitmap bitmap = null;
        try {
            try {
                if (this.mRecyclePolicy.canInBitmap()) {
                    if (options == null) {
                        options = new BitmapFactory.Options();
                    }
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                        if (addInBitmapOptions(inputStreamProvider, options) && atomicInteger != null) {
                            atomicInteger.set(1);
                        }
                    }
                }
                inputStream = inputStreamProvider.getInputStream();
                if (inputStream == null) {
                    try {
                        if (inputStreamProvider instanceof ByteArrayInputStreamProvider) {
                            byte[] bArr = ((ByteArrayInputStreamProvider) inputStreamProvider).array;
                            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        } else {
                            bitmapDecodeByteArray = BitmapFactory.decodeStream(inputStream, null, options);
                        }
                        bitmap = bitmapDecodeByteArray;
                    } catch (Exception e) {
                        e = e;
                        Log.e(Constants.LOG_TAG, "Unable to decode stream", e);
                        IoUtils.closeStream(inputStream);
                        return bitmap;
                    }
                }
            } catch (Throwable th) {
                th = th;
                r1 = atomicInteger;
                IoUtils.closeStream((InputStream) r1);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            IoUtils.closeStream((InputStream) r1);
            throw th;
        }
        IoUtils.closeStream(inputStream);
        return bitmap;
    }

    private boolean addInBitmapOptions(InputStreamProvider inputStreamProvider, BitmapFactory.Options options) throws IOException {
        InputStream inputStream = inputStreamProvider.getInputStream();
        options.inJustDecodeBounds = true;
        if (inputStream == null && (inputStreamProvider instanceof ByteArrayInputStreamProvider)) {
            byte[] bArr = ((ByteArrayInputStreamProvider) inputStreamProvider).array;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            BitmapFactory.decodeStream(inputStream, null, options);
        }
        IoUtils.closeStream(inputStream);
        options.inJustDecodeBounds = false;
        options.inMutable = true;
        synchronized (this.mMemoryCache) {
            Bitmap bitmapFromRemoved = this.mMemoryCache.getBitmapFromRemoved(options.outWidth, options.outHeight);
            if (bitmapFromRemoved == null) {
                return false;
            }
            if (Constants.DEBUG) {
                Log.i(Constants.LOG_TAG, "Using inBitmap");
            }
            SDK11.addInBitmapOption(options, bitmapFromRemoved);
            return true;
        }
    }

    public static final class Builder {
        static final int DEFAULT_DISK_CACHE_MAX_SIZE_MB = 10;
        static final float DEFAULT_MEMORY_CACHE_HEAP_PERCENTAGE = 12.5f;
        static final float DEFAULT_MEMORY_CACHE_HEAP_RATIO = 0.125f;
        static final int DEFAULT_MEM_CACHE_MAX_SIZE_MB = 3;
        static final RecyclePolicy DEFAULT_RECYCLE_POLICY = RecyclePolicy.PRE_HONEYCOMB_ONLY;
        static final float MAX_MEMORY_CACHE_HEAP_PERCENTAGE = 75.0f;
        static final float MAX_MEMORY_CACHE_HEAP_RATIO = 0.75f;
        static final int MEGABYTE = 1048576;
        private Context mContext;
        private boolean mDiskCacheEnabled;
        private File mDiskCacheLocation;
        private long mDiskCacheMaxSize;
        private boolean mMemoryCacheEnabled;
        private int mMemoryCacheMaxSize;
        private RecyclePolicy mRecyclePolicy;

        private static long getHeapSize() {
            return Runtime.getRuntime().maxMemory();
        }

        public Builder() {
            this(null);
        }

        public Builder(Context context) {
            this.mContext = context;
            this.mDiskCacheMaxSize = 10485760L;
            this.mMemoryCacheEnabled = true;
            this.mMemoryCacheMaxSize = 3145728;
            this.mRecyclePolicy = DEFAULT_RECYCLE_POLICY;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [uk.co.senab.bitmapcache.BitmapLruCache$Builder$1] */
        public BitmapLruCache build() {
            final BitmapLruCache bitmapLruCache = new BitmapLruCache(this.mContext);
            if (isValidOptionsForMemoryCache()) {
                if (Constants.DEBUG) {
                    Log.d("BitmapLruCache.Builder", "Creating Memory Cache");
                }
                bitmapLruCache.setMemoryCache(new BitmapMemoryLruCache(this.mMemoryCacheMaxSize, this.mRecyclePolicy));
            }
            if (isValidOptionsForDiskCache()) {
                new AsyncTask<Void, Void, DiskLruCache>() { // from class: uk.co.senab.bitmapcache.BitmapLruCache.Builder.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public DiskLruCache doInBackground(Void... voidArr) {
                        try {
                            return DiskLruCache.open(Builder.this.mDiskCacheLocation, 0, 1, Builder.this.mDiskCacheMaxSize);
                        } catch (IOException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public void onPostExecute(DiskLruCache diskLruCache) {
                        bitmapLruCache.setDiskCache(diskLruCache);
                    }
                }.execute(new Void[0]);
            }
            return bitmapLruCache;
        }

        public Builder setDiskCacheEnabled(boolean z) {
            this.mDiskCacheEnabled = z;
            return this;
        }

        public Builder setDiskCacheLocation(File file) {
            this.mDiskCacheLocation = file;
            return this;
        }

        public Builder setDiskCacheMaxSize(long j) {
            this.mDiskCacheMaxSize = j;
            return this;
        }

        public Builder setMemoryCacheEnabled(boolean z) {
            this.mMemoryCacheEnabled = z;
            return this;
        }

        public Builder setMemoryCacheMaxSize(int i) {
            this.mMemoryCacheMaxSize = i;
            return this;
        }

        public Builder setMemoryCacheMaxSizeUsingHeapSize() {
            return setMemoryCacheMaxSizeUsingHeapSize(DEFAULT_MEMORY_CACHE_HEAP_RATIO);
        }

        public Builder setMemoryCacheMaxSizeUsingHeapSize(float f) {
            return setMemoryCacheMaxSize(Math.round(getHeapSize() * Math.min(f, MAX_MEMORY_CACHE_HEAP_RATIO)));
        }

        public Builder setRecyclePolicy(RecyclePolicy recyclePolicy) {
            if (recyclePolicy == null) {
                throw new IllegalArgumentException("The recycle policy can not be null");
            }
            this.mRecyclePolicy = recyclePolicy;
            return this;
        }

        private boolean isValidOptionsForDiskCache() {
            boolean z = this.mDiskCacheEnabled;
            if (!z) {
                return z;
            }
            File file = this.mDiskCacheLocation;
            if (file == null) {
                Log.i(Constants.LOG_TAG, "Disk Cache has been enabled, but no location given. Please call setDiskCacheLocation(...)");
            } else {
                if (file.canWrite()) {
                    return z;
                }
                Log.i(Constants.LOG_TAG, "Disk Cache Location is not write-able, disabling disk caching.");
            }
            return false;
        }

        private boolean isValidOptionsForMemoryCache() {
            return this.mMemoryCacheEnabled && this.mMemoryCacheMaxSize > 0;
        }
    }

    static final class DiskCacheFlushRunnable implements Runnable {
        private final DiskLruCache mDiskCache;

        public DiskCacheFlushRunnable(DiskLruCache diskLruCache) {
            this.mDiskCache = diskLruCache;
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            if (Constants.DEBUG) {
                Log.d(Constants.LOG_TAG, "Flushing Disk Cache");
            }
            try {
                this.mDiskCache.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class FileInputStreamProvider implements InputStreamProvider {
        final File mFile;

        public FileInputStreamProvider(File file) {
            this.mFile = file;
        }

        @Override // uk.co.senab.bitmapcache.BitmapLruCache.InputStreamProvider
        public InputStream getInputStream() {
            try {
                return new FileInputStream(this.mFile);
            } catch (FileNotFoundException e) {
                Log.e(Constants.LOG_TAG, "Could not decode file: " + this.mFile.getAbsolutePath(), e);
                return null;
            }
        }
    }

    public static class ByteArrayInputStreamProvider implements InputStreamProvider {
        final byte[] array;

        @Override // uk.co.senab.bitmapcache.BitmapLruCache.InputStreamProvider
        public InputStream getInputStream() {
            return null;
        }

        public ByteArrayInputStreamProvider(byte[] bArr) {
            this.array = bArr;
        }
    }

    final class SnapshotInputStreamProvider implements InputStreamProvider {
        final String mKey;

        SnapshotInputStreamProvider(String str) {
            this.mKey = str;
        }

        @Override // uk.co.senab.bitmapcache.BitmapLruCache.InputStreamProvider
        public InputStream getInputStream() {
            try {
                DiskLruCache.Snapshot snapshot = BitmapLruCache.this.mDiskCache.get(this.mKey);
                if (snapshot != null) {
                    return snapshot.getInputStream(0);
                }
                return null;
            } catch (IOException e) {
                Log.e(Constants.LOG_TAG, "Could open disk cache for url: " + this.mKey, e);
                return null;
            }
        }
    }
}
