package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzak {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081 A[Catch: SQLiteException -> 0x00ec, TryCatch #3 {SQLiteException -> 0x00ec, blocks: (B:21:0x0046, B:23:0x0072, B:25:0x0081, B:27:0x0089, B:28:0x008c, B:29:0x00b9, B:31:0x00bc, B:33:0x00bf, B:35:0x00c7, B:36:0x00ce, B:37:0x00d1, B:39:0x00d7, B:42:0x00e8, B:43:0x00eb, B:22:0x006b), top: B:58:0x0046, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bc A[Catch: SQLiteException -> 0x00ec, LOOP:1: B:31:0x00bc->B:36:0x00ce, LOOP_START, PHI: r12
      0x00bc: PHI (r12v1 int) = (r12v0 int), (r12v2 int) binds: [B:30:0x00ba, B:36:0x00ce] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {SQLiteException -> 0x00ec, blocks: (B:21:0x0046, B:23:0x0072, B:25:0x0081, B:27:0x0089, B:28:0x008c, B:29:0x00b9, B:31:0x00bc, B:33:0x00bf, B:35:0x00c7, B:36:0x00ce, B:37:0x00d1, B:39:0x00d7, B:42:0x00e8, B:43:0x00eb, B:22:0x006b), top: B:58:0x0046, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7 A[Catch: SQLiteException -> 0x00ec, TryCatch #3 {SQLiteException -> 0x00ec, blocks: (B:21:0x0046, B:23:0x0072, B:25:0x0081, B:27:0x0089, B:28:0x008c, B:29:0x00b9, B:31:0x00bc, B:33:0x00bf, B:35:0x00c7, B:36:0x00ce, B:37:0x00d1, B:39:0x00d7, B:42:0x00e8, B:43:0x00eb, B:22:0x006b), top: B:58:0x0046, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void zza(zzel zzelVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        HashSet hashSet;
        Cursor cursorRawQuery;
        boolean zMoveToFirst;
        if (zzelVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        ?? r13 = 0;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    zMoveToFirst = cursorQuery.moveToFirst();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzelVar.zzk().zzc("Error querying for table", str, e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    sQLiteDatabase.execSQL(str2);
                    hashSet = new HashSet();
                    StringBuilder sb = new StringBuilder(str.length() + 22);
                    sb.append("SELECT * FROM ");
                    sb.append(str);
                    sb.append(" LIMIT 0");
                    cursorRawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                    try {
                        Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
                        cursorRawQuery.close();
                        while (i < r2) {
                        }
                        if (strArr != null) {
                        }
                        if (hashSet.isEmpty()) {
                        }
                    } catch (Throwable th) {
                        cursorRawQuery.close();
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r13 = str2;
                if (r13 != 0) {
                    r13.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (r13 != 0) {
            }
            throw th;
        }
        if (!zMoveToFirst) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            hashSet = new HashSet();
            StringBuilder sb2 = new StringBuilder(str.length() + 22);
            sb2.append("SELECT * FROM ");
            sb2.append(str);
            sb2.append(" LIMIT 0");
            cursorRawQuery = sQLiteDatabase.rawQuery(sb2.toString(), null);
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            cursorRawQuery.close();
            for (String str4 : str3.split(",")) {
                if (!hashSet.remove(str4)) {
                    StringBuilder sb3 = new StringBuilder(str.length() + 35 + String.valueOf(str4).length());
                    sb3.append("Table ");
                    sb3.append(str);
                    sb3.append(" is missing required column: ");
                    sb3.append(str4);
                    throw new SQLiteException(sb3.toString());
                }
            }
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i += 2) {
                    if (!hashSet.remove(strArr[i])) {
                        sQLiteDatabase.execSQL(strArr[i + 1]);
                    }
                }
            }
            if (hashSet.isEmpty()) {
                zzelVar.zzk().zzc("Table has extra columns. table, columns", str, TextUtils.join(", ", hashSet));
            }
        } catch (SQLiteException e3) {
            zzelVar.zzd().zzb("Failed to verify columns on table that was just created", str);
            throw e3;
        }
    }

    static void zzb(zzel zzelVar, SQLiteDatabase sQLiteDatabase) {
        if (zzelVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzelVar.zzk().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzelVar.zzk().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzelVar.zzk().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzelVar.zzk().zza("Failed to turn on database write permission for owner");
    }
}
