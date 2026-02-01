package org.apache.http.client.fluent;

import java.util.concurrent.Future;
import org.apache.http.client.ResponseHandler;
import org.apache.http.concurrent.BasicFuture;
import org.apache.http.concurrent.FutureCallback;

/* loaded from: classes2.dex */
public class Async {
    private java.util.concurrent.Executor concurrentExec;
    private Executor executor;

    public static Async newInstance() {
        return new Async();
    }

    Async() {
    }

    public Async use(Executor executor) {
        this.executor = executor;
        return this;
    }

    public Async use(java.util.concurrent.Executor executor) {
        this.concurrentExec = executor;
        return this;
    }

    static class ExecRunnable<T> implements Runnable {
        private final Executor executor;
        private final BasicFuture<T> future;
        private final ResponseHandler<T> handler;
        private final Request request;

        ExecRunnable(BasicFuture<T> basicFuture, Request request, Executor executor, ResponseHandler<T> responseHandler) {
            this.future = basicFuture;
            this.request = request;
            this.executor = executor;
            this.handler = responseHandler;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                this.future.completed(this.executor.execute(this.request).handleResponse(this.handler));
            } catch (Exception e) {
                this.future.failed(e);
            }
        }
    }

    public <T> Future<T> execute(Request request, ResponseHandler<T> responseHandler, FutureCallback<T> futureCallback) {
        BasicFuture basicFuture = new BasicFuture(futureCallback);
        Executor executorNewInstance = this.executor;
        if (executorNewInstance == null) {
            executorNewInstance = Executor.newInstance();
        }
        ExecRunnable execRunnable = new ExecRunnable(basicFuture, request, executorNewInstance, responseHandler);
        java.util.concurrent.Executor executor = this.concurrentExec;
        if (executor != null) {
            executor.execute(execRunnable);
        } else {
            Thread thread = new Thread(execRunnable);
            thread.setDaemon(true);
            thread.start();
        }
        return basicFuture;
    }

    public <T> Future<T> execute(Request request, ResponseHandler<T> responseHandler) {
        return execute(request, responseHandler, null);
    }

    public Future<Content> execute(Request request, FutureCallback<Content> futureCallback) {
        return execute(request, new ContentResponseHandler(), futureCallback);
    }

    public Future<Content> execute(Request request) {
        return execute(request, new ContentResponseHandler(), null);
    }
}
