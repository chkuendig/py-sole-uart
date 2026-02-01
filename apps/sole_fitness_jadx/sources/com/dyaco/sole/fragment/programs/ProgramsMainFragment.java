package com.dyaco.sole.fragment.programs;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.PostUtil;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.TypefaceTextView;
import com.dyaco.sole.fragment.BaseFragment;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class ProgramsMainFragment extends BaseFragment implements View.OnClickListener {
    private MainActivity activity;
    private TypefaceTextView edit_profile_textview;
    private TypefaceTextView not_user_textview;
    private View.OnClickListener onClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id != R.id.edit_profile_textview) {
                if (id != R.id.not_user_textview) {
                    return;
                }
                ErrorLogSave.addErrorString(ProgramsMainFragment.this.getActivity(), ErrorLogSave.CLICK, "ProgramsMainFragment_not_user", ErrorLogSave.CLICK);
                ProgramsMainFragment.this.activity.switchFragment(0);
                return;
            }
            ErrorLogSave.addErrorString(ProgramsMainFragment.this.getActivity(), ErrorLogSave.CLICK, "ProgramsMainFragment_edit_profile", ErrorLogSave.CLICK);
            PostUtil.postTrackerData(ProgramsMainFragment.this.activity, 5);
            if (Global.userName.equals(ProgramsMainFragment.this.getString(R.string.guest))) {
                ProgramsMainFragment.this.activity.switchFragment(12);
            } else {
                ProgramsMainFragment.this.activity.switchFragment(11);
            }
        }
    };
    private TableLayout programs_tablelayout;
    private View rootView;
    private TypefaceTextView title_textview;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.activity = (MainActivity) getActivity();
        int i = Global.BRAND;
        if (i == 0) {
            this.rootView = layoutInflater.inflate(R.layout.fragment_programs_main, viewGroup, false);
        } else if (i == 1 || i == 2 || i == 3) {
            this.rootView = layoutInflater.inflate(R.layout.s_fragment_programs_main, viewGroup, false);
        }
        findViews();
        setListeners();
        return this.rootView;
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        this.title_textview.setText(String.format(getString(R.string.welcome_back), Global.memberData.getName()));
        this.not_user_textview.setText(String.format(getString(R.string.not_user), Global.memberData.getName()));
        handleDeviceModelView();
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void findViews() {
        this.title_textview = (TypefaceTextView) this.rootView.findViewById(R.id.title_textview);
        this.not_user_textview = (TypefaceTextView) this.rootView.findViewById(R.id.not_user_textview);
        this.edit_profile_textview = (TypefaceTextView) this.rootView.findViewById(R.id.edit_profile_textview);
        this.programs_tablelayout = (TableLayout) this.rootView.findViewById(R.id.programs_tablelayout);
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void initParams() {
        View viewInflate;
        Resources resources = getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.title_textview.getLayoutParams();
        layoutParams.height = Global.getLongScreenHeight((int) resources.getDimension(R.dimen.all_title_height), 1.0f);
        this.title_textview.setLayoutParams(layoutParams);
        if (Global.BRAND == 0) {
            this.title_textview.setTypeface(this.activity, Global.fontsPath[2], 1);
        }
        this.title_textview.setTextSize(0, Global.getLongScreenHeight((int) resources.getDimension(R.dimen.all_title_text_size), 1.0f));
        int iDpToPixel = (int) Global.dpToPixel(25.0f);
        int dimensionPixelSize = ((((Global.screenHeight - resources.getDimensionPixelSize(R.dimen.main_title_bg_height)) - resources.getDimensionPixelSize(R.dimen.all_title_height)) - resources.getDimensionPixelSize(R.dimen.programs_main_text_height)) / 2) - iDpToPixel;
        int i = Global.screenWidth / 7;
        if (dimensionPixelSize >= i) {
            dimensionPixelSize = i - iDpToPixel;
        }
        this.programs_tablelayout.removeAllViews();
        int i2 = 0;
        for (int i3 = 0; i3 < DeviceModelList.programTextsLocation.length; i3++) {
            TableRow tableRow = new TableRow(this.activity);
            tableRow.setGravity(17);
            int[] iArr = DeviceModelList.programTextsLocation[i3];
            int[] iArr2 = DeviceModelList.programImagesLocation[i3];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                int i5 = Global.BRAND;
                if (i5 == 0) {
                    viewInflate = View.inflate(this.activity, R.layout.item_programs, null);
                } else if (i5 != 1 && i5 != 2 && i5 != 3) {
                    return;
                } else {
                    viewInflate = View.inflate(this.activity, R.layout.s_item_programs, null);
                }
                viewInflate.setId(i2);
                i2++;
                viewInflate.setOnClickListener(this);
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.item_program_layout);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = dimensionPixelSize;
                linearLayout.setLayoutParams(layoutParams2);
                ((ImageView) viewInflate.findViewById(R.id.item_program_imageview)).setImageResource(iArr2[i4]);
                ((TextView) viewInflate.findViewById(R.id.item_program_textview)).setText(iArr[i4]);
                tableRow.addView(viewInflate);
            }
            this.programs_tablelayout.addView(tableRow);
        }
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void setListeners() {
        this.not_user_textview.setOnClickListener(this.onClick);
        this.edit_profile_textview.setOnClickListener(this.onClick);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0108  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        int i = Global.BRAND;
        if (i != 0) {
            if (i == 1 || i == 2 || i == 3) {
                switch (view.getId()) {
                    case 0:
                        this.activity.switchFragment(65);
                        break;
                    case 1:
                        this.activity.switchFragment(66);
                        break;
                    case 2:
                        this.activity.switchFragment(67);
                        break;
                    case 3:
                        this.activity.switchFragment(68);
                        break;
                    case 4:
                        this.activity.switchFragment(69);
                        break;
                    case 5:
                        this.activity.switchFragment(70);
                        break;
                    case 6:
                        this.activity.switchFragment(71);
                        break;
                    case 7:
                        this.activity.switchFragment(72);
                        break;
                    case 8:
                        this.activity.switchFragment(73);
                        break;
                    case 9:
                        this.activity.switchFragment(74);
                        break;
                    case 10:
                        this.activity.switchFragment(75);
                        break;
                    case 11:
                        this.activity.switchFragment(76);
                        break;
                }
            }
            return;
        }
        ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "ProgramsMainFragment_select_program", "deviceModel:" + ProtocolHandler.protocol.deviceModel + "_program:" + view.getId());
        int i2 = ProtocolHandler.protocol.deviceModel;
        if (i2 != 64) {
            switch (i2) {
                case 16:
                case 17:
                    switch (view.getId()) {
                        case 0:
                            this.activity.switchFragment(65);
                            break;
                        case 1:
                            this.activity.switchFragment(66);
                            break;
                        case 2:
                            this.activity.switchFragment(67);
                            break;
                        case 3:
                            this.activity.switchFragment(68);
                            break;
                        case 4:
                            this.activity.switchFragment(69);
                            break;
                        case 5:
                            this.activity.switchFragment(70);
                            break;
                        case 6:
                            this.activity.switchFragment(71);
                            break;
                        case 7:
                            this.activity.switchFragment(72);
                            break;
                        case 8:
                            this.activity.switchFragment(73);
                            break;
                    }
                case 18:
                case 19:
                case 22:
                case 23:
                case 24:
                case 25:
                case 27:
                case 28:
                    switch (view.getId()) {
                        case 0:
                            this.activity.switchFragment(65);
                            break;
                        case 1:
                            this.activity.switchFragment(67);
                            break;
                        case 2:
                            this.activity.switchFragment(69);
                            break;
                        case 3:
                            this.activity.switchFragment(71);
                            break;
                        case 4:
                            this.activity.switchFragment(73);
                            break;
                        case 5:
                            this.activity.switchFragment(66);
                            break;
                        case 6:
                            this.activity.switchFragment(68);
                            break;
                        case 7:
                            this.activity.switchFragment(70);
                            break;
                        case 8:
                            this.activity.switchFragment(72);
                            break;
                        case 9:
                            this.activity.switchFragment(74);
                            break;
                    }
                case 20:
                case 21:
                case 26:
                    switch (view.getId()) {
                        case 0:
                            this.activity.switchFragment(65);
                            break;
                        case 1:
                            this.activity.switchFragment(67);
                            break;
                        case 2:
                            this.activity.switchFragment(69);
                            break;
                        case 3:
                            this.activity.switchFragment(72);
                            break;
                        case 4:
                            this.activity.switchFragment(66);
                            break;
                        case 5:
                            this.activity.switchFragment(68);
                            break;
                        case 6:
                            this.activity.switchFragment(70);
                            break;
                        case 7:
                            this.activity.switchFragment(71);
                            break;
                        case 8:
                            this.activity.switchFragment(73);
                            break;
                    }
                case 29:
                case 30:
                case 31:
                    break;
                default:
                    switch (i2) {
                    }
            }
        }
        switch (view.getId()) {
            case 0:
                this.activity.switchFragment(65);
                break;
            case 1:
                this.activity.switchFragment(66);
                break;
            case 2:
                this.activity.switchFragment(67);
                break;
            case 3:
                this.activity.switchFragment(68);
                break;
            case 4:
                this.activity.switchFragment(69);
                break;
            case 5:
                this.activity.switchFragment(70);
                break;
            case 6:
                this.activity.switchFragment(71);
                break;
            case 7:
                this.activity.switchFragment(72);
                break;
            case 8:
                this.activity.switchFragment(73);
                break;
            case 9:
                this.activity.switchFragment(74);
                break;
        }
    }

    private void handleDeviceModelView() {
        initParams();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
