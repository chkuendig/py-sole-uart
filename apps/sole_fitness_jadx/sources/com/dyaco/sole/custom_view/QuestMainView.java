package com.dyaco.sole.custom_view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.bumptech.glide.Glide;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.sole.Bean.MessageBean;
import com.dyaco.sole.Bean.QABean;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.Execute;
import com.dyaco.sole.activity.ConnectionDialog;
import com.dyaco.sole.activity.GarminConnectLoginActivity;
import com.dyaco.sole.activity.LanguageDialog;
import com.dyaco.sole.activity.LoginActivity;
import com.dyaco.sole.activity.LogoActivity;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.activity.OmronConnectLoginActivity;
import com.dyaco.sole.activity.OutdoorMapsActivity;
import com.dyaco.sole.activity.Register_Step3_Activity;
import com.dyaco.sole.activity.ShareDialog;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.database.MessageDB;
import com.facebook.share.internal.ShareConstants;
import com.soletreadmills.sole.R;
import com.ua.sdk.recorder.datasource.sensor.location.MockLocationClient;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class QuestMainView extends RelativeLayout implements View.OnClickListener {
    public static final String CONNECT_BLE = "CONNECTIONDIALOG";
    public static final String GARMIN = "GARMIN";
    public static final String LANGUAGE = "language";
    public static final String LOGIN = "LOGIN_ACTIVITY";
    public static final String LOGO = "LOGO_ACTIVITY";
    public static final String MAIN = "MAIN_ACTIVITY";
    public static final String OMRON = "omron";
    public static final String OUTDOOR = "outdoor";
    public static final String OUTDOORCN = "outdoorcn";
    public static final String REGIST = "REGIST_STEP3_ACTIVITY";
    public static final String SHARE = "SHARE_DIALOG";
    public static final int inSampleSize = 2;
    private final int LOAD_TIME;
    private RelativeLayout background;
    private ImageView closeImg;
    private ConnectionDialog connectionDialog;
    private String errorCode;
    private GarminConnectLoginActivity garminConnectLoginActivity;
    private boolean isKeepLoading;
    private boolean isQA;
    private boolean isSetting;
    private LanguageDialog languageDialog;
    private LoginActivity loginActivity;
    private LogoActivity logoActivity;
    private MainActivity mainActivity;
    private MemberData memberData;
    private ImageView menu_end_imageview;
    private TypefaceTextView menu_message_textview;
    private TypefaceTextView menu_message_textview1;
    private TypefaceTextView menu_qa_textview;
    private TypefaceTextView menu_qa_textview1;
    private ArrayList<MessageBean> messageBeanArrayList;
    public MessageDB messageDB;
    private Handler messageHandler;
    private Runnable messageRunable;
    private OmronConnectLoginActivity omronConnectLoginActivity;
    private OutdoorMapsActivity outdoorMapsActivity;
    private ImageView photo_send;
    private ArrayList<QABean> qaBeanArrayList;
    private EditText qa_edit;
    private ScrollView qa_scroll;
    private ImageView qa_send;
    private Register_Step3_Activity register_step3_activity;
    private LinearLayout sendBar;
    private String serial;
    private ImageView setImg;
    private ShareDialog shareDialog;
    private RelativeLayout showImg;
    private LinearLayout showmessage;
    private String type;
    private View view;

    public QuestMainView(Context context) {
        super(context);
        this.errorCode = ErrorLogSave.ERROR_0001;
        this.isKeepLoading = false;
        this.LOAD_TIME = MockLocationClient.CONNECTION_TIMEOUT;
        this.isQA = true;
        this.serial = "guest_" + Build.SERIAL;
        this.messageRunable = new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.3
            @Override // java.lang.Runnable
            public void run() {
                QuestMainView.this.getMessage();
            }
        };
        this.isSetting = false;
        initViews(context);
    }

    public QuestMainView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.errorCode = ErrorLogSave.ERROR_0001;
        this.isKeepLoading = false;
        this.LOAD_TIME = MockLocationClient.CONNECTION_TIMEOUT;
        this.isQA = true;
        this.serial = "guest_" + Build.SERIAL;
        this.messageRunable = new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.3
            @Override // java.lang.Runnable
            public void run() {
                QuestMainView.this.getMessage();
            }
        };
        this.isSetting = false;
        initViews(context);
    }

    private void initViews(Context context) {
        this.memberData = getAccoutData();
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.quest_main_layout, this);
        this.view = viewInflate;
        viewInflate.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.menu_end_imageview);
        this.menu_end_imageview = imageView;
        imageView.setOnClickListener(this);
        TypefaceTextView typefaceTextView = (TypefaceTextView) findViewById(R.id.menu_qa_textview);
        this.menu_qa_textview = typefaceTextView;
        typefaceTextView.setOnClickListener(this);
        this.menu_qa_textview1 = (TypefaceTextView) findViewById(R.id.menu_qa_textview1);
        TypefaceTextView typefaceTextView2 = (TypefaceTextView) findViewById(R.id.menu_message_textview);
        this.menu_message_textview = typefaceTextView2;
        typefaceTextView2.setOnClickListener(this);
        this.menu_message_textview1 = (TypefaceTextView) findViewById(R.id.menu_message_textview1);
        ImageView imageView2 = (ImageView) findViewById(R.id.photo_send);
        this.photo_send = imageView2;
        imageView2.setOnClickListener(this);
        this.setImg = (ImageView) findViewById(R.id.setImg);
        ImageView imageView3 = (ImageView) findViewById(R.id.closeImg);
        this.closeImg = imageView3;
        imageView3.setOnClickListener(this);
        this.showmessage = (LinearLayout) findViewById(R.id.showmessage);
        this.showImg = (RelativeLayout) findViewById(R.id.showImg);
        this.background = (RelativeLayout) findViewById(R.id.background);
        this.sendBar = (LinearLayout) findViewById(R.id.sendBar);
        ImageView imageView4 = (ImageView) findViewById(R.id.qa_send);
        this.qa_send = imageView4;
        imageView4.setOnClickListener(this);
        this.qa_edit = (EditText) findViewById(R.id.qa_edit);
        this.qa_scroll = (ScrollView) findViewById(R.id.qa_scroll);
    }

    private MemberData getAccoutData() {
        try {
            QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
            queryBuilder.where(MemberDataDao.Properties.Account.eq(Global.userName), new WhereCondition[0]);
            List<MemberData> list = queryBuilder.list();
            if (list != null && list.size() == 1) {
                return list.get(0);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String getCurrentTimeZone() {
        return String.valueOf(((TimeZone.getDefault().getRawOffset() / 1000) / 60) / 60);
    }

    public void showQA(String str, String str2) {
        changToQA();
        this.isQA = true;
        this.type = str;
        Log.e("closeImg", str);
        if (str.equals(MAIN)) {
            this.mainActivity = (MainActivity) getContext();
        } else if (str.equals(LOGIN)) {
            this.loginActivity = (LoginActivity) getContext();
        } else if (str.equals(LOGO)) {
            this.logoActivity = (LogoActivity) getContext();
        } else if (str.equals(REGIST)) {
            this.register_step3_activity = (Register_Step3_Activity) getContext();
        } else if (str.equals(CONNECT_BLE)) {
            this.connectionDialog = (ConnectionDialog) getContext();
        } else if (str.equals(SHARE)) {
            this.shareDialog = (ShareDialog) getContext();
        } else if (str.equals(GARMIN)) {
            this.garminConnectLoginActivity = (GarminConnectLoginActivity) getContext();
        } else if (str.equals(OMRON)) {
            this.omronConnectLoginActivity = (OmronConnectLoginActivity) getContext();
        } else if (str.equals(OUTDOOR)) {
            this.outdoorMapsActivity = (OutdoorMapsActivity) getContext();
        } else if (!str.equals(OUTDOORCN) && str.equals(LANGUAGE)) {
            this.languageDialog = (LanguageDialog) getContext();
        }
        this.isKeepLoading = false;
        this.errorCode = str2;
        Handler handler = this.messageHandler;
        if (handler != null) {
            handler.removeCallbacks(this.messageRunable);
        }
        LinearLayout linearLayout = this.showmessage;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        this.qaBeanArrayList = new ArrayList<>();
        Execute.getSQADoc(getContext(), str2, new Callback() { // from class: com.dyaco.sole.custom_view.QuestMainView.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e("getSQADoc", "onFailure : " + iOException.toString());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws JSONException, IOException {
                try {
                    String strString = response.body().string();
                    Log.e("getSQADoc", "data : " + strString);
                    JSONArray jSONArray = new JSONObject(strString).getJSONArray("sys_response_data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        QABean qABean = new QABean();
                        qABean.setQuestion(jSONObject.getString("doc_content_q"));
                        qABean.setAnswer(jSONObject.getString("doc_content_a"));
                        QuestMainView.this.qaBeanArrayList.add(qABean);
                    }
                    QuestMainView.this.showmessage.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QuestMainView.this.setQAView();
                        }
                    });
                } catch (Exception e) {
                    Log.e("getSQADoc", "Exception : " + e.toString());
                }
            }
        });
    }

    public void setQAView() {
        if (this.isQA) {
            for (int i = 0; i < this.qaBeanArrayList.size(); i++) {
                QAInfoView qAInfoView = new QAInfoView(getContext());
                qAInfoView.setView(this.qaBeanArrayList.get(i).getQuestion(), this.qaBeanArrayList.get(i).getAnswer());
                this.showmessage.addView(qAInfoView);
            }
        }
    }

    public void changToQA() {
        this.showmessage.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.2
            @Override // java.lang.Runnable
            public void run() {
                QuestMainView.this.menu_qa_textview1.setBackgroundResource(R.drawable.all_title_a_display1);
                QuestMainView.this.menu_message_textview1.setBackground(null);
                QuestMainView.this.background.setBackgroundColor(Color.parseColor("#000000"));
                QuestMainView.this.sendBar.setVisibility(8);
            }
        });
    }

    public void showMessage() {
        LinearLayout linearLayout = this.showmessage;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        if (this.messageDB == null) {
            this.messageDB = new MessageDB(getContext());
        }
        String account = this.serial;
        MemberData memberData = this.memberData;
        if (memberData != null && memberData.getAccount().length() > 0) {
            account = this.memberData.getAccount();
        }
        this.messageBeanArrayList = this.messageDB.getAll(account);
        setMessageView();
        this.isQA = false;
        this.isKeepLoading = true;
        startLoad(3000);
        this.menu_qa_textview1.setBackground(null);
        this.menu_message_textview1.setBackgroundResource(R.drawable.all_title_a_display1);
        this.background.setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.sendBar.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad(int i) {
        if (this.isKeepLoading) {
            Handler handler = this.messageHandler;
            if (handler == null) {
                this.messageHandler = new Handler();
            } else {
                handler.removeCallbacks(this.messageRunable);
            }
            this.messageHandler.postDelayed(this.messageRunable, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageView() {
        ArrayList<MessageBean> arrayList = this.messageBeanArrayList;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if (!this.isSetting) {
            this.isSetting = true;
            this.showmessage.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (QuestMainView.this.isQA) {
                        return;
                    }
                    if (QuestMainView.this.showmessage != null) {
                        QuestMainView.this.showmessage.removeAllViews();
                    }
                    for (final int i = 0; i < QuestMainView.this.messageBeanArrayList.size(); i++) {
                        QAMessageView qAMessageView = new QAMessageView(QuestMainView.this.getContext());
                        qAMessageView.setView((MessageBean) QuestMainView.this.messageBeanArrayList.get(i));
                        if (((MessageBean) QuestMainView.this.messageBeanArrayList.get(i)).getType().equals(ShareConstants.IMAGE_URL) || ((MessageBean) QuestMainView.this.messageBeanArrayList.get(i)).getType().equals("REIMAGE")) {
                            qAMessageView.setTextOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.custom_view.QuestMainView.4.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Glide.with(QuestMainView.this.getContext()).load(((MessageBean) QuestMainView.this.messageBeanArrayList.get(i)).getMsg_content()).into(QuestMainView.this.setImg);
                                    QuestMainView.this.showImg.setVisibility(0);
                                }
                            });
                        }
                        QuestMainView.this.showmessage.addView(qAMessageView);
                    }
                    QuestMainView.this.qa_scroll.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QuestMainView.this.qa_scroll.fullScroll(130);
                        }
                    });
                }
            });
            this.isSetting = false;
        }
        startLoad(MockLocationClient.CONNECTION_TIMEOUT);
    }

    public String getAccount() {
        String str = this.serial;
        MemberData memberData = this.memberData;
        return (memberData == null || memberData.getAccount().length() <= 0) ? str : this.memberData.getAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMessage() {
        final String account = this.serial;
        MemberData memberData = this.memberData;
        if (memberData != null && memberData.getAccount().length() > 0) {
            account = this.memberData.getAccount();
        }
        Execute.getMessage(account, getCurrentTimeZone(), new Callback() { // from class: com.dyaco.sole.custom_view.QuestMainView.5
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e("getMessage", "onFailure : " + iOException.toString());
                QuestMainView.this.startLoad(MockLocationClient.CONNECTION_TIMEOUT);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws JSONException, IOException {
                try {
                    String strString = response.body().string();
                    Log.e("getMessage", "data : " + strString);
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = new JSONObject(strString).getJSONArray("sys_response_data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            MessageBean messageBean = new MessageBean();
                            messageBean.setAccount(account);
                            messageBean.setType(jSONObject.getString("msg_type"));
                            messageBean.setMsg_content(jSONObject.getString(MessageDB.MSG_CONTENT));
                            messageBean.setMsg_datetime(jSONObject.getString(MessageDB.MSG_DATETIME));
                            arrayList.add(messageBean);
                        } catch (Exception e) {
                            Log.e("getMessage", "errorMsg : " + e.toString());
                        }
                    }
                    boolean z = true;
                    if (QuestMainView.this.messageBeanArrayList != null && QuestMainView.this.messageBeanArrayList.size() > 0 && QuestMainView.this.messageBeanArrayList.size() == arrayList.size()) {
                        boolean z2 = false;
                        for (int i2 = 0; i2 < QuestMainView.this.messageBeanArrayList.size(); i2++) {
                            if (!((MessageBean) arrayList.get(i2)).getMsg_content().equals(((MessageBean) QuestMainView.this.messageBeanArrayList.get(i2)).getMsg_content()) && !((MessageBean) arrayList.get(i2)).getAccount().equals(((MessageBean) QuestMainView.this.messageBeanArrayList.get(i2)).getAccount()) && !((MessageBean) arrayList.get(i2)).getType().equals(((MessageBean) QuestMainView.this.messageBeanArrayList.get(i2)).getType()) && !((MessageBean) arrayList.get(i2)).getMsg_datetime().equals(((MessageBean) QuestMainView.this.messageBeanArrayList.get(i2)).getMsg_datetime())) {
                                z2 = true;
                            }
                        }
                        z = z2;
                    }
                    Log.e("checkIsNeed", String.valueOf(z));
                    if (z) {
                        QuestMainView.this.messageBeanArrayList = arrayList;
                        QuestMainView.this.saveToDB(account);
                        QuestMainView.this.setMessageView();
                        return;
                    }
                    QuestMainView.this.startLoad(MockLocationClient.CONNECTION_TIMEOUT);
                } catch (Exception e2) {
                    Log.e("getMessage", "Exception : " + e2.toString());
                    QuestMainView.this.startLoad(MockLocationClient.CONNECTION_TIMEOUT);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToDB(String str) {
        if (this.messageDB == null) {
            this.messageDB = new MessageDB(getContext());
        }
        this.messageDB.delete(str);
        this.messageDB.insert(this.messageBeanArrayList);
    }

    private void addMessage(String str) {
        final String account = this.serial;
        MemberData memberData = this.memberData;
        if (memberData != null && memberData.getAccount().length() > 0) {
            account = this.memberData.getAccount();
        }
        Log.e("checkAccountadd", this.memberData.toString());
        this.messageBeanArrayList = new ArrayList<>();
        Execute.addMessage(account, getCurrentTimeZone(), str, new Callback() { // from class: com.dyaco.sole.custom_view.QuestMainView.6
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e("addMessage", "onFailure : " + iOException.toString());
                QuestMainView.this.startLoad(MockLocationClient.CONNECTION_TIMEOUT);
                QuestMainView.this.qa_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QuestMainView.this.qa_send.setEnabled(true);
                    }
                });
                QuestMainView.this.photo_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.6.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QuestMainView.this.photo_send.setEnabled(true);
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws JSONException, IOException {
                try {
                    String strString = response.body().string();
                    Log.e("addMessage", "data : " + strString);
                    JSONArray jSONArray = new JSONObject(strString).getJSONArray("sys_response_data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            MessageBean messageBean = new MessageBean();
                            messageBean.setAccount(account);
                            messageBean.setType(jSONObject.getString("msg_type"));
                            messageBean.setMsg_content(jSONObject.getString(MessageDB.MSG_CONTENT));
                            messageBean.setMsg_datetime(jSONObject.getString(MessageDB.MSG_DATETIME));
                            QuestMainView.this.messageBeanArrayList.add(messageBean);
                        } catch (Exception e) {
                            Log.e("addMessage", "errorMsg : " + e.toString());
                        }
                    }
                    QuestMainView.this.saveToDB(account);
                    QuestMainView.this.setMessageView();
                    QuestMainView.this.qa_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.6.3
                        @Override // java.lang.Runnable
                        public void run() {
                            QuestMainView.this.qa_send.setEnabled(true);
                        }
                    });
                    QuestMainView.this.photo_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.6.4
                        @Override // java.lang.Runnable
                        public void run() {
                            QuestMainView.this.photo_send.setEnabled(true);
                        }
                    });
                } catch (Exception e2) {
                    Log.e("addMessage", "Exception : " + e2.toString());
                    QuestMainView.this.startLoad(MockLocationClient.CONNECTION_TIMEOUT);
                    QuestMainView.this.qa_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.6.5
                        @Override // java.lang.Runnable
                        public void run() {
                            QuestMainView.this.qa_send.setEnabled(true);
                        }
                    });
                    QuestMainView.this.photo_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.6.6
                        @Override // java.lang.Runnable
                        public void run() {
                            QuestMainView.this.photo_send.setEnabled(true);
                        }
                    });
                }
            }
        });
    }

    public void upLoadImg(File file) {
        this.qa_send.setEnabled(false);
        this.photo_send.setEnabled(false);
        Handler handler = this.messageHandler;
        if (handler != null) {
            handler.removeCallbacks(this.messageRunable);
        }
        final String account = this.serial;
        MemberData memberData = this.memberData;
        if (memberData != null && memberData.getAccount().length() > 0) {
            account = this.memberData.getAccount();
        }
        this.messageBeanArrayList = new ArrayList<>();
        Execute.uploadImg(account, getCurrentTimeZone(), file, new Callback() { // from class: com.dyaco.sole.custom_view.QuestMainView.7
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e("uploadImg", "onFailure : " + iOException.toString());
                QuestMainView.this.startLoad(MockLocationClient.CONNECTION_TIMEOUT);
                QuestMainView.this.qa_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QuestMainView.this.qa_send.setEnabled(true);
                    }
                });
                QuestMainView.this.photo_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QuestMainView.this.photo_send.setEnabled(true);
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws JSONException, IOException {
                try {
                    String strString = response.body().string();
                    Log.e("uploadImg", "data : " + strString);
                    JSONArray jSONArray = new JSONObject(strString).getJSONArray("sys_response_data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            MessageBean messageBean = new MessageBean();
                            messageBean.setAccount(account);
                            messageBean.setType(jSONObject.getString("msg_type"));
                            messageBean.setMsg_content(jSONObject.getString(MessageDB.MSG_CONTENT));
                            messageBean.setMsg_datetime(jSONObject.getString(MessageDB.MSG_DATETIME));
                            QuestMainView.this.messageBeanArrayList.add(messageBean);
                        } catch (Exception e) {
                            Log.e("uploadImg", "errorMsg : " + e.toString());
                        }
                    }
                    QuestMainView.this.saveToDB(account);
                    QuestMainView.this.setMessageView();
                    QuestMainView.this.qa_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.7.3
                        @Override // java.lang.Runnable
                        public void run() {
                            QuestMainView.this.qa_send.setEnabled(true);
                        }
                    });
                    QuestMainView.this.photo_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.7.4
                        @Override // java.lang.Runnable
                        public void run() {
                            QuestMainView.this.photo_send.setEnabled(true);
                        }
                    });
                } catch (Exception e2) {
                    Log.e("uploadImg", "Exception : " + e2.toString());
                    QuestMainView.this.startLoad(MockLocationClient.CONNECTION_TIMEOUT);
                    QuestMainView.this.qa_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.7.5
                        @Override // java.lang.Runnable
                        public void run() {
                            QuestMainView.this.qa_send.setEnabled(true);
                        }
                    });
                    QuestMainView.this.photo_send.post(new Runnable() { // from class: com.dyaco.sole.custom_view.QuestMainView.7.6
                        @Override // java.lang.Runnable
                        public void run() {
                            QuestMainView.this.photo_send.setEnabled(true);
                        }
                    });
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.closeImg /* 2131230998 */:
                this.setImg.setImageDrawable(null);
                this.showImg.setVisibility(8);
                break;
            case R.id.menu_end_imageview /* 2131231396 */:
                changToQA();
                this.isKeepLoading = false;
                this.view.setVisibility(8);
                Log.e("closeImg", this.type + "");
                if (this.type.equals(OUTDOOR) && !this.outdoorMapsActivity.isErrorShow()) {
                    this.outdoorMapsActivity.changeView();
                    break;
                }
                break;
            case R.id.menu_message_textview /* 2131231401 */:
                showMessage();
                break;
            case R.id.menu_qa_textview /* 2131231406 */:
                showQA(this.type, this.errorCode);
                break;
            case R.id.photo_send /* 2131231480 */:
                if (this.type.equals(MAIN)) {
                    this.mainActivity.showCameraDialog();
                    break;
                } else if (this.type.equals(LOGIN)) {
                    this.loginActivity.showCameraDialog();
                    break;
                } else if (this.type.equals(LOGO)) {
                    this.logoActivity.showCameraDialog();
                    break;
                } else if (this.type.equals(REGIST)) {
                    this.register_step3_activity.showCameraDialog();
                    break;
                } else if (this.type.equals(CONNECT_BLE)) {
                    this.connectionDialog.showCameraDialog();
                    break;
                } else if (this.type.equals(SHARE)) {
                    this.shareDialog.showCameraDialog();
                    break;
                } else if (this.type.equals(GARMIN)) {
                    this.garminConnectLoginActivity.showCameraDialog();
                    break;
                } else if (this.type.equals(OMRON)) {
                    this.omronConnectLoginActivity.showCameraDialog();
                    break;
                } else if (this.type.equals(OUTDOOR)) {
                    this.outdoorMapsActivity.showCameraDialog();
                    break;
                } else if (!this.type.equals(OUTDOORCN) && this.type.equals(LANGUAGE)) {
                    this.languageDialog.showCameraDialog();
                    break;
                }
                break;
            case R.id.qa_send /* 2131231510 */:
                if (this.qa_edit.getText().length() > 0) {
                    this.qa_send.setEnabled(false);
                    this.photo_send.setEnabled(false);
                    Handler handler = this.messageHandler;
                    if (handler != null) {
                        handler.removeCallbacks(this.messageRunable);
                    }
                    addMessage(this.qa_edit.getText().toString());
                    this.qa_edit.setText("");
                    break;
                }
                break;
        }
    }
}
