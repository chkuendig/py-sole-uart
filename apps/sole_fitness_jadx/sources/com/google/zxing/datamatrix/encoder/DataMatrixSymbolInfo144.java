package com.google.zxing.datamatrix.encoder;

import com.dyaco.sole.R2;

/* loaded from: classes2.dex */
final class DataMatrixSymbolInfo144 extends SymbolInfo {
    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getDataLengthForInterleavedBlock(int i) {
        if (i <= 8) {
            return R2.attr.circularflow_defaultAngle;
        }
        return 155;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getInterleavedBlockCount() {
        return 10;
    }

    DataMatrixSymbolInfo144() {
        super(false, R2.dimen.terms_title_bg_height, R2.attr.textOutlineColor, 22, 22, 36, -1, 62);
    }
}
