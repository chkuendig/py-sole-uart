package com.soletreadmills.sole_v2.ble.data;

import com.google.gson.Gson;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class IndoorBikeListData {
    private String clubTicket = null;
    private ArrayList<IndoorBikeData> indoorBikeDataArrayList = null;

    public static IndoorBikeListData objectFromData(String str) {
        return (IndoorBikeListData) new Gson().fromJson(str, IndoorBikeListData.class);
    }

    public ArrayList<IndoorBikeData> getIndoorBikeDataArrayList() {
        return this.indoorBikeDataArrayList;
    }

    public void setIndoorBikeDataArrayList(ArrayList<IndoorBikeData> indoorBikeDataArrayList) {
        this.indoorBikeDataArrayList = indoorBikeDataArrayList;
    }

    public String getClubTicket() {
        return this.clubTicket;
    }

    public void setClubTicket(String clubTicket) {
        this.clubTicket = clubTicket;
    }
}
