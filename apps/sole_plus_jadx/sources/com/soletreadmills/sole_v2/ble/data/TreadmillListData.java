package com.soletreadmills.sole_v2.ble.data;

import com.google.gson.Gson;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class TreadmillListData {
    private String clubTicket = null;
    private ArrayList<TreadmillData> treadmillDataArrayList = null;

    public static TreadmillListData objectFromData(String str) {
        return (TreadmillListData) new Gson().fromJson(str, TreadmillListData.class);
    }

    public ArrayList<TreadmillData> getTreadmillDataArrayList() {
        return this.treadmillDataArrayList;
    }

    public void setTreadmillDataArrayList(ArrayList<TreadmillData> treadmillDataArrayList) {
        this.treadmillDataArrayList = treadmillDataArrayList;
    }

    public String getClubTicket() {
        return this.clubTicket;
    }

    public void setClubTicket(String clubTicket) {
        this.clubTicket = clubTicket;
    }
}
