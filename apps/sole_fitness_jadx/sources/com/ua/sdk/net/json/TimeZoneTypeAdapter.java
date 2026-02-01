package com.ua.sdk.net.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class TimeZoneTypeAdapter extends TypeAdapter<TimeZone> {
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, TimeZone timeZone) throws IOException {
        if (timeZone == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(timeZone.getID());
        }
    }

    @Override // com.google.gson.TypeAdapter
    public TimeZone read(JsonReader jsonReader) throws IOException {
        String strNextString = jsonReader.nextString();
        if (strNextString == null) {
            return null;
        }
        return TimeZone.getTimeZone(strNextString);
    }
}
