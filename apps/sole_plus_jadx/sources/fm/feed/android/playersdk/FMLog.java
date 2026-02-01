package fm.feed.android.playersdk;

import android.content.Context;
import android.util.Log;
import com.android.SdkConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: FMLog.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lfm/feed/android/playersdk/FMLog;", "", "tag", "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "d", "", "obj", "ex", "", "e", "i", "v", "w", "wtf", "Companion", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class FMLog {
    private static final String FILES_SUBDIR = "/feedfm";
    private static final String fileName = "sdk_log.txt";
    private static File logFile;
    private final String tag;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CoroutineScope ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    private static LogLevel logLevel = LogLevel.DEBUG;

    public static final LogLevel getLogLevel() {
        return INSTANCE.getLogLevel();
    }

    public static final void setLogLevel(LogLevel logLevel2) {
        INSTANCE.setLogLevel(logLevel2);
    }

    public FMLog(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
    }

    public final String getTag() {
        return this.tag;
    }

    public static /* synthetic */ void v$default(FMLog fMLog, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        fMLog.v(obj, th);
    }

    public final void v(Object obj, Throwable ex) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String string = obj.toString();
        if (logLevel.compareTo(LogLevel.VERBOSE) <= 0) {
            if (ex != null) {
                Log.v(this.tag, string, ex);
            } else {
                Log.v(this.tag, string);
            }
        }
        INSTANCE.appendLog(LogLevel.VERBOSE, this.tag, string, ex);
    }

    public static /* synthetic */ void d$default(FMLog fMLog, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        fMLog.d(obj, th);
    }

    public final void d(Object obj, Throwable ex) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String string = obj.toString();
        if (logLevel.compareTo(LogLevel.DEBUG) <= 0) {
            if (ex != null) {
                Log.d(this.tag, string, ex);
            } else {
                Log.d(this.tag, string);
            }
        }
        INSTANCE.appendLog(LogLevel.DEBUG, this.tag, string, ex);
    }

    public static /* synthetic */ void w$default(FMLog fMLog, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        fMLog.w(obj, th);
    }

    public final void w(Object obj, Throwable ex) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String string = obj.toString();
        if (logLevel.compareTo(LogLevel.WARN) <= 0) {
            if (ex != null) {
                Log.w(this.tag, string, ex);
            } else {
                Log.w(this.tag, string);
            }
        }
        INSTANCE.appendLog(LogLevel.WARN, this.tag, string, ex);
    }

    public static /* synthetic */ void i$default(FMLog fMLog, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        fMLog.i(obj, th);
    }

    public final void i(Object obj, Throwable ex) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String string = obj.toString();
        if (logLevel.compareTo(LogLevel.INFO) <= 0) {
            if (ex != null) {
                Log.i(this.tag, string, ex);
            } else {
                Log.i(this.tag, string);
            }
        }
        INSTANCE.appendLog(LogLevel.INFO, this.tag, string, ex);
    }

    public static /* synthetic */ void e$default(FMLog fMLog, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        fMLog.e(obj, th);
    }

    public final void e(Object obj, Throwable ex) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String string = obj.toString();
        if (logLevel.compareTo(LogLevel.ERROR) <= 0) {
            if (ex != null) {
                Log.e(this.tag, string, ex);
            } else {
                Log.e(this.tag, string);
            }
        }
        INSTANCE.appendLog(LogLevel.ERROR, this.tag, string, ex);
    }

    public static /* synthetic */ void wtf$default(FMLog fMLog, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        fMLog.wtf(obj, th);
    }

    public final void wtf(Object obj, Throwable ex) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String string = obj.toString();
        if (logLevel.compareTo(LogLevel.ASSERT) <= 0) {
            if (ex != null) {
                Log.wtf(this.tag, string, ex);
            } else {
                Log.wtf(this.tag, string);
            }
        }
        INSTANCE.appendLog(LogLevel.ASSERT, this.tag, string, ex);
    }

    /* compiled from: FMLog.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0002J\u0013\u0010\u001b\u001a\u00020\u0004H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lfm/feed/android/playersdk/FMLog$Companion;", "", "()V", "FILES_SUBDIR", "", "fileName", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "logFile", "Ljava/io/File;", "logLevel", "Lfm/feed/android/playersdk/LogLevel;", "getLogLevel$annotations", "getLogLevel", "()Lfm/feed/android/playersdk/LogLevel;", "setLogLevel", "(Lfm/feed/android/playersdk/LogLevel;)V", "appendLog", "", "entryLogLevel", "tag", "message", "ex", "", "isFileGreaterThan10MB", "", "file", "returnLogs", "returnLogs$PlayerSdk_exoDefaultRelease", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setContext", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "truncateLogs", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getLogLevel$annotations() {
        }

        private Companion() {
        }

        public final LogLevel getLogLevel() {
            return FMLog.logLevel;
        }

        public final void setLogLevel(LogLevel logLevel) {
            Intrinsics.checkNotNullParameter(logLevel, "<set-?>");
            FMLog.logLevel = logLevel;
        }

        public final void setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(Intrinsics.stringPlus(context.getCacheDir().getPath(), FMLog.FILES_SUBDIR));
            File file2 = new File(Intrinsics.stringPlus(context.getCacheDir().getPath(), FMLog.FILES_SUBDIR), FMLog.fileName);
            Log.e("FILe", file2.getAbsolutePath());
            BuildersKt__Builders_commonKt.launch$default(FMLog.ioScope, null, null, new FMLog$Companion$setContext$1(file, file2, null), 3, null);
        }

        public final Object returnLogs$PlayerSdk_exoDefaultRelease(Continuation<? super String> continuation) throws Throwable {
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            SafeContinuation safeContinuation2 = safeContinuation;
            String text = "";
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(FMLog.logFile));
                text = TextStreamsKt.readText(bufferedReader);
                bufferedReader.close();
            } catch (Exception e) {
                Log.e("fm.feed.FMLog", "Problem retrieving internal log file", e);
            }
            FMLog.INSTANCE.truncateLogs();
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m9087constructorimpl(text));
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void appendLog(LogLevel entryLogLevel, String tag, String message, Throwable ex) {
            File file = FMLog.logFile;
            if (file == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(FMLog.ioScope, null, null, new FMLog$Companion$appendLog$1(entryLogLevel, tag, message, file, ex, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void truncateLogs() {
            BuildersKt__Builders_commonKt.launch$default(FMLog.ioScope, null, null, new FMLog$Companion$truncateLogs$1(null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isFileGreaterThan10MB(File file) {
            return Integer.parseInt(String.valueOf(file.length())) >= 10485760;
        }
    }
}
