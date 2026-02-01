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
import com.facebook.appevents.AppEventsConstants;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.joda.time.DateTime;

/* loaded from: classes.dex */
public class CalendarDayView extends View {
    private static final String[] RES_TIME_TEXTS = {"12AM", "", "1AM", "", "2AM", "", "3AM", "", "4AM", "", "5AM", "", "6AM", "", "7AM", "", "8AM", "", "9AM", "", "10AM", "", "11AM", "", "12PM", "", "1PM", "", "2PM", "", "3PM", "", "4PM", "", "5PM", "", "6PM", "", "7PM", "", "8PM", "", "9PM", "", "10PM", "", "11PM", ""};
    private static final String TAG = "com.dyaco.sole.fragment.calendar.CalendarDayView";
    private final float LINE_HEIGHT_STEP;
    private final float LINE_LEFT_MARGIN;
    private final float LINE_LEFT_MARGIN_SECOND;
    private final float LINE_TOP_MARGIN;
    private final float MARK_LEFT_MARGIN;
    private final float TEXT_TOP_MARGIN;
    private final float TIME_TEXT_SIZE;
    private Paint bluePaint;
    private Rect blueRect;
    private Context context;
    private String firstRecording;
    private OnClickTrackViewListener mOnClickTrackViewListener;
    private ArrayList<MarkData> markArray;
    private Paint paint;
    private Paint paint1;
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

    public CalendarDayView(Context context) throws Resources.NotFoundException {
        super(context);
        this.firstRecording = "";
        Resources resources = getResources();
        this.res = resources;
        float dimension = resources.getDimension(R.dimen.calendar_week_margin_start);
        this.LINE_LEFT_MARGIN = dimension;
        this.LINE_LEFT_MARGIN_SECOND = this.res.getDimension(R.dimen.calendar_week_second_margin_start);
        this.LINE_TOP_MARGIN = Global.dpToPixel(6.0f);
        this.LINE_HEIGHT_STEP = this.res.getDimension(R.dimen.calendar_week_line_height);
        float dimension2 = this.res.getDimension(R.dimen.calendar_list_title_text_size);
        this.TIME_TEXT_SIZE = dimension2;
        this.TEXT_TOP_MARGIN = dimension2 / 2.5f;
        this.MARK_LEFT_MARGIN = dimension + Global.dpToPixel(60.0f);
        this.context = context;
        init();
    }

