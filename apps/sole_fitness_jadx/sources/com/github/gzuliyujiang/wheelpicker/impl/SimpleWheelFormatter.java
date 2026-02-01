package com.github.gzuliyujiang.wheelpicker.impl;

import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;

/* loaded from: classes.dex */
public class SimpleWheelFormatter implements WheelFormatter {
    @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
    public String formatItem(Object obj) {
        return obj.toString();
    }
}
