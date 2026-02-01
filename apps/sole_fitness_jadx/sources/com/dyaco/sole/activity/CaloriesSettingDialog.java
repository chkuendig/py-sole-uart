package com.dyaco.sole.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.dyaco.ideabussdk_sole.library.MyActivity;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom_view.custom_wheel.NumberPicker;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class CaloriesSettingDialog extends MyActivity implements View.OnClickListener {
    private NumberPicker picker1;
    private NumberPicker picker2;
    private NumberPicker picker3;
    private int value1;
    private int value2;
    private int value3;

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initFragments() {
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(0);
        setContentView(R.layout.s_dialog_calories_setting);
        initFragments();
        findViews();
        initParams();
        setListeners();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResultState(0);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void findViews() {
        this.picker1 = (NumberPicker) findViewById(R.id.picker1);
        this.picker2 = (NumberPicker) findViewById(R.id.picker2);
        this.picker3 = (NumberPicker) findViewById(R.id.picker3);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initParams() {
        int[] intArrayExtra = getIntent().getIntArrayExtra("valueIntArray");
        if (intArrayExtra != null && intArrayExtra.length >= 3) {
            this.value1 = intArrayExtra[0];
            this.value2 = intArrayExtra[1];
            this.value3 = intArrayExtra[2];
        }
        setPicker1();
        setPicker2();
        setPicker3();
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void setListeners() {
        findViewById(R.id.cancel_text).setOnClickListener(this);
        findViewById(R.id.confirm_text).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancel_text) {
            setResultState(0);
            return;
        }
        if (id != R.id.confirm_text) {
            return;
        }
        this.value1 = this.picker1.getValue();
        this.value2 = this.picker2.getValue();
        int value = this.picker3.getValue();
        this.value3 = value;
        int i = (this.value1 * 100) + (this.value2 * 10) + value;
        if (i < 50 || i > 999) {
            showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, true, R.string.user_add_verify_calories_out_inch, (DialogInterface.OnClickListener) null);
        } else {
            setResultState(-1);
        }
    }

    private void setPicker1() {
        this.picker1.setMaxValue(9);
        this.picker1.setMinValue(0);
        this.picker1.setValue(this.value1);
        this.picker1.setWrapSelectorWheel(true);
        this.picker1.setFocusableInTouchMode(true);
        this.picker1.setFocusable(true);
        this.picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.dyaco.sole.activity.CaloriesSettingDialog.1
            @Override // com.dyaco.sole.custom_view.custom_wheel.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                CaloriesSettingDialog.this.value1 = i2;
            }
        });
    }

    private void setPicker2() {
        this.picker2.setMaxValue(9);
        this.picker2.setMinValue(0);
        this.picker2.setValue(this.value2);
        this.picker2.setWrapSelectorWheel(true);
        this.picker2.setFocusableInTouchMode(true);
        this.picker2.setFocusable(true);
        this.picker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.dyaco.sole.activity.CaloriesSettingDialog.2
            @Override // com.dyaco.sole.custom_view.custom_wheel.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                CaloriesSettingDialog.this.value2 = i2;
            }
        });
    }

    private void setPicker3() {
        this.picker3.setMaxValue(9);
        this.picker3.setMinValue(0);
        this.picker3.setValue(this.value3);
        this.picker3.setWrapSelectorWheel(true);
        this.picker3.setFocusableInTouchMode(true);
        this.picker3.setFocusable(true);
        this.picker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.dyaco.sole.activity.CaloriesSettingDialog.3
            @Override // com.dyaco.sole.custom_view.custom_wheel.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                CaloriesSettingDialog.this.value3 = i2;
            }
        });
    }

    private void setResultState(int i) {
        Intent intent = new Intent();
        intent.putExtra("value1", this.value1);
        intent.putExtra("value2", this.value2);
        intent.putExtra("value3", this.value3);
        setResult(i, intent);
        finish();
    }
}
