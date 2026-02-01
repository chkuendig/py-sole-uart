package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.autofill.PlatformAutofillManagerImpl;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusOwnerImplKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.focus.PlatformFocusOwner;
import androidx.compose.ui.focus.TwoDimensionalFocusSearchKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidGraphicsContext_androidKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.indirect.AndroidIndirectTouchEvent;
import androidx.compose.ui.input.indirect.AndroidIndirectTouchEvent_androidKt;
import androidx.compose.ui.input.indirect.IndirectTouchEvent;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.InsetsListener;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.layout.WindowInsetsRulers_androidKt;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OutOfFrameExecutor;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.semantics.EmptySemanticsModifier;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.android.SdkConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sun.jna.Callback;
import com.sun.jna.platform.win32.WinError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u0000ó\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018*\u0003-Ã\u0002\b\u0001\u0018\u0000 Ñ\u00042\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0004Ñ\u0004Ò\u0004B\u0017\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u00103\u001a\u000204H\u0016J\u0017\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020GH\u0016¢\u0006\u0004\bH\u0010IJ\n\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010N\u001a\u0004\u0018\u00010\u00182\u0006\u0010O\u001a\u000204H\u0002JA\u0010\u0085\u0002\u001a\u00030\u0086\u00022.\u0010\u0087\u0002\u001a)\b\u0001\u0012\u0005\u0012\u00030\u0089\u0002\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0086\u00020\u008a\u0002\u0012\u0007\u0012\u0005\u0018\u00010\u008b\u00020\u0088\u0002¢\u0006\u0003\b\u008c\u0002H\u0096@¢\u0006\u0003\u0010\u008d\u0002J\u0014\u0010Ì\u0002\u001a\u00030\u0098\u00012\b\u0010Í\u0002\u001a\u00030Î\u0002H\u0016J\u0014\u0010Ï\u0002\u001a\u00030\u0098\u00012\b\u0010Ð\u0002\u001a\u00030Ñ\u0002H\u0016J/\u0010Ö\u0002\u001a\u00030\u0098\u00012\b\u0010×\u0002\u001a\u00030Î\u00022\b\u0010Ø\u0002\u001a\u00030Ù\u00022\u000f\u0010Ú\u0002\u001a\n\u0012\u0005\u0012\u00030Ü\u00020Û\u0002H\u0016J\u0014\u0010Ý\u0002\u001a\u00030\u0098\u00012\b\u0010Þ\u0002\u001a\u00030ß\u0002H\u0016J\u001e\u0010à\u0002\u001a\u0004\u0018\u00010\u00182\t\u0010á\u0002\u001a\u0004\u0018\u00010\u00182\u0006\u0010O\u001a\u000204H\u0016J\u001d\u0010â\u0002\u001a\u00020\u00122\u0006\u0010O\u001a\u0002042\n\u0010ã\u0002\u001a\u0005\u0018\u00010Î\u0002H\u0016J$\u0010ä\u0002\u001a\u00020\u00122\b\u0010F\u001a\u0004\u0018\u00010G2\t\u0010ã\u0002\u001a\u0004\u0018\u00010KH\u0016¢\u0006\u0003\bå\u0002J\n\u0010æ\u0002\u001a\u00030\u0098\u0001H\u0016J'\u0010ç\u0002\u001a\u00030\u0098\u00012\u0007\u0010è\u0002\u001a\u00020\u00122\u0006\u0010O\u001a\u0002042\n\u0010ã\u0002\u001a\u0005\u0018\u00010Î\u0002H\u0014J\u0013\u0010é\u0002\u001a\u00030\u0098\u00012\u0007\u0010ê\u0002\u001a\u00020\u0012H\u0016J\u001c\u0010ë\u0002\u001a\u00020\u00122\b\u0010ì\u0002\u001a\u00030í\u0002H\u0016¢\u0006\u0006\bî\u0002\u0010ï\u0002J\u0013\u0010ð\u0002\u001a\u00020\u00122\b\u0010ñ\u0002\u001a\u00030ò\u0002H\u0016J\u0013\u0010ó\u0002\u001a\u00020\u00122\b\u0010ô\u0002\u001a\u00030õ\u0002H\u0016J\u0013\u0010ö\u0002\u001a\u00020\u00122\b\u0010ô\u0002\u001a\u00030õ\u0002H\u0016J\u0013\u0010÷\u0002\u001a\u00030\u0098\u00012\u0007\u0010ø\u0002\u001a\u00020\u0012H\u0016J\u0014\u0010ù\u0002\u001a\u00030\u0098\u00012\b\u0010ú\u0002\u001a\u00030Ê\u0001H\u0016J\u0013\u0010û\u0002\u001a\u00030\u0098\u00012\u0007\u0010ü\u0002\u001a\u00020\\H\u0016J\u0013\u0010ý\u0002\u001a\u00030\u0098\u00012\u0007\u0010ü\u0002\u001a\u00020\\H\u0016J\u0013\u0010þ\u0002\u001a\u00030\u0098\u00012\u0007\u0010ü\u0002\u001a\u00020\\H\u0016J\u0013\u0010ÿ\u0002\u001a\u00030\u0098\u00012\u0007\u0010ü\u0002\u001a\u00020\\H\u0016J\b\u0010\u0080\u0003\u001a\u00030\u0098\u0001J\n\u0010\u0081\u0003\u001a\u00030\u0098\u0001H\u0016J\u001b\u0010\u0082\u0003\u001a\u00030\u0098\u00012\u000f\u0010\u0083\u0003\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010¾\u0002H\u0016JD\u0010\u0084\u0003\u001a\u00020\u00122\b\u0010\u0085\u0003\u001a\u00030\u0086\u00032\b\u0010\u0087\u0003\u001a\u00030\u0088\u00032\u001c\u0010\u0089\u0003\u001a\u0017\u0012\u0005\u0012\u00030\u008a\u0003\u0012\u0005\u0012\u00030\u0098\u00010\u0096\u0001¢\u0006\u0003\b\u008c\u0002H\u0002¢\u0006\u0006\b\u008b\u0003\u0010\u008c\u0003J\u0013\u0010\u008d\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u008e\u0003\u001a\u00020\u0001H\u0002J'\u0010\u008f\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u0090\u0003\u001a\u0002042\b\u0010\u0091\u0003\u001a\u00030\u0092\u00032\b\u0010\u0093\u0003\u001a\u00030\u0094\u0003H\u0002J\u0015\u0010\u0095\u0003\u001a\u00030\u0098\u00012\t\u0010\u0096\u0003\u001a\u0004\u0018\u00010\u0018H\u0016J\u001e\u0010\u0095\u0003\u001a\u00030\u0098\u00012\t\u0010\u0096\u0003\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u0097\u0003\u001a\u000204H\u0016J'\u0010\u0095\u0003\u001a\u00030\u0098\u00012\t\u0010\u0096\u0003\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u0098\u0003\u001a\u0002042\u0007\u0010\u0099\u0003\u001a\u000204H\u0016J!\u0010\u0095\u0003\u001a\u00030\u0098\u00012\t\u0010\u0096\u0003\u001a\u0004\u0018\u00010\u00182\n\u0010\u009a\u0003\u001a\u0005\u0018\u00010\u009b\u0003H\u0016J*\u0010\u0095\u0003\u001a\u00030\u0098\u00012\t\u0010\u0096\u0003\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u0097\u0003\u001a\u0002042\n\u0010\u009a\u0003\u001a\u0005\u0018\u00010\u009b\u0003H\u0016J\u001a\u0010\u009c\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u0017\u001a\u00030\u009d\u00032\u0007\u0010\u009e\u0003\u001a\u00020\\J\u0011\u0010\u009f\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u0017\u001a\u00030\u009d\u0003J\u001b\u0010 \u0003\u001a\u00030\u0098\u00012\u0007\u0010\u0017\u001a\u00030\u009d\u00032\b\u0010¡\u0003\u001a\u00030¢\u0003J\u0017\u0010£\u0003\u001a\u00030\u0098\u00012\u000b\b\u0002\u0010¤\u0003\u001a\u0004\u0018\u00010\\H\u0002J\r\u0010¥\u0003\u001a\u00020\u0012*\u00020\\H\u0002J\u0013\u0010¦\u0003\u001a\u00030\u0098\u00012\u0007\u0010§\u0003\u001a\u00020\u0012H\u0016J&\u0010¦\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u009e\u0003\u001a\u00020\\2\b\u0010¨\u0003\u001a\u00030Å\u0001H\u0016¢\u0006\u0006\b©\u0003\u0010ª\u0003J\n\u0010«\u0003\u001a\u00030\u0098\u0001H\u0002J\u001c\u0010¬\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u009e\u0003\u001a\u00020\\2\u0007\u0010\u00ad\u0003\u001a\u00020\u0012H\u0016J.\u0010®\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u009e\u0003\u001a\u00020\\2\u0007\u0010\u00ad\u0003\u001a\u00020\u00122\u0007\u0010¯\u0003\u001a\u00020\u00122\u0007\u0010£\u0003\u001a\u00020\u0012H\u0016J%\u0010°\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u009e\u0003\u001a\u00020\\2\u0007\u0010\u00ad\u0003\u001a\u00020\u00122\u0007\u0010¯\u0003\u001a\u00020\u0012H\u0016J\u0013\u0010±\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u009e\u0003\u001a\u00020\\H\u0016J\n\u0010²\u0003\u001a\u00030\u0098\u0001H\u0016J\u0015\u0010³\u0003\u001a\u00030\u0098\u00012\t\u0010´\u0003\u001a\u0004\u0018\u00010nH\u0016J\u001c\u0010µ\u0003\u001a\u00030\u0098\u00012\u0007\u0010¶\u0003\u001a\u0002042\u0007\u0010·\u0003\u001a\u000204H\u0014J\u0018\u0010¸\u0003\u001a\u000204*\u00030¹\u0003H\u0082\n¢\u0006\u0006\bº\u0003\u0010»\u0003J\u0018\u0010¼\u0003\u001a\u000204*\u00030¹\u0003H\u0082\n¢\u0006\u0006\b½\u0003\u0010»\u0003J%\u0010¾\u0003\u001a\u00030¹\u00032\u0007\u0010¿\u0003\u001a\u0002042\u0007\u0010À\u0003\u001a\u000204H\u0002¢\u0006\u0006\bÁ\u0003\u0010Â\u0003J\u001c\u0010Ã\u0003\u001a\u00030¹\u00032\u0007\u0010Ä\u0003\u001a\u000204H\u0002¢\u0006\u0006\bÅ\u0003\u0010Æ\u0003J7\u0010Ç\u0003\u001a\u00030\u0098\u00012\u0007\u0010È\u0003\u001a\u00020\u00122\u0007\u0010É\u0003\u001a\u0002042\u0007\u0010Ê\u0003\u001a\u0002042\u0007\u0010Ë\u0003\u001a\u0002042\u0007\u0010À\u0003\u001a\u000204H\u0014J\n\u0010Í\u0003\u001a\u00030\u0098\u0001H\u0002J\u0014\u0010Î\u0003\u001a\u00030\u0098\u00012\b\u0010¡\u0003\u001a\u00030¢\u0003H\u0014Jl\u0010Ï\u0003\u001a\u00030\u008d\u00012C\u0010Ð\u0003\u001a>\u0012\u0017\u0012\u00150Ñ\u0003¢\u0006\u000f\bÒ\u0003\u0012\n\bÓ\u0003\u0012\u0005\b\b(¡\u0003\u0012\u0019\u0012\u0017\u0018\u00010Ô\u0003¢\u0006\u000f\bÒ\u0003\u0012\n\bÓ\u0003\u0012\u0005\b\b(Õ\u0003\u0012\u0005\u0012\u00030\u0098\u00010\u0088\u00022\u000f\u0010Ö\u0003\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010¾\u00022\n\u0010×\u0003\u001a\u0005\u0018\u00010Ô\u0003H\u0016J\u0019\u0010Ø\u0003\u001a\u00020\u00122\b\u0010Ù\u0003\u001a\u00030\u008d\u0001H\u0000¢\u0006\u0003\bÚ\u0003J\n\u0010Û\u0003\u001a\u00030\u0098\u0001H\u0016J\u0013\u0010Ü\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u009e\u0003\u001a\u00020\\H\u0016J\u0013\u0010Ý\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u009e\u0003\u001a\u00020\\H\u0016J\u001c\u0010Þ\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u009e\u0003\u001a\u00020\\2\u0007\u0010ß\u0003\u001a\u000204H\u0016J\u001c\u0010à\u0003\u001a\u00030\u0098\u00012\u0007\u0010\u009e\u0003\u001a\u00020\\2\u0007\u0010ß\u0003\u001a\u000204H\u0016J\u0017\u0010á\u0003\u001a\u00030\u0098\u00012\u000b\u0010\u0017\u001a\u00070\u0018j\u0003`â\u0003H\u0016J\u0014\u0010ã\u0003\u001a\u00030\u0098\u00012\b\u0010\u0083\u0003\u001a\u00030ä\u0003H\u0016J\u0014\u0010å\u0003\u001a\u00030\u0098\u00012\b\u0010¡\u0003\u001a\u00030¢\u0003H\u0014J#\u0010æ\u0003\u001a\u00030\u0098\u00012\b\u0010Ù\u0003\u001a\u00030\u008d\u00012\u0007\u0010ç\u0003\u001a\u00020\u0012H\u0000¢\u0006\u0003\bè\u0003J \u0010é\u0003\u001a\u00030\u0098\u00012\u0016\u0010ê\u0003\u001a\u0011\u0012\u0005\u0012\u00030à\u0001\u0012\u0005\u0012\u00030\u0098\u00010\u0096\u0001J\u0011\u0010ë\u0003\u001a\u00030\u0098\u0001H\u0086@¢\u0006\u0003\u0010ì\u0003J\u0011\u0010í\u0003\u001a\u00030\u0098\u0001H\u0086@¢\u0006\u0003\u0010ì\u0003J\u0013\u0010î\u0003\u001a\u00030\u0098\u00012\u0007\u0010ü\u0002\u001a\u00020\\H\u0002J\u0013\u0010ï\u0003\u001a\u00030\u0098\u00012\u0007\u0010ü\u0002\u001a\u00020\\H\u0002J\n\u0010ð\u0003\u001a\u00030\u0098\u0001H\u0016J\n\u0010ñ\u0003\u001a\u00030\u0098\u0001H\u0014J\n\u0010ò\u0003\u001a\u00030\u0098\u0001H\u0014J\u001f\u0010ó\u0003\u001a\u00030\u0098\u00012\n\u0010Ð\u0002\u001a\u0005\u0018\u00010Ñ\u00022\u0007\u0010ô\u0003\u001a\u000204H\u0016J\u001b\u0010£\u0001\u001a\u00030\u0098\u00012\u000f\u0010õ\u0003\u001a\n\u0012\u0005\u0012\u00030÷\u00030ö\u0003H\u0016J1\u0010ø\u0003\u001a\u00030\u0098\u00012\b\u0010ù\u0003\u001a\u00030ú\u00032\b\u0010û\u0003\u001a\u00030Ò\u00012\u0011\u0010ü\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010ý\u00030Û\u0002H\u0017J\u001d\u0010þ\u0003\u001a\u00030\u0098\u00012\u0011\u0010ÿ\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0081\u00040\u0080\u0004H\u0017J\u0013\u0010\u0082\u0004\u001a\u00020\u00122\b\u0010\u0083\u0004\u001a\u00030¸\u0002H\u0016J\u0013\u0010\u0084\u0004\u001a\u00020\u00122\b\u0010\u0083\u0004\u001a\u00030¸\u0002H\u0016J\u0013\u0010\u0085\u0004\u001a\u00020\u00122\b\u0010ô\u0002\u001a\u00030¸\u0002H\u0002J\u001d\u0010\u0086\u0004\u001a\u00030\u0087\u00042\b\u0010\u0083\u0004\u001a\u00030¸\u0002H\u0002¢\u0006\u0006\b\u0088\u0004\u0010\u0089\u0004J\u001d\u0010\u008a\u0004\u001a\u00020\u00122\b\u0010ô\u0002\u001a\u00030¸\u00022\b\u0010\u008b\u0004\u001a\u00030¸\u0002H\u0002J\u0013\u0010\u008c\u0004\u001a\u00020\u00122\b\u0010ô\u0002\u001a\u00030¸\u0002H\u0002J\u001d\u0010\u008d\u0004\u001a\u00030\u0087\u00042\b\u0010\u0083\u0004\u001a\u00030¸\u0002H\u0002¢\u0006\u0006\b\u008e\u0004\u0010\u0089\u0004J2\u0010\u008f\u0004\u001a\u00030\u0098\u00012\b\u0010\u0083\u0004\u001a\u00030¸\u00022\u0007\u0010\u0090\u0004\u001a\u0002042\b\u0010\u0091\u0004\u001a\u00030Ê\u00012\t\b\u0002\u0010\u0092\u0004\u001a\u00020\u0012H\u0002J\u0011\u0010\u0093\u0004\u001a\u00020\u00122\u0006\u0010O\u001a\u000204H\u0016J\u0011\u0010\u0094\u0004\u001a\u00020\u00122\u0006\u0010O\u001a\u000204H\u0016J\u0013\u0010\u0095\u0004\u001a\u00020\u00122\b\u0010\u0083\u0004\u001a\u00030¸\u0002H\u0002J\u001b\u0010\u0096\u0004\u001a\u00020\u000f2\u0007\u0010\u0097\u0004\u001a\u00020\u000fH\u0016¢\u0006\u0006\b\u0098\u0004\u0010\u0099\u0004J\u001d\u0010\u0096\u0004\u001a\u00030\u0098\u00012\b\u0010\u009a\u0004\u001a\u00030Ô\u0001H\u0016¢\u0006\u0006\b\u009b\u0004\u0010\u009c\u0004J\u001b\u0010\u009d\u0004\u001a\u00020\u000f2\u0007\u0010\u009e\u0004\u001a\u00020\u000fH\u0016¢\u0006\u0006\b\u009f\u0004\u0010\u0099\u0004J\n\u0010 \u0004\u001a\u00030\u0098\u0001H\u0002J\u0014\u0010 \u0004\u001a\u00030\u0098\u00012\b\u0010\u0083\u0004\u001a\u00030¸\u0002H\u0002J\n\u0010¡\u0004\u001a\u00030\u0098\u0001H\u0002J\n\u0010¢\u0004\u001a\u00030\u0098\u0001H\u0002J\t\u0010£\u0004\u001a\u00020\u0012H\u0016J\u0016\u0010¤\u0004\u001a\u0005\u0018\u00010¥\u00042\b\u0010¦\u0004\u001a\u00030§\u0004H\u0016J\u001b\u0010¨\u0004\u001a\u00020\u000f2\u0007\u0010©\u0004\u001a\u00020\u000fH\u0016¢\u0006\u0006\bª\u0004\u0010\u0099\u0004J\u001b\u0010«\u0004\u001a\u00020\u000f2\u0007\u0010\u0097\u0004\u001a\u00020\u000fH\u0016¢\u0006\u0006\b¬\u0004\u0010\u0099\u0004J\u0014\u0010\u00ad\u0004\u001a\u00030\u0098\u00012\b\u0010®\u0004\u001a\u00030\u0097\u0001H\u0014J\u0013\u0010¯\u0004\u001a\u00030\u0098\u00012\u0007\u0010\u009f\u0002\u001a\u000204H\u0016J\t\u0010°\u0004\u001a\u00020\u0012H\u0002J\u0013\u0010±\u0004\u001a\u00020\u00122\b\u0010ô\u0002\u001a\u00030¸\u0002H\u0016J\u0013\u0010²\u0004\u001a\u00020\u00122\b\u0010ô\u0002\u001a\u00030¸\u0002H\u0002J\u0013\u0010³\u0004\u001a\u00020\u00122\b\u0010ô\u0002\u001a\u00030¸\u0002H\u0002J\u001d\u0010´\u0004\u001a\u0004\u0018\u00010\u00182\u0007\u0010µ\u0004\u001a\u0002042\u0007\u0010¶\u0004\u001a\u00020\u0018H\u0002J\u001d\u0010·\u0004\u001a\u00030¸\u00042\b\u0010ô\u0002\u001a\u00030¸\u00022\u0007\u0010¹\u0004\u001a\u000204H\u0017J\u0012\u0010¾\u0004\u001a\u0004\u0018\u00010\u00182\u0007\u0010µ\u0004\u001a\u000204J\t\u0010À\u0004\u001a\u00020\u0012H\u0016J\n\u0010Â\u0004\u001a\u00030\u0098\u0001H\u0016J\n\u0010Ã\u0004\u001a\u00030\u0098\u0001H\u0016J\n\u0010Å\u0004\u001a\u00030\u0098\u0001H\u0016J\n\u0010Æ\u0004\u001a\u00030\u0098\u0001H\u0016J\u001b\u0010Ê\u0004\u001a\u00030\u0098\u00012\u000f\u0010Ë\u0004\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010¾\u0002H\u0016J\u0014\u0010Ì\u0004\u001a\u00030\u0098\u00012\b\u0010Í\u0004\u001a\u00030À\u0002H\u0017J\u001c\u0010Î\u0004\u001a\u00030\u0098\u00012\u0007\u0010Ï\u0004\u001a\u00020\u000fH\u0016¢\u0006\u0006\bÐ\u0004\u0010Ü\u0001R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010$\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R\u0014\u0010/\u001a\u000200X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R$\u0010\n\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020;X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\u00020TX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0011\u0010W\u001a\u00020X¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u001a\u0010[\u001a\u00020\\X\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\\0bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0014\u0010i\u001a\u00020jX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u001c\u0010m\u001a\u0004\u0018\u00010nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u000e\u0010w\u001a\u00020xX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010y\u001a\u00020zX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u0017\u0010\u007f\u001a\u00030\u0080\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0017\u0010\u008b\u0001\u001a\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u008e\u0001\u001a\f\u0012\u0005\u0012\u00030\u008d\u0001\u0018\u00010\u008c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0095\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0097\u0001\u0012\u0005\u0012\u00030\u0098\u00010\u0096\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0012\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001R\u001a\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¥\u0001\u0010¦\u0001R\u001a\u0010§\u0001\u001a\u0005\u0018\u00010¨\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b©\u0001\u0010ª\u0001R\u000f\u0010«\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010¬\u0001\u001a\u00030\u00ad\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001R\u0018\u0010°\u0001\u001a\u00030±\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001R\u0018\u0010´\u0001\u001a\u00030µ\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¶\u0001\u0010·\u0001R'\u0010¸\u0001\u001a\u00020\u00128VX\u0096\u000e¢\u0006\u0018\n\u0000\u0012\u0005\b¹\u0001\u0010^\u001a\u0005\bº\u0001\u0010'\"\u0006\b»\u0001\u0010¼\u0001R\u0012\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010¿\u0001\u001a\u00030¾\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0012\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Æ\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Ç\u0001\u001a\u00030È\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010É\u0001\u001a\u00030Ê\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bË\u0001\u0010Ì\u0001R\u0016\u0010Í\u0001\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010'R\u0012\u0010Ï\u0001\u001a\u00030Ð\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010Ñ\u0001\u001a\u00030Ò\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010Ó\u0001\u001a\u00030Ô\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Õ\u0001R\u0013\u0010Ö\u0001\u001a\u00030Ô\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Õ\u0001R\u0013\u0010×\u0001\u001a\u00030Ô\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Õ\u0001R+\u0010Ø\u0001\u001a\u00030Ê\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0019\n\u0000\u0012\u0005\bÙ\u0001\u0010^\u001a\u0006\bÚ\u0001\u0010Ì\u0001\"\u0006\bÛ\u0001\u0010Ü\u0001R\u000f\u0010Ý\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Þ\u0001\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000f\u0010ß\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010á\u0001\u001a\u0005\u0018\u00010à\u00012\t\u0010\u001b\u001a\u0005\u0018\u00010à\u00018B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0005\bæ\u0001\u0010#\u001a\u0006\bâ\u0001\u0010ã\u0001\"\u0006\bä\u0001\u0010å\u0001R#\u0010ç\u0001\u001a\u0005\u0018\u00010à\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bè\u0001\u0010ã\u0001R \u0010ë\u0001\u001a\u0013\u0012\u0005\u0012\u00030à\u0001\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u00010\u0096\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010ì\u0001\u001a\u00030í\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010î\u0001\u001a\u00030ï\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010ð\u0001\u001a\u00030ñ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010ò\u0001\u001a\u00030ó\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010ô\u0001\u001a\u00030õ\u00018\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\bö\u0001\u0010^\u001a\u0006\b÷\u0001\u0010ø\u0001R\u001a\u0010ù\u0001\u001a\n\u0012\u0005\u0012\u00030û\u00010ú\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010ü\u0001R\u0018\u0010ý\u0001\u001a\u00030þ\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÿ\u0001\u0010\u0080\u0002R\u0018\u0010\u0081\u0002\u001a\u00030\u0082\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002R!\u0010\u008e\u0002\u001a\u00030\u008f\u00028\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u0090\u0002\u0010^\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002R3\u0010\u0094\u0002\u001a\u00030\u0093\u00022\u0007\u0010\u001b\u001a\u00030\u0093\u00028V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\b\u0099\u0002\u0010#\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002\"\u0006\b\u0097\u0002\u0010\u0098\u0002R\u000f\u0010\u009a\u0002\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u009b\u0002\u001a\u000204*\u00030\u0097\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002R3\u0010\u009f\u0002\u001a\u00030\u009e\u00022\u0007\u0010\u001b\u001a\u00030\u009e\u00028V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\b¤\u0002\u0010#\u001a\u0006\b \u0002\u0010¡\u0002\"\u0006\b¢\u0002\u0010£\u0002R\u0018\u0010¥\u0002\u001a\u00030¦\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b§\u0002\u0010¨\u0002R\u0010\u0010©\u0002\u001a\u00030ª\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010«\u0002\u001a\u00030¬\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u00ad\u0002\u0010®\u0002R\u0018\u0010¯\u0002\u001a\u00030°\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b±\u0002\u0010²\u0002R\u0018\u0010³\u0002\u001a\u00030´\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bµ\u0002\u0010¶\u0002R\u0012\u0010·\u0002\u001a\u0005\u0018\u00010¸\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¹\u0002\u001a\u00030Ê\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010º\u0002\u001a\n\u0012\u0005\u0012\u00030\u008d\u00010»\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010¼\u0002\u001a\u0013\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u00010¾\u00020½\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¿\u0002\u001a\u00030À\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Á\u0002\u001a\u00030À\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Â\u0002\u001a\u00030Ã\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Ä\u0002R\u0010\u0010Å\u0002\u001a\u00030Æ\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Ç\u0002\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010È\u0002\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010¾\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010É\u0002\u001a\u00030Ê\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Ë\u0002\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ò\u0002\u001a\u0005\u0018\u00010Ó\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Ô\u0002\u001a\u00020\u00128@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÕ\u0002\u0010'R\u0011\u0010Ì\u0003\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010º\u0004\u001a\u00030»\u0004X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¼\u0004\u0010½\u0004R\u0016\u0010¿\u0004\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¿\u0004\u0010'R\u000f\u0010Á\u0004\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ä\u0004\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010Ç\u0004\u001a\u0004\u0018\u00010\u00008VX\u0096\u0004¢\u0006\b\u001a\u0006\bÈ\u0004\u0010É\u0004¨\u0006Ó\u0004"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/focus/PlatformFocusOwner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/MatrixPositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/compose/ui/node/OutOfFrameExecutor;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", SdkConstants.CONSTRUCTOR_NAME, "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "superclassInitComplete", "", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "<set-?>", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "Landroidx/compose/runtime/MutableState;", "frameRateCategoryView", "isArrEnabled", "isArrEnabled$ui_release", "()Z", "rootSemanticsNode", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "semanticsModifier", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "bringIntoViewNode", "androidx/compose/ui/platform/AndroidComposeView$bringIntoViewNode$1", "Landroidx/compose/ui/platform/AndroidComposeView$bringIntoViewNode$1;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "getImportantForAutofill", "", "value", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/AndroidDragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/AndroidDragAndDropManager;", "_windowInfo", "Landroidx/compose/ui/platform/LazyWindowInfo;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "processingRequestFocusForNextNonChildView", "moveFocusInChildren", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocusInChildren-3ESFkO8", "(I)Z", "getEmbeddedViewFocusRect", "Landroidx/compose/ui/geometry/Rect;", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "findNextNonChildView", "direction", "rotaryInputModifier", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "insetsListener", "Landroidx/compose/ui/layout/InsetsListener;", "getInsetsListener", "()Landroidx/compose/ui/layout/InsetsListener;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot$annotations", "()V", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "layoutNodes", "Landroidx/collection/MutableIntObjectMap;", "getLayoutNodes", "()Landroidx/collection/MutableIntObjectMap;", "rectManager", "Landroidx/compose/ui/spatial/RectManager;", "getRectManager", "()Landroidx/compose/ui/spatial/RectManager;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "uncaughtExceptionHandler", "Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "getUncaughtExceptionHandler$ui_release", "()Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "setUncaughtExceptionHandler$ui_release", "(Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;)V", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "getContentCaptureManager$ui_release", "()Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "setContentCaptureManager$ui_release", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;)V", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "postponedDirtyLayers", "isDrawingContent", "isPendingInteropViewLayoutChangeDispatch", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_autofillManager", "Landroidx/compose/ui/autofill/AndroidAutofillManager;", "get_autofillManager$ui_release", "()Landroidx/compose/ui/autofill/AndroidAutofillManager;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillManager", "Landroidx/compose/ui/autofill/AutofillManager;", "getAutofillManager", "()Landroidx/compose/ui/autofill/AutofillManager;", "observationClearRequested", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "clipboard", "Landroidx/compose/ui/platform/AndroidClipboard;", "getClipboard", "()Landroidx/compose/ui/platform/AndroidClipboard;", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "wasMeasuredWithMultipleConstraints", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "", "getMeasureIteration", "()J", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "tmpPositionArray", "", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "viewToWindowMatrix", "windowToViewMatrix", "lastMatrixRecalculationAnimationTime", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "forceUseMatrixCache", "windowPosition", "isRenderNodeCompatible", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "_viewTreeOwners", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners$delegate", "viewTreeOwners", "getViewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "onViewTreeOwnersAvailable", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService$annotations", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "textInputSession", "", "session", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "currentFontWeightAdjustment", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "endApplyChangesListeners", "Landroidx/collection/MutableObjectList;", "Lkotlin/Function0;", "currentFrameRate", "", "currentFrameRateCategory", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "hoverExitReceived", "resendMotionEventOnLayout", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "keyboardModifiersRequireUpdate", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "dispatchProvideStructure", "structure", "Landroid/view/ViewStructure;", "scrollCapture", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "scrollCaptureInProgress", "getScrollCaptureInProgress$ui_release", "onScrollCaptureSearch", "localVisibleRect", "windowOffset", "Landroid/graphics/Point;", "targets", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "focusSearch", "focused", SdkConstants.REQUEST_FOCUS, "previouslyFocusedRect", "requestOwnerFocus", "requestOwnerFocus-7o62pno", "clearOwnerFocus", "onFocusChanged", "gainFocus", "onWindowFocusChanged", "hasWindowFocus", "sendKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendIndirectTouchEvent", "indirectTouchEvent", "Landroidx/compose/ui/input/indirect/IndirectTouchEvent;", "dispatchKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "dispatchKeyEventPreIme", "forceAccessibilityForTesting", "enable", "setAccessibilityEventBatchIntervalMillis", "intervalMillis", "onPreAttach", "node", "onPostAttach", "onDetach", "requestAutofill", "requestClearInvalidObservations", "onEndApplyChanges", "registerOnEndApplyChangesListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "startDrag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "clearChildInvalidObservations", "viewGroup", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "addView", "child", "index", "width", "height", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "removeAndroidView", "drawAndroidView", "canvas", "Landroid/graphics/Canvas;", "scheduleMeasureAndLayout", "nodeToRemeasure", "childSizeCanAffectParentSize", "measureAndLayout", "sendPointerUpdate", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "dispatchPendingInteropLayoutCallbacks", "forceMeasureTheSubtree", "affectsLookahead", "onRequestMeasure", "forceRequest", "onRequestRelayout", "requestOnPositionedCallback", "measureAndLayoutForTest", "setUncaughtExceptionHandler", "handler", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "component1", "Lkotlin/ULong;", "component1-VKZWuLQ", "(J)I", "component2", "component2-VKZWuLQ", "pack", "a", "b", "pack-ZIaKswc", "(II)J", "convertMeasureSpec", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "onLayout", "changed", "l", "t", SdkConstants.FD_RES_CLASS, "_rootView", "updatePositionCacheAndDispatch", "onDraw", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "invalidateParentLayer", "explicitLayer", "recycle", "layer", "recycle$ui_release", "onSemanticsChange", "onLayoutChange", "onLayoutNodeDeactivated", "onPreLayoutNodeReused", "oldSemanticsId", "onPostLayoutNodeReused", "onInteropViewLayoutChange", "Landroidx/compose/ui/viewinterop/InteropView;", "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "dispatchDraw", "notifyLayerIsDirty", "isDirty", "notifyLayerIsDirty$ui_release", "setOnViewTreeOwnersAvailable", Callback.METHOD_NAME, "boundsUpdatesContentCaptureEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesAccessibilityEventLoop", "invalidateLayoutNodeMeasurement", "invalidateLayers", "invalidateDescendants", "onAttachedToWindow", "onDetachedFromWindow", "onProvideAutofillVirtualStructure", "flags", SdkConstants.FD_RES_VALUES, "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "requestsCollector", "Landroid/view/translation/ViewTranslationRequest;", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "dispatchGenericMotionEvent", "motionEvent", "dispatchTouchEvent", "handleRotaryEvent", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "hasChangedDevices", "lastEvent", "isDevicePressEvent", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "canScrollHorizontally", "canScrollVertically", "isInBounds", "localToScreen", "localPosition", "localToScreen-MK-Hz9U", "(J)J", "localTransform", "localToScreen-58bKbWc", "([F)V", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "recalculateWindowPosition", "recalculateWindowViewTransforms", "updateWindowMetrics", "onCheckIsTextEditor", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "calculatePositionInWindow", "calculatePositionInWindow-MK-Hz9U", "onConfigurationChanged", "newConfig", "onRtlPropertiesChanged", "autofillSupported", "dispatchHoverEvent", "isBadMotionEvent", "isPositionChanged", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "onResolvePointerIcon", "Landroid/view/PointerIcon;", "pointerIndex", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "findViewByAccessibilityIdTraversal", "isLifecycleInResumedState", "shouldDelayChildPressedState", "sensitiveComponentCount", "incrementSensitiveComponentCount", "decrementSensitiveComponentCount", "keepScreenOnCount", "incrementKeepScreenOnCount", "decrementKeepScreenOnCount", "outOfFrameExecutor", "getOutOfFrameExecutor", "()Landroidx/compose/ui/platform/AndroidComposeView;", "schedule", "block", "voteFrameRate", "frameRate", "dispatchOnScrollChanged", "delta", "dispatchOnScrollChanged-k-4lQ0M", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidComposeView extends ViewGroup implements Owner, PlatformFocusOwner, ViewRootForTest, MatrixPositionCalculator, DefaultLifecycleObserver, OutOfFrameExecutor {
    public static final int $stable = 8;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static Method addChangeCallbackMethod;
    private static final MutableObjectList<AndroidComposeView> composeViews;
    private static Method dispatchOnScrollChangedMethod;
    private static Method getBooleanMethod;
    private static Runnable systemPropertiesChangedRunnable;
    private static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final AndroidAutofillManager _autofillManager;
    private final InputModeManagerImpl _inputModeManager;
    private View _rootView;

    /* renamed from: _viewTreeOwners$delegate, reason: from kotlin metadata */
    private final MutableState _viewTreeOwners;
    private final LazyWindowInfo _windowInfo;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final AndroidComposeView$bringIntoViewNode$1 bringIntoViewNode;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboard clipboard;
    private final AndroidClipboardManager clipboardManager;
    private final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private AndroidContentCaptureManager contentCaptureManager;
    private CoroutineContext coroutineContext;
    private int currentFontWeightAdjustment;
    private float currentFrameRate;
    private float currentFrameRateCategory;

    /* renamed from: density$delegate, reason: from kotlin metadata */
    private final MutableState density;
    private final List<OwnedLayer> dirtyLayers;
    private final AndroidDragAndDropManager dragAndDropManager;
    private final MutableObjectList<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;

    /* renamed from: fontFamilyResolver$delegate, reason: from kotlin metadata */
    private final MutableState fontFamilyResolver;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private View frameRateCategoryView;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final GraphicsContext graphicsContext;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private final InsetsListener insetsListener;
    private final boolean isArrEnabled;
    private boolean isDrawingContent;
    private boolean isPendingInteropViewLayoutChangeDispatch;
    private boolean isRenderNodeCompatible;
    private int keepScreenOnCount;
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;

    /* renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;
    private final MutableIntObjectMap<LayoutNode> layoutNodes;
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    private MotionEvent previousMotionEvent;
    private boolean processingRequestFocusForNextNonChildView;
    private final RectManager rectManager;
    private long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final EmptySemanticsModifier rootSemanticsNode;
    private final Modifier rotaryInputModifier;
    private final ScrollCapture scrollCapture;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final EmptySemanticsElement semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private int sensitiveComponentCount;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private final SoftwareKeyboardController softwareKeyboardController;
    private boolean superclassInitComplete;
    private final TextInputService textInputService;
    private final AtomicReference<SessionMutex.Session<T>> textInputSessionMutex;
    private final TextToolbar textToolbar;
    private final float[] tmpMatrix;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private RootForTest.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;

    /* renamed from: viewTreeOwners$delegate, reason: from kotlin metadata */
    private final State viewTreeOwners;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.platform.AndroidComposeView", f = "AndroidComposeView.android.kt", i = {}, l = {WinError.ERROR_WAIT_63}, m = "textInputSession", n = {}, s = {})
    /* renamed from: androidx.compose.ui.platform.AndroidComposeView$textInputSession$1, reason: invalid class name and case insensitive filesystem */
    static final class C07331 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07331(Continuation<? super C07331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidComposeView.this.textInputSession(null, this);
        }
    }

    private final boolean autofillSupported() {
        return true;
    }

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getRoot$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    @Deprecated(message = "Use PlatformTextInputModifierNode instead.")
    public static /* synthetic */ void getTextInputService$annotations() {
    }

    @Override // android.view.View
    public int getImportantForAutofill() {
        return 1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.compose.ui.platform.AndroidComposeView$bringIntoViewNode$1] */
    /* JADX WARN: Type inference failed for: r8v29, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        Modifier.Companion companionApplyWindowInsetsRulers;
        AndroidAutofillManager androidAutofillManager;
        super(context);
        this.lastDownPointerPosition = Offset.INSTANCE.m4309getUnspecifiedF1C5BW0();
        int i = 1;
        this.superclassInitComplete = true;
        this.sharedDrawScope = new LayoutNodeDrawScope(null == true ? 1 : 0, i, null == true ? 1 : 0);
        this.density = SnapshotStateKt.mutableStateOf(AndroidDensity_androidKt.Density(context), SnapshotStateKt.referentialEqualityPolicy());
        boolean z = false;
        boolean z2 = ComposeUiFlags.isAdaptiveRefreshRateEnabled && Build.VERSION.SDK_INT >= 35;
        this.isArrEnabled = z2;
        EmptySemanticsModifier emptySemanticsModifier = new EmptySemanticsModifier();
        this.rootSemanticsNode = emptySemanticsModifier;
        EmptySemanticsElement emptySemanticsElement = new EmptySemanticsElement(emptySemanticsModifier);
        this.semanticsModifier = emptySemanticsElement;
        ?? r8 = new ModifierNodeElement<BringIntoViewOnScreenResponderNode>() { // from class: androidx.compose.ui.platform.AndroidComposeView$bringIntoViewNode$1
            @Override // androidx.compose.ui.node.ModifierNodeElement
            public boolean equals(Object other) {
                return other == this;
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            /* renamed from: create */
            public BringIntoViewOnScreenResponderNode getNode() {
                return new BringIntoViewOnScreenResponderNode(this.this$0);
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void update(BringIntoViewOnScreenResponderNode node) {
                node.setView(this.this$0);
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void inspectableProperties(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("BringIntoViewOnScreen");
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public int hashCode() {
                return this.this$0.hashCode();
            }
        };
        this.bringIntoViewNode = r8;
        AndroidComposeView androidComposeView = this;
        this.focusOwner = new FocusOwnerImpl(this, androidComposeView);
        this.coroutineContext = coroutineContext;
        this.dragAndDropManager = new AndroidDragAndDropManager(new AndroidComposeView$dragAndDropManager$1(this));
        this._windowInfo = new LazyWindowInfo();
        Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(Modifier.INSTANCE, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m6360invokeZmokQxo(keyEvent.m5673unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m6360invokeZmokQxo(android.view.KeyEvent keyEvent) {
                final FocusDirection focusDirectionM4186toFocusDirectionZmokQxo = FocusInteropUtils_androidKt.m4186toFocusDirectionZmokQxo(keyEvent);
                if (focusDirectionM4186toFocusDirectionZmokQxo == null || !KeyEventType.m5677equalsimpl0(KeyEvent_androidKt.m5685getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m5681getKeyDownCS__XNY())) {
                    return false;
                }
                Integer numM4185toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4185toAndroidFocusDirection3ESFkO8(focusDirectionM4186toFocusDirectionZmokQxo.getValue());
                if (ComposeUiFlags.isViewFocusFixEnabled && this.this$0.hasFocus() && numM4185toAndroidFocusDirection3ESFkO8 != null && this.this$0.mo4235moveFocusInChildren3ESFkO8(focusDirectionM4186toFocusDirectionZmokQxo.getValue())) {
                    return true;
                }
                Rect embeddedViewFocusRect = this.this$0.getEmbeddedViewFocusRect();
                Boolean boolMo4192focusSearchULY8qGw = this.this$0.getFocusOwner().mo4192focusSearchULY8qGw(focusDirectionM4186toFocusDirectionZmokQxo.getValue(), embeddedViewFocusRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1$focusWasMovedOrCancelled$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        return Boolean.valueOf(focusTargetNode.mo4205requestFocus3ESFkO8(focusDirectionM4186toFocusDirectionZmokQxo.getValue()));
                    }
                });
                if (boolMo4192focusSearchULY8qGw != null ? boolMo4192focusSearchULY8qGw.booleanValue() : true) {
                    return true;
                }
                if (!FocusOwnerImplKt.m4198is1dFocusSearch3ESFkO8(focusDirectionM4186toFocusDirectionZmokQxo.getValue())) {
                    return false;
                }
                if (numM4185toAndroidFocusDirection3ESFkO8 != null) {
                    View viewFindNextNonChildView = this.this$0.findNextNonChildView(numM4185toAndroidFocusDirection3ESFkO8.intValue());
                    if (Intrinsics.areEqual(viewFindNextNonChildView, this.this$0)) {
                        viewFindNextNonChildView = null;
                    }
                    if (viewFindNextNonChildView != null) {
                        android.graphics.Rect androidRect = embeddedViewFocusRect != null ? RectHelper_androidKt.toAndroidRect(embeddedViewFocusRect) : null;
                        if (androidRect == null) {
                            throw new IllegalStateException("Invalid rect".toString());
                        }
                        View rootView = this.this$0.getRootView();
                        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
                        ViewGroup viewGroup = (ViewGroup) rootView;
                        viewGroup.offsetDescendantRectToMyCoords(this.this$0, androidRect);
                        viewGroup.offsetRectIntoDescendantCoords(viewFindNextNonChildView, androidRect);
                        if (FocusInteropUtils_androidKt.requestInteropFocus(viewFindNextNonChildView, numM4185toAndroidFocusDirection3ESFkO8, androidRect)) {
                            return true;
                        }
                    }
                }
                if (!this.this$0.getFocusOwner().mo4189clearFocusI7lrPNg(false, true, false, focusDirectionM4186toFocusDirectionZmokQxo.getValue())) {
                    return true;
                }
                Boolean boolMo4192focusSearchULY8qGw2 = this.this$0.getFocusOwner().mo4192focusSearchULY8qGw(focusDirectionM4186toFocusDirectionZmokQxo.getValue(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        return Boolean.valueOf(focusTargetNode.mo4205requestFocus3ESFkO8(focusDirectionM4186toFocusDirectionZmokQxo.getValue()));
                    }
                });
                return Boolean.valueOf(boolMo4192focusSearchULY8qGw2 != null ? boolMo4192focusSearchULY8qGw2.booleanValue() : true);
            }
        });
        this.keyInputModifier = modifierOnKeyEvent;
        Modifier modifierOnRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(Modifier.INSTANCE, new Function1<RotaryScrollEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RotaryScrollEvent rotaryScrollEvent) {
                return false;
            }
        });
        this.rotaryInputModifier = modifierOnRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        this.viewConfiguration = new AndroidViewConfiguration(android.view.ViewConfiguration.get(context));
        InsetsListener insetsListener = new InsetsListener(this);
        this.insetsListener = insetsListener;
        LayoutNode layoutNode = new LayoutNode(z, null == true ? 1 : 0, 3, null == true ? 1 : 0);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setViewConfiguration(getViewConfiguration());
        if (ComposeUiFlags.areWindowInsetsRulersEnabled) {
            companionApplyWindowInsetsRulers = WindowInsetsRulers_androidKt.applyWindowInsetsRulers(Modifier.INSTANCE, insetsListener);
        } else {
            companionApplyWindowInsetsRulers = Modifier.INSTANCE;
        }
        layoutNode.setModifier(companionApplyWindowInsetsRulers.then(emptySemanticsElement).then(modifierOnRotaryScrollEvent).then(modifierOnKeyEvent).then(getFocusOwner().getModifier()).then(getDragAndDropManager().getModifier()).then((Modifier) r8));
        this.root = layoutNode;
        this.layoutNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.rectManager = new RectManager(getLayoutNodes());
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot(), emptySemanticsModifier, getLayoutNodes());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.contentCaptureManager = new AndroidContentCaptureManager(this, new AndroidComposeView$contentCaptureManager$1(this));
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.graphicsContext = AndroidGraphicsContext_androidKt.GraphicsContext(this);
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Configuration configuration) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                invoke2(configuration);
                return Unit.INSTANCE;
            }
        };
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        if (autofillSupported()) {
            AutofillManager autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                androidAutofillManager = new AndroidAutofillManager(new PlatformAutofillManagerImpl(autofillManager), getSemanticsOwner(), this, getRectManager(), context.getPackageName());
            } else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Autofill service could not be located.");
                throw new KotlinNothingValueException();
            }
        } else {
            androidAutofillManager = null;
        }
        this._autofillManager = androidAutofillManager;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.clipboard = new AndroidClipboard(getClipboardManager());
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        long j = Integer.MAX_VALUE;
        this.globalPosition = IntOffset.m7377constructorimpl((j & 4294967295L) | (j << 32));
        this.tmpPositionArray = new int[]{0, 0};
        float[] fArrM4780constructorimpl$default = Matrix.m4780constructorimpl$default(null, 1, null);
        this.tmpMatrix = fArrM4780constructorimpl$default;
        this.viewToWindowMatrix = Matrix.m4780constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m4780constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = Offset.INSTANCE.m4308getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this._viewTreeOwners = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.viewTreeOwners = SnapshotStateKt.derivedStateOf(new Function0<ViewTreeOwners>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidComposeView.ViewTreeOwners invoke() {
                return this.this$0.get_viewTreeOwners();
            }
        });
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.updatePositionCacheAndDispatch();
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f$0.updatePositionCacheAndDispatch();
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z3) {
                AndroidComposeView.touchModeChangeListener$lambda$8(this.f$0, z3);
            }
        };
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        this.legacyTextInputServiceAndroid = textInputServiceAndroid;
        this.textInputService = new TextInputService(AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(textInputServiceAndroid));
        this.textInputSessionMutex = SessionMutex.m4031constructorimpl();
        this.softwareKeyboardController = new DelegatingSoftwareKeyboardController(getTextInputService());
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(context.getResources().getConfiguration());
        LayoutDirection layoutDirection = FocusInteropUtils_androidKt.toLayoutDirection(context.getResources().getConfiguration().getLayoutDirection());
        this.layoutDirection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(layoutDirection == null ? LayoutDirection.Ltr : layoutDirection, null, 2, null);
        AndroidComposeView androidComposeView2 = this;
        this.hapticFeedBack = new PlatformHapticFeedback(androidComposeView2);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.INSTANCE.m5354getTouchaOaMEAU() : InputMode.INSTANCE.m5353getKeyboardaOaMEAU(), new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(InputMode inputMode) {
                return m6358invokeiuPiT84(inputMode.getValue());
            }

            /* renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m6358invokeiuPiT84(int i2) {
                boolean zRequestFocusFromTouch;
                if (InputMode.m5349equalsimpl0(i2, InputMode.INSTANCE.m5354getTouchaOaMEAU())) {
                    zRequestFocusFromTouch = this.this$0.isInTouchMode();
                } else {
                    zRequestFocusFromTouch = InputMode.m5349equalsimpl0(i2, InputMode.INSTANCE.m5353getKeyboardaOaMEAU()) ? this.this$0.isInTouchMode() ? this.this$0.requestFocusFromTouch() : true : false;
                }
                return Boolean.valueOf(zRequestFocusFromTouch);
            }
        }, null == true ? 1 : 0);
        this.modifierLocalManager = new ModifierLocalManager(androidComposeView);
        this.textToolbar = new AndroidTextToolbar(androidComposeView2);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableObjectList<>(null == true ? 1 : 0, i, null == true ? 1 : 0);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                this.this$0.removeCallbacks(this);
                MotionEvent motionEvent = this.this$0.previousMotionEvent;
                if (motionEvent != null) {
                    boolean z3 = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z3) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    int i2 = 7;
                    if (actionMasked != 7 && actionMasked != 9) {
                        i2 = 2;
                    }
                    AndroidComposeView androidComposeView3 = this.this$0;
                    androidComposeView3.sendSimulatedEvent(motionEvent, i2, androidComposeView3.relayoutTime, false);
                }
            }
        };
        this.sendHoverExitEvent = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.sendHoverExitEvent$lambda$10(this.f$0);
            }
        };
        this.resendMotionEventOnLayout = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
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
                MotionEvent motionEvent = this.this$0.previousMotionEvent;
                if (motionEvent != null) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 7 || actionMasked == 9) {
                        this.this$0.relayoutTime = SystemClock.uptimeMillis();
                        AndroidComposeView androidComposeView3 = this.this$0;
                        androidComposeView3.post(androidComposeView3.resendMotionEventRunnable);
                    }
                }
            }
        };
        this.matrixToWindow = Build.VERSION.SDK_INT < 29 ? new CalculateMatrixToWindowApi21(fArrM4780constructorimpl$default, null == true ? 1 : 0) : new CalculateMatrixToWindowApi29();
        addOnAttachStateChangeListener(this.contentCaptureManager);
        setWillNotDraw(false);
        setFocusable(true);
        AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(androidComposeView2, 1, false);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(androidComposeView2, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.INSTANCE.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        setOnDragListener(getDragAndDropManager());
        getRoot().attach$ui_release(androidComposeView);
        if (Build.VERSION.SDK_INT >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(androidComposeView2);
        }
        if (z2) {
            View view = new View(context);
            view.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
            view.setTag(R.id.hide_in_inspector_tag, true);
            this.frameRateCategoryView = view;
            addView(view);
        }
        this.scrollCapture = Build.VERSION.SDK_INT >= 31 ? new ScrollCapture() : null;
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            private PointerIcon currentMouseCursorIcon = PointerIcon.INSTANCE.getDefault();
            private PointerIcon currentStylusHoverIcon;

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            /* renamed from: getIcon, reason: from getter */
            public PointerIcon getCurrentMouseCursorIcon() {
                return this.currentMouseCursorIcon;
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void setIcon(PointerIcon value) {
                if (value == null) {
                    value = PointerIcon.INSTANCE.getDefault();
                }
                this.currentMouseCursorIcon = value;
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(this.this$0, this.currentMouseCursorIcon);
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            /* renamed from: getStylusHoverIcon, reason: from getter */
            public PointerIcon getCurrentStylusHoverIcon() {
                return this.currentStylusHoverIcon;
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void setStylusHoverIcon(PointerIcon value) {
                this.currentStylusHoverIcon = value;
            }
        };
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public View getView() {
        return this;
    }

    private void setDensity(Density density) {
        this.density.setValue(density);
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public Density getDensity() {
        return (Density) this.density.getValue();
    }

    /* renamed from: isArrEnabled$ui_release, reason: from getter */
    public final boolean getIsArrEnabled() {
        return this.isArrEnabled;
    }

    @Override // androidx.compose.ui.node.Owner
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // androidx.compose.ui.node.Owner
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public void setCoroutineContext(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
        DelegatableNode head = getRoot().getNodes().getHead();
        if (head instanceof SuspendingPointerInputModifierNode) {
            ((SuspendingPointerInputModifierNode) head).resetPointerInputHandler();
        }
        DelegatableNode delegatableNode = head;
        int iM6248constructorimpl = NodeKind.m6248constructorimpl(16);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & iM6248constructorimpl) != 0) {
                for (Modifier.Node child2 = node; child2 != null; child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM6248constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof PointerInputModifierNode) {
                                PointerInputModifierNode pointerInputModifierNode = (PointerInputModifierNode) delegatingNodePop;
                                if (pointerInputModifierNode instanceof SuspendingPointerInputModifierNode) {
                                    ((SuspendingPointerInputModifierNode) pointerInputModifierNode).resetPointerInputHandler();
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM6248constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate$ui_release != null) {
                                    if ((delegate$ui_release.getKindSet() & iM6248constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate$ui_release;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNodePop != 0) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegatingNodePop);
                                                }
                                                delegatingNodePop = 0;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                    delegate$ui_release = delegate$ui_release.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidDragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    @Override // androidx.compose.ui.focus.PlatformFocusOwner
    /* renamed from: moveFocusInChildren-3ESFkO8 */
    public boolean mo4235moveFocusInChildren3ESFkO8(int focusDirection) {
        AndroidViewsHandler androidViewsHandler;
        View viewFindNextFocusFromRect;
        if (!ComposeUiFlags.isViewFocusFixEnabled) {
            if (FocusDirection.m4173equalsimpl0(focusDirection, FocusDirection.INSTANCE.m4178getEnterdhqQ8s()) || FocusDirection.m4173equalsimpl0(focusDirection, FocusDirection.INSTANCE.m4179getExitdhqQ8s())) {
                return false;
            }
            Integer numM4185toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4185toAndroidFocusDirection3ESFkO8(focusDirection);
            if (numM4185toAndroidFocusDirection3ESFkO8 == null) {
                throw new IllegalStateException("Invalid focus direction".toString());
            }
            int iIntValue = numM4185toAndroidFocusDirection3ESFkO8.intValue();
            Rect embeddedViewFocusRect = getEmbeddedViewFocusRect();
            androidRect = embeddedViewFocusRect != null ? RectHelper_androidKt.toAndroidRect(embeddedViewFocusRect) : null;
            FocusFinderCompat companion = FocusFinderCompat.INSTANCE.getInstance();
            if (androidRect == null) {
                viewFindNextFocusFromRect = companion.findNextFocus(this, findFocus(), iIntValue);
            } else {
                viewFindNextFocusFromRect = companion.findNextFocusFromRect(this, androidRect, iIntValue);
            }
            if (viewFindNextFocusFromRect != null) {
                return FocusInteropUtils_androidKt.requestInteropFocus(viewFindNextFocusFromRect, Integer.valueOf(iIntValue), androidRect);
            }
            return false;
        }
        if (FocusDirection.m4173equalsimpl0(focusDirection, FocusDirection.INSTANCE.m4178getEnterdhqQ8s()) || FocusDirection.m4173equalsimpl0(focusDirection, FocusDirection.INSTANCE.m4179getExitdhqQ8s()) || !hasFocus() || (androidViewsHandler = this._androidViewsHandler) == null) {
            return false;
        }
        Integer numM4185toAndroidFocusDirection3ESFkO82 = FocusInteropUtils_androidKt.m4185toAndroidFocusDirection3ESFkO8(focusDirection);
        if (numM4185toAndroidFocusDirection3ESFkO82 == null) {
            throw new IllegalStateException("Invalid focus direction".toString());
        }
        int iIntValue2 = numM4185toAndroidFocusDirection3ESFkO82.intValue();
        View rootView = getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) rootView;
        View viewFindFocus = viewGroup.findFocus();
        if (viewFindFocus == null) {
            throw new IllegalStateException("view hasFocus but root can't find it".toString());
        }
        View viewFindNextFocus = FocusFinderCompat.INSTANCE.getInstance().findNextFocus(viewGroup, viewFindFocus, iIntValue2);
        if (!FocusOwnerImplKt.m4198is1dFocusSearch3ESFkO8(focusDirection) || !androidViewsHandler.hasFocus()) {
            Rect embeddedViewFocusRect2 = getEmbeddedViewFocusRect();
            androidRect = embeddedViewFocusRect2 != null ? RectHelper_androidKt.toAndroidRect(embeddedViewFocusRect2) : null;
            if (viewFindNextFocus != null && androidRect != null) {
                viewGroup.offsetDescendantRectToMyCoords(this, androidRect);
                viewGroup.offsetRectIntoDescendantCoords(viewFindNextFocus, androidRect);
            }
        }
        if (viewFindNextFocus == null || viewFindNextFocus == viewFindFocus) {
            return false;
        }
        View focusedChild = androidViewsHandler.getFocusedChild();
        ViewParent parent = viewFindNextFocus.getParent();
        while (parent != null && parent != focusedChild) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return false;
        }
        return FocusInteropUtils_androidKt.requestInteropFocus(viewFindNextFocus, Integer.valueOf(iIntValue2), androidRect);
    }

    @Override // androidx.compose.ui.focus.PlatformFocusOwner
    public Rect getEmbeddedViewFocusRect() {
        if (isFocused()) {
            return getFocusOwner().getFocusRect();
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus != null) {
            return FocusInteropUtils_androidKt.calculateBoundingRectRelativeTo(viewFindFocus, this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View findNextNonChildView(int direction) {
        AndroidComposeView androidComposeView = this;
        FocusFinderCompat companion = FocusFinderCompat.INSTANCE.getInstance();
        View viewFindNextFocus = androidComposeView;
        while (viewFindNextFocus != null) {
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            viewFindNextFocus = companion.findNextFocus((ViewGroup) rootView, viewFindNextFocus, direction);
            if (viewFindNextFocus != null && !AndroidComposeView_androidKt.containsDescendant(androidComposeView, viewFindNextFocus)) {
                return viewFindNextFocus;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.node.Owner
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public final InsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNode getRoot() {
        return this.root;
    }

    @Override // androidx.compose.ui.node.Owner
    public MutableIntObjectMap<LayoutNode> getLayoutNodes() {
        return this.layoutNodes;
    }

    @Override // androidx.compose.ui.node.Owner
    public RectManager getRectManager() {
        return this.rectManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    /* renamed from: getUncaughtExceptionHandler$ui_release, reason: from getter */
    public final RootForTest.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.uncaughtExceptionHandler;
    }

    public final void setUncaughtExceptionHandler$ui_release(RootForTest.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    /* renamed from: getContentCaptureManager$ui_release, reason: from getter */
    public final AndroidContentCaptureManager getContentCaptureManager() {
        return this.contentCaptureManager;
    }

    public final void setContentCaptureManager$ui_release(AndroidContentCaptureManager androidContentCaptureManager) {
        this.contentCaptureManager = androidContentCaptureManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    @Override // androidx.compose.ui.node.Owner
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        this.configurationChangeObserver = function1;
    }

    /* renamed from: get_autofillManager$ui_release, reason: from getter */
    public final AndroidAutofillManager get_autofillManager() {
        return this._autofillManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.ui.node.Owner
    public androidx.compose.ui.autofill.AutofillManager getAutofillManager() {
        return this._autofillManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboard getClipboard() {
        return this.clipboard;
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.ui.node.Owner
    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    @Override // androidx.compose.ui.node.Owner
    public boolean getShowLayoutBounds() {
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.INSTANCE.isShowingLayoutBounds(this) : this.showLayoutBounds;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
            requestLayout();
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Override // androidx.compose.ui.node.Owner
    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    /* renamed from: getLastMatrixRecalculationAnimationTime$ui_release, reason: from getter */
    public final long getLastMatrixRecalculationAnimationTime() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ViewTreeOwners get_viewTreeOwners() {
        return (ViewTreeOwners) this._viewTreeOwners.getValue();
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this._viewTreeOwners.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchModeChangeListener$lambda$8(AndroidComposeView androidComposeView, boolean z) {
        androidComposeView._inputModeManager.m5357setInputModeiuPiT84(z ? InputMode.INSTANCE.m5354getTouchaOaMEAU() : InputMode.INSTANCE.m5353getKeyboardaOaMEAU());
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.ui.node.Owner
    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    @Override // androidx.compose.ui.node.Owner
    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.ui.node.Owner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object textInputSession(kotlin.jvm.functions.Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super kotlin.coroutines.Continuation<?>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.platform.AndroidComposeView.C07331
            if (r0 == 0) goto L14
            r0 = r6
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = (androidx.compose.ui.platform.AndroidComposeView.C07331) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 == r3) goto L2e
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2e:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.concurrent.atomic.AtomicReference<androidx.compose.ui.SessionMutex$Session<T>> r6 = r4.textInputSessionMutex
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$2 r2 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$2
            r2.<init>()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0.label = r3
            java.lang.Object r5 = androidx.compose.ui.SessionMutex.m4038withSessionCancellingPreviousimpl(r6, r2, r5, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.textInputSession(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.node.Owner
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver.setValue(resolver);
    }

    @Override // androidx.compose.ui.node.Owner
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver.getValue();
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection.setValue(layoutDirection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.Owner
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // androidx.compose.ui.node.Owner
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendHoverExitEvent$lambda$10(AndroidComposeView androidComposeView) {
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() != 10) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        }
        androidComposeView.m6355sendMotionEvent8iAsVTc(motionEvent);
    }

    @Override // android.view.View
    public void getFocusedRect(android.graphics.Rect rect) {
        Rect embeddedViewFocusRect = getEmbeddedViewFocusRect();
        if (embeddedViewFocusRect != null) {
            rect.left = Math.round(embeddedViewFocusRect.getLeft());
            rect.top = Math.round(embeddedViewFocusRect.getTop());
            rect.right = Math.round(embeddedViewFocusRect.getRight());
            rect.bottom = Math.round(embeddedViewFocusRect.getBottom());
            return;
        }
        if (!Intrinsics.areEqual((Object) getFocusOwner().mo4192focusSearchULY8qGw(FocusDirection.INSTANCE.m4177getDowndhqQ8s(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.getFocusedRect.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return true;
            }
        }), (Object) true)) {
            rect.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        } else {
            super.getFocusedRect(rect);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideStructure(ViewStructure structure) {
        if (Build.VERSION.SDK_INT < 28) {
            AndroidComposeViewAssistHelperMethodsO.INSTANCE.setClassName(structure, getView());
        } else {
            super.dispatchProvideStructure(structure);
        }
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return false;
        }
        return scrollCapture.getScrollCaptureInProgress();
    }

    @Override // android.view.View
    public void onScrollCaptureSearch(android.graphics.Rect localVisibleRect, Point windowOffset, Consumer<ScrollCaptureTarget> targets) {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return;
        }
        scrollCapture.onScrollCaptureSearch(this, getSemanticsOwner(), getCoroutineContext(), targets);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        if (Build.VERSION.SDK_INT < 30) {
            setShowLayoutBounds(INSTANCE.getIsShowingLayoutBounds());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View focused, int direction) {
        Rect rectCalculateBoundingRectRelativeTo;
        if (focused == null || this.measureAndLayoutDelegate.getDuringMeasureLayout()) {
            return super.focusSearch(focused, direction);
        }
        View viewFindNextFocus = FocusFinderCompat.INSTANCE.getInstance().findNextFocus(this, focused, direction);
        if (focused != this || (rectCalculateBoundingRectRelativeTo = getFocusOwner().getFocusRect()) == null) {
            rectCalculateBoundingRectRelativeTo = FocusInteropUtils_androidKt.calculateBoundingRectRelativeTo(focused, this);
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
        int value = focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m4177getDowndhqQ8s();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (getFocusOwner().mo4192focusSearchULY8qGw(value, rectCalculateBoundingRectRelativeTo, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$focusSearch$searchResult$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.element = focusTargetNode;
                return true;
            }
        }) == null) {
            return focused;
        }
        if (objectRef.element == 0) {
            if (viewFindNextFocus == null) {
                return focused;
            }
        } else {
            if (viewFindNextFocus == null) {
                return this;
            }
            if (FocusOwnerImplKt.m4198is1dFocusSearch3ESFkO8(value)) {
                return super.focusSearch(focused, direction);
            }
            AndroidComposeView androidComposeView = this;
            if (TwoDimensionalFocusSearchKt.m4242isBetterCandidateI7lrPNg(FocusTraversalKt.focusRect((FocusTargetNode) objectRef.element), FocusInteropUtils_androidKt.calculateBoundingRectRelativeTo(viewFindNextFocus, androidComposeView), rectCalculateBoundingRectRelativeTo, value)) {
                return androidComposeView;
            }
        }
        return viewFindNextFocus;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, android.graphics.Rect previouslyFocusedRect) {
        View viewFindNextNonChildView;
        if (!ComposeUiFlags.isViewFocusFixEnabled) {
            if (isFocused()) {
                return true;
            }
            if (getFocusOwner().getRootState().getHasFocus()) {
                return super.requestFocus(direction, previouslyFocusedRect);
            }
            FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
            final int value = focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m4178getEnterdhqQ8s();
            return Intrinsics.areEqual((Object) getFocusOwner().mo4192focusSearchULY8qGw(value, previouslyFocusedRect != null ? RectHelper_androidKt.toComposeRect(previouslyFocusedRect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.requestFocus.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetNode focusTargetNode) {
                    return Boolean.valueOf(focusTargetNode.mo4205requestFocus3ESFkO8(value));
                }
            }), (Object) true);
        }
        if (isFocused()) {
            return true;
        }
        if (this.processingRequestFocusForNextNonChildView) {
            return false;
        }
        FocusDirection focusDirection2 = FocusInteropUtils_androidKt.toFocusDirection(direction);
        final int value2 = focusDirection2 != null ? focusDirection2.getValue() : FocusDirection.INSTANCE.m4178getEnterdhqQ8s();
        if (hasFocus() && mo4235moveFocusInChildren3ESFkO8(value2)) {
            return true;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Boolean boolMo4192focusSearchULY8qGw = getFocusOwner().mo4192focusSearchULY8qGw(value2, previouslyFocusedRect != null ? RectHelper_androidKt.toComposeRect(previouslyFocusedRect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocus$focusSearchResult$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                booleanRef.element = true;
                return Boolean.valueOf(focusTargetNode.mo4205requestFocus3ESFkO8(value2));
            }
        });
        if (boolMo4192focusSearchULY8qGw == null) {
            return false;
        }
        if (boolMo4192focusSearchULY8qGw.booleanValue()) {
            return true;
        }
        if (booleanRef.element) {
            return false;
        }
        if ((previouslyFocusedRect != null && !hasFocus() && Intrinsics.areEqual((Object) getFocusOwner().mo4192focusSearchULY8qGw(value2, null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocus$altFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo4205requestFocus3ESFkO8(value2));
            }
        }), (Object) true)) || (viewFindNextNonChildView = findNextNonChildView(direction)) == null || viewFindNextNonChildView == this) {
            return true;
        }
        this.processingRequestFocusForNextNonChildView = true;
        boolean zRequestFocus = viewFindNextNonChildView.requestFocus(direction);
        this.processingRequestFocusForNextNonChildView = false;
        return zRequestFocus;
    }

    @Override // androidx.compose.ui.focus.PlatformFocusOwner
    /* renamed from: requestOwnerFocus-7o62pno */
    public boolean mo4236requestOwnerFocus7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        Integer numM4185toAndroidFocusDirection3ESFkO8;
        if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus((focusDirection == null || (numM4185toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4185toAndroidFocusDirection3ESFkO8(focusDirection.getValue())) == null) ? 130 : numM4185toAndroidFocusDirection3ESFkO8.intValue(), previouslyFocusedRect != null ? RectHelper_androidKt.toAndroidRect(previouslyFocusedRect) : null);
    }

    @Override // androidx.compose.ui.focus.PlatformFocusOwner
    public void clearOwnerFocus() {
        if (isFocused() || (!ComposeUiFlags.isViewFocusFixEnabled && hasFocus())) {
            super.clearFocus();
        } else if (hasFocus()) {
            View viewFindFocus = findFocus();
            if (viewFindFocus != null) {
                viewFindFocus.clearFocus();
            }
            super.clearFocus();
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (gainFocus || hasFocus()) {
            return;
        }
        getFocusOwner().releaseFocus();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        boolean isShowingLayoutBounds;
        this._windowInfo.setWindowFocused(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        if (!hasWindowFocus || Build.VERSION.SDK_INT >= 30 || getShowLayoutBounds() == (isShowingLayoutBounds = INSTANCE.getIsShowingLayoutBounds())) {
            return;
        }
        setShowLayoutBounds(isShowingLayoutBounds);
        invalidateDescendants();
    }

    @Override // androidx.compose.ui.node.RootForTest
    /* renamed from: sendKeyEvent-ZmokQxo */
    public boolean mo6312sendKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        return getFocusOwner().mo4190dispatchInterceptedSoftKeyboardEventZmokQxo(keyEvent) || FocusOwner.m4188dispatchKeyEventYhN2O0w$default(getFocusOwner(), keyEvent, null, 2, null);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public boolean sendIndirectTouchEvent(IndirectTouchEvent indirectTouchEvent) {
        return FocusOwner.dispatchIndirectTouchEvent$default(getFocusOwner(), indirectTouchEvent, null, 2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(final android.view.KeyEvent event) {
        if (isFocused()) {
            this._windowInfo.m6412setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5891constructorimpl(event.getMetaState()));
            return FocusOwner.m4188dispatchKeyEventYhN2O0w$default(getFocusOwner(), KeyEvent.m5668constructorimpl(event), null, 2, null) || super.dispatchKeyEvent(event);
        }
        return getFocusOwner().mo4191dispatchKeyEventYhN2O0w(KeyEvent.m5668constructorimpl(event), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.dispatchKeyEvent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(AndroidComposeView.super.dispatchKeyEvent(event));
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(android.view.KeyEvent event) {
        return (isFocused() && getFocusOwner().mo4190dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent.m5668constructorimpl(event))) || super.dispatchKeyEventPreIme(event);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void forceAccessibilityForTesting(boolean enable) {
        this.composeAccessibilityDelegate.setAccessibilityForceEnabledForTesting$ui_release(enable);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void setAccessibilityEventBatchIntervalMillis(long intervalMillis) {
        this.composeAccessibilityDelegate.setSendRecurringAccessibilityEventsIntervalMillis$ui_release(intervalMillis);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPreAttach(LayoutNode node) {
        getLayoutNodes().set(node.getSemanticsId(), node);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPostAttach(LayoutNode node) {
        AndroidAutofillManager androidAutofillManager;
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.onPostAttach$ui_release(node);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onDetach(LayoutNode node) {
        AndroidAutofillManager androidAutofillManager;
        getLayoutNodes().remove(node.getSemanticsId());
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
        if (ComposeUiFlags.isRectTrackingEnabled) {
            getRectManager().remove(node);
        }
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.onDetach$ui_release(node);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void requestAutofill(LayoutNode node) {
        AndroidAutofillManager androidAutofillManager;
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.requestAutofill$ui_release(node);
        }
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onEndApplyChanges() {
        AndroidAutofillManager androidAutofillManager;
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.onEndApplyChanges$ui_release();
        }
        while (this.endApplyChangesListeners.isNotEmpty() && this.endApplyChangesListeners.get(0) != null) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i = 0; i < size; i++) {
                Function0<Unit> function0 = this.endApplyChangesListeners.get(i);
                this.endApplyChangesListeners.set(i, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        if (this.endApplyChangesListeners.contains(listener)) {
            return;
        }
        this.endApplyChangesListeners.add(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startDrag-12SF9DM, reason: not valid java name */
    public final boolean m6356startDrag12SF9DM(DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        Resources resources = getContext().getResources();
        return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop(this, transferData, new ComposeDragShadowBuilder(DensityKt.Density(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), decorationSize, drawDragDecoration, null));
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey) {
        int orDefault;
        if (Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal())) {
            int orDefault2 = this.composeAccessibilityDelegate.getIdToBeforeMap().getOrDefault(virtualViewId, -1);
            if (orDefault2 != -1) {
                info.getExtras().putInt(extraDataKey, orDefault2);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal()) || (orDefault = this.composeAccessibilityDelegate.getIdToAfterMap().getOrDefault(virtualViewId, -1)) == -1) {
            return;
        }
        info.getExtras().putInt(extraDataKey, orDefault);
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        addView(child, -1);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        Intrinsics.checkNotNull(child);
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addView(child, index, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        ViewGroup.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.width = width;
        layoutParamsGenerateDefaultLayoutParams.height = height;
        Unit unit = Unit.INSTANCE;
        addView(child, -1, layoutParamsGenerateDefaultLayoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        addView(child, -1, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addViewInLayout(child, index, params, true);
    }

    public final void addAndroidView(AndroidViewHolder view, final LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        AndroidViewHolder androidViewHolder = view;
        getAndroidViewsHandler$ui_release().addView(androidViewHolder);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        view.setImportantForAccessibility(1);
        ViewCompat.setAccessibilityDelegate(androidViewHolder, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView.addAndroidView.1
            /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onInitializeAccessibilityNodeInfo(android.view.View r5, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r6) {
                /*
                    r4 = this;
                    super.onInitializeAccessibilityNodeInfo(r5, r6)
                    androidx.compose.ui.platform.AndroidComposeView r5 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r5 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r5)
                    boolean r5 = r5.isEnabled$ui_release()
                    if (r5 == 0) goto L13
                    r5 = 0
                    r6.setVisibleToUser(r5)
                L13:
                    androidx.compose.ui.node.LayoutNode r5 = r2
                    androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
                L19:
                    r0 = 0
                    if (r5 == 0) goto L32
                    androidx.compose.ui.node.NodeChain r1 = r5.getNodes()
                    r2 = 8
                    int r2 = androidx.compose.ui.node.NodeKind.m6248constructorimpl(r2)
                    boolean r1 = r1.m6209hasH91voCI$ui_release(r2)
                    if (r1 == 0) goto L2d
                    goto L33
                L2d:
                    androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
                    goto L19
                L32:
                    r5 = r0
                L33:
                    if (r5 == 0) goto L3d
                    int r5 = r5.getSemanticsId()
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
                L3d:
                    r5 = -1
                    if (r0 == 0) goto L54
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.semantics.SemanticsOwner r1 = r1.getSemanticsOwner()
                    androidx.compose.ui.semantics.SemanticsNode r1 = r1.getUnmergedRootSemanticsNode()
                    int r1 = r1.getId()
                    int r2 = r0.intValue()
                    if (r2 != r1) goto L58
                L54:
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
                L58:
                    androidx.compose.ui.platform.AndroidComposeView r1 = r3
                    android.view.View r1 = (android.view.View) r1
                    int r0 = r0.intValue()
                    r6.setParent(r1, r0)
                    androidx.compose.ui.node.LayoutNode r0 = r2
                    int r0 = r0.getSemanticsId()
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r1 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r1)
                    androidx.collection.MutableIntIntMap r1 = r1.getIdToBeforeMap()
                    int r1 = r1.getOrDefault(r0, r5)
                    if (r1 == r5) goto La3
                    androidx.compose.ui.platform.AndroidComposeView r2 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidViewsHandler r2 = r2.getAndroidViewsHandler$ui_release()
                    android.view.View r2 = androidx.compose.ui.platform.SemanticsUtils_androidKt.semanticsIdToView(r2, r1)
                    if (r2 == 0) goto L89
                    r6.setTraversalBefore(r2)
                    goto L90
                L89:
                    androidx.compose.ui.platform.AndroidComposeView r2 = r3
                    android.view.View r2 = (android.view.View) r2
                    r6.setTraversalBefore(r2, r1)
                L90:
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    android.view.accessibility.AccessibilityNodeInfo r2 = r6.unwrap()
                    androidx.compose.ui.platform.AndroidComposeView r3 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r3 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r3)
                    java.lang.String r3 = r3.getExtraDataTestTraversalBeforeVal()
                    androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r1, r0, r2, r3)
                La3:
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r1 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r1)
                    androidx.collection.MutableIntIntMap r1 = r1.getIdToAfterMap()
                    int r1 = r1.getOrDefault(r0, r5)
                    if (r1 == r5) goto Ldd
                    androidx.compose.ui.platform.AndroidComposeView r5 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidViewsHandler r5 = r5.getAndroidViewsHandler$ui_release()
                    android.view.View r5 = androidx.compose.ui.platform.SemanticsUtils_androidKt.semanticsIdToView(r5, r1)
                    if (r5 == 0) goto Lc3
                    r6.setTraversalAfter(r5)
                    goto Lca
                Lc3:
                    androidx.compose.ui.platform.AndroidComposeView r5 = r3
                    android.view.View r5 = (android.view.View) r5
                    r6.setTraversalAfter(r5, r1)
                Lca:
                    androidx.compose.ui.platform.AndroidComposeView r5 = androidx.compose.ui.platform.AndroidComposeView.this
                    android.view.accessibility.AccessibilityNodeInfo r6 = r6.unwrap()
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r1 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r1)
                    java.lang.String r1 = r1.getExtraDataTestTraversalAfterVal()
                    androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r5, r0, r6, r1)
                Ldd:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.AnonymousClass1.onInitializeAccessibilityNodeInfo(android.view.View, androidx.core.view.accessibility.AccessibilityNodeInfoCompat):void");
            }
        });
    }

    public final void removeAndroidView(AndroidViewHolder view) {
        getAndroidViewsHandler$ui_release().removeViewInLayout(view);
        HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
        TypeIntrinsics.asMutableMap(layoutNodeToHolder).remove(getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(view));
        view.setImportantForAccessibility(0);
    }

    public final void drawAndroidView(AndroidViewHolder view, Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode nodeToRemeasure) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (nodeToRemeasure != null) {
            while (nodeToRemeasure != null && nodeToRemeasure.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(nodeToRemeasure)) {
                nodeToRemeasure = nodeToRemeasure.getParent$ui_release();
            }
            if (nodeToRemeasure == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode layoutNode) {
        LayoutNode parent$ui_release;
        return this.wasMeasuredWithMultipleConstraints || !((parent$ui_release = layoutNode.getParent$ui_release()) == null || parent$ui_release.getHasFixedInnerContentConstraints$ui_release());
    }

    @Override // androidx.compose.ui.node.Owner
    public void measureAndLayout(boolean sendPointerUpdate) {
        Function0<Unit> function0;
        if (this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() || this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (sendPointerUpdate) {
                try {
                    function0 = this.resendMotionEventOnLayout;
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } else {
                function0 = null;
            }
            if (this.measureAndLayoutDelegate.measureAndLayout(function0)) {
                requestLayout();
            }
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            dispatchPendingInteropLayoutCallbacks();
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: measureAndLayout-0kLqBqw */
    public void mo6311measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m6196measureAndLayout0kLqBqw(layoutNode, constraints);
            if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
                dispatchPendingInteropLayoutCallbacks();
            }
            if (ComposeUiFlags.isRectTrackingEnabled) {
                getRectManager().dispatchCallbacks();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    private final void dispatchPendingInteropLayoutCallbacks() {
        if (this.isPendingInteropViewLayoutChangeDispatch) {
            getViewTreeObserver().dispatchOnGlobalLayout();
            this.isPendingInteropViewLayoutChangeDispatch = false;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, affectsLookahead);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest, boolean scheduleMeasureAndLayout) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
                scheduleMeasureAndLayout(layoutNode);
                return;
            }
            return;
        }
        if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout$default(this, null, 1, null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void measureAndLayoutForTest() {
        Owner.measureAndLayout$default(this, false, 1, null);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void setUncaughtExceptionHandler(RootForTest.UncaughtExceptionHandler handler) {
        this.uncaughtExceptionHandler = handler;
        this.measureAndLayoutDelegate.setUncaughtExceptionHandler$ui_release(handler);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long jM6352convertMeasureSpecI7RO_PI = m6352convertMeasureSpecI7RO_PI(widthMeasureSpec);
            int iM9261constructorimpl = (int) ULong.m9261constructorimpl(jM6352convertMeasureSpecI7RO_PI >>> 32);
            int iM9261constructorimpl2 = (int) ULong.m9261constructorimpl(jM6352convertMeasureSpecI7RO_PI & 4294967295L);
            long jM6352convertMeasureSpecI7RO_PI2 = m6352convertMeasureSpecI7RO_PI(heightMeasureSpec);
            long jM7216fitPrioritizingHeightZbe2FdA = Constraints.INSTANCE.m7216fitPrioritizingHeightZbe2FdA(iM9261constructorimpl, iM9261constructorimpl2, (int) ULong.m9261constructorimpl(jM6352convertMeasureSpecI7RO_PI2 >>> 32), (int) ULong.m9261constructorimpl(4294967295L & jM6352convertMeasureSpecI7RO_PI2));
            Constraints constraints = this.onMeasureConstraints;
            boolean zM7201equalsimpl0 = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m7195boximpl(jM7216fitPrioritizingHeightZbe2FdA);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    zM7201equalsimpl0 = Constraints.m7201equalsimpl0(constraints.getValue(), jM7216fitPrioritizingHeightZbe2FdA);
                }
                if (!zM7201equalsimpl0) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m6197updateRootConstraintsBRTryo0(jM7216fitPrioritizingHeightZbe2FdA);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: component1-VKZWuLQ, reason: not valid java name */
    private final int m6350component1VKZWuLQ(long j) {
        return (int) ULong.m9261constructorimpl(j >>> 32);
    }

    /* renamed from: component2-VKZWuLQ, reason: not valid java name */
    private final int m6351component2VKZWuLQ(long j) {
        return (int) ULong.m9261constructorimpl(j & 4294967295L);
    }

    /* renamed from: pack-ZIaKswc, reason: not valid java name */
    private final long m6354packZIaKswc(int a, int b) {
        return ULong.m9261constructorimpl(ULong.m9261constructorimpl(b) | ULong.m9261constructorimpl(ULong.m9261constructorimpl(a) << 32));
    }

    /* renamed from: convertMeasureSpec-I7RO_PI, reason: not valid java name */
    private final long m6352convertMeasureSpecI7RO_PI(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode == Integer.MIN_VALUE) {
            return m6354packZIaKswc(0, size);
        }
        if (mode == 0) {
            return m6354packZIaKswc(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return m6354packZIaKswc(size, size);
        }
        throw new IllegalStateException();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.lastMatrixRecalculationAnimationTime = 0L;
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r - l, b - t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int iM7383getXimpl = IntOffset.m7383getXimpl(j);
        int iM7384getYimpl = IntOffset.m7384getYimpl(j);
        int[] iArr = this.tmpPositionArray;
        boolean z = false;
        int i = iArr[0];
        if (iM7383getXimpl != i || iM7384getYimpl != iArr[1] || this.lastMatrixRecalculationAnimationTime < 0) {
            this.globalPosition = IntOffset.m7377constructorimpl((i << 32) | (iArr[1] & 4294967295L));
            if (iM7383getXimpl != Integer.MAX_VALUE && iM7384getYimpl != Integer.MAX_VALUE) {
                getRoot().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                z = true;
            }
        }
        recalculateWindowPosition();
        View rootView = this._rootView;
        if (rootView == null) {
            rootView = getRootView();
            this._rootView = rootView;
        }
        getRectManager().m6487updateOffsetsgTq6Wqs(this.globalPosition, IntOffsetKt.m7400roundk4lQ0M(this.windowPosition), this.viewToWindowMatrix, rootView.getWidth(), rootView.getHeight());
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
        if (ComposeUiFlags.isRectTrackingEnabled) {
            getRectManager().dispatchCallbacks();
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnedLayer createLayer(Function2<? super androidx.compose.ui.graphics.Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer, GraphicsLayer explicitLayer) {
        if (explicitLayer != null) {
            return new GraphicsLayerOwnerLayer(explicitLayer, null, this, drawBlock, invalidateParentLayer);
        }
        OwnedLayer ownedLayerPop = this.layerCache.pop();
        if (ownedLayerPop != null) {
            ownedLayerPop.reuseLayer(drawBlock, invalidateParentLayer);
            return ownedLayerPop;
        }
        return new GraphicsLayerOwnerLayer(getGraphicsContext().createGraphicsLayer(), getGraphicsContext(), this, drawBlock, invalidateParentLayer);
    }

    public final boolean recycle$ui_release(OwnedLayer layer) {
        if (this.viewLayersContainer != null) {
            ViewLayer.INSTANCE.getShouldUseDispatchDraw();
        }
        this.layerCache.push(layer);
        this.dirtyLayers.remove(layer);
        return true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui_release();
        this.contentCaptureManager.onSemanticsChange$ui_release();
    }

    @Override // androidx.compose.ui.node.Owner
    public void onLayoutChange(LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.onLayoutChange$ui_release(layoutNode);
        this.contentCaptureManager.onLayoutChange$ui_release();
    }

    @Override // androidx.compose.ui.node.Owner
    public void onLayoutNodeDeactivated(LayoutNode layoutNode) {
        AndroidAutofillManager androidAutofillManager;
        if (ComposeUiFlags.isRectTrackingEnabled) {
            getRectManager().remove(layoutNode);
        }
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.onLayoutNodeDeactivated$ui_release(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPreLayoutNodeReused(LayoutNode layoutNode, int oldSemanticsId) {
        getLayoutNodes().remove(oldSemanticsId);
        getLayoutNodes().set(layoutNode.getSemanticsId(), layoutNode);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPostLayoutNodeReused(LayoutNode layoutNode, int oldSemanticsId) {
        AndroidAutofillManager androidAutofillManager;
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.onPostLayoutNodeReused$ui_release(layoutNode, oldSemanticsId);
        }
        getRectManager().onLayoutPositionChanged(layoutNode, true);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onInteropViewLayoutChange(View view) {
        this.isPendingInteropViewLayoutChangeDispatch = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(listener);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        View view = null;
        Owner.measureAndLayout$default(this, false, 1, null);
        Snapshot.INSTANCE.notifyObjectsInitialized();
        this.isDrawingContent = true;
        try {
            CanvasHolder canvasHolder = this.canvasHolder;
            Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
            canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
            getRoot().draw$ui_release(canvasHolder.getAndroidCanvas(), null);
            canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
            if (!this.dirtyLayers.isEmpty()) {
                int size = this.dirtyLayers.size();
                for (int i = 0; i < size; i++) {
                    this.dirtyLayers.get(i).updateDisplayList();
                }
            }
            if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
                int iSave = canvas.save();
                canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
                super.dispatchDraw(canvas);
                canvas.restoreToCount(iSave);
            }
            this.dirtyLayers.clear();
            this.isDrawingContent = false;
        } catch (Throwable th) {
            RootForTest.UncaughtExceptionHandler uncaughtExceptionHandler = this.uncaughtExceptionHandler;
            if (uncaughtExceptionHandler == null) {
                throw th;
            }
            uncaughtExceptionHandler.onUncaughtException(th);
        }
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
        if (this.isArrEnabled) {
            Api35Impl.setRequestedFrameRate(this, this.currentFrameRate);
            View view2 = this.frameRateCategoryView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameRateCategoryView");
                view2 = null;
            }
            Api35Impl.setRequestedFrameRate(view2, this.currentFrameRateCategory);
            if (!Float.isNaN(this.currentFrameRateCategory)) {
                View view3 = this.frameRateCategoryView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("frameRateCategoryView");
                    view3 = null;
                }
                view3.invalidate();
                View view4 = this.frameRateCategoryView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("frameRateCategoryView");
                } else {
                    view = view4;
                }
                drawChild(canvas, view, getDrawingTime());
            }
            this.currentFrameRate = Float.NaN;
            this.currentFrameRateCategory = Float.NaN;
        }
        if (ComposeUiFlags.isRectTrackingEnabled) {
            getRectManager().dispatchCallbacks();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer layer, boolean isDirty) {
        if (!isDirty) {
            if (this.isDrawingContent) {
                return;
            }
            this.dirtyLayers.remove(layer);
            List<OwnedLayer> list = this.postponedDirtyLayers;
            if (list != null) {
                list.remove(layer);
                return;
            }
            return;
        }
        if (!this.isDrawingContent) {
            this.dirtyLayers.add(layer);
            return;
        }
        ArrayList arrayList = this.postponedDirtyLayers;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.postponedDirtyLayers = arrayList;
        }
        arrayList.add(layer);
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> callback) {
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.onViewTreeOwnersAvailable = callback;
    }

    public final Object boundsUpdatesContentCaptureEventLoop(Continuation<? super Unit> continuation) {
        Object objBoundsUpdatesEventLoop$ui_release = this.contentCaptureManager.boundsUpdatesEventLoop$ui_release(continuation);
        return objBoundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBoundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    public final Object boundsUpdatesAccessibilityEventLoop(Continuation<? super Unit> continuation) {
        Object objBoundsUpdatesEventLoop$ui_release = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui_release(continuation);
        return objBoundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBoundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode node) {
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, node, false, 2, null);
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            invalidateLayoutNodeMeasurement(layoutNodeArr[i]);
        }
    }

    private final void invalidateLayers(LayoutNode node) {
        node.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            invalidateLayers(layoutNodeArr[i]);
        }
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner2;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT < 30) {
            setShowLayoutBounds(INSTANCE.getIsShowingLayoutBounds());
        }
        if (ComposeUiFlags.areWindowInsetsRulersEnabled) {
            this.insetsListener.onViewAttachedToWindow(this);
        }
        INSTANCE.addNotificationForSysPropsChange(this);
        this._windowInfo.setWindowFocused(hasWindowFocus());
        this._windowInfo.setOnInitializeContainerSize(new Function0<IntSize>() { // from class: androidx.compose.ui.platform.AndroidComposeView.onAttachedToWindow.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ IntSize invoke() {
                return IntSize.m7418boximpl(m6361invokeYbymL2g());
            }

            /* renamed from: invoke-YbymL2g, reason: not valid java name */
            public final long m6361invokeYbymL2g() {
                return AndroidWindowInfo_androidKt.calculateWindowSize(AndroidComposeView.this);
            }
        });
        updateWindowMetrics();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        AndroidComposeView androidComposeView = this;
        LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get(androidComposeView);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(androidComposeView);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle2 = null;
        if (viewTreeOwners == null || (lifecycleOwner3 != null && savedStateRegistryOwner != null && (lifecycleOwner3 != viewTreeOwners.getLifecycleOwner() || savedStateRegistryOwner != viewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner3 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (savedStateRegistryOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            lifecycleOwner3.getLifecycle().addObserver(this);
            ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner3, savedStateRegistryOwner);
            set_viewTreeOwners(viewTreeOwners2);
            Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
            if (function1 != null) {
                function1.invoke(viewTreeOwners2);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        this._inputModeManager.m5357setInputModeiuPiT84(isInTouchMode() ? InputMode.INSTANCE.m5354getTouchaOaMEAU() : InputMode.INSTANCE.m5353getKeyboardaOaMEAU());
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        if (viewTreeOwners3 != null && (lifecycleOwner2 = viewTreeOwners3.getLifecycleOwner()) != null) {
            lifecycle2 = lifecycleOwner2.getLifecycle();
        }
        if (lifecycle2 != null) {
            lifecycle2.addObserver(this);
            lifecycle2.addObserver(this.contentCaptureManager);
            getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
            getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
            getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
            if (Build.VERSION.SDK_INT >= 31) {
                AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(androidComposeView);
            }
            AndroidAutofillManager androidAutofillManager = this._autofillManager;
            if (androidAutofillManager != null) {
                getFocusOwner().getListeners().add(androidAutofillManager);
                getSemanticsOwner().getListeners$ui_release().add(androidAutofillManager);
                return;
            }
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
        throw new KotlinNothingValueException();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        super.onDetachedFromWindow();
        if (ComposeUiFlags.areWindowInsetsRulersEnabled) {
            this.insetsListener.onViewDetachedFromWindow(this);
        }
        Lifecycle lifecycle = null;
        if (this.isArrEnabled) {
            View view = this.frameRateCategoryView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameRateCategoryView");
                view = null;
            }
            removeView(view);
        }
        INSTANCE.removeNotificationForSysPropsChange(this);
        getSnapshotObserver().stopObserving$ui_release();
        this._windowInfo.setOnInitializeContainerSize(null);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null) {
            lifecycle = lifecycleOwner.getLifecycle();
        }
        if (lifecycle != null) {
            lifecycle.removeObserver(this.contentCaptureManager);
            lifecycle.removeObserver(this);
            if (autofillSupported() && (androidAutofill = this._autofill) != null) {
                AutofillCallback.INSTANCE.unregister(androidAutofill);
            }
            getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
            getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
            getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
            if (Build.VERSION.SDK_INT >= 31) {
                AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback(this);
            }
            AndroidAutofillManager androidAutofillManager = this._autofillManager;
            if (androidAutofillManager != null) {
                getSemanticsOwner().getListeners$ui_release().remove(androidAutofillManager);
                getFocusOwner().getListeners().remove(androidAutofillManager);
                return;
            }
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
        throw new KotlinNothingValueException();
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        AndroidAutofillManager androidAutofillManager;
        if (!autofillSupported() || structure == null) {
            return;
        }
        if (ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.populateViewStructure(structure);
        }
        AndroidAutofill androidAutofill = this._autofill;
        if (androidAutofill != null) {
            AndroidAutofill_androidKt.populateViewStructure(androidAutofill, structure);
        }
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> values) {
        AndroidAutofillManager androidAutofillManager;
        if (autofillSupported()) {
            if (ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
                androidAutofillManager.performAutofill(values);
            }
            AndroidAutofill androidAutofill = this._autofill;
            if (androidAutofill != null) {
                AndroidAutofill_androidKt.performAutofill(androidAutofill, values);
            }
        }
    }

    @Override // android.view.View
    public void onCreateVirtualViewTranslationRequests(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        this.contentCaptureManager.onCreateVirtualViewTranslationRequests$ui_release(virtualIds, supportedFormats, requestsCollector);
    }

    @Override // android.view.View
    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> response) {
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.onVirtualViewTranslationResponses$ui_release(androidContentCaptureManager, response);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(final MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            if (motionEvent.getActionMasked() == 8) {
                this.hoverExitReceived = false;
            } else {
                this.sendHoverExitEvent.run();
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 8) {
            if (motionEvent.isFromSource(4194304)) {
                return handleRotaryEvent(motionEvent);
            }
            return (m6353handleMotionEvent8iAsVTc(motionEvent) & 1) != 0;
        }
        if (!motionEvent.isFromSource(2)) {
            float x = motionEvent.getX();
            if (getFocusOwner().dispatchIndirectTouchEvent(new AndroidIndirectTouchEvent(Offset.m4286constructorimpl((Float.floatToRawIntBits(motionEvent.getY()) & 4294967295L) | (Float.floatToRawIntBits(x) << 32)), motionEvent.getEventTime(), AndroidIndirectTouchEvent_androidKt.convertActionToIndirectTouchEventType(motionEvent.getActionMasked()), motionEvent, null), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$dispatchGenericMotionEvent$handled$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(super/*android.view.ViewGroup*/.dispatchGenericMotionEvent(motionEvent));
                }
            })) {
                return true;
            }
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int iM6353handleMotionEvent8iAsVTc = m6353handleMotionEvent8iAsVTc(motionEvent);
        if ((iM6353handleMotionEvent8iAsVTc & 2) != 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return (iM6353handleMotionEvent8iAsVTc & 1) != 0;
    }

    private final boolean handleRotaryEvent(final MotionEvent event) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        float f = -event.getAxisValue(26);
        return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(f * ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, getContext()), f * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, getContext()), event.getEventTime(), event.getDeviceId()), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.handleRotaryEvent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(AndroidComposeView.super.dispatchGenericMotionEvent(event));
            }
        });
    }

    /* renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m6353handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        int i;
        int i2;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked = motionEvent.getActionMasked();
                MotionEvent motionEvent2 = this.previousMotionEvent;
                boolean z = motionEvent2 != null && motionEvent2.getToolType(0) == 3;
                if (motionEvent2 == null || !hasChangedDevices(motionEvent, motionEvent2)) {
                    i = 10;
                } else {
                    if (isDevicePressEvent(motionEvent2)) {
                        this.pointerInputEventProcessor.processCancel();
                    } else if (motionEvent2.getActionMasked() != 10 && z) {
                        i = 10;
                        sendSimulatedEvent$default(this, motionEvent2, 10, motionEvent2.getEventTime(), false, 8, null);
                    }
                    i = 10;
                }
                boolean z2 = motionEvent.getToolType(0) == 3;
                if (z || !z2 || actionMasked == 3 || actionMasked == 9 || !isInBounds(motionEvent)) {
                    i2 = 9;
                } else {
                    i2 = 9;
                    sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                MotionEvent motionEvent3 = this.previousMotionEvent;
                if (motionEvent3 != null && motionEvent3.getAction() == i) {
                    MotionEvent motionEvent4 = this.previousMotionEvent;
                    int pointerId = motionEvent4 != null ? motionEvent4.getPointerId(0) : -1;
                    if (motionEvent.getAction() == i2 && motionEvent.getHistorySize() == 0) {
                        if (pointerId >= 0) {
                            this.motionEventAdapter.endStream(pointerId);
                        }
                    } else if (motionEvent.getAction() == 0 && motionEvent.getHistorySize() == 0) {
                        MotionEvent motionEvent5 = this.previousMotionEvent;
                        float x = motionEvent5 != null ? motionEvent5.getX() : Float.NaN;
                        MotionEvent motionEvent6 = this.previousMotionEvent;
                        boolean z3 = (x == motionEvent.getX() && (motionEvent6 != null ? motionEvent6.getY() : Float.NaN) == motionEvent.getY()) ? false : true;
                        MotionEvent motionEvent7 = this.previousMotionEvent;
                        boolean z4 = (motionEvent7 != null ? motionEvent7.getEventTime() : -1L) != motionEvent.getEventTime();
                        if (z3 || z4) {
                            if (pointerId >= 0) {
                                this.motionEventAdapter.endStream(pointerId);
                            }
                            this.pointerInputEventProcessor.clearPreviouslyHitModifierNodes();
                        }
                    }
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                return m6355sendMotionEvent8iAsVTc(motionEvent);
            } finally {
                Trace.endSection();
            }
        } finally {
            this.forceUseMatrixCache = false;
        }
    }

    private final boolean hasChangedDevices(MotionEvent event, MotionEvent lastEvent) {
        return (lastEvent.getSource() == event.getSource() && lastEvent.getToolType(0) == event.getToolType(0)) ? false : true;
    }

    private final boolean isDevicePressEvent(MotionEvent event) {
        int actionMasked;
        return event.getButtonState() != 0 || (actionMasked = event.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    /* renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m6355sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m6412setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5891constructorimpl(motionEvent.getMetaState()));
        }
        AndroidComposeView androidComposeView = this;
        PointerInputEvent pointerInputEventConvertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, androidComposeView);
        if (pointerInputEventConvertToPointerInputEvent$ui_release != null) {
            List<PointerInputEventData> pointers = pointerInputEventConvertToPointerInputEvent$ui_release.getPointers();
            int size = pointers.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    pointerInputEventData = pointers.get(size);
                    if (pointerInputEventData.getDown()) {
                        break;
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
                pointerInputEventData = null;
            } else {
                pointerInputEventData = null;
            }
            PointerInputEventData pointerInputEventData2 = pointerInputEventData;
            if (pointerInputEventData2 != null) {
                this.lastDownPointerPosition = pointerInputEventData2.m5845getPositionF1C5BW0();
            }
            int iM5850processBIzXfog = this.pointerInputEventProcessor.m5850processBIzXfog(pointerInputEventConvertToPointerInputEvent$ui_release, androidComposeView, isInBounds(motionEvent));
            pointerInputEventConvertToPointerInputEvent$ui_release.setMotionEvent(null);
            int actionMasked = motionEvent.getActionMasked();
            if ((actionMasked != 0 && actionMasked != 5) || (iM5850processBIzXfog & 1) != 0) {
                return iM5850processBIzXfog;
            }
            this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
            return iM5850processBIzXfog;
        }
        this.pointerInputEventProcessor.processCancel();
        return PointerInputEventProcessorKt.ProcessResult(false, false, false);
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
        } else if (action != 9 && action != 10) {
            actionIndex = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (actionIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            pointerPropertiesArr[i] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerCoordsArr[i2] = new MotionEvent.PointerCoords();
        }
        int i3 = 0;
        while (i3 < pointerCount) {
            int i4 = ((actionIndex < 0 || i3 < actionIndex) ? 0 : 1) + i3;
            motionEvent.getPointerProperties(i4, pointerPropertiesArr[i3]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i3];
            motionEvent.getPointerCoords(i4, pointerCoords);
            float f = pointerCoords.x;
            long jMo5909localToScreenMKHz9U = mo5909localToScreenMKHz9U(Offset.m4286constructorimpl((Float.floatToRawIntBits(pointerCoords.y) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
            pointerCoords.x = Float.intBitsToFloat((int) (jMo5909localToScreenMKHz9U >> 32));
            pointerCoords.y = Float.intBitsToFloat((int) (jMo5909localToScreenMKHz9U & 4294967295L));
            i3++;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? eventTime : motionEvent.getDownTime(), eventTime, action, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), forceHover ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        AndroidComposeView androidComposeView = this;
        PointerInputEvent pointerInputEventConvertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEventObtain, androidComposeView);
        Intrinsics.checkNotNull(pointerInputEventConvertToPointerInputEvent$ui_release);
        this.pointerInputEventProcessor.m5850processBIzXfog(pointerInputEventConvertToPointerInputEvent$ui_release, androidComposeView, true);
        motionEventObtain.recycle();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return this.composeAccessibilityDelegate.m6366canScroll0AR0LA0$ui_release(false, direction, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.composeAccessibilityDelegate.m6366canScroll0AR0LA0$ui_release(true, direction, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return 0.0f <= x && x <= ((float) getWidth()) && 0.0f <= y && y <= ((float) getHeight());
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo5909localToScreenMKHz9U(long localPosition) {
        recalculateWindowPosition();
        long jM4786mapMKHz9U = Matrix.m4786mapMKHz9U(this.viewToWindowMatrix, localPosition);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM4786mapMKHz9U >> 32)) + Float.intBitsToFloat((int) (this.windowPosition >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM4786mapMKHz9U & 4294967295L)) + Float.intBitsToFloat((int) (this.windowPosition & 4294967295L));
        return Offset.m4286constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    @Override // androidx.compose.ui.input.pointer.MatrixPositionCalculator
    /* renamed from: localToScreen-58bKbWc */
    public void mo5758localToScreen58bKbWc(float[] localTransform) {
        recalculateWindowPosition();
        Matrix.m4799timesAssign58bKbWc(localTransform, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.m6371preTranslatecG2Xzmc(localTransform, Float.intBitsToFloat((int) (this.windowPosition >> 32)), Float.intBitsToFloat((int) (this.windowPosition & 4294967295L)), this.tmpMatrix);
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo5910screenToLocalMKHz9U(long positionOnScreen) {
        recalculateWindowPosition();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (positionOnScreen >> 32)) - Float.intBitsToFloat((int) (this.windowPosition >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (positionOnScreen & 4294967295L)) - Float.intBitsToFloat((int) (this.windowPosition & 4294967295L));
        return Matrix.m4786mapMKHz9U(this.windowToViewMatrix, Offset.m4286constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (4294967295L & Float.floatToRawIntBits(fIntBitsToFloat2))));
    }

    private final void recalculateWindowPosition() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = jCurrentAnimationTimeMillis;
            recalculateWindowViewTransforms();
            ViewParent parent = getParent();
            AndroidComposeView androidComposeView = this;
            while (parent instanceof ViewGroup) {
                androidComposeView = (View) parent;
                parent = ((ViewGroup) androidComposeView).getParent();
            }
            androidComposeView.getLocationOnScreen(this.tmpPositionArray);
            int[] iArr = this.tmpPositionArray;
            float f = iArr[0];
            float f2 = iArr[1];
            androidComposeView.getLocationInWindow(iArr);
            float f3 = this.tmpPositionArray[0];
            float f4 = f2 - r0[1];
            this.windowPosition = Offset.m4286constructorimpl((Float.floatToRawIntBits(f - f3) << 32) | (Float.floatToRawIntBits(f4) & 4294967295L));
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        float[] fArr = this.viewToWindowMatrix;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        long jM4786mapMKHz9U = Matrix.m4786mapMKHz9U(fArr, Offset.m4286constructorimpl((Float.floatToRawIntBits(y) & 4294967295L) | (Float.floatToRawIntBits(x) << 32)));
        float rawX = motionEvent.getRawX() - Float.intBitsToFloat((int) (jM4786mapMKHz9U >> 32));
        float rawY = motionEvent.getRawY() - Float.intBitsToFloat((int) (jM4786mapMKHz9U & 4294967295L));
        this.windowPosition = Offset.m4286constructorimpl((Float.floatToRawIntBits(rawX) << 32) | (Float.floatToRawIntBits(rawY) & 4294967295L));
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo6372calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m6404invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    private final void updateWindowMetrics() {
        MutableState mutableState = this._windowInfo._containerSize;
        if (mutableState != null) {
            mutableState.setValue(IntSize.m7418boximpl(AndroidWindowInfo_androidKt.calculateWindowSize(this)));
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m4035getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.getEditorHasFocus();
        }
        return androidPlatformTextInputSession.isReadyForConnection();
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m4035getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.createInputConnection(outAttrs);
        }
        return androidPlatformTextInputSession.createInputConnection(outAttrs);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculateLocalPosition-MK-Hz9U */
    public long mo6308calculateLocalPositionMKHz9U(long positionInWindow) {
        recalculateWindowPosition();
        return Matrix.m4786mapMKHz9U(this.windowToViewMatrix, positionInWindow);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo6309calculatePositionInWindowMKHz9U(long localPosition) {
        recalculateWindowPosition();
        return Matrix.m4786mapMKHz9U(this.viewToWindowMatrix, localPosition);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setDensity(AndroidDensity_androidKt.Density(getContext()));
        updateWindowMetrics();
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        if (this.superclassInitComplete) {
            LayoutDirection layoutDirection2 = FocusInteropUtils_androidKt.toLayoutDirection(layoutDirection);
            if (layoutDirection2 == null) {
                layoutDirection2 = LayoutDirection.Ltr;
            }
            setLayoutDirection(layoutDirection2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return false;
        }
        this.composeAccessibilityDelegate.dispatchHoverEvent$ui_release(event);
        int actionMasked = event.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(event)) {
                if (event.getToolType(0) == 3 && event.getButtonState() != 0) {
                    return false;
                }
                MotionEvent motionEvent = this.previousMotionEvent;
                if (motionEvent != null) {
                    motionEvent.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                this.hoverExitReceived = true;
                postDelayed(this.sendHoverExitEvent, 8L);
                return false;
            }
        } else if (!isPositionChanged(event)) {
            return false;
        }
        return (m6353handleMotionEvent8iAsVTc(event) & 1) != 0;
    }

    private final boolean isBadMotionEvent(MotionEvent event) {
        boolean z = (Float.floatToRawIntBits(event.getX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(event.getY()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(event.getRawX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(event.getRawY()) & Integer.MAX_VALUE) >= 2139095040;
        if (!z) {
            int pointerCount = event.getPointerCount();
            for (int i = 1; i < pointerCount; i++) {
                z = (Float.floatToRawIntBits(event.getX(i)) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(event.getY(i)) & Integer.MAX_VALUE) >= 2139095040 || (Build.VERSION.SDK_INT >= 29 && !MotionEventVerifierApi29.INSTANCE.isValidMotionEvent(event, i));
                if (z) {
                    break;
                }
            }
        }
        return z;
    }

    private final boolean isPositionChanged(MotionEvent event) {
        MotionEvent motionEvent;
        return (event.getPointerCount() == 1 && (motionEvent = this.previousMotionEvent) != null && motionEvent.getPointerCount() == event.getPointerCount() && event.getRawX() == motionEvent.getRawX() && event.getRawY() == motionEvent.getRawY()) ? false : true;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int accessibilityId, View currentView) throws NoSuchMethodException, SecurityException {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        Method declaredMethod = Class.forName("android.view.View").getDeclaredMethod("getAccessibilityViewId", new Class[0]);
        declaredMethod.setAccessible(true);
        if (Intrinsics.areEqual(declaredMethod.invoke(currentView, new Object[0]), Integer.valueOf(accessibilityId))) {
            return currentView;
        }
        if (!(currentView instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) currentView;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewFindViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, viewGroup.getChildAt(i));
            if (viewFindViewByAccessibilityIdRootedAtCurrentView != null) {
                return viewFindViewByAccessibilityIdRootedAtCurrentView;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public android.view.PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        PointerIcon stylusHoverIcon;
        int toolType = event.getToolType(pointerIndex);
        if (!event.isFromSource(8194) && event.isFromSource(16386) && ((toolType == 2 || toolType == 4) && (stylusHoverIcon = getPointerIconService().getCurrentStylusHoverIcon()) != null)) {
            return AndroidComposeViewVerificationHelperMethodsN.INSTANCE.toAndroidPointerIcon(getContext(), stylusHoverIcon);
        }
        return super.onResolvePointerIcon(event, pointerIndex);
    }

    @Override // androidx.compose.ui.node.Owner
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int accessibilityId) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        View viewFindViewByAccessibilityIdRootedAtCurrentView = null;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method declaredMethod = Class.forName("android.view.View").getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(this, Integer.valueOf(accessibilityId));
                if (objInvoke instanceof View) {
                    viewFindViewByAccessibilityIdRootedAtCurrentView = (View) objInvoke;
                }
            } else {
                viewFindViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, this);
            }
        } catch (NoSuchMethodException unused) {
        }
        return viewFindViewByAccessibilityIdRootedAtCurrentView;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean isLifecycleInResumedState() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        return ((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getState()) == Lifecycle.State.RESUMED;
    }

    @Override // androidx.compose.ui.node.Owner
    public void incrementSensitiveComponentCount() {
        if (Build.VERSION.SDK_INT >= 35) {
            if (this.sensitiveComponentCount == 0) {
                AndroidComposeViewSensitiveContent35.INSTANCE.setContentSensitivity(getView(), true);
            }
            this.sensitiveComponentCount++;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void decrementSensitiveComponentCount() {
        if (Build.VERSION.SDK_INT >= 35) {
            if (this.sensitiveComponentCount == 1) {
                AndroidComposeViewSensitiveContent35.INSTANCE.setContentSensitivity(getView(), false);
            }
            this.sensitiveComponentCount--;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void incrementKeepScreenOnCount() {
        this.keepScreenOnCount++;
        getView().setKeepScreenOn(this.keepScreenOnCount > 0);
    }

    @Override // androidx.compose.ui.node.Owner
    public void decrementKeepScreenOnCount() {
        this.keepScreenOnCount--;
        getView().setKeepScreenOn(this.keepScreenOnCount > 0);
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidComposeView getOutOfFrameExecutor() {
        if (isAttachedToWindow()) {
            return this;
        }
        return null;
    }

    @Override // androidx.compose.ui.node.OutOfFrameExecutor
    public void schedule(final Function0<Unit> block) {
        Handler handler = getHandler();
        if (handler == null) {
            throw new IllegalArgumentException("schedule is called when outOfFrameExecutor is not available (view is detached)".toString());
        }
        handler.postAtFrontOfQueue(new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.schedule$lambda$38(block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void schedule$lambda$38(Function0 function0) {
        Trace.beginSection("AndroidOwner:outOfFrameExecutor");
        try {
            function0.invoke();
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void voteFrameRate(float frameRate) {
        if (this.isArrEnabled) {
            if (frameRate > 0.0f) {
                if (Float.isNaN(this.currentFrameRate) || frameRate > this.currentFrameRate) {
                    this.currentFrameRate = frameRate;
                    return;
                }
                return;
            }
            if (frameRate < 0.0f) {
                if (Float.isNaN(this.currentFrameRateCategory) || frameRate < this.currentFrameRateCategory) {
                    this.currentFrameRateCategory = frameRate;
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: dispatchOnScrollChanged-k-4lQ0M */
    public void mo6310dispatchOnScrollChangedk4lQ0M(long delta) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        INSTANCE.dispatchOnScrollChanged(getViewTreeObserver());
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "systemPropertiesClass", "Ljava/lang/Class;", "getBooleanMethod", "Ljava/lang/reflect/Method;", "addChangeCallbackMethod", "composeViews", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/platform/AndroidComposeView;", "systemPropertiesChangedRunnable", "Ljava/lang/Runnable;", "dispatchOnScrollChangedMethod", "getIsShowingLayoutBounds", "", "addNotificationForSysPropsChange", "", "composeView", "removeNotificationForSysPropsChange", "dispatchOnScrollChanged", "viewTreeObserver", "Landroid/view/ViewTreeObserver;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                }
                if (AndroidComposeView.getBooleanMethod == null) {
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object objInvoke = method != null ? method.invoke(null, "debug.layout", false) : null;
                return Intrinsics.areEqual((Object) (objInvoke instanceof Boolean ? (Boolean) objInvoke : null), (Object) true);
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addNotificationForSysPropsChange(AndroidComposeView composeView) {
            if (Build.VERSION.SDK_INT > 28) {
                if (AndroidComposeView.systemPropertiesChangedRunnable == null) {
                    Runnable runnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$Companion$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            AndroidComposeView.Companion.addNotificationForSysPropsChange$lambda$3();
                        }
                    };
                    AndroidComposeView.systemPropertiesChangedRunnable = runnable;
                    StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
                    try {
                        try {
                            if (AndroidComposeView.systemPropertiesClass == null) {
                                AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                            }
                            if (AndroidComposeView.addChangeCallbackMethod == null) {
                                StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
                                Class cls = AndroidComposeView.systemPropertiesClass;
                                AndroidComposeView.addChangeCallbackMethod = cls != null ? cls.getDeclaredMethod("addChangeCallback", Runnable.class) : null;
                            }
                            Method method = AndroidComposeView.addChangeCallbackMethod;
                            if (method != null) {
                                method.invoke(null, runnable);
                            }
                        } finally {
                            StrictMode.setVmPolicy(vmPolicy);
                        }
                    } catch (Throwable unused) {
                        Unit unit = Unit.INSTANCE;
                    }
                }
                synchronized (AndroidComposeView.composeViews) {
                    AndroidComposeView.composeViews.add(composeView);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void addNotificationForSysPropsChange$lambda$3() {
            synchronized (AndroidComposeView.composeViews) {
                int i = 0;
                if (Build.VERSION.SDK_INT < 30) {
                    MutableObjectList mutableObjectList = AndroidComposeView.composeViews;
                    Object[] objArr = mutableObjectList.content;
                    int i2 = mutableObjectList._size;
                    while (i < i2) {
                        AndroidComposeView androidComposeView = (AndroidComposeView) objArr[i];
                        boolean showLayoutBounds = androidComposeView.getShowLayoutBounds();
                        androidComposeView.setShowLayoutBounds(AndroidComposeView.INSTANCE.getIsShowingLayoutBounds());
                        if (showLayoutBounds != androidComposeView.getShowLayoutBounds()) {
                            androidComposeView.invalidateDescendants();
                        }
                        i++;
                    }
                } else {
                    MutableObjectList mutableObjectList2 = AndroidComposeView.composeViews;
                    Object[] objArr2 = mutableObjectList2.content;
                    int i3 = mutableObjectList2._size;
                    while (i < i3) {
                        ((AndroidComposeView) objArr2[i]).invalidateDescendants();
                        i++;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeNotificationForSysPropsChange(AndroidComposeView composeView) {
            if (Build.VERSION.SDK_INT > 28) {
                synchronized (AndroidComposeView.composeViews) {
                    AndroidComposeView.composeViews.remove(composeView);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final void dispatchOnScrollChanged(ViewTreeObserver viewTreeObserver) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            try {
                if (AndroidComposeView.dispatchOnScrollChangedMethod == null) {
                    Method declaredMethod = viewTreeObserver.getClass().getDeclaredMethod("dispatchOnScrollChanged", new Class[0]);
                    declaredMethod.setAccessible(true);
                    AndroidComposeView.dispatchOnScrollChangedMethod = declaredMethod;
                }
                Method method = AndroidComposeView.dispatchOnScrollChangedMethod;
                if (method != null) {
                    method.invoke(viewTreeObserver, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        composeViews = new MutableObjectList<>(0, 1, defaultConstructorMarker);
    }
}
