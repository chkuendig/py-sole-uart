package com.dyaco.sole.fragment.user_profiles;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.R2;
import com.dyaco.sole.activity.Login_Guest_Activity;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.fragment.BaseFragment;
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
public class EditGuestFragment extends BaseFragment {
    private MainActivity activity;
    Button cancel;
    LinearLayout edittext;
    LinearLayout edittext1;
    LinearLayout edittext2;
    Typeface font;
    TextView guestEdituserAccountName;
    RelativeLayout guestEdituserBackgroundLayout;
    LinearLayout guestEdituserContentLayout;
    TextView guestEdituserTitle;
    ImageView guestEdituserTitleImage;
    TextView height;
    List<MemberData> list;
    LinearLayout mainLayout;
    MemberDataDao memberDataDao;
    private View rootView;
    Button save;
    TextView weight;
    MemberData memberData = new MemberData();
    String heightUnitType = "";
    String weightUnitType = "";
    String heightValue = "165";
    String weightValue = "60";

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.activity = (MainActivity) getActivity();
        this.rootView = layoutInflater.inflate(R.layout.fragment_editguest, viewGroup, false);
        findViews();
        initParams();
        setListeners();
        return this.rootView;
    }

    @Override // android.app.Fragment
    public void onStart() throws Resources.NotFoundException {
        super.onStart();
        Log.v("skypoo", "EditGuestFragment onStart");
        MemberDataDao memberDataDao = DbManager.getMemberDataDao();
        this.memberDataDao = memberDataDao;
        QueryBuilder<MemberData> queryBuilder = memberDataDao.queryBuilder();
        queryBuilder.where(MemberDataDao.Properties.Account.eq(Login_Guest_Activity.GUEST), new WhereCondition[0]);
        this.list = queryBuilder.list();
        Log.v("skypoo", "memberData" + this.memberData.getHeight());
        if (this.list.size() == 0) {
            Log.v("skypoo", "EditGuest list.size:" + this.list.size());
            return;
        }
        String account = this.list.get(0).getAccount();
        if (account.equalsIgnoreCase("guest")) {
            account = getResources().getString(R.string.guest);
        }
        this.guestEdituserAccountName.setText(account);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.list.get(0).getUnit_type())) {
            this.height.setText(this.list.get(0).getHeight() + " cm");
            this.weight.setText(this.list.get(0).getWeight() + " kg");
            return;
        }
        TextView textView = this.height;
        textView.setText(((int) ((this.list.get(0).getHeight() / 2.54f) + 0.5d)) + " in");
        TextView textView2 = this.weight;
        textView2.setText(((int) ((this.list.get(0).getWeight() / 0.454f) + 0.5d)) + " lb");
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void findViews() {
        this.guestEdituserBackgroundLayout = (RelativeLayout) this.rootView.findViewById(R.id.guest_edituser_background_layout);
        this.mainLayout = (LinearLayout) this.rootView.findViewById(R.id.guest_edituser_main_layout);
        this.guestEdituserContentLayout = (LinearLayout) this.rootView.findViewById(R.id.guest_edituser_contentlinearlayout);
        this.guestEdituserTitleImage = (ImageView) this.rootView.findViewById(R.id.guest_edituser_title_image);
        this.guestEdituserTitle = (TextView) this.rootView.findViewById(R.id.guest_edituser_title);
        this.guestEdituserAccountName = (TextView) this.rootView.findViewById(R.id.guest_edituser_account_name);
        this.height = (TextView) this.rootView.findViewById(R.id.guest_edituser_height);
        this.weight = (TextView) this.rootView.findViewById(R.id.guest_edituser_weight);
        this.cancel = (Button) this.rootView.findViewById(R.id.edituser_cancel);
        this.save = (Button) this.rootView.findViewById(R.id.edituser_save);
        this.edittext = (LinearLayout) this.rootView.findViewById(R.id.edittext);
        this.edittext1 = (LinearLayout) this.rootView.findViewById(R.id.edittext1);
        this.edittext2 = (LinearLayout) this.rootView.findViewById(R.id.edittext2);
        this.font = Typeface.createFromAsset(this.activity.getAssets(), "fonts/HelveticaNeueLight.ttf");
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void initParams() {
        int i = Global.BRAND;
        if (i == 1) {
            this.guestEdituserTitleImage.setVisibility(8);
            this.guestEdituserTitle.setTypeface(Typeface.createFromAsset(this.activity.getAssets(), Global.fontsPath[4]));
            this.height.setBackgroundResource(R.drawable.edituser_spirit_textbox);
            this.weight.setBackgroundResource(R.drawable.edituser_spirit_textbox);
            this.cancel.setBackgroundResource(R.drawable.edituser_spirit_button_b);
            this.save.setBackgroundResource(R.drawable.edituser_spirit_button_a);
        } else if (i == 2 || i == 3) {
            this.guestEdituserTitleImage.setVisibility(8);
        }
        if (isPad(this)) {
            initTable();
        } else {
            initPhone();
        }
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void setListeners() {
        this.height.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditGuestFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(EditGuestFragment.this.getActivity(), ErrorLogSave.CLICK, "EditGuestFragment_height", ErrorLogSave.CLICK);
                EditGuestFragment.this.onHeightLinkagePicker();
            }
        });
        this.weight.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditGuestFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(EditGuestFragment.this.getActivity(), ErrorLogSave.CLICK, "EditGuestFragment_weight", ErrorLogSave.CLICK);
                EditGuestFragment.this.onWeightLinkagePicker();
            }
        });
        this.save.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditGuestFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(EditGuestFragment.this.getActivity(), ErrorLogSave.CLICK, "EditGuestFragment_save", "height:" + ((Object) EditGuestFragment.this.height.getText()) + "_weight:" + ((Object) EditGuestFragment.this.weight.getText()));
                if (EditGuestFragment.this.heightUnitType.equals(EditGuestFragment.this.weightUnitType)) {
                    EditGuestFragment.this.height.setBackgroundResource(R.drawable.signup_sole_button_a);
                    EditGuestFragment.this.weight.setBackgroundResource(R.drawable.signup_sole_button_a);
                    EditGuestFragment.this.list.get(0).setUnit_type(EditGuestFragment.this.heightUnitType);
                    EditGuestFragment.this.list.get(0).setHeight(Integer.valueOf(EditGuestFragment.this.heightValue).intValue());
                    EditGuestFragment.this.list.get(0).setWeight(Integer.valueOf(EditGuestFragment.this.weightValue).intValue());
                    EditGuestFragment.this.memberDataDao.update(EditGuestFragment.this.list.get(0));
                    EditGuestFragment.this.getFragmentManager().beginTransaction().hide(EditGuestFragment.this).commit();
                    EditGuestFragment.this.activity.switchFragment(0);
                    return;
                }
                EditGuestFragment.this.height.setBackgroundResource(R.drawable.signup_sole_button_b);
                EditGuestFragment.this.weight.setBackgroundResource(R.drawable.signup_sole_button_b);
                Toast.makeText(EditGuestFragment.this.getActivity(), "單位必須一致", 1).show();
            }
        });
        this.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditGuestFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(EditGuestFragment.this.getActivity(), ErrorLogSave.CLICK, "EditGuestFragment_cancel", ErrorLogSave.CLICK);
                EditGuestFragment.this.getFragmentManager().beginTransaction().hide(EditGuestFragment.this).commit();
                EditGuestFragment.this.activity.switchFragment(0);
            }
        });
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
        this.guestEdituserContentLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.guestEdituserContentLayout.setX(0.0f);
        this.guestEdituserContentLayout.setY(0.0f);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.guestEdituserContentLayout.getLayoutParams();
        layoutParams3.topMargin = (i * 20) / R2.bool.abc_config_actionMenuItemAllCaps;
        layoutParams3.leftMargin = (i2 * 20) / 1024;
        this.guestEdituserContentLayout.setLayoutParams(layoutParams3);
        this.guestEdituserContentLayout.setGravity(1);
        this.guestEdituserTitleImage.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.guestEdituserTitleImage.setY((i * 30) / R2.bool.abc_config_actionMenuItemAllCaps);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.guestEdituserTitleImage.getLayoutParams();
        layoutParams4.height = (i * 28) / R2.bool.abc_config_actionMenuItemAllCaps;
        layoutParams4.width = (i2 * R2.attr.com_facebook_style) / 1024;
        this.guestEdituserTitleImage.setLayoutParams(layoutParams4);
        this.guestEdituserTitle.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView textView = this.guestEdituserTitle;
        int i3 = (i * 40) / R2.bool.abc_config_actionMenuItemAllCaps;
        textView.setY(i3);
        this.guestEdituserTitle.setTextSize(20.0f);
        this.guestEdituserTitle.setLayoutParams((LinearLayout.LayoutParams) this.guestEdituserTitle.getLayoutParams());
        this.edittext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.edittext.setY((i * 50) / R2.bool.abc_config_actionMenuItemAllCaps);
        this.guestEdituserAccountName.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.guestEdituserAccountName.setX((i2 * 165) / 1024);
        this.guestEdituserAccountName.setTextSize(10.0f);
        this.guestEdituserAccountName.setLayoutParams((LinearLayout.LayoutParams) this.guestEdituserAccountName.getLayoutParams());
        this.edittext1.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext1.setY((i * 60) / R2.bool.abc_config_actionMenuItemAllCaps);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.edittext1.getLayoutParams();
        layoutParams5.height = i3;
        int i4 = (i2 * 510) / 1024;
        layoutParams5.width = i4;
        this.edittext1.setLayoutParams(layoutParams5);
        this.height.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.height.setTextSize(10.0f);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.height.getLayoutParams();
        layoutParams6.height = i3;
        int i5 = (i2 * R2.attr.defaultState) / 1024;
        layoutParams6.width = i5;
        this.height.setLayoutParams(layoutParams6);
        this.weight.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        float f = (i2 * 50) / 1024;
        this.weight.setX(f);
        this.weight.setTextSize(10.0f);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.weight.getLayoutParams();
        layoutParams7.height = i3;
        layoutParams7.width = i5;
        this.weight.setLayoutParams(layoutParams7);
        this.edittext2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext2.setY((i * 200) / R2.bool.abc_config_actionMenuItemAllCaps);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.edittext2.getLayoutParams();
        layoutParams8.height = i3;
        layoutParams8.width = i4;
        this.edittext2.setLayoutParams(layoutParams8);
        this.cancel.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cancel.setTextSize(10.0f);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.cancel.getLayoutParams();
        layoutParams9.height = i3;
        layoutParams9.width = i5;
        this.cancel.setLayoutParams(layoutParams9);
        this.save.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.save.setX(f);
        this.save.setTextSize(10.0f);
        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) this.save.getLayoutParams();
        layoutParams10.height = i3;
        layoutParams10.width = i5;
        this.save.setLayoutParams(layoutParams10);
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
        this.guestEdituserContentLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.guestEdituserContentLayout.setBackgroundResource(R.drawable.main);
        this.guestEdituserContentLayout.setLayoutParams((LinearLayout.LayoutParams) this.guestEdituserContentLayout.getLayoutParams());
        this.guestEdituserContentLayout.setGravity(1);
        this.guestEdituserTitleImage.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.guestEdituserTitleImage.setY(30.0f * f3);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.guestEdituserTitleImage.getLayoutParams();
        layoutParams3.height = (int) ((28.0f * f3) + 0.5d);
        layoutParams3.width = (int) ((188.0f * f4) + 0.5d);
        this.guestEdituserTitleImage.setLayoutParams(layoutParams3);
        this.guestEdituserTitle.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.guestEdituserTitle.setY(45.0f * f3);
        this.guestEdituserTitle.setTextSize(16.0f);
        this.guestEdituserTitle.setTypeface(this.font);
        this.guestEdituserTitle.setLayoutParams((LinearLayout.LayoutParams) this.guestEdituserTitle.getLayoutParams());
        this.edittext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.edittext.setY(55.0f * f3);
        this.guestEdituserAccountName.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.guestEdituserAccountName.setX(165.0f * f4);
        this.guestEdituserAccountName.setTextSize(10.0f);
        this.guestEdituserAccountName.setTypeface(this.font);
        this.guestEdituserAccountName.setLayoutParams((LinearLayout.LayoutParams) this.guestEdituserAccountName.getLayoutParams());
        this.edittext1.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext1.setY(65.0f * f3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.edittext1.getLayoutParams();
        int i3 = (int) ((40.0f * f3) + 0.5d);
        layoutParams4.height = i3;
        int i4 = (int) ((510.0f * f4) + 0.5d);
        layoutParams4.width = i4;
        this.edittext1.setLayoutParams(layoutParams4);
        this.height.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.height.setTextSize(10.0f);
        this.height.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.height.getLayoutParams();
        layoutParams5.height = i3;
        int i5 = (int) ((230.0f * f4) + 0.5d);
        layoutParams5.width = i5;
        this.height.setLayoutParams(layoutParams5);
        this.weight.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        float f5 = f4 * 50.0f;
        this.weight.setX(f5);
        this.weight.setTextSize(10.0f);
        this.weight.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.weight.getLayoutParams();
        layoutParams6.height = i3;
        layoutParams6.width = i5;
        this.weight.setLayoutParams(layoutParams6);
        this.edittext2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.edittext2.setY(f3 * 225.0f);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.edittext2.getLayoutParams();
        layoutParams7.height = i3;
        layoutParams7.width = i4;
        this.edittext2.setLayoutParams(layoutParams7);
        this.cancel.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cancel.setTextSize(10.0f);
        this.cancel.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.cancel.getLayoutParams();
        layoutParams8.height = i3;
        layoutParams8.width = i5;
        this.cancel.setLayoutParams(layoutParams8);
        this.save.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.save.setX(f5);
        this.save.setTextSize(10.0f);
        this.save.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.save.getLayoutParams();
        layoutParams9.height = i3;
        layoutParams9.width = i5;
        this.save.setLayoutParams(layoutParams9);
    }

    public static boolean isPad(EditGuestFragment editGuestFragment) {
        return (editGuestFragment.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public void onHeightLinkagePicker() {
        LinkageProvider linkageProvider = new LinkageProvider() { // from class: com.dyaco.sole.fragment.user_profiles.EditGuestFragment.5
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
        LinkagePicker linkagePicker = new LinkagePicker(getActivity()) { // from class: com.dyaco.sole.fragment.user_profiles.EditGuestFragment.6
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
        linkagePicker.setOnLinkagePickedListener(new OnLinkagePickedListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditGuestFragment.7
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener
            public void onLinkagePicked(Object obj, Object obj2, Object obj3) {
                if ((obj instanceof String) && (obj2 instanceof String)) {
                    EditGuestFragment.this.height.setText(obj2 + StringUtils.SPACE + obj);
                    if (obj.equals("cm")) {
                        EditGuestFragment.this.height.setText(obj2 + StringUtils.SPACE + EditGuestFragment.this.getString(R.string.login_cm));
                        EditGuestFragment.this.heightValue = (String) obj2;
                        EditGuestFragment.this.heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    } else {
                        EditGuestFragment.this.height.setText(obj2 + StringUtils.SPACE + EditGuestFragment.this.getString(R.string.login_in));
                        float f = 0.0f;
                        try {
                            f = Float.parseFloat((String) obj2) * 2.54f;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        EditGuestFragment.this.heightValue = String.valueOf((int) (f + 0.5d));
                        EditGuestFragment.this.heightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    }
                    Log.v("skypoo", "height:" + EditGuestFragment.this.memberData.getHeight());
                }
            }
        });
        linkagePicker.show();
    }

    public void onWeightLinkagePicker() {
        LinkageProvider linkageProvider = new LinkageProvider() { // from class: com.dyaco.sole.fragment.user_profiles.EditGuestFragment.8
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
        LinkagePicker linkagePicker = new LinkagePicker(getActivity()) { // from class: com.dyaco.sole.fragment.user_profiles.EditGuestFragment.9
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
        linkagePicker.setOnLinkagePickedListener(new OnLinkagePickedListener() { // from class: com.dyaco.sole.fragment.user_profiles.EditGuestFragment.10
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener
            public void onLinkagePicked(Object obj, Object obj2, Object obj3) {
                if ((obj instanceof String) && (obj2 instanceof String)) {
                    EditGuestFragment.this.weight.setText(obj2 + StringUtils.SPACE + obj);
                    if (obj.equals("kg")) {
                        EditGuestFragment.this.weight.setText(obj2 + StringUtils.SPACE + EditGuestFragment.this.getString(R.string.login_kg));
                        EditGuestFragment.this.weightValue = (String) obj2;
                        EditGuestFragment.this.weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    } else {
                        EditGuestFragment.this.weight.setText(obj2 + StringUtils.SPACE + EditGuestFragment.this.getString(R.string.login_lb));
                        float f = 0.0f;
                        try {
                            f = Float.parseFloat((String) obj2) * 0.454f;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        EditGuestFragment.this.weightValue = String.valueOf((int) (f + 0.5d));
                        EditGuestFragment.this.weightUnitType = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    }
                    Log.v("skypoo", "weightValue:" + EditGuestFragment.this.weightValue);
                }
            }
        });
        linkagePicker.show();
    }
}
