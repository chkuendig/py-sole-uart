package com.ua.sdk.recorder;

import android.content.Context;
import android.os.Handler;
import com.ua.sdk.EntityList;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.LocalDate;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.activitytype.ActivityType;
import com.ua.sdk.activitytype.ActivityTypeManager;
import com.ua.sdk.activitytype.ActivityTypeRef;
import com.ua.sdk.datapoint.DataFrame;
import com.ua.sdk.datapoint.DataFrameImpl;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.heartrate.HeartRateZones;
import com.ua.sdk.heartrate.HeartRateZonesListRef;
import com.ua.sdk.heartrate.HeartRateZonesManager;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.recorder.RecorderCalculator;
import com.ua.sdk.recorder.data.DataFrameObserver;
import com.ua.sdk.recorder.datasource.AbstractDataSourceConfiguration;
import com.ua.sdk.recorder.datasource.DataSource;
import com.ua.sdk.recorder.datasource.sensor.SensorDataSource;
import com.ua.sdk.recorder.producer.CommandProducer;
import com.ua.sdk.recorder.producer.MessageProducer;
import com.ua.sdk.recorder.producer.SensorMessageProducer;
import com.ua.sdk.recorder.producer.TimeProducer;
import com.ua.sdk.recorder.save.RecorderWorkoutConverterImpl;
import com.ua.sdk.user.User;
import com.ua.sdk.user.UserManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class RecorderImpl implements Recorder {
    private static final int HANDLER_DISPATCH_DATA_TYPE_OBSERVERS = 1;
    private static final int HANDLER_DISPATCH_SEGMENT_STATE_OBSERVERS = 3;
    private static final int HANDLER_DISPATCH_SENSOR_STATE_OBSERVERS = 2;
    private static final int HANDLER_DISPATCH_TIME_OBSERVERS = 4;
    private ActivityTypeManager activityTypeManager;
    private CommandProducer commandProducer;
    private RecorderConfigurationImpl configuration;
    private Context context;
    private HeartRateZonesManager heartRateZonesManager;
    private boolean isConfigured;
    private boolean isConfiguring;
    private boolean isDestroying;
    private MessageQueue processorMessageQueue;
    private RecorderManagerImpl recordManager;
    private RecordProcessor recordProcessor;
    private RecorderCalculator recorderCalculator;
    private RecorderContext recorderContext;
    private SensorMessageProducer sensorMessageProducer;
    private TimeProducer timeProducer;
    private UserManager userManager;
    private List<MessageProducer> messageProducers = new ArrayList();
    private Map<DataTypeRef, List<DataFrameObserver>> dataFrameObservers = new ConcurrentHashMap();
    private List<SensorDataSourceObserver> sensorDataSourceObservers = new ArrayList();
    private List<RecorderObserver> recorderObservers = new ArrayList();
    private MyRecordSessionHandler handler = new MyRecordSessionHandler();

    @Deprecated
    private List<DataFrame> dataFrames = new ArrayList();

    protected interface RecorderConfigureCallback {
        void onConfigureFailed(UaException uaException);

        void onConfigureSuccess();
    }

    public RecorderImpl(RecorderConfiguration recorderConfiguration, Context context, UserManager userManager, ActivityTypeManager activityTypeManager, HeartRateZonesManager heartRateZonesManager, RecorderManagerImpl recorderManagerImpl) throws NullPointerException {
        this.configuration = (RecorderConfigurationImpl) Precondition.isNotNull(recorderConfiguration);
        this.context = (Context) Precondition.isNotNull(context);
        this.userManager = (UserManager) Precondition.isNotNull(userManager);
        this.activityTypeManager = (ActivityTypeManager) Precondition.isNotNull(activityTypeManager);
        this.heartRateZonesManager = (HeartRateZonesManager) Precondition.isNotNull(heartRateZonesManager);
        this.recordManager = (RecorderManagerImpl) Precondition.isNotNull(recorderManagerImpl);
        Precondition.isNotNull(this.configuration.getName(), "recorder name");
        Precondition.isNotNull(this.configuration.getActivityTypeRef(), "activity type");
        Precondition.isNotNull(this.configuration.getUserRef(), "user ref");
    }

    void configure(RecorderConfigureCallback recorderConfigureCallback) {
        this.isConfiguring = true;
        this.isConfigured = false;
        RecorderContext recorderContext = new RecorderContext();
        this.recorderContext = recorderContext;
        recorderContext.setApplicationContext(this.context);
        this.recorderContext.setName(this.configuration.getName());
        RecorderClock recorderClock = new RecorderClock();
        recorderClock.init();
        this.recorderContext.setClock(recorderClock);
        MessageQueue messageQueue = new MessageQueue();
        this.processorMessageQueue = messageQueue;
        CommandProducer commandProducer = new CommandProducer(recorderClock, messageQueue);
        this.commandProducer = commandProducer;
        this.messageProducers.add(commandProducer);
        TimeProducer timeProducer = new TimeProducer(recorderClock, this.processorMessageQueue);
        this.timeProducer = timeProducer;
        this.messageProducers.add(timeProducer);
        SensorMessageProducer sensorMessageProducer = new SensorMessageProducer(recorderClock, this.processorMessageQueue);
        this.sensorMessageProducer = sensorMessageProducer;
        this.messageProducers.add(sensorMessageProducer);
        this.userManager.fetchUser(this.configuration.getUserRef(), new MyFetchUserCallback(recorderConfigureCallback));
    }

    void onPostConfigureLoad(RecorderConfigureCallback recorderConfigureCallback) throws IllegalArgumentException {
        this.recorderCalculator = new RecorderCalculator(this.recorderContext, new MyRecordCalculatorListener());
        this.recordProcessor = new RecordProcessor(this.configuration.getName(), this.processorMessageQueue, this.recorderCalculator);
        this.isConfigured = true;
        Iterator<MessageProducer> it = this.messageProducers.iterator();
        while (it.hasNext()) {
            it.next().beginRecorder();
        }
        Iterator<DataSourceConfiguration> it2 = this.configuration.getDataSourceConfigurations().iterator();
        while (it2.hasNext()) {
            addDataSource(it2.next(), false);
        }
        this.dataFrames.add(this.recorderCalculator.createDataFrame());
        this.recordProcessor.begin();
        this.isConfiguring = false;
        recorderConfigureCallback.onConfigureSuccess();
        if (this.isDestroying) {
            destroyRecorder();
        }
    }

    @Override // com.ua.sdk.recorder.Recorder
    public void startSegment() {
        checkConfigured();
        this.commandProducer.produceStartSegment();
    }

    @Override // com.ua.sdk.recorder.Recorder
    public void stopSegment() {
        checkConfigured();
        this.commandProducer.produceStopSegment();
    }

    @Override // com.ua.sdk.recorder.Recorder
    public void destroy() throws IllegalArgumentException {
        checkConfigured();
        this.isConfigured = false;
        this.isDestroying = true;
        if (this.isConfiguring) {
            return;
        }
        destroyRecorder();
    }

    private void destroyRecorder() throws IllegalArgumentException {
        this.recordProcessor.finish();
        Iterator<MessageProducer> it = this.messageProducers.iterator();
        while (it.hasNext()) {
            it.next().finishRecorder();
        }
        Iterator<DataSource> it2 = this.recorderCalculator.getDataSources().iterator();
        while (it2.hasNext()) {
            it2.next().disconnectDataSource();
        }
        this.recordManager.destroyRecorder(this.configuration.getName());
    }

    @Override // com.ua.sdk.recorder.Recorder
    public DataFrame getDataFrame() {
        checkConfigured();
        if (this.dataFrames.isEmpty()) {
            return null;
        }
        return this.dataFrames.get(r0.size() - 1);
    }

    @Override // com.ua.sdk.recorder.Recorder
    public List<DataFrame> getAllDataFrames() {
        checkConfigured();
        return new ArrayList(this.dataFrames);
    }

    @Override // com.ua.sdk.recorder.Recorder
    public RecorderWorkoutConverter getRecorderWorkoutConverter() {
        checkConfigured();
        return new RecorderWorkoutConverterImpl(getAllDataFrames(), this.recorderContext);
    }

    @Override // com.ua.sdk.recorder.Recorder
    public void addDataSource(DataSourceConfiguration dataSourceConfiguration) {
        addDataSource(dataSourceConfiguration, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void addDataSource(DataSourceConfiguration dataSourceConfiguration, boolean z) {
        checkConfigured();
        DataSource dataSourceBuild = ((AbstractDataSourceConfiguration) dataSourceConfiguration).build(this.sensorMessageProducer, new MySensorDataSourceListener());
        dataSourceBuild.configure(this.recorderContext);
        dataSourceBuild.connectDataSource();
        this.recorderCalculator.addDataSource(dataSourceBuild);
        if (z) {
            this.recordManager.addDataSourceRecorderCache(dataSourceConfiguration);
        }
    }

    @Override // com.ua.sdk.recorder.Recorder
    public boolean removeDataSource(DataSourceIdentifier dataSourceIdentifier) {
        checkConfigured();
        for (DataSource dataSource : this.recorderCalculator.getDataSources()) {
            if (dataSource.getDataSourceIdentifier().equals(dataSourceIdentifier)) {
                dataSource.disconnectDataSource();
                this.recorderCalculator.removeDataSource(dataSource);
                this.recordManager.removeDataSourceRecorderCache(dataSourceIdentifier);
                return true;
            }
        }
        return false;
    }

    @Override // com.ua.sdk.recorder.Recorder
    public void updateRecorderActivityType(ActivityTypeRef activityTypeRef) {
        checkConfigured();
        this.activityTypeManager.fetchActivityType(activityTypeRef, new MyUpdateActivityTypeFetchCallback());
    }

    @Override // com.ua.sdk.recorder.Recorder
    public List<DataSourceIdentifier> getDataSources() {
        checkConfigured();
        ArrayList arrayList = new ArrayList();
        Iterator<DataSource> it = this.recorderCalculator.getDataSources().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getDataSourceIdentifier());
        }
        return arrayList;
    }

    @Override // com.ua.sdk.recorder.Recorder
    public void addDataFrameObserver(DataFrameObserver dataFrameObserver, DataTypeRef... dataTypeRefArr) {
        DataFrameImpl dataFrameImpl = (DataFrameImpl) getDataFrame();
        for (DataTypeRef dataTypeRef : dataTypeRefArr) {
            List<DataFrameObserver> arrayList = this.dataFrameObservers.get(dataTypeRef);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.dataFrameObservers.put(dataTypeRef, arrayList);
            }
            arrayList.add(dataFrameObserver);
            if (dataFrameImpl != null && dataFrameImpl.getDataPoint(dataTypeRef) != null && dataFrameImpl.getPrimaryDataSources().containsKey(dataTypeRef)) {
                dispatchDataFrame(dataFrameImpl.getPrimaryDataSources().get(dataTypeRef), dataTypeRef, dataFrameImpl);
            }
        }
    }

    @Override // com.ua.sdk.recorder.Recorder
    public void removeDataFrameObserver(DataFrameObserver dataFrameObserver) {
        Iterator<Map.Entry<DataTypeRef, List<DataFrameObserver>>> it = this.dataFrameObservers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<DataTypeRef, List<DataFrameObserver>> next = it.next();
            next.getValue().remove(dataFrameObserver);
            if (next.getValue().isEmpty()) {
                it.remove();
            }
        }
    }

    @Override // com.ua.sdk.recorder.Recorder
    public void addSensorDataSourceObserver(SensorDataSourceObserver sensorDataSourceObserver) {
        checkConfigured();
        this.sensorDataSourceObservers.add(sensorDataSourceObserver);
        for (DataSource dataSource : this.recorderCalculator.getDataSources()) {
            if (dataSource instanceof SensorDataSource) {
                DataSourceIdentifier dataSourceIdentifier = dataSource.getDataSourceIdentifier();
                SensorDataSource sensorDataSource = (SensorDataSource) dataSource;
                sensorDataSourceObserver.onSensorDataSourceStatus(dataSourceIdentifier, sensorDataSource.getSensorStatus(), sensorDataSource.getSensorHealth());
            }
        }
    }

    @Override // com.ua.sdk.recorder.Recorder
    public void removeSensorDataSourceObserver(SensorDataSourceObserver sensorDataSourceObserver) {
        this.sensorDataSourceObservers.remove(sensorDataSourceObserver);
    }

    @Override // com.ua.sdk.recorder.Recorder
    public void addRecorderObserver(RecorderObserver recorderObserver) {
        checkConfigured();
        this.recorderObservers.add(recorderObserver);
    }

    @Override // com.ua.sdk.recorder.Recorder
    public void removeRecorderObserver(RecorderObserver recorderObserver) {
        this.recorderObservers.remove(recorderObserver);
    }

    protected void dispatchDataFrame(DataSourceIdentifier dataSourceIdentifier, DataTypeRef dataTypeRef, DataFrame dataFrame) {
        this.handler.sendMessage(this.handler.obtainMessage(1, new DataFrameObserverData(dataSourceIdentifier, dataTypeRef, dataFrame)));
    }

    protected void dispatchTime(DataFrameImpl dataFrameImpl) {
        this.handler.sendMessage(this.handler.obtainMessage(4, dataFrameImpl));
    }

    protected void dispatchSegmentState(DataFrameImpl dataFrameImpl) {
        this.handler.sendMessage(this.handler.obtainMessage(3, dataFrameImpl));
    }

    protected void dispatchSensorStateChanged(DataSourceIdentifier dataSourceIdentifier, SensorStatus sensorStatus, SensorHealth sensorHealth) {
        this.handler.sendMessage(this.handler.obtainMessage(2, new SensorDataSourceObserverData(dataSourceIdentifier, sensorStatus, sensorHealth)));
    }

    private void checkConfigured() {
        if (!this.isConfigured) {
            throw new IllegalStateException("Cannot call method before configure callback is called");
        }
        if (this.isDestroying) {
            throw new IllegalStateException("Cannot call method after destroy is called");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAge(User user) {
        LocalDate birthdate = user.getBirthdate();
        Calendar calendar = Calendar.getInstance();
        if (birthdate == null) {
            return 35;
        }
        int year = calendar.get(1) - birthdate.getYear();
        return (calendar.get(2) >= birthdate.getMonth() && (calendar.get(2) != birthdate.getMonth() || calendar.get(5) >= birthdate.getDayOfMonth())) ? year : year - 1;
    }

    protected class MyRecordCalculatorListener implements RecorderCalculator.RecorderCalculatorListener {
        protected MyRecordCalculatorListener() {
        }

        @Override // com.ua.sdk.recorder.RecorderCalculator.RecorderCalculatorListener
        public void storeDataFrame(DataFrame dataFrame) {
            RecorderImpl.this.dataFrames.add(dataFrame);
        }

        @Override // com.ua.sdk.recorder.RecorderCalculator.RecorderCalculatorListener
        public boolean isDataTypeObserved(DataTypeRef dataTypeRef) {
            return RecorderImpl.this.dataFrameObservers.containsKey(dataTypeRef);
        }

        @Override // com.ua.sdk.recorder.RecorderCalculator.RecorderCalculatorListener
        public void onDataTypeUpdated(DataFrameImpl dataFrameImpl) {
            List<DataSourceIdentifier> dataSourceIdentifiersChanged = dataFrameImpl.getDataSourceIdentifiersChanged();
            Iterator<DataTypeRef> it = dataFrameImpl.getDataTypesChanged().iterator();
            int i = 0;
            while (it.hasNext()) {
                RecorderImpl.this.dispatchDataFrame(dataSourceIdentifiersChanged.get(i), it.next(), dataFrameImpl);
                i++;
            }
        }

        @Override // com.ua.sdk.recorder.RecorderCalculator.RecorderCalculatorListener
        public boolean isTimeObserved() {
            return !RecorderImpl.this.recorderObservers.isEmpty();
        }

        @Override // com.ua.sdk.recorder.RecorderCalculator.RecorderCalculatorListener
        public void onTimeUpdated(DataFrameImpl dataFrameImpl) {
            RecorderImpl.this.dispatchTime(dataFrameImpl);
        }

        @Override // com.ua.sdk.recorder.RecorderCalculator.RecorderCalculatorListener
        public boolean isSegmentStateObserved() {
            return !RecorderImpl.this.recorderObservers.isEmpty();
        }

        @Override // com.ua.sdk.recorder.RecorderCalculator.RecorderCalculatorListener
        public void onSegmentStateUpdated(DataFrameImpl dataFrameImpl) {
            RecorderImpl.this.dispatchSegmentState(dataFrameImpl);
        }
    }

    protected class MySensorDataSourceListener implements SensorDataSource.SensorDataSourceListener {
        protected MySensorDataSourceListener() {
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.SensorDataSource.SensorDataSourceListener
        public void onSensorStateChanged(DataSourceIdentifier dataSourceIdentifier, SensorStatus sensorStatus, SensorHealth sensorHealth) {
            if (RecorderImpl.this.sensorDataSourceObservers == null || RecorderImpl.this.sensorDataSourceObservers.isEmpty()) {
                return;
            }
            RecorderImpl.this.dispatchSensorStateChanged(dataSourceIdentifier, sensorStatus, sensorHealth);
        }
    }

    protected class MyRecordSessionHandler extends Handler {
        protected MyRecordSessionHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 1) {
                DataFrameObserverData dataFrameObserverData = (DataFrameObserverData) message.obj;
                List list = (List) RecorderImpl.this.dataFrameObservers.get(dataFrameObserverData.dataTypeRef);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((DataFrameObserver) it.next()).onDataFrameUpdated(dataFrameObserverData.dataSourceIdentifier, dataFrameObserverData.dataTypeRef, dataFrameObserverData.dataFrame);
                    }
                    return;
                }
                return;
            }
            if (i == 2) {
                SensorDataSourceObserverData sensorDataSourceObserverData = (SensorDataSourceObserverData) message.obj;
                Iterator it2 = RecorderImpl.this.sensorDataSourceObservers.iterator();
                while (it2.hasNext()) {
                    ((SensorDataSourceObserver) it2.next()).onSensorDataSourceStatus(sensorDataSourceObserverData.dataSourceIdentifier, sensorDataSourceObserverData.status, sensorDataSourceObserverData.health);
                }
                return;
            }
            if (i == 3) {
                Iterator it3 = RecorderImpl.this.recorderObservers.iterator();
                while (it3.hasNext()) {
                    ((RecorderObserver) it3.next()).onSegmentStateUpdated((DataFrameImpl) message.obj);
                }
            } else {
                if (i == 4) {
                    DataFrameImpl dataFrameImpl = (DataFrameImpl) message.obj;
                    double dDoubleValue = dataFrameImpl.getActiveTime().doubleValue();
                    double dDoubleValue2 = dataFrameImpl.getElapsedTime().doubleValue();
                    Iterator it4 = RecorderImpl.this.recorderObservers.iterator();
                    while (it4.hasNext()) {
                        ((RecorderObserver) it4.next()).onTimeUpdated(dDoubleValue, dDoubleValue2);
                    }
                    return;
                }
                UaLog.error("RecordSessionImpl unknown handler what");
            }
        }
    }

    private class MyFetchUserCallback implements FetchCallback<User> {
        private RecorderConfigureCallback callback;

        private MyFetchUserCallback(RecorderConfigureCallback recorderConfigureCallback) {
            this.callback = recorderConfigureCallback;
        }

        @Override // com.ua.sdk.FetchCallback
        public void onFetched(User user, UaException uaException) {
            if (user != null) {
                RecorderImpl.this.recorderContext.setUser(user);
                RecorderImpl.this.activityTypeManager.fetchActivityType(RecorderImpl.this.configuration.getActivityTypeRef(), new MyFetchActivityTypeCallback(this.callback));
            } else {
                this.callback.onConfigureFailed(uaException);
            }
        }
    }

    private class MyFetchActivityTypeCallback implements FetchCallback<ActivityType> {
        private RecorderConfigureCallback callback;

        private MyFetchActivityTypeCallback(RecorderConfigureCallback recorderConfigureCallback) {
            this.callback = recorderConfigureCallback;
        }

        @Override // com.ua.sdk.FetchCallback
        public void onFetched(ActivityType activityType, UaException uaException) {
            if (activityType != null) {
                RecorderImpl.this.recorderContext.setActivityType(activityType);
                RecorderImpl.this.heartRateZonesManager.fetchHeartRateZonesList(HeartRateZonesListRef.getBuilder().setUser(RecorderImpl.this.recorderContext.getUser().getRef()).build(), new MyFetchHeartRateZonesCallback(this.callback));
            } else {
                this.callback.onConfigureFailed(uaException);
            }
        }
    }

    private class MyFetchHeartRateZonesCallback implements FetchCallback<EntityList<HeartRateZones>> {
        private RecorderConfigureCallback callback;

        private MyFetchHeartRateZonesCallback(RecorderConfigureCallback recorderConfigureCallback) {
            this.callback = recorderConfigureCallback;
        }

        @Override // com.ua.sdk.FetchCallback
        public void onFetched(EntityList<HeartRateZones> entityList, UaException uaException) throws IllegalArgumentException {
            if (uaException != null) {
                this.callback.onConfigureFailed(uaException);
            }
            if (entityList == null || entityList.isEmpty()) {
                RecorderContext recorderContext = RecorderImpl.this.recorderContext;
                HeartRateZonesManager heartRateZonesManager = RecorderImpl.this.heartRateZonesManager;
                RecorderImpl recorderImpl = RecorderImpl.this;
                recorderContext.setHeartRateZones(heartRateZonesManager.calculateHeartRateZonesWithAge(recorderImpl.getAge(recorderImpl.recorderContext.getUser())));
            } else {
                RecorderImpl.this.recorderContext.setHeartRateZones(entityList.get(0));
            }
            RecorderImpl.this.onPostConfigureLoad(this.callback);
        }
    }

    private class MyUpdateActivityTypeFetchCallback implements FetchCallback<ActivityType> {
        private MyUpdateActivityTypeFetchCallback() {
        }

        @Override // com.ua.sdk.FetchCallback
        public void onFetched(ActivityType activityType, UaException uaException) {
            if (uaException == null) {
                RecorderImpl.this.recorderContext.setActivityType(activityType);
                RecorderImpl.this.commandProducer.produceRecorderContext(RecorderImpl.this.recorderContext);
            }
        }
    }

    private static class DataFrameObserverData {
        DataFrame dataFrame;
        DataSourceIdentifier dataSourceIdentifier;
        DataTypeRef dataTypeRef;

        DataFrameObserverData(DataSourceIdentifier dataSourceIdentifier, DataTypeRef dataTypeRef, DataFrame dataFrame) {
            this.dataSourceIdentifier = dataSourceIdentifier;
            this.dataTypeRef = dataTypeRef;
            this.dataFrame = dataFrame;
        }
    }

    private static class SensorDataSourceObserverData {
        DataSourceIdentifier dataSourceIdentifier;
        SensorHealth health;
        SensorStatus status;

        SensorDataSourceObserverData(DataSourceIdentifier dataSourceIdentifier, SensorStatus sensorStatus, SensorHealth sensorHealth) {
            this.dataSourceIdentifier = dataSourceIdentifier;
            this.status = sensorStatus;
            this.health = sensorHealth;
        }
    }
}
