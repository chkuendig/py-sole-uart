package com.google.android.gms.internal.wearable;

import com.google.android.gms.internal.wearable.zzaq;
import com.google.android.gms.internal.wearable.zzar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public abstract class zzar<MessageType extends zzar<MessageType, BuilderType>, BuilderType extends zzaq<MessageType, BuilderType>> implements zzdn {
    protected int zza = 0;

    /* JADX WARN: Multi-variable type inference failed */
    protected static void zzJ(Iterable iterable, List list) {
        byte[] bArr = zzco.zzd;
        iterable.getClass();
        if (iterable instanceof zzcv) {
            List listZzh = ((zzcv) iterable).zzh();
            zzcv zzcvVar = (zzcv) list;
            int size = list.size();
            for (Object obj : listZzh) {
                if (obj == null) {
                    String str = "Element at index " + (zzcvVar.size() - size) + " is null.";
                    int size2 = zzcvVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        zzcvVar.remove(size2);
                    }
                } else if (obj instanceof zzbh) {
                    zzcvVar.zzi((zzbh) obj);
                } else {
                    zzcvVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzdu) {
            list.addAll(iterable);
            return;
        }
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
        }
        int size3 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size3) {
                        throw new NullPointerException(str2);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj2);
            }
        }
    }

    int zzH(zzdy zzdyVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final zzbh zzI() {
        try {
            int iZzM = zzM();
            zzbh zzbhVar = zzbh.zzb;
            byte[] bArr = new byte[iZzM];
            zzbp zzbpVarZzz = zzbp.zzz(bArr, 0, iZzM);
            zzad(zzbpVarZzz);
            zzbpVarZzz.zzA();
            return new zzbe(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zzK() {
        try {
            int iZzM = zzM();
            byte[] bArr = new byte[iZzM];
            zzbp zzbpVarZzz = zzbp.zzz(bArr, 0, iZzM);
            zzad(zzbpVarZzz);
            zzbpVarZzz.zzA();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
