package fm.feed.android.playersdk;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationCompat;
import com.android.SdkConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.sun.jna.platform.win32.LMErr;
import com.sun.jna.platform.win32.WinError;
import fm.feed.android.playersdk.FeedAudioPlayer;
import fm.feed.android.playersdk.FeedSession;
import fm.feed.android.playersdk.MixingAudioPlayer;
import fm.feed.android.playersdk.OfflineSession;
import fm.feed.android.playersdk.SessionTimeTracker;
import fm.feed.android.playersdk.models.AudioFile;
import fm.feed.android.playersdk.models.NotificationStyle;
import fm.feed.android.playersdk.models.Play;
import fm.feed.android.playersdk.models.PlayList;
import fm.feed.android.playersdk.models.Station;
import fm.feed.android.playersdk.models.StationList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: FeedAudioPlayer.kt */
@Metadata(d1 = {"\u0000\u0087\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b(*\tB\u0080\u0001\u008b\u0001\u009c\u0001§\u0001\u0018\u0000 \u008b\u00022\u00020\u0001:\b\u008a\u0002\u008b\u0002\u008c\u0002\u008d\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rBE\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0013J\n\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u0011\u0010¶\u0001\u001a\u00030µ\u00012\u0007\u0010·\u0001\u001a\u00020MJ\u0011\u0010¸\u0001\u001a\u00030µ\u00012\u0007\u0010¹\u0001\u001a\u00020\tJ\u0011\u0010º\u0001\u001a\u00030µ\u00012\u0007\u0010»\u0001\u001a\u00020VJ\u0013\u0010¼\u0001\u001a\u00030µ\u00012\t\u0010½\u0001\u001a\u0004\u0018\u00010XJ\u0011\u0010¾\u0001\u001a\u00030µ\u00012\u0007\u0010¿\u0001\u001a\u00020^J\u0011\u0010À\u0001\u001a\u00030µ\u00012\u0007\u0010Á\u0001\u001a\u00020aJ\u0011\u0010Â\u0001\u001a\u00030µ\u00012\u0007\u0010¹\u0001\u001a\u00020nJ\u0011\u0010Ã\u0001\u001a\u00030µ\u00012\u0007\u0010Ä\u0001\u001a\u00020rJ\u0011\u0010Å\u0001\u001a\u00030µ\u00012\u0007\u0010Æ\u0001\u001a\u00020tJ\u0011\u0010Ç\u0001\u001a\u00030µ\u00012\u0007\u0010¹\u0001\u001a\u00020wJ\u001c\u0010È\u0001\u001a\u00030µ\u00012\u0007\u0010É\u0001\u001a\u00020\u00112\u0007\u0010Ê\u0001\u001a\u00020\u0005H\u0002J\u0013\u0010È\u0001\u001a\u00030µ\u00012\u0007\u0010Ê\u0001\u001a\u00020\u0005H\u0002J\u0007\u0010Ë\u0001\u001a\u00020\u0011J\u0007\u0010Ì\u0001\u001a\u00020\u0011J\n\u0010Í\u0001\u001a\u00030µ\u0001H\u0002J\u0013\u0010\u0010\u001a\u00030µ\u00012\n\u0010Î\u0001\u001a\u0005\u0018\u00010Ï\u0001J\b\u0010Ð\u0001\u001a\u00030µ\u0001J\u0010\u0010Ñ\u0001\u001a\u00030µ\u00012\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010Ò\u0001\u001a\u00030µ\u0001J\b\u0010Ó\u0001\u001a\u00030µ\u0001J\u0014\u0010Ó\u0001\u001a\u00030µ\u00012\n\u0010Ô\u0001\u001a\u0005\u0018\u00010Õ\u0001J\u001a\u0010Ö\u0001\u001a\u00030µ\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010×\u0001\u001a\u00030Ø\u0001J#\u0010Ö\u0001\u001a\u00030µ\u00012\u0007\u0010Ù\u0001\u001a\u00020z2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010×\u0001\u001a\u00030Ø\u0001J\r\u0010Ú\u0001\u001a\b0Û\u0001R\u00030Ü\u0001J\b\u0010Ý\u0001\u001a\u00030µ\u0001J\u0014\u0010Ý\u0001\u001a\u00030µ\u00012\n\u0010Ô\u0001\u001a\u0005\u0018\u00010Õ\u0001J\u0011\u0010Þ\u0001\u001a\u00030µ\u00012\u0007\u0010ß\u0001\u001a\u00020\u0005J\u001a\u0010Þ\u0001\u001a\u00030µ\u00012\u0007\u0010ß\u0001\u001a\u00020\u00052\u0007\u0010à\u0001\u001a\u00020\u0001J\u000f\u0010á\u0001\u001a\u0004\u0018\u000106¢\u0006\u0003\u0010£\u0001J\b\u0010â\u0001\u001a\u00030µ\u0001J\b\u0010ã\u0001\u001a\u00030µ\u0001J\u001f\u0010ã\u0001\u001a\u00030µ\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u00012\t\b\u0002\u0010ä\u0001\u001a\u00020\u0011H\u0007J\u001d\u0010ã\u0001\u001a\u00030µ\u00012\u0006\u0010\u0014\u001a\u00020\u00152\t\b\u0002\u0010ä\u0001\u001a\u00020\u0011H\u0007J&\u0010ã\u0001\u001a\u00030µ\u00012\u000f\u0010å\u0001\u001a\n\u0012\u0005\u0012\u00030Õ\u00010æ\u00012\t\b\u0002\u0010ä\u0001\u001a\u00020\u0011H\u0007J\t\u0010ç\u0001\u001a\u00020\u0011H\u0002J\n\u0010è\u0001\u001a\u00030µ\u0001H\u0002J'\u0010è\u0001\u001a\u00030µ\u00012\u000e\u0010é\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150æ\u00012\u000b\b\u0002\u0010Î\u0001\u001a\u0004\u0018\u00010-H\u0007J!\u0010ê\u0001\u001a\u00030µ\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u00012\u000b\b\u0002\u0010Î\u0001\u001a\u0004\u0018\u00010XH\u0007J\u001d\u0010ê\u0001\u001a\u00030µ\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\t\u0010Î\u0001\u001a\u0004\u0018\u00010XJ\n\u0010ë\u0001\u001a\u00030µ\u0001H\u0002J\u0011\u0010ì\u0001\u001a\u00030µ\u00012\u0007\u0010·\u0001\u001a\u00020MJ\u0011\u0010í\u0001\u001a\u00030µ\u00012\u0007\u0010»\u0001\u001a\u00020VJ\u0011\u0010î\u0001\u001a\u00030µ\u00012\u0007\u0010½\u0001\u001a\u00020XJ\u0011\u0010ï\u0001\u001a\u00030µ\u00012\u0007\u0010¿\u0001\u001a\u00020^J\u0011\u0010ð\u0001\u001a\u00030µ\u00012\u0007\u0010Á\u0001\u001a\u00020aJ\u0011\u0010ñ\u0001\u001a\u00030µ\u00012\u0007\u0010¹\u0001\u001a\u00020nJ\u0011\u0010ò\u0001\u001a\u00030µ\u00012\u0007\u0010Ä\u0001\u001a\u00020rJ\u0011\u0010ó\u0001\u001a\u00030µ\u00012\u0007\u0010Æ\u0001\u001a\u00020tJ\u0011\u0010ô\u0001\u001a\u00030µ\u00012\u0007\u0010¹\u0001\u001a\u00020wJ\u0011\u0010õ\u0001\u001a\u00030µ\u00012\u0007\u0010ö\u0001\u001a\u000206J\u0011\u0010÷\u0001\u001a\u00030µ\u00012\u0007\u0010ø\u0001\u001a\u000206J%\u0010\u0019\u001a\u00030µ\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0007\u0010ä\u0001\u001a\u00020\u00112\t\b\u0002\u0010ù\u0001\u001a\u000206H\u0007J\u000f\u0010ú\u0001\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0005J\u0012\u0010û\u0001\u001a\u00030µ\u00012\u0006\u0010.\u001a\u00020\u0005H\u0002J\u0019\u0010ü\u0001\u001a\u00030µ\u00012\u0007\u0010ý\u0001\u001a\u00020ZH\u0000¢\u0006\u0003\bþ\u0001J\u0011\u0010ÿ\u0001\u001a\u00030µ\u00012\u0007\u0010\u0080\u0002\u001a\u00020cJ\u0011\u0010\u0081\u0002\u001a\u00030µ\u00012\u0007\u0010\u0082\u0002\u001a\u000206J\b\u0010\u0083\u0002\u001a\u00030µ\u0001J\u0013\u0010\u0083\u0002\u001a\u00030µ\u00012\t\u0010\u0084\u0002\u001a\u0004\u0018\u00010nJ\b\u0010\u0085\u0002\u001a\u00030µ\u0001J\u0011\u0010\u0086\u0002\u001a\u00030µ\u00012\u0007\u0010Ê\u0001\u001a\u00020\u0005J\b\u0010\u0087\u0002\u001a\u00030µ\u0001J\b\u0010\u0088\u0002\u001a\u00030µ\u0001J\u0014\u0010\u0088\u0002\u001a\u00030µ\u00012\n\u0010Ô\u0001\u001a\u0005\u0018\u00010Õ\u0001J\u0011\u0010\u0089\u0002\u001a\u00030µ\u00012\u0007\u0010Î\u0001\u001a\u00020hR(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010.\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0013\u00101\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0011\u00109\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b:\u00108R\u000e\u0010;\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010CR\u0011\u0010D\u001a\u00020E8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010K\u001a\u0012\u0012\u0004\u0012\u00020M0Lj\b\u0012\u0004\u0012\u00020M`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\t0Lj\b\u0012\u0004\u0012\u00020\t`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010U\u001a\u0012\u0012\u0004\u0012\u00020V0Lj\b\u0012\u0004\u0012\u00020V`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010W\u001a\u0012\u0012\u0004\u0012\u00020X0Lj\b\u0012\u0004\u0012\u00020X`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010]\u001a\u0012\u0012\u0004\u0012\u00020^0Lj\b\u0012\u0004\u0012\u00020^`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010_\u001a\u0012\u0012\u0004\u0012\u0002020Lj\b\u0012\u0004\u0012\u000202`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010`\u001a\u0012\u0012\u0004\u0012\u00020a0Lj\b\u0012\u0004\u0012\u00020a`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010g\u001a\u0004\u0018\u00010hX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001e\u0010m\u001a\u0012\u0012\u0004\u0012\u00020n0Lj\b\u0012\u0004\u0012\u00020n`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020pX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010q\u001a\u0012\u0012\u0004\u0012\u00020r0Lj\b\u0012\u0004\u0012\u00020r`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010s\u001a\u0012\u0012\u0004\u0012\u00020t0Lj\b\u0012\u0004\u0012\u00020t`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010v\u001a\u0012\u0012\u0004\u0012\u00020w0Lj\b\u0012\u0004\u0012\u00020w`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010y\u001a\u00020z2\u0006\u0010y\u001a\u00020z8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u0012\u0010\u007f\u001a\u00030\u0080\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0081\u0001R\u0016\u0010\u0082\u0001\u001a\t\u0018\u00010\u0083\u0001R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u00012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0013\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008c\u0001R\u0015\u0010\u008d\u0001\u001a\u00030\u008e\u00018F¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R0\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001b\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0098\u00018F¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0013\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u009d\u0001R#\u0010\u009f\u0001\u001a\u00020E2\u0007\u0010\u009e\u0001\u001a\u00020E8F@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010GR.\u0010¡\u0001\u001a\u0004\u0018\u0001062\t\u0010¡\u0001\u001a\u0004\u0018\u0001068F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R\u0013\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¨\u0001R\u0010\u0010©\u0001\u001a\u00030ª\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010«\u0001\u001a\u00030¬\u0001X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u00ad\u0001\u001a\u00020p2\u0007\u0010\u00ad\u0001\u001a\u00020p8F@BX\u0086\u000e¢\u0006\u0010\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u0013\u0010²\u0001\u001a\u00020E8F¢\u0006\u0007\u001a\u0005\b³\u0001\u0010G¨\u0006\u008e\u0002"}, d2 = {"Lfm/feed/android/playersdk/FeedAudioPlayer;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "token", "", "secret", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "availabilityListener", "Lfm/feed/android/playersdk/AvailabilityListener;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lfm/feed/android/playersdk/AvailabilityListener;)V", LocationCompat.EXTRA_IS_MOCK, "Lfm/feed/android/playersdk/MockLocations;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lfm/feed/android/playersdk/AvailabilityListener;Lfm/feed/android/playersdk/MockLocations;)V", "mContext", "exportedClientId", "createNewClientId", "", "location", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lfm/feed/android/playersdk/AvailabilityListener;Ljava/lang/String;ZLfm/feed/android/playersdk/MockLocations;)V", "station", "Lfm/feed/android/playersdk/models/Station;", "activeStation", "getActiveStation", "()Lfm/feed/android/playersdk/models/Station;", "setActiveStation", "(Lfm/feed/android/playersdk/models/Station;)V", "afChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", SdkConstants.TAG_BITMAP, "Landroid/graphics/Bitmap;", "artWork", "getArtWork", "()Landroid/graphics/Bitmap;", "setArtWork", "(Landroid/graphics/Bitmap;)V", "bIsSkipping", "getBIsSkipping", "()Z", "setBIsSkipping", "(Z)V", "bIsUpdatingSession", "getBIsUpdatingSession", "setBIsUpdatingSession", "cachePreparedListener", "Lfm/feed/android/playersdk/CachePreparedListener;", "clientId", "getClientId", "()Ljava/lang/String;", "currentPlay", "Lfm/feed/android/playersdk/models/Play;", "getCurrentPlay", "()Lfm/feed/android/playersdk/models/Play;", "currentPlayDuration", "", "getCurrentPlayDuration", "()F", "currentPlaybackTime", "getCurrentPlaybackTime", "focusLock", "focusRequest", "Landroid/media/AudioFocusRequest;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "isOfflineStationActive", "lifecycleListener", "fm/feed/android/playersdk/FeedAudioPlayer$lifecycleListener$1", "Lfm/feed/android/playersdk/FeedAudioPlayer$lifecycleListener$1;", "localOfflineStationList", "Lfm/feed/android/playersdk/models/StationList;", "getLocalOfflineStationList", "()Lfm/feed/android/playersdk/models/StationList;", "log", "Lfm/feed/android/playersdk/FMLog;", "mAdvanceOnNextItemReady", "mAudioFocusListeners", "Ljava/util/ArrayList;", "Lfm/feed/android/playersdk/AudioFocusListener;", "Lkotlin/collections/ArrayList;", "mAudioManager", "Landroid/media/AudioManager;", "mAvailabilityListeners", "mExoMixingAudioPlayer", "Lfm/feed/android/playersdk/ExoMixingAudioPlayer;", "mLastUpdate", "mLikeStatusChangeListener", "Lfm/feed/android/playersdk/LikeStatusChangeListener;", "mMusicQueuedListeners", "Lfm/feed/android/playersdk/MusicQueuedListener;", "mNotificationDataListener", "Lfm/feed/android/playersdk/NotificationDataListener;", "mOfflineSession", "Lfm/feed/android/playersdk/OfflineSession;", "mOutOfMusicListeners", "Lfm/feed/android/playersdk/OutOfMusicListener;", "mPlayHistory", "mPlayListeners", "Lfm/feed/android/playersdk/PlayListener;", "mPlayer", "Lfm/feed/android/playersdk/MixingAudioPlayer;", "mResumePlaybackOnAudioFocusGain", "mSession", "Lfm/feed/android/playersdk/FeedSession;", "mSessionUpdateListener", "Lfm/feed/android/playersdk/SessionUpdateListener;", "getMSessionUpdateListener", "()Lfm/feed/android/playersdk/SessionUpdateListener;", "setMSessionUpdateListener", "(Lfm/feed/android/playersdk/SessionUpdateListener;)V", "mSkipListeners", "Lfm/feed/android/playersdk/SkipListener;", "mState", "Lfm/feed/android/playersdk/State;", "mStateListeners", "Lfm/feed/android/playersdk/StateListener;", "mStationChangedListener", "Lfm/feed/android/playersdk/StationChangedListener;", "mTransientVolume", "mUnhandledErrorListeners", "Lfm/feed/android/playersdk/UnhandledErrorListener;", "mVolume", "maxBitrate", "", "getMaxBitrate", "()I", "setMaxBitrate", "(I)V", "mixingAudioPlayerEventListener", "fm/feed/android/playersdk/FeedAudioPlayer$mixingAudioPlayerEventListener$1", "Lfm/feed/android/playersdk/FeedAudioPlayer$mixingAudioPlayerEventListener$1;", "networkMonitor", "Lfm/feed/android/playersdk/FeedAudioPlayer$ConnectionStateMonitor;", "notificationStyle", "Lfm/feed/android/playersdk/models/NotificationStyle;", "getNotificationStyle", "()Lfm/feed/android/playersdk/models/NotificationStyle;", "setNotificationStyle", "(Lfm/feed/android/playersdk/models/NotificationStyle;)V", "offlineEventListener", "fm/feed/android/playersdk/FeedAudioPlayer$offlineEventListener$1", "Lfm/feed/android/playersdk/FeedAudioPlayer$offlineEventListener$1;", "offlineStorageUsed", "", "getOfflineStorageUsed", "()J", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "getPendingIntent", "()Landroid/app/PendingIntent;", "setPendingIntent", "(Landroid/app/PendingIntent;)V", "playHistory", "", "getPlayHistory", "()Ljava/util/List;", "playlistListener", "fm/feed/android/playersdk/FeedAudioPlayer$playlistListener$1", "Lfm/feed/android/playersdk/FeedAudioPlayer$playlistListener$1;", "<set-?>", "remoteOfflineStationList", "getRemoteOfflineStationList", "secondsOfCrossfade", "getSecondsOfCrossfade", "()Ljava/lang/Float;", "setSecondsOfCrossfade", "(Ljava/lang/Float;)V", "sessionEventListener", "fm/feed/android/playersdk/FeedAudioPlayer$sessionEventListener$1", "Lfm/feed/android/playersdk/FeedAudioPlayer$sessionEventListener$1;", "sessionTimeTracker", "Lfm/feed/android/playersdk/SessionTimeTracker;", "songProvider", "Lfm/feed/android/playersdk/NextSongProvider;", ServerProtocol.DIALOG_PARAM_STATE, "getState", "()Lfm/feed/android/playersdk/State;", "setState", "(Lfm/feed/android/playersdk/State;)V", "stationList", "getStationList", "activeStationDidChange", "", "addAudioFocusListener", "audioFocusListener", "addAvailabilityListener", "eventListener", "addLikeStatusChangeListener", "likeStatusChangeListener", "addMusicQueuedListener", "musicQueuedListener", "addOutOfMusicListener", "outOfMusicListener", "addPlayListener", "playListener", "addSkipListener", "addStateListener", "stateListener", "addStationChangedListener", "stationChangedListener", "addUnhandledErrorListener", "assert", "bool", "msg", "canSeek", "canSkip", "checkAndAnnounceEndOfPlaylist", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lfm/feed/android/playersdk/ClientIdListener;", "deleteAllOfflineStations", "deleteOfflineStation", "destroyInstance", "dislike", "audioFile", "Lfm/feed/android/playersdk/models/AudioFile;", "downloadAndSync", "downloadListener", "Lfm/feed/android/playersdk/StationDownloadListener;", "targetMins", "getPlayQueueEditor", "Lfm/feed/android/playersdk/models/PlayList$Editor;", "Lfm/feed/android/playersdk/models/PlayList;", "like", "logEvent", NotificationCompat.CATEGORY_EVENT, NativeProtocol.WEB_DIALOG_PARAMS, "maxSeekableLengthInSeconds", "pause", "play", "withCrossfade", "audioFiles", "", "prePlayCheck", "prepareStations", "stations", "prepareToPlay", "removeAllListeners", "removeAudioFocusListener", "removeLikeStatusChangeListener", "removeMusicQueuedListener", "removeOutOfMusicListener", "removePlayListener", "removeSkipListener", "removeStateListener", "removeStationChangedListener", "removeUnhandledErrorListener", "seek", "position", "seekCurrentStationBy", "seconds", "advanceBy", "setClientId", "setClientIdAndResetSession", "setNotificationDataListener", "nl", "setNotificationDataListener$PlayerSdk_exoDefaultRelease", "setPlayer", "player", "setVolume", "volume", SdkConstants.TAG_SKIP, "skipListener", "stop", "submitLogsForRemoteDebuggingWithLabel", "switchToDefaultPlayer", "unlike", "updateSession", "Builder", "Companion", "ConnectionStateMonitor", "MusicSource", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class FeedAudioPlayer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXPORT_CLIENT_ID_PREFIX = "fmcidv1:";
    private static final int UPDATE_PERIOD = 10;
    private static boolean autoNetworkRetry;
    private static boolean disableAudioFocus;
    private final AudioManager.OnAudioFocusChangeListener afChangeListener;
    private Bitmap artWork;
    private boolean bIsSkipping;
    private boolean bIsUpdatingSession;
    private CachePreparedListener cachePreparedListener;
    private final Object focusLock;
    private AudioFocusRequest focusRequest;
    private final CoroutineScope ioScope;
    private boolean isOfflineStationActive;
    private final FeedAudioPlayer$lifecycleListener$1 lifecycleListener;
    private final FMLog log;
    private boolean mAdvanceOnNextItemReady;
    private final ArrayList<AudioFocusListener> mAudioFocusListeners;
    private final AudioManager mAudioManager;
    private final ArrayList<AvailabilityListener> mAvailabilityListeners;
    private final Context mContext;
    private ExoMixingAudioPlayer mExoMixingAudioPlayer;
    private float mLastUpdate;
    private final ArrayList<LikeStatusChangeListener> mLikeStatusChangeListener;
    private final ArrayList<MusicQueuedListener> mMusicQueuedListeners;
    private NotificationDataListener mNotificationDataListener;
    private OfflineSession mOfflineSession;
    private final ArrayList<OutOfMusicListener> mOutOfMusicListeners;
    private final ArrayList<Play> mPlayHistory;
    private final ArrayList<PlayListener> mPlayListeners;
    private MixingAudioPlayer mPlayer;
    private boolean mResumePlaybackOnAudioFocusGain;
    private FeedSession mSession;
    private SessionUpdateListener mSessionUpdateListener;
    private final ArrayList<SkipListener> mSkipListeners;
    private State mState;
    private final ArrayList<StateListener> mStateListeners;
    private final ArrayList<StationChangedListener> mStationChangedListener;
    private float mTransientVolume;
    private final ArrayList<UnhandledErrorListener> mUnhandledErrorListeners;
    private float mVolume;
    private final FeedAudioPlayer$mixingAudioPlayerEventListener$1 mixingAudioPlayerEventListener;
    private ConnectionStateMonitor networkMonitor;
    private NotificationStyle notificationStyle;
    private final FeedAudioPlayer$offlineEventListener$1 offlineEventListener;
    private PendingIntent pendingIntent;
    private FeedAudioPlayer$playlistListener$1 playlistListener;
    private StationList remoteOfflineStationList;
    private final FeedAudioPlayer$sessionEventListener$1 sessionEventListener;
    private final SessionTimeTracker sessionTimeTracker;
    private NextSongProvider songProvider;

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lfm/feed/android/playersdk/FeedAudioPlayer$MusicSource;", "", "(Ljava/lang/String;I)V", "STATION", "ON_DEMAND", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum MusicSource {
        STATION,
        ON_DEMAND
    }

    public /* synthetic */ FeedAudioPlayer(Context context, String str, String str2, AvailabilityListener availabilityListener, String str3, boolean z, MockLocations mockLocations, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, availabilityListener, str3, z, mockLocations);
    }

    public static final boolean getAutoNetworkRetry() {
        return INSTANCE.getAutoNetworkRetry();
    }

    public static final boolean getDisableAudioFocus() {
        return INSTANCE.getDisableAudioFocus();
    }

    public static final void setAutoNetworkRetry(boolean z) {
        INSTANCE.setAutoNetworkRetry(z);
    }

    @JvmStatic
    public static final void setBaseUrl(String str) throws SecurityException {
        INSTANCE.setBaseUrl(str);
    }

    public static final void setDisableAudioFocus(boolean z) {
        INSTANCE.setDisableAudioFocus(z);
    }

    public final boolean canSeek() {
        return true;
    }

    public final void play(AudioFile audioFile) {
        Intrinsics.checkNotNullParameter(audioFile, "audioFile");
        play$default(this, audioFile, false, 2, (Object) null);
    }

    public final void play(Station station) throws JSONException {
        Intrinsics.checkNotNullParameter(station, "station");
        play$default(this, station, false, 2, (Object) null);
    }

    public final void play(List<AudioFile> audioFiles) {
        Intrinsics.checkNotNullParameter(audioFiles, "audioFiles");
        play$default(this, (List) audioFiles, false, 2, (Object) null);
    }

    public final void prepareStations(List<Station> stations) {
        Intrinsics.checkNotNullParameter(stations, "stations");
        prepareStations$default(this, stations, null, 2, null);
    }

    public final void prepareToPlay(AudioFile audioFile) {
        Intrinsics.checkNotNullParameter(audioFile, "audioFile");
        prepareToPlay$default(this, audioFile, null, 2, null);
    }

    public final void setActiveStation(Station station, boolean z) throws JSONException {
        Intrinsics.checkNotNullParameter(station, "station");
        setActiveStation$default(this, station, z, 0.0f, 4, null);
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [fm.feed.android.playersdk.FeedAudioPlayer$mixingAudioPlayerEventListener$1] */
    /* JADX WARN: Type inference failed for: r2v20, types: [fm.feed.android.playersdk.FeedAudioPlayer$lifecycleListener$1] */
    /* JADX WARN: Type inference failed for: r3v1, types: [fm.feed.android.playersdk.FeedAudioPlayer$offlineEventListener$1] */
    /* JADX WARN: Type inference failed for: r4v1, types: [fm.feed.android.playersdk.FeedAudioPlayer$playlistListener$1] */
    private FeedAudioPlayer(Context context, String str, String str2, AvailabilityListener availabilityListener, String str3, boolean z, MockLocations mockLocations) {
        this.mContext = context;
        this.log = new FMLog("fm.feed.FeedAudioPlayer");
        this.mVolume = 1.0f;
        this.mTransientVolume = 1.0f;
        this.mState = State.UNINITIALIZED;
        Object systemService = context.getSystemService("audio");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
        }
        this.mAudioManager = (AudioManager) systemService;
        this.mPlayHistory = new ArrayList<>();
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.ioScope = CoroutineScope;
        this.mMusicQueuedListeners = new ArrayList<>();
        this.mAvailabilityListeners = new ArrayList<>();
        this.mStateListeners = new ArrayList<>();
        this.mStationChangedListener = new ArrayList<>();
        this.mPlayListeners = new ArrayList<>();
        this.mUnhandledErrorListeners = new ArrayList<>();
        this.mSkipListeners = new ArrayList<>();
        this.mLikeStatusChangeListener = new ArrayList<>();
        this.mOutOfMusicListeners = new ArrayList<>();
        this.mAudioFocusListeners = new ArrayList<>();
        this.notificationStyle = new NotificationStyle();
        ?? r2 = new SessionTimeTracker.LifecycleListener() { // from class: fm.feed.android.playersdk.FeedAudioPlayer$lifecycleListener$1
            @Override // fm.feed.android.playersdk.SessionTimeTracker.LifecycleListener
            public void onApplicationBackgrounded() throws JSONException {
                Play currentPlay;
                MixingAudioPlayer mixingAudioPlayer = this.this$0.mPlayer;
                FeedSession feedSession = null;
                if (mixingAudioPlayer != null && (currentPlay = mixingAudioPlayer.getCurrentPlay()) != null) {
                    FeedAudioPlayer feedAudioPlayer = this.this$0;
                    FeedSession feedSession2 = feedAudioPlayer.mSession;
                    if (feedSession2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSession");
                        feedSession2 = null;
                    }
                    feedSession2.updatePlayTime(currentPlay, Float.valueOf(feedAudioPlayer.getCurrentPlaybackTime() - currentPlay.getAudioFile().getStartTrim()));
                }
                this.this$0.logEvent("backgrounded");
                FeedSession feedSession3 = this.this$0.mSession;
                if (feedSession3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSession");
                } else {
                    feedSession = feedSession3;
                }
                if (feedSession.getLogEverything()) {
                    this.this$0.submitLogsForRemoteDebuggingWithLabel("Logging Everything, app backgrounded");
                }
            }

            @Override // fm.feed.android.playersdk.SessionTimeTracker.LifecycleListener
            public void onApplicationForegrounded() throws JSONException {
                this.this$0.logEvent("launched");
            }
        };
        this.lifecycleListener = r2;
        SessionTimeTracker sessionTimeTracker = new SessionTimeTracker((SessionTimeTracker.LifecycleListener) r2);
        this.sessionTimeTracker = sessionTimeTracker;
        this.afChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: fm.feed.android.playersdk.FeedAudioPlayer$$ExternalSyntheticLambda0
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i) {
                FeedAudioPlayer.m8775afChangeListener$lambda0(this.f$0, i);
            }
        };
        this.focusLock = new Object();
        ?? r13 = new MixingAudioPlayer.EventListener() { // from class: fm.feed.android.playersdk.FeedAudioPlayer$mixingAudioPlayerEventListener$1
            private float elapsedTime;
            private float elapsedTimeCounter;

            public final float getElapsedTime() {
                return this.elapsedTime;
            }

            public final void setElapsedTime(float f) {
                this.elapsedTime = f;
            }

            public final float getElapsedTimeCounter() {
                return this.elapsedTimeCounter;
            }

            public final void setElapsedTimeCounter(float f) {
                this.elapsedTimeCounter = f;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
            @Override // fm.feed.android.playersdk.MixingAudioPlayer.EventListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onPlayItemReadyForPlayback(fm.feed.android.playersdk.models.Play r6) {
                /*
                    r5 = this;
                    java.lang.String r0 = "play"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    fm.feed.android.playersdk.FeedAudioPlayer r0 = r5.this$0
                    fm.feed.android.playersdk.FMLog r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getLog$p(r0)
                    java.lang.String r1 = "play has become ready for playback: "
                    java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r6)
                    r2 = 0
                    r3 = 2
                    fm.feed.android.playersdk.FMLog.v$default(r0, r1, r2, r3, r2)
                    fm.feed.android.playersdk.FeedAudioPlayer r0 = r5.this$0
                    fm.feed.android.playersdk.State r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMState$p(r0)
                    fm.feed.android.playersdk.State r1 = fm.feed.android.playersdk.State.READY_TO_PLAY
                    r4 = 0
                    if (r0 != r1) goto L4f
                    fm.feed.android.playersdk.FeedAudioPlayer r6 = r5.this$0
                    fm.feed.android.playersdk.FMLog r6 = fm.feed.android.playersdk.FeedAudioPlayer.access$getLog$p(r6)
                    java.lang.String r0 = "notifying listeners that music is queued"
                    fm.feed.android.playersdk.FMLog.v$default(r6, r0, r2, r3, r2)
                L2c:
                    fm.feed.android.playersdk.FeedAudioPlayer r6 = r5.this$0
                    java.util.ArrayList r6 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMMusicQueuedListeners$p(r6)
                    java.util.Collection r6 = (java.util.Collection) r6
                    boolean r6 = r6.isEmpty()
                    if (r6 != 0) goto Lab
                    fm.feed.android.playersdk.FeedAudioPlayer r6 = r5.this$0
                    java.util.ArrayList r6 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMMusicQueuedListeners$p(r6)
                    java.lang.Object r6 = r6.remove(r4)
                    java.lang.String r0 = "mMusicQueuedListeners.removeAt(0)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
                    fm.feed.android.playersdk.MusicQueuedListener r6 = (fm.feed.android.playersdk.MusicQueuedListener) r6
                    r6.onMusicQueued()
                    goto L2c
                L4f:
                    fm.feed.android.playersdk.FeedAudioPlayer r0 = r5.this$0
                    boolean r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMAdvanceOnNextItemReady$p(r0)
                    if (r0 == 0) goto Lab
                    fm.feed.android.playersdk.FeedAudioPlayer r0 = r5.this$0
                    boolean r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$isOfflineStationActive$p(r0)
                    if (r0 == 0) goto L77
                    fm.feed.android.playersdk.FeedAudioPlayer r0 = r5.this$0
                    fm.feed.android.playersdk.OfflineSession r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMOfflineSession$p(r0)
                    if (r0 != 0) goto L6d
                    java.lang.String r0 = "mOfflineSession"
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                    r0 = r2
                L6d:
                    fm.feed.android.playersdk.models.Play r0 = r0.getNextItem()
                    boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
                    if (r0 != 0) goto L8f
                L77:
                    fm.feed.android.playersdk.FeedAudioPlayer r0 = r5.this$0
                    fm.feed.android.playersdk.NextSongProvider r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r0)
                    if (r0 != 0) goto L85
                    java.lang.String r0 = "songProvider"
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                    r0 = r2
                L85:
                    fm.feed.android.playersdk.models.Play r0 = r0.getNextItem()
                    boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
                    if (r6 == 0) goto Lab
                L8f:
                    fm.feed.android.playersdk.FeedAudioPlayer r6 = r5.this$0
                    fm.feed.android.playersdk.FMLog r6 = fm.feed.android.playersdk.FeedAudioPlayer.access$getLog$p(r6)
                    java.lang.String r0 = "advancing to next play"
                    fm.feed.android.playersdk.FMLog.d$default(r6, r0, r2, r3, r2)
                    fm.feed.android.playersdk.FeedAudioPlayer r6 = r5.this$0
                    fm.feed.android.playersdk.FeedAudioPlayer.access$setMAdvanceOnNextItemReady$p(r6, r4)
                    fm.feed.android.playersdk.FeedAudioPlayer r6 = r5.this$0
                    fm.feed.android.playersdk.MixingAudioPlayer r6 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMPlayer$p(r6)
                    if (r6 != 0) goto La8
                    goto Lab
                La8:
                    r6.skipWithCrossFade()
                Lab:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer$mixingAudioPlayerEventListener$1.onPlayItemReadyForPlayback(fm.feed.android.playersdk.models.Play):void");
            }

            @Override // fm.feed.android.playersdk.MixingAudioPlayer.EventListener
            public void onPlayItemBeganPlayback(int waitingTime, Play play, long bufferingTime) throws JSONException {
                Intrinsics.checkNotNullParameter(play, "play");
                this.elapsedTime = 0.0f;
                this.this$0.mLastUpdate = 0.0f;
                this.elapsedTimeCounter = 0.0f;
                NextSongProvider nextSongProvider = null;
                OfflineSession offlineSession = null;
                FMLog.d$default(this.this$0.log, "Announcing play start for " + play + ", with bufferingTime = " + bufferingTime + ", and waitingTime = " + waitingTime, null, 2, null);
                if (this.this$0.isOfflineStationActive) {
                    OfflineSession offlineSession2 = this.this$0.mOfflineSession;
                    if (offlineSession2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                    } else {
                        offlineSession = offlineSession2;
                    }
                    offlineSession.playStarted();
                    return;
                }
                NextSongProvider nextSongProvider2 = this.this$0.songProvider;
                if (nextSongProvider2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                } else {
                    nextSongProvider = nextSongProvider2;
                }
                nextSongProvider.setCurrentItem(play);
                this.this$0.mPlayHistory.add(play);
                Iterator it = this.this$0.mPlayListeners.iterator();
                while (it.hasNext()) {
                    ((PlayListener) it.next()).onPlayStarted(this.this$0.getCurrentPlay());
                }
                this.this$0.checkAndAnnounceEndOfPlaylist();
                BuildersKt__Builders_commonKt.launch$default(this.this$0.ioScope, null, null, new FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayItemBeganPlayback$1(this.this$0, play, bufferingTime, waitingTime, null), 3, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // fm.feed.android.playersdk.MixingAudioPlayer.EventListener
            public void onPlayItemFinishedPlayback(Play play, int reason, float timePlayed, Exception error) throws JSONException {
                String localizedMessage;
                Intrinsics.checkNotNullParameter(play, "play");
                this.elapsedTime = 0.0f;
                this.elapsedTimeCounter = 0.0f;
                this.this$0.mLastUpdate = 0.0f;
                OfflineSession offlineSession = null;
                FMLog.d$default(this.this$0.log, "Play has finished: " + play + " with reason " + reason + ((Object) (error == null ? null : error.getMessage())), null, 2, null);
                if (reason != 0) {
                    if (reason == 3) {
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        String str4 = "";
                        T t = str4;
                        if (error != null) {
                            try {
                                Throwable cause = error.getCause();
                                t = (cause == null || (localizedMessage = cause.getLocalizedMessage()) == null) ? str4 : localizedMessage;
                            } catch (Exception e) {
                                objectRef.element = "Error while retrieving error";
                                FMLog.d$default(this.this$0.log, Intrinsics.stringPlus("Problem retrieving completion error reason \n", e.getStackTrace()), null, 2, null);
                            }
                        }
                        objectRef.element = t;
                        if (this.this$0.isOfflineStationActive) {
                            OfflineSession offlineSession2 = this.this$0.mOfflineSession;
                            if (offlineSession2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                                offlineSession2 = null;
                            }
                            offlineSession2.rejectItem(play.getAudioFile());
                        } else {
                            this.this$0.checkAndAnnounceEndOfPlaylist();
                            BuildersKt__Builders_commonKt.launch$default(this.this$0.ioScope, null, null, new FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayItemFinishedPlayback$1(this.this$0, play, objectRef, null), 3, null);
                        }
                    }
                } else if (this.this$0.isOfflineStationActive) {
                    OfflineSession offlineSession3 = this.this$0.mOfflineSession;
                    if (offlineSession3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                        offlineSession3 = null;
                    }
                    offlineSession3.updatePlayCompleted();
                } else {
                    FeedSession feedSession = this.this$0.mSession;
                    if (feedSession == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSession");
                        feedSession = null;
                    }
                    feedSession.playCompleted(play, timePlayed - play.getAudioFile().getStartTrim());
                }
                if (reason != 2) {
                    if (!this.this$0.isOfflineStationActive) {
                        BuildersKt__Builders_commonKt.launch$default(this.this$0.ioScope, null, null, new FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayItemFinishedPlayback$2(this.this$0, play, null), 3, null);
                        return;
                    }
                    OfflineSession offlineSession4 = this.this$0.mOfflineSession;
                    if (offlineSession4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                    } else {
                        offlineSession = offlineSession4;
                    }
                    offlineSession.requestNextItem();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // fm.feed.android.playersdk.MixingAudioPlayer.EventListener
            public void onPlayFailedToPrepare(Play play, Exception error) throws JSONException {
                Intrinsics.checkNotNullParameter(play, "play");
                Intrinsics.checkNotNullParameter(error, "error");
                OfflineSession offlineSession = null;
                FMLog.d$default(this.this$0.log, "Play failed to prepare: " + play + " \n" + error.getStackTrace(), null, 2, null);
                if (this.this$0.isOfflineStationActive) {
                    if (error.getMessage() == null) {
                        return;
                    }
                    OfflineSession offlineSession2 = this.this$0.mOfflineSession;
                    if (offlineSession2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                    } else {
                        offlineSession = offlineSession2;
                    }
                    offlineSession.rejectItem(play.getAudioFile());
                    return;
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                try {
                    Throwable cause = error.getCause();
                    String str4 = "";
                    T t = str4;
                    if (cause != null) {
                        String localizedMessage = cause.getLocalizedMessage();
                        t = localizedMessage == null ? str4 : localizedMessage;
                    }
                    objectRef.element = t;
                } catch (Exception e) {
                    objectRef.element = "Error while retrieving error";
                    FMLog.e$default(this.this$0.log, Intrinsics.stringPlus("Problem retrieving completion error reason", e.getStackTrace()), null, 2, null);
                }
                BuildersKt__Builders_commonKt.launch$default(this.this$0.ioScope, null, null, new FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayFailedToPrepare$2(this.this$0, play, objectRef, null), 3, null);
            }

            @Override // fm.feed.android.playersdk.MixingAudioPlayer.EventListener
            public void onProgressUpdate(Play play, float elapsedTime, float duration) throws JSONException {
                Intrinsics.checkNotNullParameter(play, "play");
                if (this.elapsedTime != elapsedTime) {
                    Iterator it = this.this$0.mPlayListeners.iterator();
                    while (it.hasNext()) {
                        ((PlayListener) it.next()).onProgressUpdate(play, elapsedTime, duration);
                    }
                    return;
                }
                float f = this.elapsedTimeCounter + 1.0f;
                this.elapsedTimeCounter = f;
                if (f >= 5.0f) {
                    FeedSession feedSession = null;
                    OfflineSession offlineSession = null;
                    FMLog.e$default(this.this$0.log, Intrinsics.stringPlus("PLAYER NEEDED RESET at elapsed time ", Float.valueOf(elapsedTime)), null, 2, null);
                    if (this.this$0.isOfflineStationActive) {
                        OfflineSession offlineSession2 = this.this$0.mOfflineSession;
                        if (offlineSession2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                        } else {
                            offlineSession = offlineSession2;
                        }
                        offlineSession.logEvent("ANDROID PLAYER STUCK NEEDED RESET at ", String.valueOf(elapsedTime));
                    } else {
                        FeedSession feedSession2 = this.this$0.mSession;
                        if (feedSession2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSession");
                        } else {
                            feedSession = feedSession2;
                        }
                        feedSession.logEvent("ANDROID PLAYER STUCK NEEDED RESET at ", Float.valueOf(elapsedTime));
                    }
                    this.this$0.stop();
                }
            }

            @Override // fm.feed.android.playersdk.MixingAudioPlayer.EventListener
            public void onPlayerStateChanged(State playerState) throws JSONException {
                Play currentPlay;
                FeedAudioPlayer feedAudioPlayer;
                MixingAudioPlayer mixingAudioPlayer;
                Intrinsics.checkNotNullParameter(playerState, "playerState");
                FeedSession feedSession = null;
                OfflineSession offlineSession = null;
                if (playerState == State.PAUSED) {
                    if (this.this$0.isOfflineStationActive) {
                        MixingAudioPlayer mixingAudioPlayer2 = this.this$0.mPlayer;
                        if (mixingAudioPlayer2 != null) {
                            float currentPlayTime = mixingAudioPlayer2.getCurrentPlayTime();
                            OfflineSession offlineSession2 = this.this$0.mOfflineSession;
                            if (offlineSession2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                            } else {
                                offlineSession = offlineSession2;
                            }
                            offlineSession.updatePlayTime(Float.valueOf(currentPlayTime));
                        }
                    } else {
                        MixingAudioPlayer mixingAudioPlayer3 = this.this$0.mPlayer;
                        if (mixingAudioPlayer3 != null && (currentPlay = mixingAudioPlayer3.getCurrentPlay()) != null && (mixingAudioPlayer = (feedAudioPlayer = this.this$0).mPlayer) != null) {
                            float currentPlayTime2 = mixingAudioPlayer.getCurrentPlayTime();
                            FeedSession feedSession2 = feedAudioPlayer.mSession;
                            if (feedSession2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mSession");
                            } else {
                                feedSession = feedSession2;
                            }
                            feedSession.updatePlayTime(currentPlay, Float.valueOf(currentPlayTime2 - currentPlay.getAudioFile().getStartTrim()));
                        }
                    }
                } else if (playerState == State.WAITING_FOR_ITEM) {
                    NextSongProvider nextSongProvider = this.this$0.songProvider;
                    if (nextSongProvider == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                        nextSongProvider = null;
                    }
                    if (!nextSongProvider.getMNextPlayInProgress()) {
                        FMLog.e$default(this.this$0.log, "No song and nothing being requested", null, 2, null);
                        BuildersKt__Builders_commonKt.launch$default(this.this$0.ioScope, null, null, new FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayerStateChanged$3(playerState, this.this$0, null), 3, null);
                    }
                }
                this.this$0.setState(playerState);
            }
        };
        this.mixingAudioPlayerEventListener = r13;
        FeedAudioPlayer$sessionEventListener$1 feedAudioPlayer$sessionEventListener$1 = new FeedAudioPlayer$sessionEventListener$1(this);
        this.sessionEventListener = feedAudioPlayer$sessionEventListener$1;
        ?? r3 = new OfflineSession.OfflineEventListener() { // from class: fm.feed.android.playersdk.FeedAudioPlayer$offlineEventListener$1
            @Override // fm.feed.android.playersdk.OfflineSession.OfflineEventListener
            public void currentItemDidChange() {
                OfflineSession offlineSession = this.this$0.mOfflineSession;
                if (offlineSession == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                    offlineSession = null;
                }
                Play currentItem = offlineSession.getCurrentItem();
                if (currentItem != null) {
                    this.this$0.mPlayHistory.add(currentItem);
                    Iterator it = this.this$0.mPlayListeners.iterator();
                    while (it.hasNext()) {
                        ((PlayListener) it.next()).onPlayStarted(currentItem);
                    }
                }
            }

            @Override // fm.feed.android.playersdk.OfflineSession.OfflineEventListener
            public void nextItemAvailable() {
                MixingAudioPlayer mixingAudioPlayer;
                OfflineSession offlineSession = this.this$0.mOfflineSession;
                if (offlineSession == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                    offlineSession = null;
                }
                Play nextItem = offlineSession.getNextItem();
                if (nextItem == null || (mixingAudioPlayer = this.this$0.mPlayer) == null) {
                    return;
                }
                mixingAudioPlayer.addAudioAsset(nextItem);
            }

            @Override // fm.feed.android.playersdk.OfflineSession.OfflineEventListener
            public void activeStationDidChange() {
                Iterator it = this.this$0.mStationChangedListener.iterator();
                while (it.hasNext()) {
                    StationChangedListener stationChangedListener = (StationChangedListener) it.next();
                    OfflineSession offlineSession = this.this$0.mOfflineSession;
                    if (offlineSession == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                        offlineSession = null;
                    }
                    Station activeStation = offlineSession.getActiveStation();
                    if (activeStation != null) {
                        stationChangedListener.onStationChanged(activeStation);
                    }
                }
            }

            @Override // fm.feed.android.playersdk.OfflineSession.OfflineEventListener
            public void noMoreMusic() {
                if (this.this$0.mAdvanceOnNextItemReady) {
                    this.this$0.mAdvanceOnNextItemReady = false;
                }
                MixingAudioPlayer mixingAudioPlayer = this.this$0.mPlayer;
                if ((mixingAudioPlayer == null ? null : mixingAudioPlayer.getState()) != State.WAITING_FOR_ITEM) {
                    MixingAudioPlayer mixingAudioPlayer2 = this.this$0.mPlayer;
                    if ((mixingAudioPlayer2 != null ? mixingAudioPlayer2.getState() : null) != State.READY_TO_PLAY) {
                        return;
                    }
                }
                this.this$0.stop();
                Iterator it = this.this$0.mOutOfMusicListeners.iterator();
                while (it.hasNext()) {
                    ((OutOfMusicListener) it.next()).onOutOfMusic();
                }
            }
        };
        this.offlineEventListener = r3;
        this.remoteOfflineStationList = new StationList();
        this.playlistListener = new PlayList.PlayListListener() { // from class: fm.feed.android.playersdk.FeedAudioPlayer$playlistListener$1
            @Override // fm.feed.android.playersdk.models.PlayList.PlayListListener
            public void onPlaylistChanged() {
                NextSongProvider nextSongProvider = this.this$0.songProvider;
                if (nextSongProvider == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider = null;
                }
                if (nextSongProvider.getCurrentMusicSource() != FeedAudioPlayer.MusicSource.ON_DEMAND || this.this$0.getPlayQueueEditor().viewCurrentPlayList().isEmpty()) {
                    return;
                }
                NextSongProvider nextSongProvider2 = this.this$0.songProvider;
                if (nextSongProvider2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider2 = null;
                }
                Play nextItem = nextSongProvider2.getNextItem();
                if (nextItem != null) {
                    FeedAudioPlayer feedAudioPlayer = this.this$0;
                    if (!Intrinsics.areEqual(CollectionsKt.first((List) feedAudioPlayer.getPlayQueueEditor().viewCurrentPlayList()), nextItem.getAudioFile())) {
                        MixingAudioPlayer mixingAudioPlayer = feedAudioPlayer.mPlayer;
                        if (mixingAudioPlayer != null) {
                            mixingAudioPlayer.flushAndIncludeCurrent(false);
                        }
                        BuildersKt__Builders_commonKt.launch$default(feedAudioPlayer.ioScope, null, null, new FeedAudioPlayer$playlistListener$1$onPlaylistChanged$1$1(feedAudioPlayer, null), 3, null);
                    }
                }
                NextSongProvider nextSongProvider3 = this.this$0.songProvider;
                if (nextSongProvider3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider3 = null;
                }
                if (nextSongProvider3.getNextItem() == null && this.this$0.getMState() == State.WAITING_FOR_ITEM) {
                    BuildersKt__Builders_commonKt.launch$default(this.this$0.ioScope, null, null, new FeedAudioPlayer$playlistListener$1$onPlaylistChanged$2(this.this$0, null), 3, null);
                }
            }
        };
        FMLog.INSTANCE.setContext(context);
        OfflineSession offlineSession = new OfflineSession(context, (OfflineSession.OfflineEventListener) r3);
        this.mOfflineSession = offlineSession;
        if (!offlineSession.getAvailableStationList().isEmpty()) {
            this.mState = State.AVAILABLE_OFFLINE_ONLY;
        }
        if (z) {
            FeedSession.INSTANCE.resetClientId(context);
        }
        this.mSession = new FeedSession(context, str, str2, feedAudioPlayer$sessionEventListener$1, str3 == null ? null : INSTANCE.unwrapClientId(str3), mockLocations);
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        this.songProvider = new NextSongProvider(feedSession);
        if (availabilityListener != null) {
            addAvailabilityListener(availabilityListener);
        }
        NextSongProvider nextSongProvider = this.songProvider;
        if (nextSongProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider = null;
        }
        nextSongProvider.getPlayQueue().setListener(this.playlistListener);
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper()");
        ExoMixingAudioPlayer exoMixingAudioPlayer = new ExoMixingAudioPlayer(context, (MixingAudioPlayer.EventListener) r13, mainLooper);
        this.mExoMixingAudioPlayer = exoMixingAudioPlayer;
        Intrinsics.checkNotNull(exoMixingAudioPlayer);
        ExoMixingAudioPlayer exoMixingAudioPlayer2 = exoMixingAudioPlayer;
        this.mPlayer = exoMixingAudioPlayer2;
        exoMixingAudioPlayer2.setBTrimmingEnabled(true);
        MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
        if (mixingAudioPlayer != null) {
            mixingAudioPlayer.setVolume(1.0f);
        }
        ConnectionStateMonitor connectionStateMonitor = new ConnectionStateMonitor(this);
        this.networkMonitor = connectionStateMonitor;
        connectionStateMonitor.enable(context);
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
        ((Application) applicationContext).registerActivityLifecycleCallbacks(sessionTimeTracker);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
        NotificationDataListener notificationDataListener = this.mNotificationDataListener;
        if (notificationDataListener == null) {
            return;
        }
        notificationDataListener.onPendingIntentChanged();
    }

    public final NotificationStyle getNotificationStyle() {
        return this.notificationStyle;
    }

    public final void setNotificationStyle(NotificationStyle notificationStyle) {
        this.notificationStyle = notificationStyle;
        NotificationDataListener notificationDataListener = this.mNotificationDataListener;
        if (notificationDataListener == null) {
            return;
        }
        notificationDataListener.onNotificationStyleChanged();
    }

    public final Bitmap getArtWork() {
        return this.artWork;
    }

    private final void setArtWork(Bitmap bitmap) {
        NotificationDataListener notificationDataListener;
        this.artWork = bitmap;
        if (bitmap == null || (notificationDataListener = this.mNotificationDataListener) == null) {
            return;
        }
        notificationDataListener.onArtWorkChanged(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: afChangeListener$lambda-0, reason: not valid java name */
    public static final void m8775afChangeListener$lambda0(FeedAudioPlayer this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (disableAudioFocus) {
            if (i == -3) {
                float f = this$0.mVolume;
                float f2 = 5;
                this$0.mTransientVolume = f / f2;
                MixingAudioPlayer mixingAudioPlayer = this$0.mPlayer;
                if (mixingAudioPlayer != null) {
                    mixingAudioPlayer.setVolume(f / f2);
                }
                Iterator<AudioFocusListener> it = this$0.mAudioFocusListeners.iterator();
                while (it.hasNext()) {
                    it.next().volumeChangedDueToTransientLossOrGain(this$0.mTransientVolume);
                }
                this$0.mResumePlaybackOnAudioFocusGain = false;
                FMLog.i$default(this$0.log, "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK", null, 2, null);
                return;
            }
            if (i == -2) {
                if (this$0.mState == State.WAITING_FOR_ITEM || this$0.mState == State.PLAYING || this$0.mState == State.STALLED) {
                    MixingAudioPlayer mixingAudioPlayer2 = this$0.mPlayer;
                    if (mixingAudioPlayer2 != null) {
                        mixingAudioPlayer2.pause();
                    }
                    Iterator<AudioFocusListener> it2 = this$0.mAudioFocusListeners.iterator();
                    while (it2.hasNext()) {
                        it2.next().musicPausedDueToAudioFocusLost(false);
                    }
                    this$0.mResumePlaybackOnAudioFocusGain = true;
                } else {
                    this$0.mResumePlaybackOnAudioFocusGain = false;
                }
                FMLog.i$default(this$0.log, "AUDIOFOCUS_LOSS_TRANSIENT", null, 2, null);
                return;
            }
            if (i == -1) {
                Iterator<AudioFocusListener> it3 = this$0.mAudioFocusListeners.iterator();
                while (it3.hasNext()) {
                    it3.next().musicPausedDueToAudioFocusLost(true);
                }
                MixingAudioPlayer mixingAudioPlayer3 = this$0.mPlayer;
                if (mixingAudioPlayer3 != null) {
                    mixingAudioPlayer3.pause();
                }
                this$0.mResumePlaybackOnAudioFocusGain = false;
                FMLog.i$default(this$0.log, "AUDIOFOCUS_LOSS", null, 2, null);
                return;
            }
            if (i != 1) {
                return;
            }
            FMLog.i$default(this$0.log, "AUDIOFOCUS_GAIN", null, 2, null);
            float f3 = this$0.mTransientVolume;
            float f4 = this$0.mVolume;
            if (f3 != f4) {
                this$0.mTransientVolume = f4;
                MixingAudioPlayer mixingAudioPlayer4 = this$0.mPlayer;
                if (mixingAudioPlayer4 != null) {
                    mixingAudioPlayer4.setVolume(f4);
                }
                Iterator<AudioFocusListener> it4 = this$0.mAudioFocusListeners.iterator();
                while (it4.hasNext()) {
                    it4.next().volumeChangedDueToTransientLossOrGain(this$0.mVolume);
                }
            }
            if (this$0.mResumePlaybackOnAudioFocusGain) {
                Iterator<AudioFocusListener> it5 = this$0.mAudioFocusListeners.iterator();
                while (it5.hasNext()) {
                    it5.next().musicWillBeResumedDueToAudioFocusGain();
                }
                this$0.play();
                this$0.mResumePlaybackOnAudioFocusGain = false;
            }
        }
    }

    public final Play getCurrentPlay() {
        if (this.mState != State.UNINITIALIZED && this.mState != State.WAITING_FOR_ITEM) {
            MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
            if (mixingAudioPlayer == null) {
                return null;
            }
            return mixingAudioPlayer.getCurrentPlay();
        }
        return null;
    }

    public final int getMaxBitrate() {
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        return feedSession.getMaxBitrate();
    }

    public final void setMaxBitrate(int i) {
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        feedSession.setMaxBitrate(i);
    }

    public final float getCurrentPlaybackTime() {
        MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
        if (mixingAudioPlayer == null) {
            return 0.0f;
        }
        Float fValueOf = mixingAudioPlayer == null ? null : Float.valueOf(mixingAudioPlayer.getCurrentPlayTime());
        Intrinsics.checkNotNull(fValueOf);
        return fValueOf.floatValue();
    }

    public final float getCurrentPlayDuration() {
        MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
        if (mixingAudioPlayer == null) {
            return 0.0f;
        }
        Float fValueOf = mixingAudioPlayer == null ? null : Float.valueOf(mixingAudioPlayer.getCurrentPlayDuration());
        Intrinsics.checkNotNull(fValueOf);
        return fValueOf.floatValue();
    }

    public final List<Play> getPlayHistory() {
        return this.mPlayHistory;
    }

    /* renamed from: getState, reason: from getter */
    public final State getMState() {
        return this.mState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setState(State state) {
        if (state == this.mState) {
            return;
        }
        FMLog.d$default(this.log, "state change " + this.mState + " -> " + state, null, 2, null);
        this.mState = state;
        FMLog fMLog = this.log;
        NextSongProvider nextSongProvider = this.songProvider;
        if (nextSongProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider = null;
        }
        FMLog.i$default(fMLog, nextSongProvider.toString(), null, 2, null);
        Iterator<StateListener> it = this.mStateListeners.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(this.mState);
        }
    }

    public final long getOfflineStorageUsed() {
        OfflineSession offlineSession = this.mOfflineSession;
        if (offlineSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            offlineSession = null;
        }
        return offlineSession.calculateOfflineStorageUsed();
    }

    public final Station getActiveStation() {
        NextSongProvider nextSongProvider = null;
        OfflineSession offlineSession = null;
        if (this.isOfflineStationActive) {
            OfflineSession offlineSession2 = this.mOfflineSession;
            if (offlineSession2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            } else {
                offlineSession = offlineSession2;
            }
            return offlineSession.getActiveStation();
        }
        NextSongProvider nextSongProvider2 = this.songProvider;
        if (nextSongProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
        } else {
            nextSongProvider = nextSongProvider2;
        }
        return nextSongProvider.getCurrentStation();
    }

    private final void setActiveStation(Station station) throws JSONException {
        if (station != null) {
            setActiveStation$default(this, station, false, 0.0f, 4, null);
        }
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lfm/feed/android/playersdk/FeedAudioPlayer$ConnectionStateMonitor;", "Landroid/net/ConnectivityManager$NetworkCallback;", "(Lfm/feed/android/playersdk/FeedAudioPlayer;)V", "networkRequest", "Landroid/net/NetworkRequest;", "disable", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "enable", "onAvailable", "network", "Landroid/net/Network;", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLinkPropertiesChanged", "linkProperties", "Landroid/net/LinkProperties;", "onLosing", "maxMsToLive", "", "onLost", "onUnavailable", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class ConnectionStateMonitor extends ConnectivityManager.NetworkCallback {
        private final NetworkRequest networkRequest;
        final /* synthetic */ FeedAudioPlayer this$0;

        public ConnectionStateMonitor(FeedAudioPlayer this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).addTransportType(4).addTransportType(1).build();
            Intrinsics.checkNotNullExpressionValue(networkRequestBuild, "Builder().addCapability(…s.TRANSPORT_WIFI).build()");
            this.networkRequest = networkRequestBuild;
        }

        public final void enable(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Object systemService = context.getSystemService("connectivity");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
                }
                ((ConnectivityManager) systemService).registerNetworkCallback(this.networkRequest, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void disable(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            try {
                ((ConnectivityManager) systemService).unregisterNetworkCallback(this);
            } catch (Exception e) {
                FMLog.e$default(this.this$0.log, e.toString(), null, 2, null);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            if (this.this$0.mState == State.WAITING_FOR_ITEM) {
                NextSongProvider nextSongProvider = this.this$0.songProvider;
                if (nextSongProvider == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider = null;
                }
                if (nextSongProvider.getMNextPlayInProgress()) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(this.this$0.ioScope, null, null, new FeedAudioPlayer$ConnectionStateMonitor$onAvailable$1(this.this$0, null), 3, null);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.checkNotNullParameter(network, "network");
            Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
            super.onCapabilitiesChanged(network, networkCapabilities);
            FMLog.i$default(this.this$0.log, "onCapabilitiesChanged", null, 2, null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            super.onLost(network);
            FMLog.i$default(this.this$0.log, "onLost", null, 2, null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            Intrinsics.checkNotNullParameter(network, "network");
            Intrinsics.checkNotNullParameter(linkProperties, "linkProperties");
            super.onLinkPropertiesChanged(network, linkProperties);
            FMLog.i$default(this.this$0.log, "onLinkPropertiesChanged", null, 2, null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            FMLog.i$default(this.this$0.log, "onUnavailable", null, 2, null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int maxMsToLive) {
            Intrinsics.checkNotNullParameter(network, "network");
            super.onLosing(network, maxMsToLive);
            FMLog.i$default(this.this$0.log, Intrinsics.stringPlus("onLosing in ", Integer.valueOf(maxMsToLive)), null, 2, null);
        }
    }

    public final Float getSecondsOfCrossfade() {
        MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
        if (mixingAudioPlayer == null) {
            return null;
        }
        return Float.valueOf(mixingAudioPlayer.getFadeDuration());
    }

    public final void setSecondsOfCrossfade(Float f) {
        MixingAudioPlayer mixingAudioPlayer;
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        if (feedSession.getRemoteCrossfadeEnabled() || f == null || (mixingAudioPlayer = this.mPlayer) == null) {
            return;
        }
        mixingAudioPlayer.setFadeDuration(f.floatValue());
    }

    public final StationList getStationList() {
        StationList stationList = new StationList();
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        stationList.addAll(feedSession.getStationList());
        return stationList;
    }

    public final StationList getRemoteOfflineStationList() {
        StationList stationList = new StationList();
        stationList.addAll(this.remoteOfflineStationList);
        return stationList;
    }

    public final StationList getLocalOfflineStationList() {
        StationList stationList = new StationList();
        OfflineSession offlineSession = this.mOfflineSession;
        if (offlineSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            offlineSession = null;
        }
        stationList.addAll(offlineSession.getAvailableStationList());
        return stationList;
    }

    public final void addMusicQueuedListener(MusicQueuedListener musicQueuedListener) {
        if (musicQueuedListener != null) {
            this.mMusicQueuedListeners.add(musicQueuedListener);
        }
    }

    public final void removeMusicQueuedListener(MusicQueuedListener musicQueuedListener) {
        Intrinsics.checkNotNullParameter(musicQueuedListener, "musicQueuedListener");
        this.mMusicQueuedListeners.remove(musicQueuedListener);
    }

    public final void addAvailabilityListener(AvailabilityListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        Boolean boolIsAvailable = feedSession.isAvailable();
        if (boolIsAvailable == null) {
            this.mAvailabilityListeners.add(eventListener);
            return;
        }
        if (boolIsAvailable.booleanValue()) {
            eventListener.onPlayerAvailable(this);
        } else if (getLocalOfflineStationList().size() > 0) {
            eventListener.onPlayerAvailable(this);
        } else {
            eventListener.onPlayerUnavailable(new Exception("Player Unavailable"));
        }
    }

    public final void addStateListener(StateListener stateListener) {
        Intrinsics.checkNotNullParameter(stateListener, "stateListener");
        this.mStateListeners.add(stateListener);
    }

    public final void removeStateListener(StateListener stateListener) {
        Intrinsics.checkNotNullParameter(stateListener, "stateListener");
        this.mStateListeners.remove(stateListener);
    }

    public final void addStationChangedListener(StationChangedListener stationChangedListener) {
        Intrinsics.checkNotNullParameter(stationChangedListener, "stationChangedListener");
        this.mStationChangedListener.add(stationChangedListener);
    }

    public final void removeStationChangedListener(StationChangedListener stationChangedListener) {
        Intrinsics.checkNotNullParameter(stationChangedListener, "stationChangedListener");
        this.mStationChangedListener.remove(stationChangedListener);
    }

    public final void addPlayListener(PlayListener playListener) {
        Intrinsics.checkNotNullParameter(playListener, "playListener");
        this.mPlayListeners.add(playListener);
    }

    public final void removePlayListener(PlayListener playListener) {
        Intrinsics.checkNotNullParameter(playListener, "playListener");
        this.mPlayListeners.remove(playListener);
    }

    public final void addUnhandledErrorListener(UnhandledErrorListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.mUnhandledErrorListeners.add(eventListener);
    }

    public final void removeUnhandledErrorListener(UnhandledErrorListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.mUnhandledErrorListeners.remove(eventListener);
    }

    public final void addSkipListener(SkipListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.mSkipListeners.add(eventListener);
    }

    public final void removeSkipListener(SkipListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.mSkipListeners.remove(eventListener);
    }

    public final void addLikeStatusChangeListener(LikeStatusChangeListener likeStatusChangeListener) {
        Intrinsics.checkNotNullParameter(likeStatusChangeListener, "likeStatusChangeListener");
        this.mLikeStatusChangeListener.add(likeStatusChangeListener);
    }

    public final void removeLikeStatusChangeListener(LikeStatusChangeListener likeStatusChangeListener) {
        Intrinsics.checkNotNullParameter(likeStatusChangeListener, "likeStatusChangeListener");
        this.mLikeStatusChangeListener.remove(likeStatusChangeListener);
    }

    public final void addOutOfMusicListener(OutOfMusicListener outOfMusicListener) {
        Intrinsics.checkNotNullParameter(outOfMusicListener, "outOfMusicListener");
        this.mOutOfMusicListeners.add(outOfMusicListener);
    }

    public final void removeOutOfMusicListener(OutOfMusicListener outOfMusicListener) {
        Intrinsics.checkNotNullParameter(outOfMusicListener, "outOfMusicListener");
        this.mOutOfMusicListeners.remove(outOfMusicListener);
    }

    public final void setNotificationDataListener$PlayerSdk_exoDefaultRelease(NotificationDataListener nl) {
        Intrinsics.checkNotNullParameter(nl, "nl");
        this.mNotificationDataListener = nl;
    }

    public final void addAudioFocusListener(AudioFocusListener audioFocusListener) {
        Intrinsics.checkNotNullParameter(audioFocusListener, "audioFocusListener");
        this.mAudioFocusListeners.add(audioFocusListener);
    }

    public final void removeAudioFocusListener(AudioFocusListener audioFocusListener) {
        Intrinsics.checkNotNullParameter(audioFocusListener, "audioFocusListener");
        this.mAudioFocusListeners.remove(audioFocusListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedAudioPlayer(Context context, String token, String secret) {
        this(context, token, secret, null, null, false, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(secret, "secret");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedAudioPlayer(Context context, String token, String secret, AvailabilityListener availabilityListener) {
        this(context, token, secret, availabilityListener, null, false, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(secret, "secret");
        Intrinsics.checkNotNullParameter(availabilityListener, "availabilityListener");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedAudioPlayer(Context context, String token, String secret, AvailabilityListener availabilityListener, MockLocations mockLocation) {
        this(context, token, secret, availabilityListener, null, false, mockLocation);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(secret, "secret");
        Intrinsics.checkNotNullParameter(availabilityListener, "availabilityListener");
        Intrinsics.checkNotNullParameter(mockLocation, "mockLocation");
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$1", f = "FeedAudioPlayer.kt", i = {}, l = {WinError.ERROR_STACK_BUFFER_OVERRUN}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAudioPlayer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int i2 = FeedAudioPlayer.INSTANCE.getAutoNetworkRetry() ? 100 : 0;
                this.label = 1;
                if (RetryOperationKt.retryOperation((14 & 1) != 0 ? 100 : i2, (14 & 2) != 0 ? 0L : 0L, (14 & 4) != 0 ? 1000L : 0L, (14 & 8) != 0 ? RetryStrategy.LINEAR : null, new C02671(FeedAudioPlayer.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: FeedAudioPlayer.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lfm/feed/android/playersdk/RetryOperation;"}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$1$1", f = "FeedAudioPlayer.kt", i = {0}, l = {WinError.ERROR_DEBUGGER_INACTIVE, WinError.ERROR_VDM_DISALLOWED}, m = "invokeSuspend", n = {"$this$retryOperation"}, s = {"L$0"})
        /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02671 extends SuspendLambda implements Function2<RetryOperation, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ FeedAudioPlayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02671(FeedAudioPlayer feedAudioPlayer, Continuation<? super C02671> continuation) {
                super(2, continuation);
                this.this$0 = feedAudioPlayer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C02671 c02671 = new C02671(this.this$0, continuation);
                c02671.L$0 = obj;
                return c02671;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(RetryOperation retryOperation, Continuation<? super Unit> continuation) {
                return ((C02671) create(retryOperation, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                RetryOperation retryOperation;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    retryOperation = (RetryOperation) this.L$0;
                    FeedSession feedSession = this.this$0.mSession;
                    if (feedSession == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSession");
                        feedSession = null;
                    }
                    this.L$0 = retryOperation;
                    this.label = 1;
                    obj = feedSession.requestSession(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    retryOperation = (RetryOperation) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    this.L$0 = null;
                    this.label = 2;
                    if (retryOperation.operationFailed(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    public final void setPlayer(MixingAudioPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        FMLog.d$default(this.log, "setPlayer", null, 2, null);
        stop();
        float currentPlayDuration = getCurrentPlayDuration();
        this.mPlayer = player;
        if (player != null) {
            player.setMEventListener(this.mixingAudioPlayerEventListener);
        }
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C10401(currentPlayDuration, null), 3, null);
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$setPlayer$1", f = "FeedAudioPlayer.kt", i = {}, l = {WinError.ERROR_UNKNOWN_REVISION}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$setPlayer$1, reason: invalid class name and case insensitive filesystem */
    static final class C10401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $tempDuration;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10401(float f, Continuation<? super C10401> continuation) {
            super(2, continuation);
            this.$tempDuration = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAudioPlayer.this.new C10401(this.$tempDuration, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00c0  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L19
                if (r1 != r2) goto L11
                kotlin.ResultKt.throwOnFailure(r5)
                goto L7c
            L11:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L19:
                kotlin.ResultKt.throwOnFailure(r5)
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.NextSongProvider r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r5)
                java.lang.String r1 = "songProvider"
                if (r5 != 0) goto L2a
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r5 = r3
            L2a:
                fm.feed.android.playersdk.models.Play r5 = r5.getCurrentItem()
                if (r5 == 0) goto L41
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.NextSongProvider r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r5)
                if (r5 != 0) goto L3c
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r5 = r3
            L3c:
                fm.feed.android.playersdk.models.Play r5 = r5.getCurrentItem()
                goto L7e
            L41:
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.NextSongProvider r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r5)
                if (r5 != 0) goto L4d
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r5 = r3
            L4d:
                fm.feed.android.playersdk.models.Play r5 = r5.getNextItem()
                if (r5 == 0) goto L64
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.NextSongProvider r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r5)
                if (r5 != 0) goto L5f
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r5 = r3
            L5f:
                fm.feed.android.playersdk.models.Play r5 = r5.getNextItem()
                goto L7e
            L64:
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.NextSongProvider r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r5)
                if (r5 != 0) goto L70
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r5 = r3
            L70:
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r2
                java.lang.Object r5 = r5.requestNextPlay(r1)
                if (r5 != r0) goto L7c
                return r0
            L7c:
                fm.feed.android.playersdk.models.Play r5 = (fm.feed.android.playersdk.models.Play) r5
            L7e:
                fm.feed.android.playersdk.FeedAudioPlayer r0 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.FMLog r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getLog$p(r0)
                java.lang.String r1 = "play = "
                java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r5)
                r2 = 2
                fm.feed.android.playersdk.FMLog.d$default(r0, r1, r3, r2, r3)
                if (r5 == 0) goto Lab
                fm.feed.android.playersdk.FeedAudioPlayer r0 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.FMLog r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getLog$p(r0)
                java.lang.String r1 = "Adding setActiveStation "
                java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r5)
                fm.feed.android.playersdk.FMLog.d$default(r0, r1, r3, r2, r3)
                fm.feed.android.playersdk.FeedAudioPlayer r0 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.MixingAudioPlayer r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMPlayer$p(r0)
                if (r0 != 0) goto La8
                goto Lab
            La8:
                r0.addAudioAsset(r5)
            Lab:
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.MixingAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMPlayer$p(r5)
                if (r5 != 0) goto Lb4
                goto Lb7
            Lb4:
                r5.play()
            Lb7:
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.MixingAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMPlayer$p(r5)
                if (r5 != 0) goto Lc0
                goto Lc5
            Lc0:
                float r0 = r4.$tempDuration
                r5.seekTo(r0)
            Lc5:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer.C10401.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void switchToDefaultPlayer() {
        float currentPlayDuration = getCurrentPlayDuration();
        FMLog.d$default(this.log, "switchToDefaultPlayer", null, 2, null);
        stop();
        ExoMixingAudioPlayer exoMixingAudioPlayer = this.mExoMixingAudioPlayer;
        Intrinsics.checkNotNull(exoMixingAudioPlayer);
        ExoMixingAudioPlayer exoMixingAudioPlayer2 = exoMixingAudioPlayer;
        this.mPlayer = exoMixingAudioPlayer2;
        if (exoMixingAudioPlayer2 != null) {
            exoMixingAudioPlayer2.setMEventListener(this.mixingAudioPlayerEventListener);
        }
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C10421(currentPlayDuration, null), 3, null);
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$switchToDefaultPlayer$1", f = "FeedAudioPlayer.kt", i = {}, l = {WinError.ERROR_TOO_MANY_LUIDS_REQUESTED}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$switchToDefaultPlayer$1, reason: invalid class name and case insensitive filesystem */
    static final class C10421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $tempDuration;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10421(float f, Continuation<? super C10421> continuation) {
            super(2, continuation);
            this.$tempDuration = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAudioPlayer.this.new C10421(this.$tempDuration, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00c0  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L19
                if (r1 != r2) goto L11
                kotlin.ResultKt.throwOnFailure(r5)
                goto L7c
            L11:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L19:
                kotlin.ResultKt.throwOnFailure(r5)
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.NextSongProvider r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r5)
                java.lang.String r1 = "songProvider"
                if (r5 != 0) goto L2a
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r5 = r3
            L2a:
                fm.feed.android.playersdk.models.Play r5 = r5.getCurrentItem()
                if (r5 == 0) goto L41
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.NextSongProvider r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r5)
                if (r5 != 0) goto L3c
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r5 = r3
            L3c:
                fm.feed.android.playersdk.models.Play r5 = r5.getCurrentItem()
                goto L7e
            L41:
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.NextSongProvider r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r5)
                if (r5 != 0) goto L4d
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r5 = r3
            L4d:
                fm.feed.android.playersdk.models.Play r5 = r5.getNextItem()
                if (r5 == 0) goto L64
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.NextSongProvider r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r5)
                if (r5 != 0) goto L5f
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r5 = r3
            L5f:
                fm.feed.android.playersdk.models.Play r5 = r5.getNextItem()
                goto L7e
            L64:
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.NextSongProvider r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r5)
                if (r5 != 0) goto L70
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r5 = r3
            L70:
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r2
                java.lang.Object r5 = r5.requestNextPlay(r1)
                if (r5 != r0) goto L7c
                return r0
            L7c:
                fm.feed.android.playersdk.models.Play r5 = (fm.feed.android.playersdk.models.Play) r5
            L7e:
                fm.feed.android.playersdk.FeedAudioPlayer r0 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.FMLog r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getLog$p(r0)
                java.lang.String r1 = "play = "
                java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r5)
                r2 = 2
                fm.feed.android.playersdk.FMLog.d$default(r0, r1, r3, r2, r3)
                if (r5 == 0) goto Lab
                fm.feed.android.playersdk.FeedAudioPlayer r0 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.FMLog r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getLog$p(r0)
                java.lang.String r1 = "Adding setActiveStation "
                java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r5)
                fm.feed.android.playersdk.FMLog.d$default(r0, r1, r3, r2, r3)
                fm.feed.android.playersdk.FeedAudioPlayer r0 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.MixingAudioPlayer r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMPlayer$p(r0)
                if (r0 != 0) goto La8
                goto Lab
            La8:
                r0.addAudioAsset(r5)
            Lab:
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.MixingAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMPlayer$p(r5)
                if (r5 != 0) goto Lb4
                goto Lb7
            Lb4:
                r5.play()
            Lb7:
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.this
                fm.feed.android.playersdk.MixingAudioPlayer r5 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMPlayer$p(r5)
                if (r5 != 0) goto Lc0
                goto Lc5
            Lc0:
                float r0 = r4.$tempDuration
                r5.seekTo(r0)
            Lc5:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer.C10421.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final boolean getBIsUpdatingSession() {
        return this.bIsUpdatingSession;
    }

    public final void setBIsUpdatingSession(boolean z) {
        this.bIsUpdatingSession = z;
    }

    public final SessionUpdateListener getMSessionUpdateListener() {
        return this.mSessionUpdateListener;
    }

    public final void setMSessionUpdateListener(SessionUpdateListener sessionUpdateListener) {
        this.mSessionUpdateListener = sessionUpdateListener;
    }

    public final void updateSession(SessionUpdateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        Boolean boolIsAvailable = feedSession.isAvailable();
        if (boolIsAvailable != null && boolIsAvailable.booleanValue()) {
            stop();
            setBIsUpdatingSession(true);
            setMSessionUpdateListener(listener);
            BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new FeedAudioPlayer$updateSession$1$1(this, null), 3, null);
        }
    }

    public final boolean canSkip() {
        FeedSession feedSession = null;
        OfflineSession offlineSession = null;
        if (this.isOfflineStationActive) {
            OfflineSession offlineSession2 = this.mOfflineSession;
            if (offlineSession2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            } else {
                offlineSession = offlineSession2;
            }
            return offlineSession.canSkip();
        }
        FeedSession feedSession2 = this.mSession;
        if (feedSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
        } else {
            feedSession = feedSession2;
        }
        return feedSession.getMCanSkipCurrent();
    }

    public final void seek(float position) {
        Play currentPlay;
        AudioFile audioFile;
        MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
        if (mixingAudioPlayer == null || (currentPlay = mixingAudioPlayer.getCurrentPlay()) == null || (audioFile = currentPlay.getAudioFile()) == null) {
            return;
        }
        audioFile.getCanSeek();
        MixingAudioPlayer mixingAudioPlayer2 = this.mPlayer;
        if (mixingAudioPlayer2 == null) {
            return;
        }
        mixingAudioPlayer2.seekTo(position);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void play() {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer.play():void");
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$play$1", f = "FeedAudioPlayer.kt", i = {}, l = {WinError.ERROR_CHILD_WINDOW_MENU}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$play$1, reason: invalid class name and case insensitive filesystem */
    static final class C10361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10361(Continuation<? super C10361> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAudioPlayer.this.new C10361(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NextSongProvider nextSongProvider = FeedAudioPlayer.this.songProvider;
                if (nextSongProvider == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider = null;
                }
                nextSongProvider.reset();
                NextSongProvider nextSongProvider2 = FeedAudioPlayer.this.songProvider;
                if (nextSongProvider2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider2 = null;
                }
                this.label = 1;
                obj = nextSongProvider2.requestNextPlay(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Play play = (Play) obj;
            if (play != null) {
                FMLog.d$default(FeedAudioPlayer.this.log, Intrinsics.stringPlus("Adding Play ", play), null, 2, null);
                MixingAudioPlayer mixingAudioPlayer = FeedAudioPlayer.this.mPlayer;
                if (mixingAudioPlayer != null) {
                    mixingAudioPlayer.addAudioAsset(play);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void seekCurrentStationBy(float seconds) {
        MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
        if (mixingAudioPlayer == null) {
            return;
        }
        mixingAudioPlayer.seekTo(seconds);
    }

    public final Float maxSeekableLengthInSeconds() {
        MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
        if (mixingAudioPlayer == null) {
            return null;
        }
        return Float.valueOf(mixingAudioPlayer.maxSeekableLengthInSeconds());
    }

    public final void skip() {
        skip(null);
    }

    public final boolean getBIsSkipping() {
        return this.bIsSkipping;
    }

    public final void setBIsSkipping(boolean z) {
        this.bIsSkipping = z;
    }

    public final void skip(final SkipListener skipListener) {
        final Play currentPlay;
        MixingAudioPlayer mixingAudioPlayer;
        FeedSession feedSession = null;
        OfflineSession offlineSession = null;
        FMLog.d$default(this.log, "skip request", null, 2, null);
        MixingAudioPlayer mixingAudioPlayer2 = this.mPlayer;
        if ((mixingAudioPlayer2 == null ? null : mixingAudioPlayer2.getCurrentPlay()) == null || this.bIsSkipping) {
            if (skipListener == null) {
                return;
            }
            skipListener.requestCompleted(false);
            return;
        }
        this.bIsSkipping = true;
        if (this.isOfflineStationActive) {
            MixingAudioPlayer mixingAudioPlayer3 = this.mPlayer;
            if (mixingAudioPlayer3 == null) {
                return;
            }
            float currentPlayTime = mixingAudioPlayer3.getCurrentPlayTime();
            OfflineSession offlineSession2 = this.mOfflineSession;
            if (offlineSession2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            } else {
                offlineSession = offlineSession2;
            }
            if (offlineSession.requestSkip(currentPlayTime)) {
                MixingAudioPlayer mixingAudioPlayer4 = this.mPlayer;
                if (mixingAudioPlayer4 != null) {
                    mixingAudioPlayer4.skip();
                }
                Iterator<SkipListener> it = this.mSkipListeners.iterator();
                while (it.hasNext()) {
                    it.next().requestCompleted(true);
                }
                setBIsSkipping(false);
                return;
            }
            Iterator<SkipListener> it2 = this.mSkipListeners.iterator();
            while (it2.hasNext()) {
                it2.next().requestCompleted(false);
            }
            setBIsSkipping(false);
            return;
        }
        MixingAudioPlayer mixingAudioPlayer5 = this.mPlayer;
        if (mixingAudioPlayer5 == null || (currentPlay = mixingAudioPlayer5.getCurrentPlay()) == null || (mixingAudioPlayer = this.mPlayer) == null) {
            return;
        }
        float currentPlayTime2 = mixingAudioPlayer.getCurrentPlayTime();
        FeedSession feedSession2 = this.mSession;
        if (feedSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
        } else {
            feedSession = feedSession2;
        }
        feedSession.requestSkip(currentPlay, currentPlayTime2, new FeedSession.SkipRequestListener() { // from class: fm.feed.android.playersdk.FeedAudioPlayer$skip$2$1$1
            @Override // fm.feed.android.playersdk.FeedSession.SkipRequestListener
            public void onSuccess() {
                MixingAudioPlayer mixingAudioPlayer6;
                Play currentPlay2;
                AudioFile audioFile;
                String id2 = currentPlay.getAudioFile().getId();
                MixingAudioPlayer mixingAudioPlayer7 = this.mPlayer;
                String id3 = null;
                if (mixingAudioPlayer7 != null && (currentPlay2 = mixingAudioPlayer7.getCurrentPlay()) != null && (audioFile = currentPlay2.getAudioFile()) != null) {
                    id3 = audioFile.getId();
                }
                if (Intrinsics.areEqual(id2, id3) && (mixingAudioPlayer6 = this.mPlayer) != null) {
                    mixingAudioPlayer6.skip();
                }
                SkipListener skipListener2 = skipListener;
                if (skipListener2 != null) {
                    skipListener2.requestCompleted(true);
                }
                Iterator it3 = this.mSkipListeners.iterator();
                while (it3.hasNext()) {
                    ((SkipListener) it3.next()).requestCompleted(true);
                }
                this.setBIsSkipping(false);
            }

            @Override // fm.feed.android.playersdk.FeedSession.SkipRequestListener
            public void onFailure(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                if (e instanceof FeedSession.CancelledRequest) {
                    atomicBoolean.set(true);
                }
                SkipListener skipListener2 = skipListener;
                if (skipListener2 != null) {
                    skipListener2.requestCompleted(atomicBoolean.get());
                }
                Iterator it3 = this.mSkipListeners.iterator();
                while (it3.hasNext()) {
                    ((SkipListener) it3.next()).requestCompleted(atomicBoolean.get());
                }
                this.setBIsSkipping(false);
            }
        });
    }

    public final void pause() {
        FMLog.i$default(this.log, "Pausing player", null, 2, null);
        FMLog fMLog = this.log;
        NextSongProvider nextSongProvider = this.songProvider;
        if (nextSongProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider = null;
        }
        FMLog.i$default(fMLog, nextSongProvider.toString(), null, 2, null);
        this.mResumePlaybackOnAudioFocusGain = false;
        AudioFocusRequest audioFocusRequest = this.focusRequest;
        if (audioFocusRequest != null) {
            this.mAudioManager.abandonAudioFocusRequest(audioFocusRequest);
        }
        MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
        if (mixingAudioPlayer != null) {
            mixingAudioPlayer.pause();
        }
        FMLog fMLog2 = this.log;
        NextSongProvider nextSongProvider2 = this.songProvider;
        if (nextSongProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider2 = null;
        }
        FMLog.i$default(fMLog2, nextSongProvider2.toString(), null, 2, null);
    }

    public final void stop() {
        pause();
        OfflineSession offlineSession = this.mOfflineSession;
        NextSongProvider nextSongProvider = null;
        if (offlineSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            offlineSession = null;
        }
        offlineSession.reset();
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        feedSession.reset();
        NextSongProvider nextSongProvider2 = this.songProvider;
        if (nextSongProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
        } else {
            nextSongProvider = nextSongProvider2;
        }
        nextSongProvider.reset();
        ConnectionStateMonitor connectionStateMonitor = this.networkMonitor;
        if (connectionStateMonitor != null) {
            connectionStateMonitor.disable(this.mContext);
        }
        MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
        if (mixingAudioPlayer != null) {
            mixingAudioPlayer.flushAndIncludeCurrent(true);
        }
        setState(State.READY_TO_PLAY);
    }

    public final void destroyInstance() {
        removeAllListeners();
        stop();
        FeedSession feedSession = this.mSession;
        OfflineSession offlineSession = null;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        feedSession.resetSessionToNull();
        OfflineSession offlineSession2 = this.mOfflineSession;
        if (offlineSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
        } else {
            offlineSession = offlineSession2;
        }
        offlineSession.destroy();
        MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
        if (mixingAudioPlayer == null) {
            return;
        }
        mixingAudioPlayer.destroy();
    }

    private final void removeAllListeners() {
        Context applicationContext = this.mContext.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
        ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this.sessionTimeTracker);
        this.mPlayListeners.clear();
        this.mMusicQueuedListeners.clear();
        this.mAvailabilityListeners.clear();
        this.mLikeStatusChangeListener.clear();
        this.mOutOfMusicListeners.clear();
        this.mSkipListeners.clear();
        this.mStateListeners.clear();
        this.mStationChangedListener.clear();
        this.mUnhandledErrorListeners.clear();
    }

    public static /* synthetic */ void prepareToPlay$default(FeedAudioPlayer feedAudioPlayer, AudioFile audioFile, MusicQueuedListener musicQueuedListener, int i, Object obj) {
        if ((i & 2) != 0) {
            musicQueuedListener = null;
        }
        feedAudioPlayer.prepareToPlay(audioFile, musicQueuedListener);
    }

    public final void prepareToPlay(AudioFile audioFile, MusicQueuedListener listener) {
        Intrinsics.checkNotNullParameter(audioFile, "audioFile");
        if (this.mState == State.UNINITIALIZED) {
            FMLog.e$default(this.log, "trying to prepare to play before initialization", null, 2, null);
        } else {
            if (this.mState != State.UNAVAILABLE) {
                if (listener != null) {
                    addMusicQueuedListener(listener);
                }
                BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C10371(audioFile, null), 3, null);
                return;
            }
            FMLog.e$default(this.log, "trying to prepare to play but session not available", null, 2, null);
        }
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$prepareToPlay$1", f = "FeedAudioPlayer.kt", i = {}, l = {1698}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$prepareToPlay$1, reason: invalid class name and case insensitive filesystem */
    static final class C10371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioFile $audioFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10371(AudioFile audioFile, Continuation<? super C10371> continuation) {
            super(2, continuation);
            this.$audioFile = audioFile;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAudioPlayer.this.new C10371(this.$audioFile, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MixingAudioPlayer mixingAudioPlayer;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NextSongProvider nextSongProvider = FeedAudioPlayer.this.songProvider;
                if (nextSongProvider == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider = null;
                }
                this.label = 1;
                obj = nextSongProvider.cachePlayForAudioFile(this.$audioFile, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Play play = (Play) obj;
            if (play != null && (mixingAudioPlayer = FeedAudioPlayer.this.mPlayer) != null) {
                mixingAudioPlayer.prepareTrack(play);
            }
            return Unit.INSTANCE;
        }
    }

    public final void prepareToPlay(Station station, MusicQueuedListener listener) {
        FMLog.d$default(this.log, "PrepareToPlay", null, 2, null);
        if (this.mState == State.UNINITIALIZED) {
            FMLog.e$default(this.log, "trying to prepare to play before initialization", null, 2, null);
            return;
        }
        if (this.mState != State.UNAVAILABLE) {
            if (listener != null) {
                addMusicQueuedListener(listener);
            }
            if (station == null) {
                Station first = getStationList().getFirst();
                Intrinsics.checkNotNullExpressionValue(first, "stationList.first");
                station = first;
            }
            BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C10382(station, null), 3, null);
            return;
        }
        FMLog.e$default(this.log, "trying to prepare to play but session not available", null, 2, null);
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$prepareToPlay$2", f = "FeedAudioPlayer.kt", i = {}, l = {WinError.RPC_S_PROTOCOL_ERROR}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$prepareToPlay$2, reason: invalid class name and case insensitive filesystem */
    static final class C10382 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Station $sta;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10382(Station station, Continuation<? super C10382> continuation) {
            super(2, continuation);
            this.$sta = station;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAudioPlayer.this.new C10382(this.$sta, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10382) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            MixingAudioPlayer mixingAudioPlayer;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NextSongProvider nextSongProvider = FeedAudioPlayer.this.songProvider;
                if (nextSongProvider == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider = null;
                }
                this.label = 1;
                obj = nextSongProvider.cacheNextPlayInStation(this.$sta, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Play play = (Play) obj;
            if (play != null && (mixingAudioPlayer = FeedAudioPlayer.this.mPlayer) != null) {
                mixingAudioPlayer.prepareTrack(play);
            }
            return Unit.INSTANCE;
        }
    }

    public final void downloadAndSync(Station station, StationDownloadListener downloadListener) {
        Intrinsics.checkNotNullParameter(station, "station");
        Intrinsics.checkNotNullParameter(downloadListener, "downloadListener");
        downloadAndSync(-1, station, downloadListener);
    }

    public final void downloadAndSync(int targetMins, Station station, StationDownloadListener downloadListener) {
        Intrinsics.checkNotNullParameter(station, "station");
        Intrinsics.checkNotNullParameter(downloadListener, "downloadListener");
        OfflineSession offlineSession = this.mOfflineSession;
        FeedSession feedSession = null;
        if (offlineSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            offlineSession = null;
        }
        List<AudioFile> audioItemsForLocalStationWithName = offlineSession.getAudioItemsForLocalStationWithName(station.getName());
        ArrayList arrayList = new ArrayList();
        Iterator<AudioFile> it = audioItemsForLocalStationWithName.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getId());
        }
        FeedSession feedSession2 = this.mSession;
        if (feedSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
        } else {
            feedSession = feedSession2;
        }
        feedSession.downloadAndSync(station, targetMins, arrayList, downloadListener);
    }

    public final void deleteOfflineStation(Station station) {
        Intrinsics.checkNotNullParameter(station, "station");
        OfflineSession offlineSession = this.mOfflineSession;
        if (offlineSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            offlineSession = null;
        }
        offlineSession.deleteLocalStationWithName(station.getName());
    }

    public final void deleteAllOfflineStations() {
        OfflineSession offlineSession = this.mOfflineSession;
        if (offlineSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            offlineSession = null;
        }
        offlineSession.deleteAllStations();
    }

    public final void like() throws JSONException {
        if (this.isOfflineStationActive) {
            OfflineSession offlineSession = this.mOfflineSession;
            if (offlineSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                offlineSession = null;
            }
            Play currentItem = offlineSession.getCurrentItem();
            like(currentItem != null ? currentItem.getAudioFile() : null);
            return;
        }
        NextSongProvider nextSongProvider = this.songProvider;
        if (nextSongProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider = null;
        }
        Play currentItem2 = nextSongProvider.getCurrentItem();
        like(currentItem2 != null ? currentItem2.getAudioFile() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void like(fm.feed.android.playersdk.models.AudioFile r4) throws org.json.JSONException {
        /*
            r3 = this;
            if (r4 != 0) goto L3
            return
        L3:
            r4.setUnliked()
            r4.setLiked()
            boolean r0 = r3.isOfflineStationActive
            r1 = 0
            if (r0 == 0) goto L1e
            fm.feed.android.playersdk.OfflineSession r0 = r3.mOfflineSession
            if (r0 != 0) goto L18
            java.lang.String r0 = "mOfflineSession"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L19
        L18:
            r1 = r0
        L19:
            r1.requestLikeForItem(r4)
            goto Lb1
        L1e:
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            java.lang.String r2 = "songProvider"
            if (r0 != 0) goto L28
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L28:
            fm.feed.android.playersdk.models.Play r0 = r0.getCurrentItem()
            if (r0 == 0) goto L62
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            if (r0 != 0) goto L36
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L36:
            fm.feed.android.playersdk.models.Play r0 = r0.getCurrentItem()
            if (r0 != 0) goto L3e
            r0 = r1
            goto L42
        L3e:
            fm.feed.android.playersdk.models.AudioFile r0 = r0.getAudioFile()
        L42:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 == 0) goto L62
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            if (r0 != 0) goto L50
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L50:
            fm.feed.android.playersdk.models.Play r0 = r0.getCurrentItem()
            if (r0 != 0) goto L57
            goto La3
        L57:
            fm.feed.android.playersdk.models.AudioFile r0 = r0.getAudioFile()
            if (r0 != 0) goto L5e
            goto La3
        L5e:
            r0.setLiked()
            goto La3
        L62:
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            if (r0 != 0) goto L6a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L6a:
            fm.feed.android.playersdk.models.Play r0 = r0.getNextItem()
            if (r0 == 0) goto La3
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            if (r0 != 0) goto L78
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L78:
            fm.feed.android.playersdk.models.Play r0 = r0.getNextItem()
            if (r0 != 0) goto L80
            r0 = r1
            goto L84
        L80:
            fm.feed.android.playersdk.models.AudioFile r0 = r0.getAudioFile()
        L84:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 == 0) goto La3
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            if (r0 != 0) goto L92
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L92:
            fm.feed.android.playersdk.models.Play r0 = r0.getNextItem()
            if (r0 != 0) goto L99
            goto La3
        L99:
            fm.feed.android.playersdk.models.AudioFile r0 = r0.getAudioFile()
            if (r0 != 0) goto La0
            goto La3
        La0:
            r0.setLiked()
        La3:
            fm.feed.android.playersdk.FeedSession r0 = r3.mSession
            if (r0 != 0) goto Lad
            java.lang.String r0 = "mSession"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto Lae
        Lad:
            r1 = r0
        Lae:
            r1.requestLike(r4)
        Lb1:
            java.util.ArrayList<fm.feed.android.playersdk.models.Play> r0 = r3.mPlayHistory
            java.util.Iterator r0 = r0.iterator()
        Lb7:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Ld0
            java.lang.Object r1 = r0.next()
            fm.feed.android.playersdk.models.Play r1 = (fm.feed.android.playersdk.models.Play) r1
            fm.feed.android.playersdk.models.AudioFile r2 = r1.getAudioFile()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            if (r2 == 0) goto Lb7
            r1.setAudioFile(r4)
        Ld0:
            java.util.ArrayList<fm.feed.android.playersdk.LikeStatusChangeListener> r0 = r3.mLikeStatusChangeListener
            java.util.Iterator r0 = r0.iterator()
        Ld6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Le6
            java.lang.Object r1 = r0.next()
            fm.feed.android.playersdk.LikeStatusChangeListener r1 = (fm.feed.android.playersdk.LikeStatusChangeListener) r1
            r1.onLikeStatusChanged(r4)
            goto Ld6
        Le6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer.like(fm.feed.android.playersdk.models.AudioFile):void");
    }

    public final void dislike() throws JSONException {
        if (this.isOfflineStationActive) {
            OfflineSession offlineSession = this.mOfflineSession;
            if (offlineSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                offlineSession = null;
            }
            Play currentItem = offlineSession.getCurrentItem();
            dislike(currentItem != null ? currentItem.getAudioFile() : null);
            return;
        }
        NextSongProvider nextSongProvider = this.songProvider;
        if (nextSongProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider = null;
        }
        Play currentItem2 = nextSongProvider.getCurrentItem();
        dislike(currentItem2 != null ? currentItem2.getAudioFile() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dislike(fm.feed.android.playersdk.models.AudioFile r4) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer.dislike(fm.feed.android.playersdk.models.AudioFile):void");
    }

    public final void unlike() throws JSONException {
        if (this.isOfflineStationActive) {
            OfflineSession offlineSession = this.mOfflineSession;
            if (offlineSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                offlineSession = null;
            }
            Play currentItem = offlineSession.getCurrentItem();
            unlike(currentItem != null ? currentItem.getAudioFile() : null);
            return;
        }
        NextSongProvider nextSongProvider = this.songProvider;
        if (nextSongProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider = null;
        }
        Play currentItem2 = nextSongProvider.getCurrentItem();
        unlike(currentItem2 != null ? currentItem2.getAudioFile() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void unlike(fm.feed.android.playersdk.models.AudioFile r4) throws org.json.JSONException {
        /*
            r3 = this;
            if (r4 != 0) goto L3
            return
        L3:
            r4.setUnliked()
            boolean r0 = r3.isOfflineStationActive
            r1 = 0
            if (r0 == 0) goto L1b
            fm.feed.android.playersdk.OfflineSession r0 = r3.mOfflineSession
            if (r0 != 0) goto L15
            java.lang.String r0 = "mOfflineSession"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L16
        L15:
            r1 = r0
        L16:
            r1.requestUnlikeForItem(r4)
            goto Lae
        L1b:
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            java.lang.String r2 = "songProvider"
            if (r0 != 0) goto L25
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L25:
            fm.feed.android.playersdk.models.Play r0 = r0.getCurrentItem()
            if (r0 == 0) goto L5f
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            if (r0 != 0) goto L33
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L33:
            fm.feed.android.playersdk.models.Play r0 = r0.getCurrentItem()
            if (r0 != 0) goto L3b
            r0 = r1
            goto L3f
        L3b:
            fm.feed.android.playersdk.models.AudioFile r0 = r0.getAudioFile()
        L3f:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 == 0) goto L5f
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            if (r0 != 0) goto L4d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L4d:
            fm.feed.android.playersdk.models.Play r0 = r0.getCurrentItem()
            if (r0 != 0) goto L54
            goto La0
        L54:
            fm.feed.android.playersdk.models.AudioFile r0 = r0.getAudioFile()
            if (r0 != 0) goto L5b
            goto La0
        L5b:
            r0.setUnliked()
            goto La0
        L5f:
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            if (r0 != 0) goto L67
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L67:
            fm.feed.android.playersdk.models.Play r0 = r0.getNextItem()
            if (r0 == 0) goto La0
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            if (r0 != 0) goto L75
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L75:
            fm.feed.android.playersdk.models.Play r0 = r0.getNextItem()
            if (r0 != 0) goto L7d
            r0 = r1
            goto L81
        L7d:
            fm.feed.android.playersdk.models.AudioFile r0 = r0.getAudioFile()
        L81:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 == 0) goto La0
            fm.feed.android.playersdk.NextSongProvider r0 = r3.songProvider
            if (r0 != 0) goto L8f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L8f:
            fm.feed.android.playersdk.models.Play r0 = r0.getNextItem()
            if (r0 != 0) goto L96
            goto La0
        L96:
            fm.feed.android.playersdk.models.AudioFile r0 = r0.getAudioFile()
            if (r0 != 0) goto L9d
            goto La0
        L9d:
            r0.setUnliked()
        La0:
            fm.feed.android.playersdk.FeedSession r0 = r3.mSession
            if (r0 != 0) goto Laa
            java.lang.String r0 = "mSession"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto Lab
        Laa:
            r1 = r0
        Lab:
            r1.requestUnlike(r4)
        Lae:
            java.util.ArrayList<fm.feed.android.playersdk.models.Play> r0 = r3.mPlayHistory
            java.util.Iterator r0 = r0.iterator()
        Lb4:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lcd
            java.lang.Object r1 = r0.next()
            fm.feed.android.playersdk.models.Play r1 = (fm.feed.android.playersdk.models.Play) r1
            fm.feed.android.playersdk.models.AudioFile r2 = r1.getAudioFile()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            if (r2 == 0) goto Lb4
            r1.setAudioFile(r4)
        Lcd:
            java.util.ArrayList<fm.feed.android.playersdk.LikeStatusChangeListener> r0 = r3.mLikeStatusChangeListener
            java.util.Iterator r0 = r0.iterator()
        Ld3:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Le3
            java.lang.Object r1 = r0.next()
            fm.feed.android.playersdk.LikeStatusChangeListener r1 = (fm.feed.android.playersdk.LikeStatusChangeListener) r1
            r1.onLikeStatusChanged(r4)
            goto Ld3
        Le3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer.unlike(fm.feed.android.playersdk.models.AudioFile):void");
    }

    public static /* synthetic */ void play$default(FeedAudioPlayer feedAudioPlayer, AudioFile audioFile, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        feedAudioPlayer.play(audioFile, z);
    }

    public final void play(AudioFile audioFile, boolean withCrossfade) {
        Intrinsics.checkNotNullParameter(audioFile, "audioFile");
        if (prePlayCheck()) {
            NextSongProvider nextSongProvider = this.songProvider;
            if (nextSongProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                nextSongProvider = null;
            }
            if (nextSongProvider.getCurrentItem() != null) {
                NextSongProvider nextSongProvider2 = this.songProvider;
                if (nextSongProvider2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider2 = null;
                }
                Play currentItem = nextSongProvider2.getCurrentItem();
                if (Intrinsics.areEqual(currentItem == null ? null : currentItem.getAudioFile(), audioFile)) {
                    return;
                }
            }
            if (withCrossfade) {
                MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
                if (mixingAudioPlayer != null) {
                    mixingAudioPlayer.flushAndIncludeCurrent(false);
                }
                BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new AnonymousClass3(audioFile, null), 3, null);
                return;
            }
            MixingAudioPlayer mixingAudioPlayer2 = this.mPlayer;
            if (mixingAudioPlayer2 != null) {
                mixingAudioPlayer2.pause();
            }
            MixingAudioPlayer mixingAudioPlayer3 = this.mPlayer;
            if (mixingAudioPlayer3 != null) {
                mixingAudioPlayer3.flushAndIncludeCurrent(true);
            }
            BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new AnonymousClass4(audioFile, null), 3, null);
            play();
        }
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$play$3", f = "FeedAudioPlayer.kt", i = {}, l = {1988}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$play$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioFile $audioFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AudioFile audioFile, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$audioFile = audioFile;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAudioPlayer.this.new AnonymousClass3(this.$audioFile, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NextSongProvider nextSongProvider = FeedAudioPlayer.this.songProvider;
                if (nextSongProvider == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider = null;
                }
                this.label = 1;
                obj = nextSongProvider.requestPlayForAudioFile(this.$audioFile, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Play play = (Play) obj;
            if (play != null) {
                FMLog.e$default(FeedAudioPlayer.this.log, Intrinsics.stringPlus("Adding PlayStation ", play), null, 2, null);
                MixingAudioPlayer mixingAudioPlayer = FeedAudioPlayer.this.mPlayer;
                if (mixingAudioPlayer != null) {
                    mixingAudioPlayer.addAudioAsset(play);
                }
                MixingAudioPlayer mixingAudioPlayer2 = FeedAudioPlayer.this.mPlayer;
                if (mixingAudioPlayer2 != null) {
                    mixingAudioPlayer2.skipWithCrossFade();
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$play$4", f = "FeedAudioPlayer.kt", i = {}, l = {2005}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$play$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioFile $audioFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(AudioFile audioFile, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$audioFile = audioFile;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAudioPlayer.this.new AnonymousClass4(this.$audioFile, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NextSongProvider nextSongProvider = FeedAudioPlayer.this.songProvider;
                if (nextSongProvider == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider = null;
                }
                this.label = 1;
                obj = nextSongProvider.requestPlayForAudioFile(this.$audioFile, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Play play = (Play) obj;
            if (play != null) {
                FMLog.e$default(FeedAudioPlayer.this.log, Intrinsics.stringPlus("Adding PlayStation ", play), null, 2, null);
                MixingAudioPlayer mixingAudioPlayer = FeedAudioPlayer.this.mPlayer;
                if (mixingAudioPlayer != null) {
                    mixingAudioPlayer.addAudioAsset(play);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void play$default(FeedAudioPlayer feedAudioPlayer, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        feedAudioPlayer.play((List<AudioFile>) list, z);
    }

    public final void play(List<AudioFile> audioFiles, boolean withCrossfade) {
        Intrinsics.checkNotNullParameter(audioFiles, "audioFiles");
        if (!prePlayCheck() || audioFiles.isEmpty()) {
            return;
        }
        NextSongProvider nextSongProvider = this.songProvider;
        if (nextSongProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider = null;
        }
        new PlayList.Editor(nextSongProvider.getPlayQueue()).clearPlayList();
        NextSongProvider nextSongProvider2 = this.songProvider;
        if (nextSongProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider2 = null;
        }
        new PlayList.Editor(nextSongProvider2.getPlayQueue()).addToPlayList(audioFiles);
        if (withCrossfade) {
            MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
            if (mixingAudioPlayer != null) {
                mixingAudioPlayer.flushAndIncludeCurrent(false);
            }
        } else {
            MixingAudioPlayer mixingAudioPlayer2 = this.mPlayer;
            if (mixingAudioPlayer2 != null) {
                mixingAudioPlayer2.pause();
            }
            MixingAudioPlayer mixingAudioPlayer3 = this.mPlayer;
            if (mixingAudioPlayer3 != null) {
                mixingAudioPlayer3.flushAndIncludeCurrent(true);
            }
        }
        checkAndAnnounceEndOfPlaylist();
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new AnonymousClass5(withCrossfade, null), 3, null);
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$play$5", f = "FeedAudioPlayer.kt", i = {}, l = {2043}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$play$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $withCrossfade;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$withCrossfade = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAudioPlayer.this.new AnonymousClass5(this.$withCrossfade, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NextSongProvider nextSongProvider = FeedAudioPlayer.this.songProvider;
                if (nextSongProvider == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                    nextSongProvider = null;
                }
                this.label = 1;
                obj = nextSongProvider.requestNextPlay(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Play play = (Play) obj;
            if (play != null) {
                FMLog.e$default(FeedAudioPlayer.this.log, Intrinsics.stringPlus("Adding PlayStation ", play), null, 2, null);
                MixingAudioPlayer mixingAudioPlayer = FeedAudioPlayer.this.mPlayer;
                if (mixingAudioPlayer != null) {
                    mixingAudioPlayer.addAudioAsset(play);
                }
                if (this.$withCrossfade) {
                    MixingAudioPlayer mixingAudioPlayer2 = FeedAudioPlayer.this.mPlayer;
                    if (mixingAudioPlayer2 != null) {
                        mixingAudioPlayer2.skipWithCrossFade();
                    }
                } else {
                    FeedAudioPlayer.this.play();
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAndAnnounceEndOfPlaylist() {
        NextSongProvider nextSongProvider = this.songProvider;
        NextSongProvider nextSongProvider2 = null;
        if (nextSongProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider = null;
        }
        if (nextSongProvider.getCurrentMusicSource() == MusicSource.ON_DEMAND) {
            NextSongProvider nextSongProvider3 = this.songProvider;
            if (nextSongProvider3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            } else {
                nextSongProvider2 = nextSongProvider3;
            }
            if (new PlayList.Editor(nextSongProvider2.getPlayQueue()).viewCurrentPlayList().isEmpty()) {
                Iterator<T> it = this.mOutOfMusicListeners.iterator();
                while (it.hasNext()) {
                    ((OutOfMusicListener) it.next()).onOutOfMusic();
                }
            }
        }
    }

    public static /* synthetic */ void play$default(FeedAudioPlayer feedAudioPlayer, Station station, boolean z, int i, Object obj) throws JSONException {
        if ((i & 2) != 0) {
            z = false;
        }
        feedAudioPlayer.play(station, z);
    }

    public final void play(Station station, boolean withCrossfade) throws JSONException {
        Intrinsics.checkNotNullParameter(station, "station");
        setActiveStation$default(this, station, withCrossfade, 0.0f, 4, null);
        play();
    }

    private final boolean prePlayCheck() {
        if (this.isOfflineStationActive) {
            return false;
        }
        if (this.mState == State.UNINITIALIZED) {
            FMLog.e$default(this.log, "attempting to play specific song before player is initialized", null, 2, null);
            return false;
        }
        if (this.mState != State.UNAVAILABLE) {
            return true;
        }
        FMLog.e$default(this.log, "attempting to play specific song but player is unavailable", null, 2, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareStations() {
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        feedSession.prepareCache();
    }

    public static /* synthetic */ void prepareStations$default(FeedAudioPlayer feedAudioPlayer, List list, CachePreparedListener cachePreparedListener, int i, Object obj) {
        if ((i & 2) != 0) {
            cachePreparedListener = null;
        }
        feedAudioPlayer.prepareStations(list, cachePreparedListener);
    }

    public final void prepareStations(List<Station> stations, CachePreparedListener listener) {
        Intrinsics.checkNotNullParameter(stations, "stations");
        this.cachePreparedListener = listener;
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        feedSession.prepareStationCache(stations);
    }

    public final void setVolume(float volume) {
        MixingAudioPlayer mixingAudioPlayer;
        this.mVolume = volume;
        MixingAudioPlayer mixingAudioPlayer2 = this.mPlayer;
        if (Intrinsics.areEqual(volume, mixingAudioPlayer2 == null ? null : Float.valueOf(mixingAudioPlayer2.getVolume())) || (mixingAudioPlayer = this.mPlayer) == null) {
            return;
        }
        mixingAudioPlayer.setVolume(volume);
    }

    public final PlayList.Editor getPlayQueueEditor() {
        NextSongProvider nextSongProvider = this.songProvider;
        if (nextSongProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider = null;
        }
        return new PlayList.Editor(nextSongProvider.getPlayQueue());
    }

    public static /* synthetic */ void setActiveStation$default(FeedAudioPlayer feedAudioPlayer, Station station, boolean z, float f, int i, Object obj) throws JSONException {
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        feedAudioPlayer.setActiveStation(station, z, f);
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setActiveStation(fm.feed.android.playersdk.models.Station r11, boolean r12, float r13) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer.setActiveStation(fm.feed.android.playersdk.models.Station, boolean, float):void");
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$setActiveStation$2", f = "FeedAudioPlayer.kt", i = {}, l = {2296, LMErr.NERR_IncompleteDel}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$setActiveStation$2, reason: invalid class name and case insensitive filesystem */
    static final class C10392 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $advanceBy;
        final /* synthetic */ Station $station;
        int label;
        final /* synthetic */ FeedAudioPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10392(float f, FeedAudioPlayer feedAudioPlayer, Station station, Continuation<? super C10392> continuation) {
            super(2, continuation);
            this.$advanceBy = f;
            this.this$0 = feedAudioPlayer;
            this.$station = station;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10392(this.$advanceBy, this.this$0, this.$station, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10392) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                java.lang.String r2 = "songProvider"
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L22
                if (r1 == r4) goto L1d
                if (r1 != r3) goto L15
                kotlin.ResultKt.throwOnFailure(r13)
                goto L44
            L15:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1d:
                kotlin.ResultKt.throwOnFailure(r13)
                goto L8d
            L22:
                kotlin.ResultKt.throwOnFailure(r13)
                float r13 = r12.$advanceBy
                r1 = 0
                int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
                if (r13 != 0) goto L47
                fm.feed.android.playersdk.FeedAudioPlayer r13 = r12.this$0
                fm.feed.android.playersdk.NextSongProvider r13 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r13)
                if (r13 != 0) goto L38
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                r13 = r5
            L38:
                r1 = r12
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r12.label = r3
                java.lang.Object r13 = r13.requestNextPlay(r1)
                if (r13 != r0) goto L44
                return r0
            L44:
                fm.feed.android.playersdk.models.Play r13 = (fm.feed.android.playersdk.models.Play) r13
                goto L9e
            L47:
                fm.feed.android.playersdk.FeedAudioPlayer r13 = r12.this$0
                fm.feed.android.playersdk.FeedSession r13 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMSession$p(r13)
                java.lang.String r1 = "mSession"
                if (r13 != 0) goto L55
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r13 = r5
            L55:
                r13.reset()
                fm.feed.android.playersdk.FeedAudioPlayer r13 = r12.this$0
                fm.feed.android.playersdk.MixingAudioPlayer r13 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMPlayer$p(r13)
                if (r13 != 0) goto L61
                goto L64
            L61:
                r13.setBTrimmingEnabled(r4)
            L64:
                fm.feed.android.playersdk.FeedAudioPlayer r13 = r12.this$0
                fm.feed.android.playersdk.FeedSession r13 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMSession$p(r13)
                if (r13 != 0) goto L71
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                r6 = r5
                goto L72
            L71:
                r6 = r13
            L72:
                fm.feed.android.playersdk.models.Station r7 = r12.$station
                float r13 = r12.$advanceBy
                java.lang.Float r9 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
                fm.feed.android.playersdk.FeedAudioPlayer r13 = r12.this$0
                java.lang.Float r10 = r13.getSecondsOfCrossfade()
                r11 = r12
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                r12.label = r4
                r8 = 0
                java.lang.Object r13 = r6.requestAudioFile(r7, r8, r9, r10, r11)
                if (r13 != r0) goto L8d
                return r0
            L8d:
                fm.feed.android.playersdk.models.Play r13 = (fm.feed.android.playersdk.models.Play) r13
                fm.feed.android.playersdk.FeedAudioPlayer r0 = r12.this$0
                fm.feed.android.playersdk.NextSongProvider r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r0)
                if (r0 != 0) goto L9b
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                r0 = r5
            L9b:
                r0.setNextItem(r13)
            L9e:
                if (r13 == 0) goto Lbb
                fm.feed.android.playersdk.FeedAudioPlayer r0 = r12.this$0
                fm.feed.android.playersdk.FMLog r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getLog$p(r0)
                java.lang.String r1 = "Adding setActiveStation "
                java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r13)
                fm.feed.android.playersdk.FMLog.d$default(r0, r1, r5, r3, r5)
                fm.feed.android.playersdk.FeedAudioPlayer r0 = r12.this$0
                fm.feed.android.playersdk.MixingAudioPlayer r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMPlayer$p(r0)
                if (r0 != 0) goto Lb8
                goto Lbb
            Lb8:
                r0.addAudioAsset(r13)
            Lbb:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer.C10392.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void activeStationDidChange() {
        NextSongProvider nextSongProvider = this.songProvider;
        if (nextSongProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider = null;
        }
        Station currentStation = nextSongProvider.getCurrentStation();
        if (currentStation != null) {
            if (currentStation.getCastUrl() != null) {
                MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
                if (mixingAudioPlayer != null) {
                    mixingAudioPlayer.pause();
                }
                MixingAudioPlayer mixingAudioPlayer2 = this.mPlayer;
                if (mixingAudioPlayer2 != null) {
                    mixingAudioPlayer2.flushAndIncludeCurrent(true);
                }
            }
            Iterator<StationChangedListener> it = this.mStationChangedListener.iterator();
            while (it.hasNext()) {
                it.next().onStationChanged(currentStation);
            }
        }
    }

    public final void logEvent(String event) throws JSONException {
        Intrinsics.checkNotNullParameter(event, "event");
        FeedSession feedSession = null;
        if (this.isOfflineStationActive) {
            OfflineSession offlineSession = this.mOfflineSession;
            if (offlineSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                offlineSession = null;
            }
            offlineSession.logEvent(event, null);
            return;
        }
        FeedSession feedSession2 = this.mSession;
        if (feedSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
        } else {
            feedSession = feedSession2;
        }
        feedSession.logEvent(event);
    }

    public final void logEvent(String event, Object params) throws JSONException {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        String json = new Gson().toJson(params);
        FeedSession feedSession = null;
        OfflineSession offlineSession = null;
        if (this.isOfflineStationActive) {
            OfflineSession offlineSession2 = this.mOfflineSession;
            if (offlineSession2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            } else {
                offlineSession = offlineSession2;
            }
            offlineSession.logEvent(event, json);
            return;
        }
        FeedSession feedSession2 = this.mSession;
        if (feedSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
        } else {
            feedSession = feedSession2;
        }
        feedSession.logEvent(event, params);
    }

    public final String getClientId() {
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        String clientId = feedSession.getClientId();
        if (clientId == null) {
            return null;
        }
        return INSTANCE.wrapClientId(clientId);
    }

    public final boolean setClientId(String exportedClientId) throws JSONException {
        Intrinsics.checkNotNullParameter(exportedClientId, "exportedClientId");
        FeedSession feedSession = null;
        if (this.mState == State.UNINITIALIZED || this.mState == State.UNAVAILABLE) {
            FMLog.e$default(this.log, "Attempt to update client id to " + exportedClientId + " failed because player is not ready", null, 2, null);
            return false;
        }
        String strUnwrapClientId = INSTANCE.unwrapClientId(exportedClientId);
        if (strUnwrapClientId == null) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Cannot update client id to invalid value: ", exportedClientId), null, 2, null);
            return false;
        }
        FeedSession feedSession2 = this.mSession;
        if (feedSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
        } else {
            feedSession = feedSession2;
        }
        if (Intrinsics.areEqual(strUnwrapClientId, feedSession.getClientId())) {
            return true;
        }
        setClientIdAndResetSession(strUnwrapClientId);
        return true;
    }

    public final void createNewClientId(final ClientIdListener listener) {
        FeedSession feedSession = this.mSession;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        feedSession.generateClientId(new FeedSession.ClientIdListener() { // from class: fm.feed.android.playersdk.FeedAudioPlayer.createNewClientId.1
            @Override // fm.feed.android.playersdk.FeedSession.ClientIdListener
            public void onSuccess(String clientId) throws JSONException {
                Intrinsics.checkNotNullParameter(clientId, "clientId");
                FeedAudioPlayer.this.setClientIdAndResetSession(clientId);
                ClientIdListener clientIdListener = listener;
                if (clientIdListener == null) {
                    return;
                }
                clientIdListener.onClientId(FeedAudioPlayer.INSTANCE.wrapClientId(clientId));
            }

            @Override // fm.feed.android.playersdk.FeedSession.ClientIdListener
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                ClientIdListener clientIdListener = listener;
                if (clientIdListener == null) {
                    return;
                }
                clientIdListener.onError();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setClientIdAndResetSession(String clientId) throws JSONException {
        pause();
        FeedSession feedSession = this.mSession;
        FeedSession feedSession2 = null;
        if (feedSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession = null;
        }
        feedSession.reset();
        OfflineSession offlineSession = this.mOfflineSession;
        if (offlineSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            offlineSession = null;
        }
        offlineSession.reset();
        NextSongProvider nextSongProvider = this.songProvider;
        if (nextSongProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("songProvider");
            nextSongProvider = null;
        }
        nextSongProvider.reset();
        MixingAudioPlayer mixingAudioPlayer = this.mPlayer;
        if (mixingAudioPlayer != null) {
            mixingAudioPlayer.flushAndIncludeCurrent(true);
        }
        OfflineSession offlineSession2 = this.mOfflineSession;
        if (offlineSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            offlineSession2 = null;
        }
        JSONArray jSONArrayCopyAndResetLogs = offlineSession2.copyAndResetLogs();
        FeedSession feedSession3 = this.mSession;
        if (feedSession3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession3 = null;
        }
        Boolean boolIsAvailable = feedSession3.isAvailable();
        if (boolIsAvailable != null) {
            boolean zBooleanValue = boolIsAvailable.booleanValue();
            if (jSONArrayCopyAndResetLogs.length() > 0 && zBooleanValue) {
                FeedSession feedSession4 = this.mSession;
                if (feedSession4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSession");
                    feedSession4 = null;
                }
                feedSession4.sendOfflineLogs(jSONArrayCopyAndResetLogs, new FeedSession.OfflineLogsListener() { // from class: fm.feed.android.playersdk.FeedAudioPlayer$setClientIdAndResetSession$1$1
                    @Override // fm.feed.android.playersdk.FeedSession.OfflineLogsListener
                    public void offlineLogSaveFailed(JSONArray logs) {
                        Intrinsics.checkNotNullParameter(logs, "logs");
                        OfflineSession offlineSession3 = this.this$0.mOfflineSession;
                        if (offlineSession3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                            offlineSession3 = null;
                        }
                        offlineSession3.prependLogs(logs);
                    }
                });
            }
        }
        FeedSession feedSession5 = this.mSession;
        if (feedSession5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
            feedSession5 = null;
        }
        feedSession5.setClientId(clientId);
        FeedSession feedSession6 = this.mSession;
        if (feedSession6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSession");
        } else {
            feedSession2 = feedSession6;
        }
        feedSession2.prepareCache();
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$assert$1", f = "FeedAudioPlayer.kt", i = {0}, l = {2493}, m = "invokeSuspend", n = {"map"}, s = {"L$0"})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$assert$1, reason: invalid class name and case insensitive filesystem */
    static final class C10341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $bool;
        final /* synthetic */ String $msg;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ FeedAudioPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10341(boolean z, FeedAudioPlayer feedAudioPlayer, String str, Continuation<? super C10341> continuation) {
            super(2, continuation);
            this.$bool = z;
            this.this$0 = feedAudioPlayer;
            this.$msg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10341(this.$bool, this.this$0, this.$msg, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            LinkedHashMap linkedHashMap;
            Map map;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.$bool) {
                    FeedSession feedSession = this.this$0.mSession;
                    if (feedSession == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSession");
                        feedSession = null;
                    }
                    if (feedSession.getLoggingEnabled()) {
                        linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("description", this.$msg);
                        this.L$0 = linkedHashMap;
                        this.L$1 = linkedHashMap;
                        this.L$2 = "SessionLogs";
                        this.label = 1;
                        obj = FMLog.INSTANCE.returnLogs$PlayerSdk_exoDefaultRelease(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map = linkedHashMap;
                        str = "SessionLogs";
                    }
                    FMLog.wtf$default(this.this$0.log, this.$msg, null, 2, null);
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$2;
            linkedHashMap = (Map) this.L$1;
            map = (Map) this.L$0;
            ResultKt.throwOnFailure(obj);
            linkedHashMap.put(str, obj);
            FeedSession feedSession2 = this.this$0.mSession;
            if (feedSession2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSession");
                feedSession2 = null;
            }
            feedSession2.logEvent("FeedAudioPlayer failed assertion", map);
            FMLog.wtf$default(this.this$0.log, this.$msg, null, 2, null);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: assert, reason: not valid java name */
    private final void m8777assert(boolean bool, String msg) {
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C10341(bool, this, msg, null), 3, null);
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$assert$2", f = "FeedAudioPlayer.kt", i = {0}, l = {LMErr.NERR_RplLoadrDiskErr}, m = "invokeSuspend", n = {"map"}, s = {"L$0"})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$assert$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $msg;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ FeedAudioPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, FeedAudioPlayer feedAudioPlayer, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$msg = str;
            this.this$0 = feedAudioPlayer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$msg, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            LinkedHashMap linkedHashMap;
            Map map;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("description", this.$msg);
                this.L$0 = linkedHashMap;
                this.L$1 = linkedHashMap;
                this.L$2 = "SessionLogs";
                this.label = 1;
                obj = FMLog.INSTANCE.returnLogs$PlayerSdk_exoDefaultRelease(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                map = linkedHashMap;
                str = "SessionLogs";
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$2;
                linkedHashMap = (Map) this.L$1;
                map = (Map) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            linkedHashMap.put(str, obj);
            FeedSession feedSession = this.this$0.mSession;
            if (feedSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSession");
                feedSession = null;
            }
            feedSession.logEvent(this.$msg, map);
            Log.e("Assert!!", this.$msg);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: assert, reason: not valid java name */
    public final void m8776assert(String msg) {
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new AnonymousClass2(msg, this, null), 3, null);
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$submitLogsForRemoteDebuggingWithLabel$1", f = "FeedAudioPlayer.kt", i = {0}, l = {2522}, m = "invokeSuspend", n = {"map"}, s = {"L$0"})
    /* renamed from: fm.feed.android.playersdk.FeedAudioPlayer$submitLogsForRemoteDebuggingWithLabel$1, reason: invalid class name and case insensitive filesystem */
    static final class C10411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $msg;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ FeedAudioPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10411(String str, FeedAudioPlayer feedAudioPlayer, Continuation<? super C10411> continuation) {
            super(2, continuation);
            this.$msg = str;
            this.this$0 = feedAudioPlayer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10411(this.$msg, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            LinkedHashMap linkedHashMap;
            Map map;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("description", this.$msg);
                this.L$0 = linkedHashMap;
                this.L$1 = linkedHashMap;
                this.L$2 = "SessionLogs";
                this.label = 1;
                obj = FMLog.INSTANCE.returnLogs$PlayerSdk_exoDefaultRelease(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                map = linkedHashMap;
                str = "SessionLogs";
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$2;
                linkedHashMap = (Map) this.L$1;
                map = (Map) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            linkedHashMap.put(str, obj);
            FeedSession feedSession = this.this$0.mSession;
            if (feedSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSession");
                feedSession = null;
            }
            feedSession.logEvent("Client Logs Trigger", map);
            return Unit.INSTANCE;
        }
    }

    public final void submitLogsForRemoteDebuggingWithLabel(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C10411(msg, this, null), 3, null);
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0010R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lfm/feed/android/playersdk/FeedAudioPlayer$Builder;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "token", "", "secret", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "availabilityListener", "Lfm/feed/android/playersdk/AvailabilityListener;", "getContext", "()Landroid/content/Context;", "createNewClientId", "", "exportedClientId", LocationCompat.EXTRA_IS_MOCK, "Lfm/feed/android/playersdk/MockLocations;", "build", "Lfm/feed/android/playersdk/FeedAudioPlayer;", "setAvailabilityListener", "setClientId", "clientId", "setCreateNewClientId", "setMockLocation", "location", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private AvailabilityListener availabilityListener;
        private final Context context;
        private boolean createNewClientId;
        private String exportedClientId;
        private MockLocations mockLocation;
        private String secret;
        private String token;

        public Builder(Context context, String token, String secret) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(secret, "secret");
            this.context = context;
            this.token = token;
            this.secret = secret;
        }

        public final Context getContext() {
            return this.context;
        }

        public final Builder setAvailabilityListener(AvailabilityListener availabilityListener) {
            Intrinsics.checkNotNullParameter(availabilityListener, "availabilityListener");
            this.availabilityListener = availabilityListener;
            return this;
        }

        public final Builder setClientId(String clientId) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            this.exportedClientId = clientId;
            return this;
        }

        public final Builder setCreateNewClientId(boolean createNewClientId) {
            this.createNewClientId = createNewClientId;
            return this;
        }

        public final Builder setMockLocation(MockLocations location) {
            Intrinsics.checkNotNullParameter(location, "location");
            this.mockLocation = location;
            return this;
        }

        public final FeedAudioPlayer build() {
            return new FeedAudioPlayer(this.context, this.token, this.secret, this.availabilityListener, this.exportedClientId, this.createNewClientId, this.mockLocation, null);
        }
    }

    /* compiled from: FeedAudioPlayer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u0019"}, d2 = {"Lfm/feed/android/playersdk/FeedAudioPlayer$Companion;", "", "()V", "EXPORT_CLIENT_ID_PREFIX", "", "UPDATE_PERIOD", "", "autoNetworkRetry", "", "getAutoNetworkRetry$annotations", "getAutoNetworkRetry", "()Z", "setAutoNetworkRetry", "(Z)V", "disableAudioFocus", "getDisableAudioFocus$annotations", "getDisableAudioFocus", "setDisableAudioFocus", "setBaseUrl", "", "url", "unwrapClientId", "exportedClientId", "wrapClientId", "clientId", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getAutoNetworkRetry$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getDisableAudioFocus$annotations() {
        }

        private Companion() {
        }

        public final boolean getAutoNetworkRetry() {
            return FeedAudioPlayer.autoNetworkRetry;
        }

        public final void setAutoNetworkRetry(boolean z) {
            FeedAudioPlayer.autoNetworkRetry = z;
        }

        public final boolean getDisableAudioFocus() {
            return FeedAudioPlayer.disableAudioFocus;
        }

        public final void setDisableAudioFocus(boolean z) {
            FeedAudioPlayer.disableAudioFocus = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String wrapClientId(String clientId) {
            return Intrinsics.stringPlus(FeedAudioPlayer.EXPORT_CLIENT_ID_PREFIX, clientId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String unwrapClientId(String exportedClientId) {
            if (!StringsKt.startsWith$default(exportedClientId, FeedAudioPlayer.EXPORT_CLIENT_ID_PREFIX, false, 2, (Object) null)) {
                return null;
            }
            int length = FeedAudioPlayer.EXPORT_CLIENT_ID_PREFIX.length();
            if (exportedClientId == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = exportedClientId.substring(length);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }

        @JvmStatic
        public final void setBaseUrl(String url) throws SecurityException {
            Intrinsics.checkNotNullParameter(url, "url");
            FeedSession.INSTANCE.changeBaseURL(url);
        }
    }
}
