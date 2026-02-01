package com.journeyapps.barcodescanner;

import com.google.zxing.ResultPoint;
import java.util.List;

/* loaded from: classes5.dex */
public interface BarcodeCallback {
    void barcodeResult(BarcodeResult barcodeResult);

    default void possibleResultPoints(List<ResultPoint> list) {
    }
}
