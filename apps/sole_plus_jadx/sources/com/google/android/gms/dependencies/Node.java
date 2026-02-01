package com.google.android.gms.dependencies;

import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataObjects.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/google/android/gms/dependencies/Node;", "", "child", SdkConstants.PreferenceAttributes.ATTR_DEPENDENCY, "Lcom/google/android/gms/dependencies/Dependency;", "(Lcom/google/android/gms/dependencies/Node;Lcom/google/android/gms/dependencies/Dependency;)V", "getChild", "()Lcom/google/android/gms/dependencies/Node;", "getDependency", "()Lcom/google/android/gms/dependencies/Dependency;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "strict-version-matcher-plugin"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final /* data */ class Node {
    private final Node child;
    private final Dependency dependency;

    public static /* synthetic */ Node copy$default(Node node, Node node2, Dependency dependency, int i, Object obj) {
        if ((i & 1) != 0) {
            node2 = node.child;
        }
        if ((i & 2) != 0) {
            dependency = node.dependency;
        }
        return node.copy(node2, dependency);
    }

    /* renamed from: component1, reason: from getter */
    public final Node getChild() {
        return this.child;
    }

    /* renamed from: component2, reason: from getter */
    public final Dependency getDependency() {
        return this.dependency;
    }

    public final Node copy(Node child, Dependency dependency) {
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        return new Node(child, dependency);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Node)) {
            return false;
        }
        Node node = (Node) other;
        return Intrinsics.areEqual(this.child, node.child) && Intrinsics.areEqual(this.dependency, node.dependency);
    }

    public int hashCode() {
        Node node = this.child;
        int iHashCode = (node != null ? node.hashCode() : 0) * 31;
        Dependency dependency = this.dependency;
        return iHashCode + (dependency != null ? dependency.hashCode() : 0);
    }

    public String toString() {
        return "Node(child=" + this.child + ", dependency=" + this.dependency + ")";
    }

    public Node(Node node, Dependency dependency) {
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        this.child = node;
        this.dependency = dependency;
    }

    public final Node getChild() {
        return this.child;
    }

    public final Dependency getDependency() {
        return this.dependency;
    }
}
