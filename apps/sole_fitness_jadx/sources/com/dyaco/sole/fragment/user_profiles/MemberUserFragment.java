package com.dyaco.sole.fragment.user_profiles;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.activity.LoginActivity;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.fragment.BaseFragment;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class MemberUserFragment extends BaseFragment {
    private MainActivity activity;
    private EditGuestFragment editGuestFragment;
    Button editProfile;
    private EditUserFragment editUserFragment;
    Button exportData;
    Typeface font;
    Button logout;
    LinearLayout mainLayout;
    private View rootView;
    RelativeLayout userBackgroundLayout;
    LinearLayout userContentLayout;
    ImageView userImageView;
    TextView userTitle;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.activity = (MainActivity) getActivity();
        this.rootView = layoutInflater.inflate(R.layout.fragment_member_user, viewGroup, false);
        findViews();
        initParams();
        setListeners();
        return this.rootView;
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void findViews() {
        this.userBackgroundLayout = (RelativeLayout) this.rootView.findViewById(R.id.user_background_layout);
        this.mainLayout = (LinearLayout) this.rootView.findViewById(R.id.user_main_layout);
        this.userContentLayout = (LinearLayout) this.rootView.findViewById(R.id.user_contentlinearlayout);
        this.userImageView = (ImageView) this.rootView.findViewById(R.id.user_imageView);
        this.userTitle = (TextView) this.rootView.findViewById(R.id.user_title);
        this.editProfile = (Button) this.rootView.findViewById(R.id.user_edit_profile);
        this.logout = (Button) this.rootView.findViewById(R.id.user_logout);
        this.exportData = (Button) this.rootView.findViewById(R.id.user_export_old_data);
        this.font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/HelveticaNeueLight.ttf");
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void initParams() {
        int i = Global.BRAND;
        if (i == 0) {
            this.userImageView.setBackgroundResource(R.drawable.user_sole_leftpic);
            this.exportData.setBackgroundResource(R.drawable.user_sole_button_c0);
        } else if (i == 1) {
            this.userImageView.setBackgroundResource(R.drawable.user_spirit_leftpic);
            this.editProfile.setBackgroundResource(R.drawable.user_spirit_button_b);
            this.logout.setBackgroundResource(R.drawable.user_spirit_button_b);
            this.exportData.setBackgroundResource(R.drawable.user_spirit_button_a);
            this.editProfile.setTextColor(-1);
            this.logout.setTextColor(-1);
        } else if (i == 2) {
            this.userImageView.setBackgroundResource(R.drawable.user_xterra_leftpic);
            this.exportData.setBackgroundResource(R.drawable.user_xterra_button_c0);
        } else if (i == 3) {
            this.userImageView.setBackgroundResource(R.drawable.user_fuel_leftpic);
            this.exportData.setBackgroundResource(R.drawable.user_fuel_button_c0);
        }
        initPhone();
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void setListeners() {
        this.editProfile.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.MemberUserFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(MemberUserFragment.this.getActivity(), ErrorLogSave.CLICK, "MemberUserFragment_editProfile", "click_userName:" + Global.userName);
                if (Global.userName.equals(MemberUserFragment.this.getString(R.string.guest))) {
                    FragmentTransaction fragmentTransactionBeginTransaction = MemberUserFragment.this.getFragmentManager().beginTransaction();
                    fragmentTransactionBeginTransaction.show(MemberUserFragment.this.editGuestFragment);
                    fragmentTransactionBeginTransaction.setTransition(4097);
                    fragmentTransactionBeginTransaction.commit();
                    return;
                }
                FragmentTransaction fragmentTransactionBeginTransaction2 = MemberUserFragment.this.getFragmentManager().beginTransaction();
                fragmentTransactionBeginTransaction2.show(MemberUserFragment.this.editUserFragment);
                fragmentTransactionBeginTransaction2.setTransition(4097);
                fragmentTransactionBeginTransaction2.commit();
            }
        });
        this.logout.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.MemberUserFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(MemberUserFragment.this.getActivity(), ErrorLogSave.CLICK, "MemberUserFragment_logout", ErrorLogSave.CLICK);
                MemberUserFragment.this.clearDATA();
                Intent intent = new Intent();
                intent.setFlags(268468224);
                intent.setClass(MemberUserFragment.this.getActivity(), LoginActivity.class);
                MemberUserFragment.this.startActivity(intent);
                MemberUserFragment.this.getActivity().finish();
            }
        });
        this.exportData.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.user_profiles.MemberUserFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(MemberUserFragment.this.getActivity(), ErrorLogSave.CLICK, "MemberUserFragment_exportData", ErrorLogSave.CLICK);
                MemberUserFragment.this.activity.goExportUser();
            }
        });
    }

    public static boolean isPad(MemberUserFragment memberUserFragment) {
        return (memberUserFragment.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private void initPhone() {
        float f;
        float f2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        if (isPad(this)) {
            int i3 = (i * 4) / 3;
            f = i / 760.0f;
            f2 = i3 / 1024.0f;
        } else {
            float f3 = i;
            float f4 = f3 - ((f3 / 768.0f) * 144.0f);
            f = f4 / 460.0f;
            f2 = ((f4 / 23.0f) * 39.0f) / 780.0f;
        }
        if (isPad(this)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = (int) (820.0f * f2);
            layoutParams.height = (int) (f * 500.0f);
            layoutParams.topMargin = (int) (f * 20.0f);
            layoutParams.bottomMargin = (int) (88.0f * f);
            layoutParams.addRule(13);
            this.mainLayout.setLayoutParams(layoutParams);
            if (Global.BRAND == 1) {
                this.mainLayout.setBackgroundResource(R.drawable.signup_spirit_main);
            }
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = (int) (780.0f * f2);
            layoutParams2.height = (int) (f * 460.0f);
            layoutParams2.addRule(14, -1);
            this.mainLayout.setLayoutParams(layoutParams2);
            this.mainLayout.setBackgroundResource(R.drawable.my_edittext);
            if (Global.BRAND == 1) {
                this.mainLayout.setBackgroundResource(R.drawable.main3);
            }
        }
        if (isPad(this)) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.height = (int) (f * 460.0f);
            layoutParams3.width = (int) (500.0f * f2);
            layoutParams3.topMargin = (int) (f * 20.0f);
            this.userContentLayout.setLayoutParams(layoutParams3);
            this.userContentLayout.setX(0.0f);
            this.userContentLayout.setY(0.0f);
            this.userContentLayout.setGravity(1);
        } else {
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.height = (int) ((f * 460.0f) + 0.5d);
            layoutParams4.width = (int) ((500.0f * f2) + 0.5d);
            this.userContentLayout.setLayoutParams(layoutParams4);
            this.userContentLayout.setGravity(1);
            this.userContentLayout.setBackgroundResource(R.drawable.main);
        }
        if (isPad(this)) {
            int i4 = Global.BRAND;
            int i5 = (i4 == 1 || i4 == 2 || i4 == 3) ? (int) (f * 20.0f) : 0;
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.height = (int) ((460.0f * f) - i5);
            layoutParams5.width = (int) (280.0f * f2);
            layoutParams5.topMargin = (int) (f * 20.0f);
            layoutParams5.leftMargin = (int) (f2 * 20.0f);
            this.userImageView.setLayoutParams(layoutParams5);
            this.userImageView.setX(0.0f);
            this.userImageView.setY(0.0f);
        } else {
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams6.height = (int) (460.0f * f);
            layoutParams6.width = (int) (280.0f * f2);
            this.userImageView.setLayoutParams(layoutParams6);
        }
        this.userTitle.setLayoutParams((LinearLayout.LayoutParams) this.userTitle.getLayoutParams());
        this.userTitle.setY(64.0f * f);
        this.userTitle.setTextSize(20.0f);
        this.userTitle.setTypeface(this.font);
        this.editProfile.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.editProfile.setY(120.0f * f);
        this.editProfile.setTextSize(10.0f);
        this.editProfile.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.editProfile.getLayoutParams();
        int i6 = (int) ((40.0f * f) + 0.5d);
        layoutParams7.height = i6;
        int i7 = (int) ((f2 * 230.0f) + 0.5d);
        layoutParams7.width = i7;
        this.editProfile.setLayoutParams(layoutParams7);
        this.logout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.logout.setY(140.0f * f);
        this.logout.setTextSize(10.0f);
        this.logout.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.logout.getLayoutParams();
        layoutParams8.height = i6;
        layoutParams8.width = i7;
        this.logout.setLayoutParams(layoutParams8);
        this.exportData.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.exportData.setY(f * 220.0f);
        this.exportData.setTextSize(10.0f);
        this.exportData.setTypeface(this.font);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.exportData.getLayoutParams();
        layoutParams9.height = i6;
        layoutParams9.width = i7;
        this.exportData.setLayoutParams(layoutParams9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDATA() {
        getActivity().getSharedPreferences("DATA", 0).edit().clear().apply();
    }

    public void setEditUserFragment(EditUserFragment editUserFragment) {
        this.editUserFragment = editUserFragment;
    }

    public EditUserFragment getEditUserFragment() {
        return this.editUserFragment;
    }

    public void setEditGuestFragment(EditGuestFragment editGuestFragment) {
        this.editGuestFragment = editGuestFragment;
    }

    public EditGuestFragment getEditGuestFragment() {
        return this.editGuestFragment;
    }
}
