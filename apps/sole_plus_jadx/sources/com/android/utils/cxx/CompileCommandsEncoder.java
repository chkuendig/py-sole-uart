package com.android.utils.cxx;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: CompileCommandsCodec.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\n \u000b*\u0004\u0018\u00010\u00190\u00192\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u0010(\u001a\n \u000b*\u0004\u0018\u00010\u00190\u00192\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\n \u000b*\u0004\u0018\u00010\u00190\u0019H\u0002J\b\u0010+\u001a\u00020$H\u0002J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020!H\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0005H\u0002J\b\u00100\u001a\u00020$H\u0002J\u0012\u00101\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010!H\u0002J\u0016\u00101\u001a\u00020\u00052\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\u0002J<\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\f\u00106\u001a\b\u0012\u0004\u0012\u00020!0\u001e2\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020!J\u0010\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020<H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u000b*\u0004\u0018\u00010\u00190\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001e\u0012\u0004\u0012\u00020\u00050\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00050\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/android/utils/cxx/CompileCommandsEncoder;", "Ljava/lang/AutoCloseable;", "file", "Ljava/io/File;", "initialBufferSize", "", "(Ljava/io/File;I)V", "bufferStartPosition", "", "channel", "Ljava/nio/channels/FileChannel;", "kotlin.jvm.PlatformType", "compileCommandsIndexEntry", "countOfSourceFiles", "countOfSourceMessages", "countOfSourceMessagesOffset", "getFile", "()Ljava/io/File;", "lastCompilerWritten", "lastFlagsWritten", "lastTargetWritten", "lastWorkingDirectoryWritten", "lock", "Ljava/nio/channels/FileLock;", "map", "Ljava/nio/ByteBuffer;", "ras", "Ljava/io/RandomAccessFile;", "stringListTable", "", "", "stringListsIndexEntry", "stringTable", "", "stringTableIndexEntry", "close", "", "encodeByte", "byte", "", "encodeInt", "int", "encodeLongZero", "encodeMagic", "encodeUTF8", "string", "ensureAtLeast", "bytes", "flushBuffer", "intern", "strings", "writeCompileCommand", "sourceFile", "compiler", "flags", "workingDirectory", "outputFile", TypedValues.AttributesType.S_TARGET, "writeSectionIndexEntry", "section", "Lcom/android/utils/cxx/Sections;", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CompileCommandsEncoder implements AutoCloseable {
    private long bufferStartPosition;
    private final FileChannel channel;
    private final long compileCommandsIndexEntry;
    private int countOfSourceFiles;
    private int countOfSourceMessages;
    private final long countOfSourceMessagesOffset;
    private final File file;
    private int lastCompilerWritten;
    private int lastFlagsWritten;
    private int lastTargetWritten;
    private int lastWorkingDirectoryWritten;
    private final FileLock lock;
    private ByteBuffer map;
    private final RandomAccessFile ras;
    private final Map<List<Integer>, Integer> stringListTable;
    private final long stringListsIndexEntry;
    private final Map<String, Integer> stringTable;
    private final long stringTableIndexEntry;

    public CompileCommandsEncoder(File file, int i) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.ras = randomAccessFile;
        FileChannel channel = randomAccessFile.getChannel();
        this.channel = channel;
        this.lock = channel.lock();
        this.map = ByteBuffer.allocate(i);
        this.stringTable = new LinkedHashMap();
        this.stringListTable = new LinkedHashMap();
        this.lastCompilerWritten = -1;
        this.lastFlagsWritten = -1;
        this.lastTargetWritten = -1;
        this.lastWorkingDirectoryWritten = -1;
        encodeMagic();
        encodeInt(3);
        encodeInt(3);
        this.compileCommandsIndexEntry = writeSectionIndexEntry(Sections.CompileCommands);
        this.stringTableIndexEntry = writeSectionIndexEntry(Sections.StringTable);
        this.stringListsIndexEntry = writeSectionIndexEntry(Sections.StringLists);
        this.countOfSourceMessagesOffset = randomAccessFile.getFilePointer() + this.map.position();
        encodeInt(0);
        encodeInt(0);
    }

    public /* synthetic */ CompileCommandsEncoder(File file, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i2 & 2) != 0 ? 32768 : i);
    }

    public final File getFile() {
        return this.file;
    }

    private final void encodeMagic() {
        byte[] bytes = "C/C++ Build Metadata\u001a".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        ensureAtLeast(bytes.length).put(bytes);
    }

    private final void encodeUTF8(String string) throws IOException {
        Charset charset = Charsets.UTF_8;
        if (string == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = string.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        ByteBuffer byteBufferEnsureAtLeast = ensureAtLeast(bytes.length + 4);
        byteBufferEnsureAtLeast.putInt(bytes.length);
        byteBufferEnsureAtLeast.put(bytes);
    }

    private final ByteBuffer encodeByte(byte b) {
        return ensureAtLeast(1).put(b);
    }

    private final ByteBuffer encodeInt(int i) {
        return ensureAtLeast(4).putInt(i);
    }

    private final ByteBuffer encodeLongZero() {
        return ensureAtLeast(8).putLong(0L);
    }

    private final ByteBuffer ensureAtLeast(int bytes) throws IOException {
        if (this.map.capacity() < this.map.position() + bytes) {
            flushBuffer();
            if (this.map.capacity() < bytes) {
                this.map = ByteBuffer.allocate(bytes);
            }
        }
        ByteBuffer map = this.map;
        Intrinsics.checkNotNullExpressionValue(map, "map");
        return map;
    }

    private final void flushBuffer() throws IOException {
        if (this.map.position() == 0) {
            return;
        }
        this.ras.seek(this.bufferStartPosition);
        this.ras.write(this.map.array(), 0, this.map.position());
        this.bufferStartPosition += this.map.position();
        ByteBuffer byteBuffer = this.map;
        if (byteBuffer == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.nio.Buffer");
        }
        byteBuffer.clear();
    }

    private final int intern(String string) {
        Integer numComputeIfAbsent;
        if (string == null) {
            numComputeIfAbsent = 0;
        } else {
            numComputeIfAbsent = this.stringTable.computeIfAbsent(string, new Function() { // from class: com.android.utils.cxx.CompileCommandsEncoder.intern.1
                @Override // java.util.function.Function
                public final Integer apply(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(CompileCommandsEncoder.this.stringTable.size() + 1);
                }
            });
        }
        Intrinsics.checkNotNullExpressionValue(numComputeIfAbsent, "private fun intern(strin…ve 0 for 'null'\n        }");
        return numComputeIfAbsent.intValue();
    }

    private final int intern(List<Integer> strings) {
        Integer numComputeIfAbsent = this.stringListTable.computeIfAbsent(strings, new Function() { // from class: com.android.utils.cxx.CompileCommandsEncoder.intern.2
            @Override // java.util.function.Function
            public final Integer apply(List<Integer> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(CompileCommandsEncoder.this.stringListTable.size());
            }
        });
        Intrinsics.checkNotNullExpressionValue(numComputeIfAbsent, "private fun intern(strin…tringListTable.size\n    }");
        return numComputeIfAbsent.intValue();
    }

    private final long writeSectionIndexEntry(Sections section) {
        long filePointer = this.ras.getFilePointer() + this.map.position();
        encodeInt(section.ordinal());
        encodeLongZero();
        return filePointer;
    }

    public final void writeCompileCommand(File sourceFile, File compiler, List<String> flags, File workingDirectory, File outputFile, String target) {
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        Intrinsics.checkNotNullParameter(compiler, "compiler");
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(workingDirectory, "workingDirectory");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        Intrinsics.checkNotNullParameter(target, "target");
        int iIntern = intern(compiler.getPath());
        List<String> list = flags;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(intern((String) it.next())));
        }
        int iIntern2 = intern(arrayList);
        int iIntern3 = intern(workingDirectory.getPath());
        int iIntern4 = intern(target);
        if (iIntern != this.lastCompilerWritten || iIntern2 != this.lastFlagsWritten || iIntern3 != this.lastWorkingDirectoryWritten || iIntern4 != this.lastTargetWritten) {
            encodeByte((byte) 0);
            encodeInt(iIntern);
            encodeInt(iIntern2);
            encodeInt(iIntern3);
            encodeInt(iIntern4);
            this.lastCompilerWritten = iIntern;
            this.lastFlagsWritten = iIntern2;
            this.lastWorkingDirectoryWritten = iIntern3;
            this.lastTargetWritten = iIntern4;
            this.countOfSourceMessages++;
        }
        encodeByte((byte) 1);
        encodeInt(intern(sourceFile.getPath()));
        encodeInt(intern(outputFile.getPath()));
        this.countOfSourceMessages++;
        this.countOfSourceFiles++;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws IOException {
        long jPosition = this.bufferStartPosition + this.map.position();
        encodeInt(this.stringTable.size());
        Iterator it = CollectionsKt.sortedWith(MapsKt.toList(this.stringTable), new Comparator() { // from class: com.android.utils.cxx.CompileCommandsEncoder$close$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((Number) ((Pair) t).component2()).intValue()), Integer.valueOf(((Number) ((Pair) t2).component2()).intValue()));
            }
        }).iterator();
        while (it.hasNext()) {
            encodeUTF8((String) ((Pair) it.next()).component1());
        }
        long jPosition2 = this.bufferStartPosition + this.map.position();
        encodeInt(this.stringListTable.size());
        Iterator it2 = CollectionsKt.sortedWith(MapsKt.toList(this.stringListTable), new Comparator() { // from class: com.android.utils.cxx.CompileCommandsEncoder$close$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((Number) ((Pair) t).component2()).intValue()), Integer.valueOf(((Number) ((Pair) t2).component2()).intValue()));
            }
        }).iterator();
        while (it2.hasNext()) {
            List list = (List) ((Pair) it2.next()).component1();
            encodeInt(list.size());
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                encodeInt(((Number) it3.next()).intValue());
            }
        }
        flushBuffer();
        this.map = null;
        this.ras.seek(this.countOfSourceMessagesOffset);
        this.ras.writeInt(this.countOfSourceMessages);
        this.ras.writeInt(this.countOfSourceFiles);
        long j = 4;
        this.ras.seek(this.compileCommandsIndexEntry + j);
        this.ras.writeLong(this.countOfSourceMessagesOffset);
        this.ras.seek(this.stringTableIndexEntry + j);
        this.ras.writeLong(jPosition);
        this.ras.seek(this.stringListsIndexEntry + j);
        this.ras.writeLong(jPosition2);
        this.ras.getFD().sync();
        this.lock.close();
        this.channel.close();
        this.ras.close();
    }
}
