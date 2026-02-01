package com.soletreadmills.sole_v2.ui.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import com.soletreadmills.sole_v2._data.api.JwtErrorCode;
import com.soletreadmills.sole_v2._data.classes.DeleteFavoriteRequest;
import com.soletreadmills.sole_v2._data.classes.FavoritesData;
import com.soletreadmills.sole_v2._data.classes.GetFavoritesApiData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.JwtDyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentMyFavoritesBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.settings.MyFavoritesAdapter;
import com.sun.jna.platform.win32.WinNT;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: MyFavoritesFragment.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006J\u0006\u0010\u001b\u001a\u00020\u0018J\u001a\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\u0012\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0006\u0010)\u001a\u00020\u0018J\u0006\u0010*\u001a\u00020\u0018J\"\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u000200H\u0002R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u00061"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/MyFavoritesFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentMyFavoritesBinding;", "Landroid/view/View$OnClickListener;", "()V", "favoritesList", "", "Lcom/soletreadmills/sole_v2/_data/classes/FavoritesData;", "getFavoritesList", "()Ljava/util/List;", "setFavoritesList", "(Ljava/util/List;)V", "isEdit", "", "()Z", "setEdit", "(Z)V", "viewModel", "Lcom/soletreadmills/sole_v2/ui/settings/MyFavoritesViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/settings/MyFavoritesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "deleteFavorites", "", "list", "", "getFavorites", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "setRecyclerView", "setTextView", "updateTextViewStyle", "textView", "Landroid/widget/TextView;", "isSelected", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyFavoritesFragment extends BaseFragment<FragmentMyFavoritesBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private List<FavoritesData> favoritesList = new ArrayList();
    private boolean isEdit;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public MyFavoritesFragment() {
        final MyFavoritesFragment myFavoritesFragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(myFavoritesFragment, Reflection.getOrCreateKotlinClass(MyFavoritesViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.settings.MyFavoritesFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = myFavoritesFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.settings.MyFavoritesFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = myFavoritesFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.settings.MyFavoritesFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = myFavoritesFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MyFavoritesViewModel getViewModel() {
        return (MyFavoritesViewModel) this.viewModel.getValue();
    }

    /* renamed from: isEdit, reason: from getter */
    public final boolean getIsEdit() {
        return this.isEdit;
    }

    public final void setEdit(boolean z) {
        this.isEdit = z;
    }

    public final List<FavoritesData> getFavoritesList() {
        return this.favoritesList;
    }

    public final void setFavoritesList(List<FavoritesData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.favoritesList = list;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTextView();
        FragmentKt.findNavController(this).getBackStackEntry(R.id.myFavoritesFragment).getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.soletreadmills.sole_v2.ui.settings.MyFavoritesFragment.onViewCreated.1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                MyFavoritesFragment.this.getViewModel().reset();
                Timber.INSTANCE.d("MyFavorites removed from back stack, reset ViewModel", new Object[0]);
            }
        });
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentMyFavoritesBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentMyFavoritesBinding fragmentMyFavoritesBindingInflate = FragmentMyFavoritesBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentMyFavoritesBindingInflate, "inflate(...)");
        return fragmentMyFavoritesBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        ImageView imageView;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        FragmentMyFavoritesBinding binding = getBinding();
        if (binding != null && (textView5 = binding.txtClasses) != null) {
            textView5.setOnClickListener(this);
        }
        FragmentMyFavoritesBinding binding2 = getBinding();
        if (binding2 != null && (textView4 = binding2.txtCollections) != null) {
            textView4.setOnClickListener(this);
        }
        FragmentMyFavoritesBinding binding3 = getBinding();
        if (binding3 != null && (textView3 = binding3.txtPrograms) != null) {
            textView3.setOnClickListener(this);
        }
        FragmentMyFavoritesBinding binding4 = getBinding();
        if (binding4 != null && (textView2 = binding4.tvResetFilters) != null) {
            textView2.setOnClickListener(this);
        }
        FragmentMyFavoritesBinding binding5 = getBinding();
        if (binding5 != null && (textView = binding5.txtEditOrDone) != null) {
            textView.setOnClickListener(this);
        }
        FragmentMyFavoritesBinding binding6 = getBinding();
        if (binding6 != null && (linearLayout = binding6.LLRemoveAll) != null) {
            linearLayout.setOnClickListener(this);
        }
        FragmentMyFavoritesBinding binding7 = getBinding();
        if (binding7 != null && (imageView = binding7.back) != null) {
            imageView.setOnClickListener(this);
        }
        getFavorites();
        setRecyclerView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter = null;
        adapter = null;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.txt_editOrDone;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            boolean z = this.isEdit;
            this.isEdit = !z;
            if (!z) {
                FragmentMyFavoritesBinding binding = getBinding();
                TextView textView = binding != null ? binding.txtEditOrDone : null;
                if (textView != null) {
                    textView.setText(getString(R.string.done));
                }
                FragmentMyFavoritesBinding binding2 = getBinding();
                LinearLayout linearLayout = binding2 != null ? binding2.LLRemoveAll : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            } else {
                FragmentMyFavoritesBinding binding3 = getBinding();
                TextView textView2 = binding3 != null ? binding3.txtEditOrDone : null;
                if (textView2 != null) {
                    textView2.setText(getString(R.string.edit));
                }
                FragmentMyFavoritesBinding binding4 = getBinding();
                LinearLayout linearLayout2 = binding4 != null ? binding4.LLRemoveAll : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
            }
            setRecyclerView();
            return;
        }
        int i3 = R.id.txt_classes;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            getViewModel().setSelectClasses(!getViewModel().getSelectClasses());
            setTextView();
            getFavorites();
            return;
        }
        int i4 = R.id.txt_collections;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            getViewModel().setSelectCollections(!getViewModel().getSelectCollections());
            setTextView();
            getFavorites();
            return;
        }
        int i5 = R.id.txt_programs;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            getViewModel().setSelectPrograms(!getViewModel().getSelectPrograms());
            setTextView();
            getFavorites();
            return;
        }
        int i6 = R.id.tv_resetFilters;
        if (numValueOf != null && numValueOf.intValue() == i6) {
            getViewModel().setSelectClasses(false);
            getViewModel().setSelectCollections(false);
            getViewModel().setSelectPrograms(false);
            setTextView();
            getFavorites();
            return;
        }
        int i7 = R.id.LL_removeAll;
        if (numValueOf != null && numValueOf.intValue() == i7) {
            FragmentMyFavoritesBinding binding5 = getBinding();
            if (binding5 != null && (recyclerView = binding5.recyclerViewFavorites) != null) {
                adapter = recyclerView.getAdapter();
            }
            if (adapter instanceof MyFavoritesAdapter) {
                List<FavoritesData> currentList = ((MyFavoritesAdapter) adapter).getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                if (currentList.size() <= 0) {
                    return;
                }
            }
            CustomDialogKt.showCustomDialog$default(this, getString(R.string.are_you_sure), getString(R.string.are_you_sure_msg), getString(R.string.remove_all), getString(R.string.cancel), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.MyFavoritesFragment.onClick.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ArrayList arrayList = new ArrayList();
                    Iterator<FavoritesData> it = MyFavoritesFragment.this.getFavoritesList().iterator();
                    while (it.hasNext()) {
                        String favoriteId = it.next().getFavoriteId();
                        if (favoriteId == null) {
                            favoriteId = "";
                        }
                        arrayList.add(favoriteId);
                    }
                    MyFavoritesFragment.this.deleteFavorites(arrayList);
                }
            }, null, false, 64, null);
        }
    }

    public final void setRecyclerView() {
        RecyclerView recyclerView;
        View root;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        final Context context = getContext();
        if (context == null) {
            return;
        }
        FragmentMyFavoritesBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView3 = binding.recyclerViewFavorites) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentMyFavoritesBinding binding2 = getBinding();
            RecyclerView recyclerView4 = binding2 != null ? binding2.recyclerViewFavorites : null;
            if (recyclerView4 != null) {
                recyclerView4.setLayoutManager(new LinearLayoutManager(context));
            }
        }
        FragmentMyFavoritesBinding binding3 = getBinding();
        if (!(((binding3 == null || (recyclerView2 = binding3.recyclerViewFavorites) == null) ? null : recyclerView2.getAdapter()) instanceof MyFavoritesAdapter)) {
            MyFavoritesAdapter myFavoritesAdapter = new MyFavoritesAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.settings.MyFavoritesFragment$setRecyclerView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    RecyclerView recyclerView5;
                    FragmentMyFavoritesBinding binding4 = this.this$0.getBinding();
                    RecyclerView.Adapter adapter2 = (binding4 == null || (recyclerView5 = binding4.recyclerViewFavorites) == null) ? null : recyclerView5.getAdapter();
                    if (adapter2 instanceof MyFavoritesAdapter) {
                        List<FavoritesData> currentList = ((MyFavoritesAdapter) adapter2).getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        FavoritesData favoritesData = currentList.get(pos);
                        String objectType = favoritesData.getObjectType();
                        if (objectType != null) {
                            int iHashCode = objectType.hashCode();
                            if (iHashCode == 67) {
                                if (objectType.equals("C")) {
                                    Timber.INSTANCE.d("C: Class", new Object[0]);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("classID", favoritesData.getObjectId());
                                    this.this$0.safeNavigate(R.id.classesDetailFragment, bundle);
                                    return;
                                }
                                return;
                            }
                            if (iHashCode != 2153) {
                                if (iHashCode == 2157 && objectType.equals("CP")) {
                                    Timber.INSTANCE.d("CP: Custom program", new Object[0]);
                                    return;
                                }
                                return;
                            }
                            if (objectType.equals("CL")) {
                                Timber.INSTANCE.d("CL: Collection", new Object[0]);
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("collectionId", favoritesData.getObjectId());
                                this.this$0.safeNavigate(R.id.collectionDetailFragment, bundle2);
                            }
                        }
                    }
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    RecyclerView recyclerView5;
                    Intrinsics.checkNotNullParameter(string, "string");
                    FragmentMyFavoritesBinding binding4 = this.this$0.getBinding();
                    RecyclerView.Adapter adapter2 = (binding4 == null || (recyclerView5 = binding4.recyclerViewFavorites) == null) ? null : recyclerView5.getAdapter();
                    if (adapter2 instanceof MyFavoritesAdapter) {
                        List<FavoritesData> currentList = ((MyFavoritesAdapter) adapter2).getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        FavoritesData favoritesData = currentList.get(pos);
                        if (Intrinsics.areEqual(string, "delete")) {
                            ArrayList arrayList = new ArrayList();
                            String favoriteId = favoritesData.getFavoriteId();
                            if (favoriteId == null) {
                                favoriteId = "";
                            }
                            arrayList.add(favoriteId);
                            this.this$0.deleteFavorites(arrayList);
                        }
                    }
                }
            });
            FragmentMyFavoritesBinding binding4 = getBinding();
            RecyclerView recyclerView5 = binding4 != null ? binding4.recyclerViewFavorites : null;
            if (recyclerView5 != null) {
                recyclerView5.setAdapter(myFavoritesAdapter);
            }
        }
        final ArrayList arrayList = new ArrayList();
        for (FavoritesData favoritesData : this.favoritesList) {
            FavoritesData favoritesDataCopy = favoritesData.copy((511 & 1) != 0 ? favoritesData.favoriteId : null, (511 & 2) != 0 ? favoritesData.objectBackgroundUrl : null, (511 & 4) != 0 ? favoritesData.objectClassTypeName : null, (511 & 8) != 0 ? favoritesData.objectId : null, (511 & 16) != 0 ? favoritesData.objectMachineTypeName : null, (511 & 32) != 0 ? favoritesData.objectName : null, (511 & 64) != 0 ? favoritesData.objectType : null, (511 & 128) != 0 ? favoritesData.objectWorkoutAmount : null, (511 & 256) != 0 ? favoritesData.isEdit : false);
            if (this.isEdit) {
                favoritesDataCopy.setEdit(true);
            } else {
                favoritesDataCopy.setEdit(false);
            }
            arrayList.add(favoritesDataCopy);
        }
        FragmentMyFavoritesBinding binding5 = getBinding();
        if (binding5 != null && (root = binding5.getRoot()) != null) {
            root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.settings.MyFavoritesFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MyFavoritesFragment.setRecyclerView$lambda$0(arrayList, this, context);
                }
            });
        }
        FragmentMyFavoritesBinding binding6 = getBinding();
        if (binding6 != null && (recyclerView = binding6.recyclerViewFavorites) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof MyFavoritesAdapter) {
            ((MyFavoritesAdapter) adapter).submitList(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRecyclerView$lambda$0(List newList, MyFavoritesFragment this$0, Context context) {
        ImageView imageView;
        ImageView imageView2;
        Intrinsics.checkNotNullParameter(newList, "$newList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (newList.isEmpty()) {
            if (this$0.getViewModel().getSelectClasses() || this$0.getViewModel().getSelectCollections() || this$0.getViewModel().getSelectPrograms()) {
                FragmentMyFavoritesBinding binding = this$0.getBinding();
                TextView textView = binding != null ? binding.tvResetFilters : null;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                FragmentMyFavoritesBinding binding2 = this$0.getBinding();
                if (binding2 != null && (imageView = binding2.imgEmpty) != null) {
                    imageView.setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.search_empty));
                }
                FragmentMyFavoritesBinding binding3 = this$0.getBinding();
                TextView textView2 = binding3 != null ? binding3.tvEmpty : null;
                if (textView2 != null) {
                    textView2.setText(this$0.getString(R.string.hint_29));
                }
                FragmentMyFavoritesBinding binding4 = this$0.getBinding();
                HorizontalScrollView horizontalScrollView = binding4 != null ? binding4.scrollFilter : null;
                if (horizontalScrollView != null) {
                    horizontalScrollView.setVisibility(0);
                }
            } else {
                FragmentMyFavoritesBinding binding5 = this$0.getBinding();
                TextView textView3 = binding5 != null ? binding5.tvResetFilters : null;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                FragmentMyFavoritesBinding binding6 = this$0.getBinding();
                if (binding6 != null && (imageView2 = binding6.imgEmpty) != null) {
                    imageView2.setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.favorites));
                }
                FragmentMyFavoritesBinding binding7 = this$0.getBinding();
                TextView textView4 = binding7 != null ? binding7.tvEmpty : null;
                if (textView4 != null) {
                    textView4.setText(this$0.getString(R.string.hint_30));
                }
                FragmentMyFavoritesBinding binding8 = this$0.getBinding();
                HorizontalScrollView horizontalScrollView2 = binding8 != null ? binding8.scrollFilter : null;
                if (horizontalScrollView2 != null) {
                    horizontalScrollView2.setVisibility(8);
                }
            }
            FragmentMyFavoritesBinding binding9 = this$0.getBinding();
            LinearLayout linearLayout = binding9 != null ? binding9.LLWorkoutsEmpty : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            FragmentMyFavoritesBinding binding10 = this$0.getBinding();
            RecyclerView recyclerView = binding10 != null ? binding10.recyclerViewFavorites : null;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(8);
            return;
        }
        FragmentMyFavoritesBinding binding11 = this$0.getBinding();
        LinearLayout linearLayout2 = binding11 != null ? binding11.LLWorkoutsEmpty : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        FragmentMyFavoritesBinding binding12 = this$0.getBinding();
        RecyclerView recyclerView2 = binding12 != null ? binding12.recyclerViewFavorites : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        FragmentMyFavoritesBinding binding13 = this$0.getBinding();
        HorizontalScrollView horizontalScrollView3 = binding13 != null ? binding13.scrollFilter : null;
        if (horizontalScrollView3 == null) {
            return;
        }
        horizontalScrollView3.setVisibility(0);
    }

    public final void setTextView() {
        Context context = getContext();
        if (context != null) {
            FragmentMyFavoritesBinding binding = getBinding();
            updateTextViewStyle(binding != null ? binding.txtClasses : null, getViewModel().getSelectClasses(), context);
            FragmentMyFavoritesBinding binding2 = getBinding();
            updateTextViewStyle(binding2 != null ? binding2.txtCollections : null, getViewModel().getSelectCollections(), context);
            FragmentMyFavoritesBinding binding3 = getBinding();
            updateTextViewStyle(binding3 != null ? binding3.txtPrograms : null, getViewModel().getSelectPrograms(), context);
        }
    }

    private final void updateTextViewStyle(TextView textView, boolean isSelected, Context context) {
        if (textView != null) {
            if (isSelected) {
                textView.setTextColor(ContextCompat.getColor(context, R.color.colorGlobal_accent));
                textView.setBackgroundResource(R.drawable.bg_corner32_outline_tinted_raised);
            } else {
                textView.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                textView.setBackgroundResource(R.drawable.bg_corner32_outline);
            }
        }
    }

    /* compiled from: MyFavoritesFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.MyFavoritesFragment$getFavorites$1", f = "MyFavoritesFragment.kt", i = {}, l = {WinNT.SERVICE_TYPE_ALL}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.MyFavoritesFragment$getFavorites$1, reason: invalid class name and case insensitive filesystem */
    static final class C09991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09991(Continuation<? super C09991> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MyFavoritesFragment.this.new C09991(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            GetFavoritesApiData.ResponseData responseData;
            String message;
            JwtApiBaseData.SysResponseMessage sysMsg;
            JwtApiBaseData.SysResponseMessage sysMsg2;
            JwtApiBaseData.SysResponseMessage sysMsg3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        MyFavoritesFragment.this.showLoading();
                        ArrayList arrayList = new ArrayList();
                        if (MyFavoritesFragment.this.getViewModel().getSelectClasses()) {
                            arrayList.add("C");
                        }
                        if (MyFavoritesFragment.this.getViewModel().getSelectCollections()) {
                            arrayList.add("CL");
                        }
                        if (MyFavoritesFragment.this.getViewModel().getSelectPrograms()) {
                            arrayList.add("CP");
                        }
                        this.label = 1;
                        obj = JwtDyacoApiKt.callGetFavorites(new GetFavoritesApiData.RequestBodyData(CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null)), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    responseData = (GetFavoritesApiData.ResponseData) ((Response) obj).body();
                    Timber.INSTANCE.d("getFavorites: " + responseData, new Object[0]);
                    message = null;
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(MyFavoritesFragment.this, "getFavorites2", message2, false, 4, null);
                    unit = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), "1")) {
                    String code = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                    if (MyFavoritesFragment.this.shouldIgnoreError(code)) {
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    MyFavoritesFragment myFavoritesFragment = MyFavoritesFragment.this;
                    if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                        message = sysMsg.getMessage();
                    }
                    BaseFragment.handleUndefinedError$default(myFavoritesFragment, "getFavorites2", code, message, false, 8, null);
                } else {
                    MyFavoritesFragment myFavoritesFragment2 = MyFavoritesFragment.this;
                    ArrayList dataMap = responseData.getDataMap();
                    if (dataMap == null) {
                        dataMap = new ArrayList();
                    }
                    myFavoritesFragment2.setFavoritesList(dataMap);
                    MyFavoritesFragment.this.setRecyclerView();
                }
                MyFavoritesFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                MyFavoritesFragment.this.stopLoading();
            }
        }
    }

    public final void getFavorites() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09991(null), 3, null);
    }

    /* compiled from: MyFavoritesFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.MyFavoritesFragment$deleteFavorites$1", f = "MyFavoritesFragment.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.MyFavoritesFragment$deleteFavorites$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $list;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<String> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$list = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MyFavoritesFragment.this.new AnonymousClass1(this.$list, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            DeleteFavoriteRequest.ResponseData responseData;
            String message;
            JwtApiBaseData.SysResponseMessage sysMsg;
            JwtApiBaseData.SysResponseMessage sysMsg2;
            JwtApiBaseData.SysResponseMessage sysMsg3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        MyFavoritesFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtDyacoApiKt.callDeleteFavorite(new DeleteFavoriteRequest.RequestBodyData(this.$list), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    responseData = (DeleteFavoriteRequest.ResponseData) ((Response) obj).body();
                    Timber.INSTANCE.d("deleteFavorites: " + responseData, new Object[0]);
                    message = null;
                } catch (Exception e) {
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(MyFavoritesFragment.this, "deleteFavorites", message2, false, 4, null);
                    unit = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                    String code = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                    if (MyFavoritesFragment.this.shouldIgnoreError(code)) {
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    MyFavoritesFragment myFavoritesFragment = MyFavoritesFragment.this;
                    if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                        message = sysMsg.getMessage();
                    }
                    BaseFragment.handleUndefinedError$default(myFavoritesFragment, "deleteFavorites", code, message, false, 8, null);
                } else {
                    MyFavoritesFragment.this.getFavorites();
                }
                MyFavoritesFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                MyFavoritesFragment.this.stopLoading();
            }
        }
    }

    public final void deleteFavorites(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(list, null), 3, null);
    }
}
