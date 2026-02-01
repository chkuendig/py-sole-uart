package com.sun.jna.platform.win32.COM;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.PointerByReference;

/* loaded from: classes4.dex */
public class TypeLibUtil {
    public static final OleAuto OLEAUTO = OleAuto.INSTANCE;
    private String docString;
    private int helpContext;
    private String helpFile;
    private WinDef.LCID lcid = Kernel32.INSTANCE.GetUserDefaultLCID();
    private String name;
    private ITypeLib typelib;

    public TypeLibUtil(String str, int i, int i2) {
        Guid.CLSID.ByReference byReference = new Guid.CLSID.ByReference();
        COMUtils.checkRC(Ole32.INSTANCE.CLSIDFromString(str, byReference));
        PointerByReference pointerByReference = new PointerByReference();
        COMUtils.checkRC(OleAuto.INSTANCE.LoadRegTypeLib(byReference, i, i2, this.lcid, pointerByReference));
        this.typelib = new TypeLib(pointerByReference.getValue());
        initTypeLibInfo();
    }

    public TypeLibUtil(String str) {
        PointerByReference pointerByReference = new PointerByReference();
        COMUtils.checkRC(OleAuto.INSTANCE.LoadTypeLib(str, pointerByReference));
        this.typelib = new TypeLib(pointerByReference.getValue());
        initTypeLibInfo();
    }

    private void initTypeLibInfo() {
        TypeLibDoc documentation = getDocumentation(-1);
        this.name = documentation.getName();
        this.docString = documentation.getDocString();
        this.helpContext = documentation.getHelpContext();
        this.helpFile = documentation.getHelpFile();
    }

    public int getTypeInfoCount() {
        return this.typelib.GetTypeInfoCount().intValue();
    }

    public OaIdl.TYPEKIND getTypeInfoType(int i) {
        OaIdl.TYPEKIND.ByReference byReference = new OaIdl.TYPEKIND.ByReference();
        COMUtils.checkRC(this.typelib.GetTypeInfoType(new WinDef.UINT(i), byReference));
        return byReference;
    }

    public ITypeInfo getTypeInfo(int i) {
        PointerByReference pointerByReference = new PointerByReference();
        COMUtils.checkRC(this.typelib.GetTypeInfo(new WinDef.UINT(i), pointerByReference));
        return new TypeInfo(pointerByReference.getValue());
    }

    public TypeInfoUtil getTypeInfoUtil(int i) {
        return new TypeInfoUtil(getTypeInfo(i));
    }

    public OaIdl.TLIBATTR getLibAttr() {
        PointerByReference pointerByReference = new PointerByReference();
        COMUtils.checkRC(this.typelib.GetLibAttr(pointerByReference));
        return new OaIdl.TLIBATTR(pointerByReference.getValue());
    }

    public TypeComp GetTypeComp() {
        PointerByReference pointerByReference = new PointerByReference();
        COMUtils.checkRC(this.typelib.GetTypeComp(pointerByReference));
        return new TypeComp(pointerByReference.getValue());
    }

    public TypeLibDoc getDocumentation(int i) {
        WTypes.BSTRByReference bSTRByReference = new WTypes.BSTRByReference();
        WTypes.BSTRByReference bSTRByReference2 = new WTypes.BSTRByReference();
        WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
        WTypes.BSTRByReference bSTRByReference3 = new WTypes.BSTRByReference();
        COMUtils.checkRC(this.typelib.GetDocumentation(i, bSTRByReference, bSTRByReference2, dWORDByReference, bSTRByReference3));
        TypeLibDoc typeLibDoc = new TypeLibDoc(bSTRByReference.getString(), bSTRByReference2.getString(), dWORDByReference.getValue().intValue(), bSTRByReference3.getString());
        OleAuto oleAuto = OLEAUTO;
        oleAuto.SysFreeString(bSTRByReference.getValue());
        oleAuto.SysFreeString(bSTRByReference2.getValue());
        oleAuto.SysFreeString(bSTRByReference3.getValue());
        return typeLibDoc;
    }

    public static class TypeLibDoc {
        private String docString;
        private int helpContext;
        private String helpFile;
        private String name;

