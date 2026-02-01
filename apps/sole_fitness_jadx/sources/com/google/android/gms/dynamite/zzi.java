package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
/* loaded from: classes.dex */
final class zzi implements DynamiteModule.VersionPolicy {
    zzi() {
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.localVersion = iVersions.zza(context, str);
        int iZzb = iVersions.zzb(context, str, true);
        selectionResult.remoteVersion = iZzb;
        int i = selectionResult.localVersion;
        if (i != 0) {
            if (i < iZzb) {
                selectionResult.selection = -1;
            } else {
                selectionResult.selection = 1;
            }
        } else if (iZzb == 0) {
            selectionResult.selection = 0;
        } else {
            i = 0;
            if (i < iZzb) {
            }
        }
        return selectionResult;
    }
}
