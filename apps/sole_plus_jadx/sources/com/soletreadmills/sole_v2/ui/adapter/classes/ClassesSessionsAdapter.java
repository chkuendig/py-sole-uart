package com.soletreadmills.sole_v2.ui.adapter.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.soletreadmills.sole_v2._data.classes.ClassesData;
import com.soletreadmills.sole_v2._data.classes.DurationType;
import com.soletreadmills.sole_v2.databinding.AdapterClassesSessionsBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.classes.ClassesSessionsAdapter;
import com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassesSessionsAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesSessionsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesSessionsAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "onItemClickListener", "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesSessionsAdapter extends ListAdapter<ClassesData, ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private final OnItemClickListener onItemClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassesSessionsAdapter(Context context, OnItemClickListener onItemClickListener) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterClassesSessionsBinding adapterClassesSessionsBindingInflate = AdapterClassesSessionsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterClassesSessionsBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterClassesSessionsBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ClassesData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    /* compiled from: ClassesSessionsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesSessionsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClassesSessionsBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesSessionsAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClassesSessionsBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterClassesSessionsBinding;", "bind", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClassesSessionsBinding binding;
        final /* synthetic */ ClassesSessionsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClassesSessionsAdapter classesSessionsAdapter, AdapterClassesSessionsBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = classesSessionsAdapter;
            this.binding = binding;
        }

        public final AdapterClassesSessionsBinding getBinding() {
            return this.binding;
        }

        public final void bind(final ClassesData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.title.setText(item.getClass_name());
            this.binding.parts.setText(this.this$0.context.getString(item.getClassType().getClassCategory()));
            ImageView imgFavorite = this.binding.imgFavorite;
            Intrinsics.checkNotNullExpressionValue(imgFavorite, "imgFavorite");
            ImageView imageView = imgFavorite;
            Boolean boolIs_favorite = item.is_favorite();
            imageView.setVisibility(boolIs_favorite != null ? boolIs_favorite.booleanValue() : false ? 0 : 8);
            TextView textView = this.binding.min;
            StringBuilder sb = new StringBuilder();
            DurationType durationStr = item.getDurationStr();
            textView.setText(sb.append(durationStr != null ? durationStr.getTitle() : null).append(' ').append(ClassesDetailFragmentKt.localized(this.this$0.context, HealthConstants.HeartRate.MIN)).toString());
            Glide.with(this.binding.img.getContext()).load(item.getBackground_url()).centerCrop().into(this.binding.img);
            View root = this.binding.getRoot();
            final ClassesSessionsAdapter classesSessionsAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.classes.ClassesSessionsAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClassesSessionsAdapter.ViewHolder.bind$lambda$1(this.f$0, item, classesSessionsAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(ViewHolder this$0, ClassesData item, ClassesSessionsAdapter this$1, View view) {
            String class_id;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || (class_id = item.getClass_id()) == null) {
                return;
            }
            this$1.onItemClickListener.onClick(bindingAdapterPosition, class_id);
        }
    }

    /* compiled from: ClassesSessionsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesSessionsAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<ClassesData> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(ClassesData oldItem, ClassesData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getClass_id(), newItem.getClass_id());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(ClassesData oldItem, ClassesData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
