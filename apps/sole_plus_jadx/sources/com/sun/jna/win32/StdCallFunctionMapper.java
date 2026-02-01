package com.sun.jna.win32;

import com.android.SdkConstants;
import com.sun.jna.FunctionMapper;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class StdCallFunctionMapper implements FunctionMapper {
    protected int getArgumentNativeStackSize(Class<?> cls) {
        if (NativeMapped.class.isAssignableFrom(cls)) {
            cls = NativeMappedConverter.getInstance(cls).nativeType();
        }
        if (cls.isArray()) {
            return Native.POINTER_SIZE;
        }
        try {
            return Native.getNativeSize(cls);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Unknown native stack allocation size for " + cls);
        }
    }

    @Override // com.sun.jna.FunctionMapper
    public String getFunctionName(NativeLibrary nativeLibrary, Method method) {
        String name = method.getName();
        int argumentNativeStackSize = 0;
        for (Class<?> cls : method.getParameterTypes()) {
            argumentNativeStackSize += getArgumentNativeStackSize(cls);
        }
        String str = name + SdkConstants.PREFIX_RESOURCE_REF + argumentNativeStackSize;
        try {
            try {
                return nativeLibrary.getFunction(str, 63).getName();
            } catch (UnsatisfiedLinkError unused) {
                return name;
            }
        } catch (UnsatisfiedLinkError unused2) {
            return nativeLibrary.getFunction("_" + str, 63).getName();
        }
    }
}
