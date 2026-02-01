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
import com.soletreadmills.sole_v2._data.classes.ActivityDataBase;
import com.soletreadmills.sole_v2._data.classes.CollectionActivityData;
import com.soletreadmills.sole_v2._data.classes.SessionActivityData;
import com.soletreadmills.sole_v2._type.ActivityType;
import com.soletreadmills.sole_v2.databinding.CustomSelectActivityBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectActivityCustom.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0011J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectActivityCustom;", "Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "activityDataList", "", "Lcom/soletreadmills/sole_v2/_data/classes/ActivityDataBase;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/ui/customview/SelectActivityCustom$SelectActivityCustomListener;", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Ljava/util/List;Lcom/soletreadmills/sole_v2/ui/customview/SelectActivityCustom$SelectActivityCustomListener;)V", "getActivityDataList", "()Ljava/util/List;", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomSelectActivityBinding;", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/CustomSelectActivityBinding;", "isReset", "", "()Z", "setReset", "(Z)V", "getListener", "()Lcom/soletreadmills/sole_v2/ui/customview/SelectActivityCustom$SelectActivityCustomListener;", "checkSelect", "", "onBackPressed", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setItemView", "type", "Lcom/soletreadmills/sole_v2/_type/ActivityType;", "isSelect", "toggleSelect", "SelectActivityCustomListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectActivityCustom extends BaseRelativeLayout {
    public static final int $stable = 8;
    private final List<ActivityDataBase> activityDataList;
    private final CustomSelectActivityBinding binding;
    private boolean isReset;
    private final SelectActivityCustomListener listener;

    /* compiled from: SelectActivityCustom.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectActivityCustom$SelectActivityCustomListener;", "", SdkConstants.ATTR_ON_CLICK, "", "activityDataList", "", "Lcom/soletreadmills/sole_v2/_data/classes/ActivityDataBase;", "onReset", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface SelectActivityCustomListener {
        void onClick(List<ActivityDataBase> activityDataList);

        void onReset();
    }

    /* compiled from: SelectActivityCustom.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ActivityType.values().length];
            try {
                iArr[ActivityType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActivityType.CYCLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActivityType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ActivityType.ROWING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ActivityType.SRVO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ActivityType.FULL_SWEAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ActivityType.BOXING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ActivityType.SCULPT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ActivityType.STRETCHING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ActivityType.YOGA.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ActivityType.MEDITATION.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout
    public boolean onBackPressed() {
        return false;
    }

    public final List<ActivityDataBase> getActivityDataList() {
        return this.activityDataList;
    }

    public final SelectActivityCustomListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectActivityCustom(MainActivity mainActivity, List<ActivityDataBase> activityDataList, SelectActivityCustomListener listener) {
        super(mainActivity, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
        Intrinsics.checkNotNullParameter(activityDataList, "activityDataList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.activityDataList = activityDataList;
        this.listener = listener;
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(mainActivity), R.layout.custom_select_activity, this, true);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        CustomSelectActivityBinding customSelectActivityBinding = (CustomSelectActivityBinding) viewDataBindingInflate;
        this.binding = customSelectActivityBinding;
        SelectActivityCustom selectActivityCustom = this;
        customSelectActivityBinding.close.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.reset.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.LLDone.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.LLTreadmill.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.LLCycling.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.LLElliptical.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.LLRowing.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.LLFullSweat.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.LLBoxing.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.LLSculpt.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.LLStretching.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.LLYoga.setOnClickListener(selectActivityCustom);
        customSelectActivityBinding.LLMeditation.setOnClickListener(selectActivityCustom);
        for (ActivityDataBase activityDataBase : activityDataList) {
            setItemView(activityDataBase.getType(), activityDataBase.isSelect());
        }
        checkSelect();
    }

    public final CustomSelectActivityBinding getBinding() {
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
        ActivityDataBase collectionActivityData;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 == R.id.close) {
            getMainActivity().onBackPressed();
            return;
        }
        if (id2 == R.id.reset) {
            for (ActivityDataBase activityDataBase : this.activityDataList) {
                activityDataBase.setSelect(false);
                setItemView(activityDataBase.getType(), activityDataBase.isSelect());
            }
            this.isReset = true;
            checkSelect();
            return;
        }
        if (id2 == R.id.LL_done) {
            ArrayList arrayList = new ArrayList();
            for (ActivityDataBase activityDataBase2 : this.activityDataList) {
                if (activityDataBase2 instanceof SessionActivityData) {
                    collectionActivityData = new SessionActivityData(activityDataBase2.getType(), activityDataBase2.isSelect());
                } else if (activityDataBase2 instanceof CollectionActivityData) {
                    collectionActivityData = new CollectionActivityData(activityDataBase2.getType(), activityDataBase2.isSelect());
                } else {
                    throw new IllegalArgumentException("Unknown type");
                }
                arrayList.add(collectionActivityData);
            }
            this.listener.onClick(arrayList);
            if (this.isReset) {
                this.listener.onReset();
            }
            getMainActivity().onBackPressed();
            return;
        }
        if (id2 == R.id.LL_treadmill) {
            toggleSelect(ActivityType.TREADMILL);
            return;
        }
        if (id2 == R.id.LL_cycling) {
            toggleSelect(ActivityType.CYCLING);
            return;
        }
        if (id2 == R.id.LL_elliptical) {
            toggleSelect(ActivityType.ELLIPTICAL);
            return;
        }
        if (id2 == R.id.LL_rowing) {
            toggleSelect(ActivityType.ROWING);
            return;
        }
        if (id2 == R.id.LL_fullSweat) {
            toggleSelect(ActivityType.FULL_SWEAT);
            return;
        }
        if (id2 == R.id.LL_boxing) {
            toggleSelect(ActivityType.BOXING);
            return;
        }
        if (id2 == R.id.LL_sculpt) {
            toggleSelect(ActivityType.SCULPT);
            return;
        }
        if (id2 == R.id.LL_stretching) {
            toggleSelect(ActivityType.STRETCHING);
        } else if (id2 == R.id.LL_yoga) {
            toggleSelect(ActivityType.YOGA);
        } else if (id2 == R.id.LL_meditation) {
            toggleSelect(ActivityType.MEDITATION);
        }
    }

    private final void checkSelect() {
        Iterator<ActivityDataBase> it = this.activityDataList.iterator();
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

    private final void toggleSelect(ActivityType type) {
        Object next;
        Iterator<T> it = this.activityDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((ActivityDataBase) next).getType() == type) {
                    break;
                }
            }
        }
        ActivityDataBase activityDataBase = (ActivityDataBase) next;
        if (activityDataBase != null) {
            activityDataBase.setSelect(!activityDataBase.isSelect());
            setItemView(type, activityDataBase.isSelect());
        }
        checkSelect();
    }

    public final void setItemView(ActivityType type, boolean isSelect) {
        Intrinsics.checkNotNullParameter(type, "type");
        Context context = getContext();
        if (context == null) {
        }
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                if (isSelect) {
                    this.binding.LLTreadmill.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                    this.binding.tvTreadmill.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                    this.binding.imgTreadmill.setImageResource(R.drawable.ic_machine_treadmill_red);
                    break;
                } else {
                    this.binding.LLTreadmill.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                    this.binding.tvTreadmill.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                    this.binding.imgTreadmill.setImageResource(R.drawable.ic_machine_treadmill);
                    break;
                }
            case 2:
                if (isSelect) {
                    this.binding.LLCycling.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                    this.binding.tvCycling.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                    this.binding.imgCycling.setImageResource(R.drawable.ic_machine_bike_red);
                    break;
                } else {
                    this.binding.LLCycling.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                    this.binding.tvCycling.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                    this.binding.imgCycling.setImageResource(R.drawable.ic_machine_bike);
                    break;
                }
            case 3:
                if (isSelect) {
                    this.binding.LLElliptical.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                    this.binding.tvElliptical.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                    this.binding.imgElliptical.setImageResource(R.drawable.ic_machine_elliptical_red);
                    break;
                } else {
                    this.binding.LLElliptical.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                    this.binding.tvElliptical.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                    this.binding.imgElliptical.setImageResource(R.drawable.ic_machine_elliptical);
                    break;
                }
            case 4:
                if (isSelect) {
                    this.binding.LLRowing.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                    this.binding.tvRowing.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                    this.binding.imgRowing.setImageResource(R.drawable.ic_machine_rower_red);
                    break;
                } else {
                    this.binding.LLRowing.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                    this.binding.tvRowing.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                    this.binding.imgRowing.setImageResource(R.drawable.ic_machine_rower);
                    break;
                }
            case 6:
                if (isSelect) {
                    this.binding.LLFullSweat.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                    this.binding.tvFullSweat.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                    this.binding.imgFullSweat.setImageResource(R.drawable.ic_activity_fullsweat_red);
                    break;
                } else {
                    this.binding.LLFullSweat.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                    this.binding.tvFullSweat.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                    this.binding.imgFullSweat.setImageResource(R.drawable.ic_activity_fullsweat);
                    break;
                }
            case 7:
                if (isSelect) {
                    this.binding.LLBoxing.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                    this.binding.tvBoxing.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                    this.binding.imgBoxing.setImageResource(R.drawable.ic_activity_boxing_red);
                    break;
                } else {
                    this.binding.LLBoxing.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                    this.binding.tvBoxing.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                    this.binding.imgBoxing.setImageResource(R.drawable.ic_activity_boxing);
                    break;
                }
            case 8:
                if (isSelect) {
                    this.binding.LLSculpt.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                    this.binding.tvSculpt.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                    this.binding.imgSculpt.setImageResource(R.drawable.ic_activity_sculpt_red);
                    break;
                } else {
                    this.binding.LLSculpt.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                    this.binding.tvSculpt.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                    this.binding.imgSculpt.setImageResource(R.drawable.ic_activity_sculpt);
                    break;
                }
            case 9:
                if (isSelect) {
                    this.binding.LLStretching.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                    this.binding.tvStretching.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                    this.binding.imgStretching.setImageResource(R.drawable.ic_activity_stretching_red);
                    break;
                } else {
                    this.binding.LLStretching.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                    this.binding.tvStretching.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                    this.binding.imgStretching.setImageResource(R.drawable.ic_activity_stretching);
                    break;
                }
            case 10:
                if (isSelect) {
                    this.binding.LLYoga.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                    this.binding.tvYoga.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                    this.binding.imgYoga.setImageResource(R.drawable.ic_activity_yoga_red);
                    break;
                } else {
                    this.binding.LLYoga.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                    this.binding.tvYoga.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                    this.binding.imgYoga.setImageResource(R.drawable.ic_activity_yoga);
                    break;
                }
            case 11:
                if (isSelect) {
                    this.binding.LLMeditation.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline_tinted_raised));
                    this.binding.tvMeditation.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
                    this.binding.imgMeditation.setImageResource(R.drawable.ic_activity_meditation_red);
                    break;
                } else {
                    this.binding.LLMeditation.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner24_outline));
                    this.binding.tvMeditation.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                    this.binding.imgMeditation.setImageResource(R.drawable.ic_activity_meditation);
                    break;
                }
        }
    }
}
