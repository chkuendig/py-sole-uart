package com.dyaco.sole.custom_view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.soletreadmills.sole.R;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class UserProfileView extends View {
    private static final int COLUMNS_COUNT = 8;
    public static final int SOLE_ROW_COUNT = 18;
    public static final int SPIRIT_XTERRA_ROW_COUNT = 20;
    private static final int S_COLUMNS_COUNT = 10;
    private Timer animationTimer;
    private int columnsCount;
    private float gridHeight;
    private RectF gridRectF;
    private float gridWidth;
    private Handler handler;
    private float heightSpacing;
    private boolean isAnimationShowing;
    private boolean isCustomProgram;
    private boolean isDrawing;
    private boolean isShownAnimation;
    private boolean isStartAnimation;
    private int nowShowAnimationPosition;
    private Paint paint;
    private ArrayList<Integer> programNowPositionArray;
    private ArrayList<ArrayList<ProgramPosition>> programsPositionArray;
    private float radius;
    private Resources res;
    private int rowCount;
    private int viewHeight;
    private int viewWidth;
    private float widthSpacing;

    public UserProfileView(Context context) {
        super(context);
        Resources resources = getResources();
        this.res = resources;
        this.widthSpacing = resources.getDimension(R.dimen.profiles_spacing_s);
        this.heightSpacing = this.res.getDimension(R.dimen.profiles_spacing_s);
        this.radius = 2.0f;
        this.paint = new Paint();
        this.nowShowAnimationPosition = -1;
        this.rowCount = 20;
        this.columnsCount = 8;
        this.handler = new Handler() { // from class: com.dyaco.sole.custom_view.UserProfileView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                UserProfileView.this.isShownAnimation = !r2.isShownAnimation;
                UserProfileView.this.invalidate();
            }
        };
    }

    public UserProfileView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.res = resources;
        this.widthSpacing = resources.getDimension(R.dimen.profiles_spacing_s);
        this.heightSpacing = this.res.getDimension(R.dimen.profiles_spacing_s);
        this.radius = 2.0f;
        this.paint = new Paint();
        this.nowShowAnimationPosition = -1;
        this.rowCount = 20;
        this.columnsCount = 8;
        this.handler = new Handler() { // from class: com.dyaco.sole.custom_view.UserProfileView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                UserProfileView.this.isShownAnimation = !r2.isShownAnimation;
                UserProfileView.this.invalidate();
            }
        };
    }

    public UserProfileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = getResources();
        this.res = resources;
        this.widthSpacing = resources.getDimension(R.dimen.profiles_spacing_s);
        this.heightSpacing = this.res.getDimension(R.dimen.profiles_spacing_s);
        this.radius = 2.0f;
        this.paint = new Paint();
        this.nowShowAnimationPosition = -1;
        this.rowCount = 20;
        this.columnsCount = 8;
        this.handler = new Handler() { // from class: com.dyaco.sole.custom_view.UserProfileView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                UserProfileView.this.isShownAnimation = !r2.isShownAnimation;
                UserProfileView.this.invalidate();
            }
        };
    }

    private void init(Canvas canvas) {
        this.viewWidth = canvas.getWidth();
        this.viewHeight = canvas.getHeight();
        this.gridRectF = new RectF();
        init();
    }

    private void init() {
        float f = this.viewWidth;
        float f2 = this.widthSpacing;
        this.gridWidth = (f - (f2 * (r2 + 1))) / this.rowCount;
        float f3 = this.viewHeight;
        float f4 = this.heightSpacing;
        this.gridHeight = (f3 - (f4 * (r2 + 1))) / this.columnsCount;
        initProgramArray();
        invalidate();
    }

    public void setProfileColor(int i) {
        this.paint.setColor(this.res.getColor(i));
    }

    private void initProgramArray() {
        ArrayList<ArrayList<ProgramPosition>> arrayList = this.programsPositionArray;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.programsPositionArray = new ArrayList<>();
        }
        int i = Global.BRAND;
        if (i == 0) {
            this.rowCount = 18;
            this.columnsCount = 8;
        } else if (i == 1 || i == 2 || i == 3) {
            this.rowCount = 20;
            this.columnsCount = 10;
        }
        float f = this.widthSpacing;
        for (int i2 = 0; i2 < this.rowCount; i2++) {
            float f2 = this.heightSpacing * this.columnsCount;
            ArrayList<ProgramPosition> arrayList2 = new ArrayList<>();
            for (int i3 = this.columnsCount - 1; i3 >= 0; i3--) {
                float f3 = this.gridWidth;
                float f4 = this.gridHeight;
                arrayList2.add(new ProgramPosition(f + (i2 * f3), (i3 * f4) + f2, f + (f3 * (i2 + 1)), f2 + (f4 * (i3 + 1))));
                f2 -= this.heightSpacing;
            }
            f += this.widthSpacing;
            this.programsPositionArray.add(arrayList2);
        }
    }

    public void resetProgramCount() {
        init();
        invalidate();
    }

    public ArrayList<Integer> getProgramNowPositionArray() {
        ArrayList<Integer> arrayList = this.programNowPositionArray;
        if (arrayList == null) {
            return null;
        }
        return (ArrayList) arrayList.clone();
    }

    public void setProgramNowManualPosition(int i, int i2) {
        ArrayList<Integer> arrayList = this.programNowPositionArray;
        if (arrayList != null && i < arrayList.size()) {
            int size = this.programNowPositionArray.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 >= i) {
                    this.programNowPositionArray.set(i3, Integer.valueOf(transformHeight(i2)));
                }
            }
        }
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004f, code lost:
    
        if (r11 != 127) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int transformHeight(int i) {
        int i2 = Global.BRAND;
        if (i2 != 0) {
            if (i2 != 1 && i2 != 2 && i2 != 3) {
                return i;
            }
            if (ProtocolHandler.protocol.deviceType == 0) {
                return i - 1;
            }
            if (ProtocolHandler.protocol.deviceType != 1 && ProtocolHandler.protocol.deviceType != 2) {
                return i;
            }
            switch (i) {
                case 1:
                case 2:
                default:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                case 6:
                    return 2;
                case 7:
                case 8:
                    return 3;
                case 9:
                case 10:
                    return 4;
                case 11:
                case 12:
                    return 5;
                case 13:
                case 14:
                    return 6;
                case 15:
                case 16:
                    return 7;
                case 17:
                case 18:
                    return 8;
                case 19:
                case 20:
                    return 9;
            }
        }
        if (ProtocolHandler.protocol.deviceType == 0) {
            if (i != 1) {
                if (i != 3) {
                    if (i != 7) {
                        if (i != 15) {
                            if (i != 31) {
                                if (i != 63) {
                                }
                                return 5;
                            }
                            return 4;
                        }
                        return 3;
                    }
                    return 2;
                }
                return 1;
            }
            return 0;
        }
        if (ProtocolHandler.protocol.deviceType != 1 && ProtocolHandler.protocol.deviceType != 2) {
            return i;
        }
        if (ProtocolHandler.protocol.deviceModel == 21) {
            return setHeight(i, 40);
        }
        switch (i) {
        }
    }

    private int setHeight(int i, int i2) {
        int i3 = i2 / 8;
        int i4 = (i - 1) / i3;
        Log.e("nowheight", "Math : " + (i / i3));
        Log.e("nowheight", "a_box : " + i4);
        if (i4 <= 0) {
            return 0;
        }
        if (i4 >= 7) {
            return 7;
        }
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setProgramNowPositionArray(ArrayList<Integer> arrayList, boolean z) {
        ArrayList<Integer> arrayList2 = arrayList != null ? (ArrayList) arrayList.clone() : null;
        this.programNowPositionArray = arrayList2;
        if (arrayList2 != null) {
            this.isCustomProgram = z;
            this.res = getResources();
            int i = Global.BRAND;
            if (i == 0) {
                this.widthSpacing = this.res.getDimension(R.dimen.profiles_spacing_s);
                this.heightSpacing = this.res.getDimension(R.dimen.profiles_spacing_s);
                this.radius = 1.5f;
            } else if (i == 1) {
                this.widthSpacing = this.res.getDimension(R.dimen.profiles_spacing_s);
                this.heightSpacing = 0.0f;
                this.radius = 0.0f;
            } else if (i == 2 || i == 3) {
            }
        }
        invalidate();
    }

    public void showProgramAnimation() {
        this.isStartAnimation = true;
        cancelProgramAnimation();
        if (this.isAnimationShowing) {
            return;
        }
        this.isAnimationShowing = true;
        Timer timer = new Timer();
        this.animationTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.dyaco.sole.custom_view.UserProfileView.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (UserProfileView.this.isStartAnimation) {
                    UserProfileView.this.handler.sendEmptyMessage(0);
                }
            }
        }, 1000L, 1000L);
    }

    public void startProgramAnimation() {
        this.isStartAnimation = true;
    }

    public void pauseProgramAnimation() {
        this.isStartAnimation = false;
        this.isShownAnimation = true;
        invalidate();
    }

    public void cancelProgramAnimation() {
        this.isShownAnimation = true;
        this.isAnimationShowing = false;
        Timer timer = this.animationTimer;
        if (timer != null) {
            timer.cancel();
            this.animationTimer = null;
        }
        invalidate();
    }

    public void setNowShowAnimationPosition(int i) {
        this.nowShowAnimationPosition = i % this.rowCount;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isCustomProgram || this.programNowPositionArray == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 2) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int size = this.programsPositionArray.size();
            for (int i = 0; i < size; i++) {
                if (i < size) {
                    ArrayList<ProgramPosition> arrayList = this.programsPositionArray.get(i);
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (i2 < size2) {
                            ProgramPosition programPosition = arrayList.get(i2);
                            if (y >= programPosition.getTop()) {
                                float f = x;
                                if (f >= programPosition.getLeft() && f <= programPosition.getRight()) {
                                    this.programNowPositionArray.set(i, Integer.valueOf(i2));
                                    invalidate();
                                    return true;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.isDrawing) {
            return;
        }
        this.isDrawing = true;
        super.onDraw(canvas);
        if (this.viewWidth == 0 || this.viewHeight == 0) {
            init(canvas);
        }
        if (this.programNowPositionArray != null) {
            int size = this.programsPositionArray.size();
            for (int i = 0; i < size; i++) {
                ArrayList<ProgramPosition> arrayList = this.programsPositionArray.get(i);
                int size2 = arrayList.size();
                if (i < this.programNowPositionArray.size()) {
                    int iIntValue = this.programNowPositionArray.get(i).intValue();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (this.nowShowAnimationPosition == i) {
                            while (iIntValue >= 0) {
                                ProgramPosition programPosition = arrayList.get(iIntValue);
                                this.gridRectF.set(programPosition.getLeft(), programPosition.getTop(), programPosition.getRight(), programPosition.getBottom());
                                if (this.isShownAnimation) {
                                    RectF rectF = this.gridRectF;
                                    float f = this.radius;
                                    canvas.drawRoundRect(rectF, f, f, this.paint);
                                }
                                iIntValue--;
                            }
                        } else {
                            while (iIntValue >= 0) {
                                ProgramPosition programPosition2 = arrayList.get(iIntValue);
                                this.gridRectF.set(programPosition2.getLeft(), programPosition2.getTop(), programPosition2.getRight(), programPosition2.getBottom());
                                RectF rectF2 = this.gridRectF;
                                float f2 = this.radius;
                                canvas.drawRoundRect(rectF2, f2, f2, this.paint);
                                iIntValue--;
                            }
                        }
                    }
                }
            }
        }
        this.isDrawing = false;
    }

    private class ProgramPosition {
        private float bottom;
        private float left;
        private float right;
        private float top;

        public ProgramPosition(float f, float f2, float f3, float f4) {
            this.left = f;
            this.top = f2;
            this.right = f3;
            this.bottom = f4;
        }

        public float getLeft() {
            return this.left;
        }

        public float getTop() {
            return this.top;
        }

        public float getRight() {
            return this.right;
        }

        public float getBottom() {
            return this.bottom;
        }
    }
}
