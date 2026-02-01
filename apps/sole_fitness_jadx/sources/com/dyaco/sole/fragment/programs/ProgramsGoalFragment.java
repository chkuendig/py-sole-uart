package com.dyaco.sole.fragment.programs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.DCProgramGoalData;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.ResponseDataCollection;
import com.digifly.cloudapi.data.ResponseMessage;
import com.digifly.cloudapi.listener.DCGoalDeltetListener;
import com.digifly.cloudapi.listener.DCGoalUploadUpdateListener;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCProgramGoalDataDao;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.dyaco.sole.MyApp;
import com.dyaco.sole.R2;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.fragment.BaseFragment;
import com.dyaco.sole.fragment.programs.ProgramGoalData;
import com.facebook.internal.security.CertificateUtil;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.joda.time.DateTime;

/* loaded from: classes.dex */
public class ProgramsGoalFragment extends BaseFragment {
    public static final String TAG = "ProgramGoal";
    public static DateTime alarmDateTime;
    public static TextView txtGoalAlert;
    private MainActivity activity;
    private View btnNewGoal;
    private CloudApi cloudApi;
    private FrameLayout content_layout;
    private List<ProgramGoalData> data;
    private DbManager dbManager;
    private DCProgramGoalDataDao dbProgramGoalDataDao;
    private CalendarUtils detailsCalendarUtils;
    private HorizontalAdapter horizontalAdapter;
    private LinearLayoutManager horizontalLayoutManager;
    private RecyclerView horizontal_recycler_view;
    private View imgBtnLeft;
    private View imgBtnRight;
    private View include_calendar_goal;
    private Resources res;
    private View rootView;
    private View txtGoal;
    private int scrollItemLengthDP = R2.attr.layout_constraintTop_toTopOf;
    private int scrollItemLengthPixel = R2.attr.layout_constraintTop_toTopOf;
    private DateTime lastUpdateTime = null;
    private int diffSec = 6;
    private boolean debug = false;
    private View.OnClickListener onClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.imgBtnLeft /* 2131231298 */:
                    ProgramsGoalFragment.this.horizontal_recycler_view.scrollBy(ProgramsGoalFragment.this.scrollItemLengthPixel * (-1), 0);
                    break;
                case R.id.imgBtnRight /* 2131231299 */:
                    ProgramsGoalFragment.this.horizontal_recycler_view.scrollBy(ProgramsGoalFragment.this.scrollItemLengthPixel, 0);
                    break;
                case R.id.program_goal_new_textview /* 2131231498 */:
                    ProgramsGoalAddEditFragment.currentItemID = 0L;
                    ProgramsGoalAddEditFragment.currentGoalItem = null;
                    ProgramsGoalAddEditFragment.isEditing = false;
                    ProgramsGoalFragment.this.activity.switchFragment(9);
                    break;
                case R.id.txtGoal /* 2131231800 */:
                    if (ProgramsGoalFragment.this.debug) {
                        ProgramsGoalFragment.this.activity.switchFragment(10);
                        break;
                    }
                    break;
            }
        }
    };

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MainActivity mainActivity = (MainActivity) getActivity();
        this.activity = mainActivity;
        DbManager.getInstance(mainActivity);
        this.scrollItemLengthPixel = (int) convertDpToPixel(this.scrollItemLengthDP);
        initGoalView();
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) throws Resources.NotFoundException {
        super.onHiddenChanged(z);
        Log.v(TAG, "onHiddenChanged() hidden : " + z);
        if (z) {
            return;
        }
        populateData();
        ProgramsGoalAddEditFragment.isEditing = false;
        if (MyApp.alertSchedule != null) {
            txtGoalAlert.setText(getResources().getString(R.string.goal_alert_title_alert_time).concat(MyApp.alertSchedule.getAlertLocalTime().toString("a hh:mm")));
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.v(TAG, "onCreateView");
        this.activity = (MainActivity) getActivity();
        int i = Global.BRAND;
        if (i == 0) {
            this.rootView = layoutInflater.inflate(R.layout.fragment_programs_goal, viewGroup, false);
        } else if (i == 1 || i == 2 || i == 3) {
            this.rootView = layoutInflater.inflate(R.layout.s_fragment_programs_goal, viewGroup, false);
        }
        findViews();
        initParams();
        setListeners();
        this.horizontal_recycler_view = (RecyclerView) this.rootView.findViewById(R.id.horizontal_recycler_view);
        populateData();
        this.lastUpdateTime = null;
        return this.rootView;
    }

    private void populateData() {
        Log.v(TAG, "populateData()");
        this.data = getDCProgramGoalDataFromDB();
        List<DCProgramGoalData> list = this.dbProgramGoalDataDao.queryBuilder().where(DCProgramGoalDataDao.Properties.Goal_end_date.gt(new DateTime().minusDays(30).toDate()), new WhereCondition[0]).orderDesc(DCProgramGoalDataDao.Properties.GoalId).list();
        Logger.d("programGoalDatas = " + list);
        uploadGoalDataToCloud(list);
        List<ProgramGoalData> list2 = this.data;
        if (list2 != null && list2.size() > 0) {
            Log.v(TAG, "populateData() data.size() : " + this.data.size() + "");
            if (this.data.size() < 4) {
                this.imgBtnLeft.setVisibility(4);
                this.imgBtnRight.setVisibility(4);
            } else {
                this.imgBtnLeft.setVisibility(0);
                this.imgBtnRight.setVisibility(0);
            }
            this.horizontal_recycler_view.setVisibility(0);
            this.horizontalAdapter = new HorizontalAdapter(this.data, this.activity.getApplication());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.activity, 0, false);
            this.horizontalLayoutManager = linearLayoutManager;
            this.horizontal_recycler_view.setLayoutManager(linearLayoutManager);
            this.horizontal_recycler_view.setAdapter(this.horizontalAdapter);
            return;
        }
        Log.v(TAG, "populateData() data == null");
        this.horizontal_recycler_view.setVisibility(4);
        this.imgBtnLeft.setVisibility(4);
        this.imgBtnRight.setVisibility(4);
    }

    private void uploadGoalDataToCloud(List<DCProgramGoalData> list) {
        for (DCProgramGoalData dCProgramGoalData : list) {
            CloudApi cloudApiCreateInstance = CloudApi.createInstance(this.activity);
            cloudApiCreateInstance.setGoalUploadUpdateListener(new DCGoalUploadUpdateListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalFragment.2
                @Override // com.digifly.cloudapi.listener.DCGoalUploadUpdateListener
                public void onSuccess(ResponseDataCollection responseDataCollection) {
                    Logger.d("responseDataCollection = " + responseDataCollection);
                }

                @Override // com.digifly.cloudapi.listener.DCGoalUploadUpdateListener
                public void onFail(ResponseDataCollection responseDataCollection) {
                    Logger.d("responseDataCollection = " + responseDataCollection);
                }

                @Override // com.digifly.cloudapi.listener.DCGoalUploadUpdateListener
                public void onError(String str) {
                    Logger.d("err = " + str);
                }
            });
            cloudApiCreateInstance.callGoalUploadUpdate(dCProgramGoalData, Global.memberData.getPassword());
        }
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void findViews() {
        this.cloudApi = CloudApi.getInstance(this.activity);
        this.dbManager = DbManager.getInstance(this.activity);
        this.dbProgramGoalDataDao = DbManager.getDCProgramGoalDataDao();
        this.imgBtnLeft = this.rootView.findViewById(R.id.imgBtnLeft);
        this.imgBtnRight = this.rootView.findViewById(R.id.imgBtnRight);
        this.btnNewGoal = this.rootView.findViewById(R.id.program_goal_new_textview);
        this.txtGoal = this.rootView.findViewById(R.id.txtGoal);
        txtGoalAlert = (TextView) this.rootView.findViewById(R.id.txtGoalAlert);
    }

    private void initGoalView() {
        int i = Global.BRAND;
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void initParams() {
        int i = Global.BRAND;
        this.res = getResources();
        this.detailsCalendarUtils = new CalendarUtils();
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void setListeners() {
        this.imgBtnLeft.setOnClickListener(this.onClick);
        this.imgBtnRight.setOnClickListener(this.onClick);
        this.btnNewGoal.setOnClickListener(this.onClick);
        this.txtGoal.setOnClickListener(this.onClick);
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws IOException {
        super.onActivityResult(i, i2, intent);
        if (i == 99 && i2 == -1) {
            int i3 = Global.BRAND;
            if (i3 == 0) {
                this.activity.switchFragment(3);
                return;
            }
            if (i3 == 1) {
                this.activity.switchFragment(3);
                return;
            }
            if (i3 == 2 || i3 == 3) {
                if (ProtocolHandler.protocol.salesVersion == 1) {
                    this.activity.startWorkout();
                    this.activity.switchFragment(5);
                } else {
                    this.activity.switchFragment(3);
                }
            }
        }
    }

    public List<ProgramGoalData> fill_with_sample_data() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ProgramGoalData(ProgramGoalData.GoalStateType.Processing, 88, "Target Name 1", 2, 3, 88, 126, ProgramGoalData.GoalPeriodType.Week, ProgramGoalData.GoalType.Calorie, new Date(), new Date()));
        arrayList.add(new ProgramGoalData(ProgramGoalData.GoalStateType.Miss, 40, "Target Name 2", 3, 5, 43, 77, ProgramGoalData.GoalPeriodType.Day, ProgramGoalData.GoalType.Time, new Date(), new Date()));
        arrayList.add(new ProgramGoalData(ProgramGoalData.GoalStateType.Done, 100, "Target Name 3", 1, 3, 12, 126, ProgramGoalData.GoalPeriodType.Month, ProgramGoalData.GoalType.Distance, new Date(), new Date()));
        arrayList.add(new ProgramGoalData(ProgramGoalData.GoalStateType.Processing, 88, "Target Name 4", 2, 3, 88, 126, ProgramGoalData.GoalPeriodType.Week, ProgramGoalData.GoalType.Calorie, new Date(), new Date()));
        arrayList.add(new ProgramGoalData(ProgramGoalData.GoalStateType.Miss, 40, "Target Name 5", 3, 5, 43, 77, ProgramGoalData.GoalPeriodType.Day, ProgramGoalData.GoalType.Time, new Date(), new Date()));
        arrayList.add(new ProgramGoalData(ProgramGoalData.GoalStateType.Done, 100, "Target Name 6", 1, 3, 12, 126, ProgramGoalData.GoalPeriodType.Month, ProgramGoalData.GoalType.Distance, new Date(), new Date()));
        arrayList.add(new ProgramGoalData(ProgramGoalData.GoalStateType.Processing, 88, "Target Name 7", 2, 3, 88, 126, ProgramGoalData.GoalPeriodType.Week, ProgramGoalData.GoalType.Calorie, new Date(), new Date()));
        arrayList.add(new ProgramGoalData(ProgramGoalData.GoalStateType.Miss, 40, "Target Name 8", 3, 5, 43, 77, ProgramGoalData.GoalPeriodType.Day, ProgramGoalData.GoalType.Time, new Date(), new Date()));
        arrayList.add(new ProgramGoalData(ProgramGoalData.GoalStateType.Done, 100, "Target Name 9", 1, 3, 12, 126, ProgramGoalData.GoalPeriodType.Month, ProgramGoalData.GoalType.Distance, new Date(), new Date()));
        return arrayList;
    }

    private float convertPixelsToDp(float f) {
        return Math.round(f / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0f));
    }

    private float convertDpToPixel(float f) {
        return Math.round(f * (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0f));
    }

    private int convertDpToPx(int i) {
        return Math.round(i * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    private int convertPxToDp(int i) {
        return Math.round(i / (Resources.getSystem().getDisplayMetrics().xdpi / 160.0f));
    }

    private List<ProgramGoalData> getDCProgramGoalDataFromDB() {
        Log.v(TAG, "getDCProgramGoalDataFromDB() ");
        updateDCProgramGoalDataFromDB();
        ArrayList arrayList = null;
        try {
            int i = 0;
            List<DCProgramGoalData> list = this.dbProgramGoalDataDao.queryBuilder().where(DCProgramGoalDataDao.Properties.Goal_name.notEq(""), new WhereCondition[0]).orderDesc(DCProgramGoalDataDao.Properties.GoalId).list();
            Log.v(TAG, "getDCProgramGoalDataFromDB() programGoalDatas = " + list);
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (DCProgramGoalData dCProgramGoalData : list) {
                    Log.v(TAG, "getDCProgramGoalDataFromDB() idx : " + i + " programGoalData.getGoal_state() : " + dCProgramGoalData.getGoal_state() + " programGoalData.getGoal_percent() : " + dCProgramGoalData.getGoal_percent());
                    ProgramGoalData programGoalData = new ProgramGoalData();
                    programGoalData.goal_id = dCProgramGoalData.getGoalId();
                    programGoalData.goal_val = dCProgramGoalData.getGoal_val();
                    programGoalData.goal_val_now = dCProgramGoalData.getGoal_val_now();
                    programGoalData.goal_pos_in_duration = dCProgramGoalData.getGoal_pos_in_duration();
                    int goal_state = dCProgramGoalData.getGoal_state();
                    if (goal_state == 0) {
                        programGoalData.goal_state = ProgramGoalData.GoalStateType.Processing;
                    } else if (goal_state == 1) {
                        programGoalData.goal_state = ProgramGoalData.GoalStateType.Done;
                    } else if (goal_state == 2) {
                        programGoalData.goal_state = ProgramGoalData.GoalStateType.Miss;
                    }
                    programGoalData.goal_percent = dCProgramGoalData.getGoal_percent();
                    programGoalData.goal_duration = dCProgramGoalData.getGoal_duration();
                    programGoalData.goal_end_date = dCProgramGoalData.getGoal_end_date();
                    int goal_period_type = dCProgramGoalData.getGoal_period_type();
                    if (goal_period_type == 0) {
                        programGoalData.goal_period_type = ProgramGoalData.GoalPeriodType.Day;
                    } else if (goal_period_type == 1) {
                        programGoalData.goal_period_type = ProgramGoalData.GoalPeriodType.Week;
                    } else if (goal_period_type == 2) {
                        programGoalData.goal_period_type = ProgramGoalData.GoalPeriodType.Month;
                    }
                    programGoalData.goal_name = dCProgramGoalData.getGoal_name();
                    programGoalData.goal_start_date = dCProgramGoalData.getGoal_start_date();
                    int goal_type = dCProgramGoalData.getGoal_type();
                    if (goal_type == 0) {
                        programGoalData.goal_type = ProgramGoalData.GoalType.Time;
                    } else if (goal_type == 1) {
                        programGoalData.goal_type = ProgramGoalData.GoalType.Distance;
                    } else if (goal_type == 2) {
                        programGoalData.goal_type = ProgramGoalData.GoalType.Calorie;
                    }
                    Log.v(TAG, "getDCProgramGoalDataFromDB() idx : " + i + " d.goal_state : " + programGoalData.goal_state + " d.goal_percent : " + programGoalData.goal_percent);
                    programGoalData.setGoalDataStr();
                    arrayList2.add(programGoalData);
                    i++;
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                arrayList = arrayList2;
                Log.v(TAG, "getDCProgramGoalDataFromDB() error : " + e.toString());
                return arrayList;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void updateDCProgramGoalDataFromDB() {
        Log.v(TAG, "updateDCProgramGoalDataFromDB() ");
        if (this.lastUpdateTime == null) {
            this.lastUpdateTime = new DateTime();
        } else {
            DateTime dateTime = new DateTime();
            Log.v(TAG, "updateDCProgramGoalDataFromDB() nextUpdateTime :" + this.lastUpdateTime.plusSeconds(this.diffSec).getMillis());
            Log.v(TAG, "updateDCProgramGoalDataFromDB() currentTime " + dateTime.getMillis());
            if (!this.debug && this.lastUpdateTime.plusSeconds(this.diffSec).getMillis() > dateTime.getMillis()) {
                Log.v(TAG, "updateDCProgramGoalDataFromDB() nextUpdateTime < currentTime ");
                return;
            }
            this.lastUpdateTime = new DateTime();
        }
        try {
            int i = 0;
            List<DCProgramGoalData> list = this.dbProgramGoalDataDao.queryBuilder().where(DCProgramGoalDataDao.Properties.Goal_state.le(Integer.valueOf(this.debug ? 3 : 1)), new WhereCondition[0]).orderDesc(DCProgramGoalDataDao.Properties.GoalId).list();
            Log.v(TAG, "updateDCProgramGoalDataFromDB() programGoalDatas = " + list);
            if (list == null || list.size() <= 0) {
                return;
            }
            for (DCProgramGoalData dCProgramGoalData : list) {
                Log.v(TAG, "updateDCProgramGoalDataFromDB() idx : " + i + " programGoalData.getGoal_state() : " + dCProgramGoalData.getGoal_state());
                processingUpdateGoalData(dCProgramGoalData);
                i++;
            }
        } catch (Exception e) {
            Log.v(TAG, "updateDCProgramGoalDataFromDB() error : " + e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean delDCProgramGoalDataFromDB(Long l) throws SQLException {
        Log.v(TAG, "delDCProgramGoalDataFromDB() goalId : " + l);
        this.dbProgramGoalDataDao.queryBuilder().where(DCProgramGoalDataDao.Properties.GoalId.eq(l), new WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
        populateData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteGoalAlert(String str, final Long l) {
        new AlertDialog.Builder(this.activity).setTitle(Global.ALERT_TITLE_RID).setMessage(getString(R.string.goal_sure_del)).setPositiveButton(R.string.no, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) throws SQLException {
                List<DCProgramGoalData> list = ProgramsGoalFragment.this.dbProgramGoalDataDao.queryBuilder().where(DCProgramGoalDataDao.Properties.GoalId.eq(l), new WhereCondition[0]).list();
                if (list == null || list.size() <= 0) {
                    return;
                }
                String goal_no = list.get(0).getGoal_no();
                ProgramsGoalFragment.this.delDCProgramGoalDataFromDB(l);
                ProgramsGoalFragment.this.cloudApi.setGoalDeleteListener(new DCGoalDeltetListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalFragment.3.1
                    @Override // com.digifly.cloudapi.listener.DCGoalDeltetListener
                    public void onSuccess(ResponseMessage responseMessage) {
                        Logger.d("responseMessage = " + responseMessage);
                    }

                    @Override // com.digifly.cloudapi.listener.DCGoalDeltetListener
                    public void onFail(ResponseMessage responseMessage) {
                        Logger.d("responseMessage = " + responseMessage);
                    }

                    @Override // com.digifly.cloudapi.listener.DCGoalDeltetListener
                    public void onError(String str2) {
                        Logger.d("err = " + str2);
                    }
                });
                ProgramsGoalFragment.this.cloudApi.callGoalDelete(Global.memberData.getAccount(), Global.memberData.getPassword(), goal_no);
            }
        }).create().show();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x04ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void processingUpdateGoalData(DCProgramGoalData dCProgramGoalData) {
        int i;
        int goal_duration;
        Logger.d("processingUpdateGoalData222 = ");
        if (dCProgramGoalData.getGoal_state() != 0) {
            return;
        }
        Log.d(TAG, "processingUpdateGoalData() dt.getGoalId() : " + dCProgramGoalData.getGoalId());
        Log.d(TAG, "processingUpdateGoalData() duration() : " + dCProgramGoalData.getGoal_duration());
        Log.d(TAG, "processingUpdateGoalData() period_type() : " + dCProgramGoalData.getGoal_period_type());
        Log.d(TAG, "processingUpdateGoalData() start_date() : " + dCProgramGoalData.getGoal_start_date());
        Log.d(TAG, "processingUpdateGoalData() end_date() : " + dCProgramGoalData.getGoal_end_date());
        DateTime dateTime = new DateTime();
        DateTime dateTime2 = new DateTime(dCProgramGoalData.getGoal_start_date());
        DateTime dateTime3 = new DateTime(dCProgramGoalData.getGoal_end_date());
        int goal_period_type = dCProgramGoalData.getGoal_period_type();
        if (goal_period_type == 0) {
            dateTime3 = dateTime2.plusDays(dCProgramGoalData.getGoal_duration());
        } else if (goal_period_type == 1) {
            dateTime3 = dateTime2.plusWeeks(dCProgramGoalData.getGoal_duration());
        } else if (goal_period_type == 2) {
            dateTime3 = dateTime2.plusMonths(dCProgramGoalData.getGoal_duration());
        }
        Log.v(TAG, "processingUpdateGoalData() startDate : " + dateTime2);
        Log.v(TAG, "processingUpdateGoalData() endDate : " + dateTime3);
        dCProgramGoalData.setGoal_end_date(dateTime3.toDate());
        DateTime dateTime4 = new DateTime(dCProgramGoalData.getGoal_start_date().getTime());
        DateTime dateTime5 = new DateTime(dCProgramGoalData.getGoal_end_date().getTime());
        Log.d(TAG, "processingUpdateGoalData() sd : " + dateTime4);
        Log.d(TAG, "processingUpdateGoalData() ed : " + dateTime5);
        QueryBuilder.LOG_SQL = true;
        QueryBuilder<DCTrainingData> queryBuilder = DbManager.getDCTrainingDataDao().queryBuilder();
        queryBuilder.where(DCTrainingDataDao.Properties.Account.eq(Global.calendarUserName), DCTrainingDataDao.Properties.Training_datetime.between(dateTime4.toDate(), dateTime5.toDate()));
        List<DCTrainingData> list = queryBuilder.list();
        QueryBuilder.LOG_SQL = false;
        Log.d(TAG, "processingUpdateGoalData() Global.calendarUserName " + Global.calendarUserName + " datas.size() = " + list.size());
        DCTrainingData dCTrainingData = new DCTrainingData();
        if (list != null && list.size() > 0) {
            countSumAvg(list, dCTrainingData);
        }
        Log.d(TAG, "processingUpdateGoalData() = " + dCTrainingData);
        long total_time = (long) dCTrainingData.getTotal_time();
        String strValueOf = String.valueOf(total_time / 3600);
        String strValueOf2 = String.valueOf((total_time / 60) % 60);
        String strValueOf3 = String.valueOf(total_time % 60);
        String strValueOf4 = String.valueOf(dCTrainingData.getTotal_calories());
        String scaleToString = Global.getScaleToString(dCTrainingData.getTotal_distance(), 1);
        String str = scaleToString + StringUtils.SPACE + this.res.getString(R.string.unit_km);
        String scaleToString2 = Global.getScaleToString(dCTrainingData.getAvg_speed(), 1);
        String str2 = scaleToString2 + StringUtils.SPACE + this.res.getString(R.string.unit_km);
        Log.d(TAG, "processingUpdateGoalData() total_time : " + strValueOf + CertificateUtil.DELIMITER + strValueOf2 + CertificateUtil.DELIMITER + strValueOf3 + " sec : " + total_time);
        StringBuilder sb = new StringBuilder();
        sb.append("processingUpdateGoalData() calories : ");
        sb.append(strValueOf4);
        Log.d(TAG, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("processingUpdateGoalData() distance : ");
        sb2.append(scaleToString);
        Log.d(TAG, sb2.toString());
        Log.d(TAG, "processingUpdateGoalData() distanceAndUnit : " + str);
        Log.d(TAG, "processingUpdateGoalData() speed : " + scaleToString2);
        Log.d(TAG, "processingUpdateGoalData() speedAndUnit : " + str2);
        int goal_val = dCProgramGoalData.getGoal_val();
        dCProgramGoalData.getGoal_val_now();
        dCProgramGoalData.getGoal_state();
        float total_distance = 0.0f;
        float time = ((dCProgramGoalData.getGoal_end_date().getTime() - dCProgramGoalData.getGoal_start_date().getTime()) / 1000) / 86400;
        float millis = ((dateTime.getMillis() - dCProgramGoalData.getGoal_start_date().getTime()) / 1000.0f) / 86400.0f;
        Log.d(TAG, "processingUpdateGoalData() dt.getGoal_type() : " + dCProgramGoalData.getGoal_type());
        Log.d(TAG, "processingUpdateGoalData() elapse_days : " + millis + " duration_days : " + time);
        int goal_type = dCProgramGoalData.getGoal_type();
        if (goal_type == 0) {
            goal_val = (int) (goal_val * time);
            float total_time2 = dCTrainingData.getTotal_time() / 60.0f;
            float total_time3 = (dCTrainingData.getTotal_time() / 60.0f) / time;
            int i2 = (int) (((total_time2 / time) / goal_val) * 100.0f);
            Log.d(TAG, "processingUpdateGoalData() Time : goalVal : " + goal_val);
            Log.d(TAG, "processingUpdateGoalData() Time : currentVal : " + total_time3);
            Log.d(TAG, "processingUpdateGoalData() Time : percentVal : " + i2);
            i = i2;
            total_distance = total_time3;
        } else if (goal_type == 1) {
            total_distance = dCTrainingData.getTotal_distance();
            i = (int) ((total_distance / goal_val) * 100.0f);
            Log.d(TAG, "processingUpdateGoalData() Distance : goalVal : " + goal_val);
            Log.d(TAG, "processingUpdateGoalData() Distance : currentVal : " + total_distance);
            Log.d(TAG, "processingUpdateGoalData() Distance : percentVal : " + i);
        } else if (goal_type != 2) {
            i = 0;
        } else {
            total_distance = dCTrainingData.getTotal_calories() / 1000.0f;
            i = (int) ((total_distance / goal_val) * 100.0f);
            Log.d(TAG, "processingUpdateGoalData() Calorie : goalVal : " + goal_val);
            Log.d(TAG, "processingUpdateGoalData() Calorie : currentVal : " + total_distance);
            Log.d(TAG, "processingUpdateGoalData() Calorie : percentVal : " + i);
        }
        Log.d(TAG, "processingUpdateGoalData()   dt.getGoal_percent() : " + dCProgramGoalData.getGoal_percent());
        if (i > 100) {
            Log.d(TAG, "processingUpdateGoalData()   (percentVal >= dt.getGoal_percent())  dt.setGoal_percent(100)");
            dCProgramGoalData.setGoal_percent(100);
        } else {
            Log.d(TAG, "processingUpdateGoalData()   (percentVal < dt.getGoal_percent())  dt.setGoal_percent(" + i + ")");
            dCProgramGoalData.setGoal_percent(i);
        }
        dCProgramGoalData.setGoal_val_now(total_distance);
        int goal_state = dCProgramGoalData.getGoal_state();
        Log.d(TAG, "processingUpdateGoalData()  dt.getGoal_state(): " + dCProgramGoalData.getGoal_state());
        Log.d(TAG, "processingUpdateGoalData() cd.getMillis() : " + dateTime.getMillis());
        Log.d(TAG, "processingUpdateGoalData() ed.getMillis() : " + dateTime5.getMillis());
        Log.d(TAG, "processingUpdateGoalData() currentVal " + total_distance + " goalVal : " + goal_val);
        int goal_period_type2 = dCProgramGoalData.getGoal_period_type();
        if (goal_period_type2 != 0) {
            if (goal_period_type2 != 1) {
                if (goal_period_type2 == 2 && millis >= 1.0f) {
                    int i3 = ((int) millis) % 30;
                    goal_duration = ((int) (millis / 30.0f)) + 1;
                } else {
                    goal_duration = 1;
                }
            } else if (millis >= 1.0f) {
                goal_duration = ((int) (millis / 7.0f)) + 1;
                int i4 = ((int) millis) % 7;
            }
        } else if (millis >= 1.0f) {
            goal_duration = (int) millis;
        }
        if (dateTime.getMillis() > dateTime5.getMillis()) {
            Log.d(TAG, "processingUpdateGoalData() currentDate.getMillis() >  ed.getMillis() ");
            float f = goal_val;
            if (total_distance < f) {
                Log.d(TAG, "processingUpdateGoalData() (currentVal < goalVal) goal_state = 2");
                dCProgramGoalData.setGoal_state(2);
            } else if (total_distance >= f) {
                Log.d(TAG, "processingUpdateGoalData() (currentVal >= goalVal) goal_state = 1");
                dCProgramGoalData.setGoal_state(1);
            }
            if (goal_duration > dCProgramGoalData.getGoal_duration()) {
                goal_duration = dCProgramGoalData.getGoal_duration();
            }
            dCProgramGoalData.setGoal_pos_in_duration(dCProgramGoalData.getGoal_duration());
            Logger.d("new_pos_in_duration = " + goal_duration);
            Logger.d("elapse_days = " + millis);
            dCProgramGoalData.setElapsedays(millis);
        } else {
            Log.d(TAG, "processingUpdateGoalData() currentDate.getMillis() <=  ed.getMillis() ");
            dCProgramGoalData.setGoal_pos_in_duration(goal_duration);
            dCProgramGoalData.setElapsedays(millis);
            Logger.d("new_pos_in_duration = " + goal_duration);
            Logger.d("elapse_days = " + millis);
            float f2 = (float) goal_val;
            if (total_distance < f2) {
                Log.d(TAG, "processingUpdateGoalData() (currentVal < goalVal) goal_state = 0");
            } else if (total_distance >= f2) {
                Log.d(TAG, "processingUpdateGoalData() (currentVal >= goalVal) goal_state = 0");
            }
            dCProgramGoalData.setGoal_state(0);
        }
        Log.d(TAG, "processingUpdateGoalData() goal_state : " + goal_state + " dt.getGoal_state() " + dCProgramGoalData.getGoal_state());
        this.dbProgramGoalDataDao.update(dCProgramGoalData);
    }

    private void countSumAvg(List<DCTrainingData> list, DCTrainingData dCTrainingData) {
        float total_time = 0.0f;
        float total_calories = 0.0f;
        float avg_hr = 0.0f;
        float avg_speed = 0.0f;
        float avg_watt = 0.0f;
        float avg_level = 0.0f;
        float avg_rpm = 0.0f;
        int i = 0;
        float total_distance = 0.0f;
        for (DCTrainingData dCTrainingData2 : list) {
            total_time += dCTrainingData2.getTotal_time();
            total_distance += dCTrainingData2.getTotal_distance();
            total_calories += dCTrainingData2.getTotal_calories();
            avg_hr += dCTrainingData2.getAvg_hr();
            avg_speed += dCTrainingData2.getAvg_speed();
            avg_watt += dCTrainingData2.getAvg_watt();
            avg_level += dCTrainingData2.getAvg_level();
            avg_rpm += dCTrainingData2.getAvg_rpm();
            i++;
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
    }

    public class HorizontalAdapter extends RecyclerView.Adapter<MyViewHolder> {
        Context context;
        List<ProgramGoalData> horizontalList;

        public HorizontalAdapter(List<ProgramGoalData> list, Context context) {
            Collections.emptyList();
            this.horizontalList = list;
            this.context = context;
            ProgramGoalData.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.programs_goal_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder myViewHolder, int i) throws Resources.NotFoundException {
            final ProgramGoalData programGoalData = this.horizontalList.get(i);
            myViewHolder.imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalFragment.HorizontalAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ProgramsGoalFragment.this.showDeleteGoalAlert(programGoalData.goal_name, programGoalData.goal_id);
                }
            });
            myViewHolder.txt1TitleDate.setText(programGoalData.strGoalDate);
            myViewHolder.txt2Title.setText(programGoalData.strGoalTitle);
            myViewHolder.txt3Status.setText(programGoalData.strGoalStatus);
            myViewHolder.txt4Percent.setText(programGoalData.strGoalPercent);
            myViewHolder.txt6Type.setText(programGoalData.strGoalType);
            myViewHolder.txt7Duration.setText(programGoalData.strGoalPeriodType + StringUtils.SPACE + programGoalData.strGoalPosInDuration + "/" + programGoalData.strGoalDuration);
            myViewHolder.txt8Val.setText(programGoalData.strGoalValNow + "/" + programGoalData.strGoalVal + StringUtils.SPACE + programGoalData.strGoalUnit);
            ProgramsGoalFragment.this.getResources().getColor(R.color.colorGoalProcessing);
            int i2 = AnonymousClass4.$SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType[programGoalData.goal_state.ordinal()];
            if (i2 == 1) {
                int color = ProgramsGoalFragment.this.getResources().getColor(R.color.colorGoalProcessing);
                Log.i("onBindViewHolder", "onBindViewHolder()  dt.goal_state : Process ! txtColor : " + color);
                myViewHolder.txt3Status.setTextColor(color);
                myViewHolder.txt4Percent.setTextColor(color);
                myViewHolder.txt5PercentSign.setTextColor(color);
            } else if (i2 == 2) {
                int color2 = ProgramsGoalFragment.this.getResources().getColor(R.color.colorGoalDone);
                Log.i("onBindViewHolder", "onBindViewHolder()  dt.goal_state : Done ! txtColor : " + color2);
                myViewHolder.txt3Status.setTextColor(color2);
                myViewHolder.txt4Percent.setTextColor(color2);
                myViewHolder.txt5PercentSign.setTextColor(color2);
            } else if (i2 == 3) {
                int color3 = ProgramsGoalFragment.this.getResources().getColor(R.color.colorGoalMiss);
                Log.i("onBindViewHolder", "onBindViewHolder()  dt.goal_state : Miss ! txtColor : " + color3);
                myViewHolder.txt2Title.setTextColor(color3);
                myViewHolder.txt3Status.setTextColor(color3);
                myViewHolder.txt4Percent.setTextColor(color3);
                myViewHolder.txt5PercentSign.setTextColor(color3);
                myViewHolder.txt6Type.setTextColor(color3);
                myViewHolder.txt7Duration.setTextColor(color3);
                myViewHolder.txt8Val.setTextColor(color3);
            }
            myViewHolder.cntr.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalFragment.HorizontalAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ProgramsGoalAddEditFragment.currentItemID = programGoalData.goal_id;
                    ProgramsGoalAddEditFragment.currentGoalItem = null;
                    ProgramsGoalFragment.this.activity.switchFragment(9);
                }
            });
            myViewHolder.circleProgress.setGoalData(programGoalData);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.horizontalList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ProgramGoalCircleProgressView circleProgress;
            View cntr;
            ImageView imageView;
            TextView txt1TitleDate;
            TextView txt2Title;
            TextView txt3Status;
            TextView txt4Percent;
            TextView txt5PercentSign;
            TextView txt6Type;
            TextView txt7Duration;
            TextView txt8Val;

            public MyViewHolder(View view) {
                super(view);
                this.imageView = (ImageView) view.findViewById(R.id.imageview);
                this.txt1TitleDate = (TextView) view.findViewById(R.id.txt1TitleDate);
                this.txt2Title = (TextView) view.findViewById(R.id.txt2title);
                this.txt3Status = (TextView) view.findViewById(R.id.txt3Status);
                this.txt4Percent = (TextView) view.findViewById(R.id.txt4Percent);
                this.txt5PercentSign = (TextView) view.findViewById(R.id.txt5PercentSign);
                this.txt6Type = (TextView) view.findViewById(R.id.txt6Type);
                this.txt7Duration = (TextView) view.findViewById(R.id.txt7Duration);
                this.txt8Val = (TextView) view.findViewById(R.id.txt8Val);
                this.cntr = view.findViewById(R.id.cntr);
                this.circleProgress = (ProgramGoalCircleProgressView) view.findViewById(R.id.circle_progress);
            }
        }
    }

    /* renamed from: com.dyaco.sole.fragment.programs.ProgramsGoalFragment$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType;

        static {
            int[] iArr = new int[ProgramGoalData.GoalStateType.values().length];
            $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType = iArr;
            try {
                iArr[ProgramGoalData.GoalStateType.Processing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType[ProgramGoalData.GoalStateType.Done.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType[ProgramGoalData.GoalStateType.Miss.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
