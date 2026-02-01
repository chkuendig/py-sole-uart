package com.facebook.internal.instrument.crashreport;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CrashHandler.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "previousHandler", "(Ljava/lang/Thread$UncaughtExceptionHandler;)V", "uncaughtException", "", "t", "Ljava/lang/Thread;", "e", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final int MAX_CRASH_REPORT_NUM = 5;
    private static CrashHandler instance;
    private final Thread.UncaughtExceptionHandler previousHandler;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = CrashHandler.class.getCanonicalName();

    @JvmStatic
    public static final synchronized void enable() {
        INSTANCE.enable();
    }

    public /* synthetic */ CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, DefaultConstructorMarker defaultConstructorMarker) {
        this(uncaughtExceptionHandler);
    }

    private CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.previousHandler = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread t, Throwable e) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(e, "e");
        if (InstrumentUtility.isSDKRelatedException(e)) {
            ExceptionAnalyzer.execute(e);
            InstrumentData.Builder.build(e, InstrumentData.Type.CrashReport).save();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(t, e);
        }
    }

    /* compiled from: CrashHandler.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler$Companion;", "", "()V", "MAX_CRASH_REPORT_NUM", "", "TAG", "", "instance", "Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "enable", "", "sendExceptionReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final synchronized void enable() {
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                Companion companion = this;
                sendExceptionReports();
            }
            if (CrashHandler.instance != null) {
                Log.w(CrashHandler.TAG, "Already enabled!");
            } else {
                CrashHandler.instance = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler(), null);
                Thread.setDefaultUncaughtExceptionHandler(CrashHandler.instance);
            }
        }

        private final void sendExceptionReports() {
            if (Utility.isDataProcessingRestricted()) {
                return;
            }
            File[] fileArrListExceptionReportFiles = InstrumentUtility.listExceptionReportFiles();
            ArrayList arrayList = new ArrayList(fileArrListExceptionReportFiles.length);
            for (File file : fileArrListExceptionReportFiles) {
                arrayList.add(InstrumentData.Builder.load(file));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((InstrumentData) obj).isValid()) {
                    arrayList2.add(obj);
                }
            }
            final List listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.facebook.internal.instrument.crashreport.CrashHandler$Companion$sendExceptionReports$validReports$3
                @Override // java.util.Comparator
                public final int compare(InstrumentData instrumentData, InstrumentData o2) {
                    Intrinsics.checkNotNullExpressionValue(o2, "o2");
                    return instrumentData.compareTo(o2);
                }
            });
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = RangesKt.until(0, Math.min(listSortedWith.size(), 5)).iterator();
            while (it.hasNext()) {
                jSONArray.put(listSortedWith.get(((IntIterator) it).nextInt()));
            }
            InstrumentUtility.sendReports("crash_reports", jSONArray, new GraphRequest.Callback() { // from class: com.facebook.internal.instrument.crashreport.CrashHandler$Companion$sendExceptionReports$2
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse response) {
                    JSONObject jsonObject;
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        if (response.getError() == null && (jsonObject = response.getJsonObject()) != null && jsonObject.getBoolean("success")) {
                            Iterator it2 = listSortedWith.iterator();
                            while (it2.hasNext()) {
                                ((InstrumentData) it2.next()).clear();
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            });
        }
    }
}
