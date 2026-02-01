package com.dyaco.sole.fragment.display;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dyaco.ideabussdk_sole.protocol.WorkoutData;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom.Sole_DeviceModelList;
import com.dyaco.sole.custom_view.TypefaceTextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.security.CertificateUtil;
import com.soletreadmills.sole.R;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes.dex */
public class DisplayDashboardLinearLayout extends DisplayBaseLinearLayout implements View.OnClickListener {
    private TypefaceTextView dashboard_center_title_text;
    private TextView dashboard_center_value_text;
    private S_DisplayDashboardView dashboard_center_view;
    private View dashboard_layout;
    private TypefaceTextView dashboard_left_1_number_textview;
    private TypefaceTextView dashboard_left_1_title_textview;
    private TypefaceTextView dashboard_left_2_number_textview;
    private TypefaceTextView dashboard_left_2_title_textview;
    private ImageView dashboard_left_title_image;
    private TypefaceTextView dashboard_left_title_text;
    private TextView dashboard_left_value_text;
    private S_DisplayDashboardView dashboard_left_view;
    private TypefaceTextView dashboard_minute_textview;
    private TypefaceTextView dashboard_right_1_number_textview;
    private TypefaceTextView dashboard_right_1_title_textview;
    private TypefaceTextView dashboard_right_2_number_textview;
    private TypefaceTextView dashboard_right_2_title_textview;
    private ImageView dashboard_right_title_image;
    private TypefaceTextView dashboard_right_title_text;
    private TextView dashboard_right_value_text;
    private S_DisplayDashboardView dashboard_right_view;
    private TypefaceTextView dashboard_seconds_textview;
    private DisplayDashboardView display_dashboard_view;
    private View include_display_dashboard_view;
    private View left_1_down_arrow_image;
    private View left_1_up_arrow_image;
    private float numberControlTextSize;
    private float numberTextSize;
    private View.OnClickListener onControlArrowClick;
    private ImageView param1_icon_image;
    private TypefaceTextView param1_title_text;
    private TextView param1_value_text;
    private ImageView param2_icon_image;
    private View param2_include;
    private TypefaceTextView param2_title_text;
    private TextView param2_value_text;
    private ImageView param3_icon_image;
    private View param3_include;
    private View param3_line;
    private TypefaceTextView param3_title_text;
    private TextView param3_value_text;
    private ImageView param4_icon_image;
    private View param4_include;
    private TypefaceTextView param4_title_text;
    private TextView param4_value_text;
    private ImageView param5_icon_image;
    private View param5_include;
    private TypefaceTextView param5_title_text;
    private TextView param5_value_text;
    private DisplayMainFragment parentFragment;
    private View right_1_down_arrow_image;
    private View right_1_up_arrow_image;
    private View right_2_down_arrow_image;
    private View right_2_up_arrow_image;
    private float titleControlTextSize;
    private float titleTextSize;
    private TypefaceTextView unit_4_1_text;
    private TypefaceTextView unit_4_2_text;
    private View unit_layout;
    private TypefaceTextView unit_right_1_text;
    private TypefaceTextView unit_right_2_text;
    private X_DisplayDashboardView x_dashboard_center_view;
    private X_DisplayDashboardView x_dashboard_left_view;
    private X_DisplayDashboardView x_dashboard_right_view;

