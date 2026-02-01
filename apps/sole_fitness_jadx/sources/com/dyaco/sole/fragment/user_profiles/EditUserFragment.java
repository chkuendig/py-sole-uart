package com.dyaco.sole.fragment.user_profiles;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.ResponseMessage;
import com.digifly.cloudapi.listener.MemberLoginListener;
import com.digifly.cloudapi.listener.MemberRegistUpdateListener;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.R2;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.database.MessageDB;
import com.dyaco.sole.fragment.BaseFragment;
import com.facebook.appevents.AppEventsConstants;
import com.github.gzuliyujiang.wheelpicker.LinkagePicker;
import com.github.gzuliyujiang.wheelpicker.OptionPicker;
import com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider;
import com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionPickedListener;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes.dex */
public class EditUserFragment extends BaseFragment {
    private MainActivity activity;
    private TextView birthday;
    private Button cancel;
    private CloudApi cloudApi;
    private EditText confirmPassword;
    private DbManager dbManager;
    private LinearLayout edittext;
    private LinearLayout edittext1;
    private LinearLayout edittext2;
    private LinearLayout edittext3;
    private LinearLayout edittext4;
    private LinearLayout edittext5;
    private TextView edituserAccountName;
    private RelativeLayout edituserBackgroundLayout;
    private LinearLayout edituserContentLayout;
    private ImageView edituserTestHead;
    private TextView edituserTitle;
    private ImageView edituserTitleImage;
    private EditText email;
    private Typeface font;
    private TextView gender;
    private TextView height;
    String[] itemsGender;
    private List<MemberData> list;
    private int mDay;
    private int mMonth;
    private int mYear;
    private LinearLayout mainLayout;
    private EditText name;
    private EditText password;
    private View rootView;
    private Button save;
    private TextView weight;
    private final String TAG = "EditUserFragment";
    private MemberData memberData = new MemberData();
    private String heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private String weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String[] chGender = {"M", "F"};

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.activity = (MainActivity) getActivity();
        this.rootView = layoutInflater.inflate(R.layout.fragment_edituser, viewGroup, false);
        findViews();
        initParams();
        setListeners();
        return this.rootView;
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void findViews() {
        this.cloudApi = CloudApi.getInstance(this.activity);
        this.dbManager = DbManager.getInstance(this.activity);
        this.edituserBackgroundLayout = (RelativeLayout) this.rootView.findViewById(R.id.edituser_background_layout);
        this.mainLayout = (LinearLayout) this.rootView.findViewById(R.id.edituser_main_layout);
        this.edituserContentLayout = (LinearLayout) this.rootView.findViewById(R.id.edituser_contentlinearlayout);
        this.edituserTitleImage = (ImageView) this.rootView.findViewById(R.id.edituser_title_image);
        this.edituserTitle = (TextView) this.rootView.findViewById(R.id.edituser_title);
        this.edituserAccountName = (TextView) this.rootView.findViewById(R.id.edituser_account_name);
        this.name = (EditText) this.rootView.findViewById(R.id.edituser_name);
        this.email = (EditText) this.rootView.findViewById(R.id.edituser_email);
        this.password = (EditText) this.rootView.findViewById(R.id.edituser_password);
        this.confirmPassword = (EditText) this.rootView.findViewById(R.id.edituser_confirm_password);
        this.gender = (TextView) this.rootView.findViewById(R.id.edituser_gender);
        this.birthday = (TextView) this.rootView.findViewById(R.id.edituser_birthday);
        this.height = (TextView) this.rootView.findViewById(R.id.edituser_height);
        this.weight = (TextView) this.rootView.findViewById(R.id.edituser_weight);
        this.cancel = (Button) this.rootView.findViewById(R.id.edituser_cancel);
        this.save = (Button) this.rootView.findViewById(R.id.edituser_save);
        this.edittext = (LinearLayout) this.rootView.findViewById(R.id.edittext);
        this.edittext1 = (LinearLayout) this.rootView.findViewById(R.id.edittext1);
        this.edittext2 = (LinearLayout) this.rootView.findViewById(R.id.edittext2);
        this.edittext3 = (LinearLayout) this.rootView.findViewById(R.id.edittext3);
        this.edittext4 = (LinearLayout) this.rootView.findViewById(R.id.edittext4);
        this.edittext5 = (LinearLayout) this.rootView.findViewById(R.id.edittext5);
        this.font = Typeface.createFromAsset(this.activity.getAssets(), "fonts/HelveticaNeueLight.ttf");
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void initParams() {
        int i = Global.BRAND;
        if (i == 1) {
            this.edituserTitleImage.setVisibility(8);
            this.edituserTitle.setTypeface(Typeface.createFromAsset(this.activity.getAssets(), Global.fontsPath[4]));
            this.name.setBackgroundResource(R.drawable.edituser_spirit_textbox);
            this.email.setBackgroundResource(R.drawable.edituser_spirit_textbox);
            this.password.setBackgroundResource(R.drawable.edituser_spirit_textbox);
            this.confirmPassword.setBackgroundResource(R.drawable.edituser_spirit_textbox);
            this.gender.setBackgroundResource(R.drawable.edituser_spirit_textbox);
            this.birthday.setBackgroundResource(R.drawable.edituser_spirit_textbox);
            this.height.setBackgroundResource(R.drawable.edituser_spirit_textbox);
            this.weight.setBackgroundResource(R.drawable.edituser_spirit_textbox);
            this.cancel.setBackgroundResource(R.drawable.edituser_spirit_button_b);
            this.save.setBackgroundResource(R.drawable.edituser_spirit_button_a);
        } else if (i == 2 || i == 3) {
            this.edituserTitleImage.setVisibility(8);
        }
        if (isPad(this)) {
            initTable();
        } else {
            initPhone();
        }
        this.itemsGender = new String[]{getResources().getString(R.string.gender_male), getResources().getString(R.string.gender_female)};
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
        queryBuilder.where(MemberDataDao.Properties.Account.eq(Global.userName), new WhereCondition[0]);
        List<MemberData> list = queryBuilder.list();
        this.list = list;
        if (list.size() == 0) {
            return;
        }
        setViewsValue();
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        readMemberData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewsValue() {
        if (Global.userName.equals(getResources().getString(R.string.guest))) {
            return;
        }
        MemberData memberData = Global.memberData;
        this.memberData = memberData;
        this.edituserAccountName.setText(memberData.getAccount());
        this.name.setText(this.memberData.getName());
        if ("M".equals(this.memberData.getSex())) {
            this.gender.setText(R.string.gender_male);
        } else {
            this.gender.setText(R.string.gender_female);
        }
        this.email.setText(this.memberData.getEmail());
        this.birthday.setText(this.memberData.getBirthday());
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.memberData.getUnit_type())) {
            this.height.setText(String.valueOf(this.memberData.getHeight()) + " cm");
            this.weight.setText(String.valueOf(this.memberData.getWeight()) + " kg");
            this.heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            this.weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            TextView textView = this.height;
            textView.setText(((int) ((this.memberData.getHeight() / 2.54f) + 0.5d)) + " in");
            TextView textView2 = this.weight;
            textView2.setText(((int) ((this.memberData.getWeight() / 0.454f) + 0.5d)) + " lb");
            this.heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            this.weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        if (this.memberData.getRegist_type().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) || this.memberData.getRegist_type().equalsIgnoreCase(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
            this.password.setCursorVisible(false);
            this.password.setFocusableInTouchMode(false);
            this.confirmPassword.setCursorVisible(false);
            this.confirmPassword.setFocusableInTouchMode(false);
        }
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void setListeners() {
        this.gender.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditUserFragment.this.onOptionPicker();
            }
        });
        this.birthday.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditUserFragment.this.showDatePickerDialog();
            }
        });
        this.height.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditUserFragment.this.onHeightLinkagePicker();
            }
        });
        this.weight.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditUserFragment.this.onWeightLinkagePicker();
            }
        });
        this.save.setOnClickListener(new AnonymousClass5());
        this.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(EditUserFragment.this.getActivity(), ErrorLogSave.CLICK, "EditUserFragment_cancel", ErrorLogSave.CLICK);
                EditUserFragment.this.getFragmentManager().beginTransaction().hide(EditUserFragment.this).commit();
                EditUserFragment.this.activity.switchFragment(0);
            }
        });
    }

    /* renamed from: com.dyaco.sole.fragment.user_profiles.EditUserFragment$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ErrorLogSave.addErrorString(EditUserFragment.this.getActivity(), ErrorLogSave.CLICK, "EditUserFragment_save", "email:" + ((Object) EditUserFragment.this.email.getText()) + "_gender:" + ((Object) EditUserFragment.this.gender.getText()) + "_birthday:" + ((Object) EditUserFragment.this.birthday.getText()) + "_height:" + EditUserFragment.this.height + "_weight:" + ((Object) EditUserFragment.this.weight.getText()));
            StringBuilder sb = new StringBuilder();
            sb.append("view = ");
            sb.append(view);
            Logger.d(sb.toString());
            EditUserFragment editUserFragment = EditUserFragment.this;
            if (!editUserFragment.isEmailFormat(editUserFragment.email)) {
                EditUserFragment.this.email.setBackgroundResource(R.drawable.signup_sole_button_b);
                EditUserFragment.this.email.requestFocus();
                Toast.makeText(EditUserFragment.this.getActivity(), "Email格式錯誤", 1).show();
                return;
            }
            if (!EditUserFragment.this.heightUnitType.equals(EditUserFragment.this.weightUnitType)) {
                EditUserFragment.this.height.setBackgroundResource(R.drawable.signup_sole_button_b);
                EditUserFragment.this.weight.setBackgroundResource(R.drawable.signup_sole_button_b);
                Toast.makeText(EditUserFragment.this.getActivity(), "單位必須一致", 1).show();
                return;
            }
            if ("".equals(EditUserFragment.this.password.getText().toString().trim())) {
                EditUserFragment.this.height.setBackgroundResource(R.drawable.signup_sole_button_a);
                EditUserFragment.this.weight.setBackgroundResource(R.drawable.signup_sole_button_a);
                EditUserFragment.this.email.setBackgroundResource(R.drawable.edituser_sole_button_a);
                EditUserFragment.this.memberData.setName(EditUserFragment.this.name.getText().toString());
                EditUserFragment.this.memberData.setEmail(EditUserFragment.this.email.getText().toString());
                EditUserFragment.this.memberData.setBirthday(EditUserFragment.this.birthday.getText().toString());
                EditUserFragment.this.memberData.setSex(String.valueOf(EditUserFragment.this.chGender[Arrays.asList(EditUserFragment.this.itemsGender).indexOf(EditUserFragment.this.gender.getText().toString())]));
                EditUserFragment.this.memberData.setUnit_type(EditUserFragment.this.heightUnitType);
                EditUserFragment.this.cloudApi.setMemberRegistUpdateListener(new MemberRegistUpdateListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.5.1
                    @Override // com.digifly.cloudapi.listener.MemberRegistUpdateListener
                    public void onSuccess(final MemberData memberData) {
                        EditUserFragment.this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.5.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                memberData.setPassword(EditUserFragment.this.password.getText().toString().trim());
                                MemberDataDao memberDataDao = DbManager.getMemberDataDao();
                                QueryBuilder<MemberData> queryBuilder = memberDataDao.queryBuilder();
                                queryBuilder.where(MemberDataDao.Properties.Account.eq(memberData.getAccount()), new WhereCondition[0]);
                                List<MemberData> list = queryBuilder.list();
                                list.get(0).setName(memberData.getName());
                                list.get(0).setEmail(memberData.getEmail());
                                list.get(0).setSex(memberData.getSex());
                                list.get(0).setBirthday(memberData.getBirthday());
                                list.get(0).setHeight(memberData.getHeight());
                                list.get(0).setWeight(memberData.getWeight());
                                list.get(0).setUnit_type(memberData.getUnit_type());
                                memberDataDao.update(list.get(0));
                                EditUserFragment.this.getFragmentManager().beginTransaction().hide(EditUserFragment.this).commit();
                                EditUserFragment.this.activity.switchFragment(0);
                                Global.memberData = memberData;
                                Logger.d("data = " + memberData);
                            }
                        });
                    }

                    @Override // com.digifly.cloudapi.listener.MemberRegistUpdateListener
                    public void onFail(final ResponseMessage responseMessage) {
                        EditUserFragment.this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.5.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(EditUserFragment.this.activity, responseMessage.getMessage(), 0).show();
                            }
                        });
                        EditUserFragment.this.activity.showErrorLog(R.string.error_0004, ErrorLogSave.ERROR_0004);
                    }

                    @Override // com.digifly.cloudapi.listener.MemberRegistUpdateListener
                    public void onError(final String str) {
                        EditUserFragment.this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.5.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(EditUserFragment.this.activity, str.toString(), 0).show();
                            }
                        });
                        EditUserFragment.this.activity.showErrorLog(R.string.error_0004, ErrorLogSave.ERROR_0004);
                    }
                });
                EditUserFragment.this.cloudApi.callMemberRegistUpdate(EditUserFragment.this.memberData);
                return;
            }
            if (EditUserFragment.this.password.getText().length() < 6 || EditUserFragment.this.password.getText().length() > 20) {
                if (EditUserFragment.this.password.getText().length() < 6) {
                    EditUserFragment.this.password.setBackgroundResource(R.drawable.signup_sole_button_b);
                    EditUserFragment.this.password.requestFocus();
                    Toast.makeText(EditUserFragment.this.getActivity(), "密碼需6位數以上", 0).show();
                    return;
                } else {
                    EditUserFragment.this.password.setBackgroundResource(R.drawable.signup_sole_button_b);
                    EditUserFragment.this.password.requestFocus();
                    Toast.makeText(EditUserFragment.this.getActivity(), "密碼需20位數以下", 0).show();
                    return;
                }
            }
            if (EditUserFragment.this.password.getText().toString().equals(EditUserFragment.this.confirmPassword.getText().toString())) {
                EditUserFragment.this.email.setBackgroundResource(R.drawable.edituser_sole_button_a);
                EditUserFragment.this.password.setBackgroundResource(R.drawable.edituser_sole_button_a);
                EditUserFragment.this.confirmPassword.setBackgroundResource(R.drawable.edituser_sole_button_a);
                EditUserFragment.this.memberData.setName(EditUserFragment.this.name.getText().toString());
                EditUserFragment.this.memberData.setEmail(EditUserFragment.this.email.getText().toString());
                EditUserFragment.this.memberData.setBirthday(EditUserFragment.this.birthday.getText().toString());
                EditUserFragment.this.memberData.setPassword(EditUserFragment.this.password.getText().toString());
                EditUserFragment.this.memberData.setSex(String.valueOf(EditUserFragment.this.chGender[Arrays.asList(EditUserFragment.this.itemsGender).indexOf(EditUserFragment.this.gender.getText().toString())]));
                EditUserFragment.this.memberData.setUnit_type(EditUserFragment.this.heightUnitType);
                EditUserFragment.this.cloudApi.setMemberRegistUpdateListener(new MemberRegistUpdateListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.5.2
                    @Override // com.digifly.cloudapi.listener.MemberRegistUpdateListener
                    public void onSuccess(final MemberData memberData) {
                        EditUserFragment.this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.5.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                memberData.setPassword(EditUserFragment.this.password.getText().toString().trim());
                                MemberDataDao memberDataDao = DbManager.getMemberDataDao();
                                QueryBuilder<MemberData> queryBuilder = memberDataDao.queryBuilder();
                                queryBuilder.where(MemberDataDao.Properties.Account.eq(memberData.getAccount()), new WhereCondition[0]);
                                List<MemberData> list = queryBuilder.list();
                                list.get(0).setName(memberData.getName());
                                list.get(0).setEmail(memberData.getEmail());
                                list.get(0).setPassword(EditUserFragment.this.password.getText().toString());
                                list.get(0).setSex(memberData.getSex());
                                list.get(0).setBirthday(memberData.getBirthday());
                                list.get(0).setHeight(memberData.getHeight());
                                list.get(0).setWeight(memberData.getWeight());
                                list.get(0).setUnit_type(memberData.getUnit_type());
                                memberDataDao.update(list.get(0));
                                EditUserFragment.this.getFragmentManager().beginTransaction().hide(EditUserFragment.this).commit();
                                Global.memberData = memberData;
                                Logger.d("data = " + memberData);
                            }
                        });
                    }

                    @Override // com.digifly.cloudapi.listener.MemberRegistUpdateListener
                    public void onFail(final ResponseMessage responseMessage) {
                        EditUserFragment.this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.5.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(EditUserFragment.this.activity, responseMessage.getMessage(), 0).show();
                                Logger.d("responseMessage = " + responseMessage);
                            }
                        });
                        EditUserFragment.this.activity.showErrorLog(R.string.error_0004, ErrorLogSave.ERROR_0004);
                    }

                    @Override // com.digifly.cloudapi.listener.MemberRegistUpdateListener
                    public void onError(final String str) {
                        EditUserFragment.this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.5.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(EditUserFragment.this.activity, str.toString(), 0).show();
                                Logger.d("err = " + str);
                            }
                        });
                        EditUserFragment.this.activity.showErrorLog(R.string.error_0004, ErrorLogSave.ERROR_0004);
                    }
                });
                EditUserFragment.this.cloudApi.callMemberRegistUpdate(EditUserFragment.this.memberData);
                return;
            }
            EditUserFragment.this.password.setBackgroundResource(R.drawable.signup_sole_button_b);
            EditUserFragment.this.confirmPassword.setBackgroundResource(R.drawable.signup_sole_button_b);
            EditUserFragment.this.password.requestFocus();
            Toast.makeText(EditUserFragment.this.getActivity(), "密碼錯誤", 1).show();
        }
    }

    private void initTable() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = (i * 4) / 3;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = (i2 * R2.color.browser_actions_bg_grey) / 1024;
        layoutParams.height = (i * 500) / R2.bool.abc_config_actionMenuItemAllCaps;
        this.mainLayout.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mainLayout.getLayoutParams();
        layoutParams2.addRule(14, -1);
        layoutParams2.topMargin = (i * 24) / R2.bool.abc_config_actionMenuItemAllCaps;
        layoutParams2.bottomMargin = (i * 88) / R2.bool.abc_config_actionMenuItemAllCaps;
        this.mainLayout.setLayoutParams(layoutParams2);
        Log.v("skypoo", "ScreenHeight=" + displayMetrics.heightPixels);
        Log.v("skypoo", "ScreenWidth=" + displayMetrics.widthPixels);
        Log.v("skypoo", "height=" + layoutParams.height);
        this.edituserContentLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.edituserContentLayout.setX(0.0f);
        this.edituserContentLayout.setY(0.0f);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.edituserContentLayout.getLayoutParams();
        layoutParams3.topMargin = (i * 20) / R2.bool.abc_config_actionMenuItemAllCaps;
        layoutParams3.leftMargin = (i2 * 20) / 1024;
        this.edituserContentLayout.setLayoutParams(layoutParams3);
        this.edituserContentLayout.setGravity(1);
        this.edituserTitleImage.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edituserTitleImage.setY((i * 30) / R2.bool.abc_config_actionMenuItemAllCaps);
        this.edituserTitleImage.setLayoutParams((LinearLayout.LayoutParams) this.edituserTitleImage.getLayoutParams());
        this.edituserTitle.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edituserTitle.setY((i * 60) / R2.bool.abc_config_actionMenuItemAllCaps);
        this.edituserTitle.setTypeface(this.font);
        this.edituserTitle.setLayoutParams((LinearLayout.LayoutParams) this.edituserTitle.getLayoutParams());
        this.edittext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.edittext.setY((i * 70) / R2.bool.abc_config_actionMenuItemAllCaps);
        this.edituserAccountName.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edituserAccountName.setX((i2 * 165) / 1024);
        this.edituserAccountName.setTypeface(this.font);
        this.edituserAccountName.setLayoutParams((LinearLayout.LayoutParams) this.edituserAccountName.getLayoutParams());
        this.edittext1.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext1.setY((i * 80) / R2.bool.abc_config_actionMenuItemAllCaps);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.edittext1.getLayoutParams();
        int i3 = (i * 40) / R2.bool.abc_config_actionMenuItemAllCaps;
        layoutParams4.height = i3;
        int i4 = (i2 * 510) / 1024;
        layoutParams4.width = i4;
        this.edittext1.setLayoutParams(layoutParams4);
        this.name.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.name.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.name.getLayoutParams();
        layoutParams5.height = i3;
        int i5 = (i2 * R2.attr.defaultState) / 1024;
        layoutParams5.width = i5;
        this.name.setLayoutParams(layoutParams5);
        this.gender.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        float f = (i2 * 50) / 1024;
        this.gender.setX(f);
        this.gender.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.gender.getLayoutParams();
        layoutParams6.height = i3;
        layoutParams6.width = i5;
        this.gender.setLayoutParams(layoutParams5);
        this.edittext2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext2.setY((i * 90) / R2.bool.abc_config_actionMenuItemAllCaps);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.edittext2.getLayoutParams();
        layoutParams7.height = i3;
        layoutParams7.width = i4;
        this.edittext2.setLayoutParams(layoutParams7);
        this.email.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.email.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.email.getLayoutParams();
        layoutParams8.height = i3;
        layoutParams8.width = i5;
        this.email.setLayoutParams(layoutParams8);
        this.birthday.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.birthday.setX(f);
        this.birthday.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.birthday.getLayoutParams();
        layoutParams9.height = i3;
        layoutParams9.width = i5;
        this.birthday.setLayoutParams(layoutParams9);
        this.edittext3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext3.setY((i * 100) / R2.bool.abc_config_actionMenuItemAllCaps);
        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) this.edittext3.getLayoutParams();
        layoutParams10.height = i3;
        layoutParams10.width = i4;
        this.edittext3.setLayoutParams(layoutParams10);
        this.password.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.password.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) this.password.getLayoutParams();
        layoutParams11.height = i3;
        layoutParams11.width = i5;
        this.password.setLayoutParams(layoutParams11);
        this.height.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.height.setX(f);
        this.height.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) this.height.getLayoutParams();
        layoutParams12.height = i3;
        layoutParams12.width = i5;
        this.height.setLayoutParams(layoutParams12);
        this.edittext4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext4.setY((i * 110) / R2.bool.abc_config_actionMenuItemAllCaps);
        LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) this.edittext4.getLayoutParams();
        layoutParams13.height = i3;
        layoutParams13.width = i4;
        this.edittext4.setLayoutParams(layoutParams13);
        this.confirmPassword.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.confirmPassword.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams14 = (LinearLayout.LayoutParams) this.confirmPassword.getLayoutParams();
        layoutParams14.height = i3;
        layoutParams14.width = i5;
        this.confirmPassword.setLayoutParams(layoutParams14);
        this.weight.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.weight.setX(f);
        this.weight.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) this.weight.getLayoutParams();
        layoutParams15.height = i3;
        layoutParams15.width = i5;
        this.weight.setLayoutParams(layoutParams15);
        this.edittext5.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext5.setY((i * 120) / R2.bool.abc_config_actionMenuItemAllCaps);
        LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) this.edittext5.getLayoutParams();
        layoutParams16.height = i3;
        layoutParams16.width = i4;
        this.edittext5.setLayoutParams(layoutParams16);
        this.cancel.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cancel.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams17 = (LinearLayout.LayoutParams) this.cancel.getLayoutParams();
        layoutParams17.height = i3;
        layoutParams17.width = i5;
        this.cancel.setLayoutParams(layoutParams17);
        this.save.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.save.setX(f);
        this.save.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams18 = (LinearLayout.LayoutParams) this.save.getLayoutParams();
        layoutParams18.height = i3;
        layoutParams18.width = i5;
        this.save.setLayoutParams(layoutParams18);
    }

    private void initPhone() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        float f = i;
        float f2 = f - ((f / 768.0f) * 144.0f);
        float f3 = f2 / 460.0f;
        float f4 = ((f2 / 23.0f) * 39.0f) / 780.0f;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) (780.0f * f4);
        layoutParams.height = (int) (460.0f * f3);
        this.mainLayout.setLayoutParams(layoutParams);
        this.mainLayout.setBackgroundResource(R.drawable.my_edittext);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mainLayout.getLayoutParams();
        layoutParams2.addRule(14, -1);
        this.mainLayout.setLayoutParams(layoutParams2);
        Log.v("skypoo", "ScreenHeight=" + displayMetrics.heightPixels);
        Log.v("skypoo", "ScreenWidth=" + displayMetrics.widthPixels);
        Log.v("skypoo", "height=" + layoutParams.height);
        this.edituserContentLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.edituserContentLayout.setBackgroundResource(R.drawable.main);
        this.edituserContentLayout.setLayoutParams((LinearLayout.LayoutParams) this.edituserContentLayout.getLayoutParams());
        this.edituserContentLayout.setGravity(1);
        this.edituserTitleImage.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edituserTitleImage.setY(30.0f * f3);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.edituserTitleImage.getLayoutParams();
        layoutParams3.height = (int) ((28.0f * f3) + 0.5d);
        layoutParams3.width = (int) ((188.0f * f4) + 0.5d);
        this.edituserTitleImage.setLayoutParams(layoutParams3);
        this.edituserTitle.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edituserTitle.setY(45.0f * f3);
        this.edituserTitle.setTextSize(16.0f);
        this.edituserTitle.setTypeface(this.font);
        this.edituserTitle.setLayoutParams((LinearLayout.LayoutParams) this.edituserTitle.getLayoutParams());
        this.edittext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.edittext.setY(55.0f * f3);
        this.edituserAccountName.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edituserAccountName.setX(165.0f * f4);
        this.edituserAccountName.setTextSize(10.0f);
        this.edituserAccountName.setTypeface(this.font);
        this.edituserAccountName.setLayoutParams((LinearLayout.LayoutParams) this.edituserAccountName.getLayoutParams());
        this.edittext1.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext1.setY(65.0f * f3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.edittext1.getLayoutParams();
        int i3 = (int) ((40.0f * f3) + 0.5d);
        layoutParams4.height = i3;
        int i4 = (int) ((510.0f * f4) + 0.5d);
        layoutParams4.width = i4;
        this.edittext1.setLayoutParams(layoutParams4);
        this.name.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.name.setTextSize(10.0f);
        this.name.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.name.getLayoutParams();
        layoutParams5.height = i3;
        int i5 = (int) ((230.0f * f4) + 0.5d);
        layoutParams5.width = i5;
        this.name.setLayoutParams(layoutParams5);
        this.gender.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        float f5 = f4 * 50.0f;
        this.gender.setX(f5);
        this.gender.setTextSize(10.0f);
        this.gender.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.gender.getLayoutParams();
        layoutParams6.height = i3;
        layoutParams6.width = i5;
        this.gender.setLayoutParams(layoutParams5);
        this.edittext2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext2.setY(75.0f * f3);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.edittext2.getLayoutParams();
        layoutParams7.height = i3;
        layoutParams7.width = i4;
        this.edittext2.setLayoutParams(layoutParams7);
        this.email.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.email.setTextSize(10.0f);
        this.email.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.email.getLayoutParams();
        layoutParams8.height = i3;
        layoutParams8.width = i5;
        this.email.setLayoutParams(layoutParams8);
        this.birthday.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.birthday.setX(f5);
        this.birthday.setTextSize(10.0f);
        this.birthday.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.birthday.getLayoutParams();
        layoutParams9.height = i3;
        layoutParams9.width = i5;
        this.birthday.setLayoutParams(layoutParams9);
        this.edittext3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext3.setY(85.0f * f3);
        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) this.edittext3.getLayoutParams();
        layoutParams10.height = i3;
        layoutParams10.width = i4;
        this.edittext3.setLayoutParams(layoutParams10);
        this.password.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.password.setTextSize(10.0f);
        this.password.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) this.password.getLayoutParams();
        layoutParams11.height = i3;
        layoutParams11.width = i5;
        this.password.setLayoutParams(layoutParams11);
        this.height.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.height.setX(f5);
        this.height.setTextSize(10.0f);
        this.height.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) this.height.getLayoutParams();
        layoutParams12.height = i3;
        layoutParams12.width = i5;
        this.height.setLayoutParams(layoutParams12);
        this.edittext4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext4.setY(95.0f * f3);
        LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) this.edittext4.getLayoutParams();
        layoutParams13.height = i3;
        layoutParams13.width = i4;
        this.edittext4.setLayoutParams(layoutParams13);
        this.confirmPassword.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.confirmPassword.setTextSize(10.0f);
        this.confirmPassword.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams14 = (LinearLayout.LayoutParams) this.confirmPassword.getLayoutParams();
        layoutParams14.height = i3;
        layoutParams14.width = i5;
        this.confirmPassword.setLayoutParams(layoutParams14);
        this.weight.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.weight.setX(f5);
        this.weight.setTextSize(10.0f);
        this.weight.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) this.weight.getLayoutParams();
        layoutParams15.height = i3;
        layoutParams15.width = i5;
        this.weight.setLayoutParams(layoutParams15);
        this.edittext5.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext5.setY(f3 * 105.0f);
        LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) this.edittext5.getLayoutParams();
        layoutParams16.height = i3;
        layoutParams16.width = i4;
        this.edittext5.setLayoutParams(layoutParams16);
        this.cancel.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cancel.setTextSize(10.0f);
        this.cancel.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams17 = (LinearLayout.LayoutParams) this.cancel.getLayoutParams();
        layoutParams17.height = i3;
        layoutParams17.width = i5;
        this.cancel.setLayoutParams(layoutParams17);
        this.save.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.save.setX(f5);
        this.save.setTextSize(10.0f);
        this.save.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams18 = (LinearLayout.LayoutParams) this.save.getLayoutParams();
        layoutParams18.height = i3;
        layoutParams18.width = i5;
        this.save.setLayoutParams(layoutParams18);
    }

    public static boolean isPad(EditUserFragment editUserFragment) {
        return (editUserFragment.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEmailFormat(EditText editText) {
        if (editText == null) {
            return false;
        }
        return editText.getText().toString().contains("@");
    }

    public void onOptionPicker() {
        OptionPicker optionPicker = new OptionPicker(getActivity()) { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.7
            @Override // com.github.gzuliyujiang.wheelpicker.OptionPicker, com.github.gzuliyujiang.dialog.ModalDialog
            protected View createBodyView() {
                View viewCreateBodyView = super.createBodyView();
                getWheelView().setCyclicEnabled(false);
                return viewCreateBodyView;
            }
        };
        optionPicker.setData(getResources().getString(R.string.gender_male), getResources().getString(R.string.gender_female));
        optionPicker.setOnOptionPickedListener(new OnOptionPickedListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.8
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnOptionPickedListener
            public void onOptionPicked(int i, Object obj) {
                if (obj instanceof String) {
                    EditUserFragment.this.gender.setText((String) obj);
                }
            }
        });
        optionPicker.show();
    }

    public void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2);
        this.mDay = calendar.get(5);
        new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.9
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                EditUserFragment.this.birthday.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
            }
        }, this.mYear, this.mMonth, this.mDay).show();
    }

    public void onHeightLinkagePicker() {
        LinkageProvider linkageProvider = new LinkageProvider() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.10
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
        LinkagePicker linkagePicker = new LinkagePicker(getActivity()) { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.11
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
        linkagePicker.setOnLinkagePickedListener(new OnLinkagePickedListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.12
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener
            public void onLinkagePicked(Object obj, Object obj2, Object obj3) throws NumberFormatException {
                if ((obj instanceof String) && (obj2 instanceof String)) {
                    EditUserFragment.this.height.setText(obj2 + StringUtils.SPACE + obj);
                    if (obj.equals("cm")) {
                        EditUserFragment.this.height.setText(obj2 + StringUtils.SPACE + EditUserFragment.this.getString(R.string.login_cm));
                        int i = 0;
                        try {
                            i = Integer.parseInt((String) obj2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        EditUserFragment.this.memberData.setHeight(i);
                        EditUserFragment.this.heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    } else {
                        EditUserFragment.this.height.setText(obj2 + StringUtils.SPACE + EditUserFragment.this.getString(R.string.login_in));
                        float f = 0.0f;
                        try {
                            f = Float.parseFloat((String) obj2) * 2.54f;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        EditUserFragment.this.memberData.setHeight((int) (f + 0.5d));
                        EditUserFragment.this.heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    }
                    Log.v("skypoo", "height:" + EditUserFragment.this.memberData.getHeight());
                }
            }
        });
        linkagePicker.show();
    }

    public void onWeightLinkagePicker() {
        LinkageProvider linkageProvider = new LinkageProvider() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.13
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
        LinkagePicker linkagePicker = new LinkagePicker(getActivity()) { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.14
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
        linkagePicker.setOnLinkagePickedListener(new OnLinkagePickedListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.15
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener
            public void onLinkagePicked(Object obj, Object obj2, Object obj3) throws NumberFormatException {
                if ((obj instanceof String) && (obj2 instanceof String)) {
                    EditUserFragment.this.weight.setText(obj2 + StringUtils.SPACE + obj);
                    if (obj.equals("kg")) {
                        EditUserFragment.this.weight.setText(obj2 + StringUtils.SPACE + EditUserFragment.this.getString(R.string.login_kg));
                        int i = 0;
                        try {
                            i = Integer.parseInt((String) obj2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        EditUserFragment.this.memberData.setWeight(i);
                        EditUserFragment.this.weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    } else {
                        EditUserFragment.this.weight.setText(obj2 + StringUtils.SPACE + EditUserFragment.this.getString(R.string.login_lb));
                        float f = 0.0f;
                        try {
                            f = Float.parseFloat((String) obj2) * 0.454f;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        EditUserFragment.this.memberData.setWeight((int) (f + 0.5d));
                        EditUserFragment.this.weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    }
                    Log.v("skypoo", "weight:" + EditUserFragment.this.memberData.getWeight());
                }
            }
        });
        linkagePicker.show();
    }

    private void readMemberData() {
        SharedPreferences sharedPreferences = this.activity.getSharedPreferences("DATA", 0);
        String string = sharedPreferences.getString(MessageDB.ACCOUNT, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        final String string2 = sharedPreferences.getString("password", "");
        String string3 = sharedPreferences.getString("type", "");
        if (string == null || string.length() <= 0 || string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || string2 == null || string2.length() <= 0 || string3 == null || string3.length() <= 0) {
            return;
        }
        this.activity.showLoadDialog(null);
        this.cloudApi.setMemberLoginListener(new MemberLoginListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.16
            @Override // com.digifly.cloudapi.listener.MemberLoginListener
            public void onSuccess(MemberData memberData) {
                Log.v("skypoo", "Login data:" + memberData.toString());
                memberData.setPassword(string2);
                MemberDataDao memberDataDao = DbManager.getMemberDataDao();
                QueryBuilder<MemberData> queryBuilder = memberDataDao.queryBuilder();
                queryBuilder.where(MemberDataDao.Properties.Account.eq(memberData.getAccount()), new WhereCondition[0]);
                List<MemberData> list = queryBuilder.list();
                if (list != null) {
                    if (list.size() == 0) {
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
                }
                QueryBuilder<MemberData> queryBuilder2 = memberDataDao.queryBuilder();
                queryBuilder2.where(MemberDataDao.Properties.Account.eq(memberData.getAccount()), new WhereCondition[0]);
                List<MemberData> list2 = queryBuilder2.list();
                list2.get(0).setPassword(string2);
                memberDataDao.update(list2.get(0));
                Global.userName = memberData.getAccount();
                Global.calendarUserName = memberData.getAccount();
                Global.memberData = memberData;
                EditUserFragment.this.rootView.post(new Runnable() { // from class: com.dyaco.sole.fragment.user_profiles.EditUserFragment.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EditUserFragment.this.setViewsValue();
                    }
                });
                EditUserFragment.this.activity.closeLoadDialog();
            }

            @Override // com.digifly.cloudapi.listener.MemberLoginListener
            public void onFail(ResponseMessage responseMessage) {
                EditUserFragment.this.activity.closeLoadDialog();
                Log.d(EditUserFragment.this.TAG, "readMemberData onFail responseMessage=" + responseMessage.toString());
            }

            @Override // com.digifly.cloudapi.listener.MemberLoginListener
            public void onError(String str) {
                Log.d(EditUserFragment.this.TAG, "readMemberData onError err=" + str);
                EditUserFragment.this.activity.closeLoadDialog();
            }
        });
        this.cloudApi.callMemberLogin(string, string2, string3);
    }
}
