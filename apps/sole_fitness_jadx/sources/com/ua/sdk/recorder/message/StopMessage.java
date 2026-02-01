package com.ua.sdk.recorder.message;

import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.Message;
import com.ua.sdk.recorder.MessagePersistence;
import com.ua.sdk.recorder.RecorderCalculator;
import com.ua.sdk.util.Pools;

/* loaded from: classes2.dex */
public class StopMessage extends Message {
    @Override // com.ua.sdk.recorder.Message
    public void reset() {
    }

    public StopMessage(DataSourceIdentifier dataSourceIdentifier, MessagePersistence messagePersistence, Pools.Pool pool) {
        super(dataSourceIdentifier, messagePersistence, pool);
    }

    @Override // com.ua.sdk.recorder.Message
    public void processMessage(RecorderCalculator recorderCalculator) {
        recorderCalculator.stopSegment(getDataSourceIdentifier(), getTimestamp());
    }
}
