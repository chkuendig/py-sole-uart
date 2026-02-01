package com.soletreadmills.sole_v2._manager;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.soletreadmills.sole_v2.MyApplication;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.MainActivity;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MyNotificationManager.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015J(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\n8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/MyNotificationManager;", "", "()V", "myApplication", "Lcom/soletreadmills/sole_v2/MyApplication;", "getMyApplication", "()Lcom/soletreadmills/sole_v2/MyApplication;", "setMyApplication", "(Lcom/soletreadmills/sole_v2/MyApplication;)V", "notificationId", "", "getNotificationId", "()I", "setNotificationId", "(I)V", "createApiWorkerForegroundInfoNotification", "Landroid/app/Notification;", "title", "", "msg", "channelType", "Lcom/soletreadmills/sole_v2/_manager/MyNotificationManager$NotificationChannelIdType;", "createImportanceMaxChannel", "Landroidx/core/app/NotificationChannelCompat;", "notificationChannelIdType", "sendForegroundInfoNotification", "", "type", "message", "service", "Landroid/app/Service;", "sendNotificationFromFcm", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "Companion", "NotificationChannelIdType", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyNotificationManager {
    private static MyNotificationManager instance;
    public MyApplication myApplication;
    private int notificationId = NotificationChannelIdType.values()[NotificationChannelIdType.values().length - 1].getNotificationId() + 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static String KEY_NOTIFICATION_ID = "NOTIFICATION_ID";

    /* compiled from: MyNotificationManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/MyNotificationManager$Companion;", "", "()V", "KEY_NOTIFICATION_ID", "", "getKEY_NOTIFICATION_ID", "()Ljava/lang/String;", "setKEY_NOTIFICATION_ID", "(Ljava/lang/String;)V", "instance", "Lcom/soletreadmills/sole_v2/_manager/MyNotificationManager;", "getInstance", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized MyNotificationManager getInstance() {
            MyNotificationManager myNotificationManager;
            if (MyNotificationManager.instance == null) {
                MyNotificationManager.instance = new MyNotificationManager();
            }
            myNotificationManager = MyNotificationManager.instance;
            Intrinsics.checkNotNull(myNotificationManager);
            return myNotificationManager;
        }

        public final String getKEY_NOTIFICATION_ID() {
            return MyNotificationManager.KEY_NOTIFICATION_ID;
        }

        public final void setKEY_NOTIFICATION_ID(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            MyNotificationManager.KEY_NOTIFICATION_ID = str;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: MyNotificationManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/MyNotificationManager$NotificationChannelIdType;", "", "channelId", "", "notificationId", "", "channelNameStringId", "(Ljava/lang/String;ILjava/lang/String;II)V", "getChannelId", "()Ljava/lang/String;", "getChannelNameStringId", "()I", "getNotificationId", "KEY_DIGIFLY_CID", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NotificationChannelIdType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NotificationChannelIdType[] $VALUES;
        public static final NotificationChannelIdType KEY_DIGIFLY_CID = new NotificationChannelIdType("KEY_DIGIFLY_CID", 0, "digifly_cid", 4, R.string.channel_name_notification);
        private final String channelId;
        private final int channelNameStringId;
        private final int notificationId;

        private static final /* synthetic */ NotificationChannelIdType[] $values() {
            return new NotificationChannelIdType[]{KEY_DIGIFLY_CID};
        }

        public static EnumEntries<NotificationChannelIdType> getEntries() {
            return $ENTRIES;
        }

        public static NotificationChannelIdType valueOf(String str) {
            return (NotificationChannelIdType) Enum.valueOf(NotificationChannelIdType.class, str);
        }

        public static NotificationChannelIdType[] values() {
            return (NotificationChannelIdType[]) $VALUES.clone();
        }

        private NotificationChannelIdType(String str, int i, String str2, int i2, int i3) {
            this.channelId = str2;
            this.notificationId = i2;
            this.channelNameStringId = i3;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final int getNotificationId() {
            return this.notificationId;
        }

        public final int getChannelNameStringId() {
            return this.channelNameStringId;
        }

        static {
            NotificationChannelIdType[] notificationChannelIdTypeArr$values = $values();
            $VALUES = notificationChannelIdTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(notificationChannelIdTypeArr$values);
        }
    }

    public final MyApplication getMyApplication() {
        MyApplication myApplication = this.myApplication;
        if (myApplication != null) {
            return myApplication;
        }
        Intrinsics.throwUninitializedPropertyAccessException("myApplication");
        return null;
    }

    public final void setMyApplication(MyApplication myApplication) {
        Intrinsics.checkNotNullParameter(myApplication, "<set-?>");
        this.myApplication = myApplication;
    }

    public final void setNotificationId(int i) {
        this.notificationId = i;
    }

    public final synchronized int getNotificationId() {
        int notificationId;
        notificationId = this.notificationId + 1;
        if (notificationId > Integer.MAX_VALUE) {
            notificationId = NotificationChannelIdType.values()[NotificationChannelIdType.values().length - 1].getNotificationId() + 1;
        }
        this.notificationId = notificationId;
        return notificationId;
    }

    public final NotificationChannelCompat createImportanceMaxChannel(NotificationChannelIdType notificationChannelIdType) {
        Intrinsics.checkNotNullParameter(notificationChannelIdType, "notificationChannelIdType");
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(getMyApplication());
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatFrom, "from(...)");
        String channelId = notificationChannelIdType.getChannelId();
        String string = getMyApplication().getString(notificationChannelIdType.getChannelNameStringId());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        NotificationChannelCompat notificationChannelCompatBuild = new NotificationChannelCompat.Builder(channelId, 5).setName(string).build();
        Intrinsics.checkNotNullExpressionValue(notificationChannelCompatBuild, "build(...)");
        notificationManagerCompatFrom.createNotificationChannel(notificationChannelCompatBuild);
        return notificationChannelCompatBuild;
    }

    public static /* synthetic */ Notification createApiWorkerForegroundInfoNotification$default(MyNotificationManager myNotificationManager, String str, String str2, NotificationChannelIdType notificationChannelIdType, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return myNotificationManager.createApiWorkerForegroundInfoNotification(str, str2, notificationChannelIdType);
    }

    public final Notification createApiWorkerForegroundInfoNotification(String title, String msg, NotificationChannelIdType channelType) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(channelType, "channelType");
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(getMyApplication());
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatFrom, "from(...)");
        String channelId = channelType.getChannelId();
        String string = getMyApplication().getString(channelType.getChannelNameStringId());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        NotificationChannelCompat notificationChannelCompatBuild = new NotificationChannelCompat.Builder(channelId, 2).setName(string).build();
        Intrinsics.checkNotNullExpressionValue(notificationChannelCompatBuild, "build(...)");
        notificationManagerCompatFrom.createNotificationChannel(notificationChannelCompatBuild);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getMyApplication(), channelId);
        builder.setContentTitle(title);
        if (msg != null) {
            builder.setContentText(msg);
        }
        builder.setWhen(System.currentTimeMillis());
        builder.setVisibility(0);
        Intent intent = new Intent(getMyApplication(), (Class<?>) MainActivity.class);
        intent.setFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(getMyApplication(), 0, intent, 67108864);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        builder.setContentIntent(activity);
        builder.setAutoCancel(false);
        builder.setOngoing(true);
        Notification notificationBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    public static /* synthetic */ void sendForegroundInfoNotification$default(MyNotificationManager myNotificationManager, NotificationChannelIdType notificationChannelIdType, String str, Service service, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            service = null;
        }
        myNotificationManager.sendForegroundInfoNotification(notificationChannelIdType, str, service);
    }

    public final void sendForegroundInfoNotification(NotificationChannelIdType type, String message, Service service) {
        Intrinsics.checkNotNullParameter(type, "type");
        int notificationId = type.getNotificationId();
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(getMyApplication());
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatFrom, "from(...)");
        String string = getMyApplication().getString(R.string.app_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Notification notificationCreateApiWorkerForegroundInfoNotification = createApiWorkerForegroundInfoNotification(string, message, type);
        if (service != null) {
            if (Build.VERSION.SDK_INT >= 34) {
                if (ContextCompat.checkSelfPermission(getMyApplication(), "android.permission.BLUETOOTH_CONNECT") == 0 || ContextCompat.checkSelfPermission(getMyApplication(), "android.permission.BLUETOOTH_SCAN") == 0) {
                    service.startForeground(notificationId, notificationCreateApiWorkerForegroundInfoNotification, 16);
                    return;
                }
                return;
            }
            service.startForeground(notificationId, notificationCreateApiWorkerForegroundInfoNotification);
            return;
        }
        if (Build.VERSION.SDK_INT < 33 || ActivityCompat.checkSelfPermission(getMyApplication(), "android.permission.POST_NOTIFICATIONS") == 0) {
            notificationManagerCompatFrom.notify(notificationId, notificationCreateApiWorkerForegroundInfoNotification);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void sendNotificationFromFcm(com.google.firebase.messaging.RemoteMessage r20) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.MyNotificationManager.sendNotificationFromFcm(com.google.firebase.messaging.RemoteMessage):void");
    }
}
