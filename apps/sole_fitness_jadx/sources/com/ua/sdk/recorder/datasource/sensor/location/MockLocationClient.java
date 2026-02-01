package com.ua.sdk.recorder.datasource.sensor.location;

import android.content.ContentResolver;
import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.ua.sdk.UaLog;
import com.ua.sdk.recorder.datasource.RollingAverage;
import com.ua.sdk.recorder.datasource.sensor.location.LocationClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;

/* loaded from: classes2.dex */
public class MockLocationClient implements LocationClient {
    public static final int CONNECTION_TIMEOUT = 30000;
    public static final String MOCK_GPS_ENABLED_KEY = "mockGpsEnabled";
    public static final String MOCK_GPS_FAST_KEY = "mockGpsFast";
    public static final String MOCK_GPS_URL_KEY = "mockGpsUrl";
    private Handler backgroundHandler;
    private Context context;
    private List<Location> data;
    private boolean fastForward;
    private LocationClient.LocationClientListener locationClientListener;
    private String url;
    private RollingAverage<Float> accuracyAccumulator = new RollingAverage<>(3);
    private boolean isRunning = false;
    private MockGpsLoader dataLoader = null;
    private boolean mockLocationRunning = false;
    private int lineIndex = 0;
    private Location currentLocation = null;
    private long currentOriginalTime = 0;
    private boolean stopped = false;
    private HandlerThread handlerThread = new HandlerThread("MockLocationClientTimer");

