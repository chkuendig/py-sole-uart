package com.android.utils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import kotlin.jvm.internal.CharCompanionObject;

/* loaded from: classes3.dex */
public final class Base128OutputStream extends BufferedOutputStream {
    public Base128OutputStream(OutputStream stream) {
        super(stream);
    }

    public Base128OutputStream(Path file) throws IOException {
        super(Files.newOutputStream(file, new OpenOption[0]));
    }

    public void writeInt(int value) throws IOException {
        do {
            int i = value & 127;
            value >>>= 7;
            if (value != 0) {
                i |= 128;
            }
            super.write(i);
        } while (value != 0);
    }

    public void writeLong(long value) throws IOException {
        do {
            int i = ((int) value) & 127;
            value >>>= 7;
            if (value != 0) {
                i |= 128;
            }
            super.write(i);
        } while (value != 0);
    }

    public void writeString(String str) throws IOException {
        if (str == null) {
            writeInt(0);
            return;
        }
        int length = str.length();
        writeInt(length + 1);
        for (int i = 0; i < length; i++) {
            writeChar(str.charAt(i));
        }
    }

    public void writeChar(char value) throws IOException {
        writeInt(value & CharCompanionObject.MAX_VALUE);
    }

    public void writeByte(byte value) throws IOException {
        super.write(value);
    }

    public void writeBytes(byte[] bytes) throws IOException {
        writeInt(bytes.length);
        for (byte b : bytes) {
            writeByte(b);
        }
    }

    public void writeBoolean(boolean z) throws IOException {
        writeInt(z ? 1 : 0);
    }

    @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    @Deprecated
    public void write(int b) {
        throw new UnsupportedOperationException("This method is disabled to prevent unintended accidental use. Please use writeByte or writeInt instead.");
    }
}
