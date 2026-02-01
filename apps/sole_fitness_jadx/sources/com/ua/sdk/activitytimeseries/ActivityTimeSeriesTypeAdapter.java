package com.ua.sdk.activitytimeseries;

import com.dyaco.sole.database.WorkoutData;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ua.sdk.activitytimeseries.ActivityTimeSeriesImpl;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.util.DoubleList;
import com.ua.sdk.util.IntList;
import com.ua.sdk.util.LongList;
import java.io.IOException;

/* loaded from: classes2.dex */
public class ActivityTimeSeriesTypeAdapter extends TypeAdapter<ActivityTimeSeriesImpl.TimeSeries> {
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ActivityTimeSeriesImpl.TimeSeries timeSeries) throws IOException {
        if (timeSeries != null) {
            jsonWriter.beginObject();
            writeIntValues(jsonWriter, BaseDataTypes.ID_STEPS, timeSeries.stepEpochs, timeSeries.stepValues);
            writeDoubleValues(jsonWriter, "distance", timeSeries.distanceEpochs, timeSeries.distanceValues);
            writeDoubleValues(jsonWriter, WorkoutData.CALORIES, timeSeries.calorieEpochs, timeSeries.calorieValues);
            jsonWriter.endObject();
            return;
        }
        jsonWriter.nullValue();
    }

    private void writeIntValues(JsonWriter jsonWriter, String str, long[] jArr, int[] iArr) throws IOException {
        if (jArr != null) {
            jsonWriter.name(str);
            jsonWriter.beginObject();
            jsonWriter.name("values");
            jsonWriter.beginArray();
            int length = jArr.length;
            for (int i = 0; i < length; i++) {
                jsonWriter.beginArray();
                jsonWriter.value(jArr[i]);
                jsonWriter.value(iArr[i]);
                jsonWriter.endArray();
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
        }
    }

    private void writeDoubleValues(JsonWriter jsonWriter, String str, long[] jArr, double[] dArr) throws IOException {
        if (jArr != null) {
            jsonWriter.name(str);
            jsonWriter.beginObject();
            jsonWriter.name("values");
            jsonWriter.beginArray();
            int length = jArr.length;
            for (int i = 0; i < length; i++) {
                jsonWriter.beginArray();
                jsonWriter.value(jArr[i]);
                jsonWriter.value(dArr[i]);
                jsonWriter.endArray();
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public ActivityTimeSeriesImpl.TimeSeries read(JsonReader jsonReader) throws IOException, NumberFormatException {
        ActivityTimeSeriesImpl.TimeSeries timeSeries = new ActivityTimeSeriesImpl.TimeSeries();
        jsonReader.beginObject();
        LongList longList = null;
        IntList intList = null;
        DoubleList doubleList = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (BaseDataTypes.ID_STEPS.equals(strNextName)) {
                if (longList == null) {
                    longList = new LongList();
                } else {
                    longList.clear();
                }
                if (intList == null) {
                    intList = new IntList();
                } else {
                    intList.clear();
                }
                readIntValues(jsonReader, longList, intList);
                timeSeries.stepEpochs = longList.toArray();
                timeSeries.stepValues = intList.toArray();
            } else if ("distance".equals(strNextName)) {
                if (longList == null) {
                    longList = new LongList();
                } else {
                    longList.clear();
                }
                if (doubleList == null) {
                    doubleList = new DoubleList();
                } else {
                    doubleList.clear();
                }
                readDoubleValues(jsonReader, longList, doubleList);
                timeSeries.distanceEpochs = longList.toArray();
                timeSeries.distanceValues = doubleList.toArray();
            } else if (WorkoutData.CALORIES.equals(strNextName)) {
                if (longList == null) {
                    longList = new LongList();
                } else {
                    longList.clear();
                }
                if (doubleList == null) {
                    doubleList = new DoubleList();
                } else {
                    doubleList.clear();
                }
                readDoubleValues(jsonReader, longList, doubleList);
                timeSeries.calorieEpochs = longList.toArray();
                timeSeries.calorieValues = doubleList.toArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return timeSeries;
    }

    private void readIntValues(JsonReader jsonReader, LongList longList, IntList intList) throws IOException, NumberFormatException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if ("values".equals(jsonReader.nextName())) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    long jNextLong = jsonReader.nextLong();
                    int iNextInt = jsonReader.nextInt();
                    longList.add(jNextLong);
                    intList.add(iNextInt);
                    jsonReader.endArray();
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private void readDoubleValues(JsonReader jsonReader, LongList longList, DoubleList doubleList) throws IOException, NumberFormatException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if ("values".equals(jsonReader.nextName())) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    long jNextLong = jsonReader.nextLong();
                    double dNextDouble = jsonReader.nextDouble();
                    longList.add(jNextLong);
                    doubleList.add(dNextDouble);
                    jsonReader.endArray();
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
