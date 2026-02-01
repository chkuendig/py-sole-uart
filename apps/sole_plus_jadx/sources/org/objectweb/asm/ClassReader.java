package org.objectweb.asm;

import com.android.SdkConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okio.Utf8;

/* loaded from: classes6.dex */
public class ClassReader {
    static final int EXPAND_ASM_INSNS = 256;
    public static final int EXPAND_FRAMES = 8;
    private static final int INPUT_STREAM_DATA_CHUNK_SIZE = 4096;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;

    @Deprecated
    public final byte[] b;
    private final int[] bootstrapMethodOffsets;
    final byte[] classFileBuffer;
    private final ConstantDynamic[] constantDynamicValues;
    private final String[] constantUtf8Values;
    private final int[] cpInfoOffsets;
    public final int header;
    private final int maxStringLength;

    public ClassReader(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public ClassReader(byte[] bArr, int i, int i2) {
        this(bArr, i, true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072 A[PHI: r8
      0x0072: PHI (r8v1 int) = (r8v0 int), (r8v2 int), (r8v6 int) binds: [B:12:0x0050, B:21:0x006d, B:17:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    ClassReader(byte[] r11, int r12, boolean r13) {
        /*
            r10 = this;
            r10.<init>()
            r10.classFileBuffer = r11
            r10.b = r11
            if (r13 == 0) goto L2d
            int r13 = r12 + 6
            short r0 = r10.readShort(r13)
            r1 = 61
            if (r0 > r1) goto L14
            goto L2d
        L14:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Unsupported class file major version "
            r12.<init>(r0)
            short r13 = r10.readShort(r13)
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L2d:
            int r13 = r12 + 8
            int r13 = r10.readUnsignedShort(r13)
            int[] r0 = new int[r13]
            r10.cpInfoOffsets = r0
            java.lang.String[] r0 = new java.lang.String[r13]
            r10.constantUtf8Values = r0
            int r12 = r12 + 10
            r0 = 0
            r1 = 1
            r2 = r0
            r3 = r2
            r4 = r1
        L42:
            if (r4 >= r13) goto L75
            int[] r5 = r10.cpInfoOffsets
            int r6 = r4 + 1
            int r7 = r12 + 1
            r5[r4] = r7
            r5 = r11[r12]
            r8 = 3
            r9 = 5
            switch(r5) {
                case 1: goto L68;
                case 2: goto L53;
                case 3: goto L65;
                case 4: goto L65;
                case 5: goto L60;
                case 6: goto L60;
                case 7: goto L72;
                case 8: goto L72;
                case 9: goto L65;
                case 10: goto L65;
                case 11: goto L65;
                case 12: goto L65;
                case 13: goto L53;
                case 14: goto L53;
                case 15: goto L5e;
                case 16: goto L72;
                case 17: goto L5b;
                case 18: goto L59;
                case 19: goto L72;
                case 20: goto L72;
                default: goto L53;
            }
        L53:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r11.<init>()
            throw r11
        L59:
            r3 = r1
            goto L65
        L5b:
            r2 = r1
            r3 = r2
            goto L65
        L5e:
            r8 = 4
            goto L72
        L60:
            int r4 = r4 + 2
            r8 = 9
            goto L73
        L65:
            r4 = r6
            r8 = r9
            goto L73
        L68:
            int r4 = r10.readUnsignedShort(r7)
            int r8 = r8 + r4
            if (r8 <= r0) goto L72
            r4 = r6
            r0 = r8
            goto L73
        L72:
            r4 = r6
        L73:
            int r12 = r12 + r8
            goto L42
        L75:
            r10.maxStringLength = r0
            r10.header = r12
            r11 = 0
            if (r2 == 0) goto L7f
            org.objectweb.asm.ConstantDynamic[] r12 = new org.objectweb.asm.ConstantDynamic[r13]
            goto L80
        L7f:
            r12 = r11
        L80:
            r10.constantDynamicValues = r12
            if (r3 == 0) goto L88
            int[] r11 = r10.readBootstrapMethodsAttribute(r0)
        L88:
            r10.bootstrapMethodOffsets = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassReader.<init>(byte[], int, boolean):void");
    }

    public ClassReader(InputStream inputStream) throws IOException {
        this(readStream(inputStream, false));
    }

    public ClassReader(String str) throws IOException {
        this(readStream(ClassLoader.getSystemResourceAsStream(str.replace('.', '/') + SdkConstants.DOT_CLASS), true));
    }

    private static byte[] readStream(InputStream inputStream, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IOException("Class not found");
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStream.read(bArr, 0, 4096);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } finally {
            if (z) {
                inputStream.close();
            }
        }
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.maxStringLength]);
    }

    public String getSuperName() {
        return readClass(this.header + 4, new char[this.maxStringLength]);
    }

    public String[] getInterfaces() {
        int i = this.header + 6;
        int unsignedShort = readUnsignedShort(i);
        String[] strArr = new String[unsignedShort];
        if (unsignedShort > 0) {
            char[] cArr = new char[this.maxStringLength];
            for (int i2 = 0; i2 < unsignedShort; i2++) {
                i += 2;
                strArr[i2] = readClass(i, cArr);
            }
        }
        return strArr;
    }

    public void accept(ClassVisitor classVisitor, int i) {
        accept(classVisitor, new Attribute[0], i);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attributeArr, int i) {
        int i2;
        int i3;
        int i4;
        String[] strArr;
        Context context = new Context();
        context.attributePrototypes = attributeArr;
        context.parsingOptions = i;
        context.charBuffer = new char[this.maxStringLength];
        char[] cArr = context.charBuffer;
        int i5 = this.header;
        int unsignedShort = readUnsignedShort(i5);
        String str = readClass(i5 + 2, cArr);
        String str2 = readClass(i5 + 4, cArr);
        int unsignedShort2 = readUnsignedShort(i5 + 6);
        String[] strArr2 = new String[unsignedShort2];
        int i6 = i5 + 8;
        for (int i7 = 0; i7 < unsignedShort2; i7++) {
            strArr2[i7] = readClass(i6, cArr);
            i6 += 2;
        }
        int firstAttributeOffset = getFirstAttributeOffset();
        int i8 = unsignedShort;
        int unsignedShort3 = readUnsignedShort(firstAttributeOffset - 2);
        String utf = null;
        String utf8 = null;
        int i9 = 0;
        String utf82 = null;
        int i10 = 0;
        String str3 = null;
        String str4 = null;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        Attribute attribute = null;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (unsignedShort3 > 0) {
            String utf83 = readUTF8(firstAttributeOffset, cArr);
            int i20 = readInt(firstAttributeOffset + 2);
            int i21 = firstAttributeOffset + 6;
            String str5 = utf;
            if ("SourceFile".equals(utf83)) {
                i2 = i21;
                utf8 = readUTF8(i21, cArr);
            } else if ("InnerClasses".equals(utf83)) {
                i18 = i21;
                i2 = i18;
            } else if ("EnclosingMethod".equals(utf83)) {
                i11 = i21;
                i2 = i11;
            } else if ("NestHost".equals(utf83)) {
                i2 = i21;
                str4 = readClass(i21, cArr);
            } else if ("NestMembers".equals(utf83)) {
                i16 = i21;
                i2 = i16;
            } else if ("PermittedSubclasses".equals(utf83)) {
                i17 = i21;
                i2 = i17;
            } else {
                if ("Signature".equals(utf83)) {
                    utf82 = readUTF8(i21, cArr);
                } else if ("RuntimeVisibleAnnotations".equals(utf83)) {
                    i12 = i21;
                    i2 = i12;
                } else if ("RuntimeVisibleTypeAnnotations".equals(utf83)) {
                    i14 = i21;
                    i2 = i14;
                } else if ("Deprecated".equals(utf83)) {
                    i8 |= 131072;
                } else if ("Synthetic".equals(utf83)) {
                    i8 |= 4096;
                } else if ("SourceDebugExtension".equals(utf83)) {
                    if (i20 > this.classFileBuffer.length - i21) {
                        throw new IllegalArgumentException();
                    }
                    utf = readUtf(i21, i20, new char[i20]);
                    i2 = i21;
                    i3 = i6;
                    i4 = i20;
                    strArr = strArr2;
                    firstAttributeOffset = i2 + i4;
                    unsignedShort3--;
                    strArr2 = strArr;
                    i6 = i3;
                } else if ("RuntimeInvisibleAnnotations".equals(utf83)) {
                    i13 = i21;
                    i2 = i13;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(utf83)) {
                    i15 = i21;
                    i2 = i15;
                } else if ("Record".equals(utf83)) {
                    i8 |= 65536;
                    i19 = i21;
                    i2 = i19;
                } else if ("Module".equals(utf83)) {
                    i9 = i21;
                    i2 = i9;
                } else if ("ModuleMainClass".equals(utf83)) {
                    str3 = readClass(i21, cArr);
                } else if ("ModulePackages".equals(utf83)) {
                    i10 = i21;
                    i2 = i10;
                } else {
                    if ("BootstrapMethods".equals(utf83)) {
                        i2 = i21;
                        i3 = i6;
                        i4 = i20;
                        strArr = strArr2;
                        utf = str5;
                    } else {
                        i2 = i21;
                        i3 = i6;
                        i4 = i20;
                        strArr = strArr2;
                        Attribute attribute2 = readAttribute(attributeArr, utf83, i2, i20, cArr, -1, null);
                        attribute2.nextAttribute = attribute;
                        attribute = attribute2;
                        i8 = i8;
                        utf = str5;
                        utf8 = utf8;
                    }
                    firstAttributeOffset = i2 + i4;
                    unsignedShort3--;
                    strArr2 = strArr;
                    i6 = i3;
                }
                i2 = i21;
            }
            i3 = i6;
            i4 = i20;
            strArr = strArr2;
            utf = str5;
            firstAttributeOffset = i2 + i4;
            unsignedShort3--;
            strArr2 = strArr;
            i6 = i3;
        }
        String str6 = utf;
        String str7 = utf8;
        int i22 = i6;
        String[] strArr3 = strArr2;
        Attribute attribute3 = attribute;
        classVisitor.visit(readInt(this.cpInfoOffsets[1] - 7), i8, str, utf82, str2, strArr3);
        if ((i & 2) == 0 && (str7 != null || str6 != null)) {
            classVisitor.visitSource(str7, str6);
        }
        if (i9 != 0) {
            readModuleAttributes(classVisitor, context, i9, i10, str3);
        }
        String str8 = str4;
        if (str8 != null) {
            classVisitor.visitNestHost(str8);
        }
        int i23 = i11;
        if (i23 != 0) {
            String str9 = readClass(i23, cArr);
            int unsignedShort4 = readUnsignedShort(i23 + 2);
            classVisitor.visitOuterClass(str9, unsignedShort4 == 0 ? null : readUTF8(this.cpInfoOffsets[unsignedShort4], cArr), unsignedShort4 == 0 ? null : readUTF8(this.cpInfoOffsets[unsignedShort4] + 2, cArr));
        }
        int i24 = i12;
        if (i24 != 0) {
            int unsignedShort5 = readUnsignedShort(i24);
            int elementValues = i24 + 2;
            while (true) {
                int i25 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                elementValues = readElementValues(classVisitor.visitAnnotation(readUTF8(elementValues, cArr), true), elementValues + 2, true, cArr);
                unsignedShort5 = i25;
            }
        }
        int i26 = i13;
        if (i26 != 0) {
            int unsignedShort6 = readUnsignedShort(i26);
            int elementValues2 = i26 + 2;
            while (true) {
                int i27 = unsignedShort6 - 1;
                if (unsignedShort6 <= 0) {
                    break;
                }
                elementValues2 = readElementValues(classVisitor.visitAnnotation(readUTF8(elementValues2, cArr), false), elementValues2 + 2, true, cArr);
                unsignedShort6 = i27;
            }
        }
        int i28 = i14;
        if (i28 != 0) {
            int unsignedShort7 = readUnsignedShort(i28);
            int elementValues3 = i28 + 2;
            while (true) {
                int i29 = unsignedShort7 - 1;
                if (unsignedShort7 <= 0) {
                    break;
                }
                int typeAnnotationTarget = readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = readElementValues(classVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget, cArr), true), typeAnnotationTarget + 2, true, cArr);
                unsignedShort7 = i29;
            }
        }
        int i30 = i15;
        if (i30 != 0) {
            int unsignedShort8 = readUnsignedShort(i30);
            int elementValues4 = i30 + 2;
            while (true) {
                int i31 = unsignedShort8 - 1;
                if (unsignedShort8 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = readElementValues(classVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget2, cArr), false), typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort8 = i31;
            }
        }
        while (attribute3 != null) {
            Attribute attribute4 = attribute3.nextAttribute;
            attribute3.nextAttribute = null;
            classVisitor.visitAttribute(attribute3);
            attribute3 = attribute4;
        }
        int i32 = i16;
        if (i32 != 0) {
            int unsignedShort9 = readUnsignedShort(i32);
            int i33 = i32 + 2;
            while (true) {
                int i34 = unsignedShort9 - 1;
                if (unsignedShort9 <= 0) {
                    break;
                }
                classVisitor.visitNestMember(readClass(i33, cArr));
                i33 += 2;
                unsignedShort9 = i34;
            }
        }
        int i35 = i17;
        if (i35 != 0) {
            int unsignedShort10 = readUnsignedShort(i35);
            int i36 = i35 + 2;
            while (true) {
                int i37 = unsignedShort10 - 1;
                if (unsignedShort10 <= 0) {
                    break;
                }
                classVisitor.visitPermittedSubclass(readClass(i36, cArr));
                i36 += 2;
                unsignedShort10 = i37;
            }
        }
        int i38 = i18;
        if (i38 != 0) {
            int unsignedShort11 = readUnsignedShort(i38);
            int i39 = i38 + 2;
            while (true) {
                int i40 = unsignedShort11 - 1;
                if (unsignedShort11 <= 0) {
                    break;
                }
                classVisitor.visitInnerClass(readClass(i39, cArr), readClass(i39 + 2, cArr), readUTF8(i39 + 4, cArr), readUnsignedShort(i39 + 6));
                i39 += 8;
                unsignedShort11 = i40;
            }
        }
        int i41 = i19;
        if (i41 != 0) {
            int unsignedShort12 = readUnsignedShort(i41);
            int recordComponent = i41 + 2;
            while (true) {
                int i42 = unsignedShort12 - 1;
                if (unsignedShort12 <= 0) {
                    break;
                }
                recordComponent = readRecordComponent(classVisitor, context, recordComponent);
                unsignedShort12 = i42;
            }
        }
        int unsignedShort13 = readUnsignedShort(i22);
        int field = i22 + 2;
        while (true) {
            int i43 = unsignedShort13 - 1;
            if (unsignedShort13 <= 0) {
                break;
            }
            field = readField(classVisitor, context, field);
            unsignedShort13 = i43;
        }
        int unsignedShort14 = readUnsignedShort(field);
        int method = field + 2;
        while (true) {
            int i44 = unsignedShort14 - 1;
            if (unsignedShort14 > 0) {
                method = readMethod(classVisitor, context, method);
                unsignedShort14 = i44;
            } else {
                classVisitor.visitEnd();
                return;
            }
        }
    }

    private void readModuleAttributes(ClassVisitor classVisitor, Context context, int i, int i2, String str) {
        String[] strArr;
        char[] cArr = context.charBuffer;
        int i3 = i + 6;
        ModuleVisitor moduleVisitorVisitModule = classVisitor.visitModule(readModule(i, cArr), readUnsignedShort(i + 2), readUTF8(i + 4, cArr));
        if (moduleVisitorVisitModule == null) {
            return;
        }
        if (str != null) {
            moduleVisitorVisitModule.visitMainClass(str);
        }
        if (i2 != 0) {
            int unsignedShort = readUnsignedShort(i2);
            int i4 = i2 + 2;
            while (true) {
                int i5 = unsignedShort - 1;
                if (unsignedShort <= 0) {
                    break;
                }
                moduleVisitorVisitModule.visitPackage(readPackage(i4, cArr));
                i4 += 2;
                unsignedShort = i5;
            }
        }
        int unsignedShort2 = readUnsignedShort(i3);
        int i6 = i + 8;
        while (true) {
            int i7 = unsignedShort2 - 1;
            if (unsignedShort2 <= 0) {
                break;
            }
            String module = readModule(i6, cArr);
            int unsignedShort3 = readUnsignedShort(i6 + 2);
            String utf8 = readUTF8(i6 + 4, cArr);
            i6 += 6;
            moduleVisitorVisitModule.visitRequire(module, unsignedShort3, utf8);
            unsignedShort2 = i7;
        }
        int unsignedShort4 = readUnsignedShort(i6);
        int i8 = i6 + 2;
        while (true) {
            int i9 = unsignedShort4 - 1;
            String[] strArr2 = null;
            if (unsignedShort4 <= 0) {
                break;
            }
            String str2 = readPackage(i8, cArr);
            int unsignedShort5 = readUnsignedShort(i8 + 2);
            int unsignedShort6 = readUnsignedShort(i8 + 4);
            i8 += 6;
            if (unsignedShort6 != 0) {
                strArr2 = new String[unsignedShort6];
                for (int i10 = 0; i10 < unsignedShort6; i10++) {
                    strArr2[i10] = readModule(i8, cArr);
                    i8 += 2;
                }
            }
            moduleVisitorVisitModule.visitExport(str2, unsignedShort5, strArr2);
            unsignedShort4 = i9;
        }
        int unsignedShort7 = readUnsignedShort(i8);
        int i11 = i8 + 2;
        while (true) {
            int i12 = unsignedShort7 - 1;
            if (unsignedShort7 <= 0) {
                break;
            }
            String str3 = readPackage(i11, cArr);
            int unsignedShort8 = readUnsignedShort(i11 + 2);
            int unsignedShort9 = readUnsignedShort(i11 + 4);
            i11 += 6;
            if (unsignedShort9 != 0) {
                strArr = new String[unsignedShort9];
                for (int i13 = 0; i13 < unsignedShort9; i13++) {
                    strArr[i13] = readModule(i11, cArr);
                    i11 += 2;
                }
            } else {
                strArr = null;
            }
            moduleVisitorVisitModule.visitOpen(str3, unsignedShort8, strArr);
            unsignedShort7 = i12;
        }
        int unsignedShort10 = readUnsignedShort(i11);
        int i14 = i11 + 2;
        while (true) {
            int i15 = unsignedShort10 - 1;
            if (unsignedShort10 <= 0) {
                break;
            }
            moduleVisitorVisitModule.visitUse(readClass(i14, cArr));
            i14 += 2;
            unsignedShort10 = i15;
        }
        int unsignedShort11 = readUnsignedShort(i14);
        int i16 = i14 + 2;
        while (true) {
            int i17 = unsignedShort11 - 1;
            if (unsignedShort11 > 0) {
                String str4 = readClass(i16, cArr);
                int unsignedShort12 = readUnsignedShort(i16 + 2);
                i16 += 4;
                String[] strArr3 = new String[unsignedShort12];
                for (int i18 = 0; i18 < unsignedShort12; i18++) {
                    strArr3[i18] = readClass(i16, cArr);
                    i16 += 2;
                }
                moduleVisitorVisitModule.visitProvide(str4, strArr3);
                unsignedShort11 = i17;
            } else {
                moduleVisitorVisitModule.visitEnd();
                return;
            }
        }
    }

    private int readRecordComponent(ClassVisitor classVisitor, Context context, int i) {
        int i2;
        Context context2 = context;
        char[] cArr = context2.charBuffer;
        String utf8 = readUTF8(i, cArr);
        String utf82 = readUTF8(i + 2, cArr);
        int unsignedShort = readUnsignedShort(i + 4);
        int i3 = i + 6;
        int i4 = 0;
        Attribute attribute = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        String utf83 = null;
        while (true) {
            int i8 = unsignedShort - 1;
            if (unsignedShort <= 0) {
                break;
            }
            String utf84 = readUTF8(i3, cArr);
            int i9 = readInt(i3 + 2);
            int i10 = i3 + 6;
            if ("Signature".equals(utf84)) {
                utf83 = readUTF8(i10, cArr);
                i2 = i10;
            } else if ("RuntimeVisibleAnnotations".equals(utf84)) {
                i7 = i10;
                i2 = i7;
            } else if ("RuntimeVisibleTypeAnnotations".equals(utf84)) {
                i5 = i10;
                i2 = i5;
            } else if ("RuntimeInvisibleAnnotations".equals(utf84)) {
                i6 = i10;
                i2 = i6;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(utf84)) {
                i4 = i10;
                i2 = i4;
            } else {
                i2 = i10;
                Attribute attribute2 = attribute;
                attribute = readAttribute(context2.attributePrototypes, utf84, i2, i9, cArr, -1, null);
                attribute.nextAttribute = attribute2;
                i7 = i7;
                i6 = i6;
                i5 = i5;
                i4 = i4;
            }
            i3 = i2 + i9;
            context2 = context;
            unsignedShort = i8;
        }
        int i11 = i4;
        Attribute attribute3 = attribute;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        RecordComponentVisitor recordComponentVisitorVisitRecordComponent = classVisitor.visitRecordComponent(utf8, utf82, utf83);
        if (recordComponentVisitorVisitRecordComponent == null) {
            return i3;
        }
        if (i14 != 0) {
            int unsignedShort2 = readUnsignedShort(i14);
            int elementValues = i14 + 2;
            while (true) {
                int i15 = unsignedShort2 - 1;
                if (unsignedShort2 <= 0) {
                    break;
                }
                elementValues = readElementValues(recordComponentVisitorVisitRecordComponent.visitAnnotation(readUTF8(elementValues, cArr), true), elementValues + 2, true, cArr);
                unsignedShort2 = i15;
            }
        }
        if (i13 != 0) {
            int unsignedShort3 = readUnsignedShort(i13);
            int elementValues2 = i13 + 2;
            while (true) {
                int i16 = unsignedShort3 - 1;
                if (unsignedShort3 <= 0) {
                    break;
                }
                elementValues2 = readElementValues(recordComponentVisitorVisitRecordComponent.visitAnnotation(readUTF8(elementValues2, cArr), false), elementValues2 + 2, true, cArr);
                unsignedShort3 = i16;
            }
        }
        if (i12 != 0) {
            int unsignedShort4 = readUnsignedShort(i12);
            int elementValues3 = i12 + 2;
            while (true) {
                int i17 = unsignedShort4 - 1;
                if (unsignedShort4 <= 0) {
                    break;
                }
                int typeAnnotationTarget = readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = readElementValues(recordComponentVisitorVisitRecordComponent.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget, cArr), true), typeAnnotationTarget + 2, true, cArr);
                unsignedShort4 = i17;
            }
        }
        if (i11 != 0) {
            int unsignedShort5 = readUnsignedShort(i11);
            int elementValues4 = i11 + 2;
            while (true) {
                int i18 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = readElementValues(recordComponentVisitorVisitRecordComponent.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget2, cArr), false), typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort5 = i18;
            }
        }
        Attribute attribute4 = attribute3;
        while (attribute4 != null) {
            Attribute attribute5 = attribute4.nextAttribute;
            attribute4.nextAttribute = null;
            recordComponentVisitorVisitRecordComponent.visitAttribute(attribute4);
            attribute4 = attribute5;
        }
        recordComponentVisitorVisitRecordComponent.visitEnd();
        return i3;
    }

    private int readField(ClassVisitor classVisitor, Context context, int i) {
        int i2;
        int i3;
        Context context2 = context;
        char[] cArr = context2.charBuffer;
        int unsignedShort = readUnsignedShort(i);
        String utf8 = readUTF8(i + 2, cArr);
        String utf82 = readUTF8(i + 4, cArr);
        int unsignedShort2 = readUnsignedShort(i + 6);
        int i4 = i + 8;
        int i5 = unsignedShort;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Attribute attribute = null;
        String utf83 = null;
        Object obj = null;
        while (true) {
            int i10 = unsignedShort2 - 1;
            if (unsignedShort2 <= 0) {
                break;
            }
            String utf84 = readUTF8(i4, cArr);
            int i11 = readInt(i4 + 2);
            int i12 = i4 + 6;
            if ("ConstantValue".equals(utf84)) {
                int unsignedShort3 = readUnsignedShort(i12);
                obj = unsignedShort3 == 0 ? null : readConst(unsignedShort3, cArr);
            } else if ("Signature".equals(utf84)) {
                utf83 = readUTF8(i12, cArr);
            } else {
                if ("Deprecated".equals(utf84)) {
                    i3 = 131072 | i5;
                } else if ("Synthetic".equals(utf84)) {
                    i3 = i5 | 4096;
                } else {
                    if ("RuntimeVisibleAnnotations".equals(utf84)) {
                        i9 = i12;
                        i2 = i9;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(utf84)) {
                        i7 = i12;
                        i2 = i7;
                    } else if ("RuntimeInvisibleAnnotations".equals(utf84)) {
                        i8 = i12;
                        i2 = i8;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(utf84)) {
                        i6 = i12;
                        i2 = i6;
                    } else {
                        i2 = i12;
                        Attribute attribute2 = attribute;
                        attribute = readAttribute(context2.attributePrototypes, utf84, i2, i11, cArr, -1, null);
                        attribute.nextAttribute = attribute2;
                        i8 = i8;
                        i9 = i9;
                        i6 = i6;
                        i7 = i7;
                    }
                    i4 = i2 + i11;
                    context2 = context;
                    unsignedShort2 = i10;
                }
                i5 = i3;
            }
            i2 = i12;
            i4 = i2 + i11;
            context2 = context;
            unsignedShort2 = i10;
        }
        Attribute attribute3 = attribute;
        int i13 = i6;
        int i14 = i7;
        int i15 = i8;
        int i16 = i9;
        FieldVisitor fieldVisitorVisitField = classVisitor.visitField(i5, utf8, utf82, utf83, obj);
        if (fieldVisitorVisitField == null) {
            return i4;
        }
        if (i16 != 0) {
            int unsignedShort4 = readUnsignedShort(i16);
            int elementValues = i16 + 2;
            while (true) {
                int i17 = unsignedShort4 - 1;
                if (unsignedShort4 <= 0) {
                    break;
                }
                elementValues = readElementValues(fieldVisitorVisitField.visitAnnotation(readUTF8(elementValues, cArr), true), elementValues + 2, true, cArr);
                unsignedShort4 = i17;
            }
        }
        if (i15 != 0) {
            int unsignedShort5 = readUnsignedShort(i15);
            int elementValues2 = i15 + 2;
            while (true) {
                int i18 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                elementValues2 = readElementValues(fieldVisitorVisitField.visitAnnotation(readUTF8(elementValues2, cArr), false), elementValues2 + 2, true, cArr);
                unsignedShort5 = i18;
            }
        }
        if (i14 != 0) {
            int unsignedShort6 = readUnsignedShort(i14);
            int elementValues3 = i14 + 2;
            while (true) {
                int i19 = unsignedShort6 - 1;
                if (unsignedShort6 <= 0) {
                    break;
                }
                int typeAnnotationTarget = readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = readElementValues(fieldVisitorVisitField.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget, cArr), true), typeAnnotationTarget + 2, true, cArr);
                unsignedShort6 = i19;
            }
        }
        if (i13 != 0) {
            int unsignedShort7 = readUnsignedShort(i13);
            int elementValues4 = i13 + 2;
            while (true) {
                int i20 = unsignedShort7 - 1;
                if (unsignedShort7 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = readElementValues(fieldVisitorVisitField.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget2, cArr), false), typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort7 = i20;
            }
        }
        while (true) {
            Attribute attribute4 = attribute3;
            if (attribute4 != null) {
                attribute3 = attribute4.nextAttribute;
                attribute4.nextAttribute = null;
                fieldVisitorVisitField.visitAttribute(attribute4);
            } else {
                fieldVisitorVisitField.visitEnd();
                return i4;
            }
        }
    }

    private int readMethod(ClassVisitor classVisitor, Context context, int i) {
        int i2;
        int i3;
        char[] cArr = context.charBuffer;
        context.currentMethodAccessFlags = readUnsignedShort(i);
        context.currentMethodName = readUTF8(i + 2, cArr);
        int i4 = i + 4;
        context.currentMethodDescriptor = readUTF8(i4, cArr);
        int unsignedShort = readUnsignedShort(i + 6);
        int i5 = i + 8;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int unsignedShort2 = 0;
        Attribute attribute = null;
        boolean z = false;
        int i11 = 0;
        String[] strArr = null;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            int i16 = unsignedShort - 1;
            if (unsignedShort <= 0) {
                break;
            }
            String utf8 = readUTF8(i5, cArr);
            int i17 = readInt(i5 + 2);
            int i18 = unsignedShort2;
            int i19 = i5 + 6;
            int i20 = i6;
            if ("Code".equals(utf8)) {
                if ((context.parsingOptions & 1) == 0) {
                    i15 = i19;
                    i6 = i20;
                    unsignedShort2 = i18;
                    i3 = i15;
                    i5 = i3 + i17;
                    unsignedShort = i16;
                } else {
                    i2 = i7;
                    i6 = i20;
                    i7 = i2;
                }
            } else {
                if ("Exceptions".equals(utf8)) {
                    int unsignedShort3 = readUnsignedShort(i19);
                    String[] strArr2 = new String[unsignedShort3];
                    int i21 = i5 + 8;
                    int i22 = i7;
                    for (int i23 = 0; i23 < unsignedShort3; i23++) {
                        strArr2[i23] = readClass(i21, cArr);
                        i21 += 2;
                    }
                    strArr = strArr2;
                    i11 = i19;
                    i6 = i20;
                    i7 = i22;
                    unsignedShort2 = i18;
                    i3 = i11;
                } else {
                    i2 = i7;
                    if ("Signature".equals(utf8)) {
                        i3 = i19;
                        i6 = i20;
                        i7 = i2;
                        unsignedShort2 = readUnsignedShort(i19);
                    } else if ("Deprecated".equals(utf8)) {
                        context.currentMethodAccessFlags |= 131072;
                        i6 = i20;
                        i7 = i2;
                    } else if ("RuntimeVisibleAnnotations".equals(utf8)) {
                        i8 = i19;
                        i6 = i20;
                        i7 = i2;
                        unsignedShort2 = i18;
                        i3 = i8;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(utf8)) {
                        i6 = i19;
                        i7 = i2;
                        unsignedShort2 = i18;
                        i3 = i6;
                    } else if ("AnnotationDefault".equals(utf8)) {
                        i9 = i19;
                        i6 = i20;
                        i7 = i2;
                        unsignedShort2 = i18;
                        i3 = i9;
                    } else if ("Synthetic".equals(utf8)) {
                        context.currentMethodAccessFlags |= 4096;
                        i6 = i20;
                        i7 = i2;
                        z = true;
                    } else if ("RuntimeInvisibleAnnotations".equals(utf8)) {
                        i7 = i19;
                        i6 = i20;
                        unsignedShort2 = i18;
                        i3 = i7;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(utf8)) {
                        i12 = i19;
                        i6 = i20;
                        i7 = i2;
                        unsignedShort2 = i18;
                        i3 = i12;
                    } else if ("RuntimeVisibleParameterAnnotations".equals(utf8)) {
                        i13 = i19;
                        i6 = i20;
                        i7 = i2;
                        unsignedShort2 = i18;
                        i3 = i13;
                    } else if ("RuntimeInvisibleParameterAnnotations".equals(utf8)) {
                        i14 = i19;
                        i6 = i20;
                        i7 = i2;
                        unsignedShort2 = i18;
                        i3 = i14;
                    } else if ("MethodParameters".equals(utf8)) {
                        i10 = i19;
                        i6 = i20;
                        i7 = i2;
                        unsignedShort2 = i18;
                        i3 = i10;
                    } else {
                        i3 = i19;
                        Attribute attribute2 = readAttribute(context.attributePrototypes, utf8, i19, i17, cArr, -1, null);
                        attribute2.nextAttribute = attribute;
                        attribute = attribute2;
                        unsignedShort2 = i18;
                        i6 = i20;
                        i7 = i2;
                        i8 = i8;
                        i9 = i9;
                        i10 = i10;
                    }
                }
                i5 = i3 + i17;
                unsignedShort = i16;
            }
            i3 = i19;
            unsignedShort2 = i18;
            i5 = i3 + i17;
            unsignedShort = i16;
        }
        int i24 = i6;
        int i25 = i7;
        int i26 = i8;
        int i27 = i9;
        int i28 = i10;
        int i29 = unsignedShort2;
        MethodVisitor methodVisitorVisitMethod = classVisitor.visitMethod(context.currentMethodAccessFlags, context.currentMethodName, context.currentMethodDescriptor, i29 == 0 ? null : readUtf(i29, cArr), strArr);
        if (methodVisitorVisitMethod == null) {
            return i5;
        }
        if (methodVisitorVisitMethod instanceof MethodWriter) {
            MethodWriter methodWriter = (MethodWriter) methodVisitorVisitMethod;
            if (methodWriter.canCopyMethodAttributes(this, z, (context.currentMethodAccessFlags & 131072) != 0, readUnsignedShort(i4), i29, i11)) {
                methodWriter.setMethodAttributesSource(i, i5 - i);
                return i5;
            }
        }
        if (i28 != 0 && (context.parsingOptions & 2) == 0) {
            int i30 = readByte(i28);
            int i31 = i28 + 1;
            while (true) {
                int i32 = i30 - 1;
                if (i30 <= 0) {
                    break;
                }
                methodVisitorVisitMethod.visitParameter(readUTF8(i31, cArr), readUnsignedShort(i31 + 2));
                i31 += 4;
                i30 = i32;
            }
        }
        if (i27 != 0) {
            AnnotationVisitor annotationVisitorVisitAnnotationDefault = methodVisitorVisitMethod.visitAnnotationDefault();
            readElementValue(annotationVisitorVisitAnnotationDefault, i27, null, cArr);
            if (annotationVisitorVisitAnnotationDefault != null) {
                annotationVisitorVisitAnnotationDefault.visitEnd();
            }
        }
        if (i26 != 0) {
            int unsignedShort4 = readUnsignedShort(i26);
            int elementValues = i26 + 2;
            while (true) {
                int i33 = unsignedShort4 - 1;
                if (unsignedShort4 <= 0) {
                    break;
                }
                elementValues = readElementValues(methodVisitorVisitMethod.visitAnnotation(readUTF8(elementValues, cArr), true), elementValues + 2, true, cArr);
                unsignedShort4 = i33;
            }
        }
        if (i25 != 0) {
            int unsignedShort5 = readUnsignedShort(i25);
            int elementValues2 = i25 + 2;
            while (true) {
                int i34 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                elementValues2 = readElementValues(methodVisitorVisitMethod.visitAnnotation(readUTF8(elementValues2, cArr), false), elementValues2 + 2, true, cArr);
                unsignedShort5 = i34;
            }
        }
        if (i24 != 0) {
            int unsignedShort6 = readUnsignedShort(i24);
            int elementValues3 = i24 + 2;
            while (true) {
                int i35 = unsignedShort6 - 1;
                if (unsignedShort6 <= 0) {
                    break;
                }
                int typeAnnotationTarget = readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = readElementValues(methodVisitorVisitMethod.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget, cArr), true), typeAnnotationTarget + 2, true, cArr);
                unsignedShort6 = i35;
            }
        }
        int i36 = i12;
        if (i36 != 0) {
            int unsignedShort7 = readUnsignedShort(i36);
            int elementValues4 = i36 + 2;
            while (true) {
                int i37 = unsignedShort7 - 1;
                if (unsignedShort7 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = readElementValues(methodVisitorVisitMethod.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget2, cArr), false), typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort7 = i37;
            }
        }
        int i38 = i13;
        if (i38 != 0) {
            readParameterAnnotations(methodVisitorVisitMethod, context, i38, true);
        }
        int i39 = i14;
        if (i39 != 0) {
            readParameterAnnotations(methodVisitorVisitMethod, context, i39, false);
        }
        while (attribute != null) {
            Attribute attribute3 = attribute.nextAttribute;
            attribute.nextAttribute = null;
            methodVisitorVisitMethod.visitAttribute(attribute);
            attribute = attribute3;
        }
        int i40 = i15;
        if (i40 != 0) {
            methodVisitorVisitMethod.visitCode();
            readCode(methodVisitorVisitMethod, context, i40);
        }
        methodVisitorVisitMethod.visitEnd();
        return i5;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private void readCode(org.objectweb.asm.MethodVisitor r42, org.objectweb.asm.Context r43, int r44) {
        /*
            Method dump skipped, instructions count: 3438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassReader.readCode(org.objectweb.asm.MethodVisitor, org.objectweb.asm.Context, int):void");
    }

    protected Label readLabel(int i, Label[] labelArr) {
        if (labelArr[i] == null) {
            labelArr[i] = new Label();
        }
        return labelArr[i];
    }

    private Label createLabel(int i, Label[] labelArr) {
        Label label = readLabel(i, labelArr);
        label.flags = (short) (label.flags & (-2));
        return label;
    }

    private void createDebugLabel(int i, Label[] labelArr) {
        if (labelArr[i] == null) {
            Label label = readLabel(i, labelArr);
            label.flags = (short) (label.flags | 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int[] readTypeAnnotations(org.objectweb.asm.MethodVisitor r11, org.objectweb.asm.Context r12, int r13, boolean r14) {
        /*
            r10 = this;
            char[] r0 = r12.charBuffer
            int r1 = r10.readUnsignedShort(r13)
            int[] r2 = new int[r1]
            int r13 = r13 + 2
            r3 = 0
        Lb:
            if (r3 >= r1) goto L84
            r2[r3] = r13
            int r4 = r10.readInt(r13)
            int r5 = r4 >>> 24
            r6 = 23
            if (r5 == r6) goto L4d
            switch(r5) {
                case 16: goto L4d;
                case 17: goto L4d;
                case 18: goto L4d;
                default: goto L1c;
            }
        L1c:
            switch(r5) {
                case 64: goto L28;
                case 65: goto L28;
                case 66: goto L4d;
                case 67: goto L4d;
                case 68: goto L4d;
                case 69: goto L4d;
                case 70: goto L4d;
                case 71: goto L25;
                case 72: goto L25;
                case 73: goto L25;
                case 74: goto L25;
                case 75: goto L25;
                default: goto L1f;
            }
        L1f:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r11.<init>()
            throw r11
        L25:
            int r13 = r13 + 4
            goto L4f
        L28:
            int r6 = r13 + 1
            int r6 = r10.readUnsignedShort(r6)
            int r13 = r13 + 3
        L30:
            int r7 = r6 + (-1)
            if (r6 <= 0) goto L4f
            int r6 = r10.readUnsignedShort(r13)
            int r8 = r13 + 2
            int r8 = r10.readUnsignedShort(r8)
            int r13 = r13 + 6
            org.objectweb.asm.Label[] r9 = r12.currentMethodLabels
            r10.createLabel(r6, r9)
            int r6 = r6 + r8
            org.objectweb.asm.Label[] r8 = r12.currentMethodLabels
            r10.createLabel(r6, r8)
            r6 = r7
            goto L30
        L4d:
            int r13 = r13 + 3
        L4f:
            int r6 = r10.readByte(r13)
            r7 = 66
            r8 = 0
            r9 = 1
            if (r5 != r7) goto L78
            if (r6 != 0) goto L5c
            goto L63
        L5c:
            org.objectweb.asm.TypePath r8 = new org.objectweb.asm.TypePath
            byte[] r5 = r10.classFileBuffer
            r8.<init>(r5, r13)
        L63:
            int r6 = r6 * 2
            int r6 = r6 + r9
            int r13 = r13 + r6
            java.lang.String r5 = r10.readUTF8(r13, r0)
            int r13 = r13 + 2
            r4 = r4 & (-256(0xffffffffffffff00, float:NaN))
            org.objectweb.asm.AnnotationVisitor r4 = r11.visitTryCatchAnnotation(r4, r8, r5, r14)
            int r13 = r10.readElementValues(r4, r13, r9, r0)
            goto L81
        L78:
            int r6 = r6 * 2
            int r6 = r6 + 3
            int r13 = r13 + r6
            int r13 = r10.readElementValues(r8, r13, r9, r0)
        L81:
            int r3 = r3 + 1
            goto Lb
        L84:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassReader.readTypeAnnotations(org.objectweb.asm.MethodVisitor, org.objectweb.asm.Context, int, boolean):int[]");
    }

    private int getTypeAnnotationBytecodeOffset(int[] iArr, int i) {
        if (iArr == null || i >= iArr.length || readByte(iArr[i]) < 67) {
            return -1;
        }
        return readUnsignedShort(iArr[i] + 1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int readTypeAnnotationTarget(org.objectweb.asm.Context r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.readInt(r11)
            int r1 = r0 >>> 24
            r2 = 1
            if (r1 == 0) goto L70
            if (r1 == r2) goto L70
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            switch(r1) {
                case 16: goto L6b;
                case 17: goto L6b;
                case 18: goto L6b;
                case 19: goto L68;
                case 20: goto L68;
                case 21: goto L68;
                case 22: goto L70;
                case 23: goto L6b;
                default: goto L10;
            }
        L10:
            switch(r1) {
                case 64: goto L22;
                case 65: goto L22;
                case 66: goto L6b;
                case 67: goto L20;
                case 68: goto L20;
                case 69: goto L20;
                case 70: goto L20;
                case 71: goto L19;
                case 72: goto L19;
                case 73: goto L19;
                case 74: goto L19;
                case 75: goto L19;
                default: goto L13;
            }
        L13:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>()
            throw r10
        L19:
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0 = r0 & r1
            int r11 = r11 + 4
            goto L75
        L20:
            r0 = r0 & r3
            goto L6d
        L22:
            r0 = r0 & r3
            int r1 = r11 + 1
            int r1 = r9.readUnsignedShort(r1)
            int r11 = r11 + 3
            org.objectweb.asm.Label[] r3 = new org.objectweb.asm.Label[r1]
            r10.currentLocalVariableAnnotationRangeStarts = r3
            org.objectweb.asm.Label[] r3 = new org.objectweb.asm.Label[r1]
            r10.currentLocalVariableAnnotationRangeEnds = r3
            int[] r3 = new int[r1]
            r10.currentLocalVariableAnnotationRangeIndices = r3
            r3 = 0
        L38:
            if (r3 >= r1) goto L75
            int r4 = r9.readUnsignedShort(r11)
            int r5 = r11 + 2
            int r5 = r9.readUnsignedShort(r5)
            int r6 = r11 + 4
            int r6 = r9.readUnsignedShort(r6)
            int r11 = r11 + 6
            org.objectweb.asm.Label[] r7 = r10.currentLocalVariableAnnotationRangeStarts
            org.objectweb.asm.Label[] r8 = r10.currentMethodLabels
            org.objectweb.asm.Label r8 = r9.createLabel(r4, r8)
            r7[r3] = r8
            org.objectweb.asm.Label[] r7 = r10.currentLocalVariableAnnotationRangeEnds
            int r4 = r4 + r5
            org.objectweb.asm.Label[] r5 = r10.currentMethodLabels
            org.objectweb.asm.Label r4 = r9.createLabel(r4, r5)
            r7[r3] = r4
            int[] r4 = r10.currentLocalVariableAnnotationRangeIndices
            r4[r3] = r6
            int r3 = r3 + 1
            goto L38
        L68:
            r0 = r0 & r3
            int r11 = r11 + r2
            goto L75
        L6b:
            r0 = r0 & (-256(0xffffffffffffff00, float:NaN))
        L6d:
            int r11 = r11 + 3
            goto L75
        L70:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0 = r0 & r1
            int r11 = r11 + 2
        L75:
            r10.currentTypeAnnotationTarget = r0
            int r0 = r9.readByte(r11)
            if (r0 != 0) goto L7f
            r1 = 0
            goto L86
        L7f:
            org.objectweb.asm.TypePath r1 = new org.objectweb.asm.TypePath
            byte[] r3 = r9.classFileBuffer
            r1.<init>(r3, r11)
        L86:
            r10.currentTypeAnnotationTargetPath = r1
            int r11 = r11 + r2
            int r0 = r0 * 2
            int r11 = r11 + r0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassReader.readTypeAnnotationTarget(org.objectweb.asm.Context, int):int");
    }

    private void readParameterAnnotations(MethodVisitor methodVisitor, Context context, int i, boolean z) {
        int elementValues = i + 1;
        int i2 = this.classFileBuffer[i] & 255;
        methodVisitor.visitAnnotableParameterCount(i2, z);
        char[] cArr = context.charBuffer;
        for (int i3 = 0; i3 < i2; i3++) {
            int unsignedShort = readUnsignedShort(elementValues);
            elementValues += 2;
            while (true) {
                int i4 = unsignedShort - 1;
                if (unsignedShort > 0) {
                    elementValues = readElementValues(methodVisitor.visitParameterAnnotation(i3, readUTF8(elementValues, cArr), z), elementValues + 2, true, cArr);
                    unsignedShort = i4;
                }
            }
        }
    }

    private int readElementValues(AnnotationVisitor annotationVisitor, int i, boolean z, char[] cArr) {
        int unsignedShort = readUnsignedShort(i);
        int elementValue = i + 2;
        if (!z) {
            while (true) {
                int i2 = unsignedShort - 1;
                if (unsignedShort <= 0) {
                    break;
                }
                elementValue = readElementValue(annotationVisitor, elementValue, null, cArr);
                unsignedShort = i2;
            }
        } else {
            while (true) {
                int i3 = unsignedShort - 1;
                if (unsignedShort <= 0) {
                    break;
                }
                elementValue = readElementValue(annotationVisitor, elementValue + 2, readUTF8(elementValue, cArr), cArr);
                unsignedShort = i3;
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return elementValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x020a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int readElementValue(org.objectweb.asm.AnnotationVisitor r11, int r12, java.lang.String r13, char[] r14) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassReader.readElementValue(org.objectweb.asm.AnnotationVisitor, int, java.lang.String, char[]):int");
    }

    private void computeImplicitFrame(Context context) {
        int i;
        String str = context.currentMethodDescriptor;
        Object[] objArr = context.currentFrameLocalTypes;
        int i2 = 0;
        if ((context.currentMethodAccessFlags & 8) == 0) {
            if (SdkConstants.CONSTRUCTOR_NAME.equals(context.currentMethodName)) {
                objArr[0] = Opcodes.UNINITIALIZED_THIS;
            } else {
                objArr[0] = readClass(this.header + 2, context.charBuffer);
            }
            i2 = 1;
        }
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt = str.charAt(i3);
            if (cCharAt == 'F') {
                i = i2 + 1;
                objArr[i2] = Opcodes.FLOAT;
            } else if (cCharAt != 'L') {
                if (cCharAt != 'S' && cCharAt != 'I') {
                    if (cCharAt == 'J') {
                        i = i2 + 1;
                        objArr[i2] = Opcodes.LONG;
                    } else if (cCharAt != 'Z') {
                        if (cCharAt != '[') {
                            switch (cCharAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    i = i2 + 1;
                                    objArr[i2] = Opcodes.DOUBLE;
                                    break;
                                default:
                                    context.currentFrameLocalCount = i2;
                                    return;
                            }
                        } else {
                            while (str.charAt(i4) == '[') {
                                i4++;
                            }
                            if (str.charAt(i4) == 'L') {
                                do {
                                    i4++;
                                } while (str.charAt(i4) != ';');
                            }
                            int i5 = i4 + 1;
                            objArr[i2] = str.substring(i3, i5);
                            i3 = i5;
                            i2++;
                        }
                    }
                }
                i = i2 + 1;
                objArr[i2] = Opcodes.INTEGER;
            } else {
                int i6 = i4;
                while (str.charAt(i6) != ';') {
                    i6++;
                }
                objArr[i2] = str.substring(i4, i6);
                i2++;
                i3 = i6 + 1;
            }
            i2 = i;
            i3 = i4;
        }
    }

    private int readStackMapFrame(int i, boolean z, boolean z2, Context context) {
        int verificationTypeInfo;
        int i2;
        char[] cArr = context.charBuffer;
        Label[] labelArr = context.currentMethodLabels;
        if (z) {
            verificationTypeInfo = i + 1;
            i2 = this.classFileBuffer[i] & 255;
        } else {
            context.currentFrameOffset = -1;
            verificationTypeInfo = i;
            i2 = 255;
        }
        context.currentFrameLocalCountDelta = 0;
        if (i2 < 64) {
            context.currentFrameType = 3;
            context.currentFrameStackCount = 0;
        } else if (i2 < 128) {
            i2 -= 64;
            verificationTypeInfo = readVerificationTypeInfo(verificationTypeInfo, context.currentFrameStackTypes, 0, cArr, labelArr);
            context.currentFrameType = 4;
            context.currentFrameStackCount = 1;
        } else if (i2 >= 247) {
            int unsignedShort = readUnsignedShort(verificationTypeInfo);
            int i3 = verificationTypeInfo + 2;
            if (i2 == 247) {
                verificationTypeInfo = readVerificationTypeInfo(i3, context.currentFrameStackTypes, 0, cArr, labelArr);
                context.currentFrameType = 4;
                context.currentFrameStackCount = 1;
            } else {
                if (i2 >= 248 && i2 < 251) {
                    context.currentFrameType = 2;
                    context.currentFrameLocalCountDelta = 251 - i2;
                    context.currentFrameLocalCount -= context.currentFrameLocalCountDelta;
                    context.currentFrameStackCount = 0;
                } else if (i2 == 251) {
                    context.currentFrameType = 3;
                    context.currentFrameStackCount = 0;
                } else if (i2 < 255) {
                    int i4 = i2 - 251;
                    int i5 = z2 ? context.currentFrameLocalCount : 0;
                    verificationTypeInfo = i3;
                    int i6 = i4;
                    while (i6 > 0) {
                        verificationTypeInfo = readVerificationTypeInfo(verificationTypeInfo, context.currentFrameLocalTypes, i5, cArr, labelArr);
                        i6--;
                        i5++;
                    }
                    context.currentFrameType = 1;
                    context.currentFrameLocalCountDelta = i4;
                    context.currentFrameLocalCount += context.currentFrameLocalCountDelta;
                    context.currentFrameStackCount = 0;
                } else {
                    int unsignedShort2 = readUnsignedShort(i3);
                    int verificationTypeInfo2 = verificationTypeInfo + 4;
                    context.currentFrameType = 0;
                    context.currentFrameLocalCountDelta = unsignedShort2;
                    context.currentFrameLocalCount = unsignedShort2;
                    for (int i7 = 0; i7 < unsignedShort2; i7++) {
                        verificationTypeInfo2 = readVerificationTypeInfo(verificationTypeInfo2, context.currentFrameLocalTypes, i7, cArr, labelArr);
                    }
                    int unsignedShort3 = readUnsignedShort(verificationTypeInfo2);
                    verificationTypeInfo = verificationTypeInfo2 + 2;
                    context.currentFrameStackCount = unsignedShort3;
                    for (int i8 = 0; i8 < unsignedShort3; i8++) {
                        verificationTypeInfo = readVerificationTypeInfo(verificationTypeInfo, context.currentFrameStackTypes, i8, cArr, labelArr);
                    }
                }
                verificationTypeInfo = i3;
            }
            i2 = unsignedShort;
        } else {
            throw new IllegalArgumentException();
        }
        context.currentFrameOffset += i2 + 1;
        createLabel(context.currentFrameOffset, labelArr);
        return verificationTypeInfo;
    }

    private int readVerificationTypeInfo(int i, Object[] objArr, int i2, char[] cArr, Label[] labelArr) {
        int i3 = i + 1;
        switch (this.classFileBuffer[i] & 255) {
            case 0:
                objArr[i2] = Opcodes.TOP;
                return i3;
            case 1:
                objArr[i2] = Opcodes.INTEGER;
                return i3;
            case 2:
                objArr[i2] = Opcodes.FLOAT;
                return i3;
            case 3:
                objArr[i2] = Opcodes.DOUBLE;
                return i3;
            case 4:
                objArr[i2] = Opcodes.LONG;
                return i3;
            case 5:
                objArr[i2] = Opcodes.NULL;
                return i3;
            case 6:
                objArr[i2] = Opcodes.UNINITIALIZED_THIS;
                return i3;
            case 7:
                objArr[i2] = readClass(i3, cArr);
                break;
            case 8:
                objArr[i2] = createLabel(readUnsignedShort(i3), labelArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i + 3;
    }

    final int getFirstAttributeOffset() {
        int i = this.header;
        int unsignedShort = i + 8 + (readUnsignedShort(i + 6) * 2);
        int unsignedShort2 = readUnsignedShort(unsignedShort);
        int i2 = unsignedShort + 2;
        while (true) {
            int i3 = unsignedShort2 - 1;
            if (unsignedShort2 <= 0) {
                break;
            }
            int unsignedShort3 = readUnsignedShort(i2 + 6);
            i2 += 8;
            while (true) {
                int i4 = unsignedShort3 - 1;
                if (unsignedShort3 > 0) {
                    i2 += readInt(i2 + 2) + 6;
                    unsignedShort3 = i4;
                }
            }
            unsignedShort2 = i3;
        }
        int unsignedShort4 = readUnsignedShort(i2);
        int i5 = i2 + 2;
        while (true) {
            int i6 = unsignedShort4 - 1;
            if (unsignedShort4 <= 0) {
                return i5 + 2;
            }
            int unsignedShort5 = readUnsignedShort(i5 + 6);
            i5 += 8;
            while (true) {
                int i7 = unsignedShort5 - 1;
                if (unsignedShort5 > 0) {
                    i5 += readInt(i5 + 2) + 6;
                    unsignedShort5 = i7;
                }
            }
            unsignedShort4 = i6;
        }
    }

    private int[] readBootstrapMethodsAttribute(int i) {
        char[] cArr = new char[i];
        int firstAttributeOffset = getFirstAttributeOffset();
        for (int unsignedShort = readUnsignedShort(firstAttributeOffset - 2); unsignedShort > 0; unsignedShort--) {
            String utf8 = readUTF8(firstAttributeOffset, cArr);
            int i2 = readInt(firstAttributeOffset + 2);
            int i3 = firstAttributeOffset + 6;
            if ("BootstrapMethods".equals(utf8)) {
                int unsignedShort2 = readUnsignedShort(i3);
                int[] iArr = new int[unsignedShort2];
                int unsignedShort3 = firstAttributeOffset + 8;
                for (int i4 = 0; i4 < unsignedShort2; i4++) {
                    iArr[i4] = unsignedShort3;
                    unsignedShort3 += (readUnsignedShort(unsignedShort3 + 2) * 2) + 4;
                }
                return iArr;
            }
            firstAttributeOffset = i3 + i2;
        }
        throw new IllegalArgumentException();
    }

    private Attribute readAttribute(Attribute[] attributeArr, String str, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        for (Attribute attribute : attributeArr) {
            if (attribute.type.equals(str)) {
                return attribute.read(this, i, i2, cArr, i3, labelArr);
            }
        }
        return new Attribute(str).read(this, i, i2, null, -1, null);
    }

    public int getItemCount() {
        return this.cpInfoOffsets.length;
    }

    public int getItem(int i) {
        return this.cpInfoOffsets[i];
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public int readByte(int i) {
        return this.classFileBuffer[i] & 255;
    }

    public int readUnsignedShort(int i) {
        byte[] bArr = this.classFileBuffer;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public short readShort(int i) {
        byte[] bArr = this.classFileBuffer;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public int readInt(int i) {
        byte[] bArr = this.classFileBuffer;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public long readLong(int i) {
        return (readInt(i) << 32) | (readInt(i + 4) & 4294967295L);
    }

    public String readUTF8(int i, char[] cArr) {
        int unsignedShort = readUnsignedShort(i);
        if (i == 0 || unsignedShort == 0) {
            return null;
        }
        return readUtf(unsignedShort, cArr);
    }

    final String readUtf(int i, char[] cArr) {
        String[] strArr = this.constantUtf8Values;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int i2 = this.cpInfoOffsets[i];
        String utf = readUtf(i2 + 2, readUnsignedShort(i2), cArr);
        strArr[i] = utf;
        return utf;
    }

    private String readUtf(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.classFileBuffer;
        int i5 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b = bArr[i];
            if ((b & 128) == 0) {
                cArr[i5] = (char) (b & 127);
                i5++;
                i = i6;
            } else {
                if ((b & 224) == 192) {
                    i3 = i5 + 1;
                    i += 2;
                    cArr[i5] = (char) (((b & 31) << 6) + (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                } else {
                    i3 = i5 + 1;
                    int i7 = i + 2;
                    i += 3;
                    cArr[i5] = (char) (((b & 15) << 12) + ((bArr[i6] & Utf8.REPLACEMENT_BYTE) << 6) + (bArr[i7] & Utf8.REPLACEMENT_BYTE));
                }
                i5 = i3;
            }
        }
        return new String(cArr, 0, i5);
    }

    private String readStringish(int i, char[] cArr) {
        return readUTF8(this.cpInfoOffsets[readUnsignedShort(i)], cArr);
    }

    public String readClass(int i, char[] cArr) {
        return readStringish(i, cArr);
    }

    public String readModule(int i, char[] cArr) {
        return readStringish(i, cArr);
    }

    public String readPackage(int i, char[] cArr) {
        return readStringish(i, cArr);
    }

    private ConstantDynamic readConstantDynamic(int i, char[] cArr) {
        ConstantDynamic constantDynamic = this.constantDynamicValues[i];
        if (constantDynamic != null) {
            return constantDynamic;
        }
        int[] iArr = this.cpInfoOffsets;
        int i2 = iArr[i];
        int i3 = iArr[readUnsignedShort(i2 + 2)];
        String utf8 = readUTF8(i3, cArr);
        String utf82 = readUTF8(i3 + 2, cArr);
        int i4 = this.bootstrapMethodOffsets[readUnsignedShort(i2)];
        Handle handle = (Handle) readConst(readUnsignedShort(i4), cArr);
        int unsignedShort = readUnsignedShort(i4 + 2);
        Object[] objArr = new Object[unsignedShort];
        int i5 = i4 + 4;
        for (int i6 = 0; i6 < unsignedShort; i6++) {
            objArr[i6] = readConst(readUnsignedShort(i5), cArr);
            i5 += 2;
        }
        ConstantDynamic[] constantDynamicArr = this.constantDynamicValues;
        ConstantDynamic constantDynamic2 = new ConstantDynamic(utf8, utf82, handle, objArr);
        constantDynamicArr[i] = constantDynamic2;
        return constantDynamic2;
    }

    public Object readConst(int i, char[] cArr) {
        int i2 = this.cpInfoOffsets[i];
        byte b = this.classFileBuffer[i2 - 1];
        switch (b) {
            case 3:
                return Integer.valueOf(readInt(i2));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(readInt(i2)));
            case 5:
                return Long.valueOf(readLong(i2));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(readLong(i2)));
            case 7:
                return Type.getObjectType(readUTF8(i2, cArr));
            case 8:
                return readUTF8(i2, cArr);
            default:
                switch (b) {
                    case 15:
                        int i3 = readByte(i2);
                        int i4 = this.cpInfoOffsets[readUnsignedShort(i2 + 1)];
                        int i5 = this.cpInfoOffsets[readUnsignedShort(i4 + 2)];
                        return new Handle(i3, readClass(i4, cArr), readUTF8(i5, cArr), readUTF8(i5 + 2, cArr), this.classFileBuffer[i4 - 1] == 11);
                    case 16:
                        return Type.getMethodType(readUTF8(i2, cArr));
                    case 17:
                        return readConstantDynamic(i, cArr);
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }
}
