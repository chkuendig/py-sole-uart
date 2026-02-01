package com.sun.jna.platform.mac;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.ByReference;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.ShortByReference;

/* loaded from: classes4.dex */
public interface CoreFoundation extends Library {
    public static final CFTypeID ARRAY_TYPE_ID;
    public static final CFTypeID BOOLEAN_TYPE_ID;
    public static final CFTypeID DATA_TYPE_ID;
    public static final CFTypeID DATE_TYPE_ID;
    public static final CFTypeID DICTIONARY_TYPE_ID;
    public static final CoreFoundation INSTANCE;
    public static final CFTypeID NUMBER_TYPE_ID;
    public static final CFTypeID STRING_TYPE_ID;
    public static final int kCFNotFound = -1;
    public static final int kCFStringEncodingASCII = 1536;
    public static final int kCFStringEncodingUTF8 = 134217984;

    public static class CFAllocatorRef extends CFTypeRef {
    }

    CFAllocatorRef CFAllocatorGetDefault();

    CFArrayRef CFArrayCreate(CFAllocatorRef cFAllocatorRef, Pointer pointer, CFIndex cFIndex, Pointer pointer2);

    CFIndex CFArrayGetCount(CFArrayRef cFArrayRef);

    CFTypeID CFArrayGetTypeID();

    Pointer CFArrayGetValueAtIndex(CFArrayRef cFArrayRef, CFIndex cFIndex);

    CFTypeID CFBooleanGetTypeID();

    byte CFBooleanGetValue(CFBooleanRef cFBooleanRef);

    CFStringRef CFCopyDescription(CFTypeRef cFTypeRef);

    CFDataRef CFDataCreate(CFAllocatorRef cFAllocatorRef, Pointer pointer, CFIndex cFIndex);

    Pointer CFDataGetBytePtr(CFDataRef cFDataRef);

    CFIndex CFDataGetLength(CFDataRef cFDataRef);

    CFTypeID CFDataGetTypeID();

    CFTypeID CFDateGetTypeID();

    CFMutableDictionaryRef CFDictionaryCreateMutable(CFAllocatorRef cFAllocatorRef, CFIndex cFIndex, Pointer pointer, Pointer pointer2);

    CFTypeID CFDictionaryGetTypeID();

    Pointer CFDictionaryGetValue(CFDictionaryRef cFDictionaryRef, PointerType pointerType);

    byte CFDictionaryGetValueIfPresent(CFDictionaryRef cFDictionaryRef, PointerType pointerType, PointerByReference pointerByReference);

    void CFDictionarySetValue(CFMutableDictionaryRef cFMutableDictionaryRef, PointerType pointerType, PointerType pointerType2);

    CFIndex CFGetRetainCount(CFTypeRef cFTypeRef);

    CFTypeID CFGetTypeID(CFTypeRef cFTypeRef);

    CFNumberRef CFNumberCreate(CFAllocatorRef cFAllocatorRef, CFIndex cFIndex, ByReference byReference);

    CFIndex CFNumberGetType(CFNumberRef cFNumberRef);

    CFTypeID CFNumberGetTypeID();

    byte CFNumberGetValue(CFNumberRef cFNumberRef, CFIndex cFIndex, ByReference byReference);

    void CFRelease(CFTypeRef cFTypeRef);

    CFTypeRef CFRetain(CFTypeRef cFTypeRef);

    CFStringRef CFStringCreateWithCharacters(CFAllocatorRef cFAllocatorRef, char[] cArr, CFIndex cFIndex);

    byte CFStringGetCString(CFStringRef cFStringRef, Pointer pointer, CFIndex cFIndex, int i);

    CFIndex CFStringGetLength(CFStringRef cFStringRef);

    CFIndex CFStringGetMaximumSizeForEncoding(CFIndex cFIndex, int i);

    CFTypeID CFStringGetTypeID();

    static {
        CoreFoundation coreFoundation = (CoreFoundation) Native.load("CoreFoundation", CoreFoundation.class);
        INSTANCE = coreFoundation;
        ARRAY_TYPE_ID = coreFoundation.CFArrayGetTypeID();
        BOOLEAN_TYPE_ID = coreFoundation.CFBooleanGetTypeID();
        DATA_TYPE_ID = coreFoundation.CFDataGetTypeID();
        DATE_TYPE_ID = coreFoundation.CFDateGetTypeID();
        DICTIONARY_TYPE_ID = coreFoundation.CFDictionaryGetTypeID();
        NUMBER_TYPE_ID = coreFoundation.CFNumberGetTypeID();
        STRING_TYPE_ID = coreFoundation.CFStringGetTypeID();
    }

