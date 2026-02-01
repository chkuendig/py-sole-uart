package com.ua.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.sdk.UaException;
import com.ua.sdk.net.json.Iso8601PeriodFormat;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class Period implements Parcelable {
    final String period;
    public static final Period ONE_DAY = new Period("P1D");
    public static final Period ONE_WEEK = new Period("P1W");
    public static final Period ONE_MONTH = new Period("P1M");
    public static final Period ONE_YEAR = new Period("P1Y");
    public static Parcelable.Creator<Period> CREATOR = new Parcelable.Creator<Period>() { // from class: com.ua.sdk.internal.Period.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Period createFromParcel(Parcel parcel) {
            return new Period(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Period[] newArray(int i) {
            return new Period[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private Period(String str) {
        this.period = str;
    }

    private Period(Iso8601PeriodFormat iso8601PeriodFormat) {
        this(iso8601PeriodFormat.toString());
    }

    private Period(Parcel parcel) {
        this.period = parcel.readString();
    }

    public boolean isValid(Period... periodArr) {
        if (periodArr == null) {
            return true;
        }
        for (Period period : periodArr) {
            if (period.toString().equalsIgnoreCase(this.period)) {
                return true;
            }
        }
        return false;
    }

    public static Period parse(String str) throws UaException {
        return new Period(Iso8601PeriodFormat.parse(str));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.period);
    }

    public String toString() {
        return this.period;
    }

    public static class PeriodAdapter implements JsonSerializer<Period>, JsonDeserializer<Period> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.JsonDeserializer
        public Period deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            try {
                return new Period(Iso8601PeriodFormat.parse(jsonElement.getAsString()));
            } catch (UaException unused) {
                return null;
            }
        }

        @Override // com.google.gson.JsonSerializer
        public JsonElement serialize(Period period, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(period.period);
        }
    }
}
