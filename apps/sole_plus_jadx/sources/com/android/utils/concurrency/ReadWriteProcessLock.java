package com.android.utils.concurrency;

import com.android.utils.JvmWideVariable;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Verify;
import com.google.common.reflect.TypeToken;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final class ReadWriteProcessLock {
    private final ReentrantLock criticalSectionLock;
    private final Path lockFile;
    private final Lock readLock;
    private final AtomicReference<FileChannel> sharedFileChannel;
    private final AtomicReference<FileLock> sharedFileLock;
    private final Map<Thread, Boolean> threadToLockTypeMap;
    private final ReentrantReadWriteLock withinProcessLock;
    private final Lock writeLock;

    public interface Lock {
        void lock() throws IOException;

        boolean tryLock(long timeout, TimeUnit timeUnit) throws IOException;

        void unlock() throws IOException;
    }

    public static /* synthetic */ ReentrantLock $r8$lambda$9gwV00LQw_JXLxWKTczX5H_s7Wo() {
        return new ReentrantLock();
    }

    /* renamed from: $r8$lambda$dDAmF9BKTb9gDpH3MrCZzceE-HY, reason: not valid java name */
    public static /* synthetic */ AtomicReference m8003$r8$lambda$dDAmF9BKTb9gDpH3MrCZzceEHY() {
        return new AtomicReference();
    }

    public static /* synthetic */ HashMap $r8$lambda$zL9zIj_AuRar_VZKE_7we4Hn4rk() {
        return new HashMap();
    }

    /* renamed from: $r8$lambda$zhJNYY2XLYzmS-cx9_vYq1OSyUI, reason: not valid java name */
    public static /* synthetic */ ReentrantReadWriteLock m8004$r8$lambda$zhJNYY2XLYzmScx9_vYq1OSyUI() {
        return new ReentrantReadWriteLock();
    }

    public ReadWriteProcessLock(Path lockFile) {
        this.readLock = new ReadLock();
        this.writeLock = new WriteLock();
        try {
            Path pathCreateAndNormalizeLockFile = createAndNormalizeLockFile(lockFile);
            this.lockFile = pathCreateAndNormalizeLockFile;
            this.withinProcessLock = (ReentrantReadWriteLock) JvmWideVariable.getJvmWideObjectPerKey(ReadWriteProcessLock.class, "withinProcessLock", TypeToken.of(Path.class), TypeToken.of(ReentrantReadWriteLock.class), pathCreateAndNormalizeLockFile, new Supplier() { // from class: com.android.utils.concurrency.ReadWriteProcessLock$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ReadWriteProcessLock.m8004$r8$lambda$zhJNYY2XLYzmScx9_vYq1OSyUI();
                }
            });
            this.criticalSectionLock = (ReentrantLock) JvmWideVariable.getJvmWideObjectPerKey(ReadWriteProcessLock.class, "criticalSectionLock", TypeToken.of(Path.class), TypeToken.of(ReentrantLock.class), pathCreateAndNormalizeLockFile, new Supplier() { // from class: com.android.utils.concurrency.ReadWriteProcessLock$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ReadWriteProcessLock.$r8$lambda$9gwV00LQw_JXLxWKTczX5H_s7Wo();
                }
            });
            this.threadToLockTypeMap = (Map) JvmWideVariable.getJvmWideObjectPerKey(ReadWriteProcessLock.class, "threadToLockTypeMap", TypeToken.of(Path.class), new TypeToken<Map<Thread, Boolean>>() { // from class: com.android.utils.concurrency.ReadWriteProcessLock.1
            }, pathCreateAndNormalizeLockFile, new Supplier() { // from class: com.android.utils.concurrency.ReadWriteProcessLock$$ExternalSyntheticLambda2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ReadWriteProcessLock.$r8$lambda$zL9zIj_AuRar_VZKE_7we4Hn4rk();
                }
            });
            this.sharedFileChannel = (AtomicReference) JvmWideVariable.getJvmWideObjectPerKey(ReadWriteProcessLock.class, "sharedFileChannel", TypeToken.of(Path.class), new TypeToken<AtomicReference<FileChannel>>() { // from class: com.android.utils.concurrency.ReadWriteProcessLock.2
            }, pathCreateAndNormalizeLockFile, new Supplier() { // from class: com.android.utils.concurrency.ReadWriteProcessLock$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ReadWriteProcessLock.m8003$r8$lambda$dDAmF9BKTb9gDpH3MrCZzceEHY();
                }
            });
            this.sharedFileLock = (AtomicReference) JvmWideVariable.getJvmWideObjectPerKey(ReadWriteProcessLock.class, "sharedFileLock", TypeToken.of(Path.class), new TypeToken<AtomicReference<FileLock>>() { // from class: com.android.utils.concurrency.ReadWriteProcessLock.3
            }, pathCreateAndNormalizeLockFile, new Supplier() { // from class: com.android.utils.concurrency.ReadWriteProcessLock$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ReadWriteProcessLock.m8003$r8$lambda$dDAmF9BKTb9gDpH3MrCZzceEHY();
                }
            });
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    static Path createAndNormalizeLockFile(Path lockFilePath) throws IOException {
        if (!Files.exists(lockFilePath, new LinkOption[0])) {
            lockFilePath = lockFilePath.normalize();
            Preconditions.checkArgument(Files.exists((Path) Verify.verifyNotNull(lockFilePath.getParent()), new LinkOption[0]), "Parent directory of " + lockFilePath.toAbsolutePath() + " does not exist");
            try {
                Files.createFile(lockFilePath, new FileAttribute[0]);
            } catch (FileAlreadyExistsException unused) {
            }
        }
        Path realPath = lockFilePath.toRealPath(new LinkOption[0]);
        Preconditions.checkArgument(!Files.isDirectory(realPath, new LinkOption[0]), realPath.toAbsolutePath() + " is a directory.");
        long size = Files.size(realPath);
        Preconditions.checkArgument(size == 0, String.format("File '%1$s' with size=%2$d cannot be used as a lock file.", realPath.toAbsolutePath(), Long.valueOf(size)));
        return realPath;
    }

    public Lock readLock() {
        return this.readLock;
    }

    public Lock writeLock() {
        return this.writeLock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acquireLock(boolean shared) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = this.withinProcessLock;
        java.util.concurrent.locks.Lock lock = shared ? reentrantReadWriteLock.readLock() : reentrantReadWriteLock.writeLock();
        lock.lock();
        try {
            acquireInterProcessLock(shared);
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryAcquireLock(boolean shared, long nanosTimeout) throws IOException {
        Stopwatch stopwatchCreateStarted = Stopwatch.createStarted();
        ReentrantReadWriteLock reentrantReadWriteLock = this.withinProcessLock;
        java.util.concurrent.locks.Lock lock = shared ? reentrantReadWriteLock.readLock() : reentrantReadWriteLock.writeLock();
        try {
            if (!lock.tryLock(nanosTimeout, TimeUnit.NANOSECONDS)) {
                return false;
            }
            try {
                stopwatchCreateStarted.stop();
                boolean zTryAcquireInterProcessLock = tryAcquireInterProcessLock(shared, nanosTimeout - stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
                if (!zTryAcquireInterProcessLock) {
                }
                return zTryAcquireInterProcessLock;
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseLock(boolean shared) throws IOException {
        try {
            releaseInterProcessLock(shared);
        } finally {
            (shared ? this.withinProcessLock.readLock() : this.withinProcessLock.writeLock()).unlock();
        }
    }

    private void acquireInterProcessLock(boolean shared) throws IOException {
        this.criticalSectionLock.lock();
        try {
            Preconditions.checkState(!this.threadToLockTypeMap.containsKey(Thread.currentThread()), "ReadWriteProcessLock is not reentrant, violated by thread " + Thread.currentThread());
            if (shared) {
                Preconditions.checkState(!this.threadToLockTypeMap.values().contains(false));
            } else {
                Preconditions.checkState(this.threadToLockTypeMap.isEmpty());
            }
            if (this.threadToLockTypeMap.isEmpty()) {
                acquireFileLock(shared);
            }
            this.threadToLockTypeMap.put(Thread.currentThread(), Boolean.valueOf(shared));
        } finally {
            this.criticalSectionLock.unlock();
        }
    }

    private boolean tryAcquireInterProcessLock(boolean shared, long nanosTimeout) throws IOException {
        Stopwatch stopwatchCreateStarted = Stopwatch.createStarted();
        try {
            if (!this.criticalSectionLock.tryLock(nanosTimeout, TimeUnit.NANOSECONDS)) {
                return false;
            }
            try {
                boolean zTryAcquireFileLock = true;
                Preconditions.checkState(!this.threadToLockTypeMap.containsKey(Thread.currentThread()), "ReadWriteProcessLock is not reentrant, violated by thread " + Thread.currentThread());
                if (shared) {
                    Preconditions.checkState(!this.threadToLockTypeMap.values().contains(false));
                } else {
                    Preconditions.checkState(this.threadToLockTypeMap.isEmpty());
                }
                if (this.threadToLockTypeMap.isEmpty()) {
                    stopwatchCreateStarted.stop();
                    zTryAcquireFileLock = tryAcquireFileLock(shared, nanosTimeout - stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
                }
                if (zTryAcquireFileLock) {
                    this.threadToLockTypeMap.put(Thread.currentThread(), Boolean.valueOf(shared));
                }
                return zTryAcquireFileLock;
            } finally {
                this.criticalSectionLock.unlock();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void releaseInterProcessLock(boolean shared) throws IOException {
        this.criticalSectionLock.lock();
        try {
            Preconditions.checkState(this.threadToLockTypeMap.containsKey(Thread.currentThread()));
            boolean z = true;
            if (shared) {
                Preconditions.checkState(!this.threadToLockTypeMap.values().contains(false));
            } else {
                if (this.threadToLockTypeMap.size() != 1 || !this.threadToLockTypeMap.containsValue(false)) {
                    z = false;
                }
                Preconditions.checkState(z);
            }
            this.threadToLockTypeMap.remove(Thread.currentThread());
            if (this.threadToLockTypeMap.isEmpty()) {
                releaseFileLock();
            }
        } finally {
            this.criticalSectionLock.unlock();
        }
    }

    private void acquireFileLock(boolean shared) throws IOException {
        Preconditions.checkState(this.sharedFileChannel.get() == null && this.sharedFileLock.get() == null);
        FileChannel fileChannelOpen = FileChannel.open(this.lockFile, StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        try {
            try {
                FileLock fileLockLock = fileChannelOpen.lock(0L, Long.MAX_VALUE, shared);
                this.sharedFileChannel.set(fileChannelOpen);
                this.sharedFileLock.set(fileLockLock);
            } catch (OverlappingFileLockException e) {
                throw new RuntimeException("Unable to acquire a file lock for " + this.lockFile.toAbsolutePath(), e);
            }
        } catch (Throwable th) {
            fileChannelOpen.close();
            throw th;
        }
    }

    private boolean tryAcquireFileLock(boolean shared, long nanosTimeout) throws IOException {
        FileLock fileLockTryLock;
        Stopwatch stopwatchCreateStarted = Stopwatch.createStarted();
        Preconditions.checkState(this.sharedFileChannel.get() == null && this.sharedFileLock.get() == null);
        FileChannel fileChannelOpen = FileChannel.open(this.lockFile, StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        try {
            long j = nanosTimeout / 10;
            while (true) {
                try {
                    fileLockTryLock = fileChannelOpen.tryLock(0L, Long.MAX_VALUE, shared);
                    if (fileLockTryLock != null) {
                        this.sharedFileChannel.set(fileChannelOpen);
                        this.sharedFileLock.set(fileLockTryLock);
                        break;
                    }
                    long jElapsed = nanosTimeout - stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS);
                    if (jElapsed <= 0) {
                        break;
                    }
                    try {
                        Thread.sleep(TimeUnit.MILLISECONDS.convert(Math.min(jElapsed, j), TimeUnit.NANOSECONDS));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (OverlappingFileLockException e2) {
                    throw new RuntimeException("Unable to acquire a file lock for " + this.lockFile.toAbsolutePath(), e2);
                }
            }
            if (fileLockTryLock == null) {
            }
            return fileLockTryLock != null;
        } finally {
            fileChannelOpen.close();
        }
    }

    private void releaseFileLock() throws IOException {
        FileChannel fileChannel = (FileChannel) Preconditions.checkNotNull(this.sharedFileChannel.get());
        FileLock fileLock = (FileLock) Preconditions.checkNotNull(this.sharedFileLock.get());
        this.sharedFileChannel.set(null);
        this.sharedFileLock.set(null);
        try {
            fileLock.release();
        } finally {
            fileChannel.close();
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("lockFile", this.lockFile).toString();
    }

    private final class ReadLock implements Lock {
        private ReadLock() {
        }

        @Override // com.android.utils.concurrency.ReadWriteProcessLock.Lock
        public void lock() throws IOException {
            ReadWriteProcessLock.this.acquireLock(true);
        }

        @Override // com.android.utils.concurrency.ReadWriteProcessLock.Lock
        public boolean tryLock(long timeout, TimeUnit timeUnit) throws IOException {
            return ReadWriteProcessLock.this.tryAcquireLock(true, TimeUnit.NANOSECONDS.convert(timeout, timeUnit));
        }

        @Override // com.android.utils.concurrency.ReadWriteProcessLock.Lock
        public void unlock() throws IOException {
            ReadWriteProcessLock.this.releaseLock(true);
        }
    }

    private final class WriteLock implements Lock {
        private WriteLock() {
        }

        @Override // com.android.utils.concurrency.ReadWriteProcessLock.Lock
        public void lock() throws IOException {
            ReadWriteProcessLock.this.acquireLock(false);
        }

        @Override // com.android.utils.concurrency.ReadWriteProcessLock.Lock
        public boolean tryLock(long timeout, TimeUnit timeUnit) throws IOException {
            return ReadWriteProcessLock.this.tryAcquireLock(false, TimeUnit.NANOSECONDS.convert(timeout, timeUnit));
        }

        @Override // com.android.utils.concurrency.ReadWriteProcessLock.Lock
        public void unlock() throws IOException {
            ReadWriteProcessLock.this.releaseLock(false);
        }
    }
}
