package com.soletreadmills.sole_v2.ui.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.FileProvider;
import androidx.lifecycle.LifecycleOwnerKt;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.settings.SetCoverPhotoApiData;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._tools.ConvertUtils;
import com.soletreadmills.sole_v2._tools.FileTool;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._type.user.GenderType;
import com.soletreadmills.sole_v2.databinding.FragmentSettingProfileBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._dialog.IosAlertActionSheetDialog;
import com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: SettingProfileFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bJ\b\u0010!\u001a\u00020\u001bH\u0007J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0016\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u000eR(\u0010\u0005\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b \t*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/SettingProfileFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentSettingProfileBinding;", "Landroid/view/View$OnClickListener;", "()V", "checkPermissionCameraActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "currentPhotoPath", "iosAlertActionSheetDialog", "Lcom/soletreadmills/sole_v2/ui/_dialog/IosAlertActionSheetDialog;", "photoUri", "Landroid/net/Uri;", "pickMedia", "Landroidx/activity/result/PickVisualMediaRequest;", "takePictureLauncher", "Landroid/content/Intent;", "createImageFile", "Ljava/io/File;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "openCamera", "openPhotoPicker", "setView", "updateAvatarIconByCustomImage", "uri", "uploadImage", "image", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingProfileFragment extends BaseFragment<FragmentSettingProfileBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private final ActivityResultLauncher<String[]> checkPermissionCameraActivityResultLauncher;
    private String currentPhotoPath;
    private IosAlertActionSheetDialog iosAlertActionSheetDialog;
    private Uri photoUri;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMedia;
    private ActivityResultLauncher<Intent> takePictureLauncher;

    public SettingProfileFragment() {
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws IOException {
                SettingProfileFragment.checkPermissionCameraActivityResultLauncher$lambda$11(this.f$0, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.checkPermissionCameraActivityResultLauncher = activityResultLauncherRegisterForActivityResult;
    }

    public static final /* synthetic */ FragmentSettingProfileBinding access$getBinding(SettingProfileFragment settingProfileFragment) {
        return settingProfileFragment.getBinding();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentSettingProfileBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentSettingProfileBinding fragmentSettingProfileBindingInflate = FragmentSettingProfileBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentSettingProfileBindingInflate, "inflate(...)");
        return fragmentSettingProfileBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ImageView imageView;
        FragmentSettingProfileBinding binding = getBinding();
        if (binding != null && (imageView = binding.back) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentSettingProfileBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout2 = binding2.LLEditProfile) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentSettingProfileBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout = binding3.LLEdit) != null) {
            linearLayout.setOnClickListener(this);
        }
        ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws FileNotFoundException {
                SettingProfileFragment.initViews$lambda$0(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.pickMedia = activityResultLauncherRegisterForActivityResult;
        this.takePictureLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment$$ExternalSyntheticLambda3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SettingProfileFragment.initViews$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
        setView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(SettingProfileFragment this$0, Uri uri) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (uri != null) {
            Timber.INSTANCE.d("PhotoPickerURI: " + uri, new Object[0]);
            this$0.updateAvatarIconByCustomImage(uri);
        } else {
            Timber.INSTANCE.d("PhotoPicker No media selected", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(SettingProfileFragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Timber.INSTANCE.d("result:" + result, new Object[0]);
            Timber.INSTANCE.d("imageData:" + result.getData(), new Object[0]);
            if (this$0.photoUri != null) {
                Timber.INSTANCE.d("photoUri:" + this$0.photoUri, new Object[0]);
                try {
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getDefault(), null, new SettingProfileFragment$initViews$2$1(this$0, null), 2, null);
                    return;
                } catch (Exception e) {
                    Timber.INSTANCE.e("processImage err----: " + e, new Object[0]);
                    Timber.INSTANCE.d("Stack: " + Log.getStackTraceString(new Throwable()), new Object[0]);
                    return;
                }
            }
            Toast.makeText(this$0.requireContext(), "Can't get image URI", 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.LL_edit;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            Context context = getContext();
            if (context != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(getString(R.string.camera));
                arrayList.add(getString(R.string.library));
                arrayList.add(getString(R.string.sole_icons));
                IosAlertActionSheetDialog iosAlertActionSheetDialog = new IosAlertActionSheetDialog(context, arrayList);
                this.iosAlertActionSheetDialog = iosAlertActionSheetDialog;
                iosAlertActionSheetDialog.setListener(new IosAlertActionSheetDialog.Listener() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment$onClick$1$1
                    @Override // com.soletreadmills.sole_v2.ui._dialog.IosAlertActionSheetDialog.Listener
                    public void onItemClick(int position, String item) {
                        String[] strArr;
                        Intrinsics.checkNotNullParameter(item, "item");
                        if (position == 0) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                strArr = new String[]{"android.permission.CAMERA"};
                            } else {
                                strArr = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
                            }
                            this.this$0.checkPermissionCameraActivityResultLauncher.launch(strArr);
                            return;
                        }
                        if (position == 1) {
                            this.this$0.openPhotoPicker();
                        } else {
                            if (position != 2) {
                                return;
                            }
                            BaseFragment.safeNavigate$default(this.this$0, R.id.selectIconFragment, null, 2, null);
                        }
                    }
                });
                IosAlertActionSheetDialog iosAlertActionSheetDialog2 = this.iosAlertActionSheetDialog;
                if (iosAlertActionSheetDialog2 != null) {
                    iosAlertActionSheetDialog2.show();
                    return;
                }
                return;
            }
            return;
        }
        int i3 = R.id.LL_editProfile;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            BaseFragment.safeNavigate$default(this, R.id.editProfileFragment, null, 2, null);
        }
    }

    public final void setView() {
        Context context;
        ImageView imageView;
        String loginAccountNo;
        Object objM9087constructorimpl;
        Object objM9087constructorimpl2;
        String string;
        LoginUserData loginUserData = Global.userData;
        if (loginUserData == null || (context = getContext()) == null) {
            return;
        }
        try {
            FragmentSettingProfileBinding binding = getBinding();
            if (binding != null) {
                Glide.with(context).load(loginUserData.getPhotoFileUrl()).into(binding.imgHead);
            }
        } catch (Exception e) {
            FragmentSettingProfileBinding binding2 = getBinding();
            if (binding2 != null && (imageView = binding2.imgHead) != null) {
                imageView.setImageResource(R.drawable.ic_user);
            }
            Timber.INSTANCE.e(e);
        }
        String sharedBaseUrl = MySharedPreferences.INSTANCE.getInstance().getSharedBaseUrl();
        if (sharedBaseUrl != null && StringsKt.contains$default((CharSequence) sharedBaseUrl, (CharSequence) "-us", false, 2, (Object) null)) {
            loginAccountNo = Global.getLoginAccountNo() + ".us";
        } else {
            loginAccountNo = Global.getLoginAccountNo();
        }
        FragmentSettingProfileBinding binding3 = getBinding();
        TextView textView = binding3 != null ? binding3.globalUserUuid : null;
        if (textView != null) {
            textView.setText(loginAccountNo);
        }
        FragmentSettingProfileBinding binding4 = getBinding();
        TextView textView2 = binding4 != null ? binding4.name : null;
        if (textView2 != null) {
            textView2.setText(loginUserData.getDisplayName());
        }
        FragmentSettingProfileBinding binding5 = getBinding();
        TextView textView3 = binding5 != null ? binding5.birthday : null;
        if (textView3 != null) {
            textView3.setText(TimeTools.INSTANCE.formatToTime05(loginUserData.getBirthDate()));
        }
        String strCalculateAge = Global.INSTANCE.calculateAge();
        FragmentSettingProfileBinding binding6 = getBinding();
        TextView textView4 = binding6 != null ? binding6.years : null;
        if (textView4 != null) {
            textView4.setText(getString(R.string.years_old, strCalculateAge));
        }
        GenderType sex = Global.INSTANCE.getSex();
        FragmentSettingProfileBinding binding7 = getBinding();
        TextView textView5 = binding7 != null ? binding7.gender : null;
        if (textView5 != null) {
            if (sex == GenderType.Male) {
                string = getString(R.string.male);
            } else {
                string = getString(R.string.female);
            }
            textView5.setText(string);
        }
        if (Global.INSTANCE.getUnitType()) {
            String ft = UnitConversion.INSTANCE.getFt(loginUserData.getHeight());
            String heightIn = UnitConversion.INSTANCE.getHeightIn(loginUserData.getHeight());
            try {
                Result.Companion companion = Result.INSTANCE;
                SettingProfileFragment settingProfileFragment = this;
                objM9087constructorimpl = Result.m9087constructorimpl(Float.valueOf(Float.parseFloat(ft)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9090exceptionOrNullimpl(objM9087constructorimpl) != null) {
                objM9087constructorimpl = Float.valueOf(0.0f);
            }
            float fFloatValue = ((Number) objM9087constructorimpl).floatValue();
            try {
                Result.Companion companion3 = Result.INSTANCE;
                SettingProfileFragment settingProfileFragment2 = this;
                objM9087constructorimpl2 = Result.m9087constructorimpl(Float.valueOf(Float.parseFloat(heightIn)));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM9087constructorimpl2 = Result.m9087constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m9090exceptionOrNullimpl(objM9087constructorimpl2) != null) {
                objM9087constructorimpl2 = Float.valueOf(0.0f);
            }
            float fFloatValue2 = ((Number) objM9087constructorimpl2).floatValue();
            DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US);
            DecimalFormat decimalFormat = new DecimalFormat("#0", decimalFormatSymbols);
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            DecimalFormat decimalFormat2 = new DecimalFormat("#0", decimalFormatSymbols);
            decimalFormat2.setRoundingMode(RoundingMode.DOWN);
            FragmentSettingProfileBinding binding8 = getBinding();
            TextView textView6 = binding8 != null ? binding8.height : null;
            if (textView6 != null) {
                textView6.setText(decimalFormat2.format(Float.valueOf(fFloatValue)) + "' " + decimalFormat.format(Float.valueOf(fFloatValue2)) + '\"');
            }
            String toOneDecimal$default = ConvertUtils.formatToOneDecimal$default(ConvertUtils.INSTANCE, UnitConversion.INSTANCE.getLb(loginUserData.getWeight()), null, 2, null);
            FragmentSettingProfileBinding binding9 = getBinding();
            TextView textView7 = binding9 != null ? binding9.weight : null;
            if (textView7 == null) {
                return;
            }
            textView7.setText(toOneDecimal$default + ' ' + getString(R.string.lb));
            return;
        }
        FragmentSettingProfileBinding binding10 = getBinding();
        TextView textView8 = binding10 != null ? binding10.height : null;
        if (textView8 != null) {
            textView8.setText(loginUserData.getHeight() + ' ' + getString(R.string.cm));
        }
        FragmentSettingProfileBinding binding11 = getBinding();
        TextView textView9 = binding11 != null ? binding11.weight : null;
        if (textView9 == null) {
            return;
        }
        textView9.setText(ConvertUtils.formatToOneDecimal$default(ConvertUtils.INSTANCE, loginUserData.getWeight(), null, 2, null) + ' ' + getString(R.string.kg));
    }

    private final void updateAvatarIconByCustomImage(Uri uri) throws FileNotFoundException {
        FileTool fileTool = FileTool.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        File fileUriToFile = fileTool.uriToFile(contextRequireContext, uri);
        Timber.INSTANCE.d("imageFile: " + fileUriToFile, new Object[0]);
        if (fileUriToFile == null) {
            Timber.INSTANCE.e("imageFileNotExist", new Object[0]);
            return;
        }
        Timber.INSTANCE.d("imageFile-exists: " + fileUriToFile.exists(), new Object[0]);
        String path = fileUriToFile.getPath();
        if (fileUriToFile.exists()) {
            try {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getDefault(), null, new AnonymousClass1(path, this, uri, null), 2, null);
            } catch (Exception e) {
                Timber.INSTANCE.e("processImage err----: " + e, new Object[0]);
                Timber.INSTANCE.d("Stack: " + Log.getStackTraceString(new Throwable()), new Object[0]);
            }
        }
    }

    /* compiled from: SettingProfileFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment$updateAvatarIconByCustomImage$1", f = "SettingProfileFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment$updateAvatarIconByCustomImage$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ SettingProfileFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, SettingProfileFragment settingProfileFragment, Uri uri, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$path = str;
            this.this$0 = settingProfileFragment;
            this.$uri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$path, this.this$0, this.$uri, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!new File(this.$path).exists()) {
                Timber.INSTANCE.e("File does not exist at path: " + this.$path, new Object[0]);
                return Unit.INSTANCE;
            }
            Timber.INSTANCE.d("path: " + this.$path, new Object[0]);
            FileTool fileTool = FileTool.INSTANCE;
            Context contextRequireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            File fileResizeImageWithGlide = fileTool.resizeImageWithGlide(contextRequireContext, this.$uri, 500, 500);
            Timber.INSTANCE.d("resizeImage-----" + fileResizeImageWithGlide, new Object[0]);
            if (fileResizeImageWithGlide == null) {
                Timber.INSTANCE.e("resize Error", new Object[0]);
                return Unit.INSTANCE;
            }
            this.this$0.uploadImage(fileResizeImageWithGlide, this.$uri);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkPermissionCameraActivityResultLauncher$lambda$11(final SettingProfileFragment this$0, Map result) throws IOException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.containsValue(false)) {
            MainActivity mainActivity = this$0.getMainActivity();
            if (mainActivity != null) {
                BaseActivity.showBaseDialog$default(mainActivity, this$0.getString(R.string.camera_authorised), null, this$0.getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SettingProfileFragment.checkPermissionCameraActivityResultLauncher$lambda$11$lambda$10(this.f$0, dialogInterface, i);
                    }
                }, this$0.getString(R.string.cancel), null, null, null, null, null, null, 1984, null);
                return;
            }
            return;
        }
        this$0.openCamera();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkPermissionCameraActivityResultLauncher$lambda$11$lambda$10(SettingProfileFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        MainActivity mainActivity = this$0.getMainActivity();
        Intrinsics.checkNotNull(mainActivity);
        intent.setData(Uri.fromParts("package", mainActivity.getPackageName(), null));
        this$0.startActivity(intent);
    }

    public final void openCamera() throws IOException {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File fileCreateImageFile = createImageFile();
        Context context = getContext();
        String packageName = context != null ? context.getPackageName() : null;
        if (packageName == null) {
            return;
        }
        Uri uriForFile = FileProvider.getUriForFile(requireContext(), packageName + ".fileprovider", fileCreateImageFile);
        this.photoUri = uriForFile;
        intent.putExtra("output", uriForFile);
        ActivityResultLauncher<Intent> activityResultLauncher = this.takePictureLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
    }

    private final File createImageFile() throws IOException {
        String str = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        File fileCreateTempFile = File.createTempFile("JPEG_" + str + '_', SdkConstants.DOT_JPG, requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        String absolutePath = fileCreateTempFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        this.currentPhotoPath = absolutePath;
        Timber.Companion companion = Timber.INSTANCE;
        StringBuilder sb = new StringBuilder("currentPhotoPath");
        String str2 = this.currentPhotoPath;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentPhotoPath");
            str2 = null;
        }
        companion.d(sb.append(str2).toString(), new Object[0]);
        Intrinsics.checkNotNullExpressionValue(fileCreateTempFile, "apply(...)");
        return fileCreateTempFile;
    }

    public final void openPhotoPicker() {
        ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncher = this.pickMedia;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickMedia");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(PickVisualMediaRequestKt.PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE, 0, false, null, 14, null));
    }

    /* compiled from: SettingProfileFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment$uploadImage$1", f = "SettingProfileFragment.kt", i = {}, l = {376}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment$uploadImage$1, reason: invalid class name and case insensitive filesystem */
    static final class C10031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $image;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10031(File file, Uri uri, Continuation<? super C10031> continuation) {
            super(2, continuation);
            this.$image = file;
            this.$uri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingProfileFragment.this.new C10031(this.$image, this.$uri, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            SetCoverPhotoApiData.ResponseData responseData;
            String fileUrl;
            SetCoverPhotoApiData.ResponseData.DataMap.Data data;
            View root;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SettingProfileFragment.this.showLoading();
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
                    BaseFragment.handleApiError$default(SettingProfileFragment.this, "setting-uploadImage", message, false, 4, null);
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
                    FragmentSettingProfileBinding fragmentSettingProfileBindingAccess$getBinding = SettingProfileFragment.access$getBinding(SettingProfileFragment.this);
                    if (fragmentSettingProfileBindingAccess$getBinding != null && (root = fragmentSettingProfileBindingAccess$getBinding.getRoot()) != null) {
                        final SettingProfileFragment settingProfileFragment = SettingProfileFragment.this;
                        final Uri uri = this.$uri;
                        Boxing.boxBoolean(root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment$uploadImage$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                SettingProfileFragment.C10031.invokeSuspend$lambda$0(settingProfileFragment, uri);
                            }
                        }));
                    }
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (SettingProfileFragment.this.shouldIgnoreError(errorCode)) {
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error))).get(errorCode);
                    if (num != null) {
                        SettingProfileFragment settingProfileFragment2 = SettingProfileFragment.this;
                        CustomDialogKt.showCustomDialog$default(settingProfileFragment2, settingProfileFragment2.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(SettingProfileFragment.this, "setting-uploadImage", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
                SettingProfileFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                SettingProfileFragment.this.stopLoading();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(SettingProfileFragment settingProfileFragment, Uri uri) {
            ImageView imageView;
            FragmentSettingProfileBinding fragmentSettingProfileBindingAccess$getBinding = SettingProfileFragment.access$getBinding(settingProfileFragment);
            if (fragmentSettingProfileBindingAccess$getBinding == null || (imageView = fragmentSettingProfileBindingAccess$getBinding.imgHead) == null) {
                return;
            }
            imageView.setImageURI(uri);
        }
    }

    public final void uploadImage(File image, Uri uri) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(uri, "uri");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10031(image, uri, null), 3, null);
    }
}
