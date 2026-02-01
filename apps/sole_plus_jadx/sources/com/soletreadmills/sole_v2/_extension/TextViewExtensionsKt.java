package com.soletreadmills.sole_v2._extension;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextViewExtensions.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\b"}, d2 = {"setRedUnderlineClickable", "", "Landroid/widget/TextView;", "text", "", SdkConstants.ATTR_ON_CLICK, "Lkotlin/Function1;", "Landroid/content/Context;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TextViewExtensionsKt {
    public static final void setRedUnderlineClickable(final TextView textView, String text, final Function1<? super Context, Unit> onClick) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(textView.getContext(), R.color.colorGlobal_accent)), 0, text.length(), 33);
        spannableString.setSpan(new UnderlineSpan(), 0, text.length(), 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2._extension.TextViewExtensionsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextViewExtensionsKt.setRedUnderlineClickable$lambda$1(onClick, textView, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRedUnderlineClickable$lambda$1(Function1 onClick, TextView this_setRedUnderlineClickable, View view) {
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        Intrinsics.checkNotNullParameter(this_setRedUnderlineClickable, "$this_setRedUnderlineClickable");
        Context context = this_setRedUnderlineClickable.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        onClick.invoke(context);
    }
}
