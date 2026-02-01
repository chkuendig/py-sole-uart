package com.soletreadmills.sole_v2.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.UserPersonalBestVoData;
import com.soletreadmills.sole_v2._data.activity.PersonalBestYearData;
import com.soletreadmills.sole_v2._data.api.activity.GetMyPersonalBestListApiData;
import com.soletreadmills.sole_v2._type.PersonalBestType;
import com.soletreadmills.sole_v2.databinding.FragmentPersonalBestBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.activity.PersonalBest02Adapter;
import com.soletreadmills.sole_v2.ui.adapter.activity.PersonalBestLockAdapter;
import com.soletreadmills.sole_v2.ui.adapter.activity.PersonalBestYearAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import timber.log.Timber;

/* compiled from: PersonalBestFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0016\u0010&\u001a\u00020\u001b2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(J\u0016\u0010*\u001a\u00020\u001b2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u0016\u0010,\u001a\u00020\u001b2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(J\u0006\u0010.\u001a\u00020\u001bR\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/activity/PersonalBestFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentPersonalBestBinding;", "Landroid/view/View$OnClickListener;", "()V", "activityViewModel", "Lcom/soletreadmills/sole_v2/ui/activity/ActivityViewModel;", "getActivityViewModel", "()Lcom/soletreadmills/sole_v2/ui/activity/ActivityViewModel;", "activityViewModel$delegate", "Lkotlin/Lazy;", "currentCollapseMode", "", "personalBestList", "", "Lcom/soletreadmills/sole_v2/_data/UserPersonalBestVoData;", "getPersonalBestList", "()Ljava/util/List;", "setPersonalBestList", "(Ljava/util/List;)V", "selectUnlock", "", "getSelectUnlock", "()Z", "setSelectUnlock", "(Z)V", "changeCollapseMode", "", "collapseMode", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setPersonalBestLockRcv", "list", "", "Lcom/soletreadmills/sole_v2/_type/PersonalBestType;", "setPersonalBestRecyclerview", "data", "setPersonalBestYear", "availableYears", "setSelectPosition", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonalBestFragment extends BaseFragment<FragmentPersonalBestBinding> implements View.OnClickListener {
    public static final int $stable = 8;

    /* renamed from: activityViewModel$delegate, reason: from kotlin metadata */
    private final Lazy activityViewModel;
    private int currentCollapseMode = 2;
    private boolean selectUnlock = true;
    private List<UserPersonalBestVoData> personalBestList = new ArrayList();

    public PersonalBestFragment() {
        final PersonalBestFragment personalBestFragment = this;
        final Function0 function0 = null;
        this.activityViewModel = FragmentViewModelLazyKt.createViewModelLazy(personalBestFragment, Reflection.getOrCreateKotlinClass(ActivityViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.activity.PersonalBestFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = personalBestFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.activity.PersonalBestFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = personalBestFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.activity.PersonalBestFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = personalBestFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public final ActivityViewModel getActivityViewModel() {
        return (ActivityViewModel) this.activityViewModel.getValue();
    }

    public final boolean getSelectUnlock() {
        return this.selectUnlock;
    }

    public final void setSelectUnlock(boolean z) {
        this.selectUnlock = z;
    }

    public final List<UserPersonalBestVoData> getPersonalBestList() {
        return this.personalBestList;
    }

    public final void setPersonalBestList(List<UserPersonalBestVoData> list) {
        this.personalBestList = list;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentPersonalBestBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentPersonalBestBinding fragmentPersonalBestBindingInflate = FragmentPersonalBestBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentPersonalBestBindingInflate, "inflate(...)");
        return fragmentPersonalBestBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ImageView imageView;
        AppBarLayout appBarLayout;
        FragmentPersonalBestBinding binding = getBinding();
        if (binding != null && (appBarLayout = binding.appBarLayout) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soletreadmills.sole_v2.ui.activity.PersonalBestFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    PersonalBestFragment.initViews$lambda$0(this.f$0, appBarLayout2, i);
                }
            });
        }
        FragmentPersonalBestBinding binding2 = getBinding();
        if (binding2 != null && (imageView = binding2.back) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentPersonalBestBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout2 = binding3.LLUnlockHeader) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentPersonalBestBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout = binding4.LLLockHeader) != null) {
            linearLayout.setOnClickListener(this);
        }
        this.selectUnlock = true;
        List<UserPersonalBestVoData> value = getActivityViewModel().getUserPersonalBestVoData().getValue();
        this.personalBestList = value;
        setPersonalBestRecyclerview(value != null ? GetMyPersonalBestListApiData.DataMap.INSTANCE.filterBestRecords(value) : null);
        List<UserPersonalBestVoData> list = this.personalBestList;
        setPersonalBestLockRcv(list != null ? GetMyPersonalBestListApiData.DataMap.INSTANCE.getMissingPersonalBestItems(list) : null);
        List<UserPersonalBestVoData> list2 = this.personalBestList;
        setPersonalBestYear(list2 != null ? GetMyPersonalBestListApiData.DataMap.INSTANCE.getAvailableYears(list2) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(PersonalBestFragment this$0, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = ((float) Math.abs(i)) / ((float) appBarLayout.getTotalScrollRange()) >= 0.85f ? 1 : 2;
        if (this$0.currentCollapseMode != i2) {
            this$0.changeCollapseMode(i2);
            this$0.currentCollapseMode = i2;
        }
    }

    private final void changeCollapseMode(int collapseMode) {
        TextView textView;
        Toolbar toolbar;
        FragmentPersonalBestBinding binding = getBinding();
        ViewGroup.LayoutParams layoutParams = (binding == null || (toolbar = binding.collapsingToolbar) == null) ? null : toolbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) layoutParams;
        layoutParams2.setCollapseMode(collapseMode);
        FragmentPersonalBestBinding binding2 = getBinding();
        Toolbar toolbar2 = binding2 != null ? binding2.collapsingToolbar : null;
        if (toolbar2 != null) {
            toolbar2.setLayoutParams(layoutParams2);
        }
        if (collapseMode == 2) {
            FragmentPersonalBestBinding binding3 = getBinding();
            textView = binding3 != null ? binding3.title : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        FragmentPersonalBestBinding binding4 = getBinding();
        textView = binding4 != null ? binding4.title : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.LL_unlockHeader;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            this.selectUnlock = true;
            setSelectPosition();
            return;
        }
        int i3 = R.id.LL_lockHeader;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            this.selectUnlock = false;
            setSelectPosition();
        }
    }

    public final void setSelectPosition() {
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        RecyclerView recyclerView;
        Context context = getContext();
        if (context != null) {
            if (this.selectUnlock) {
                FragmentPersonalBestBinding binding = getBinding();
                LinearLayout linearLayout2 = binding != null ? binding.LLUnlock : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                FragmentPersonalBestBinding binding2 = getBinding();
                LinearLayout linearLayout3 = binding2 != null ? binding2.LLLock : null;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                FragmentPersonalBestBinding binding3 = getBinding();
                LinearLayout linearLayout4 = binding3 != null ? binding3.LLGreatJob : null;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                FragmentPersonalBestBinding binding4 = getBinding();
                View view = binding4 != null ? binding4.unlockLine : null;
                if (view != null) {
                    view.setVisibility(0);
                }
                FragmentPersonalBestBinding binding5 = getBinding();
                View view2 = binding5 != null ? binding5.lockLine : null;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                FragmentPersonalBestBinding binding6 = getBinding();
                RecyclerView.Adapter adapter = (binding6 == null || (recyclerView = binding6.rcvYear) == null) ? null : recyclerView.getAdapter();
                if (adapter instanceof PersonalBestYearAdapter) {
                    List<PersonalBestYearData> currentList = ((PersonalBestYearAdapter) adapter).getCurrentList();
                    Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                    if (currentList.size() > 1) {
                        FragmentPersonalBestBinding binding7 = getBinding();
                        linearLayout = binding7 != null ? binding7.LLYear : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(0);
                        }
                    } else {
                        FragmentPersonalBestBinding binding8 = getBinding();
                        linearLayout = binding8 != null ? binding8.LLYear : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                    }
                }
                FragmentPersonalBestBinding binding9 = getBinding();
                if (binding9 != null && (textView4 = binding9.tvUnlockTitle) != null) {
                    textView4.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label2));
                }
                FragmentPersonalBestBinding binding10 = getBinding();
                if (binding10 == null || (textView3 = binding10.tvLockTitle) == null) {
                    return;
                }
                textView3.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
                return;
            }
            FragmentPersonalBestBinding binding11 = getBinding();
            LinearLayout linearLayout5 = binding11 != null ? binding11.LLUnlock : null;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
            FragmentPersonalBestBinding binding12 = getBinding();
            LinearLayout linearLayout6 = binding12 != null ? binding12.LLLock : null;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
            FragmentPersonalBestBinding binding13 = getBinding();
            LinearLayout linearLayout7 = binding13 != null ? binding13.LLGreatJob : null;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(8);
            }
            FragmentPersonalBestBinding binding14 = getBinding();
            View view3 = binding14 != null ? binding14.unlockLine : null;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            FragmentPersonalBestBinding binding15 = getBinding();
            View view4 = binding15 != null ? binding15.lockLine : null;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            FragmentPersonalBestBinding binding16 = getBinding();
            linearLayout = binding16 != null ? binding16.LLYear : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            FragmentPersonalBestBinding binding17 = getBinding();
            if (binding17 != null && (textView2 = binding17.tvUnlockTitle) != null) {
                textView2.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
            }
            FragmentPersonalBestBinding binding18 = getBinding();
            if (binding18 == null || (textView = binding18.tvLockTitle) == null) {
                return;
            }
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label2));
        }
    }

    public final void setPersonalBestRecyclerview(List<UserPersonalBestVoData> data) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Context context = getContext();
        if (context != null) {
            FragmentPersonalBestBinding binding = getBinding();
            RecyclerView.Adapter adapter = null;
            if (!(((binding == null || (recyclerView3 = binding.recyclerview) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentPersonalBestBinding binding2 = getBinding();
                RecyclerView recyclerView4 = binding2 != null ? binding2.recyclerview : null;
                if (recyclerView4 != null) {
                    recyclerView4.setLayoutManager(new LinearLayoutManager(context));
                }
            }
            FragmentPersonalBestBinding binding3 = getBinding();
            if (!(((binding3 == null || (recyclerView2 = binding3.recyclerview) == null) ? null : recyclerView2.getAdapter()) instanceof PersonalBest02Adapter)) {
                PersonalBest02Adapter personalBest02Adapter = new PersonalBest02Adapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.activity.PersonalBestFragment$setPersonalBestRecyclerview$1$adapter$1
                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos, String string) {
                        Intrinsics.checkNotNullParameter(string, "string");
                    }

                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos) {
                        RecyclerView recyclerView5;
                        FragmentPersonalBestBinding binding4 = this.this$0.getBinding();
                        RecyclerView.Adapter adapter2 = (binding4 == null || (recyclerView5 = binding4.recyclerview) == null) ? null : recyclerView5.getAdapter();
                        if (adapter2 instanceof PersonalBest02Adapter) {
                            List<UserPersonalBestVoData> currentList = ((PersonalBest02Adapter) adapter2).getCurrentList();
                            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                            UserPersonalBestVoData userPersonalBestVoData = currentList.get(pos);
                            Bundle bundle = new Bundle();
                            String currentBestUserWorkoutUuid = userPersonalBestVoData.getCurrentBestUserWorkoutUuid();
                            if (currentBestUserWorkoutUuid == null) {
                                currentBestUserWorkoutUuid = "";
                            }
                            bundle.putString("workoutUuid", currentBestUserWorkoutUuid);
                            bundle.putBoolean("isBest", true);
                            this.this$0.safeNavigate(R.id.historyWorkoutFragment, bundle);
                        }
                    }
                });
                FragmentPersonalBestBinding binding4 = getBinding();
                RecyclerView recyclerView5 = binding4 != null ? binding4.recyclerview : null;
                if (recyclerView5 != null) {
                    recyclerView5.setAdapter(personalBest02Adapter);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (data != null) {
                FragmentPersonalBestBinding binding5 = getBinding();
                RecyclerView recyclerView6 = binding5 != null ? binding5.recyclerview : null;
                if (recyclerView6 != null) {
                    recyclerView6.setVisibility(0);
                }
                Iterator<UserPersonalBestVoData> it = data.iterator();
                while (it.hasNext()) {
                    arrayList.add(UserPersonalBestVoData.copy$default(it.next(), null, null, null, null, null, null, 63, null));
                }
            } else {
                FragmentPersonalBestBinding binding6 = getBinding();
                RecyclerView recyclerView7 = binding6 != null ? binding6.recyclerview : null;
                if (recyclerView7 != null) {
                    recyclerView7.setVisibility(8);
                }
            }
            FragmentPersonalBestBinding binding7 = getBinding();
            if (binding7 != null && (recyclerView = binding7.recyclerview) != null) {
                adapter = recyclerView.getAdapter();
            }
            if (adapter instanceof PersonalBest02Adapter) {
                ((PersonalBest02Adapter) adapter).submitList(arrayList);
            }
        }
    }

    public final void setPersonalBestLockRcv(List<? extends PersonalBestType> list) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Context context = getContext();
        if (context != null) {
            FragmentPersonalBestBinding binding = getBinding();
            RecyclerView.Adapter adapter = null;
            if (!(((binding == null || (recyclerView3 = binding.rcvLock) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentPersonalBestBinding binding2 = getBinding();
                RecyclerView recyclerView4 = binding2 != null ? binding2.rcvLock : null;
                if (recyclerView4 != null) {
                    recyclerView4.setLayoutManager(new LinearLayoutManager(context));
                }
            }
            FragmentPersonalBestBinding binding3 = getBinding();
            if (!(((binding3 == null || (recyclerView2 = binding3.rcvLock) == null) ? null : recyclerView2.getAdapter()) instanceof PersonalBestLockAdapter)) {
                PersonalBestLockAdapter personalBestLockAdapter = new PersonalBestLockAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.activity.PersonalBestFragment$setPersonalBestLockRcv$1$adapter$1
                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos) {
                    }

                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos, String string) {
                        Intrinsics.checkNotNullParameter(string, "string");
                    }
                });
                FragmentPersonalBestBinding binding4 = getBinding();
                RecyclerView recyclerView5 = binding4 != null ? binding4.rcvLock : null;
                if (recyclerView5 != null) {
                    recyclerView5.setAdapter(personalBestLockAdapter);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                FragmentPersonalBestBinding binding5 = getBinding();
                RecyclerView recyclerView6 = binding5 != null ? binding5.rcvLock : null;
                if (recyclerView6 != null) {
                    recyclerView6.setVisibility(0);
                }
                FragmentPersonalBestBinding binding6 = getBinding();
                LinearLayout linearLayout = binding6 != null ? binding6.LLGreatJob : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                Iterator<? extends PersonalBestType> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } else {
                FragmentPersonalBestBinding binding7 = getBinding();
                RecyclerView recyclerView7 = binding7 != null ? binding7.rcvLock : null;
                if (recyclerView7 != null) {
                    recyclerView7.setVisibility(8);
                }
                FragmentPersonalBestBinding binding8 = getBinding();
                LinearLayout linearLayout2 = binding8 != null ? binding8.LLGreatJob : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
            }
            FragmentPersonalBestBinding binding9 = getBinding();
            if (binding9 != null && (recyclerView = binding9.rcvLock) != null) {
                adapter = recyclerView.getAdapter();
            }
            if (adapter instanceof PersonalBestLockAdapter) {
                ((PersonalBestLockAdapter) adapter).submitList(arrayList);
            }
        }
    }

    public final void setPersonalBestYear(List<Integer> availableYears) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        ArrayList arrayList = new ArrayList();
        RecyclerView.Adapter adapter = null;
        if (availableYears != null && (!availableYears.isEmpty()) && availableYears.size() > 1) {
            String string = getString(R.string.all_time);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            arrayList.add(new PersonalBestYearData(string, true));
            Iterator<Integer> it = availableYears.iterator();
            while (it.hasNext()) {
                arrayList.add(new PersonalBestYearData(String.valueOf(it.next().intValue()), false));
            }
            FragmentPersonalBestBinding binding = getBinding();
            LinearLayout linearLayout = binding != null ? binding.LLYear : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            FragmentPersonalBestBinding binding2 = getBinding();
            LinearLayout linearLayout2 = binding2 != null ? binding2.LLYear : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        Context context = getContext();
        if (context != null) {
            FragmentPersonalBestBinding binding3 = getBinding();
            if (!(((binding3 == null || (recyclerView3 = binding3.rcvYear) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentPersonalBestBinding binding4 = getBinding();
                RecyclerView recyclerView4 = binding4 != null ? binding4.rcvYear : null;
                if (recyclerView4 != null) {
                    recyclerView4.setLayoutManager(new LinearLayoutManager(context, 0, false));
                }
            }
            FragmentPersonalBestBinding binding5 = getBinding();
            if (!(((binding5 == null || (recyclerView2 = binding5.rcvYear) == null) ? null : recyclerView2.getAdapter()) instanceof PersonalBestYearAdapter)) {
                PersonalBestYearAdapter personalBestYearAdapter = new PersonalBestYearAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.activity.PersonalBestFragment$setPersonalBestYear$1$adapter$1
                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos, String string2) {
                        Intrinsics.checkNotNullParameter(string2, "string");
                    }

                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos) {
                        RecyclerView recyclerView5;
                        FragmentPersonalBestBinding binding6 = this.this$0.getBinding();
                        RecyclerView.Adapter adapter2 = (binding6 == null || (recyclerView5 = binding6.rcvYear) == null) ? null : recyclerView5.getAdapter();
                        if (adapter2 instanceof PersonalBestYearAdapter) {
                            PersonalBestYearAdapter personalBestYearAdapter2 = (PersonalBestYearAdapter) adapter2;
                            List<PersonalBestYearData> currentList = personalBestYearAdapter2.getCurrentList();
                            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                            List mutableList = CollectionsKt.toMutableList((Collection) currentList);
                            PersonalBestYearData personalBestYearData = (PersonalBestYearData) mutableList.get(pos);
                            int size = mutableList.size();
                            int i = 0;
                            int i2 = -1;
                            while (i < size) {
                                if (((PersonalBestYearData) mutableList.get(i)).isSelect()) {
                                    i2 = i;
                                }
                                ((PersonalBestYearData) mutableList.get(i)).setSelect(i == pos);
                                i++;
                            }
                            if (i2 != -1 && i2 != pos) {
                                personalBestYearAdapter2.notifyItemChanged(i2);
                            }
                            personalBestYearAdapter2.notifyItemChanged(pos);
                            try {
                                if (Intrinsics.areEqual(personalBestYearData.getYearOrAll(), this.this$0.getString(R.string.all_time))) {
                                    PersonalBestFragment personalBestFragment = this.this$0;
                                    List<UserPersonalBestVoData> personalBestList = personalBestFragment.getPersonalBestList();
                                    personalBestFragment.setPersonalBestRecyclerview(personalBestList != null ? GetMyPersonalBestListApiData.DataMap.INSTANCE.filterBestRecords(personalBestList) : null);
                                } else {
                                    PersonalBestFragment personalBestFragment2 = this.this$0;
                                    List<UserPersonalBestVoData> personalBestList2 = personalBestFragment2.getPersonalBestList();
                                    personalBestFragment2.setPersonalBestRecyclerview(personalBestList2 != null ? GetMyPersonalBestListApiData.DataMap.INSTANCE.filterByYear(personalBestList2, Integer.parseInt(personalBestYearData.getYearOrAll())) : null);
                                }
                            } catch (Exception e) {
                                Timber.INSTANCE.e(e);
                                PersonalBestFragment personalBestFragment3 = this.this$0;
                                List<UserPersonalBestVoData> personalBestList3 = personalBestFragment3.getPersonalBestList();
                                personalBestFragment3.setPersonalBestRecyclerview(personalBestList3 != null ? GetMyPersonalBestListApiData.DataMap.INSTANCE.filterBestRecords(personalBestList3) : null);
                            }
                        }
                    }
                });
                FragmentPersonalBestBinding binding6 = getBinding();
                RecyclerView recyclerView5 = binding6 != null ? binding6.rcvYear : null;
                if (recyclerView5 != null) {
                    recyclerView5.setAdapter(personalBestYearAdapter);
                }
            }
            FragmentPersonalBestBinding binding7 = getBinding();
            if (binding7 != null && (recyclerView = binding7.rcvYear) != null) {
                adapter = recyclerView.getAdapter();
            }
            if (adapter instanceof PersonalBestYearAdapter) {
                ((PersonalBestYearAdapter) adapter).submitList(arrayList);
            }
        }
    }
}
