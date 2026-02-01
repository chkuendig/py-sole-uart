package fm.feed.android.playersdk;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fm.feed.android.playersdk.models.AudioFile;
import fm.feed.android.playersdk.models.Play;
import fm.feed.android.playersdk.models.Station;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OfflineSession.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0000\u0018\u0000 Y2\u00020\u0001:\u0002YZB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u000201J\u0014\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020503H\u0002J\u0006\u00106\u001a\u00020\u001bJ\u0006\u00107\u001a\u00020'J\u001e\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\u00152\f\u0010:\u001a\b\u0012\u0004\u0012\u0002040\fH\u0002J\u0012\u0010;\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u000e\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020\u0017J\u0006\u0010@\u001a\u00020'J\u0014\u0010A\u001a\b\u0012\u0004\u0012\u0002040\f2\u0006\u0010?\u001a\u00020\u0017J\u0012\u0010B\u001a\u0004\u0018\u00010\u00152\u0006\u0010?\u001a\u00020\u0017H\u0002J\u000e\u0010C\u001a\u0002012\u0006\u0010?\u001a\u00020\u0017J\u0018\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020\u00172\b\u0010F\u001a\u0004\u0018\u00010\u0017J\u0006\u0010G\u001a\u00020'J\u000e\u0010H\u001a\u00020'2\u0006\u0010I\u001a\u00020\u001bJ\u000e\u0010J\u001a\u00020'2\u0006\u0010<\u001a\u000204J\u000e\u0010K\u001a\u00020'2\u0006\u0010<\u001a\u000204J\u000e\u0010L\u001a\u00020'2\u0006\u0010<\u001a\u000204J\u0006\u0010M\u001a\u00020'J\u000e\u0010N\u001a\u0002012\u0006\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u00020'2\u0006\u0010<\u001a\u000204J\u0006\u0010R\u001a\u00020'J\b\u0010S\u001a\u00020'H\u0002J\u0016\u0010T\u001a\u00020'2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002J\u000e\u0010U\u001a\u00020'2\u0006\u0010?\u001a\u00020\u0017J\u0006\u0010V\u001a\u00020'J\u0015\u0010W\u001a\u00020'2\b\u0010O\u001a\u0004\u0018\u00010P¢\u0006\u0002\u0010XR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000eR\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\f8F¢\u0006\u0006\u001a\u0004\b%\u0010\u000e¨\u0006["}, d2 = {"Lfm/feed/android/playersdk/OfflineSession;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "eventListener", "Lfm/feed/android/playersdk/OfflineSession$OfflineEventListener;", "(Landroid/content/Context;Lfm/feed/android/playersdk/OfflineSession$OfflineEventListener;)V", "activeStation", "Lfm/feed/android/playersdk/models/Station;", "getActiveStation", "()Lfm/feed/android/playersdk/models/Station;", "availableStationList", "", "getAvailableStationList", "()Ljava/util/List;", "<set-?>", "Lfm/feed/android/playersdk/models/Play;", "currentItem", "getCurrentItem", "()Lfm/feed/android/playersdk/models/Play;", "currentManager", "Lfm/feed/android/playersdk/OfflineStationManager;", "fileStoragePath", "", "log", "Lfm/feed/android/playersdk/FMLog;", SdkConstants.FD_LOGS, "Lorg/json/JSONArray;", "nextItem", "getNextItem", "offlineStationManagers", "", "savedStationList", "getSavedStationList", "sharedPreferences", "Landroid/content/SharedPreferences;", "stationList", "getStationList", "addOfflineStation", "", "station", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lfm/feed/android/playersdk/StationDownloadListener;", "appendLogEntry", "entry", "Lorg/json/JSONObject;", "calculateOfflineStorageUsed", "", "canSkip", "", "computeAudioItemCounts", "", "Lfm/feed/android/playersdk/models/AudioFile;", "", "copyAndResetLogs", "deleteAllStations", "deleteAudioItemsFromOfflineStationManager", "manager", "audioItems", "deleteExtraneousFilesIn", "file", "Ljava/io/File;", "deleteLocalStationWithName", "name", "destroy", "getAudioItemsForLocalStationWithName", "getStationManagerForStationName", "isStationAvailableWithName", "logEvent", NotificationCompat.CATEGORY_EVENT, "parms", "playStarted", "prependLogs", "entries", "rejectItem", "requestDislikeForItem", "requestLikeForItem", "requestNextItem", "requestSkip", "time", "", "requestUnlikeForItem", "reset", "retrieveLogs", "saveStationList", "setActiveStationByName", "updatePlayCompleted", "updatePlayTime", "(Ljava/lang/Float;)V", "Companion", "OfflineEventListener", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class OfflineSession {
    private Play currentItem;
    private OfflineStationManager currentManager;
    private final OfflineEventListener eventListener;
    private final String fileStoragePath;
    private final FMLog log;
    private JSONArray logs;
    private Play nextItem;
    private final List<OfflineStationManager> offlineStationManagers;
    private final SharedPreferences sharedPreferences;
    private static final String OFFLINE_PREFS_SHARED_PREF_KEY = "FeedFMOffline";
    private static final String OFFLINE_STATIONS_SHARED_PREF_KEY = "OfflineStations";
    private static final String LOGS_SHARED_PREF_KEY = SdkConstants.FD_LOGS;
    private static final String FILES_SUBDIR = "/feedfm";

    /* compiled from: OfflineSession.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lfm/feed/android/playersdk/OfflineSession$OfflineEventListener;", "", "activeStationDidChange", "", "currentItemDidChange", "nextItemAvailable", "noMoreMusic", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OfflineEventListener {
        void activeStationDidChange();

        void currentItemDidChange();

        void nextItemAvailable();

        void noMoreMusic();
    }

    public final boolean canSkip() {
        return true;
    }

    public OfflineSession(Context context, OfflineEventListener eventListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.eventListener = eventListener;
        this.log = new FMLog("fm.feed.OfflineSession");
        this.offlineStationManagers = new ArrayList();
        SharedPreferences sharedPreferences = context.getSharedPreferences(OFFLINE_PREFS_SHARED_PREF_KEY, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…EY, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences;
        this.fileStoragePath = Intrinsics.stringPlus(context.getFilesDir().getPath(), FILES_SUBDIR);
        List<Station> savedStationList = getSavedStationList();
        Date date = new Date();
        for (Station station : savedStationList) {
            Date expiry = station.getExpiry();
            if (expiry != null) {
                if (expiry.after(date)) {
                    this.offlineStationManagers.add(new OfflineStationManager(station, this.fileStoragePath, this.sharedPreferences));
                } else {
                    this.offlineStationManagers.add(new OfflineStationManager(station, this.fileStoragePath, this.sharedPreferences));
                    deleteLocalStationWithName(station.getName());
                }
            }
        }
        if (this.offlineStationManagers.size() > 0) {
            this.currentManager = this.offlineStationManagers.get(0);
        }
        retrieveLogs();
    }

    public final Play getCurrentItem() {
        return this.currentItem;
    }

    public final Play getNextItem() {
        return this.nextItem;
    }

    public final Station getActiveStation() {
        OfflineStationManager offlineStationManager = this.currentManager;
        if (offlineStationManager == null) {
            return null;
        }
        return offlineStationManager.getStation();
    }

    private final List<Station> getSavedStationList() {
        List<Station> list;
        try {
            list = (List) new Gson().fromJson(this.sharedPreferences.getString(OFFLINE_STATIONS_SHARED_PREF_KEY, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), new TypeToken<List<? extends Station>>() { // from class: fm.feed.android.playersdk.OfflineSession$savedStationList$1
            }.getType());
        } catch (Exception e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Unable to parse saved station list ", e), null, 2, null);
            list = null;
        }
        return list == null ? new ArrayList() : list;
    }

    public final List<Station> getStationList() {
        ArrayList arrayList = new ArrayList();
        Iterator<OfflineStationManager> it = this.offlineStationManagers.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getStation());
        }
        return arrayList;
    }

    public final List<Station> getAvailableStationList() {
        ArrayList arrayList = new ArrayList();
        for (OfflineStationManager offlineStationManager : this.offlineStationManagers) {
            if (offlineStationManager.isStationAvailableOffline()) {
                arrayList.add(offlineStationManager.getStation());
            }
        }
        return arrayList;
    }

    private final void retrieveLogs() {
        try {
            this.logs = new JSONArray(this.sharedPreferences.getString(LOGS_SHARED_PREF_KEY, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
        } catch (JSONException e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Exception parsing stored logs", e), null, 2, null);
        }
        this.logs = new JSONArray();
    }

    public final void appendLogEntry(JSONObject entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        JSONArray jSONArray = this.logs;
        Intrinsics.checkNotNull(jSONArray);
        jSONArray.put(entry);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        String str = LOGS_SHARED_PREF_KEY;
        JSONArray jSONArray2 = this.logs;
        Intrinsics.checkNotNull(jSONArray2);
        editorEdit.putString(str, jSONArray2.toString()).apply();
    }

    public final JSONArray copyAndResetLogs() {
        JSONArray jSONArray = this.logs;
        this.logs = new JSONArray();
        Intrinsics.checkNotNull(jSONArray);
        if (jSONArray.length() > 0) {
            this.sharedPreferences.edit().remove(LOGS_SHARED_PREF_KEY).apply();
        }
        return jSONArray;
    }

    public final void prependLogs(JSONArray entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        JSONArray jSONArray = new JSONArray();
        int length = entries.length();
        int i = 0;
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                try {
                    jSONArray.put(entries.get(i2));
                } catch (JSONException e) {
                    FMLog.e$default(this.log, Intrinsics.stringPlus("Log parsing error", e), null, 2, null);
                }
                if (i3 >= length) {
                    break;
                } else {
                    i2 = i3;
                }
            }
        }
        JSONArray jSONArray2 = this.logs;
        Intrinsics.checkNotNull(jSONArray2);
        int length2 = jSONArray2.length();
        if (length2 > 0) {
            while (true) {
                int i4 = i + 1;
                try {
                    jSONArray.put(entries.get(i));
                } catch (JSONException e2) {
                    FMLog.e$default(this.log, Intrinsics.stringPlus("Log parsing error ", e2), null, 2, null);
                }
                if (i4 >= length2) {
                    break;
                } else {
                    i = i4;
                }
            }
        }
        this.logs = jSONArray;
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        String str = LOGS_SHARED_PREF_KEY;
        JSONArray jSONArray3 = this.logs;
        Intrinsics.checkNotNull(jSONArray3);
        editorEdit.putString(str, jSONArray3.toString()).apply();
    }

    public final void setActiveStationByName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        OfflineStationManager stationManagerForStationName = getStationManagerForStationName(name);
        if (stationManagerForStationName == null) {
            FMLog.d$default(this.log, Intrinsics.stringPlus("Cannot find offline station with name ", name), null, 2, null);
            return;
        }
        OfflineStationManager offlineStationManager = this.currentManager;
        if (offlineStationManager != null) {
            Intrinsics.checkNotNull(offlineStationManager);
            if (Intrinsics.areEqual(offlineStationManager.getStation().getName(), name)) {
                FMLog.d$default(this.log, "Not changing offline station to same station!", null, 2, null);
                return;
            }
        }
        FMLog.d$default(this.log, Intrinsics.stringPlus("Updating current offline station to ", name), null, 2, null);
        reset();
        this.currentManager = stationManagerForStationName;
        this.eventListener.activeStationDidChange();
    }

    public final void reset() {
        this.nextItem = null;
        this.currentItem = null;
    }

    public final void destroy() {
        reset();
        this.currentManager = null;
    }

    public final void addOfflineStation(Station station, StationDownloadListener listener) {
        Intrinsics.checkNotNullParameter(station, "station");
        Intrinsics.checkNotNullParameter(listener, "listener");
        OfflineStationManager stationManagerForStationName = getStationManagerForStationName(station.getName());
        List<Station> savedStationList = getSavedStationList();
        FMLog.d$default(this.log, (stationManagerForStationName == null ? "Adding" : "Updating") + " offline station " + station, null, 2, null);
        savedStationList.add(station);
        if (stationManagerForStationName != null) {
            Station station2 = stationManagerForStationName.getStation();
            savedStationList.remove(station2);
            ArrayList arrayList = new ArrayList();
            List<AudioFile> audioFiles = station2.getAudioFiles();
            if (audioFiles != null) {
                List<AudioFile> audioFiles2 = station.getAudioFiles();
                if (audioFiles2 == null) {
                    deleteAudioItemsFromOfflineStationManager(stationManagerForStationName, audioFiles);
                } else {
                    for (AudioFile audioFile : audioFiles) {
                        if (!audioFiles2.contains(audioFile)) {
                            arrayList.add(audioFile);
                        }
                    }
                    deleteAudioItemsFromOfflineStationManager(stationManagerForStationName, arrayList);
                }
            }
        }
        saveStationList(savedStationList);
        OfflineStationManager offlineStationManager = new OfflineStationManager(station, this.fileStoragePath, this.sharedPreferences);
        if (stationManagerForStationName != null) {
            this.offlineStationManagers.remove(stationManagerForStationName);
        }
        this.offlineStationManagers.add(offlineStationManager);
        OfflineStationManager offlineStationManager2 = this.currentManager;
        if (offlineStationManager2 != null) {
            Intrinsics.checkNotNull(offlineStationManager2);
            if (Intrinsics.areEqual(offlineStationManager2.getStation().getName(), offlineStationManager.getStation().getName())) {
                this.currentManager = offlineStationManager;
            }
        }
        offlineStationManager.downloadStation(listener);
    }

    private final void saveStationList(List<Station> stationList) {
        if (stationList.isEmpty()) {
            this.sharedPreferences.edit().remove(OFFLINE_STATIONS_SHARED_PREF_KEY).apply();
        } else {
            this.sharedPreferences.edit().putString(OFFLINE_STATIONS_SHARED_PREF_KEY, new Gson().toJson(stationList)).apply();
        }
    }

    private final OfflineStationManager getStationManagerForStationName(String name) {
        for (OfflineStationManager offlineStationManager : this.offlineStationManagers) {
            if (Intrinsics.areEqual(offlineStationManager.getStation().getName(), name)) {
                return offlineStationManager;
            }
        }
        return null;
    }

    public final void deleteAllStations() {
        for (OfflineStationManager offlineStationManager : this.offlineStationManagers) {
            offlineStationManager.deleteFilesForAudioItems(offlineStationManager.getAudioFilesAvailable());
            offlineStationManager.deleteConfig();
        }
        this.offlineStationManagers.clear();
        deleteExtraneousFilesIn(new File(this.fileStoragePath));
        saveStationList(new LinkedList());
    }

    public final void deleteLocalStationWithName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        OfflineStationManager stationManagerForStationName = getStationManagerForStationName(name);
        if (stationManagerForStationName != null) {
            FMLog.d$default(this.log, Intrinsics.stringPlus("Deleting station ", stationManagerForStationName.getStation()), null, 2, null);
            deleteAudioItemsFromOfflineStationManager(stationManagerForStationName, stationManagerForStationName.getAudioFilesAvailable());
            stationManagerForStationName.deleteConfig();
            this.offlineStationManagers.remove(stationManagerForStationName);
            List<Station> savedStationList = getSavedStationList();
            savedStationList.remove(stationManagerForStationName.getStation());
            saveStationList(savedStationList);
        }
    }

    public final List<AudioFile> getAudioItemsForLocalStationWithName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        OfflineStationManager stationManagerForStationName = getStationManagerForStationName(name);
        List<AudioFile> audioFilesAvailable = stationManagerForStationName == null ? null : stationManagerForStationName.getAudioFilesAvailable();
        return audioFilesAvailable == null ? new ArrayList() : audioFilesAvailable;
    }

    private final void deleteAudioItemsFromOfflineStationManager(OfflineStationManager manager, List<AudioFile> audioItems) {
        Map<AudioFile, Integer> mapComputeAudioItemCounts = computeAudioItemCounts();
        LinkedList linkedList = new LinkedList();
        for (AudioFile audioFile : audioItems) {
            Integer num = mapComputeAudioItemCounts.get(audioFile);
            if (num == null || num.intValue() <= 1) {
                linkedList.add(audioFile);
            }
        }
        manager.deleteFilesForAudioItems(linkedList);
    }

    private final void deleteExtraneousFilesIn(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            try {
                FMLog.d$default(this.log, Intrinsics.stringPlus("Deleting extraneous file:", file), null, 2, null);
                if (file.delete()) {
                    return;
                }
                FMLog.w$default(this.log, Intrinsics.stringPlus("Unable to delete extraneous file:", file), null, 2, null);
                return;
            } catch (SecurityException e) {
                FMLog.e$default(this.log, Intrinsics.stringPlus("Problem cleaning up excess storage ", e), null, 2, null);
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            int length = fileArrListFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = fileArrListFiles[i];
                i++;
                try {
                    if (file2.isDirectory()) {
                        deleteExtraneousFilesIn(file2);
                    } else {
                        FMLog.d$default(this.log, Intrinsics.stringPlus("Deleting extraneous file:", file2), null, 2, null);
                        if (!file2.delete()) {
                            FMLog.w$default(this.log, Intrinsics.stringPlus("Unable to delete extraneous file: ", file2), null, 2, null);
                        }
                    }
                } catch (SecurityException e2) {
                    FMLog.e$default(this.log, Intrinsics.stringPlus("Problem cleaning up excess storage", e2), null, 2, null);
                }
            }
        }
    }

    public final long calculateOfflineStorageUsed() {
        File[] fileArrListFiles;
        File file = new File(this.fileStoragePath);
        long length = 0;
        if (!file.exists()) {
            return 0L;
        }
        if (!file.isDirectory()) {
            FMLog.v$default(this.log, "  in storage: " + file + ": " + file.length(), null, 2, null);
            return file.length();
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(file);
        while (!linkedList.isEmpty()) {
            int i = 0;
            Object objRemove = linkedList.remove(0);
            Intrinsics.checkNotNullExpressionValue(objRemove, "dirs.removeAt(0)");
            File file2 = (File) objRemove;
            if (file2.exists() && (fileArrListFiles = file2.listFiles()) != null && fileArrListFiles.length != 0) {
                int length2 = fileArrListFiles.length;
                while (i < length2) {
                    File file3 = fileArrListFiles[i];
                    i++;
                    FMLog.v$default(this.log, "  in storage: " + file3 + ": " + file3.length(), null, 2, null);
                    length += file3.length();
                    if (file3.isDirectory()) {
                        linkedList.add(file3);
                    }
                }
            }
        }
        return length;
    }

    private final Map<AudioFile, Integer> computeAudioItemCounts() {
        HashMap map = new HashMap();
        Iterator<OfflineStationManager> it = this.offlineStationManagers.iterator();
        while (it.hasNext()) {
            for (AudioFile audioFile : it.next().getAudioFilesAvailable()) {
                Integer num = (Integer) map.get(audioFile);
                if (num == null) {
                    map.put(audioFile, 1);
                } else {
                    map.put(audioFile, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
        return map;
    }

    public final boolean isStationAvailableWithName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        OfflineStationManager stationManagerForStationName = getStationManagerForStationName(name);
        if (stationManagerForStationName == null) {
            return false;
        }
        return stationManagerForStationName.isStationAvailableOffline();
    }

    public final void requestNextItem() {
        FMLog.v$default(this.log, "Looking for next item", null, 2, null);
        if (this.nextItem != null) {
            FMLog.d$default(this.log, "Not Requesting next item since we already have one", null, 2, null);
            return;
        }
        OfflineStationManager offlineStationManager = this.currentManager;
        if (offlineStationManager == null) {
            FMLog.d$default(this.log, "Not Requesting next item since there is no current manager", null, 2, null);
            return;
        }
        if (offlineStationManager == null) {
            return;
        }
        this.nextItem = offlineStationManager.getNextPlay();
        if (getNextItem() != null) {
            FMLog fMLog = this.log;
            Play nextItem = getNextItem();
            Intrinsics.checkNotNull(nextItem);
            FMLog.d$default(fMLog, Intrinsics.stringPlus("Next offline item set to ", nextItem), null, 2, null);
            this.eventListener.nextItemAvailable();
            return;
        }
        OfflineStationManager offlineStationManager2 = this.currentManager;
        if (offlineStationManager2 != null) {
            offlineStationManager2.shuffleStation();
        }
        this.nextItem = offlineStationManager.getNextPlay();
        if (getNextItem() != null) {
            FMLog fMLog2 = this.log;
            Play nextItem2 = getNextItem();
            Intrinsics.checkNotNull(nextItem2);
            FMLog.d$default(fMLog2, Intrinsics.stringPlus("Next offline item set to ", nextItem2), null, 2, null);
            this.eventListener.nextItemAvailable();
            return;
        }
        this.eventListener.noMoreMusic();
    }

    public final void updatePlayTime(Float time) throws JSONException {
        Play play;
        if (time == null || (play = this.currentItem) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, "elapse");
            jSONObject.put("play_id", play.getId());
            jSONObject.put("seconds", time.floatValue());
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            appendLogEntry(jSONObject);
        } catch (JSONException e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("unable to encode play time event", e), null, 2, null);
        }
    }

    public final boolean requestSkip(float time) throws JSONException {
        Play play = this.currentItem;
        if (play == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, SdkConstants.TAG_SKIP);
            jSONObject.put("play_id", play.getId());
            jSONObject.put("seconds", time);
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            appendLogEntry(jSONObject);
            return true;
        } catch (JSONException e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Unable to encode skip request event", e), null, 2, null);
            return true;
        }
    }

    public final void playStarted() throws JSONException {
        this.currentItem = this.nextItem;
        this.eventListener.currentItemDidChange();
        this.nextItem = null;
        requestNextItem();
        Play play = this.currentItem;
        if (play == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, "start");
            jSONObject.put("play_id", play.getId());
            jSONObject.put("audio_file_id", play.getAudioFile().getId());
            jSONObject.put("format", play.getAudioFile().getCodec());
            jSONObject.put("max_bitrate", play.getAudioFile().getBitrate());
            Station station = play.getStation();
            jSONObject.put("station_id", station == null ? null : station.getId());
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            appendLogEntry(jSONObject);
        } catch (JSONException e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Unable to encode play started event", e), null, 2, null);
        }
    }

    public final void updatePlayCompleted() throws JSONException {
        Play play = this.currentItem;
        if (play == null) {
            FMLog.d$default(this.log, "Trying to mark play completed when there is none!", null, 2, null);
            return;
        }
        if (play == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, SdkConstants.TAG_SKIP);
            jSONObject.put("play_id", play.getId());
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            appendLogEntry(jSONObject);
        } catch (JSONException e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Unable to encode play completed event", e), null, 2, null);
        }
    }

    public final void requestLikeForItem(AudioFile file) throws JSONException {
        Intrinsics.checkNotNullParameter(file, "file");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, "like");
            jSONObject.put("audio_file_id", file.getId());
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            appendLogEntry(jSONObject);
        } catch (JSONException e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Unable to encode like request event ", e), null, 2, null);
        }
    }

    public final void requestUnlikeForItem(AudioFile file) throws JSONException {
        Intrinsics.checkNotNullParameter(file, "file");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, "unlike");
            jSONObject.put("audio_file_id", file.getId());
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            appendLogEntry(jSONObject);
        } catch (JSONException e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Unable to encode unlike event", e), null, 2, null);
        }
    }

    public final void requestDislikeForItem(AudioFile file) throws JSONException {
        Intrinsics.checkNotNullParameter(file, "file");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, "dislike");
            jSONObject.put("audio_file_id", file.getId());
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            appendLogEntry(jSONObject);
        } catch (JSONException e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Unable to encode dislike event", e), null, 2, null);
        }
    }

    public final void logEvent(String event, String parms) throws JSONException {
        Intrinsics.checkNotNullParameter(event, "event");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, NotificationCompat.CATEGORY_EVENT);
            jSONObject.put("name", event);
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            if (parms != null) {
                jSONObject.put("parameters", parms);
            }
            appendLogEntry(jSONObject);
        } catch (JSONException e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Unable to encode generic event event", e), null, 2, null);
        }
    }

    public final void rejectItem(AudioFile file) throws JSONException {
        Intrinsics.checkNotNullParameter(file, "file");
        Play play = this.currentItem;
        if (play == null) {
            return;
        }
        if (Intrinsics.areEqual(file.getId(), play.getAudioFile().getId())) {
            this.currentItem = getNextItem();
            this.nextItem = null;
            requestNextItem();
        } else {
            Play nextItem = getNextItem();
            if (nextItem != null && Intrinsics.areEqual(file.getId(), nextItem.getId())) {
                this.nextItem = null;
                requestNextItem();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, "invalidate");
            jSONObject.put("audio_file_id", play.getAudioFile().getId());
            jSONObject.put("format", play.getAudioFile().getCodec());
            jSONObject.put("max_bitrate", play.getAudioFile().getBitrate());
            Station station = play.getStation();
            jSONObject.put("station_id", station == null ? null : station.getId());
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            appendLogEntry(jSONObject);
        } catch (JSONException e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Unable to encode invalidate event ", e), null, 2, null);
        }
    }
}
