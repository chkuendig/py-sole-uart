package com.sun.jna.platform.win32.COM.tlb;

import com.sun.jna.platform.win32.COM.TypeLibUtil;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbBase;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbCmdlineArgs;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbCoClass;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbConst;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbDispInterface;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbEnum;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbInterface;
import com.sun.jna.platform.win32.OaIdl;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
public class TlbImp implements TlbConst {
    private TlbCmdlineArgs cmdlineArgs;
    private File comRootDir;
    private File outputDir;
    private TypeLibUtil typeLibUtil;

    public static void main(String[] strArr) {
        new TlbImp(strArr);
    }

    public TlbImp(String[] strArr) {
        TlbCmdlineArgs tlbCmdlineArgs = new TlbCmdlineArgs(strArr);
        this.cmdlineArgs = tlbCmdlineArgs;
        if (tlbCmdlineArgs.isTlbId()) {
            this.typeLibUtil = new TypeLibUtil(this.cmdlineArgs.getRequiredParam(TlbConst.CMD_ARG_TYPELIB_ID), this.cmdlineArgs.getIntParam(TlbConst.CMD_ARG_TYPELIB_MAJOR_VERSION), this.cmdlineArgs.getIntParam(TlbConst.CMD_ARG_TYPELIB_MINOR_VERSION));
            startCOM2Java();
        } else if (this.cmdlineArgs.isTlbFile()) {
            this.typeLibUtil = new TypeLibUtil(this.cmdlineArgs.getRequiredParam(TlbConst.CMD_ARG_TYPELIB_FILE));
            startCOM2Java();
        } else {
            this.cmdlineArgs.showCmdHelp();
        }
    }

    public void startCOM2Java() {
        try {
            createDir();
            String bindingMode = this.cmdlineArgs.getBindingMode();
            int typeInfoCount = this.typeLibUtil.getTypeInfoCount();
            for (int i = 0; i < typeInfoCount; i++) {
                OaIdl.TYPEKIND typeInfoType = this.typeLibUtil.getTypeInfoType(i);
                if (typeInfoType.value == 0) {
                    createCOMEnum(i, getPackageName(), this.typeLibUtil);
                } else if (typeInfoType.value == 1) {
                    logInfo("'TKIND_RECORD' objects are currently not supported!");
                } else if (typeInfoType.value == 2) {
                    logInfo("'TKIND_MODULE' objects are currently not supported!");
                } else if (typeInfoType.value == 3) {
                    createCOMInterface(i, getPackageName(), this.typeLibUtil);
                } else if (typeInfoType.value == 4) {
                    createCOMDispInterface(i, getPackageName(), this.typeLibUtil);
                } else if (typeInfoType.value == 5) {
                    createCOMCoClass(i, getPackageName(), this.typeLibUtil, bindingMode);
                } else if (typeInfoType.value == 6) {
                    logInfo("'TKIND_ALIAS' objects are currently not supported!");
                } else if (typeInfoType.value == 7) {
                    logInfo("'TKIND_UNION' objects are currently not supported!");
                }
            }
            logInfo(typeInfoCount + " files sucessfully written to: " + this.comRootDir.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createDir() throws FileNotFoundException {
        String param = this.cmdlineArgs.getParam(TlbConst.CMD_ARG_OUTPUT_DIR);
        String str = "_jnaCOM_" + System.currentTimeMillis() + "\\myPackage\\" + this.typeLibUtil.getName().toLowerCase() + "\\";
        if (param != null) {
            this.comRootDir = new File(param + "\\" + str);
        } else {
            this.comRootDir = new File(System.getProperty("java.io.tmpdir") + "\\" + str);
        }
        if (this.comRootDir.exists()) {
            this.comRootDir.delete();
        }
        if (this.comRootDir.mkdirs()) {
            logInfo("Output directory sucessfully created.");
            return;
        }
        throw new FileNotFoundException("Output directory NOT sucessfully created to: " + this.comRootDir.toString());
    }

    private String getPackageName() {
        return "myPackage." + this.typeLibUtil.getName().toLowerCase();
    }

    private void writeTextFile(String str, String str2) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.comRootDir + File.separator + str));
        bufferedOutputStream.write(str2.getBytes());
        bufferedOutputStream.close();
    }

    private void writeTlbClass(TlbBase tlbBase) throws IOException {
        writeTextFile(tlbBase.getFilename(), tlbBase.getClassBuffer().toString());
    }

    private void createCOMEnum(int i, String str, TypeLibUtil typeLibUtil) throws IOException {
        writeTlbClass(new TlbEnum(i, str, typeLibUtil));
    }

    private void createCOMInterface(int i, String str, TypeLibUtil typeLibUtil) throws IOException {
        writeTlbClass(new TlbInterface(i, str, typeLibUtil));
    }

    private void createCOMDispInterface(int i, String str, TypeLibUtil typeLibUtil) throws IOException {
        writeTlbClass(new TlbDispInterface(i, str, typeLibUtil));
    }

    private void createCOMCoClass(int i, String str, TypeLibUtil typeLibUtil, String str2) throws IOException {
        writeTlbClass(new TlbCoClass(i, getPackageName(), typeLibUtil, str2));
    }

    public static void logInfo(String str) {
        System.out.println(str);
    }
}
