package com.android.incfs.install;

import com.android.incfs.install.IDeviceConnection;
import com.android.incfs.install.IncrementalInstallSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class IncrementalInstallSession implements AutoCloseable {
    private final ArrayList<StreamingApk> mApks;
    private final String[] mCommandArgs;
    private IncrementalInstallSessionImpl mImpl;
    private final ILogger mLogger;
    private final long mResponseTimeoutNs;
    private final IBlockTransformer mTransformer;

    public static class Builder {
        private boolean mReinstall;
        private final List<Path> mApks = new ArrayList();
        private final List<Path> mSignatures = new ArrayList();
        private final List<String> mArgs = new ArrayList();
        private IBlockFilter mFilter = new IBlockFilter() { // from class: com.android.incfs.install.IncrementalInstallSession$Builder$$ExternalSyntheticLambda0
            @Override // com.android.incfs.install.IBlockFilter
            public final boolean shouldServeBlock(PendingBlock pendingBlock) {
                return IncrementalInstallSession.Builder.lambda$new$0(pendingBlock);
            }
        };
        private IBlockTransformer mTransformer = new IBlockTransformer() { // from class: com.android.incfs.install.IncrementalInstallSession$Builder$$ExternalSyntheticLambda1
            @Override // com.android.incfs.install.IBlockTransformer
            public final PendingBlock transform(PendingBlock pendingBlock) {
                return IncrementalInstallSession.Builder.lambda$new$1(pendingBlock);
            }
        };
        private ILogger mLogger = new NullLogger();
        private long mResponseTimeoutNs = 0;

        static /* synthetic */ boolean lambda$new$0(PendingBlock pendingBlock) {
            return true;
        }

        static /* synthetic */ PendingBlock lambda$new$1(PendingBlock pendingBlock) throws IOException {
            return pendingBlock;
        }

        public Builder addApk(Path apk, Path signature) {
            this.mApks.add(apk);
            this.mSignatures.add(signature);
            return this;
        }

        public Builder addExtraArgs(String... extraArgs) {
            this.mArgs.addAll(Arrays.asList(extraArgs));
            return this;
        }

        public Builder setAllowReinstall(boolean reinstall) {
            this.mReinstall = reinstall;
            return this;
        }

        public Builder setBlockFilter(IBlockFilter filter) {
            this.mFilter = filter;
            return this;
        }

        public Builder setBlockTransformer(IBlockTransformer transformer) {
            this.mTransformer = transformer;
            return this;
        }

        public Builder setLogger(ILogger logger) {
            this.mLogger = logger;
            return this;
        }

        public Builder setResponseTimeout(long timeout, TimeUnit maxTimeUnits) {
            this.mResponseTimeoutNs = maxTimeUnits.toNanos(timeout);
            return this;
        }

        public IncrementalInstallSession build() throws IOException {
            ArrayList arrayList = new ArrayList();
            arrayList.add("install-incremental");
            if (this.mReinstall) {
                arrayList.add("-r");
            }
            arrayList.addAll(this.mArgs);
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < this.mApks.size(); i++) {
                Path path = this.mApks.get(i);
                StreamingApk streamingApkGenerate = StreamingApk.generate(path, this.mSignatures.get(i), this.mFilter, this.mLogger);
                arrayList2.add(streamingApkGenerate);
                arrayList.add(String.format(Locale.US, "arg%1$d.apk:%2$d:%1$d:%3$s:1", Integer.valueOf(i), Long.valueOf(Files.size(path)), streamingApkGenerate.getSignatureBase64()));
            }
            return new IncrementalInstallSession((String[]) arrayList.toArray(new String[0]), arrayList2, this.mResponseTimeoutNs, this.mTransformer, this.mLogger);
        }
    }

    private IncrementalInstallSession(String[] commandArgs, ArrayList<StreamingApk> apks, long responseTimeoutNs, IBlockTransformer transformer, ILogger logger) {
        this.mCommandArgs = commandArgs;
        this.mApks = apks;
        this.mResponseTimeoutNs = responseTimeoutNs;
        this.mTransformer = transformer;
        this.mLogger = logger;
    }

    public synchronized IncrementalInstallSession start(Executor executor, IDeviceConnection.Factory conFactory) throws IOException {
        if (this.mImpl != null) {
            throw new IllegalStateException("Session cannot be started multiple time.");
        }
        IncrementalInstallSessionImpl incrementalInstallSessionImpl = new IncrementalInstallSessionImpl(conFactory.connectToService("package", this.mCommandArgs), this.mApks, this.mResponseTimeoutNs, this.mTransformer, this.mLogger);
        this.mImpl = incrementalInstallSessionImpl;
        incrementalInstallSessionImpl.execute(executor);
        return this;
    }

    public void waitForInstallCompleted(long timeout, TimeUnit units) throws InterruptedException, IOException {
        this.mImpl.waitForInstallCompleted(timeout, units);
    }

    public void waitForServingCompleted(long timeout, TimeUnit units) throws InterruptedException, IOException {
        this.mImpl.waitForServingCompleted(timeout, units);
    }

    public void waitForAnyCompletion(long timeout, TimeUnit units) throws InterruptedException, IOException {
        this.mImpl.waitForAnyCompletion(timeout, units);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        IncrementalInstallSessionImpl incrementalInstallSessionImpl = this.mImpl;
        if (incrementalInstallSessionImpl != null) {
            incrementalInstallSessionImpl.close();
        }
    }

    private static class NullLogger implements ILogger {
        @Override // com.android.incfs.install.ILogger
        public void error(Throwable t, String msgFormat, Object... args) {
        }

        @Override // com.android.incfs.install.ILogger
        public void info(String msgFormat, Object... args) {
        }

        @Override // com.android.incfs.install.ILogger
        public void verbose(String msgFormat, Object... args) {
        }

        @Override // com.android.incfs.install.ILogger
        public void warning(String msgFormat, Object... args) {
        }

        private NullLogger() {
        }
    }
}
