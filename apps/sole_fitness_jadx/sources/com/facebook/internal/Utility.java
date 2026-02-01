package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.http.HttpHost;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: Utility.kt */
@Metadata(d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\bí\u0001î\u0001ï\u0001ð\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010)\u001a\u00020 \"\u0004\b\u0000\u0010*2\b\u0010+\u001a\u0004\u0018\u0001H*2\b\u0010,\u001a\u0004\u0018\u0001H*H\u0007¢\u0006\u0002\u0010-J7\u0010.\u001a\u0012\u0012\u0004\u0012\u0002H*0/j\b\u0012\u0004\u0012\u0002H*`0\"\u0004\b\u0000\u0010*2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u0002H*02\"\u0002H*H\u0007¢\u0006\u0002\u00103J-\u00104\u001a\b\u0012\u0004\u0012\u0002H*05\"\u0004\b\u0000\u0010*2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002H*02\"\u0002H*H\u0007¢\u0006\u0002\u00107J\u0012\u00108\u001a\u0004\u0018\u00010\u001a2\u0006\u00109\u001a\u00020\u0004H\u0007J&\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010\u00042\b\u0010>\u001a\u0004\u0018\u00010?H\u0007J\b\u0010@\u001a\u00020AH\u0007J\u0018\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0004H\u0002J\u0010\u0010F\u001a\u00020A2\u0006\u0010C\u001a\u00020DH\u0007J\u0012\u0010G\u001a\u00020A2\b\u0010H\u001a\u0004\u0018\u00010IH\u0007J\u001e\u0010J\u001a\u0004\u0018\u00010\u00042\b\u0010K\u001a\u0004\u0018\u00010\u00042\b\u0010L\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020OH\u0002J\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020\u0004052\u0006\u0010Q\u001a\u00020RH\u0007J\u001c\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010T2\u0006\u0010U\u001a\u00020\u001aH\u0007J\u001c\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040T2\u0006\u0010U\u001a\u00020\u001aH\u0007J\u001a\u0010W\u001a\u00020\u00062\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020[H\u0007J\u0012\u0010\\\u001a\u00020A2\b\u0010]\u001a\u0004\u0018\u00010^H\u0007J\u0012\u0010_\u001a\u00020A2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J\b\u0010b\u001a\u00020 H\u0002J4\u0010c\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u000105\"\u0004\b\u0000\u0010*2\u000e\u0010d\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u0001052\f\u0010e\u001a\b\u0012\u0004\u0012\u0002H*0fH\u0007J\u0010\u0010g\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u0006H\u0007J\u0012\u0010i\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010DH\u0007J\u0010\u0010j\u001a\u00020\u00042\u0006\u0010C\u001a\u00020DH\u0007J\n\u0010k\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010l\u001a\u0004\u0018\u00010m2\b\u0010n\u001a\u0004\u0018\u00010?2\b\u0010o\u001a\u0004\u0018\u00010\u00042\u0006\u0010p\u001a\u00020mH\u0007J\u0010\u0010q\u001a\u00020\u00132\u0006\u0010r\u001a\u00020;H\u0007J\n\u0010s\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010t\u001a\u00020\u00042\b\u0010u\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010v\u001a\u00020w2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0018\u0010x\u001a\u00020A2\u0006\u00109\u001a\u00020\u00042\u0006\u0010y\u001a\u00020zH\u0007J\u0012\u0010{\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010DH\u0007JF\u0010|\u001a\u0004\u0018\u00010}2\n\u0010~\u001a\u0006\u0012\u0002\b\u00030\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u00042\u001f\u0010\u0081\u0001\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u007f02\"\b\u0012\u0002\b\u0003\u0018\u00010\u007fH\u0007¢\u0006\u0003\u0010\u0082\u0001JC\u0010|\u001a\u0004\u0018\u00010}2\u0007\u0010\u0083\u0001\u001a\u00020\u00042\u0007\u0010\u0080\u0001\u001a\u00020\u00042\u001f\u0010\u0081\u0001\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u007f02\"\b\u0012\u0002\b\u0003\u0018\u00010\u007fH\u0007¢\u0006\u0003\u0010\u0084\u0001J\u0014\u0010\u0085\u0001\u001a\u00020\u00042\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010U\u001a\u00020\u001a2\b\u0010o\u001a\u0004\u0018\u00010\u00042\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010;H\u0007J\u0013\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u001aH\u0007J\u001d\u0010\u008e\u0001\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010\u001a2\b\u0010,\u001a\u0004\u0018\u00010\u001aH\u0007J\u001c\u0010\u008f\u0001\u001a\u00020\u00042\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010N\u001a\u00030\u0092\u0001H\u0002J;\u0010\u0093\u0001\u001a\u0014\u0012\u0004\u0012\u0002H*0\u0094\u0001j\t\u0012\u0004\u0012\u0002H*`\u0095\u0001\"\u0004\b\u0000\u0010*2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u0002H*02\"\u0002H*H\u0007¢\u0006\u0003\u0010\u0096\u0001J\u001d\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0098\u0001\u001a\u00020\u00042\u0007\u0010N\u001a\u00030\u0092\u0001H\u0002J\u001c\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0098\u0001\u001a\u00020\u00042\u0006\u0010o\u001a\u00020\u0004H\u0002J$\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0007J>\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010\u009f\u0001\u001a\u00020}2\u0017\u0010 \u0001\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000102\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010¡\u0001J\u0011\u0010¢\u0001\u001a\u00020 2\u0006\u0010C\u001a\u00020DH\u0007J\u0011\u0010£\u0001\u001a\u00020 2\u0006\u0010C\u001a\u00020DH\u0007J\u0014\u0010¤\u0001\u001a\u00020 2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010;H\u0007J\u0015\u0010¥\u0001\u001a\u00020 2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0007J\u0014\u0010¨\u0001\u001a\u00020 2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010;H\u0007J\u0013\u0010©\u0001\u001a\u00020 2\b\u0010K\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010©\u0001\u001a\u00020 \"\u0004\b\u0000\u0010*2\u0010\u0010ª\u0001\u001a\u000b\u0012\u0004\u0012\u0002H*\u0018\u00010«\u0001H\u0007J3\u0010¬\u0001\u001a\u00020 \"\u0004\b\u0000\u0010*2\u0010\u0010\u00ad\u0001\u001a\u000b\u0012\u0004\u0012\u0002H*\u0018\u00010«\u00012\u0010\u0010®\u0001\u001a\u000b\u0012\u0004\u0012\u0002H*\u0018\u00010«\u0001H\u0007J\u0014\u0010¯\u0001\u001a\u00020 2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010;H\u0007J\u0018\u0010°\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040±\u00012\u0006\u0010Q\u001a\u00020RH\u0007J\u0017\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004052\u0006\u0010Q\u001a\u00020RH\u0007J\u001e\u0010³\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040T2\u0007\u0010´\u0001\u001a\u00020\u0004H\u0007J'\u0010µ\u0001\u001a\u00020A2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u00042\u0011\u0010·\u0001\u001a\f\u0018\u00010¸\u0001j\u0005\u0018\u0001`¹\u0001H\u0007J\u001f\u0010µ\u0001\u001a\u00020A2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J+\u0010µ\u0001\u001a\u00020A2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010º\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0007JF\u0010½\u0001\u001a\u000b\u0012\u0005\u0012\u0003H¾\u0001\u0018\u000105\"\u0004\b\u0000\u0010*\"\u0005\b\u0001\u0010¾\u00012\u000e\u0010d\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u0001052\u0015\u0010¿\u0001\u001a\u0010\u0012\u0004\u0012\u0002H*\u0012\u0005\u0012\u0003H¾\u00010À\u0001H\u0007J\"\u0010Á\u0001\u001a\u00020\u00042\u0017\u0010½\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040TH\u0007J\u0013\u0010Â\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010o\u001a\u00020\u0004H\u0007J\u0011\u0010Ã\u0001\u001a\u00020 2\u0006\u0010C\u001a\u00020DH\u0007J\u0014\u0010Ä\u0001\u001a\u00020?2\t\u0010Å\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J.\u0010Æ\u0001\u001a\u00020A2\u0006\u0010,\u001a\u00020?2\b\u0010o\u001a\u0004\u0018\u00010\u00042\u0011\u0010Ç\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u000105H\u0007J&\u0010È\u0001\u001a\u00020 2\u0006\u0010n\u001a\u00020?2\b\u0010o\u001a\u0004\u0018\u00010\u00042\t\u0010É\u0001\u001a\u0004\u0018\u00010\u0001H\u0007J&\u0010Ê\u0001\u001a\u00020A2\u0006\u0010,\u001a\u00020?2\b\u0010o\u001a\u0004\u0018\u00010\u00042\t\u0010É\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010Ë\u0001\u001a\u00020A2\u0006\u0010,\u001a\u00020?2\b\u0010o\u001a\u0004\u0018\u00010\u00042\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010;H\u0007J\u0013\u0010Ì\u0001\u001a\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010YH\u0007J%\u0010Í\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010T2\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0007J\t\u0010Ð\u0001\u001a\u00020AH\u0002J\t\u0010Ñ\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010Ò\u0001\u001a\u00020A2\u0007\u0010Ó\u0001\u001a\u00020DH\u0002J\u0012\u0010Ô\u0001\u001a\u00020A2\u0007\u0010Ó\u0001\u001a\u00020DH\u0002J\t\u0010Õ\u0001\u001a\u00020AH\u0002J\t\u0010Ö\u0001\u001a\u00020AH\u0002J\u0015\u0010×\u0001\u001a\u00020A2\n\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u0001H\u0007J\u001f\u0010Ú\u0001\u001a\u00020\u00042\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J2\u0010Ý\u0001\u001a\u00020A2\u0007\u0010Þ\u0001\u001a\u00020\u001a2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00012\t\u0010á\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010â\u0001\u001a\u00020 H\u0007J\u001b\u0010ã\u0001\u001a\u00020A2\u0007\u0010Þ\u0001\u001a\u00020\u001a2\u0007\u0010Ó\u0001\u001a\u00020DH\u0007J\u0014\u0010ä\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010N\u001a\u00030\u0092\u0001H\u0007J\u0013\u0010ä\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010o\u001a\u00020\u0004H\u0007J\u0016\u0010å\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010N\u001a\u0005\u0018\u00010\u0092\u0001H\u0007J\u0015\u0010å\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010o\u001a\u0004\u0018\u00010\u0004H\u0007J\u001d\u0010æ\u0001\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010ç\u0001\u001a\u0004\u0018\u00010R2\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010è\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010é\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010è\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J0\u0010ê\u0001\u001a\t\u0012\u0004\u0012\u0002H*0«\u0001\"\u0004\b\u0000\u0010*2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u0002H*02\"\u0002H*H\u0007¢\u0006\u0003\u0010ë\u0001J.\u0010ì\u0001\u001a\u00020A2\b\u0010Î\u0001\u001a\u00030Ï\u00012\u0019\u0010½\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010TH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\u001f\u0010\"R\u0011\u0010#\u001a\u00020 8G¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\u00168G¢\u0006\u0006\u001a\u0004\b&\u0010\u0018R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ñ\u0001"}, d2 = {"Lcom/facebook/internal/Utility;", "", "()V", "ARC_DEVICE_PATTERN", "", "DEFAULT_STREAM_BUFFER_SIZE", "", "EXTRA_APP_EVENTS_INFO_FORMAT_VERSION", "FACEBOOK_PROFILE_FIELDS", "HASH_ALGORITHM_MD5", "HASH_ALGORITHM_SHA1", "HASH_ALGORITHM_SHA256", "INSTAGRAM_PROFILE_FIELDS", "LOG_TAG", "NO_CARRIER", "REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS", "URL_SCHEME", "UTF8", "availableExternalStorageGB", "", "carrierName", "currentLocale", "Ljava/util/Locale;", "getCurrentLocale", "()Ljava/util/Locale;", "dataProcessingOptions", "Lorg/json/JSONObject;", "getDataProcessingOptions", "()Lorg/json/JSONObject;", "deviceTimeZoneName", "deviceTimezoneAbbreviation", "isAutoAppLinkSetup", "", "isAutoAppLinkSetup$annotations", "()Z", "isDataProcessingRestricted", "numCPUCores", "resourceLocale", "getResourceLocale", "timestampOfLastCheck", "totalExternalStorageGB", "areObjectsEqual", ExifInterface.GPS_DIRECTION_TRUE, "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "arrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ts", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "asListNoNulls", "", "array", "([Ljava/lang/Object;)Ljava/util/List;", "awaitGetGraphMeRequestWithCache", SDKConstants.PARAM_ACCESS_TOKEN, "buildUri", "Landroid/net/Uri;", "authority", ClientCookie.PATH_ATTR, "parameters", "Landroid/os/Bundle;", "clearCaches", "", "clearCookiesForDomain", "context", "Landroid/content/Context;", ClientCookie.DOMAIN_ATTR, "clearFacebookCookies", "closeQuietly", "closeable", "Ljava/io/Closeable;", "coerceValueIfNullOrEmpty", "s", "valueIfNullOrEmpty", "convertBytesToGB", "bytes", "", "convertJSONArrayToList", "jsonArray", "Lorg/json/JSONArray;", "convertJSONObjectToHashMap", "", "jsonObject", "convertJSONObjectToStringMap", "copyAndCloseInputStream", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "deleteDirectory", "directoryOrFile", "Ljava/io/File;", "disconnectQuietly", "connection", "Ljava/net/URLConnection;", "externalStorageExists", "filter", TypedValues.AttributesType.S_TARGET, "predicate", "Lcom/facebook/internal/Utility$Predicate;", "generateRandomString", "length", "getActivityName", "getAppName", "getAppVersion", "getBundleLongAsDate", "Ljava/util/Date;", "bundle", SDKConstants.PARAM_KEY, "dateBase", "getContentSize", "contentUri", "getCurrentTokenDomainWithDefault", "getGraphDomainFromTokenDomain", "tokenGraphDomain", "getGraphMeRequestWithCache", "Lcom/facebook/GraphRequest;", "getGraphMeRequestWithCacheAsync", "callback", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "getMetadataApplicationId", "getMethodQuietly", "Ljava/lang/reflect/Method;", "clazz", "Ljava/lang/Class;", "methodName", "parameterTypes", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getProfileFieldsForGraphDomain", SDKConstants.PARAM_GRAPH_DOMAIN, "getStringPropertyAsJSON", "nonJSONPropertyKey", "getUriString", ShareConstants.MEDIA_URI, "handlePermissionResponse", "Lcom/facebook/internal/Utility$PermissionsLists;", "result", "hasSameId", "hashBytes", "hash", "Ljava/security/MessageDigest;", "", "hashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "([Ljava/lang/Object;)Ljava/util/HashSet;", "hashWithAlgorithm", "algorithm", "intersectRanges", "", "range1", "range2", "invokeMethodQuietly", "receiver", FirebaseAnalytics.Param.METHOD, "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "isAutofillAvailable", "isChromeOS", "isContentUri", "isCurrentAccessToken", "token", "Lcom/facebook/AccessToken;", "isFileUri", "isNullOrEmpty", "c", "", "isSubset", "subset", "superset", "isWebUri", "jsonArrayToSet", "", "jsonArrayToStringList", "jsonStrToMap", "str", "logd", ViewHierarchyConstants.TAG_KEY, "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", NotificationCompat.CATEGORY_MESSAGE, "t", "", "map", "K", "mapper", "Lcom/facebook/internal/Utility$Mapper;", "mapToJsonStr", "md5hash", "mustFixWindowParamsForAutofill", "parseUrlQueryString", "queryString", "putCommaSeparatedStringList", "list", "putJSONValueInBundle", "value", "putNonEmptyString", "putUri", "readStreamToString", "readStringMapFromParcel", "parcel", "Landroid/os/Parcel;", "refreshAvailableExternalStorage", "refreshBestGuessNumberOfCPUCores", "refreshCarrierName", "appContext", "refreshPeriodicExtendedDeviceInfo", "refreshTimezone", "refreshTotalExternalStorage", "runOnNonUiThread", "runnable", "Ljava/lang/Runnable;", "safeGetStringFromResponse", "response", "propertyName", "setAppEventAttributionParameters", NativeProtocol.WEB_DIALOG_PARAMS, "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "limitEventUsage", "setAppEventExtendedDeviceInfoParameters", "sha1hash", "sha256hash", "stringsEqualOrEmpty", "tryGetJSONArrayFromResponse", "propertyKey", "tryGetJSONObjectFromResponse", "unmodifiableCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "writeStringMapToParcel", "GraphMeRequestWithCacheCallback", "Mapper", "PermissionsLists", "Predicate", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Utility {
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final String FACEBOOK_PROFILE_FIELDS = "id,name,first_name,middle_name,last_name";
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";
    private static final String INSTAGRAM_PROFILE_FIELDS = "id,name,profile_picture";
    public static final String LOG_TAG = "FacebookSDK";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static int numCPUCores;
    public static final Utility INSTANCE = new Utility();
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;
    private static long availableExternalStorageGB = -1;
    private static String deviceTimezoneAbbreviation = "";
    private static String deviceTimeZoneName = "";
    private static final String NO_CARRIER = "NoCarrier";
    private static String carrierName = NO_CARRIER;

    /* compiled from: Utility.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "", "onFailure", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException error);

        void onSuccess(JSONObject userInfo);
    }

    /* compiled from: Utility.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/Utility$Mapper;", ExifInterface.GPS_DIRECTION_TRUE, "K", "", "apply", "item", "(Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface Mapper<T, K> {
        K apply(T item);
    }

    /* compiled from: Utility.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/Utility$Predicate;", ExifInterface.GPS_DIRECTION_TRUE, "", "apply", "", "item", "(Ljava/lang/Object;)Z", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface Predicate<T> {
        boolean apply(T item);
    }

    @JvmStatic
    public static /* synthetic */ void isAutoAppLinkSetup$annotations() {
    }

    private Utility() {
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x000e A[SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int[] intersectRanges(int[] range1, int[] range2) {
        if (range1 == null) {
            return range2;
        }
        if (range2 == null) {
            return range1;
        }
        int[] iArr = new int[range1.length + range2.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i >= range1.length || i2 >= range2.length) {
                break;
            }
            int i4 = range1[i];
            int i5 = range2[i2];
            int i6 = i < range1.length + (-1) ? range1[i + 1] : Integer.MAX_VALUE;
            int i7 = i2 < range2.length + (-1) ? range2[i2 + 1] : Integer.MAX_VALUE;
            if (i4 < i5) {
                if (i6 <= i5) {
                    i += 2;
                    i6 = Integer.MAX_VALUE;
                    i4 = Integer.MIN_VALUE;
                    if (i4 == Integer.MIN_VALUE) {
                    }
                } else if (i6 > i7) {
                    i2 += 2;
                    i4 = i5;
                    i6 = i7;
                    if (i4 == Integer.MIN_VALUE) {
                        int i8 = i3 + 1;
                        iArr[i3] = i4;
                        if (i6 == Integer.MAX_VALUE) {
                            i3 = i8;
                            break;
                        }
                        i3 = i8 + 1;
                        iArr[i8] = i6;
                    }
                } else {
                    i += 2;
                    i4 = i5;
                    if (i4 == Integer.MIN_VALUE) {
                    }
                }
            } else if (i7 <= i4) {
                i2 += 2;
                i6 = Integer.MAX_VALUE;
                i4 = Integer.MIN_VALUE;
                if (i4 == Integer.MIN_VALUE) {
                }
            } else if (i7 > i6) {
                i += 2;
                if (i4 == Integer.MIN_VALUE) {
                }
            } else {
                i2 += 2;
                i6 = i7;
                if (i4 == Integer.MIN_VALUE) {
                }
            }
        }
        return Arrays.copyOf(iArr, i3);
    }

    @JvmStatic
    public static final <T> boolean isSubset(Collection<? extends T> subset, Collection<? extends T> superset) {
        if (superset == null || superset.isEmpty()) {
            return subset == null || subset.isEmpty();
        }
        HashSet hashSet = new HashSet(superset);
        if (subset != null) {
            Iterator<? extends T> it = subset.iterator();
            while (it.hasNext()) {
                if (!hashSet.contains(it.next())) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @JvmStatic
    public static final <T> boolean isNullOrEmpty(Collection<? extends T> c) {
        return c == null || c.isEmpty();
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(String s) {
        if (s != null) {
            if (!(s.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final String coerceValueIfNullOrEmpty(String s, String valueIfNullOrEmpty) {
        return isNullOrEmpty(s) ? valueIfNullOrEmpty : s;
    }

    @JvmStatic
    public static final <T> Collection<T> unmodifiableCollection(T... ts) {
        Intrinsics.checkNotNullParameter(ts, "ts");
        Collection<T> collectionUnmodifiableCollection = Collections.unmodifiableCollection(Arrays.asList(Arrays.copyOf(ts, ts.length)));
        Intrinsics.checkNotNullExpressionValue(collectionUnmodifiableCollection, "Collections.unmodifiable…ction(Arrays.asList(*ts))");
        return collectionUnmodifiableCollection;
    }

    @JvmStatic
    public static final <T> ArrayList<T> arrayList(T... ts) {
        Intrinsics.checkNotNullParameter(ts, "ts");
        ArrayList<T> arrayList = new ArrayList<>(ts.length);
        for (T t : ts) {
            arrayList.add(t);
        }
        return arrayList;
    }

    @JvmStatic
    public static final <T> HashSet<T> hashSet(T... ts) {
        Intrinsics.checkNotNullParameter(ts, "ts");
        HashSet<T> hashSet = new HashSet<>(ts.length);
        for (T t : ts) {
            hashSet.add(t);
        }
        return hashSet;
    }

    @JvmStatic
    public static final String md5hash(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_MD5, key);
    }

    @JvmStatic
    public static final String sha1hash(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA1, key);
    }

    @JvmStatic
    public static final String sha1hash(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA1, bytes);
    }

    @JvmStatic
    public static final String sha256hash(String key) {
        if (key == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA256, key);
    }

    @JvmStatic
    public static final String sha256hash(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA256, bytes);
    }

    private final String hashWithAlgorithm(String algorithm, String key) {
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(key, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = key.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return hashWithAlgorithm(algorithm, bytes);
    }

    private final String hashWithAlgorithm(String algorithm, byte[] bytes) throws NoSuchAlgorithmException {
        try {
            MessageDigest hash = MessageDigest.getInstance(algorithm);
            Intrinsics.checkNotNullExpressionValue(hash, "hash");
            return hashBytes(hash, bytes);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private final String hashBytes(MessageDigest hash, byte[] bytes) {
        hash.update(bytes);
        byte[] bArrDigest = hash.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString((b >> 0) & 15));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }

    @JvmStatic
    public static final Uri buildUri(String authority, String path, Bundle parameters) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(URL_SCHEME);
        builder.authority(authority);
        builder.path(path);
        if (parameters != null) {
            for (String str : parameters.keySet()) {
                Object obj = parameters.get(str);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str, (String) obj);
                }
            }
        }
        Uri uriBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "builder.build()");
        return uriBuild;
    }

    @JvmStatic
    public static final Bundle parseUrlQueryString(String queryString) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(queryString)) {
            if (queryString == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Object[] array = StringsKt.split$default((CharSequence) queryString, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            for (String str : (String[]) array) {
                Object[] array2 = StringsKt.split$default((CharSequence) str, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr = (String[]) array2;
                try {
                    if (strArr.length == 2) {
                        bundle.putString(URLDecoder.decode(strArr[0], "UTF-8"), URLDecoder.decode(strArr[1], "UTF-8"));
                    } else if (strArr.length == 1) {
                        bundle.putString(URLDecoder.decode(strArr[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e) {
                    logd(LOG_TAG, e);
                }
            }
        }
        return bundle;
    }

    @JvmStatic
    public static final void putNonEmptyString(Bundle b, String key, String value) {
        Intrinsics.checkNotNullParameter(b, "b");
        if (isNullOrEmpty(value)) {
            return;
        }
        b.putString(key, value);
    }

    @JvmStatic
    public static final void putCommaSeparatedStringList(Bundle b, String key, List<String> list) {
        Intrinsics.checkNotNullParameter(b, "b");
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            b.putString(key, sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "");
        }
    }

    @JvmStatic
    public static final void putUri(Bundle b, String key, Uri uri) {
        Intrinsics.checkNotNullParameter(b, "b");
        if (uri != null) {
            putNonEmptyString(b, key, uri.toString());
        }
    }

    @JvmStatic
    public static final boolean putJSONValueInBundle(Bundle bundle, String key, Object value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (value == null) {
            bundle.remove(key);
            return true;
        }
        if (value instanceof Boolean) {
            bundle.putBoolean(key, ((Boolean) value).booleanValue());
            return true;
        }
        if (value instanceof boolean[]) {
            bundle.putBooleanArray(key, (boolean[]) value);
            return true;
        }
        if (value instanceof Double) {
            bundle.putDouble(key, ((Number) value).doubleValue());
            return true;
        }
        if (value instanceof double[]) {
            bundle.putDoubleArray(key, (double[]) value);
            return true;
        }
        if (value instanceof Integer) {
            bundle.putInt(key, ((Number) value).intValue());
            return true;
        }
        if (value instanceof int[]) {
            bundle.putIntArray(key, (int[]) value);
            return true;
        }
        if (value instanceof Long) {
            bundle.putLong(key, ((Number) value).longValue());
            return true;
        }
        if (value instanceof long[]) {
            bundle.putLongArray(key, (long[]) value);
            return true;
        }
        if (value instanceof String) {
            bundle.putString(key, (String) value);
            return true;
        }
        if (value instanceof JSONArray) {
            bundle.putString(key, value.toString());
            return true;
        }
        if (!(value instanceof JSONObject)) {
            return false;
        }
        bundle.putString(key, value.toString());
        return true;
    }

    @JvmStatic
    public static final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @JvmStatic
    public static final void disconnectQuietly(URLConnection connection) {
        if (connection == null || !(connection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) connection).disconnect();
    }

    @JvmStatic
    public static final String getMetadataApplicationId(Context context) {
        Validate.notNull(context, "context");
        return FacebookSdk.getApplicationId();
    }

    @JvmStatic
    public static final Map<String, Object> convertJSONObjectToHashMap(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        HashMap map = new HashMap();
        JSONArray jSONArrayNames = jsonObject.names();
        int length = jSONArrayNames.length();
        for (int i = 0; i < length; i++) {
            try {
                String string = jSONArrayNames.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "keys.getString(i)");
                Object value = jsonObject.get(string);
                if (value instanceof JSONObject) {
                    value = convertJSONObjectToHashMap((JSONObject) value);
                }
                Intrinsics.checkNotNullExpressionValue(value, "value");
                map.put(string, value);
            } catch (JSONException unused) {
            }
        }
        return map;
    }

    @JvmStatic
    public static final Map<String, String> convertJSONObjectToStringMap(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        HashMap map = new HashMap();
        Iterator<String> itKeys = jsonObject.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            String strOptString = jsonObject.optString(key);
            if (strOptString != null) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                map.put(key, strOptString);
            }
        }
        return map;
    }

    @JvmStatic
    public static final List<String> convertJSONArrayToList(JSONArray jsonArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                String string = jsonArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                arrayList.add(string);
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    @JvmStatic
    public static final Object getStringPropertyAsJSON(JSONObject jsonObject, String key, String nonJSONPropertyKey) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Object objOpt = jsonObject.opt(key);
        if (objOpt != null && (objOpt instanceof String)) {
            objOpt = new JSONTokener((String) objOpt).nextValue();
        }
        if (objOpt == null || (objOpt instanceof JSONObject) || (objOpt instanceof JSONArray)) {
            return objOpt;
        }
        if (nonJSONPropertyKey != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(nonJSONPropertyKey, objOpt);
            return jSONObject;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    @JvmStatic
    public static final String readStreamToString(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int i = inputStreamReader.read(cArr);
                        if (i != -1) {
                            sb.append(cArr, 0, i);
                        } else {
                            String string = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            return string;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
        }
    }

    @JvmStatic
    public static final int copyAndCloseInputStream(InputStream inputStream, OutputStream outputStream) throws Throwable {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int i2 = bufferedInputStream2.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, i2);
                    i += i2;
                }
                bufferedInputStream2.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return i;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @JvmStatic
    public static final boolean stringsEqualOrEmpty(String a, String b) {
        String str = a;
        boolean z = str == null || str.length() == 0;
        String str2 = b;
        boolean z2 = str2 == null || str2.length() == 0;
        if (z && z2) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return Intrinsics.areEqual(a, b);
    }

    private final void clearCookiesForDomain(Context context, String domain) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(domain);
        if (cookie != null) {
            Object[] array = StringsKt.split$default((CharSequence) cookie, new String[]{";"}, false, 0, 6, (Object) null).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            for (String str : (String[]) array) {
                Object[] array2 = StringsKt.split$default((CharSequence) str, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr = (String[]) array2;
                if (strArr.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    String str2 = strArr[0];
                    int length = str2.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length) {
                        boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            } else {
                                length--;
                            }
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    sb.append(str2.subSequence(i, length + 1).toString());
                    sb.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                    cookieManager.setCookie(domain, sb.toString());
                }
            }
            cookieManager.removeExpiredCookie();
        }
    }

    @JvmStatic
    public static final void clearFacebookCookies(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Utility utility = INSTANCE;
        utility.clearCookiesForDomain(context, FacebookSdk.FACEBOOK_COM);
        utility.clearCookiesForDomain(context, ".facebook.com");
        utility.clearCookiesForDomain(context, "https://facebook.com");
        utility.clearCookiesForDomain(context, "https://.facebook.com");
    }

    @JvmStatic
    public static final void logd(String tag, Exception e) {
        if (!FacebookSdk.isDebugEnabled() || tag == null || e == null) {
            return;
        }
        Log.d(tag, e.getClass().getSimpleName() + ": " + e.getMessage());
    }

    @JvmStatic
    public static final void logd(String tag, String msg) {
        if (!FacebookSdk.isDebugEnabled() || tag == null || msg == null) {
            return;
        }
        Log.d(tag, msg);
    }

    @JvmStatic
    public static final void logd(String tag, String msg, Throwable t) {
        if (!FacebookSdk.isDebugEnabled() || isNullOrEmpty(tag)) {
            return;
        }
        Log.d(tag, msg, t);
    }

    @JvmStatic
    public static final <T> boolean areObjectsEqual(T a, T b) {
        if (a == null) {
            return b == null;
        }
        return Intrinsics.areEqual(a, b);
    }

    @JvmStatic
    public static final boolean hasSameId(JSONObject a, JSONObject b) {
        if (a == null || b == null || !a.has("id") || !b.has("id")) {
            return false;
        }
        if (Intrinsics.areEqual(a, b)) {
            return true;
        }
        String strOptString = a.optString("id");
        String strOptString2 = b.optString("id");
        if (strOptString == null || strOptString2 == null) {
            return false;
        }
        return Intrinsics.areEqual(strOptString, strOptString2);
    }

    @JvmStatic
    public static final String safeGetStringFromResponse(JSONObject response, String propertyName) {
        if (response == null) {
            return "";
        }
        String strOptString = response.optString(propertyName, "");
        Intrinsics.checkNotNullExpressionValue(strOptString, "response.optString(propertyName, \"\")");
        return strOptString;
    }

    @JvmStatic
    public static final JSONObject tryGetJSONObjectFromResponse(JSONObject response, String propertyKey) {
        if (response != null) {
            return response.optJSONObject(propertyKey);
        }
        return null;
    }

    @JvmStatic
    public static final JSONArray tryGetJSONArrayFromResponse(JSONObject response, String propertyKey) {
        if (response != null) {
            return response.optJSONArray(propertyKey);
        }
        return null;
    }

    @JvmStatic
    public static final void clearCaches() {
        ImageDownloader.clearCache();
    }

    @JvmStatic
    public static final void deleteDirectory(File directoryOrFile) {
        File[] fileArrListFiles;
        if (directoryOrFile == null || !directoryOrFile.exists()) {
            return;
        }
        if (directoryOrFile.isDirectory() && (fileArrListFiles = directoryOrFile.listFiles()) != null) {
            for (File file : fileArrListFiles) {
                deleteDirectory(file);
            }
        }
        directoryOrFile.delete();
    }

    @JvmStatic
    public static final <T> List<T> asListNoNulls(T... array) {
        Intrinsics.checkNotNullParameter(array, "array");
        ArrayList arrayList = new ArrayList();
        for (T t : array) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final List<String> jsonArrayToStringList(JSONArray jsonArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jsonArray.getString(i));
        }
        return arrayList;
    }

    @JvmStatic
    public static final Set<String> jsonArrayToSet(JSONArray jsonArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        HashSet hashSet = new HashSet();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            String string = jsonArray.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
            hashSet.add(string);
        }
        return hashSet;
    }

    @JvmStatic
    public static final String mapToJsonStr(Map<String, String> map) throws JSONException {
        Intrinsics.checkNotNullParameter(map, "map");
        String string = "";
        if (!map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                string = jSONObject.toString();
            } catch (JSONException unused) {
            }
            Intrinsics.checkNotNullExpressionValue(string, "try {\n        val jsonOb…ion) {\n        \"\"\n      }");
        }
        return string;
    }

    @JvmStatic
    public static final Map<String, String> jsonStrToMap(String str) throws JSONException {
        Intrinsics.checkNotNullParameter(str, "str");
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String key = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                String string = jSONObject.getString(key);
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
                map.put(key, string);
            }
            return map;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    @JvmStatic
    public static final void setAppEventAttributionParameters(JSONObject params, AttributionIdentifiers attributionIdentifiers, String anonymousAppDeviceGUID, boolean limitEventUsage) throws JSONException {
        Intrinsics.checkNotNullParameter(params, "params");
        params.put("anon_id", anonymousAppDeviceGUID);
        params.put("application_tracking_enabled", !limitEventUsage);
        params.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if (attributionIdentifiers != null) {
            if (attributionIdentifiers.getAttributionId() != null) {
                params.put("attribution", attributionIdentifiers.getAttributionId());
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                params.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                params.put("advertiser_tracking_enabled", !attributionIdentifiers.getIsTrackingLimited());
            }
            if (!attributionIdentifiers.getIsTrackingLimited()) {
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                if (!(allHashedUserData.length() == 0)) {
                    params.put("ud", allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                params.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
    }

    @JvmStatic
    public static final String getAppVersion() throws PackageManager.NameNotFoundException {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext != null) {
            try {
                PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    @JvmStatic
    public static final void setAppEventExtendedDeviceInfoParameters(JSONObject params, Context appContext) throws JSONException, PackageManager.NameNotFoundException {
        String str;
        Locale locale;
        int i;
        Display defaultDisplay;
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        INSTANCE.refreshPeriodicExtendedDeviceInfo(appContext);
        String packageName = appContext.getPackageName();
        int i2 = 0;
        int i3 = -1;
        try {
            packageInfo = appContext.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            str = "";
        }
        if (packageInfo != null) {
            i3 = packageInfo.versionCode;
            str = packageInfo.versionName;
            jSONArray.put(packageName);
            jSONArray.put(i3);
            jSONArray.put(str);
            jSONArray.put(Build.VERSION.RELEASE);
            jSONArray.put(Build.MODEL);
            try {
                Resources resources = appContext.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "appContext.resources");
                locale = resources.getConfiguration().locale;
            } catch (Exception unused2) {
                locale = Locale.getDefault();
            }
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(locale, "locale");
            sb.append(locale.getLanguage());
            sb.append("_");
            sb.append(locale.getCountry());
            jSONArray.put(sb.toString());
            jSONArray.put(deviceTimezoneAbbreviation);
            jSONArray.put(carrierName);
            double d = 0.0d;
            try {
                defaultDisplay = null;
                if (Build.VERSION.SDK_INT >= 17) {
                    Object systemService = appContext.getSystemService("display");
                    if (!(systemService instanceof DisplayManager)) {
                        systemService = null;
                    }
                    DisplayManager displayManager = (DisplayManager) systemService;
                    if (displayManager != null) {
                        defaultDisplay = displayManager.getDisplay(0);
                    }
                } else {
                    Object systemService2 = appContext.getSystemService("window");
                    if (!(systemService2 instanceof WindowManager)) {
                        systemService2 = null;
                    }
                    WindowManager windowManager = (WindowManager) systemService2;
                    if (windowManager != null) {
                        defaultDisplay = windowManager.getDefaultDisplay();
                    }
                }
            } catch (Exception unused3) {
            }
            if (defaultDisplay != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                int i4 = displayMetrics.widthPixels;
                try {
                    i2 = displayMetrics.heightPixels;
                    d = displayMetrics.density;
                } catch (Exception unused4) {
                }
                i = i2;
                i2 = i4;
            } else {
                i = 0;
            }
            jSONArray.put(i2);
            jSONArray.put(i);
            jSONArray.put(new DecimalFormat("#.##").format(d));
            jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
            jSONArray.put(totalExternalStorageGB);
            jSONArray.put(availableExternalStorageGB);
            jSONArray.put(deviceTimeZoneName);
            params.put(Constants.EXTINFO, jSONArray.toString());
        }
    }

    @JvmStatic
    public static final Method getMethodQuietly(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            return clazz.getMethod(methodName, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Method getMethodQuietly(String className, String methodName, Class<?>... parameterTypes) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            Class<?> cls = Class.forName(className);
            Intrinsics.checkNotNullExpressionValue(cls, "Class.forName(className)");
            return getMethodQuietly(cls, methodName, (Class<?>[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Object invokeMethodQuietly(Object receiver, Method method, Object... args) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            return method.invoke(receiver, Arrays.copyOf(args, args.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final String getActivityName(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "context.javaClass.simpleName");
        return simpleName;
    }

    @JvmStatic
    public static final <T> List<T> filter(List<? extends T> target, Predicate<T> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (target == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : target) {
            if (predicate.apply(t)) {
                arrayList.add(t);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @JvmStatic
    public static final <T, K> List<K> map(List<? extends T> target, Mapper<T, K> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        if (target == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = target.iterator();
        while (it.hasNext()) {
            K kApply = mapper.apply(it.next());
            if (kApply != null) {
                arrayList.add(kApply);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @JvmStatic
    public static final String getUriString(Uri uri) {
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    @JvmStatic
    public static final boolean isWebUri(Uri uri) {
        return uri != null && (StringsKt.equals(HttpHost.DEFAULT_SCHEME_NAME, uri.getScheme(), true) || StringsKt.equals(URL_SCHEME, uri.getScheme(), true) || StringsKt.equals("fbstaging", uri.getScheme(), true));
    }

    @JvmStatic
    public static final boolean isContentUri(Uri uri) {
        return uri != null && StringsKt.equals(FirebaseAnalytics.Param.CONTENT, uri.getScheme(), true);
    }

    @JvmStatic
    public static final boolean isFileUri(Uri uri) {
        return uri != null && StringsKt.equals("file", uri.getScheme(), true);
    }

    @JvmStatic
    public static final long getContentSize(Uri contentUri) {
        Intrinsics.checkNotNullParameter(contentUri, "contentUri");
        Cursor cursorQuery = null;
        try {
            cursorQuery = FacebookSdk.getApplicationContext().getContentResolver().query(contentUri, null, null, null, null);
            if (cursorQuery == null) {
                return 0L;
            }
            int columnIndex = cursorQuery.getColumnIndex("_size");
            cursorQuery.moveToFirst();
            long j = cursorQuery.getLong(columnIndex);
            cursorQuery.close();
            return j;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    @JvmStatic
    public static final Date getBundleLongAsDate(Bundle bundle, String key, Date dateBase) throws NumberFormatException {
        long jLongValue;
        Intrinsics.checkNotNullParameter(dateBase, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(key);
        if (obj instanceof Long) {
            jLongValue = ((Number) obj).longValue();
        } else {
            if (obj instanceof String) {
                try {
                    jLongValue = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        if (jLongValue == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(dateBase.getTime() + (jLongValue * 1000));
    }

    @JvmStatic
    public static final void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    @JvmStatic
    public static final Map<String, String> readStringMapFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i = parcel.readInt();
        if (i < 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            map.put(parcel.readString(), parcel.readString());
        }
        return map;
    }

    @JvmStatic
    public static final boolean isCurrentAccessToken(AccessToken token) {
        return token != null && Intrinsics.areEqual(token, AccessToken.INSTANCE.getCurrentAccessToken());
    }

    @JvmStatic
    public static final String getGraphDomainFromTokenDomain(String tokenGraphDomain) {
        String facebookDomain = FacebookSdk.getFacebookDomain();
        if (tokenGraphDomain == null) {
            return facebookDomain;
        }
        int iHashCode = tokenGraphDomain.hashCode();
        return iHashCode != -1253231569 ? (iHashCode == 28903346 && tokenGraphDomain.equals(FacebookSdk.INSTAGRAM)) ? StringsKt.replace$default(facebookDomain, FacebookSdk.FACEBOOK_COM, FacebookSdk.INSTAGRAM_COM, false, 4, (Object) null) : facebookDomain : tokenGraphDomain.equals(FacebookSdk.GAMING) ? StringsKt.replace$default(facebookDomain, FacebookSdk.FACEBOOK_COM, FacebookSdk.FB_GG, false, 4, (Object) null) : facebookDomain;
    }

    @JvmStatic
    public static final void getGraphMeRequestWithCacheAsync(final String accessToken, final GraphMeRequestWithCacheCallback callback) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(accessToken);
        if (profileInformation != null) {
            callback.onSuccess(profileInformation);
            return;
        }
        GraphRequest.Callback callback2 = new GraphRequest.Callback() { // from class: com.facebook.internal.Utility$getGraphMeRequestWithCacheAsync$graphCallback$1
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.getError() != null) {
                    callback.onFailure(response.getError().getException());
                    return;
                }
                String str = accessToken;
                JSONObject jsonObject = response.getJsonObject();
                if (jsonObject == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                ProfileInformationCache.putProfileInformation(str, jsonObject);
                callback.onSuccess(response.getJsonObject());
            }
        };
        GraphRequest graphMeRequestWithCache = INSTANCE.getGraphMeRequestWithCache(accessToken);
        graphMeRequestWithCache.setCallback(callback2);
        graphMeRequestWithCache.executeAsync();
    }

    @JvmStatic
    public static final JSONObject awaitGetGraphMeRequestWithCache(String accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(accessToken);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse graphResponseExecuteAndWait = INSTANCE.getGraphMeRequestWithCache(accessToken).executeAndWait();
        if (graphResponseExecuteAndWait.getError() != null) {
            return null;
        }
        return graphResponseExecuteAndWait.getJsonObject();
    }

    private final GraphRequest getGraphMeRequestWithCache(String accessToken) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, getProfileFieldsForGraphDomain(getCurrentTokenDomainWithDefault()));
        bundle.putString("access_token", accessToken);
        return new GraphRequest(null, "me", bundle, HttpMethod.GET, null, null, 32, null);
    }

    private final String getProfileFieldsForGraphDomain(String graphDomain) {
        return Intrinsics.areEqual(graphDomain, FacebookSdk.INSTAGRAM) ? INSTAGRAM_PROFILE_FIELDS : FACEBOOK_PROFILE_FIELDS;
    }

    private final String getCurrentTokenDomainWithDefault() {
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        return (currentAccessToken == null || currentAccessToken.getGraphDomain() == null) ? AccessToken.DEFAULT_GRAPH_DOMAIN : currentAccessToken.getGraphDomain();
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        int i = numCPUCores;
        if (i > 0) {
            return i;
        }
        try {
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: com.facebook.internal.Utility$refreshBestGuessNumberOfCPUCores$cpuFiles$1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    return Pattern.matches("cpu[0-9]+", str);
                }
            });
            if (fileArrListFiles != null) {
                numCPUCores = fileArrListFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context appContext) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(appContext);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private final void refreshTimezone() {
        try {
            TimeZone tz = TimeZone.getDefault();
            String displayName = tz.getDisplayName(tz.inDaylightTime(new Date()), 0);
            Intrinsics.checkNotNullExpressionValue(displayName, "tz.getDisplayName(tz.inD…(Date()), TimeZone.SHORT)");
            deviceTimezoneAbbreviation = displayName;
            Intrinsics.checkNotNullExpressionValue(tz, "tz");
            String id = tz.getID();
            Intrinsics.checkNotNullExpressionValue(id, "tz.id");
            deviceTimeZoneName = id;
        } catch (AssertionError | Exception unused) {
        }
    }

    private final void refreshCarrierName(Context appContext) {
        if (Intrinsics.areEqual(carrierName, NO_CARRIER)) {
            try {
                Object systemService = appContext.getSystemService("phone");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
                }
                String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                Intrinsics.checkNotNullExpressionValue(networkOperatorName, "telephonyManager.networkOperatorName");
                carrierName = networkOperatorName;
            } catch (Exception unused) {
            }
        }
    }

    private final boolean externalStorageExists() {
        return Intrinsics.areEqual("mounted", Environment.getExternalStorageState());
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                File path = Environment.getExternalStorageDirectory();
                Intrinsics.checkNotNullExpressionValue(path, "path");
                StatFs statFs = new StatFs(path.getPath());
                availableExternalStorageGB = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                File path = Environment.getExternalStorageDirectory();
                Intrinsics.checkNotNullExpressionValue(path, "path");
                StatFs statFs = new StatFs(path.getPath());
                totalExternalStorageGB = statFs.getBlockCount() * statFs.getBlockSize();
            }
            totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final long convertBytesToGB(double bytes) {
        return Math.round(bytes / 1.073741824E9d);
    }

    @JvmStatic
    public static final PermissionsLists handlePermissionResponse(JSONObject result) throws JSONException {
        String strOptString;
        Intrinsics.checkNotNullParameter(result, "result");
        JSONArray jSONArray = result.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        ArrayList arrayList3 = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            String strOptString2 = jSONObjectOptJSONObject.optString("permission");
            if (strOptString2 != null && !Intrinsics.areEqual(strOptString2, "installed") && (strOptString = jSONObjectOptJSONObject.optString("status")) != null) {
                if (Intrinsics.areEqual(strOptString, "granted")) {
                    arrayList.add(strOptString2);
                } else if (Intrinsics.areEqual(strOptString, "declined")) {
                    arrayList2.add(strOptString2);
                } else if (Intrinsics.areEqual(strOptString, "expired")) {
                    arrayList3.add(strOptString2);
                }
            }
        }
        return new PermissionsLists(arrayList, arrayList2, arrayList3);
    }

    @JvmStatic
    public static final String generateRandomString(int length) {
        String string = new BigInteger(length * 5, new Random()).toString(32);
        Intrinsics.checkNotNullExpressionValue(string, "BigInteger(length * 5, r).toString(32)");
        return string;
    }

    @JvmStatic
    public static final boolean mustFixWindowParamsForAutofill(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isAutofillAvailable(context);
    }

    @JvmStatic
    public static final boolean isAutofillAvailable(Context context) {
        AutofillManager autofillManager;
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled();
    }

    @JvmStatic
    public static final boolean isChromeOS(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        if (Build.DEVICE != null) {
            String str = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(str, "Build.DEVICE");
            if (new Regex(ARC_DEVICE_PATTERN).matches(str)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final Locale getResourceLocale() {
        try {
            Resources resources = FacebookSdk.getApplicationContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "FacebookSdk.getApplicationContext().resources");
            return resources.getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale != null) {
            return resourceLocale;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        return locale;
    }

    @JvmStatic
    public static final void runOnNonUiThread(Runnable runnable) {
        try {
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final String getAppName(Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringId)");
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(str));
            Context applicationContext = FacebookSdk.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(packageName, it.next().activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @JvmStatic
    public static final JSONObject getDataProcessingOptions() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return null;
        }
        try {
            String string = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.DATA_PROCESSING_OPTIONS_PREFERENCES, 0).getString(FacebookSdk.DATA_PROCESSION_OPTIONS, null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isDataProcessingRestricted() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return false;
        }
        try {
            JSONObject dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions != null) {
                try {
                    JSONArray jSONArray = dataProcessingOptions.getJSONArray(FacebookSdk.DATA_PROCESSION_OPTIONS);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray.getString(i);
                        Intrinsics.checkNotNullExpressionValue(string, "options.getString(i)");
                        if (string == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase = string.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (Intrinsics.areEqual(lowerCase, "ldu")) {
                            return true;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return false;
        }
    }

    /* compiled from: Utility.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/Utility$PermissionsLists;", "", "grantedPermissions", "", "", SDKConstants.PARAM_DECLINED_PERMISSIONS, SDKConstants.PARAM_EXPIRED_PERMISSIONS, "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDeclinedPermissions", "()Ljava/util/List;", "setDeclinedPermissions", "(Ljava/util/List;)V", "getExpiredPermissions", "setExpiredPermissions", "getGrantedPermissions", "setGrantedPermissions", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class PermissionsLists {
        private List<String> declinedPermissions;
        private List<String> expiredPermissions;
        private List<String> grantedPermissions;

        public PermissionsLists(List<String> grantedPermissions, List<String> declinedPermissions, List<String> expiredPermissions) {
            Intrinsics.checkNotNullParameter(grantedPermissions, "grantedPermissions");
            Intrinsics.checkNotNullParameter(declinedPermissions, "declinedPermissions");
            Intrinsics.checkNotNullParameter(expiredPermissions, "expiredPermissions");
            this.grantedPermissions = grantedPermissions;
            this.declinedPermissions = declinedPermissions;
            this.expiredPermissions = expiredPermissions;
        }

        public final List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public final void setGrantedPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.grantedPermissions = list;
        }

        public final List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        public final void setDeclinedPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.declinedPermissions = list;
        }

        public final List<String> getExpiredPermissions() {
            return this.expiredPermissions;
        }

        public final void setExpiredPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.expiredPermissions = list;
        }
    }
}
