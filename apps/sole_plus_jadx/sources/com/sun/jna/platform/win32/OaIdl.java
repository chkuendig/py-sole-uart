package com.sun.jna.platform.win32;

import com.sun.jna.IntegerType;
import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.Dispatch;
import com.sun.jna.platform.win32.COM.TypeComp;
import com.sun.jna.platform.win32.COM.Unknown;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.ByReference;
import com.sun.jna.ptr.PointerByReference;
import java.io.Closeable;
import java.util.Date;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes4.dex */
public interface OaIdl {
    public static final long DATE_OFFSET = new Date(-1, 11, 30, 0, 0, 0).getTime();
    public static final DISPID DISPID_COLLECT = new DISPID(-8);
    public static final DISPID DISPID_CONSTRUCTOR = new DISPID(-6);
    public static final DISPID DISPID_DESTRUCTOR = new DISPID(-7);
    public static final DISPID DISPID_EVALUATE = new DISPID(-5);
    public static final DISPID DISPID_NEWENUM = new DISPID(-4);
    public static final DISPID DISPID_PROPERTYPUT = new DISPID(-3);
    public static final DISPID DISPID_UNKNOWN;
    public static final DISPID DISPID_VALUE;
    public static final int FADF_AUTO = 1;
    public static final int FADF_BSTR = 256;
    public static final int FADF_DISPATCH = 1024;
    public static final int FADF_EMBEDDED = 4;
    public static final int FADF_FIXEDSIZE = 16;
    public static final int FADF_HAVEIID = 64;
    public static final int FADF_HAVEVARTYPE = 128;
    public static final int FADF_RECORD = 32;
    public static final int FADF_RESERVED = 61448;
    public static final int FADF_STATIC = 2;
    public static final int FADF_UNKNOWN = 512;
    public static final int FADF_VARIANT = 2048;
    public static final MEMBERID MEMBERID_NIL;

    static {
        DISPID dispid = new DISPID(-1);
        DISPID_UNKNOWN = dispid;
        DISPID_VALUE = new DISPID(0);
        MEMBERID_NIL = new MEMBERID(dispid.intValue());
    }

    @Structure.FieldOrder({"wCode", "wReserved", "bstrSource", "bstrDescription", "bstrHelpFile", "dwHelpContext", "pvReserved", "pfnDeferredFillIn", "scode"})
    public static class EXCEPINFO extends Structure {
        public WTypes.BSTR bstrDescription;
        public WTypes.BSTR bstrHelpFile;
        public WTypes.BSTR bstrSource;
        public WinDef.DWORD dwHelpContext;
        public ByReference pfnDeferredFillIn;
        public WinDef.PVOID pvReserved;
        public WinDef.SCODE scode;
        public WinDef.WORD wCode;
        public WinDef.WORD wReserved;

        public static class ByReference extends EXCEPINFO implements Structure.ByReference {
        }

        public EXCEPINFO() {
        }

        public EXCEPINFO(Pointer pointer) {
            super(pointer);
        }
    }

    public static class VARIANT_BOOL extends IntegerType {
        public static final int SIZE = 2;
        private static final long serialVersionUID = 1;

        public VARIANT_BOOL() {
            this(0L);
        }

        public VARIANT_BOOL(long j) {
            super(2, j);
        }

        public VARIANT_BOOL(boolean z) {
            this(z ? WebSocketProtocol.PAYLOAD_SHORT_MAX : 0L);
        }

        public boolean booleanValue() {
            return shortValue() != 0;
        }
    }

    public static class _VARIANT_BOOL extends VARIANT_BOOL {
        private static final long serialVersionUID = 1;

        public _VARIANT_BOOL() {
            this(0L);
        }

        public _VARIANT_BOOL(long j) {
            super(j);
        }
    }

    public static class VARIANT_BOOLByReference extends ByReference {
        public VARIANT_BOOLByReference() {
            this(new VARIANT_BOOL(0L));
        }

        public VARIANT_BOOLByReference(VARIANT_BOOL variant_bool) {
            super(2);
            setValue(variant_bool);
        }

        public void setValue(VARIANT_BOOL variant_bool) {
            getPointer().setShort(0L, variant_bool.shortValue());
        }

        public VARIANT_BOOL getValue() {
            return new VARIANT_BOOL(getPointer().getShort(0L));
        }
    }

    public static class _VARIANT_BOOLByReference extends ByReference {
        public _VARIANT_BOOLByReference() {
            this(new VARIANT_BOOL(0L));
        }

        public _VARIANT_BOOLByReference(VARIANT_BOOL variant_bool) {
            super(2);
            setValue(variant_bool);
        }

        public void setValue(VARIANT_BOOL variant_bool) {
            getPointer().setShort(0L, variant_bool.shortValue());
        }

        public VARIANT_BOOL getValue() {
            return new VARIANT_BOOL(getPointer().getShort(0L));
        }
    }

    @Structure.FieldOrder({"date"})
    public static class DATE extends Structure {
        private static final long MICRO_SECONDS_PER_DAY = 86400000;
        public double date;

