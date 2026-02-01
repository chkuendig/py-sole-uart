package fm.feed.android.playersdk.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: PageInfo.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006¨\u0006\f"}, d2 = {"Lfm/feed/android/playersdk/models/PageInfo;", "", "()V", "page", "", "getPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "perPageResults", "getPerPageResults", "total", "getTotal", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public class PageInfo {

    @SerializedName("total")
    private final Integer total = 0;

    @SerializedName("per_page")
    private final Integer perPageResults = 0;

    @SerializedName("page")
    private final Integer page = 0;

    public final Integer getTotal() {
        return this.total;
    }

    public final Integer getPerPageResults() {
        return this.perPageResults;
    }

    public final Integer getPage() {
        return this.page;
    }
}
