package com.dyaco.sole.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.ResponseMessage;
import com.digifly.cloudapi.listener.MemberCheckAccountListener;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.custom.Global;
import com.soletreadmills.sole.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Register_Step1_Activity extends AppCompatActivity {
    static Activity register;
    LinearLayout btncontent;
    Button cancel;
    EditText confirmPassword;
    Typeface font;
    LinearLayout mainLayout;
    Button next;
    RelativeLayout registerBackgroundLayout;
    LinearLayout registerContentLayout;
    EditText registerEmail;
    ImageView registerImageView;
    EditText registerPassword;
    TextView registerTitle;
    ImageView stageImage;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        int i = Global.BRAND;
        if (i == 0) {
            setContentView(R.layout.activity_register_step1);
        } else if (i == 1) {
            setContentView(R.layout.spirit_activity_register_step1);
        } else if (i == 2) {
            setContentView(R.layout.xterra_activity_register_step1);
        } else if (i == 3) {
            setContentView(R.layout.fuel_activity_register_step1);
        }
        getWindow().setSoftInputMode(2);
        register = this;
        this.registerBackgroundLayout = (RelativeLayout) findViewById(R.id.register_background_layout);
        this.mainLayout = (LinearLayout) findViewById(R.id.main_layout);
        this.registerContentLayout = (LinearLayout) findViewById(R.id.register_content_layout);
        this.registerImageView = (ImageView) findViewById(R.id.register_imageView);
        this.stageImage = (ImageView) findViewById(R.id.stage_image);
        this.registerTitle = (TextView) findViewById(R.id.register_title);
        this.registerEmail = (EditText) findViewById(R.id.register_email);
        this.registerPassword = (EditText) findViewById(R.id.register_password);
        this.confirmPassword = (EditText) findViewById(R.id.confirm_password);
        this.next = (Button) findViewById(R.id.next);
        this.cancel = (Button) findViewById(R.id.cancel);
        this.btncontent = (LinearLayout) findViewById(R.id.btncontent);
        this.font = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLight.ttf");
        initPhone();
        this.next.setOnClickListener(new AnonymousClass1());
        this.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step1_Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(Register_Step1_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "regist1_cancel_btn", ErrorLogSave.CLICK);
                Intent intent = new Intent();
                intent.setClass(Register_Step1_Activity.this, LoginActivity.class);
                Register_Step1_Activity.this.startActivity(intent);
                Register_Step1_Activity.this.finish();
            }
        });
    }

    /* renamed from: com.dyaco.sole.activity.Register_Step1_Activity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ErrorLogSave.addErrorString(Register_Step1_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "regist1_next_btn", ErrorLogSave.CLICK);
            Register_Step1_Activity register_Step1_Activity = Register_Step1_Activity.this;
            if (!register_Step1_Activity.isEmailFormat(register_Step1_Activity.registerEmail)) {
                if (Register_Step1_Activity.this.registerPassword.getText().length() >= 6 && Register_Step1_Activity.this.registerPassword.getText().length() <= 20) {
                    ErrorLogSave.addErrorString(Register_Step1_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "regist1_next_btn", "input_err_email:" + ((Object) Register_Step1_Activity.this.registerEmail.getText()));
                    Register_Step1_Activity.this.registerEmail.setBackgroundResource(R.drawable.signup_sole_button_b);
                    Register_Step1_Activity.this.registerPassword.setBackgroundResource(R.drawable.signup_sole_button_a);
                    Register_Step1_Activity.this.registerEmail.requestFocus();
                    Toast.makeText(Register_Step1_Activity.this, R.string.login_email_formate_err, 0).show();
                    return;
                }
                if (Register_Step1_Activity.this.registerPassword.getText().length() < 6) {
                    ErrorLogSave.addErrorString(Register_Step1_Activity.this.getApplicationContext(), ErrorLogSave.INPUT, "regist1_next_btn", "input_err_email:" + ((Object) Register_Step1_Activity.this.registerEmail.getText()) + "_pwd:" + ((Object) Register_Step1_Activity.this.registerPassword.getText()));
                    Register_Step1_Activity.this.registerEmail.setBackgroundResource(R.drawable.signup_sole_button_b);
                    Register_Step1_Activity.this.registerPassword.setBackgroundResource(R.drawable.signup_sole_button_b);
                    Register_Step1_Activity.this.registerEmail.requestFocus();
                    Toast.makeText(Register_Step1_Activity.this, R.string.login_password_email_pwd_format_err, 0).show();
                    return;
                }
                ErrorLogSave.addErrorString(Register_Step1_Activity.this.getApplicationContext(), ErrorLogSave.INPUT, "regist1_next_btn", "input_err2_email:" + ((Object) Register_Step1_Activity.this.registerEmail.getText()) + "_pwd:" + ((Object) Register_Step1_Activity.this.registerPassword.getText()));
                Register_Step1_Activity.this.registerEmail.setBackgroundResource(R.drawable.signup_sole_button_b);
                Register_Step1_Activity.this.registerPassword.setBackgroundResource(R.drawable.signup_sole_button_b);
                Register_Step1_Activity.this.registerEmail.requestFocus();
                Toast.makeText(Register_Step1_Activity.this, R.string.login_password_email_pwd_format_err, 0).show();
                return;
            }
            if (Register_Step1_Activity.this.registerPassword.getText().length() >= 6 && Register_Step1_Activity.this.registerPassword.getText().length() <= 20) {
                if (Register_Step1_Activity.this.registerPassword.getText().toString().equals(Register_Step1_Activity.this.confirmPassword.getText().toString())) {
                    CloudApi cloudApi = CloudApi.getInstance(Register_Step1_Activity.this);
                    cloudApi.setCheckAccountListener(new MemberCheckAccountListener() { // from class: com.dyaco.sole.activity.Register_Step1_Activity.1.1
                        @Override // com.digifly.cloudapi.listener.MemberCheckAccountListener
                        public void onError(final String str) {
                            ErrorLogSave.addErrorString(Register_Step1_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "regist1_next_btn", "regist_error:" + str);
                            Register_Step1_Activity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Register_Step1_Activity.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(Register_Step1_Activity.this, str, 0).show();
                                }
                            });
                        }

                        @Override // com.digifly.cloudapi.listener.MemberCheckAccountListener
                        public void onSuccess(ResponseMessage responseMessage) {
                            ArrayList<String> arrayList;
                            Bundle extras = Register_Step1_Activity.this.getIntent().getExtras();
                            if (extras != null) {
                                arrayList = extras.getStringArrayList("data");
                                if (arrayList != null) {
                                    arrayList.set(0, Register_Step1_Activity.this.registerEmail.getText().toString());
                                    arrayList.set(1, Register_Step1_Activity.this.registerPassword.getText().toString());
                                } else {
                                    arrayList = new ArrayList<>();
                                    arrayList.add(Register_Step1_Activity.this.registerEmail.getText().toString());
                                    arrayList.add(Register_Step1_Activity.this.registerPassword.getText().toString());
                                }
                            } else {
                                arrayList = new ArrayList<>();
                                arrayList.add(Register_Step1_Activity.this.registerEmail.getText().toString());
                                arrayList.add(Register_Step1_Activity.this.registerPassword.getText().toString());
                            }
                            ErrorLogSave.addErrorString(Register_Step1_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "regist1_next_btn", "regist_success:" + ((Object) Register_Step1_Activity.this.registerEmail.getText()));
                            Intent intent = new Intent();
                            intent.setClass(Register_Step1_Activity.this, Register_Step2_Activity.class);
                            Bundle bundle = new Bundle();
                            bundle.putStringArrayList("data", arrayList);
                            intent.putExtras(bundle);
                            Register_Step1_Activity.this.startActivity(intent);
                            Register_Step1_Activity.this.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
                        }

                        @Override // com.digifly.cloudapi.listener.MemberCheckAccountListener
                        public void onFail(final ResponseMessage responseMessage) {
                            ErrorLogSave.addErrorString(Register_Step1_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "regist1_next_btn", "regist_fail:" + responseMessage.getMessage());
                            Register_Step1_Activity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Register_Step1_Activity.1.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (responseMessage.getCode().equals("-1")) {
                                        Toast.makeText(Register_Step1_Activity.this, R.string.login_account_is_exist, 0).show();
                                    } else {
                                        Toast.makeText(Register_Step1_Activity.this, responseMessage.getMessage(), 0).show();
                                    }
                                }
                            });
                        }
                    });
                    cloudApi.callCheckAccount(Register_Step1_Activity.this.registerEmail.getText().toString());
                    return;
                }
                ErrorLogSave.addErrorString(Register_Step1_Activity.this.getApplicationContext(), ErrorLogSave.INPUT, "regist1_next_btn", "input_err_pwd:" + ((Object) Register_Step1_Activity.this.registerPassword.getText()));
                Register_Step1_Activity.this.confirmPassword.setBackgroundResource(R.drawable.signup_sole_button_b);
                Register_Step1_Activity.this.confirmPassword.requestFocus();
                Toast.makeText(Register_Step1_Activity.this, R.string.login_password_err, 0).show();
                return;
            }
            if (Register_Step1_Activity.this.registerPassword.getText().length() < 6) {
                ErrorLogSave.addErrorString(Register_Step1_Activity.this.getApplicationContext(), ErrorLogSave.INPUT, "regist1_next_btn", "input_err_pwd<6:" + ((Object) Register_Step1_Activity.this.registerPassword.getText()));
                Register_Step1_Activity.this.registerEmail.setBackgroundResource(R.drawable.signup_sole_button_a);
                Register_Step1_Activity.this.registerPassword.setBackgroundResource(R.drawable.signup_sole_button_b);
                Register_Step1_Activity.this.registerPassword.requestFocus();
                Toast.makeText(Register_Step1_Activity.this, R.string.login_password_too_short, 0).show();
                return;
            }
            ErrorLogSave.addErrorString(Register_Step1_Activity.this.getApplicationContext(), ErrorLogSave.INPUT, "regist1_next_btn", "input_err_pwd>20:" + ((Object) Register_Step1_Activity.this.registerPassword.getText()));
            Register_Step1_Activity.this.registerEmail.setBackgroundResource(R.drawable.signup_sole_button_a);
            Register_Step1_Activity.this.registerPassword.setBackgroundResource(R.drawable.signup_sole_button_b);
            Register_Step1_Activity.this.registerPassword.requestFocus();
            Toast.makeText(Register_Step1_Activity.this, R.string.login_password_too_long, 0).show();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        ArrayList<String> stringArrayList;
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras == null || (stringArrayList = extras.getStringArrayList("data")) == null || stringArrayList.size() < 2) {
            return;
        }
        this.registerEmail.setText(stringArrayList.get(0));
        this.registerPassword.setText(stringArrayList.get(1));
        this.confirmPassword.setText(stringArrayList.get(1));
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
        this.registerEmail.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.registerEmail.setY(f * 100.0f);
        this.registerEmail.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.registerEmail.getLayoutParams();
        int i4 = (int) ((40.0f * f) + 0.5d);
        layoutParams6.height = i4;
        int i5 = (int) ((230.0f * f4) + 0.5d);
        layoutParams6.width = i5;
        this.registerEmail.setLayoutParams(layoutParams6);
        this.registerPassword.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.registerPassword.setY(120.0f * f);
        this.registerPassword.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.registerPassword.getLayoutParams();
        layoutParams7.height = i4;
        layoutParams7.width = i5;
        this.registerPassword.setLayoutParams(layoutParams7);
        this.confirmPassword.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.confirmPassword.setY(140.0f * f);
        this.confirmPassword.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.confirmPassword.getLayoutParams();
        layoutParams8.height = i4;
        layoutParams8.width = i5;
        this.confirmPassword.setLayoutParams(layoutParams8);
        Log.v("skypoo", "confirm:" + this.confirmPassword.getWidth());
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
        this.cancel.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cancel.setX(380.0f * f4);
        this.cancel.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) this.cancel.getLayoutParams();
        layoutParams10.height = i4;
        layoutParams10.width = (int) ((f4 * 100.0f) + 0.5d);
        this.cancel.setLayoutParams(layoutParams10);
    }

    public static boolean isPad(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEmailFormat(EditText editText) {
        if (editText == null) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(editText.getText().toString()).matches();
    }
}
