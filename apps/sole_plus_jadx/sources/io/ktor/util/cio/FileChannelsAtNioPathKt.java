package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.File;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileChannelsAtNioPath.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"readChannel", "Lio/ktor/utils/io/ByteReadChannel;", "Ljava/nio/file/Path;", "start", "", "endInclusive", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FileChannelsAtNioPathKt {
    public static final ByteReadChannel readChannel(Path path, long j, long j2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        File file = path.toFile();
        Intrinsics.checkNotNullExpressionValue(file, "toFile()");
        return FileChannelsKt.readChannel$default(file, j, j2, null, 4, null);
    }

    public static final ByteReadChannel readChannel(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        File file = path.toFile();
        Intrinsics.checkNotNullExpressionValue(file, "toFile()");
        return FileChannelsKt.readChannel$default(file, 0L, 0L, null, 7, null);
    }
}
