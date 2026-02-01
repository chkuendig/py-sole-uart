package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Wearable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public abstract class NodeClient extends GoogleApi<Wearable.WearableOptions> {
    public static final String ACTION_NODE_MIGRATED = "com.google.android.gms.wearable.NODE_MIGRATED";

    /* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
    public interface OnNodeMigratedListener {
        void onNodeMigrated(String str, DataItemBuffer dataItemBuffer);
    }

    public NodeClient(Activity activity, GoogleApi.Settings settings) {
        super(activity, Wearable.API, Wearable.WearableOptions.zza, settings);
    }

    public abstract Task<String> getCompanionPackageForNode(String str);

    public abstract Task<List<Node>> getConnectedNodes();

    public abstract Task<Node> getLocalNode();

    public abstract Task<String> getNodeId(String str);

    public NodeClient(Context context, GoogleApi.Settings settings) {
        super(context, Wearable.API, Wearable.WearableOptions.zza, settings);
    }
}
