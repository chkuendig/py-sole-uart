package com.soletreadmills.sole_v2.service;

import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.soletreadmills.sole_v2._manager.MyNotificationManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* compiled from: MyFirebaseMessagingService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/service/MyFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "onMessageReceived", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final int $stable = 0;

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) throws JSONException {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        MyNotificationManager.INSTANCE.getInstance().sendNotificationFromFcm(remoteMessage);
        Map<String, String> data = remoteMessage.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        if (data.isEmpty()) {
            return;
        }
        Log.d("FCM_DATA", "data = " + remoteMessage.getData());
        Map<String, String> data2 = remoteMessage.getData();
        Intrinsics.checkNotNullExpressionValue(data2, "getData(...)");
        for (Map.Entry<String, String> entry : data2.entrySet()) {
            Log.d("FCM_DATA", entry.getKey() + " = " + entry.getValue());
        }
    }
}
