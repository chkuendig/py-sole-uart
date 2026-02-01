package com.soletreadmills.sole.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.ResponseMessage;
import com.digifly.cloudapi.listener.MemberLoginListener;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.Global;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes2.dex */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private static final String GRANT_TYPE = "authorization_code";
    public static final String WECHAT_ACCESS_FAIL = "wechat access fail";
    private static final String WECHAT_URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
    private static final String WECHAT_URL_USERINFO = "https://api.weixin.qq.com/sns/userinfo";
    private String WECHAT_APP_ID;
    private String WECHAT_SECRET_ID;
    private IWXAPI api;
    private OkHttpClient okHttpClient = new OkHttpClient();

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.d("wechat   test  wxentryactivity = wechat   test  wxentryactivity");
        getWechatAppID_SecretID();
        this.api = WXAPIFactory.createWXAPI(this, this.WECHAT_APP_ID, true);
        this.api.handleIntent(getIntent(), this);
    }

    private void getWechatAppID_SecretID() {
        int i = Global.BRAND;
        if (i == 0) {
            this.WECHAT_APP_ID = getResources().getString(R.string.wechat_app_id_sole);
            this.WECHAT_SECRET_ID = getResources().getString(R.string.wechat_secret_id_sole);
            return;
        }
        if (i == 1) {
            this.WECHAT_APP_ID = getResources().getString(R.string.wechat_app_id_spirit);
            this.WECHAT_SECRET_ID = getResources().getString(R.string.wechat_secret_id_spirit);
        } else if (i == 2) {
            this.WECHAT_APP_ID = getResources().getString(R.string.wechat_app_id_xterra);
            this.WECHAT_SECRET_ID = getResources().getString(R.string.wechat_secret_id_xterra);
        } else {
            if (i != 3) {
                return;
            }
            this.WECHAT_APP_ID = getResources().getString(R.string.wechat_app_id_fuel);
            this.WECHAT_SECRET_ID = getResources().getString(R.string.wechat_secret_id_fuel);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        Logger.d("wechat  baseReq = " + baseReq);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        Logger.d("wechat  baseResp.errCode = " + baseResp.errCode);
        int i = baseResp.errCode;
        if (i == -4) {
            Toast.makeText(this, "wechat access fail", 0).show();
            finish();
            return;
        }
        if (i == -2) {
            Toast.makeText(this, "wechat access fail", 0).show();
            finish();
        } else {
            if (i == 0) {
                String str = ((SendAuth.Resp) baseResp).code;
                Logger.d("code = " + str);
                callWechatAccessToken(this.WECHAT_APP_ID, this.WECHAT_SECRET_ID, str, GRANT_TYPE);
                return;
            }
            Toast.makeText(this, "wechat access fail", 0).show();
            finish();
        }
    }

    public void callWechatAccessToken(String str, String str2, String str3, String str4) {
        this.okHttpClient.newCall(new Request.Builder().url(WECHAT_URL_ACCESS_TOKEN + String.format("?appid=%s&secret=%s&code=%s&grant_type=%s", str, str2, str3, str4)).build()).enqueue(new AnonymousClass1());
    }

    /* renamed from: com.soletreadmills.sole.wxapi.WXEntryActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Callback {
        AnonymousClass1() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, final IOException iOException) {
            WXEntryActivity.this.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole.wxapi.WXEntryActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(WXEntryActivity.this, "wechat access fail  " + iOException.getMessage(), 0).show();
                    WXEntryActivity.this.finish();
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            String str = (String) WXEntryActivity.this.parseWechatAccessTokenData(response.body().string()).get("unionid");
            if (str == null) {
                WXEntryActivity.this.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole.wxapi.WXEntryActivity.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(WXEntryActivity.this, "wechat access fail", 0).show();
                        WXEntryActivity.this.finish();
                    }
                });
            }
            CloudApi cloudApi = CloudApi.getInstance(WXEntryActivity.this);
            final String str2 = str + "@wechat";
            cloudApi.setMemberLoginListener(new MemberLoginListener() { // from class: com.soletreadmills.sole.wxapi.WXEntryActivity.1.3
                @Override // com.digifly.cloudapi.listener.MemberLoginListener
                public void onSuccess(MemberData memberData) {
                    MemberDataDao memberDataDao = DbManager.getMemberDataDao();
                    QueryBuilder<MemberData> queryBuilder = memberDataDao.queryBuilder();
                    queryBuilder.where(MemberDataDao.Properties.Account.eq(memberData.getAccount()), new WhereCondition[0]);
                    List<MemberData> list = queryBuilder.list();
                    if (list != null && list.size() == 0) {
                        memberDataDao.insert(memberData);
                    } else {
                        list.get(0).setName(memberData.getName());
                        list.get(0).setEmail(memberData.getEmail());
                        list.get(0).setSex(memberData.getSex());
                        list.get(0).setBirthday(memberData.getBirthday());
                        list.get(0).setHeight(memberData.getHeight());
                        list.get(0).setWeight(memberData.getWeight());
                        list.get(0).setUnit_type(memberData.getUnit_type());
                        memberDataDao.update(list.get(0));
                    }
                    QueryBuilder<MemberData> queryBuilder2 = memberDataDao.queryBuilder();
                    queryBuilder2.where(MemberDataDao.Properties.Account.eq(memberData.getAccount()), new WhereCondition[0]);
                    List<MemberData> list2 = queryBuilder2.list();
                    list2.get(0).setPassword("");
                    memberDataDao.update(list2.get(0));
                    Global.userName = str2;
                    Global.calendarUserName = str2;
                    Global.memberData = memberData;
                    WXEntryActivity.this.goMain();
                }

                @Override // com.digifly.cloudapi.listener.MemberLoginListener
                public void onFail(final ResponseMessage responseMessage) {
                    WXEntryActivity.this.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole.wxapi.WXEntryActivity.1.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(WXEntryActivity.this, responseMessage.getMessage(), 0).show();
                            WXEntryActivity.this.finish();
                        }
                    });
                }

                @Override // com.digifly.cloudapi.listener.MemberLoginListener
                public void onError(final String str3) {
                    WXEntryActivity.this.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole.wxapi.WXEntryActivity.1.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(WXEntryActivity.this, str3, 0).show();
                            WXEntryActivity.this.finish();
                        }
                    });
                }
            });
            cloudApi.callMemberLogin(str2, "", "WECHAT");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goMain() {
        boolean booleanExtra = getIntent().getBooleanExtra("restart", false);
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("restart", booleanExtra);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> parseWechatAccessTokenData(String str) {
        return (Map) new Gson().fromJson(str, new TypeToken<Map<String, String>>() { // from class: com.soletreadmills.sole.wxapi.WXEntryActivity.2
        }.getType());
    }
}
