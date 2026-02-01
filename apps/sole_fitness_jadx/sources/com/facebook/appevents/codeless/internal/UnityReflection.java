package com.facebook.appevents.codeless.internal;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* compiled from: UnityReflection.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0007J\f\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/codeless/internal/UnityReflection;", "", "()V", "CAPTURE_VIEW_HIERARCHY_METHOD", "", "EVENT_MAPPING_METHOD", "FB_UNITY_GAME_OBJECT", "TAG", "UNITY_PLAYER_CLASS", "UNITY_SEND_MESSAGE_METHOD", "unityPlayer", "Ljava/lang/Class;", "captureViewHierarchy", "", "getUnityPlayerClass", "sendEventMapping", "eventMapping", "sendMessage", "unityObject", "unityMethod", "message", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UnityReflection {
    private static final String CAPTURE_VIEW_HIERARCHY_METHOD = "CaptureViewHierarchy";
    private static final String EVENT_MAPPING_METHOD = "OnReceiveMapping";
    private static final String FB_UNITY_GAME_OBJECT = "UnityFacebookSDKPlugin";
    public static final UnityReflection INSTANCE = new UnityReflection();
    private static final String TAG = UnityReflection.class.getCanonicalName();
    private static final String UNITY_PLAYER_CLASS = "com.unity3d.player.UnityPlayer";
    private static final String UNITY_SEND_MESSAGE_METHOD = "UnitySendMessage";
    private static Class<?> unityPlayer;

    private UnityReflection() {
    }

    public static final /* synthetic */ Class access$getUnityPlayer$p(UnityReflection unityReflection) {
        Class<?> cls = unityPlayer;
        if (cls == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unityPlayer");
        }
        return cls;
    }

    private final Class<?> getUnityPlayerClass() throws ClassNotFoundException {
        Class<?> cls = Class.forName(UNITY_PLAYER_CLASS);
        Intrinsics.checkNotNullExpressionValue(cls, "Class.forName(UNITY_PLAYER_CLASS)");
        return cls;
    }

    /* compiled from: UnityReflection.kt */
    @Metadata(k = 3, mv = {1, 5, 1})
    /* renamed from: com.facebook.appevents.codeless.internal.UnityReflection$sendMessage$1, reason: invalid class name */
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        AnonymousClass1(UnityReflection unityReflection) {
            super(unityReflection, UnityReflection.class, "unityPlayer", "getUnityPlayer()Ljava/lang/Class;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return UnityReflection.access$getUnityPlayer$p((UnityReflection) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object obj) {
            UnityReflection.unityPlayer = (Class) obj;
        }
    }

    @JvmStatic
    public static final void sendMessage(String unityObject, String unityMethod, String message) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            if (unityPlayer == null) {
                unityPlayer = INSTANCE.getUnityPlayerClass();
            }
            Class<?> cls = unityPlayer;
            if (cls == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unityPlayer");
            }
            Method method = cls.getMethod(UNITY_SEND_MESSAGE_METHOD, String.class, String.class, String.class);
            Intrinsics.checkNotNullExpressionValue(method, "unityPlayer.getMethod(\n …java, String::class.java)");
            Class<?> cls2 = unityPlayer;
            if (cls2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unityPlayer");
            }
            method.invoke(cls2, unityObject, unityMethod, message);
        } catch (Exception e) {
            Log.e(TAG, "Failed to send message to Unity", e);
        }
    }

    @JvmStatic
    public static final void captureViewHierarchy() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        sendMessage(FB_UNITY_GAME_OBJECT, CAPTURE_VIEW_HIERARCHY_METHOD, "");
    }

    @JvmStatic
    public static final void sendEventMapping(String eventMapping) {
        sendMessage(FB_UNITY_GAME_OBJECT, EVENT_MAPPING_METHOD, eventMapping);
    }
}
