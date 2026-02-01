package com.dyaco.sole.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.ResponseMessage;
import com.digifly.cloudapi.listener.MemberLoginListener;
import com.digifly.cloudapi.listener.MemberRegistListener;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom_view.ErrorDialog;
import com.dyaco.sole.custom_view.QuestMainView;
import com.dyaco.sole.database.MessageDB;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.github.gzuliyujiang.wheelpicker.LinkagePicker;
import com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider;
import com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes.dex */
public class Register_Step3_Activity extends AppCompatActivity {
    private static final int CAMERA = 66;
    private static final int PHOTO = 67;
    private static final String TAG = "Register_Step3_Activity";
    Button back;
    LinearLayout btncontent;
    private CloudApi cloudApi;
    private DbManager dbManager;
    Button done;
    private ErrorDialog errorDialog;
    Typeface font;
    TextView height;
    private String heightUnitType;
    public Uri imageUri;
    Button imperial;
    LinearLayout mainLayout;
    MemberData memberData = new MemberData();
    private String password;
    private QuestMainView questMainView;
    RelativeLayout registerBackgroundLayout;
    LinearLayout registerContentLayout;
    ImageView registerImageView;
    TextView registerTitle;
    ImageView stageImage;
    TextView weight;
    private String weightUnitType;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        int i = Global.BRAND;
        if (i == 0) {
            setContentView(R.layout.activity_register_step3);
            this.questMainView = (QuestMainView) findViewById(R.id.questMainView);
            this.errorDialog = (ErrorDialog) findViewById(R.id.errorDialog);
        } else if (i == 1) {
            setContentView(R.layout.spirit_activity_register_step3);
        } else if (i == 2) {
            setContentView(R.layout.xterra_activity_register_step3);
        } else if (i == 3) {
            setContentView(R.layout.fuel_activity_register_step3);
        }
        getWindow().setSoftInputMode(2);
        this.cloudApi = CloudApi.getInstance(this);
        this.dbManager = DbManager.getInstance(this);
        this.registerBackgroundLayout = (RelativeLayout) findViewById(R.id.register3_background_layout);
        this.mainLayout = (LinearLayout) findViewById(R.id.register3_main_layout);
        this.registerContentLayout = (LinearLayout) findViewById(R.id.register3_content_layout);
        this.registerImageView = (ImageView) findViewById(R.id.register3_imageView);
        this.stageImage = (ImageView) findViewById(R.id.register3_stage_image);
        this.registerTitle = (TextView) findViewById(R.id.register3_title);
        this.height = (TextView) findViewById(R.id.register3_height);
        this.weight = (TextView) findViewById(R.id.register3_weight);
        this.done = (Button) findViewById(R.id.register3_done);
        this.back = (Button) findViewById(R.id.register3_back);
        this.btncontent = (LinearLayout) findViewById(R.id.register3_btncontent);
        this.font = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLight.ttf");
        initPhone();
        this.height.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Register_Step3_Activity.this.onHeightLinkagePicker();
            }
        });
        this.weight.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Register_Step3_Activity.this.onWeightLinkagePicker();
            }
        });
        this.done.setOnClickListener(new AnonymousClass3());
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(Register_Step3_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "regist3_back_btn", ErrorLogSave.CLICK);
                ArrayList<String> stringArrayList = Register_Step3_Activity.this.getIntent().getExtras().getStringArrayList("data");
                Intent intent = new Intent();
                intent.setClass(Register_Step3_Activity.this, Register_Step2_Activity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("data", stringArrayList);
                intent.putExtras(bundle2);
                Register_Step3_Activity.this.startActivity(intent);
                Register_Step3_Activity.this.finish();
            }
        });
    }

    /* renamed from: com.dyaco.sole.activity.Register_Step3_Activity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ErrorLogSave.addErrorString(Register_Step3_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "regist3_done_btn", ErrorLogSave.CLICK);
            ArrayList<String> stringArrayList = Register_Step3_Activity.this.getIntent().getExtras().getStringArrayList("data");
            if ("".equals(Register_Step3_Activity.this.height.getText().toString())) {
                Register_Step3_Activity.this.memberData.setHeight(165);
                Register_Step3_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                Register_Step3_Activity.this.heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if ("".equals(Register_Step3_Activity.this.weight.getText().toString())) {
                Register_Step3_Activity.this.memberData.setWeight(60);
                Register_Step3_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                Register_Step3_Activity.this.weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if (!Register_Step3_Activity.this.heightUnitType.equals(Register_Step3_Activity.this.weightUnitType)) {
                Register_Step3_Activity.this.height.setBackgroundResource(R.drawable.signup_sole_button_b);
                Register_Step3_Activity.this.weight.setBackgroundResource(R.drawable.signup_sole_button_b);
                Toast.makeText(Register_Step3_Activity.this, R.string.login_unit_must_be_same, 1).show();
                return;
            }
            Register_Step3_Activity.this.password = stringArrayList.get(1);
            Register_Step3_Activity.this.memberData.setAccount(stringArrayList.get(0));
            Register_Step3_Activity.this.memberData.setPassword(Register_Step3_Activity.this.password);
            Register_Step3_Activity.this.memberData.setName(stringArrayList.get(2));
            Register_Step3_Activity.this.memberData.setEmail(stringArrayList.get(0));
            Register_Step3_Activity.this.memberData.setSex(stringArrayList.get(3));
            Register_Step3_Activity.this.memberData.setBirthday(stringArrayList.get(4));
            Register_Step3_Activity.this.memberData.setRegist_type("NORMAL");
            Logger.d("data = " + stringArrayList);
            Register_Step3_Activity.this.cloudApi.setMemberRegistListener(new AnonymousClass1());
            Register_Step3_Activity.this.cloudApi.callMemberRegist(Register_Step3_Activity.this.memberData);
        }

        /* renamed from: com.dyaco.sole.activity.Register_Step3_Activity$3$1, reason: invalid class name */
        class AnonymousClass1 implements MemberRegistListener {
            AnonymousClass1() {
            }

            /* renamed from: com.dyaco.sole.activity.Register_Step3_Activity$3$1$1, reason: invalid class name and collision with other inner class name */
            class RunnableC00261 implements Runnable {
                final /* synthetic */ MemberData val$registerData;

                RunnableC00261(MemberData memberData) {
                    this.val$registerData = memberData;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Log.v("skypoo", "Register onSuccess:" + this.val$registerData.toString());
                    Toast.makeText(Register_Step3_Activity.this, R.string.login_reg_susscess, 1).show();
                    ErrorLogSave.addErrorString(Register_Step3_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "regist3_done_btn", "regist3_regist_success");
                    Register_Step3_Activity.this.cloudApi.callMemberLogin(this.val$registerData.getAccount(), Register_Step3_Activity.this.password, this.val$registerData.getRegist_type());
                    Register_Step3_Activity.this.cloudApi.setMemberLoginListener(new MemberLoginListener() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.3.1.1.1
                        @Override // com.digifly.cloudapi.listener.MemberLoginListener
                        public void onSuccess(final MemberData memberData) {
                            Register_Step3_Activity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.3.1.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Log.v("skypoo", "Login data:" + memberData.toString());
                                    Register_Step3_Activity.this.saveData(memberData.getAccount(), Register_Step3_Activity.this.password, memberData.getRegist_type());
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
                                    list2.get(0).setPassword(Register_Step3_Activity.this.password);
                                    memberDataDao.update(list2.get(0));
                                    Global.userName = memberData.getAccount();
                                    Global.calendarUserName = memberData.getAccount();
                                    Global.memberData = memberData;
                                    ErrorLogSave.addErrorString(Register_Step3_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "regist3_done_btn", "regist3_login_success");
                                    if (!Register_Step1_Activity.register.isFinishing()) {
                                        Register_Step1_Activity.register.finish();
                                    } else if (!Register_Step2_Activity.register2.isFinishing()) {
                                        Register_Step2_Activity.register2.finish();
                                    } else if (!LoginActivity.loginActivity.isFinishing()) {
                                        LoginActivity.loginActivity.finish();
                                    }
                                    Register_Step3_Activity.this.finish();
                                    Register_Step3_Activity.this.goMain();
                                }
                            });
                        }

                        @Override // com.digifly.cloudapi.listener.MemberLoginListener
                        public void onFail(final ResponseMessage responseMessage) {
                            ErrorLogSave.addErrorString(Register_Step3_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "regist3_done_btn", "regist3_login_fail:" + responseMessage.getMessage());
                            Register_Step3_Activity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.3.1.1.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(Register_Step3_Activity.this, responseMessage.toString(), 1).show();
                                }
                            });
                            Register_Step3_Activity.this.showErrorLog(R.string.error_0002, ErrorLogSave.ERROR_0002);
                        }

                        @Override // com.digifly.cloudapi.listener.MemberLoginListener
                        public void onError(final String str) {
                            ErrorLogSave.addErrorString(Register_Step3_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "regist3_done_btn", "regist3_login_err:" + str);
                            Register_Step3_Activity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.3.1.1.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(Register_Step3_Activity.this, str, 1).show();
                                }
                            });
                            Register_Step3_Activity.this.showErrorLog(R.string.error_0002, ErrorLogSave.ERROR_0002);
                        }
                    });
                }
            }

            @Override // com.digifly.cloudapi.listener.MemberRegistListener
            public void onSuccess(MemberData memberData) {
                Register_Step3_Activity.this.runOnUiThread(new RunnableC00261(memberData));
            }

            @Override // com.digifly.cloudapi.listener.MemberRegistListener
            public void onFail(final ResponseMessage responseMessage) {
                Register_Step3_Activity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.3.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.v("skypoo", "onFail:" + responseMessage.toString());
                        ErrorLogSave.addErrorString(Register_Step3_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "regist3_done_btn", "regist3_regist_fail:" + responseMessage.getMessage());
                        Toast.makeText(Register_Step3_Activity.this, responseMessage.getMessage(), 0).show();
                    }
                });
                Register_Step3_Activity.this.showErrorLog(R.string.error_0003, ErrorLogSave.ERROR_0003);
            }

            @Override // com.digifly.cloudapi.listener.MemberRegistListener
            public void onError(final String str) {
                Register_Step3_Activity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.3.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ErrorLogSave.addErrorString(Register_Step3_Activity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "regist3_done_btn", "regist3_regist_err:" + str);
                        Log.v("skypoo", "onError:" + str);
                        Toast.makeText(Register_Step3_Activity.this, str, 0).show();
                    }
                });
                Register_Step3_Activity.this.showErrorLog(R.string.error_0003, ErrorLogSave.ERROR_0003);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        ArrayList<String> stringArrayList;
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras == null || (stringArrayList = extras.getStringArrayList("data")) == null || stringArrayList.size() < 7) {
            return;
        }
        Logger.d("data = " + stringArrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorLog(final int i, final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.5
            @Override // java.lang.Runnable
            public void run() {
                Register_Step3_Activity.this.errorDialog.setVisibility(0);
                Register_Step3_Activity.this.errorDialog.initView(Register_Step3_Activity.this.getString(i), new View.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ErrorLogSave.sendErrorList(Register_Step3_Activity.this.questMainView.getAccount(), Register_Step3_Activity.this.getApplicationContext());
                        Register_Step3_Activity.this.questMainView.showQA(QuestMainView.REGIST, str);
                        Register_Step3_Activity.this.questMainView.setVisibility(0);
                    }
                }, new View.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.5.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Register_Step3_Activity.this.errorDialog.setVisibility(8);
                    }
                });
            }
        });
    }

    public void showCameraDialog() {
        new AlertDialog.Builder(this, R.style.myDialog).setSingleChoiceItems(new String[]{"Camera", "Album"}, -1, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("description", "Image capture by camera");
                    contentValues.put("mime_type", "image/jpeg");
                    Register_Step3_Activity register_Step3_Activity = Register_Step3_Activity.this;
                    register_Step3_Activity.imageUri = register_Step3_Activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", Register_Step3_Activity.this.imageUri);
                    intent.putExtra("android.intent.extra.videoQuality", 1);
                    Register_Step3_Activity.this.startActivityForResult(intent, 66);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setType("image/*");
                    intent2.setAction("android.intent.action.PICK");
                    Register_Step3_Activity.this.startActivityForResult(Intent.createChooser(intent2, "Choose Image File"), 67);
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
                runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.7
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(Register_Step3_Activity.this.getContentResolver(), data);
                            File file = new File(Register_Step3_Activity.this.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                Register_Step3_Activity.this.questMainView.upLoadImg(new File(file.getPath()));
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
        layoutParams5.width = (int) ((160.0f * f4) + 0.5d);
        layoutParams5.height = (int) ((30.0f * f) + 0.5d);
        this.stageImage.setLayoutParams(layoutParams5);
        this.stageImage.setY(80.0f * f);
        this.height.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.height.setY(120.0f * f);
        this.height.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.height.getLayoutParams();
        int i4 = (int) ((40.0f * f) + 0.5d);
        layoutParams6.height = i4;
        int i5 = (int) ((230.0f * f4) + 0.5d);
        layoutParams6.width = i5;
        this.height.setLayoutParams(layoutParams6);
        this.weight.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.weight.setY(140.0f * f);
        this.weight.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.weight.getLayoutParams();
        layoutParams7.height = i4;
        layoutParams7.width = i5;
        this.weight.setLayoutParams(layoutParams7);
        Log.v("skypoo", "confirm:" + this.weight.getWidth());
        int i6 = layoutParams7.height + 20 + 130;
        this.done.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.done.setY(((float) i6) * f);
        this.done.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.done.getLayoutParams();
        layoutParams8.height = i4;
        layoutParams8.width = i5;
        Log.v("skypoo", "next:" + layoutParams8.weight);
        this.done.setLayoutParams(layoutParams8);
        this.btncontent.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.btncontent.setY(((float) (i6 + 20)) * f);
        this.back.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.back.setX(380.0f * f4);
        this.back.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.back.getLayoutParams();
        layoutParams9.height = i4;
        layoutParams9.width = (int) ((f4 * 100.0f) + 0.5d);
        this.back.setLayoutParams(layoutParams9);
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Register_Step3_Activity.this.onBackPressed();
            }
        });
    }

    public static boolean isPad(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public void onHeightLinkagePicker() {
        LinkageProvider linkageProvider = new LinkageProvider() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.9
            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public int findFirstIndex(Object obj) {
                return 0;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public int findSecondIndex(int i, Object obj) {
                return 0;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public int findThirdIndex(int i, int i2, Object obj) {
                return 0;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public boolean firstLevelVisible() {
                return true;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public boolean thirdLevelVisible() {
                return false;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public List<String> provideFirstData() {
                ArrayList arrayList = new ArrayList();
                arrayList.add("cm");
                arrayList.add("in");
                return arrayList;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public List<String> linkageSecondData(int i) {
                ArrayList arrayList = new ArrayList();
                if (i == 0) {
                    for (int i2 = 100; i2 <= 250; i2++) {
                        arrayList.add(String.valueOf(i2));
                    }
                } else {
                    for (int i3 = 40; i3 <= 100; i3++) {
                        arrayList.add(String.valueOf(i3));
                    }
                }
                return arrayList;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public List<String> linkageThirdData(int i, int i2) {
                return new ArrayList();
            }
        };
        LinkagePicker linkagePicker = new LinkagePicker(this) { // from class: com.dyaco.sole.activity.Register_Step3_Activity.10
            @Override // com.github.gzuliyujiang.wheelpicker.LinkagePicker, com.github.gzuliyujiang.dialog.ModalDialog
            protected View createBodyView() {
                View viewCreateBodyView = super.createBodyView();
                getFirstWheelView().setCyclicEnabled(false);
                getSecondWheelView().setCyclicEnabled(false);
                return viewCreateBodyView;
            }
        };
        linkagePicker.setData(linkageProvider);
        linkagePicker.setDefaultValue(linkageProvider.provideFirstData().get(0), linkageProvider.linkageSecondData(0).get(65), null);
        linkagePicker.setOnLinkagePickedListener(new OnLinkagePickedListener() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.11
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener
            public void onLinkagePicked(Object obj, Object obj2, Object obj3) throws NumberFormatException {
                if ((obj instanceof String) && (obj2 instanceof String)) {
                    Register_Step3_Activity.this.height.setText(obj2 + StringUtils.SPACE + obj);
                    if (obj.equals("cm")) {
                        Register_Step3_Activity.this.height.setText(obj2 + StringUtils.SPACE + Register_Step3_Activity.this.getString(R.string.login_cm));
                        int i = 0;
                        try {
                            i = Integer.parseInt((String) obj2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Register_Step3_Activity.this.memberData.setHeight(i);
                        Register_Step3_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        Register_Step3_Activity.this.heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        return;
                    }
                    float f = 0.0f;
                    try {
                        f = Float.parseFloat((String) obj2) * 2.54f;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    Register_Step3_Activity.this.height.setText(obj2 + StringUtils.SPACE + Register_Step3_Activity.this.getString(R.string.login_in));
                    Register_Step3_Activity.this.memberData.setHeight((int) (((double) f) + 0.5d));
                    Register_Step3_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    Register_Step3_Activity.this.heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                }
            }
        });
        linkagePicker.show();
    }

    public void onWeightLinkagePicker() {
        LinkageProvider linkageProvider = new LinkageProvider() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.12
            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public int findFirstIndex(Object obj) {
                return 0;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public int findSecondIndex(int i, Object obj) {
                return 0;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public int findThirdIndex(int i, int i2, Object obj) {
                return 0;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public boolean firstLevelVisible() {
                return true;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public boolean thirdLevelVisible() {
                return false;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public List<String> provideFirstData() {
                ArrayList arrayList = new ArrayList();
                arrayList.add("kg");
                arrayList.add("lb");
                return arrayList;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public List<String> linkageSecondData(int i) {
                ArrayList arrayList = new ArrayList();
                if (i == 0) {
                    for (int i2 = 30; i2 <= 180; i2++) {
                        arrayList.add(String.valueOf(i2));
                    }
                } else {
                    for (int i3 = 66; i3 <= 396; i3++) {
                        arrayList.add(String.valueOf(i3));
                    }
                }
                return arrayList;
            }

            @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
            public List<String> linkageThirdData(int i, int i2) {
                return new ArrayList();
            }
        };
        LinkagePicker linkagePicker = new LinkagePicker(this) { // from class: com.dyaco.sole.activity.Register_Step3_Activity.13
            @Override // com.github.gzuliyujiang.wheelpicker.LinkagePicker, com.github.gzuliyujiang.dialog.ModalDialog
            protected View createBodyView() {
                View viewCreateBodyView = super.createBodyView();
                getFirstWheelView().setCyclicEnabled(false);
                getSecondWheelView().setCyclicEnabled(false);
                return viewCreateBodyView;
            }
        };
        linkagePicker.setData(linkageProvider);
        linkagePicker.setDefaultValue(linkageProvider.provideFirstData().get(0), linkageProvider.linkageSecondData(0).get(30), null);
        linkagePicker.setOnLinkagePickedListener(new OnLinkagePickedListener() { // from class: com.dyaco.sole.activity.Register_Step3_Activity.14
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener
            public void onLinkagePicked(Object obj, Object obj2, Object obj3) throws NumberFormatException {
                if ((obj instanceof String) && (obj2 instanceof String)) {
                    Register_Step3_Activity.this.weight.setText(obj2 + StringUtils.SPACE + obj);
                    if (obj.equals("kg")) {
                        Register_Step3_Activity.this.weight.setText(obj2 + StringUtils.SPACE + Register_Step3_Activity.this.getString(R.string.login_kg));
                        int i = 0;
                        try {
                            i = Integer.parseInt((String) obj2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Register_Step3_Activity.this.memberData.setWeight(i);
                        Register_Step3_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        Register_Step3_Activity.this.weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        return;
                    }
                    float f = 0.0f;
                    try {
                        f = Float.parseFloat((String) obj2) * 0.454f;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    Register_Step3_Activity.this.weight.setText(obj2 + StringUtils.SPACE + Register_Step3_Activity.this.getString(R.string.login_lb));
                    Register_Step3_Activity.this.memberData.setWeight((int) (((double) f) + 0.5d));
                    Register_Step3_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    Register_Step3_Activity.this.weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                }
            }
        });
        linkagePicker.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveData(String str, String str2, String str3) {
        getSharedPreferences("DATA", 0).edit().putString(MessageDB.ACCOUNT, str).putString("password", str2).putString("type", str3).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goMain() {
        boolean booleanExtra = getIntent().getBooleanExtra("restart", false);
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setFlags(268468224);
        intent.putExtra("restart", booleanExtra);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        finish();
    }
}
