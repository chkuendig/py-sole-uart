package com.github.gzuliyujiang.wheelpicker.impl;

import com.facebook.appevents.AppEventsConstants;
import com.github.gzuliyujiang.wheelpicker.contract.DateFormatter;

/* loaded from: classes.dex */
public class SimpleDateFormatter implements DateFormatter {
    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatYear(int i) {
        if (i < 1000) {
            i += 1000;
        }
        return "" + i;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatMonth(int i) {
        StringBuilder sb;
        String str;
        if (i < 10) {
            sb = new StringBuilder();
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            sb = new StringBuilder();
            str = "";
        }
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatDay(int i) {
        StringBuilder sb;
        String str;
        if (i < 10) {
            sb = new StringBuilder();
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            sb = new StringBuilder();
            str = "";
        }
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }
}
