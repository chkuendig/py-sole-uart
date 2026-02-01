package com.soletreadmills.sole_v2.ble.manager;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.digifly.ble.data.wear.WearHrData;
import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2.ble.data.CrossTrainerData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.HrData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import com.soletreadmills.sole_v2.ble.data.RowerData;
import com.soletreadmills.sole_v2.ble.data.StepClimberData;
import com.soletreadmills.sole_v2.ble.data.TreadmillData;
import com.soletreadmills.sole_v2.ble.listener.UploadSummaryDataListener;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineFeatureType;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class BleDataManager {
    private static BleDataManager manager;
    public static WearHrData nowWearHrData = new WearHrData();
    private Handler handler;
    private HandlerThread handlerThread;
    private final String TAG = "BleDataManager";
    private ArrayList<FtmsBaseData> nowFtmsDataArrayList = new ArrayList<>();
    private ArrayList<FtmsBaseData> summaryFtmsDataList = null;
    private FtmsBaseData oldFtmsBaseData = null;
    private FtmsBaseData firstFtmsData = null;
    private ArrayList<FitnessMachineFeatureType> fitnessMachineFeatureList = null;
    private HrData nowHrData = null;
    private HrData oldHrData = null;
    private WearHrData oldWearHrData = null;
    private TrainingStatusType nowTrainingStatusType = null;
    private TrainingStatusType oldTrainingStatusType = null;
    private FitnessMachineStatusType nowFitnessMachineStatusType = null;
    private FitnessMachineStatusType nowFMSTypeOnlyFourType = null;
    private FitnessMachineStatusType oldFitnessMachineStatusType = null;
    private UploadSummaryDataListener uploadSummaryDataListener = null;

    @SerializedName("class_id")
    private String classId = null;

    @SerializedName("class_type")
    private String classType = null;

    @SerializedName("class_name")
    private String className = null;
    private final CountDownTimer summaryDataUploadCountDownTimer = new CountDownTimer(30000, 1000) { // from class: com.soletreadmills.sole_v2.ble.manager.BleDataManager.3
        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            Timber.d("summaryDataUploadCountDownTimer -> onTick sec=%s", Long.valueOf(millisUntilFinished / 1000));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            synchronized (BleDataManager.class) {
                Timber.d("summaryDataUploadCountDownTimer -> onFinish", new Object[0]);
                if (BleDataManager.this.getNowFitnessMachineStatusType() == FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER) {
                    BleDataManager.this.restartSummaryDataUploadCountDownTimer();
                } else {
                    BleDataManager.this.uploadSummaryData();
                }
            }
        }
    };

    private BleDataManager() {
    }

    public static BleDataManager getInstance() {
        if (manager == null) {
            synchronized (BleDataManager.class) {
                if (manager == null) {
                    manager = new BleDataManager();
                }
            }
        }
        return manager;
    }

    public void onCreate() {
        synchronized (BleDataManager.class) {
            Timber.d("onCreate", new Object[0]);
            HandlerThread handlerThread = new HandlerThread(this.TAG + HandlerThread.class.getSimpleName(), 10);
            this.handlerThread = handlerThread;
            handlerThread.start();
            this.handler = new Handler(this.handlerThread.getLooper());
        }
    }

    public void onDestroy() {
        synchronized (BleDataManager.class) {
            Timber.d("onDestroy", new Object[0]);
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.handler = null;
            HandlerThread handlerThread = this.handlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.handlerThread = null;
            this.nowFtmsDataArrayList = new ArrayList<>();
            clearSummaryData();
            this.oldFtmsBaseData = null;
            setFitnessMachineFeatureList(null);
            this.nowHrData = null;
            this.oldHrData = null;
        }
    }

    public void virtualRaceFix(final FtmsBaseData ftmsBaseData) {
        if (this.firstFtmsData != null) {
            Integer elapsedTime = ftmsBaseData != null ? ftmsBaseData.getElapsedTime() : null;
            FtmsBaseData ftmsBaseData2 = this.firstFtmsData;
            Integer elapsedTime2 = ftmsBaseData2 != null ? ftmsBaseData2.getElapsedTime() : null;
            ftmsBaseData.setElapsedTime(Integer.valueOf((elapsedTime != null ? elapsedTime.intValue() : 0) - (elapsedTime2 != null ? elapsedTime2.intValue() : 0)));
            Integer totalEnergy = ftmsBaseData != null ? ftmsBaseData.getTotalEnergy() : null;
            FtmsBaseData ftmsBaseData3 = this.firstFtmsData;
            Integer totalEnergy2 = ftmsBaseData3 != null ? ftmsBaseData3.getTotalEnergy() : null;
            ftmsBaseData.setTotalEnergy(Integer.valueOf((totalEnergy != null ? totalEnergy.intValue() : 0) - (totalEnergy2 != null ? totalEnergy2.intValue() : 0)));
            if (ftmsBaseData instanceof TreadmillData) {
                FtmsBaseData ftmsBaseData4 = this.firstFtmsData;
                if (ftmsBaseData4 instanceof TreadmillData) {
                    TreadmillData treadmillData = (TreadmillData) ftmsBaseData;
                    TreadmillData treadmillData2 = (TreadmillData) ftmsBaseData4;
                    Integer totalDistance = treadmillData != null ? treadmillData.getTotalDistance() : null;
                    Integer totalDistance2 = treadmillData2 != null ? treadmillData2.getTotalDistance() : null;
                    treadmillData.setTotalDistance(Integer.valueOf((totalDistance != null ? totalDistance.intValue() : 0) - (totalDistance2 != null ? totalDistance2.intValue() : 0)));
                    Double positiveElevationGain = treadmillData.getPositiveElevationGain();
                    Double positiveElevationGain2 = treadmillData2 != null ? treadmillData2.getPositiveElevationGain() : null;
                    treadmillData.setPositiveElevationGain(Double.valueOf(Math.max((positiveElevationGain != null ? positiveElevationGain.doubleValue() : 0.0d) - (positiveElevationGain2 != null ? positiveElevationGain2.doubleValue() : 0.0d), AudioStats.AUDIO_AMPLITUDE_NONE)));
                }
            }
            if (ftmsBaseData instanceof IndoorBikeData) {
                boolean z = this.firstFtmsData instanceof IndoorBikeData;
            }
            if (ftmsBaseData instanceof CrossTrainerData) {
                boolean z2 = this.firstFtmsData instanceof CrossTrainerData;
            }
            if (ftmsBaseData instanceof StepClimberData) {
                boolean z3 = this.firstFtmsData instanceof StepClimberData;
            }
            if (ftmsBaseData instanceof RowerData) {
                boolean z4 = this.firstFtmsData instanceof RowerData;
            }
        }
    }

    public void addFtmsData(final FtmsBaseData ftmsBaseData) {
        Handler handler;
        if (ftmsBaseData == null || (handler = this.handler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.BleDataManager.1
            /* JADX WARN: Removed duplicated region for block: B:71:0x01e3 A[Catch: all -> 0x02da, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0010, B:8:0x0016, B:10:0x0022, B:12:0x002a, B:14:0x0036, B:16:0x0046, B:18:0x0052, B:23:0x0071, B:25:0x0077, B:27:0x0081, B:29:0x0099, B:31:0x00b5, B:21:0x006b, B:32:0x00c4, B:34:0x00d0, B:36:0x00f4, B:37:0x0103, B:39:0x010b, B:41:0x0117, B:43:0x0123, B:45:0x013c, B:47:0x0142, B:49:0x014a, B:51:0x015e, B:52:0x016d, B:54:0x0175, B:56:0x0181, B:58:0x018e, B:60:0x019a, B:62:0x01a6, B:64:0x01bf, B:66:0x01c5, B:68:0x01cd, B:71:0x01e3, B:73:0x01eb, B:74:0x01ef, B:76:0x01f7, B:78:0x0203, B:80:0x0213, B:82:0x0219, B:84:0x0241, B:86:0x024c, B:88:0x0257, B:90:0x0263, B:92:0x026f, B:94:0x027b, B:95:0x028a, B:97:0x028e, B:99:0x0296, B:100:0x02a5, B:101:0x02d1, B:102:0x02d8), top: B:109:0x0003, inners: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:73:0x01eb A[Catch: all -> 0x02da, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0010, B:8:0x0016, B:10:0x0022, B:12:0x002a, B:14:0x0036, B:16:0x0046, B:18:0x0052, B:23:0x0071, B:25:0x0077, B:27:0x0081, B:29:0x0099, B:31:0x00b5, B:21:0x006b, B:32:0x00c4, B:34:0x00d0, B:36:0x00f4, B:37:0x0103, B:39:0x010b, B:41:0x0117, B:43:0x0123, B:45:0x013c, B:47:0x0142, B:49:0x014a, B:51:0x015e, B:52:0x016d, B:54:0x0175, B:56:0x0181, B:58:0x018e, B:60:0x019a, B:62:0x01a6, B:64:0x01bf, B:66:0x01c5, B:68:0x01cd, B:71:0x01e3, B:73:0x01eb, B:74:0x01ef, B:76:0x01f7, B:78:0x0203, B:80:0x0213, B:82:0x0219, B:84:0x0241, B:86:0x024c, B:88:0x0257, B:90:0x0263, B:92:0x026f, B:94:0x027b, B:95:0x028a, B:97:0x028e, B:99:0x0296, B:100:0x02a5, B:101:0x02d1, B:102:0x02d8), top: B:109:0x0003, inners: #0 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 733
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ble.manager.BleDataManager.AnonymousClass1.run():void");
            }
        });
    }

    public void addHrData(final HrData hrData) {
        Handler handler;
        if (hrData == null || hrData.getHr() == null || hrData.getHr().intValue() <= 0 || (handler = this.handler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.BleDataManager.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BleDataManager.class) {
                    Timber.d("addHrData", new Object[0]);
                    BleDataManager bleDataManager = BleDataManager.this;
                    bleDataManager.oldHrData = bleDataManager.nowHrData;
                    if (BleDataManager.this.nowFtmsDataArrayList.size() > 0) {
                        Iterator it = BleDataManager.this.nowFtmsDataArrayList.iterator();
                        while (it.hasNext()) {
                            FtmsBaseData ftmsBaseData = (FtmsBaseData) it.next();
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(ftmsBaseData.getCreateDate());
                            Calendar calendar2 = Calendar.getInstance();
                            calendar2.setTime(hrData.getCreateDate());
                            if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5) && calendar.get(11) == calendar2.get(11) && calendar.get(12) == calendar2.get(12) && calendar.get(13) == calendar2.get(13)) {
                                ftmsBaseData.setHeartRate(hrData.getHr());
                            }
                        }
                    }
                    BleDataManager.this.nowHrData = hrData;
                }
            }
        });
    }

    public void clearHrData() {
        this.nowHrData = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartSummaryDataUploadCountDownTimer() {
        synchronized (BleDataManager.class) {
            Timber.d("restartSummaryDataUploadCountDownTimer", new Object[0]);
            this.summaryDataUploadCountDownTimer.cancel();
            this.summaryDataUploadCountDownTimer.start();
        }
    }

    public void uploadSummaryData() {
        synchronized (BleDataManager.class) {
            Timber.d("uploadSummaryData", new Object[0]);
            this.summaryDataUploadCountDownTimer.cancel();
            if (createSummaryData()) {
                noticeUploadSummaryData();
            }
        }
    }

    private boolean createSummaryData() {
        synchronized (BleDataManager.class) {
            Timber.d("createSummaryData", new Object[0]);
            try {
                if (this.nowFtmsDataArrayList.size() > 0) {
                    clearSummaryData();
                    if (this.nowFtmsDataArrayList.size() == 1) {
                        this.nowFtmsDataArrayList = new ArrayList<>();
                        return false;
                    }
                    this.summaryFtmsDataList = this.nowFtmsDataArrayList;
                    this.nowFtmsDataArrayList = new ArrayList<>();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    private void noticeUploadSummaryData() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.BleDataManager.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (BleDataManager.class) {
                            Timber.d("noticeUploadSummaryData", new Object[0]);
                            if (BleDataManager.this.summaryFtmsDataList != null && BleDataManager.this.summaryFtmsDataList.size() > 0 && BleDataManager.this.uploadSummaryDataListener != null) {
                                ArrayList<FtmsBaseData> arrayList = new ArrayList<>(BleDataManager.this.summaryFtmsDataList);
                                Iterator<FtmsBaseData> it = arrayList.iterator();
                                String classId = null;
                                String classType = null;
                                String className = null;
                                while (it.hasNext()) {
                                    FtmsBaseData next = it.next();
                                    if (!TextUtils.isEmpty(next.getClassId()) && TextUtils.isEmpty(classId)) {
                                        classId = next.getClassId();
                                    }
                                    if (!TextUtils.isEmpty(next.getClassType()) && TextUtils.isEmpty(classType)) {
                                        classType = next.getClassType();
                                    }
                                    if (!TextUtils.isEmpty(next.getClassName()) && TextUtils.isEmpty(className)) {
                                        className = next.getClassName();
                                    }
                                    if (!TextUtils.isEmpty(classId) && !TextUtils.isEmpty(classType) && !TextUtils.isEmpty(className)) {
                                        break;
                                    }
                                }
                                BleDataManager.this.uploadSummaryDataListener.onNoticeUpload(arrayList, false, null, null);
                                BleDataManager.this.clearSummaryData();
                            }
                        }
                    } catch (Exception e) {
                        Timber.e(e);
                        BleDataManager.this.clearSummaryData();
                    }
                }
            });
        }
    }

    public void clearSummaryData() {
        synchronized (BleDataManager.class) {
            Timber.d("clearSummaryData", new Object[0]);
            ArrayList<FtmsBaseData> arrayList = this.summaryFtmsDataList;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.summaryFtmsDataList = null;
        }
    }

    public void setUploadSummaryDataListener(UploadSummaryDataListener uploadSummaryDataListener) {
        synchronized (BleDataManager.class) {
            this.uploadSummaryDataListener = uploadSummaryDataListener;
        }
    }

    public ArrayList<FtmsBaseData> getSummaryFtmsDataList() {
        ArrayList<FtmsBaseData> arrayList;
        synchronized (BleDataManager.class) {
            arrayList = this.summaryFtmsDataList;
        }
        return arrayList;
    }

    public ArrayList<FtmsBaseData> getNowFtmsDataArrayList() {
        ArrayList<FtmsBaseData> arrayList;
        synchronized (BleDataManager.class) {
            arrayList = this.nowFtmsDataArrayList;
        }
        return arrayList;
    }

    public synchronized ArrayList<FitnessMachineFeatureType> getFitnessMachineFeatureList() {
        ArrayList<FitnessMachineFeatureType> arrayList;
        synchronized (this) {
            arrayList = this.fitnessMachineFeatureList;
        }
        return arrayList;
        return arrayList;
    }

    public synchronized void setFitnessMachineFeatureList(ArrayList<FitnessMachineFeatureType> fitnessMachineFeatureList) {
        synchronized (this) {
            this.fitnessMachineFeatureList = fitnessMachineFeatureList;
        }
    }

    public synchronized TrainingStatusType getNowTrainingStatusType() {
        TrainingStatusType trainingStatusType;
        synchronized (this) {
            trainingStatusType = this.nowTrainingStatusType;
        }
        return trainingStatusType;
        return trainingStatusType;
    }

    public synchronized void setNowTrainingStatusType(TrainingStatusType nowTrainingStatusType) {
        synchronized (this) {
            this.nowTrainingStatusType = nowTrainingStatusType;
        }
    }

    public synchronized TrainingStatusType getOldTrainingStatusType() {
        TrainingStatusType trainingStatusType;
        synchronized (this) {
            trainingStatusType = this.oldTrainingStatusType;
        }
        return trainingStatusType;
        return trainingStatusType;
    }

    public synchronized void setOldTrainingStatusType(TrainingStatusType oldTrainingStatusType) {
        synchronized (this) {
            this.oldTrainingStatusType = oldTrainingStatusType;
        }
    }

    public synchronized FitnessMachineStatusType getNowFitnessMachineStatusType() {
        FitnessMachineStatusType fitnessMachineStatusType;
        synchronized (this) {
            fitnessMachineStatusType = this.nowFitnessMachineStatusType;
        }
        return fitnessMachineStatusType;
        return fitnessMachineStatusType;
    }

    public synchronized void setNowFitnessMachineStatusType(FitnessMachineStatusType nowFitnessMachineStatusType) {
        synchronized (this) {
            this.oldFitnessMachineStatusType = this.nowFitnessMachineStatusType;
            this.nowFitnessMachineStatusType = nowFitnessMachineStatusType;
        }
    }

    public FitnessMachineStatusType getNowFMSTypeOnlyFourType() {
        return this.nowFMSTypeOnlyFourType;
    }

    public void setNowFMSTypeOnlyFourType(FitnessMachineStatusType nowFMSTypeOnlyFourType) {
        if (nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER || nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER || nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY || nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_STARTED_OR_RESUMED_BY_THE_USER) {
            this.nowFMSTypeOnlyFourType = nowFMSTypeOnlyFourType;
        }
    }

    public FitnessMachineStatusType getOldFitnessMachineStatusType() {
        FitnessMachineStatusType fitnessMachineStatusType;
        synchronized (this) {
            fitnessMachineStatusType = this.oldFitnessMachineStatusType;
        }
        return fitnessMachineStatusType;
    }

    public void setOldFitnessMachineStatusType(FitnessMachineStatusType oldFitnessMachineStatusType) {
        synchronized (this) {
            this.oldFitnessMachineStatusType = oldFitnessMachineStatusType;
        }
    }

    public HrData getNowHrData() {
        return this.nowHrData;
    }

    public String getClassId() {
        String str;
        synchronized (this) {
            str = this.classId;
        }
        return str;
    }

    public void setClassId(String classId) {
        synchronized (this) {
            this.classId = classId;
        }
    }

    public String getClassType() {
        String str;
        synchronized (this) {
            str = this.classType;
        }
        return str;
    }

    public void setClassType(String classType) {
        synchronized (this) {
            this.classType = classType;
        }
    }

    public String getClassName() {
        String str;
        synchronized (this) {
            str = this.className;
        }
        return str;
    }

    public void setClassName(String className) {
        synchronized (this) {
            this.className = className;
        }
    }

    public FtmsBaseData getFirstFtmsData() {
        return this.firstFtmsData;
    }

    public void setFirstFtmsData(FtmsBaseData firstFtmsData) {
        this.firstFtmsData = firstFtmsData;
        this.nowFtmsDataArrayList.clear();
    }

    public void setWearData(int heartRate) {
        nowWearHrData.setHrValue(Integer.valueOf(heartRate));
        nowWearHrData.setTime(Long.valueOf(Instant.now().toEpochMilli()));
    }
}
