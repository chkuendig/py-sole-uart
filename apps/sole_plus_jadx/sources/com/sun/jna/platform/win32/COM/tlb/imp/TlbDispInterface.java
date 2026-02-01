package com.sun.jna.platform.win32.COM.tlb.imp;

import com.sun.jna.platform.win32.COM.TypeInfoUtil;
import com.sun.jna.platform.win32.COM.TypeLibUtil;
import com.sun.jna.platform.win32.OaIdl;

/* loaded from: classes4.dex */
public class TlbDispInterface extends TlbBase {
    public TlbDispInterface(int i, String str, TypeLibUtil typeLibUtil) {
        TlbBase tlbPropertyPutStub;
        super(i, typeLibUtil, null);
        TypeLibUtil.TypeLibDoc documentation = this.typeLibUtil.getDocumentation(i);
        String docString = documentation.getDocString();
        if (documentation.getName().length() > 0) {
            this.name = documentation.getName();
        }
        logInfo("Type of kind 'DispInterface' found: " + this.name);
        createPackageName(str);
        createClassName(this.name);
        setFilename(this.name);
        TypeInfoUtil typeInfoUtil = typeLibUtil.getTypeInfoUtil(i);
        OaIdl.TYPEATTR typeAttr = typeInfoUtil.getTypeAttr();
        createJavaDocHeader(typeAttr.guid.toGuidString(), docString);
        int iIntValue = typeAttr.cFuncs.intValue();
        for (int i2 = 0; i2 < iIntValue; i2++) {
            OaIdl.FUNCDESC funcDesc = typeInfoUtil.getFuncDesc(i2);
            if (!isReservedMethod(typeInfoUtil.getDocumentation(funcDesc.memid).getName())) {
                if (funcDesc.invkind.value == OaIdl.INVOKEKIND.INVOKE_FUNC.value) {
                    tlbPropertyPutStub = new TlbFunctionStub(i, typeLibUtil, funcDesc, typeInfoUtil);
                } else if (funcDesc.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYGET.value) {
                    tlbPropertyPutStub = new TlbPropertyGetStub(i, typeLibUtil, funcDesc, typeInfoUtil);
                } else {
                    tlbPropertyPutStub = (funcDesc.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUT.value || funcDesc.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUTREF.value) ? new TlbPropertyPutStub(i, typeLibUtil, funcDesc, typeInfoUtil) : null;
                }
                this.content += ((Object) tlbPropertyPutStub.getClassBuffer());
                if (i2 < iIntValue - 1) {
                    this.content += "\n";
                }
            }
            typeInfoUtil.ReleaseFuncDesc(funcDesc);
        }
        createContent(this.content);
    }

    protected void createJavaDocHeader(String str, String str2) {
        replaceVariable("uuid", str);
        replaceVariable("helpstring", str2);
    }

    @Override // com.sun.jna.platform.win32.COM.tlb.imp.TlbBase
    protected String getClassTemplate() {
        return "com/sun/jna/platform/win32/COM/tlb/imp/TlbDispInterface.template";
    }
}
