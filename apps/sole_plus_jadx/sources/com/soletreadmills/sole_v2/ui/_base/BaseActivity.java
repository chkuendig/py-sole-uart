package com.soletreadmills.sole_v2.ui._base;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.compose.DialogNavigator;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2.MyApplication;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api._global.CheckAppUpdateApi;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.databinding.CustomPairingDialogBinding;
import com.sun.jna.platform.win32.WinError;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: BaseActivity.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J!\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u000b¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\b\u0010!\u001a\u00020\u0014H\u0016J\u0012\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u0014H\u0014J\b\u0010&\u001a\u00020\u0014H\u0014J\u000e\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u001aJ\u000e\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\bJ\u0087\u0001\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010.2\n\b\u0002\u00104\u001a\u0004\u0018\u0001022\n\b\u0002\u00105\u001a\u0004\u0018\u00010.2\n\b\u0002\u00106\u001a\u0004\u0018\u0001022\n\b\u0003\u00107\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u00108\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u00109\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010:J8\u0010,\u001a\u00020\u00142\b\u0010/\u001a\u0004\u0018\u00010\u001a2\b\u00100\u001a\u0004\u0018\u00010\u001a2\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u00010\u001a2\b\u00104\u001a\u0004\u0018\u000102JL\u0010,\u001a\u00020\u00142\b\u0010/\u001a\u0004\u0018\u00010\u001a2\b\u00100\u001a\u0004\u0018\u00010\u001a2\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u00010\u001a2\b\u00104\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u00010\u001a2\b\u00106\u001a\u0004\u0018\u000102J:\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010\u001a2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\b\u00100\u001a\u0004\u0018\u00010\u001a2\b\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<JL\u0010=\u001a\u00020\u00142\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010A\u001a\u0004\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010-\u001a\u0004\u0018\u00010\u001a2\b\u0010D\u001a\u0004\u0018\u00010\u001a2\b\u0010E\u001a\u0004\u0018\u00010\u001aJ\u0012\u0010F\u001a\u00020\u00142\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u001aJ$\u0010H\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\u000b2\b\u0010J\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010LJH\u0010M\u001a\u00020\u00142\u0006\u0010B\u001a\u00020N2\b\b\u0001\u0010O\u001a\u00020\u000b2\b\b\u0001\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u001a2\b\u0010D\u001a\u0004\u0018\u00010\u001a2\b\u0010E\u001a\u0004\u0018\u00010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006R"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "closePairDialogRunnable", "Ljava/lang/Runnable;", DialogNavigator.NAME, "Landroid/app/AlertDialog;", "isStart", "", "loadDialog", "loadDialogCount", "", "loadDialogCountLock", "", "pairingDialog", "getPairingDialog", "()Landroid/app/AlertDialog;", "setPairingDialog", "(Landroid/app/AlertDialog;)V", "callApiCheckAppUpdate", "", "cancelDialog", "cancelLoadDialog", "checkPermission", "permission", "", "", "requestCode", "([Ljava/lang/String;I)V", "getAppVersionName", "isDialogShow", "isHasGooglePlay", "isLoadDialogShowing", "onAppClosing", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "openUrlByWeb", "url", "setScreenOn", DebugKt.DEBUG_PROPERTY_VALUE_ON, "showAppUpdateDialog", "showBaseDialog", "title", "", "message", "posBtn", "posListener", "Landroid/content/DialogInterface$OnClickListener;", "negBtn", "negListener", "neuBtn", "neuListener", "posBtnColor", "negBtnColor", "neuBtnColor", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "showDatePickerDialog", "localDate", "Ljava/time/LocalDate;", "minLocalDate", "maxLocalDate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/app/DatePickerDialog$OnDateSetListener;", "okBtnStr", "cancelBtnStr", "showLoadDialog", "msg", "showPairingDialog", "type", "name", "onPairingDialogDismissListener", "Lcom/soletreadmills/sole_v2/ui/_base/OnPairingDialogDismissListener;", "showTimePickerDialog", "Landroid/app/TimePickerDialog$OnTimeSetListener;", "hourOfDay", "minute", "is24HourView", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class BaseActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private AlertDialog dialog;
    private AlertDialog loadDialog;
    private int loadDialogCount;
    private AlertDialog pairingDialog;
    private final Object loadDialogCountLock = new Object();
    private boolean isStart = true;
    private final Runnable closePairDialogRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda13
        @Override // java.lang.Runnable
        public final void run() {
            BaseActivity.closePairDialogRunnable$lambda$16(this.f$0);
        }
    };

    public final AlertDialog getPairingDialog() {
        return this.pairingDialog;
    }

    public final void setPairingDialog(AlertDialog alertDialog) {
        this.pairingDialog = alertDialog;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.isStart = true;
        callApiCheckAppUpdate();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.isStart = false;
    }

    public void onAppClosing() {
        Timber.INSTANCE.d("onAppClosing", new Object[0]);
    }

    public static /* synthetic */ void showLoadDialog$default(BaseActivity baseActivity, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadDialog");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        baseActivity.showLoadDialog(str);
    }

    public final synchronized void showLoadDialog(final String msg) {
        cancelLoadDialog();
        Runnable runnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.showLoadDialog$lambda$1(this.f$0, msg);
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            runOnUiThread(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLoadDialog$lambda$1(BaseActivity this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("showLoadDialog", new Object[0]);
        BaseActivity baseActivity = this$0;
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity);
        builder.setCancelable(false);
        LinearLayout linearLayout = new LinearLayout(baseActivity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        ProgressBar progressBar = new ProgressBar(baseActivity);
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(progressBar);
        if (str != null) {
            String str2 = str;
            if (str2.length() > 0) {
                TextView textView = new TextView(baseActivity);
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                textView.setTextColor(ContextCompat.getColor(baseActivity, R.color.colorGlobal_white));
                textView.setTextSize(16.0f);
                textView.setText(str2);
                linearLayout.addView(textView);
            }
        }
        builder.setView(linearLayout);
        AlertDialog alertDialogCreate = builder.create();
        this$0.loadDialog = alertDialogCreate;
        if (alertDialogCreate != null) {
            Intrinsics.checkNotNull(alertDialogCreate);
            if (alertDialogCreate.getWindow() != null) {
                AlertDialog alertDialog = this$0.loadDialog;
                Intrinsics.checkNotNull(alertDialog);
                Window window = alertDialog.getWindow();
                Intrinsics.checkNotNull(window);
                window.setBackgroundDrawableResource(R.drawable.load);
                AlertDialog alertDialog2 = this$0.loadDialog;
                Intrinsics.checkNotNull(alertDialog2);
                alertDialog2.show();
            }
        }
        synchronized (this$0.loadDialogCountLock) {
            this$0.loadDialogCount++;
            Timber.INSTANCE.d("showLoadDialog loadDialogCount=" + this$0.loadDialogCount, new Object[0]);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final synchronized void cancelLoadDialog() {
        Runnable runnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.cancelLoadDialog$lambda$3(this.f$0);
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            runOnUiThread(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelLoadDialog$lambda$3(BaseActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.loadDialogCountLock) {
            Timber.INSTANCE.d("cancelLoadDialog", new Object[0]);
            try {
                AlertDialog alertDialog = this$0.loadDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                this$0.loadDialogCount--;
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
            }
            Timber.INSTANCE.d("cancelLoadDialog loadDialogCount=" + this$0.loadDialogCount, new Object[0]);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean isLoadDialogShowing() {
        AlertDialog alertDialog = this.loadDialog;
        if (alertDialog == null) {
            return false;
        }
        Intrinsics.checkNotNull(alertDialog);
        return alertDialog.isShowing();
    }

    public final void showBaseDialog(final String message, final String posBtn, final DialogInterface.OnClickListener posListener, final String negBtn, final DialogInterface.OnClickListener negListener, final String neuBtn, final DialogInterface.OnClickListener neuListener) {
        cancelDialog();
        runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.showBaseDialog$lambda$4(this.f$0, message, posBtn, posListener, negBtn, negListener, neuBtn, neuListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBaseDialog$lambda$4(BaseActivity this$0, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2, String str4, DialogInterface.OnClickListener onClickListener3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlertDialog.Builder builder = new AlertDialog.Builder(this$0, R.style.BaseDialog);
        if (str != null) {
            builder.setMessage(str);
        }
        builder.setCancelable(false);
        if (str2 != null) {
            builder.setPositiveButton(str2, onClickListener);
        }
        if (str3 != null) {
            builder.setNegativeButton(str3, onClickListener2);
        }
        if (str4 != null) {
            builder.setNeutralButton(str4, onClickListener3);
        }
        AlertDialog alertDialogCreate = builder.create();
        this$0.dialog = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.show();
        }
        if (str2 != null) {
            AlertDialog alertDialog = this$0.dialog;
            Button button = alertDialog != null ? alertDialog.getButton(-1) : null;
            if (button != null) {
                button.setAllCaps(false);
            }
        }
        if (str3 != null) {
            AlertDialog alertDialog2 = this$0.dialog;
            Button button2 = alertDialog2 != null ? alertDialog2.getButton(-2) : null;
            if (button2 != null) {
                button2.setAllCaps(false);
            }
        }
        if (str4 != null) {
            AlertDialog alertDialog3 = this$0.dialog;
            Button button3 = alertDialog3 != null ? alertDialog3.getButton(-3) : null;
            if (button3 == null) {
                return;
            }
            button3.setAllCaps(false);
        }
    }

    public final void showBaseDialog(final String message, final String posBtn, final DialogInterface.OnClickListener posListener, final String negBtn, final DialogInterface.OnClickListener negListener) {
        cancelDialog();
        runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.showBaseDialog$lambda$6(this.f$0, message, posBtn, posListener, negBtn, negListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBaseDialog$lambda$6(BaseActivity this$0, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2) {
        Button button;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseActivity baseActivity = this$0;
        AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity, R.style.BaseDialog);
        if (str != null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(baseActivity, R.color.colorLabel_label1)), 0, str.length(), 33);
            builder.setMessage(spannableString);
        }
        builder.setCancelable(false);
        if (str2 != null) {
            builder.setPositiveButton(str2, onClickListener);
        }
        if (str3 != null) {
            builder.setNegativeButton(str3, onClickListener2);
        }
        AlertDialog alertDialogCreate = builder.create();
        this$0.dialog = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.show();
        }
        if (str2 != null) {
            AlertDialog alertDialog = this$0.dialog;
            Button button2 = alertDialog != null ? alertDialog.getButton(-1) : null;
            if (button2 != null) {
                button2.setAllCaps(false);
            }
            AlertDialog alertDialog2 = this$0.dialog;
            if (alertDialog2 != null && (button = alertDialog2.getButton(-1)) != null) {
                button.setTextColor(ContextCompat.getColor(baseActivity, R.color.colorGlobal_accent));
            }
        }
        if (str3 != null) {
            AlertDialog alertDialog3 = this$0.dialog;
            Button button3 = alertDialog3 != null ? alertDialog3.getButton(-2) : null;
            if (button3 == null) {
                return;
            }
            button3.setAllCaps(false);
        }
    }

    public static /* synthetic */ void showBaseDialog$default(BaseActivity baseActivity, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, DialogInterface.OnClickListener onClickListener, CharSequence charSequence4, DialogInterface.OnClickListener onClickListener2, CharSequence charSequence5, DialogInterface.OnClickListener onClickListener3, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBaseDialog");
        }
        baseActivity.showBaseDialog(charSequence, charSequence2, charSequence3, onClickListener, (i & 16) != 0 ? null : charSequence4, (i & 32) != 0 ? null : onClickListener2, (i & 64) != 0 ? null : charSequence5, (i & 128) != 0 ? null : onClickListener3, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : num3);
    }

    public final void showBaseDialog(final CharSequence title, final CharSequence message, final CharSequence posBtn, final DialogInterface.OnClickListener posListener, final CharSequence negBtn, final DialogInterface.OnClickListener negListener, final CharSequence neuBtn, final DialogInterface.OnClickListener neuListener, final Integer posBtnColor, final Integer negBtnColor, final Integer neuBtnColor) {
        cancelDialog();
        runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.showBaseDialog$lambda$8(this.f$0, title, message, posBtn, posListener, negBtn, negListener, neuBtn, neuListener, posBtnColor, negBtnColor, neuBtnColor);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBaseDialog$lambda$8(BaseActivity this$0, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, DialogInterface.OnClickListener onClickListener, CharSequence charSequence4, DialogInterface.OnClickListener onClickListener2, CharSequence charSequence5, DialogInterface.OnClickListener onClickListener3, Integer num, Integer num2, Integer num3) {
        AlertDialog alertDialog;
        Button button;
        AlertDialog alertDialog2;
        Button button2;
        AlertDialog alertDialog3;
        Button button3;
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlertDialog.Builder builder = new AlertDialog.Builder(this$0, R.style.BaseDialog);
        if (charSequence != null) {
            builder.setTitle(charSequence);
        }
        if (charSequence2 != null) {
            builder.setMessage(charSequence2);
        }
        builder.setCancelable(false);
        if (charSequence3 != null) {
            builder.setPositiveButton(charSequence3, onClickListener);
        }
        if (charSequence4 != null) {
            builder.setNegativeButton(charSequence4, onClickListener2);
        }
        if (charSequence5 != null) {
            builder.setNeutralButton(charSequence5, onClickListener3);
        }
        AlertDialog alertDialogCreate = builder.create();
        this$0.dialog = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.show();
        }
        try {
            int identifier = this$0.getResources().getIdentifier("alertTitle", "id", "android");
            if (identifier > 0) {
                AlertDialog alertDialog4 = this$0.dialog;
                final TextView textView = alertDialog4 != null ? (TextView) alertDialog4.findViewById(identifier) : null;
                if (textView != null && (viewTreeObserver = textView.getViewTreeObserver()) != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda0
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public final void onGlobalLayout() {
                            BaseActivity.showBaseDialog$lambda$8$lambda$7(textView);
                        }
                    });
                }
            }
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
        if (charSequence3 != null) {
            AlertDialog alertDialog5 = this$0.dialog;
            Button button4 = alertDialog5 != null ? alertDialog5.getButton(-1) : null;
            if (button4 != null) {
                button4.setAllCaps(false);
            }
        }
        if (charSequence4 != null) {
            AlertDialog alertDialog6 = this$0.dialog;
            Button button5 = alertDialog6 != null ? alertDialog6.getButton(-2) : null;
            if (button5 != null) {
                button5.setAllCaps(false);
            }
        }
        if (charSequence5 != null) {
            AlertDialog alertDialog7 = this$0.dialog;
            Button button6 = alertDialog7 != null ? alertDialog7.getButton(-3) : null;
            if (button6 != null) {
                button6.setAllCaps(false);
            }
        }
        if (num != null && (alertDialog3 = this$0.dialog) != null && (button3 = alertDialog3.getButton(-1)) != null) {
            button3.setTextColor(num.intValue());
        }
        if (num2 != null && (alertDialog2 = this$0.dialog) != null && (button2 = alertDialog2.getButton(-2)) != null) {
            button2.setTextColor(num2.intValue());
        }
        if (num3 == null || (alertDialog = this$0.dialog) == null || (button = alertDialog.getButton(-3)) == null) {
            return;
        }
        button.setTextColor(num3.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBaseDialog$lambda$8$lambda$7(TextView textView) {
        if (textView.getMaxLines() != Integer.MAX_VALUE) {
            textView.setMaxLines(Integer.MAX_VALUE);
        }
    }

    public static /* synthetic */ void showBaseDialog$default(BaseActivity baseActivity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBaseDialog");
        }
        if ((i & 16) != 0) {
            onDismissListener = null;
        }
        baseActivity.showBaseDialog(str, str2, str3, onClickListener, onDismissListener);
    }

    public final void showBaseDialog(final String title, final String message, final String posBtn, final DialogInterface.OnClickListener posListener, final DialogInterface.OnDismissListener dismissListener) {
        cancelDialog();
        runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.showBaseDialog$lambda$10(this.f$0, title, message, posBtn, posListener, dismissListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBaseDialog$lambda$10(BaseActivity this$0, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlertDialog.Builder builder = new AlertDialog.Builder(this$0, R.style.BaseDialog);
        if (str != null) {
            builder.setTitle(str);
        }
        if (str2 != null) {
            builder.setMessage(str2);
        }
        builder.setCancelable(false);
        if (str3 != null) {
            builder.setPositiveButton(str3, onClickListener);
        }
        if (onDismissListener != null) {
            builder.setOnDismissListener(onDismissListener);
        }
        AlertDialog alertDialogCreate = builder.create();
        this$0.dialog = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.show();
        }
        try {
            int identifier = this$0.getResources().getIdentifier("alertTitle", "id", "android");
            if (identifier > 0) {
                AlertDialog alertDialog = this$0.dialog;
                final TextView textView = alertDialog != null ? (TextView) alertDialog.findViewById(identifier) : null;
                if (textView != null && (viewTreeObserver = textView.getViewTreeObserver()) != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda2
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public final void onGlobalLayout() {
                            BaseActivity.showBaseDialog$lambda$10$lambda$9(textView);
                        }
                    });
                }
            }
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
        if (str3 != null) {
            AlertDialog alertDialog2 = this$0.dialog;
            Button button = alertDialog2 != null ? alertDialog2.getButton(-1) : null;
            if (button == null) {
                return;
            }
            button.setAllCaps(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBaseDialog$lambda$10$lambda$9(TextView textView) {
        if (textView.getMaxLines() != Integer.MAX_VALUE) {
            textView.setMaxLines(Integer.MAX_VALUE);
        }
    }

    public final void showDatePickerDialog(final LocalDate localDate, final LocalDate minLocalDate, final LocalDate maxLocalDate, final DatePickerDialog.OnDateSetListener listener, final String title, final String okBtnStr, final String cancelBtnStr) {
        cancelDialog();
        runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.showDatePickerDialog$lambda$11(this.f$0, minLocalDate, maxLocalDate, localDate, listener, title, okBtnStr, cancelBtnStr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.time.ZonedDateTime] */
    public static final void showDatePickerDialog$lambda$11(BaseActivity this$0, LocalDate localDate, LocalDate localDate2, LocalDate localDate3, DatePickerDialog.OnDateSetListener onDateSetListener, String str, String str2, String str3) {
        Button button;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DatePickerDialog datePickerDialog = new DatePickerDialog(this$0, R.style.MaterialCalendarCustomStyle);
        LocalDateTime localDateTimeOf = localDate != null ? LocalDateTime.of(localDate, LocalTime.of(0, 0)) : null;
        LocalDateTime localDateTimeOf2 = localDate2 != null ? LocalDateTime.of(localDate2, LocalTime.of(0, 0)) : null;
        if (localDateTimeOf != null) {
            datePickerDialog.getDatePicker().setMinDate(localDateTimeOf.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        }
        if (localDateTimeOf2 != null) {
            datePickerDialog.getDatePicker().setMaxDate(localDateTimeOf2.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        }
        if (localDate3 != null) {
            if (localDate != null && localDate3.isBefore(localDate)) {
                datePickerDialog.updateDate(localDate.getYear(), localDate.getMonthValue() - 1, localDate.getDayOfMonth());
            } else if (localDate2 != null && localDate3.isAfter(localDate2)) {
                datePickerDialog.updateDate(localDate2.getYear(), localDate2.getMonthValue() - 1, localDate2.getDayOfMonth());
            } else {
                datePickerDialog.updateDate(localDate3.getYear(), localDate3.getMonthValue() - 1, localDate3.getDayOfMonth());
            }
        }
        datePickerDialog.setOnDateSetListener(onDateSetListener);
        if (str != null) {
            datePickerDialog.setTitle(str);
        }
        if (str2 != null) {
            datePickerDialog.setButton(-1, str2, datePickerDialog);
        }
        if (str3 != null) {
            datePickerDialog.setButton(-2, str3, datePickerDialog);
        }
        datePickerDialog.setCancelable(false);
        datePickerDialog.setCanceledOnTouchOutside(false);
        datePickerDialog.show();
        DatePickerDialog datePickerDialog2 = datePickerDialog;
        this$0.dialog = datePickerDialog2;
        if (str2 != null && (button = datePickerDialog2.getButton(-1)) != null) {
            button.setAllCaps(false);
        }
        if (str3 != null) {
            AlertDialog alertDialog = this$0.dialog;
            Button button2 = alertDialog != null ? alertDialog.getButton(-2) : null;
            if (button2 == null) {
                return;
            }
            button2.setAllCaps(false);
        }
    }

    public final void showTimePickerDialog(final TimePickerDialog.OnTimeSetListener listener, final int hourOfDay, final int minute, final boolean is24HourView, final String title, final String okBtnStr, final String cancelBtnStr) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        cancelDialog();
        runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.showTimePickerDialog$lambda$12(this.f$0, listener, hourOfDay, minute, is24HourView, title, okBtnStr, cancelBtnStr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTimePickerDialog$lambda$12(BaseActivity this$0, TimePickerDialog.OnTimeSetListener listener, int i, int i2, boolean z, String str, String str2, String str3) {
        Button button;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        TimePickerDialog timePickerDialog = new TimePickerDialog(this$0, R.style.MaterialCalendarCustomStyle, listener, i, i2, z);
        timePickerDialog.setCancelable(false);
        timePickerDialog.setCanceledOnTouchOutside(false);
        if (str != null) {
            timePickerDialog.setTitle(str);
        }
        if (str2 != null) {
            timePickerDialog.setButton(-1, str2, timePickerDialog);
        }
        if (str3 != null) {
            timePickerDialog.setButton(-2, str3, timePickerDialog);
        }
        timePickerDialog.show();
        TimePickerDialog timePickerDialog2 = timePickerDialog;
        this$0.dialog = timePickerDialog2;
        if (str2 != null && (button = timePickerDialog2.getButton(-1)) != null) {
            button.setAllCaps(false);
        }
        if (str3 != null) {
            AlertDialog alertDialog = this$0.dialog;
            Button button2 = alertDialog != null ? alertDialog.getButton(-2) : null;
            if (button2 == null) {
                return;
            }
            button2.setAllCaps(false);
        }
    }

    public final void cancelDialog() {
        runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.cancelDialog$lambda$13(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelDialog$lambda$13(BaseActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlertDialog alertDialog = this$0.dialog;
        if (alertDialog != null) {
            try {
                Intrinsics.checkNotNull(alertDialog);
                alertDialog.dismiss();
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
            }
        }
    }

    public final boolean isDialogShow() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }

    public final void checkPermission(String[] permission, int requestCode) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        ActivityCompat.requestPermissions(this, permission, requestCode);
    }

    public final void setScreenOn(boolean on) {
        if (getWindow() != null) {
            if (on) {
                getWindow().addFlags(128);
            } else {
                getWindow().clearFlags(128);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031 A[PHI: r1
      0x0031: PHI (r1v4 java.lang.String) = (r1v3 java.lang.String), (r1v7 java.lang.String) binds: [B:9:0x002e, B:6:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getAppVersionName() {
        /*
            r5 = this;
            java.lang.String r0 = "unknown"
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L32
            r2 = 33
            if (r1 < r2) goto L1f
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch: java.lang.Exception -> L32
            java.lang.String r2 = r5.getPackageName()     // Catch: java.lang.Exception -> L32
            r3 = 0
            android.content.pm.PackageManager$PackageInfoFlags r3 = android.content.pm.PackageManager.PackageInfoFlags.of(r3)     // Catch: java.lang.Exception -> L32
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r3)     // Catch: java.lang.Exception -> L32
            java.lang.String r1 = r1.versionName     // Catch: java.lang.Exception -> L32
            if (r1 != 0) goto L31
            goto L32
        L1f:
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch: java.lang.Exception -> L32
            java.lang.String r2 = r5.getPackageName()     // Catch: java.lang.Exception -> L32
            r3 = 0
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r3)     // Catch: java.lang.Exception -> L32
            java.lang.String r1 = r1.versionName     // Catch: java.lang.Exception -> L32
            if (r1 != 0) goto L31
            goto L32
        L31:
            r0 = r1
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui._base.BaseActivity.getAppVersionName():java.lang.String");
    }

    public final void openUrlByWeb(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    public static /* synthetic */ void showPairingDialog$default(BaseActivity baseActivity, int i, String str, OnPairingDialogDismissListener onPairingDialogDismissListener, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPairingDialog");
        }
        if ((i2 & 4) != 0) {
            onPairingDialogDismissListener = null;
        }
        baseActivity.showPairingDialog(i, str, onPairingDialogDismissListener);
    }

    public final void showPairingDialog(final int type, final String name, final OnPairingDialogDismissListener onPairingDialogDismissListener) {
        runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.showPairingDialog$lambda$15(this.f$0, type, name, onPairingDialogDismissListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPairingDialog$lambda$15(final BaseActivity this$0, int i, String str, final OnPairingDialogDismissListener onPairingDialogDismissListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlertDialog alertDialog = this$0.pairingDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        BaseActivity baseActivity = this$0;
        CustomPairingDialogBinding customPairingDialogBindingInflate = CustomPairingDialogBinding.inflate(LayoutInflater.from(baseActivity));
        Intrinsics.checkNotNullExpressionValue(customPairingDialogBindingInflate, "inflate(...)");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(baseActivity, R.style.CustomDialog).setView(customPairingDialogBindingInflate.getRoot()).setCancelable(false).create();
        this$0.pairingDialog = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.show();
        }
        customPairingDialogBindingInflate.LLPairSuccess.setVisibility(8);
        customPairingDialogBindingInflate.LLPairFailed.setVisibility(8);
        customPairingDialogBindingInflate.LLPairingProgressbar.setVisibility(8);
        customPairingDialogBindingInflate.LLDisconnect.setVisibility(8);
        if (i == 0) {
            customPairingDialogBindingInflate.LLPairingProgressbar.setVisibility(0);
        } else if (i == 1) {
            TextView textView = customPairingDialogBindingInflate.tvSuccess;
            int i2 = R.string.device_paired;
            if (str == null) {
                str = "";
            }
            textView.setText(this$0.getString(i2, new Object[]{str}));
            customPairingDialogBindingInflate.LLPairSuccess.setVisibility(0);
        } else if (i == 2) {
            customPairingDialogBindingInflate.LLPairFailed.setVisibility(0);
        } else if (i == 3) {
            customPairingDialogBindingInflate.LLDisconnect.setVisibility(0);
        }
        if (i == 1 || i == 2 || i == 3) {
            customPairingDialogBindingInflate.getRoot().removeCallbacks(this$0.closePairDialogRunnable);
            customPairingDialogBindingInflate.getRoot().postDelayed(this$0.closePairDialogRunnable, 2000L);
        } else {
            customPairingDialogBindingInflate.getRoot().removeCallbacks(this$0.closePairDialogRunnable);
            customPairingDialogBindingInflate.getRoot().postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    BaseActivity.showPairingDialog$lambda$15$lambda$14(this.f$0, onPairingDialogDismissListener);
                }
            }, 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPairingDialog$lambda$15$lambda$14(BaseActivity this$0, OnPairingDialogDismissListener onPairingDialogDismissListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isFinishing() || this$0.isDestroyed()) {
            return;
        }
        AlertDialog alertDialog = this$0.pairingDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (onPairingDialogDismissListener != null) {
            onPairingDialogDismissListener.onPairingDialogDismissed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void closePairDialogRunnable$lambda$16(BaseActivity this$0) {
        AlertDialog alertDialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isFinishing() || this$0.isDestroyed() || (alertDialog = this$0.pairingDialog) == null) {
            return;
        }
        alertDialog.dismiss();
    }

    /* compiled from: BaseActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._base.BaseActivity$callApiCheckAppUpdate$1", f = "BaseActivity.kt", i = {}, l = {WinError.ERROR_EVENT_DONE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui._base.BaseActivity$callApiCheckAppUpdate$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = DyacoApiKt.callCheckAppUpdate(new CheckAppUpdateApi.Request(null, null, null, 7, null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                CheckAppUpdateApi.ResponseData responseData = (CheckAppUpdateApi.ResponseData) ((Response) obj).body();
                if (responseData != null && responseData.getSuccess()) {
                    CheckAppUpdateApi.DataMap dataMap = responseData.getDataMap();
                    CheckAppUpdateApi.UpdateInfo data = dataMap != null ? dataMap.getData() : null;
                    if (data != null && data.isForceUpgrade()) {
                        Long newestVersionInt = data.getNewestVersionInt();
                        if (255 < ((int) (newestVersionInt != null ? newestVersionInt.longValue() : 0L)) && !BaseActivity.this.isFinishing() && !BaseActivity.this.isDestroyed()) {
                            BaseActivity baseActivity = BaseActivity.this;
                            baseActivity.showAppUpdateDialog(baseActivity.isHasGooglePlay());
                        }
                    }
                }
                return Unit.INSTANCE;
            } catch (Exception e) {
                Timber.INSTANCE.e("Error all: " + e, new Object[0]);
                return Unit.INSTANCE;
            }
        }
    }

    public final void callApiCheckAppUpdate() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void showAppUpdateDialog(final boolean isHasGooglePlay) {
        runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.showAppUpdateDialog$lambda$18(this.f$0, isHasGooglePlay);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAppUpdateDialog$lambda$18(final BaseActivity this$0, final boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isFinishing() || this$0.isDestroyed()) {
            return;
        }
        String string = this$0.getString(R.string.app_update_dialog_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this$0.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        showBaseDialog$default(this$0, null, string, string2, new DialogInterface.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui._base.BaseActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                BaseActivity.showAppUpdateDialog$lambda$18$lambda$17(z, this$0, dialogInterface, i);
            }
        }, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAppUpdateDialog$lambda$18$lambda$17(boolean z, BaseActivity this$0, DialogInterface dialogInterface, int i) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        if (!z) {
            str = AppConfig.BAIDU_APP_URL;
        } else {
            str = "https://play.google.com/store/apps/details?id=" + this$0.getPackageName();
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (z) {
                intent.setPackage("com.android.vending");
            }
            this$0.startActivity(intent);
        } catch (Exception e) {
            Timber.INSTANCE.e(e, "Google Play redirect failed, trying alternative", new Object[0]);
            try {
                this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(AppConfig.BAIDU_APP_URL)));
            } catch (Exception e2) {
                Timber.INSTANCE.e(e2, "Alternative URL failed", new Object[0]);
            }
        }
    }

    public final boolean isHasGooglePlay() {
        try {
            return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MyApplication.INSTANCE.getAppContext()) == 0;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return false;
        }
    }
}
