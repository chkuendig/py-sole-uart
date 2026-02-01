package com.dyaco.sole.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class CustomRecordActivity_ViewBinding implements Unbinder {
    private CustomRecordActivity target;
    private View view7f08007c;
    private View view7f08007d;
    private View view7f08008f;

    public CustomRecordActivity_ViewBinding(CustomRecordActivity customRecordActivity) {
        this(customRecordActivity, customRecordActivity.getWindow().getDecorView());
    }

    public CustomRecordActivity_ViewBinding(final CustomRecordActivity customRecordActivity, View view) {
        this.target = customRecordActivity;
        customRecordActivity.sportTypeSettingLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.sportTypeSettingLayout, "field 'sportTypeSettingLayout'", RelativeLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btnBack0, "field 'btnBack0' and method 'onClick'");
        customRecordActivity.btnBack0 = (Button) Utils.castView(viewFindRequiredView, R.id.btnBack0, "field 'btnBack0'", Button.class);
        this.view7f08007d = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.CustomRecordActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws NumberFormatException {
                customRecordActivity.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btnBack, "field 'btnBack' and method 'onClick'");
        customRecordActivity.btnBack = (Button) Utils.castView(viewFindRequiredView2, R.id.btnBack, "field 'btnBack'", Button.class);
        this.view7f08007c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.CustomRecordActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws NumberFormatException {
                customRecordActivity.onClick(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btnSave, "field 'btnStop' and method 'onClick'");
        customRecordActivity.btnStop = (Button) Utils.castView(viewFindRequiredView3, R.id.btnSave, "field 'btnStop'", Button.class);
        this.view7f08008f = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.CustomRecordActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws NumberFormatException {
                customRecordActivity.onClick(view2);
            }
        });
        customRecordActivity.tvDistanceValue = (EditText) Utils.findRequiredViewAsType(view, R.id.tvDistanceValue, "field 'tvDistanceValue'", EditText.class);
        customRecordActivity.tvDurationValue = (EditText) Utils.findRequiredViewAsType(view, R.id.tvDurationValue, "field 'tvDurationValue'", EditText.class);
        customRecordActivity.tvCalorieValue = (TextView) Utils.findRequiredViewAsType(view, R.id.tvCalorieValue, "field 'tvCalorieValue'", TextView.class);
        customRecordActivity.etStartDateTime = (EditText) Utils.findRequiredViewAsType(view, R.id.etStartDateTime, "field 'etStartDateTime'", EditText.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CustomRecordActivity customRecordActivity = this.target;
        if (customRecordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        customRecordActivity.sportTypeSettingLayout = null;
        customRecordActivity.btnBack0 = null;
        customRecordActivity.btnBack = null;
        customRecordActivity.btnStop = null;
        customRecordActivity.tvDistanceValue = null;
        customRecordActivity.tvDurationValue = null;
        customRecordActivity.tvCalorieValue = null;
        customRecordActivity.etStartDateTime = null;
        this.view7f08007d.setOnClickListener(null);
        this.view7f08007d = null;
        this.view7f08007c.setOnClickListener(null);
        this.view7f08007c = null;
        this.view7f08008f.setOnClickListener(null);
        this.view7f08008f = null;
    }
}
