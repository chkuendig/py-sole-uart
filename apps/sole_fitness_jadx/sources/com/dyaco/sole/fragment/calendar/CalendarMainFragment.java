package com.dyaco.sole.fragment.calendar;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.digifly.cloudapi.JsonUtil;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.DCTrainingDetailData;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.digifly.dbapi.greeddao_gen.DCTrainingDetailDataDao;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.adapter.CalendarListAdapter;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom_view.TypefaceTextView;
import com.dyaco.sole.database.WorkoutData;
import com.dyaco.sole.fragment.BaseFragment;
import com.dyaco.sole.fragment.calendar.CalendarDayView;
import com.dyaco.sole.fragment.calendar.CalendarWeekView;
import com.dyaco.sole.listener.GetTrainingDataFinishListener;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;

/* loaded from: classes.dex */
public class CalendarMainFragment extends BaseFragment implements OnMapReadyCallback, View.OnClickListener {
    public static final int CALENDAR_CHART = 104;
    public static final int CALENDAR_DAY = 97;
    public static final int CALENDAR_DETAILS = 102;
    public static final int CALENDAR_DETAILS_OUTDOOR = 103;
    public static final int CALENDAR_LIST = 100;
    public static final int CALENDAR_MONTH = 99;
    private static final String CALENDAR_SELECTED_VIEW = "calendar_selected_view";
    public static final int CALENDAR_TOTALS = 101;
    public static final int CALENDAR_WEEK = 98;
    public static final String TAG = "SOLE-CalendarMainFragment";
    private MainActivity activity;
    private CalendarListAdapter calendarListAdapter;
    private TypefaceTextView calendar_bottom_day_textview;
    private TypefaceTextView calendar_bottom_list_textview;
    private TypefaceTextView calendar_bottom_month_textview;
    private TypefaceTextView calendar_bottom_totals_textview;
    private TypefaceTextView calendar_bottom_week_textview;
    private CalendarDayView calendar_day_view;
    private TypefaceTextView calendar_details_avg_hr_textview;
    private TypefaceTextView calendar_details_avg_hr_textview2_in;
    private TypefaceTextView calendar_details_avg_level_textview;
    private TypefaceTextView calendar_details_avg_level_textview2_in;
    private TypefaceTextView calendar_details_avg_mets_textview;
    private TypefaceTextView calendar_details_avg_mets_textview2_in;
    private TypefaceTextView calendar_details_avg_rpm_textview;
    private TypefaceTextView calendar_details_avg_rpm_textview2_in;
    private TypefaceTextView calendar_details_avg_speed_textview;
    private TypefaceTextView calendar_details_avg_speed_textview2_in;
    private TypefaceTextView calendar_details_avg_watts_textview;
    private TypefaceTextView calendar_details_avg_watts_textview2_in;
    private TypefaceTextView calendar_details_calories_textview;
    private TypefaceTextView calendar_details_calories_textview2;
    private TypefaceTextView calendar_details_calories_textview2_in;
    private View calendar_details_content_wrapper_in;
    private View calendar_details_content_wrapper_out;
    private TypefaceTextView calendar_details_distance_textview;
    private TypefaceTextView calendar_details_distance_textview2;
    private TypefaceTextView calendar_details_distance_textview2_in;
    private TypefaceTextView calendar_details_goals_textview;
    private TypefaceTextView calendar_details_goals_textview2_in;
    private TypefaceTextView calendar_details_notes_textview;
    private TypefaceTextView calendar_details_notes_textview2_in;
    private TypefaceTextView calendar_details_pace_textview2;
    private TypefaceTextView calendar_details_raw_datas;
    private TypefaceTextView calendar_details_speed_textview2;
    private TypefaceTextView calendar_details_sport_type_title_textview2;
    private TypefaceTextView calendar_details_time_textview;
    private TypefaceTextView calendar_details_time_textview2;
    private TypefaceTextView calendar_details_time_textview2_in;
    private ListView calendar_list_listview;
    private CalendarMonthView calendar_month_view;
    private TypefaceTextView calendar_second_title_textview;
    private TypefaceTextView calendar_second_title_textview2;
    private CalendarWeekTitleView calendar_week_title_view;
    private CalendarWeekView calendar_week_view;
    private CalendarUtils chartCalendarUtils;
    private WorkoutChart chartView;
    private FrameLayout content_layout;
    private CalendarUtils dayCalendarUtils;
    private TypefaceTextView day_calendar_title_textview;
    private CalendarUtils detailsCalendarUtils;
    private CalendarUtils detailsCalendarUtils2;
    private TypefaceTextView details_calendar_title_textview;
    private TypefaceTextView details_calendar_title_textview2;
    private View include_calendar_chart;
    private View include_calendar_day;
    private View include_calendar_details;
    private View include_calendar_details_outdoor;
    private View include_calendar_list;
    private View include_calendar_month;
    private View include_calendar_totals;
    private View include_calendar_week;
    private View include_title_bar;
    private View include_title_bar2;
    private int lastSelectedView;
    private GoogleMap mMap;
    private CalendarUtils monthCalendarUtils;
    private TypefaceTextView month_calendar_title_textview;
    private Resources res;
    private View rootView;
    private String shareCategory;
    private String shareModel;
    private String shareProgram;
    private WorkoutTotalChart totalChartView;
    private List<DCTrainingData> totalModeTrainingData;
    private String trackCalories;
    private String trackDistance;
    private String trackDuration;
    private String trackHeartRate;
    private String trackSpeed;
    private String trackStartDate;
    private List<DCTrainingData> trainingDatas;
    private CalendarUtils weekCalendarUtils;
    private TypefaceTextView week_calendar_title_textview;
    private String shareRecording = "";
    private int nowPage = 0;
    private boolean beFirstLocationChange = true;
    private String loc = "tw";
    private final GetTrainingDataFinishListener getTrainingDataFinishListener = new GetTrainingDataFinishListener() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.1
        @Override // com.dyaco.sole.listener.GetTrainingDataFinishListener
        public void onFinish() throws Resources.NotFoundException, NumberFormatException {
            if (CalendarMainFragment.this.isHidden()) {
                return;
            }
            CalendarMainFragment.this.updateDay();
            CalendarMainFragment.this.updateWeek();
            CalendarMainFragment.this.updateMonth();
            CalendarMainFragment.this.updateListData();
            CalendarMainFragment.this.updateTotalsData();
            CalendarMainFragment calendarMainFragment = CalendarMainFragment.this;
            calendarMainFragment.trainingDatas = calendarMainFragment.loadListData2();
            CalendarMainFragment.this.updateTotalsDataForOutdoor(null);
            CalendarMainFragment.this.initSelectedView();
        }
    };
    private View.OnClickListener onTitleBarClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException, NumberFormatException {
            CalendarMainFragment.this.setShareRecording();
            switch (view.getId()) {
                case R.id.calendar_next_textview /* 2131230962 */:
                    ErrorLogSave.addErrorString(CalendarMainFragment.this.getActivity(), ErrorLogSave.CLICK, "CalendarMainFragment_next", "onTitleBarClick_nowPage:" + CalendarMainFragment.this.nowPage);
                    int i = CalendarMainFragment.this.nowPage;
                    if (i == 0) {
                        CalendarMainFragment.this.day_calendar_title_textview.setText(CalendarMainFragment.this.dayCalendarUtils.changeCalendarFormat(1));
                        CalendarMainFragment.this.calendar_day_view.updateView(CalendarMainFragment.this.dayCalendarUtils.getNowDayCalendarForSQL());
                        break;
                    } else if (i == 1) {
                        CalendarMainFragment.this.week_calendar_title_textview.setText(CalendarMainFragment.this.weekCalendarUtils.changeCalendarFormat(1));
                        CalendarMainFragment.this.calendar_week_title_view.changeCalendar(CalendarMainFragment.this.weekCalendarUtils.getCalendar());
                        CalendarMainFragment.this.calendar_week_view.updateView(CalendarMainFragment.this.weekCalendarUtils.getNowWeekCalendarForSQL());
                        break;
                    } else if (i == 2) {
                        CalendarMainFragment.this.month_calendar_title_textview.setText(CalendarMainFragment.this.monthCalendarUtils.changeCalendarFormat(1));
                        CalendarMainFragment.this.calendar_month_view.updateView(CalendarMainFragment.this.monthCalendarUtils);
                        break;
                    } else if (i == 5) {
                        CalendarMainFragment.this.details_calendar_title_textview.setText(CalendarMainFragment.this.detailsCalendarUtils.changeCalendarFormat(1));
                        CalendarMainFragment.this.updateTotalsData();
                        break;
                    } else if (i == 6) {
                        CalendarMainFragment.this.details_calendar_title_textview2.setText(CalendarMainFragment.this.detailsCalendarUtils2.changeCalendarFormat(1));
                        CalendarMainFragment.this.updateTotalsDataForOutdoor(null);
                        break;
                    }
                    break;
                case R.id.calendar_prev_textview /* 2131230963 */:
                    ErrorLogSave.addErrorString(CalendarMainFragment.this.getActivity(), ErrorLogSave.CLICK, "CalendarMainFragment_prev", "onTitleBarClick_nowPage:" + CalendarMainFragment.this.nowPage);
                    int i2 = CalendarMainFragment.this.nowPage;
                    if (i2 == 0) {
                        CalendarMainFragment.this.day_calendar_title_textview.setText(CalendarMainFragment.this.dayCalendarUtils.changeCalendarFormat(-1));
                        CalendarMainFragment.this.calendar_day_view.updateView(CalendarMainFragment.this.dayCalendarUtils.getNowDayCalendarForSQL());
                        break;
                    } else if (i2 == 1) {
                        CalendarMainFragment.this.week_calendar_title_textview.setText(CalendarMainFragment.this.weekCalendarUtils.changeCalendarFormat(-1));
                        CalendarMainFragment.this.calendar_week_title_view.changeCalendar(CalendarMainFragment.this.weekCalendarUtils.getCalendar());
                        CalendarMainFragment.this.calendar_week_view.updateView(CalendarMainFragment.this.weekCalendarUtils.getNowWeekCalendarForSQL());
                        break;
                    } else if (i2 == 2) {
                        CalendarMainFragment.this.month_calendar_title_textview.setText(CalendarMainFragment.this.monthCalendarUtils.changeCalendarFormat(-1));
                        CalendarMainFragment.this.calendar_month_view.updateView(CalendarMainFragment.this.monthCalendarUtils);
                        break;
                    } else if (i2 == 5) {
                        CalendarMainFragment.this.details_calendar_title_textview.setText(CalendarMainFragment.this.detailsCalendarUtils.changeCalendarFormat(-1));
                        CalendarMainFragment.this.updateTotalsData();
                        break;
                    } else if (i2 == 6) {
                        CalendarMainFragment.this.details_calendar_title_textview2.setText(CalendarMainFragment.this.detailsCalendarUtils2.changeCalendarFormat(-1));
                        CalendarMainFragment.this.updateTotalsDataForOutdoor(null);
                        break;
                    }
                    break;
                case R.id.totalchart /* 2131231750 */:
                    ErrorLogSave.addErrorString(CalendarMainFragment.this.getActivity(), ErrorLogSave.CLICK, "CalendarMainFragment_totalchart", "onTitleBarClick_nowPage:" + CalendarMainFragment.this.nowPage);
                    Log.d("totalchart", "nowPage:" + CalendarMainFragment.this.nowPage);
                    int i3 = CalendarMainFragment.this.nowPage;
                    if (i3 == 0) {
                        Log.d("totalchart", "totalchart:DAY");
                        CalendarMainFragment.this.onClickTotalChart(0, 0);
                        break;
                    } else if (i3 == 1) {
                        Log.d("totalchart", "totalchart:WEEK");
                        CalendarMainFragment.this.onClickTotalChart(1, 0);
                        break;
                    } else if (i3 == 2) {
                        Log.d("totalchart", "totalchart:Month");
                        CalendarMainFragment.this.onClickTotalChart(2, 0);
                        break;
                    } else if (i3 == 5) {
                        CalendarMainFragment.this.onClickTotalChart(CalendarMainFragment.this.detailsCalendarUtils.getCalendarType(), 1);
                        break;
                    }
                    break;
            }
        }
    };
    private int curPos = 0;
    private View.OnClickListener onTitleBarClick2 = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException, NumberFormatException {
            if (CalendarMainFragment.this.trainingDatas == null) {
            }
            switch (view.getId()) {
                case R.id.calendar_next_textview /* 2131230962 */:
                    ErrorLogSave.addErrorString(CalendarMainFragment.this.getActivity(), ErrorLogSave.CLICK, "CalendarMainFragment_next", "onTitleBarClick2_nowPage:" + CalendarMainFragment.this.nowPage);
                    if (CalendarMainFragment.this.curPos + 1 < CalendarMainFragment.this.trainingDatas.size()) {
                        CalendarMainFragment.access$1608(CalendarMainFragment.this);
                        DCTrainingData dCTrainingData = (DCTrainingData) CalendarMainFragment.this.trainingDatas.get(CalendarMainFragment.this.curPos);
                        CalendarMainFragment.this.details_calendar_title_textview2.setText(new DateTime(dCTrainingData.getTraining_datetime()).toString("E. MM/dd/yyyy"));
                        CalendarMainFragment.this.updateTotalsDataForOutdoor(dCTrainingData);
                        break;
                    }
                    break;
                case R.id.calendar_prev_textview /* 2131230963 */:
                    ErrorLogSave.addErrorString(CalendarMainFragment.this.getActivity(), ErrorLogSave.CLICK, "CalendarMainFragment_pre", "onTitleBarClick2_nowPage:" + CalendarMainFragment.this.nowPage);
                    if (CalendarMainFragment.this.curPos - 1 >= 0) {
                        CalendarMainFragment.access$1610(CalendarMainFragment.this);
                        DCTrainingData dCTrainingData2 = (DCTrainingData) CalendarMainFragment.this.trainingDatas.get(CalendarMainFragment.this.curPos);
                        CalendarMainFragment.this.details_calendar_title_textview2.setText(new DateTime(dCTrainingData2.getTraining_datetime()).toString("E. MM/dd/yyyy"));
                        CalendarMainFragment.this.updateTotalsDataForOutdoor(dCTrainingData2);
                        break;
                    }
                    break;
                case R.id.totalchart /* 2131231750 */:
                    ErrorLogSave.addErrorString(CalendarMainFragment.this.getActivity(), ErrorLogSave.CLICK, "CalendarMainFragment_totalchart", "onTitleBarClick2_nowPage:" + CalendarMainFragment.this.nowPage);
                    DCTrainingData dCTrainingData3 = (DCTrainingData) CalendarMainFragment.this.trainingDatas.get(CalendarMainFragment.this.curPos);
                    CalendarMainFragment calendarMainFragment = CalendarMainFragment.this;
                    calendarMainFragment.onClickChart(calendarMainFragment.curPos, false, CalendarMainFragment.this.calendarListAdapter.getCurrentClickCalendar(CalendarMainFragment.this.curPos), dCTrainingData3);
                    break;
            }
        }
    };
    private View.OnClickListener onTotalsClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException, NumberFormatException {
            CalendarMainFragment.this.onClickTotals(view.getId(), true, CalendarMainFragment.this.detailsCalendarUtils);
        }
    };

    static /* synthetic */ int access$1608(CalendarMainFragment calendarMainFragment) {
        int i = calendarMainFragment.curPos;
        calendarMainFragment.curPos = i + 1;
        return i;
    }

    static /* synthetic */ int access$1610(CalendarMainFragment calendarMainFragment) {
        int i = calendarMainFragment.curPos;
        calendarMainFragment.curPos = i - 1;
        return i;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException, NumberFormatException {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.loc = Locale.getDefault().getCountry();
        this.activity = (MainActivity) getActivity();
        this.res = getResources();
        int i = Global.BRAND;
        if (i == 0) {
            this.rootView = layoutInflater.inflate(R.layout.fragment_calendar_main, viewGroup, false);
        } else if (i == 1) {
            this.rootView = layoutInflater.inflate(R.layout.s_fragment_calendar_main, viewGroup, false);
        } else if (i == 2 || i == 3) {
            this.rootView = layoutInflater.inflate(R.layout.x_fragment_calendar_main, viewGroup, false);
        }
        findViews();
        initParams();
        setListeners();
        return this.rootView;
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        MainActivity mainActivity = this.activity;
        if (mainActivity == null) {
            return;
        }
        if (!z) {
            int i = Global.BRAND;
            if (i == 1 || i == 2 || i == 3) {
                this.activity.hideBottomRedLine();
            }
            this.activity.setGetTrainingDataFinishListener(this.getTrainingDataFinishListener);
            this.activity.startDataSyncTimer();
            return;
        }
        mainActivity.setGetTrainingDataFinishListener(null);
        int i2 = Global.BRAND;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            this.activity.showBottomRedLine();
        }
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void findViews() {
        this.content_layout = (FrameLayout) this.rootView.findViewById(R.id.content_layout);
        this.calendar_bottom_day_textview = (TypefaceTextView) this.rootView.findViewById(R.id.calendar_bottom_day_textview);
        this.calendar_bottom_week_textview = (TypefaceTextView) this.rootView.findViewById(R.id.calendar_bottom_week_textview);
        this.calendar_bottom_month_textview = (TypefaceTextView) this.rootView.findViewById(R.id.calendar_bottom_month_textview);
        this.calendar_bottom_list_textview = (TypefaceTextView) this.rootView.findViewById(R.id.calendar_bottom_list_textview);
        this.calendar_bottom_totals_textview = (TypefaceTextView) this.rootView.findViewById(R.id.calendar_bottom_totals_textview);
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void initParams() throws Resources.NotFoundException, NumberFormatException {
        int i = Global.BRAND;
        if (i == 1 || i == 2 || i == 3) {
            this.calendar_bottom_day_textview.setText(getString(R.string.day).toUpperCase());
            this.calendar_bottom_week_textview.setText(getString(R.string.week).toUpperCase());
            this.calendar_bottom_month_textview.setText(getString(R.string.month).toUpperCase());
            this.calendar_bottom_list_textview.setText(getString(R.string.list).toUpperCase());
            this.calendar_bottom_totals_textview.setText(getString(R.string.totals).toUpperCase());
            if (Global.BRAND == 1) {
                this.calendar_bottom_day_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
                this.calendar_bottom_week_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
                this.calendar_bottom_month_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
                this.calendar_bottom_list_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
            } else {
                this.calendar_bottom_day_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
                this.calendar_bottom_week_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
                this.calendar_bottom_month_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
                this.calendar_bottom_list_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
            }
        }
        this.trainingDatas = loadListData2();
        initDayView();
        initWeekView();
        initMonthView();
        initListView();
        initTotalsView();
        initDetailsView();
        initDetailsForOutdoorView();
        initChartView();
        initSelectedView();
    }

    private void initDayView() {
        int i = Global.BRAND;
        if (i == 0) {
            this.include_calendar_day = View.inflate(this.activity, R.layout.include_calendar_day, null);
        } else if (i == 1 || i == 2 || i == 3) {
            this.include_calendar_day = View.inflate(this.activity, R.layout.s_include_calendar_day, null);
        }
        this.content_layout.addView(this.include_calendar_day);
        View viewFindViewById = this.include_calendar_day.findViewById(R.id.include_title_bar);
        setTitleBarListener(viewFindViewById);
        TypefaceTextView typefaceTextView = (TypefaceTextView) viewFindViewById.findViewById(R.id.calendar_title_textview);
        this.day_calendar_title_textview = typefaceTextView;
        typefaceTextView.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.calendar_list_content_text_size), 0.8f));
        int i2 = Global.BRAND;
        CalendarUtils calendarUtils = new CalendarUtils();
        this.dayCalendarUtils = calendarUtils;
        calendarUtils.setCalendarType(false, 0);
        this.day_calendar_title_textview.setText(this.dayCalendarUtils.getNowCalendar());
        CalendarDayView calendarDayView = (CalendarDayView) this.include_calendar_day.findViewById(R.id.calendar_day_view);
        this.calendar_day_view = calendarDayView;
        calendarDayView.updateView(this.dayCalendarUtils.getNowDayCalendarForSQL());
        this.calendar_day_view.setOnClickTrackViewListener(new CalendarDayView.OnClickTrackViewListener() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.2
            @Override // com.dyaco.sole.fragment.calendar.CalendarDayView.OnClickTrackViewListener
            public void onClickView() throws Resources.NotFoundException, NumberFormatException {
                ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_day_onItemClick", ErrorLogSave.CLICK);
                CalendarMainFragment calendarMainFragment = CalendarMainFragment.this;
                calendarMainFragment.onClickTotals(R.id.calendar_totals_day_textview, false, calendarMainFragment.dayCalendarUtils);
            }
        });
    }

    private void initWeekView() throws Resources.NotFoundException, NumberFormatException {
        int i = Global.BRAND;
        if (i == 0) {
            this.include_calendar_week = View.inflate(this.activity, R.layout.include_calendar_week, null);
        } else if (i == 1 || i == 2 || i == 3) {
            this.include_calendar_week = View.inflate(this.activity, R.layout.s_include_calendar_week, null);
        }
        this.content_layout.addView(this.include_calendar_week);
        View viewFindViewById = this.include_calendar_week.findViewById(R.id.include_title_bar);
        setTitleBarListener(viewFindViewById);
        TypefaceTextView typefaceTextView = (TypefaceTextView) viewFindViewById.findViewById(R.id.calendar_title_textview);
        this.week_calendar_title_textview = typefaceTextView;
        typefaceTextView.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.calendar_list_content_text_size), 0.8f));
        int i2 = Global.BRAND;
        CalendarUtils calendarUtils = new CalendarUtils();
        this.weekCalendarUtils = calendarUtils;
        calendarUtils.setCalendarType(false, 1);
        this.week_calendar_title_textview.setText(this.weekCalendarUtils.getNowCalendar());
        CalendarWeekTitleView calendarWeekTitleView = (CalendarWeekTitleView) this.include_calendar_week.findViewById(R.id.calendar_week_title_view);
        this.calendar_week_title_view = calendarWeekTitleView;
        calendarWeekTitleView.changeCalendar(this.weekCalendarUtils.getCalendar());
        CalendarWeekView calendarWeekView = (CalendarWeekView) this.include_calendar_week.findViewById(R.id.calendar_week_view);
        this.calendar_week_view = calendarWeekView;
        calendarWeekView.updateView(this.weekCalendarUtils.getNowWeekCalendarForSQL());
        this.calendar_week_view.setOnClickTrackViewListener(new CalendarWeekView.OnClickTrackViewListener() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.3
            @Override // com.dyaco.sole.fragment.calendar.CalendarWeekView.OnClickTrackViewListener
            public void onClickView() throws Resources.NotFoundException, NumberFormatException {
                ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_week_onItemClick", ErrorLogSave.CLICK);
                CalendarMainFragment calendarMainFragment = CalendarMainFragment.this;
                calendarMainFragment.onClickTotals(R.id.calendar_totals_week_textview, false, calendarMainFragment.weekCalendarUtils);
            }
        });
    }

    private void initMonthView() {
        int i = Global.BRAND;
        if (i == 0) {
            this.include_calendar_month = View.inflate(this.activity, R.layout.include_calendar_month, null);
        } else if (i == 1 || i == 2 || i == 3) {
            this.include_calendar_month = View.inflate(this.activity, R.layout.s_include_calendar_month, null);
        }
        this.content_layout.addView(this.include_calendar_month);
        View viewFindViewById = this.include_calendar_month.findViewById(R.id.include_title_bar);
        setTitleBarListener(viewFindViewById);
        TypefaceTextView typefaceTextView = (TypefaceTextView) viewFindViewById.findViewById(R.id.calendar_title_textview);
        this.month_calendar_title_textview = typefaceTextView;
        typefaceTextView.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.calendar_list_content_text_size), 0.8f));
        int i2 = Global.BRAND;
        TypefaceTextView typefaceTextView2 = (TypefaceTextView) this.include_calendar_month.findViewById(R.id.calendar_header1_textview);
        TypefaceTextView typefaceTextView3 = (TypefaceTextView) this.include_calendar_month.findViewById(R.id.calendar_header2_textview);
        TypefaceTextView typefaceTextView4 = (TypefaceTextView) this.include_calendar_month.findViewById(R.id.calendar_header3_textview);
        TypefaceTextView typefaceTextView5 = (TypefaceTextView) this.include_calendar_month.findViewById(R.id.calendar_header4_textview);
        TypefaceTextView typefaceTextView6 = (TypefaceTextView) this.include_calendar_month.findViewById(R.id.calendar_header5_textview);
        TypefaceTextView typefaceTextView7 = (TypefaceTextView) this.include_calendar_month.findViewById(R.id.calendar_header6_textview);
        TypefaceTextView typefaceTextView8 = (TypefaceTextView) this.include_calendar_month.findViewById(R.id.calendar_header7_textview);
        float longScreenHeight = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.calendar_list_title_text_size), 0.8f);
        typefaceTextView2.setTextSize(0, longScreenHeight);
        typefaceTextView3.setTextSize(0, longScreenHeight);
        typefaceTextView4.setTextSize(0, longScreenHeight);
        typefaceTextView5.setTextSize(0, longScreenHeight);
        typefaceTextView6.setTextSize(0, longScreenHeight);
        typefaceTextView7.setTextSize(0, longScreenHeight);
        typefaceTextView8.setTextSize(0, longScreenHeight);
        CalendarUtils calendarUtils = new CalendarUtils();
        this.monthCalendarUtils = calendarUtils;
        calendarUtils.setCalendarType(false, 2);
        this.month_calendar_title_textview.setText(this.monthCalendarUtils.getNowCalendar());
        CalendarMonthView calendarMonthView = (CalendarMonthView) this.include_calendar_month.findViewById(R.id.calendar_month_view);
        this.calendar_month_view = calendarMonthView;
        calendarMonthView.updateView(this.monthCalendarUtils);
        this.calendar_month_view.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) throws Resources.NotFoundException, NumberFormatException {
                ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_month_onItemClick", ErrorLogSave.CLICK);
                CalendarMainFragment calendarMainFragment = CalendarMainFragment.this;
                calendarMainFragment.onClickTotals(R.id.calendar_totals_month_textview, false, calendarMainFragment.monthCalendarUtils);
            }
        });
    }

    private void initListView() {
        int i = Global.BRAND;
        if (i == 0) {
            this.include_calendar_list = View.inflate(this.activity, R.layout.include_calendar_list, null);
        } else if (i == 1 || i == 2 || i == 3) {
            this.include_calendar_list = View.inflate(this.activity, R.layout.s_include_calendar_list, null);
        }
        this.content_layout.addView(this.include_calendar_list);
        View viewFindViewById = this.include_calendar_list.findViewById(R.id.calendar_list_title_include);
        TypefaceTextView typefaceTextView = (TypefaceTextView) viewFindViewById.findViewById(R.id.item_date_textview);
        TypefaceTextView typefaceTextView2 = (TypefaceTextView) viewFindViewById.findViewById(R.id.item_program_textview);
        TypefaceTextView typefaceTextView3 = (TypefaceTextView) viewFindViewById.findViewById(R.id.item_duration_textview);
        TypefaceTextView typefaceTextView4 = (TypefaceTextView) viewFindViewById.findViewById(R.id.item_time_textview);
        typefaceTextView.setTextSize(0, this.res.getDimension(R.dimen.calendar_list_title_text_size));
        typefaceTextView2.setTextSize(0, this.res.getDimension(R.dimen.calendar_list_title_text_size));
        typefaceTextView3.setTextSize(0, this.res.getDimension(R.dimen.calendar_list_title_text_size));
        typefaceTextView4.setTextSize(0, this.res.getDimension(R.dimen.calendar_list_title_text_size));
        typefaceTextView4.setText(this.res.getString(R.string.time).toUpperCase());
        ArrayList<WorkoutData> arrayListSaveAsWorkoutData = saveAsWorkoutData(loadListData2());
        this.calendar_list_listview = (ListView) this.include_calendar_list.findViewById(R.id.calendar_list_listview);
        CalendarListAdapter calendarListAdapter = new CalendarListAdapter(this.activity);
        this.calendarListAdapter = calendarListAdapter;
        calendarListAdapter.setData(arrayListSaveAsWorkoutData);
        this.calendar_list_listview.setAdapter((ListAdapter) this.calendarListAdapter);
        this.calendarListAdapter.setOnClickListener(new CalendarListAdapter.OnClickListener() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.5
            @Override // com.dyaco.sole.adapter.CalendarListAdapter.OnClickListener
            public void onClick(View view, int i2) throws Resources.NotFoundException, NumberFormatException {
                String str = ((("selectItem_name:" + CalendarMainFragment.this.calendarListAdapter.getItem(i2).getName()) + "_startDay:" + CalendarMainFragment.this.calendarListAdapter.getItem(i2).getStartDate()) + "_endDay:" + CalendarMainFragment.this.calendarListAdapter.getItem(i2).getEndDate()) + "_deviceMode:" + CalendarMainFragment.this.calendarListAdapter.getItem(i2).getDeviceModelName();
                String string = "Manual";
                try {
                    if (CalendarMainFragment.this.calendarListAdapter.getItem(i2).getProgramNameRes() != 0) {
                        string = CalendarMainFragment.this.getResources().getString(CalendarMainFragment.this.calendarListAdapter.getItem(i2).getProgramNameRes());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_List_ItemClick", str + "_deviceProgram:" + string);
                DCTrainingData dCTrainingDataLoadTrainingDataBy = CalendarMainFragment.this.loadTrainingDataBy(CalendarMainFragment.this.calendarListAdapter.getItem(i2).getTrainingDataId());
                if (view.getId() == R.id.item_chart_textview) {
                    CalendarMainFragment.this.onClickChart(view.getId(), false, CalendarMainFragment.this.calendarListAdapter.getCurrentClickCalendar(i2), dCTrainingDataLoadTrainingDataBy);
                    return;
                }
                if (view.getId() == R.id.item_date_textview) {
                    Log.d("TOM", "item_date_textview");
                    CalendarMainFragment.this.curPos = i2;
                    CalendarMainFragment.this.onClickTotalsForOutdoor(dCTrainingDataLoadTrainingDataBy);
                } else {
                    Log.d("TOM", "item_other");
                    CalendarMainFragment.this.curPos = i2;
                    CalendarMainFragment.this.onClickTotalsForOutdoor(dCTrainingDataLoadTrainingDataBy);
                }
            }
        });
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.include_calendar_list.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.6
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                swipeRefreshLayout.postDelayed(new Runnable() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000L);
                CalendarMainFragment.this.activity.startDataSyncTimer();
            }
        });
    }

    private void initTotalsView() {
        View viewInflate = View.inflate(this.activity, R.layout.include_calendar_totals, null);
        this.include_calendar_totals = viewInflate;
        this.content_layout.addView(viewInflate);
        TypefaceTextView typefaceTextView = (TypefaceTextView) this.include_calendar_totals.findViewById(R.id.calendar_totals_day_textview);
        TypefaceTextView typefaceTextView2 = (TypefaceTextView) this.include_calendar_totals.findViewById(R.id.calendar_totals_week_textview);
        TypefaceTextView typefaceTextView3 = (TypefaceTextView) this.include_calendar_totals.findViewById(R.id.calendar_totals_month_textview);
        TypefaceTextView typefaceTextView4 = (TypefaceTextView) this.include_calendar_totals.findViewById(R.id.calendar_totals_year_textview);
        TypefaceTextView typefaceTextView5 = (TypefaceTextView) this.include_calendar_totals.findViewById(R.id.calendar_totals_total_textview);
        typefaceTextView.setOnClickListener(this.onTotalsClick);
        typefaceTextView2.setOnClickListener(this.onTotalsClick);
        typefaceTextView3.setOnClickListener(this.onTotalsClick);
        typefaceTextView4.setOnClickListener(this.onTotalsClick);
        typefaceTextView5.setOnClickListener(this.onTotalsClick);
        int i = Global.BRAND;
    }

    private void initDetailsView() throws Resources.NotFoundException {
        int i = Global.BRAND;
        if (i == 0) {
            this.include_calendar_details = View.inflate(this.activity, R.layout.include_calendar_details, null);
        } else if (i == 1 || i == 2 || i == 3) {
            this.include_calendar_details = View.inflate(this.activity, R.layout.s_include_calendar_details, null);
        }
        this.content_layout.addView(this.include_calendar_details);
        this.calendar_details_time_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_time_textview);
        this.calendar_details_distance_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_distance_textview);
        this.calendar_details_calories_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_calories_textview);
        this.calendar_details_goals_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_goals_textview);
        this.calendar_details_notes_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_notes_textview);
        this.calendar_details_avg_hr_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_hr_textview);
        this.calendar_details_avg_speed_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_speed_textview);
        this.calendar_details_avg_rpm_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_rpm_textview);
        this.calendar_details_avg_watts_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_watts_textview);
        this.calendar_details_avg_level_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_level_textview);
        this.calendar_details_avg_mets_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_mets_textview);
        this.calendar_details_raw_datas = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.tvDetailRawDatas);
        TypefaceTextView typefaceTextView = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_time_title_textview);
        TypefaceTextView typefaceTextView2 = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_distance_title_textview);
        TypefaceTextView typefaceTextView3 = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_calories_title_textview);
        TypefaceTextView typefaceTextView4 = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_goals_title_textview);
        TypefaceTextView typefaceTextView5 = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_notes_title_textview);
        TypefaceTextView typefaceTextView6 = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_hr_title_textview);
        TypefaceTextView typefaceTextView7 = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_speed_title_textview);
        TypefaceTextView typefaceTextView8 = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_rpm_title_textview);
        TypefaceTextView typefaceTextView9 = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_watts_title_textview);
        TypefaceTextView typefaceTextView10 = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_level_title_textview);
        TypefaceTextView typefaceTextView11 = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_details_avg_mets_title_textview);
        this.calendar_details_time_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_distance_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_calories_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_goals_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_notes_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_hr_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_speed_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_rpm_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_watts_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_level_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_mets_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView2.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView3.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView4.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView5.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView6.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView7.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView8.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView9.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView10.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView11.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        Resources resources = getResources();
        View viewFindViewById = this.include_calendar_details.findViewById(R.id.calendar_details_time_layout);
        View viewFindViewById2 = this.include_calendar_details.findViewById(R.id.calendar_details_distance_layout);
        View viewFindViewById3 = this.include_calendar_details.findViewById(R.id.calendar_details_calories_layout);
        View viewFindViewById4 = this.include_calendar_details.findViewById(R.id.calendar_details_goals_layout);
        View viewFindViewById5 = this.include_calendar_details.findViewById(R.id.calendar_details_notes_layout);
        View viewFindViewById6 = this.include_calendar_details.findViewById(R.id.calendar_details_avg_hr_layout);
        View viewFindViewById7 = this.include_calendar_details.findViewById(R.id.calendar_details_avg_speed_layout);
        View viewFindViewById8 = this.include_calendar_details.findViewById(R.id.calendar_details_avg_rpm_layout);
        View viewFindViewById9 = this.include_calendar_details.findViewById(R.id.calendar_details_avg_watts_layout);
        View viewFindViewById10 = this.include_calendar_details.findViewById(R.id.calendar_details_avg_level_layout);
        View viewFindViewById11 = this.include_calendar_details.findViewById(R.id.calendar_details_avg_mets_layout);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.height = Global.getLongScreenHeight((int) resources.getDimension(R.dimen.calendar_list_item_single_height), 1.0f);
        viewFindViewById.setLayoutParams(layoutParams);
        viewFindViewById2.setLayoutParams(layoutParams);
        viewFindViewById3.setLayoutParams(layoutParams);
        viewFindViewById6.setLayoutParams(layoutParams);
        viewFindViewById7.setLayoutParams(layoutParams);
        viewFindViewById8.setLayoutParams(layoutParams);
        viewFindViewById9.setLayoutParams(layoutParams);
        viewFindViewById10.setLayoutParams(layoutParams);
        viewFindViewById11.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewFindViewById4.getLayoutParams();
        layoutParams2.height = Global.getLongScreenHeight((int) resources.getDimension(R.dimen.calendar_list_item_multi_height), 1.0f);
        viewFindViewById4.setLayoutParams(layoutParams2);
        viewFindViewById5.setLayoutParams(layoutParams2);
        View viewFindViewById12 = this.include_calendar_details.findViewById(R.id.include_title_bar);
        this.include_title_bar = viewFindViewById12;
        setTitleBarListener(viewFindViewById12);
        TypefaceTextView typefaceTextView12 = (TypefaceTextView) this.include_title_bar.findViewById(R.id.calendar_title_textview);
        this.details_calendar_title_textview = typefaceTextView12;
        typefaceTextView12.setTextSize(0, Global.getLongScreenHeight((int) resources.getDimension(R.dimen.calendar_list_content_text_size), 0.8f));
        this.calendar_second_title_textview = (TypefaceTextView) this.include_calendar_details.findViewById(R.id.calendar_second_title_textview);
        this.detailsCalendarUtils = new CalendarUtils();
        updateTotalsData();
    }

    private void initDetailsForOutdoorView() throws Resources.NotFoundException {
        int i = Global.BRAND;
        if (i == 0) {
            this.include_calendar_details_outdoor = View.inflate(this.activity, R.layout.include_calendar_details_outdoor, null);
        } else if (i == 1 || i == 2 || i == 3) {
            this.include_calendar_details_outdoor = View.inflate(this.activity, R.layout.s_include_calendar_details_outdoor, null);
        }
        this.content_layout.addView(this.include_calendar_details_outdoor);
        MapFragment mapFragment = (MapFragment) this.activity.getFragmentManager().findFragmentById(R.id.outdoor_details_map);
        mapFragment.getMapAsync(this);
        mapFragment.getView().setVisibility(0);
        initValueField();
        initTitleSize();
        initFieldLayout();
        this.calendar_details_content_wrapper_out = this.include_calendar_details_outdoor.findViewById(R.id.content_wrapper_outdoor);
        this.calendar_details_content_wrapper_in = this.include_calendar_details_outdoor.findViewById(R.id.content_wrapper_indoor);
        View viewFindViewById = this.include_calendar_details_outdoor.findViewById(R.id.include_title_bar);
        this.include_title_bar2 = viewFindViewById;
        setTitleBarListener2(viewFindViewById);
        TypefaceTextView typefaceTextView = (TypefaceTextView) this.include_title_bar2.findViewById(R.id.calendar_title_textview);
        this.details_calendar_title_textview2 = typefaceTextView;
        typefaceTextView.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.calendar_list_content_text_size), 0.8f));
        this.calendar_second_title_textview2 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_second_title_textview);
        this.detailsCalendarUtils2 = new CalendarUtils();
        updateTotalsDataForOutdoor(null);
    }

    private void initFieldLayout() {
        View viewFindViewById = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_time_layout);
        View viewFindViewById2 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_distance_layout);
        View viewFindViewById3 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_calories_layout);
        View viewFindViewById4 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_goals_layout);
        View viewFindViewById5 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_notes_layout);
        View viewFindViewById6 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_time_layout_in);
        View viewFindViewById7 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_distance_layout_in);
        View viewFindViewById8 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_calories_layout_in);
        View viewFindViewById9 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_goals_layout_in);
        View viewFindViewById10 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_notes_layout_in);
        View viewFindViewById11 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_hr_layout_in);
        View viewFindViewById12 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_speed_layout_in);
        View viewFindViewById13 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_rpm_layout_in);
        View viewFindViewById14 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_watts_layout_in);
        View viewFindViewById15 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_level_layout_in);
        View viewFindViewById16 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_mets_layout_in);
        Resources resources = getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.height = Global.getLongScreenHeight((int) resources.getDimension(R.dimen.calendar_list_item_single_height), 1.0f);
        viewFindViewById.setLayoutParams(layoutParams);
        viewFindViewById2.setLayoutParams(layoutParams);
        viewFindViewById3.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewFindViewById4.getLayoutParams();
        layoutParams2.height = Global.getLongScreenHeight((int) resources.getDimension(R.dimen.calendar_list_item_multi_height), 1.0f);
        viewFindViewById4.setLayoutParams(layoutParams2);
        viewFindViewById5.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) viewFindViewById6.getLayoutParams();
        layoutParams3.height = Global.getLongScreenHeight((int) resources.getDimension(R.dimen.calendar_list_item_single_height), 1.0f);
        viewFindViewById6.setLayoutParams(layoutParams3);
        viewFindViewById7.setLayoutParams(layoutParams3);
        viewFindViewById8.setLayoutParams(layoutParams3);
        viewFindViewById11.setLayoutParams(layoutParams3);
        viewFindViewById12.setLayoutParams(layoutParams3);
        viewFindViewById13.setLayoutParams(layoutParams3);
        viewFindViewById14.setLayoutParams(layoutParams3);
        viewFindViewById15.setLayoutParams(layoutParams3);
        viewFindViewById16.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) viewFindViewById9.getLayoutParams();
        layoutParams4.height = Global.getLongScreenHeight((int) resources.getDimension(R.dimen.calendar_list_item_multi_height), 1.0f);
        viewFindViewById9.setLayoutParams(layoutParams4);
        viewFindViewById10.setLayoutParams(layoutParams4);
    }

    private void initValueField() {
        this.calendar_details_time_textview2 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_time_textview);
        this.calendar_details_distance_textview2 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_distance_textview);
        this.calendar_details_calories_textview2 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_calories_textview);
        this.calendar_details_pace_textview2 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_goals_textview);
        this.calendar_details_speed_textview2 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_notes_textview);
        this.calendar_details_sport_type_title_textview2 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_sport_type_title_textview);
        this.calendar_details_time_textview2_in = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_time_textview_in);
        this.calendar_details_distance_textview2_in = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_distance_textview_in);
        this.calendar_details_calories_textview2_in = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_calories_textview_in);
        this.calendar_details_goals_textview2_in = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_goals_textview_in);
        this.calendar_details_notes_textview2_in = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_notes_textview_in);
        this.calendar_details_avg_hr_textview2_in = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_hr_textview_in);
        this.calendar_details_avg_speed_textview2_in = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_speed_textview_in);
        this.calendar_details_avg_rpm_textview2_in = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_rpm_textview_in);
        this.calendar_details_avg_watts_textview2_in = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_watts_textview_in);
        this.calendar_details_avg_level_textview2_in = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_level_textview_in);
        this.calendar_details_avg_mets_textview2_in = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_mets_textview_in);
        this.calendar_details_time_textview2.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_distance_textview2.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_calories_textview2.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_pace_textview2.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_speed_textview2.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_time_textview2_in.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_distance_textview2_in.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_calories_textview2_in.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_goals_textview2_in.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_notes_textview2_in.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_hr_textview2_in.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_speed_textview2_in.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_rpm_textview2_in.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_watts_textview2_in.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_level_textview2_in.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        this.calendar_details_avg_mets_textview2_in.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
    }

    private void initTitleSize() {
        TypefaceTextView typefaceTextView = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_time_title_textview);
        TypefaceTextView typefaceTextView2 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_distance_title_textview);
        TypefaceTextView typefaceTextView3 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_calories_title_textview);
        TypefaceTextView typefaceTextView4 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_goals_title_textview);
        TypefaceTextView typefaceTextView5 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_notes_title_textview);
        TypefaceTextView typefaceTextView6 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_time_title_textview_in);
        TypefaceTextView typefaceTextView7 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_distance_title_textview_in);
        TypefaceTextView typefaceTextView8 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_calories_title_textview_in);
        TypefaceTextView typefaceTextView9 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_goals_title_textview_in);
        TypefaceTextView typefaceTextView10 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_notes_title_textview_in);
        TypefaceTextView typefaceTextView11 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_hr_title_textview_in);
        TypefaceTextView typefaceTextView12 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_speed_title_textview_in);
        TypefaceTextView typefaceTextView13 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_rpm_title_textview_in);
        TypefaceTextView typefaceTextView14 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_watts_title_textview_in);
        TypefaceTextView typefaceTextView15 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_level_title_textview_in);
        TypefaceTextView typefaceTextView16 = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_mets_title_textview_in);
        typefaceTextView.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView2.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView3.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView4.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView5.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView6.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView7.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView8.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView9.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView10.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView11.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView12.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView13.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView14.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView15.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView16.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_text_size), 0.8f));
        typefaceTextView4.setText(((Object) typefaceTextView4.getText()) + CertificateUtil.DELIMITER);
    }

    private void initChartView() {
        int i = Global.BRAND;
        if (i == 0) {
            this.include_calendar_chart = View.inflate(this.activity, R.layout.include_calendar_chart, null);
        } else if (i == 1 || i == 2 || i == 3) {
            this.include_calendar_chart = View.inflate(this.activity, R.layout.s_include_calendar_chart, null);
        }
        this.content_layout.addView(this.include_calendar_chart);
        this.chartView = (WorkoutChart) this.include_calendar_chart.findViewById(R.id.workoutchartWrapper);
        this.totalChartView = (WorkoutTotalChart) this.include_calendar_chart.findViewById(R.id.workouttotalchartWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSelectedView() throws Resources.NotFoundException, NumberFormatException {
        int i = Global.getSharedPreferences(this.activity).getInt(CALENDAR_SELECTED_VIEW, 99);
        this.lastSelectedView = i;
        switchFragment(i);
    }

    private void setTitleBarListener(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.calendar_prev_textview);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.calendar_next_textview);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.totalchart);
        imageView2.setOnClickListener(this.onTitleBarClick);
        imageView.setOnClickListener(this.onTitleBarClick);
        imageView3.setOnClickListener(this.onTitleBarClick);
    }

    private void setTitleBarListener2(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.calendar_prev_textview);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.calendar_next_textview);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.totalchart);
        imageView2.setOnClickListener(this.onTitleBarClick2);
        imageView.setOnClickListener(this.onTitleBarClick2);
        imageView3.setOnClickListener(this.onTitleBarClick2);
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void setListeners() {
        this.calendar_bottom_day_textview.setOnClickListener(this);
        this.calendar_bottom_week_textview.setOnClickListener(this);
        this.calendar_bottom_month_textview.setOnClickListener(this);
        this.calendar_bottom_list_textview.setOnClickListener(this);
        this.calendar_bottom_totals_textview.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException, NumberFormatException {
        int i = 99;
        switch (view.getId()) {
            case R.id.calendar_bottom_day_textview /* 2131230875 */:
                ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_bottom_day", ErrorLogSave.CLICK);
                i = 97;
                break;
            case R.id.calendar_bottom_list_textview /* 2131230876 */:
                ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_bottom_list", ErrorLogSave.CLICK);
                i = 100;
                this.totalModeTrainingData = null;
                break;
            case R.id.calendar_bottom_month_textview /* 2131230877 */:
                ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_bottom_month", ErrorLogSave.CLICK);
                break;
            case R.id.calendar_bottom_totals_textview /* 2131230878 */:
                ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_bottom_totals", ErrorLogSave.CLICK);
                i = 101;
                break;
            case R.id.calendar_bottom_week_textview /* 2131230879 */:
                ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_bottom_week", ErrorLogSave.CLICK);
                i = 98;
                break;
        }
        switchFragment(i);
        SharedPreferences.Editor spfEditor = Global.getSpfEditor(this.activity);
        spfEditor.putInt(CALENDAR_SELECTED_VIEW, i);
        spfEditor.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickTotals(int i, boolean z, CalendarUtils calendarUtils) throws Resources.NotFoundException, NumberFormatException {
        switchFragment(102);
        this.detailsCalendarUtils = calendarUtils.m37clone();
        this.include_title_bar.setVisibility(8);
        this.calendar_second_title_textview.setVisibility(8);
        if (i == R.id.calendar_totals_total_textview) {
            ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_totals_total", ErrorLogSave.CLICK);
            this.detailsCalendarUtils.setCalendarType(z, 4);
            this.calendar_second_title_textview.setVisibility(0);
        } else {
            switch (i) {
                case R.id.calendar_list_listview /* 2131230959 */:
                    this.detailsCalendarUtils.setCalendarType(z, 0);
                    break;
                case R.id.calendar_totals_day_textview /* 2131230966 */:
                    ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_totals_day", ErrorLogSave.CLICK);
                    this.detailsCalendarUtils.setCalendarType(z, 0);
                    break;
                case R.id.calendar_totals_month_textview /* 2131230967 */:
                    ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_totals_month", ErrorLogSave.CLICK);
                    this.detailsCalendarUtils.setCalendarType(z, 2);
                    break;
                case R.id.calendar_totals_week_textview /* 2131230969 */:
                    ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_totals_week", ErrorLogSave.CLICK);
                    this.detailsCalendarUtils.setCalendarType(z, 1);
                    break;
                case R.id.calendar_totals_year_textview /* 2131230970 */:
                    ErrorLogSave.addErrorString(FacebookSdk.getApplicationContext(), ErrorLogSave.CLICK, "CalendarMainFragment_totals_year", ErrorLogSave.CLICK);
                    this.detailsCalendarUtils.setCalendarType(z, 3);
                    break;
            }
            this.details_calendar_title_textview.setText(this.detailsCalendarUtils.getNowCalendar());
            this.include_title_bar.setVisibility(0);
        }
        updateTotalsData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickTotalsForOutdoor(DCTrainingData dCTrainingData) throws Resources.NotFoundException, NumberFormatException {
        switchFragment(103);
        this.calendar_second_title_textview2.setVisibility(8);
        this.include_title_bar2.setVisibility(0);
        this.details_calendar_title_textview2.setText(new DateTime(dCTrainingData.getTraining_datetime()).toString("E. MM/dd/yyyy"));
        updateTotalsDataForOutdoor(dCTrainingData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickTotalChart(int i, int i2) throws Resources.NotFoundException, NumberFormatException {
        Interval dateIntervalForTotalChart;
        Log.d("totalchart", "totalchart type:" + i);
        if (i2 == 1) {
            dateIntervalForTotalChart = getDateIntervalForDetail(i);
        } else {
            dateIntervalForTotalChart = i2 == 2 ? null : getDateIntervalForTotalChart(i);
        }
        Log.d("totalchart", "start:" + dateIntervalForTotalChart.getStart().toString(CalendarUtils.SQL_DATE_TIME_FORMAT));
        Log.d("totalchart", "end:" + dateIntervalForTotalChart.getEnd().toString(CalendarUtils.SQL_DATE_TIME_FORMAT));
        long startMillis = dateIntervalForTotalChart.getStartMillis();
        long endMillis = dateIntervalForTotalChart.getEndMillis();
        String str = "%Y-%m-%d";
        if (i == 3) {
            str = "%Y-%m";
        } else if (i != 1 && i != 2) {
            str = "%H h";
        }
        Database database = DbManager.getDCTrainingDataDao().getDatabase();
        String str2 = "select TB.CATALOG,sum(TB.TOTAL_TIME) as TOTAL_TIME,sum(TB.TOTAL_DISTANCE) as TOTAL_DISTANCE,sum(TB.TOTAL_CALORIES) as TOTAL_CALORIES  from ( select strftime('" + str + "',TRAINING_DATETIME/1000,'unixepoch','localtime') as CATALOG,TOTAL_TIME/60 as TOTAL_TIME,TOTAL_DISTANCE,TOTAL_CALORIES from TRAINING_DATA where account='" + Global.calendarUserName + "' and TRAINING_DATETIME between " + startMillis + " and " + endMillis + " ) as TB group by CATALOG order by CATALOG ";
        Log.d("totalchart", "sqlCmd:" + str2);
        Cursor cursorRawQuery = database.rawQuery(str2, null);
        ArrayList arrayList = new ArrayList();
        if (cursorRawQuery != null) {
            while (cursorRawQuery.moveToNext()) {
                DCTrainingData dCTrainingData = new DCTrainingData();
                String string = cursorRawQuery.getString(0);
                float f = cursorRawQuery.getFloat(1);
                float f2 = cursorRawQuery.getFloat(2);
                float f3 = cursorRawQuery.getFloat(3);
                dCTrainingData.setCategory_code(string);
                dCTrainingData.setTotal_time(f);
                dCTrainingData.setTotal_distance(f2);
                dCTrainingData.setTotal_calories(f3);
                arrayList.add(dCTrainingData);
                Log.d("totalchart", "catalog:" + string + " total_time:" + f + " total_distance:" + f2 + " total_calories:" + f3);
            }
            cursorRawQuery.close();
        }
        if (arrayList.size() == 0) {
            Toast.makeText(this.activity, "No any fitness data.", 1).show();
            return;
        }
        DCTrainingData dCTrainingData2 = new DCTrainingData();
        dCTrainingData2.setCategory_code(StringUtils.SPACE);
        dCTrainingData2.setTotal_time(0.0f);
        dCTrainingData2.setTotal_distance(0.0f);
        dCTrainingData2.setTotal_calories(0.0f);
        arrayList.add(0, dCTrainingData2);
        DCTrainingData dCTrainingData3 = new DCTrainingData();
        dCTrainingData3.setCategory_code(StringUtils.SPACE);
        dCTrainingData3.setTotal_time(0.0f);
        dCTrainingData3.setTotal_distance(0.0f);
        dCTrainingData3.setTotal_calories(0.0f);
        arrayList.add(dCTrainingData3);
        this.totalChartView.setVisibility(0);
        this.chartView.setVisibility(8);
        switchFragment(104);
        this.rootView.setBackgroundColor(-1);
        if (Global.BRAND == 0) {
            this.activity.setBackgroundColor(-1);
        }
        this.totalChartView.updateView(i, arrayList, dateIntervalForTotalChart);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickChart(int i, boolean z, CalendarUtils calendarUtils, DCTrainingData dCTrainingData) throws Resources.NotFoundException, NumberFormatException {
        CalendarUtils calendarUtilsM37clone = calendarUtils.m37clone();
        this.detailsCalendarUtils = calendarUtilsM37clone;
        calendarUtilsM37clone.setCalendarType(z, 0);
        DbManager.getInstance(this.activity);
        if (dCTrainingData.getIn_out().equals(ExifInterface.GPS_MEASUREMENT_2D) || (dCTrainingData.getBrand_code() != null && dCTrainingData.getBrand_code().contains("garmin"))) {
            DCTrainingData dCTrainingData2 = new DCTrainingData();
            dCTrainingData2.setTotal_calories(dCTrainingData.getTotal_calories());
            dCTrainingData2.setAvg_speed(dCTrainingData.getAvg_speed());
            dCTrainingData2.setTotal_distance(dCTrainingData.getTotal_distance());
            dCTrainingData2.setAvg_rpm(dCTrainingData.getAvg_rpm());
            dCTrainingData2.setAvg_hr(dCTrainingData.getAvg_hr());
            dCTrainingData2.setBrand_code(dCTrainingData.getBrand_code());
            dCTrainingData2.setBrand_type(dCTrainingData.getBrand_type());
            dCTrainingData2.setCategory_code(dCTrainingData.getCategory_code());
            dCTrainingData2.setDevice_model(dCTrainingData.getDevice_model());
            dCTrainingData2.setIn_out(dCTrainingData.getIn_out());
            dCTrainingData2.setModel_code(dCTrainingData.getModel_code());
            dCTrainingData2.setProgram_name(dCTrainingData.getProgram_name());
            dCTrainingData2.setProgramNameRes(dCTrainingData.getProgramNameRes());
            dCTrainingData2.setSales_version(dCTrainingData.getSales_version());
            dCTrainingData2.setTotal_time(dCTrainingData.getTotal_time());
            dCTrainingData2.setTraining_datetime(dCTrainingData.getTraining_datetime());
            dCTrainingData2.setUnit(dCTrainingData.getUnit());
            dCTrainingData2.setTrainingId(dCTrainingData.getTrainingId());
            dCTrainingData2.setTrainh_no(dCTrainingData.getTrainh_no());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CalendarUtils.SQL_DATE_FORMAT, Locale.getDefault());
            Date training_datetime = dCTrainingData2.getTraining_datetime();
            String str = simpleDateFormat.format(training_datetime);
            String str2 = simpleDateFormat.format(training_datetime) + " 23:59:59";
            DateTime dateTime = DateTime.parse(str, DateTimeFormat.forPattern(CalendarUtils.SQL_DATE_FORMAT));
            DateTime dateTime2 = DateTime.parse(str2, DateTimeFormat.forPattern(CalendarUtils.SQL_DATE_TIME_FORMAT));
            String str3 = TAG;
            Log.d(str3, "start==>" + dateTime.toString("yyyy/MM/dd HH:mm:ss"));
            Log.d(str3, "endDateTime==>" + dateTime2.toString("yyyy/MM/dd HH:mm:ss"));
            List<DCTrainingData> list = DbManager.getDCTrainingDataDao().queryBuilder().where(DCTrainingDataDao.Properties.Brand_code.eq("garmin"), new WhereCondition[0]).where(DCTrainingDataDao.Properties.Account.eq(Global.calendarUserName), new WhereCondition[0]).where(DCTrainingDataDao.Properties.Training_datetime.between(dateTime.toDate(), dateTime2.toDate()), new WhereCondition[0]).orderAsc(DCTrainingDataDao.Properties.Training_datetime).list();
            Log.d(str3, "queryList==>" + list.size());
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            for (int i2 = 0; i2 < size; i2++) {
                DCTrainingData dCTrainingData3 = list.get(i2);
                DCTrainingDetailData dCTrainingDetailData = new DCTrainingDetailData();
                dCTrainingDetailData.setTraning_datetime(dCTrainingData3.getTraining_datetime());
                float total_distance = dCTrainingData3.getTotal_distance();
                float total_calories = dCTrainingData3.getTotal_calories();
                float avg_speed = dCTrainingData3.getAvg_speed();
                float total_time = dCTrainingData3.getTotal_time();
                dCTrainingDetailData.setD_distance(total_distance);
                dCTrainingDetailData.setD_calories(total_calories);
                dCTrainingDetailData.setD_speed(avg_speed);
                dCTrainingDetailData.setD_time(total_time);
                f4 += total_calories;
                f2 += total_distance;
                f3 += avg_speed;
                f += total_time;
                arrayList.add(dCTrainingDetailData);
            }
            dCTrainingData2.setTotal_time(f);
            dCTrainingData2.setTotal_distance(f2);
            dCTrainingData2.setAvg_speed(f3 / size);
            dCTrainingData2.setTotal_calories(f4);
            if (arrayList.size() == 0) {
                Toast.makeText(this.activity, "No any fitness data.", 1).show();
                return;
            }
            DCTrainingDetailData dCTrainingDetailData2 = new DCTrainingDetailData();
            dCTrainingDetailData2.setTraning_datetime(list.get(0).getTraining_datetime());
            dCTrainingDetailData2.setD_distance(0.0f);
            dCTrainingDetailData2.setD_calories(0.0f);
            dCTrainingDetailData2.setD_speed(0.0f);
            dCTrainingDetailData2.setD_time(0.0f);
            arrayList.add(0, dCTrainingDetailData2);
            DCTrainingDetailData dCTrainingDetailData3 = new DCTrainingDetailData();
            dCTrainingDetailData3.setTraning_datetime(list.get(list.size() - 1).getTraining_datetime());
            dCTrainingDetailData3.setD_distance(0.0f);
            dCTrainingDetailData3.setD_calories(0.0f);
            dCTrainingDetailData3.setD_speed(0.0f);
            dCTrainingDetailData3.setD_time(0.0f);
            arrayList.add(dCTrainingDetailData3);
            this.chartView.updateView(dCTrainingData2, arrayList);
        } else {
            List<DCTrainingDetailData> list2 = DbManager.getDCTrainingDetailDataDao().queryBuilder().where(DCTrainingDetailDataDao.Properties.TrainingId.eq(dCTrainingData.getTrainingId()), new WhereCondition[0]).list();
            if (list2 != null && list2.size() == 0) {
                Toast.makeText(this.activity, "No any fitness data.", 1).show();
                return;
            }
            this.chartView.updateView(dCTrainingData, list2);
        }
        this.totalChartView.setVisibility(8);
        this.chartView.setVisibility(0);
        switchFragment(104);
        this.rootView.setBackgroundColor(-1);
        if (Global.BRAND != 0) {
            return;
        }
        this.activity.setBackgroundColor(-1);
    }

    private void setBottomButtonState(int i) {
        int i2 = Global.BRAND;
        if (i2 == 0) {
            this.calendar_bottom_day_textview.setBackgroundResource(R.drawable.all_btn_a_02);
            this.calendar_bottom_week_textview.setBackgroundResource(R.drawable.all_btn_a_02);
            this.calendar_bottom_month_textview.setBackgroundResource(R.drawable.all_btn_a_02);
            this.calendar_bottom_list_textview.setBackgroundResource(R.drawable.all_btn_a_02);
            this.calendar_bottom_totals_textview.setBackgroundResource(R.drawable.all_btn_a_02);
            if (i == 0) {
                this.calendar_bottom_day_textview.setBackgroundResource(R.drawable.all_btn_a_03);
                return;
            }
            if (i == 1) {
                this.calendar_bottom_week_textview.setBackgroundResource(R.drawable.all_btn_a_03);
                return;
            }
            if (i == 2) {
                this.calendar_bottom_month_textview.setBackgroundResource(R.drawable.all_btn_a_03);
                return;
            }
            if (i == 3) {
                this.calendar_bottom_list_textview.setBackgroundResource(R.drawable.all_btn_a_03);
                return;
            } else {
                if (i == 4 || i == 5) {
                    this.calendar_bottom_totals_textview.setBackgroundResource(R.drawable.all_btn_a_03);
                    return;
                }
                return;
            }
        }
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (Global.BRAND == 1) {
                this.calendar_bottom_day_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
                this.calendar_bottom_week_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
                this.calendar_bottom_month_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
                this.calendar_bottom_list_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
                this.calendar_bottom_totals_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
                if (i == 0) {
                    this.calendar_bottom_day_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_1);
                    return;
                }
                if (i == 1) {
                    this.calendar_bottom_week_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_1);
                    return;
                }
                if (i == 2) {
                    this.calendar_bottom_month_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_1);
                    return;
                }
                if (i == 3) {
                    this.calendar_bottom_list_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_1);
                    return;
                } else {
                    if (i == 4 || i == 5) {
                        this.calendar_bottom_totals_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_1);
                        return;
                    }
                    return;
                }
            }
            this.calendar_bottom_day_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
            this.calendar_bottom_week_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
            this.calendar_bottom_month_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
            this.calendar_bottom_list_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
            this.calendar_bottom_totals_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
            if (i == 0) {
                this.calendar_bottom_day_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_1);
                return;
            }
            if (i == 1) {
                this.calendar_bottom_week_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_1);
                return;
            }
            if (i == 2) {
                this.calendar_bottom_month_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_1);
                return;
            }
            if (i == 3) {
                this.calendar_bottom_list_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_1);
            } else if (i == 4 || i == 5) {
                this.calendar_bottom_totals_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_1);
            }
        }
    }

    public void hideFragment() throws Resources.NotFoundException, NumberFormatException {
        switchFragment(-1);
    }

    public void switchFragment(int i) throws Resources.NotFoundException, NumberFormatException {
        ArrayList<WorkoutData> arrayListSaveAsWorkoutData;
        this.include_calendar_day.setVisibility(8);
        this.include_calendar_week.setVisibility(8);
        this.include_calendar_month.setVisibility(8);
        this.include_calendar_list.setVisibility(8);
        this.include_calendar_totals.setVisibility(8);
        this.include_calendar_details.setVisibility(8);
        this.include_calendar_details_outdoor.setVisibility(8);
        this.include_calendar_chart.setVisibility(8);
        if (Global.BRAND == 0) {
            this.rootView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            if (i != -1) {
                this.activity.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
        }
        if (i == 6) {
            i = 99;
        }
        int i2 = i - 97;
        this.nowPage = i2;
        setBottomButtonState(i2);
        Log.d("TOM", "nowPage:" + this.nowPage);
        switch (this.nowPage) {
            case 0:
                this.day_calendar_title_textview.setText(this.dayCalendarUtils.getNowCalendar());
                this.calendar_day_view.updateView(this.dayCalendarUtils.getNowDayCalendarForSQL());
                this.include_calendar_day.setVisibility(0);
                Global.shareMore = false;
                break;
            case 1:
                this.week_calendar_title_textview.setText(this.weekCalendarUtils.getNowCalendar());
                this.calendar_week_title_view.changeCalendar(this.weekCalendarUtils.getCalendar());
                this.calendar_week_view.updateView(this.weekCalendarUtils.getNowWeekCalendarForSQL());
                this.include_calendar_week.setVisibility(0);
                Global.shareMore = false;
                break;
            case 2:
                this.month_calendar_title_textview.setText(this.monthCalendarUtils.getNowCalendar());
                this.calendar_month_view.updateView(this.monthCalendarUtils);
                this.include_calendar_month.setVisibility(0);
                Global.shareMore = false;
                break;
            case 3:
                Logger.d("totalModeTrainingData = " + this.totalModeTrainingData);
                List<DCTrainingData> list = this.totalModeTrainingData;
                if (list != null) {
                    arrayListSaveAsWorkoutData = saveAsWorkoutData(list);
                } else {
                    arrayListSaveAsWorkoutData = saveAsWorkoutData(loadListData2());
                }
                this.calendarListAdapter.setData(arrayListSaveAsWorkoutData);
                this.include_calendar_list.setVisibility(0);
                Global.shareMore = false;
                break;
            case 4:
                this.include_calendar_totals.setVisibility(0);
                Global.shareMore = false;
                break;
            case 5:
                this.include_calendar_details.setVisibility(0);
                Global.shareMore = false;
                break;
            case 6:
                this.include_calendar_details_outdoor.setVisibility(0);
                Global.shareMore = true;
                break;
            case 7:
                this.include_calendar_chart.setVisibility(0);
                Global.shareMore = false;
                break;
        }
        setShareRecording();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShareRecording() {
        this.shareRecording = "";
        this.trackCalories = null;
        this.trackStartDate = null;
        this.trackDuration = null;
        this.trackDistance = null;
        this.trackSpeed = null;
        this.trackHeartRate = null;
        int i = this.nowPage;
        if (i == 0) {
            this.shareRecording = this.calendar_day_view.getFirstRecording();
            this.trackCalories = this.calendar_day_view.getTrackCalories();
            this.trackStartDate = this.calendar_day_view.getTrackStartDate();
            this.trackDuration = this.calendar_day_view.getTrackDuration();
            this.trackDistance = this.calendar_day_view.getTrackDistance();
            this.trackSpeed = this.calendar_day_view.getTrackSpeed();
            this.trackHeartRate = this.calendar_day_view.getTrackHeartRate();
            return;
        }
        if (i == 1) {
            this.shareRecording = this.calendar_week_view.getFirstRecording();
            this.trackCalories = this.calendar_week_view.getTrackCalories();
            this.trackStartDate = this.calendar_week_view.getTrackStartDate();
            this.trackDuration = this.calendar_week_view.getTrackDuration();
            this.trackDistance = this.calendar_week_view.getTrackDistance();
            this.trackSpeed = this.calendar_week_view.getTrackSpeed();
            this.trackHeartRate = this.calendar_week_view.getTrackHeartRate();
            return;
        }
        if (i == 2) {
            this.shareRecording = this.calendar_month_view.getFirstRecording();
            this.trackCalories = this.calendar_month_view.getTrackCalories();
            this.trackStartDate = this.calendar_month_view.getTrackStartDate();
            this.trackDuration = this.calendar_month_view.getTrackDuration();
            this.trackDistance = this.calendar_month_view.getTrackDistance();
            this.trackSpeed = this.calendar_month_view.getTrackSpeed();
            this.trackHeartRate = this.calendar_month_view.getTrackHeartRate();
            return;
        }
        if (i != 3) {
            return;
        }
        this.shareRecording = this.calendarListAdapter.getFirstRecording();
        this.trackCalories = this.calendarListAdapter.getTrackCalories();
        this.trackStartDate = this.calendarListAdapter.getTrackStartDate();
        this.trackDuration = this.calendarListAdapter.getTrackDuration();
        this.trackDistance = this.calendarListAdapter.getTrackDistance();
        this.trackSpeed = this.calendarListAdapter.getTrackSpeed();
        this.trackHeartRate = this.calendarListAdapter.getTrackHeartRate();
        this.shareProgram = this.calendarListAdapter.getTrackProgram();
    }

    public String getShareCategory() {
        return this.shareCategory;
    }

    public String getShareModel() {
        return this.shareModel;
    }

    public String getShareProgram() {
        return this.shareProgram;
    }

    public String getShareRecording() {
        return this.shareRecording;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDay() {
        CalendarDayView calendarDayView = this.calendar_day_view;
        if (calendarDayView == null) {
            return;
        }
        calendarDayView.updateView(this.dayCalendarUtils.getNowDayCalendarForSQL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWeek() throws Resources.NotFoundException {
        CalendarWeekView calendarWeekView = this.calendar_week_view;
        if (calendarWeekView == null) {
            return;
        }
        calendarWeekView.updateView(this.weekCalendarUtils.getNowWeekCalendarForSQL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMonth() {
        if (this.calendar_month_view == null) {
            return;
        }
        String str = TAG;
        Log.d(str, "TAG updateMonth = " + str);
        this.calendar_month_view.updateView(this.monthCalendarUtils);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateListData() {
        String str = TAG;
        Log.d(str, "TAG = " + str);
        if (this.calendarListAdapter == null) {
            return;
        }
        this.calendarListAdapter.setData(saveAsWorkoutData(loadListData2()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DCTrainingData> loadListData2() {
        List<DCTrainingData> arrayList = new ArrayList();
        DbManager.getInstance(this.activity);
        QueryBuilder<DCTrainingData> queryBuilder = DbManager.getDCTrainingDataDao().queryBuilder();
        if (Global.memberData != null && Global.memberData.getAccount() != null) {
            queryBuilder.where(DCTrainingDataDao.Properties.Account.eq(Global.memberData.getAccount()), new WhereCondition[0]);
            queryBuilder.orderDesc(DCTrainingDataDao.Properties.Training_datetime);
            arrayList = queryBuilder.list();
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (DCTrainingData dCTrainingData : arrayList) {
                boolean z = dCTrainingData.getBrand_code() != null && dCTrainingData.getBrand_code().contains(Global.CLOUD_BRAND_NAME);
                if (dCTrainingData.getBrand_code() != null && dCTrainingData.getBrand_code().equals("garmin")) {
                    z = true;
                }
                if (TextUtils.equals(dCTrainingData.getIn_out(), AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    z = true;
                }
                if (!z) {
                    arrayList2.add(dCTrainingData);
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.removeAll(arrayList2);
            }
        }
        Log.d(TAG, "loadListData2 trainingDatas = " + arrayList);
        return arrayList;
    }

    private List<DCTrainingData> loadListData3() {
        DbManager.getInstance(this.activity);
        QueryBuilder<DCTrainingData> queryBuilder = DbManager.getDCTrainingDataDao().queryBuilder();
        queryBuilder.where(DCTrainingDataDao.Properties.Account.eq(Global.calendarUserName), DCTrainingDataDao.Properties.In_out.eq(AppEventsConstants.EVENT_PARAM_VALUE_YES));
        queryBuilder.orderDesc(DCTrainingDataDao.Properties.Training_datetime);
        List<DCTrainingData> list = queryBuilder.list();
        Log.d(TAG, "list = " + list);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DCTrainingData loadTrainingDataBy(Long l) {
        DbManager.getInstance(this.activity);
        return DbManager.getDCTrainingDataDao().load(l);
    }

    private ArrayList<WorkoutData> saveAsWorkoutData(List<DCTrainingData> list) {
        ArrayList<WorkoutData> arrayList = new ArrayList<>();
        if (list != null) {
            for (DCTrainingData dCTrainingData : list) {
                WorkoutData workoutData = new WorkoutData();
                workoutData.setName(dCTrainingData.getProgram_name());
                workoutData.setTrainingDataId(dCTrainingData.getTrainingId());
                workoutData.setStartDate(new DateTime(dCTrainingData.getTraining_datetime()).toString("yyy-MM-dd HH:mm:ss"));
                workoutData.setEndDate(new DateTime(dCTrainingData.getTraining_datetime()).plusSeconds((int) dCTrainingData.getTotal_time()).toString("yyy-MM-dd HH:mm:ss"));
                if (dCTrainingData.getBrand_code() != null && dCTrainingData.getBrand_code().equals("garmin")) {
                    workoutData.setIn_out(ExifInterface.GPS_MEASUREMENT_2D);
                } else {
                    workoutData.setIn_out(dCTrainingData.getIn_out());
                }
                try {
                    Integer num = DeviceModelList.programTexts.get(dCTrainingData.getProgram_name());
                    if (num != null) {
                        workoutData.setProgramNameRes(num.intValue());
                    } else {
                        workoutData.setName(dCTrainingData.getProgram_name());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                workoutData.setDuration((int) dCTrainingData.getTotal_time());
                arrayList.add(workoutData);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTotalsData() throws Resources.NotFoundException {
        DCTrainingData dCTrainingData;
        CalendarUtils calendarUtils = this.detailsCalendarUtils;
        if (calendarUtils == null) {
            return;
        }
        int calendarType = calendarUtils.getCalendarType();
        Interval dateIntervalForDetail = getDateIntervalForDetail(calendarType);
        if (calendarType == 4) {
            dateIntervalForDetail = new Interval(new DateTime().minusYears(20), new DateTime());
        }
        WhereCondition whereConditionBetween = DCTrainingDataDao.Properties.Training_datetime.between(dateIntervalForDetail.getStart().toDate(), dateIntervalForDetail.getEnd().toDate());
        QueryBuilder<DCTrainingData> queryBuilder = DbManager.getDCTrainingDataDao().queryBuilder();
        queryBuilder.where(DCTrainingDataDao.Properties.Account.eq(Global.calendarUserName), whereConditionBetween).orderDesc(DCTrainingDataDao.Properties.Training_datetime);
        final List<DCTrainingData> list = queryBuilder.list();
        DCTrainingData dCTrainingData2 = new DCTrainingData();
        if (list == null || list.size() <= 0) {
            dCTrainingData = null;
        } else {
            countSumAvg(list, dCTrainingData2);
            dCTrainingData = list.get(0);
        }
        this.calendar_details_time_textview.setText(StringUtils.SPACE);
        this.calendar_details_distance_textview.setText(StringUtils.SPACE);
        this.calendar_details_calories_textview.setText(StringUtils.SPACE);
        this.calendar_details_goals_textview.setText(StringUtils.SPACE);
        this.calendar_details_notes_textview.setText(StringUtils.SPACE);
        this.calendar_details_avg_hr_textview.setText(StringUtils.SPACE);
        this.calendar_details_avg_speed_textview.setText(StringUtils.SPACE);
        this.calendar_details_avg_rpm_textview.setText(StringUtils.SPACE);
        this.calendar_details_avg_watts_textview.setText(StringUtils.SPACE);
        this.calendar_details_avg_level_textview.setText(StringUtils.SPACE);
        this.calendar_details_avg_mets_textview.setText(StringUtils.SPACE);
        this.shareRecording = "";
        this.trackCalories = null;
        this.trackStartDate = null;
        this.trackDuration = null;
        this.trackDistance = null;
        Global.getSharedPreferences(this.activity);
        int i = this.activity.getSharedPreferences("UnitWay", 0).getInt("unit", -1);
        if (i == -1) {
            i = !dCTrainingData2.getUnit().equals("") ? Integer.parseInt(dCTrainingData2.getUnit()) : 0;
        }
        long total_time = (long) dCTrainingData2.getTotal_time();
        String str = String.format("%02d", Long.valueOf(total_time / 3600));
        String str2 = String.format("%02d", Long.valueOf((total_time / 60) % 60));
        String str3 = String.format("%02d", Long.valueOf(total_time % 60));
        String string = this.res.getString(R.string.unit_time_hh_mm);
        Logger.d("hour = " + str);
        String strValueOf = String.valueOf(dCTrainingData2.getTotal_calories());
        float total_distance = dCTrainingData2.getTotal_distance();
        if (i != 0) {
            total_distance /= 1.6f;
        }
        String strValueOf2 = String.valueOf(total_distance);
        StringBuilder sb = new StringBuilder();
        sb.append(strValueOf2);
        sb.append(StringUtils.SPACE);
        sb.append(this.res.getString(i == 0 ? R.string.unit_km : R.string.unit_mi));
        String string2 = sb.toString();
        float avg_speed = dCTrainingData2.getAvg_speed();
        if (i != 0) {
            avg_speed /= 1.6f;
        }
        String strValueOf3 = String.valueOf(avg_speed);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strValueOf3);
        sb2.append(StringUtils.SPACE);
        sb2.append(this.res.getString(i == 0 ? R.string.unit_kmph : R.string.unit_mph));
        String string3 = sb2.toString();
        TypefaceTextView typefaceTextView = this.calendar_details_time_textview;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(CertificateUtil.DELIMITER);
        sb3.append(str2);
        int i2 = i;
        sb3.append("   ");
        sb3.append(string);
        typefaceTextView.setText(sb3.toString());
        this.calendar_details_distance_textview.setText(string2);
        this.calendar_details_calories_textview.setText(strValueOf);
        this.calendar_details_goals_textview.setText(dCTrainingData2.getGoals());
        this.calendar_details_notes_textview.setText(dCTrainingData2.getNotes());
        this.calendar_details_avg_hr_textview.setText(dCTrainingData2.getAvg_hr() + StringUtils.SPACE + this.res.getString(R.string.unit_bpm));
        this.calendar_details_avg_speed_textview.setText(string3);
        this.calendar_details_avg_rpm_textview.setText(String.valueOf(dCTrainingData2.getAvg_rpm()));
        this.calendar_details_avg_watts_textview.setText(String.valueOf(dCTrainingData2.getAvg_watt()));
        this.calendar_details_avg_level_textview.setText(String.valueOf(dCTrainingData2.getAvg_level()));
        this.calendar_details_avg_mets_textview.setText(String.format("%.2f", Float.valueOf(dCTrainingData2.getAvg_met())));
        if (dCTrainingData != null) {
            searchTrainingData(this.trainingDatas, dCTrainingData);
            this.calendar_details_raw_datas.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws Resources.NotFoundException, NumberFormatException {
                    CalendarMainFragment.this.totalModeTrainingData = list;
                    CalendarMainFragment.this.switchFragment(100);
                }
            });
        }
        this.shareRecording = string2 + HelpFormatter.DEFAULT_OPT_PREFIX + str + CertificateUtil.DELIMITER + str2 + CertificateUtil.DELIMITER + str3;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT);
        this.trackCalories = String.valueOf(dCTrainingData2.getTotal_calories());
        this.trackStartDate = simpleDateFormat.format(dCTrainingData2.getTraining_datetime());
        this.trackDuration = String.valueOf((int) dCTrainingData2.getTotal_time());
        if (i2 == 1) {
            this.trackDistance = String.valueOf(dCTrainingData2.getTotal_distance() * 1.6f);
            this.trackSpeed = String.valueOf(dCTrainingData2.getAvg_speed() * 1.6f);
        } else {
            this.trackDistance = String.valueOf(dCTrainingData2.getTotal_distance());
            this.trackSpeed = String.valueOf(dCTrainingData2.getAvg_speed());
        }
        this.trackHeartRate = String.valueOf(dCTrainingData2.getAvg_hr());
    }

    private int searchTrainingData(List<DCTrainingData> list, DCTrainingData dCTrainingData) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTrainingId().longValue() == dCTrainingData.getTrainingId().longValue()) {
                return i;
            }
        }
        return -1;
    }

    private Interval getDateIntervalForDetail(int i) {
        String nowMonthCalendarForSQL;
        String nowMonthCalendarForSQL2;
        new DateTime().toString(CalendarUtils.SQL_DATE_FORMAT);
        new DateTime().toString(CalendarUtils.SQL_DATE_FORMAT);
        Calendar calendar = this.detailsCalendarUtils.getCalendar();
        if (i == 1) {
            String[] strArrSplit = this.detailsCalendarUtils.getNowWeekCalendarForSQL().split("&");
            String str = strArrSplit[0];
            nowMonthCalendarForSQL = strArrSplit[1];
            nowMonthCalendarForSQL2 = str;
        } else if (i == 2) {
            calendar.set(5, 1);
            nowMonthCalendarForSQL2 = this.detailsCalendarUtils.getNowMonthCalendarForSQL(calendar.getTime());
            calendar.set(5, calendar.getActualMaximum(5));
            nowMonthCalendarForSQL = this.detailsCalendarUtils.getNowMonthCalendarForSQL(calendar.getTime());
        } else if (i != 3) {
            nowMonthCalendarForSQL2 = this.detailsCalendarUtils.getNowDayCalendarForSQL();
            nowMonthCalendarForSQL = nowMonthCalendarForSQL2;
        } else {
            calendar.set(2, 0);
            calendar.set(5, 1);
            nowMonthCalendarForSQL2 = this.detailsCalendarUtils.getNowMonthCalendarForSQL(calendar.getTime());
            calendar.set(2, calendar.getActualMaximum(2));
            calendar.set(5, calendar.getActualMaximum(5));
            nowMonthCalendarForSQL = this.detailsCalendarUtils.getNowMonthCalendarForSQL(calendar.getTime());
        }
        return new Interval(DateTime.parse(nowMonthCalendarForSQL2), DateTime.parse(nowMonthCalendarForSQL).plusHours(23).plusMinutes(59).plusSeconds(59));
    }

    private Interval getDateIntervalForTotalChart(int i) {
        Calendar calendar;
        String nowMonthCalendarForSQL;
        String nowMonthCalendarForSQL2;
        String str;
        String nowDayCalendarForSQL;
        new DateTime().toString(CalendarUtils.SQL_DATE_FORMAT);
        new DateTime().toString(CalendarUtils.SQL_DATE_FORMAT);
        if (i == 1) {
            calendar = this.weekCalendarUtils.getCalendar();
        } else if (i == 2) {
            calendar = this.monthCalendarUtils.getCalendar();
        } else {
            calendar = this.dayCalendarUtils.getCalendar();
        }
        if (i == 1) {
            String[] strArrSplit = this.weekCalendarUtils.getNowWeekCalendarForSQL().split("&");
            nowMonthCalendarForSQL = strArrSplit[0];
            nowMonthCalendarForSQL2 = strArrSplit[1];
        } else {
            if (i != 2) {
                nowDayCalendarForSQL = this.dayCalendarUtils.getNowDayCalendarForSQL();
                str = nowDayCalendarForSQL;
                return new Interval(DateTime.parse(nowDayCalendarForSQL), DateTime.parse(str).plusHours(23).plusMinutes(59).plusSeconds(59));
            }
            calendar.set(5, 1);
            nowMonthCalendarForSQL = this.monthCalendarUtils.getNowMonthCalendarForSQL(calendar.getTime());
            calendar.set(5, calendar.getActualMaximum(5));
            nowMonthCalendarForSQL2 = this.monthCalendarUtils.getNowMonthCalendarForSQL(calendar.getTime());
        }
        String str2 = nowMonthCalendarForSQL;
        str = nowMonthCalendarForSQL2;
        nowDayCalendarForSQL = str2;
        return new Interval(DateTime.parse(nowDayCalendarForSQL), DateTime.parse(str).plusHours(23).plusMinutes(59).plusSeconds(59));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:81:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x061b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateTotalsDataForOutdoor(DCTrainingData dCTrainingData) throws Resources.NotFoundException {
        List<DCTrainingData> list;
        String str;
        String str2;
        int i;
        String scaleToString;
        String scaleToString2;
        List<DCTrainingData> list2;
        emptyDetailFieldValue();
        if (dCTrainingData == null) {
            return;
        }
        new DCTrainingData();
        List<DCTrainingDetailData> list3 = null;
        try {
            DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
            DCTrainingData dCTrainingDataLoad = dCTrainingDataDao.load(dCTrainingData.getTrainingId());
            if (dCTrainingDataLoad.getIn_out().equals(ExifInterface.GPS_MEASUREMENT_2D) || (dCTrainingDataLoad.getBrand_code() != null && dCTrainingDataLoad.getBrand_code().contains("garmin"))) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CalendarUtils.SQL_DATE_FORMAT, Locale.getDefault());
                Date training_datetime = dCTrainingDataLoad.getTraining_datetime();
                list2 = dCTrainingDataDao.queryBuilder().where(DCTrainingDataDao.Properties.Brand_code.eq("garmin"), new WhereCondition[0]).where(DCTrainingDataDao.Properties.Account.eq(Global.calendarUserName), new WhereCondition[0]).where(DCTrainingDataDao.Properties.Training_datetime.between(DateTime.parse(simpleDateFormat.format(training_datetime), DateTimeFormat.forPattern(CalendarUtils.SQL_DATE_FORMAT)).toDate(), DateTime.parse(simpleDateFormat.format(training_datetime) + " 23:59:59", DateTimeFormat.forPattern(CalendarUtils.SQL_DATE_TIME_FORMAT)).toDate()), new WhereCondition[0]).orderAsc(DCTrainingDataDao.Properties.Training_datetime).list();
            } else {
                list2 = null;
            }
            list = list2;
        } catch (Exception e) {
            e.printStackTrace();
            list = null;
        }
        if (dCTrainingData != null && dCTrainingData.getTrainingId() != null) {
            try {
                list3 = DbManager.getDCTrainingDetailDataDao().queryBuilder().where(DCTrainingDetailDataDao.Properties.TrainingId.eq(dCTrainingData.getTrainingId()), new WhereCondition[0]).list();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        View view = this.include_title_bar2;
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.totalchart);
            imageView.setVisibility(4);
            if (list != null && !list.isEmpty()) {
                imageView.setVisibility(0);
            }
            if (list3 != null && !list3.isEmpty()) {
                imageView.setVisibility(0);
            }
        }
        this.calendar_details_content_wrapper_out.setVisibility(8);
        this.calendar_details_content_wrapper_in.setVisibility(8);
        if (dCTrainingData.getIn_out().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            this.calendar_details_content_wrapper_out.setVisibility(0);
        } else {
            this.calendar_details_content_wrapper_in.setVisibility(0);
        }
        int i2 = this.activity.getSharedPreferences("UnitWay", 0).getInt("unit", -1);
        if (i2 == -1) {
            i2 = !dCTrainingData.getUnit().equals("") ? Integer.parseInt(dCTrainingData.getUnit()) : 0;
        }
        long total_time = (long) dCTrainingData.getTotal_time();
        String str3 = String.format("%02d", Long.valueOf(total_time / 3600));
        String str4 = String.format("%02d", Long.valueOf((total_time / 60) % 60));
        String str5 = String.format("%02d", Long.valueOf(total_time % 60));
        String string = this.res.getString(R.string.unit_time);
        String string2 = this.res.getString(R.string.unit_time_hh_mm);
        String strValueOf = String.valueOf(dCTrainingData.getTotal_calories());
        String scaleToString3 = Global.getScaleToString(dCTrainingData.getTotal_distance(), 1);
        String scaleToString4 = Global.getScaleToString(dCTrainingData.getAvg_speed(), 1);
        float total_time2 = dCTrainingData.getTotal_distance() != 0.0f ? (dCTrainingData.getTotal_time() / dCTrainingData.getTotal_distance()) / 60.0f : 0.0f;
        View viewFindViewById = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_goals_layout_in);
        View viewFindViewById2 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_notes_layout_in);
        View viewFindViewById3 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_watts_layout_in);
        int i3 = i2;
        View viewFindViewById4 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_level_layout_in);
        View viewFindViewById5 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_mets_layout_in);
        View viewFindViewById6 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_goals_line_in);
        View viewFindViewById7 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_watts_line_in);
        View viewFindViewById8 = this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_level_line_in);
        TypefaceTextView typefaceTextView = (TypefaceTextView) this.include_calendar_details_outdoor.findViewById(R.id.calendar_details_avg_rpm_title_textview_in);
        if (dCTrainingData.getIn_out().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            String str6 = scaleToString4 + StringUtils.SPACE + this.res.getString(R.string.unit_kmph);
            String string3 = this.res.getString(R.string.pace_unit_min_km);
            this.calendar_details_distance_textview2.setText(scaleToString3 + StringUtils.SPACE + this.res.getString(R.string.unit_km));
            this.calendar_details_time_textview2.setText(str3 + CertificateUtil.DELIMITER + str4 + CertificateUtil.DELIMITER + str5 + "    " + string);
            TypefaceTextView typefaceTextView2 = this.calendar_details_calories_textview2;
            StringBuilder sb = new StringBuilder();
            sb.append(strValueOf);
            sb.append("  ");
            sb.append(this.res.getString(R.string.calorie_unit));
            typefaceTextView2.setText(sb.toString());
            this.calendar_details_pace_textview2.setText(total_time2 + "  " + string3);
            this.calendar_details_speed_textview2.setText(str6);
        } else {
            int i4 = R.string.unit_km;
            if (dCTrainingData.getIn_out().equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                viewFindViewById.setVisibility(4);
                viewFindViewById2.setVisibility(4);
                viewFindViewById3.setVisibility(4);
                viewFindViewById4.setVisibility(4);
                viewFindViewById5.setVisibility(4);
                viewFindViewById6.setVisibility(4);
                viewFindViewById7.setVisibility(4);
                viewFindViewById8.setVisibility(4);
                typefaceTextView.setText(getResources().getString(R.string.avg_pace_chart) + CertificateUtil.DELIMITER);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(scaleToString3);
                sb2.append(StringUtils.SPACE);
                Resources resources = this.res;
                if (i3 != 0) {
                    i4 = R.string.unit_mi;
                }
                sb2.append(resources.getString(i4));
                String string4 = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(scaleToString4);
                sb3.append(StringUtils.SPACE);
                sb3.append(this.res.getString(i3 == 0 ? R.string.unit_kmph : R.string.unit_mph));
                String string5 = sb3.toString();
                this.calendar_details_time_textview2_in.setText(str3 + CertificateUtil.DELIMITER + str4 + "   " + string2);
                this.calendar_details_distance_textview2_in.setText(string4);
                this.calendar_details_calories_textview2_in.setText(strValueOf);
                this.calendar_details_avg_hr_textview2_in.setText(dCTrainingData.getAvg_hr() + StringUtils.SPACE + this.res.getString(R.string.unit_bpm));
                this.calendar_details_avg_speed_textview2_in.setText(string5);
                this.calendar_details_avg_rpm_textview2_in.setText(String.valueOf(dCTrainingData.getAvg_incline()));
            } else {
                str = str5;
                str2 = scaleToString3;
                viewFindViewById.setVisibility(0);
                viewFindViewById2.setVisibility(0);
                viewFindViewById3.setVisibility(0);
                viewFindViewById4.setVisibility(0);
                viewFindViewById5.setVisibility(0);
                viewFindViewById6.setVisibility(0);
                viewFindViewById7.setVisibility(0);
                viewFindViewById8.setVisibility(0);
                typefaceTextView.setText(R.string.avg_rpm_colon);
                i = i3;
                if (i == 1) {
                    scaleToString2 = Global.getScaleToString(dCTrainingData.getTotal_distance() * 0.62f, 1);
                    scaleToString = Global.getScaleToString(dCTrainingData.getAvg_speed() * 0.62f, 1);
                } else {
                    scaleToString = scaleToString4;
                    scaleToString2 = str2;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(scaleToString2);
                sb4.append(StringUtils.SPACE);
                sb4.append(this.res.getString(i == 0 ? R.string.unit_km : R.string.unit_mi));
                String string6 = sb4.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(scaleToString);
                sb5.append(StringUtils.SPACE);
                sb5.append(this.res.getString(i == 0 ? R.string.unit_kmph : R.string.unit_mph));
                String string7 = sb5.toString();
                this.calendar_details_time_textview2_in.setText(str3 + CertificateUtil.DELIMITER + str4 + "   " + string2);
                this.calendar_details_distance_textview2_in.setText(string6);
                this.calendar_details_calories_textview2_in.setText(strValueOf);
                this.calendar_details_goals_textview2_in.setText(dCTrainingData.getGoals());
                this.calendar_details_notes_textview2_in.setText(dCTrainingData.getNotes());
                this.calendar_details_avg_hr_textview2_in.setText(dCTrainingData.getAvg_hr() + StringUtils.SPACE + this.res.getString(R.string.unit_bpm));
                this.calendar_details_avg_speed_textview2_in.setText(string7);
                this.calendar_details_avg_rpm_textview2_in.setText(String.valueOf(dCTrainingData.getAvg_rpm()));
                this.calendar_details_avg_watts_textview2_in.setText(String.valueOf(dCTrainingData.getAvg_watt()));
                this.calendar_details_avg_level_textview2_in.setText(String.valueOf(dCTrainingData.getAvg_level()));
                this.calendar_details_avg_mets_textview2_in.setText(String.format("%.2f", Float.valueOf(dCTrainingData.getAvg_met())));
                if (dCTrainingData.getIn_out().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                    DbManager.getInstance(this.activity);
                    List<DCTrainingDetailData> list4 = DbManager.getDCTrainingDetailDataDao().queryBuilder().where(DCTrainingDetailDataDao.Properties.TrainingId.eq(dCTrainingData.getTrainingId()), new WhereCondition[0]).list();
                    ArrayList arrayList = new ArrayList();
                    for (DCTrainingDetailData dCTrainingDetailData : list4) {
                        if (dCTrainingDetailData.getDevice_gps_lat() != 0.0f && dCTrainingDetailData.getDevice_gps_lng() != 0.0f) {
                            arrayList.add(new double[]{dCTrainingDetailData.getDevice_gps_lat(), dCTrainingDetailData.getDevice_gps_lng()});
                        }
                    }
                    trackToMe(arrayList);
                }
                this.shareRecording = "";
                this.shareRecording = str2 + HelpFormatter.DEFAULT_OPT_PREFIX + str3 + CertificateUtil.DELIMITER + str4 + CertificateUtil.DELIMITER + str;
                this.shareProgram = dCTrainingData.getProgram_name();
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT);
                this.trackCalories = String.valueOf(dCTrainingData.getTotal_calories());
                this.trackStartDate = simpleDateFormat2.format(dCTrainingData.getTraining_datetime());
                this.trackDuration = String.valueOf((int) dCTrainingData.getTotal_time());
                this.shareModel = dCTrainingData.getModel_code();
                this.shareCategory = dCTrainingData.getCategory_code();
                if (i != 1) {
                    this.trackDistance = String.valueOf(dCTrainingData.getTotal_distance() * 1.6f);
                    this.trackSpeed = String.valueOf(dCTrainingData.getAvg_speed() * 1.6f);
                } else {
                    this.trackDistance = String.valueOf(dCTrainingData.getTotal_distance());
                    this.trackSpeed = String.valueOf(dCTrainingData.getAvg_speed());
                }
                this.trackHeartRate = String.valueOf(dCTrainingData.getAvg_hr());
            }
        }
        str = str5;
        str2 = scaleToString3;
        i = i3;
        if (dCTrainingData.getIn_out().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
        }
        this.shareRecording = "";
        this.shareRecording = str2 + HelpFormatter.DEFAULT_OPT_PREFIX + str3 + CertificateUtil.DELIMITER + str4 + CertificateUtil.DELIMITER + str;
        this.shareProgram = dCTrainingData.getProgram_name();
        SimpleDateFormat simpleDateFormat22 = new SimpleDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT);
        this.trackCalories = String.valueOf(dCTrainingData.getTotal_calories());
        this.trackStartDate = simpleDateFormat22.format(dCTrainingData.getTraining_datetime());
        this.trackDuration = String.valueOf((int) dCTrainingData.getTotal_time());
        this.shareModel = dCTrainingData.getModel_code();
        this.shareCategory = dCTrainingData.getCategory_code();
        if (i != 1) {
        }
        this.trackHeartRate = String.valueOf(dCTrainingData.getAvg_hr());
    }

    private String getProgramNameOutdoor(String str) {
        try {
            return getResources().getString(DeviceModelList.programTexts.get(str).intValue());
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void emptyDetailFieldValue() {
        this.calendar_details_time_textview2.setText(StringUtils.SPACE);
        this.calendar_details_distance_textview2.setText(StringUtils.SPACE);
        this.calendar_details_calories_textview2.setText(StringUtils.SPACE);
        this.calendar_details_pace_textview2.setText(StringUtils.SPACE);
        this.calendar_details_speed_textview2.setText(StringUtils.SPACE);
        this.calendar_details_time_textview2_in.setText(StringUtils.SPACE);
        this.calendar_details_distance_textview2_in.setText(StringUtils.SPACE);
        this.calendar_details_calories_textview2_in.setText(StringUtils.SPACE);
        this.calendar_details_goals_textview2_in.setText(StringUtils.SPACE);
        this.calendar_details_notes_textview2_in.setText(StringUtils.SPACE);
        this.calendar_details_avg_hr_textview2_in.setText(StringUtils.SPACE);
        this.calendar_details_avg_speed_textview2_in.setText(StringUtils.SPACE);
        this.calendar_details_avg_rpm_textview2_in.setText(StringUtils.SPACE);
        this.calendar_details_avg_watts_textview2_in.setText(StringUtils.SPACE);
        this.calendar_details_avg_level_textview2_in.setText(StringUtils.SPACE);
        this.calendar_details_avg_mets_textview2_in.setText(StringUtils.SPACE);
    }

    private void countSumAvg(List<DCTrainingData> list, DCTrainingData dCTrainingData) {
        LinkedList linkedList = new LinkedList();
        String str = "";
        float total_distance = 0.0f;
        float total_calories = 0.0f;
        float avg_hr = 0.0f;
        float avg_speed = 0.0f;
        float avg_watt = 0.0f;
        float avg_level = 0.0f;
        float avg_rpm = 0.0f;
        int i = 0;
        String str2 = "";
        float total_time = 0.0f;
        for (DCTrainingData dCTrainingData2 : list) {
            total_time += dCTrainingData2.getTotal_time();
            total_distance += dCTrainingData2.getTotal_distance();
            total_calories += dCTrainingData2.getTotal_calories();
            avg_hr += dCTrainingData2.getAvg_hr();
            avg_speed += dCTrainingData2.getAvg_speed();
            avg_watt += dCTrainingData2.getAvg_watt();
            avg_level += dCTrainingData2.getAvg_level();
            avg_rpm += dCTrainingData2.getAvg_rpm();
            linkedList.addAll(JsonUtil.parseSportPath(dCTrainingData2.getSportPathJsonStr()));
            String in_out = dCTrainingData2.getIn_out();
            String program_name = dCTrainingData2.getProgram_name();
            dCTrainingData.setUnit(dCTrainingData2.getUnit());
            i++;
            str = in_out;
            str2 = program_name;
        }
        dCTrainingData.setTotal_time(total_time);
        dCTrainingData.setTotal_distance(total_distance);
        dCTrainingData.setTotal_calories(total_calories);
        float f = i;
        dCTrainingData.setAvg_hr(avg_hr / f);
        dCTrainingData.setAvg_speed(avg_speed / f);
        dCTrainingData.setAvg_watt(avg_watt / f);
        dCTrainingData.setAvg_level(avg_level / f);
        dCTrainingData.setAvg_rpm(avg_rpm / f);
        dCTrainingData.setIn_out(str);
        dCTrainingData.setProgram_name(str2);
        dCTrainingData.setSportPathJsonStr(JsonUtil.toJsonSportPath(linkedList));
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setCompassEnabled(true);
        this.mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(0.0d, 0.0d)));
        this.mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
        if (ActivityCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.mMap.setMyLocationEnabled(true);
            this.mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() { // from class: com.dyaco.sole.fragment.calendar.CalendarMainFragment.11
                @Override // com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener
                public void onMyLocationChange(Location location) {
                }
            });
        } else {
            Toast.makeText(this.activity, "no get loctation.", 0).show();
        }
    }

    public void trackToMe(List<double[]> list) {
        if (this.mMap == null) {
            return;
        }
        if (list == null || list.size() < 2) {
            this.mMap.clear();
            return;
        }
        this.mMap.clear();
        this.mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(0.0d, 0.0d)));
        this.mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(list.get(list.size() - 1)[0], list.get(list.size() - 1)[1])));
        PolylineOptions polylineOptions = new PolylineOptions();
        for (double[] dArr : list) {
            polylineOptions.add(new LatLng(dArr[0], dArr[1]));
        }
        polylineOptions.color(SupportMenu.CATEGORY_MASK);
        this.mMap.addPolyline(polylineOptions).setWidth(10.0f);
        double[] dArr2 = list.get(0);
        this.mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(dArr2[0], dArr2[1])));
        this.mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
    }
}
