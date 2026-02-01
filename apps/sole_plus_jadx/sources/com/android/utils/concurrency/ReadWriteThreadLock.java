package com.android.utils.concurrency;

import com.android.utils.JvmWideVariable;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final class ReadWriteThreadLock {
    private final ReentrantReadWriteLock lock;
    private final Object lockObject;
    private final Lock readLock;
    private final Lock writeLock;

    public interface Lock {
        void lock();

        boolean tryLock(long timeout, TimeUnit timeUnit);

        void unlock();
    }

    /* renamed from: $r8$lambda$zhJNYY2XLYzmS-cx9_vYq1OSyUI, reason: not valid java name */
    public static /* synthetic */ ReentrantReadWriteLock m8005$r8$lambda$zhJNYY2XLYzmScx9_vYq1OSyUI() {
        return new ReentrantReadWriteLock();
    }

    public ReadWriteThreadLock(final Object lockObject) {
        this.readLock = new ReadLock();
        this.writeLock = new WriteLock();
        TypeToken typeTokenOf = TypeToken.of(String.class);
        TypeToken typeTokenOf2 = TypeToken.of(Class.class);
        String name = lockObject.getClass().getName();
        Objects.requireNonNull(lockObject);
        Preconditions.checkArgument(lockObject.getClass() == ((Class) JvmWideVariable.getJvmWideObjectPerKey(ReadWriteThreadLock.class, "lockObjectClass", typeTokenOf, typeTokenOf2, name, new Supplier() { // from class: com.android.utils.concurrency.ReadWriteThreadLock$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return lockObject.getClass();
            }
        })), String.format("Lock object's class %1$s must be loaded once but is loaded twice", lockObject.getClass().getName()));
        this.lockObject = lockObject;
        this.lock = (ReentrantReadWriteLock) JvmWideVariable.getJvmWideObjectPerKey(ReadWriteThreadLock.class, "lock", TypeToken.of(Object.class), TypeToken.of(ReentrantReadWriteLock.class), lockObject, new Supplier() { // from class: com.android.utils.concurrency.ReadWriteThreadLock$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return ReadWriteThreadLock.m8005$r8$lambda$zhJNYY2XLYzmScx9_vYq1OSyUI();
            }
        });
    }

    public Lock readLock() {
        return this.readLock;
    }

    public Lock writeLock() {
        return this.writeLock;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("lockObject", this.lockObject).toString();
    }

    private final class ReadLock implements Lock {
        private ReadLock() {
        }

        @Override // com.android.utils.concurrency.ReadWriteThreadLock.Lock
        public void lock() {
            ReadWriteThreadLock.this.lock.readLock().lock();
        }

        @Override // com.android.utils.concurrency.ReadWriteThreadLock.Lock
        public boolean tryLock(long timeout, TimeUnit timeUnit) {
            try {
                return ReadWriteThreadLock.this.lock.readLock().tryLock(timeout, timeUnit);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.android.utils.concurrency.ReadWriteThreadLock.Lock
        public void unlock() {
            ReadWriteThreadLock.this.lock.readLock().unlock();
        }
    }

    private final class WriteLock implements Lock {
        private WriteLock() {
        }

        @Override // com.android.utils.concurrency.ReadWriteThreadLock.Lock
        public void lock() {
            ReadWriteThreadLock.this.lock.writeLock().lock();
        }

        @Override // com.android.utils.concurrency.ReadWriteThreadLock.Lock
        public boolean tryLock(long timeout, TimeUnit timeUnit) {
            try {
                return ReadWriteThreadLock.this.lock.writeLock().tryLock(timeout, timeUnit);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.android.utils.concurrency.ReadWriteThreadLock.Lock
        public void unlock() {
            ReadWriteThreadLock.this.lock.writeLock().unlock();
        }
    }
}
