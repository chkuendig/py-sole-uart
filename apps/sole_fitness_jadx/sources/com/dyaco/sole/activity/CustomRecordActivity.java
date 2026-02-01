package com.dyaco.sole.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.ResponseDataCollection;
import com.digifly.cloudapi.listener.DCUploadTrainingDataListener;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.security.CertificateUtil;
import com.soletreadmills.sole.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.PeriodFormatterBuilder;

/* loaded from: classes.dex */
public class CustomRecordActivity extends AppCompatActivity {

    @BindView(R.id.btnBack)
    Button btnBack;

    @BindView(R.id.btnBack0)
    Button btnBack0;

    @BindView(R.id.btnSave)
    Button btnStop;
    private DbManager dbManager;

    @BindView(R.id.etStartDateTime)
    EditText etStartDateTime;
    private SportTypeSetting sportTypeSetting;

    @BindView(R.id.sportTypeSettingLayout)
    RelativeLayout sportTypeSettingLayout;

    @BindView(R.id.tvCalorieValue)
    TextView tvCalorieValue;

    @BindView(R.id.tvDistanceValue)
    EditText tvDistanceValue;

    @BindView(R.id.tvDurationValue)
    EditText tvDurationValue;
    private float weight = 70.0f;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_custom_record);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        this.dbManager = DbManager.getInstance(this);
        SportTypeSetting sportTypeSetting = new SportTypeSetting(getApplicationContext(), this.sportTypeSettingLayout);
        this.sportTypeSetting = sportTypeSetting;
        sportTypeSetting.updateSportType();
        this.etStartDateTime.setText(this.simpleDateFormat.format(new Date()));
        initListener();
    }

    private void initListener() {
        this.tvDistanceValue.addTextChangedListener(new TextWatcher() { // from class: com.dyaco.sole.activity.CustomRecordActivity.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CustomRecordActivity.this.countCalorie();
            }
        });
        this.tvDurationValue.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.dyaco.sole.activity.CustomRecordActivity.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    return;
                }
                CustomRecordActivity.this.checkDuration();
            }
        });
        this.tvDurationValue.addTextChangedListener(new TextWatcher() { // from class: com.dyaco.sole.activity.CustomRecordActivity.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.etStartDateTime.setOnClickListener(new AnonymousClass4());
    }

    /* renamed from: com.dyaco.sole.activity.CustomRecordActivity$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Calendar calendar = Calendar.getInstance();
            new DatePickerDialog(CustomRecordActivity.this, new DatePickerDialog.OnDateSetListener() { // from class: com.dyaco.sole.activity.CustomRecordActivity.4.1
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    final LocalDateTime localDateTime = new LocalDateTime(i, i2 + 1, i3, 0, 0);
                    Calendar calendar2 = Calendar.getInstance();
                    new TimePickerDialog(CustomRecordActivity.this, new TimePickerDialog.OnTimeSetListener() { // from class: com.dyaco.sole.activity.CustomRecordActivity.4.1.1
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i4, int i5) {
                            CustomRecordActivity.this.etStartDateTime.setText(localDateTime.withHourOfDay(i4).withMinuteOfHour(i5).toString(CalendarUtils.SQL_DATE_TIME_FORMAT));
                        }
                    }, calendar2.get(11), calendar2.get(12), false).show();
                }
            }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkDuration() {
        String string = this.tvDurationValue.getText().toString();
        Log.e("checkDuration", string + "");
        if (string.equals("") || !string.contains(CertificateUtil.DELIMITER) || string.endsWith(CertificateUtil.DELIMITER) || string.startsWith(CertificateUtil.DELIMITER)) {
            Toast.makeText(this, "format err. Correct format is  hh:mm.", 1).show();
            return false;
        }
        try {
            new PeriodFormatterBuilder().appendHours().appendSeparator(CertificateUtil.DELIMITER).appendMinutes().toFormatter().parsePeriod(string);
            return true;
        } catch (Exception unused) {
            Toast.makeText(this, "format err1. Correct format is  hh:mm.", 1).show();
            return false;
        }
    }

    private boolean checkDistance() throws NumberFormatException {
        String string = this.tvDistanceValue.getText().toString();
        if (string.equals("")) {
            Toast.makeText(this, "can not  empt", 1).show();
            return false;
        }
        Float.parseFloat(string);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countCalorie() {
        if (!this.tvDistanceValue.getText().toString().equals("")) {
            this.tvCalorieValue.setText(String.format("%2.1f", Double.valueOf(Float.parseFloat(r0) * this.weight * 1.036d)));
        } else {
            this.tvCalorieValue.setText("00");
        }
    }

    @OnClick({R.id.btnBack0, R.id.btnBack, R.id.btnSave})
    public void onClick(View view) throws NumberFormatException {
        switch (view.getId()) {
            case R.id.btnBack /* 2131230844 */:
            case R.id.btnBack0 /* 2131230845 */:
                new AlertDialog.Builder(this).setMessage(getResources().getString(R.string.custom_record_text1)).setPositiveButton(getResources().getString(R.string.custom_record_yes), new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.CustomRecordActivity.6
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CustomRecordActivity.this.onBackPressed();
                    }
                }).setNegativeButton(getResources().getString(R.string.custom_record_no), new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.CustomRecordActivity.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
                break;
            case R.id.btnSave /* 2131230863 */:
                if (checkDuration() && checkDistance()) {
                    saveDB();
                    onBackPressed();
                    break;
                }
                break;
        }
    }

    private void saveDB() throws NumberFormatException {
        DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
        DCTrainingData dCTrainingDataSaveAsTrainingData = saveAsTrainingData();
        dCTrainingDataDao.insert(dCTrainingDataSaveAsTrainingData);
        dCTrainingDataSaveAsTrainingData.setPassword(Global.getAccoutData(this).getPassword());
        updateTrainingDataToCloud(dCTrainingDataSaveAsTrainingData);
    }

    private void updateTrainingDataToCloud(DCTrainingData dCTrainingData) {
        CloudApi cloudApi = CloudApi.getInstance(this);
        cloudApi.setDCUploadTrainingDataListener(new MyDCUploadTrainingDataListener(dCTrainingData));
        cloudApi.callDCUploadTrainingData(dCTrainingData);
    }

    private DCTrainingData saveAsTrainingData() throws NumberFormatException {
        DCTrainingData dCTrainingData = new DCTrainingData();
        int accout_noFromDB = getAccout_noFromDB();
        dCTrainingData.setAccount(Global.userName);
        dCTrainingData.setAccount_no(accout_noFromDB);
        dCTrainingData.setTraining_datetime(DateTime.parse(this.etStartDateTime.getText().toString(), DateTimeFormat.forPattern(CalendarUtils.SQL_DATE_TIME_FORMAT)).toDate());
        DateTime dateTime = new DateTime(dCTrainingData.getTraining_datetime());
        Calendar calendar = Calendar.getInstance(getLocale());
        calendar.setTimeInMillis(dateTime.getMillis());
        dCTrainingData.setTraining_timezone_hour(((calendar.get(15) / 1000) / 60) / 60);
        dCTrainingData.setTraining_timezone_name(calendar.getTimeZone().getID());
        dCTrainingData.setIn_out(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        dCTrainingData.setBrand_code(Global.CLOUD_BRAND_NAME);
        dCTrainingData.setProgram_name(this.sportTypeSetting.getCurrentSportTypeName());
        Period period = new PeriodFormatterBuilder().appendHours().appendSeparator(CertificateUtil.DELIMITER).appendMinutes().toFormatter().parsePeriod(this.tvDurationValue.getText().toString());
        float f = Float.parseFloat(this.tvDistanceValue.getText().toString());
        float f2 = Float.parseFloat(this.tvCalorieValue.getText().toString());
        dCTrainingData.setTotal_time(period.toStandardSeconds().getSeconds());
        dCTrainingData.setTotal_distance(f);
        dCTrainingData.setTotal_calories(f2);
        dCTrainingData.setDevice_os_name("Android");
        dCTrainingData.setDevice_os_version(Build.VERSION.RELEASE);
        dCTrainingData.setDevice_model(Build.BRAND);
        dCTrainingData.setDevice_sno(Build.SERIAL);
        dCTrainingData.setMac_address("");
        return dCTrainingData;
    }

    private Locale getLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            return getResources().getConfiguration().getLocales().get(0);
        }
        return getResources().getConfiguration().locale;
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

    private static class MyDCUploadTrainingDataListener implements DCUploadTrainingDataListener {
        private final DCTrainingData dcTrainingData;

        public MyDCUploadTrainingDataListener(DCTrainingData dCTrainingData) {
            this.dcTrainingData = dCTrainingData;
        }

        @Override // com.digifly.cloudapi.listener.DCUploadTrainingDataListener
        public void onSuccess(ResponseDataCollection responseDataCollection) {
            String str = responseDataCollection.getSys_response_data().get("trainh_no");
            Log.d("cloudapi   trainh_no  ", str);
            DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
            DCTrainingData dCTrainingDataLoad = dCTrainingDataDao.load(this.dcTrainingData.getTrainingId());
            dCTrainingDataLoad.setTrainh_no(str);
            dCTrainingDataDao.update(dCTrainingDataLoad);
        }

        @Override // com.digifly.cloudapi.listener.DCUploadTrainingDataListener
        public void onFail(ResponseDataCollection responseDataCollection) {
            Log.d("cloudapi  Faili:", responseDataCollection.toString());
        }

        @Override // com.digifly.cloudapi.listener.DCUploadTrainingDataListener
        public void onError(String str) {
            Log.d("cloudapi Error:", str.toString());
        }
    }
}
