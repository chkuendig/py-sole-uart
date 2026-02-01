package com.soletreadmills.sole_v2.ui.adapter.displayMode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.ImageViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.DisplaySelectStatsData;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.databinding.AdapterDisplayDashboardItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.displayMode.DisplayModeItemAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayModeItemAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u001dB5\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0002\u0010\fJ\u001c\u0010\u0010\u001a\u00020\u000b2\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u001c\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0016\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/displayMode/DisplayModeItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", "Lcom/soletreadmills/sole_v2/ui/adapter/displayMode/DisplayModeItemAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "onItemClick", "Lkotlin/Function2;", "", "", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;Lkotlin/jvm/functions/Function2;)V", "valueMap", "", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateItemValue", "type", "value", "updateVisibility", "show", "", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayModeItemAdapter extends ListAdapter<DisplaySelectStatsData, ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private final BleFtmsMachineType machineType;
    private final Function2<DisplaySelectStatsData, Integer, Unit> onItemClick;
    private final Map<DisplaySelectStatsData, String> valueMap;

    public /* synthetic */ DisplayModeItemAdapter(Context context, BleFtmsMachineType bleFtmsMachineType, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, bleFtmsMachineType, (i & 4) != 0 ? null : function2);
    }

    public static final /* synthetic */ DisplaySelectStatsData access$getItem(DisplayModeItemAdapter displayModeItemAdapter, int i) {
        return displayModeItemAdapter.getItem(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DisplayModeItemAdapter(Context context, BleFtmsMachineType machineType, Function2<? super DisplaySelectStatsData, ? super Integer, Unit> function2) {
        super(new DiffUtil.ItemCallback<DisplaySelectStatsData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.displayMode.DisplayModeItemAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(DisplaySelectStatsData oldItem, DisplaySelectStatsData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(DisplaySelectStatsData oldItem, DisplaySelectStatsData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        Intrinsics.checkNotNullParameter(machineType, "machineType");
        this.context = context;
        this.machineType = machineType;
        this.onItemClick = function2;
        this.valueMap = new LinkedHashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_display_dashboard_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        return new ViewHolder(this, (AdapterDisplayDashboardItemBinding) viewDataBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        DisplaySelectStatsData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.setBind(item, position);
    }

    public final void updateVisibility(boolean show) {
        notifyDataSetChanged();
    }

    public final void updateItemValue(DisplaySelectStatsData type, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        this.valueMap.put(type, value);
        int iIndexOf = getCurrentList().indexOf(type);
        if (iIndexOf != -1) {
            notifyItemChanged(iIndexOf);
        }
    }

    /* compiled from: DisplayModeItemAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/displayMode/DisplayModeItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterDisplayDashboardItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/displayMode/DisplayModeItemAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterDisplayDashboardItemBinding;)V", "getDefaultValue", "", "type", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "getIconResource", "", "getStatsColor", "getUnitText", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setBind", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", "position", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterDisplayDashboardItemBinding binding;
        final /* synthetic */ DisplayModeItemAdapter this$0;

        /* compiled from: DisplayModeItemAdapter.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DisplayStatsType.values().length];
                try {
                    iArr[DisplayStatsType.SPEED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DisplayStatsType.INCLINE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DisplayStatsType.TIME.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DisplayStatsType.REMAINING_TIME.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[DisplayStatsType.DISTANCE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[DisplayStatsType.HEART_RATE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[DisplayStatsType.CALORIES.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[DisplayStatsType.ASCENT.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[DisplayStatsType.METS.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[DisplayStatsType.PACE.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[DisplayStatsType.OUTPUT.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[DisplayStatsType.AVG_PACE.ordinal()] = 12;
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
                    iArr[DisplayStatsType.AVG_CADENCE.ordinal()] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr[DisplayStatsType.AVG_SPEED.ordinal()] = 17;
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
        public ViewHolder(final DisplayModeItemAdapter displayModeItemAdapter, AdapterDisplayDashboardItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = displayModeItemAdapter;
            this.binding = binding;
            binding.getRoot().setClickable(true);
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.displayMode.DisplayModeItemAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DisplayModeItemAdapter.ViewHolder._init_$lambda$0(this.f$0, displayModeItemAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(ViewHolder this$0, DisplayModeItemAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition != -1) {
                DisplaySelectStatsData displaySelectStatsDataAccess$getItem = DisplayModeItemAdapter.access$getItem(this$1, bindingAdapterPosition);
                Function2 function2 = this$1.onItemClick;
                if (function2 != null) {
                    Intrinsics.checkNotNull(displaySelectStatsDataAccess$getItem);
                    function2.invoke(displaySelectStatsDataAccess$getItem, Integer.valueOf(bindingAdapterPosition));
                }
            }
        }

        public final void setBind(DisplaySelectStatsData item, int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            String defaultValue = (String) this.this$0.valueMap.get(item);
            if (defaultValue == null) {
                defaultValue = getDefaultValue(item.getType());
            }
            this.binding.valueText.setText(defaultValue);
            this.binding.img.setImageResource(getIconResource(item.getType()));
            Context context = this.this$0.context;
            if (context != null) {
                ImageViewCompat.setImageTintList(this.binding.img, AppCompatResources.getColorStateList(context, getStatsColor(item.getType())));
            }
            this.binding.unitText.setText(getUnitText(item.getType(), this.this$0.machineType));
        }

        private final String getDefaultValue(DisplayStatsType type) {
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                case 17:
                    return "0.00";
                case 2:
                case 6:
                case 7:
                case 8:
                case 11:
                case 13:
                case 14:
                case 15:
                case 16:
                case 18:
                case 19:
                case 20:
                case 21:
                default:
                    return "0";
                case 3:
                case 4:
                case 10:
                case 12:
                    return "00:00";
                case 5:
                case 9:
                    return "0.0";
            }
        }

        private final int getStatsColor(DisplayStatsType type) {
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    return R.color.colorStats_speed;
                case 2:
                    return R.color.colorStats_incline;
                case 3:
                    return R.color.colorStats_time;
                case 4:
                    return R.color.colorStats_time;
                case 5:
                    return R.color.colorStats_distance;
                case 6:
                    return R.color.colorStats_hr;
                case 7:
                    return R.color.colorStats_calories;
                case 8:
                    return R.color.colorStats_ascent;
                case 9:
                    return R.color.colorStats_mets;
                case 10:
                    return R.color.colorStats_pace;
                case 11:
                    return R.color.colorStats_output;
                case 12:
                    return R.color.colorStats_pace;
                case 13:
                    return R.color.colorStats_resistance;
                case 14:
                    return R.color.colorStats_cadence;
                case 15:
                    return R.color.colorStats_count;
                case 16:
                    return R.color.colorStats_cadence;
                case 17:
                    return R.color.colorStats_speed;
                case 18:
                    return R.color.colorStats_count;
                case 19:
                    return R.color.colorStats_floors;
                case 20:
                    return R.color.colorStats_count;
                case 21:
                    return R.color.colorStats_calories;
                default:
                    return R.color.colorStats_time;
            }
        }

        private final int getIconResource(DisplayStatsType type) {
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            }
            return R.drawable.ic_stats_speed;
        }

        private final String getUnitText(DisplayStatsType type, BleFtmsMachineType machineType) {
            String string;
            String string2;
            String string3;
            Context context = this.this$0.context;
            if (context == null) {
                return "";
            }
            boolean unitType = Global.INSTANCE.getUnitType();
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                case 17:
                    String string4 = context.getString(unitType ? R.string.mph : R.string.km_h);
                    Intrinsics.checkNotNull(string4);
                    return string4;
                case 2:
                    String string5 = context.getString(R.string.incline);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    return string5;
                case 3:
                    String string6 = context.getString(R.string.elapsed);
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    return string6;
                case 4:
                    String string7 = context.getString(R.string.remaining);
                    Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                    return string7;
                case 5:
                    if (machineType == BleFtmsMachineType.ROWER) {
                        string = context.getString(R.string.m);
                    } else {
                        string = context.getString(unitType ? R.string.mi : R.string.km);
                    }
                    Intrinsics.checkNotNull(string);
                    return string;
                case 6:
                    String string8 = context.getString(R.string.bpm);
                    Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                    return string8;
                case 7:
                    String string9 = context.getString(R.string.kcal);
                    Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                    return string9;
                case 8:
                    String string10 = context.getString(unitType ? R.string.ft_ascent : R.string.m_ascent);
                    Intrinsics.checkNotNull(string10);
                    return string10;
                case 9:
                    String string11 = context.getString(R.string.mets);
                    Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                    return string11;
                case 10:
                    if (machineType == BleFtmsMachineType.ROWER) {
                        string2 = context.getString(R.string.min_500m);
                    } else {
                        string2 = context.getString(unitType ? R.string.min_mi : R.string.min_km);
                    }
                    Intrinsics.checkNotNull(string2);
                    return string2;
                case 11:
                    String string12 = context.getString(R.string.watts);
                    Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                    return string12;
                case 12:
                    if (machineType == BleFtmsMachineType.ROWER) {
                        string3 = context.getString(R.string.min_500m);
                    } else {
                        string3 = context.getString(unitType ? R.string.avg_min_mi : R.string.avg_min_km);
                    }
                    Intrinsics.checkNotNull(string3);
                    return string3;
                case 13:
                    String string13 = context.getString(R.string.resistance);
                    Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                    return string13;
                case 14:
                case 16:
                    String string14 = context.getString(R.string.spm);
                    Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                    return string14;
                case 15:
                    String string15 = context.getString(R.string.strides);
                    Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                    return string15;
                case 18:
                    String string16 = context.getString(R.string.strokes);
                    Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
                    return string16;
                case 19:
                    String string17 = context.getString(R.string.floors);
                    Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
                    return string17;
                case 20:
                    String string18 = context.getString(R.string.steps);
                    Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
                    return string18;
                case 21:
                    String string19 = context.getString(R.string.kcal_min);
                    Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
                    return string19;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }
}
