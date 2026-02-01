package com.dyaco.sole.custom;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.dyaco.sole.database.PostData;
import com.dyaco.sole.database.PostDataDB;
import com.dyaco.sole.database.WorkoutData;
import com.facebook.appevents.codeless.internal.Constants;
import com.ua.sdk.datapoint.BaseDataTypes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.cli.HelpFormatter;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.OAuthConstants;

/* loaded from: classes.dex */
public class PostUtil {
    public static final String API_ERROR_INFO = "api/error_info";
    public static final String API_GOODS_CON = "api/goods_con";
    public static final String API_SPORTS_INFO = "api/sports_info";
    public static final String API_SYS = "api/sys";
    public static final String API_USE_ITEM = "api/use_item";
    public static final String POST_FAILED = "failed";
    public static final String POST_SUCCESSFUL = "successful";
    public static final String POST_TYPE_EVENT = "event";
    public static final String POST_TYPE_SYSTEM = "system";
    private static final String POST_URL = "http://dyaco.ideabus.net/";
    private static final String TAG = "PostUtil";
    private static boolean isNotNetwork = false;
    public static OnConnectResultListener listener;

    public interface OnConnectResultListener {
        void onPostResult(String str, String str2, String str3);
    }

    public static void setOnConnectListener(OnConnectResultListener onConnectResultListener) {
        listener = onConnectResultListener;
    }

    private static void onPostResult(String str, String str2, String str3) {
        OnConnectResultListener onConnectResultListener = listener;
        if (onConnectResultListener != null) {
            onConnectResultListener.onPostResult(str, str2, str3);
        }
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [com.dyaco.sole.custom.PostUtil$1] */
    public static void postSystemData(final Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("only_value", Build.SERIAL));
        arrayList.add(new BasicNameValuePair("os", Constants.PLATFORM));
        arrayList.add(new BasicNameValuePair("model", Build.MODEL));
        arrayList.add(new BasicNameValuePair("company", Build.MANUFACTURER));
        if (str != null) {
            if (str.contains(",") && str.split(",").length == 2) {
                arrayList.add(new BasicNameValuePair("gps", str));
            } else {
                onPostResult(POST_FAILED, POST_TYPE_SYSTEM, "gps must contain ','  e.g. '24.141241,120.670363' ");
                return;
            }
        }
        arrayList.add(new BasicNameValuePair("app_code", "" + Global.BRAND + 1));
        arrayList.add(new BasicNameValuePair("enc", "Mjg4NzY0OA=="));
        arrayList.add(new BasicNameValuePair("trigger_date", Global.getDateTime()));
        String str2 = TAG;
        Log.d(str2, "手機唯一碼 = " + Build.SERIAL);
        Log.d(str2, "手機廠牌 = " + Build.MANUFACTURER);
        Log.d(str2, "手機型號 = " + Build.MODEL);
        send2Server(context, false, 0, arrayList);
        new Thread() { // from class: com.dyaco.sole.custom.PostUtil.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws InterruptedException {
                PostDataDB postDataDB = new PostDataDB(context);
                ArrayList<PostData> allPostData = postDataDB.getAllPostData();
                postDataDB.close();
                if (allPostData.size() >= 50) {
                    allPostData = (ArrayList) allPostData.subList(0, 50);
                }
                for (int i = 0; i < allPostData.size() && !PostUtil.isNotNetwork; i++) {
                    try {
                        PostData postData = allPostData.get(i);
                        Log.d(PostUtil.TAG, "上次未上傳的資料    data = " + postData);
                        JSONObject jSONObjectResolveJson = PostUtil.resolveJson(postData.getPostData());
                        Iterator<String> itKeys = jSONObjectResolveJson.keys();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new BasicNameValuePair("post_id", "" + postData.getPostId()));
                        arrayList2.add(new BasicNameValuePair("sys_id", PostUtil.getSysId(context)));
                        arrayList2.add(new BasicNameValuePair("api_key", PostUtil.getApiKey(context)));
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            arrayList2.add(new BasicNameValuePair(next, jSONObjectResolveJson.get(next).toString()));
                        }
                        PostUtil.send2Server(context, true, postData.getPostType(), arrayList2);
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void postWorkoutData(Context context, WorkoutData workoutData) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("enc", "Mjg4NzY0OA=="));
        arrayList.add(new BasicNameValuePair("api_key", getApiKey(context)));
        arrayList.add(new BasicNameValuePair("app_code", "" + Global.BRAND + 1));
        arrayList.add(new BasicNameValuePair("machine_code", String.valueOf(ProtocolHandler.protocol.deviceModel)));
        arrayList.add(new BasicNameValuePair("minutes", String.valueOf(workoutData.getDuration() / 60)));
        arrayList.add(new BasicNameValuePair(WorkoutData.CALORIES, String.valueOf(workoutData.getCalories())));
        arrayList.add(new BasicNameValuePair("distance", String.valueOf(workoutData.getDistance())));
        arrayList.add(new BasicNameValuePair(BaseDataTypes.ID_SPEED, String.valueOf(workoutData.getAvgSpeed())));
        arrayList.add(new BasicNameValuePair("progame_code", String.valueOf(ProtocolHandler.protocol.setProgramMode)));
        arrayList.add(new BasicNameValuePair("machine_time", workoutData.getStartDate().replace(HelpFormatter.DEFAULT_OPT_PREFIX, "/")));
        arrayList.add(new BasicNameValuePair("trigger_date", Global.getDateTime()));
        send2Server(context, false, 1, arrayList);
    }

