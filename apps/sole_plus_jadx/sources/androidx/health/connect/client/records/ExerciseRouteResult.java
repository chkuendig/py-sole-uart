package androidx.health.connect.client.records;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExerciseRouteResult.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0000¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRouteResult;", "", "()V", "ConsentRequired", "Data", "NoData", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ExerciseRouteResult {

    /* compiled from: ExerciseRouteResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRouteResult$Data;", "Landroidx/health/connect/client/records/ExerciseRouteResult;", "exerciseRoute", "Landroidx/health/connect/client/records/ExerciseRoute;", "(Landroidx/health/connect/client/records/ExerciseRoute;)V", "getExerciseRoute", "()Landroidx/health/connect/client/records/ExerciseRoute;", "equals", "", "other", "", "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Data extends ExerciseRouteResult {
        private final ExerciseRoute exerciseRoute;

        public int hashCode() {
            return 0;
        }

        public Data(ExerciseRoute exerciseRoute) {
            Intrinsics.checkNotNullParameter(exerciseRoute, "exerciseRoute");
            this.exerciseRoute = exerciseRoute;
        }

        public final ExerciseRoute getExerciseRoute() {
            return this.exerciseRoute;
        }

        public boolean equals(Object other) {
            if (other instanceof Data) {
                return Intrinsics.areEqual(this.exerciseRoute, ((Data) other).exerciseRoute);
            }
            return false;
        }

        public String toString() {
            return "Data(exerciseRoute=" + this.exerciseRoute + ')';
        }
    }

    /* compiled from: ExerciseRouteResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRouteResult$ConsentRequired;", "Landroidx/health/connect/client/records/ExerciseRouteResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ConsentRequired extends ExerciseRouteResult {
        public int hashCode() {
            return 0;
        }

        public boolean equals(Object other) {
            return other instanceof ConsentRequired;
        }

        public String toString() {
            return "ConsentRequired";
        }
    }

    /* compiled from: ExerciseRouteResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRouteResult$NoData;", "Landroidx/health/connect/client/records/ExerciseRouteResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NoData extends ExerciseRouteResult {
        public int hashCode() {
            return 0;
        }

        public boolean equals(Object other) {
            return other instanceof NoData;
        }

        public String toString() {
            return "NoData";
        }
    }
}
