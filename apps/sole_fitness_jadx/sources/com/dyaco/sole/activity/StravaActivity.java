package com.dyaco.sole.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.dyaco.sole.MyApp;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.facebook.appevents.AppEventsConstants;
import com.soletreadmills.sole.R;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONObject;
import org.scribe.model.OAuthConstants;

/* loaded from: classes.dex */
public class StravaActivity extends Activity {
    private String member_no;
    private String noDataRecord;
    private String recordFailed;
    private final String TAG = "StravaActivity";
    final String client_id = "22436";
    final String redirect_uri = "http://com.sole.fitness";
    final String client_secret = "9a8aa616f75aded938f5d924cdc8c6d502766cb8";
    private String model = "";
    private String category = "";
    private String startDate = "";
    private String duration = "";
    private String distance = "";
    private boolean auth = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_authentication);
        this.recordFailed = getString(R.string.record_failed);
        this.noDataRecord = getString(R.string.no_data_record);
        if (Global.memberData != null) {
            this.member_no = "" + Global.memberData.getAccount_no();
        }
        this.model = "";
        this.category = "";
        this.startDate = "";
        this.duration = "";
        this.distance = "";
        Intent intent = getIntent();
        this.model = intent.getStringExtra("trackModel");
        this.category = intent.getStringExtra("trackCategory");
        this.startDate = intent.getStringExtra("trackStartDate");
        this.duration = intent.getStringExtra("trackDuration");
        this.distance = intent.getStringExtra("trackDistance");
        SharedPreferences sharedPreferences = getSharedPreferences("strava", 0);
        String string = sharedPreferences.getString("strava", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (string == null || string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            this.auth = false;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String str = simpleDateFormat.format(new Date());
            Log.e("savetime", "now : " + str + " - before : " + string);
            try {
                Long lValueOf = Long.valueOf((((Long.valueOf(simpleDateFormat.parse(str).getTime()).longValue() - Long.valueOf(simpleDateFormat.parse(string).getTime()).longValue()) / 1000) / 60) / 60);
                if (lValueOf.longValue() >= 1) {
                    sharedPreferences.edit().clear().commit();
                    this.auth = false;
                } else {
                    this.auth = true;
                }
                Log.e("savetime", "betweentime : " + lValueOf);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Log.e("stravaGet", "auth : " + this.auth);
        if (this.auth) {
            try {
                createStravaActivity();
            } catch (Exception unused) {
            }
        } else {
            loadWeb("https://www.strava.com/oauth/authorize?client_id=22436&response_type=code&redirect_uri=http://com.sole.fitness&scope=activity:write&state=mystate&approval_prompt=force");
        }
    }

    private void loadWeb(final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.StravaActivity.1
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = (WebView) StravaActivity.this.findViewById(R.id.wvAuthorise);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient() { // from class: com.dyaco.sole.activity.StravaActivity.1.1
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView2, String str2) {
                        Log.d(StravaActivity.this.TAG, "shouldOverrideUrlLoading url=" + str2);
                        if (str2.toLowerCase().startsWith("http://com.sole.fitness".toLowerCase())) {
                            webView2.loadDataWithBaseURL("", "<html><body><h3>Loading....</h3></body></html>", "text/html", "UTF-8", "");
                            for (String str3 : str2.substring(str2.indexOf("?") + 1).split("&")) {
                                String[] strArrSplit = str3.split("=");
                                if (strArrSplit[0].equals(OAuthConstants.CODE)) {
                                    StravaActivity.this.stravaTokenExchange(strArrSplit[1]);
                                } else if (strArrSplit[0].equals("error")) {
                                    Toast.makeText(StravaActivity.this, StravaActivity.this.recordFailed, 0).show();
                                    StravaActivity.this.setBackResult(0, StravaActivity.this.recordFailed);
                                }
                            }
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView2, str2);
                    }

                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                        Log.d(StravaActivity.this.TAG, "shouldOverrideUrlLoading request.getUrl=" + webResourceRequest.getUrl());
                        if (webResourceRequest.getRequestHeaders() != null) {
                            Log.d(StravaActivity.this.TAG, "shouldOverrideUrlLoading request.getRequestHeaders=" + webResourceRequest.getRequestHeaders().toString());
                        }
                        return super.shouldOverrideUrlLoading(webView2, webResourceRequest);
                    }

                    @Override // android.webkit.WebViewClient
                    public WebResourceResponse shouldInterceptRequest(WebView webView2, String str2) {
                        Log.d(StravaActivity.this.TAG, "shouldInterceptRequest url=" + str2);
                        return super.shouldInterceptRequest(webView2, str2);
                    }

                    @Override // android.webkit.WebViewClient
                    public WebResourceResponse shouldInterceptRequest(WebView webView2, WebResourceRequest webResourceRequest) {
                        Log.d(StravaActivity.this.TAG, "shouldInterceptRequest request.getUrl=" + webResourceRequest.getUrl());
                        if (webResourceRequest.getRequestHeaders() != null) {
                            Log.d(StravaActivity.this.TAG, "shouldInterceptRequest request.getRequestHeaders=" + webResourceRequest.getRequestHeaders().toString());
                        }
                        return super.shouldInterceptRequest(webView2, webResourceRequest);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageStarted(WebView webView2, String str2, Bitmap bitmap) {
                        super.onPageStarted(webView2, str2, bitmap);
                        Log.d(StravaActivity.this.TAG, "onPageStarted url=" + str2);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView2, String str2) {
                        super.onPageFinished(webView2, str2);
                        Log.d(StravaActivity.this.TAG, "onPageFinished url=" + str2);
                    }
                });
                String str2 = str;
                if (str2 == null) {
                    StravaActivity stravaActivity = StravaActivity.this;
                    stravaActivity.setBackResult(0, stravaActivity.recordFailed);
                } else {
                    webView.loadUrl(str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stravaTokenExchange(final String str) {
        final String str2 = String.format("https://www.strava.com/oauth/token", new Object[0]);
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.StravaActivity.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                HttpURLConnection httpURLConnection;
                String str3 = String.format("client_id=%s&client_secret=%s&code=%s", "22436", "9a8aa616f75aded938f5d924cdc8c6d502766cb8", str);
                StringBuilder sb = new StringBuilder();
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                    } catch (Exception unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.connect();
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                    bufferedWriter.write(str3);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    }
                    String string = new JSONObject(sb.toString()).getString("access_token");
                    MyApp.strava_access_token = string;
                    FileOutputStream fileOutputStreamOpenFileOutput = StravaActivity.this.openFileOutput("strava_access_token_" + StravaActivity.this.member_no, 0);
                    fileOutputStreamOpenFileOutput.write(string.getBytes());
                    fileOutputStreamOpenFileOutput.close();
                    StravaActivity.this.auth = true;
                    StravaActivity.this.getSharedPreferences("strava", 0).edit().putString("strava", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())).commit();
                    StravaActivity.this.createStravaActivity();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Exception unused2) {
                    httpURLConnection2 = httpURLConnection;
                    StravaActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.StravaActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(StravaActivity.this, StravaActivity.this.recordFailed, 0).show();
                        }
                    });
                    StravaActivity stravaActivity = StravaActivity.this;
                    stravaActivity.setBackResult(0, stravaActivity.recordFailed);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackResult(final int i, final String str) {
        Runnable runnable = new Runnable() { // from class: com.dyaco.sole.activity.StravaActivity.3
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent();
                intent.putExtra("error", str);
                StravaActivity.this.setResult(i, intent);
                StravaActivity.this.finish();
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            runOnUiThread(runnable);
        }
    }

    public StravaActivity() {
        this.member_no = null;
        if (Global.memberData != null) {
            this.member_no = "" + Global.memberData.getAccount_no();
        }
    }

    public void createStravaActivity() {
        String str;
        final String str2;
        new SimpleDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT);
        final String str3 = String.format("https://www.strava.com/api/v3/activities", new Object[0]);
        final String str4 = Global.CLOUD_BRAND_NAME.toUpperCase().charAt(0) + Global.CLOUD_BRAND_NAME.substring(1) + StringUtils.SPACE + this.model;
        String str5 = this.category;
        if (str5.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            str2 = "Run";
        } else {
            if (!str5.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                str = str5.equals(ExifInterface.GPS_MEASUREMENT_2D) ? "Elliptical" : "Ride";
                str2 = "Run";
            }
            str2 = str;
        }
        final String str6 = this.startDate;
        final String strValueOf = String.valueOf(this.duration);
        final String str7 = "" + (Double.valueOf(Double.parseDouble(this.distance)).doubleValue() * 1000.0d);
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.StravaActivity.4
            /* JADX WARN: Removed duplicated region for block: B:31:0x012c A[PHI: r4
              0x012c: PHI (r4v5 java.net.HttpURLConnection) = (r4v4 java.net.HttpURLConnection), (r4v8 java.net.HttpURLConnection) binds: [B:30:0x012a, B:21:0x011d] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0138  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() throws Throwable {
                HttpURLConnection httpURLConnection;
                String str8 = String.format("name=%s&type=%s&start_date_local=%s&elapsed_time=%s&distance=%s", str4, str2, str6, strValueOf, str7);
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
                    try {
                        try {
                            httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                            httpURLConnection.setRequestProperty("Authorization", "Bearer " + MyApp.strava_access_token);
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.connect();
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                            bufferedWriter.write(str8);
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            outputStream.close();
                            StringBuilder sb = new StringBuilder();
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
                                while (true) {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    } else {
                                        sb.append(line);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            StringBuilder sb2 = new StringBuilder();
                            try {
                                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), StandardCharsets.UTF_8));
                                while (true) {
                                    String line2 = bufferedReader2.readLine();
                                    if (line2 == null) {
                                        break;
                                    } else {
                                        sb2.append(line2);
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            Log.d(StravaActivity.this.TAG, "createStravaActivity -> conn.getResponseCode()=" + httpURLConnection.getResponseCode());
                            Log.d(StravaActivity.this.TAG, "createStravaActivity -> inputStreamStringBuilder=" + sb.toString());
                            Log.d(StravaActivity.this.TAG, "createStravaActivity ->  errorStreamStringBuilder=" + sb2.toString());
                            StravaActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.StravaActivity.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(StravaActivity.this, StravaActivity.this.getString(R.string.update_succeful), 0).show();
                                }
                            });
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (httpURLConnection != null) {
                            }
                            StravaActivity.this.setBackResult(-1, null);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        StravaActivity.this.setBackResult(-1, null);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    httpURLConnection = null;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = null;
                    if (httpURLConnection != null) {
                    }
                    StravaActivity.this.setBackResult(-1, null);
                    throw th;
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                StravaActivity.this.setBackResult(-1, null);
            }
        }).start();
    }
}
