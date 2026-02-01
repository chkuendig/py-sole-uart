package com.ua.sdk.recorder;

import java.util.ArrayDeque;

/* loaded from: classes2.dex */
public class MessageQueue {
    private ArrayDeque<Message> queue = new ArrayDeque<>(1024);

    public synchronized void offer(Message message) {
        this.queue.offer(message);
        notify();
    }

    public synchronized Message poll() {
        return this.queue.poll();
    }
}
