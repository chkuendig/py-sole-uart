package com.sun.jna.platform.win32.COM.tlb.imp;

import com.android.SdkConstants;
import java.util.Hashtable;

/* loaded from: classes4.dex */
public class TlbCmdlineArgs extends Hashtable<String, String> implements TlbConst {
    private static final long serialVersionUID = 1;

    public TlbCmdlineArgs(String[] strArr) {
        readCmdArgs(strArr);
    }

    public int getIntParam(String str) {
        return Integer.parseInt(getRequiredParam(str));
    }

    public String getParam(String str) {
        return get(str);
    }

    public String getRequiredParam(String str) {
        String param = getParam(str);
        if (param != null) {
            return param;
        }
        throw new TlbParameterNotFoundException("Commandline parameter not found: " + str);
    }

    private void readCmdArgs(String[] strArr) {
        if (strArr.length < 2) {
            showCmdHelp();
        }
        for (int i = 0; i < strArr.length; i += 2) {
            String str = strArr[i];
            String str2 = strArr[i + 1];
            if (str.startsWith(SdkConstants.RES_QUALIFIER_SEP) && !str2.startsWith(SdkConstants.RES_QUALIFIER_SEP)) {
                put(str.substring(1), str2);
            } else {
                showCmdHelp();
                return;
            }
        }
    }

    public boolean isTlbFile() {
        return containsKey(TlbConst.CMD_ARG_TYPELIB_FILE);
    }

    public boolean isTlbId() {
        return containsKey(TlbConst.CMD_ARG_TYPELIB_ID);
    }

    public String getBindingMode() {
        if (containsKey(TlbConst.CMD_ARG_BINDING_MODE)) {
            return getParam(TlbConst.CMD_ARG_BINDING_MODE);
        }
        return TlbConst.BINDING_MODE_VTABLE;
    }

    public void showCmdHelp() {
        System.out.println("usage: TlbImp [-tlb.id -tlb.major.version -tlb.minor.version] [-tlb.file] [-bind.mode vTable, dispId] [-output.dir]\n\noptions:\n-tlb.id               The guid of the type library.\n-tlb.major.version    The major version of the type library.\n-tlb.minor.version    The minor version of the type library.\n-tlb.file             The file name containing the type library.\n-bind.mode            The binding mode used to create the Java code.\n-output.dir           The optional output directory, default is the user temp directory.\n\nsamples:\nMicrosoft Shell Controls And Automation:\n-tlb.file shell32.dll\n-tlb.id {50A7E9B0-70EF-11D1-B75A-00A0C90564FE} -tlb.major.version 1 -tlb.minor.version 0\n\nMicrosoft Word 12.0 Object Library:\n-tlb.id {00020905-0000-0000-C000-000000000046} -tlb.major.version 8 -tlb.minor.version 4\n\n");
        System.exit(0);
    }
}