    public static class CFTypeRef extends PointerType {
        public CFTypeRef() {
        }

        public CFTypeRef(Pointer pointer) {
            super(pointer);
        }

        public CFTypeID getTypeID() {
            if (getPointer() == null) {
                return new CFTypeID(0L);
            }
            return CoreFoundation.INSTANCE.CFGetTypeID(this);
        }

        public boolean isTypeID(CFTypeID cFTypeID) {
            return getTypeID().equals(cFTypeID);
        }

        public void retain() {
            CoreFoundation.INSTANCE.CFRetain(this);
        }

        public void release() {
            CoreFoundation.INSTANCE.CFRelease(this);
        }
    }

    public static class CFNumberRef extends CFTypeRef {
        public CFNumberRef() {
        }

        public CFNumberRef(Pointer pointer) {
            super(pointer);
            if (!isTypeID(CoreFoundation.NUMBER_TYPE_ID)) {
                throw new ClassCastException("Unable to cast to CFNumber. Type ID: " + getTypeID());
            }
        }

        public long longValue() {
            LongByReference longByReference = new LongByReference();
            CoreFoundation.INSTANCE.CFNumberGetValue(this, CFNumberType.kCFNumberLongLongType.typeIndex(), longByReference);
            return longByReference.getValue();
        }

        public int intValue() {
            IntByReference intByReference = new IntByReference();
            CoreFoundation.INSTANCE.CFNumberGetValue(this, CFNumberType.kCFNumberIntType.typeIndex(), intByReference);
            return intByReference.getValue();
        }

        public short shortValue() {
            ShortByReference shortByReference = new ShortByReference();
            CoreFoundation.INSTANCE.CFNumberGetValue(this, CFNumberType.kCFNumberShortType.typeIndex(), shortByReference);
            return shortByReference.getValue();
        }

        public byte byteValue() {
            ByteByReference byteByReference = new ByteByReference();
            CoreFoundation.INSTANCE.CFNumberGetValue(this, CFNumberType.kCFNumberCharType.typeIndex(), byteByReference);
            return byteByReference.getValue();
        }

        public double doubleValue() {
            DoubleByReference doubleByReference = new DoubleByReference();
            CoreFoundation.INSTANCE.CFNumberGetValue(this, CFNumberType.kCFNumberDoubleType.typeIndex(), doubleByReference);
            return doubleByReference.getValue();
        }

        public float floatValue() {
            FloatByReference floatByReference = new FloatByReference();
            CoreFoundation.INSTANCE.CFNumberGetValue(this, CFNumberType.kCFNumberFloatType.typeIndex(), floatByReference);
            return floatByReference.getValue();
        }
    }

    public enum CFNumberType {
        unusedZero,
        kCFNumberSInt8Type,
        kCFNumberSInt16Type,
        kCFNumberSInt32Type,
        kCFNumberSInt64Type,
        kCFNumberFloat32Type,
        kCFNumberFloat64Type,
        kCFNumberCharType,
        kCFNumberShortType,
        kCFNumberIntType,
        kCFNumberLongType,
        kCFNumberLongLongType,
        kCFNumberFloatType,
        kCFNumberDoubleType,
        kCFNumberCFIndexType,
        kCFNumberNSIntegerType,
        kCFNumberCGFloatType,
        kCFNumberMaxType;

        public CFIndex typeIndex() {
            return new CFIndex(ordinal());
        }
    }

    public static class CFBooleanRef extends CFTypeRef {
        public CFBooleanRef() {
        }

        public CFBooleanRef(Pointer pointer) {
            super(pointer);
            if (!isTypeID(CoreFoundation.BOOLEAN_TYPE_ID)) {
                throw new ClassCastException("Unable to cast to CFBoolean. Type ID: " + getTypeID());
            }
        }

        public boolean booleanValue() {
            return CoreFoundation.INSTANCE.CFBooleanGetValue(this) != 0;
        }
    }

    public static class CFArrayRef extends CFTypeRef {
        public CFArrayRef() {
        }

        public CFArrayRef(Pointer pointer) {
            super(pointer);
            if (!isTypeID(CoreFoundation.ARRAY_TYPE_ID)) {
                throw new ClassCastException("Unable to cast to CFArray. Type ID: " + getTypeID());
            }
        }

        public int getCount() {
            return CoreFoundation.INSTANCE.CFArrayGetCount(this).intValue();
        }

