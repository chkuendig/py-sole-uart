package com.soletreadmills.sole_v2.ui._shared;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.databinding.DialogIosOnePickerBottomSheetBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IosOnePickerBottomSheetDialog.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001#B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001fH\u0016R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_shared/IosOnePickerBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "list", "", "", "currentPosition", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/ui/_shared/IosOnePickerBottomSheetDialog$Listener;", "title", "isShowTitle", "", "(Landroid/content/Context;Ljava/util/List;ILcom/soletreadmills/sole_v2/ui/_shared/IosOnePickerBottomSheetDialog$Listener;Ljava/lang/String;Z)V", "binding", "Lcom/soletreadmills/sole_v2/databinding/DialogIosOnePickerBottomSheetBinding;", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/DialogIosOnePickerBottomSheetBinding;", "()Z", "setShowTitle", "(Z)V", "getList", "()Ljava/util/List;", "getListener", "()Lcom/soletreadmills/sole_v2/ui/_shared/IosOnePickerBottomSheetDialog$Listener;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "show", "Listener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IosOnePickerBottomSheetDialog extends BottomSheetDialog {
    public static final int $stable = 8;
    private final DialogIosOnePickerBottomSheetBinding binding;
    private boolean isShowTitle;
    private final List<String> list;
    private final Listener listener;
    private String title;

    /* compiled from: IosOnePickerBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_shared/IosOnePickerBottomSheetDialog$Listener;", "", "onApply", "", "iosOnePickerBottomSheetDialog", "Lcom/soletreadmills/sole_v2/ui/_shared/IosOnePickerBottomSheetDialog;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onApply(IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog);
    }

    public final List<String> getList() {
        return this.list;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public /* synthetic */ IosOnePickerBottomSheetDialog(Context context, List list, int i, Listener listener, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, i, listener, (i2 & 16) != 0 ? "" : str, (i2 & 32) != 0 ? false : z);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    /* renamed from: isShowTitle, reason: from getter */
    public final boolean getIsShowTitle() {
        return this.isShowTitle;
    }

    public final void setShowTitle(boolean z) {
        this.isShowTitle = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IosOnePickerBottomSheetDialog(Context context, List<String> list, int i, Listener listener, String title, boolean z) {
        super(context, R.style.TransparentBottomSheetDialogTheme);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(title, "title");
        this.list = list;
        this.listener = listener;
        this.title = title;
        this.isShowTitle = z;
        DialogIosOnePickerBottomSheetBinding dialogIosOnePickerBottomSheetBindingInflate = DialogIosOnePickerBottomSheetBinding.inflate(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(dialogIosOnePickerBottomSheetBindingInflate, "inflate(...)");
        this.binding = dialogIosOnePickerBottomSheetBindingInflate;
        setContentView(dialogIosOnePickerBottomSheetBindingInflate.getRoot());
        dialogIosOnePickerBottomSheetBindingInflate.loop.setTextSize(17.0f);
        dialogIosOnePickerBottomSheetBindingInflate.loop.setNotLoop();
        dialogIosOnePickerBottomSheetBindingInflate.loop.setItems(list);
        dialogIosOnePickerBottomSheetBindingInflate.loop.setInitPosition(0);
        dialogIosOnePickerBottomSheetBindingInflate.loop.setTypeface(ResourcesCompat.getFont(context, R.font.inter_medium_500));
        dialogIosOnePickerBottomSheetBindingInflate.loop.setCurrentPosition(i <= 0 ? 0 : i);
        dialogIosOnePickerBottomSheetBindingInflate.loop.setCenterTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
        if (this.isShowTitle) {
            dialogIosOnePickerBottomSheetBindingInflate.CLTitle.setVisibility(0);
            dialogIosOnePickerBottomSheetBindingInflate.title.setText(this.title);
        } else {
            dialogIosOnePickerBottomSheetBindingInflate.CLTitle.setVisibility(8);
        }
    }

    public final DialogIosOnePickerBottomSheetBinding getBinding() {
        return this.binding;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding.apply.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IosOnePickerBottomSheetDialog.onCreate$lambda$0(this.f$0, view);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IosOnePickerBottomSheetDialog.onCreate$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(IosOnePickerBottomSheetDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listener.onApply(this$0);
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(IosOnePickerBottomSheetDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        Window window = getWindow();
        View viewFindViewById = window != null ? window.findViewById(com.google.android.material.R.id.design_bottom_sheet) : null;
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setDimAmount(0.5f);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getContext(), R.color.gray_01000000)));
        }
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundTintMode(PorterDuff.Mode.CLEAR);
        }
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.gray_01000000)));
        }
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(0);
        }
        super.show();
    }
}
