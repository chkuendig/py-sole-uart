package com.android.io;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Images.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001a\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002¨\u0006\t"}, d2 = {"readImage", "Ljava/awt/image/BufferedImage;", "Ljava/nio/file/Path;", "writeImage", "", "Ljava/awt/image/RenderedImage;", "formatName", "", "output", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Images {
    public static final BufferedImage readImage(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            BufferedImage bufferedImage = ImageIO.read(inputStreamNewInputStream);
            if (bufferedImage == null) {
                throw new IIOException(Intrinsics.stringPlus("Unrecognized image format in file ", path));
            }
            CloseableKt.closeFinally(inputStreamNewInputStream, null);
            return bufferedImage;
        } finally {
        }
    }

    public static final void writeImage(RenderedImage renderedImage, String formatName, Path output) throws IOException {
        Intrinsics.checkNotNullParameter(renderedImage, "<this>");
        Intrinsics.checkNotNullParameter(formatName, "formatName");
        Intrinsics.checkNotNullParameter(output, "output");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(output, new OpenOption[0]);
        try {
            if (!ImageIO.write(renderedImage, formatName, outputStreamNewOutputStream)) {
                throw new IIOException("Unrecognized image format \"" + formatName + '\"');
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStreamNewOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(outputStreamNewOutputStream, th);
                throw th2;
            }
        }
    }
}
