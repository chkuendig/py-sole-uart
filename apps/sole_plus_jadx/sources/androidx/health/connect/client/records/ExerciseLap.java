package androidx.health.connect.client.records;

import androidx.camera.video.AudioStats;
import androidx.health.connect.client.units.Length;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExerciseLap.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0014"}, d2 = {"Landroidx/health/connect/client/records/ExerciseLap;", "", "startTime", "Ljava/time/Instant;", SDKConstants.PARAM_END_TIME, SessionDescription.ATTR_LENGTH, "Landroidx/health/connect/client/units/Length;", "(Ljava/time/Instant;Ljava/time/Instant;Landroidx/health/connect/client/units/Length;)V", "getEndTime", "()Ljava/time/Instant;", "getLength", "()Landroidx/health/connect/client/units/Length;", "getStartTime", "equals", "", "other", "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExerciseLap {
    private final Instant endTime;
    private final Length length;
    private final Instant startTime;

    public ExerciseLap(Instant startTime, Instant endTime, Length length) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        this.startTime = startTime;
        this.endTime = endTime;
        this.length = length;
        if (!startTime.isBefore(endTime)) {
            throw new IllegalArgumentException("startTime must be before endTime.".toString());
        }
        if (length != null) {
            double meters = length.getMeters();
            if (AudioStats.AUDIO_AMPLITUDE_NONE > meters || meters > 1000000.0d) {
                throw new IllegalArgumentException("length valid range: 0-1000000.".toString());
            }
        }
    }

    public /* synthetic */ ExerciseLap(Instant instant, Instant instant2, Length length, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, instant2, (i & 4) != 0 ? null : length);
    }

    public final Instant getStartTime() {
        return this.startTime;
    }

    public final Instant getEndTime() {
        return this.endTime;
    }

    public final Length getLength() {
        return this.length;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExerciseLap)) {
            return false;
        }
        ExerciseLap exerciseLap = (ExerciseLap) other;
        return Intrinsics.areEqual(this.startTime, exerciseLap.startTime) && Intrinsics.areEqual(this.endTime, exerciseLap.endTime) && Intrinsics.areEqual(this.length, exerciseLap.length);
    }

    public int hashCode() {
        int iHashCode = ((this.startTime.hashCode() * 31) + this.endTime.hashCode()) * 31;
        Length length = this.length;
        return iHashCode + (length != null ? length.hashCode() : 0);
    }

    public String toString() {
        return "ExerciseLap(startTime=" + this.startTime + ", endTime=" + this.endTime + ", length=" + this.length + ')';
    }
}
