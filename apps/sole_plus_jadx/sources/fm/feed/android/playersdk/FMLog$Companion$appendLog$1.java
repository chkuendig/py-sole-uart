package fm.feed.android.playersdk;

import android.os.Build;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FMLog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "fm.feed.android.playersdk.FMLog$Companion$appendLog$1", f = "FMLog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FMLog$Companion$appendLog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LogLevel $entryLogLevel;
    final /* synthetic */ Throwable $ex;
    final /* synthetic */ File $logFile;
    final /* synthetic */ String $message;
    final /* synthetic */ String $tag;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FMLog$Companion$appendLog$1(LogLevel logLevel, String str, String str2, File file, Throwable th, Continuation<? super FMLog$Companion$appendLog$1> continuation) {
        super(2, continuation);
        this.$entryLogLevel = logLevel;
        this.$tag = str;
        this.$message = str2;
        this.$logFile = file;
        this.$ex = th;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FMLog$Companion$appendLog$1(this.$entryLogLevel, this.$tag, this.$message, this.$logFile, this.$ex, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FMLog$Companion$appendLog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27) {
            str = System.currentTimeMillis() + "    " + this.$entryLogLevel + "    " + this.$tag + "    " + this.$message;
        } else {
            try {
                str = new Date() + "    " + this.$entryLogLevel + "    " + this.$tag + "    " + this.$message;
            } catch (AssertionError e) {
                e.printStackTrace();
                str = "";
            }
        }
        if (!this.$logFile.exists()) {
            try {
                this.$logFile.createNewFile();
            } catch (IOException e2) {
                Log.e(this.$tag, "Unable to create internal log file", e2);
            }
        }
        if (FMLog.INSTANCE.isFileGreaterThan10MB(this.$logFile)) {
            FMLog.INSTANCE.truncateLogs();
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.$logFile, true));
            bufferedWriter.append((CharSequence) str);
            bufferedWriter.newLine();
            if (this.$ex != null) {
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                this.$ex.printStackTrace(printWriter);
                printWriter.flush();
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e3) {
            Log.e(this.$tag, "Problem appending to internal log file", e3);
        }
        return Unit.INSTANCE;
    }
}
