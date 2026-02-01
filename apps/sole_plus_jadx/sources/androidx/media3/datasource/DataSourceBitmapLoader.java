package androidx.media3.datasource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class DataSourceBitmapLoader implements BitmapLoader {
    public static final Supplier<ListeningExecutorService> DEFAULT_EXECUTOR_SERVICE = Suppliers.memoize(new Supplier() { // from class: androidx.media3.datasource.DataSourceBitmapLoader$$ExternalSyntheticLambda0
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
        }
    });
    private final DataSource.Factory dataSourceFactory;
    private final ListeningExecutorService listeningExecutorService;

    public DataSourceBitmapLoader(Context context) {
        this((ListeningExecutorService) Assertions.checkStateNotNull(DEFAULT_EXECUTOR_SERVICE.get()), new DefaultDataSource.Factory(context));
    }

    public DataSourceBitmapLoader(ListeningExecutorService listeningExecutorService, DataSource.Factory factory) {
        this.listeningExecutorService = listeningExecutorService;
        this.dataSourceFactory = factory;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture<Bitmap> decodeBitmap(final byte[] bArr) {
        return this.listeningExecutorService.submit(new Callable() { // from class: androidx.media3.datasource.DataSourceBitmapLoader$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DataSourceBitmapLoader.decode(bArr, null);
            }
        });
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture<Bitmap> loadBitmap(final Uri uri, final BitmapFactory.Options options) {
        return this.listeningExecutorService.submit(new Callable() { // from class: androidx.media3.datasource.DataSourceBitmapLoader$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m7625x731908d1(uri, options);
            }
        });
    }

    /* renamed from: lambda$loadBitmap$2$androidx-media3-datasource-DataSourceBitmapLoader, reason: not valid java name */
    /* synthetic */ Bitmap m7625x731908d1(Uri uri, BitmapFactory.Options options) throws Exception {
        return load(this.dataSourceFactory.createDataSource(), uri, options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap decode(byte[] bArr, BitmapFactory.Options options) throws IOException {
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        Assertions.checkArgument(bitmapDecodeByteArray != null, "Could not decode image data");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            ExifInterface exifInterface = new ExifInterface(byteArrayInputStream);
            byteArrayInputStream.close();
            int rotationDegrees = exifInterface.getRotationDegrees();
            if (rotationDegrees == 0) {
                return bitmapDecodeByteArray;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(rotationDegrees);
            return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static Bitmap load(DataSource dataSource, Uri uri, BitmapFactory.Options options) throws IOException {
        try {
            dataSource.open(new DataSpec(uri));
            return decode(DataSourceUtil.readToEnd(dataSource), options);
        } finally {
            dataSource.close();
        }
    }
}
