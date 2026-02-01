package com.orhanobut.logger;

import androidx.exifinterface.media.ExifInterface;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class LoggerPrinter implements Printer {
    private static final int JSON_INDENT = 2;
    private final ThreadLocal<String> localTag = new ThreadLocal<>();
    private final List<LogAdapter> logAdapters = new ArrayList();

    LoggerPrinter() {
    }

    @Override // com.orhanobut.logger.Printer
    public Printer t(String str) {
        if (str != null) {
            this.localTag.set(str);
        }
        return this;
    }

    @Override // com.orhanobut.logger.Printer
    public void d(String str, Object... objArr) {
        log(3, (Throwable) null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public void d(Object obj) {
        log(3, (Throwable) null, Utils.toString(obj), new Object[0]);
    }

    @Override // com.orhanobut.logger.Printer
    public void e(String str, Object... objArr) {
        e(null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public void e(Throwable th, String str, Object... objArr) {
        log(6, th, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public void w(String str, Object... objArr) {
        log(5, (Throwable) null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public void i(String str, Object... objArr) {
        log(4, (Throwable) null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public void v(String str, Object... objArr) {
        log(2, (Throwable) null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public void wtf(String str, Object... objArr) {
        log(7, (Throwable) null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public void json(String str) {
        if (Utils.isEmpty(str)) {
            d("Empty/Null json content");
            return;
        }
        try {
            String strTrim = str.trim();
            if (strTrim.startsWith("{")) {
                d(new JSONObject(strTrim).toString(2));
            } else if (strTrim.startsWith("[")) {
                d(new JSONArray(strTrim).toString(2));
            } else {
                e("Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            e("Invalid Json", new Object[0]);
        }
    }

    @Override // com.orhanobut.logger.Printer
    public void xml(String str) throws TransformerException, IllegalArgumentException {
        if (Utils.isEmpty(str)) {
            d("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", ExifInterface.GPS_MEASUREMENT_2D);
            transformerNewTransformer.transform(streamSource, streamResult);
            d(streamResult.getWriter().toString().replaceFirst(">", ">\n"));
        } catch (TransformerException unused) {
            e("Invalid xml", new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[Catch: all -> 0x004b, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x0021, B:9:0x0025, B:12:0x002d, B:13:0x0033, B:15:0x0039, B:17:0x0045), top: B:24:0x0005 }] */
    @Override // com.orhanobut.logger.Printer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void log(int i, String str, String str2, Throwable th) {
        if (th != null && str2 != null) {
            str2 = str2 + " : " + Utils.getStackTraceString(th);
            if (th != null) {
                str2 = Utils.getStackTraceString(th);
            }
            if (Utils.isEmpty(str2)) {
            }
            while (r6.hasNext()) {
            }
        } else {
            if (th != null && str2 == null) {
                str2 = Utils.getStackTraceString(th);
            }
            if (Utils.isEmpty(str2)) {
                str2 = "Empty/NULL log message";
            }
            for (LogAdapter logAdapter : this.logAdapters) {
                if (logAdapter.isLoggable(i, str)) {
                    logAdapter.log(i, str, str2);
                }
            }
        }
    }

    @Override // com.orhanobut.logger.Printer
    public void clearLogAdapters() {
        this.logAdapters.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.orhanobut.logger.Printer
    public void addAdapter(LogAdapter logAdapter) {
        this.logAdapters.add(Utils.checkNotNull(logAdapter));
    }

    private synchronized void log(int i, Throwable th, String str, Object... objArr) {
        Utils.checkNotNull(str);
        log(i, getTag(), createMessage(str, objArr), th);
    }

    private String getTag() {
        String str = this.localTag.get();
        if (str == null) {
            return null;
        }
        this.localTag.remove();
        return str;
    }

    private String createMessage(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }
}
