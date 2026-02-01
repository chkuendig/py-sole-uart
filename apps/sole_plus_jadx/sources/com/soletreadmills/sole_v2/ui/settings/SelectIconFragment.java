package com.soletreadmills.sole_v2.ui.settings;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.settings.SetCoverPhotoApiData;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._data.settings.SelectIconData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._tools.FileTool;
import com.soletreadmills.sole_v2.databinding.FragmentSelectIconBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.settings.SelectIconAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: SelectIconFragment.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d¨\u0006\u001e"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/SelectIconFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentSelectIconBinding;", "Landroid/view/View$OnClickListener;", "()V", "getDrawableResources", "", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "prefix", "", SessionDescription.ATTR_RANGE, "Lkotlin/ranges/IntRange;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setRecyclerView", "uploadImage", "image", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectIconFragment extends BaseFragment<FragmentSelectIconBinding> implements View.OnClickListener {
    public static final int $stable = 0;

    public static final /* synthetic */ FragmentSelectIconBinding access$getBinding(SelectIconFragment selectIconFragment) {
        return selectIconFragment.getBinding();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentSelectIconBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentSelectIconBinding fragmentSelectIconBindingInflate = FragmentSelectIconBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentSelectIconBindingInflate, "inflate(...)");
        return fragmentSelectIconBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        TextView textView;
        FragmentSelectIconBinding binding = getBinding();
        if (binding != null && (textView = binding.cancel) != null) {
            textView.setOnClickListener(this);
        }
        FragmentSelectIconBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout = binding2.LLDone) != null) {
            linearLayout.setOnClickListener(this);
        }
        setRecyclerView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.cancel;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.LL_done;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
        }
    }

    /* compiled from: SelectIconFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SelectIconFragment$onClick$1", f = "SelectIconFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SelectIconFragment$onClick$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SelectIconFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object next;
            RecyclerView recyclerView;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FragmentSelectIconBinding fragmentSelectIconBindingAccess$getBinding = SelectIconFragment.access$getBinding(SelectIconFragment.this);
            RecyclerView.Adapter adapter = (fragmentSelectIconBindingAccess$getBinding == null || (recyclerView = fragmentSelectIconBindingAccess$getBinding.recyclerview) == null) ? null : recyclerView.getAdapter();
            if (adapter instanceof SelectIconAdapter) {
                List<SelectIconData> currentList = ((SelectIconAdapter) adapter).getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                Iterator<T> it = currentList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((SelectIconData) next).isSelect()) {
                        break;
                    }
                }
                SelectIconData selectIconData = (SelectIconData) next;
                if (selectIconData != null) {
                    int resouceId = selectIconData.getResouceId();
                    StringBuilder sb = new StringBuilder("android.resource://");
                    Context context = SelectIconFragment.this.getContext();
                    Uri uri = Uri.parse(sb.append(context != null ? context.getPackageName() : null).append('/').append(resouceId).toString());
                    FileTool fileTool = FileTool.INSTANCE;
                    Context contextRequireContext = SelectIconFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    Intrinsics.checkNotNull(uri);
                    File fileResizeImageWithGlide = fileTool.resizeImageWithGlide(contextRequireContext, uri, 500, 500);
                    Timber.INSTANCE.d("resizeImage-----" + fileResizeImageWithGlide, new Object[0]);
                    if (fileResizeImageWithGlide == null) {
                        Timber.INSTANCE.e("resize Error", new Object[0]);
                        return Unit.INSTANCE;
                    }
                    SelectIconFragment.this.uploadImage(fileResizeImageWithGlide, uri);
                }
            }
            return Unit.INSTANCE;
        }
    }

    private final void setRecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        FragmentSelectIconBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView3 = binding.recyclerview) == null) ? null : recyclerView3.getLayoutManager()) instanceof GridLayoutManager)) {
            FragmentSelectIconBinding binding2 = getBinding();
            RecyclerView recyclerView4 = binding2 != null ? binding2.recyclerview : null;
            if (recyclerView4 != null) {
                recyclerView4.setLayoutManager(new GridLayoutManager(getMainActivity(), 3));
            }
        }
        FragmentSelectIconBinding binding3 = getBinding();
        RecyclerView recyclerView5 = binding3 != null ? binding3.recyclerview : null;
        if (recyclerView5 != null) {
            recyclerView5.setItemAnimator(null);
        }
        FragmentSelectIconBinding binding4 = getBinding();
        if (!(((binding4 == null || (recyclerView2 = binding4.recyclerview) == null) ? null : recyclerView2.getAdapter()) instanceof SelectIconAdapter)) {
            SelectIconAdapter selectIconAdapter = new SelectIconAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.settings.SelectIconFragment$setRecyclerView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    RecyclerView recyclerView6;
                    FragmentSelectIconBinding fragmentSelectIconBindingAccess$getBinding = SelectIconFragment.access$getBinding(this.this$0);
                    RecyclerView.Adapter adapter2 = (fragmentSelectIconBindingAccess$getBinding == null || (recyclerView6 = fragmentSelectIconBindingAccess$getBinding.recyclerview) == null) ? null : recyclerView6.getAdapter();
                    if (adapter2 instanceof SelectIconAdapter) {
                        SelectIconAdapter selectIconAdapter2 = (SelectIconAdapter) adapter2;
                        List<SelectIconData> currentList = selectIconAdapter2.getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        int size = currentList.size();
                        for (int i = 0; i < size; i++) {
                            SelectIconData selectIconData = currentList.get(i);
                            if (i == pos) {
                                selectIconData.setSelect(true);
                            } else {
                                selectIconData.setSelect(false);
                            }
                        }
                        selectIconAdapter2.notifyItemChangedAll();
                    }
                }
            });
            FragmentSelectIconBinding binding5 = getBinding();
            RecyclerView recyclerView6 = binding5 != null ? binding5.recyclerview : null;
            if (recyclerView6 != null) {
                recyclerView6.setAdapter(selectIconAdapter);
            }
        }
        ArrayList arrayList = new ArrayList();
        Context context = getContext();
        if (context != null) {
            List<Integer> drawableResources = getDrawableResources(context, "female_", new IntRange(1, 20));
            List<Integer> drawableResources2 = getDrawableResources(context, "male_", new IntRange(1, 20));
            Iterator<Integer> it = drawableResources.iterator();
            while (it.hasNext()) {
                arrayList.add(new SelectIconData(it.next().intValue(), false));
            }
            Iterator<Integer> it2 = drawableResources2.iterator();
            while (it2.hasNext()) {
                arrayList.add(new SelectIconData(it2.next().intValue(), false));
            }
        }
        FragmentSelectIconBinding binding6 = getBinding();
        if (binding6 != null && (recyclerView = binding6.recyclerview) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof SelectIconAdapter) {
            ((SelectIconAdapter) adapter).submitList(arrayList);
        }
    }

    public final List<Integer> getDrawableResources(Context context, String prefix, IntRange range) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(range, "range");
        ArrayList arrayList = new ArrayList();
        int first = range.getFirst();
        int last = range.getLast();
        if (first <= last) {
            while (true) {
                int identifier = context.getResources().getIdentifier(prefix + StringsKt.padStart(String.valueOf(first), 2, '0'), "drawable", context.getPackageName());
                if (identifier != 0) {
                    arrayList.add(Integer.valueOf(identifier));
                }
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        return arrayList;
    }

    /* compiled from: SelectIconFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SelectIconFragment$uploadImage$1", f = "SelectIconFragment.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SelectIconFragment$uploadImage$1, reason: invalid class name and case insensitive filesystem */
    static final class C10021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $image;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10021(File file, Continuation<? super C10021> continuation) {
            super(2, continuation);
            this.$image = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SelectIconFragment.this.new C10021(this.$image, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            SetCoverPhotoApiData.ResponseData responseData;
            String fileUrl;
            SetCoverPhotoApiData.ResponseData.DataMap.Data data;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SelectIconFragment.this.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callSetCoverPhoto(new SetCoverPhotoApiData.RequestBodyData(this.$image, null), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    responseData = (SetCoverPhotoApiData.ResponseData) ((Response) obj).body();
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(SelectIconFragment.this, "uploadImage", message, false, 4, null);
                    unit = Unit.INSTANCE;
                }
                if (responseData != null && responseData.getSuccess()) {
                    LoginUserData loginUserData = Global.userData;
                    if (loginUserData != null) {
                        SetCoverPhotoApiData.ResponseData.DataMap dataMap = responseData.getDataMap();
                        if (dataMap == null || (data = dataMap.getData()) == null || (fileUrl = data.getFileUrl()) == null) {
                            fileUrl = "";
                        }
                        loginUserData.setPhotoFileUrl(fileUrl);
                    }
                    SelectIconFragment.this.safeNavigateUp();
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (SelectIconFragment.this.shouldIgnoreError(errorCode)) {
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error))).get(errorCode);
                    if (num != null) {
                        SelectIconFragment selectIconFragment = SelectIconFragment.this;
                        CustomDialogKt.showCustomDialog$default(selectIconFragment, selectIconFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(SelectIconFragment.this, "uploadImage", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
                SelectIconFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                SelectIconFragment.this.stopLoading();
            }
        }
    }

    public final void uploadImage(File image, Uri uri) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(uri, "uri");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10021(image, null), 3, null);
    }
}
