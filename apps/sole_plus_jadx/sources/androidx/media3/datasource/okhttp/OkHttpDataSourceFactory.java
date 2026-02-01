package androidx.media3.datasource.okhttp;

import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.TransferListener;
import okhttp3.CacheControl;
import okhttp3.Call;

@Deprecated
/* loaded from: classes3.dex */
public final class OkHttpDataSourceFactory extends HttpDataSource.BaseFactory {
    private final CacheControl cacheControl;
    private final Call.Factory callFactory;
    private final TransferListener listener;
    private final String userAgent;

    public OkHttpDataSourceFactory(Call.Factory factory) {
        this(factory, null, null, null);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, String str) {
        this(factory, str, null, null);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, String str, CacheControl cacheControl) {
        this(factory, str, null, cacheControl);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, String str, TransferListener transferListener) {
        this(factory, str, transferListener, null);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, String str, TransferListener transferListener, CacheControl cacheControl) {
        this.callFactory = factory;
        this.userAgent = str;
        this.listener = transferListener;
        this.cacheControl = cacheControl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.datasource.HttpDataSource.BaseFactory
    public OkHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties requestProperties) {
        OkHttpDataSource okHttpDataSource = new OkHttpDataSource(this.callFactory, this.userAgent, this.cacheControl, requestProperties);
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            okHttpDataSource.addTransferListener(transferListener);
        }
        return okHttpDataSource;
    }
}
