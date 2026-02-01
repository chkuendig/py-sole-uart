package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import com.github.gzuliyujiang.wheelpicker.entity.DateEntity;
import com.github.gzuliyujiang.wheelpicker.impl.BirthdayFormatter;
import java.util.Calendar;

/* loaded from: classes.dex */
public class BirthdayPicker extends DatePicker {
    private static final int MAX_AGE = 100;

    public BirthdayPicker(Activity activity) {
        super(activity);
    }

    public BirthdayPicker(Activity activity, int i) {
        super(activity, i);
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    protected void initData() {
        super.initData();
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        this.wheelLayout.setRange(DateEntity.target(i - 100, 1, 1), DateEntity.target(i, calendar.get(2) + 1, calendar.get(5)));
        this.wheelLayout.setDateMode(0);
        this.wheelLayout.setDateFormatter(new BirthdayFormatter());
    }

    public void setDefaultValue(int i, int i2, int i3) {
        this.wheelLayout.setDefaultValue(DateEntity.target(i, i2, i3));
    }
}
