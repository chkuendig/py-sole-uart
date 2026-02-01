package com.github.gzuliyujiang.wheelpicker.impl;

import com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter;

/* loaded from: classes.dex */
public class UnitTimeFormatter implements TimeFormatter {
    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatHour(int i) {
        return i + "点";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatMinute(int i) {
        return i + "分";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatSecond(int i) {
        return i + "秒";
    }
}
