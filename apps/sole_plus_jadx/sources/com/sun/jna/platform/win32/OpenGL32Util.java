package com.sun.jna.platform.win32;

import com.google.common.base.Ascii;
import com.sun.jna.Function;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinGDI;

/* loaded from: classes4.dex */
public abstract class OpenGL32Util {
    public static Function wglGetProcAddress(String str) {
        Pointer pointerWglGetProcAddress = OpenGL32.INSTANCE.wglGetProcAddress("wglEnumGpusNV");
        if (pointerWglGetProcAddress == null) {
            return null;
        }
        return Function.getFunction(pointerWglGetProcAddress);
    }

    public static int countGpusNV() {
        WinDef.HWND hwndCreateWindow = User32Util.createWindow("Message", null, 0, 0, 0, 0, 0, null, null, null, null);
        WinDef.HDC hdcGetDC = User32.INSTANCE.GetDC(hwndCreateWindow);
        WinGDI.PIXELFORMATDESCRIPTOR.ByReference byReference = new WinGDI.PIXELFORMATDESCRIPTOR.ByReference();
        byReference.nVersion = (short) 1;
        byReference.dwFlags = 37;
        byReference.iPixelType = (byte) 0;
        byReference.cColorBits = Ascii.CAN;
        byReference.cDepthBits = (byte) 16;
        byReference.iLayerType = (byte) 0;
        GDI32.INSTANCE.SetPixelFormat(hdcGetDC, GDI32.INSTANCE.ChoosePixelFormat(hdcGetDC, byReference), byReference);
        WinDef.HGLRC hglrcWglCreateContext = OpenGL32.INSTANCE.wglCreateContext(hdcGetDC);
        OpenGL32.INSTANCE.wglMakeCurrent(hdcGetDC, hglrcWglCreateContext);
        Pointer pointerWglGetProcAddress = OpenGL32.INSTANCE.wglGetProcAddress("wglEnumGpusNV");
        Function function = pointerWglGetProcAddress == null ? null : Function.getFunction(pointerWglGetProcAddress);
        OpenGL32.INSTANCE.wglDeleteContext(hglrcWglCreateContext);
        User32.INSTANCE.ReleaseDC(hwndCreateWindow, hdcGetDC);
        User32Util.destroyWindow(hwndCreateWindow);
        if (function == null) {
            return 0;
        }
        WinDef.HGLRCByReference hGLRCByReference = new WinDef.HGLRCByReference();
        for (int i = 0; i < 16; i++) {
            if (!((Boolean) function.invoke(Boolean.class, new Object[]{Integer.valueOf(i), hGLRCByReference})).booleanValue()) {
                return i;
            }
        }
        return 0;
    }
}