    public CalendarDayView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.firstRecording = "";
        Resources resources = getResources();
        this.res = resources;
        float dimension = resources.getDimension(R.dimen.calendar_week_margin_start);
        this.LINE_LEFT_MARGIN = dimension;
        this.LINE_LEFT_MARGIN_SECOND = this.res.getDimension(R.dimen.calendar_week_second_margin_start);
        this.LINE_TOP_MARGIN = Global.dpToPixel(6.0f);
        this.LINE_HEIGHT_STEP = this.res.getDimension(R.dimen.calendar_week_line_height);
        float dimension2 = this.res.getDimension(R.dimen.calendar_list_title_text_size);
        this.TIME_TEXT_SIZE = dimension2;
        this.TEXT_TOP_MARGIN = dimension2 / 2.5f;
        this.MARK_LEFT_MARGIN = dimension + Global.dpToPixel(60.0f);
        this.context = context;
        init();
    }

    public CalendarDayView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.firstRecording = "";
        Resources resources = getResources();
        this.res = resources;
        float dimension = resources.getDimension(R.dimen.calendar_week_margin_start);
        this.LINE_LEFT_MARGIN = dimension;
        this.LINE_LEFT_MARGIN_SECOND = this.res.getDimension(R.dimen.calendar_week_second_margin_start);
        this.LINE_TOP_MARGIN = Global.dpToPixel(6.0f);
        this.LINE_HEIGHT_STEP = this.res.getDimension(R.dimen.calendar_week_line_height);
        float dimension2 = this.res.getDimension(R.dimen.calendar_list_title_text_size);
        this.TIME_TEXT_SIZE = dimension2;
        this.TEXT_TOP_MARGIN = dimension2 / 2.5f;
        this.MARK_LEFT_MARGIN = dimension + Global.dpToPixel(60.0f);
        this.context = context;
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setStrokeWidth(2.0f);
        this.paint.setColor(this.res.getColor(R.color.light_gray));
        this.paint.setTextSize(this.TIME_TEXT_SIZE);
        Paint paint2 = new Paint();
        this.bluePaint = paint2;
        paint2.setColor(this.res.getColor(R.color.display_number_blue));
        this.bluePaint.setTextSize(this.TIME_TEXT_SIZE);
        this.paint1 = new Paint();
        int i = Global.BRAND;
        if (i == 0) {
            this.paint.setColor(this.res.getColor(R.color.light_gray));
            this.paint1.setColor(this.res.getColor(R.color.black));
        } else if (i == 1 || i == 2 || i == 3) {
            this.paint.setColor(this.res.getColor(R.color.black));
            this.paint1.setColor(this.res.getColor(R.color.white));
        }
        this.paint1.setTextSize(this.TIME_TEXT_SIZE);
        this.markArray = new ArrayList<>();
        this.blueRect = new Rect();
        this.textBounds = new Rect();
    }

    private void getCanvasSize(Canvas canvas) {
        this.viewWidth = canvas.getWidth();
        this.viewHeight = canvas.getHeight();
    }

    public void addMark(int[] iArr, int[] iArr2, String str) {
        this.markArray.add(new MarkData(iArr, iArr2, str));
    }

    public void updateView(String str) {
        String string;
        DateTime dateTime = DateTime.parse(str);
        DateTime dateTimePlusDays = DateTime.parse(str).plusDays(1);
        String str2 = TAG;
        Log.d(str2, "startDate = " + dateTime);
        Log.d(str2, "endDate = " + dateTimePlusDays);
        Logger.d("endDate = " + dateTimePlusDays);
        DbManager.getInstance(this.context);
        QueryBuilder<DCTrainingData> queryBuilder = DbManager.getDCTrainingDataDao().queryBuilder();
        queryBuilder.where(queryBuilder.and(DCTrainingDataDao.Properties.Training_datetime.between(dateTime.toDate(), dateTimePlusDays.toDate()), DCTrainingDataDao.Properties.Account.eq(Global.calendarUserName), new WhereCondition[0]), new WhereCondition[0]);
        List<DCTrainingData> list = queryBuilder.list();
        Log.d(str2, "list = " + list);
        this.markArray.clear();
        this.firstRecording = "";
        this.trackCalories = null;
        this.trackStartDate = null;
        this.trackDuration = null;
        this.trackDistance = null;
        this.trackSpeed = null;
        this.trackHeartRate = null;
        for (DCTrainingData dCTrainingData : list) {
            DateTime dateTime2 = new DateTime(dCTrainingData.getTraining_datetime());
            DateTime dateTimePlusSeconds = dateTime2.plusSeconds((int) dCTrainingData.getTotal_time());
            int[] iArr = {dateTime2.getHourOfDay(), dateTime2.getMinuteOfHour()};
            int[] iArr2 = {dateTimePlusSeconds.getHourOfDay(), dateTimePlusSeconds.getMinuteOfHour()};
            int total_time = (int) dCTrainingData.getTotal_time();
            Global.getFillString(total_time / 3600, 2, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            int i = total_time / 60;
            Global.getFillString(total_time % 60, 2, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            try {
                string = getResources().getString(DeviceModelList.programTexts.get(dCTrainingData.getProgram_name()).intValue());
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
                string = "";
                addMark(iArr, iArr2, string + StringUtils.SPACE + this.res.getString(R.string.workout) + ": " + String.valueOf(i) + StringUtils.SPACE + this.res.getString(R.string.minutes) + StringUtils.SPACE + dateTime2.toString("hh:mm a") + " - " + dateTimePlusSeconds.toString("hh:mm a"));
            } catch (Exception e2) {
                e2.printStackTrace();
                string = "";
                addMark(iArr, iArr2, string + StringUtils.SPACE + this.res.getString(R.string.workout) + ": " + String.valueOf(i) + StringUtils.SPACE + this.res.getString(R.string.minutes) + StringUtils.SPACE + dateTime2.toString("hh:mm a") + " - " + dateTimePlusSeconds.toString("hh:mm a"));
            }
            addMark(iArr, iArr2, string + StringUtils.SPACE + this.res.getString(R.string.workout) + ": " + String.valueOf(i) + StringUtils.SPACE + this.res.getString(R.string.minutes) + StringUtils.SPACE + dateTime2.toString("hh:mm a") + " - " + dateTimePlusSeconds.toString("hh:mm a"));
        }
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
        Iterator<MarkData> it = this.markArray.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            int timeStart = (int) (this.LINE_HEIGHT_STEP * next.getTimeStart());
            if (timeStart == 0) {
                timeStart += (int) this.LINE_TOP_MARGIN;
            }
            int timeEnd = (int) (this.LINE_HEIGHT_STEP * next.getTimeEnd());
            int i3 = (int) this.MARK_LEFT_MARGIN;
            int i4 = (int) (this.viewWidth - i3);
            float f7 = timeEnd - timeStart;
            float f8 = this.LINE_HEIGHT_STEP;
            if (f7 < f8) {
                timeEnd = (int) (timeEnd + f8);
                next.setTimeEnd(timeEnd);
            }
            this.blueRect.set(i3, timeStart, i4, timeEnd);
            canvas.drawRect(this.blueRect, this.bluePaint);
            String info = next.getInfo();
            this.paint.getTextBounds(info, 0, info.length(), this.textBounds);
            canvas.drawText(info, (this.viewWidth / 2.0f) - (this.textBounds.width() / 2.0f), ((timeStart + timeEnd) / 2.0f) + (this.textBounds.height() / 2.0f), this.paint1);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            Log.d("--------------", "ACTION_DOWN");
            return true;
        }
        if (action == 1) {
            Log.d("--------------", "ACTION_UP");
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            Iterator<MarkData> it = this.markArray.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                int timeStart = (int) (this.LINE_HEIGHT_STEP * next.getTimeStart());
                if (timeStart == 0) {
                    timeStart += (int) this.LINE_TOP_MARGIN;
                }
                int timeEnd = (int) (this.LINE_HEIGHT_STEP * next.getTimeEnd());
                int i = (int) this.MARK_LEFT_MARGIN;
                int i2 = (int) (this.viewWidth - i);
                if (x >= i && x <= i2 && y >= timeStart && y <= timeEnd) {
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

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(i, (int) (this.LINE_HEIGHT_STEP * RES_TIME_TEXTS.length));
    }

    private class MarkData {
        private String info;
        private int timeEnd;
        private int timeStart;

        public MarkData(int[] iArr, int[] iArr2, String str) {
            this.info = str;
            int i = iArr[0] * 2;
            this.timeStart = i;
            int i2 = iArr[1];
            int i3 = iArr2[0] * 2;
            this.timeEnd = i3;
            int i4 = iArr2[1];
            if (i2 >= 30) {
                this.timeStart = i + 1;
            }
            if (i4 >= 30) {
                this.timeEnd = i3 + 1;
            }
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
