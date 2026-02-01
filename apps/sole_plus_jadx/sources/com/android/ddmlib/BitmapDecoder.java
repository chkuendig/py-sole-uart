package com.android.ddmlib;

import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableMap;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.Map;

/* loaded from: classes3.dex */
public class BitmapDecoder {
    public static final String BITMAP_DRAWABLE_FQCN = "android.graphics.drawable.BitmapDrawable";
    public static final String BITMAP_FQCN = "android.graphics.Bitmap";
    private static final int MAX_DIMENSION = 1024;
    protected static final Map<String, BitmapExtractor> SUPPORTED_FORMATS;

    public interface BitmapDataProvider {
        boolean downsizeBitmap(Dimension newSize) throws Exception;

        String getBitmapConfigName() throws Exception;

        Dimension getDimension() throws Exception;

        byte[] getPixelBytes(Dimension size) throws Exception;
    }

    private interface BitmapExtractor {
        BufferedImage getImage(int w, int h, byte[] data);
    }

    static {
        SUPPORTED_FORMATS = ImmutableMap.of("\"ARGB_8888\"", (ALPHA8_BitmapExtractor) new ARGB8888_BitmapExtractor(), "\"RGB_565\"", (ALPHA8_BitmapExtractor) new RGB565_BitmapExtractor(), "\"ALPHA_8\"", new ALPHA8_BitmapExtractor());
    }

    public static BufferedImage getBitmap(BitmapDataProvider dataProvider) throws Exception {
        String bitmapConfigName = dataProvider.getBitmapConfigName();
        if (bitmapConfigName == null) {
            throw new RuntimeException("Unable to determine bitmap configuration");
        }
        BitmapExtractor bitmapExtractor = SUPPORTED_FORMATS.get(bitmapConfigName);
        if (bitmapExtractor == null) {
            throw new RuntimeException("Unsupported bitmap configuration: " + bitmapConfigName);
        }
        Dimension dimension = dataProvider.getDimension();
        if (dimension == null) {
            throw new RuntimeException("Unable to determine image dimensions.");
        }
        if (dimension.width > 1024 || dimension.height > 1024) {
            if (!dataProvider.downsizeBitmap(dimension)) {
                throw new RuntimeException("Unable to create scaled bitmap");
            }
            dimension = dataProvider.getDimension();
            if (dimension == null) {
                throw new RuntimeException("Unable to obtained scaled bitmap's dimensions");
            }
        }
        return bitmapExtractor.getImage(dimension.width, dimension.height, dataProvider.getPixelBytes(dimension));
    }

    private static class ARGB8888_BitmapExtractor implements BitmapExtractor {
        private ARGB8888_BitmapExtractor() {
        }

        @Override // com.android.ddmlib.BitmapDecoder.BitmapExtractor
        public BufferedImage getImage(int width, int height, byte[] rgba) {
            BufferedImage bufferedImage = new BufferedImage(width, height, 2);
            for (int i = 0; i < height; i++) {
                int i2 = i * width;
                for (int i3 = 0; i3 < width; i3++) {
                    int i4 = (i2 + i3) * 4;
                    bufferedImage.setRGB(i3, i, (int) ((((rgba[i4] & 255) << 16) | ((rgba[i4 + 1] & 255) << 8) | (rgba[i4 + 2] & 255) | ((255 & rgba[i4 + 3]) << 24)) & 4294967295L));
                }
            }
            return bufferedImage;
        }
    }

    private static class RGB565_BitmapExtractor implements BitmapExtractor {
        private RGB565_BitmapExtractor() {
        }

        @Override // com.android.ddmlib.BitmapDecoder.BitmapExtractor
        public BufferedImage getImage(int width, int height, byte[] rgb) {
            BufferedImage bufferedImage = new BufferedImage(width, height, 2);
            for (int i = 0; i < height; i++) {
                int i2 = i * width;
                for (int i3 = 0; i3 < width; i3++) {
                    int i4 = (i2 + i3) * 2;
                    int i5 = ((rgb[i4 + 1] << 8) & 65280) | (rgb[i4] & 255);
                    bufferedImage.setRGB(i3, i, (((i5 & 31) * 255) / 31) | (((((i5 >>> 11) & 31) * 255) / 31) << 16) | (-16777216) | (((((i5 >>> 5) & 63) * 255) / 63) << 8));
                }
            }
            return bufferedImage;
        }
    }

    private static class ALPHA8_BitmapExtractor implements BitmapExtractor {
        private ALPHA8_BitmapExtractor() {
        }

        @Override // com.android.ddmlib.BitmapDecoder.BitmapExtractor
        public BufferedImage getImage(int width, int height, byte[] rgb) {
            BufferedImage bufferedImage = new BufferedImage(width, height, 2);
            for (int i = 0; i < height; i++) {
                int i2 = i * width;
                for (int i3 = 0; i3 < width; i3++) {
                    bufferedImage.setRGB(i3, i, (rgb[i2 + i3] << Ascii.CAN) | 16777215);
                }
            }
            return bufferedImage;
        }
    }
}
