package com.weigan.loopview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.android.utils.XmlUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class LoopView extends View {
    private static final float DEFAULT_LINE_SPACE = 1.0f;
    private static final int DEFAULT_VISIBLE_ITEMS = 9;
    public static final int SCROLL_STATE_DRAGGING = 2;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SCROLLING = 3;
    public static final int SCROLL_STATE_SETTING = 1;
    int centerTextColor;
    int change;
    private Context context;
    int currentScrollState;
    int dividerColor;
    HashMap<Integer, IndexString> drawingStrings;
    int firstLineY;
    private GestureDetector flingGestureDetector;
    int halfCircumference;
    Handler handler;
    int initPosition;
    private boolean isEnableCurve;
    boolean isLoop;
    int itemTextHeight;
    List<IndexString> items;
    int itemsVisibleCount;
    int lastScrollState;
    float lineSpacingMultiplier;
    ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private int mOffset;
    OnItemScrollListener mOnItemScrollListener;
    int measuredHeight;
    int measuredWidth;
    OnItemSelectedListener onItemSelectedListener;
    int outerTextColor;
    private int paddingLeft;
    private int paddingRight;
    private Paint paintCenterText;
    private Paint paintIndicator;
    private Paint paintOuterText;
    int preCurrentIndex;
    private float previousY;
    int radius;
    private float scaleX;
    int secondLineY;
    long startTime;
    private Rect tempRect;
    int textHeight;
    int textSize;
    int totalScrollY;
    private Typeface typeface;
    private static final int DEFAULT_TEXT_SIZE = (int) (Resources.getSystem().getDisplayMetrics().density * 15.0f);
    private static boolean ENABLE_CURVE = true;

    public enum ACTION {
        CLICK,
        FLING,
        DRAG
    }

    public void setLineSpacingMultiplier(float lineSpacingMultiplier) {
        if (lineSpacingMultiplier > 1.0f) {
            this.lineSpacingMultiplier = lineSpacingMultiplier;
        }
    }

    public void setCenterTextColor(int centerTextColor) {
        this.centerTextColor = centerTextColor;
        Paint paint = this.paintCenterText;
        if (paint != null) {
            paint.setColor(centerTextColor);
        }
    }

    public void setOuterTextColor(int outerTextColor) {
        this.outerTextColor = outerTextColor;
        Paint paint = this.paintOuterText;
        if (paint != null) {
            paint.setColor(outerTextColor);
        }
    }

    public void setDividerColor(int dividerColor) {
        this.dividerColor = dividerColor;
        Paint paint = this.paintIndicator;
        if (paint != null) {
            paint.setColor(dividerColor);
        }
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    public LoopView(Context context) {
        super(context);
        this.scaleX = 1.05f;
        this.lastScrollState = 0;
        this.currentScrollState = 1;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mOffset = 0;
        this.startTime = 0L;
        this.tempRect = new Rect();
        this.typeface = Typeface.MONOSPACE;
        this.isEnableCurve = ENABLE_CURVE;
        initLoopView(context, null);
    }

    public LoopView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        this.scaleX = 1.05f;
        this.lastScrollState = 0;
        this.currentScrollState = 1;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mOffset = 0;
        this.startTime = 0L;
        this.tempRect = new Rect();
        this.typeface = Typeface.MONOSPACE;
        this.isEnableCurve = ENABLE_CURVE;
        initLoopView(context, attributeset);
    }

    public LoopView(Context context, AttributeSet attributeset, int defStyleAttr) {
        super(context, attributeset, defStyleAttr);
        this.scaleX = 1.05f;
        this.lastScrollState = 0;
        this.currentScrollState = 1;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mOffset = 0;
        this.startTime = 0L;
        this.tempRect = new Rect();
        this.typeface = Typeface.MONOSPACE;
        this.isEnableCurve = ENABLE_CURVE;
        initLoopView(context, attributeset);
    }

    private void initLoopView(Context context, AttributeSet attributeset) {
        this.context = context;
        this.handler = new MessageHandler(this);
        GestureDetector gestureDetector = new GestureDetector(context, new LoopViewGestureListener(this));
        this.flingGestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeset, R.styleable.LoopView);
        if (typedArrayObtainStyledAttributes != null) {
            this.textSize = typedArrayObtainStyledAttributes.getInteger(R.styleable.LoopView_awv_textsize, DEFAULT_TEXT_SIZE);
            this.textSize = (int) (Resources.getSystem().getDisplayMetrics().density * this.textSize);
            this.lineSpacingMultiplier = typedArrayObtainStyledAttributes.getFloat(R.styleable.LoopView_awv_lineSpace, 1.0f);
            this.centerTextColor = typedArrayObtainStyledAttributes.getInteger(R.styleable.LoopView_awv_centerTextColor, -13553359);
            this.outerTextColor = typedArrayObtainStyledAttributes.getInteger(R.styleable.LoopView_awv_outerTextColor, -5263441);
            this.dividerColor = typedArrayObtainStyledAttributes.getInteger(R.styleable.LoopView_awv_dividerTextColor, -3815995);
            int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.LoopView_awv_itemsVisibleCount, 9);
            this.itemsVisibleCount = integer;
            if (integer % 2 == 0) {
                this.itemsVisibleCount = 9;
            }
            this.isLoop = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LoopView_awv_isLoop, true);
            this.isEnableCurve = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LoopView_awv_isCurve, ENABLE_CURVE);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.drawingStrings = new HashMap<>();
        this.totalScrollY = 0;
        this.initPosition = -1;
        initPaintsIfPossible();
    }

    public void setItemsVisibleCount(int visibleNumber) {
        if (visibleNumber % 2 == 0 || visibleNumber == this.itemsVisibleCount) {
            return;
        }
        this.itemsVisibleCount = visibleNumber;
        this.drawingStrings = new HashMap<>();
    }

    private void initPaintsIfPossible() {
        if (this.paintOuterText == null) {
            Paint paint = new Paint();
            this.paintOuterText = paint;
            paint.setColor(this.outerTextColor);
            this.paintOuterText.setAntiAlias(true);
            this.paintOuterText.setTypeface(this.typeface);
            this.paintOuterText.setTextSize(this.textSize);
        }
        if (this.paintCenterText == null) {
            Paint paint2 = new Paint();
            this.paintCenterText = paint2;
            paint2.setColor(this.centerTextColor);
            this.paintCenterText.setAntiAlias(true);
            this.paintCenterText.setTextScaleX(this.scaleX);
            this.paintCenterText.setTypeface(this.typeface);
            this.paintCenterText.setTextSize(this.textSize);
        }
        if (this.paintIndicator == null) {
            Paint paint3 = new Paint();
            this.paintIndicator = paint3;
            paint3.setColor(this.dividerColor);
            this.paintIndicator.setAntiAlias(true);
        }
    }

    private void remeasure() {
        List<IndexString> list = this.items;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.measuredHeight = measuredHeight;
        if (this.measuredWidth == 0 || measuredHeight == 0) {
            return;
        }
        this.paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        this.paddingRight = paddingRight;
        this.measuredWidth -= paddingRight;
        this.paintCenterText.getTextBounds("星期", 0, 2, this.tempRect);
        this.textHeight = this.tempRect.height();
        int i = this.measuredHeight;
        int i2 = (int) ((i * 3.141592653589793d) / 2.0d);
        this.halfCircumference = i2;
        if (this.isEnableCurve) {
            this.itemTextHeight = (int) (i2 / (this.lineSpacingMultiplier * (this.itemsVisibleCount - 1)));
        } else {
            this.itemTextHeight = i / this.itemsVisibleCount;
        }
        this.radius = i / 2;
        float f = this.lineSpacingMultiplier;
        int i3 = this.itemTextHeight;
        this.firstLineY = (int) ((i - (i3 * f)) / 2.0f);
        this.secondLineY = (int) ((i + (f * i3)) / 2.0f);
        if (this.initPosition == -1) {
            if (this.isLoop) {
                this.initPosition = (this.items.size() + 1) / 2;
            } else {
                this.initPosition = 0;
            }
        }
        this.preCurrentIndex = this.initPosition;
    }

    void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DRAG) {
            float f = this.lineSpacingMultiplier * this.itemTextHeight;
            int i = (int) (((this.totalScrollY % f) + f) % f);
            this.mOffset = i;
            if (i > f / 2.0f) {
                this.mOffset = (int) (f - i);
            } else {
                this.mOffset = -i;
            }
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
        changeScrollState(3);
    }

    protected final void scrollBy(float velocityY) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new InertiaTimerTask(this, velocityY), 0L, 10, TimeUnit.MILLISECONDS);
        changeScrollState(2);
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
        changeScrollState(0);
    }

    private void printMethodStackTrace(String methodName) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder("printMethodStackTrace ");
        sb.append(methodName);
        sb.append(" ");
        int length = stackTrace.length;
        while (true) {
            length--;
            if (length >= 4) {
                StackTraceElement stackTraceElement = stackTrace[length];
                sb.append(String.format("%s(%d).%s", stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()), stackTraceElement.getMethodName()));
                if (length > 4) {
                    sb.append(XmlUtils.XML_COMMENT_END);
                }
            } else {
                Log.i("printMethodStackTrace", sb.toString());
                return;
            }
        }
    }

    private void changeScrollState(int scrollState) {
        if (scrollState == this.currentScrollState || this.handler.hasMessages(2001)) {
            return;
        }
        this.lastScrollState = this.currentScrollState;
        this.currentScrollState = scrollState;
    }

    public void setNotLoop() {
        this.isLoop = false;
    }

    public final void setTextSize(float size) {
        if (size > 0.0f) {
            int i = (int) (this.context.getResources().getDisplayMetrics().density * size);
            this.textSize = i;
            Paint paint = this.paintOuterText;
            if (paint != null) {
                paint.setTextSize(i);
            }
            Paint paint2 = this.paintCenterText;
            if (paint2 != null) {
                paint2.setTextSize(this.textSize);
            }
        }
    }

    public final void setInitPosition(int initPosition) {
        if (initPosition < 0) {
            this.initPosition = 0;
            return;
        }
        List<IndexString> list = this.items;
        if (list == null || list.size() <= initPosition) {
            return;
        }
        this.initPosition = initPosition;
    }

    public final void setListener(OnItemSelectedListener OnItemSelectedListener) {
        this.onItemSelectedListener = OnItemSelectedListener;
    }

    public final void setOnItemScrollListener(OnItemScrollListener mOnItemScrollListener) {
        this.mOnItemScrollListener = mOnItemScrollListener;
    }

    public final void setItems(List<String> items) {
        this.items = convertData(items);
        remeasure();
        invalidate();
    }

    public List<IndexString> convertData(List<String> items) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < items.size(); i++) {
            arrayList.add(new IndexString(i, items.get(i)));
        }
        return arrayList;
    }

    public final int getSelectedItem() {
        return this.preCurrentIndex;
    }

    protected final void onItemSelected() {
        if (this.onItemSelectedListener != null) {
            postDelayed(new OnItemSelectedRunnable(this), 200L);
        }
    }

    @Override // android.view.View
    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public void setCurrentPosition(int position) {
        List<IndexString> list = this.items;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.items.size();
        if (position < 0 || position >= size || position == getSelectedItem()) {
            return;
        }
        this.initPosition = position;
        this.totalScrollY = 0;
        this.mOffset = 0;
        changeScrollState(1);
        remeasure();
        this.handler.sendEmptyMessage(3000);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        OnItemScrollListener onItemScrollListener;
        int iCos;
        super.onDraw(canvas);
        List<IndexString> list = this.items;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i = (int) (this.totalScrollY / (this.lineSpacingMultiplier * this.itemTextHeight));
        this.change = i;
        int size = this.initPosition + (i % this.items.size());
        this.preCurrentIndex = size;
        if (!this.isLoop) {
            if (size < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > this.items.size() - 1) {
                this.preCurrentIndex = this.items.size() - 1;
            }
        } else {
            if (size < 0) {
                this.preCurrentIndex = this.items.size() + this.preCurrentIndex;
            }
            if (this.preCurrentIndex > this.items.size() - 1) {
                this.preCurrentIndex -= this.items.size();
            }
        }
        int i2 = this.totalScrollY % this.itemTextHeight;
        int i3 = 0;
        while (true) {
            int i4 = this.itemsVisibleCount;
            if (i3 >= i4) {
                break;
            }
            int size2 = this.preCurrentIndex - ((i4 / 2) - i3);
            if (this.isLoop) {
                while (size2 < 0) {
                    size2 += this.items.size();
                }
                while (size2 > this.items.size() - 1) {
                    size2 -= this.items.size();
                }
                this.drawingStrings.put(Integer.valueOf(i3), this.items.get(size2));
            } else if (size2 < 0) {
                this.drawingStrings.put(Integer.valueOf(i3), new IndexString());
            } else if (size2 > this.items.size() - 1) {
                this.drawingStrings.put(Integer.valueOf(i3), new IndexString());
            } else {
                this.drawingStrings.put(Integer.valueOf(i3), this.items.get(size2));
            }
            i3++;
        }
        float f = this.paddingLeft;
        int i5 = this.firstLineY;
        canvas.drawLine(f, i5, this.measuredWidth, i5, this.paintIndicator);
        float f2 = this.paddingLeft;
        int i6 = this.secondLineY;
        canvas.drawLine(f2, i6, this.measuredWidth, i6, this.paintIndicator);
        for (int i7 = 0; i7 < this.itemsVisibleCount; i7++) {
            canvas.save();
            float f3 = this.itemTextHeight * this.lineSpacingMultiplier;
            float f4 = (i7 * f3) - i2;
            double d = (f4 * 3.141592653589793d) / this.halfCircumference;
            if ((d >= 3.141592653589793d || d <= AudioStats.AUDIO_AMPLITUDE_NONE) && this.isEnableCurve) {
                canvas.restore();
            } else {
                if (this.isEnableCurve) {
                    iCos = (int) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.itemTextHeight) / 2.0d));
                } else {
                    iCos = (int) f4;
                    Log.d("weigan", "translateY " + iCos + " pos " + i7 + " j2 " + i2);
                }
                canvas.translate(0.0f, iCos);
                if (this.isEnableCurve) {
                    canvas.scale(1.0f, (float) Math.sin(d));
                }
                int i8 = this.firstLineY;
                if (iCos <= i8 && this.itemTextHeight + iCos >= i8) {
                    canvas.save();
                    canvas.clipRect(0, 0, this.measuredWidth, this.firstLineY - iCos);
                    drawOuterText(canvas, i7);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, this.firstLineY - iCos, this.measuredWidth, (int) f3);
                    drawCenterText(canvas, i7);
                    canvas.restore();
                } else {
                    int i9 = this.secondLineY;
                    if (iCos <= i9 && this.itemTextHeight + iCos >= i9) {
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, this.secondLineY - iCos);
                        drawCenterText(canvas, i7);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0, this.secondLineY - iCos, this.measuredWidth, (int) f3);
                        drawOuterText(canvas, i7);
                        canvas.restore();
                    } else if (iCos >= i8 && this.itemTextHeight + iCos <= i9) {
                        canvas.clipRect(0, 0, this.measuredWidth, (int) f3);
                        drawCenterText(canvas, i7);
                    } else {
                        canvas.clipRect(0, 0, this.measuredWidth, (int) f3);
                        drawOuterText(canvas, i7);
                    }
                }
                canvas.restore();
            }
        }
        int i10 = this.currentScrollState;
        int i11 = this.lastScrollState;
        if (i10 != i11) {
            this.lastScrollState = i10;
            OnItemScrollListener onItemScrollListener2 = this.mOnItemScrollListener;
            if (onItemScrollListener2 != null) {
                onItemScrollListener2.onItemScrollStateChanged(this, getSelectedItem(), i11, this.currentScrollState, this.totalScrollY);
            }
        }
        int i12 = this.currentScrollState;
        if ((i12 == 2 || i12 == 3) && (onItemScrollListener = this.mOnItemScrollListener) != null) {
            onItemScrollListener.onItemScrolling(this, getSelectedItem(), this.currentScrollState, this.totalScrollY);
        }
    }

    private void drawOuterText(Canvas canvas, int position) {
        canvas.drawText(this.drawingStrings.get(Integer.valueOf(position)).string, getTextX(this.drawingStrings.get(Integer.valueOf(position)).string, this.paintOuterText, this.tempRect), getDrawingY(), this.paintOuterText);
    }

    private void drawCenterText(Canvas canvas, int position) {
        canvas.drawText(this.drawingStrings.get(Integer.valueOf(position)).string, getTextX(this.drawingStrings.get(Integer.valueOf(position)).string, this.paintOuterText, this.tempRect), getDrawingY(), this.paintCenterText);
    }

    private int getDrawingY() {
        int i = this.itemTextHeight;
        int i2 = this.textHeight;
        return i > i2 ? i - ((i - i2) / 2) : i;
    }

    private int getTextX(String a, Paint paint, Rect rect) {
        paint.getTextBounds(a, 0, a.length(), rect);
        int iWidth = (int) (rect.width() * this.scaleX);
        int i = this.measuredWidth;
        int i2 = this.paddingLeft;
        return (((i - i2) - iWidth) / 2) + i2;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        remeasure();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean zOnTouchEvent = this.flingGestureDetector.onTouchEvent(event);
        float f = this.lineSpacingMultiplier * this.itemTextHeight;
        int action = event.getAction();
        if (action == 0) {
            this.startTime = System.currentTimeMillis();
            cancelFuture();
            this.previousY = event.getRawY();
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 2) {
            float rawY = this.previousY - event.getRawY();
            this.previousY = event.getRawY();
            this.totalScrollY = (int) (this.totalScrollY + rawY);
            if (!this.isLoop) {
                float f2 = (-this.initPosition) * f;
                float size = ((this.items.size() - 1) - this.initPosition) * f;
                int i = this.totalScrollY;
                if (i < f2) {
                    this.totalScrollY = (int) f2;
                } else if (i > size) {
                    this.totalScrollY = (int) size;
                }
            }
            changeScrollState(2);
        } else {
            if (!zOnTouchEvent) {
                float y = event.getY();
                int i2 = this.radius;
                int iAcos = (int) (((Math.acos((i2 - y) / i2) * this.radius) + (f / 2.0f)) / f);
                this.mOffset = (int) (((iAcos - (this.itemsVisibleCount / 2)) * f) - (((this.totalScrollY % f) + f) % f));
                if (System.currentTimeMillis() - this.startTime > 120) {
                    smoothScroll(ACTION.DRAG);
                } else {
                    smoothScroll(ACTION.CLICK);
                }
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        invalidate();
        return true;
    }

    class IndexString {
        private int index;
        private String string;

        public IndexString() {
            this.string = "";
        }

        public IndexString(int index, String str) {
            this.index = index;
            this.string = str;
        }
    }
}
