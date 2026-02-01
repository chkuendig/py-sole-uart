package com.google.zxing.qrcode.decoder;

import com.dyaco.sole.R2;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00da A[LOOP:0: B:53:0x001e->B:50:0x00da, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode modeForBits;
        Mode mode;
        int i;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i2 = 1;
        ArrayList arrayList = new ArrayList(1);
        boolean z = 0;
        int i3 = -1;
        int bits = -1;
        CharacterSetECI characterSetECIByValue = null;
        while (true) {
            try {
                if (bitSource.available() < 4) {
                    modeForBits = Mode.TERMINATOR;
                } else {
                    modeForBits = Mode.forBits(bitSource.readBits(4));
                }
                Mode mode2 = modeForBits;
                int i4 = z;
                switch (mode2) {
                    case TERMINATOR:
                        mode = mode2;
                        i = i4;
                        if (mode != Mode.TERMINATOR) {
                            return new DecoderResult(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel == null ? null : errorCorrectionLevel.toString(), i3, bits);
                        }
                        i2 = 1;
                        z = i;
                    case FNC1_FIRST_POSITION:
                    case FNC1_SECOND_POSITION:
                        i4 = i2;
                        mode = mode2;
                        i = i4;
                        if (mode != Mode.TERMINATOR) {
                        }
                        break;
                    case STRUCTURED_APPEND:
                        if (bitSource.available() < 16) {
                            throw FormatException.getFormatInstance();
                        }
                        int bits2 = bitSource.readBits(8);
                        bits = bitSource.readBits(8);
                        i3 = bits2;
                        i4 = z;
                        mode = mode2;
                        i = i4;
                        if (mode != Mode.TERMINATOR) {
                        }
                        break;
                    case ECI:
                        characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                        if (characterSetECIByValue == null) {
                            throw FormatException.getFormatInstance();
                        }
                        i4 = z;
                        mode = mode2;
                        i = i4;
                        if (mode != Mode.TERMINATOR) {
                        }
                        break;
                    case HANZI:
                        int bits3 = bitSource.readBits(4);
                        int bits4 = bitSource.readBits(mode2.getCharacterCountBits(version));
                        i4 = z;
                        if (bits3 == i2) {
                            decodeHanziSegment(bitSource, sb, bits4);
                            i4 = z;
                        }
                        mode = mode2;
                        i = i4;
                        if (mode != Mode.TERMINATOR) {
                        }
                        break;
                    default:
                        int bits5 = bitSource.readBits(mode2.getCharacterCountBits(version));
                        int i5 = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode2.ordinal()];
                        if (i5 == i2) {
                            mode = mode2;
                            decodeNumericSegment(bitSource, sb, bits5);
                            i = z;
                        } else if (i5 == 2) {
                            mode = mode2;
                            decodeAlphanumericSegment(bitSource, sb, bits5, z);
                            i = z;
                        } else if (i5 == 3) {
                            mode = mode2;
                            decodeByteSegment(bitSource, sb, bits5, characterSetECIByValue, arrayList, map);
                            i = z;
                        } else if (i5 == 4) {
                            decodeKanjiSegment(bitSource, sb, bits5);
                            i4 = z;
                            mode = mode2;
                            i = i4;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        if (mode != Mode.TERMINATOR) {
                        }
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int bits = bitSource.readBits(13);
            int i3 = (bits % 96) | ((bits / 96) << 8);
            int i4 = i3 + (i3 < 2560 ? 41377 : 42657);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, StringUtils.GB2312));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int bits = bitSource.readBits(13);
            int i3 = (bits % R2.attr.constraintSet) | ((bits / R2.attr.constraintSet) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, StringUtils.SHIFT_JIS));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String strName;
        if ((i << 3) > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) bitSource.readBits(8);
        }
        if (characterSetECI == null) {
            strName = StringUtils.guessEncoding(bArr, map);
        } else {
            strName = characterSetECI.name();
        }
        try {
            sb.append(new String(bArr, strName));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static char toAlphaNumericChar(int i) throws FormatException {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i >= cArr.length) {
            throw FormatException.getFormatInstance();
        }
        return cArr[i];
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder sb, int i, boolean z) throws FormatException {
        while (i > 1) {
            if (bitSource.available() < 11) {
                throw FormatException.getFormatInstance();
            }
            int bits = bitSource.readBits(11);
            sb.append(toAlphaNumericChar(bits / 45));
            sb.append(toAlphaNumericChar(bits % 45));
            i -= 2;
        }
        if (i == 1) {
            if (bitSource.available() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bitSource.readBits(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    }
                }
            }
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (bitSource.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int bits = bitSource.readBits(10);
            if (bits >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits / 100));
            sb.append(toAlphaNumericChar((bits / 10) % 10));
            sb.append(toAlphaNumericChar(bits % 10));
            i -= 3;
        }
        if (i == 2) {
            if (bitSource.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            int bits2 = bitSource.readBits(7);
            if (bits2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits2 / 10));
            sb.append(toAlphaNumericChar(bits2 % 10));
            return;
        }
        if (i == 1) {
            if (bitSource.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            int bits3 = bitSource.readBits(4);
            if (bits3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits3));
        }
    }

    private static int parseECIValue(BitSource bitSource) throws FormatException {
        int bits = bitSource.readBits(8);
        if ((bits & 128) == 0) {
            return bits & 127;
        }
        if ((bits & R2.attr.constraintSet) == 128) {
            return bitSource.readBits(8) | ((bits & 63) << 8);
        }
        if ((bits & R2.attr.customPixelDimension) == 192) {
            return bitSource.readBits(16) | ((bits & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }
}
