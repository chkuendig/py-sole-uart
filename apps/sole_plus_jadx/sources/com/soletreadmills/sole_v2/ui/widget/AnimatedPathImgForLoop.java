package com.soletreadmills.sole_v2.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.PathParser;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.WorkoutRawData4WorkoutDetailDisplay;
import com.soletreadmills.sole_v2._data.WorkoutViewVo;
import com.soletreadmills.sole_v2._data.history.UserRunnerForRematch;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* compiled from: AnimatedPathImgForLoop.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010N\u001a\u00020OJ*\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00172\u0006\u0010T\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J:\u0010U\u001a\u00020O2\u0006\u0010Q\u001a\u00020R2\u0006\u0010V\u001a\u00020\u00172\u0006\u0010W\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002JP\u0010Z\u001a\u00020O2\u0006\u0010Q\u001a\u00020R2\u0006\u0010[\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020\u00172\u0006\u0010]\u001a\u00020^2\b\b\u0002\u0010_\u001a\u00020\u00172\b\b\u0002\u0010`\u001a\u00020\u00172\b\b\u0002\u0010a\u001a\u00020\u00172\b\b\u0002\u0010b\u001a\u00020\u0017H\u0002J\b\u0010c\u001a\u00020OH\u0002J,\u0010d\u001a\u00020O2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010e\u001a\u00020^2\u0014\u0010f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020O0gJ\b\u0010h\u001a\u00020OH\u0014J\u0010\u0010i\u001a\u00020O2\u0006\u0010Q\u001a\u00020RH\u0014J\u0010\u0010j\u001a\u00020%2\u0006\u0010k\u001a\u00020lH\u0016J\u0006\u0010m\u001a\u00020OJ\u0006\u0010n\u001a\u00020OJ\u0006\u0010o\u001a\u00020OJ\u000e\u00102\u001a\u00020O2\u0006\u0010e\u001a\u00020^J\u0006\u0010p\u001a\u00020OJ\u000e\u0010q\u001a\u00020O2\u0006\u0010r\u001a\u00020\u0017J\u000e\u0010s\u001a\u00020O2\u0006\u0010t\u001a\u00020\u0017J\b\u0010u\u001a\u00020OH\u0002J\u0006\u0010v\u001a\u00020OJ\u0006\u0010w\u001a\u00020OJ\u000e\u0010x\u001a\u00020O2\u0006\u0010y\u001a\u00020\u0017R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020908X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0019\"\u0004\bK\u0010\u001bR\u000e\u0010L\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/widget/AnimatedPathImgForLoop;", "Landroid/view/View;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animPath", "Landroid/graphics/Path;", "animPathPaint", "Landroid/graphics/Paint;", "animationStartTime", "", "Ljava/lang/Long;", SdkConstants.FD_RES_ANIMATOR, "Landroid/animation/ValueAnimator;", "arrowFillPaint", "arrowPath", SdkConstants.TAG_BITMAP, "Landroid/graphics/Bitmap;", "currentDistance", "", "getCurrentDistance", "()F", "setCurrentDistance", "(F)V", "fixedPathPaint", "fullPath", "gestureDetector", "Landroid/view/GestureDetector;", "grayMarkerPaint", "grayMarkerTextPaint", "handler", "Landroid/os/Handler;", "isAnimationFinished", "", "isDragging", "isPaused", "()Z", "setPaused", "(Z)V", "lastTouchTime", "lastTouchX", "lastTouchY", "lastUpdateTime", "mainUserBitmap", "getMainUserBitmap", "()Landroid/graphics/Bitmap;", "setMainUserBitmap", "(Landroid/graphics/Bitmap;)V", "markerFillPaint", "markerPaint", "markerPath", "otherUsers", "", "Lcom/soletreadmills/sole_v2/_data/history/UserRunnerForRematch;", "otherUsersDataList", "Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "getOtherUsersDataList", "()Ljava/util/List;", "setOtherUsersDataList", "(Ljava/util/List;)V", "pathLength", "pathMeasure", "Landroid/graphics/PathMeasure;", "resetCenterRunnable", "Ljava/lang/Runnable;", "scaleFactor", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "speedKmh", "totalDistanceKm", "getTotalDistanceKm", "setTotalDistanceKm", "translateX", "translateY", "centerToMainUser", "", "drawMapMarker", "canvas", "Landroid/graphics/Canvas;", "distance", "color", "drawMapMarkerWithSmallArrow", "tipX", "tipY", "circleColor", "arrowColor", "drawMarkerBubble", SdkConstants.ATTR_CENTER_X, SdkConstants.ATTR_CENTER_Y, "text", "", "horizontalPadding", "bubbleHeight", "tailHeight", "radius", "limitTranslate", "loadBitmapFromUrl", "url", "onComplete", "Lkotlin/Function1;", "onDetachedFromWindow", "onDraw", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "pauseAnimation", "resetView", "resumeAnimation", "setOtherUsers", "setScaleFactor", "factor", "setTotalDistance", "km", "setupAnimator", "startAnimation", "stopAnimation", "updateSpeed", "kmh", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnimatedPathImgForLoop extends View {
    public static final int $stable = 8;
    private Path animPath;
    private final Paint animPathPaint;
    private Long animationStartTime;
    private ValueAnimator animator;
    private final Paint arrowFillPaint;
    private final Path arrowPath;
    private Bitmap bitmap;
    private float currentDistance;
    private final Paint fixedPathPaint;
    private Path fullPath;
    private GestureDetector gestureDetector;
    private final Paint grayMarkerPaint;
    private final Paint grayMarkerTextPaint;
    private final Handler handler;
    private boolean isAnimationFinished;
    private boolean isDragging;
    private boolean isPaused;
    private long lastTouchTime;
    private float lastTouchX;
    private float lastTouchY;
    private long lastUpdateTime;
    private Bitmap mainUserBitmap;
    private final Paint markerFillPaint;
    private final Paint markerPaint;
    private final Path markerPath;
    private final List<UserRunnerForRematch> otherUsers;
    private List<WorkoutViewVo> otherUsersDataList;
    private float pathLength;
    private PathMeasure pathMeasure;
    private final Runnable resetCenterRunnable;
    private float scaleFactor;
    private ScaleGestureDetector scaleGestureDetector;
    private float speedKmh;
    private float totalDistanceKm;
    private float translateX;
    private float translateY;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimatedPathImgForLoop(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimatedPathImgForLoop(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AnimatedPathImgForLoop(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedPathImgForLoop(Context context, AttributeSet attributeSet, int i) throws IOException {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        paint.setColor(ContextCompat.getColor(context, R.color.colorGlobal_signal_40));
        paint.setStrokeWidth(16.0f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.fixedPathPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(ContextCompat.getColor(context, R.color.colorGlobal_signal));
        paint2.setStrokeWidth(16.0f);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.animPathPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setColor(ContextCompat.getColor(context, R.color.colorGlobal_signal));
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(6.0f);
        this.markerPaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setColor(-1);
        paint4.setStyle(Paint.Style.FILL);
        this.markerFillPaint = paint4;
        Paint paint5 = new Paint(1);
        paint5.setColor(ContextCompat.getColor(context, R.color.colorGlobal_signal));
        paint5.setStyle(Paint.Style.FILL);
        this.arrowFillPaint = paint5;
        Paint paint6 = new Paint(1);
        paint6.setColor(ContextCompat.getColor(context, R.color.colorGlobal_black_overlay75));
        paint6.setStyle(Paint.Style.FILL);
        this.grayMarkerPaint = paint6;
        Paint paint7 = new Paint(1);
        paint7.setColor(-1);
        paint7.setTextSize(30.0f);
        paint7.setTextAlign(Paint.Align.CENTER);
        paint7.setTypeface(Typeface.DEFAULT_BOLD);
        this.grayMarkerTextPaint = paint7;
        this.fullPath = new Path();
        this.animPath = new Path();
        this.scaleFactor = 1.0f;
        this.totalDistanceKm = 5.0f;
        this.markerPath = new Path();
        this.arrowPath = new Path();
        this.otherUsers = new ArrayList();
        this.otherUsersDataList = new ArrayList();
        this.lastTouchTime = System.currentTimeMillis();
        this.handler = new Handler(Looper.getMainLooper());
        this.resetCenterRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui.widget.AnimatedPathImgForLoop$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AnimatedPathImgForLoop.resetCenterRunnable$lambda$7(this.f$0);
            }
        };
        this.scaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.soletreadmills.sole_v2.ui.widget.AnimatedPathImgForLoop.1
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector detector) {
                Intrinsics.checkNotNullParameter(detector, "detector");
                float f = AnimatedPathImgForLoop.this.scaleFactor;
                float fCoerceIn = RangesKt.coerceIn(AnimatedPathImgForLoop.this.scaleFactor * detector.getScaleFactor(), 0.8f, 3.0f);
                if (fCoerceIn == f) {
                    return false;
                }
                float f2 = fCoerceIn / f;
                AnimatedPathImgForLoop.this.scaleFactor = fCoerceIn;
                float focusX = detector.getFocusX();
                float focusY = detector.getFocusY();
                AnimatedPathImgForLoop animatedPathImgForLoop = AnimatedPathImgForLoop.this;
                animatedPathImgForLoop.translateX = ((animatedPathImgForLoop.translateX - focusX) * f2) + focusX;
                AnimatedPathImgForLoop animatedPathImgForLoop2 = AnimatedPathImgForLoop.this;
                animatedPathImgForLoop2.translateY = ((animatedPathImgForLoop2.translateY - focusY) * f2) + focusY;
                AnimatedPathImgForLoop.this.invalidate();
                return true;
            }
        });
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.soletreadmills.sole_v2.ui.widget.AnimatedPathImgForLoop.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                if (e.getActionMasked() == 1) {
                    AnimatedPathImgForLoop.this.centerToMainUser();
                }
                return true;
            }
        });
        if (isInEditMode()) {
            return;
        }
        resetView();
    }

    public final float getCurrentDistance() {
        return this.currentDistance;
    }

    public final void setCurrentDistance(float f) {
        this.currentDistance = f;
    }

    public final float getTotalDistanceKm() {
        return this.totalDistanceKm;
    }

    public final void setTotalDistanceKm(float f) {
        this.totalDistanceKm = f;
    }

    public final List<WorkoutViewVo> getOtherUsersDataList() {
        return this.otherUsersDataList;
    }

    public final void setOtherUsersDataList(List<WorkoutViewVo> list) {
        this.otherUsersDataList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetCenterRunnable$lambda$7(AnimatedPathImgForLoop this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.centerToMainUser();
    }

    /* renamed from: isPaused, reason: from getter */
    public final boolean getIsPaused() {
        return this.isPaused;
    }

    public final void setPaused(boolean z) {
        this.isPaused = z;
    }

    public final Bitmap getMainUserBitmap() {
        return this.mainUserBitmap;
    }

    public final void setMainUserBitmap(Bitmap bitmap) {
        this.mainUserBitmap = bitmap;
    }

    public final void setTotalDistance(float km) {
        this.totalDistanceKm = RangesKt.coerceAtLeast(km, 0.1f);
    }

    public final void updateSpeed(float kmh) {
        this.speedKmh = RangesKt.coerceAtLeast(kmh, 0.0f);
    }

    public final void setScaleFactor(float factor) {
        this.scaleFactor = RangesKt.coerceIn(factor, 0.8f, 3.0f);
        invalidate();
    }

    public final void setOtherUsers() {
        final String displayName;
        String photoFileUrl;
        List<WorkoutViewVo> list = this.otherUsersDataList;
        if (list == null) {
            return;
        }
        for (final WorkoutViewVo workoutViewVo : list) {
            List<WorkoutRawData4WorkoutDetailDisplay> rawDataList = workoutViewVo.getRawDataList();
            if (rawDataList != null && !rawDataList.isEmpty()) {
                final Double nowSpeed = workoutViewVo.getRawDataList().get(0).getNowSpeed();
                LoginUserData loginUserData = Global.userData;
                if (loginUserData == null || (displayName = loginUserData.getDisplayName()) == null) {
                    displayName = "1";
                }
                LoginUserData loginUserData2 = Global.userData;
                if (loginUserData2 == null || (photoFileUrl = loginUserData2.getPhotoFileUrl()) == null) {
                    photoFileUrl = "";
                }
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                loadBitmapFromUrl(context, photoFileUrl, new Function1<Bitmap, Unit>() { // from class: com.soletreadmills.sole_v2.ui.widget.AnimatedPathImgForLoop.setOtherUsers.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                        invoke2(bitmap);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Bitmap bitmap) {
                        String str = displayName;
                        Double d = nowSpeed;
                        this.otherUsers.add(new UserRunnerForRematch(str, -7829368, 0.0f, d != null ? (float) d.doubleValue() : 0.0f, workoutViewVo.getRawDataList(), 0, bitmap));
                    }
                });
            }
        }
    }

    public final void setMainUserBitmap(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        loadBitmapFromUrl(context, url, new Function1<Bitmap, Unit>() { // from class: com.soletreadmills.sole_v2.ui.widget.AnimatedPathImgForLoop.setMainUserBitmap.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Bitmap bitmap) {
                AnimatedPathImgForLoop.this.setMainUserBitmap(bitmap);
            }
        });
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ScaleGestureDetector scaleGestureDetector = this.scaleGestureDetector;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(event);
        }
        GestureDetector gestureDetector = this.gestureDetector;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(event);
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0 || actionMasked == 2) {
            this.lastTouchTime = System.currentTimeMillis();
        }
        int actionMasked2 = event.getActionMasked();
        if (actionMasked2 == 0) {
            this.lastTouchX = event.getX();
            this.lastTouchY = event.getY();
            this.isDragging = true;
        } else if (actionMasked2 == 2 && this.isDragging) {
            float x = event.getX() - this.lastTouchX;
            float y = event.getY() - this.lastTouchY;
            this.lastTouchX = event.getX();
            this.lastTouchY = event.getY();
            this.translateX += x;
            this.translateY += y;
            invalidate();
        }
        return true;
    }

    private final void limitTranslate() {
        Unit unit;
        if (this.bitmap != null) {
            float width = r0.getWidth() * this.scaleFactor;
            float height = r0.getHeight() * this.scaleFactor;
            float height2 = getHeight() - height;
            this.translateX = width > ((float) getWidth()) ? RangesKt.coerceIn(this.translateX, getWidth() - width, 0.0f) : 0.0f;
            this.translateY = height > ((float) getHeight()) ? RangesKt.coerceIn(this.translateY, height2, 0.0f) : 0.0f;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.translateX = 0.0f;
            this.translateY = 0.0f;
        }
    }

    public final void startAnimation() {
        if (this.isPaused) {
            resumeAnimation();
            return;
        }
        stopAnimation();
        if (this.animationStartTime == null) {
            this.animationStartTime = Long.valueOf(System.currentTimeMillis());
        }
        this.isAnimationFinished = false;
        this.isPaused = false;
        this.currentDistance = 0.0f;
        Iterator<T> it = this.otherUsers.iterator();
        while (it.hasNext()) {
            ((UserRunnerForRematch) it.next()).setCurrentDistance(0.0f);
        }
        this.lastUpdateTime = 0L;
        setupAnimator();
    }

    public final void pauseAnimation() {
        this.isPaused = true;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    public final void resumeAnimation() {
        Timber.INSTANCE.e("resumeAnimation animator", new Object[0]);
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && this.isPaused) {
            Timber.INSTANCE.e("resumeAnimation animator02", new Object[0]);
            this.isPaused = false;
            this.lastUpdateTime = System.currentTimeMillis();
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 != null) {
                valueAnimator2.resume();
                return;
            }
            return;
        }
        if (valueAnimator == null && this.isPaused) {
            stopAnimation();
            if (this.animationStartTime == null) {
                this.animationStartTime = Long.valueOf(System.currentTimeMillis());
            }
            this.isAnimationFinished = false;
            this.isPaused = false;
            this.currentDistance = 0.0f;
            Iterator<T> it = this.otherUsers.iterator();
            while (it.hasNext()) {
                ((UserRunnerForRematch) it.next()).setCurrentDistance(0.0f);
            }
            this.lastUpdateTime = 0L;
            setupAnimator();
        }
    }

    private final void setupAnimator() {
        Timber.INSTANCE.e("start animator", new Object[0]);
        final ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(Long.MAX_VALUE);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soletreadmills.sole_v2.ui.widget.AnimatedPathImgForLoop$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimatedPathImgForLoop.setupAnimator$lambda$13$lambda$12(valueAnimatorOfFloat, this, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        this.animator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAnimator$lambda$13$lambda$12(ValueAnimator valueAnimator, AnimatedPathImgForLoop this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (valueAnimator.isPaused()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this$0.lastUpdateTime;
        if (j == 0) {
            this$0.lastUpdateTime = jCurrentTimeMillis;
            return;
        }
        long j2 = jCurrentTimeMillis - j;
        if (j2 < 10) {
            return;
        }
        this$0.lastUpdateTime = jCurrentTimeMillis;
        float f = j2 / 3600000.0f;
        float f2 = this$0.currentDistance + (this$0.speedKmh * f);
        this$0.currentDistance = f2;
        float f3 = this$0.totalDistanceKm;
        if (f2 >= f3) {
            this$0.currentDistance = f3;
            this$0.isAnimationFinished = true;
            ValueAnimator valueAnimator2 = this$0.animator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
        }
        Long l = this$0.animationStartTime;
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - (l != null ? l.longValue() : System.currentTimeMillis())) / 1000);
        for (UserRunnerForRematch userRunnerForRematch : this$0.otherUsers) {
            int currentIndex = userRunnerForRematch.getCurrentIndex() + 1;
            if (currentIndex < userRunnerForRematch.getRawDataList().size()) {
                userRunnerForRematch.getRawDataList().get(userRunnerForRematch.getCurrentIndex());
                WorkoutRawData4WorkoutDetailDisplay workoutRawData4WorkoutDetailDisplay = userRunnerForRematch.getRawDataList().get(currentIndex);
                Integer totalWorkoutTime = workoutRawData4WorkoutDetailDisplay.getTotalWorkoutTime();
                if (iCurrentTimeMillis >= (totalWorkoutTime != null ? totalWorkoutTime.intValue() : 0)) {
                    userRunnerForRematch.setCurrentIndex(currentIndex);
                    Double nowSpeed = workoutRawData4WorkoutDetailDisplay.getNowSpeed();
                    userRunnerForRematch.setSpeedKmh(nowSpeed != null ? (float) nowSpeed.doubleValue() : 0.0f);
                }
            }
            userRunnerForRematch.setCurrentDistance(userRunnerForRematch.getCurrentDistance() + (userRunnerForRematch.getSpeedKmh() * f));
            float currentDistance = userRunnerForRematch.getCurrentDistance();
            float f4 = this$0.totalDistanceKm;
            if (currentDistance > f4) {
                userRunnerForRematch.setCurrentDistance(f4);
            }
        }
        this$0.invalidate();
    }

    public final void stopAnimation() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.animator = null;
        this.isPaused = false;
        this.isAnimationFinished = false;
        this.lastUpdateTime = 0L;
        this.currentDistance = 0.0f;
        Iterator<T> it = this.otherUsers.iterator();
        while (it.hasNext()) {
            ((UserRunnerForRematch) it.next()).setCurrentDistance(0.0f);
        }
        invalidate();
    }

    public final void resetView() throws IOException {
        String string = getContext().getString(R.string.path_loop);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        InputStream inputStreamOpen = getContext().getAssets().open("loop.png");
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        this.bitmap = BitmapFactory.decodeStream(inputStreamOpen);
        inputStreamOpen.close();
        Path pathCreatePathFromPathData = PathParser.createPathFromPathData(string);
        Intrinsics.checkNotNullExpressionValue(pathCreatePathFromPathData, "createPathFromPathData(...)");
        this.fullPath = pathCreatePathFromPathData;
        PathMeasure pathMeasure = new PathMeasure(this.fullPath, false);
        this.pathMeasure = pathMeasure;
        this.pathLength = pathMeasure.getLength();
        centerToMainUser();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String string;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        PathMeasure pathMeasure = this.pathMeasure;
        if (pathMeasure != null) {
            float fCoerceIn = this.pathLength * RangesKt.coerceIn(this.currentDistance / this.totalDistanceKm, 0.0f, 1.0f);
            int i = 2;
            float[] fArr = new float[2];
            float[] fArr2 = null;
            pathMeasure.getPosTan(fCoerceIn, fArr, null);
            float width = getWidth() / 2.0f;
            float height = getHeight() / 2.0f;
            Timber.INSTANCE.e("isDragging:%s", Boolean.valueOf(this.isDragging));
            char c = 1;
            if (!this.isDragging) {
                float f = fArr[0];
                float f2 = this.scaleFactor;
                this.translateX = width - (f * f2);
                this.translateY = height - (fArr[1] * f2);
            }
            canvas.save();
            canvas.translate(this.translateX, this.translateY);
            float f3 = this.scaleFactor;
            canvas.scale(f3, f3);
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            }
            canvas.drawPath(this.fullPath, this.fixedPathPaint);
            this.animPath.reset();
            pathMeasure.getSegment(0.0f, fCoerceIn, this.animPath, true);
            canvas.drawPath(this.animPath, this.animPathPaint);
            float f4 = 0.0f;
            while (true) {
                float f5 = this.totalDistanceKm;
                if (f4 > f5) {
                    break;
                }
                float f6 = this.pathLength * (f4 / f5);
                float[] fArr3 = new float[i];
                pathMeasure.getPosTan(f6, fArr3, fArr2);
                if (f4 == 0.0f) {
                    string = "Start";
                } else {
                    string = f4 >= this.totalDistanceKm ? "Finish" : new StringBuilder().append((int) f4).append('K').toString();
                }
                drawMarkerBubble$default(this, canvas, fArr3[0], fArr3[c], string, 0.0f, 0.0f, 0.0f, 0.0f, 240, null);
                f4 += 1.0f;
                i = i;
                c = c;
                fArr2 = fArr2;
                fArr = fArr;
            }
            char c2 = c;
            float[] fArr4 = fArr;
            for (UserRunnerForRematch userRunnerForRematch : this.otherUsers) {
                drawMapMarker(canvas, userRunnerForRematch.getCurrentDistance(), userRunnerForRematch.getColor(), userRunnerForRematch.getBitmap());
            }
            drawMapMarkerWithSmallArrow(canvas, fArr4[0], fArr4[c2], ContextCompat.getColor(getContext(), R.color.colorGlobal_signal), ContextCompat.getColor(getContext(), R.color.colorGlobal_signal), this.mainUserBitmap);
            canvas.restore();
        }
    }

    private final void drawMapMarkerWithSmallArrow(Canvas canvas, float tipX, float tipY, int circleColor, int arrowColor, Bitmap bitmap) {
        canvas.save();
        canvas.translate(tipX, tipY);
        float f = 1.0f / this.scaleFactor;
        canvas.scale(f, f);
        this.markerPath.reset();
        this.arrowPath.reset();
        this.arrowPath.moveTo(0.0f, 0.0f);
        float f2 = 2;
        this.arrowPath.lineTo((-24.0f) / f2, -20.0f);
        this.arrowPath.lineTo(24.0f / f2, -20.0f);
        this.arrowPath.close();
        if (bitmap != null) {
            float f3 = f2 * 50.0f;
            RectF rectF = new RectF(-50.0f, -120.0f, 50.0f, -20.0f);
            BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            float fMin = f3 / Math.min(bitmap.getWidth(), bitmap.getHeight());
            Matrix matrix = new Matrix();
            matrix.setScale(fMin, fMin);
            matrix.postTranslate(rectF.left + ((f3 - (bitmap.getWidth() * fMin)) / f2), rectF.top + ((f3 - (bitmap.getHeight() * fMin)) / f2));
            bitmapShader.setLocalMatrix(matrix);
            Paint paint = new Paint(1);
            paint.setShader(bitmapShader);
            canvas.drawCircle(0.0f, -70.0f, 50.0f, paint);
        } else {
            canvas.drawCircle(0.0f, -70.0f, 50.0f, this.markerFillPaint);
        }
        this.markerPaint.setColor(circleColor);
        canvas.drawCircle(0.0f, -70.0f, 50.0f, this.markerPaint);
        this.arrowFillPaint.setColor(arrowColor);
        canvas.drawPath(this.arrowPath, this.arrowFillPaint);
        canvas.restore();
    }

    private final void drawMapMarker(Canvas canvas, float distance, int color, Bitmap bitmap) {
        float fCoerceIn = this.pathLength * RangesKt.coerceIn(distance / this.totalDistanceKm, 0.0f, 1.0f);
        float[] fArr = new float[2];
        PathMeasure pathMeasure = this.pathMeasure;
        if (pathMeasure != null) {
            pathMeasure.getPosTan(fCoerceIn, fArr, null);
            drawMapMarkerWithSmallArrow(canvas, fArr[0], fArr[1], color, color, bitmap);
        }
    }

    static /* synthetic */ void drawMarkerBubble$default(AnimatedPathImgForLoop animatedPathImgForLoop, Canvas canvas, float f, float f2, String str, float f3, float f4, float f5, float f6, int i, Object obj) {
        animatedPathImgForLoop.drawMarkerBubble(canvas, f, f2, str, (i & 16) != 0 ? 20.0f : f3, (i & 32) != 0 ? 40.0f : f4, (i & 64) != 0 ? 10.0f : f5, (i & 128) != 0 ? 12.0f : f6);
    }

    private final void drawMarkerBubble(Canvas canvas, float centerX, float centerY, String text, float horizontalPadding, float bubbleHeight, float tailHeight, float radius) {
        float f = 2;
        float fMeasureText = (this.grayMarkerTextPaint.measureText(text) + (horizontalPadding * f)) / f;
        float f2 = centerX - fMeasureText;
        float f3 = centerY - (bubbleHeight + tailHeight);
        float f4 = fMeasureText + centerX;
        float f5 = centerY - tailHeight;
        Path path = new Path();
        float f6 = f2 + radius;
        path.moveTo(f6, f3);
        float f7 = f4 - radius;
        path.lineTo(f7, f3);
        float f8 = f3 + radius;
        path.quadTo(f4, f3, f4, f8);
        float f9 = f5 - radius;
        path.lineTo(f4, f9);
        path.quadTo(f4, f5, f7, f5);
        path.lineTo(centerX + 10.0f, f5);
        path.lineTo(centerX, centerY);
        path.lineTo(centerX - 10.0f, f5);
        path.lineTo(f6, f5);
        path.quadTo(f2, f5, f2, f9);
        path.lineTo(f2, f8);
        path.quadTo(f2, f3, f6, f3);
        path.close();
        canvas.drawPath(path, this.grayMarkerPaint);
        canvas.drawText(text, centerX, (f3 + (bubbleHeight / f)) - ((this.grayMarkerTextPaint.descent() + this.grayMarkerTextPaint.ascent()) / f), this.grayMarkerTextPaint);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
        this.handler.removeCallbacks(this.resetCenterRunnable);
    }

    public final void centerToMainUser() {
        this.isDragging = false;
        Timber.INSTANCE.e("isDragging centerToMainUser:%s", Boolean.valueOf(this.isDragging));
        PathMeasure pathMeasure = this.pathMeasure;
        if (pathMeasure != null) {
            float[] fArr = new float[2];
            pathMeasure.getPosTan(this.pathLength * RangesKt.coerceIn(this.currentDistance / this.totalDistanceKm, 0.0f, 1.0f), fArr, null);
            this.translateX = (getWidth() / 2.0f) - (fArr[0] * this.scaleFactor);
            this.translateY = (getHeight() / 2.0f) - (fArr[1] * this.scaleFactor);
            invalidate();
        }
    }

    public final void loadBitmapFromUrl(Context context, String url, final Function1<? super Bitmap, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        Glide.with(context).asBitmap().load(url).into((RequestBuilder<Bitmap>) new CustomTarget<Bitmap>() { // from class: com.soletreadmills.sole_v2.ui.widget.AnimatedPathImgForLoop.loadBitmapFromUrl.1
            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
                onComplete.invoke(null);
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(Drawable errorDrawable) {
                onComplete.invoke(null);
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                onComplete.invoke(resource);
            }
        });
    }
}
