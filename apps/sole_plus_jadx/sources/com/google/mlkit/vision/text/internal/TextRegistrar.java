package com.google.mlkit.vision.text.internal;

import com.google.android.gms.internal.mlkit_vision_text_common.zzbk;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes5.dex */
public class TextRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        return zzbk.zzi(Component.builder(zzp.class).add(Dependency.required((Class<?>) MlKitContext.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.vision.text.internal.zzs
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                int i = TextRegistrar.zza;
                return new zzp((MlKitContext) componentContainer.get(MlKitContext.class));
            }
        }).build(), Component.builder(zzo.class).add(Dependency.required((Class<?>) zzp.class)).add(Dependency.required((Class<?>) ExecutorSelector.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.vision.text.internal.zzt
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzo((zzp) componentContainer.get(zzp.class), (ExecutorSelector) componentContainer.get(ExecutorSelector.class));
            }
        }).build());
    }
}
