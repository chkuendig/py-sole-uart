package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import com.google.android.gms.wearable.NodeClient;
import com.google.android.gms.wearable.internal.zzbg;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public abstract class WearableListenerService extends Service implements DataApi.DataListener, MessageApi.MessageListener, NodeClient.OnNodeMigratedListener, CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, MessageClient.RpcService {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private ComponentName zza;
    private zzs zzb;
    private IBinder zzc;
    private Intent zzd;
    private Looper zze;
    private boolean zzg;
    private final Object zzf = new Object();
    private final zzbg zzh = new zzbg(new zzp(this, null));

    public Looper getLooper() {
        if (this.zze == null) {
            HandlerThread handlerThread = new HandlerThread("WearableListenerService");
            handlerThread.start();
            this.zze = handlerThread.getLooper();
        }
        return this.zze;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.IBinder onBind(android.content.Intent r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = r5.getAction()
            if (r1 != 0) goto Lb
            return r0
        Lb:
            int r2 = r1.hashCode()
            r3 = 3
            switch(r2) {
                case -1487371046: goto L50;
                case -1140095138: goto L46;
                case -786751258: goto L3c;
                case 705066793: goto L32;
                case 915816236: goto L28;
                case 1003809169: goto L1e;
                case 1460975593: goto L14;
                default: goto L13;
            }
        L13:
            goto L5a
        L14:
            java.lang.String r2 = "com.google.android.gms.wearable.BIND_LISTENER"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L5a
            r1 = 0
            goto L5b
        L1e:
            java.lang.String r2 = "com.google.android.gms.wearable.CHANNEL_EVENT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L5a
            r1 = r3
            goto L5b
        L28:
            java.lang.String r2 = "com.google.android.gms.wearable.DATA_CHANGED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L5a
            r1 = 1
            goto L5b
        L32:
            java.lang.String r2 = "com.google.android.gms.wearable.NODE_MIGRATED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L5a
            r1 = 2
            goto L5b
        L3c:
            java.lang.String r2 = "com.google.android.gms.wearable.MESSAGE_RECEIVED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L5a
            r1 = 5
            goto L5b
        L46:
            java.lang.String r2 = "com.google.android.gms.wearable.REQUEST_RECEIVED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L5a
            r1 = 4
            goto L5b
        L50:
            java.lang.String r2 = "com.google.android.gms.wearable.CAPABILITY_CHANGED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L5a
            r1 = 6
            goto L5b
        L5a:
            r1 = -1
        L5b:
            switch(r1) {
                case 0: goto L81;
                case 1: goto L81;
                case 2: goto L81;
                case 3: goto L81;
                case 4: goto L81;
                case 5: goto L81;
                case 6: goto L81;
                default: goto L5e;
            }
        L5e:
            java.lang.String r1 = "WearableLS"
            boolean r2 = android.util.Log.isLoggable(r1, r3)
            if (r2 == 0) goto L84
            java.lang.String r5 = r5.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "onBind: Provided bind intent ("
            r2.<init>(r3)
            r2.append(r5)
            java.lang.String r5 = ") is not allowed"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            android.util.Log.d(r1, r5)
            goto L84
        L81:
            android.os.IBinder r5 = r4.zzc
            return r5
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.WearableListenerService.onBind(android.content.Intent):android.os.IBinder");
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener
    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelClosed(Channel channel, int i, int i2) {
    }

    public void onChannelClosed(ChannelClient.Channel channel, int i, int i2) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelOpened(Channel channel) {
    }

    public void onChannelOpened(ChannelClient.Channel channel) {
    }

    public void onConnectedNodes(List<Node> list) {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.zza = new ComponentName(this, getClass().getName());
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: ".concat(String.valueOf(String.valueOf(this.zza))));
        }
        this.zzb = new zzs(this, getLooper());
        Intent intent = new Intent(BIND_LISTENER_INTENT_ACTION);
        this.zzd = intent;
        intent.setComponent(this.zza);
        this.zzc = new zzag(this, null);
    }

    @Override // com.google.android.gms.wearable.DataApi.DataListener
    public void onDataChanged(DataEventBuffer dataEventBuffer) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onDestroy: ".concat(String.valueOf(String.valueOf(this.zza))));
        }
        synchronized (this.zzf) {
            this.zzg = true;
            zzs zzsVar = this.zzb;
            if (zzsVar == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=" + String.valueOf(this.zza));
            }
            zzsVar.zzb();
        }
        super.onDestroy();
    }

    public void onEntityUpdate(zza zzaVar) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onInputClosed(Channel channel, int i, int i2) {
    }

    public void onInputClosed(ChannelClient.Channel channel, int i, int i2) {
    }

    @Override // com.google.android.gms.wearable.MessageApi.MessageListener
    public void onMessageReceived(MessageEvent messageEvent) {
    }

    @Override // com.google.android.gms.wearable.NodeClient.OnNodeMigratedListener
    public void onNodeMigrated(String str, DataItemBuffer dataItemBuffer) {
    }

    public void onNotificationReceived(zzb zzbVar) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onOutputClosed(Channel channel, int i, int i2) {
    }

    public void onOutputClosed(ChannelClient.Channel channel, int i, int i2) {
    }

    public void onPeerConnected(Node node) {
    }

    public void onPeerDisconnected(Node node) {
    }

    @Override // com.google.android.gms.wearable.MessageClient.RpcService
    public Task<byte[]> onRequest(String str, String str2, byte[] bArr) {
        return null;
    }
}
