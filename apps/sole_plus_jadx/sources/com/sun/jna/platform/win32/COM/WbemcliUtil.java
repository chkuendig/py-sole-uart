package com.sun.jna.platform.win32.COM;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.COM.Wbemcli;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Logger;

/* loaded from: classes4.dex */
public class WbemcliUtil {
    public static final String DEFAULT_NAMESPACE = "ROOT\\CIMV2";
    public static final WbemcliUtil INSTANCE = new WbemcliUtil();

    private enum NamespaceProperty {
        NAME
    }

    public static class WmiQuery<T extends Enum<T>> {
        private String nameSpace;
        private Class<T> propertyEnum;
        private String wmiClassName;

        public WmiQuery(String str, String str2, Class<T> cls) {
            this.nameSpace = str;
            this.wmiClassName = str2;
            this.propertyEnum = cls;
        }

        public WmiQuery(String str, Class<T> cls) {
            this(WbemcliUtil.DEFAULT_NAMESPACE, str, cls);
        }

        public Class<T> getPropertyEnum() {
            return this.propertyEnum;
        }

        public String getNameSpace() {
            return this.nameSpace;
        }

        public void setNameSpace(String str) {
            this.nameSpace = str;
        }

        public String getWmiClassName() {
            return this.wmiClassName;
        }

        public void setWmiClassName(String str) {
            this.wmiClassName = str;
        }

        public WmiResult<T> execute() {
            try {
                return execute(-1);
            } catch (TimeoutException unused) {
                throw new COMException("Got a WMI timeout when infinite wait was specified. This should never happen.");
            }
        }

        public WmiResult<T> execute(int i) throws TimeoutException {
            if (getPropertyEnum().getEnumConstants().length < 1) {
                throw new IllegalArgumentException("The query's property enum has no values.");
            }
            Wbemcli.IWbemServices iWbemServicesConnectServer = WbemcliUtil.connectServer(getNameSpace());
            try {
                Wbemcli.IEnumWbemClassObject iEnumWbemClassObjectSelectProperties = selectProperties(iWbemServicesConnectServer, this);
                try {
                    return enumerateProperties(iEnumWbemClassObjectSelectProperties, getPropertyEnum(), i);
                } finally {
                    iEnumWbemClassObjectSelectProperties.Release();
                }
            } finally {
                iWbemServicesConnectServer.Release();
            }
        }

        private static <T extends Enum<T>> Wbemcli.IEnumWbemClassObject selectProperties(Wbemcli.IWbemServices iWbemServices, WmiQuery<T> wmiQuery) {
            T[] enumConstants = wmiQuery.getPropertyEnum().getEnumConstants();
            StringBuilder sb = new StringBuilder("SELECT ");
            sb.append(enumConstants[0].name());
            for (int i = 1; i < enumConstants.length; i++) {
                sb.append(AbstractJsonLexerKt.COMMA).append(enumConstants[i].name());
            }
            sb.append(" FROM ").append(wmiQuery.getWmiClassName());
            return iWbemServices.ExecQuery("WQL", sb.toString().replaceAll("\\\\", "\\\\\\\\"), 48, null);
        }

