package com.soletreadmills.sole_v2._extension;

import android.content.Context;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._manager.CustomDialogManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CustomDialog.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001ah\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"showCustomDialog", "", "Landroidx/fragment/app/Fragment;", "title", "", "message", "confirmText", "cancelText", "onConfirm", "Lkotlin/Function0;", "onCancel", "cancelable", "", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomDialogKt {
    public static /* synthetic */ void showCustomDialog$default(Fragment fragment, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, boolean z, int i, Object obj) {
        Context context;
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0 && ((context = fragment.getContext()) == null || (str3 = context.getString(R.string.confirm)) == null)) {
            str3 = "Confirm";
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            function0 = null;
        }
        if ((i & 32) != 0) {
            function02 = null;
        }
        if ((i & 64) != 0) {
            z = true;
        }
        showCustomDialog(fragment, str, str2, str3, str4, function0, function02, z);
    }

    public static final void showCustomDialog(final Fragment fragment, final String str, final String str2, final String str3, final String str4, final Function0<Unit> function0, final Function0<Unit> function02, final boolean z) {
        Object objM9087constructorimpl;
        FragmentManager fragmentManager;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            FragmentActivity activity = fragment.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2._extension.CustomDialogKt$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        CustomDialogKt.showCustomDialog$lambda$0(fragment, str, str2, str3, str4, function0, function02, z);
                    }
                });
                return;
            }
            return;
        }
        if (fragment.isAdded()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM9087constructorimpl = Result.m9087constructorimpl(fragment.getParentFragmentManager());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9093isFailureimpl(objM9087constructorimpl)) {
                objM9087constructorimpl = null;
            }
            FragmentManager fragmentManager2 = (FragmentManager) objM9087constructorimpl;
            if (fragmentManager2 == null) {
                FragmentActivity activity2 = fragment.getActivity();
                if (!(activity2 instanceof FragmentActivity)) {
                    activity2 = null;
                }
                FragmentManager supportFragmentManager = activity2 != null ? activity2.getSupportFragmentManager() : null;
                if (supportFragmentManager == null) {
                    return;
                } else {
                    fragmentManager = supportFragmentManager;
                }
            } else {
                fragmentManager = fragmentManager2;
            }
            if (fragmentManager.isStateSaved()) {
                return;
            }
            if (!fragment.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
                final FragmentManager fragmentManager3 = fragmentManager;
                fragment.getViewLifecycleOwnerLiveData().observe(fragment, new CustomDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<LifecycleOwner, Unit>() { // from class: com.soletreadmills.sole_v2._extension.CustomDialogKt.showCustomDialog.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LifecycleOwner lifecycleOwner) {
                        invoke2(lifecycleOwner);
                        return Unit.INSTANCE;
                    }

                    /* compiled from: CustomDialog.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.soletreadmills.sole_v2._extension.CustomDialogKt$showCustomDialog$2$1", f = "CustomDialog.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.soletreadmills.sole_v2._extension.CustomDialogKt$showCustomDialog$2$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ String $cancelText;
                        final /* synthetic */ boolean $cancelable;
                        final /* synthetic */ String $confirmText;
                        final /* synthetic */ FragmentManager $fm;
                        final /* synthetic */ String $message;
                        final /* synthetic */ Function0<Unit> $onCancel;
                        final /* synthetic */ Function0<Unit> $onConfirm;
                        final /* synthetic */ LifecycleOwner $owner;
                        final /* synthetic */ Fragment $this_showCustomDialog;
                        final /* synthetic */ String $title;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(LifecycleOwner lifecycleOwner, Fragment fragment, FragmentManager fragmentManager, String str, String str2, String str3, String str4, Function0<Unit> function0, Function0<Unit> function02, boolean z, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$owner = lifecycleOwner;
                            this.$this_showCustomDialog = fragment;
                            this.$fm = fragmentManager;
                            this.$title = str;
                            this.$message = str2;
                            this.$confirmText = str3;
                            this.$cancelText = str4;
                            this.$onConfirm = function0;
                            this.$onCancel = function02;
                            this.$cancelable = z;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$owner, this.$this_showCustomDialog, this.$fm, this.$title, this.$message, this.$confirmText, this.$cancelText, this.$onConfirm, this.$onCancel, this.$cancelable, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* compiled from: CustomDialog.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.soletreadmills.sole_v2._extension.CustomDialogKt$showCustomDialog$2$1$1", f = "CustomDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.soletreadmills.sole_v2._extension.CustomDialogKt$showCustomDialog$2$1$1, reason: invalid class name and collision with other inner class name */
                        static final class C02041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ String $cancelText;
                            final /* synthetic */ boolean $cancelable;
                            final /* synthetic */ String $confirmText;
                            final /* synthetic */ FragmentManager $fm;
                            final /* synthetic */ String $message;
                            final /* synthetic */ Function0<Unit> $onCancel;
                            final /* synthetic */ Function0<Unit> $onConfirm;
                            final /* synthetic */ Fragment $this_showCustomDialog;
                            final /* synthetic */ String $title;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C02041(Fragment fragment, FragmentManager fragmentManager, String str, String str2, String str3, String str4, Function0<Unit> function0, Function0<Unit> function02, boolean z, Continuation<? super C02041> continuation) {
                                super(2, continuation);
                                this.$this_showCustomDialog = fragment;
                                this.$fm = fragmentManager;
                                this.$title = str;
                                this.$message = str2;
                                this.$confirmText = str3;
                                this.$cancelText = str4;
                                this.$onConfirm = function0;
                                this.$onCancel = function02;
                                this.$cancelable = z;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C02041(this.$this_showCustomDialog, this.$fm, this.$title, this.$message, this.$confirmText, this.$cancelText, this.$onConfirm, this.$onCancel, this.$cancelable, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C02041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label != 0) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                if (!this.$this_showCustomDialog.isAdded() || this.$fm.isStateSaved()) {
                                    return Unit.INSTANCE;
                                }
                                CustomDialogManager.INSTANCE.show(this.$fm, this.$title, this.$message, this.$confirmText, this.$cancelText, this.$onConfirm, this.$onCancel, this.$cancelable);
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (RepeatOnLifecycleKt.repeatOnLifecycle(this.$owner.getLifecycle(), Lifecycle.State.STARTED, new C02041(this.$this_showCustomDialog, this.$fm, this.$title, this.$message, this.$confirmText, this.$cancelText, this.$onConfirm, this.$onCancel, this.$cancelable, null), this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LifecycleOwner lifecycleOwner) {
                        if (lifecycleOwner == null) {
                            return;
                        }
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new AnonymousClass1(lifecycleOwner, fragment, fragmentManager3, str, str2, str3, str4, function0, function02, z, null), 3, null);
                    }
                }));
            } else {
                CustomDialogManager.INSTANCE.show(fragmentManager, str, str2, str3, str4, function0, function02, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCustomDialog$lambda$0(Fragment this_showCustomDialog, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, boolean z) {
        Intrinsics.checkNotNullParameter(this_showCustomDialog, "$this_showCustomDialog");
        showCustomDialog(this_showCustomDialog, str, str2, str3, str4, function0, function02, z);
    }
}
