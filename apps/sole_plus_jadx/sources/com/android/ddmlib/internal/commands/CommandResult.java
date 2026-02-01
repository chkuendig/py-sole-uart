package com.android.ddmlib.internal.commands;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommandResult.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0007HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/android/ddmlib/internal/commands/CommandResult;", "", "()V", "message", "", "(Ljava/lang/String;)V", "success", "", "(ZLjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "ddmlib"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CommandResult {
    private final String message;
    private final boolean success;

    public static /* synthetic */ CommandResult copy$default(CommandResult commandResult, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = commandResult.success;
        }
        if ((i & 2) != 0) {
            str = commandResult.message;
        }
        return commandResult.copy(z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final CommandResult copy(boolean success, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new CommandResult(success, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommandResult)) {
            return false;
        }
        CommandResult commandResult = (CommandResult) other;
        return this.success == commandResult.success && Intrinsics.areEqual(this.message, commandResult.message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.message.hashCode();
    }

    public String toString() {
        return "CommandResult(success=" + this.success + ", message=" + this.message + ')';
    }

    public CommandResult(boolean z, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.success = z;
        this.message = message;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public CommandResult() {
        this(true, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommandResult(String message) {
        this(false, message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
