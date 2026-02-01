package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.image.ImageDecoder;
import com.google.common.collect.ImmutableSet;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class BitmapFactoryImageDecoder extends SimpleDecoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> implements ImageDecoder {
    private final BitmapDecoder bitmapDecoder;

    public interface BitmapDecoder {
        Bitmap decode(byte[] bArr, int i) throws ImageDecoderException;
    }

    @Override // androidx.media3.decoder.SimpleDecoder, androidx.media3.decoder.Decoder
    public /* bridge */ /* synthetic */ ImageOutputBuffer dequeueOutputBuffer() throws ImageDecoderException {
        return (ImageOutputBuffer) super.dequeueOutputBuffer();
    }

    public static final class Factory implements ImageDecoder.Factory {
        private static final ImmutableSet<String> SUPPORTED_IMAGE_TYPES = getSupportedMimeTypes();
        private final BitmapDecoder bitmapDecoder;

        public Factory() {
            this.bitmapDecoder = new BitmapDecoder() { // from class: androidx.media3.exoplayer.image.BitmapFactoryImageDecoder$Factory$$ExternalSyntheticLambda0
                @Override // androidx.media3.exoplayer.image.BitmapFactoryImageDecoder.BitmapDecoder
                public final Bitmap decode(byte[] bArr, int i) {
                    return BitmapFactoryImageDecoder.decode(bArr, i);
                }
            };
        }

        public Factory(BitmapDecoder bitmapDecoder) {
            this.bitmapDecoder = bitmapDecoder;
        }

        @Override // androidx.media3.exoplayer.image.ImageDecoder.Factory
        public int supportsFormat(Format format) {
            if (!MimeTypes.isImage(format.containerMimeType)) {
                return RendererCapabilities.create(0);
            }
            if (format.tileCountHorizontal != 1 || format.tileCountVertical != 1) {
                return RendererCapabilities.create(3);
            }
            if (SUPPORTED_IMAGE_TYPES.contains(format.containerMimeType)) {
                return RendererCapabilities.create(4);
            }
            return RendererCapabilities.create(1);
        }

        @Override // androidx.media3.exoplayer.image.ImageDecoder.Factory
        public BitmapFactoryImageDecoder createImageDecoder() {
            return new BitmapFactoryImageDecoder(this.bitmapDecoder);
        }

        private static ImmutableSet<String> getSupportedMimeTypes() {
            ImmutableSet.Builder builder = ImmutableSet.builder();
            builder.add((Object[]) new String[]{"image/png", "image/jpeg", MimeTypes.IMAGE_BMP, "image/webp"});
            if (Util.SDK_INT >= 26) {
                builder.add((ImmutableSet.Builder) "image/heif");
            }
            return builder.build();
        }
    }

    private BitmapFactoryImageDecoder(BitmapDecoder bitmapDecoder) {
        super(new DecoderInputBuffer[1], new ImageOutputBuffer[1]);
        this.bitmapDecoder = bitmapDecoder;
    }

    @Override // androidx.media3.decoder.Decoder
    public String getName() {
        return "BitmapFactoryImageDecoder";
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    protected DecoderInputBuffer createInputBuffer() {
        return new DecoderInputBuffer(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    public ImageOutputBuffer createOutputBuffer() {
        return new ImageOutputBuffer() { // from class: androidx.media3.exoplayer.image.BitmapFactoryImageDecoder.1
            @Override // androidx.media3.decoder.DecoderOutputBuffer
            public void release() {
                BitmapFactoryImageDecoder.this.releaseOutputBuffer(this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    public ImageDecoderException createUnexpectedDecodeException(Throwable th) {
        return new ImageDecoderException("Unexpected decode error", th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    public ImageDecoderException decode(DecoderInputBuffer decoderInputBuffer, ImageOutputBuffer imageOutputBuffer, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data);
            Assertions.checkState(byteBuffer.hasArray());
            Assertions.checkArgument(byteBuffer.arrayOffset() == 0);
            imageOutputBuffer.bitmap = this.bitmapDecoder.decode(byteBuffer.array(), byteBuffer.remaining());
            imageOutputBuffer.timeUs = decoderInputBuffer.timeUs;
            return null;
        } catch (ImageDecoderException e) {
            return e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap decode(byte[] bArr, int i) throws IOException, ImageDecoderException {
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, i);
        if (bitmapDecodeByteArray == null) {
            throw new ImageDecoderException("Could not decode image data with BitmapFactory. (data.length = " + bArr.length + ", input length = " + i + ")");
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i);
            try {
                ExifInterface exifInterface = new ExifInterface(byteArrayInputStream);
                byteArrayInputStream.close();
                int rotationDegrees = exifInterface.getRotationDegrees();
                if (rotationDegrees == 0) {
                    return bitmapDecodeByteArray;
                }
                Matrix matrix = new Matrix();
                matrix.postRotate(rotationDegrees);
                return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
            } finally {
            }
        } catch (IOException e) {
            throw new ImageDecoderException(e);
        }
    }
}
