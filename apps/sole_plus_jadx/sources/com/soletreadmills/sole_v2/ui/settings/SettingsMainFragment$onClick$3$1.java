package com.soletreadmills.sole_v2.ui.settings;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2.databinding.FragmentSettingsMainBinding;
import com.soletreadmills.sole_v2.ui.customview.SelectLanguageCustom;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsMainFragment.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/soletreadmills/sole_v2/ui/settings/SettingsMainFragment$onClick$3$1", "Lcom/soletreadmills/sole_v2/ui/customview/SelectLanguageCustom$SelectLanguageListener;", SdkConstants.ATTR_ON_CLICK, "", "selectLocale", "Ljava/util/Locale;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsMainFragment$onClick$3$1 implements SelectLanguageCustom.SelectLanguageListener {
    final /* synthetic */ SettingsMainFragment this$0;

    SettingsMainFragment$onClick$3$1(SettingsMainFragment settingsMainFragment) {
        this.this$0 = settingsMainFragment;
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.SelectLanguageCustom.SelectLanguageListener
    public void onClick(Locale selectLocale) {
        View root;
        Intrinsics.checkNotNullParameter(selectLocale, "selectLocale");
        String country = selectLocale.getCountry();
        final LocaleListCompat localeListCompatForLanguageTags = LocaleListCompat.forLanguageTags(((country == null || country.length() == 0) ? new Locale(selectLocale.getLanguage(), Locale.getDefault().getCountry()) : selectLocale).toLanguageTag());
        Intrinsics.checkNotNullExpressionValue(localeListCompatForLanguageTags, "forLanguageTags(...)");
        String loginUuid = Global.getLoginUuid();
        if (loginUuid == null) {
            loginUuid = "";
        }
        MySharedPreferences companion = MySharedPreferences.INSTANCE.getInstance();
        String language = selectLocale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        companion.setAppLanguage(language, loginUuid);
        FragmentSettingsMainBinding fragmentSettingsMainBindingAccess$getBinding = SettingsMainFragment.access$getBinding(this.this$0);
        if (fragmentSettingsMainBindingAccess$getBinding == null || (root = fragmentSettingsMainBindingAccess$getBinding.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$onClick$3$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SettingsMainFragment$onClick$3$1.onClick$lambda$0(localeListCompatForLanguageTags);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$0(LocaleListCompat appLocale) {
        Intrinsics.checkNotNullParameter(appLocale, "$appLocale");
        AppCompatDelegate.setApplicationLocales(appLocale);
    }
}
