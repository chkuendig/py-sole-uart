package com.ua.sdk.activitytype;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.UaLog;
import com.ua.sdk.util.Convert;
import com.ua.sdk.util.Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes2.dex */
public class WorkoutMetsSpeed implements Parcelable {
    public static Parcelable.Creator<WorkoutMetsSpeed> CREATOR = new Parcelable.Creator<WorkoutMetsSpeed>() { // from class: com.ua.sdk.activitytype.WorkoutMetsSpeed.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutMetsSpeed createFromParcel(Parcel parcel) {
            return new WorkoutMetsSpeed(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutMetsSpeed[] newArray(int i) {
            return new WorkoutMetsSpeed[i];
        }
    };
    private Double mMetersPerSec;
    private Double mMets;
    private Double mMph;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WorkoutMetsSpeed() {
    }

    public WorkoutMetsSpeed(Double d, Double d2) {
        this.mMph = d != null ? Convert.meterPerSecToMilePerHour(d) : null;
        this.mMetersPerSec = d != null ? Double.valueOf(d.doubleValue()) : null;
        this.mMets = d2 != null ? Double.valueOf(d2.doubleValue()) : null;
    }

    public Double getMets() {
        Double d = this.mMets;
        if (d != null) {
            return Double.valueOf(d.doubleValue());
        }
        return null;
    }

    public Double getSpeed() {
        Double d = this.mMetersPerSec;
        if (d != null) {
            return Double.valueOf(d.doubleValue());
        }
        return null;
    }

    public Double getSpeedMilesPerHour() {
        Double d = this.mMph;
        if (d != null) {
            return Double.valueOf(d.doubleValue());
        }
        return null;
    }

    public boolean isValid() {
        return (this.mMph == null || this.mMets == null) ? false : true;
    }

    public void setMets(Double d) {
        this.mMets = d != null ? Double.valueOf(d.doubleValue()) : null;
    }

    public void setSpeed(Double d) {
        this.mMph = d != null ? Double.valueOf(d.doubleValue()) : null;
        this.mMetersPerSec = d != null ? Convert.milePerHourToMeterPerSecond(d) : null;
    }

    public static List<WorkoutMetsSpeed> parseSpeedList(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!Utility.isEmpty(str)) {
            try {
                Object objNextValue = new JSONTokener(str).nextValue();
                if (objNextValue instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) objNextValue;
                    Iterator<String> itKeys = jSONObject.keys();
                    if (itKeys.hasNext()) {
                        do {
                            String next = itKeys.next();
                            Double dValueOf = Double.valueOf(Double.parseDouble(next));
                            Double dValueOf2 = Double.valueOf(Double.parseDouble(jSONObject.getString(next)));
                            if (dValueOf2 != null && dValueOf != null) {
                                WorkoutMetsSpeed workoutMetsSpeed = new WorkoutMetsSpeed(dValueOf2, dValueOf);
                                if (workoutMetsSpeed.isValid()) {
                                    arrayList.add(workoutMetsSpeed);
                                }
                            }
                        } while (itKeys.hasNext());
                    }
                }
                Collections.sort(arrayList, new Comparable());
            } catch (NumberFormatException e) {
                UaLog.error("Expected Number Value : %s\n, %s", str, e);
                arrayList.clear();
            } catch (JSONException e2) {
                UaLog.error("Malformed JSON", (Throwable) e2);
                arrayList.clear();
            }
        }
        return arrayList;
    }

    public static class Comparable implements Comparator<WorkoutMetsSpeed> {
        @Override // java.util.Comparator
        public int compare(WorkoutMetsSpeed workoutMetsSpeed, WorkoutMetsSpeed workoutMetsSpeed2) {
            Double speedMilesPerHour = workoutMetsSpeed.getSpeedMilesPerHour();
            Double speedMilesPerHour2 = workoutMetsSpeed2.getSpeedMilesPerHour();
            if (speedMilesPerHour == null && speedMilesPerHour2 == null) {
                return 0;
            }
            if (speedMilesPerHour2 == null) {
                return 1;
            }
            if (speedMilesPerHour == null) {
                return -1;
            }
            if (speedMilesPerHour.doubleValue() > speedMilesPerHour2.doubleValue()) {
                return 1;
            }
            return speedMilesPerHour == speedMilesPerHour2 ? 0 : -1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.mMph);
        parcel.writeValue(this.mMetersPerSec);
        parcel.writeValue(this.mMets);
    }

    private WorkoutMetsSpeed(Parcel parcel) {
        this.mMph = (Double) parcel.readValue(Double.class.getClassLoader());
        this.mMetersPerSec = (Double) parcel.readValue(Double.class.getClassLoader());
        this.mMets = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
