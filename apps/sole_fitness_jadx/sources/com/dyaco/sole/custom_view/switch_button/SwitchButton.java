package com.dyaco.sole.custom_view.switch_button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CompoundButton;
import com.dyaco.sole.R;
import com.dyaco.sole.custom_view.switch_button.AnimationController;
import com.dyaco.sole.custom_view.switch_button.Configuration;

/* loaded from: classes.dex */
public class SwitchButton extends CompoundButton {
    private static boolean SHOW_RECT = false;
    private boolean isAnimating;
    private AnimationController mAnimationController;
    private Rect mBackZone;
    private Rect mBounds;
    private float mCenterPos;
    private int mClickTimeout;
    private Configuration mConf;
    private boolean mIsChecked;
    private float mLastX;
    private SBAnimationListener mOnAnimateListener;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private Paint mRectPaint;
    private Rect mSafeZone;
    private RectF mSaveLayerZone;
    private float mStartX;
    private float mStartY;
    private Rect mThumbZone;
    private int mTouchSlop;

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.mOnAnimateListener = new SBAnimationListener();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchButton);
        Configuration configuration = this.mConf;
        configuration.setThumbMarginInPixel(typedArrayObtainStyledAttributes.getDimensionPixelSize(15, configuration.getDefaultThumbMarginInPixel()));
        Configuration configuration2 = this.mConf;
        configuration2.setThumbMarginInPixel(typedArrayObtainStyledAttributes.getDimensionPixelSize(19, configuration2.getThumbMarginTop()), typedArrayObtainStyledAttributes.getDimensionPixelSize(16, this.mConf.getThumbMarginBottom()), typedArrayObtainStyledAttributes.getDimensionPixelSize(17, this.mConf.getThumbMarginLeft()), typedArrayObtainStyledAttributes.getDimensionPixelSize(18, this.mConf.getThumbMarginRight()));
        this.mConf.setRadius(typedArrayObtainStyledAttributes.getInt(10, Configuration.Default.DEFAULT_RADIUS));
        this.mConf.setThumbWidthAndHeightInPixel(typedArrayObtainStyledAttributes.getDimensionPixelSize(20, -1), typedArrayObtainStyledAttributes.getDimensionPixelSize(14, -1));
        this.mConf.setMeasureFactor(typedArrayObtainStyledAttributes.getFloat(5, -1.0f));
        this.mConf.setInsetBounds(typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0));
        this.mAnimationController.setVelocity(typedArrayObtainStyledAttributes.getInteger(0, -1));
        fetchDrawableFromAttr(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    private void initView() {
        this.mConf = Configuration.getDefault(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mClickTimeout = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.mAnimationController = AnimationController.getDefault().init(this.mOnAnimateListener);
        this.mBounds = new Rect();
        if (SHOW_RECT) {
            Paint paint = new Paint();
            this.mRectPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
        }
    }

    private void fetchDrawableFromAttr(TypedArray typedArray) {
        Configuration configuration = this.mConf;
        if (configuration == null) {
            return;
        }
        configuration.setOffDrawable(fetchDrawable(typedArray, 7, 6, Configuration.Default.DEFAULT_OFF_COLOR));
        this.mConf.setOnDrawable(fetchDrawable(typedArray, 9, 8, Configuration.Default.DEFAULT_ON_COLOR));
        this.mConf.setThumbDrawable(fetchThumbDrawable(typedArray));
    }

    private Drawable fetchDrawable(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable != null) {
            return drawable;
        }
        int color = typedArray.getColor(i2, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.mConf.getRadius());
        gradientDrawable.setColor(color);
        return gradientDrawable;
    }

    private Drawable fetchThumbDrawable(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(12);
        if (drawable != null) {
            return drawable;
        }
        int color = typedArray.getColor(11, Configuration.Default.DEFAULT_THUMB_COLOR);
        int color2 = typedArray.getColor(13, Configuration.Default.DEFAULT_THUMB_PRESSED_COLOR);
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.mConf.getRadius());
        gradientDrawable.setColor(color);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(this.mConf.getRadius());
        gradientDrawable2.setColor(color2);
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public void setConfiguration(Configuration configuration) {
        if (this.mConf == null) {
            this.mConf = Configuration.getDefault(configuration.getDensity());
        }
        this.mConf.setOffDrawable(configuration.getOffDrawableWithFix());
        this.mConf.setOnDrawable(configuration.getOnDrawableWithFix());
        this.mConf.setThumbDrawable(configuration.getThumbDrawableWithFix());
        this.mConf.setThumbMarginInPixel(configuration.getThumbMarginTop(), configuration.getThumbMarginBottom(), configuration.getThumbMarginLeft(), configuration.getThumbMarginRight());
        this.mConf.setThumbWidthAndHeightInPixel(configuration.getThumbWidth(), configuration.getThumbHeight());
        this.mConf.setVelocity(configuration.getVelocity());
        this.mConf.setMeasureFactor(configuration.getMeasureFactor());
        this.mAnimationController.setVelocity(this.mConf.getVelocity());
        requestLayout();
        setup();
        setChecked(this.mIsChecked);
    }

    public Configuration getConfiguration() {
        return this.mConf;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    private void setup() {
        setupBackZone();
        setupSafeZone();
        setupThumbZone();
        setupDrawableBounds();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.mSaveLayerZone = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    private void setupSafeZone() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.mSafeZone == null) {
                this.mSafeZone = new Rect();
            }
            this.mSafeZone.set(getPaddingLeft() + (this.mConf.getThumbMarginLeft() > 0 ? this.mConf.getThumbMarginLeft() : 0), getPaddingTop() + (this.mConf.getThumbMarginTop() > 0 ? this.mConf.getThumbMarginTop() : 0), ((measuredWidth - getPaddingRight()) - (this.mConf.getThumbMarginRight() > 0 ? this.mConf.getThumbMarginRight() : 0)) + (-this.mConf.getShrinkX()), ((measuredHeight - getPaddingBottom()) - (this.mConf.getThumbMarginBottom() > 0 ? this.mConf.getThumbMarginBottom() : 0)) + (-this.mConf.getShrinkY()));
            this.mCenterPos = this.mSafeZone.left + (((this.mSafeZone.right - this.mSafeZone.left) - this.mConf.getThumbWidth()) / 2);
            return;
        }
        this.mSafeZone = null;
    }

    private void setupBackZone() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.mBackZone == null) {
                this.mBackZone = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.mConf.getThumbMarginLeft() > 0 ? 0 : -this.mConf.getThumbMarginLeft());
            int paddingRight = ((measuredWidth - getPaddingRight()) - (this.mConf.getThumbMarginRight() > 0 ? 0 : -this.mConf.getThumbMarginRight())) + (-this.mConf.getShrinkX());
            this.mBackZone.set(paddingLeft, getPaddingTop() + (this.mConf.getThumbMarginTop() > 0 ? 0 : -this.mConf.getThumbMarginTop()), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.mConf.getThumbMarginBottom() <= 0 ? -this.mConf.getThumbMarginBottom() : 0)) + (-this.mConf.getShrinkY()));
            return;
        }
        this.mBackZone = null;
    }

    private void setupThumbZone() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.mThumbZone == null) {
                this.mThumbZone = new Rect();
            }
            int thumbWidth = this.mIsChecked ? this.mSafeZone.right - this.mConf.getThumbWidth() : this.mSafeZone.left;
            int thumbWidth2 = this.mConf.getThumbWidth() + thumbWidth;
            int i = this.mSafeZone.top;
            this.mThumbZone.set(thumbWidth, i, thumbWidth2, this.mConf.getThumbHeight() + i);
            return;
        }
        this.mThumbZone = null;
    }

    private void setupDrawableBounds() {
        if (this.mBackZone != null) {
            this.mConf.getOnDrawable().setBounds(this.mBackZone);
            this.mConf.getOffDrawable().setBounds(this.mBackZone);
        }
        if (this.mThumbZone != null) {
            this.mConf.getThumbDrawable().setBounds(this.mThumbZone);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int thumbWidth = (int) ((this.mConf.getThumbWidth() * this.mConf.getMeasureFactor()) + getPaddingLeft() + getPaddingRight());
        int thumbMarginLeft = this.mConf.getThumbMarginLeft() + this.mConf.getThumbMarginRight();
        if (thumbMarginLeft > 0) {
            thumbWidth += thumbMarginLeft;
        }
        if (mode == 1073741824) {
            thumbWidth = Math.max(size, thumbWidth);
        } else if (mode == Integer.MIN_VALUE) {
            thumbWidth = Math.min(size, thumbWidth);
        }
        return thumbWidth + this.mConf.getInsetBounds().left + this.mConf.getInsetBounds().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int thumbHeight = this.mConf.getThumbHeight() + getPaddingTop() + getPaddingBottom();
        int thumbMarginTop = this.mConf.getThumbMarginTop() + this.mConf.getThumbMarginBottom();
        if (thumbMarginTop > 0) {
            thumbHeight += thumbMarginTop;
        }
        if (mode == 1073741824) {
            thumbHeight = Math.max(size, thumbHeight);
        } else if (mode == Integer.MIN_VALUE) {
            thumbHeight = Math.min(size, thumbHeight);
        }
        return thumbHeight + this.mConf.getInsetBounds().top + this.mConf.getInsetBounds().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.mConf.needShrink()) {
            this.mBounds.inset(this.mConf.getInsetX(), this.mConf.getInsetY());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.mConf.getInsetBounds().left, this.mConf.getInsetBounds().top);
        }
        boolean z = !isEnabled() && notStatableDrawable();
        if (z) {
            canvas.saveLayerAlpha(this.mSaveLayerZone, 127, 31);
        }
        this.mConf.getOffDrawable().draw(canvas);
        this.mConf.getOnDrawable().setAlpha(calcAlpha());
        this.mConf.getOnDrawable().draw(canvas);
        this.mConf.getThumbDrawable().draw(canvas);
        if (z) {
            canvas.restore();
        }
        if (SHOW_RECT) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.mBackZone, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.mSafeZone, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.mThumbZone, this.mRectPaint);
        }
    }

    private boolean notStatableDrawable() {
        return ((this.mConf.getThumbDrawable() instanceof StateListDrawable) && (this.mConf.getOnDrawable() instanceof StateListDrawable) && (this.mConf.getOffDrawable() instanceof StateListDrawable)) ? false : true;
    }

    private int calcAlpha() {
        int thumbWidth;
        Rect rect = this.mSafeZone;
        if (rect == null || rect.right == this.mSafeZone.left || (thumbWidth = (this.mSafeZone.right - this.mConf.getThumbWidth()) - this.mSafeZone.left) <= 0) {
            return 255;
        }
        return ((this.mThumbZone.left - this.mSafeZone.left) * 255) / thumbWidth;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isAnimating || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.mStartX;
        float y = motionEvent.getY() - this.mStartY;
        if (action == 0) {
            catchView();
            this.mStartX = motionEvent.getX();
            this.mStartY = motionEvent.getY();
            this.mLastX = this.mStartX;
            setPressed(true);
        } else if (action == 1) {
            setPressed(false);
            boolean statusBasedOnPos = getStatusBasedOnPos();
            float eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
            int i = this.mTouchSlop;
            if (x < i && y < i && eventTime < this.mClickTimeout) {
                performClick();
            } else {
                slideToChecked(statusBasedOnPos);
            }
        } else if (action == 2) {
            float x2 = motionEvent.getX();
            moveThumb((int) (x2 - this.mLastX));
            this.mLastX = x2;
        } else if (action == 3) {
        }
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.mThumbZone.left) > this.mCenterPos;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.mConf.needShrink()) {
            invalidate(this.mBounds);
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private void catchView() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.mThumbZone != null) {
            int measuredWidth = getMeasuredWidth();
            if (!z) {
                measuredWidth = -measuredWidth;
            }
            moveThumb(measuredWidth);
        }
        setCheckedInClass(z, z2);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean z) {
        if (z) {
            slideToChecked(!this.mIsChecked);
        } else {
            setChecked(!this.mIsChecked);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setDrawableState(this.mConf.getThumbDrawable());
        setDrawableState(this.mConf.getOnDrawable());
        setDrawableState(this.mConf.getOffDrawable());
    }

    private void setDrawableState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (onCheckedChangeListener == null) {
            throw new IllegalArgumentException("onCheckedChangeListener can not be null");
        }
        this.mOnCheckedChangeListener = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        setCheckedInClass(z, true);
    }

    private void setCheckedInClass(boolean z, boolean z2) {
        if (this.mIsChecked == z) {
            return;
        }
        this.mIsChecked = z;
        refreshDrawableState();
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeListener;
        if (onCheckedChangeListener == null || !z2) {
            return;
        }
        onCheckedChangeListener.onCheckedChanged(this, this.mIsChecked);
    }

    public void slideToChecked(boolean z) {
        if (this.isAnimating) {
            return;
        }
        this.mAnimationController.startAnimation(this.mThumbZone.left, z ? this.mSafeZone.right - this.mConf.getThumbWidth() : this.mSafeZone.left);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveThumb(int i) {
        int thumbWidth = this.mThumbZone.left + i;
        int thumbWidth2 = this.mThumbZone.right + i;
        if (thumbWidth < this.mSafeZone.left) {
            thumbWidth = this.mSafeZone.left;
            thumbWidth2 = thumbWidth + this.mConf.getThumbWidth();
        }
        if (thumbWidth2 > this.mSafeZone.right) {
            thumbWidth2 = this.mSafeZone.right;
            thumbWidth = thumbWidth2 - this.mConf.getThumbWidth();
        }
        moveThumbTo(thumbWidth, thumbWidth2);
    }

    private void moveThumbTo(int i, int i2) {
        Rect rect = this.mThumbZone;
        rect.set(i, rect.top, i2, this.mThumbZone.bottom);
        this.mConf.getThumbDrawable().setBounds(this.mThumbZone);
    }

    class SBAnimationListener implements AnimationController.OnAnimateListener {
        SBAnimationListener() {
        }

        @Override // com.dyaco.sole.custom_view.switch_button.AnimationController.OnAnimateListener
        public void onAnimationStart() {
            SwitchButton.this.isAnimating = true;
        }

        @Override // com.dyaco.sole.custom_view.switch_button.AnimationController.OnAnimateListener
        public boolean continueAnimating() {
            return SwitchButton.this.mThumbZone.right < SwitchButton.this.mSafeZone.right && SwitchButton.this.mThumbZone.left > SwitchButton.this.mSafeZone.left;
        }

        @Override // com.dyaco.sole.custom_view.switch_button.AnimationController.OnAnimateListener
        public void onFrameUpdate(int i) {
            SwitchButton.this.moveThumb(i);
            SwitchButton.this.postInvalidate();
        }

        @Override // com.dyaco.sole.custom_view.switch_button.AnimationController.OnAnimateListener
        public void onAnimateComplete() {
            SwitchButton switchButton = SwitchButton.this;
            switchButton.setCheckedInClass(switchButton.getStatusBasedOnPos());
            SwitchButton.this.isAnimating = false;
        }
    }
}
