package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FeatureCollection extends GeoJSONObject {
    public static final Parcelable.Creator<FeatureCollection> CREATOR = new Parcelable.Creator<FeatureCollection>() { // from class: com.cocoahero.android.geojson.FeatureCollection.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeatureCollection createFromParcel(Parcel parcel) {
            return (FeatureCollection) GeoJSONObject.readParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeatureCollection[] newArray(int i) {
            return new FeatureCollection[i];
        }
    };
    public static final String JSON_FEATURES = "features";
    private final List<Feature> mFeatures;

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public String getType() {
        return GeoJSON.TYPE_FEATURE_COLLECTION;
    }

    public FeatureCollection() {
        this.mFeatures = new ArrayList();
    }

    public FeatureCollection(JSONObject jSONObject) {
        super(jSONObject);
        this.mFeatures = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(JSON_FEATURES);
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    this.mFeatures.add(new Feature(jSONObjectOptJSONObject));
                }
            }
        }
    }

    public void addFeature(Feature feature) {
        this.mFeatures.add(feature);
    }

    public void removeFeature(Feature feature) {
        this.mFeatures.remove(feature);
    }

    public List<Feature> getFeatures() {
        return this.mFeatures;
    }

    public void setFeatures(List<Feature> list) {
        this.mFeatures.clear();
        if (list != null) {
            this.mFeatures.addAll(list);
        }
    }

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        JSONArray jSONArray = new JSONArray();
        Iterator<Feature> it = this.mFeatures.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJSON());
        }
        json.put(JSON_FEATURES, jSONArray);
        return json;
    }
}
