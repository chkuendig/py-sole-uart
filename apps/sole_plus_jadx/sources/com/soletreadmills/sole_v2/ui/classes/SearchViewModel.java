package com.soletreadmills.sole_v2.ui.classes;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ClassesSearchViewModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_text", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "hint", "getHint", "()Ljava/lang/String;", "setHint", "(Ljava/lang/String;)V", "text", "Lkotlinx/coroutines/flow/StateFlow;", "getText", "()Lkotlinx/coroutines/flow/StateFlow;", "updateText", "", "newText", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _text;
    private String hint;
    private final StateFlow<String> text;

    public SearchViewModel() {
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow("");
        this._text = MutableStateFlow;
        this.text = MutableStateFlow;
        this.hint = "";
    }

    public final StateFlow<String> getText() {
        return this.text;
    }

    public final String getHint() {
        return this.hint;
    }

    public final void setHint(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hint = str;
    }

    public final void updateText(String newText) {
        Intrinsics.checkNotNullParameter(newText, "newText");
        this._text.setValue(newText);
    }
}
