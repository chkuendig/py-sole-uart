package fm.feed.android.playersdk.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Play.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0003H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006-"}, d2 = {"Lfm/feed/android/playersdk/models/Play;", "", "id", "", "(Ljava/lang/String;)V", "audioFile", "Lfm/feed/android/playersdk/models/AudioFile;", "getAudioFile", "()Lfm/feed/android/playersdk/models/AudioFile;", "setAudioFile", "(Lfm/feed/android/playersdk/models/AudioFile;)V", "elapsedSeconds", "", "getElapsedSeconds", "()F", "setElapsedSeconds", "(F)V", "getId", "()Ljava/lang/String;", "setId", "likeState", "Lfm/feed/android/playersdk/models/Play$LikeState;", "getLikeState", "()Lfm/feed/android/playersdk/models/Play$LikeState;", "setLikeState", "(Lfm/feed/android/playersdk/models/Play$LikeState;)V", "start", "getStart", "()Ljava/lang/Float;", "setStart", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "station", "Lfm/feed/android/playersdk/models/Station;", "getStation", "()Lfm/feed/android/playersdk/models/Station;", "setStation", "(Lfm/feed/android/playersdk/models/Station;)V", "equals", "", "other", "hashCode", "", "toString", "LikeState", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class Play {

    @SerializedName("audio_file")
    public AudioFile audioFile;

    @SerializedName("elapsed_seconds")
    private float elapsedSeconds;

    @SerializedName("id")
    private String id;

    @SerializedName("start_at")
    private Float start;

    @SerializedName("station")
    private Station station;

    /* compiled from: Play.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lfm/feed/android/playersdk/models/Play$LikeState;", "", "(Ljava/lang/String;I)V", "NONE", "LIKED", "DISLIKED", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum LikeState {
        NONE,
        LIKED,
        DISLIKED
    }

    /* compiled from: Play.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LikeState.values().length];
            iArr[LikeState.LIKED.ordinal()] = 1;
            iArr[LikeState.DISLIKED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Play(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        this.id = id2;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final float getElapsedSeconds() {
        return this.elapsedSeconds;
    }

    public final void setElapsedSeconds(float f) {
        this.elapsedSeconds = f;
    }

    public final Station getStation() {
        return this.station;
    }

    public final void setStation(Station station) {
        this.station = station;
    }

    public final AudioFile getAudioFile() {
        AudioFile audioFile = this.audioFile;
        if (audioFile != null) {
            return audioFile;
        }
        Intrinsics.throwUninitializedPropertyAccessException("audioFile");
        return null;
    }

    public final void setAudioFile(AudioFile audioFile) {
        Intrinsics.checkNotNullParameter(audioFile, "<set-?>");
        this.audioFile = audioFile;
    }

    public final Float getStart() {
        return this.start;
    }

    public final void setStart(Float f) {
        this.start = f;
    }

    public final LikeState getLikeState() {
        if (getAudioFile().getIsLiked()) {
            return LikeState.LIKED;
        }
        if (getAudioFile().getIsDisliked()) {
            return LikeState.DISLIKED;
        }
        return LikeState.NONE;
    }

    public final void setLikeState(LikeState likeState) {
        Intrinsics.checkNotNullParameter(likeState, "likeState");
        int i = WhenMappings.$EnumSwitchMapping$0[likeState.ordinal()];
        if (i == 1) {
            getAudioFile().setLiked();
        } else if (i == 2) {
            getAudioFile().setDisliked();
        } else {
            getAudioFile().setUnliked();
        }
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Play) {
            return Intrinsics.areEqual(this.id, ((Play) other).id);
        }
        return false;
    }

    public String toString() {
        return Intrinsics.stringPlus(Intrinsics.stringPlus("{ id: ", this.id) + " audioFile: " + getAudioFile(), " }");
    }
}
