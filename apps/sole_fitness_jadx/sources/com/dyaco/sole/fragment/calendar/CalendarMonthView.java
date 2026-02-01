package com.dyaco.sole.fragment.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.dyaco.sole.BuildConfig;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom_view.LinesGridView;
import com.soletreadmills.sole.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.joda.time.DateTime;

/* loaded from: classes.dex */
public class CalendarMonthView extends LinesGridView {
    private static final int DAYS_COUNT = 35;
    private static final String TAG = "com.dyaco.sole.fragment.calendar.CalendarMonthView";
    private ArrayList<Date> cells;
    private Context context;
    private Date endDate;
    private String firstRecording;
    private int gridHeight;
    private ArrayList<MarkData> markArray;
    private Resources res;
    private Date startDate;
    private String trackCalories;
    private String trackDistance;
    private String trackDuration;
    private String trackHeartRate;
    private String trackSpeed;
    private String trackStartDate;

    public CalendarMonthView(Context context) {
        super(context);
        this.firstRecording = "";
        this.res = getResources();
        this.context = context;
    }

    public CalendarMonthView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.firstRecording = "";
        this.res = getResources();
        this.context = context;
        init();
    }

    public CalendarMonthView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.firstRecording = "";
        this.res = getResources();
        this.context = context;
        init();
    }

    private void init() {
        setNumColumns(7);
        setSelector(R.color.transparent);
        this.markArray = new ArrayList<>();
    }

    public void updateView(CalendarUtils calendarUtils) {
        Calendar calendar = calendarUtils.getCalendar();
        this.cells = getMonthCalendar(calendar);
        String nowMonthCalendarForSQL = calendarUtils.getNowMonthCalendarForSQL(this.startDate);
        String nowMonthCalendarForSQL2 = calendarUtils.getNowMonthCalendarForSQL(this.endDate);
        DateTime dateTime = DateTime.parse(nowMonthCalendarForSQL);
        DateTime dateTimePlusDays = DateTime.parse(nowMonthCalendarForSQL2).plusDays(1);
        DbManager.getInstance(this.context);
        QueryBuilder<DCTrainingData> queryBuilder = DbManager.getDCTrainingDataDao().queryBuilder();
        queryBuilder.where(queryBuilder.and(DCTrainingDataDao.Properties.Training_datetime.between(dateTime.toDate(), dateTimePlusDays.toDate()), DCTrainingDataDao.Properties.Account.eq(Global.calendarUserName), new WhereCondition[0]), new WhereCondition[0]);
        ArrayList arrayList = new ArrayList();
        for (DCTrainingData dCTrainingData : queryBuilder.list()) {
            String brand_code = dCTrainingData.getBrand_code();
            if (BuildConfig.FLAVOR.contains(brand_code) || "garmin".contains(brand_code)) {
                arrayList.add(dCTrainingData);
            }
        }
        Log.d(TAG, "list = " + arrayList);
        this.markArray.clear();
        this.firstRecording = "";
        this.trackCalories = null;
        this.trackStartDate = null;
        this.trackDuration = null;
        this.trackDistance = null;
        this.trackSpeed = null;
        this.trackHeartRate = null;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            DateTime dateTime2 = new DateTime(((DCTrainingData) it.next()).getTraining_datetime());
            int year = dateTime2.getYear();
            int monthOfYear = dateTime2.getMonthOfYear();
            int dayOfMonth = dateTime2.getDayOfMonth();
            String str = TAG;
            Log.d(str, "year = " + year);
            Log.d(str, "month = " + monthOfYear);
            Log.d(str, "day = " + dayOfMonth);
            this.markArray.add(new MarkData(year, monthOfYear, dayOfMonth));
        }
        Log.d(TAG, "markArray = " + this.markArray);
        invalidate();
        setAdapter((ListAdapter) new CalendarAdapter(getContext(), calendar, this.cells));
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
    public void onDraw(Canvas canvas) {
        if (this.gridHeight == 0) {
            this.gridHeight = Global.getLongScreenHeight((int) (canvas.getHeight() / 5.5f), 0.6f);
            setAdapter((ListAdapter) new CalendarAdapter(getContext(), null, this.cells));
        }
    }

    private ArrayList<Date> getMonthCalendar(Calendar calendar) {
        ArrayList<Date> arrayList = new ArrayList<>();
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.set(5, 1);
        calendar2.add(5, -(calendar2.get(7) - 1));
        while (arrayList.size() < 35) {
            if (arrayList.size() == 0) {
                this.startDate = calendar2.getTime();
            } else if (arrayList.size() == 34) {
                this.endDate = calendar2.getTime();
            }
            arrayList.add(calendar2.getTime());
            calendar2.add(5, 1);
        }
        return arrayList;
    }

    private class CalendarAdapter extends ArrayAdapter<Date> {
        private Calendar currentCalendar;
        private LayoutInflater inflater;
        private Calendar itemCalendar;
        private Resources res;
        private int todayDay;
        private int todayMonth;
        private int todayYear;

        public CalendarAdapter(Context context, Calendar calendar, ArrayList<Date> arrayList) {
            super(context, R.layout.item_calendar_month, arrayList);
            this.itemCalendar = Calendar.getInstance();
            this.res = CalendarMonthView.this.getResources();
            this.inflater = LayoutInflater.from(context);
            Calendar calendar2 = Calendar.getInstance();
            this.todayYear = calendar2.get(1);
            this.todayMonth = calendar2.get(2) + 1;
            this.todayDay = calendar2.get(5);
            this.currentCalendar = calendar == null ? (Calendar) calendar2.clone() : calendar;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            ViewHolder viewHolder;
            this.itemCalendar.setTime(getItem(i));
            int i2 = this.itemCalendar.get(1);
            int i3 = this.itemCalendar.get(2) + 1;
            int i4 = this.itemCalendar.get(5);
            int i5 = this.currentCalendar.get(2) + 1;
            if (view == null) {
                viewHolder = new ViewHolder();
                viewInflate = View.inflate(CalendarMonthView.this.context, R.layout.item_calendar_month, null);
                viewHolder.bg_layout = viewInflate.findViewById(R.id.bg_layout);
                viewHolder.item_image = (ImageView) viewInflate.findViewById(R.id.bg_image);
                viewHolder.bottom_image = (ImageView) viewInflate.findViewById(R.id.bottom_image);
                viewHolder.item_text = (TextView) viewInflate.findViewById(R.id.day_text);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewHolder.bg_layout.getLayoutParams();
                layoutParams.height = CalendarMonthView.this.gridHeight;
                viewHolder.bg_layout.setLayoutParams(layoutParams);
                viewHolder.item_text.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.calendar_month_item_text_size), 1.0f));
                viewInflate.setTag(viewHolder);
            } else {
                viewInflate = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            int i6 = Global.BRAND;
            if (i6 != 0) {
                if (i6 == 1 || i6 == 2 || i6 == 3) {
                    if (i2 == this.todayYear && i3 == this.todayMonth && i4 == this.todayDay) {
                        viewHolder.item_text.setTextColor(this.res.getColor(R.color.white));
                        viewHolder.item_image.setVisibility(0);
                    } else if (i3 == i5) {
                        viewHolder.item_text.setTextColor(this.res.getColor(R.color.black));
                    } else {
                        viewHolder.item_text.setTextColor(this.res.getColor(R.color.light_gray1));
                    }
                    if (Global.BRAND == 1) {
                        viewHolder.item_image.setImageResource(R.drawable.s_calendar_mark_1);
                    } else {
                        viewHolder.item_image.setImageResource(R.drawable.x_calendar_mark_1);
                    }
                }
            } else if (i2 == this.todayYear && i3 == this.todayMonth && i4 == this.todayDay) {
                viewHolder.item_text.setTextColor(this.res.getColor(R.color.black));
                viewHolder.item_text.setBackgroundColor(this.res.getColor(R.color.display_number_blue));
            } else if (i3 == i5) {
                viewHolder.item_text.setTextColor(this.res.getColor(R.color.light_gray));
            } else {
                viewHolder.item_text.setTextColor(this.res.getColor(R.color.dark_gray));
            }
            viewHolder.item_text.setText(String.valueOf(i4));
            int i7 = 0;
            while (true) {
                if (i7 >= CalendarMonthView.this.markArray.size()) {
                    break;
                }
                MarkData markData = (MarkData) CalendarMonthView.this.markArray.get(i7);
                int year = markData.getYear();
                int month = markData.getMonth();
                int day = markData.getDay();
                if (year == i2 && month == i3 && day == i4 && i4 != this.todayDay) {
                    viewHolder.bottom_image.setVisibility(0);
                    break;
                }
                i7++;
            }
            return viewInflate;
        }

        private class ViewHolder {
            View bg_layout;
            ImageView bottom_image;
            ImageView item_image;
            TextView item_text;

            private ViewHolder() {
            }
        }
    }

    private class MarkData {
        private int day;
        private int month;
        private int year;

        public MarkData(int i, int i2, int i3) {
            this.year = i;
            this.month = i2;
            this.day = i3;
        }

        public int getYear() {
            return this.year;
        }

        public int getMonth() {
            return this.month;
        }

        public int getDay() {
            return this.day;
        }
    }
}
