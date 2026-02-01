package com.dyaco.sole;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.Global;

/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
        String stringExtra = intent.getStringExtra(NotificationCompat.CATEGORY_MESSAGE);
        Log.d("ccc", NotificationCompat.CATEGORY_ALARM);
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context).setSmallIcon(com.soletreadmills.sole.R.mipmap.ic_launcher).setContentTitle(context.getResources().getString(Global.ALERT_TITLE_RID)).setContentText(stringExtra);
        Intent intent2 = new Intent(context, (Class<?>) MainActivity.class);
        TaskStackBuilder taskStackBuilderCreate = TaskStackBuilder.create(context);
        taskStackBuilderCreate.addParentStack(MainActivity.class);
        taskStackBuilderCreate.addNextIntent(intent2);
        contentText.setContentIntent(taskStackBuilderCreate.getPendingIntent(0, 134217728));
        ((NotificationManager) context.getSystemService("notification")).notify(1, contentText.build());
    }
}
