package fm.feed.android.playersdk;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fm.feed.android.playersdk.models.AudioFile;
import fm.feed.android.playersdk.models.Play;
import fm.feed.android.playersdk.models.Station;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* compiled from: OfflineStationManager.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0014\u0010\u001f\u001a\u00020\u001e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0005H\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\u0006\u0010*\u001a\u00020\u001eJ&\u0010+\u001a\u00020\u001e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0-2\u0006\u0010!\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0002R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00062"}, d2 = {"Lfm/feed/android/playersdk/OfflineStationManager;", "", "station", "Lfm/feed/android/playersdk/models/Station;", "fileStoragePath", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Lfm/feed/android/playersdk/models/Station;Ljava/lang/String;Landroid/content/SharedPreferences;)V", "audioFiles", "", "Lfm/feed/android/playersdk/models/AudioFile;", "audioFilesAvailable", "getAudioFilesAvailable", "()Ljava/util/List;", "isStationAvailableOffline", "", "()Z", "log", "Lfm/feed/android/playersdk/FMLog;", "nextPlay", "Lfm/feed/android/playersdk/models/Play;", "getNextPlay", "()Lfm/feed/android/playersdk/models/Play;", "playList", "", "sharedPrefKey", "getStation", "()Lfm/feed/android/playersdk/models/Station;", "deleteConfig", "", "deleteFilesForAudioItems", "downloadStation", "stationDownloadListener", "Lfm/feed/android/playersdk/StationDownloadListener;", "getFilePathForId", "Ljava/io/File;", "id", "isFileAvailableOfflineForId", "loadConfig", "randomString", "saveConfig", "shuffleStation", "startNextDownload", "audioFileDownloadList", "Ljava/util/LinkedList;", "pastErrorCount", "", "Companion", "DownloadFilesTask", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class OfflineStationManager {
    private static final String PLAYLIST_SHARED_PREF_KEY = ".playlist";
    private final List<AudioFile> audioFiles;
    private final String fileStoragePath;
    private final FMLog log;
    private List<AudioFile> playList;
    private final String sharedPrefKey;
    private final SharedPreferences sharedPreferences;
    private final Station station;
    private static SecureRandom rnd = new SecureRandom();

    public OfflineStationManager(Station station, String fileStoragePath, SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(station, "station");
        Intrinsics.checkNotNullParameter(fileStoragePath, "fileStoragePath");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.station = station;
        this.fileStoragePath = fileStoragePath;
        this.sharedPreferences = sharedPreferences;
        this.log = new FMLog("fm.feed.OfflineStationManager");
        station.setOfflineType(true);
        this.audioFiles = station.getAudioFiles();
        this.playList = new LinkedList();
        this.sharedPrefKey = Intrinsics.stringPlus(station.getName(), PLAYLIST_SHARED_PREF_KEY);
        loadConfig();
        station.setAudioFiles(null);
    }

    public final Station getStation() {
        return this.station;
    }

    public final boolean isStationAvailableOffline() {
        List<AudioFile> list = this.audioFiles;
        if (list == null) {
            return false;
        }
        int size = list.size();
        Iterator<AudioFile> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (isFileAvailableOfflineForId(it.next().getId())) {
                i++;
            }
        }
        return size > 0 && i > size / 2;
    }

    public final Play getNextPlay() {
        List<AudioFile> list = this.playList;
        if (list == null) {
            return null;
        }
        Iterator<AudioFile> it = list.iterator();
        if (!it.hasNext()) {
            return null;
        }
        AudioFile next = it.next();
        it.remove();
        if (!isFileAvailableOfflineForId(next.getId())) {
            return null;
        }
        Play play = new Play(randomString());
        String absolutePath = getFilePathForId(next.getId()).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getFilePathForId(file.id).absolutePath");
        next.setUrl(absolutePath);
        play.setAudioFile(next);
        play.setStation(getStation());
        saveConfig();
        return play;
    }

    public final List<AudioFile> getAudioFilesAvailable() {
        ArrayList arrayList = new ArrayList();
        List<AudioFile> list = this.audioFiles;
        if (list != null) {
            for (AudioFile audioFile : list) {
                if (isFileAvailableOfflineForId(audioFile.getId())) {
                    arrayList.add(audioFile);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getFilePathForId(String id2) {
        File file = new File(this.fileStoragePath, id2);
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists()) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Unable to make path for local storage. Result = ", parentFile == null ? null : Boolean.valueOf(parentFile.mkdirs())), null, 2, null);
        }
        return file;
    }

    private final boolean isFileAvailableOfflineForId(String id2) {
        return getFilePathForId(id2).exists();
    }

    public final void deleteFilesForAudioItems(List<AudioFile> audioFiles) {
        Intrinsics.checkNotNullParameter(audioFiles, "audioFiles");
        for (AudioFile audioFile : audioFiles) {
            File filePathForId = getFilePathForId(audioFile.getId());
            if (filePathForId.exists()) {
                if (filePathForId.delete()) {
                    FMLog.d$default(this.log, "Deleted audio file " + audioFile + " at path " + filePathForId, null, 2, null);
                } else {
                    FMLog.e$default(this.log, "Unable to delete audio file " + audioFile + " at path " + filePathForId, null, 2, null);
                }
            } else {
                FMLog.w$default(this.log, "local file for " + audioFile + " does not seem to exist. Deleting, so ignoring.", null, 2, null);
            }
        }
    }

    public final void shuffleStation() {
        List<AudioFile> list = this.audioFiles;
        if (list == null) {
            return;
        }
        List<AudioFile> list2 = this.playList;
        if (list2 != null) {
            list2.clear();
        }
        List<AudioFile> list3 = this.playList;
        if (list3 != null) {
            list3.addAll(list);
        }
        List<AudioFile> list4 = this.playList;
        if (list4 == null) {
            return;
        }
        Collections.shuffle(list4);
    }

    private final void saveConfig() {
        this.sharedPreferences.edit().putString(this.sharedPrefKey, new Gson().toJson(this.playList)).apply();
    }

    private final void loadConfig() {
        Gson gson = new Gson();
        if (this.sharedPreferences.contains(this.sharedPrefKey)) {
            List<AudioFile> list = (List) gson.fromJson(this.sharedPreferences.getString(this.sharedPrefKey, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), new TypeToken<LinkedList<AudioFile>>() { // from class: fm.feed.android.playersdk.OfflineStationManager.loadConfig.1
            }.getType());
            this.playList = list;
            if (list != null && list.size() > 0) {
                return;
            }
        }
        shuffleStation();
    }

    public final void deleteConfig() {
        String str = this.sharedPrefKey;
        if (this.sharedPreferences.contains(str)) {
            this.sharedPreferences.edit().remove(str).apply();
        }
    }

    private final String randomString() {
        StringBuilder sb = new StringBuilder(8);
        int i = 0;
        do {
            i++;
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(rnd.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZ".length())));
        } while (i <= 7);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final void downloadStation(StationDownloadListener stationDownloadListener) {
        Intrinsics.checkNotNullParameter(stationDownloadListener, "stationDownloadListener");
        LinkedList<AudioFile> linkedList = new LinkedList<>();
        List<AudioFile> list = this.audioFiles;
        if (list == null) {
            return;
        }
        linkedList.addAll(list);
        startNextDownload(linkedList, stationDownloadListener, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startNextDownload(LinkedList<AudioFile> audioFileDownloadList, StationDownloadListener stationDownloadListener, int pastErrorCount) {
        List<AudioFile> list = this.audioFiles;
        if (list == null) {
            return;
        }
        stationDownloadListener.onDownloadProgress(getStation(), list.size(), audioFileDownloadList.size(), pastErrorCount);
        if (audioFileDownloadList.size() == 0) {
            return;
        }
        try {
            AudioFile audioFileRemoveLast = audioFileDownloadList.removeLast();
            new DownloadFilesTask(this, audioFileDownloadList, stationDownloadListener, pastErrorCount).execute(audioFileRemoveLast.getUrl(), audioFileRemoveLast.getId());
        } catch (Exception e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Station download failed", e), null, 2, null);
            stationDownloadListener.onDownloadProgress(getStation(), this.audioFiles.size(), 0, pastErrorCount + audioFileDownloadList.size() + 1);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* compiled from: OfflineStationManager.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0083\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\r\"\u00020\u0002H\u0014¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0014J%\u0010\u0013\u001a\u00020\u00102\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\r\"\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lfm/feed/android/playersdk/OfflineStationManager$DownloadFilesTask;", "Landroid/os/AsyncTask;", "", "", "audioFileDownloadList", "Ljava/util/LinkedList;", "Lfm/feed/android/playersdk/models/AudioFile;", "stationDownloadListener", "Lfm/feed/android/playersdk/StationDownloadListener;", "pastErrorCount", "(Lfm/feed/android/playersdk/OfflineStationManager;Ljava/util/LinkedList;Lfm/feed/android/playersdk/StationDownloadListener;I)V", "doInBackground", "info", "", "([Ljava/lang/String;)Ljava/lang/String;", "onCancelled", "", "result", "onPostExecute", "onProgressUpdate", "progress", "([Ljava/lang/Integer;)V", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class DownloadFilesTask extends AsyncTask<String, Integer, String> {
        private final LinkedList<AudioFile> audioFileDownloadList;
        private int pastErrorCount;
        private final StationDownloadListener stationDownloadListener;
        final /* synthetic */ OfflineStationManager this$0;

        public DownloadFilesTask(OfflineStationManager this$0, LinkedList<AudioFile> audioFileDownloadList, StationDownloadListener stationDownloadListener, int i) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(audioFileDownloadList, "audioFileDownloadList");
            Intrinsics.checkNotNullParameter(stationDownloadListener, "stationDownloadListener");
            this.this$0 = this$0;
            this.audioFileDownloadList = audioFileDownloadList;
            this.stationDownloadListener = stationDownloadListener;
            this.pastErrorCount = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
        
            if (r7 != null) goto L116;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
        
            r7.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
        
            r8.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0097, code lost:
        
            if (r7 != null) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x009a, code lost:
        
            r7.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a1, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00a3, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0109, code lost:
        
            r3.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x010f, code lost:
        
            r15.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0115, code lost:
        
            r4.disconnect();
         */
        /* JADX WARN: Removed duplicated region for block: B:100:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:130:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x010f A[Catch: IOException -> 0x0112, TRY_LEAVE, TryCatch #5 {IOException -> 0x0112, blocks: (B:83:0x0109, B:86:0x010f), top: B:106:0x0109 }] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0123 A[Catch: IOException -> 0x0126, TRY_LEAVE, TryCatch #10 {IOException -> 0x0126, blocks: (B:94:0x011d, B:97:0x0123), top: B:108:0x011d }] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String doInBackground(java.lang.String... r17) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 301
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.OfflineStationManager.DownloadFilesTask.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... progress) {
            Intrinsics.checkNotNullParameter(progress, "progress");
            FMLog.d$default(this.this$0.log, Intrinsics.stringPlus("Progress = ", progress[0]), null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            if (result != null) {
                this.pastErrorCount++;
                FMLog.e$default(this.this$0.log, Intrinsics.stringPlus("Download task error result = ", result), null, 2, null);
            }
            this.this$0.startNextDownload(this.audioFileDownloadList, this.stationDownloadListener, this.pastErrorCount);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled(String result) {
            Intrinsics.checkNotNullParameter(result, "result");
            FMLog.i$default(this.this$0.log, "Download task cancelled", null, 2, null);
        }
    }
}
