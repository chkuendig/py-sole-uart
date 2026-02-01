package fm.feed.android.playersdk.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ArtistResults.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R0\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lfm/feed/android/playersdk/models/ArtistResults;", "Lfm/feed/android/playersdk/models/PageInfo;", "()V", "<set-?>", "", "Lfm/feed/android/playersdk/models/Artist;", "artists", "getArtists", "()Ljava/util/List;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class ArtistResults extends PageInfo {

    @SerializedName("artists")
    private List<Artist> artists;

    public final List<Artist> getArtists() {
        return this.artists;
    }
}
