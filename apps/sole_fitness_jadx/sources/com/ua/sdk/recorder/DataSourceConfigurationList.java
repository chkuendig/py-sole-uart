package com.ua.sdk.recorder;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class DataSourceConfigurationList {

    @SerializedName("bluetooth_data_source_configuration")
    ArrayList<BluetoothSensorDataSourceConfiguration> bluetoothDataSourceConfigurations;

    @SerializedName("derived_data_source_configuration")
    ArrayList<DerivedDataSourceConfiguration> derivedDataSourceConfigurations;

    @SerializedName("location_data_source_configuration")
    ArrayList<LocationSensorDataSourceConfiguration> locationDataSourceConfigurations;

    public ArrayList<BluetoothSensorDataSourceConfiguration> getBluetoothDataSourceConfigurations() {
        return this.bluetoothDataSourceConfigurations;
    }

    public ArrayList<LocationSensorDataSourceConfiguration> getLocationDataSourceConfigurations() {
        return this.locationDataSourceConfigurations;
    }

    public ArrayList<DerivedDataSourceConfiguration> getDerivedDataSourceConfigurations() {
        return this.derivedDataSourceConfigurations;
    }

    public boolean isBluetoothDataSourceConfigurationEmpty() {
        ArrayList<BluetoothSensorDataSourceConfiguration> arrayList = this.bluetoothDataSourceConfigurations;
        return arrayList == null || arrayList.isEmpty();
    }

    public boolean isLocationDataSourceConfigurationEmpty() {
        ArrayList<LocationSensorDataSourceConfiguration> arrayList = this.locationDataSourceConfigurations;
        return arrayList == null || arrayList.isEmpty();
    }

    public boolean isDerivedDataSourceConfigurationEmpty() {
        ArrayList<DerivedDataSourceConfiguration> arrayList = this.derivedDataSourceConfigurations;
        return arrayList == null || arrayList.isEmpty();
    }

    public void addBluetoothDataSourceConfiguration(BluetoothSensorDataSourceConfiguration bluetoothSensorDataSourceConfiguration) {
        if (this.bluetoothDataSourceConfigurations == null) {
            this.bluetoothDataSourceConfigurations = new ArrayList<>();
        }
        this.bluetoothDataSourceConfigurations.add(bluetoothSensorDataSourceConfiguration);
    }

    public void addLocationDataSourceConfiguration(LocationSensorDataSourceConfiguration locationSensorDataSourceConfiguration) {
        if (this.locationDataSourceConfigurations == null) {
            this.locationDataSourceConfigurations = new ArrayList<>();
        }
        this.locationDataSourceConfigurations.add(locationSensorDataSourceConfiguration);
    }

    public void addDerivedDataSourceConfiguration(DerivedDataSourceConfiguration derivedDataSourceConfiguration) {
        if (this.derivedDataSourceConfigurations == null) {
            this.derivedDataSourceConfigurations = new ArrayList<>();
        }
        this.derivedDataSourceConfigurations.add(derivedDataSourceConfiguration);
    }
}
