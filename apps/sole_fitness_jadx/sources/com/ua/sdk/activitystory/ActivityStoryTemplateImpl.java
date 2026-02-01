package com.ua.sdk.activitystory;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.Convert;
import com.ua.sdk.ImageUrl;
import com.ua.sdk.MeasurementSystem;
import com.ua.sdk.internal.ImageUrlImpl;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ActivityStoryTemplateImpl implements ActivityStoryTemplate, Parcelable {
    public static Parcelable.Creator<ActivityStoryTemplateImpl> CREATOR = new Parcelable.Creator<ActivityStoryTemplateImpl>() { // from class: com.ua.sdk.activitystory.ActivityStoryTemplateImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryTemplateImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryTemplateImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryTemplateImpl[] newArray(int i) {
            return new ActivityStoryTemplateImpl[i];
        }
    };

    @SerializedName("icon")
    String mIcon;
    transient Map<String, Object> mMessageArgs;

    @SerializedName("message")
    String mMessageTemplate;
    transient Map<String, Object> mSubtitleArgs;

    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    String mSubtitleTemplate;
    transient Map<String, Object> mTitleArgs;

    @SerializedName("title")
    String mTitleTemplate;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTemplate
    public ImageUrl getIconUrl() {
        if (this.mIcon == null) {
            return null;
        }
        return ImageUrlImpl.getBuilder().setUri(this.mIcon).build();
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTemplate
    public String getTitle(MeasurementSystem measurementSystem) {
        return createString(this.mTitleTemplate, this.mTitleArgs, measurementSystem);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTemplate
    public String getTitleTemplate() {
        return this.mTitleTemplate;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTemplate
    public Map<String, Object> getTitleArgs() {
        return this.mTitleArgs;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTemplate
    public String getSubtitle(MeasurementSystem measurementSystem) {
        return createString(this.mSubtitleTemplate, this.mSubtitleArgs, measurementSystem);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTemplate
    public String getSubtitleTemplate() {
        return this.mSubtitleTemplate;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTemplate
    public Map<String, Object> getSubtitleArgs() {
        return this.mSubtitleArgs;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTemplate
    public String getMessage(MeasurementSystem measurementSystem) {
        return createString(this.mMessageTemplate, this.mMessageArgs, measurementSystem);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTemplate
    public String getMessageTemplate() {
        return this.mMessageTemplate;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTemplate
    public Map<String, Object> getMessageArgs() {
        return this.mMessageArgs;
    }

    public void fillTemplateArgs(JsonObject jsonObject) {
        this.mTitleArgs = getArgs(this.mTitleTemplate, jsonObject);
        this.mSubtitleArgs = getArgs(this.mSubtitleTemplate, jsonObject);
        this.mMessageArgs = getArgs(this.mMessageTemplate, jsonObject);
    }

    Map<String, Object> getArgs(String str, JsonObject jsonObject) {
        Object asString;
        String strSubstring;
        if (jsonObject == null || str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }
        int length = str.length();
        int i = -1;
        HashMap map = null;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (z) {
                z = false;
            } else if (cCharAt == '\\') {
                z = true;
            } else if (cCharAt == '{') {
                i2++;
                if (i2 == 1) {
                    i = i4;
                }
            } else if (cCharAt == '}' && i2 > 0 && i2 == (i3 = i3 + 1)) {
                int i5 = i4 + 1;
                String strSubstring2 = str.substring(i2 + i, i5 - i3);
                JsonElement jsonElement = jsonObject;
                while (strSubstring2.length() > 0) {
                    int iIndexOf = strSubstring2.indexOf(46);
                    if (iIndexOf > 0) {
                        String strSubstring3 = strSubstring2.substring(0, iIndexOf);
                        strSubstring = strSubstring2.substring(iIndexOf + 1);
                        strSubstring2 = strSubstring3;
                    } else {
                        strSubstring = "";
                    }
                    jsonElement = jsonElement.isJsonObject() ? jsonElement.getAsJsonObject().get(strSubstring2) : null;
                    strSubstring2 = strSubstring;
                }
                if (jsonElement != null && !jsonElement.isJsonNull()) {
                    String strSubstring4 = str.substring(i, i5);
                    if (jsonElement.isJsonPrimitive()) {
                        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
                        if (jsonPrimitive.isBoolean()) {
                            asString = Boolean.valueOf(jsonPrimitive.getAsBoolean());
                        } else if (jsonPrimitive.isNumber()) {
                            asString = jsonPrimitive.getAsNumber();
                        } else {
                            asString = jsonPrimitive.getAsString();
                        }
                    } else {
                        asString = jsonElement.getAsString();
                    }
                    if (map == null) {
                        map = new HashMap(2);
                    }
                    map.put(strSubstring4, asString);
                }
                i = -1;
                i2 = 0;
                i3 = 0;
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    private String createString(String str, Map<String, Object> map, MeasurementSystem measurementSystem) throws NumberFormatException {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (measurementSystem == null) {
            measurementSystem = MeasurementSystem.IMPERIAL;
        }
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i = -1;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (z) {
                sb.append(cCharAt);
                z = false;
            } else if (cCharAt == '\\') {
                sb.append(cCharAt);
                z = true;
            } else if (cCharAt == '{') {
                i2++;
                if (i2 == 1) {
                    i = i4;
                }
            } else if (cCharAt != '}') {
                if (i < 0) {
                    sb.append(cCharAt);
                }
            } else if (i2 > 0 && i2 == (i3 = i3 + 1)) {
                String strSubstring = str.substring(i, i4 + 1);
                Object obj = map.get(strSubstring);
                if (obj == null) {
                    sb.append(strSubstring);
                } else if (strSubstring.contains("distance")) {
                    writeDistance(sb, obj, measurementSystem);
                } else {
                    sb.append(obj);
                }
                i = -1;
                i2 = 0;
                i3 = 0;
            }
        }
        return sb.toString();
    }

    private void writeDistance(StringBuilder sb, Object obj, MeasurementSystem measurementSystem) throws NumberFormatException {
        double dDoubleValue;
        if (obj instanceof Number) {
            dDoubleValue = ((Number) obj).doubleValue();
        } else {
            try {
                dDoubleValue = Double.parseDouble(obj.toString());
            } catch (NumberFormatException unused) {
                sb.append(obj.toString());
                return;
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        int i = AnonymousClass2.$SwitchMap$com$ua$sdk$MeasurementSystem[measurementSystem.ordinal()];
        if (i == 1) {
            sb.append(decimalFormat.format(Convert.meterToMile(Double.valueOf(dDoubleValue)).doubleValue()));
            sb.append("mi");
        } else {
            if (i != 2) {
                return;
            }
            sb.append(decimalFormat.format(Convert.meterToKilometer(Double.valueOf(dDoubleValue)).doubleValue()));
            sb.append("km");
        }
    }

    /* renamed from: com.ua.sdk.activitystory.ActivityStoryTemplateImpl$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$MeasurementSystem;

        static {
            int[] iArr = new int[MeasurementSystem.values().length];
            $SwitchMap$com$ua$sdk$MeasurementSystem = iArr;
            try {
                iArr[MeasurementSystem.IMPERIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$MeasurementSystem[MeasurementSystem.METRIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void writeArgsToParcel(Map<String, Object> map, Parcel parcel) {
        if (map == null || map.isEmpty()) {
            parcel.writeBundle(null);
            return;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            bundle.putSerializable(entry.getKey(), (Serializable) entry.getValue());
        }
        parcel.writeBundle(bundle);
    }

    private Map<String, Object> readArgsFromParcel(Parcel parcel) {
        Bundle bundle = parcel.readBundle();
        if (bundle == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundle.size());
        for (String str : bundle.keySet()) {
            map.put(str, bundle.getSerializable(str));
        }
        return map;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mIcon);
        writeArgsToParcel(this.mTitleArgs, parcel);
        writeArgsToParcel(this.mSubtitleArgs, parcel);
        writeArgsToParcel(this.mMessageArgs, parcel);
        parcel.writeString(this.mTitleTemplate);
        parcel.writeString(this.mSubtitleTemplate);
        parcel.writeString(this.mMessageTemplate);
    }

    public ActivityStoryTemplateImpl() {
    }

    private ActivityStoryTemplateImpl(Parcel parcel) {
        this.mIcon = parcel.readString();
        this.mTitleArgs = readArgsFromParcel(parcel);
        this.mSubtitleArgs = readArgsFromParcel(parcel);
        this.mMessageArgs = readArgsFromParcel(parcel);
        this.mTitleTemplate = parcel.readString();
        this.mSubtitleTemplate = parcel.readString();
        this.mMessageTemplate = parcel.readString();
    }

    public String toString() {
        return toString(null);
    }

    public String toString(MeasurementSystem measurementSystem) {
        StringBuilder sb = new StringBuilder();
        if (this.mTitleTemplate != null) {
            sb.append(getTitle(measurementSystem));
        }
        if (this.mSubtitleTemplate != null) {
            sb.append('\n');
            sb.append(getSubtitle(measurementSystem));
        }
        if (this.mMessageTemplate != null) {
            sb.append('\n');
            sb.append(getMessage(measurementSystem));
        }
        return sb.toString();
    }
}
