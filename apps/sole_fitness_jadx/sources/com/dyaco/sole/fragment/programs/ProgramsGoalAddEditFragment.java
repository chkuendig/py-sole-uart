package com.dyaco.sole.fragment.programs;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.DCProgramGoalData;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.ResponseDataCollection;
import com.digifly.cloudapi.listener.DCGoalUploadUpdateListener;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCProgramGoalDataDao;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.sole.activity.ConnectionDialog;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.LongClickRepeatButton;
import com.dyaco.sole.fragment.BaseFragment;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.joda.time.DateTime;

/* loaded from: classes.dex */
public class ProgramsGoalAddEditFragment extends BaseFragment {
    public static final String TAG = "ProgramGoalEdit";
    private MainActivity activity;
    private View btnCancel;
    private View btnSave;
    private CloudApi cloudApi;
    private FrameLayout content_layout;
    private DbManager dbManager;
    private DCProgramGoalDataDao dbProgramGoalDataDao;
    private View include_calendar_goal;
    private View rootView;
    private int[] settingValue;
    private LongClickRepeatButton setting_down_btn_GoalDuration;
    private LongClickRepeatButton setting_down_btn_GoalPeriodType;
    private LongClickRepeatButton setting_down_btn_GoalType;
    private LongClickRepeatButton setting_down_btn_GoalVal;
    private LongClickRepeatButton setting_up_btn_GoalDuration;
    private LongClickRepeatButton setting_up_btn_GoalPeriodType;
    private LongClickRepeatButton setting_up_btn_GoalType;
    private LongClickRepeatButton setting_up_btn_GoalVal;
    private TextView txtGoalDuration;
    private TextView txtGoalPeriodType;
    private TextView txtGoalTitle;
    private TextView txtGoalType;
    private TextView txtGoalUnit;
    private TextView txtGoalVal;
    public static Long currentItemID = 0L;
    public static DCProgramGoalData currentGoalItem = null;
    public static boolean isEditing = false;
    private boolean bl_cannot_modify_alert_show = false;
    private boolean debug = false;
    private int beUpdatedCloud = 0;
    private View.OnClickListener onClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalAddEditFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws InterruptedException {
            int id = view.getId();
            switch (id) {
                case R.id.btnCancel /* 2131230846 */:
                    ProgramsGoalAddEditFragment.isEditing = false;
                    ProgramsGoalAddEditFragment.this.activity.switchFragment(8);
                    break;
                case R.id.btnSave /* 2131230863 */:
                    new ProgressDialog(ProgramsGoalAddEditFragment.this.activity);
                    final DCProgramGoalData dCProgramGoalDataSaveAsProgramGoalData = ProgramsGoalAddEditFragment.this.saveAsProgramGoalData();
                    if (!Global.userName.equals(ProgramsGoalAddEditFragment.this.getResources().getString(R.string.guest)) && dCProgramGoalDataSaveAsProgramGoalData != null) {
                        Logger.d("Global.memberData = " + Global.memberData);
                        Logger.d("dcProgramGoalData = " + dCProgramGoalDataSaveAsProgramGoalData);
                        CloudApi.getInstance(ProgramsGoalAddEditFragment.this.activity);
                        ProgramsGoalAddEditFragment.this.cloudApi.setGoalUploadUpdateListener(new DCGoalUploadUpdateListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalAddEditFragment.3.1
                            @Override // com.digifly.cloudapi.listener.DCGoalUploadUpdateListener
                            public void onSuccess(ResponseDataCollection responseDataCollection) {
                                Logger.d("responseDataCollection = " + responseDataCollection);
                                DCProgramGoalDataDao dCProgramGoalDataDao = DbManager.getDCProgramGoalDataDao();
                                if (dCProgramGoalDataSaveAsProgramGoalData != null) {
                                    if (ProgramsGoalAddEditFragment.currentItemID.longValue() != 0 && ProgramsGoalAddEditFragment.currentGoalItem != null) {
                                        dCProgramGoalDataDao.update(dCProgramGoalDataSaveAsProgramGoalData);
                                    } else {
                                        dCProgramGoalDataSaveAsProgramGoalData.setGoal_no(responseDataCollection.getSys_response_data().get("goal_no"));
                                        dCProgramGoalDataDao.insert(dCProgramGoalDataSaveAsProgramGoalData);
                                    }
                                }
                                ProgramsGoalAddEditFragment.this.beUpdatedCloud = 1;
                            }

                            @Override // com.digifly.cloudapi.listener.DCGoalUploadUpdateListener
                            public void onFail(ResponseDataCollection responseDataCollection) {
                                Logger.d("responseDataCollection = " + responseDataCollection);
                                ProgramsGoalAddEditFragment.this.beUpdatedCloud = 2;
                            }

                            @Override // com.digifly.cloudapi.listener.DCGoalUploadUpdateListener
                            public void onError(String str) {
                                Logger.d("err = " + str);
                                ProgramsGoalAddEditFragment.this.beUpdatedCloud = 3;
                            }
                        });
                        ProgramsGoalAddEditFragment.this.cloudApi.callGoalUploadUpdate(dCProgramGoalDataSaveAsProgramGoalData, Global.memberData.getPassword());
                    }
                    int i = 100;
                    while (true) {
                        if (i <= 0) {
                            break;
                        } else if (ProgramsGoalAddEditFragment.this.beUpdatedCloud != 0) {
                            ProgramsGoalAddEditFragment.isEditing = false;
                            ProgramsGoalAddEditFragment.this.activity.switchFragment(8);
                            if (ProgramsGoalAddEditFragment.this.beUpdatedCloud == 2 || ProgramsGoalAddEditFragment.this.beUpdatedCloud == 3) {
                                Toast.makeText(ProgramsGoalAddEditFragment.this.activity, "can not upload data to cloud", 0).show();
                            }
                            ProgramsGoalAddEditFragment.this.beUpdatedCloud = 0;
                            break;
                        } else {
                            try {
                                Thread.sleep(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            i--;
                        }
                    }
                    break;
                case R.id.txtGoalPeriodType /* 2131231803 */:
                    if (ProgramsGoalAddEditFragment.currentItemID.longValue() == 0 || !ProgramsGoalAddEditFragment.isEditing) {
                        int i2 = ProgramsGoalAddEditFragment.this.settingValue[1];
                        if (i2 == 0) {
                            ProgramsGoalAddEditFragment.this.settingValue[1] = 1;
                            break;
                        } else if (i2 == 1) {
                            ProgramsGoalAddEditFragment.this.settingValue[1] = 2;
                            break;
                        } else if (i2 == 2) {
                            ProgramsGoalAddEditFragment.this.settingValue[1] = 0;
                            break;
                        }
                    } else {
                        ProgramsGoalAddEditFragment.this.showCannotModifyAlert();
                        return;
                    }
                    break;
                case R.id.txtGoalType /* 2131231805 */:
                    int i3 = ProgramsGoalAddEditFragment.this.settingValue[2];
                    if (i3 == 0) {
                        ProgramsGoalAddEditFragment.this.settingValue[2] = 1;
                        break;
                    } else if (i3 == 1) {
                        ProgramsGoalAddEditFragment.this.settingValue[2] = 2;
                        break;
                    } else if (i3 == 2) {
                        ProgramsGoalAddEditFragment.this.settingValue[2] = 0;
                        break;
                    }
                    break;
                default:
                    switch (id) {
                        case R.id.setting_down_btn_GoalDuration /* 2131231625 */:
                            if (ProgramsGoalAddEditFragment.currentItemID.longValue() == 0 || !ProgramsGoalAddEditFragment.isEditing) {
                                int[] iArr = ProgramsGoalAddEditFragment.this.settingValue;
                                iArr[0] = iArr[0] - 1;
                                if (ProgramsGoalAddEditFragment.this.settingValue[0] < 0) {
                                    ProgramsGoalAddEditFragment.this.settingValue[0] = 0;
                                    break;
                                }
                            } else {
                                ProgramsGoalAddEditFragment.this.showCannotModifyAlert();
                                break;
                            }
                            break;
                        case R.id.setting_down_btn_GoalPeriodType /* 2131231626 */:
                            if (ProgramsGoalAddEditFragment.currentItemID.longValue() == 0 || !ProgramsGoalAddEditFragment.isEditing) {
                                int i4 = ProgramsGoalAddEditFragment.this.settingValue[1];
                                if (i4 == 0) {
                                    ProgramsGoalAddEditFragment.this.settingValue[1] = 2;
                                    break;
                                } else if (i4 == 1) {
                                    ProgramsGoalAddEditFragment.this.settingValue[1] = 0;
                                    break;
                                } else if (i4 == 2) {
                                    ProgramsGoalAddEditFragment.this.settingValue[1] = 1;
                                    break;
                                }
                            } else {
                                ProgramsGoalAddEditFragment.this.showCannotModifyAlert();
                                return;
                            }
                            break;
                        case R.id.setting_down_btn_GoalType /* 2131231627 */:
                            int i5 = ProgramsGoalAddEditFragment.this.settingValue[2];
                            if (i5 == 0) {
                                ProgramsGoalAddEditFragment.this.settingValue[2] = 2;
                                break;
                            } else if (i5 == 1) {
                                ProgramsGoalAddEditFragment.this.settingValue[2] = 0;
                                break;
                            } else if (i5 == 2) {
                                ProgramsGoalAddEditFragment.this.settingValue[2] = 1;
                                break;
                            }
                            break;
                        case R.id.setting_down_btn_GoalVal /* 2131231628 */:
                            int[] iArr2 = ProgramsGoalAddEditFragment.this.settingValue;
                            iArr2[3] = iArr2[3] - 1;
                            if (ProgramsGoalAddEditFragment.this.settingValue[3] < 0) {
                                ProgramsGoalAddEditFragment.this.settingValue[3] = 0;
                                break;
                            }
                            break;
                        default:
                            switch (id) {
                                case R.id.setting_up_btn_GoalDuration /* 2131231637 */:
                                    if (ProgramsGoalAddEditFragment.currentItemID.longValue() == 0 || !ProgramsGoalAddEditFragment.isEditing) {
                                        int[] iArr3 = ProgramsGoalAddEditFragment.this.settingValue;
                                        iArr3[0] = iArr3[0] + 1;
                                        break;
                                    } else {
                                        ProgramsGoalAddEditFragment.this.showCannotModifyAlert();
                                        break;
                                    }
                                case R.id.setting_up_btn_GoalPeriodType /* 2131231638 */:
                                    if (ProgramsGoalAddEditFragment.currentItemID.longValue() == 0 || !ProgramsGoalAddEditFragment.isEditing) {
                                        int i6 = ProgramsGoalAddEditFragment.this.settingValue[1];
                                        if (i6 == 0) {
                                            ProgramsGoalAddEditFragment.this.settingValue[1] = 1;
                                            break;
                                        } else if (i6 == 1) {
                                            ProgramsGoalAddEditFragment.this.settingValue[1] = 2;
                                            break;
                                        } else if (i6 == 2) {
                                            ProgramsGoalAddEditFragment.this.settingValue[1] = 0;
                                            break;
                                        }
                                    } else {
                                        ProgramsGoalAddEditFragment.this.showCannotModifyAlert();
                                        return;
                                    }
                                    break;
                                case R.id.setting_up_btn_GoalType /* 2131231639 */:
                                    int i7 = ProgramsGoalAddEditFragment.this.settingValue[2];
                                    if (i7 == 0) {
                                        ProgramsGoalAddEditFragment.this.settingValue[2] = 1;
                                        break;
                                    } else if (i7 == 1) {
                                        ProgramsGoalAddEditFragment.this.settingValue[2] = 2;
                                        break;
                                    } else if (i7 == 2) {
                                        ProgramsGoalAddEditFragment.this.settingValue[2] = 0;
                                        break;
                                    }
                                    break;
                                case R.id.setting_up_btn_GoalVal /* 2131231640 */:
                                    int[] iArr4 = ProgramsGoalAddEditFragment.this.settingValue;
                                    iArr4[3] = iArr4[3] + 1;
                                    break;
                            }
                    }
            }
            ProgramsGoalAddEditFragment.this.setGoalDataStr();
        }
    };

