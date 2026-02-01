package com.android.incfs.install;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
class ReadRequest {
    final short apkId;
    final int blockIndex;
    final RequestType requestType;

    enum RequestType {
        SERVING_COMPLETE,
        BLOCK_MISSING,
        PREFETCH,
        DESTROY
    }

    ReadRequest(RequestType requestType, short apkId, int blockIndex) {
        this.requestType = requestType;
        this.apkId = apkId;
        this.blockIndex = blockIndex;
    }

    public String toString() {
        return "ReadRequest{requestType=" + this.requestType + ", apkId=" + ((int) this.apkId) + ", blockIndex=" + this.blockIndex + AbstractJsonLexerKt.END_OBJ;
    }
}
