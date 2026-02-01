package com.soletreadmills.sole_v2.ui.pair;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.ble.SelectProgramSeekbarData;
import com.soletreadmills.sole_v2._type.ConnectProgramNameType;
import com.soletreadmills.sole_v2.adapter.selectProgram.SelectProgramSeekbarAdapter;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.databinding.FragmentConnectEditProgramBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.widget.MultiLayerBarChartView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: ConnectEditProgramFragment.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020#J\u0006\u0010)\u001a\u00020#J\u0006\u0010*\u001a\u00020#R\u001b\u0010\u0005\u001a\u00020\u00068@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/ConnectEditProgramFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentConnectEditProgramBinding;", "Landroid/view/View$OnClickListener;", "()V", "connectProgramViewModel", "Lcom/soletreadmills/sole_v2/ui/pair/ConnectProgramViewModel;", "getConnectProgramViewModel$app_release", "()Lcom/soletreadmills/sole_v2/ui/pair/ConnectProgramViewModel;", "connectProgramViewModel$delegate", "Lkotlin/Lazy;", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "getMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setMachineType", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)V", "selectPosition", "", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "type", "Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;", "getType", "()Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;", "setType", "(Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;)V", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setBarChat", "setInclineRecyclerView", "setSelectView", "setSpeedOrLevelRecyclerView", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectEditProgramFragment extends BaseFragment<FragmentConnectEditProgramBinding> implements View.OnClickListener {
    public static final int $stable = 8;

    /* renamed from: connectProgramViewModel$delegate, reason: from kotlin metadata */
    private final Lazy connectProgramViewModel;
    private BleFtmsMachineType machineType;
    private int selectPosition;
    private ConnectProgramNameType type;

    /* compiled from: ConnectEditProgramFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BleFtmsMachineType.values().length];
            try {
                iArr[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleFtmsMachineType.BIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BleFtmsMachineType.STEPPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BleFtmsMachineType.ROWER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ConnectEditProgramFragment() {
        final ConnectEditProgramFragment connectEditProgramFragment = this;
        final Function0 function0 = null;
        this.connectProgramViewModel = FragmentViewModelLazyKt.createViewModelLazy(connectEditProgramFragment, Reflection.getOrCreateKotlinClass(ConnectProgramViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectEditProgramFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = connectEditProgramFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectEditProgramFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = connectEditProgramFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectEditProgramFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = connectEditProgramFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public final int getSelectPosition() {
        return this.selectPosition;
    }

    public final void setSelectPosition(int i) {
        this.selectPosition = i;
    }

    public final ConnectProgramViewModel getConnectProgramViewModel$app_release() {
        return (ConnectProgramViewModel) this.connectProgramViewModel.getValue();
    }

    public final BleFtmsMachineType getMachineType() {
        return this.machineType;
    }

    public final void setMachineType(BleFtmsMachineType bleFtmsMachineType) {
        this.machineType = bleFtmsMachineType;
    }

    public final ConnectProgramNameType getType() {
        return this.type;
    }

    public final void setType(ConnectProgramNameType connectProgramNameType) {
        this.type = connectProgramNameType;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentConnectEditProgramBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentConnectEditProgramBinding fragmentConnectEditProgramBindingInflate = FragmentConnectEditProgramBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentConnectEditProgramBindingInflate, "inflate(...)");
        return fragmentConnectEditProgramBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        FragmentConnectEditProgramBinding binding = getBinding();
        if (binding != null && (relativeLayout2 = binding.cancel) != null) {
            relativeLayout2.setOnClickListener(this);
        }
        FragmentConnectEditProgramBinding binding2 = getBinding();
        if (binding2 != null && (relativeLayout = binding2.save) != null) {
            relativeLayout.setOnClickListener(this);
        }
        FragmentConnectEditProgramBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout3 = binding3.LLIncline) != null) {
            linearLayout3.setOnClickListener(this);
        }
        FragmentConnectEditProgramBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout2 = binding4.LLSpeedOrLevel) != null) {
            linearLayout2.setOnClickListener(this);
        }
        this.type = getConnectProgramViewModel$app_release().getType();
        BleFtmsMachineType machineType = getConnectProgramViewModel$app_release().getMachineType();
        this.machineType = machineType;
        int i = machineType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[machineType.ordinal()];
        if (i == 1) {
            FragmentConnectEditProgramBinding binding5 = getBinding();
            linearLayout = binding5 != null ? binding5.LLIncline : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (i == 2) {
            FragmentConnectEditProgramBinding binding6 = getBinding();
            linearLayout = binding6 != null ? binding6.LLIncline : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else if (i == 3) {
            FragmentConnectEditProgramBinding binding7 = getBinding();
            linearLayout = binding7 != null ? binding7.LLIncline : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (i == 4) {
            FragmentConnectEditProgramBinding binding8 = getBinding();
            linearLayout = binding8 != null ? binding8.LLIncline : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else if (i == 5) {
            FragmentConnectEditProgramBinding binding9 = getBinding();
            linearLayout = binding9 != null ? binding9.LLIncline : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
        setSelectView();
        setSpeedOrLevelRecyclerView();
        setInclineRecyclerView();
        setBarChat();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView.Adapter adapter = null;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.cancel;
        if (numValueOf != null && numValueOf.intValue() == i) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        int i2 = R.id.save;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            FragmentConnectEditProgramBinding binding = getBinding();
            RecyclerView.Adapter adapter2 = (binding == null || (recyclerView2 = binding.recyclerView) == null) ? null : recyclerView2.getAdapter();
            FragmentConnectEditProgramBinding binding2 = getBinding();
            if (binding2 != null && (recyclerView = binding2.recyclerViewIncline) != null) {
                adapter = recyclerView.getAdapter();
            }
            if (adapter2 instanceof SelectProgramSeekbarAdapter) {
                List<SelectProgramSeekbarData> currentList = ((SelectProgramSeekbarAdapter) adapter2).getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                Iterator<SelectProgramSeekbarData> it = currentList.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(it.next().getValue()));
                }
            }
            if (adapter instanceof SelectProgramSeekbarAdapter) {
                List<SelectProgramSeekbarData> currentList2 = ((SelectProgramSeekbarAdapter) adapter).getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList2, "getCurrentList(...)");
                Iterator<SelectProgramSeekbarData> it2 = currentList2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Integer.valueOf(it2.next().getValue()));
                }
            }
            getConnectProgramViewModel$app_release().setSpeedOrLevelListGlobal(arrayList);
            getConnectProgramViewModel$app_release().setInclineProFileListGlobal(arrayList2);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.onBackPressed();
                return;
            }
            return;
        }
        int i3 = R.id.LL_incline;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            this.selectPosition = 1;
            setSelectView();
            setBarChat();
            return;
        }
        int i4 = R.id.LL_speedOrLevel;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            this.selectPosition = 0;
            setSelectView();
            setBarChat();
        }
    }

    public final void setSpeedOrLevelRecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        FragmentConnectEditProgramBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView3 = binding.recyclerView) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentConnectEditProgramBinding binding2 = getBinding();
            RecyclerView recyclerView4 = binding2 != null ? binding2.recyclerView : null;
            if (recyclerView4 != null) {
                recyclerView4.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        }
        FragmentConnectEditProgramBinding binding3 = getBinding();
        if (!(((binding3 == null || (recyclerView2 = binding3.recyclerView) == null) ? null : recyclerView2.getAdapter()) instanceof SelectProgramSeekbarAdapter)) {
            SelectProgramSeekbarAdapter selectProgramSeekbarAdapter = new SelectProgramSeekbarAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectEditProgramFragment$setSpeedOrLevelRecyclerView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    this.this$0.setBarChat();
                }
            });
            FragmentConnectEditProgramBinding binding4 = getBinding();
            RecyclerView recyclerView5 = binding4 != null ? binding4.recyclerView : null;
            if (recyclerView5 != null) {
                recyclerView5.setAdapter(selectProgramSeekbarAdapter);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<Integer> speedOrLevelListGlobal = getConnectProgramViewModel$app_release().getSpeedOrLevelListGlobal();
        BleFtmsMachineType bleFtmsMachineType = this.machineType;
        int i = (bleFtmsMachineType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[bleFtmsMachineType.ordinal()]) == 1 ? 0 : 2;
        if (speedOrLevelListGlobal.size() > 0) {
            int size = speedOrLevelListGlobal.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new SelectProgramSeekbarData(speedOrLevelListGlobal.get(i2).intValue(), i));
            }
        } else {
            for (int i3 = 1; i3 < 21; i3++) {
                arrayList.add(new SelectProgramSeekbarData(5, i));
            }
        }
        FragmentConnectEditProgramBinding binding5 = getBinding();
        if (binding5 != null && (recyclerView = binding5.recyclerView) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof SelectProgramSeekbarAdapter) {
            ((SelectProgramSeekbarAdapter) adapter).submitList(arrayList);
        }
    }

    public final void setInclineRecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        FragmentConnectEditProgramBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView3 = binding.recyclerViewIncline) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentConnectEditProgramBinding binding2 = getBinding();
            RecyclerView recyclerView4 = binding2 != null ? binding2.recyclerViewIncline : null;
            if (recyclerView4 != null) {
                recyclerView4.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        }
        FragmentConnectEditProgramBinding binding3 = getBinding();
        if (!(((binding3 == null || (recyclerView2 = binding3.recyclerViewIncline) == null) ? null : recyclerView2.getAdapter()) instanceof SelectProgramSeekbarAdapter)) {
            SelectProgramSeekbarAdapter selectProgramSeekbarAdapter = new SelectProgramSeekbarAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectEditProgramFragment$setInclineRecyclerView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    this.this$0.setBarChat();
                }
            });
            FragmentConnectEditProgramBinding binding4 = getBinding();
            RecyclerView recyclerView5 = binding4 != null ? binding4.recyclerViewIncline : null;
            if (recyclerView5 != null) {
                recyclerView5.setAdapter(selectProgramSeekbarAdapter);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<Integer> inclineProFileListGlobal = getConnectProgramViewModel$app_release().getInclineProFileListGlobal();
        if (inclineProFileListGlobal.size() > 0) {
            int size = inclineProFileListGlobal.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new SelectProgramSeekbarData(inclineProFileListGlobal.get(i).intValue(), 1));
            }
        } else {
            for (int i2 = 1; i2 < 21; i2++) {
                arrayList.add(new SelectProgramSeekbarData(1, 1));
            }
        }
        FragmentConnectEditProgramBinding binding5 = getBinding();
        if (binding5 != null && (recyclerView = binding5.recyclerViewIncline) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof SelectProgramSeekbarAdapter) {
            ((SelectProgramSeekbarAdapter) adapter).submitList(arrayList);
        }
    }

    public final void setSelectView() {
        RecyclerView recyclerView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Context context = getContext();
        if (context != null) {
            int i = this.selectPosition;
            if (i == 0) {
                FragmentConnectEditProgramBinding binding = getBinding();
                if (binding != null && (textView2 = binding.txtSpeedOrLevel) != null) {
                    textView2.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                }
                FragmentConnectEditProgramBinding binding2 = getBinding();
                View view = binding2 != null ? binding2.lineSpeedOrLevel : null;
                if (view != null) {
                    view.setVisibility(0);
                }
                FragmentConnectEditProgramBinding binding3 = getBinding();
                if (binding3 != null && (textView = binding3.txtIncline) != null) {
                    textView.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
                }
                FragmentConnectEditProgramBinding binding4 = getBinding();
                View view2 = binding4 != null ? binding4.lineIncline : null;
                if (view2 != null) {
                    view2.setVisibility(4);
                }
                FragmentConnectEditProgramBinding binding5 = getBinding();
                RecyclerView recyclerView2 = binding5 != null ? binding5.recyclerView : null;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(0);
                }
                FragmentConnectEditProgramBinding binding6 = getBinding();
                recyclerView = binding6 != null ? binding6.recyclerViewIncline : null;
                if (recyclerView == null) {
                    return;
                }
                recyclerView.setVisibility(8);
                return;
            }
            if (i != 1) {
                return;
            }
            FragmentConnectEditProgramBinding binding7 = getBinding();
            if (binding7 != null && (textView4 = binding7.txtSpeedOrLevel) != null) {
                textView4.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
            }
            FragmentConnectEditProgramBinding binding8 = getBinding();
            View view3 = binding8 != null ? binding8.lineSpeedOrLevel : null;
            if (view3 != null) {
                view3.setVisibility(4);
            }
            FragmentConnectEditProgramBinding binding9 = getBinding();
            if (binding9 != null && (textView3 = binding9.txtIncline) != null) {
                textView3.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
            }
            FragmentConnectEditProgramBinding binding10 = getBinding();
            View view4 = binding10 != null ? binding10.lineIncline : null;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            FragmentConnectEditProgramBinding binding11 = getBinding();
            RecyclerView recyclerView3 = binding11 != null ? binding11.recyclerView : null;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(8);
            }
            FragmentConnectEditProgramBinding binding12 = getBinding();
            recyclerView = binding12 != null ? binding12.recyclerViewIncline : null;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(0);
        }
    }

    public final void setBarChat() {
        MultiLayerBarChartView multiLayerBarChartView;
        MultiLayerBarChartView multiLayerBarChartView2;
        MultiLayerBarChartView multiLayerBarChartView3;
        MultiLayerBarChartView multiLayerBarChartView4;
        MultiLayerBarChartView multiLayerBarChartView5;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Context context = getContext();
        if (context != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            FragmentConnectEditProgramBinding binding = getBinding();
            Paint paintLayer3 = null;
            RecyclerView.Adapter adapter = (binding == null || (recyclerView2 = binding.recyclerView) == null) ? null : recyclerView2.getAdapter();
            FragmentConnectEditProgramBinding binding2 = getBinding();
            RecyclerView.Adapter adapter2 = (binding2 == null || (recyclerView = binding2.recyclerViewIncline) == null) ? null : recyclerView.getAdapter();
            if (adapter instanceof SelectProgramSeekbarAdapter) {
                List<SelectProgramSeekbarData> currentList = ((SelectProgramSeekbarAdapter) adapter).getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                Iterator<SelectProgramSeekbarData> it = currentList.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(it.next().getValue()));
                }
            }
            if (adapter2 instanceof SelectProgramSeekbarAdapter) {
                List<SelectProgramSeekbarData> currentList2 = ((SelectProgramSeekbarAdapter) adapter2).getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList2, "getCurrentList(...)");
                Iterator<SelectProgramSeekbarData> it2 = currentList2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Integer.valueOf(it2.next().getValue()));
                }
            }
            FragmentConnectEditProgramBinding binding3 = getBinding();
            MultiLayerBarChartView multiLayerBarChartView6 = binding3 != null ? binding3.barChart : null;
            if (multiLayerBarChartView6 != null) {
                multiLayerBarChartView6.setMaxValueLayer2(100);
            }
            FragmentConnectEditProgramBinding binding4 = getBinding();
            MultiLayerBarChartView multiLayerBarChartView7 = binding4 != null ? binding4.barChart : null;
            if (multiLayerBarChartView7 != null) {
                multiLayerBarChartView7.setMaxValueLayer3(15);
            }
            if (this.selectPosition == 0) {
                FragmentConnectEditProgramBinding binding5 = getBinding();
                Paint paintLayer2 = (binding5 == null || (multiLayerBarChartView5 = binding5.barChart) == null) ? null : multiLayerBarChartView5.getPaintLayer2();
                if (paintLayer2 != null) {
                    paintLayer2.setColor(ContextCompat.getColor(context, R.color.colorGlobal_accent));
                }
                FragmentConnectEditProgramBinding binding6 = getBinding();
                if (binding6 != null && (multiLayerBarChartView4 = binding6.barChart) != null) {
                    paintLayer3 = multiLayerBarChartView4.getPaintLayer3();
                }
                if (paintLayer3 != null) {
                    paintLayer3.setColor(0);
                }
            } else {
                FragmentConnectEditProgramBinding binding7 = getBinding();
                Paint paintLayer22 = (binding7 == null || (multiLayerBarChartView2 = binding7.barChart) == null) ? null : multiLayerBarChartView2.getPaintLayer2();
                if (paintLayer22 != null) {
                    paintLayer22.setColor(ContextCompat.getColor(context, R.color.colorLabel_accent_overlay30));
                }
                FragmentConnectEditProgramBinding binding8 = getBinding();
                if (binding8 != null && (multiLayerBarChartView = binding8.barChart) != null) {
                    paintLayer3 = multiLayerBarChartView.getPaintLayer3();
                }
                if (paintLayer3 != null) {
                    paintLayer3.setColor(ContextCompat.getColor(context, R.color.colorPalette_olive));
                }
            }
            FragmentConnectEditProgramBinding binding9 = getBinding();
            if (binding9 == null || (multiLayerBarChartView3 = binding9.barChart) == null) {
                return;
            }
            multiLayerBarChartView3.setData(arrayList, arrayList2);
        }
    }
}
