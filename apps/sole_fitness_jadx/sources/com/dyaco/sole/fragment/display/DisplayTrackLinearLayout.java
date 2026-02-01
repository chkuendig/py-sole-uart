package com.dyaco.sole.fragment.display;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.dyaco.ideabussdk_sole.protocol.WorkoutData;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.TypefaceTextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.security.CertificateUtil;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class DisplayTrackLinearLayout extends DisplayBaseLinearLayout implements View.OnClickListener {
    private static final int[] RES_TRACK_IMAGE = {R.drawable.s_display_track_a_table_1, R.drawable.s_display_track_a_table_2, R.drawable.s_display_track_a_table_3, R.drawable.s_display_track_a_table_4, R.drawable.s_display_track_a_table_5, R.drawable.s_display_track_a_table_6, R.drawable.s_display_track_a_table_7, R.drawable.s_display_track_a_table_8, R.drawable.s_display_track_a_table_9, R.drawable.s_display_track_a_table_10, R.drawable.s_display_track_a_table_11, R.drawable.s_display_track_a_table_12, R.drawable.s_display_track_a_table_13, R.drawable.s_display_track_a_table_14, R.drawable.s_display_track_a_table_15, R.drawable.s_display_track_a_table_16, R.drawable.s_display_track_a_table_17, R.drawable.s_display_track_a_table_18, R.drawable.s_display_track_a_table_19, R.drawable.s_display_track_a_table_20, R.drawable.s_display_track_a_table_21, R.drawable.s_display_track_a_table_22, R.drawable.s_display_track_a_table_23, R.drawable.s_display_track_a_table_24, R.drawable.s_display_track_a_table_25, R.drawable.s_display_track_a_table_26, R.drawable.s_display_track_a_table_27, R.drawable.s_display_track_a_table_28, R.drawable.s_display_track_a_table_29, R.drawable.s_display_track_a_table_30, R.drawable.s_display_track_a_table_31, R.drawable.s_display_track_a_table_32, R.drawable.s_display_track_a_table_33, R.drawable.s_display_track_a_table_34, R.drawable.s_display_track_a_table_35, R.drawable.s_display_track_a_table_36, R.drawable.s_display_track_a_table_37, R.drawable.s_display_track_a_table_38, R.drawable.s_display_track_a_table_39, R.drawable.s_display_track_a_table_40, R.drawable.s_display_track_a_table_41, R.drawable.s_display_track_a_table_42, R.drawable.s_display_track_a_table_43, R.drawable.s_display_track_a_table_44, R.drawable.s_display_track_a_table_45, R.drawable.s_display_track_a_table_46, R.drawable.s_display_track_a_table_47, R.drawable.s_display_track_a_table_48};
    private static final int[] X_RES_TRACK_IMAGE = {R.drawable.x_display_track_a_table_1, R.drawable.x_display_track_a_table_2, R.drawable.x_display_track_a_table_3, R.drawable.x_display_track_a_table_4, R.drawable.x_display_track_a_table_5, R.drawable.x_display_track_a_table_6, R.drawable.x_display_track_a_table_7, R.drawable.x_display_track_a_table_8, R.drawable.x_display_track_a_table_9, R.drawable.x_display_track_a_table_10, R.drawable.x_display_track_a_table_11, R.drawable.x_display_track_a_table_12, R.drawable.x_display_track_a_table_13, R.drawable.x_display_track_a_table_14, R.drawable.x_display_track_a_table_15, R.drawable.x_display_track_a_table_16, R.drawable.x_display_track_a_table_17, R.drawable.x_display_track_a_table_18, R.drawable.x_display_track_a_table_19, R.drawable.x_display_track_a_table_20, R.drawable.x_display_track_a_table_21, R.drawable.x_display_track_a_table_22, R.drawable.x_display_track_a_table_23, R.drawable.x_display_track_a_table_24, R.drawable.x_display_track_a_table_25, R.drawable.x_display_track_a_table_26, R.drawable.x_display_track_a_table_27, R.drawable.x_display_track_a_table_28, R.drawable.x_display_track_a_table_29, R.drawable.x_display_track_a_table_30, R.drawable.x_display_track_a_table_31, R.drawable.x_display_track_a_table_32, R.drawable.x_display_track_a_table_33, R.drawable.x_display_track_a_table_34, R.drawable.x_display_track_a_table_35, R.drawable.x_display_track_a_table_36, R.drawable.x_display_track_a_table_37, R.drawable.x_display_track_a_table_38, R.drawable.x_display_track_a_table_39, R.drawable.x_display_track_a_table_40, R.drawable.x_display_track_a_table_41, R.drawable.x_display_track_a_table_42, R.drawable.x_display_track_a_table_43, R.drawable.x_display_track_a_table_44, R.drawable.x_display_track_a_table_45, R.drawable.x_display_track_a_table_46, R.drawable.x_display_track_a_table_47, R.drawable.x_display_track_a_table_48};
    private int countTest;
    private DisplayTrackView display_track_view;
    private float distanceTest;
    private View include_display_track_view;
    private boolean isTrackBgShow;
    private ImageView left_1_image;
    private TextView left_1_text;
    private TypefaceTextView left_1_title_text;
    private ImageView left_2_image;
    private View left_2_layout;
    private TextView left_2_text;
    private TypefaceTextView left_2_title_text;
    private View left_3_layout;
    private ImageView left_4_image;
    private View left_4_layout;
    private TextView left_4_text;
    private TypefaceTextView left_4_title_text;
    private View left_top_control_include;
    private TypefaceTextView left_top_number_text;
    private TypefaceTextView left_top_title_text;
    private View.OnClickListener onControlArrowClick;
    private DisplayMainFragment parentFragment;
    private ImageView right_1_image;
    private View right_1_layout;
    private TextView right_1_text;
    private TypefaceTextView right_1_title_text;
    private TypefaceTextView right_1_unit_1_text;
    private TypefaceTextView right_1_unit_2_text;
    private View right_1_unit_layout;
    private ImageView right_2_image;
    private View right_2_layout;
    private TextView right_2_text;
    private TypefaceTextView right_2_title_text;
    private TypefaceTextView right_2_unit_1_text;
    private TypefaceTextView right_2_unit_2_text;
    private View right_2_unit_layout;
    private ImageView right_3_image;
    private View right_3_layout;
    private TextView right_3_text;
    private TypefaceTextView right_3_title_text;
    private TypefaceTextView right_3_unit_1_text;
    private TypefaceTextView right_3_unit_2_text;
    private View right_3_unit_layout;
    private ImageView right_4_image;
    private TextView right_4_text;
    private TypefaceTextView right_4_title_text;
    private View right_bottom_control_include;
    private TypefaceTextView right_bottom_number_text;
    private TypefaceTextView right_bottom_title_text;
    private View right_top_control_include;
    private TypefaceTextView right_top_number_text;
    private TypefaceTextView right_top_title_text;
    private TextView time_text;
    private int totalPace;
    private ImageView track_bg_image;
    private View track_layout;
    private ImageView track_left_bottom_imageview;
    private TypefaceTextView track_left_bottom_number_textview;
    private TypefaceTextView track_left_bottom_title_textview;
    private ImageView track_left_top_imageview;
    private View track_left_top_layout;
    private TypefaceTextView track_left_top_number_textview;
    private TypefaceTextView track_left_top_title_textview;
    private TypefaceTextView track_minute_textview;
    private ImageView track_right_bottom_imageview;
    private View track_right_bottom_layout;
    private TypefaceTextView track_right_bottom_number_textview;
    private TypefaceTextView track_right_bottom_title_textview;
    private ImageView track_right_top_imageview;
    private View track_right_top_layout;
    private TypefaceTextView track_right_top_number_textview;
    private TypefaceTextView track_right_top_title_textview;
    private TypefaceTextView track_seconds_textview;

    @Override // com.dyaco.sole.fragment.display.DisplayBaseLinearLayout
    protected void setListeners() {
    }

    public DisplayTrackLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.distanceTest = 0.0f;
        this.countTest = 0;
        this.onControlArrowClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayTrackLinearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.d("TOM", "onclick:" + view.getId());
                ErrorLogSave.addErrorString(DisplayTrackLinearLayout.this.getContext(), ErrorLogSave.CLICK, "DisplayTrackLinearLayout_onControlArrowClick", "click_id:" + view.getId() + "_deivceType:" + ProtocolHandler.protocol.deviceType);
                switch (view.getId()) {
                    case 1:
                        int i = ProtocolHandler.protocol.deviceType;
                        if (i == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        } else if (i == 1) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        }
                        break;
                    case 2:
                        int i2 = ProtocolHandler.protocol.deviceType;
                        if (i2 == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        } else if (i2 == 1) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i2 == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        }
                        break;
                    case 3:
                        int i3 = ProtocolHandler.protocol.deviceType;
                        if (i3 == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i3 == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 4:
                        int i4 = ProtocolHandler.protocol.deviceType;
                        if (i4 == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i4 == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        }
                        break;
                    case 5:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 6:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        }
                        break;
                }
            }
        };
    }

    public DisplayTrackLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.distanceTest = 0.0f;
        this.countTest = 0;
        this.onControlArrowClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayTrackLinearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.d("TOM", "onclick:" + view.getId());
                ErrorLogSave.addErrorString(DisplayTrackLinearLayout.this.getContext(), ErrorLogSave.CLICK, "DisplayTrackLinearLayout_onControlArrowClick", "click_id:" + view.getId() + "_deivceType:" + ProtocolHandler.protocol.deviceType);
                switch (view.getId()) {
                    case 1:
                        int i2 = ProtocolHandler.protocol.deviceType;
                        if (i2 == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        } else if (i2 == 1) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i2 == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        }
                        break;
                    case 2:
                        int i22 = ProtocolHandler.protocol.deviceType;
                        if (i22 == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        } else if (i22 == 1) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i22 == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        }
                        break;
                    case 3:
                        int i3 = ProtocolHandler.protocol.deviceType;
                        if (i3 == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i3 == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 4:
                        int i4 = ProtocolHandler.protocol.deviceType;
                        if (i4 == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i4 == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        }
                        break;
                    case 5:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 6:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        }
                        break;
                }
            }
        };
    }

    public DisplayTrackLinearLayout(Context context, DisplayMainFragment displayMainFragment) {
        super(context, 0);
        this.distanceTest = 0.0f;
        this.countTest = 0;
        this.onControlArrowClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayTrackLinearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.d("TOM", "onclick:" + view.getId());
                ErrorLogSave.addErrorString(DisplayTrackLinearLayout.this.getContext(), ErrorLogSave.CLICK, "DisplayTrackLinearLayout_onControlArrowClick", "click_id:" + view.getId() + "_deivceType:" + ProtocolHandler.protocol.deviceType);
                switch (view.getId()) {
                    case 1:
                        int i2 = ProtocolHandler.protocol.deviceType;
                        if (i2 == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        } else if (i2 == 1) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i2 == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineUp();
                            break;
                        }
                        break;
                    case 2:
                        int i22 = ProtocolHandler.protocol.deviceType;
                        if (i22 == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        } else if (i22 == 1) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i22 == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setInclineDown();
                            break;
                        }
                        break;
                    case 3:
                        int i3 = ProtocolHandler.protocol.deviceType;
                        if (i3 == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        } else if (i3 == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 4:
                        int i4 = ProtocolHandler.protocol.deviceType;
                        if (i4 == 0) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        } else if (i4 == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
                            break;
                        }
                        break;
                    case 5:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelUp();
                            break;
                        }
                        break;
                    case 6:
                        if (ProtocolHandler.protocol.deviceType == 2) {
                            DisplayTrackLinearLayout.this.parentFragment.setLevelDown();
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
        setBottomLayout();
    }

    @Override // com.dyaco.sole.fragment.display.DisplayBaseLinearLayout
    protected void findViews() {
        View viewInflate = inflate(this.activity, R.layout.include_display_track, null);
        this.include_display_track_view = viewInflate;
        this.display_track_view = (DisplayTrackView) viewInflate.findViewById(R.id.display_track_view);
        this.track_minute_textview = (TypefaceTextView) this.include_display_track_view.findViewById(R.id.track_minute_textview);
        this.track_seconds_textview = (TypefaceTextView) this.include_display_track_view.findViewById(R.id.track_seconds_textview);
        this.track_left_top_title_textview = (TypefaceTextView) this.include_display_track_view.findViewById(R.id.track_left_top_title_textview);
        this.track_left_top_number_textview = (TypefaceTextView) this.include_display_track_view.findViewById(R.id.track_left_top_number_textview);
        this.track_left_bottom_title_textview = (TypefaceTextView) this.include_display_track_view.findViewById(R.id.track_left_bottom_title_textview);
        this.track_left_bottom_number_textview = (TypefaceTextView) this.include_display_track_view.findViewById(R.id.track_left_bottom_number_textview);
        this.track_right_top_title_textview = (TypefaceTextView) this.include_display_track_view.findViewById(R.id.track_right_top_title_textview);
        this.track_right_top_number_textview = (TypefaceTextView) this.include_display_track_view.findViewById(R.id.track_right_top_number_textview);
        this.track_right_bottom_title_textview = (TypefaceTextView) this.include_display_track_view.findViewById(R.id.track_right_bottom_title_textview);
        this.track_right_bottom_number_textview = (TypefaceTextView) this.include_display_track_view.findViewById(R.id.track_right_bottom_number_textview);
        ((FrameLayout) this.rootView.findViewById(R.id.display_content_layout)).addView(this.include_display_track_view);
    }

    @Override // com.dyaco.sole.fragment.display.DisplayBaseLinearLayout
    protected void initParams() {
        if (Global.BRAND != 0) {
            return;
        }
        View viewFindViewById = this.include_display_track_view.findViewById(R.id.track_layout);
        this.track_layout = viewFindViewById;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.gravity = 17;
        layoutParams.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_bg_width), 0.8f);
        layoutParams.height = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_bg_height), 0.8f);
        this.track_layout.setLayoutParams(layoutParams);
        View viewFindViewById2 = this.include_display_track_view.findViewById(R.id.track_horizontal_left_line);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams();
        layoutParams2.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_icon_size), 0.8f);
        viewFindViewById2.setLayoutParams(layoutParams2);
        View viewFindViewById3 = this.include_display_track_view.findViewById(R.id.track_horizontal_right_line);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) viewFindViewById3.getLayoutParams();
        layoutParams3.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_icon_size), 0.8f);
        viewFindViewById3.setLayoutParams(layoutParams3);
        this.track_minute_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_time_text_size), 0.8f));
        this.track_seconds_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_time_text_size), 0.8f));
        this.track_left_top_title_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_icon_title_text_size), 0.8f));
        this.track_left_top_number_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_text_size), 0.8f));
        ImageView imageView = (ImageView) this.include_display_track_view.findViewById(R.id.track_left_top_imageview);
        this.track_left_top_imageview = imageView;
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        int longScreenHeight = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_icon_size), 0.8f);
        layoutParams4.height = longScreenHeight;
        layoutParams4.width = longScreenHeight;
        this.track_left_top_imageview.setLayoutParams(layoutParams4);
        this.track_left_bottom_title_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_icon_title_text_size), 0.8f));
        this.track_left_bottom_number_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_text_size), 0.8f));
        ImageView imageView2 = (ImageView) this.include_display_track_view.findViewById(R.id.track_left_bottom_imageview);
        this.track_left_bottom_imageview = imageView2;
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) imageView2.getLayoutParams();
        int longScreenHeight2 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_icon_size), 0.8f);
        layoutParams5.height = longScreenHeight2;
        layoutParams5.width = longScreenHeight2;
        this.track_left_bottom_imageview.setLayoutParams(layoutParams5);
        this.track_right_top_title_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_icon_title_text_size), 0.8f));
        this.track_right_top_number_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_text_size), 0.8f));
        ImageView imageView3 = (ImageView) this.include_display_track_view.findViewById(R.id.track_right_top_imageview);
        this.track_right_top_imageview = imageView3;
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) imageView3.getLayoutParams();
        int longScreenHeight3 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_icon_size), 0.8f);
        layoutParams6.height = longScreenHeight3;
        layoutParams6.width = longScreenHeight3;
        this.track_right_top_imageview.setLayoutParams(layoutParams6);
        this.track_right_bottom_title_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_icon_title_text_size), 0.8f));
        this.track_right_bottom_number_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_text_size), 0.8f));
        ImageView imageView4 = (ImageView) this.include_display_track_view.findViewById(R.id.track_right_bottom_imageview);
        this.track_right_bottom_imageview = imageView4;
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) imageView4.getLayoutParams();
        int longScreenHeight4 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_icon_size), 0.8f);
        layoutParams7.height = longScreenHeight4;
        layoutParams7.width = longScreenHeight4;
        this.track_right_bottom_imageview.setLayoutParams(layoutParams7);
        this.track_minute_textview.setTypeface(this.activity, Global.fontsPath[0]);
        this.track_seconds_textview.setTypeface(this.activity, Global.fontsPath[0]);
        this.track_left_top_title_textview.setTypeface(this.activity, Global.fontsPath[1], 2);
        this.track_left_top_number_textview.setTypeface(this.activity, Global.fontsPath[0], 1);
        this.track_left_bottom_title_textview.setTypeface(this.activity, Global.fontsPath[1], 2);
        this.track_left_bottom_number_textview.setTypeface(this.activity, Global.fontsPath[0], 1);
        this.track_right_top_title_textview.setTypeface(this.activity, Global.fontsPath[1], 2);
        this.track_right_top_number_textview.setTypeface(this.activity, Global.fontsPath[0], 1);
        this.track_right_bottom_title_textview.setTypeface(this.activity, Global.fontsPath[1], 2);
        this.track_right_bottom_number_textview.setTypeface(this.activity, Global.fontsPath[0], 1);
        this.track_left_top_layout = this.track_layout.findViewById(R.id.track_left_top_layout);
        this.track_right_top_layout = this.track_layout.findViewById(R.id.track_right_top_layout);
        this.track_right_bottom_layout = this.track_layout.findViewById(R.id.track_right_bottom_layout);
        this.left_top_control_include = this.include_display_track_view.findViewById(R.id.left_top_control_include);
        this.right_top_control_include = this.include_display_track_view.findViewById(R.id.right_top_control_include);
        this.right_bottom_control_include = this.include_display_track_view.findViewById(R.id.right_bottom_control_include);
        this.left_top_title_text = (TypefaceTextView) this.left_top_control_include.findViewById(R.id.title_text);
        this.left_top_number_text = (TypefaceTextView) this.left_top_control_include.findViewById(R.id.number_text);
        this.right_top_title_text = (TypefaceTextView) this.right_top_control_include.findViewById(R.id.title_text);
        this.right_top_number_text = (TypefaceTextView) this.right_top_control_include.findViewById(R.id.number_text);
        this.right_bottom_title_text = (TypefaceTextView) this.right_bottom_control_include.findViewById(R.id.title_text);
        this.right_bottom_number_text = (TypefaceTextView) this.right_bottom_control_include.findViewById(R.id.number_text);
        this.left_top_title_text.setTypeface(this.activity, Global.fontsPath[1], 2);
        this.left_top_number_text.setTypeface(this.activity, Global.fontsPath[0], 1);
        this.right_top_title_text.setTypeface(this.activity, Global.fontsPath[1], 2);
        this.right_top_number_text.setTypeface(this.activity, Global.fontsPath[0], 1);
        this.right_bottom_title_text.setTypeface(this.activity, Global.fontsPath[1], 2);
        this.right_bottom_number_text.setTypeface(this.activity, Global.fontsPath[0], 1);
        this.left_top_title_text.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_icon_title_text_size), 0.8f));
        this.left_top_number_text.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_text_size), 0.8f));
        this.right_top_title_text.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_icon_title_text_size), 0.8f));
        this.right_top_number_text.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_text_size), 0.8f));
        this.right_bottom_title_text.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_icon_title_text_size), 0.8f));
        this.right_bottom_number_text.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_text_size), 0.8f));
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.left_top_title_text.getLayoutParams();
        layoutParams8.topMargin = (int) this.res.getDimension(R.dimen.display_track_control_title_margin_top);
        this.left_top_title_text.setLayoutParams(layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.right_top_title_text.getLayoutParams();
        layoutParams9.topMargin = (int) this.res.getDimension(R.dimen.display_track_control_title_margin_top);
        this.right_top_title_text.setLayoutParams(layoutParams9);
        this.left_top_title_text.setGravity(GravityCompat.START);
        this.right_top_title_text.setGravity(GravityCompat.END);
        this.right_bottom_title_text.setGravity(GravityCompat.END);
        View viewFindViewById4 = this.left_top_control_include.findViewById(R.id.left_arrow_image);
        View viewFindViewById5 = this.left_top_control_include.findViewById(R.id.right_arrow_image);
        View viewFindViewById6 = this.right_top_control_include.findViewById(R.id.left_arrow_image);
        View viewFindViewById7 = this.right_top_control_include.findViewById(R.id.right_arrow_image);
        View viewFindViewById8 = this.right_bottom_control_include.findViewById(R.id.left_arrow_image);
        View viewFindViewById9 = this.right_bottom_control_include.findViewById(R.id.right_arrow_image);
        viewFindViewById4.setId(1);
        viewFindViewById5.setId(2);
        viewFindViewById6.setId(3);
        viewFindViewById7.setId(4);
        viewFindViewById8.setId(5);
        viewFindViewById9.setId(6);
        viewFindViewById4.setOnClickListener(this.onControlArrowClick);
        viewFindViewById5.setOnClickListener(this.onControlArrowClick);
        viewFindViewById6.setOnClickListener(this.onControlArrowClick);
        viewFindViewById7.setOnClickListener(this.onControlArrowClick);
        viewFindViewById8.setOnClickListener(this.onControlArrowClick);
        viewFindViewById9.setOnClickListener(this.onControlArrowClick);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_2_layout /* 2131231350 */:
                ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "DisplayTrackLinearLayout_left_2", "click_deviceType:" + ProtocolHandler.protocol.deviceType);
                int i = ProtocolHandler.protocol.deviceType;
                if (i == 0) {
                    if (this.parentFragment.caloriesLayoutFlag == 0) {
                        this.left_2_title_text.setText(R.string.calories_hour);
                        this.parentFragment.caloriesLayoutFlag = 1;
                    } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                        this.left_2_title_text.setText(R.string.calories);
                        this.parentFragment.caloriesLayoutFlag = 0;
                    }
                    this.left_2_text.setText(this.parentFragment.caloriesValue);
                    break;
                } else if (i == 1) {
                    if (this.parentFragment.caloriesLayoutFlag == 0) {
                        this.left_2_title_text.setText(R.string.calories_hour);
                        this.parentFragment.caloriesLayoutFlag = 1;
                    } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                        this.left_2_title_text.setText(R.string.display_watts);
                        this.parentFragment.caloriesLayoutFlag = 2;
                    } else {
                        this.left_2_title_text.setText(R.string.calories);
                        this.parentFragment.caloriesLayoutFlag = 0;
                    }
                    this.left_2_text.setText(this.parentFragment.caloriesValue);
                    break;
                }
                break;
            case R.id.left_4_layout /* 2131231359 */:
                ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "DisplayTrackLinearLayout_left_4", "click_deviceType:" + ProtocolHandler.protocol.deviceType);
                if (ProtocolHandler.protocol.deviceType == 2) {
                    if (this.parentFragment.caloriesLayoutFlag == 0) {
                        this.left_4_title_text.setText(R.string.calories_hour);
                        this.parentFragment.caloriesLayoutFlag = 1;
                    } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                        this.left_4_title_text.setText(R.string.display_watts);
                        this.parentFragment.caloriesLayoutFlag = 2;
                    } else {
                        this.left_4_title_text.setText(R.string.calories);
                        this.parentFragment.caloriesLayoutFlag = 0;
                    }
                    this.left_4_text.setText(this.parentFragment.caloriesValue);
                    break;
                }
                break;
            case R.id.right_1_layout /* 2131231556 */:
                ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "DisplayTrackLinearLayout_right_1", "click_deviceType:" + ProtocolHandler.protocol.deviceType);
                int i2 = ProtocolHandler.protocol.deviceType;
                if (i2 == 0) {
                    if (this.parentFragment.speedUnitFlag) {
                        changeRight1ViewToMI();
                    } else {
                        changeRight1ViewToKM();
                    }
                    this.right_1_text.setText(String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.speedUnitFlag ? 1 : 0, this.parentFragment.speedUnitValue)));
                    this.parentFragment.speedUnitFlag = !r10.speedUnitFlag;
                    break;
                } else if (i2 == 1) {
                    if (this.parentFragment.speedUnitFlag) {
                        changeRight1ViewToMI();
                    } else {
                        changeRight1ViewToKM();
                    }
                    String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.speedUnitFlag ? 1 : 0, this.parentFragment.speedUnitValue));
                    this.parentFragment.speedUnitFlag = !r10.speedUnitFlag;
                    break;
                }
                break;
            case R.id.right_2_layout /* 2131231565 */:
                ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "DisplayTrackLinearLayout_right_2", "click_deviceType:" + ProtocolHandler.protocol.deviceType);
                int i3 = ProtocolHandler.protocol.deviceType;
                if (i3 == 0 || i3 == 1) {
                    if (this.parentFragment.distanceUnitFlag) {
                        changeRight2ViewToMI();
                    } else {
                        changeRight2ViewToKM();
                    }
                    this.right_2_text.setText(String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.distanceUnitFlag ? 1 : 0, this.parentFragment.distanceUnitValue)));
                    this.parentFragment.distanceUnitFlag = !r10.distanceUnitFlag;
                    break;
                }
            case R.id.right_3_layout /* 2131231573 */:
                ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "DisplayTrackLinearLayout_right_3", "click_deviceType:" + ProtocolHandler.protocol.deviceType);
                int i4 = ProtocolHandler.protocol.deviceType;
                if (i4 == 0) {
                    if (this.parentFragment.isPaceOrLapsUnitFlag) {
                        this.right_3_title_text.setText(this.res.getString(R.string.display_pace).toUpperCase());
                        this.right_3_text.setText("" + this.parentFragment.paceUnitValue);
                    } else {
                        this.right_3_title_text.setText(this.res.getString(R.string.laps).toUpperCase());
                        this.right_3_text.setText("" + this.parentFragment.lapsUnitValue);
                    }
                    this.right_3_image.setImageResource(R.drawable.s_display_icon_a_laps);
                    this.parentFragment.isPaceOrLapsUnitFlag = !r10.isPaceOrLapsUnitFlag;
                    break;
                } else if (i4 == 2) {
                    if (this.parentFragment.distanceUnitFlag) {
                        changeRight3ViewToMI();
                    } else {
                        changeRight3ViewToKM();
                    }
                    this.right_3_text.setText(String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.distanceUnitFlag ? 1 : 0, this.parentFragment.distanceUnitValue)));
                    this.parentFragment.distanceUnitFlag = !r10.distanceUnitFlag;
                    break;
                }
                break;
        }
    }

    private void changeRight1ViewToMI() {
        this.right_1_unit_1_text.setTextColor(this.res.getColor(R.color.black));
        this.right_1_unit_2_text.setTextColor(this.res.getColor(R.color.light_gray1));
    }

    private void changeRight1ViewToKM() {
        this.right_1_unit_1_text.setTextColor(this.res.getColor(R.color.light_gray1));
        this.right_1_unit_2_text.setTextColor(this.res.getColor(R.color.black));
    }

    private void changeRight2ViewToMI() {
        this.right_2_unit_1_text.setTextColor(this.res.getColor(R.color.black));
        this.right_2_unit_2_text.setTextColor(this.res.getColor(R.color.light_gray1));
    }

    private void changeRight2ViewToKM() {
        this.right_2_unit_1_text.setTextColor(this.res.getColor(R.color.light_gray1));
        this.right_2_unit_2_text.setTextColor(this.res.getColor(R.color.black));
    }

    private void changeRight3ViewToMI() {
        this.right_3_unit_1_text.setTextColor(this.res.getColor(R.color.black));
        this.right_3_unit_2_text.setTextColor(this.res.getColor(R.color.light_gray1));
    }

    private void changeRight3ViewToKM() {
        this.right_3_unit_1_text.setTextColor(this.res.getColor(R.color.light_gray1));
        this.right_3_unit_2_text.setTextColor(this.res.getColor(R.color.black));
    }

    public void onStart() {
        DisplayTrackView displayTrackView = this.display_track_view;
        if (displayTrackView != null) {
            displayTrackView.onStart(this.totalPace);
        }
    }

    public void onDestroy() {
        DisplayTrackView displayTrackView = this.display_track_view;
        if (displayTrackView != null) {
            displayTrackView.onDestroy();
        }
    }

    public void resetPace() {
        this.totalPace = 0;
    }

    @Override // com.dyaco.sole.fragment.display.DisplayBaseLinearLayout
    public void resetData() {
        Spanned spannedFromHtml;
        this.distanceTest = 0.0f;
        this.countTest = 0;
        String string = this.res.getString(R.string.display_incline);
        String string2 = this.res.getString(R.string.display_speed);
        String string3 = this.res.getString(R.string.display_level);
        int i = Global.BRAND;
        if (i != 0) {
            if (i != 1) {
                return;
            }
            View viewFindViewById = this.include_display_track_view.findViewById(R.id.left_3_line);
            View viewFindViewById2 = this.include_display_track_view.findViewById(R.id.right_4_layout);
            View viewFindViewById3 = this.include_display_track_view.findViewById(R.id.right_4_line);
            viewFindViewById.setVisibility(8);
            this.left_3_layout.setVisibility(8);
            this.right_1_unit_layout.setVisibility(4);
            this.right_2_unit_layout.setVisibility(4);
            this.right_3_unit_layout.setVisibility(4);
            DisplayMainFragment displayMainFragment = this.parentFragment;
            boolean z = ProtocolHandler.protocol.deviceUnit == 0;
            displayMainFragment.distanceUnitFlag = z;
            displayMainFragment.speedUnitFlag = z;
            if (this.parentFragment.speedUnitFlag) {
                changeRight1ViewToKM();
            } else {
                changeRight1ViewToMI();
            }
            if (this.parentFragment.distanceUnitFlag) {
                changeRight2ViewToKM();
            } else {
                changeRight2ViewToMI();
            }
            int i2 = ProtocolHandler.protocol.deviceType;
            if (i2 == 0) {
                this.right_1_unit_layout.setVisibility(0);
                this.right_2_unit_layout.setVisibility(0);
                if (this.parentFragment.caloriesLayoutFlag == 0) {
                    this.left_2_title_text.setText(R.string.calories);
                } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                    this.left_2_title_text.setText(R.string.calories_hour);
                }
                if (ProtocolHandler.protocol.showInclineMode == 2) {
                    this.left_1_title_text.setText(this.res.getString(R.string.stride).toUpperCase());
                } else {
                    this.left_1_image.setImageResource(R.drawable.s_display_icon_a_incline);
                    this.left_1_title_text.setText(string.toUpperCase());
                }
                this.left_2_image.setImageResource(R.drawable.s_display_icon_a_cal);
                this.left_4_image.setImageResource(R.drawable.s_display_icon_a_hr);
                this.right_1_image.setImageResource(R.drawable.s_display_icon_a_speed);
                this.right_2_image.setImageResource(R.drawable.s_display_icon_a_dis);
                this.right_3_image.setImageResource(R.drawable.s_display_icon_a_laps);
                this.right_4_image.setImageResource(R.drawable.s_display_icon_a_mets);
                this.left_4_title_text.setText(R.string.heart_rate);
                this.right_1_title_text.setText(this.res.getString(R.string.speed).toUpperCase());
                this.right_2_title_text.setText(R.string.distance);
                this.right_3_title_text.setText(this.res.getString(R.string.display_pace).toUpperCase());
                this.right_4_title_text.setText(R.string.mets);
                viewFindViewById2.setVisibility(0);
                viewFindViewById3.setVisibility(0);
                return;
            }
            if (i2 == 1) {
                this.right_2_unit_layout.setVisibility(0);
                if (this.parentFragment.caloriesLayoutFlag == 0) {
                    this.left_2_title_text.setText(R.string.calories);
                } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                    this.left_2_title_text.setText(R.string.calories_hour);
                } else {
                    this.left_2_title_text.setText(R.string.display_watts);
                }
                this.left_1_image.setImageResource(R.drawable.s_display_icon_a_level);
                this.left_2_image.setImageResource(R.drawable.s_display_icon_a_cal);
                this.left_4_image.setImageResource(R.drawable.s_display_icon_a_hr);
                this.right_1_image.setImageResource(R.drawable.s_display_icon_a_rpm);
                this.right_2_image.setImageResource(R.drawable.s_display_icon_a_dis);
                this.right_3_image.setImageResource(R.drawable.s_display_icon_a_laps);
                this.left_1_title_text.setText(this.res.getString(R.string.level).toUpperCase());
                this.left_2_title_text.setText(R.string.calories);
                this.left_4_title_text.setText(R.string.heart_rate);
                this.right_1_title_text.setText(R.string.display_rpm);
                this.right_2_title_text.setText(R.string.distance);
                this.right_3_title_text.setText(this.res.getString(R.string.laps).toUpperCase());
                viewFindViewById2.setVisibility(8);
                viewFindViewById3.setVisibility(8);
                return;
            }
            if (i2 != 2) {
                return;
            }
            this.right_3_unit_layout.setVisibility(0);
            if (this.parentFragment.caloriesLayoutFlag == 0) {
                this.left_4_title_text.setText(R.string.calories);
            } else if (this.parentFragment.caloriesLayoutFlag == 1) {
                this.left_4_title_text.setText(R.string.calories_hour);
            } else {
                this.left_4_title_text.setText(R.string.display_watts);
            }
            this.parentFragment.distanceUnitFlag = ProtocolHandler.protocol.deviceUnit == 0;
            if (this.parentFragment.distanceUnitFlag) {
                changeRight3ViewToKM();
            } else {
                changeRight3ViewToMI();
            }
            if (ProtocolHandler.protocol.showInclineMode == 2) {
                this.left_1_title_text.setText(this.res.getString(R.string.stride).toUpperCase());
            } else {
                this.left_1_image.setImageResource(R.drawable.s_display_icon_a_incline);
                this.left_1_title_text.setText(string.toUpperCase());
            }
            this.left_2_image.setImageResource(R.drawable.s_display_icon_a_level);
            this.left_4_image.setImageResource(R.drawable.s_display_icon_a_cal);
            this.right_1_image.setImageResource(R.drawable.s_display_icon_a_hr);
            this.right_2_image.setImageResource(R.drawable.s_display_icon_a_rpm);
            this.right_3_image.setImageResource(R.drawable.s_display_icon_a_dis);
            this.right_4_image.setImageResource(R.drawable.s_display_icon_a_laps);
            this.left_2_title_text.setText(this.res.getString(R.string.level).toUpperCase());
            this.right_1_title_text.setText(R.string.heart_rate);
            this.right_2_title_text.setText(R.string.display_rpm);
            this.right_3_title_text.setText(R.string.distance);
            this.right_4_title_text.setText(this.res.getString(R.string.laps).toUpperCase());
            viewFindViewById2.setVisibility(0);
            viewFindViewById3.setVisibility(0);
            return;
        }
        int i3 = DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode];
        this.isHRMode = i3 == R.string.hr1 || i3 == R.string.hr2;
        int i4 = ProtocolHandler.protocol.deviceType;
        if (i4 == 0) {
            this.track_right_bottom_number_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_track_number_text_size), 0.75f));
            this.track_left_top_title_textview.setText(string);
            this.track_left_bottom_title_textview.setText(R.string.display_distance);
            this.track_right_top_title_textview.setText(string2);
            this.track_right_bottom_title_textview.setText(R.string.display_pace);
            this.track_left_top_imageview.setImageResource(R.drawable.display_icon_a_incline);
            this.track_left_bottom_imageview.setImageResource(R.drawable.display_icon_a_distance);
            this.track_right_top_imageview.setImageResource(R.drawable.display_icon_a_speed);
            this.track_right_bottom_imageview.setImageResource(R.drawable.display_icon_a_pace);
            setRightBottomTextView(1, "");
            if (ProtocolHandler.protocol.salesVersion == 0) {
                setLeftTopTextView(0, string);
                setRightTopTextView(0, string2 + StringUtils.SPACE);
            } else {
                setLeftTopTextView(1, "");
                setRightTopTextView(1, "");
            }
        } else if (i4 == 1) {
            this.track_left_top_title_textview.setText(string3);
            this.track_left_bottom_title_textview.setText(R.string.display_distance);
            this.track_right_top_title_textview.setText(R.string.display_rpm);
            this.track_right_bottom_title_textview.setText(string2);
            this.track_left_top_imageview.setImageResource(R.drawable.display_icon_a_level);
            this.track_left_bottom_imageview.setImageResource(R.drawable.display_icon_a_distance);
            this.track_right_top_imageview.setImageResource(R.drawable.display_icon_a_rpm);
            this.track_right_bottom_imageview.setImageResource(R.drawable.display_icon_a_speed);
            setRightTopTextView(1, "");
            setRightBottomTextView(1, "");
            if (ProtocolHandler.protocol.salesVersion == 0 && !this.isHRMode) {
                setLeftTopTextView(0, string3);
            } else {
                setLeftTopTextView(1, "");
            }
        } else if (i4 == 2) {
            if (ProtocolHandler.protocol.deviceUnit == 0) {
                spannedFromHtml = Html.fromHtml(this.activity.getString(R.string.vert) + " <font color=\"#7B7B7B\">FT</font>/MTR");
            } else {
                spannedFromHtml = Html.fromHtml(this.activity.getString(R.string.vert) + " FT/<font color=\"#7B7B7B\">MTR</font>");
            }
            if (ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 30) {
                this.track_left_top_title_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_icon_title_text_size), 0.8f) * 0.9f);
                this.track_left_top_title_textview.setText(R.string.steps_per_min);
                this.track_left_bottom_title_textview.setText(R.string.total_steps);
                this.track_right_top_title_textview.setText(string3);
                this.track_right_bottom_title_textview.setText(spannedFromHtml);
                this.track_left_top_imageview.setImageResource(R.drawable.display_icon_a_pace);
                this.track_left_bottom_imageview.setImageResource(R.drawable.display_icon_a_total_steps);
                this.track_right_top_imageview.setImageResource(R.drawable.display_icon_a_level);
                this.track_right_bottom_imageview.setImageResource(R.drawable.display_icon_a_vert);
                setLeftTopTextView(1, "");
                setRightTopTextView(1, "");
                setRightBottomTextView(1, "");
                if (ProtocolHandler.protocol.salesVersion == 0) {
                    if (!this.isHRMode) {
                        setRightTopTextView(0, string3);
                        this.track_right_bottom_title_textview.setText(spannedFromHtml);
                    } else {
                        setRightBottomTextView(1, "");
                    }
                } else {
                    setLeftTopTextView(1, "");
                    setRightBottomTextView(1, "");
                }
            } else if (ProtocolHandler.protocol.deviceModel == 31) {
                this.track_left_top_title_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_icon_title_text_size), 0.8f) * 0.9f);
                this.track_left_top_title_textview.setText(R.string.steps_height);
                this.track_left_bottom_title_textview.setText(R.string.total_steps);
                this.track_right_top_title_textview.setText(string3);
                this.track_right_bottom_title_textview.setText(spannedFromHtml);
                this.track_left_top_imageview.setImageResource(R.drawable.display_icon_a_incline);
                this.track_left_bottom_imageview.setImageResource(R.drawable.display_icon_a_total_steps);
                this.track_right_top_imageview.setImageResource(R.drawable.display_icon_a_level);
                this.track_right_bottom_imageview.setImageResource(R.drawable.display_icon_a_vert);
                setLeftTopTextView(1, "");
                setRightTopTextView(1, "");
                setRightBottomTextView(1, "");
                if (ProtocolHandler.protocol.salesVersion == 0) {
                    if (!this.isHRMode) {
                        setLeftTopTextView(0, getResources().getString(R.string.steps_height));
                        setRightTopTextView(0, string3);
                        this.track_right_bottom_title_textview.setText(spannedFromHtml);
                    } else {
                        setRightBottomTextView(1, "");
                    }
                } else {
                    setLeftTopTextView(1, "");
                    setRightBottomTextView(1, "");
                }
            } else if (ProtocolHandler.protocol.deviceModel == 64) {
                this.track_left_top_title_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_icon_title_text_size), 0.8f));
                this.track_left_top_title_textview.setText(this.res.getString(R.string.display_stride));
                this.track_left_bottom_title_textview.setText(R.string.display_distance);
                this.track_right_top_title_textview.setText(this.res.getString(R.string.display_pace));
                this.track_right_bottom_title_textview.setText(string3);
                this.track_left_top_imageview.setImageResource(R.drawable.display_icon_a_incline);
                this.track_left_bottom_imageview.setImageResource(R.drawable.display_icon_a_distance);
                this.track_right_top_imageview.setImageResource(R.drawable.display_icon_a_speed);
                this.track_right_bottom_imageview.setImageResource(R.drawable.display_icon_a_level);
                setRightTopTextView(1, "");
                if (ProtocolHandler.protocol.salesVersion == 0) {
                    setLeftTopTextView(0, string);
                    if (!this.isHRMode) {
                        setLeftTopTextView(0, string);
                        setRightBottomTextView(0, string3 + StringUtils.SPACE);
                    } else {
                        setRightBottomTextView(1, "");
                    }
                } else {
                    setLeftTopTextView(1, "");
                    setRightBottomTextView(1, "");
                }
            } else {
                this.track_left_top_title_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_icon_title_text_size), 0.8f));
                this.track_left_top_title_textview.setText(string);
                this.track_left_bottom_title_textview.setText(R.string.display_distance);
                this.track_right_top_title_textview.setText(string2);
                this.track_right_bottom_title_textview.setText(string3);
                this.track_left_top_imageview.setImageResource(R.drawable.display_icon_a_incline);
                this.track_left_bottom_imageview.setImageResource(R.drawable.display_icon_a_distance);
                this.track_right_top_imageview.setImageResource(R.drawable.display_icon_a_speed);
                this.track_right_bottom_imageview.setImageResource(R.drawable.display_icon_a_level);
                setRightTopTextView(1, "");
                if (ProtocolHandler.protocol.salesVersion == 0) {
                    setLeftTopTextView(0, string);
                    if (!this.isHRMode) {
                        setLeftTopTextView(0, string);
                        setRightBottomTextView(0, string3 + StringUtils.SPACE);
                    } else {
                        setRightBottomTextView(1, "");
                    }
                } else {
                    setLeftTopTextView(1, "");
                    setRightBottomTextView(1, "");
                }
            }
        }
        this.display_track_view.resetView();
        setBottomLayout();
        updateProgramImage();
        showProgramImage();
    }

    public void resetParams() {
        this.parentFragment.removeParamLayout();
        int i = ProtocolHandler.protocol.deviceType;
        if (i == 0) {
            this.parentFragment.addParamLayout(R.string.display_incline, R.drawable.s_display_icon_a_incline);
            this.parentFragment.addParamLayout(R.string.display_calories, R.drawable.s_display_icon_a_cal);
            this.parentFragment.addParamLayout(R.string.heart_rate, R.drawable.s_display_icon_a_hr);
            this.parentFragment.addParamLayout(R.string.display_speed, R.drawable.s_display_icon_a_speed);
            this.parentFragment.addParamLayout(R.string.display_distance, R.drawable.s_display_icon_a_dis);
            this.parentFragment.addParamLayout(R.string.display_pace, R.drawable.s_display_icon_a_laps);
            this.parentFragment.addParamLayout(R.string.mets, R.drawable.s_display_icon_a_mets);
        } else if (i == 1) {
            this.parentFragment.addParamLayout(R.string.display_level, R.drawable.s_display_icon_a_level);
            this.parentFragment.addParamLayout(R.string.display_calories, R.drawable.s_display_icon_a_cal);
            this.parentFragment.addParamLayout(R.string.heart_rate, R.drawable.s_display_icon_a_hr);
            this.parentFragment.addParamLayout(R.string.display_rpm, R.drawable.s_display_icon_a_rpm);
            this.parentFragment.addParamLayout(R.string.display_distance, R.drawable.s_display_icon_a_dis);
            this.parentFragment.addParamLayout(R.string.laps, R.drawable.s_display_icon_a_laps);
        } else if (i == 2) {
            this.parentFragment.addParamLayout(R.string.display_incline, R.drawable.s_display_icon_a_incline);
            this.parentFragment.addParamLayout(R.string.display_level, R.drawable.s_display_icon_a_level);
            this.parentFragment.addParamLayout(R.string.display_calories, R.drawable.s_display_icon_a_cal);
            this.parentFragment.addParamLayout(R.string.heart_rate, R.drawable.s_display_icon_a_hr);
            this.parentFragment.addParamLayout(R.string.display_rpm, R.drawable.s_display_icon_a_rpm);
            this.parentFragment.addParamLayout(R.string.display_distance, R.drawable.s_display_icon_a_dis);
            this.parentFragment.addParamLayout(R.string.laps, R.drawable.s_display_icon_a_laps);
        }
        int i2 = Global.BRAND;
        if (i2 == 2) {
            int i3 = ProtocolHandler.protocol.deviceType;
            if (i3 != 0) {
                if (i3 != 2) {
                    return;
                }
                this.parentFragment.setUnitLayout(5, true);
                DisplayMainFragment displayMainFragment = this.parentFragment;
                displayMainFragment.setUnit(5, displayMainFragment.distanceUnitFlag, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                return;
            }
            this.parentFragment.setUnitLayout(3, true);
            this.parentFragment.setUnitLayout(4, true);
            DisplayMainFragment displayMainFragment2 = this.parentFragment;
            displayMainFragment2.setUnit(3, displayMainFragment2.speedUnitFlag, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            DisplayMainFragment displayMainFragment3 = this.parentFragment;
            displayMainFragment3.setUnit(4, displayMainFragment3.distanceUnitFlag, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            return;
        }
        if (i2 == 3 && ProtocolHandler.protocol.deviceType == 0) {
            this.parentFragment.setUnitLayout(3, true);
            this.parentFragment.setUnitLayout(4, true);
            DisplayMainFragment displayMainFragment4 = this.parentFragment;
            displayMainFragment4.setUnit(3, displayMainFragment4.speedUnitFlag, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            DisplayMainFragment displayMainFragment5 = this.parentFragment;
            displayMainFragment5.setUnit(4, displayMainFragment5.distanceUnitFlag, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
    }

    private void setLeftTopTextView(int i, String str) {
        if (i == 0) {
            this.track_left_top_layout.setVisibility(8);
            this.left_top_control_include.setVisibility(0);
            this.left_top_title_text.setText(str);
        } else {
            if (i != 1) {
                return;
            }
            this.track_left_top_layout.setVisibility(0);
            this.left_top_control_include.setVisibility(8);
        }
    }

    private void setRightTopTextView(int i, String str) {
        if (i == 0) {
            this.track_right_top_layout.setVisibility(8);
            this.right_top_control_include.setVisibility(0);
            this.right_top_title_text.setText(str);
        } else {
            if (i != 1) {
                return;
            }
            this.track_right_top_layout.setVisibility(0);
            this.right_top_control_include.setVisibility(8);
        }
    }

    private void setRightBottomTextView(int i, String str) {
        if (i == 0) {
            this.track_right_bottom_layout.setVisibility(8);
            this.right_bottom_control_include.setVisibility(0);
            this.right_bottom_title_text.setText(str);
        } else {
            if (i != 1) {
                return;
            }
            this.track_right_bottom_layout.setVisibility(0);
            this.right_bottom_control_include.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02f8  */
    @Override // com.dyaco.sole.fragment.display.DisplayBaseLinearLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateWorkoutData(WorkoutData workoutData) {
        String strValueOf;
        int i;
        super.updateWorkoutData(workoutData);
        int minute = workoutData.getMinute();
        int seconds = workoutData.getSeconds();
        if (minute < 10) {
            strValueOf = "  " + String.valueOf(minute);
        } else {
            strValueOf = String.valueOf(minute);
        }
        String fillString = Global.getFillString(seconds, 2, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        int nowIncline = workoutData.getNowIncline();
        float distance = workoutData.getDistance();
        float f = ProtocolHandler.protocol.deviceUnit == 0 ? 0.4f : 0.25f;
        String.valueOf(workoutData.getLaps());
        float speed = workoutData.getSpeed();
        String strValueOf2 = String.valueOf(speed);
        BigDecimal bigDecimalDivide = new BigDecimal(distance * 10000.0f).divide(new BigDecimal(f), 1, RoundingMode.HALF_UP);
        Log.e("checkPaceDecimal", bigDecimalDivide.intValue() + "");
        if (ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 30 || ProtocolHandler.protocol.deviceModel == 31) {
            bigDecimalDivide = new BigDecimal(((workoutData.getVert() * (ProtocolHandler.protocol.deviceUnit == 0 ? 1.0f : 0.304f)) / 1000.0f) * 10000.0f).divide(new BigDecimal(0.4000000059604645d), 1, RoundingMode.HALF_UP);
        }
        int iIntValue = bigDecimalDivide.intValue();
        String paceMinute = workoutData.getPaceMinute();
        String paceSeconds = workoutData.getPaceSeconds();
        int i2 = Integer.parseInt(paceMinute);
        workoutData.getCalHour();
        workoutData.getCalSeconds();
        String strValueOf3 = String.valueOf(new BigDecimal(distance).divide(new BigDecimal(1), 2, RoundingMode.HALF_UP).floatValue());
        String strValueOf4 = String.valueOf(workoutData.getRpm());
        String.valueOf(workoutData.getWatt());
        String strValueOf5 = String.valueOf(workoutData.getNowLevel());
        Logger.d("levelStr = " + strValueOf5);
        Logger.d("data.getNowLevel() = " + workoutData.getNowLevel());
        String.valueOf(workoutData.getCalories());
        String.valueOf(workoutData.getHeartRate());
        String.valueOf(workoutData.getMets());
        int i3 = ((int) ((distance * 100.0f) * (48.0f / (f * 100.0f)))) % 48;
        String strValueOf6 = String.valueOf(nowIncline);
        this.parentFragment.showControlView(-1);
        workoutData.setNowTargetHR(this.parentFragment.getNowTargetHR());
        this.track_minute_textview.setText(strValueOf);
        this.track_seconds_textview.setText(fillString);
        Log.e("checkPaceStep", "total : " + this.totalPace + " | custom : " + iIntValue);
        if (this.totalPace != iIntValue) {
            this.totalPace = iIntValue;
            this.track_left_bottom_number_textview.setText(strValueOf3);
            int i4 = ProtocolHandler.protocol.deviceUnit;
            this.display_track_view.setPace(this.totalPace);
        }
        String str = "00:00";
        if (i2 >= 100) {
            if (speed == 0.0f) {
            }
            i = ProtocolHandler.protocol.deviceType;
            if (i != 0) {
                if (ProtocolHandler.protocol.salesVersion == 0) {
                    this.left_top_number_text.setText(strValueOf6);
                    this.right_top_number_text.setText(strValueOf2);
                } else {
                    this.track_left_top_number_textview.setText(strValueOf6);
                    this.track_right_top_number_textview.setText(strValueOf2);
                }
                this.track_right_bottom_number_textview.setText(paceMinute);
                return;
            }
            if (i == 1) {
                if (ProtocolHandler.protocol.salesVersion == 0 && !this.isHRMode) {
                    this.left_top_number_text.setText(strValueOf5);
                } else {
                    this.track_left_top_number_textview.setText(strValueOf5);
                }
                this.track_right_top_number_textview.setText(strValueOf4);
                this.track_right_bottom_number_textview.setText(strValueOf2);
                return;
            }
            if (i != 2) {
                return;
            }
            String strValueOf7 = (ProtocolHandler.protocol.deviceModel == 27 || ProtocolHandler.protocol.deviceModel == 64) ? String.valueOf(Global.divide(workoutData.getNowIncline(), 10.0f, 1)) : strValueOf6;
            if (ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 30) {
                this.track_left_top_number_textview.setText(String.valueOf(workoutData.getSpm()));
                this.track_left_bottom_number_textview.setText(String.valueOf(workoutData.getTotalSteps()));
                this.track_right_bottom_number_textview.setText(String.valueOf(workoutData.getVert()));
                this.track_right_top_number_textview.setText(strValueOf5);
                this.right_top_number_text.setText(strValueOf5);
                return;
            }
            if (ProtocolHandler.protocol.deviceModel == 31) {
                this.track_left_top_number_textview.setText(String.valueOf(workoutData.getNowIncline() / 10.0f));
                this.left_top_number_text.setText(String.valueOf(workoutData.getNowIncline() / 10.0f));
                this.track_left_bottom_number_textview.setText(String.valueOf(workoutData.getTotalSteps()));
                this.track_right_bottom_number_textview.setText(String.valueOf(workoutData.getVert()));
                this.right_top_number_text.setText(strValueOf5);
                this.track_right_top_number_textview.setText(strValueOf5);
                return;
            }
            if (ProtocolHandler.protocol.deviceModel == 64) {
                this.track_right_top_number_textview.setText(paceMinute);
                this.track_left_top_number_textview.setText(strValueOf7);
                this.track_right_bottom_number_textview.setText(strValueOf5);
                return;
            }
            this.track_left_top_number_textview.setText(strValueOf7);
            this.track_right_top_number_textview.setText(strValueOf2);
            this.track_right_bottom_number_textview.setText(strValueOf5);
            if (ProtocolHandler.protocol.salesVersion == 0) {
                if (!this.isHRMode) {
                    this.right_bottom_number_text.setText(strValueOf5);
                }
                this.left_top_number_text.setText(strValueOf6);
                return;
            }
            return;
        }
        if (speed != 0.0f) {
            str = paceMinute + CertificateUtil.DELIMITER + paceSeconds;
        }
        paceMinute = str;
        i = ProtocolHandler.protocol.deviceType;
        if (i != 0) {
        }
    }

    public void resetProfileImage() {
        updateProgramImage();
    }
}
