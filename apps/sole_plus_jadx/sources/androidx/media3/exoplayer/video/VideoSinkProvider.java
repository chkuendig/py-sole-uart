package androidx.media3.exoplayer.video;

import android.view.Surface;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.util.Size;
import androidx.media3.exoplayer.video.VideoSink;
import java.util.List;

/* loaded from: classes3.dex */
interface VideoSinkProvider {
    void clearOutputSurfaceInfo();

    VideoSink getSink();

    void initialize(Format format) throws VideoSink.VideoSinkException;

    boolean isInitialized();

    void release();

    void setOutputSurfaceInfo(Surface surface, Size size);

    void setStreamOffsetUs(long j);

    void setVideoEffects(List<Effect> list);

    void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);
}
