package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.http2.Http2Connection;
import org.apache.commons.lang3.ClassUtils;
import org.apache.http.message.TokenParser;

/* compiled from: Duration.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087@\u0018\u0000 ¬\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¬\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010OJ\u001b\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bV\u0010WJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bV\u0010XJ\u001b\u0010T\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u001a\u0010[\u001a\u00020\\2\b\u0010Q\u001a\u0004\u0018\u00010]HÖ\u0003¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\tHÖ\u0001¢\u0006\u0004\ba\u0010\rJ\r\u0010b\u001a\u00020\\¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\\H\u0002¢\u0006\u0004\bf\u0010dJ\u000f\u0010g\u001a\u00020\\H\u0002¢\u0006\u0004\bh\u0010dJ\r\u0010i\u001a\u00020\\¢\u0006\u0004\bj\u0010dJ\r\u0010k\u001a\u00020\\¢\u0006\u0004\bl\u0010dJ\r\u0010m\u001a\u00020\\¢\u0006\u0004\bn\u0010dJ\u001b\u0010o\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bp\u0010qJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bs\u0010qJ\u001e\u0010t\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010WJ\u001e\u0010t\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010XJ \u0001\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2v\u0010x\u001ar\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(|\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(}\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0yH\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u008c\u0001\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2b\u0010x\u001a^\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(}\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0083\u0001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0084\u0001Jw\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2M\u0010x\u001aI\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0085\u0001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0086\u0001Jb\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w28\u0010x\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0087\u0001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0088\u0001J\u001e\u0010\u0089\u0001\u001a\u00020\u000f2\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001e\u0010\u008e\u0001\u001a\u00020\t2\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u00030\u0092\u0001¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001e\u0010\u0095\u0001\u001a\u00020\u00032\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0099\u0001\u0010\u0005J\u0011\u0010\u009a\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u009b\u0001\u0010\u0005J\u0013\u0010\u009c\u0001\u001a\u00030\u0092\u0001H\u0016¢\u0006\u0006\b\u009d\u0001\u0010\u0094\u0001J*\u0010\u009c\u0001\u001a\u00030\u0092\u00012\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u00012\t\b\u0002\u0010\u009e\u0001\u001a\u00020\t¢\u0006\u0006\b\u009d\u0001\u0010\u009f\u0001J\u0018\u0010 \u0001\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b¡\u0001\u0010\u0005JK\u0010¢\u0001\u001a\u00030£\u0001*\b0¤\u0001j\u0003`¥\u00012\u0007\u0010¦\u0001\u001a\u00020\t2\u0007\u0010§\u0001\u001a\u00020\t2\u0007\u0010¨\u0001\u001a\u00020\t2\b\u0010\u008a\u0001\u001a\u00030\u0092\u00012\u0007\u0010©\u0001\u001a\u00020\\H\u0002¢\u0006\u0006\bª\u0001\u0010«\u0001R\u0017\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\u0005R\u001a\u0010(\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\u0005R\u001a\u0010+\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\u0005R\u001a\u0010.\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\u0005R\u001a\u00101\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\u0005R\u001a\u00104\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\u0005R\u001a\u00107\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\u0005R\u001a\u0010:\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\rR\u001a\u0010=\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\rR\u0014\u0010C\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0015\u0010G\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\rR\u0014\u0010I\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006\u00ad\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays$annotations", "getInWholeDays-impl", "inWholeHours", "getInWholeHours$annotations", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds$annotations", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds$annotations", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes$annotations", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds$annotations", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds$annotations", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Ljava/util/concurrent/TimeUnit;", "getStorageUnit-impl", "(J)Ljava/util/concurrent/TimeUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(JLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(JLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@JvmInline
/* loaded from: classes2.dex */
public final class Duration implements Comparable<Duration> {
    private final long rawValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long ZERO = m1416constructorimpl(0);
    private static final long INFINITE = DurationKt.durationOfMillis(DurationKt.MAX_MILLIS);
    private static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m1414boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1420equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).getRawValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1421equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    public static /* synthetic */ void getInDays$annotations() {
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    public static /* synthetic */ void getInHours$annotations() {
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    public static /* synthetic */ void getInWholeDays$annotations() {
    }

    public static /* synthetic */ void getInWholeHours$annotations() {
    }

    public static /* synthetic */ void getInWholeMicroseconds$annotations() {
    }

    public static /* synthetic */ void getInWholeMilliseconds$annotations() {
    }

    public static /* synthetic */ void getInWholeMinutes$annotations() {
    }

    public static /* synthetic */ void getInWholeNanoseconds$annotations() {
    }

    public static /* synthetic */ void getInWholeSeconds$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m1442getUnitDiscriminatorimpl(long j) {
        return ((int) j) & 1;
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    private static final long m1443getValueimpl(long j) {
        return j >> 1;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1444hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m1446isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m1447isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m1449isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m1450isPositiveimpl(long j) {
        return j > 0;
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m1469compareToLRDsOJo(long j) {
        return m1415compareToLRDsOJo(this.rawValue, j);
    }

    public boolean equals(Object obj) {
        return m1420equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m1444hashCodeimpl(this.rawValue);
    }

    public String toString() {
        return m1465toStringimpl(this.rawValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m1469compareToLRDsOJo(duration.getRawValue());
    }

    /* renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final TimeUnit m1441getStorageUnitimpl(long j) {
        return m1447isInNanosimpl(j) ? TimeUnit.NANOSECONDS : TimeUnit.MILLISECONDS;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1416constructorimpl(long j) {
        if (m1447isInNanosimpl(j)) {
            long jM1443getValueimpl = m1443getValueimpl(j);
            if (-4611686018426999999L > jM1443getValueimpl || DurationKt.MAX_NANOS < jM1443getValueimpl) {
                throw new AssertionError(m1443getValueimpl(j) + " ns is out of nanoseconds range");
            }
        } else {
            long jM1443getValueimpl2 = m1443getValueimpl(j);
            if (-4611686018427387903L > jM1443getValueimpl2 || DurationKt.MAX_MILLIS < jM1443getValueimpl2) {
                throw new AssertionError(m1443getValueimpl(j) + " ms is out of milliseconds range");
            }
            long jM1443getValueimpl3 = m1443getValueimpl(j);
            if (-4611686018426L <= jM1443getValueimpl3 && 4611686018426L >= jM1443getValueimpl3) {
                throw new AssertionError(m1443getValueimpl(j) + " ms is denormalized");
            }
        }
        return j;
    }

    /* compiled from: Duration.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0017J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0015J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0017J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0019J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0015J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0019J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0015J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0017J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0019J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0015J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0017J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0019J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010'J\u001d\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b+J\u001d\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b-J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0015J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0017J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0019R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00060"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "days", "days-UwyO8pc", "(D)J", "", "(I)J", "", "(J)J", "hours", "hours-UwyO8pc", "microseconds", "microseconds-UwyO8pc", "milliseconds", "milliseconds-UwyO8pc", "minutes", "minutes-UwyO8pc", "nanoseconds", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m1476getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m1474getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m1475getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        public final double convert(double value, TimeUnit sourceUnit, TimeUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m1490nanosecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.NANOSECONDS);
        }

        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m1491nanosecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.NANOSECONDS);
        }

        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m1489nanosecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.NANOSECONDS);
        }

        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m1481microsecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.MICROSECONDS);
        }

        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m1482microsecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.MICROSECONDS);
        }

        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m1480microsecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.MICROSECONDS);
        }

        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m1484millisecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.MILLISECONDS);
        }

        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m1485millisecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.MILLISECONDS);
        }

        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m1483millisecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.MILLISECONDS);
        }

        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m1497secondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.SECONDS);
        }

        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m1498secondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.SECONDS);
        }

        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m1496secondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.SECONDS);
        }

        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m1487minutesUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.MINUTES);
        }

        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m1488minutesUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.MINUTES);
        }

        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m1486minutesUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.MINUTES);
        }

        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m1478hoursUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.HOURS);
        }

        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m1479hoursUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.HOURS);
        }

        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m1477hoursUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.HOURS);
        }

        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m1472daysUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.DAYS);
        }

        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m1473daysUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.DAYS);
        }

        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m1471daysUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.DAYS);
        }

        /* renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m1492parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.parseDuration(value, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m1493parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m1495parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m1414boximpl(DurationKt.parseDuration(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m1494parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m1414boximpl(DurationKt.parseDuration(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    /* renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m1468unaryMinusUwyO8pc(long j) {
        return DurationKt.durationOf(-m1443getValueimpl(j), ((int) j) & 1);
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m1452plusLRDsOJo(long j, long j2) {
        if (m1448isInfiniteimpl(j)) {
            if (m1445isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (m1448isInfiniteimpl(j2)) {
            return j2;
        }
        if ((((int) j) & 1) == (((int) j2) & 1)) {
            long jM1443getValueimpl = m1443getValueimpl(j) + m1443getValueimpl(j2);
            return m1447isInNanosimpl(j) ? DurationKt.durationOfNanosNormalized(jM1443getValueimpl) : DurationKt.durationOfMillisNormalized(jM1443getValueimpl);
        }
        if (m1446isInMillisimpl(j)) {
            return m1412addValuesMixedRangesUwyO8pc(j, m1443getValueimpl(j), m1443getValueimpl(j2));
        }
        return m1412addValuesMixedRangesUwyO8pc(j, m1443getValueimpl(j2), m1443getValueimpl(j));
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m1412addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long jNanosToMillis = DurationKt.nanosToMillis(j3);
        long j4 = j2 + jNanosToMillis;
        if (-4611686018426L <= j4 && 4611686018426L >= j4) {
            return DurationKt.durationOfNanos(DurationKt.millisToNanos(j4) + (j3 - DurationKt.millisToNanos(jNanosToMillis)));
        }
        return DurationKt.durationOfMillis(RangesKt.coerceIn(j4, -4611686018427387903L, DurationKt.MAX_MILLIS));
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m1451minusLRDsOJo(long j, long j2) {
        return m1452plusLRDsOJo(j, m1468unaryMinusUwyO8pc(j2));
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1454timesUwyO8pc(long j, int i) {
        if (m1448isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m1468unaryMinusUwyO8pc(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i == 0) {
            return ZERO;
        }
        long jM1443getValueimpl = m1443getValueimpl(j);
        long j2 = i;
        long j3 = jM1443getValueimpl * j2;
        if (!m1447isInNanosimpl(j)) {
            if (j3 / j2 == jM1443getValueimpl) {
                return DurationKt.durationOfMillis(RangesKt.coerceIn(j3, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
            }
            return MathKt.getSign(jM1443getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        if (-2147483647L <= jM1443getValueimpl && 2147483647L >= jM1443getValueimpl) {
            return DurationKt.durationOfNanos(j3);
        }
        if (j3 / j2 == jM1443getValueimpl) {
            return DurationKt.durationOfNanosNormalized(j3);
        }
        long jNanosToMillis = DurationKt.nanosToMillis(jM1443getValueimpl);
        long j4 = jNanosToMillis * j2;
        long jNanosToMillis2 = DurationKt.nanosToMillis((jM1443getValueimpl - DurationKt.millisToNanos(jNanosToMillis)) * j2) + j4;
        if (j4 / j2 != jNanosToMillis || (jNanosToMillis2 ^ j4) < 0) {
            return MathKt.getSign(jM1443getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        return DurationKt.durationOfMillis(RangesKt.coerceIn(jNanosToMillis2, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1453timesUwyO8pc(long j, double d) {
        int iRoundToInt = MathKt.roundToInt(d);
        if (iRoundToInt == d) {
            return m1454timesUwyO8pc(j, iRoundToInt);
        }
        TimeUnit timeUnitM1441getStorageUnitimpl = m1441getStorageUnitimpl(j);
        return DurationKt.toDuration(m1459toDoubleimpl(j, timeUnitM1441getStorageUnitimpl) * d, timeUnitM1441getStorageUnitimpl);
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1419divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m1450isPositiveimpl(j)) {
                return INFINITE;
            }
            if (m1449isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (m1447isInNanosimpl(j)) {
            return DurationKt.durationOfNanos(m1443getValueimpl(j) / i);
        }
        if (m1448isInfiniteimpl(j)) {
            return m1454timesUwyO8pc(j, MathKt.getSign(i));
        }
        long j2 = i;
        long jM1443getValueimpl = m1443getValueimpl(j) / j2;
        if (-4611686018426L <= jM1443getValueimpl && 4611686018426L >= jM1443getValueimpl) {
            return DurationKt.durationOfNanos(DurationKt.millisToNanos(jM1443getValueimpl) + (DurationKt.millisToNanos(m1443getValueimpl(j) - (jM1443getValueimpl * j2)) / j2));
        }
        return DurationKt.durationOfMillis(jM1443getValueimpl);
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1418divUwyO8pc(long j, double d) {
        int iRoundToInt = MathKt.roundToInt(d);
        if (iRoundToInt == d && iRoundToInt != 0) {
            return m1419divUwyO8pc(j, iRoundToInt);
        }
        TimeUnit timeUnitM1441getStorageUnitimpl = m1441getStorageUnitimpl(j);
        return DurationKt.toDuration(m1459toDoubleimpl(j, timeUnitM1441getStorageUnitimpl) / d, timeUnitM1441getStorageUnitimpl);
    }

    /* renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m1417divLRDsOJo(long j, long j2) {
        TimeUnit timeUnit = (TimeUnit) ComparisonsKt.maxOf(m1441getStorageUnitimpl(j), m1441getStorageUnitimpl(j2));
        return m1459toDoubleimpl(j, timeUnit) / m1459toDoubleimpl(j2, timeUnit);
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m1448isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m1445isFiniteimpl(long j) {
        return !m1448isInfiniteimpl(j);
    }

    /* renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m1422getAbsoluteValueUwyO8pc(long j) {
        return m1449isNegativeimpl(j) ? m1468unaryMinusUwyO8pc(j) : j;
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m1415compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return (j > j2 ? 1 : (j == j2 ? 0 : -1));
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m1449isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1458toComponentsimpl(long j, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf(m1460toIntimpl(j, TimeUnit.DAYS)), Integer.valueOf(m1423getHoursComponentimpl(j)), Integer.valueOf(m1438getMinutesComponentimpl(j)), Integer.valueOf(m1440getSecondsComponentimpl(j)), Integer.valueOf(m1439getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1457toComponentsimpl(long j, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf(m1460toIntimpl(j, TimeUnit.HOURS)), Integer.valueOf(m1438getMinutesComponentimpl(j)), Integer.valueOf(m1440getSecondsComponentimpl(j)), Integer.valueOf(m1439getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1456toComponentsimpl(long j, Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf(m1460toIntimpl(j, TimeUnit.MINUTES)), Integer.valueOf(m1440getSecondsComponentimpl(j)), Integer.valueOf(m1439getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1455toComponentsimpl(long j, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m1437getInWholeSecondsimpl(j)), Integer.valueOf(m1439getNanosecondsComponentimpl(j)));
    }

    /* renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m1423getHoursComponentimpl(long j) {
        if (m1448isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m1432getInWholeHoursimpl(j) % 24);
    }

    /* renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m1438getMinutesComponentimpl(long j) {
        if (m1448isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m1435getInWholeMinutesimpl(j) % 60);
    }

    /* renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m1440getSecondsComponentimpl(long j) {
        if (m1448isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m1437getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m1439getNanosecondsComponentimpl(long j) {
        long jM1443getValueimpl;
        if (m1448isInfiniteimpl(j)) {
            return 0;
        }
        if (m1446isInMillisimpl(j)) {
            jM1443getValueimpl = DurationKt.millisToNanos(m1443getValueimpl(j) % 1000);
        } else {
            jM1443getValueimpl = m1443getValueimpl(j) % Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
        }
        return (int) jM1443getValueimpl;
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m1459toDoubleimpl(long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt.convertDurationUnit(m1443getValueimpl(j), m1441getStorageUnitimpl(j), unit);
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m1462toLongimpl(long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt.convertDurationUnit(m1443getValueimpl(j), m1441getStorageUnitimpl(j), unit);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    public static final int m1460toIntimpl(long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt.coerceIn(m1462toLongimpl(j, unit), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* renamed from: getInDays-impl, reason: not valid java name */
    public static final double m1424getInDaysimpl(long j) {
        return m1459toDoubleimpl(j, TimeUnit.DAYS);
    }

    /* renamed from: getInHours-impl, reason: not valid java name */
    public static final double m1425getInHoursimpl(long j) {
        return m1459toDoubleimpl(j, TimeUnit.HOURS);
    }

    /* renamed from: getInMinutes-impl, reason: not valid java name */
    public static final double m1428getInMinutesimpl(long j) {
        return m1459toDoubleimpl(j, TimeUnit.MINUTES);
    }

    /* renamed from: getInSeconds-impl, reason: not valid java name */
    public static final double m1430getInSecondsimpl(long j) {
        return m1459toDoubleimpl(j, TimeUnit.SECONDS);
    }

    /* renamed from: getInMilliseconds-impl, reason: not valid java name */
    public static final double m1427getInMillisecondsimpl(long j) {
        return m1459toDoubleimpl(j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: getInMicroseconds-impl, reason: not valid java name */
    public static final double m1426getInMicrosecondsimpl(long j) {
        return m1459toDoubleimpl(j, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInNanoseconds-impl, reason: not valid java name */
    public static final double m1429getInNanosecondsimpl(long j) {
        return m1459toDoubleimpl(j, TimeUnit.NANOSECONDS);
    }

    /* renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m1431getInWholeDaysimpl(long j) {
        return m1462toLongimpl(j, TimeUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m1432getInWholeHoursimpl(long j) {
        return m1462toLongimpl(j, TimeUnit.HOURS);
    }

    /* renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m1435getInWholeMinutesimpl(long j) {
        return m1462toLongimpl(j, TimeUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m1437getInWholeSecondsimpl(long j) {
        return m1462toLongimpl(j, TimeUnit.SECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m1434getInWholeMillisecondsimpl(long j) {
        return (m1446isInMillisimpl(j) && m1445isFiniteimpl(j)) ? m1443getValueimpl(j) : m1462toLongimpl(j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m1433getInWholeMicrosecondsimpl(long j) {
        return m1462toLongimpl(j, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m1436getInWholeNanosecondsimpl(long j) {
        long jM1443getValueimpl = m1443getValueimpl(j);
        if (m1447isInNanosimpl(j)) {
            return jM1443getValueimpl;
        }
        if (jM1443getValueimpl > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (jM1443getValueimpl < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.millisToNanos(jM1443getValueimpl);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    /* renamed from: toLongNanoseconds-impl, reason: not valid java name */
    public static final long m1464toLongNanosecondsimpl(long j) {
        return m1436getInWholeNanosecondsimpl(j);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    /* renamed from: toLongMilliseconds-impl, reason: not valid java name */
    public static final long m1463toLongMillisecondsimpl(long j) {
        return m1434getInWholeMillisecondsimpl(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1465toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean zM1449isNegativeimpl = m1449isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (zM1449isNegativeimpl) {
            sb.append('-');
        }
        long jM1422getAbsoluteValueUwyO8pc = m1422getAbsoluteValueUwyO8pc(j);
        m1460toIntimpl(jM1422getAbsoluteValueUwyO8pc, TimeUnit.DAYS);
        int iM1423getHoursComponentimpl = m1423getHoursComponentimpl(jM1422getAbsoluteValueUwyO8pc);
        int iM1438getMinutesComponentimpl = m1438getMinutesComponentimpl(jM1422getAbsoluteValueUwyO8pc);
        int iM1440getSecondsComponentimpl = m1440getSecondsComponentimpl(jM1422getAbsoluteValueUwyO8pc);
        int iM1439getNanosecondsComponentimpl = m1439getNanosecondsComponentimpl(jM1422getAbsoluteValueUwyO8pc);
        long jM1431getInWholeDaysimpl = m1431getInWholeDaysimpl(jM1422getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = jM1431getInWholeDaysimpl != 0;
        boolean z2 = iM1423getHoursComponentimpl != 0;
        boolean z3 = iM1438getMinutesComponentimpl != 0;
        boolean z4 = (iM1440getSecondsComponentimpl == 0 && iM1439getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(jM1431getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(TokenParser.SP);
            }
            sb.append(iM1423getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(TokenParser.SP);
            }
            sb.append(iM1438getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(TokenParser.SP);
            }
            if (iM1440getSecondsComponentimpl != 0 || z || z2 || z3) {
                m1413appendFractionalimpl(jM1422getAbsoluteValueUwyO8pc, sb, iM1440getSecondsComponentimpl, iM1439getNanosecondsComponentimpl, 9, "s", false);
            } else if (iM1439getNanosecondsComponentimpl >= 1000000) {
                m1413appendFractionalimpl(jM1422getAbsoluteValueUwyO8pc, sb, iM1439getNanosecondsComponentimpl / DurationKt.NANOS_IN_MILLIS, iM1439getNanosecondsComponentimpl % DurationKt.NANOS_IN_MILLIS, 6, "ms", false);
            } else if (iM1439getNanosecondsComponentimpl >= 1000) {
                m1413appendFractionalimpl(jM1422getAbsoluteValueUwyO8pc, sb, iM1439getNanosecondsComponentimpl / 1000, iM1439getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(iM1439getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i = i4;
        }
        if (zM1449isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m1413appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            String strPadStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = strPadStart.length() - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                if (strPadStart.charAt(length) != '0') {
                    i4 = length;
                    break;
                }
                length--;
            }
            int i5 = i4 + 1;
            if (!z && i5 < 3) {
                sb.append((CharSequence) strPadStart, 0, i5);
                Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) strPadStart, 0, ((i5 + 2) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    /* renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m1467toStringimpl$default(long j, TimeUnit timeUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m1466toStringimpl(j, timeUnit, i);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static final String m1466toStringimpl(long j, TimeUnit unit, int i) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
        }
        double dM1459toDoubleimpl = m1459toDoubleimpl(j, unit);
        if (Double.isInfinite(dM1459toDoubleimpl)) {
            return String.valueOf(dM1459toDoubleimpl);
        }
        return FormatToDecimalsKt.formatToExactDecimals(dM1459toDoubleimpl, RangesKt.coerceAtMost(i, 12)) + DurationUnitKt.shortName(unit);
    }

    /* renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m1461toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m1449isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long jM1422getAbsoluteValueUwyO8pc = m1422getAbsoluteValueUwyO8pc(j);
        m1460toIntimpl(jM1422getAbsoluteValueUwyO8pc, TimeUnit.HOURS);
        int iM1438getMinutesComponentimpl = m1438getMinutesComponentimpl(jM1422getAbsoluteValueUwyO8pc);
        int iM1440getSecondsComponentimpl = m1440getSecondsComponentimpl(jM1422getAbsoluteValueUwyO8pc);
        int iM1439getNanosecondsComponentimpl = m1439getNanosecondsComponentimpl(jM1422getAbsoluteValueUwyO8pc);
        long jM1432getInWholeHoursimpl = m1432getInWholeHoursimpl(jM1422getAbsoluteValueUwyO8pc);
        if (m1448isInfiniteimpl(j)) {
            jM1432getInWholeHoursimpl = 9999999999999L;
        }
        boolean z = true;
        boolean z2 = jM1432getInWholeHoursimpl != 0;
        boolean z3 = (iM1440getSecondsComponentimpl == 0 && iM1439getNanosecondsComponentimpl == 0) ? false : true;
        if (iM1438getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(jM1432getInWholeHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(iM1438getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m1413appendFractionalimpl(j, sb, iM1440getSecondsComponentimpl, iM1439getNanosecondsComponentimpl, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
