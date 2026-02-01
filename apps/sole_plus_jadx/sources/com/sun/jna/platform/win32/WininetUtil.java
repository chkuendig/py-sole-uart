package com.sun.jna.platform.win32;

/* loaded from: classes4.dex */
public class WininetUtil {
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
    
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
    
        if (r0.hasNext() == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0087, code lost:
    
        r4 = (com.sun.jna.platform.win32.Wininet.INTERNET_CACHE_ENTRY_INFO) r0.next();
        r5 = r4.lpszSourceUrlName.getWideString(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0097, code lost:
    
        if (r4.lpszLocalFileName != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009c, code lost:
    
        r4 = r4.lpszLocalFileName.getWideString(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a2, code lost:
    
        r1.put(r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
    
        if (r3 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a8, code lost:
    
        com.sun.jna.platform.win32.Wininet.INSTANCE.FindCloseUrlCache(r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077 A[Catch: all -> 0x00bd, Win32Exception -> 0x00c0, TryCatch #4 {Win32Exception -> 0x00c0, all -> 0x00bd, blocks: (B:18:0x0044, B:19:0x0047, B:21:0x0054, B:33:0x007d, B:34:0x0081, B:36:0x0087, B:40:0x00a2, B:39:0x009c, B:27:0x0060, B:28:0x0065, B:29:0x0066, B:31:0x0077, B:47:0x00b3, B:48:0x00b8, B:49:0x00b9, B:54:0x00c2, B:55:0x00cb), top: B:77:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00b9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.String> getCache() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.platform.win32.WininetUtil.getCache():java.util.Map");
    }
}
