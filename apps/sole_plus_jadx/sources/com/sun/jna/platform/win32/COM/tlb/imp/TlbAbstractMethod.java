package com.sun.jna.platform.win32.COM.tlb.imp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.SdkConstants;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.COM.TypeInfoUtil;
import com.sun.jna.platform.win32.COM.TypeLibUtil;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import io.ktor.client.utils.CacheControl;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public abstract class TlbAbstractMethod extends TlbBase implements Variant {
    protected String docStr;
    protected OaIdl.MEMBERID memberid;
    protected String methodName;
    protected String methodparams;
    protected String methodvariables;
    protected short paramCount;
    protected String returnType;
    protected TypeInfoUtil.TypeInfoDoc typeInfoDoc;
    protected short vtableId;

    public TlbAbstractMethod(int i, TypeLibUtil typeLibUtil, OaIdl.FUNCDESC funcdesc, TypeInfoUtil typeInfoUtil) {
        super(i, typeLibUtil, typeInfoUtil);
        this.methodparams = "";
        this.methodvariables = "";
        TypeInfoUtil.TypeInfoDoc documentation = typeInfoUtil.getDocumentation(funcdesc.memid);
        this.typeInfoDoc = documentation;
        this.methodName = documentation.getName();
        this.docStr = this.typeInfoDoc.getDocString();
        this.vtableId = funcdesc.oVft.shortValue();
        this.memberid = funcdesc.memid;
        this.paramCount = funcdesc.cParams.shortValue();
        this.returnType = getType(funcdesc);
    }

    public TypeInfoUtil.TypeInfoDoc getTypeInfoDoc() {
        return this.typeInfoDoc;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public String getDocStr() {
        return this.docStr;
    }

    protected String getVarType(WTypes.VARTYPE vartype) {
        int iIntValue = vartype.intValue();
        if (iIntValue == 64) {
            return WinBase.FILETIME.class.getSimpleName();
        }
        if (iIntValue == 4096 || iIntValue == 8192) {
            return "";
        }
        if (iIntValue == 16384) {
            return WinDef.PVOID.class.getSimpleName();
        }
        if (iIntValue == 32768) {
            return "";
        }
        if (iIntValue != 65535) {
            switch (iIntValue) {
                case 0:
                    return "";
                case 1:
                    return AbstractJsonLexerKt.NULL;
                case 2:
                    return "short";
                case 3:
                    return "int";
                case 4:
                    return TypedValues.Custom.S_FLOAT;
                case 5:
                    return "double";
                case 6:
                    return OaIdl.CURRENCY.class.getSimpleName();
                case 7:
                    return OaIdl.DATE.class.getSimpleName();
                case 8:
                    return WTypes.BSTR.class.getSimpleName();
                case 9:
                    return "IDispatch";
                case 10:
                    return WinDef.SCODE.class.getSimpleName();
                case 11:
                    return WinDef.BOOL.class.getSimpleName();
                case 12:
                    return Variant.VARIANT.class.getSimpleName();
                case 13:
                    return "IUnknown";
                case 14:
                    return OaIdl.DECIMAL.class.getSimpleName();
                default:
                    switch (iIntValue) {
                        case 16:
                            return WinDef.CHAR.class.getSimpleName();
                        case 17:
                            return WinDef.UCHAR.class.getSimpleName();
                        case 18:
                            return WinDef.USHORT.class.getSimpleName();
                        case 19:
                            return WinDef.UINT.class.getSimpleName();
                        case 20:
                            return WinDef.LONG.class.getSimpleName();
                        case 21:
                            return WinDef.ULONG.class.getSimpleName();
                        case 22:
                            return "int";
                        case 23:
                            return WinDef.UINT.class.getSimpleName();
                        case 24:
                            return WinDef.PVOID.class.getSimpleName();
                        case 25:
                            return WinNT.HRESULT.class.getSimpleName();
                        case 26:
                            return Pointer.class.getSimpleName();
                        case 27:
                            return "safearray";
                        case 28:
                            return "carray";
                        case 29:
                            return "userdefined";
                        case 30:
                            return WTypes.LPSTR.class.getSimpleName();
                        case 31:
                            return WTypes.LPWSTR.class.getSimpleName();
                        default:
                            switch (iIntValue) {
                                case 36:
                                    return "record";
                                case 37:
                                    return WinDef.INT_PTR.class.getSimpleName();
                                case 38:
                                    return WinDef.UINT_PTR.class.getSimpleName();
                                default:
                                    switch (iIntValue) {
                                        case 66:
                                            return "steam";
                                        case 67:
                                            return "storage";
                                        case 68:
                                            return "steamed_object";
                                        case 69:
                                            return "stored_object";
                                        case 70:
                                            return "blob_object";
                                        case 71:
                                            return "cf";
                                        case 72:
                                            return Guid.CLSID.class.getSimpleName();
                                        case 73:
                                            return "";
                                        default:
                                            return null;
                                    }
                            }
                    }
            }
        }
        return "illegal";
    }

    protected String getUserdefinedType(OaIdl.HREFTYPE hreftype) {
        return new TypeInfoUtil(this.typeInfoUtil.getRefTypeInfo(hreftype)).getDocumentation(OaIdl.MEMBERID_NIL).getName();
    }

    protected String getType(OaIdl.FUNCDESC funcdesc) {
        return getType(funcdesc.elemdescFunc);
    }

    protected String getType(OaIdl.ELEMDESC elemdesc) {
        return getType(elemdesc.tdesc);
    }

    protected String getType(OaIdl.TYPEDESC typedesc) {
        WTypes.VARTYPE vartype = typedesc.vt;
        if (vartype.intValue() == 26) {
            return getType(typedesc._typedesc.getLptdesc());
        }
        if (vartype.intValue() == 27 || vartype.intValue() == 28) {
            return getType(typedesc._typedesc.getLpadesc().tdescElem);
        }
        if (vartype.intValue() == 29) {
            return getUserdefinedType(typedesc._typedesc.hreftype);
        }
        return getVarType(vartype);
    }

    protected String replaceJavaKeyword(String str) {
        if (str.equals("final")) {
            return "_" + str;
        }
        if (str.equals(SdkConstants.SKIN_DEFAULT)) {
            return "_" + str;
        }
        if (str.equals("case")) {
            return "_" + str;
        }
        if (str.equals("char")) {
            return "_" + str;
        }
        if (str.equals(CacheControl.PRIVATE)) {
            return "_" + str;
        }
        return str.equals(SdkConstants.SKIN_DEFAULT) ? "_" + str : str;
    }
}
