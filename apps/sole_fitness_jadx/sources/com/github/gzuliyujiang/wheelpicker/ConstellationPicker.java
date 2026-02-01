package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import com.facebook.appevents.AppEventsConstants;
import com.github.gzuliyujiang.dialog.DialogLog;
import com.github.gzuliyujiang.wheelpicker.entity.ConstellationEntity;
import com.github.gzuliyujiang.wheelpicker.entity.DateEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ConstellationPicker extends OptionPicker {
    public static String JSON = "[{\"id\":0,\"name\":\"不限\",\"startDate\":\"\",\"endDate\":\"\",\"english\":\"Unlimited\"},\n{\"id\":1,\"name\":\"白羊座\",\"startDate\":\"3-21\",\"endDate\":\"4-19\",\"english\":\"Aries\"},\n{\"id\":2,\"name\":\"金牛座\",\"startDate\":\"4-20\",\"endDate\":\"5-20\",\"english\":\"Taurus\"},\n{\"id\":3,\"name\":\"双子座\",\"startDate\":\"5-21\",\"endDate\":\"6-21\",\"english\":\"Gemini\"},\n{\"id\":4,\"name\":\"巨蟹座\",\"startDate\":\"6-22\",\"endDate\":\"7-22\",\"english\":\"Cancer\"},\n{\"id\":5,\"name\":\"狮子座\",\"startDate\":\"7-23\",\"endDate\":\"8-22\",\"english\":\"Leo\"},\n{\"id\":6,\"name\":\"处女座\",\"startDate\":\"8-23\",\"endDate\":\"9-22\",\"english\":\"Virgo\"},\n{\"id\":7,\"name\":\"天秤座\",\"startDate\":\"9-23\",\"endDate\":\"10-23\",\"english\":\"Libra\"},\n{\"id\":8,\"name\":\"天蝎座\",\"startDate\":\"10-24\",\"endDate\":\"11-22\",\"english\":\"Scorpio\"},\n{\"id\":9,\"name\":\"射手座\",\"startDate\":\"11-23\",\"endDate\":\"12-21\",\"english\":\"Sagittarius\"},\n{\"id\":10,\"name\":\"摩羯座\",\"startDate\":\"12-22\",\"endDate\":\"1-19\",\"english\":\"Capricorn\"},\n{\"id\":11,\"name\":\"水瓶座\",\"startDate\":\"1-20\",\"endDate\":\"2-18\",\"english\":\"Aquarius\"},\n{\"id\":12,\"name\":\"双鱼座\",\"startDate\":\"2-19\",\"endDate\":\"3-20\",\"english\":\"Pisces\"}]";
    private boolean includeUnlimited;

    public ConstellationPicker(Activity activity) {
        super(activity);
        this.includeUnlimited = false;
    }

    public ConstellationPicker(Activity activity, int i) {
        super(activity, i);
        this.includeUnlimited = false;
    }

    public void setIncludeUnlimited(boolean z) {
        this.includeUnlimited = z;
        setData(provideData());
    }

    @Override // com.github.gzuliyujiang.wheelpicker.OptionPicker
    public void setDefaultValue(Object obj) {
        if (obj instanceof String) {
            setDefaultValueByName(obj.toString());
        } else {
            super.setDefaultValue(obj);
        }
    }

    public void setDefaultValueById(String str) {
        ConstellationEntity constellationEntity = new ConstellationEntity();
        constellationEntity.setId(str);
        super.setDefaultValue(constellationEntity);
    }

    public void setDefaultValueByName(String str) {
        ConstellationEntity constellationEntity = new ConstellationEntity();
        constellationEntity.setName(str);
        super.setDefaultValue(constellationEntity);
    }

    public void setDefaultValueByDate(DateEntity dateEntity) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateEntity.toTimeInMillis());
        setDefaultValueByDate(calendar.getTime());
    }

    public void setDefaultValueByDate(Date date) {
        ConstellationPicker constellationPicker;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(2) + 1;
        int i2 = calendar.get(5);
        String str = "射手座";
        switch (i) {
            case 1:
                String str2 = i2 >= 21 ? "水瓶座" : "摩羯座";
                constellationPicker = this;
                str = str2;
                break;
            case 2:
                String str3 = i2 < 20 ? "水瓶座" : "双鱼座";
                constellationPicker = this;
                str = str3;
                break;
            case 3:
                String str4 = i2 < 21 ? "双鱼座" : "白羊座";
                constellationPicker = this;
                str = str4;
                break;
            case 4:
                String str5 = i2 < 21 ? "白羊座" : "金牛座";
                constellationPicker = this;
                str = str5;
                break;
            case 5:
                String str6 = i2 < 22 ? "金牛座" : "双子座";
                constellationPicker = this;
                str = str6;
                break;
            case 6:
                String str7 = i2 < 22 ? "双子座" : "巨蟹座";
                constellationPicker = this;
                str = str7;
                break;
            case 7:
                String str8 = i2 < 23 ? "巨蟹座" : "狮子座";
                constellationPicker = this;
                str = str8;
                break;
            case 8:
                String str9 = i2 < 24 ? "狮子座" : "处女座";
                constellationPicker = this;
                str = str9;
                break;
            case 9:
                String str10 = i2 < 24 ? "处女座" : "天秤座";
                constellationPicker = this;
                str = str10;
                break;
            case 10:
                String str11 = i2 < 24 ? "天秤座" : "天蝎座";
                constellationPicker = this;
                str = str11;
                break;
            case 11:
                if (i2 < 23) {
                    str = "天蝎座";
                }
                constellationPicker = this;
                break;
            case 12:
                if (i2 >= 22) {
                    str = "摩羯座";
                }
                constellationPicker = this;
                break;
            default:
                str = "不限";
                constellationPicker = this;
                break;
        }
        constellationPicker.setDefaultValueByName(str);
    }

    public void setDefaultValueByEnglish(String str) {
        ConstellationEntity constellationEntity = new ConstellationEntity();
        constellationEntity.setEnglish(str);
        super.setDefaultValue(constellationEntity);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.OptionPicker
    protected List<?> provideData() throws JSONException {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(JSON);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                ConstellationEntity constellationEntity = new ConstellationEntity();
                constellationEntity.setId(jSONObject.getString("id"));
                constellationEntity.setStartDate(jSONObject.getString("startDate"));
                constellationEntity.setEndDate(jSONObject.getString("endDate"));
                constellationEntity.setName(jSONObject.getString("name"));
                constellationEntity.setEnglish(jSONObject.getString("english"));
                if (this.includeUnlimited || !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(constellationEntity.getId())) {
                    arrayList.add(constellationEntity);
                }
            }
        } catch (JSONException e) {
            DialogLog.print(e);
        }
        return arrayList;
    }
}
