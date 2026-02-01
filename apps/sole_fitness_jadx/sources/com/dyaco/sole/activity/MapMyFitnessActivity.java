package com.dyaco.sole.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.PostUtil;
import com.dyaco.sole.custom.ProtocolHandler;
import com.facebook.appevents.AppEventsConstants;
import com.soletreadmills.sole.R;
import com.ua.sdk.CreateCallback;
import com.ua.sdk.Ua;
import com.ua.sdk.UaException;
import com.ua.sdk.activitytype.ActivityTypeRef;
import com.ua.sdk.internal.UaProviderImpl;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.user.User;
import com.ua.sdk.workout.Workout;
import com.ua.sdk.workout.WorkoutBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.scribe.model.OAuthConstants;

/* loaded from: classes.dex */
public class MapMyFitnessActivity extends Activity {
    private static final String API_KEY = "x5r2ckrpywsx236qngmycwwxz9725bbg";
    private static final String API_SECRET = "jktG2keRDJWtwGzP679XbTXcqyayMku8GwqJYpG8NHZ";
    public static final String REDIRECT_URI = "http://localhost.mapmyapi.com:12345/callback/";
    private static final String TAG = "Sole-MapMyFitnessActivity";
    private boolean isAuth;
    private String noDataRecord;
    private String recordFailed;
    private String shareText = "";
    private String trackCalories = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private String trackStartDate = "2016-01-01 01:01:01";
    private double trackDuration = 0.0d;
    private double trackDistance = 0.0d;
    private double trackSpeed = 0.0d;
    private int trackHeartRate = 0;
    private String trackProgram = "";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_share_oauth2_login);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("shareText");
        String stringExtra2 = intent.getStringExtra("trackCalories");
        String stringExtra3 = intent.getStringExtra("trackStartDate");
        String stringExtra4 = intent.getStringExtra("trackDuration");
        String stringExtra5 = intent.getStringExtra("trackDistance");
        String stringExtra6 = intent.getStringExtra("trackSpeed");
        String stringExtra7 = intent.getStringExtra("trackHeartRate");
        String strReplace = intent.getStringExtra("trackProgram").replace("PGName_", "");
        String strValueOf = String.valueOf((Float.valueOf(stringExtra6).floatValue() * 1000.0f) / 3600.0f);
        this.recordFailed = getString(R.string.record_failed);
        this.noDataRecord = getString(R.string.no_data_record);
        this.isAuth = intent.getBooleanExtra("auth", false);
        if (stringExtra == null) {
            try {
                stringExtra = this.shareText;
            } catch (Exception e) {
                e.printStackTrace();
                setBackResult(0, this.noDataRecord);
                return;
            }
        }
        this.shareText = stringExtra;
        if (stringExtra2 == null) {
            stringExtra2 = this.trackCalories;
        }
        this.trackCalories = stringExtra2;
        if (stringExtra3 == null) {
            stringExtra3 = this.trackStartDate;
        }
        this.trackStartDate = stringExtra3;
        this.trackDuration = stringExtra4 == null ? this.trackDuration : Double.valueOf(stringExtra4).doubleValue();
        this.trackDistance = stringExtra5 == null ? this.trackDistance : Double.valueOf(stringExtra5).doubleValue() * 1000.0d;
        this.trackSpeed = strValueOf == null ? this.trackSpeed : Double.valueOf(strValueOf).doubleValue();
        this.trackHeartRate = stringExtra7 == null ? this.trackHeartRate : (int) Double.parseDouble(stringExtra7);
        if (strReplace == null) {
            strReplace = this.trackProgram;
        }
        this.trackProgram = strReplace;
        Log.e("mapmyfitness", "trackProgram" + this.trackProgram);
        final Ua uaBuild = Ua.getBuilder().setClientId(API_KEY).setClientSecret(API_SECRET).setContext(this).setProvider(new UaProviderImpl(API_KEY, API_SECRET, this, false) { // from class: com.dyaco.sole.activity.MapMyFitnessActivity.1
            @Override // com.ua.sdk.internal.UaProviderImpl
            public UrlBuilderImpl getUrlBuilder() {
                return new UrlBuilderImpl();
            }
        }).setDebug(false).build();
        String userAuthorizationUrl = uaBuild.getUserAuthorizationUrl(REDIRECT_URI);
        WebView webView = (WebView) findViewById(R.id.oauth2AuthorizationWebView);
        webView.setLayerType(1, null);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        SharedPreferences sharedPreferences = getSharedPreferences("time", 0);
        String string = sharedPreferences.getString("time", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (string != null && !string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String str = simpleDateFormat.format(new Date());
            Log.e("savetime", "now : " + str + " - before : " + string);
            try {
                Long lValueOf = Long.valueOf((((Long.valueOf(simpleDateFormat.parse(str).getTime()).longValue() - Long.valueOf(simpleDateFormat.parse(string).getTime()).longValue()) / 1000) / 60) / 60);
                if (lValueOf.longValue() >= 1) {
                    Global.isAuth = false;
                    sharedPreferences.edit().clear().commit();
                    webView.clearCache(true);
                    webView.clearFormData();
                    webView.clearHistory();
                    webView.clearMatches();
                    webView.clearSslPreferences();
                    settings.setCacheMode(2);
                    CookieSyncManager.createInstance(webView.getContext());
                    CookieManager cookieManager = CookieManager.getInstance();
                    cookieManager.setAcceptCookie(true);
                    cookieManager.removeSessionCookie();
                    cookieManager.removeAllCookie();
                }
                Log.e("savetime", "betweentime : " + lValueOf);
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
        if (userAuthorizationUrl == null) {
            setBackResult(0, this.recordFailed);
        } else {
            webView.loadUrl(userAuthorizationUrl);
            webView.setWebViewClient(new WebViewClient() { // from class: com.dyaco.sole.activity.MapMyFitnessActivity.2
                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView2, String str2) {
                    Log.d(MapMyFitnessActivity.TAG, "shouldOverrideUrlLoading~~~~" + str2);
                    if (str2.startsWith(MapMyFitnessActivity.REDIRECT_URI)) {
                        String queryParameter = Uri.parse(str2).getQueryParameter(OAuthConstants.CODE);
                        Log.d(MapMyFitnessActivity.TAG, "code~~~~" + queryParameter);
                        if (queryParameter == null) {
                            return true;
                        }
                        uaBuild.login(queryParameter, new Ua.LoginCallback() { // from class: com.dyaco.sole.activity.MapMyFitnessActivity.2.1
                            @Override // com.ua.sdk.Ua.LoginCallback
                            public void onLogin(User user, UaException uaException) throws NullPointerException {
                                if (uaException != null) {
                                    MapMyFitnessActivity.this.setBackResult(0, MapMyFitnessActivity.this.recordFailed);
                                    return;
                                }
                                if (Global.isAuth) {
                                    MapMyFitnessActivity.this.trackerWorkout(uaBuild);
                                    return;
                                }
                                String str3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
                                SharedPreferences sharedPreferences2 = MapMyFitnessActivity.this.getSharedPreferences("time", 0);
                                String string2 = sharedPreferences2.getString("time", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                if (string2 == null || string2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                    sharedPreferences2.edit().putString("time", str3).commit();
                                }
                                Global.isAuth = true;
                                MapMyFitnessActivity.this.trackerWorkout(uaBuild);
                            }
                        });
                        return true;
                    }
                    return super.shouldOverrideUrlLoading(webView2, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackerWorkout(Ua ua) throws NullPointerException {
        ActivityTypeRef activityTypeRefBuild;
        PostUtil.postTrackerData(this, 16);
        PostUtil.postTrackerData(this, 17);
        WorkoutBuilder workoutBuilderCreate = ua.getWorkoutManager().getWorkoutBuilderCreate();
        if (ProtocolHandler.protocol.deviceType == 0) {
            activityTypeRefBuild = ActivityTypeRef.getBuilder().setActivityTypeId("16").build();
        } else {
            activityTypeRefBuild = ActivityTypeRef.getBuilder().setActivityTypeId("11").build();
        }
        workoutBuilderCreate.setName(this.trackProgram);
        workoutBuilderCreate.setTotalTime(Double.valueOf(this.trackDuration), Double.valueOf(this.trackDuration));
        workoutBuilderCreate.setTotalDistance(Double.valueOf(this.trackDistance));
        workoutBuilderCreate.setSpeedAggregates(Double.valueOf(this.trackSpeed), Double.valueOf(this.trackSpeed), Double.valueOf(this.trackSpeed));
        workoutBuilderCreate.setHeartRateAggregates(Integer.valueOf(this.trackHeartRate), Integer.valueOf(this.trackHeartRate), Integer.valueOf(this.trackHeartRate));
        workoutBuilderCreate.setNotes(getString(DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode]));
        workoutBuilderCreate.setActivityType(activityTypeRefBuild);
        Date time = Calendar.getInstance().getTime();
        Log.d(TAG, "trackerWorkout  date ~~~~" + time);
        workoutBuilderCreate.setStartTime(time).setCreateTime(time).setPrivacy(Privacy.Level.PUBLIC).setTimeZone(TimeZone.getDefault());
        ua.getWorkoutManager().createWorkout(workoutBuilderCreate.build(), new CreateCallback<Workout>() { // from class: com.dyaco.sole.activity.MapMyFitnessActivity.3
            @Override // com.ua.sdk.CreateCallback
            public void onCreated(Workout workout, UaException uaException) {
                Log.d(MapMyFitnessActivity.TAG, "createWorkout error~~~~~~~~~~~~~" + uaException);
                if (uaException == null) {
                    MapMyFitnessActivity.this.setBackResult(-1, null);
                    MapMyFitnessActivity mapMyFitnessActivity = MapMyFitnessActivity.this;
                    Toast.makeText(mapMyFitnessActivity, mapMyFitnessActivity.getString(R.string.update_succeful), 0).show();
                } else {
                    MapMyFitnessActivity mapMyFitnessActivity2 = MapMyFitnessActivity.this;
                    mapMyFitnessActivity2.setBackResult(0, mapMyFitnessActivity2.recordFailed);
                }
                MapMyFitnessActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackResult(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("error", str);
        setResult(i, intent);
        finish();
    }
}
