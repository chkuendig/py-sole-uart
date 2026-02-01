package com.sun.jna.platform.win32.COM;

import com.sun.jna.platform.win32.WinNT;

/* loaded from: classes4.dex */
public class COMInvokeException extends COMException {
    private static final long serialVersionUID = 1;
    private final String description;
    private final Integer errorArg;
    private final Integer helpContext;
    private final String helpFile;
    private final Integer scode;
    private final String source;
    private final Integer wCode;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COMInvokeException() {
        this("", null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COMInvokeException(String str) {
        this(str, null);
    }

    public COMInvokeException(Throwable th) {
        this(null, th);
    }

    public COMInvokeException(String str, Throwable th) {
        super(str, th);
        this.description = null;
        this.errorArg = null;
        this.helpContext = null;
        this.helpFile = null;
        this.scode = null;
        this.source = null;
        this.wCode = null;
    }

    public COMInvokeException(String str, WinNT.HRESULT hresult, Integer num, String str2, Integer num2, String str3, Integer num3, String str4, Integer num4) {
        super(formatMessage(hresult, str, num), hresult);
        this.description = str2;
        this.errorArg = num;
        this.helpContext = num2;
        this.helpFile = str3;
        this.scode = num3;
        this.source = str4;
        this.wCode = num4;
    }

    public Integer getErrorArg() {
        return this.errorArg;
    }

    public Integer getWCode() {
        return this.wCode;
    }

    public String getSource() {
        return this.source;
    }

    public String getDescription() {
        return this.description;
    }

    public String getHelpFile() {
        return this.helpFile;
    }

    public Integer getHelpContext() {
        return this.helpContext;
    }

    public Integer getScode() {
        return this.scode;
    }

    private static String formatMessage(WinNT.HRESULT hresult, String str, Integer num) {
        return (hresult.intValue() == -2147352571 || hresult.intValue() == -2147352572) ? str + " (puArgErr=" + num + ")" : str;
    }
}
