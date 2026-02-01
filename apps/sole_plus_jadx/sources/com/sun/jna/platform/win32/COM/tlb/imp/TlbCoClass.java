package com.sun.jna.platform.win32.COM.tlb.imp;

import com.facebook.internal.ServerProtocol;
import com.sun.jna.platform.win32.COM.TypeInfoUtil;
import com.sun.jna.platform.win32.COM.TypeLibUtil;
import com.sun.jna.platform.win32.OaIdl;

/* loaded from: classes4.dex */
public class TlbCoClass extends TlbBase {
    public TlbCoClass(int i, String str, TypeLibUtil typeLibUtil, String str2) {
        super(i, typeLibUtil, null);
        TypeInfoUtil typeInfoUtil = typeLibUtil.getTypeInfoUtil(i);
        TypeLibUtil.TypeLibDoc documentation = this.typeLibUtil.getDocumentation(i);
        String docString = documentation.getDocString();
        if (documentation.getName().length() > 0) {
            this.name = documentation.getName();
        }
        logInfo("Type of kind 'CoClass' found: " + this.name);
        createPackageName(str);
        createClassName(this.name);
        setFilename(this.name);
        String guidString = this.typeLibUtil.getLibAttr().guid.toGuidString();
        String str3 = this.typeLibUtil.getLibAttr().wMajorVerNum.intValue() + "." + this.typeLibUtil.getLibAttr().wMinorVerNum.intValue();
        String guidString2 = typeInfoUtil.getTypeAttr().guid.toGuidString();
        createJavaDocHeader(guidString, str3, docString);
        createCLSID(guidString2);
        createCLSIDName(this.name);
        int iIntValue = typeInfoUtil.getTypeAttr().cImplTypes.intValue();
        String str4 = "";
        for (int i2 = 0; i2 < iIntValue; i2++) {
            TypeInfoUtil typeInfoUtil2 = new TypeInfoUtil(typeInfoUtil.getRefTypeInfo(typeInfoUtil.getRefTypeOfImplType(i2)));
            createFunctions(typeInfoUtil2, str2);
            str4 = str4 + typeInfoUtil2.getDocumentation(new OaIdl.MEMBERID(-1)).getName();
            if (i2 < iIntValue - 1) {
                str4 = str4 + ", ";
            }
        }
        createInterfaces(str4);
        createContent(this.content);
    }

    protected void createFunctions(TypeInfoUtil typeInfoUtil, String str) {
        TlbAbstractMethod tlbPropertyPut;
        int iIntValue = typeInfoUtil.getTypeAttr().cFuncs.intValue();
        for (int i = 0; i < iIntValue; i++) {
            OaIdl.FUNCDESC funcDesc = typeInfoUtil.getFuncDesc(i);
            if (funcDesc.invkind.value == OaIdl.INVOKEKIND.INVOKE_FUNC.value) {
                if (isVTableMode()) {
                    tlbPropertyPut = new TlbFunctionVTable(i, this.index, this.typeLibUtil, funcDesc, typeInfoUtil);
                } else {
                    tlbPropertyPut = new TlbFunctionDispId(i, this.index, this.typeLibUtil, funcDesc, typeInfoUtil);
                }
            } else if (funcDesc.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYGET.value) {
                tlbPropertyPut = new TlbPropertyGet(i, this.index, this.typeLibUtil, funcDesc, typeInfoUtil);
            } else if (funcDesc.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUT.value) {
                tlbPropertyPut = new TlbPropertyPut(i, this.index, this.typeLibUtil, funcDesc, typeInfoUtil);
            } else if (funcDesc.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUTREF.value) {
                tlbPropertyPut = new TlbPropertyPut(i, this.index, this.typeLibUtil, funcDesc, typeInfoUtil);
            } else {
                tlbPropertyPut = null;
            }
            if (!isReservedMethod(tlbPropertyPut.getMethodName())) {
                this.content += ((Object) tlbPropertyPut.getClassBuffer());
                if (i < iIntValue - 1) {
                    this.content += "\n";
                }
            }
            typeInfoUtil.ReleaseFuncDesc(funcDesc);
        }
    }

    protected void createJavaDocHeader(String str, String str2, String str3) {
        replaceVariable("uuid", str);
        replaceVariable(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, str2);
        replaceVariable("helpstring", str3);
    }

    protected void createCLSIDName(String str) {
        replaceVariable("clsidname", str.toUpperCase());
    }

    protected void createCLSID(String str) {
        replaceVariable("clsid", str);
    }

    protected void createInterfaces(String str) {
        replaceVariable("interfaces", str);
    }

    @Override // com.sun.jna.platform.win32.COM.tlb.imp.TlbBase
    protected String getClassTemplate() {
        return "com/sun/jna/platform/win32/COM/tlb/imp/TlbCoClass.template";
    }
}
