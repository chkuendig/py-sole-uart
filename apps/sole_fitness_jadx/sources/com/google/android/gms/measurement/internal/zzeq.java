package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTimeConstants;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzeq implements Runnable {
    final /* synthetic */ zzer zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzen zzd;
    private final String zze;
    private final Map<String, String> zzf;

    public zzeq(zzer zzerVar, String str, URL url, byte[] bArr, Map<String, String> map, zzen zzenVar) {
        this.zza = zzerVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzenVar);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzenVar;
        this.zze = str;
        this.zzf = map;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0100: MOVE (r12 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:45:0x00fe */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0106: MOVE (r12 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:47:0x0103 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c9 A[Catch: all -> 0x00f3, LOOP:1: B:26:0x00c3->B:28:0x00c9, LOOP_END, TryCatch #7 {all -> 0x00f3, blocks: (B:25:0x00c1, B:26:0x00c3, B:28:0x00c9, B:29:0x00cd), top: B:84:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3 A[Catch: all -> 0x00fd, IOException -> 0x0102, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x0102, all -> 0x00fd, blocks: (B:31:0x00d3, B:42:0x00f9, B:43:0x00fc), top: B:93:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00cd A[EDGE_INSN: B:96:0x00cd->B:29:0x00cd BREAK  A[LOOP:1: B:26:0x00c3->B:28:0x00c9], SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        Throwable th;
        int i;
        HttpURLConnection httpURLConnection;
        Map map;
        IOException e;
        int i2;
        Map map2;
        zzep zzepVar;
        zzfs zzfsVarZzaz;
        IOException iOException;
        zzer zzerVar;
        URLConnection uRLConnectionOpenConnection;
        int responseCode;
        Map map3;
        Map map4;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int i3;
        this.zza.zzax();
        OutputStream outputStream = null;
        try {
            zzerVar = this.zza;
            uRLConnectionOpenConnection = this.zzb.openConnection();
        } catch (IOException e2) {
            e = e2;
            i2 = 0;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th2) {
            th = th2;
            i = 0;
            httpURLConnection = null;
            map = null;
        }
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        zzerVar.zzs.zzf();
        httpURLConnection.setConnectTimeout(DateTimeConstants.MILLIS_PER_MINUTE);
        zzerVar.zzs.zzf();
        httpURLConnection.setReadTimeout(61000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        try {
            Map<String, String> map5 = this.zzf;
            if (map5 != null) {
                for (Map.Entry<String, String> entry : map5.entrySet()) {
                    httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            if (this.zzc != null) {
                byte[] bArrZzz = this.zza.zzf.zzu().zzz(this.zzc);
                zzej zzejVarZzj = this.zza.zzs.zzay().zzj();
                int length = bArrZzz.length;
                zzejVarZzj.zzb("Uploading data. size", Integer.valueOf(length));
                httpURLConnection.setDoOutput(true);
                httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                httpURLConnection.setFixedLengthStreamingMode(length);
                httpURLConnection.connect();
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(bArrZzz);
                    outputStream2.close();
                    responseCode = httpURLConnection.getResponseCode();
                } catch (IOException e3) {
                    e = e3;
                    i2 = 0;
                    map2 = null;
                    outputStream = outputStream2;
                    iOException = e;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            this.zza.zzs.zzay().zzd().zzc("Error closing HTTP compressed POST connection output stream. appId", zzel.zzn(this.zze), e4);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzfsVarZzaz = this.zza.zzs.zzaz();
                    zzepVar = new zzep(this.zze, this.zzd, i2, iOException, null, map2, null);
                    zzfsVarZzaz.zzp(zzepVar);
                } catch (Throwable th3) {
                    th = th3;
                    i = 0;
                    map = null;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                            this.zza.zzs.zzay().zzd().zzc("Error closing HTTP compressed POST connection output stream. appId", zzel.zzn(this.zze), e5);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.zza.zzs.zzaz().zzp(new zzep(this.zze, this.zzd, i, null, null, map, null));
                    throw th;
                }
                try {
                    try {
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                bArr = new byte[1024];
                                while (true) {
                                    i3 = inputStream.read(bArr);
                                    if (i3 > 0) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, i3);
                                    }
                                }
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                zzfsVarZzaz = this.zza.zzs.zzaz();
                                zzepVar = new zzep(this.zze, this.zzd, responseCode, null, byteArray, headerFields, null);
                            } catch (Throwable th4) {
                                th = th4;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = null;
                        }
                    } catch (IOException e6) {
                        map2 = null;
                        iOException = e6;
                        i2 = responseCode;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        zzfsVarZzaz = this.zza.zzs.zzaz();
                        zzepVar = new zzep(this.zze, this.zzd, i2, iOException, null, map2, null);
                        zzfsVarZzaz.zzp(zzepVar);
                    } catch (Throwable th6) {
                        th = th6;
                        map = null;
                        i = responseCode;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        this.zza.zzs.zzaz().zzp(new zzep(this.zze, this.zzd, i, null, null, map, null));
                        throw th;
                    }
                } catch (IOException e7) {
                    iOException = e7;
                    i2 = responseCode;
                    map2 = map4;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzfsVarZzaz = this.zza.zzs.zzaz();
                    zzepVar = new zzep(this.zze, this.zzd, i2, iOException, null, map2, null);
                    zzfsVarZzaz.zzp(zzepVar);
                } catch (Throwable th7) {
                    th = th7;
                    i = responseCode;
                    map = map3;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    this.zza.zzs.zzaz().zzp(new zzep(this.zze, this.zzd, i, null, null, map, null));
                    throw th;
                }
            } else {
                responseCode = httpURLConnection.getResponseCode();
                Map<String, List<String>> headerFields2 = httpURLConnection.getHeaderFields();
                byteArrayOutputStream = new ByteArrayOutputStream();
                inputStream = httpURLConnection.getInputStream();
                bArr = new byte[1024];
                while (true) {
                    i3 = inputStream.read(bArr);
                    if (i3 > 0) {
                    }
                    byteArrayOutputStream.write(bArr, 0, i3);
                }
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                zzfsVarZzaz = this.zza.zzs.zzaz();
                zzepVar = new zzep(this.zze, this.zzd, responseCode, null, byteArray2, headerFields2, null);
            }
        } catch (IOException e8) {
            i2 = 0;
            map2 = null;
            iOException = e8;
        } catch (Throwable th8) {
            i = 0;
            map = null;
            th = th8;
        }
        zzfsVarZzaz.zzp(zzepVar);
    }
}
