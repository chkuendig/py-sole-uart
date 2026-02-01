package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import com.android.SdkConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternalPointerInput.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b*\u0010\u0018J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u0010\u0010,\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b-\u0010\u0018J\u0010\u0010.\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b/\u0010\u0018J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\u0010\u00102\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b3\u0010\"J\t\u00104\u001a\u00020\nHÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\u0010\u00106\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b7\u0010\u0018J\u0010\u00108\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b9\u0010\u0018J\u0084\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b;\u0010<J\u0013\u0010=\u001a\u00020\n2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020BHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\b\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u00020\u000e¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0013\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b'\u0010\u0018R\u0013\u0010\u0014\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b(\u0010\u0018¨\u0006C"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventData;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "position", "down", "", "pressure", "", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "activeHover", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "scrollDelta", "originalEventPosition", SdkConstants.CONSTRUCTOR_NAME, "(JJJJZFIZLjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-J3iCeTQ", "()J", "J", "getUptime", "getPositionOnScreen-F1C5BW0", "getPosition-F1C5BW0", "getDown", "()Z", "getPressure", "()F", "getType-T8wyACA", "()I", "I", "getActiveHover", "getHistorical", "()Ljava/util/List;", "getScrollDelta-F1C5BW0", "getOriginalEventPosition-F1C5BW0", "component1", "component1-J3iCeTQ", "component2", "component3", "component3-F1C5BW0", "component4", "component4-F1C5BW0", "component5", "component6", "component7", "component7-T8wyACA", "component8", "component9", "component10", "component10-F1C5BW0", "component11", "component11-F1C5BW0", "copy", "copy-rc8HELY", "(JJJJZFIZLjava/util/List;JJ)Landroidx/compose/ui/input/pointer/PointerInputEventData;", "equals", "other", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PointerInputEventData {
    public static final int $stable = 8;
    private final boolean activeHover;
    private final boolean down;
    private final List<HistoricalChange> historical;
    private final long id;
    private final long originalEventPosition;
    private final long position;
    private final long positionOnScreen;
    private final float pressure;
    private final long scrollDelta;
    private final int type;
    private final long uptime;

    public /* synthetic */ PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List list, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, z, f, i, z2, list, j5, j6);
    }

    /* renamed from: component1-J3iCeTQ, reason: not valid java name and from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10-F1C5BW0, reason: not valid java name and from getter */
    public final long getScrollDelta() {
        return this.scrollDelta;
    }

    /* renamed from: component11-F1C5BW0, reason: not valid java name and from getter */
    public final long getOriginalEventPosition() {
        return this.originalEventPosition;
    }

    /* renamed from: component2, reason: from getter */
    public final long getUptime() {
        return this.uptime;
    }

    /* renamed from: component3-F1C5BW0, reason: not valid java name and from getter */
    public final long getPositionOnScreen() {
        return this.positionOnScreen;
    }

    /* renamed from: component4-F1C5BW0, reason: not valid java name and from getter */
    public final long getPosition() {
        return this.position;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getDown() {
        return this.down;
    }

    /* renamed from: component6, reason: from getter */
    public final float getPressure() {
        return this.pressure;
    }

    /* renamed from: component7-T8wyACA, reason: not valid java name and from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getActiveHover() {
        return this.activeHover;
    }

    public final List<HistoricalChange> component9() {
        return this.historical;
    }

    /* renamed from: copy-rc8HELY, reason: not valid java name */
    public final PointerInputEventData m5842copyrc8HELY(long id2, long uptime, long positionOnScreen, long position, boolean down, float pressure, int type, boolean activeHover, List<HistoricalChange> historical, long scrollDelta, long originalEventPosition) {
        return new PointerInputEventData(id2, uptime, positionOnScreen, position, down, pressure, type, activeHover, historical, scrollDelta, originalEventPosition, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PointerInputEventData)) {
            return false;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) other;
        return PointerId.m5811equalsimpl0(this.id, pointerInputEventData.id) && this.uptime == pointerInputEventData.uptime && Offset.m4291equalsimpl0(this.positionOnScreen, pointerInputEventData.positionOnScreen) && Offset.m4291equalsimpl0(this.position, pointerInputEventData.position) && this.down == pointerInputEventData.down && Float.compare(this.pressure, pointerInputEventData.pressure) == 0 && PointerType.m5900equalsimpl0(this.type, pointerInputEventData.type) && this.activeHover == pointerInputEventData.activeHover && Intrinsics.areEqual(this.historical, pointerInputEventData.historical) && Offset.m4291equalsimpl0(this.scrollDelta, pointerInputEventData.scrollDelta) && Offset.m4291equalsimpl0(this.originalEventPosition, pointerInputEventData.originalEventPosition);
    }

    public int hashCode() {
        return (((((((((((((((((((PointerId.m5812hashCodeimpl(this.id) * 31) + Long.hashCode(this.uptime)) * 31) + Offset.m4296hashCodeimpl(this.positionOnScreen)) * 31) + Offset.m4296hashCodeimpl(this.position)) * 31) + Boolean.hashCode(this.down)) * 31) + Float.hashCode(this.pressure)) * 31) + PointerType.m5901hashCodeimpl(this.type)) * 31) + Boolean.hashCode(this.activeHover)) * 31) + this.historical.hashCode()) * 31) + Offset.m4296hashCodeimpl(this.scrollDelta)) * 31) + Offset.m4296hashCodeimpl(this.originalEventPosition);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PointerInputEventData(id=");
        sb.append((Object) PointerId.m5813toStringimpl(this.id)).append(", uptime=").append(this.uptime).append(", positionOnScreen=").append((Object) Offset.m4302toStringimpl(this.positionOnScreen)).append(", position=").append((Object) Offset.m4302toStringimpl(this.position)).append(", down=").append(this.down).append(", pressure=").append(this.pressure).append(", type=").append((Object) PointerType.m5902toStringimpl(this.type)).append(", activeHover=").append(this.activeHover).append(", historical=").append(this.historical).append(", scrollDelta=").append((Object) Offset.m4302toStringimpl(this.scrollDelta)).append(", originalEventPosition=").append((Object) Offset.m4302toStringimpl(this.originalEventPosition)).append(')');
        return sb.toString();
    }

    private PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List<HistoricalChange> list, long j5, long j6) {
        this.id = j;
        this.uptime = j2;
        this.positionOnScreen = j3;
        this.position = j4;
        this.down = z;
        this.pressure = f;
        this.type = i;
        this.activeHover = z2;
        this.historical = list;
        this.scrollDelta = j5;
        this.originalEventPosition = j6;
    }

    /* renamed from: getId-J3iCeTQ, reason: not valid java name */
    public final long m5843getIdJ3iCeTQ() {
        return this.id;
    }

    public final long getUptime() {
        return this.uptime;
    }

    /* renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
    public final long m5846getPositionOnScreenF1C5BW0() {
        return this.positionOnScreen;
    }

    /* renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m5845getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getDown() {
        return this.down;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* renamed from: getType-T8wyACA, reason: not valid java name */
    public final int m5848getTypeT8wyACA() {
        return this.type;
    }

    public final boolean getActiveHover() {
        return this.activeHover;
    }

    public /* synthetic */ PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List list, long j5, long j6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, z, f, i, (i2 & 128) != 0 ? false : z2, (i2 & 256) != 0 ? new ArrayList() : list, (i2 & 512) != 0 ? Offset.INSTANCE.m4310getZeroF1C5BW0() : j5, (i2 & 1024) != 0 ? Offset.INSTANCE.m4310getZeroF1C5BW0() : j6, null);
    }

    public final List<HistoricalChange> getHistorical() {
        return this.historical;
    }

    /* renamed from: getScrollDelta-F1C5BW0, reason: not valid java name */
    public final long m5847getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* renamed from: getOriginalEventPosition-F1C5BW0, reason: not valid java name */
    public final long m5844getOriginalEventPositionF1C5BW0() {
        return this.originalEventPosition;
    }
}
