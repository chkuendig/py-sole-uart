package fm.feed.android.playersdk.models;

import androidx.camera.video.AudioStats;
import com.android.SdkConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AudioFile.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010>\u001a\u00020\u00102\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0018\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020AH\u0002J\b\u0010D\u001a\u00020EH\u0016J\u0006\u0010F\u001a\u00020GJ\u0006\u0010H\u001a\u00020GJ\u0006\u0010I\u001a\u00020GJ\b\u0010J\u001a\u00020\u0003H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u0004R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\rR\u001e\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R \u0010#\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00108\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R,\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR\u0011\u00103\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b4\u0010\u001bR\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u0004¨\u0006K"}, d2 = {"Lfm/feed/android/playersdk/models/AudioFile;", "", "id", "", "(Ljava/lang/String;)V", "artist", "Lfm/feed/android/playersdk/models/Artist;", "getArtist", "()Lfm/feed/android/playersdk/models/Artist;", "setArtist", "(Lfm/feed/android/playersdk/models/Artist;)V", "bitrate", "getBitrate", "()Ljava/lang/String;", "setBitrate", "canCache", "", "getCanCache", "()Z", "canSeek", "getCanSeek", "codec", "getCodec", "setCodec", "durationInSeconds", "", "getDurationInSeconds", "()F", "setDurationInSeconds", "(F)V", "endTrim", "getEndTrim", "getId", "<set-?>", "isDisliked", "isLiked", "metadata", "", "getMetadata", "()Ljava/util/Map;", "setMetadata", "(Ljava/util/Map;)V", "release", "Lfm/feed/android/playersdk/models/Release;", "getRelease", "()Lfm/feed/android/playersdk/models/Release;", "setRelease", "(Lfm/feed/android/playersdk/models/Release;)V", "replayGain", "getReplayGain", "setReplayGain", "startTrim", "getStartTrim", SdkConstants.ATTR_TRACK, "Lfm/feed/android/playersdk/models/Track;", "getTrack", "()Lfm/feed/android/playersdk/models/Track;", "setTrack", "(Lfm/feed/android/playersdk/models/Track;)V", "url", "getUrl", "setUrl", "equals", "other", "getDoubleOption", "", "name", SdkConstants.PreferenceAttributes.ATTR_DEFAULT_VALUE, "hashCode", "", "setDisliked", "", "setLiked", "setUnliked", "toString", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class AudioFile {

    @SerializedName("artist")
    public Artist artist;

    @SerializedName("bitrate")
    private String bitrate;

    @SerializedName("can_cache")
    private final boolean canCache;

    @SerializedName("can_seek")
    private final boolean canSeek;

    @SerializedName("codec")
    private String codec;

    @SerializedName("duration_in_seconds")
    private float durationInSeconds;

    @SerializedName("id")
    private final String id;
    private boolean isDisliked;

    @SerializedName("liked")
    private boolean isLiked;

    @SerializedName("extra")
    private Map<String, Object> metadata;

    @SerializedName("release")
    public Release release;

    @SerializedName("replaygain_track_gain")
    private float replayGain;

    @SerializedName(SdkConstants.ATTR_TRACK)
    public Track track;

    @SerializedName("url")
    private String url;

    public AudioFile(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        this.id = id2;
        this.url = "";
    }

    public final String getId() {
        return this.id;
    }

    public final float getDurationInSeconds() {
        return this.durationInSeconds;
    }

    public final void setDurationInSeconds(float f) {
        this.durationInSeconds = f;
    }

    public final String getCodec() {
        return this.codec;
    }

    public final void setCodec(String str) {
        this.codec = str;
    }

    public final String getBitrate() {
        return this.bitrate;
    }

    public final void setBitrate(String str) {
        this.bitrate = str;
    }

    public final float getReplayGain() {
        return this.replayGain;
    }

    public final void setReplayGain(float f) {
        this.replayGain = f;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    /* renamed from: isLiked, reason: from getter */
    public final boolean getIsLiked() {
        return this.isLiked;
    }

    /* renamed from: isDisliked, reason: from getter */
    public final boolean getIsDisliked() {
        return this.isDisliked;
    }

    public final Track getTrack() {
        Track track = this.track;
        if (track != null) {
            return track;
        }
        Intrinsics.throwUninitializedPropertyAccessException(SdkConstants.ATTR_TRACK);
        return null;
    }

    public final void setTrack(Track track) {
        Intrinsics.checkNotNullParameter(track, "<set-?>");
        this.track = track;
    }

    public final Release getRelease() {
        Release release = this.release;
        if (release != null) {
            return release;
        }
        Intrinsics.throwUninitializedPropertyAccessException("release");
        return null;
    }

    public final void setRelease(Release release) {
        Intrinsics.checkNotNullParameter(release, "<set-?>");
        this.release = release;
    }

    public final Artist getArtist() {
        Artist artist = this.artist;
        if (artist != null) {
            return artist;
        }
        Intrinsics.throwUninitializedPropertyAccessException("artist");
        return null;
    }

    public final void setArtist(Artist artist) {
        Intrinsics.checkNotNullParameter(artist, "<set-?>");
        this.artist = artist;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(Map<String, Object> map) {
        this.metadata = map;
    }

    public final boolean getCanSeek() {
        return this.canSeek;
    }

    public final boolean getCanCache() {
        return this.canCache;
    }

    public final float getEndTrim() {
        return (float) getDoubleOption("trim_end", AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public final float getStartTrim() {
        return (float) getDoubleOption("trim_start", AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    private final double getDoubleOption(String name, double defaultValue) {
        Map<String, Object> map = this.metadata;
        if (map == null) {
            return defaultValue;
        }
        Intrinsics.checkNotNull(map);
        Object obj = map.get(name);
        double dDoubleValue = (obj == null || !(obj instanceof Double)) ? defaultValue : ((Number) obj).doubleValue();
        if (dDoubleValue != defaultValue) {
            return dDoubleValue;
        }
        if (!Intrinsics.areEqual(obj == null ? null : obj.getClass(), String.class)) {
            return dDoubleValue;
        }
        Double doubleOrNull = StringsKt.toDoubleOrNull(obj.toString());
        if (doubleOrNull != null) {
            defaultValue = doubleOrNull.doubleValue();
        }
        return defaultValue;
    }

    public final void setLiked() {
        this.isLiked = true;
        this.isDisliked = false;
    }

    public final void setDisliked() {
        this.isLiked = false;
        this.isDisliked = true;
    }

    public final void setUnliked() {
        this.isLiked = false;
        this.isDisliked = false;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object other) {
        return other != null && (other instanceof AudioFile) && Intrinsics.areEqual(((AudioFile) other).id, this.id);
    }

    public String toString() {
        return "{ id: " + this.id + ", track: " + ((Object) getTrack().getTitle()) + " , Artist: " + ((Object) getArtist().getName()) + " \n }";
    }
}
