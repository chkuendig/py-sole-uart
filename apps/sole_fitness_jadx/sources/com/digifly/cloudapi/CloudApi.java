package com.digifly.cloudapi;

import android.content.Context;
import android.util.Log;
import com.digifly.cloudapi.data.DCConnectInfoData;
import com.digifly.cloudapi.data.DCLoginInfoData;
import com.digifly.cloudapi.data.DCProgramGoalData;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.DCTrainingDetailData;
import com.digifly.cloudapi.data.DLUploadErrorCodeData;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.ResponseDataCollection;
import com.digifly.cloudapi.data.ResponseDataGet;
import com.digifly.cloudapi.data.ResponseDetailDataGet;
import com.digifly.cloudapi.data.ResponseGoalDataGet;
import com.digifly.cloudapi.data.ResponseMember;
import com.digifly.cloudapi.data.ResponseMessage;
import com.digifly.cloudapi.data.ResponseMessagePush;
import com.digifly.cloudapi.listener.DCConnectInfoListener;
import com.digifly.cloudapi.listener.DCGetTrainingDataListener;
import com.digifly.cloudapi.listener.DCGetTrainingDetailDataListener;
import com.digifly.cloudapi.listener.DCGoalDeltetListener;
import com.digifly.cloudapi.listener.DCGoalGetListener;
import com.digifly.cloudapi.listener.DCGoalUploadUpdateListener;
import com.digifly.cloudapi.listener.DCLoginInfoListener;
import com.digifly.cloudapi.listener.DCUploadTrainingDataListener;
import com.digifly.cloudapi.listener.DCUploadTrainingDetailDataListener;
import com.digifly.cloudapi.listener.DLUploadErrorCodeListener;
import com.digifly.cloudapi.listener.GetPushMessageListener;
import com.digifly.cloudapi.listener.MemberChangeLangCodeListener;
import com.digifly.cloudapi.listener.MemberCheckAccountListener;
import com.digifly.cloudapi.listener.MemberForgetPasswordListener;
import com.digifly.cloudapi.listener.MemberLoginListener;
import com.digifly.cloudapi.listener.MemberRegistListener;
import com.digifly.cloudapi.listener.MemberRegistUpdateListener;
import com.digifly.cloudapi.listener.ReadPushMessageListener;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.database.MessageDB;
import com.dyaco.sole.database.UserData;
import com.dyaco.sole.database.WorkoutData;
import com.google.gson.Gson;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* loaded from: classes.dex */
public class CloudApi {
    public static final String CLOUD_URL_CHANGE_LANG_CODE = "https://cloud.dyaco.com/api/Member/ChangeLangCode";
    private static final String CLOUD_URL_CHECK_ACCOUNT = "https://cloud.dyaco.com/api/Member/CheckAccount";
    private static final String CLOUD_URL_CONECT_INFO = "https://cloud.dyaco.com/api/DeviceDC/ConnectInfo";
    private static final String CLOUD_URL_FORGET_PASSWORD = "https://cloud.dyaco.com/api/Member/ForgetPassword";
    public static final String CLOUD_URL_GET_PUSH_MESSAGE = "https://cloud.dyaco.com/api/Member/GetPushMessage";
    private static final String CLOUD_URL_GET_TRAINING_DATA = "https://cloud.dyaco.com/api/TrainingDC/GetTrainingData";
    private static final String CLOUD_URL_GET_TRAINING_DETAIL_DATA = "https://cloud.dyaco.com/api/TrainingDC/GetTrainingDetailData";
    public static final String CLOUD_URL_GOAL_DELETE = "https://cloud.dyaco.com/api/TrainingDC/DeleteUserGoal";
    public static final String CLOUD_URL_GOAL_GET = "https://cloud.dyaco.com/api/TrainingDC/GetUserGoal";
    public static final String CLOUD_URL_GOAL_UPLOAD_UPDATE = "https://cloud.dyaco.com/api/TrainingDC/UploadGoal";
    private static final String CLOUD_URL_LOGIN = "https://cloud.dyaco.com/api/Member/Login";
    private static final String CLOUD_URL_LOGIN_INFO = "https://cloud.dyaco.com/api/MemberDC/LoginInfo";
    public static final String CLOUD_URL_READ_PUSH_MESSAGE = "https://cloud.dyaco.com/api/Member/ReadPushMessage";
    private static final String CLOUD_URL_REGIST = "https://cloud.dyaco.com/api/Member/Regist";
    private static final String CLOUD_URL_REGIST_UPDATE = "https://cloud.dyaco.com/api/Member/RegistUpdate";
    public static final String CLOUD_URL_SYNC_ADD_SYNCE_DEVICE = "https://cloud.dyaco.com/api/Member/Sync_AddSynceDevice";
    public static final String CLOUD_URL_UPLOAD_ERROR_CODE = "https://cloud.dyaco.com/api/DeviceLog/UploadErrorCode";
    public static final String CLOUD_URL_UPLOAD_NOTICE_TOKEN = "https://cloud.dyaco.com/api/MemberDC/UploadNoticeToken";
    private static final String CLOUD_URL_UPLOAD_TRAINING_DATA = "https://cloud.dyaco.com/api/TrainingDC/UploadTrainingData";
    private static final String CLOUD_URL_UPLOAD_TRAINING_DETAIL_DATA = "https://cloud.dyaco.com/api/TrainingDC/UploadTrainingDetailData";
    public static final String SERVER_DNS = "cloud.dyaco.com";
    private static final String TAG = "CloudApi";
    private static volatile CloudApi cloudApi;
    private String api_key;
    private Call call;
    private MemberCheckAccountListener checkAccountListener;
    private DCConnectInfoListener dcConnectInfoListener;
    private DCGetTrainingDataListener dcGetTrainingDataListener;
    private DCGetTrainingDetailDataListener dcGetTrainingDetailDataListener;
    private DCLoginInfoListener dcLoginInfoListener;
    private DCUploadTrainingDataListener dcUploadTrainingDataListener;
    private DCUploadTrainingDetailDataListener dcUploadTrainingDetailDataListener;
    private DLUploadErrorCodeListener dlUploadErrorCodeListener;
    private GetPushMessageListener getPushMessageListener;
    private DCGoalDeltetListener goalDeleteListener;
    private DCGoalGetListener goalGetListener;
    private DCGoalUploadUpdateListener goalUploadUpdateListener;
    private Gson gson = new Gson();
    private MemberChangeLangCodeListener memberChangeLangCodeListener;
    private MemberForgetPasswordListener memberForgetPasswordListener;
    private MemberLoginListener memberLoginListener;
    private MemberRegistListener memberRegistListener;
    private MemberRegistUpdateListener memberRegistUpdateListener;
    private OkHttpClient okHttpClient;
    private Request request;
    private RequestBody requestBody;

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

