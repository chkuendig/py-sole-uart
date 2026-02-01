package com.google.firebase.remoteconfig.interop.rollouts;

import com.android.SdkConstants;
import java.util.Set;

/* loaded from: classes5.dex */
final class AutoValue_RolloutsState extends RolloutsState {
    private final Set<RolloutAssignment> rolloutAssignments;

    AutoValue_RolloutsState(Set<RolloutAssignment> set) {
        if (set == null) {
            throw new NullPointerException("Null rolloutAssignments");
        }
        this.rolloutAssignments = set;
    }

    @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutsState
    public Set<RolloutAssignment> getRolloutAssignments() {
        return this.rolloutAssignments;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.rolloutAssignments + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RolloutsState) {
            return this.rolloutAssignments.equals(((RolloutsState) obj).getRolloutAssignments());
        }
        return false;
    }

    public int hashCode() {
        return this.rolloutAssignments.hashCode() ^ 1000003;
    }
}