    public MockLocationClient(Context context, String str, boolean z) {
        this.context = context;
        this.url = str;
        this.fastForward = z;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.location.LocationClient
    public void connect(LocationClient.LocationClientListener locationClientListener) {
        this.locationClientListener = locationClientListener;
        if (!this.isRunning) {
            this.isRunning = true;
            MockGpsLoader mockGpsLoader = new MockGpsLoader(this.context, this.url);
            this.dataLoader = mockGpsLoader;
            mockGpsLoader.execute(new Void[0]);
        }
        this.handlerThread.start();
        this.backgroundHandler = new MyHandler(this.handlerThread.getLooper());
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.location.LocationClient
    public void disconnect() {
        MockGpsLoader mockGpsLoader = this.dataLoader;
        if (mockGpsLoader != null) {
            mockGpsLoader.cancel(true);
            this.dataLoader = null;
        }
        stopLocationUpdates();
        this.handlerThread.quit();
        this.isRunning = false;
    }

    public void beginLocationUpdates() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        List<Location> list = this.data;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.locationClientListener.onStatus(true, true, 100.0f);
        updateLocation();
        dispatchCurrentLocation();
    }

    public void stopLocationUpdates() {
        Handler handler = this.backgroundHandler;
        if (handler != null) {
            handler.removeMessages(0);
        }
        this.stopped = true;
    }

    public void dispatchCurrentLocation() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.stopped) {
            return;
        }
        UaLog.debug("MockLocationClient next location " + this.lineIndex + " of " + this.data.size());
        this.accuracyAccumulator.addValue(Float.valueOf(this.currentLocation.getAccuracy()));
        this.locationClientListener.onStatus(true, true, Double.valueOf(this.accuracyAccumulator.getAverage()).floatValue());
        this.locationClientListener.onLocation(this.currentLocation);
        if (this.lineIndex < this.data.size()) {
            updateLocation();
            long time = this.currentLocation.getTime() - System.currentTimeMillis();
            if (time < 0) {
                time = 0;
            }
            this.backgroundHandler.sendEmptyMessageDelayed(0, time);
            return;
        }
        this.mockLocationRunning = false;
    }

    private void updateLocation() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<Location> list = this.data;
        int i = this.lineIndex;
        this.lineIndex = i + 1;
        Location location = list.get(i);
        long time = location.getTime();
        long j = this.currentOriginalTime;
        if (j != 0) {
            long j2 = time - j;
            if (this.fastForward) {
                j2 /= 2;
            }
            location.setTime(jCurrentTimeMillis + j2);
        } else {
            location.setTime(jCurrentTimeMillis);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                Method method = Location.class.getMethod("makeComplete", new Class[0]);
                if (method != null) {
                    method.invoke(location, new Object[0]);
                }
            } catch (Exception e) {
                UaLog.warn("failed Location.makeComplete", (Throwable) e);
            }
        }
        this.currentLocation = location;
        this.currentOriginalTime = time;
    }

    public class MyHandler extends Handler {
        public MyHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            MockLocationClient.this.dispatchCurrentLocation();
        }
    }

    protected class MockGpsLoader extends AsyncTask<Void, Void, List<Location>> {
        private ContentResolver cr;
        private String dataUrl;

        public MockGpsLoader(Context context, String str) {
            this.cr = context.getContentResolver();
            this.dataUrl = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Not initialized variable reg: 3, insn: 0x0101: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:47:0x0101 */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<Location> doInBackground(Void... voidArr) throws Throwable {
            InputStream inputStream;
            InputStream inputStreamOpenInputStream;
            InputStream inputStream2;
            InputStream inputStream3;
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    if (this.dataUrl == null) {
                        UaLog.error("Mock GPS URL is empty, aborting data mock data load.");
                        return MockLocationClient.this.data;
                    }
                    UaLog.info("Importing mock data from URI " + this.dataUrl);
                    if (this.dataUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        inputStreamOpenInputStream = new URL(this.dataUrl).openConnection().getInputStream();
                    } else {
                        inputStreamOpenInputStream = this.cr.openInputStream(Uri.parse(this.dataUrl));
                    }
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenInputStream));
                        String line = bufferedReader.readLine();
                        char c = 3;
                        char c2 = 2;
                        char c3 = 1;
                        char c4 = 0;
                        if (line.startsWith("#Android")) {
                            try {
                                line = bufferedReader.readLine();
                            } catch (Exception e) {
                                e = e;
                                UaLog.error("Exception during Mock GPS URL load.", (Throwable) e);
                                if (inputStreamOpenInputStream != null) {
                                    try {
                                        inputStreamOpenInputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                return null;
                            }
                        } else {
                            c2 = 3;
                            c = 2;
                            c4 = 1;
                            c3 = 0;
                        }
                        while (line != null) {
                            String[] strArrSplit = line.split(",");
                            Double dValueOf = Double.valueOf(strArrSplit[c3].trim());
                            Double dValueOf2 = Double.valueOf(strArrSplit[c4].trim());
                            float fFloatValue = Float.valueOf(strArrSplit[c].trim()).floatValue();
                            long jLongValue = Long.valueOf(strArrSplit[c2].trim()).longValue();
                            Location location = new Location("mock");
                            inputStream3 = inputStreamOpenInputStream;
                            try {
                                location.setLatitude(dValueOf2.doubleValue());
                                location.setLongitude(dValueOf.doubleValue());
                                location.setAccuracy(fFloatValue);
                                location.setTime(jLongValue);
                                arrayList.add(location);
                                line = bufferedReader.readLine();
                                inputStreamOpenInputStream = inputStream3;
                            } catch (Exception e2) {
                                e = e2;
                                inputStreamOpenInputStream = inputStream3;
                                UaLog.error("Exception during Mock GPS URL load.", (Throwable) e);
                                if (inputStreamOpenInputStream != null) {
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStream3;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                throw th;
                            }
                        }
                        InputStream inputStream4 = inputStreamOpenInputStream;
                        if (inputStream4 == null) {
                            return arrayList;
                        }
                        try {
                            inputStream4.close();
                            return arrayList;
                        } catch (IOException unused3) {
                            return arrayList;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream3 = inputStreamOpenInputStream;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                }
            } catch (Exception e4) {
                e = e4;
                inputStreamOpenInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(List<Location> list) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                MockLocationClient.this.data = list;
                MockLocationClient.this.beginLocationUpdates();
            } else {
                Toast.makeText(MockLocationClient.this.context, "Mock GPS load failed.", 1).show();
            }
            MockLocationClient.this.dataLoader = null;
        }
    }
}
