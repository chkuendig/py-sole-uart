package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.PathIterator;
import com.android.SdkConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: Path.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000 _2\u00020\u0001:\u0002^_J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH&J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH&J(\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH'J(\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J(\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH'J(\u0010!\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0016J8\u0010\"\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH&J8\u0010%\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH&J(\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\tH\u0016J(\u0010.\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\tH&J\u0010\u00101\u001a\u00020\r2\u0006\u0010)\u001a\u00020*H'J\u001a\u00101\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u00102\u001a\u000203H&J\u0010\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020*H'J\u001a\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020*2\b\b\u0002\u00102\u001a\u000203H&J\u0010\u00106\u001a\u00020\r2\u0006\u00107\u001a\u000208H'J\u001a\u00106\u001a\u00020\r2\u0006\u00107\u001a\u0002082\b\b\u0002\u00102\u001a\u000203H&J \u00109\u001a\u00020\r2\u0006\u00105\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH&J \u0010:\u001a\u00020\r2\u0006\u00105\u001a\u00020*2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fH&J!\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u00002\b\b\u0002\u0010=\u001a\u00020>H&¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020\rH&J\b\u0010B\u001a\u00020\rH&J\b\u0010C\u001a\u00020\rH\u0016J\u0017\u0010D\u001a\u00020\r2\u0006\u0010=\u001a\u00020>H&¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\r2\u0006\u0010H\u001a\u00020IH\u0016¢\u0006\u0004\bJ\u0010KJ\b\u0010L\u001a\u00020*H&J\t\u0010M\u001a\u00020NH\u0096\u0002J\u001a\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020\u000fH\u0016J'\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020VH&¢\u0006\u0004\bW\u0010XJ\u0011\u0010Y\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0096\u0002J\u0011\u0010Z\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0096\u0002J\u0011\u0010[\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0096\u0004J\u0011\u0010\\\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0096\u0004J\u0011\u0010]\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0096\u0004R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006`À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/Path;", "", "fillType", "Landroidx/compose/ui/graphics/PathFillType;", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "isConvex", "", "()Z", "isEmpty", "moveTo", "", "x", "", "y", "relativeMoveTo", "dx", "dy", "lineTo", "relativeLineTo", "quadraticBezierTo", "x1", "y1", "x2", "y2", "quadraticTo", "relativeQuadraticBezierTo", "dx1", "dy1", "dx2", "dy2", "relativeQuadraticTo", "cubicTo", "x3", "y3", "relativeCubicTo", "dx3", "dy3", "arcToRad", "rect", "Landroidx/compose/ui/geometry/Rect;", "startAngleRadians", "sweepAngleRadians", "forceMoveTo", "arcTo", "startAngleDegrees", "sweepAngleDegrees", "addRect", "direction", "Landroidx/compose/ui/graphics/Path$Direction;", "addOval", "oval", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "addArcRad", "addArc", "addPath", "path", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "close", "reset", "rewind", "translate", "translate-k-4lQ0M", "(J)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "getBounds", "iterator", "Landroidx/compose/ui/graphics/PathIterator;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "op", "path1", "path2", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "plus", "minus", "or", "and", "xor", "Direction", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Path {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void addArc(Rect oval, float startAngleDegrees, float sweepAngleDegrees);

    void addArcRad(Rect oval, float startAngleRadians, float sweepAngleRadians);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addOval() with a winding direction", replaceWith = @ReplaceWith(expression = "addOval(oval)", imports = {}))
    /* synthetic */ void addOval(Rect oval);

    void addOval(Rect oval, Direction direction);

    /* renamed from: addPath-Uv8p0NA */
    void mo4426addPathUv8p0NA(Path path, long offset);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addRect() with a winding direction", replaceWith = @ReplaceWith(expression = "addRect(rect)", imports = {}))
    /* synthetic */ void addRect(Rect rect);

    void addRect(Rect rect, Direction direction);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addRoundRect() with a winding direction", replaceWith = @ReplaceWith(expression = "addRoundRect(roundRect)", imports = {}))
    /* synthetic */ void addRoundRect(RoundRect roundRect);

    void addRoundRect(RoundRect roundRect, Direction direction);

    void arcTo(Rect rect, float startAngleDegrees, float sweepAngleDegrees, boolean forceMoveTo);

    void close();

    void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3);

    Rect getBounds();

    /* renamed from: getFillType-Rg-k1Os */
    int mo4427getFillTypeRgk1Os();

    boolean isConvex();

    boolean isEmpty();

    void lineTo(float x, float y);

    void moveTo(float x, float y);

    /* renamed from: op-N5in7k0 */
    boolean mo4428opN5in7k0(Path path1, Path path2, int operation);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use quadraticTo() for consistency with cubicTo()", replaceWith = @ReplaceWith(expression = "quadraticTo(x1, y1, x2, y2)", imports = {}))
    void quadraticBezierTo(float x1, float y1, float x2, float y2);

    void relativeCubicTo(float dx1, float dy1, float dx2, float dy2, float dx3, float dy3);

    void relativeLineTo(float dx, float dy);

    void relativeMoveTo(float dx, float dy);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use relativeQuadraticTo() for consistency with relativeCubicTo()", replaceWith = @ReplaceWith(expression = "relativeQuadraticTo(dx1, dy1, dx2, dy2)", imports = {}))
    void relativeQuadraticBezierTo(float dx1, float dy1, float dx2, float dy2);

    void reset();

    /* renamed from: setFillType-oQ8Xj4U */
    void mo4429setFillTypeoQ8Xj4U(int i);

    /* renamed from: transform-58bKbWc */
    default void mo4430transform58bKbWc(float[] matrix) {
    }

    /* renamed from: translate-k-4lQ0M */
    void mo4431translatek4lQ0M(long offset);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Path.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/graphics/Path$Direction;", "", SdkConstants.CONSTRUCTOR_NAME, "(Ljava/lang/String;I)V", "CounterClockwise", "Clockwise", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Direction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Direction[] $VALUES;
        public static final Direction CounterClockwise = new Direction("CounterClockwise", 0);
        public static final Direction Clockwise = new Direction("Clockwise", 1);

        private static final /* synthetic */ Direction[] $values() {
            return new Direction[]{CounterClockwise, Clockwise};
        }

        public static EnumEntries<Direction> getEntries() {
            return $ENTRIES;
        }

        private Direction(String str, int i) {
        }

        static {
            Direction[] directionArr$values = $values();
            $VALUES = directionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(directionArr$values);
        }

        public static Direction valueOf(String str) {
            return (Direction) Enum.valueOf(Direction.class, str);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }
    }

    /* compiled from: Path.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void quadraticTo(Path path, float f, float f2, float f3, float f4) {
            Path.super.quadraticTo(f, f2, f3, f4);
        }

        @Deprecated
        public static void relativeQuadraticTo(Path path, float f, float f2, float f3, float f4) {
            Path.super.relativeQuadraticTo(f, f2, f3, f4);
        }

        @Deprecated
        public static void arcToRad(Path path, Rect rect, float f, float f2, boolean z) {
            Path.super.arcToRad(rect, f, f2, z);
        }

        @Deprecated
        public static void rewind(Path path) {
            Path.super.rewind();
        }

        @Deprecated
        /* renamed from: transform-58bKbWc, reason: not valid java name */
        public static void m4823transform58bKbWc(Path path, float[] fArr) {
            Path.super.mo4430transform58bKbWc(fArr);
        }

        @Deprecated
        public static PathIterator iterator(Path path) {
            return Path.super.iterator();
        }

        @Deprecated
        public static PathIterator iterator(Path path, PathIterator.ConicEvaluation conicEvaluation, float f) {
            return Path.super.iterator(conicEvaluation, f);
        }

        @Deprecated
        public static Path plus(Path path, Path path2) {
            return Path.super.plus(path2);
        }

        @Deprecated
        public static Path minus(Path path, Path path2) {
            return Path.super.minus(path2);
        }

        @Deprecated
        public static Path or(Path path, Path path2) {
            return Path.super.or(path2);
        }

        @Deprecated
        public static Path and(Path path, Path path2) {
            return Path.super.and(path2);
        }

        @Deprecated
        public static Path xor(Path path, Path path2) {
            return Path.super.xor(path2);
        }
    }

    default void quadraticTo(float x1, float y1, float x2, float y2) {
        quadraticBezierTo(x1, y1, x2, y2);
    }

    default void relativeQuadraticTo(float dx1, float dy1, float dx2, float dy2) {
        relativeQuadraticBezierTo(dx1, dy1, dx2, dy2);
    }

    default void arcToRad(Rect rect, float startAngleRadians, float sweepAngleRadians, boolean forceMoveTo) {
        arcTo(rect, DegreesKt.degrees(startAngleRadians), DegreesKt.degrees(sweepAngleRadians), forceMoveTo);
    }

    static /* synthetic */ void addRect$default(Path path, Rect rect, Direction direction, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRect");
        }
        if ((i & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addRect(rect, direction);
    }

    static /* synthetic */ void addOval$default(Path path, Rect rect, Direction direction, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addOval");
        }
        if ((i & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addOval(rect, direction);
    }

    static /* synthetic */ void addRoundRect$default(Path path, RoundRect roundRect, Direction direction, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRoundRect");
        }
        if ((i & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addRoundRect(roundRect, direction);
    }

    /* renamed from: addPath-Uv8p0NA$default, reason: not valid java name */
    static /* synthetic */ void m4820addPathUv8p0NA$default(Path path, Path path2, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
        }
        if ((i & 2) != 0) {
            j = Offset.INSTANCE.m4310getZeroF1C5BW0();
        }
        path.mo4426addPathUv8p0NA(path2, j);
    }

    default void rewind() {
        reset();
    }

    default PathIterator iterator() {
        return AndroidPathIterator_androidKt.PathIterator$default(this, null, 0.0f, 6, null);
    }

    static /* synthetic */ PathIterator iterator$default(Path path, PathIterator.ConicEvaluation conicEvaluation, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: iterator");
        }
        if ((i & 2) != 0) {
            f = 0.25f;
        }
        return path.iterator(conicEvaluation, f);
    }

    default PathIterator iterator(PathIterator.ConicEvaluation conicEvaluation, float tolerance) {
        return AndroidPathIterator_androidKt.PathIterator(this, conicEvaluation, tolerance);
    }

    default Path plus(Path path) {
        Path Path = AndroidPath_androidKt.Path();
        Path.mo4428opN5in7k0(this, path, PathOperation.INSTANCE.m4845getUnionb3I0S0c());
        return Path;
    }

    default Path minus(Path path) {
        Path Path = AndroidPath_androidKt.Path();
        Path.mo4428opN5in7k0(this, path, PathOperation.INSTANCE.m4842getDifferenceb3I0S0c());
        return Path;
    }

    default Path or(Path path) {
        return plus(path);
    }

    default Path and(Path path) {
        Path Path = AndroidPath_androidKt.Path();
        Path.mo4428opN5in7k0(this, path, PathOperation.INSTANCE.m4843getIntersectb3I0S0c());
        return Path;
    }

    default Path xor(Path path) {
        Path Path = AndroidPath_androidKt.Path();
        Path.mo4428opN5in7k0(this, path, PathOperation.INSTANCE.m4846getXorb3I0S0c());
        return Path;
    }

    /* compiled from: Path.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/Path$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "combine", "Landroidx/compose/ui/graphics/Path;", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "path1", "path2", "combine-xh6zSI8", "(ILandroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;)Landroidx/compose/ui/graphics/Path;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* renamed from: combine-xh6zSI8, reason: not valid java name */
        public final Path m4821combinexh6zSI8(int operation, Path path1, Path path2) {
            Path Path = AndroidPath_androidKt.Path();
            if (Path.mo4428opN5in7k0(path1, path2, operation)) {
                return Path;
            }
            throw new IllegalArgumentException("Path.combine() failed.  This may be due an invalid path; in particular, check for NaN values.");
        }
    }
}
