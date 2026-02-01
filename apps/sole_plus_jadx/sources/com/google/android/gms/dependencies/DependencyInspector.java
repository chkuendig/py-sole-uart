package com.google.android.gms.dependencies;

import com.android.SdkConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.gradle.api.GradleException;
import org.gradle.api.artifacts.DependencyResolutionListener;
import org.gradle.api.artifacts.ResolvableDependencies;
import org.gradle.api.artifacts.result.ResolutionResult;
import org.gradle.api.artifacts.result.ResolvedComponentResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public class DependencyInspector implements DependencyResolutionListener {
    private static final String GRADLE_PROJECT = "gradle.project";
    private static Logger logger = LoggerFactory.getLogger((Class<?>) DependencyInspector.class);
    private final DependencyAnalyzer dependencyAnalyzer;
    private final String exceptionMessageAddendum;
    private final String projectName;

    public void beforeResolve(ResolvableDependencies resolvableDependencies) {
    }

    public DependencyInspector(@Nonnull DependencyAnalyzer dependencyAnalyzer, @Nonnull String str, @Nullable String str2) {
        this.dependencyAnalyzer = dependencyAnalyzer;
        this.exceptionMessageAddendum = str2;
        this.projectName = str;
    }

    private static String simplifyKnownGroupIds(@Nonnull String str) {
        return str.replace("com.google.android.gms", "c.g.a.g").replace("com.google.firebase", "c.g.f");
    }

    private static void printNode(int i, @Nonnull Node node) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("--");
        }
        sb.append(" ");
        Dependency dependency = node.getDependency();
        if (GRADLE_PROJECT.equals(node.getDependency().getFromArtifactVersion().getGroupId())) {
            logger.info(sb.toString() + dependency.getFromArtifactVersion().getGradleRef().replace(GRADLE_PROJECT, "") + " task/module dep -> " + simplifyKnownGroupIds(dependency.getToArtifact().getGradleRef()) + SdkConstants.PREFIX_RESOURCE_REF + dependency.getToArtifactVersionString());
        } else {
            logger.info(sb.toString() + simplifyKnownGroupIds(dependency.getFromArtifactVersion().getGradleRef()) + " library depends -> " + simplifyKnownGroupIds(dependency.getToArtifact().getGradleRef()) + SdkConstants.PREFIX_RESOURCE_REF + dependency.getToArtifactVersionString());
        }
        if (node.getChild() != null) {
            printNode(i + 1, node.getChild());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x000c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void registerDependencies(@javax.annotation.Nonnull org.gradle.api.artifacts.ResolvableDependencies r10, @javax.annotation.Nonnull java.lang.String r11, @javax.annotation.Nonnull java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dependencies.DependencyInspector.registerDependencies(org.gradle.api.artifacts.ResolvableDependencies, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.gradle.api.GradleException */
    public void afterResolve(ResolvableDependencies resolvableDependencies) throws GradleException {
        String name = resolvableDependencies.getName();
        logger.info("Registered task dependencies: " + this.projectName + ":" + name);
        if (resolvableDependencies.getResolutionResult() != null && resolvableDependencies.getResolutionResult().getAllDependencies() != null) {
            registerDependencies(resolvableDependencies, this.projectName, name);
        }
        logger.info("Starting dependency analysis");
        ResolutionResult resolutionResult = resolvableDependencies.getResolutionResult();
        HashMap map = new HashMap();
        Iterator it = resolutionResult.getAllComponents().iterator();
        while (it.hasNext()) {
            ArtifactVersion artifactVersionFromGradleRefOrNull = ArtifactVersion.INSTANCE.fromGradleRefOrNull(((ResolvedComponentResult) it.next()).getId().toString());
            if (artifactVersionFromGradleRefOrNull != null) {
                map.put(artifactVersionFromGradleRefOrNull.getArtifact(), artifactVersionFromGradleRefOrNull);
            }
        }
        if (map.size() < 1) {
            return;
        }
        for (Dependency dependency : this.dependencyAnalyzer.getActiveDependencies(map.values())) {
            ArtifactVersion artifactVersion = (ArtifactVersion) map.get(dependency.getToArtifact());
            if (!dependency.isVersionCompatible(artifactVersion.getVersion())) {
                logger.warn("Dependency resolved to an incompatible version: " + dependency);
                Collection<Node> paths = this.dependencyAnalyzer.getPaths(artifactVersion.getArtifact());
                logger.info("Dependency Resolution Help: Displaying all currently known paths to any version of the dependency: " + dependency.getToArtifact());
                logger.info("NOTE: com.google.android.gms translated to c.g.a.g for brevity. Same for com.google.firebase -> c.g.f");
                Iterator<Node> it2 = paths.iterator();
                while (it2.hasNext()) {
                    printNode(1, it2.next());
                }
                throw new GradleException(getErrorMessage(dependency, artifactVersion, paths));
            }
        }
    }

    private String getErrorMessage(@Nonnull Dependency dependency, @Nonnull ArtifactVersion artifactVersion, @Nonnull Collection<Node> collection) {
        StringBuilder sbAppend = new StringBuilder("In project '").append(this.projectName).append("' a resolved Google Play services library dependency depends on another at an exact version (e.g. \"").append(dependency.getToArtifactVersionString()).append("\", but isn't being resolved to that version. Behavior exhibited by the library will be unknown.").append(System.lineSeparator()).append(System.lineSeparator()).append("Dependency failing: ").append(dependency.getDisplayString()).append(", but ").append(dependency.getToArtifact().getArtifactId()).append(" version was ").append(artifactVersion.getVersion()).append(".").append(System.lineSeparator()).append(System.lineSeparator()).append("The following dependencies are project dependencies that are direct or have transitive dependencies that lead to the artifact with the issue.");
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Node node : collection) {
            String[] strArrSplit = node.getDependency().getFromArtifactVersion().getArtifactId().split(SdkConstants.RES_QUALIFIER_SEP);
            if (strArrSplit[0].equals(strArrSplit[2])) {
                sb.append("-- Project '").append(strArrSplit[0]).append("' depends onto ");
            } else {
                sb.append("-- Project '").append(strArrSplit[0]).append("' depends on project '").append(strArrSplit[2]).append("' which depends onto ");
            }
            sb.append(node.getDependency().getToArtifact().getGroupId()).append(":").append(node.getDependency().getToArtifact().getArtifactId()).append(SdkConstants.PREFIX_RESOURCE_REF).append(node.getDependency().getToArtifactVersionString());
            hashSet.add(sb.toString());
            sb.delete(0, sb.length());
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            sbAppend.append(System.lineSeparator()).append((String) it.next());
        }
        sbAppend.append(System.lineSeparator()).append(System.lineSeparator()).append("For extended debugging info execute Gradle from the command line with ./gradlew --info :").append(this.projectName).append(":assembleDebug to see the dependency paths to the artifact. ");
        String str = this.exceptionMessageAddendum;
        if (str != null && !"".equals(str.trim())) {
            sbAppend.append(this.exceptionMessageAddendum);
        }
        return sbAppend.toString().replaceAll(".{120}(?=.)", "$0" + System.lineSeparator());
    }
}
