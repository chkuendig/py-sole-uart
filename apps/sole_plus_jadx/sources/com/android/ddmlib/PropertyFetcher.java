package com.android.ddmlib;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class PropertyFetcher {
    private static final int EXPECTED_PROP_COUNT = 150;
    private static final String GETPROP_COMMAND = "getprop";
    private static final int GETPROP_TIMEOUT_SEC = 2;
    private final IDevice mDevice;
    private static final Pattern GETPROP_PATTERN = Pattern.compile("^\\[([^]]+)\\]\\:\\s*\\[(.*)\\]$");
    private static final Pattern GETPROP_START_LINE_PATTERN = Pattern.compile("^\\[([^]]+)\\]\\:\\s*\\[(.*)$");
    private static final Pattern GETPROP_END_LINE_PATTERN = Pattern.compile("(.*)\\]$");
    private static boolean sEnableCachingMutableProps = true;
    private final Map<String, String> mProperties = Maps.newHashMapWithExpectedSize(150);
    private CacheState mCacheState = CacheState.UNPOPULATED;
    private final Map<String, SettableFuture<String>> mPendingRequests = Maps.newHashMapWithExpectedSize(4);

    private enum CacheState {
        UNPOPULATED,
        FETCHING,
        POPULATED
    }

    static class GetPropReceiver extends MultiLineReceiver {
        private final Map<String, String> mCollectedProperties = Maps.newHashMapWithExpectedSize(150);
        private String[] lines = new String[0];

        @Override // com.android.ddmlib.IShellOutputReceiver
        public boolean isCancelled() {
            return false;
        }

        GetPropReceiver() {
        }

        @Override // com.android.ddmlib.MultiLineReceiver
        public void processNewLines(String[] newLines) {
            String[] strArr = this.lines;
            String[] strArr2 = new String[strArr.length + newLines.length];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            System.arraycopy(newLines, 0, strArr2, this.lines.length, newLines.length);
            this.lines = strArr2;
        }

        @Override // com.android.ddmlib.MultiLineReceiver
        public void done() {
            String strGroup = null;
            String strGroup2 = null;
            for (String str : this.lines) {
                if (strGroup != null || (!str.isEmpty() && !str.startsWith("#"))) {
                    Matcher matcher = PropertyFetcher.GETPROP_PATTERN.matcher(str);
                    if (!matcher.matches()) {
                        Matcher matcher2 = PropertyFetcher.GETPROP_START_LINE_PATTERN.matcher(str);
                        if (!matcher2.matches()) {
                            Matcher matcher3 = PropertyFetcher.GETPROP_END_LINE_PATTERN.matcher(str);
                            if (matcher3.matches()) {
                                this.mCollectedProperties.put(strGroup, strGroup2 + "\n" + matcher3.group(1));
                            } else if (strGroup2 != null) {
                                strGroup2 = strGroup2 + "\n" + str;
                            }
                        } else {
                            strGroup = matcher2.group(1);
                            if (!strGroup.isEmpty()) {
                                strGroup2 = matcher2.group(2);
                            }
                        }
                    } else {
                        String strGroup3 = matcher.group(1);
                        String strGroup4 = matcher.group(2);
                        if (!strGroup3.isEmpty()) {
                            this.mCollectedProperties.put(strGroup3, strGroup4);
                        }
                    }
                    strGroup = null;
                    strGroup2 = null;
                }
            }
        }

        Map<String, String> getCollectedProperties() {
            return this.mCollectedProperties;
        }
    }

    public PropertyFetcher(IDevice device) {
        this.mDevice = device;
    }

    public synchronized Map<String, String> getProperties() {
        return this.mProperties;
    }

    public static void enableCachingMutableProps(boolean enabled) {
        sEnableCachingMutableProps = enabled;
    }

    public synchronized ListenableFuture<String> getProperty(String name) {
        SettableFuture<String> settableFutureAddPendingRequest;
        if (this.mCacheState.equals(CacheState.FETCHING)) {
            settableFutureAddPendingRequest = addPendingRequest(name);
        } else if ((this.mDevice.isOnline() && this.mCacheState.equals(CacheState.UNPOPULATED)) || !isImmutableProperty(name)) {
            settableFutureAddPendingRequest = addPendingRequest(name);
            this.mCacheState = CacheState.FETCHING;
            initiatePropertiesQuery();
        } else {
            SettableFuture<String> settableFutureCreate = SettableFuture.create();
            settableFutureCreate.set(this.mProperties.get(name));
            settableFutureAddPendingRequest = settableFutureCreate;
        }
        return settableFutureAddPendingRequest;
    }

    private SettableFuture<String> addPendingRequest(String name) {
        SettableFuture<String> settableFuture = this.mPendingRequests.get(name);
        if (settableFuture != null) {
            return settableFuture;
        }
        SettableFuture<String> settableFutureCreate = SettableFuture.create();
        this.mPendingRequests.put(name, settableFutureCreate);
        return settableFutureCreate;
    }

    private void initiatePropertiesQuery() {
        Thread thread = new Thread(String.format("query-prop-%s", this.mDevice.getSerialNumber())) { // from class: com.android.ddmlib.PropertyFetcher.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    GetPropReceiver getPropReceiver = new GetPropReceiver();
                    PropertyFetcher.this.mDevice.executeShellCommand(PropertyFetcher.GETPROP_COMMAND, getPropReceiver, 2L, TimeUnit.SECONDS);
                    PropertyFetcher.this.populateCache(getPropReceiver.getCollectedProperties());
                } catch (Throwable th) {
                    PropertyFetcher.this.handleException(th);
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void populateCache(Map<String, String> props) {
        this.mCacheState = props.isEmpty() ? CacheState.UNPOPULATED : CacheState.POPULATED;
        if (!props.isEmpty()) {
            if (sEnableCachingMutableProps) {
                this.mProperties.putAll(props);
            } else {
                for (Map.Entry<String, String> entry : props.entrySet()) {
                    if (isImmutableProperty(entry.getKey())) {
                        this.mProperties.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        for (Map.Entry<String, SettableFuture<String>> entry2 : this.mPendingRequests.entrySet()) {
            if (sEnableCachingMutableProps || isImmutableProperty(entry2.getKey())) {
                entry2.getValue().set(this.mProperties.get(entry2.getKey()));
            } else {
                entry2.getValue().set(props.get(entry2.getKey()));
            }
        }
        this.mPendingRequests.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleException(Throwable e) {
        this.mCacheState = CacheState.UNPOPULATED;
        Log.w("PropertyFetcher", new Throwable(String.format("%s getting properties for device %s", e.getClass().getSimpleName(), this.mDevice.getSerialNumber()), e));
        Iterator<Map.Entry<String, SettableFuture<String>>> it = this.mPendingRequests.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().setException(e);
        }
        this.mPendingRequests.clear();
    }

    @Deprecated
    public synchronized boolean arePropertiesSet() {
        return CacheState.POPULATED.equals(this.mCacheState);
    }

    private static boolean isImmutableProperty(String propName) {
        return propName.startsWith("ro.") || propName.equals(IDevice.PROP_DEVICE_EMULATOR_DENSITY);
    }
}
