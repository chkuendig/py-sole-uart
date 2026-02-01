package com.sun.jna.platform.win32.COM;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;

/* loaded from: classes4.dex */
public class ConnectionPoint extends Unknown implements IConnectionPoint {
    void EnumConnections() {
    }

    void GetConnectionPointContainer() {
    }

    public ConnectionPoint(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.platform.win32.COM.IConnectionPoint
    public WinNT.HRESULT GetConnectionInterface(Guid.IID iid) {
        return (WinNT.HRESULT) _invokeNativeObject(3, new Object[]{getPointer(), iid}, WinNT.HRESULT.class);
    }

    @Override // com.sun.jna.platform.win32.COM.IConnectionPoint
    public WinNT.HRESULT Advise(IUnknownCallback iUnknownCallback, WinDef.DWORDByReference dWORDByReference) {
        return (WinNT.HRESULT) _invokeNativeObject(5, new Object[]{getPointer(), iUnknownCallback.getPointer(), dWORDByReference}, WinNT.HRESULT.class);
    }

    @Override // com.sun.jna.platform.win32.COM.IConnectionPoint
    public WinNT.HRESULT Unadvise(WinDef.DWORD dword) {
        return (WinNT.HRESULT) _invokeNativeObject(6, new Object[]{getPointer(), dword}, WinNT.HRESULT.class);
    }
}
