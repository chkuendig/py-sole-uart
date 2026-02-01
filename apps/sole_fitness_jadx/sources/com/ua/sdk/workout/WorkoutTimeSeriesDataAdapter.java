package com.ua.sdk.workout;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ua.sdk.datapoint.BaseDataTypes;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class WorkoutTimeSeriesDataAdapter extends TypeAdapter<WorkoutTimeSeriesImpl> {
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, WorkoutTimeSeriesImpl workoutTimeSeriesImpl) throws IOException {
        if (workoutTimeSeriesImpl != null) {
            jsonWriter.beginObject();
            if (workoutTimeSeriesImpl.workoutHeartRateEntryTimeSeries != null) {
                jsonWriter.name("heartrate");
                jsonWriter.beginArray();
                Iterator<T> it = workoutTimeSeriesImpl.workoutHeartRateEntryTimeSeries.iterator();
                while (it.hasNext()) {
                    WorkoutHeartRateEntry workoutHeartRateEntry = (WorkoutHeartRateEntry) it.next();
                    jsonWriter.beginArray();
                    jsonWriter.value(workoutHeartRateEntry.getOffset());
                    jsonWriter.value(workoutHeartRateEntry.getBpm());
                    jsonWriter.endArray();
                }
                jsonWriter.endArray();
            }
            if (workoutTimeSeriesImpl.workoutSpeedEntryTimeSeries != null) {
                jsonWriter.name(BaseDataTypes.ID_SPEED);
                jsonWriter.beginArray();
                Iterator<T> it2 = workoutTimeSeriesImpl.workoutSpeedEntryTimeSeries.iterator();
                while (it2.hasNext()) {
                    WorkoutSpeedEntry workoutSpeedEntry = (WorkoutSpeedEntry) it2.next();
                    jsonWriter.beginArray();
                    jsonWriter.value(workoutSpeedEntry.getOffset());
                    jsonWriter.value(workoutSpeedEntry.getInstantaneousSpeed());
                    jsonWriter.endArray();
                }
                jsonWriter.endArray();
            }
            if (workoutTimeSeriesImpl.workoutCadenceEntryTimeSeries != null) {
                jsonWriter.name("cadence");
                jsonWriter.beginArray();
                Iterator<T> it3 = workoutTimeSeriesImpl.workoutCadenceEntryTimeSeries.iterator();
                while (it3.hasNext()) {
                    WorkoutCadenceEntry workoutCadenceEntry = (WorkoutCadenceEntry) it3.next();
                    jsonWriter.beginArray();
                    jsonWriter.value(workoutCadenceEntry.getOffset());
                    jsonWriter.value(workoutCadenceEntry.getInstantaneousCadence());
                    jsonWriter.endArray();
                }
                jsonWriter.endArray();
            }
            if (workoutTimeSeriesImpl.workoutPowerEntryTimeSeries != null) {
                jsonWriter.name("power");
                jsonWriter.beginArray();
                Iterator<T> it4 = workoutTimeSeriesImpl.workoutPowerEntryTimeSeries.iterator();
                while (it4.hasNext()) {
                    WorkoutPowerEntry workoutPowerEntry = (WorkoutPowerEntry) it4.next();
                    jsonWriter.beginArray();
                    jsonWriter.value(workoutPowerEntry.getOffset());
                    jsonWriter.value(workoutPowerEntry.getInstantaneousPower());
                    jsonWriter.endArray();
                }
                jsonWriter.endArray();
            }
            if (workoutTimeSeriesImpl.workoutTorqueEntryTimeSeries != null) {
                jsonWriter.name("torque");
                jsonWriter.beginArray();
                Iterator<T> it5 = workoutTimeSeriesImpl.workoutTorqueEntryTimeSeries.iterator();
                while (it5.hasNext()) {
                    WorkoutTorqueEntry workoutTorqueEntry = (WorkoutTorqueEntry) it5.next();
                    jsonWriter.beginArray();
                    jsonWriter.value(workoutTorqueEntry.getOffset());
                    jsonWriter.value(workoutTorqueEntry.getInstantaneousTorque());
                    jsonWriter.endArray();
                }
                jsonWriter.endArray();
            }
            if (workoutTimeSeriesImpl.workoutDistanceTimeSeries != null) {
                jsonWriter.name("distance");
                jsonWriter.beginArray();
                Iterator<T> it6 = workoutTimeSeriesImpl.workoutDistanceTimeSeries.iterator();
                while (it6.hasNext()) {
                    WorkoutDistanceEntry workoutDistanceEntry = (WorkoutDistanceEntry) it6.next();
                    jsonWriter.beginArray();
                    jsonWriter.value(workoutDistanceEntry.getOffset());
                    jsonWriter.value(workoutDistanceEntry.getDistance());
                    jsonWriter.endArray();
                }
                jsonWriter.endArray();
            }
            if (workoutTimeSeriesImpl.workoutStepsEntryTimeSeries != null) {
                jsonWriter.name(BaseDataTypes.ID_STEPS);
                jsonWriter.beginArray();
                Iterator<T> it7 = workoutTimeSeriesImpl.workoutStepsEntryTimeSeries.iterator();
                while (it7.hasNext()) {
                    WorkoutStepsEntry workoutStepsEntry = (WorkoutStepsEntry) it7.next();
                    jsonWriter.beginArray();
                    jsonWriter.value(workoutStepsEntry.getOffset());
                    jsonWriter.value(workoutStepsEntry.getInstantaneousSteps());
                    jsonWriter.endArray();
                }
                jsonWriter.endArray();
            }
            if (workoutTimeSeriesImpl.workoutPositionEntryTimeSeries != null) {
                jsonWriter.name("position");
                jsonWriter.beginArray();
                Iterator<T> it8 = workoutTimeSeriesImpl.workoutPositionEntryTimeSeries.iterator();
                while (it8.hasNext()) {
                    WorkoutPositionEntry workoutPositionEntry = (WorkoutPositionEntry) it8.next();
                    jsonWriter.beginArray();
                    jsonWriter.value(workoutPositionEntry.getOffset());
                    jsonWriter.beginObject();
                    jsonWriter.name("elevation");
                    jsonWriter.value(workoutPositionEntry.getElevation());
                    jsonWriter.name("lat");
                    jsonWriter.value(workoutPositionEntry.getLatitude());
                    jsonWriter.name("lng");
                    jsonWriter.value(workoutPositionEntry.getLongitude());
                    jsonWriter.endObject();
                    jsonWriter.endArray();
                }
                jsonWriter.endArray();
            }
            if (workoutTimeSeriesImpl.workoutStopTimeEntryTimeSeries != null) {
                jsonWriter.name("timer_stop");
                jsonWriter.beginArray();
                Iterator<T> it9 = workoutTimeSeriesImpl.workoutStopTimeEntryTimeSeries.iterator();
                while (it9.hasNext()) {
                    WorkoutTimerStopEntry workoutTimerStopEntry = (WorkoutTimerStopEntry) it9.next();
                    jsonWriter.beginArray();
                    jsonWriter.value(workoutTimerStopEntry.getOffset());
                    jsonWriter.value(workoutTimerStopEntry.getStoppedTime());
                    jsonWriter.endArray();
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
            return;
        }
        jsonWriter.nullValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public WorkoutTimeSeriesImpl read(JsonReader jsonReader) throws IOException, NumberFormatException {
        WorkoutTimeSeriesImpl workoutTimeSeriesImpl = new WorkoutTimeSeriesImpl();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("heartrate")) {
                TimeSeriesImpl<WorkoutHeartRateEntry> timeSeriesImpl = new TimeSeriesImpl<>();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    timeSeriesImpl.add(new WorkoutHeartRateEntryImpl(Double.valueOf(jsonReader.nextDouble()), Integer.valueOf(jsonReader.nextInt())));
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                workoutTimeSeriesImpl.workoutHeartRateEntryTimeSeries = timeSeriesImpl;
            } else if (strNextName.equals(BaseDataTypes.ID_SPEED)) {
                TimeSeriesImpl<WorkoutSpeedEntry> timeSeriesImpl2 = new TimeSeriesImpl<>();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    timeSeriesImpl2.add(new WorkoutSpeedEntryImpl(Double.valueOf(jsonReader.nextDouble()), Double.valueOf(jsonReader.nextDouble())));
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                workoutTimeSeriesImpl.workoutSpeedEntryTimeSeries = timeSeriesImpl2;
            } else if (strNextName.equals("cadence")) {
                TimeSeriesImpl<WorkoutCadenceEntry> timeSeriesImpl3 = new TimeSeriesImpl<>();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    timeSeriesImpl3.add(new WorkoutCadenceEntryImpl(Double.valueOf(jsonReader.nextDouble()), Integer.valueOf(jsonReader.nextInt())));
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                workoutTimeSeriesImpl.workoutCadenceEntryTimeSeries = timeSeriesImpl3;
            } else if (strNextName.equals("power")) {
                TimeSeriesImpl<WorkoutPowerEntry> timeSeriesImpl4 = new TimeSeriesImpl<>();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    timeSeriesImpl4.add(new WorkoutPowerEntryImpl(Double.valueOf(jsonReader.nextDouble()), Double.valueOf(jsonReader.nextDouble())));
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                workoutTimeSeriesImpl.workoutPowerEntryTimeSeries = timeSeriesImpl4;
            } else if (strNextName.equals("torque")) {
                TimeSeriesImpl<WorkoutTorqueEntry> timeSeriesImpl5 = new TimeSeriesImpl<>();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    timeSeriesImpl5.add(new WorkoutTorqueEntryImpl(Double.valueOf(jsonReader.nextDouble()), Double.valueOf(jsonReader.nextDouble())));
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                workoutTimeSeriesImpl.workoutTorqueEntryTimeSeries = timeSeriesImpl5;
            } else if (strNextName.equals("distance")) {
                TimeSeriesImpl<WorkoutDistanceEntry> timeSeriesImpl6 = new TimeSeriesImpl<>();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    timeSeriesImpl6.add(new WorkoutDistanceEntryImpl(Double.valueOf(jsonReader.nextDouble()), Double.valueOf(jsonReader.nextDouble())));
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                workoutTimeSeriesImpl.workoutDistanceTimeSeries = timeSeriesImpl6;
            } else if (strNextName.equals(BaseDataTypes.ID_STEPS)) {
                TimeSeriesImpl<WorkoutStepsEntry> timeSeriesImpl7 = new TimeSeriesImpl<>();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    timeSeriesImpl7.add(new WorkoutStepsEntryImpl(Double.valueOf(jsonReader.nextDouble()), Integer.valueOf(jsonReader.nextInt())));
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                workoutTimeSeriesImpl.workoutStepsEntryTimeSeries = timeSeriesImpl7;
            } else if (strNextName.equals("position")) {
                TimeSeriesImpl<WorkoutPositionEntry> timeSeriesImpl8 = new TimeSeriesImpl<>();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    double dNextDouble = jsonReader.nextDouble();
                    jsonReader.beginObject();
                    Double dValueOf = null;
                    Double dValueOf2 = null;
                    Double dValueOf3 = null;
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        if (strNextName2.equals("elevation")) {
                            dValueOf = Double.valueOf(jsonReader.nextDouble());
                        } else if (strNextName2.equals("lat")) {
                            dValueOf2 = Double.valueOf(jsonReader.nextDouble());
                        } else if (strNextName2.equals("lng")) {
                            dValueOf3 = Double.valueOf(jsonReader.nextDouble());
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    timeSeriesImpl8.add(new WorkoutPositionEntryImpl(Double.valueOf(dNextDouble), dValueOf, dValueOf2, dValueOf3));
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                workoutTimeSeriesImpl.workoutPositionEntryTimeSeries = timeSeriesImpl8;
            } else if (strNextName.equals("timer_stop")) {
                TimeSeriesImpl<WorkoutTimerStopEntry> timeSeriesImpl9 = new TimeSeriesImpl<>();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    timeSeriesImpl9.add(new WorkoutTimerStopEntryImpl(Double.valueOf(jsonReader.nextDouble()), Double.valueOf(jsonReader.nextDouble())));
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                workoutTimeSeriesImpl.workoutStopTimeEntryTimeSeries = timeSeriesImpl9;
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return workoutTimeSeriesImpl;
    }
}
