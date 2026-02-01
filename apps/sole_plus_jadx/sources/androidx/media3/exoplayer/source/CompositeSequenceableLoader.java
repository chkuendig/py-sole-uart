package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.LoadingInfo;

/* loaded from: classes3.dex */
public class CompositeSequenceableLoader implements SequenceableLoader {
    protected final SequenceableLoader[] loaders;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this.loaders = sequenceableLoaderArr;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (SequenceableLoader sequenceableLoader : this.loaders) {
            long bufferedPositionUs = sequenceableLoader.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, bufferedPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (SequenceableLoader sequenceableLoader : this.loaders) {
            long nextLoadPositionUs = sequenceableLoader.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, nextLoadPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
        for (SequenceableLoader sequenceableLoader : this.loaders) {
            sequenceableLoader.reevaluateBuffer(j);
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public boolean continueLoading(LoadingInfo loadingInfo) {
        boolean zContinueLoading;
        boolean z = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            long j = Long.MIN_VALUE;
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            SequenceableLoader[] sequenceableLoaderArr = this.loaders;
            int length = sequenceableLoaderArr.length;
            int i = 0;
            zContinueLoading = false;
            while (i < length) {
                SequenceableLoader sequenceableLoader = sequenceableLoaderArr[i];
                long nextLoadPositionUs2 = sequenceableLoader.getNextLoadPositionUs();
                boolean z2 = nextLoadPositionUs2 != j && nextLoadPositionUs2 <= loadingInfo.playbackPositionUs;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z2) {
                    zContinueLoading |= sequenceableLoader.continueLoading(loadingInfo);
                }
                i++;
                j = Long.MIN_VALUE;
            }
            z |= zContinueLoading;
        } while (zContinueLoading);
        return z;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public boolean isLoading() {
        for (SequenceableLoader sequenceableLoader : this.loaders) {
            if (sequenceableLoader.isLoading()) {
                return true;
            }
        }
        return false;
    }
}
