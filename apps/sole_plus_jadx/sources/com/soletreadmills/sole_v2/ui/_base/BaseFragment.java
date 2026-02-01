package com.soletreadmills.sole_v2.ui._base;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.ViewKt;
import androidx.viewbinding.ViewBinding;
import com.android.SdkConstants;
import com.blankj.utilcode.util.ThreadUtils;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2.AppConfigKt;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.banner.BannerApiData;
import com.soletreadmills.sole_v2._data.api.login.LoginByEmailApiData;
import com.soletreadmills.sole_v2._data.api.login.LoginByFacebookApiData;
import com.soletreadmills.sole_v2._data.api.login.LoginByGoogleApiData;
import com.soletreadmills.sole_v2._data.api.login.LoginByTokenApiData;
import com.soletreadmills.sole_v2._data.api.settings.UpdateMyUserInfoApiData;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._extension.FragmentExtensionKt;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._network.JwtNotificationDyacoApiKt;
import com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao;
import com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDatabase;
import com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoEntity;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._tools.KeyboardHideTool;
import com.soletreadmills.sole_v2._tools.UiTool;
import com.soletreadmills.sole_v2._type.BleDeviceListType;
import com.soletreadmills.sole_v2._type.MachineType;
import com.soletreadmills.sole_v2._type.UnitSettings;
import com.soletreadmills.sole_v2._type.user.GenderType;
import com.soletreadmills.sole_v2._type.user.RegisterType;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._shared.LoadingDialog;
import com.soletreadmills.sole_v2.ui._shared.UiStateViewModel;
import com.sun.jna.platform.win32.WinError;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: BaseFragment.kt */
@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0006¤\u0001¥\u0001¦\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u0006\u00102\u001a\u000203J\f\u00104\u001a\b\u0012\u0004\u0012\u00020605J\u0006\u00107\u001a\u000203J\u0006\u00108\u001a\u000203J\u000e\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020;J$\u0010<\u001a\u0002032\u0006\u0010=\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010?\u001a\u00020@H\u0004J\u0010\u0010A\u001a\u0002032\u0006\u0010B\u001a\u00020\u001dH\u0002J\u0012\u0010C\u001a\u0002032\b\u0010D\u001a\u0004\u0018\u00010\u001aH\u0002J0\u0010E\u001a\u0002032\u0006\u0010=\u001a\u00020.2\b\u0010F\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010?\u001a\u00020@H\u0004J\u0006\u0010H\u001a\u000203J\u001f\u0010I\u001a\u00028\u00002\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MH&¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u000203H&J\u001a\u0010P\u001a\u0002032\b\b\u0002\u0010Q\u001a\u00020.2\b\b\u0002\u0010R\u001a\u00020.J\u0010\u0010S\u001a\u0002032\b\b\u0002\u0010T\u001a\u00020.J\u0010\u0010U\u001a\u0002032\b\b\u0002\u0010V\u001a\u00020.J0\u0010W\u001a\u0002032\u0006\u0010W\u001a\u00020.2\b\b\u0002\u0010X\u001a\u00020@2\u0016\b\u0002\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u000203\u0018\u00010ZJ\b\u0010[\u001a\u000203H\u0002J\"\u0010\\\u001a\u0002032\u0006\u0010]\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001d2\b\u0010D\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010_\u001a\u0002032\u0006\u0010:\u001a\u00020;H\u0016J&\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\b\u0010d\u001a\u000203H\u0016J\b\u0010e\u001a\u000203H\u0016J\b\u0010f\u001a\u000203H\u0016J\b\u0010g\u001a\u000203H\u0016J\u001a\u0010h\u001a\u0002032\u0006\u0010i\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u0010\u0010j\u001a\u0002032\u0006\u0010k\u001a\u00020.H\u0004J\u0010\u0010l\u001a\u0002032\u0006\u0010k\u001a\u00020.H\u0004J\u0006\u0010m\u001a\u000203J\u001e\u0010n\u001a\u0002032\b\b\u0001\u0010o\u001a\u00020\u001d2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010cH\u0004JG\u0010n\u001a\u0002032\b\b\u0001\u0010o\u001a\u00020\u001d2.\u0010p\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010s0r0q\"\u0010\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010s0rH\u0004¢\u0006\u0002\u0010tJ\u001e\u0010u\u001a\u0002032\b\b\u0001\u0010o\u001a\u00020\u001d2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010cH\u0004J&\u0010v\u001a\u0002032\b\b\u0001\u0010w\u001a\u00020\u001d2\b\u0010p\u001a\u0004\u0018\u00010c2\b\u0010x\u001a\u0004\u0018\u00010yH\u0002J\b\u0010z\u001a\u00020@H\u0004J2\u0010{\u001a\u0002032\b\b\u0001\u0010o\u001a\u00020\u001d2\b\b\u0001\u0010|\u001a\u00020\u001d2\b\b\u0002\u0010}\u001a\u00020@2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010cH\u0004J\u001c\u0010~\u001a\u0002032\b\b\u0001\u0010\u007f\u001a\u00020\u001d2\b\b\u0002\u0010}\u001a\u00020@H\u0004J\u0010\u0010\u0080\u0001\u001a\u0002032\u0007\u0010D\u001a\u00030\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u0002032\u0006\u0010i\u001a\u00020aH\u0002J\u0012\u0010\u0083\u0001\u001a\u0002032\u0007\u0010\u0084\u0001\u001a\u00020aH\u0004J\u0007\u0010\u0085\u0001\u001a\u000203J\u0013\u0010\u0086\u0001\u001a\u0002032\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0004J\u0013\u0010\u0089\u0001\u001a\u00020@2\b\u0010F\u001a\u0004\u0018\u00010.H\u0004J\u0007\u0010\u008a\u0001\u001a\u000203JZ\u0010\u008b\u0001\u001a\u0002032\u0006\u0010:\u001a\u00020;2\u0007\u0010\u008c\u0001\u001a\u00020a2\u0019\u0010\u008d\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u001d0r002%\u0010\u008e\u0001\u001a \u0012\u0016\u0012\u00140\u001d¢\u0006\u000f\b\u008f\u0001\u0012\n\b\u0090\u0001\u0012\u0005\b\b(\u0091\u0001\u0012\u0004\u0012\u0002030ZJ\u0012\u0010\u0092\u0001\u001a\u0002032\u0007\u0010\u0093\u0001\u001a\u00020.H\u0004J\u0007\u0010\u0094\u0001\u001a\u000203J,\u0010\u0095\u0001\u001a\u0002032\u0007\u0010\u0096\u0001\u001a\u00020.2\u0006\u0010T\u001a\u00020.2\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0006\u0010Q\u001a\u00020.H\u0002J%\u0010\u0099\u0001\u001a\u0002032\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0012\b\u0002\u0010\u009c\u0001\u001a\u000b\u0012\u0004\u0012\u000203\u0018\u00010\u009d\u0001J!\u0010\u009e\u0001\u001a\u000203*\u00020c2\u0007\u0010\u009f\u0001\u001a\u00020.2\t\u0010 \u0001\u001a\u0004\u0018\u00010sH\u0002J\u001e\u0010¡\u0001\u001a\u000203*\u00030¢\u00012\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u0002030\u009d\u0001H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006§\u0001"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "()V", "NAV_FALLBACK_MS", "", "NAV_MAX_LOCK_MS", "NAV_UNLOCK_DELAY_MS", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "fbCallbackManager", "Lcom/facebook/CallbackManager;", "fbLoginManager", "Lcom/facebook/login/LoginManager;", "getFbLoginManager", "()Lcom/facebook/login/LoginManager;", "setFbLoginManager", "(Lcom/facebook/login/LoginManager;)V", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "googleSignInLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "loadingCount", "", "loadingDialog", "Lcom/soletreadmills/sole_v2/ui/_shared/LoadingDialog;", "<set-?>", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "mainActivity", "getMainActivity", "()Lcom/soletreadmills/sole_v2/ui/MainActivity;", "uiViewModel", "Lcom/soletreadmills/sole_v2/ui/_shared/UiStateViewModel;", "getUiViewModel", "()Lcom/soletreadmills/sole_v2/ui/_shared/UiStateViewModel;", "uiViewModel$delegate", "Lkotlin/Lazy;", "createClickableText", "Landroid/text/SpannableString;", "fullText", "", "clickableTexts", "", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment$ClickableTextData;", "getBanner", "", "getBleDevice", "", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "getFbIdAndLoginFB", "getGoogleIdAndLogin", "getLanguage", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "handleApiError", "apiName", "exception", "showDialog", "", "handleGoogleSignInError", "statusCode", "handleGoogleSignInResult", "data", "handleUndefinedError", "errorCode", "errorMsg", "hideKeyboard", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "initViews", "loginEmail", "email", "password", "loginFacebook", SDKConstants.PARAM_ACCESS_TOKEN, "loginGoogle", "idToken", "loginToken", "switchToHome", "onComplete", "Lkotlin/Function1;", "observeLoading", "onActivityResult", "requestCode", "resultCode", "onAttach", "onCreateView", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onDetach", "onResume", "onStart", "onViewCreated", "view", "openUrl", "url", "openUrlInBrowser", "resetLoginData", "safeNavigate", "actionId", "args", "", "Lkotlin/Pair;", "", "(I[Lkotlin/Pair;)V", "safeNavigateAndClearStack", "safeNavigateInternal", "actionOrDestId", "popUpConfig", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment$PopUpConfig;", "safeNavigateUp", "safeNavigateWithPopUp", "popUpToId", "inclusive", "safePopUpTo", "destinationId", "saveLoginData", "Lcom/soletreadmills/sole_v2/_data/login/LoginUserData;", "setStatusBarHeightOnViewCreated", "setStatusBarViewHeight", "statusBarView", "setUserAppLanguage", "setupTermsText", "textView", "Landroid/widget/TextView;", "shouldIgnoreError", "showLoading", "showSharePopupWithCustomLayout", "anchorView", FirebaseAnalytics.Param.ITEMS, "onItemClick", "Lkotlin/ParameterName;", "name", "index", "showToast", "msg", "stopLoading", "submitLoginBySocialAccount", "userId", "registerType", "Lcom/soletreadmills/sole_v2/_type/user/RegisterType;", "updateUserInfo", "newUserData", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMyUserInfoApiData$RequestBodyData;", "onSuccess", "Lkotlin/Function0;", "putAny", "key", "value", "withNavLock", "Landroidx/navigation/NavController;", "block", "ClickableTextData", "NavLock", "PopUpConfig", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {
    public static final int $stable = 8;
    private final long NAV_FALLBACK_MS;
    private final long NAV_MAX_LOCK_MS;
    private final long NAV_UNLOCK_DELAY_MS;
    private VB _binding;
    private CallbackManager fbCallbackManager;
    private LoginManager fbLoginManager;
    private GoogleSignInClient googleSignInClient;
    private final ActivityResultLauncher<Intent> googleSignInLauncher;
    private int loadingCount;
    private LoadingDialog loadingDialog;
    private MainActivity mainActivity;

    /* renamed from: uiViewModel$delegate, reason: from kotlin metadata */
    private final Lazy uiViewModel;

    public abstract VB inflateBinding(LayoutInflater inflater, ViewGroup container);

    public abstract void initViews();

    public BaseFragment() {
        final BaseFragment<VB> baseFragment = this;
        final Function0 function0 = null;
        this.uiViewModel = FragmentViewModelLazyKt.createViewModelLazy(baseFragment, Reflection.getOrCreateKotlinClass(UiStateViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = baseFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = baseFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = baseFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda7
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws Throwable {
                BaseFragment.googleSignInLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.googleSignInLauncher = activityResultLauncherRegisterForActivityResult;
        this.NAV_MAX_LOCK_MS = 2000L;
        this.NAV_UNLOCK_DELAY_MS = 500L;
        this.NAV_FALLBACK_MS = 500 + 150;
    }

    public final MainActivity getMainActivity() {
        return this.mainActivity;
    }

    protected final VB getBinding() {
        return this._binding;
    }

    protected final UiStateViewModel getUiViewModel() {
        return (UiStateViewModel) this.uiViewModel.getValue();
    }

    public final LoginManager getFbLoginManager() {
        return this.fbLoginManager;
    }

    public final void setFbLoginManager(LoginManager loginManager) {
        this.fbLoginManager = loginManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void googleSignInLauncher$lambda$0(BaseFragment this$0, ActivityResult result) throws Throwable {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.handleGoogleSignInResult(result.getData());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean shouldIgnoreError(String errorCode) {
        return CollectionsKt.contains(AppConfig.INSTANCE.getIGNORED_ERROR_CODES(), errorCode);
    }

    public static /* synthetic */ void handleApiError$default(BaseFragment baseFragment, String str, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleApiError");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        baseFragment.handleApiError(str, str2, z);
    }

    protected final void handleApiError(String apiName, String exception, boolean showDialog) {
        FragmentActivity activity;
        View view;
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        if (StringsKt.equals(exception, "StandaloneCoroutine was cancelled", true) || StringsKt.equals(exception, "Job was cancelled", true)) {
            Timber.INSTANCE.d("API Cancelled - Name: " + apiName + ", exception=" + exception, new Object[0]);
            return;
        }
        Timber.INSTANCE.e("API Exception - Name: " + apiName + ", Exception: " + exception, new Object[0]);
        MainActivity mainActivity = this.mainActivity;
        if (mainActivity != null) {
            MainActivity.logErrorUpload$default(mainActivity, apiName, "Exception", null, exception, 4, null);
        }
        if (!showDialog || (activity = getActivity()) == null || (view = getView()) == null || !isAdded() || isDetached()) {
            return;
        }
        final String string = activity.getString(R.string.err_network_service_not_available);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        final String string2 = activity.getString(R.string.confirm);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        view.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                BaseFragment.handleApiError$lambda$1(this.f$0, string, string2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleApiError$lambda$1(BaseFragment this$0, String errorMessage, String confirmText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errorMessage, "$errorMessage");
        Intrinsics.checkNotNullParameter(confirmText, "$confirmText");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || !this$0.isAdded() || this$0.isDetached() || this$0.getParentFragmentManager().isStateSaved() || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        CustomDialogKt.showCustomDialog$default(this$0, "", errorMessage, confirmText, null, null, null, false, 112, null);
    }

    public static /* synthetic */ void handleUndefinedError$default(BaseFragment baseFragment, String str, String str2, String str3, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleUndefinedError");
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            z = true;
        }
        baseFragment.handleUndefinedError(str, str2, str3, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void handleUndefinedError(String apiName, String errorCode, String errorMsg, boolean showDialog) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Timber.INSTANCE.e("API Undefined Error - Name: " + apiName + ", Code: " + errorCode + ", Msg: " + errorMsg, new Object[0]);
        MainActivity mainActivity = this.mainActivity;
        if (mainActivity != null) {
            mainActivity.logErrorUpload(apiName, "UndefinedErrorCode", errorCode, errorMsg);
        }
        if (isAdded() && getContext() != null && showDialog) {
            CustomDialogKt.showCustomDialog$default(this, "", getString(R.string.err_network_exception) + " (" + errorCode + ')', getString(R.string.confirm), null, null, null, false, 112, null);
        }
    }

    public static /* synthetic */ void safeNavigate$default(BaseFragment baseFragment, int i, Bundle bundle, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: safeNavigate");
        }
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        baseFragment.safeNavigate(i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void safeNavigate(int actionId, Bundle args) {
        safeNavigateInternal(actionId, args, null);
    }

    protected final void safeNavigate(int actionId, Pair<String, ? extends Object>... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Bundle bundle = new Bundle();
        for (Pair<String, ? extends Object> pair : args) {
            putAny(bundle, pair.component1(), pair.component2());
        }
        safeNavigate(actionId, bundle);
    }

    private final void putAny(Bundle bundle, String str, Object obj) {
        if (obj == null) {
            bundle.putString(str, null);
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Float) {
            bundle.putFloat(str, ((Number) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof CharSequence) {
            bundle.putCharSequence(str, (CharSequence) obj);
            return;
        }
        if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
            return;
        }
        if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof String[]) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                bundle.putStringArray(str, (String[]) obj);
                return;
            } else {
                if (!(objArr instanceof Parcelable[])) {
                    throw new IllegalStateException(("Unsupported array type for key=" + str).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                bundle.putParcelableArray(str, (Parcelable[]) obj);
                return;
            }
        }
        if (!(obj instanceof Enum)) {
            throw new IllegalStateException(("Unsupported type " + obj.getClass() + " for key=" + str).toString());
        }
        bundle.putString(str, ((Enum) obj).name());
    }

    public static /* synthetic */ void safeNavigateWithPopUp$default(BaseFragment baseFragment, int i, int i2, boolean z, Bundle bundle, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: safeNavigateWithPopUp");
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            bundle = null;
        }
        baseFragment.safeNavigateWithPopUp(i, i2, z, bundle);
    }

    protected final void safeNavigateWithPopUp(int actionId, int popUpToId, boolean inclusive, Bundle args) {
        safeNavigateInternal(actionId, args, new PopUpConfig(popUpToId, inclusive, false, 4, null));
    }

    public static /* synthetic */ void safeNavigateAndClearStack$default(BaseFragment baseFragment, int i, Bundle bundle, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: safeNavigateAndClearStack");
        }
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        baseFragment.safeNavigateAndClearStack(i, bundle);
    }

    protected final void safeNavigateAndClearStack(int actionId, final Bundle args) {
        Object objM9087constructorimpl;
        Object objM9087constructorimpl2;
        NavAction action;
        if (!isAdded() || isDetached() || isRemoving()) {
            Timber.INSTANCE.d("ResetNav skipped: fragment not attached → id=" + actionId, new Object[0]);
            return;
        }
        View view = getView();
        if (view == null) {
            Timber.INSTANCE.d("ResetNav skipped: view is null → id=" + actionId, new Object[0]);
            return;
        }
        if (!getViewLifecycleOwner().getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
            Timber.INSTANCE.d("ResetNav skipped: viewLifecycle not STARTED → id=" + actionId, new Object[0]);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BaseFragment<VB> baseFragment = this;
            objM9087constructorimpl = Result.m9087constructorimpl(ViewKt.findNavController(view));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9090exceptionOrNullimpl = Result.m9090exceptionOrNullimpl(objM9087constructorimpl);
        if (thM9090exceptionOrNullimpl != null) {
            Timber.INSTANCE.w(thM9090exceptionOrNullimpl, "ResetNav skipped: cannot find NavController → id=" + actionId, new Object[0]);
            return;
        }
        final NavController navController = (NavController) objM9087constructorimpl;
        NavDestination currentDestination = navController.getCurrentDestination();
        final int destinationId = (currentDestination == null || (action = currentDestination.getAction(actionId)) == null) ? actionId : action.getDestinationId();
        if (navController.getGraph().findNode(destinationId) == null || !getViewLifecycleOwner().getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
            Timber.INSTANCE.d("ResetNav skipped → id=" + actionId, new Object[0]);
            return;
        }
        final NavOptions navOptions = NavOptionsBuilderKt.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$safeNavigateAndClearStack$opts$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                invoke2(navOptionsBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavOptionsBuilder navOptions2) {
                Intrinsics.checkNotNullParameter(navOptions2, "$this$navOptions");
                navOptions2.popUpTo(navController.getGraph().getId(), new Function1<PopUpToBuilder, Unit>() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$safeNavigateAndClearStack$opts$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
                        invoke2(popUpToBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PopUpToBuilder popUpTo) {
                        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                        popUpTo.setInclusive(true);
                    }
                });
                navOptions2.setLaunchSingleTop(true);
                navOptions2.setRestoreState(false);
            }
        });
        try {
            Result.Companion companion3 = Result.INSTANCE;
            BaseFragment<VB> baseFragment2 = this;
            withNavLock(navController, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$safeNavigateAndClearStack$1$1
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
                    navController.navigate(destinationId, args, navOptions);
                }
            });
            objM9087constructorimpl2 = Result.m9087constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM9087constructorimpl2 = Result.m9087constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM9090exceptionOrNullimpl2 = Result.m9090exceptionOrNullimpl(objM9087constructorimpl2);
        if (thM9090exceptionOrNullimpl2 != null) {
            Timber.INSTANCE.w(thM9090exceptionOrNullimpl2, "ResetNav failed → action=" + actionId + " dest=" + destinationId, new Object[0]);
        }
    }

    public static /* synthetic */ void safePopUpTo$default(BaseFragment baseFragment, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: safePopUpTo");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        baseFragment.safePopUpTo(i, z);
    }

    protected final void safePopUpTo(int destinationId, boolean inclusive) {
        View view;
        Object objM9087constructorimpl;
        Object objM9087constructorimpl2;
        if (!isAdded() || isDetached() || isRemoving() || (view = getView()) == null || !getViewLifecycleOwner().getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BaseFragment<VB> baseFragment = this;
            objM9087constructorimpl = Result.m9087constructorimpl(ViewKt.findNavController(view));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9090exceptionOrNullimpl = Result.m9090exceptionOrNullimpl(objM9087constructorimpl);
        if (thM9090exceptionOrNullimpl != null) {
            Timber.INSTANCE.w(thM9090exceptionOrNullimpl, "SafeNavigation popUp skipped: no NavController", new Object[0]);
            return;
        }
        NavController navController = (NavController) objM9087constructorimpl;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            BaseFragment<VB> baseFragment2 = this;
            objM9087constructorimpl2 = Result.m9087constructorimpl(Boolean.valueOf(navController.popBackStack(destinationId, inclusive)));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM9087constructorimpl2 = Result.m9087constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM9090exceptionOrNullimpl2 = Result.m9090exceptionOrNullimpl(objM9087constructorimpl2);
        if (thM9090exceptionOrNullimpl2 != null) {
            Timber.INSTANCE.w(thM9090exceptionOrNullimpl2, "SafeNavigation popUp failed", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean safeNavigateUp() {
        View view;
        Object objM9087constructorimpl;
        Object objM9087constructorimpl2;
        if (!isAdded() || isDetached() || isRemoving() || (view = getView()) == null || !getViewLifecycleOwner().getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BaseFragment<VB> baseFragment = this;
            objM9087constructorimpl = Result.m9087constructorimpl(ViewKt.findNavController(view));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9093isFailureimpl(objM9087constructorimpl)) {
            objM9087constructorimpl = null;
        }
        NavController navController = (NavController) objM9087constructorimpl;
        if (navController == null) {
            return false;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            BaseFragment<VB> baseFragment2 = this;
            objM9087constructorimpl2 = Result.m9087constructorimpl(Boolean.valueOf(navController.navigateUp()));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM9087constructorimpl2 = Result.m9087constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM9090exceptionOrNullimpl = Result.m9090exceptionOrNullimpl(objM9087constructorimpl2);
        if (thM9090exceptionOrNullimpl != null) {
            Timber.INSTANCE.w(thM9090exceptionOrNullimpl, "SafeNavigation navigateUp failed", new Object[0]);
            objM9087constructorimpl2 = false;
        }
        return ((Boolean) objM9087constructorimpl2).booleanValue();
    }

    protected final void openUrlInBrowser(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        } catch (ActivityNotFoundException e) {
            Timber.INSTANCE.e(e, "No browser found", new Object[0]);
            CustomDialogKt.showCustomDialog$default(this, null, getString(R.string.network_exception), getString(R.string.confirm), null, null, null, false, 112, null);
        }
    }

    /* compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment$PopUpConfig;", "", "destinationId", "", "inclusive", "", "saveState", "(IZZ)V", "getDestinationId", "()I", "getInclusive", "()Z", "getSaveState", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final /* data */ class PopUpConfig {
        private final int destinationId;
        private final boolean inclusive;
        private final boolean saveState;

        public static /* synthetic */ PopUpConfig copy$default(PopUpConfig popUpConfig, int i, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = popUpConfig.destinationId;
            }
            if ((i2 & 2) != 0) {
                z = popUpConfig.inclusive;
            }
            if ((i2 & 4) != 0) {
                z2 = popUpConfig.saveState;
            }
            return popUpConfig.copy(i, z, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getDestinationId() {
            return this.destinationId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getInclusive() {
            return this.inclusive;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getSaveState() {
            return this.saveState;
        }

        public final PopUpConfig copy(int destinationId, boolean inclusive, boolean saveState) {
            return new PopUpConfig(destinationId, inclusive, saveState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PopUpConfig)) {
                return false;
            }
            PopUpConfig popUpConfig = (PopUpConfig) other;
            return this.destinationId == popUpConfig.destinationId && this.inclusive == popUpConfig.inclusive && this.saveState == popUpConfig.saveState;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.destinationId) * 31) + Boolean.hashCode(this.inclusive)) * 31) + Boolean.hashCode(this.saveState);
        }

        public String toString() {
            return "PopUpConfig(destinationId=" + this.destinationId + ", inclusive=" + this.inclusive + ", saveState=" + this.saveState + ')';
        }

        public PopUpConfig(int i, boolean z, boolean z2) {
            this.destinationId = i;
            this.inclusive = z;
            this.saveState = z2;
        }

        public /* synthetic */ PopUpConfig(int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, z, (i2 & 4) != 0 ? false : z2);
        }

        public final int getDestinationId() {
            return this.destinationId;
        }

        public final boolean getInclusive() {
            return this.inclusive;
        }

        public final boolean getSaveState() {
            return this.saveState;
        }
    }

    private final void safeNavigateInternal(int actionOrDestId, final Bundle args, PopUpConfig popUpConfig) {
        Object objM9087constructorimpl;
        if (!isAdded() || isDetached() || isRemoving()) {
            Timber.INSTANCE.d("SafeNavigation: Fragment not attached, skip id=" + actionOrDestId, new Object[0]);
            return;
        }
        if (getParentFragmentManager().isStateSaved()) {
            Timber.INSTANCE.d("SafeNavigation: FragmentManager state saved, skip", new Object[0]);
            return;
        }
        View view = getView();
        if (view == null) {
            Timber.INSTANCE.d("SafeNavigation: view is null, skip id=" + actionOrDestId, new Object[0]);
            return;
        }
        if (!getViewLifecycleOwner().getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
            Timber.INSTANCE.d("SafeNavigation: viewLifecycle not STARTED, skip", new Object[0]);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BaseFragment<VB> baseFragment = this;
            objM9087constructorimpl = Result.m9087constructorimpl(ViewKt.findNavController(view));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9090exceptionOrNullimpl = Result.m9090exceptionOrNullimpl(objM9087constructorimpl);
        if (thM9090exceptionOrNullimpl != null) {
            Timber.INSTANCE.w(thM9090exceptionOrNullimpl, "SafeNavigation: cannot find NavController, skip id=" + actionOrDestId, new Object[0]);
            return;
        }
        final NavController navController = (NavController) objM9087constructorimpl;
        NavDestination currentDestination = navController.getCurrentDestination();
        NavAction action = currentDestination != null ? currentDestination.getAction(actionOrDestId) : null;
        int destinationId = action != null ? action.getDestinationId() : actionOrDestId;
        final int i = action != null ? actionOrDestId : destinationId;
        if (navController.getGraph().findNode(destinationId) == null) {
            Timber.INSTANCE.w("SafeNavigation: destination/action " + actionOrDestId + " not found in graph " + navController.getGraph().getId(), new Object[0]);
            return;
        }
        if (!getViewLifecycleOwner().getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
            Timber.INSTANCE.d("SafeNavigation: Fragment not ready, skip", new Object[0]);
            return;
        }
        try {
            NavOptions.Builder popExitAnim = new NavOptions.Builder().setEnterAnim(R.anim.slide_right).setExitAnim(R.anim.slide_out_left).setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right);
            if (popUpConfig != null) {
                popExitAnim.setPopUpTo(popUpConfig.getDestinationId(), popUpConfig.getInclusive(), popUpConfig.getSaveState());
            }
            final NavOptions navOptionsBuild = popExitAnim.build();
            withNavLock(navController, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment.safeNavigateInternal.1
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
                    navController.navigate(i, args, navOptionsBuild);
                }
            });
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                Timber.INSTANCE.w(e, "SafeNavigation: invalid destination id=" + actionOrDestId, new Object[0]);
            } else if (e instanceof IllegalStateException) {
                Timber.INSTANCE.w(e, "SafeNavigation: state error, possibly back stack issue", new Object[0]);
            } else {
                Timber.INSTANCE.e(e, "SafeNavigation: unexpected error", new Object[0]);
            }
        }
    }

    /* compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\t\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment$NavLock;", "", "()V", "map", "Ljava/util/WeakHashMap;", "Landroidx/navigation/NavController;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "of", "kotlin.jvm.PlatformType", "nav", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class NavLock {
        public static final NavLock INSTANCE = new NavLock();
        private static final WeakHashMap<NavController, AtomicBoolean> map = new WeakHashMap<>();

        private NavLock() {
        }

        public final synchronized AtomicBoolean of(NavController nav) {
            AtomicBoolean atomicBoolean;
            Intrinsics.checkNotNullParameter(nav, "nav");
            WeakHashMap<NavController, AtomicBoolean> weakHashMap = map;
            atomicBoolean = weakHashMap.get(nav);
            if (atomicBoolean == null) {
                atomicBoolean = new AtomicBoolean(false);
                weakHashMap.put(nav, atomicBoolean);
            }
            return atomicBoolean;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda2] */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda3] */
    private final void withNavLock(final NavController navController, Function0<Unit> function0) {
        NavController.OnDestinationChangedListener onDestinationChangedListener;
        final AtomicBoolean atomicBooleanOf = NavLock.INSTANCE.of(navController);
        if (!atomicBooleanOf.compareAndSet(false, true)) {
            Timber.INSTANCE.d("NavLock: Action ignored, already navigating", new Object[0]);
            return;
        }
        final Handler handler = new Handler(Looper.getMainLooper());
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        objectRef.element = new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BaseFragment.withNavLock$lambda$20(booleanRef, atomicBooleanOf, handler, objectRef, objectRef2, objectRef3, navController, objectRef4);
            }
        };
        objectRef2.element = new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BaseFragment.withNavLock$lambda$21(booleanRef, atomicBooleanOf, handler, objectRef, objectRef2, objectRef3, navController, objectRef4);
            }
        };
        objectRef3.element = new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BaseFragment.withNavLock$lambda$22(booleanRef, atomicBooleanOf, handler, objectRef, objectRef2, objectRef3, navController, objectRef4);
            }
        };
        objectRef4.element = new NavController.OnDestinationChangedListener() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda3
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public final void onDestinationChanged(NavController navController2, NavDestination navDestination, Bundle bundle) {
                BaseFragment.withNavLock$lambda$23(handler, objectRef3, objectRef, this, navController2, navDestination, bundle);
            }
        };
        try {
            Runnable runnable = null;
            if (objectRef4.element == 0) {
                Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                onDestinationChangedListener = null;
            } else {
                onDestinationChangedListener = (NavController.OnDestinationChangedListener) objectRef4.element;
            }
            navController.addOnDestinationChangedListener(onDestinationChangedListener);
            if (objectRef2.element == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("maxTimeout");
            } else {
                runnable = (Runnable) objectRef2.element;
            }
            handler.postDelayed(runnable, this.NAV_MAX_LOCK_MS);
            function0.invoke();
        } catch (Throwable th) {
            Timber.INSTANCE.w(th, "NavLock: Error during navigation", new Object[0]);
            withNavLock$release(booleanRef, atomicBooleanOf, handler, objectRef, objectRef2, objectRef3, navController, objectRef4);
        }
    }

    private static final void withNavLock$release(Ref.BooleanRef booleanRef, AtomicBoolean atomicBoolean, Handler handler, Ref.ObjectRef<Runnable> objectRef, Ref.ObjectRef<Runnable> objectRef2, Ref.ObjectRef<Runnable> objectRef3, NavController navController, Ref.ObjectRef<NavController.OnDestinationChangedListener> objectRef4) {
        Runnable runnable;
        Runnable runnable2;
        Runnable runnable3;
        if (booleanRef.element) {
            return;
        }
        booleanRef.element = true;
        atomicBoolean.set(false);
        NavController.OnDestinationChangedListener onDestinationChangedListener = null;
        if (objectRef.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destRelease");
            runnable = null;
        } else {
            runnable = objectRef.element;
        }
        handler.removeCallbacks(runnable);
        if (objectRef2.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxTimeout");
            runnable2 = null;
        } else {
            runnable2 = objectRef2.element;
        }
        handler.removeCallbacks(runnable2);
        if (objectRef3.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fallback");
            runnable3 = null;
        } else {
            runnable3 = objectRef3.element;
        }
        handler.removeCallbacks(runnable3);
        try {
            Result.Companion companion = Result.INSTANCE;
            if (objectRef4.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            } else {
                onDestinationChangedListener = objectRef4.element;
            }
            navController.removeOnDestinationChangedListener(onDestinationChangedListener);
            Result.m9087constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9087constructorimpl(ResultKt.createFailure(th));
        }
        Timber.INSTANCE.d("NavLock: Released", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void withNavLock$lambda$20(Ref.BooleanRef released, AtomicBoolean atomicBoolean, Handler main, Ref.ObjectRef destRelease, Ref.ObjectRef maxTimeout, Ref.ObjectRef fallback, NavController this_withNavLock, Ref.ObjectRef listener) {
        Intrinsics.checkNotNullParameter(released, "$released");
        Intrinsics.checkNotNullParameter(main, "$main");
        Intrinsics.checkNotNullParameter(destRelease, "$destRelease");
        Intrinsics.checkNotNullParameter(maxTimeout, "$maxTimeout");
        Intrinsics.checkNotNullParameter(fallback, "$fallback");
        Intrinsics.checkNotNullParameter(this_withNavLock, "$this_withNavLock");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        withNavLock$release(released, atomicBoolean, main, destRelease, maxTimeout, fallback, this_withNavLock, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void withNavLock$lambda$21(Ref.BooleanRef released, AtomicBoolean atomicBoolean, Handler main, Ref.ObjectRef destRelease, Ref.ObjectRef maxTimeout, Ref.ObjectRef fallback, NavController this_withNavLock, Ref.ObjectRef listener) {
        Intrinsics.checkNotNullParameter(released, "$released");
        Intrinsics.checkNotNullParameter(main, "$main");
        Intrinsics.checkNotNullParameter(destRelease, "$destRelease");
        Intrinsics.checkNotNullParameter(maxTimeout, "$maxTimeout");
        Intrinsics.checkNotNullParameter(fallback, "$fallback");
        Intrinsics.checkNotNullParameter(this_withNavLock, "$this_withNavLock");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        withNavLock$release(released, atomicBoolean, main, destRelease, maxTimeout, fallback, this_withNavLock, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void withNavLock$lambda$22(Ref.BooleanRef released, AtomicBoolean atomicBoolean, Handler main, Ref.ObjectRef destRelease, Ref.ObjectRef maxTimeout, Ref.ObjectRef fallback, NavController this_withNavLock, Ref.ObjectRef listener) {
        Intrinsics.checkNotNullParameter(released, "$released");
        Intrinsics.checkNotNullParameter(main, "$main");
        Intrinsics.checkNotNullParameter(destRelease, "$destRelease");
        Intrinsics.checkNotNullParameter(maxTimeout, "$maxTimeout");
        Intrinsics.checkNotNullParameter(fallback, "$fallback");
        Intrinsics.checkNotNullParameter(this_withNavLock, "$this_withNavLock");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        withNavLock$release(released, atomicBoolean, main, destRelease, maxTimeout, fallback, this_withNavLock, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void withNavLock$lambda$23(Handler main, Ref.ObjectRef fallback, Ref.ObjectRef destRelease, BaseFragment this$0, NavController navController, NavDestination navDestination, Bundle bundle) {
        Runnable runnable;
        Runnable runnable2;
        Intrinsics.checkNotNullParameter(main, "$main");
        Intrinsics.checkNotNullParameter(fallback, "$fallback");
        Intrinsics.checkNotNullParameter(destRelease, "$destRelease");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(navController, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(navDestination, "<anonymous parameter 1>");
        Runnable runnable3 = null;
        if (fallback.element == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("fallback");
            runnable = null;
        } else {
            runnable = (Runnable) fallback.element;
        }
        main.removeCallbacks(runnable);
        if (destRelease.element == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("destRelease");
            runnable2 = null;
        } else {
            runnable2 = (Runnable) destRelease.element;
        }
        main.removeCallbacks(runnable2);
        if (destRelease.element == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("destRelease");
        } else {
            runnable3 = (Runnable) destRelease.element;
        }
        main.postDelayed(runnable3, this$0.NAV_UNLOCK_DELAY_MS);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VB vb = (VB) inflateBinding(inflater, container);
        this._binding = vb;
        if (vb != null) {
            return vb.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.mainActivity = (MainActivity) getActivity();
        observeLoading();
        this.fbLoginManager = LoginManager.INSTANCE.getInstance();
        this.fbCallbackManager = CallbackManager.Factory.create();
        MainActivity mainActivity = this.mainActivity;
        if (mainActivity != null) {
            GoogleSignInOptions googleSignInOptionsBuild = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestId().requestProfile().requestIdToken(getString(R.string.default_web_client_id)).build();
            Intrinsics.checkNotNullExpressionValue(googleSignInOptionsBuild, "build(...)");
            this.googleSignInClient = GoogleSignIn.getClient((Activity) mainActivity, googleSignInOptionsBuild);
        }
        initViews();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainActivity) {
            this.mainActivity = (MainActivity) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mainActivity = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LoadingDialog loadingDialog = this.loadingDialog;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        this.loadingDialog = null;
        this._binding = null;
        MainActivity mainActivity = this.mainActivity;
        if (mainActivity != null) {
            KeyboardHideTool.INSTANCE.hideSoftInput(mainActivity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CallbackManager callbackManager = this.fbCallbackManager;
        if (callbackManager != null) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    protected final void showToast(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Toast.makeText(requireContext(), msg, 0).show();
    }

    public final void showLoading() {
        Context context;
        if (!isAdded() || getView() == null || !getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED) || (context = getContext()) == null) {
            return;
        }
        int i = this.loadingCount + 1;
        this.loadingCount = i;
        if (i == 1) {
            LoadingDialog loadingDialog = new LoadingDialog(0L, 1, null);
            this.loadingDialog = loadingDialog;
            loadingDialog.show(context);
        }
    }

    public final void stopLoading() {
        int i = this.loadingCount - 1;
        this.loadingCount = i;
        if (i <= 0) {
            this.loadingCount = 0;
            LoadingDialog loadingDialog = this.loadingDialog;
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        }
    }

    private final void observeLoading() {
        getUiViewModel().getLoadingState().observe(getViewLifecycleOwner(), new BaseFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>(this) { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment.observeLoading.1
            final /* synthetic */ BaseFragment<VB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    this.this$0.showLoading();
                } else {
                    this.this$0.stopLoading();
                }
            }
        }));
    }

    private final void setStatusBarHeightOnViewCreated(View view) {
        View viewFindViewById = view.findViewById(R.id.statusBarHeight);
        if (viewFindViewById != null) {
            FragmentExtensionKt.setStatusBarHeight(this, viewFindViewById);
        }
    }

    public final void hideKeyboard() {
        IBinder windowToken;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager == null) {
            return;
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null || (windowToken = currentFocus.getWindowToken()) == null) {
            windowToken = activity.getWindow().getDecorView().getWindowToken();
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        if (currentFocus != null) {
            currentFocus.clearFocus();
        }
    }

    public static /* synthetic */ void loginEmail$default(BaseFragment baseFragment, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginEmail");
        }
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        baseFragment.loginEmail(str, str2);
    }

    public final void loginEmail(String email, String password) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        if (Intrinsics.areEqual(email, "") || Intrinsics.areEqual(password, "")) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08471(this, email, password, null), 3, null);
    }

    /* compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "VB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._base.BaseFragment$loginEmail$1", f = "BaseFragment.kt", i = {}, l = {WinError.ERROR_EVENT_DONE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui._base.BaseFragment$loginEmail$1, reason: invalid class name and case insensitive filesystem */
    static final class C08471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $email;
        final /* synthetic */ String $password;
        int label;
        final /* synthetic */ BaseFragment<VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08471(BaseFragment<VB> baseFragment, String str, String str2, Continuation<? super C08471> continuation) {
            super(2, continuation);
            this.this$0 = baseFragment;
            this.$email = str;
            this.$password = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08471(this.this$0, this.$email, this.$password, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            LoginUserData data;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Timber.INSTANCE.d("EMAIL login", new Object[0]);
                        this.this$0.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callLoginByEmail(new LoginByEmailApiData.RequestBodyData(this.$email, this.$password, AppConfig.INSTANCE.getPUSH_MESSAGE_TOKEN()), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Response response = (Response) obj;
                    Timber.INSTANCE.d("loginEmailRes Body: " + response, new Object[0]);
                    this.this$0.stopLoading();
                    LoginByEmailApiData.ResponseData responseData = (LoginByEmailApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("loginEmailBody: " + responseData, new Object[0]);
                    if (responseData != null && responseData.getSuccess()) {
                        MySharedPreferences.INSTANCE.getInstance().clearOldLoginToken();
                        AppConfigKt.setSessionId(response.headers().get("sessionid"));
                        LoginByEmailApiData.DataMap dataMap = responseData.getDataMap();
                        AppConfigKt.setServiceLoginToken(dataMap != null ? dataMap.getServiceLoginToken() : null);
                        Timber.INSTANCE.d("loginSEmailBody: 登入成功!", new Object[0]);
                        LoginByEmailApiData.DataMap dataMap2 = responseData.getDataMap();
                        if (dataMap2 != null && (data = dataMap2.getData()) != null) {
                            this.this$0.saveLoginData(data);
                            Timber.INSTANCE.d("儲存userData:" + data, new Object[0]);
                        }
                        LoginByEmailApiData.DataMap dataMap3 = responseData.getDataMap();
                        MySharedPreferences.INSTANCE.getInstance().setSharedLoginToken(dataMap3 != null ? dataMap3.getLoginToken() : null);
                        Timber.INSTANCE.d("now save token: " + MySharedPreferences.INSTANCE.getInstance().getSharedLoginToken(), new Object[0]);
                        if (this.this$0.isAdded()) {
                            this.this$0.setUserAppLanguage();
                            BaseFragment.safeNavigateAndClearStack$default(this.this$0, R.id.homeMainFragment, null, 2, null);
                        }
                    } else {
                        String errorCode = responseData != null ? responseData.getErrorCode() : null;
                        if (this.this$0.shouldIgnoreError(errorCode)) {
                            unit = Unit.INSTANCE;
                        } else if (Intrinsics.areEqual(errorCode, ErrorCode.USER_NOT_CONFIRMED_AFTER_SIGNUP_1005.getId())) {
                            this.this$0.safeNavigate(R.id.verifyEmailFragment, BundleKt.bundleOf(TuplesKt.to("email", this.$email), TuplesKt.to("isNeedSendEmail", Boxing.boxBoolean(true))));
                            unit = Unit.INSTANCE;
                        } else {
                            Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.USER_NOT_FOUND_1003.getId(), Boxing.boxInt(R.string.err_1003_user_not_found)), TuplesKt.to(ErrorCode.USER_HAS_BEEN_DISABLED_1019.getId(), Boxing.boxInt(R.string.err_1019_user_has_been_disabled)), TuplesKt.to(ErrorCode.LOGIN_ERR_WRONG_PWD_OR_USERNAME_112.getId(), Boxing.boxInt(R.string.err_112_wrong_account_or_password))).get(errorCode);
                            if (num != null) {
                                BaseFragment<VB> baseFragment = this.this$0;
                                CustomDialogKt.showCustomDialog$default(baseFragment, baseFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                            } else {
                                BaseFragment.handleUndefinedError$default(this.this$0, "loginEmail", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                            }
                        }
                        return unit;
                    }
                } catch (IOException e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(this.this$0, "loginEmail", message, false, 4, null);
                }
                this.this$0.stopLoading();
                return Unit.INSTANCE;
            } finally {
                this.this$0.stopLoading();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loginToken$default(BaseFragment baseFragment, String str, boolean z, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginToken");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        baseFragment.loginToken(str, z, function1);
    }

    public final void loginToken(String loginToken, boolean switchToHome, Function1<? super Boolean, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(loginToken, "loginToken");
        if (Intrinsics.areEqual(loginToken, "")) {
            safeNavigateAndClearStack$default(this, R.id.chooseFragment, null, 2, null);
            if (onComplete != null) {
                onComplete.invoke(false);
                return;
            }
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08501(this, loginToken, switchToHome, onComplete, null), 3, null);
    }

    /* compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "VB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._base.BaseFragment$loginToken$1", f = "BaseFragment.kt", i = {}, l = {854}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui._base.BaseFragment$loginToken$1, reason: invalid class name and case insensitive filesystem */
    static final class C08501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $loginToken;
        final /* synthetic */ Function1<Boolean, Unit> $onComplete;
        final /* synthetic */ boolean $switchToHome;
        int label;
        final /* synthetic */ BaseFragment<VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08501(BaseFragment<VB> baseFragment, String str, boolean z, Function1<? super Boolean, Unit> function1, Continuation<? super C08501> continuation) {
            super(2, continuation);
            this.this$0 = baseFragment;
            this.$loginToken = str;
            this.$switchToHome = z;
            this.$onComplete = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08501(this.this$0, this.$loginToken, this.$switchToHome, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            Response response;
            LoginByTokenApiData.ResponseData responseData;
            LoginUserData data;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.showLoading();
                        Timber.INSTANCE.d("Token login", new Object[0]);
                        this.label = 1;
                        obj = DyacoApiKt.callLoginByToken(new LoginByTokenApiData.RequestBodyData(this.$loginToken, AppConfig.INSTANCE.getPUSH_MESSAGE_TOKEN()), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    response = (Response) obj;
                    Timber.INSTANCE.d("loginTokenRes Body: " + response, new Object[0]);
                    this.this$0.stopLoading();
                    responseData = (LoginByTokenApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("loginTokenBody: " + (responseData != null ? responseData.getDataMap() : null), new Object[0]);
                } catch (Exception e) {
                    Function1<Boolean, Unit> function1 = this.$onComplete;
                    if (function1 != null) {
                        function1.invoke(Boxing.boxBoolean(false));
                    }
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(this.this$0, "loginByToken", message, false, 4, null);
                    BaseFragment.safeNavigateAndClearStack$default(this.this$0, R.id.chooseFragment, null, 2, null);
                    unit = Unit.INSTANCE;
                }
                if (responseData != null && responseData.getSuccess()) {
                    MySharedPreferences.INSTANCE.getInstance().clearOldLoginToken();
                    AppConfigKt.setSessionId(response.headers().get("sessionid"));
                    LoginByEmailApiData.DataMap dataMap = responseData.getDataMap();
                    AppConfigKt.setServiceLoginToken(dataMap != null ? dataMap.getServiceLoginToken() : null);
                    Timber.INSTANCE.d("loginTokenBody: 登入成功!", new Object[0]);
                    LoginByEmailApiData.DataMap dataMap2 = responseData.getDataMap();
                    if (dataMap2 != null && (data = dataMap2.getData()) != null) {
                        this.this$0.saveLoginData(data);
                        Timber.INSTANCE.d("儲存userData:" + data, new Object[0]);
                    }
                    LoginByEmailApiData.DataMap dataMap3 = responseData.getDataMap();
                    MySharedPreferences.INSTANCE.getInstance().setSharedLoginToken(dataMap3 != null ? dataMap3.getLoginToken() : null);
                    Timber.INSTANCE.d("now save token: " + MySharedPreferences.INSTANCE.getInstance().getSharedLoginToken(), new Object[0]);
                    if (this.$switchToHome) {
                        BaseFragment.safeNavigateAndClearStack$default(this.this$0, R.id.homeMainFragment, null, 2, null);
                        MainActivity mainActivity = this.this$0.getMainActivity();
                        Intent pendingFcmIntent = mainActivity != null ? mainActivity.getPendingFcmIntent() : null;
                        if (pendingFcmIntent != null) {
                            MainActivity mainActivity2 = this.this$0.getMainActivity();
                            if (mainActivity2 != null) {
                                mainActivity2.handleFcmData(pendingFcmIntent);
                            }
                            MainActivity mainActivity3 = this.this$0.getMainActivity();
                            if (mainActivity3 != null) {
                                mainActivity3.setPendingFcmIntent(null);
                            }
                        } else if (this.$switchToHome) {
                            BaseFragment.safeNavigateAndClearStack$default(this.this$0, R.id.homeMainFragment, null, 2, null);
                        }
                    }
                    Function1<Boolean, Unit> function12 = this.$onComplete;
                    if (function12 != null) {
                        function12.invoke(Boxing.boxBoolean(true));
                    }
                    this.this$0.stopLoading();
                    return Unit.INSTANCE;
                }
                Function1<Boolean, Unit> function13 = this.$onComplete;
                if (function13 != null) {
                    function13.invoke(Boxing.boxBoolean(false));
                }
                BaseFragment.safeNavigateAndClearStack$default(this.this$0, R.id.chooseFragment, null, 2, null);
                String errorCode = responseData != null ? responseData.getErrorCode() : null;
                if (this.this$0.shouldIgnoreError(errorCode) || Intrinsics.areEqual(errorCode, ErrorCode.USER_NOT_FOUND_1003.getId()) || Intrinsics.areEqual(errorCode, ErrorCode.INVALID_LOGIN_TOKEN_1210.getId())) {
                    unit = Unit.INSTANCE;
                } else {
                    this.this$0.handleUndefinedError("loginByToken", errorCode, responseData != null ? responseData.getErrorMessage() : null, false);
                    unit = Unit.INSTANCE;
                }
                return unit;
            } finally {
                this.this$0.stopLoading();
            }
        }
    }

    public final void getGoogleIdAndLogin() {
        Intent signInIntent;
        Timber.INSTANCE.d("LoginGoogle...", new Object[0]);
        showLoading();
        GoogleSignInClient googleSignInClient = this.googleSignInClient;
        if (googleSignInClient == null || (signInIntent = googleSignInClient.getSignInIntent()) == null) {
            return;
        }
        this.googleSignInLauncher.launch(signInIntent);
    }

    private final void handleGoogleSignInResult(Intent data) throws Throwable {
        if (data == null) {
            stopLoading();
            return;
        }
        try {
            Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(data);
            Intrinsics.checkNotNullExpressionValue(signedInAccountFromIntent, "getSignedInAccountFromIntent(...)");
            GoogleSignInAccount result = signedInAccountFromIntent.getResult(ApiException.class);
            Timber.INSTANCE.i("Google login Success", new Object[0]);
            String id2 = result.getId();
            String idToken = result.getIdToken();
            String displayName = result.getDisplayName();
            String email = result.getEmail();
            if (email == null) {
                email = "";
            }
            Timber.INSTANCE.d("googlein getId : " + id2, new Object[0]);
            Timber.INSTANCE.d("googlein idToken : " + idToken, new Object[0]);
            Timber.INSTANCE.d("googlein getname : " + displayName, new Object[0]);
            Timber.INSTANCE.d("googlein getemail : " + email, new Object[0]);
            GoogleSignInClient googleSignInClient = this.googleSignInClient;
            if (googleSignInClient != null) {
                googleSignInClient.signOut();
            }
            if (id2 != null && idToken != null) {
                submitLoginBySocialAccount(id2, idToken, RegisterType.GOOGLE, email);
            } else {
                stopLoading();
                CustomDialogKt.showCustomDialog$default(this, getString(R.string.google_get_error), null, null, null, null, null, false, 126, null);
            }
        } catch (ApiException e) {
            stopLoading();
            Timber.INSTANCE.e("Google sign in failed: " + e.getStatusCode(), new Object[0]);
            handleGoogleSignInError(e.getStatusCode());
        }
    }

    private final void handleGoogleSignInError(int statusCode) {
        String string;
        switch (statusCode) {
            case GoogleSignInStatusCodes.SIGN_IN_FAILED /* 12500 */:
                string = getString(R.string.google_sign_in_failed);
                break;
            case GoogleSignInStatusCodes.SIGN_IN_CANCELLED /* 12501 */:
                string = getString(R.string.google_sign_in_cancelled);
                break;
            case GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS /* 12502 */:
                string = getString(R.string.google_sign_in_in_progress);
                break;
            default:
                string = getString(R.string.google_sign_in_unknown_error, Integer.valueOf(statusCode));
                break;
        }
        String str = string;
        Intrinsics.checkNotNull(str);
        Timber.INSTANCE.e("Google Sign-In failed with status code: " + statusCode, new Object[0]);
        CustomDialogKt.showCustomDialog$default(this, null, str, null, null, null, null, false, 125, null);
    }

    public final void getFbIdAndLoginFB() {
        Timber.INSTANCE.d("LoginFB...", new Object[0]);
        showLoading();
        LoginManager loginManager = this.fbLoginManager;
        if (loginManager != null) {
            loginManager.setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("public_profile");
        arrayList.add("email");
        LoginManager loginManager2 = this.fbLoginManager;
        if (loginManager2 != null) {
            loginManager2.logInWithReadPermissions(this, arrayList);
        }
        LoginManager loginManager3 = this.fbLoginManager;
        if (loginManager3 != null) {
            loginManager3.registerCallback(this.fbCallbackManager, new C08461(this));
        }
    }

    /* compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/soletreadmills/sole_v2/ui/_base/BaseFragment$getFbIdAndLoginFB$1", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "onCancel", "", "onError", "error", "Lcom/facebook/FacebookException;", "onSuccess", "result", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.soletreadmills.sole_v2.ui._base.BaseFragment$getFbIdAndLoginFB$1, reason: invalid class name and case insensitive filesystem */
    public static final class C08461 implements FacebookCallback<LoginResult> {
        final /* synthetic */ BaseFragment<VB> this$0;

        C08461(BaseFragment<VB> baseFragment) {
            this.this$0 = baseFragment;
        }

        @Override // com.facebook.FacebookCallback
        public void onSuccess(LoginResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            GraphRequest.Companion companion = GraphRequest.INSTANCE;
            AccessToken accessToken = result.getAccessToken();
            final BaseFragment<VB> baseFragment = this.this$0;
            GraphRequest graphRequestNewMeRequest = companion.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$getFbIdAndLoginFB$1$$ExternalSyntheticLambda2
                @Override // com.facebook.GraphRequest.GraphJSONObjectCallback
                public final void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
                    BaseFragment.C08461.onSuccess$lambda$0(baseFragment, jSONObject, graphResponse);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,email");
            graphRequestNewMeRequest.setParameters(bundle);
            graphRequestNewMeRequest.executeAsync();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final void onSuccess$lambda$0(com.soletreadmills.sole_v2.ui._base.BaseFragment r10, org.json.JSONObject r11, com.facebook.GraphResponse r12) {
            /*
                Method dump skipped, instructions count: 268
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui._base.BaseFragment.C08461.onSuccess$lambda$0(com.soletreadmills.sole_v2.ui._base.BaseFragment, org.json.JSONObject, com.facebook.GraphResponse):void");
        }

        @Override // com.facebook.FacebookCallback
        public void onCancel() {
            this.this$0.stopLoading();
            final BaseFragment<VB> baseFragment = this.this$0;
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$getFbIdAndLoginFB$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BaseFragment.C08461.onCancel$lambda$1(baseFragment);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCancel$lambda$1(BaseFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Timber.INSTANCE.e("loginFB -> onCancel", new Object[0]);
            LoginManager fbLoginManager = this$0.getFbLoginManager();
            if (fbLoginManager != null) {
                fbLoginManager.logOut();
            }
        }

        @Override // com.facebook.FacebookCallback
        public void onError(FacebookException error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.this$0.stopLoading();
            Timber.INSTANCE.e("loginFB -> onError=" + error, new Object[0]);
            final BaseFragment<VB> baseFragment = this.this$0;
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$getFbIdAndLoginFB$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    BaseFragment.C08461.onError$lambda$2(baseFragment);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onError$lambda$2(BaseFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LoginManager fbLoginManager = this$0.getFbLoginManager();
            if (fbLoginManager != null) {
                fbLoginManager.logOut();
            }
        }
    }

    /* compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "VB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._base.BaseFragment$submitLoginBySocialAccount$1", f = "BaseFragment.kt", i = {}, l = {1148, WinError.ERROR_NO_MATCH, WinError.ERROR_NOT_CONTAINER, WinError.ERROR_ALREADY_THREAD}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui._base.BaseFragment$submitLoginBySocialAccount$1, reason: invalid class name and case insensitive filesystem */
    static final class C08531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accessToken;
        final /* synthetic */ String $email;
        final /* synthetic */ RegisterType $registerType;
        final /* synthetic */ String $userId;
        int label;
        final /* synthetic */ BaseFragment<VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08531(BaseFragment<VB> baseFragment, RegisterType registerType, String str, String str2, String str3, Continuation<? super C08531> continuation) {
            super(2, continuation);
            this.this$0 = baseFragment;
            this.$registerType = registerType;
            this.$userId = str;
            this.$accessToken = str2;
            this.$email = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08531(this.this$0, this.$registerType, this.$userId, this.$accessToken, this.$email, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x0362 A[Catch: all -> 0x005c, Exception -> 0x03ec, TryCatch #1 {Exception -> 0x03ec, blocks: (B:94:0x0305, B:96:0x030f, B:98:0x0316, B:100:0x031c, B:102:0x0322, B:122:0x03a2, B:124:0x03c1, B:125:0x03c8, B:127:0x03ce, B:104:0x0362, B:108:0x036c, B:110:0x0374, B:112:0x037a, B:114:0x0382, B:115:0x0386, B:117:0x038c, B:119:0x0394, B:121:0x039a, B:70:0x01f7, B:72:0x022b, B:74:0x0232, B:76:0x0242, B:78:0x0248, B:79:0x02b5, B:81:0x02bb, B:83:0x02c1, B:85:0x02c9, B:86:0x02cd, B:88:0x02d3, B:90:0x02d9, B:45:0x00fb, B:47:0x0105, B:49:0x010c, B:51:0x0112, B:53:0x0118, B:67:0x01a8, B:55:0x0158, B:58:0x0160, B:61:0x0168, B:63:0x0195, B:66:0x019d, B:29:0x0088, B:31:0x00a9, B:33:0x00af, B:36:0x00bb, B:39:0x00c3, B:40:0x00d8, B:42:0x00e3, B:91:0x02ea, B:26:0x0076), top: B:139:0x0076 }] */
        /* JADX WARN: Removed duplicated region for block: B:105:0x0367  */
        /* JADX WARN: Removed duplicated region for block: B:107:0x036a  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x03c1 A[Catch: all -> 0x005c, Exception -> 0x03ec, TryCatch #1 {Exception -> 0x03ec, blocks: (B:94:0x0305, B:96:0x030f, B:98:0x0316, B:100:0x031c, B:102:0x0322, B:122:0x03a2, B:124:0x03c1, B:125:0x03c8, B:127:0x03ce, B:104:0x0362, B:108:0x036c, B:110:0x0374, B:112:0x037a, B:114:0x0382, B:115:0x0386, B:117:0x038c, B:119:0x0394, B:121:0x039a, B:70:0x01f7, B:72:0x022b, B:74:0x0232, B:76:0x0242, B:78:0x0248, B:79:0x02b5, B:81:0x02bb, B:83:0x02c1, B:85:0x02c9, B:86:0x02cd, B:88:0x02d3, B:90:0x02d9, B:45:0x00fb, B:47:0x0105, B:49:0x010c, B:51:0x0112, B:53:0x0118, B:67:0x01a8, B:55:0x0158, B:58:0x0160, B:61:0x0168, B:63:0x0195, B:66:0x019d, B:29:0x0088, B:31:0x00a9, B:33:0x00af, B:36:0x00bb, B:39:0x00c3, B:40:0x00d8, B:42:0x00e3, B:91:0x02ea, B:26:0x0076), top: B:139:0x0076 }] */
        /* JADX WARN: Removed duplicated region for block: B:127:0x03ce A[Catch: all -> 0x005c, Exception -> 0x03ec, TRY_LEAVE, TryCatch #1 {Exception -> 0x03ec, blocks: (B:94:0x0305, B:96:0x030f, B:98:0x0316, B:100:0x031c, B:102:0x0322, B:122:0x03a2, B:124:0x03c1, B:125:0x03c8, B:127:0x03ce, B:104:0x0362, B:108:0x036c, B:110:0x0374, B:112:0x037a, B:114:0x0382, B:115:0x0386, B:117:0x038c, B:119:0x0394, B:121:0x039a, B:70:0x01f7, B:72:0x022b, B:74:0x0232, B:76:0x0242, B:78:0x0248, B:79:0x02b5, B:81:0x02bb, B:83:0x02c1, B:85:0x02c9, B:86:0x02cd, B:88:0x02d3, B:90:0x02d9, B:45:0x00fb, B:47:0x0105, B:49:0x010c, B:51:0x0112, B:53:0x0118, B:67:0x01a8, B:55:0x0158, B:58:0x0160, B:61:0x0168, B:63:0x0195, B:66:0x019d, B:29:0x0088, B:31:0x00a9, B:33:0x00af, B:36:0x00bb, B:39:0x00c3, B:40:0x00d8, B:42:0x00e3, B:91:0x02ea, B:26:0x0076), top: B:139:0x0076 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0156  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0158 A[Catch: all -> 0x005c, Exception -> 0x03ec, TryCatch #1 {Exception -> 0x03ec, blocks: (B:94:0x0305, B:96:0x030f, B:98:0x0316, B:100:0x031c, B:102:0x0322, B:122:0x03a2, B:124:0x03c1, B:125:0x03c8, B:127:0x03ce, B:104:0x0362, B:108:0x036c, B:110:0x0374, B:112:0x037a, B:114:0x0382, B:115:0x0386, B:117:0x038c, B:119:0x0394, B:121:0x039a, B:70:0x01f7, B:72:0x022b, B:74:0x0232, B:76:0x0242, B:78:0x0248, B:79:0x02b5, B:81:0x02bb, B:83:0x02c1, B:85:0x02c9, B:86:0x02cd, B:88:0x02d3, B:90:0x02d9, B:45:0x00fb, B:47:0x0105, B:49:0x010c, B:51:0x0112, B:53:0x0118, B:67:0x01a8, B:55:0x0158, B:58:0x0160, B:61:0x0168, B:63:0x0195, B:66:0x019d, B:29:0x0088, B:31:0x00a9, B:33:0x00af, B:36:0x00bb, B:39:0x00c3, B:40:0x00d8, B:42:0x00e3, B:91:0x02ea, B:26:0x0076), top: B:139:0x0076 }] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x015d  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0160 A[Catch: all -> 0x005c, Exception -> 0x03ec, TryCatch #1 {Exception -> 0x03ec, blocks: (B:94:0x0305, B:96:0x030f, B:98:0x0316, B:100:0x031c, B:102:0x0322, B:122:0x03a2, B:124:0x03c1, B:125:0x03c8, B:127:0x03ce, B:104:0x0362, B:108:0x036c, B:110:0x0374, B:112:0x037a, B:114:0x0382, B:115:0x0386, B:117:0x038c, B:119:0x0394, B:121:0x039a, B:70:0x01f7, B:72:0x022b, B:74:0x0232, B:76:0x0242, B:78:0x0248, B:79:0x02b5, B:81:0x02bb, B:83:0x02c1, B:85:0x02c9, B:86:0x02cd, B:88:0x02d3, B:90:0x02d9, B:45:0x00fb, B:47:0x0105, B:49:0x010c, B:51:0x0112, B:53:0x0118, B:67:0x01a8, B:55:0x0158, B:58:0x0160, B:61:0x0168, B:63:0x0195, B:66:0x019d, B:29:0x0088, B:31:0x00a9, B:33:0x00af, B:36:0x00bb, B:39:0x00c3, B:40:0x00d8, B:42:0x00e3, B:91:0x02ea, B:26:0x0076), top: B:139:0x0076 }] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0168 A[Catch: all -> 0x005c, Exception -> 0x03ec, TryCatch #1 {Exception -> 0x03ec, blocks: (B:94:0x0305, B:96:0x030f, B:98:0x0316, B:100:0x031c, B:102:0x0322, B:122:0x03a2, B:124:0x03c1, B:125:0x03c8, B:127:0x03ce, B:104:0x0362, B:108:0x036c, B:110:0x0374, B:112:0x037a, B:114:0x0382, B:115:0x0386, B:117:0x038c, B:119:0x0394, B:121:0x039a, B:70:0x01f7, B:72:0x022b, B:74:0x0232, B:76:0x0242, B:78:0x0248, B:79:0x02b5, B:81:0x02bb, B:83:0x02c1, B:85:0x02c9, B:86:0x02cd, B:88:0x02d3, B:90:0x02d9, B:45:0x00fb, B:47:0x0105, B:49:0x010c, B:51:0x0112, B:53:0x0118, B:67:0x01a8, B:55:0x0158, B:58:0x0160, B:61:0x0168, B:63:0x0195, B:66:0x019d, B:29:0x0088, B:31:0x00a9, B:33:0x00af, B:36:0x00bb, B:39:0x00c3, B:40:0x00d8, B:42:0x00e3, B:91:0x02ea, B:26:0x0076), top: B:139:0x0076 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01f6 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:72:0x022b A[Catch: all -> 0x005c, Exception -> 0x03ec, TryCatch #1 {Exception -> 0x03ec, blocks: (B:94:0x0305, B:96:0x030f, B:98:0x0316, B:100:0x031c, B:102:0x0322, B:122:0x03a2, B:124:0x03c1, B:125:0x03c8, B:127:0x03ce, B:104:0x0362, B:108:0x036c, B:110:0x0374, B:112:0x037a, B:114:0x0382, B:115:0x0386, B:117:0x038c, B:119:0x0394, B:121:0x039a, B:70:0x01f7, B:72:0x022b, B:74:0x0232, B:76:0x0242, B:78:0x0248, B:79:0x02b5, B:81:0x02bb, B:83:0x02c1, B:85:0x02c9, B:86:0x02cd, B:88:0x02d3, B:90:0x02d9, B:45:0x00fb, B:47:0x0105, B:49:0x010c, B:51:0x0112, B:53:0x0118, B:67:0x01a8, B:55:0x0158, B:58:0x0160, B:61:0x0168, B:63:0x0195, B:66:0x019d, B:29:0x0088, B:31:0x00a9, B:33:0x00af, B:36:0x00bb, B:39:0x00c3, B:40:0x00d8, B:42:0x00e3, B:91:0x02ea, B:26:0x0076), top: B:139:0x0076 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x02b9  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x02bb A[Catch: all -> 0x005c, Exception -> 0x03ec, TryCatch #1 {Exception -> 0x03ec, blocks: (B:94:0x0305, B:96:0x030f, B:98:0x0316, B:100:0x031c, B:102:0x0322, B:122:0x03a2, B:124:0x03c1, B:125:0x03c8, B:127:0x03ce, B:104:0x0362, B:108:0x036c, B:110:0x0374, B:112:0x037a, B:114:0x0382, B:115:0x0386, B:117:0x038c, B:119:0x0394, B:121:0x039a, B:70:0x01f7, B:72:0x022b, B:74:0x0232, B:76:0x0242, B:78:0x0248, B:79:0x02b5, B:81:0x02bb, B:83:0x02c1, B:85:0x02c9, B:86:0x02cd, B:88:0x02d3, B:90:0x02d9, B:45:0x00fb, B:47:0x0105, B:49:0x010c, B:51:0x0112, B:53:0x0118, B:67:0x01a8, B:55:0x0158, B:58:0x0160, B:61:0x0168, B:63:0x0195, B:66:0x019d, B:29:0x0088, B:31:0x00a9, B:33:0x00af, B:36:0x00bb, B:39:0x00c3, B:40:0x00d8, B:42:0x00e3, B:91:0x02ea, B:26:0x0076), top: B:139:0x0076 }] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x02c0  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x02c9 A[Catch: all -> 0x005c, Exception -> 0x03ec, TryCatch #1 {Exception -> 0x03ec, blocks: (B:94:0x0305, B:96:0x030f, B:98:0x0316, B:100:0x031c, B:102:0x0322, B:122:0x03a2, B:124:0x03c1, B:125:0x03c8, B:127:0x03ce, B:104:0x0362, B:108:0x036c, B:110:0x0374, B:112:0x037a, B:114:0x0382, B:115:0x0386, B:117:0x038c, B:119:0x0394, B:121:0x039a, B:70:0x01f7, B:72:0x022b, B:74:0x0232, B:76:0x0242, B:78:0x0248, B:79:0x02b5, B:81:0x02bb, B:83:0x02c1, B:85:0x02c9, B:86:0x02cd, B:88:0x02d3, B:90:0x02d9, B:45:0x00fb, B:47:0x0105, B:49:0x010c, B:51:0x0112, B:53:0x0118, B:67:0x01a8, B:55:0x0158, B:58:0x0160, B:61:0x0168, B:63:0x0195, B:66:0x019d, B:29:0x0088, B:31:0x00a9, B:33:0x00af, B:36:0x00bb, B:39:0x00c3, B:40:0x00d8, B:42:0x00e3, B:91:0x02ea, B:26:0x0076), top: B:139:0x0076 }] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x02cd A[Catch: all -> 0x005c, Exception -> 0x03ec, TryCatch #1 {Exception -> 0x03ec, blocks: (B:94:0x0305, B:96:0x030f, B:98:0x0316, B:100:0x031c, B:102:0x0322, B:122:0x03a2, B:124:0x03c1, B:125:0x03c8, B:127:0x03ce, B:104:0x0362, B:108:0x036c, B:110:0x0374, B:112:0x037a, B:114:0x0382, B:115:0x0386, B:117:0x038c, B:119:0x0394, B:121:0x039a, B:70:0x01f7, B:72:0x022b, B:74:0x0232, B:76:0x0242, B:78:0x0248, B:79:0x02b5, B:81:0x02bb, B:83:0x02c1, B:85:0x02c9, B:86:0x02cd, B:88:0x02d3, B:90:0x02d9, B:45:0x00fb, B:47:0x0105, B:49:0x010c, B:51:0x0112, B:53:0x0118, B:67:0x01a8, B:55:0x0158, B:58:0x0160, B:61:0x0168, B:63:0x0195, B:66:0x019d, B:29:0x0088, B:31:0x00a9, B:33:0x00af, B:36:0x00bb, B:39:0x00c3, B:40:0x00d8, B:42:0x00e3, B:91:0x02ea, B:26:0x0076), top: B:139:0x0076 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r35) {
            /*
                Method dump skipped, instructions count: 1063
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui._base.BaseFragment.C08531.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void submitLoginBySocialAccount(String userId, String accessToken, RegisterType registerType, String email) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08531(this, registerType, userId, accessToken, email, null), 3, null);
    }

    public static /* synthetic */ void loginFacebook$default(BaseFragment baseFragment, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginFacebook");
        }
        if ((i & 1) != 0) {
            str = "";
        }
        baseFragment.loginFacebook(str);
    }

    public final void loginFacebook(String accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        if (Intrinsics.areEqual(accessToken, "")) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08481(this, accessToken, null), 3, null);
    }

    /* compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "VB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._base.BaseFragment$loginFacebook$1", f = "BaseFragment.kt", i = {}, l = {WinError.ERROR_LOGON_SESSION_EXISTS}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui._base.BaseFragment$loginFacebook$1, reason: invalid class name and case insensitive filesystem */
    static final class C08481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accessToken;
        int label;
        final /* synthetic */ BaseFragment<VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08481(BaseFragment<VB> baseFragment, String str, Continuation<? super C08481> continuation) {
            super(2, continuation);
            this.this$0 = baseFragment;
            this.$accessToken = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08481(this.this$0, this.$accessToken, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            LoginUserData data;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Timber.INSTANCE.d("Facebook login", new Object[0]);
                        this.this$0.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callLoginByFacebook(new LoginByFacebookApiData.RequestBodyData(this.$accessToken, AppConfig.INSTANCE.getPUSH_MESSAGE_TOKEN()), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Response response = (Response) obj;
                    Timber.INSTANCE.d("loginFacebookRes Body: " + response, new Object[0]);
                    this.this$0.stopLoading();
                    LoginByFacebookApiData.ResponseData responseData = (LoginByFacebookApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("loginFacebookBody: " + responseData, new Object[0]);
                    if (responseData != null && responseData.getSuccess()) {
                        MySharedPreferences.INSTANCE.getInstance().clearOldLoginToken();
                        AppConfigKt.setSessionId(response.headers().get("sessionid"));
                        LoginByEmailApiData.DataMap dataMap = responseData.getDataMap();
                        AppConfigKt.setServiceLoginToken(dataMap != null ? dataMap.getServiceLoginToken() : null);
                        Timber.INSTANCE.d("loginSFacebookBody: 登入成功!", new Object[0]);
                        LoginByEmailApiData.DataMap dataMap2 = responseData.getDataMap();
                        if (dataMap2 != null && (data = dataMap2.getData()) != null) {
                            this.this$0.saveLoginData(data);
                            Timber.INSTANCE.d("儲存userData:" + data, new Object[0]);
                        }
                        LoginByEmailApiData.DataMap dataMap3 = responseData.getDataMap();
                        MySharedPreferences.INSTANCE.getInstance().setSharedLoginToken(dataMap3 != null ? dataMap3.getLoginToken() : null);
                        Timber.INSTANCE.d("now save token: " + MySharedPreferences.INSTANCE.getInstance().getSharedLoginToken(), new Object[0]);
                        if (this.this$0.isAdded()) {
                            this.this$0.setUserAppLanguage();
                            BaseFragment.safeNavigateAndClearStack$default(this.this$0, R.id.homeMainFragment, null, 2, null);
                        }
                    } else {
                        String errorCode = responseData != null ? responseData.getErrorCode() : null;
                        if (this.this$0.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.USER_NOT_FOUND_1003.getId(), Boxing.boxInt(R.string.err_1003_user_not_found)), TuplesKt.to(ErrorCode.USER_HAS_BEEN_DISABLED_1019.getId(), Boxing.boxInt(R.string.err_1019_user_has_been_disabled))).get(errorCode);
                        if (num != null) {
                            BaseFragment<VB> baseFragment = this.this$0;
                            CustomDialogKt.showCustomDialog$default(baseFragment, baseFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                        } else {
                            BaseFragment.handleUndefinedError$default(this.this$0, "loginFacebook", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                        }
                    }
                } catch (IOException e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(this.this$0, "loginFacebook", message, false, 4, null);
                }
                this.this$0.stopLoading();
                return Unit.INSTANCE;
            } finally {
                this.this$0.stopLoading();
            }
        }
    }

    public static /* synthetic */ void loginGoogle$default(BaseFragment baseFragment, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginGoogle");
        }
        if ((i & 1) != 0) {
            str = "";
        }
        baseFragment.loginGoogle(str);
    }

    public final void loginGoogle(String idToken) {
        Intrinsics.checkNotNullParameter(idToken, "idToken");
        if (Intrinsics.areEqual(idToken, "")) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08491(this, idToken, null), 3, null);
    }

    /* compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "VB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._base.BaseFragment$loginGoogle$1", f = "BaseFragment.kt", i = {}, l = {WinError.ERROR_HOOK_TYPE_NOT_ALLOWED}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui._base.BaseFragment$loginGoogle$1, reason: invalid class name and case insensitive filesystem */
    static final class C08491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $idToken;
        int label;
        final /* synthetic */ BaseFragment<VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08491(BaseFragment<VB> baseFragment, String str, Continuation<? super C08491> continuation) {
            super(2, continuation);
            this.this$0 = baseFragment;
            this.$idToken = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08491(this.this$0, this.$idToken, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            LoginUserData data;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Timber.INSTANCE.d("Google login", new Object[0]);
                        this.this$0.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callLoginByGoogle(new LoginByGoogleApiData.RequestBodyData(this.$idToken, AppConfig.INSTANCE.getPUSH_MESSAGE_TOKEN()), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Response response = (Response) obj;
                    Timber.INSTANCE.d("loginGoogleRes Body: " + response, new Object[0]);
                    this.this$0.stopLoading();
                    LoginByGoogleApiData.ResponseData responseData = (LoginByGoogleApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("loginGoogleBody: " + responseData, new Object[0]);
                    if (responseData != null && responseData.getSuccess()) {
                        MySharedPreferences.INSTANCE.getInstance().clearOldLoginToken();
                        AppConfigKt.setSessionId(response.headers().get("sessionid"));
                        LoginByEmailApiData.DataMap dataMap = responseData.getDataMap();
                        AppConfigKt.setServiceLoginToken(dataMap != null ? dataMap.getServiceLoginToken() : null);
                        Timber.INSTANCE.d("loginSGoogleBody: 登入成功!", new Object[0]);
                        LoginByEmailApiData.DataMap dataMap2 = responseData.getDataMap();
                        if (dataMap2 != null && (data = dataMap2.getData()) != null) {
                            this.this$0.saveLoginData(data);
                            Timber.INSTANCE.d("儲存userData:" + data, new Object[0]);
                        }
                        LoginByEmailApiData.DataMap dataMap3 = responseData.getDataMap();
                        MySharedPreferences.INSTANCE.getInstance().setSharedLoginToken(dataMap3 != null ? dataMap3.getLoginToken() : null);
                        Timber.INSTANCE.d("now save token: " + MySharedPreferences.INSTANCE.getInstance().getSharedLoginToken(), new Object[0]);
                        if (this.this$0.isAdded()) {
                            this.this$0.setUserAppLanguage();
                            BaseFragment.safeNavigateAndClearStack$default(this.this$0, R.id.homeMainFragment, null, 2, null);
                        }
                    } else {
                        String errorCode = responseData != null ? responseData.getErrorCode() : null;
                        if (this.this$0.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.USER_NOT_FOUND_1003.getId(), Boxing.boxInt(R.string.err_1003_user_not_found)), TuplesKt.to(ErrorCode.USER_HAS_BEEN_DISABLED_1019.getId(), Boxing.boxInt(R.string.err_1019_user_has_been_disabled)), TuplesKt.to(ErrorCode.GOOGLE_VERIFY_RESULT_INVALID_ID_TOKEN_1103.getId(), null), TuplesKt.to(ErrorCode.GOOGLE_VERIFY_RESULT_GENERAL_SECURITY_EXCEPTION_1104.getId(), null), TuplesKt.to(ErrorCode.INVALID_JWT_FORMAT_1207.getId(), null)).get(errorCode);
                        if (num != null) {
                            BaseFragment<VB> baseFragment = this.this$0;
                            CustomDialogKt.showCustomDialog$default(baseFragment, baseFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                        } else {
                            BaseFragment.handleUndefinedError$default(this.this$0, "loginGoogle", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                        }
                    }
                } catch (IOException e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(this.this$0, "loginGoogle", message, false, 4, null);
                }
                this.this$0.stopLoading();
                return Unit.INSTANCE;
            } finally {
                this.this$0.stopLoading();
            }
        }
    }

    public final void saveLoginData(LoginUserData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String globalUserUuid = data.getGlobalUserUuid();
        String str = globalUserUuid == null ? "" : globalUserUuid;
        String userUuid = data.getUserUuid();
        String str2 = userUuid == null ? "" : userUuid;
        String loginName = data.getLoginName();
        String str3 = loginName == null ? "" : loginName;
        String photoFileUrl = data.getPhotoFileUrl();
        String avatarId = data.getAvatarId();
        Integer registerType = data.getRegisterType();
        Integer numValueOf = Integer.valueOf(registerType != null ? registerType.intValue() : RegisterType.Email.getId());
        String email = data.getEmail();
        String str4 = email == null ? "" : email;
        String birthDate = data.getBirthDate();
        String str5 = birthDate == null ? "" : birthDate;
        String gender = data.getGender();
        if (gender == null) {
            gender = GenderType.Male.getId();
        }
        String str6 = gender;
        String firstName = data.getFirstName();
        String str7 = firstName == null ? "" : firstName;
        String lastName = data.getLastName();
        String str8 = lastName == null ? "" : lastName;
        String displayName = data.getDisplayName();
        String str9 = displayName == null ? "" : displayName;
        String weight = data.getWeight();
        String str10 = weight == null ? "" : weight;
        Integer measurementUnit = data.getMeasurementUnit();
        Integer numValueOf2 = Integer.valueOf(measurementUnit != null ? measurementUnit.intValue() : UnitSettings.M.getId());
        String height = data.getHeight();
        MySharedPreferences.INSTANCE.getInstance().setUserData(new LoginUserData(str, str2, str3, photoFileUrl, avatarId, numValueOf, str4, str5, str6, str7, str8, str9, str10, numValueOf2, height == null ? "" : height, data.getEnabledPreferenceItems()));
        Global global = Global.INSTANCE;
        Global.userData = data;
    }

    public final void resetLoginData() {
        MySharedPreferences.INSTANCE.getInstance().resetUserData();
        Global global = Global.INSTANCE;
        Global.userData = null;
    }

    public final List<BleDeviceInfoData> getBleDevice() {
        BleDeviceInfoDao bleDeviceInfoDao;
        LoginUserData loginUserData;
        ArrayList arrayList = new ArrayList();
        if (BleManager.getInstance().getBleDeviceInfoDatabase() != null) {
            List<BleDeviceInfoEntity> all = null;
            try {
                loginUserData = Global.userData;
            } catch (Exception e) {
                Timber.INSTANCE.e(e.fillInStackTrace());
            }
            String userUuid = loginUserData != null ? loginUserData.getUserUuid() : null;
            if (userUuid == null) {
                userUuid = "";
            }
            try {
                BleDeviceInfoDatabase bleDeviceInfoDatabase = BleManager.getInstance().getBleDeviceInfoDatabase();
                if (bleDeviceInfoDatabase != null && (bleDeviceInfoDao = bleDeviceInfoDatabase.bleDeviceInfoDao()) != null) {
                    all = bleDeviceInfoDao.getAll(userUuid);
                }
            } catch (Exception e2) {
                Timber.INSTANCE.e(e2.fillInStackTrace());
            }
            if (all != null && all.size() > 0) {
                for (BleDeviceInfoEntity bleDeviceInfoEntity : all) {
                    if (bleDeviceInfoEntity != null) {
                        BleDeviceInfoData bleDeviceInfoData = new BleDeviceInfoData(bleDeviceInfoEntity.getBleName(), bleDeviceInfoEntity.getAddress(), Boolean.valueOf(bleDeviceInfoEntity.isHasAdv0x16()));
                        if (bleDeviceInfoEntity.getMachineType02() != null) {
                            bleDeviceInfoData.setMachineType(bleDeviceInfoEntity.getMachineType02());
                        }
                        if (bleDeviceInfoEntity.getMachineType02() != MachineType.HR) {
                            bleDeviceInfoData.setBleDeviceListType(BleDeviceListType.MY_DEVICES);
                            arrayList.add(bleDeviceInfoData);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateUserInfo$default(BaseFragment baseFragment, UpdateMyUserInfoApiData.RequestBodyData requestBodyData, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateUserInfo");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        baseFragment.updateUserInfo(requestBodyData, function0);
    }

    /* compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "VB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._base.BaseFragment$updateUserInfo$1", f = "BaseFragment.kt", i = {}, l = {WinError.ERROR_PATCH_PACKAGE_UNSUPPORTED}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui._base.BaseFragment$updateUserInfo$1, reason: invalid class name and case insensitive filesystem */
    static final class C08541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UpdateMyUserInfoApiData.RequestBodyData $newUserData;
        final /* synthetic */ Function0<Unit> $onSuccess;
        int label;
        final /* synthetic */ BaseFragment<VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08541(BaseFragment<VB> baseFragment, UpdateMyUserInfoApiData.RequestBodyData requestBodyData, Function0<Unit> function0, Continuation<? super C08541> continuation) {
            super(2, continuation);
            this.this$0 = baseFragment;
            this.$newUserData = requestBodyData;
            this.$onSuccess = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08541(this.this$0, this.$newUserData, this.$onSuccess, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallUpdateMyUserInfo;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Timber.INSTANCE.d("UpdateUserInfo", new Object[0]);
                        this.this$0.showLoading();
                        this.label = 1;
                        objCallUpdateMyUserInfo = DyacoApiKt.callUpdateMyUserInfo(new UpdateMyUserInfoApiData.RequestBodyData(this.$newUserData.getDisplayName(), this.$newUserData.getBirthDate(), this.$newUserData.getGender(), this.$newUserData.getFirstName(), this.$newUserData.getLastName(), this.$newUserData.getWeight(), this.$newUserData.getHeight()), this);
                        if (objCallUpdateMyUserInfo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallUpdateMyUserInfo = obj;
                    }
                    Response response = (Response) objCallUpdateMyUserInfo;
                    Timber.INSTANCE.d("UpdateUserInfo Body: " + response, new Object[0]);
                    UpdateMyUserInfoApiData.ResponseData responseData = (UpdateMyUserInfoApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("UpdateUserInfo: " + responseData, new Object[0]);
                    if (responseData != null && responseData.getSuccess()) {
                        Timber.INSTANCE.d("UpdateUserInfo success", new Object[0]);
                        LoginUserData loginUserData = Global.userData;
                        if (loginUserData != null) {
                            UpdateMyUserInfoApiData.RequestBodyData requestBodyData = this.$newUserData;
                            BaseFragment<VB> baseFragment = this.this$0;
                            String displayName = requestBodyData.getDisplayName();
                            if (displayName != null) {
                                loginUserData.setDisplayName(displayName);
                            }
                            String birthDate = requestBodyData.getBirthDate();
                            if (birthDate != null) {
                                loginUserData.setBirthDate(birthDate);
                            }
                            Integer gender = requestBodyData.getGender();
                            if (gender != null) {
                                loginUserData.setGender(String.valueOf(gender.intValue()));
                            }
                            String firstName = requestBodyData.getFirstName();
                            if (firstName != null) {
                                loginUserData.setFirstName(firstName);
                            }
                            String lastName = requestBodyData.getLastName();
                            if (lastName != null) {
                                loginUserData.setLastName(lastName);
                            }
                            String weight = requestBodyData.getWeight();
                            if (weight != null) {
                                loginUserData.setWeight(weight);
                            }
                            String height = requestBodyData.getHeight();
                            if (height != null) {
                                loginUserData.setHeight(height);
                            }
                            baseFragment.saveLoginData(loginUserData);
                            Timber.INSTANCE.d("now user data: " + MySharedPreferences.INSTANCE.getInstance().getUserData(), new Object[0]);
                        }
                        Function0<Unit> function0 = this.$onSuccess;
                        if (function0 != null) {
                            function0.invoke();
                        }
                    } else {
                        String errorCode = responseData != null ? responseData.getErrorCode() : null;
                        if (this.this$0.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), null), TuplesKt.to(ErrorCode.INVALID_DATE_FORMAT_1046.getId(), Boxing.boxInt(R.string.err_1046_invalid_date_format))).get(errorCode);
                        if (num != null) {
                            BaseFragment<VB> baseFragment2 = this.this$0;
                            CustomDialogKt.showCustomDialog$default(baseFragment2, baseFragment2.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                        } else {
                            BaseFragment.handleUndefinedError$default(this.this$0, "updateUserInfo", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                        }
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e("API call failed: updateUserInfo:" + e, new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(this.this$0, "updateUserInfo", message, false, 4, null);
                }
                this.this$0.stopLoading();
                return Unit.INSTANCE;
            } finally {
                this.this$0.stopLoading();
            }
        }
    }

    public final void updateUserInfo(UpdateMyUserInfoApiData.RequestBodyData newUserData, Function0<Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(newUserData, "newUserData");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08541(this, newUserData, onSuccess, null), 3, null);
    }

    protected final void setStatusBarViewHeight(View statusBarView) {
        Intrinsics.checkNotNullParameter(statusBarView, "statusBarView");
        ViewGroup.LayoutParams layoutParams = statusBarView.getLayoutParams();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        layoutParams.height = UiTool.getStatusBarHeight(fragmentActivityRequireActivity);
        statusBarView.requestLayout();
    }

    public final String getLanguage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.locale_code);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = lowerCase;
        if (TextUtils.equals(str, "zh_tw") || TextUtils.equals(str, "zh-tw")) {
            String string2 = context.getString(R.string.traditional_chinese);
            Intrinsics.checkNotNull(string2);
            return string2;
        }
        if (TextUtils.equals(str, "zh_cn") || TextUtils.equals(str, "zh-cn")) {
            String string3 = context.getString(R.string.simplified_chinese);
            Intrinsics.checkNotNull(string3);
            return string3;
        }
        if (TextUtils.equals(str, "de")) {
            String string4 = context.getString(R.string.german);
            Intrinsics.checkNotNull(string4);
            return string4;
        }
        if (TextUtils.equals(str, "es")) {
            String string5 = context.getString(R.string.spanish);
            Intrinsics.checkNotNull(string5);
            return string5;
        }
        if (TextUtils.equals(str, "fr")) {
            String string6 = context.getString(R.string.french);
            Intrinsics.checkNotNull(string6);
            return string6;
        }
        if (TextUtils.equals(str, "ru")) {
            String string7 = context.getString(R.string.russian);
            Intrinsics.checkNotNull(string7);
            return string7;
        }
        if (TextUtils.equals(str, "ja")) {
            String string8 = context.getString(R.string.japanese);
            Intrinsics.checkNotNull(string8);
            return string8;
        }
        String string9 = context.getString(R.string.english);
        Intrinsics.checkNotNull(string9);
        return string9;
    }

    public final void showSharePopupWithCustomLayout(Context context, View anchorView, List<Pair<String, Integer>> items, final Function1<? super Integer, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(24.0f);
        gradientDrawable.setColor(ContextCompat.getColor(context, R.color.colorGlobal_gray_overlay40));
        linearLayout.setBackground(gradientDrawable);
        final PopupWindow popupWindow = new PopupWindow((View) linearLayout, -2, -2, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setElevation(10.0f);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        final int i = 0;
        for (Object obj : items) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            View viewInflate = layoutInflaterFrom.inflate(R.layout.popup_item_layout, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tvText);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imgIcon);
            textView.setText((CharSequence) pair.getFirst());
            imageView.setImageResource(((Number) pair.getSecond()).intValue());
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseFragment.showSharePopupWithCustomLayout$lambda$31$lambda$30(onItemClick, i, popupWindow, view);
                }
            });
            linearLayout.addView(viewInflate);
            i = i2;
        }
        linearLayout.measure(0, 0);
        int measuredHeight = linearLayout.getMeasuredHeight();
        int[] iArr = new int[2];
        anchorView.getLocationOnScreen(iArr);
        popupWindow.showAtLocation(anchorView, 0, iArr[0], iArr[1] - measuredHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSharePopupWithCustomLayout$lambda$31$lambda$30(Function1 onItemClick, int i, PopupWindow popupWindow, View view) {
        Intrinsics.checkNotNullParameter(onItemClick, "$onItemClick");
        Intrinsics.checkNotNullParameter(popupWindow, "$popupWindow");
        onItemClick.invoke(Integer.valueOf(i));
        popupWindow.dismiss();
    }

    protected final void setupTermsText(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        String string = getString(R.string.privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.terms_of_use);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(R.string.terms_agreement, string, string2);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(R.string.privacy_policy_url);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = getString(R.string.termof_use_url);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        textView.setText(createClickableText(string3, CollectionsKt.listOf((Object[]) new ClickableTextData[]{new ClickableTextData(string, string4), new ClickableTextData(string2, string5)})));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final SpannableString createClickableText(String fullText, List<ClickableTextData> clickableTexts) {
        String str = fullText;
        SpannableString spannableString = new SpannableString(str);
        for (final ClickableTextData clickableTextData : clickableTexts) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, clickableTextData.getText(), 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                spannableString.setSpan(new ClickableSpan(this) { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$createClickableText$1$clickableSpan$1
                    final /* synthetic */ BaseFragment<VB> this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(View widget) {
                        Intrinsics.checkNotNullParameter(widget, "widget");
                        this.this$0.openUrl(clickableTextData.getUrl());
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint ds) {
                        Intrinsics.checkNotNullParameter(ds, "ds");
                        super.updateDrawState(ds);
                        ds.setColor(ContextCompat.getColor(this.this$0.requireContext(), R.color.colorPalette_red));
                        ds.setUnderlineText(false);
                    }
                }, iIndexOf$default, clickableTextData.getText().length() + iIndexOf$default, 33);
            }
        }
        return spannableString;
    }

    protected final void openUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        } catch (Exception unused) {
            Toast.makeText(requireContext(), "Link is not available", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment$ClickableTextData;", "", "text", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    static final /* data */ class ClickableTextData {
        private final String text;
        private final String url;

        public static /* synthetic */ ClickableTextData copy$default(ClickableTextData clickableTextData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = clickableTextData.text;
            }
            if ((i & 2) != 0) {
                str2 = clickableTextData.url;
            }
            return clickableTextData.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final ClickableTextData copy(String text, String url) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(url, "url");
            return new ClickableTextData(text, url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClickableTextData)) {
                return false;
            }
            ClickableTextData clickableTextData = (ClickableTextData) other;
            return Intrinsics.areEqual(this.text, clickableTextData.text) && Intrinsics.areEqual(this.url, clickableTextData.url);
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.url.hashCode();
        }

        public String toString() {
            return "ClickableTextData(text=" + this.text + ", url=" + this.url + ')';
        }

        public ClickableTextData(String text, String url) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(url, "url");
            this.text = text;
            this.url = url;
        }

        public final String getText() {
            return this.text;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "VB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._base.BaseFragment$getBanner$1", f = "BaseFragment.kt", i = {}, l = {1892}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui._base.BaseFragment$getBanner$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BaseFragment<VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseFragment<VB> baseFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = baseFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = JwtNotificationDyacoApiKt.callGetBanner(new BannerApiData.RequestBodyData(), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                BannerApiData.ResponseData responseData = (BannerApiData.ResponseData) ((Response) obj).body();
                if (Intrinsics.areEqual(responseData != null ? responseData.getCode() : null, "200")) {
                    Timber.INSTANCE.e("getBanner CODE_SUCCESS", new Object[0]);
                    BannerApiData.BannerResult result = responseData.getResult();
                    if (result != null ? Intrinsics.areEqual(result.is_display_banner(), Boxing.boxBoolean(true)) : false) {
                        Timber.INSTANCE.e("getBanner is_display_banner true", new Object[0]);
                        this.this$0.getUiViewModel().setBannerData(result);
                        BaseFragment.safeNavigate$default(this.this$0, R.id.bannerFragment, null, 2, null);
                    }
                } else {
                    String code = responseData != null ? responseData.getCode() : null;
                    if (this.this$0.shouldIgnoreError(code)) {
                        return Unit.INSTANCE;
                    }
                    BaseFragment.handleUndefinedError$default(this.this$0, "getBanner", code, responseData != null ? responseData.getMessage() : null, false, 8, null);
                }
            } catch (Exception e) {
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                BaseFragment.handleApiError$default(this.this$0, "getBanner", message, false, 4, null);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getBanner() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void setUserAppLanguage() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                BaseFragment.setUserAppLanguage$lambda$33();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUserAppLanguage$lambda$33() {
        String loginUuid = Global.getLoginUuid();
        if (loginUuid == null) {
            loginUuid = "";
        }
        Locale locale = new Locale(MySharedPreferences.INSTANCE.getInstance().getAppLanguage(loginUuid));
        String country = locale.getCountry();
        if (country == null || country.length() == 0) {
            locale = new Locale(locale.getLanguage(), Locale.getDefault().getCountry());
        }
        LocaleListCompat localeListCompatForLanguageTags = LocaleListCompat.forLanguageTags(locale.toLanguageTag());
        Intrinsics.checkNotNullExpressionValue(localeListCompatForLanguageTags, "forLanguageTags(...)");
        AppCompatDelegate.setApplicationLocales(localeListCompatForLanguageTags);
    }
}
