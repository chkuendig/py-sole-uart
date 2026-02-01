package com.dyaco.sole.activity;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.core.view.GestureDetectorCompat;
import com.dyaco.sole.custom.DeviceModelList;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class SportTypeSetting {
    private final Context applicationContext;
    private final ToggleButton btn1;
    private final ToggleButton btn2;
    private final ToggleButton btn3;
    private final ToggleButton[] btnArr;
    private final Button btnType1;
    private final Button btnType2;
    private final Button btnType3;
    private final GestureDetectorCompat gestureDetector;
    private int[] imgArr;
    private final RelativeLayout mSportTypeSettingLayout;
    private final TextView sportTypeTitle;
    private String[] titleArr;
    private int typeCount = 3;
    private int curType = 1;

    public SportTypeSetting(Context context, RelativeLayout relativeLayout) {
        this.applicationContext = context;
        this.mSportTypeSettingLayout = relativeLayout;
        Button button = (Button) relativeLayout.findViewById(R.id.btnWalking);
        this.btnType1 = button;
        Button button2 = (Button) relativeLayout.findViewById(R.id.btnRunning);
        this.btnType2 = button2;
        Button button3 = (Button) relativeLayout.findViewById(R.id.btnCycling);
        this.btnType3 = button3;
        this.sportTypeTitle = (TextView) relativeLayout.findViewById(R.id.sportTypeTitle);
        ToggleButton toggleButton = (ToggleButton) relativeLayout.findViewById(R.id.btn1);
        this.btn1 = toggleButton;
        ToggleButton toggleButton2 = (ToggleButton) relativeLayout.findViewById(R.id.btn2);
        this.btn2 = toggleButton2;
        ToggleButton toggleButton3 = (ToggleButton) relativeLayout.findViewById(R.id.btn3);
        this.btn3 = toggleButton3;
        this.btnArr = new ToggleButton[]{toggleButton, toggleButton2, toggleButton3};
        initIndicatorBtnBG();
        this.gestureDetector = new GestureDetectorCompat(context, new MyGestureListener(relativeLayout.getId()));
        relativeLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.dyaco.sole.activity.SportTypeSetting.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return SportTypeSetting.this.gestureDetector.onTouchEvent(motionEvent);
            }
        });
        button.setOnTouchListener(new View.OnTouchListener() { // from class: com.dyaco.sole.activity.SportTypeSetting.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return SportTypeSetting.this.gestureDetector.onTouchEvent(motionEvent);
            }
        });
        button2.setOnTouchListener(new View.OnTouchListener() { // from class: com.dyaco.sole.activity.SportTypeSetting.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return SportTypeSetting.this.gestureDetector.onTouchEvent(motionEvent);
            }
        });
        button3.setOnTouchListener(new View.OnTouchListener() { // from class: com.dyaco.sole.activity.SportTypeSetting.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return SportTypeSetting.this.gestureDetector.onTouchEvent(motionEvent);
            }
        });
        this.titleArr = new String[]{context.getResources().getString(R.string.type_title_walk), context.getResources().getString(R.string.type_title_run), context.getResources().getString(R.string.type_title_bike)};
        this.imgArr = new int[]{R.drawable.outdoor_icon_walk_large, R.drawable.outdoor_icon_run_large, R.drawable.outdoor_icon_bike_large};
    }

    private void initIndicatorBtnBG() {
        for (ToggleButton toggleButton : this.btnArr) {
            toggleButton.setBackgroundResource(R.drawable.selector_cycle_dot);
        }
    }

    public int getCurrentSportType() {
        return this.curType;
    }

    public String getCurrentSportTypeTitle() {
        return this.titleArr[this.curType];
    }

    public int getCurrentSportTypeImgID() {
        return this.imgArr[this.curType];
    }

    public void updateSportType() {
        initIndicatorBtn();
        this.btnArr[this.curType].setChecked(true);
        int i = this.curType;
        if (i == 0) {
            this.sportTypeTitle.setText(this.titleArr[i]);
            this.btnType2.setBackgroundResource(R.drawable.outdoor_icon_walk_large);
            this.btnType1.setBackgroundResource(R.drawable.outdoor_icon_bike_large);
            this.btnType3.setBackgroundResource(R.drawable.outdoor_icon_run_large);
            return;
        }
        if (i == 1) {
            this.sportTypeTitle.setText(this.titleArr[i]);
            this.btnType2.setBackgroundResource(R.drawable.outdoor_icon_run_large);
            this.btnType1.setBackgroundResource(R.drawable.outdoor_icon_walk_large);
            this.btnType3.setBackgroundResource(R.drawable.outdoor_icon_bike_large);
            return;
        }
        if (i != 2) {
            return;
        }
        this.sportTypeTitle.setText(this.titleArr[i]);
        this.btnType2.setBackgroundResource(R.drawable.outdoor_icon_bike_large);
        this.btnType1.setBackgroundResource(R.drawable.outdoor_icon_run_large);
        this.btnType3.setBackgroundResource(R.drawable.outdoor_icon_walk_large);
    }

    private void initIndicatorBtn() {
        for (ToggleButton toggleButton : this.btnArr) {
            toggleButton.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNext() {
        this.curType = (this.curType + 1) % this.typeCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPre() {
        int i = this.curType - 1;
        int i2 = this.typeCount;
        this.curType = (i + i2) % i2;
    }

    public String getCurrentSportTypeName() {
        return DeviceModelList.programNamesForOutdoor[this.curType];
    }

    public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private int org_dx = 200;
        private final int viewID;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public MyGestureListener(int i) {
            this.viewID = i;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f > this.org_dx) {
                SportTypeSetting.this.showPre();
                SportTypeSetting.this.updateSportType();
            }
            if (f < (-this.org_dx)) {
                SportTypeSetting.this.showNext();
                SportTypeSetting.this.updateSportType();
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return super.onSingleTapConfirmed(motionEvent);
        }
    }
}
