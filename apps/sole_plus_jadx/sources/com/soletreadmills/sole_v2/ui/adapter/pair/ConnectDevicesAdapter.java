package com.soletreadmills.sole_v2.ui.adapter.pair;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._type.MachineType;
import com.soletreadmills.sole_v2.databinding.AdapterConnectDeviceItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.pair.ConnectDevicesAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectDevicesAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/pair/ConnectDevicesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "Lcom/soletreadmills/sole_v2/ui/adapter/pair/ConnectDevicesAdapter$ViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectDevicesAdapter extends ListAdapter<BleDeviceInfoData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener listener;

    public static final /* synthetic */ BleDeviceInfoData access$getItem(ConnectDevicesAdapter connectDevicesAdapter, int i) {
        return connectDevicesAdapter.getItem(i);
    }

    public final OnItemClickListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectDevicesAdapter(OnItemClickListener listener) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterConnectDeviceItemBinding adapterConnectDeviceItemBindingInflate = AdapterConnectDeviceItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterConnectDeviceItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterConnectDeviceItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(position);
    }

    /* compiled from: ConnectDevicesAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/pair/ConnectDevicesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterConnectDeviceItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/pair/ConnectDevicesAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterConnectDeviceItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterConnectDeviceItemBinding;", "bind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterConnectDeviceItemBinding binding;
        final /* synthetic */ ConnectDevicesAdapter this$0;

        /* compiled from: ConnectDevicesAdapter.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MachineType.values().length];
                try {
                    iArr[MachineType.TREADMILL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MachineType.ELLIPTICAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MachineType.BIKE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[MachineType.ROWER.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[MachineType.STEPPER.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ConnectDevicesAdapter connectDevicesAdapter, AdapterConnectDeviceItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = connectDevicesAdapter;
            this.binding = binding;
        }

        public final AdapterConnectDeviceItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(int position) {
            BleDeviceInfoData bleDeviceInfoDataAccess$getItem = ConnectDevicesAdapter.access$getItem(this.this$0, position);
            if (bleDeviceInfoDataAccess$getItem == null) {
                return;
            }
            Drawable drawable = this.binding.getRoot().getContext().getDrawable(R.drawable.ic_machine_treadmill);
            MachineType machineType = bleDeviceInfoDataAccess$getItem.getMachineType();
            int i = machineType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[machineType.ordinal()];
            if (i == 1) {
                drawable = this.binding.getRoot().getContext().getDrawable(R.drawable.ic_machine_treadmill);
            } else if (i == 2) {
                drawable = this.binding.getRoot().getContext().getDrawable(R.drawable.ic_machine_elliptical);
            } else if (i == 3) {
                drawable = this.binding.getRoot().getContext().getDrawable(R.drawable.ic_machine_bike);
            } else if (i == 4) {
                drawable = this.binding.getRoot().getContext().getDrawable(R.drawable.ic_machine_rower);
            } else if (i == 5) {
                drawable = this.binding.getRoot().getContext().getDrawable(R.drawable.ic_machine_stepper);
            }
            if (bleDeviceInfoDataAccess$getItem.getConnectionState() == 2) {
                this.binding.cardImg.setCardBackgroundColor(this.binding.getRoot().getContext().getColor(R.color.colorLabel_accent_overlay30));
                this.binding.LLStatus.setVisibility(0);
                this.binding.tvStatus.setText(this.binding.getRoot().getContext().getString(R.string.connected));
            } else {
                this.binding.cardImg.setCardBackgroundColor(this.binding.getRoot().getContext().getColor(R.color.colorBackground_raised));
                this.binding.LLStatus.setVisibility(8);
            }
            this.binding.tvTitle.setText(bleDeviceInfoDataAccess$getItem.getName());
            this.binding.imgDevice.setImageDrawable(drawable);
            CardView cardView = this.binding.card;
            final ConnectDevicesAdapter connectDevicesAdapter = this.this$0;
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.pair.ConnectDevicesAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConnectDevicesAdapter.ViewHolder.bind$lambda$0(connectDevicesAdapter, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(ConnectDevicesAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition());
        }
    }

    /* compiled from: ConnectDevicesAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/pair/ConnectDevicesAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<BleDeviceInfoData> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(BleDeviceInfoData oldItem, BleDeviceInfoData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getAddress(), newItem.getAddress());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(BleDeviceInfoData oldItem, BleDeviceInfoData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
