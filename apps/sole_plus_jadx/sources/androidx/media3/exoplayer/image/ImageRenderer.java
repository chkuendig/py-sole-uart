package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.image.ImageDecoder;
import androidx.media3.exoplayer.source.MediaSource;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes3.dex */
public final class ImageRenderer extends BaseRenderer {
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM_THEN_WAIT = 2;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 3;
    private static final String TAG = "ImageRenderer";
    private ImageDecoder decoder;
    private final ImageDecoder.Factory decoderFactory;
    private int decoderReinitializationState;
    private int firstFrameState;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private final ImageOutput imageOutput;
    private DecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private final LongArrayQueue offsetQueue;
    private ImageOutputBuffer outputBuffer;
    private boolean outputStreamEnded;

    public ImageRenderer(ImageDecoder.Factory factory, ImageOutput imageOutput) {
        super(4);
        this.decoderFactory = factory;
        this.imageOutput = imageOutput;
        this.flagsOnlyBuffer = DecoderInputBuffer.newNoDataInstance();
        this.offsetQueue = new LongArrayQueue();
        this.decoderReinitializationState = 0;
        this.firstFrameState = 1;
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public String getName() {
        return TAG;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public int supportsFormat(Format format) {
        return this.decoderFactory.supportsFormat(format);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            return;
        }
        Assertions.checkState(!this.offsetQueue.isEmpty());
        if (this.inputFormat == null) {
            FormatHolder formatHolder = getFormatHolder();
            this.flagsOnlyBuffer.clear();
            int source = readSource(formatHolder, this.flagsOnlyBuffer, 2);
            if (source != -5) {
                if (source == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                    return;
                }
                return;
            }
            this.inputFormat = (Format) Assertions.checkNotNull(formatHolder.format);
            initDecoder();
        }
        try {
            TraceUtil.beginSection("drainAndFeedDecoder");
            while (drainOutputBuffer(j, j2)) {
            }
            while (feedInputBuffer()) {
            }
            TraceUtil.endSection();
        } catch (ImageDecoderException e) {
            throw createRendererException(e, null, 4003);
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        int i = this.firstFrameState;
        return i == 3 || (i == 0 && this.outputBuffer != null);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onEnabled(boolean z, boolean z2) {
        this.firstFrameState = z2 ? 1 : 0;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        super.onStreamChanged(formatArr, j, j2, mediaPeriodId);
        this.offsetQueue.add(j2);
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onPositionReset(long j, boolean z) {
        lowerFirstFrameState(1);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onDisabled() {
        this.offsetQueue.clear();
        this.inputFormat = null;
        releaseDecoderResources();
        this.imageOutput.onDisabled();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onReset() {
        this.offsetQueue.clear();
        releaseDecoderResources();
        lowerFirstFrameState(1);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onRelease() {
        this.offsetQueue.clear();
        releaseDecoderResources();
    }

    private boolean drainOutputBuffer(long j, long j2) throws ExoPlaybackException, ImageDecoderException {
        if (this.outputBuffer == null) {
            Assertions.checkStateNotNull(this.decoder);
            ImageOutputBuffer imageOutputBufferDequeueOutputBuffer = this.decoder.dequeueOutputBuffer();
            this.outputBuffer = imageOutputBufferDequeueOutputBuffer;
            if (imageOutputBufferDequeueOutputBuffer == null) {
                return false;
            }
        }
        if (this.firstFrameState == 0 && getState() != 2) {
            return false;
        }
        if (((ImageOutputBuffer) Assertions.checkNotNull(this.outputBuffer)).isEndOfStream()) {
            this.offsetQueue.remove();
            if (this.decoderReinitializationState == 3) {
                releaseDecoderResources();
                Assertions.checkStateNotNull(this.inputFormat);
                initDecoder();
            } else {
                ((ImageOutputBuffer) Assertions.checkNotNull(this.outputBuffer)).release();
                this.outputBuffer = null;
                if (this.offsetQueue.isEmpty()) {
                    this.outputStreamEnded = true;
                }
            }
            return false;
        }
        Assertions.checkStateNotNull(this.outputBuffer);
        if (!processOutputBuffer(j, j2)) {
            return false;
        }
        this.firstFrameState = 3;
        return true;
    }

    @RequiresNonNull({"outputBuffer"})
    private boolean processOutputBuffer(long j, long j2) {
        Bitmap bitmap = (Bitmap) Assertions.checkNotNull(this.outputBuffer.bitmap, "Non-EOS buffer came back from the decoder without bitmap.");
        if (j < this.outputBuffer.timeUs) {
            return false;
        }
        this.imageOutput.onImageAvailable(this.outputBuffer.timeUs - this.offsetQueue.element(), bitmap);
        ((ImageOutputBuffer) Assertions.checkNotNull(this.outputBuffer)).release();
        this.outputBuffer = null;
        return true;
    }

    private boolean feedInputBuffer() throws ImageDecoderException {
        FormatHolder formatHolder = getFormatHolder();
        ImageDecoder imageDecoder = this.decoder;
        if (imageDecoder == null || this.decoderReinitializationState == 3 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            DecoderInputBuffer decoderInputBufferDequeueInputBuffer = imageDecoder.dequeueInputBuffer();
            this.inputBuffer = decoderInputBufferDequeueInputBuffer;
            if (decoderInputBufferDequeueInputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 2) {
            Assertions.checkStateNotNull(this.inputBuffer);
            this.inputBuffer.setFlags(4);
            ((ImageDecoder) Assertions.checkNotNull(this.decoder)).queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 3;
            return false;
        }
        int source = readSource(formatHolder, this.inputBuffer, 0);
        if (source == -5) {
            this.inputFormat = (Format) Assertions.checkNotNull(formatHolder.format);
            this.decoderReinitializationState = 2;
            return true;
        }
        if (source != -4) {
            if (source == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        this.inputBuffer.flip();
        ((ImageDecoder) Assertions.checkNotNull(this.decoder)).queueInputBuffer(this.inputBuffer);
        if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.inputBuffer = null;
            return false;
        }
        this.inputBuffer = null;
        return true;
    }

    @EnsuresNonNull({"decoder"})
    @RequiresNonNull({"inputFormat"})
    private void initDecoder() throws ExoPlaybackException {
        if (canCreateDecoderForFormat(this.inputFormat)) {
            ImageDecoder imageDecoder = this.decoder;
            if (imageDecoder != null) {
                imageDecoder.release();
            }
            this.decoder = this.decoderFactory.createImageDecoder();
            return;
        }
        throw createRendererException(new ImageDecoderException("Provided decoder factory can't create decoder for format."), this.inputFormat, 4005);
    }

    private boolean canCreateDecoderForFormat(Format format) {
        int iSupportsFormat = this.decoderFactory.supportsFormat(format);
        return iSupportsFormat == RendererCapabilities.create(4) || iSupportsFormat == RendererCapabilities.create(3);
    }

    private void lowerFirstFrameState(int i) {
        this.firstFrameState = Math.min(this.firstFrameState, i);
    }

    private void releaseDecoderResources() {
        this.inputBuffer = null;
        ImageOutputBuffer imageOutputBuffer = this.outputBuffer;
        if (imageOutputBuffer != null) {
            imageOutputBuffer.release();
        }
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        ImageDecoder imageDecoder = this.decoder;
        if (imageDecoder != null) {
            imageDecoder.release();
            this.decoder = null;
        }
    }
}
