package com.soletreadmills.sole_v2.ble.data;

import com.google.gson.Gson;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class CrossTrainerListData {
    private String clubTicket = null;
    private ArrayList<CrossTrainerData> crossTrainerDataArrayList = null;

    public static CrossTrainerListData objectFromData(String str) {
        return (CrossTrainerListData) new Gson().fromJson(str, CrossTrainerListData.class);
    }

    public ArrayList<CrossTrainerData> getCrossTrainerDataArrayList() {
        return this.crossTrainerDataArrayList;
    }

    public void setCrossTrainerDataArrayList(ArrayList<CrossTrainerData> crossTrainerDataArrayList) {
        this.crossTrainerDataArrayList = crossTrainerDataArrayList;
    }

    public String getClubTicket() {
        return this.clubTicket;
    }

    public void setClubTicket(String clubTicket) {
        this.clubTicket = clubTicket;
    }
}
