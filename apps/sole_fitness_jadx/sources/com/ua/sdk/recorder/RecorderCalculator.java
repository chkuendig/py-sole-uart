package com.ua.sdk.recorder;

import com.ua.sdk.UaLog;
import com.ua.sdk.datapoint.DataFrame;
import com.ua.sdk.datapoint.DataFrameImpl;
import com.ua.sdk.datapoint.DataPoint;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.datasource.DataSource;
import com.ua.sdk.recorder.datasource.derived.DerivedDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class RecorderCalculator {
    private static final String TAG = "RecordSessionCalculator";
    private RecorderCalculatorListener listener;
    private List<DataSourceIdentifier> messageUpdatedDataSourceIdentifiers;
    private Set<DataTypeRef> messageUpdatedDataTypes;
    private boolean messageUpdatedSegmentState;
    private boolean messageUpdatedTime;
    private RecorderContext recorderContext;
    private boolean segmentStarted = false;
    private double segmentStartTimestamp = Double.NaN;
    private double segmentStopTimestamp = Double.NaN;
    private double activeTimeAdjustment = Double.NaN;
    private double activeTime = Double.NaN;
    private double firstSegmentStartTime = Double.NaN;
    private double elapsedTime = Double.NaN;
    private Map<String, DataPoint> dataPoints = new HashMap();
    private List<DataSource> dataSources = new ArrayList();
    private Map<DataTypeRef, List<DerivedDataSource>> derivedDataSourceTriggers = new HashMap();
    private Map<DataTypeRef, DataSourceIdentifier> primaryDataSource = new HashMap();

    protected interface RecorderCalculatorListener {
        boolean isDataTypeObserved(DataTypeRef dataTypeRef);

        boolean isSegmentStateObserved();

        boolean isTimeObserved();

        void onDataTypeUpdated(DataFrameImpl dataFrameImpl);

        void onSegmentStateUpdated(DataFrameImpl dataFrameImpl);

        void onTimeUpdated(DataFrameImpl dataFrameImpl);

        void storeDataFrame(DataFrame dataFrame);
    }

    public RecorderCalculator(RecorderContext recorderContext, RecorderCalculatorListener recorderCalculatorListener) {
        this.recorderContext = recorderContext;
        this.listener = recorderCalculatorListener;
    }

    public List<DataSource> getDataSources() {
        return this.dataSources;
    }

    private Map<String, DataPoint> getDataPoints() {
        return new HashMap(this.dataPoints);
    }

    private Map<DataTypeRef, DataSourceIdentifier> getPrimaryDataSources() {
        return new HashMap(this.primaryDataSource);
    }

    public void onProcessMessage(Message message) {
        DataFrameImpl dataFrameImplCreateDataFrame;
        this.messageUpdatedDataTypes = new HashSet();
        this.messageUpdatedDataSourceIdentifiers = new ArrayList();
        this.messageUpdatedTime = false;
        this.messageUpdatedSegmentState = false;
        message.processMessage(this);
        if (this.messageUpdatedDataTypes.isEmpty() || this.messageUpdatedDataTypes.size() != this.messageUpdatedDataSourceIdentifiers.size()) {
            dataFrameImplCreateDataFrame = null;
        } else {
            Iterator<DataTypeRef> it = this.messageUpdatedDataTypes.iterator();
            while (it.hasNext()) {
                if (this.listener.isDataTypeObserved(it.next())) {
                    dataFrameImplCreateDataFrame = createDataFrame(this.messageUpdatedDataTypes, this.messageUpdatedDataSourceIdentifiers);
                    this.listener.onDataTypeUpdated(dataFrameImplCreateDataFrame);
                    break;
                }
            }
            dataFrameImplCreateDataFrame = null;
        }
        if (this.messageUpdatedTime && this.listener.isTimeObserved()) {
            if (dataFrameImplCreateDataFrame == null) {
                dataFrameImplCreateDataFrame = createDataFrame();
            }
            this.listener.onTimeUpdated(dataFrameImplCreateDataFrame);
        }
        if (this.messageUpdatedSegmentState && this.listener.isSegmentStateObserved()) {
            if (dataFrameImplCreateDataFrame == null) {
                dataFrameImplCreateDataFrame = createDataFrame();
            }
            this.listener.onSegmentStateUpdated(dataFrameImplCreateDataFrame);
        }
        if (dataFrameImplCreateDataFrame == null) {
            dataFrameImplCreateDataFrame = createDataFrame();
        }
        this.listener.storeDataFrame(dataFrameImplCreateDataFrame);
    }

    public void updateDataPoint(DataSourceIdentifier dataSourceIdentifier, DataPoint dataPoint, DataTypeRef dataTypeRef) {
        this.dataPoints.put(TypeSourceKey.createDataPointKey(dataTypeRef, dataSourceIdentifier), dataPoint);
        if (this.messageUpdatedDataTypes.add(dataTypeRef)) {
            this.messageUpdatedDataSourceIdentifiers.add(dataSourceIdentifier);
        }
        if (this.derivedDataSourceTriggers.containsKey(dataTypeRef)) {
            Iterator<DerivedDataSource> it = this.derivedDataSourceTriggers.get(dataTypeRef).iterator();
            while (it.hasNext()) {
                it.next().deriveDataPoint(this, dataSourceIdentifier, dataTypeRef, dataPoint);
            }
        }
        UaLog.info("RecordSessionCalculator." + dataTypeRef.getId());
    }

    public void startSegment(DataSourceIdentifier dataSourceIdentifier, double d) {
        if (!this.segmentStarted) {
            if (Double.isNaN(this.segmentStartTimestamp)) {
                this.activeTimeAdjustment = d;
            } else {
                this.activeTimeAdjustment += d - this.segmentStopTimestamp;
            }
            this.segmentStartTimestamp = d;
            this.segmentStarted = true;
            if (Double.isNaN(this.firstSegmentStartTime)) {
                this.firstSegmentStartTime = d;
            }
            Iterator<DataSource> it = this.dataSources.iterator();
            while (it.hasNext()) {
                it.next().startSegment();
            }
            updateTime(dataSourceIdentifier, d);
            this.messageUpdatedSegmentState = true;
            UaLog.info("RecordSessionCalculator.startSegment " + d);
            return;
        }
        UaLog.warn("RecordSessionCalculator.startSegment ignored. already started.");
    }

    public void stopSegment(DataSourceIdentifier dataSourceIdentifier, double d) {
        if (this.segmentStarted) {
            this.segmentStopTimestamp = d;
            this.segmentStarted = false;
            Iterator<DataSource> it = this.dataSources.iterator();
            while (it.hasNext()) {
                it.next().stopSegment();
            }
            updateTime(dataSourceIdentifier, d);
            this.messageUpdatedSegmentState = true;
            UaLog.info("RecordSessionCalculator.stopSegment " + d);
            return;
        }
        UaLog.info("RecordSessionCalculator.stopSegment ignored. already started.");
    }

    public void updateTime(DataSourceIdentifier dataSourceIdentifier, double d) {
        if (!Double.isNaN(this.firstSegmentStartTime)) {
            this.elapsedTime = Math.round(d - this.firstSegmentStartTime);
            if (this.segmentStarted) {
                this.activeTime = Math.round(d - this.activeTimeAdjustment);
            }
        }
        this.messageUpdatedTime = true;
        UaLog.info("RecordSessionCalculator.updateTime " + d);
    }

    public void updateRecorderContext(RecorderContext recorderContext) {
        Iterator<DataSource> it = this.dataSources.iterator();
        while (it.hasNext()) {
            it.next().configure(recorderContext);
        }
    }

    public void addDataSource(DataSource dataSource) {
        this.dataSources.add(dataSource);
        DataSourceIdentifier dataSourceIdentifier = dataSource.getDataSourceIdentifier();
        Iterator<DataTypeRef> it = dataSource.getDataTypeRefs().iterator();
        while (it.hasNext()) {
            this.primaryDataSource.put(it.next(), dataSourceIdentifier);
        }
        if (dataSource instanceof DerivedDataSource) {
            DerivedDataSource derivedDataSource = (DerivedDataSource) dataSource;
            for (DataTypeRef dataTypeRef : derivedDataSource.getDataTypeRefTriggers()) {
                List<DerivedDataSource> arrayList = this.derivedDataSourceTriggers.get(dataTypeRef);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(derivedDataSource);
                this.derivedDataSourceTriggers.put(dataTypeRef, arrayList);
            }
        }
    }

    public void removeDataSource(DataSource dataSource) {
        this.dataSources.remove(dataSource);
    }

    public double getElapsedTime() {
        return this.elapsedTime;
    }

    public double getActiveTime() {
        return this.activeTime;
    }

    protected boolean isSegmentStarted() {
        return this.segmentStarted;
    }

    protected double getFirstSegmentStartTime() {
        return this.firstSegmentStartTime;
    }

    protected DataFrameImpl createDataFrame(Set<DataTypeRef> set, List<DataSourceIdentifier> list) {
        DataFrameImpl dataFrameImpl = new DataFrameImpl();
        dataFrameImpl.setDataPoints(getDataPoints());
        dataFrameImpl.setPrimaryDataSources(getPrimaryDataSources());
        dataFrameImpl.setFirstSegmentStartTime(Double.valueOf(getFirstSegmentStartTime()));
        dataFrameImpl.setActiveTime(Double.valueOf(getActiveTime()));
        dataFrameImpl.setElapsedTime(Double.valueOf(getElapsedTime()));
        dataFrameImpl.setSegmentStarted(isSegmentStarted());
        dataFrameImpl.setDataTypesChanged(set);
        dataFrameImpl.setDataSourceIdentifiersChanged(list);
        return dataFrameImpl;
    }

    protected DataFrameImpl createDataFrame() {
        return createDataFrame(null, null);
    }
}
