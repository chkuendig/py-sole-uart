package com.android.ddmlib.internal;

import com.android.ddmlib.IDevice;
import com.android.ddmlib.Log;
import com.android.ddmlib.MultiLineReceiver;
import com.google.common.util.concurrent.SettableFuture;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
class BatteryFetcher {
    private static final long BATTERY_TIMEOUT_MS = 2000;
    private static final String LOG_TAG = "BatteryFetcher";
    private static final String MAXFG_PATH = "/sys/class/power_supply/maxfg/capacity";
    private static final String NORMAL_PATH = "/sys/class/power_supply/*/capacity";
    private static final String PROP_PRODUCT_MODEL = "ro.product.model";
    private static final Set<String> Pixel3_Pixel3XL = new HashSet(Arrays.asList("Pixel 3", "Pixel 3 XL"));
    private Integer mBatteryLevel;
    private final IDevice mDevice;
    private long mLastSuccessTime;
    private SettableFuture<Integer> mPendingRequest;

    static final class SysFsBatteryLevelReceiver extends MultiLineReceiver {
        private static final Pattern BATTERY_LEVEL = Pattern.compile("^(\\d+)[.\\s]*");
        private Integer mBatteryLevel;

        @Override // com.android.ddmlib.IShellOutputReceiver
        public boolean isCancelled() {
            return false;
        }

        SysFsBatteryLevelReceiver() {
        }

        public Integer getBatteryLevel() {
            return this.mBatteryLevel;
        }

        @Override // com.android.ddmlib.MultiLineReceiver
        public void processNewLines(String[] lines) {
            for (String str : lines) {
                Matcher matcher = BATTERY_LEVEL.matcher(str);
                if (matcher.matches()) {
                    if (this.mBatteryLevel == null) {
                        this.mBatteryLevel = Integer.valueOf(Integer.parseInt(matcher.group(1)));
                    } else {
                        Integer numValueOf = Integer.valueOf(Integer.parseInt(matcher.group(1)));
                        if (!this.mBatteryLevel.equals(numValueOf)) {
                            Log.w(BatteryFetcher.LOG_TAG, String.format("Multiple lines matched with different value; Original: %s, Current: %s (keeping original)", this.mBatteryLevel.toString(), numValueOf.toString()));
                        }
                    }
                }
            }
        }
    }

    private static final class BatteryReceiver extends MultiLineReceiver {
        private static final Pattern BATTERY_LEVEL = Pattern.compile("\\s*level: (\\d+)");
        private static final Pattern SCALE = Pattern.compile("\\s*scale: (\\d+)");
        private Integer mBatteryLevel;
        private Integer mBatteryScale;

        @Override // com.android.ddmlib.IShellOutputReceiver
        public boolean isCancelled() {
            return false;
        }

        private BatteryReceiver() {
        }

        public Integer getBatteryLevel() {
            Integer num = this.mBatteryLevel;
            if (num == null || this.mBatteryScale == null) {
                return null;
            }
            return Integer.valueOf((num.intValue() * 100) / this.mBatteryScale.intValue());
        }

        @Override // com.android.ddmlib.MultiLineReceiver
        public void processNewLines(String[] lines) {
            for (String str : lines) {
                Matcher matcher = BATTERY_LEVEL.matcher(str);
                if (matcher.matches()) {
                    try {
                        this.mBatteryLevel = Integer.valueOf(Integer.parseInt(matcher.group(1)));
                    } catch (NumberFormatException unused) {
                        Log.w(BatteryFetcher.LOG_TAG, String.format("Failed to parse %s as an integer", matcher.group(1)));
                    }
                }
                Matcher matcher2 = SCALE.matcher(str);
                if (matcher2.matches()) {
                    try {
                        this.mBatteryScale = Integer.valueOf(Integer.parseInt(matcher2.group(1)));
                    } catch (NumberFormatException unused2) {
                        Log.w(BatteryFetcher.LOG_TAG, String.format("Failed to parse %s as an integer", matcher.group(1)));
                    }
                }
            }
        }
    }

    public BatteryFetcher(IDevice device) {
        this.mDevice = device;
    }

    public synchronized Future<Integer> getBattery(long freshness, TimeUnit timeUnit) {
        SettableFuture<Integer> settableFutureCreate;
        if (this.mBatteryLevel == null || isFetchRequired(freshness, timeUnit)) {
            if (this.mPendingRequest == null) {
                this.mPendingRequest = SettableFuture.create();
                initiateBatteryQuery();
            }
            settableFutureCreate = this.mPendingRequest;
        } else {
            settableFutureCreate = SettableFuture.create();
            settableFutureCreate.set(this.mBatteryLevel);
        }
        return settableFutureCreate;
    }

    private boolean isFetchRequired(long freshness, TimeUnit timeUnit) {
        return System.currentTimeMillis() - this.mLastSuccessTime > timeUnit.toMillis(freshness);
    }

    private void initiateBatteryQuery() {
        Thread thread = new Thread(String.format("query-battery-%s", this.mDevice.getSerialNumber())) { // from class: com.android.ddmlib.internal.BatteryFetcher.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SysFsBatteryLevelReceiver sysFsBatteryLevelReceiver;
                try {
                    sysFsBatteryLevelReceiver = new SysFsBatteryLevelReceiver();
                    String str = BatteryFetcher.NORMAL_PATH;
                    if (BatteryFetcher.Pixel3_Pixel3XL.contains(BatteryFetcher.this.mDevice.getProperty("ro.product.model"))) {
                        str = BatteryFetcher.MAXFG_PATH;
                    }
                    BatteryFetcher.this.mDevice.executeShellCommand("cat ".concat(str), sysFsBatteryLevelReceiver, 2000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th = th;
                }
                if (BatteryFetcher.this.setBatteryLevel(sysFsBatteryLevelReceiver.getBatteryLevel())) {
                    return;
                }
                BatteryReceiver batteryReceiver = new BatteryReceiver();
                BatteryFetcher.this.mDevice.executeShellCommand("dumpsys battery", batteryReceiver, 2000L, TimeUnit.MILLISECONDS);
                if (BatteryFetcher.this.setBatteryLevel(batteryReceiver.getBatteryLevel())) {
                    return;
                }
                th = new IOException("Unrecognized response to battery level queries");
                BatteryFetcher.this.handleBatteryLevelFailure(th);
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean setBatteryLevel(Integer batteryLevel) {
        if (batteryLevel == null) {
            return false;
        }
        this.mLastSuccessTime = System.currentTimeMillis();
        this.mBatteryLevel = batteryLevel;
        SettableFuture<Integer> settableFuture = this.mPendingRequest;
        if (settableFuture != null) {
            settableFuture.set(batteryLevel);
        }
        this.mPendingRequest = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleBatteryLevelFailure(Throwable e) {
        Log.w(LOG_TAG, String.format("%s getting battery level for device %s: %s", e.getClass().getSimpleName(), this.mDevice.getSerialNumber(), e.getMessage()));
        SettableFuture<Integer> settableFuture = this.mPendingRequest;
        if (settableFuture != null && !settableFuture.setException(e)) {
            Log.e(LOG_TAG, "Future.setException failed");
            this.mPendingRequest.set(null);
        }
        this.mPendingRequest = null;
    }
}
