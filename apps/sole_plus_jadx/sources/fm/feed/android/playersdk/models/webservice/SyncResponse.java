package fm.feed.android.playersdk.models.webservice;

import com.google.gson.annotations.SerializedName;
import fm.feed.android.playersdk.models.AudioFile;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SyncResponse.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lfm/feed/android/playersdk/models/webservice/SyncResponse;", "Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;", "()V", "audioFileList", "", "Lfm/feed/android/playersdk/models/AudioFile;", "getAudioFileList", "()Ljava/util/List;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SyncResponse extends FeedFMResponse {

    @SerializedName("audio_files")
    private final List<AudioFile> audioFileList;

    public final List<AudioFile> getAudioFileList() {
        return this.audioFileList;
    }
}