        public Pointer getValueAtIndex(int i) {
            return CoreFoundation.INSTANCE.CFArrayGetValueAtIndex(this, new CFIndex(i));
        }
    }

    public static class CFDataRef extends CFTypeRef {
        public CFDataRef() {
        }

        public CFDataRef(Pointer pointer) {
            super(pointer);
            if (!isTypeID(CoreFoundation.DATA_TYPE_ID)) {
                throw new ClassCastException("Unable to cast to CFData. Type ID: " + getTypeID());
            }
        }

        public int getLength() {
            return CoreFoundation.INSTANCE.CFDataGetLength(this).intValue();
        }

        public Pointer getBytePtr() {
            return CoreFoundation.INSTANCE.CFDataGetBytePtr(this);
        }
    }

    public static class CFDictionaryRef extends CFTypeRef {
        public CFDictionaryRef() {
        }

        public CFDictionaryRef(Pointer pointer) {
            super(pointer);
            if (!isTypeID(CoreFoundation.DICTIONARY_TYPE_ID)) {
                throw new ClassCastException("Unable to cast to CFDictionary. Type ID: " + getTypeID());
            }
        }

        public Pointer getValue(PointerType pointerType) {
            return CoreFoundation.INSTANCE.CFDictionaryGetValue(this, pointerType);
        }

        public boolean getValueIfPresent(PointerType pointerType, PointerByReference pointerByReference) {
            return CoreFoundation.INSTANCE.CFDictionaryGetValueIfPresent(this, pointerType, pointerByReference) > 0;
        }
    }

    public static class CFMutableDictionaryRef extends CFDictionaryRef {
        public CFMutableDictionaryRef() {
        }

        public CFMutableDictionaryRef(Pointer pointer) {
            super(pointer);
        }

        public void setValue(PointerType pointerType, PointerType pointerType2) {
            CoreFoundation.INSTANCE.CFDictionarySetValue(this, pointerType, pointerType2);
        }
    }

    public static class CFStringRef extends CFTypeRef {
        public CFStringRef() {
        }

        public CFStringRef(Pointer pointer) {
            super(pointer);
            if (!isTypeID(CoreFoundation.STRING_TYPE_ID)) {
                throw new ClassCastException("Unable to cast to CFString. Type ID: " + getTypeID());
            }
        }

        public static CFStringRef createCFString(String str) {
            return CoreFoundation.INSTANCE.CFStringCreateWithCharacters(null, str.toCharArray(), new CFIndex(r4.length));
        }

        public String stringValue() {
            CFIndex cFIndexCFStringGetMaximumSizeForEncoding = CoreFoundation.INSTANCE.CFStringGetMaximumSizeForEncoding(CoreFoundation.INSTANCE.CFStringGetLength(this), CoreFoundation.kCFStringEncodingUTF8);
            if (cFIndexCFStringGetMaximumSizeForEncoding.intValue() == -1) {
                return null;
            }
            Memory memory = new Memory(cFIndexCFStringGetMaximumSizeForEncoding.longValue());
            if (CoreFoundation.INSTANCE.CFStringGetCString(this, memory, cFIndexCFStringGetMaximumSizeForEncoding, CoreFoundation.kCFStringEncodingUTF8) != 0) {
                return memory.getString(0L, "UTF8");
            }
            return null;
        }
    }

    public static class CFIndex extends NativeLong {
        private static final long serialVersionUID = 1;

        public CFIndex() {
        }

        public CFIndex(long j) {
            super(j);
        }
    }

    public static class CFTypeID extends NativeLong {
        private static final long serialVersionUID = 1;

        public CFTypeID() {
        }

        public CFTypeID(long j) {
            super(j);
        }

        @Override // com.sun.jna.IntegerType
        public String toString() {
            if (equals(CoreFoundation.ARRAY_TYPE_ID)) {
                return "CFArray";
            }
            if (equals(CoreFoundation.BOOLEAN_TYPE_ID)) {
                return "CFBoolean";
            }
            if (equals(CoreFoundation.DATA_TYPE_ID)) {
                return "CFData";
            }
            if (equals(CoreFoundation.DATE_TYPE_ID)) {
                return "CFDate";
            }
            if (equals(CoreFoundation.DICTIONARY_TYPE_ID)) {
                return "CFDictionary";
            }
            if (equals(CoreFoundation.NUMBER_TYPE_ID)) {
                return "CFNumber";
            }
            if (equals(CoreFoundation.STRING_TYPE_ID)) {
                return "CFString";
            }
            return super.toString();
        }
    }
}
