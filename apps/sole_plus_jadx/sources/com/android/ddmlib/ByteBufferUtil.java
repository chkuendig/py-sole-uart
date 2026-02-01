package com.android.ddmlib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: classes3.dex */
public class ByteBufferUtil {
    public static ByteBuffer mapFile(File f, long offset, ByteOrder byteOrder) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(f);
        try {
            MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, offset, f.length() - offset);
            map.order(byteOrder);
            return map;
        } finally {
            fileInputStream.close();
        }
    }

    public static String getString(ByteBuffer buf, int len) {
        char[] cArr = new char[len];
        for (int i = 0; i < len; i++) {
            cArr[i] = buf.getChar();
        }
        return new String(cArr);
    }

    public static void putString(ByteBuffer buf, String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            buf.putChar(str.charAt(i));
        }
    }

    public static boolean cleanBuffer(ByteBuffer buffer) {
        if (!buffer.isDirect()) {
            return true;
        }
        try {
            Class<?> clsLoadClass = ByteBufferUtil.class.getClassLoader().loadClass("sun.misc.Unsafe");
            Field declaredField = clsLoadClass.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            (void) MethodHandles.lookup().findVirtual(clsLoadClass, "invokeCleaner", MethodType.methodType((Class<?>) Void.TYPE, (Class<?>) ByteBuffer.class)).invoke(clsLoadClass.cast(declaredField.get(null)), buffer);
            return true;
        } catch (Throwable th) {
            Log.w("ddmlib", "ByteBufferUtil.cleanBuffer() failed " + th);
            return false;
        }
    }
}