        public TypeLibDoc(String str, String str2, int i, String str3) {
            this.name = str;
            this.docString = str2;
            this.helpContext = i;
            this.helpFile = str3;
        }

        public String getName() {
            return this.name;
        }

        public String getDocString() {
            return this.docString;
        }

        public int getHelpContext() {
            return this.helpContext;
        }

        public String getHelpFile() {
            return this.helpFile;
        }
    }

    public IsName IsName(String str, int i) {
        WTypes.LPOLESTR lpolestr = new WTypes.LPOLESTR(str);
        WinDef.ULONG ulong = new WinDef.ULONG(i);
        WinDef.BOOLByReference bOOLByReference = new WinDef.BOOLByReference();
        COMUtils.checkRC(this.typelib.IsName(lpolestr, ulong, bOOLByReference));
        return new IsName(lpolestr.getValue(), bOOLByReference.getValue().booleanValue());
    }

    public static class IsName {
        private boolean name;
        private String nameBuf;

        public IsName(String str, boolean z) {
            this.nameBuf = str;
            this.name = z;
        }

        public String getNameBuf() {
            return this.nameBuf;
        }

        public boolean isName() {
            return this.name;
        }
    }

    public FindName FindName(String str, int i, short s) {
        Pointer pointerCoTaskMemAlloc = Ole32.INSTANCE.CoTaskMemAlloc((str.length() + 1) * Native.WCHAR_SIZE);
        WTypes.LPOLESTR lpolestr = new WTypes.LPOLESTR(pointerCoTaskMemAlloc);
        lpolestr.setValue(str);
        WinDef.ULONG ulong = new WinDef.ULONG(i);
        WinDef.USHORTByReference uSHORTByReference = new WinDef.USHORTByReference(s);
        Pointer[] pointerArr = new Pointer[s];
        OaIdl.MEMBERID[] memberidArr = new OaIdl.MEMBERID[s];
        COMUtils.checkRC(this.typelib.FindName(lpolestr, ulong, pointerArr, memberidArr, uSHORTByReference));
        FindName findName = new FindName(lpolestr.getValue(), pointerArr, memberidArr, uSHORTByReference.getValue().shortValue());
        Ole32.INSTANCE.CoTaskMemFree(pointerCoTaskMemAlloc);
        return findName;
    }

    public static class FindName {
        private String nameBuf;
        private Pointer[] pTInfo;
        private short pcFound;
        private OaIdl.MEMBERID[] rgMemId;

        FindName(String str, Pointer[] pointerArr, OaIdl.MEMBERID[] memberidArr, short s) {
            this.nameBuf = str;
            Pointer[] pointerArr2 = new Pointer[s];
            this.pTInfo = pointerArr2;
            this.rgMemId = new OaIdl.MEMBERID[s];
            this.pcFound = s;
            System.arraycopy(pointerArr, 0, pointerArr2, 0, s);
            System.arraycopy(memberidArr, 0, this.rgMemId, 0, s);
        }

        public String getNameBuf() {
            return this.nameBuf;
        }

        public ITypeInfo[] getTInfo() {
            ITypeInfo[] iTypeInfoArr = new ITypeInfo[this.pcFound];
            for (int i = 0; i < this.pcFound; i++) {
                iTypeInfoArr[i] = new TypeInfo(this.pTInfo[i]);
            }
            return iTypeInfoArr;
        }

        public OaIdl.MEMBERID[] getMemId() {
            return this.rgMemId;
        }

        public short getFound() {
            return this.pcFound;
        }
    }

    public void ReleaseTLibAttr(OaIdl.TLIBATTR tlibattr) {
        this.typelib.ReleaseTLibAttr(tlibattr);
    }

    public WinDef.LCID getLcid() {
        return this.lcid;
    }

    public ITypeLib getTypelib() {
        return this.typelib;
    }

    public String getName() {
        return this.name;
    }

    public String getDocString() {
        return this.docString;
    }

    public int getHelpContext() {
        return this.helpContext;
    }

    public String getHelpFile() {
        return this.helpFile;
    }
}
