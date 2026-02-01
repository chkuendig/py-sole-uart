package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzoa;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzw extends zzx {
    final /* synthetic */ zzz zza;
    private final com.google.android.gms.internal.measurement.zzej zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzw(zzz zzzVar, String str, int i, com.google.android.gms.internal.measurement.zzej zzejVar) {
        super(str, i);
        this.zza = zzzVar;
        this.zzh = zzejVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzx
    final int zza() {
        return this.zzh.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzx
    final boolean zzb() {
        return this.zzh.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzx
    final boolean zzc() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final boolean zzd(Long l, Long l2, com.google.android.gms.internal.measurement.zzfo zzfoVar, long j, zzap zzapVar, boolean z) {
        Boolean boolZzi;
        zzoa.zzc();
        boolean zZzs = this.zza.zzs.zzf().zzs(this.zzb, zzdy.zzY);
        long j2 = this.zzh.zzn() ? zzapVar.zze : j;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        Boolean bool = null;
        if (Log.isLoggable(this.zza.zzs.zzay().zzq(), 2)) {
            this.zza.zzs.zzay().zzj().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(this.zzc), this.zzh.zzp() ? Integer.valueOf(this.zzh.zzb()) : null, this.zza.zzs.zzj().zzd(this.zzh.zzg()));
            this.zza.zzs.zzay().zzj().zzb("Filter definition", this.zza.zzf.zzu().zzo(this.zzh));
        }
        if (!this.zzh.zzp() || this.zzh.zzb() > 256) {
            this.zza.zzs.zzay().zzk().zzc("Invalid event filter ID. appId, id", zzel.zzn(this.zzb), String.valueOf(this.zzh.zzp() ? Integer.valueOf(this.zzh.zzb()) : null));
            return false;
        }
        Object[] objArr = this.zzh.zzk() || this.zzh.zzm() || this.zzh.zzn();
        if (z && objArr != true) {
            this.zza.zzs.zzay().zzj().zzc("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), this.zzh.zzp() ? Integer.valueOf(this.zzh.zzb()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzej zzejVar = this.zzh;
        String strZzh = zzfoVar.zzh();
        if (!zzejVar.zzo()) {
            HashSet hashSet = new HashSet();
            Iterator<com.google.android.gms.internal.measurement.zzel> it = zzejVar.zzh().iterator();
            while (true) {
                if (!it.hasNext()) {
                    ArrayMap arrayMap = new ArrayMap();
                    Iterator<com.google.android.gms.internal.measurement.zzfs> it2 = zzfoVar.zzi().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            Iterator<com.google.android.gms.internal.measurement.zzel> it3 = zzejVar.zzh().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    bool = true;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.zzel next = it3.next();
                                boolean z2 = next.zzh() && next.zzg();
                                String strZze = next.zze();
                                if (strZze.isEmpty()) {
                                    this.zza.zzs.zzay().zzk().zzb("Event has empty param name. event", this.zza.zzs.zzj().zzd(strZzh));
                                    break;
                                }
                                Object obj = arrayMap.get(strZze);
                                if (obj instanceof Long) {
                                    if (!next.zzi()) {
                                        this.zza.zzs.zzay().zzk().zzc("No number filter for long param. event, param", this.zza.zzs.zzj().zzd(strZzh), this.zza.zzs.zzj().zze(strZze));
                                        break;
                                    }
                                    Boolean boolZzh = zzh(((Long) obj).longValue(), next.zzc());
                                    if (boolZzh == null) {
                                        break;
                                    }
                                    if (boolZzh.booleanValue() == z2) {
                                        bool = false;
                                        break;
                                    }
                                } else if (obj instanceof Double) {
                                    if (!next.zzi()) {
                                        this.zza.zzs.zzay().zzk().zzc("No number filter for double param. event, param", this.zza.zzs.zzj().zzd(strZzh), this.zza.zzs.zzj().zze(strZze));
                                        break;
                                    }
                                    Boolean boolZzg = zzg(((Double) obj).doubleValue(), next.zzc());
                                    if (boolZzg == null) {
                                        break;
                                    }
                                    if (boolZzg.booleanValue() == z2) {
                                        bool = false;
                                        break;
                                    }
                                } else if (obj instanceof String) {
                                    if (!next.zzk()) {
                                        if (!next.zzi()) {
                                            this.zza.zzs.zzay().zzk().zzc("No filter for String param. event, param", this.zza.zzs.zzj().zzd(strZzh), this.zza.zzs.zzj().zze(strZze));
                                            break;
                                        }
                                        String str = (String) obj;
                                        if (!zzku.zzy(str)) {
                                            this.zza.zzs.zzay().zzk().zzc("Invalid param value for number filter. event, param", this.zza.zzs.zzj().zzd(strZzh), this.zza.zzs.zzj().zze(strZze));
                                            break;
                                        }
                                        boolZzi = zzi(str, next.zzc());
                                    } else {
                                        boolZzi = zzf((String) obj, next.zzd(), this.zza.zzs.zzay());
                                    }
                                    if (boolZzi == null) {
                                        break;
                                    }
                                    if (boolZzi.booleanValue() == z2) {
                                        bool = false;
                                        break;
                                    }
                                } else if (obj == null) {
                                    this.zza.zzs.zzay().zzj().zzc("Missing param for filter. event, param", this.zza.zzs.zzj().zzd(strZzh), this.zza.zzs.zzj().zze(strZze));
                                    bool = false;
                                } else {
                                    this.zza.zzs.zzay().zzk().zzc("Unknown param type. event, param", this.zza.zzs.zzj().zzd(strZzh), this.zza.zzs.zzj().zze(strZze));
                                }
                            }
                        } else {
                            com.google.android.gms.internal.measurement.zzfs next2 = it2.next();
                            if (hashSet.contains(next2.zzg())) {
                                if (!next2.zzw()) {
                                    if (!next2.zzu()) {
                                        if (!next2.zzy()) {
                                            this.zza.zzs.zzay().zzk().zzc("Unknown value for param. event, param", this.zza.zzs.zzj().zzd(strZzh), this.zza.zzs.zzj().zze(next2.zzg()));
                                            break;
                                        }
                                        arrayMap.put(next2.zzg(), next2.zzh());
                                    } else {
                                        arrayMap.put(next2.zzg(), next2.zzu() ? Double.valueOf(next2.zza()) : null);
                                    }
                                } else {
                                    arrayMap.put(next2.zzg(), next2.zzw() ? Long.valueOf(next2.zzd()) : null);
                                }
                            }
                        }
                    }
                } else {
                    com.google.android.gms.internal.measurement.zzel next3 = it.next();
                    if (next3.zze().isEmpty()) {
                        this.zza.zzs.zzay().zzk().zzb("null or empty param name in filter. event", this.zza.zzs.zzj().zzd(strZzh));
                        break;
                    }
                    hashSet.add(next3.zze());
                }
            }
        } else {
            Boolean boolZzh2 = zzh(j2, zzejVar.zzf());
            if (boolZzh2 != null) {
                if (!boolZzh2.booleanValue()) {
                    bool = false;
                }
            }
        }
        this.zza.zzs.zzay().zzj().zzb("Event filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        this.zzd = true;
        if (!bool.booleanValue()) {
            return true;
        }
        this.zze = true;
        if (objArr != false && zzfoVar.zzu()) {
            Long lValueOf = Long.valueOf(zzfoVar.zzd());
            if (this.zzh.zzm()) {
                if (zZzs && this.zzh.zzo()) {
                    lValueOf = l;
                }
                this.zzg = lValueOf;
            } else {
                if (zZzs && this.zzh.zzo()) {
                    lValueOf = l2;
                }
                this.zzf = lValueOf;
            }
        }
        return true;
    }
}