        private static <T extends Enum<T>> WmiResult<T> enumerateProperties(Wbemcli.IEnumWbemClassObject iEnumWbemClassObject, Class<T> cls, int i) throws TimeoutException {
            WbemcliUtil wbemcliUtil = WbemcliUtil.INSTANCE;
            wbemcliUtil.getClass();
            WmiResult<T> wmiResult = wbemcliUtil.new WmiResult<>(cls);
            Pointer[] pointerArr = new Pointer[1];
            int i2 = 0;
            IntByReference intByReference = new IntByReference(0);
            HashMap map = new HashMap();
            for (T t : cls.getEnumConstants()) {
                map.put(t, new WString(t.name()));
            }
            while (iEnumWbemClassObject.getPointer() != Pointer.NULL) {
                WinNT.HRESULT hresultNext = iEnumWbemClassObject.Next(i, 1, pointerArr, intByReference);
                if (hresultNext.intValue() == 1 || hresultNext.intValue() == 262149) {
                    break;
                }
                if (hresultNext.intValue() == 262148) {
                    throw new TimeoutException("No results after " + i + " ms.");
                }
                if (COMUtils.FAILED(hresultNext)) {
                    throw new COMException("Failed to enumerate results.", hresultNext);
                }
                Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
                IntByReference intByReference2 = new IntByReference();
                Wbemcli.IWbemClassObject iWbemClassObject = new Wbemcli.IWbemClassObject(pointerArr[i2]);
                T[] enumConstants = cls.getEnumConstants();
                int length = enumConstants.length;
                int i3 = i2;
                while (i3 < length) {
                    T t2 = enumConstants[i3];
                    int i4 = i3;
                    int i5 = length;
                    T[] tArr = enumConstants;
                    Wbemcli.IWbemClassObject iWbemClassObject2 = iWbemClassObject;
                    iWbemClassObject.Get((WString) map.get(t2), 0, byReference, intByReference2, (IntByReference) null);
                    int iIntValue = (byReference.getValue() == null ? 1 : byReference.getVarType()).intValue();
                    int value = intByReference2.getValue();
                    if (iIntValue == 0 || iIntValue == 1) {
                        wmiResult.add(iIntValue, value, t2, null);
                    } else if (iIntValue == 2) {
                        wmiResult.add(iIntValue, value, t2, Short.valueOf(byReference.shortValue()));
                    } else if (iIntValue == 3) {
                        wmiResult.add(iIntValue, value, t2, Integer.valueOf(byReference.intValue()));
                    } else if (iIntValue == 4) {
                        wmiResult.add(iIntValue, value, t2, Float.valueOf(byReference.floatValue()));
                    } else if (iIntValue == 5) {
                        wmiResult.add(iIntValue, value, t2, Double.valueOf(byReference.doubleValue()));
                    } else if (iIntValue == 8) {
                        wmiResult.add(iIntValue, value, t2, byReference.stringValue());
                    } else if (iIntValue == 11) {
                        wmiResult.add(iIntValue, value, t2, Boolean.valueOf(byReference.booleanValue()));
                    } else if (iIntValue == 17) {
                        wmiResult.add(iIntValue, value, t2, Byte.valueOf(byReference.byteValue()));
                    } else if ((iIntValue & 8192) == 8192 || (iIntValue & 13) == 13 || (iIntValue & 9) == 9 || (iIntValue & 4096) == 4096) {
                        wmiResult.add(iIntValue, value, t2, null);
                    } else {
                        wmiResult.add(iIntValue, value, t2, byReference.getValue());
                    }
                    OleAuto.INSTANCE.VariantClear(byReference);
                    i3 = i4 + 1;
                    enumConstants = tArr;
                    length = i5;
                    iWbemClassObject = iWbemClassObject2;
                }
                iWbemClassObject.Release();
                wmiResult.incrementResultCount();
                i2 = 0;
            }
            return wmiResult;
        }
    }

    public class WmiResult<T extends Enum<T>> {
        private Map<T, Integer> cimTypeMap;
        private Map<T, List<Object>> propertyMap;
        private int resultCount = 0;
        private Map<T, Integer> vtTypeMap;

        public WmiResult(Class<T> cls) {
            this.propertyMap = new EnumMap(cls);
            this.vtTypeMap = new EnumMap(cls);
            this.cimTypeMap = new EnumMap(cls);
            for (T t : cls.getEnumConstants()) {
                this.propertyMap.put(t, new ArrayList());
                this.vtTypeMap.put(t, 1);
                this.cimTypeMap.put(t, 0);
            }
        }

        public Object getValue(T t, int i) {
            return this.propertyMap.get(t).get(i);
        }

        public int getVtType(T t) {
            return this.vtTypeMap.get(t).intValue();
        }

        public int getCIMType(T t) {
            return this.cimTypeMap.get(t).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void add(int i, int i2, T t, Object obj) {
            this.propertyMap.get(t).add(obj);
            if (i != 1 && this.vtTypeMap.get(t).equals(1)) {
                this.vtTypeMap.put(t, Integer.valueOf(i));
            }
            if (this.cimTypeMap.get(t).equals(0)) {
                this.cimTypeMap.put(t, Integer.valueOf(i2));
            }
        }

        public int getResultCount() {
            return this.resultCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incrementResultCount() {
            this.resultCount++;
        }
    }

    public static boolean hasNamespace(String str) {
        if (str.toUpperCase().startsWith("ROOT\\")) {
            str = str.substring(5);
        }
        WmiResult wmiResultExecute = new WmiQuery(Logger.ROOT_LOGGER_NAME, "__NAMESPACE", NamespaceProperty.class).execute();
        for (int i = 0; i < wmiResultExecute.getResultCount(); i++) {
            if (str.equalsIgnoreCase((String) wmiResultExecute.getValue(NamespaceProperty.NAME, i))) {
                return true;
            }
        }
        return false;
    }

    public static Wbemcli.IWbemServices connectServer(String str) {
        Wbemcli.IWbemLocator iWbemLocatorCreate = Wbemcli.IWbemLocator.create();
        if (iWbemLocatorCreate == null) {
            throw new COMException("Failed to create WbemLocator object.");
        }
        Wbemcli.IWbemServices iWbemServicesConnectServer = iWbemLocatorCreate.ConnectServer(str, null, null, null, 0, null, null);
        iWbemLocatorCreate.Release();
        WinNT.HRESULT hresultCoSetProxyBlanket = Ole32.INSTANCE.CoSetProxyBlanket(iWbemServicesConnectServer, 10, 0, null, 3, 3, null, 0);
        if (!COMUtils.FAILED(hresultCoSetProxyBlanket)) {
            return iWbemServicesConnectServer;
        }
        iWbemServicesConnectServer.Release();
        throw new COMException("Could not set proxy blanket.", hresultCoSetProxyBlanket);
    }
}
