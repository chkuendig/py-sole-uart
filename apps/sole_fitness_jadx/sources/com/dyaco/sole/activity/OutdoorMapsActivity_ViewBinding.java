package com.dyaco.sole.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.soletreadmills.sole.R;
import java.io.IOException;

/* loaded from: classes.dex */
public class OutdoorMapsActivity_ViewBinding implements Unbinder {
    private OutdoorMapsActivity target;
    private View view7f08007c;
    private View view7f080080;
    private View view7f080083;
    private View view7f080085;
    private View view7f080089;
    private View view7f08008a;
    private View view7f08008b;
    private View view7f08008c;
    private View view7f08008d;
    private View view7f08008e;
    private View view7f080090;
    private View view7f080091;
    private View view7f080092;
    private View view7f080238;
    private View view7f080244;
    private View view7f0802c0;
    private View view7f080400;
    private View view7f08042f;

    public OutdoorMapsActivity_ViewBinding(OutdoorMapsActivity outdoorMapsActivity) {
        this(outdoorMapsActivity, outdoorMapsActivity.getWindow().getDecorView());
    }

    public OutdoorMapsActivity_ViewBinding(final OutdoorMapsActivity outdoorMapsActivity, View view) {
        this.target = outdoorMapsActivity;
        outdoorMapsActivity.sportTypeSettingLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.sportTypeSettingLayout, "field 'sportTypeSettingLayout'", RelativeLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iconMusic, "field 'iconMusic' and method 'onClick'");
        outdoorMapsActivity.iconMusic = (ImageView) Utils.castView(viewFindRequiredView, R.id.iconMusic, "field 'iconMusic'", ImageView.class);
        this.view7f080238 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        outdoorMapsActivity.musicSelector = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.musicSelector, "field 'musicSelector'", RelativeLayout.class);
        outdoorMapsActivity.settingLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.settingLayout, "field 'settingLayout'", RelativeLayout.class);
        outdoorMapsActivity.tvDistance = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tvDistance, "field 'tvDistance'", LinearLayout.class);
        outdoorMapsActivity.tvDistanceValue = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDistanceValue, "field 'tvDistanceValue'", TextView.class);
        outdoorMapsActivity.tvDuration = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDuration, "field 'tvDuration'", TextView.class);
        outdoorMapsActivity.tvDurationValue = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDurationValue, "field 'tvDurationValue'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btnRgGo, "field 'btnRgGo' and method 'onClick'");
        outdoorMapsActivity.btnRgGo = (Button) Utils.castView(viewFindRequiredView2, R.id.btnRgGo, "field 'btnRgGo'", Button.class);
        this.view7f08008d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btnPause, "field 'btnPause' and method 'onClick'");
        outdoorMapsActivity.btnPause = (Button) Utils.castView(viewFindRequiredView3, R.id.btnPause, "field 'btnPause'", Button.class);
        this.view7f080089 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btnStop, "field 'btnStop' and method 'onClick'");
        outdoorMapsActivity.btnStop = (Button) Utils.castView(viewFindRequiredView4, R.id.btnStop, "field 'btnStop'", Button.class);
        this.view7f080091 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.imgMusicCover, "field 'imgCover' and method 'onClick'");
        outdoorMapsActivity.imgCover = (ImageView) Utils.castView(viewFindRequiredView5, R.id.imgMusicCover, "field 'imgCover'", ImageView.class);
        this.view7f080244 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        outdoorMapsActivity.musicPlayBar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.musicPlayBar, "field 'musicPlayBar'", RelativeLayout.class);
        outdoorMapsActivity.runningLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.runningLayout, "field 'runningLayout'", RelativeLayout.class);
        outdoorMapsActivity.activityOutdoorMaps = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.activity_OutdoorMaps, "field 'activityOutdoorMaps'", RelativeLayout.class);
        outdoorMapsActivity.outdoorWrapper321go = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.outdoor_wrapper_321go, "field 'outdoorWrapper321go'", RelativeLayout.class);
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.btnWalking, "field 'btnWalking' and method 'onClick'");
        outdoorMapsActivity.btnWalking = (Button) Utils.castView(viewFindRequiredView6, R.id.btnWalking, "field 'btnWalking'", Button.class);
        this.view7f080092 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.btnRunning, "field 'btnRunning' and method 'onClick'");
        outdoorMapsActivity.btnRunning = (Button) Utils.castView(viewFindRequiredView7, R.id.btnRunning, "field 'btnRunning'", Button.class);
        this.view7f08008e = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.btnCycling, "field 'btnCycling' and method 'onClick'");
        outdoorMapsActivity.btnCycling = (Button) Utils.castView(viewFindRequiredView8, R.id.btnCycling, "field 'btnCycling'", Button.class);
        this.view7f080080 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.btnGo, "field 'btnGo' and method 'onClick'");
        outdoorMapsActivity.btnGo = (Button) Utils.castView(viewFindRequiredView9, R.id.btnGo, "field 'btnGo'", Button.class);
        this.view7f080083 = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView10 = Utils.findRequiredView(view, R.id.btnBack, "field 'btnBack' and method 'onClick'");
        outdoorMapsActivity.btnBack = (Button) Utils.castView(viewFindRequiredView10, R.id.btnBack, "field 'btnBack'", Button.class);
        this.view7f08007c = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView11 = Utils.findRequiredView(view, R.id.btnRecordSelf, "field 'btnRecordSelf' and method 'onClick'");
        outdoorMapsActivity.btnRecordSelf = (Button) Utils.castView(viewFindRequiredView11, R.id.btnRecordSelf, "field 'btnRecordSelf'", Button.class);
        this.view7f08008c = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        outdoorMapsActivity.sportControlBar = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.sportControlBar, "field 'sportControlBar'", LinearLayout.class);
        outdoorMapsActivity.musicName = (TextView) Utils.findRequiredViewAsType(view, R.id.musicName, "field 'musicName'", TextView.class);
        View viewFindRequiredView12 = Utils.findRequiredView(view, R.id.btnPre, "field 'btnPre' and method 'onClick'");
        outdoorMapsActivity.btnPre = (Button) Utils.castView(viewFindRequiredView12, R.id.btnPre, "field 'btnPre'", Button.class);
        this.view7f08008b = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView13 = Utils.findRequiredView(view, R.id.btnPlayPause, "field 'btnPlayPause' and method 'onClick'");
        outdoorMapsActivity.btnPlayPause = (ToggleButton) Utils.castView(viewFindRequiredView13, R.id.btnPlayPause, "field 'btnPlayPause'", ToggleButton.class);
        this.view7f08008a = viewFindRequiredView13;
        viewFindRequiredView13.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView14 = Utils.findRequiredView(view, R.id.btnNext, "field 'btnNext' and method 'onClick'");
        outdoorMapsActivity.btnNext = (Button) Utils.castView(viewFindRequiredView14, R.id.btnNext, "field 'btnNext'", Button.class);
        this.view7f080085 = viewFindRequiredView14;
        viewFindRequiredView14.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.14
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView15 = Utils.findRequiredView(view, R.id.musicControlPanl, "field 'musicControlPanl' and method 'onClick'");
        outdoorMapsActivity.musicControlPanl = (RelativeLayout) Utils.castView(viewFindRequiredView15, R.id.musicControlPanl, "field 'musicControlPanl'", RelativeLayout.class);
        this.view7f0802c0 = viewFindRequiredView15;
        viewFindRequiredView15.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.15
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        View viewFindRequiredView16 = Utils.findRequiredView(view, R.id.tvMusicTitle, "field 'tvMusicTitle' and method 'onClick'");
        outdoorMapsActivity.tvMusicTitle = (TextView) Utils.castView(viewFindRequiredView16, R.id.tvMusicTitle, "field 'tvMusicTitle'", TextView.class);
        this.view7f08042f = viewFindRequiredView16;
        viewFindRequiredView16.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.16
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        outdoorMapsActivity.musicControlbar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.musicControlbar, "field 'musicControlbar'", RelativeLayout.class);
        outdoorMapsActivity.skbVolume = (SeekBar) Utils.findRequiredViewAsType(view, R.id.skbVolume, "field 'skbVolume'", SeekBar.class);
        outdoorMapsActivity.sportTypeTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.sportTypeTitle, "field 'sportTypeTitle'", TextView.class);
        outdoorMapsActivity.btn1 = (ToggleButton) Utils.findRequiredViewAsType(view, R.id.btn1, "field 'btn1'", ToggleButton.class);
        outdoorMapsActivity.btn2 = (ToggleButton) Utils.findRequiredViewAsType(view, R.id.btn2, "field 'btn2'", ToggleButton.class);
        outdoorMapsActivity.btn3 = (ToggleButton) Utils.findRequiredViewAsType(view, R.id.btn3, "field 'btn3'", ToggleButton.class);
        outdoorMapsActivity.sportTypeTitle2 = (TextView) Utils.findRequiredViewAsType(view, R.id.sportTypeTitle2, "field 'sportTypeTitle2'", TextView.class);
        outdoorMapsActivity.imgSportType2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.imgSportType2, "field 'imgSportType2'", ImageView.class);
        View viewFindRequiredView17 = Utils.findRequiredView(view, R.id.toggleBtnScaleRunningLayout, "field 'toggleBtnScaleRunningLayout' and method 'onClick'");
        outdoorMapsActivity.toggleBtnScaleRunningLayout = (ToggleButton) Utils.castView(viewFindRequiredView17, R.id.toggleBtnScaleRunningLayout, "field 'toggleBtnScaleRunningLayout'", ToggleButton.class);
        this.view7f080400 = viewFindRequiredView17;
        viewFindRequiredView17.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.17
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
        outdoorMapsActivity.tvDurationUnitTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDurationUnitTitle, "field 'tvDurationUnitTitle'", TextView.class);
        outdoorMapsActivity.tvDurationUnitTitle1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDurationUnitTitle1, "field 'tvDurationUnitTitle1'", TextView.class);
        outdoorMapsActivity.duration = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.duration, "field 'duration'", LinearLayout.class);
        View viewFindRequiredView18 = Utils.findRequiredView(view, R.id.btnShareMap, "field 'btnShareMap' and method 'onClick'");
        outdoorMapsActivity.btnShareMap = (Button) Utils.castView(viewFindRequiredView18, R.id.btnShareMap, "field 'btnShareMap'", Button.class);
        this.view7f080090 = viewFindRequiredView18;
        viewFindRequiredView18.setOnClickListener(new DebouncingOnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity_ViewBinding.18
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                outdoorMapsActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        OutdoorMapsActivity outdoorMapsActivity = this.target;
        if (outdoorMapsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        outdoorMapsActivity.sportTypeSettingLayout = null;
        outdoorMapsActivity.iconMusic = null;
        outdoorMapsActivity.musicSelector = null;
        outdoorMapsActivity.settingLayout = null;
        outdoorMapsActivity.tvDistance = null;
        outdoorMapsActivity.tvDistanceValue = null;
        outdoorMapsActivity.tvDuration = null;
        outdoorMapsActivity.tvDurationValue = null;
        outdoorMapsActivity.btnRgGo = null;
        outdoorMapsActivity.btnPause = null;
        outdoorMapsActivity.btnStop = null;
        outdoorMapsActivity.imgCover = null;
        outdoorMapsActivity.musicPlayBar = null;
        outdoorMapsActivity.runningLayout = null;
        outdoorMapsActivity.activityOutdoorMaps = null;
        outdoorMapsActivity.outdoorWrapper321go = null;
        outdoorMapsActivity.btnWalking = null;
        outdoorMapsActivity.btnRunning = null;
        outdoorMapsActivity.btnCycling = null;
        outdoorMapsActivity.btnGo = null;
        outdoorMapsActivity.btnBack = null;
        outdoorMapsActivity.btnRecordSelf = null;
        outdoorMapsActivity.sportControlBar = null;
        outdoorMapsActivity.musicName = null;
        outdoorMapsActivity.btnPre = null;
        outdoorMapsActivity.btnPlayPause = null;
        outdoorMapsActivity.btnNext = null;
        outdoorMapsActivity.musicControlPanl = null;
        outdoorMapsActivity.tvMusicTitle = null;
        outdoorMapsActivity.musicControlbar = null;
        outdoorMapsActivity.skbVolume = null;
        outdoorMapsActivity.sportTypeTitle = null;
        outdoorMapsActivity.btn1 = null;
        outdoorMapsActivity.btn2 = null;
        outdoorMapsActivity.btn3 = null;
        outdoorMapsActivity.sportTypeTitle2 = null;
        outdoorMapsActivity.imgSportType2 = null;
        outdoorMapsActivity.toggleBtnScaleRunningLayout = null;
        outdoorMapsActivity.tvDurationUnitTitle = null;
        outdoorMapsActivity.tvDurationUnitTitle1 = null;
        outdoorMapsActivity.duration = null;
        outdoorMapsActivity.btnShareMap = null;
        this.view7f080238.setOnClickListener(null);
        this.view7f080238 = null;
        this.view7f08008d.setOnClickListener(null);
        this.view7f08008d = null;
        this.view7f080089.setOnClickListener(null);
        this.view7f080089 = null;
        this.view7f080091.setOnClickListener(null);
        this.view7f080091 = null;
        this.view7f080244.setOnClickListener(null);
        this.view7f080244 = null;
        this.view7f080092.setOnClickListener(null);
        this.view7f080092 = null;
        this.view7f08008e.setOnClickListener(null);
        this.view7f08008e = null;
        this.view7f080080.setOnClickListener(null);
        this.view7f080080 = null;
        this.view7f080083.setOnClickListener(null);
        this.view7f080083 = null;
        this.view7f08007c.setOnClickListener(null);
        this.view7f08007c = null;
        this.view7f08008c.setOnClickListener(null);
        this.view7f08008c = null;
        this.view7f08008b.setOnClickListener(null);
        this.view7f08008b = null;
        this.view7f08008a.setOnClickListener(null);
        this.view7f08008a = null;
        this.view7f080085.setOnClickListener(null);
        this.view7f080085 = null;
        this.view7f0802c0.setOnClickListener(null);
        this.view7f0802c0 = null;
        this.view7f08042f.setOnClickListener(null);
        this.view7f08042f = null;
        this.view7f080400.setOnClickListener(null);
        this.view7f080400 = null;
        this.view7f080090.setOnClickListener(null);
        this.view7f080090 = null;
    }
}
