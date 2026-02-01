package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzom;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzgi implements Callable<byte[]> {
    final /* synthetic */ zzat zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgn zzc;

    zzgi(zzgn zzgnVar, zzat zzatVar, String str) {
        this.zzc = zzgnVar;
        this.zza = zzatVar;
        this.zzb = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x037b A[Catch: all -> 0x0603, LOOP:2: B:107:0x0375->B:109:0x037b, LOOP_END, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x041a A[Catch: all -> 0x0603, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0442 A[Catch: all -> 0x0603, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0478 A[Catch: all -> 0x0603, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x04c8 A[Catch: all -> 0x0603, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0534 A[Catch: all -> 0x0603, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x054a A[Catch: all -> 0x0603, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0555 A[Catch: all -> 0x0603, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0219 A[Catch: all -> 0x0603, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x027d A[Catch: all -> 0x0603, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02a2 A[Catch: all -> 0x0603, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02bc A[Catch: all -> 0x0603, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0306 A[Catch: all -> 0x0603, TryCatch #0 {all -> 0x0603, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x014a, B:36:0x0154, B:49:0x017f, B:51:0x0194, B:53:0x01a4, B:55:0x01aa, B:57:0x01b0, B:58:0x01b3, B:60:0x01c0, B:62:0x01d4, B:64:0x01de, B:65:0x01ef, B:67:0x01f3, B:69:0x0200, B:71:0x0219, B:72:0x0250, B:74:0x0256, B:76:0x025c, B:77:0x0273, B:79:0x027d, B:80:0x028a, B:81:0x029c, B:83:0x02a2, B:89:0x02b8, B:92:0x02e3, B:94:0x0306, B:96:0x0313, B:98:0x031f, B:99:0x0332, B:101:0x0338, B:103:0x034a, B:105:0x0350, B:106:0x036e, B:107:0x0375, B:109:0x037b, B:110:0x03b3, B:112:0x041a, B:113:0x0434, B:115:0x0442, B:117:0x048d, B:118:0x04c2, B:120:0x04c8, B:122:0x04db, B:123:0x04e8, B:125:0x0534, B:126:0x0542, B:128:0x054a, B:129:0x054d, B:131:0x0555, B:134:0x055e, B:133:0x055b, B:116:0x0478, B:91:0x02bc, B:141:0x05e8, B:37:0x0158, B:39:0x015e, B:40:0x0162, B:42:0x0168, B:43:0x016c, B:45:0x0172, B:46:0x0176, B:48:0x017c), top: B:147:0x007e, inners: #1, #3 }] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ byte[] call() throws Exception {
        byte[] bArr;
        zzks zzksVar;
        String strZzt;
        List<zzkx> listZzu;
        Iterator<zzkx> it;
        zzkx next;
        zzku zzkuVarZzu;
        int i;
        zzap zzapVarZzn;
        zzg zzgVar;
        com.google.android.gms.internal.measurement.zzfv zzfvVar;
        String str;
        Bundle bundle;
        com.google.android.gms.internal.measurement.zzfx zzfxVar;
        byte[] bArr2;
        zzap zzapVarZzc;
        long j;
        com.google.android.gms.internal.measurement.zzfn zzfnVarZze;
        zzaq zzaqVar;
        long jZzn;
        long jZzp;
        this.zzc.zza.zzA();
        zzif zzifVarZzr = this.zzc.zza.zzr();
        zzat zzatVar = this.zza;
        String str2 = this.zzb;
        zzifVarZzr.zzg();
        zzfv.zzO();
        Preconditions.checkNotNull(zzatVar);
        Preconditions.checkNotEmpty(str2);
        if (!zzifVarZzr.zzs.zzf().zzs(str2, zzdy.zzU)) {
            zzifVarZzr.zzs.zzay().zzc().zzb("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        }
        if (!"_iap".equals(zzatVar.zza) && !"_iapx".equals(zzatVar.zza)) {
            zzifVarZzr.zzs.zzay().zzc().zzc("Generating a payload for this event is not available. package_name, event_name", str2, zzatVar.zza);
            return null;
        }
        com.google.android.gms.internal.measurement.zzfv zzfvVarZza = com.google.android.gms.internal.measurement.zzfw.zza();
        zzifVarZzr.zzf.zzi().zzw();
        try {
            zzg zzgVarZzj = zzifVarZzr.zzf.zzi().zzj(str2);
            if (zzgVarZzj == null) {
                zzifVarZzr.zzs.zzay().zzc().zzb("Log and bundle not available. package_name", str2);
                bArr = new byte[0];
                zzksVar = zzifVarZzr.zzf;
            } else if (zzgVarZzj.zzaj()) {
                com.google.android.gms.internal.measurement.zzfx zzfxVarZzu = com.google.android.gms.internal.measurement.zzfy.zzu();
                zzfxVarZzu.zzaa(1);
                zzfxVarZzu.zzW(Constants.PLATFORM);
                if (!TextUtils.isEmpty(zzgVarZzj.zzt())) {
                    zzfxVarZzu.zzA(zzgVarZzj.zzt());
                }
                if (!TextUtils.isEmpty(zzgVarZzj.zzv())) {
                    zzfxVarZzu.zzC((String) Preconditions.checkNotNull(zzgVarZzj.zzv()));
                }
                if (!TextUtils.isEmpty(zzgVarZzj.zzw())) {
                    zzfxVarZzu.zzD((String) Preconditions.checkNotNull(zzgVarZzj.zzw()));
                }
                if (zzgVarZzj.zzb() != -2147483648L) {
                    zzfxVarZzu.zzE((int) zzgVarZzj.zzb());
                }
                zzfxVarZzu.zzS(zzgVarZzj.zzm());
                zzfxVarZzu.zzM(zzgVarZzj.zzk());
                String strZzz = zzgVarZzj.zzz();
                String strZzr = zzgVarZzj.zzr();
                zzom.zzc();
                if (zzifVarZzr.zzs.zzf().zzs(zzgVarZzj.zzt(), zzdy.zzac)) {
                    String strZzy = zzgVarZzj.zzy();
                    if (!TextUtils.isEmpty(strZzz)) {
                        zzfxVarZzu.zzR(strZzz);
                    } else if (!TextUtils.isEmpty(strZzy)) {
                        zzfxVarZzu.zzQ(strZzy);
                    } else if (!TextUtils.isEmpty(strZzr)) {
                        zzfxVarZzu.zzy(strZzr);
                    }
                } else if (!TextUtils.isEmpty(strZzz)) {
                    zzfxVarZzu.zzR(strZzz);
                } else if (!TextUtils.isEmpty(strZzr)) {
                    zzfxVarZzu.zzy(strZzr);
                }
                zzag zzagVarZzh = zzifVarZzr.zzf.zzh(str2);
                zzfxVarZzu.zzJ(zzgVarZzj.zzj());
                if (zzifVarZzr.zzs.zzJ() && zzifVarZzr.zzs.zzf().zzt(zzfxVarZzu.zzal()) && zzagVarZzh.zzj() && !TextUtils.isEmpty(null)) {
                    zzfxVarZzu.zzL(null);
                }
                zzfxVarZzu.zzI(zzagVarZzh.zzi());
                if (zzagVarZzh.zzj()) {
                    Pair<String, Boolean> pairZzd = zzifVarZzr.zzf.zzs().zzd(zzgVarZzj.zzt(), zzagVarZzh);
                    if (!zzgVarZzj.zzai() || TextUtils.isEmpty((CharSequence) pairZzd.first)) {
                        zzifVarZzr.zzs.zzg().zzu();
                        zzfxVarZzu.zzK(Build.MODEL);
                        zzifVarZzr.zzs.zzg().zzu();
                        zzfxVarZzu.zzV(Build.VERSION.RELEASE);
                        zzfxVarZzu.zzaf((int) zzifVarZzr.zzs.zzg().zzb());
                        zzfxVarZzu.zzaj(zzifVarZzr.zzs.zzg().zzc());
                        try {
                            if (zzagVarZzh.zzk() && zzgVarZzj.zzu() != null) {
                                zzfxVarZzu.zzB(zzif.zza((String) Preconditions.checkNotNull(zzgVarZzj.zzu()), Long.toString(zzatVar.zzd)));
                            }
                            if (!TextUtils.isEmpty(zzgVarZzj.zzx())) {
                                zzfxVarZzu.zzP((String) Preconditions.checkNotNull(zzgVarZzj.zzx()));
                            }
                            strZzt = zzgVarZzj.zzt();
                            listZzu = zzifVarZzr.zzf.zzi().zzu(strZzt);
                            it = listZzu.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it.next();
                                if ("_lte".equals(next.zzc)) {
                                    break;
                                }
                            }
                            if (next != null || next.zze == null) {
                                zzkx zzkxVar = new zzkx(strZzt, "auto", "_lte", zzifVarZzr.zzs.zzav().currentTimeMillis(), 0L);
                                listZzu.add(zzkxVar);
                                zzifVarZzr.zzf.zzi().zzN(zzkxVar);
                            }
                            zzkuVarZzu = zzifVarZzr.zzf.zzu();
                            zzkuVarZzu.zzs.zzay().zzj().zza("Checking account type status for ad personalization signals");
                            if (zzkuVarZzu.zzs.zzg().zze()) {
                                String strZzt2 = zzgVarZzj.zzt();
                                Preconditions.checkNotNull(strZzt2);
                                if (zzgVarZzj.zzai() && zzkuVarZzu.zzf.zzo().zzk(strZzt2)) {
                                    zzkuVarZzu.zzs.zzay().zzc().zza("Turning off ad personalization due to account type");
                                    Iterator<zzkx> it2 = listZzu.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        if ("_npa".equals(it2.next().zzc)) {
                                            it2.remove();
                                            break;
                                        }
                                    }
                                    listZzu.add(new zzkx(strZzt2, "auto", "_npa", zzkuVarZzu.zzs.zzav().currentTimeMillis(), 1L));
                                }
                            }
                            com.google.android.gms.internal.measurement.zzgh[] zzghVarArr = new com.google.android.gms.internal.measurement.zzgh[listZzu.size()];
                            for (i = 0; i < listZzu.size(); i++) {
                                com.google.android.gms.internal.measurement.zzgg zzggVarZzd = com.google.android.gms.internal.measurement.zzgh.zzd();
                                zzggVarZzd.zzf(listZzu.get(i).zzc);
                                zzggVarZzd.zzg(listZzu.get(i).zzd);
                                zzifVarZzr.zzf.zzu().zzv(zzggVarZzd, listZzu.get(i).zze);
                                zzghVarArr[i] = zzggVarZzd.zzaA();
                            }
                            zzfxVarZzu.zzi(Arrays.asList(zzghVarArr));
                            zzem zzemVarZzb = zzem.zzb(zzatVar);
                            zzifVarZzr.zzs.zzv().zzK(zzemVarZzb.zzd, zzifVarZzr.zzf.zzi().zzi(str2));
                            zzifVarZzr.zzs.zzv().zzL(zzemVarZzb, zzifVarZzr.zzs.zzf().zzd(str2));
                            Bundle bundle2 = zzemVarZzb.zzd;
                            bundle2.putLong("_c", 1L);
                            zzifVarZzr.zzs.zzay().zzc().zza("Marking in-app purchase as real-time");
                            bundle2.putLong("_r", 1L);
                            bundle2.putString("_o", zzatVar.zzc);
                            if (zzifVarZzr.zzs.zzv().zzad(zzfxVarZzu.zzal())) {
                                zzifVarZzr.zzs.zzv().zzN(bundle2, "_dbg", 1L);
                                zzifVarZzr.zzs.zzv().zzN(bundle2, "_r", 1L);
                            }
                            zzapVarZzn = zzifVarZzr.zzf.zzi().zzn(str2, zzatVar.zza);
                            if (zzapVarZzn != null) {
                                zzfxVar = zzfxVarZzu;
                                zzgVar = zzgVarZzj;
                                zzfvVar = zzfvVarZza;
                                str = str2;
                                bundle = bundle2;
                                bArr2 = null;
                                zzapVarZzc = new zzap(str2, zzatVar.zza, 0L, 0L, 0L, zzatVar.zzd, 0L, null, null, null, null);
                                j = 0;
                            } else {
                                zzgVar = zzgVarZzj;
                                zzfvVar = zzfvVarZza;
                                str = str2;
                                bundle = bundle2;
                                zzfxVar = zzfxVarZzu;
                                bArr2 = null;
                                long j2 = zzapVarZzn.zzf;
                                zzapVarZzc = zzapVarZzn.zzc(zzatVar.zzd);
                                j = j2;
                            }
                            zzifVarZzr.zzf.zzi().zzF(zzapVarZzc);
                            zzao zzaoVar = new zzao(zzifVarZzr.zzs, zzatVar.zzc, str, zzatVar.zza, zzatVar.zzd, j, bundle);
                            zzfnVarZze = com.google.android.gms.internal.measurement.zzfo.zze();
                            zzfnVarZze.zzm(zzaoVar.zzd);
                            zzfnVarZze.zzi(zzaoVar.zzb);
                            zzfnVarZze.zzl(zzaoVar.zze);
                            zzaqVar = new zzaq(zzaoVar.zzf);
                            while (zzaqVar.hasNext()) {
                                String next2 = zzaqVar.next();
                                com.google.android.gms.internal.measurement.zzfr zzfrVarZze = com.google.android.gms.internal.measurement.zzfs.zze();
                                zzfrVarZze.zzj(next2);
                                Object objZzf = zzaoVar.zzf.zzf(next2);
                                if (objZzf != null) {
                                    zzifVarZzr.zzf.zzu().zzu(zzfrVarZze, objZzf);
                                    zzfnVarZze.zze(zzfrVarZze);
                                }
                            }
                            com.google.android.gms.internal.measurement.zzfx zzfxVar2 = zzfxVar;
                            zzfxVar2.zzj(zzfnVarZze);
                            com.google.android.gms.internal.measurement.zzfz zzfzVarZza = com.google.android.gms.internal.measurement.zzgb.zza();
                            com.google.android.gms.internal.measurement.zzfp zzfpVarZza = com.google.android.gms.internal.measurement.zzfq.zza();
                            zzfpVarZza.zza(zzapVarZzc.zzc);
                            zzfpVarZza.zzb(zzatVar.zza);
                            zzfzVarZza.zza(zzfpVarZza);
                            zzfxVar2.zzX(zzfzVarZza);
                            zzfxVar2.zzf(zzifVarZzr.zzf.zzf().zza(zzgVar.zzt(), Collections.emptyList(), zzfxVar2.zzap(), Long.valueOf(zzfnVarZze.zzc()), Long.valueOf(zzfnVarZze.zzc())));
                            if (zzfnVarZze.zzq()) {
                                zzfxVar2.zzae(zzfnVarZze.zzc());
                                zzfxVar2.zzN(zzfnVarZze.zzc());
                            }
                            jZzn = zzgVar.zzn();
                            if (jZzn != 0) {
                                zzfxVar2.zzY(jZzn);
                            }
                            jZzp = zzgVar.zzp();
                            if (jZzp == 0) {
                                zzfxVar2.zzZ(jZzp);
                            } else if (jZzn != 0) {
                                zzfxVar2.zzZ(jZzn);
                            }
                            zzgVar.zzE();
                            zzfxVar2.zzF((int) zzgVar.zzo());
                            zzifVarZzr.zzs.zzf().zzh();
                            zzfxVar2.zzah(46000L);
                            zzfxVar2.zzag(zzifVarZzr.zzs.zzav().currentTimeMillis());
                            Boolean bool = Boolean.TRUE;
                            zzfxVar2.zzad(true);
                            com.google.android.gms.internal.measurement.zzfv zzfvVar2 = zzfvVar;
                            zzfvVar2.zza(zzfxVar2);
                            zzg zzgVar2 = zzgVar;
                            zzgVar2.zzad(zzfxVar2.zzd());
                            zzgVar2.zzab(zzfxVar2.zzc());
                            zzifVarZzr.zzf.zzi().zzE(zzgVar2);
                            zzifVarZzr.zzf.zzi().zzD();
                            try {
                                return zzifVarZzr.zzf.zzu().zzz(zzfvVar2.zzaA().zzbs());
                            } catch (IOException e) {
                                zzifVarZzr.zzs.zzay().zzd().zzc("Data loss. Failed to bundle and serialize. appId", zzel.zzn(str), e);
                                return bArr2;
                            }
                        } catch (SecurityException e2) {
                            zzifVarZzr.zzs.zzay().zzc().zzb("app instance id encryption failed", e2.getMessage());
                            bArr = new byte[0];
                            zzksVar = zzifVarZzr.zzf;
                        }
                    } else {
                        try {
                            zzfxVarZzu.zzab(zzif.zza((String) pairZzd.first, Long.toString(zzatVar.zzd)));
                            if (pairZzd.second != null) {
                                zzfxVarZzu.zzU(((Boolean) pairZzd.second).booleanValue());
                            }
                            zzifVarZzr.zzs.zzg().zzu();
                            zzfxVarZzu.zzK(Build.MODEL);
                            zzifVarZzr.zzs.zzg().zzu();
                            zzfxVarZzu.zzV(Build.VERSION.RELEASE);
                            zzfxVarZzu.zzaf((int) zzifVarZzr.zzs.zzg().zzb());
                            zzfxVarZzu.zzaj(zzifVarZzr.zzs.zzg().zzc());
                            if (zzagVarZzh.zzk()) {
                                zzfxVarZzu.zzB(zzif.zza((String) Preconditions.checkNotNull(zzgVarZzj.zzu()), Long.toString(zzatVar.zzd)));
                            }
                            if (!TextUtils.isEmpty(zzgVarZzj.zzx())) {
                            }
                            strZzt = zzgVarZzj.zzt();
                            listZzu = zzifVarZzr.zzf.zzi().zzu(strZzt);
                            it = listZzu.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                }
                            }
                            if (next != null) {
                                zzkx zzkxVar2 = new zzkx(strZzt, "auto", "_lte", zzifVarZzr.zzs.zzav().currentTimeMillis(), 0L);
                                listZzu.add(zzkxVar2);
                                zzifVarZzr.zzf.zzi().zzN(zzkxVar2);
                            }
                            zzkuVarZzu = zzifVarZzr.zzf.zzu();
                            zzkuVarZzu.zzs.zzay().zzj().zza("Checking account type status for ad personalization signals");
                            if (zzkuVarZzu.zzs.zzg().zze()) {
                            }
                            com.google.android.gms.internal.measurement.zzgh[] zzghVarArr2 = new com.google.android.gms.internal.measurement.zzgh[listZzu.size()];
                            while (i < listZzu.size()) {
                            }
                            zzfxVarZzu.zzi(Arrays.asList(zzghVarArr2));
                            zzem zzemVarZzb2 = zzem.zzb(zzatVar);
                            zzifVarZzr.zzs.zzv().zzK(zzemVarZzb2.zzd, zzifVarZzr.zzf.zzi().zzi(str2));
                            zzifVarZzr.zzs.zzv().zzL(zzemVarZzb2, zzifVarZzr.zzs.zzf().zzd(str2));
                            Bundle bundle22 = zzemVarZzb2.zzd;
                            bundle22.putLong("_c", 1L);
                            zzifVarZzr.zzs.zzay().zzc().zza("Marking in-app purchase as real-time");
                            bundle22.putLong("_r", 1L);
                            bundle22.putString("_o", zzatVar.zzc);
                            if (zzifVarZzr.zzs.zzv().zzad(zzfxVarZzu.zzal())) {
                            }
                            zzapVarZzn = zzifVarZzr.zzf.zzi().zzn(str2, zzatVar.zza);
                            if (zzapVarZzn != null) {
                            }
                            zzifVarZzr.zzf.zzi().zzF(zzapVarZzc);
                            zzao zzaoVar2 = new zzao(zzifVarZzr.zzs, zzatVar.zzc, str, zzatVar.zza, zzatVar.zzd, j, bundle);
                            zzfnVarZze = com.google.android.gms.internal.measurement.zzfo.zze();
                            zzfnVarZze.zzm(zzaoVar2.zzd);
                            zzfnVarZze.zzi(zzaoVar2.zzb);
                            zzfnVarZze.zzl(zzaoVar2.zze);
                            zzaqVar = new zzaq(zzaoVar2.zzf);
                            while (zzaqVar.hasNext()) {
                            }
                            com.google.android.gms.internal.measurement.zzfx zzfxVar22 = zzfxVar;
                            zzfxVar22.zzj(zzfnVarZze);
                            com.google.android.gms.internal.measurement.zzfz zzfzVarZza2 = com.google.android.gms.internal.measurement.zzgb.zza();
                            com.google.android.gms.internal.measurement.zzfp zzfpVarZza2 = com.google.android.gms.internal.measurement.zzfq.zza();
                            zzfpVarZza2.zza(zzapVarZzc.zzc);
                            zzfpVarZza2.zzb(zzatVar.zza);
                            zzfzVarZza2.zza(zzfpVarZza2);
                            zzfxVar22.zzX(zzfzVarZza2);
                            zzfxVar22.zzf(zzifVarZzr.zzf.zzf().zza(zzgVar.zzt(), Collections.emptyList(), zzfxVar22.zzap(), Long.valueOf(zzfnVarZze.zzc()), Long.valueOf(zzfnVarZze.zzc())));
                            if (zzfnVarZze.zzq()) {
                            }
                            jZzn = zzgVar.zzn();
                            if (jZzn != 0) {
                            }
                            jZzp = zzgVar.zzp();
                            if (jZzp == 0) {
                            }
                            zzgVar.zzE();
                            zzfxVar22.zzF((int) zzgVar.zzo());
                            zzifVarZzr.zzs.zzf().zzh();
                            zzfxVar22.zzah(46000L);
                            zzfxVar22.zzag(zzifVarZzr.zzs.zzav().currentTimeMillis());
                            Boolean bool2 = Boolean.TRUE;
                            zzfxVar22.zzad(true);
                            com.google.android.gms.internal.measurement.zzfv zzfvVar22 = zzfvVar;
                            zzfvVar22.zza(zzfxVar22);
                            zzg zzgVar22 = zzgVar;
                            zzgVar22.zzad(zzfxVar22.zzd());
                            zzgVar22.zzab(zzfxVar22.zzc());
                            zzifVarZzr.zzf.zzi().zzE(zzgVar22);
                            zzifVarZzr.zzf.zzi().zzD();
                            return zzifVarZzr.zzf.zzu().zzz(zzfvVar22.zzaA().zzbs());
                        } catch (SecurityException e3) {
                            zzifVarZzr.zzs.zzay().zzc().zzb("Resettable device id encryption failed", e3.getMessage());
                            bArr = new byte[0];
                            zzksVar = zzifVarZzr.zzf;
                        }
                    }
                }
            } else {
                zzifVarZzr.zzs.zzay().zzc().zzb("Log and bundle disabled. package_name", str2);
                bArr = new byte[0];
                zzksVar = zzifVarZzr.zzf;
            }
            zzksVar.zzi().zzy();
            return bArr;
        } finally {
            zzifVarZzr.zzf.zzi().zzy();
        }
    }
}
