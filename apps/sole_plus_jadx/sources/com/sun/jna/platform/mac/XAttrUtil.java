package com.sun.jna.platform.mac;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class XAttrUtil {
    public static List<String> listXAttr(String str) {
        long jListxattr = XAttr.INSTANCE.listxattr(str, null, 0L, 0);
        if (jListxattr < 0) {
            return null;
        }
        if (jListxattr == 0) {
            return new ArrayList(0);
        }
        Memory memory = new Memory(jListxattr);
        long jListxattr2 = XAttr.INSTANCE.listxattr(str, memory, jListxattr, 0);
        if (jListxattr2 < 0) {
            return null;
        }
        return decodeStringSequence(memory.getByteBuffer(0L, jListxattr2));
    }

    public static String getXAttr(String str, String str2) {
        long j = XAttr.INSTANCE.getxattr(str, str2, null, 0L, 0, 0);
        if (j < 0) {
            return null;
        }
        if (j == 0) {
            return "";
        }
        Memory memory = new Memory(j);
        memory.clear();
        if (XAttr.INSTANCE.getxattr(str, str2, memory, j, 0, 0) < 0) {
            return null;
        }
        return Native.toString(memory.getByteArray(0L, (int) j), "UTF-8");
    }

    public static int setXAttr(String str, String str2, String str3) {
        Memory memoryEncodeString = encodeString(str3);
        return XAttr.INSTANCE.setxattr(str, str2, memoryEncodeString, memoryEncodeString.size(), 0, 0);
    }

    public static int removeXAttr(String str, String str2) {
        return XAttr.INSTANCE.removexattr(str, str2, 0);
    }

    protected static Memory encodeString(String str) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        Memory memory = new Memory(bytes.length);
        memory.write(0L, bytes, 0, bytes.length);
        return memory;
    }

    protected static String decodeString(ByteBuffer byteBuffer) {
        return Charset.forName("UTF-8").decode(byteBuffer).toString();
    }

    protected static List<String> decodeStringSequence(ByteBuffer byteBuffer) {
        ArrayList arrayList = new ArrayList();
        byteBuffer.mark();
        while (byteBuffer.hasRemaining()) {
            if (byteBuffer.get() == 0) {
                ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.duplicate().limit(byteBuffer.position() - 1).reset();
                if (byteBuffer2.hasRemaining()) {
                    arrayList.add(decodeString(byteBuffer2));
                }
                byteBuffer.mark();
            }
        }
        return arrayList;
    }
}
