package com.soletreadmills.sole_v2.ble.manager;

import android.bluetooth.BluetoothDevice;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBase;
import com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBikeDirection;
import com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBikeEjek;
import com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperEllipticalEjek;
import com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperTreadmill;
import com.soletreadmills.sole_v2.ble.tool.CheckSimpleFtmsDeviceTool;
import java.util.Timer;
import java.util.TimerTask;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class SimpleFftmsManager {
    private Timer timer = null;
    private final Object timerLock = new Object();
    private SimpleFftmsHelperBase simpleFftmsHelper = null;
    private final Object simpleFftmsHelperLock = new Object();

    public void onDeviceConnected(BluetoothDevice device, String name, double userWeightKg, boolean isFemale) {
        createSimpleFftmsHelper(name, userWeightKg, isFemale);
    }

    public void onDeviceDisconnected() {
        stopTimer();
        removeSimpleFftmsHelper();
    }

    public void checkStartTimer() {
        Timber.d("checkStartTimer 01", new Object[0]);
        if (isTimerStart()) {
            return;
        }
        Timber.d("checkStartTimer 02", new Object[0]);
        startTimer();
    }

    private void startTimer() {
        synchronized (this.timerLock) {
            Timber.d("startTimer", new Object[0]);
            Timer timer = new Timer();
            this.timer = timer;
            timer.scheduleAtFixedRate(new TimerTask() { // from class: com.soletreadmills.sole_v2.ble.manager.SimpleFftmsManager.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Timber.d("timer run 01", new Object[0]);
                    Timber.d("timer run 02", new Object[0]);
                    synchronized (SimpleFftmsManager.this.simpleFftmsHelperLock) {
                        if (SimpleFftmsManager.this.simpleFftmsHelper != null) {
                            SimpleFftmsManager.this.simpleFftmsHelper.onTimerRun();
                        }
                    }
                }
            }, 0L, 1000L);
        }
    }

    private void stopTimer() {
        synchronized (this.timerLock) {
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
            }
            this.timer = null;
        }
    }

    public boolean isTimerStart() {
        boolean z;
        synchronized (this.timerLock) {
            z = this.timer != null;
        }
        return z;
    }

    private void createSimpleFftmsHelper(String bleName, double userWeightKg, boolean isFemale) {
        Timber.d("createSimpleFftmsHelper", new Object[0]);
        synchronized (this.simpleFftmsHelperLock) {
            if (bleName == null) {
                removeSimpleFftmsHelper();
                return;
            }
            if (CheckSimpleFtmsDeviceTool.isTreadmill(bleName)) {
                this.simpleFftmsHelper = new SimpleFftmsHelperTreadmill(userWeightKg, isFemale);
            } else if (CheckSimpleFtmsDeviceTool.isBikeSoleEjek(bleName) || CheckSimpleFtmsDeviceTool.isBikeSpiritEjek(bleName)) {
                this.simpleFftmsHelper = new SimpleFftmsHelperBikeEjek(userWeightKg, isFemale);
            } else if (!CheckSimpleFtmsDeviceTool.isBikeSoleCorestar(bleName) && !CheckSimpleFtmsDeviceTool.isBikeSpiritCorestar(bleName) && !CheckSimpleFtmsDeviceTool.isBikeXterraCorestar(bleName)) {
                if (CheckSimpleFtmsDeviceTool.isBikeDirection(bleName)) {
                    this.simpleFftmsHelper = new SimpleFftmsHelperBikeDirection(userWeightKg, isFemale);
                } else if (CheckSimpleFtmsDeviceTool.isEllipticalSoleEjek(bleName) || CheckSimpleFtmsDeviceTool.isEllipticalSpiritEjek(bleName)) {
                    this.simpleFftmsHelper = new SimpleFftmsHelperEllipticalEjek(userWeightKg, isFemale);
                }
            }
        }
    }

    private void removeSimpleFftmsHelper() {
        Timber.d("removeSimpleFftmsHelper", new Object[0]);
        synchronized (this.simpleFftmsHelperLock) {
            this.simpleFftmsHelper = null;
        }
    }

    private boolean isCreatedSimpleFftmsHelper() {
        boolean z;
        synchronized (this.simpleFftmsHelperLock) {
            z = this.simpleFftmsHelper != null;
        }
        return z;
    }

    public FtmsBaseData processData(FtmsBaseData ftmsBaseData) {
        if (ftmsBaseData == null) {
            return null;
        }
        synchronized (this.simpleFftmsHelperLock) {
            SimpleFftmsHelperBase simpleFftmsHelperBase = this.simpleFftmsHelper;
            if (simpleFftmsHelperBase != null) {
                ftmsBaseData = simpleFftmsHelperBase.processData(ftmsBaseData);
            }
        }
        return ftmsBaseData;
    }
}
