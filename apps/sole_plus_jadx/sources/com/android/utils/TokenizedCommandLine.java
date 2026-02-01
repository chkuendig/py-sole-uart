package com.android.utils;

import com.android.SdkConstants;
import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TokenizedCommandLine.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u0007J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0007J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u0007J\u0010\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010'\u001a\u00020\u0007J6\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u0005J\b\u0010.\u001a\u00020\u0003H\u0016J\u000e\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003J\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000301J*\u00102\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u0005H\u0007J\u0010\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0007H\u0002J\u0010\u00105\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u00106\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/android/utils/TokenizedCommandLine;", "", "commandLine", "", SdkConstants.FD_RES_RAW, "", "platform", "", "indexes", "", "(Ljava/lang/String;ZI[I)V", "getCommandLine", "()Ljava/lang/String;", "generation", "getPlatform", "()I", "getRaw", "()Z", "toStringValue", "bothSlash", "c1", "", "c2", "charAt", "i", "(I)Ljava/lang/Character;", "checkGeneration", "", "computeNormalizedCommandLineHashCode", "invalidate", "isEndOfCommand", "isEndOfToken", "isStartOfToken", "nextTokenAfter", "offset", "normalizedCommandLineEquals", "other", "normalizedCommandLineLength", "removeNth", "n", "removeTokenGroup", "token", "extra", "matchPrefix", "returnFirstExtra", "filePathSlashAgnostic", "toString", "separator", "toTokenList", "", "tokenMatches", "tokenStartingAt", "start", "zeroAllocTokenizePOSIX", "zeroAllocTokenizeWindows", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TokenizedCommandLine {
    private final String commandLine;
    private final int generation;
    private int[] indexes;
    private final int platform;
    private final boolean raw;
    private String toStringValue;

    private final boolean bothSlash(char c1, char c2) {
        if (c1 == '\\' || c1 == '/') {
            return c2 == '\\' || c2 == '/';
        }
        return false;
    }

    public TokenizedCommandLine(String commandLine, boolean z, int i, int[] indexes) throws Exception {
        Intrinsics.checkNotNullParameter(commandLine, "commandLine");
        Intrinsics.checkNotNullParameter(indexes, "indexes");
        this.commandLine = commandLine;
        this.raw = z;
        this.platform = i;
        this.indexes = indexes;
        int i2 = indexes[0] + 1;
        indexes[0] = i2;
        this.generation = i2;
        checkGeneration();
        if (i == 2) {
            zeroAllocTokenizeWindows(z);
        } else {
            zeroAllocTokenizePOSIX(z);
        }
    }

    public final String getCommandLine() {
        return this.commandLine;
    }

    public final boolean getRaw() {
        return this.raw;
    }

    public /* synthetic */ TokenizedCommandLine(String str, boolean z, int i, int[] iArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i2 & 4) != 0 ? SdkConstants.currentPlatform() : i, (i2 & 8) != 0 ? TokenizedCommandLineKt.allocateTokenizeCommandLineBuffer(str) : iArr);
    }

    public final int getPlatform() {
        return this.platform;
    }

    public final String removeTokenGroup(String token, int extra, boolean matchPrefix, boolean returnFirstExtra, boolean filePathSlashAgnostic) throws Exception {
        int i;
        Intrinsics.checkNotNullParameter(token, "token");
        checkGeneration();
        invalidate();
        String str = null;
        int iNextTokenAfter = 1;
        int i2 = 1;
        do {
            isStartOfToken(iNextTokenAfter);
            isStartOfToken(i2);
            if (tokenMatches(token, iNextTokenAfter, matchPrefix, filePathSlashAgnostic)) {
                if (returnFirstExtra) {
                    if (matchPrefix) {
                        str = tokenStartingAt(token.length() + iNextTokenAfter);
                    } else {
                        str = tokenStartingAt(nextTokenAfter(iNextTokenAfter));
                    }
                }
                for (int i3 = 0; i3 != extra + 1 && !isEndOfCommand(iNextTokenAfter); i3++) {
                    iNextTokenAfter = nextTokenAfter(iNextTokenAfter);
                }
            } else if (!isEndOfCommand(iNextTokenAfter) && !isEndOfCommand(i2)) {
                while (true) {
                    int[] iArr = this.indexes;
                    i = iNextTokenAfter + 1;
                    iArr[i2] = iArr[iNextTokenAfter];
                    i2++;
                    if (isEndOfToken(iNextTokenAfter)) {
                        break;
                    }
                    iNextTokenAfter = i;
                }
                iNextTokenAfter = i;
            }
        } while (!isEndOfCommand(iNextTokenAfter));
        this.indexes[i2] = Integer.MIN_VALUE;
        return str;
    }

    private final String tokenStartingAt(int start) throws Exception {
        checkGeneration();
        StringBuilder sb = new StringBuilder();
        int length = this.indexes.length;
        while (start < length) {
            int i = start + 1;
            int i2 = this.indexes[start];
            if (i2 == Integer.MIN_VALUE || i2 == Integer.MAX_VALUE) {
                break;
            }
            sb.append(this.commandLine.charAt(i2));
            start = i;
        }
        return StringsKt.trim(sb).toString();
    }

    public final String removeNth(int n) throws Exception {
        checkGeneration();
        invalidate();
        StringBuilder sb = new StringBuilder();
        int length = this.indexes.length;
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i2 < length) {
            int i4 = i2 + 1;
            if (i != n) {
                int[] iArr = this.indexes;
                iArr[i3] = iArr[i2];
                i3++;
            }
            int i5 = this.indexes[i2];
            if (i5 == Integer.MIN_VALUE) {
                if (sb.length() == 0) {
                    return null;
                }
                return sb.toString();
            }
            if (i5 == Integer.MAX_VALUE) {
                i++;
            } else if (i == n) {
                sb.append(this.commandLine.charAt(i5));
            }
            i2 = i4;
        }
        return null;
    }

    public final List<String> toTokenList() throws Exception {
        checkGeneration();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; !isEndOfCommand(i); i++) {
            Character chCharAt = charAt(i);
            if (chCharAt == null) {
                if (sb.length() > 0) {
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "token.toString()");
                    arrayList.add(string);
                    sb.setLength(0);
                }
            } else {
                sb.append(chCharAt.charValue());
            }
        }
        return arrayList;
    }

    private final TokenizedCommandLine zeroAllocTokenizeWindows(boolean raw) throws Exception {
        int i;
        int i2;
        checkGeneration();
        invalidate();
        int length = this.commandLine.length();
        int i3 = 0;
        while (i3 < length && Character.isWhitespace(this.commandLine.charAt(i3))) {
            i3++;
        }
        boolean z = false;
        int i4 = 1;
        while (i3 < length) {
            Character chValueOf = Character.valueOf(this.commandLine.charAt(i3));
            if (chValueOf.charValue() == '\"') {
                if (raw) {
                    this.indexes[i4] = i3;
                    i4++;
                }
                z = !z;
                i3++;
            } else if (chValueOf.charValue() == '\\') {
                int i5 = i3 + 1;
                Character orNull = StringsKt.getOrNull(this.commandLine, i5);
                int i6 = 1;
                while (orNull != null && orNull.charValue() == '\\') {
                    i6++;
                    i5++;
                    orNull = StringsKt.getOrNull(this.commandLine, i5);
                }
                boolean z2 = i6 % 2 == 1;
                boolean z3 = orNull != null && orNull.charValue() == '\"';
                if (!raw && z3) {
                    i6 /= 2;
                }
                int i7 = 0;
                while (i7 < i6) {
                    this.indexes[i4] = i3 + i7;
                    i7++;
                    i4++;
                }
                if (z2 && z3) {
                    i = i4 + 1;
                    i2 = i5 + 1;
                    this.indexes[i4] = i5;
                    i4 = i;
                    i3 = i2;
                } else {
                    i3 = i5;
                }
            } else if (!z && chValueOf.charValue() == '^') {
                int i8 = i3 + 1;
                Character orNull2 = StringsKt.getOrNull(this.commandLine, i8);
                if (raw || orNull2 == null) {
                    this.indexes[i4] = i3;
                    i4++;
                }
                if (orNull2 != null && orNull2.charValue() == '^') {
                    i3 += 2;
                    this.indexes[i4] = i8;
                    i4++;
                } else {
                    i3 = i8;
                }
                while (true) {
                    if ((orNull2 != null && orNull2.charValue() == '\r') || (orNull2 != null && orNull2.charValue() == '\n')) {
                        i3++;
                        orNull2 = StringsKt.getOrNull(this.commandLine, i3);
                    }
                }
            } else if (!z && Character.isWhitespace(chValueOf.charValue())) {
                int i9 = i4 + 1;
                this.indexes[i4] = Integer.MAX_VALUE;
                i3++;
                Character orNull3 = StringsKt.getOrNull(this.commandLine, i3);
                while (orNull3 != null && Character.isWhitespace(orNull3.charValue())) {
                    i3++;
                    orNull3 = StringsKt.getOrNull(this.commandLine, i3);
                }
                i4 = i9;
            } else {
                i = i4 + 1;
                i2 = i3 + 1;
                this.indexes[i4] = i3;
                i4 = i;
                i3 = i2;
            }
        }
        if (!isEndOfToken(i4 - 1)) {
            this.indexes[i4] = Integer.MAX_VALUE;
            i4++;
        }
        this.indexes[i4] = Integer.MIN_VALUE;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.android.utils.TokenizedCommandLine zeroAllocTokenizePOSIX(boolean r15) throws java.lang.Exception {
        /*
            r14 = this;
            r14.checkGeneration()
            r14.invalidate()
            java.lang.String r0 = r14.commandLine
            int r0 = r0.length()
            r1 = 0
            r2 = 1
            r3 = r1
            r6 = r3
            r7 = r6
            r8 = r7
            r4 = r2
            r5 = r4
        L14:
            r9 = 2147483647(0x7fffffff, float:NaN)
            if (r3 >= r0) goto L88
            java.lang.String r10 = r14.commandLine
            int r11 = r3 + 1
            char r10 = r10.charAt(r3)
            if (r5 == 0) goto L2c
            boolean r12 = java.lang.Character.isWhitespace(r10)
            if (r12 == 0) goto L2b
        L29:
            r3 = r11
            goto L14
        L2b:
            r5 = r1
        L2c:
            if (r6 != 0) goto L34
            boolean r12 = java.lang.Character.isWhitespace(r10)
            if (r12 != 0) goto L3d
        L34:
            if (r15 == 0) goto L3d
            int[] r12 = r14.indexes
            int r13 = r4 + 1
            r12[r4] = r3
            r4 = r13
        L3d:
            if (r7 == 0) goto L4e
            r7 = 10
            if (r10 == r7) goto L4c
            if (r15 != 0) goto L4c
            int[] r7 = r14.indexes
            int r9 = r4 + 1
            r7[r4] = r3
            r4 = r9
        L4c:
            r7 = r1
            goto L29
        L4e:
            r12 = 92
            r13 = 34
            if (r10 != r12) goto L5a
            if (r6 == 0) goto L58
            if (r8 != r13) goto L5a
        L58:
            r7 = r2
            goto L29
        L5a:
            if (r6 != 0) goto L65
            if (r10 == r13) goto L62
            r12 = 39
            if (r10 != r12) goto L65
        L62:
            r6 = r2
            r8 = r10
            goto L29
        L65:
            if (r6 == 0) goto L6c
            if (r10 != r8) goto L6c
            r6 = r1
            r8 = r6
            goto L29
        L6c:
            if (r6 != 0) goto L7e
            boolean r10 = java.lang.Character.isWhitespace(r10)
            if (r10 == 0) goto L7e
            int[] r3 = r14.indexes
            int r5 = r4 + 1
            r3[r4] = r9
            r4 = r5
            r3 = r11
            r5 = r2
            goto L14
        L7e:
            if (r15 != 0) goto L29
            int[] r9 = r14.indexes
            int r10 = r4 + 1
            r9[r4] = r3
            r4 = r10
            goto L29
        L88:
            int r15 = r4 + (-1)
            boolean r15 = r14.isEndOfToken(r15)
            if (r15 != 0) goto L97
            int[] r15 = r14.indexes
            int r0 = r4 + 1
            r15[r4] = r9
            r4 = r0
        L97:
            int[] r15 = r14.indexes
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r15[r4] = r0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.utils.TokenizedCommandLine.zeroAllocTokenizePOSIX(boolean):com.android.utils.TokenizedCommandLine");
    }

    public static /* synthetic */ boolean tokenMatches$default(TokenizedCommandLine tokenizedCommandLine, String str, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        return tokenizedCommandLine.tokenMatches(str, i, z, z2);
    }

    @VisibleForTesting
    public final boolean tokenMatches(String token, int offset, boolean matchPrefix, boolean filePathSlashAgnostic) throws Exception {
        Intrinsics.checkNotNullParameter(token, "token");
        checkGeneration();
        int i = this.indexes[offset];
        int i2 = 0;
        while (i != Integer.MIN_VALUE) {
            boolean z = i == Integer.MAX_VALUE;
            if (i2 == token.length()) {
                return z || matchPrefix;
            }
            if (z) {
                return false;
            }
            char cCharAt = token.charAt(i2);
            char cCharAt2 = this.commandLine.charAt(i);
            if (cCharAt != cCharAt2 && (!filePathSlashAgnostic || !bothSlash(cCharAt, cCharAt2))) {
                return false;
            }
            i2++;
            i = this.indexes[offset + i2];
        }
        return false;
    }

    @VisibleForTesting
    public final int nextTokenAfter(int offset) throws Exception {
        checkGeneration();
        while (!isEndOfToken(offset) && !isEndOfCommand(offset)) {
            offset++;
        }
        return offset + 1;
    }

    private final boolean isEndOfToken(int i) {
        int[] iArr = this.indexes;
        return i < iArr.length && iArr[i] == Integer.MAX_VALUE;
    }

    private final boolean isEndOfCommand(int i) {
        int[] iArr = this.indexes;
        return i >= iArr.length || iArr[i] == Integer.MIN_VALUE;
    }

    private final boolean isStartOfToken(int i) {
        return i == 1 || isEndOfToken(i - 1);
    }

    private final Character charAt(int i) {
        if (isEndOfToken(i)) {
            return null;
        }
        return Character.valueOf(this.commandLine.charAt(this.indexes[i]));
    }

    public final int normalizedCommandLineLength() {
        if (isEndOfCommand(1)) {
            return 0;
        }
        int i = 1;
        while (true) {
            int i2 = i + 1;
            if (isEndOfCommand(i2)) {
                return i - 1;
            }
            i = i2;
        }
    }

    public final int computeNormalizedCommandLineHashCode() throws Exception {
        checkGeneration();
        long jCharValue = 1469598103934665603L;
        int i = 1;
        while (!isEndOfCommand(i)) {
            int i2 = i + 1;
            if (isEndOfCommand(i2)) {
                break;
            }
            jCharValue = (jCharValue ^ (charAt(i) == null ? ' ' : r2.charValue())) * 1099511628211L;
            i = i2;
        }
        return (int) jCharValue;
    }

    public final boolean normalizedCommandLineEquals(String other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iNormalizedCommandLineLength = normalizedCommandLineLength();
        int length = other.length();
        if (iNormalizedCommandLineLength == 0 && length == 0) {
            return true;
        }
        if (iNormalizedCommandLineLength != length) {
            return false;
        }
        int i = 1;
        while (i < iNormalizedCommandLineLength) {
            int i2 = i + 1;
            Character chCharAt = charAt(i);
            if ((chCharAt == null ? ' ' : chCharAt.charValue()) != other.charAt(i - 1)) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString(String separator) throws Exception {
        Intrinsics.checkNotNullParameter(separator, "separator");
        checkGeneration();
        int i = 1;
        if (isEndOfCommand(1)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = i + 1;
            if (!isEndOfCommand(i2)) {
                Character chCharAt = charAt(i);
                if (chCharAt == null) {
                    chCharAt = separator;
                }
                sb.append(chCharAt);
                i = i2;
            } else {
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
                return string;
            }
        }
    }

    public String toString() throws Exception {
        String str = this.toStringValue;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            return str;
        }
        String string = toString(" ");
        this.toStringValue = string;
        Intrinsics.checkNotNull(string);
        return string;
    }

    private final void invalidate() {
        this.toStringValue = null;
    }

    private final void checkGeneration() throws Exception {
        if (this.generation != Math.abs(this.indexes[0])) {
            throw new Exception("Buffer indexes was shared with another TokenizedCommandLine after this one");
        }
    }
}
