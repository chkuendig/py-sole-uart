package com.google.mlkit.vision.text.internal;

import android.graphics.Point;
import android.graphics.Rect;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes5.dex */
final class zza {
    static Rect zza(List list) {
        Iterator it = list.iterator();
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            Point point = (Point) it.next();
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
        }
        return new Rect(iMin, iMin2, iMax, iMax2);
    }

    static List zzb(com.google.android.gms.internal.mlkit_vision_text_common.zzf zzfVar) {
        Point[] pointArr = new Point[4];
        double dSin = Math.sin(Math.toRadians(zzfVar.zze));
        double dCos = Math.cos(Math.toRadians(zzfVar.zze));
        pointArr[0] = new Point(zzfVar.zza, zzfVar.zzb);
        double d = zzfVar.zza;
        double d2 = zzfVar.zzc;
        pointArr[1] = new Point((int) (d + (d2 * dCos)), (int) (zzfVar.zzb + (d2 * dSin)));
        pointArr[2] = new Point((int) (r5.x - (zzfVar.zzd * dSin)), (int) (pointArr[1].y + (zzfVar.zzd * dCos)));
        pointArr[3] = new Point(pointArr[0].x + (pointArr[2].x - pointArr[1].x), pointArr[0].y + (pointArr[2].y - pointArr[1].y));
        return Arrays.asList(pointArr);
    }
}
