package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Colors.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020BH\u0016R1\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R1\u0010\t\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00108F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u000f\u0010\u001c\"\u0004\b\u001d\u0010\u001eR1\u0010\f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R1\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b%\u0010\u0018\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R1\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b(\u0010\u0018\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R1\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b+\u0010\u0018\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R1\u0010\r\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b.\u0010\u0018\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R1\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b4\u0010\u0018\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016R1\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b7\u0010\u0018\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R1\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b:\u0010\u0018\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R1\u0010\b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b=\u0010\u0018\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006C"}, d2 = {"Landroidx/compose/material/Colors;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", SdkConstants.ATTR_BACKGROUND, "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "isLight", "", "(JJJJJJJJJJJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA$material_release", "(J)V", "background$delegate", "Landroidx/compose/runtime/MutableState;", "getError-0d7_KjU", "setError-8_81llA$material_release", "error$delegate", "()Z", "setLight$material_release", "(Z)V", "isLight$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material_release", "onBackground$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material_release", "onError$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material_release", "onPrimary$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material_release", "onSecondary$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material_release", "onSurface$delegate", "getPrimary-0d7_KjU", "setPrimary-8_81llA$material_release", "primary$delegate", "getPrimaryVariant-0d7_KjU", "setPrimaryVariant-8_81llA$material_release", "primaryVariant$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material_release", "secondary$delegate", "getSecondaryVariant-0d7_KjU", "setSecondaryVariant-8_81llA$material_release", "secondaryVariant$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material_release", "surface$delegate", "copy", "copy-pvPzIIM", "(JJJJJJJJJJJJZ)Landroidx/compose/material/Colors;", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Colors {
    public static final int $stable = 0;

    /* renamed from: background$delegate, reason: from kotlin metadata */
    private final MutableState background;

    /* renamed from: error$delegate, reason: from kotlin metadata */
    private final MutableState error;

    /* renamed from: isLight$delegate, reason: from kotlin metadata */
    private final MutableState isLight;

    /* renamed from: onBackground$delegate, reason: from kotlin metadata */
    private final MutableState onBackground;

    /* renamed from: onError$delegate, reason: from kotlin metadata */
    private final MutableState onError;

    /* renamed from: onPrimary$delegate, reason: from kotlin metadata */
    private final MutableState onPrimary;

    /* renamed from: onSecondary$delegate, reason: from kotlin metadata */
    private final MutableState onSecondary;

    /* renamed from: onSurface$delegate, reason: from kotlin metadata */
    private final MutableState onSurface;

    /* renamed from: primary$delegate, reason: from kotlin metadata */
    private final MutableState primary;

    /* renamed from: primaryVariant$delegate, reason: from kotlin metadata */
    private final MutableState primaryVariant;

    /* renamed from: secondary$delegate, reason: from kotlin metadata */
    private final MutableState secondary;

    /* renamed from: secondaryVariant$delegate, reason: from kotlin metadata */
    private final MutableState secondaryVariant;

    /* renamed from: surface$delegate, reason: from kotlin metadata */
    private final MutableState surface;

    public /* synthetic */ Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z);
    }

    private Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z) {
        this.primary = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j2), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j3), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j4), SnapshotStateKt.structuralEqualityPolicy());
        this.background = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j5), SnapshotStateKt.structuralEqualityPolicy());
        this.surface = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j6), SnapshotStateKt.structuralEqualityPolicy());
        this.error = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j7), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j8), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j9), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.onError = SnapshotStateKt.mutableStateOf(Color.m4528boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight = SnapshotStateKt.mutableStateOf(Boolean.valueOf(z), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m1799getPrimary0d7_KjU() {
        return ((Color) this.primary.getValue()).m4548unboximpl();
    }

    /* renamed from: setPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m1811setPrimary8_81llA$material_release(long j) {
        this.primary.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m1800getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant.getValue()).m4548unboximpl();
    }

    /* renamed from: setPrimaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m1812setPrimaryVariant8_81llA$material_release(long j) {
        this.primaryVariant.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m1801getSecondary0d7_KjU() {
        return ((Color) this.secondary.getValue()).m4548unboximpl();
    }

    /* renamed from: setSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m1813setSecondary8_81llA$material_release(long j) {
        this.secondary.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m1802getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant.getValue()).m4548unboximpl();
    }

    /* renamed from: setSecondaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m1814setSecondaryVariant8_81llA$material_release(long j) {
        this.secondaryVariant.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m1792getBackground0d7_KjU() {
        return ((Color) this.background.getValue()).m4548unboximpl();
    }

    /* renamed from: setBackground-8_81llA$material_release, reason: not valid java name */
    public final void m1804setBackground8_81llA$material_release(long j) {
        this.background.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m1803getSurface0d7_KjU() {
        return ((Color) this.surface.getValue()).m4548unboximpl();
    }

    /* renamed from: setSurface-8_81llA$material_release, reason: not valid java name */
    public final void m1815setSurface8_81llA$material_release(long j) {
        this.surface.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m1793getError0d7_KjU() {
        return ((Color) this.error.getValue()).m4548unboximpl();
    }

    /* renamed from: setError-8_81llA$material_release, reason: not valid java name */
    public final void m1805setError8_81llA$material_release(long j) {
        this.error.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m1796getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary.getValue()).m4548unboximpl();
    }

    /* renamed from: setOnPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m1808setOnPrimary8_81llA$material_release(long j) {
        this.onPrimary.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m1797getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary.getValue()).m4548unboximpl();
    }

    /* renamed from: setOnSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m1809setOnSecondary8_81llA$material_release(long j) {
        this.onSecondary.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m1794getOnBackground0d7_KjU() {
        return ((Color) this.onBackground.getValue()).m4548unboximpl();
    }

    /* renamed from: setOnBackground-8_81llA$material_release, reason: not valid java name */
    public final void m1806setOnBackground8_81llA$material_release(long j) {
        this.onBackground.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1798getOnSurface0d7_KjU() {
        return ((Color) this.onSurface.getValue()).m4548unboximpl();
    }

    /* renamed from: setOnSurface-8_81llA$material_release, reason: not valid java name */
    public final void m1810setOnSurface8_81llA$material_release(long j) {
        this.onSurface.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m1795getOnError0d7_KjU() {
        return ((Color) this.onError.getValue()).m4548unboximpl();
    }

    /* renamed from: setOnError-8_81llA$material_release, reason: not valid java name */
    public final void m1807setOnError8_81llA$material_release(long j) {
        this.onError.setValue(Color.m4528boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isLight() {
        return ((Boolean) this.isLight.getValue()).booleanValue();
    }

    public final void setLight$material_release(boolean z) {
        this.isLight.setValue(Boolean.valueOf(z));
    }

    /* renamed from: copy-pvPzIIM, reason: not valid java name */
    public final Colors m1791copypvPzIIM(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError, boolean isLight) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, isLight, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Colors(primary=");
        sb.append((Object) Color.m4546toStringimpl(m1799getPrimary0d7_KjU())).append(", primaryVariant=").append((Object) Color.m4546toStringimpl(m1800getPrimaryVariant0d7_KjU())).append(", secondary=").append((Object) Color.m4546toStringimpl(m1801getSecondary0d7_KjU())).append(", secondaryVariant=").append((Object) Color.m4546toStringimpl(m1802getSecondaryVariant0d7_KjU())).append(", background=").append((Object) Color.m4546toStringimpl(m1792getBackground0d7_KjU())).append(", surface=").append((Object) Color.m4546toStringimpl(m1803getSurface0d7_KjU())).append(", error=").append((Object) Color.m4546toStringimpl(m1793getError0d7_KjU())).append(", onPrimary=").append((Object) Color.m4546toStringimpl(m1796getOnPrimary0d7_KjU())).append(", onSecondary=").append((Object) Color.m4546toStringimpl(m1797getOnSecondary0d7_KjU())).append(", onBackground=").append((Object) Color.m4546toStringimpl(m1794getOnBackground0d7_KjU())).append(", onSurface=").append((Object) Color.m4546toStringimpl(m1798getOnSurface0d7_KjU())).append(", onError=");
        sb.append((Object) Color.m4546toStringimpl(m1795getOnError0d7_KjU())).append(", isLight=").append(isLight()).append(')');
        return sb.toString();
    }
}
