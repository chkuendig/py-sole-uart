package com.soletreadmills.sole_v2.ui.adapter.pair;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.gson.Gson;
import com.soletreadmills.sole_v2._data.ble.ConnectProgramData;
import com.soletreadmills.sole_v2._tools.UiTool;
import com.soletreadmills.sole_v2._type.ConnectProgramNameType;
import com.soletreadmills.sole_v2._type.ConnectProgramType;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.databinding.AdapterConnectPageItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.pair.ConnectPageAdapter;
import com.soletreadmills.sole_v2.ui.widget.MultiLayerBarChartView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectPageAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/pair/ConnectPageAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/ble/ConnectProgramData;", "Lcom/soletreadmills/sole_v2/ui/adapter/pair/ConnectPageAdapter$ViewHolder;", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "itemClickListener", "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getItemClickListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "getMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectPageAdapter extends ListAdapter<ConnectProgramData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener itemClickListener;
    private final BleFtmsMachineType machineType;

    public static final /* synthetic */ ConnectProgramData access$getItem(ConnectPageAdapter connectPageAdapter, int i) {
        return connectPageAdapter.getItem(i);
    }

    public final BleFtmsMachineType getMachineType() {
        return this.machineType;
    }

    public final OnItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectPageAdapter(BleFtmsMachineType machineType, OnItemClickListener itemClickListener) {
        super(new DiffUtil.ItemCallback<ConnectProgramData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.pair.ConnectPageAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(ConnectProgramData oldItem, ConnectProgramData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.getType() == newItem.getType();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(ConnectProgramData oldItem, ConnectProgramData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(new Gson().toJson(oldItem), new Gson().toJson(newItem));
            }
        });
        Intrinsics.checkNotNullParameter(machineType, "machineType");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.machineType = machineType;
        this.itemClickListener = itemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterConnectPageItemBinding adapterConnectPageItemBindingInflate = AdapterConnectPageItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterConnectPageItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterConnectPageItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setBind(position);
    }

    /* compiled from: ConnectPageAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/pair/ConnectPageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterConnectPageItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/pair/ConnectPageAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterConnectPageItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterConnectPageItemBinding;", "setBarChart", "", "data", "Lcom/soletreadmills/sole_v2/_data/ble/ConnectProgramData;", "setBind", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterConnectPageItemBinding binding;
        final /* synthetic */ ConnectPageAdapter this$0;

        /* compiled from: ConnectPageAdapter.kt */
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ConnectPageAdapter connectPageAdapter, AdapterConnectPageItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = connectPageAdapter;
            this.binding = binding;
        }

        public final AdapterConnectPageItemBinding getBinding() {
            return this.binding;
        }

        public final void setBind(int position) {
            ConnectProgramData connectProgramDataAccess$getItem = ConnectPageAdapter.access$getItem(this.this$0, position);
            if (connectProgramDataAccess$getItem == null) {
                return;
            }
            Context context = this.binding.getRoot().getContext();
            TextView textView = this.binding.name;
            ConnectProgramNameType connectProgramNameType = connectProgramDataAccess$getItem.getConnectProgramNameType();
            Intrinsics.checkNotNull(context);
            textView.setText(connectProgramNameType.getTitle(context));
            this.binding.parts.setText(connectProgramDataAccess$getItem.getConnectProgramNameType().getDesc(context));
            ViewGroup.LayoutParams layoutParams = this.binding.img.getLayoutParams();
            if (connectProgramDataAccess$getItem.getType() == ConnectProgramType.Targets || connectProgramDataAccess$getItem.getConnectProgramNameType() == ConnectProgramNameType.Manual || connectProgramDataAccess$getItem.getConnectProgramNameType() == ConnectProgramNameType.Custom) {
                this.binding.img.setVisibility(0);
                this.binding.barChart.setVisibility(8);
                layoutParams.width = (int) UiTool.INSTANCE.convertDpToPixel(160.0f, context);
                layoutParams.height = (int) UiTool.INSTANCE.convertDpToPixel(160.0f, context);
            } else {
                this.binding.img.setVisibility(8);
                this.binding.barChart.setVisibility(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                setBarChart(connectProgramDataAccess$getItem);
            }
            this.binding.img.setLayoutParams(layoutParams);
            this.binding.img.setImageResource(connectProgramDataAccess$getItem.getIcon());
            View root = this.binding.getRoot();
            final ConnectPageAdapter connectPageAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.pair.ConnectPageAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConnectPageAdapter.ViewHolder.setBind$lambda$0(connectPageAdapter, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(ConnectPageAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getItemClickListener().onClick(this$1.getBindingAdapterPosition());
        }

        public final void setBarChart(ConnectProgramData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            List<Integer> speedList = data.getConnectProgramNameType().getSpeedList(this.this$0.getMachineType());
            List<Integer> resistList = data.getConnectProgramNameType().getResistList(this.this$0.getMachineType());
            List<Integer> inclineList = data.getConnectProgramNameType().getInclineList(this.this$0.getMachineType());
            int i = WhenMappings.$EnumSwitchMapping$0[this.this$0.getMachineType().ordinal()];
            if (i == 1) {
                this.binding.barChart.setMaxValueLayer2(100);
                this.binding.barChart.setMaxValueLayer3(15);
                this.binding.barChart.setData(speedList, inclineList);
                return;
            }
            if (i == 2) {
                this.binding.barChart.setMaxValueLayer2(20);
                MultiLayerBarChartView barChart = this.binding.barChart;
                Intrinsics.checkNotNullExpressionValue(barChart, "barChart");
                MultiLayerBarChartView.setData$default(barChart, resistList, null, 2, null);
                return;
            }
            if (i == 3) {
                this.binding.barChart.setMaxValueLayer2(20);
                this.binding.barChart.setMaxValueLayer3(15);
                this.binding.barChart.setData(resistList, inclineList);
            } else {
                if (i != 5) {
                    return;
                }
                this.binding.barChart.setMaxValueLayer2(20);
                MultiLayerBarChartView barChart2 = this.binding.barChart;
                Intrinsics.checkNotNullExpressionValue(barChart2, "barChart");
                MultiLayerBarChartView.setData$default(barChart2, resistList, null, 2, null);
            }
        }
    }
}
