package com.soletreadmills.sole_v2.ui.adapter.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.android.ddmlib.internal.commands.DisconnectCommand;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._type.MachineType;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import com.soletreadmills.sole_v2.databinding.AdapterHomeConnectItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.home.HomeConnectAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: HomeConnectAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/home/HomeConnectAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "Lcom/soletreadmills/sole_v2/ui/adapter/home/HomeConnectAdapter$ViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeConnectAdapter extends ListAdapter<BleDeviceInfoData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener listener;

    public static final /* synthetic */ BleDeviceInfoData access$getItem(HomeConnectAdapter homeConnectAdapter, int i) {
        return homeConnectAdapter.getItem(i);
    }

    public final OnItemClickListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeConnectAdapter(OnItemClickListener listener) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterHomeConnectItemBinding adapterHomeConnectItemBindingInflate = AdapterHomeConnectItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterHomeConnectItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterHomeConnectItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(position);
    }

    /* compiled from: HomeConnectAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/home/HomeConnectAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterHomeConnectItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/home/HomeConnectAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterHomeConnectItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterHomeConnectItemBinding;", "bind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterHomeConnectItemBinding binding;
        final /* synthetic */ HomeConnectAdapter this$0;

        /* compiled from: HomeConnectAdapter.kt */
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
        public ViewHolder(HomeConnectAdapter homeConnectAdapter, AdapterHomeConnectItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = homeConnectAdapter;
            this.binding = binding;
        }

        public final AdapterHomeConnectItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(int position) {
            BleDeviceInfoData bleDeviceInfoDataAccess$getItem = HomeConnectAdapter.access$getItem(this.this$0, position);
            if (bleDeviceInfoDataAccess$getItem == null) {
                return;
            }
            FtmsDeviceManager ftmsDeviceManager = BleManager.getInstance().getFtmsDeviceManager();
            boolean zIsFitnessMachineControlPoint = ftmsDeviceManager != null ? ftmsDeviceManager.isFitnessMachineControlPoint() : false;
            FtmsDeviceManager ftmsDeviceManager2 = BleManager.getInstance().getFtmsDeviceManager();
            boolean supportProgram = ftmsDeviceManager2 != null ? ftmsDeviceManager2.getSupportProgram() : false;
            TrainingStatusType nowTrainingStatusType = BleDataManager.getInstance().getNowTrainingStatusType();
            Timber.INSTANCE.e("isSupportProgram :%s", Boolean.valueOf(supportProgram));
            this.binding.llConnectingBoard.setVisibility(8);
            if (bleDeviceInfoDataAccess$getItem.getConnectionState() == 2) {
                this.binding.imgCircle.setVisibility(0);
                this.binding.imgCircle.setImageResource(R.drawable.green_circle);
                this.binding.card.setCardBackgroundColor(this.binding.getRoot().getContext().getColor(R.color.colorPalette_green_overly25));
                this.binding.cardImg.setCardBackgroundColor(this.binding.getRoot().getContext().getColor(R.color.colorPalette_green_overly25));
                this.binding.tvStatus.setText(this.binding.getRoot().getContext().getString(R.string.connected));
                this.binding.tvStatus.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorPalette_green));
                this.binding.llConnectingBoard.setVisibility(0);
                this.binding.llDisplayStats.setVisibility(0);
                this.binding.llQuickStart.setVisibility(8);
                if (zIsFitnessMachineControlPoint) {
                    if (supportProgram && nowTrainingStatusType == TrainingStatusType.IDLE) {
                        this.binding.llBrowsePrograms.setVisibility(0);
                    } else {
                        this.binding.llBrowsePrograms.setVisibility(8);
                    }
                    if (nowTrainingStatusType == TrainingStatusType.IDLE) {
                        this.binding.llQuickStart.setVisibility(0);
                        this.binding.llDisplayStats.setVisibility(8);
                    }
                } else {
                    this.binding.llBrowsePrograms.setVisibility(8);
                }
            } else if (bleDeviceInfoDataAccess$getItem.getIsUserSync()) {
                this.binding.imgCircle.setVisibility(0);
                this.binding.imgCircle.setImageResource(R.drawable.cian_circle);
                this.binding.card.setCardBackgroundColor(this.binding.getRoot().getContext().getColor(R.color.colorPalette_cian_overly25));
                this.binding.cardImg.setCardBackgroundColor(this.binding.getRoot().getContext().getColor(R.color.colorPalette_cian_overly25));
                this.binding.tvStatus.setText(this.binding.getRoot().getContext().getString(R.string.auto_sync));
                this.binding.tvStatus.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorPalette_cian));
            } else {
                this.binding.imgCircle.setVisibility(8);
                this.binding.card.setCardBackgroundColor(this.binding.getRoot().getContext().getColor(R.color.colorBackground_raised));
                this.binding.cardImg.setCardBackgroundColor(this.binding.getRoot().getContext().getColor(R.color.colorBackground_raised));
                this.binding.tvStatus.setText("");
                this.binding.tvStatus.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_label3));
            }
            String string = this.binding.getRoot().getContext().getString(R.string.my_sole_devices);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            MachineType machineType = bleDeviceInfoDataAccess$getItem.getMachineType();
            int i = machineType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[machineType.ordinal()];
            if (i == 1) {
                string = this.binding.getRoot().getContext().getString(R.string.my_treadmill);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.binding.img.setImageResource(R.drawable.ic_machine_treadmill);
            } else if (i == 2) {
                string = this.binding.getRoot().getContext().getString(R.string.my_elliptical);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.binding.img.setImageResource(R.drawable.ic_machine_elliptical);
            } else if (i == 3) {
                string = this.binding.getRoot().getContext().getString(R.string.my_bike);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.binding.img.setImageResource(R.drawable.ic_machine_bike);
            } else if (i == 4) {
                string = this.binding.getRoot().getContext().getString(R.string.my_rower);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.binding.img.setImageResource(R.drawable.ic_machine_rower);
            } else if (i == 5) {
                string = this.binding.getRoot().getContext().getString(R.string.my_stepper);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.binding.img.setImageResource(R.drawable.ic_machine_stepper);
            }
            this.binding.tvTitle.setText(string);
            this.binding.tvName.setText("SOLE " + bleDeviceInfoDataAccess$getItem.getName());
            if (Intrinsics.areEqual(bleDeviceInfoDataAccess$getItem.getName(), "add")) {
                this.binding.layoutConnect.setVisibility(8);
                this.binding.layoutAdd.setVisibility(0);
            }
            LinearLayout linearLayout = this.binding.layoutAdd;
            final HomeConnectAdapter homeConnectAdapter = this.this$0;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.home.HomeConnectAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeConnectAdapter.ViewHolder.bind$lambda$0(homeConnectAdapter, this, view);
                }
            });
            LinearLayout linearLayout2 = this.binding.layoutConnect;
            final HomeConnectAdapter homeConnectAdapter2 = this.this$0;
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.home.HomeConnectAdapter$ViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeConnectAdapter.ViewHolder.bind$lambda$1(homeConnectAdapter2, this, view);
                }
            });
            LinearLayout linearLayout3 = this.binding.llDisplayStats;
            final HomeConnectAdapter homeConnectAdapter3 = this.this$0;
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.home.HomeConnectAdapter$ViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeConnectAdapter.ViewHolder.bind$lambda$2(homeConnectAdapter3, this, view);
                }
            });
            LinearLayout linearLayout4 = this.binding.llBrowsePrograms;
            final HomeConnectAdapter homeConnectAdapter4 = this.this$0;
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.home.HomeConnectAdapter$ViewHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeConnectAdapter.ViewHolder.bind$lambda$3(homeConnectAdapter4, this, view);
                }
            });
            LinearLayout linearLayout5 = this.binding.llDisconnect;
            final HomeConnectAdapter homeConnectAdapter5 = this.this$0;
            linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.home.HomeConnectAdapter$ViewHolder$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeConnectAdapter.ViewHolder.bind$lambda$4(homeConnectAdapter5, this, view);
                }
            });
            LinearLayout linearLayout6 = this.binding.llQuickStart;
            final HomeConnectAdapter homeConnectAdapter6 = this.this$0;
            linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.home.HomeConnectAdapter$ViewHolder$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeConnectAdapter.ViewHolder.bind$lambda$5(homeConnectAdapter6, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(HomeConnectAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition(), "add");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(HomeConnectAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(HomeConnectAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition(), "display_stats");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$3(HomeConnectAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition(), "browse_program");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$4(HomeConnectAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition(), DisconnectCommand.COMMAND);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$5(HomeConnectAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition(), "quick_start");
        }
    }

    /* compiled from: HomeConnectAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/home/HomeConnectAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
