package io.ktor.client;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.KtorDsl;
import io.ktor.util.PlatformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClientConfig.kt */
@KtorDsl
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u001f\u0010$\u001a\u00020\n2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u0012J\u000e\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\tJI\u0010&\u001a\u00020\n\"\b\b\u0001\u0010(*\u00020\u0003\"\b\b\u0002\u0010)*\u00020\u00032\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H)0+2\u0019\b\u0002\u0010,\u001a\u0013\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u0012J'\u0010&\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00072\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u0012J\u0019\u0010.\u001a\u00020\n2\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0086\u0002R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R/\u0010\u001d\u001a#\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u00120\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010¨\u00060"}, d2 = {"Lio/ktor/client/HttpClientConfig;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/engine/HttpClientEngineConfig;", "", "()V", "customInterceptors", "", "", "Lkotlin/Function1;", "Lio/ktor/client/HttpClient;", "", "developmentMode", "", "getDevelopmentMode", "()Z", "setDevelopmentMode", "(Z)V", "engineConfig", "Lkotlin/ExtensionFunctionType;", "getEngineConfig$ktor_client_core", "()Lkotlin/jvm/functions/Function1;", "setEngineConfig$ktor_client_core", "(Lkotlin/jvm/functions/Function1;)V", "expectSuccess", "getExpectSuccess", "setExpectSuccess", "followRedirects", "getFollowRedirects", "setFollowRedirects", "pluginConfigurations", "Lio/ktor/util/AttributeKey;", "plugins", "useDefaultTransformers", "getUseDefaultTransformers", "setUseDefaultTransformers", "clone", "engine", "block", "install", "client", "TBuilder", "TPlugin", "plugin", "Lio/ktor/client/plugins/HttpClientPlugin;", "configure", "key", "plusAssign", "other", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpClientConfig<T extends HttpClientEngineConfig> {
    private boolean expectSuccess;
    private final Map<AttributeKey<?>, Function1<HttpClient, Unit>> plugins = new LinkedHashMap();
    private final Map<AttributeKey<?>, Function1<Object, Unit>> pluginConfigurations = new LinkedHashMap();
    private final Map<String, Function1<HttpClient, Unit>> customInterceptors = new LinkedHashMap();
    private Function1<? super T, Unit> engineConfig = new Function1<T, Unit>() { // from class: io.ktor.client.HttpClientConfig$engineConfig$1
        /* JADX WARN: Incorrect types in method signature: (TT;)V */
        public final void invoke(HttpClientEngineConfig httpClientEngineConfig) {
            Intrinsics.checkNotNullParameter(httpClientEngineConfig, "$this$null");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((HttpClientEngineConfig) obj);
            return Unit.INSTANCE;
        }
    };
    private boolean followRedirects = true;
    private boolean useDefaultTransformers = true;
    private boolean developmentMode = PlatformUtils.INSTANCE.getIS_DEVELOPMENT_MODE();

    public final Function1<T, Unit> getEngineConfig$ktor_client_core() {
        return this.engineConfig;
    }

    public final void setEngineConfig$ktor_client_core(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.engineConfig = function1;
    }

    public final void engine(final Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        final Function1<? super T, Unit> function1 = this.engineConfig;
        this.engineConfig = (Function1) new Function1<T, Unit>() { // from class: io.ktor.client.HttpClientConfig.engine.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((AnonymousClass1) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(T t) {
                Intrinsics.checkNotNullParameter(t, "$this$null");
                function1.invoke(t);
                block.invoke(t);
            }
        };
    }

    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public final void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    public final boolean getUseDefaultTransformers() {
        return this.useDefaultTransformers;
    }

    public final void setUseDefaultTransformers(boolean z) {
        this.useDefaultTransformers = z;
    }

    public final boolean getExpectSuccess() {
        return this.expectSuccess;
    }

    public final void setExpectSuccess(boolean z) {
        this.expectSuccess = z;
    }

    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final void setDevelopmentMode(boolean z) {
        this.developmentMode = z;
    }

    public static /* synthetic */ void install$default(HttpClientConfig httpClientConfig, HttpClientPlugin httpClientPlugin, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<TBuilder, Unit>() { // from class: io.ktor.client.HttpClientConfig.install.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TBuilder tbuilder) {
                    Intrinsics.checkNotNullParameter(tbuilder, "$this$null");
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                    invoke2((C10611<TBuilder>) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        httpClientConfig.install(httpClientPlugin, function1);
    }

    public final <TBuilder, TPlugin> void install(final HttpClientPlugin<? extends TBuilder, TPlugin> plugin, final Function1<? super TBuilder, Unit> configure) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(configure, "configure");
        final Function1<Object, Unit> function1 = this.pluginConfigurations.get(plugin.getKey());
        this.pluginConfigurations.put(plugin.getKey(), new Function1<Object, Unit>() { // from class: io.ktor.client.HttpClientConfig.install.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unknown type variable: TBuilder in type: kotlin.jvm.functions.Function1<? super TBuilder, kotlin.Unit> */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "$this$null");
                Function1<Object, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(obj);
                }
                configure.invoke(obj);
            }
        });
        if (this.plugins.containsKey(plugin.getKey())) {
            return;
        }
        this.plugins.put(plugin.getKey(), new Function1<HttpClient, Unit>() { // from class: io.ktor.client.HttpClientConfig.install.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unknown type variable: TBuilder in type: io.ktor.client.plugins.HttpClientPlugin<? extends TBuilder, TPlugin> */
            /* JADX WARN: Unknown type variable: TPlugin in type: io.ktor.client.plugins.HttpClientPlugin<? extends TBuilder, TPlugin> */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpClient httpClient) {
                invoke2(httpClient);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpClient scope) {
                Intrinsics.checkNotNullParameter(scope, "scope");
                Attributes attributes = (Attributes) scope.getAttributes().computeIfAbsent(HttpClientPluginKt.getPLUGIN_INSTALLED_LIST(), new Function0<Attributes>() { // from class: io.ktor.client.HttpClientConfig$install$3$attributes$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Attributes invoke() {
                        return AttributesJvmKt.Attributes(true);
                    }
                });
                Object obj = ((HttpClientConfig) scope.getConfig$ktor_client_core()).pluginConfigurations.get(plugin.getKey());
                Intrinsics.checkNotNull(obj);
                Object objPrepare = plugin.prepare((Function1) obj);
                plugin.install(objPrepare, scope);
                attributes.put(plugin.getKey(), objPrepare);
            }
        });
    }

    public final void install(String key, Function1<? super HttpClient, Unit> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        this.customInterceptors.put(key, block);
    }

    public final void install(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        Iterator<T> it = this.plugins.values().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(client);
        }
        Iterator<T> it2 = this.customInterceptors.values().iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(client);
        }
    }

    public final HttpClientConfig<T> clone() {
        HttpClientConfig<T> httpClientConfig = new HttpClientConfig<>();
        httpClientConfig.plusAssign(this);
        return httpClientConfig;
    }

    public final void plusAssign(HttpClientConfig<? extends T> other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.followRedirects = other.followRedirects;
        this.useDefaultTransformers = other.useDefaultTransformers;
        this.expectSuccess = other.expectSuccess;
        this.plugins.putAll(other.plugins);
        this.pluginConfigurations.putAll(other.pluginConfigurations);
        this.customInterceptors.putAll(other.customInterceptors);
    }
}