    private void updateProgramGoalDataToCloud(DCProgramGoalData dCProgramGoalData) {
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.bl_cannot_modify_alert_show = false;
        Log.v(TAG, "onHiddenChanged() hidden : " + z);
        if (z || isEditing) {
            return;
        }
        isEditing = true;
        if (currentItemID.longValue() != 0) {
            getCurrentEditDCProgramGoalDataFromDB();
            DCProgramGoalData dCProgramGoalData = currentGoalItem;
            if (dCProgramGoalData != null && !dCProgramGoalData.getGoal_name().equals("")) {
                Log.v(TAG, "setGoalDataStr() currentGoalItem.getGoal_name() :" + currentGoalItem.getGoal_name() + StringUtils.SPACE);
                this.txtGoalTitle.setText(currentGoalItem.getGoal_name());
            }
        } else {
            initDefaulSettingValue();
        }
        setGoalDataStr();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initGoalView();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.activity = (MainActivity) getActivity();
        int i = Global.BRAND;
        if (i == 0) {
            this.rootView = layoutInflater.inflate(R.layout.fragment_programs_goal_add_edit, viewGroup, false);
        } else if (i == 1 || i == 2 || i == 3) {
            this.rootView = layoutInflater.inflate(R.layout.s_fragment_programs_goal_add_edit, viewGroup, false);
        }
        findViews();
        initParams();
        setListeners();
        return this.rootView;
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void findViews() {
        this.cloudApi = CloudApi.getInstance(this.activity);
        this.dbManager = DbManager.getInstance(this.activity);
        this.dbProgramGoalDataDao = DbManager.getDCProgramGoalDataDao();
        this.btnSave = this.rootView.findViewById(R.id.btnSave);
        this.btnCancel = this.rootView.findViewById(R.id.btnCancel);
        this.txtGoalUnit = (TextView) this.rootView.findViewById(R.id.txtGoalUnit);
        this.txtGoalTitle = (TextView) this.rootView.findViewById(R.id.txtGoalTitle);
        this.setting_up_btn_GoalDuration = (LongClickRepeatButton) this.rootView.findViewById(R.id.setting_up_btn_GoalDuration);
        this.txtGoalDuration = (TextView) this.rootView.findViewById(R.id.txtGoalDuration);
        this.setting_down_btn_GoalDuration = (LongClickRepeatButton) this.rootView.findViewById(R.id.setting_down_btn_GoalDuration);
        this.setting_up_btn_GoalPeriodType = (LongClickRepeatButton) this.rootView.findViewById(R.id.setting_up_btn_GoalPeriodType);
        this.txtGoalPeriodType = (TextView) this.rootView.findViewById(R.id.txtGoalPeriodType);
        this.setting_down_btn_GoalPeriodType = (LongClickRepeatButton) this.rootView.findViewById(R.id.setting_down_btn_GoalPeriodType);
        this.setting_up_btn_GoalType = (LongClickRepeatButton) this.rootView.findViewById(R.id.setting_up_btn_GoalType);
        this.txtGoalType = (TextView) this.rootView.findViewById(R.id.txtGoalType);
        this.setting_down_btn_GoalType = (LongClickRepeatButton) this.rootView.findViewById(R.id.setting_down_btn_GoalType);
        this.setting_up_btn_GoalVal = (LongClickRepeatButton) this.rootView.findViewById(R.id.setting_up_btn_GoalVal);
        this.txtGoalVal = (TextView) this.rootView.findViewById(R.id.txtGoalVal);
        this.setting_down_btn_GoalVal = (LongClickRepeatButton) this.rootView.findViewById(R.id.setting_down_btn_GoalVal);
    }

    private void initGoalView() {
        int i = Global.BRAND;
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void initParams() {
        int i = Global.BRAND;
        initDefaulSettingValue();
        setGoalDataStr();
    }

    private void initDefaulSettingValue() {
        this.txtGoalTitle.setText(R.string.goal_my_goal);
        if (currentItemID.longValue() == 0) {
            this.settingValue = new int[]{7, 0, 1, 10};
        }
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void setListeners() {
        this.btnSave.setOnClickListener(this.onClick);
        this.btnCancel.setOnClickListener(this.onClick);
        this.setting_up_btn_GoalDuration.setIntervalTime(60L);
        this.setting_up_btn_GoalDuration.setOnClickListener(this.onClick);
        this.setting_down_btn_GoalDuration.setIntervalTime(60L);
        this.setting_down_btn_GoalDuration.setOnClickListener(this.onClick);
        this.setting_up_btn_GoalPeriodType.setIntervalTime(60L);
        this.setting_up_btn_GoalPeriodType.setOnClickListener(this.onClick);
        this.setting_down_btn_GoalPeriodType.setIntervalTime(60L);
        this.txtGoalPeriodType.setOnClickListener(this.onClick);
        this.setting_down_btn_GoalPeriodType.setOnClickListener(this.onClick);
        this.setting_up_btn_GoalType.setIntervalTime(60L);
        this.setting_up_btn_GoalType.setOnClickListener(this.onClick);
        this.setting_down_btn_GoalType.setIntervalTime(60L);
        this.txtGoalType.setOnClickListener(this.onClick);
        this.setting_down_btn_GoalType.setOnClickListener(this.onClick);
        this.setting_up_btn_GoalVal.setIntervalTime(60L);
        this.setting_up_btn_GoalVal.setOnClickListener(this.onClick);
        this.setting_down_btn_GoalVal.setIntervalTime(60L);
        this.setting_down_btn_GoalVal.setOnClickListener(this.onClick);
        this.txtGoalDuration.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalAddEditFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProgramsGoalAddEditFragment.currentItemID.longValue() == 0 || !ProgramsGoalAddEditFragment.isEditing) {
                    final String[] strArrCreateItmes = ProgramsGoalAddEditFragment.this.createItmes(view);
                    new AlertDialog.Builder(ProgramsGoalAddEditFragment.this.getContextThemeWrapper()).setTitle("").setSingleChoiceItems(strArrCreateItmes, Arrays.asList(strArrCreateItmes).indexOf(String.valueOf(ProgramsGoalAddEditFragment.this.settingValue[0])), new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalAddEditFragment.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ProgramsGoalAddEditFragment.this.txtGoalDuration.setText(strArrCreateItmes[i]);
                            ProgramsGoalAddEditFragment.this.settingValue[0] = Integer.parseInt(strArrCreateItmes[i]);
                            dialogInterface.dismiss();
                        }
                    }).create().show();
                    return;
                }
                ProgramsGoalAddEditFragment.this.showCannotModifyAlert();
            }
        });
        this.txtGoalVal.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalAddEditFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final String[] strArrCreateItmes = ProgramsGoalAddEditFragment.this.createItmes(view);
                new AlertDialog.Builder(ProgramsGoalAddEditFragment.this.getContextThemeWrapper()).setTitle("").setSingleChoiceItems(strArrCreateItmes, Arrays.asList(strArrCreateItmes).indexOf(String.valueOf(ProgramsGoalAddEditFragment.this.settingValue[3])), new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsGoalAddEditFragment.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ProgramsGoalAddEditFragment.this.txtGoalVal.setText(strArrCreateItmes[i]);
                        ProgramsGoalAddEditFragment.this.settingValue[3] = Integer.parseInt(strArrCreateItmes[i]);
                        dialogInterface.dismiss();
                    }
                }).create().show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ContextThemeWrapper getContextThemeWrapper() {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.activity, R.style.numAlertDialogCustomSole);
        int i = Global.BRAND;
        return (i == 1 || i == 2 || i == 3) ? new ContextThemeWrapper(this.activity, R.style.numAlertDialogCustomXterra) : contextThemeWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] createItmes(View view) {
        return genNumArr();
    }

    private String[] genNumArr() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i <= 99; i++) {
            linkedList.add(String.valueOf(i));
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoalDataStr() {
        this.txtGoalDuration.setText(this.settingValue[0] + "");
        this.txtGoalVal.setText(this.settingValue[3] + "");
        int i = this.settingValue[1];
        if (i == 0) {
            this.txtGoalPeriodType.setText(R.string.goal_period_day);
        } else if (i == 1) {
            this.txtGoalPeriodType.setText(R.string.goal_period_week);
        } else if (i == 2) {
            this.txtGoalPeriodType.setText(R.string.goal_period_month);
        }
        int i2 = this.settingValue[2];
        if (i2 == 0) {
            this.txtGoalType.setText(R.string.goal_field_time);
            this.txtGoalUnit.setText(R.string.goal_field_min_day);
        } else if (i2 == 1) {
            this.txtGoalType.setText(R.string.goal_field_distance);
            this.txtGoalUnit.setText(R.string.goal_field_km);
        } else {
            if (i2 != 2) {
                return;
            }
            this.txtGoalType.setText(R.string.goal_field_calorie);
            this.txtGoalUnit.setText(R.string.goal_field_kcal);
        }
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

    private void goPage(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this.activity, cls);
        startActivity(intent);
    }

    private void goConnection() {
        startActivityForResult(new Intent(getActivity(), (Class<?>) ConnectionDialog.class), 99);
        this.activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private int getAccout_noFromDB() {
        QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
        queryBuilder.where(MemberDataDao.Properties.Account.eq(Global.userName), new WhereCondition[0]);
        List<MemberData> list = queryBuilder.list();
        if (list == null || list.size() != 1) {
            return -1;
        }
        return list.get(0).getAccount_no();
    }

    private Locale getLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            return getResources().getConfiguration().getLocales().get(0);
        }
        return getResources().getConfiguration().locale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DCProgramGoalData saveAsProgramGoalData() {
        DateTime dateTimeMinusDays;
        boolean z = this.debug;
        int[] iArr = this.settingValue;
        if (iArr[3] == 0 || iArr[0] == 0 || "".equals(this.txtGoalTitle.getText().toString().trim())) {
            if ("".equals(this.txtGoalTitle.getText().toString().trim())) {
                this.txtGoalTitle.setText("");
                Toast.makeText(getActivity(), "請填寫目標名稱", 0).show();
                return null;
            }
            int[] iArr2 = this.settingValue;
            if (iArr2[3] == 0) {
                Toast.makeText(getActivity(), "請填寫目標值", 0).show();
                return null;
            }
            if (iArr2[0] != 0) {
                return null;
            }
            Toast.makeText(getActivity(), "請填寫持續時間", 0).show();
            return null;
        }
        DCProgramGoalData dCProgramGoalData = new DCProgramGoalData();
        int accout_noFromDB = getAccout_noFromDB();
        dCProgramGoalData.setAccount(Global.userName);
        dCProgramGoalData.setAccount_no(accout_noFromDB);
        dCProgramGoalData.setGoal_state(0);
        dCProgramGoalData.setGoal_name(this.txtGoalTitle.getText().toString());
        dCProgramGoalData.setGoal_val(this.settingValue[3]);
        dCProgramGoalData.setGoal_percent(0);
        dCProgramGoalData.setGoal_period_type(this.settingValue[1]);
        dCProgramGoalData.setGoal_type(this.settingValue[2]);
        dCProgramGoalData.setGoal_duration(this.settingValue[0]);
        DateTime dateTime = new DateTime(dCProgramGoalData.getGoal_start_date());
        DateTime dateTime2 = new DateTime(dCProgramGoalData.getGoal_end_date());
        int[] iArr3 = this.settingValue;
        int i = iArr3[1];
        if (i == 0) {
            if (z) {
                if (iArr3[0] > 5) {
                    dateTimeMinusDays = dateTime.minusSeconds((int) (iArr3[0] * 24 * 60 * 60 * 1.2f));
                } else if (iArr3[0] == 1) {
                    dateTimeMinusDays = dateTime.minusDays(1);
                } else {
                    dateTimeMinusDays = dateTime.minusDays(iArr3[0] - 1);
                }
                dateTime = dateTimeMinusDays;
            }
            dateTime2 = dateTime.plusDays(this.settingValue[0]);
        } else if (i == 1) {
            if (z) {
                dateTime = dateTime.minusSeconds((int) (iArr3[0] * 24 * 60 * 60 * 7 * 1.2f));
            }
            dateTime2 = dateTime.plusWeeks(this.settingValue[0]);
        } else if (i == 2) {
            if (z) {
                dateTime = dateTime.minusSeconds((int) (iArr3[0] * 24 * 60 * 60 * 30 * 1.2f));
            }
            dateTime2 = dateTime.plusMonths(this.settingValue[0]);
        }
        Log.v(TAG, "saveAsProgramGoalData() startDate : " + dateTime);
        Log.v(TAG, "saveAsProgramGoalData() endDate : " + dateTime2);
        dCProgramGoalData.setGoal_start_date(dateTime.toDate());
        dCProgramGoalData.setGoal_end_date(dateTime2.toDate());
        Calendar calendar = Calendar.getInstance(getLocale());
        calendar.setTimeInMillis(dateTime.getMillis());
        dCProgramGoalData.setGoal_timezone_hour(((calendar.get(15) / 1000) / 60) / 60);
        dCProgramGoalData.setGoal_timezone_name(calendar.getTimeZone().getID());
        dCProgramGoalData.setDevice_os_name("Android");
        dCProgramGoalData.setDevice_os_version(Build.VERSION.RELEASE);
        dCProgramGoalData.setDevice_model(Build.BRAND);
        dCProgramGoalData.setDevice_sno(Build.SERIAL);
        dCProgramGoalData.setBrand_code(Global.CLOUD_BRAND_NAME);
        if (currentItemID.longValue() != 0 && currentGoalItem != null) {
            dCProgramGoalData.setGoalId(currentItemID);
            dCProgramGoalData.setGoal_no(currentGoalItem.getGoal_no());
            dCProgramGoalData.setGoal_val_now(currentGoalItem.getGoal_val_now());
            dCProgramGoalData.setGoal_state(currentGoalItem.getGoal_state());
            dCProgramGoalData.setElapsedays(currentGoalItem.getElapsedays());
            dCProgramGoalData.setGoal_pos_in_duration(currentGoalItem.getGoal_pos_in_duration());
            dCProgramGoalData.setGoal_percent(currentGoalItem.getGoal_percent());
        }
        return dCProgramGoalData;
    }

    private List<ProgramGoalData> getCurrentEditDCProgramGoalDataFromDB() {
        Log.v(TAG, "getCurrentEditDCProgramGoalDataFromDB() ");
        try {
            List<DCProgramGoalData> list = this.dbProgramGoalDataDao.queryBuilder().where(DCProgramGoalDataDao.Properties.GoalId.eq(currentItemID), new WhereCondition[0]).orderAsc(DCProgramGoalDataDao.Properties.Goal_start_date).list();
            Log.v(TAG, "getCurrentEditDCProgramGoalDataFromDB() programGoalDatas = " + list);
            if (list != null && list.size() == 1) {
                DCProgramGoalData dCProgramGoalData = list.get(0);
                Log.v(TAG, "getCurrentEditDCProgramGoalDataFromDB() dt : " + dCProgramGoalData);
                this.settingValue = new int[]{dCProgramGoalData.getGoal_duration(), dCProgramGoalData.getGoal_period_type(), dCProgramGoalData.getGoal_type(), dCProgramGoalData.getGoal_val()};
                currentGoalItem = dCProgramGoalData;
            } else {
                currentGoalItem = null;
            }
        } catch (Exception e) {
            Log.v(TAG, "getCurrentEditDCProgramGoalDataFromDB() error : " + e.toString());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCannotModifyAlert() {
        if (this.bl_cannot_modify_alert_show) {
            return;
        }
        Toast.makeText(getActivity(), "目標建立後不可修改", 0).show();
        this.bl_cannot_modify_alert_show = true;
    }
}
