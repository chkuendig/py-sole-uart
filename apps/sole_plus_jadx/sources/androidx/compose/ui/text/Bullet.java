package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Bullet.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJU\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Landroidx/compose/ui/text/Bullet;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", SdkConstants.TAG_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "width", "Landroidx/compose/ui/unit/TextUnit;", "height", SdkConstants.ATTR_PADDING, "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/graphics/Shape;JJJLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getWidth-XSAIIZE", "()J", "J", "getHeight-XSAIIZE", "getPadding-XSAIIZE", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getAlpha", "()F", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "copy", "copy-w_4Rhrw", "(Landroidx/compose/ui/graphics/Shape;JJJLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/Bullet;", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Bullet implements AnnotatedString.Annotation {
    private static final Bullet Default;
    private static final long DefaultPadding;
    private static final long DefaultSize;
    private final float alpha;
    private final Brush brush;
    private final DrawStyle drawStyle;
    private final long height;
    private final long padding;
    private final Shape shape;
    private final long width;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final long DefaultIndentation = TextUnitKt.getEm(1);

    public /* synthetic */ Bullet(Shape shape, long j, long j2, long j3, Brush brush, float f, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(shape, j, j2, j3, brush, f, drawStyle);
    }

    private Bullet(Shape shape, long j, long j2, long j3, Brush brush, float f, DrawStyle drawStyle) {
        this.shape = shape;
        this.width = j;
        this.height = j2;
        this.padding = j3;
        this.brush = brush;
        this.alpha = f;
        this.drawStyle = drawStyle;
    }

    public final Shape getShape() {
        return this.shape;
    }

    /* renamed from: getWidth-XSAIIZE, reason: not valid java name and from getter */
    public final long getWidth() {
        return this.width;
    }

    /* renamed from: getHeight-XSAIIZE, reason: not valid java name and from getter */
    public final long getHeight() {
        return this.height;
    }

    /* renamed from: getPadding-XSAIIZE, reason: not valid java name and from getter */
    public final long getPadding() {
        return this.padding;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public /* synthetic */ Bullet(Shape shape, long j, long j2, long j3, Brush brush, float f, DrawStyle drawStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(shape, j, j2, j3, (i & 16) != 0 ? null : brush, (i & 32) != 0 ? Float.NaN : f, (i & 64) != 0 ? Fill.INSTANCE : drawStyle, null);
    }

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    /* renamed from: copy-w_4Rhrw, reason: not valid java name */
    public final Bullet m6537copyw_4Rhrw(Shape shape, long width, long height, long padding, Brush brush, float alpha, DrawStyle drawStyle) {
        return new Bullet(shape, width, height, padding, brush, alpha, drawStyle, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof Bullet)) {
            Bullet bullet = (Bullet) other;
            return Intrinsics.areEqual(this.shape, bullet.shape) && TextUnit.m7446equalsimpl0(this.width, bullet.width) && TextUnit.m7446equalsimpl0(this.height, bullet.height) && TextUnit.m7446equalsimpl0(this.padding, bullet.padding) && Intrinsics.areEqual(this.brush, bullet.brush) && this.alpha == bullet.alpha && Intrinsics.areEqual(this.drawStyle, bullet.drawStyle);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((((this.shape.hashCode() * 31) + TextUnit.m7450hashCodeimpl(this.width)) * 31) + TextUnit.m7450hashCodeimpl(this.height)) * 31) + TextUnit.m7450hashCodeimpl(this.padding)) * 31;
        Brush brush = this.brush;
        return ((((iHashCode + (brush != null ? brush.hashCode() : 0)) * 31) + Float.hashCode(this.alpha)) * 31) + this.drawStyle.hashCode();
    }

    public String toString() {
        return "Bullet(shape=" + this.shape + ", size=(" + ((Object) TextUnit.m7456toStringimpl(this.width)) + ", " + ((Object) TextUnit.m7456toStringimpl(this.height)) + "), padding=" + ((Object) TextUnit.m7456toStringimpl(this.padding)) + ", brush=" + this.brush + ", alpha=" + this.alpha + ", drawStyle=" + this.drawStyle + ')';
    }

    /* compiled from: Bullet.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/Bullet$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "DefaultIndentation", "Landroidx/compose/ui/unit/TextUnit;", "getDefaultIndentation-XSAIIZE", "()J", "J", "DefaultSize", "getDefaultSize-XSAIIZE", "DefaultPadding", "getDefaultPadding-XSAIIZE", "Default", "Landroidx/compose/ui/text/Bullet;", "getDefault", "()Landroidx/compose/ui/text/Bullet;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getDefaultIndentation-XSAIIZE, reason: not valid java name */
        public final long m6541getDefaultIndentationXSAIIZE() {
            return Bullet.DefaultIndentation;
        }

        /* renamed from: getDefaultSize-XSAIIZE, reason: not valid java name */
        public final long m6543getDefaultSizeXSAIIZE() {
            return Bullet.DefaultSize;
        }

        /* renamed from: getDefaultPadding-XSAIIZE, reason: not valid java name */
        public final long m6542getDefaultPaddingXSAIIZE() {
            return Bullet.DefaultPadding;
        }

        public final Bullet getDefault() {
            return Bullet.Default;
        }
    }

    static {
        long em = TextUnitKt.getEm(0.25d);
        DefaultSize = em;
        long em2 = TextUnitKt.getEm(0.25d);
        DefaultPadding = em2;
        Default = new Bullet(CircleShape.INSTANCE, em, em, em2, null, 0.0f, null, 112, null);
    }
}
