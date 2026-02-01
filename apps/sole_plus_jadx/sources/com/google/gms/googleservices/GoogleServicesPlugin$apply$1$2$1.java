package com.google.gms.googleservices;

import com.google.android.gms.dependencies.DependencyInspector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.gradle.api.GradleException;
import org.gradle.api.artifacts.ResolvableDependencies;

/* compiled from: GoogleServicesPlugin.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class GoogleServicesPlugin$apply$1$2$1 extends FunctionReferenceImpl implements Function1<ResolvableDependencies, Unit> {
    GoogleServicesPlugin$apply$1$2$1(Object obj) {
        super(1, obj, DependencyInspector.class, "afterResolve", "afterResolve(Lorg/gradle/api/artifacts/ResolvableDependencies;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ResolvableDependencies resolvableDependencies) throws GradleException {
        invoke2(resolvableDependencies);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ResolvableDependencies resolvableDependencies) throws GradleException {
        ((DependencyInspector) this.receiver).afterResolve(resolvableDependencies);
    }
}
