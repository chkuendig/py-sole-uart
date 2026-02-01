package androidx.room.guava;

import android.os.CancellationSignal;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class GuavaRoom {
    private static Executor sDirectExecutor = new Executor() { // from class: androidx.room.guava.GuavaRoom.4
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };

    private GuavaRoom() {
    }

    @Deprecated
    public static <T> ListenableFuture<T> createListenableFuture(Callable<T> callable, RoomSQLiteQuery roomSQLiteQuery, boolean z) {
        return createListenableFuture(ArchTaskExecutor.getIOThreadExecutor(), callable, roomSQLiteQuery, z, (CancellationSignal) null);
    }

    @Deprecated
    public static <T> ListenableFuture<T> createListenableFuture(RoomDatabase roomDatabase, Callable<T> callable, RoomSQLiteQuery roomSQLiteQuery, boolean z) {
        return createListenableFuture(roomDatabase.getQueryExecutor(), callable, roomSQLiteQuery, z, (CancellationSignal) null);
    }

    public static <T> ListenableFuture<T> createListenableFuture(RoomDatabase roomDatabase, boolean z, Callable<T> callable, RoomSQLiteQuery roomSQLiteQuery, boolean z2) {
        return createListenableFuture(getExecutor(roomDatabase, z), callable, roomSQLiteQuery, z2, (CancellationSignal) null);
    }

    public static <T> ListenableFuture<T> createListenableFuture(RoomDatabase roomDatabase, boolean z, Callable<T> callable, RoomSQLiteQuery roomSQLiteQuery, boolean z2, CancellationSignal cancellationSignal) {
        return createListenableFuture(getExecutor(roomDatabase, z), callable, roomSQLiteQuery, z2, cancellationSignal);
    }

    public static <T> ListenableFuture<T> createListenableFuture(RoomDatabase roomDatabase, boolean z, Callable<T> callable, SupportSQLiteQuery supportSQLiteQuery, boolean z2, CancellationSignal cancellationSignal) {
        return createListenableFuture(getExecutor(roomDatabase, z), callable, supportSQLiteQuery, z2, cancellationSignal);
    }

    private static <T> ListenableFuture<T> createListenableFuture(Executor executor, Callable<T> callable, final SupportSQLiteQuery supportSQLiteQuery, boolean z, final CancellationSignal cancellationSignal) {
        final ListenableFuture<T> listenableFutureCreateListenableFuture = createListenableFuture(executor, callable);
        if (cancellationSignal != null) {
            listenableFutureCreateListenableFuture.addListener(new Runnable() { // from class: androidx.room.guava.GuavaRoom.1
                @Override // java.lang.Runnable
                public void run() {
                    if (listenableFutureCreateListenableFuture.isCancelled()) {
                        SupportSQLiteCompat.Api16Impl.cancel(cancellationSignal);
                    }
                }
            }, sDirectExecutor);
        }
        if (z) {
            listenableFutureCreateListenableFuture.addListener(new Runnable() { // from class: androidx.room.guava.GuavaRoom.2
                @Override // java.lang.Runnable
                public void run() {
                    SupportSQLiteQuery supportSQLiteQuery2 = supportSQLiteQuery;
                    if (supportSQLiteQuery2 instanceof RoomSQLiteQuery) {
                        ((RoomSQLiteQuery) supportSQLiteQuery2).release();
                    }
                }
            }, sDirectExecutor);
        }
        return listenableFutureCreateListenableFuture;
    }

    @Deprecated
    public static <T> ListenableFuture<T> createListenableFuture(RoomDatabase roomDatabase, Callable<T> callable) {
        return createListenableFuture(roomDatabase, false, (Callable) callable);
    }

    public static <T> ListenableFuture<T> createListenableFuture(RoomDatabase roomDatabase, boolean z, Callable<T> callable) {
        return createListenableFuture(getExecutor(roomDatabase, z), callable);
    }

    private static <T> ListenableFuture<T> createListenableFuture(Executor executor, final Callable<T> callable) {
        final ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        executor.execute(new Runnable() { // from class: androidx.room.guava.GuavaRoom.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    resolvableFutureCreate.set(callable.call());
                } catch (Throwable th) {
                    resolvableFutureCreate.setException(th);
                }
            }
        });
        return resolvableFutureCreate;
    }

    private static Executor getExecutor(RoomDatabase roomDatabase, boolean z) {
        if (z) {
            return roomDatabase.getTransactionExecutor();
        }
        return roomDatabase.getQueryExecutor();
    }
}
