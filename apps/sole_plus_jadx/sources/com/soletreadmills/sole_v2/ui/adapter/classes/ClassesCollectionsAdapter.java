package com.soletreadmills.sole_v2.ui.adapter.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.classes.ClassCollectionData;
import com.soletreadmills.sole_v2.databinding.AdapterClassesCollectionBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.classes.ClassesCollectionsAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassesCollectionsAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesCollectionsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesCollectionsAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "onItemClickListener", "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesCollectionsAdapter extends ListAdapter<ClassCollectionData, ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private final OnItemClickListener onItemClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassesCollectionsAdapter(Context context, OnItemClickListener onItemClickListener) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterClassesCollectionBinding adapterClassesCollectionBindingInflate = AdapterClassesCollectionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterClassesCollectionBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterClassesCollectionBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ClassCollectionData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    /* compiled from: ClassesCollectionsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesCollectionsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClassesCollectionBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesCollectionsAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClassesCollectionBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterClassesCollectionBinding;", "bind", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClassesCollectionBinding binding;
        final /* synthetic */ ClassesCollectionsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClassesCollectionsAdapter classesCollectionsAdapter, AdapterClassesCollectionBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = classesCollectionsAdapter;
            this.binding = binding;
        }

        public final AdapterClassesCollectionBinding getBinding() {
            return this.binding;
        }

        public final void bind(final ClassCollectionData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.tvWorkoutAmount.setText(String.valueOf(item.getWorkout_amount()));
            this.binding.tvClassType.setText(this.this$0.context.getString(item.getClassTypeTitle()));
            this.binding.tvCollectionName.setText(item.getCollection_name());
            this.binding.tvCollectionDescription.setText(item.getCollection_description());
            this.binding.tvClassesLabel.setText(this.this$0.context.getString(R.string.classes));
            Glide.with(this.binding.backgroundImage.getContext()).load(item.getBackground_url()).centerCrop().into(this.binding.backgroundImage);
            ConstraintLayout root = this.binding.getRoot();
            final ClassesCollectionsAdapter classesCollectionsAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.classes.ClassesCollectionsAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClassesCollectionsAdapter.ViewHolder.bind$lambda$1(this.f$0, item, classesCollectionsAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(ViewHolder this$0, ClassCollectionData item, ClassesCollectionsAdapter this$1, View view) {
            String collection_id;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || (collection_id = item.getCollection_id()) == null) {
                return;
            }
            this$1.onItemClickListener.onClick(bindingAdapterPosition, collection_id);
        }
    }

    /* compiled from: ClassesCollectionsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesCollectionsAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<ClassCollectionData> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(ClassCollectionData oldItem, ClassCollectionData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getCollection_id(), newItem.getCollection_id());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(ClassCollectionData oldItem, ClassCollectionData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
