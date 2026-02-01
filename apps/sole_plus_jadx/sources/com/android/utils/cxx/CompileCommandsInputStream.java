package com.android.utils.cxx;

import com.facebook.internal.ServerProtocol;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompileCommandsCodec.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0016J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015J\b\u0010&\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006'"}, d2 = {"Lcom/android/utils/cxx/CompileCommandsInputStream;", "Ljava/lang/AutoCloseable;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "fileChannel", "Ljava/nio/channels/FileChannel;", "kotlin.jvm.PlatformType", "internedFiles", "", "", "map", "Ljava/nio/ByteBuffer;", "positionAfterLastMessage", ContentDisposition.Parameters.Size, "sourceMessagesCount", "getSourceMessagesCount", "()I", "start", "stringLists", "", "", "", "[Ljava/util/List;", "strings", "[Ljava/lang/String;", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "getVersion", "byte", "", "close", "", "int", "isEndOfMessages", "", "string", "stringList", "stringListOrNull", "stringOrNull", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
final class CompileCommandsInputStream implements AutoCloseable {
    private final File file;
    private final FileChannel fileChannel;
    private final Map<Integer, File> internedFiles;
    private final ByteBuffer map;
    private final int positionAfterLastMessage;
    private final int size;
    private final int sourceMessagesCount;
    private final int start;
    private final List<String>[] stringLists;
    private final String[] strings;
    private final int version;

    public CompileCommandsInputStream(File file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        FileChannel fileChannelOpen = FileChannel.open(file.toPath(), new OpenOption[0]);
        this.fileChannel = fileChannelOpen;
        int length = (int) file.length();
        this.size = length;
        ByteBuffer map = ByteBuffer.allocate(length);
        this.map = map;
        this.internedFiles = new LinkedHashMap();
        fileChannelOpen.read(map);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        Pair pairPositionAfterMagicAndVersion = CompileCommandsCodecKt.positionAfterMagicAndVersion(map);
        int iIntValue = ((Number) pairPositionAfterMagicAndVersion.getFirst()).intValue();
        this.start = iIntValue;
        int iIntValue2 = ((Number) pairPositionAfterMagicAndVersion.getSecond()).intValue();
        this.version = iIntValue2;
        if (iIntValue == 0 || iIntValue2 == 0) {
            throw new IllegalStateException((file + " is not a valid C/C++ Build Metadata file").toString());
        }
        Intrinsics.checkNotNullExpressionValue(map, "map");
        CompileCommandsCodecKt.seekSection(map, iIntValue, Sections.StringTable);
        this.positionAfterLastMessage = map.position();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        String[] stringTable = CompileCommandsCodecKt.readStringTable(map, iIntValue);
        this.strings = stringTable;
        Intrinsics.checkNotNullExpressionValue(map, "map");
        this.stringLists = CompileCommandsCodecKt.readStringListsTable(map, iIntValue, stringTable);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        CompileCommandsCodecKt.seekSection(map, iIntValue, Sections.CompileCommands);
        this.sourceMessagesCount = m8007int();
    }

    public final int getVersion() {
        return this.version;
    }

    public final int getSourceMessagesCount() {
        return this.sourceMessagesCount;
    }

    /* renamed from: byte, reason: not valid java name */
    public final byte m8006byte() {
        return this.map.get();
    }

    /* renamed from: int, reason: not valid java name */
    public final int m8007int() {
        return this.map.getInt();
    }

    public final File file() {
        final int i = this.map.getInt();
        if (i == 0) {
            throw new IllegalStateException(("Null file name seen in '" + this.file + '\'').toString());
        }
        File fileComputeIfAbsent = this.internedFiles.computeIfAbsent(Integer.valueOf(i), new Function() { // from class: com.android.utils.cxx.CompileCommandsInputStream.file.1
            @Override // java.util.function.Function
            public final File apply(Integer it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String str = CompileCommandsInputStream.this.strings[i];
                Intrinsics.checkNotNull(str);
                return new File(str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fileComputeIfAbsent, "fun file(): File {\n     …index]!!)\n        }\n    }");
        return fileComputeIfAbsent;
    }

    public final String string() {
        String str = this.strings[this.map.getInt()];
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final String stringOrNull() {
        int i = this.map.getInt();
        if (i == 0) {
            return null;
        }
        String[] strArr = this.strings;
        if (i > strArr.length) {
            return null;
        }
        return strArr[i];
    }

    public final List<String> stringList() {
        return this.stringLists[this.map.getInt()];
    }

    public final List<String> stringListOrNull() {
        int i = this.map.getInt();
        List<String>[] listArr = this.stringLists;
        if (i > listArr.length) {
            return null;
        }
        return listArr[i];
    }

    public final boolean isEndOfMessages() {
        return this.map.position() == this.positionAfterLastMessage;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.fileChannel.close();
    }
}
