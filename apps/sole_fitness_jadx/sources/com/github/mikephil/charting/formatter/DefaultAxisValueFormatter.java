package com.github.mikephil.charting.formatter;

import com.facebook.appevents.AppEventsConstants;
import com.github.mikephil.charting.components.AxisBase;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public class DefaultAxisValueFormatter implements IAxisValueFormatter {
    protected int digits;
    protected DecimalFormat mFormat;

    public DefaultAxisValueFormatter(int i) {
        this.digits = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
    public String getFormattedValue(float f, AxisBase axisBase) {
        return this.mFormat.format(f);
    }

    public int getDecimalDigits() {
        return this.digits;
    }
}
