package com.dyaco.sole.fragment.display;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.dyaco.sole.custom.Global;
import com.soletreadmills.sole.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class X_DisplayDashboardView extends View {
    private Bitmap bgBitmap;
    private ArrayList<Bitmap> bitmapArray;
    private float bitmapStartMargin;
    private float bitmapTopMargin;
    private RectF circleRectF;
    private int colorType;
    private Paint grayPaint;
    private int lastLevelIndex;
    private Resources res;
    private float viewHeight;
    private float viewWidth;
    private static final int[] LEVEL_LEFT_RID = {R.drawable.x_display_dashboard_a_table_r_1, R.drawable.x_display_dashboard_a_table_r_2, R.drawable.x_display_dashboard_a_table_r_3, R.drawable.x_display_dashboard_a_table_r_4, R.drawable.x_display_dashboard_a_table_r_5, R.drawable.x_display_dashboard_a_table_r_6, R.drawable.x_display_dashboard_a_table_r_7, R.drawable.x_display_dashboard_a_table_r_8, R.drawable.x_display_dashboard_a_table_r_9, R.drawable.x_display_dashboard_a_table_r_10, R.drawable.x_display_dashboard_a_table_r_11, R.drawable.x_display_dashboard_a_table_r_12};
    private static final int[] LEVEL_CENTER_RID = {R.drawable.x_display_dashboard_a_table_db_1, R.drawable.x_display_dashboard_a_table_db_2, R.drawable.x_display_dashboard_a_table_db_3, R.drawable.x_display_dashboard_a_table_db_4, R.drawable.x_display_dashboard_a_table_db_5, R.drawable.x_display_dashboard_a_table_db_6, R.drawable.x_display_dashboard_a_table_db_7, R.drawable.x_display_dashboard_a_table_db_8, R.drawable.x_display_dashboard_a_table_db_9, R.drawable.x_display_dashboard_a_table_db_10, R.drawable.x_display_dashboard_a_table_db_11, R.drawable.x_display_dashboard_a_table_db_12};
    private static final int[] LEVEL_RIGHT_RID = {R.drawable.x_display_dashboard_a_table_b_1, R.drawable.x_display_dashboard_a_table_b_2, R.drawable.x_display_dashboard_a_table_b_3, R.drawable.x_display_dashboard_a_table_b_4, R.drawable.x_display_dashboard_a_table_b_5, R.drawable.x_display_dashboard_a_table_b_6, R.drawable.x_display_dashboard_a_table_b_7, R.drawable.x_display_dashboard_a_table_b_8, R.drawable.x_display_dashboard_a_table_b_9, R.drawable.x_display_dashboard_a_table_b_10, R.drawable.x_display_dashboard_a_table_b_11, R.drawable.x_display_dashboard_a_table_b_12};

    public X_DisplayDashboardView(Context context) {
        super(context);
    }

    public X_DisplayDashboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public X_DisplayDashboardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init(Canvas canvas) throws Resources.NotFoundException {
        this.res = getResources();
        Paint paint = new Paint();
        this.grayPaint = paint;
        paint.setColor(this.res.getColor(R.color.light_gray2));
        this.viewWidth = canvas.getWidth();
        this.viewHeight = canvas.getHeight();
        this.bitmapStartMargin = 0.0f;
        this.bitmapTopMargin = 0.0f;
        float dimension = this.res.getDimension(R.dimen.s_display_dashboard_view_margin);
        float f = this.bitmapStartMargin + dimension;
        float f2 = this.bitmapTopMargin + dimension;
        float f3 = this.viewWidth - dimension;
        float f4 = this.viewHeight;
        this.circleRectF = new RectF(f, f2, f3, (f4 - (0.16f * f4)) * 2.0f);
        this.bitmapArray = new ArrayList<>();
        try {
            this.bgBitmap = Bitmap.createScaledBitmap(Global.readBitmapFromStream(this.res, R.drawable.x_display_dashboard_a_table, 1), (int) this.viewWidth, (int) this.viewHeight, false);
            new Thread(new Runnable() { // from class: com.dyaco.sole.fragment.display.X_DisplayDashboardView.1
                @Override // java.lang.Runnable
                public void run() {
                    for (int i = 0; i < X_DisplayDashboardView.LEVEL_LEFT_RID.length; i++) {
                        Bitmap bitmapCreateScaledBitmap = null;
                        int i2 = X_DisplayDashboardView.this.colorType;
                        if (i2 == 0) {
                            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(Global.readBitmapFromStream(X_DisplayDashboardView.this.res, X_DisplayDashboardView.LEVEL_LEFT_RID[i], 1), (int) X_DisplayDashboardView.this.viewWidth, (int) X_DisplayDashboardView.this.viewHeight, false);
                        } else if (i2 == 1) {
                            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(Global.readBitmapFromStream(X_DisplayDashboardView.this.res, X_DisplayDashboardView.LEVEL_CENTER_RID[i], 1), (int) X_DisplayDashboardView.this.viewWidth, (int) X_DisplayDashboardView.this.viewHeight, false);
                        } else if (i2 == 2) {
                            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(Global.readBitmapFromStream(X_DisplayDashboardView.this.res, X_DisplayDashboardView.LEVEL_RIGHT_RID[i], 1), (int) X_DisplayDashboardView.this.viewWidth, (int) X_DisplayDashboardView.this.viewHeight, false);
                        }
                        X_DisplayDashboardView.this.bitmapArray.add(bitmapCreateScaledBitmap);
                    }
                }
            }).start();
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.gc();
        }
    }

    public void setLevelType(int i) {
        this.colorType = i;
    }

    public void setLevel(float f) {
        int length = (int) f;
        if (length < 0) {
            length = 0;
        } else {
            int[] iArr = LEVEL_LEFT_RID;
            if (length >= iArr.length) {
                length = iArr.length - 1;
            }
        }
        this.lastLevelIndex = length;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws Resources.NotFoundException {
        super.onDraw(canvas);
        if (this.viewWidth == 0.0f || this.viewHeight == 0.0f) {
            init(canvas);
        }
        canvas.drawArc(this.circleRectF, 0.0f, 360.0f, true, this.grayPaint);
        if (this.bitmapArray.size() == LEVEL_LEFT_RID.length) {
            canvas.drawBitmap(this.bitmapArray.get(this.lastLevelIndex), 0.0f, 0.0f, (Paint) null);
        }
        canvas.drawBitmap(this.bgBitmap, 0.0f, 0.0f, (Paint) null);
    }
}
