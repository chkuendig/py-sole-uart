package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
final class zzum extends LazyInstanceMap {
    private zzum() {
        throw null;
    }

    /* synthetic */ zzum(zzul zzulVar) {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zztu zztuVar = (zztu) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzuc(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zztv(MlKitContext.getInstance().getApplicationContext(), zztuVar), zztuVar.zzb());
    }
}
