package com.sun.jna.platform.win32.COM;

import com.sun.jna.Function;
import com.sun.jna.Native;
import com.sun.jna.PointerType;

/* loaded from: classes4.dex */
public abstract class COMInvoker extends PointerType {
    protected int _invokeNativeInt(int i, Object[] objArr) {
        return Function.getFunction(getPointer().getPointer(0L).getPointer(i * Native.POINTER_SIZE)).invokeInt(objArr);
    }

    protected Object _invokeNativeObject(int i, Object[] objArr, Class<?> cls) {
        return Function.getFunction(getPointer().getPointer(0L).getPointer(i * Native.POINTER_SIZE)).invoke(cls, objArr);
    }

    protected void _invokeNativeVoid(int i, Object[] objArr) {
        Function.getFunction(getPointer().getPointer(0L).getPointer(i * Native.POINTER_SIZE)).invokeVoid(objArr);
    }
}
