package com.dyaco.sole.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.R2;
import com.dyaco.sole.custom.Global;
import com.facebook.appevents.AppEventsConstants;
import com.github.gzuliyujiang.wheelpicker.LinkagePicker;
import com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider;
import com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener;
import com.soletreadmills.sole.R;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes.dex */
public class Login_Guest_Activity extends AppCompatActivity {
    public static final String GUEST = "Guest";
    Button back;
    LinearLayout btncontent;
    Button done;
    Typeface font;
    RelativeLayout guestBackgroundLayout;
    LinearLayout guestContentLayout;
    ImageView guestImageView;
    TextView guestTitle;
    TextView height;
    private String heightUnitType;
    Button imperial;
    LinearLayout mainLayout;
    MemberData memberData = new MemberData();
    TextView weight;
    private String weightUnitType;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        int i = Global.BRAND;
        if (i == 0) {
            setContentView(R.layout.activity_login_guest);
        } else if (i == 1) {
            setContentView(R.layout.spirit_activity_login_guest);
        } else if (i == 2) {
            setContentView(R.layout.xterra_activity_login_guest);
        } else if (i == 3) {
            setContentView(R.layout.fuel_activity_login_guest);
        }
        getWindow().setSoftInputMode(2);
        this.guestBackgroundLayout = (RelativeLayout) findViewById(R.id.guest_background_layout);
        this.mainLayout = (LinearLayout) findViewById(R.id.guest_main_layout);
        this.guestContentLayout = (LinearLayout) findViewById(R.id.guest_content_layout);
        this.guestImageView = (ImageView) findViewById(R.id.guest_imageView);
        this.guestTitle = (TextView) findViewById(R.id.guest_title);
        this.height = (TextView) findViewById(R.id.guest_height);
        this.weight = (TextView) findViewById(R.id.register3_weight);
        this.done = (Button) findViewById(R.id.guest_done);
        this.back = (Button) findViewById(R.id.guest_back);
        this.btncontent = (LinearLayout) findViewById(R.id.guest_btncontent);
        this.font = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLight.ttf");
        initPhone();
        this.height.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Login_Guest_Activity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(Login_Guest_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "guest_height_btn", ErrorLogSave.CLICK);
                Login_Guest_Activity.this.onHeightLinkagePicker();
            }
        });
        this.weight.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Login_Guest_Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(Login_Guest_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "guest_weight_btn", ErrorLogSave.CLICK);
                Login_Guest_Activity.this.onWeightLinkagePicker();
            }
        });
        this.done.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Login_Guest_Activity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(Login_Guest_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "guest_done_btn", ErrorLogSave.CLICK);
                if (Login_Guest_Activity.this.memberData.getHeight() == 0 || Login_Guest_Activity.this.memberData.getWeight() == 0) {
                    Login_Guest_Activity.this.memberData.setHeight(165);
                    Login_Guest_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    Login_Guest_Activity.this.memberData.setWeight(60);
                    Login_Guest_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                Login_Guest_Activity.this.memberData.setAccount(Login_Guest_Activity.GUEST);
                MemberDataDao memberDataDao = DbManager.getMemberDataDao();
                QueryBuilder<MemberData> queryBuilder = memberDataDao.queryBuilder();
                queryBuilder.where(MemberDataDao.Properties.Account.eq(Login_Guest_Activity.GUEST), new WhereCondition[0]);
                List<MemberData> list = queryBuilder.list();
                if (list != null && list.size() == 0) {
                    memberDataDao.insert(Login_Guest_Activity.this.memberData);
                } else {
                    list.get(0).setHeight(Login_Guest_Activity.this.memberData.getHeight());
                    list.get(0).setWeight(Login_Guest_Activity.this.memberData.getWeight());
                    list.get(0).setUnit_type(Login_Guest_Activity.this.memberData.getUnit_type());
                    memberDataDao.update(list.get(0));
                }
                Global.userName = Login_Guest_Activity.this.getString(R.string.guest);
                Global.calendarUserName = Login_Guest_Activity.this.getString(R.string.guest);
                Global.memberData = Login_Guest_Activity.this.memberData;
                Login_Guest_Activity.this.goMain();
                if (!LoginActivity.loginActivity.isFinishing()) {
                    LoginActivity.loginActivity.finish();
                }
                Login_Guest_Activity.this.finish();
            }
        });
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
                this.guestBackgroundLayout.setBackgroundColor(-1);
            }
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i2;
            layoutParams2.height = i;
            this.mainLayout.setLayoutParams(layoutParams2);
            this.mainLayout.setBackgroundResource(R.drawable.main2);
            if (Global.BRAND == 1) {
                this.mainLayout.setBackgroundResource(R.drawable.main3);
                this.guestBackgroundLayout.setBackgroundColor(-1);
            }
        }
        this.guestContentLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.guestContentLayout.getLayoutParams();
        int i3 = (int) ((460.0f * f) + 0.5d);
        layoutParams3.height = i3;
        layoutParams3.width = (int) ((500.0f * f4) + 0.5d);
        this.guestContentLayout.setLayoutParams(layoutParams3);
        this.guestContentLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.height = i3;
        layoutParams4.width = (int) ((280.0f * f4) + 0.5d);
        this.guestImageView.setLayoutParams(layoutParams4);
        if (isPad(this)) {
            layoutParams4.topMargin = (int) (f * 20.0f);
            layoutParams4.leftMargin = (int) (20.0f * f4);
        }
        this.guestTitle.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.guestTitle.setTypeface(this.font);
        this.guestTitle.setLayoutParams((LinearLayout.LayoutParams) this.guestTitle.getLayoutParams());
        this.guestTitle.setY(64.0f * f);
        this.height.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.height.setY(140.0f * f);
        this.height.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.height.getLayoutParams();
        int i4 = (int) ((40.0f * f) + 0.5d);
        layoutParams5.height = i4;
        int i5 = (int) ((230.0f * f4) + 0.5d);
        layoutParams5.width = i5;
        this.height.setLayoutParams(layoutParams5);
        this.weight.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.weight.setY(160.0f * f);
        this.weight.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.weight.getLayoutParams();
        layoutParams6.height = i4;
        layoutParams6.width = i5;
        this.weight.setLayoutParams(layoutParams6);
        Log.v("skypoo", "confirm:" + this.weight.getWidth());
        int i6 = isPad(this) ? R2.attr.dividerPadding : 200;
        this.done.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.done.setY(i6 * f);
        this.done.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.done.getLayoutParams();
        layoutParams7.height = i4;
        layoutParams7.width = i5;
        Log.v("skypoo", "next:" + layoutParams7.weight);
        this.done.setLayoutParams(layoutParams7);
        this.btncontent.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.btncontent.setY(((float) (i6 + 20)) * f);
        this.back.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.back.setX(380.0f * f4);
        this.back.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.back.getLayoutParams();
        layoutParams8.height = i4;
        layoutParams8.width = (int) ((f4 * 100.0f) + 0.5d);
        this.back.setLayoutParams(layoutParams8);
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.Login_Guest_Activity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(Login_Guest_Activity.this.getApplicationContext(), ErrorLogSave.CLICK, "guest_back_btn", ErrorLogSave.CLICK);
                Login_Guest_Activity.this.onBackPressed();
            }
        });
    }

    public static boolean isPad(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public void onHeightLinkagePicker() {
        LinkageProvider linkageProvider = new LinkageProvider() { // from class: com.dyaco.sole.activity.Login_Guest_Activity.5
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
        LinkagePicker linkagePicker = new LinkagePicker(this) { // from class: com.dyaco.sole.activity.Login_Guest_Activity.6
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
        linkagePicker.setOnLinkagePickedListener(new OnLinkagePickedListener() { // from class: com.dyaco.sole.activity.Login_Guest_Activity.7
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener
            public void onLinkagePicked(Object obj, Object obj2, Object obj3) throws NumberFormatException {
                if ((obj instanceof String) && (obj2 instanceof String)) {
                    Login_Guest_Activity.this.height.setText(obj2 + StringUtils.SPACE + obj);
                    if (obj.equals("cm")) {
                        Login_Guest_Activity.this.height.setText(obj2 + StringUtils.SPACE + Login_Guest_Activity.this.getString(R.string.login_cm));
                        int i = 0;
                        try {
                            i = Integer.parseInt((String) obj2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Login_Guest_Activity.this.memberData.setHeight(i);
                        Login_Guest_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        Login_Guest_Activity.this.heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        return;
                    }
                    float f = 0.0f;
                    try {
                        f = Float.parseFloat((String) obj2) * 2.54f;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    Login_Guest_Activity.this.height.setText(obj2 + StringUtils.SPACE + Login_Guest_Activity.this.getString(R.string.login_in));
                    Login_Guest_Activity.this.memberData.setHeight((int) (((double) f) + 0.5d));
                    Login_Guest_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    Login_Guest_Activity.this.heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                }
            }
        });
        linkagePicker.show();
    }

    public void onWeightLinkagePicker() {
        LinkageProvider linkageProvider = new LinkageProvider() { // from class: com.dyaco.sole.activity.Login_Guest_Activity.8
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
        LinkagePicker linkagePicker = new LinkagePicker(this) { // from class: com.dyaco.sole.activity.Login_Guest_Activity.9
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
        linkagePicker.setOnLinkagePickedListener(new OnLinkagePickedListener() { // from class: com.dyaco.sole.activity.Login_Guest_Activity.10
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener
            public void onLinkagePicked(Object obj, Object obj2, Object obj3) throws NumberFormatException {
                if ((obj instanceof String) && (obj2 instanceof String)) {
                    Login_Guest_Activity.this.weight.setText(obj2 + StringUtils.SPACE + obj);
                    if (obj.equals("kg")) {
                        Login_Guest_Activity.this.weight.setText(obj2 + StringUtils.SPACE + Login_Guest_Activity.this.getString(R.string.login_kg));
                        int i = 0;
                        try {
                            i = Integer.parseInt((String) obj2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Login_Guest_Activity.this.memberData.setWeight(i);
                        Login_Guest_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        Login_Guest_Activity.this.weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        return;
                    }
                    float f = 0.0f;
                    try {
                        f = Float.parseFloat((String) obj2) * 0.454f;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    Login_Guest_Activity.this.weight.setText(obj2 + StringUtils.SPACE + Login_Guest_Activity.this.getString(R.string.login_lb));
                    Login_Guest_Activity.this.memberData.setWeight((int) (((double) f) + 0.5d));
                    Login_Guest_Activity.this.memberData.setUnit_type(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    Login_Guest_Activity.this.weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                }
            }
        });
        linkagePicker.show();
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
