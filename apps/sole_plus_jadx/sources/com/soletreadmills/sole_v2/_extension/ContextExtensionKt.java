package com.soletreadmills.sole_v2._extension;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.view.View;
import androidx.core.os.LocaleListCompat;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.MyApplication;
import com.soletreadmills.sole_v2.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import timber.log.Timber;

/* compiled from: ContextExtension.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\"\u0010\u0007\u001a\u00020\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r¨\u0006\u000e"}, d2 = {"getLocaleListFromXml", "Landroidx/core/os/LocaleListCompat;", "Landroid/content/Context;", "getMyApplication", "Lcom/soletreadmills/sole_v2/MyApplication;", "isScreenOrientationPortrait", "", "setOnClickListenerWithDebounce", "", "Landroid/view/View;", "debounceTime", "", "action", "Lkotlin/Function0;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContextExtensionKt {
    public static final MyApplication getMyApplication(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.soletreadmills.sole_v2.MyApplication");
        return (MyApplication) applicationContext;
    }

    public static final boolean isScreenOrientationPortrait(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static final LocaleListCompat getLocaleListFromXml(Context context) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(context, "<this>");
        ArrayList arrayList = new ArrayList();
        try {
            XmlResourceParser xml = context.getResources().getXml(R.xml.locales_config);
            Intrinsics.checkNotNullExpressionValue(xml, "getXml(...)");
            XmlResourceParser xmlResourceParser = xml;
            while (xmlResourceParser.getEventType() != 1) {
                if (xmlResourceParser.getEventType() == 2 && Intrinsics.areEqual(xmlResourceParser.getName(), SdkConstants.ATTR_LOCALE)) {
                    String attributeValue = xmlResourceParser.getAttributeValue(0);
                    Intrinsics.checkNotNullExpressionValue(attributeValue, "getAttributeValue(...)");
                    arrayList.add(attributeValue);
                }
                xmlResourceParser.next();
            }
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
        LocaleListCompat localeListCompatForLanguageTags = LocaleListCompat.forLanguageTags(CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null));
        Intrinsics.checkNotNullExpressionValue(localeListCompatForLanguageTags, "forLanguageTags(...)");
        return localeListCompatForLanguageTags;
    }

    public static /* synthetic */ void setOnClickListenerWithDebounce$default(View view, long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 300;
        }
        setOnClickListenerWithDebounce(view, j, function0);
    }

    public static final void setOnClickListenerWithDebounce(View view, final long j, final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final Ref.LongRef longRef = new Ref.LongRef();
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2._extension.ContextExtensionKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContextExtensionKt.setOnClickListenerWithDebounce$lambda$0(longRef, j, action, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnClickListenerWithDebounce$lambda$0(Ref.LongRef lastClickTime, long j, Function0 action, View view) {
        Intrinsics.checkNotNullParameter(lastClickTime, "$lastClickTime");
        Intrinsics.checkNotNullParameter(action, "$action");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - lastClickTime.element > j) {
            lastClickTime.element = jCurrentTimeMillis;
            action.invoke();
        }
    }
}
