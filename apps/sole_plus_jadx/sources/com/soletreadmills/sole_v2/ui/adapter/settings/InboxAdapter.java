package com.soletreadmills.sole_v2.ui.adapter.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.settings.GetMessagesApiData;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2.databinding.AdapterInboxItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.settings.InboxAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: InboxAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0018\u0019\u001aB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/InboxAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$MessageData;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "showFooter", "", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "setShowFooter", "show", "Companion", "FooterViewHolder", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InboxAdapter extends ListAdapter<GetMessagesApiData.MessageData, RecyclerView.ViewHolder> {
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 0;
    private final OnItemClickListener listener;
    private boolean showFooter;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final DiffUtil.ItemCallback<GetMessagesApiData.MessageData> DIFF = new DiffUtil.ItemCallback<GetMessagesApiData.MessageData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.settings.InboxAdapter$Companion$DIFF$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(GetMessagesApiData.MessageData oldItem, GetMessagesApiData.MessageData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getMessage_id(), newItem.getMessage_id());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(GetMessagesApiData.MessageData oldItem, GetMessagesApiData.MessageData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    public static final /* synthetic */ GetMessagesApiData.MessageData access$getItem(InboxAdapter inboxAdapter, int i) {
        return inboxAdapter.getItem(i);
    }

    public final OnItemClickListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InboxAdapter(OnItemClickListener listener) {
        super(DIFF);
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    /* compiled from: InboxAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/InboxAdapter$Companion;", "", "()V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$MessageData;", "getDIFF", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "TYPE_FOOTER", "", "TYPE_ITEM", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DiffUtil.ItemCallback<GetMessagesApiData.MessageData> getDIFF() {
            return InboxAdapter.DIFF;
        }
    }

    public final void setShowFooter(boolean show) {
        this.showFooter = show;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return (this.showFooter && position == getCurrentList().size()) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getCurrentList().size() + (this.showFooter ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_history_footer_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new FooterViewHolder(this, viewInflate);
        }
        AdapterInboxItemBinding adapterInboxItemBindingInflate = AdapterInboxItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterInboxItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterInboxItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (!(holder instanceof ViewHolder) || position >= getCurrentList().size()) {
            return;
        }
        ((ViewHolder) holder).setBind(position);
    }

    /* compiled from: InboxAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/InboxAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/soletreadmills/sole_v2/ui/adapter/settings/InboxAdapter;Landroid/view/View;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class FooterViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ InboxAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FooterViewHolder(InboxAdapter inboxAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = inboxAdapter;
        }
    }

    /* compiled from: InboxAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/InboxAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterInboxItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/settings/InboxAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterInboxItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterInboxItemBinding;", "setBind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterInboxItemBinding binding;
        final /* synthetic */ InboxAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(InboxAdapter inboxAdapter, AdapterInboxItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = inboxAdapter;
            this.binding = binding;
        }

        public final AdapterInboxItemBinding getBinding() {
            return this.binding;
        }

        public final void setBind(int position) {
            GetMessagesApiData.MessageData messageDataAccess$getItem = InboxAdapter.access$getItem(this.this$0, position);
            if (messageDataAccess$getItem == null) {
                return;
            }
            boolean z = true;
            int i = position + 1;
            GetMessagesApiData.MessageData messageDataAccess$getItem2 = i < this.this$0.getCurrentList().size() ? InboxAdapter.access$getItem(this.this$0, i) : null;
            this.binding.line.setVisibility(((messageDataAccess$getItem2 != null ? Intrinsics.areEqual((Object) messageDataAccess$getItem2.is_read(), (Object) true) : false) && Intrinsics.areEqual((Object) messageDataAccess$getItem.is_read(), (Object) false)) ? 0 : 4);
            if (messageDataAccess$getItem.getCover_url() != null) {
                try {
                    Glide.with(this.binding.getRoot().getContext()).load(messageDataAccess$getItem.getCover_url()).into(this.binding.img);
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                }
            } else {
                this.binding.img.setImageResource(R.drawable.sole_icon);
            }
            if (Intrinsics.areEqual((Object) messageDataAccess$getItem.is_read(), (Object) true)) {
                this.binding.tvNew.setVisibility(8);
                this.binding.tvTitle.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_label1));
            } else {
                this.binding.tvNew.setVisibility(0);
                this.binding.tvTitle.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorGlobal_accent));
            }
            String publish_date = messageDataAccess$getItem.getPublish_date();
            if (publish_date != null && publish_date.length() != 0) {
                z = false;
            }
            if (!z) {
                this.binding.tvDate.setText(TimeTools.INSTANCE.convertUtcToLocalDateOnly(messageDataAccess$getItem.getPublish_date()));
            }
            this.binding.tvTitle.setText(messageDataAccess$getItem.getTitle());
            this.binding.tvDec.setText(messageDataAccess$getItem.getBody());
            View root = this.binding.getRoot();
            final InboxAdapter inboxAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.settings.InboxAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InboxAdapter.ViewHolder.setBind$lambda$0(inboxAdapter, this, view);
                }
            });
            View root2 = this.binding.getRoot();
            final InboxAdapter inboxAdapter2 = this.this$0;
            root2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.settings.InboxAdapter$ViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return InboxAdapter.ViewHolder.setBind$lambda$1(inboxAdapter2, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(InboxAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean setBind$lambda$1(InboxAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition(), "delete");
            return true;
        }
    }
}
