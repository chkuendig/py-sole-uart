package com.google.gms.googleservices;

import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.android.build.api.variant.AndroidComponentsExtension;
import com.android.build.api.variant.ApplicationAndroidComponentsExtension;
import com.android.build.api.variant.ApplicationVariant;
import com.android.build.api.variant.DynamicFeatureAndroidComponentsExtension;
import com.android.build.api.variant.DynamicFeatureVariant;
import com.android.build.api.variant.GeneratesApk;
import com.android.build.api.variant.SourceDirectories;
import com.android.build.api.variant.Variant;
import com.android.build.api.variant.VariantSelector;
import com.google.android.gms.dependencies.DependencyAnalyzer;
import com.google.android.gms.dependencies.DependencyInspector;
import com.google.gms.googleservices.GoogleServicesPlugin;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.BinaryOperator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ResolvableDependencies;
import org.gradle.api.plugins.AppliedPlugin;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.plugins.PluginManager;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.TaskContainer;
import org.gradle.api.tasks.TaskProvider;
import org.gradle.configurationcache.extensions.CharSequenceExtensionsKt;

/* compiled from: GoogleServicesPlugin.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J+\u0010\u0007\u001a\u00020\u0005\"\f\b\u0000\u0010\b*\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u0002H\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\fJ\f\u0010\r\u001a\u00020\u000e*\u00020\u000eH\u0002¨\u0006\u0012"}, d2 = {"Lcom/google/gms/googleservices/GoogleServicesPlugin;", "Lorg/gradle/api/Plugin;", "Lorg/gradle/api/Project;", "()V", "apply", "", "project", "handleVariant", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/build/api/variant/Variant;", "Lcom/android/build/api/variant/GeneratesApk;", "variant", "(Lcom/android/build/api/variant/Variant;Lorg/gradle/api/Project;)V", SdkConstants.ATTR_CAPITALIZE, "", "Companion", "GoogleServicesPluginConfig", "MissingGoogleServicesStrategy", "google-services-plugin"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class GoogleServicesPlugin implements Plugin<Project> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String JSON_FILE_NAME = "google-services.json";
    public static final String MINIMUM_VERSION = "9.0.0";
    public static final String MODULE_CORE = "firebase-core";
    public static final String MODULE_GROUP = "com.google.android.gms";
    public static final String MODULE_GROUP_FIREBASE = "com.google.firebase";
    public static final String MODULE_VERSION = "11.4.2";
    public static final String SOURCE_TYPE = "google-services";

    /* compiled from: GoogleServicesPlugin.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/gms/googleservices/GoogleServicesPlugin$MissingGoogleServicesStrategy;", "", "(Ljava/lang/String;I)V", "IGNORE", "WARN", "ERROR", "google-services-plugin"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum MissingGoogleServicesStrategy {
        IGNORE,
        WARN,
        ERROR
    }

    /* compiled from: GoogleServicesPlugin.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lorg/gradle/api/Project;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.google.gms.googleservices.GoogleServicesPlugin$apply$1, reason: invalid class name */
    static final class AnonymousClass1 extends Lambda implements Function1<Project, Unit> {
        final /* synthetic */ GoogleServicesPluginConfig $config;
        final /* synthetic */ Project $project;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GoogleServicesPluginConfig googleServicesPluginConfig, Project project) {
            super(1);
            this.$config = googleServicesPluginConfig;
            this.$project = project;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Project project) {
            invoke2(project);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Project project) {
            if (this.$config.getDisableVersionCheck()) {
                return;
            }
            DependencyInspector dependencyInspector = new DependencyInspector(new DependencyAnalyzer(), this.$project.getName(), "This error message came from the google-services Gradle plugin, report issues at https://github.com/google/play-services-plugins and disable by adding \"googleServices { disableVersionCheck = true }\" to your build.gradle file.");
            Iterable configurations = this.$project.getConfigurations();
            Intrinsics.checkNotNullExpressionValue(configurations, "project.configurations");
            ArrayList arrayList = new ArrayList();
            for (Object obj : configurations) {
                String name = ((Configuration) obj).getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                if (StringsKt.contains$default((CharSequence) name, (CharSequence) "ompile", false, 2, (Object) null)) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ResolvableDependencies incoming = ((Configuration) it.next()).getIncoming();
                final GoogleServicesPlugin$apply$1$2$1 googleServicesPlugin$apply$1$2$1 = new GoogleServicesPlugin$apply$1$2$1(dependencyInspector);
                incoming.afterResolve(new Action() { // from class: com.google.gms.googleservices.GoogleServicesPlugin$apply$1$$ExternalSyntheticLambda0
                    public final void execute(Object obj2) {
                        GoogleServicesPlugin.AnonymousClass1.invoke$lambda$2$lambda$1(googleServicesPlugin$apply$1$2$1, obj2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$1(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }
    }

    public void apply(final Project project) {
        Intrinsics.checkNotNullParameter(project, "project");
        final AnonymousClass1 anonymousClass1 = new AnonymousClass1((GoogleServicesPluginConfig) project.getExtensions().create("googleServices", GoogleServicesPluginConfig.class, new Object[0]), project);
        project.afterEvaluate(new Action() { // from class: com.google.gms.googleservices.GoogleServicesPlugin$$ExternalSyntheticLambda0
            public final void execute(Object obj) {
                GoogleServicesPlugin.apply$lambda$0(anonymousClass1, obj);
            }
        });
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        PluginManager pluginManager = project.getPluginManager();
        final AnonymousClass2 anonymousClass2 = new AnonymousClass2(booleanRef, project, this);
        pluginManager.withPlugin("com.android.application", new Action() { // from class: com.google.gms.googleservices.GoogleServicesPlugin$$ExternalSyntheticLambda1
            public final void execute(Object obj) {
                GoogleServicesPlugin.apply$lambda$1(anonymousClass2, obj);
            }
        });
        PluginManager pluginManager2 = project.getPluginManager();
        final AnonymousClass3 anonymousClass3 = new AnonymousClass3(booleanRef, project, this);
        pluginManager2.withPlugin("com.android.dynamic-feature", new Action() { // from class: com.google.gms.googleservices.GoogleServicesPlugin$$ExternalSyntheticLambda2
            public final void execute(Object obj) {
                GoogleServicesPlugin.apply$lambda$2(anonymousClass3, obj);
            }
        });
        final Function1<Project, Unit> function1 = new Function1<Project, Unit>() { // from class: com.google.gms.googleservices.GoogleServicesPlugin.apply.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Project project2) {
                invoke2(project2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Project project2) {
                if (booleanRef.element) {
                    return;
                }
                project.getLogger().error("The google-services Gradle plugin needs to be applied on a project with com.android.application or com.android.dynamic-feature.");
            }
        };
        project.afterEvaluate(new Action() { // from class: com.google.gms.googleservices.GoogleServicesPlugin$$ExternalSyntheticLambda3
            public final void execute(Object obj) {
                GoogleServicesPlugin.apply$lambda$3(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void apply$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* compiled from: GoogleServicesPlugin.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lorg/gradle/api/plugins/AppliedPlugin;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.google.gms.googleservices.GoogleServicesPlugin$apply$2, reason: invalid class name */
    static final class AnonymousClass2 extends Lambda implements Function1<AppliedPlugin, Unit> {
        final /* synthetic */ Ref.BooleanRef $pluginApplied;
        final /* synthetic */ Project $project;
        final /* synthetic */ GoogleServicesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.BooleanRef booleanRef, Project project, GoogleServicesPlugin googleServicesPlugin) {
            super(1);
            this.$pluginApplied = booleanRef;
            this.$project = project;
            this.this$0 = googleServicesPlugin;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AppliedPlugin appliedPlugin) {
            invoke2(appliedPlugin);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppliedPlugin appliedPlugin) {
            this.$pluginApplied.element = true;
            ExtensionContainer extensions = this.$project.getExtensions();
            final GoogleServicesPlugin googleServicesPlugin = this.this$0;
            final Project project = this.$project;
            final Function1<ApplicationAndroidComponentsExtension, Unit> function1 = new Function1<ApplicationAndroidComponentsExtension, Unit>() { // from class: com.google.gms.googleservices.GoogleServicesPlugin.apply.2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ApplicationAndroidComponentsExtension applicationAndroidComponentsExtension) {
                    invoke2(applicationAndroidComponentsExtension);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ApplicationAndroidComponentsExtension it) {
                    it.registerSourceType(GoogleServicesPlugin.SOURCE_TYPE);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    final GoogleServicesPlugin googleServicesPlugin2 = googleServicesPlugin;
                    final Project project2 = project;
                    AndroidComponentsExtension.DefaultImpls.onVariants$default(it, (VariantSelector) null, new Function1<ApplicationVariant, Unit>() { // from class: com.google.gms.googleservices.GoogleServicesPlugin.apply.2.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ApplicationVariant applicationVariant) {
                            invoke2(applicationVariant);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ApplicationVariant variant) {
                            Intrinsics.checkNotNullParameter(variant, "variant");
                            googleServicesPlugin2.handleVariant(variant, project2);
                        }
                    }, 1, (Object) null);
                }
            };
            extensions.configure(ApplicationAndroidComponentsExtension.class, new Action() { // from class: com.google.gms.googleservices.GoogleServicesPlugin$apply$2$$ExternalSyntheticLambda0
                public final void execute(Object obj) {
                    GoogleServicesPlugin.AnonymousClass2.invoke$lambda$0(function1, obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void apply$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* compiled from: GoogleServicesPlugin.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lorg/gradle/api/plugins/AppliedPlugin;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.google.gms.googleservices.GoogleServicesPlugin$apply$3, reason: invalid class name */
    static final class AnonymousClass3 extends Lambda implements Function1<AppliedPlugin, Unit> {
        final /* synthetic */ Ref.BooleanRef $pluginApplied;
        final /* synthetic */ Project $project;
        final /* synthetic */ GoogleServicesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.BooleanRef booleanRef, Project project, GoogleServicesPlugin googleServicesPlugin) {
            super(1);
            this.$pluginApplied = booleanRef;
            this.$project = project;
            this.this$0 = googleServicesPlugin;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AppliedPlugin appliedPlugin) {
            invoke2(appliedPlugin);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppliedPlugin appliedPlugin) {
            this.$pluginApplied.element = true;
            ExtensionContainer extensions = this.$project.getExtensions();
            final GoogleServicesPlugin googleServicesPlugin = this.this$0;
            final Project project = this.$project;
            final Function1<DynamicFeatureAndroidComponentsExtension, Unit> function1 = new Function1<DynamicFeatureAndroidComponentsExtension, Unit>() { // from class: com.google.gms.googleservices.GoogleServicesPlugin.apply.3.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DynamicFeatureAndroidComponentsExtension dynamicFeatureAndroidComponentsExtension) {
                    invoke2(dynamicFeatureAndroidComponentsExtension);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DynamicFeatureAndroidComponentsExtension it) {
                    it.registerSourceType(GoogleServicesPlugin.SOURCE_TYPE);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    final GoogleServicesPlugin googleServicesPlugin2 = googleServicesPlugin;
                    final Project project2 = project;
                    AndroidComponentsExtension.DefaultImpls.onVariants$default(it, (VariantSelector) null, new Function1<DynamicFeatureVariant, Unit>() { // from class: com.google.gms.googleservices.GoogleServicesPlugin.apply.3.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DynamicFeatureVariant dynamicFeatureVariant) {
                            invoke2(dynamicFeatureVariant);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DynamicFeatureVariant variant) {
                            Intrinsics.checkNotNullParameter(variant, "variant");
                            googleServicesPlugin2.handleVariant(variant, project2);
                        }
                    }, 1, (Object) null);
                }
            };
            extensions.configure(DynamicFeatureAndroidComponentsExtension.class, new Action() { // from class: com.google.gms.googleservices.GoogleServicesPlugin$apply$3$$ExternalSyntheticLambda0
                public final void execute(Object obj) {
                    GoogleServicesPlugin.AnonymousClass3.invoke$lambda$0(function1, obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void apply$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void apply$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Variant & GeneratesApk> void handleVariant(final T variant, final Project project) {
        TaskContainer tasks = project.getTasks();
        String str = "process" + capitalize(variant.getName()) + "GoogleServices";
        final Function1<GoogleServicesTask, Unit> function1 = new Function1<GoogleServicesTask, Unit>() { // from class: com.google.gms.googleservices.GoogleServicesPlugin$handleVariant$jsonToXmlTask$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lorg/gradle/api/Project;TT;)V */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GoogleServicesTask googleServicesTask) {
                invoke2(googleServicesTask);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GoogleServicesTask googleServicesTask) {
                googleServicesTask.getMissingGoogleServicesStrategy().set(((GoogleServicesPlugin.GoogleServicesPluginConfig) project.getExtensions().getByType(GoogleServicesPlugin.GoogleServicesPluginConfig.class)).getMissingGoogleServicesStrategy());
                Property<Collection<File>> googleServicesJsonFiles = googleServicesTask.getGoogleServicesJsonFiles();
                GoogleServicesPlugin.Companion companion = GoogleServicesPlugin.INSTANCE;
                String buildType = variant.getBuildType();
                if (buildType == null) {
                    buildType = "";
                }
                List<Pair<String, String>> productFlavors = variant.getProductFlavors();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(productFlavors, 10));
                Iterator<T> it = productFlavors.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).getSecond());
                }
                File projectDir = project.getProjectDir();
                Intrinsics.checkNotNullExpressionValue(projectDir, "project.projectDir");
                googleServicesJsonFiles.set(companion.getJsonFiles(buildType, arrayList, projectDir));
                googleServicesTask.getApplicationId().set(((GeneratesApk) variant).getApplicationId());
                Property<File> gmpAppId = googleServicesTask.getGmpAppId();
                File buildDir = project.getBuildDir();
                Intrinsics.checkNotNullExpressionValue(buildDir, "project.buildDir");
                gmpAppId.set(FilesKt.resolve(buildDir, "gmpAppId.txt"));
            }
        };
        TaskProvider jsonToXmlTask = tasks.register(str, GoogleServicesTask.class, new Action() { // from class: com.google.gms.googleservices.GoogleServicesPlugin$$ExternalSyntheticLambda4
            public final void execute(Object obj) {
                GoogleServicesPlugin.handleVariant$lambda$4(function1, obj);
            }
        });
        try {
            variant.getSources().getByName(SOURCE_TYPE).addStaticSourceDirectory(project.getLayout().getProjectDirectory().dir("src/" + variant.getName() + "/google-services").toString());
        } catch (IllegalArgumentException unused) {
        }
        SourceDirectories.Layered res = variant.getSources().getRes();
        if (res != null) {
            Intrinsics.checkNotNullExpressionValue(jsonToXmlTask, "jsonToXmlTask");
            res.addGeneratedSourceDirectory(jsonToXmlTask, new PropertyReference1Impl() { // from class: com.google.gms.googleservices.GoogleServicesPlugin.handleVariant.1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((GoogleServicesTask) obj).getOutputDirectory();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleVariant$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final String capitalize(String str) {
        String strValueOf;
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            strValueOf = CharsKt.titlecase(cCharAt, locale);
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        StringBuilder sbAppend = sb.append((Object) strValueOf);
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return sbAppend.append(strSubstring).toString();
    }

    /* compiled from: GoogleServicesPlugin.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0010\u001a\u00020\rJ\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/google/gms/googleservices/GoogleServicesPlugin$Companion;", "", "()V", "JSON_FILE_NAME", "", "MINIMUM_VERSION", "MODULE_CORE", "MODULE_GROUP", "MODULE_GROUP_FIREBASE", "MODULE_VERSION", "SOURCE_TYPE", "getJsonFiles", "", "Ljava/io/File;", "buildType", "flavorNames", "root", "getJsonLocations", "google-services-plugin"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<File> getJsonFiles(String buildType, List<String> flavorNames, File root) {
            Intrinsics.checkNotNullParameter(buildType, "buildType");
            Intrinsics.checkNotNullParameter(flavorNames, "flavorNames");
            Intrinsics.checkNotNullParameter(root, "root");
            List<String> jsonLocations = getJsonLocations(buildType, flavorNames);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonLocations, 10));
            Iterator<T> it = jsonLocations.iterator();
            while (it.hasNext()) {
                arrayList.add(FilesKt.resolve(root, (String) it.next()));
            }
            return arrayList;
        }

        public final List<String> getJsonLocations(String buildType, List<String> flavorNames) {
            StringBuilder sbAppend;
            String str;
            Intrinsics.checkNotNullParameter(buildType, "buildType");
            Intrinsics.checkNotNullParameter(flavorNames, "flavorNames");
            ArrayList arrayList = new ArrayList();
            String strReduce = flavorNames.stream().reduce("", new BinaryOperator() { // from class: com.google.gms.googleservices.GoogleServicesPlugin$Companion$$ExternalSyntheticLambda0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return GoogleServicesPlugin.Companion.getJsonLocations$lambda$1((String) obj, (String) obj2);
                }
            });
            arrayList.add("");
            arrayList.add("src/" + strReduce + "/" + buildType);
            arrayList.add("src/" + buildType + "/" + strReduce);
            arrayList.add("src/" + strReduce);
            arrayList.add("src/" + buildType);
            String str2 = buildType;
            arrayList.add("src/" + strReduce + CharSequenceExtensionsKt.capitalized(str2));
            arrayList.add("src/" + buildType);
            Iterator<String> it = flavorNames.iterator();
            String str3 = "src";
            while (it.hasNext()) {
                str3 = str3 + "/" + it.next();
                arrayList.add(str3);
                arrayList.add(str3 + "/" + buildType);
                arrayList.add(str3 + CharSequenceExtensionsKt.capitalized(str2));
            }
            List<String> listSortedWith = CollectionsKt.sortedWith(CollectionsKt.distinct(arrayList), new Comparator() { // from class: com.google.gms.googleservices.GoogleServicesPlugin$Companion$getJsonLocations$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String str4 = (String) t2;
                    int i = 0;
                    for (int i2 = 0; i2 < str4.length(); i2++) {
                        if (str4.charAt(i2) == '/') {
                            i++;
                        }
                    }
                    Integer numValueOf = Integer.valueOf(i);
                    String str5 = (String) t;
                    int i3 = 0;
                    for (int i4 = 0; i4 < str5.length(); i4++) {
                        if (str5.charAt(i4) == '/') {
                            i3++;
                        }
                    }
                    return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i3));
                }
            });
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
            for (String str4 : listSortedWith) {
                if (str4.length() == 0) {
                    sbAppend = new StringBuilder().append(str4);
                    str = "google-services.json";
                } else {
                    sbAppend = new StringBuilder().append(str4);
                    str = "/google-services.json";
                }
                arrayList2.add(sbAppend.append(str).toString());
            }
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String getJsonLocations$lambda$1(String a, String b) {
            Intrinsics.checkNotNullExpressionValue(a, "a");
            if (a.length() != 0) {
                Intrinsics.checkNotNullExpressionValue(b, "b");
                b = CharSequenceExtensionsKt.capitalized(b);
            }
            return a + b;
        }
    }

    /* compiled from: GoogleServicesPlugin.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/google/gms/googleservices/GoogleServicesPlugin$GoogleServicesPluginConfig;", "", "()V", "disableVersionCheck", "", "getDisableVersionCheck", "()Z", "setDisableVersionCheck", "(Z)V", "missingGoogleServicesStrategy", "Lcom/google/gms/googleservices/GoogleServicesPlugin$MissingGoogleServicesStrategy;", "getMissingGoogleServicesStrategy", "()Lcom/google/gms/googleservices/GoogleServicesPlugin$MissingGoogleServicesStrategy;", "setMissingGoogleServicesStrategy", "(Lcom/google/gms/googleservices/GoogleServicesPlugin$MissingGoogleServicesStrategy;)V", "google-services-plugin"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class GoogleServicesPluginConfig {
        private boolean disableVersionCheck;
        private MissingGoogleServicesStrategy missingGoogleServicesStrategy = MissingGoogleServicesStrategy.ERROR;

        public final boolean getDisableVersionCheck() {
            return this.disableVersionCheck;
        }

        public final void setDisableVersionCheck(boolean z) {
            this.disableVersionCheck = z;
        }

        public final MissingGoogleServicesStrategy getMissingGoogleServicesStrategy() {
            return this.missingGoogleServicesStrategy;
        }

        public final void setMissingGoogleServicesStrategy(MissingGoogleServicesStrategy missingGoogleServicesStrategy) {
            Intrinsics.checkNotNullParameter(missingGoogleServicesStrategy, "<set-?>");
            this.missingGoogleServicesStrategy = missingGoogleServicesStrategy;
        }
    }
}
