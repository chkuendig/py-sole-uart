package com.sun.jna.platform.win32.COM.util;

import com.android.SdkConstants;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.internal.ReflectionUtils;
import com.sun.jna.platform.win32.COM.COMException;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.ConnectionPoint;
import com.sun.jna.platform.win32.COM.ConnectionPointContainer;
import com.sun.jna.platform.win32.COM.Dispatch;
import com.sun.jna.platform.win32.COM.IDispatchCallback;
import com.sun.jna.platform.win32.COM.util.annotation.ComInterface;
import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;
import com.sun.jna.platform.win32.COM.util.annotation.ComProperty;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes4.dex */
public class ProxyObject implements InvocationHandler, IDispatch, IRawDispatchHandle, IConnectionPoint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ObjectFactory factory;
    private final com.sun.jna.platform.win32.COM.IDispatch rawDispatch;
    private final Class<?> theInterface;
    private long unknownId = -1;

    public ProxyObject(Class<?> cls, com.sun.jna.platform.win32.COM.IDispatch iDispatch, ObjectFactory objectFactory) {
        this.rawDispatch = iDispatch;
        this.theInterface = cls;
        this.factory = objectFactory;
        iDispatch.AddRef();
        getUnknownId();
        objectFactory.register(this);
    }

    private long getUnknownId() {
        if (-1 == this.unknownId) {
            try {
                PointerByReference pointerByReference = new PointerByReference();
                Thread.currentThread().getName();
                WinNT.HRESULT hresultQueryInterface = getRawDispatch().QueryInterface(new Guid.REFIID(com.sun.jna.platform.win32.COM.IUnknown.IID_IUNKNOWN), pointerByReference);
                if (WinNT.S_OK.equals(hresultQueryInterface)) {
                    Dispatch dispatch = new Dispatch(pointerByReference.getValue());
                    this.unknownId = Pointer.nativeValue(dispatch.getPointer());
                    dispatch.Release();
                } else {
                    throw new COMException("getUnknownId: " + Kernel32Util.formatMessage(hresultQueryInterface), hresultQueryInterface);
                }
            } catch (RuntimeException e) {
                if (e instanceof COMException) {
                    throw e;
                }
                throw new COMException("Error occured when trying get Unknown Id ", e);
            }
        }
        return this.unknownId;
    }

    protected void finalize() throws Throwable {
        dispose();
        super.finalize();
    }

    public synchronized void dispose() {
        if (((Dispatch) this.rawDispatch).getPointer() != Pointer.NULL) {
            this.rawDispatch.Release();
            ((Dispatch) this.rawDispatch).setPointer(Pointer.NULL);
            this.factory.unregister(this);
        }
    }

    @Override // com.sun.jna.platform.win32.COM.util.IRawDispatchHandle
    public com.sun.jna.platform.win32.COM.IDispatch getRawDispatch() {
        return this.rawDispatch;
    }

    public boolean equals(Object obj) throws IllegalArgumentException {
        if (obj == null) {
            return false;
        }
        if (obj instanceof ProxyObject) {
            return getUnknownId() == ((ProxyObject) obj).getUnknownId();
        }
        if (!Proxy.isProxyClass(obj.getClass())) {
            return false;
        }
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
        if (!(invocationHandler instanceof ProxyObject)) {
            return false;
        }
        try {
            return getUnknownId() == ((ProxyObject) invocationHandler).getUnknownId();
        } catch (Exception unused) {
            return false;
        }
    }

    public int hashCode() {
        long unknownId = getUnknownId();
        return ((int) (unknownId >>> 32)) + ((int) unknownId);
    }

    public String toString() {
        return this.theInterface.getName() + "{unk=" + hashCode() + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        boolean z = (method.getAnnotation(ComMethod.class) == null && method.getAnnotation(ComProperty.class) == null) ? false : true;
        if (!z && (method.getDeclaringClass().equals(Object.class) || method.getDeclaringClass().equals(IRawDispatchHandle.class) || method.getDeclaringClass().equals(IUnknown.class) || method.getDeclaringClass().equals(IDispatch.class) || method.getDeclaringClass().equals(IConnectionPoint.class))) {
            try {
                return method.invoke(this, objArr);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }
        if (!z && ReflectionUtils.isDefault(method)) {
            return ReflectionUtils.invokeDefaultMethod(obj, ReflectionUtils.getMethodHandle(method), objArr);
        }
        Class<?> returnType = method.getReturnType();
        boolean zEquals = Void.TYPE.equals(returnType);
        ComProperty comProperty = (ComProperty) method.getAnnotation(ComProperty.class);
        if (comProperty != null) {
            int iDispId = comProperty.dispId();
            Object[] objArrUnfoldWhenVarargs = unfoldWhenVarargs(method, objArr);
            if (!zEquals) {
                if (iDispId != -1) {
                    return getProperty(returnType, new OaIdl.DISPID(iDispId), objArr);
                }
                return getProperty(returnType, getAccessorName(method, comProperty), objArr);
            }
            if (iDispId != -1) {
                setProperty(new OaIdl.DISPID(iDispId), objArrUnfoldWhenVarargs);
                return null;
            }
            setProperty(getMutatorName(method, comProperty), objArrUnfoldWhenVarargs);
            return null;
        }
        ComMethod comMethod = (ComMethod) method.getAnnotation(ComMethod.class);
        if (comMethod == null) {
            return null;
        }
        Object[] objArrUnfoldWhenVarargs2 = unfoldWhenVarargs(method, objArr);
        int iDispId2 = comMethod.dispId();
        if (iDispId2 != -1) {
            return invokeMethod(returnType, new OaIdl.DISPID(iDispId2), objArrUnfoldWhenVarargs2);
        }
        return invokeMethod(returnType, getMethodName(method, comMethod), objArrUnfoldWhenVarargs2);
    }

    private ConnectionPoint fetchRawConnectionPoint(Guid.IID iid) {
        ConnectionPointContainer connectionPointContainer = new ConnectionPointContainer(((Dispatch) ((IConnectionPointContainer) queryInterface(IConnectionPointContainer.class)).getRawDispatch()).getPointer());
        Guid.REFIID refiid = new Guid.REFIID(iid.getPointer());
        PointerByReference pointerByReference = new PointerByReference();
        COMUtils.checkRC(connectionPointContainer.FindConnectionPoint(refiid, pointerByReference));
        return new ConnectionPoint(pointerByReference.getValue());
    }

    @Override // com.sun.jna.platform.win32.COM.util.IConnectionPoint
    public IComEventCallbackCookie advise(Class<?> cls, IComEventCallbackListener iComEventCallbackListener) throws COMException {
        try {
            ComInterface comInterface = (ComInterface) cls.getAnnotation(ComInterface.class);
            if (comInterface == null) {
                throw new COMException("advise: Interface must define a value for either iid via the ComInterface annotation");
            }
            ConnectionPoint connectionPointFetchRawConnectionPoint = fetchRawConnectionPoint(getIID(comInterface));
            IDispatchCallback iDispatchCallbackCreateDispatchCallback = this.factory.createDispatchCallback(cls, iComEventCallbackListener);
            iComEventCallbackListener.setDispatchCallbackListener(iDispatchCallbackCreateDispatchCallback);
            WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
            WinNT.HRESULT hresultAdvise = connectionPointFetchRawConnectionPoint.Advise(iDispatchCallbackCreateDispatchCallback, dWORDByReference);
            connectionPointFetchRawConnectionPoint.Release();
            COMUtils.checkRC(hresultAdvise);
            return new ComEventCallbackCookie(dWORDByReference.getValue());
        } catch (RuntimeException e) {
            if (e instanceof COMException) {
                throw e;
            }
            throw new COMException("Error occured in advise when trying to connect the listener " + iComEventCallbackListener, e);
        }
    }

    @Override // com.sun.jna.platform.win32.COM.util.IConnectionPoint
    public void unadvise(Class<?> cls, IComEventCallbackCookie iComEventCallbackCookie) throws COMException {
        try {
            ComInterface comInterface = (ComInterface) cls.getAnnotation(ComInterface.class);
            if (comInterface == null) {
                throw new COMException("unadvise: Interface must define a value for iid via the ComInterface annotation");
            }
            ConnectionPoint connectionPointFetchRawConnectionPoint = fetchRawConnectionPoint(getIID(comInterface));
            WinNT.HRESULT hresultUnadvise = connectionPointFetchRawConnectionPoint.Unadvise(((ComEventCallbackCookie) iComEventCallbackCookie).getValue());
            connectionPointFetchRawConnectionPoint.Release();
            COMUtils.checkRC(hresultUnadvise);
        } catch (RuntimeException e) {
            if (e instanceof COMException) {
                throw e;
            }
            throw new COMException("Error occured in unadvise when trying to disconnect the listener from " + this, e);
        }
    }

    @Override // com.sun.jna.platform.win32.COM.util.IDispatch
    public <T> void setProperty(String str, T t) throws COMException {
        setProperty(resolveDispId(getRawDispatch(), str), (OaIdl.DISPID) t);
    }

    @Override // com.sun.jna.platform.win32.COM.util.IDispatch
    public <T> void setProperty(OaIdl.DISPID dispid, T t) throws COMException {
        Variant.VARIANT variant = Convert.toVariant(t);
        WinNT.HRESULT hresultOleMethod = oleMethod(4, (Variant.VARIANT.ByReference) null, getRawDispatch(), dispid, variant);
        Convert.free(variant, t);
        COMUtils.checkRC(hresultOleMethod);
    }

    private void setProperty(String str, Object... objArr) throws COMException {
        setProperty(resolveDispId(getRawDispatch(), str), objArr);
    }

    private void setProperty(OaIdl.DISPID dispid, Object... objArr) throws COMException {
        Variant.VARIANT[] variantArr;
        if (objArr == null) {
            variantArr = new Variant.VARIANT[0];
        } else {
            variantArr = new Variant.VARIANT[objArr.length];
        }
        for (int i = 0; i < variantArr.length; i++) {
            variantArr[i] = Convert.toVariant(objArr[i]);
        }
        new Variant.VARIANT.ByReference();
        WinNT.HRESULT hresultOleMethod = oleMethod(4, (Variant.VARIANT.ByReference) null, getRawDispatch(), dispid, variantArr);
        for (int i2 = 0; i2 < variantArr.length; i2++) {
            Convert.free(variantArr[i2], objArr[i2]);
        }
        COMUtils.checkRC(hresultOleMethod);
    }

    @Override // com.sun.jna.platform.win32.COM.util.IDispatch
    public <T> T getProperty(Class<T> cls, String str, Object... objArr) {
        return (T) getProperty(cls, resolveDispId(getRawDispatch(), str), objArr);
    }

    @Override // com.sun.jna.platform.win32.COM.util.IDispatch
    public <T> T getProperty(Class<T> cls, OaIdl.DISPID dispid, Object... objArr) throws COMException {
        Variant.VARIANT[] variantArr;
        if (objArr == null) {
            variantArr = new Variant.VARIANT[0];
        } else {
            variantArr = new Variant.VARIANT[objArr.length];
        }
        for (int i = 0; i < variantArr.length; i++) {
            variantArr[i] = Convert.toVariant(objArr[i]);
        }
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        WinNT.HRESULT hresultOleMethod = oleMethod(2, byReference, getRawDispatch(), dispid, variantArr);
        for (int i2 = 0; i2 < variantArr.length; i2++) {
            Convert.free(variantArr[i2], objArr[i2]);
        }
        COMUtils.checkRC(hresultOleMethod);
        return (T) Convert.toJavaObject(byReference, cls, this.factory, false, true);
    }

    @Override // com.sun.jna.platform.win32.COM.util.IDispatch
    public <T> T invokeMethod(Class<T> cls, String str, Object... objArr) {
        return (T) invokeMethod(cls, resolveDispId(getRawDispatch(), str), objArr);
    }

    @Override // com.sun.jna.platform.win32.COM.util.IDispatch
    public <T> T invokeMethod(Class<T> cls, OaIdl.DISPID dispid, Object... objArr) throws COMException {
        Variant.VARIANT[] variantArr;
        if (objArr == null) {
            variantArr = new Variant.VARIANT[0];
        } else {
            variantArr = new Variant.VARIANT[objArr.length];
        }
        for (int i = 0; i < variantArr.length; i++) {
            variantArr[i] = Convert.toVariant(objArr[i]);
        }
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        WinNT.HRESULT hresultOleMethod = oleMethod(1, byReference, getRawDispatch(), dispid, variantArr);
        for (int i2 = 0; i2 < variantArr.length; i2++) {
            Convert.free(variantArr[i2], objArr[i2]);
        }
        COMUtils.checkRC(hresultOleMethod);
        return (T) Convert.toJavaObject(byReference, cls, this.factory, false, true);
    }

    private Object[] unfoldWhenVarargs(Method method, Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0 || !method.isVarArgs() || !(objArr[objArr.length - 1] instanceof Object[])) {
            return objArr;
        }
        Object[] objArr2 = (Object[]) objArr[objArr.length - 1];
        Object[] objArr3 = new Object[(objArr.length - 1) + objArr2.length];
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length - 1);
        System.arraycopy(objArr2, 0, objArr3, objArr.length - 1, objArr2.length);
        return objArr3;
    }

    @Override // com.sun.jna.platform.win32.COM.util.IUnknown
    public <T> T queryInterface(Class<T> cls) throws COMException {
        try {
            ComInterface comInterface = (ComInterface) cls.getAnnotation(ComInterface.class);
            if (comInterface == null) {
                throw new COMException("queryInterface: Interface must define a value for iid via the ComInterface annotation");
            }
            Guid.IID iid = getIID(comInterface);
            PointerByReference pointerByReference = new PointerByReference();
            WinNT.HRESULT hresultQueryInterface = getRawDispatch().QueryInterface(new Guid.REFIID(iid), pointerByReference);
            if (WinNT.S_OK.equals(hresultQueryInterface)) {
                Dispatch dispatch = new Dispatch(pointerByReference.getValue());
                T t = (T) this.factory.createProxy(cls, dispatch);
                dispatch.Release();
                return t;
            }
            throw new COMException("queryInterface: " + Kernel32Util.formatMessage(hresultQueryInterface), hresultQueryInterface);
        } catch (RuntimeException e) {
            if (e instanceof COMException) {
                throw e;
            }
            throw new COMException("Error occured when trying to query for interface " + cls.getName(), e);
        }
    }

    private Guid.IID getIID(ComInterface comInterface) {
        String strIid = comInterface.iid();
        if (strIid != null && !strIid.isEmpty()) {
            return new Guid.IID(strIid);
        }
        throw new COMException("ComInterface must define a value for iid");
    }

    private String getAccessorName(Method method, ComProperty comProperty) {
        if (comProperty.name().isEmpty()) {
            String name = method.getName();
            if (name.startsWith("get")) {
                return name.replaceFirst("get", "");
            }
            throw new RuntimeException("Property Accessor name must start with 'get', or set the anotation 'name' value");
        }
        return comProperty.name();
    }

    private String getMutatorName(Method method, ComProperty comProperty) {
        if (comProperty.name().isEmpty()) {
            String name = method.getName();
            if (name.startsWith("set")) {
                return name.replaceFirst("set", "");
            }
            throw new RuntimeException("Property Mutator name must start with 'set', or set the anotation 'name' value");
        }
        return comProperty.name();
    }

    private String getMethodName(Method method, ComMethod comMethod) {
        if (comMethod.name().isEmpty()) {
            return method.getName();
        }
        return comMethod.name();
    }

    protected OaIdl.DISPID resolveDispId(String str) {
        return resolveDispId(getRawDispatch(), str);
    }

    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, String str, Variant.VARIANT variant) throws COMException {
        return oleMethod(i, byReference, str, new Variant.VARIANT[]{variant});
    }

    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, OaIdl.DISPID dispid, Variant.VARIANT variant) throws COMException {
        return oleMethod(i, byReference, dispid, new Variant.VARIANT[]{variant});
    }

    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, String str) throws COMException {
        return oleMethod(i, byReference, str, (Variant.VARIANT[]) null);
    }

    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, OaIdl.DISPID dispid) throws COMException {
        return oleMethod(i, byReference, dispid, (Variant.VARIANT[]) null);
    }

    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, String str, Variant.VARIANT[] variantArr) throws COMException {
        return oleMethod(i, byReference, resolveDispId(str), variantArr);
    }

    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, OaIdl.DISPID dispid, Variant.VARIANT[] variantArr) throws COMException {
        return oleMethod(i, byReference, getRawDispatch(), dispid, variantArr);
    }

    @Deprecated
    protected OaIdl.DISPID resolveDispId(com.sun.jna.platform.win32.COM.IDispatch iDispatch, String str) {
        if (iDispatch == null) {
            throw new COMException("pDisp (IDispatch) parameter is null!");
        }
        WString[] wStringArr = {new WString(str)};
        OaIdl.DISPIDByReference dISPIDByReference = new OaIdl.DISPIDByReference();
        COMUtils.checkRC(iDispatch.GetIDsOfNames(new Guid.REFIID(Guid.IID_NULL), wStringArr, 1, this.factory.getLCID(), dISPIDByReference));
        return dISPIDByReference.getValue();
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, com.sun.jna.platform.win32.COM.IDispatch iDispatch, String str, Variant.VARIANT variant) throws COMException {
        return oleMethod(i, byReference, iDispatch, str, new Variant.VARIANT[]{variant});
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, com.sun.jna.platform.win32.COM.IDispatch iDispatch, OaIdl.DISPID dispid, Variant.VARIANT variant) throws COMException {
        return oleMethod(i, byReference, iDispatch, dispid, new Variant.VARIANT[]{variant});
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, com.sun.jna.platform.win32.COM.IDispatch iDispatch, String str) throws COMException {
        return oleMethod(i, byReference, iDispatch, str, (Variant.VARIANT[]) null);
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, com.sun.jna.platform.win32.COM.IDispatch iDispatch, OaIdl.DISPID dispid) throws COMException {
        return oleMethod(i, byReference, iDispatch, dispid, (Variant.VARIANT[]) null);
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, com.sun.jna.platform.win32.COM.IDispatch iDispatch, String str, Variant.VARIANT[] variantArr) throws COMException {
        return oleMethod(i, byReference, iDispatch, resolveDispId(iDispatch, str), variantArr);
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int i, Variant.VARIANT.ByReference byReference, com.sun.jna.platform.win32.COM.IDispatch iDispatch, OaIdl.DISPID dispid, Variant.VARIANT[] variantArr) throws COMException {
        Variant.VARIANT[] variantArr2;
        int length;
        int i2 = i;
        if (iDispatch == null) {
            throw new COMException("pDisp (IDispatch) parameter is null!");
        }
        OleAuto.DISPPARAMS.ByReference byReference2 = new OleAuto.DISPPARAMS.ByReference();
        OaIdl.EXCEPINFO.ByReference byReference3 = new OaIdl.EXCEPINFO.ByReference();
        IntByReference intByReference = new IntByReference();
        if (variantArr == null || variantArr.length <= 0) {
            variantArr2 = null;
            length = 0;
        } else {
            length = variantArr.length;
            variantArr2 = new Variant.VARIANT[length];
            int i3 = length;
            for (int i4 = 0; i4 < length; i4++) {
                i3--;
                variantArr2[i4] = variantArr[i3];
            }
        }
        if (i2 == 4) {
            byReference2.setRgdispidNamedArgs(new OaIdl.DISPID[]{OaIdl.DISPID_PROPERTYPUT});
        }
        if (i2 == 1 || i2 == 2) {
            i2 = 3;
        }
        if (length > 0) {
            byReference2.setArgs(variantArr2);
            byReference2.write();
        }
        WinNT.HRESULT hresultInvoke = iDispatch.Invoke(dispid, new Guid.REFIID(Guid.IID_NULL), this.factory.getLCID(), new WinDef.WORD(i2), byReference2, byReference, byReference3, intByReference);
        COMUtils.checkRC(hresultInvoke, byReference3, intByReference);
        return hresultInvoke;
    }
}
