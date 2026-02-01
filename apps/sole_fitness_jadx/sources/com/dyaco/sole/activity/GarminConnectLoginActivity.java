package com.dyaco.sole.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.ideabussdk_sole.protocol.EndWorkoutData;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.Execute;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Event;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.PostUtil;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.ErrorDialog;
import com.dyaco.sole.custom_view.QuestMainView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.stetho.BuildConfig;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.OAuthConstants;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Verb;

/* loaded from: classes.dex */
public class GarminConnectLoginActivity extends Activity {
    private static final String CALLBACK = "http://sole.fitness/";
    private static final String CALLBACK_ENCODE = "https%3A%2F%2Flocalhost%2F";
    private static final int CAMERA = 66;
    private static final String CLIENT_ID = "227YGX";
    private static final String CODE = "code";
    private static final int PHOTO = 67;
    private static final String SCOPE = "activity%20nutrition%20heartrate%20location%20nutrition%20profile%20settings%20sleep%20social%20weight";
    private static final String TAG = "GarminConnectLoginActivity";
    private static String back_url = "http://com.sole.fitness";
    private static String fitbitCode = null;
    private static String oauth_consumer_key = "75f2ce48-d973-40f1-ac97-274ef17a6d36";
    private static String oauth_consumer_secret = "5feCXso0AE1alDeN8ioFnuaRNv9Fr7RR84Z";
    private ErrorDialog errorDialog;
    public Uri imageUri;
    private boolean isAuth;
    private Dialog loadDialog;
    private String noDataRecord;
    private QuestMainView questMainView;
    private String recordFailed;
    private String trackCalories = AppEventsConstants.EVENT_PARAM_VALUE_YES;
    private String trackStartDate = "2016-01-01";
    private String trackStartTime = "01:01:01";
    private String trackDuration = AppEventsConstants.EVENT_PARAM_VALUE_YES;
    private String trackDistance = "0.1";
    private String step1_oauth_token_secret = null;
    private String member_no = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws InterruptedException, SecurityException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_authentication);
        this.questMainView = (QuestMainView) findViewById(R.id.questMainViewGarmin);
        this.errorDialog = (ErrorDialog) findViewById(R.id.errorDialogGarmin);
        EventBus.getDefault().register(this);
        requestToken();
    }

    public void showMessageView(final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.1
            @Override // java.lang.Runnable
            public void run() {
                ErrorLogSave.sendErrorList(GarminConnectLoginActivity.this.questMainView.getAccount(), GarminConnectLoginActivity.this.getApplicationContext());
                GarminConnectLoginActivity.this.questMainView.showQA(QuestMainView.GARMIN, str);
                GarminConnectLoginActivity.this.questMainView.setVisibility(0);
            }
        });
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = false, threadMode = ThreadMode.MAIN)
    public void onGarminEvent(Event.GarminEvent garminEvent) {
        if (garminEvent.getEventode() != 2) {
            return;
        }
        showErrorLog(R.string.error_0012, ErrorLogSave.ERROR_0012);
    }

    public void showErrorLog(final int i, final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.2
            @Override // java.lang.Runnable
            public void run() {
                Log.e("showErrorLog", "show");
                if (GarminConnectLoginActivity.this.errorDialog.isShown()) {
                    return;
                }
                GarminConnectLoginActivity.this.errorDialog.setVisibility(0);
                GarminConnectLoginActivity.this.errorDialog.initView(GarminConnectLoginActivity.this.getString(i), new View.OnClickListener() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GarminConnectLoginActivity.this.showMessageView(str);
                    }
                }, new View.OnClickListener() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GarminConnectLoginActivity.this.errorDialog.setVisibility(8);
                    }
                });
            }
        });
    }

    public void showCameraDialog() {
        new AlertDialog.Builder(this, R.style.myDialog).setSingleChoiceItems(new String[]{"Camera", "Album"}, -1, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("description", "Image capture by camera");
                    contentValues.put("mime_type", "image/jpeg");
                    GarminConnectLoginActivity garminConnectLoginActivity = GarminConnectLoginActivity.this;
                    garminConnectLoginActivity.imageUri = garminConnectLoginActivity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", GarminConnectLoginActivity.this.imageUri);
                    intent.putExtra("android.intent.extra.videoQuality", 1);
                    GarminConnectLoginActivity.this.startActivityForResult(intent, 66);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setType("image/*");
                    intent2.setAction("android.intent.action.PICK");
                    GarminConnectLoginActivity.this.startActivityForResult(Intent.createChooser(intent2, "Choose Image File"), 67);
                }
                dialogInterface.dismiss();
            }
        }).show();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = TAG;
        Log.d(str, "onActivityResult--------" + i);
        Log.d(str, "resultCode--------" + i2);
        if (i == 66 || i == 67) {
            final Uri data = i == 66 ? this.imageUri : null;
            if (i == 67 && intent != null) {
                Log.d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                data = intent.getData();
            }
            if (data != null) {
                Log.d(str, "uri:" + data.getPath());
                runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.4
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(GarminConnectLoginActivity.this.getContentResolver(), data);
                            File file = new File(GarminConnectLoginActivity.this.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                GarminConnectLoginActivity.this.questMainView.upLoadImg(new File(file.getPath()));
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

    private void requestToken() throws InterruptedException {
        if (Global.memberData != null) {
            this.member_no = "" + Global.memberData.getAccount_no();
        }
        final String str = null;
        final String strHmacSha1 = "+";
        String str2 = "";
        String str3 = str2;
        String str4 = null;
        final String nonce = null;
        while (strHmacSha1.contains("+")) {
            try {
                nonce = getNonce();
                str = "" + (System.currentTimeMillis() / 1000);
                str4 = String.format("oauth_consumer_key=%s&oauth_nonce=%s&oauth_signature_method=HMAC-SHA1&oauth_timestamp=%s&oauth_version=1.0", oauth_consumer_key, nonce, str);
                str2 = "POST&" + URLEncoder.encode("https://connectapi.garmin.com/oauth-service-1.0/oauth/request_token", "utf-8") + "&" + URLEncoder.encode(str4, "utf-8");
                str3 = URLEncoder.encode(oauth_consumer_secret, "utf-8") + "&";
                strHmacSha1 = hmacSha1(str2, str3);
                Log.d(TAG, "oauth_signature:" + strHmacSha1);
                if (strHmacSha1.contains("+")) {
                    Thread.sleep(1000L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String str5 = TAG;
        Log.d(str5, "request_url:https://connectapi.garmin.com/oauth-service-1.0/oauth/request_token");
        Log.d(str5, "oauth_timestamp:" + str);
        Log.d(str5, "parametersString:" + str4);
        Log.d(str5, "baseString:" + str2);
        Log.d(str5, "oauth_nonce:" + nonce);
        Log.d(str5, "secretString:" + str3);
        Log.d(str5, "oauth_signature:" + strHmacSha1);
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST, "https://connectapi.garmin.com/oauth-service-1.0/oauth/request_token");
                    oAuthRequest.addHeader("Authorization", "OAuth");
                    oAuthRequest.addHeader(OAuthConstants.NONCE, nonce);
                    oAuthRequest.addHeader(OAuthConstants.SIGNATURE, strHmacSha1);
                    oAuthRequest.addHeader(OAuthConstants.CONSUMER_KEY, GarminConnectLoginActivity.oauth_consumer_key);
                    oAuthRequest.addHeader(OAuthConstants.TIMESTAMP, str);
                    oAuthRequest.addHeader(OAuthConstants.SIGN_METHOD, "HMAC-SHA1");
                    oAuthRequest.addHeader(OAuthConstants.VERSION, BuildConfig.VERSION_NAME);
                    oAuthRequest.addBodyParameter(OAuthConstants.NONCE, nonce);
                    oAuthRequest.addBodyParameter(OAuthConstants.SIGNATURE, strHmacSha1);
                    oAuthRequest.addBodyParameter(OAuthConstants.CONSUMER_KEY, GarminConnectLoginActivity.oauth_consumer_key);
                    oAuthRequest.addBodyParameter(OAuthConstants.TIMESTAMP, str);
                    oAuthRequest.addBodyParameter(OAuthConstants.SIGN_METHOD, "HMAC-SHA1");
                    oAuthRequest.addBodyParameter(OAuthConstants.VERSION, BuildConfig.VERSION_NAME);
                    String body = oAuthRequest.send().getBody();
                    Log.d(GarminConnectLoginActivity.TAG, "Request Token response==>" + body);
                    if (body == null || !body.startsWith("oauth_token=")) {
                        Log.e(GarminConnectLoginActivity.TAG, "Request Token response==>" + body);
                        GarminConnectLoginActivity.this.setBackResult(0, "Request Token Failed!");
                        return;
                    }
                    String[] strArrSplit = body.split("&");
                    String str6 = null;
                    String str7 = null;
                    for (int i = 0; i < strArrSplit.length; i++) {
                        String[] strArrSplit2 = strArrSplit[i].split("=");
                        if (strArrSplit2.length == 2) {
                            if (i == 0) {
                                str7 = strArrSplit2[1];
                            } else if (i == 1) {
                                str6 = strArrSplit2[1];
                            }
                        }
                    }
                    GarminConnectLoginActivity.this.step1_oauth_token_secret = str6;
                    Log.e(GarminConnectLoginActivity.TAG, "step1_oauth_token==>" + str7);
                    Log.e(GarminConnectLoginActivity.TAG, "step1_oauth_token_secret==>" + str6);
                    GarminConnectLoginActivity.this.userAuth(str7);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    GarminConnectLoginActivity garminConnectLoginActivity = GarminConnectLoginActivity.this;
                    garminConnectLoginActivity.setBackResult(0, garminConnectLoginActivity.recordFailed);
                }
            }
        }).start();
    }

    private void userAuth2(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://connect.garmin.com/oauthConfirm?oauth_token=%s&oauth_callback=%s?action=step3", str, back_url))));
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) throws InterruptedException {
        super.onNewIntent(intent);
        String str = TAG;
        Log.d(str, "onNewIntent" + intent.getData());
        if (intent.getData() != null) {
            Log.d(str, "tSchema=>" + intent.getScheme());
            String string = intent.getData().toString();
            Log.d(str, "uri=>" + string);
            String strSubstring = string.substring(string.indexOf("?") + 1);
            Log.d(str, "url==>" + strSubstring);
            String str2 = null;
            String str3 = null;
            for (String str4 : strSubstring.split("&")) {
                String[] strArrSplit = str4.split("=");
                if (strArrSplit[0].equals(OAuthConstants.TOKEN)) {
                    str2 = strArrSplit[1];
                } else if (strArrSplit[0].equals(OAuthConstants.VERIFIER)) {
                    str3 = strArrSplit[1];
                }
            }
            String str5 = TAG;
            Log.e(str5, "step2_oauth_token==>" + str2);
            Log.e(str5, "step2_oauth_verifier==>" + str3);
            requestUserToken(str2, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void userAuth(String str) {
        final String str2 = String.format("https://connect.garmin.com/oauthConfirm?oauth_token=%s&oauth_callback=%s?action=step3", str, back_url);
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.6
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = (WebView) GarminConnectLoginActivity.this.findViewById(R.id.wvAuthorise);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setAllowContentAccess(true);
                webView.getSettings().setAppCacheEnabled(true);
                webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                webView.getSettings().setDomStorageEnabled(true);
                webView.getSettings().getLoadsImagesAutomatically();
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setAllowFileAccessFromFileURLs(true);
                webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
                webView.getSettings().setAllowFileAccess(true);
                webView.getSettings().setBuiltInZoomControls(true);
                webView.getSettings().setDisplayZoomControls(true);
                webView.getSettings().setDomStorageEnabled(true);
                webView.getSettings().setSupportZoom(true);
                webView.setWebViewClient(new WebViewClient() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.6.1
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView2, String str3) {
                        Log.d(GarminConnectLoginActivity.TAG, "shouldOverrideUrlLoading~~~~~~~~~~~" + str3);
                        if (str3.toLowerCase().startsWith(GarminConnectLoginActivity.back_url.toLowerCase())) {
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView2, str3);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView2, String str3) throws InterruptedException {
                        Log.d(GarminConnectLoginActivity.TAG, "onPageFinished~~~~~~~~~~~" + str3);
                        if (str3.toLowerCase().startsWith(GarminConnectLoginActivity.back_url.toLowerCase())) {
                            webView2.loadDataWithBaseURL("", "<html><body><h3>Loading....</h3></body></html>", "text/html", "UTF-8", "");
                            Log.d(GarminConnectLoginActivity.TAG, "url==>" + str3);
                            String strSubstring = str3.substring(str3.indexOf("&") + 1);
                            Log.d(GarminConnectLoginActivity.TAG, "url==>" + strSubstring);
                            String[] strArrSplit = strSubstring.split("&");
                            String str4 = null;
                            String str5 = null;
                            for (String str6 : strArrSplit) {
                                String[] strArrSplit2 = str6.split("=");
                                if (strArrSplit2[0].equals(OAuthConstants.TOKEN)) {
                                    str4 = strArrSplit2[1];
                                } else if (strArrSplit2[0].equals(OAuthConstants.VERIFIER)) {
                                    str5 = strArrSplit2[1];
                                }
                            }
                            Log.e(GarminConnectLoginActivity.TAG, "step2_oauth_token==>" + str4);
                            Log.e(GarminConnectLoginActivity.TAG, "step2_oauth_verifier==>" + str5);
                            GarminConnectLoginActivity.this.requestUserToken(str4, str5);
                        }
                    }
                });
                if (str2 == null) {
                    GarminConnectLoginActivity garminConnectLoginActivity = GarminConnectLoginActivity.this;
                    garminConnectLoginActivity.setBackResult(0, garminConnectLoginActivity.recordFailed);
                } else {
                    webView.loadUrl(str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestUserToken(final String str, final String str2) throws InterruptedException {
        StringBuilder sb;
        Log.d(TAG, "requestUserToken");
        String str3 = null;
        String strHmacSha1 = "+";
        String str4 = "";
        String string = str4;
        String str5 = null;
        String nonce = null;
        while (strHmacSha1.contains("+")) {
            try {
                nonce = getNonce();
                str3 = "" + (System.currentTimeMillis() / 1000);
                str5 = String.format("oauth_consumer_key=%s&oauth_nonce=%s&oauth_signature_method=HMAC-SHA1&oauth_timestamp=%s&oauth_token=%s&oauth_verifier=%s&oauth_version=1.0", oauth_consumer_key, nonce, str3, str, str2);
                str4 = "POST&" + URLEncoder.encode("https://connectapi.garmin.com/oauth-service-1.0/oauth/access_token", "utf-8") + "&" + URLEncoder.encode(str5, "utf-8");
                sb = new StringBuilder();
                sb.append(URLEncoder.encode(oauth_consumer_secret, "utf-8"));
                sb.append("&");
            } catch (Exception e) {
                e = e;
            }
            try {
                sb.append(URLEncoder.encode(this.step1_oauth_token_secret, "utf-8"));
                string = sb.toString();
                strHmacSha1 = hmacSha1(str4, string);
                Log.d(TAG, "oauth_signature:" + strHmacSha1);
                if (strHmacSha1.contains("+")) {
                    Thread.sleep(1000L);
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                final String str6 = str3;
                final String str7 = nonce;
                final String str8 = strHmacSha1;
                new Thread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST, "https://connectapi.garmin.com/oauth-service-1.0/oauth/access_token");
                            oAuthRequest.addHeader("Authorization", "OAuth");
                            oAuthRequest.addHeader(OAuthConstants.NONCE, str7);
                            oAuthRequest.addHeader(OAuthConstants.SIGNATURE, str8);
                            oAuthRequest.addHeader(OAuthConstants.CONSUMER_KEY, GarminConnectLoginActivity.oauth_consumer_key);
                            oAuthRequest.addHeader(OAuthConstants.TIMESTAMP, str6);
                            oAuthRequest.addHeader(OAuthConstants.SIGN_METHOD, "HMAC-SHA1");
                            oAuthRequest.addHeader(OAuthConstants.VERSION, BuildConfig.VERSION_NAME);
                            oAuthRequest.addHeader(OAuthConstants.TOKEN, str);
                            oAuthRequest.addHeader(OAuthConstants.VERIFIER, str2);
                            oAuthRequest.addBodyParameter(OAuthConstants.NONCE, str7);
                            oAuthRequest.addBodyParameter(OAuthConstants.SIGNATURE, str8);
                            oAuthRequest.addBodyParameter(OAuthConstants.CONSUMER_KEY, GarminConnectLoginActivity.oauth_consumer_key);
                            oAuthRequest.addBodyParameter(OAuthConstants.TIMESTAMP, str6);
                            oAuthRequest.addBodyParameter(OAuthConstants.SIGN_METHOD, "HMAC-SHA1");
                            oAuthRequest.addBodyParameter(OAuthConstants.VERSION, BuildConfig.VERSION_NAME);
                            oAuthRequest.addBodyParameter(OAuthConstants.TOKEN, str);
                            oAuthRequest.addBodyParameter(OAuthConstants.VERIFIER, str2);
                            String body = oAuthRequest.send().getBody();
                            Log.d(GarminConnectLoginActivity.TAG, "Request Token response==>" + body);
                            if (body == null || !body.startsWith("oauth_token=")) {
                                Log.e(GarminConnectLoginActivity.TAG, "Request User Token response==>" + body);
                                GarminConnectLoginActivity.this.setBackResult(0, "Request User Token Failed!");
                                return;
                            }
                            String[] strArrSplit = body.split("&");
                            String str9 = null;
                            String str10 = null;
                            for (int i = 0; i < strArrSplit.length; i++) {
                                String[] strArrSplit2 = strArrSplit[i].split("=");
                                if (strArrSplit2.length == 2) {
                                    if (i == 0) {
                                        str9 = strArrSplit2[1];
                                    } else if (i == 1) {
                                        str10 = strArrSplit2[1];
                                    }
                                }
                            }
                            Log.e(GarminConnectLoginActivity.TAG, "step3_oauth_user_token==>" + str9);
                            Log.e(GarminConnectLoginActivity.TAG, "step3_oauth_user_token_secret==>" + str10);
                            if (GarminConnectLoginActivity.this.member_no != null) {
                                String str11 = "GARMIN_USER_ACCESSTOKEN_NAME_" + GarminConnectLoginActivity.this.member_no;
                                String str12 = "GARMIN_USER_ACCESSTOKEN_SECRET_NAME_" + GarminConnectLoginActivity.this.member_no;
                                Log.e(GarminConnectLoginActivity.TAG, "key_token==>" + str11);
                                Log.e(GarminConnectLoginActivity.TAG, "key_token_secret==>" + str12);
                            }
                            GarminConnectLoginActivity.this.updateGarminToken(str9);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            GarminConnectLoginActivity garminConnectLoginActivity = GarminConnectLoginActivity.this;
                            garminConnectLoginActivity.setBackResult(0, garminConnectLoginActivity.recordFailed);
                        }
                    }
                }).start();
            }
        }
        String str9 = TAG;
        Log.d(str9, "request_url:https://connectapi.garmin.com/oauth-service-1.0/oauth/access_token");
        Log.d(str9, "oauth_timestamp:" + str3);
        Log.d(str9, "parametersString:" + str5);
        Log.d(str9, "baseString:" + str4);
        Log.d(str9, "oauth_nonce:" + nonce);
        Log.d(str9, "secretString:" + string);
        Log.d(str9, "oauth_signature:" + strHmacSha1);
        final String str62 = str3;
        final String str72 = nonce;
        final String str82 = strHmacSha1;
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST, "https://connectapi.garmin.com/oauth-service-1.0/oauth/access_token");
                    oAuthRequest.addHeader("Authorization", "OAuth");
                    oAuthRequest.addHeader(OAuthConstants.NONCE, str72);
                    oAuthRequest.addHeader(OAuthConstants.SIGNATURE, str82);
                    oAuthRequest.addHeader(OAuthConstants.CONSUMER_KEY, GarminConnectLoginActivity.oauth_consumer_key);
                    oAuthRequest.addHeader(OAuthConstants.TIMESTAMP, str62);
                    oAuthRequest.addHeader(OAuthConstants.SIGN_METHOD, "HMAC-SHA1");
                    oAuthRequest.addHeader(OAuthConstants.VERSION, BuildConfig.VERSION_NAME);
                    oAuthRequest.addHeader(OAuthConstants.TOKEN, str);
                    oAuthRequest.addHeader(OAuthConstants.VERIFIER, str2);
                    oAuthRequest.addBodyParameter(OAuthConstants.NONCE, str72);
                    oAuthRequest.addBodyParameter(OAuthConstants.SIGNATURE, str82);
                    oAuthRequest.addBodyParameter(OAuthConstants.CONSUMER_KEY, GarminConnectLoginActivity.oauth_consumer_key);
                    oAuthRequest.addBodyParameter(OAuthConstants.TIMESTAMP, str62);
                    oAuthRequest.addBodyParameter(OAuthConstants.SIGN_METHOD, "HMAC-SHA1");
                    oAuthRequest.addBodyParameter(OAuthConstants.VERSION, BuildConfig.VERSION_NAME);
                    oAuthRequest.addBodyParameter(OAuthConstants.TOKEN, str);
                    oAuthRequest.addBodyParameter(OAuthConstants.VERIFIER, str2);
                    String body = oAuthRequest.send().getBody();
                    Log.d(GarminConnectLoginActivity.TAG, "Request Token response==>" + body);
                    if (body == null || !body.startsWith("oauth_token=")) {
                        Log.e(GarminConnectLoginActivity.TAG, "Request User Token response==>" + body);
                        GarminConnectLoginActivity.this.setBackResult(0, "Request User Token Failed!");
                        return;
                    }
                    String[] strArrSplit = body.split("&");
                    String str92 = null;
                    String str10 = null;
                    for (int i = 0; i < strArrSplit.length; i++) {
                        String[] strArrSplit2 = strArrSplit[i].split("=");
                        if (strArrSplit2.length == 2) {
                            if (i == 0) {
                                str92 = strArrSplit2[1];
                            } else if (i == 1) {
                                str10 = strArrSplit2[1];
                            }
                        }
                    }
                    Log.e(GarminConnectLoginActivity.TAG, "step3_oauth_user_token==>" + str92);
                    Log.e(GarminConnectLoginActivity.TAG, "step3_oauth_user_token_secret==>" + str10);
                    if (GarminConnectLoginActivity.this.member_no != null) {
                        String str11 = "GARMIN_USER_ACCESSTOKEN_NAME_" + GarminConnectLoginActivity.this.member_no;
                        String str12 = "GARMIN_USER_ACCESSTOKEN_SECRET_NAME_" + GarminConnectLoginActivity.this.member_no;
                        Log.e(GarminConnectLoginActivity.TAG, "key_token==>" + str11);
                        Log.e(GarminConnectLoginActivity.TAG, "key_token_secret==>" + str12);
                    }
                    GarminConnectLoginActivity.this.updateGarminToken(str92);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    GarminConnectLoginActivity garminConnectLoginActivity = GarminConnectLoginActivity.this;
                    garminConnectLoginActivity.setBackResult(0, garminConnectLoginActivity.recordFailed);
                }
            }
        }).start();
    }

    public static void RequestUserActivity(final String str, String str2, final String str3, final String str4) throws InterruptedException {
        final String str5;
        final String str6;
        String str7;
        String str8;
        String str9;
        String str10 = "&";
        String str11 = TAG;
        Log.d(str11, "RequestUserActivity");
        Log.d(str11, "uploadday==>" + str3 + "==" + str4);
        String string = null;
        String str12 = "";
        String strHmacSha1 = "+";
        String nonce = null;
        String str13 = null;
        String str14 = "";
        String str15 = str14;
        while (strHmacSha1.contains("+")) {
            try {
                nonce = getNonce();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                str8 = str14;
                str9 = str15;
                try {
                    sb.append(System.currentTimeMillis() / 1000);
                    string = sb.toString();
                    str13 = String.format("oauth_consumer_key=%s&oauth_nonce=%s&oauth_signature_method=HMAC-SHA1&oauth_timestamp=%s&oauth_token=%s&oauth_version=1.0&uploadEndTimeInSeconds=%s&uploadStartTimeInSeconds=%s", oauth_consumer_key, nonce, string, str, str4, str3);
                    str14 = "GET&" + URLEncoder.encode("https://gcsapi.garmin.com/wellness-api/rest/activities", "utf-8") + str10 + URLEncoder.encode(str13, "utf-8");
                    try {
                        str15 = URLEncoder.encode(oauth_consumer_secret, "utf-8") + str10 + URLEncoder.encode(str2, "utf-8");
                    } catch (Exception e) {
                        e = e;
                        str15 = str9;
                        Log.d(TAG, e.getMessage());
                        e.printStackTrace();
                        str7 = string;
                        str6 = nonce;
                        str5 = strHmacSha1;
                        final String str16 = String.format("%s?%s", "https://gcsapi.garmin.com/wellness-api/rest/activities", str12);
                        String str17 = TAG;
                        Log.d(str17, "request_url:https://gcsapi.garmin.com/wellness-api/rest/activities");
                        Log.d(str17, "oauth_timestamp:" + str7);
                        Log.d(str17, "parametersString:" + str13);
                        Log.d(str17, "baseString:" + str14);
                        Log.d(str17, "oauth_nonce:" + str6);
                        Log.d(str17, "secretString:" + str15);
                        Log.d(str17, "oauth_signature:" + str5);
                        Log.d(str17, "link_url:" + str16);
                        Log.d(str17, "oauth_useraccess_token:" + str);
                        final String str18 = str7;
                        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.8
                            @Override // java.lang.Runnable
                            public void run() throws JSONException {
                                String str19 = "============================================================================";
                                String str20 = "activityType";
                                String str21 = "jsonObject==>";
                                try {
                                    OAuthRequest oAuthRequest = new OAuthRequest(Verb.GET, str16);
                                    oAuthRequest.addHeader("Authorization", "OAuth");
                                    oAuthRequest.addHeader(OAuthConstants.NONCE, str6);
                                    oAuthRequest.addHeader(OAuthConstants.SIGNATURE, str5);
                                    oAuthRequest.addHeader(OAuthConstants.TOKEN, str);
                                    oAuthRequest.addHeader(OAuthConstants.CONSUMER_KEY, GarminConnectLoginActivity.oauth_consumer_key);
                                    oAuthRequest.addHeader(OAuthConstants.TIMESTAMP, str18);
                                    oAuthRequest.addHeader(OAuthConstants.SIGN_METHOD, "HMAC-SHA1");
                                    oAuthRequest.addHeader(OAuthConstants.VERSION, BuildConfig.VERSION_NAME);
                                    String body = oAuthRequest.send().getBody();
                                    Log.d(GarminConnectLoginActivity.TAG, "Activity response==>" + str3);
                                    Log.d(GarminConnectLoginActivity.TAG, "Activity response==>" + str4);
                                    Log.d(GarminConnectLoginActivity.TAG, "Activity response==>" + body);
                                    int i = 0;
                                    if (body == null || body.contains("\"errorMessage\":")) {
                                        Log.e(GarminConnectLoginActivity.TAG, body);
                                        if (body == null || !body.contains("Unknown UserAccessToken")) {
                                            return;
                                        }
                                        EventBus.getDefault().post(new Event.GarminEvent(0));
                                        return;
                                    }
                                    JSONArray jSONArray = new JSONArray(body);
                                    int i2 = 0;
                                    while (i2 < jSONArray.length()) {
                                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                        Log.d(GarminConnectLoginActivity.TAG, str21 + jSONObject);
                                        Log.d(GarminConnectLoginActivity.TAG, str21 + jSONObject.getString(str20));
                                        long j = jSONObject.getLong("durationInSeconds");
                                        long j2 = jSONObject.getLong("startTimeInSeconds");
                                        long j3 = jSONObject.getLong("startTimeOffsetInSeconds");
                                        String string2 = jSONObject.getString(str20);
                                        int iOptInt = jSONObject.optInt("averageHeartRateInBeatsPerMinute", i);
                                        String str22 = str20;
                                        String str23 = str21;
                                        int i3 = i2;
                                        double dOptDouble = jSONObject.optDouble("activeKilocalories", 0.0d);
                                        JSONArray jSONArray2 = jSONArray;
                                        double dOptDouble2 = jSONObject.optDouble("distanceInMeters", 0.0d) / 1000.0d;
                                        double dOptDouble3 = jSONObject.optDouble("averageSpeedInMetersPerSecond", 0.0d) * 3.6d;
                                        double dOptDouble4 = jSONObject.optDouble("averagePaceInMinutesPerKilometer", 0.0d);
                                        long j4 = j2 - j3;
                                        Log.d(GarminConnectLoginActivity.TAG, str19);
                                        String str24 = GarminConnectLoginActivity.TAG;
                                        StringBuilder sb2 = new StringBuilder();
                                        String str25 = str19;
                                        sb2.append("deviceName==>");
                                        sb2.append(QuestMainView.GARMIN);
                                        Log.d(str24, sb2.toString());
                                        Log.d(GarminConnectLoginActivity.TAG, "activityType==>" + string2);
                                        Log.d(GarminConnectLoginActivity.TAG, "durationInSeconds==>" + j);
                                        Log.d(GarminConnectLoginActivity.TAG, "startTimeInSeconds==>" + j2);
                                        Log.d(GarminConnectLoginActivity.TAG, "realStartSecound==>" + j4);
                                        Log.d(GarminConnectLoginActivity.TAG, "startTimeOffsetInSeconds==>" + j3);
                                        Log.d(GarminConnectLoginActivity.TAG, "averageHeartRateInBeatsPerMinute==>" + iOptInt);
                                        Log.d(GarminConnectLoginActivity.TAG, "activeKilocalories==>" + dOptDouble);
                                        Log.d(GarminConnectLoginActivity.TAG, "distanceInMeters==>" + dOptDouble2);
                                        Log.d(GarminConnectLoginActivity.TAG, "averageSpeedInMetersPerSecond==>" + dOptDouble3);
                                        Log.d(GarminConnectLoginActivity.TAG, "averagePaceInMinutesPerKilometer==>" + dOptDouble4);
                                        EndWorkoutData endWorkoutData = new EndWorkoutData();
                                        endWorkoutData.setDistance((float) dOptDouble2);
                                        endWorkoutData.setCalories((float) dOptDouble);
                                        endWorkoutData.setHeartRate(iOptInt);
                                        endWorkoutData.setSpeed((float) dOptDouble3);
                                        endWorkoutData.setIncline((int) dOptDouble4);
                                        endWorkoutData.setSeconds((int) j);
                                        DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
                                        Calendar calendar = Calendar.getInstance();
                                        calendar.setTimeInMillis(j4 * 1000);
                                        List<DCTrainingData> list = dCTrainingDataDao.queryBuilder().where(DCTrainingDataDao.Properties.Training_datetime.eq(calendar.getTime()), new WhereCondition[0]).list();
                                        Log.d(GarminConnectLoginActivity.TAG, "count==>" + list.size());
                                        if (list.size() != 0) {
                                            Log.d(GarminConnectLoginActivity.TAG, "Double");
                                        } else {
                                            dCTrainingDataDao.insert(GarminConnectLoginActivity.saveAsDCTrainingData(endWorkoutData, calendar, string2));
                                            Log.d(GarminConnectLoginActivity.TAG, "Insert");
                                        }
                                        Log.d(GarminConnectLoginActivity.TAG, str25);
                                        i2 = i3 + 1;
                                        str19 = str25;
                                        str20 = str22;
                                        str21 = str23;
                                        jSONArray = jSONArray2;
                                        i = 0;
                                    }
                                } catch (Exception e2) {
                                    Log.d(GarminConnectLoginActivity.TAG, e2.getMessage());
                                    e2.printStackTrace();
                                    EventBus.getDefault().post(new Event.GarminEvent(2));
                                }
                            }
                        }).start();
                    }
                } catch (Exception e2) {
                    e = e2;
                    str14 = str8;
                }
            } catch (Exception e3) {
                e = e3;
            }
            try {
                strHmacSha1 = hmacSha1(str14, str15);
                String str19 = str10;
                Log.d(TAG, "oauth_signature:" + strHmacSha1);
                if (strHmacSha1.contains("+")) {
                    Thread.sleep(1000L);
                }
                str10 = str19;
            } catch (Exception e4) {
                e = e4;
                Log.d(TAG, e.getMessage());
                e.printStackTrace();
                str7 = string;
                str6 = nonce;
                str5 = strHmacSha1;
                final String str162 = String.format("%s?%s", "https://gcsapi.garmin.com/wellness-api/rest/activities", str12);
                String str172 = TAG;
                Log.d(str172, "request_url:https://gcsapi.garmin.com/wellness-api/rest/activities");
                Log.d(str172, "oauth_timestamp:" + str7);
                Log.d(str172, "parametersString:" + str13);
                Log.d(str172, "baseString:" + str14);
                Log.d(str172, "oauth_nonce:" + str6);
                Log.d(str172, "secretString:" + str15);
                Log.d(str172, "oauth_signature:" + str5);
                Log.d(str172, "link_url:" + str162);
                Log.d(str172, "oauth_useraccess_token:" + str);
                final String str182 = str7;
                new Thread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.8
                    @Override // java.lang.Runnable
                    public void run() throws JSONException {
                        String str192 = "============================================================================";
                        String str20 = "activityType";
                        String str21 = "jsonObject==>";
                        try {
                            OAuthRequest oAuthRequest = new OAuthRequest(Verb.GET, str162);
                            oAuthRequest.addHeader("Authorization", "OAuth");
                            oAuthRequest.addHeader(OAuthConstants.NONCE, str6);
                            oAuthRequest.addHeader(OAuthConstants.SIGNATURE, str5);
                            oAuthRequest.addHeader(OAuthConstants.TOKEN, str);
                            oAuthRequest.addHeader(OAuthConstants.CONSUMER_KEY, GarminConnectLoginActivity.oauth_consumer_key);
                            oAuthRequest.addHeader(OAuthConstants.TIMESTAMP, str182);
                            oAuthRequest.addHeader(OAuthConstants.SIGN_METHOD, "HMAC-SHA1");
                            oAuthRequest.addHeader(OAuthConstants.VERSION, BuildConfig.VERSION_NAME);
                            String body = oAuthRequest.send().getBody();
                            Log.d(GarminConnectLoginActivity.TAG, "Activity response==>" + str3);
                            Log.d(GarminConnectLoginActivity.TAG, "Activity response==>" + str4);
                            Log.d(GarminConnectLoginActivity.TAG, "Activity response==>" + body);
                            int i = 0;
                            if (body == null || body.contains("\"errorMessage\":")) {
                                Log.e(GarminConnectLoginActivity.TAG, body);
                                if (body == null || !body.contains("Unknown UserAccessToken")) {
                                    return;
                                }
                                EventBus.getDefault().post(new Event.GarminEvent(0));
                                return;
                            }
                            JSONArray jSONArray = new JSONArray(body);
                            int i2 = 0;
                            while (i2 < jSONArray.length()) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                Log.d(GarminConnectLoginActivity.TAG, str21 + jSONObject);
                                Log.d(GarminConnectLoginActivity.TAG, str21 + jSONObject.getString(str20));
                                long j = jSONObject.getLong("durationInSeconds");
                                long j2 = jSONObject.getLong("startTimeInSeconds");
                                long j3 = jSONObject.getLong("startTimeOffsetInSeconds");
                                String string2 = jSONObject.getString(str20);
                                int iOptInt = jSONObject.optInt("averageHeartRateInBeatsPerMinute", i);
                                String str22 = str20;
                                String str23 = str21;
                                int i3 = i2;
                                double dOptDouble = jSONObject.optDouble("activeKilocalories", 0.0d);
                                JSONArray jSONArray2 = jSONArray;
                                double dOptDouble2 = jSONObject.optDouble("distanceInMeters", 0.0d) / 1000.0d;
                                double dOptDouble3 = jSONObject.optDouble("averageSpeedInMetersPerSecond", 0.0d) * 3.6d;
                                double dOptDouble4 = jSONObject.optDouble("averagePaceInMinutesPerKilometer", 0.0d);
                                long j4 = j2 - j3;
                                Log.d(GarminConnectLoginActivity.TAG, str192);
                                String str24 = GarminConnectLoginActivity.TAG;
                                StringBuilder sb2 = new StringBuilder();
                                String str25 = str192;
                                sb2.append("deviceName==>");
                                sb2.append(QuestMainView.GARMIN);
                                Log.d(str24, sb2.toString());
                                Log.d(GarminConnectLoginActivity.TAG, "activityType==>" + string2);
                                Log.d(GarminConnectLoginActivity.TAG, "durationInSeconds==>" + j);
                                Log.d(GarminConnectLoginActivity.TAG, "startTimeInSeconds==>" + j2);
                                Log.d(GarminConnectLoginActivity.TAG, "realStartSecound==>" + j4);
                                Log.d(GarminConnectLoginActivity.TAG, "startTimeOffsetInSeconds==>" + j3);
                                Log.d(GarminConnectLoginActivity.TAG, "averageHeartRateInBeatsPerMinute==>" + iOptInt);
                                Log.d(GarminConnectLoginActivity.TAG, "activeKilocalories==>" + dOptDouble);
                                Log.d(GarminConnectLoginActivity.TAG, "distanceInMeters==>" + dOptDouble2);
                                Log.d(GarminConnectLoginActivity.TAG, "averageSpeedInMetersPerSecond==>" + dOptDouble3);
                                Log.d(GarminConnectLoginActivity.TAG, "averagePaceInMinutesPerKilometer==>" + dOptDouble4);
                                EndWorkoutData endWorkoutData = new EndWorkoutData();
                                endWorkoutData.setDistance((float) dOptDouble2);
                                endWorkoutData.setCalories((float) dOptDouble);
                                endWorkoutData.setHeartRate(iOptInt);
                                endWorkoutData.setSpeed((float) dOptDouble3);
                                endWorkoutData.setIncline((int) dOptDouble4);
                                endWorkoutData.setSeconds((int) j);
                                DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTimeInMillis(j4 * 1000);
                                List<DCTrainingData> list = dCTrainingDataDao.queryBuilder().where(DCTrainingDataDao.Properties.Training_datetime.eq(calendar.getTime()), new WhereCondition[0]).list();
                                Log.d(GarminConnectLoginActivity.TAG, "count==>" + list.size());
                                if (list.size() != 0) {
                                    Log.d(GarminConnectLoginActivity.TAG, "Double");
                                } else {
                                    dCTrainingDataDao.insert(GarminConnectLoginActivity.saveAsDCTrainingData(endWorkoutData, calendar, string2));
                                    Log.d(GarminConnectLoginActivity.TAG, "Insert");
                                }
                                Log.d(GarminConnectLoginActivity.TAG, str25);
                                i2 = i3 + 1;
                                str192 = str25;
                                str20 = str22;
                                str21 = str23;
                                jSONArray = jSONArray2;
                                i = 0;
                            }
                        } catch (Exception e22) {
                            Log.d(GarminConnectLoginActivity.TAG, e22.getMessage());
                            e22.printStackTrace();
                            EventBus.getDefault().post(new Event.GarminEvent(2));
                        }
                    }
                }).start();
            }
        }
        str8 = str14;
        str9 = str15;
        str12 = String.format("uploadStartTimeInSeconds=%s&uploadEndTimeInSeconds=%s&oauth_consumer_key=%s&oauth_signature=%s&oauth_timestamp=%s&oauth_nonce=%s&oauth_signature_method=HMAC-SHA1&oauth_version=1.0&oauth_token=%s", str3, str4, oauth_consumer_key, strHmacSha1, string, nonce, URLEncoder.encode(str, "utf-8"));
        str7 = string;
        str6 = nonce;
        str5 = strHmacSha1;
        str14 = str8;
        str15 = str9;
        final String str1622 = String.format("%s?%s", "https://gcsapi.garmin.com/wellness-api/rest/activities", str12);
        String str1722 = TAG;
        Log.d(str1722, "request_url:https://gcsapi.garmin.com/wellness-api/rest/activities");
        Log.d(str1722, "oauth_timestamp:" + str7);
        Log.d(str1722, "parametersString:" + str13);
        Log.d(str1722, "baseString:" + str14);
        Log.d(str1722, "oauth_nonce:" + str6);
        Log.d(str1722, "secretString:" + str15);
        Log.d(str1722, "oauth_signature:" + str5);
        Log.d(str1722, "link_url:" + str1622);
        Log.d(str1722, "oauth_useraccess_token:" + str);
        final String str1822 = str7;
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.8
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                String str192 = "============================================================================";
                String str20 = "activityType";
                String str21 = "jsonObject==>";
                try {
                    OAuthRequest oAuthRequest = new OAuthRequest(Verb.GET, str1622);
                    oAuthRequest.addHeader("Authorization", "OAuth");
                    oAuthRequest.addHeader(OAuthConstants.NONCE, str6);
                    oAuthRequest.addHeader(OAuthConstants.SIGNATURE, str5);
                    oAuthRequest.addHeader(OAuthConstants.TOKEN, str);
                    oAuthRequest.addHeader(OAuthConstants.CONSUMER_KEY, GarminConnectLoginActivity.oauth_consumer_key);
                    oAuthRequest.addHeader(OAuthConstants.TIMESTAMP, str1822);
                    oAuthRequest.addHeader(OAuthConstants.SIGN_METHOD, "HMAC-SHA1");
                    oAuthRequest.addHeader(OAuthConstants.VERSION, BuildConfig.VERSION_NAME);
                    String body = oAuthRequest.send().getBody();
                    Log.d(GarminConnectLoginActivity.TAG, "Activity response==>" + str3);
                    Log.d(GarminConnectLoginActivity.TAG, "Activity response==>" + str4);
                    Log.d(GarminConnectLoginActivity.TAG, "Activity response==>" + body);
                    int i = 0;
                    if (body == null || body.contains("\"errorMessage\":")) {
                        Log.e(GarminConnectLoginActivity.TAG, body);
                        if (body == null || !body.contains("Unknown UserAccessToken")) {
                            return;
                        }
                        EventBus.getDefault().post(new Event.GarminEvent(0));
                        return;
                    }
                    JSONArray jSONArray = new JSONArray(body);
                    int i2 = 0;
                    while (i2 < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        Log.d(GarminConnectLoginActivity.TAG, str21 + jSONObject);
                        Log.d(GarminConnectLoginActivity.TAG, str21 + jSONObject.getString(str20));
                        long j = jSONObject.getLong("durationInSeconds");
                        long j2 = jSONObject.getLong("startTimeInSeconds");
                        long j3 = jSONObject.getLong("startTimeOffsetInSeconds");
                        String string2 = jSONObject.getString(str20);
                        int iOptInt = jSONObject.optInt("averageHeartRateInBeatsPerMinute", i);
                        String str22 = str20;
                        String str23 = str21;
                        int i3 = i2;
                        double dOptDouble = jSONObject.optDouble("activeKilocalories", 0.0d);
                        JSONArray jSONArray2 = jSONArray;
                        double dOptDouble2 = jSONObject.optDouble("distanceInMeters", 0.0d) / 1000.0d;
                        double dOptDouble3 = jSONObject.optDouble("averageSpeedInMetersPerSecond", 0.0d) * 3.6d;
                        double dOptDouble4 = jSONObject.optDouble("averagePaceInMinutesPerKilometer", 0.0d);
                        long j4 = j2 - j3;
                        Log.d(GarminConnectLoginActivity.TAG, str192);
                        String str24 = GarminConnectLoginActivity.TAG;
                        StringBuilder sb2 = new StringBuilder();
                        String str25 = str192;
                        sb2.append("deviceName==>");
                        sb2.append(QuestMainView.GARMIN);
                        Log.d(str24, sb2.toString());
                        Log.d(GarminConnectLoginActivity.TAG, "activityType==>" + string2);
                        Log.d(GarminConnectLoginActivity.TAG, "durationInSeconds==>" + j);
                        Log.d(GarminConnectLoginActivity.TAG, "startTimeInSeconds==>" + j2);
                        Log.d(GarminConnectLoginActivity.TAG, "realStartSecound==>" + j4);
                        Log.d(GarminConnectLoginActivity.TAG, "startTimeOffsetInSeconds==>" + j3);
                        Log.d(GarminConnectLoginActivity.TAG, "averageHeartRateInBeatsPerMinute==>" + iOptInt);
                        Log.d(GarminConnectLoginActivity.TAG, "activeKilocalories==>" + dOptDouble);
                        Log.d(GarminConnectLoginActivity.TAG, "distanceInMeters==>" + dOptDouble2);
                        Log.d(GarminConnectLoginActivity.TAG, "averageSpeedInMetersPerSecond==>" + dOptDouble3);
                        Log.d(GarminConnectLoginActivity.TAG, "averagePaceInMinutesPerKilometer==>" + dOptDouble4);
                        EndWorkoutData endWorkoutData = new EndWorkoutData();
                        endWorkoutData.setDistance((float) dOptDouble2);
                        endWorkoutData.setCalories((float) dOptDouble);
                        endWorkoutData.setHeartRate(iOptInt);
                        endWorkoutData.setSpeed((float) dOptDouble3);
                        endWorkoutData.setIncline((int) dOptDouble4);
                        endWorkoutData.setSeconds((int) j);
                        DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(j4 * 1000);
                        List<DCTrainingData> list = dCTrainingDataDao.queryBuilder().where(DCTrainingDataDao.Properties.Training_datetime.eq(calendar.getTime()), new WhereCondition[0]).list();
                        Log.d(GarminConnectLoginActivity.TAG, "count==>" + list.size());
                        if (list.size() != 0) {
                            Log.d(GarminConnectLoginActivity.TAG, "Double");
                        } else {
                            dCTrainingDataDao.insert(GarminConnectLoginActivity.saveAsDCTrainingData(endWorkoutData, calendar, string2));
                            Log.d(GarminConnectLoginActivity.TAG, "Insert");
                        }
                        Log.d(GarminConnectLoginActivity.TAG, str25);
                        i2 = i3 + 1;
                        str192 = str25;
                        str20 = str22;
                        str21 = str23;
                        jSONArray = jSONArray2;
                        i = 0;
                    }
                } catch (Exception e22) {
                    Log.d(GarminConnectLoginActivity.TAG, e22.getMessage());
                    e22.printStackTrace();
                    EventBus.getDefault().post(new Event.GarminEvent(2));
                }
            }
        }).start();
    }

    public static DCTrainingData saveAsDCTrainingData(EndWorkoutData endWorkoutData, Calendar calendar, String str) {
        Calendar calendar2 = Calendar.getInstance();
        int i = ((calendar2.get(15) / 1000) / 60) / 60;
        DCTrainingData dCTrainingData = new DCTrainingData();
        int accout_noFromDB = getAccout_noFromDB();
        dCTrainingData.setAccount(Global.userName);
        dCTrainingData.setAccount_no(accout_noFromDB);
        dCTrainingData.setTraining_datetime(calendar.getTime());
        dCTrainingData.setTraining_timezone_hour(i);
        dCTrainingData.setTraining_timezone_name(calendar2.getTimeZone().getID());
        dCTrainingData.setBrand_code("garmin");
        dCTrainingData.setIn_out(ExifInterface.GPS_MEASUREMENT_2D);
        dCTrainingData.setModel_code("Garmin");
        dCTrainingData.setCategory_code("9");
        dCTrainingData.setBrand_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setUnit(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setSales_version(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setProgram_name(str);
        dCTrainingData.setGoals("");
        dCTrainingData.setNotes("");
        dCTrainingData.setTotal_time(endWorkoutData.getSeconds());
        dCTrainingData.setTotal_distance(endWorkoutData.getDistance());
        dCTrainingData.setTotal_calories(endWorkoutData.getCalories());
        dCTrainingData.setAvg_hr(endWorkoutData.getHeartRate());
        dCTrainingData.setAvg_incline(endWorkoutData.getIncline());
        dCTrainingData.setAvg_speed(endWorkoutData.getSpeed());
        dCTrainingData.setDevice_os_name("Android");
        dCTrainingData.setDevice_os_version(Build.VERSION.RELEASE);
        dCTrainingData.setDevice_model(Build.BRAND);
        dCTrainingData.setDevice_sno(Build.SERIAL);
        dCTrainingData.setDevice_gps_lat((float) Global.gpsLat);
        dCTrainingData.setDevice_gps_lng((float) Global.gpsLon);
        String str2 = ProtocolHandler.protocol.connectedMacAddress;
        return dCTrainingData;
    }

    private static int getAccout_noFromDB() {
        QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
        queryBuilder.where(MemberDataDao.Properties.Account.eq(Global.userName), new WhereCondition[0]);
        List<MemberData> list = queryBuilder.list();
        if (list == null || list.size() != 1) {
            return -1;
        }
        return list.get(0).getAccount_no();
    }

    private static String getNonce() {
        String str = "";
        for (int i = 0; i < 10; i++) {
            str = str + "0123456789".charAt((int) Math.floor(Math.random() * 10));
        }
        return str;
    }

    private static String encodeBase64URLSafeString(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    private static String hmacSha1(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(str2.getBytes("UTF-8"), mac.getAlgorithm()));
            return encodeBase64URLSafeString(mac.doFinal(str.getBytes()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    private void loadWeb(final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.9
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = (WebView) GarminConnectLoginActivity.this.findViewById(R.id.wvAuthorise);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.addJavascriptInterface(GarminConnectLoginActivity.this.new MyJavaScriptInterface(), "HtmlViewer");
                webView.setWebViewClient(new WebViewClient() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.9.1
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView2, String str2) {
                        Log.d(GarminConnectLoginActivity.TAG, "shouldOverrideUrlLoading~~~~~~~~~~~" + str2);
                        if (str2.startsWith(GarminConnectLoginActivity.CALLBACK)) {
                            if (GarminConnectLoginActivity.this.isAuth) {
                                Logger.d(" isAuth  url = " + str2);
                                GarminConnectLoginActivity.this.setBackResult(-1, null);
                                return true;
                            }
                            Logger.d(" not  isAuth  url = " + str2);
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView2, str2);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView2, String str2) {
                        Log.d(GarminConnectLoginActivity.TAG, "onPageFinished~~~~~~~~~~~" + str2);
                        webView2.loadUrl("javascript:window.HtmlViewer.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                    }
                });
                String str2 = str;
                if (str2 == null) {
                    GarminConnectLoginActivity garminConnectLoginActivity = GarminConnectLoginActivity.this;
                    garminConnectLoginActivity.setBackResult(0, garminConnectLoginActivity.recordFailed);
                } else {
                    webView.loadUrl(str2);
                }
            }
        });
    }

    private void getOAuth2Code() {
        loadWeb("http://www.google.com.tw");
    }

    private void getOAuth2Token(final String str) {
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.10
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                try {
                    String strCallCloudApiOauth2Token = GarminConnectLoginActivity.this.callCloudApiOauth2Token(GarminConnectLoginActivity.this.getCode(str));
                    if (strCallCloudApiOauth2Token != null && !strCallCloudApiOauth2Token.contains("errors")) {
                        new JSONObject(strCallCloudApiOauth2Token).getString("access_token");
                    } else {
                        GarminConnectLoginActivity garminConnectLoginActivity = GarminConnectLoginActivity.this;
                        garminConnectLoginActivity.setBackResult(0, garminConnectLoginActivity.recordFailed);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    GarminConnectLoginActivity garminConnectLoginActivity2 = GarminConnectLoginActivity.this;
                    garminConnectLoginActivity2.setBackResult(0, garminConnectLoginActivity2.recordFailed);
                }
            }
        }).start();
    }

    private void getOAuth2TokenAndRecord(final String str) {
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strCallCloudApiOauth2Token = GarminConnectLoginActivity.this.callCloudApiOauth2Token(GarminConnectLoginActivity.this.getCode(str));
                    if (strCallCloudApiOauth2Token != null && !strCallCloudApiOauth2Token.contains("errors")) {
                        GarminConnectLoginActivity.this.record(new JSONObject(strCallCloudApiOauth2Token).getString("access_token"));
                    } else {
                        GarminConnectLoginActivity garminConnectLoginActivity = GarminConnectLoginActivity.this;
                        garminConnectLoginActivity.setBackResult(0, garminConnectLoginActivity.recordFailed);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    GarminConnectLoginActivity garminConnectLoginActivity2 = GarminConnectLoginActivity.this;
                    garminConnectLoginActivity2.setBackResult(0, garminConnectLoginActivity2.recordFailed);
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
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST, "https://api.fitbit.com/1/user/-/activities.json");
                    oAuthRequest.addHeader("Authorization", "Bearer " + str);
                    oAuthRequest.addBodyParameter("activityName", GarminConnectLoginActivity.this.getString(DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode]));
                    oAuthRequest.addBodyParameter("manualCalories", GarminConnectLoginActivity.this.trackCalories);
                    oAuthRequest.addBodyParameter("startTime", GarminConnectLoginActivity.this.trackStartTime);
                    oAuthRequest.addBodyParameter("durationMillis", GarminConnectLoginActivity.this.trackDuration + "000");
                    oAuthRequest.addBodyParameter("date", GarminConnectLoginActivity.this.trackStartDate);
                    oAuthRequest.addBodyParameter("distance", GarminConnectLoginActivity.this.trackDistance);
                    String body = oAuthRequest.send().getBody();
                    Log.d(GarminConnectLoginActivity.TAG, "responseStr~~~~~~~~~~~" + body);
                    if (body != null && !body.contains("errors")) {
                        GarminConnectLoginActivity.this.setBackResult(-1, null);
                    } else {
                        GarminConnectLoginActivity garminConnectLoginActivity = GarminConnectLoginActivity.this;
                        garminConnectLoginActivity.setBackResult(0, garminConnectLoginActivity.recordFailed);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    GarminConnectLoginActivity garminConnectLoginActivity2 = GarminConnectLoginActivity.this;
                    garminConnectLoginActivity2.setBackResult(0, garminConnectLoginActivity2.recordFailed);
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
            Log.d(GarminConnectLoginActivity.TAG, "MyJavaScriptInterface~~~~~~~~~~~");
        }

        @JavascriptInterface
        public void showHTML(String str) {
            if (!this.firstRun) {
                try {
                    Log.d(GarminConnectLoginActivity.TAG, "MyJavaScriptInterface~~~~~~~~~~~showHTML = " + str);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            this.firstRun = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGarminToken(String str) {
        String account = Global.getAccount(this);
        String password = Global.getPassword(this);
        if (account == null) {
            return;
        }
        showLoadDialog();
        Execute.registUpdate(account, password, str.toUpperCase(), new Callback() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.13
            @Override // okhttp3.Callback
            public void onFailure(Call call, final IOException iOException) {
                Log.e(GarminConnectLoginActivity.TAG, "updateUserData -> onFailure Exception=" + iOException.toString());
                iOException.printStackTrace();
                GarminConnectLoginActivity.this.cancelLoadDialog();
                GarminConnectLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ErrorLogSave.addErrorString(GarminConnectLoginActivity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "login_login_btn", "login_error_" + iOException);
                        GarminConnectLoginActivity.this.setBackResult(0, GarminConnectLoginActivity.this.recordFailed);
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    GarminConnectLoginActivity.this.cancelLoadDialog();
                    final String strString = response.body().string();
                    Log.d(GarminConnectLoginActivity.TAG, "updateUserData -> onResponse data=" + strString);
                    if (TextUtils.equals(new JSONObject(strString).getJSONObject("sys_response_message").getString("code"), AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                        GarminConnectLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.13.2
                            @Override // java.lang.Runnable
                            public void run() {
                                EventBus.getDefault().post(new Event.GarminEvent(1));
                                GarminConnectLoginActivity.this.setBackResult(-1, null);
                            }
                        });
                    } else {
                        GarminConnectLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.13.3
                            @Override // java.lang.Runnable
                            public void run() {
                                ErrorLogSave.addErrorString(GarminConnectLoginActivity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "login_login_btn", "login_error_" + strString);
                                GarminConnectLoginActivity.this.setBackResult(0, GarminConnectLoginActivity.this.recordFailed);
                            }
                        });
                    }
                } catch (Exception e) {
                    Log.e(GarminConnectLoginActivity.TAG, "updateUserData -> onResponse Exception" + e);
                    GarminConnectLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.13.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ErrorLogSave.addErrorString(GarminConnectLoginActivity.this.getApplicationContext(), ErrorLogSave.EXECUTE, "login_login_btn", "login_error_" + e);
                            GarminConnectLoginActivity.this.setBackResult(0, GarminConnectLoginActivity.this.recordFailed);
                        }
                    });
                }
            }
        });
    }

    public void showLoadDialog() {
        cancelLoadDialog();
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.14
            @Override // java.lang.Runnable
            public void run() {
                Log.e("TAG", "showLoadDialog");
                AlertDialog.Builder builder = new AlertDialog.Builder(GarminConnectLoginActivity.this);
                builder.setCancelable(false);
                builder.setView(new ProgressBar(GarminConnectLoginActivity.this));
                GarminConnectLoginActivity.this.loadDialog = builder.create();
                if (GarminConnectLoginActivity.this.loadDialog.getWindow() != null) {
                    GarminConnectLoginActivity.this.loadDialog.getWindow().setBackgroundDrawableResource(R.drawable.load);
                }
                GarminConnectLoginActivity.this.loadDialog.show();
            }
        });
    }

    public void cancelLoadDialog() {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.GarminConnectLoginActivity.15
            @Override // java.lang.Runnable
            public void run() {
                if (GarminConnectLoginActivity.this.loadDialog != null) {
                    GarminConnectLoginActivity.this.loadDialog.dismiss();
                    Log.d(GarminConnectLoginActivity.TAG, "cancelLoadDialog");
                }
                GarminConnectLoginActivity.this.loadDialog = null;
            }
        });
    }

    public boolean isLoadDialogShowing() {
        Dialog dialog = this.loadDialog;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }
}