    private CloudApi(Context context) {
        this.okHttpClient = new OkHttpClient();
        this.okHttpClient = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).build();
    }

    public static CloudApi getInstance(Context context) {
        if (cloudApi == null) {
            synchronized (CloudApi.class) {
                if (cloudApi == null) {
                    cloudApi = new CloudApi(context);
                }
            }
        }
        return cloudApi;
    }

    public static CloudApi createInstance(Context context) {
        return new CloudApi(context);
    }

    public void setMemberRegistListener(MemberRegistListener memberRegistListener) {
        this.memberRegistListener = memberRegistListener;
    }

    public void callMemberRegist(MemberData memberData) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, memberData.getAccount()).add("password", memberData.getPassword()).add("name", memberData.getName()).add("email", memberData.getEmail()).add("sex", memberData.getSex()).add("height", String.valueOf(memberData.getHeight())).add(UserData.WEIGHT, String.valueOf(memberData.getWeight())).add("birthday", memberData.getBirthday()).add("regist_type", memberData.getRegist_type()).add("unit_type", memberData.getUnit_type()).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_REGIST).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.memberRegistListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                Log.d("ddd", strString);
                ResponseMember responseMemberData = JsonUtil.parseResponseMemberData(strString);
                if (responseMemberData == null) {
                    Log.d("", "member data format err");
                } else if (responseMemberData.isSuccess()) {
                    CloudApi.this.memberRegistListener.onSuccess(responseMemberData.getSys_response_data());
                } else {
                    responseMemberData.getSys_response_message().getMessage();
                    CloudApi.this.memberRegistListener.onFail(responseMemberData.getSys_response_message());
                }
            }
        });
    }

    public void setMemberLoginListener(MemberLoginListener memberLoginListener) {
        this.memberLoginListener = memberLoginListener;
    }

    public void callMemberLogin(String str, String str2, String str3) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, str).add("password", str2).add("regist_type", str3).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_LOGIN).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.memberLoginListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                Log.d("response", "resp==>" + strString);
                try {
                    ResponseMember responseMemberData = JsonUtil.parseResponseMemberData(strString);
                    if (responseMemberData.isSuccess()) {
                        CloudApi.this.memberLoginListener.onSuccess(responseMemberData.getSys_response_data());
                    } else {
                        responseMemberData.getSys_response_message().getMessage();
                        CloudApi.this.memberLoginListener.onFail(responseMemberData.getSys_response_message());
                    }
                } catch (Exception e) {
                    CloudApi.this.memberLoginListener.onError(e.getMessage());
                }
            }
        });
    }

    public void setMemberForgetPassword(MemberForgetPasswordListener memberForgetPasswordListener) {
        this.memberForgetPasswordListener = memberForgetPasswordListener;
    }

    public void callMemberForgetPasswordListener(String str) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, str).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_FORGET_PASSWORD).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.memberForgetPasswordListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseMember responseMemberData = JsonUtil.parseResponseMemberData(response.body().string());
                if (responseMemberData.isSuccess()) {
                    CloudApi.this.memberForgetPasswordListener.onSuccess(responseMemberData.getSys_response_message());
                } else {
                    responseMemberData.getSys_response_message().getMessage();
                    CloudApi.this.memberForgetPasswordListener.onFail(responseMemberData.getSys_response_message());
                }
            }
        });
    }

    public void setMemberRegistUpdateListener(MemberRegistUpdateListener memberRegistUpdateListener) {
        this.memberRegistUpdateListener = memberRegistUpdateListener;
    }

    public void callMemberRegistUpdate(MemberData memberData) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, memberData.getAccount()).add("password", memberData.getPassword()).add("name", memberData.getName()).add("email", memberData.getEmail()).add("sex", memberData.getSex()).add("height", String.valueOf(memberData.getHeight())).add(UserData.WEIGHT, String.valueOf(memberData.getWeight())).add("birthday", memberData.getBirthday()).add("regist_type", memberData.getRegist_type()).add("unit_type", memberData.getUnit_type()).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_REGIST_UPDATE).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.4
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.memberRegistUpdateListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseMember responseMemberData = JsonUtil.parseResponseMemberData(response.body().string());
                if (responseMemberData.isSuccess()) {
                    CloudApi.this.memberRegistUpdateListener.onSuccess(responseMemberData.getSys_response_data());
                } else {
                    responseMemberData.getSys_response_message().getMessage();
                    CloudApi.this.memberRegistUpdateListener.onFail(responseMemberData.getSys_response_message());
                }
            }
        });
    }

    public void setCheckAccountListener(MemberCheckAccountListener memberCheckAccountListener) {
        this.checkAccountListener = memberCheckAccountListener;
    }

    public void callCheckAccount(String str) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, str).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_CHECK_ACCOUNT).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.5
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.checkAccountListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseMember responseMemberData = JsonUtil.parseResponseMemberData(response.body().string());
                if (responseMemberData.isSuccess()) {
                    CloudApi.this.checkAccountListener.onSuccess(responseMemberData.getSys_response_message());
                } else {
                    responseMemberData.getSys_response_message().getMessage();
                    CloudApi.this.checkAccountListener.onFail(responseMemberData.getSys_response_message());
                }
            }
        });
    }

    public void setDCLoginInfoListener(DCLoginInfoListener dCLoginInfoListener) {
        this.dcLoginInfoListener = dCLoginInfoListener;
    }

    public void callDCLoginInfo(DCLoginInfoData dCLoginInfoData) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, dCLoginInfoData.getAccount()).add("password", dCLoginInfoData.getPassword()).add("login_model_code", dCLoginInfoData.getLogin_model_code()).add("login_time", dCLoginInfoData.getLogin_time()).add("login_timezone_hour", String.valueOf(dCLoginInfoData.getLogin_timezone_hour())).add("login_timezone_name", dCLoginInfoData.getLogin_timezone_name()).add("device_os_name", dCLoginInfoData.getDevice_os_name()).add("device_os_version", dCLoginInfoData.getDevice_os_version()).add("device_model", dCLoginInfoData.getDevice_model()).add("device_sno", dCLoginInfoData.getDevice_sno()).add("device_gps_lat", String.valueOf(dCLoginInfoData.getDevice_gps_lat())).add("device_gps_lng", String.valueOf(dCLoginInfoData.getDevice_gps_lng())).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_LOGIN_INFO).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.6
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.dcLoginInfoListener.onError(iOException.toString());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseDataCollection responseDataCollection = JsonUtil.parseResponseDataCollection(response.body().string());
                if (responseDataCollection.isSuccess()) {
                    CloudApi.this.dcLoginInfoListener.onSuccess(responseDataCollection);
                } else {
                    responseDataCollection.getSys_response_message().getMessage();
                    CloudApi.this.dcLoginInfoListener.onFail(responseDataCollection);
                }
            }
        });
    }

    public void setDCConnectInfoListener(DCConnectInfoListener dCConnectInfoListener) {
        this.dcConnectInfoListener = dCConnectInfoListener;
    }

    public void callDCConnectInfo(DCConnectInfoData dCConnectInfoData) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, dCConnectInfoData.getAccount()).add("password", dCConnectInfoData.getPassword()).add("connect_time", dCConnectInfoData.getConnect_time()).add("connect_timezone_hour", String.valueOf(dCConnectInfoData.getConnect_timezone_hour())).add("connect_timezone_name", dCConnectInfoData.getConnect_timezone_name()).add("brand_code", dCConnectInfoData.getBrand_code()).add("brand_type", dCConnectInfoData.getBrand_type()).add("model_code", dCConnectInfoData.getModel_code()).add("category_code", dCConnectInfoData.getCategory_code()).add("mac_address", dCConnectInfoData.getMac_address()).add("sales_version", dCConnectInfoData.getSales_version()).add("unit", dCConnectInfoData.getUnit()).add("device_os_name", dCConnectInfoData.getDevice_os_name()).add("device_os_version", dCConnectInfoData.getDevice_os_version()).add("device_model", dCConnectInfoData.getDevice_model()).add("device_sno", dCConnectInfoData.getDevice_sno()).add("device_gps_lat", String.valueOf(dCConnectInfoData.getDevice_gps_lat())).add("device_gps_lng", String.valueOf(dCConnectInfoData.getDevice_gps_lng())).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_CONECT_INFO).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.7
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.dcConnectInfoListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                ResponseDataCollection responseDataCollection = JsonUtil.parseResponseDataCollection(strString);
                Log.d("ddd", strString);
                if (responseDataCollection.isSuccess()) {
                    CloudApi.this.dcConnectInfoListener.onSuccess(responseDataCollection);
                } else {
                    responseDataCollection.getSys_response_message().getMessage();
                    CloudApi.this.dcConnectInfoListener.onFail(responseDataCollection);
                }
            }
        });
    }

    public void setDCUploadTrainingDataListener(DCUploadTrainingDataListener dCUploadTrainingDataListener) {
        this.dcUploadTrainingDataListener = dCUploadTrainingDataListener;
    }

    public void callDCUploadTrainingData(DCTrainingData dCTrainingData) {
        if (dCTrainingData.getModel_code() != null && dCTrainingData.getBrand_code().equals("garmin")) {
            Log.d(TAG, "Garmin data");
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT);
        Log.d("", "sdf.format(data.getTraning_datetime()) = " + simpleDateFormat.format(dCTrainingData.getTraining_datetime()));
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, dCTrainingData.getAccount()).add("password", dCTrainingData.getPassword()).add("training_datetime", simpleDateFormat.format(dCTrainingData.getTraining_datetime())).add("training_timezone_hour", String.valueOf(dCTrainingData.getTraining_timezone_hour())).add("training_timezone_name", dCTrainingData.getTraining_timezone_name()).add("brand_code", dCTrainingData.getBrand_code()).add("model_code", dCTrainingData.getModel_code()).add("category_code", dCTrainingData.getCategory_code()).add("brand_type", dCTrainingData.getBrand_type()).add("in_out", dCTrainingData.getIn_out()).add("unit", dCTrainingData.getUnit()).add("sales_version", dCTrainingData.getSales_version()).add("program_name", dCTrainingData.getProgram_name()).add("total_time", String.valueOf(dCTrainingData.getTotal_time())).add("total_distance", String.valueOf(dCTrainingData.getTotal_distance())).add("total_calories", String.valueOf(dCTrainingData.getTotal_calories())).add(WorkoutData.AVG_HR, String.valueOf(dCTrainingData.getAvg_hr())).add(WorkoutData.AVG_RPM, String.valueOf(dCTrainingData.getAvg_rpm())).add(WorkoutData.AVG_SPEED, String.valueOf(dCTrainingData.getAvg_speed())).add("avg_watt", String.valueOf(dCTrainingData.getAvg_watt())).add("avg_met", String.valueOf(dCTrainingData.getAvg_met())).add(WorkoutData.AVG_LEVEL, String.valueOf(dCTrainingData.getAvg_level())).add("avg_incline", String.valueOf(dCTrainingData.getAvg_incline())).add("device_os_name", dCTrainingData.getDevice_os_name()).add("device_os_version", dCTrainingData.getDevice_os_version()).add("device_model", dCTrainingData.getDevice_model()).add("device_sno", dCTrainingData.getDevice_sno()).add("device_gps_lat", String.valueOf(dCTrainingData.getDevice_gps_lat())).add("device_gps_lng", String.valueOf(dCTrainingData.getDevice_gps_lng())).add("mac_address", dCTrainingData.getMac_address()).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_UPLOAD_TRAINING_DATA).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.8
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.dcUploadTrainingDataListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                Log.d("ddd", strString);
                ResponseDataCollection responseDataCollection = JsonUtil.parseResponseDataCollection(strString);
                if (responseDataCollection.isSuccess()) {
                    CloudApi.this.dcUploadTrainingDataListener.onSuccess(responseDataCollection);
                } else {
                    responseDataCollection.getSys_response_message().getMessage();
                    CloudApi.this.dcUploadTrainingDataListener.onFail(responseDataCollection);
                }
            }
        });
    }

    public void setDCUploadTrainingDetailDataListener(DCUploadTrainingDetailDataListener dCUploadTrainingDetailDataListener) {
        this.dcUploadTrainingDetailDataListener = dCUploadTrainingDetailDataListener;
    }

    public void callDCUploadTrainingDetailData(DCTrainingDetailData dCTrainingDetailData) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, dCTrainingDetailData.getAccount()).add("password", dCTrainingDetailData.getPassword()).add("training_datetime", simpleDateFormat.format(dCTrainingDetailData.getTraning_datetime())).add("trainh_no", dCTrainingDetailData.getTrainh_no()).add("d_time", String.valueOf(dCTrainingDetailData.getD_time())).add("d_distance", String.valueOf(dCTrainingDetailData.getD_distance())).add("d_calories", String.valueOf(dCTrainingDetailData.getD_calories())).add("d_hr", String.valueOf(dCTrainingDetailData.getD_hr())).add("d_rpm", String.valueOf(dCTrainingDetailData.getD_rpm())).add("d_speed", String.valueOf(dCTrainingDetailData.getD_speed())).add("d_watt", String.valueOf(dCTrainingDetailData.getD_watt())).add("d_met", String.valueOf(dCTrainingDetailData.getD_met())).add("d_level", String.valueOf(dCTrainingDetailData.getD_level())).add("d_incline", String.valueOf(dCTrainingDetailData.getD_incline())).add("d_heart_rate_type", String.valueOf(dCTrainingDetailData.getD_heart_rate_type())).add("d_fusion_interval_time", String.valueOf(dCTrainingDetailData.getD_fusion_interval_time())).add("d_fusion_recovery_time", String.valueOf(dCTrainingDetailData.getD_fusion_recovery_time())).add("d_program_row", String.valueOf(dCTrainingDetailData.getD_program_row())).add("d_program_height", String.valueOf(dCTrainingDetailData.getD_program_height())).add("d_program_level", String.valueOf(dCTrainingDetailData.getD_program_level())).add("d_program_total_step", String.valueOf(dCTrainingDetailData.getD_program_total_step())).add("d_program_per_step", String.valueOf(dCTrainingDetailData.getD_program_per_step())).add("d_program_vert", String.valueOf(dCTrainingDetailData.getD_program_vert())).add("d_program_step_height", String.valueOf(dCTrainingDetailData.getD_program_step_height())).add("device_gps_lat", String.valueOf(dCTrainingDetailData.getDevice_gps_lat())).add("device_gps_lng", String.valueOf(dCTrainingDetailData.getDevice_gps_lng())).build();
        Log.e("CloudApi", "account : " + dCTrainingDetailData.getAccount() + "\npassword : " + dCTrainingDetailData.getPassword() + "\ntraning_time : " + simpleDateFormat.format(dCTrainingDetailData.getTraning_datetime()) + "\ntraning_no : " + dCTrainingDetailData.getTrainh_no() + "\ndata_D_time : " + String.valueOf(dCTrainingDetailData.getD_time()) + "\ndistance : " + String.valueOf(dCTrainingDetailData.getD_distance()) + "\ncalories : " + String.valueOf(dCTrainingDetailData.getD_calories()) + "\nhr : " + String.valueOf(dCTrainingDetailData.getD_hr()) + "\nrpm : " + String.valueOf(dCTrainingDetailData.getD_rpm()) + "\nspeed : " + String.valueOf(dCTrainingDetailData.getD_speed()) + "\nwatt : " + String.valueOf(dCTrainingDetailData.getD_watt()) + "\nmet : " + String.valueOf(dCTrainingDetailData.getD_met()) + "\nlevel : " + String.valueOf(dCTrainingDetailData.getD_level()) + "\nincline : " + String.valueOf(dCTrainingDetailData.getD_incline()) + "\nrate_type : " + String.valueOf(dCTrainingDetailData.getD_heart_rate_type()) + "\ninterval_time : " + String.valueOf(dCTrainingDetailData.getD_fusion_interval_time()) + "\nrecovery_time : " + String.valueOf(dCTrainingDetailData.getD_fusion_recovery_time()) + "\nprogram_row : " + String.valueOf(dCTrainingDetailData.getD_program_row()) + "\nprogram_height : " + String.valueOf(dCTrainingDetailData.getD_program_height()) + "\nprogram_level : " + String.valueOf(dCTrainingDetailData.getD_program_level()) + "\nprogram_total : " + String.valueOf(dCTrainingDetailData.getD_program_total_step()) + "\nprogram_per : " + String.valueOf(dCTrainingDetailData.getD_program_per_step()) + "\nprogram_vert : " + String.valueOf(dCTrainingDetailData.getD_program_vert()) + "\nprogram_step_height : " + String.valueOf(dCTrainingDetailData.getD_program_step_height()) + "\ndevice_gps_lat : " + String.valueOf(dCTrainingDetailData.getDevice_gps_lat()) + "\ndevice_pgs_lng : " + String.valueOf(dCTrainingDetailData.getDevice_gps_lng()));
        Request requestBuild = new Request.Builder().url(CLOUD_URL_UPLOAD_TRAINING_DETAIL_DATA).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.9
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (iOException == null || iOException.toString() == null || iOException.toString().length() <= 0) {
                    CloudApi.this.dcUploadTrainingDetailDataListener.onError("Internet Error");
                } else {
                    CloudApi.this.dcUploadTrainingDetailDataListener.onError(iOException.toString());
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                Log.d("ddd", strString);
                ResponseDataCollection responseDataCollection = JsonUtil.parseResponseDataCollection(strString);
                if (responseDataCollection.isSuccess()) {
                    CloudApi.this.dcUploadTrainingDetailDataListener.onSuccess(responseDataCollection);
                } else {
                    responseDataCollection.getSys_response_message().getMessage();
                    CloudApi.this.dcUploadTrainingDetailDataListener.onFail(responseDataCollection);
                }
            }
        });
    }

    public void setDCGetTrainingDataListener(DCGetTrainingDataListener dCGetTrainingDataListener) {
        this.dcGetTrainingDataListener = dCGetTrainingDataListener;
    }

    public void callDCGetTrainingData(String str, String str2, String str3) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, str).add("password", str2).add("training_datetime", str3).build();
        this.request = new Request.Builder().url(CLOUD_URL_GET_TRAINING_DATA).post(this.requestBody).build();
        Log.d(TAG, "post -> request=" + this.request.toString() + "\nBody=" + bodyToString(this.request));
        Call callNewCall = this.okHttpClient.newCall(this.request);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.10
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e(CloudApi.TAG, "GetTrainingData -> onFailure e=" + iOException);
                CloudApi.this.dcGetTrainingDataListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                Log.d(CloudApi.TAG, "GetTrainingData -> onResponse strResponse=" + strString);
                ResponseDataGet responseDataGet = JsonUtil.parseResponseDataGet(strString);
                if (responseDataGet == null) {
                    return;
                }
                if (responseDataGet.isSuccess()) {
                    CloudApi.this.dcGetTrainingDataListener.onSuccess(responseDataGet.getSys_response_data());
                } else {
                    CloudApi.this.dcGetTrainingDataListener.onFail(responseDataGet);
                }
            }
        });
    }

    public void setDCGetTrainingDetailDataListener(DCGetTrainingDetailDataListener dCGetTrainingDetailDataListener) {
        this.dcGetTrainingDetailDataListener = dCGetTrainingDetailDataListener;
    }

    public void callDCGetTrainingDetailData(String str, String str2, String str3) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, str).add("password", str2).add("training_datetime", str3).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_GET_TRAINING_DETAIL_DATA).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.11
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.dcGetTrainingDetailDataListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseDetailDataGet responseDetailDataGet = JsonUtil.parseResponseDetailDataGet(response.body().string());
                if (responseDetailDataGet.isSuccess()) {
                    CloudApi.this.dcGetTrainingDetailDataListener.onSuccess(responseDetailDataGet.getSys_response_data());
                } else {
                    CloudApi.this.dcGetTrainingDetailDataListener.onFail(responseDetailDataGet);
                }
            }
        });
    }

    public void setGoalUploadUpdateListener(DCGoalUploadUpdateListener dCGoalUploadUpdateListener) {
        this.goalUploadUpdateListener = dCGoalUploadUpdateListener;
    }

    public void callGoalUploadUpdate(DCProgramGoalData dCProgramGoalData, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CalendarUtils.SQL_DATE_FORMAT);
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, dCProgramGoalData.getAccount()).add("password", str).add("goal_name", dCProgramGoalData.getGoal_name()).add("goal_duration", String.valueOf(dCProgramGoalData.getGoal_duration())).add("goal_duration_range", String.valueOf(dCProgramGoalData.getGoal_period_type())).add("goal_starttime", String.valueOf(simpleDateFormat.format(dCProgramGoalData.getGoal_start_date()))).add("goal_endtime", String.valueOf(simpleDateFormat.format(dCProgramGoalData.getGoal_end_date()))).add("goal_type", String.valueOf(dCProgramGoalData.getGoal_type())).add("goal_type_value", String.valueOf(dCProgramGoalData.getGoal_val())).add("goal_staturs", String.valueOf(dCProgramGoalData.getGoal_state())).add("goal_no", dCProgramGoalData.getGoal_no()).add("goal_finish_day", String.valueOf(dCProgramGoalData.getElapsedays())).add("goal_finish_value", String.valueOf(dCProgramGoalData.getGoal_val_now())).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_GOAL_UPLOAD_UPDATE).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.12
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.goalUploadUpdateListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                Log.d("ddd", strString);
                ResponseDataCollection responseDataCollection = JsonUtil.parseResponseDataCollection(strString);
                if (responseDataCollection.isSuccess()) {
                    CloudApi.this.goalUploadUpdateListener.onSuccess(responseDataCollection);
                } else {
                    responseDataCollection.getSys_response_message().getMessage();
                    CloudApi.this.goalUploadUpdateListener.onFail(responseDataCollection);
                }
            }
        });
    }

    public void setGoalGetListener(DCGoalGetListener dCGoalGetListener) {
        this.goalGetListener = dCGoalGetListener;
    }

    public void callGoalGet(String str, String str2) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, str).add("password", str2).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_GOAL_GET).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.13
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.goalGetListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                Log.d("ddd", strString);
                ResponseGoalDataGet responseGoalDataGet = JsonUtil.parseResponseGoalDataGet(strString);
                if (responseGoalDataGet.isSuccess()) {
                    CloudApi.this.goalGetListener.onSuccess(responseGoalDataGet.getSys_response_data());
                } else {
                    responseGoalDataGet.getSys_response_message().getMessage();
                    CloudApi.this.goalGetListener.onFail(responseGoalDataGet.getSys_response_message());
                }
            }
        });
    }

    public void setGoalDeleteListener(DCGoalDeltetListener dCGoalDeltetListener) {
        this.goalDeleteListener = dCGoalDeltetListener;
    }

    public void callGoalDelete(String str, String str2, String str3) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, str).add("password", str2).add("goal_no", str3).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_GOAL_DELETE).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.14
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.goalDeleteListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseDataCollection responseDataCollection = JsonUtil.parseResponseDataCollection(response.body().string());
                if (responseDataCollection.isSuccess()) {
                    CloudApi.this.goalDeleteListener.onSuccess(responseDataCollection.getSys_response_message());
                } else {
                    responseDataCollection.getSys_response_message().getMessage();
                    CloudApi.this.goalDeleteListener.onFail(responseDataCollection.getSys_response_message());
                }
            }
        });
    }

    public void setMemberChangeLangCodeListener(MemberChangeLangCodeListener memberChangeLangCodeListener) {
        this.memberChangeLangCodeListener = memberChangeLangCodeListener;
    }

    public void callMemberChangeLangCode(String str, String str2, String str3) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, str).add("password", str2).add("lang_code", str3).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_CHANGE_LANG_CODE).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.15
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.memberChangeLangCodeListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseDataCollection responseDataCollection = JsonUtil.parseResponseDataCollection(response.body().string());
                if (responseDataCollection.isSuccess()) {
                    CloudApi.this.memberChangeLangCodeListener.onSuccess(responseDataCollection.getSys_response_message());
                } else {
                    responseDataCollection.getSys_response_message().getMessage();
                    CloudApi.this.memberChangeLangCodeListener.onFail(responseDataCollection.getSys_response_message());
                }
            }
        });
    }

    public void setUploadErrorCodeListener(DLUploadErrorCodeListener dLUploadErrorCodeListener) {
        this.dlUploadErrorCodeListener = dLUploadErrorCodeListener;
    }

    public void callUploadErrorCode(DLUploadErrorCodeData dLUploadErrorCodeData) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, dLUploadErrorCodeData.getAccount()).add("password", dLUploadErrorCodeData.getPassword()).add("err_time", dLUploadErrorCodeData.getErr_time()).add("err_timezone_hour", String.valueOf(dLUploadErrorCodeData.getErr_timezone_hour())).add("err_timezone_name", dLUploadErrorCodeData.getErr_timezone_name()).add("con_macaddress", dLUploadErrorCodeData.getCon_macaddress()).add("err_code", dLUploadErrorCodeData.getErr_code()).add("con_brand", dLUploadErrorCodeData.getCon_brand()).add("brand_type", dLUploadErrorCodeData.getBrand_type()).add("con_categorycode", dLUploadErrorCodeData.getCon_categorycode()).add("con_modelcode", dLUploadErrorCodeData.getCon_modelcode()).add("con_unit", dLUploadErrorCodeData.getCon_unit()).add("con_saleversion", dLUploadErrorCodeData.getCon_saleversion()).add("device_os", dLUploadErrorCodeData.getDevice_os()).add("device_os_version", dLUploadErrorCodeData.getDevice_os_version()).add("device_model", dLUploadErrorCodeData.getDevice_model()).add("device_sno", dLUploadErrorCodeData.getDevice_sno()).add("device_gps_lat", String.valueOf(dLUploadErrorCodeData.getDevice_gps_lat())).add("device_gps_lng", String.valueOf(dLUploadErrorCodeData.getDevice_gps_lng())).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_UPLOAD_ERROR_CODE).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.16
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.dlUploadErrorCodeListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                Log.d("callUploadErrorCode", "strResponse = " + strString);
                ResponseDataCollection responseDataCollection = JsonUtil.parseResponseDataCollection(strString);
                if (responseDataCollection != null) {
                    if (responseDataCollection.isSuccess()) {
                        CloudApi.this.dlUploadErrorCodeListener.onSuccess(responseDataCollection.getSys_response_message());
                        return;
                    } else {
                        CloudApi.this.dlUploadErrorCodeListener.onFail(responseDataCollection.getSys_response_message());
                        return;
                    }
                }
                ResponseMessage responseMessage = new ResponseMessage();
                responseMessage.setMessage(strString);
                CloudApi.this.dlUploadErrorCodeListener.onFail(responseMessage);
            }
        });
    }

    public void setGetPushMessageListener(GetPushMessageListener getPushMessageListener) {
        this.getPushMessageListener = getPushMessageListener;
    }

    public void callMessagePull(String str, String str2) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, str).add("password", str2).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_GET_PUSH_MESSAGE).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.17
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CloudApi.this.getPushMessageListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                Log.d("", "strResponse = " + strString);
                ResponseMessagePush responseMessagePush = JsonUtil.parseResponseMessagePush(strString);
                if (responseMessagePush.isSuccess()) {
                    CloudApi.this.getPushMessageListener.onSuccess(responseMessagePush);
                } else {
                    CloudApi.this.getPushMessageListener.onFail(responseMessagePush);
                }
            }
        });
    }

    public void callReadPushMessage(String str, String str2, String str3, final ReadPushMessageListener readPushMessageListener) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, str).add("password", str2).add("message_no", str3).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_READ_PUSH_MESSAGE).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.digifly.cloudapi.CloudApi.18
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                readPushMessageListener.onError(iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                Log.d("", "strResponse = " + strString);
                ResponseDataCollection responseDataCollection = JsonUtil.parseResponseDataCollection(strString);
                if (responseDataCollection.isSuccess()) {
                    readPushMessageListener.onSuccess(responseDataCollection);
                } else {
                    readPushMessageListener.onFail(responseDataCollection);
                }
            }
        });
    }

    public void callSyncAddSynceDevice(String str, String str2, Callback callback) {
        this.requestBody = new FormBody.Builder().add(MessageDB.ACCOUNT, str).add("device_id", str2).build();
        Request requestBuild = new Request.Builder().url(CLOUD_URL_SYNC_ADD_SYNCE_DEVICE).post(this.requestBody).build();
        this.request = requestBuild;
        Call callNewCall = this.okHttpClient.newCall(requestBuild);
        this.call = callNewCall;
        callNewCall.enqueue(callback);
    }
}
