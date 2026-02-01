package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Lazy;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DefaultHeartBeatInfo implements HeartBeatInfo {
    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$ExternalSyntheticLambda4
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return DefaultHeartBeatInfo.lambda$static$0(runnable);
        }
    };
    private final Executor backgroundExecutor;
    private final Set<HeartBeatConsumer> consumers;
    private Provider<HeartBeatInfoStorage> storageProvider;

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        return new Thread(runnable, "heartbeat-information-executor");
    }

    private DefaultHeartBeatInfo(final Context context, Set<HeartBeatConsumer> set) {
        this(new Lazy(new Provider() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$ExternalSyntheticLambda1
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return HeartBeatInfoStorage.getInstance(context);
            }
        }), set, new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY));
    }

    DefaultHeartBeatInfo(Provider<HeartBeatInfoStorage> provider, Set<HeartBeatConsumer> set, Executor executor) {
        this.storageProvider = provider;
        this.consumers = set;
        this.backgroundExecutor = executor;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public HeartBeatInfo.HeartBeat getHeartBeatCode(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zShouldSendSdkHeartBeat = this.storageProvider.get().shouldSendSdkHeartBeat(str, jCurrentTimeMillis);
        boolean zShouldSendGlobalHeartBeat = this.storageProvider.get().shouldSendGlobalHeartBeat(jCurrentTimeMillis);
        if (zShouldSendSdkHeartBeat && zShouldSendGlobalHeartBeat) {
            return HeartBeatInfo.HeartBeat.COMBINED;
        }
        if (zShouldSendGlobalHeartBeat) {
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        if (zShouldSendSdkHeartBeat) {
            return HeartBeatInfo.HeartBeat.SDK;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public Task<List<HeartBeatResult>> getAndClearStoredHeartBeatInfo() {
        return Tasks.call(this.backgroundExecutor, new Callable() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m78xaf1d5f68();
            }
        });
    }

    /* renamed from: lambda$getAndClearStoredHeartBeatInfo$2$com-google-firebase-heartbeatinfo-DefaultHeartBeatInfo, reason: not valid java name */
    /* synthetic */ List m78xaf1d5f68() throws Exception {
        HeartBeatInfo.HeartBeat heartBeat;
        ArrayList arrayList = new ArrayList();
        HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
        List<SdkHeartBeatResult> storedHeartBeats = heartBeatInfoStorage.getStoredHeartBeats(true);
        long lastGlobalHeartBeat = heartBeatInfoStorage.getLastGlobalHeartBeat();
        for (SdkHeartBeatResult sdkHeartBeatResult : storedHeartBeats) {
            boolean zIsSameDateUtc = HeartBeatInfoStorage.isSameDateUtc(lastGlobalHeartBeat, sdkHeartBeatResult.getMillis());
            if (zIsSameDateUtc) {
                heartBeat = HeartBeatInfo.HeartBeat.COMBINED;
            } else {
                heartBeat = HeartBeatInfo.HeartBeat.SDK;
            }
            if (zIsSameDateUtc) {
                lastGlobalHeartBeat = sdkHeartBeatResult.getMillis();
            }
            arrayList.add(HeartBeatResult.create(sdkHeartBeatResult.getSdkName(), sdkHeartBeatResult.getMillis(), heartBeat));
        }
        if (lastGlobalHeartBeat > 0) {
            heartBeatInfoStorage.updateGlobalHeartBeat(lastGlobalHeartBeat);
        }
        return arrayList;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public Task<Void> storeHeartBeatInfo(final String str) {
        if (this.consumers.size() <= 0) {
            return Tasks.forResult(null);
        }
        return Tasks.call(this.backgroundExecutor, new Callable() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m79x2740e339(str);
            }
        });
    }

    /* renamed from: lambda$storeHeartBeatInfo$3$com-google-firebase-heartbeatinfo-DefaultHeartBeatInfo, reason: not valid java name */
    /* synthetic */ Void m79x2740e339(String str) throws Exception {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.storageProvider.get().shouldSendSdkHeartBeat(str, jCurrentTimeMillis)) {
            return null;
        }
        this.storageProvider.get().storeHeartBeatInformation(str, jCurrentTimeMillis);
        return null;
    }

    public static Component<HeartBeatInfo> component() {
        return Component.builder(HeartBeatInfo.class).add(Dependency.required(Context.class)).add(Dependency.setOf(HeartBeatConsumer.class)).factory(new ComponentFactory() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$ExternalSyntheticLambda0
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return DefaultHeartBeatInfo.lambda$component$4(componentContainer);
            }
        }).build();
    }

    static /* synthetic */ HeartBeatInfo lambda$component$4(ComponentContainer componentContainer) {
        return new DefaultHeartBeatInfo((Context) componentContainer.get(Context.class), componentContainer.setOf(HeartBeatConsumer.class));
    }
}
