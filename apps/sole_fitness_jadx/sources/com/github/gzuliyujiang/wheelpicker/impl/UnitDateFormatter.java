package com.github.gzuliyujiang.wheelpicker.impl;

import com.github.gzuliyujiang.wheelpicker.contract.DateFormatter;

/* loaded from: classes.dex */
public class UnitDateFormatter implements DateFormatter {
    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatYear(int i) {
        return i + "年";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatMonth(int i) {
        return i + "月";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatDay(int i) {
        return i + "日";
    }
}
