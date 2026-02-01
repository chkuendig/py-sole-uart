package com.google.android.gms;

import com.google.android.gms.dependencies.DependencyAnalyzer;
import com.google.android.gms.dependencies.DependencyInspector;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.gradle.api.Action;
import org.gradle.api.GradleException;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ResolvableDependencies;

/* loaded from: classes4.dex */
public class StrictVersionMatcherPlugin implements Plugin<Project> {
    private static DependencyAnalyzer globalDependencies = new DependencyAnalyzer();

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.gradle.api.GradleException */
    static /* synthetic */ void lambda$apply$0(ResolvableDependencies resolvableDependencies) throws GradleException {
        throw new GradleException("test");
    }

    public void apply(@Nonnull Project project) {
        new Action() { // from class: com.google.android.gms.StrictVersionMatcherPlugin$$ExternalSyntheticLambda1
            public final void execute(Object obj) throws GradleException {
                StrictVersionMatcherPlugin.lambda$apply$0((ResolvableDependencies) obj);
            }
        };
        final DependencyInspector dependencyInspector = new DependencyInspector(globalDependencies, project.getName(), "This error message came from the strict-version-matcher-plugin Gradle plugin, report issues at https://github.com/google/play-services-plugins and disable by removing the reference to the plugin (\"apply 'strict-version-matcher-plugin'\") from build.gradle.");
        project.getConfigurations().all(new Action() { // from class: com.google.android.gms.StrictVersionMatcherPlugin$$ExternalSyntheticLambda2
            public final void execute(Object obj) {
                StrictVersionMatcherPlugin.lambda$apply$1(dependencyInspector, (Configuration) obj);
            }
        });
    }

    static /* synthetic */ void lambda$apply$1(final DependencyInspector dependencyInspector, Configuration configuration) {
        if (configuration.getName().contains("ompile")) {
            ResolvableDependencies incoming = configuration.getIncoming();
            Objects.requireNonNull(dependencyInspector);
            incoming.afterResolve(new Action() { // from class: com.google.android.gms.StrictVersionMatcherPlugin$$ExternalSyntheticLambda0
                public final void execute(Object obj) throws GradleException {
                    dependencyInspector.afterResolve((ResolvableDependencies) obj);
                }
            });
        }
    }
}
