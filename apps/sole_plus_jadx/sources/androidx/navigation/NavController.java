package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavControllerImpl;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: NavController.android.kt */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u009f\u00012\u00020\u0001:\u0006\u009d\u0001\u009e\u0001\u009f\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u00102\u001a\u000603R\u00020\u00002\u000e\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020605H\u0000¢\u0006\u0002\b7J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010=\u001a\u00020\u0019H\u0017J\u001a\u0010=\u001a\u00020\u00192\b\b\u0001\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0019H\u0017J\"\u0010=\u001a\u00020\u00192\b\b\u0001\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u0019H\u0017J\"\u0010=\u001a\u00020\u00192\u0006\u0010B\u001a\u00020C2\u0006\u0010@\u001a\u00020\u00192\b\b\u0002\u0010A\u001a\u00020\u0019H\u0007J'\u0010=\u001a\u00020\u0019\"\n\b\u0000\u0010D\u0018\u0001*\u00020\u00012\u0006\u0010@\u001a\u00020\u00192\b\b\u0002\u0010A\u001a\u00020\u0019H\u0087\bJ2\u0010=\u001a\u00020\u0019\"\b\b\u0000\u0010D*\u00020\u00012\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HD0E2\u0006\u0010@\u001a\u00020\u00192\b\b\u0002\u0010A\u001a\u00020\u0019H\u0007J1\u0010=\u001a\u00020\u0019\"\b\b\u0000\u0010D*\u00020\u00012\u0006\u0010B\u001a\u0002HD2\u0006\u0010@\u001a\u00020\u00192\b\b\u0002\u0010A\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010FJ$\u0010G\u001a\u00020\u00192\b\b\u0001\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00192\b\b\u0002\u0010A\u001a\u00020\u0019H\u0003J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010B\u001a\u00020CH\u0007J\u0012\u0010H\u001a\u00020\u00192\b\b\u0001\u0010>\u001a\u00020?H\u0007J\u0015\u0010H\u001a\u00020\u0019\"\n\b\u0000\u0010D\u0018\u0001*\u00020\u0001H\u0087\bJ \u0010H\u001a\u00020\u0019\"\b\b\u0000\u0010D*\u00020\u00012\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HD0EH\u0007J\u001f\u0010H\u001a\u00020\u0019\"\b\b\u0000\u0010D*\u00020\u00012\u0006\u0010B\u001a\u0002HDH\u0007¢\u0006\u0002\u0010IJ\b\u0010J\u001a\u00020\u0019H\u0017J\b\u0010K\u001a\u00020\u0019H\u0002J\b\u0010L\u001a\u00020\u0019H\u0002J\u0012\u0010\u0016\u001a\u0002092\b\b\u0001\u0010U\u001a\u00020?H\u0017J\"\u0010\u0016\u001a\u0002092\b\b\u0001\u0010U\u001a\u00020?2\u000e\u0010V\u001a\n\u0018\u00010Wj\u0004\u0018\u0001`XH\u0017J \u0010\u0016\u001a\u0002092\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010V\u001a\n\u0018\u00010Wj\u0004\u0018\u0001`XH\u0017J\r\u0010Y\u001a\u00020\u0019H\u0000¢\u0006\u0002\bZJ\u0012\u0010[\u001a\u00020\u00192\b\u0010\\\u001a\u0004\u0018\u00010]H\u0017J\u0010\u0010[\u001a\u00020\u00192\u0006\u0010^\u001a\u00020_H\u0007J3\u0010[\u001a\u00020\u00192\u0006\u0010`\u001a\u00020a2\u0014\u0010b\u001a\u0010\u0012\f\u0012\n\u0018\u00010Wj\u0004\u0018\u0001`X0c2\u0006\u0010d\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010eJ\u0012\u0010f\u001a\u0004\u0018\u00010C2\u0006\u0010`\u001a\u00020aH\u0002J \u0010j\u001a\u0004\u0018\u0001062\b\b\u0001\u0010>\u001a\u00020?2\n\b\u0002\u0010k\u001a\u0004\u0018\u000106H\u0007J,\u0010l\u001a\u0004\u0018\u000106*\u0002062\b\b\u0001\u0010>\u001a\u00020?2\u0006\u0010m\u001a\u00020\u00192\n\b\u0002\u0010k\u001a\u0004\u0018\u000106H\u0007J\u0012\u0010j\u001a\u0004\u0018\u0001062\u0006\u0010B\u001a\u00020CH\u0007J\u0012\u0010n\u001a\u0002092\b\b\u0001\u0010o\u001a\u00020?H\u0017J\"\u0010n\u001a\u0002092\b\b\u0001\u0010o\u001a\u00020?2\u000e\u0010b\u001a\n\u0018\u00010Wj\u0004\u0018\u0001`XH\u0017J,\u0010n\u001a\u0002092\b\b\u0001\u0010o\u001a\u00020?2\u000e\u0010b\u001a\n\u0018\u00010Wj\u0004\u0018\u0001`X2\b\u0010p\u001a\u0004\u0018\u00010qH\u0017J6\u0010n\u001a\u0002092\b\b\u0001\u0010o\u001a\u00020?2\u000e\u0010b\u001a\n\u0018\u00010Wj\u0004\u0018\u0001`X2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0017J\u0010\u0010n\u001a\u0002092\u0006\u0010`\u001a\u00020tH\u0017J\u001a\u0010n\u001a\u0002092\u0006\u0010`\u001a\u00020t2\b\u0010p\u001a\u0004\u0018\u00010qH\u0017J$\u0010n\u001a\u0002092\u0006\u0010`\u001a\u00020t2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0017J\u0010\u0010n\u001a\u0002092\u0006\u0010^\u001a\u00020_H\u0017J\u001a\u0010n\u001a\u0002092\u0006\u0010^\u001a\u00020_2\b\u0010p\u001a\u0004\u0018\u00010qH\u0017J$\u0010n\u001a\u0002092\u0006\u0010^\u001a\u00020_2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0017J!\u0010u\u001a\u0002092\u0006\u0010^\u001a\u00020_2\n\u0010b\u001a\u00060Wj\u0002`XH\u0000¢\u0006\u0002\bvJ4\u0010n\u001a\u0002092\u0006\u0010w\u001a\u0002062\u000e\u0010b\u001a\n\u0018\u00010Wj\u0004\u0018\u0001`X2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0003J\u0010\u0010n\u001a\u0002092\u0006\u0010x\u001a\u00020yH\u0017J\u001a\u0010n\u001a\u0002092\u0006\u0010x\u001a\u00020y2\b\u0010p\u001a\u0004\u0018\u00010qH\u0017J\u0018\u0010n\u001a\u0002092\u0006\u0010x\u001a\u00020y2\u0006\u0010r\u001a\u00020sH\u0017J)\u0010n\u001a\u0002092\u0006\u0010B\u001a\u00020C2\u0017\u0010z\u001a\u0013\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u0002090{¢\u0006\u0002\b}H\u0007J(\u0010n\u001a\u0002092\u0006\u0010B\u001a\u00020C2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010q2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010sH\u0007J8\u0010n\u001a\u000209\"\b\b\u0000\u0010D*\u00020\u00012\u0006\u0010B\u001a\u0002HD2\u0017\u0010z\u001a\u0013\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u0002090{¢\u0006\u0002\b}H\u0007¢\u0006\u0002\u0010~J7\u0010n\u001a\u000209\"\b\b\u0000\u0010D*\u00020\u00012\u0006\u0010B\u001a\u0002HD2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010q2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010sH\u0007¢\u0006\u0002\u0010\u007fJ\n\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0016J\u0010\u0010A\u001a\n\u0018\u00010Wj\u0004\u0018\u0001`XH\u0017J\u001a\u0010\u0082\u0001\u001a\u0002092\u000f\u0010\u0083\u0001\u001a\n\u0018\u00010Wj\u0004\u0018\u0001`XH\u0017J\u0013\u0010\u0084\u0001\u001a\u0002092\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0017J\u0012\u0010\u0087\u0001\u001a\u0002092\u0007\u0010\u0088\u0001\u001a\u00020'H\u0017J\u0012\u0010\u0089\u0001\u001a\u0002092\u0007\u0010\u008a\u0001\u001a\u00020\u0019H\u0017J\t\u0010\u008b\u0001\u001a\u000209H\u0002J\u0013\u0010\u008c\u0001\u001a\u0002092\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0017J\u0015\u0010\u008f\u0001\u001a\u00030\u0090\u00012\t\b\u0001\u0010\u0091\u0001\u001a\u00020?H\u0016J\u0013\u0010\u0092\u0001\u001a\u00020!2\b\b\u0001\u0010>\u001a\u00020?H\u0016J\u000f\u0010\u0092\u0001\u001a\u00020!2\u0006\u0010B\u001a\u00020CJ\u0016\u0010\u0092\u0001\u001a\u00020!\"\n\b\u0000\u0010D\u0018\u0001*\u00020\u0001H\u0086\bJ\u001f\u0010\u0092\u0001\u001a\u00020!\"\b\b\u0000\u0010D*\u00020\u00012\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HD0EJ\u001f\u0010\u0092\u0001\u001a\u00020!\"\b\b\u0000\u0010D*\u00020\u00012\u0006\u0010B\u001a\u0002HD¢\u0006\u0003\u0010\u0093\u0001R\u0013\u0010\u0002\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f8G¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f8F¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,8V@WX\u0096\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u0010M\u001a\u00020?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001b\u0010P\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bQ\u0010RR\u0016\u0010g\u001a\u0004\u0018\u0001068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0019\u0010\u0094\u0001\u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001b\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020!0\u0098\u00018F¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009b\u0001\u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u0096\u0001¨\u0006 \u0001"}, d2 = {"Landroidx/navigation/NavController;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", SdkConstants.CONSTRUCTOR_NAME, "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "impl", "Landroidx/navigation/internal/NavControllerImpl;", "navContext", "Landroidx/navigation/internal/NavContext;", "getNavContext$navigation_runtime_release", "()Landroidx/navigation/internal/NavContext;", "activity", "Landroid/app/Activity;", "inflater", "Landroidx/navigation/NavInflater;", SdkConstants.ATTR_GRAPH, "Landroidx/navigation/NavGraph;", "getGraph", "()Landroidx/navigation/NavGraph;", "setGraph", "(Landroidx/navigation/NavGraph;)V", "deepLinkHandled", "", "getDeepLinkHandled$navigation_runtime_release", "()Z", "setDeepLinkHandled$navigation_runtime_release", "(Z)V", "currentBackStack", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/navigation/NavBackStackEntry;", "getCurrentBackStack", "()Lkotlinx/coroutines/flow/StateFlow;", "visibleEntries", "getVisibleEntries", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "enableOnBackPressedCallback", "value", "Landroidx/navigation/NavigatorProvider;", "navigatorProvider", "getNavigatorProvider", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "createNavControllerNavigatorState", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigator", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "createNavControllerNavigatorState$navigation_runtime_release", "addOnDestinationChangedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/navigation/NavController$OnDestinationChangedListener;", "removeOnDestinationChangedListener", "popBackStack", "destinationId", "", "inclusive", "saveState", "route", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "(Ljava/lang/Object;ZZ)Z", "popBackStackInternal", "clearBackStack", "(Ljava/lang/Object;)Z", "navigateUp", "tryRelaunchUpToExplicitStack", "tryRelaunchUpToGeneratedStack", "destinationCountOnBackStack", "getDestinationCountOnBackStack", "()I", "navInflater", "getNavInflater", "()Landroidx/navigation/NavInflater;", "navInflater$delegate", "Lkotlin/Lazy;", "graphResId", "startDestinationArgs", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "checkDeepLinkHandled", "checkDeepLinkHandled$navigation_runtime_release", "handleDeepLink", "intent", "Landroid/content/Intent;", "request", "Landroidx/navigation/NavDeepLinkRequest;", "deepLink", "", "args", "", "newTask", "([I[Landroid/os/Bundle;Z)Z", "findInvalidDestinationDisplayNameInDeepLink", "currentDestination", "getCurrentDestination", "()Landroidx/navigation/NavDestination;", "findDestination", "matchingDest", "findDestinationComprehensive", "searchChildren", "navigate", "resId", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "Landroid/net/Uri;", "writeIntent", "writeIntent$navigation_runtime_release", "node", "directions", "Landroidx/navigation/NavDirections;", "builder", "Lkotlin/Function1;", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "createDeepLink", "Landroidx/navigation/NavDeepLinkBuilder;", "restoreState", "navState", "setLifecycleOwner", "owner", "Landroidx/lifecycle/LifecycleOwner;", "setOnBackPressedDispatcher", "dispatcher", "enableOnBackPressed", "enabled", "updateOnBackPressedCallbackEnabled", "setViewModelStore", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "navGraphId", "getBackStackEntry", "(Ljava/lang/Object;)Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntry", "getCurrentBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/Flow;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/Flow;", "previousBackStackEntry", "getPreviousBackStackEntry", "OnDestinationChangedListener", "NavControllerNavigatorState", "Companion", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class NavController {
    public static final String KEY_DEEP_LINK_ARGS = "android-support-nav:controller:deepLinkArgs";
    public static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    public static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    public static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private Activity activity;
    private final Context context;
    private boolean deepLinkHandled;
    private boolean enableOnBackPressedCallback;
    private final NavControllerImpl impl;
    private NavInflater inflater;
    private final NavContext navContext;

    /* renamed from: navInflater$delegate, reason: from kotlin metadata */
    private final Lazy navInflater;
    private final OnBackPressedCallback onBackPressedCallback;
    private OnBackPressedDispatcher onBackPressedDispatcher;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean deepLinkSaveState = true;

    /* compiled from: NavController.android.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments);
    }

    @JvmStatic
    public static final void enableDeepLinkSaveState(boolean z) {
        INSTANCE.enableDeepLinkSaveState(z);
    }

    public final <T> void navigate(T route) {
        Intrinsics.checkNotNullParameter(route, "route");
        navigate$default(this, route, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    public final <T> void navigate(T route, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(route, "route");
        navigate$default(this, route, navOptions, (Navigator.Extras) null, 4, (Object) null);
    }

    public final void navigate(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        navigate$default(this, route, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    public final void navigate(String route, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(route, "route");
        navigate$default(this, route, navOptions, (Navigator.Extras) null, 4, (Object) null);
    }

    public final <T> boolean popBackStack(T route, boolean z) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStack$default(this, (Object) route, z, false, 4, (Object) null);
    }

    public final boolean popBackStack(String route, boolean z) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStack$default(this, route, z, false, 4, (Object) null);
    }

    public final <T> boolean popBackStack(KClass<T> route, boolean z) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStack$default(this, (KClass) route, z, false, 4, (Object) null);
    }

    public NavController(Context context) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.impl = new NavControllerImpl(this, new Function0() { // from class: androidx.navigation.NavController$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavController.impl$lambda$0(this.f$0);
            }
        });
        this.navContext = new NavContext(context);
        Iterator it = SequencesKt.generateSequence(context, (Function1<? super Context, ? extends Context>) new Function1() { // from class: androidx.navigation.NavController$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavController.activity$lambda$1((Context) obj);
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Context) next) instanceof Activity) {
                    break;
                }
            }
        }
        this.activity = (Activity) next;
        this.onBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.navigation.NavController$onBackPressedCallback$1
            {
                super(false);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                this.this$0.popBackStack();
            }
        };
        this.enableOnBackPressedCallback = true;
        this.impl.get_navigatorProvider$navigation_runtime_release().addNavigator(new NavGraphNavigator(this.impl.get_navigatorProvider$navigation_runtime_release()));
        this.impl.get_navigatorProvider$navigation_runtime_release().addNavigator(new ActivityNavigator(this.context));
        this.navInflater = LazyKt.lazy(new Function0() { // from class: androidx.navigation.NavController$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavController.navInflater_delegate$lambda$10(this.f$0);
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit impl$lambda$0(NavController navController) {
        navController.updateOnBackPressedCallbackEnabled();
        return Unit.INSTANCE;
    }

    /* renamed from: getNavContext$navigation_runtime_release, reason: from getter */
    public final NavContext getNavContext() {
        return this.navContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context activity$lambda$1(Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof ContextWrapper) {
            return ((ContextWrapper) it).getBaseContext();
        }
        return null;
    }

    public NavGraph getGraph() {
        return this.impl.getGraph$navigation_runtime_release();
    }

    public void setGraph(NavGraph graph) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        this.impl.setGraph$navigation_runtime_release(graph);
    }

    /* renamed from: getDeepLinkHandled$navigation_runtime_release, reason: from getter */
    public final boolean getDeepLinkHandled() {
        return this.deepLinkHandled;
    }

    public final void setDeepLinkHandled$navigation_runtime_release(boolean z) {
        this.deepLinkHandled = z;
    }

    public final StateFlow<List<NavBackStackEntry>> getCurrentBackStack() {
        return this.impl.getCurrentBackStack$navigation_runtime_release();
    }

    public final StateFlow<List<NavBackStackEntry>> getVisibleEntries() {
        return this.impl.getVisibleEntries$navigation_runtime_release();
    }

    public NavigatorProvider getNavigatorProvider() {
        return this.impl.get_navigatorProvider();
    }

    public void setNavigatorProvider(NavigatorProvider value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.impl.setNavigatorProvider$navigation_runtime_release(value);
    }

    /* compiled from: NavController.android.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0090\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\fH\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "navigator", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "getNavigator", "()Landroidx/navigation/Navigator;", "push", "", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;", "addInternal", "createBackStackEntry", "destination", "arguments", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "pop", "popUpTo", "saveState", "", "popWithTransition", "markTransitionComplete", "entry", "prepareForTransition", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public class NavControllerNavigatorState extends NavigatorState {
        private final Navigator<? extends NavDestination> navigator;
        final /* synthetic */ NavController this$0;

        public NavControllerNavigatorState(NavController navController, Navigator<? extends NavDestination> navigator) {
            Intrinsics.checkNotNullParameter(navigator, "navigator");
            this.this$0 = navController;
            this.navigator = navigator;
        }

        public final Navigator<? extends NavDestination> getNavigator() {
            return this.navigator;
        }

        @Override // androidx.navigation.NavigatorState
        public void push(NavBackStackEntry backStackEntry) {
            Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
            this.this$0.impl.push$navigation_runtime_release(this, backStackEntry);
        }

        public final void addInternal(NavBackStackEntry backStackEntry) {
            Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
            super.push(backStackEntry);
        }

        @Override // androidx.navigation.NavigatorState
        public NavBackStackEntry createBackStackEntry(NavDestination destination, Bundle arguments) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            return this.this$0.impl.createBackStackEntry$navigation_runtime_release(destination, arguments);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pop$lambda$0(NavControllerNavigatorState navControllerNavigatorState, NavBackStackEntry navBackStackEntry, boolean z) {
            super.pop(navBackStackEntry, z);
            return Unit.INSTANCE;
        }

        @Override // androidx.navigation.NavigatorState
        public void pop(final NavBackStackEntry popUpTo, final boolean saveState) {
            Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
            this.this$0.impl.pop$navigation_runtime_release(this, popUpTo, saveState, new Function0() { // from class: androidx.navigation.NavController$NavControllerNavigatorState$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NavController.NavControllerNavigatorState.pop$lambda$0(this.f$0, popUpTo, saveState);
                }
            });
        }

        @Override // androidx.navigation.NavigatorState
        public void popWithTransition(NavBackStackEntry popUpTo, boolean saveState) {
            Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
            super.popWithTransition(popUpTo, saveState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit markTransitionComplete$lambda$1(NavControllerNavigatorState navControllerNavigatorState, NavBackStackEntry navBackStackEntry) {
            super.markTransitionComplete(navBackStackEntry);
            return Unit.INSTANCE;
        }

        @Override // androidx.navigation.NavigatorState
        public void markTransitionComplete(final NavBackStackEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.this$0.impl.markTransitionComplete$navigation_runtime_release(this, entry, new Function0() { // from class: androidx.navigation.NavController$NavControllerNavigatorState$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NavController.NavControllerNavigatorState.markTransitionComplete$lambda$1(this.f$0, entry);
                }
            });
        }

        @Override // androidx.navigation.NavigatorState
        public void prepareForTransition(NavBackStackEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            super.prepareForTransition(entry);
            this.this$0.impl.prepareForTransition$navigation_runtime_release(entry);
        }
    }

    public final NavControllerNavigatorState createNavControllerNavigatorState$navigation_runtime_release(Navigator<? extends NavDestination> navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        return new NavControllerNavigatorState(this, navigator);
    }

    public void addOnDestinationChangedListener(OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.impl.addOnDestinationChangedListener$navigation_runtime_release(listener);
    }

    public void removeOnDestinationChangedListener(OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.impl.removeOnDestinationChangedListener$navigation_runtime_release(listener);
    }

    public boolean popBackStack() {
        return this.impl.popBackStack$navigation_runtime_release();
    }

    public boolean popBackStack(int destinationId, boolean inclusive) {
        return this.impl.popBackStack$navigation_runtime_release(destinationId, inclusive);
    }

    public boolean popBackStack(int destinationId, boolean inclusive, boolean saveState) {
        return this.impl.popBackStack$navigation_runtime_release(destinationId, inclusive, saveState);
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, String str, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return navController.popBackStack(str, z, z2);
    }

    public final boolean popBackStack(String route, boolean inclusive, boolean saveState) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.popBackStack$navigation_runtime_release(route, inclusive, saveState);
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return navController.popBackStack(Reflection.getOrCreateKotlinClass(Object.class), z, z2);
    }

    public final /* synthetic */ <T> boolean popBackStack(boolean inclusive, boolean saveState) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return popBackStack((KClass) Reflection.getOrCreateKotlinClass(Object.class), inclusive, saveState);
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, KClass kClass, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return navController.popBackStack(kClass, z, z2);
    }

    public final <T> boolean popBackStack(KClass<T> route, boolean inclusive, boolean saveState) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.popBackStack$navigation_runtime_release((KClass) route, inclusive, saveState);
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, Object obj, boolean z, boolean z2, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return navController.popBackStack((NavController) obj, z, z2);
    }

    public final <T> boolean popBackStack(T route, boolean inclusive, boolean saveState) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.popBackStack$navigation_runtime_release((NavControllerImpl) route, inclusive, saveState);
    }

    static /* synthetic */ boolean popBackStackInternal$default(NavController navController, int i, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return navController.popBackStackInternal(i, z, z2);
    }

    private final boolean popBackStackInternal(int destinationId, boolean inclusive, boolean saveState) {
        return this.impl.popBackStackInternal$navigation_runtime_release(destinationId, inclusive, saveState);
    }

    public final boolean clearBackStack(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.clearBackStack$navigation_runtime_release(route);
    }

    public final boolean clearBackStack(int destinationId) {
        return this.impl.clearBackStack$navigation_runtime_release(destinationId);
    }

    public final /* synthetic */ <T> boolean clearBackStack() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return clearBackStack((KClass) Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> boolean clearBackStack(KClass<T> route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.clearBackStack$navigation_runtime_release((KClass) route);
    }

    public final <T> boolean clearBackStack(T route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.clearBackStack$navigation_runtime_release((NavControllerImpl) route);
    }

    public boolean navigateUp() {
        Intent intent;
        if (getDestinationCountOnBackStack() == 1) {
            Activity activity = this.activity;
            Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
            if ((extras != null ? extras.getIntArray(KEY_DEEP_LINK_IDS) : null) != null) {
                return tryRelaunchUpToExplicitStack();
            }
            return tryRelaunchUpToGeneratedStack();
        }
        return popBackStack();
    }

    private final boolean tryRelaunchUpToExplicitStack() {
        Pair[] pairArr;
        int i = 0;
        if (!this.deepLinkHandled) {
            return false;
        }
        Activity activity = this.activity;
        Intrinsics.checkNotNull(activity);
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        int[] intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
        Intrinsics.checkNotNull(intArray);
        List<Integer> mutableList = ArraysKt.toMutableList(intArray);
        ArrayList parcelableArrayList = extras.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
        if (mutableList.size() < 2) {
            return false;
        }
        int iIntValue = ((Number) CollectionsKt.removeLast(mutableList)).intValue();
        if (parcelableArrayList != null) {
        }
        NavDestination navDestinationFindDestinationComprehensive$default = findDestinationComprehensive$default(this, getGraph(), iIntValue, false, null, 4, null);
        if (navDestinationFindDestinationComprehensive$default instanceof NavGraph) {
            iIntValue = NavGraph.INSTANCE.findStartDestination((NavGraph) navDestinationFindDestinationComprehensive$default).getId();
        }
        NavDestination currentDestination = getCurrentDestination();
        if (currentDestination == null || iIntValue != currentDestination.getId()) {
            return false;
        }
        NavDeepLinkBuilder navDeepLinkBuilderCreateDeepLink = createDeepLink();
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Bundle bundleM7892constructorimpl = SavedStateWriter.m7892constructorimpl(bundleBundleOf);
        Intrinsics.checkNotNull(intent);
        SavedStateWriter.m7916putParcelableimpl(bundleM7892constructorimpl, KEY_DEEP_LINK_INTENT, intent);
        Bundle bundle = extras.getBundle(KEY_DEEP_LINK_EXTRAS);
        if (bundle != null) {
            SavedStateWriter.m7896putAllimpl(bundleM7892constructorimpl, bundle);
        }
        navDeepLinkBuilderCreateDeepLink.setArguments(bundleBundleOf);
        for (Object obj : mutableList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            navDeepLinkBuilderCreateDeepLink.addDestination(((Number) obj).intValue(), parcelableArrayList != null ? (Bundle) parcelableArrayList.get(i) : null);
            i = i2;
        }
        navDeepLinkBuilderCreateDeepLink.createTaskStackBuilder().startActivities();
        Activity activity2 = this.activity;
        if (activity2 == null) {
            return true;
        }
        activity2.finish();
        return true;
    }

    private final boolean tryRelaunchUpToGeneratedStack() {
        Pair[] pairArr;
        Bundle bundleAddInDefaultArgs;
        NavDestination currentDestination = getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        int id2 = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestinationId() == id2) {
                id2 = parent.getId();
            } else {
                Map mapEmptyMap = MapsKt.emptyMap();
                if (mapEmptyMap.isEmpty()) {
                    pairArr = new Pair[0];
                } else {
                    ArrayList arrayList = new ArrayList(mapEmptyMap.size());
                    for (Map.Entry entry : mapEmptyMap.entrySet()) {
                        arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
                    }
                    pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
                }
                Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                Bundle bundleM7892constructorimpl = SavedStateWriter.m7892constructorimpl(bundleBundleOf);
                Activity activity = this.activity;
                if (activity != null) {
                    Intrinsics.checkNotNull(activity);
                    if (activity.getIntent() != null) {
                        Activity activity2 = this.activity;
                        Intrinsics.checkNotNull(activity2);
                        if (activity2.getIntent().getData() != null) {
                            Activity activity3 = this.activity;
                            Intrinsics.checkNotNull(activity3);
                            Intent intent = activity3.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                            SavedStateWriter.m7916putParcelableimpl(bundleM7892constructorimpl, KEY_DEEP_LINK_INTENT, intent);
                            NavGraph topGraph$navigation_runtime_release = this.impl.getTopGraph$navigation_runtime_release();
                            Activity activity4 = this.activity;
                            Intrinsics.checkNotNull(activity4);
                            Intent intent2 = activity4.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
                            NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive = topGraph$navigation_runtime_release.matchDeepLinkComprehensive(NavControllerKt.NavDeepLinkRequest(intent2), true, true, topGraph$navigation_runtime_release);
                            if ((deepLinkMatchMatchDeepLinkComprehensive != null ? deepLinkMatchMatchDeepLinkComprehensive.getMatchingArgs() : null) != null && (bundleAddInDefaultArgs = deepLinkMatchMatchDeepLinkComprehensive.getDestination().addInDefaultArgs(deepLinkMatchMatchDeepLinkComprehensive.getMatchingArgs())) != null) {
                                SavedStateWriter.m7896putAllimpl(bundleM7892constructorimpl, bundleAddInDefaultArgs);
                            }
                        }
                    }
                }
                NavDeepLinkBuilder.setDestination$default(new NavDeepLinkBuilder(this), parent.getId(), (Bundle) null, 2, (Object) null).setArguments(bundleBundleOf).createTaskStackBuilder().startActivities();
                Activity activity5 = this.activity;
                if (activity5 != null) {
                    activity5.finish();
                }
                return true;
            }
        }
        return false;
    }

    private final int getDestinationCountOnBackStack() {
        ArrayDeque<NavBackStackEntry> backQueue$navigation_runtime_release = this.impl.getBackQueue$navigation_runtime_release();
        int i = 0;
        if (!(backQueue$navigation_runtime_release instanceof Collection) || !backQueue$navigation_runtime_release.isEmpty()) {
            Iterator<NavBackStackEntry> it = backQueue$navigation_runtime_release.iterator();
            while (it.hasNext()) {
                if (!(it.next().getDestination() instanceof NavGraph) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    public NavInflater getNavInflater() {
        return (NavInflater) this.navInflater.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavInflater navInflater_delegate$lambda$10(NavController navController) {
        NavInflater navInflater = navController.inflater;
        return navInflater == null ? new NavInflater(navController.context, navController.impl.get_navigatorProvider$navigation_runtime_release()) : navInflater;
    }

    public void setGraph(int graphResId) {
        this.impl.setGraph$navigation_runtime_release(getNavInflater().inflate(graphResId), null);
    }

    public void setGraph(int graphResId, Bundle startDestinationArgs) {
        this.impl.setGraph$navigation_runtime_release(getNavInflater().inflate(graphResId), startDestinationArgs);
    }

    public void setGraph(NavGraph graph, Bundle startDestinationArgs) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        this.impl.setGraph$navigation_runtime_release(graph, startDestinationArgs);
    }

    public final boolean checkDeepLinkHandled$navigation_runtime_release() {
        Activity activity;
        if (!this.deepLinkHandled && (activity = this.activity) != null) {
            Intrinsics.checkNotNull(activity);
            if (handleDeepLink(activity.getIntent())) {
                return true;
            }
        }
        return false;
    }

    public boolean handleDeepLink(Intent intent) {
        int[] intArray;
        Pair[] pairArr;
        NavGraph topGraph$navigation_runtime_release;
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive;
        Pair[] pairArr2;
        Bundle bundle;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        ArrayList arrayList = null;
        if (extras != null) {
            try {
                intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
            } catch (Exception e) {
                Log.e(NavControllerImpl.TAG, "handleDeepLink() could not extract deepLink from " + intent, e);
            }
        } else {
            intArray = null;
        }
        ArrayList parcelableArrayList = extras != null ? extras.getParcelableArrayList(KEY_DEEP_LINK_ARGS) : null;
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList2 = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList2.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList2.toArray(new Pair[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m7892constructorimpl(bundleBundleOf);
        Bundle bundle2 = extras != null ? extras.getBundle(KEY_DEEP_LINK_EXTRAS) : null;
        if (bundle2 != null) {
            SavedStateWriter.m7896putAllimpl(SavedStateWriter.m7892constructorimpl(bundleBundleOf), bundle2);
        }
        if ((intArray == null || intArray.length == 0) && (deepLinkMatchMatchDeepLinkComprehensive = (topGraph$navigation_runtime_release = this.impl.getTopGraph$navigation_runtime_release()).matchDeepLinkComprehensive(NavControllerKt.NavDeepLinkRequest(intent), true, true, topGraph$navigation_runtime_release)) != null) {
            NavDestination destination = deepLinkMatchMatchDeepLinkComprehensive.getDestination();
            int[] iArrBuildDeepLinkIds$default = NavDestination.buildDeepLinkIds$default(destination, null, 1, null);
            Bundle bundleAddInDefaultArgs = destination.addInDefaultArgs(deepLinkMatchMatchDeepLinkComprehensive.getMatchingArgs());
            if (bundleAddInDefaultArgs != null) {
                SavedStateWriter.m7896putAllimpl(SavedStateWriter.m7892constructorimpl(bundleBundleOf), bundleAddInDefaultArgs);
            }
            intArray = iArrBuildDeepLinkIds$default;
        } else {
            arrayList = parcelableArrayList;
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String strFindInvalidDestinationDisplayNameInDeepLink = findInvalidDestinationDisplayNameInDeepLink(intArray);
        if (strFindInvalidDestinationDisplayNameInDeepLink != null) {
            androidx.navigation.internal.Log.INSTANCE.i(NavControllerImpl.TAG, "Could not find destination " + strFindInvalidDestinationDisplayNameInDeepLink + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        SavedStateWriter.m7916putParcelableimpl(SavedStateWriter.m7892constructorimpl(bundleBundleOf), KEY_DEEP_LINK_INTENT, intent);
        int length = intArray.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i = 0; i < length; i++) {
            Map mapEmptyMap2 = MapsKt.emptyMap();
            if (mapEmptyMap2.isEmpty()) {
                pairArr2 = new Pair[0];
            } else {
                ArrayList arrayList3 = new ArrayList(mapEmptyMap2.size());
                for (Map.Entry entry2 : mapEmptyMap2.entrySet()) {
                    arrayList3.add(TuplesKt.to((String) entry2.getKey(), entry2.getValue()));
                }
                pairArr2 = (Pair[]) arrayList3.toArray(new Pair[0]);
            }
            Bundle bundleBundleOf2 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
            Bundle bundleM7892constructorimpl = SavedStateWriter.m7892constructorimpl(bundleBundleOf2);
            SavedStateWriter.m7896putAllimpl(bundleM7892constructorimpl, bundleBundleOf);
            if (arrayList != null && (bundle = (Bundle) arrayList.get(i)) != null) {
                SavedStateWriter.m7896putAllimpl(bundleM7892constructorimpl, bundle);
            }
            bundleArr[i] = bundleBundleOf2;
        }
        int flags = intent.getFlags();
        int i2 = 268435456 & flags;
        if (i2 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            TaskStackBuilder taskStackBuilderAddNextIntentWithParentStack = TaskStackBuilder.create(this.context).addNextIntentWithParentStack(intent);
            Intrinsics.checkNotNullExpressionValue(taskStackBuilderAddNextIntentWithParentStack, "addNextIntentWithParentStack(...)");
            taskStackBuilderAddNextIntentWithParentStack.startActivities();
            Activity activity = this.activity;
            if (activity != null) {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
            return true;
        }
        return handleDeepLink(intArray, bundleArr, i2 != 0);
    }

    public final boolean handleDeepLink(NavDeepLinkRequest request) {
        Pair[] pairArr;
        Pair[] pairArr2;
        Intrinsics.checkNotNullParameter(request, "request");
        NavGraph topGraph$navigation_runtime_release = this.impl.getTopGraph$navigation_runtime_release();
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive = topGraph$navigation_runtime_release.matchDeepLinkComprehensive(request, true, true, topGraph$navigation_runtime_release);
        if (deepLinkMatchMatchDeepLinkComprehensive == null) {
            return false;
        }
        NavDestination destination = deepLinkMatchMatchDeepLinkComprehensive.getDestination();
        int[] iArrBuildDeepLinkIds$default = NavDestination.buildDeepLinkIds$default(destination, null, 1, null);
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Bundle bundleM7892constructorimpl = SavedStateWriter.m7892constructorimpl(bundleBundleOf);
        Bundle bundleAddInDefaultArgs = destination.addInDefaultArgs(deepLinkMatchMatchDeepLinkComprehensive.getMatchingArgs());
        if (bundleAddInDefaultArgs != null) {
            SavedStateWriter.m7896putAllimpl(bundleM7892constructorimpl, bundleAddInDefaultArgs);
        }
        int length = iArrBuildDeepLinkIds$default.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i = 0; i < length; i++) {
            Map mapEmptyMap2 = MapsKt.emptyMap();
            if (mapEmptyMap2.isEmpty()) {
                pairArr2 = new Pair[0];
            } else {
                ArrayList arrayList2 = new ArrayList(mapEmptyMap2.size());
                for (Map.Entry entry2 : mapEmptyMap2.entrySet()) {
                    arrayList2.add(TuplesKt.to((String) entry2.getKey(), entry2.getValue()));
                }
                pairArr2 = (Pair[]) arrayList2.toArray(new Pair[0]);
            }
            Bundle bundleBundleOf2 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
            SavedStateWriter.m7896putAllimpl(SavedStateWriter.m7892constructorimpl(bundleBundleOf2), bundleBundleOf);
            bundleArr[i] = bundleBundleOf2;
        }
        return handleDeepLink(iArrBuildDeepLinkIds$default, bundleArr, true);
    }

    private final boolean handleDeepLink(int[] deepLink, Bundle[] args, boolean newTask) {
        NavGraph navGraphFindNode;
        NavGraph navGraph;
        int i = 0;
        if (newTask) {
            if (!this.impl.getBackQueue$navigation_runtime_release().isEmpty()) {
                NavGraph navGraph2 = this.impl.get_graph();
                Intrinsics.checkNotNull(navGraph2);
                popBackStackInternal$default(this, navGraph2.getId(), true, false, 4, null);
            }
            while (i < deepLink.length) {
                int i2 = deepLink[i];
                int i3 = i + 1;
                Bundle bundle = args[i];
                final NavDestination navDestinationFindDestination$default = findDestination$default(this, i2, null, 2, null);
                if (navDestinationFindDestination$default == null) {
                    throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.INSTANCE.getDisplayName(this.navContext, i2) + " cannot be found from the current destination " + getCurrentDestination());
                }
                navigate(navDestinationFindDestination$default, bundle, NavOptionsBuilderKt.navOptions(new Function1() { // from class: androidx.navigation.NavController$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavController.handleDeepLink$lambda$21(navDestinationFindDestination$default, this, (NavOptionsBuilder) obj);
                    }
                }), (Navigator.Extras) null);
                i = i3;
            }
            this.deepLinkHandled = true;
            return true;
        }
        NavGraph navGraph3 = this.impl.get_graph();
        int length = deepLink.length;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = deepLink[i4];
            Bundle bundle2 = args[i4];
            if (i4 == 0) {
                navGraphFindNode = this.impl.get_graph();
            } else {
                Intrinsics.checkNotNull(navGraph3);
                navGraphFindNode = navGraph3.findNode(i5);
            }
            if (navGraphFindNode == null) {
                throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.INSTANCE.getDisplayName(this.navContext, i5) + " cannot be found in graph " + navGraph3);
            }
            if (i4 != deepLink.length - 1) {
                if (navGraphFindNode instanceof NavGraph) {
                    while (true) {
                        navGraph = (NavGraph) navGraphFindNode;
                        Intrinsics.checkNotNull(navGraph);
                        if (!(navGraph.findNode(navGraph.getStartDestinationId()) instanceof NavGraph)) {
                            break;
                        }
                        navGraphFindNode = navGraph.findNode(navGraph.getStartDestinationId());
                    }
                    navGraph3 = navGraph;
                }
            } else {
                NavOptions.Builder builder = new NavOptions.Builder();
                NavGraph navGraph4 = this.impl.get_graph();
                Intrinsics.checkNotNull(navGraph4);
                navigate(navGraphFindNode, bundle2, NavOptions.Builder.setPopUpTo$default(builder, navGraph4.getId(), true, false, 4, (Object) null).setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
            }
        }
        this.deepLinkHandled = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeepLink$lambda$21(NavDestination navDestination, NavController navController, NavOptionsBuilder navOptions) {
        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
        navOptions.anim(new Function1() { // from class: androidx.navigation.NavController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavController.handleDeepLink$lambda$21$lambda$18((AnimBuilder) obj);
            }
        });
        if (navDestination instanceof NavGraph) {
            Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(navDestination).iterator();
            while (true) {
                if (it.hasNext()) {
                    NavDestination next = it.next();
                    NavDestination currentDestination = navController.getCurrentDestination();
                    if (Intrinsics.areEqual(next, currentDestination != null ? currentDestination.getParent() : null)) {
                        break;
                    }
                } else if (deepLinkSaveState) {
                    navOptions.popUpTo(NavGraph.INSTANCE.findStartDestination(navController.getGraph()).getId(), new Function1() { // from class: androidx.navigation.NavController$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavController.handleDeepLink$lambda$21$lambda$20((PopUpToBuilder) obj);
                        }
                    });
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeepLink$lambda$21$lambda$18(AnimBuilder anim) {
        Intrinsics.checkNotNullParameter(anim, "$this$anim");
        anim.setEnter(0);
        anim.setExit(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeepLink$lambda$21$lambda$20(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.setSaveState(true);
        return Unit.INSTANCE;
    }

    private final String findInvalidDestinationDisplayNameInDeepLink(int[] deepLink) {
        return this.impl.findInvalidDestinationDisplayNameInDeepLink$navigation_runtime_release(deepLink);
    }

    public NavDestination getCurrentDestination() {
        return this.impl.getCurrentDestination$navigation_runtime_release();
    }

    public static /* synthetic */ NavDestination findDestination$default(NavController navController, int i, NavDestination navDestination, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findDestination");
        }
        if ((i2 & 2) != 0) {
            navDestination = null;
        }
        return navController.findDestination(i, navDestination);
    }

    public final NavDestination findDestination(int destinationId, NavDestination matchingDest) {
        return this.impl.findDestination$navigation_runtime_release(destinationId, matchingDest);
    }

    public static /* synthetic */ NavDestination findDestinationComprehensive$default(NavController navController, NavDestination navDestination, int i, boolean z, NavDestination navDestination2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findDestinationComprehensive");
        }
        if ((i2 & 4) != 0) {
            navDestination2 = null;
        }
        return navController.findDestinationComprehensive(navDestination, i, z, navDestination2);
    }

    public final NavDestination findDestinationComprehensive(NavDestination navDestination, int i, boolean z, NavDestination navDestination2) {
        Intrinsics.checkNotNullParameter(navDestination, "<this>");
        return this.impl.findDestinationComprehensive$navigation_runtime_release(navDestination, i, z, navDestination2);
    }

    public final NavDestination findDestination(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.findDestination$navigation_runtime_release(route);
    }

    public void navigate(int resId) {
        navigate(resId, (Bundle) null);
    }

    public void navigate(int resId, Bundle args) {
        navigate(resId, args, (NavOptions) null);
    }

    public void navigate(int resId, Bundle args, NavOptions navOptions) {
        navigate(resId, args, navOptions, (Navigator.Extras) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void navigate(int r11, android.os.Bundle r12, androidx.navigation.NavOptions r13, androidx.navigation.Navigator.Extras r14) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.navigate(int, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    public void navigate(Uri deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.impl.navigate$navigation_runtime_release(new NavDeepLinkRequest(deepLink, null, null));
    }

    public void navigate(Uri deepLink, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.impl.navigate$navigation_runtime_release(new NavDeepLinkRequest(deepLink, null, null), navOptions);
    }

    public void navigate(Uri deepLink, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.impl.navigate$navigation_runtime_release(new NavDeepLinkRequest(deepLink, null, null), navOptions, navigatorExtras);
    }

    public void navigate(NavDeepLinkRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.impl.navigate$navigation_runtime_release(request);
    }

    public void navigate(NavDeepLinkRequest request, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.impl.navigate$navigation_runtime_release(request, navOptions);
    }

    public void navigate(NavDeepLinkRequest request, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.impl.navigate$navigation_runtime_release(request, navOptions, navigatorExtras);
    }

    public final void writeIntent$navigation_runtime_release(NavDeepLinkRequest request, Bundle args) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(args, "args");
        Intent intent = new Intent();
        intent.setDataAndType(request.getUri(), request.getMimeType());
        intent.setAction(request.getAction());
        SavedStateWriter.m7916putParcelableimpl(SavedStateWriter.m7892constructorimpl(args), KEY_DEEP_LINK_INTENT, intent);
    }

    private final void navigate(NavDestination node, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        this.impl.navigate$navigation_runtime_release(node, args, navOptions, navigatorExtras);
    }

    public void navigate(NavDirections directions) {
        Intrinsics.checkNotNullParameter(directions, "directions");
        navigate(directions.getActionId(), directions.getArguments(), (NavOptions) null);
    }

    public void navigate(NavDirections directions, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(directions, "directions");
        navigate(directions.getActionId(), directions.getArguments(), navOptions);
    }

    public void navigate(NavDirections directions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(directions, "directions");
        Intrinsics.checkNotNullParameter(navigatorExtras, "navigatorExtras");
        navigate(directions.getActionId(), directions.getArguments(), (NavOptions) null, navigatorExtras);
    }

    public final void navigate(String route, Function1<? super NavOptionsBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.impl.navigate$navigation_runtime_release(route, builder);
    }

    public static /* synthetic */ void navigate$default(NavController navController, String str, NavOptions navOptions, Navigator.Extras extras, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i & 2) != 0) {
            navOptions = null;
        }
        if ((i & 4) != 0) {
            extras = null;
        }
        navController.navigate(str, navOptions, extras);
    }

    public final void navigate(String route, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.impl.navigate$navigation_runtime_release(route, navOptions, navigatorExtras);
    }

    public final <T> void navigate(T route, Function1<? super NavOptionsBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.impl.navigate$navigation_runtime_release((NavControllerImpl) route, builder);
    }

    public static /* synthetic */ void navigate$default(NavController navController, Object obj, NavOptions navOptions, Navigator.Extras extras, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i & 2) != 0) {
            navOptions = null;
        }
        if ((i & 4) != 0) {
            extras = null;
        }
        navController.navigate((NavController) obj, navOptions, extras);
    }

    public final <T> void navigate(T route, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.impl.navigate$navigation_runtime_release((NavControllerImpl) route, navOptions, navigatorExtras);
    }

    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    public Bundle saveState() {
        Pair[] pairArr;
        Bundle bundleSaveState$navigation_runtime_release = this.impl.saveState$navigation_runtime_release();
        if (this.deepLinkHandled) {
            if (bundleSaveState$navigation_runtime_release == null) {
                Map mapEmptyMap = MapsKt.emptyMap();
                if (mapEmptyMap.isEmpty()) {
                    pairArr = new Pair[0];
                } else {
                    ArrayList arrayList = new ArrayList(mapEmptyMap.size());
                    for (Map.Entry entry : mapEmptyMap.entrySet()) {
                        arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
                    }
                    pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
                }
                bundleSaveState$navigation_runtime_release = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                SavedStateWriter.m7892constructorimpl(bundleSaveState$navigation_runtime_release);
            }
            SavedStateWriter.m7898putBooleanimpl(SavedStateWriter.m7892constructorimpl(bundleSaveState$navigation_runtime_release), KEY_DEEP_LINK_HANDLED, this.deepLinkHandled);
        }
        return bundleSaveState$navigation_runtime_release;
    }

    public void restoreState(Bundle navState) {
        if (navState != null) {
            navState.setClassLoader(this.context.getClassLoader());
        }
        this.impl.restoreState$navigation_runtime_release(navState);
        if (navState != null) {
            Boolean boolM7818getBooleanOrNullimpl = SavedStateReader.m7818getBooleanOrNullimpl(SavedStateReader.m7806constructorimpl(navState), KEY_DEEP_LINK_HANDLED);
            this.deepLinkHandled = boolM7818getBooleanOrNullimpl != null ? boolM7818getBooleanOrNullimpl.booleanValue() : false;
        }
    }

    public void setLifecycleOwner(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.impl.setLifecycleOwner$navigation_runtime_release(owner);
    }

    public void setOnBackPressedDispatcher(OnBackPressedDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        if (Intrinsics.areEqual(dispatcher, this.onBackPressedDispatcher)) {
            return;
        }
        LifecycleOwner lifecycleOwner$navigation_runtime_release = this.impl.getLifecycleOwner();
        if (lifecycleOwner$navigation_runtime_release == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()".toString());
        }
        this.onBackPressedCallback.remove();
        this.onBackPressedDispatcher = dispatcher;
        dispatcher.addCallback(lifecycleOwner$navigation_runtime_release, this.onBackPressedCallback);
        Lifecycle lifecycle = lifecycleOwner$navigation_runtime_release.getLifecycle();
        lifecycle.removeObserver(this.impl.getLifecycleObserver());
        lifecycle.addObserver(this.impl.getLifecycleObserver());
    }

    public void enableOnBackPressed(boolean enabled) {
        this.enableOnBackPressedCallback = enabled;
        updateOnBackPressedCallbackEnabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateOnBackPressedCallbackEnabled() {
        /*
            r3 = this;
            androidx.activity.OnBackPressedCallback r0 = r3.onBackPressedCallback
            boolean r1 = r3.enableOnBackPressedCallback
            if (r1 == 0) goto Le
            int r1 = r3.getDestinationCountOnBackStack()
            r2 = 1
            if (r1 <= r2) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateOnBackPressedCallbackEnabled():void");
    }

    public void setViewModelStore(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        this.impl.setViewModelStore$navigation_runtime_release(viewModelStore);
    }

    public ViewModelStoreOwner getViewModelStoreOwner(int navGraphId) {
        return this.impl.getViewModelStoreOwner$navigation_runtime_release(navGraphId);
    }

    public NavBackStackEntry getBackStackEntry(int destinationId) {
        return this.impl.getBackStackEntry$navigation_runtime_release(destinationId);
    }

    public final NavBackStackEntry getBackStackEntry(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.getBackStackEntry$navigation_runtime_release(route);
    }

    public final /* synthetic */ <T> NavBackStackEntry getBackStackEntry() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return getBackStackEntry((KClass) Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> NavBackStackEntry getBackStackEntry(KClass<T> route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.getBackStackEntry$navigation_runtime_release((KClass) route);
    }

    public final <T> NavBackStackEntry getBackStackEntry(T route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.getBackStackEntry$navigation_runtime_release((NavControllerImpl) route);
    }

    public NavBackStackEntry getCurrentBackStackEntry() {
        return this.impl.getCurrentBackStackEntry$navigation_runtime_release();
    }

    public final Flow<NavBackStackEntry> getCurrentBackStackEntryFlow() {
        return FlowKt.asSharedFlow(this.impl.get_currentBackStackEntryFlow$navigation_runtime_release());
    }

    public NavBackStackEntry getPreviousBackStackEntry() {
        return this.impl.getPreviousBackStackEntry$navigation_runtime_release();
    }

    /* compiled from: NavController.android.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/navigation/NavController$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "KEY_DEEP_LINK_IDS", "", "KEY_DEEP_LINK_ARGS", "KEY_DEEP_LINK_EXTRAS", "getKEY_DEEP_LINK_EXTRAS$annotations", "KEY_DEEP_LINK_HANDLED", "KEY_DEEP_LINK_INTENT", "deepLinkSaveState", "", "enableDeepLinkSaveState", "", "saveState", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getKEY_DEEP_LINK_EXTRAS$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final void enableDeepLinkSaveState(boolean saveState) {
            NavController.deepLinkSaveState = saveState;
        }
    }

    public final /* synthetic */ <T> boolean popBackStack(boolean z) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return popBackStack((KClass) Reflection.getOrCreateKotlinClass(Object.class), z, false);
    }
}
