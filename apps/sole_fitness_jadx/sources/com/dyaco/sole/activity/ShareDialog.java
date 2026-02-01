package com.dyaco.sole.activity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.dyaco.ideabussdk_sole.library.MyActivity;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom_view.ErrorDialog;
import com.dyaco.sole.custom_view.QuestMainView;
import com.dyaco.sole.custom_view.switch_button.SwitchButton;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.stetho.common.LogUtil;
import com.soletreadmills.sole.R;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.cli.HelpFormatter;

/* loaded from: classes.dex */
public class ShareDialog extends MyActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int CAMERA = 66;
    private static final int PHOTO = 67;
    public static boolean flag = false;
    private ErrorDialog errorDialog;
    private SwitchButton fitbit_switch_button;
    public Uri imageUri;
    private boolean isFirstRecord;
    private SwitchButton mmf_switch_button;
    private QuestMainView questMainView;
    private SwitchButton record_switch_button;
    private String shareText;
    private ImageView share_cancel_image;
    private View share_facebook_layout;
    private View share_fitbit_layout;
    private View share_map_my_fitness_layout;
    private View share_other_layout;
    private LinearLayout share_record_content_layout;
    private View share_record_layout;
    private View share_strava_layout;
    private View share_twitter_layout;
    private SwitchButton strava_switch_button;
    private String trackCalories;
    private String trackCategory;
    private String trackDistance;
    private String trackDuration;
    private String trackHeartRate;
    private String trackModel;
    private String trackProgram;
    private String trackSpeed;
    private String trackStartDate;

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initFragments() {
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(0);
        setContentView(R.layout.dialog_share);
        initFragments();
        findViews();
        initParams();
        setListeners();
        if (checkInternet(getApplicationContext())) {
            return;
        }
        new AlertDialog.Builder(getApplicationContext()).setCancelable(false).setMessage(getApplicationContext().getString(R.string.internet_error)).setPositiveButton(getApplicationContext().getString(R.string.yes), (DialogInterface.OnClickListener) null).show();
    }

    public static boolean checkInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Global.nowActivityName = ShareDialog.class.getName();
        Global.printLog("d", "ShareDialog", "onStart - " + Global.nowActivityName);
        this.share_record_layout.setEnabled(true);
        this.share_map_my_fitness_layout.setEnabled(true);
        this.share_fitbit_layout.setEnabled(true);
        this.share_strava_layout.setEnabled(true);
        Intent intent = getIntent();
        if (intent.getIntExtra("nowPage", 6) != 6) {
            findViewById(R.id.share_record_content_layout).setVisibility(8);
        }
        String stringExtra = intent.getStringExtra("shareRecording");
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (stringExtra.contains(HelpFormatter.DEFAULT_OPT_PREFIX)) {
            try {
                String string = getString(Global.APP_NAME_RID);
                String[] strArrSplit = stringExtra.split(HelpFormatter.DEFAULT_OPT_PREFIX);
                String str = strArrSplit[0];
                String[] strArrSplit2 = strArrSplit[1].split(CertificateUtil.DELIMITER);
                this.shareText = String.format(getString(R.string.share_format_text), string, str, strArrSplit2[0], strArrSplit2[1], strArrSplit2[2], "\nGoogle Play https://play.google.com/store/apps/details?id=com.dyaco.sole\nApple Store ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.shareText = "";
        }
        this.trackCalories = intent.getStringExtra("trackCalories");
        this.trackStartDate = intent.getStringExtra("trackStartDate");
        this.trackDuration = intent.getStringExtra("trackDuration");
        this.trackDistance = intent.getStringExtra("trackDistance");
        this.trackSpeed = intent.getStringExtra("trackSpeed");
        this.trackHeartRate = intent.getStringExtra("trackHeartRate");
        this.trackProgram = intent.getStringExtra("trackProgram");
        this.trackModel = intent.getStringExtra("trackModel");
        this.trackCategory = intent.getStringExtra("trackCategory");
        Log.d("test", "ShareDialog~~~~~~~~~~~trackCalories = " + this.trackCalories);
        Log.d("test", "ShareDialog~~~~~~~~~~~trackDuration = " + this.trackDuration);
        Log.d("test", "ShareDialog~~~~~~~~~~~trackStartDate = " + this.trackStartDate);
        Log.d("test", "ShareDialog~~~~~~~~~~~trackDistance = " + this.trackDistance);
        Log.d("test", "ShareDialog~~~~~~~~~~~trackSpeed = " + this.trackSpeed);
        Log.d("test", "ShareDialog~~~~~~~~~~~trackHeartRate = " + this.trackHeartRate);
        Log.d("test", "ShareDialog~~~~~~~~~~~trackProgram = " + this.trackProgram);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void findViews() {
        this.share_cancel_image = (ImageView) findViewById(R.id.share_cancel_image);
        this.share_facebook_layout = findViewById(R.id.share_facebook_layout);
        this.share_twitter_layout = findViewById(R.id.share_twitter_layout);
        this.share_other_layout = findViewById(R.id.share_other_layout);
        this.share_fitbit_layout = findViewById(R.id.share_fitbit_layout);
        this.share_record_layout = findViewById(R.id.share_record_layout);
        this.share_map_my_fitness_layout = findViewById(R.id.share_map_my_fitness_layout);
        this.share_strava_layout = findViewById(R.id.share_strava_layout);
        this.fitbit_switch_button = (SwitchButton) findViewById(R.id.fitbit_switch_button);
        this.record_switch_button = (SwitchButton) findViewById(R.id.record_switch_button);
        this.mmf_switch_button = (SwitchButton) findViewById(R.id.mmf_switch_button);
        this.strava_switch_button = (SwitchButton) findViewById(R.id.strava_switch_button);
        this.share_record_content_layout = (LinearLayout) findViewById(R.id.share_record_content_layout);
        this.questMainView = (QuestMainView) findViewById(R.id.questMainViewShare);
        this.errorDialog = (ErrorDialog) findViewById(R.id.errorDialogShare);
        if (Global.shareMore) {
            this.share_record_content_layout.setVisibility(0);
        } else {
            this.share_record_content_layout.setVisibility(8);
        }
    }

    public void showMessageView(final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.ShareDialog.1
            @Override // java.lang.Runnable
            public void run() {
                ErrorLogSave.sendErrorList(ShareDialog.this.questMainView.getAccount(), ShareDialog.this.getApplicationContext());
                ShareDialog.this.questMainView.showQA(QuestMainView.SHARE, str);
                ShareDialog.this.questMainView.setVisibility(0);
            }
        });
    }

    public void showErrorLog(final int i, final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.ShareDialog.2
            @Override // java.lang.Runnable
            public void run() {
                Log.e("showErrorLog", "show");
                ShareDialog.this.errorDialog.setVisibility(0);
                ShareDialog.this.errorDialog.initView(ShareDialog.this.getString(i), new View.OnClickListener() { // from class: com.dyaco.sole.activity.ShareDialog.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ShareDialog.this.showMessageView(str);
                    }
                }, new View.OnClickListener() { // from class: com.dyaco.sole.activity.ShareDialog.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ShareDialog.this.errorDialog.setVisibility(8);
                    }
                });
            }
        });
    }

    public void showCameraDialog() {
        new AlertDialog.Builder(this, R.style.myDialog).setSingleChoiceItems(new String[]{"Camera", "Album"}, -1, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.ShareDialog.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("description", "Image capture by camera");
                    contentValues.put("mime_type", "image/jpeg");
                    ShareDialog shareDialog = ShareDialog.this;
                    shareDialog.imageUri = shareDialog.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", ShareDialog.this.imageUri);
                    intent.putExtra("android.intent.extra.videoQuality", 1);
                    ShareDialog.this.startActivityForResult(intent, 66);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setType("image/*");
                    intent2.setAction("android.intent.action.PICK");
                    ShareDialog.this.startActivityForResult(Intent.createChooser(intent2, "Choose Image File"), 67);
                }
                dialogInterface.dismiss();
            }
        }).show();
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initParams() {
        this.isFirstRecord = Global.getSharedPreferences(this).getBoolean("isFirstRecord", true);
        this.fitbit_switch_button.setChecked(Global.getSharedPreferences(this).getBoolean("fitbit_auto", false));
        this.record_switch_button.setChecked(Global.getSharedPreferences(this).getBoolean("record_auto", false));
        this.mmf_switch_button.setChecked(Global.getSharedPreferences(this).getBoolean("mmf_auto", false));
        this.strava_switch_button.setChecked(Global.getSharedPreferences(this).getBoolean("strava_auto", false));
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void setListeners() {
        this.share_cancel_image.setOnClickListener(this);
        this.share_facebook_layout.setOnClickListener(this);
        this.share_twitter_layout.setOnClickListener(this);
        this.share_fitbit_layout.setOnClickListener(this);
        this.share_record_layout.setOnClickListener(this);
        this.share_map_my_fitness_layout.setOnClickListener(this);
        this.share_strava_layout.setOnClickListener(this);
        this.share_other_layout.setOnClickListener(this);
        this.fitbit_switch_button.setOnCheckedChangeListener(this);
        this.record_switch_button.setOnCheckedChangeListener(this);
        this.mmf_switch_button.setOnCheckedChangeListener(this);
        this.strava_switch_button.setOnCheckedChangeListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        switch (view.getId()) {
            case R.id.share_cancel_image /* 2131231642 */:
                setResult(0);
                finish();
                break;
            case R.id.share_fitbit_layout /* 2131231644 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "ShareDialog_fitbit", ErrorLogSave.CLICK);
                goFitbit();
                break;
            case R.id.share_map_my_fitness_layout /* 2131231645 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "ShareDialog_fitness", ErrorLogSave.CLICK);
                goMapMyFitness();
                break;
            case R.id.share_other_layout /* 2131231646 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "ShareDialog_other", ErrorLogSave.CLICK);
                shareTo(getString(R.string.shareto));
                break;
            case R.id.share_record_layout /* 2131231648 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "ShareDialog_record", ErrorLogSave.CLICK);
                goMapMyFitness();
                break;
            case R.id.share_strava_layout /* 2131231649 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "ShareDialog_strava", ErrorLogSave.CLICK);
                goStrava();
                break;
        }
    }

    private void setNotFirstRecord() {
        this.isFirstRecord = false;
        Global.getSpfEditor(this).putBoolean("isFirstRecord", false).commit();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.isFirstRecord) {
            setNotFirstRecord();
        }
        switch (compoundButton.getId()) {
            case R.id.fitbit_switch_button /* 2131231224 */:
                Global.getSpfEditor(this).putBoolean("fitbit_auto", z).commit();
                break;
            case R.id.mmf_switch_button /* 2131231420 */:
                Global.getSpfEditor(this).putBoolean("mmf_auto", z).commit();
                break;
            case R.id.record_switch_button /* 2131231521 */:
                Global.getSpfEditor(this).putBoolean("record_auto", z).commit();
                break;
            case R.id.strava_switch_button /* 2131231696 */:
                Global.getSpfEditor(this).putBoolean("strava_auto", z).commit();
                break;
        }
    }

    private void shareTo(String str) throws IOException {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/jpeg");
        Uri uri = null;
        try {
            FileInputStream fileInputStreamOpenFileInput = getApplicationContext().openFileInput(Global.screenshotFile.getName());
            uri = Uri.parse(MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(), BitmapFactory.decodeStream(fileInputStreamOpenFileInput), (String) null, (String) null));
            fileInputStreamOpenFileInput.close();
        } catch (Exception e) {
            LogUtil.v(TAG, "shareAct e = ", e);
            showErrorLog(R.string.error_0011, ErrorLogSave.ERROR_0011);
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        startActivity(Intent.createChooser(intent, str));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            showErrorLog(R.string.error_0011, ErrorLogSave.ERROR_0011);
        }
        if (i != 101 && i != 102 && i != 103) {
            if (i == 66 || i == 67) {
                final Uri data = i == 66 ? this.imageUri : null;
                if (i == 67 && intent != null) {
                    Log.d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                    data = intent.getData();
                }
                if (data != null) {
                    Log.d(TAG, "uri:" + data.getPath());
                    runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.ShareDialog.4
                        @Override // java.lang.Runnable
                        public void run() throws IOException {
                            try {
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(ShareDialog.this.getContentResolver(), data);
                                File file = new File(ShareDialog.this.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
                                try {
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                    ShareDialog.this.questMainView.upLoadImg(new File(file.getPath()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } catch (Exception e2) {
                                Log.e("uploadImg", "bitmapEr : " + e2.toString());
                            }
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if ((extras != null ? extras.getString("error") : null) != null) {
                showErrorLog(R.string.error_0011, ErrorLogSave.ERROR_0011);
            }
        } else {
            Toast.makeText(this, getString(R.string.record_cancel), 0).show();
        }
        if (i == 101) {
            this.share_fitbit_layout.setEnabled(true);
            this.fitbit_switch_button.setChecked(i2 == -1);
        } else {
            if (i == 102) {
                this.share_record_layout.setEnabled(true);
                this.share_map_my_fitness_layout.setEnabled(true);
                this.record_switch_button.setChecked(i2 == -1);
                this.mmf_switch_button.setChecked(i2 == -1);
                return;
            }
            if (i == 103) {
                this.share_strava_layout.setEnabled(true);
                this.strava_switch_button.setChecked(i2 == -1);
            }
        }
    }

    private void goFitbit() {
        Intent intent = new Intent(this, (Class<?>) FitbitAuthenticationActivity.class);
        intent.putExtra("auth", true);
        intent.putExtra("trackCalories", this.trackCalories);
        intent.putExtra("trackStartDate", this.trackStartDate);
        intent.putExtra("trackDuration", this.trackDuration);
        intent.putExtra("trackDistance", this.trackDistance);
        startActivityForResult(intent, 101);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void goMapMyFitness() {
        Intent intent = new Intent(this, (Class<?>) MapMyFitnessActivity.class);
        intent.putExtra("auth", true);
        intent.putExtra("shareText", this.shareText);
        intent.putExtra("trackCalories", this.trackCalories);
        intent.putExtra("trackStartDate", this.trackStartDate);
        intent.putExtra("trackDuration", this.trackDuration);
        intent.putExtra("trackDistance", this.trackDistance);
        intent.putExtra("trackSpeed", this.trackSpeed);
        intent.putExtra("trackHeartRate", this.trackHeartRate);
        intent.putExtra("trackProgram", this.trackProgram);
        startActivityForResult(intent, 102);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void goStrava() {
        Intent intent = new Intent(this, (Class<?>) StravaActivity.class);
        intent.putExtra("trackModel", this.trackModel);
        intent.putExtra("trackCategory", this.trackCategory);
        intent.putExtra("trackStartDate", this.trackStartDate);
        intent.putExtra("trackDuration", this.trackDuration);
        intent.putExtra("trackDistance", this.trackDistance);
        startActivityForResult(intent, 103);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
