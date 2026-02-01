package com.soletreadmills.sole_v2.ui.pair;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.navigation.fragment.FragmentKt;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.databinding.FragmentHowToLinkProfileBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HowToLinkProfileFragment.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/HowToLinkProfileFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentHowToLinkProfileBinding;", "Landroid/view/View$OnClickListener;", "()V", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HowToLinkProfileFragment extends BaseFragment<FragmentHowToLinkProfileBinding> implements View.OnClickListener {
    public static final int $stable = 0;

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentHowToLinkProfileBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentHowToLinkProfileBinding fragmentHowToLinkProfileBindingInflate = FragmentHowToLinkProfileBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentHowToLinkProfileBindingInflate, "inflate(...)");
        return fragmentHowToLinkProfileBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        ImageView imageView;
        FragmentHowToLinkProfileBinding binding = getBinding();
        if (binding == null || (imageView = binding.back) == null) {
            return;
        }
        imageView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            FragmentKt.findNavController(this).navigateUp();
        }
    }
}
