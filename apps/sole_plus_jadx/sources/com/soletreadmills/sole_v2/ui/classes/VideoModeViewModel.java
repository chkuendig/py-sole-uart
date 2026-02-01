package com.soletreadmills.sole_v2.ui.classes;

import android.app.Application;
import android.content.Context;
import androidx.camera.video.AudioStats;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.android.SdkConstants;
import com.digifly.ble.data.YogaWorkoutData;
import com.digifly.ble.data.YogaWorkoutListData;
import com.digifly.ble.data.wear.WearHrData;
import com.google.gson.Gson;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2._data.classes.VideoDetailData;
import com.soletreadmills.sole_v2._data.club.DisplaySelectStatsData;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDatabase;
import com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataEntity;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._tools.SrtParser;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._tools.VideoUtils;
import com.soletreadmills.sole_v2._type.ClassType;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import com.soletreadmills.sole_v2._type.user.GenderType;
import com.soletreadmills.sole_v2.ble.data.FitnessMachineControlPointResponseData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.HrData;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import com.soletreadmills.sole_v2.listener.BluetoothCallbackListener;
import com.sun.jna.platform.win32.WinError;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import timber.log.Timber;

/* compiled from: VideoModeViewModel.kt */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010¡\u0001\u001a\u00030¢\u0001H\u0086@¢\u0006\u0003\u0010£\u0001J\u0011\u0010¤\u0001\u001a\u00030¢\u0001H\u0086@¢\u0006\u0003\u0010£\u0001J#\u0010¥\u0001\u001a\u00020\u00072\t\u0010¦\u0001\u001a\u0004\u0018\u00010+2\t\u0010§\u0001\u001a\u0004\u0018\u00010+¢\u0006\u0003\u0010¨\u0001J.\u0010©\u0001\u001a\u00020j2\t\u0010ª\u0001\u001a\u0004\u0018\u00010j2\t\u0010«\u0001\u001a\u0004\u0018\u00010j2\t\u0010¬\u0001\u001a\u0004\u0018\u00010j¢\u0006\u0003\u0010\u00ad\u0001J\u0018\u0010®\u0001\u001a\u00020\u00072\t\u0010¯\u0001\u001a\u0004\u0018\u00010j¢\u0006\u0003\u0010°\u0001J\b\u0010±\u0001\u001a\u00030¢\u0001J\u001a\u0010²\u0001\u001a\u00020\u00072\t\u0010³\u0001\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0003\u0010´\u0001J\u001a\u0010µ\u0001\u001a\u00020\u00072\t\u0010¯\u0001\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0003\u0010´\u0001J\u001a\u0010¶\u0001\u001a\u00020\u00072\t\u0010·\u0001\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0003\u0010¸\u0001J\u001d\u0010¹\u0001\u001a\u00020\u00072\b\u0010º\u0001\u001a\u00030»\u00012\b\u00104\u001a\u0004\u0018\u00010/H\u0002J\u0013\u0010¼\u0001\u001a\u00030¢\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0010J\n\u0010½\u0001\u001a\u00030¢\u0001H\u0014J\u0011\u0010¾\u0001\u001a\u00030¢\u0001H\u0086@¢\u0006\u0003\u0010£\u0001J\b\u0010¿\u0001\u001a\u00030¢\u0001J\u0011\u0010À\u0001\u001a\u00030¢\u0001H\u0086@¢\u0006\u0003\u0010£\u0001J\u0012\u0010Á\u0001\u001a\u00030¢\u00012\b\u0010Â\u0001\u001a\u00030»\u0001J>\u0010Ã\u0001\u001a\u00030¢\u00012\u000e\u0010\u009c\u0001\u001a\t\u0012\u0005\u0012\u00030\u009b\u00010\n2\u0007\u0010Ä\u0001\u001a\u0002072\t\u0010Å\u0001\u001a\u0004\u0018\u00010+2\b\u0010Æ\u0001\u001a\u00030Ç\u0001H\u0002¢\u0006\u0003\u0010È\u0001J$\u0010É\u0001\u001a\u00030¢\u00012\u0007\u0010Ê\u0001\u001a\u00020+2\u0007\u0010Ë\u0001\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u00010/J\n\u0010Ì\u0001\u001a\u00030¢\u0001H\u0002J\b\u0010Í\u0001\u001a\u00030¢\u0001J\b\u0010Î\u0001\u001a\u00030¢\u0001J\u0011\u0010Ï\u0001\u001a\u00030¢\u00012\u0007\u0010Ð\u0001\u001a\u000207J\u0011\u0010Ñ\u0001\u001a\u00030¢\u00012\u0007\u0010Ò\u0001\u001a\u00020+J\u0012\u0010Ó\u0001\u001a\u00030¢\u00012\b\u0010Â\u0001\u001a\u00030»\u0001J\u001a\u0010Ô\u0001\u001a\u00030¢\u00012\u0007\u0010Õ\u0001\u001a\u00020B2\u0007\u0010Ö\u0001\u001a\u00020BJ6\u0010×\u0001\u001a\u00030¢\u00012\u000e\u0010\u009c\u0001\u001a\t\u0012\u0005\u0012\u00030\u009b\u00010\n2\u0007\u0010Ä\u0001\u001a\u0002072\u000b\b\u0002\u0010Å\u0001\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0003\u0010Ø\u0001R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\n  *\u0004\u0018\u00010\u001f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R+\u00108\u001a\u0002072\u0006\u0010!\u001a\u0002078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010)\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010=\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R+\u0010?\u001a\u0002072\u0006\u0010!\u001a\u0002078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010)\u001a\u0004\b?\u00109\"\u0004\b@\u0010;R+\u0010C\u001a\u00020B2\u0006\u0010!\u001a\u00020B8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010)\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR+\u0010J\u001a\u00020I2\u0006\u0010!\u001a\u00020I8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010Q\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00101\"\u0004\bX\u00103R\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\\¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R+\u0010_\u001a\u0002072\u0006\u0010!\u001a\u0002078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bb\u0010)\u001a\u0004\b`\u00109\"\u0004\ba\u0010;R\u001d\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\\¢\u0006\b\n\u0000\u001a\u0004\bd\u0010^R+\u0010e\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bh\u0010)\u001a\u0004\bf\u0010\u001b\"\u0004\bg\u0010\u001dR\u001a\u0010i\u001a\u00020jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR+\u0010o\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\br\u0010)\u001a\u0004\bp\u0010\u001b\"\u0004\bq\u0010\u001dR+\u0010s\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bv\u0010)\u001a\u0004\bt\u0010\u001b\"\u0004\bu\u0010\u001dR+\u0010w\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bz\u0010)\u001a\u0004\bx\u0010\u001b\"\u0004\by\u0010\u001dR+\u0010{\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b~\u0010)\u001a\u0004\b|\u0010\u001b\"\u0004\b}\u0010\u001dR5\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010!\u001a\u0004\u0018\u00010\u007f8F@BX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b\u0085\u0001\u0010)\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001d\u0010\u0086\u0001\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u001b\"\u0005\b\u0088\u0001\u0010\u001dR\u0015\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R/\u0010\u008d\u0001\u001a\u00020I2\u0006\u0010!\u001a\u00020I8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010)\u001a\u0005\b\u008e\u0001\u0010L\"\u0005\b\u008f\u0001\u0010NR/\u0010\u0091\u0001\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0094\u0001\u0010)\u001a\u0005\b\u0092\u0001\u0010\u001b\"\u0005\b\u0093\u0001\u0010\u001dR/\u0010\u0095\u0001\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010)\u001a\u0005\b\u0096\u0001\u0010\u001b\"\u0005\b\u0097\u0001\u0010\u001dR<\u0010\u009c\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u00012\u000f\u0010\u0099\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u00018F@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001¨\u0006Ù\u0001"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/VideoModeViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_errorData", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "_selectedList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", "_statsList", "actualTimer", "Ljava/util/Timer;", "bleFtmsMachineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "getBleFtmsMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setBleFtmsMachineType", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)V", "bluetoothCallbackListener", "Lcom/soletreadmills/sole_v2/listener/BluetoothCallbackListener;", "getBluetoothCallbackListener", "()Lcom/soletreadmills/sole_v2/listener/BluetoothCallbackListener;", "classId", "getClassId", "()Ljava/lang/String;", "setClassId", "(Ljava/lang/String;)V", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "kotlin.jvm.PlatformType", "<set-?>", "Lcom/soletreadmills/sole_v2/ui/classes/CookieData;", "cookieData", "getCookieData", "()Lcom/soletreadmills/sole_v2/ui/classes/CookieData;", "setCookieData", "(Lcom/soletreadmills/sole_v2/ui/classes/CookieData;)V", "cookieData$delegate", "Landroidx/compose/runtime/MutableState;", "currentVideoMaxTime", "", "currentVideoTime", "durationVideoTime", "firstFtmsData", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "getFirstFtmsData", "()Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "setFirstFtmsData", "(Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;)V", "ftmsData", "getFtmsData", "setFtmsData", "", "isConnectingHr", "()Z", "setConnectingHr", "(Z)V", "isConnectingHr$delegate", "isDataLoaded", "setDataLoaded", "isLandscape", "setLandscape", "isLandscape$delegate", "", "lastPosition", "getLastPosition", "()J", "setLastPosition", "(J)V", "lastPosition$delegate", "", "musicVolume", "getMusicVolume", "()F", "setMusicVolume", "(F)V", "musicVolume$delegate", "Landroidx/compose/runtime/MutableFloatState;", "nowSelectPos", "getNowSelectPos", "()I", "setNowSelectPos", "(I)V", "oldFtmsData", "getOldFtmsData", "setOldFtmsData", "prefs", "Lcom/soletreadmills/sole_v2/_sharedPreferences/MySharedPreferences;", "selectedList", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedList", "()Lkotlinx/coroutines/flow/StateFlow;", "showSubtitles", "getShowSubtitles", "setShowSubtitles", "showSubtitles$delegate", "statsList", "getStatsList", "subtitle", "getSubtitle", "setSubtitle", "subtitle$delegate", "totalCalories", "", "getTotalCalories", "()D", "setTotalCalories", "(D)V", "tvDisplay1Title", "getTvDisplay1Title", "setTvDisplay1Title", "tvDisplay1Title$delegate", "tvDisplay2Title", "getTvDisplay2Title", "setTvDisplay2Title", "tvDisplay2Title$delegate", "tvDisplay3Title", "getTvDisplay3Title", "setTvDisplay3Title", "tvDisplay3Title$delegate", "tvDisplay4Title", "getTvDisplay4Title", "setTvDisplay4Title", "tvDisplay4Title$delegate", "Lcom/soletreadmills/sole_v2/_data/classes/VideoDetailData;", "videoDetailData", "getVideoDetailData", "()Lcom/soletreadmills/sole_v2/_data/classes/VideoDetailData;", "setVideoDetailData", "(Lcom/soletreadmills/sole_v2/_data/classes/VideoDetailData;)V", "videoDetailData$delegate", "videoId", "getVideoId", "setVideoId", "videoPlayerController", "Lcom/soletreadmills/sole_v2/ui/classes/VideoPlayerController;", "getVideoPlayerController", "()Lcom/soletreadmills/sole_v2/ui/classes/VideoPlayerController;", "videoProgress", "getVideoProgress", "setVideoProgress", "videoProgress$delegate", "videoStartTime", "getVideoStartTime", "setVideoStartTime", "videoStartTime$delegate", "videoTotalTime", "getVideoTotalTime", "setVideoTotalTime", "videoTotalTime$delegate", "value", "", "Lcom/digifly/ble/data/YogaWorkoutData;", "yogaWorkoutDataList", "getYogaWorkoutDataList", "()Ljava/util/List;", "setYogaWorkoutDataList", "(Ljava/util/List;)V", "apiGetClassVideo", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apiPostCompletedClassEvent", "calculateAveragePace", "totalTimeSec", "distance", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "calculateMets", "speed", "inclinePercent", "watt", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)D", "calculatePace", "speedKmh", "(Ljava/lang/Double;)Ljava/lang/String;", "collectVideoDataWithoutMachine", "convertDistance", "distanceM", "(Ljava/lang/Float;)Ljava/lang/String;", "convertSpeed", "convertTime", "seconds", "(Ljava/lang/Integer;)Ljava/lang/String;", "getDisplayValue", "type", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "loadStatsForMachine", "onCleared", "onTapFinish", "refreshSelectedList", "refreshSubtitlesState", "replaceSelectedItem", "newType", "saveFailedWorkoutData", "isFromSqlite", "entityId", "summaryTempDataDatabase", "Lcom/soletreadmills/sole_v2/_roomDataBase/summaryTempData/SummaryTempDataDatabase;", "(Ljava/util/List;ZLjava/lang/Integer;Lcom/soletreadmills/sole_v2/_roomDataBase/summaryTempData/SummaryTempDataDatabase;)V", "setDisPlayValue", "pos", "data", "startActualTimer", "stopTimer", "updateHrConnectionStatus", "updateOrientation", "isLandscapeNow", "updateSelection", "position", "updateSelectionWithNewType", "updateVideoProgress", "currentTimeMs", "totalTime", "uploadWorkoutData", "(Ljava/util/List;ZLjava/lang/Integer;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoModeViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<String> _errorData;
    private final MutableStateFlow<List<DisplaySelectStatsData>> _selectedList;
    private final MutableStateFlow<List<DisplaySelectStatsData>> _statsList;
    private Timer actualTimer;
    private BleFtmsMachineType bleFtmsMachineType;
    private final BluetoothCallbackListener bluetoothCallbackListener;
    private String classId;
    private final Context context;

    /* renamed from: cookieData$delegate, reason: from kotlin metadata */
    private final MutableState cookieData;
    private int currentVideoMaxTime;
    private int currentVideoTime;
    private int durationVideoTime;
    private FtmsBaseData firstFtmsData;
    private FtmsBaseData ftmsData;

    /* renamed from: isConnectingHr$delegate, reason: from kotlin metadata */
    private final MutableState isConnectingHr;
    private boolean isDataLoaded;

    /* renamed from: isLandscape$delegate, reason: from kotlin metadata */
    private final MutableState isLandscape;

    /* renamed from: lastPosition$delegate, reason: from kotlin metadata */
    private final MutableState lastPosition;

    /* renamed from: musicVolume$delegate, reason: from kotlin metadata */
    private final MutableFloatState musicVolume;
    private int nowSelectPos;
    private FtmsBaseData oldFtmsData;
    private final MySharedPreferences prefs;
    private final StateFlow<List<DisplaySelectStatsData>> selectedList;

    /* renamed from: showSubtitles$delegate, reason: from kotlin metadata */
    private final MutableState showSubtitles;
    private final StateFlow<List<DisplaySelectStatsData>> statsList;

    /* renamed from: subtitle$delegate, reason: from kotlin metadata */
    private final MutableState subtitle;
    private double totalCalories;

    /* renamed from: tvDisplay1Title$delegate, reason: from kotlin metadata */
    private final MutableState tvDisplay1Title;

    /* renamed from: tvDisplay2Title$delegate, reason: from kotlin metadata */
    private final MutableState tvDisplay2Title;

    /* renamed from: tvDisplay3Title$delegate, reason: from kotlin metadata */
    private final MutableState tvDisplay3Title;

    /* renamed from: tvDisplay4Title$delegate, reason: from kotlin metadata */
    private final MutableState tvDisplay4Title;

    /* renamed from: videoDetailData$delegate, reason: from kotlin metadata */
    private final MutableState videoDetailData;
    private String videoId;
    private final VideoPlayerController videoPlayerController;

    /* renamed from: videoProgress$delegate, reason: from kotlin metadata */
    private final MutableState videoProgress;

    /* renamed from: videoStartTime$delegate, reason: from kotlin metadata */
    private final MutableState videoStartTime;

    /* renamed from: videoTotalTime$delegate, reason: from kotlin metadata */
    private final MutableState videoTotalTime;
    private List<YogaWorkoutData> yogaWorkoutDataList;

    /* compiled from: VideoModeViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[BleFtmsMachineType.values().length];
            try {
                iArr[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleFtmsMachineType.BIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BleFtmsMachineType.STEPPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BleFtmsMachineType.ROWER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DisplayStatsType.values().length];
            try {
                iArr2[DisplayStatsType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DisplayStatsType.REMAINING_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DisplayStatsType.DISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[DisplayStatsType.SPEED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[DisplayStatsType.PACE.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[DisplayStatsType.AVG_PACE.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[DisplayStatsType.HEART_RATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[DisplayStatsType.INCLINE.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[DisplayStatsType.CALORIES.ordinal()] = 9;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[DisplayStatsType.ASCENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[DisplayStatsType.OUTPUT.ordinal()] = 11;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[DisplayStatsType.METS.ordinal()] = 12;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[DisplayStatsType.AVG_SPEED.ordinal()] = 13;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[DisplayStatsType.CADENCE.ordinal()] = 14;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[DisplayStatsType.AVG_CADENCE.ordinal()] = 15;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[DisplayStatsType.RESISTANCE.ordinal()] = 16;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[DisplayStatsType.STRIDES.ordinal()] = 17;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[DisplayStatsType.FLOORS.ordinal()] = 18;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[DisplayStatsType.STEPS.ordinal()] = 19;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[DisplayStatsType.CALORIES_PER_MIN.ordinal()] = 20;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[DisplayStatsType.STROKES.ordinal()] = 21;
            } catch (NoSuchFieldError unused26) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ClassType.values().length];
            try {
                iArr3[ClassType.Yoga.ordinal()] = 1;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr3[ClassType.Boxing.ordinal()] = 2;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr3[ClassType.FullSweet.ordinal()] = 3;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr3[ClassType.Meditation.ordinal()] = 4;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr3[ClassType.Stretching.ordinal()] = 5;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr3[ClassType.Srvo.ordinal()] = 6;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr3[ClassType.Sculpt.ordinal()] = 7;
            } catch (NoSuchFieldError unused33) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[GenderType.values().length];
            try {
                iArr4[GenderType.Male.ordinal()] = 1;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr4[GenderType.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused35) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    /* compiled from: VideoModeViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel", f = "VideoModeViewModel.kt", i = {0, 1, 1, 1, 2}, l = {WinError.ERROR_INVALID_SERVICE_CONTROL, 1098, WinError.ERROR_UNABLE_TO_LOCK_MEDIA, WinError.ERROR_BUS_RESET}, m = "apiGetClassVideo", n = {"this", "this", "httpCookieList", "videoURL", "this"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$apiGetClassVideo$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VideoModeViewModel.this.apiGetClassVideo(this);
        }
    }

    /* compiled from: VideoModeViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel", f = "VideoModeViewModel.kt", i = {}, l = {WinError.ERROR_FLOPPY_UNKNOWN_ERROR}, m = "apiPostCompletedClassEvent", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$apiPostCompletedClassEvent$1, reason: invalid class name and case insensitive filesystem */
    static final class C09001 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09001(Continuation<? super C09001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VideoModeViewModel.this.apiPostCompletedClassEvent(this);
        }
    }

    /* compiled from: VideoModeViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel", f = "VideoModeViewModel.kt", i = {0, 1}, l = {TypedValues.Custom.TYPE_REFERENCE, 911}, m = "onTapFinish", n = {"this", "this"}, s = {"L$0", "L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$onTapFinish$1, reason: invalid class name and case insensitive filesystem */
    static final class C09011 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09011(Continuation<? super C09011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VideoModeViewModel.this.onTapFinish(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoModeViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        MySharedPreferences companion = MySharedPreferences.INSTANCE.getInstance();
        this.prefs = companion;
        this.context = getApplication().getApplicationContext();
        this.videoDetailData = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.cookieData = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.subtitle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.showSubtitles = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(companion.getShowSubtitles()), null, 2, null);
        this.musicVolume = PrimitiveSnapshotStateKt.mutableFloatStateOf(companion.getMusicVolume());
        this.classId = "";
        this.videoId = "";
        this._errorData = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.isLandscape = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isConnectingHr = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.videoProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.videoStartTime = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("-:-", null, 2, null);
        this.videoTotalTime = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("-:-", null, 2, null);
        this.lastPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.videoPlayerController = new VideoPlayerController();
        MutableStateFlow<List<DisplaySelectStatsData>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._statsList = MutableStateFlow;
        this.statsList = MutableStateFlow;
        MutableStateFlow<List<DisplaySelectStatsData>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._selectedList = MutableStateFlow2;
        this.selectedList = MutableStateFlow2;
        this.tvDisplay1Title = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SdkConstants.RES_QUALIFIER_SEP, null, 2, null);
        this.tvDisplay2Title = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SdkConstants.RES_QUALIFIER_SEP, null, 2, null);
        this.tvDisplay3Title = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SdkConstants.RES_QUALIFIER_SEP, null, 2, null);
        this.tvDisplay4Title = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SdkConstants.RES_QUALIFIER_SEP, null, 2, null);
        this.yogaWorkoutDataList = new ArrayList();
        startActualTimer();
        this.bluetoothCallbackListener = new BluetoothCallbackListener() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$bluetoothCallbackListener$1
            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onConnected(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
                Intrinsics.checkNotNullParameter(deviceType, "deviceType");
                Intrinsics.checkNotNullParameter(macAddress, "macAddress");
            }

            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onConnecting(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
                Intrinsics.checkNotNullParameter(deviceType, "deviceType");
                Intrinsics.checkNotNullParameter(macAddress, "macAddress");
            }

            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onDisconnected(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
                Intrinsics.checkNotNullParameter(deviceType, "deviceType");
                Intrinsics.checkNotNullParameter(macAddress, "macAddress");
            }

            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onReceiveFitnessMachineControlPoint(FitnessMachineControlPointResponseData fitnessMachineControlPointResponseData) {
            }

            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onReceiveFitnessMachineStatus(FitnessMachineStatusType fitnessMachineStatusType) {
            }

            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onReceiveHrData(String hrDataJsonStr) {
            }

            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onReceiveSrvoData(String srvoData, String className) {
            }

            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onReceiveTrainingStatus(TrainingStatusType trainingStatusType) {
            }

            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onScan() {
            }

            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onScanResult(int callbackType, ScanResult scanResult) {
                Intrinsics.checkNotNullParameter(scanResult, "scanResult");
            }

            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onSrvoDeviceReady(String macAddress) {
                Intrinsics.checkNotNullParameter(macAddress, "macAddress");
            }

            @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
            public void onReceiveFtmsData(String ftmsDataJsonStr, String className) throws ClassNotFoundException, NumberFormatException {
                Class<?> cls;
                if (className == null || ftmsDataJsonStr == null) {
                    return;
                }
                try {
                    cls = Class.forName(className);
                } catch (Exception e) {
                    e.printStackTrace();
                    cls = null;
                }
                try {
                    this.this$0.setFtmsData((FtmsBaseData) new Gson().fromJson(ftmsDataJsonStr, (Type) cls));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.this$0.getOldFtmsData() != null) {
                    FtmsBaseData ftmsData = this.this$0.getFtmsData();
                    Integer elapsedTime = ftmsData != null ? ftmsData.getElapsedTime() : null;
                    FtmsBaseData oldFtmsData = this.this$0.getOldFtmsData();
                    if (Intrinsics.areEqual(elapsedTime, oldFtmsData != null ? oldFtmsData.getElapsedTime() : null)) {
                        return;
                    }
                }
                List<DisplaySelectStatsData> value = this.this$0.getSelectedList().getValue();
                int size = value.size();
                for (int i = 0; i < size; i++) {
                    DisplaySelectStatsData displaySelectStatsData = value.get(i);
                    VideoModeViewModel videoModeViewModel = this.this$0;
                    videoModeViewModel.setDisPlayValue(i, displaySelectStatsData, videoModeViewModel.getFtmsData());
                }
                VideoModeViewModel videoModeViewModel2 = this.this$0;
                videoModeViewModel2.setOldFtmsData(videoModeViewModel2.getFtmsData());
            }
        };
    }

    /* renamed from: isDataLoaded, reason: from getter */
    public final boolean getIsDataLoaded() {
        return this.isDataLoaded;
    }

    public final void setDataLoaded(boolean z) {
        this.isDataLoaded = z;
    }

    private final void setVideoDetailData(VideoDetailData videoDetailData) {
        this.videoDetailData.setValue(videoDetailData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final VideoDetailData getVideoDetailData() {
        return (VideoDetailData) this.videoDetailData.getValue();
    }

    private final void setCookieData(CookieData cookieData) {
        this.cookieData.setValue(cookieData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CookieData getCookieData() {
        return (CookieData) this.cookieData.getValue();
    }

    private final void setSubtitle(String str) {
        this.subtitle.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getSubtitle() {
        return (String) this.subtitle.getValue();
    }

    private final void setShowSubtitles(boolean z) {
        this.showSubtitles.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowSubtitles() {
        return ((Boolean) this.showSubtitles.getValue()).booleanValue();
    }

    private final void setMusicVolume(float f) {
        this.musicVolume.setFloatValue(f);
    }

    public final float getMusicVolume() {
        return this.musicVolume.getFloatValue();
    }

    public final String getClassId() {
        return this.classId;
    }

    public final void setClassId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.classId = str;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final void setVideoId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoId = str;
    }

    private final void setLandscape(boolean z) {
        this.isLandscape.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isLandscape() {
        return ((Boolean) this.isLandscape.getValue()).booleanValue();
    }

    private final void setConnectingHr(boolean z) {
        this.isConnectingHr.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isConnectingHr() {
        return ((Boolean) this.isConnectingHr.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getVideoProgress() {
        return ((Number) this.videoProgress.getValue()).floatValue();
    }

    public final void setVideoProgress(float f) {
        this.videoProgress.setValue(Float.valueOf(f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getVideoStartTime() {
        return (String) this.videoStartTime.getValue();
    }

    public final void setVideoStartTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoStartTime.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getVideoTotalTime() {
        return (String) this.videoTotalTime.getValue();
    }

    public final void setVideoTotalTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoTotalTime.setValue(str);
    }

    public final double getTotalCalories() {
        return this.totalCalories;
    }

    public final void setTotalCalories(double d) {
        this.totalCalories = d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long getLastPosition() {
        return ((Number) this.lastPosition.getValue()).longValue();
    }

    public final void setLastPosition(long j) {
        this.lastPosition.setValue(Long.valueOf(j));
    }

    public final VideoPlayerController getVideoPlayerController() {
        return this.videoPlayerController;
    }

    public final StateFlow<List<DisplaySelectStatsData>> getStatsList() {
        return this.statsList;
    }

    public final StateFlow<List<DisplaySelectStatsData>> getSelectedList() {
        return this.selectedList;
    }

    public final int getNowSelectPos() {
        return this.nowSelectPos;
    }

    public final void setNowSelectPos(int i) {
        this.nowSelectPos = i;
    }

    public final BleFtmsMachineType getBleFtmsMachineType() {
        return this.bleFtmsMachineType;
    }

    public final void setBleFtmsMachineType(BleFtmsMachineType bleFtmsMachineType) {
        this.bleFtmsMachineType = bleFtmsMachineType;
    }

    public final FtmsBaseData getFirstFtmsData() {
        return this.firstFtmsData;
    }

    public final void setFirstFtmsData(FtmsBaseData ftmsBaseData) {
        this.firstFtmsData = ftmsBaseData;
    }

    public final FtmsBaseData getOldFtmsData() {
        return this.oldFtmsData;
    }

    public final void setOldFtmsData(FtmsBaseData ftmsBaseData) {
        this.oldFtmsData = ftmsBaseData;
    }

    private final void setTvDisplay1Title(String str) {
        this.tvDisplay1Title.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getTvDisplay1Title() {
        return (String) this.tvDisplay1Title.getValue();
    }

    private final void setTvDisplay2Title(String str) {
        this.tvDisplay2Title.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getTvDisplay2Title() {
        return (String) this.tvDisplay2Title.getValue();
    }

    private final void setTvDisplay3Title(String str) {
        this.tvDisplay3Title.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getTvDisplay3Title() {
        return (String) this.tvDisplay3Title.getValue();
    }

    private final void setTvDisplay4Title(String str) {
        this.tvDisplay4Title.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getTvDisplay4Title() {
        return (String) this.tvDisplay4Title.getValue();
    }

    public final FtmsBaseData getFtmsData() {
        return this.ftmsData;
    }

    public final void setFtmsData(FtmsBaseData ftmsBaseData) {
        this.ftmsData = ftmsBaseData;
    }

    public final List<YogaWorkoutData> getYogaWorkoutDataList() {
        List<YogaWorkoutData> list;
        synchronized (this) {
            list = this.yogaWorkoutDataList;
        }
        return list;
    }

    public final void setYogaWorkoutDataList(List<YogaWorkoutData> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this) {
            this.yogaWorkoutDataList = value;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final BluetoothCallbackListener getBluetoothCallbackListener() {
        return this.bluetoothCallbackListener;
    }

    private final String convertDistance(Float distanceM) {
        if (distanceM == null) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(distanceM.floatValue()));
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(1000);
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
            BigDecimal bigDecimalDivide = bigDecimal.divide(bigDecimalValueOf, 4, RoundingMode.FLOOR);
            if (Global.INSTANCE.getUnitType()) {
                bigDecimalDivide = new BigDecimal(UnitConversion.INSTANCE.getMi(bigDecimalDivide.toString()));
            }
            DecimalFormat decimalFormat = new DecimalFormat("#0.##", DecimalFormatSymbols.getInstance(Locale.US));
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            String str = decimalFormat.format(bigDecimalDivide);
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return SdkConstants.RES_QUALIFIER_SEP;
        }
    }

    private final String convertTime(Integer seconds) {
        return TimeTools.INSTANCE.secToTime02(seconds != null ? seconds.intValue() : 0L, false);
    }

    private final String convertSpeed(Float speedKmh) throws NumberFormatException {
        double dFloatValue;
        if (speedKmh == null) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        try {
            if (Global.INSTANCE.getUnitType()) {
                dFloatValue = Double.parseDouble(UnitConversion.INSTANCE.getMi(speedKmh.toString()));
            } else {
                dFloatValue = speedKmh.floatValue();
            }
            DecimalFormat decimalFormat = new DecimalFormat("#0.#", DecimalFormatSymbols.getInstance(Locale.US));
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            String str = decimalFormat.format(dFloatValue);
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return SdkConstants.RES_QUALIFIER_SEP;
        }
    }

    public final String calculatePace(Double speedKmh) throws NumberFormatException {
        double dDoubleValue;
        if (speedKmh == null || speedKmh.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        try {
            if (Global.INSTANCE.getUnitType()) {
                dDoubleValue = Double.parseDouble(UnitConversion.INSTANCE.getMi(speedKmh.toString()));
            } else {
                dDoubleValue = speedKmh.doubleValue();
            }
            double d = 60.0d / dDoubleValue;
            int i = (int) d;
            int iRoundToInt = MathKt.roundToInt((d - i) * 60);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(iRoundToInt)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return SdkConstants.RES_QUALIFIER_SEP;
        }
    }

    public final String calculateAveragePace(Integer totalTimeSec, Integer distance) {
        double dDoubleValue;
        if (totalTimeSec == null || totalTimeSec.intValue() <= 0 || distance == null || distance.intValue() <= 0) {
            return "0:00";
        }
        try {
            float fIntValue = distance.intValue() / 1000.0f;
            if (Global.INSTANCE.getUnitType()) {
                Double doubleOrNull = StringsKt.toDoubleOrNull(UnitConversion.INSTANCE.getMi(String.valueOf(fIntValue)));
                if (doubleOrNull == null) {
                    return "0:00";
                }
                dDoubleValue = doubleOrNull.doubleValue();
            } else {
                dDoubleValue = fIntValue;
            }
            int iIntValue = (int) (totalTimeSec.intValue() / dDoubleValue);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue / 60), Integer.valueOf(iIntValue % 60)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return "0:00";
        }
    }

    public final double calculateMets(Double speed, Double inclinePercent, Double watt) throws NumberFormatException {
        VideoModeViewModel videoModeViewModel;
        double d;
        double d2;
        double d3;
        String weight;
        LoginUserData loginUserData = Global.userData;
        double d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (loginUserData == null || (weight = loginUserData.getWeight()) == null) {
            videoModeViewModel = this;
            d = 0.0d;
        } else {
            d = Double.parseDouble(weight);
            videoModeViewModel = this;
        }
        try {
            BleFtmsMachineType bleFtmsMachineType = videoModeViewModel.bleFtmsMachineType;
            int i = bleFtmsMachineType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[bleFtmsMachineType.ordinal()];
            if (i == 1) {
                double dDoubleValue = speed != null ? speed.doubleValue() : 0.0d;
                double d5 = 26.8d * dDoubleValue;
                double dDoubleValue2 = (inclinePercent != null ? inclinePercent.doubleValue() : 0.0d) / 100.0d;
                if (dDoubleValue >= 4.5d) {
                    d2 = (0.2d * d5) + 3.5d;
                    d3 = d5 * 0.9d;
                } else {
                    d2 = (0.1d * d5) + 3.5d;
                    d3 = d5 * 1.8d;
                }
                double d6 = d2 + (d3 * dDoubleValue2);
                if (d6 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    d4 = d6 / 3.5d;
                }
            } else if (i == 2 || i == 3) {
                double dDoubleValue3 = (watt != null ? watt.doubleValue() : 0.0d) * 6;
                if (dDoubleValue3 > AudioStats.AUDIO_AMPLITUDE_NONE && d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    d4 = (7 + ((dDoubleValue3 * 1.8d) / d)) / 3.5d;
                }
            }
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
        return MathKt.roundToInt(d4 * 10) / 10.0d;
    }

    public final void setDisPlayValue(int pos, DisplaySelectStatsData data, FtmsBaseData ftmsData) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(data, "data");
        String displayValue = getDisplayValue(data.getType(), ftmsData);
        if (this.firstFtmsData == null) {
            this.firstFtmsData = ftmsData;
            BleDataManager.getInstance().setFirstFtmsData(this.firstFtmsData);
            return;
        }
        if (pos == 0) {
            setTvDisplay1Title(displayValue);
            return;
        }
        if (pos == 1) {
            setTvDisplay2Title(displayValue);
        } else if (pos == 2) {
            setTvDisplay3Title(displayValue);
        } else {
            if (pos != 3) {
                return;
            }
            setTvDisplay4Title(displayValue);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x0230 A[PHI: r5
      0x0230: PHI (r5v6 java.lang.String) = (r5v5 java.lang.String), (r5v9 java.lang.String), (r5v14 java.lang.String) binds: [B:320:0x0425, B:250:0x032b, B:179:0x022b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e A[PHI: r1
      0x005e: PHI (r1v13 java.lang.String) = 
      (r1v7 java.lang.String)
      (r1v17 java.lang.String)
      (r1v30 java.lang.String)
      (r1v44 java.lang.String)
      (r1v51 java.lang.String)
      (r1v58 java.lang.String)
      (r1v61 java.lang.String)
     binds: [B:374:0x050f, B:320:0x0425, B:250:0x032b, B:179:0x022b, B:111:0x0158, B:19:0x003c, B:29:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0516 A[PHI: r13
      0x0516: PHI (r13v2 java.lang.String) = (r13v1 java.lang.String), (r13v5 java.lang.String), (r13v10 java.lang.String), (r13v21 java.lang.String) binds: [B:374:0x050f, B:320:0x0425, B:250:0x032b, B:97:0x013d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0518 A[PHI: r12
      0x0518: PHI (r12v4 java.lang.String) = 
      (r12v2 java.lang.String)
      (r12v7 java.lang.String)
      (r12v11 java.lang.String)
      (r12v16 java.lang.String)
      (r12v20 java.lang.String)
     binds: [B:374:0x050f, B:320:0x0425, B:250:0x032b, B:179:0x022b, B:96:0x013b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x051a A[PHI: r11
      0x051a: PHI (r11v4 java.lang.String) = 
      (r11v2 java.lang.String)
      (r11v7 java.lang.String)
      (r11v11 java.lang.String)
      (r11v15 java.lang.String)
      (r11v22 java.lang.String)
     binds: [B:374:0x050f, B:320:0x0425, B:250:0x032b, B:179:0x022b, B:95:0x0139] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:380:0x051c A[PHI: r10
      0x051c: PHI (r10v5 java.lang.String) = (r10v3 java.lang.String), (r10v8 java.lang.String), (r10v12 java.lang.String), (r10v16 java.lang.String) binds: [B:374:0x050f, B:320:0x0425, B:250:0x032b, B:179:0x022b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:381:0x051e A[PHI: r9
      0x051e: PHI (r9v2 java.lang.String) = (r9v1 java.lang.String), (r9v7 java.lang.String), (r9v15 java.lang.String), (r9v21 java.lang.String) binds: [B:374:0x050f, B:320:0x0425, B:250:0x032b, B:179:0x022b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0520 A[PHI: r8
      0x0520: PHI (r8v4 java.lang.String) = (r8v2 java.lang.String), (r8v9 java.lang.String), (r8v16 java.lang.String), (r8v20 java.lang.String) binds: [B:374:0x050f, B:320:0x0425, B:250:0x032b, B:179:0x022b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0522 A[PHI: r4
      0x0522: PHI (r4v5 java.lang.String) = 
      (r4v3 java.lang.String)
      (r4v8 java.lang.String)
      (r4v12 java.lang.String)
      (r4v17 java.lang.String)
      (r4v22 java.lang.String)
     binds: [B:374:0x050f, B:320:0x0425, B:250:0x032b, B:179:0x022b, B:113:0x015c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0524 A[PHI: r6
      0x0524: PHI (r6v7 java.lang.String) = (r6v4 java.lang.String), (r6v14 java.lang.String), (r6v22 java.lang.String), (r6v26 java.lang.String) binds: [B:374:0x050f, B:320:0x0425, B:250:0x032b, B:179:0x022b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0526 A[PHI: r3
      0x0526: PHI (r3v5 java.lang.String) = (r3v4 java.lang.String), (r3v11 java.lang.String), (r3v17 java.lang.String), (r3v23 java.lang.String) binds: [B:374:0x050f, B:320:0x0425, B:250:0x032b, B:179:0x022b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0528 A[PHI: r23
      0x0528: PHI (r23v4 java.lang.String) = (r23v2 java.lang.String), (r23v7 java.lang.String), (r23v14 java.lang.String) binds: [B:374:0x050f, B:320:0x0425, B:250:0x032b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String getDisplayValue(com.soletreadmills.sole_v2._type.DisplayStatsType r22, com.soletreadmills.sole_v2.ble.data.FtmsBaseData r23) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.getDisplayValue(com.soletreadmills.sole_v2._type.DisplayStatsType, com.soletreadmills.sole_v2.ble.data.FtmsBaseData):java.lang.String");
    }

    public final void loadStatsForMachine(BleFtmsMachineType type) {
        List listListOf;
        Set of;
        if (this._statsList.getValue().isEmpty()) {
            int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.SPEED, DisplayStatsType.PACE, DisplayStatsType.AVG_PACE, DisplayStatsType.HEART_RATE, DisplayStatsType.INCLINE, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.ASCENT, DisplayStatsType.OUTPUT});
                of = SetsKt.setOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CALORIES, DisplayStatsType.PACE});
            } else if (i == 2) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.RESISTANCE, DisplayStatsType.SPEED, DisplayStatsType.AVG_SPEED, DisplayStatsType.HEART_RATE, DisplayStatsType.CADENCE, DisplayStatsType.AVG_CADENCE, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.OUTPUT});
                of = SetsKt.setOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.CALORIES});
            } else if (i == 3) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.RESISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.AVG_CADENCE, DisplayStatsType.HEART_RATE, DisplayStatsType.INCLINE, DisplayStatsType.STRIDES, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.OUTPUT});
                of = SetsKt.setOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.CALORIES});
            } else if (i == 4) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.ASCENT, DisplayStatsType.RESISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.AVG_CADENCE, DisplayStatsType.HEART_RATE, DisplayStatsType.FLOORS, DisplayStatsType.STEPS, DisplayStatsType.CALORIES, DisplayStatsType.CALORIES_PER_MIN, DisplayStatsType.METS});
                of = SetsKt.setOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.ASCENT, DisplayStatsType.CALORIES, DisplayStatsType.STEPS});
            } else if (i == 5) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.RESISTANCE, DisplayStatsType.PACE, DisplayStatsType.AVG_PACE, DisplayStatsType.HEART_RATE, DisplayStatsType.CADENCE, DisplayStatsType.STROKES, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.OUTPUT});
                of = SetsKt.setOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CALORIES, DisplayStatsType.PACE});
            } else {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.CALORIES, DisplayStatsType.HEART_RATE});
                of = SetsKt.setOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.CALORIES, DisplayStatsType.HEART_RATE});
            }
            MutableStateFlow<List<DisplaySelectStatsData>> mutableStateFlow = this._statsList;
            List<DisplayStatsType> list = listListOf;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (DisplayStatsType displayStatsType : list) {
                arrayList.add(new DisplaySelectStatsData(displayStatsType, of.contains(displayStatsType), false, 4, null));
            }
            mutableStateFlow.setValue(arrayList);
            refreshSelectedList();
        }
    }

    public final void updateSelection(int position) {
        List<DisplaySelectStatsData> value = this._selectedList.getValue();
        List<DisplaySelectStatsData> value2 = this._statsList.getValue();
        if (position < 0 || position >= value.size()) {
            return;
        }
        this.nowSelectPos = position;
        DisplayStatsType type = value.get(position).getType();
        MutableStateFlow<List<DisplaySelectStatsData>> mutableStateFlow = this._statsList;
        List<DisplaySelectStatsData> list = value2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DisplaySelectStatsData displaySelectStatsData : list) {
            arrayList.add(DisplaySelectStatsData.copy$default(displaySelectStatsData, null, false, displaySelectStatsData.getType() == type, 3, null));
        }
        mutableStateFlow.setValue(arrayList);
        MutableStateFlow<List<DisplaySelectStatsData>> mutableStateFlow2 = this._selectedList;
        List<DisplaySelectStatsData> list2 = value;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DisplaySelectStatsData displaySelectStatsData2 : list2) {
            arrayList2.add(DisplaySelectStatsData.copy$default(displaySelectStatsData2, null, false, displaySelectStatsData2.getType() == type, 3, null));
        }
        mutableStateFlow2.setValue(arrayList2);
    }

    public final void refreshSelectedList() {
        MutableStateFlow<List<DisplaySelectStatsData>> mutableStateFlow = this._selectedList;
        List<DisplaySelectStatsData> value = this._statsList.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (((DisplaySelectStatsData) obj).isSelect()) {
                arrayList.add(obj);
            }
        }
        mutableStateFlow.setValue(arrayList);
    }

    public final void updateSelectionWithNewType(DisplayStatsType newType) {
        Intrinsics.checkNotNullParameter(newType, "newType");
        MutableStateFlow<List<DisplaySelectStatsData>> mutableStateFlow = this._statsList;
        List<DisplaySelectStatsData> value = mutableStateFlow.getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
        for (DisplaySelectStatsData displaySelectStatsDataCopy$default : value) {
            if (displaySelectStatsDataCopy$default.getNowSelect()) {
                displaySelectStatsDataCopy$default = DisplaySelectStatsData.copy$default(displaySelectStatsDataCopy$default, null, false, false, 1, null);
            } else if (displaySelectStatsDataCopy$default.getType() == newType) {
                displaySelectStatsDataCopy$default = DisplaySelectStatsData.copy$default(displaySelectStatsDataCopy$default, null, true, true, 1, null);
            }
            arrayList.add(displaySelectStatsDataCopy$default);
        }
        mutableStateFlow.setValue(arrayList);
        replaceSelectedItem(newType);
    }

    public final void replaceSelectedItem(DisplayStatsType newType) {
        Object next;
        Intrinsics.checkNotNullParameter(newType, "newType");
        List<DisplaySelectStatsData> value = this._statsList.getValue();
        List<DisplaySelectStatsData> mutableList = CollectionsKt.toMutableList((Collection) this._selectedList.getValue());
        int size = mutableList.size();
        int i = this.nowSelectPos;
        if (i < 0 || i >= size) {
            return;
        }
        boolean nowSelect = mutableList.get(i).getNowSelect();
        Iterator<T> it = value.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((DisplaySelectStatsData) next).getType() == newType) {
                    break;
                }
            }
        }
        DisplaySelectStatsData displaySelectStatsData = (DisplaySelectStatsData) next;
        if (displaySelectStatsData == null) {
            return;
        }
        mutableList.set(this.nowSelectPos, DisplaySelectStatsData.copy$default(displaySelectStatsData, null, true, nowSelect, 1, null));
        this._selectedList.setValue(mutableList);
    }

    public final void updateHrConnectionStatus() {
        setConnectingHr(BleManager.getInstance().isConnectedHr());
    }

    public final void updateOrientation(boolean isLandscapeNow) {
        setLandscape(isLandscapeNow);
    }

    public final Object refreshSubtitlesState(Continuation<? super Unit> continuation) {
        Object objLoadSubtitles;
        setShowSubtitles(this.prefs.getShowSubtitles());
        setMusicVolume(this.prefs.getMusicVolume());
        if (getVideoDetailData() != null) {
            VideoUtils videoUtils = VideoUtils.INSTANCE;
            VideoDetailData videoDetailData = getVideoDetailData();
            Intrinsics.checkNotNull(videoDetailData);
            String srtURL = videoUtils.getSrtURL(videoDetailData);
            if (srtURL != null && (objLoadSubtitles = SrtParser.INSTANCE.getShared().loadSubtitles(srtURL, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return objLoadSubtitles;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onTapFinish(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.C09011
            if (r0 == 0) goto L14
            r0 = r10
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$onTapFinish$1 r0 = (com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.C09011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$onTapFinish$1 r0 = new com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$onTapFinish$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 500(0x1f4, double:2.47E-321)
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L44
            if (r2 == r6) goto L3c
            if (r2 != r5) goto L34
            java.lang.Object r0 = r0.L$0
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r0 = (com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel) r0
            kotlin.ResultKt.throwOnFailure(r10)
            r3 = r0
            goto L75
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3c:
            java.lang.Object r2 = r0.L$0
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r2 = (com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L5e
        L44:
            kotlin.ResultKt.throwOnFailure(r10)
            com.soletreadmills.sole_v2._manager.BleManager r10 = com.soletreadmills.sole_v2._manager.BleManager.getInstance()
            no.nordicsemi.android.ble.data.Data r2 = com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlPointCmd.pause()
            r10.sendCmdFtms(r2)
            r0.L$0 = r9
            r0.label = r6
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r3, r0)
            if (r10 != r1) goto L5d
            return r1
        L5d:
            r2 = r9
        L5e:
            com.soletreadmills.sole_v2._manager.BleManager r10 = com.soletreadmills.sole_v2._manager.BleManager.getInstance()
            no.nordicsemi.android.ble.data.Data r6 = com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlPointCmd.stop()
            r10.sendCmdFtms(r6)
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r3, r0)
            if (r10 != r1) goto L74
            return r1
        L74:
            r3 = r2
        L75:
            com.soletreadmills.sole_v2._data.classes.VideoDetailData r10 = r3.getVideoDetailData()
            if (r10 == 0) goto L80
            com.soletreadmills.sole_v2._type.ClassType r10 = r10.getClassType()
            goto L81
        L80:
            r10 = 0
        L81:
            if (r10 != 0) goto L85
            r10 = -1
            goto L8d
        L85:
            int[] r0 = com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.WhenMappings.$EnumSwitchMapping$2
            int r10 = r10.ordinal()
            r10 = r0[r10]
        L8d:
            switch(r10) {
                case 1: goto L98;
                case 2: goto L98;
                case 3: goto L98;
                case 4: goto L98;
                case 5: goto L98;
                case 6: goto L98;
                case 7: goto L98;
                default: goto L90;
            }
        L90:
            com.soletreadmills.sole_v2.ble.manager.BleDataManager r10 = com.soletreadmills.sole_v2.ble.manager.BleDataManager.getInstance()
            r10.uploadSummaryData()
            goto La3
        L98:
            java.util.List r4 = r3.getYogaWorkoutDataList()
            r7 = 4
            r8 = 0
            r5 = 0
            r6 = 0
            uploadWorkoutData$default(r3, r4, r5, r6, r7, r8)
        La3:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.onTapFinish(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void updateVideoProgress(long currentTimeMs, long totalTime) {
        long j = 1000;
        int i = (int) (currentTimeMs / j);
        int i2 = (int) (totalTime / j);
        setSubtitle(SrtParser.INSTANCE.getShared().updateSubtitle(currentTimeMs));
        this.currentVideoTime = i;
        setVideoStartTime(VideoModeViewModelKt.formattedTime(i));
        this.durationVideoTime = i2;
        setVideoTotalTime(VideoModeViewModelKt.formattedTime(i2));
        setVideoProgress(this.currentVideoTime / this.durationVideoTime);
    }

    private final void startActualTimer() {
        Timer timer = new Timer();
        this.actualTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.startActualTimer.1

            /* compiled from: VideoModeViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$startActualTimer$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ClassType.values().length];
                    try {
                        iArr[ClassType.Yoga.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ClassType.Boxing.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ClassType.Meditation.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[ClassType.Stretching.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[ClassType.Sculpt.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws NumberFormatException {
                VideoModeViewModel.this.currentVideoMaxTime++;
                VideoDetailData videoDetailData = VideoModeViewModel.this.getVideoDetailData();
                ClassType classType = videoDetailData != null ? videoDetailData.getClassType() : null;
                int i = classType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[classType.ordinal()];
                if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                    VideoModeViewModel.this.collectVideoDataWithoutMachine();
                }
            }
        }, 1000L, 1000L);
    }

    public final void stopTimer() {
        Timer timer = this.actualTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.actualTimer = null;
    }

    public final void collectVideoDataWithoutMachine() throws NumberFormatException {
        double d;
        String string;
        ClassType classType;
        double dIntValue;
        double d2;
        String weight;
        Double doubleOrNull;
        if (BleManager.getInstance().isConnectedFtms()) {
            return;
        }
        HrData nowHrData = BleDataManager.getInstance().getNowHrData();
        String rawValue = null;
        Integer hr = nowHrData != null ? nowHrData.getHr() : null;
        if (BleDataManager.nowWearHrData != null) {
            WearHrData wearHrData = BleDataManager.nowWearHrData;
            Intrinsics.checkNotNull(wearHrData);
            if (wearHrData.checkTimeInRangeAndGetValue() >= 0) {
                WearHrData wearHrData2 = BleDataManager.nowWearHrData;
                hr = wearHrData2 != null ? wearHrData2.getHrValue() : null;
            }
        }
        double d3 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (hr == null || hr.intValue() <= 0) {
            d = 0.0d;
        } else {
            LoginUserData loginUserData = Global.userData;
            double dDoubleValue = (loginUserData == null || (weight = loginUserData.getWeight()) == null || (doubleOrNull = StringsKt.toDoubleOrNull(weight)) == null) ? 60.0d : doubleOrNull.doubleValue();
            double d4 = Double.parseDouble(Global.INSTANCE.calculateAge());
            int i = WhenMappings.$EnumSwitchMapping$3[Global.INSTANCE.getSex().ordinal()];
            if (i == 1) {
                dIntValue = ((hr.intValue() * 0.6309d) - 55.0969d) + (dDoubleValue * 0.1988d);
                d2 = 0.2017d;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                dIntValue = ((hr.intValue() * 0.4472d) - 20.4022d) - (dDoubleValue * 0.1263d);
                d2 = 0.074d;
            }
            d = ((dIntValue + (d4 * d2)) / 4.184d) * 60 * 2.777777777777778E-4d;
        }
        if (d >= AudioStats.AUDIO_AMPLITUDE_NONE) {
            d3 = d;
        }
        this.totalCalories += d3;
        YogaWorkoutData yogaWorkoutData = new YogaWorkoutData(this.currentVideoMaxTime, this.durationVideoTime - this.currentVideoTime, null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
        setTvDisplay1Title(VideoModeViewModelKt.formattedTime(this.currentVideoMaxTime));
        setTvDisplay2Title(String.valueOf((int) this.totalCalories));
        if (hr == null || (string = hr.toString()) == null) {
            string = SdkConstants.RES_QUALIFIER_SEP;
        }
        setTvDisplay3Title(string);
        yogaWorkoutData.setClassId(this.classId);
        VideoDetailData videoDetailData = getVideoDetailData();
        yogaWorkoutData.setClassName(videoDetailData != null ? videoDetailData.getClass_name() : null);
        VideoDetailData videoDetailData2 = getVideoDetailData();
        if (videoDetailData2 != null && (classType = videoDetailData2.getClassType()) != null) {
            rawValue = classType.getRawValue();
        }
        yogaWorkoutData.setClassType(rawValue);
        yogaWorkoutData.setHeartRate(hr);
        yogaWorkoutData.setCaloriesOfSec(Double.valueOf(d3));
        yogaWorkoutData.setTotalCalories(Double.valueOf(this.totalCalories));
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneOffset.UTC);
        Intrinsics.checkNotNullExpressionValue(zonedDateTimeNow, "now(...)");
        yogaWorkoutData.setUtcDateTime(zonedDateTimeNow);
        synchronized (this) {
            getYogaWorkoutDataList().add(yogaWorkoutData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c A[Catch: Exception -> 0x0066, TryCatch #2 {Exception -> 0x0066, blocks: (B:18:0x0044, B:91:0x0188, B:26:0x0062, B:35:0x007a, B:37:0x0084, B:39:0x008a, B:41:0x0090, B:43:0x009c, B:45:0x00a2, B:47:0x00a5, B:49:0x00b5, B:51:0x00b8, B:52:0x00bd, B:54:0x00d6, B:56:0x00de, B:57:0x00e4, B:59:0x00ea, B:62:0x00f7, B:64:0x00fd, B:67:0x0104, B:70:0x010b, B:73:0x0113, B:75:0x011b, B:77:0x0123, B:79:0x0129, B:81:0x012f, B:83:0x0163, B:85:0x016b, B:92:0x01a0, B:94:0x01a3), top: B:108:0x0029, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a3 A[Catch: Exception -> 0x0066, TRY_LEAVE, TryCatch #2 {Exception -> 0x0066, blocks: (B:18:0x0044, B:91:0x0188, B:26:0x0062, B:35:0x007a, B:37:0x0084, B:39:0x008a, B:41:0x0090, B:43:0x009c, B:45:0x00a2, B:47:0x00a5, B:49:0x00b5, B:51:0x00b8, B:52:0x00bd, B:54:0x00d6, B:56:0x00de, B:57:0x00e4, B:59:0x00ea, B:62:0x00f7, B:64:0x00fd, B:67:0x0104, B:70:0x010b, B:73:0x0113, B:75:0x011b, B:77:0x0123, B:79:0x0129, B:81:0x012f, B:83:0x0163, B:85:0x016b, B:92:0x01a0, B:94:0x01a3), top: B:108:0x0029, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiGetClassVideo(kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.apiGetClassVideo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiPostCompletedClassEvent(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.C09001
            if (r0 == 0) goto L14
            r0 = r7
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$apiPostCompletedClassEvent$1 r0 = (com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.C09001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$apiPostCompletedClassEvent$1 r0 = new com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$apiPostCompletedClassEvent$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L2a
            goto L52
        L2a:
            r7 = move-exception
            goto L5e
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            com.soletreadmills.sole_v2._data.classes.CompletedClassEventRequest$RequestBodyData r7 = new com.soletreadmills.sole_v2._data.classes.CompletedClassEventRequest$RequestBodyData     // Catch: java.lang.Exception -> L6c
            int r2 = r6.currentVideoMaxTime     // Catch: java.lang.Exception -> L6c
            int r4 = r6.durationVideoTime     // Catch: java.lang.Exception -> L6c
            int r5 = r6.currentVideoTime     // Catch: java.lang.Exception -> L6c
            r7.<init>(r2, r4, r5)     // Catch: java.lang.Exception -> L6c
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2a
            r2 = r6
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r2 = (com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel) r2     // Catch: java.lang.Throwable -> L2a
            java.lang.String r2 = r6.classId     // Catch: java.lang.Throwable -> L2a
            r0.label = r3     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r7 = com.soletreadmills.sole_v2._network.JwtDyacoApiKt.callPostCompletedClassEvent(r2, r7, r0)     // Catch: java.lang.Throwable -> L2a
            if (r7 != r1) goto L52
            return r1
        L52:
            retrofit2.Response r7 = (retrofit2.Response) r7     // Catch: java.lang.Throwable -> L2a
            r7.isSuccessful()     // Catch: java.lang.Throwable -> L2a
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r7 = kotlin.Result.m9087constructorimpl(r7)     // Catch: java.lang.Throwable -> L2a
            goto L68
        L5e:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Exception -> L6c
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)     // Catch: java.lang.Exception -> L6c
            java.lang.Object r7 = kotlin.Result.m9087constructorimpl(r7)     // Catch: java.lang.Exception -> L6c
        L68:
            kotlin.Result.m9090exceptionOrNullimpl(r7)     // Catch: java.lang.Exception -> L6c
            goto L70
        L6c:
            r7 = move-exception
            r7.printStackTrace()
        L70:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.apiPostCompletedClassEvent(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        stopTimer();
    }

    public static /* synthetic */ void uploadWorkoutData$default(VideoModeViewModel videoModeViewModel, List list, boolean z, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        videoModeViewModel.uploadWorkoutData(list, z, num);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01a7  */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.time.ZonedDateTime] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void uploadWorkoutData(final java.util.List<com.digifly.ble.data.YogaWorkoutData> r52, final boolean r53, final java.lang.Integer r54) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.uploadWorkoutData(java.util.List, boolean, java.lang.Integer):void");
    }

    /* compiled from: VideoModeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$saveFailedWorkoutData$1", f = "VideoModeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$saveFailedWorkoutData$1, reason: invalid class name and case insensitive filesystem */
    static final class C09021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SummaryTempDataDatabase $summaryTempDataDatabase;
        final /* synthetic */ List<YogaWorkoutData> $yogaWorkoutDataList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09021(List<YogaWorkoutData> list, SummaryTempDataDatabase summaryTempDataDatabase, Continuation<? super C09021> continuation) {
            super(2, continuation);
            this.$yogaWorkoutDataList = list;
            this.$summaryTempDataDatabase = summaryTempDataDatabase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09021(this.$yogaWorkoutDataList, this.$summaryTempDataDatabase, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String json;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String name = YogaWorkoutData.class.getName();
            if (this.$yogaWorkoutDataList.isEmpty()) {
                json = null;
            } else {
                try {
                    json = new Gson().toJson(new YogaWorkoutListData(this.$yogaWorkoutDataList));
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                }
            }
            String str = json;
            if (str != null && str.length() != 0) {
                Intrinsics.checkNotNull(name);
                if (name.length() > 0) {
                    try {
                        this.$summaryTempDataDatabase.summaryTempDataDao().insert(new SummaryTempDataEntity(json, name));
                    } catch (Exception e2) {
                        Timber.INSTANCE.e(e2);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveFailedWorkoutData(List<YogaWorkoutData> yogaWorkoutDataList, boolean isFromSqlite, Integer entityId, SummaryTempDataDatabase summaryTempDataDatabase) {
        if (isFromSqlite || entityId != null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C09021(yogaWorkoutDataList, summaryTempDataDatabase, null), 2, null);
    }
}
