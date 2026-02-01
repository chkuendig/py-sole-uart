package com.soletreadmills.sole_v2._data;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TrainhProcessData.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/TrainhProcessData;", "", "()V", "sys_response_data", "", "Lcom/soletreadmills/sole_v2/_data/TrainhProcessData$SysResponseDataBean;", "getSys_response_data", "()Ljava/util/List;", "setSys_response_data", "(Ljava/util/List;)V", "Companion", "SysResponseDataBean", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrainhProcessData {
    private List<SysResponseDataBean> sys_response_data;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public final List<SysResponseDataBean> getSys_response_data() {
        return this.sys_response_data;
    }

    public final void setSys_response_data(List<SysResponseDataBean> list) {
        this.sys_response_data = list;
    }

    /* compiled from: TrainhProcessData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b-\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001e\u0010 \u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u001e\u0010#\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001e\u0010&\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001e\u0010)\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001e\u0010,\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001e\u0010/\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001e\u00102\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001e\u00105\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\u001e\u00108\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001e\u0010;\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR\u001c\u0010>\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001a\"\u0004\b@\u0010\u001cR\u001c\u0010A\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001a\"\u0004\bC\u0010\u001c¨\u0006E"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/TrainhProcessData$SysResponseDataBean;", "", "()V", "avg_rpm", "", "getAvg_rpm", "()Ljava/lang/Double;", "setAvg_rpm", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "now_hr", "getNow_hr", "setNow_hr", "now_incline", "getNow_incline", "setNow_incline", "now_level", "", "getNow_level", "()Ljava/lang/Integer;", "setNow_level", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "now_pace", "", "getNow_pace", "()Ljava/lang/String;", "setNow_pace", "(Ljava/lang/String;)V", "now_speed", "getNow_speed", "setNow_speed", "now_watt", "getNow_watt", "setNow_watt", "total_avg_spm", "getTotal_avg_spm", "setTotal_avg_spm", "total_calorie", "getTotal_calorie", "setTotal_calorie", "total_cur_spm", "getTotal_cur_spm", "setTotal_cur_spm", "total_distance", "getTotal_distance", "setTotal_distance", "total_elevation", "getTotal_elevation", "setTotal_elevation", "total_floor", "getTotal_floor", "setTotal_floor", "total_min_spm", "getTotal_min_spm", "setTotal_min_spm", "total_spm", "getTotal_spm", "setTotal_spm", "total_steps", "getTotal_steps", "setTotal_steps", "total_timeleft", "getTotal_timeleft", "setTotal_timeleft", "total_workout_time", "getTotal_workout_time", "setTotal_workout_time", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SysResponseDataBean {
        private Double avg_rpm;
        private Double now_hr;
        private Double now_incline;
        private Integer now_level;
        private String now_pace;
        private Double now_speed;
        private Integer now_watt;
        private Double total_avg_spm;
        private Double total_calorie;
        private Double total_cur_spm;
        private Double total_distance;
        private Double total_elevation;
        private Double total_floor;
        private Double total_min_spm;
        private Double total_spm;
        private Double total_steps;
        private String total_timeleft;
        private String total_workout_time;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        public final String getTotal_workout_time() {
            return this.total_workout_time;
        }

        public final void setTotal_workout_time(String str) {
            this.total_workout_time = str;
        }

        public final String getTotal_timeleft() {
            return this.total_timeleft;
        }

        public final void setTotal_timeleft(String str) {
            this.total_timeleft = str;
        }

        public final Double getNow_hr() {
            return this.now_hr;
        }

        public final void setNow_hr(Double d) {
            this.now_hr = d;
        }

        public final Double getTotal_distance() {
            return this.total_distance;
        }

        public final void setTotal_distance(Double d) {
            this.total_distance = d;
        }

        public final String getNow_pace() {
            return this.now_pace;
        }

        public final void setNow_pace(String str) {
            this.now_pace = str;
        }

        public final Double getTotal_calorie() {
            return this.total_calorie;
        }

        public final void setTotal_calorie(Double d) {
            this.total_calorie = d;
        }

        public final Double getNow_speed() {
            return this.now_speed;
        }

        public final void setNow_speed(Double d) {
            this.now_speed = d;
        }

        public final Double getNow_incline() {
            return this.now_incline;
        }

        public final void setNow_incline(Double d) {
            this.now_incline = d;
        }

        public final Integer getNow_level() {
            return this.now_level;
        }

        public final void setNow_level(Integer num) {
            this.now_level = num;
        }

        public final Integer getNow_watt() {
            return this.now_watt;
        }

        public final void setNow_watt(Integer num) {
            this.now_watt = num;
        }

        public final Double getTotal_min_spm() {
            return this.total_min_spm;
        }

        public final void setTotal_min_spm(Double d) {
            this.total_min_spm = d;
        }

        public final Double getTotal_spm() {
            return this.total_spm;
        }

        public final void setTotal_spm(Double d) {
            this.total_spm = d;
        }

        public final Double getAvg_rpm() {
            return this.avg_rpm;
        }

        public final void setAvg_rpm(Double d) {
            this.avg_rpm = d;
        }

        public final Double getTotal_floor() {
            return this.total_floor;
        }

        public final void setTotal_floor(Double d) {
            this.total_floor = d;
        }

        public final Double getTotal_elevation() {
            return this.total_elevation;
        }

        public final void setTotal_elevation(Double d) {
            this.total_elevation = d;
        }

        public final Double getTotal_steps() {
            return this.total_steps;
        }

        public final void setTotal_steps(Double d) {
            this.total_steps = d;
        }

        public final Double getTotal_cur_spm() {
            return this.total_cur_spm;
        }

        public final void setTotal_cur_spm(Double d) {
            this.total_cur_spm = d;
        }

        public final Double getTotal_avg_spm() {
            return this.total_avg_spm;
        }

        public final void setTotal_avg_spm(Double d) {
            this.total_avg_spm = d;
        }

        /* compiled from: TrainhProcessData.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/TrainhProcessData$SysResponseDataBean$Companion;", "", "()V", "arraySysResponseDataBeanFromData", "", "Lcom/soletreadmills/sole_v2/_data/TrainhProcessData$SysResponseDataBean;", "str", "", "key", "objectFromData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SysResponseDataBean objectFromData(String str) throws JsonSyntaxException {
                Object objFromJson = new Gson().fromJson(str, (Class<Object>) SysResponseDataBean.class);
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                return (SysResponseDataBean) objFromJson;
            }

            public final SysResponseDataBean objectFromData(String str, String key) {
                try {
                    return (SysResponseDataBean) new Gson().fromJson(new JSONObject(str).getString(str), SysResponseDataBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            public final List<SysResponseDataBean> arraySysResponseDataBeanFromData(String str) throws JsonSyntaxException {
                Object objFromJson = new Gson().fromJson(str, new TypeToken<ArrayList<SysResponseDataBean>>() { // from class: com.soletreadmills.sole_v2._data.TrainhProcessData$SysResponseDataBean$Companion$arraySysResponseDataBeanFromData$listType$1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                return (List) objFromJson;
            }

            public final List<SysResponseDataBean> arraySysResponseDataBeanFromData(String str, String key) throws JsonSyntaxException {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Object objFromJson = new Gson().fromJson(jSONObject.getString(str), new TypeToken<ArrayList<SysResponseDataBean>>() { // from class: com.soletreadmills.sole_v2._data.TrainhProcessData$SysResponseDataBean$Companion$arraySysResponseDataBeanFromData$listType$2
                    }.getType());
                    Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                    return (List) objFromJson;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new ArrayList();
                }
            }
        }
    }

    /* compiled from: TrainhProcessData.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/TrainhProcessData$Companion;", "", "()V", "arrayTrainhProcessDataFromData", "", "Lcom/soletreadmills/sole_v2/_data/TrainhProcessData;", "str", "", "key", "objectFromData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TrainhProcessData objectFromData(String str) throws JsonSyntaxException {
            Object objFromJson = new Gson().fromJson(str, (Class<Object>) TrainhProcessData.class);
            Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
            return (TrainhProcessData) objFromJson;
        }

        public final TrainhProcessData objectFromData(String str, String key) {
            try {
                return (TrainhProcessData) new Gson().fromJson(new JSONObject(str).getString(str), TrainhProcessData.class);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public final List<TrainhProcessData> arrayTrainhProcessDataFromData(String str) throws JsonSyntaxException {
            Object objFromJson = new Gson().fromJson(str, new TypeToken<ArrayList<TrainhProcessData>>() { // from class: com.soletreadmills.sole_v2._data.TrainhProcessData$Companion$arrayTrainhProcessDataFromData$listType$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
            return (List) objFromJson;
        }

        public final List<TrainhProcessData> arrayTrainhProcessDataFromData(String str, String key) throws JsonSyntaxException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Object objFromJson = new Gson().fromJson(jSONObject.getString(str), new TypeToken<ArrayList<TrainhProcessData>>() { // from class: com.soletreadmills.sole_v2._data.TrainhProcessData$Companion$arrayTrainhProcessDataFromData$listType$2
                }.getType());
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                return (List) objFromJson;
            } catch (JSONException e) {
                e.printStackTrace();
                return new ArrayList();
            }
        }
    }
}
