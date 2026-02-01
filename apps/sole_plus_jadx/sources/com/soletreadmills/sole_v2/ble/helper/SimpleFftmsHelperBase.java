package com.soletreadmills.sole_v2.ble.helper;

import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import timber.log.Timber;

/* loaded from: classes5.dex */
public abstract class SimpleFftmsHelperBase {
    protected final boolean isFemale;
    protected final double userWeightKg;
    private int elapsedTimeSimpleFtms = 0;
    private final Object elapsedTimeSimpleFtmsLock = new Object();
    protected Integer elapsedTimeOld = null;

    public abstract void onTimerRunBind();

    public abstract FtmsBaseData processDataBind(FtmsBaseData ftmsBaseData);

    public SimpleFftmsHelperBase(double userWeightKg, boolean isFemale) {
        this.userWeightKg = userWeightKg;
        this.isFemale = isFemale;
    }

    public void onTimerRun() {
        Timber.d("plusOneElapsedTimeSimpleFtms", new Object[0]);
        plusOneElapsedTimeSimpleFtms();
        onTimerRunBind();
    }

    public FtmsBaseData processData(FtmsBaseData ftmsBaseData) {
        Timber.d("processData ftmsBaseData=%s", ftmsBaseData);
        if (ftmsBaseData == null) {
            return null;
        }
        if (ftmsBaseData.getElapsedTime() == null || ftmsBaseData.getElapsedTime().intValue() <= 0) {
            ftmsBaseData.setElapsedTime(getElapsedTimeSimpleFtms());
        }
        FtmsBaseData ftmsBaseDataProcessDataBind = processDataBind(ftmsBaseData);
        if (ftmsBaseDataProcessDataBind != null) {
            this.elapsedTimeOld = ftmsBaseDataProcessDataBind.getElapsedTime();
        }
        return ftmsBaseDataProcessDataBind;
    }

    private Integer getElapsedTimeSimpleFtms() {
        Integer numValueOf;
        synchronized (this.elapsedTimeSimpleFtmsLock) {
            numValueOf = Integer.valueOf(this.elapsedTimeSimpleFtms);
        }
        return numValueOf;
    }

    private void setElapsedTimeSimpleFtms(Integer elapsedTimeSimpleFtms) {
        synchronized (this.elapsedTimeSimpleFtmsLock) {
            int iIntValue = elapsedTimeSimpleFtms.intValue();
            this.elapsedTimeSimpleFtms = iIntValue;
            Timber.d("setElapsedTimeSimpleFtms elapsedTimeSimpleFtms=%s", Integer.valueOf(iIntValue));
        }
    }

    public void plusOneElapsedTimeSimpleFtms() {
        Timber.d("plusOneElapsedTimeSimpleFtms", new Object[0]);
        setElapsedTimeSimpleFtms(Integer.valueOf(getElapsedTimeSimpleFtms().intValue() + 1));
    }
}
