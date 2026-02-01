package com.android.utils;

import com.android.io.CancellableFileIo;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;

/* loaded from: classes3.dex */
public final class Base128InputStream extends BufferedInputStream {
    private Map<String, String> myStringCache;

    public Base128InputStream(InputStream stream) {
        super(stream);
    }

    public Base128InputStream(Path file) throws IOException {
        super(CancellableFileIo.newInputStream(file, new OpenOption[0]));
    }

    public void setStringCache(Map<String, String> stringCache) {
        this.myStringCache = stringCache;
    }

    public char readChar() throws IOException {
        int byteAsInt = readByteAsInt();
        int i = byteAsInt & 127;
        int i2 = 7;
        while ((byteAsInt & 128) != 0) {
            byteAsInt = readByteAsInt();
            if (i2 == 14 && (byteAsInt & 252) != 0) {
                throw StreamFormatException.invalidFormat();
            }
            i |= (byteAsInt & 127) << i2;
            i2 += 7;
        }
        return (char) i;
    }

    public int readInt() throws IOException {
        int byteAsInt = readByteAsInt();
        int i = byteAsInt & 127;
        int i2 = 7;
        while ((byteAsInt & 128) != 0) {
            byteAsInt = readByteAsInt();
            if (i2 == 28 && (byteAsInt & 240) != 0) {
                throw StreamFormatException.invalidFormat();
            }
            i |= (byteAsInt & 127) << i2;
            i2 += 7;
        }
        return i;
    }

    public long readLong() throws IOException {
        int byteAsInt = readByteAsInt();
        long j = byteAsInt & 127;
        int i = 7;
        while ((byteAsInt & 128) != 0) {
            byteAsInt = readByteAsInt();
            if (i == 63 && (byteAsInt & 254) != 0) {
                throw StreamFormatException.invalidFormat();
            }
            j |= (byteAsInt & 127) << i;
            i += 7;
        }
        return j;
    }

    public String readString() throws IOException {
        int i = readInt();
        if (i < 0) {
            throw StreamFormatException.invalidFormat();
        }
        if (i == 0) {
            return null;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(readChar());
        }
        String string = sb.toString();
        Map<String, String> map = this.myStringCache;
        return map == null ? string : map.computeIfAbsent(string, Function.identity());
    }

    public byte readByte() throws IOException {
        return (byte) readByteAsInt();
    }

    public byte[] readBytes() throws IOException {
        int i = readInt();
        if (i < 0) {
            throw StreamFormatException.invalidFormat();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = readByte();
        }
        return bArr;
    }

    public boolean readBoolean() throws IOException {
        int i = readInt();
        if ((i & (-2)) == 0) {
            return i != 0;
        }
        throw StreamFormatException.invalidFormat();
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    @Deprecated
    public int read() {
        throw new UnsupportedOperationException("This method is disabled to prevent unintended accidental use. Please use readByte or readInt instead.");
    }

    public boolean validateContents(byte[] expected) throws IOException {
        boolean z = true;
        for (byte b : expected) {
            if (b != readByte()) {
                z = false;
            }
        }
        return z;
    }

    private int readByteAsInt() throws IOException {
        int i = super.read();
        if (i >= 0) {
            return i;
        }
        throw StreamFormatException.prematureEndOfFile();
    }

    public static class StreamFormatException extends IOException {
        public StreamFormatException(String message) {
            super(message);
        }

        public static StreamFormatException prematureEndOfFile() {
            return new StreamFormatException("Premature end of file");
        }

        public static StreamFormatException invalidFormat() {
            return new StreamFormatException("Invalid file format");
        }
    }
}
