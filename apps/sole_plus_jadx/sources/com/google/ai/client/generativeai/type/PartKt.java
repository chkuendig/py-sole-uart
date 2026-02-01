package com.google.ai.client.generativeai.type;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Part.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0002\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002¨\u0006\t"}, d2 = {"asBlobPartOrNull", "Lcom/google/ai/client/generativeai/type/BlobPart;", "Lcom/google/ai/client/generativeai/type/Part;", "asFileDataPartOrNull", "Lcom/google/ai/client/generativeai/type/FileDataPart;", "asImageOrNull", "Landroid/graphics/Bitmap;", "asTextOrNull", "", "generativeai_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PartKt {
    public static final FileDataPart asFileDataPartOrNull(Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        if (part instanceof FileDataPart) {
            return (FileDataPart) part;
        }
        return null;
    }

    public static final String asTextOrNull(Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        TextPart textPart = part instanceof TextPart ? (TextPart) part : null;
        if (textPart != null) {
            return textPart.getText();
        }
        return null;
    }

    public static final Bitmap asImageOrNull(Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        ImagePart imagePart = part instanceof ImagePart ? (ImagePart) part : null;
        if (imagePart != null) {
            return imagePart.getImage();
        }
        return null;
    }

    public static final BlobPart asBlobPartOrNull(Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        if (part instanceof BlobPart) {
            return (BlobPart) part;
        }
        return null;
    }
}
