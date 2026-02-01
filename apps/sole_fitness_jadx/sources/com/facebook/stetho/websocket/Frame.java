package com.facebook.stetho.websocket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
class Frame {
    public static final byte OPCODE_BINARY_FRAME = 2;
    public static final byte OPCODE_CONNECTION_CLOSE = 8;
    public static final byte OPCODE_CONNECTION_PING = 9;
    public static final byte OPCODE_CONNECTION_PONG = 10;
    public static final byte OPCODE_TEXT_FRAME = 1;
    public boolean fin;
    public boolean hasMask;
    public byte[] maskingKey;
    public byte opcode;
    public byte[] payloadData;
    public long payloadLen;
    public boolean rsv1;
    public boolean rsv2;
    public boolean rsv3;

    private static byte[] encodeLength(long j) {
        return j <= 125 ? new byte[]{(byte) j} : j <= WebSocketProtocol.PAYLOAD_SHORT_MAX ? new byte[]{126, (byte) ((j >> 8) & 255), (byte) (j & 255)} : new byte[]{ByteCompanionObject.MAX_VALUE, (byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)};
    }

    Frame() {
    }

    public void readFrom(BufferedInputStream bufferedInputStream) throws IOException {
        decodeFirstByte(readByteOrThrow(bufferedInputStream));
        byte byteOrThrow = readByteOrThrow(bufferedInputStream);
        this.hasMask = (byteOrThrow & ByteCompanionObject.MIN_VALUE) != 0;
        this.payloadLen = decodeLength((byte) (byteOrThrow & ByteCompanionObject.MAX_VALUE), bufferedInputStream);
        this.maskingKey = this.hasMask ? decodeMaskingKey(bufferedInputStream) : null;
        long j = this.payloadLen;
        byte[] bArr = new byte[(int) j];
        this.payloadData = bArr;
        readBytesOrThrow(bufferedInputStream, bArr, 0, (int) j);
        MaskingHelper.unmask(this.maskingKey, this.payloadData, 0, (int) this.payloadLen);
    }

    public void writeTo(BufferedOutputStream bufferedOutputStream) throws IOException {
        bufferedOutputStream.write(encodeFirstByte());
        byte[] bArrEncodeLength = encodeLength(this.payloadLen);
        if (this.hasMask) {
            bArrEncodeLength[0] = (byte) (bArrEncodeLength[0] | ByteCompanionObject.MIN_VALUE);
        }
        bufferedOutputStream.write(bArrEncodeLength, 0, bArrEncodeLength.length);
        if (this.hasMask) {
            throw new UnsupportedOperationException("Writing masked data not implemented");
        }
        bufferedOutputStream.write(this.payloadData, 0, (int) this.payloadLen);
    }

    private void decodeFirstByte(byte b) {
        this.fin = (b & ByteCompanionObject.MIN_VALUE) != 0;
        this.rsv1 = (b & 64) != 0;
        this.rsv2 = (b & 32) != 0;
        this.rsv3 = (b & 16) != 0;
        this.opcode = (byte) (b & 15);
    }

    private byte encodeFirstByte() {
        byte b = this.fin ? (byte) 128 : (byte) 0;
        if (this.rsv1) {
            b = (byte) (b | 64);
        }
        if (this.rsv2) {
            b = (byte) (b | 32);
        }
        if (this.rsv3) {
            b = (byte) (b | 16);
        }
        return (byte) (b | (this.opcode & 15));
    }

    private long decodeLength(byte b, InputStream inputStream) throws IOException {
        if (b <= 125) {
            return b;
        }
        if (b == 126) {
            return ((readByteOrThrow(inputStream) & UByte.MAX_VALUE) << 8) | (readByteOrThrow(inputStream) & UByte.MAX_VALUE);
        }
        if (b != 127) {
            throw new IOException("Unexpected length byte: " + ((int) b));
        }
        long byteOrThrow = 0;
        for (int i = 0; i < 8; i++) {
            byteOrThrow = (byteOrThrow | (readByteOrThrow(inputStream) & UByte.MAX_VALUE)) << 8;
        }
        return byteOrThrow;
    }

    private static byte[] decodeMaskingKey(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4];
        readBytesOrThrow(inputStream, bArr, 0, 4);
        return bArr;
    }

    private static void readBytesOrThrow(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 -= i3;
            i += i3;
        }
    }

    private static byte readByteOrThrow(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return (byte) i;
        }
        throw new EOFException();
    }
}
