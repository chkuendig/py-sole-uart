package com.sun.jna.platform.win32;

import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.Winspool;
import com.sun.jna.ptr.IntByReference;

/* loaded from: classes4.dex */
public abstract class WinspoolUtil {
    public static Winspool.PRINTER_INFO_1[] getPrinterInfo1() {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        Winspool.INSTANCE.EnumPrinters(2, null, 1, null, 0, intByReference, intByReference2);
        if (intByReference.getValue() <= 0) {
            return new Winspool.PRINTER_INFO_1[0];
        }
        Winspool.PRINTER_INFO_1 printer_info_1 = new Winspool.PRINTER_INFO_1(intByReference.getValue());
        if (!Winspool.INSTANCE.EnumPrinters(2, null, 1, printer_info_1.getPointer(), intByReference.getValue(), intByReference, intByReference2)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        printer_info_1.read();
        return (Winspool.PRINTER_INFO_1[]) printer_info_1.toArray(intByReference2.getValue());
    }

    public static Winspool.PRINTER_INFO_2[] getPrinterInfo2() {
        return getPrinterInfo2(2);
    }

    public static Winspool.PRINTER_INFO_2[] getAllPrinterInfo2() {
        return getPrinterInfo2(6);
    }

    private static Winspool.PRINTER_INFO_2[] getPrinterInfo2(int i) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        Winspool.INSTANCE.EnumPrinters(i, null, 2, null, 0, intByReference, intByReference2);
        if (intByReference.getValue() <= 0) {
            return new Winspool.PRINTER_INFO_2[0];
        }
        Winspool.PRINTER_INFO_2 printer_info_2 = new Winspool.PRINTER_INFO_2(intByReference.getValue());
        if (!Winspool.INSTANCE.EnumPrinters(i, null, 2, printer_info_2.getPointer(), intByReference.getValue(), intByReference, intByReference2)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        printer_info_2.read();
        return (Winspool.PRINTER_INFO_2[]) printer_info_2.toArray(intByReference2.getValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.sun.jna.platform.win32.Winspool.PRINTER_INFO_2 getPrinterInfo2(java.lang.String r11) {
        /*
            com.sun.jna.ptr.IntByReference r6 = new com.sun.jna.ptr.IntByReference
            r6.<init>()
            com.sun.jna.ptr.IntByReference r7 = new com.sun.jna.ptr.IntByReference
            r7.<init>()
            com.sun.jna.platform.win32.WinNT$HANDLEByReference r8 = new com.sun.jna.platform.win32.WinNT$HANDLEByReference
            r8.<init>()
            com.sun.jna.platform.win32.Winspool r0 = com.sun.jna.platform.win32.Winspool.INSTANCE
            r9 = 0
            boolean r11 = r0.OpenPrinter(r11, r8, r9)
            if (r11 == 0) goto Lcc
            com.sun.jna.platform.win32.Winspool r0 = com.sun.jna.platform.win32.Winspool.INSTANCE     // Catch: java.lang.Throwable -> L91 com.sun.jna.platform.win32.Win32Exception -> Laa
            com.sun.jna.platform.win32.WinNT$HANDLE r1 = r8.getValue()     // Catch: java.lang.Throwable -> L91 com.sun.jna.platform.win32.Win32Exception -> Laa
            r3 = 0
            r4 = 0
            r2 = 2
            r5 = r6
            r0.GetPrinter(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L91 com.sun.jna.platform.win32.Win32Exception -> Laa
            int r11 = r6.getValue()     // Catch: java.lang.Throwable -> L91 com.sun.jna.platform.win32.Win32Exception -> Laa
            if (r11 > 0) goto L48
            com.sun.jna.platform.win32.Winspool$PRINTER_INFO_2 r11 = new com.sun.jna.platform.win32.Winspool$PRINTER_INFO_2     // Catch: java.lang.Throwable -> L91 com.sun.jna.platform.win32.Win32Exception -> Laa
            r11.<init>()     // Catch: java.lang.Throwable -> L91 com.sun.jna.platform.win32.Win32Exception -> Laa
            com.sun.jna.platform.win32.Winspool r0 = com.sun.jna.platform.win32.Winspool.INSTANCE
            com.sun.jna.platform.win32.WinNT$HANDLE r1 = r8.getValue()
            boolean r0 = r0.ClosePrinter(r1)
            if (r0 != 0) goto L47
            com.sun.jna.platform.win32.Win32Exception r0 = new com.sun.jna.platform.win32.Win32Exception
            com.sun.jna.platform.win32.Kernel32 r1 = com.sun.jna.platform.win32.Kernel32.INSTANCE
            int r1 = r1.GetLastError()
            r0.<init>(r1)
        L47:
            return r11
        L48:
            com.sun.jna.platform.win32.Winspool$PRINTER_INFO_2 r11 = new com.sun.jna.platform.win32.Winspool$PRINTER_INFO_2     // Catch: java.lang.Throwable -> L91 com.sun.jna.platform.win32.Win32Exception -> Laa
            int r0 = r6.getValue()     // Catch: java.lang.Throwable -> L91 com.sun.jna.platform.win32.Win32Exception -> Laa
            r11.<init>(r0)     // Catch: java.lang.Throwable -> L91 com.sun.jna.platform.win32.Win32Exception -> Laa
            com.sun.jna.platform.win32.Winspool r0 = com.sun.jna.platform.win32.Winspool.INSTANCE     // Catch: com.sun.jna.platform.win32.Win32Exception -> L8e java.lang.Throwable -> L91
            com.sun.jna.platform.win32.WinNT$HANDLE r1 = r8.getValue()     // Catch: com.sun.jna.platform.win32.Win32Exception -> L8e java.lang.Throwable -> L91
            com.sun.jna.Pointer r3 = r11.getPointer()     // Catch: com.sun.jna.platform.win32.Win32Exception -> L8e java.lang.Throwable -> L91
            int r4 = r6.getValue()     // Catch: com.sun.jna.platform.win32.Win32Exception -> L8e java.lang.Throwable -> L91
            r2 = 2
            r5 = r7
            boolean r0 = r0.GetPrinter(r1, r2, r3, r4, r5)     // Catch: com.sun.jna.platform.win32.Win32Exception -> L8e java.lang.Throwable -> L91
            if (r0 == 0) goto L82
            r11.read()     // Catch: com.sun.jna.platform.win32.Win32Exception -> L8e java.lang.Throwable -> L91
            com.sun.jna.platform.win32.Winspool r0 = com.sun.jna.platform.win32.Winspool.INSTANCE
            com.sun.jna.platform.win32.WinNT$HANDLE r1 = r8.getValue()
            boolean r0 = r0.ClosePrinter(r1)
            if (r0 != 0) goto Lc8
            com.sun.jna.platform.win32.Win32Exception r0 = new com.sun.jna.platform.win32.Win32Exception
            com.sun.jna.platform.win32.Kernel32 r1 = com.sun.jna.platform.win32.Kernel32.INSTANCE
            int r1 = r1.GetLastError()
            r0.<init>(r1)
            goto Lc8
        L82:
            com.sun.jna.platform.win32.Win32Exception r0 = new com.sun.jna.platform.win32.Win32Exception     // Catch: com.sun.jna.platform.win32.Win32Exception -> L8e java.lang.Throwable -> L91
            com.sun.jna.platform.win32.Kernel32 r1 = com.sun.jna.platform.win32.Kernel32.INSTANCE     // Catch: com.sun.jna.platform.win32.Win32Exception -> L8e java.lang.Throwable -> L91
            int r1 = r1.GetLastError()     // Catch: com.sun.jna.platform.win32.Win32Exception -> L8e java.lang.Throwable -> L91
            r0.<init>(r1)     // Catch: com.sun.jna.platform.win32.Win32Exception -> L8e java.lang.Throwable -> L91
            throw r0     // Catch: com.sun.jna.platform.win32.Win32Exception -> L8e java.lang.Throwable -> L91
        L8e:
            r0 = move-exception
            r9 = r0
            goto Lae
        L91:
            r11 = move-exception
            com.sun.jna.platform.win32.Winspool r0 = com.sun.jna.platform.win32.Winspool.INSTANCE
            com.sun.jna.platform.win32.WinNT$HANDLE r1 = r8.getValue()
            boolean r0 = r0.ClosePrinter(r1)
            if (r0 != 0) goto La9
            com.sun.jna.platform.win32.Win32Exception r0 = new com.sun.jna.platform.win32.Win32Exception
            com.sun.jna.platform.win32.Kernel32 r1 = com.sun.jna.platform.win32.Kernel32.INSTANCE
            int r1 = r1.GetLastError()
            r0.<init>(r1)
        La9:
            throw r11
        Laa:
            r11 = move-exception
            r10 = r9
            r9 = r11
            r11 = r10
        Lae:
            com.sun.jna.platform.win32.Winspool r0 = com.sun.jna.platform.win32.Winspool.INSTANCE
            com.sun.jna.platform.win32.WinNT$HANDLE r1 = r8.getValue()
            boolean r0 = r0.ClosePrinter(r1)
            if (r0 != 0) goto Lc8
            com.sun.jna.platform.win32.Win32Exception r0 = new com.sun.jna.platform.win32.Win32Exception
            com.sun.jna.platform.win32.Kernel32 r1 = com.sun.jna.platform.win32.Kernel32.INSTANCE
            int r1 = r1.GetLastError()
            r0.<init>(r1)
            r0.addSuppressedReflected(r9)
        Lc8:
            if (r9 != 0) goto Lcb
            return r11
        Lcb:
            throw r9
        Lcc:
            com.sun.jna.platform.win32.Win32Exception r11 = new com.sun.jna.platform.win32.Win32Exception
            com.sun.jna.platform.win32.Kernel32 r0 = com.sun.jna.platform.win32.Kernel32.INSTANCE
            int r0 = r0.GetLastError()
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.platform.win32.WinspoolUtil.getPrinterInfo2(java.lang.String):com.sun.jna.platform.win32.Winspool$PRINTER_INFO_2");
    }

    public static Winspool.PRINTER_INFO_4[] getPrinterInfo4() {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        Winspool.INSTANCE.EnumPrinters(2, null, 4, null, 0, intByReference, intByReference2);
        if (intByReference.getValue() <= 0) {
            return new Winspool.PRINTER_INFO_4[0];
        }
        Winspool.PRINTER_INFO_4 printer_info_4 = new Winspool.PRINTER_INFO_4(intByReference.getValue());
        if (!Winspool.INSTANCE.EnumPrinters(2, null, 4, printer_info_4.getPointer(), intByReference.getValue(), intByReference, intByReference2)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        printer_info_4.read();
        return (Winspool.PRINTER_INFO_4[]) printer_info_4.toArray(intByReference2.getValue());
    }

    public static Winspool.JOB_INFO_1[] getJobInfo1(WinNT.HANDLEByReference hANDLEByReference) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        Winspool.INSTANCE.EnumJobs(hANDLEByReference.getValue(), 0, 255, 1, null, 0, intByReference, intByReference2);
        if (intByReference.getValue() <= 0) {
            return new Winspool.JOB_INFO_1[0];
        }
        Winspool.JOB_INFO_1 job_info_1 = new Winspool.JOB_INFO_1(intByReference.getValue());
        if (!Winspool.INSTANCE.EnumJobs(hANDLEByReference.getValue(), 0, 255, 1, job_info_1.getPointer(), intByReference.getValue(), intByReference, intByReference2)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        job_info_1.read();
        return (Winspool.JOB_INFO_1[]) job_info_1.toArray(intByReference2.getValue());
    }
}
