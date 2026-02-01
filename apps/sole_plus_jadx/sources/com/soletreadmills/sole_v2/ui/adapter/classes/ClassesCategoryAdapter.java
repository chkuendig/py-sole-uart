package com.soletreadmills.sole_v2.ui.adapter.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.gson.Gson;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.classes.ClassesCategoryData;
import com.soletreadmills.sole_v2._type.ClassesCategoryType;
import com.soletreadmills.sole_v2.databinding.AdapterCategoryItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.classes.ClassesCategoryAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassesCategoryAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesCategoryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/classes/ClassesCategoryData;", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesCategoryAdapter$ViewHolder;", "itemClickListener", "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getItemClickListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesCategoryAdapter extends ListAdapter<ClassesCategoryData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener itemClickListener;

    public static final /* synthetic */ ClassesCategoryData access$getItem(ClassesCategoryAdapter classesCategoryAdapter, int i) {
        return classesCategoryAdapter.getItem(i);
    }

    public final OnItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassesCategoryAdapter(OnItemClickListener itemClickListener) {
        super(new DiffUtil.ItemCallback<ClassesCategoryData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.classes.ClassesCategoryAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(ClassesCategoryData oldItem, ClassesCategoryData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.getType() == newItem.getType();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(ClassesCategoryData oldItem, ClassesCategoryData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(new Gson().toJson(oldItem), new Gson().toJson(newItem));
            }
        });
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterCategoryItemBinding adapterCategoryItemBindingInflate = AdapterCategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterCategoryItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterCategoryItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setBind(position);
    }

    /* compiled from: ClassesCategoryAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesCategoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterCategoryItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesCategoryAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterCategoryItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterCategoryItemBinding;", "applySelectedStyle", "", "count", "", "setBind", "position", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterCategoryItemBinding binding;
        final /* synthetic */ ClassesCategoryAdapter this$0;

        /* compiled from: ClassesCategoryAdapter.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ClassesCategoryType.values().length];
                try {
                    iArr[ClassesCategoryType.FAVORITE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ClassesCategoryType.ACTIVITY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ClassesCategoryType.DURATION.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ClassesCategoryType.INSTRUCTORS.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ClassesCategoryType.LEVEL.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ClassesCategoryType.FOCUS.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClassesCategoryAdapter classesCategoryAdapter, AdapterCategoryItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = classesCategoryAdapter;
            this.binding = binding;
        }

        public final AdapterCategoryItemBinding getBinding() {
            return this.binding;
        }

        public final void setBind(int position) {
            final ClassesCategoryData classesCategoryDataAccess$getItem = ClassesCategoryAdapter.access$getItem(this.this$0, position);
            if (classesCategoryDataAccess$getItem == null) {
                return;
            }
            this.binding.imgFavorite.setVisibility(8);
            this.binding.title.setVisibility(8);
            this.binding.imgArrow.setVisibility(8);
            this.binding.selectCount.setVisibility(8);
            switch (WhenMappings.$EnumSwitchMapping$0[classesCategoryDataAccess$getItem.getType().ordinal()]) {
                case 1:
                    this.binding.imgFavorite.setVisibility(0);
                    if (classesCategoryDataAccess$getItem.getSelect()) {
                        this.binding.LL.setBackgroundResource(R.drawable.bg_corner32_outline_tinted_raised);
                        this.binding.imgFavorite.setImageResource(R.drawable.ic_bookmark_fill_red);
                        break;
                    } else {
                        this.binding.LL.setBackgroundResource(R.drawable.bg_corner32_outline);
                        this.binding.imgFavorite.setImageResource(R.drawable.ic_bookmark_fill);
                        break;
                    }
                case 2:
                    this.binding.title.setVisibility(0);
                    this.binding.imgArrow.setVisibility(0);
                    applySelectedStyle(classesCategoryDataAccess$getItem.getCount());
                    this.binding.title.setText(R.string.activity);
                    break;
                case 3:
                    this.binding.title.setVisibility(0);
                    this.binding.imgArrow.setVisibility(0);
                    applySelectedStyle(classesCategoryDataAccess$getItem.getCount());
                    this.binding.title.setText(R.string.duration);
                    break;
                case 4:
                    this.binding.title.setVisibility(0);
                    this.binding.imgArrow.setVisibility(0);
                    applySelectedStyle(classesCategoryDataAccess$getItem.getCount());
                    this.binding.title.setText(R.string.instructors);
                    break;
                case 5:
                    this.binding.title.setVisibility(0);
                    this.binding.imgArrow.setVisibility(0);
                    applySelectedStyle(classesCategoryDataAccess$getItem.getCount());
                    this.binding.title.setText(R.string.level);
                    break;
                case 6:
                    this.binding.title.setVisibility(0);
                    this.binding.imgArrow.setVisibility(0);
                    applySelectedStyle(classesCategoryDataAccess$getItem.getCount());
                    this.binding.title.setText(R.string.focus);
                    break;
            }
            LinearLayout linearLayout = this.binding.LL;
            final ClassesCategoryAdapter classesCategoryAdapter = this.this$0;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.classes.ClassesCategoryAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClassesCategoryAdapter.ViewHolder.setBind$lambda$0(classesCategoryAdapter, this, classesCategoryDataAccess$getItem, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(ClassesCategoryAdapter this$0, ViewHolder this$1, ClassesCategoryData data, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(data, "$data");
            this$0.getItemClickListener().onClick(this$1.getBindingAdapterPosition(), data.getType().name());
        }

        public final void applySelectedStyle(int count) {
            if (count > 0) {
                this.binding.selectCount.setVisibility(0);
                this.binding.selectCount.setText(String.valueOf(count));
                this.binding.LL.setBackgroundResource(R.drawable.bg_corner32_outline_tinted_raised);
                this.binding.imgArrow.setImageResource(R.drawable.ic_s__chevron_down_red);
                this.binding.title.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_accent));
                return;
            }
            this.binding.selectCount.setVisibility(8);
            this.binding.LL.setBackgroundResource(R.drawable.bg_corner32_outline);
            this.binding.imgArrow.setImageResource(R.drawable.ic_s__chevron_down);
            this.binding.title.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_label1));
        }
    }
}
