package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.apache.commons.lang3.ClassUtils;

/* compiled from: TimeSources.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(TimeUnit.NANOSECONDS);
    }

    @Override // kotlin.time.AbstractLongTimeSource
    /* renamed from: read, reason: from getter */
    protected long getReading() {
        return this.reading;
    }

    /* renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m1502plusAssignLRDsOJo(long duration) {
        long j;
        long jM1462toLongimpl = Duration.m1462toLongimpl(duration, getUnit());
        if (jM1462toLongimpl != Long.MIN_VALUE && jM1462toLongimpl != Long.MAX_VALUE) {
            long j2 = this.reading;
            j = j2 + jM1462toLongimpl;
            if ((jM1462toLongimpl ^ j2) >= 0 && (j2 ^ j) < 0) {
                m1501overflowLRDsOJo(duration);
            }
        } else {
            double dM1459toDoubleimpl = this.reading + Duration.m1459toDoubleimpl(duration, getUnit());
            if (dM1459toDoubleimpl > Long.MAX_VALUE || dM1459toDoubleimpl < Long.MIN_VALUE) {
                m1501overflowLRDsOJo(duration);
            }
            j = (long) dM1459toDoubleimpl;
        }
        this.reading = j;
    }

    /* renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m1501overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + "ns is advanced by " + Duration.m1465toStringimpl(duration) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }
}
