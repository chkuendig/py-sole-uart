package com.sun.jna.platform.win32;

import androidx.collection.SieveCacheKt;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.WinDef;

/* loaded from: classes4.dex */
public interface Tlhelp32 {
    public static final int MAX_MODULE_NAME32 = 255;
    public static final WinDef.DWORD TH32CS_SNAPALL;
    public static final WinDef.DWORD TH32CS_SNAPHEAPLIST = new WinDef.DWORD(1);
    public static final WinDef.DWORD TH32CS_SNAPPROCESS = new WinDef.DWORD(2);
    public static final WinDef.DWORD TH32CS_SNAPTHREAD = new WinDef.DWORD(4);
    public static final WinDef.DWORD TH32CS_SNAPMODULE = new WinDef.DWORD(8);
    public static final WinDef.DWORD TH32CS_SNAPMODULE32 = new WinDef.DWORD(16);
    public static final WinDef.DWORD TH32CS_INHERIT = new WinDef.DWORD(SieveCacheKt.NodeMetaAndPreviousMask);

    static {
        TH32CS_SNAPALL = new WinDef.DWORD(r0.intValue() | r1.intValue() | r2.intValue() | r3.intValue());
    }

    @Structure.FieldOrder({"dwSize", "cntUsage", "th32ProcessID", "th32DefaultHeapID", "th32ModuleID", "cntThreads", "th32ParentProcessID", "pcPriClassBase", "dwFlags", "szExeFile"})
    public static class PROCESSENTRY32 extends Structure {
        public WinDef.DWORD cntThreads;
        public WinDef.DWORD cntUsage;
        public WinDef.DWORD dwFlags;
        public WinDef.DWORD dwSize;
        public WinDef.LONG pcPriClassBase;
        public char[] szExeFile;
        public BaseTSD.ULONG_PTR th32DefaultHeapID;
        public WinDef.DWORD th32ModuleID;
        public WinDef.DWORD th32ParentProcessID;
        public WinDef.DWORD th32ProcessID;

        public static class ByReference extends PROCESSENTRY32 implements Structure.ByReference {
            public ByReference() {
            }

            public ByReference(Pointer pointer) {
                super(pointer);
            }
        }

        public PROCESSENTRY32() {
            this.szExeFile = new char[260];
            this.dwSize = new WinDef.DWORD(size());
        }

        public PROCESSENTRY32(Pointer pointer) {
            super(pointer);
            this.szExeFile = new char[260];
            read();
        }
    }

    @Structure.FieldOrder({"dwSize", "cntUsage", "th32ThreadID", "th32OwnerProcessID", "tpBasePri", "tpDeltaPri", "dwFlags"})
    public static class THREADENTRY32 extends Structure {
        public int cntUsage;
        public int dwFlags;
        public int dwSize;
        public int th32OwnerProcessID;
        public int th32ThreadID;
        public NativeLong tpBasePri;
        public NativeLong tpDeltaPri;

        public static class ByReference extends THREADENTRY32 implements Structure.ByReference {
            public ByReference() {
            }

            public ByReference(Pointer pointer) {
                super(pointer);
            }
        }

        public THREADENTRY32() {
            this.dwSize = size();
        }

        public THREADENTRY32(Pointer pointer) {
            super(pointer);
            read();
        }
    }

    @Structure.FieldOrder({"dwSize", "th32ModuleID", "th32ProcessID", "GlblcntUsage", "ProccntUsage", "modBaseAddr", "modBaseSize", "hModule", "szModule", "szExePath"})
    public static class MODULEENTRY32W extends Structure {
        public WinDef.DWORD GlblcntUsage;
        public WinDef.DWORD ProccntUsage;
        public WinDef.DWORD dwSize;
        public WinDef.HMODULE hModule;
        public Pointer modBaseAddr;
        public WinDef.DWORD modBaseSize;
        public char[] szExePath;
        public char[] szModule;
        public WinDef.DWORD th32ModuleID;
        public WinDef.DWORD th32ProcessID;

        public static class ByReference extends MODULEENTRY32W implements Structure.ByReference {
            public ByReference() {
            }

            public ByReference(Pointer pointer) {
                super(pointer);
            }
        }

        public MODULEENTRY32W() {
            this.szModule = new char[256];
            this.szExePath = new char[260];
            this.dwSize = new WinDef.DWORD(size());
        }

        public MODULEENTRY32W(Pointer pointer) {
            super(pointer);
            this.szModule = new char[256];
            this.szExePath = new char[260];
            read();
        }

        public String szModule() {
            return Native.toString(this.szModule);
        }

        public String szExePath() {
            return Native.toString(this.szExePath);
        }
    }
}
