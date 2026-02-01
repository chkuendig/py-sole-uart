package com.dyaco.sole.activity;

import android.content.Context;
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
import com.digifly.cloudapi.listener.MemberForgetPasswordListener;
import com.digifly.dbapi.DbManager;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.R2;
import com.dyaco.sole.custom.Global;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class Login_Forget_Activity extends AppCompatActivity {
    Button cancel;
    private CloudApi cloudApi;
    private DbManager dbManager;
    Typeface font;
    RelativeLayout forgetBackgroundLayout;
    LinearLayout forgetContentLayout;
    EditText forgetEmail;
    ImageView forgetImageView;
    TextView forgetTitle;
    LinearLayout mainLayout;
    Button reset;
    TextView text;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        int i = Global.BRAND;
        if (i == 0) {
            setContentView(R.layout.activity_login_forget);
        } else if (i == 1) {
            setContentView(R.layout.spirit_activity_login_forget);
        } else if (i == 2) {
            setContentView(R.layout.xterra_activity_login_forget);
        } else if (i == 3) {
            setContentView(R.layout.fuel_activity_login_forget);
        }
        getWindow().setSoftInputMode(2);
        this.cloudApi = CloudApi.getInstance(this);
        this.dbManager = DbManager.getInstance(this);
        this.forgetBackgroundLayout = (RelativeLayout) findViewById(R.id.forget_background_layout);
        this.mainLayout = (LinearLayout) findViewById(R.id.forget_main_layout);
        this.forgetContentLayout = (LinearLayout) findViewById(R.id.forget_contentlinearlayout);
        this.forgetImageView = (ImageView) findViewById(R.id.forget_imageView);
        this.forgetTitle = (TextView) findViewById(R.id.forget_title);
        this.forgetEmail = (EditText) findViewById(R.id.forget_email);
        this.text = (TextView) findViewById(R.id.forget_text);
        this.cancel = (Button) findViewById(R.id.forget_cancel);
        this.reset = (Button) findViewById(R.id.forget_reset);
        this.font = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLight.ttf");
        initPhone();
        this.reset.setOnClickListener(new AnonymousClass1());
        this.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Login_Forget_Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(Login_Forget_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "forgetPwd_cancel_btn", ErrorLogSave.CLICK);
                Login_Forget_Activity.this.onBackPressed();
            }
        });
    }

    /* renamed from: com.dyaco.sole.activity.Login_Forget_Activity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ErrorLogSave.addErrorString(Login_Forget_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "forgetPwd_reset_btn", ErrorLogSave.CLICK);
            if ("".equals(Login_Forget_Activity.this.forgetEmail.getText().toString().trim())) {
                Login_Forget_Activity.this.forgetEmail.setBackgroundResource(R.drawable.signup_sole_button_b);
                Login_Forget_Activity.this.forgetEmail.requestFocus();
                Toast.makeText(Login_Forget_Activity.this, R.string.login_input_email, 1).show();
                return;
            }
            Login_Forget_Activity login_Forget_Activity = Login_Forget_Activity.this;
            if (!login_Forget_Activity.isEmailFormat(login_Forget_Activity.forgetEmail)) {
                ErrorLogSave.addErrorString(Login_Forget_Activity.this.getApplicationContext(), ErrorLogSave.INPUT, "forgetPwd_reset_btn", "input_err_email:" + ((Object) Login_Forget_Activity.this.forgetEmail.getText()));
                Login_Forget_Activity.this.forgetEmail.setBackgroundResource(R.drawable.signup_sole_button_b);
                Login_Forget_Activity.this.forgetEmail.requestFocus();
                Toast.makeText(Login_Forget_Activity.this, R.string.login_email_formate_err, 1).show();
                return;
            }
            Login_Forget_Activity.this.forgetEmail.setBackgroundResource(R.drawable.signup_sole_button_a);
            Login_Forget_Activity.this.cloudApi.setMemberForgetPassword(new MemberForgetPasswordListener() { // from class: com.dyaco.sole.activity.Login_Forget_Activity.1.1
                @Override // com.digifly.cloudapi.listener.MemberForgetPasswordListener
                public void onError(final String str) {
                    Login_Forget_Activity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Login_Forget_Activity.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ErrorLogSave.addErrorString(Login_Forget_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "forgetPwd_reset_btn", "execute_err:" + str);
                            Logger.d("forgetEmail = " + Login_Forget_Activity.this.forgetEmail);
                            Log.v("skypoo", "onError:" + str);
                        }
                    });
                }

                @Override // com.digifly.cloudapi.listener.MemberForgetPasswordListener
                public void onSuccess(final ResponseMessage responseMessage) {
                    Login_Forget_Activity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Login_Forget_Activity.1.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ErrorLogSave.addErrorString(Login_Forget_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "forgetPwd_reset_btn", "execute_success");
                            Logger.d("forgetEmail = " + Login_Forget_Activity.this.forgetEmail);
                            Log.v("skypoo", "onSuccess:" + responseMessage.toString());
                            Toast.makeText(Login_Forget_Activity.this, R.string.forget_email_formate_success, 1).show();
                        }
                    });
                }

                @Override // com.digifly.cloudapi.listener.MemberForgetPasswordListener
                public void onFail(final ResponseMessage responseMessage) {
                    Login_Forget_Activity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Login_Forget_Activity.1.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ErrorLogSave.addErrorString(Login_Forget_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "forgetPwd_reset_btn", "execute_fail:" + responseMessage.getMessage());
                            Log.v("skypoo", "onFail:" + responseMessage.toString());
                            Toast.makeText(Login_Forget_Activity.this, R.string.forget_email_formate_error, 1).show();
                        }
                    });
                }
            });
            Login_Forget_Activity.this.cloudApi.callMemberForgetPasswordListener(Login_Forget_Activity.this.forgetEmail.getText().toString());
        }
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
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = (int) (820.0f * f4);
            layoutParams.height = (int) (f * 500.0f);
            layoutParams.addRule(13);
            this.mainLayout.setLayoutParams(layoutParams);
            if (Global.BRAND == 1) {
                this.forgetBackgroundLayout.setBackgroundColor(-1);
            }
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i2;
            layoutParams2.height = i;
            this.mainLayout.setLayoutParams(layoutParams2);
            this.mainLayout.setBackgroundResource(R.drawable.main2);
            if (Global.BRAND == 1) {
                this.mainLayout.setBackgroundResource(R.drawable.main3);
                this.forgetBackgroundLayout.setBackgroundColor(-1);
            }
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        int i3 = (int) ((460.0f * f) + 0.5d);
        layoutParams3.height = i3;
        layoutParams3.width = (int) ((500.0f * f4) + 0.5d);
        this.forgetContentLayout.setLayoutParams(layoutParams3);
        this.forgetContentLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.height = i3;
        layoutParams4.width = (int) ((280.0f * f4) + 0.5d);
        this.forgetImageView.setLayoutParams(layoutParams4);
        if (isPad(this)) {
            layoutParams4.topMargin = (int) (f * 20.0f);
            layoutParams4.leftMargin = (int) (20.0f * f4);
        }
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.forgetTitle.getLayoutParams();
        this.forgetTitle.setY(64.0f * f);
        this.forgetTitle.setTypeface(this.font);
        this.forgetTitle.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        this.text.setY(80.0f * f);
        layoutParams6.height = (int) ((60.0f * f) + 0.5d);
        int i4 = (int) ((230.0f * f4) + 0.5d);
        layoutParams6.width = i4;
        this.text.setLayoutParams(layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        this.forgetEmail.setY(120.0f * f);
        this.forgetEmail.setTypeface(this.font);
        int i5 = (int) ((40.0f * f) + 0.5d);
        layoutParams7.height = i5;
        layoutParams7.width = i4;
        this.forgetEmail.setLayoutParams(layoutParams7);
        int i6 = isPad(this) ? R2.attr.customDimension : 200;
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        this.reset.setY(i6 * f);
        this.reset.setTypeface(this.font);
        layoutParams8.height = i5;
        layoutParams8.width = i4;
        this.reset.setLayoutParams(layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        this.cancel.setX(f4 * 200.0f);
        this.cancel.setY((i6 + 20) * f);
        this.cancel.setTypeface(this.font);
        layoutParams9.height = i5;
        layoutParams9.width = i4;
        this.cancel.setLayoutParams(layoutParams9);
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
