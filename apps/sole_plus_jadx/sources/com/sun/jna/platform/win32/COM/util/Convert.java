package com.sun.jna.platform.win32.COM.util;

import com.android.SdkConstants;
import com.sun.jna.platform.win32.COM.Dispatch;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinDef;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Date;

/* loaded from: classes4.dex */
class Convert {
    Convert() {
    }

    public static Variant.VARIANT toVariant(Object obj) {
        Constructor<?> constructor;
        if (obj instanceof Variant.VARIANT) {
            return (Variant.VARIANT) obj;
        }
        if (obj instanceof Byte) {
            return new Variant.VARIANT(((Byte) obj).byteValue());
        }
        if (obj instanceof Character) {
            return new Variant.VARIANT(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return new Variant.VARIANT(((Short) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new Variant.VARIANT(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return new Variant.VARIANT(((Long) obj).longValue());
        }
        if (obj instanceof Float) {
            return new Variant.VARIANT(((Float) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new Variant.VARIANT(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return new Variant.VARIANT((String) obj);
        }
        if (obj instanceof Boolean) {
            return new Variant.VARIANT(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Dispatch) {
            return new Variant.VARIANT((Dispatch) obj);
        }
        if (obj instanceof Date) {
            return new Variant.VARIANT((Date) obj);
        }
        if (obj instanceof Proxy) {
            return new Variant.VARIANT(((ProxyObject) Proxy.getInvocationHandler(obj)).getRawDispatch());
        }
        if (obj instanceof IComEnum) {
            return new Variant.VARIANT(new WinDef.LONG(((IComEnum) obj).getValue()));
        }
        if (obj != null) {
            constructor = null;
            for (Constructor<?> constructor2 : Variant.VARIANT.class.getConstructors()) {
                Class<?>[] parameterTypes = constructor2.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(obj.getClass())) {
                    constructor = constructor2;
                }
            }
        } else {
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        try {
            return (Variant.VARIANT) constructor.newInstance(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object toJavaObject(com.sun.jna.platform.win32.Variant.VARIANT r5, java.lang.Class<?> r6, com.sun.jna.platform.win32.COM.util.ObjectFactory r7, boolean r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.platform.win32.COM.util.Convert.toJavaObject(com.sun.jna.platform.win32.Variant$VARIANT, java.lang.Class, com.sun.jna.platform.win32.COM.util.ObjectFactory, boolean, boolean):java.lang.Object");
    }

    public static <T extends IComEnum> T toComEnum(Class<T> cls, Object obj) {
        try {
            for (IComEnum iComEnum : (IComEnum[]) cls.getMethod(SdkConstants.FD_RES_VALUES, new Class[0]).invoke(null, new Object[0])) {
                T t = (T) iComEnum;
                if (obj.equals(Long.valueOf(t.getValue()))) {
                    return t;
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return null;
    }

    public static void free(Variant.VARIANT variant, Class<?> cls) {
        if ((cls == null || !WTypes.BSTR.class.isAssignableFrom(cls)) && variant != null && variant.getVarType().intValue() == 8) {
            Object value = variant.getValue();
            if (value instanceof WTypes.BSTR) {
                OleAuto.INSTANCE.SysFreeString((WTypes.BSTR) value);
            }
        }
    }

    public static void free(Variant.VARIANT variant, Object obj) {
        free(variant, obj == null ? null : obj.getClass());
    }
}
