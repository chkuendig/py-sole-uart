package com.github.gzuliyujiang.wheelpicker.impl;

/* loaded from: classes.dex */
public class BirthdayFormatter extends SimpleDateFormatter {
    @Override // com.github.gzuliyujiang.wheelpicker.impl.SimpleDateFormatter, com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatYear(int i) {
        return super.formatYear(i) + "年";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.impl.SimpleDateFormatter, com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatMonth(int i) {
        return super.formatMonth(i) + "月";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.impl.SimpleDateFormatter, com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatDay(int i) {
        return super.formatDay(i) + "日";
    }
}
