package com.ua.sdk.recorder;

import com.ua.sdk.UaLog;
import com.ua.sdk.internal.Precondition;

/* loaded from: classes2.dex */
public class RecordProcessor {
    private static final String TAG = "RecordProcessor";
    private boolean finished;
    private final MessageQueue processorMessageQueue;
    private final Thread processorThread = new Thread(new MyProcessLoopRunnable());
    private final RecorderCalculator recorderCalculator;
    private final String recorderName;

    public RecordProcessor(String str, MessageQueue messageQueue, RecorderCalculator recorderCalculator) {
        this.recorderName = str;
        this.processorMessageQueue = messageQueue;
        this.recorderCalculator = recorderCalculator;
    }

    public void begin() throws IllegalArgumentException {
        Precondition.check(!this.finished, "Can not begin an already finished RecordProcessor.");
        this.finished = false;
        this.processorThread.setName("RecordProcessor-" + this.recorderName);
        this.processorThread.start();
    }

    public void finish() throws IllegalArgumentException {
        Precondition.check(!this.finished, "Can not finish a RecordProcessor that has not called begin.");
        synchronized (this.processorMessageQueue) {
            this.finished = true;
            this.processorMessageQueue.notify();
        }
    }

    protected void processLoop() {
        Message messagePoll;
        while (!this.finished) {
            try {
                synchronized (this.processorMessageQueue) {
                    messagePoll = this.processorMessageQueue.poll();
                    if (messagePoll == null) {
                        this.processorMessageQueue.wait();
                    }
                }
                if (messagePoll != null) {
                    this.recorderCalculator.onProcessMessage(messagePoll);
                }
            } catch (InterruptedException unused) {
                UaLog.info("MessageProducerQueue InterruptedException, moving on.");
            }
        }
    }

    protected class MyProcessLoopRunnable implements Runnable {
        protected MyProcessLoopRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecordProcessor.this.processLoop();
        }
    }
}
