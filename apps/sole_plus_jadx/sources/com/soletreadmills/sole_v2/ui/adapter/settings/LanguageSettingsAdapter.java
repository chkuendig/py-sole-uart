package com.soletreadmills.sole_v2.ui.adapter.settings;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.os.LocaleListCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._extension.ContextExtensionKt;
import com.soletreadmills.sole_v2.databinding.AdapterLanguageSettingsBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui.adapter.settings.LanguageSettingsAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: LanguageSettingsAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/LanguageSettingsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/ui/adapter/settings/LanguageSettingsAdapter$AdapterData;", "Lcom/soletreadmills/sole_v2/ui/adapter/settings/LanguageSettingsAdapter$ViewHolder;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "defaultLocale", "Ljava/util/Locale;", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Ljava/util/Locale;)V", "getSelectLocale", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "AdapterData", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LanguageSettingsAdapter extends ListAdapter<AdapterData, ViewHolder> {
    public static final int $stable = 0;

    public static final /* synthetic */ AdapterData access$getItem(LanguageSettingsAdapter languageSettingsAdapter, int i) {
        return languageSettingsAdapter.getItem(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LanguageSettingsAdapter(MainActivity mainActivity, Locale locale) throws Resources.NotFoundException {
        String language;
        boolean zAreEqual;
        super(new DiffUtil.ItemCallback<AdapterData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.settings.LanguageSettingsAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(AdapterData oldItem, AdapterData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getLocale(), newItem.getLocale());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(AdapterData oldItem, AdapterData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
        ArrayList arrayList = new ArrayList();
        LocaleListCompat localeListFromXml = ContextExtensionKt.getLocaleListFromXml(mainActivity);
        if (localeListFromXml == null) {
            localeListFromXml = LocaleListCompat.getEmptyLocaleList();
            Intrinsics.checkNotNullExpressionValue(localeListFromXml, "getEmptyLocaleList(...)");
        }
        if (locale == null) {
            language = mainActivity.getString(R.string.locale_code);
            if (language == null) {
                language = "";
            }
        } else {
            language = locale.getLanguage();
        }
        int size = localeListFromXml.size();
        for (int i = 0; i < size; i++) {
            Locale locale2 = localeListFromXml.get(i);
            if (locale2 != null) {
                Timber.INSTANCE.d("LocaleListCompat localeFromXml=" + locale2, new Object[0]);
                if (Intrinsics.areEqual(locale2, Locale.TRADITIONAL_CHINESE)) {
                    zAreEqual = Intrinsics.areEqual(language, "zh_tw");
                } else if (Intrinsics.areEqual(locale2, Locale.SIMPLIFIED_CHINESE)) {
                    zAreEqual = Intrinsics.areEqual(language, "zh_cn");
                } else if (Intrinsics.areEqual(locale2, Locale.GERMAN)) {
                    zAreEqual = Intrinsics.areEqual(language, "de");
                } else if (Intrinsics.areEqual(locale2, new Locale("es"))) {
                    zAreEqual = Intrinsics.areEqual(language, "es");
                } else if (Intrinsics.areEqual(locale2, Locale.FRENCH)) {
                    zAreEqual = Intrinsics.areEqual(language, "fr");
                } else if (Intrinsics.areEqual(locale2, new Locale("ru"))) {
                    zAreEqual = Intrinsics.areEqual(language, "ru");
                } else if (Intrinsics.areEqual(locale2, Locale.JAPANESE)) {
                    zAreEqual = Intrinsics.areEqual(language, "ja");
                } else {
                    zAreEqual = Intrinsics.areEqual(language, "en");
                }
                arrayList.add(new AdapterData(locale2, zAreEqual));
            }
        }
        submitList(arrayList);
    }

    public final Locale getSelectLocale() {
        Object next;
        List<AdapterData> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        Iterator<T> it = currentList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((AdapterData) next).isSelect()) {
                break;
            }
        }
        AdapterData adapterData = (AdapterData) next;
        if (adapterData != null) {
            return adapterData.getLocale();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterLanguageSettingsBinding adapterLanguageSettingsBindingInflate = AdapterLanguageSettingsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterLanguageSettingsBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterLanguageSettingsBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setBind(position);
    }

    /* compiled from: LanguageSettingsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/LanguageSettingsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterLanguageSettingsBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/settings/LanguageSettingsAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterLanguageSettingsBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterLanguageSettingsBinding;", "setBind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterLanguageSettingsBinding binding;
        final /* synthetic */ LanguageSettingsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(LanguageSettingsAdapter languageSettingsAdapter, AdapterLanguageSettingsBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = languageSettingsAdapter;
            this.binding = binding;
        }

        public final AdapterLanguageSettingsBinding getBinding() {
            return this.binding;
        }

        public final void setBind(int position) {
            int i;
            AdapterData adapterDataAccess$getItem = LanguageSettingsAdapter.access$getItem(this.this$0, position);
            AppCompatTextView appCompatTextView = this.binding.title;
            if (Intrinsics.areEqual(adapterDataAccess$getItem.getLocale(), Locale.SIMPLIFIED_CHINESE)) {
                i = R.string.simplified_chinese;
            } else if (Intrinsics.areEqual(adapterDataAccess$getItem.getLocale(), Locale.TRADITIONAL_CHINESE)) {
                i = R.string.traditional_chinese;
            } else if (Intrinsics.areEqual(adapterDataAccess$getItem.getLocale(), Locale.GERMAN)) {
                i = R.string.german;
            } else if (Intrinsics.areEqual(adapterDataAccess$getItem.getLocale(), new Locale("es"))) {
                i = R.string.spanish;
            } else if (Intrinsics.areEqual(adapterDataAccess$getItem.getLocale(), Locale.FRENCH)) {
                i = R.string.french;
            } else if (Intrinsics.areEqual(adapterDataAccess$getItem.getLocale(), new Locale("ru"))) {
                i = R.string.russian;
            } else if (Intrinsics.areEqual(adapterDataAccess$getItem.getLocale(), Locale.JAPANESE)) {
                i = R.string.japanese;
            } else {
                i = R.string.english;
            }
            appCompatTextView.setText(i);
            this.binding.img.setSelected(adapterDataAccess$getItem.isSelect());
            LinearLayoutCompat linearLayoutCompat = this.binding.mainLayout;
            final LanguageSettingsAdapter languageSettingsAdapter = this.this$0;
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.settings.LanguageSettingsAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LanguageSettingsAdapter.ViewHolder.setBind$lambda$0(this.f$0, languageSettingsAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(ViewHolder this$0, LanguageSettingsAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (AdapterData adapterData : this$1.getCurrentList()) {
                int i2 = i + 1;
                Intrinsics.checkNotNull(adapterData);
                arrayList.add(AdapterData.copy$default(adapterData, null, i == bindingAdapterPosition, 1, null));
                i = i2;
            }
            this$1.submitList(arrayList);
        }
    }

    /* compiled from: LanguageSettingsAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/LanguageSettingsAdapter$AdapterData;", "", SdkConstants.ATTR_LOCALE, "Ljava/util/Locale;", "isSelect", "", "(Ljava/util/Locale;Z)V", "()Z", "setSelect", "(Z)V", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AdapterData {
        public static final int $stable = 8;
        private boolean isSelect;
        private Locale locale;

        public static /* synthetic */ AdapterData copy$default(AdapterData adapterData, Locale locale, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                locale = adapterData.locale;
            }
            if ((i & 2) != 0) {
                z = adapterData.isSelect;
            }
            return adapterData.copy(locale, z);
        }

        /* renamed from: component1, reason: from getter */
        public final Locale getLocale() {
            return this.locale;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSelect() {
            return this.isSelect;
        }

        public final AdapterData copy(Locale locale, boolean isSelect) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return new AdapterData(locale, isSelect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdapterData)) {
                return false;
            }
            AdapterData adapterData = (AdapterData) other;
            return Intrinsics.areEqual(this.locale, adapterData.locale) && this.isSelect == adapterData.isSelect;
        }

        public int hashCode() {
            return (this.locale.hashCode() * 31) + Boolean.hashCode(this.isSelect);
        }

        public String toString() {
            return "AdapterData(locale=" + this.locale + ", isSelect=" + this.isSelect + ')';
        }

        public AdapterData(Locale locale, boolean z) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            this.locale = locale;
            this.isSelect = z;
        }

        public /* synthetic */ AdapterData(Locale locale, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(locale, (i & 2) != 0 ? false : z);
        }

        public final Locale getLocale() {
            return this.locale;
        }

        public final void setLocale(Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "<set-?>");
            this.locale = locale;
        }

        public final boolean isSelect() {
            return this.isSelect;
        }

        public final void setSelect(boolean z) {
            this.isSelect = z;
        }
    }
}
