package com.samsung.android.sdk.internal.healthdata;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.Pair;
import androidx.autofill.HintConstants;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes5.dex */
public final class DeviceUtil {
    private static URL a(Context context) throws ClassNotFoundException, IOException {
        String strSubstring;
        String strSubstring2;
        String str;
        String simOperator;
        String str2 = Build.MODEL;
        String strSubstring3 = "";
        if (str2.startsWith("OMAP_SS")) {
            File file = new File("/system/version");
            if (file.isFile()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[128];
                        int i = fileInputStream.read(bArr);
                        strSubstring = i > 0 ? new String(bArr, 0, i) : "";
                        try {
                            fileInputStream.close();
                        } catch (Exception unused) {
                        }
                    } finally {
                    }
                } catch (Exception unused2) {
                }
            }
            str2 = "";
        } else {
            strSubstring = str2.startsWith("SAMSUNG-") ? str2.substring(8) : str2;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null || (simOperator = telephonyManager.getSimOperator()) == null || simOperator.length() <= 3) {
            strSubstring2 = "";
        } else {
            strSubstring3 = simOperator.substring(0, 3);
            strSubstring2 = simOperator.substring(3);
        }
        Pair pair = new Pair(strSubstring3, strSubstring2);
        try {
            Class<?> cls = Class.forName("android.os.SemSystemProperties");
            str = (String) cls.getMethod("getSalesCode", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception unused3) {
            str = "FAIL";
        }
        if (str == null || str.isEmpty()) {
            str = "NONE";
        }
        String str3 = (((("https://hub.samsungapps.com/product/appCheck.as?appInfo=com.sec.android.app.shealth@0&deviceId=" + strSubstring) + "&mnc=" + ((String) pair.second)) + "&csc=" + str) + "&openApi=" + String.valueOf(Build.VERSION.SDK_INT)) + "&mcc=" + ((String) pair.first);
        Log.d("HealthSDK-DeviceUtil", "Server URL : " + str3);
        return new URL(str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean b(java.net.URL r5) {
        /*
            java.lang.String r0 = "HealthSDK-DeviceUtil"
            java.lang.String r1 = "N/A"
            r2 = 0
            r3 = 0
            java.net.HttpURLConnection r2 = a(r5)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            java.io.InputStream r5 = r2.getInputStream()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            java.lang.String r1 = a(r5)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            java.lang.String r5 = "1"
            boolean r5 = r5.equals(r1)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            if (r5 != 0) goto L22
            java.lang.String r5 = "2"
            boolean r5 = r5.equals(r1)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            if (r5 == 0) goto L2f
        L22:
            r5 = 1
            r3 = r5
            goto L2f
        L25:
            r5 = move-exception
            goto L5c
        L27:
            r5 = move-exception
            java.lang.String r4 = "Failed to check update"
            android.util.Log.e(r0, r4, r5)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L32
        L2f:
            r2.disconnect()
        L32:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r2 = "Downloading Samsung Health is "
            r5.<init>(r2)
            if (r3 == 0) goto L3e
            java.lang.String r2 = ""
            goto L40
        L3e:
            java.lang.String r2 = "un"
        L40:
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.String r2 = "available ("
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.StringBuilder r5 = r5.append(r1)
            java.lang.String r1 = ")"
            java.lang.StringBuilder r5 = r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r0, r5)
            return r3
        L5c:
            if (r2 == 0) goto L61
            r2.disconnect()
        L61:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.internal.healthdata.DeviceUtil.b(java.net.URL):boolean");
    }

    public static boolean isSamsungHealthDownloadable(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return b(a(context));
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    private static HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection;
        boolean z;
        int i = 0;
        do {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 300 || responseCode > 307 || responseCode == 306 || responseCode == 304) {
                z = false;
            } else {
                String headerField = httpURLConnection.getHeaderField("Location");
                if (headerField != null) {
                    url = new URL(httpURLConnection.getURL(), headerField.replace("http://", "https://"));
                }
                httpURLConnection.disconnect();
                if ((!url.getProtocol().equals("http") && !url.getProtocol().equals(TournamentShareDialogURIBuilder.scheme)) || i >= 5) {
                    throw new SecurityException("Illegal URL redirect");
                }
                i++;
                z = true;
            }
        } while (z);
        return httpURLConnection;
    }

    private static String a(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(inputStream, null);
        for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
            if (eventType == 2 && "resultCode".equals(xmlPullParserNewPullParser.getName()) && xmlPullParserNewPullParser.next() == 4) {
                return xmlPullParserNewPullParser.getText();
            }
        }
        return "";
    }
}
