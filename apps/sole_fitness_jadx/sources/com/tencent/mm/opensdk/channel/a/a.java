package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.http.client.methods.HttpGet;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a, reason: collision with other inner class name */
    public static class C0057a {
        public String a;
        public String b;
        public String c;
        public long d;
        public Bundle e;
    }

    public static int a(Bundle bundle, String str, int i) {
        if (bundle == null) {
            return i;
        }
        try {
            return bundle.getInt(str, i);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            return i;
        }
    }

    public static Object a(int i, String str) {
        try {
            switch (i) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    return null;
            }
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
            return null;
        }
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            return null;
        }
    }

    public static boolean a(Context context, C0057a c0057a) {
        String str;
        if (context == null || c0057a == null) {
            str = "send fail, invalid argument";
        } else {
            if (!b.b(c0057a.b)) {
                String str2 = null;
                if (!b.b(c0057a.a)) {
                    str2 = c0057a.a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c0057a.b);
                Bundle bundle = c0057a.e;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, c0057a.c);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0057a.d);
                intent.putExtra(ConstantsAPI.CHECK_SUM, a(c0057a.c, Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str2);
                Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            }
            str = "send fail, action is null";
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x014f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:104:0x014f */
    /* JADX WARN: Removed duplicated region for block: B:132:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, int i) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ?? r8;
        ByteArrayOutputStream byteArrayOutputStream3;
        String str2;
        ?? r3;
        Object obj;
        InputStream inputStream;
        Exception e;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        IOException e2;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream3;
        MalformedURLException e3;
        HttpURLConnection httpURLConnection3;
        InputStream inputStream4;
        ByteArrayOutputStream byteArrayOutputStream4;
        ByteArrayOutputStream byteArrayOutputStream5;
        ByteArrayOutputStream byteArrayOutputStream6;
        HttpURLConnection httpURLConnection4;
        HttpURLConnection httpURLConnection5;
        HttpURLConnection httpURLConnection6;
        ?? r82;
        ByteArrayOutputStream byteArrayOutputStream7;
        InputStream inputStream5 = null;
        if (str != null) {
            int length = str.length();
            try {
                if (length != 0) {
                    try {
                        r82 = (HttpURLConnection) new URL(str).openConnection();
                    } catch (MalformedURLException e4) {
                        e3 = e4;
                        httpURLConnection3 = null;
                        inputStream4 = null;
                    } catch (IOException e5) {
                        e2 = e5;
                        httpURLConnection2 = null;
                        inputStream3 = null;
                    } catch (Exception e6) {
                        e = e6;
                        httpURLConnection = null;
                        inputStream2 = null;
                    } catch (Throwable th) {
                        th = th;
                        obj = null;
                        inputStream = null;
                    }
                    try {
                        if (r82 == 0) {
                            Log.e("MicroMsg.SDK.NetUtil", "open connection failed.");
                            if (r82 != 0) {
                                try {
                                    r82.disconnect();
                                } catch (Throwable unused) {
                                }
                            }
                            return null;
                        }
                        try {
                            r82.setRequestMethod(HttpGet.METHOD_NAME);
                            r82.setConnectTimeout(i);
                            r82.setReadTimeout(i);
                            if (r82.getResponseCode() >= 300) {
                                Log.e("MicroMsg.SDK.NetUtil", "httpURLConnectionGet 300");
                                try {
                                    r82.disconnect();
                                } catch (Throwable unused2) {
                                }
                                return null;
                            }
                            InputStream inputStream6 = r82.getInputStream();
                            try {
                                byteArrayOutputStream7 = new ByteArrayOutputStream();
                            } catch (MalformedURLException e7) {
                                inputStream4 = inputStream6;
                                e3 = e7;
                                httpURLConnection3 = r82;
                                byteArrayOutputStream6 = null;
                                httpURLConnection6 = httpURLConnection3;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                                if (httpURLConnection6 != null) {
                                    try {
                                        httpURLConnection6.disconnect();
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (inputStream4 != null) {
                                    try {
                                        inputStream4.close();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                if (byteArrayOutputStream6 != null) {
                                    try {
                                        byteArrayOutputStream6.close();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                return null;
                            } catch (IOException e8) {
                                inputStream3 = inputStream6;
                                e2 = e8;
                                httpURLConnection2 = r82;
                                byteArrayOutputStream5 = null;
                                httpURLConnection5 = httpURLConnection2;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                                if (httpURLConnection5 != null) {
                                    try {
                                        httpURLConnection5.disconnect();
                                    } catch (Throwable unused6) {
                                    }
                                }
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Throwable unused7) {
                                    }
                                }
                                if (byteArrayOutputStream5 != null) {
                                    try {
                                        byteArrayOutputStream5.close();
                                    } catch (Throwable unused8) {
                                    }
                                }
                                return null;
                            } catch (Exception e9) {
                                inputStream2 = inputStream6;
                                e = e9;
                                httpURLConnection = r82;
                                byteArrayOutputStream4 = null;
                                httpURLConnection4 = httpURLConnection;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                                if (httpURLConnection4 != null) {
                                    try {
                                        httpURLConnection4.disconnect();
                                    } catch (Throwable unused9) {
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable unused10) {
                                    }
                                }
                                if (byteArrayOutputStream4 != null) {
                                    try {
                                        byteArrayOutputStream4.close();
                                    } catch (Throwable unused11) {
                                    }
                                }
                                return null;
                            } catch (Throwable th2) {
                                inputStream = inputStream6;
                                th = th2;
                                obj = r82;
                                inputStream5 = inputStream;
                                byteArrayOutputStream3 = null;
                                r8 = obj;
                                if (r8 != 0) {
                                    try {
                                        r8.disconnect();
                                    } catch (Throwable unused12) {
                                    }
                                }
                                if (inputStream5 != null) {
                                    try {
                                        inputStream5.close();
                                    } catch (Throwable unused13) {
                                    }
                                }
                                if (byteArrayOutputStream3 == null) {
                                    throw th;
                                }
                                try {
                                    byteArrayOutputStream3.close();
                                    throw th;
                                } catch (Throwable unused14) {
                                    throw th;
                                }
                            }
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i2 = inputStream6.read(bArr);
                                    if (i2 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream7.write(bArr, 0, i2);
                                }
                                byte[] byteArray = byteArrayOutputStream7.toByteArray();
                                Log.d("MicroMsg.SDK.NetUtil", "httpGet end");
                                try {
                                    r82.disconnect();
                                } catch (Throwable unused15) {
                                }
                                try {
                                    inputStream6.close();
                                } catch (Throwable unused16) {
                                }
                                try {
                                    byteArrayOutputStream7.close();
                                } catch (Throwable unused17) {
                                }
                                return byteArray;
                            } catch (MalformedURLException e10) {
                                inputStream4 = inputStream6;
                                e3 = e10;
                                byteArrayOutputStream6 = byteArrayOutputStream7;
                                httpURLConnection6 = r82;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                                if (httpURLConnection6 != null) {
                                }
                                if (inputStream4 != null) {
                                }
                                if (byteArrayOutputStream6 != null) {
                                }
                                return null;
                            } catch (IOException e11) {
                                inputStream3 = inputStream6;
                                e2 = e11;
                                byteArrayOutputStream5 = byteArrayOutputStream7;
                                httpURLConnection5 = r82;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                                if (httpURLConnection5 != null) {
                                }
                                if (inputStream3 != null) {
                                }
                                if (byteArrayOutputStream5 != null) {
                                }
                                return null;
                            } catch (Exception e12) {
                                inputStream2 = inputStream6;
                                e = e12;
                                byteArrayOutputStream4 = byteArrayOutputStream7;
                                httpURLConnection4 = r82;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                                if (httpURLConnection4 != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                if (byteArrayOutputStream4 != null) {
                                }
                                return null;
                            } catch (Throwable th3) {
                                byteArrayOutputStream2 = byteArrayOutputStream7;
                                r3 = inputStream6;
                                th = th3;
                                str2 = r82;
                                byteArrayOutputStream3 = byteArrayOutputStream2;
                                inputStream5 = r3;
                                r8 = str2;
                                if (r8 != 0) {
                                }
                                if (inputStream5 != null) {
                                }
                                if (byteArrayOutputStream3 == null) {
                                }
                            }
                        } catch (MalformedURLException e13) {
                            e3 = e13;
                            inputStream4 = null;
                            httpURLConnection3 = r82;
                        } catch (IOException e14) {
                            e2 = e14;
                            inputStream3 = null;
                            httpURLConnection2 = r82;
                        } catch (Exception e15) {
                            e = e15;
                            inputStream2 = null;
                            httpURLConnection = r82;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = null;
                            obj = r82;
                        }
                    } catch (MalformedURLException e16) {
                        e3 = e16;
                        inputStream4 = null;
                        byteArrayOutputStream6 = null;
                        httpURLConnection6 = r82;
                    } catch (IOException e17) {
                        e2 = e17;
                        inputStream3 = null;
                        byteArrayOutputStream5 = null;
                        httpURLConnection5 = r82;
                    } catch (Exception e18) {
                        e = e18;
                        inputStream2 = null;
                        byteArrayOutputStream4 = null;
                        httpURLConnection4 = r82;
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayOutputStream3 = null;
                        r8 = r82;
                        if (r8 != 0) {
                        }
                        if (inputStream5 != null) {
                        }
                        if (byteArrayOutputStream3 == null) {
                        }
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream2 = byteArrayOutputStream;
                r3 = length;
                str2 = str;
            }
        }
        Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
        return null;
    }

    public static byte[] a(String str, int i, String str2) throws NoSuchAlgorithmException {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i2 = 0;
            for (byte b : bArrDigest) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
            }
            str3 = new String(cArr2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3.getBytes();
    }
}
