package com.dyaco.sole.fragment.programs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.dyaco.sole.R2;
import com.dyaco.sole.fragment.programs.ProgramGoalData;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class ProgramGoalCircleProgressView extends View {
    private static final int DEFAULT_ARC_COLOR = -3355444;
    private static final int DEFAULT_CIRCLE2_COLOR = -1;
    private static final int DEFAULT_CIRCLE_COLOR = -65536;
    public static final String TAG = "CircleView";
    private int _startAngle;
    private int _sweepAngle;
    private int arcColor;
    private float circle2percent;
    private float circle3percent;
    private float circle4percent;
    private int circleColor;
    private int circleColor2;
    private int circleColor3;
    private int circleColor4;
    private ProgramGoalData data;
    private Paint paint;

    public int getStartAngle() {
        return this._startAngle;
    }

    public void setStartAngle(int i) {
        this._startAngle = i;
    }

    public int getSweepAngle() {
        return this._sweepAngle;
    }

    public void setSweepAngle(int i) {
        this._sweepAngle = i;
    }

    public ProgramGoalCircleProgressView(Context context) {
        super(context);
        this.data = null;
        this.circleColor = -65536;
        this.circleColor2 = -1;
        this.circleColor3 = -65536;
        this.circleColor4 = -1;
        this.arcColor = DEFAULT_ARC_COLOR;
        this.circle2percent = 0.85f;
        this.circle3percent = 0.8f;
        this.circle4percent = 0.77f;
        this._startAngle = 0;
        this._sweepAngle = 135;
        init(context, null);
    }

    public ProgramGoalCircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.data = null;
        this.circleColor = -65536;
        this.circleColor2 = -1;
        this.circleColor3 = -65536;
        this.circleColor4 = -1;
        this.arcColor = DEFAULT_ARC_COLOR;
        this.circle2percent = 0.85f;
        this.circle3percent = 0.8f;
        this.circle4percent = 0.77f;
        this._startAngle = 0;
        this._sweepAngle = 135;
        init(context, attributeSet);
    }

    public ProgramGoalCircleProgressView(Context context, AttributeSet attributeSet, ProgramGoalData programGoalData) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.data = null;
        this.circleColor = -65536;
        this.circleColor2 = -1;
        this.circleColor3 = -65536;
        this.circleColor4 = -1;
        this.arcColor = DEFAULT_ARC_COLOR;
        this.circle2percent = 0.85f;
        this.circle3percent = 0.8f;
        this.circle4percent = 0.77f;
        this._startAngle = 0;
        this._sweepAngle = 135;
        init(context, attributeSet);
        setGoalData(programGoalData);
    }

    public ProgramGoalCircleProgressView(Context context, AttributeSet attributeSet, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(context, attributeSet);
        this.data = null;
        this.circleColor = -65536;
        this.circleColor2 = -1;
        this.circleColor3 = -65536;
        this.circleColor4 = -1;
        this.arcColor = DEFAULT_ARC_COLOR;
        this.circle2percent = 0.85f;
        this.circle3percent = 0.8f;
        this.circle4percent = 0.77f;
        this._startAngle = 0;
        this._sweepAngle = 135;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
    }

    public void setGoalData(ProgramGoalData programGoalData) throws Resources.NotFoundException {
        if (programGoalData != null) {
            Paint paint = new Paint();
            this.paint = paint;
            paint.setAntiAlias(true);
            int i = (int) ((programGoalData.goal_percent * 360.0f) / 100.0f);
            int color = getResources().getColor(R.color.blue);
            int color2 = getResources().getColor(R.color.colorGoal);
            int color3 = getResources().getColor(R.color.colorGoal_bg);
            Log.v(TAG, "setGoalData() dt.goal_id : " + programGoalData.goal_id + " dt.goal_percent : " + programGoalData.goal_percent + " percent_degree :" + i);
            int i2 = AnonymousClass1.$SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType[programGoalData.goal_state.ordinal()];
            if (i2 == 1) {
                color = getResources().getColor(R.color.colorGoalDone);
            } else if (i2 == 2) {
                color = getResources().getColor(R.color.colorGoalMiss);
            } else if (i2 == 3) {
                color = getResources().getColor(R.color.colorGoalProcessing);
            }
            int i3 = color;
            this.data = programGoalData;
            setRingParam(color2, color3, i3, color3, i3, R2.attr.firstBaselineToTopHeight, i);
        }
    }

    /* renamed from: com.dyaco.sole.fragment.programs.ProgramGoalCircleProgressView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType;

        static {
            int[] iArr = new int[ProgramGoalData.GoalStateType.values().length];
            $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType = iArr;
            try {
                iArr[ProgramGoalData.GoalStateType.Done.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType[ProgramGoalData.GoalStateType.Miss.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType[ProgramGoalData.GoalStateType.Processing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void setRingParam(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.circleColor = i;
        this.circleColor2 = i2;
        this.circleColor3 = i3;
        this.circleColor4 = i4;
        this.arcColor = i5;
        this._startAngle = i6;
        this._sweepAngle = i7;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.data != null) {
            canvas.drawColor(getResources().getColor(R.color.colorGoal_bg));
            drawBackgroundCircle(canvas);
            drawArc1(canvas);
            drawBackgroundCircle2(canvas);
            drawBackgroundCircle3(canvas);
            drawBackgroundCircle4(canvas);
        }
    }

    private void drawArc1(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float fMin = Math.min(width - (getPaddingLeft() + getPaddingRight()), height - (getPaddingTop() + getPaddingBottom())) / 2;
        Point point = new Point(width / 2, height / 2);
        new RectF().set(point.x - fMin, point.y - fMin, point.x + fMin, point.y + fMin);
        Paint paint = new Paint();
        RectF rectF = new RectF(point.x - fMin, point.y - fMin, point.x + fMin, point.y + fMin);
        paint.setColor(this.arcColor);
        canvas.drawArc(rectF, this._startAngle, this._sweepAngle, true, paint);
    }

    private void drawArc2(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float fMin = (Math.min(width - (getPaddingLeft() + getPaddingRight()), height - (getPaddingTop() + getPaddingBottom())) / 2) * this.circle2percent;
        Point point = new Point(width / 2, height / 2);
        new RectF().set(point.x - fMin, point.y - fMin, point.x + fMin, point.y + fMin);
        Paint paint = new Paint();
        RectF rectF = new RectF(point.x - fMin, point.y - fMin, point.x + fMin, point.y + fMin);
        paint.setColor(InputDeviceCompat.SOURCE_ANY);
        canvas.drawArc(rectF, this._startAngle, this._sweepAngle, true, paint);
    }

    private void drawArc(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float fMin = Math.min(width - (getPaddingLeft() + getPaddingRight()), height - (getPaddingTop() + getPaddingBottom())) / 2;
        Point point = new Point(width / 2, height / 2);
        new RectF().set(point.x - fMin, point.y - fMin, point.x + fMin, point.y + fMin);
        Paint paint = new Paint();
        RectF rectF = new RectF(point.x - fMin, point.y - fMin, point.x + fMin, point.y + fMin);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawArc(rectF, 15, 45, true, paint);
    }

    private void drawBackgroundCircle(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int iMin = Math.min(width - (paddingRight + paddingLeft), height - (getPaddingBottom() + getPaddingTop())) / 2;
        this.paint.setColor(this.circleColor);
        canvas.drawCircle(paddingLeft + (r0 / 2), r4 + (r1 / 2), iMin, this.paint);
    }

    private void drawBackgroundCircle2(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i = width - (paddingRight + paddingLeft);
        int paddingBottom = height - (getPaddingBottom() + getPaddingTop());
        this.paint.setColor(this.circleColor2);
        canvas.drawCircle(paddingLeft + (i / 2), r4 + (paddingBottom / 2), (Math.min(i, paddingBottom) / 2) * this.circle2percent, this.paint);
    }

    private void drawBackgroundCircle3(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i = width - (paddingRight + paddingLeft);
        int paddingBottom = height - (getPaddingBottom() + getPaddingTop());
        this.paint.setColor(this.circleColor3);
        canvas.drawCircle(paddingLeft + (i / 2), r4 + (paddingBottom / 2), (Math.min(i, paddingBottom) / 2) * this.circle3percent, this.paint);
    }

    private void drawBackgroundCircle4(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i = width - (paddingRight + paddingLeft);
        int paddingBottom = height - (getPaddingBottom() + getPaddingTop());
        this.paint.setColor(this.circleColor4);
        canvas.drawCircle(paddingLeft + (i / 2), r4 + (paddingBottom / 2), (Math.min(i, paddingBottom) / 2) * this.circle4percent, this.paint);
    }
}