    public DisplayDashboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onControlArrowClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayDashboardLinearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(DisplayDashboardLinearLayout.this.getContext(), ErrorLogSave.CLICK, "DisplayDashboardLinearLayout_onControlArrowClick", "click_id:" + view.getId() + "_devictType:" + ProtocolHandler.protocol.deviceType);
                switch (view.getId()) {
                    case 1:
                        int i = ProtocolHandler.protocol.deviceType;
                        if (i == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        } else if (i == 1) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        }
                        break;
                    case 2:
                        int i2 = ProtocolHandler.protocol.deviceType;
                        if (i2 == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        } else if (i2 == 1) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i2 == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        }
                        break;
                    case 3:
                        int i3 = ProtocolHandler.protocol.deviceType;
                        if (i3 == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i3 == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 4:
                        int i4 = ProtocolHandler.protocol.deviceType;
                        if (i4 == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i4 == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        }
                        break;
                    case 5:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 6:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        }
                        break;
                }
            }
        };
    }

    public DisplayDashboardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onControlArrowClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayDashboardLinearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(DisplayDashboardLinearLayout.this.getContext(), ErrorLogSave.CLICK, "DisplayDashboardLinearLayout_onControlArrowClick", "click_id:" + view.getId() + "_devictType:" + ProtocolHandler.protocol.deviceType);
                switch (view.getId()) {
                    case 1:
                        int i2 = ProtocolHandler.protocol.deviceType;
                        if (i2 == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        } else if (i2 == 1) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i2 == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        }
                        break;
                    case 2:
                        int i22 = ProtocolHandler.protocol.deviceType;
                        if (i22 == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        } else if (i22 == 1) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i22 == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        }
                        break;
                    case 3:
                        int i3 = ProtocolHandler.protocol.deviceType;
                        if (i3 == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i3 == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 4:
                        int i4 = ProtocolHandler.protocol.deviceType;
                        if (i4 == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i4 == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        }
                        break;
                    case 5:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 6:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        }
                        break;
                }
            }
        };
    }

    public DisplayDashboardLinearLayout(Context context, DisplayMainFragment displayMainFragment) {
        super(context, 1);
        this.onControlArrowClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayDashboardLinearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(DisplayDashboardLinearLayout.this.getContext(), ErrorLogSave.CLICK, "DisplayDashboardLinearLayout_onControlArrowClick", "click_id:" + view.getId() + "_devictType:" + ProtocolHandler.protocol.deviceType);
                switch (view.getId()) {
                    case 1:
                        int i2 = ProtocolHandler.protocol.deviceType;
                        if (i2 == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        } else if (i2 == 1) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i2 == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        }
                        break;
                    case 2:
                        int i22 = ProtocolHandler.protocol.deviceType;
                        if (i22 == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        } else if (i22 == 1) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i22 == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        }
                        break;
                    case 3:
                        int i3 = ProtocolHandler.protocol.deviceType;
                        if (i3 == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i3 == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 4:
                        int i4 = ProtocolHandler.protocol.deviceType;
                        if (i4 == 0) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i4 == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        }
                        break;
                    case 5:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 6:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayDashboardLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        }
                        break;
                }
            }
        };
        this.parentFragment = displayMainFragment;
        init();
    }

    private void init() {
        findViews();
        initParams();
        setListeners();
        if (Global.BRAND != 0) {
            return;
        }
        setBottomLayout();
    }

    @Override // com.dyaco.sole.fragment.display.DisplayBaseLinearLayout
    protected void findViews() {
        int i = Global.BRAND;
        if (i == 0) {
            View viewInflate = inflate(this.activity, R.layout.include_display_dashboard, null);
            this.include_display_dashboard_view = viewInflate;
            this.display_dashboard_view = (DisplayDashboardView) viewInflate.findViewById(R.id.display_dashboard_view);
            this.dashboard_minute_textview = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_minute_textview);
            this.dashboard_seconds_textview = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_seconds_textview);
            this.dashboard_left_1_title_textview = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_left_1_title_textview);
            this.dashboard_left_1_number_textview = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_left_1_number_textview);
            this.dashboard_left_2_title_textview = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_left_2_title_textview);
            this.dashboard_left_2_number_textview = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_left_2_number_textview);
            this.dashboard_right_1_title_textview = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_right_1_title_textview);
            this.dashboard_right_1_number_textview = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_right_1_number_textview);
            this.dashboard_right_2_title_textview = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_right_2_title_textview);
            this.dashboard_right_2_number_textview = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_right_2_number_textview);
            this.left_1_up_arrow_image = this.include_display_dashboard_view.findViewById(R.id.left_1_up_arrow_image);
            this.left_1_down_arrow_image = this.include_display_dashboard_view.findViewById(R.id.left_1_down_arrow_image);
            this.right_1_up_arrow_image = this.include_display_dashboard_view.findViewById(R.id.right_1_up_arrow_image);
            this.right_1_down_arrow_image = this.include_display_dashboard_view.findViewById(R.id.right_1_down_arrow_image);
            this.right_2_up_arrow_image = this.include_display_dashboard_view.findViewById(R.id.right_2_up_arrow_image);
            this.right_2_down_arrow_image = this.include_display_dashboard_view.findViewById(R.id.right_2_down_arrow_image);
        } else if (i == 1 || i == 2 || i == 3) {
            this.rootView.findViewById(R.id.display_bottom_content_layout).setVisibility(8);
            View viewInflate2 = inflate(this.activity, R.layout.s_include_display_dashboard, null);
            this.include_display_dashboard_view = viewInflate2;
            this.dashboard_left_title_text = (TypefaceTextView) viewInflate2.findViewById(R.id.dashboard_left_title_text);
            this.dashboard_right_title_text = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_right_title_text);
            this.dashboard_left_title_image = (ImageView) this.include_display_dashboard_view.findViewById(R.id.dashboard_left_title_image);
            this.dashboard_right_title_image = (ImageView) this.include_display_dashboard_view.findViewById(R.id.dashboard_right_title_image);
            this.dashboard_left_value_text = (TextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_left_value_text);
            this.dashboard_right_value_text = (TextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_right_value_text);
            this.dashboard_center_value_text = (TextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_center_value_text);
            this.unit_layout = this.include_display_dashboard_view.findViewById(R.id.unit_layout);
            this.unit_right_1_text = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.unit_1_text);
            this.unit_right_2_text = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.unit_2_text);
            if (Global.BRAND == 1) {
                this.dashboard_left_view = (S_DisplayDashboardView) this.include_display_dashboard_view.findViewById(R.id.dashboard_left_view);
                this.dashboard_right_view = (S_DisplayDashboardView) this.include_display_dashboard_view.findViewById(R.id.dashboard_right_view);
                this.dashboard_center_view = (S_DisplayDashboardView) this.include_display_dashboard_view.findViewById(R.id.dashboard_center_view);
                View viewFindViewById = this.include_display_dashboard_view.findViewById(R.id.param1_include);
                this.param2_include = this.include_display_dashboard_view.findViewById(R.id.param2_include);
                this.param3_include = this.include_display_dashboard_view.findViewById(R.id.param3_include);
                this.param4_include = this.include_display_dashboard_view.findViewById(R.id.param4_include);
                this.param5_include = this.include_display_dashboard_view.findViewById(R.id.param5_include);
                this.param3_line = this.include_display_dashboard_view.findViewById(R.id.param3_line);
                this.param1_icon_image = (ImageView) viewFindViewById.findViewById(R.id.icon_image);
                this.param2_icon_image = (ImageView) this.param2_include.findViewById(R.id.icon_image);
                this.param3_icon_image = (ImageView) this.param3_include.findViewById(R.id.icon_image);
                this.param4_icon_image = (ImageView) this.param4_include.findViewById(R.id.icon_image);
                this.param5_icon_image = (ImageView) this.param5_include.findViewById(R.id.icon_image);
                this.param1_value_text = (TextView) viewFindViewById.findViewById(R.id.value_text);
                this.param2_value_text = (TextView) this.param2_include.findViewById(R.id.value_text);
                this.param3_value_text = (TextView) this.param3_include.findViewById(R.id.value_text);
                this.param4_value_text = (TextView) this.param4_include.findViewById(R.id.value_text);
                this.param5_value_text = (TextView) this.param5_include.findViewById(R.id.value_text);
                this.param1_title_text = (TypefaceTextView) viewFindViewById.findViewById(R.id.title_text);
                this.param2_title_text = (TypefaceTextView) this.param2_include.findViewById(R.id.title_text);
                this.param3_title_text = (TypefaceTextView) this.param3_include.findViewById(R.id.title_text);
                this.param4_title_text = (TypefaceTextView) this.param4_include.findViewById(R.id.title_text);
                this.param5_title_text = (TypefaceTextView) this.param5_include.findViewById(R.id.title_text);
                this.param4_include.findViewById(R.id.unit_layout).setVisibility(0);
                this.unit_4_1_text = (TypefaceTextView) this.param4_include.findViewById(R.id.unit_1_text);
                this.unit_4_2_text = (TypefaceTextView) this.param4_include.findViewById(R.id.unit_2_text);
            } else {
                this.include_display_dashboard_view.findViewById(R.id.line).setVisibility(8);
                this.x_dashboard_left_view = (X_DisplayDashboardView) this.include_display_dashboard_view.findViewById(R.id.x_dashboard_left_view);
                this.x_dashboard_right_view = (X_DisplayDashboardView) this.include_display_dashboard_view.findViewById(R.id.x_dashboard_right_view);
                this.x_dashboard_center_view = (X_DisplayDashboardView) this.include_display_dashboard_view.findViewById(R.id.x_dashboard_center_view);
            }
        }
        ((FrameLayout) this.rootView.findViewById(R.id.display_content_layout)).addView(this.include_display_dashboard_view);
    }

    @Override // com.dyaco.sole.fragment.display.DisplayBaseLinearLayout
    protected void initParams() {
        int i = Global.BRAND;
        if (i == 0) {
            View viewFindViewById = this.include_display_dashboard_view.findViewById(R.id.dashboard_layout);
            this.dashboard_layout = viewFindViewById;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_bg_width), 0.8f);
            layoutParams.height = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_bg_height), 0.8f);
            this.dashboard_layout.setLayoutParams(layoutParams);
            this.dashboard_minute_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_dashboard_time_text_size), 0.8f));
            this.dashboard_seconds_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_dashboard_time_text_size), 0.8f));
            this.titleTextSize = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_dashboard_title_text_size), 0.8f);
            this.numberTextSize = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_dashboard_number_text_size), 0.8f);
            this.titleControlTextSize = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_dashboard_control_title_text_size), 0.8f);
            this.numberControlTextSize = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_dashboard_control_number_text_size), 0.8f);
            this.dashboard_left_2_title_textview.setTextSize(0, this.titleTextSize);
            this.dashboard_left_2_number_textview.setTextSize(0, this.numberTextSize);
            this.dashboard_minute_textview.setTypeface(this.activity, Global.fontsPath[0]);
            this.dashboard_seconds_textview.setTypeface(this.activity, Global.fontsPath[0]);
            this.dashboard_left_1_title_textview.setTypeface(this.activity, Global.fontsPath[1], 2);
            this.dashboard_left_1_number_textview.setTypeface(this.activity, Global.fontsPath[0]);
            this.dashboard_left_2_title_textview.setTypeface(this.activity, Global.fontsPath[1], 2);
            this.dashboard_left_2_number_textview.setTypeface(this.activity, Global.fontsPath[0]);
            this.dashboard_right_1_title_textview.setTypeface(this.activity, Global.fontsPath[1], 2);
            this.dashboard_right_1_number_textview.setTypeface(this.activity, Global.fontsPath[0]);
            this.dashboard_right_2_title_textview.setTypeface(this.activity, Global.fontsPath[1], 2);
            this.dashboard_right_2_number_textview.setTypeface(this.activity, Global.fontsPath[0]);
            this.left_1_up_arrow_image.setId(1);
            this.left_1_down_arrow_image.setId(2);
            this.right_1_up_arrow_image.setId(5);
            this.right_1_down_arrow_image.setId(6);
            this.right_2_up_arrow_image.setId(3);
            this.right_2_down_arrow_image.setId(4);
            this.left_1_up_arrow_image.setOnClickListener(this.onControlArrowClick);
            this.left_1_down_arrow_image.setOnClickListener(this.onControlArrowClick);
            this.right_1_up_arrow_image.setOnClickListener(this.onControlArrowClick);
            this.right_1_down_arrow_image.setOnClickListener(this.onControlArrowClick);
            this.right_2_up_arrow_image.setOnClickListener(this.onControlArrowClick);
            this.right_2_down_arrow_image.setOnClickListener(this.onControlArrowClick);
            return;
        }
        if (i == 1 || i == 2 || i == 3) {
            this.parentFragment.caloriesValue = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            this.parentFragment.paceUnitValue = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            this.parentFragment.lapsUnitValue = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            this.dashboard_center_title_text = (TypefaceTextView) this.include_display_dashboard_view.findViewById(R.id.dashboard_center_title_text);
            View viewFindViewById2 = this.include_display_dashboard_view.findViewById(R.id.dashboard_center_layout);
            View viewFindViewById3 = this.include_display_dashboard_view.findViewById(R.id.dashboard_left_layout);
            View viewFindViewById4 = this.include_display_dashboard_view.findViewById(R.id.dashboard_right_layout);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams();
            layoutParams2.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_dashboard_width_m), 0.8f);
            layoutParams2.height = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_dashboard_height_m), 0.8f);
            viewFindViewById2.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) viewFindViewById3.getLayoutParams();
            layoutParams3.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_dashboard_width_s), 0.8f);
            layoutParams3.height = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_dashboard_height_s), 0.8f);
            viewFindViewById3.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) viewFindViewById4.getLayoutParams();
            layoutParams4.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_dashboard_width_s), 0.8f);
            layoutParams4.height = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_dashboard_height_s), 0.8f);
            viewFindViewById4.setLayoutParams(layoutParams4);
            if (Global.BRAND == 1) {
                this.dashboard_center_view.setVisibility(0);
                this.dashboard_left_view.setVisibility(0);
                this.dashboard_right_view.setVisibility(0);
                this.dashboard_center_view.setLevelDirection(true);
                this.dashboard_left_view.setLevelDirection(true);
                this.dashboard_right_view.setLevelDirection(false);
                View viewFindViewById5 = this.include_display_dashboard_view.findViewById(R.id.bottom_layout);
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) viewFindViewById5.getLayoutParams();
                layoutParams5.height = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_dashboard_bottom_layout_height), 0.8f);
                int longScreenHeight = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_dashboard_bottom_margin), 2.0f);
                layoutParams5.setMargins(0, longScreenHeight, 0, longScreenHeight);
                viewFindViewById5.setLayoutParams(layoutParams5);
                viewFindViewById5.setVisibility(0);
                return;
            }
            this.x_dashboard_center_view.setVisibility(0);
            this.x_dashboard_left_view.setVisibility(0);
            this.x_dashboard_right_view.setVisibility(0);
            this.x_dashboard_left_view.setLevelType(0);
            this.x_dashboard_center_view.setLevelType(1);
            this.x_dashboard_right_view.setLevelType(2);
            this.dashboard_left_value_text.setTextColor(this.res.getColor(R.color.white));
            this.dashboard_center_value_text.setTextColor(this.res.getColor(R.color.white));
            this.dashboard_right_value_text.setTextColor(this.res.getColor(R.color.white));
            this.dashboard_left_title_text.setTextColor(this.res.getColor(R.color.black));
            this.dashboard_center_title_text.setTextColor(this.res.getColor(R.color.black));
            this.dashboard_right_title_text.setTextColor(this.res.getColor(R.color.black));
        }
    }

    @Override // com.dyaco.sole.fragment.display.DisplayBaseLinearLayout
    protected void setListeners() {
        int i = Global.BRAND;
        if (i != 1) {
            if (i == 2 || i == 3) {
                this.include_display_dashboard_view.findViewById(R.id.dashboard_right_click_layout).setOnClickListener(this);
                return;
            }
            return;
        }
        this.include_display_dashboard_view.findViewById(R.id.dashboard_right_click_layout).setOnClickListener(this);
        this.param2_include.setOnClickListener(this);
        this.param3_include.setOnClickListener(this);
        this.param4_include.setOnClickListener(this);
        this.param5_include.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dashboard_right_click_layout /* 2131231090 */:
                ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "DisplayDashboardLinearLayout_right_click", "click_devictType:" + ProtocolHandler.protocol.deviceType);
                int i = Global.BRAND;
                if (i == 1) {
                    if (ProtocolHandler.protocol.deviceType == 0) {
                        if (this.parentFragment.speedUnitFlag) {
                            changeRightViewToMI();
                        } else {
                            changeRightViewToKM();
                        }
                        this.dashboard_right_value_text.setText(String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.speedUnitFlag ? 1 : 0, this.parentFragment.speedUnitValue)));
                        this.parentFragment.speedUnitFlag = !r9.speedUnitFlag;
                        break;
                    }
                } else if ((i == 2 || i == 3) && ProtocolHandler.protocol.deviceType == 0) {
                    if (!this.parentFragment.speedUnitFlag) {
                        changeRightViewToMI();
                    } else {
                        changeRightViewToKM();
                    }
                    this.dashboard_right_value_text.setText(String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.speedUnitFlag ? 1 : 0, this.parentFragment.speedUnitValue)));
                    this.parentFragment.speedUnitFlag = !r9.speedUnitFlag;
                    break;
                }
                break;
            case R.id.param2_include /* 2131231465 */:
                ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "DisplayDashboardLinearLayout_param2_include", "click_devictType:" + ProtocolHandler.protocol.deviceType);
                int i2 = ProtocolHandler.protocol.deviceType;
                if (i2 == 0) {
                    if (this.parentFragment.caloriesLayoutFlag == 0) {
                        this.param2_title_text.setText(R.string.calories_hour);
                        this.parentFragment.caloriesLayoutFlag = 1;
                    } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                        this.param2_title_text.setText(R.string.calories);
                        this.parentFragment.caloriesLayoutFlag = 0;
                    }
                    this.param2_value_text.setText(this.parentFragment.caloriesValue);
                    break;
                } else if (i2 == 1) {
                    if (this.parentFragment.caloriesLayoutFlag == 0) {
                        this.param2_title_text.setText(R.string.calories_hour);
                        this.parentFragment.caloriesLayoutFlag = 1;
                    } else {
                        this.param2_title_text.setText(R.string.calories);
                        this.parentFragment.caloriesLayoutFlag = 0;
                    }
                    this.param2_value_text.setText(this.parentFragment.caloriesValue);
                    break;
                }
                break;
            case R.id.param3_include /* 2131231466 */:
                ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "DisplayDashboardLinearLayout_param3_include", "click_devictType:" + ProtocolHandler.protocol.deviceType);
                if (ProtocolHandler.protocol.deviceType == 2) {
                    if (this.parentFragment.caloriesLayoutFlag == 0) {
                        this.param3_title_text.setText(R.string.calories_hour);
                        this.parentFragment.caloriesLayoutFlag = 1;
                    } else {
                        this.param3_title_text.setText(R.string.calories);
                        this.parentFragment.caloriesLayoutFlag = 0;
                    }
                    this.param3_value_text.setText(this.parentFragment.caloriesValue);
                    break;
                }
                break;
            case R.id.param4_include /* 2131231468 */:
                ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "DisplayDashboardLinearLayout_param4_include", "click_devictType:" + ProtocolHandler.protocol.deviceType);
                int i3 = ProtocolHandler.protocol.deviceType;
                if (i3 == 0 || i3 == 1 || i3 == 2) {
                    if (this.parentFragment.distanceUnitFlag) {
                        change4ViewToMI();
                    } else {
                        change4ViewToKM();
                    }
                    this.param4_value_text.setText(String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.distanceUnitFlag ? 1 : 0, this.parentFragment.distanceUnitValue)));
                    this.parentFragment.distanceUnitFlag = !r9.distanceUnitFlag;
                    break;
                }
            case R.id.param5_include /* 2131231469 */:
                ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "DisplayDashboardLinearLayout_param5_include", "click_devictType:" + ProtocolHandler.protocol.deviceType);
                if (ProtocolHandler.protocol.deviceType == 0) {
                    if (this.parentFragment.isPaceOrLapsUnitFlag) {
                        this.param5_title_text.setText(this.res.getString(R.string.display_pace).toUpperCase());
                        this.param5_icon_image.setImageResource(R.drawable.s_display_icon_a_laps);
                        this.param5_value_text.setText(this.parentFragment.paceUnitValue);
                    } else {
                        this.param5_title_text.setText(R.string.mets);
                        this.param5_icon_image.setImageResource(R.drawable.s_display_icon_a_mets);
                        this.param5_value_text.setText(this.parentFragment.lapsUnitValue);
                    }
                    this.parentFragment.isPaceOrLapsUnitFlag = !r9.isPaceOrLapsUnitFlag;
                    break;
                }
                break;
        }
    }

    private void changeRightViewToMI() {
        this.unit_right_1_text.setTextColor(this.res.getColor(R.color.black));
        this.unit_right_2_text.setTextColor(this.res.getColor(R.color.light_gray1));
    }

    private void changeRightViewToKM() {
        this.unit_right_1_text.setTextColor(this.res.getColor(R.color.light_gray1));
        this.unit_right_2_text.setTextColor(this.res.getColor(R.color.black));
    }

    private void change4ViewToMI() {
        this.unit_4_1_text.setTextColor(this.res.getColor(R.color.black));
        this.unit_4_2_text.setTextColor(this.res.getColor(R.color.light_gray1));
    }

    private void change4ViewToKM() {
        this.unit_4_1_text.setTextColor(this.res.getColor(R.color.light_gray1));
        this.unit_4_2_text.setTextColor(this.res.getColor(R.color.black));
    }

    @Override // com.dyaco.sole.fragment.display.DisplayBaseLinearLayout
    public void resetData() {
        int i = Global.BRAND;
        if (i != 0) {
            if (i == 1 || i == 2 || i == 3) {
                this.unit_layout.setVisibility(8);
                int i2 = ProtocolHandler.protocol.deviceType;
                if (i2 == 0) {
                    this.unit_layout.setVisibility(0);
                    if (ProtocolHandler.protocol.showInclineMode == 2) {
                        this.dashboard_left_title_text.setText(this.res.getString(R.string.stride).toUpperCase());
                    } else {
                        this.dashboard_left_title_image.setImageResource(R.drawable.s_display_icon_a_incline_l);
                        this.dashboard_left_title_text.setText(this.res.getString(R.string.display_incline).toUpperCase());
                    }
                    this.dashboard_right_title_text.setText(this.res.getString(R.string.speed).toUpperCase());
                    this.dashboard_right_title_image.setImageResource(R.drawable.s_display_icon_a_speed);
                } else if (i2 == 1) {
                    this.dashboard_left_title_text.setText(this.res.getString(R.string.level).toUpperCase());
                    this.dashboard_right_title_text.setText(R.string.display_rpm);
                    this.dashboard_left_title_image.setImageResource(R.drawable.s_display_icon_a_level);
                    this.dashboard_right_title_image.setImageResource(R.drawable.s_display_icon_a_rpm);
                } else if (i2 == 2) {
                    if (ProtocolHandler.protocol.showInclineMode == 2) {
                        this.dashboard_left_title_text.setText(this.res.getString(R.string.stride).toUpperCase());
                    } else {
                        this.dashboard_left_title_image.setImageResource(R.drawable.s_display_icon_a_incline_l);
                        this.dashboard_left_title_text.setText(this.res.getString(R.string.display_incline).toUpperCase());
                    }
                    this.dashboard_right_title_text.setText(this.res.getString(R.string.level).toUpperCase());
                    this.dashboard_right_title_image.setImageResource(R.drawable.s_display_icon_a_level);
                }
                if (Global.BRAND == 1) {
                    this.param3_include.setVisibility(8);
                    this.param3_line.setVisibility(8);
                    DisplayMainFragment displayMainFragment = this.parentFragment;
                    boolean z = ProtocolHandler.protocol.deviceUnit == 0;
                    displayMainFragment.distanceUnitFlag = z;
                    displayMainFragment.speedUnitFlag = z;
                    this.param1_icon_image.setImageResource(R.drawable.s_display_icon_a_hr);
                    this.param1_title_text.setText(R.string.heart_rate);
                    if (this.parentFragment.speedUnitFlag) {
                        changeRightViewToKM();
                    } else {
                        changeRightViewToMI();
                    }
                    if (this.parentFragment.distanceUnitFlag) {
                        change4ViewToKM();
                    } else {
                        change4ViewToMI();
                    }
                    int i3 = ProtocolHandler.protocol.deviceType;
                    if (i3 == 0) {
                        if (this.parentFragment.caloriesLayoutFlag == 0) {
                            this.param2_title_text.setText(R.string.calories);
                        } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                            this.param2_title_text.setText(R.string.calories_hour);
                        }
                        if (this.parentFragment.isPaceOrLapsUnitFlag) {
                            this.param5_title_text.setText(R.string.mets);
                            this.param5_icon_image.setImageResource(R.drawable.s_display_icon_a_mets);
                        } else {
                            this.param5_title_text.setText(this.res.getString(R.string.display_pace).toUpperCase());
                            this.param5_icon_image.setImageResource(R.drawable.s_display_icon_a_laps);
                        }
                        this.param2_icon_image.setImageResource(R.drawable.s_display_icon_a_cal);
                        this.param4_icon_image.setImageResource(R.drawable.s_display_icon_a_dis);
                        this.param4_title_text.setText(R.string.distance);
                        return;
                    }
                    if (i3 == 1) {
                        if (this.parentFragment.caloriesLayoutFlag == 0) {
                            this.param2_title_text.setText(R.string.calories);
                            this.param2_icon_image.setImageResource(R.drawable.s_display_icon_a_cal);
                        } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                            this.param2_title_text.setText(R.string.calories_hour);
                            this.param2_icon_image.setImageResource(R.drawable.s_display_icon_a_cal);
                        } else {
                            this.param2_title_text.setText(R.string.display_watts);
                            this.param2_icon_image.setImageResource(R.drawable.s_display_icon_a_cal);
                        }
                        this.param4_icon_image.setImageResource(R.drawable.s_display_icon_a_dis);
                        this.param5_icon_image.setImageResource(R.drawable.s_display_icon_a_watts);
                        this.param4_title_text.setText(R.string.distance);
                        this.param5_title_text.setText(R.string.display_watts);
                        return;
                    }
                    if (i3 != 2) {
                        return;
                    }
                    if (this.parentFragment.caloriesLayoutFlag == 0) {
                        this.param3_title_text.setText(R.string.calories);
                        this.param3_icon_image.setImageResource(R.drawable.s_display_icon_a_cal);
                    } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                        this.param3_title_text.setText(R.string.calories_hour);
                        this.param3_icon_image.setImageResource(R.drawable.s_display_icon_a_cal);
                    } else {
                        this.param3_title_text.setText(R.string.display_watts);
                        this.param3_icon_image.setImageResource(R.drawable.s_display_icon_a_cal);
                    }
                    this.param2_icon_image.setImageResource(R.drawable.s_display_icon_a_rpm);
                    this.param4_icon_image.setImageResource(R.drawable.s_display_icon_a_dis);
                    this.param5_icon_image.setImageResource(R.drawable.s_display_icon_a_watts);
                    this.param2_title_text.setText(R.string.display_rpm);
                    this.param4_title_text.setText(R.string.distance);
                    this.param5_title_text.setText(R.string.display_watts);
                    this.param3_include.setVisibility(0);
                    this.param3_line.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        int i4 = DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode];
        Log.e("getProgramMode", "setProgramMode : " + ProtocolHandler.protocol.setProgramMode);
        Log.e("getProgramMode", "mode : " + getResources().getString(i4));
        this.isHRMode = i4 == R.string.hr1 || i4 == R.string.hr2;
        int i5 = ProtocolHandler.protocol.deviceType;
        if (i5 == 0) {
            this.dashboard_right_1_title_textview.setText(R.string.display_pace);
            this.dashboard_right_2_title_textview.setText(R.string.display_speed);
            this.dashboard_left_1_title_textview.setText(R.string.display_incline);
            this.dashboard_left_2_title_textview.setText(R.string.display_distance);
            setRight1TextView(1);
            if (ProtocolHandler.protocol.salesVersion == 0) {
                setLeft1TextView(0);
                setRight2TextView(0);
            } else {
                setLeft1TextView(1);
                setRight2TextView(1);
            }
        } else if (i5 == 1) {
            this.dashboard_right_1_title_textview.setText(R.string.display_rpm);
            this.dashboard_right_2_title_textview.setText(R.string.display_speed);
            this.dashboard_left_1_title_textview.setText(R.string.display_level);
            this.dashboard_left_2_title_textview.setText(R.string.display_distance);
            setRight1TextView(1);
            setRight2TextView(1);
            if (ProtocolHandler.protocol.salesVersion == 0 && !this.isHRMode) {
                setLeft1TextView(0);
            } else {
                setLeft1TextView(1);
            }
        } else if (i5 == 2) {
            if (ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 30) {
                setLeft1TextView(1);
                setRight1TextView(1);
                setRight2TextView(1);
                if (ProtocolHandler.protocol.salesVersion == 0) {
                    if (!this.isHRMode) {
                        setRight2TextView(0);
                    } else {
                        setRight1TextView(1);
                    }
                } else {
                    setLeft1TextView(1);
                    setRight1TextView(1);
                }
                this.dashboard_left_1_title_textview.setTextSize(0, this.titleControlTextSize);
                this.dashboard_left_1_title_textview.setText(R.string.vert_ft_mtr);
                this.dashboard_left_2_title_textview.setTextSize(0, this.titleControlTextSize);
                this.dashboard_right_1_title_textview.setTextSize(0, this.titleControlTextSize);
                this.dashboard_left_2_title_textview.setText(R.string.steps_per_min);
                this.dashboard_right_1_title_textview.setText(R.string.total_steps);
                this.dashboard_right_2_title_textview.setText(R.string.display_level);
            } else if (ProtocolHandler.protocol.deviceModel == 31) {
                setLeft1TextView(1);
                setRight1TextView(1);
                setRight2TextView(1);
                if (ProtocolHandler.protocol.salesVersion == 0) {
                    if (!this.isHRMode) {
                        setRight2TextView(0);
                        setLeft1TextView(0);
                    } else {
                        setRight1TextView(1);
                        setLeft1TextView(1);
                    }
                } else {
                    setLeft1TextView(1);
                    setRight1TextView(1);
                }
                this.dashboard_left_1_title_textview.setTextSize(0, this.titleControlTextSize);
                this.dashboard_left_1_title_textview.setText(R.string.steps_height);
                this.dashboard_left_2_title_textview.setTextSize(0, this.titleControlTextSize);
                this.dashboard_right_1_title_textview.setTextSize(0, this.titleControlTextSize);
                this.dashboard_left_2_title_textview.setText(R.string.steps_per_min);
                this.dashboard_right_1_title_textview.setText(R.string.total_steps);
                this.dashboard_right_2_title_textview.setText(R.string.display_level);
            } else if (ProtocolHandler.protocol.deviceModel == 64) {
                setRight2TextView(1);
                if (ProtocolHandler.protocol.salesVersion == 0) {
                    setLeft1TextView(0);
                    if (!this.isHRMode) {
                        setRight1TextView(0);
                    } else {
                        setRight1TextView(1);
                    }
                } else {
                    setLeft1TextView(1);
                    setRight1TextView(1);
                }
                this.dashboard_left_1_title_textview.setTextSize(0, this.titleTextSize);
                this.dashboard_left_1_title_textview.setText(R.string.display_stride);
                this.dashboard_left_2_title_textview.setTextSize(0, this.titleTextSize);
                this.dashboard_right_1_title_textview.setTextSize(0, this.titleTextSize);
                this.dashboard_left_2_title_textview.setText(R.string.display_distance);
                this.dashboard_right_1_title_textview.setText(R.string.display_level);
                this.dashboard_right_2_title_textview.setText(R.string.display_pace);
            } else {
                setRight2TextView(1);
                if (ProtocolHandler.protocol.salesVersion == 0) {
                    setLeft1TextView(0);
                    if (!this.isHRMode) {
                        setRight1TextView(0);
                    } else {
                        setRight1TextView(1);
                    }
                } else {
                    setLeft1TextView(1);
                    setRight1TextView(1);
                }
                this.dashboard_left_1_title_textview.setTextSize(0, this.titleTextSize);
                this.dashboard_left_1_title_textview.setText(R.string.display_incline);
                this.dashboard_left_2_title_textview.setTextSize(0, this.titleTextSize);
                this.dashboard_right_1_title_textview.setTextSize(0, this.titleTextSize);
                this.dashboard_left_2_title_textview.setText(R.string.display_distance);
                this.dashboard_right_1_title_textview.setText(R.string.display_level);
                this.dashboard_right_2_title_textview.setText(R.string.speed);
            }
        }
        setBottomLayout();
        updateProgramImage();
        showProgramImage();
    }

    public void resetParams() {
        this.parentFragment.removeParamLayout();
        int i = ProtocolHandler.protocol.deviceType;
        if (i == 0) {
            this.dashboard_left_title_image.setImageResource(R.drawable.s_display_icon_a_level);
            this.dashboard_right_title_image.setImageResource(R.drawable.s_display_icon_a_rpm);
            this.parentFragment.addParamLayout(R.string.heart_rate, R.drawable.s_display_icon_a_hr);
            this.parentFragment.addParamLayout(R.string.display_calories, R.drawable.s_display_icon_a_cal);
            this.parentFragment.addParamLayout(R.string.display_distance, R.drawable.s_display_icon_a_dis);
            this.parentFragment.addParamLayout(R.string.display_pace, R.drawable.s_display_icon_a_laps);
        } else if (i == 1) {
            this.dashboard_left_title_image.setImageResource(R.drawable.s_display_icon_a_level);
            this.dashboard_right_title_image.setImageResource(R.drawable.s_display_icon_a_rpm);
            this.parentFragment.addParamLayout(R.string.heart_rate, R.drawable.s_display_icon_a_hr);
            this.parentFragment.addParamLayout(R.string.display_calories, R.drawable.s_display_icon_a_cal);
            this.parentFragment.addParamLayout(R.string.display_distance, R.drawable.s_display_icon_a_dis);
            this.parentFragment.addParamLayout(R.string.display_watts, R.drawable.s_display_icon_a_watts);
        } else if (i == 2) {
            this.dashboard_left_title_image.setImageResource(R.drawable.s_display_icon_a_incline_l);
            this.dashboard_right_title_image.setImageResource(R.drawable.s_display_icon_a_level);
            this.parentFragment.addParamLayout(R.string.heart_rate, R.drawable.s_display_icon_a_hr);
            this.parentFragment.addParamLayout(R.string.display_rpm, R.drawable.s_display_icon_a_rpm);
            this.parentFragment.addParamLayout(R.string.display_calories, R.drawable.s_display_icon_a_cal);
            this.parentFragment.addParamLayout(R.string.display_distance, R.drawable.s_display_icon_a_dis);
            this.parentFragment.addParamLayout(R.string.display_watts, R.drawable.s_display_icon_a_watts);
        }
        int i2 = Global.BRAND;
        if (i2 == 2) {
            int i3 = ProtocolHandler.protocol.deviceType;
            if (i3 != 0) {
                if (i3 != 2) {
                    return;
                }
                this.parentFragment.setUnitLayout(2, true);
                DisplayMainFragment displayMainFragment = this.parentFragment;
                displayMainFragment.setUnit(2, displayMainFragment.distanceUnitFlag, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                return;
            }
            if (this.parentFragment.speedUnitFlag) {
                changeRightViewToMI();
            } else {
                changeRightViewToKM();
            }
            this.parentFragment.setUnitLayout(2, true);
            DisplayMainFragment displayMainFragment2 = this.parentFragment;
            displayMainFragment2.setUnit(2, displayMainFragment2.distanceUnitFlag, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            return;
        }
        if (i2 == 3 && ProtocolHandler.protocol.deviceType == 0) {
            if (this.parentFragment.speedUnitFlag) {
                changeRightViewToMI();
            } else {
                changeRightViewToKM();
            }
            this.parentFragment.setUnitLayout(2, true);
            DisplayMainFragment displayMainFragment3 = this.parentFragment;
            displayMainFragment3.setUnit(2, displayMainFragment3.distanceUnitFlag, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
    }

    private void setLeft1TextView(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dashboard_left_1_number_textview.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.left_1_down_arrow_image.getLayoutParams();
        int dimension = (int) this.res.getDimension(R.dimen.dashboard_number_margin_bottom);
        if (i == 0) {
            this.dashboard_left_1_title_textview.setTextSize(0, this.titleControlTextSize);
            this.dashboard_left_1_number_textview.setTextSize(0, this.numberControlTextSize);
            this.left_1_up_arrow_image.setVisibility(0);
            this.left_1_down_arrow_image.setVisibility(0);
            layoutParams.bottomMargin = 0;
            layoutParams2.bottomMargin = dimension;
        } else if (i == 1) {
            this.dashboard_left_1_title_textview.setTextSize(0, this.titleTextSize);
            this.dashboard_left_1_number_textview.setTextSize(0, this.numberTextSize);
            this.left_1_up_arrow_image.setVisibility(8);
            this.left_1_down_arrow_image.setVisibility(8);
            layoutParams.bottomMargin = dimension;
            layoutParams2.bottomMargin = 0;
        }
        this.dashboard_left_1_number_textview.setLayoutParams(layoutParams);
        this.left_1_down_arrow_image.setLayoutParams(layoutParams2);
    }

    private void setRight1TextView(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dashboard_right_1_number_textview.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.right_1_down_arrow_image.getLayoutParams();
        int dimension = (int) this.res.getDimension(R.dimen.dashboard_number_margin_bottom);
        if (i == 0) {
            this.dashboard_right_1_title_textview.setTextSize(0, this.titleControlTextSize);
            this.dashboard_right_1_number_textview.setTextSize(0, this.numberControlTextSize);
            this.right_1_up_arrow_image.setVisibility(0);
            this.right_1_down_arrow_image.setVisibility(0);
            layoutParams.bottomMargin = 0;
            layoutParams2.bottomMargin = dimension;
        } else if (i == 1) {
            this.dashboard_right_1_title_textview.setTextSize(0, this.titleTextSize);
            this.dashboard_right_1_number_textview.setTextSize(0, this.numberTextSize);
            this.right_1_up_arrow_image.setVisibility(8);
            this.right_1_down_arrow_image.setVisibility(8);
            layoutParams.bottomMargin = dimension;
            layoutParams2.bottomMargin = 0;
        }
        this.dashboard_right_1_number_textview.setLayoutParams(layoutParams);
        this.right_1_down_arrow_image.setLayoutParams(layoutParams2);
    }

    private void setRight2TextView(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dashboard_right_2_number_textview.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.right_2_down_arrow_image.getLayoutParams();
        int dimension = (int) this.res.getDimension(R.dimen.dashboard_number_margin_bottom);
        if (i == 0) {
            this.dashboard_right_2_title_textview.setTextSize(0, this.titleControlTextSize);
            this.dashboard_right_2_number_textview.setTextSize(0, this.numberControlTextSize);
            this.right_2_up_arrow_image.setVisibility(0);
            this.right_2_down_arrow_image.setVisibility(0);
            layoutParams.bottomMargin = 0;
            layoutParams2.bottomMargin = dimension;
        } else if (i == 1) {
            this.dashboard_right_2_title_textview.setTextSize(0, this.titleTextSize);
            this.dashboard_right_2_number_textview.setTextSize(0, this.numberTextSize);
            this.right_2_up_arrow_image.setVisibility(8);
            this.right_2_down_arrow_image.setVisibility(8);
            layoutParams.bottomMargin = dimension;
            layoutParams2.bottomMargin = 0;
        }
        this.dashboard_right_2_number_textview.setLayoutParams(layoutParams);
        this.right_2_down_arrow_image.setLayoutParams(layoutParams2);
    }

    @Override // com.dyaco.sole.fragment.display.DisplayBaseLinearLayout
    public void updateWorkoutData(WorkoutData workoutData) {
        String strValueOf;
        float f;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        String str6;
        String strValueOf2;
        String str7;
        super.updateWorkoutData(workoutData);
        int minute = workoutData.getMinute();
        workoutData.getMinute();
        if (minute < 10) {
            strValueOf = "  " + String.valueOf(minute);
        } else {
            strValueOf = String.valueOf(minute);
        }
        String fillString = Global.getFillString(workoutData.getSeconds(), 2, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        float speed = workoutData.getSpeed();
        String.valueOf(speed);
        int nowIncline = workoutData.getNowIncline();
        float distance = workoutData.getDistance();
        String strValueOf3 = String.valueOf(new BigDecimal(distance).setScale(2, RoundingMode.HALF_UP).floatValue());
        int rpm = workoutData.getRpm();
        String strValueOf4 = String.valueOf(rpm);
        int nowLevel = workoutData.getNowLevel();
        String strValueOf5 = String.valueOf(nowLevel);
        String paceMinute = workoutData.getPaceMinute();
        String paceSeconds = workoutData.getPaceSeconds();
        int i2 = Integer.parseInt(paceMinute);
        float calHour = workoutData.getCalHour();
        workoutData.getCalSeconds();
        String strValueOf6 = String.valueOf(workoutData.getHeartRate());
        String strValueOf7 = String.valueOf(workoutData.getCalories());
        String str8 = strValueOf;
        String strValueOf8 = String.valueOf(workoutData.getWatt());
        String strValueOf9 = String.valueOf(workoutData.getMets());
        int i3 = Global.BRAND;
        if (i3 == 0) {
            String str9 = paceMinute;
            String strValueOf10 = String.valueOf(nowIncline);
            this.parentFragment.showControlView(-1);
            workoutData.setNowTargetHR(this.parentFragment.getNowTargetHR());
            this.dashboard_minute_textview.setText(str8);
            this.dashboard_seconds_textview.setText(fillString);
            this.dashboard_right_2_number_textview.setText(String.valueOf(speed));
            this.dashboard_left_2_number_textview.setText(strValueOf3);
            if (ProtocolHandler.protocol.deviceModel == 149 && ProtocolHandler.protocol.salesVersion == 0) {
                f = speed;
                this.display_dashboard_view.setRightLevelTT8View((int) f);
            } else {
                f = speed;
                if (ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 30 || ProtocolHandler.protocol.deviceModel == 31) {
                    this.display_dashboard_view.setRightLevelSC300View(workoutData.getSpm());
                } else {
                    this.display_dashboard_view.setRightLevelView((int) f);
                }
            }
            int i4 = ProtocolHandler.protocol.deviceType;
            if (i4 == 0) {
                this.dashboard_left_1_number_textview.setText(strValueOf10);
                if (i2 >= 100) {
                    this.dashboard_right_1_number_textview.setText(f != 0.0f ? str9 : "00:00");
                } else {
                    TypefaceTextView typefaceTextView = this.dashboard_right_1_number_textview;
                    if (f != 0.0f) {
                        str = str9 + CertificateUtil.DELIMITER + paceSeconds;
                    } else {
                        str = "00:00";
                    }
                    typefaceTextView.setText(str);
                }
                if (ProtocolHandler.protocol.deviceModel == 149) {
                    this.display_dashboard_view.setLeftLevelTT8View(nowIncline);
                    return;
                } else {
                    this.display_dashboard_view.setLeftLevelView(nowIncline);
                    return;
                }
            }
            if (i4 == 1) {
                this.dashboard_right_1_number_textview.setText(strValueOf4);
                this.dashboard_left_1_number_textview.setText(strValueOf5);
                this.display_dashboard_view.setLeftLevelView(workoutData.getNowLevel());
                return;
            }
            if (i4 != 2) {
                return;
            }
            if (ProtocolHandler.protocol.deviceModel >= 22 && ProtocolHandler.protocol.deviceModel <= 26) {
                this.display_dashboard_view.setLeftLevelE25E98View(nowIncline);
            } else if (ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 30 || ProtocolHandler.protocol.deviceModel == 31) {
                this.display_dashboard_view.setLeftLevelSc300View(convertStepHeightLevel(Global.divide(nowIncline, 10.0f, 1)));
            } else {
                this.display_dashboard_view.setLeftLevelView(nowIncline);
            }
            if (ProtocolHandler.protocol.deviceModel == 27 || ProtocolHandler.protocol.deviceModel == 64) {
                this.dashboard_left_1_number_textview.setText(String.valueOf(Global.divide(workoutData.getNowIncline(), 10.0f, 1)));
                if (i2 >= 100) {
                    TypefaceTextView typefaceTextView2 = this.dashboard_right_2_number_textview;
                    if (f == 0.0f) {
                        str9 = "00:00";
                    }
                    typefaceTextView2.setText(str9);
                } else {
                    TypefaceTextView typefaceTextView3 = this.dashboard_right_2_number_textview;
                    if (f != 0.0f) {
                        str2 = str9 + CertificateUtil.DELIMITER + paceSeconds;
                    } else {
                        str2 = "00:00";
                    }
                    typefaceTextView3.setText(str2);
                }
            }
            if (ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 30) {
                this.dashboard_left_1_number_textview.setText(String.valueOf(workoutData.getVert()));
                this.dashboard_left_2_number_textview.setText(String.valueOf(workoutData.getSpm()));
                this.dashboard_right_1_number_textview.setText(String.valueOf(workoutData.getTotalSteps()));
                this.dashboard_right_2_number_textview.setText(strValueOf5);
                return;
            }
            if (ProtocolHandler.protocol.deviceModel == 31) {
                this.dashboard_left_1_number_textview.setText(String.valueOf(workoutData.getNowIncline() / 10.0f));
                this.dashboard_left_2_number_textview.setText(String.valueOf(workoutData.getSpm()));
                this.dashboard_right_1_number_textview.setText(String.valueOf(workoutData.getTotalSteps()));
                this.dashboard_right_2_number_textview.setText(strValueOf5);
                return;
            }
            this.dashboard_left_1_number_textview.setText(strValueOf10);
            this.dashboard_right_1_number_textview.setText(strValueOf5);
            return;
        }
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            float f2 = ProtocolHandler.protocol.maxLevel / 9.0f;
            float f3 = ProtocolHandler.protocol.maxIncline / 9.0f;
            float f4 = ProtocolHandler.protocol.maxSpeed / 9.0f;
            float f5 = (ProtocolHandler.protocol.setWorkoutTime == 0 ? 99.0f : ProtocolHandler.protocol.setWorkoutTime) / 12.0f;
            this.parentFragment.speedUnitValue = speed;
            this.parentFragment.distanceUnitValue = distance;
            String strValueOf11 = String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.speedUnitFlag ? 1 : 0, speed));
            String str10 = String.format("%2.2f", Float.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.distanceUnitFlag ? 1 : 0, distance)));
            int i5 = ProtocolHandler.protocol.deviceType;
            if (i5 != 0) {
                if (i5 == 1) {
                    if (this.parentFragment.caloriesLayoutFlag == 0) {
                        this.parentFragment.caloriesValue = strValueOf7;
                        str6 = this.parentFragment.caloriesValue;
                    } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                        this.parentFragment.caloriesValue = Global.getScaleToString(calHour, 1);
                        str6 = this.parentFragment.caloriesValue;
                    } else {
                        this.parentFragment.caloriesValue = strValueOf8;
                        str6 = this.parentFragment.caloriesValue;
                    }
                    this.dashboard_left_value_text.setText(strValueOf5);
                    this.dashboard_right_value_text.setText(strValueOf4);
                    if (Global.BRAND == 1) {
                        this.dashboard_left_view.setLevel(nowLevel / f2);
                        this.dashboard_right_view.setLevel(rpm / 27.777779f);
                        this.param1_value_text.setText(strValueOf6);
                        this.param2_value_text.setText(str6);
                        this.param4_value_text.setText(str10);
                        this.param5_value_text.setText(strValueOf8);
                    } else {
                        this.x_dashboard_left_view.setLevel(nowLevel / f2);
                        this.x_dashboard_right_view.setLevel(rpm / 27.777779f);
                        this.parentFragment.setParamValue(0, strValueOf6);
                        this.parentFragment.setParamValue(1, str6);
                        this.parentFragment.setParamValue(2, str10);
                        this.parentFragment.setParamValue(3, strValueOf8);
                    }
                } else if (i5 != 2) {
                    i = 1;
                    str4 = CertificateUtil.DELIMITER;
                } else {
                    if (ProtocolHandler.protocol.showInclineMode == 1) {
                        strValueOf2 = String.valueOf(Global.divide(nowIncline, 2.0f, 1));
                    } else if (ProtocolHandler.protocol.showInclineMode == 2) {
                        strValueOf2 = String.valueOf(Global.divide(nowIncline, 2.0f, 1) + 18.0f);
                    } else {
                        strValueOf2 = String.valueOf(nowIncline);
                    }
                    if (this.parentFragment.caloriesLayoutFlag == 0) {
                        this.parentFragment.caloriesValue = strValueOf7;
                        str7 = this.parentFragment.caloriesValue;
                    } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                        this.parentFragment.caloriesValue = Global.getScaleToString(calHour, 1);
                        str7 = this.parentFragment.caloriesValue;
                    } else {
                        this.parentFragment.caloriesValue = strValueOf8;
                        str7 = this.parentFragment.caloriesValue;
                    }
                    this.dashboard_left_value_text.setText(strValueOf2);
                    this.dashboard_right_value_text.setText(strValueOf5);
                    if (Global.BRAND == 1) {
                        this.dashboard_left_view.setLevel(nowIncline / f3);
                        this.dashboard_right_view.setLevel(nowLevel / f2);
                        this.param1_value_text.setText(strValueOf6);
                        this.param2_value_text.setText(strValueOf4);
                        this.param3_value_text.setText(str7);
                        this.param4_value_text.setText(str10);
                        this.param5_value_text.setText(strValueOf8);
                    } else {
                        this.x_dashboard_left_view.setLevel(nowIncline / f3);
                        this.x_dashboard_right_view.setLevel(nowLevel / f2);
                        this.parentFragment.setParamValue(0, strValueOf6);
                        this.parentFragment.setParamValue(1, strValueOf4);
                        this.parentFragment.setParamValue(2, str7);
                        this.parentFragment.setParamValue(3, str10);
                        this.parentFragment.setParamValue(4, strValueOf8);
                    }
                }
                str4 = CertificateUtil.DELIMITER;
                i = 1;
            } else {
                int i6 = DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode];
                float f6 = nowIncline;
                this.dashboard_left_value_text.setText(String.valueOf(Global.divide(f6, 10.0f, 1)));
                this.dashboard_right_value_text.setText(strValueOf11);
                if (this.parentFragment.caloriesLayoutFlag == 0) {
                    this.parentFragment.caloriesValue = strValueOf7;
                    str3 = this.parentFragment.caloriesValue;
                } else {
                    this.parentFragment.caloriesValue = Global.getScaleToString(calHour, 1);
                    str3 = this.parentFragment.caloriesValue;
                }
                if (this.parentFragment.isPaceOrLapsUnitFlag) {
                    this.parentFragment.lapsUnitValue = strValueOf9;
                    str5 = this.parentFragment.lapsUnitValue;
                    str4 = CertificateUtil.DELIMITER;
                } else {
                    if (speed == 0.0f) {
                        str4 = CertificateUtil.DELIMITER;
                        this.parentFragment.paceUnitValue = "00:00";
                    } else if (i2 >= 100) {
                        this.parentFragment.paceUnitValue = paceMinute;
                        str4 = CertificateUtil.DELIMITER;
                    } else {
                        DisplayMainFragment displayMainFragment = this.parentFragment;
                        StringBuilder sb = new StringBuilder();
                        sb.append(paceMinute);
                        str4 = CertificateUtil.DELIMITER;
                        sb.append(str4);
                        sb.append(paceSeconds);
                        displayMainFragment.paceUnitValue = sb.toString();
                    }
                    str5 = this.parentFragment.paceUnitValue;
                }
                if (Global.BRAND == 1) {
                    this.dashboard_left_view.setLevel(f6 / f3);
                    this.dashboard_right_view.setLevel(speed / f4);
                    this.param1_value_text.setText(strValueOf6);
                    this.param2_value_text.setText(str3);
                    this.param4_value_text.setText(str10);
                    this.param5_value_text.setText(str5);
                    i = 1;
                } else {
                    this.x_dashboard_left_view.setLevel(f6 / f3);
                    this.x_dashboard_right_view.setLevel(speed / f4);
                    this.parentFragment.setParamValue(0, strValueOf6);
                    i = 1;
                    this.parentFragment.setParamValue(1, str3);
                    this.parentFragment.setParamValue(2, str10);
                    this.parentFragment.setParamValue(3, str5);
                }
            }
            if (Global.BRAND == i) {
                this.dashboard_center_view.setLevel(minute / f5);
            } else {
                this.x_dashboard_center_view.setLevel(minute / f5);
            }
            this.dashboard_center_value_text.setText(str8 + str4 + fillString);
        }
    }

    private int convertStepHeightLevel(float f) {
        int i;
        int i2 = 0;
        if (ProtocolHandler.protocol.deviceUnit == 0) {
            i = 0;
            while (i2 < Sole_DeviceModelList.stepHeightCMArr.length && f >= Sole_DeviceModelList.stepHeightCMArr[i2]) {
                int i3 = i2;
                i2++;
                i = i3;
            }
        } else {
            i = 0;
            while (i2 < Sole_DeviceModelList.stepHeightInArr.length && f >= Sole_DeviceModelList.stepHeightInArr[i2]) {
                int i4 = i2;
                i2++;
                i = i4;
            }
        }
        return i;
    }

    public void resetProfileImage() {
        updateProgramImage();
    }
}
