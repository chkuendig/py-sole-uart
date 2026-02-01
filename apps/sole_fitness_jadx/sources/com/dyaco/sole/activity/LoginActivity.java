package com.dyaco.sole.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.DCLoginInfoData;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.ResponseDataCollection;
import com.digifly.cloudapi.data.ResponseMessage;
import com.digifly.cloudapi.listener.DCLoginInfoListener;
import com.digifly.cloudapi.listener.MemberLoginListener;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.sole.BuildConfig;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom_view.ErrorDialog;
import com.dyaco.sole.custom_view.QuestMainView;
import com.dyaco.sole.database.MessageDB;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LoginActivity extends AppCompatActivity {
    private static final int CAMERA = 66;
    public static final String LOGIN_TYPE_NORMAL = "NORMAL";
    private static final int PHOTO = 67;
    private static final String TAG = "LoginActivity";
    static Activity loginActivity;
    private AccessToken accessToken;
    RelativeLayout backgroundLayout;
    LinearLayout btncontent;
    CallbackManager callbackManager;
    private CloudApi cloudApi;
    LinearLayout contentLinearLayout;
    private DbManager dbManager;
    EditText email;
    private ErrorDialog errorDialog;
    Button fb;
    String fbEmail;
    TextView fbTitle;
    Typeface font;
    Button forget;
    Button gotoRegister;
    Button guest;
    public Uri imageUri;
    ImageView imageView;
    LinearLayout infoLinearLayout;
    ImageView line;
    Button login;
    String loginType;
    private ImageView login_service;
    LinearLayout otherLogin;
    EditText password;
    private QuestMainView questMainView;
    TextView title;
    LinearLayout titleLinearLayout;
    Button wechat;
    TextView wechatTitle;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws NoSuchAlgorithmException {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.sole_activity_login);
        getWindow().setSoftInputMode(2);
        this.callbackManager = CallbackManager.Factory.create();
        loginActivity = this;
        this.questMainView = (QuestMainView) findViewById(R.id.questMainView);
        this.errorDialog = (ErrorDialog) findViewById(R.id.errorDialog);
        this.login_service = (ImageView) findViewById(R.id.login_service);
        this.backgroundLayout = (RelativeLayout) findViewById(R.id.background_linearlayout);
        this.titleLinearLayout = (LinearLayout) findViewById(R.id.title_linearlayout);
        this.contentLinearLayout = (LinearLayout) findViewById(R.id.contentlinearlayout);
        this.otherLogin = (LinearLayout) findViewById(R.id.otherlogin);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.title = (TextView) findViewById(R.id.title);
        this.email = (EditText) findViewById(R.id.email);
        this.password = (EditText) findViewById(R.id.password);
        this.login = (Button) findViewById(R.id.login);
        this.forget = (Button) findViewById(R.id.forget);
        this.gotoRegister = (Button) findViewById(R.id.goto_register);
        this.fb = (Button) findViewById(R.id.fb);
        this.fbTitle = (TextView) findViewById(R.id.fb_title);
        this.wechat = (Button) findViewById(R.id.wechat);
        this.wechatTitle = (TextView) findViewById(R.id.wechat_title);
        this.guest = (Button) findViewById(R.id.guest);
        this.btncontent = (LinearLayout) findViewById(R.id.signup_btncontent);
        this.font = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLight.ttf");
        this.cloudApi = CloudApi.getInstance(this);
        this.dbManager = DbManager.getInstance(this);
        initPhone();
        printHashKey();
        initListener();
    }

    private void initListener() {
        this.login_service.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.LoginActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoginActivity.this.showMessageDialog("");
            }
        });
        this.gotoRegister.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.LoginActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "login_regist_btn", ErrorLogSave.CLICK);
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, Register_Step1_Activity.class);
                LoginActivity.this.startActivity(intent);
                LoginActivity.this.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
            }
        });
        this.forget.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.LoginActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "login_forgetPwd_btn", ErrorLogSave.CLICK);
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, Login_Forget_Activity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
        this.login.setOnClickListener(new AnonymousClass4());
        this.guest.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.LoginActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "login_guest_btn", ErrorLogSave.CLICK);
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, Login_Guest_Activity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
        this.fb.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.LoginActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws FacebookException {
                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "login_fblogin_btn", ErrorLogSave.CLICK);
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile", "email"));
            }
        });
        this.fbTitle.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.LoginActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws FacebookException {
                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "login_fblogin_btn", ErrorLogSave.CLICK);
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile", "email"));
            }
        });
        LoginManager.getInstance().registerCallback(this.callbackManager, new AnonymousClass8());
        this.wechat.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.LoginActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "login_wechartlogin_btn", ErrorLogSave.CLICK);
                SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "dyaco_home";
                LogoActivity.wechat_api.sendReq(req);
                Logger.d("wechat = " + req);
            }
        });
        this.wechatTitle.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.LoginActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "login_wechartlogin_btn", ErrorLogSave.CLICK);
                SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "dyaco_home";
                LogoActivity.wechat_api.sendReq(req);
                Logger.d("wechat = " + req);
            }
        });
    }

    /* renamed from: com.dyaco.sole.activity.LoginActivity$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "login_login_btn", "input_email:" + ((Object) LoginActivity.this.email.getText()) + "_pwd:" + ((Object) LoginActivity.this.password.getText()));
            LoginActivity loginActivity = LoginActivity.this;
            if (loginActivity.isEmailFormat(loginActivity.email)) {
                if (LoginActivity.this.password.getText().length() >= 6 && LoginActivity.this.password.getText().length() <= 20) {
                    LoginActivity.this.email.setBackgroundResource(R.drawable.signup_sole_button_a);
                    LoginActivity.this.password.setBackgroundResource(R.drawable.signup_sole_button_a);
                    LoginActivity.this.loginType = "NORMAL";
                    LoginActivity.this.cloudApi.setMemberLoginListener(new MemberLoginListener() { // from class: com.dyaco.sole.activity.LoginActivity.4.1
                        @Override // com.digifly.cloudapi.listener.MemberLoginListener
                        public void onSuccess(final MemberData memberData) {
                            LoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LoginActivity.4.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    LoginActivity.this.saveData(LoginActivity.this.email.getText().toString(), LoginActivity.this.password.getText().toString(), LoginActivity.this.loginType);
                                    memberData.setPassword(LoginActivity.this.password.getText().toString());
                                    MemberDataDao memberDataDao = DbManager.getMemberDataDao();
                                    QueryBuilder<MemberData> queryBuilder = memberDataDao.queryBuilder();
                                    queryBuilder.where(MemberDataDao.Properties.Account.eq(memberData.getAccount()), new WhereCondition[0]);
                                    List<MemberData> list = queryBuilder.list();
                                    if (list != null && list.size() == 0) {
                                        memberDataDao.insert(memberData);
                                    } else {
                                        list.get(0).setName(memberData.getName());
                                        list.get(0).setEmail(memberData.getEmail());
                                        list.get(0).setSex(memberData.getSex());
                                        list.get(0).setBirthday(memberData.getBirthday());
                                        list.get(0).setHeight(memberData.getHeight());
                                        list.get(0).setWeight(memberData.getWeight());
                                        list.get(0).setUnit_type(memberData.getUnit_type());
                                        memberDataDao.update(list.get(0));
                                    }
                                    QueryBuilder<MemberData> queryBuilder2 = memberDataDao.queryBuilder();
                                    queryBuilder2.where(MemberDataDao.Properties.Account.eq(memberData.getAccount()), new WhereCondition[0]);
                                    List<MemberData> list2 = queryBuilder2.list();
                                    list2.get(0).setPassword(LoginActivity.this.password.getText().toString());
                                    memberDataDao.update(list2.get(0));
                                    Global.userName = memberData.getAccount();
                                    Global.calendarUserName = memberData.getAccount();
                                    Global.memberData = memberData;
                                    ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "login_login_btn", "login_success_user_name:" + Global.userName);
                                    LoginActivity.this.updateLOginInfoToCloud(LoginActivity.this.email.getText().toString(), LoginActivity.this.password.getText().toString());
                                    LoginActivity.this.goMain();
                                }
                            });
                        }

                        @Override // com.digifly.cloudapi.listener.MemberLoginListener
                        public void onFail(final ResponseMessage responseMessage) {
                            LoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LoginActivity.4.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "login_login_btn", "login_fail_" + responseMessage);
                                    Toast.makeText(LoginActivity.this, responseMessage.getMessage(), 1).show();
                                    LoginActivity.this.showErrorLog(R.string.error_0002, ErrorLogSave.ERROR_0002);
                                }
                            });
                        }

                        @Override // com.digifly.cloudapi.listener.MemberLoginListener
                        public void onError(final String str) {
                            LoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LoginActivity.4.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "login_login_btn", "login_error_" + str);
                                    Toast.makeText(LoginActivity.this, str, 1).show();
                                    LoginActivity.this.showErrorLog(R.string.error_0002, ErrorLogSave.ERROR_0002);
                                }
                            });
                        }
                    });
                    LoginActivity.this.cloudApi.callMemberLogin(LoginActivity.this.email.getText().toString(), LoginActivity.this.password.getText().toString(), LoginActivity.this.loginType);
                    return;
                }
                if (LoginActivity.this.password.getText().length() < 6) {
                    ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.INPUT, "login_login_btn", "input_err_pwd<6:" + ((Object) LoginActivity.this.password.getText()));
                    LoginActivity.this.email.setBackgroundResource(R.drawable.signup_sole_button_a);
                    LoginActivity.this.password.setBackgroundResource(R.drawable.signup_sole_button_b);
                    LoginActivity.this.password.requestFocus();
                    Toast.makeText(LoginActivity.this, R.string.login_password_too_short, 0).show();
                    return;
                }
                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.INPUT, "login_login_btn", "input_err_pwd>20:" + ((Object) LoginActivity.this.password.getText()));
                LoginActivity.this.email.setBackgroundResource(R.drawable.signup_sole_button_a);
                LoginActivity.this.password.setBackgroundResource(R.drawable.signup_sole_button_b);
                LoginActivity.this.password.requestFocus();
                Toast.makeText(LoginActivity.this, R.string.login_password_too_long, 0).show();
                return;
            }
            if (LoginActivity.this.password.getText().length() >= 6 && LoginActivity.this.password.getText().length() <= 20) {
                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.INPUT, "login_login_btn", "input_err_email:" + ((Object) LoginActivity.this.email.getText()));
                LoginActivity.this.email.setBackgroundResource(R.drawable.signup_sole_button_b);
                LoginActivity.this.password.setBackgroundResource(R.drawable.signup_sole_button_a);
                LoginActivity.this.email.requestFocus();
                Toast.makeText(LoginActivity.this, R.string.longin_email_format_err, 0).show();
                return;
            }
            if (LoginActivity.this.password.getText().length() < 6) {
                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.INPUT, "login_login_btn", "input_err_email:" + ((Object) LoginActivity.this.email.getText()) + "_pwd:" + ((Object) LoginActivity.this.password.getText()));
                LoginActivity.this.email.setBackgroundResource(R.drawable.signup_sole_button_b);
                LoginActivity.this.password.setBackgroundResource(R.drawable.signup_sole_button_b);
                LoginActivity.this.email.requestFocus();
                Toast.makeText(LoginActivity.this, R.string.login_password_email_pwd_format_err, 0).show();
                return;
            }
            ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.INPUT, "login_login_btn", "input_err2_email:" + ((Object) LoginActivity.this.email.getText()) + "_pwd:" + ((Object) LoginActivity.this.password.getText()));
            LoginActivity.this.email.setBackgroundResource(R.drawable.signup_sole_button_b);
            LoginActivity.this.password.setBackgroundResource(R.drawable.signup_sole_button_b);
            LoginActivity.this.email.requestFocus();
            Toast.makeText(LoginActivity.this, R.string.login_password_email_pwd_format_err, 0).show();
        }
    }

    /* renamed from: com.dyaco.sole.activity.LoginActivity$8, reason: invalid class name */
    class AnonymousClass8 implements FacebookCallback<LoginResult> {
        AnonymousClass8() {
        }

        @Override // com.facebook.FacebookCallback
        public void onSuccess(LoginResult loginResult) {
            LoginActivity.this.accessToken = loginResult.getAccessToken();
            GraphRequest graphRequestNewMeRequest = GraphRequest.newMeRequest(LoginActivity.this.accessToken, new AnonymousClass1());
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id,email");
            graphRequestNewMeRequest.setParameters(bundle);
            graphRequestNewMeRequest.executeAsync();
        }

        /* renamed from: com.dyaco.sole.activity.LoginActivity$8$1, reason: invalid class name */
        class AnonymousClass1 implements GraphRequest.GraphJSONObjectCallback {
            AnonymousClass1() {
            }

            @Override // com.facebook.GraphRequest.GraphJSONObjectCallback
            public void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
                LoginActivity.this.fbEmail = jSONObject.optString("email");
                if (LoginActivity.this.fbEmail == null || LoginActivity.this.fbEmail.equals("")) {
                    LoginActivity.this.fbEmail = jSONObject.optString("id") + "@facebook";
                }
                LoginActivity.this.loginType = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                LoginActivity.this.saveData(LoginActivity.this.fbEmail, "      ", LoginActivity.this.loginType);
                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "login_fblogin_btn", "execute_Get_Success_email:" + LoginActivity.this.fbEmail);
                LoginActivity.this.cloudApi.setMemberLoginListener(new MemberLoginListener() { // from class: com.dyaco.sole.activity.LoginActivity.8.1.1
                    @Override // com.digifly.cloudapi.listener.MemberLoginListener
                    public void onSuccess(final MemberData memberData) {
                        LoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LoginActivity.8.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MemberDataDao memberDataDao = DbManager.getMemberDataDao();
                                QueryBuilder<MemberData> queryBuilder = memberDataDao.queryBuilder();
                                queryBuilder.where(MemberDataDao.Properties.Account.eq(memberData.getAccount()), new WhereCondition[0]);
                                List<MemberData> list = queryBuilder.list();
                                if (list != null && list.size() == 0) {
                                    memberDataDao.insert(memberData);
                                } else {
                                    list.get(0).setName(memberData.getName());
                                    list.get(0).setEmail(memberData.getEmail());
                                    list.get(0).setSex(memberData.getSex());
                                    list.get(0).setBirthday(memberData.getBirthday());
                                    list.get(0).setHeight(memberData.getHeight());
                                    list.get(0).setWeight(memberData.getWeight());
                                    list.get(0).setUnit_type(memberData.getUnit_type());
                                    memberDataDao.update(list.get(0));
                                }
                                QueryBuilder<MemberData> queryBuilder2 = memberDataDao.queryBuilder();
                                queryBuilder2.where(MemberDataDao.Properties.Account.eq(memberData.getAccount()), new WhereCondition[0]);
                                List<MemberData> list2 = queryBuilder2.list();
                                list2.get(0).setPassword("      ");
                                memberDataDao.update(list2.get(0));
                                Global.userName = memberData.getAccount();
                                Global.calendarUserName = memberData.getAccount();
                                Global.memberData = memberData;
                                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "login_fblogin_btn", "execute_Success_user_name:" + Global.userName);
                                LoginActivity.this.goMain();
                            }
                        });
                    }

                    @Override // com.digifly.cloudapi.listener.MemberLoginListener
                    public void onFail(final ResponseMessage responseMessage) {
                        LoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LoginActivity.8.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "login_fblogin_btn", "execute_Fail:" + responseMessage.getMessage());
                                if (responseMessage.toString().equals("-3")) {
                                    Toast.makeText(LoginActivity.this, R.string.login_hint_fb_acc_can_not_login, 1).show();
                                }
                                Toast.makeText(LoginActivity.this, responseMessage.getMessage(), 1).show();
                            }
                        });
                        LoginActivity.this.showErrorLog(R.string.error_0002, ErrorLogSave.ERROR_0002);
                    }

                    @Override // com.digifly.cloudapi.listener.MemberLoginListener
                    public void onError(final String str) {
                        LoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LoginActivity.8.1.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "login_fblogin_btn", "execute_Err:" + str);
                                Toast.makeText(LoginActivity.this, str, 1).show();
                            }
                        });
                        LoginActivity.this.showErrorLog(R.string.error_0002, ErrorLogSave.ERROR_0002);
                    }
                });
                LoginActivity.this.cloudApi.callMemberLogin(LoginActivity.this.fbEmail, "      ", LoginActivity.this.loginType);
            }
        }

        @Override // com.facebook.FacebookCallback
        public void onCancel() {
            ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "login_fblogin_btn", "execute_CANCEL");
            Log.v("skypoo", "CANCEL");
        }

        @Override // com.facebook.FacebookCallback
        public void onError(FacebookException facebookException) {
            ErrorLogSave.addErrorString(LoginActivity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "login_fblogin_btn", "execute_Err:" + facebookException.toString());
            Log.v("skypoo", "登入失敗:" + facebookException.toString());
            LoginActivity.this.showErrorLog(R.string.error_0002, ErrorLogSave.ERROR_0002);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMessageDialog(String str) {
        ErrorLogSave.sendErrorList(this.questMainView.getAccount(), getApplicationContext());
        this.questMainView.showQA(QuestMainView.LOGIN, str);
        this.questMainView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorLog(final int i, final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LoginActivity.11
            @Override // java.lang.Runnable
            public void run() {
                LoginActivity.this.errorDialog.setVisibility(0);
                LoginActivity.this.errorDialog.initView(LoginActivity.this.getString(i), new View.OnClickListener() { // from class: com.dyaco.sole.activity.LoginActivity.11.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LoginActivity.this.showMessageDialog(str);
                    }
                }, new View.OnClickListener() { // from class: com.dyaco.sole.activity.LoginActivity.11.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LoginActivity.this.errorDialog.setVisibility(8);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLOginInfoToCloud(String str, String str2) {
        DCLoginInfoData dCLoginInfoData = new DCLoginInfoData();
        dCLoginInfoData.setAccount(str);
        dCLoginInfoData.setPassword(str2);
        dCLoginInfoData.setLogin_model_code("DYACO_HOMEAPP");
        Calendar calendar = Calendar.getInstance();
        String calendarFormat = CalendarUtils.getCalendarFormat(calendar.getTime(), CalendarUtils.SQL_DATE_TIME_FORMAT);
        Calendar calendar2 = Calendar.getInstance(getLocale());
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        int i = ((calendar2.get(15) / 1000) / 60) / 60;
        dCLoginInfoData.setLogin_time(calendarFormat);
        dCLoginInfoData.setLogin_timezone_hour(i);
        dCLoginInfoData.setLogin_timezone_name(calendar2.getTimeZone().getID());
        dCLoginInfoData.setDevice_os_name("Android");
        dCLoginInfoData.setDevice_os_version(Build.VERSION.RELEASE);
        dCLoginInfoData.setDevice_model(Build.BRAND);
        dCLoginInfoData.setDevice_sno(Build.SERIAL);
        this.cloudApi.setDCLoginInfoListener(new DCLoginInfoListener() { // from class: com.dyaco.sole.activity.LoginActivity.12
            @Override // com.digifly.cloudapi.listener.DCLoginInfoListener
            public void onSuccess(ResponseDataCollection responseDataCollection) {
                Log.d(LoginActivity.TAG, "responseMessage = " + responseDataCollection);
            }

            @Override // com.digifly.cloudapi.listener.DCLoginInfoListener
            public void onFail(ResponseDataCollection responseDataCollection) {
                Log.d(LoginActivity.TAG, "onFail responseMessage = " + responseDataCollection);
            }

            @Override // com.digifly.cloudapi.listener.DCLoginInfoListener
            public void onError(String str3) {
                Log.d(LoginActivity.TAG, "err = " + str3);
            }
        });
        this.cloudApi.callDCLoginInfo(dCLoginInfoData);
    }

    private Locale getLocale() {
        Resources resources = getResources();
        resources.getDisplayMetrics();
        return resources.getConfiguration().locale;
    }

    public void showCameraDialog() {
        new AlertDialog.Builder(this, R.style.myDialog).setSingleChoiceItems(new String[]{"Camera", "Album"}, -1, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.LoginActivity.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("description", "Image capture by camera");
                    contentValues.put("mime_type", "image/jpeg");
                    LoginActivity loginActivity2 = LoginActivity.this;
                    loginActivity2.imageUri = loginActivity2.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", LoginActivity.this.imageUri);
                    intent.putExtra("android.intent.extra.videoQuality", 1);
                    LoginActivity.this.startActivityForResult(intent, 66);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setType("image/*");
                    intent2.setAction("android.intent.action.PICK");
                    LoginActivity.this.startActivityForResult(Intent.createChooser(intent2, "Choose Image File"), 67);
                }
                dialogInterface.dismiss();
            }
        }).show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 66 || i == 67) {
            final Uri data = i == 66 ? this.imageUri : null;
            if (i == 67 && intent != null) {
                Log.d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                data = intent.getData();
            }
            if (data != null) {
                Log.d(TAG, "uri:" + data.getPath());
                runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LoginActivity.14
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(LoginActivity.this.getContentResolver(), data);
                            File file = new File(LoginActivity.this.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                LoginActivity.this.questMainView.upLoadImg(new File(file.getPath()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e2) {
                            Log.e("uploadImg", "bitmapEr : " + e2.toString());
                        }
                    }
                });
            }
        }
        this.callbackManager.onActivityResult(i, i2, intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        String string = getSharedPreferences("DATA", 0).getString(MessageDB.ACCOUNT, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Log.d("TOM DEBUG", "TYPE:" + string);
        if (string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            this.email.requestFocus();
            return;
        }
        readData();
        QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
        queryBuilder.where(MemberDataDao.Properties.Account.eq(this.email.getText().toString()), new WhereCondition[0]);
        List<MemberData> list = queryBuilder.list();
        if (list != null && list.size() > 0) {
            MemberData memberData = list.get(0);
            Global.userName = memberData.getAccount();
            Global.calendarUserName = memberData.getAccount();
            Global.memberData = memberData;
            goMain();
            return;
        }
        this.cloudApi.setMemberLoginListener(new MemberLoginListener() { // from class: com.dyaco.sole.activity.LoginActivity.15
            @Override // com.digifly.cloudapi.listener.MemberLoginListener
            public void onSuccess(final MemberData memberData2) {
                LoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LoginActivity.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.v("skypoo", "Login data:" + memberData2.toString());
                        memberData2.setPassword(LoginActivity.this.password.getText().toString());
                        MemberDataDao memberDataDao = DbManager.getMemberDataDao();
                        QueryBuilder<MemberData> queryBuilder2 = memberDataDao.queryBuilder();
                        queryBuilder2.where(MemberDataDao.Properties.Account.eq(memberData2.getAccount()), new WhereCondition[0]);
                        List<MemberData> list2 = queryBuilder2.list();
                        if (list2 != null && list2.size() == 0) {
                            memberDataDao.insert(memberData2);
                        } else {
                            list2.get(0).setName(memberData2.getName());
                            list2.get(0).setEmail(memberData2.getEmail());
                            list2.get(0).setSex(memberData2.getSex());
                            list2.get(0).setBirthday(memberData2.getBirthday());
                            list2.get(0).setHeight(memberData2.getHeight());
                            list2.get(0).setWeight(memberData2.getWeight());
                            list2.get(0).setUnit_type(memberData2.getUnit_type());
                            memberDataDao.update(list2.get(0));
                        }
                        QueryBuilder<MemberData> queryBuilder3 = memberDataDao.queryBuilder();
                        queryBuilder3.where(MemberDataDao.Properties.Account.eq(memberData2.getAccount()), new WhereCondition[0]);
                        List<MemberData> list3 = queryBuilder3.list();
                        list3.get(0).setPassword(LoginActivity.this.password.getText().toString());
                        memberDataDao.update(list3.get(0));
                        Global.userName = memberData2.getAccount();
                        Global.calendarUserName = memberData2.getAccount();
                        Global.memberData = memberData2;
                        LoginActivity.this.goMain();
                    }
                });
            }

            @Override // com.digifly.cloudapi.listener.MemberLoginListener
            public void onFail(final ResponseMessage responseMessage) {
                LoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LoginActivity.15.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(LoginActivity.this, responseMessage.getMessage(), 1).show();
                    }
                });
                LoginActivity.this.showErrorLog(R.string.error_0002, ErrorLogSave.ERROR_0002);
            }

            @Override // com.digifly.cloudapi.listener.MemberLoginListener
            public void onError(final String str) {
                LoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LoginActivity.15.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(LoginActivity.this, str, 1).show();
                    }
                });
                LoginActivity.this.showErrorLog(R.string.error_0002, ErrorLogSave.ERROR_0002);
            }
        });
        this.cloudApi.callMemberLogin(this.email.getText().toString(), this.password.getText().toString(), this.loginType);
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
            this.titleLinearLayout.setLayoutParams(layoutParams);
            if (Global.BRAND == 1) {
                this.backgroundLayout.setBackgroundColor(-1);
            }
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i2;
            layoutParams2.height = i;
            this.titleLinearLayout.setLayoutParams(layoutParams2);
            this.titleLinearLayout.setBackgroundResource(R.drawable.main2);
            if (Global.BRAND == 1) {
                this.titleLinearLayout.setBackgroundResource(R.drawable.main3);
                this.backgroundLayout.setBackgroundColor(-1);
            }
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.contentLinearLayout.setX(0.0f);
        int i3 = (int) ((460.0f * f) + 0.5d);
        layoutParams3.height = i3;
        layoutParams3.width = (int) ((500.0f * f4) + 0.5d);
        this.contentLinearLayout.setLayoutParams(layoutParams3);
        this.contentLinearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        this.imageView.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.imageView.getLayoutParams();
        layoutParams5.height = i3;
        layoutParams5.width = (int) ((280.0f * f4) + 0.5d);
        this.imageView.setLayoutParams(layoutParams5);
        if (isPad(this)) {
            layoutParams4.topMargin = (int) (f * 20.0f);
            layoutParams4.leftMargin = (int) (20.0f * f4);
        }
        this.title.setLayoutParams((LinearLayout.LayoutParams) this.title.getLayoutParams());
        this.title.setY(44.0f * f);
        this.title.setTypeface(this.font);
        this.gotoRegister.setLayoutParams(new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 210.0f, getResources().getDisplayMetrics()), -2));
        this.gotoRegister.setGravity(5);
        this.gotoRegister.setY(64.0f * f);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.gotoRegister.getLayoutParams();
        int i4 = (int) ((f * 30.0f) + 0.5d);
        layoutParams6.height = i4;
        int i5 = (int) ((230.0f * f4) + 0.5d);
        layoutParams6.width = i5;
        this.gotoRegister.setLayoutParams(layoutParams6);
        this.email.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.email.setY(f * 80.0f);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.email.getLayoutParams();
        layoutParams7.width = i5;
        int i6 = (int) ((40.0f * f) + 0.5d);
        layoutParams7.height = i6;
        this.email.setLayoutParams(layoutParams7);
        this.password.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.password.setY(f * 100.0f);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.password.getLayoutParams();
        layoutParams8.width = i5;
        layoutParams8.height = i6;
        this.password.setLayoutParams(layoutParams7);
        this.login.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.login.setY(120.0f * f);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.login.getLayoutParams();
        layoutParams9.height = i6;
        layoutParams9.width = i5;
        this.login.setLayoutParams(layoutParams9);
        this.otherLogin.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.otherLogin.setY(140.0f * f);
        this.fb.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) this.fb.getLayoutParams();
        layoutParams10.height = i4;
        float f5 = 30.0f * f4;
        int i7 = (int) (f5 + 0.5d);
        layoutParams10.width = i7;
        this.fb.setLayoutParams(layoutParams10);
        this.wechat.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) this.wechat.getLayoutParams();
        layoutParams11.height = i4;
        layoutParams11.width = i7;
        this.wechat.setLayoutParams(layoutParams10);
        this.btncontent.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.btncontent.setY(f * 150.0f);
        this.forget.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.forget.setX(f5);
        LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) this.forget.getLayoutParams();
        layoutParams12.height = i4;
        layoutParams12.width = (int) ((f4 * 80.0f) + 0.5d);
        this.forget.setLayoutParams(layoutParams12);
        this.guest.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.guest.setX(300.0f * f4);
        LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) this.guest.getLayoutParams();
        layoutParams13.height = i6;
        layoutParams13.width = (int) ((f4 * 100.0f) + 0.5d);
        this.guest.setLayoutParams(layoutParams13);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void saveData(String str, String str2, String str3) {
        getSharedPreferences("DATA", 0).edit().putString(MessageDB.ACCOUNT, str).putString("password", str2).putString("type", str3).commit();
    }

    private void readData() {
        SharedPreferences sharedPreferences = getSharedPreferences("DATA", 0);
        this.email.setText(sharedPreferences.getString(MessageDB.ACCOUNT, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        this.password.setText(sharedPreferences.getString("password", ""));
        this.loginType = sharedPreferences.getString("type", "");
    }

    public void printHashKey() throws NoSuchAlgorithmException {
        try {
            for (Signature signature : getPackageManager().getPackageInfo(BuildConfig.APPLICATION_ID, 64).signatures) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                new String(Base64.encode(messageDigest.digest(), 0));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Logger.d("KeyResult  name not found = " + e);
        } catch (NoSuchAlgorithmException e2) {
            Logger.d("KeyResult no  an algorithm = " + e2);
        } catch (Exception e3) {
            Logger.d("KeyResult  exception = " + e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goMain() {
        boolean booleanExtra = getIntent().getBooleanExtra("restart", false);
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("restart", booleanExtra);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        finish();
    }
}
