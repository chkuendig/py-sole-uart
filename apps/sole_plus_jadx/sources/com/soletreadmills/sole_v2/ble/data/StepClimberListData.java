package com.soletreadmills.sole_v2.ble.data;

import com.google.gson.Gson;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class StepClimberListData {
    private String clubTicket = null;
    private ArrayList<StepClimberData> stepClimberDataArrayList = null;

    public static StepClimberListData objectFromData(String str) {
        return (StepClimberListData) new Gson().fromJson(str, StepClimberListData.class);
    }

    public ArrayList<StepClimberData> getStepClimberDataArrayList() {
        return this.stepClimberDataArrayList;
    }

    public void setStepClimberDataArrayList(ArrayList<StepClimberData> stepClimberDataArrayList) {
        this.stepClimberDataArrayList = stepClimberDataArrayList;
    }

    public String getClubTicket() {
        return this.clubTicket;
    }

    public void setClubTicket(String clubTicket) {
        this.clubTicket = clubTicket;
    }
}
