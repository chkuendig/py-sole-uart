package com.soletreadmills.sole_v2.ui.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.classes.FitnessLevelData;
import com.soletreadmills.sole_v2._type.FitnessLevelType;
import com.soletreadmills.sole_v2.databinding.CustomSelectFitnessLevelBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectFitnessLevelCustom.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0011J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectFitnessLevelCustom;", "Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "fitnessLevelDataList", "", "Lcom/soletreadmills/sole_v2/_data/classes/FitnessLevelData;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/ui/customview/SelectFitnessLevelCustom$SelectFitnessLevelCustomListener;", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Ljava/util/List;Lcom/soletreadmills/sole_v2/ui/customview/SelectFitnessLevelCustom$SelectFitnessLevelCustomListener;)V", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomSelectFitnessLevelBinding;", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/CustomSelectFitnessLevelBinding;", "getFitnessLevelDataList", "()Ljava/util/List;", "isReset", "", "()Z", "setReset", "(Z)V", "getListener", "()Lcom/soletreadmills/sole_v2/ui/customview/SelectFitnessLevelCustom$SelectFitnessLevelCustomListener;", "checkSelect", "", "onBackPressed", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setItemView", "type", "Lcom/soletreadmills/sole_v2/_type/FitnessLevelType;", "isSelect", "toggleSelect", "SelectFitnessLevelCustomListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectFitnessLevelCustom extends BaseRelativeLayout {
    public static final int $stable = 8;
    private final CustomSelectFitnessLevelBinding binding;
    private final List<FitnessLevelData> fitnessLevelDataList;
    private boolean isReset;
    private final SelectFitnessLevelCustomListener listener;

    /* compiled from: SelectFitnessLevelCustom.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectFitnessLevelCustom$SelectFitnessLevelCustomListener;", "", SdkConstants.ATTR_ON_CLICK, "", "fitnessLevelDataList", "", "Lcom/soletreadmills/sole_v2/_data/classes/FitnessLevelData;", "onReset", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface SelectFitnessLevelCustomListener {
        void onClick(List<FitnessLevelData> fitnessLevelDataList);

        void onReset();
    }

    /* compiled from: SelectFitnessLevelCustom.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FitnessLevelType.values().length];
            try {
                iArr[FitnessLevelType.NOVICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FitnessLevelType.SKILLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FitnessLevelType.EXPERT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FitnessLevelType.ANY_LEVEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout
    public boolean onBackPressed() {
        return false;
    }

    public final List<FitnessLevelData> getFitnessLevelDataList() {
        return this.fitnessLevelDataList;
    }

    public final SelectFitnessLevelCustomListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectFitnessLevelCustom(MainActivity mainActivity, List<FitnessLevelData> fitnessLevelDataList, SelectFitnessLevelCustomListener listener) {
        super(mainActivity, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
        Intrinsics.checkNotNullParameter(fitnessLevelDataList, "fitnessLevelDataList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.fitnessLevelDataList = fitnessLevelDataList;
        this.listener = listener;
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(mainActivity), R.layout.custom_select_fitness_level, this, true);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        CustomSelectFitnessLevelBinding customSelectFitnessLevelBinding = (CustomSelectFitnessLevelBinding) viewDataBindingInflate;
        this.binding = customSelectFitnessLevelBinding;
        SelectFitnessLevelCustom selectFitnessLevelCustom = this;
        customSelectFitnessLevelBinding.close.setOnClickListener(selectFitnessLevelCustom);
        customSelectFitnessLevelBinding.reset.setOnClickListener(selectFitnessLevelCustom);
        customSelectFitnessLevelBinding.LLDone.setOnClickListener(selectFitnessLevelCustom);
        customSelectFitnessLevelBinding.LLNovice.setOnClickListener(selectFitnessLevelCustom);
        customSelectFitnessLevelBinding.LLSkilled.setOnClickListener(selectFitnessLevelCustom);
        customSelectFitnessLevelBinding.LLExpert.setOnClickListener(selectFitnessLevelCustom);
        customSelectFitnessLevelBinding.LLAnyLevel.setOnClickListener(selectFitnessLevelCustom);
        for (FitnessLevelData fitnessLevelData : fitnessLevelDataList) {
            setItemView(fitnessLevelData.getType(), fitnessLevelData.isSelect());
        }
        checkSelect();
    }

    public final CustomSelectFitnessLevelBinding getBinding() {
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
            for (FitnessLevelData fitnessLevelData : this.fitnessLevelDataList) {
                fitnessLevelData.setSelect(false);
                setItemView(fitnessLevelData.getType(), fitnessLevelData.isSelect());
            }
            this.isReset = true;
            checkSelect();
            return;
        }
        if (id2 == R.id.LL_done) {
            ArrayList arrayList = new ArrayList();
            Iterator<FitnessLevelData> it = this.fitnessLevelDataList.iterator();
            while (it.hasNext()) {
                arrayList.add(FitnessLevelData.copy$default(it.next(), null, false, 3, null));
            }
            this.listener.onClick(arrayList);
            if (this.isReset) {
                this.listener.onReset();
            }
            getMainActivity().onBackPressed();
            return;
        }
        if (id2 == R.id.LL_novice) {
            toggleSelect(FitnessLevelType.NOVICE);
            return;
        }
        if (id2 == R.id.LL_skilled) {
            toggleSelect(FitnessLevelType.SKILLED);
        } else if (id2 == R.id.LL_expert) {
            toggleSelect(FitnessLevelType.EXPERT);
        } else if (id2 == R.id.LL_anyLevel) {
            toggleSelect(FitnessLevelType.ANY_LEVEL);
        }
    }

    private final void checkSelect() {
        Iterator<FitnessLevelData> it = this.fitnessLevelDataList.iterator();
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

    private final void toggleSelect(FitnessLevelType type) {
        Object next;
        Iterator<T> it = this.fitnessLevelDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((FitnessLevelData) next).getType() == type) {
                    break;
                }
            }
        }
        FitnessLevelData fitnessLevelData = (FitnessLevelData) next;
        if (fitnessLevelData != null) {
            fitnessLevelData.setSelect(!fitnessLevelData.isSelect());
            setItemView(type, fitnessLevelData.isSelect());
        }
        checkSelect();
    }

    public final void setItemView(FitnessLevelType type, boolean isSelect) {
        Intrinsics.checkNotNullParameter(type, "type");
        Context context = getContext();
        if (context == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            if (isSelect) {
                this.binding.LLNovice.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                this.binding.txtNovice.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                this.binding.imgNovice.setImageResource(R.drawable.ic_level_novice_red);
                return;
            } else {
                this.binding.LLNovice.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                this.binding.txtNovice.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                this.binding.imgNovice.setImageResource(R.drawable.ic_level_novice);
                return;
            }
        }
        if (i == 2) {
            if (isSelect) {
                this.binding.LLSkilled.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                this.binding.txtSkilled.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                this.binding.imgSkilled.setImageResource(R.drawable.ic_level_skilled_red);
                return;
            } else {
                this.binding.LLSkilled.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                this.binding.txtSkilled.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                this.binding.imgSkilled.setImageResource(R.drawable.ic_level_skilled);
                return;
            }
        }
        if (i == 3) {
            if (isSelect) {
                this.binding.LLExpert.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                this.binding.txtExpert.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                this.binding.imgExpert.setImageResource(R.drawable.ic_level_expert02);
                return;
            } else {
                this.binding.LLExpert.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                this.binding.txtExpert.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                this.binding.imgExpert.setImageResource(R.drawable.ic_level_expert);
                return;
            }
        }
        if (i != 4) {
            return;
        }
        if (isSelect) {
            this.binding.LLAnyLevel.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
            this.binding.txtAnyLevel.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
            this.binding.imgAnyLevel.setImageResource(R.drawable.ic_level_any_red);
        } else {
            this.binding.LLAnyLevel.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
            this.binding.txtAnyLevel.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
            this.binding.imgAnyLevel.setImageResource(R.drawable.ic_level_any);
        }
    }
}
