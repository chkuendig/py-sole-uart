package com.soletreadmills.sole_v2.ui._dialog;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.divider.MaterialDividerItemDecoration;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.databinding.DialogIosAlertActionSheetBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.IosAlertActionSheetDialogAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IosAlertActionSheetDialog.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_dialog/IosAlertActionSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "itemList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "binding", "Lcom/soletreadmills/sole_v2/databinding/DialogIosAlertActionSheetBinding;", "getItemList", "()Ljava/util/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/ui/_dialog/IosAlertActionSheetDialog$Listener;", "getListener", "()Lcom/soletreadmills/sole_v2/ui/_dialog/IosAlertActionSheetDialog$Listener;", "setListener", "(Lcom/soletreadmills/sole_v2/ui/_dialog/IosAlertActionSheetDialog$Listener;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "show", "Listener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IosAlertActionSheetDialog extends BottomSheetDialog {
    public static final int $stable = 8;
    private final DialogIosAlertActionSheetBinding binding;
    private final ArrayList<String> itemList;
    private Listener listener;

    /* compiled from: IosAlertActionSheetDialog.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_dialog/IosAlertActionSheetDialog$Listener;", "", "onItemClick", "", "position", "", SdkConstants.TAG_ITEM, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onItemClick(int position, String item);
    }

    public final ArrayList<String> getItemList() {
        return this.itemList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IosAlertActionSheetDialog(Context context, ArrayList<String> itemList) {
        super(context, R.style.TransparentBottomSheetDialogTheme);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        this.itemList = itemList;
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_ios_alert_action_sheet, null, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        DialogIosAlertActionSheetBinding dialogIosAlertActionSheetBinding = (DialogIosAlertActionSheetBinding) viewDataBindingInflate;
        this.binding = dialogIosAlertActionSheetBinding;
        setContentView(dialogIosAlertActionSheetBinding.getRoot());
        dialogIosAlertActionSheetBinding.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui._dialog.IosAlertActionSheetDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IosAlertActionSheetDialog._init_$lambda$0(this.f$0, view);
            }
        });
        if (!(dialogIosAlertActionSheetBinding.list.getLayoutManager() instanceof LinearLayoutManager)) {
            dialogIosAlertActionSheetBinding.list.setLayoutManager(new LinearLayoutManager(context));
        }
        if (dialogIosAlertActionSheetBinding.list.getItemDecorationCount() == 0) {
            MaterialDividerItemDecoration materialDividerItemDecoration = new MaterialDividerItemDecoration(context, 1);
            materialDividerItemDecoration.setDividerColor(ContextCompat.getColor(context, R.color.colorLabel_outline));
            materialDividerItemDecoration.setLastItemDecorated(false);
            dialogIosAlertActionSheetBinding.list.addItemDecoration(materialDividerItemDecoration);
        }
        IosAlertActionSheetDialogAdapter iosAlertActionSheetDialogAdapter = new IosAlertActionSheetDialogAdapter(itemList);
        iosAlertActionSheetDialogAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui._dialog.IosAlertActionSheetDialog.2
            @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
            public void onClick(int pos, String string) {
                Intrinsics.checkNotNullParameter(string, "string");
            }

            @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
            public void onClick(int pos) {
                IosAlertActionSheetDialog.this.dismiss();
                Listener listener = IosAlertActionSheetDialog.this.getListener();
                if (listener != null) {
                    String str = IosAlertActionSheetDialog.this.getItemList().get(pos);
                    Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                    listener.onItemClick(pos, str);
                }
            }
        });
        dialogIosAlertActionSheetBinding.list.setAdapter(iosAlertActionSheetDialogAdapter);
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final void setListener(Listener listener) {
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(IosAlertActionSheetDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
