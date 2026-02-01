package com.dyaco.sole.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.dyaco.ideabussdk_sole.library.MyActivity;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.adapter.ConnectionListAdapter;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.PostUtil;
import com.dyaco.sole.custom_view.ErrorDialog;
import com.dyaco.sole.custom_view.QuestMainView;
import com.facebook.internal.AnalyticsEvents;
import com.soletreadmills.sole.R;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes.dex */
public class LanguageDialog extends MyActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final int CAMERA = 66;
    private static final int PHOTO = 67;

    /* renamed from: 俄文, reason: contains not printable characters */
    private static final int f0 = 6;

    /* renamed from: 德文, reason: contains not printable characters */
    private static final int f1 = 3;

    /* renamed from: 法文, reason: contains not printable characters */
    private static final int f2 = 2;

    /* renamed from: 簡體中文, reason: contains not printable characters */
    private static final int f3 = 4;

    /* renamed from: 繁體中文, reason: contains not printable characters */
    private static final int f4 = 5;

    /* renamed from: 英文, reason: contains not printable characters */
    private static final int f5 = 0;

    /* renamed from: 西班牙文, reason: contains not printable characters */
    private static final int f6 = 1;
    private ConnectionListAdapter adapter;
    private TextView connection_cancel_textview;
    private TextView connection_connect_textview;
    private ListView connection_listView;
    private TextView connection_title_textview;
    private ErrorDialog errorDialog;
    public Uri imageUri;
    private QuestMainView questMainView;
    private ImageView service_imageview;

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initFragments() {
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(0);
        setContentView(R.layout.dialog_connection);
        initFragments();
        findViews();
        initParams();
        setListeners();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Global.nowActivityName = LanguageDialog.class.getName();
        Global.printLog("d", "LanguageDialog", "onStart - " + Global.nowActivityName);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void findViews() {
        this.connection_title_textview = (TextView) findViewById(R.id.connection_title_textview);
        this.connection_listView = (ListView) findViewById(R.id.connection_listView);
        this.connection_cancel_textview = (TextView) findViewById(R.id.connection_cancel_textview);
        this.connection_connect_textview = (TextView) findViewById(R.id.connection_connect_textview);
        this.service_imageview = (ImageView) findViewById(R.id.service_imageview);
        this.questMainView = (QuestMainView) findViewById(R.id.questMainViewLan);
        this.errorDialog = (ErrorDialog) findViewById(R.id.errorDialogLan);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initParams() {
        this.connection_title_textview.setText(R.string.language_setting);
        ConnectionListAdapter connectionListAdapter = new ConnectionListAdapter(this);
        this.adapter = connectionListAdapter;
        this.connection_listView.setAdapter((ListAdapter) connectionListAdapter);
        this.adapter.addConnectionData(Locale.ENGLISH.toString(), "English", 0);
        this.adapter.addConnectionData(Global.ES.toString(), "Español", 1);
        this.adapter.addConnectionData(Locale.FRANCE.toString(), "Français", 2);
        this.adapter.addConnectionData(Global.DE.toString(), "Deutsch", 3);
        this.adapter.addConnectionData(Locale.CHINA.toString(), "中文(简体)", 4);
        this.adapter.addConnectionData(Locale.TAIWAN.toString(), "中文(繁體)", 5);
        this.adapter.addConnectionData(Global.RU.toString(), "Pусский", 6);
        int i = Global.BRAND;
        if (i == 0 || i == 1) {
            this.adapter.addConnectionData(Global.RU.toString(), "Pусский", 6);
        }
        this.connection_connect_textview.setText(R.string.confirm);
        this.connection_connect_textview.setEnabled(true);
        String string = Global.getSharedPreferences(this).getString(QuestMainView.LANGUAGE, "");
        Log.d("LanguageDialog", "App now language = " + string);
        this.adapter.setSelectedLanguage(string);
        findViewById(R.id.connection_refresh_imageview).setVisibility(8);
    }

    public void showMessageView(final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LanguageDialog.1
            @Override // java.lang.Runnable
            public void run() {
                ErrorLogSave.sendErrorList(LanguageDialog.this.questMainView.getAccount(), LanguageDialog.this.getApplicationContext());
                LanguageDialog.this.questMainView.showQA(QuestMainView.LANGUAGE, str);
                LanguageDialog.this.questMainView.setVisibility(0);
            }
        });
    }

    public void showErrorLog(final int i, final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LanguageDialog.2
            @Override // java.lang.Runnable
            public void run() {
                Log.e("showErrorLog", "show");
                if (LanguageDialog.this.errorDialog.isShown()) {
                    return;
                }
                LanguageDialog.this.errorDialog.setVisibility(0);
                LanguageDialog.this.errorDialog.initView(LanguageDialog.this.getString(i), new View.OnClickListener() { // from class: com.dyaco.sole.activity.LanguageDialog.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LanguageDialog.this.showMessageView(str);
                    }
                }, new View.OnClickListener() { // from class: com.dyaco.sole.activity.LanguageDialog.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LanguageDialog.this.errorDialog.setVisibility(8);
                    }
                });
            }
        });
    }

    public void showCameraDialog() {
        new AlertDialog.Builder(this, R.style.myDialog).setSingleChoiceItems(new String[]{"Camera", "Album"}, -1, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.LanguageDialog.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("description", "Image capture by camera");
                    contentValues.put("mime_type", "image/jpeg");
                    LanguageDialog languageDialog = LanguageDialog.this;
                    languageDialog.imageUri = languageDialog.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", LanguageDialog.this.imageUri);
                    intent.putExtra("android.intent.extra.videoQuality", 1);
                    LanguageDialog.this.startActivityForResult(intent, 66);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setType("image/*");
                    intent2.setAction("android.intent.action.PICK");
                    LanguageDialog.this.startActivityForResult(Intent.createChooser(intent2, "Choose Image File"), 67);
                }
                dialogInterface.dismiss();
            }
        }).show();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 66 || i == 67) {
            final Uri data = i == 66 ? this.imageUri : null;
            if (i == 67 && intent != null) {
                Log.d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                data = intent.getData();
            }
            if (data != null) {
                Log.d(TAG, "uri:" + data.getPath());
                runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LanguageDialog.4
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(LanguageDialog.this.getContentResolver(), data);
                            File file = new File(LanguageDialog.this.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                LanguageDialog.this.questMainView.upLoadImg(new File(file.getPath()));
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

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void setListeners() {
        this.connection_cancel_textview.setOnClickListener(this);
        this.connection_connect_textview.setOnClickListener(this);
        this.connection_listView.setOnItemClickListener(this);
        this.service_imageview.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.connection_cancel_textview /* 2131231027 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "LanguageDialog_cancel_btn", ErrorLogSave.CLICK);
                setResult(0);
                finish();
                break;
            case R.id.connection_connect_textview /* 2131231028 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "LanguageDialog_conncet_btn", ErrorLogSave.CLICK);
                switch (this.adapter.getRssi(this.adapter.getSelected())) {
                    case 0:
                        Global.setAppLocale(getResources(), Locale.ENGLISH);
                        break;
                    case 1:
                        Global.setAppLocale(getResources(), Global.ES);
                        break;
                    case 2:
                        Global.setAppLocale(getResources(), Locale.FRANCE);
                        break;
                    case 3:
                        Global.setAppLocale(getResources(), Global.DE);
                        break;
                    case 4:
                        Global.setAppLocale(getResources(), Locale.CHINA);
                        break;
                    case 5:
                        Global.setAppLocale(getResources(), Locale.TAIWAN);
                        break;
                    case 6:
                        Global.setAppLocale(getResources(), Global.RU);
                        break;
                }
                Global.getSpfEditor(this).putString(QuestMainView.LANGUAGE, this.adapter.getSelectedLanguage()).commit();
                setResult(-1);
                finish();
                break;
            case R.id.service_imageview /* 2131231616 */:
                showMessageView(ErrorLogSave.ERROR_0016);
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "LanguageDialog_onItemClick_btn", "itmeSelect:英文");
                PostUtil.postTrackerData(this, 10);
                break;
            case 1:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "LanguageDialog_onItemClick_btn", "itmeSelect:西班牙文");
                PostUtil.postTrackerData(this, 27);
                break;
            case 2:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "LanguageDialog_onItemClick_btn", "itmeSelect:法文");
                PostUtil.postTrackerData(this, 11);
                break;
            case 3:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "LanguageDialog_onItemClick_btn", "itmeSelect:德文");
                PostUtil.postTrackerData(this, 26);
                break;
            case 4:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "LanguageDialog_onItemClick_btn", "itmeSelect:簡體中文");
                PostUtil.postTrackerData(this, 12);
                break;
            case 5:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "LanguageDialog_onItemClick_btn", "itmeSelect:繁體中文");
                PostUtil.postTrackerData(this, 9);
                break;
            case 6:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "LanguageDialog_onItemClick_btn", "itmeSelect:俄文");
                PostUtil.postTrackerData(this, 26);
                break;
        }
        this.connection_connect_textview.setEnabled(true);
        this.adapter.setSelected(i);
    }
}
