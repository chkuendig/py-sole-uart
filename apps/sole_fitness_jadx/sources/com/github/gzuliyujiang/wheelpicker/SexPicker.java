package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import com.facebook.appevents.AppEventsConstants;
import com.github.gzuliyujiang.dialog.DialogLog;
import com.github.gzuliyujiang.wheelpicker.entity.SexEntity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SexPicker extends OptionPicker {
    public static String JSON = "[{\"id\":0,\"name\":\"保密\",\"english\":\"Secrecy\"},\n{\"id\":1,\"name\":\"男\",\"english\":\"Male\"},\n{\"id\":2,\"name\":\"女\",\"english\":\"Female\"}]";
    private boolean includeSecrecy;

    public SexPicker(Activity activity) {
        super(activity);
    }

    public SexPicker(Activity activity, int i) {
        super(activity, i);
    }

    public void setIncludeSecrecy(boolean z) {
        this.includeSecrecy = z;
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

    public void setDefaultValueByName(String str) {
        SexEntity sexEntity = new SexEntity();
        sexEntity.setName(str);
        super.setDefaultValue(sexEntity);
    }

    public void setDefaultValueByEnglish(String str) {
        SexEntity sexEntity = new SexEntity();
        sexEntity.setEnglish(str);
        super.setDefaultValue(sexEntity);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.OptionPicker
    protected List<?> provideData() throws JSONException {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(JSON);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                SexEntity sexEntity = new SexEntity();
                sexEntity.setId(jSONObject.getString("id"));
                sexEntity.setName(jSONObject.getString("name"));
                sexEntity.setEnglish(jSONObject.getString("english"));
                if (this.includeSecrecy || !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(sexEntity.getId())) {
                    arrayList.add(sexEntity);
                }
            }
        } catch (JSONException e) {
            DialogLog.print(e);
        }
        return arrayList;
    }
}
