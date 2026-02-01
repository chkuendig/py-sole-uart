package androidx.media3.common.util;

/* loaded from: classes3.dex */
public interface TimestampIterator {
    TimestampIterator copyOf();

    boolean hasNext();

    long next();
}
