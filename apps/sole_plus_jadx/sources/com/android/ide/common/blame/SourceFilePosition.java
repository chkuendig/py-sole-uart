package com.android.ide.common.blame;

import com.google.common.base.Objects;
import java.io.File;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class SourceFilePosition implements Serializable {
    public static final SourceFilePosition UNKNOWN = new SourceFilePosition(SourceFile.UNKNOWN, SourcePosition.UNKNOWN);
    private final SourceFile mSourceFile;
    private final SourcePosition mSourcePosition;

    public SourceFilePosition(SourceFile sourceFile, SourcePosition sourcePosition) {
        this.mSourceFile = sourceFile;
        this.mSourcePosition = sourcePosition;
    }

    public SourceFilePosition(File file, SourcePosition sourcePosition) {
        this(new SourceFile(file), sourcePosition);
    }

    public SourcePosition getPosition() {
        return this.mSourcePosition;
    }

    public SourceFile getFile() {
        return this.mSourceFile;
    }

    public String toString() {
        return print(false);
    }

    public String print(boolean shortFormat) {
        if (this.mSourcePosition.equals(SourcePosition.UNKNOWN)) {
            return this.mSourceFile.print(shortFormat);
        }
        return this.mSourceFile.print(shortFormat) + ':' + this.mSourcePosition.toString();
    }

    public int hashCode() {
        return Objects.hashCode(this.mSourceFile, this.mSourcePosition);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceFilePosition)) {
            return false;
        }
        SourceFilePosition sourceFilePosition = (SourceFilePosition) obj;
        return Objects.equal(this.mSourceFile, sourceFilePosition.mSourceFile) && Objects.equal(this.mSourcePosition, sourceFilePosition.mSourcePosition);
    }
}
