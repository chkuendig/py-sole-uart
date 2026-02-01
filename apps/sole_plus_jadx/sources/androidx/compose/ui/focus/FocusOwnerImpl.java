package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.indirect.IndirectTouchEvent;
import androidx.compose.ui.input.indirect.IndirectTouchInputModifierNode;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: FocusOwnerImpl.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\b\u001aJ!\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0015H\u0016J/\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b&\u0010'J\u001a\u0010#\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0017\u0010)\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b*\u0010+J7\u0010,\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u00192\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150/H\u0016¢\u0006\u0004\b0\u00101J%\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001506H\u0016¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00152\u0006\u00103\u001a\u000204H\u0016¢\u0006\u0004\b:\u0010;J\u001e\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020>2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001506H\u0016J\u001e\u0010?\u001a\u00020\u00152\u0006\u0010=\u001a\u00020@2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001506H\u0016J\u0010\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\tH\u0016J\u0010\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020!H\u0016Jd\u0010E\u001a\u00020!\"\n\b\u0000\u0010F\u0018\u0001*\u00020G*\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HF0I2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u00020!0/2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020!062\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u00020!0/H\u0082\b¢\u0006\u0004\bM\u0010NJ0\u0010O\u001a\u0004\u0018\u0001HF\"\n\b\u0000\u0010F\u0018\u0001*\u00020P*\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HF0IH\u0082\b¢\u0006\u0004\bQ\u0010RJ\n\u0010S\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010T\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010f\u001a\u0004\u0018\u00010g*\u00020GH\u0002J\u0017\u0010h\u001a\u00020\u00152\u0006\u00103\u001a\u000204H\u0002¢\u0006\u0004\bi\u0010;R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010U\u001a\u00020V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0ZX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R(\u0010_\u001a\u0004\u0018\u00010\t2\b\u0010^\u001a\u0004\u0018\u00010\t@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000b\"\u0004\ba\u0010\rR$\u0010b\u001a\u00020\u00152\u0006\u0010^\u001a\u00020\u0015@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e¨\u0006j"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "platformFocusOwner", "Landroidx/compose/ui/focus/PlatformFocusOwner;", "owner", "Landroidx/compose/ui/node/Owner;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/focus/PlatformFocusOwner;Landroidx/compose/ui/node/Owner;)V", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "requestOwnerFocus", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "requestOwnerFocus-7o62pno", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "releaseFocus", "", "clearOwnerFocus", "clearFocus", "force", "refreshFocusEvents", "clearFocus-I7lrPNg", "(ZZZI)Z", "forced", "moveFocus", "moveFocus-3ESFkO8", "(I)Z", "focusSearch", "focusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "dispatchKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onFocusedItem", "Lkotlin/Function0;", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchInterceptedSoftKeyboardEvent", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchRotaryEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "dispatchIndirectTouchEvent", "Landroidx/compose/ui/input/indirect/IndirectTouchEvent;", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "scheduleInvalidationForOwner", "traverseAncestorsIncludingSelf", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "nearestAncestorIncludingSelf", "", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "getFocusRect", "findFocusTargetNode", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "listeners", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/focus/FocusListener;", "getListeners", "()Landroidx/collection/MutableObjectList;", "value", "activeFocusTargetNode", "getActiveFocusTargetNode", "setActiveFocusTargetNode", "isFocusCaptured", "()Z", "setFocusCaptured", "(Z)V", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private FocusTargetNode activeFocusTargetNode;
    private final FocusInvalidationManager focusInvalidationManager;
    private boolean isFocusCaptured;
    private MutableLongSet keysCurrentlyDown;
    private final Owner owner;
    private final PlatformFocusOwner platformFocusOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode(Focusability.INSTANCE.m4229getNeverLCbbffg(), null, null, 6, null);
    private final Modifier modifier = new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            return other == this;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode node) {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* renamed from: create */
        public FocusTargetNode getNode() {
            return this.this$0.getRootFocusNode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("RootFocusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return this.this$0.getRootFocusNode().hashCode();
        }
    };
    private final MutableObjectList<FocusListener> listeners = new MutableObjectList<>(1);

    /* compiled from: FocusOwnerImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FocusOwnerImpl(PlatformFocusOwner platformFocusOwner, Owner owner) {
        this.platformFocusOwner = platformFocusOwner;
        this.owner = owner;
        this.focusInvalidationManager = new FocusInvalidationManager(this, owner);
    }

    /* renamed from: getRootFocusNode$ui_release, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: requestOwnerFocus-7o62pno */
    public boolean mo4193requestOwnerFocus7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        return this.platformFocusOwner.mo4236requestOwnerFocus7o62pno(focusDirection, previouslyFocusedRect);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: takeFocus-aToIllA */
    public boolean mo4194takeFocusaToIllA(final int focusDirection, Rect previouslyFocusedRect) {
        Boolean boolMo4192focusSearchULY8qGw = mo4192focusSearchULY8qGw(focusDirection, previouslyFocusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo4205requestFocus3ESFkO8(focusDirection));
            }
        });
        if (boolMo4192focusSearchULY8qGw != null) {
            return boolMo4192focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void clearOwnerFocus() {
        this.platformFocusOwner.clearOwnerFocus();
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean force) {
        mo4189clearFocusI7lrPNg(force, true, true, FocusDirection.INSTANCE.m4179getExitdhqQ8s());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: clearFocus-I7lrPNg */
    public boolean mo4189clearFocusI7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection) {
        boolean zClearFocus;
        if (!force) {
            int i = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m4212performCustomClearFocusMxy_nc0(this.rootFocusNode, focusDirection).ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                zClearFocus = false;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                zClearFocus = clearFocus(force, refreshFocusEvents);
            }
        } else {
            zClearFocus = clearFocus(force, refreshFocusEvents);
        }
        if (zClearFocus && clearOwnerFocus) {
            clearOwnerFocus();
        }
        return zClearFocus;
    }

    static /* synthetic */ boolean clearFocus$default(FocusOwnerImpl focusOwnerImpl, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return focusOwnerImpl.clearFocus(z, z2);
    }

    private final boolean clearFocus(boolean forced, boolean refreshFocusEvents) {
        NodeChain nodes;
        if (getActiveFocusTargetNode() == null) {
            return true;
        }
        if (getIsFocusCaptured() && !forced) {
            return false;
        }
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        setActiveFocusTargetNode(null);
        if (refreshFocusEvents && activeFocusTargetNode != null) {
            activeFocusTargetNode.dispatchFocusCallbacks$ui_release(getIsFocusCaptured() ? FocusStateImpl.Captured : FocusStateImpl.Active, FocusStateImpl.Inactive);
            FocusTargetNode focusTargetNode = activeFocusTargetNode;
            int iM6248constructorimpl = NodeKind.m6248constructorimpl(1024);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = focusTargetNode.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            while (layoutNodeRequireLayoutNode != null) {
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM6248constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM6248constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            Modifier.Node nodePop = parent;
                            while (nodePop != null) {
                                if (nodePop instanceof FocusTargetNode) {
                                    ((FocusTargetNode) nodePop).dispatchFocusCallbacks$ui_release(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                                } else if ((nodePop.getKindSet() & iM6248constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                        if ((delegate.getKindSet() & iM6248constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.Boolean] */
    @Override // androidx.compose.ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo4187moveFocus3ESFkO8(final int focusDirection) {
        if (ComposeUiFlags.isViewFocusFixEnabled && this.platformFocusOwner.mo4235moveFocusInChildren3ESFkO8(focusDirection)) {
            return true;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = false;
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        Boolean boolMo4192focusSearchULY8qGw = mo4192focusSearchULY8qGw(focusDirection, this.platformFocusOwner.getEmbeddedViewFocusRect(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Boolean] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.element = Boolean.valueOf(focusTargetNode.mo4205requestFocus3ESFkO8(focusDirection));
                return objectRef.element;
            }
        });
        if (Intrinsics.areEqual((Object) boolMo4192focusSearchULY8qGw, (Object) true) && activeFocusTargetNode != getActiveFocusTargetNode()) {
            return true;
        }
        if (boolMo4192focusSearchULY8qGw == null || objectRef.element == 0) {
            return false;
        }
        if (boolMo4192focusSearchULY8qGw.booleanValue() && ((Boolean) objectRef.element).booleanValue()) {
            return true;
        }
        return FocusOwnerImplKt.m4198is1dFocusSearch3ESFkO8(focusDirection) ? mo4189clearFocusI7lrPNg(false, true, false, focusDirection) && mo4194takeFocusaToIllA(focusDirection, null) : !ComposeUiFlags.isViewFocusFixEnabled && this.platformFocusOwner.mo4235moveFocusInChildren3ESFkO8(focusDirection);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: focusSearch-ULY8qGw */
    public Boolean mo4192focusSearchULY8qGw(int focusDirection, Rect focusedRect, final Function1<? super FocusTargetNode, Boolean> onFound) {
        final FocusTargetNode focusTargetNodeFindFocusTargetNode = findFocusTargetNode();
        if (focusTargetNodeFindFocusTargetNode != null) {
            FocusRequester focusRequesterM4218customFocusSearchOMvw8 = FocusTraversalKt.m4218customFocusSearchOMvw8(focusTargetNodeFindFocusTargetNode, focusDirection, this.owner.getLayoutDirection());
            if (Intrinsics.areEqual(focusRequesterM4218customFocusSearchOMvw8, FocusRequester.INSTANCE.getCancel())) {
                return null;
            }
            if (Intrinsics.areEqual(focusRequesterM4218customFocusSearchOMvw8, FocusRequester.INSTANCE.getRedirect$ui_release())) {
                FocusTargetNode focusTargetNodeFindFocusTargetNode2 = findFocusTargetNode();
                if (focusTargetNodeFindFocusTargetNode2 != null) {
                    return onFound.invoke(focusTargetNodeFindFocusTargetNode2);
                }
                return null;
            }
            if (!Intrinsics.areEqual(focusRequesterM4218customFocusSearchOMvw8, FocusRequester.INSTANCE.getDefault())) {
                return Boolean.valueOf(focusRequesterM4218customFocusSearchOMvw8.findFocusTargetNode$ui_release(onFound));
            }
        } else {
            focusTargetNodeFindFocusTargetNode = null;
        }
        return FocusTraversalKt.m4219focusSearch0X8WOeE(this.rootFocusNode, focusDirection, this.owner.getLayoutDirection(), focusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                boolean zBooleanValue;
                if (Intrinsics.areEqual(focusTargetNode, focusTargetNodeFindFocusTargetNode)) {
                    zBooleanValue = false;
                } else {
                    if (Intrinsics.areEqual(focusTargetNode, this.getRootFocusNode())) {
                        throw new IllegalStateException("Focus search landed at the root.".toString());
                    }
                    zBooleanValue = onFound.invoke(focusTargetNode).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f3 A[Catch: all -> 0x03f5, TryCatch #0 {all -> 0x03f5, blocks: (B:3:0x0009, B:5:0x0012, B:8:0x001d, B:12:0x0027, B:15:0x0035, B:118:0x01ae, B:120:0x01be, B:121:0x01c1, B:123:0x01d0, B:126:0x01e1, B:130:0x01ec, B:133:0x01f2, B:134:0x01f9, B:157:0x0247, B:135:0x01fd, B:137:0x0204, B:139:0x0208, B:141:0x0212, B:143:0x0219, B:145:0x021d, B:147:0x0223, B:150:0x022e, B:153:0x0238, B:154:0x023f, B:158:0x024c, B:159:0x0251, B:161:0x0257, B:163:0x025d, B:166:0x0268, B:168:0x0273, B:175:0x028a, B:176:0x028c, B:177:0x029c, B:179:0x02a0, B:181:0x02a6, B:211:0x0319, B:185:0x02b4, B:187:0x02bf, B:189:0x02c5, B:191:0x02d0, B:193:0x02d7, B:195:0x02db, B:196:0x02e0, B:198:0x02e6, B:199:0x02ed, B:201:0x02f5, B:203:0x02fb, B:204:0x0302, B:205:0x0304, B:207:0x030a, B:208:0x0311, B:212:0x0325, B:216:0x0335, B:217:0x0345, B:219:0x0349, B:221:0x034f, B:251:0x03c2, B:225:0x035d, B:227:0x0368, B:229:0x036e, B:231:0x0379, B:233:0x0380, B:235:0x0384, B:236:0x0389, B:238:0x038f, B:239:0x0396, B:241:0x039e, B:243:0x03a4, B:244:0x03ab, B:245:0x03ad, B:247:0x03b3, B:248:0x03ba, B:253:0x03d0, B:255:0x03da, B:260:0x03ed, B:261:0x03ef, B:18:0x0040, B:20:0x0050, B:21:0x0053, B:23:0x005d, B:26:0x006e, B:30:0x0079, B:64:0x00e9, B:66:0x00ed, B:33:0x007f, B:35:0x0086, B:37:0x008a, B:39:0x0094, B:41:0x009b, B:43:0x009f, B:45:0x00a5, B:48:0x00b0, B:51:0x00ba, B:52:0x00c1, B:55:0x00c9, B:56:0x00ce, B:57:0x00d3, B:59:0x00d9, B:61:0x00df, B:67:0x00f3, B:69:0x0105, B:70:0x0108, B:72:0x0116, B:75:0x0127, B:79:0x0132, B:113:0x01a2, B:115:0x01a6, B:82:0x0138, B:84:0x013f, B:86:0x0143, B:88:0x014d, B:90:0x0154, B:92:0x0158, B:94:0x015e, B:97:0x0169, B:100:0x0173, B:101:0x017a, B:104:0x0182, B:105:0x0187, B:106:0x018c, B:108:0x0192, B:110:0x0198), top: B:267:0x0009 }] */
    /* JADX WARN: Type inference failed for: r4v21, types: [T, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v31, types: [T, androidx.compose.ui.Modifier$Node, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v40, types: [T, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v50, types: [T, androidx.compose.ui.Modifier$Node, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v68 */
    /* JADX WARN: Type inference failed for: r4v69 */
    /* JADX WARN: Type inference failed for: r4v70 */
    /* JADX WARN: Type inference failed for: r4v71 */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-YhN2O0w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo4191dispatchKeyEventYhN2O0w(android.view.KeyEvent r17, kotlin.jvm.functions.Function0<java.lang.Boolean> r18) {
        /*
            Method dump skipped, instructions count: 1018
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.mo4191dispatchKeyEventYhN2O0w(android.view.KeyEvent, kotlin.jvm.functions.Function0):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo4190dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        int size;
        NodeChain nodes;
        DelegatingNode delegatingNodePop;
        NodeChain nodes2;
        if (this.focusInvalidationManager.getIsInvalidationScheduled()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            FocusTargetNode focusTargetNode = focusTargetNodeFindActiveFocusNode;
            int iM6248constructorimpl = NodeKind.m6248constructorimpl(131072);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    delegatingNodePop = 0;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM6248constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & iM6248constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            delegatingNodePop = node;
                            while (delegatingNodePop != 0) {
                                if (delegatingNodePop instanceof SoftKeyboardInterceptionModifierNode) {
                                    break loop0;
                                }
                                if ((delegatingNodePop.getKindSet() & iM6248constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = delegatingNodePop.getDelegate();
                                    int i = 0;
                                    delegatingNodePop = delegatingNodePop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM6248constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                delegatingNodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNodePop != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegatingNodePop);
                                                    }
                                                    delegatingNodePop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        delegatingNodePop = delegatingNodePop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                node = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            softKeyboardInterceptionModifierNode = (SoftKeyboardInterceptionModifierNode) delegatingNodePop;
        } else {
            softKeyboardInterceptionModifierNode = null;
        }
        if (softKeyboardInterceptionModifierNode != null) {
            SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode2 = softKeyboardInterceptionModifierNode;
            int iM6248constructorimpl2 = NodeKind.m6248constructorimpl(131072);
            if (!softKeyboardInterceptionModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = softKeyboardInterceptionModifierNode2.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(softKeyboardInterceptionModifierNode2);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode2 != null) {
                if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM6248constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM6248constructorimpl2) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof SoftKeyboardInterceptionModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                } else if ((nodePop.getKindSet() & iM6248constructorimpl2) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & iM6248constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodePop = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate2);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
                parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i3 = size - 1;
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(size)).mo5372onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    size = i3;
                }
            }
            DelegatingNode node2 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node2 != 0) {
                if (node2 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node2).mo5372onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node2.getKindSet() & iM6248constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                    Modifier.Node delegate3 = node2.getDelegate();
                    int i4 = 0;
                    node2 = node2;
                    while (delegate3 != null) {
                        if ((delegate3.getKindSet() & iM6248constructorimpl2) != 0) {
                            i4++;
                            if (i4 == 1) {
                                node2 = delegate3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node2 != 0) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(node2);
                                    }
                                    node2 = 0;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(delegate3);
                                }
                            }
                        }
                        delegate3 = delegate3.getChild();
                        node2 = node2;
                    }
                    if (i4 == 1) {
                    }
                }
                node2 = DelegatableNodeKt.pop(mutableVector3);
            }
            DelegatingNode node3 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node3 != 0) {
                if (node3 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node3).mo5371onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node3.getKindSet() & iM6248constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = node3.getDelegate();
                    int i5 = 0;
                    node3 = node3;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & iM6248constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node3 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(node3);
                                    }
                                    node3 = 0;
                                }
                                if (mutableVector4 != null) {
                                    mutableVector4.add(delegate4);
                                }
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node3 = node3;
                    }
                    if (i5 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(i6)).mo5371onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent event, Function0<Boolean> onFocusedItem) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int size;
        NodeChain nodes;
        DelegatingNode delegatingNodePop;
        NodeChain nodes2;
        if (this.focusInvalidationManager.getIsInvalidationScheduled()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode focusTargetNodeFindFocusTargetNode = findFocusTargetNode();
        if (focusTargetNodeFindFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = focusTargetNodeFindFocusTargetNode;
            int iM6248constructorimpl = NodeKind.m6248constructorimpl(16384);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    delegatingNodePop = 0;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM6248constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & iM6248constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            delegatingNodePop = node;
                            while (delegatingNodePop != 0) {
                                if (delegatingNodePop instanceof RotaryInputModifierNode) {
                                    break loop0;
                                }
                                if ((delegatingNodePop.getKindSet() & iM6248constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = delegatingNodePop.getDelegate();
                                    int i = 0;
                                    delegatingNodePop = delegatingNodePop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM6248constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                delegatingNodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNodePop != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegatingNodePop);
                                                    }
                                                    delegatingNodePop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        delegatingNodePop = delegatingNodePop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                node = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) delegatingNodePop;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            RotaryInputModifierNode rotaryInputModifierNode2 = rotaryInputModifierNode;
            int iM6248constructorimpl2 = NodeKind.m6248constructorimpl(16384);
            if (!rotaryInputModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = rotaryInputModifierNode2.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode2);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode2 != null) {
                if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM6248constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM6248constructorimpl2) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof RotaryInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                } else if ((nodePop.getKindSet() & iM6248constructorimpl2) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & iM6248constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodePop = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate2);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
                parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i3 = size - 1;
                    if (((RotaryInputModifierNode) arrayList.get(size)).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    size = i3;
                }
            }
            DelegatingNode node2 = rotaryInputModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node2 != 0) {
                if (node2 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node2).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node2.getKindSet() & iM6248constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                    Modifier.Node delegate3 = node2.getDelegate();
                    int i4 = 0;
                    node2 = node2;
                    while (delegate3 != null) {
                        if ((delegate3.getKindSet() & iM6248constructorimpl2) != 0) {
                            i4++;
                            if (i4 == 1) {
                                node2 = delegate3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node2 != 0) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(node2);
                                    }
                                    node2 = 0;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(delegate3);
                                }
                            }
                        }
                        delegate3 = delegate3.getChild();
                        node2 = node2;
                    }
                    if (i4 == 1) {
                    }
                }
                node2 = DelegatableNodeKt.pop(mutableVector3);
            }
            if (onFocusedItem.invoke().booleanValue()) {
                return true;
            }
            DelegatingNode node3 = rotaryInputModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node3 != 0) {
                if (node3 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node3).onRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node3.getKindSet() & iM6248constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = node3.getDelegate();
                    int i5 = 0;
                    node3 = node3;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & iM6248constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node3 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(node3);
                                    }
                                    node3 = 0;
                                }
                                if (mutableVector4 != null) {
                                    mutableVector4.add(delegate4);
                                }
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node3 = node3;
                    }
                    if (i5 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (((RotaryInputModifierNode) arrayList.get(i6)).onRotaryScrollEvent(event)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchIndirectTouchEvent(IndirectTouchEvent event, Function0<Boolean> onFocusedItem) {
        IndirectTouchInputModifierNode indirectTouchInputModifierNode;
        int size;
        NodeChain nodes;
        DelegatingNode delegatingNodePop;
        NodeChain nodes2;
        if (this.focusInvalidationManager.getIsInvalidationScheduled()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching indirect touch event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode focusTargetNodeFindFocusTargetNode = findFocusTargetNode();
        if (focusTargetNodeFindFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = focusTargetNodeFindFocusTargetNode;
            int iM6248constructorimpl = NodeKind.m6248constructorimpl(2097152);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    delegatingNodePop = 0;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM6248constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & iM6248constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            delegatingNodePop = node;
                            while (delegatingNodePop != 0) {
                                if (delegatingNodePop instanceof IndirectTouchInputModifierNode) {
                                    break loop0;
                                }
                                if ((delegatingNodePop.getKindSet() & iM6248constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = delegatingNodePop.getDelegate();
                                    int i = 0;
                                    delegatingNodePop = delegatingNodePop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM6248constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                delegatingNodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNodePop != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegatingNodePop);
                                                    }
                                                    delegatingNodePop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        delegatingNodePop = delegatingNodePop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                node = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            indirectTouchInputModifierNode = (IndirectTouchInputModifierNode) delegatingNodePop;
        } else {
            indirectTouchInputModifierNode = null;
        }
        if (indirectTouchInputModifierNode != null) {
            IndirectTouchInputModifierNode indirectTouchInputModifierNode2 = indirectTouchInputModifierNode;
            int iM6248constructorimpl2 = NodeKind.m6248constructorimpl(2097152);
            if (!indirectTouchInputModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = indirectTouchInputModifierNode2.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(indirectTouchInputModifierNode2);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode2 != null) {
                if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM6248constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM6248constructorimpl2) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof IndirectTouchInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                } else if ((nodePop.getKindSet() & iM6248constructorimpl2) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & iM6248constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodePop = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate2);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
                parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i3 = size - 1;
                    if (((IndirectTouchInputModifierNode) arrayList.get(size)).onPreIndirectTouchEvent(event)) {
                        return true;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    size = i3;
                }
            }
            DelegatingNode node2 = indirectTouchInputModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node2 != 0) {
                if (node2 instanceof IndirectTouchInputModifierNode) {
                    if (((IndirectTouchInputModifierNode) node2).onPreIndirectTouchEvent(event)) {
                        return true;
                    }
                } else if ((node2.getKindSet() & iM6248constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                    Modifier.Node delegate3 = node2.getDelegate();
                    int i4 = 0;
                    node2 = node2;
                    while (delegate3 != null) {
                        if ((delegate3.getKindSet() & iM6248constructorimpl2) != 0) {
                            i4++;
                            if (i4 == 1) {
                                node2 = delegate3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node2 != 0) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(node2);
                                    }
                                    node2 = 0;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(delegate3);
                                }
                            }
                        }
                        delegate3 = delegate3.getChild();
                        node2 = node2;
                    }
                    if (i4 == 1) {
                    }
                }
                node2 = DelegatableNodeKt.pop(mutableVector3);
            }
            if (onFocusedItem.invoke().booleanValue()) {
                return true;
            }
            DelegatingNode node3 = indirectTouchInputModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node3 != 0) {
                if (node3 instanceof IndirectTouchInputModifierNode) {
                    if (((IndirectTouchInputModifierNode) node3).onIndirectTouchEvent(event)) {
                        return true;
                    }
                } else if ((node3.getKindSet() & iM6248constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = node3.getDelegate();
                    int i5 = 0;
                    node3 = node3;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & iM6248constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node3 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(node3);
                                    }
                                    node3 = 0;
                                }
                                if (mutableVector4 != null) {
                                    mutableVector4.add(delegate4);
                                }
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node3 = node3;
                    }
                    if (i5 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (((IndirectTouchInputModifierNode) arrayList.get(i6)).onIndirectTouchEvent(event)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidationForOwner() {
        this.focusInvalidationManager.scheduleInvalidation();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode focusTargetNodeFindFocusTargetNode = findFocusTargetNode();
        if (focusTargetNodeFindFocusTargetNode != null) {
            return FocusTraversalKt.focusRect(focusTargetNodeFindFocusTargetNode);
        }
        return null;
    }

    private final FocusTargetNode findFocusTargetNode() {
        return FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public MutableObjectList<FocusListener> getListeners() {
        return this.listeners;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTargetNode getActiveFocusTargetNode() {
        return this.activeFocusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setActiveFocusTargetNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = this.activeFocusTargetNode;
        this.activeFocusTargetNode = focusTargetNode;
        if (focusTargetNode == null || focusTargetNode2 != focusTargetNode) {
            setFocusCaptured(false);
        }
        if (ComposeUiFlags.isSemanticAutofillEnabled) {
            MutableObjectList<FocusListener> listeners = getListeners();
            Object[] objArr = listeners.content;
            int i = listeners._size;
            for (int i2 = 0; i2 < i; i2++) {
                ((FocusListener) objArr[i2]).onFocusChanged(focusTargetNode2, focusTargetNode);
            }
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: isFocusCaptured, reason: from getter */
    public boolean getIsFocusCaptured() {
        return this.isFocusCaptured;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setFocusCaptured(boolean z) {
        if (!((z && getActiveFocusTargetNode() == null) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot capture focus when the active focus target node is unset");
        }
        this.isFocusCaptured = z;
    }

    /* renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m4197validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long jM5684getKeyZmokQxo = KeyEvent_androidKt.m5684getKeyZmokQxo(keyEvent);
        int iM5685getTypeZmokQxo = KeyEvent_androidKt.m5685getTypeZmokQxo(keyEvent);
        if (KeyEventType.m5677equalsimpl0(iM5685getTypeZmokQxo, KeyEventType.INSTANCE.m5681getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(jM5684getKeyZmokQxo);
        } else if (KeyEventType.m5677equalsimpl0(iM5685getTypeZmokQxo, KeyEventType.INSTANCE.m5682getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(jM5684getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(jM5684getKeyZmokQxo);
            }
        }
        return true;
    }

    /* renamed from: traverseAncestorsIncludingSelf-QFhIj7k, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m4196traverseAncestorsIncludingSelfQFhIj7k(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        int i2;
        int size;
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                break;
            }
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(nodePop);
                            } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        if (arrayList != null && arrayList.size() - 1 >= 0) {
            while (true) {
                int i4 = size - 1;
                function1.invoke((Object) arrayList.get(size));
                if (i4 < 0) {
                    break;
                } else {
                    size = i4;
                }
            }
        }
        Modifier.Node node = delegatableNode.getNode();
        MutableVector mutableVector2 = null;
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node instanceof Object) {
                function1.invoke(node);
            } else if ((node.getKindSet() & i) != 0 && (node instanceof DelegatingNode)) {
                int i5 = 0;
                for (Modifier.Node delegate2 = ((DelegatingNode) node).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                    if ((delegate2.getKindSet() & i) != 0) {
                        i5++;
                        if (i5 == 1) {
                            node = delegate2;
                        } else {
                            if (mutableVector2 == null) {
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector2 != null) {
                                    mutableVector2.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector2 != null) {
                                mutableVector2.add(delegate2);
                            }
                        }
                    }
                }
                if (i5 == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector2);
        }
        function0.invoke();
        Modifier.Node node2 = delegatableNode.getNode();
        MutableVector mutableVector3 = null;
        while (node2 != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node2 instanceof Object) {
                function12.invoke(node2);
            } else if ((node2.getKindSet() & i) != 0 && (node2 instanceof DelegatingNode)) {
                int i6 = 0;
                for (Modifier.Node delegate3 = ((DelegatingNode) node2).getDelegate(); delegate3 != null; delegate3 = delegate3.getChild()) {
                    if ((delegate3.getKindSet() & i) != 0) {
                        i6++;
                        if (i6 == 1) {
                            node2 = delegate3;
                        } else {
                            if (mutableVector3 == null) {
                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node2 != null) {
                                if (mutableVector3 != null) {
                                    mutableVector3.add(node2);
                                }
                                node2 = null;
                            }
                            if (mutableVector3 != null) {
                                mutableVector3.add(delegate3);
                            }
                        }
                    }
                }
                if (i6 == 1) {
                }
            }
            node2 = DelegatableNodeKt.pop(mutableVector3);
        }
        if (arrayList != null) {
            int size2 = arrayList.size();
            for (i2 = 0; i2 < size2; i2++) {
                function12.invoke((Object) arrayList.get(i2));
            }
        }
    }

    /* renamed from: nearestAncestorIncludingSelf-64DMado, reason: not valid java name */
    private final /* synthetic */ <T> T m4195nearestAncestorIncludingSelf64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        Object obj = (T) node;
                        MutableVector mutableVector = null;
                        while (obj != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (obj instanceof Object) {
                                return (T) obj;
                            }
                            if ((((Modifier.Node) obj).getKindSet() & i) != 0 && (obj instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = obj.getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            obj = (T) delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (obj != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(obj);
                                                }
                                                obj = (T) null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            obj = (T) DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int iM6248constructorimpl = NodeKind.m6248constructorimpl(1024) | NodeKind.m6248constructorimpl(8192);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet() & iM6248constructorimpl) != 0) {
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & iM6248constructorimpl) != 0) {
                    if ((NodeKind.m6248constructorimpl(1024) & child.getKindSet()) != 0) {
                        return node2;
                    }
                    node2 = child;
                }
            }
        }
        return node2;
    }
}
