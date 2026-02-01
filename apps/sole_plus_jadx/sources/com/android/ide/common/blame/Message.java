package com.android.ide.common.blame;

import androidx.health.connect.client.records.metadata.DeviceTypes;
import com.android.SdkConstants;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Message.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u00013B3\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t\"\u00020\u0007¢\u0006\u0002\u0010\nBE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t\"\u00020\u0007¢\u0006\u0002\u0010\rB7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\u0010\u0010B;\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\u0010\u0012B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0016HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0015\u001a\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!¨\u00064"}, d2 = {"Lcom/android/ide/common/blame/Message;", "", "kind", "Lcom/android/ide/common/blame/Message$Kind;", "text", "", "sourceFilePosition", "Lcom/android/ide/common/blame/SourceFilePosition;", "sourceFilePositions", "", "(Lcom/android/ide/common/blame/Message$Kind;Ljava/lang/String;Lcom/android/ide/common/blame/SourceFilePosition;[Lcom/android/ide/common/blame/SourceFilePosition;)V", "rawMessage", "toolName", "(Lcom/android/ide/common/blame/Message$Kind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/ide/common/blame/SourceFilePosition;[Lcom/android/ide/common/blame/SourceFilePosition;)V", "positions", "Lcom/google/common/collect/ImmutableList;", "(Lcom/android/ide/common/blame/Message$Kind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/common/collect/ImmutableList;)V", "Lcom/google/common/base/Optional;", "(Lcom/android/ide/common/blame/Message$Kind;Ljava/lang/String;Ljava/lang/String;Lcom/google/common/base/Optional;Lcom/google/common/collect/ImmutableList;)V", "", "(Lcom/android/ide/common/blame/Message$Kind;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", SdkConstants.ATTR_COLUMN, "", "getColumn$annotations", "()V", "getColumn", "()I", "getKind", "()Lcom/android/ide/common/blame/Message$Kind;", "lineNumber", "getLineNumber$annotations", "getLineNumber", "getRawMessage", "()Ljava/lang/String;", "getSourceFilePositions", "()Ljava/util/List;", "sourcePath", "getSourcePath", "getText", "getToolName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Kind", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Message {
    private final Kind kind;
    private final String rawMessage;
    private final List<SourceFilePosition> sourceFilePositions;
    private final String text;
    private final String toolName;

    public static /* synthetic */ Message copy$default(Message message, Kind kind, String str, List list, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            kind = message.kind;
        }
        if ((i & 2) != 0) {
            str = message.text;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            list = message.sourceFilePositions;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            str2 = message.rawMessage;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = message.toolName;
        }
        return message.copy(kind, str4, list2, str5, str3);
    }

    @Deprecated(message = "Use sourceFilePositions", replaceWith = @ReplaceWith(expression = "sourceFilePositions[0].position.startColumn + 1", imports = {}))
    public static /* synthetic */ void getColumn$annotations() {
    }

    @Deprecated(message = "Use sourceFilePositions", replaceWith = @ReplaceWith(expression = "sourceFilePositions[0].position.startLine + 1", imports = {}))
    public static /* synthetic */ void getLineNumber$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Kind getKind() {
        return this.kind;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final List<SourceFilePosition> component3() {
        return this.sourceFilePositions;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRawMessage() {
        return this.rawMessage;
    }

    /* renamed from: component5, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    public final Message copy(Kind kind, String text, List<SourceFilePosition> sourceFilePositions, String rawMessage, String toolName) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(sourceFilePositions, "sourceFilePositions");
        Intrinsics.checkNotNullParameter(rawMessage, "rawMessage");
        return new Message(kind, text, sourceFilePositions, rawMessage, toolName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        return this.kind == message.kind && Intrinsics.areEqual(this.text, message.text) && Intrinsics.areEqual(this.sourceFilePositions, message.sourceFilePositions) && Intrinsics.areEqual(this.rawMessage, message.rawMessage) && Intrinsics.areEqual(this.toolName, message.toolName);
    }

    public int hashCode() {
        int iHashCode = ((((((this.kind.hashCode() * 31) + this.text.hashCode()) * 31) + this.sourceFilePositions.hashCode()) * 31) + this.rawMessage.hashCode()) * 31;
        String str = this.toolName;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Message(kind=" + this.kind + ", text=" + this.text + ", sourceFilePositions=" + this.sourceFilePositions + ", rawMessage=" + this.rawMessage + ", toolName=" + ((Object) this.toolName) + ')';
    }

    public Message(Kind kind, String text, List<SourceFilePosition> sourceFilePositions, String rawMessage, String str) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(sourceFilePositions, "sourceFilePositions");
        Intrinsics.checkNotNullParameter(rawMessage, "rawMessage");
        this.kind = kind;
        this.text = text;
        this.sourceFilePositions = sourceFilePositions;
        this.rawMessage = rawMessage;
        this.toolName = str;
        if (sourceFilePositions.isEmpty()) {
            throw new IllegalArgumentException("Source file positions cannot be empty.");
        }
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Message(Kind kind, String str, List list, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            ImmutableList immutableListOf = ImmutableList.of(SourceFilePosition.UNKNOWN);
            Intrinsics.checkNotNullExpressionValue(immutableListOf, "of(SourceFilePosition.UNKNOWN)");
            list = immutableListOf;
        }
        this(kind, str, (List<SourceFilePosition>) list, (i & 8) != 0 ? str : str2, (i & 16) != 0 ? null : str3);
    }

    public final List<SourceFilePosition> getSourceFilePositions() {
        return this.sourceFilePositions;
    }

    public final String getRawMessage() {
        return this.rawMessage;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final String getSourcePath() {
        File sourceFile = this.sourceFilePositions.get(0).getFile().getSourceFile();
        if (sourceFile == null) {
            return null;
        }
        return sourceFile.getAbsolutePath();
    }

    public final int getLineNumber() {
        return this.sourceFilePositions.get(0).getPosition().getStartLine() + 1;
    }

    public final int getColumn() {
        return this.sourceFilePositions.get(0).getPosition().getStartColumn() + 1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Message(Kind kind, String text, SourceFilePosition sourceFilePosition, SourceFilePosition... sourceFilePositions) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(sourceFilePosition, "sourceFilePosition");
        Intrinsics.checkNotNullParameter(sourceFilePositions, "sourceFilePositions");
        ImmutableList immutableListBuild = ImmutableList.builder().add((ImmutableList.Builder) sourceFilePosition).add(Arrays.copyOf(sourceFilePositions, sourceFilePositions.length)).build();
        Intrinsics.checkNotNullExpressionValue(immutableListBuild, "build()");
        this(kind, text, immutableListBuild, text, null, 16, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Message(Kind kind, String text, String rawMessage, String str, SourceFilePosition sourceFilePosition, SourceFilePosition... sourceFilePositions) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(rawMessage, "rawMessage");
        Intrinsics.checkNotNullParameter(sourceFilePosition, "sourceFilePosition");
        Intrinsics.checkNotNullParameter(sourceFilePositions, "sourceFilePositions");
        ImmutableList immutableListBuild = ImmutableList.builder().add((ImmutableList.Builder) sourceFilePosition).add(Arrays.copyOf(sourceFilePositions, sourceFilePositions.length)).build();
        Intrinsics.checkNotNullExpressionValue(immutableListBuild, "build()");
        this(kind, text, immutableListBuild, rawMessage, str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Message(Kind kind, String text, String rawMessage, String str, ImmutableList<SourceFilePosition> positions) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(rawMessage, "rawMessage");
        Intrinsics.checkNotNullParameter(positions, "positions");
        positions = positions.isEmpty() ? ImmutableList.of(SourceFilePosition.UNKNOWN) : positions;
        Intrinsics.checkNotNullExpressionValue(positions, "if (positions.isEmpty())…  positions\n            }");
        this(kind, text, positions, rawMessage, str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated(message = "Used by kotlin plugin.")
    public Message(Kind kind, String text, String rawMessage, Optional<String> toolName, ImmutableList<SourceFilePosition> positions) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(rawMessage, "rawMessage");
        Intrinsics.checkNotNullParameter(toolName, "toolName");
        Intrinsics.checkNotNullParameter(positions, "positions");
        String strOrNull = toolName.orNull();
        positions = positions.isEmpty() ? ImmutableList.of(SourceFilePosition.UNKNOWN) : positions;
        Intrinsics.checkNotNullExpressionValue(positions, "if (positions.isEmpty())…  positions\n            }");
        this(kind, text, positions, rawMessage, strOrNull);
    }

    /* compiled from: Message.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/android/ide/common/blame/Message$Kind;", "", "(Ljava/lang/String;I)V", "ERROR", "WARNING", "INFO", "STATISTICS", DeviceTypes.UNKNOWN, "SIMPLE", "Companion", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Kind {
        ERROR,
        WARNING,
        INFO,
        STATISTICS,
        UNKNOWN,
        SIMPLE;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @JvmStatic
        public static final Kind findIgnoringCase(String str, Kind kind) {
            return INSTANCE.findIgnoringCase(str, kind);
        }

        /* compiled from: Message.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/android/ide/common/blame/Message$Kind$Companion;", "", "()V", "findIgnoringCase", "Lcom/android/ide/common/blame/Message$Kind;", "s", "", "defaultKind", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Kind findIgnoringCase(String s, Kind defaultKind) {
                Intrinsics.checkNotNullParameter(s, "s");
                Kind[] kindArrValues = Kind.values();
                int length = kindArrValues.length;
                int i = 0;
                while (i < length) {
                    Kind kind = kindArrValues[i];
                    i++;
                    if (StringsKt.equals(kind.toString(), s, true)) {
                        return kind;
                    }
                }
                return defaultKind;
            }
        }
    }
}
