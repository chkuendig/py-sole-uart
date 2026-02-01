package com.dyaco.sole.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.dyaco.sole.BuildConfig;
import com.dyaco.sole.activity.LogoActivity;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.Global;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.soletreadmills.sole.R;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final String INTENT_FILTER = "INTENT_FILTER";
    public static final String NOTIFICATION_ID = "NOTIFICATION_ID";
    public static final String NOTIFICATION_KEY = "NOTIFICATION_KEY";
    private static int id = 2;
    private final String TAG = "MyFirebaseMessagingService";

    /* JADX WARN: Removed duplicated region for block: B:23:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02ce  */
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessageReceived(RemoteMessage remoteMessage) throws JSONException, PackageManager.NameNotFoundException {
        String string;
        String string2;
        PowerManager powerManager;
        PendingIntent activity;
        int i;
        int color;
        Notification notificationBuild;
        int i2;
        String string3;
        String str = "";
        super.onMessageReceived(remoteMessage);
        Log.d(this.TAG, "onMessageReceived -> remoteMessage.getFrom()=" + remoteMessage.getFrom());
        Log.d(this.TAG, "onMessageReceived -> remoteMessage.getData()=" + remoteMessage.getData());
        boolean zIsPackageInstalled = isPackageInstalled("com.android.vending");
        Log.d(this.TAG, "isGooglePlayInstalled=" + zIsPackageInstalled);
        Map<String, String> data = remoteMessage.getData();
        String string4 = getString(R.string.app_name);
        try {
            JSONObject jSONObject = new JSONObject(data);
            string4 = string4 + StringUtils.SPACE + jSONObject.getString("data_title");
            string = jSONObject.getString("data_message");
            try {
                string3 = jSONObject.getString("data_linkkey");
                string2 = jSONObject.getString("message_no");
            } catch (Exception e) {
                e = e;
                string2 = "";
            }
        } catch (Exception e2) {
            e = e2;
            string = "";
            string2 = string;
        }
        try {
            Log.d(this.TAG, "onReceive id=" + id + " | data_title=" + string4 + " | data_message=" + string + " | data_linkkey=" + string3 + " | data_linktype= | message_no=" + string2);
        } catch (Exception e3) {
            e = e3;
            Log.e(this.TAG, "onMessageReceived JSONObject Exception=" + e.getMessage());
            e.printStackTrace();
            String notifyMessageNo = Global.getNotifyMessageNo(getApplicationContext());
            if (string2 == null) {
            }
            if (string2 != null) {
            }
            powerManager = (PowerManager) getSystemService("power");
            if (!powerManager.isInteractive()) {
            }
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            Log.d(this.TAG, "isMainActivityRun=" + Global.isMainActivityRun);
            Global.noticeMessage_no = str;
            if (!Global.isMainActivityRun) {
            }
            Log.d(this.TAG, "APPLICATION_ID =com.soletreadmills.sole");
            i = Global.BRAND;
            int i3 = R.drawable.ic_notice_sole;
            if (i != 0) {
            }
            if (Build.VERSION.SDK_INT < 26) {
            }
            notificationManager.notify(id, notificationBuild);
            i2 = id + 1;
            id = i2;
            if (i2 > 1000) {
            }
            sendBroadcast(new Intent(INTENT_FILTER));
        }
        String notifyMessageNo2 = Global.getNotifyMessageNo(getApplicationContext());
        if (string2 == null && string2.length() > 0 && string2.equals(notifyMessageNo2)) {
            Log.d(this.TAG, "一樣的推播，不發通知 JPush");
            return;
        }
        if (string2 != null) {
            Global.saveNotifyMessageNo(getApplicationContext(), string2);
            str = string2;
        }
        powerManager = (PowerManager) getSystemService("power");
        if (!powerManager.isInteractive()) {
            powerManager.newWakeLock(805306394, "MH24_SCREENLOCK").acquire(10000L);
            powerManager.newWakeLock(1, "MH24_SCREENLOCK").acquire(10000L);
        }
        NotificationManager notificationManager2 = (NotificationManager) getSystemService("notification");
        Log.d(this.TAG, "isMainActivityRun=" + Global.isMainActivityRun);
        Global.noticeMessage_no = str;
        if (!Global.isMainActivityRun) {
            Intent intent = new Intent(getApplicationContext(), (Class<?>) MainActivity.class);
            intent.setFlags(67108864);
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            activity = PendingIntent.getActivity(getApplicationContext(), id, intent, 134217728);
        } else {
            Intent intent2 = new Intent(getApplicationContext(), (Class<?>) LogoActivity.class);
            intent2.setFlags(67108864);
            intent2.addFlags(268435456);
            intent2.addFlags(536870912);
            activity = PendingIntent.getActivity(getApplicationContext(), id, intent2, 134217728);
        }
        Log.d(this.TAG, "APPLICATION_ID =com.soletreadmills.sole");
        i = Global.BRAND;
        int i32 = R.drawable.ic_notice_sole;
        if (i != 0) {
            color = getColor(R.color.sole_notification_icon);
        } else if (i == 1) {
            i32 = R.drawable.ic_notice_spirit;
            color = getColor(R.color.spirit_notification_icon);
        } else if (i == 2) {
            i32 = R.drawable.ic_notice_xterra;
            color = getColor(R.color.xterra_notification_icon);
        } else if (i == 3) {
            i32 = R.drawable.ic_notice_fuel;
            color = getColor(R.color.fuel_notification_icon);
        } else {
            color = getColor(R.color.sole_notification_icon);
        }
        if (Build.VERSION.SDK_INT < 26) {
            NotificationChannel notificationChannel = new NotificationChannel(BuildConfig.APPLICATION_ID, string4 + " notify", 4);
            notificationChannel.setLockscreenVisibility(1);
            notificationChannel.enableVibration(true);
            notificationChannel.enableLights(true);
            notificationManager2.createNotificationChannel(notificationChannel);
            notificationBuild = new NotificationCompat.Builder(this, BuildConfig.APPLICATION_ID).setContentIntent(activity).setSmallIcon(i32).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).setColor(color).setDefaults(-1).setContentTitle(string4).setContentText(string).setStyle(new NotificationCompat.BigTextStyle().bigText(string)).setVisibility(1).setCategory(NotificationCompat.CATEGORY_MESSAGE).setPriority(1).setContentIntent(activity).setAutoCancel(true).build();
        } else {
            notificationBuild = new NotificationCompat.Builder(this).setContentIntent(activity).setSmallIcon(i32).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).setColor(color).setDefaults(-1).setContentTitle(string4).setContentText(string).setStyle(new NotificationCompat.BigTextStyle().bigText(string)).setVisibility(1).setPriority(1).setCategory(NotificationCompat.CATEGORY_MESSAGE).setContentIntent(activity).setAutoCancel(true).build();
        }
        notificationManager2.notify(id, notificationBuild);
        i2 = id + 1;
        id = i2;
        if (i2 > 1000) {
            id = 2;
        }
        sendBroadcast(new Intent(INTENT_FILTER));
    }

    private boolean isPackageInstalled(String str) throws PackageManager.NameNotFoundException {
        try {
            getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
