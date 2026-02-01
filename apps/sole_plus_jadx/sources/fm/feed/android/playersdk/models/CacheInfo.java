package fm.feed.android.playersdk.models;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheInfo.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lfm/feed/android/playersdk/models/CacheInfo;", "", "()V", "cacheSize", "", "getCacheSize", "()I", "setCacheSize", "(I)V", "fileSize", "getFileSize", "setFileSize", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class CacheInfo {

    @SerializedName("max")
    private int cacheSize;

    @SerializedName(SessionDescription.ATTR_LENGTH)
    private int fileSize;

    @SerializedName("url")
    public String url;

    public final String getUrl() {
        String str = this.url;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("url");
        return null;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final int getFileSize() {
        return this.fileSize;
    }

    public final void setFileSize(int i) {
        this.fileSize = i;
    }

    public final int getCacheSize() {
        return this.cacheSize;
    }

    public final void setCacheSize(int i) {
        this.cacheSize = i;
    }
}
