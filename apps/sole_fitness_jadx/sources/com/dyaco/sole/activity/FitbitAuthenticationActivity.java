package com.dyaco.sole.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.PostUtil;
import com.dyaco.sole.custom.ProtocolHandler;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Verb;

/* loaded from: classes.dex */
public class FitbitAuthenticationActivity extends Activity {
    private static final String CALLBACK = "https://localhost/";
    private static final String CALLBACK_ENCODE = "https%3A%2F%2Flocalhost%2F";
    private static final String CLIENT_ID = "227YGX";
    private static final String CODE = "code";
    private static final String SCOPE = "activity%20nutrition%20heartrate%20location%20nutrition%20profile%20settings%20sleep%20social%20weight";
    private static final String TAG = "FitbitAuthenticationActivity";
    private static String fitbitCode;
    private boolean isAuth;
    private String noDataRecord;
    private String recordFailed;
    private String trackCalories = AppEventsConstants.EVENT_PARAM_VALUE_YES;
    private String trackStartDate = "2016-01-01";
    private String trackStartTime = "01:01:01";
    private String trackDuration = AppEventsConstants.EVENT_PARAM_VALUE_YES;
    private String trackDistance = "0.1";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_authentication);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("trackCalories");
        String stringExtra2 = intent.getStringExtra("trackStartDate");
        String stringExtra3 = intent.getStringExtra("trackDuration");
        String stringExtra4 = intent.getStringExtra("trackDistance");
        this.recordFailed = getString(R.string.record_failed);
        this.noDataRecord = getString(R.string.no_data_record);
        this.isAuth = false;
        if (stringExtra2 != null) {
            String[] strArrSplit = stringExtra2.split(StringUtils.SPACE);
            this.trackStartDate = strArrSplit[0];
            this.trackStartTime = strArrSplit[1];
        }
        if (stringExtra != null && stringExtra.contains(".")) {
            stringExtra = stringExtra.substring(0, stringExtra.indexOf("."));
        }
        if (stringExtra == null) {
            stringExtra = this.trackCalories;
        }
        this.trackCalories = stringExtra;
        if (stringExtra3 == null) {
            stringExtra3 = this.trackDuration;
        }
        this.trackDuration = stringExtra3;
        if (stringExtra4 == null || stringExtra4.equals(IdManager.DEFAULT_VERSION_NAME)) {
            stringExtra4 = this.trackDistance;
        }
        this.trackDistance = stringExtra4;
        getOAuth2Code();
    }

    private void getOAuth2Code() {
        loadWeb("https://www.fitbit.com/oauth2/authorize?scope=activity%20nutrition%20heartrate%20location%20nutrition%20profile%20settings%20sleep%20social%20weight&redirect_uri=https%3A%2F%2Flocalhost%2F&client_id=227YGX&response_type=code&expires_in=31536000");
    }

    private void loadWeb(final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.FitbitAuthenticationActivity.1
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = (WebView) FitbitAuthenticationActivity.this.findViewById(R.id.wvAuthorise);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.addJavascriptInterface(FitbitAuthenticationActivity.this.new MyJavaScriptInterface(), "HtmlViewer");
                WebSettings settings = webView.getSettings();
                SharedPreferences sharedPreferences = FitbitAuthenticationActivity.this.getSharedPreferences("time", 0);
                String string = sharedPreferences.getString("time", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                if (string != null && !string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String str2 = simpleDateFormat.format(new Date());
                    Log.e("savetime", "now : " + str2 + " - before : " + string);
                    try {
                        Long lValueOf = Long.valueOf((((Long.valueOf(simpleDateFormat.parse(str2).getTime()).longValue() - Long.valueOf(simpleDateFormat.parse(string).getTime()).longValue()) / 1000) / 60) / 60);
                        if (lValueOf.longValue() >= 1) {
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
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                webView.setWebViewClient(new WebViewClient() { // from class: com.dyaco.sole.activity.FitbitAuthenticationActivity.1.1
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView2, String str3) {
                        Log.d(FitbitAuthenticationActivity.TAG, "shouldOverrideUrlLoading~~~~~~~~~~~" + str3);
                        if (str3.startsWith(FitbitAuthenticationActivity.CALLBACK)) {
                            if (FitbitAuthenticationActivity.this.isAuth) {
                                Logger.d(" isAuth  url = " + str3);
                                String unused = FitbitAuthenticationActivity.fitbitCode = FitbitAuthenticationActivity.this.getCode(str3);
                                FitbitAuthenticationActivity.this.setBackResult(-1, null);
                                return true;
                            }
                            Logger.d(" not  isAuth  url = " + str3);
                            FitbitAuthenticationActivity.this.getOAuth2TokenAndRecord(str3);
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView2, str3);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView2, String str3) {
                        Log.d(FitbitAuthenticationActivity.TAG, "onPageFinished~~~~~~~~~~~" + str3);
                        webView2.loadUrl("javascript:window.HtmlViewer.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                    }
                });
                String str3 = str;
                if (str3 == null) {
                    FitbitAuthenticationActivity fitbitAuthenticationActivity = FitbitAuthenticationActivity.this;
                    fitbitAuthenticationActivity.setBackResult(0, fitbitAuthenticationActivity.recordFailed);
                } else {
                    webView.loadUrl(str3);
                }
            }
        });
    }

    private void getOAuth2Token(final String str) {
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.FitbitAuthenticationActivity.2
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                try {
                    String strCallCloudApiOauth2Token = FitbitAuthenticationActivity.this.callCloudApiOauth2Token(FitbitAuthenticationActivity.this.getCode(str));
                    if (strCallCloudApiOauth2Token != null && !strCallCloudApiOauth2Token.contains("errors")) {
                        new JSONObject(strCallCloudApiOauth2Token).getString("access_token");
                    } else {
                        FitbitAuthenticationActivity fitbitAuthenticationActivity = FitbitAuthenticationActivity.this;
                        fitbitAuthenticationActivity.setBackResult(0, fitbitAuthenticationActivity.recordFailed);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FitbitAuthenticationActivity fitbitAuthenticationActivity2 = FitbitAuthenticationActivity.this;
                    fitbitAuthenticationActivity2.setBackResult(0, fitbitAuthenticationActivity2.recordFailed);
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOAuth2TokenAndRecord(final String str) {
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.FitbitAuthenticationActivity.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strCallCloudApiOauth2Token = FitbitAuthenticationActivity.this.callCloudApiOauth2Token(FitbitAuthenticationActivity.this.getCode(str));
                    if (strCallCloudApiOauth2Token != null && !strCallCloudApiOauth2Token.contains("errors")) {
                        FitbitAuthenticationActivity.this.record(new JSONObject(strCallCloudApiOauth2Token).getString("access_token"));
                    } else {
                        FitbitAuthenticationActivity fitbitAuthenticationActivity = FitbitAuthenticationActivity.this;
                        fitbitAuthenticationActivity.setBackResult(0, fitbitAuthenticationActivity.recordFailed);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FitbitAuthenticationActivity fitbitAuthenticationActivity2 = FitbitAuthenticationActivity.this;
                    fitbitAuthenticationActivity2.setBackResult(0, fitbitAuthenticationActivity2.recordFailed);
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String callCloudApiOauth2Token(String str) {
        OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST, "https://api.fitbit.com/oauth2/token");
        oAuthRequest.addHeader("Authorization", "Basic MjI3WUdYOmFjMTllODM4OGQxYjZkYjBjZWYwMWEyOGEwNzlkNmZl");
        oAuthRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");
        oAuthRequest.addBodyParameter("client_id", CLIENT_ID);
        oAuthRequest.addBodyParameter("grant_type", "authorization_code");
        oAuthRequest.addBodyParameter("redirect_uri", CALLBACK);
        oAuthRequest.addBodyParameter("code", str);
        String body = oAuthRequest.send().getBody();
        Log.d(TAG, "getOAuth2Token~~~~~~~~~~~ responseStr = " + body);
        Logger.d("getOAuth2Token  responseStr = " + body);
        return body;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCode(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("code");
        Logger.d("getOAuth2Token     code = " + queryParameter);
        return queryParameter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void record(final String str) {
        PostUtil.postTrackerData(this, 14);
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.FitbitAuthenticationActivity.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST, "https://api.fitbit.com/1/user/-/activities.json");
                    oAuthRequest.addHeader("Authorization", "Bearer " + str);
                    oAuthRequest.addBodyParameter("activityName", FitbitAuthenticationActivity.this.getString(DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode]));
                    oAuthRequest.addBodyParameter("manualCalories", FitbitAuthenticationActivity.this.trackCalories);
                    oAuthRequest.addBodyParameter("startTime", FitbitAuthenticationActivity.this.trackStartTime);
                    oAuthRequest.addBodyParameter("durationMillis", FitbitAuthenticationActivity.this.trackDuration + "000");
                    oAuthRequest.addBodyParameter("date", FitbitAuthenticationActivity.this.trackStartDate);
                    oAuthRequest.addBodyParameter("distance", FitbitAuthenticationActivity.this.trackDistance);
                    String body = oAuthRequest.send().getBody();
                    Log.d(FitbitAuthenticationActivity.TAG, "responseStr~~~~~~~~~~~" + body);
                    if (body != null && !body.contains("errors")) {
                        String str2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
                        SharedPreferences sharedPreferences = FitbitAuthenticationActivity.this.getSharedPreferences("time", 0);
                        sharedPreferences.getString("time", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        sharedPreferences.edit().putString("time", str2).commit();
                        FitbitAuthenticationActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.FitbitAuthenticationActivity.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(FitbitAuthenticationActivity.this, FitbitAuthenticationActivity.this.getString(R.string.update_succeful), 0).show();
                                FitbitAuthenticationActivity.this.setBackResult(-1, null);
                            }
                        });
                    } else {
                        FitbitAuthenticationActivity fitbitAuthenticationActivity = FitbitAuthenticationActivity.this;
                        fitbitAuthenticationActivity.setBackResult(0, fitbitAuthenticationActivity.recordFailed);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FitbitAuthenticationActivity fitbitAuthenticationActivity2 = FitbitAuthenticationActivity.this;
                    fitbitAuthenticationActivity2.setBackResult(0, fitbitAuthenticationActivity2.recordFailed);
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackResult(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("error", str);
        setResult(i, intent);
        finish();
    }

    private class MyJavaScriptInterface {
        boolean firstRun = true;

        public MyJavaScriptInterface() {
            Log.d(FitbitAuthenticationActivity.TAG, "MyJavaScriptInterface~~~~~~~~~~~");
        }

        @JavascriptInterface
        public void showHTML(String str) {
            if (!this.firstRun) {
                try {
                    Log.d(FitbitAuthenticationActivity.TAG, "MyJavaScriptInterface~~~~~~~~~~~showHTML = " + str);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            this.firstRun = false;
        }
    }
}
