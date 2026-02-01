package com.sun.jna.platform.win32;

import com.sun.jna.LastErrorException;
import com.sun.jna.platform.win32.WinNT;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public class Win32Exception extends LastErrorException {
    private static Method addSuppressedMethod = null;
    private static final long serialVersionUID = 1;
    private WinNT.HRESULT _hr;

    public WinNT.HRESULT getHR() {
        return this._hr;
    }

    public Win32Exception(int i) {
        this(i, W32Errors.HRESULT_FROM_WIN32(i));
    }

    public Win32Exception(WinNT.HRESULT hresult) {
        this(W32Errors.HRESULT_CODE(hresult.intValue()), hresult);
    }

    protected Win32Exception(int i, WinNT.HRESULT hresult) {
        this(i, hresult, Kernel32Util.formatMessage(hresult));
    }

    protected Win32Exception(int i, WinNT.HRESULT hresult, String str) {
        super(i, str);
        this._hr = hresult;
    }

    static {
        try {
            addSuppressedMethod = Throwable.class.getMethod("addSuppressed", Throwable.class);
        } catch (NoSuchMethodException unused) {
        } catch (SecurityException e) {
            Logger.getLogger(Win32Exception.class.getName()).log(Level.SEVERE, "Failed to initialize 'addSuppressed' method", (Throwable) e);
        }
    }

    void addSuppressedReflected(Throwable th) {
        Method method = addSuppressedMethod;
        if (method == null) {
            return;
        }
        try {
            method.invoke(this, th);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to call addSuppressedMethod", e);
        } catch (IllegalArgumentException e2) {
            throw new RuntimeException("Failed to call addSuppressedMethod", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Failed to call addSuppressedMethod", e3);
        }
    }
}