        public static class ByReference extends DATE implements Structure.ByReference {
        }

        public DATE() {
        }

        public DATE(double d) {
            this.date = d;
        }

        public DATE(Date date) {
            setFromJavaDate(date);
        }

        public Date getAsJavaDate() {
            long j = (((long) this.date) * 86400000) + OaIdl.DATE_OFFSET;
            double dAbs = Math.abs(this.date - ((long) r2)) * 24.0d;
            int i = (int) dAbs;
            double d = (dAbs - i) * 60.0d;
            int i2 = (int) d;
            Date date = new Date(j);
            date.setHours(i);
            date.setMinutes(i2);
            date.setSeconds((int) ((d - i2) * 60.0d));
            date.setTime(date.getTime() + ((int) ((r2 - r5) * 1000.0d)));
            return date;
        }

        public void setFromJavaDate(Date date) {
            double time = (date.getTime() - OaIdl.DATE_OFFSET) / 8.64E7d;
            Date date2 = new Date(date.getTime());
            date2.setHours(0);
            date2.setMinutes(0);
            date2.setSeconds(0);
            date2.setTime((date2.getTime() / 1000) * 1000);
            this.date = Math.floor(time) + (Math.signum(time) * ((date.getTime() - date2.getTime()) / 8.64E7d));
        }
    }

    public static class DISPID extends WinDef.LONG {
        private static final long serialVersionUID = 1;

        public DISPID() {
            this(0);
        }

        public DISPID(int i) {
            super(i);
        }
    }

    public static class DISPIDByReference extends ByReference {
        public DISPIDByReference() {
            this(new DISPID(0));
        }

        public DISPIDByReference(DISPID dispid) {
            super(DISPID.SIZE);
            setValue(dispid);
        }

        public void setValue(DISPID dispid) {
            getPointer().setInt(0L, dispid.intValue());
        }

        public DISPID getValue() {
            return new DISPID(getPointer().getInt(0L));
        }
    }

    public static class MEMBERID extends DISPID {
        private static final long serialVersionUID = 1;

        public MEMBERID() {
            this(0);
        }

        public MEMBERID(int i) {
            super(i);
        }
    }

    public static class MEMBERIDByReference extends ByReference {
        public MEMBERIDByReference() {
            this(new MEMBERID(0));
        }

        public MEMBERIDByReference(MEMBERID memberid) {
            super(MEMBERID.SIZE);
            setValue(memberid);
        }

        public void setValue(MEMBERID memberid) {
            getPointer().setInt(0L, memberid.intValue());
        }

        public MEMBERID getValue() {
            return new MEMBERID(getPointer().getInt(0L));
        }
    }

    @Structure.FieldOrder({"value"})
    public static class TYPEKIND extends Structure {
        public static final int TKIND_ALIAS = 6;
        public static final int TKIND_COCLASS = 5;
        public static final int TKIND_DISPATCH = 4;
        public static final int TKIND_ENUM = 0;
        public static final int TKIND_INTERFACE = 3;
        public static final int TKIND_MAX = 8;
        public static final int TKIND_MODULE = 2;
        public static final int TKIND_RECORD = 1;
        public static final int TKIND_UNION = 7;
        public int value;

        public static class ByReference extends TYPEKIND implements Structure.ByReference {
            public ByReference() {
            }

            public ByReference(int i) {
                super(i);
            }

            public ByReference(TYPEKIND typekind) {
                super(typekind.getPointer());
                this.value = typekind.value;
            }
        }

        public TYPEKIND() {
        }

        public TYPEKIND(int i) {
            this.value = i;
        }

        public TYPEKIND(Pointer pointer) {
            super(pointer);
            read();
        }
    }

    @Structure.FieldOrder({"value"})
    public static class DESCKIND extends Structure {
        public static final int DESCKIND_FUNCDESC = 1;
        public static final int DESCKIND_IMPLICITAPPOBJ = 4;
        public static final int DESCKIND_MAX = 5;
        public static final int DESCKIND_NONE = 0;
        public static final int DESCKIND_TYPECOMP = 3;
        public static final int DESCKIND_VARDESC = 2;
        public int value;

        public static class ByReference extends DESCKIND implements Structure.ByReference {
        }

        public DESCKIND() {
        }

        public DESCKIND(int i) {
            this.value = i;
        }

        public DESCKIND(Pointer pointer) {
            super(pointer);
            read();
        }
    }

    @Structure.FieldOrder({"cDims", "fFeatures", "cbElements", "cLocks", "pvData", "rgsabound"})
    public static class SAFEARRAY extends Structure implements Closeable {
        public WinDef.USHORT cDims;
        public WinDef.ULONG cLocks;
        public WinDef.ULONG cbElements;
        public WinDef.USHORT fFeatures;
        public WinDef.PVOID pvData;
        public SAFEARRAYBOUND[] rgsabound;

        public static class ByReference extends SAFEARRAY implements Structure.ByReference {
        }

        public SAFEARRAY() {
            this.rgsabound = new SAFEARRAYBOUND[]{new SAFEARRAYBOUND()};
        }

