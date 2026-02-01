package com.github.gzuliyujiang.wheelpicker.impl;

import com.facebook.appevents.AppEventsConstants;
import com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter;
import com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout;

/* loaded from: classes.dex */
public class SimpleTimeFormatter implements TimeFormatter {
    private final TimeWheelLayout wheelLayout;

    public SimpleTimeFormatter(TimeWheelLayout timeWheelLayout) {
        this.wheelLayout = timeWheelLayout;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatHour(int i) {
        StringBuilder sb;
        String str;
        if (this.wheelLayout.isHour12Mode()) {
            if (i == 0) {
                i = 24;
            }
            if (i > 12) {
                i -= 12;
            }
        }
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

    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatMinute(int i) {
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

    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatSecond(int i) {
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
