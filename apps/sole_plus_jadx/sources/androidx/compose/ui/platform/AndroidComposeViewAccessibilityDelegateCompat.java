package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.ArraySet;
import androidx.collection.IntIntMapKt;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterSet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.R;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(d1 = {"\u0000è\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 õ\u00012\u00020\u0001:\nõ\u0001ö\u0001÷\u0001ø\u0001ù\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010u\u001a\u00020\u00132\u0006\u0010v\u001a\u00020\u00132\u0006\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020yH\u0000¢\u0006\u0004\bz\u0010{J5\u0010u\u001a\u00020\u00132\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0Y2\u0006\u0010v\u001a\u00020\u00132\u0006\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020yH\u0002¢\u0006\u0004\b|\u0010}J\b\u0010~\u001a\u00020\u0013H\u0002J\u0013\u0010\u007f\u001a\u0004\u0018\u00010@2\u0007\u0010\u0080\u0001\u001a\u00020\tH\u0002J\u000b\u0010\u0081\u0001\u001a\u0004\u0018\u00010@H\u0002J\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020ZH\u0002J%\u0010\u0085\u0001\u001a\u00020T2\u0007\u0010\u0080\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020@2\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0002J\u001c\u0010\u0089\u0001\u001a\u00020T2\b\u0010\u0084\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0086\u0001\u001a\u00020@H\u0002J\u0011\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001*\u00030\u008c\u0001H\u0002J\u001c\u0010\u008d\u0001\u001a\u00020T2\b\u0010\u0084\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0086\u0001\u001a\u00020@H\u0002J\u0012\u0010\u008e\u0001\u001a\u00020\u00132\u0007\u0010\u0080\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u008f\u0001\u001a\u00020\u00132\u0007\u0010\u0080\u0001\u001a\u00020\tH\u0002JA\u0010\u0090\u0001\u001a\u00020\u00132\u0007\u0010\u0080\u0001\u001a\u00020\t2\u0007\u0010\u0091\u0001\u001a\u00020\t2\u000b\b\u0002\u0010\u0092\u0001\u001a\u0004\u0018\u00010\t2\u0011\b\u0002\u0010\u0093\u0001\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010/H\u0002¢\u0006\u0003\u0010\u0094\u0001J\u0012\u0010\u0095\u0001\u001a\u00020\u00132\u0007\u0010\u0096\u0001\u001a\u00020\u0012H\u0002J\u001b\u0010\u0097\u0001\u001a\u00020\u00122\u0007\u0010\u0080\u0001\u001a\u00020\t2\u0007\u0010\u0091\u0001\u001a\u00020\tH\u0003JD\u0010\u0098\u0001\u001a\u00020\u00122\u0007\u0010\u0080\u0001\u001a\u00020\t2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0003\u0010\u009d\u0001J\u0012\u0010\u009e\u0001\u001a\u00020\u00132\u0007\u0010\u0080\u0001\u001a\u00020\tH\u0002J'\u0010\u009f\u0001\u001a\u00020\u00132\u0007\u0010\u0080\u0001\u001a\u00020\t2\u0007\u0010 \u0001\u001a\u00020\t2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0002J0\u0010£\u0001\u001a\u00020T2\u0007\u0010\u0080\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020@2\u0007\u0010¤\u0001\u001a\u00020i2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0002J\"\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u00012\n\u0010§\u0001\u001a\u0005\u0018\u00010\u0088\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\u0019\u0010ª\u0001\u001a\u00030«\u0001*\u00030¬\u00012\b\u0010\u0084\u0001\u001a\u00030\u0088\u0001H\u0002J\u0011\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u0083\u0001*\u00030«\u0001H\u0002J\u0011\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001*\u00030«\u0001H\u0002J\u0011\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001*\u00030«\u0001H\u0002J\u000f\u0010\u00ad\u0001\u001a\u00030\u0083\u0001*\u00030©\u0001H\u0002J\u0019\u0010²\u0001\u001a\u00020\u00132\b\u0010\u0096\u0001\u001a\u00030³\u0001H\u0000¢\u0006\u0003\b´\u0001J#\u0010µ\u0001\u001a\u00020\t2\b\u0010¶\u0001\u001a\u00030·\u00012\b\u0010¸\u0001\u001a\u00030·\u0001H\u0001¢\u0006\u0003\b¹\u0001J\u0012\u0010º\u0001\u001a\u00020T2\u0007\u0010\u0080\u0001\u001a\u00020\tH\u0002J\u0014\u0010»\u0001\u001a\u00030¼\u00012\b\u0010½\u0001\u001a\u00030¾\u0001H\u0016J4\u0010¿\u0001\u001a\u0005\u0018\u0001HÀ\u0001\"\t\b\u0000\u0010À\u0001*\u00020I2\n\u0010\u009c\u0001\u001a\u0005\u0018\u0001HÀ\u00012\t\b\u0001\u0010Á\u0001\u001a\u00020\tH\u0002¢\u0006\u0003\u0010Â\u0001J\u000f\u0010Å\u0001\u001a\u00020TH\u0000¢\u0006\u0003\bÆ\u0001J\u0013\u0010Ç\u0001\u001a\u00020TH\u0080@¢\u0006\u0006\bÈ\u0001\u0010É\u0001J\u0018\u0010Ê\u0001\u001a\u00020T2\u0007\u0010Ë\u0001\u001a\u00020QH\u0000¢\u0006\u0003\bÌ\u0001J\u0012\u0010Í\u0001\u001a\u00020T2\u0007\u0010Ë\u0001\u001a\u00020QH\u0002J\u0012\u0010Î\u0001\u001a\u00020T2\u0007\u0010Ë\u0001\u001a\u00020QH\u0002J\u001b\u0010Ï\u0001\u001a\u00020T2\u0007\u0010Ë\u0001\u001a\u00020Q2\u0007\u0010Ð\u0001\u001a\u00020^H\u0002J\t\u0010Ñ\u0001\u001a\u00020TH\u0002J\t\u0010Ò\u0001\u001a\u00020TH\u0002J\u0018\u0010Ó\u0001\u001a\u00020T2\r\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020Z0YH\u0002J\"\u0010Ø\u0001\u001a\u00020\u00132\u0007\u0010Ù\u0001\u001a\u00020\t2\u000e\u0010Ú\u0001\u001a\t\u0012\u0005\u0012\u00030Ö\u00010/H\u0002J\u0013\u0010Û\u0001\u001a\u00020T2\b\u0010Ü\u0001\u001a\u00030Ö\u0001H\u0002J&\u0010Ý\u0001\u001a\u00020T2\u0007\u0010Þ\u0001\u001a\u00020\t2\u0007\u0010\u0092\u0001\u001a\u00020\t2\t\u0010ß\u0001\u001a\u0004\u0018\u00010iH\u0002J\u001c\u0010à\u0001\u001a\u00020T2\b\u0010á\u0001\u001a\u00030\u0088\u00012\u0007\u0010â\u0001\u001a\u00020qH\u0002J\u0012\u0010ã\u0001\u001a\u00020\t2\u0007\u0010Ù\u0001\u001a\u00020\tH\u0002J.\u0010ä\u0001\u001a\u00020\u00132\b\u0010\u0084\u0001\u001a\u00030\u0088\u00012\u0007\u0010å\u0001\u001a\u00020\t2\u0007\u0010æ\u0001\u001a\u00020\u00132\u0007\u0010ç\u0001\u001a\u00020\u0013H\u0002J\u0012\u0010è\u0001\u001a\u00020T2\u0007\u0010Þ\u0001\u001a\u00020\tH\u0002J.\u0010é\u0001\u001a\u00020\u00132\b\u0010\u0084\u0001\u001a\u00030\u0088\u00012\u0007\u0010ê\u0001\u001a\u00020\t2\u0007\u0010ë\u0001\u001a\u00020\t2\u0007\u0010ì\u0001\u001a\u00020\u0013H\u0002J\u0013\u0010í\u0001\u001a\u00020\t2\b\u0010\u0084\u0001\u001a\u00030\u0088\u0001H\u0002J\u0013\u0010î\u0001\u001a\u00020\t2\b\u0010\u0084\u0001\u001a\u00030\u0088\u0001H\u0002J\u0013\u0010ï\u0001\u001a\u00020\u00132\b\u0010\u0084\u0001\u001a\u00030\u0088\u0001H\u0002J!\u0010ð\u0001\u001a\u0005\u0018\u00010ñ\u00012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0088\u00012\u0007\u0010å\u0001\u001a\u00020\tH\u0002J\u0017\u0010ò\u0001\u001a\u0004\u0018\u00010i2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0002J\u0011\u0010ó\u0001\u001a\u0005\u0018\u00010\u008c\u0001*\u00030ô\u0001H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR0\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010+\u001a&\u0012\f\u0012\n .*\u0004\u0018\u00010-0- .*\u0012\u0012\f\u0012\n .*\u0004\u0018\u00010-0-\u0018\u00010/0,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001eR\u0014\u00102\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001eR\u001e\u00103\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u00060<R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020E0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0H0HX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0K0HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010M\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010NR\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0Y8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u000e\u0010]\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u00020`X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020`X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010b\"\u0004\bg\u0010dR\u0014\u0010h\u001a\u00020iX\u0080D¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0014\u0010l\u001a\u00020iX\u0080D¢\u0006\b\n\u0000\u001a\u0004\bm\u0010kR\u000e\u0010n\u001a\u00020oX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010p\u001a\b\u0012\u0004\u0012\u00020q0DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020qX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020`X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ã\u0001\u001a\u00030Ä\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Õ\u0001\u001a\t\u0012\u0005\u0012\u00030Ö\u00010,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010×\u0001\u001a\u000f\u0012\u0005\u0012\u00030Ö\u0001\u0012\u0004\u0012\u00020T0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ú\u0001"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "hoveredVirtualViewId", "", "getHoveredVirtualViewId$ui_release$annotations", "()V", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "onSendAccessibilityEvent", "Lkotlin/Function1;", "Landroid/view/accessibility/AccessibilityEvent;", "", "getOnSendAccessibilityEvent$ui_release$annotations", "getOnSendAccessibilityEvent$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnSendAccessibilityEvent$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "value", "accessibilityForceEnabledForTesting", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "SendRecurringAccessibilityEventsIntervalMillis", "", "getSendRecurringAccessibilityEventsIntervalMillis$ui_release", "()J", "setSendRecurringAccessibilityEventsIntervalMillis$ui_release", "(J)V", "enabledStateListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "touchExplorationStateListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "kotlin.jvm.PlatformType", "", "isEnabled", "isEnabled$ui_release", "isTouchExplorationEnabled", "requestFromAccessibilityToolForTesting", "getRequestFromAccessibilityToolForTesting$ui_release", "()Ljava/lang/Boolean;", "setRequestFromAccessibilityToolForTesting$ui_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "handler", "Landroid/os/Handler;", "nodeProvider", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "accessibilityFocusedVirtualViewId", "focusedVirtualViewId", "currentlyAccessibilityFocusedANI", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "currentlyFocusedANI", "sendingFocusAffectingEvent", "pendingHorizontalScrollEvents", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "pendingVerticalScrollEvents", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "labelToActionId", "Landroidx/collection/MutableObjectIntMap;", "accessibilityCursorPosition", "previousTraversedNode", "Ljava/lang/Integer;", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "currentSemanticsNodesInvalidated", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Landroidx/collection/IntObjectMap;", "paneDisplayed", "Landroidx/collection/MutableIntSet;", "idToBeforeMap", "Landroidx/collection/MutableIntIntMap;", "getIdToBeforeMap$ui_release", "()Landroidx/collection/MutableIntIntMap;", "setIdToBeforeMap$ui_release", "(Landroidx/collection/MutableIntIntMap;)V", "idToAfterMap", "getIdToAfterMap$ui_release", "setIdToAfterMap$ui_release", "ExtraDataTestTraversalBeforeVal", "", "getExtraDataTestTraversalBeforeVal$ui_release", "()Ljava/lang/String;", "ExtraDataTestTraversalAfterVal", "getExtraDataTestTraversalAfterVal$ui_release", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "checkingForSemanticsChanges", "drawingOrder", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "canScroll-moWRBKg", "(Landroidx/collection/IntObjectMap;ZIJ)Z", "isRequestFromAccessibilityTool", "createNodeInfo", "virtualViewId", "emptyNodeInfoOrNull", "boundsInScreen", "Landroid/graphics/Rect;", "node", "populateAccessibilityNodeInfoProperties", "info", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "setContentInvalid", "toSpannableString", "Landroid/text/SpannableString;", "Landroidx/compose/ui/text/AnnotatedString;", "setText", "isAccessibilityFocused", "requestAccessibilityFocus", "sendEventForVirtualView", "eventType", "contentChangeType", SdkConstants.ATTR_CONTENT_DESCRIPTION, "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendEvent", NotificationCompat.CATEGORY_EVENT, "createEvent", "createTextSelectionChangedEvent", "fromIndex", "toIndex", SdkConstants.ATTR_ITEM_COUNT, "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "clearAccessibilityFocus", "performActionHelper", "action", "arguments", "Landroid/os/Bundle;", "addExtraDataToAccessibilityNodeInfoHelper", "extraDataKey", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "Landroidx/compose/ui/graphics/Shape;", "toAndroidRect", "toCornerArray", "", "toRegion", "Landroid/graphics/Region;", "dispatchHoverEvent", "Landroid/view/MotionEvent;", "dispatchHoverEvent$ui_release", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "updateHoveredVirtualView", "getAccessibilityNodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", SdkConstants.ATTR_HOST, "Landroid/view/View;", "trimToSize", ExifInterface.GPS_DIRECTION_TRUE, ContentDisposition.Parameters.Size, "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "onSemanticsChange", "onSemanticsChange$ui_release", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLayoutChange", "layoutNode", "onLayoutChange$ui_release", "notifySubtreeAccessibilityStateChangedIfNeeded", "sendTypeViewScrolledAccessibilityEvent", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "checkForSemanticsChanges", "updateSemanticsNodesCopyAndPanes", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "scrollObservationScopes", "Landroidx/compose/ui/platform/ScrollObservationScope;", "scheduleScrollEventIfNeededLambda", "registerScrollingId", "id", "oldScrollObservationScopes", "scheduleScrollEventIfNeeded", "scrollObservationScope", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "semanticsNodeIdToAccessibilityVirtualNodeId", "traverseAtGranularity", "granularity", "forward", "extendSelection", "sendPendingTextTraversedAtGranularityEvent", "setAccessibilitySelection", "start", "end", "traversalMode", "getAccessibilitySelectionStart", "getAccessibilitySelectionEnd", "isAccessibilitySelectionExtendable", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "getIterableTextForAccessibility", "getTextForTextField", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Companion", "PendingTextTraversedEvent", "ComposeAccessibilityNodeProvider", "Api24Impl", "Api29Impl", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataShapeRectCornersKey = "androidx.compose.ui.semantics.shapeCorners";
    public static final String ExtraDataShapeRectKey = "androidx.compose.ui.semantics.shapeRect";
    public static final String ExtraDataShapeRegionKey = "androidx.compose.ui.semantics.shapeRegion";
    public static final int ExtraDataShapeTypeGeneric = 2;
    public static final String ExtraDataShapeTypeKey = "androidx.compose.ui.semantics.shapeType";
    public static final int ExtraDataShapeTypeRectangle = 0;
    public static final int ExtraDataShapeTypeRounded = 1;
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private final String ExtraDataTestTraversalAfterVal;
    private final String ExtraDataTestTraversalBeforeVal;
    private long SendRecurringAccessibilityEventsIntervalMillis;
    private int accessibilityCursorPosition;
    private int accessibilityFocusedVirtualViewId;
    private boolean accessibilityForceEnabledForTesting;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private AccessibilityNodeInfoCompat currentlyAccessibilityFocusedANI;
    private AccessibilityNodeInfoCompat currentlyFocusedANI;
    private final MutableIntIntMap drawingOrder;
    private List<AccessibilityServiceInfo> enabledServices;
    private final AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    private int focusedVirtualViewId;
    private final Handler handler;
    private MutableIntIntMap idToAfterMap;
    private MutableIntIntMap idToBeforeMap;
    private SparseArrayCompat<MutableObjectIntMap<CharSequence>> labelToActionId;
    private ComposeAccessibilityNodeProvider nodeProvider;
    private MutableIntSet paneDisplayed;
    private final MutableIntObjectMap<ScrollAxisRange> pendingHorizontalScrollEvents;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private final MutableIntObjectMap<ScrollAxisRange> pendingVerticalScrollEvents;
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private Boolean requestFromAccessibilityToolForTesting;
    private final Function1<ScrollObservationScope, Unit> scheduleScrollEventIfNeededLambda;
    private final List<ScrollObservationScope> scrollObservationScopes;
    private final Runnable semanticsChangeChecker;
    private boolean sendingFocusAffectingEvent;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;
    public static final int $stable = 8;
    private static final IntList AccessibilityActionsResourceIds = IntListKt.intListOf(R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31);
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private Function1<? super AccessibilityEvent, Boolean> onSendAccessibilityEvent = new Function1<AccessibilityEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AccessibilityEvent accessibilityEvent) {
            return Boolean.valueOf(this.this$0.getView().getParent().requestSendAccessibilityEvent(this.this$0.getView(), accessibilityEvent));
        }
    };

    public static /* synthetic */ void getHoveredVirtualViewId$ui_release$annotations() {
    }

    public static /* synthetic */ void getOnSendAccessibilityEvent$ui_release$annotations() {
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.view = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        android.view.accessibility.AccessibilityManager accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        this.accessibilityManager = accessibilityManager;
        this.SendRecurringAccessibilityEventsIntervalMillis = 100L;
        this.enabledStateListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z) {
                AndroidComposeViewAccessibilityDelegateCompat.enabledStateListener$lambda$0(this.f$0, z);
            }
        };
        this.touchExplorationStateListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                AndroidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener$lambda$1(this.f$0, z);
            }
        };
        this.enabledServices = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new ComposeAccessibilityNodeProvider();
        this.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.pendingHorizontalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.pendingVerticalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.actionIdToLabel = new SparseArrayCompat<>(0, 1, null);
        this.labelToActionId = new SparseArrayCompat<>(0, 1, null);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>(0, 1, null);
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.paneDisplayed = new MutableIntSet(0, 1, null);
        this.idToBeforeMap = new MutableIntIntMap(0, 1, null);
        this.idToAfterMap = new MutableIntIntMap(0, 1, null);
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        this.drawingOrder = IntIntMapKt.mutableIntIntMapOf();
        androidComposeView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                android.view.accessibility.AccessibilityManager accessibilityManager2 = AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                androidComposeViewAccessibilityDelegateCompat.enabledServices = androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1);
                accessibilityManager2.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                accessibilityManager2.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                AndroidComposeViewAccessibilityDelegateCompat.this.handler.removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.this.semanticsChangeChecker);
                android.view.accessibility.AccessibilityManager accessibilityManager2 = AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                accessibilityManager2.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                accessibilityManager2.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }
        });
        this.semanticsChangeChecker = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker$lambda$50(this.f$0);
            }
        };
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new Function1<ScrollObservationScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollObservationScope scrollObservationScope) {
                invoke2(scrollObservationScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollObservationScope scrollObservationScope) {
                this.this$0.scheduleScrollEventIfNeeded(scrollObservationScope);
            }
        };
    }

    /* renamed from: getHoveredVirtualViewId$ui_release, reason: from getter */
    public final int getHoveredVirtualViewId() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final Function1<AccessibilityEvent, Boolean> getOnSendAccessibilityEvent$ui_release() {
        return this.onSendAccessibilityEvent;
    }

    public final void setOnSendAccessibilityEvent$ui_release(Function1<? super AccessibilityEvent, Boolean> function1) {
        this.onSendAccessibilityEvent = function1;
    }

    /* renamed from: getAccessibilityForceEnabledForTesting$ui_release, reason: from getter */
    public final boolean getAccessibilityForceEnabledForTesting() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
        this.currentSemanticsNodesInvalidated = true;
    }

    /* renamed from: getSendRecurringAccessibilityEventsIntervalMillis$ui_release, reason: from getter */
    public final long getSendRecurringAccessibilityEventsIntervalMillis() {
        return this.SendRecurringAccessibilityEventsIntervalMillis;
    }

    public final void setSendRecurringAccessibilityEventsIntervalMillis$ui_release(long j) {
        this.SendRecurringAccessibilityEventsIntervalMillis = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z) {
        List<AccessibilityServiceInfo> listEmptyList;
        if (z) {
            listEmptyList = androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        androidComposeViewAccessibilityDelegateCompat.enabledServices = listEmptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchExplorationStateListener$lambda$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z) {
        androidComposeViewAccessibilityDelegateCompat.enabledServices = androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1);
    }

    public final boolean isEnabled$ui_release() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && !this.enabledServices.isEmpty());
    }

    private final boolean isTouchExplorationEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    /* renamed from: getRequestFromAccessibilityToolForTesting$ui_release, reason: from getter */
    public final Boolean getRequestFromAccessibilityToolForTesting() {
        return this.requestFromAccessibilityToolForTesting;
    }

    public final void setRequestFromAccessibilityToolForTesting$ui_release(Boolean bool) {
        this.requestFromAccessibilityToolForTesting = bool;
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getAction", "()I", "getGranularity", "getFromIndex", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int i, int i2, int i3, int i4, long j) {
            this.node = semanticsNode;
            this.action = i;
            this.granularity = i2;
            this.fromIndex = i3;
            this.toIndex = i4;
            this.traverseTime = j;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsOwnerKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner(), -1);
            if (isEnabled$ui_release()) {
                AndroidComposeViewAccessibilityDelegateCompat_androidKt.setTraversalValues(this.currentSemanticsNodes, this.idToBeforeMap, this.idToAfterMap, this.view.getContext().getResources());
            }
        }
        return this.currentSemanticsNodes;
    }

    /* renamed from: getIdToBeforeMap$ui_release, reason: from getter */
    public final MutableIntIntMap getIdToBeforeMap() {
        return this.idToBeforeMap;
    }

    public final void setIdToBeforeMap$ui_release(MutableIntIntMap mutableIntIntMap) {
        this.idToBeforeMap = mutableIntIntMap;
    }

    /* renamed from: getIdToAfterMap$ui_release, reason: from getter */
    public final MutableIntIntMap getIdToAfterMap() {
        return this.idToAfterMap;
    }

    public final void setIdToAfterMap$ui_release(MutableIntIntMap mutableIntIntMap) {
        this.idToAfterMap = mutableIntIntMap;
    }

    /* renamed from: getExtraDataTestTraversalBeforeVal$ui_release, reason: from getter */
    public final String getExtraDataTestTraversalBeforeVal() {
        return this.ExtraDataTestTraversalBeforeVal;
    }

    /* renamed from: getExtraDataTestTraversalAfterVal$ui_release, reason: from getter */
    public final String getExtraDataTestTraversalAfterVal() {
        return this.ExtraDataTestTraversalAfterVal;
    }

    /* renamed from: canScroll-0AR0LA0$ui_release, reason: not valid java name */
    public final boolean m6366canScroll0AR0LA0$ui_release(boolean vertical, int direction, long position) {
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return m6365canScrollmoWRBKg(getCurrentSemanticsNodes(), vertical, direction, position);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00df  */
    /* renamed from: canScroll-moWRBKg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean m6365canScrollmoWRBKg(androidx.collection.IntObjectMap<androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds> r21, boolean r22, int r23, long r24) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.m6365canScrollmoWRBKg(androidx.collection.IntObjectMap, boolean, int, long):boolean");
    }

    private final boolean isRequestFromAccessibilityTool() {
        Boolean bool = this.requestFromAccessibilityToolForTesting;
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) bool, (Object) false)) {
            return false;
        }
        return AccessibilityManagerCompat.isRequestFromAccessibilityTool(this.accessibilityManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfoCompat createNodeInfo(int virtualViewId) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = this.view.getViewTreeOwners();
        if (((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getState()) == Lifecycle.State.DESTROYED) {
            return emptyNodeInfoOrNull();
        }
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null) {
            return emptyNodeInfoOrNull();
        }
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
        boolean zAreEqual = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getIsSensitiveData()), (Object) true);
        if (zAreEqual && !isRequestFromAccessibilityTool()) {
            return null;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain();
        accessibilityNodeInfoCompatObtain.setAccessibilityDataSensitive(zAreEqual);
        if (virtualViewId == -1) {
            ViewParent parentForAccessibility = this.view.getParentForAccessibility();
            accessibilityNodeInfoCompatObtain.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else {
            SemanticsNode parent = semanticsNode.getParent();
            Integer numValueOf = parent != null ? Integer.valueOf(parent.getId()) : null;
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                accessibilityNodeInfoCompatObtain.setParent(this.view, iIntValue != this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId() ? iIntValue : -1);
            } else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + virtualViewId + " has null parent");
                throw new KotlinNothingValueException();
            }
        }
        accessibilityNodeInfoCompatObtain.setSource(this.view, virtualViewId);
        accessibilityNodeInfoCompatObtain.setBoundsInScreen(boundsInScreen(semanticsNodeWithAdjustedBounds));
        populateAccessibilityNodeInfoProperties(virtualViewId, accessibilityNodeInfoCompatObtain, semanticsNode);
        return accessibilityNodeInfoCompatObtain;
    }

    private final AccessibilityNodeInfoCompat emptyNodeInfoOrNull() {
        if (this.accessibilityManager.isEnabled()) {
            return null;
        }
        return AccessibilityNodeInfoCompat.obtain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect boundsInScreen(SemanticsNodeWithAdjustedBounds node) {
        IntRect adjustedBounds = node.getAdjustedBounds();
        AndroidComposeView androidComposeView = this.view;
        float left = adjustedBounds.getLeft();
        float top = adjustedBounds.getTop();
        long jMo5909localToScreenMKHz9U = androidComposeView.mo5909localToScreenMKHz9U(Offset.m4286constructorimpl((Float.floatToRawIntBits(top) & 4294967295L) | (Float.floatToRawIntBits(left) << 32)));
        AndroidComposeView androidComposeView2 = this.view;
        float right = adjustedBounds.getRight();
        float bottom = adjustedBounds.getBottom();
        long jMo5909localToScreenMKHz9U2 = androidComposeView2.mo5909localToScreenMKHz9U(Offset.m4286constructorimpl((Float.floatToRawIntBits(right) << 32) | (Float.floatToRawIntBits(bottom) & 4294967295L)));
        int i = (int) (jMo5909localToScreenMKHz9U >> 32);
        int i2 = (int) (jMo5909localToScreenMKHz9U2 >> 32);
        int i3 = (int) (jMo5909localToScreenMKHz9U & 4294967295L);
        int i4 = (int) (jMo5909localToScreenMKHz9U2 & 4294967295L);
        return new Rect((int) Math.floor(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.floor(Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))));
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x066a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void populateAccessibilityNodeInfoProperties(int r23, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r24, androidx.compose.ui.semantics.SemanticsNode r25) {
        /*
            Method dump skipped, instructions count: 2670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties(int, androidx.core.view.accessibility.AccessibilityNodeInfoCompat, androidx.compose.ui.semantics.SemanticsNode):void");
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && scrollAxisRange.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && scrollAxisRange.getReverseScrolling());
    }

    private final void setContentInvalid(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getError())) {
            info.setContentInvalid(true);
            info.setError((CharSequence) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final SpannableString toSpannableString(AnnotatedString annotatedString) {
        return (SpannableString) trimToSize(AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), this.view.getFontFamilyResolver(), this.urlSpanCache), 100000);
    }

    private final void setText(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        AnnotatedString infoText = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoText(node);
        info.setText(infoText != null ? toSpannableString(infoText) : null);
    }

    private final boolean isAccessibilityFocused(int virtualViewId) {
        return this.accessibilityFocusedVirtualViewId == virtualViewId;
    }

    private final boolean requestAccessibilityFocus(int virtualViewId) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        int i = this.accessibilityFocusedVirtualViewId;
        if (i != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, i, 65536, null, null, 12, null);
        }
        this.accessibilityFocusedVirtualViewId = virtualViewId;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 32768, null, null, 12, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int virtualViewId, int eventType, Integer contentChangeType, List<String> contentDescription) {
        if (virtualViewId == Integer.MIN_VALUE || !isEnabled$ui_release()) {
            return false;
        }
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(virtualViewId, eventType);
        if (contentChangeType != null) {
            accessibilityEventCreateEvent.setContentChangeTypes(contentChangeType.intValue());
        }
        if (contentDescription != null) {
            accessibilityEventCreateEvent.setContentDescription(ListUtilsKt.fastJoinToString$default(contentDescription, ",", null, null, 0, null, null, 62, null));
        }
        return sendEvent(accessibilityEventCreateEvent);
    }

    private final boolean sendEvent(AccessibilityEvent event) {
        if (!isEnabled$ui_release()) {
            return false;
        }
        if (event.getEventType() == 2048 || event.getEventType() == 32768) {
            this.sendingFocusAffectingEvent = true;
        }
        try {
            return this.onSendAccessibilityEvent.invoke(event).booleanValue();
        } finally {
            this.sendingFocusAffectingEvent = false;
        }
    }

    private final AccessibilityEvent createEvent(int virtualViewId, int eventType) {
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(eventType);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setClassName("android.view.View");
        accessibilityEventObtain.setPackageName(this.view.getContext().getPackageName());
        accessibilityEventObtain.setSource(this.view, virtualViewId);
        if (isEnabled$ui_release() && (semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId)) != null) {
            accessibilityEventObtain.setPassword(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword()));
            AccessibilityEventCompat.setAccessibilityDataSensitive(accessibilityEventObtain, Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig(), SemanticsProperties.INSTANCE.getIsSensitiveData()), (Object) true));
        }
        return accessibilityEventObtain;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int virtualViewId, Integer fromIndex, Integer toIndex, Integer itemCount, CharSequence text) {
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(virtualViewId, 8192);
        if (fromIndex != null) {
            accessibilityEventCreateEvent.setFromIndex(fromIndex.intValue());
        }
        if (toIndex != null) {
            accessibilityEventCreateEvent.setToIndex(toIndex.intValue());
        }
        if (itemCount != null) {
            accessibilityEventCreateEvent.setItemCount(itemCount.intValue());
        }
        if (text != null) {
            accessibilityEventCreateEvent.getText().add(text);
        }
        return accessibilityEventCreateEvent;
    }

    private final boolean clearAccessibilityFocus(int virtualViewId) {
        if (!isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        this.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.currentlyAccessibilityFocusedANI = null;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 65536, null, null, 12, null);
        return true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:96:0x01c8
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01c7 -> B:96:0x01c8). Please report as a decompilation issue!!! */
    public final boolean performActionHelper(int r16, int r17, android.os.Bundle r18) {
        /*
            Method dump skipped, instructions count: 2016
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.performActionHelper(int, int, android.os.Bundle):boolean");
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f) {
        return (f < 0.0f && scrollAxisRange.getValue().invoke().floatValue() > 0.0f) || (f > 0.0f && scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float f, float f2) {
        if (Math.signum(f) == Math.signum(f2)) {
            return Math.abs(f) < Math.abs(f2) ? f : f2;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
        SemanticsNode semanticsNode;
        Region region;
        float[] cornerArray;
        Rect androidRect;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalBeforeVal)) {
            int orDefault = this.idToBeforeMap.getOrDefault(virtualViewId, -1);
            if (orDefault != -1) {
                info.getExtras().putInt(extraDataKey, orDefault);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalAfterVal)) {
            int orDefault2 = this.idToAfterMap.getOrDefault(virtualViewId, -1);
            if (orDefault2 != -1) {
                info.getExtras().putInt(extraDataKey, orDefault2);
                return;
            }
            return;
        }
        if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && arguments != null && Intrinsics.areEqual(extraDataKey, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY)) {
            int i = arguments.getInt(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX, -1);
            int i2 = arguments.getInt(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH, -1);
            if (i2 > 0 && i >= 0) {
                if (i < (iterableTextForAccessibility != null ? iterableTextForAccessibility.length() : Integer.MAX_VALUE)) {
                    TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(semanticsNode.getUnmergedConfig());
                    if (textLayoutResult == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = i + i3;
                        if (i4 >= textLayoutResult.getLayoutInput().getText().length()) {
                            arrayList.add(null);
                        } else {
                            arrayList.add(toScreenCoords(semanticsNode, textLayoutResult.getBoundingBox(i4)));
                        }
                    }
                    info.getExtras().putParcelableArray(extraDataKey, (Parcelable[]) arrayList.toArray(new RectF[0]));
                    return;
                }
            }
            Log.e(LogTag, "Invalid arguments for accessibility character locations");
            return;
        }
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag()) && arguments != null && Intrinsics.areEqual(extraDataKey, ExtraDataTestTagKey)) {
            String str = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag());
            if (str != null) {
                info.getExtras().putCharSequence(extraDataKey, str);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataIdKey)) {
            info.getExtras().putInt(extraDataKey, semanticsNode.getId());
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataShapeTypeKey)) {
            Shape shape = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getShape());
            if (shape != null) {
                Outline outlineCreateOutline = createOutline(shape, semanticsNode);
                if (outlineCreateOutline instanceof Outline.Rectangle) {
                    info.getExtras().putInt(ExtraDataShapeTypeKey, 0);
                    info.getExtras().putParcelable(ExtraDataShapeRectKey, toAndroidRect(outlineCreateOutline));
                    return;
                } else if (outlineCreateOutline instanceof Outline.Rounded) {
                    info.getExtras().putInt(ExtraDataShapeTypeKey, 1);
                    info.getExtras().putParcelable(ExtraDataShapeRectKey, toAndroidRect(outlineCreateOutline));
                    info.getExtras().putFloatArray(ExtraDataShapeRectCornersKey, toCornerArray(outlineCreateOutline));
                    return;
                } else {
                    if (outlineCreateOutline instanceof Outline.Generic) {
                        info.getExtras().putInt(ExtraDataShapeTypeKey, 2);
                        info.getExtras().putParcelable(ExtraDataShapeRegionKey, toRegion(outlineCreateOutline));
                        return;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataShapeRectKey)) {
            Shape shape2 = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getShape());
            if (shape2 == null || (androidRect = toAndroidRect(createOutline(shape2, semanticsNode))) == null) {
                return;
            }
            info.getExtras().putParcelable(ExtraDataShapeRectKey, androidRect);
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataShapeRectCornersKey)) {
            Shape shape3 = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getShape());
            if (shape3 == null || (cornerArray = toCornerArray(createOutline(shape3, semanticsNode))) == null) {
                return;
            }
            info.getExtras().putFloatArray(ExtraDataShapeRectCornersKey, cornerArray);
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataShapeRegionKey)) {
            Shape shape4 = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getShape());
            if (shape4 == null || (region = toRegion(createOutline(shape4, semanticsNode))) == null) {
                return;
            }
            info.getExtras().putParcelable(ExtraDataShapeRegionKey, region);
            return;
        }
        ScatterSet<SemanticsPropertyKey<?>> accessibilityExtraKeys$ui_release = semanticsNode.getUnmergedConfig().getAccessibilityExtraKeys$ui_release();
        if (accessibilityExtraKeys$ui_release == null) {
            return;
        }
        Object[] objArr = accessibilityExtraKeys$ui_release.elements;
        long[] jArr = accessibilityExtraKeys$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j = jArr[i5];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j) < 128) {
                        SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) objArr[(i5 << 3) + i7];
                        String accessibilityExtraKey = semanticsPropertyKey.getAccessibilityExtraKey();
                        if (Intrinsics.areEqual(accessibilityExtraKey, extraDataKey)) {
                            Object orNull = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsPropertyKey);
                            if (orNull instanceof Serializable) {
                                info.getExtras().putSerializable(accessibilityExtraKey, (Serializable) orNull);
                            } else {
                                if (!(orNull instanceof Parcelable)) {
                                    throw new IllegalStateException("Accessibility extra values must be either Serializable or Parcelable.");
                                }
                                info.getExtras().putParcelable(accessibilityExtraKey, (Parcelable) orNull);
                            }
                        } else {
                            continue;
                        }
                    }
                    j >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    private final RectF toScreenCoords(SemanticsNode textNode, androidx.compose.ui.geometry.Rect bounds) {
        if (textNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect rectM4331translatek4lQ0M = bounds.m4331translatek4lQ0M(textNode.m6474getPositionInRootF1C5BW0());
        androidx.compose.ui.geometry.Rect boundsInRoot = textNode.getBoundsInRoot();
        androidx.compose.ui.geometry.Rect rectIntersect = rectM4331translatek4lQ0M.overlaps(boundsInRoot) ? rectM4331translatek4lQ0M.intersect(boundsInRoot) : null;
        if (rectIntersect == null) {
            return null;
        }
        AndroidComposeView androidComposeView = this.view;
        float left = rectIntersect.getLeft();
        long jMo5909localToScreenMKHz9U = androidComposeView.mo5909localToScreenMKHz9U(Offset.m4286constructorimpl((Float.floatToRawIntBits(rectIntersect.getTop()) & 4294967295L) | (Float.floatToRawIntBits(left) << 32)));
        long jMo5909localToScreenMKHz9U2 = this.view.mo5909localToScreenMKHz9U(Offset.m4286constructorimpl((Float.floatToRawIntBits(rectIntersect.getRight()) << 32) | (Float.floatToRawIntBits(rectIntersect.getBottom()) & 4294967295L)));
        int i = (int) (jMo5909localToScreenMKHz9U >> 32);
        int i2 = (int) (jMo5909localToScreenMKHz9U2 >> 32);
        int i3 = (int) (jMo5909localToScreenMKHz9U & 4294967295L);
        int i4 = (int) (jMo5909localToScreenMKHz9U2 & 4294967295L);
        return new RectF(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)));
    }

    private final Outline createOutline(Shape shape, SemanticsNode semanticsNode) {
        return shape.mo588createOutlinePq9zytI(IntSizeKt.m7438toSizeozmzZPI(semanticsNode.m6477getSizeYbymL2g()), semanticsNode.getLayoutInfo().getLayoutDirection(), this.view.getDensity());
    }

    private final Rect toAndroidRect(Outline outline) {
        if ((outline instanceof Outline.Rectangle) || (outline instanceof Outline.Rounded)) {
            return toAndroidRect(outline.getRect());
        }
        return null;
    }

    private final float[] toCornerArray(Outline outline) {
        if (!(outline instanceof Outline.Rounded)) {
            return null;
        }
        Outline.Rounded rounded = (Outline.Rounded) outline;
        return new float[]{Float.intBitsToFloat((int) (rounded.getRoundRect().m4344getTopLeftCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m4344getTopLeftCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (rounded.getRoundRect().m4345getTopRightCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m4345getTopRightCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (rounded.getRoundRect().m4343getBottomRightCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m4343getBottomRightCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (rounded.getRoundRect().m4342getBottomLeftCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m4342getBottomLeftCornerRadiuskKHJgLs() & 4294967295L))};
    }

    private final Region toRegion(Outline outline) {
        if (!(outline instanceof Outline.Generic)) {
            return null;
        }
        Outline.Generic generic = (Outline.Generic) outline;
        Region region = new Region(toAndroidRect(generic.getRect()));
        Region region2 = new Region();
        Path path = generic.getPath();
        if (path instanceof AndroidPath) {
            region2.setPath(((AndroidPath) path).getInternalPath(), region);
            return region2;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    private final Rect toAndroidRect(androidx.compose.ui.geometry.Rect rect) {
        return new Rect((int) rect.getLeft(), (int) rect.getTop(), (int) rect.getRight(), (int) rect.getBottom());
    }

    public final boolean dispatchHoverEvent$ui_release(MotionEvent event) {
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        int action = event.getAction();
        if (action == 7 || action == 9) {
            int iHitTestSemanticsAt$ui_release = hitTestSemanticsAt$ui_release(event.getX(), event.getY());
            boolean zDispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
            updateHoveredVirtualView(iHitTestSemanticsAt$ui_release);
            if (iHitTestSemanticsAt$ui_release == Integer.MIN_VALUE) {
                return zDispatchGenericMotionEvent;
            }
            return true;
        }
        if (action != 10) {
            return false;
        }
        if (this.hoveredVirtualViewId != Integer.MIN_VALUE) {
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
        return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
    }

    public final int hitTestSemanticsAt$ui_release(float x, float y) {
        int iSemanticsNodeIdToAccessibilityVirtualNodeId;
        Owner.measureAndLayout$default(this.view, false, 1, null);
        HitTestResult hitTestResult = new HitTestResult();
        LayoutNode.m6151hitTestSemantics6fMxITs$ui_release$default(this.view.getRoot(), Offset.m4286constructorimpl((Float.floatToRawIntBits(y) & 4294967295L) | (Float.floatToRawIntBits(x) << 32)), hitTestResult, 0, false, 12, null);
        int lastIndex = CollectionsKt.getLastIndex(hitTestResult);
        while (true) {
            iSemanticsNodeIdToAccessibilityVirtualNodeId = Integer.MIN_VALUE;
            if (-1 >= lastIndex) {
                break;
            }
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(hitTestResult.get(lastIndex));
            if (this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNodeRequireLayoutNode) != null) {
                return Integer.MIN_VALUE;
            }
            if (layoutNodeRequireLayoutNode.getNodes().m6209hasH91voCI$ui_release(NodeKind.m6248constructorimpl(8))) {
                iSemanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(layoutNodeRequireLayoutNode.getSemanticsId());
                SemanticsNode SemanticsNode = SemanticsNodeKt.SemanticsNode(layoutNodeRequireLayoutNode, false);
                if (SemanticsOwnerKt.isImportantForAccessibility(SemanticsNode) && !SemanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getLinkTestMarker())) {
                    break;
                }
            }
            lastIndex--;
        }
        return iSemanticsNodeIdToAccessibilityVirtualNodeId;
    }

    private final void updateHoveredVirtualView(int virtualViewId) {
        int i = this.hoveredVirtualViewId;
        if (i == virtualViewId) {
            return;
        }
        this.hoveredVirtualViewId = virtualViewId;
        sendEventForVirtualView$default(this, virtualViewId, 128, null, null, 12, null);
        sendEventForVirtualView$default(this, i, 256, null, null, 12, null);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T text, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size should be greater than 0".toString());
        }
        if (text == null || text.length() == 0 || text.length() <= size) {
            return text;
        }
        int i = size - 1;
        if (Character.isHighSurrogate(text.charAt(i)) && Character.isLowSurrogate(text.charAt(size))) {
            size = i;
        }
        T t = (T) text.subSequence(0, size);
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void semanticsChangeChecker$lambda$50(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Trace.beginSection("measureAndLayout");
        try {
            Owner.measureAndLayout$default(androidComposeViewAccessibilityDelegateCompat.view, false, 1, null);
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("checkForSemanticsChanges");
            try {
                androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
            } finally {
            }
        } finally {
        }
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release() || this.checkingForSemanticsChanges) {
            return;
        }
        this.checkingForSemanticsChanges = true;
        this.handler.post(this.semanticsChangeChecker);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072 A[Catch: all -> 0x00cd, TryCatch #0 {all -> 0x00cd, blocks: (B:13:0x0032, B:22:0x005a, B:26:0x006a, B:28:0x0072, B:30:0x007b, B:32:0x0086, B:33:0x0097, B:35:0x009e, B:36:0x00a7, B:18:0x0047, B:21:0x004e), top: B:44:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c2 -> B:14:0x0035). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo10590trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendTypeViewScrolledAccessibilityEvent(LayoutNode layoutNode) {
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int semanticsId = layoutNode.getSemanticsId();
            ScrollAxisRange scrollAxisRange = this.pendingHorizontalScrollEvents.get(semanticsId);
            ScrollAxisRange scrollAxisRange2 = this.pendingVerticalScrollEvents.get(semanticsId);
            if (scrollAxisRange == null && scrollAxisRange2 == null) {
                return;
            }
            AccessibilityEvent accessibilityEventCreateEvent = createEvent(semanticsId, 4096);
            if (scrollAxisRange != null) {
                accessibilityEventCreateEvent.setScrollX((int) scrollAxisRange.getValue().invoke().floatValue());
                accessibilityEventCreateEvent.setMaxScrollX((int) scrollAxisRange.getMaxValue().invoke().floatValue());
            }
            if (scrollAxisRange2 != null) {
                accessibilityEventCreateEvent.setScrollY((int) scrollAxisRange2.getValue().invoke().floatValue());
                accessibilityEventCreateEvent.setMaxScrollY((int) scrollAxisRange2.getMaxValue().invoke().floatValue());
            }
            sendEvent(accessibilityEventCreateEvent);
        }
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, MutableIntSet subtreeChangedSemanticsNodesIds) {
        SemanticsConfiguration semanticsConfiguration;
        LayoutNode layoutNodeFindClosestParentNode;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            if (!layoutNode.getNodes().m6209hasH91voCI$ui_release(NodeKind.m6248constructorimpl(8))) {
                layoutNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(LayoutNode layoutNode2) {
                        return Boolean.valueOf(layoutNode2.getNodes().m6209hasH91voCI$ui_release(NodeKind.m6248constructorimpl(8)));
                    }
                });
            }
            if (layoutNode == null || (semanticsConfiguration = layoutNode.getSemanticsConfiguration()) == null) {
                return;
            }
            if (!semanticsConfiguration.getIsMergingSemanticsOfDescendants() && (layoutNodeFindClosestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSubtreeChangeAccessibilityEvents.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode layoutNode2) {
                    SemanticsConfiguration semanticsConfiguration2 = layoutNode2.getSemanticsConfiguration();
                    boolean z = false;
                    if (semanticsConfiguration2 != null && semanticsConfiguration2.getIsMergingSemanticsOfDescendants()) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            })) != null) {
                layoutNode = layoutNodeFindClosestParentNode;
            }
            if (layoutNode != null) {
                int semanticsId = layoutNode.getSemanticsId();
                if (subtreeChangedSemanticsNodesIds.add(semanticsId)) {
                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsId), 2048, 1, null, 8, null);
                }
            }
        }
    }

    private final void checkForSemanticsChanges() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (isEnabled$ui_release()) {
                sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    updateSemanticsNodesCopyAndPanes();
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateSemanticsNodesCopyAndPanes() {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.updateSemanticsNodesCopyAndPanes():void");
    }

    private final void sendSemanticsPropertyChangeEvents(IntObjectMap<SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        ArrayList arrayList;
        int[] iArr;
        long[] jArr;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList2;
        int[] iArr2;
        long[] jArr2;
        int i6;
        int i7;
        int i8;
        int i9;
        SemanticsNode semanticsNode;
        int i10;
        boolean zPropertiesDeleted;
        long[] jArr3;
        Object[] objArr;
        int i11;
        Object[] objArr2;
        long[] jArr4;
        Object[] objArr3;
        int i12;
        ArrayList arrayList3;
        int i13;
        Object[] objArr4;
        int i14;
        int i15;
        SemanticsNode semanticsNode2;
        int i16;
        String text;
        AccessibilityEvent accessibilityEventCreateTextSelectionChangedEvent;
        boolean zSendEventForVirtualView$default;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap = newSemanticsNodes;
        ArrayList arrayList4 = new ArrayList(this.scrollObservationScopes);
        this.scrollObservationScopes.clear();
        int[] iArr3 = intObjectMap.keys;
        long[] jArr5 = intObjectMap.metadata;
        int i17 = 2;
        int length = jArr5.length - 2;
        if (length < 0) {
            return;
        }
        int i18 = 0;
        while (true) {
            long j = jArr5[i18];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i19 = 8;
                int i20 = 8 - ((~(i18 - length)) >>> 31);
                long j2 = j;
                int i21 = 0;
                while (i21 < i20) {
                    if ((j2 & 255) < 128) {
                        int i22 = iArr3[(i18 << 3) + i21];
                        SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(i22);
                        if (semanticsNodeCopy == null) {
                            i4 = i21;
                            i5 = i20;
                            arrayList2 = arrayList4;
                            iArr2 = iArr3;
                            jArr2 = jArr5;
                            i6 = length;
                            i7 = i18;
                            i8 = i17;
                        } else {
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = intObjectMap.get(i22);
                            SemanticsNode semanticsNode3 = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                            if (semanticsNode3 != null) {
                                MutableScatterMap<SemanticsPropertyKey<?>, Object> props$ui_release = semanticsNode3.getUnmergedConfig().getProps$ui_release();
                                Object[] objArr5 = props$ui_release.keys;
                                Object[] objArr6 = props$ui_release.values;
                                long[] jArr6 = props$ui_release.metadata;
                                int length2 = jArr6.length - i17;
                                if (length2 >= 0) {
                                    i4 = i21;
                                    int i23 = i20;
                                    int i24 = 0;
                                    zPropertiesDeleted = false;
                                    while (true) {
                                        long j3 = jArr6[i24];
                                        iArr2 = iArr3;
                                        jArr2 = jArr5;
                                        if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i25 = 8 - ((~(i24 - length2)) >>> 31);
                                            long j4 = j3;
                                            int i26 = 0;
                                            while (i26 < i25) {
                                                if ((j4 & 255) < 128) {
                                                    int i27 = (i24 << 3) + i26;
                                                    Object obj = objArr5[i27];
                                                    Object obj2 = objArr6[i27];
                                                    SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) obj;
                                                    long[] jArr7 = jArr6;
                                                    if (((Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) || Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) ? registerScrollingId(i22, arrayList4) : false) || !Intrinsics.areEqual(obj2, SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), semanticsPropertyKey))) {
                                                        if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getPaneTitle())) {
                                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                                                            String str = (String) obj2;
                                                            if (semanticsNodeCopy.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                                                sendPaneChangeEvents(i22, 8, str);
                                                            }
                                                            Unit unit = Unit.INSTANCE;
                                                        } else {
                                                            if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getStateDescription()) || Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getToggleableState())) {
                                                                objArr3 = objArr5;
                                                                i12 = length2;
                                                                i13 = length;
                                                                objArr4 = objArr6;
                                                                i14 = i18;
                                                                i15 = i23;
                                                                jArr4 = jArr7;
                                                                semanticsNode2 = semanticsNode3;
                                                                arrayList3 = arrayList4;
                                                                i16 = i22;
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i16), 2048, 64, null, 8, null);
                                                                Boolean.valueOf(sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i16), 2048, 0, null, 8, null));
                                                            } else {
                                                                if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getProgressBarRangeInfo())) {
                                                                    jArr4 = jArr7;
                                                                    objArr3 = objArr5;
                                                                    int i28 = i22;
                                                                    i15 = i23;
                                                                    semanticsNode2 = semanticsNode3;
                                                                    i12 = length2;
                                                                    arrayList3 = arrayList4;
                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i22), 2048, 64, null, 8, null);
                                                                    i16 = i28;
                                                                    Boolean.valueOf(sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, 0, null, 8, null));
                                                                } else {
                                                                    objArr3 = objArr5;
                                                                    i12 = length2;
                                                                    i15 = i23;
                                                                    jArr4 = jArr7;
                                                                    semanticsNode2 = semanticsNode3;
                                                                    arrayList3 = arrayList4;
                                                                    i16 = i22;
                                                                    if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getSelected())) {
                                                                        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
                                                                        if (role == null ? false : Role.m6460equalsimpl0(role.getValue(), Role.INSTANCE.m6471getTabo7Vup1c())) {
                                                                            if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected()), (Object) true)) {
                                                                                AccessibilityEvent accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i16), 4);
                                                                                SemanticsNode semanticsNodeCopyWithMergingEnabled$ui_release = semanticsNode2.copyWithMergingEnabled$ui_release();
                                                                                List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopyWithMergingEnabled$ui_release.getConfig(), SemanticsProperties.INSTANCE.getContentDescription());
                                                                                String strFastJoinToString$default = list != null ? ListUtilsKt.fastJoinToString$default(list, ",", null, null, 0, null, null, 62, null) : null;
                                                                                List list2 = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopyWithMergingEnabled$ui_release.getConfig(), SemanticsProperties.INSTANCE.getText());
                                                                                String strFastJoinToString$default2 = list2 != null ? ListUtilsKt.fastJoinToString$default(list2, ",", null, null, 0, null, null, 62, null) : null;
                                                                                if (strFastJoinToString$default != null) {
                                                                                    accessibilityEventCreateEvent.setContentDescription(strFastJoinToString$default);
                                                                                    Unit unit2 = Unit.INSTANCE;
                                                                                    Unit unit3 = Unit.INSTANCE;
                                                                                }
                                                                                if (strFastJoinToString$default2 != null) {
                                                                                    Boolean.valueOf(accessibilityEventCreateEvent.getText().add(strFastJoinToString$default2));
                                                                                }
                                                                                zSendEventForVirtualView$default = sendEvent(accessibilityEventCreateEvent);
                                                                            } else {
                                                                                zSendEventForVirtualView$default = sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i16), 2048, 0, null, 8, null);
                                                                            }
                                                                        } else {
                                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i16), 2048, 64, null, 8, null);
                                                                            zSendEventForVirtualView$default = sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i16), 2048, 0, null, 8, null);
                                                                        }
                                                                        Boolean.valueOf(zSendEventForVirtualView$default);
                                                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getContentDescription())) {
                                                                        int iSemanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(i16);
                                                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                                                        Boolean.valueOf(sendEventForVirtualView(iSemanticsNodeIdToAccessibilityVirtualNodeId, 2048, 4, (List) obj2));
                                                                    } else {
                                                                        String str2 = "";
                                                                        if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getEditableText())) {
                                                                            if (semanticsNode2.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetText())) {
                                                                                AnnotatedString textForTextField = getTextForTextField(semanticsNodeCopy.getUnmergedConfig());
                                                                                String str3 = textForTextField != null ? textForTextField : "";
                                                                                AnnotatedString textForTextField2 = getTextForTextField(semanticsNode2.getUnmergedConfig());
                                                                                String str4 = textForTextField2 != null ? textForTextField2 : "";
                                                                                CharSequence charSequenceTrimToSize = trimToSize(str4, 100000);
                                                                                int length3 = str3.length();
                                                                                int length4 = str4.length();
                                                                                int iCoerceAtMost = RangesKt.coerceAtMost(length3, length4);
                                                                                int i29 = 0;
                                                                                while (true) {
                                                                                    if (i29 >= iCoerceAtMost) {
                                                                                        i13 = length;
                                                                                        objArr4 = objArr6;
                                                                                        break;
                                                                                    }
                                                                                    objArr4 = objArr6;
                                                                                    i13 = length;
                                                                                    if (str3.charAt(i29) != str4.charAt(i29)) {
                                                                                        break;
                                                                                    }
                                                                                    i29++;
                                                                                    objArr6 = objArr4;
                                                                                    length = i13;
                                                                                }
                                                                                int i30 = 0;
                                                                                while (i30 < iCoerceAtMost - i29) {
                                                                                    int i31 = iCoerceAtMost;
                                                                                    if (str3.charAt((length3 - 1) - i30) != str4.charAt((length4 - 1) - i30)) {
                                                                                        break;
                                                                                    }
                                                                                    i30++;
                                                                                    iCoerceAtMost = i31;
                                                                                }
                                                                                int i32 = (length3 - i30) - i29;
                                                                                int i33 = (length4 - i30) - i29;
                                                                                boolean zContains = semanticsNodeCopy.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword());
                                                                                boolean zContains2 = semanticsNode2.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword());
                                                                                i14 = i18;
                                                                                boolean zContains3 = semanticsNodeCopy.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText());
                                                                                boolean z = zContains3 && !zContains && zContains2;
                                                                                boolean z2 = zContains3 && zContains && !zContains2;
                                                                                if (z || z2) {
                                                                                    accessibilityEventCreateTextSelectionChangedEvent = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i16), 0, 0, Integer.valueOf(length4), charSequenceTrimToSize);
                                                                                } else {
                                                                                    accessibilityEventCreateTextSelectionChangedEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i16), 16);
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setFromIndex(i29);
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setRemovedCount(i32);
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setAddedCount(i33);
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setBeforeText(str3);
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.getText().add(charSequenceTrimToSize);
                                                                                }
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setClassName("android.widget.EditText");
                                                                                sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                if (z || z2) {
                                                                                    long packedValue = ((TextRange) semanticsNode2.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue();
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setFromIndex(TextRange.m6717getStartimpl(packedValue));
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setToIndex(TextRange.m6712getEndimpl(packedValue));
                                                                                    sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                }
                                                                                Unit unit4 = Unit.INSTANCE;
                                                                            } else {
                                                                                i13 = length;
                                                                                objArr4 = objArr6;
                                                                                i14 = i18;
                                                                                Boolean.valueOf(sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i16), 2048, 2, null, 8, null));
                                                                            }
                                                                        } else {
                                                                            i13 = length;
                                                                            objArr4 = objArr6;
                                                                            i14 = i18;
                                                                            if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getTextSelectionRange())) {
                                                                                AnnotatedString textForTextField3 = getTextForTextField(semanticsNode2.getUnmergedConfig());
                                                                                if (textForTextField3 != null && (text = textForTextField3.getText()) != null) {
                                                                                    str2 = text;
                                                                                }
                                                                                long packedValue2 = ((TextRange) semanticsNode2.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue();
                                                                                sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i16), Integer.valueOf(TextRange.m6717getStartimpl(packedValue2)), Integer.valueOf(TextRange.m6712getEndimpl(packedValue2)), Integer.valueOf(str2.length()), trimToSize(str2, 100000)));
                                                                                sendPendingTextTraversedAtGranularityEvent(semanticsNode2.getId());
                                                                                Unit unit5 = Unit.INSTANCE;
                                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) || Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) {
                                                                                notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode2.getLayoutNode());
                                                                                ScrollObservationScope scrollObservationScopeFindById = SemanticsUtils_androidKt.findById(this.scrollObservationScopes, i16);
                                                                                Intrinsics.checkNotNull(scrollObservationScopeFindById);
                                                                                scrollObservationScopeFindById.setHorizontalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()));
                                                                                scrollObservationScopeFindById.setVerticalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange()));
                                                                                scheduleScrollEventIfNeeded(scrollObservationScopeFindById);
                                                                                Unit unit6 = Unit.INSTANCE;
                                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getFocused())) {
                                                                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                                                                if (((Boolean) obj2).booleanValue()) {
                                                                                    sendEvent(createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode2.getId()), 8));
                                                                                }
                                                                                Boolean.valueOf(sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode2.getId()), 2048, 0, null, 8, null));
                                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsActions.INSTANCE.getCustomActions())) {
                                                                                List list3 = (List) semanticsNode2.getUnmergedConfig().get(SemanticsActions.INSTANCE.getCustomActions());
                                                                                List list4 = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions());
                                                                                if (list4 != null) {
                                                                                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                                                                                    int size = list3.size();
                                                                                    for (int i34 = 0; i34 < size; i34++) {
                                                                                        linkedHashSet.add(((CustomAccessibilityAction) list3.get(i34)).getLabel());
                                                                                    }
                                                                                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                                                                                    int size2 = list4.size();
                                                                                    for (int i35 = 0; i35 < size2; i35++) {
                                                                                        linkedHashSet2.add(((CustomAccessibilityAction) list4.get(i35)).getLabel());
                                                                                    }
                                                                                    zPropertiesDeleted = (linkedHashSet.containsAll(linkedHashSet2) && linkedHashSet2.containsAll(linkedHashSet)) ? false : true;
                                                                                } else if (!list3.isEmpty()) {
                                                                                    zPropertiesDeleted = true;
                                                                                }
                                                                                Unit unit7 = Unit.INSTANCE;
                                                                            } else {
                                                                                boolean z3 = ((obj2 instanceof AccessibilityAction) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals((AccessibilityAction) obj2, SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), semanticsPropertyKey))) ? false : true;
                                                                                Unit unit8 = Unit.INSTANCE;
                                                                                zPropertiesDeleted = z3;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                i13 = length;
                                                                objArr4 = objArr6;
                                                                i14 = i18;
                                                            }
                                                            j4 >>= 8;
                                                            i26++;
                                                            length2 = i12;
                                                            i22 = i16;
                                                            semanticsNode3 = semanticsNode2;
                                                            jArr6 = jArr4;
                                                            arrayList4 = arrayList3;
                                                            objArr6 = objArr4;
                                                            objArr5 = objArr3;
                                                            length = i13;
                                                            i23 = i15;
                                                            i18 = i14;
                                                        }
                                                    }
                                                    objArr3 = objArr5;
                                                    i12 = length2;
                                                    i13 = length;
                                                    objArr4 = objArr6;
                                                    i14 = i18;
                                                    i15 = i23;
                                                    jArr4 = jArr7;
                                                    semanticsNode2 = semanticsNode3;
                                                    arrayList3 = arrayList4;
                                                } else {
                                                    jArr4 = jArr6;
                                                    objArr3 = objArr5;
                                                    i12 = length2;
                                                    arrayList3 = arrayList4;
                                                    i13 = length;
                                                    objArr4 = objArr6;
                                                    i14 = i18;
                                                    i15 = i23;
                                                    semanticsNode2 = semanticsNode3;
                                                }
                                                i16 = i22;
                                                j4 >>= 8;
                                                i26++;
                                                length2 = i12;
                                                i22 = i16;
                                                semanticsNode3 = semanticsNode2;
                                                jArr6 = jArr4;
                                                arrayList4 = arrayList3;
                                                objArr6 = objArr4;
                                                objArr5 = objArr3;
                                                length = i13;
                                                i23 = i15;
                                                i18 = i14;
                                            }
                                            jArr3 = jArr6;
                                            objArr = objArr5;
                                            i11 = length2;
                                            arrayList2 = arrayList4;
                                            i6 = length;
                                            objArr2 = objArr6;
                                            i7 = i18;
                                            i5 = i23;
                                            i8 = 2;
                                            semanticsNode = semanticsNode3;
                                            i10 = i22;
                                            if (i25 != 8) {
                                                break;
                                            }
                                        } else {
                                            jArr3 = jArr6;
                                            objArr = objArr5;
                                            i11 = length2;
                                            arrayList2 = arrayList4;
                                            i6 = length;
                                            objArr2 = objArr6;
                                            i7 = i18;
                                            i5 = i23;
                                            i8 = 2;
                                            semanticsNode = semanticsNode3;
                                            i10 = i22;
                                        }
                                        if (i24 == i11) {
                                            break;
                                        }
                                        i24++;
                                        length2 = i11;
                                        i22 = i10;
                                        semanticsNode3 = semanticsNode;
                                        iArr3 = iArr2;
                                        jArr5 = jArr2;
                                        jArr6 = jArr3;
                                        arrayList4 = arrayList2;
                                        objArr6 = objArr2;
                                        objArr5 = objArr;
                                        length = i6;
                                        i23 = i5;
                                        i18 = i7;
                                    }
                                } else {
                                    semanticsNode = semanticsNode3;
                                    i4 = i21;
                                    i5 = i20;
                                    arrayList2 = arrayList4;
                                    iArr2 = iArr3;
                                    jArr2 = jArr5;
                                    i6 = length;
                                    i7 = i18;
                                    i10 = i22;
                                    i8 = i17;
                                    zPropertiesDeleted = false;
                                }
                                if (!zPropertiesDeleted) {
                                    zPropertiesDeleted = AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(semanticsNode, semanticsNodeCopy.getUnmergedConfig());
                                }
                                if (zPropertiesDeleted) {
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i10), 2048, 0, null, 8, null);
                                }
                            } else {
                                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
                                throw new KotlinNothingValueException();
                            }
                        }
                        i9 = 8;
                    } else {
                        i4 = i21;
                        i5 = i20;
                        arrayList2 = arrayList4;
                        iArr2 = iArr3;
                        jArr2 = jArr5;
                        i6 = length;
                        i7 = i18;
                        i8 = i17;
                        i9 = i19;
                    }
                    j2 >>= i9;
                    i21 = i4 + 1;
                    intObjectMap = newSemanticsNodes;
                    i19 = i9;
                    i17 = i8;
                    iArr3 = iArr2;
                    jArr5 = jArr2;
                    arrayList4 = arrayList2;
                    length = i6;
                    i20 = i5;
                    i18 = i7;
                }
                arrayList = arrayList4;
                iArr = iArr3;
                jArr = jArr5;
                int i36 = length;
                int i37 = i18;
                i = i17;
                if (i20 != i19) {
                    return;
                }
                i3 = i36;
                i2 = i37;
            } else {
                arrayList = arrayList4;
                iArr = iArr3;
                jArr = jArr5;
                int i38 = length;
                i = i17;
                i2 = i18;
                i3 = i38;
            }
            if (i2 == i3) {
                return;
            }
            i18 = i2 + 1;
            intObjectMap = newSemanticsNodes;
            i17 = i;
            iArr3 = iArr;
            jArr5 = jArr;
            arrayList4 = arrayList;
            length = i3;
        }
    }

    private final boolean registerScrollingId(int id2, List<ScrollObservationScope> oldScrollObservationScopes) {
        boolean z;
        ScrollObservationScope scrollObservationScopeFindById = SemanticsUtils_androidKt.findById(oldScrollObservationScopes, id2);
        if (scrollObservationScopeFindById != null) {
            z = false;
        } else {
            scrollObservationScopeFindById = new ScrollObservationScope(id2, this.scrollObservationScopes, null, null, null, null);
            z = true;
        }
        this.scrollObservationScopes.add(scrollObservationScopeFindById);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleScrollEventIfNeeded(final ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValidOwnerScope()) {
            this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.scheduleScrollEventIfNeededLambda, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeeded.1
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
                    SemanticsNode semanticsNode;
                    LayoutNode layoutNode;
                    ScrollAxisRange horizontalScrollAxisRange = scrollObservationScope.getHorizontalScrollAxisRange();
                    ScrollAxisRange verticalScrollAxisRange = scrollObservationScope.getVerticalScrollAxisRange();
                    Float oldXValue = scrollObservationScope.getOldXValue();
                    Float oldYValue = scrollObservationScope.getOldYValue();
                    float fFloatValue = (horizontalScrollAxisRange == null || oldXValue == null) ? 0.0f : horizontalScrollAxisRange.getValue().invoke().floatValue() - oldXValue.floatValue();
                    float fFloatValue2 = (verticalScrollAxisRange == null || oldYValue == null) ? 0.0f : verticalScrollAxisRange.getValue().invoke().floatValue() - oldYValue.floatValue();
                    if (fFloatValue != 0.0f || fFloatValue2 != 0.0f) {
                        int iSemanticsNodeIdToAccessibilityVirtualNodeId = this.semanticsNodeIdToAccessibilityVirtualNodeId(scrollObservationScope.getSemanticsNodeId());
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) this.getCurrentSemanticsNodes().get(this.accessibilityFocusedVirtualViewId);
                        if (semanticsNodeWithAdjustedBounds != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this;
                            try {
                                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI;
                                if (accessibilityNodeInfoCompat != null) {
                                    accessibilityNodeInfoCompat.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat.boundsInScreen(semanticsNodeWithAdjustedBounds));
                                    Unit unit = Unit.INSTANCE;
                                }
                            } catch (IllegalStateException unused) {
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) this.getCurrentSemanticsNodes().get(this.focusedVirtualViewId);
                        if (semanticsNodeWithAdjustedBounds2 != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = this;
                            try {
                                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = androidComposeViewAccessibilityDelegateCompat2.currentlyFocusedANI;
                                if (accessibilityNodeInfoCompat2 != null) {
                                    accessibilityNodeInfoCompat2.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat2.boundsInScreen(semanticsNodeWithAdjustedBounds2));
                                    Unit unit3 = Unit.INSTANCE;
                                }
                            } catch (IllegalStateException unused2) {
                                Unit unit4 = Unit.INSTANCE;
                            }
                        }
                        this.getView().invalidate();
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds3 = (SemanticsNodeWithAdjustedBounds) this.getCurrentSemanticsNodes().get(iSemanticsNodeIdToAccessibilityVirtualNodeId);
                        if (semanticsNodeWithAdjustedBounds3 != null && (semanticsNode = semanticsNodeWithAdjustedBounds3.getSemanticsNode()) != null && (layoutNode = semanticsNode.getLayoutNode()) != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat3 = this;
                            if (horizontalScrollAxisRange != null) {
                                androidComposeViewAccessibilityDelegateCompat3.pendingHorizontalScrollEvents.set(iSemanticsNodeIdToAccessibilityVirtualNodeId, horizontalScrollAxisRange);
                            }
                            if (verticalScrollAxisRange != null) {
                                androidComposeViewAccessibilityDelegateCompat3.pendingVerticalScrollEvents.set(iSemanticsNodeIdToAccessibilityVirtualNodeId, verticalScrollAxisRange);
                            }
                            androidComposeViewAccessibilityDelegateCompat3.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                        }
                    }
                    if (horizontalScrollAxisRange != null) {
                        scrollObservationScope.setOldXValue(horizontalScrollAxisRange.getValue().invoke());
                    }
                    if (verticalScrollAxisRange != null) {
                        scrollObservationScope.setOldYValue(verticalScrollAxisRange.getValue().invoke());
                    }
                }
            });
        }
    }

    private final void sendPaneChangeEvents(int semanticsNodeId, int contentChangeType, String title) {
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNodeId), 32);
        accessibilityEventCreateEvent.setContentChangeTypes(contentChangeType);
        if (title != null) {
            accessibilityEventCreateEvent.getText().add(title);
        }
        sendEvent(accessibilityEventCreateEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void sendAccessibilitySemanticsStructureChangeEvents(androidx.compose.ui.semantics.SemanticsNode r17, androidx.compose.ui.platform.SemanticsNodeCopy r18) {
        /*
            r16 = this;
            r0 = r16
            androidx.collection.MutableIntSet r1 = androidx.collection.IntSetKt.mutableIntSetOf()
            java.util.List r2 = r17.getReplacedChildren$ui_release()
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            int r3 = r3.size()
            r4 = 0
            r5 = r4
        L13:
            if (r5 >= r3) goto L49
            java.lang.Object r6 = r2.get(r5)
            androidx.compose.ui.semantics.SemanticsNode r6 = (androidx.compose.ui.semantics.SemanticsNode) r6
            androidx.collection.IntObjectMap r7 = r16.getCurrentSemanticsNodes()
            int r8 = r6.getId()
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L46
            androidx.collection.MutableIntSet r7 = r18.getChildren()
            int r8 = r6.getId()
            boolean r7 = r7.contains(r8)
            if (r7 != 0) goto L3f
            androidx.compose.ui.node.LayoutNode r1 = r17.getLayoutNode()
            r0.notifySubtreeAccessibilityStateChangedIfNeeded(r1)
            return
        L3f:
            int r6 = r6.getId()
            r1.add(r6)
        L46:
            int r5 = r5 + 1
            goto L13
        L49:
            androidx.collection.MutableIntSet r2 = r18.getChildren()
            androidx.collection.IntSet r2 = (androidx.collection.IntSet) r2
            int[] r3 = r2.elements
            long[] r2 = r2.metadata
            int r5 = r2.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L9c
            r6 = r4
        L59:
            r7 = r2[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L97
            int r9 = r6 - r5
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = r4
        L73:
            if (r11 >= r9) goto L95
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.3E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L91
            int r12 = r6 << 3
            int r12 = r12 + r11
            r12 = r3[r12]
            boolean r12 = r1.contains(r12)
            if (r12 != 0) goto L91
            androidx.compose.ui.node.LayoutNode r1 = r17.getLayoutNode()
            r0.notifySubtreeAccessibilityStateChangedIfNeeded(r1)
            return
        L91:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L73
        L95:
            if (r9 != r10) goto L9c
        L97:
            if (r6 == r5) goto L9c
            int r6 = r6 + 1
            goto L59
        L9c:
            java.util.List r1 = r17.getReplacedChildren$ui_release()
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
        La7:
            if (r4 >= r2) goto Ld1
            java.lang.Object r3 = r1.get(r4)
            androidx.compose.ui.semantics.SemanticsNode r3 = (androidx.compose.ui.semantics.SemanticsNode) r3
            androidx.collection.MutableIntObjectMap<androidx.compose.ui.platform.SemanticsNodeCopy> r5 = r0.previousSemanticsNodes
            int r6 = r3.getId()
            java.lang.Object r5 = r5.get(r6)
            androidx.compose.ui.platform.SemanticsNodeCopy r5 = (androidx.compose.ui.platform.SemanticsNodeCopy) r5
            if (r5 == 0) goto Lce
            androidx.collection.IntObjectMap r6 = r16.getCurrentSemanticsNodes()
            int r7 = r3.getId()
            boolean r6 = r6.containsKey(r7)
            if (r6 == 0) goto Lce
            r0.sendAccessibilitySemanticsStructureChangeEvents(r3, r5)
        Lce:
            int r4 = r4 + 1
            goto La7
        Ld1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendAccessibilitySemanticsStructureChangeEvents(androidx.compose.ui.semantics.SemanticsNode, androidx.compose.ui.platform.SemanticsNodeCopy):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int id2) {
        if (id2 == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return id2;
    }

    private final boolean traverseAtGranularity(SemanticsNode node, int granularity, boolean forward, boolean extendSelection) {
        AccessibilityIterators.TextSegmentIterator iteratorForGranularity;
        int accessibilitySelectionStart;
        int i;
        int id2 = node.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id2 != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(node.getId());
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(node);
        String str = iterableTextForAccessibility;
        if (str == null || str.length() == 0 || (iteratorForGranularity = getIteratorForGranularity(node, granularity)) == null) {
            return false;
        }
        int accessibilitySelectionEnd = getAccessibilitySelectionEnd(node);
        if (accessibilitySelectionEnd == -1) {
            accessibilitySelectionEnd = forward ? 0 : iterableTextForAccessibility.length();
        }
        int[] iArrFollowing = forward ? iteratorForGranularity.following(accessibilitySelectionEnd) : iteratorForGranularity.preceding(accessibilitySelectionEnd);
        if (iArrFollowing == null) {
            return false;
        }
        int i2 = iArrFollowing[0];
        int i3 = iArrFollowing[1];
        if (extendSelection && isAccessibilitySelectionExtendable(node)) {
            accessibilitySelectionStart = getAccessibilitySelectionStart(node);
            if (accessibilitySelectionStart == -1) {
                accessibilitySelectionStart = forward ? i2 : i3;
            }
            i = forward ? i3 : i2;
        } else {
            accessibilitySelectionStart = forward ? i3 : i2;
            i = accessibilitySelectionStart;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(node, forward ? 256 : 512, granularity, i2, i3, SystemClock.uptimeMillis());
        setAccessibilitySelection(node, accessibilitySelectionStart, i, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int semanticsNodeId) {
        PendingTextTraversedEvent pendingTextTraversedEvent = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent != null) {
            if (semanticsNodeId != pendingTextTraversedEvent.getNode().getId()) {
                return;
            }
            if (SystemClock.uptimeMillis() - pendingTextTraversedEvent.getTraverseTime() <= 1000) {
                AccessibilityEvent accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent.getNode().getId()), 131072);
                accessibilityEventCreateEvent.setFromIndex(pendingTextTraversedEvent.getFromIndex());
                accessibilityEventCreateEvent.setToIndex(pendingTextTraversedEvent.getToIndex());
                accessibilityEventCreateEvent.setAction(pendingTextTraversedEvent.getAction());
                accessibilityEventCreateEvent.setMovementGranularity(pendingTextTraversedEvent.getGranularity());
                accessibilityEventCreateEvent.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent.getNode()));
                sendEvent(accessibilityEventCreateEvent);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode node, int start, int end, boolean traversalMode) {
        String iterableTextForAccessibility;
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(node)) {
            Function3 function3 = (Function3) ((AccessibilityAction) node.getUnmergedConfig().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(traversalMode))).booleanValue();
            }
            return false;
        }
        if ((start == end && end == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(node)) == null) {
            return false;
        }
        if (start < 0 || start != end || end > iterableTextForAccessibility.length()) {
            start = -1;
        }
        this.accessibilityCursorPosition = start;
        String str = iterableTextForAccessibility;
        boolean z = str.length() > 0;
        sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(node.getId()), z ? Integer.valueOf(this.accessibilityCursorPosition) : null, z ? Integer.valueOf(this.accessibilityCursorPosition) : null, z ? Integer.valueOf(iterableTextForAccessibility.length()) : null, str));
        sendPendingTextTraversedAtGranularityEvent(node.getId());
        return true;
    }

    private final int getAccessibilitySelectionStart(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m6717getStartimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m6712getEndimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode node) {
        return !node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(androidx.compose.ui.semantics.SemanticsNode r6, int r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = r5.getIterableTextForAccessibility(r6)
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto Lb1
            int r2 = r2.length()
            if (r2 != 0) goto L15
            goto Lb1
        L15:
            r2 = 1
            if (r7 == r2) goto L90
            r2 = 2
            if (r7 == r2) goto L71
            r2 = 4
            if (r7 == r2) goto L34
            r3 = 8
            if (r7 == r3) goto L27
            r3 = 16
            if (r7 == r3) goto L34
            return r0
        L27:
            androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator$Companion r6 = androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator.INSTANCE
            androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator r6 = r6.getInstance()
            androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator r6 = (androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator) r6
            r6.initialize(r1)
            goto Lae
        L34:
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r6.getUnmergedConfig()
            androidx.compose.ui.semantics.SemanticsActions r4 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r4.getGetTextLayoutResult()
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L45
            return r0
        L45:
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r6.getUnmergedConfig()
            androidx.compose.ui.text.TextLayoutResult r3 = androidx.compose.ui.platform.SemanticsUtils_androidKt.getTextLayoutResult(r3)
            if (r3 != 0) goto L50
            return r0
        L50:
            if (r7 != r2) goto L61
            androidx.compose.ui.platform.AccessibilityIterators$LineTextSegmentIterator$Companion r6 = androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator.INSTANCE
            androidx.compose.ui.platform.AccessibilityIterators$LineTextSegmentIterator r6 = r6.getInstance()
            androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator r6 = (androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator) r6
            r7 = r6
            androidx.compose.ui.platform.AccessibilityIterators$LineTextSegmentIterator r7 = (androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator) r7
            r7.initialize(r1, r3)
            goto Lae
        L61:
            androidx.compose.ui.platform.AccessibilityIterators$PageTextSegmentIterator$Companion r7 = androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator.INSTANCE
            androidx.compose.ui.platform.AccessibilityIterators$PageTextSegmentIterator r7 = r7.getInstance()
            androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator r7 = (androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator) r7
            r0 = r7
            androidx.compose.ui.platform.AccessibilityIterators$PageTextSegmentIterator r0 = (androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator) r0
            r0.initialize(r1, r3, r6)
            r6 = r7
            goto Lae
        L71:
            androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator$Companion r6 = androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator.INSTANCE
            androidx.compose.ui.platform.AndroidComposeView r7 = r5.view
            android.content.Context r7 = r7.getContext()
            android.content.res.Resources r7 = r7.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            java.util.Locale r7 = r7.locale
            androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator r6 = r6.getInstance(r7)
            androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator r6 = (androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator) r6
            r7 = r6
            androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator r7 = (androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator) r7
            r7.initialize(r1)
            goto Lae
        L90:
            androidx.compose.ui.platform.AccessibilityIterators$CharacterTextSegmentIterator$Companion r6 = androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator.INSTANCE
            androidx.compose.ui.platform.AndroidComposeView r7 = r5.view
            android.content.Context r7 = r7.getContext()
            android.content.res.Resources r7 = r7.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            java.util.Locale r7 = r7.locale
            androidx.compose.ui.platform.AccessibilityIterators$CharacterTextSegmentIterator r6 = r6.getInstance(r7)
            androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator r6 = (androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator) r6
            r7 = r6
            androidx.compose.ui.platform.AccessibilityIterators$CharacterTextSegmentIterator r7 = (androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator) r7
            r7.initialize(r1)
        Lae:
            androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator r6 = (androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator) r6
            return r6
        Lb1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.getIteratorForGranularity(androidx.compose.ui.semantics.SemanticsNode, int):androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator");
    }

    private final String getIterableTextForAccessibility(SemanticsNode node) {
        AnnotatedString annotatedString;
        if (node == null) {
            return null;
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return ListUtilsKt.fastJoinToString$default((List) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", null, null, 0, null, null, 62, null);
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getEditableText());
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "createAccessibilityNodeInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "virtualViewId", "", "performAction", "", "action", "arguments", "Landroid/os/Bundle;", "addExtraDataToAccessibilityNodeInfo", "", "info", "extraDataKey", "", "findFocus", "focus", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {
        public ComposeAccessibilityNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int virtualViewId) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateNodeInfo = AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(virtualViewId);
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            if (androidComposeViewAccessibilityDelegateCompat.sendingFocusAffectingEvent) {
                if (virtualViewId == androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId) {
                    androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI = accessibilityNodeInfoCompatCreateNodeInfo;
                }
                if (virtualViewId == androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId) {
                    androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI = accessibilityNodeInfoCompatCreateNodeInfo;
                }
            }
            return accessibilityNodeInfoCompatCreateNodeInfo;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(virtualViewId, action, arguments);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, extraDataKey, arguments);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int focus) {
            if (focus != 1) {
                if (focus == 2) {
                    return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityFocusedVirtualViewId);
                }
                throw new IllegalArgumentException("Unknown focus type: " + focus);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId);
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            AccessibilityAction accessibilityAction;
            if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) == null) {
                return;
            }
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionSetProgress, accessibilityAction.getLabel()));
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (role == null ? false : Role.m6460equalsimpl0(role.getValue(), Role.INSTANCE.m6465getCarouselo7Vup1c())) {
                    return;
                }
                AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                if (accessibilityAction != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageUp, accessibilityAction.getLabel()));
                }
                AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown());
                if (accessibilityAction2 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageDown, accessibilityAction2.getLabel()));
                }
                AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                if (accessibilityAction3 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageLeft, accessibilityAction3.getLabel()));
                }
                AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight());
                if (accessibilityAction4 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageRight, accessibilityAction4.getLabel()));
                }
            }
        }
    }
}
