package com.android.ddmlib.internal;

import com.android.ddmlib.AdbHelper;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class AdbSocketUtils {
    static void read(SocketChannel socket, ByteBuffer buf) throws IOException {
        while (buf.remaining() > 0) {
            if (socket.read(buf) < 0) {
                throw new EOFException("EOF");
            }
        }
    }

    static ByteBuffer read(SocketChannel socket, int length) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        read(socket, byteBufferAllocate);
        byteBufferAllocate.rewind();
        return byteBufferAllocate;
    }

    static String read(SocketChannel socket, byte[] buffer) throws IOException {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(buffer, 0, buffer.length);
        read(socket, byteBufferWrap);
        return new String(buffer, 0, byteBufferWrap.position(), AdbHelper.DEFAULT_CHARSET);
    }

    static int readLength(SocketChannel socket, byte[] buffer) throws IOException {
        String str = read(socket, buffer);
        if (str != null) {
            try {
                return Integer.parseInt(str, 16);
            } catch (NumberFormatException unused) {
            }
        }
        throw new IOException("Unable to read length");
    }

    static String readNullTerminatedString(SocketChannel socket) throws IOException {
        return readNullTerminatedString(socket, AdbHelper.DEFAULT_CHARSET);
    }

    static String readNullTerminatedString(SocketChannel socket, Charset charset) throws IOException {
        byte[] bArr = new byte[64];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, 64);
        ByteArrayDataOutput byteArrayDataOutputNewDataOutput = ByteStreams.newDataOutput(64);
        boolean z = false;
        while (!z) {
            byteBufferWrap.rewind();
            try {
                read(socket, byteBufferWrap);
            } catch (EOFException unused) {
                z = true;
            }
            int i = 0;
            while (true) {
                if (i >= byteBufferWrap.position()) {
                    break;
                }
                if (bArr[i] == 0) {
                    z = true;
                    break;
                }
                i++;
            }
            byteArrayDataOutputNewDataOutput.write(bArr, 0, i);
        }
        return new String(byteArrayDataOutputNewDataOutput.toByteArray(), charset);
    }
}
