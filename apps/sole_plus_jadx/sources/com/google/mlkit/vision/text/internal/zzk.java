package com.google.mlkit.vision.text.internal;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbh;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbk;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbu;
import com.google.android.gms.internal.mlkit_vision_text_common.zzcp;
import com.google.android.gms.internal.mlkit_vision_text_common.zzu;
import com.google.android.gms.internal.mlkit_vision_text_common.zzv;
import com.google.android.gms.internal.mlkit_vision_text_common.zzy;
import com.google.mlkit.vision.text.Text;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes5.dex */
final class zzk {
    public static final /* synthetic */ int zzb = 0;
    static final zzv zza = zzv.zza("\n");
    private static final Comparator zzc = new Comparator() { // from class: com.google.mlkit.vision.text.internal.zzf
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int i = zzk.zzb;
            return ((Integer) ((Map.Entry) obj).getValue()).compareTo((Integer) ((Map.Entry) obj2).getValue());
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    static Text zza(com.google.android.gms.internal.mlkit_vision_text_common.zzl[] zzlVarArr, final Matrix matrix) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (com.google.android.gms.internal.mlkit_vision_text_common.zzl zzlVar : zzlVarArr) {
            SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzlVar.zzj);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                sparseArray.append(zzlVar.zzj, sparseArray2);
            }
            sparseArray2.append(zzlVar.zzk, zzlVar);
        }
        zzbh zzbhVar = new zzbh();
        int i2 = 0;
        while (i2 < sparseArray.size()) {
            SparseArray sparseArray3 = (SparseArray) sparseArray.valueAt(i2);
            zzbh zzbhVar2 = new zzbh();
            for (int i3 = i; i3 < sparseArray3.size(); i3++) {
                zzbhVar2.zza((com.google.android.gms.internal.mlkit_vision_text_common.zzl) sparseArray3.valueAt(i3));
            }
            zzbk zzbkVarZzb = zzbhVar2.zzb();
            List listZza = zzbu.zza(zzbkVarZzb, new zzu() { // from class: com.google.mlkit.vision.text.internal.zzh
                @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                public final Object zza(Object obj) {
                    com.google.android.gms.internal.mlkit_vision_text_common.zzl zzlVar2 = (com.google.android.gms.internal.mlkit_vision_text_common.zzl) obj;
                    int i4 = zzk.zzb;
                    List listZzb = zza.zzb(zzlVar2.zzb);
                    String str = zzy.zzb(zzlVar2.zze) ? "" : zzlVar2.zze;
                    Rect rectZza = zza.zza(listZzb);
                    String str2 = zzy.zzb(zzlVar2.zzg) ? "und" : zzlVar2.zzg;
                    final Matrix matrix2 = matrix;
                    return new Text.Line(str, rectZza, listZzb, str2, matrix2, zzbu.zza(Arrays.asList(zzlVar2.zza), new zzu() { // from class: com.google.mlkit.vision.text.internal.zzj
                        @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                        public final Object zza(Object obj2) {
                            com.google.android.gms.internal.mlkit_vision_text_common.zzr zzrVar = (com.google.android.gms.internal.mlkit_vision_text_common.zzr) obj2;
                            int i5 = zzk.zzb;
                            List listZzb2 = zza.zzb(zzrVar.zzb);
                            return new Text.Element(zzy.zzb(zzrVar.zzd) ? "" : zzrVar.zzd, zza.zza(listZzb2), listZzb2, zzy.zzb(zzrVar.zzf) ? "und" : zzrVar.zzf, matrix2, zzrVar.zze, zzrVar.zzb.zze, zzbk.zzh());
                        }
                    }), zzlVar2.zzf, zzlVar2.zzb.zze);
                }
            });
            com.google.android.gms.internal.mlkit_vision_text_common.zzf zzfVar = ((com.google.android.gms.internal.mlkit_vision_text_common.zzl) zzbkVarZzb.get(i)).zzb;
            zzcp zzcpVarListIterator = zzbkVarZzb.listIterator(i);
            int iMax = Integer.MIN_VALUE;
            int iMin = Integer.MAX_VALUE;
            int iMin2 = Integer.MAX_VALUE;
            int iMax2 = Integer.MIN_VALUE;
            while (zzcpVarListIterator.hasNext()) {
                com.google.android.gms.internal.mlkit_vision_text_common.zzf zzfVar2 = ((com.google.android.gms.internal.mlkit_vision_text_common.zzl) zzcpVarListIterator.next()).zzb;
                int i4 = -zzfVar.zza;
                int i5 = -zzfVar.zzb;
                zzcp zzcpVar = zzcpVarListIterator;
                double dSin = Math.sin(Math.toRadians(zzfVar.zze));
                SparseArray sparseArray4 = sparseArray;
                int i6 = i2;
                double dCos = Math.cos(Math.toRadians(zzfVar.zze));
                zzbh zzbhVar3 = zzbhVar;
                List list = listZza;
                Point point = new Point(zzfVar2.zza, zzfVar2.zzb);
                point.offset(i4, i5);
                int i7 = (int) ((pointArr[0].x * dCos) + (pointArr[0].y * dSin));
                pointArr[0].x = i7;
                int i8 = (int) (((-pointArr[0].x) * dSin) + (pointArr[0].y * dCos));
                pointArr[0].y = i8;
                Point[] pointArr = {point, new Point(zzfVar2.zzc + i7, i8), new Point(zzfVar2.zzc + i7, zzfVar2.zzd + i8), new Point(i7, i8 + zzfVar2.zzd)};
                iMax2 = iMax2;
                iMax = iMax;
                for (int i9 = 0; i9 < 4; i9++) {
                    Point point2 = pointArr[i9];
                    iMin = Math.min(iMin, point2.x);
                    iMax = Math.max(iMax, point2.x);
                    iMin2 = Math.min(iMin2, point2.y);
                    iMax2 = Math.max(iMax2, point2.y);
                }
                zzcpVarListIterator = zzcpVar;
                sparseArray = sparseArray4;
                i2 = i6;
                zzbhVar = zzbhVar3;
                listZza = list;
            }
            zzbh zzbhVar4 = zzbhVar;
            SparseArray sparseArray5 = sparseArray;
            int i10 = i2;
            int i11 = iMax;
            int i12 = iMax2;
            List list2 = listZza;
            int i13 = zzfVar.zza;
            int i14 = zzfVar.zzb;
            double dSin2 = Math.sin(Math.toRadians(zzfVar.zze));
            double dCos2 = Math.cos(Math.toRadians(zzfVar.zze));
            Point[] pointArr2 = {new Point(iMin, iMin2), new Point(i11, iMin2), new Point(i11, i12), new Point(iMin, i12)};
            int i15 = 0;
            for (int i16 = 4; i15 < i16; i16 = 4) {
                pointArr2[i15].x = (int) ((pointArr2[i15].x * dCos2) - (pointArr2[i15].y * dSin2));
                pointArr2[i15].y = (int) ((pointArr2[i15].x * dSin2) + (pointArr2[i15].y * dCos2));
                pointArr2[i15].offset(i13, i14);
                i15++;
            }
            List listAsList = Arrays.asList(pointArr2);
            zzbhVar4.zza(new Text.TextBlock(zza.zzb(zzbu.zza(list2, new zzu() { // from class: com.google.mlkit.vision.text.internal.zzi
                @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                public final Object zza(Object obj) {
                    return ((Text.Line) obj).getText();
                }
            })), zza.zza(listAsList), listAsList, zzb(list2), matrix, list2));
            i2 = i10 + 1;
            zzbhVar = zzbhVar4;
            sparseArray = sparseArray5;
            i = 0;
        }
        zzbk zzbkVarZzb2 = zzbhVar.zzb();
        return new Text(zza.zzb(zzbu.zza(zzbkVarZzb2, new zzu() { // from class: com.google.mlkit.vision.text.internal.zzg
            @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
            public final Object zza(Object obj) {
                return ((Text.TextBlock) obj).getText();
            }
        })), zzbkVarZzb2);
    }

    private static String zzb(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String recognizedLanguage = ((Text.Line) it.next()).getRecognizedLanguage();
            map.put(recognizedLanguage, Integer.valueOf((map.containsKey(recognizedLanguage) ? ((Integer) map.get(recognizedLanguage)).intValue() : 0) + 1));
        }
        Set setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return "und";
        }
        String str = (String) ((Map.Entry) Collections.max(setEntrySet, zzc)).getKey();
        return !zzy.zzb(str) ? str : "und";
    }
}
