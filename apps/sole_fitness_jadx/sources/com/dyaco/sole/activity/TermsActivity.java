package com.dyaco.sole.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.dyaco.ideabussdk_sole.library.MyActivity;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.PostUtil;
import com.dyaco.sole.custom_view.QuestMainView;
import com.soletreadmills.sole.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: classes.dex */
public class TermsActivity extends MyActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final String TAG = "SOLE-LogoActivity";
    private CheckBox checkBox;
    private int selectorColor;
    private String termsFileName;
    private TextView terms_accept_textview;
    private TextView terms_info_textview;
    private int unselectorColor;

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initFragments() {
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = Global.BRAND;
        if (i == 0) {
            setContentView(R.layout.activity_terms);
        } else if (i == 1) {
            setContentView(R.layout.s_activity_terms);
        } else if (i == 2 || i == 3) {
            setContentView(R.layout.x_activity_terms);
        }
        initFragments();
        findViews();
        initParams();
        setListeners();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Global.nowActivityName = TermsActivity.class.getName();
        Global.printLog("d", TAG, "onStart - " + Global.nowActivityName);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void findViews() {
        this.terms_info_textview = (TextView) findViewById(R.id.terms_info_textview);
        this.checkBox = (CheckBox) findViewById(R.id.checkBox);
        this.terms_accept_textview = (TextView) findViewById(R.id.terms_accept_textview);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initParams() {
        if (Global.BRAND == 3) {
            ((ImageView) findViewById(R.id.title_image)).setImageResource(R.drawable.f_all_logo);
        }
        this.termsFileName = getNowCountry() + "_TermsOfService.txt";
        this.terms_info_textview.setText(Html.fromHtml(loadTextFile().replace("TERMS-NAME", getString(Global.APP_NAME_RID))));
        Resources resources = getResources();
        this.selectorColor = resources.getColor(R.color.white);
        this.unselectorColor = resources.getColor(R.color.light_gray);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void setListeners() {
        this.checkBox.setOnCheckedChangeListener(this);
        this.terms_accept_textview.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostUtil.postTrackerData(this, 1);
        SharedPreferences.Editor spfEditor = Global.getSpfEditor(this);
        spfEditor.putBoolean("terms_accept", true);
        spfEditor.commit();
        goLoginSystem();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.terms_accept_textview.setEnabled(true);
            this.terms_accept_textview.setTextColor(this.selectorColor);
            int i = Global.BRAND;
            if (i == 0) {
                this.terms_accept_textview.setBackgroundResource(R.drawable.all_btn_a_agree_1);
                return;
            }
            if (i == 1) {
                this.terms_accept_textview.setBackgroundResource(R.drawable.s_all_btn_a_agree_1);
                return;
            } else {
                if (i == 2 || i == 3) {
                    this.terms_accept_textview.setBackgroundResource(R.drawable.x_all_btn_a_agree_1);
                    return;
                }
                return;
            }
        }
        this.terms_accept_textview.setEnabled(false);
        int i2 = Global.BRAND;
        if (i2 == 0) {
            this.terms_accept_textview.setTextColor(this.unselectorColor);
            this.terms_accept_textview.setBackgroundResource(R.drawable.all_btn_a_agree_0);
        } else if (i2 == 1) {
            this.terms_accept_textview.setTextColor(this.unselectorColor);
            this.terms_accept_textview.setBackgroundResource(R.drawable.s_all_btn_a_agree_0);
        } else if (i2 == 2 || i2 == 3) {
            this.terms_accept_textview.setTextColor(this.unselectorColor);
            this.terms_accept_textview.setBackgroundResource(R.drawable.x_all_btn_a_agree_0);
        }
    }

    private String getNowCountry() {
        String string = Global.getSharedPreferences(this).getString(QuestMainView.LANGUAGE, "");
        return (string.equals("") || !(string.equals(Locale.ENGLISH.toString()) || string.equals(Locale.FRANCE.toString()) || string.equals(Locale.TRADITIONAL_CHINESE.toString()) || string.equals(Locale.CHINA.toString()) || string.equals(Global.DE.toString()) || string.equals(Global.ES.toString()) || string.equals(Global.RU.toString()))) ? Locale.ENGLISH.toString() : string;
    }

    private String loadTextFile() throws IOException {
        InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = getAssets().open(this.termsFileName);
                byte[] bArr = new byte[inputStreamOpen.available()];
                inputStreamOpen.read(bArr);
                return new String(bArr);
            } finally {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (inputStreamOpen == null) {
                return "";
            }
            try {
                inputStreamOpen.close();
                return "";
            } catch (IOException e3) {
                e3.printStackTrace();
                return "";
            }
        }
    }

    private void goMain() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        finish();
    }

    private void goLoginSystem() {
        Global.printLog("d", TAG, "goLoginSystem");
        startActivity(new Intent(this, (Class<?>) LoginActivity.class));
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        finish();
    }
}
