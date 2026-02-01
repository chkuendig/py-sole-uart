package com.ua.sdk.recorder.datasource.derived;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.DerivedDataSourceConfiguration;
import com.ua.sdk.recorder.datasource.AbstractDataSourceConfiguration;
import com.ua.sdk.recorder.datasource.DataSource;
import com.ua.sdk.recorder.datasource.derived.location.LocationDerivedDataSource;
import com.ua.sdk.recorder.datasource.sensor.SensorDataSource;
import com.ua.sdk.recorder.producer.SensorMessageProducer;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class DerivedDataSourceConfigurationImpl extends AbstractDataSourceConfiguration implements DerivedDataSourceConfiguration {

    @SerializedName("data_source_type")
    public DerivedDataSourceConfiguration.DataSourceType dataSourceType;

    @SerializedName("priority")
    public int priority;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.recorder.DataSourceConfiguration
    public DerivedDataSourceConfiguration setDataSourceIdentifier(DataSourceIdentifier dataSourceIdentifier) {
        this.dataSourceIdentifier = dataSourceIdentifier;
        return this;
    }

    @Override // com.ua.sdk.recorder.DerivedDataSourceConfiguration
    public DerivedDataSourceConfiguration setDataSource(DerivedDataSourceConfiguration.DataSourceType dataSourceType) {
        this.dataSourceType = dataSourceType;
        return this;
    }

    @Override // com.ua.sdk.recorder.DerivedDataSourceConfiguration
    public DerivedDataSourceConfiguration setPriority(int i) {
        this.priority = i;
        return this;
    }

    @Override // com.ua.sdk.recorder.datasource.AbstractDataSourceConfiguration
    public DataSource build(SensorMessageProducer sensorMessageProducer, SensorDataSource.SensorDataSourceListener sensorDataSourceListener) {
        if (this.dataSourceIdentifier == null) {
            throw new IllegalArgumentException("A data source must be specified.");
        }
        if (this.dataSourceType == null) {
            throw new IllegalArgumentException("A data source type must be specified.");
        }
        switch (AnonymousClass1.$SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType[this.dataSourceType.ordinal()]) {
            case 1:
                return new BearingDerivedDataSource(this.dataSourceIdentifier, new ArrayList(Arrays.asList(BaseDataTypes.TYPE_BEARING.getRef())));
            case 2:
                return new CyclingPowerSummaryDerivedDataSource(this.dataSourceIdentifier, new ArrayList(Arrays.asList(BaseDataTypes.TYPE_CYCLING_POWER_SUMMARY.getRef())));
            case 3:
                return new DistanceDerivedDataSource(this.dataSourceIdentifier, new ArrayList(Arrays.asList(BaseDataTypes.TYPE_DISTANCE.getRef())));
            case 4:
                return new ElevationSummaryDerivedDataSource(this.dataSourceIdentifier, new ArrayList(Arrays.asList(BaseDataTypes.TYPE_ELEVATION_SUMMARY.getRef())));
            case 5:
                return new EnergyExpendedDerivedDataSource(this.dataSourceIdentifier, new ArrayList(Arrays.asList(BaseDataTypes.TYPE_ENERGY_EXPENDED.getRef())));
            case 6:
                return new HeartRateSummaryDerivedDataSource(this.dataSourceIdentifier, new ArrayList(Arrays.asList(BaseDataTypes.TYPE_HEART_RATE_SUMMARY.getRef())));
            case 7:
                return new IntensityDerivedDataSource(this.dataSourceIdentifier, new ArrayList(Arrays.asList(BaseDataTypes.TYPE_INTENSITY.getRef())));
            case 8:
                return new LocationDerivedDataSource(this.dataSourceIdentifier, new ArrayList(Arrays.asList(BaseDataTypes.TYPE_LOCATION.getRef())));
            case 9:
                return new RunCadenceSummaryDerivedDataSource(this.dataSourceIdentifier, new ArrayList(Arrays.asList(BaseDataTypes.TYPE_RUN_CADENCE_SUMMARY.getRef())));
            case 10:
                return new SpeedDerivedDataSource(this.dataSourceIdentifier, new ArrayList(Arrays.asList(BaseDataTypes.TYPE_SPEED.getRef())));
            case 11:
                return new SpeedSummaryDerivedDataSource(this.dataSourceIdentifier, new ArrayList(Arrays.asList(BaseDataTypes.TYPE_SPEED_SUMMARY.getRef())));
            default:
                return null;
        }
    }

    /* renamed from: com.ua.sdk.recorder.datasource.derived.DerivedDataSourceConfigurationImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType;

        static {
            int[] iArr = new int[DerivedDataSourceConfiguration.DataSourceType.values().length];
            $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType = iArr;
            try {
                iArr[DerivedDataSourceConfiguration.DataSourceType.BEARING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType[DerivedDataSourceConfiguration.DataSourceType.CYCLING_POWER_SUMMARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType[DerivedDataSourceConfiguration.DataSourceType.DISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType[DerivedDataSourceConfiguration.DataSourceType.ELEVATION_SUMMARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType[DerivedDataSourceConfiguration.DataSourceType.ENERGY_EXPENDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType[DerivedDataSourceConfiguration.DataSourceType.HEART_RATE_SUMMARY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType[DerivedDataSourceConfiguration.DataSourceType.INTENSITY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType[DerivedDataSourceConfiguration.DataSourceType.LOCATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType[DerivedDataSourceConfiguration.DataSourceType.RUN_CADENCE_SUMMARY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType[DerivedDataSourceConfiguration.DataSourceType.SPEED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$DerivedDataSourceConfiguration$DataSourceType[DerivedDataSourceConfiguration.DataSourceType.SPEED_SUMMARY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }
}
