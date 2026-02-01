package com.android.ide.common.blame;

import com.android.SdkConstants;
import com.google.common.base.Objects;
import java.io.Serializable;
import org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes3.dex */
public final class SourcePosition implements Serializable {
    public static final SourcePosition UNKNOWN = new SourcePosition();
    private final int mEndColumn;
    private final int mEndLine;
    private final int mEndOffset;
    private final int mStartColumn;
    private final int mStartLine;
    private final int mStartOffset;

    public SourcePosition(int startLine, int startColumn, int startOffset, int endLine, int endColumn, int endOffset) {
        this.mStartLine = startLine;
        this.mStartColumn = startColumn;
        this.mStartOffset = startOffset;
        this.mEndLine = endLine;
        this.mEndColumn = endColumn;
        this.mEndOffset = endOffset;
    }

    public SourcePosition(int lineNumber, int column, int offset) {
        this.mEndLine = lineNumber;
        this.mStartLine = lineNumber;
        this.mEndColumn = column;
        this.mStartColumn = column;
        this.mEndOffset = offset;
        this.mStartOffset = offset;
    }

    private SourcePosition() {
        this.mEndOffset = -1;
        this.mEndColumn = -1;
        this.mEndLine = -1;
        this.mStartOffset = -1;
        this.mStartColumn = -1;
        this.mStartLine = -1;
    }

    protected SourcePosition(SourcePosition copy) {
        this.mStartLine = copy.getStartLine();
        this.mStartColumn = copy.getStartColumn();
        this.mStartOffset = copy.getStartOffset();
        this.mEndLine = copy.getEndLine();
        this.mEndColumn = copy.getEndColumn();
        this.mEndOffset = copy.getEndOffset();
    }

    public String toString() {
        if (this.mStartLine == -1) {
            return SdkConstants.PREFIX_THEME_REF;
        }
        StringBuilder sb = new StringBuilder(15);
        sb.append(this.mStartLine + 1);
        if (this.mStartColumn != -1) {
            sb.append(':');
            sb.append(this.mStartColumn + 1);
        }
        int i = this.mEndLine;
        if (i != -1) {
            if (i == this.mStartLine) {
                int i2 = this.mEndColumn;
                if (i2 != -1 && i2 != this.mStartColumn) {
                    sb.append(SignatureVisitor.SUPER);
                    sb.append(this.mEndColumn + 1);
                }
            } else {
                sb.append(SignatureVisitor.SUPER);
                sb.append(this.mEndLine + 1);
                if (this.mEndColumn != -1) {
                    sb.append(':');
                    sb.append(this.mEndColumn + 1);
                } else if (this.mStartColumn != -1) {
                    sb.append(":?");
                }
            }
        }
        return sb.toString();
    }

    private static int parseString(String string) {
        if (string.equals(SdkConstants.PREFIX_THEME_REF)) {
            return 0;
        }
        return Integer.parseInt(string);
    }

    public static SourcePosition fromString(String string) {
        int string2;
        int i;
        int i2;
        int string3;
        int string4;
        int string5;
        if (string.equals(SdkConstants.PREFIX_THEME_REF)) {
            return UNKNOWN;
        }
        int string6 = 0;
        if (string.contains(SdkConstants.RES_QUALIFIER_SEP)) {
            String[] strArrSplit = string.split(SdkConstants.RES_QUALIFIER_SEP);
            if (strArrSplit[0].contains(":")) {
                String[] strArrSplit2 = strArrSplit[0].split(":");
                string2 = parseString(strArrSplit2[0]);
                string3 = parseString(strArrSplit2[1]);
            } else {
                string2 = parseString(strArrSplit[0]);
                string3 = 0;
            }
            if (strArrSplit[1].contains(":")) {
                String[] strArrSplit3 = strArrSplit[1].split(":");
                int string7 = parseString(strArrSplit3[0]);
                string5 = parseString(strArrSplit3[1]);
                string4 = string7;
            } else if (string3 != 0) {
                string5 = parseString(strArrSplit[1]);
                string4 = string2;
            } else {
                string4 = parseString(strArrSplit[1]);
                string5 = 0;
            }
            int i3 = string3;
            i2 = string5;
            i = string4;
            string6 = i3;
        } else if (string.contains(":")) {
            String[] strArrSplit4 = string.split(":");
            string2 = parseString(strArrSplit4[0]);
            i2 = 0;
            string6 = parseString(strArrSplit4[1]);
            i = 0;
        } else {
            string2 = parseString(string);
            i = 0;
            i2 = 0;
        }
        return new SourcePosition(string2 - 1, string6 - 1, -1, i - 1, i2 - 1, -1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourcePosition)) {
            return false;
        }
        SourcePosition sourcePosition = (SourcePosition) obj;
        return sourcePosition.mStartLine == this.mStartLine && sourcePosition.mStartColumn == this.mStartColumn && sourcePosition.mStartOffset == this.mStartOffset && sourcePosition.mEndLine == this.mEndLine && sourcePosition.mEndColumn == this.mEndColumn && sourcePosition.mEndOffset == this.mEndOffset;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mStartLine), Integer.valueOf(this.mStartColumn), Integer.valueOf(this.mStartOffset), Integer.valueOf(this.mEndLine), Integer.valueOf(this.mEndColumn), Integer.valueOf(this.mEndOffset));
    }

    public int getStartLine() {
        return this.mStartLine;
    }

    public int getStartColumn() {
        return this.mStartColumn;
    }

    public int getStartOffset() {
        return this.mStartOffset;
    }

    public int getEndLine() {
        return this.mEndLine;
    }

    public int getEndColumn() {
        return this.mEndColumn;
    }

    public int getEndOffset() {
        return this.mEndOffset;
    }

    public int compareStart(SourcePosition other) {
        int i;
        int i2;
        int i3;
        int i4 = this.mStartOffset;
        if (i4 != -1 && (i3 = other.mStartOffset) != -1) {
            return i4 - i3;
        }
        int i5 = this.mStartLine;
        int i6 = other.mStartLine;
        return (i5 != i6 || (i = this.mStartColumn) == -1 || (i2 = other.mStartColumn) == -1) ? i5 - i6 : i - i2;
    }

    public int compareEnd(SourcePosition other) {
        int i;
        int i2;
        int i3;
        int i4 = this.mEndOffset;
        if (i4 != -1 && (i3 = other.mEndOffset) != -1) {
            return i4 - i3;
        }
        int i5 = this.mEndLine;
        int i6 = other.mEndLine;
        return (i5 != i6 || (i = this.mEndColumn) == -1 || (i2 = other.mEndColumn) == -1) ? i5 - i6 : i - i2;
    }
}
