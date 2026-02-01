package androidx.media3.exoplayer.video;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.TimestampIterator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
interface VideoSink {
    public static final int INPUT_TYPE_BITMAP = 2;
    public static final int INPUT_TYPE_SURFACE = 1;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputType {
    }

    public interface Listener {
        void onError(VideoSink videoSink, VideoSinkException videoSinkException);

        void onFirstFrameRendered(VideoSink videoSink);

        void onVideoSizeChanged(VideoSink videoSink, VideoSize videoSize);
    }

    public interface RenderControl {
        public static final long RENDER_TIME_DROP = -2;
        public static final long RENDER_TIME_IMMEDIATELY = -1;
        public static final long RENDER_TIME_TRY_AGAIN_LATER = -3;

        long getFrameRenderTimeNs(long j, long j2, long j3, float f);

        void onFrameDropped();

        void onFrameRendered();

        void onNextFrame(long j);
    }

    void flush();

    Surface getInputSurface();

    boolean isEnded();

    boolean isFrameDropAllowedOnInput();

    boolean isReady();

    boolean queueBitmap(Bitmap bitmap, TimestampIterator timestampIterator);

    long registerInputFrame(long j, boolean z);

    void registerInputStream(int i, Format format);

    void render(long j, long j2);

    void setListener(Listener listener, Executor executor);

    void setPlaybackSpeed(float f);

    public static final class VideoSinkException extends Exception {
        public final Format format;

        public VideoSinkException(Throwable th, Format format) {
            super(th);
            this.format = format;
        }
    }
}
