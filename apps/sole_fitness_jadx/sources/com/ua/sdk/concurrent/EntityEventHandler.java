package com.ua.sdk.concurrent;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ua.sdk.CreateCallback;
import com.ua.sdk.DeleteCallback;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.MultipleCreateCallback;
import com.ua.sdk.Reference;
import com.ua.sdk.ResetPasswordCallback;
import com.ua.sdk.Resource;
import com.ua.sdk.SaveCallback;
import com.ua.sdk.Ua;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.UploadCallback;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.user.User;
import java.util.List;

/* loaded from: classes2.dex */
public class EntityEventHandler extends Handler {
    private static final EntityEventHandler HANDLER = new EntityEventHandler();
    private static final int ON_CREATED = 0;
    private static final int ON_DELETED = 3;
    private static final int ON_FETCHED = 1;
    private static final int ON_LOGIN = 4;
    private static final int ON_LOGOUT = 5;
    private static final int ON_MULTIPLE_CREATED = 10;
    private static final int ON_PAGE_FETCHED = 7;
    private static final int ON_RESET_PASSWORD = 6;
    private static final int ON_SAVED = 2;
    private static final int ON_UPLOAD_PROGRESS = 8;
    private static final int ON_UPLOAD_UPLOADED = 9;

    private EntityEventHandler() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            Precondition.isOnMain();
            switch (message.what) {
                case 0:
                    MessageData messageData = (MessageData) message.obj;
                    ((CreateCallback) messageData.listener).onCreated((Resource) messageData.value, messageData.error);
                    break;
                case 1:
                    MessageData messageData2 = (MessageData) message.obj;
                    ((FetchCallback) messageData2.listener).onFetched((Resource) messageData2.value, messageData2.error);
                    break;
                case 2:
                    MessageData messageData3 = (MessageData) message.obj;
                    ((SaveCallback) messageData3.listener).onSaved((Resource) messageData3.value, messageData3.error);
                    break;
                case 3:
                    MessageData messageData4 = (MessageData) message.obj;
                    ((DeleteCallback) messageData4.listener).onDeleted((Reference) messageData4.value, messageData4.error);
                    break;
                case 4:
                    MessageData messageData5 = (MessageData) message.obj;
                    ((Ua.LoginCallback) messageData5.listener).onLogin((User) messageData5.value, messageData5.error);
                    break;
                case 5:
                    MessageData messageData6 = (MessageData) message.obj;
                    ((Ua.LogoutCallback) messageData6.listener).onLogout(messageData6.error);
                    break;
                case 6:
                    MessageData messageData7 = (MessageData) message.obj;
                    ((ResetPasswordCallback) messageData7.listener).onFetched(messageData7.error);
                    break;
                case 8:
                    MessageData messageData8 = (MessageData) message.obj;
                    ((UploadCallback) messageData8.listener).onProgress(((Long) messageData8.value).longValue());
                    break;
                case 9:
                    MessageData messageData9 = (MessageData) message.obj;
                    ((UploadCallback) messageData9.listener).onUploaded((Resource) messageData9.value, messageData9.error);
                    break;
                case 10:
                    MessageData messageData10 = (MessageData) message.obj;
                    ((MultipleCreateCallback) messageData10.listener).onSynced((List) messageData10.value, messageData10.error);
                    break;
            }
        } catch (Throwable th) {
            UaLog.error("Error handling callback.", th);
        }
    }

    public static <T extends Resource> void callOnSaved(T t, UaException uaException, SaveCallback<T> saveCallback) {
        if (saveCallback == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            saveCallback.onSaved(t, uaException);
        } else {
            EntityEventHandler entityEventHandler = HANDLER;
            entityEventHandler.sendMessage(entityEventHandler.obtainMessage(2, new MessageData(saveCallback, t, uaException)));
        }
    }

    public static <R extends Reference> void callOnDeleted(R r, UaException uaException, DeleteCallback<R> deleteCallback) {
        if (deleteCallback == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            deleteCallback.onDeleted(r, uaException);
        } else {
            EntityEventHandler entityEventHandler = HANDLER;
            entityEventHandler.sendMessage(entityEventHandler.obtainMessage(3, new MessageData(deleteCallback, r, uaException)));
        }
    }

    public static <T extends Resource> void callOnFetched(T t, UaException uaException, FetchCallback<T> fetchCallback) {
        if (fetchCallback == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            fetchCallback.onFetched(t, uaException);
        } else {
            EntityEventHandler entityEventHandler = HANDLER;
            entityEventHandler.sendMessage(entityEventHandler.obtainMessage(1, new MessageData(fetchCallback, t, uaException)));
        }
    }

    public static void callOnLogin(User user, UaException uaException, Ua.LoginCallback loginCallback) {
        if (loginCallback == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            loginCallback.onLogin(user, uaException);
        } else {
            EntityEventHandler entityEventHandler = HANDLER;
            entityEventHandler.sendMessage(entityEventHandler.obtainMessage(4, new MessageData(loginCallback, user, uaException)));
        }
    }

    public static void callOnLogout(UaException uaException, Ua.LogoutCallback logoutCallback) {
        if (logoutCallback == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            logoutCallback.onLogout(uaException);
            return;
        }
        EntityEventHandler entityEventHandler = HANDLER;
        AnonymousClass1 anonymousClass1 = null;
        entityEventHandler.sendMessage(entityEventHandler.obtainMessage(5, new MessageData(logoutCallback, anonymousClass1, uaException)));
    }

    public static <T extends Resource> void callOnCreated(T t, UaException uaException, CreateCallback<T> createCallback) {
        if (createCallback == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            createCallback.onCreated(t, uaException);
        } else {
            EntityEventHandler entityEventHandler = HANDLER;
            entityEventHandler.sendMessage(entityEventHandler.obtainMessage(0, new MessageData(createCallback, t, uaException)));
        }
    }

    public static <T extends Resource> void callOnMultipleCreated(List<T> list, UaException uaException, MultipleCreateCallback<T> multipleCreateCallback) {
        if (multipleCreateCallback == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            multipleCreateCallback.onSynced(list, uaException);
        } else {
            EntityEventHandler entityEventHandler = HANDLER;
            entityEventHandler.sendMessage(entityEventHandler.obtainMessage(10, new MessageData(multipleCreateCallback, list, uaException)));
        }
    }

    public static void callOnResetPassword(UaException uaException, ResetPasswordCallback resetPasswordCallback) {
        if (resetPasswordCallback == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            resetPasswordCallback.onFetched(uaException);
            return;
        }
        EntityEventHandler entityEventHandler = HANDLER;
        AnonymousClass1 anonymousClass1 = null;
        entityEventHandler.sendMessage(entityEventHandler.obtainMessage(6, new MessageData(resetPasswordCallback, anonymousClass1, uaException)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void callOnUploadProgress(long j, UploadCallback uploadCallback) {
        if (uploadCallback == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            uploadCallback.onProgress(j);
        } else {
            EntityEventHandler entityEventHandler = HANDLER;
            entityEventHandler.sendMessage(entityEventHandler.obtainMessage(8, new MessageData(uploadCallback, Long.valueOf(j), null)));
        }
    }

    public static <T extends Resource> void callOnUploadUploaded(T t, UaException uaException, UploadCallback<T> uploadCallback) {
        if (uploadCallback == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            uploadCallback.onUploaded(t, uaException);
        } else {
            EntityEventHandler entityEventHandler = HANDLER;
            entityEventHandler.sendMessage(entityEventHandler.obtainMessage(9, new MessageData(uploadCallback, t, uaException)));
        }
    }

    private static class MessageData {
        final UaException error;
        final Object listener;
        final Object value;

        private MessageData(Object obj, Object obj2, UaException uaException) {
            this.listener = obj;
            this.value = obj2;
            this.error = uaException;
        }
    }
}
