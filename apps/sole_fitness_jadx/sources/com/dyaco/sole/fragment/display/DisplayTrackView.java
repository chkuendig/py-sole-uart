package com.dyaco.sole.fragment.display;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.soletreadmills.sole.R;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class DisplayTrackView extends View {
    private static final int RESET = 99;
    private static final int SHINE = 100;
    private static final int TOTAL_STEP = 250;
    int aaa;
    private Bitmap bgBitmap;
    private Paint bgGrayPaint;
    private Rect bgRect;
    private float bitmapStartMargin;
    private float bitmapTopMargin;
    private float bitmapWidthCenter;
    private float circleStep;
    private Handler drawHandler;
    private Path endPath;
    private float endPathX;
    private boolean isClockwise;
    private boolean isDrawShineMode;
    boolean isDrawing;
    private boolean isShine;
    private boolean isStartDraw;
    private boolean isTen;
    private float leftCircleAngle;
    private RectF leftCircleRectF;
    private float leftCircleStartAngle;
    private float leftShineAngle;
    private float lineMarginBottom;
    private float lineStep;
    private float lineWidth;
    private int nowStep;
    private Paint paint;
    private Resources res;
    private float rightCircleAngle;
    private RectF rightCircleRectF;
    private float rightCircleStartAngle;
    private float rightShineAngle;
    private Path secondLinePath;
    private float secondLinePathX;
    private Path shineEndPath;
    private Path shineSecondLinePath;
    private Path shineStartLinePath;
    private Timer shineTimer;
    private Path startLinePath;
    private float startLinePathX;
    int step;
    private int totalStep;
    private Paint transparentPaint;
    private float viewHeight;
    private float viewWidth;

    static /* synthetic */ int access$308(DisplayTrackView displayTrackView) {
        int i = displayTrackView.nowStep;
        displayTrackView.nowStep = i + 1;
        return i;
    }

    public DisplayTrackView(Context context) {
        super(context);
        this.startLinePathX = 0.0f;
        this.secondLinePathX = 9999.0f;
        this.endPathX = -9999.0f;
        this.nowStep = 0;
        this.drawHandler = new Handler() { // from class: com.dyaco.sole.fragment.display.DisplayTrackView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 99) {
                    DisplayTrackView.this.resetView();
                    DisplayTrackView.this.invalidate();
                }
                if (i == 100) {
                    if (DisplayTrackView.this.isDrawShineMode) {
                        DisplayTrackView.this.invalidate();
                        return;
                    }
                    return;
                }
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        DisplayTrackView.this.isDrawing = true;
                        DisplayTrackView.this.invalidate();
                        break;
                    case 7:
                        DisplayTrackView.this.isDrawing = false;
                        DisplayTrackView.this.isDrawShineMode = true;
                        break;
                }
            }
        };
        this.isTen = false;
        this.aaa = 0;
    }

    public DisplayTrackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startLinePathX = 0.0f;
        this.secondLinePathX = 9999.0f;
        this.endPathX = -9999.0f;
        this.nowStep = 0;
        this.drawHandler = new Handler() { // from class: com.dyaco.sole.fragment.display.DisplayTrackView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 99) {
                    DisplayTrackView.this.resetView();
                    DisplayTrackView.this.invalidate();
                }
                if (i == 100) {
                    if (DisplayTrackView.this.isDrawShineMode) {
                        DisplayTrackView.this.invalidate();
                        return;
                    }
                    return;
                }
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        DisplayTrackView.this.isDrawing = true;
                        DisplayTrackView.this.invalidate();
                        break;
                    case 7:
                        DisplayTrackView.this.isDrawing = false;
                        DisplayTrackView.this.isDrawShineMode = true;
                        break;
                }
            }
        };
        this.isTen = false;
        this.aaa = 0;
    }

    public DisplayTrackView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.startLinePathX = 0.0f;
        this.secondLinePathX = 9999.0f;
        this.endPathX = -9999.0f;
        this.nowStep = 0;
        this.drawHandler = new Handler() { // from class: com.dyaco.sole.fragment.display.DisplayTrackView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 99) {
                    DisplayTrackView.this.resetView();
                    DisplayTrackView.this.invalidate();
                }
                if (i2 == 100) {
                    if (DisplayTrackView.this.isDrawShineMode) {
                        DisplayTrackView.this.invalidate();
                        return;
                    }
                    return;
                }
                switch (i2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        DisplayTrackView.this.isDrawing = true;
                        DisplayTrackView.this.invalidate();
                        break;
                    case 7:
                        DisplayTrackView.this.isDrawing = false;
                        DisplayTrackView.this.isDrawShineMode = true;
                        break;
                }
            }
        };
        this.isTen = false;
        this.aaa = 0;
    }

    private void init(Canvas canvas) {
        Resources resources = getResources();
        this.res = resources;
        this.lineWidth = resources.getDimension(R.dimen.display_track_line_width);
        this.lineStep = this.res.getDimension(R.dimen.display_track_line_step);
        this.lineMarginBottom = this.res.getDimension(R.dimen.display_track_line_margin_bottom);
        this.circleStep = this.res.getDimension(R.dimen.display_track_circle_step);
        this.viewWidth = canvas.getWidth();
        this.viewHeight = canvas.getHeight();
        float f = this.viewWidth;
        this.totalStep = (int) ((f - (f * 0.05d)) / this.lineWidth);
        Log.e("checkTotalStep", this.totalStep + "");
        Log.e("checkDrawNum", "viewW : " + this.viewWidth + " | viewHeight : " + this.viewHeight + " | line : " + this.lineWidth);
        StringBuilder sb = new StringBuilder();
        sb.append("step : ");
        sb.append(this.totalStep);
        Log.e("checkDrawNum", sb.toString());
        try {
            this.bgBitmap = Bitmap.createScaledBitmap(Global.readBitmapFromStream(this.res, R.drawable.display_track_a_table, 1), (int) this.viewWidth, (int) this.viewHeight, false);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.gc();
            this.bgBitmap = Bitmap.createScaledBitmap(Global.readBitmapFromStream(this.res, R.drawable.display_track_a_table, 2), (int) this.viewWidth, (int) this.viewHeight, false);
        }
        this.bitmapStartMargin = 0.0f;
        this.bitmapTopMargin = 0.0f;
        this.bitmapWidthCenter = this.viewWidth / 2.0f;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(this.res.getColor(R.color.display_number_blue));
        Paint paint2 = new Paint();
        this.transparentPaint = paint2;
        paint2.setColor(this.res.getColor(R.color.transparent));
        Paint paint3 = new Paint();
        this.bgGrayPaint = paint3;
        paint3.setColor(this.res.getColor(R.color.display_track_gray));
        float f2 = this.bitmapStartMargin;
        this.bgRect = new Rect((int) f2, (int) this.bitmapTopMargin, (int) (f2 + this.viewWidth), (int) this.viewHeight);
        this.rightCircleRectF = new RectF();
        this.leftCircleRectF = new RectF();
        this.startLinePath = new Path();
        this.secondLinePath = new Path();
        this.endPath = new Path();
        this.shineStartLinePath = new Path();
        this.shineSecondLinePath = new Path();
        this.shineEndPath = new Path();
        setDirection(false);
    }

    public void setDirection(boolean z) {
        this.isClockwise = z;
        if (z) {
            this.rightCircleStartAngle = -90.0f;
            this.leftCircleStartAngle = -270.0f;
        } else {
            this.rightCircleStartAngle = 90.0f;
            this.leftCircleStartAngle = -90.0f;
        }
    }

    public void onStart(int i) {
        Global.printLog("d", "DisplayTrackView", "即時更新View-----" + i);
        resetView();
        if (this.isDrawing) {
            return;
        }
        setPace(i);
    }

    public void onDestroy() {
        Timer timer = this.shineTimer;
        if (timer != null) {
            timer.cancel();
            this.shineTimer = null;
        }
        resetView();
        invalidate();
    }

    public void setPace(int i) {
        this.isStartDraw = true;
        int i2 = i + 1;
        if (this.isDrawing) {
            return;
        }
        this.step = new BigDecimal((int) (i2 % 10000.0f)).divide(new BigDecimal(200), 1, RoundingMode.HALF_UP).intValue();
        Log.e("checkStep", this.circleStep + " | " + this.lineStep);
        this.isTen = false;
        int i3 = this.step;
        if (i3 == 0) {
            Global.printLog("d", "DisplayTrackView", "setPace reset~~~~~~~~~~");
            if (ProtocolHandler.protocol.deviceUnit == 0) {
                resetView();
                invalidate();
                return;
            }
            this.step = this.totalStep;
        } else if (i3 == 10 && ProtocolHandler.protocol.deviceUnit == 1) {
            this.step = this.totalStep;
            this.isTen = true;
        }
        if (this.shineTimer == null) {
            Timer timer = new Timer();
            this.shineTimer = timer;
            timer.schedule(new TimerTask() { // from class: com.dyaco.sole.fragment.display.DisplayTrackView.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    DisplayTrackView.this.isShine = !r0.isShine;
                    DisplayTrackView.this.drawHandler.sendEmptyMessage(100);
                }
            }, 100L, 500L);
        }
        setView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.dyaco.sole.fragment.display.DisplayTrackView$3] */
    public void setView() {
        new Thread() { // from class: com.dyaco.sole.fragment.display.DisplayTrackView.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws InterruptedException {
                while (DisplayTrackView.this.nowStep < DisplayTrackView.this.step) {
                    DisplayTrackView.this.isDrawShineMode = false;
                    for (int i = 1; i < 8; i++) {
                        Log.e("checkNowiii", DisplayTrackView.this.nowStep + " | " + i);
                        DisplayTrackView.this.drawHandler.sendEmptyMessage(i);
                        try {
                            Thread.sleep(50L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (DisplayTrackView.this.nowStep == DisplayTrackView.this.totalStep - 1 && i == 7) {
                            DisplayTrackView.this.drawHandler.sendEmptyMessage(99);
                            if (DisplayTrackView.this.isTen) {
                                DisplayTrackView.this.nowStep = 0;
                                DisplayTrackView.this.step = 10;
                                DisplayTrackView.this.setView();
                            }
                        }
                    }
                    DisplayTrackView.access$308(DisplayTrackView.this);
                }
            }
        }.start();
    }

    public void setPaintColor(int i) {
        this.paint.setColor(this.res.getColor(i));
    }

    public void resetView() {
        Path path = this.startLinePath;
        if (path == null) {
            return;
        }
        this.nowStep = 0;
        this.startLinePathX = 0.0f;
        this.secondLinePathX = 9999.0f;
        this.endPathX = -9999.0f;
        this.rightCircleAngle = 0.0f;
        this.leftCircleAngle = 0.0f;
        path.reset();
        this.rightCircleRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.secondLinePath.reset();
        this.leftCircleRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.endPath.reset();
        this.leftCircleRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.endPath.reset();
        this.shineStartLinePath.reset();
        this.rightShineAngle = 0.0f;
        this.shineSecondLinePath.reset();
        this.leftShineAngle = 0.0f;
        this.shineEndPath.reset();
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x01cc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.viewWidth == 0.0f || this.viewHeight == 0.0f) {
            init(canvas);
        }
        if (!this.isStartDraw) {
            canvas.drawRect(this.bgRect, this.bgGrayPaint);
            canvas.drawBitmap(this.bgBitmap, this.bitmapStartMargin, this.bitmapTopMargin, (Paint) null);
            return;
        }
        if (this.isDrawShineMode) {
            canvas.drawRect(this.bgRect, this.bgGrayPaint);
            canvas.drawPath(this.startLinePath, this.paint);
            canvas.drawArc(this.rightCircleRectF, this.rightCircleStartAngle, this.rightCircleAngle, true, this.paint);
            canvas.drawPath(this.secondLinePath, this.paint);
            canvas.drawArc(this.leftCircleRectF, this.leftCircleStartAngle, this.leftCircleAngle, true, this.paint);
            canvas.drawPath(this.endPath, this.paint);
            canvas.drawPath(this.shineStartLinePath, this.isShine ? this.paint : this.transparentPaint);
            canvas.drawArc(this.rightCircleRectF, this.rightCircleStartAngle, this.rightShineAngle, true, this.isShine ? this.paint : this.transparentPaint);
            canvas.drawPath(this.shineSecondLinePath, this.isShine ? this.paint : this.transparentPaint);
            canvas.drawArc(this.leftCircleRectF, this.leftCircleStartAngle, this.leftShineAngle, true, this.isShine ? this.paint : this.transparentPaint);
            canvas.drawPath(this.shineEndPath, this.isShine ? this.paint : this.transparentPaint);
            canvas.drawBitmap(this.bgBitmap, this.bitmapStartMargin, this.bitmapTopMargin, (Paint) null);
            return;
        }
        if (this.isClockwise) {
            float f = this.startLinePathX;
            float f2 = this.viewWidth;
            if (f <= f2 / 3.0f) {
                float f3 = f + this.lineStep;
                this.startLinePathX = f3;
                float f4 = this.bitmapWidthCenter;
                float f5 = f3 + f4;
                this.startLinePath.moveTo(f4, this.bitmapTopMargin);
                this.startLinePath.lineTo(this.bitmapWidthCenter, this.bitmapTopMargin + this.lineWidth);
                this.startLinePath.lineTo(f5, this.lineWidth);
                this.startLinePath.lineTo(f5, this.bitmapTopMargin);
                this.startLinePath.close();
                this.shineStartLinePath.moveTo(f5, this.bitmapTopMargin);
                this.shineStartLinePath.lineTo(f5, this.bitmapTopMargin + this.lineWidth);
                this.shineStartLinePath.lineTo(this.lineStep + f5, this.lineWidth);
                this.shineStartLinePath.lineTo(f5 + this.lineStep, this.bitmapTopMargin);
            } else {
                float f6 = this.rightCircleAngle;
                if (f6 < 180.0f) {
                    this.rightCircleAngle = f6 + this.circleStep;
                    RectF rectF = this.rightCircleRectF;
                    float f7 = this.bitmapStartMargin;
                    rectF.set((f2 - (f2 / 3.0f)) + f7, 0.0f, f7 + f2, this.viewHeight);
                } else {
                    float f8 = this.secondLinePathX;
                    if ((f2 / 2.0f) + f8 > f2 / 6.0f) {
                        if (f8 == 9999.0f) {
                            this.secondLinePathX = f;
                        }
                        this.secondLinePathX -= this.lineStep;
                        this.secondLinePath.moveTo(this.bitmapWidthCenter + f, this.viewHeight - (this.lineWidth + this.lineMarginBottom));
                        this.secondLinePath.lineTo(this.bitmapWidthCenter + this.startLinePathX, this.viewHeight - this.lineMarginBottom);
                        this.secondLinePath.lineTo(this.bitmapWidthCenter + this.secondLinePathX, this.viewHeight - this.lineMarginBottom);
                        this.secondLinePath.lineTo(this.bitmapWidthCenter + this.secondLinePathX, this.viewHeight - (this.lineWidth + this.lineMarginBottom));
                        this.secondLinePath.close();
                    } else if ((f2 / 2.0f) + f8 <= f2 / 6.0f) {
                        float f9 = this.leftCircleAngle;
                        if (f9 < 180.0f) {
                            this.leftCircleAngle = f9 + this.circleStep;
                            RectF rectF2 = this.leftCircleRectF;
                            float f10 = this.bitmapStartMargin;
                            rectF2.set(f10, 0.0f, (f2 / 3.0f) + f10, this.viewHeight);
                        } else {
                            float f11 = this.bitmapWidthCenter;
                            float f12 = this.endPathX;
                            if (f11 + f12 < f11) {
                                if (f12 == -9999.0f) {
                                    this.endPathX = f8;
                                }
                                this.endPathX += this.lineStep;
                                this.endPath.moveTo(f11 + f8, this.bitmapTopMargin);
                                this.endPath.lineTo(this.bitmapWidthCenter + this.secondLinePathX, this.bitmapTopMargin + this.lineWidth);
                                this.endPath.lineTo(this.bitmapWidthCenter + this.endPathX, this.bitmapTopMargin + this.lineWidth);
                                this.endPath.lineTo(this.bitmapWidthCenter + this.endPathX, this.bitmapTopMargin);
                                this.endPath.close();
                            }
                        }
                    }
                }
            }
        } else {
            float f13 = this.startLinePathX;
            float f14 = this.viewWidth;
            if (f13 <= f14 / 3.0f) {
                float f15 = f13 + this.lineStep;
                this.startLinePathX = f15;
                float f16 = this.bitmapWidthCenter;
                float f17 = f15 + f16;
                this.startLinePath.moveTo(f16, this.viewHeight - (this.lineWidth + this.lineMarginBottom));
                this.startLinePath.lineTo(this.bitmapWidthCenter, this.viewHeight - this.lineMarginBottom);
                this.startLinePath.lineTo(f17, this.viewHeight - this.lineMarginBottom);
                this.startLinePath.lineTo(f17, this.viewHeight - (this.lineWidth + this.lineMarginBottom));
                this.startLinePath.close();
                this.shineStartLinePath.moveTo(f17, this.viewHeight - (this.lineWidth + this.lineMarginBottom));
                this.shineStartLinePath.lineTo(f17, this.viewHeight - this.lineMarginBottom);
                this.shineStartLinePath.lineTo(this.lineStep + f17, this.viewHeight - this.lineMarginBottom);
                this.shineStartLinePath.lineTo(f17 + this.lineStep, this.viewHeight - (this.lineWidth + this.lineMarginBottom));
                this.shineStartLinePath.close();
            } else {
                float f18 = this.rightCircleAngle;
                if (f18 > -180.0f) {
                    this.rightCircleAngle = f18 - this.circleStep;
                    RectF rectF3 = this.rightCircleRectF;
                    float f19 = this.bitmapStartMargin;
                    rectF3.set((f14 - (f14 / 3.0f)) + f19, 0.0f, f19 + f14, this.viewHeight);
                    this.shineStartLinePath.reset();
                    this.rightShineAngle = this.rightCircleAngle - this.circleStep;
                } else {
                    float f20 = this.secondLinePathX;
                    if ((f14 / 2.0f) + f20 > f14 / 6.0f) {
                        if (f20 == 9999.0f) {
                            this.secondLinePathX = f13;
                        }
                        float f21 = this.secondLinePathX - this.lineStep;
                        this.secondLinePathX = f21;
                        float f22 = this.bitmapWidthCenter;
                        float f23 = f13 + f22;
                        float f24 = f22 + f21;
                        this.secondLinePath.moveTo(f23, this.bitmapTopMargin);
                        this.secondLinePath.lineTo(f23, this.bitmapTopMargin + this.lineWidth);
                        this.secondLinePath.lineTo(f24, this.lineWidth);
                        this.secondLinePath.lineTo(f24, this.bitmapTopMargin);
                        this.secondLinePath.close();
                        this.rightShineAngle = 0.0f;
                        this.shineSecondLinePath.moveTo(f24, this.bitmapTopMargin);
                        this.shineSecondLinePath.lineTo(f24, this.bitmapTopMargin + this.lineWidth);
                        this.shineSecondLinePath.lineTo(f24 - this.lineStep, this.lineWidth);
                        this.shineSecondLinePath.lineTo(f24 - this.lineStep, this.bitmapTopMargin);
                    } else {
                        float f25 = this.leftCircleAngle;
                        if (f25 > -180.0f) {
                            this.leftCircleAngle = f25 - this.circleStep;
                            RectF rectF4 = this.leftCircleRectF;
                            float f26 = this.bitmapStartMargin;
                            rectF4.set(f26, 0.0f, (f14 / 3.0f) + f26, this.viewHeight);
                            this.leftShineAngle = this.leftCircleAngle - this.circleStep;
                        } else {
                            float f27 = this.bitmapWidthCenter;
                            float f28 = this.endPathX;
                            float f29 = f27 + f28;
                            float f30 = this.lineStep;
                            if (f29 < (10.0f * f30) + f27) {
                                if (f28 == -9999.0f) {
                                    this.endPathX = f20;
                                }
                                float f31 = this.endPathX + f30;
                                this.endPathX = f31;
                                float f32 = f20 + f27;
                                float f33 = f27 + f31;
                                this.endPath.moveTo(f32, this.viewHeight - (this.lineWidth + this.lineMarginBottom));
                                this.endPath.lineTo(f32, this.viewHeight - this.lineMarginBottom);
                                this.endPath.lineTo(f33, this.viewHeight - this.lineMarginBottom);
                                this.endPath.lineTo(f33, this.viewHeight - (this.lineWidth + this.lineMarginBottom));
                                this.endPath.close();
                                this.leftShineAngle = 0.0f;
                                this.shineEndPath.moveTo(f33, this.viewHeight - (this.lineWidth + this.lineMarginBottom));
                                this.shineEndPath.lineTo(f33, this.viewHeight - this.lineMarginBottom);
                                this.shineEndPath.lineTo(this.lineStep + f33, this.viewHeight - this.lineMarginBottom);
                                this.shineEndPath.lineTo(f33 + this.lineStep, this.viewHeight - (this.lineWidth + this.lineMarginBottom));
                            }
                        }
                    }
                }
            }
        }
        canvas.drawRect(this.bgRect, this.bgGrayPaint);
        canvas.drawPath(this.startLinePath, this.paint);
        canvas.drawArc(this.rightCircleRectF, this.rightCircleStartAngle, this.rightCircleAngle, true, this.paint);
        canvas.drawPath(this.secondLinePath, this.paint);
        canvas.drawArc(this.leftCircleRectF, this.leftCircleStartAngle, this.leftCircleAngle, true, this.paint);
        canvas.drawPath(this.endPath, this.paint);
        canvas.drawBitmap(this.bgBitmap, this.bitmapStartMargin, this.bitmapTopMargin, (Paint) null);
    }
}
