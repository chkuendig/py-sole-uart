package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppEventStore.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u0017\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\b\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/AppEventStore;", "", "()V", "PERSISTED_EVENTS_FILENAME", "", "TAG", "persistEvents", "", "accessTokenAppIdPair", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "appEvents", "Lcom/facebook/appevents/SessionEventsState;", "eventsToPersist", "Lcom/facebook/appevents/AppEventCollection;", "readAndClearStore", "Lcom/facebook/appevents/PersistedEvents;", "saveEventsToDisk", "saveEventsToDisk$facebook_core_release", "MovedClassObjectInputStream", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppEventStore {
    public static final AppEventStore INSTANCE = new AppEventStore();
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG;

    static {
        String name = AppEventStore.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "AppEventStore::class.java.name");
        TAG = name;
    }

    private AppEventStore() {
    }

    @JvmStatic
    public static final synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState appEvents) {
        if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
            Intrinsics.checkNotNullParameter(appEvents, "appEvents");
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents andClearStore = readAndClearStore();
            andClearStore.addEvents(accessTokenAppIdPair, appEvents.getEventsToPersist());
            saveEventsToDisk$facebook_core_release(andClearStore);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventStore.class);
        }
    }

    @JvmStatic
    public static final synchronized void persistEvents(AppEventCollection eventsToPersist) {
        if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(eventsToPersist, "eventsToPersist");
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents andClearStore = readAndClearStore();
            for (AccessTokenAppIdPair accessTokenAppIdPair : eventsToPersist.keySet()) {
                SessionEventsState sessionEventsState = eventsToPersist.get(accessTokenAppIdPair);
                if (sessionEventsState == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                andClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
            }
            saveEventsToDisk$facebook_core_release(andClearStore);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventStore.class);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bd A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #2 {all -> 0x00c4, blocks: (B:9:0x000c, B:14:0x003a, B:15:0x003f, B:50:0x00bd, B:18:0x004b, B:29:0x006d, B:30:0x0072, B:33:0x007d, B:34:0x0083, B:36:0x0088, B:37:0x008d, B:41:0x00a1, B:40:0x0098, B:43:0x00a3, B:44:0x00a8, B:47:0x00b3), top: B:63:0x000c, outer: #8, inners: #1, #3, #7, #9 }] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v11, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.content.Context] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized PersistedEvents readAndClearStore() {
        MovedClassObjectInputStream movedClassObjectInputStream;
        String str;
        String str2;
        Exception exc;
        PersistedEvents persistedEvents;
        Object object;
        ?? IsObjectCrashing = CrashShieldHandler.isObjectCrashing(AppEventStore.class);
        if (IsObjectCrashing != 0) {
            return null;
        }
        try {
            try {
                AppEventUtility.assertIsNotMainThread();
                IsObjectCrashing = FacebookSdk.getApplicationContext();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, AppEventStore.class);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            FileInputStream fileInputStreamOpenFileInput = IsObjectCrashing.openFileInput(PERSISTED_EVENTS_FILENAME);
            Intrinsics.checkNotNullExpressionValue(fileInputStreamOpenFileInput, "context.openFileInput(PERSISTED_EVENTS_FILENAME)");
            movedClassObjectInputStream = new MovedClassObjectInputStream(new BufferedInputStream(fileInputStreamOpenFileInput));
            try {
                object = movedClassObjectInputStream.readObject();
            } catch (FileNotFoundException unused) {
                Utility.closeQuietly(movedClassObjectInputStream);
                try {
                    IsObjectCrashing.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                } catch (Exception e) {
                    str = TAG;
                    str2 = "Got unexpected exception when removing events file: ";
                    exc = e;
                    Log.w(str, str2, exc);
                    persistedEvents = null;
                    if (persistedEvents == null) {
                    }
                    return persistedEvents;
                }
                persistedEvents = null;
                if (persistedEvents == null) {
                }
                return persistedEvents;
            } catch (Exception e2) {
                e = e2;
                Log.w(TAG, "Got unexpected exception while reading events: ", e);
                Utility.closeQuietly(movedClassObjectInputStream);
                try {
                    IsObjectCrashing.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                } catch (Exception e3) {
                    str = TAG;
                    str2 = "Got unexpected exception when removing events file: ";
                    exc = e3;
                    Log.w(str, str2, exc);
                    persistedEvents = null;
                    if (persistedEvents == null) {
                    }
                    return persistedEvents;
                }
                persistedEvents = null;
                if (persistedEvents == null) {
                }
                return persistedEvents;
            }
        } catch (FileNotFoundException unused2) {
            movedClassObjectInputStream = null;
        } catch (Exception e4) {
            e = e4;
            movedClassObjectInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            Utility.closeQuietly((Closeable) null);
            try {
                IsObjectCrashing.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
            } catch (Exception e5) {
                Log.w(TAG, "Got unexpected exception when removing events file: ", e5);
            }
            throw th;
        }
        if (object == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.PersistedEvents");
        }
        persistedEvents = (PersistedEvents) object;
        Utility.closeQuietly(movedClassObjectInputStream);
        try {
            IsObjectCrashing.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
        } catch (Exception e6) {
            Log.w(TAG, "Got unexpected exception when removing events file: ", e6);
        }
        if (persistedEvents == null) {
            persistedEvents = new PersistedEvents();
        }
        return persistedEvents;
    }

    @JvmStatic
    public static final void saveEventsToDisk$facebook_core_release(PersistedEvents eventsToPersist) {
        ObjectOutputStream objectOutputStream;
        if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
            return;
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            try {
                objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeObject(eventsToPersist);
                Utility.closeQuietly(objectOutputStream);
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                try {
                    Log.w(TAG, "Got unexpected exception while persisting events: ", th);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception unused) {
                    }
                } finally {
                    Utility.closeQuietly(objectOutputStream2);
                }
            }
        } catch (Throwable th3) {
            CrashShieldHandler.handleThrowable(th3, AppEventStore.class);
        }
    }

    /* compiled from: AppEventStore.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";

        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
            ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
            Intrinsics.checkNotNullExpressionValue(resultClassDescriptor, "resultClassDescriptor");
            if (Intrinsics.areEqual(resultClassDescriptor.getName(), ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (Intrinsics.areEqual(resultClassDescriptor.getName(), APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            Intrinsics.checkNotNullExpressionValue(resultClassDescriptor, "resultClassDescriptor");
            return resultClassDescriptor;
        }
    }
}
