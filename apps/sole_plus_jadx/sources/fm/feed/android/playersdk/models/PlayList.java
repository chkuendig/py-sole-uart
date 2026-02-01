package fm.feed.android.playersdk.models;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;

/* compiled from: PlayList.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006 "}, d2 = {"Lfm/feed/android/playersdk/models/PlayList;", "", "()V", "currentPlayList", "", "Lfm/feed/android/playersdk/models/AudioFile;", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "id", "getId", "setId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lfm/feed/android/playersdk/models/PlayList$PlayListListener;", "getListener", "()Lfm/feed/android/playersdk/models/PlayList$PlayListListener;", "setListener", "(Lfm/feed/android/playersdk/models/PlayList$PlayListListener;)V", "name", "getName", "setName", "first", "isEmpty", "", "isNotEmpty", "toList", "", "Editor", "PlayListListener", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class PlayList {
    private List<AudioFile> currentPlayList = new ArrayList();
    private String description;
    public String id;
    private PlayListListener listener;
    public String name;

    /* compiled from: PlayList.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lfm/feed/android/playersdk/models/PlayList$PlayListListener;", "", "onPlaylistChanged", "", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface PlayListListener {
        void onPlaylistChanged();
    }

    public final String getId() {
        String str = this.id;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("id");
        return null;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
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

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final PlayListListener getListener() {
        return this.listener;
    }

    public final void setListener(PlayListListener playListListener) {
        this.listener = playListListener;
    }

    public final boolean isEmpty() {
        return this.currentPlayList.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.currentPlayList.isEmpty();
    }

    public final AudioFile first() {
        return (AudioFile) CollectionsKt.first((List) this.currentPlayList);
    }

    public final List<AudioFile> toList() {
        return CollectionsKt.toList(this.currentPlayList);
    }

    /* compiled from: PlayList.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0004J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\b¨\u0006\u0011"}, d2 = {"Lfm/feed/android/playersdk/models/PlayList$Editor;", "", "(Lfm/feed/android/playersdk/models/PlayList;)V", "addToPlayList", "", "file", "Lfm/feed/android/playersdk/models/AudioFile;", "activePlayList", "", "clearPlayList", "moveItemToIndex", "audioFile", "pos", "", "removeFromPlaylist", "shufflePlaylist", "viewCurrentPlayList", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class Editor {
        final /* synthetic */ PlayList this$0;

        public Editor(PlayList this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        public final List<AudioFile> viewCurrentPlayList() {
            return CollectionsKt.toList(this.this$0.currentPlayList);
        }

        public final void clearPlayList() {
            this.this$0.currentPlayList.clear();
            PlayListListener listener = this.this$0.getListener();
            if (listener == null) {
                return;
            }
            listener.onPlaylistChanged();
        }

        public final void addToPlayList(AudioFile file) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.this$0.currentPlayList.add(file);
            PlayListListener listener = this.this$0.getListener();
            if (listener == null) {
                return;
            }
            listener.onPlaylistChanged();
        }

        public final void addToPlayList(List<AudioFile> activePlayList) {
            Intrinsics.checkNotNullParameter(activePlayList, "activePlayList");
            this.this$0.currentPlayList.addAll(activePlayList);
            PlayListListener listener = this.this$0.getListener();
            if (listener == null) {
                return;
            }
            listener.onPlaylistChanged();
        }

        public final void removeFromPlaylist(AudioFile audioFile) {
            Intrinsics.checkNotNullParameter(audioFile, "audioFile");
            Iterator it = this.this$0.currentPlayList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual((AudioFile) it.next(), audioFile)) {
                    this.this$0.currentPlayList.remove(audioFile);
                    PlayListListener listener = this.this$0.getListener();
                    if (listener == null) {
                        return;
                    }
                    listener.onPlaylistChanged();
                    return;
                }
            }
        }

        public final void moveItemToIndex(AudioFile audioFile, int pos) {
            Integer numValueOf;
            Intrinsics.checkNotNullParameter(audioFile, "audioFile");
            Iterator it = this.this$0.currentPlayList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    numValueOf = null;
                    break;
                }
                int i2 = i + 1;
                if (Intrinsics.areEqual((AudioFile) it.next(), audioFile)) {
                    numValueOf = Integer.valueOf(i);
                    break;
                }
                i = i2;
            }
            if (numValueOf != null) {
                this.this$0.currentPlayList.remove(numValueOf.intValue());
                this.this$0.currentPlayList.add(pos, audioFile);
            }
            PlayListListener listener = this.this$0.getListener();
            if (listener == null) {
                return;
            }
            listener.onPlaylistChanged();
        }

        public final void shufflePlaylist() {
            Random Random = RandomKt.Random(new java.util.Random().nextInt());
            PlayList playList = this.this$0;
            playList.currentPlayList = CollectionsKt.toMutableList((Collection) CollectionsKt.shuffled(playList.currentPlayList, Random));
            PlayListListener listener = this.this$0.getListener();
            if (listener == null) {
                return;
            }
            listener.onPlaylistChanged();
        }
    }
}
