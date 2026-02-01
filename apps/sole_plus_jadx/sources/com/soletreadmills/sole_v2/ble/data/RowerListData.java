package com.soletreadmills.sole_v2.ble.data;

import com.google.gson.Gson;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class RowerListData {
    private String clubTicket = null;
    private ArrayList<RowerData> rowerDataArrayList = null;

    public static RowerListData objectFromData(String str) {
        return (RowerListData) new Gson().fromJson(str, RowerListData.class);
    }

    public ArrayList<RowerData> getRowerDataArrayList() {
        return this.rowerDataArrayList;
    }

    public void setRowerDataArrayList(ArrayList<RowerData> rowerDataArrayList) {
        this.rowerDataArrayList = rowerDataArrayList;
    }

    public String getClubTicket() {
        return this.clubTicket;
    }

    public void setClubTicket(String clubTicket) {
        this.clubTicket = clubTicket;
    }
}
