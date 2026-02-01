package com.dyaco.sole.fragment.display;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.dyaco.sole.R2;
import com.dyaco.sole.custom.Global;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class S_DisplayDashboardView extends View {
    private static final int[] LEVEL = {0, 27, 44, 59, 75, 90, 106, 122, 138, R2.attr.circleCrop, 168, R2.attr.com_facebook_login_text, 207};
    private Bitmap bgBitmap;
    private float bitmapStartMargin;
    private float bitmapTopMargin;
    private Paint btBlackPaint;
    private RectF circleRectF;
    private boolean direction;
    private int lastLevel;
    private int level;
    private Paint paint;
    private Resources res;
    private float viewHeight;
    private float viewWidth;

    public S_DisplayDashboardView(Context context) {
        super(context);
        this.level = LEVEL[0];
        this.lastLevel = -1;
        this.direction = true;
    }

    public S_DisplayDashboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.level = LEVEL[0];
        this.lastLevel = -1;
        this.direction = true;
    }

    public S_DisplayDashboardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.level = LEVEL[0];
        this.lastLevel = -1;
        this.direction = true;
    }

    private void init(Canvas canvas) throws Resources.NotFoundException {
        this.res = getResources();
        this.viewWidth = canvas.getWidth();
        this.viewHeight = canvas.getHeight();
        try {
            this.bgBitmap = Bitmap.createScaledBitmap(Global.readBitmapFromStream(this.res, R.drawable.s_display_dashboard_a_table, 1), (int) this.viewWidth, (int) this.viewHeight, false);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.gc();
            this.bgBitmap = Bitmap.createScaledBitmap(Global.readBitmapFromStream(this.res, R.drawable.s_display_dashboard_a_table, 2), (int) this.viewWidth, (int) this.viewHeight, false);
        }
        this.bitmapStartMargin = 0.0f;
        this.bitmapTopMargin = 0.0f;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(this.res.getColor(R.color.spirit_program_red));
        Paint paint2 = new Paint();
        this.btBlackPaint = paint2;
        paint2.setColor(this.res.getColor(R.color.black));
        float dimension = this.res.getDimension(R.dimen.s_display_dashboard_view_margin);
        float f = this.bitmapStartMargin + dimension;
        float f2 = this.bitmapTopMargin + dimension;
        float f3 = this.viewWidth - dimension;
        float f4 = this.viewHeight;
        this.circleRectF = new RectF(f, f2, f3, (f4 - (0.16f * f4)) * 2.0f);
    }

    public void setLevelDirection(boolean z) {
        this.direction = z;
    }

    public void setLevel(float f) {
        int length = (int) f;
        if (length < 0) {
            length = 0;
        } else {
            int[] iArr = LEVEL;
            if (length >= iArr.length) {
                length = iArr.length - 1;
            }
        }
        int i = LEVEL[length];
        this.level = i;
        if (this.lastLevel != length) {
            this.lastLevel = i;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws Resources.NotFoundException {
        super.onDraw(canvas);
        if (this.viewWidth == 0.0f || this.viewHeight == 0.0f) {
            init(canvas);
        }
        canvas.drawArc(this.circleRectF, 0.0f, 360.0f, true, this.btBlackPaint);
        if (this.direction) {
            canvas.drawArc(this.circleRectF, -195.0f, this.level, true, this.paint);
        } else {
            canvas.drawArc(this.circleRectF, 15.0f, -this.level, true, this.paint);
        }
        Bitmap bitmap = this.bgBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.bitmapStartMargin, this.bitmapTopMargin, (Paint) null);
        }
    }
}
