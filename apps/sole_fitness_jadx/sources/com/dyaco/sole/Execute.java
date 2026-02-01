package com.dyaco.sole;

import android.content.Context;
import android.util.Log;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom_view.QuestMainView;
import com.dyaco.sole.database.MessageDB;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;

/* loaded from: classes.dex */
public class Execute {
    public static final String API = "http://cloud.dyaco.com";
    private static final String TAG = "Execute";

    public static void post(String str, RequestBody requestBody, Callback callback) {
        OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
        Request requestBuild = new Request.Builder().url(API + str).post(requestBody).addHeader("Content-Type", "application/x-www-form-urlencoded").build();
        Log.d(TAG, "post -> request=" + requestBuild.toString() + "\nBody=" + bodyToString(requestBuild));
        okHttpClientBuild.newCall(requestBuild).enqueue(callback);
    }

    private static String bodyToString(Request request) {
        try {
            Request requestBuild = request.newBuilder().build();
            Buffer buffer = new Buffer();
            requestBuild.body().writeTo(buffer);
            String utf8 = buffer.readUtf8();
            return utf8.contains("image/jpeg") ? "is upload image" : utf8;
        } catch (Exception e) {
            Log.e(TAG, "bodyToString : " + e.toString());
            return "did not work";
        }
    }

    public static void getSQADoc(Context context, String str, Callback callback) {
        String string = Global.getSharedPreferences(context).getString(QuestMainView.LANGUAGE, "");
        String str2 = "en";
        if (!string.equals(Locale.ENGLISH.toString())) {
            if (string.equals(Global.ES.toString())) {
                str2 = "es";
            } else if (string.equals(Locale.FRANCE.toString())) {
                str2 = "fr";
            } else if (string.equals(Global.DE.toString())) {
                str2 = "de";
            } else if (string.equals(Locale.CHINA.toString())) {
                str2 = "zh-Hans";
            } else if (string.equals(Locale.TAIWAN.toString())) {
                str2 = "zh-Hant";
            } else if (string.equals(Global.RU.toString())) {
                str2 = "ru";
            }
        }
        Log.e("checkLanguage", string + " | " + str2);
        post("/api/SQADoc/getSQADoc", new FormBody.Builder().add("doc_code", str).add("doc_lang_code", str2).build(), callback);
    }

    public static void getMessage(String str, String str2, Callback callback) {
        post("/api/SQAMessage/getMessage", new FormBody.Builder().add("account_no", str).add("utc_hour", str2).build(), callback);
    }

    public static void addMessage(String str, String str2, String str3, Callback callback) {
        post("/api/SQAMessage/AddMessage", new FormBody.Builder().add("account_no", str).add("utc_hour", str2).add(MessageDB.MSG_CONTENT, str3).build(), callback);
    }

    public static void getAppVersion(String str, Callback callback) {
        post("/api/SQAMessage/GetAPPVersion", new FormBody.Builder().add("app_version_type", str).build(), callback);
    }

    public static void addErrorLog(String str, ArrayList<String> arrayList, Callback callback) {
        post("/api/SQAMessage/AddErrorLog", new FormBody.Builder().add("account_no", str).add("error_log", arrayList.toString()).build(), callback);
    }

    public static void uploadImg(String str, String str2, File file, Callback callback) {
        new OkHttpClient.Builder().connectTimeout(5L, TimeUnit.SECONDS).writeTimeout(20L, TimeUnit.SECONDS).readTimeout(20L, TimeUnit.SECONDS).build().newCall(new Request.Builder().url("http://cloud.dyaco.com/api/SQAMessage/UploadImage").post(new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("account_no", str).addFormDataPart("utc_hour", str2).addFormDataPart("filename", "member.jpg", RequestBody.create(MediaType.parse("image/jpeg"), file)).build()).addHeader("Content-Type", "multipart/form-data").build()).enqueue(callback);
    }

    public static void registUpdate(String str, String str2, String str3, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        if (str != null) {
            builder.add(MessageDB.ACCOUNT, str);
        }
        if (str2 != null) {
            builder.add("password", str2);
        }
        builder.add("user_access_token", str3);
        int i = Global.BRAND;
        String str4 = BuildConfig.FLAVOR;
        if (i != 0) {
            if (i == 1) {
                str4 = "spirit";
            } else if (i == 2) {
                str4 = "xterra";
            } else if (i == 3) {
                str4 = "fuel";
            }
        }
        builder.add("brand_code", str4);
        post("/api/Member20/RegistUpdate", builder.build(), callback);
    }

    public static void getMemberInfo(String str, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add(MessageDB.ACCOUNT, str);
        int i = Global.BRAND;
        String str2 = BuildConfig.FLAVOR;
        if (i != 0) {
            if (i == 1) {
                str2 = "spirit";
            } else if (i == 2) {
                str2 = "xterra";
            } else if (i == 3) {
                str2 = "fuel";
            }
        }
        builder.add("brand_code", str2);
        post("/api/Member20/getMemberInfo", builder.build(), callback);
    }
}
