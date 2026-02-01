package androidx.compose.runtime;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.ObservableComposition;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.compose.ComposeNavigator;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composition.kt */
@Metadata(d1 = {"\u0000®\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B'\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ \u0010g\u001a\u00020\\2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0016¢\u0006\u0002\u0010aJ \u0010i\u001a\u00020\\2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0016¢\u0006\u0002\u0010aJ \u0010j\u001a\u00020k2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0016¢\u0006\u0002\u0010lJ \u0010m\u001a\u00020k2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0016¢\u0006\u0002\u0010lJ\u001d\u0010n\u001a\u00020\\2\u000e\u0010o\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010pH\u0000¢\u0006\u0002\brJ \u0010s\u001a\u00020\\2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0002¢\u0006\u0002\u0010aJ(\u0010t\u001a\u00020k2\u0006\u0010u\u001a\u00020<2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0002¢\u0006\u0002\u0010vJ \u0010w\u001a\u00020\\2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0002¢\u0006\u0002\u0010aJ\b\u0010x\u001a\u00020\\H\u0002J\b\u0010y\u001a\u00020<H\u0002J\u0010\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}H\u0016J\u000e\u0010~\u001a\u00020\\2\u0006\u0010\u007f\u001a\u00020HJ\t\u0010\u0080\u0001\u001a\u00020\\H\u0002J\t\u0010\u0081\u0001\u001a\u00020\\H\u0002J\t\u0010\u0082\u0001\u001a\u00020\\H\u0002J!\u0010\u0083\u0001\u001a\u00020\\2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0016¢\u0006\u0002\u0010aJ\u000f\u0010\u0084\u0001\u001a\u00020\\H\u0000¢\u0006\u0003\b\u0085\u0001J\t\u0010\u0086\u0001\u001a\u00020\\H\u0016J\u0018\u0010\u0089\u0001\u001a\u00020\\2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130(H\u0016J\u0018\u0010\u008b\u0001\u001a\u00020<2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130(H\u0016J\u0018\u0010\u008c\u0001\u001a\u00020\\2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\\0[H\u0016J:\u0010\u008e\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130\u008f\u0001032\u0015\u0010\u0090\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0092\u0001\u0012\u0004\u0012\u00020<0\u0091\u0001H\u0080\b¢\u0006\u0003\b\u0093\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\\2\u0007\u0010\u0095\u0001\u001a\u00020\u00132\u0007\u0010\u0096\u0001\u001a\u00020<H\u0002J!\u0010\u0094\u0001\u001a\u00020\\2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130(2\u0007\u0010\u0096\u0001\u001a\u00020<H\u0002J\t\u0010\u0097\u0001\u001a\u00020\\H\u0002J\u0012\u0010\u0098\u0001\u001a\u00020\\2\u0007\u0010\u0095\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010\u0099\u0001\u001a\u00020\\2\u0007\u0010\u0095\u0001\u001a\u00020\u0013H\u0002J\u0012\u0010\u009a\u0001\u001a\u00020\\2\u0007\u0010\u0095\u0001\u001a\u00020\u0013H\u0016J\t\u0010\u009b\u0001\u001a\u00020<H\u0016J)\u0010\u009c\u0001\u001a\u00020\\2\u001e\u0010\u009d\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u009e\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009e\u00010\u008f\u000103H\u0016J\u0012\u0010\u009f\u0001\u001a\u00020\\2\u0007\u0010W\u001a\u00030 \u0001H\u0016J\u0011\u0010¡\u0001\u001a\u00020\\2\u0006\u00106\u001a\u000207H\u0002J\t\u0010¢\u0001\u001a\u00020\\H\u0016J\t\u0010£\u0001\u001a\u00020\\H\u0016J\t\u0010¤\u0001\u001a\u00020\\H\u0016JL\u0010¥\u0001\u001a\u0003H¦\u0001\"\u0005\b\u0000\u0010¦\u000122\u0010\u008d\u0001\u001a-\u0012!\u0012\u001f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130$¢\u0006\u000e\b§\u0001\u0012\t\b¨\u0001\u0012\u0004\b\b(6\u0012\u0005\u0012\u0003H¦\u00010\u0091\u0001H\u0082\b¢\u0006\u0003\u0010©\u0001J(\u0010ª\u0001\u001a\u0003H¦\u0001\"\u0005\b\u0000\u0010¦\u00012\u000e\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u0003H¦\u00010[H\u0082\b¢\u0006\u0003\u0010«\u0001J\t\u0010¬\u0001\u001a\u00020\\H\u0016J\t\u0010\u00ad\u0001\u001a\u00020\\H\u0016J\t\u0010®\u0001\u001a\u00020\\H\u0016J;\u0010¯\u0001\u001a\u0003H°\u0001\"\u0005\b\u0000\u0010°\u00012\t\u0010±\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010²\u0001\u001a\u00020H2\u000e\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u0003H°\u00010[H\u0016¢\u0006\u0003\u0010³\u0001J\u0015\u0010´\u0001\u001a\u0004\u0018\u00010C2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u001e\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010·\u0001\u001a\u00020%2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010¹\u0001\u001a\u00020\\2\u0007\u0010·\u0001\u001a\u00020%H\u0016J)\u0010º\u0001\u001a\u0005\u0018\u0001H¦\u0001\"\u0005\b\u0000\u0010¦\u00012\u000e\u0010\u007f\u001a\n\u0012\u0005\u0012\u0003H¦\u00010»\u0001H\u0016¢\u0006\u0003\u0010¼\u0001J\u001d\u0010½\u0001\u001a\u00020<2\u0007\u0010·\u0001\u001a\u00020%2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J(\u0010¾\u0001\u001a\u00030¶\u00012\u0007\u0010·\u0001\u001a\u00020%2\b\u0010¿\u0001\u001a\u00030\u0092\u00012\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J!\u0010À\u0001\u001a\u00020\\2\u0007\u0010¸\u0001\u001a\u00020\u00132\u0007\u0010·\u0001\u001a\u00020%H\u0000¢\u0006\u0003\bÁ\u0001J\u001b\u0010Â\u0001\u001a\u00020\\2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030/H\u0000¢\u0006\u0003\bÃ\u0001J\u001e\u0010Ä\u0001\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130$H\u0002¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u0011\u0010Ç\u0001\u001a\u00020\\2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J(\u0010È\u0001\u001a\u0003H¦\u0001\"\u0005\b\u0000\u0010¦\u00012\u000e\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u0003H¦\u00010[H\u0082\b¢\u0006\u0003\u0010«\u0001J\n\u0010|\u001a\u0004\u0018\u00010}H\u0002J\t\u0010É\u0001\u001a\u00020\\H\u0016J\u000f\u0010Ê\u0001\u001a\u00020HH\u0000¢\u0006\u0003\bË\u0001R\u0013\u0010\u0007\u001a\u00020\b8G¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013`\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0016\u001a\u00060\u0013j\u0002`\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130(8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020%0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020%0,X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030/0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130(8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u0010*R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020%038AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u001c\u0010:\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130$X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R \u0010;\u001a\u00020<X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b=\u0010\u001d\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u00020JX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\u00020PX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0010\u0010S\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0011\u0010V\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\bV\u0010?R\u000e\u0010W\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\u00020<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010?R'\u0010Z\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]X\u0086\u000e¢\u0006\u0010\n\u0002\u0010b\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010?R\u0014\u0010d\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010?R\u0014\u0010e\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010?R\u0016\u0010\u0087\u0001\u001a\u00020<8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010?¨\u0006Ì\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "Landroidx/compose/runtime/PausableComposition;", "Landroidx/compose/runtime/tooling/ObservableComposition;", SdkConstants.ATTR_PARENT, "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "getParent", "()Landroidx/compose/runtime/CompositionContext;", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "getAbandonSet$annotations", "()V", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime$annotations", "getSlotTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "observations", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/collection/MutableScatterMap;", "observedObjects", "", "getObservedObjects$runtime", "()Ljava/util/Set;", "invalidatedScopes", "Landroidx/collection/MutableScatterSet;", "conditionallyInvalidatedScopes", "derivedStates", "Landroidx/compose/runtime/DerivedState;", "derivedStateDependencies", "getDerivedStateDependencies$runtime", "conditionalScopes", "", "getConditionalScopes$runtime", "()Ljava/util/List;", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "lateChanges", "observationsProcessed", "invalidations", "pendingInvalidScopes", "", "getPendingInvalidScopes$runtime$annotations", "getPendingInvalidScopes$runtime", "()Z", "setPendingInvalidScopes$runtime", "(Z)V", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "pendingPausedComposition", "Landroidx/compose/runtime/PausedCompositionImpl;", "invalidationDelegate", "invalidationDelegateGroup", "", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "getComposer$runtime", "()Landroidx/compose/runtime/ComposerImpl;", "_recomposeContext", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "isRoot", ServerProtocol.DIALOG_PARAM_STATE, "areChildrenComposing", "getAreChildrenComposing", ComposeNavigator.NAME, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "isComposing", "isDisposed", "hasPendingChanges", "getHasPendingChanges", "setContent", "content", "setContentWithReuse", "setPausableContent", "Landroidx/compose/runtime/PausedComposition;", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "setPausableContentWithReuse", "pausedCompositionFinished", "ignoreSet", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RememberObserverHolder;", "pausedCompositionFinished$runtime", "composeInitial", "composeInitialPaused", "reusable", "(ZLkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "composeInitialWithReuse", "ensureRunning", "clearDeactivated", "setObserver", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "invalidateGroupsWithKey", "key", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "drainPendingModificationsOutOfBandLocked", "composeContent", "updateMovingInvalidations", "updateMovingInvalidations$runtime", "dispose", "hasInvalidations", "getHasInvalidations", "recordModificationsOf", SdkConstants.FD_RES_VALUES, "observesAnyOf", "prepareCompose", "block", "extractInvalidationsOfGroup", "Lkotlin/Pair;", "inGroup", "Lkotlin/Function1;", "Landroidx/compose/runtime/Anchor;", "extractInvalidationsOfGroup$runtime", "addPendingInvalidationsLocked", "value", "forgetConditionalScopes", "cleanUpDerivedStateObservations", "recordReadOf", "invalidateScopeOfLocked", "recordWriteOf", "recompose", "insertMovableContent", "references", "Landroidx/compose/runtime/MovableContentStateReference;", "disposeUnusedMovableContent", "Landroidx/compose/runtime/MovableContentState;", "applyChangesInLocked", "applyChanges", "applyLateChanges", "changesApplied", "guardInvalidationsLocked", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "abandonChanges", "invalidateAll", "verifyConsistent", "delegateInvalidations", "R", "to", "groupIndex", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAndSetShouldPauseCallback", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "recomposeScopeReleased", "getCompositionService", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "tryImminentInvalidation", "invalidateChecked", LinkHeader.Parameters.Anchor, "removeObservation", "removeObservation$runtime", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime", "takeInvalidations", "takeInvalidations-afanTW4", "()Landroidx/collection/MutableScatterMap;", "validateRecomposeScopeAnchors", "trackAbandonedValues", "deactivate", "composerStacksSizes", "composerStacksSizes$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices, PausableComposition, ObservableComposition {
    public static final int $stable = 8;
    private final CoroutineContext _recomposeContext;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ChangeList changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final MutableScatterMap<Object, Object> derivedStates;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private MutableScatterMap<Object, Object> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    private final Object lock;
    private final MutableScatterMap<Object, Object> observations;
    private final MutableScatterMap<Object, Object> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private PausedCompositionImpl pendingPausedComposition;
    private final RememberEventDispatcher rememberManager;
    private ShouldPauseCallback shouldPause;
    private final SlotTable slotTable;
    private int state;

    private static /* synthetic */ void getAbandonSet$annotations() {
    }

    public static /* synthetic */ void getPendingInvalidScopes$runtime$annotations() {
    }

    public static /* synthetic */ void getSlotTable$runtime$annotations() {
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier, CoroutineContext coroutineContext) {
        this.parent = compositionContext;
        this.applier = applier;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        int i = 0;
        int i2 = 1;
        Set<RememberObserver> setAsMutableSet = new MutableScatterSet(i, i2, defaultConstructorMarker).asMutableSet();
        this.abandonSet = setAsMutableSet;
        SlotTable slotTable = new SlotTable();
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            slotTable.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation()) {
            slotTable.collectSourceInformation();
        }
        this.slotTable = slotTable;
        this.observations = ScopeMap.m3958constructorimpl$default(null, 1, null);
        this.invalidatedScopes = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
        this.derivedStates = ScopeMap.m3958constructorimpl$default(null, 1, null);
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = ScopeMap.m3958constructorimpl$default(null, 1, null);
        this.invalidations = ScopeMap.m3958constructorimpl$default(null, 1, null);
        CompositionObserverHolder compositionObserverHolder = new CompositionObserverHolder(null, false, compositionContext, 3, null);
        this.observerHolder = compositionObserverHolder;
        this.rememberManager = new RememberEventDispatcher();
        ComposerImpl composerImpl = new ComposerImpl(applier, compositionContext, slotTable, setAsMutableSet, changeList, changeList2, compositionObserverHolder, this);
        compositionContext.registerComposer$runtime(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$954879418$runtime();
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i & 4) != 0 ? null : coroutineContext);
    }

    public final CompositionContext getParent() {
        return this.parent;
    }

    /* renamed from: getSlotTable$runtime, reason: from getter */
    public final SlotTable getSlotTable() {
        return this.slotTable;
    }

    public final Set<Object> getObservedObjects$runtime() {
        return this.observations.asMap().keySet();
    }

    public final Set<Object> getDerivedStateDependencies$runtime() {
        return this.derivedStates.asMap().keySet();
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes.asSet());
    }

    /* renamed from: getPendingInvalidScopes$runtime, reason: from getter */
    public final boolean getPendingInvalidScopes() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime(boolean z) {
        this.pendingInvalidScopes = z;
    }

    /* renamed from: getObserverHolder$runtime, reason: from getter */
    public final CompositionObserverHolder getObserverHolder() {
        return this.observerHolder;
    }

    /* renamed from: getComposer$runtime, reason: from getter */
    public final ComposerImpl getComposer() {
        return this.composer;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime() : coroutineContext;
    }

    /* renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.state == 3;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime;
        synchronized (this.lock) {
            hasPendingChanges$runtime = this.composer.getHasPendingChanges$runtime();
        }
        return hasPendingChanges$runtime;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        boolean zClearDeactivated = clearDeactivated();
        ensureRunning();
        if (zClearDeactivated) {
            composeInitialWithReuse(content);
        } else {
            composeInitial(content);
        }
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        clearDeactivated();
        ensureRunning();
        composeInitialWithReuse(content);
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContent(Function2<? super Composer, ? super Integer, Unit> content) {
        return composeInitialPaused(clearDeactivated(), content);
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        clearDeactivated();
        ensureRunning();
        return composeInitialPaused(true, content);
    }

    public final void pausedCompositionFinished$runtime(ScatterSet<RememberObserverHolder> ignoreSet) {
        this.pendingPausedComposition = null;
        if (ignoreSet != null) {
            this.rememberManager.ignoreForgotten(ignoreSet);
            this.state = 2;
        }
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composable = content;
        this.parent.composeInitial$runtime(this, content);
    }

    private final PausedComposition composeInitialPaused(boolean reusable, Function2<? super Composer, ? super Integer, Unit> content) {
        if (!(this.pendingPausedComposition == null)) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        PausedCompositionImpl pausedCompositionImpl = new PausedCompositionImpl(this, this.parent, this.composer, this.abandonSet, content, reusable, this.applier, this.lock);
        this.pendingPausedComposition = pausedCompositionImpl;
        return pausedCompositionImpl;
    }

    private final void composeInitialWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composer.startReuseFromRoot();
        composeInitial(content);
        this.composer.endReuseFromRoot();
    }

    private final void ensureRunning() {
        String str;
        int i = this.state;
        if (!(i == 0)) {
            if (i == 1) {
                str = "The composition should be activated before setting content.";
            } else if (i == 2) {
                str = "A previous pausable composition for this composition was cancelled. This composition must be disposed.";
            } else if (i == 3) {
                str = "The composition is disposed";
            } else {
                str = "";
            }
            PreconditionsKt.throwIllegalStateException(str);
        }
        if (this.pendingPausedComposition == null) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
    }

    private final boolean clearDeactivated() {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (this.state != 1) {
                z = false;
            }
            if (z) {
                this.state = 0;
            }
        }
        return z;
    }

    @Override // androidx.compose.runtime.tooling.ObservableComposition
    public CompositionObserverHandle setObserver(final CompositionObserver observer) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(observer);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.CompositionImpl.setObserver.2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj = CompositionImpl.this.lock;
                CompositionImpl compositionImpl = CompositionImpl.this;
                CompositionObserver compositionObserver = observer;
                synchronized (obj) {
                    if (Intrinsics.areEqual(compositionImpl.getObserverHolder().getObserver(), compositionObserver)) {
                        compositionImpl.getObserverHolder().setObserver(null);
                        compositionImpl.getObserverHolder().setRoot(false);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    public final void invalidateGroupsWithKey(int key) {
        List<RecomposeScopeImpl> listInvalidateGroupsWithKey$runtime;
        synchronized (this.lock) {
            listInvalidateGroupsWithKey$runtime = this.slotTable.invalidateGroupsWithKey$runtime(key);
        }
        if (listInvalidateGroupsWithKey$runtime != null) {
            int size = listInvalidateGroupsWithKey$runtime.size();
            for (int i = 0; i < size; i++) {
                if (listInvalidateGroupsWithKey$runtime.get(i).invalidateForResult(null) != InvalidationResult.IGNORED) {
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime()) {
            this.parent.invalidate$runtime(this);
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet != null) {
            if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) andSet, true);
                return;
            }
            if (andSet instanceof Object[]) {
                for (Set<? extends Object> set : (Set[]) andSet) {
                    addPendingInvalidationsLocked(set, true);
                }
                return;
            }
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet(null);
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            if (andSet == null) {
                ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
                throw new KotlinNothingValueException();
            }
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
        for (Set<? extends Object> set : (Set[]) andSet) {
            addPendingInvalidationsLocked(set, false);
        }
    }

    private final void drainPendingModificationsOutOfBandLocked() {
        Object andSet = this.pendingModifications.getAndSet(SetsKt.emptySet());
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                MutableScatterMap<Object, Object> mutableScatterMapM3790takeInvalidationsafanTW4 = m3790takeInvalidationsafanTW4();
                try {
                    this.composer.m3785composeContentZbOJvo$runtime(mutableScatterMapM3790takeInvalidationsafanTW4, content, this.shouldPause);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    this.invalidations = mutableScatterMapM3790takeInvalidationsafanTW4;
                    throw th;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        } catch (Throwable th2) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th3) {
                        rememberEventDispatcher.clear();
                        throw th3;
                    }
                }
                throw th2;
            } catch (Throwable th4) {
                abandonChanges();
                throw th4;
            }
        }
    }

    public final void updateMovingInvalidations$runtime() {
        synchronized (this.lock) {
            drainPendingModificationsOutOfBandLocked();
            MutableScatterMap<Object, Object> mutableScatterMapM3790takeInvalidationsafanTW4 = m3790takeInvalidationsafanTW4();
            try {
                this.composer.m3787updateComposerInvalidationsRY85e9Y(mutableScatterMapM3790takeInvalidationsafanTW4);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                this.invalidations = mutableScatterMapM3790takeInvalidationsafanTW4;
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            if (this.composer.getIsComposing()) {
                PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            }
            if (this.state != 3) {
                this.state = 3;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$1918065384$runtime();
                ChangeList deferredChanges$runtime = this.composer.getDeferredChanges();
                if (deferredChanges$runtime != null) {
                    applyChangesInLocked(deferredChanges$runtime);
                }
                boolean z = this.slotTable.getGroupsSize() > 0;
                if (z || !this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        if (z) {
                            this.applier.onBeginChanges();
                            SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                            try {
                                ComposerKt.removeCurrentGroup(slotWriterOpenWriter, this.rememberManager);
                                Unit unit = Unit.INSTANCE;
                                slotWriterOpenWriter.close(true);
                                this.applier.clear();
                                this.applier.onEndChanges();
                                rememberEventDispatcher.dispatchRememberObservers();
                            } catch (Throwable th) {
                                slotWriterOpenWriter.close(false);
                                throw th;
                            }
                        }
                        rememberEventDispatcher.dispatchAbandons();
                    } finally {
                        rememberEventDispatcher.clear();
                    }
                }
                this.composer.dispose$runtime();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = ScopeMap.m3963getSizeimpl(this.invalidations) > 0;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.Set[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Set<? extends Object> setPlus;
        do {
            obj = this.pendingModifications.get();
            if (obj == null || Intrinsics.areEqual(obj, CompositionKt.PendingApplyNoModifications)) {
                setPlus = values;
            } else if (obj instanceof Set) {
                setPlus = new Set[]{obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                setPlus = ArraysKt.plus((Set<? extends Object>[]) obj, values);
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, obj, setPlus));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        this.composer.prepareCompose$runtime(block);
    }

    public final List<Pair<RecomposeScopeImpl, Object>> extractInvalidationsOfGroup$runtime(Function1<? super Anchor, Boolean> inGroup) {
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        int i3;
        long j;
        int i4;
        char c;
        long j2;
        int i5;
        int i6;
        boolean z;
        boolean zIsEmpty;
        Object[] objArr;
        long[] jArr3;
        int i7;
        Object[] objArr2;
        long[] jArr4;
        int i8;
        boolean z2;
        if (ScopeMap.m3963getSizeimpl(this.invalidations) > 0) {
            ArrayList arrayList = new ArrayList();
            MutableScatterMap mutableScatterMap = this.invalidations;
            long[] jArr5 = mutableScatterMap.metadata;
            int length = jArr5.length - 2;
            if (length < 0) {
                return arrayList;
            }
            int i9 = 0;
            while (true) {
                long j3 = jArr5[i9];
                char c2 = 7;
                long j4 = -9187201950435737472L;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8;
                    int i11 = 8 - ((~(i9 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        if ((j3 & 255) < 128) {
                            int i13 = (i9 << 3) + i12;
                            Object obj = mutableScatterMap.keys[i13];
                            Object obj2 = mutableScatterMap.values[i13];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr3 = mutableScatterSet.elements;
                                long[] jArr6 = mutableScatterSet.metadata;
                                int length2 = jArr6.length - 2;
                                jArr2 = jArr5;
                                if (length2 >= 0) {
                                    i3 = i9;
                                    j = j3;
                                    int i14 = 0;
                                    while (true) {
                                        long j5 = jArr6[i14];
                                        i4 = i11;
                                        c = 7;
                                        j2 = -9187201950435737472L;
                                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i15 = 8 - ((~(i14 - length2)) >>> 31);
                                            int i16 = 0;
                                            while (i16 < i15) {
                                                if ((j5 & 255) < 128) {
                                                    jArr4 = jArr6;
                                                    int i17 = (i14 << 3) + i16;
                                                    i7 = length;
                                                    Object obj3 = objArr3[i17];
                                                    objArr2 = objArr3;
                                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                                                    i8 = i12;
                                                    Anchor anchor = recomposeScopeImpl.getAnchor();
                                                    if (anchor == null || !inGroup.invoke(anchor).booleanValue()) {
                                                        z2 = false;
                                                    } else {
                                                        arrayList.add(TuplesKt.to(recomposeScopeImpl, obj3));
                                                        z2 = true;
                                                    }
                                                    if (z2) {
                                                        mutableScatterSet.removeElementAt(i17);
                                                    }
                                                } else {
                                                    i7 = length;
                                                    objArr2 = objArr3;
                                                    jArr4 = jArr6;
                                                    i8 = i12;
                                                }
                                                j5 >>= 8;
                                                i16++;
                                                length = i7;
                                                jArr6 = jArr4;
                                                objArr3 = objArr2;
                                                i12 = i8;
                                            }
                                            i2 = length;
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                            i5 = i12;
                                            if (i15 != 8) {
                                                break;
                                            }
                                        } else {
                                            i2 = length;
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                            i5 = i12;
                                        }
                                        if (i14 == length2) {
                                            break;
                                        }
                                        i14++;
                                        i11 = i4;
                                        length = i2;
                                        jArr6 = jArr3;
                                        objArr3 = objArr;
                                        i12 = i5;
                                    }
                                } else {
                                    i2 = length;
                                    i3 = i9;
                                    j = j3;
                                    i4 = i11;
                                    i5 = i12;
                                    j2 = -9187201950435737472L;
                                    c = 7;
                                }
                                zIsEmpty = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr5;
                                i2 = length;
                                i3 = i9;
                                j = j3;
                                i4 = i11;
                                c = c2;
                                i5 = i12;
                                j2 = -9187201950435737472L;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
                                Anchor anchor2 = recomposeScopeImpl2.getAnchor();
                                if (anchor2 == null || !inGroup.invoke(anchor2).booleanValue()) {
                                    z = false;
                                } else {
                                    arrayList.add(TuplesKt.to(recomposeScopeImpl2, obj2));
                                    z = true;
                                }
                                zIsEmpty = z;
                            }
                            if (zIsEmpty) {
                                mutableScatterMap.removeValueAt(i13);
                            }
                            i6 = 8;
                        } else {
                            jArr2 = jArr5;
                            i2 = length;
                            i3 = i9;
                            j = j3;
                            i4 = i11;
                            c = c2;
                            j2 = j4;
                            i5 = i12;
                            i6 = i10;
                        }
                        j3 = j >> i6;
                        i12 = i5 + 1;
                        i10 = i6;
                        j4 = j2;
                        c2 = c;
                        jArr5 = jArr2;
                        i9 = i3;
                        i11 = i4;
                        length = i2;
                    }
                    jArr = jArr5;
                    int i18 = length;
                    int i19 = i9;
                    if (i11 != i10) {
                        return arrayList;
                    }
                    i = i19;
                    length = i18;
                } else {
                    jArr = jArr5;
                    i = i9;
                }
                if (i == length) {
                    return arrayList;
                }
                i9 = i + 1;
                jArr5 = jArr;
            }
        } else {
            return CollectionsKt.emptyList();
        }
    }

    private final void addPendingInvalidationsLocked(Object value, boolean forgetConditionalScopes) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (!ScopeMap.m3965removeimpl(this.observationsProcessed, value, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(value) != InvalidationResult.IGNORED) {
                                if (recomposeScopeImpl.isConditional() && !forgetConditionalScopes) {
                                    this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                } else {
                                    this.invalidatedScopes.add(recomposeScopeImpl);
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (ScopeMap.m3965removeimpl(this.observationsProcessed, value, recomposeScopeImpl2) || recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IGNORED) {
                return;
            }
            if (recomposeScopeImpl2.isConditional() && !forgetConditionalScopes) {
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
            } else {
                this.invalidatedScopes.add(recomposeScopeImpl2);
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        long[] jArr;
        long[] jArr2;
        int i;
        int i2;
        int i3;
        int i4;
        Object[] objArr;
        long[] jArr3;
        Object[] objArr2;
        long[] jArr4;
        MutableScatterMap<Object, Object> mutableScatterMap = this.derivedStates;
        long[] jArr5 = mutableScatterMap.metadata;
        int length = jArr5.length - 2;
        long j = 255;
        char c = 7;
        long j2 = -9187201950435737472L;
        int i5 = 8;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j3 = jArr5[i6];
                if ((((~j3) << c) & j3 & j2) != j2) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j3 & j) < 128) {
                            int i9 = (i6 << 3) + i8;
                            Object obj = mutableScatterMap.keys[i9];
                            Object obj2 = mutableScatterMap.values[i9];
                            boolean zIsEmpty = true;
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr3 = mutableScatterSet.elements;
                                long[] jArr6 = mutableScatterSet.metadata;
                                int length2 = jArr6.length - 2;
                                jArr2 = jArr5;
                                i = length;
                                if (length2 >= 0) {
                                    int i10 = 0;
                                    while (true) {
                                        long j4 = jArr6[i10];
                                        i2 = i7;
                                        i3 = i8;
                                        if ((((~j4) << c) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                            int i12 = 0;
                                            while (i12 < i11) {
                                                if ((j4 & 255) < 128) {
                                                    int i13 = (i10 << 3) + i12;
                                                    objArr2 = objArr3;
                                                    jArr4 = jArr6;
                                                    if (!ScopeMap.m3959containsimpl(this.observations, (DerivedState) objArr3[i13])) {
                                                        mutableScatterSet.removeElementAt(i13);
                                                    }
                                                } else {
                                                    objArr2 = objArr3;
                                                    jArr4 = jArr6;
                                                }
                                                j4 >>= 8;
                                                i12++;
                                                jArr6 = jArr4;
                                                objArr3 = objArr2;
                                            }
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                            if (i11 != 8) {
                                                break;
                                            }
                                        } else {
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                        }
                                        if (i10 == length2) {
                                            break;
                                        }
                                        i10++;
                                        i7 = i2;
                                        i8 = i3;
                                        jArr6 = jArr3;
                                        objArr3 = objArr;
                                        c = 7;
                                    }
                                } else {
                                    i2 = i7;
                                    i3 = i8;
                                }
                                zIsEmpty = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr5;
                                i = length;
                                i2 = i7;
                                i3 = i8;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                if (ScopeMap.m3959containsimpl(this.observations, (DerivedState) obj2)) {
                                    zIsEmpty = false;
                                }
                            }
                            if (zIsEmpty) {
                                mutableScatterMap.removeValueAt(i9);
                            }
                            i4 = 8;
                        } else {
                            jArr2 = jArr5;
                            i = length;
                            i2 = i7;
                            i3 = i8;
                            i4 = i5;
                        }
                        j3 >>= i4;
                        i8 = i3 + 1;
                        i5 = i4;
                        jArr5 = jArr2;
                        length = i;
                        i7 = i2;
                        j = 255;
                        c = 7;
                    }
                    jArr = jArr5;
                    int i14 = length;
                    if (i7 != i5) {
                        break;
                    } else {
                        length = i14;
                    }
                } else {
                    jArr = jArr5;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
                jArr5 = jArr;
                j = 255;
                c = 7;
                j2 = -9187201950435737472L;
                i5 = 8;
            }
        }
        if (!this.conditionallyInvalidatedScopes.isNotEmpty()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        Object[] objArr4 = mutableScatterSet2.elements;
        long[] jArr7 = mutableScatterSet2.metadata;
        int length3 = jArr7.length - 2;
        if (length3 < 0) {
            return;
        }
        int i15 = 0;
        while (true) {
            long j5 = jArr7[i15];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i16 = 8 - ((~(i15 - length3)) >>> 31);
                for (int i17 = 0; i17 < i16; i17++) {
                    if ((j5 & 255) < 128) {
                        int i18 = (i15 << 3) + i17;
                        if (!((RecomposeScopeImpl) objArr4[i18]).isConditional()) {
                            mutableScatterSet2.removeElementAt(i18);
                        }
                    }
                    j5 >>= 8;
                }
                if (i16 != 8) {
                    return;
                }
            }
            if (i15 == length3) {
                return;
            } else {
                i15++;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        long[] jArr;
        long[] jArr2;
        int i;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime = this.composer.getCurrentRecomposeScope$runtime()) == null) {
            return;
        }
        currentRecomposeScope$runtime.setUsed(true);
        boolean zRecordRead = currentRecomposeScope$runtime.recordRead(value);
        CompositionObserver compositionObserverObserver = observer();
        if (compositionObserverObserver != null) {
            compositionObserverObserver.onReadInScope(currentRecomposeScope$runtime, value);
        }
        if (zRecordRead) {
            return;
        }
        if (value instanceof StateObjectImpl) {
            ReaderKind.Companion companion = ReaderKind.INSTANCE;
            ((StateObjectImpl) value).m4015recordReadInh_f27i8$runtime(ReaderKind.m3997constructorimpl(1));
        }
        ScopeMap.m3952addimpl(this.observations, value, currentRecomposeScope$runtime);
        if (value instanceof DerivedState) {
            DerivedState<?> derivedState = (DerivedState) value;
            DerivedState.Record<?> currentRecord = derivedState.getCurrentRecord();
            ScopeMap.m3967removeScopeimpl(this.derivedStates, value);
            ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
            Object[] objArr = dependencies.keys;
            long[] jArr3 = dependencies.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr3[i2];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i3 = 8;
                        int i4 = 8 - ((~(i2 - length)) >>> 31);
                        int i5 = 0;
                        while (i5 < i4) {
                            if ((j & 255) < 128) {
                                StateObject stateObject = (StateObject) objArr[(i2 << 3) + i5];
                                if (stateObject instanceof StateObjectImpl) {
                                    ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                                    jArr2 = jArr3;
                                    ((StateObjectImpl) stateObject).m4015recordReadInh_f27i8$runtime(ReaderKind.m3997constructorimpl(1));
                                } else {
                                    jArr2 = jArr3;
                                }
                                ScopeMap.m3952addimpl(this.derivedStates, stateObject, value);
                                i = 8;
                            } else {
                                jArr2 = jArr3;
                                i = i3;
                            }
                            j >>= i;
                            i5++;
                            i3 = i;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i4 != i3) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                    jArr3 = jArr;
                }
            }
            currentRecomposeScope$runtime.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                                ScopeMap.m3952addimpl(this.observationsProcessed, value, recomposeScopeImpl);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                ScopeMap.m3952addimpl(this.observationsProcessed, value, recomposeScopeImpl2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void recordWriteOf(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.lock
            monitor-enter(r0)
            r14.invalidateScopeOfLocked(r15)     // Catch: java.lang.Throwable -> L64
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r1 = r14.derivedStates     // Catch: java.lang.Throwable -> L64
            java.lang.Object r15 = r1.get(r15)     // Catch: java.lang.Throwable -> L64
            if (r15 == 0) goto L60
            boolean r1 = r15 instanceof androidx.collection.MutableScatterSet     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L5b
            androidx.collection.MutableScatterSet r15 = (androidx.collection.MutableScatterSet) r15     // Catch: java.lang.Throwable -> L64
            androidx.collection.ScatterSet r15 = (androidx.collection.ScatterSet) r15     // Catch: java.lang.Throwable -> L64
            java.lang.Object[] r1 = r15.elements     // Catch: java.lang.Throwable -> L64
            long[] r15 = r15.metadata     // Catch: java.lang.Throwable -> L64
            int r2 = r15.length     // Catch: java.lang.Throwable -> L64
            int r2 = r2 + (-2)
            if (r2 < 0) goto L60
            r3 = 0
            r4 = r3
        L21:
            r5 = r15[r4]     // Catch: java.lang.Throwable -> L64
            long r7 = ~r5     // Catch: java.lang.Throwable -> L64
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L56
            int r7 = r4 - r2
            int r7 = ~r7     // Catch: java.lang.Throwable -> L64
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L3b:
            if (r9 >= r7) goto L54
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L50
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]     // Catch: java.lang.Throwable -> L64
            androidx.compose.runtime.DerivedState r10 = (androidx.compose.runtime.DerivedState) r10     // Catch: java.lang.Throwable -> L64
            r14.invalidateScopeOfLocked(r10)     // Catch: java.lang.Throwable -> L64
        L50:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L3b
        L54:
            if (r7 != r8) goto L60
        L56:
            if (r4 == r2) goto L60
            int r4 = r4 + 1
            goto L21
        L5b:
            androidx.compose.runtime.DerivedState r15 = (androidx.compose.runtime.DerivedState) r15     // Catch: java.lang.Throwable -> L64
            r14.invalidateScopeOfLocked(r15)     // Catch: java.lang.Throwable -> L64
        L60:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L64
            monitor-exit(r0)
            return
        L64:
            r15 = move-exception
            monitor-exit(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordWriteOf(java.lang.Object):void");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        synchronized (this.lock) {
            PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
            if (pausedCompositionImpl != null && !pausedCompositionImpl.isRecomposing$runtime()) {
                pausedCompositionImpl.markIncomplete$runtime();
                return false;
            }
            drainPendingModificationsForCompositionLocked();
            try {
                try {
                    boolean zM3786recomposeaFTiNEg$runtime = this.composer.m3786recomposeaFTiNEg$runtime(m3790takeInvalidationsafanTW4(), this.shouldPause);
                    if (!zM3786recomposeaFTiNEg$runtime) {
                        drainPendingModificationsLocked();
                    }
                    return zM3786recomposeaFTiNEg$runtime;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
            SlotWriter slotWriterOpenWriter = state.getSlotTable().openWriter();
            try {
                ComposerKt.removeCurrentGroup(slotWriterOpenWriter, this.rememberManager);
                Unit unit = Unit.INSTANCE;
                slotWriterOpenWriter.close(true);
                rememberEventDispatcher.dispatchRememberObservers();
            } catch (Throwable th) {
                slotWriterOpenWriter.close(false);
                throw th;
            }
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    /* JADX WARN: Finally extract failed */
    private final void applyChangesInLocked(ChangeList changes) throws Throwable {
        RememberEventDispatcher rememberManager$runtime;
        Object obj;
        Object obj2;
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        int i3;
        char c;
        long j;
        int i4;
        boolean zIsEmpty;
        long[] jArr3;
        RecordingApplier<Object> pausableApplier$runtime;
        CompositionImpl compositionImpl = this;
        compositionImpl.rememberManager.prepare(compositionImpl.abandonSet, compositionImpl.composer.getErrorContext$runtime());
        try {
            if (!changes.isEmpty()) {
                Object objBeginSection = Trace.INSTANCE.beginSection("Compose:applyChanges");
                try {
                    PausedCompositionImpl pausedCompositionImpl = compositionImpl.pendingPausedComposition;
                    RecordingApplier<Object> recordingApplier = (pausedCompositionImpl == null || (pausableApplier$runtime = pausedCompositionImpl.getPausableApplier$runtime()) == null) ? compositionImpl.applier : pausableApplier$runtime;
                    PausedCompositionImpl pausedCompositionImpl2 = compositionImpl.pendingPausedComposition;
                    if (pausedCompositionImpl2 == null || (rememberManager$runtime = pausedCompositionImpl2.getRememberManager()) == null) {
                        rememberManager$runtime = compositionImpl.rememberManager;
                    }
                    recordingApplier.onBeginChanges();
                    SlotWriter slotWriterOpenWriter = compositionImpl.slotTable.openWriter();
                    int i5 = 0;
                    try {
                        changes.executeAndFlushAllPendingChanges(recordingApplier, slotWriterOpenWriter, rememberManager$runtime, compositionImpl.composer.getErrorContext$runtime());
                        Unit unit = Unit.INSTANCE;
                        slotWriterOpenWriter.close(true);
                        recordingApplier.onEndChanges();
                        Unit unit2 = Unit.INSTANCE;
                        Trace.INSTANCE.endSection(objBeginSection);
                        compositionImpl.rememberManager.dispatchRememberObservers();
                        compositionImpl.rememberManager.dispatchSideEffects();
                        if (compositionImpl.pendingInvalidScopes) {
                            try {
                                Object objBeginSection2 = Trace.INSTANCE.beginSection("Compose:unobserve");
                                try {
                                    compositionImpl.pendingInvalidScopes = false;
                                    MutableScatterMap<Object, Object> mutableScatterMap = compositionImpl.observations;
                                    long[] jArr4 = mutableScatterMap.metadata;
                                    int length = jArr4.length - 2;
                                    if (length >= 0) {
                                        int i6 = 0;
                                        while (true) {
                                            try {
                                                long j2 = jArr4[i6];
                                                char c2 = 7;
                                                long j3 = -9187201950435737472L;
                                                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i7 = 8;
                                                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                                                    int i9 = i5;
                                                    while (i9 < i8) {
                                                        if ((j2 & 255) < 128) {
                                                            int i10 = (i6 << 3) + i9;
                                                            Object obj3 = mutableScatterMap.keys[i10];
                                                            Object obj4 = mutableScatterMap.values[i10];
                                                            if (obj4 instanceof MutableScatterSet) {
                                                                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj4;
                                                                Object[] objArr = mutableScatterSet.elements;
                                                                long[] jArr5 = mutableScatterSet.metadata;
                                                                int length2 = jArr5.length - 2;
                                                                obj2 = objBeginSection2;
                                                                if (length2 >= 0) {
                                                                    int i11 = 0;
                                                                    while (true) {
                                                                        try {
                                                                            long j4 = jArr5[i11];
                                                                            i2 = length;
                                                                            i3 = i6;
                                                                            c = 7;
                                                                            j = -9187201950435737472L;
                                                                            if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                int i12 = 8 - ((~(i11 - length2)) >>> 31);
                                                                                int i13 = 0;
                                                                                while (i13 < i12) {
                                                                                    if ((j4 & 255) < 128) {
                                                                                        jArr3 = jArr4;
                                                                                        int i14 = (i11 << 3) + i13;
                                                                                        if (!((RecomposeScopeImpl) objArr[i14]).getValid()) {
                                                                                            mutableScatterSet.removeElementAt(i14);
                                                                                        }
                                                                                    } else {
                                                                                        jArr3 = jArr4;
                                                                                    }
                                                                                    j4 >>= 8;
                                                                                    i13++;
                                                                                    jArr4 = jArr3;
                                                                                }
                                                                                jArr2 = jArr4;
                                                                                if (i12 != 8) {
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                jArr2 = jArr4;
                                                                            }
                                                                            if (i11 == length2) {
                                                                                break;
                                                                            }
                                                                            i11++;
                                                                            length = i2;
                                                                            i6 = i3;
                                                                            jArr4 = jArr2;
                                                                        } catch (Throwable th) {
                                                                            th = th;
                                                                            obj = obj2;
                                                                            Trace.INSTANCE.endSection(obj);
                                                                            throw th;
                                                                        }
                                                                    }
                                                                } else {
                                                                    jArr2 = jArr4;
                                                                    i2 = length;
                                                                    i3 = i6;
                                                                    c = c2;
                                                                    j = -9187201950435737472L;
                                                                }
                                                                zIsEmpty = mutableScatterSet.isEmpty();
                                                            } else {
                                                                obj2 = objBeginSection2;
                                                                jArr2 = jArr4;
                                                                i2 = length;
                                                                i3 = i6;
                                                                c = c2;
                                                                j = j3;
                                                                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                                                zIsEmpty = !((RecomposeScopeImpl) obj4).getValid();
                                                            }
                                                            if (zIsEmpty) {
                                                                mutableScatterMap.removeValueAt(i10);
                                                            }
                                                            i4 = 8;
                                                        } else {
                                                            obj2 = objBeginSection2;
                                                            jArr2 = jArr4;
                                                            i2 = length;
                                                            i3 = i6;
                                                            c = c2;
                                                            j = j3;
                                                            i4 = i7;
                                                        }
                                                        j2 >>= i4;
                                                        i9++;
                                                        i7 = i4;
                                                        j3 = j;
                                                        c2 = c;
                                                        objBeginSection2 = obj2;
                                                        length = i2;
                                                        i6 = i3;
                                                        jArr4 = jArr2;
                                                    }
                                                    obj2 = objBeginSection2;
                                                    jArr = jArr4;
                                                    int i15 = length;
                                                    int i16 = i6;
                                                    if (i8 != i7) {
                                                        break;
                                                    }
                                                    length = i15;
                                                    i = i16;
                                                } else {
                                                    obj2 = objBeginSection2;
                                                    jArr = jArr4;
                                                    i = i6;
                                                }
                                                if (i == length) {
                                                    break;
                                                }
                                                i6 = i + 1;
                                                i5 = 0;
                                                objBeginSection2 = obj2;
                                                jArr4 = jArr;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                obj2 = objBeginSection2;
                                                obj = obj2;
                                                Trace.INSTANCE.endSection(obj);
                                                throw th;
                                            }
                                        }
                                    } else {
                                        obj2 = objBeginSection2;
                                    }
                                    cleanUpDerivedStateObservations();
                                    Unit unit3 = Unit.INSTANCE;
                                    Trace.INSTANCE.endSection(obj2);
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj = objBeginSection2;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                compositionImpl = this;
                                try {
                                    if (compositionImpl.lateChanges.isEmpty() && compositionImpl.pendingPausedComposition == null) {
                                        compositionImpl.rememberManager.dispatchAbandons();
                                    }
                                    throw th;
                                } finally {
                                }
                            }
                        }
                        try {
                            if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                                this.rememberManager.dispatchAbandons();
                            }
                            return;
                        } finally {
                            this.rememberManager.clear();
                        }
                    } catch (Throwable th5) {
                        slotWriterOpenWriter.close(false);
                        throw th5;
                    }
                } catch (Throwable th6) {
                    Trace.INSTANCE.endSection(objBeginSection);
                    throw th6;
                }
            }
            try {
                if (compositionImpl.lateChanges.isEmpty() && compositionImpl.pendingPausedComposition == null) {
                    compositionImpl.rememberManager.dispatchAbandons();
                }
            } finally {
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        RememberEventDispatcher rememberEventDispatcher;
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime();
                if (!this.abandonSet.isEmpty()) {
                    rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } finally {
                    }
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } finally {
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    abandonChanges();
                    throw th2;
                }
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super ScopeMap<RecomposeScopeImpl, Object>, ? extends T> block) {
        MutableScatterMap<Object, Object> mutableScatterMapM3790takeInvalidationsafanTW4 = m3790takeInvalidationsafanTW4();
        try {
            return block.invoke(ScopeMap.m3955boximpl(mutableScatterMapM3790takeInvalidationsafanTW4));
        } catch (Throwable th) {
            this.invalidations = mutableScatterMapM3790takeInvalidationsafanTW4;
            throw th;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (this.abandonSet.isEmpty()) {
            return;
        }
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
            rememberEventDispatcher.dispatchAbandons();
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            for (Object obj : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        if (to != null && !Intrinsics.areEqual(to, this) && groupIndex >= 0) {
            this.invalidationDelegate = (CompositionImpl) to;
            this.invalidationDelegateGroup = groupIndex;
            try {
                return block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return block.invoke();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public ShouldPauseCallback getAndSetShouldPauseCallback(ShouldPauseCallback shouldPause) {
        ShouldPauseCallback shouldPauseCallback = this.shouldPause;
        this.shouldPause = shouldPause;
        return shouldPauseCallback;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        CompositionObserver compositionObserverObserver;
        CompositionImpl compositionImpl;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (this.slotTable.ownsAnchor(anchor)) {
            if (!scope.getCanRecompose()) {
                return InvalidationResult.IGNORED;
            }
            InvalidationResult invalidationResultInvalidateChecked = invalidateChecked(scope, anchor, instance);
            if (invalidationResultInvalidateChecked != InvalidationResult.IGNORED && (compositionObserverObserver = observer()) != null) {
                compositionObserverObserver.onScopeInvalidated(scope, instance);
            }
            return invalidationResultInvalidateChecked;
        }
        synchronized (this.lock) {
            compositionImpl = this.invalidationDelegate;
        }
        if (compositionImpl != null && compositionImpl.tryImminentInvalidation(scope, instance)) {
            return InvalidationResult.IMMINENT;
        }
        return InvalidationResult.IGNORED;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
        CompositionObserver compositionObserverObserver = observer();
        if (compositionObserverObserver != null) {
            compositionObserverObserver.onScopeDisposed(scope);
        }
    }

    @Override // androidx.compose.runtime.CompositionServices
    public <T> T getCompositionService(CompositionServiceKey<T> key) {
        if (Intrinsics.areEqual(key, CompositionKt.getObservableCompositionServiceKey())) {
            return (T) this;
        }
        return null;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime(scope, instance);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a2 A[Catch: all -> 0x00c3, EDGE_INSN: B:63:0x00a2->B:48:0x00a2 BREAK  A[LOOP:0: B:29:0x005b->B:44:0x009a], EDGE_INSN: B:64:0x00a2->B:48:0x00a2 BREAK  A[LOOP:0: B:29:0x005b->B:44:0x009a], TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0010, B:12:0x001f, B:14:0x0025, B:18:0x002b, B:19:0x0034, B:21:0x0038, B:22:0x0041, B:24:0x0049, B:26:0x004d, B:29:0x005b, B:31:0x006b, B:33:0x0077, B:35:0x0081, B:40:0x0090, B:44:0x009a, B:45:0x009d, B:48:0x00a2), top: B:61:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.runtime.InvalidationResult invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl r21, androidx.compose.runtime.Anchor r22, java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.Anchor, java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    public final void removeObservation$runtime(Object instance, RecomposeScopeImpl scope) {
        ScopeMap.m3965removeimpl(this.observations, instance, scope);
    }

    public final void removeDerivedStateObservation$runtime(DerivedState<?> state) {
        if (ScopeMap.m3959containsimpl(this.observations, state)) {
            return;
        }
        ScopeMap.m3967removeScopeimpl(this.derivedStates, state);
    }

    /* renamed from: takeInvalidations-afanTW4, reason: not valid java name */
    private final MutableScatterMap<Object, Object> m3790takeInvalidationsafanTW4() {
        MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
        this.invalidations = ScopeMap.m3958constructorimpl$default(null, 1, null);
        return mutableScatterMap;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        Object[] slots = slotTable.getSlots();
        ArrayList arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList2.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime(anchor.toIndexFor(slotTable)).contains(recomposeScopeImpl2)) {
                PreconditionsKt.throwIllegalStateException("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt.indexOf((RecomposeScopeImpl[]) slotTable.getSlots(), recomposeScopeImpl2));
            }
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            T tInvoke = block.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return tInvoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (!this.abandonSet.isEmpty()) {
                RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                try {
                    rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                    rememberEventDispatcher.dispatchAbandons();
                } finally {
                    InlineMarker.finallyStart(1);
                    rememberEventDispatcher.clear();
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final CompositionObserver observer() {
        return this.observerHolder.current();
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        synchronized (this.lock) {
            if (!(this.pendingPausedComposition == null)) {
                PreconditionsKt.throwIllegalStateException("Deactivate is not supported while pausable composition is in progress");
            }
            boolean z = this.slotTable.getGroupsSize() > 0;
            if (z || !this.abandonSet.isEmpty()) {
                Object objBeginSection = Trace.INSTANCE.beginSection("Compose:deactivate");
                try {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        if (z) {
                            this.applier.onBeginChanges();
                            SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                            try {
                                ComposerKt.deactivateCurrentGroup(slotWriterOpenWriter, this.rememberManager);
                                Unit unit = Unit.INSTANCE;
                                slotWriterOpenWriter.close(true);
                                this.applier.onEndChanges();
                                rememberEventDispatcher.dispatchRememberObservers();
                            } catch (Throwable th) {
                                slotWriterOpenWriter.close(false);
                                throw th;
                            }
                        }
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                        Unit unit2 = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        rememberEventDispatcher.clear();
                        throw th2;
                    }
                } finally {
                    Trace.INSTANCE.endSection(objBeginSection);
                }
            }
            ScopeMap.m3956clearimpl(this.observations);
            ScopeMap.m3956clearimpl(this.derivedStates);
            ScopeMap.m3956clearimpl(this.invalidations);
            this.changes.clear();
            this.lateChanges.clear();
            this.composer.deactivate$runtime();
            this.state = 1;
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final int composerStacksSizes$runtime() {
        return this.composer.stacksSize$runtime();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5c
            androidx.compose.runtime.collection.ScatterSetWrapper r15 = (androidx.compose.runtime.collection.ScatterSetWrapper) r15
            androidx.collection.ScatterSet r15 = r15.getSet$runtime()
            java.lang.Object[] r0 = r15.elements
            long[] r15 = r15.metadata
            int r3 = r15.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L7d
            r4 = r1
        L16:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r1
        L30:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r11 = r14.observations
            boolean r11 = androidx.compose.runtime.collection.ScopeMap.m3959containsimpl(r11, r10)
            if (r11 != 0) goto L50
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r11 = r14.derivedStates
            boolean r10 = androidx.compose.runtime.collection.ScopeMap.m3959containsimpl(r11, r10)
            if (r10 == 0) goto L51
        L50:
            return r2
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L30
        L55:
            if (r7 != r8) goto L7d
        L57:
            if (r4 == r3) goto L7d
            int r4 = r4 + 1
            goto L16
        L5c:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
        L62:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L7d
            java.lang.Object r0 = r15.next()
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r3 = r14.observations
            boolean r3 = androidx.compose.runtime.collection.ScopeMap.m3959containsimpl(r3, r0)
            if (r3 != 0) goto L7c
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r3 = r14.derivedStates
            boolean r0 = androidx.compose.runtime.collection.ScopeMap.m3959containsimpl(r3, r0)
            if (r0 == 0) goto L62
        L7c:
            return r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addPendingInvalidationsLocked(java.util.Set<? extends java.lang.Object> r34, boolean r35) {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.addPendingInvalidationsLocked(java.util.Set, boolean):void");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        int size = references.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual(references.get(i).getFirst().getComposition(), this)) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th2) {
                        rememberEventDispatcher.clear();
                        throw th2;
                    }
                }
                throw th;
            } catch (Throwable th3) {
                abandonChanges();
                throw th3;
            }
        }
    }

    private final <T> T guardChanges(Function0<? extends T> block) {
        try {
            try {
                T tInvoke = block.invoke();
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                return tInvoke;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        InlineMarker.finallyStart(1);
                        rememberEventDispatcher.clear();
                        InlineMarker.finallyEnd(1);
                    } catch (Throwable th2) {
                        InlineMarker.finallyStart(1);
                        rememberEventDispatcher.clear();
                        InlineMarker.finallyEnd(1);
                        throw th2;
                    }
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } catch (Throwable th3) {
            abandonChanges();
            throw th3;
        }
    }
}
