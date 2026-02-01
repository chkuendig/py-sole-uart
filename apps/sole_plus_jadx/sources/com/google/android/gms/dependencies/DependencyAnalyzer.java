package com.google.android.gms.dependencies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import javax.annotation.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public class DependencyAnalyzer {
    private Logger logger = LoggerFactory.getLogger((Class<?>) DependencyAnalyzer.class);
    private ArtifactDependencyManager dependencyManager = new ArtifactDependencyManager();

    synchronized void registerDependency(@Nonnull Dependency dependency) {
        this.dependencyManager.addDependency(dependency);
    }

    @Nonnull
    synchronized Collection<Dependency> getActiveDependencies(Collection<ArtifactVersion> collection) {
        ArrayList arrayList;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (ArtifactVersion artifactVersion : collection) {
            hashSet.add(artifactVersion.getArtifact());
            hashSet2.add(artifactVersion);
        }
        arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            for (Dependency dependency : this.dependencyManager.getDependencies((Artifact) it.next())) {
                if (hashSet2.contains(dependency.getFromArtifactVersion()) && hashSet.contains(dependency.getToArtifact())) {
                    arrayList.add(dependency);
                }
            }
        }
        return arrayList;
    }

    synchronized Collection<Node> getPaths(Artifact artifact) {
        ArrayList<Node> arrayList;
        arrayList = new ArrayList<>();
        for (Dependency dependency : this.dependencyManager.getDependencies(artifact)) {
            getNode(arrayList, new Node(null, dependency), dependency.getFromArtifactVersion());
        }
        return arrayList;
    }

    private synchronized void getNode(ArrayList<Node> arrayList, Node node, ArtifactVersion artifactVersion) {
        Collection<Dependency> dependencies = this.dependencyManager.getDependencies(artifactVersion.getArtifact());
        if (dependencies.size() < 1) {
            arrayList.add(node);
            return;
        }
        for (Dependency dependency : dependencies) {
            if (dependency.isVersionCompatible(artifactVersion.getVersion())) {
                getNode(arrayList, new Node(node, dependency), dependency.getFromArtifactVersion());
            }
        }
    }
}
