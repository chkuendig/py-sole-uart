package com.digifly.cloudapi;

import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.ResponseDataCollection;
import com.digifly.cloudapi.data.ResponseDataGet;
import com.digifly.cloudapi.data.ResponseDetailDataGet;
import com.digifly.cloudapi.data.ResponseGoalDataGet;
import com.digifly.cloudapi.data.ResponseMember;
import com.digifly.cloudapi.data.ResponseMessagePush;
import com.digifly.data.MemberData2;
import com.dyaco.sole.custom.CalendarUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class JsonUtil {
    public static ResponseMember parseResponseMemberData(String str) {
        String json;
        float f;
        try {
            MemberData2 memberData2 = (MemberData2) new Gson().fromJson(str, MemberData2.class);
            if (memberData2 != null && memberData2.getSys_response_data() != null) {
                float f2 = 0.0f;
                try {
                    f = Float.parseFloat(memberData2.getSys_response_data().getHeight());
                } catch (Exception e) {
                    e.printStackTrace();
                    f = 0.0f;
                }
                try {
                    f2 = Float.parseFloat(memberData2.getSys_response_data().getWeight());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                memberData2.getSys_response_data().setWeight(String.valueOf((int) f2));
                memberData2.getSys_response_data().setHeight(String.valueOf((int) f));
            }
            try {
                json = new Gson().toJson(memberData2);
            } catch (Exception e3) {
                e3.printStackTrace();
                json = null;
            }
            Gson gson = new Gson();
            if (json == null) {
                return (ResponseMember) gson.fromJson(str, ResponseMember.class);
            }
            return (ResponseMember) gson.fromJson(json, ResponseMember.class);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static MemberData parseMemberData(String str) {
        return (MemberData) new Gson().fromJson(str, MemberData.class);
    }

    public static String toJsonMemberData(MemberData memberData) {
        return new Gson().toJson(memberData, MemberData.class);
    }

    public static ResponseDataCollection parseResponseDataCollection(String str) {
        return (ResponseDataCollection) new Gson().fromJson(str, ResponseDataCollection.class);
    }

    public static ResponseGoalDataGet parseResponseGoalDataGet(String str) {
        return (ResponseGoalDataGet) new Gson().fromJson(str, ResponseGoalDataGet.class);
    }

    public static ResponseDataGet parseResponseDataGet(String str) {
        try {
            return (ResponseDataGet) new GsonBuilder().setDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT).create().fromJson(str, ResponseDataGet.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ResponseDetailDataGet parseResponseDetailDataGet(String str) {
        return (ResponseDetailDataGet) new GsonBuilder().setDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT).create().fromJson(str, ResponseDetailDataGet.class);
    }

    public static String toJsonSportPath(List<double[]> list) {
        return new Gson().toJson(list, new TypeToken<List<double[]>>() { // from class: com.digifly.cloudapi.JsonUtil.1
        }.getType());
    }

    public static List<double[]> parseSportPath(String str) {
        List<double[]> list = (List) new Gson().fromJson(str, new TypeToken<List<double[]>>() { // from class: com.digifly.cloudapi.JsonUtil.2
        }.getType());
        return list == null ? new LinkedList() : list;
    }

    public static List<String> parseExportedUsers(String str) {
        List<String> list = (List) new Gson().fromJson(str, new TypeToken<List<String>>() { // from class: com.digifly.cloudapi.JsonUtil.3
        }.getType());
        return list == null ? new ArrayList() : list;
    }

    public static String toJsonExportedUsers(List<String> list) {
        return new Gson().toJson(list, new TypeToken<List<String>>() { // from class: com.digifly.cloudapi.JsonUtil.4
        }.getType());
    }

    public static ResponseMessagePush parseResponseMessagePush(String str) {
        return (ResponseMessagePush) new Gson().fromJson(str, ResponseMessagePush.class);
    }
}
