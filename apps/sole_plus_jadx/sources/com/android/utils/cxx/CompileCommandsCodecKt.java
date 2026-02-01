package com.android.utils.cxx;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.CloseableKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: CompileCommandsCodec.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015\u001a&\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u001a\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015\u001a5\u0010\u001f\u001a\u0002H \"\u0004\b\u0000\u0010 2\u0006\u0010\u0019\u001a\u00020\u00152\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u0002H 0\"¢\u0006\u0002\b$H\u0082\b¢\u0006\u0002\u0010%\u001a\u000e\u0010&\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0015\u001a'\u0010'\u001a\u00020(2\u0006\u0010\u0019\u001a\u00020\u00152\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020(0\"¢\u0006\u0002\b$\u001av\u0010*\u001a\u00020(2\u0006\u0010\u0019\u001a\u00020\u00152f\u0010!\u001ab\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\t¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020(0+\u001a2\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010.\u001a\u00020\u00072\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u000704\u001a\u0018\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000106*\u000207H\u0002\u001a5\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t09*\u0002072\u0006\u0010:\u001a\u00020\u00012\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000709H\u0002¢\u0006\u0002\u0010<\u001a!\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000709*\u0002072\u0006\u0010:\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010>\u001a\f\u0010?\u001a\u00020\u0007*\u000207H\u0002\u001a\u001c\u0010@\u001a\u00020(*\u0002072\u0006\u0010:\u001a\u00020\u00012\u0006\u0010A\u001a\u00020BH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"BYTEBUFFER_WINDOW_SIZE", "", "COMPILE_COMMANDS_CODEC_VERSION", "COMPILE_COMMAND_CONTEXT_MESSAGE", "", "COMPILE_COMMAND_FILE_MESSAGE", "MAGIC", "", "STRIP_FLAGS_WITHOUT_ARG", "", "getSTRIP_FLAGS_WITHOUT_ARG", "()Ljava/util/List;", "STRIP_FLAGS_WITH_ARG", "getSTRIP_FLAGS_WITH_ARG", "STRIP_FLAGS_WITH_ARG_INCLUDING_OUTPUT_FILE", "getSTRIP_FLAGS_WITH_ARG_INCLUDING_OUTPUT_FILE", "STRIP_FLAGS_WITH_IMMEDIATE_ARG", "getSTRIP_FLAGS_WITH_IMMEDIATE_ARG", "STRIP_FLAGS_WITH_IMMEDIATE_ARG_INCLUDING_OUTPUT_FILE", "getSTRIP_FLAGS_WITH_IMMEDIATE_ARG_INCLUDING_OUTPUT_FILE", "VERSION_FALLBACK_OUTPUT_FILE", "Ljava/io/File;", "VERSION_FALLBACK_TARGET", "compileCommandsFileIsCurrentVersion", "", "file", "extractFlagArgument", "short", "long", "flags", "hasBug201754404", "indexCompileCommands", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function1;", "Lcom/android/utils/cxx/CompileCommandsInputStream;", "Lkotlin/ExtensionFunctionType;", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "readCompileCommandsVersionNumber", "streamCompileCommands", "", "Lcom/android/utils/cxx/CompileCommand;", "streamCompileCommandsV1", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "sourceFile", "compiler", "workingDirectory", "stripArgsForIde", "args", "scratchSpace", "", "positionAfterMagicAndVersion", "Lkotlin/Pair;", "Ljava/nio/ByteBuffer;", "readStringListsTable", "", "start", "strings", "(Ljava/nio/ByteBuffer;I[Ljava/lang/String;)[Ljava/util/List;", "readStringTable", "(Ljava/nio/ByteBuffer;I)[Ljava/lang/String;", "readUTF8", "seekSection", "section", "Lcom/android/utils/cxx/Sections;", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CompileCommandsCodecKt {
    private static final int BYTEBUFFER_WINDOW_SIZE = 32768;
    public static final int COMPILE_COMMANDS_CODEC_VERSION = 3;
    private static final byte COMPILE_COMMAND_CONTEXT_MESSAGE = 0;
    private static final byte COMPILE_COMMAND_FILE_MESSAGE = 1;
    private static final String MAGIC = "C/C++ Build Metadata\u001a";
    private static final List<String> STRIP_FLAGS_WITHOUT_ARG;
    private static final List<String> STRIP_FLAGS_WITH_ARG;
    private static final List<String> STRIP_FLAGS_WITH_ARG_INCLUDING_OUTPUT_FILE;
    private static final List<String> STRIP_FLAGS_WITH_IMMEDIATE_ARG;
    private static final List<String> STRIP_FLAGS_WITH_IMMEDIATE_ARG_INCLUDING_OUTPUT_FILE;
    private static final File VERSION_FALLBACK_OUTPUT_FILE = new File("compile-commands-fallback-output-file");
    private static final String VERSION_FALLBACK_TARGET = "compile-commands-fallback-targets-list";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, Integer> positionAfterMagicAndVersion(ByteBuffer byteBuffer) {
        byteBuffer.position(0);
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!byteBuffer.hasRemaining()) {
                return TuplesKt.to(0, 0);
            }
            if (byteBuffer.get() != ((byte) cCharAt)) {
                return TuplesKt.to(0, 0);
            }
        }
        return TuplesKt.to(Integer.valueOf(byteBuffer.position()), Integer.valueOf(byteBuffer.getInt()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void seekSection(ByteBuffer byteBuffer, int i, Sections sections) {
        ByteBuffer byteBuffer2 = byteBuffer;
        byteBuffer2.position(i);
        int i2 = byteBuffer.getInt();
        for (int i3 = 0; i3 < i2; i3++) {
            Sections byValue = Sections.INSTANCE.getByValue(byteBuffer.getInt());
            long j = byteBuffer.getLong();
            if (byValue == sections) {
                byteBuffer2.position((int) j);
                return;
            }
        }
    }

    private static final String readUTF8(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.getInt()];
        byteBuffer.get(bArr);
        return new String(bArr, Charsets.UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String[] readStringTable(ByteBuffer byteBuffer, int i) {
        seekSection(byteBuffer, i, Sections.StringTable);
        int i2 = byteBuffer.getInt();
        List listListOf = CollectionsKt.listOf((Object) null);
        IntRange intRangeUntil = RangesKt.until(0, i2);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(readUTF8(byteBuffer));
        }
        Object[] array = CollectionsKt.plus((Collection) listListOf, (Iterable) arrayList).toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String>[] readStringListsTable(ByteBuffer byteBuffer, int i, String[] strArr) {
        seekSection(byteBuffer, i, Sections.StringLists);
        IntRange intRangeUntil = RangesKt.until(0, byteBuffer.getInt());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            IntRange intRangeUntil2 = RangesKt.until(0, byteBuffer.getInt());
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil2, 10));
            Iterator<Integer> it2 = intRangeUntil2.iterator();
            while (it2.hasNext()) {
                ((IntIterator) it2).nextInt();
                String str = strArr[byteBuffer.getInt()];
                Intrinsics.checkNotNull(str);
                arrayList2.add(str);
            }
            arrayList.add(arrayList2);
        }
        Object[] array = arrayList.toArray(new List[0]);
        if (array != null) {
            return (List[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final void streamCompileCommandsV1(File file, final Function4<? super File, ? super File, ? super List<String>, ? super File, Unit> action) throws Exception {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(action, "action");
        streamCompileCommands(file, new Function1<CompileCommand, Unit>() { // from class: com.android.utils.cxx.CompileCommandsCodecKt.streamCompileCommandsV1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CompileCommand compileCommand) {
                invoke2(compileCommand);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CompileCommand streamCompileCommands) {
                Intrinsics.checkNotNullParameter(streamCompileCommands, "$this$streamCompileCommands");
                action.invoke(streamCompileCommands.getSourceFile(), streamCompileCommands.getCompiler(), streamCompileCommands.getFlags(), streamCompileCommands.getWorkingDirectory());
            }
        });
    }

    static {
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"-MF", "-MT", "-MQ"});
        STRIP_FLAGS_WITH_ARG = listListOf;
        STRIP_FLAGS_WITH_ARG_INCLUDING_OUTPUT_FILE = CollectionsKt.plus((Collection) CollectionsKt.listOf((Object[]) new String[]{"-o", "--output"}), (Iterable) listListOf);
        List<String> listListOf2 = CollectionsKt.listOf((Object[]) new String[]{"-MF", "-MT", "-MQ"});
        STRIP_FLAGS_WITH_IMMEDIATE_ARG = listListOf2;
        STRIP_FLAGS_WITH_IMMEDIATE_ARG_INCLUDING_OUTPUT_FILE = CollectionsKt.plus((Collection) CollectionsKt.listOf("--output="), (Iterable) listListOf2);
        STRIP_FLAGS_WITHOUT_ARG = CollectionsKt.listOf((Object[]) new String[]{"-M", "-MM", "-MD", "-MG", "-MP", "-MMD", "-c"});
    }

    private static final <T> T indexCompileCommands(File file, Function1<? super CompileCommandsInputStream, ? extends T> function1) throws Exception {
        CompileCommandsInputStream compileCommandsInputStream = new CompileCommandsInputStream(file);
        try {
            T tInvoke = function1.invoke(compileCommandsInputStream);
            InlineMarker.finallyStart(1);
            AutoCloseableKt.closeFinally(compileCommandsInputStream, null);
            InlineMarker.finallyEnd(1);
            return tInvoke;
        } finally {
        }
    }

    public static final void streamCompileCommands(File file, Function1<? super CompileCommand, Unit> action) throws Exception {
        File file2;
        List<String> list;
        File file3;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(action, "action");
        boolean zHasBug201754404 = hasBug201754404(file);
        CompileCommandsInputStream compileCommandsInputStream = new CompileCommandsInputStream(file);
        try {
            CompileCommandsInputStream compileCommandsInputStream2 = compileCommandsInputStream;
            int i3 = 2;
            int iM8007int = (compileCommandsInputStream2.getVersion() > 2 || (compileCommandsInputStream2.getVersion() == 2 && zHasBug201754404)) ? compileCommandsInputStream2.m8007int() : -1;
            File file4 = VERSION_FALLBACK_OUTPUT_FILE;
            int sourceMessagesCount = compileCommandsInputStream2.getSourceMessagesCount();
            File file5 = null;
            List<String> listStringList = null;
            File file6 = null;
            String strString = VERSION_FALLBACK_TARGET;
            int i4 = 0;
            int i5 = 0;
            while (i4 < sourceMessagesCount) {
                byte bM8006byte = compileCommandsInputStream2.m8006byte();
                if (bM8006byte == 0) {
                    file5 = compileCommandsInputStream2.file();
                    listStringList = compileCommandsInputStream2.stringList();
                    file6 = compileCommandsInputStream2.file();
                    if (compileCommandsInputStream2.getVersion() > i3 || zHasBug201754404) {
                        strString = compileCommandsInputStream2.string();
                    } else if (compileCommandsInputStream2.getVersion() == i3) {
                        file4 = compileCommandsInputStream2.file();
                    }
                    i = i4;
                    i2 = sourceMessagesCount;
                } else if (bM8006byte == 1) {
                    File file7 = compileCommandsInputStream2.file();
                    if (compileCommandsInputStream2.getVersion() > i3 || zHasBug201754404) {
                        file4 = compileCommandsInputStream2.file();
                    }
                    File file8 = file4;
                    if (file5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lastCompiler");
                        file2 = null;
                    } else {
                        file2 = file5;
                    }
                    if (listStringList == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lastFlags");
                        list = null;
                    } else {
                        list = listStringList;
                    }
                    if (file6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lastWorkingDirectory");
                        file3 = null;
                    } else {
                        file3 = file6;
                    }
                    i = i4;
                    i2 = sourceMessagesCount;
                    action.invoke(new CompileCommand(file7, file2, list, file3, file8, strString, i5, iM8007int));
                    i5++;
                    file4 = file8;
                } else {
                    throw new IllegalStateException("Unexpected".toString());
                }
                i4 = i + 1;
                sourceMessagesCount = i2;
                i3 = 2;
            }
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(compileCommandsInputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(compileCommandsInputStream, th);
                throw th2;
            }
        }
    }

    public static final boolean compileCommandsFileIsCurrentVersion(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return readCompileCommandsVersionNumber(file) == 3;
    }

    public static final int readCompileCommandsVersionNumber(File file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        FileChannel fileChannelOpen = FileChannel.open(file.toPath(), new OpenOption[0]);
        try {
            ByteBuffer map = ByteBuffer.allocate(MAGIC.length() + 4);
            fileChannelOpen.read(map);
            Intrinsics.checkNotNullExpressionValue(map, "map");
            int iIntValue = positionAfterMagicAndVersion(map).component2().intValue();
            CloseableKt.closeFinally(fileChannelOpen, null);
            return iIntValue;
        } finally {
        }
    }

    public static /* synthetic */ List stripArgsForIde$default(String str, List list, List list2, int i, Object obj) {
        if ((i & 4) != 0) {
            list2 = new ArrayList();
        }
        return stripArgsForIde(str, list, list2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List<java.lang.String> stripArgsForIde(java.lang.String r7, java.util.List<java.lang.String> r8, java.util.List<java.lang.String> r9) {
        /*
            java.lang.String r0 = "sourceFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "scratchSpace"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r9.clear()
            r0 = 0
            r1 = r0
        L16:
            int r2 = r8.size()
            if (r1 >= r2) goto L70
            java.lang.Object r2 = r8.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            java.util.List<java.lang.String> r3 = com.android.utils.cxx.CompileCommandsCodecKt.STRIP_FLAGS_WITHOUT_ARG
            boolean r3 = r3.contains(r2)
            if (r3 == 0) goto L2b
            goto L6d
        L2b:
            java.util.List<java.lang.String> r3 = com.android.utils.cxx.CompileCommandsCodecKt.STRIP_FLAGS_WITH_ARG_INCLUDING_OUTPUT_FILE
            boolean r3 = r3.contains(r2)
            if (r3 == 0) goto L36
            int r1 = r1 + 1
            goto L6d
        L36:
            java.util.List<java.lang.String> r3 = com.android.utils.cxx.CompileCommandsCodecKt.STRIP_FLAGS_WITH_IMMEDIATE_ARG_INCLUDING_OUTPUT_FILE
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L48
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L48
            goto L61
        L48:
            java.util.Iterator r3 = r3.iterator()
        L4c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L61
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r5 = 2
            r6 = 0
            boolean r4 = kotlin.text.StringsKt.startsWith$default(r2, r4, r0, r5, r6)
            if (r4 == 0) goto L4c
            goto L6d
        L61:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r7)
            if (r3 != 0) goto L6d
            r3 = r9
            java.util.Collection r3 = (java.util.Collection) r3
            r3.add(r2)
        L6d:
            int r1 = r1 + 1
            goto L16
        L70:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.utils.cxx.CompileCommandsCodecKt.stripArgsForIde(java.lang.String, java.util.List, java.util.List):java.util.List");
    }

    public static final List<String> getSTRIP_FLAGS_WITH_ARG() {
        return STRIP_FLAGS_WITH_ARG;
    }

    public static final List<String> getSTRIP_FLAGS_WITH_ARG_INCLUDING_OUTPUT_FILE() {
        return STRIP_FLAGS_WITH_ARG_INCLUDING_OUTPUT_FILE;
    }

    public static final List<String> getSTRIP_FLAGS_WITH_IMMEDIATE_ARG() {
        return STRIP_FLAGS_WITH_IMMEDIATE_ARG;
    }

    public static final List<String> getSTRIP_FLAGS_WITH_IMMEDIATE_ARG_INCLUDING_OUTPUT_FILE() {
        return STRIP_FLAGS_WITH_IMMEDIATE_ARG_INCLUDING_OUTPUT_FILE;
    }

    public static final List<String> getSTRIP_FLAGS_WITHOUT_ARG() {
        return STRIP_FLAGS_WITHOUT_ARG;
    }

    public static final String extractFlagArgument(String str, String str2, List<String> flags) {
        Intrinsics.checkNotNullParameter(str, "short");
        Intrinsics.checkNotNullParameter(str2, "long");
        Intrinsics.checkNotNullParameter(flags, "flags");
        String strStringPlus = Intrinsics.stringPlus(str2, "=");
        boolean z = false;
        for (String str3 : flags) {
            if (z) {
                return str3;
            }
            if (StringsKt.startsWith$default(str3, strStringPlus, false, 2, (Object) null)) {
                return StringsKt.substringAfter$default(str3, strStringPlus, (String) null, 2, (Object) null);
            }
            if (Intrinsics.areEqual(str3, str) || Intrinsics.areEqual(str3, str2)) {
                z = true;
            }
        }
        return null;
    }

    public static final boolean hasBug201754404(File file) throws Exception {
        Intrinsics.checkNotNullParameter(file, "file");
        CompileCommandsInputStream compileCommandsInputStream = new CompileCommandsInputStream(file);
        try {
            CompileCommandsInputStream compileCommandsInputStream2 = compileCommandsInputStream;
            if (compileCommandsInputStream2.getVersion() != 2) {
                AutoCloseableKt.closeFinally(compileCommandsInputStream, null);
                return false;
            }
            int sourceMessagesCount = compileCommandsInputStream2.getSourceMessagesCount();
            for (int i = 0; i < sourceMessagesCount; i++) {
                byte bM8006byte = compileCommandsInputStream2.m8006byte();
                if (bM8006byte == 0) {
                    if (compileCommandsInputStream2.stringOrNull() == null) {
                        AutoCloseableKt.closeFinally(compileCommandsInputStream, null);
                        return true;
                    }
                    if (compileCommandsInputStream2.stringListOrNull() == null) {
                        AutoCloseableKt.closeFinally(compileCommandsInputStream, null);
                        return true;
                    }
                    if (compileCommandsInputStream2.stringOrNull() == null) {
                        AutoCloseableKt.closeFinally(compileCommandsInputStream, null);
                        return true;
                    }
                    if (compileCommandsInputStream2.stringOrNull() == null) {
                        AutoCloseableKt.closeFinally(compileCommandsInputStream, null);
                        return true;
                    }
                } else if (bM8006byte == 1) {
                    if (compileCommandsInputStream2.stringOrNull() == null) {
                        AutoCloseableKt.closeFinally(compileCommandsInputStream, null);
                        return true;
                    }
                } else {
                    AutoCloseableKt.closeFinally(compileCommandsInputStream, null);
                    return true;
                }
            }
            boolean z = !compileCommandsInputStream2.isEndOfMessages();
            AutoCloseableKt.closeFinally(compileCommandsInputStream, null);
            return z;
        } finally {
        }
    }
}
