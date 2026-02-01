package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzaz extends zzaw {
    protected zzaz() {
        this.zza.add(zzbl.APPLY);
        this.zza.add(zzbl.BLOCK);
        this.zza.add(zzbl.BREAK);
        this.zza.add(zzbl.CASE);
        this.zza.add(zzbl.DEFAULT);
        this.zza.add(zzbl.CONTINUE);
        this.zza.add(zzbl.DEFINE_FUNCTION);
        this.zza.add(zzbl.FN);
        this.zza.add(zzbl.IF);
        this.zza.add(zzbl.QUOTE);
        this.zza.add(zzbl.RETURN);
        this.zza.add(zzbl.SWITCH);
        this.zza.add(zzbl.TERNARY);
    }

    private static zzap zzc(zzg zzgVar, List<zzap> list) {
        zzh.zzi(zzbl.FN.name(), 2, list);
        zzap zzapVarZzb = zzgVar.zzb(list.get(0));
        zzap zzapVarZzb2 = zzgVar.zzb(list.get(1));
        if (!(zzapVarZzb2 instanceof zzae)) {
            throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", zzapVarZzb2.getClass().getCanonicalName()));
        }
        List<zzap> listZzm = ((zzae) zzapVarZzb2).zzm();
        List<zzap> arrayList = new ArrayList<>();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new zzao(zzapVarZzb.zzi(), listZzm, arrayList, zzgVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0129, code lost:
    
        if (r8.equals("continue") == false) goto L64;
     */
    @Override // com.google.android.gms.internal.measurement.zzaw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzap zza(String str, zzg zzgVar, List<zzap> list) {
        zzap zzapVarZzb;
        zzbl zzblVar = zzbl.ADD;
        int iOrdinal = zzh.zze(str).ordinal();
        if (iOrdinal == 2) {
            zzh.zzh(zzbl.APPLY.name(), 3, list);
            zzap zzapVarZzb2 = zzgVar.zzb(list.get(0));
            String strZzi = zzgVar.zzb(list.get(1)).zzi();
            zzap zzapVarZzb3 = zzgVar.zzb(list.get(2));
            if (!(zzapVarZzb3 instanceof zzae)) {
                throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", zzapVarZzb3.getClass().getCanonicalName()));
            }
            if (strZzi.isEmpty()) {
                throw new IllegalArgumentException("Function name for apply is undefined");
            }
            return zzapVarZzb2.zzbK(strZzi, zzgVar, ((zzae) zzapVarZzb3).zzm());
        }
        if (iOrdinal == 15) {
            zzh.zzh(zzbl.BREAK.name(), 0, list);
            return zzap.zzh;
        }
        if (iOrdinal == 25) {
            return zzc(zzgVar, list);
        }
        if (iOrdinal == 41) {
            zzh.zzi(zzbl.IF.name(), 2, list);
            zzap zzapVarZzb4 = zzgVar.zzb(list.get(0));
            zzap zzapVarZzb5 = zzgVar.zzb(list.get(1));
            zzap zzapVarZzb6 = list.size() > 2 ? zzgVar.zzb(list.get(2)) : null;
            zzap zzapVarZzc = zzap.zzf;
            if (zzapVarZzb4.zzg().booleanValue()) {
                zzapVarZzc = zzgVar.zzc((zzae) zzapVarZzb5);
            } else if (zzapVarZzb6 != null) {
                zzapVarZzc = zzgVar.zzc((zzae) zzapVarZzb6);
            }
            return zzapVarZzc instanceof zzag ? zzapVarZzc : zzap.zzf;
        }
        if (iOrdinal == 54) {
            return new zzae(list);
        }
        if (iOrdinal == 57) {
            if (list.isEmpty()) {
                return zzap.zzj;
            }
            zzh.zzh(zzbl.RETURN.name(), 1, list);
            return new zzag("return", zzgVar.zzb(list.get(0)));
        }
        if (iOrdinal != 19) {
            if (iOrdinal == 20) {
                zzh.zzi(zzbl.DEFINE_FUNCTION.name(), 2, list);
                zzap zzapVarZzc2 = zzc(zzgVar, list);
                zzai zzaiVar = (zzai) zzapVarZzc2;
                if (zzaiVar.zzc() == null) {
                    zzgVar.zzg("", zzapVarZzc2);
                } else {
                    zzgVar.zzg(zzaiVar.zzc(), zzapVarZzc2);
                }
                return zzapVarZzc2;
            }
            if (iOrdinal == 60) {
                zzh.zzh(zzbl.SWITCH.name(), 3, list);
                zzap zzapVarZzb7 = zzgVar.zzb(list.get(0));
                zzap zzapVarZzb8 = zzgVar.zzb(list.get(1));
                zzap zzapVarZzb9 = zzgVar.zzb(list.get(2));
                if (!(zzapVarZzb8 instanceof zzae)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                }
                if (!(zzapVarZzb9 instanceof zzae)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                }
                zzae zzaeVar = (zzae) zzapVarZzb8;
                zzae zzaeVar2 = (zzae) zzapVarZzb9;
                int i = 0;
                boolean z = false;
                while (true) {
                    if (i >= zzaeVar.zzc()) {
                        if (zzaeVar.zzc() + 1 == zzaeVar2.zzc()) {
                            zzapVarZzb = zzgVar.zzb(zzaeVar2.zze(zzaeVar.zzc()));
                            if (zzapVarZzb instanceof zzag) {
                                String strZzc = ((zzag) zzapVarZzb).zzc();
                                if (!strZzc.equals("return")) {
                                }
                            }
                        }
                        return zzap.zzf;
                    }
                    if (z || zzapVarZzb7.equals(zzgVar.zzb(zzaeVar.zze(i)))) {
                        zzapVarZzb = zzgVar.zzb(zzaeVar2.zze(i));
                        if (!(zzapVarZzb instanceof zzag)) {
                            z = true;
                        } else if (((zzag) zzapVarZzb).zzc().equals("break")) {
                            return zzap.zzf;
                        }
                    } else {
                        z = false;
                    }
                    i++;
                }
                return zzapVarZzb;
            }
            if (iOrdinal == 61) {
                zzh.zzh(zzbl.TERNARY.name(), 3, list);
                return zzgVar.zzb(list.get(0)).zzg().booleanValue() ? zzgVar.zzb(list.get(1)) : zzgVar.zzb(list.get(2));
            }
            switch (iOrdinal) {
                case 11:
                    return zzgVar.zza().zzc(new zzae(list));
                case 12:
                    zzh.zzh(zzbl.BREAK.name(), 0, list);
                    return zzap.zzi;
                case 13:
                    break;
                default:
                    return super.zzb(str);
            }
        }
        if (list.isEmpty()) {
            return zzap.zzf;
        }
        zzap zzapVarZzb10 = zzgVar.zzb(list.get(0));
        return zzapVarZzb10 instanceof zzae ? zzgVar.zzc((zzae) zzapVarZzb10) : zzap.zzf;
    }
}
