package com.localebro.okhttpprofiler;

import com.localebro.okhttpprofiler.transfer.DataTransfer;
import com.localebro.okhttpprofiler.transfer.LogDataTransfer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes5.dex */
public class OkHttpProfilerInterceptor implements Interceptor {
    private final DataTransfer dataTransfer = new LogDataTransfer();
    private final DateFormat format = new SimpleDateFormat("ddhhmmssSSS", Locale.US);
    private final AtomicLong previousTime = new AtomicLong();

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        String strGenerateId = generateId();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.dataTransfer.sendRequest(strGenerateId, chain.request());
        try {
            Response responseProceed = chain.proceed(chain.request());
            this.dataTransfer.sendResponse(strGenerateId, responseProceed);
            this.dataTransfer.sendDuration(strGenerateId, System.currentTimeMillis() - jCurrentTimeMillis);
            return responseProceed;
        } catch (Exception e) {
            this.dataTransfer.sendException(strGenerateId, e);
            this.dataTransfer.sendDuration(strGenerateId, System.currentTimeMillis() - jCurrentTimeMillis);
            throw e;
        }
    }

    private synchronized String generateId() {
        long j;
        j = Long.parseLong(this.format.format(new Date()));
        long j2 = this.previousTime.get();
        if (j <= j2) {
            j = 1 + j2;
        }
        this.previousTime.set(j);
        return Long.toString(j, 36);
    }
}
