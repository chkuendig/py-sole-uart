package com.dyaco.sole.custom_view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.dyaco.sole.custom.Global;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class TargetHRView extends View {
    private Bitmap bgBitmap;
    private int level;
    private int level50;
    private int level55;
    private int level60;
    private int level65;
    private int level70;
    private int level75;
    private int level80;
    private int level85;
    private int level90;
    private float marginStart;
    private Paint paint;
    private Rect rect;
    private Resources res;
    private int viewHeight;
    private int viewWidth;

    public TargetHRView(Context context) {
        super(context);
    }

    public TargetHRView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TargetHRView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init(Canvas canvas) {
        this.res = getResources();
        this.viewWidth = canvas.getWidth();
        int height = canvas.getHeight();
        this.viewHeight = height;
        this.marginStart = this.viewWidth / 2.6f;
        if (this.level == 0) {
            this.level = height;
        }
        this.bgBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.res, R.drawable.display_table), this.viewWidth, this.viewHeight, false);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(this.res.getColor(R.color.display_number_blue));
        this.rect = new Rect();
        this.level50 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_target_hr_level_50), 0.8f);
        this.level55 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_target_hr_level_55), 0.8f);
        this.level60 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_target_hr_level_60), 0.8f);
        this.level65 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_target_hr_level_65), 0.8f);
        this.level70 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_target_hr_level_70), 0.8f);
        this.level75 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_target_hr_level_75), 0.8f);
        this.level80 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_target_hr_level_80), 0.8f);
        this.level85 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_target_hr_level_85), 0.8f);
        this.level90 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_target_hr_level_90), 0.8f);
    }

    public void setLevel(int i) {
        if (this.res == null) {
            return;
        }
        if (i >= 0 && i < 48) {
            this.level = this.viewHeight;
        }
        if (i > 47 && i <= 52) {
            this.level = this.level50;
        } else if (i > 52 && i <= 57) {
            this.level = this.level55;
        } else if (i > 57 && i <= 62) {
            this.level = this.level60;
        } else if (i > 62 && i <= 67) {
            this.level = this.level65;
        } else if (i > 67 && i <= 72) {
            this.level = this.level70;
        } else if (i > 72 && i <= 77) {
            this.level = this.level75;
        } else if (i > 77 && i <= 82) {
            this.level = this.level80;
        } else if (i > 82 && i <= 87) {
            this.level = this.level85;
        } else if (i > 87) {
            this.level = this.level90;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.viewWidth == 0 || this.viewHeight == 0) {
            init(canvas);
        }
        this.rect.set((int) this.marginStart, this.level, this.viewWidth, this.viewHeight);
        canvas.drawRect(this.rect, this.paint);
        canvas.drawBitmap(this.bgBitmap, 0.0f, 0.0f, (Paint) null);
    }
}