        public SAFEARRAY(Pointer pointer) {
            super(pointer);
            this.rgsabound = new SAFEARRAYBOUND[]{new SAFEARRAYBOUND()};
            read();
        }

        @Override // com.sun.jna.Structure
        public void read() {
            super.read();
            if (this.cDims.intValue() > 0) {
                this.rgsabound = (SAFEARRAYBOUND[]) this.rgsabound[0].toArray(this.cDims.intValue());
            } else {
                this.rgsabound = new SAFEARRAYBOUND[]{new SAFEARRAYBOUND()};
            }
        }

        public static ByReference createSafeArray(int... iArr) {
            return createSafeArray(new WTypes.VARTYPE(12), iArr);
        }

        public static ByReference createSafeArray(WTypes.VARTYPE vartype, int... iArr) {
            SAFEARRAYBOUND[] safearrayboundArr = (SAFEARRAYBOUND[]) new SAFEARRAYBOUND().toArray(iArr.length);
            for (int i = 0; i < iArr.length; i++) {
                safearrayboundArr[i].lLbound = new WinDef.LONG(0L);
                safearrayboundArr[i].cElements = new WinDef.ULONG(iArr[(iArr.length - i) - 1]);
            }
            return OleAuto.INSTANCE.SafeArrayCreate(vartype, new WinDef.UINT(iArr.length), safearrayboundArr);
        }

