package com.dyaco.sole.custom;

import com.digifly.cloudapi.data.DCGoalWebData;
import com.digifly.cloudapi.data.DCProgramGoalData;

/* loaded from: classes.dex */
public class DataUtils {
    public static DCProgramGoalData convertToGoalData(DCGoalWebData dCGoalWebData) {
        DCProgramGoalData dCProgramGoalData = new DCProgramGoalData();
        dCProgramGoalData.setAccount(dCGoalWebData.getAccount());
        dCProgramGoalData.setAccount_no(dCGoalWebData.getAccount_no());
        dCProgramGoalData.setGoal_no(dCGoalWebData.getGoal_no());
        dCProgramGoalData.setGoal_name(dCGoalWebData.getGoal_name());
        dCProgramGoalData.setGoal_duration(dCGoalWebData.getGoal_duration());
        dCProgramGoalData.setGoal_period_type(dCGoalWebData.getGoal_duration_range());
        dCProgramGoalData.setGoal_type(dCGoalWebData.getGoal_type());
        dCProgramGoalData.setGoal_val(dCGoalWebData.getGoal_type_value());
        dCProgramGoalData.setGoal_start_date(dCGoalWebData.getGoal_starttime());
        dCProgramGoalData.setGoal_end_date(dCGoalWebData.getGoal_endtime());
        dCProgramGoalData.setGoal_state(dCGoalWebData.getGoal_staturs());
        dCProgramGoalData.setGoal_val_now(dCGoalWebData.getGoal_finish_value());
        dCProgramGoalData.setElapsedays(dCGoalWebData.getGoal_finish_day());
        return dCProgramGoalData;
    }
}
