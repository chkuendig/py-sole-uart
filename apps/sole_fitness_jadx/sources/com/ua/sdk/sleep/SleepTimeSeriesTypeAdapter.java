package com.ua.sdk.sleep;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ua.sdk.sleep.SleepMetric;
import com.ua.sdk.sleep.SleepMetricImpl;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class SleepTimeSeriesTypeAdapter extends TypeAdapter<SleepMetricImpl.TimeSeries> {
    public static final int BUFFER_SIZE = 256;

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, SleepMetricImpl.TimeSeries timeSeries) throws IOException {
        if (timeSeries != null) {
            jsonWriter.beginObject();
            jsonWriter.name("sleep");
            jsonWriter.beginObject();
            jsonWriter.name("values");
            jsonWriter.beginArray();
            ArrayList<SleepStateEntry> arrayList = timeSeries.events;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                SleepStateEntry sleepStateEntry = arrayList.get(i);
                jsonWriter.beginArray();
                jsonWriter.value(sleepStateEntry.epoch);
                jsonWriter.value(sleepStateEntry.state.value);
                jsonWriter.endArray();
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
            jsonWriter.endObject();
            return;
        }
        jsonWriter.nullValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public SleepMetricImpl.TimeSeries read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SleepMetricImpl.TimeSeries timeSeries = new SleepMetricImpl.TimeSeries();
        ArrayList<SleepStateEntry> arrayList = timeSeries.events;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if ("sleep".equals(jsonReader.nextName())) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if ("values".equals(jsonReader.nextName())) {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            arrayList.add(new SleepStateEntry(jsonReader.nextLong(), SleepMetric.State.getState(jsonReader.nextInt())));
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return timeSeries;
    }
}
