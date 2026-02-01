package com.localebro.okhttpprofiler.transfer;

import androidx.health.connect.client.records.metadata.DeviceTypes;

/* loaded from: classes5.dex */
public enum MessageType {
    REQUEST_URL("RQU"),
    REQUEST_TIME("RQT"),
    REQUEST_METHOD("RQM"),
    REQUEST_HEADER("RQH"),
    REQUEST_BODY("RQB"),
    REQUEST_END("RQD"),
    RESPONSE_TIME("RST"),
    RESPONSE_STATUS("RSS"),
    RESPONSE_HEADER("RSH"),
    RESPONSE_BODY("RSB"),
    RESPONSE_END("RSD"),
    RESPONSE_ERROR("REE"),
    UNKNOWN(DeviceTypes.UNKNOWN);

    public final String name;

    MessageType(String str) {
        this.name = str;
    }
}