    public static void postTrackerData(Context context, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("enc", "Mjg4NzY0OA=="));
        arrayList.add(new BasicNameValuePair("api_key", getApiKey(context)));
        arrayList.add(new BasicNameValuePair("item_code", "" + i));
        arrayList.add(new BasicNameValuePair("trigger_date", Global.getDateTime()));
        send2Server(context, false, 2, arrayList);
    }

    public static void postErrorData(Context context, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("enc", "Mjg4NzY0OA=="));
        arrayList.add(new BasicNameValuePair("api_key", getApiKey(context)));
        arrayList.add(new BasicNameValuePair("error_code", "" + i));
        arrayList.add(new BasicNameValuePair("app_code", "" + Global.BRAND + 1));
        arrayList.add(new BasicNameValuePair("machine_code", String.valueOf(ProtocolHandler.protocol.deviceModel)));
        arrayList.add(new BasicNameValuePair("trigger_date", Global.getDateTime()));
        send2Server(context, false, 3, arrayList);
    }

    public static void postConnectData(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("enc", "Mjg4NzY0OA=="));
        arrayList.add(new BasicNameValuePair("api_key", getApiKey(context)));
        arrayList.add(new BasicNameValuePair("machine_code", String.valueOf(ProtocolHandler.protocol.deviceModel)));
        arrayList.add(new BasicNameValuePair("ble_mauip", str));
        arrayList.add(new BasicNameValuePair("trigger_date", Global.getDateTime()));
        send2Server(context, false, 4, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.dyaco.sole.custom.PostUtil$2] */
    public static void send2Server(final Context context, final boolean z, final int i, final List<NameValuePair> list) {
        Log.d(TAG, "send2Server  postType = " + i + " , params = " + list);
        new Thread() { // from class: com.dyaco.sole.custom.PostUtil.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:112:0x020e A[Catch: all -> 0x0231, TRY_ENTER, TRY_LEAVE, TryCatch #11 {all -> 0x0231, blocks: (B:24:0x00a5, B:25:0x00a7, B:27:0x00ae, B:28:0x00b2, B:96:0x01e0, B:98:0x01f1, B:112:0x020e), top: B:152:0x0023 }] */
            /* JADX WARN: Removed duplicated region for block: B:129:0x0235  */
            /* JADX WARN: Removed duplicated region for block: B:153:0x0244 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:162:0x023a A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:179:? A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:98:0x01f1 A[Catch: all -> 0x0231, TRY_LEAVE, TryCatch #11 {all -> 0x0231, blocks: (B:24:0x00a5, B:25:0x00a7, B:27:0x00ae, B:28:0x00b2, B:96:0x01e0, B:98:0x01f1, B:112:0x020e), top: B:152:0x0023 }] */
            /* JADX WARN: Type inference failed for: r0v14, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r0v20, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r0v27 */
            /* JADX WARN: Type inference failed for: r0v28 */
            /* JADX WARN: Type inference failed for: r0v29 */
            /* JADX WARN: Type inference failed for: r0v3 */
            /* JADX WARN: Type inference failed for: r0v30 */
            /* JADX WARN: Type inference failed for: r0v31 */
            /* JADX WARN: Type inference failed for: r0v32 */
            /* JADX WARN: Type inference failed for: r0v7 */
            /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.StringBuilder] */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() throws Throwable {
                ByteArrayOutputStream byteArrayOutputStream;
                OutputStream outputStream;
                UnknownHostException e;
                byte[] bytes;
                int i2 = i;
                String str = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "" : PostUtil.API_GOODS_CON : PostUtil.API_ERROR_INFO : PostUtil.API_USE_ITEM : PostUtil.API_SPORTS_INFO : PostUtil.API_SYS;
                HttpURLConnection httpURLConnection = null;
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                httpURLConnection = null;
                try {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    try {
                        bytes = PostUtil.getRequestData(list, "UTF-8").toString().getBytes();
                        str = (HttpURLConnection) new URL(PostUtil.POST_URL + str).openConnection();
                        try {
                            str.setRequestMethod(HttpPost.METHOD_NAME);
                            str.setConnectTimeout(10000);
                            str.setDoInput(true);
                            str.setDoOutput(true);
                            str.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            str.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                            outputStream = str.getOutputStream();
                        } catch (UnknownHostException e2) {
                            e = e2;
                            outputStream = null;
                            byteArrayOutputStream = null;
                        } catch (Exception e3) {
                            e = e3;
                            outputStream = null;
                            byteArrayOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            outputStream = null;
                            byteArrayOutputStream = null;
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return;
                    }
                } catch (UnknownHostException e5) {
                    outputStream = null;
                    byteArrayOutputStream = null;
                    e = e5;
                    str = 0;
                } catch (Exception e6) {
                    e = e6;
                    outputStream = null;
                    byteArrayOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                    byteArrayOutputStream = null;
                    if (httpURLConnection != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (byteArrayOutputStream == null) {
                    }
                }
                try {
                    outputStream.write(bytes);
                    outputStream.flush();
                    int responseCode = str.getResponseCode();
                    Log.d(PostUtil.TAG, "send2Server  statusCode = " + responseCode);
                    if (responseCode == 200) {
                        InputStream inputStream = str.getInputStream();
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i3 = inputStream.read(bArr);
                                if (i3 == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream.write(bArr, 0, i3);
                                }
                            }
                            String str2 = new String(byteArrayOutputStream.toByteArray());
                            Log.d(PostUtil.TAG, "postType = " + i + " , result = " + str2);
                            boolean unused = PostUtil.isNotNetwork = false;
                            PostUtil.postSuccessProcess(context, z, i, str2, list);
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (UnknownHostException e7) {
                            e = e7;
                            e.printStackTrace();
                            Log.e(PostUtil.TAG, "目前無法上傳資料");
                            if (z) {
                                PostUtil.postFailedProcess(context, i, list);
                                if (str != 0) {
                                    str.disconnect();
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return;
                            }
                            boolean unused2 = PostUtil.isNotNetwork = true;
                            if (str != 0) {
                                str.disconnect();
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                    return;
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                    return;
                                }
                            }
                            return;
                        } catch (Exception e11) {
                            e = e11;
                            httpURLConnection = str;
                            try {
                                e.printStackTrace();
                                PostDataDB postDataDB = new PostDataDB(context);
                                if (!z || !postDataDB.isDataExist(((NameValuePair) list.get(0)).getValue())) {
                                    PostUtil.postFailedProcess(i, "error:" + e);
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (IOException e12) {
                                            e12.printStackTrace();
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    return;
                                }
                                Log.e(PostUtil.TAG, "上次未上傳的資料   錯誤----刪除未上傳資料  post_id = " + ((NameValuePair) list.get(0)).getValue());
                                postDataDB.deletePostData(((NameValuePair) list.get(0)).getValue());
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e13) {
                                        e13.printStackTrace();
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                        return;
                                    } catch (IOException e14) {
                                        e14.printStackTrace();
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th4) {
                                th = th4;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e15) {
                                        e15.printStackTrace();
                                    }
                                }
                                if (byteArrayOutputStream == null) {
                                    throw th;
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                    throw th;
                                }
                            }
                        }
                    } else {
                        PostUtil.postFailedProcess(i, "ErrorStatusCode:" + responseCode);
                    }
                    if (str != 0) {
                        str.disconnect();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                } catch (UnknownHostException e18) {
                    e = e18;
                    byteArrayOutputStream = null;
                    e = e;
                    e.printStackTrace();
                    Log.e(PostUtil.TAG, "目前無法上傳資料");
                    if (z) {
                    }
                } catch (Exception e19) {
                    e = e19;
                    byteArrayOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = null;
                    httpURLConnection = str;
                    if (httpURLConnection != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (byteArrayOutputStream == null) {
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void postSuccessProcess(Context context, boolean z, int i, String str, List<NameValuePair> list) throws JSONException {
        List<Map<String, Object>> listResolveJson = resolveJson(str, null);
        String string = listResolveJson.get(0).get(OAuthConstants.CODE).toString();
        PostDataDB postDataDB = new PostDataDB(context);
        if (z && string.equals("100") && postDataDB.isDataExist(list.get(0).getValue())) {
            Log.d(TAG, "上次未上傳的資料  上傳成功    刪除未上傳資料  post_id = " + list.get(0).getValue());
            postDataDB.deletePostData(list.get(0).getValue());
            postDataDB.close();
            return;
        }
        postDataDB.close();
        if (i != 0) {
            if (i != 1) {
                return;
            }
            if (string.equals("100")) {
                onPostResult(POST_SUCCESSFUL, "event", "success");
                return;
            }
            if ((string.equals("99") && getApiKey(context) == null) || (string.equals("02") && getSysId(context) == null)) {
                insertPostData(context, i, list);
            }
            onPostResult(POST_FAILED, "event", listResolveJson.get(0).get("info") + "");
            return;
        }
        if (string.equals("100")) {
            String string2 = listResolveJson.get(0).get("api_key").toString();
            String string3 = listResolveJson.get(0).get("sys_id").toString();
            SharedPreferences.Editor spfEditor = Global.getSpfEditor(context);
            spfEditor.putString("sys_id", string3);
            spfEditor.putString("api_key", string2);
            spfEditor.commit();
            onPostResult(POST_SUCCESSFUL, POST_TYPE_SYSTEM, "success");
            return;
        }
        if ((string.equals("99") && getApiKey(context) == null) || (string.equals("02") && getSysId(context) == null)) {
            insertPostData(context, i, list);
        }
        onPostResult(POST_FAILED, POST_TYPE_SYSTEM, listResolveJson.get(0).get("info") + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void postFailedProcess(int i, String str) {
        if (i == 0) {
            onPostResult(POST_FAILED, POST_TYPE_SYSTEM, "errorMessage:" + str);
            return;
        }
        if (i != 1) {
            return;
        }
        onPostResult(POST_FAILED, "event", "errorMessage:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void postFailedProcess(Context context, int i, List<NameValuePair> list) throws JSONException {
        insertPostData(context, i, list);
        postFailedProcess(i, "No Network");
    }

    private static void insertPostData(Context context, int i, List<NameValuePair> list) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (int i2 = 0; i2 < list.size(); i2++) {
                jSONObject.put(list.get(i2).getName(), list.get(i2).getValue());
            }
            PostDataDB postDataDB = new PostDataDB(context);
            postDataDB.insertPostData(i, jSONObject.toString());
            postDataDB.close();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getSysId(Context context) {
        return Global.getSharedPreferences(context).getString("sys_id", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getApiKey(Context context) {
        return Global.getSharedPreferences(context).getString("api_key", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StringBuffer getRequestData(List<NameValuePair> list, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (NameValuePair nameValuePair : list) {
            String name = nameValuePair.getName();
            String value = nameValuePair.getValue();
            if (name != null && value != null && name.length() != 0 && value.length() != 0) {
                try {
                    stringBuffer.append(name);
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(value, str));
                    stringBuffer.append("&");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        deleteEndWord(stringBuffer, "&");
        return stringBuffer;
    }

    private static void deleteEndWord(StringBuffer stringBuffer, String str) {
        int length = stringBuffer.length();
        if (length == 0) {
            return;
        }
        int i = length - 1;
        if (str.equals(stringBuffer.substring(i, length))) {
            stringBuffer.delete(i, length);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject resolveJson(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<Map<String, Object>> resolveJson(String str, String str2) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (str == null || str.equals("")) {
            arrayList.add(new HashMap());
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = null;
            if (str2 != null && !str2.equals("")) {
                try {
                    jSONArray = jSONObject.getJSONArray(str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i));
                    Iterator<String> itKeys = jSONObject2.keys();
                    HashMap map = new HashMap();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObject2.get(next).toString());
                    }
                    arrayList.add(map);
                }
            } else {
                Iterator<String> itKeys2 = jSONObject.keys();
                HashMap map2 = new HashMap();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    map2.put(next2, jSONObject.get(next2).toString());
                }
                arrayList.add(map2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }
}
