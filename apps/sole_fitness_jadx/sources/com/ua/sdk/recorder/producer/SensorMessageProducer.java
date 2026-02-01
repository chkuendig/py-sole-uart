package com.ua.sdk.recorder.producer;

import com.ua.sdk.datapoint.DataPoint;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.MessageQueue;
import com.ua.sdk.recorder.RecorderClock;
import com.ua.sdk.recorder.message.DataPointMessage;
import com.ua.sdk.util.Pools;

/* loaded from: classes2.dex */
public class SensorMessageProducer extends MessageProducer {
    private Pools.Pool<DataPointMessage> dataPointMessagePool;

    @Override // com.ua.sdk.recorder.producer.MessageProducer
    public void beginRecorder() {
    }

    @Override // com.ua.sdk.recorder.producer.MessageProducer
    public void finishRecorder() {
    }

    public SensorMessageProducer(RecorderClock recorderClock, MessageQueue messageQueue) {
        super(recorderClock, messageQueue);
        this.dataPointMessagePool = new Pools.SynchronizedPool(512);
    }

    private DataPointMessage acquireDatePointMessage(DataSourceIdentifier dataSourceIdentifier) {
        DataPointMessage dataPointMessageAcquire = this.dataPointMessagePool.acquire();
        return dataPointMessageAcquire == null ? new DataPointMessage(dataSourceIdentifier, null, this.dataPointMessagePool) : dataPointMessageAcquire;
    }

    public void dealWithIt(DataSourceIdentifier dataSourceIdentifier, DataPoint dataPoint, DataTypeRef dataTypeRef) {
        DataPointMessage dataPointMessageAcquireDatePointMessage = acquireDatePointMessage(dataSourceIdentifier);
        dataPointMessageAcquireDatePointMessage.setDataPoint(dataPoint);
        dataPointMessageAcquireDatePointMessage.setDataTypeRef(dataTypeRef);
        offer(dataPointMessageAcquireDatePointMessage);
    }
}
