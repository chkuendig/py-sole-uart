package com.android.ddmlib;

import java.nio.ByteBuffer;
import kotlin.UShort;

/* loaded from: classes3.dex */
public class AllocationsParser {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String descriptorToDot(java.lang.String r6) {
        /*
            r0 = 0
            r1 = r0
        L2:
            java.lang.String r2 = "["
            boolean r2 = r6.startsWith(r2)
            r3 = 1
            if (r2 == 0) goto L12
            java.lang.String r6 = r6.substring(r3)
            int r1 = r1 + 1
            goto L2
        L12:
            int r2 = r6.length()
            r4 = 2
            if (r2 < r4) goto L37
            char r4 = r6.charAt(r0)
            r5 = 76
            if (r4 != r5) goto L37
            int r2 = r2 - r3
            char r4 = r6.charAt(r2)
            r5 = 59
            if (r4 != r5) goto L37
            java.lang.String r6 = r6.substring(r3, r2)
            r2 = 47
            r3 = 46
            java.lang.String r6 = r6.replace(r2, r3)
            goto L8f
        L37:
            java.lang.String r2 = "C"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L42
            java.lang.String r6 = "char"
            goto L8f
        L42:
            java.lang.String r2 = "B"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L4d
            java.lang.String r6 = "byte"
            goto L8f
        L4d:
            java.lang.String r2 = "Z"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L58
            java.lang.String r6 = "boolean"
            goto L8f
        L58:
            java.lang.String r2 = "S"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L64
            java.lang.String r6 = "short"
            goto L8f
        L64:
            java.lang.String r2 = "I"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L6f
            java.lang.String r6 = "int"
            goto L8f
        L6f:
            java.lang.String r2 = "J"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L7a
            java.lang.String r6 = "long"
            goto L8f
        L7a:
            java.lang.String r2 = "F"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L85
            java.lang.String r6 = "float"
            goto L8f
        L85:
            java.lang.String r2 = "D"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L8f
            java.lang.String r6 = "double"
        L8f:
            if (r0 >= r1) goto La7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r6 = r2.append(r6)
            java.lang.String r2 = "[]"
            java.lang.StringBuilder r6 = r6.append(r2)
            java.lang.String r6 = r6.toString()
            int r0 = r0 + 1
            goto L8f
        La7:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ddmlib.AllocationsParser.descriptorToDot(java.lang.String):java.lang.String");
    }

    private static void readStringTable(ByteBuffer data, String[] strings) {
        int length = strings.length;
        for (int i = 0; i < length; i++) {
            strings[i] = descriptorToDot(ByteBufferUtil.getString(data, data.getInt()));
        }
    }

    public static AllocationInfo[] parse(ByteBuffer data) {
        ByteBuffer byteBufferFixAllocOverflow = fixAllocOverflow(data);
        int i = byteBufferFixAllocOverflow.get() & 255;
        int i2 = byteBufferFixAllocOverflow.get() & 255;
        int i3 = byteBufferFixAllocOverflow.get() & 255;
        short s = byteBufferFixAllocOverflow.getShort();
        short s2 = UShort.MAX_VALUE;
        int i4 = s & UShort.MAX_VALUE;
        int i5 = byteBufferFixAllocOverflow.getInt();
        int i6 = byteBufferFixAllocOverflow.getShort() & UShort.MAX_VALUE;
        int i7 = byteBufferFixAllocOverflow.getShort() & UShort.MAX_VALUE;
        int i8 = byteBufferFixAllocOverflow.getShort() & UShort.MAX_VALUE;
        byteBufferFixAllocOverflow.position(i5);
        String[] strArr = new String[i6];
        String[] strArr2 = new String[i7];
        String[] strArr3 = new String[i8];
        readStringTable(byteBufferFixAllocOverflow, strArr);
        readStringTable(byteBufferFixAllocOverflow, strArr2);
        readStringTable(byteBufferFixAllocOverflow, strArr3);
        byteBufferFixAllocOverflow.position(i);
        AllocationInfo[] allocationInfoArr = new AllocationInfo[i4];
        int i9 = 0;
        while (i9 < i4) {
            int i10 = byteBufferFixAllocOverflow.getInt();
            int i11 = byteBufferFixAllocOverflow.getShort() & s2;
            int i12 = byteBufferFixAllocOverflow.getShort() & s2;
            int i13 = byteBufferFixAllocOverflow.get() & 255;
            for (int i14 = 9; i14 < i2; i14++) {
                byteBufferFixAllocOverflow.get();
            }
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[i13];
            int i15 = 0;
            while (i15 < i13) {
                int i16 = byteBufferFixAllocOverflow.getShort() & s2;
                int i17 = byteBufferFixAllocOverflow.getShort() & s2;
                int i18 = byteBufferFixAllocOverflow.getShort() & s2;
                short s3 = byteBufferFixAllocOverflow.getShort();
                int i19 = i2;
                String str = strArr[i16];
                int i20 = i13;
                String str2 = strArr2[i17];
                String[] strArr4 = strArr2;
                String str3 = strArr3[i18];
                String[] strArr5 = strArr3;
                stackTraceElementArr[i15] = new StackTraceElement(str, str2, str3, s3);
                for (int i21 = 8; i21 < i3; i21++) {
                    byteBufferFixAllocOverflow.get();
                }
                i15++;
                i13 = i20;
                strArr2 = strArr4;
                strArr3 = strArr5;
                i2 = i19;
                s2 = UShort.MAX_VALUE;
            }
            allocationInfoArr[i9] = new AllocationInfo(i4 - i9, strArr[i12], i10, (short) i11, stackTraceElementArr);
            i9++;
            strArr2 = strArr2;
            i2 = i2;
            s2 = UShort.MAX_VALUE;
        }
        return allocationInfoArr;
    }

    private static ByteBuffer fixAllocOverflow(ByteBuffer original) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(original.capacity());
        int i = original.get() & 255;
        byteBufferAllocate.put((byte) i);
        int i2 = original.get() & 255;
        byteBufferAllocate.put((byte) i2);
        int i3 = original.get() & 255;
        byteBufferAllocate.put((byte) i3);
        if ((original.getShort() & UShort.MAX_VALUE) != 0) {
            original.rewind();
            return original;
        }
        int i4 = original.getInt();
        if (i4 - i < i2 + i3) {
            original.rewind();
            return original;
        }
        byteBufferAllocate.putShort((short) 65535);
        byteBufferAllocate.putInt(i4);
        byteBufferAllocate.putShort((short) (original.getShort() & UShort.MAX_VALUE));
        byteBufferAllocate.putShort((short) (original.getShort() & UShort.MAX_VALUE));
        byteBufferAllocate.putShort((short) (original.getShort() & UShort.MAX_VALUE));
        for (int iPosition = byteBufferAllocate.position(); iPosition < i; iPosition++) {
            byteBufferAllocate.put((byte) 0);
        }
        original.position(i);
        for (int i5 = 0; i5 < 65535; i5++) {
            byteBufferAllocate.putInt(original.getInt());
            byteBufferAllocate.putShort(original.getShort());
            byteBufferAllocate.putShort(original.getShort());
            int i6 = original.get() & 255;
            byteBufferAllocate.put((byte) i6);
            for (int i7 = 9; i7 < i2; i7++) {
                byteBufferAllocate.put(original.get());
            }
            for (int i8 = 0; i8 < i6; i8++) {
                byteBufferAllocate.putShort(original.getShort());
                byteBufferAllocate.putShort(original.getShort());
                byteBufferAllocate.putShort(original.getShort());
                byteBufferAllocate.putShort(original.getShort());
                for (int i9 = 8; i9 < i3; i9++) {
                    byteBufferAllocate.put(original.get());
                }
            }
        }
        original.position(i4);
        int iPosition2 = byteBufferAllocate.position();
        while (original.hasRemaining()) {
            byteBufferAllocate.put(original.get());
        }
        int iPosition3 = byteBufferAllocate.position();
        byteBufferAllocate.position(5);
        byteBufferAllocate.putInt(iPosition2);
        byteBufferAllocate.position(iPosition3);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }
}
