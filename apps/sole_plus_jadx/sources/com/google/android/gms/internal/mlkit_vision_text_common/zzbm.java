package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public abstract class zzbm implements Map, Serializable {

    @CheckForNull
    private transient zzbn zza;

    @CheckForNull
    private transient zzbn zzb;

    @CheckForNull
    private transient zzbf zzc;

    zzbm() {
    }

    public static zzbm zzc(Object obj, Object obj2) {
        zzaq.zzb("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
        return zzcj.zzg(1, new Object[]{"optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzcl.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzbn zzbnVar = this.zzb;
        if (zzbnVar != null) {
            return zzbnVar;
        }
        zzbn zzbnVarZze = zze();
        this.zzb = zzbnVarZze;
        return zzbnVarZze;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzaq.zza(size, ContentDisposition.Parameters.Size);
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append(SignatureVisitor.INSTANCEOF);
            sb.append(entry.getValue());
            z = false;
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    abstract zzbf zza();

    @Override // java.util.Map
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzbf values() {
        zzbf zzbfVar = this.zzc;
        if (zzbfVar != null) {
            return zzbfVar;
        }
        zzbf zzbfVarZza = zza();
        this.zzc = zzbfVarZza;
        return zzbfVarZza;
    }

    abstract zzbn zzd();

    abstract zzbn zze();

    @Override // java.util.Map
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzbn entrySet() {
        zzbn zzbnVar = this.zza;
        if (zzbnVar != null) {
            return zzbnVar;
        }
        zzbn zzbnVarZzd = zzd();
        this.zza = zzbnVarZzd;
        return zzbnVarZzd;
    }
}
