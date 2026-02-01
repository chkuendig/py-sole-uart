package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public final class AdapterHistoryFooterItemBinding implements ViewBinding {
    private final LinearLayout rootView;

    private AdapterHistoryFooterItemBinding(LinearLayout rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AdapterHistoryFooterItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterHistoryFooterItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_history_footer_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterHistoryFooterItemBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new AdapterHistoryFooterItemBinding((LinearLayout) rootView);
    }
}
