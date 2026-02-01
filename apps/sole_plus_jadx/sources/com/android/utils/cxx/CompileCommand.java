package com.android.utils.cxx;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompileCommandsCodec.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J_\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\fHÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006)"}, d2 = {"Lcom/android/utils/cxx/CompileCommand;", "", "sourceFile", "Ljava/io/File;", "compiler", "flags", "", "", "workingDirectory", "outputFile", TypedValues.AttributesType.S_TARGET, "sourceFileIndex", "", "sourceFileCount", "(Ljava/io/File;Ljava/io/File;Ljava/util/List;Ljava/io/File;Ljava/io/File;Ljava/lang/String;II)V", "getCompiler", "()Ljava/io/File;", "getFlags", "()Ljava/util/List;", "getOutputFile", "getSourceFile", "getSourceFileCount", "()I", "getSourceFileIndex", "getTarget", "()Ljava/lang/String;", "getWorkingDirectory", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CompileCommand {
    private final File compiler;
    private final List<String> flags;
    private final File outputFile;
    private final File sourceFile;
    private final int sourceFileCount;
    private final int sourceFileIndex;
    private final String target;
    private final File workingDirectory;

    /* renamed from: component1, reason: from getter */
    public final File getSourceFile() {
        return this.sourceFile;
    }

    /* renamed from: component2, reason: from getter */
    public final File getCompiler() {
        return this.compiler;
    }

    public final List<String> component3() {
        return this.flags;
    }

    /* renamed from: component4, reason: from getter */
    public final File getWorkingDirectory() {
        return this.workingDirectory;
    }

    /* renamed from: component5, reason: from getter */
    public final File getOutputFile() {
        return this.outputFile;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTarget() {
        return this.target;
    }

    /* renamed from: component7, reason: from getter */
    public final int getSourceFileIndex() {
        return this.sourceFileIndex;
    }

    /* renamed from: component8, reason: from getter */
    public final int getSourceFileCount() {
        return this.sourceFileCount;
    }

    public final CompileCommand copy(File sourceFile, File compiler, List<String> flags, File workingDirectory, File outputFile, String target, int sourceFileIndex, int sourceFileCount) {
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        Intrinsics.checkNotNullParameter(compiler, "compiler");
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(workingDirectory, "workingDirectory");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        Intrinsics.checkNotNullParameter(target, "target");
        return new CompileCommand(sourceFile, compiler, flags, workingDirectory, outputFile, target, sourceFileIndex, sourceFileCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompileCommand)) {
            return false;
        }
        CompileCommand compileCommand = (CompileCommand) other;
        return Intrinsics.areEqual(this.sourceFile, compileCommand.sourceFile) && Intrinsics.areEqual(this.compiler, compileCommand.compiler) && Intrinsics.areEqual(this.flags, compileCommand.flags) && Intrinsics.areEqual(this.workingDirectory, compileCommand.workingDirectory) && Intrinsics.areEqual(this.outputFile, compileCommand.outputFile) && Intrinsics.areEqual(this.target, compileCommand.target) && this.sourceFileIndex == compileCommand.sourceFileIndex && this.sourceFileCount == compileCommand.sourceFileCount;
    }

    public int hashCode() {
        return (((((((((((((this.sourceFile.hashCode() * 31) + this.compiler.hashCode()) * 31) + this.flags.hashCode()) * 31) + this.workingDirectory.hashCode()) * 31) + this.outputFile.hashCode()) * 31) + this.target.hashCode()) * 31) + Integer.hashCode(this.sourceFileIndex)) * 31) + Integer.hashCode(this.sourceFileCount);
    }

    public String toString() {
        return "CompileCommand(sourceFile=" + this.sourceFile + ", compiler=" + this.compiler + ", flags=" + this.flags + ", workingDirectory=" + this.workingDirectory + ", outputFile=" + this.outputFile + ", target=" + this.target + ", sourceFileIndex=" + this.sourceFileIndex + ", sourceFileCount=" + this.sourceFileCount + ')';
    }

    public CompileCommand(File sourceFile, File compiler, List<String> flags, File workingDirectory, File outputFile, String target, int i, int i2) {
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        Intrinsics.checkNotNullParameter(compiler, "compiler");
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(workingDirectory, "workingDirectory");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        Intrinsics.checkNotNullParameter(target, "target");
        this.sourceFile = sourceFile;
        this.compiler = compiler;
        this.flags = flags;
        this.workingDirectory = workingDirectory;
        this.outputFile = outputFile;
        this.target = target;
        this.sourceFileIndex = i;
        this.sourceFileCount = i2;
    }

    public final File getSourceFile() {
        return this.sourceFile;
    }

    public final File getCompiler() {
        return this.compiler;
    }

    public final List<String> getFlags() {
        return this.flags;
    }

    public final File getWorkingDirectory() {
        return this.workingDirectory;
    }

    public final File getOutputFile() {
        return this.outputFile;
    }

    public final String getTarget() {
        return this.target;
    }

    public final int getSourceFileIndex() {
        return this.sourceFileIndex;
    }

    public final int getSourceFileCount() {
        return this.sourceFileCount;
    }
}
