package com.dyaco.sole.fragment.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.joda.time.DateTime;

/* loaded from: classes.dex */
public class CalendarWeekView extends View {
    private static final String[] RES_TIME_TEXTS = {"12AM", "", "1AM", "", "2AM", "", "3AM", "", "4AM", "", "5AM", "", "6AM", "", "7AM", "", "8AM", "", "9AM", "", "10AM", "", "11AM", "", "12PM", "", "1PM", "", "2PM", "", "3PM", "", "4PM", "", "5PM", "", "6PM", "", "7PM", "", "8PM", "", "9PM", "", "10PM", "", "11PM", ""};
    private static final String TAG = "com.dyaco.sole.fragment.calendar.CalendarWeekView";
    private float GRAY_MARGIN_LEFT;
    private final float LINE_HEIGHT_STEP;
    private final float LINE_LEFT_MARGIN;
    private final float LINE_LEFT_MARGIN_SECOND;
    private final float LINE_TOP_MARGIN;
    private final float TEXT_TOP_MARGIN;
    private final float TIME_TEXT_SIZE;
    private Paint blackPaint;
    private Paint bluePaint;
    private Rect blueRect;
    private Context context;
    private String firstRecording;
    private float grayBgCenter;
    private Paint grayBgPaint;
    private Rect grayRect;
    private float grayWidthSplit;
    private OnClickTrackViewListener mOnClickTrackViewListener;
    private ArrayList<MarkData> markArray;
    private Paint paint;
    private Resources res;
    private Rect textBounds;
    private String trackCalories;
    private String trackDistance;
    private String trackDuration;
    private String trackHeartRate;
    private String trackSpeed;
    private String trackStartDate;
    private float viewHeight;
    private float viewWidth;

    public interface OnClickTrackViewListener {
        void onClickView();
    }

    public void setOnClickTrackViewListener(OnClickTrackViewListener onClickTrackViewListener) {
        this.mOnClickTrackViewListener = onClickTrackViewListener;
    }

    public CalendarWeekView(Context context) throws Resources.NotFoundException {
        super(context);
        this.firstRecording = "";
        Resources resources = getResources();
        this.res = resources;
        float dimension = resources.getDimension(R.dimen.calendar_week_margin_start);
        this.LINE_LEFT_MARGIN = dimension;
        this.LINE_LEFT_MARGIN_SECOND = this.res.getDimension(R.dimen.calendar_week_second_margin_start);
        this.LINE_TOP_MARGIN = Global.dpToPixel(4.0f);
        this.LINE_HEIGHT_STEP = this.res.getDimension(R.dimen.calendar_week_line_height);
        float dimension2 = this.res.getDimension(R.dimen.calendar_list_title_text_size);
        this.TIME_TEXT_SIZE = dimension2;
        this.TEXT_TOP_MARGIN = dimension2 / 2.5f;
        this.GRAY_MARGIN_LEFT = dimension / 2.0f;
        this.context = context;
        init();
    }

