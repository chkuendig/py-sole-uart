package com.soletreadmills.sole_v2.ui.adapter.viewpage;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.google.gson.Gson;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui.pair.PairDevicePageItemFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PairDeviceViewPageAdapter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/viewpage/PairDeviceViewPageAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "dataList", "", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Ljava/util/List;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PairDeviceViewPageAdapter extends FragmentStateAdapter {
    public static final int $stable = 8;
    private final List<BleDeviceInfoData> dataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PairDeviceViewPageAdapter(MainActivity fragmentActivity, List<BleDeviceInfoData> dataList) {
        super(fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList = dataList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        String json = new Gson().toJson(this.dataList.get(position));
        PairDevicePageItemFragment.Companion companion = PairDevicePageItemFragment.INSTANCE;
        Intrinsics.checkNotNull(json);
        return companion.newInstance(json);
    }
}
