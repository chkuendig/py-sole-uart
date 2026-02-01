package com.soletreadmills.sole_v2.ui.club;

import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
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
import androidx.appcompat.widget.AppCompatButton;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.blankj.utilcode.constant.CacheConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.gson.GsonBuilder;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.club.CreateChallengeApiData;
import com.soletreadmills.sole_v2._data.api.club.UpdateChallengeApiData;
import com.soletreadmills.sole_v2._data.api.club.UpdateChallengeCoverPhotoApiData;
import com.soletreadmills.sole_v2._data.club.ChallengeActivityStatus;
import com.soletreadmills.sole_v2._data.club.ChallengeEditModeTypeSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeFormData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemFullData;
import com.soletreadmills.sole_v2._data.club.ChallengeMachineTypeItems;
import com.soletreadmills.sole_v2._data.club.ChallengePrivacyLevelSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings;
import com.soletreadmills.sole_v2._data.club.VirtualRaceCodeType;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2.databinding.FragmentClubEditFormBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubEditMachineTypeAdapter;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubEditPrivacyAdapter;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubEditRaceDistanceItemAdapter;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubEditScoreItemAdapter;
import com.sun.jna.platform.win32.WinError;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ClubEditFormFragment.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0007\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001vB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010*\u001a\u00020!H\u0002J\u001a\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000eH\u0002J\u0010\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000eH\u0002J\u0010\u00104\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000eH\u0002J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0002J\b\u00108\u001a\u00020)H\u0002J\b\u00109\u001a\u000206H\u0002J\u0010\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020<H\u0002J \u0010=\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020!H\u0002J\u001f\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010>\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010CJ\u001f\u0010D\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010>\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010CJ\u001a\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010J\u001a\u000206H\u0016J\u0012\u0010K\u001a\u0002062\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0012\u0010N\u001a\u0002062\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u000206H\u0016J\b\u0010R\u001a\u000206H\u0002J\b\u0010S\u001a\u000206H\u0002J\u0010\u0010T\u001a\u0002062\u0006\u0010U\u001a\u00020\u0010H\u0002J\u0010\u0010V\u001a\u0002062\u0006\u0010W\u001a\u00020\u0010H\u0002J*\u0010X\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020-2\u0006\u0010Y\u001a\u00020#2\u0006\u0010Z\u001a\u00020\u00102\u0006\u0010[\u001a\u00020\u0010H\u0002J\u0019\u0010\\\u001a\u0002062\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010^J\u0019\u0010_\u001a\u0002062\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010^J\u0012\u0010`\u001a\u0002062\b\b\u0002\u0010]\u001a\u00020\u0010H\u0002J\u0012\u0010a\u001a\u0002062\b\b\u0002\u0010]\u001a\u00020\u000eH\u0002J\b\u0010b\u001a\u000206H\u0002J\b\u0010c\u001a\u000206H\u0002J\u001c\u0010d\u001a\u00020\u000e2\b\u0010e\u001a\u0004\u0018\u00010f2\b\b\u0002\u0010g\u001a\u00020\u000eH\u0002J\u0012\u0010h\u001a\u0002062\b\b\u0002\u0010]\u001a\u00020\u0010H\u0002J\u0010\u0010i\u001a\u0002062\u0006\u0010j\u001a\u00020!H\u0002J\b\u0010k\u001a\u000206H\u0002J\u0017\u0010l\u001a\u0002062\b\u0010]\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010^J\u0012\u0010m\u001a\u0002062\b\u0010Y\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010n\u001a\u0002062\u0006\u0010]\u001a\u00020\u0010H\u0002J\u0010\u0010o\u001a\u0002062\u0006\u0010]\u001a\u00020\u000eH\u0002J\u0010\u0010p\u001a\u0002062\u0006\u0010q\u001a\u00020\u0010H\u0002J\b\u0010r\u001a\u000206H\u0002J\u0018\u0010s\u001a\u0002062\u0006\u0010t\u001a\u00020#2\u0006\u0010u\u001a\u00020\u000eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006w"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubEditFormFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentClubEditFormBinding;", "Landroid/view/View$OnClickListener;", "()V", "adapter1", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditScoreItemAdapter;", "adapter2", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditMachineTypeAdapter;", "adapter3", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditPrivacyAdapter;", "adapter4", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditRaceDistanceItemAdapter;", "argChallengeId", "", "argChallengeTypeId", "", "argPageEditMode", "cameraPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "challengeDateCount", "getChallengeDateCount", "()I", "setChallengeDateCount", "(I)V", "clubViewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "getClubViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "clubViewModel$delegate", "Lkotlin/Lazy;", "currentPhotoPath", "isCreateBinding", "", "photoUri", "Landroid/net/Uri;", "pickMedia", "Landroidx/activity/result/PickVisualMediaRequest;", "takePictureLauncher", "Landroid/content/Intent;", "tempResizeImgFile", "Ljava/io/File;", "allPermissionsGranted", "bitmapToTempFile", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", SdkConstants.TAG_BITMAP, "Landroid/graphics/Bitmap;", "convertFromDisplayFormat", "displayDate", "convertToDisplayFormat", "isoDate", "convertToDisplayFormatSpecialText", "createChallenge", "", "createForm", "createImageFile", "editSaveForm", "examineForm", "data", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeFormData;", "getFormUnitText", "scoreItem", "isImperial", "getLoadScoreValText", "", "currentScore", "(Ljava/lang/Double;I)D", "getUploadScoreVal", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "openCamera", "resetAll", "resetFocusValueInput", "nowScoreItem", "resetMachineTypeId", "itemScore", "resizeImageWithGlide", "uri", "targetWidth", "targetHeight", "setupEditMachineTypeRecyclerView", "activeId", "(Ljava/lang/Integer;)V", "setupEditPrivacyRecyclerView", "setupEditScoreItemRecyclerView", "setupEditVirtualRaceDistanceRecyclerView", "showEndDatePicker", "showStartDatePicker", "toText", "text", "", "defaultText", "updateActiveScoreItem", "updateChallenge", "isNewImg", "updateDateCount", "updateMachineType", "updatePreviewImage", "updatePrivacy", "updateRaceDistance", "updateRaceList", "machineTypeId", "updateStartEndDate", "uploadCoverImage", "imageUri", "challengeUuid", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubEditFormFragment extends BaseFragment<FragmentClubEditFormBinding> implements View.OnClickListener {
    private static final String ARG_CHALLENGE_ID = "challenge_id";
    private static final String ARG_CHALLENGE_TYPE = "challenge_type_id";
    private static final String ARG_PAGE_EDIT_MODE_ID = "page_mode_id";
    private ClubEditScoreItemAdapter adapter1;
    private ClubEditMachineTypeAdapter adapter2;
    private ClubEditPrivacyAdapter adapter3;
    private ClubEditRaceDistanceItemAdapter adapter4;
    private String argChallengeId;
    private int argChallengeTypeId;
    private int argPageEditMode;
    private ActivityResultLauncher<String> cameraPermissionLauncher;
    private int challengeDateCount = 30;

    /* renamed from: clubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy clubViewModel;
    private String currentPhotoPath;
    private boolean isCreateBinding;
    private Uri photoUri;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMedia;
    private ActivityResultLauncher<Intent> takePictureLauncher;
    private File tempResizeImgFile;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public ClubEditFormFragment() {
        final ClubEditFormFragment clubEditFormFragment = this;
        final Function0 function0 = null;
        this.clubViewModel = FragmentViewModelLazyKt.createViewModelLazy(clubEditFormFragment, Reflection.getOrCreateKotlinClass(ClubViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubEditFormFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = clubEditFormFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubEditFormFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentClubEditFormBinding access$getBinding(ClubEditFormFragment clubEditFormFragment) {
        return clubEditFormFragment.getBinding();
    }

    /* compiled from: ClubEditFormFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubEditFormFragment$Companion;", "", "()V", "ARG_CHALLENGE_ID", "", "ARG_CHALLENGE_TYPE", "ARG_PAGE_EDIT_MODE_ID", "newInstance", "Lcom/soletreadmills/sole_v2/ui/club/ClubEditFormFragment;", "argPageEditMode", "", "argChallengeTypeId", "argChallengeId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ClubEditFormFragment newInstance$default(Companion companion, int i, int i2, String str, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = null;
            }
            return companion.newInstance(i, i2, str);
        }

        public final ClubEditFormFragment newInstance(int argPageEditMode, int argChallengeTypeId, String argChallengeId) {
            ClubEditFormFragment clubEditFormFragment = new ClubEditFormFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ClubEditFormFragment.ARG_PAGE_EDIT_MODE_ID, argPageEditMode);
            bundle.putInt(ClubEditFormFragment.ARG_CHALLENGE_TYPE, argChallengeTypeId);
            bundle.putString(ClubEditFormFragment.ARG_CHALLENGE_ID, argChallengeId);
            clubEditFormFragment.setArguments(bundle);
            return clubEditFormFragment;
        }
    }

    public final ClubViewModel getClubViewModel() {
        return (ClubViewModel) this.clubViewModel.getValue();
    }

    public final int getChallengeDateCount() {
        return this.challengeDateCount;
    }

    public final void setChallengeDateCount(int i) {
        this.challengeDateCount = i;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentClubEditFormBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClubEditFormBinding fragmentClubEditFormBindingInflate = FragmentClubEditFormBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentClubEditFormBindingInflate, "inflate(...)");
        return fragmentClubEditFormBindingInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.argPageEditMode = arguments.getInt(ARG_PAGE_EDIT_MODE_ID);
            this.argChallengeTypeId = arguments.getInt(ARG_CHALLENGE_TYPE);
            this.argChallengeId = arguments.getString(ARG_CHALLENGE_ID);
        }
        Timber.INSTANCE.d("argPageEditMode: " + this.argPageEditMode, new Object[0]);
        Timber.INSTANCE.d("argChallengeTypeId: " + this.argChallengeTypeId, new Object[0]);
        Timber.INSTANCE.d("argChallengeId: " + this.argChallengeId, new Object[0]);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        final ChallengeItemFullData value;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        EditText editText6;
        AppCompatButton appCompatButton;
        TextView textView;
        AppCompatButton appCompatButton2;
        TextView textView2;
        EditText editText7;
        EditText editText8;
        EditText editText9;
        ImageView imageView;
        ImageView imageView2;
        EditText editText10;
        EditText editText11;
        ImageView imageView3;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView3;
        Integer onMachineType;
        Integer onMachineType2;
        ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda9
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ClubEditFormFragment.initViews$lambda$1(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.pickMedia = activityResultLauncherRegisterForActivityResult;
        this.takePictureLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda16
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ClubEditFormFragment.initViews$lambda$3(this.f$0, (ActivityResult) obj);
            }
        });
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda17
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ClubEditFormFragment.initViews$lambda$4(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.cameraPermissionLauncher = activityResultLauncherRegisterForActivityResult2;
        FragmentClubEditFormBinding binding = getBinding();
        LinearLayout linearLayout3 = binding != null ? binding.llPhotoWrap : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        FragmentClubEditFormBinding binding2 = getBinding();
        LinearLayout linearLayout4 = binding2 != null ? binding2.llRaceDateWrap : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        FragmentClubEditFormBinding binding3 = getBinding();
        LinearLayout linearLayout5 = binding3 != null ? binding3.llRaceDistanceWrap : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        FragmentClubEditFormBinding binding4 = getBinding();
        LinearLayout linearLayout6 = binding4 != null ? binding4.llTargetWrap : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        FragmentClubEditFormBinding binding5 = getBinding();
        LinearLayout linearLayout7 = binding5 != null ? binding5.llDatesWrap : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        int i = this.argChallengeTypeId;
        if (i == ChallengeTypeSettings.GOAL.getId()) {
            FragmentClubEditFormBinding binding6 = getBinding();
            LinearLayout linearLayout8 = binding6 != null ? binding6.llPhotoWrap : null;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(0);
            }
            FragmentClubEditFormBinding binding7 = getBinding();
            LinearLayout linearLayout9 = binding7 != null ? binding7.llTargetWrap : null;
            if (linearLayout9 != null) {
                linearLayout9.setVisibility(0);
            }
            FragmentClubEditFormBinding binding8 = getBinding();
            LinearLayout linearLayout10 = binding8 != null ? binding8.llDatesWrap : null;
            if (linearLayout10 != null) {
                linearLayout10.setVisibility(0);
            }
            if (this.argPageEditMode == ChallengeEditModeTypeSettings.CREATE.getId()) {
                FragmentClubEditFormBinding binding9 = getBinding();
                TextView textView4 = binding9 != null ? binding9.tvPageTitle : null;
                if (textView4 != null) {
                    textView4.setText(getString(R.string.new_shared_goal));
                }
            } else {
                FragmentClubEditFormBinding binding10 = getBinding();
                TextView textView5 = binding10 != null ? binding10.tvPageTitle : null;
                if (textView5 != null) {
                    textView5.setText(getString(R.string.edit_shared_goal));
                }
            }
        } else if (i == ChallengeTypeSettings.RANKING.getId()) {
            FragmentClubEditFormBinding binding11 = getBinding();
            LinearLayout linearLayout11 = binding11 != null ? binding11.llPhotoWrap : null;
            if (linearLayout11 != null) {
                linearLayout11.setVisibility(0);
            }
            FragmentClubEditFormBinding binding12 = getBinding();
            LinearLayout linearLayout12 = binding12 != null ? binding12.llTargetWrap : null;
            if (linearLayout12 != null) {
                linearLayout12.setVisibility(0);
            }
            FragmentClubEditFormBinding binding13 = getBinding();
            LinearLayout linearLayout13 = binding13 != null ? binding13.llDatesWrap : null;
            if (linearLayout13 != null) {
                linearLayout13.setVisibility(0);
            }
            FragmentClubEditFormBinding binding14 = getBinding();
            LinearLayout linearLayout14 = binding14 != null ? binding14.llTargetScoreWrap : null;
            if (linearLayout14 != null) {
                linearLayout14.setVisibility(8);
            }
            if (this.argPageEditMode == ChallengeEditModeTypeSettings.CREATE.getId()) {
                FragmentClubEditFormBinding binding15 = getBinding();
                TextView textView6 = binding15 != null ? binding15.tvPageTitle : null;
                if (textView6 != null) {
                    textView6.setText(getString(R.string.challenge_ranking));
                }
            } else {
                FragmentClubEditFormBinding binding16 = getBinding();
                TextView textView7 = binding16 != null ? binding16.tvPageTitle : null;
                if (textView7 != null) {
                    textView7.setText(getString(R.string.edit_ranking));
                }
            }
        } else if (i == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
            FragmentClubEditFormBinding binding17 = getBinding();
            TextView textView8 = binding17 != null ? binding17.tvPageTitle : null;
            if (textView8 != null) {
                textView8.setText(getString(R.string.virtual_race));
            }
            FragmentClubEditFormBinding binding18 = getBinding();
            LinearLayout linearLayout15 = binding18 != null ? binding18.llRaceDateWrap : null;
            if (linearLayout15 != null) {
                linearLayout15.setVisibility(0);
            }
            FragmentClubEditFormBinding binding19 = getBinding();
            LinearLayout linearLayout16 = binding19 != null ? binding19.llRaceDistanceWrap : null;
            if (linearLayout16 != null) {
                linearLayout16.setVisibility(0);
            }
            if (this.argPageEditMode == ChallengeEditModeTypeSettings.CREATE.getId()) {
                FragmentClubEditFormBinding binding20 = getBinding();
                TextView textView9 = binding20 != null ? binding20.tvPageTitle : null;
                if (textView9 != null) {
                    textView9.setText(getString(R.string.virtual_race));
                }
            } else {
                FragmentClubEditFormBinding binding21 = getBinding();
                TextView textView10 = binding21 != null ? binding21.tvPageTitle : null;
                if (textView10 != null) {
                    textView10.setText(getString(R.string.edit_virtual_race));
                }
            }
        }
        FragmentClubEditFormBinding binding22 = getBinding();
        AppCompatButton appCompatButton3 = binding22 != null ? binding22.btnBottomSaveEdit : null;
        if (appCompatButton3 != null) {
            appCompatButton3.setVisibility(8);
        }
        FragmentClubEditFormBinding binding23 = getBinding();
        AppCompatButton appCompatButton4 = binding23 != null ? binding23.btnBottomSaveCreate : null;
        if (appCompatButton4 != null) {
            appCompatButton4.setVisibility(8);
        }
        int i2 = this.argPageEditMode;
        if (i2 == ChallengeEditModeTypeSettings.EDIT.getId()) {
            FragmentClubEditFormBinding binding24 = getBinding();
            AppCompatButton appCompatButton5 = binding24 != null ? binding24.btnBottomSaveEdit : null;
            if (appCompatButton5 != null) {
                appCompatButton5.setVisibility(0);
            }
            FragmentClubEditFormBinding binding25 = getBinding();
            LinearLayout linearLayout17 = binding25 != null ? binding25.llPrivacyWrap : null;
            if (linearLayout17 != null) {
                linearLayout17.setVisibility(8);
            }
        } else if (i2 == ChallengeEditModeTypeSettings.CREATE.getId()) {
            FragmentClubEditFormBinding binding26 = getBinding();
            AppCompatButton appCompatButton6 = binding26 != null ? binding26.btnBottomSaveCreate : null;
            if (appCompatButton6 != null) {
                appCompatButton6.setVisibility(0);
            }
        }
        getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : ClubEditFormFragment.this.argChallengeTypeId, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
            }
        });
        if (this.argPageEditMode == ChallengeEditModeTypeSettings.CREATE.getId()) {
            getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.5
                @Override // kotlin.jvm.functions.Function1
                public final ChallengeFormData invoke(ChallengeFormData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : ChallengePrivacyLevelSettings.PUBLIC.getId(), (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                }
            });
            if (this.argChallengeTypeId == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
                getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.6
                    @Override // kotlin.jvm.functions.Function1
                    public final ChallengeFormData invoke(ChallengeFormData it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : ChallengeMachineTypeItems.TREADMILL.getId(), (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                    }
                });
            }
        }
        ChallengeFormData value2 = getClubViewModel().getEditChallengeDataForm().getValue();
        Integer numValueOf = value2 != null ? Integer.valueOf(value2.getChallengeType()) : null;
        setupEditScoreItemRecyclerView$default(this, 0, 1, null);
        List list = ArraysKt.toList(ChallengeScoreItemSettings.values());
        ClubEditScoreItemAdapter clubEditScoreItemAdapter = this.adapter1;
        if (clubEditScoreItemAdapter != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((ChallengeScoreItemSettings) obj).getShowAtForm()) {
                    arrayList.add(obj);
                }
            }
            clubEditScoreItemAdapter.submitList(arrayList);
            Unit unit = Unit.INSTANCE;
        }
        setupEditMachineTypeRecyclerView$default(this, null, 1, null);
        int id2 = ChallengeTypeSettings.VIRTUAL_RACE.getId();
        if (numValueOf != null && numValueOf.intValue() == id2) {
            List list2 = CollectionsKt.toList(ChallengeMachineTypeItems.INSTANCE.getUsedMachineTypes());
            ClubEditMachineTypeAdapter clubEditMachineTypeAdapter = this.adapter2;
            if (clubEditMachineTypeAdapter != null) {
                clubEditMachineTypeAdapter.submitList(list2);
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            List list3 = ArraysKt.toList(ChallengeMachineTypeItems.values());
            ClubEditMachineTypeAdapter clubEditMachineTypeAdapter2 = this.adapter2;
            if (clubEditMachineTypeAdapter2 != null) {
                clubEditMachineTypeAdapter2.submitList(list3);
                Unit unit3 = Unit.INSTANCE;
            }
        }
        ChallengeFormData value3 = getClubViewModel().getEditChallengeDataForm().getValue();
        updateMachineType(value3 != null ? value3.getOnMachineType() : null);
        setupEditPrivacyRecyclerView$default(this, null, 1, null);
        List list4 = ArraysKt.toList(ChallengePrivacyLevelSettings.values());
        ClubEditPrivacyAdapter clubEditPrivacyAdapter = this.adapter3;
        if (clubEditPrivacyAdapter != null) {
            clubEditPrivacyAdapter.submitList(list4);
            Unit unit4 = Unit.INSTANCE;
        }
        ChallengeFormData value4 = getClubViewModel().getEditChallengeDataForm().getValue();
        if (value4 != null) {
            updatePrivacy(value4.getPrivacyLevel());
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        setupEditVirtualRaceDistanceRecyclerView$default(this, null, 1, null);
        ChallengeFormData value5 = getClubViewModel().getEditChallengeDataForm().getValue();
        List list5 = (value5 == null || (onMachineType2 = value5.getOnMachineType()) == null) ? null : CollectionsKt.toList(VirtualRaceCodeType.INSTANCE.findByMachineTypeId(onMachineType2.intValue()));
        ClubEditRaceDistanceItemAdapter clubEditRaceDistanceItemAdapter = this.adapter4;
        if (clubEditRaceDistanceItemAdapter != null) {
            clubEditRaceDistanceItemAdapter.submitList(list5);
            Unit unit7 = Unit.INSTANCE;
        }
        ChallengeFormData value6 = getClubViewModel().getEditChallengeDataForm().getValue();
        if (value6 != null && (onMachineType = value6.getOnMachineType()) != null) {
            updateRaceList(onMachineType.intValue());
            Unit unit8 = Unit.INSTANCE;
            Unit unit9 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding27 = getBinding();
        TextView textView11 = binding27 != null ? binding27.tvCreateBtn : null;
        if (textView11 != null) {
            textView11.setVisibility(8);
        }
        FragmentClubEditFormBinding binding28 = getBinding();
        TextView textView12 = binding28 != null ? binding28.tvSaveEditBtn : null;
        if (textView12 != null) {
            textView12.setVisibility(8);
        }
        if (this.argPageEditMode == ChallengeEditModeTypeSettings.CREATE.getId()) {
            FragmentClubEditFormBinding binding29 = getBinding();
            TextView textView13 = binding29 != null ? binding29.tvCreateBtn : null;
            if (textView13 != null) {
                textView13.setVisibility(0);
            }
        } else {
            FragmentClubEditFormBinding binding30 = getBinding();
            TextView textView14 = binding30 != null ? binding30.tvSaveEditBtn : null;
            if (textView14 != null) {
                textView14.setVisibility(0);
            }
        }
        FragmentClubEditFormBinding binding31 = getBinding();
        if (binding31 != null && (textView3 = binding31.tvCancelBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEditFormFragment.initViews$lambda$9(this.f$0, view);
                }
            });
            Unit unit10 = Unit.INSTANCE;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AnonymousClass11(null), 2, null);
        FragmentClubEditFormBinding binding32 = getBinding();
        LinearLayout linearLayout18 = binding32 != null ? binding32.challengeFormPreviewPhotoWrap : null;
        if (linearLayout18 != null) {
            linearLayout18.setVisibility(8);
        }
        FragmentClubEditFormBinding binding33 = getBinding();
        TextView textView15 = binding33 != null ? binding33.challengeFormTakePhotoError : null;
        if (textView15 != null) {
            textView15.setVisibility(8);
        }
        FragmentClubEditFormBinding binding34 = getBinding();
        TextView textView16 = binding34 != null ? binding34.tvEventNameError : null;
        if (textView16 != null) {
            textView16.setVisibility(8);
        }
        FragmentClubEditFormBinding binding35 = getBinding();
        TextView textView17 = binding35 != null ? binding35.tvEventDescriptionError : null;
        if (textView17 != null) {
            textView17.setVisibility(8);
        }
        FragmentClubEditFormBinding binding36 = getBinding();
        TextView textView18 = binding36 != null ? binding36.tvTargetScoreError : null;
        if (textView18 != null) {
            textView18.setVisibility(8);
        }
        FragmentClubEditFormBinding binding37 = getBinding();
        if (binding37 != null && (linearLayout2 = binding37.challengeFormMakePhotoBtn) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEditFormFragment.initViews$lambda$10(this.f$0, view);
                }
            });
            Unit unit11 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding38 = getBinding();
        if (binding38 != null && (linearLayout = binding38.challengeFormSelectPhotoBtn) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEditFormFragment.initViews$lambda$11(this.f$0, view);
                }
            });
            Unit unit12 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding39 = getBinding();
        if (binding39 != null && (imageView3 = binding39.challengeFormClearPhotoBtn) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEditFormFragment.initViews$lambda$12(this.f$0, view);
                }
            });
            Unit unit13 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding40 = getBinding();
        if (binding40 != null && (editText11 = binding40.etEventName) != null) {
            editText11.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.15
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    final String string = StringsKt.trim((CharSequence) ClubEditFormFragment.toText$default(ClubEditFormFragment.this, s, null, 2, null)).toString();
                    FragmentClubEditFormBinding fragmentClubEditFormBindingAccess$getBinding = ClubEditFormFragment.access$getBinding(ClubEditFormFragment.this);
                    TextView textView19 = fragmentClubEditFormBindingAccess$getBinding != null ? fragmentClubEditFormBindingAccess$getBinding.tvEventNameError : null;
                    if (textView19 != null) {
                        textView19.setError("");
                    }
                    FragmentClubEditFormBinding fragmentClubEditFormBindingAccess$getBinding2 = ClubEditFormFragment.access$getBinding(ClubEditFormFragment.this);
                    TextView textView20 = fragmentClubEditFormBindingAccess$getBinding2 != null ? fragmentClubEditFormBindingAccess$getBinding2.tvEventNameError : null;
                    if (textView20 != null) {
                        textView20.setVisibility(8);
                    }
                    Timber.INSTANCE.d("new val: " + string, new Object[0]);
                    ClubEditFormFragment.this.getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$initViews$15$afterTextChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final ChallengeFormData invoke(ChallengeFormData it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : string, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                        }
                    });
                }
            });
            Unit unit14 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding41 = getBinding();
        if (binding41 != null && (editText10 = binding41.etEventDescription) != null) {
            editText10.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(final Editable s) {
                    Timber.INSTANCE.d("new val: " + ((Object) s), new Object[0]);
                    FragmentClubEditFormBinding fragmentClubEditFormBindingAccess$getBinding = ClubEditFormFragment.access$getBinding(ClubEditFormFragment.this);
                    TextView textView19 = fragmentClubEditFormBindingAccess$getBinding != null ? fragmentClubEditFormBindingAccess$getBinding.tvEventDescriptionError : null;
                    if (textView19 != null) {
                        textView19.setError("");
                    }
                    FragmentClubEditFormBinding fragmentClubEditFormBindingAccess$getBinding2 = ClubEditFormFragment.access$getBinding(ClubEditFormFragment.this);
                    TextView textView20 = fragmentClubEditFormBindingAccess$getBinding2 != null ? fragmentClubEditFormBindingAccess$getBinding2.tvEventDescriptionError : null;
                    if (textView20 != null) {
                        textView20.setVisibility(8);
                    }
                    ClubEditFormFragment.this.getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$initViews$16$afterTextChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final ChallengeFormData invoke(ChallengeFormData it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : String.valueOf(s), (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                        }
                    });
                }
            });
            Unit unit15 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding42 = getBinding();
        EditText editText12 = binding42 != null ? binding42.etDateStart : null;
        FragmentClubEditFormBinding binding43 = getBinding();
        EditText editText13 = binding43 != null ? binding43.etVirtualRaceDateStart : null;
        FragmentClubEditFormBinding binding44 = getBinding();
        EditText editText14 = binding44 != null ? binding44.etDateEnd : null;
        FragmentClubEditFormBinding binding45 = getBinding();
        final EditText editText15 = binding45 != null ? binding45.etDateCount : null;
        FragmentClubEditFormBinding binding46 = getBinding();
        TextView textView19 = binding46 != null ? binding46.challengeFormStartDateTimeFormat : null;
        FragmentClubEditFormBinding binding47 = getBinding();
        TextView textView20 = binding47 != null ? binding47.challengeFormEndDateTimeFormat : null;
        boolean zIs24HourFormat = DateFormat.is24HourFormat(getContext());
        Timber.INSTANCE.d("is24Hour----" + zIs24HourFormat, new Object[0]);
        if (!zIs24HourFormat) {
            if (textView19 != null) {
                textView19.setText("(0:00 AM)");
            }
            if (textView20 != null) {
                textView20.setText("(11:59 PM)");
            }
        }
        if (editText15 != null) {
            editText15.setText(String.valueOf(this.challengeDateCount));
            Unit unit16 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding48 = getBinding();
        if (binding48 != null && (imageView2 = binding48.imgPlusDay) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEditFormFragment.initViews$lambda$13(this.f$0, editText15, view);
                }
            });
            Unit unit17 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding49 = getBinding();
        if (binding49 != null && (imageView = binding49.imgMinusDay) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEditFormFragment.initViews$lambda$14(this.f$0, editText15, view);
                }
            });
            Unit unit18 = Unit.INSTANCE;
        }
        if (editText15 != null) {
            editText15.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.19
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    Integer intOrNull;
                    Timber.INSTANCE.d("new val: " + ((Object) s), new Object[0]);
                    String text$default = ClubEditFormFragment.toText$default(ClubEditFormFragment.this, s, null, 2, null);
                    try {
                        if (text$default.length() <= 0 || (intOrNull = StringsKt.toIntOrNull(text$default)) == null) {
                            editText15.setText("1");
                            ClubEditFormFragment.this.setChallengeDateCount(1);
                        } else if (intOrNull.intValue() <= 365) {
                            ClubEditFormFragment.this.setChallengeDateCount(intOrNull.intValue());
                        } else {
                            editText15.setText("365");
                            ClubEditFormFragment.this.setChallengeDateCount(365);
                        }
                        ClubEditFormFragment.this.updateStartEndDate();
                    } catch (Exception e) {
                        Timber.INSTANCE.e(e);
                    }
                }
            });
            Unit unit19 = Unit.INSTANCE;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        calendar2.add(5, 1);
        String strConvertTimestampToStringDateISO = TimeTools.INSTANCE.convertTimestampToStringDateISO(calendar.getTimeInMillis());
        if (this.argChallengeTypeId == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
            strConvertTimestampToStringDateISO = TimeTools.INSTANCE.convertTimestampToStringDateISO(calendar2.getTimeInMillis());
        }
        final String strConvertToDisplayFormat = convertToDisplayFormat(strConvertTimestampToStringDateISO);
        String strConvertToDisplayFormatSpecialText = convertToDisplayFormatSpecialText(strConvertTimestampToStringDateISO);
        Timber.INSTANCE.d("startDay: " + strConvertToDisplayFormat, new Object[0]);
        getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.20
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : strConvertToDisplayFormat, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
            }
        });
        if (editText12 != null) {
            editText12.setText(strConvertToDisplayFormatSpecialText);
            Unit unit20 = Unit.INSTANCE;
        }
        if (editText13 != null) {
            editText13.setText(strConvertToDisplayFormatSpecialText);
            Unit unit21 = Unit.INSTANCE;
        }
        if (editText12 != null) {
            editText12.setInputType(0);
            editText12.setKeyListener(null);
            editText12.setFocusable(true);
            editText12.setFocusableInTouchMode(true);
        }
        if (editText12 != null) {
            editText12.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ClubEditFormFragment.initViews$lambda$18(this.f$0, view, z);
                }
            });
            Unit unit22 = Unit.INSTANCE;
        }
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(6, 29);
        calendar3.set(11, 0);
        calendar3.set(12, 0);
        calendar3.set(13, 0);
        calendar3.set(14, 0);
        String strConvertTimestampToStringDateISO2 = TimeTools.INSTANCE.convertTimestampToStringDateISO(calendar3.getTimeInMillis());
        final String strConvertToDisplayFormat2 = convertToDisplayFormat(strConvertTimestampToStringDateISO2);
        String strConvertToDisplayFormatSpecialText2 = convertToDisplayFormatSpecialText(strConvertTimestampToStringDateISO2);
        if (editText14 != null) {
            editText14.setText(strConvertToDisplayFormatSpecialText2);
            Unit unit23 = Unit.INSTANCE;
        }
        getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.23
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : strConvertToDisplayFormat2, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
            }
        });
        if (editText14 != null) {
            editText14.setInputType(0);
            editText14.setKeyListener(null);
            editText14.setFocusable(true);
            editText14.setFocusableInTouchMode(true);
        }
        if (editText14 != null) {
            editText14.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ClubEditFormFragment.initViews$lambda$21(this.f$0, view, z);
                }
            });
            Unit unit24 = Unit.INSTANCE;
        }
        ChallengeFormData value7 = getClubViewModel().getEditChallengeDataForm().getValue();
        if (value7 != null) {
            resetFocusValueInput(value7.getScoreItem());
            Unit unit25 = Unit.INSTANCE;
            Unit unit26 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding50 = getBinding();
        if (binding50 != null && (editText9 = binding50.etTargetScore) != null) {
            editText9.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.27
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    FragmentClubEditFormBinding fragmentClubEditFormBindingAccess$getBinding = ClubEditFormFragment.access$getBinding(ClubEditFormFragment.this);
                    TextView textView21 = fragmentClubEditFormBindingAccess$getBinding != null ? fragmentClubEditFormBindingAccess$getBinding.tvTargetScoreError : null;
                    if (textView21 != null) {
                        textView21.setText("");
                    }
                    FragmentClubEditFormBinding fragmentClubEditFormBindingAccess$getBinding2 = ClubEditFormFragment.access$getBinding(ClubEditFormFragment.this);
                    TextView textView22 = fragmentClubEditFormBindingAccess$getBinding2 != null ? fragmentClubEditFormBindingAccess$getBinding2.tvTargetScoreError : null;
                    if (textView22 != null) {
                        textView22.setVisibility(8);
                    }
                    Timber.INSTANCE.d("new val: " + ((Object) s), new Object[0]);
                    final Double doubleOrNull = StringsKt.toDoubleOrNull(String.valueOf(s));
                    if (doubleOrNull != null && doubleOrNull.doubleValue() >= AudioStats.AUDIO_AMPLITUDE_NONE) {
                        ClubEditFormFragment.this.getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$initViews$27$afterTextChanged$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final ChallengeFormData invoke(ChallengeFormData it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : doubleOrNull, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                            }
                        });
                    } else {
                        ClubEditFormFragment.this.getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$initViews$27$afterTextChanged$2
                            @Override // kotlin.jvm.functions.Function1
                            public final ChallengeFormData invoke(ChallengeFormData it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                            }
                        });
                    }
                }
            });
            Unit unit27 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding51 = getBinding();
        if (binding51 != null && (editText8 = binding51.etVirtualRaceDateStart) != null) {
            editText8.setInputType(0);
            editText8.setKeyListener(null);
            editText8.setFocusable(true);
            editText8.setFocusableInTouchMode(true);
        }
        FragmentClubEditFormBinding binding52 = getBinding();
        if (binding52 != null && (editText7 = binding52.etVirtualRaceDateStart) != null) {
            editText7.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ClubEditFormFragment.initViews$lambda$24(this.f$0, view, z);
                }
            });
            Unit unit28 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding53 = getBinding();
        if (binding53 != null && (textView2 = binding53.tvSaveEditBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEditFormFragment.initViews$lambda$25(this.f$0, view);
                }
            });
            Unit unit29 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding54 = getBinding();
        if (binding54 != null && (appCompatButton2 = binding54.btnBottomSaveEdit) != null) {
            appCompatButton2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEditFormFragment.initViews$lambda$26(this.f$0, view);
                }
            });
            Unit unit30 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding55 = getBinding();
        if (binding55 != null && (textView = binding55.tvCreateBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEditFormFragment.initViews$lambda$27(this.f$0, view);
                }
            });
            Unit unit31 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding56 = getBinding();
        if (binding56 != null && (appCompatButton = binding56.btnBottomSaveCreate) != null) {
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEditFormFragment.initViews$lambda$28(this.f$0, view);
                }
            });
            Unit unit32 = Unit.INSTANCE;
        }
        if (this.argPageEditMode != ChallengeEditModeTypeSettings.EDIT.getId() || (value = getClubViewModel().getSelectedChallengeData().getValue()) == null) {
            return;
        }
        if (value.getActivityStatus() == ChallengeActivityStatus.IN_PROGRESS.getId() || value.getActivityStatus() == ChallengeActivityStatus.IN_PROGRESS_EARLY.getId() || value.getActivityStatus() == ChallengeActivityStatus.FINISHED.getId()) {
            CustomDialogKt.showCustomDialog$default(this, null, getString(R.string.err_4008_only_challenges_that_have_not_yet_started_can_be_modified), getString(R.string.confirm), null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.34
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
                    ClubEditFormFragment.this.resetAll();
                    ClubEditFormFragment.this.safeNavigateUp();
                }
            }, null, false, 40, null);
        }
        final Ref.DoubleRef doubleRef = new Ref.DoubleRef();
        doubleRef.element = getLoadScoreValText(Double.valueOf(value.getGoalValue()), value.getScoreItem());
        getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.35
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String photoFileUrl = value.getPhotoFileUrl();
                return it.copy((3967 & 1) != 0 ? it.photoUri : photoFileUrl != null ? Uri.parse(photoFileUrl) : null, (3967 & 2) != 0 ? it.challengeType : value.getChallengeType(), (3967 & 4) != 0 ? it.startDate : TimeTools.INSTANCE.convertTimestampToStringDate(value.getStartTimeMillis()), (3967 & 8) != 0 ? it.endDate : TimeTools.INSTANCE.convertTimestampToStringDate(value.getEndTimeMillis()), (3967 & 16) != 0 ? it.privacyLevel : value.getPrivacyLevel(), (3967 & 32) != 0 ? it.scoreItem : value.getScoreItem(), (3967 & 64) != 0 ? it.goalValue : Double.valueOf(doubleRef.element), (3967 & 128) != 0 ? it.challengeName : value.getChallengeName(), (3967 & 256) != 0 ? it.introduction : value.getIntroduction(), (3967 & 512) != 0 ? it.onMachineType : value.getOnMachineType(), (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : value.getVirtualRaceCode());
            }
        });
        if (getBinding() != null) {
            FragmentClubEditFormBinding binding57 = getBinding();
            LinearLayout linearLayout19 = binding57 != null ? binding57.challengeFormTakePhotoWrap : null;
            if (linearLayout19 != null) {
                linearLayout19.setVisibility(8);
            }
            FragmentClubEditFormBinding binding58 = getBinding();
            LinearLayout linearLayout20 = binding58 != null ? binding58.challengeFormPreviewPhotoWrap : null;
            if (linearLayout20 != null) {
                linearLayout20.setVisibility(0);
            }
            String photoFileUrl = value.getPhotoFileUrl();
            if (photoFileUrl != null) {
                FragmentClubEditFormBinding binding59 = getBinding();
                Intrinsics.checkNotNull(binding59);
                RequestBuilder<Drawable> requestBuilderLoad = Glide.with(binding59.challengeFormPreviewPhoto).load(photoFileUrl);
                FragmentClubEditFormBinding binding60 = getBinding();
                Intrinsics.checkNotNull(binding60);
                requestBuilderLoad.into(binding60.challengeFormPreviewPhoto);
            }
        }
        FragmentClubEditFormBinding binding61 = getBinding();
        if (binding61 != null && (editText6 = binding61.etEventName) != null) {
            editText6.setText(value.getChallengeName());
            Unit unit33 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding62 = getBinding();
        if (binding62 != null && (editText5 = binding62.etEventDescription) != null) {
            editText5.setText(value.getIntroduction());
            Unit unit34 = Unit.INSTANCE;
        }
        updateActiveScoreItem(value.getScoreItem());
        FragmentClubEditFormBinding binding63 = getBinding();
        if (binding63 != null && (editText4 = binding63.etTargetScore) != null) {
            editText4.setText(StringsKt.removeSuffix(String.valueOf(doubleRef.element), (CharSequence) ".0"));
            Unit unit35 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding64 = getBinding();
        if (binding64 != null && (editText3 = binding64.etDateStart) != null) {
            editText3.setText(TimeTools.INSTANCE.formatToTimeByTimeMillis05(Long.valueOf(value.getStartTimeMillis())));
            Unit unit36 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding65 = getBinding();
        if (binding65 != null && (editText2 = binding65.etVirtualRaceDateStart) != null) {
            editText2.setText(TimeTools.INSTANCE.formatToTimeByTimeMillis05(Long.valueOf(value.getStartTimeMillis())));
            Unit unit37 = Unit.INSTANCE;
        }
        FragmentClubEditFormBinding binding66 = getBinding();
        if (binding66 != null && (editText = binding66.etDateEnd) != null) {
            editText.setText(TimeTools.INSTANCE.formatToTimeByTimeMillis05(Long.valueOf(value.getEndTimeMillis())));
            Unit unit38 = Unit.INSTANCE;
        }
        updateDateCount();
        updateMachineType(value.getOnMachineType());
        updatePrivacy(value.getPrivacyLevel());
        String virtualRaceCode = value.getVirtualRaceCode();
        if (virtualRaceCode != null) {
            updateRaceDistance(virtualRaceCode);
            Unit unit39 = Unit.INSTANCE;
            Unit unit40 = Unit.INSTANCE;
        }
        Timber.INSTANCE.d("existData: " + value, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(ClubEditFormFragment this$0, final Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (uri != null) {
            Timber.INSTANCE.d("PhotoPickerURI: " + uri, new Object[0]);
            this$0.getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$initViews$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ChallengeFormData invoke(ChallengeFormData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.copy((3967 & 1) != 0 ? it.photoUri : uri, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                }
            });
            this$0.updatePreviewImage(uri);
            try {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getDefault(), null, new ClubEditFormFragment$initViews$1$2(this$0, uri, null), 2, null);
                return;
            } catch (Exception e) {
                Timber.INSTANCE.e("processImage err----: " + e, new Object[0]);
                Timber.INSTANCE.d("Stack: " + Log.getStackTraceString(e), new Object[0]);
                return;
            }
        }
        Timber.INSTANCE.d("PhotoPicker No media selected", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$3(final ClubEditFormFragment this$0, ActivityResult result) {
        Context context;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Timber.INSTANCE.d("result:" + result, new Object[0]);
            Timber.INSTANCE.d("imaageData:" + result.getData(), new Object[0]);
            if (this$0.photoUri != null) {
                this$0.getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$initViews$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final ChallengeFormData invoke(ChallengeFormData it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.copy((3967 & 1) != 0 ? it.photoUri : this.this$0.photoUri, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                    }
                });
                Timber.INSTANCE.d("photoUri:" + this$0.photoUri, new Object[0]);
                this$0.updatePreviewImage(this$0.photoUri);
                try {
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getDefault(), null, new ClubEditFormFragment$initViews$2$2(this$0, null), 2, null);
                    return;
                } catch (Exception e) {
                    Timber.INSTANCE.e("processImage err----: " + e, new Object[0]);
                    Timber.INSTANCE.d("Stack: " + Log.getStackTraceString(new Throwable()), new Object[0]);
                    return;
                }
            }
            View view = this$0.getView();
            if (view == null || (context = view.getContext()) == null) {
                return;
            }
            Toast.makeText(context, "Can't get image URI", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4(ClubEditFormFragment this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            Timber.INSTANCE.d("Camera permission granted", new Object[0]);
            this$0.openCamera();
        } else {
            Timber.INSTANCE.w("Camera permission denied", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$9(ClubEditFormFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("Cancel", new Object[0]);
        this$0.resetAll();
        this$0.safeNavigateUp();
    }

    /* compiled from: ClubEditFormFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$initViews$11", f = "ClubEditFormFragment.kt", i = {}, l = {407}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$initViews$11, reason: invalid class name */
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass11(Continuation<? super AnonymousClass11> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubEditFormFragment.this.new AnonymousClass11(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ClubEditFormFragment.this.getClubViewModel().getEditChallengeDataForm().collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.initViews.11.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((ChallengeFormData) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(ChallengeFormData challengeFormData, Continuation<? super Unit> continuation) {
                        Timber.INSTANCE.d("collect---" + challengeFormData, new Object[0]);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10(ClubEditFormFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.allPermissionsGranted()) {
            this$0.openCamera();
            return;
        }
        ActivityResultLauncher<String> activityResultLauncher = this$0.cameraPermissionLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPermissionLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch("android.permission.CAMERA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$11(ClubEditFormFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncher = this$0.pickMedia;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickMedia");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(PickVisualMediaRequestKt.PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE, 0, false, null, 14, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$12(ClubEditFormFragment this$0, View view) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$initViews$14$1
            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
            }
        });
        FragmentClubEditFormBinding binding = this$0.getBinding();
        LinearLayout linearLayout = binding != null ? binding.challengeFormPreviewPhotoWrap : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FragmentClubEditFormBinding binding2 = this$0.getBinding();
        LinearLayout linearLayout2 = binding2 != null ? binding2.challengeFormTakePhotoWrap : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        FragmentClubEditFormBinding binding3 = this$0.getBinding();
        if (binding3 == null || (imageView = binding3.challengeFormPreviewPhoto) == null) {
            return;
        }
        imageView.setImageResource(android.R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$13(ClubEditFormFragment this$0, EditText editText, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.challengeDateCount;
        if (i < 365) {
            int i2 = i + 1;
            this$0.challengeDateCount = i2;
            if (editText != null) {
                editText.setText(String.valueOf(i2));
            }
            this$0.updateStartEndDate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$14(ClubEditFormFragment this$0, EditText editText, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.challengeDateCount;
        if (i > 1) {
            int i2 = i - 1;
            this$0.challengeDateCount = i2;
            if (editText != null) {
                editText.setText(String.valueOf(i2));
            }
            this$0.updateStartEndDate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$18(ClubEditFormFragment this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("startDateInput focus: " + z, new Object[0]);
        if (z) {
            this$0.showStartDatePicker();
        }
        view.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$21(ClubEditFormFragment this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("endDateInput focus: " + z, new Object[0]);
        if (z) {
            this$0.showEndDatePicker();
        }
        view.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$24(ClubEditFormFragment this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("startDateInput focus: " + z, new Object[0]);
        if (z) {
            this$0.showStartDatePicker();
        }
        view.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$25(ClubEditFormFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.editSaveForm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$26(ClubEditFormFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.editSaveForm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$27(ClubEditFormFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.createForm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$28(ClubEditFormFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.createForm();
    }

    private final double getLoadScoreValText(Double currentScore, int scoreItem) {
        double dDoubleValue = currentScore != null ? currentScore.doubleValue() : 0.0d;
        if (scoreItem != ChallengeScoreItemSettings.TOTAL_CALORIES.getId() && scoreItem != ChallengeScoreItemSettings.SESSION.getId()) {
            if (scoreItem != ChallengeScoreItemSettings.TOTAL_DISTANCE.getId()) {
                return scoreItem == ChallengeScoreItemSettings.TOTAL_TIME.getId() ? dDoubleValue / CacheConstants.HOUR : AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            if (Global.INSTANCE.getUnitType()) {
                return Double.parseDouble(UnitConversion.INSTANCE.getMi(StringsKt.trim((CharSequence) String.valueOf(dDoubleValue)).toString(), 7));
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double getUploadScoreVal(Double currentScore, int scoreItem) {
        double dDoubleValue = currentScore != null ? currentScore.doubleValue() : 0.0d;
        if (scoreItem != ChallengeScoreItemSettings.TOTAL_CALORIES.getId() && scoreItem != ChallengeScoreItemSettings.SESSION.getId()) {
            if (scoreItem != ChallengeScoreItemSettings.TOTAL_DISTANCE.getId()) {
                return scoreItem == ChallengeScoreItemSettings.TOTAL_TIME.getId() ? dDoubleValue * CacheConstants.HOUR : AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            if (Global.INSTANCE.getUnitType()) {
                return Double.parseDouble(UnitConversion.INSTANCE.getKm(StringsKt.trim((CharSequence) String.valueOf(dDoubleValue)).toString(), 7));
            }
        }
        return dDoubleValue;
    }

    private final void createChallenge() {
        ChallengeFormData value = getClubViewModel().getEditChallengeDataForm().getValue();
        if (value == null) {
            return;
        }
        showLoading();
        Timber.INSTANCE.d("rawData:" + value, new Object[0]);
        CreateChallengeApiData.RequestBodyData requestBodyData = new CreateChallengeApiData.RequestBodyData(value.getChallengeType(), convertFromDisplayFormat(value.getStartDate()), convertFromDisplayFormat(value.getEndDate()), value.getPrivacyLevel(), Integer.valueOf(value.getScoreItem()), Double.valueOf(getUploadScoreVal(value.getGoalValue(), value.getScoreItem())), value.getChallengeName(), value.getIntroduction(), value.getOnMachineType(), value.getVirtualRaceCode());
        int challengeType = value.getChallengeType();
        if (challengeType == ChallengeTypeSettings.GOAL.getId()) {
            requestBodyData.setVirtualRaceCode(null);
        } else if (challengeType == ChallengeTypeSettings.RANKING.getId()) {
            requestBodyData.setGoalValue(null);
            requestBodyData.setVirtualRaceCode(null);
        } else if (challengeType == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
            requestBodyData.setEndDate(null);
            requestBodyData.setScoreItem(null);
            requestBodyData.setGoalValue(null);
        }
        Timber.INSTANCE.d("requestData:\n" + new GsonBuilder().setPrettyPrinting().create().toJson(requestBodyData), new Object[0]);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(requestBodyData, this, null), 3, null);
    }

    /* compiled from: ClubEditFormFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$createChallenge$1", f = "ClubEditFormFragment.kt", i = {}, l = {909}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$createChallenge$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CreateChallengeApiData.RequestBodyData $requestData;
        int label;
        final /* synthetic */ ClubEditFormFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CreateChallengeApiData.RequestBodyData requestBodyData, ClubEditFormFragment clubEditFormFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$requestData = requestBodyData;
            this.this$0 = clubEditFormFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$requestData, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallCreateChallenge;
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        objCallCreateChallenge = DyacoApiKt.callCreateChallenge(this.$requestData, this);
                        if (objCallCreateChallenge == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallCreateChallenge = obj;
                    }
                    Response response = (Response) objCallCreateChallenge;
                    CreateChallengeApiData.ResponseData responseData = (CreateChallengeApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("callCreateChallenge: " + response, new Object[0]);
                    CreateChallengeApiData.DataMap sysResponseData = responseData != null ? responseData.getSysResponseData() : null;
                    String challengeUuid = sysResponseData != null ? sysResponseData.getChallengeUuid() : null;
                    final String challengeName = sysResponseData != null ? sysResponseData.getChallengeName() : null;
                    Timber.INSTANCE.d("create ID :" + challengeUuid, new Object[0]);
                    Timber.INSTANCE.d("systemAdviceName :" + challengeName, new Object[0]);
                    CreateChallengeApiData.ResponseData responseData2 = (CreateChallengeApiData.ResponseData) response.body();
                    String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                    CreateChallengeApiData.ResponseData responseData3 = (CreateChallengeApiData.ResponseData) response.body();
                    if (responseData3 == null || !responseData3.getSuccess()) {
                        if (this.this$0.shouldIgnoreError(errorCode)) {
                            unit = Unit.INSTANCE;
                        } else if (Intrinsics.areEqual(errorCode, ErrorCode.CHALLENGE_DUPLICATE_NAME_4013.getId())) {
                            ClubEditFormFragment clubEditFormFragment = this.this$0;
                            String string = clubEditFormFragment.getString(R.string.challenge_title_duplicate);
                            String string2 = this.this$0.getString(R.string.err_4013_use_system_suggested_name);
                            final ClubEditFormFragment clubEditFormFragment2 = this.this$0;
                            CustomDialogKt.showCustomDialog$default(clubEditFormFragment, string, string2, null, null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.createChallenge.1.2
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
                                    EditText editText;
                                    if (challengeName != null) {
                                        ClubViewModel clubViewModel = clubEditFormFragment2.getClubViewModel();
                                        final String str = challengeName;
                                        clubViewModel.updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.createChallenge.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final ChallengeFormData invoke(ChallengeFormData it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : str, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                                            }
                                        });
                                        FragmentClubEditFormBinding fragmentClubEditFormBindingAccess$getBinding = ClubEditFormFragment.access$getBinding(clubEditFormFragment2);
                                        if (fragmentClubEditFormBindingAccess$getBinding == null || (editText = fragmentClubEditFormBindingAccess$getBinding.etEventName) == null) {
                                            return;
                                        }
                                        editText.setText(challengeName);
                                    }
                                }
                            }, null, false, 108, null);
                            unit = Unit.INSTANCE;
                        } else {
                            if (!Intrinsics.areEqual(errorCode, ErrorCode.CHALLENGE_DUPLICATE_NAME_FAIL_GEN_NAME_4014.getId()) && !Intrinsics.areEqual(errorCode, ErrorCode.CHALLENGE_DUPLICATE_NAME_1_4015.getId())) {
                                Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.INVALID_DATE_FORMAT_1046.getId(), Boxing.boxInt(R.string.err_1046_invalid_date_format)), TuplesKt.to(ErrorCode.INVALID_ARGUMENT_1025.getId(), Boxing.boxInt(R.string.err_1025_invalid_argument)), TuplesKt.to(ErrorCode.CHALLENGE_INVALID_END_DATE_4004.getId(), Boxing.boxInt(R.string.err_4004_invalid_end_date)), TuplesKt.to(ErrorCode.CHALLENGE_INVALID_START_DATE_4005.getId(), Boxing.boxInt(R.string.err_4005_invalid_start_date))).get(errorCode);
                                if (num != null) {
                                    ClubEditFormFragment clubEditFormFragment3 = this.this$0;
                                    CustomDialogKt.showCustomDialog$default(clubEditFormFragment3, null, clubEditFormFragment3.getString(num.intValue()), this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
                                } else {
                                    ClubEditFormFragment clubEditFormFragment4 = this.this$0;
                                    CreateChallengeApiData.ResponseData responseData4 = (CreateChallengeApiData.ResponseData) response.body();
                                    BaseFragment.handleUndefinedError$default(clubEditFormFragment4, "createChallenge", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                                }
                            }
                            ClubEditFormFragment clubEditFormFragment5 = this.this$0;
                            CustomDialogKt.showCustomDialog$default(clubEditFormFragment5, null, "Network error, please try again.", clubEditFormFragment5.getString(R.string.confirm), null, null, null, false, 112, null);
                            unit = Unit.INSTANCE;
                        }
                        return unit;
                    }
                    if (this.$requestData.getChallengeType() == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
                        Timber.INSTANCE.d("若是race，跳轉到detail", new Object[0]);
                        if (challengeUuid != null) {
                            this.this$0.getClubViewModel().setSelectChallengeId(challengeUuid);
                            BaseFragment.safeNavigateWithPopUp$default(this.this$0, R.id.clubEventDetailFragment, R.id.clubEditFormFragment, true, null, 8, null);
                        }
                    }
                    File file = this.this$0.tempResizeImgFile;
                    if (file != null) {
                        ClubEditFormFragment clubEditFormFragment6 = this.this$0;
                        try {
                            Timber.INSTANCE.d("成功，接上傳圖片", new Object[0]);
                            MainActivity mainActivity = clubEditFormFragment6.getMainActivity();
                            Uri uriForFile = mainActivity != null ? FileProvider.getUriForFile(mainActivity, mainActivity.getPackageName() + ".fileprovider", file) : null;
                            if (challengeUuid != null) {
                                if (uriForFile != null) {
                                    clubEditFormFragment6.uploadCoverImage(uriForFile, challengeUuid);
                                }
                                Unit unit2 = Unit.INSTANCE;
                            }
                        } catch (IllegalArgumentException e) {
                            Timber.INSTANCE.e(e, "FileProvider error: " + file.getAbsolutePath(), new Object[0]);
                            CustomDialogKt.showCustomDialog$default(clubEditFormFragment6, null, clubEditFormFragment6.getString(R.string.image_processing_failed_msg), clubEditFormFragment6.getString(R.string.confirm), null, null, null, false, 112, null);
                            Unit unit3 = Unit.INSTANCE;
                        }
                    }
                } catch (IOException e2) {
                    Timber.INSTANCE.e(e2, "API call failed", new Object[0]);
                    String message = e2.getMessage();
                    if (message == null) {
                        message = e2.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(this.this$0, "createChallenge", message, false, 4, null);
                }
                this.this$0.stopLoading();
                return Unit.INSTANCE;
            } finally {
                this.this$0.stopLoading();
            }
        }
    }

    /* compiled from: ClubEditFormFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$uploadCoverImage$1", f = "ClubEditFormFragment.kt", i = {}, l = {WinError.ERROR_SERVICE_NOT_ACTIVE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$uploadCoverImage$1, reason: invalid class name and case insensitive filesystem */
    static final class C09241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $challengeUuid;
        final /* synthetic */ Uri $imageUri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09241(Uri uri, String str, Continuation<? super C09241> continuation) {
            super(2, continuation);
            this.$imageUri = uri;
            this.$challengeUuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubEditFormFragment.this.new C09241(this.$imageUri, this.$challengeUuid, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ContentResolver contentResolver;
            InputStream inputStreamOpenInputStream;
            String type;
            Object objCallUpdateChallengeCoverPhoto;
            ContentResolver contentResolver2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        MainActivity mainActivity = ClubEditFormFragment.this.getMainActivity();
                        if (mainActivity == null || (contentResolver = mainActivity.getContentResolver()) == null || (inputStreamOpenInputStream = contentResolver.openInputStream(this.$imageUri)) == null) {
                            throw new IOException("Unable to open image input stream");
                        }
                        InputStream inputStream = inputStreamOpenInputStream;
                        try {
                            byte[] bytes = ByteStreamsKt.readBytes(inputStream);
                            CloseableKt.closeFinally(inputStream, null);
                            MainActivity mainActivity2 = ClubEditFormFragment.this.getMainActivity();
                            if (mainActivity2 == null || (contentResolver2 = mainActivity2.getContentResolver()) == null || (type = contentResolver2.getType(this.$imageUri)) == null) {
                                type = "image/*";
                            }
                            RequestBody requestBodyCreate$default = RequestBody.Companion.create$default(RequestBody.INSTANCE, bytes, MediaType.INSTANCE.parse(type), 0, 0, 6, (Object) null);
                            this.label = 1;
                            objCallUpdateChallengeCoverPhoto = DyacoApiKt.callUpdateChallengeCoverPhoto(MultipartBody.Part.INSTANCE.createFormData("file", "cover_photo.jpg", requestBodyCreate$default), this.$challengeUuid, this);
                            if (objCallUpdateChallengeCoverPhoto == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } finally {
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallUpdateChallengeCoverPhoto = obj;
                    }
                    Response response = (Response) objCallUpdateChallengeCoverPhoto;
                    UpdateChallengeCoverPhotoApiData.ResponseData responseData = (UpdateChallengeCoverPhotoApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("callUpdateChallengeCoverPhoto: " + response, new Object[0]);
                    if (responseData != null && responseData.getSuccess()) {
                        Timber.INSTANCE.d("uploadCoverImage -> onResponse response=" + response, new Object[0]);
                        UpdateChallengeCoverPhotoApiData.DataMap sysResponseData = responseData.getSysResponseData();
                        Timber.INSTANCE.d("Cover photo uploaded successfully: " + (sysResponseData != null ? sysResponseData.getData() : null), new Object[0]);
                        ClubEditFormFragment.this.getClubViewModel().setSelectChallengeId(this.$challengeUuid);
                        BaseFragment.safeNavigateWithPopUp$default(ClubEditFormFragment.this, R.id.clubEventDetailFragment, R.id.clubEditFormFragment, true, null, 8, null);
                    } else {
                        Timber.INSTANCE.e("uploadCoverImage -> onFailure ", new Object[0]);
                        String errorCode = responseData != null ? responseData.getErrorCode() : null;
                        if (ClubEditFormFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        ClubEditFormFragment clubEditFormFragment = ClubEditFormFragment.this;
                        UpdateChallengeCoverPhotoApiData.ResponseData responseData2 = (UpdateChallengeCoverPhotoApiData.ResponseData) response.body();
                        BaseFragment.handleUndefinedError$default(clubEditFormFragment, "uploadCoverImage", errorCode, responseData2 != null ? responseData2.getErrorMessage() : null, false, 8, null);
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "uploadCoverImage -> IOException", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubEditFormFragment.this, "uploadCoverImage", message, false, 4, null);
                }
                ClubEditFormFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubEditFormFragment.this.stopLoading();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadCoverImage(Uri imageUri, String challengeUuid) {
        showLoading();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09241(imageUri, challengeUuid, null), 3, null);
    }

    private final void updateChallenge(boolean isNewImg) {
        ChallengeFormData value;
        ChallengeItemFullData value2 = getClubViewModel().getSelectedChallengeData().getValue();
        if (value2 == null || (value = getClubViewModel().getEditChallengeDataForm().getValue()) == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09181(value, value2, isNewImg, null), 3, null);
    }

    /* compiled from: ClubEditFormFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$updateChallenge$1", f = "ClubEditFormFragment.kt", i = {0}, l = {WinError.ERROR_ILLEGAL_ELEMENT_ADDRESS}, m = "invokeSuspend", n = {"requestData"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$updateChallenge$1, reason: invalid class name and case insensitive filesystem */
    static final class C09181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChallengeFormData $data;
        final /* synthetic */ ChallengeItemFullData $existData;
        final /* synthetic */ boolean $isNewImg;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09181(ChallengeFormData challengeFormData, ChallengeItemFullData challengeItemFullData, boolean z, Continuation<? super C09181> continuation) {
            super(2, continuation);
            this.$data = challengeFormData;
            this.$existData = challengeItemFullData;
            this.$isNewImg = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubEditFormFragment.this.new C09181(this.$data, this.$existData, this.$isNewImg, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UpdateChallengeApiData.RequestBodyData requestBodyData;
            Object objCallUpdateChallenge;
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubEditFormFragment.this.showLoading();
                        Timber.INSTANCE.d("rawData:" + this.$data, new Object[0]);
                        requestBodyData = new UpdateChallengeApiData.RequestBodyData(this.$existData.getChallengeUuid(), this.$data.getChallengeType(), ClubEditFormFragment.this.convertFromDisplayFormat(this.$data.getStartDate()), ClubEditFormFragment.this.convertFromDisplayFormat(this.$data.getEndDate()), this.$data.getPrivacyLevel(), Boxing.boxInt(this.$data.getScoreItem()), Boxing.boxDouble(ClubEditFormFragment.this.getUploadScoreVal(this.$data.getGoalValue(), this.$data.getScoreItem())), this.$data.getChallengeName(), this.$data.getIntroduction(), this.$data.getOnMachineType(), this.$data.getVirtualRaceCode());
                        int challengeType = this.$data.getChallengeType();
                        if (challengeType == ChallengeTypeSettings.GOAL.getId()) {
                            requestBodyData.setVirtualRaceCode(null);
                        } else if (challengeType == ChallengeTypeSettings.RANKING.getId()) {
                            requestBodyData.setGoalValue(null);
                            requestBodyData.setVirtualRaceCode(null);
                        } else if (challengeType == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
                            requestBodyData.setEndDate(null);
                            requestBodyData.setScoreItem(null);
                            requestBodyData.setGoalValue(null);
                            requestBodyData.setOnMachineType(null);
                        }
                        Timber.INSTANCE.d("requestData:\n" + new GsonBuilder().setPrettyPrinting().create().toJson(requestBodyData), new Object[0]);
                        this.L$0 = requestBodyData;
                        this.label = 1;
                        objCallUpdateChallenge = DyacoApiKt.callUpdateChallenge(requestBodyData, this);
                        if (objCallUpdateChallenge == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        UpdateChallengeApiData.RequestBodyData requestBodyData2 = (UpdateChallengeApiData.RequestBodyData) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        requestBodyData = requestBodyData2;
                        objCallUpdateChallenge = obj;
                    }
                    Response response = (Response) objCallUpdateChallenge;
                    ClubEditFormFragment.this.stopLoading();
                    UpdateChallengeApiData.ResponseData responseData = (UpdateChallengeApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("callUpdateChallenge: " + response, new Object[0]);
                    UpdateChallengeApiData.ResponseData responseData2 = (UpdateChallengeApiData.ResponseData) response.body();
                    UpdateChallengeApiData.DataMap sysResponseData = responseData2 != null ? responseData2.getSysResponseData() : null;
                    String challengeUuid = this.$existData.getChallengeUuid();
                    final String challengeName = sysResponseData != null ? sysResponseData.getChallengeName() : null;
                    UpdateChallengeApiData.ResponseData responseData3 = (UpdateChallengeApiData.ResponseData) response.body();
                    String errorCode = responseData3 != null ? responseData3.getErrorCode() : null;
                    if (responseData == null || !responseData.getSuccess()) {
                        if (ClubEditFormFragment.this.shouldIgnoreError(errorCode)) {
                            unit = Unit.INSTANCE;
                        } else if (Intrinsics.areEqual(errorCode, ErrorCode.CHALLENGE_DUPLICATE_NAME_4013.getId())) {
                            ClubEditFormFragment clubEditFormFragment = ClubEditFormFragment.this;
                            String string = clubEditFormFragment.getString(R.string.challenge_title_duplicate);
                            String string2 = ClubEditFormFragment.this.getString(R.string.err_4013_use_system_suggested_name);
                            final ClubEditFormFragment clubEditFormFragment2 = ClubEditFormFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubEditFormFragment, string, string2, null, null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.updateChallenge.1.2
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
                                    EditText editText;
                                    if (challengeName != null) {
                                        ClubViewModel clubViewModel = clubEditFormFragment2.getClubViewModel();
                                        final String str = challengeName;
                                        clubViewModel.updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.updateChallenge.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final ChallengeFormData invoke(ChallengeFormData it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : str, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                                            }
                                        });
                                        FragmentClubEditFormBinding fragmentClubEditFormBindingAccess$getBinding = ClubEditFormFragment.access$getBinding(clubEditFormFragment2);
                                        if (fragmentClubEditFormBindingAccess$getBinding == null || (editText = fragmentClubEditFormBindingAccess$getBinding.etEventName) == null) {
                                            return;
                                        }
                                        editText.setText(challengeName);
                                    }
                                }
                            }, null, false, 108, null);
                            unit = Unit.INSTANCE;
                        } else {
                            if (!Intrinsics.areEqual(errorCode, ErrorCode.CHALLENGE_DUPLICATE_NAME_FAIL_GEN_NAME_4014.getId()) && !Intrinsics.areEqual(errorCode, ErrorCode.CHALLENGE_DUPLICATE_NAME_1_4015.getId())) {
                                Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.INVALID_DATE_FORMAT_1046.getId(), Boxing.boxInt(R.string.err_1046_invalid_date_format)), TuplesKt.to(ErrorCode.INVALID_ARGUMENT_1025.getId(), Boxing.boxInt(R.string.err_1025_invalid_argument)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_EXIST_4000.getId(), Boxing.boxInt(R.string.err_4000_challenge_not_exist)), TuplesKt.to(ErrorCode.CHALLENGE_INVALID_START_DATE_4005.getId(), Boxing.boxInt(R.string.err_4005_invalid_start_date)), TuplesKt.to(ErrorCode.CHALLENGE_INVALID_END_DATE_4004.getId(), Boxing.boxInt(R.string.err_4004_invalid_end_date)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_LEADER_4007.getId(), Boxing.boxInt(R.string.err_4007_not_challenge_leader)), TuplesKt.to(ErrorCode.CHALLENGE_INVALID_OPERATION_ON_CURRENT_ACTIVITY_STATUS_4008.getId(), Boxing.boxInt(R.string.err_4008_only_challenges_that_have_not_yet_started_can_be_modified)), TuplesKt.to(ErrorCode.CHALLENGE_CAN_NOT_MODIFY_PRIVACY_LEVEL_4010.getId(), Boxing.boxInt(R.string.err_4010_can_not_modify_privacy_level))).get(errorCode);
                                if (num != null) {
                                    ClubEditFormFragment clubEditFormFragment3 = ClubEditFormFragment.this;
                                    CustomDialogKt.showCustomDialog$default(clubEditFormFragment3, null, clubEditFormFragment3.getString(num.intValue()), ClubEditFormFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                                } else {
                                    ClubEditFormFragment clubEditFormFragment4 = ClubEditFormFragment.this;
                                    UpdateChallengeApiData.ResponseData responseData4 = (UpdateChallengeApiData.ResponseData) response.body();
                                    BaseFragment.handleUndefinedError$default(clubEditFormFragment4, "updateChallenge", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                                }
                            }
                            ClubEditFormFragment clubEditFormFragment5 = ClubEditFormFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubEditFormFragment5, null, "Network error, please try again.", clubEditFormFragment5.getString(R.string.confirm), null, null, null, false, 112, null);
                            unit = Unit.INSTANCE;
                        }
                        ClubEditFormFragment.this.stopLoading();
                        return unit;
                    }
                    if (requestBodyData.getChallengeType() == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
                        Timber.INSTANCE.d("若是race，跳轉到detail", new Object[0]);
                        if (challengeUuid != null) {
                            ClubEditFormFragment.this.resetAll();
                            ClubEditFormFragment.this.safeNavigateUp();
                        }
                    }
                    if (this.$isNewImg) {
                        File file = ClubEditFormFragment.this.tempResizeImgFile;
                        if (file != null) {
                            ClubEditFormFragment clubEditFormFragment6 = ClubEditFormFragment.this;
                            try {
                                Timber.INSTANCE.d("成功，接上傳圖片2", new Object[0]);
                                MainActivity mainActivity = clubEditFormFragment6.getMainActivity();
                                Uri uriForFile = mainActivity != null ? FileProvider.getUriForFile(mainActivity, mainActivity.getPackageName() + ".fileprovider", file) : null;
                                if (uriForFile != null) {
                                    clubEditFormFragment6.uploadCoverImage(uriForFile, challengeUuid);
                                }
                            } catch (IllegalArgumentException e) {
                                Timber.INSTANCE.e(e, "FileProvider error: " + file.getAbsolutePath(), new Object[0]);
                                CustomDialogKt.showCustomDialog$default(clubEditFormFragment6, null, clubEditFormFragment6.getString(R.string.image_processing_failed_msg), clubEditFormFragment6.getString(R.string.confirm), null, null, null, false, 112, null);
                            }
                        }
                    } else {
                        ClubEditFormFragment.this.resetAll();
                        ClubEditFormFragment.this.safeNavigateUp();
                    }
                } catch (IOException e2) {
                    Timber.INSTANCE.e(e2, "API call failed", new Object[0]);
                    String message = e2.getMessage();
                    if (message == null) {
                        message = e2.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubEditFormFragment.this, "updateChallenge", message, false, 4, null);
                }
                ClubEditFormFragment.this.stopLoading();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ClubEditFormFragment.this.stopLoading();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetAll() {
        getClubViewModel().resetChallengeFormData();
        this.tempResizeImgFile = null;
        this.photoUri = null;
    }

    static /* synthetic */ String toText$default(ClubEditFormFragment clubEditFormFragment, Object obj, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = "";
        }
        return clubEditFormFragment.toText(obj, str);
    }

    private final String toText(Object text, String defaultText) {
        if (text == null || Intrinsics.areEqual(text, AbstractJsonLexerKt.NULL)) {
            return StringsKt.replace$default(StringsKt.replace$default(String.valueOf(text), "\n", "", false, 4, (Object) null), "\r", "", false, 4, (Object) null);
        }
        return StringsKt.replace$default(StringsKt.replace$default(text.toString(), "\n", "", false, 4, (Object) null), "\r", "", false, 4, (Object) null);
    }

    private final boolean examineForm(ChallengeFormData data) {
        boolean z;
        if (data.getPhotoUri() != null || data.getChallengeType() == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
            z = true;
        } else {
            FragmentClubEditFormBinding binding = getBinding();
            TextView textView = binding != null ? binding.challengeFormTakePhotoError : null;
            if (textView != null) {
                textView.setText(getString(R.string.input_required));
            }
            FragmentClubEditFormBinding binding2 = getBinding();
            TextView textView2 = binding2 != null ? binding2.challengeFormTakePhotoError : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            z = false;
        }
        if (Intrinsics.areEqual(data.getChallengeName(), "")) {
            FragmentClubEditFormBinding binding3 = getBinding();
            TextView textView3 = binding3 != null ? binding3.tvEventNameError : null;
            if (textView3 != null) {
                textView3.setText(getString(R.string.input_required));
            }
            FragmentClubEditFormBinding binding4 = getBinding();
            TextView textView4 = binding4 != null ? binding4.tvEventNameError : null;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            z = false;
        }
        if (Intrinsics.areEqual(data.getIntroduction(), "")) {
            FragmentClubEditFormBinding binding5 = getBinding();
            TextView textView5 = binding5 != null ? binding5.tvEventDescriptionError : null;
            if (textView5 != null) {
                textView5.setText(getString(R.string.input_required));
            }
            FragmentClubEditFormBinding binding6 = getBinding();
            TextView textView6 = binding6 != null ? binding6.tvEventDescriptionError : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            z = false;
        }
        if (data.getChallengeType() == ChallengeTypeSettings.GOAL.getId() && data.getGoalValue() == null) {
            FragmentClubEditFormBinding binding7 = getBinding();
            TextView textView7 = binding7 != null ? binding7.tvTargetScoreError : null;
            if (textView7 != null) {
                textView7.setText(getString(R.string.input_required));
            }
            FragmentClubEditFormBinding binding8 = getBinding();
            TextView textView8 = binding8 != null ? binding8.tvTargetScoreError : null;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            z = false;
        }
        if (data.getChallengeType() != ChallengeTypeSettings.GOAL.getId() || !Intrinsics.areEqual(data.getGoalValue(), AudioStats.AUDIO_AMPLITUDE_NONE)) {
            return z;
        }
        FragmentClubEditFormBinding binding9 = getBinding();
        TextView textView9 = binding9 != null ? binding9.tvTargetScoreError : null;
        if (textView9 != null) {
            textView9.setText(getString(R.string.input_err_the_value_cannot_be_0));
        }
        FragmentClubEditFormBinding binding10 = getBinding();
        TextView textView10 = binding10 != null ? binding10.tvTargetScoreError : null;
        if (textView10 == null) {
            return false;
        }
        textView10.setVisibility(0);
        return false;
    }

    private final void createForm() {
        hideKeyboard();
        ChallengeFormData value = getClubViewModel().getEditChallengeDataForm().getValue();
        if (value != null) {
            boolean zExamineForm = examineForm(value);
            Timber.INSTANCE.d("CREATE form!: " + value, new Object[0]);
            if (zExamineForm) {
                createChallenge();
            } else {
                CustomDialogKt.showCustomDialog$default(this, null, getString(R.string.please_complete_all_required_fields), getString(R.string.confirm), null, null, null, false, 112, null);
            }
        }
    }

    private final void editSaveForm() {
        Timber.INSTANCE.d("SAVE", new Object[0]);
        ChallengeItemFullData value = getClubViewModel().getSelectedChallengeData().getValue();
        ChallengeFormData value2 = getClubViewModel().getEditChallengeDataForm().getValue();
        if (value2 != null) {
            boolean zExamineForm = examineForm(value2);
            Timber.INSTANCE.d("SAVE editSaveForm!: " + value2, new Object[0]);
            if (zExamineForm) {
                Timber.INSTANCE.d("PASS，updateChallenge", new Object[0]);
                if (value != null) {
                    updateChallenge(!Intrinsics.areEqual(value.getPhotoFileUrl(), String.valueOf(value2.getPhotoUri())));
                    return;
                }
                return;
            }
            CustomDialogKt.showCustomDialog$default(this, null, getString(R.string.please_complete_all_required_fields), getString(R.string.confirm), null, null, null, false, 112, null);
        }
    }

    static /* synthetic */ void setupEditScoreItemRecyclerView$default(ClubEditFormFragment clubEditFormFragment, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ChallengeScoreItemSettings.TOTAL_DISTANCE.getId();
        }
        clubEditFormFragment.setupEditScoreItemRecyclerView(i);
    }

    private final void setupEditScoreItemRecyclerView(int activeId) {
        RecyclerView recyclerView;
        ClubEditScoreItemAdapter clubEditScoreItemAdapter = this.adapter1;
        if (clubEditScoreItemAdapter != null) {
            if (clubEditScoreItemAdapter != null) {
                clubEditScoreItemAdapter.updateActiveId(activeId);
                return;
            }
            return;
        }
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.adapter1 = new ClubEditScoreItemAdapter(mainActivity, new ClubEditScoreItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$setupEditScoreItemRecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubEditScoreItemAdapter.OnItemClickListener
                public void onClick(int bindingAdapterPosition, ChallengeScoreItemSettings item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    Timber.INSTANCE.d("item click: " + item.getId(), new Object[0]);
                    this.this$0.updateActiveScoreItem(item.getId());
                }
            }, activeId, true);
        }
        FragmentClubEditFormBinding binding = getBinding();
        if (binding == null || (recyclerView = binding.rvEditScoreItem) == null) {
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
        recyclerView.setAdapter(this.adapter1);
        recyclerView.setLayoutManager(flexboxLayoutManager);
    }

    static /* synthetic */ void updateActiveScoreItem$default(ClubEditFormFragment clubEditFormFragment, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ChallengeScoreItemSettings.TOTAL_DISTANCE.getId();
        }
        clubEditFormFragment.updateActiveScoreItem(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateActiveScoreItem(final int activeId) {
        ClubEditScoreItemAdapter clubEditScoreItemAdapter = this.adapter1;
        if (clubEditScoreItemAdapter != null) {
            clubEditScoreItemAdapter.updateActiveId(activeId);
        }
        resetFocusValueInput(activeId);
        resetMachineTypeId(activeId);
        getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.updateActiveScoreItem.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : activeId, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
            }
        });
    }

    private final void resetFocusValueInput(int nowScoreItem) {
        EditText editText;
        FragmentClubEditFormBinding binding = getBinding();
        if (binding != null && (editText = binding.etTargetScore) != null) {
            editText.setText("");
        }
        getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.resetFocusValueInput.1
            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
            }
        });
        MainActivity mainActivity = getMainActivity();
        String formUnitText = mainActivity != null ? getFormUnitText(mainActivity, nowScoreItem, Global.INSTANCE.getUnitType()) : null;
        FragmentClubEditFormBinding binding2 = getBinding();
        EditText editText2 = binding2 != null ? binding2.etTargetScore : null;
        if (editText2 == null) {
            return;
        }
        editText2.setHint(formUnitText);
    }

    static /* synthetic */ void setupEditMachineTypeRecyclerView$default(ClubEditFormFragment clubEditFormFragment, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = ChallengeMachineTypeItems.TREADMILL.getId();
        }
        clubEditFormFragment.setupEditMachineTypeRecyclerView(num);
    }

    private final void setupEditMachineTypeRecyclerView(Integer activeId) {
        RecyclerView recyclerView;
        ClubEditMachineTypeAdapter clubEditMachineTypeAdapter = this.adapter2;
        if (clubEditMachineTypeAdapter != null) {
            if (clubEditMachineTypeAdapter != null) {
                clubEditMachineTypeAdapter.updateActiveId(activeId);
                return;
            }
            return;
        }
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.adapter2 = new ClubEditMachineTypeAdapter(mainActivity, new ClubEditMachineTypeAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$setupEditMachineTypeRecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubEditMachineTypeAdapter.OnItemClickListener
                public void onClick(int bindingAdapterPosition, ChallengeMachineTypeItems item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    Timber.INSTANCE.d("item machineType: " + item.getId(), new Object[0]);
                    this.this$0.updateMachineType(item.getId());
                }
            }, activeId, Integer.valueOf(ChallengeScoreItemSettings.TOTAL_DISTANCE.getId()), true);
        }
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        FragmentClubEditFormBinding binding = getBinding();
        if (binding == null || (recyclerView = binding.rvEditMachineType) == null) {
            return;
        }
        recyclerView.setAdapter(this.adapter2);
        recyclerView.setLayoutManager(flexboxLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMachineType(final Integer activeId) {
        Timber.INSTANCE.d("updateMachineType:" + activeId, new Object[0]);
        ClubEditMachineTypeAdapter clubEditMachineTypeAdapter = this.adapter2;
        if (clubEditMachineTypeAdapter != null) {
            clubEditMachineTypeAdapter.updateActiveId(activeId);
        }
        getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.updateMachineType.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : activeId, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
            }
        });
        if (activeId != null) {
            updateRaceList(activeId.intValue());
        }
    }

    private final void resetMachineTypeId(int itemScore) {
        final ChallengeMachineTypeItems challengeMachineTypeItemsFindFirstSupportId = ChallengeMachineTypeItems.INSTANCE.findFirstSupportId(Integer.valueOf(itemScore));
        Timber.INSTANCE.d("firstMachineSupportFocus:" + challengeMachineTypeItemsFindFirstSupportId, new Object[0]);
        if (challengeMachineTypeItemsFindFirstSupportId != null) {
            getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.resetMachineTypeId.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ChallengeFormData invoke(ChallengeFormData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : challengeMachineTypeItemsFindFirstSupportId.getId(), (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                }
            });
            ClubEditMachineTypeAdapter clubEditMachineTypeAdapter = this.adapter2;
            if (clubEditMachineTypeAdapter != null) {
                clubEditMachineTypeAdapter.updateActiveId(challengeMachineTypeItemsFindFirstSupportId.getId());
            }
            ClubEditMachineTypeAdapter clubEditMachineTypeAdapter2 = this.adapter2;
            if (clubEditMachineTypeAdapter2 != null) {
                clubEditMachineTypeAdapter2.updateItemScoreId(Integer.valueOf(itemScore));
            }
            Integer id2 = challengeMachineTypeItemsFindFirstSupportId.getId();
            if (id2 != null) {
                updateRaceList(id2.intValue());
            }
        }
    }

    static /* synthetic */ void setupEditPrivacyRecyclerView$default(ClubEditFormFragment clubEditFormFragment, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = Integer.valueOf(ChallengePrivacyLevelSettings.PRIVATE.getId());
        }
        clubEditFormFragment.setupEditPrivacyRecyclerView(num);
    }

    private final void setupEditPrivacyRecyclerView(Integer activeId) {
        RecyclerView recyclerView;
        ClubEditPrivacyAdapter clubEditPrivacyAdapter = this.adapter3;
        if (clubEditPrivacyAdapter != null) {
            if (clubEditPrivacyAdapter != null) {
                clubEditPrivacyAdapter.updateActiveId(activeId);
                return;
            }
            return;
        }
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.adapter3 = new ClubEditPrivacyAdapter(mainActivity, new ClubEditPrivacyAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$setupEditPrivacyRecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubEditPrivacyAdapter.OnItemClickListener
                public void onClick(int bindingAdapterPosition, ChallengePrivacyLevelSettings item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    Timber.INSTANCE.d("item privacy: " + item.getId(), new Object[0]);
                    this.this$0.updatePrivacy(item.getId());
                }
            }, activeId, true);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        FragmentClubEditFormBinding binding = getBinding();
        if (binding == null || (recyclerView = binding.rvEditPravicy) == null) {
            return;
        }
        recyclerView.setAdapter(this.adapter3);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePrivacy(final int activeId) {
        ClubEditPrivacyAdapter clubEditPrivacyAdapter = this.adapter3;
        if (clubEditPrivacyAdapter != null) {
            clubEditPrivacyAdapter.updateActiveId(Integer.valueOf(activeId));
        }
        getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.updatePrivacy.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : activeId, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
            }
        });
    }

    static /* synthetic */ void setupEditVirtualRaceDistanceRecyclerView$default(ClubEditFormFragment clubEditFormFragment, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = VirtualRaceCodeType.T_3K.getCode();
        }
        clubEditFormFragment.setupEditVirtualRaceDistanceRecyclerView(str);
    }

    private final void setupEditVirtualRaceDistanceRecyclerView(String activeId) {
        RecyclerView recyclerView;
        ClubEditRaceDistanceItemAdapter clubEditRaceDistanceItemAdapter = this.adapter4;
        if (clubEditRaceDistanceItemAdapter != null) {
            if (clubEditRaceDistanceItemAdapter != null) {
                clubEditRaceDistanceItemAdapter.updateActiveId(activeId);
                return;
            }
            return;
        }
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.adapter4 = new ClubEditRaceDistanceItemAdapter(mainActivity, new ClubEditRaceDistanceItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$setupEditVirtualRaceDistanceRecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubEditRaceDistanceItemAdapter.OnItemClickListener
                public void onClick(int bindingAdapterPosition, VirtualRaceCodeType item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    Timber.INSTANCE.d("item updateRaceDistance: " + item.getCode(), new Object[0]);
                    this.this$0.updateRaceDistance(item.getCode());
                }
            }, activeId, true);
        }
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        FragmentClubEditFormBinding binding = getBinding();
        if (binding == null || (recyclerView = binding.rvEditRaceDistance) == null) {
            return;
        }
        recyclerView.setAdapter(this.adapter4);
        recyclerView.setLayoutManager(flexboxLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRaceDistance(final String activeId) {
        FragmentClubEditFormBinding binding;
        ImageView imageView;
        ClubEditRaceDistanceItemAdapter clubEditRaceDistanceItemAdapter = this.adapter4;
        if (clubEditRaceDistanceItemAdapter != null) {
            clubEditRaceDistanceItemAdapter.updateActiveId(activeId);
        }
        getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.updateRaceDistance.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : activeId);
            }
        });
        VirtualRaceCodeType virtualRaceCodeTypeFromCode = VirtualRaceCodeType.INSTANCE.fromCode(activeId);
        Integer imageResourceId = virtualRaceCodeTypeFromCode != null ? virtualRaceCodeTypeFromCode.getImageResourceId() : null;
        if (imageResourceId == null || (binding = getBinding()) == null || (imageView = binding.imgRaceDistance) == null) {
            return;
        }
        imageView.setImageResource(imageResourceId.intValue());
    }

    private final void updateRaceList(int machineTypeId) {
        Timber.INSTANCE.d("updateRaceList:" + IntCompanionObject.INSTANCE, new Object[0]);
        List list = CollectionsKt.toList(VirtualRaceCodeType.INSTANCE.findByMachineTypeId(machineTypeId));
        ClubEditRaceDistanceItemAdapter clubEditRaceDistanceItemAdapter = this.adapter4;
        if (clubEditRaceDistanceItemAdapter != null) {
            clubEditRaceDistanceItemAdapter.submitList(list);
        }
        if (list.isEmpty()) {
            return;
        }
        updateRaceDistance(((VirtualRaceCodeType) CollectionsKt.first(list)).getCode());
    }

    private final void showStartDatePicker() {
        String startDate;
        ChallengeFormData value = getClubViewModel().getEditChallengeDataForm().getValue();
        if (value == null || (startDate = value.getStartDate()) == null) {
            return;
        }
        Timber.INSTANCE.d("startDateString: " + startDate, new Object[0]);
        Calendar calendar = Calendar.getInstance();
        Long lConvertStringDateToTimestamp$default = TimeTools.convertStringDateToTimestamp$default(TimeTools.INSTANCE, startDate, null, true, 2, null);
        if (lConvertStringDateToTimestamp$default != null) {
            calendar.setTimeInMillis(lConvertStringDateToTimestamp$default.longValue());
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda8
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                ClubEditFormFragment.showStartDatePicker$lambda$48(this.f$0, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        Intrinsics.checkNotNullExpressionValue(calendar2, "apply(...)");
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(11, 0);
        calendar3.set(12, 0);
        calendar3.set(13, 0);
        calendar3.set(14, 0);
        calendar3.add(5, 1);
        datePickerDialog.getDatePicker().setMinDate(calendar2.getTimeInMillis());
        if (this.argChallengeTypeId == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
            datePickerDialog.getDatePicker().setMinDate(calendar3.getTimeInMillis());
        }
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showStartDatePicker$lambda$48(ClubEditFormFragment this$0, DatePicker datePicker, int i, int i2, int i3) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        Timber.INSTANCE.d("startDateInput: " + TimeTools.INSTANCE.convertTimestampToStringDateISO(timeInMillis), new Object[0]);
        String strConvertTimestampToStringDateISO = TimeTools.INSTANCE.convertTimestampToStringDateISO(timeInMillis);
        final String strConvertToDisplayFormat = this$0.convertToDisplayFormat(strConvertTimestampToStringDateISO);
        String strConvertToDisplayFormatSpecialText = this$0.convertToDisplayFormatSpecialText(strConvertTimestampToStringDateISO);
        FragmentClubEditFormBinding binding = this$0.getBinding();
        if (binding != null && (editText3 = binding.etDateStart) != null) {
            editText3.setText(strConvertToDisplayFormatSpecialText);
        }
        FragmentClubEditFormBinding binding2 = this$0.getBinding();
        if (binding2 != null && (editText2 = binding2.etVirtualRaceDateStart) != null) {
            editText2.setText(strConvertToDisplayFormatSpecialText);
        }
        ChallengeFormData value = this$0.getClubViewModel().getEditChallengeDataForm().getValue();
        if (value != null) {
            String endDate = value.getEndDate();
            Timber.INSTANCE.d("currentEndDateDisplay:" + endDate, new Object[0]);
            if (!TimeTools.INSTANCE.isFirstDateEarly(strConvertToDisplayFormat, endDate)) {
                Timber.INSTANCE.i("endDate早於startDate - 調整endDate為startDate加一天", new Object[0]);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(timeInMillis);
                calendar2.add(6, 1);
                String strConvertTimestampToStringDateISO2 = TimeTools.INSTANCE.convertTimestampToStringDateISO(calendar2.getTimeInMillis());
                final String strConvertToDisplayFormat2 = this$0.convertToDisplayFormat(strConvertTimestampToStringDateISO2);
                String strConvertToDisplayFormatSpecialText2 = this$0.convertToDisplayFormatSpecialText(strConvertTimestampToStringDateISO2);
                FragmentClubEditFormBinding binding3 = this$0.getBinding();
                if (binding3 != null && (editText = binding3.etDateEnd) != null) {
                    editText.setText(strConvertToDisplayFormatSpecialText2);
                }
                this$0.getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$showStartDatePicker$datePickerDialog$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final ChallengeFormData invoke(ChallengeFormData it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : strConvertToDisplayFormat, (3967 & 8) != 0 ? it.endDate : strConvertToDisplayFormat2, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                    }
                });
            } else {
                this$0.getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$showStartDatePicker$datePickerDialog$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final ChallengeFormData invoke(ChallengeFormData it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : strConvertToDisplayFormat, (3967 & 8) != 0 ? it.endDate : null, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
                    }
                });
            }
        }
        this$0.updateDateCount();
    }

    private final void showEndDatePicker() {
        String endDate;
        Long lConvertStringDateToTimestamp$default;
        ChallengeFormData value = getClubViewModel().getEditChallengeDataForm().getValue();
        if (value == null || (endDate = value.getEndDate()) == null) {
            return;
        }
        Timber.INSTANCE.d("endDateString: " + endDate, new Object[0]);
        Calendar calendar = Calendar.getInstance();
        Long lConvertStringDateToTimestamp$default2 = TimeTools.convertStringDateToTimestamp$default(TimeTools.INSTANCE, endDate, null, true, 2, null);
        if (lConvertStringDateToTimestamp$default2 != null) {
            calendar.setTimeInMillis(lConvertStringDateToTimestamp$default2.longValue());
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$$ExternalSyntheticLambda0
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                ClubEditFormFragment.showEndDatePicker$lambda$52(this.f$0, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5));
        ChallengeFormData value2 = getClubViewModel().getEditChallengeDataForm().getValue();
        if (value2 != null && (lConvertStringDateToTimestamp$default = TimeTools.convertStringDateToTimestamp$default(TimeTools.INSTANCE, value2.getStartDate(), null, false, 6, null)) != null) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(lConvertStringDateToTimestamp$default.longValue());
            calendar2.add(6, 1);
            datePickerDialog.getDatePicker().setMinDate(calendar2.getTimeInMillis());
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTimeInMillis(lConvertStringDateToTimestamp$default.longValue());
            calendar3.add(6, 364);
            datePickerDialog.getDatePicker().setMaxDate(calendar3.getTimeInMillis());
        }
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEndDatePicker$lambda$52(ClubEditFormFragment this$0, DatePicker datePicker, int i, int i2, int i3) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        String strConvertTimestampToStringDateISO = TimeTools.INSTANCE.convertTimestampToStringDateISO(calendar.getTimeInMillis());
        final String strConvertToDisplayFormat = this$0.convertToDisplayFormat(strConvertTimestampToStringDateISO);
        String strConvertToDisplayFormatSpecialText = this$0.convertToDisplayFormatSpecialText(strConvertTimestampToStringDateISO);
        FragmentClubEditFormBinding binding = this$0.getBinding();
        if (binding != null && (editText = binding.etDateEnd) != null) {
            editText.setText(strConvertToDisplayFormatSpecialText);
        }
        this$0.getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$showEndDatePicker$datePickerDialog$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : strConvertToDisplayFormat, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
            }
        });
        this$0.updateDateCount();
    }

    private final void updateDateCount() {
        EditText editText;
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ChallengeFormData value = getClubViewModel().getEditChallengeDataForm().getValue();
        String endDate = value != null ? value.getEndDate() : null;
        ChallengeFormData value2 = getClubViewModel().getEditChallengeDataForm().getValue();
        String startDate = value2 != null ? value2.getStartDate() : null;
        Timber.INSTANCE.d("startDate " + startDate, new Object[0]);
        Timber.INSTANCE.d("endDate " + endDate, new Object[0]);
        if (startDate == null || endDate == null) {
            return;
        }
        long jBetween = ChronoUnit.DAYS.between(LocalDate.parse(startDate, dateTimeFormatterOfPattern), LocalDate.parse(endDate, dateTimeFormatterOfPattern)) + 1;
        Timber.INSTANCE.d("daysBetween " + jBetween, new Object[0]);
        FragmentClubEditFormBinding binding = getBinding();
        if (binding != null && (editText = binding.etDateCount) != null) {
            editText.setText(String.valueOf(jBetween));
        }
        this.challengeDateCount = (int) jBetween;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStartEndDate() {
        LocalDate localDateNow;
        EditText editText;
        String startDate;
        final DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateTimeFormatterWithLocale = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault());
        ChallengeFormData value = getClubViewModel().getEditChallengeDataForm().getValue();
        if (value == null || (startDate = value.getStartDate()) == null || (localDateNow = LocalDate.parse(startDate, dateTimeFormatterOfPattern)) == null) {
            localDateNow = LocalDate.now();
        }
        final LocalDate localDatePlusDays = localDateNow.plusDays(this.challengeDateCount - 1);
        Timber.INSTANCE.d("changed endDate:" + localDatePlusDays, new Object[0]);
        String str = localDatePlusDays.format(dateTimeFormatterWithLocale);
        FragmentClubEditFormBinding binding = getBinding();
        if (binding != null && (editText = binding.etDateEnd) != null) {
            editText.setText(str);
        }
        getClubViewModel().updateChallengeFormData(new Function1<ChallengeFormData, ChallengeFormData>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment.updateStartEndDate.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChallengeFormData invoke(ChallengeFormData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String str2 = localDatePlusDays.format(dateTimeFormatterOfPattern);
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return it.copy((3967 & 1) != 0 ? it.photoUri : null, (3967 & 2) != 0 ? it.challengeType : 0, (3967 & 4) != 0 ? it.startDate : null, (3967 & 8) != 0 ? it.endDate : str2, (3967 & 16) != 0 ? it.privacyLevel : 0, (3967 & 32) != 0 ? it.scoreItem : 0, (3967 & 64) != 0 ? it.goalValue : null, (3967 & 128) != 0 ? it.challengeName : null, (3967 & 256) != 0 ? it.introduction : null, (3967 & 512) != 0 ? it.onMachineType : null, (3967 & 1024) != 0 ? it.iconId : null, (3967 & 2048) != 0 ? it.virtualRaceCode : null);
            }
        });
    }

    private final void updatePreviewImage(Uri uri) {
        Timber.INSTANCE.d("newUri:" + uri, new Object[0]);
        if (uri == null) {
            return;
        }
        FragmentClubEditFormBinding binding = getBinding();
        TextView textView = binding != null ? binding.challengeFormTakePhotoError : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new C09201(uri, null), 2, null);
    }

    /* compiled from: ClubEditFormFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$updatePreviewImage$1", f = "ClubEditFormFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$updatePreviewImage$1, reason: invalid class name and case insensitive filesystem */
    static final class C09201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09201(Uri uri, Continuation<? super C09201> continuation) {
            super(2, continuation);
            this.$uri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubEditFormFragment.this.new C09201(this.$uri, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ImageView imageView;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FragmentClubEditFormBinding fragmentClubEditFormBindingAccess$getBinding = ClubEditFormFragment.access$getBinding(ClubEditFormFragment.this);
            if (fragmentClubEditFormBindingAccess$getBinding != null && (imageView = fragmentClubEditFormBindingAccess$getBinding.challengeFormPreviewPhoto) != null) {
                imageView.setImageURI(this.$uri);
            }
            FragmentClubEditFormBinding fragmentClubEditFormBindingAccess$getBinding2 = ClubEditFormFragment.access$getBinding(ClubEditFormFragment.this);
            LinearLayout linearLayout = fragmentClubEditFormBindingAccess$getBinding2 != null ? fragmentClubEditFormBindingAccess$getBinding2.challengeFormPreviewPhotoWrap : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            FragmentClubEditFormBinding fragmentClubEditFormBindingAccess$getBinding3 = ClubEditFormFragment.access$getBinding(ClubEditFormFragment.this);
            LinearLayout linearLayout2 = fragmentClubEditFormBindingAccess$getBinding3 != null ? fragmentClubEditFormBindingAccess$getBinding3.challengeFormTakePhotoWrap : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            return Unit.INSTANCE;
        }
    }

    private final boolean allPermissionsGranted() {
        MainActivity mainActivity = getMainActivity();
        return mainActivity != null && ContextCompat.checkSelfPermission(mainActivity, "android.permission.CAMERA") == 0;
    }

    private final void openCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        MainActivity mainActivity = getMainActivity();
        if ((mainActivity != null ? intent.resolveActivity(mainActivity.getPackageManager()) : null) != null) {
            try {
                File fileCreateImageFile = createImageFile();
                MainActivity mainActivity2 = getMainActivity();
                Uri uriForFile = mainActivity2 != null ? FileProvider.getUriForFile(mainActivity2, mainActivity2.getPackageName() + ".fileprovider", fileCreateImageFile) : null;
                this.photoUri = uriForFile;
                intent.putExtra("output", uriForFile);
                ActivityResultLauncher<Intent> activityResultLauncher = this.takePictureLauncher;
                if (activityResultLauncher != null) {
                    activityResultLauncher.launch(intent);
                    return;
                }
                return;
            } catch (IOException e) {
                Log.e("Camera", "創建圖片文件時出錯", e);
                return;
            }
        }
        Log.e("Camera", "沒有可用的相機應用");
    }

    private final File createImageFile() throws IOException {
        String str = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        FragmentActivity activity = getActivity();
        File file = new File(activity != null ? activity.getCacheDir() : null, "userTemp");
        if (!file.exists()) {
            file.mkdirs();
        }
        File fileCreateTempFile = File.createTempFile("JPEG_" + str + '_', SdkConstants.DOT_JPG, file);
        Intrinsics.checkNotNullExpressionValue(fileCreateTempFile, "createTempFile(...)");
        return fileCreateTempFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final File resizeImageWithGlide(Context context, Uri uri, int targetWidth, int targetHeight) {
        try {
            Bitmap bitmap = (Bitmap) Glide.with(context).asBitmap().load(uri).override(targetWidth, targetHeight).submit().get();
            Intrinsics.checkNotNull(bitmap);
            return bitmapToTempFile(context, bitmap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final File bitmapToTempFile(Context context, Bitmap bitmap) throws IOException {
        try {
            File file = new File(context.getCacheDir(), "userTemp");
            if (!file.exists() && !file.mkdirs()) {
                Timber.INSTANCE.e("Failed to create userTemp directory", new Object[0]);
                return null;
            }
            File fileCreateTempFile = File.createTempFile("userTemp" + System.currentTimeMillis(), ".tmp", file);
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            try {
                if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream)) {
                    Timber.INSTANCE.e("Failed to compress bitmap", new Object[0]);
                    fileCreateTempFile.delete();
                    CloseableKt.closeFinally(fileOutputStream, null);
                    return null;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
                Timber.INSTANCE.d("Created temp file: " + fileCreateTempFile.getAbsolutePath(), new Object[0]);
                return fileCreateTempFile;
            } finally {
            }
        } catch (Exception e) {
            Timber.INSTANCE.e(e, "Failed to create temp file from bitmap", new Object[0]);
            return null;
        }
    }

    private final String getFormUnitText(Context context, int scoreItem, boolean isImperial) {
        String string;
        if (scoreItem == ChallengeScoreItemSettings.TOTAL_CALORIES.getId()) {
            String string2 = context.getString(R.string.kcal);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (scoreItem == ChallengeScoreItemSettings.TOTAL_DISTANCE.getId()) {
            if (isImperial) {
                string = context.getString(R.string.mi);
            } else {
                string = context.getString(R.string.km);
            }
            Intrinsics.checkNotNull(string);
            return string;
        }
        if (scoreItem == ChallengeScoreItemSettings.TOTAL_TIME.getId()) {
            String string3 = context.getString(R.string.hours);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (scoreItem == ChallengeScoreItemSettings.SESSION.getId()) {
            String string4 = context.getString(R.string.session);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        return "";
    }

    private final String convertToDisplayFormatSpecialText(String isoDate) {
        String string;
        try {
            LocalDate localDate = LocalDate.parse(isoDate, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH));
            LocalDate localDateNow = LocalDate.now();
            LocalDate localDatePlusDays = localDateNow.plusDays(1L);
            if (Intrinsics.areEqual(localDate, localDateNow)) {
                string = getString(R.string.calendar_today);
            } else {
                string = Intrinsics.areEqual(localDate, localDatePlusDays) ? getString(R.string.calendar_tomorrow) : localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault()));
            }
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Exception e) {
            Timber.INSTANCE.e(e, "Date conversion error", new Object[0]);
            return isoDate;
        }
    }

    private final String convertToDisplayFormat(String isoDate) {
        try {
            String str = LocalDate.parse(isoDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e("Date conversion error: " + e.getMessage(), new Object[0]);
            return isoDate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String convertFromDisplayFormat(String displayDate) {
        try {
            String str = LocalDate.parse(displayDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e("Date conversion error: " + e.getMessage(), new Object[0]);
            return displayDate;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        resetAll();
    }
}
