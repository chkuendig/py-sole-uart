package com.android.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TokenizedCommandLine.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ZERO_ALLOC_TOKENIZER_END_OF_COMMAND", "", "ZERO_ALLOC_TOKENIZER_END_OF_TOKEN", "allocateTokenizeCommandLineBuffer", "", "commandLine", "", "minimumSizeOfTokenizeCommandLineBuffer", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TokenizedCommandLineKt {
    public static final int ZERO_ALLOC_TOKENIZER_END_OF_COMMAND = Integer.MIN_VALUE;
    public static final int ZERO_ALLOC_TOKENIZER_END_OF_TOKEN = Integer.MAX_VALUE;

    public static final int[] allocateTokenizeCommandLineBuffer(String commandLine) {
        Intrinsics.checkNotNullParameter(commandLine, "commandLine");
        return new int[minimumSizeOfTokenizeCommandLineBuffer(commandLine)];
    }

    public static final int minimumSizeOfTokenizeCommandLineBuffer(String commandLine) {
        Intrinsics.checkNotNullParameter(commandLine, "commandLine");
        return commandLine.length() + 3;
    }
}
