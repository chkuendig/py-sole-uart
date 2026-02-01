package com.dyaco.sole.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.DCTrainingDetailData;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.digifly.dbapi.greeddao_gen.DCTrainingDetailDataDao;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.database.WorkoutData;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.security.CertificateUtil;
import com.soletreadmills.sole.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.greendao.query.WhereCondition;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/* loaded from: classes.dex */
public class CalendarListAdapter extends BaseAdapter {
    private Context context;
    private String firstRecording = "";
    private int grayBgColor;
    private int grayBgColor2;
    private OnClickListener listener;
    private Resources res;
    private String trackCalories;
    private String trackDistance;
    private String trackDuration;
    private String trackHeartRate;
    private String trackProgram;
    private String trackSpeed;
    private String trackStartDate;
    private ArrayList<WorkoutData> workoutDatas;

    public interface OnClickListener {
        void onClick(View view, int i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public CalendarListAdapter(Context context) {
        this.context = context;
        Resources resources = context.getResources();
        this.res = resources;
        this.grayBgColor = resources.getColor(R.color.transparent_gray);
        this.grayBgColor2 = this.res.getColor(R.color.transparent_gray);
    }

    public void setData(ArrayList<WorkoutData> arrayList) {
        this.workoutDatas = arrayList;
        notifyDataSetChanged();
    }

    public String getFirstRecording() {
        WorkoutData item = getItem(0);
        if (item != null) {
            SharedPreferences sharedPreferences = Global.getSharedPreferences(this.context);
            if (ProtocolHandler.protocol == null) {
                ProtocolHandler.init(this.context);
            }
            int i = sharedPreferences.getInt(item.getStartDate(), ProtocolHandler.protocol.deviceUnit);
            String scaleToString = Global.getScaleToString(item.getDistance(), 1);
            StringBuilder sb = new StringBuilder();
            sb.append(scaleToString);
            sb.append(StringUtils.SPACE);
            sb.append(this.res.getString(i == 0 ? R.string.unit_km : R.string.unit_mi));
            String string = sb.toString();
            int duration = item.getDuration();
            int i2 = duration / 60;
            this.firstRecording = string + HelpFormatter.DEFAULT_OPT_PREFIX + Global.getFillString(i2 / 60, 2, AppEventsConstants.EVENT_PARAM_VALUE_NO) + CertificateUtil.DELIMITER + Global.getFillString(i2 % 60, 2, AppEventsConstants.EVENT_PARAM_VALUE_NO) + CertificateUtil.DELIMITER + Global.getFillString(duration % 60, 2, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            try {
                this.trackProgram = this.context.getResources().getString(item.getProgramNameRes());
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.trackCalories = String.valueOf(item.getCalories());
            this.trackStartDate = item.getStartDate();
            this.trackDuration = String.valueOf(duration);
            this.trackDistance = scaleToString;
            this.trackSpeed = String.valueOf(item.getAvgSpeed());
            this.trackHeartRate = String.valueOf(item.getAvgHR());
        } else {
            this.firstRecording = "";
            this.trackCalories = null;
            this.trackStartDate = null;
            this.trackDuration = null;
            this.trackDistance = null;
            this.trackSpeed = null;
            this.trackHeartRate = null;
        }
        return this.firstRecording;
    }

    public String getTrackProgram() {
        return this.trackProgram;
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

    public CalendarUtils getCurrentClickCalendar(int i) throws NumberFormatException {
        ArrayList<WorkoutData> arrayList = this.workoutDatas;
        if (arrayList == null || i >= arrayList.size()) {
            return null;
        }
        WorkoutData workoutData = this.workoutDatas.get(i);
        Calendar startCalendar = workoutData.getStartCalendar(workoutData.getStartDate());
        CalendarUtils calendarUtils = new CalendarUtils();
        calendarUtils.setCalendarType(false, 0);
        calendarUtils.setCalendar(startCalendar);
        return calendarUtils;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<WorkoutData> arrayList = this.workoutDatas;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public WorkoutData getItem(int i) {
        ArrayList<WorkoutData> arrayList = this.workoutDatas;
        if (arrayList == null || i >= arrayList.size()) {
            return null;
        }
        return this.workoutDatas.get(i);
    }

    public WorkoutData removeItem(int i) {
        ArrayList<WorkoutData> arrayList = this.workoutDatas;
        if (arrayList == null || i >= arrayList.size()) {
            return null;
        }
        WorkoutData workoutDataRemove = this.workoutDatas.remove(i);
        notifyDataSetChanged();
        return workoutDataRemove;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        ViewHolder viewHolder;
        View viewInflate;
        String string;
        List<DCTrainingData> list;
        List<DCTrainingDetailData> list2;
        int i2;
        List<DCTrainingData> list3;
        if (view == null) {
            int i3 = Global.BRAND;
            if (i3 == 0) {
                viewInflate = View.inflate(this.context, R.layout.item_calendar_list, null);
            } else {
                viewInflate = (i3 == 1 || i3 == 2 || i3 == 3) ? View.inflate(this.context, R.layout.s_item_calendar_list, null) : view;
            }
            viewHolder = new ViewHolder();
            viewHolder.item_calendar_list_layout = (LinearLayout) viewInflate.findViewById(R.id.item_calendar_list_layout);
            viewHolder.item_date_textview = (TextView) viewInflate.findViewById(R.id.item_date_textview);
            viewHolder.item_program_textview = (TextView) viewInflate.findViewById(R.id.item_program_textview);
            viewHolder.item_duration_textview = (TextView) viewInflate.findViewById(R.id.item_duration_textview);
            viewHolder.item_time_textview = (TextView) viewInflate.findViewById(R.id.item_time_textview);
            viewHolder.item_chart_textview = (ImageView) viewInflate.findViewById(R.id.item_chart_textview);
            viewHolder.item_date_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.calendar_list_title_text_size), 0.8f));
            viewHolder.item_program_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.calendar_list_title_text_size), 0.8f));
            viewHolder.item_duration_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.calendar_list_title_text_size), 0.8f));
            viewHolder.item_time_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.calendar_list_title_text_size), 0.8f));
            viewInflate.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
            viewInflate = view;
        }
        if (i % 2 == 0) {
            viewHolder.item_calendar_list_layout.setBackgroundColor(this.grayBgColor);
        } else {
            viewHolder.item_calendar_list_layout.setBackgroundColor(0);
        }
        int i4 = Global.BRAND;
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.adapter.CalendarListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CalendarListAdapter.this.listener.onClick(view2, i);
            }
        });
        viewHolder.item_chart_textview.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.adapter.CalendarListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CalendarListAdapter.this.listener.onClick(view2, i);
            }
        });
        viewHolder.item_date_textview.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.adapter.CalendarListAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CalendarListAdapter.this.listener.onClick(view2, i);
            }
        });
        WorkoutData workoutData = this.workoutDatas.get(i);
        String startDate = workoutData.getStartDate();
        String endDate = workoutData.getEndDate();
        String strValueOf = String.valueOf(workoutData.getDuration() / 60);
        viewHolder.item_date_textview.setText(workoutData.getStartDateFormat(startDate));
        try {
            string = this.context.getResources().getString(workoutData.getProgramNameRes());
        } catch (Exception e) {
            e.printStackTrace();
            string = "";
        }
        String name = string;
        try {
            DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
            DCTrainingData dCTrainingDataLoad = dCTrainingDataDao.load(workoutData.getTrainingDataId());
            if (dCTrainingDataLoad.getIn_out().equals(ExifInterface.GPS_MEASUREMENT_2D) || (dCTrainingDataLoad.getBrand_code() != null && dCTrainingDataLoad.getBrand_code().contains("garmin"))) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CalendarUtils.SQL_DATE_FORMAT, Locale.getDefault());
                Date training_datetime = dCTrainingDataLoad.getTraining_datetime();
                list3 = dCTrainingDataDao.queryBuilder().where(DCTrainingDataDao.Properties.Brand_code.eq("garmin"), new WhereCondition[0]).where(DCTrainingDataDao.Properties.Account.eq(Global.calendarUserName), new WhereCondition[0]).where(DCTrainingDataDao.Properties.Training_datetime.between(DateTime.parse(simpleDateFormat.format(training_datetime), DateTimeFormat.forPattern(CalendarUtils.SQL_DATE_FORMAT)).toDate(), DateTime.parse(simpleDateFormat.format(training_datetime) + " 23:59:59", DateTimeFormat.forPattern(CalendarUtils.SQL_DATE_TIME_FORMAT)).toDate()), new WhereCondition[0]).orderAsc(DCTrainingDataDao.Properties.Training_datetime).list();
            } else {
                list3 = null;
            }
            list = list3;
        } catch (Exception e2) {
            e2.printStackTrace();
            list = null;
        }
        if (workoutData == null || workoutData.getTrainingDataId() == null) {
            list2 = null;
        } else {
            try {
                list2 = DbManager.getDCTrainingDetailDataDao().queryBuilder().where(DCTrainingDetailDataDao.Properties.TrainingId.eq(workoutData.getTrainingDataId()), new WhereCondition[0]).list();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        viewHolder.item_chart_textview.setVisibility(4);
        if (list == null || list.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 0;
            viewHolder.item_chart_textview.setVisibility(0);
        }
        if (list2 != null && !list2.isEmpty()) {
            viewHolder.item_chart_textview.setVisibility(i2);
        }
        if (name == null || name.length() == 0) {
            Log.d("TOM", "getIn_out:" + workoutData.getIn_out());
            Log.d("TOM", "getName:" + workoutData.getName());
            Log.d("TOM", "getStartDate:" + workoutData.getStartDate());
            Log.d("TOM", "getStartDate:" + workoutData.getEndDate());
            Log.d("TOM", "getDeviceModelName:" + workoutData.getDeviceModelName());
            Log.d("TOM", "getAvgSpeed:" + workoutData.getAvgSpeed());
            Log.d("TOM", "getCalories:" + workoutData.getCalories());
            Log.d("TOM", "getDistance:" + workoutData.getDistance());
            Log.d("TOM", "getIn_out:" + workoutData.getIn_out());
            Log.d("TOM", "getDuration:" + workoutData.getDuration());
            if (workoutData.getIn_out() == null || workoutData.getIn_out().equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                name = workoutData.getName();
            } else {
                name = workoutData.getName();
            }
        }
        viewHolder.item_program_textview.setText(name);
        viewHolder.item_duration_textview.setText(strValueOf + StringUtils.SPACE + this.res.getString(R.string.min));
        viewHolder.item_time_textview.setText(workoutData.getStartTimeFormat(startDate) + " - " + workoutData.getEndTimeFormat(endDate));
        int currentTextColor = viewHolder.item_date_textview.getCurrentTextColor();
        if (workoutData.getIn_out().equals(ExifInterface.GPS_MEASUREMENT_2D)) {
            int i5 = Global.BRAND;
            if (i5 == 0) {
                currentTextColor = Color.rgb(0, 255, 255);
            } else if (i5 == 1 || i5 == 2 || i5 == 3) {
                currentTextColor = Color.rgb(0, 127, 255);
            }
        } else {
            int i6 = Global.BRAND;
            if (i6 == 0) {
                currentTextColor = this.context.getResources().getColor(R.color.light_gray);
            } else if (i6 == 1 || i6 == 2 || i6 == 3) {
                currentTextColor = this.context.getResources().getColor(R.color.black);
            }
        }
        viewHolder.item_date_textview.setTextColor(currentTextColor);
        viewHolder.item_program_textview.setTextColor(currentTextColor);
        viewHolder.item_duration_textview.setTextColor(currentTextColor);
        viewHolder.item_time_textview.setTextColor(currentTextColor);
        if (!workoutData.getIn_out().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            int i7 = Global.BRAND;
            if (i7 == 0) {
                this.context.getResources().getColor(R.color.light_gray);
            } else if (i7 == 1 || i7 == 2 || i7 == 3) {
                this.context.getResources().getColor(R.color.white);
            }
        }
        return viewInflate;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.listener = onClickListener;
    }

    class ViewHolder {
        LinearLayout item_calendar_list_layout;
        ImageView item_chart_textview;
        TextView item_date_textview;
        TextView item_duration_textview;
        TextView item_program_textview;
        TextView item_time_textview;

        ViewHolder() {
        }
    }
}
