package com.soletreadmills.sole_v2.ui.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.MyApplication;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.classes.ClassInstructorsDataBase;
import com.soletreadmills.sole_v2._data.api.classes.CollectionInstructorsData;
import com.soletreadmills.sole_v2._data.api.classes.SessionInstructorsData;
import com.soletreadmills.sole_v2._tools.UiTool;
import com.soletreadmills.sole_v2.databinding.CustomSelectInstructorsBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui.adapter.customview.SelectInstructorItemAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectInstructorsCustom.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001!B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectInstructorsCustom;", "Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "instructorsList", "", "Lcom/soletreadmills/sole_v2/_data/api/classes/ClassInstructorsDataBase;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/ui/customview/SelectInstructorsCustom$SelectDurationCustomListener;", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Ljava/util/List;Lcom/soletreadmills/sole_v2/ui/customview/SelectInstructorsCustom$SelectDurationCustomListener;)V", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomSelectInstructorsBinding;", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/CustomSelectInstructorsBinding;", "getInstructorsList", "()Ljava/util/List;", "isReset", "", "()Z", "setReset", "(Z)V", "getListener", "()Lcom/soletreadmills/sole_v2/ui/customview/SelectInstructorsCustom$SelectDurationCustomListener;", "closeView", "", "onBackPressed", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setChangeView", "setRecycleView", "setStatusBarHeight", "statusBarView", "SelectDurationCustomListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectInstructorsCustom extends BaseRelativeLayout {
    public static final int $stable = 8;
    private final CustomSelectInstructorsBinding binding;
    private final List<ClassInstructorsDataBase> instructorsList;
    private boolean isReset;
    private final SelectDurationCustomListener listener;

    /* compiled from: SelectInstructorsCustom.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectInstructorsCustom$SelectDurationCustomListener;", "", SdkConstants.ATTR_ON_CLICK, "", "list", "", "Lcom/soletreadmills/sole_v2/_data/api/classes/ClassInstructorsDataBase;", "onReset", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface SelectDurationCustomListener {
        void onClick(List<ClassInstructorsDataBase> list);

        void onReset();
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout
    public boolean onBackPressed() {
        return false;
    }

    public final List<ClassInstructorsDataBase> getInstructorsList() {
        return this.instructorsList;
    }

    public final SelectDurationCustomListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectInstructorsCustom(MainActivity mainActivity, List<ClassInstructorsDataBase> instructorsList, SelectDurationCustomListener listener) {
        super(mainActivity, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
        Intrinsics.checkNotNullParameter(instructorsList, "instructorsList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.instructorsList = instructorsList;
        this.listener = listener;
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(mainActivity), R.layout.custom_select_instructors, this, true);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        CustomSelectInstructorsBinding customSelectInstructorsBinding = (CustomSelectInstructorsBinding) viewDataBindingInflate;
        this.binding = customSelectInstructorsBinding;
        View statusBarHeight = customSelectInstructorsBinding.statusBarHeight;
        Intrinsics.checkNotNullExpressionValue(statusBarHeight, "statusBarHeight");
        setStatusBarHeight(statusBarHeight);
        SelectInstructorsCustom selectInstructorsCustom = this;
        customSelectInstructorsBinding.close.setOnClickListener(selectInstructorsCustom);
        customSelectInstructorsBinding.reset.setOnClickListener(selectInstructorsCustom);
        customSelectInstructorsBinding.LLDone.setOnClickListener(selectInstructorsCustom);
        setRecycleView();
    }

    public final CustomSelectInstructorsBinding getBinding() {
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
            RecyclerView.Adapter adapter = this.binding.recyclerview.getAdapter();
            if (adapter instanceof SelectInstructorItemAdapter) {
                ArrayList arrayList = new ArrayList();
                SelectInstructorItemAdapter selectInstructorItemAdapter = (SelectInstructorItemAdapter) adapter;
                List<ClassInstructorsDataBase> currentList = selectInstructorItemAdapter.getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                for (CollectionInstructorsData collectionInstructorsDataCopy$default : currentList) {
                    if (collectionInstructorsDataCopy$default instanceof SessionInstructorsData) {
                        Intrinsics.checkNotNull(collectionInstructorsDataCopy$default);
                        collectionInstructorsDataCopy$default = SessionInstructorsData.copy$default((SessionInstructorsData) collectionInstructorsDataCopy$default, null, false, 1, null);
                    } else if (collectionInstructorsDataCopy$default instanceof CollectionInstructorsData) {
                        Intrinsics.checkNotNull(collectionInstructorsDataCopy$default);
                        collectionInstructorsDataCopy$default = CollectionInstructorsData.copy$default((CollectionInstructorsData) collectionInstructorsDataCopy$default, null, false, 1, null);
                    } else {
                        collectionInstructorsDataCopy$default.setSelect(false);
                    }
                    Intrinsics.checkNotNull(collectionInstructorsDataCopy$default);
                    arrayList.add(collectionInstructorsDataCopy$default);
                }
                selectInstructorItemAdapter.submitList(arrayList);
                selectInstructorItemAdapter.notifyDataSetChanged();
                this.isReset = true;
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
        if (!(this.binding.recyclerview.getLayoutManager() instanceof GridLayoutManager)) {
            this.binding.recyclerview.setLayoutManager(new GridLayoutManager(getMainActivity(), 3));
        }
        this.binding.recyclerview.setItemAnimator(null);
        RecyclerView.ItemAnimator itemAnimator = this.binding.recyclerview.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        if (!(this.binding.recyclerview.getAdapter() instanceof SelectInstructorItemAdapter)) {
            this.binding.recyclerview.setAdapter(new SelectInstructorItemAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.SelectInstructorsCustom$setRecycleView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    RecyclerView.Adapter adapter = this.this$0.getBinding().recyclerview.getAdapter();
                    if (adapter instanceof SelectInstructorItemAdapter) {
                        SelectInstructorItemAdapter selectInstructorItemAdapter = (SelectInstructorItemAdapter) adapter;
                        List<ClassInstructorsDataBase> currentList = selectInstructorItemAdapter.getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        currentList.get(pos).setSelect(!r1.isSelect());
                        selectInstructorItemAdapter.notifyItemChanged(pos);
                        this.this$0.setChangeView();
                    }
                }
            }));
        }
        ArrayList arrayList = new ArrayList();
        for (CollectionInstructorsData collectionInstructorsDataCopy$default : this.instructorsList) {
            if (collectionInstructorsDataCopy$default instanceof SessionInstructorsData) {
                collectionInstructorsDataCopy$default = SessionInstructorsData.copy$default((SessionInstructorsData) collectionInstructorsDataCopy$default, null, false, 3, null);
            } else if (collectionInstructorsDataCopy$default instanceof CollectionInstructorsData) {
                collectionInstructorsDataCopy$default = CollectionInstructorsData.copy$default((CollectionInstructorsData) collectionInstructorsDataCopy$default, null, false, 3, null);
            }
            arrayList.add(collectionInstructorsDataCopy$default);
        }
        RecyclerView.Adapter adapter = this.binding.recyclerview.getAdapter();
        if (adapter instanceof SelectInstructorItemAdapter) {
            ((SelectInstructorItemAdapter) adapter).submitList(arrayList);
            setChangeView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setChangeView() {
        RecyclerView.Adapter adapter = this.binding.recyclerview.getAdapter();
        if (adapter instanceof SelectInstructorItemAdapter) {
            List<ClassInstructorsDataBase> currentList = ((SelectInstructorItemAdapter) adapter).getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            Iterator<ClassInstructorsDataBase> it = currentList.iterator();
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
        RecyclerView.Adapter adapter = this.binding.recyclerview.getAdapter();
        ArrayList arrayList = new ArrayList();
        if (adapter instanceof SelectInstructorItemAdapter) {
            List<ClassInstructorsDataBase> currentList = ((SelectInstructorItemAdapter) adapter).getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            for (ClassInstructorsDataBase classInstructorsDataBase : currentList) {
                Intrinsics.checkNotNull(classInstructorsDataBase);
                arrayList.add(classInstructorsDataBase);
            }
        }
        this.listener.onClick(arrayList);
        if (this.isReset) {
            this.listener.onReset();
        }
        getMainActivity().onBackPressed();
    }

    public final void setStatusBarHeight(View statusBarView) {
        Intrinsics.checkNotNullParameter(statusBarView, "statusBarView");
        MainActivity mainActivity = getMainActivity();
        if (mainActivity == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = statusBarView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "getLayoutParams(...)");
        Context applicationContext = mainActivity.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.soletreadmills.sole_v2.MyApplication");
        Integer statusBarHeight = ((MyApplication) applicationContext).getStatusBarHeight();
        int iIntValue = statusBarHeight != null ? statusBarHeight.intValue() : 0;
        int statusBarHeight2 = UiTool.getStatusBarHeight(mainActivity);
        if (statusBarHeight2 > iIntValue) {
            iIntValue = statusBarHeight2;
        }
        layoutParams.height = iIntValue;
        statusBarView.requestLayout();
    }
}
