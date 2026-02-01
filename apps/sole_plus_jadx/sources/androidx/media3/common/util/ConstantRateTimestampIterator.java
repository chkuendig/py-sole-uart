package androidx.media3.common.util;

/* loaded from: classes3.dex */
public final class ConstantRateTimestampIterator implements TimestampIterator {
    private double currentTimestampUs;
    private final long durationUs;
    private final float frameRate;
    private final double framesDurationUs;
    private int framesToAdd;

    public ConstantRateTimestampIterator(long j, float f) {
        Assertions.checkArgument(j > 0);
        Assertions.checkArgument(f > 0.0f);
        this.durationUs = j;
        this.frameRate = f;
        this.framesToAdd = Math.round((j / 1000000.0f) * f);
        this.framesDurationUs = 1000000.0f / f;
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public boolean hasNext() {
        return this.framesToAdd != 0;
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public long next() {
        Assertions.checkState(hasNext());
        this.framesToAdd--;
        long jRound = Math.round(this.currentTimestampUs);
        this.currentTimestampUs += this.framesDurationUs;
        return jRound;
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public ConstantRateTimestampIterator copyOf() {
        return new ConstantRateTimestampIterator(this.durationUs, this.frameRate);
    }
}
