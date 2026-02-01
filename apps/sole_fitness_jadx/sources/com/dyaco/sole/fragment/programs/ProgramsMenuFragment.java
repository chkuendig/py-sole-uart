package com.dyaco.sole.fragment.programs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.Execute;
import com.dyaco.sole.MyApp;
import com.dyaco.sole.activity.ConnectionDialog;
import com.dyaco.sole.activity.GarminConnectLoginActivity;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.activity.OmronConnectLoginActivity;
import com.dyaco.sole.activity.OutdoorMapsActivity;
import com.dyaco.sole.custom.Event;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.fragment.BaseFragment;
import com.facebook.appevents.AppEventsConstants;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.OAuthConstants;

/* loaded from: classes.dex */
public class ProgramsMenuFragment extends BaseFragment {
    private static final String TAG = "ProgramsMenuFragment";
    private MainActivity activity;
    private ImageView btn_garmin_connect;
    private ImageView btn_omron_connect;
    private View garmin_menu;
    private Button garmin_menu_close;
    private Button garmin_menu_logout;
    private Button garmin_menu_syncdata;
    private View indoor;
    private ImageView item_img;
    private ImageView item_img2;
    private TextView item_text;
    private TextView item_text2;
    private View outdoor;
    private View rootView;
    private boolean touchOmronBtn;
    private String member_no = null;
    private String garminToken = null;
    private View.OnClickListener onClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsMenuFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.d("Garmin", "id:" + view.getId());
            Log.d("Garmin", "idd2131230850");
            switch (view.getId()) {
                case R.id.btnGarmin /* 2131230850 */:
                    ErrorLogSave.addErrorString(ProgramsMenuFragment.this.getActivity(), ErrorLogSave.CLICK, "ProgramsMenuFragment_btnGarmin", ErrorLogSave.CLICK);
                    Log.d("Garmin", "btnGarmin");
                    ProgramsMenuFragment.this.OpenGarminConnect();
                    break;
                case R.id.btnIndoor /* 2131230852 */:
                    ErrorLogSave.addErrorString(ProgramsMenuFragment.this.getActivity(), ErrorLogSave.CLICK, "ProgramsMenuFragment_btnIndoor", ErrorLogSave.CLICK);
                    if (!ProtocolHandler.protocol.isConnected()) {
                        ProgramsMenuFragment.this.goConnection();
                        break;
                    } else {
                        int i = Global.BRAND;
                        if (i == 0) {
                            ProgramsMenuFragment.this.activity.switchFragment(3);
                            break;
                        } else if (i == 1) {
                            ProgramsMenuFragment.this.activity.switchFragment(3);
                            break;
                        } else if (i == 2 || i == 3) {
                            if (ProtocolHandler.protocol.salesVersion == 1) {
                                ProgramsMenuFragment.this.activity.switchFragment(5);
                                break;
                            } else {
                                ProgramsMenuFragment.this.activity.switchFragment(3);
                                break;
                            }
                        }
                    }
                case R.id.btnOmron /* 2131230855 */:
                    ErrorLogSave.addErrorString(ProgramsMenuFragment.this.getActivity(), ErrorLogSave.CLICK, "ProgramsMenuFragment_btnOmron", ErrorLogSave.CLICK);
                    Log.d("Omron", "btnOmron");
                    ProgramsMenuFragment.this.OpenOmronConnect();
                    break;
                case R.id.btnOutdoor /* 2131230856 */:
                    ErrorLogSave.addErrorString(ProgramsMenuFragment.this.getActivity(), ErrorLogSave.CLICK, "ProgramsMenuFragment_btnOutdoor", ErrorLogSave.CLICK);
                    if (ProgramsMenuFragment.this.isOpenGps()) {
                        ProgramsMenuFragment.this.goPage(OutdoorMapsActivity.class);
                        break;
                    } else {
                        ProgramsMenuFragment.this.buildAlertMessageNoGps();
                        break;
                    }
                case R.id.garmin_menu /* 2131231240 */:
                    Log.d("Garmin", "garmin_menu");
                    ProgramsMenuFragment.this.garminToClose();
                    break;
                case R.id.garmin_menu_close /* 2131231241 */:
                    Log.d("Garmin", "garmin_menu_close");
                    ProgramsMenuFragment.this.touchOmronBtn = false;
                    ProgramsMenuFragment.this.garminToClose();
                    break;
                case R.id.garmin_menu_logout /* 2131231242 */:
                    Log.d("Garmin", "garmin_menu_logout");
                    ProgramsMenuFragment.this.garminToLogout();
                    break;
                case R.id.garmin_menu_syncdata /* 2131231243 */:
                    Log.d("Garmin", "garmin_menu_syncdata");
                    ProgramsMenuFragment.this.garminToSync();
                    break;
            }
        }
    };

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) throws SecurityException {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.activity = (MainActivity) getActivity();
        int i = Global.BRAND;
        if (i == 0) {
            this.rootView = layoutInflater.inflate(R.layout.fragment_programs_menu, viewGroup, false);
        } else if (i == 1 || i == 2 || i == 3) {
            this.rootView = layoutInflater.inflate(R.layout.s_fragment_programs_menu, viewGroup, false);
        }
        findViews();
        initParams();
        setListeners();
        return this.rootView;
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        Logger.d("hiddenaaa = " + z);
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void findViews() {
        View viewFindViewById = this.rootView.findViewById(R.id.btnIndoor);
        this.indoor = viewFindViewById;
        this.item_img = (ImageView) viewFindViewById.findViewById(R.id.item_program_imageview);
        this.item_text = (TextView) this.indoor.findViewById(R.id.item_program_textview);
        View viewFindViewById2 = this.rootView.findViewById(R.id.btnOutdoor);
        this.outdoor = viewFindViewById2;
        this.item_img2 = (ImageView) viewFindViewById2.findViewById(R.id.item_program_imageview);
        this.item_text2 = (TextView) this.outdoor.findViewById(R.id.item_program_textview);
        this.btn_garmin_connect = (ImageView) this.rootView.findViewById(R.id.btnGarmin);
        this.garmin_menu = this.rootView.findViewById(R.id.garmin_menu);
        this.garmin_menu_syncdata = (Button) this.rootView.findViewById(R.id.garmin_menu_syncdata);
        this.garmin_menu_logout = (Button) this.rootView.findViewById(R.id.garmin_menu_logout);
        this.garmin_menu_close = (Button) this.rootView.findViewById(R.id.garmin_menu_close);
        this.garmin_menu.setVisibility(8);
        this.btn_omron_connect = (ImageView) this.rootView.findViewById(R.id.btnOmron);
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void initParams() {
        int i = Global.BRAND;
        if (i == 0) {
            this.item_img.setImageResource(R.drawable.indoor_black);
            this.item_text.setText(R.string.program_btn_text_indoor);
            this.item_img2.setImageResource(R.drawable.outdoor_black);
            this.item_text2.setText(R.string.program_btn_text_outdoor);
            return;
        }
        if (i == 1 || i == 2 || i == 3) {
            this.item_img.setImageResource(R.drawable.indoor_white);
            this.item_text.setText(R.string.program_btn_text_indoor);
            this.item_img2.setImageResource(R.drawable.outdoor_white);
            this.item_text2.setText(R.string.program_btn_text_outdoor);
        }
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void setListeners() {
        this.indoor.setOnClickListener(this.onClick);
        this.outdoor.setOnClickListener(this.onClick);
        this.btn_garmin_connect.setOnClickListener(this.onClick);
        this.btn_omron_connect.setOnClickListener(this.onClick);
        this.garmin_menu.setOnClickListener(this.onClick);
        this.garmin_menu_syncdata.setOnClickListener(this.onClick);
        this.garmin_menu_logout.setOnClickListener(this.onClick);
        this.garmin_menu_close.setOnClickListener(this.onClick);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        Log.d("onActivityCreated", "onResume");
        CheckIsLoginGarmin();
        CheckIsLoginOmron();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public void CheckIsLoginGarmin() {
        setGarminBtnView();
        if (Global.memberData != null) {
            this.member_no = "" + Global.memberData.getAccount_no();
        }
        if (Global.memberData != null && this.member_no != null) {
            String account = Global.memberData.getAccount();
            if (account == null) {
                return;
            }
            Execute.getMemberInfo(account, new Callback() { // from class: com.dyaco.sole.fragment.programs.ProgramsMenuFragment.2
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    iOException.printStackTrace();
                    ProgramsMenuFragment.this.setGarminBtnView();
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws JSONException, IOException {
                    try {
                        String strString = response.body().string();
                        Log.d(ProgramsMenuFragment.TAG, "getMemberInfo -> onResponse data=" + strString);
                        JSONObject jSONObject = new JSONObject(strString);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("sys_response_message");
                        JSONObject jSONObject3 = jSONObject.getJSONObject("sys_response_data");
                        String string = jSONObject2.getString(OAuthConstants.CODE);
                        ProgramsMenuFragment.this.garminToken = jSONObject3.getString("user_access_token");
                        if (!TextUtils.equals(string, AppEventsConstants.EVENT_PARAM_VALUE_YES) || !TextUtils.isEmpty(ProgramsMenuFragment.this.garminToken)) {
                            ProgramsMenuFragment.this.setGarminBtnView();
                        } else {
                            ProgramsMenuFragment.this.setGarminBtnView();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        ProgramsMenuFragment.this.setGarminBtnView();
                    }
                }
            });
            return;
        }
        setGarminBtnView();
    }

    public void CheckIsLoginOmron() {
        if ("".equals(MyApp.omron_access_token)) {
            this.btn_omron_connect.setImageResource(R.drawable.btn_omron_connect_0);
        } else {
            this.btn_omron_connect.setImageResource(R.drawable.btn_omron_connect_1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OpenGarminConnect() {
        if (TextUtils.isEmpty(this.garminToken)) {
            goGarminConnect();
            Log.d(TAG, "goGarminConnect1");
        } else {
            this.garmin_menu.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OpenOmronConnect() {
        if ("".equals(MyApp.omron_access_token)) {
            goOmronConnect();
        } else {
            this.touchOmronBtn = true;
            this.garmin_menu.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void garminToSync() {
        garminToClose();
        if (this.touchOmronBtn) {
            this.touchOmronBtn = false;
            new MyApp().getOmronSearchDate();
        }
        this.activity.startDataSyncTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void garminToLogout() {
        garminToClose();
        if (this.touchOmronBtn) {
            this.touchOmronBtn = false;
            goOmronConnect();
        } else {
            updateGarminClearToken();
        }
    }

    private void updateGarminClearToken() {
        String account = Global.getAccount(this.activity);
        String password = Global.getPassword(this.activity);
        if (account == null) {
            garminToClose();
        } else {
            Execute.registUpdate(account, password, "-1", new Callback() { // from class: com.dyaco.sole.fragment.programs.ProgramsMenuFragment.3
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    Log.e(ProgramsMenuFragment.TAG, "updateUserData -> onFailure Exception=" + iOException.toString());
                    iOException.printStackTrace();
                    ErrorLogSave.addErrorString(ProgramsMenuFragment.this.activity.getApplicationContext(), ErrorLogSave.EXECUTE, "login_login_btn", "login_error_" + iOException);
                    ProgramsMenuFragment.this.CheckIsLoginGarmin();
                    ProgramsMenuFragment.this.garminToClose();
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        try {
                            String strString = response.body().string();
                            Log.d(ProgramsMenuFragment.TAG, "updateUserData -> onResponse data=" + strString);
                            if (TextUtils.equals(new JSONObject(strString).getJSONObject("sys_response_message").getString(OAuthConstants.CODE), AppEventsConstants.EVENT_PARAM_VALUE_YES) && ProgramsMenuFragment.this.rootView != null) {
                                ProgramsMenuFragment.this.rootView.post(new Runnable() { // from class: com.dyaco.sole.fragment.programs.ProgramsMenuFragment.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        EventBus.getDefault().post(new Event.GarminEvent(0));
                                    }
                                });
                            }
                        } catch (Exception e) {
                            Log.e(ProgramsMenuFragment.TAG, "updateUserData -> onResponse Exception" + e);
                            e.printStackTrace();
                            if (ProgramsMenuFragment.this.rootView != null) {
                                ProgramsMenuFragment.this.rootView.post(new Runnable() { // from class: com.dyaco.sole.fragment.programs.ProgramsMenuFragment.3.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ErrorLogSave.addErrorString(ProgramsMenuFragment.this.activity.getApplicationContext(), ErrorLogSave.EXECUTE, "login_login_btn", "login_error_" + e);
                                    }
                                });
                            }
                        }
                    } finally {
                        ProgramsMenuFragment.this.CheckIsLoginGarmin();
                        ProgramsMenuFragment.this.garminToClose();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void garminToClose() {
        Runnable runnable = new Runnable() { // from class: com.dyaco.sole.fragment.programs.ProgramsMenuFragment.4
            @Override // java.lang.Runnable
            public void run() {
                ProgramsMenuFragment.this.garmin_menu.setVisibility(8);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        View view = this.rootView;
        if (view != null) {
            view.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGarminBtnView() {
        Runnable runnable = new Runnable() { // from class: com.dyaco.sole.fragment.programs.ProgramsMenuFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (Global.memberData == null || TextUtils.isEmpty(Global.memberData.getAccount()) || Global.memberData.getAccount().toLowerCase().equals("guest")) {
                    ProgramsMenuFragment.this.btn_garmin_connect.setVisibility(8);
                } else if (!TextUtils.isEmpty(ProgramsMenuFragment.this.garminToken)) {
                    ProgramsMenuFragment.this.btn_garmin_connect.setImageResource(R.drawable.btn_garrmin_connect_1);
                } else {
                    ProgramsMenuFragment.this.btn_garmin_connect.setImageResource(R.drawable.btn_garrmin_connect_0);
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        View view = this.rootView;
        if (view != null) {
            view.post(runnable);
        }
    }

    private void goGarminConnect() {
        Intent intent = new Intent(this.activity, (Class<?>) GarminConnectLoginActivity.class);
        intent.putExtra("auth", true);
        startActivityForResult(intent, 101);
        this.activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void goOmronConnect() {
        startActivityForResult(new Intent(this.activity, (Class<?>) OmronConnectLoginActivity.class), 101);
        this.activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Subscribe(sticky = false, threadMode = ThreadMode.MAIN)
    public void onGarminEvent(Event.GarminEvent garminEvent) {
        String account;
        int eventode = garminEvent.getEventode();
        if ((eventode != 0 && eventode != 1) || Global.memberData == null || (account = Global.memberData.getAccount()) == null) {
            return;
        }
        Execute.getMemberInfo(account, new Callback() { // from class: com.dyaco.sole.fragment.programs.ProgramsMenuFragment.6
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                iOException.printStackTrace();
                ProgramsMenuFragment.this.setGarminBtnView();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws JSONException, IOException {
                try {
                    String strString = response.body().string();
                    Log.d(ProgramsMenuFragment.TAG, "getMemberInfo -> onResponse data=" + strString);
                    JSONObject jSONObject = new JSONObject(strString);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("sys_response_message");
                    JSONObject jSONObject3 = jSONObject.getJSONObject("sys_response_data");
                    String string = jSONObject2.getString(OAuthConstants.CODE);
                    ProgramsMenuFragment.this.garminToken = jSONObject3.getString("user_access_token");
                    if (!TextUtils.equals(string, AppEventsConstants.EVENT_PARAM_VALUE_YES) || !TextUtils.isEmpty(ProgramsMenuFragment.this.garminToken)) {
                        ProgramsMenuFragment.this.setGarminBtnView();
                    } else {
                        ProgramsMenuFragment.this.setGarminBtnView();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ProgramsMenuFragment.this.setGarminBtnView();
                }
            }
        });
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws IOException {
        super.onActivityResult(i, i2, intent);
        if (i == 99 && i2 == -1) {
            int i3 = Global.BRAND;
            if (i3 == 0) {
                this.activity.switchFragment(3);
                return;
            }
            if (i3 == 1) {
                this.activity.switchFragment(3);
                return;
            }
            if (i3 == 2 || i3 == 3) {
                if (ProtocolHandler.protocol.salesVersion == 1) {
                    this.activity.startWorkout();
                    this.activity.switchFragment(5);
                } else {
                    this.activity.switchFragment(3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goPage(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this.activity, cls);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goConnection() {
        startActivityForResult(new Intent(getActivity(), (Class<?>) ConnectionDialog.class), 99);
        this.activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOpenGps() {
        return ((LocationManager) this.activity.getSystemService("location")).isProviderEnabled("gps");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildAlertMessageNoGps() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsMenuFragment.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ProgramsMenuFragment.this.activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsMenuFragment.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }
}
