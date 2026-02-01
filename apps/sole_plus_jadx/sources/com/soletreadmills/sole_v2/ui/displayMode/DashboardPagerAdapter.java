package com.soletreadmills.sole_v2.ui.displayMode;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayDashboardFragment.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/displayMode/DashboardPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "createFragment", "position", "", "getItemCount", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DashboardPagerAdapter extends FragmentStateAdapter {
    public static final int $stable = 0;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DashboardPagerAdapter(Fragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new DisplayDashboardP1Fragment();
        }
        if (position == 1) {
            return new DisplayDashboardP2Fragment();
        }
        if (position == 2) {
            return new DisplayDashboardP3Fragment();
        }
        return new DisplayDashboardP1Fragment();
    }
}
