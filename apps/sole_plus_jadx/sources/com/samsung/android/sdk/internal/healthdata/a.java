package com.samsung.android.sdk.internal.healthdata;

import com.samsung.android.sdk.internal.interfaces.ParcelFdSupplier;
import java.io.InputStream;

/* compiled from: StreamUtil.java */
/* loaded from: classes5.dex */
final class a implements Runnable {
    final /* synthetic */ InputStream a;
    final /* synthetic */ String b;
    final /* synthetic */ ParcelFdSupplier c;
    final /* synthetic */ String d;

    a(InputStream inputStream, String str, ParcelFdSupplier parcelFdSupplier, String str2) {
        this.a = inputStream;
        this.b = str;
        this.c = parcelFdSupplier;
        this.d = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0082 A[Catch: IOException -> 0x0085, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x0085, blocks: (B:18:0x002c, B:46:0x0082), top: B:62:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            java.io.InputStream r1 = r8.a     // Catch: java.lang.Throwable -> L4f
            java.lang.String r2 = r8.b     // Catch: java.lang.Throwable -> L39
            if (r2 != 0) goto Ld
            if (r1 == 0) goto Lc
            r1.close()     // Catch: java.lang.Throwable -> L4f
        Lc:
            return
        Ld:
            com.samsung.android.sdk.internal.interfaces.ParcelFdSupplier r3 = r8.c     // Catch: java.lang.Throwable -> L39
            java.lang.String r4 = r8.d     // Catch: java.lang.Throwable -> L39
            android.os.ParcelFileDescriptor r2 = r3.get(r4, r2)     // Catch: java.lang.Throwable -> L39
            android.os.ParcelFileDescriptor$AutoCloseOutputStream r3 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream     // Catch: java.lang.Throwable -> L34
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L34
            r0 = 65536(0x10000, float:9.1835E-41)
            byte[] r4 = new byte[r0]     // Catch: java.lang.Throwable -> L32
        L1e:
            r5 = 0
            int r6 = r1.read(r4, r5, r0)     // Catch: java.lang.Throwable -> L32
            if (r6 <= 0) goto L29
            r3.write(r4, r5, r6)     // Catch: java.lang.Throwable -> L32
            goto L1e
        L29:
            r1.close()     // Catch: java.lang.Throwable -> L30
            r3.close()     // Catch: java.io.IOException -> L85
            goto L85
        L30:
            r0 = move-exception
            goto L53
        L32:
            r0 = move-exception
            goto L3f
        L34:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L3b
        L39:
            r2 = move-exception
            r3 = r0
        L3b:
            r7 = r3
            r3 = r0
            r0 = r2
            r2 = r7
        L3f:
            throw r0     // Catch: java.lang.Throwable -> L40
        L40:
            r4 = move-exception
            if (r1 == 0) goto L4b
            r1.close()     // Catch: java.lang.Throwable -> L47
            goto L4b
        L47:
            r1 = move-exception
            r0.addSuppressed(r1)     // Catch: java.lang.Throwable -> L4c
        L4b:
            throw r4     // Catch: java.lang.Throwable -> L4c
        L4c:
            r1 = move-exception
            r0 = r2
            goto L51
        L4f:
            r1 = move-exception
            r3 = r0
        L51:
            r2 = r0
            r0 = r1
        L53:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L86
            r1.<init>()     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = "Failed to send stream for ("
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = r8.b     // Catch: java.lang.Throwable -> L86
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = ")"
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L86
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L86
            java.lang.String r1 = "HealthData.Stream"
            android.util.Log.e(r1, r0)     // Catch: java.lang.Throwable -> L86
            if (r2 == 0) goto L80
            r2.closeWithError(r0)     // Catch: java.io.IOException -> L80 java.lang.Throwable -> L86
        L80:
            if (r3 == 0) goto L85
            r3.close()     // Catch: java.io.IOException -> L85
        L85:
            return
        L86:
            r0 = move-exception
            if (r3 == 0) goto L8c
            r3.close()     // Catch: java.io.IOException -> L8c
        L8c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.internal.healthdata.a.run():void");
    }
}
