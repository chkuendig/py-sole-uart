package com.soletreadmills.sole_v2.ui.adapter.customview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.DisplaySelectStatsData;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import com.soletreadmills.sole_v2.databinding.AdapterDisplayStatsSelectItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.customview.DisplayStatsSelectAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayStatsSelectAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/customview/DisplayStatsSelectAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", "Lcom/soletreadmills/sole_v2/ui/adapter/customview/DisplayStatsSelectAdapter$ViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayStatsSelectAdapter extends ListAdapter<DisplaySelectStatsData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener listener;

    public static final /* synthetic */ DisplaySelectStatsData access$getItem(DisplayStatsSelectAdapter displayStatsSelectAdapter, int i) {
        return displayStatsSelectAdapter.getItem(i);
    }

    public final OnItemClickListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayStatsSelectAdapter(OnItemClickListener listener) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterDisplayStatsSelectItemBinding adapterDisplayStatsSelectItemBindingInflate = AdapterDisplayStatsSelectItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterDisplayStatsSelectItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterDisplayStatsSelectItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setBind(position);
    }

    /* compiled from: DisplayStatsSelectAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/customview/DisplayStatsSelectAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterDisplayStatsSelectItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/customview/DisplayStatsSelectAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterDisplayStatsSelectItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterDisplayStatsSelectItemBinding;", "setBind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterDisplayStatsSelectItemBinding binding;
        final /* synthetic */ DisplayStatsSelectAdapter this$0;

        /* compiled from: DisplayStatsSelectAdapter.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DisplayStatsType.values().length];
                try {
                    iArr[DisplayStatsType.TIME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DisplayStatsType.REMAINING_TIME.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DisplayStatsType.DISTANCE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DisplayStatsType.SPEED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[DisplayStatsType.PACE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[DisplayStatsType.AVG_PACE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[DisplayStatsType.HEART_RATE.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[DisplayStatsType.INCLINE.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[DisplayStatsType.CALORIES.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[DisplayStatsType.METS.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[DisplayStatsType.ASCENT.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[DisplayStatsType.OUTPUT.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[DisplayStatsType.RESISTANCE.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[DisplayStatsType.CADENCE.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[DisplayStatsType.STRIDES.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr[DisplayStatsType.AVG_SPEED.ordinal()] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr[DisplayStatsType.AVG_CADENCE.ordinal()] = 17;
                } catch (NoSuchFieldError unused17) {
                }
                try {
                    iArr[DisplayStatsType.STROKES.ordinal()] = 18;
                } catch (NoSuchFieldError unused18) {
                }
                try {
                    iArr[DisplayStatsType.FLOORS.ordinal()] = 19;
                } catch (NoSuchFieldError unused19) {
                }
                try {
                    iArr[DisplayStatsType.STEPS.ordinal()] = 20;
                } catch (NoSuchFieldError unused20) {
                }
                try {
                    iArr[DisplayStatsType.CALORIES_PER_MIN.ordinal()] = 21;
                } catch (NoSuchFieldError unused21) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(DisplayStatsSelectAdapter displayStatsSelectAdapter, AdapterDisplayStatsSelectItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = displayStatsSelectAdapter;
            this.binding = binding;
        }

        public final AdapterDisplayStatsSelectItemBinding getBinding() {
            return this.binding;
        }

        public final void setBind(int position) {
            final DisplaySelectStatsData displaySelectStatsDataAccess$getItem = DisplayStatsSelectAdapter.access$getItem(this.this$0, position);
            this.binding.imgSelect.setVisibility(4);
            if (displaySelectStatsDataAccess$getItem.isSelect()) {
                this.binding.imgSelect.setVisibility(0);
            }
            switch (WhenMappings.$EnumSwitchMapping$0[displaySelectStatsDataAccess$getItem.getType().ordinal()]) {
                case 1:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.time));
                    this.binding.img.setImageResource(R.drawable.ic_stats_timer_fill03);
                    break;
                case 2:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.remaining_time));
                    this.binding.img.setImageResource(R.drawable.ic_stats_timer_fill02);
                    break;
                case 3:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.distance));
                    this.binding.img.setImageResource(R.drawable.ic_stats_distance02);
                    break;
                case 4:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.speed));
                    this.binding.img.setImageResource(R.drawable.ic_stats_speed02);
                    break;
                case 5:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.pace));
                    this.binding.img.setImageResource(R.drawable.ic_activity_run02);
                    break;
                case 6:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.avg_pace));
                    this.binding.img.setImageResource(R.drawable.ic_activity_run02);
                    break;
                case 7:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.heart_rate));
                    this.binding.img.setImageResource(R.drawable.ic_stats_hr02);
                    break;
                case 8:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.incline));
                    this.binding.img.setImageResource(R.drawable.ic_stats_incline02);
                    break;
                case 9:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.calories));
                    this.binding.img.setImageResource(R.drawable.ic_stats_calories02);
                    break;
                case 10:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.mets));
                    this.binding.img.setImageResource(R.drawable.ic_stats_mets02);
                    break;
                case 11:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.ascent));
                    this.binding.img.setImageResource(R.drawable.ic_stats_ascent02);
                    break;
                case 12:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.output));
                    this.binding.img.setImageResource(R.drawable.ic_stats_power02);
                    break;
                case 13:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.resistance));
                    this.binding.img.setImageResource(R.drawable.ic_level_expert02);
                    break;
                case 14:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.cadence));
                    this.binding.img.setImageResource(R.drawable.ic_stats_cadence_rpm02);
                    break;
                case 15:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.strides));
                    this.binding.img.setImageResource(R.drawable.ic_stats_steps02);
                    break;
                case 16:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.avg_speed));
                    this.binding.img.setImageResource(R.drawable.ic_stats_speed02);
                    break;
                case 17:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.avg_cadence));
                    this.binding.img.setImageResource(R.drawable.ic_stats_cadence_rpm02);
                    break;
                case 18:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.strokes));
                    this.binding.img.setImageResource(R.drawable.ic_stats_strokes02);
                    break;
                case 19:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.floors));
                    this.binding.img.setImageResource(R.drawable.ic_stats_floors02);
                    break;
                case 20:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.steps));
                    this.binding.img.setImageResource(R.drawable.ic_stats_steps02);
                    break;
                case 21:
                    this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.calories_min));
                    this.binding.img.setImageResource(R.drawable.ic_stats_calories02);
                    break;
            }
            if (displaySelectStatsDataAccess$getItem.getNowSelect()) {
                this.binding.title.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_label3));
                this.binding.layout.setBackground(ContextCompat.getDrawable(this.binding.getRoot().getContext(), R.drawable.bg_corner28_outline));
            } else {
                this.binding.title.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_label1));
                this.binding.layout.setBackground(ContextCompat.getDrawable(this.binding.getRoot().getContext(), R.drawable.bg_corner28_raised));
            }
            View root = this.binding.getRoot();
            final DisplayStatsSelectAdapter displayStatsSelectAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.customview.DisplayStatsSelectAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DisplayStatsSelectAdapter.ViewHolder.setBind$lambda$0(displaySelectStatsDataAccess$getItem, displayStatsSelectAdapter, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(DisplaySelectStatsData displaySelectStatsData, DisplayStatsSelectAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (displaySelectStatsData.isSelect()) {
                return;
            }
            this$0.getListener().onClick(this$1.getBindingAdapterPosition());
        }
    }

    /* compiled from: DisplayStatsSelectAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/customview/DisplayStatsSelectAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<DisplaySelectStatsData> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(DisplaySelectStatsData oldItem, DisplaySelectStatsData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getType() == newItem.getType();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(DisplaySelectStatsData oldItem, DisplaySelectStatsData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
