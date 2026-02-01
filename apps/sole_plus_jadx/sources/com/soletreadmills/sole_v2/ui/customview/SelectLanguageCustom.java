package com.soletreadmills.sole_v2.ui.customview;

import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.databinding.CustomSelectLanguageBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui.adapter.settings.LanguageSettingsAdapter;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectLanguageCustom.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectLanguageCustom;", "Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "defaultLocale", "Ljava/util/Locale;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/ui/customview/SelectLanguageCustom$SelectLanguageListener;", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Ljava/util/Locale;Lcom/soletreadmills/sole_v2/ui/customview/SelectLanguageCustom$SelectLanguageListener;)V", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomSelectLanguageBinding;", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/CustomSelectLanguageBinding;", "getDefaultLocale", "()Ljava/util/Locale;", "getListener", "()Lcom/soletreadmills/sole_v2/ui/customview/SelectLanguageCustom$SelectLanguageListener;", "onBackPressed", "", SdkConstants.ATTR_ON_CLICK, "", "v", "Landroid/view/View;", "setRecycleView", "SelectLanguageListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectLanguageCustom extends BaseRelativeLayout {
    public static final int $stable = 8;
    private final CustomSelectLanguageBinding binding;
    private final Locale defaultLocale;
    private final SelectLanguageListener listener;

    /* compiled from: SelectLanguageCustom.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectLanguageCustom$SelectLanguageListener;", "", SdkConstants.ATTR_ON_CLICK, "", "selectLocale", "Ljava/util/Locale;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface SelectLanguageListener {
        void onClick(Locale selectLocale);
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout
    public boolean onBackPressed() {
        return false;
    }

    public final Locale getDefaultLocale() {
        return this.defaultLocale;
    }

    public final SelectLanguageListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectLanguageCustom(MainActivity mainActivity, Locale locale, SelectLanguageListener listener) {
        super(mainActivity, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.defaultLocale = locale;
        this.listener = listener;
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(mainActivity), R.layout.custom_select_language, this, true);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        CustomSelectLanguageBinding customSelectLanguageBinding = (CustomSelectLanguageBinding) viewDataBindingInflate;
        this.binding = customSelectLanguageBinding;
        SelectLanguageCustom selectLanguageCustom = this;
        customSelectLanguageBinding.close.setOnClickListener(selectLanguageCustom);
        customSelectLanguageBinding.LLDone.setOnClickListener(selectLanguageCustom);
        setRecycleView();
    }

    public final CustomSelectLanguageBinding getBinding() {
        return this.binding;
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout, android.view.View.OnClickListener
    public void onClick(View v) {
        Locale selectLocale;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 == R.id.close) {
            getMainActivity().onBackPressed();
            return;
        }
        if (id2 == R.id.LL_done) {
            RecyclerView.Adapter adapter = this.binding.recyclerview.getAdapter();
            if ((adapter instanceof LanguageSettingsAdapter) && (selectLocale = ((LanguageSettingsAdapter) adapter).getSelectLocale()) != null) {
                this.listener.onClick(selectLocale);
            }
        }
    }

    private final void setRecycleView() {
        if (!(this.binding.recyclerview.getLayoutManager() instanceof GridLayoutManager)) {
            this.binding.recyclerview.setLayoutManager(new GridLayoutManager(getMainActivity(), 2));
        }
        this.binding.recyclerview.setItemAnimator(null);
        if (this.binding.recyclerview.getAdapter() instanceof LanguageSettingsAdapter) {
            return;
        }
        this.binding.recyclerview.setAdapter(new LanguageSettingsAdapter(getMainActivity(), this.defaultLocale));
    }
}
