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
import com.soletreadmills.sole_v2._data.classes.DurationData;
import com.soletreadmills.sole_v2._type.DurationType;
import com.soletreadmills.sole_v2.databinding.CustomSelectDurationBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui.adapter.customview.SelectDurationAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectDurationCustom.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectDurationCustom;", "Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "durationDataList", "", "Lcom/soletreadmills/sole_v2/_data/classes/DurationData;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/ui/customview/SelectDurationCustom$SelectDurationCustomListener;", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Ljava/util/List;Lcom/soletreadmills/sole_v2/ui/customview/SelectDurationCustom$SelectDurationCustomListener;)V", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomSelectDurationBinding;", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/CustomSelectDurationBinding;", "getDurationDataList", "()Ljava/util/List;", "isReset", "", "()Z", "setReset", "(Z)V", "getListener", "()Lcom/soletreadmills/sole_v2/ui/customview/SelectDurationCustom$SelectDurationCustomListener;", "closeView", "", "onBackPressed", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setChangeView", "setRecycleView", "SelectDurationCustomListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectDurationCustom extends BaseRelativeLayout {
    public static final int $stable = 8;
    private final CustomSelectDurationBinding binding;
    private final List<DurationData> durationDataList;
    private boolean isReset;
    private final SelectDurationCustomListener listener;

    /* compiled from: SelectDurationCustom.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectDurationCustom$SelectDurationCustomListener;", "", SdkConstants.ATTR_ON_CLICK, "", "durationDataList", "", "Lcom/soletreadmills/sole_v2/_data/classes/DurationData;", "onReset", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface SelectDurationCustomListener {
        void onClick(List<DurationData> durationDataList);

        void onReset();
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout
    public boolean onBackPressed() {
        return false;
    }

    public final List<DurationData> getDurationDataList() {
        return this.durationDataList;
    }

    public final SelectDurationCustomListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectDurationCustom(MainActivity mainActivity, List<DurationData> durationDataList, SelectDurationCustomListener listener) {
        super(mainActivity, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
        Intrinsics.checkNotNullParameter(durationDataList, "durationDataList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.durationDataList = durationDataList;
        this.listener = listener;
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(mainActivity), R.layout.custom_select_duration, this, true);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        CustomSelectDurationBinding customSelectDurationBinding = (CustomSelectDurationBinding) viewDataBindingInflate;
        this.binding = customSelectDurationBinding;
        SelectDurationCustom selectDurationCustom = this;
        customSelectDurationBinding.close.setOnClickListener(selectDurationCustom);
        customSelectDurationBinding.reset.setOnClickListener(selectDurationCustom);
        customSelectDurationBinding.LLDone.setOnClickListener(selectDurationCustom);
        setRecycleView();
    }

    /* renamed from: isReset, reason: from getter */
    public final boolean getIsReset() {
        return this.isReset;
    }

    public final void setReset(boolean z) {
        this.isReset = z;
    }

    public final CustomSelectDurationBinding getBinding() {
        return this.binding;
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout, android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 == R.id.close) {
            getMainActivity().onBackPressed();
            return;
        }
        if (id2 == R.id.reset) {
            RecyclerView.Adapter adapter = this.binding.rv.getAdapter();
            if (adapter instanceof SelectDurationAdapter) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new DurationData(DurationType.MIN_5, false, 2, null));
                arrayList.add(new DurationData(DurationType.MIN_10, false, 2, null));
                arrayList.add(new DurationData(DurationType.MIN_15, false, 2, null));
                arrayList.add(new DurationData(DurationType.MIN_20, false, 2, null));
                arrayList.add(new DurationData(DurationType.MIN_30, false, 2, null));
                arrayList.add(new DurationData(DurationType.MIN_45, false, 2, null));
                arrayList.add(new DurationData(DurationType.MIN_60, false, 2, null));
                this.isReset = true;
                ((SelectDurationAdapter) adapter).submitList(arrayList);
                this.binding.reset.setVisibility(4);
                this.binding.done.setText(getMainActivity().getString(R.string.done));
                return;
            }
            return;
        }
        if (id2 == R.id.LL_done) {
            closeView();
        }
    }

    private final void setRecycleView() {
        if (!(this.binding.rv.getLayoutManager() instanceof GridLayoutManager)) {
            this.binding.rv.setLayoutManager(new GridLayoutManager(getMainActivity(), 4));
        }
        this.binding.rv.setItemAnimator(null);
        if (!(this.binding.rv.getAdapter() instanceof SelectDurationAdapter)) {
            this.binding.rv.setAdapter(new SelectDurationAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.SelectDurationCustom$setRecycleView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    RecyclerView.Adapter adapter = this.this$0.getBinding().rv.getAdapter();
                    if (adapter instanceof SelectDurationAdapter) {
                        SelectDurationAdapter selectDurationAdapter = (SelectDurationAdapter) adapter;
                        List<DurationData> currentList = selectDurationAdapter.getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        currentList.get(pos).setSelect(!r1.isSelect());
                        selectDurationAdapter.notifyItemChanged(pos);
                        this.this$0.setChangeView();
                    }
                }
            }));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<DurationData> it = this.durationDataList.iterator();
        while (it.hasNext()) {
            arrayList.add(DurationData.copy$default(it.next(), null, false, 3, null));
        }
        RecyclerView.Adapter adapter = this.binding.rv.getAdapter();
        if (adapter instanceof SelectDurationAdapter) {
            ((SelectDurationAdapter) adapter).submitList(arrayList);
            setChangeView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setChangeView() {
        RecyclerView.Adapter adapter = this.binding.rv.getAdapter();
        if (adapter instanceof SelectDurationAdapter) {
            List<DurationData> currentList = ((SelectDurationAdapter) adapter).getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            Iterator<DurationData> it = currentList.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().isSelect()) {
                    i++;
                }
            }
            if (i == 0) {
                this.binding.reset.setVisibility(4);
                this.binding.done.setText(getMainActivity().getString(R.string.done));
            } else {
                this.binding.reset.setVisibility(0);
                this.binding.done.setText(getMainActivity().getString(R.string.apply_filter, new Object[]{String.valueOf(i)}));
            }
        }
    }

    private final void closeView() {
        RecyclerView.Adapter adapter = this.binding.rv.getAdapter();
        ArrayList arrayList = new ArrayList();
        if (adapter instanceof SelectDurationAdapter) {
            List<DurationData> currentList = ((SelectDurationAdapter) adapter).getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            for (DurationData durationData : currentList) {
                Intrinsics.checkNotNull(durationData);
                arrayList.add(DurationData.copy$default(durationData, null, false, 3, null));
            }
        }
        this.listener.onClick(arrayList);
        if (this.isReset) {
            this.listener.onReset();
        }
        getMainActivity().onBackPressed();
    }
}
