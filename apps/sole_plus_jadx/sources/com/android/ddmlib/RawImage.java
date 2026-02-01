package com.android.ddmlib;

import com.sun.jna.platform.win32.Winspool;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Hashtable;

/* loaded from: classes3.dex */
public final class RawImage {
    public static final int COLOR_SPACE_DISPLAY_P3 = 2;
    public static final int COLOR_SPACE_SRGB = 1;
    public static final int COLOR_SPACE_UNKNOWN = 0;
    public int alpha_length;
    public int alpha_offset;
    public int blue_length;
    public int blue_offset;
    public int bpp;
    public int colorSpace;
    public byte[] data;
    public int green_length;
    public int green_offset;
    public int height;
    public int red_length;
    public int red_offset;
    public int size;
    public int version;
    public int width;

    public static int getHeaderSize(int version) {
        if (version == 1) {
            return 12;
        }
        if (version != 2) {
            return version != 16 ? 0 : 3;
        }
        return 13;
    }

    private static int getMask(int length) {
        return (1 << length) - 1;
    }

    public boolean readHeader(int version, ByteBuffer buf) {
        this.version = version;
        if (version == 16) {
            this.bpp = 16;
            this.size = buf.getInt();
            this.width = buf.getInt();
            this.height = buf.getInt();
            this.red_offset = 11;
            this.red_length = 5;
            this.green_offset = 5;
            this.green_length = 6;
            this.blue_offset = 0;
            this.blue_length = 5;
            this.alpha_offset = 0;
            this.alpha_length = 0;
        } else {
            if (version != 1 && version != 2) {
                return false;
            }
            this.bpp = buf.getInt();
            if (version == 2) {
                this.colorSpace = buf.getInt();
            }
            this.size = buf.getInt();
            this.width = buf.getInt();
            this.height = buf.getInt();
            this.red_offset = buf.getInt();
            this.red_length = buf.getInt();
            this.blue_offset = buf.getInt();
            this.blue_length = buf.getInt();
            this.green_offset = buf.getInt();
            this.green_length = buf.getInt();
            this.alpha_offset = buf.getInt();
            this.alpha_length = buf.getInt();
        }
        return true;
    }

    public int getRedMask() {
        return getMask(this.red_length, this.red_offset);
    }

    public int getGreenMask() {
        return getMask(this.green_length, this.green_offset);
    }

    public int getBlueMask() {
        return getMask(this.blue_length, this.blue_offset);
    }

    public RawImage getRotated() {
        RawImage rawImage = new RawImage();
        rawImage.version = this.version;
        rawImage.bpp = this.bpp;
        rawImage.colorSpace = this.colorSpace;
        rawImage.size = this.size;
        rawImage.red_offset = this.red_offset;
        rawImage.red_length = this.red_length;
        rawImage.blue_offset = this.blue_offset;
        rawImage.blue_length = this.blue_length;
        rawImage.green_offset = this.green_offset;
        rawImage.green_length = this.green_length;
        rawImage.alpha_offset = this.alpha_offset;
        rawImage.alpha_length = this.alpha_length;
        rawImage.width = this.height;
        int i = this.width;
        rawImage.height = i;
        rawImage.data = new byte[this.data.length];
        int i2 = this.bpp >> 3;
        int i3 = this.height;
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                System.arraycopy(this.data, ((i4 * i) + i5) * i2, rawImage.data, ((((i - i5) - 1) * i3) + i4) * i2, i2);
            }
        }
        return rawImage;
    }

    public int getARGB(int index) {
        int mask;
        int mask2;
        int i;
        int i2 = this.bpp;
        int mask3 = 255;
        if (i2 == 16) {
            byte[] bArr = this.data;
            int i3 = ((bArr[index + 1] << 8) & 65280) | (bArr[index] & 255);
            mask = (((i3 >>> 11) & 31) * 255) / 31;
            mask2 = (((i3 >>> 5) & 63) * 255) / 63;
            i = ((i3 & 31) * 255) / 31;
        } else if (i2 == 32) {
            byte[] bArr2 = this.data;
            int i4 = ((bArr2[index + 3] & 255) << 24) | (bArr2[index] & 255) | ((bArr2[index + 1] & 255) << 8) | ((bArr2[index + 2] & 255) << 16);
            mask = ((i4 >>> this.red_offset) & getMask(this.red_length)) << (8 - this.red_length);
            mask2 = ((i4 >>> this.green_offset) & getMask(this.green_length)) << (8 - this.green_length);
            int mask4 = ((i4 >>> this.blue_offset) & getMask(this.blue_length)) << (8 - this.blue_length);
            mask3 = ((i4 >>> this.alpha_offset) & getMask(this.alpha_length)) << (8 - this.alpha_length);
            i = mask4;
        } else {
            throw new UnsupportedOperationException("RawImage.getARGB(int) only works in 16 and 32 bit mode.");
        }
        return i | (mask << 16) | (mask3 << 24) | (mask2 << 8);
    }

    public BufferedImage asBufferedImage() {
        BufferedImage bufferedImage;
        String profileName = getProfileName();
        if (profileName == null) {
            bufferedImage = new BufferedImage(this.width, this.height, 2);
        } else {
            ICC_Profile iCC_Profile = ICC_Profile.getInstance(1000);
            try {
                iCC_Profile = ICC_Profile.getInstance(getClass().getClassLoader().getResourceAsStream("colorProfiles/" + profileName));
            } catch (IOException unused) {
            }
            DirectColorModel directColorModel = new DirectColorModel(new ICC_ColorSpace(iCC_Profile), 32, Winspool.PRINTER_ENUM_ICONMASK, 65280, 255, -16777216, false, 3);
            bufferedImage = new BufferedImage(directColorModel, directColorModel.createCompatibleWritableRaster(this.width, this.height), directColorModel.isAlphaPremultiplied(), (Hashtable) null);
        }
        for (int i = 0; i < this.height; i++) {
            int i2 = 0;
            while (true) {
                int i3 = this.width;
                if (i2 < i3) {
                    bufferedImage.setRGB(i2, i, getARGB(((i3 * i) + i2) * (this.bpp / 8)));
                    i2++;
                }
            }
        }
        return bufferedImage;
    }

    public String getProfileName() {
        int i = this.colorSpace;
        if (i == 1) {
            return "sRGB.icc";
        }
        if (i != 2) {
            return null;
        }
        return "DisplayP3.icc";
    }

    private int getMask(int length, int offset) {
        int mask = getMask(length) << offset;
        return this.bpp == 32 ? Integer.reverseBytes(mask) : mask;
    }
}
