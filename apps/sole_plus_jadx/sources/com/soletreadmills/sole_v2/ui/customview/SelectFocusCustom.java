package com.soletreadmills.sole_v2.ui.customview;

import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.classes.FocusData;
import com.soletreadmills.sole_v2._type.FocusType;
import com.soletreadmills.sole_v2.databinding.CustomSelectFocusBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui.adapter.customview.SelectFocusAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectFocusCustom.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectFocusCustom;", "Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "focusDataList", "", "Lcom/soletreadmills/sole_v2/_data/classes/FocusData;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/ui/customview/SelectFocusCustom$SelectFocusCustomListener;", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Ljava/util/List;Lcom/soletreadmills/sole_v2/ui/customview/SelectFocusCustom$SelectFocusCustomListener;)V", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomSelectFocusBinding;", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/CustomSelectFocusBinding;", "getFocusDataList", "()Ljava/util/List;", "isReset", "", "()Z", "setReset", "(Z)V", "getListener", "()Lcom/soletreadmills/sole_v2/ui/customview/SelectFocusCustom$SelectFocusCustomListener;", "closeView", "", "onBackPressed", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setChangeView", "setRecycleView", "SelectFocusCustomListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectFocusCustom extends BaseRelativeLayout {
    public static final int $stable = 8;
    private final CustomSelectFocusBinding binding;
    private final List<FocusData> focusDataList;
    private boolean isReset;
    private final SelectFocusCustomListener listener;

    /* compiled from: SelectFocusCustom.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectFocusCustom$SelectFocusCustomListener;", "", SdkConstants.ATTR_ON_CLICK, "", "durationDataList", "", "Lcom/soletreadmills/sole_v2/_data/classes/FocusData;", "onReset", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface SelectFocusCustomListener {
        void onClick(List<FocusData> durationDataList);

        void onReset();
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout
    public boolean onBackPressed() {
        return false;
    }

    public final List<FocusData> getFocusDataList() {
        return this.focusDataList;
    }

    public final SelectFocusCustomListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectFocusCustom(MainActivity mainActivity, List<FocusData> focusDataList, SelectFocusCustomListener listener) {
        super(mainActivity, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
        Intrinsics.checkNotNullParameter(focusDataList, "focusDataList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.focusDataList = focusDataList;
        this.listener = listener;
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(mainActivity), R.layout.custom_select_focus, this, true);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        CustomSelectFocusBinding customSelectFocusBinding = (CustomSelectFocusBinding) viewDataBindingInflate;
        this.binding = customSelectFocusBinding;
        SelectFocusCustom selectFocusCustom = this;
        customSelectFocusBinding.close.setOnClickListener(selectFocusCustom);
        customSelectFocusBinding.reset.setOnClickListener(selectFocusCustom);
        customSelectFocusBinding.LLDone.setOnClickListener(selectFocusCustom);
        setRecycleView();
    }

    public final CustomSelectFocusBinding getBinding() {
        return this.binding;
    }

    /* renamed from: isReset, reason: from getter */
    public final boolean getIsReset() {
        return this.isReset;
    }

    public final void setReset(boolean z) {
        this.isReset = z;
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
            if (adapter instanceof SelectFocusAdapter) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new FocusData(FocusType.ENDURANCE, false, 2, null));
                arrayList.add(new FocusData(FocusType.INTERVALS, false, 2, null));
                arrayList.add(new FocusData(FocusType.HILLS, false, 2, null));
                arrayList.add(new FocusData(FocusType.SPRINTS, false, 2, null));
                arrayList.add(new FocusData(FocusType.WALKS, false, 2, null));
                ((SelectFocusAdapter) adapter).submitList(arrayList);
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
        if (!(this.binding.rv.getLayoutManager() instanceof FlexboxLayoutManager)) {
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getMainActivity());
            flexboxLayoutManager.setFlexWrap(1);
            flexboxLayoutManager.setJustifyContent(2);
            flexboxLayoutManager.setAlignItems(2);
            this.binding.rv.setLayoutManager(flexboxLayoutManager);
        }
        this.binding.rv.setItemAnimator(null);
        if (!(this.binding.rv.getAdapter() instanceof SelectFocusAdapter)) {
            this.binding.rv.setAdapter(new SelectFocusAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.SelectFocusCustom$setRecycleView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    RecyclerView.Adapter adapter = this.this$0.getBinding().rv.getAdapter();
                    if (adapter instanceof SelectFocusAdapter) {
                        SelectFocusAdapter selectFocusAdapter = (SelectFocusAdapter) adapter;
                        List<FocusData> currentList = selectFocusAdapter.getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        currentList.get(pos).setSelect(!r1.isSelect());
                        selectFocusAdapter.notifyItemChanged(pos);
                        this.this$0.setChangeView();
                    }
                }
            }));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<FocusData> it = this.focusDataList.iterator();
        while (it.hasNext()) {
            arrayList.add(FocusData.copy$default(it.next(), null, false, 3, null));
        }
        RecyclerView.Adapter adapter = this.binding.rv.getAdapter();
        if (adapter instanceof SelectFocusAdapter) {
            ((SelectFocusAdapter) adapter).submitList(arrayList);
            setChangeView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setChangeView() {
        RecyclerView.Adapter adapter = this.binding.rv.getAdapter();
        if (adapter instanceof SelectFocusAdapter) {
            List<FocusData> currentList = ((SelectFocusAdapter) adapter).getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            Iterator<FocusData> it = currentList.iterator();
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
        if (adapter instanceof SelectFocusAdapter) {
            List<FocusData> currentList = ((SelectFocusAdapter) adapter).getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            for (FocusData focusData : currentList) {
                Intrinsics.checkNotNull(focusData);
                arrayList.add(FocusData.copy$default(focusData, null, false, 3, null));
            }
        }
        this.listener.onClick(arrayList);
        if (this.isReset) {
            this.listener.onReset();
        }
        getMainActivity().onBackPressed();
    }
}
