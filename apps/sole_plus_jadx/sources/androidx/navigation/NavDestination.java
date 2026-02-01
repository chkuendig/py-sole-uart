package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavDestination;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavDestinationImpl;
import androidx.navigation.serialization.RouteSerializerKt;
import androidx.savedstate.SavedStateReader;
import com.android.SdkConstants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializersKt;

/* compiled from: NavDestination.android.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u0000 h2\u00020\u0001:\u0003fghB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0017J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010@\u001a\u00020A2\u0006\u0010D\u001a\u00020EH\u0016J\u000e\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\u0003J\u000e\u0010F\u001a\u00020/2\u0006\u0010H\u001a\u00020\"J\u0012\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010:\u001a\u00020\u0003H\u0007J\u0012\u0010K\u001a\u0004\u0018\u00010J2\u0006\u0010L\u001a\u00020EH\u0017J\u0014\u0010M\u001a\u00020N2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0000H\u0007J \u0010P\u001a\u00020A2\u0006\u0010:\u001a\u00020\u00032\u000e\u0010)\u001a\n\u0018\u00010Qj\u0004\u0018\u0001`RH\u0007J\b\u0010S\u001a\u00020AH\u0017J\u0012\u0010T\u001a\u0004\u0018\u00010(2\b\b\u0001\u00105\u001a\u000204J\u001a\u0010U\u001a\u00020/2\b\b\u0001\u0010V\u001a\u0002042\b\b\u0001\u0010W\u001a\u000204J\u0018\u0010U\u001a\u00020/2\b\b\u0001\u0010V\u001a\u0002042\u0006\u0010X\u001a\u00020(J\u0010\u0010Y\u001a\u00020/2\b\b\u0001\u0010V\u001a\u000204J\u0016\u0010Z\u001a\u00020/2\u0006\u0010[\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020+J\u000e\u0010]\u001a\u00020/2\u0006\u0010[\u001a\u00020\u0003J \u0010^\u001a\n\u0018\u00010Qj\u0004\u0018\u0001`R2\u000e\u0010_\u001a\n\u0018\u00010Qj\u0004\u0018\u0001`RH\u0007J \u0010`\u001a\u0004\u0018\u00010\u00032\u0006\u00100\u001a\u0002012\u000e\u0010a\u001a\n\u0018\u00010Qj\u0004\u0018\u0001`RJ\b\u0010b\u001a\u00020\u0003H\u0016J\u0013\u0010c\u001a\u00020A2\b\u0010d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010e\u001a\u000204H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R/\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\u0005*\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b$\u0010%*\u0004\b#\u0010\u0017R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+0*8F¢\u0006\u0006\u001a\u0004\b,\u0010-R&\u00105\u001a\u0002042\b\b\u0001\u0010\r\u001a\u0002048G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R/\u0010:\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b<\u0010\n\"\u0004\b=\u0010\u0005*\u0004\b;\u0010\u0017R\u0014\u0010>\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\n¨\u0006i"}, d2 = {"Landroidx/navigation/NavDestination;", "", "navigatorName", "", SdkConstants.CONSTRUCTOR_NAME, "(Ljava/lang/String;)V", "navigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "getNavigatorName", "()Ljava/lang/String;", "impl", "Landroidx/navigation/internal/NavDestinationImpl;", "value", "Landroidx/navigation/NavGraph;", SdkConstants.ATTR_PARENT, "getParent", "()Landroidx/navigation/NavGraph;", "setParent", "(Landroidx/navigation/NavGraph;)V", "<set-?>", "idName", "getIdName$delegate", "(Landroidx/navigation/NavDestination;)Ljava/lang/Object;", "getIdName", "setIdName", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "deepLinks", "", "Landroidx/navigation/NavDeepLink;", "getDeepLinks$delegate", "getDeepLinks", "()Ljava/util/List;", "actions", "Landroidx/collection/SparseArrayCompat;", "Landroidx/navigation/NavAction;", "arguments", "", "Landroidx/navigation/NavArgument;", "getArguments", "()Ljava/util/Map;", "onInflate", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "", "id", "getId", "()I", "setId", "(I)V", "route", "getRoute$delegate", "getRoute", "setRoute", "displayName", "getDisplayName", "hasDeepLink", "", "deepLink", "Landroid/net/Uri;", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "addDeepLink", "uriPattern", "navDeepLink", "matchRoute", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "matchDeepLink", "navDeepLinkRequest", "buildDeepLinkIds", "", "previousDestination", "hasRoute", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "supportsActions", "getAction", "putAction", "actionId", "destId", "action", "removeAction", "addArgument", "argumentName", SdkConstants.TAG_ARGUMENT, "removeArgument", "addInDefaultArgs", "args", "fillInLabel", "bundle", "toString", "equals", "other", "hashCode", "ClassType", "DeepLinkMatch", "Companion", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class NavDestination {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Class<?>> classes = new LinkedHashMap();
    private final SparseArrayCompat<NavAction> actions;
    private final NavDestinationImpl impl;
    private CharSequence label;
    private final String navigatorName;
    private NavGraph parent;

    /* compiled from: NavDestination.android.kt */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/NavDestination$ClassType;", "", "value", "Lkotlin/reflect/KClass;", "()Ljava/lang/Class;", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface ClassType {
        Class<?> value();
    }

    @JvmStatic
    public static final String getDisplayName(NavContext navContext, int i) {
        return INSTANCE.getDisplayName(navContext, i);
    }

    public static final Sequence<NavDestination> getHierarchy(NavDestination navDestination) {
        return INSTANCE.getHierarchy(navDestination);
    }

    @JvmStatic
    public static final <T> boolean hasRoute(NavDestination navDestination, KClass<T> kClass) {
        return INSTANCE.hasRoute(navDestination, kClass);
    }

    @JvmStatic
    protected static final <C> Class<? extends C> parseClassFromName(Context context, String str, Class<? extends C> cls) {
        return INSTANCE.parseClassFromName(context, str, cls);
    }

    @JvmStatic
    public static final <C> Class<? extends C> parseClassFromNameInternal(Context context, String str, Class<? extends C> cls) {
        return INSTANCE.parseClassFromNameInternal(context, str, cls);
    }

    public final int[] buildDeepLinkIds() {
        return buildDeepLinkIds$default(this, null, 1, null);
    }

    public boolean supportsActions() {
        return true;
    }

    public NavDestination(String navigatorName) {
        Intrinsics.checkNotNullParameter(navigatorName, "navigatorName");
        this.navigatorName = navigatorName;
        this.impl = new NavDestinationImpl(this);
        this.actions = new SparseArrayCompat<>(0, 1, null);
    }

    public final String getNavigatorName() {
        return this.navigatorName;
    }

    /* compiled from: NavDestination.android.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0000H\u0096\u0002J\u0016\u0010\u0015\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavDestination$DeepLinkMatch;", "", "destination", "Landroidx/navigation/NavDestination;", "matchingArgs", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "isExactDeepLink", "", "matchingPathSegments", "", "hasMatchingAction", "mimeTypeMatchLevel", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZIZI)V", "getDestination", "()Landroidx/navigation/NavDestination;", "getMatchingArgs", "()Landroid/os/Bundle;", "compareTo", "other", "hasMatchingArgs", "arguments", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;
        private final Bundle matchingArgs;
        private final int matchingPathSegments;
        private final int mimeTypeMatchLevel;

        public DeepLinkMatch(NavDestination destination, Bundle bundle, boolean z, int i, boolean z2, int i2) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            this.destination = destination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z;
            this.matchingPathSegments = i;
            this.hasMatchingAction = z2;
            this.mimeTypeMatchLevel = i2;
        }

        public final NavDestination getDestination() {
            return this.destination;
        }

        public final Bundle getMatchingArgs() {
            return this.matchingArgs;
        }

        @Override // java.lang.Comparable
        public int compareTo(DeepLinkMatch other) {
            Intrinsics.checkNotNullParameter(other, "other");
            boolean z = this.isExactDeepLink;
            if (z && !other.isExactDeepLink) {
                return 1;
            }
            if (!z && other.isExactDeepLink) {
                return -1;
            }
            int i = this.matchingPathSegments - other.matchingPathSegments;
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            Bundle bundle = this.matchingArgs;
            if (bundle != null && other.matchingArgs == null) {
                return 1;
            }
            if (bundle == null && other.matchingArgs != null) {
                return -1;
            }
            if (bundle != null) {
                int iM7886sizeimpl = SavedStateReader.m7886sizeimpl(SavedStateReader.m7806constructorimpl(bundle));
                Bundle bundle2 = other.matchingArgs;
                Intrinsics.checkNotNull(bundle2);
                int iM7886sizeimpl2 = iM7886sizeimpl - SavedStateReader.m7886sizeimpl(SavedStateReader.m7806constructorimpl(bundle2));
                if (iM7886sizeimpl2 > 0) {
                    return 1;
                }
                if (iM7886sizeimpl2 < 0) {
                    return -1;
                }
            }
            boolean z2 = this.hasMatchingAction;
            if (z2 && !other.hasMatchingAction) {
                return 1;
            }
            if (z2 || !other.hasMatchingAction) {
                return this.mimeTypeMatchLevel - other.mimeTypeMatchLevel;
            }
            return -1;
        }

        public final boolean hasMatchingArgs(Bundle arguments) {
            Bundle bundle;
            if (arguments == null || (bundle = this.matchingArgs) == null) {
                return false;
            }
            Set<String> setKeySet = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
            for (String str : setKeySet) {
                Bundle bundleM7806constructorimpl = SavedStateReader.m7806constructorimpl(arguments);
                Intrinsics.checkNotNull(str);
                if (!SavedStateReader.m7807containsimpl(bundleM7806constructorimpl, str)) {
                    return false;
                }
                NavArgument navArgument = this.destination.getArguments().get(str);
                NavType<Object> type = navArgument != null ? navArgument.getType() : null;
                Object obj = type != null ? type.get(this.matchingArgs, str) : null;
                Object obj2 = type != null ? type.get(arguments, str) : null;
                if (type != null && !type.valueEquals(obj, obj2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public final NavGraph getParent() {
        return this.parent;
    }

    public final void setParent(NavGraph navGraph) {
        this.parent = navGraph;
    }

    private final String getIdName() {
        return this.impl.getIdName();
    }

    private final void setIdName(String str) {
        this.impl.setIdName$navigation_common_release(str);
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
    }

    private final List<NavDeepLink> getDeepLinks() {
        return this.impl.getDeepLinks$navigation_common_release();
    }

    public final Map<String, NavArgument> getArguments() {
        return MapsKt.toMap(this.impl.getArguments$navigation_common_release());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.INSTANCE.getNameForNavigator$navigation_common_release(navigator.getClass()));
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    public void onInflate(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.Navigator);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "obtainAttributes(...)");
        setRoute(typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.Navigator_route));
        if (typedArrayObtainAttributes.hasValue(androidx.navigation.common.R.styleable.Navigator_android_id)) {
            setId(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.Navigator_android_id, 0));
            setIdName(INSTANCE.getDisplayName(new NavContext(context), getId()));
        }
        this.label = typedArrayObtainAttributes.getText(androidx.navigation.common.R.styleable.Navigator_android_label);
        Unit unit = Unit.INSTANCE;
        typedArrayObtainAttributes.recycle();
    }

    public final int getId() {
        return this.impl.getId();
    }

    public final void setId(int i) {
        this.impl.setId$navigation_common_release(i);
    }

    public final String getRoute() {
        return this.impl.getRoute();
    }

    public final void setRoute(String str) {
        this.impl.setRoute$navigation_common_release(str);
    }

    public String getDisplayName() {
        String idName = getIdName();
        return idName == null ? String.valueOf(getId()) : idName;
    }

    public boolean hasDeepLink(Uri deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        return hasDeepLink(new NavDeepLinkRequest(deepLink, null, null));
    }

    public boolean hasDeepLink(NavDeepLinkRequest deepLinkRequest) {
        Intrinsics.checkNotNullParameter(deepLinkRequest, "deepLinkRequest");
        return matchDeepLink(deepLinkRequest) != null;
    }

    public final void addDeepLink(String uriPattern) {
        Intrinsics.checkNotNullParameter(uriPattern, "uriPattern");
        addDeepLink(new NavDeepLink.Builder().setUriPattern(uriPattern).build());
    }

    public final void addDeepLink(NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        this.impl.addDeepLink$navigation_common_release(navDeepLink);
    }

    public final DeepLinkMatch matchRoute(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.matchRoute$navigation_common_release(route);
    }

    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return this.impl.matchDeepLink$navigation_common_release(navDeepLinkRequest);
    }

    public static /* synthetic */ int[] buildDeepLinkIds$default(NavDestination navDestination, NavDestination navDestination2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
        }
        if ((i & 1) != 0) {
            navDestination2 = null;
        }
        return navDestination.buildDeepLinkIds(navDestination2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] buildDeepLinkIds(androidx.navigation.NavDestination r6) {
        /*
            r5 = this;
            kotlin.collections.ArrayDeque r0 = new kotlin.collections.ArrayDeque
            r0.<init>()
            r1 = r5
        L6:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.navigation.NavGraph r2 = r1.parent
            if (r6 == 0) goto L10
            androidx.navigation.NavGraph r3 = r6.parent
            goto L11
        L10:
            r3 = 0
        L11:
            if (r3 == 0) goto L26
            androidx.navigation.NavGraph r3 = r6.parent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r4 = r1.getId()
            androidx.navigation.NavDestination r3 = r3.findNode(r4)
            if (r3 != r1) goto L26
            r0.addFirst(r1)
            goto L41
        L26:
            if (r2 == 0) goto L32
            int r3 = r2.getStartDestinationId()
            int r4 = r1.getId()
            if (r3 == r4) goto L35
        L32:
            r0.addFirst(r1)
        L35:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r6)
            if (r1 == 0) goto L3c
            goto L41
        L3c:
            r1 = r2
            androidx.navigation.NavDestination r1 = (androidx.navigation.NavDestination) r1
            if (r1 != 0) goto L6
        L41:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r6 = kotlin.collections.CollectionsKt.toList(r0)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r6 = r6.iterator()
        L5a:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L72
            java.lang.Object r1 = r6.next()
            androidx.navigation.NavDestination r1 = (androidx.navigation.NavDestination) r1
            int r1 = r1.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L5a
        L72:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            int[] r6 = kotlin.collections.CollectionsKt.toIntArray(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.buildDeepLinkIds(androidx.navigation.NavDestination):int[]");
    }

    public final boolean hasRoute(String route, Bundle arguments) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.hasRoute$navigation_common_release(route, arguments);
    }

    public final NavAction getAction(int id2) {
        NavAction navAction = this.actions.getIsEmpty() ? null : this.actions.get(id2);
        if (navAction != null) {
            return navAction;
        }
        NavGraph navGraph = this.parent;
        if (navGraph != null) {
            return navGraph.getAction(id2);
        }
        return null;
    }

    public final void putAction(int actionId, int destId) {
        putAction(actionId, new NavAction(destId, null, null, 6, null));
    }

    public final void putAction(int actionId, NavAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!supportsActions()) {
            throw new UnsupportedOperationException("Cannot add action " + actionId + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        }
        if (actionId == 0) {
            throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
        }
        this.actions.put(actionId, action);
    }

    public final void removeAction(int actionId) {
        this.actions.remove(actionId);
    }

    public final void addArgument(String argumentName, NavArgument argument) {
        Intrinsics.checkNotNullParameter(argumentName, "argumentName");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.impl.addArgument$navigation_common_release(argumentName, argument);
    }

    public final void removeArgument(String argumentName) {
        Intrinsics.checkNotNullParameter(argumentName, "argumentName");
        this.impl.removeArgument$navigation_common_release(argumentName);
    }

    public final Bundle addInDefaultArgs(Bundle args) {
        return this.impl.addInDefaultArgs$navigation_common_release(args);
    }

    public final String fillInLabel(Context context, Bundle bundle) {
        Map<String, Object> mapEmptyMap;
        String strValueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence charSequence = this.label;
        if (charSequence == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
        StringBuffer stringBuffer = new StringBuffer();
        if (bundle == null || (mapEmptyMap = SavedStateReader.m7887toMapimpl(SavedStateReader.m7806constructorimpl(bundle))) == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (strGroup == null || !mapEmptyMap.containsKey(strGroup)) {
                throw new IllegalArgumentException(("Could not find \"" + strGroup + "\" in " + bundle + " to fill label \"" + ((Object) charSequence) + '\"').toString());
            }
            matcher.appendReplacement(stringBuffer, "");
            NavArgument navArgument = getArguments().get(strGroup);
            NavType<Object> type = navArgument != null ? navArgument.getType() : null;
            if (Intrinsics.areEqual(type, NavType.ReferenceType)) {
                NavType<Integer> navType = NavType.ReferenceType;
                Intrinsics.checkNotNull(bundle);
                Integer num = navType.get(bundle, strGroup);
                Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
                strValueOf = context.getString(num.intValue());
            } else {
                Intrinsics.checkNotNull(type);
                Intrinsics.checkNotNull(bundle);
                strValueOf = String.valueOf(type.get(bundle, strGroup));
            }
            Intrinsics.checkNotNull(strValueOf);
            stringBuffer.append(strValueOf);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        if (getIdName() == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(getId()));
        } else {
            sb.append(getIdName());
        }
        sb.append(")");
        String route = getRoute();
        if (route != null && !StringsKt.isBlank(route)) {
            sb.append(" route=");
            sb.append(getRoute());
        }
        if (this.label != null) {
            sb.append(" label=");
            sb.append(this.label);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public boolean equals(Object other) {
        boolean z;
        boolean z2;
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof NavDestination)) {
            return false;
        }
        NavDestination navDestination = (NavDestination) other;
        boolean zAreEqual = Intrinsics.areEqual(getDeepLinks(), navDestination.getDeepLinks());
        if (this.actions.size() != navDestination.actions.size()) {
            z = false;
            break;
        }
        Iterator it = SequencesKt.asSequence(SparseArrayKt.keyIterator(this.actions)).iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (!Intrinsics.areEqual(this.actions.get(iIntValue), navDestination.actions.get(iIntValue))) {
                z = false;
                break;
            }
        }
        z = true;
        if (getArguments().size() != navDestination.getArguments().size()) {
            z2 = false;
            break;
        }
        for (Map.Entry entry : MapsKt.asSequence(getArguments())) {
            if (!navDestination.getArguments().containsKey(entry.getKey()) || !Intrinsics.areEqual(navDestination.getArguments().get(entry.getKey()), entry.getValue())) {
                z2 = false;
                break;
            }
        }
        z2 = true;
        return getId() == navDestination.getId() && Intrinsics.areEqual(getRoute(), navDestination.getRoute()) && zAreEqual && z && z2;
    }

    public int hashCode() {
        int id2 = getId() * 31;
        String route = getRoute();
        int iHashCode = id2 + (route != null ? route.hashCode() : 0);
        for (NavDeepLink navDeepLink : getDeepLinks()) {
            int i = iHashCode * 31;
            String uriPattern = navDeepLink.getUriPattern();
            int iHashCode2 = (i + (uriPattern != null ? uriPattern.hashCode() : 0)) * 31;
            String action = navDeepLink.getAction();
            int iHashCode3 = (iHashCode2 + (action != null ? action.hashCode() : 0)) * 31;
            String mimeType = navDeepLink.getMimeType();
            iHashCode = iHashCode3 + (mimeType != null ? mimeType.hashCode() : 0);
        }
        Iterator itValueIterator = SparseArrayKt.valueIterator(this.actions);
        while (itValueIterator.hasNext()) {
            NavAction navAction = (NavAction) itValueIterator.next();
            int destinationId = ((iHashCode * 31) + navAction.getDestinationId()) * 31;
            NavOptions navOptions = navAction.getNavOptions();
            iHashCode = destinationId + (navOptions != null ? navOptions.hashCode() : 0);
            Bundle defaultArguments = navAction.getDefaultArguments();
            if (defaultArguments != null) {
                iHashCode = (iHashCode * 31) + SavedStateReader.m7809contentDeepHashCodeimpl(SavedStateReader.m7806constructorimpl(defaultArguments));
            }
        }
        for (String str : getArguments().keySet()) {
            int iHashCode4 = ((iHashCode * 31) + str.hashCode()) * 31;
            NavArgument navArgument = getArguments().get(str);
            iHashCode = iHashCode4 + (navArgument != null ? navArgument.hashCode() : 0);
        }
        return iHashCode;
    }

    /* compiled from: NavDestination.android.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\t0\u0007\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0010\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\t0\u0007H\u0005J:\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\t0\u0007\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0010\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\t0\u0007H\u0007J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0007J\u0019\u0010\u001c\u001a\u00020\u001d\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u0001*\u00020\u0017H\u0087\bJ$\u0010\u001c\u001a\u00020\u001d\"\b\b\u0000\u0010\u001e*\u00020\u0001*\u00020\u00172\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001fH\u0007R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Landroidx/navigation/NavDestination$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", SdkConstants.FD_CLASSES_OUTPUT, "", "", "Ljava/lang/Class;", "parseClassFromName", "C", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "name", "expectedClassType", "parseClassFromNameInternal", "getDisplayName", "Landroidx/navigation/internal/NavContext;", "id", "", "createRoute", "route", "hierarchy", "Lkotlin/sequences/Sequence;", "Landroidx/navigation/NavDestination;", "getHierarchy$annotations", "(Landroidx/navigation/NavDestination;)V", "getHierarchy", "(Landroidx/navigation/NavDestination;)Lkotlin/sequences/Sequence;", "hasRoute", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getHierarchy$annotations(NavDestination navDestination) {
        }

        private Companion() {
        }

        @JvmStatic
        protected final <C> Class<? extends C> parseClassFromName(Context context, String name, Class<? extends C> expectedClassType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(expectedClassType, "expectedClassType");
            String str = name.charAt(0) == '.' ? context.getPackageName() + name : name;
            Class<? extends C> cls = (Class) NavDestination.classes.get(str);
            if (cls == null) {
                try {
                    cls = (Class<? extends C>) Class.forName(str, true, context.getClassLoader());
                    NavDestination.classes.put(name, cls);
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            Intrinsics.checkNotNull(cls);
            if (expectedClassType.isAssignableFrom(cls)) {
                return cls;
            }
            throw new IllegalArgumentException((str + " must be a subclass of " + expectedClassType).toString());
        }

        @JvmStatic
        public final <C> Class<? extends C> parseClassFromNameInternal(Context context, String name, Class<? extends C> expectedClassType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(expectedClassType, "expectedClassType");
            return NavDestination.parseClassFromName(context, name, expectedClassType);
        }

        @JvmStatic
        public final String getDisplayName(NavContext context, int id2) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (id2 <= 16777215) {
                return String.valueOf(id2);
            }
            return context.getResourceName(id2);
        }

        public final String createRoute(String route) {
            return route != null ? "android-app://androidx.navigation/" + route : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final NavDestination _get_hierarchy_$lambda$1(NavDestination it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getParent();
        }

        public final Sequence<NavDestination> getHierarchy(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            return SequencesKt.generateSequence(navDestination, (Function1<? super NavDestination, ? extends NavDestination>) new Function1() { // from class: androidx.navigation.NavDestination$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NavDestination.Companion._get_hierarchy_$lambda$1((NavDestination) obj);
                }
            });
        }

        @JvmStatic
        public final /* synthetic */ <T> boolean hasRoute(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return hasRoute(navDestination, Reflection.getOrCreateKotlinClass(Object.class));
        }

        @JvmStatic
        public final <T> boolean hasRoute(NavDestination navDestination, KClass<T> route) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            Intrinsics.checkNotNullParameter(route, "route");
            return RouteSerializerKt.generateHashCode(SerializersKt.serializer(route)) == navDestination.getId();
        }
    }
}
