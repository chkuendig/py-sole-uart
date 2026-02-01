package com.dyaco.sole.database;

import com.dyaco.sole.custom.CalendarUtils;
import com.facebook.internal.security.CertificateUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class WorkoutData {
    public static final String AVG_HR = "avg_hr";
    public static final String AVG_LEVEL = "avg_level";
    public static final String AVG_METS = "avg_mets";
    public static final String AVG_RPM = "avg_rpm";
    public static final String AVG_SPEED = "avg_speed";
    public static final String AVG_WATTS = "avg_watts";
    public static final String CALORIES = "calories";
    public static final String DEVICE_MODEL_NAME = "device_model_name";
    public static final String DISTANCE = "distance";
    public static final String DURATION = "duration";
    public static final String END_DATE = "end_date";
    public static final String GOALS = "goals";
    public static final String NAME = "name";
    public static final String NOTES = "notes";
    public static final String PROGRAM_NAME_RES = "program_name_res";
    public static final String START_DATE = "start_date";
    public static final String WORKOUT_TB_NAME = "workout";
    private int avgHR;
    private int avgLevel;
    private float avgMETs;
    private int avgRPM;
    private float avgSpeed;
    private int avgWatts;
    private int calories;
    private String deviceModelName;
    private float distance;
    private int duration;
    private String endDate;
    private String goals;
    private String in_out;
    private String name;
    private String notes;
    private int programNameRes;
    private String startDate;
    private Long trainingDataId;
    private SimpleDateFormat dateSdf = new SimpleDateFormat(CalendarUtils.DAY_DATE_FORMAT);
    private SimpleDateFormat timeSdf = new SimpleDateFormat("hh:mm a");

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public String getDeviceModelName() {
        return this.deviceModelName;
    }

    public void setDeviceModelName(String str) {
        this.deviceModelName = str;
    }

    public int getProgramNameRes() {
        return this.programNameRes;
    }

    public void setProgramNameRes(int i) {
        this.programNameRes = i;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setDistance(float f) {
        this.distance = f;
    }

    public int getCalories() {
        return this.calories;
    }

    public void setCalories(int i) {
        this.calories = i;
    }

    public String getGoals() {
        return this.goals;
    }

    public void setGoals(String str) {
        this.goals = str;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String str) {
        this.notes = str;
    }

    public int getAvgHR() {
        return this.avgHR;
    }

    public void setAvgHR(int i) {
        this.avgHR = i;
    }

    public float getAvgSpeed() {
        return this.avgSpeed;
    }

    public void setAvgSpeed(float f) {
        this.avgSpeed = f;
    }

    public int getAvgRPM() {
        return this.avgRPM;
    }

    public void setAvgRPM(int i) {
        this.avgRPM = i;
    }

    public int getAvgWatts() {
        return this.avgWatts;
    }

    public void setAvgWatts(int i) {
        this.avgWatts = i;
    }

    public int getAvgLevel() {
        return this.avgLevel;
    }

    public void setAvgLevel(int i) {
        this.avgLevel = i;
    }

    public float getAvgMETs() {
        return this.avgMETs;
    }

    public void setAvgMETs(float f) {
        this.avgMETs = f;
    }

    public String getStartDateFormat(String str) {
        return this.dateSdf.format(getStartCalendar(str).getTime());
    }

    public String getStartTimeFormat(String str) {
        return this.timeSdf.format(getStartCalendar(str).getTime());
    }

    public String getEndTimeFormat(String str) {
        return this.timeSdf.format(getEndCalendar(str).getTime());
    }

    public Calendar getStartCalendar(String str) throws NumberFormatException {
        String[] strArrSplit = str.split(StringUtils.SPACE);
        String[] strArrSplit2 = strArrSplit[0].split(HelpFormatter.DEFAULT_OPT_PREFIX);
        String[] strArrSplit3 = strArrSplit[1].split(CertificateUtil.DELIMITER);
        int i = Integer.parseInt(strArrSplit2[0]);
        int i2 = Integer.parseInt(strArrSplit2[1]) - 1;
        int i3 = Integer.parseInt(strArrSplit2[2]);
        int i4 = Integer.parseInt(strArrSplit3[0]);
        int i5 = Integer.parseInt(strArrSplit3[1]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i2, i3, i4, i5);
        return calendar;
    }

    public Calendar getEndCalendar(String str) throws NumberFormatException {
        String[] strArrSplit = str.split(StringUtils.SPACE);
        String[] strArrSplit2 = strArrSplit[0].split(HelpFormatter.DEFAULT_OPT_PREFIX);
        String[] strArrSplit3 = strArrSplit[1].split(CertificateUtil.DELIMITER);
        int i = Integer.parseInt(strArrSplit2[0]);
        int i2 = Integer.parseInt(strArrSplit2[1]) - 1;
        int i3 = Integer.parseInt(strArrSplit2[2]);
        int i4 = Integer.parseInt(strArrSplit3[0]);
        int i5 = Integer.parseInt(strArrSplit3[1]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i2, i3, i4, i5);
        return calendar;
    }

    public void setIn_out(String str) {
        this.in_out = str;
    }

    public String getIn_out() {
        return this.in_out;
    }

    public void setTrainingDataId(Long l) {
        this.trainingDataId = l;
    }

    public Long getTrainingDataId() {
        return this.trainingDataId;
    }
}
