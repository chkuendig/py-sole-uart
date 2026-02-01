package com.dyaco.sole.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AlertDialog;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.MyApp;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom_view.ErrorDialog;
import com.dyaco.sole.custom_view.QuestMainView;
import com.facebook.internal.AnalyticsEvents;
import com.soletreadmills.sole.R;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONObject;
import org.scribe.model.OAuthConstants;

/* loaded from: classes.dex */
public class OmronConnectLoginActivity extends Activity {
    private static final int CAMERA = 66;
    private static final int PHOTO = 67;
    private static final String TAG = "OmronLogin";
    private ErrorDialog errorDialog;
    public Uri imageUri;
    private WebView omronLoginWeb;
    private QuestMainView questMainView;
    final String server_domain = "data-jp.omronconnect.com";
    final String AppID = "1e3ddd17";
    final String State = "sjp";
    final String clientID = "a9f0of3iq65lvjj98qk9gcpdflg8dtcf97rq";
    final String client_secret = "bevn4duio7v8v1aafrourh4s6ir9gmd8si5hg6ee6u3dnm39uhpki11fsmbre7nk";
    final String callback_URI = "http://com.sole.fitness";
    private String member_no = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_omron_connect_login);
        this.questMainView = (QuestMainView) findViewById(R.id.questMainViewOmron);
        this.errorDialog = (ErrorDialog) findViewById(R.id.errorDialogOmron);
        this.omronLoginWeb = (WebView) findViewById(R.id.omronWeb);
        omronLoginPage();
    }

    public void showMessageView(final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.OmronConnectLoginActivity.1
            @Override // java.lang.Runnable
            public void run() {
                ErrorLogSave.sendErrorList(OmronConnectLoginActivity.this.questMainView.getAccount(), OmronConnectLoginActivity.this.getApplicationContext());
                OmronConnectLoginActivity.this.questMainView.showQA(QuestMainView.OMRON, str);
                OmronConnectLoginActivity.this.questMainView.setVisibility(0);
            }
        });
    }

    public void showErrorLog(final int i, final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.OmronConnectLoginActivity.2
            @Override // java.lang.Runnable
            public void run() {
                Log.e("showErrorLog", "show");
                if (OmronConnectLoginActivity.this.errorDialog.isShown()) {
                    return;
                }
                OmronConnectLoginActivity.this.errorDialog.setVisibility(0);
                OmronConnectLoginActivity.this.errorDialog.initView(OmronConnectLoginActivity.this.getString(i), new View.OnClickListener() { // from class: com.dyaco.sole.activity.OmronConnectLoginActivity.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        OmronConnectLoginActivity.this.showMessageView(str);
                    }
                }, new View.OnClickListener() { // from class: com.dyaco.sole.activity.OmronConnectLoginActivity.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        OmronConnectLoginActivity.this.errorDialog.setVisibility(8);
                        OmronConnectLoginActivity.this.backResult();
                    }
                });
            }
        });
    }

    public void showCameraDialog() {
        new AlertDialog.Builder(this, R.style.myDialog).setSingleChoiceItems(new String[]{"Camera", "Album"}, -1, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.OmronConnectLoginActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("description", "Image capture by camera");
                    contentValues.put("mime_type", "image/jpeg");
                    OmronConnectLoginActivity omronConnectLoginActivity = OmronConnectLoginActivity.this;
                    omronConnectLoginActivity.imageUri = omronConnectLoginActivity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", OmronConnectLoginActivity.this.imageUri);
                    intent.putExtra("android.intent.extra.videoQuality", 1);
                    OmronConnectLoginActivity.this.startActivityForResult(intent, 66);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setType("image/*");
                    intent2.setAction("android.intent.action.PICK");
                    OmronConnectLoginActivity.this.startActivityForResult(Intent.createChooser(intent2, "Choose Image File"), 67);
                }
                dialogInterface.dismiss();
            }
        }).show();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Log.d(TAG, "onActivityResult--------" + i);
        Log.d(TAG, "resultCode--------" + i2);
        if (i == 66 || i == 67) {
            final Uri data = i == 66 ? this.imageUri : null;
            if (i == 67 && intent != null) {
                Log.d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                data = intent.getData();
            }
            if (data != null) {
                Log.d(TAG, "uri:" + data.getPath());
                runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.OmronConnectLoginActivity.4
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(OmronConnectLoginActivity.this.getContentResolver(), data);
                            File file = new File(OmronConnectLoginActivity.this.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                OmronConnectLoginActivity.this.questMainView.upLoadImg(new File(file.getPath()));
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

    private void omronLoginPage() {
        if (Global.memberData != null) {
            this.member_no = "" + Global.memberData.getAccount_no();
        }
        String str = String.format("https://%s/api/apps/%s/oauth2/authorize?response_type=code&client_id=%s&redirect_uri=%s&scope=openid&state=%s", "data-jp.omronconnect.com", "1e3ddd17", "a9f0of3iq65lvjj98qk9gcpdflg8dtcf97rq", "http://com.sole.fitness", "sjp");
        this.omronLoginWeb.getSettings().setJavaScriptEnabled(true);
        this.omronLoginWeb.setWebViewClient(new WebViewClient() { // from class: com.dyaco.sole.activity.OmronConnectLoginActivity.5
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                super.onPageStarted(webView, str2, bitmap);
                if (str2.toLowerCase().startsWith("http://com.sole.fitness".toLowerCase())) {
                    webView.loadDataWithBaseURL("", "<html><body><h3>Loading....</h3></body></html>", "text/html", "UTF-8", "");
                    for (String str3 : str2.substring(str2.indexOf("?") + 1).split("&")) {
                        String[] strArrSplit = str3.split("=");
                        if (strArrSplit[0].equals(OAuthConstants.CODE)) {
                            OmronConnectLoginActivity.this.omronLoginAPI(strArrSplit[1]);
                        }
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
            }
        });
        this.omronLoginWeb.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void omronLoginAPI(final String str) {
        final String str2 = String.format("https://%s/api/apps/%s/oauth2/token", "data-jp.omronconnect.com", "1e3ddd17");
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.OmronConnectLoginActivity.6
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                HttpURLConnection httpURLConnection;
                String str3 = String.format("grant_type=%s&code=%s&redirect_uri=%s&client_id=%s&client_secret=%s", "authorization_code", str, "http://com.sole.fitness", "a9f0of3iq65lvjj98qk9gcpdflg8dtcf97rq", "bevn4duio7v8v1aafrourh4s6ir9gmd8si5hg6ee6u3dnm39uhpki11fsmbre7nk");
                StringBuilder sb = new StringBuilder();
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        try {
                            httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.connect();
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                            bufferedWriter.write(str3);
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            outputStream.close();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                } else {
                                    sb.append(line);
                                }
                            }
                            JSONObject jSONObject = new JSONObject(sb.toString());
                            String string = jSONObject.getString("access_token");
                            String string2 = jSONObject.getString("refresh_token");
                            MyApp.omron_access_token = string;
                            FileOutputStream fileOutputStreamOpenFileOutput = OmronConnectLoginActivity.this.openFileOutput("omron_refresh_token_" + OmronConnectLoginActivity.this.member_no, 0);
                            fileOutputStreamOpenFileOutput.write(string2.getBytes());
                            fileOutputStreamOpenFileOutput.close();
                            try {
                                new MyApp().getOmronSearchDate();
                            } catch (Exception unused) {
                                OmronConnectLoginActivity.this.showErrorLog(R.string.error_0013, ErrorLogSave.ERROR_0013);
                            }
                            OmronConnectLoginActivity.this.backResult();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Exception unused2) {
                            httpURLConnection2 = httpURLConnection;
                            OmronConnectLoginActivity.this.backResult();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backResult() {
        finish();
    }
}
