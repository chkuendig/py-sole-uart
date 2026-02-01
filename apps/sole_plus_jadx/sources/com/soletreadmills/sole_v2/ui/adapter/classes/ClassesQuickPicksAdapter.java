package com.soletreadmills.sole_v2.ui.adapter.classes;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.classes.QuickPicksData;
import com.soletreadmills.sole_v2.databinding.AdapterClassesQuickPicksBinding;
import com.soletreadmills.sole_v2.databinding.AdapterQuickPickItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.classes.ClassesQuickPicksAdapter;
import com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragmentKt;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ClassesQuickPicksAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0016\u0010\u001b\u001a\u00020\u00112\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesQuickPicksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesQuickPicksAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "onItemClickListener", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesQuickPicksAdapter$OnItemClickListener;", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesQuickPicksAdapter$OnItemClickListener;)V", FirebaseAnalytics.Param.ITEMS, "", "Lcom/soletreadmills/sole_v2/_data/classes/QuickPicksData;", "selectedItems", "", "", "getSelectedItems", "()Ljava/util/Set;", "clearSelections", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "submitList", "data", "OnItemClickListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesQuickPicksAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private List<QuickPicksData> items;
    private final OnItemClickListener onItemClickListener;
    private final Set<String> selectedItems;

    /* compiled from: ClassesQuickPicksAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesQuickPicksAdapter$OnItemClickListener;", "", "onQuickPickClick", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/classes/QuickPicksData;", "isSelected", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemClickListener {
        void onQuickPickClick(QuickPicksData item, boolean isSelected);
    }

    public ClassesQuickPicksAdapter(Context context, OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.context = context;
        this.onItemClickListener = onItemClickListener;
        this.items = CollectionsKt.emptyList();
        this.selectedItems = new LinkedHashSet();
    }

    public final Set<String> getSelectedItems() {
        return this.selectedItems;
    }

    public final void submitList(List<QuickPicksData> data) {
        if (data == null) {
            data = CollectionsKt.emptyList();
        }
        this.items = data;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return !this.items.isEmpty() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterClassesQuickPicksBinding adapterClassesQuickPicksBindingInflate = AdapterClassesQuickPicksBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterClassesQuickPicksBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterClassesQuickPicksBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.items);
    }

    /* compiled from: ClassesQuickPicksAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesQuickPicksAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClassesQuickPicksBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesQuickPicksAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClassesQuickPicksBinding;)V", "bind", "", "dataList", "", "Lcom/soletreadmills/sole_v2/_data/classes/QuickPicksData;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClassesQuickPicksBinding binding;
        final /* synthetic */ ClassesQuickPicksAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClassesQuickPicksAdapter classesQuickPicksAdapter, AdapterClassesQuickPicksBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = classesQuickPicksAdapter;
            this.binding = binding;
        }

        public final void bind(List<QuickPicksData> dataList) {
            Pair pair;
            int color;
            int color2;
            int i;
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            final Context context = this.binding.getRoot().getContext();
            this.binding.quickPicksLabel.setText(context.getString(R.string.quickPicks));
            this.binding.flexQuickPicks.removeAllViews();
            final ClassesQuickPicksAdapter classesQuickPicksAdapter = this.this$0;
            int i2 = 0;
            for (Object obj : dataList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final QuickPicksData quickPicksData = (QuickPicksData) obj;
                final AdapterQuickPickItemBinding adapterQuickPickItemBindingInflate = AdapterQuickPickItemBinding.inflate(LayoutInflater.from(context), this.binding.flexQuickPicks, false);
                Intrinsics.checkNotNullExpressionValue(adapterQuickPickItemBindingInflate, "inflate(...)");
                String filterItemId = quickPicksData.getFilterItemId();
                final String strValueOf = (filterItemId == null && (filterItemId = quickPicksData.getFilterItemName()) == null) ? String.valueOf(i2) : filterItemId;
                String filterItemName = quickPicksData.getFilterItemName();
                String string = filterItemName != null ? StringsKt.trim((CharSequence) filterItemName).toString() : null;
                if (string == null) {
                    string = "";
                }
                String str = string;
                Character chFirstOrNull = StringsKt.firstOrNull(str);
                if (chFirstOrNull != null && Character.isDigit(chFirstOrNull.charValue())) {
                    int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, ' ', 0, false, 6, (Object) null);
                    if (iIndexOf$default != -1) {
                        int i4 = iIndexOf$default + 1;
                        String strSubstring = string.substring(0, i4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        String strSubstring2 = string.substring(i4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        String lowerCase = strSubstring2.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        pair = TuplesKt.to(strSubstring, lowerCase);
                    } else {
                        pair = TuplesKt.to(string, "");
                    }
                } else {
                    String lowerCase2 = string.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    pair = TuplesKt.to("", StringsKt.replace$default(lowerCase2, " ", "_", false, 4, (Object) null));
                }
                String str2 = (String) pair.component1();
                String str3 = (String) pair.component2();
                System.out.println((Object) ("numberPart: '" + str2 + "', textPart: '" + str3 + '\''));
                StringBuilder sbAppend = new StringBuilder().append(str2);
                Intrinsics.checkNotNull(context);
                String string2 = sbAppend.append(ClassesDetailFragmentKt.localized(context, str3)).toString();
                boolean zContains = classesQuickPicksAdapter.getSelectedItems().contains(strValueOf);
                adapterQuickPickItemBindingInflate.getRoot().setSelected(zContains);
                adapterQuickPickItemBindingInflate.tvLabel.setText(string2);
                TextView textView = adapterQuickPickItemBindingInflate.tvLabel;
                if (zContains) {
                    color = ContextCompat.getColor(context, R.color.colorLabel_accent);
                } else {
                    color = ContextCompat.getColor(context, R.color.colorLabel_label1);
                }
                textView.setTextColor(color);
                adapterQuickPickItemBindingInflate.imgIcon.setImageResource(quickPicksData.getIconName());
                ImageView imageView = adapterQuickPickItemBindingInflate.imgIcon;
                if (zContains) {
                    color2 = ContextCompat.getColor(context, R.color.colorGlobal_accent);
                } else {
                    color2 = ContextCompat.getColor(context, R.color.colorLabel_label3);
                }
                imageView.setImageTintList(ColorStateList.valueOf(color2));
                View root = adapterQuickPickItemBindingInflate.getRoot();
                if (zContains) {
                    i = R.drawable.bg_corner32_outline_tinted_raised;
                } else {
                    i = R.drawable.bg_corner28_outline;
                }
                root.setBackgroundResource(i);
                adapterQuickPickItemBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.classes.ClassesQuickPicksAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClassesQuickPicksAdapter.ViewHolder.bind$lambda$1$lambda$0(classesQuickPicksAdapter, strValueOf, adapterQuickPickItemBindingInflate, context, quickPicksData, view);
                    }
                });
                this.binding.flexQuickPicks.addView(adapterQuickPickItemBindingInflate.getRoot());
                i2 = i3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1$lambda$0(ClassesQuickPicksAdapter this$0, String id2, AdapterQuickPickItemBinding itemBinding, Context context, QuickPicksData qp, View view) {
            boolean z;
            int color;
            int color2;
            int i;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(id2, "$id");
            Intrinsics.checkNotNullParameter(itemBinding, "$itemBinding");
            Intrinsics.checkNotNullParameter(qp, "$qp");
            if (this$0.getSelectedItems().contains(id2)) {
                this$0.getSelectedItems().remove(id2);
                z = false;
            } else {
                this$0.getSelectedItems().add(id2);
                z = true;
            }
            itemBinding.getRoot().setSelected(z);
            TextView textView = itemBinding.tvLabel;
            if (z) {
                color = ContextCompat.getColor(context, R.color.colorLabel_accent);
            } else {
                color = ContextCompat.getColor(context, R.color.colorLabel_label1);
            }
            textView.setTextColor(color);
            ImageView imageView = itemBinding.imgIcon;
            if (z) {
                color2 = ContextCompat.getColor(context, R.color.colorGlobal_accent);
            } else {
                color2 = ContextCompat.getColor(context, R.color.colorLabel_label3);
            }
            imageView.setImageTintList(ColorStateList.valueOf(color2));
            View root = itemBinding.getRoot();
            if (z) {
                i = R.drawable.bg_corner32_outline_tinted_raised;
            } else {
                i = R.drawable.bg_corner28_outline;
            }
            root.setBackgroundResource(i);
            this$0.onItemClickListener.onQuickPickClick(qp, z);
        }
    }

    public final void clearSelections() {
        this.selectedItems.clear();
        notifyDataSetChanged();
    }
}