    public CalendarWeekView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.firstRecording = "";
        Resources resources = getResources();
        this.res = resources;
        float dimension = resources.getDimension(R.dimen.calendar_week_margin_start);
        this.LINE_LEFT_MARGIN = dimension;
        this.LINE_LEFT_MARGIN_SECOND = this.res.getDimension(R.dimen.calendar_week_second_margin_start);
        this.LINE_TOP_MARGIN = Global.dpToPixel(4.0f);
        this.LINE_HEIGHT_STEP = this.res.getDimension(R.dimen.calendar_week_line_height);
        float dimension2 = this.res.getDimension(R.dimen.calendar_list_title_text_size);
        this.TIME_TEXT_SIZE = dimension2;
        this.TEXT_TOP_MARGIN = dimension2 / 2.5f;
        this.GRAY_MARGIN_LEFT = dimension / 2.0f;
        this.context = context;
        init();
    }

    public CalendarWeekView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.firstRecording = "";
        Resources resources = getResources();
        this.res = resources;
        float dimension = resources.getDimension(R.dimen.calendar_week_margin_start);
        this.LINE_LEFT_MARGIN = dimension;
        this.LINE_LEFT_MARGIN_SECOND = this.res.getDimension(R.dimen.calendar_week_second_margin_start);
        this.LINE_TOP_MARGIN = Global.dpToPixel(4.0f);
        this.LINE_HEIGHT_STEP = this.res.getDimension(R.dimen.calendar_week_line_height);
        float dimension2 = this.res.getDimension(R.dimen.calendar_list_title_text_size);
        this.TIME_TEXT_SIZE = dimension2;
        this.TEXT_TOP_MARGIN = dimension2 / 2.5f;
        this.GRAY_MARGIN_LEFT = dimension / 2.0f;
        this.context = context;
        init();
    }

    private void init() {
        this.res = getResources();
        this.grayRect = new Rect();
        this.blueRect = new Rect();
        Paint paint = new Paint();
        this.paint = paint;
        paint.setStrokeWidth(2.0f);
        this.paint.setTextSize(this.TIME_TEXT_SIZE);
        Paint paint2 = new Paint();
        this.grayBgPaint = paint2;
        paint2.setColor(this.res.getColor(R.color.transparent_gray));
        this.grayBgPaint.setTextSize(this.TIME_TEXT_SIZE);
        Paint paint3 = new Paint();
        this.bluePaint = paint3;
        paint3.setColor(this.res.getColor(R.color.display_number_blue));
        this.bluePaint.setTextSize(this.TIME_TEXT_SIZE);
        Paint paint4 = new Paint();
        this.blackPaint = paint4;
        paint4.setTextSize(this.TIME_TEXT_SIZE);
        int i = Global.BRAND;
        if (i == 0) {
            this.paint.setColor(this.res.getColor(R.color.light_gray));
            this.blackPaint.setColor(this.res.getColor(R.color.black));
        } else if (i == 1 || i == 2 || i == 3) {
            this.paint.setColor(this.res.getColor(R.color.black));
            this.blackPaint.setColor(this.res.getColor(R.color.white));
        }
        this.markArray = new ArrayList<>();
        this.textBounds = new Rect();
    }

    private void getCanvasSize(Canvas canvas) {
        this.viewWidth = canvas.getWidth();
        this.viewHeight = canvas.getHeight();
        float f = (int) ((this.viewWidth - this.LINE_LEFT_MARGIN) / 8.0f);
        this.grayWidthSplit = f;
        this.grayBgCenter = f / 2.0f;
    }

    private void addMark(int i, int[] iArr, int[] iArr2, String str) {
        if (i == 7) {
            i = 0;
        }
        this.markArray.add(new MarkData(i, iArr, iArr2, str));
    }

    public void updateView(String str) throws Resources.NotFoundException {
        String string;
        String[] strArrSplit = str.split("&");
        DateTime dateTime = DateTime.parse(strArrSplit[0]);
        DateTime dateTimePlusDays = DateTime.parse(strArrSplit[1]).plusDays(1);
        DbManager.getInstance(this.context);
        QueryBuilder<DCTrainingData> queryBuilder = DbManager.getDCTrainingDataDao().queryBuilder();
        queryBuilder.where(queryBuilder.and(DCTrainingDataDao.Properties.Training_datetime.between(dateTime.toDate(), dateTimePlusDays.toDate()), DCTrainingDataDao.Properties.Account.eq(Global.calendarUserName), new WhereCondition[0]), new WhereCondition[0]);
        List<DCTrainingData> list = queryBuilder.list();
        Log.d(TAG, "list = " + list);
        this.markArray.clear();
        this.firstRecording = "";
        this.trackCalories = null;
        this.trackStartDate = null;
        this.trackDuration = null;
        this.trackDistance = null;
        this.trackSpeed = null;
        this.trackHeartRate = null;
        Logger.d("trainingDatas = " + list);
        for (DCTrainingData dCTrainingData : list) {
            DateTime dateTime2 = new DateTime(dCTrainingData.getTraining_datetime());
            DateTime dateTimePlusSeconds = dateTime2.plusSeconds((int) dCTrainingData.getTotal_time());
            int dayOfWeek = dateTime2.getDayOfWeek();
            int[] iArr = {dateTime2.getHourOfDay(), dateTime2.getMinuteOfHour()};
            int[] iArr2 = {dateTimePlusSeconds.getHourOfDay(), dateTimePlusSeconds.getMinuteOfHour()};
            try {
                string = getResources().getString(DeviceModelList.programTexts.get(dCTrainingData.getProgram_name()).intValue());
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
                string = "";
                addMark(dayOfWeek, iArr, iArr2, string);
            } catch (Exception e2) {
                e2.printStackTrace();
                string = "";
                addMark(dayOfWeek, iArr, iArr2, string);
            }
            addMark(dayOfWeek, iArr, iArr2, string);
        }
        Log.d(TAG, "markArray = " + this.markArray);
        invalidate();
    }

    public String getFirstRecording() {
        return this.firstRecording;
    }

    public String getTrackCalories() {
        return this.trackCalories;
    }

    public String getTrackStartDate() {
        return this.trackStartDate;
    }

    public String getTrackDuration() {
        return this.trackDuration;
    }

    public String getTrackDistance() {
        return this.trackDistance;
    }

    public String getTrackSpeed() {
        return this.trackSpeed;
    }

    public String getTrackHeartRate() {
        return this.trackHeartRate;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.viewWidth == 0.0f || this.viewHeight == 0.0f) {
            getCanvasSize(canvas);
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = RES_TIME_TEXTS;
            if (i >= strArr.length) {
                break;
            }
            float f = i2;
            if (i == 0) {
                f += this.LINE_TOP_MARGIN;
            }
            float f2 = f;
            String str = strArr[i];
            canvas.drawText(str, 0.0f, this.TEXT_TOP_MARGIN + f2, this.paint);
            if (!str.equals("")) {
                float f3 = this.LINE_LEFT_MARGIN;
                canvas.drawLine(f3, f2, this.viewWidth - f3, f2, this.paint);
            } else {
                float f4 = this.LINE_LEFT_MARGIN_SECOND;
                float f5 = this.viewWidth;
                float f6 = this.LINE_LEFT_MARGIN;
                canvas.drawLine(f4, f2, (f5 - f6) - (f4 - f6), f2, this.paint);
            }
            i2 = (int) (i2 + this.LINE_HEIGHT_STEP);
            i++;
        }
        float f7 = (this.grayWidthSplit * 4.0f) + this.GRAY_MARGIN_LEFT;
        Rect rect = this.grayRect;
        float f8 = this.grayBgCenter;
        rect.set((int) (f7 - f8), (int) this.LINE_TOP_MARGIN, (int) (f7 + f8), (int) this.viewHeight);
        canvas.drawRect(this.grayRect, this.grayBgPaint);
        float f9 = (this.grayWidthSplit * 2.0f) + this.GRAY_MARGIN_LEFT;
        Rect rect2 = this.grayRect;
        float f10 = this.grayBgCenter;
        rect2.set((int) (f9 - f10), (int) this.LINE_TOP_MARGIN, (int) (f9 + f10), (int) this.viewHeight);
        canvas.drawRect(this.grayRect, this.grayBgPaint);
        float f11 = (this.grayWidthSplit * 6.0f) + this.GRAY_MARGIN_LEFT;
        Rect rect3 = this.grayRect;
        float f12 = this.grayBgCenter;
        rect3.set((int) (f11 - f12), (int) this.LINE_TOP_MARGIN, (int) (f11 + f12), (int) this.viewHeight);
        canvas.drawRect(this.grayRect, this.grayBgPaint);
        float f13 = (this.GRAY_MARGIN_LEFT + this.grayWidthSplit) - this.grayBgCenter;
        int iDpToPixel = (int) Global.dpToPixel(2.0f);
        Iterator<MarkData> it = this.markArray.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            int week = next.getWeek();
            int timeStart = (int) (this.LINE_HEIGHT_STEP * next.getTimeStart());
            if (timeStart == 0) {
                timeStart += (int) this.LINE_TOP_MARGIN;
            }
            int timeEnd = (int) (this.LINE_HEIGHT_STEP * next.getTimeEnd());
            float f14 = this.grayWidthSplit;
            int i3 = (int) ((week * f14) + f13);
            int i4 = (int) ((f14 * (week + 1)) + f13);
            float f15 = timeEnd - timeStart;
            float f16 = this.LINE_HEIGHT_STEP;
            if (f15 < f16) {
                timeEnd = (int) (timeEnd + f16);
                next.setTimeEnd(timeEnd);
            }
            this.blueRect.set(i3 + iDpToPixel, timeStart, i4 - iDpToPixel, timeEnd);
            canvas.drawRect(this.blueRect, this.bluePaint);
            String info = next.getInfo();
            this.paint.getTextBounds(info, 0, info.length(), this.textBounds);
            canvas.drawText(info, (i3 + this.grayBgCenter) - (this.textBounds.width() / 2.0f), ((timeStart + timeEnd) / 2.0f) + (this.textBounds.height() / 2.0f), this.blackPaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(i, (int) (this.LINE_HEIGHT_STEP * RES_TIME_TEXTS.length));
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            return true;
        }
        if (action == 1) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            float f = (this.GRAY_MARGIN_LEFT + this.grayWidthSplit) - this.grayBgCenter;
            int iDpToPixel = (int) Global.dpToPixel(2.0f);
            Iterator<MarkData> it = this.markArray.iterator();
            while (it.hasNext()) {
                int week = it.next().getWeek();
                int timeStart = (int) (this.LINE_HEIGHT_STEP * r6.getTimeStart());
                if (timeStart == 0) {
                    timeStart += (int) this.LINE_TOP_MARGIN;
                }
                int timeEnd = (int) (this.LINE_HEIGHT_STEP * r6.getTimeEnd());
                float f2 = this.grayWidthSplit;
                int i = (int) ((week * f2) + f);
                int i2 = (int) ((f2 * (week + 1)) + f);
                if (x >= i + iDpToPixel && x <= i2 - iDpToPixel && y >= timeStart && y <= timeEnd) {
                    OnClickTrackViewListener onClickTrackViewListener = this.mOnClickTrackViewListener;
                    if (onClickTrackViewListener != null) {
                        onClickTrackViewListener.onClickView();
                    }
                    return true;
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private class MarkData {
        private String info;
        private int timeEnd;
        private int timeStart;
        private int week;

        public MarkData(int i, int[] iArr, int[] iArr2, String str) {
            this.week = i;
            this.info = str;
            int i2 = iArr[0] * 2;
            this.timeStart = i2;
            int i3 = iArr[1];
            int i4 = iArr2[0] * 2;
            this.timeEnd = i4;
            int i5 = iArr2[1];
            if (i3 >= 30) {
                this.timeStart = i2 + 1;
            }
            if (i5 >= 30) {
                this.timeEnd = i4 + 1;
            }
        }

        public int getWeek() {
            return this.week;
        }

        public String getInfo() {
            return this.info;
        }

        public int getTimeStart() {
            return this.timeStart;
        }

        public int getTimeEnd() {
            return this.timeEnd;
        }

        public void setTimeEnd(int i) {
            this.timeEnd = i;
        }
    }
}
