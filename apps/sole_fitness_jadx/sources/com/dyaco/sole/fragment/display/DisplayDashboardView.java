package com.dyaco.sole.fragment.display;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class DisplayDashboardView extends View {
    private Bitmap bgBitmap;
    private Rect bgRect;
    private Paint bgWhitePaint;
    private float bitmapStartMargin;
    private float bitmapTopMargin;
    private boolean isLeftEModel;
    private boolean isLeftSC300Model;
    private boolean isLeftTT8Model;
    private boolean isRightSC300Model;
    private boolean isRightTT8Model;
    private boolean isStartDraw;
    private int leftLevel;
    private Resources res;
    private int rightLevel;
    private float viewHeight;
    private float viewWidth;
    private static final int[] RES_LEFT_IMAGE = {0, R.drawable.display_dashboard_a_table_l_1, R.drawable.display_dashboard_a_table_l_2, R.drawable.display_dashboard_a_table_l_3, R.drawable.display_dashboard_a_table_l_4, R.drawable.display_dashboard_a_table_l_5, R.drawable.display_dashboard_a_table_l_6, R.drawable.display_dashboard_a_table_l_7, R.drawable.display_dashboard_a_table_l_8, R.drawable.display_dashboard_a_table_l_9, R.drawable.display_dashboard_a_table_l_10, R.drawable.display_dashboard_a_table_l_11, R.drawable.display_dashboard_a_table_l_12, R.drawable.display_dashboard_a_table_l_13, R.drawable.display_dashboard_a_table_l_14, R.drawable.display_dashboard_a_table_l_15, R.drawable.display_dashboard_a_table_l_16, R.drawable.display_dashboard_a_table_l_17, R.drawable.display_dashboard_a_table_l_18};
    private static final int[] RES_LEFT_SC300_IMAGE = {0, R.drawable.display_dashboard_a_table_l_1, R.drawable.display_dashboard_a_table_l_2, R.drawable.display_dashboard_a_table_l_3, R.drawable.display_dashboard_a_table_l_4, R.drawable.display_dashboard_a_table_l_5, R.drawable.display_dashboard_a_table_l_6, R.drawable.display_dashboard_a_table_l_7, R.drawable.display_dashboard_a_table_l_8, R.drawable.display_dashboard_a_table_l_9, R.drawable.display_dashboard_a_table_l_10, R.drawable.display_dashboard_a_table_l_11, R.drawable.display_dashboard_a_table_l_12, R.drawable.display_dashboard_a_table_l_13, R.drawable.display_dashboard_a_table_l_14, R.drawable.display_dashboard_a_table_l_15, R.drawable.display_dashboard_a_table_l_16, R.drawable.display_dashboard_a_table_l_17, R.drawable.display_dashboard_a_table_l_18};
    private static final int[] RES_LEFT_E_IMAGE = {0, R.drawable.display_dashboard_a_table_l_1, R.drawable.display_dashboard_a_table_l_2, R.drawable.display_dashboard_a_table_l_3, R.drawable.display_dashboard_a_table_l_4, R.drawable.display_dashboard_a_table_l_5, R.drawable.display_dashboard_a_table_l_6, R.drawable.display_dashboard_a_table_l_7, R.drawable.display_dashboard_a_table_l_8, R.drawable.display_dashboard_a_table_l_9, R.drawable.display_dashboard_a_table_l_10, R.drawable.display_dashboard_a_table_l_11, R.drawable.display_dashboard_a_table_l_12, R.drawable.display_dashboard_a_table_l_13, R.drawable.display_dashboard_a_table_l_14, R.drawable.display_dashboard_a_table_l_15, R.drawable.display_dashboard_a_table_l_16, R.drawable.display_dashboard_a_table_l_17, R.drawable.display_dashboard_a_table_l_18};
    private static final int[] RES_LEFT_TT8_IMAGE = {R.drawable.display_tt8_dashboard_a_table_l_n_6, R.drawable.display_tt8_dashboard_a_table_l_n_5, R.drawable.display_tt8_dashboard_a_table_l_n_4, R.drawable.display_tt8_dashboard_a_table_l_n_3, R.drawable.display_tt8_dashboard_a_table_l_n_2, R.drawable.display_tt8_dashboard_a_table_l_n_1, 0, R.drawable.display_tt8_dashboard_a_table_l_1, R.drawable.display_tt8_dashboard_a_table_l_2, R.drawable.display_tt8_dashboard_a_table_l_3, R.drawable.display_tt8_dashboard_a_table_l_4, R.drawable.display_tt8_dashboard_a_table_l_5, R.drawable.display_tt8_dashboard_a_table_l_6, R.drawable.display_tt8_dashboard_a_table_l_7, R.drawable.display_tt8_dashboard_a_table_l_8, R.drawable.display_tt8_dashboard_a_table_l_9, R.drawable.display_tt8_dashboard_a_table_l_10, R.drawable.display_tt8_dashboard_a_table_l_11, R.drawable.display_tt8_dashboard_a_table_l_12};
    private static final int[] RES_RIGHT_IMAGE = {0, R.drawable.display_dashboard_a_table_r_1, R.drawable.display_dashboard_a_table_r_2, R.drawable.display_dashboard_a_table_r_3, R.drawable.display_dashboard_a_table_r_4, R.drawable.display_dashboard_a_table_r_5, R.drawable.display_dashboard_a_table_r_6, R.drawable.display_dashboard_a_table_r_7, R.drawable.display_dashboard_a_table_r_8, R.drawable.display_dashboard_a_table_r_9, R.drawable.display_dashboard_a_table_r_10, R.drawable.display_dashboard_a_table_r_11, R.drawable.display_dashboard_a_table_r_12, R.drawable.display_dashboard_a_table_r_13, R.drawable.display_dashboard_a_table_r_14, R.drawable.display_dashboard_a_table_r_15, R.drawable.display_dashboard_a_table_r_18};
    private static final int[] RES_RIGHT_SC300_IMAGE = {0, R.drawable.display_dashboard_a_table_r_1, R.drawable.display_dashboard_a_table_r_2, R.drawable.display_dashboard_a_table_r_3, R.drawable.display_dashboard_a_table_r_4, R.drawable.display_dashboard_a_table_r_5, R.drawable.display_dashboard_a_table_r_6, R.drawable.display_dashboard_a_table_r_7, R.drawable.display_dashboard_a_table_r_8, R.drawable.display_dashboard_a_table_r_9, R.drawable.display_dashboard_a_table_r_10, R.drawable.display_dashboard_a_table_r_11, R.drawable.display_dashboard_a_table_r_12, R.drawable.display_dashboard_a_table_r_13, R.drawable.display_dashboard_a_table_r_14, R.drawable.display_dashboard_a_table_r_15, R.drawable.display_dashboard_a_table_r_18};
    private static final int[] RES_RIGHT_TT8_IMAGE = {0, R.drawable.display_dashboard_a_table_r_1, R.drawable.display_dashboard_a_table_r_2, R.drawable.display_dashboard_a_table_r_3, R.drawable.display_dashboard_a_table_r_4, R.drawable.display_dashboard_a_table_r_5, R.drawable.display_dashboard_a_table_r_6, R.drawable.display_dashboard_a_table_r_7, R.drawable.display_dashboard_a_table_r_8, R.drawable.display_dashboard_a_table_r_9, R.drawable.display_dashboard_a_table_r_10, R.drawable.display_dashboard_a_table_r_11, R.drawable.display_dashboard_a_table_r_12, R.drawable.display_dashboard_a_table_r_13, R.drawable.display_dashboard_a_table_r_14, R.drawable.display_dashboard_a_table_r_15, R.drawable.display_dashboard_a_table_r_16, R.drawable.display_dashboard_a_table_r_17, R.drawable.display_dashboard_a_table_r_18};

    public DisplayDashboardView(Context context) {
        super(context);
    }

    public DisplayDashboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DisplayDashboardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init(Canvas canvas) {
        int i;
        this.res = getResources();
        this.viewWidth = canvas.getWidth();
        this.viewHeight = canvas.getHeight();
        if (ProtocolHandler.protocol.deviceModel == 149 && ProtocolHandler.protocol.salesVersion == 0) {
            i = R.drawable.display_dashboard_a_table_tt8;
        } else if (ProtocolHandler.protocol.deviceModel == 149 && ProtocolHandler.protocol.salesVersion == 1) {
            i = R.drawable.display_dashboard_a_table_tt8_us;
        } else if (ProtocolHandler.protocol.deviceModel < 22 || ProtocolHandler.protocol.deviceModel > 26) {
            i = (ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 30 || ProtocolHandler.protocol.deviceModel == 31) ? R.drawable.display_dashboard_a_table_sc300_a : R.drawable.display_dashboard_a_table;
        } else {
            i = R.drawable.display_dashboard_a_table_incline;
        }
        try {
            this.bgBitmap = Bitmap.createScaledBitmap(Global.readBitmapFromStream(this.res, i, 1), (int) this.viewWidth, (int) this.viewHeight, false);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.gc();
            this.bgBitmap = Bitmap.createScaledBitmap(Global.readBitmapFromStream(this.res, i, 2), (int) this.viewWidth, (int) this.viewHeight, false);
        }
        this.bitmapStartMargin = 0.0f;
        this.bitmapTopMargin = 0.0f;
        Paint paint = new Paint();
        this.bgWhitePaint = paint;
        paint.setColor(this.res.getColor(R.color.white));
        float f = this.bitmapStartMargin;
        this.bgRect = new Rect((int) f, (int) this.bitmapTopMargin, (int) (f + this.viewWidth), (int) this.viewHeight);
    }

    public void setLeftLevelE25E98View(int i) {
        this.isLeftEModel = true;
        if (i >= 16 && i <= 17) {
            i = 16;
        } else if (i >= 18 && i <= 19) {
            i = 17;
        } else if (i >= 20) {
            i = 18;
        }
        this.isStartDraw = true;
        this.leftLevel = i;
        if (i < 0) {
            i = 0;
        } else {
            int[] iArr = RES_LEFT_E_IMAGE;
            if (i >= iArr.length) {
                i = iArr.length - 1;
            }
        }
        this.leftLevel = i;
        postInvalidate();
    }

    public void setLeftLevelTT8View(int i) {
        this.isLeftTT8Model = true;
        int length = i + 6;
        if (length >= 15 && length <= 16) {
            length = 15;
        } else if (length >= 17 && length <= 18) {
            length = 16;
        } else if (length >= 19 && length <= 20) {
            length = 17;
        } else if (length >= 21) {
            length = 18;
        }
        this.isStartDraw = true;
        this.leftLevel = length;
        if (length < 0) {
            length = 0;
        } else {
            int[] iArr = RES_LEFT_TT8_IMAGE;
            if (length >= iArr.length) {
                length = iArr.length - 1;
            }
        }
        this.leftLevel = length;
        postInvalidate();
    }

    public void setLeftLevelSc300View(int i) {
        this.isLeftSC300Model = true;
        if (i >= 18) {
            i = 18;
        }
        this.isStartDraw = true;
        this.leftLevel = i;
        if (i < 0) {
            i = 0;
        } else {
            int[] iArr = RES_LEFT_SC300_IMAGE;
            if (i >= iArr.length) {
                i = iArr.length - 1;
            }
        }
        this.leftLevel = i;
        postInvalidate();
    }

    public void setRightLevelTT8View(int i) {
        this.isRightTT8Model = true;
        if (i >= 16 && i <= 17) {
            i = 16;
        } else if (i >= 18 && i <= 19) {
            i = 17;
        } else if (i >= 20) {
            i = 18;
        }
        this.isStartDraw = true;
        this.rightLevel = i;
        if (i < 0) {
            i = 0;
        } else {
            int[] iArr = RES_RIGHT_TT8_IMAGE;
            if (i >= iArr.length) {
                i = iArr.length - 1;
            }
        }
        this.rightLevel = i;
        postInvalidate();
    }

    public void setRightLevelSC300View(int i) {
        this.isRightSC300Model = true;
        Log.d("setRightLevelSC300View", "level = " + i);
        int length = i / 20;
        Log.d("setRightLevelSC300View", "level = " + length);
        this.isStartDraw = true;
        this.rightLevel = length;
        if (length < 0) {
            length = 0;
        } else {
            int[] iArr = RES_RIGHT_SC300_IMAGE;
            if (length >= iArr.length) {
                length = iArr.length - 1;
            }
        }
        this.rightLevel = length;
        postInvalidate();
    }

    public void setLeftLevelView(int i) {
        this.isLeftTT8Model = false;
        this.isLeftEModel = false;
        this.isLeftSC300Model = false;
        this.isStartDraw = true;
        this.leftLevel = i;
        if (i < 0) {
            i = 0;
        } else {
            int[] iArr = RES_LEFT_IMAGE;
            if (i >= iArr.length) {
                i = iArr.length - 1;
            }
        }
        this.leftLevel = i;
        postInvalidate();
    }

    public void setRightLevelView(int i) {
        this.isRightTT8Model = false;
        this.isRightSC300Model = false;
        this.isStartDraw = true;
        this.rightLevel = i;
        if (i < 0) {
            i = 0;
        } else {
            int[] iArr = RES_RIGHT_IMAGE;
            if (i >= iArr.length) {
                i = iArr.length - 1;
            }
        }
        this.rightLevel = i;
        postInvalidate();
    }

    private Bitmap getLeftLevelView() {
        Bitmap bitmapFromStream;
        int[] iArr = RES_LEFT_IMAGE;
        if (this.isLeftTT8Model) {
            iArr = RES_LEFT_TT8_IMAGE;
        } else if (this.isLeftEModel) {
            iArr = RES_LEFT_E_IMAGE;
        } else if (this.isLeftSC300Model) {
            iArr = RES_LEFT_SC300_IMAGE;
        }
        int i = this.leftLevel;
        if (i >= iArr.length) {
            return null;
        }
        try {
            bitmapFromStream = Global.readBitmapFromStream(this.res, iArr[i], 1);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            bitmapFromStream = Global.readBitmapFromStream(this.res, iArr[this.leftLevel], 2);
        }
        if (bitmapFromStream == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmapFromStream, (int) this.viewWidth, (int) this.viewHeight, false);
    }

    private Bitmap getRightLevelView() {
        Bitmap bitmapFromStream;
        int[] iArr = RES_RIGHT_IMAGE;
        if (this.isRightTT8Model) {
            iArr = RES_RIGHT_TT8_IMAGE;
        }
        int i = this.rightLevel;
        if (i >= iArr.length) {
            return null;
        }
        try {
            bitmapFromStream = Global.readBitmapFromStream(this.res, iArr[i], 1);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            bitmapFromStream = Global.readBitmapFromStream(this.res, iArr[this.rightLevel], 2);
        }
        if (bitmapFromStream == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmapFromStream, (int) this.viewWidth, (int) this.viewHeight, false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.viewWidth == 0.0f || this.viewHeight == 0.0f) {
            init(canvas);
        }
        if (!this.isStartDraw) {
            canvas.drawRect(this.bgRect, this.bgWhitePaint);
            canvas.drawBitmap(this.bgBitmap, this.bitmapStartMargin, this.bitmapTopMargin, (Paint) null);
            return;
        }
        canvas.drawRect(this.bgRect, this.bgWhitePaint);
        Bitmap leftLevelView = getLeftLevelView();
        if (leftLevelView != null) {
            canvas.drawBitmap(leftLevelView, this.bitmapStartMargin, this.bitmapTopMargin, (Paint) null);
        }
        Bitmap rightLevelView = getRightLevelView();
        if (rightLevelView != null) {
            canvas.drawBitmap(rightLevelView, this.bitmapStartMargin, this.bitmapTopMargin, (Paint) null);
        }
        canvas.drawBitmap(this.bgBitmap, this.bitmapStartMargin, this.bitmapTopMargin, (Paint) null);
    }
}
