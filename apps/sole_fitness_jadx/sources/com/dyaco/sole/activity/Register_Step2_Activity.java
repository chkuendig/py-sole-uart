package com.dyaco.sole.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.github.gzuliyujiang.wheelpicker.OptionPicker;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionPickedListener;
import com.soletreadmills.sole.R;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.commons.cli.HelpFormatter;
import org.joda.time.DateTime;

/* loaded from: classes.dex */
public class Register_Step2_Activity extends AppCompatActivity {
    static Activity register2;
    Button back;
    TextView birthday;
    LinearLayout btncontent;
    Typeface font;
    private int mDay;
    private int mMonth;
    private int mYear;
    LinearLayout mainLayout;
    Button next;
    RelativeLayout registerBackgroundLayout;
    LinearLayout registerContentLayout;
    TextView registerGender;
    ImageView registerImageView;
    EditText registerName;
    TextView registerTitle;
    ImageView stageImage;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        int i = Global.BRAND;
        if (i == 0) {
            setContentView(R.layout.activity_register_step2);
        } else if (i == 1) {
            setContentView(R.layout.spirit_activity_register_step2);
        } else if (i == 2) {
            setContentView(R.layout.xterra_activity_register_step2);
        } else if (i == 3) {
            setContentView(R.layout.fuel_activity_register_step2);
        }
        getWindow().setSoftInputMode(2);
        register2 = this;
        this.registerBackgroundLayout = (RelativeLayout) findViewById(R.id.register2_background_layout);
        this.mainLayout = (LinearLayout) findViewById(R.id.register2_main_layout);
        this.registerContentLayout = (LinearLayout) findViewById(R.id.register2_content_layout);
        this.registerImageView = (ImageView) findViewById(R.id.register2_imageView);
        this.stageImage = (ImageView) findViewById(R.id.register2_stage_image);
        this.registerTitle = (TextView) findViewById(R.id.register2_title);
        this.registerName = (EditText) findViewById(R.id.register2_name);
        this.registerGender = (TextView) findViewById(R.id.register2_gender);
        this.birthday = (TextView) findViewById(R.id.register2_birthday);
        this.next = (Button) findViewById(R.id.register2_next);
        this.back = (Button) findViewById(R.id.register2_back);
        this.btncontent = (LinearLayout) findViewById(R.id.register2_btncontent);
        this.font = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLight.ttf");
        initPhone();
        this.registerGender.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step2_Activity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Register_Step2_Activity.this.onOptionPicker();
            }
        });
        this.birthday.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step2_Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Register_Step2_Activity.this.showDatePickerDialog();
            }
        });
        this.next.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step2_Activity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(Register_Step2_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "regist2_next_btn", ErrorLogSave.CLICK);
                ArrayList<String> stringArrayList = Register_Step2_Activity.this.getIntent().getExtras().getStringArrayList("data");
                if ("".equals(Register_Step2_Activity.this.registerName.getText().toString().trim())) {
                    stringArrayList.add(stringArrayList.get(0));
                } else {
                    stringArrayList.add(Register_Step2_Activity.this.registerName.getText().toString());
                }
                if ("".equals(Register_Step2_Activity.this.registerGender.getText().toString()) || Register_Step2_Activity.this.getResources().getString(R.string.gender_male).equals(Register_Step2_Activity.this.registerGender.getText().toString())) {
                    stringArrayList.add("M");
                } else {
                    stringArrayList.add("F");
                }
                if ("".equals(Register_Step2_Activity.this.birthday.getText().toString())) {
                    stringArrayList.add(new DateTime().minusYears(20).toString(CalendarUtils.SQL_DATE_FORMAT));
                } else {
                    stringArrayList.add(Register_Step2_Activity.this.birthday.getText().toString());
                }
                Intent intent = new Intent();
                intent.setClass(Register_Step2_Activity.this, Register_Step3_Activity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("data", stringArrayList);
                intent.putExtras(bundle2);
                Register_Step2_Activity.this.startActivity(intent);
                Register_Step2_Activity.this.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
            }
        });
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step2_Activity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(Register_Step2_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "regist2_back_btn", ErrorLogSave.CLICK);
                ArrayList<String> stringArrayList = Register_Step2_Activity.this.getIntent().getExtras().getStringArrayList("data");
                Intent intent = new Intent();
                intent.setClass(Register_Step2_Activity.this, Register_Step1_Activity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("data", stringArrayList);
                intent.putExtras(bundle2);
                Register_Step2_Activity.this.startActivity(intent);
                Register_Step2_Activity.this.finish();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        ArrayList<String> stringArrayList;
        String string;
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras == null || (stringArrayList = extras.getStringArrayList("data")) == null || stringArrayList.size() < 5) {
            return;
        }
        this.registerName.setText(stringArrayList.get(2));
        if (stringArrayList.get(3).equals("M")) {
            string = getResources().getString(R.string.gender_male);
        } else {
            string = getResources().getString(R.string.gender_female);
        }
        this.registerGender.setText(string);
        this.birthday.setText(stringArrayList.get(4));
    }

    private void initPhone() {
        float f;
        float f2;
        float f3;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        if (isPad(this)) {
            i2 = (i * 4) / 3;
            f = i / 760.0f;
            f2 = i2;
            f3 = 1024.0f;
        } else {
            f = i / 460.0f;
            f2 = i2;
            f3 = 780.0f;
        }
        float f4 = f2 / f3;
        if (isPad(this)) {
            this.registerBackgroundLayout.setGravity(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = (int) (820.0f * f4);
            layoutParams.height = (int) (f * 500.0f);
            layoutParams.addRule(13);
            this.mainLayout.setLayoutParams(layoutParams);
            if (Global.BRAND == 1) {
                this.registerBackgroundLayout.setBackgroundColor(-1);
            }
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i2;
            layoutParams2.height = i;
            this.mainLayout.setLayoutParams(layoutParams2);
            this.mainLayout.setBackgroundResource(R.drawable.main2);
            if (Global.BRAND == 1) {
                this.mainLayout.setBackgroundResource(R.drawable.main3);
                this.registerBackgroundLayout.setBackgroundColor(-1);
            }
        }
        this.registerContentLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.registerContentLayout.getLayoutParams();
        int i3 = (int) ((460.0f * f) + 0.5d);
        layoutParams3.height = i3;
        layoutParams3.width = (int) ((500.0f * f4) + 0.5d);
        this.registerContentLayout.setLayoutParams(layoutParams3);
        this.registerContentLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.height = i3;
        layoutParams4.width = (int) ((280.0f * f4) + 0.5d);
        this.registerImageView.setLayoutParams(layoutParams4);
        if (isPad(this)) {
            layoutParams4.topMargin = (int) (f * 20.0f);
            layoutParams4.leftMargin = (int) (20.0f * f4);
        }
        this.registerTitle.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.registerTitle.setLayoutParams((LinearLayout.LayoutParams) this.registerTitle.getLayoutParams());
        this.registerTitle.setY(64.0f * f);
        this.registerTitle.setTypeface(this.font);
        this.stageImage.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.stageImage.getLayoutParams();
        layoutParams5.width = (int) ((f4 * 160.0f) + 0.5d);
        layoutParams5.height = (int) ((30.0f * f) + 0.5d);
        this.stageImage.setLayoutParams(layoutParams5);
        this.stageImage.setY(80.0f * f);
        this.registerName.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.registerName.setY(f * 100.0f);
        this.registerName.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.registerName.getLayoutParams();
        int i4 = (int) ((40.0f * f) + 0.5d);
        layoutParams6.height = i4;
        int i5 = (int) ((230.0f * f4) + 0.5d);
        layoutParams6.width = i5;
        this.registerName.setLayoutParams(layoutParams6);
        this.registerGender.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.registerGender.setY(120.0f * f);
        this.registerGender.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.registerGender.getLayoutParams();
        layoutParams7.height = i4;
        layoutParams7.width = i5;
        this.registerGender.setLayoutParams(layoutParams7);
        this.birthday.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.birthday.setY(140.0f * f);
        this.birthday.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.birthday.getLayoutParams();
        layoutParams8.height = i4;
        layoutParams8.width = i5;
        this.birthday.setLayoutParams(layoutParams8);
        Log.v("skypoo", "confirm:" + this.birthday.getWidth());
        this.next.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.next.setY(160.0f * f);
        this.next.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.next.getLayoutParams();
        layoutParams9.height = i4;
        layoutParams9.width = i5;
        Log.v("skypoo", "next:" + layoutParams9.weight);
        this.next.setLayoutParams(layoutParams9);
        this.btncontent.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.btncontent.setY(f * 180.0f);
        this.back.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.back.setX(380.0f * f4);
        this.back.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) this.back.getLayoutParams();
        layoutParams10.height = i4;
        layoutParams10.width = (int) ((f4 * 100.0f) + 0.5d);
        this.back.setLayoutParams(layoutParams10);
    }

    public static boolean isPad(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2);
        this.mDay = calendar.get(5);
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() { // from class: com.dyaco.sole.activity.Register_Step2_Activity.5
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Register_Step2_Activity.this.birthday.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
            }
        }, this.mYear, this.mMonth, this.mDay).show();
    }

    public void onOptionPicker() {
        OptionPicker optionPicker = new OptionPicker(this) { // from class: com.dyaco.sole.activity.Register_Step2_Activity.6
            @Override // com.github.gzuliyujiang.wheelpicker.OptionPicker, com.github.gzuliyujiang.dialog.ModalDialog
            protected View createBodyView() {
                View viewCreateBodyView = super.createBodyView();
                getWheelView().setCyclicEnabled(false);
                return viewCreateBodyView;
            }
        };
        optionPicker.setData(getString(R.string.gender_male), getString(R.string.gender_female));
        optionPicker.setOnOptionPickedListener(new OnOptionPickedListener() { // from class: com.dyaco.sole.activity.Register_Step2_Activity.7
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnOptionPickedListener
            public void onOptionPicked(int i, Object obj) {
                if (obj instanceof String) {
                    Register_Step2_Activity.this.registerGender.setText((String) obj);
                }
            }
        });
        optionPicker.show();
    }
}
