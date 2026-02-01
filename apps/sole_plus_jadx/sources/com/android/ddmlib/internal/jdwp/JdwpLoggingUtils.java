package com.android.ddmlib.internal.jdwp;

import com.android.ddmlib.Log;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import java.nio.ByteBuffer;
import java.util.Locale;

/* loaded from: classes3.dex */
public class JdwpLoggingUtils {
    public static void log(String owner, String action, JdwpPacket packet) {
        if (Log.isAtLeast(Log.LogLevel.VERBOSE)) {
            Log.v("JdwpProxy-Packet", String.format(Locale.getDefault(), "%s %s (%d)", owner, action, Integer.valueOf(packet.getId())));
            packet.log(action);
        }
    }

    public static void log(String owner, String action, byte[] buffer, int length) {
        if (Log.isAtLeast(Log.LogLevel.VERBOSE)) {
            Log.v("JdwpProxy-Buffer", String.format(Locale.getDefault(), "%s %s (%d) %s", owner, action, Integer.valueOf(length), formatBytesToString(buffer, length)));
        }
    }

    public static void logPacketError(String message, ByteBuffer packet) {
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        int iPosition = packet.position();
        if (iPosition > 0) {
            sb.append(String.format(Locale.getDefault(), "\nPacket Payload (%d): %s", Integer.valueOf(iPosition), formatBytesToString(packet.array(), Math.min(iPosition, 128))));
        }
        Log.e("JdwpProxy", sb.toString());
    }

    public static void logPacketError(String message, JdwpPacket packet) {
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        if (packet != null) {
            sb.append(String.format("\nPacket Header: %s", packet.toString()));
            sb.append(String.format(Locale.getDefault(), "\nPacket Payload (%d): %s", Integer.valueOf(packet.getLength()), formatBytesToString(packet.getPayload().array(), Math.min(packet.getLength(), 128))));
        }
        Log.e("JdwpProxy", sb.toString());
    }

    private static String formatBytesToString(byte[] buffer, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            if (Character.isLetterOrDigit((char) buffer[i])) {
                sb.append((char) buffer[i]);
            } else {
                sb.append(Integer.toHexString(buffer[i]));
            }
        }
        return sb.toString();
    }
}
