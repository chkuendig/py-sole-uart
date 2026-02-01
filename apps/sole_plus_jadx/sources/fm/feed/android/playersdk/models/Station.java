package fm.feed.android.playersdk.models;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Station.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\rJ\u0013\u00109\u001a\u00020\u001c2\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010;\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\rJ\u0006\u0010<\u001a\u00020\u001cJ\b\u0010=\u001a\u00020\u0003H\u0016J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001cJ\b\u0010A\u001a\u00020\rH\u0016R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001c8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001dR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010$\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR \u0010%\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u0018\u0010(\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0015R\u001e\u0010*\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R$\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010.8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001e\u00101\u001a\u0002028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006B"}, d2 = {"Lfm/feed/android/playersdk/models/Station;", "", "id", "", "(Ljava/lang/Integer;)V", "audioFiles", "", "Lfm/feed/android/playersdk/models/AudioFile;", "getAudioFiles", "()Ljava/util/List;", "setAudioFiles", "(Ljava/util/List;)V", "castUrl", "", "getCastUrl", "()Ljava/lang/String;", "setCastUrl", "(Ljava/lang/String;)V", "expiry", "Ljava/util/Date;", "getExpiry", "()Ljava/util/Date;", "setExpiry", "(Ljava/util/Date;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isOnDemand", "", "()Z", "isSinglePlay", "()Ljava/lang/Boolean;", "setSinglePlay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "<set-?>", "isTypeOffline", "lastPlayStart", "getLastPlayStart", "setLastPlayStart", "lastUpdated", "getLastUpdated", "name", "getName", "setName", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "getOptions", "()Ljava/util/Map;", "preGain", "", "getPreGain", "()F", "setPreGain", "(F)V", "containsOption", "key", "equals", "other", "getOption", "hasNewMusic", "hashCode", "setOfflineType", "", "flag", "toString", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class Station {

    @SerializedName("audio_files")
    private List<AudioFile> audioFiles;

    @SerializedName("cast_url")
    private String castUrl;

    @SerializedName("expire_date")
    private Date expiry;

    @SerializedName("id")
    private final Integer id;

    @SerializedName("on_demand")
    @JsonAdapter(BooleanAdapter.class)
    private final boolean isOnDemand;

    @SerializedName("single_play")
    private Boolean isSinglePlay;
    private boolean isTypeOffline;

    @SerializedName("last_play_start")
    private Date lastPlayStart;

    @SerializedName("last_updated")
    private final Date lastUpdated;

    @SerializedName("name")
    public String name;

    @SerializedName(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS)
    private final Map<String, Object> options;

    @SerializedName("pre_gain")
    private float preGain;

    public Station(Integer num) {
        this.id = num;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("name");
        return null;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final Map<String, Object> getOptions() {
        return this.options;
    }

    public final float getPreGain() {
        return this.preGain;
    }

    public final void setPreGain(float f) {
        this.preGain = f;
    }

    public final Date getExpiry() {
        return this.expiry;
    }

    public final void setExpiry(Date date) {
        this.expiry = date;
    }

    /* renamed from: isSinglePlay, reason: from getter */
    public final Boolean getIsSinglePlay() {
        return this.isSinglePlay;
    }

    public final void setSinglePlay(Boolean bool) {
        this.isSinglePlay = bool;
    }

    public final Date getLastUpdated() {
        return this.lastUpdated;
    }

    public final Date getLastPlayStart() {
        return this.lastPlayStart;
    }

    public final void setLastPlayStart(Date date) {
        this.lastPlayStart = date;
    }

    /* renamed from: isOnDemand, reason: from getter */
    public final boolean getIsOnDemand() {
        return this.isOnDemand;
    }

    public final String getCastUrl() {
        return this.castUrl;
    }

    public final void setCastUrl(String str) {
        this.castUrl = str;
    }

    public final List<AudioFile> getAudioFiles() {
        return this.audioFiles;
    }

    public final void setAudioFiles(List<AudioFile> list) {
        this.audioFiles = list;
    }

    /* renamed from: isTypeOffline, reason: from getter */
    public final boolean getIsTypeOffline() {
        return this.isTypeOffline;
    }

    public final void setOfflineType(boolean flag) {
        this.isTypeOffline = flag;
    }

    public final Object getOption(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, Object> map = this.options;
        if (map == null) {
            return null;
        }
        return map.get(key);
    }

    public final boolean containsOption(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, Object> map = this.options;
        if (map == null) {
            return false;
        }
        return map.containsKey(key);
    }

    public int hashCode() {
        Integer num = this.id;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof Station)) {
            return false;
        }
        Station station = (Station) other;
        return Intrinsics.areEqual(station.id, this.id) && station.isTypeOffline == this.isTypeOffline;
    }

    public String toString() {
        return "{ id: " + this.id + ", name: \"" + getName() + "\" }";
    }

    public final boolean hasNewMusic() {
        Date date = this.lastPlayStart;
        if (date == null || this.lastUpdated == null) {
            return true;
        }
        Intrinsics.checkNotNull(date);
        return date.before(this.lastUpdated);
    }
}