        public void putElement(Object obj, int... iArr) {
            WinDef.LONG[] longArr = new WinDef.LONG[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                longArr[i] = new WinDef.LONG(iArr[(iArr.length - i) - 1]);
            }
            switch (getVarType().intValue()) {
                case 2:
                case 18:
                    Memory memory = new Memory(2L);
                    memory.setShort(0L, ((Number) obj).shortValue());
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, memory));
                    return;
                case 3:
                case 19:
                case 22:
                case 23:
                    Memory memory2 = new Memory(4L);
                    memory2.setInt(0L, ((Number) obj).intValue());
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, memory2));
                    return;
                case 4:
                    Memory memory3 = new Memory(4L);
                    memory3.setFloat(0L, ((Number) obj).floatValue());
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, memory3));
                    return;
                case 5:
                    Memory memory4 = new Memory(8L);
                    memory4.setDouble(0L, ((Number) obj).doubleValue());
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, memory4));
                    return;
                case 6:
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, ((CURRENCY) obj).getPointer()));
                    return;
                case 7:
                    Memory memory5 = new Memory(8L);
                    memory5.setDouble(0L, ((DATE) obj).date);
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, memory5));
                    return;
                case 8:
                    if (obj instanceof String) {
                        WTypes.BSTR bstrSysAllocString = OleAuto.INSTANCE.SysAllocString((String) obj);
                        WinNT.HRESULT hresultSafeArrayPutElement = OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, bstrSysAllocString.getPointer());
                        OleAuto.INSTANCE.SysFreeString(bstrSysAllocString);
                        COMUtils.checkRC(hresultSafeArrayPutElement);
                        return;
                    }
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, ((WTypes.BSTR) obj).getPointer()));
                    return;
                case 9:
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, ((Dispatch) obj).getPointer()));
                    return;
                case 10:
                    Memory memory6 = new Memory(4L);
                    memory6.setInt(0L, ((Number) obj).intValue());
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, memory6));
                    return;
                case 11:
                    Memory memory7 = new Memory(2L);
                    if (obj instanceof Boolean) {
                        memory7.setShort(0L, (short) (((Boolean) obj).booleanValue() ? 65535 : 0));
                    } else {
                        memory7.setShort(0L, (short) (((Number) obj).intValue() > 0 ? 65535 : 0));
                    }
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, memory7));
                    return;
                case 12:
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, ((Variant.VARIANT) obj).getPointer()));
                    return;
                case 13:
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, ((Unknown) obj).getPointer()));
                    return;
                case 14:
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, ((DECIMAL) obj).getPointer()));
                    return;
                case 15:
                case 20:
                case 21:
                default:
                    throw new IllegalStateException("Can't parse array content - type not supported: " + getVarType().intValue());
                case 16:
                case 17:
                    Memory memory8 = new Memory(1L);
                    memory8.setByte(0L, ((Number) obj).byteValue());
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPutElement(this, longArr, memory8));
                    return;
            }
        }

        public Object getElement(int... iArr) {
            Object date;
            WinDef.LONG[] longArr = new WinDef.LONG[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                longArr[i] = new WinDef.LONG(iArr[(iArr.length - i) - 1]);
            }
            switch (getVarType().intValue()) {
                case 2:
                case 18:
                    Memory memory = new Memory(2L);
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, memory));
                    return Short.valueOf(memory.getShort(0L));
                case 3:
                case 19:
                case 22:
                case 23:
                    Memory memory2 = new Memory(4L);
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, memory2));
                    return Integer.valueOf(memory2.getInt(0L));
                case 4:
                    Memory memory3 = new Memory(4L);
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, memory3));
                    return Float.valueOf(memory3.getFloat(0L));
                case 5:
                    Memory memory4 = new Memory(8L);
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, memory4));
                    return Double.valueOf(memory4.getDouble(0L));
                case 6:
                    CURRENCY currency = new CURRENCY();
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, currency.getPointer()));
                    return currency;
                case 7:
                    Memory memory5 = new Memory(8L);
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, memory5));
                    date = new DATE(memory5.getDouble(0L));
                    break;
                case 8:
                    PointerByReference pointerByReference = new PointerByReference();
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, pointerByReference.getPointer()));
                    WTypes.BSTR bstr = new WTypes.BSTR(pointerByReference.getValue());
                    String value = bstr.getValue();
                    OleAuto.INSTANCE.SysFreeString(bstr);
                    return value;
                case 9:
                    PointerByReference pointerByReference2 = new PointerByReference();
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, pointerByReference2.getPointer()));
                    date = new Dispatch(pointerByReference2.getValue());
                    break;
                case 10:
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, new Memory(4L)));
                    date = new WinDef.SCODE(r12.getInt(0L));
                    break;
                case 11:
                    Memory memory6 = new Memory(2L);
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, memory6));
                    return Boolean.valueOf(memory6.getShort(0L) != 0);
                case 12:
                    Variant.VARIANT variant = new Variant.VARIANT();
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, variant.getPointer()));
                    return variant;
                case 13:
                    PointerByReference pointerByReference3 = new PointerByReference();
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, pointerByReference3.getPointer()));
                    date = new Unknown(pointerByReference3.getValue());
                    break;
                case 14:
                    DECIMAL decimal = new DECIMAL();
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, decimal.getPointer()));
                    return decimal;
                case 15:
                case 20:
                case 21:
                default:
                    throw new IllegalStateException("Can't parse array content - type not supported: " + getVarType().intValue());
                case 16:
                case 17:
                    Memory memory7 = new Memory(1L);
                    COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetElement(this, longArr, memory7));
                    return Byte.valueOf(memory7.getByte(0L));
            }
            return date;
        }

        public Pointer ptrOfIndex(int... iArr) {
            WinDef.LONG[] longArr = new WinDef.LONG[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                longArr[i] = new WinDef.LONG(iArr[(iArr.length - i) - 1]);
            }
            PointerByReference pointerByReference = new PointerByReference();
            COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayPtrOfIndex(this, longArr, pointerByReference));
            return pointerByReference.getValue();
        }

        public void destroy() {
            COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayDestroy(this));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            destroy();
        }

        public int getLBound(int i) {
            int dimensionCount = getDimensionCount() - i;
            WinDef.LONGByReference lONGByReference = new WinDef.LONGByReference();
            COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetLBound(this, new WinDef.UINT(dimensionCount), lONGByReference));
            return lONGByReference.getValue().intValue();
        }

        public int getUBound(int i) {
            int dimensionCount = getDimensionCount() - i;
            WinDef.LONGByReference lONGByReference = new WinDef.LONGByReference();
            COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetUBound(this, new WinDef.UINT(dimensionCount), lONGByReference));
            return lONGByReference.getValue().intValue();
        }

        public int getDimensionCount() {
            return OleAuto.INSTANCE.SafeArrayGetDim(this).intValue();
        }

        public Pointer accessData() {
            PointerByReference pointerByReference = new PointerByReference();
            COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayAccessData(this, pointerByReference));
            return pointerByReference.getValue();
        }

        public void unaccessData() {
            COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayUnaccessData(this));
        }

        public void lock() {
            COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayLock(this));
        }

        public void unlock() {
            COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayUnlock(this));
        }

        public void redim(int i, int i2) {
            COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayRedim(this, new SAFEARRAYBOUND(i, i2)));
        }

        public WTypes.VARTYPE getVarType() {
            WTypes.VARTYPEByReference vARTYPEByReference = new WTypes.VARTYPEByReference();
            COMUtils.checkRC(OleAuto.INSTANCE.SafeArrayGetVartype(this, vARTYPEByReference));
            return vARTYPEByReference.getValue();
        }

        public long getElemsize() {
            return OleAuto.INSTANCE.SafeArrayGetElemsize(this).longValue();
        }
    }

    @Structure.FieldOrder({"pSAFEARRAY"})
    public static class SAFEARRAYByReference extends Structure implements Structure.ByReference {
        public SAFEARRAY.ByReference pSAFEARRAY;

        public SAFEARRAYByReference() {
        }

        public SAFEARRAYByReference(Pointer pointer) {
            super(pointer);
            read();
        }

        public SAFEARRAYByReference(SAFEARRAY.ByReference byReference) {
            this.pSAFEARRAY = byReference;
        }
    }

    @Structure.FieldOrder({"cElements", "lLbound"})
    public static class SAFEARRAYBOUND extends Structure {
        public WinDef.ULONG cElements;
        public WinDef.LONG lLbound;

        public static class ByReference extends SAFEARRAYBOUND implements Structure.ByReference {
        }

        public SAFEARRAYBOUND() {
        }

        public SAFEARRAYBOUND(Pointer pointer) {
            super(pointer);
            read();
        }

        public SAFEARRAYBOUND(int i, int i2) {
            this.cElements = new WinDef.ULONG(i);
            this.lLbound = new WinDef.LONG(i2);
            write();
        }
    }

    public static class CURRENCY extends Union {
        public _CURRENCY currency;
        public WinDef.LONGLONG int64;

        public static class ByReference extends CURRENCY implements Structure.ByReference {
        }

        public CURRENCY() {
        }

        public CURRENCY(Pointer pointer) {
            super(pointer);
            read();
        }

        @Structure.FieldOrder({"Lo", "Hi"})
        public static class _CURRENCY extends Structure {
            public WinDef.LONG Hi;
            public WinDef.ULONG Lo;

            public _CURRENCY() {
            }

            public _CURRENCY(Pointer pointer) {
                super(pointer);
                read();
            }
        }
    }

    @Structure.FieldOrder({"wReserved", "decimal1", "Hi32", "decimal2"})
    public static class DECIMAL extends Structure {
        public NativeLong Hi32;
        public _DECIMAL1 decimal1;
        public _DECIMAL2 decimal2;
        public short wReserved;

        public static class ByReference extends DECIMAL implements Structure.ByReference {
        }

        public static class _DECIMAL1 extends Union {
            public _DECIMAL1_DECIMAL decimal1_DECIMAL;
            public WinDef.USHORT signscale;

            public _DECIMAL1() {
                setType("signscale");
            }

            public _DECIMAL1(Pointer pointer) {
                super(pointer);
                setType("signscale");
                read();
            }

            @Structure.FieldOrder({"scale", "sign"})
            public static class _DECIMAL1_DECIMAL extends Structure {
                public WinDef.BYTE scale;
                public WinDef.BYTE sign;

                public _DECIMAL1_DECIMAL() {
                }

                public _DECIMAL1_DECIMAL(Pointer pointer) {
                    super(pointer);
                }
            }
        }

        public static class _DECIMAL2 extends Union {
            public WinDef.ULONGLONG Lo64;
            public _DECIMAL2_DECIMAL decimal2_DECIMAL;

            public _DECIMAL2() {
                setType("Lo64");
            }

            public _DECIMAL2(Pointer pointer) {
                super(pointer);
                setType("Lo64");
                read();
            }

            @Structure.FieldOrder({"Lo32", "Mid32"})
            public static class _DECIMAL2_DECIMAL extends Structure {
                public WinDef.BYTE Lo32;
                public WinDef.BYTE Mid32;

                public _DECIMAL2_DECIMAL() {
                }

                public _DECIMAL2_DECIMAL(Pointer pointer) {
                    super(pointer);
                }
            }
        }

        public DECIMAL() {
        }

        public DECIMAL(Pointer pointer) {
            super(pointer);
        }
    }

    @Structure.FieldOrder({"value"})
    public static class SYSKIND extends Structure {
        public static final int SYS_MAC = 2;
        public static final int SYS_WIN16 = 0;
        public static final int SYS_WIN32 = 1;
        public static final int SYS_WIN64 = 3;
        public int value;

        public static class ByReference extends SYSKIND implements Structure.ByReference {
        }

        public SYSKIND() {
        }

        public SYSKIND(int i) {
            this.value = i;
        }

        public SYSKIND(Pointer pointer) {
            super(pointer);
            read();
        }
    }

    @Structure.FieldOrder({"value"})
    public static class LIBFLAGS extends Structure {
        public static final int LIBFLAG_FCONTROL = 2;
        public static final int LIBFLAG_FHASDISKIMAGE = 8;
        public static final int LIBFLAG_FHIDDEN = 4;
        public static final int LIBFLAG_FRESTRICTED = 1;
        public int value;

        public static class ByReference extends LIBFLAGS implements Structure.ByReference {
        }

        public LIBFLAGS() {
        }

        public LIBFLAGS(int i) {
            this.value = i;
        }

        public LIBFLAGS(Pointer pointer) {
            super(pointer);
            read();
        }
    }

    @Structure.FieldOrder({"guid", "lcid", "syskind", "wMajorVerNum", "wMinorVerNum", "wLibFlags"})
    public static class TLIBATTR extends Structure {
        public Guid.GUID guid;
        public WinDef.LCID lcid;
        public SYSKIND syskind;
        public WinDef.WORD wLibFlags;
        public WinDef.WORD wMajorVerNum;
        public WinDef.WORD wMinorVerNum;

        public static class ByReference extends TLIBATTR implements Structure.ByReference {
            public ByReference() {
            }

            public ByReference(Pointer pointer) {
                super(pointer);
                read();
            }
        }

        public TLIBATTR() {
        }

        public TLIBATTR(Pointer pointer) {
            super(pointer);
            read();
        }
    }

    public static class BINDPTR extends Union {
        public FUNCDESC lpfuncdesc;
        public TypeComp lptcomp;
        public VARDESC lpvardesc;

        public static class ByReference extends BINDPTR implements Structure.ByReference {
        }

        public BINDPTR() {
        }

        public BINDPTR(VARDESC vardesc) {
            this.lpvardesc = vardesc;
            setType(VARDESC.class);
        }

        public BINDPTR(TypeComp typeComp) {
            this.lptcomp = typeComp;
            setType(TypeComp.class);
        }

        public BINDPTR(FUNCDESC funcdesc) {
            this.lpfuncdesc = funcdesc;
            setType(FUNCDESC.class);
        }
    }

    @Structure.FieldOrder({"memid", "lprgscode", "lprgelemdescParam", "funckind", "invkind", "callconv", "cParams", "cParamsOpt", "oVft", "cScodes", "elemdescFunc", "wFuncFlags"})
    public static class FUNCDESC extends Structure {
        public WinDef.SHORT cParams;
        public WinDef.SHORT cParamsOpt;
        public WinDef.SHORT cScodes;
        public CALLCONV callconv;
        public ELEMDESC elemdescFunc;
        public FUNCKIND funckind;
        public INVOKEKIND invkind;
        public ElemDescArg.ByReference lprgelemdescParam;
        public ScodeArg.ByReference lprgscode;
        public MEMBERID memid;
        public WinDef.SHORT oVft;
        public WinDef.WORD wFuncFlags;

        public static class ByReference extends FUNCDESC implements Structure.ByReference {
        }

        public FUNCDESC() {
        }

        public FUNCDESC(Pointer pointer) {
            super(pointer);
            read();
            if (this.cParams.shortValue() > 1) {
                this.lprgelemdescParam.elemDescArg = new ELEMDESC[this.cParams.shortValue()];
                this.lprgelemdescParam.read();
            }
        }
    }

    @Structure.FieldOrder({"elemDescArg"})
    public static class ElemDescArg extends Structure {
        public ELEMDESC[] elemDescArg;

        public static class ByReference extends ElemDescArg implements Structure.ByReference {
        }

        public ElemDescArg() {
            this.elemDescArg = new ELEMDESC[]{new ELEMDESC()};
        }

        public ElemDescArg(Pointer pointer) {
            super(pointer);
            this.elemDescArg = new ELEMDESC[]{new ELEMDESC()};
            read();
        }
    }

    @Structure.FieldOrder({"scodeArg"})
    public static class ScodeArg extends Structure {
        public WinDef.SCODE[] scodeArg;

        public static class ByReference extends ScodeArg implements Structure.ByReference {
        }

        public ScodeArg() {
            this.scodeArg = new WinDef.SCODE[]{new WinDef.SCODE()};
        }

        public ScodeArg(Pointer pointer) {
            super(pointer);
            this.scodeArg = new WinDef.SCODE[]{new WinDef.SCODE()};
            read();
        }
    }

    @Structure.FieldOrder({"memid", "lpstrSchema", "_vardesc", "elemdescVar", "wVarFlags", "varkind"})
    public static class VARDESC extends Structure {
        public _VARDESC _vardesc;
        public ELEMDESC elemdescVar;
        public WTypes.LPOLESTR lpstrSchema;
        public MEMBERID memid;
        public VARKIND varkind;
        public WinDef.WORD wVarFlags;

        public static class ByReference extends VARDESC implements Structure.ByReference {
        }

        public static class _VARDESC extends Union {
            public Variant.VARIANT.ByReference lpvarValue;
            public NativeLong oInst;

            public static class ByReference extends _VARDESC implements Structure.ByReference {
            }

            public _VARDESC() {
                setType("lpvarValue");
                read();
            }

            public _VARDESC(Pointer pointer) {
                super(pointer);
                setType("lpvarValue");
                read();
            }

            public _VARDESC(Variant.VARIANT.ByReference byReference) {
                this.lpvarValue = byReference;
                setType("lpvarValue");
            }

            public _VARDESC(NativeLong nativeLong) {
                this.oInst = nativeLong;
                setType("oInst");
            }
        }

        public VARDESC() {
        }

        public VARDESC(Pointer pointer) {
            super(pointer);
            this._vardesc.setType("lpvarValue");
            read();
        }
    }

    @Structure.FieldOrder({"tdesc", "_elemdesc"})
    public static class ELEMDESC extends Structure {
        public _ELEMDESC _elemdesc;
        public TYPEDESC tdesc;

        public static class ByReference extends ELEMDESC implements Structure.ByReference {
        }

        public static class _ELEMDESC extends Union {
            public IDLDESC idldesc;
            public PARAMDESC paramdesc;

            public static class ByReference extends _ELEMDESC implements Structure.ByReference {
            }

            public _ELEMDESC() {
            }

            public _ELEMDESC(Pointer pointer) {
                super(pointer);
                setType("paramdesc");
                read();
            }

            public _ELEMDESC(PARAMDESC paramdesc) {
                this.paramdesc = paramdesc;
                setType("paramdesc");
            }

            public _ELEMDESC(IDLDESC idldesc) {
                this.idldesc = idldesc;
                setType("idldesc");
            }
        }

        public ELEMDESC() {
        }

        public ELEMDESC(Pointer pointer) {
            super(pointer);
            read();
        }
    }

    @Structure.FieldOrder({"value"})
    public static class FUNCKIND extends Structure {
        public static final int FUNC_DISPATCH = 4;
        public static final int FUNC_NONVIRTUAL = 2;
        public static final int FUNC_PUREVIRTUAL = 1;
        public static final int FUNC_STATIC = 3;
        public static final int FUNC_VIRTUAL = 0;
        public int value;

        public static class ByReference extends FUNCKIND implements Structure.ByReference {
        }

        public FUNCKIND() {
        }

        public FUNCKIND(int i) {
            this.value = i;
        }
    }

    @Structure.FieldOrder({"value"})
    public static class INVOKEKIND extends Structure {
        public static final INVOKEKIND INVOKE_FUNC = new INVOKEKIND(1);
        public static final INVOKEKIND INVOKE_PROPERTYGET = new INVOKEKIND(2);
        public static final INVOKEKIND INVOKE_PROPERTYPUT = new INVOKEKIND(4);
        public static final INVOKEKIND INVOKE_PROPERTYPUTREF = new INVOKEKIND(8);
        public int value;

        public static class ByReference extends INVOKEKIND implements Structure.ByReference {
        }

        public INVOKEKIND() {
        }

        public INVOKEKIND(int i) {
            this.value = i;
        }
    }

    @Structure.FieldOrder({"value"})
    public static class CALLCONV extends Structure {
        public static final int CC_CDECL = 1;
        public static final int CC_FASTCALL = 0;
        public static final int CC_FPFASTCALL = 5;
        public static final int CC_MACPASCAL = 3;
        public static final int CC_MAX = 9;
        public static final int CC_MPWCDECL = 7;
        public static final int CC_MPWPASCAL = 8;
        public static final int CC_MSCPASCAL = 2;
        public static final int CC_PASCAL = 2;
        public static final int CC_STDCALL = 4;
        public static final int CC_SYSCALL = 6;
        public int value;

        public static class ByReference extends CALLCONV implements Structure.ByReference {
        }

        public CALLCONV() {
        }

        public CALLCONV(int i) {
            this.value = i;
        }
    }

    @Structure.FieldOrder({"value"})
    public static class VARKIND extends Structure {
        public static final int VAR_CONST = 2;
        public static final int VAR_DISPATCH = 3;
        public static final int VAR_PERINSTANCE = 0;
        public static final int VAR_STATIC = 1;
        public int value;

        public static class ByReference extends VARKIND implements Structure.ByReference {
        }

        public VARKIND() {
        }

        public VARKIND(int i) {
            this.value = i;
        }
    }

    @Structure.FieldOrder({"_typedesc", "vt"})
    public static class TYPEDESC extends Structure {
        public _TYPEDESC _typedesc;
        public WTypes.VARTYPE vt;

        public static class ByReference extends TYPEDESC implements Structure.ByReference {
        }

        public static class _TYPEDESC extends Union {
            public HREFTYPE hreftype;
            public ARRAYDESC.ByReference lpadesc;
            public ByReference lptdesc;

            public _TYPEDESC() {
                setType("hreftype");
                read();
            }

            public _TYPEDESC(Pointer pointer) {
                super(pointer);
                setType("hreftype");
                read();
            }

            public ByReference getLptdesc() {
                setType("lptdesc");
                read();
                return this.lptdesc;
            }

            public ARRAYDESC.ByReference getLpadesc() {
                setType("lpadesc");
                read();
                return this.lpadesc;
            }

            public HREFTYPE getHreftype() {
                setType("hreftype");
                read();
                return this.hreftype;
            }
        }

        public TYPEDESC() {
            read();
        }

        public TYPEDESC(Pointer pointer) {
            super(pointer);
            read();
        }

        public TYPEDESC(_TYPEDESC _typedesc, WTypes.VARTYPE vartype) {
            this._typedesc = _typedesc;
            this.vt = vartype;
        }
    }

    @Structure.FieldOrder({"dwReserved", "wIDLFlags"})
    public static class IDLDESC extends Structure {
        public BaseTSD.ULONG_PTR dwReserved;
        public WinDef.USHORT wIDLFlags;

        public static class ByReference extends IDLDESC implements Structure.ByReference {
            public ByReference() {
            }

            public ByReference(IDLDESC idldesc) {
                super(idldesc.dwReserved, idldesc.wIDLFlags);
            }
        }

        public IDLDESC() {
        }

        public IDLDESC(Pointer pointer) {
            super(pointer);
            read();
        }

        public IDLDESC(BaseTSD.ULONG_PTR ulong_ptr, WinDef.USHORT ushort) {
            this.dwReserved = ulong_ptr;
            this.wIDLFlags = ushort;
        }
    }

    @Structure.FieldOrder({"tdescElem", "cDims", "rgbounds"})
    public static class ARRAYDESC extends Structure {
        public short cDims;
        public SAFEARRAYBOUND[] rgbounds;
        public TYPEDESC tdescElem;

        public static class ByReference extends ARRAYDESC implements Structure.ByReference {
        }

        public ARRAYDESC() {
            this.rgbounds = new SAFEARRAYBOUND[]{new SAFEARRAYBOUND()};
        }

        public ARRAYDESC(Pointer pointer) {
            super(pointer);
            this.rgbounds = new SAFEARRAYBOUND[]{new SAFEARRAYBOUND()};
            read();
        }

        public ARRAYDESC(TYPEDESC typedesc, short s, SAFEARRAYBOUND[] safearrayboundArr) {
            SAFEARRAYBOUND[] safearrayboundArr2 = {new SAFEARRAYBOUND()};
            this.rgbounds = safearrayboundArr2;
            this.tdescElem = typedesc;
            this.cDims = s;
            if (safearrayboundArr.length != safearrayboundArr2.length) {
                throw new IllegalArgumentException("Wrong array size !");
            }
            this.rgbounds = safearrayboundArr;
        }
    }

    @Structure.FieldOrder({"pparamdescex", "wParamFlags"})
    public static class PARAMDESC extends Structure {
        public Pointer pparamdescex;
        public WinDef.USHORT wParamFlags;

        public static class ByReference extends PARAMDESC implements Structure.ByReference {
        }

        public PARAMDESC() {
        }

        public PARAMDESC(Pointer pointer) {
            super(pointer);
            read();
        }
    }

    @Structure.FieldOrder({"cBytes", "varDefaultValue"})
    public static class PARAMDESCEX extends Structure {
        public WinDef.ULONG cBytes;
        public Variant.VariantArg varDefaultValue;

        public static class ByReference extends PARAMDESCEX implements Structure.ByReference {
        }

        public PARAMDESCEX() {
        }

        public PARAMDESCEX(Pointer pointer) {
            super(pointer);
            read();
        }
    }

    public static class HREFTYPE extends WinDef.DWORD {
        private static final long serialVersionUID = 1;

        public HREFTYPE() {
        }

        public HREFTYPE(long j) {
            super(j);
        }
    }

    public static class HREFTYPEByReference extends WinDef.DWORDByReference {
        public HREFTYPEByReference() {
            this(new HREFTYPE(0L));
        }

        public HREFTYPEByReference(WinDef.DWORD dword) {
            super(dword);
        }

        public void setValue(HREFTYPE hreftype) {
            getPointer().setInt(0L, hreftype.intValue());
        }

        @Override // com.sun.jna.platform.win32.WinDef.DWORDByReference
        public HREFTYPE getValue() {
            return new HREFTYPE(getPointer().getInt(0L));
        }
    }

    @Structure.FieldOrder({"guid", "lcid", "dwReserved", "memidConstructor", "memidDestructor", "lpstrSchema", "cbSizeInstance", "typekind", "cFuncs", "cVars", "cImplTypes", "cbSizeVft", "cbAlignment", "wTypeFlags", "wMajorVerNum", "wMinorVerNum", "tdescAlias", "idldescType"})
    public static class TYPEATTR extends Structure {
        public static final int TYPEFLAGS_FAGGREGATABLE = 1024;
        public static final int TYPEFLAGS_FAPPOBJECT = 1;
        public static final int TYPEFLAGS_FCANCREATE = 2;
        public static final int TYPEFLAGS_FCONTROL = 32;
        public static final int TYPEFLAGS_FDISPATCHABLE = 4096;
        public static final int TYPEFLAGS_FDUAL = 64;
        public static final int TYPEFLAGS_FHIDDEN = 16;
        public static final int TYPEFLAGS_FLICENSED = 4;
        public static final int TYPEFLAGS_FNONEXTENSIBLE = 128;
        public static final int TYPEFLAGS_FOLEAUTOMATION = 256;
        public static final int TYPEFLAGS_FPREDECLID = 8;
        public static final int TYPEFLAGS_FPROXY = 16384;
        public static final int TYPEFLAGS_FREPLACEABLE = 2048;
        public static final int TYPEFLAGS_FRESTRICTED = 512;
        public static final int TYPEFLAGS_FREVERSEBIND = 8192;
        public WinDef.WORD cFuncs;
        public WinDef.WORD cImplTypes;
        public WinDef.WORD cVars;
        public WinDef.WORD cbAlignment;
        public WinDef.ULONG cbSizeInstance;
        public WinDef.WORD cbSizeVft;
        public WinDef.DWORD dwReserved;
        public Guid.GUID guid;
        public IDLDESC idldescType;
        public WinDef.LCID lcid;
        public WTypes.LPOLESTR lpstrSchema;
        public MEMBERID memidConstructor;
        public MEMBERID memidDestructor;
        public TYPEDESC tdescAlias;
        public TYPEKIND typekind;
        public WinDef.WORD wMajorVerNum;
        public WinDef.WORD wMinorVerNum;
        public WinDef.WORD wTypeFlags;

        public static class ByReference extends TYPEATTR implements Structure.ByReference {
        }

        public TYPEATTR() {
        }

        public TYPEATTR(Pointer pointer) {
            super(pointer);
            read();
        }
    }
}
