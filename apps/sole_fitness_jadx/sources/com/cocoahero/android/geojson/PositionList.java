package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import com.cocoahero.android.geojson.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class PositionList implements Parcelable {
    public static final Parcelable.Creator<PositionList> CREATOR = new Parcelable.Creator<PositionList>() { // from class: com.cocoahero.android.geojson.PositionList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PositionList createFromParcel(Parcel parcel) {
            return new PositionList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PositionList[] newArray(int i) {
            return new PositionList[i];
        }
    };
    private final List<Position> mPositions = new ArrayList();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PositionList() {
    }

    public PositionList(JSONArray jSONArray) {
        setPositions(jSONArray);
    }

    public PositionList(double[][] dArr) {
        for (double[] dArr2 : dArr) {
            addPosition(new Position(dArr2));
        }
    }

    protected PositionList(Parcel parcel) {
        setPositions(parcel.createTypedArrayList(Position.CREATOR));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.mPositions);
    }

    public List<Position> getPositions() {
        return this.mPositions;
    }

    public void addPosition(Position position) {
        this.mPositions.add(position);
    }

    public void addPositions(PositionList positionList) {
        this.mPositions.addAll(positionList.mPositions);
    }

    public void addPositions(List<Position> list) {
        this.mPositions.addAll(list);
    }

    public void removePosition(Position position) {
        this.mPositions.remove(position);
    }

    public void removePositions(PositionList positionList) {
        this.mPositions.removeAll(positionList.mPositions);
    }

    public void removePositions(List<Position> list) {
        this.mPositions.removeAll(list);
    }

    public void clearPositions() {
        this.mPositions.clear();
    }

    public void setPositions(JSONArray jSONArray) {
        this.mPositions.clear();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArrayOptJSONArray = jSONArray.optJSONArray(i);
                if (jSONArrayOptJSONArray != null) {
                    this.mPositions.add(new Position(jSONArrayOptJSONArray));
                }
            }
        }
    }

    public void setPositions(PositionList positionList) {
        this.mPositions.clear();
        if (positionList != null) {
            this.mPositions.addAll(positionList.mPositions);
        }
    }

    public void setPositions(List<Position> list) {
        this.mPositions.clear();
        if (list != null) {
            this.mPositions.addAll(list);
        }
    }

    public Position getHead() {
        return (Position) ListUtils.getHead(this.mPositions);
    }

    public Position getTail() {
        return (Position) ListUtils.getTail(this.mPositions);
    }

    public boolean isLinearRing() {
        if (this.mPositions.size() < 4) {
            return false;
        }
        return getHead().equals(getTail());
    }

    public JSONArray toJSON() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<Position> it = this.mPositions.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJSON());
        }
        return jSONArray;
    }
}
