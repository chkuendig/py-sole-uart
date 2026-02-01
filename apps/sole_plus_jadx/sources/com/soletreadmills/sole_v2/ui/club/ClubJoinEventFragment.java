package com.soletreadmills.sole_v2.ui.club;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.club.JoinChallengeApiData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentClubJoinEventBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbConst;
import java.io.IOException;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ClubJoinEventFragment.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001*B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\u0014\u0010\u001f\u001a\u00020\u00122\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0012H\u0002J\b\u0010)\u001a\u00020\u0012H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082.¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubJoinEventFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentClubJoinEventBinding;", "Landroid/view/View$OnClickListener;", "()V", "clubViewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "getClubViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "clubViewModel$delegate", "Lkotlin/Lazy;", "etDigits", "", "Landroid/widget/EditText;", "[Landroid/widget/EditText;", "isLoading", "", "clearInput", "", "deleteDigit", "getEventId", "", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initOtpInput", "initViews", "inputDigit", "digit", "joinChallengeByCode", "passCode", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "setupCustomKeyboard", "submitEventId", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubJoinEventFragment extends BaseFragment<FragmentClubJoinEventBinding> implements View.OnClickListener {

    /* renamed from: clubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy clubViewModel;
    private EditText[] etDigits;
    private boolean isLoading;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public ClubJoinEventFragment() {
        final ClubJoinEventFragment clubJoinEventFragment = this;
        final Function0 function0 = null;
        this.clubViewModel = FragmentViewModelLazyKt.createViewModelLazy(clubJoinEventFragment, Reflection.getOrCreateKotlinClass(ClubViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubJoinEventFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = clubJoinEventFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubJoinEventFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* compiled from: ClubJoinEventFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubJoinEventFragment$Companion;", "", "()V", "newInstance", "Lcom/soletreadmills/sole_v2/ui/club/ClubJoinEventFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClubJoinEventFragment newInstance() {
            return new ClubJoinEventFragment();
        }
    }

    public final ClubViewModel getClubViewModel() {
        return (ClubViewModel) this.clubViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentClubJoinEventBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClubJoinEventBinding fragmentClubJoinEventBindingInflate = FragmentClubJoinEventBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentClubJoinEventBindingInflate, "inflate(...)");
        return fragmentClubJoinEventBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        TextView textView;
        FragmentClubJoinEventBinding binding = getBinding();
        if (binding != null && (textView = binding.tvCancel) != null) {
            textView.setOnClickListener(this);
        }
        initOtpInput();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.tv_cancel;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
        }
    }

    private final void initOtpInput() {
        if (getBinding() != null) {
            FragmentClubJoinEventBinding binding = getBinding();
            if (binding != null) {
                EditText etDigit1 = binding.etDigit1;
                Intrinsics.checkNotNullExpressionValue(etDigit1, "etDigit1");
                EditText etDigit2 = binding.etDigit2;
                Intrinsics.checkNotNullExpressionValue(etDigit2, "etDigit2");
                EditText etDigit3 = binding.etDigit3;
                Intrinsics.checkNotNullExpressionValue(etDigit3, "etDigit3");
                EditText etDigit4 = binding.etDigit4;
                Intrinsics.checkNotNullExpressionValue(etDigit4, "etDigit4");
                EditText etDigit5 = binding.etDigit5;
                Intrinsics.checkNotNullExpressionValue(etDigit5, "etDigit5");
                EditText etDigit6 = binding.etDigit6;
                Intrinsics.checkNotNullExpressionValue(etDigit6, "etDigit6");
                this.etDigits = new EditText[]{etDigit1, etDigit2, etDigit3, etDigit4, etDigit5, etDigit6};
            }
            EditText[] editTextArr = this.etDigits;
            EditText[] editTextArr2 = null;
            if (editTextArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                editTextArr = null;
            }
            int length = editTextArr.length;
            int i = 0;
            final int i2 = 0;
            while (i < length) {
                final EditText editText = editTextArr[i];
                editText.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$initOtpInput$2$1
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        String strValueOf = String.valueOf(s);
                        EditText[] editTextArr3 = null;
                        if (strValueOf.length() > 0) {
                            editText.setBackground(null);
                        } else {
                            editText.setBackgroundResource(R.drawable.ic_field_digit);
                        }
                        if (strValueOf.length() == 1) {
                            int i3 = i2;
                            EditText[] editTextArr4 = this.etDigits;
                            if (editTextArr4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                                editTextArr4 = null;
                            }
                            if (i3 < editTextArr4.length - 1) {
                                EditText[] editTextArr5 = this.etDigits;
                                if (editTextArr5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                                } else {
                                    editTextArr3 = editTextArr5;
                                }
                                editTextArr3[i2 + 1].requestFocus();
                                return;
                            }
                            this.submitEventId();
                        }
                    }
                });
                editText.setOnKeyListener(new View.OnKeyListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnKeyListener
                    public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                        return ClubJoinEventFragment.initOtpInput$lambda$4$lambda$1(editText, i2, this, view, i3, keyEvent);
                    }
                });
                editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        ClubJoinEventFragment.initOtpInput$lambda$4$lambda$2(editText, view, z);
                    }
                });
                editText.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClubJoinEventFragment.initOtpInput$lambda$4$lambda$3(editText, view);
                    }
                });
                i++;
                i2++;
            }
            EditText[] editTextArr3 = this.etDigits;
            if (editTextArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            } else {
                editTextArr2 = editTextArr3;
            }
            editTextArr2[0].requestFocus();
            setupCustomKeyboard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initOtpInput$lambda$4$lambda$1(EditText editText, int i, ClubJoinEventFragment this$0, View view, int i2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i2 != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        Editable text = editText.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (text.length() != 0 || i <= 0) {
            return false;
        }
        EditText[] editTextArr = this$0.etDigits;
        EditText[] editTextArr2 = null;
        if (editTextArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            editTextArr = null;
        }
        int i3 = i - 1;
        editTextArr[i3].requestFocus();
        EditText[] editTextArr3 = this$0.etDigits;
        if (editTextArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
        } else {
            editTextArr2 = editTextArr3;
        }
        editTextArr2[i3].setText("");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOtpInput$lambda$4$lambda$2(EditText editText, View view, boolean z) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        if (z) {
            editText.setSelection(editText.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOtpInput$lambda$4$lambda$3(EditText editText, View view) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setSelection(editText.getText().length());
    }

    private final void setupCustomKeyboard() {
        LinearLayout linearLayout;
        Button button;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        Button button6;
        Button button7;
        Button button8;
        Button button9;
        Button button10;
        FragmentClubJoinEventBinding binding = getBinding();
        if (binding != null && (button10 = binding.btn1) != null) {
            button10.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubJoinEventFragment.setupCustomKeyboard$lambda$5(this.f$0, view);
                }
            });
        }
        FragmentClubJoinEventBinding binding2 = getBinding();
        if (binding2 != null && (button9 = binding2.btn2) != null) {
            button9.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubJoinEventFragment.setupCustomKeyboard$lambda$6(this.f$0, view);
                }
            });
        }
        FragmentClubJoinEventBinding binding3 = getBinding();
        if (binding3 != null && (button8 = binding3.btn3) != null) {
            button8.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubJoinEventFragment.setupCustomKeyboard$lambda$7(this.f$0, view);
                }
            });
        }
        FragmentClubJoinEventBinding binding4 = getBinding();
        if (binding4 != null && (button7 = binding4.btn4) != null) {
            button7.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubJoinEventFragment.setupCustomKeyboard$lambda$8(this.f$0, view);
                }
            });
        }
        FragmentClubJoinEventBinding binding5 = getBinding();
        if (binding5 != null && (button6 = binding5.btn5) != null) {
            button6.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubJoinEventFragment.setupCustomKeyboard$lambda$9(this.f$0, view);
                }
            });
        }
        FragmentClubJoinEventBinding binding6 = getBinding();
        if (binding6 != null && (button5 = binding6.btn6) != null) {
            button5.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubJoinEventFragment.setupCustomKeyboard$lambda$10(this.f$0, view);
                }
            });
        }
        FragmentClubJoinEventBinding binding7 = getBinding();
        if (binding7 != null && (button4 = binding7.btn7) != null) {
            button4.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubJoinEventFragment.setupCustomKeyboard$lambda$11(this.f$0, view);
                }
            });
        }
        FragmentClubJoinEventBinding binding8 = getBinding();
        if (binding8 != null && (button3 = binding8.btn8) != null) {
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubJoinEventFragment.setupCustomKeyboard$lambda$12(this.f$0, view);
                }
            });
        }
        FragmentClubJoinEventBinding binding9 = getBinding();
        if (binding9 != null && (button2 = binding9.btn9) != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubJoinEventFragment.setupCustomKeyboard$lambda$13(this.f$0, view);
                }
            });
        }
        FragmentClubJoinEventBinding binding10 = getBinding();
        if (binding10 != null && (button = binding10.btn0) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubJoinEventFragment.setupCustomKeyboard$lambda$14(this.f$0, view);
                }
            });
        }
        FragmentClubJoinEventBinding binding11 = getBinding();
        if (binding11 == null || (linearLayout = binding11.btnDelete) == null) {
            return;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClubJoinEventFragment.setupCustomKeyboard$lambda$15(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$5(ClubJoinEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$6(ClubJoinEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$7(ClubJoinEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit(ExifInterface.GPS_MEASUREMENT_3D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$8(ClubJoinEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit(TlbConst.TYPELIB_MINOR_VERSION_WORD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$9(ClubJoinEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit(TlbConst.TYPELIB_MINOR_VERSION_OFFICE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$10(ClubJoinEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("6");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$11(ClubJoinEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("7");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$12(ClubJoinEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit(TlbConst.TYPELIB_MAJOR_VERSION_WORD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$13(ClubJoinEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("9");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$14(ClubJoinEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$15(ClubJoinEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.deleteDigit();
    }

    private final void inputDigit(String digit) {
        EditText[] editTextArr = this.etDigits;
        EditText[] editTextArr2 = null;
        if (editTextArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            editTextArr = null;
        }
        int length = editTextArr.length;
        for (int i = 0; i < length; i++) {
            EditText[] editTextArr3 = this.etDigits;
            if (editTextArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                editTextArr3 = null;
            }
            if (editTextArr3[i].getText().toString().length() == 0) {
                EditText[] editTextArr4 = this.etDigits;
                if (editTextArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                    editTextArr4 = null;
                }
                editTextArr4[i].setText(digit);
                EditText[] editTextArr5 = this.etDigits;
                if (editTextArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                } else {
                    editTextArr2 = editTextArr5;
                }
                if (i == editTextArr2.length - 1) {
                    submitEventId();
                    return;
                }
                return;
            }
        }
    }

    private final void deleteDigit() {
        EditText[] editTextArr = this.etDigits;
        EditText[] editTextArr2 = null;
        if (editTextArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            editTextArr = null;
        }
        int length = editTextArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            EditText[] editTextArr3 = this.etDigits;
            if (editTextArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                editTextArr3 = null;
            }
            if (editTextArr3[length].getText().toString().length() > 0) {
                EditText[] editTextArr4 = this.etDigits;
                if (editTextArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                } else {
                    editTextArr2 = editTextArr4;
                }
                editTextArr2[length].setText("");
                return;
            }
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void submitEventId() {
        String eventId = getEventId();
        if (eventId.length() == 6) {
            hideKeyboard();
            if (this.isLoading) {
                return;
            }
            joinChallengeByCode(eventId);
        }
    }

    private final String getEventId() {
        EditText[] editTextArr = this.etDigits;
        if (editTextArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            editTextArr = null;
        }
        return ArraysKt.joinToString$default(editTextArr, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<EditText, CharSequence>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment.getEventId.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(EditText it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getText().toString();
            }
        }, 30, (Object) null);
    }

    private final void clearInput() {
        EditText[] editTextArr = this.etDigits;
        EditText[] editTextArr2 = null;
        if (editTextArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            editTextArr = null;
        }
        for (EditText editText : editTextArr) {
            editText.setText("");
        }
        EditText[] editTextArr3 = this.etDigits;
        if (editTextArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
        } else {
            editTextArr2 = editTextArr3;
        }
        editTextArr2[0].requestFocus();
    }

    static /* synthetic */ void joinChallengeByCode$default(ClubJoinEventFragment clubJoinEventFragment, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        clubJoinEventFragment.joinChallengeByCode(str);
    }

    private final void joinChallengeByCode(String passCode) {
        Timber.INSTANCE.d("joinChallengeByCode", new Object[0]);
        this.isLoading = true;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09281(passCode, null), 3, null);
    }

    /* compiled from: ClubJoinEventFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$joinChallengeByCode$1", f = "ClubJoinEventFragment.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$joinChallengeByCode$1, reason: invalid class name and case insensitive filesystem */
    static final class C09281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $passCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09281(String str, Continuation<? super C09281> continuation) {
            super(2, continuation);
            this.$passCode = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubJoinEventFragment.this.new C09281(this.$passCode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallJoinChallenge;
            JoinChallengeApiData.DataMap sysResponseData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubJoinEventFragment.this.showLoading();
                        this.label = 1;
                        objCallJoinChallenge = DyacoApiKt.callJoinChallenge(new JoinChallengeApiData.RequestBodyData(null, this.$passCode, 1, null), this);
                        if (objCallJoinChallenge == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallJoinChallenge = obj;
                    }
                    Response response = (Response) objCallJoinChallenge;
                    Timber.INSTANCE.d("callGetPublicChallengesToJoin: " + response, new Object[0]);
                    JoinChallengeApiData.ResponseData responseData = (JoinChallengeApiData.ResponseData) response.body();
                    final String challengeUuid = (responseData == null || (sysResponseData = responseData.getSysResponseData()) == null) ? null : sysResponseData.getChallengeUuid();
                    Timber.INSTANCE.d("dataJoin res:" + challengeUuid, new Object[0]);
                    JoinChallengeApiData.ResponseData responseData2 = (JoinChallengeApiData.ResponseData) response.body();
                    String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                    JoinChallengeApiData.ResponseData responseData3 = (JoinChallengeApiData.ResponseData) response.body();
                    if (responseData3 != null && responseData3.getSuccess() && challengeUuid != null) {
                        Timber.INSTANCE.d("加入成功", new Object[0]);
                        ClubJoinEventFragment clubJoinEventFragment = ClubJoinEventFragment.this;
                        String string = clubJoinEventFragment.getString(R.string.join_by_code_title);
                        String string2 = ClubJoinEventFragment.this.getString(R.string.join_by_code_desc);
                        String string3 = ClubJoinEventFragment.this.getString(R.string.confirm);
                        final ClubJoinEventFragment clubJoinEventFragment2 = ClubJoinEventFragment.this;
                        CustomDialogKt.showCustomDialog$default(clubJoinEventFragment, string, string2, string3, null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment.joinChallengeByCode.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                clubJoinEventFragment2.getClubViewModel().setSelectChallengeId(challengeUuid);
                                BaseFragment.safeNavigateWithPopUp$default(clubJoinEventFragment2, R.id.clubEventDetailFragment, R.id.clubMainFragment, false, null, 8, null);
                            }
                        }, null, false, 104, null);
                    } else {
                        JoinChallengeApiData.ResponseData responseData4 = (JoinChallengeApiData.ResponseData) response.body();
                        if (Intrinsics.areEqual(responseData4 != null ? responseData4.getErrorCode() : null, ErrorCode.CHALLENGE_ALREADY_MEMBER_4003.getId())) {
                            if (challengeUuid != null) {
                                Timber.INSTANCE.d("已加入過", new Object[0]);
                                ClubJoinEventFragment.this.getClubViewModel().setSelectChallengeId(challengeUuid);
                                BaseFragment.safeNavigateWithPopUp$default(ClubJoinEventFragment.this, R.id.clubEventDetailFragment, R.id.clubMainFragment, false, null, 8, null);
                            }
                        } else {
                            if (ClubJoinEventFragment.this.shouldIgnoreError(errorCode)) {
                                return Unit.INSTANCE;
                            }
                            Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.INVALID_OPERATION_ON_TARGET_OBJ_STATUS_1045.getId(), Boxing.boxInt(R.string.invalid_operation_on_target_obj_status)), TuplesKt.to(ErrorCode.CHALLENGE_PASSCODE_REQUIRED_4002.getId(), Boxing.boxInt(R.string.challenge_passcode_required)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_EXIST_4000.getId(), Boxing.boxInt(R.string.challenge_pass_code_not_exist)), TuplesKt.to(ErrorCode.USER_NOT_FOUND_1003.getId(), Boxing.boxInt(R.string.user_not_found)));
                            JoinChallengeApiData.ResponseData responseData5 = (JoinChallengeApiData.ResponseData) response.body();
                            Integer num = (Integer) mapMapOf.get(responseData5 != null ? responseData5.getErrorCode() : null);
                            if (num != null) {
                                LifecycleOwner viewLifecycleOwner = ClubJoinEventFragment.this.getViewLifecycleOwner();
                                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass2(ClubJoinEventFragment.this, num, null), 3, null);
                            } else {
                                ClubJoinEventFragment clubJoinEventFragment3 = ClubJoinEventFragment.this;
                                JoinChallengeApiData.ResponseData responseData6 = (JoinChallengeApiData.ResponseData) response.body();
                                BaseFragment.handleUndefinedError$default(clubJoinEventFragment3, "joinChallengeByCode", errorCode, responseData6 != null ? responseData6.getErrorMessage() : null, false, 8, null);
                            }
                        }
                    }
                    ClubJoinEventFragment.this.isLoading = false;
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubJoinEventFragment.this, "joinChallengeByCode", message, false, 4, null);
                    ClubJoinEventFragment.this.isLoading = false;
                }
                ClubJoinEventFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubJoinEventFragment.this.stopLoading();
            }
        }

        /* compiled from: ClubJoinEventFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$joinChallengeByCode$1$2", f = "ClubJoinEventFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubJoinEventFragment$joinChallengeByCode$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Integer $msgResId;
            int label;
            final /* synthetic */ ClubJoinEventFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(ClubJoinEventFragment clubJoinEventFragment, Integer num, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = clubJoinEventFragment;
                this.$msgResId = num;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$msgResId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ClubJoinEventFragment clubJoinEventFragment = this.this$0;
                CustomDialogKt.showCustomDialog$default(clubJoinEventFragment, null, clubJoinEventFragment.getString(this.$msgResId.intValue()), this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
                return Unit.INSTANCE;
            }
        }
    }
}
