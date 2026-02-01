package com.dyaco.sole.fragment.programs;

import android.content.Context;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class ProgramGoalData {
    public static String TAG = "ProgramGoalData";
    public static Context context;
    public int goal_duration;
    public Date goal_end_date;
    public Long goal_id;
    public String goal_name;
    public int goal_percent;
    public GoalPeriodType goal_period_type;
    public int goal_pos_in_duration;
    public Date goal_start_date;
    public GoalStateType goal_state;
    public GoalType goal_type;
    public int goal_val;
    public float goal_val_now;
    public int imageId;
    public String strGoalTitle = "";
    public String strGoalStatus = "";
    public String strGoalPercent = "";
    public String strGoalType = "";
    public String strGoalPeriodType = "";
    public String strGoalPosInDuration = "";
    public String strGoalDuration = "";
    public String strGoalVal = "";
    public String strGoalValNow = "";
    public String strGoalUnit = "";
    public String strGoalDate = "";

    public enum GoalPeriodType {
        Day,
        Week,
        Month
    }

    public enum GoalStateType {
        Processing,
        Done,
        Miss
    }

    public enum GoalType {
        Time,
        Distance,
        Calorie
    }

    ProgramGoalData() {
    }

    ProgramGoalData(GoalStateType goalStateType, int i, String str, int i2, int i3, int i4, int i5, GoalPeriodType goalPeriodType, GoalType goalType, Date date, Date date2) {
        this.goal_state = goalStateType;
        this.goal_percent = i;
        this.goal_name = str;
        this.goal_pos_in_duration = i2;
        this.goal_duration = i3;
        this.goal_val = i5;
        this.goal_val_now = i4;
        this.goal_period_type = goalPeriodType;
        this.goal_type = goalType;
        this.goal_start_date = date;
        this.goal_end_date = date2;
        setGoalDataStr();
    }

    public void setGoalDataStr() {
        this.strGoalTitle = this.goal_name;
        this.strGoalPosInDuration = this.goal_pos_in_duration + "";
        this.strGoalDuration = this.goal_duration + "";
        int i = AnonymousClass1.$SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType[this.goal_state.ordinal()];
        if (i == 1) {
            this.strGoalStatus = "Processing";
        } else if (i == 2) {
            this.strGoalStatus = "Done";
        } else if (i == 3) {
            this.strGoalStatus = "Miss";
        }
        this.strGoalPercent = this.goal_percent + "";
        Log.v(TAG, "setGoalDataStr() goal_state : " + this.goal_state + " strGoalStatus : " + this.strGoalStatus + " strGoalPercent : " + this.strGoalPercent);
        int i2 = AnonymousClass1.$SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalPeriodType[this.goal_period_type.ordinal()];
        if (i2 == 1) {
            this.strGoalPeriodType = "Day";
        } else if (i2 == 2) {
            this.strGoalPeriodType = "Week";
        } else if (i2 == 3) {
            this.strGoalPeriodType = "Month";
        }
        this.strGoalVal = this.goal_val + "";
        this.strGoalValNow = (((float) Math.round(this.goal_val_now * 10.0f)) / 10.0f) + "";
        int i3 = AnonymousClass1.$SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalType[this.goal_type.ordinal()];
        if (i3 == 1) {
            this.strGoalType = "Distance";
            this.strGoalUnit = "Km";
        } else if (i3 == 2) {
            this.strGoalType = "Time";
            this.strGoalUnit = "Min/Day";
        } else if (i3 == 3) {
            this.strGoalType = "Calorie";
            this.strGoalUnit = "Kcal";
        }
        this.strGoalDate = new SimpleDateFormat("MM/dd/yyyy").format(Long.valueOf(this.goal_start_date.getTime()));
    }

    /* renamed from: com.dyaco.sole.fragment.programs.ProgramGoalData$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalPeriodType;
        static final /* synthetic */ int[] $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType;
        static final /* synthetic */ int[] $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalType;

        static {
            int[] iArr = new int[GoalType.values().length];
            $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalType = iArr;
            try {
                iArr[GoalType.Distance.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalType[GoalType.Time.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalType[GoalType.Calorie.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[GoalPeriodType.values().length];
            $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalPeriodType = iArr2;
            try {
                iArr2[GoalPeriodType.Day.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalPeriodType[GoalPeriodType.Week.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalPeriodType[GoalPeriodType.Month.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[GoalStateType.values().length];
            $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType = iArr3;
            try {
                iArr3[GoalStateType.Processing.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType[GoalStateType.Done.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dyaco$sole$fragment$programs$ProgramGoalData$GoalStateType[GoalStateType.Miss.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}
