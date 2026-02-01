package com.sun.jna.platform.mac;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.platform.mac.CoreFoundation;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.PointerByReference;

/* loaded from: classes4.dex */
public interface IOKit extends Library {
    public static final IOKit INSTANCE = (IOKit) Native.load("IOKit", IOKit.class);
    public static final double kIOPSTimeRemainingUnknown = -1.0d;
    public static final double kIOPSTimeRemainingUnlimited = -2.0d;
    public static final int kIORegistryIterateParents = 2;
    public static final int kIORegistryIterateRecursively = 1;
    public static final int kIOReturnNoDevice = -536870208;

    CoreFoundation.CFMutableDictionaryRef IOBSDNameMatching(int i, int i2, String str);

    IORegistryEntry IOIteratorNext(IOIterator iOIterator);

    int IOMasterPort(int i, IntByReference intByReference);

    boolean IOObjectConformsTo(IOObject iOObject, String str);

    int IOObjectRelease(IOObject iOObject);

    CoreFoundation.CFTypeRef IOPSCopyPowerSourcesInfo();

    CoreFoundation.CFArrayRef IOPSCopyPowerSourcesList(CoreFoundation.CFTypeRef cFTypeRef);

    CoreFoundation.CFDictionaryRef IOPSGetPowerSourceDescription(CoreFoundation.CFTypeRef cFTypeRef, CoreFoundation.CFTypeRef cFTypeRef2);

    double IOPSGetTimeRemainingEstimate();

    int IORegistryEntryCreateCFProperties(IORegistryEntry iORegistryEntry, PointerByReference pointerByReference, CoreFoundation.CFAllocatorRef cFAllocatorRef, int i);

    CoreFoundation.CFTypeRef IORegistryEntryCreateCFProperty(IORegistryEntry iORegistryEntry, CoreFoundation.CFStringRef cFStringRef, CoreFoundation.CFAllocatorRef cFAllocatorRef, int i);

    int IORegistryEntryGetChildEntry(IORegistryEntry iORegistryEntry, String str, PointerByReference pointerByReference);

    int IORegistryEntryGetChildIterator(IORegistryEntry iORegistryEntry, String str, PointerByReference pointerByReference);

    int IORegistryEntryGetName(IORegistryEntry iORegistryEntry, Pointer pointer);

    int IORegistryEntryGetParentEntry(IORegistryEntry iORegistryEntry, String str, PointerByReference pointerByReference);

    int IORegistryEntryGetRegistryEntryID(IORegistryEntry iORegistryEntry, LongByReference longByReference);

    CoreFoundation.CFTypeRef IORegistryEntrySearchCFProperty(IORegistryEntry iORegistryEntry, String str, CoreFoundation.CFStringRef cFStringRef, CoreFoundation.CFAllocatorRef cFAllocatorRef, int i);

    IORegistryEntry IORegistryGetRootEntry(int i);

    int IOServiceClose(IOConnect iOConnect);

    int IOServiceGetBusyState(IOService iOService, IntByReference intByReference);

    IOService IOServiceGetMatchingService(int i, CoreFoundation.CFDictionaryRef cFDictionaryRef);

    int IOServiceGetMatchingServices(int i, CoreFoundation.CFDictionaryRef cFDictionaryRef, PointerByReference pointerByReference);

    CoreFoundation.CFMutableDictionaryRef IOServiceMatching(String str);

    CoreFoundation.CFMutableDictionaryRef IOServiceNameMatching(String str);

    int IOServiceOpen(IOService iOService, int i, int i2, PointerByReference pointerByReference);

    public static class IOObject extends PointerType {
        public IOObject() {
        }

        public IOObject(Pointer pointer) {
            super(pointer);
        }

        public boolean conformsTo(String str) {
            return IOKit.INSTANCE.IOObjectConformsTo(this, str);
        }

        public int release() {
            return IOKit.INSTANCE.IOObjectRelease(this);
        }
    }

    public static class IOIterator extends IOObject {
        public IOIterator() {
        }

        public IOIterator(Pointer pointer) {
            super(pointer);
        }

        public IORegistryEntry next() {
            return IOKit.INSTANCE.IOIteratorNext(this);
        }
    }

    public static class IORegistryEntry extends IOObject {
        public IORegistryEntry() {
        }

        public IORegistryEntry(Pointer pointer) {
            super(pointer);
        }

        public long getRegistryEntryID() {
            LongByReference longByReference = new LongByReference();
            int iIORegistryEntryGetRegistryEntryID = IOKit.INSTANCE.IORegistryEntryGetRegistryEntryID(this, longByReference);
            if (iIORegistryEntryGetRegistryEntryID != 0) {
                throw new IOReturnException(iIORegistryEntryGetRegistryEntryID);
            }
            return longByReference.getValue();
        }

        public String getName() {
            Memory memory = new Memory(128L);
            int iIORegistryEntryGetName = IOKit.INSTANCE.IORegistryEntryGetName(this, memory);
            if (iIORegistryEntryGetName != 0) {
                throw new IOReturnException(iIORegistryEntryGetName);
            }
            return memory.getString(0L);
        }

        public IOIterator getChildIterator(String str) {
            PointerByReference pointerByReference = new PointerByReference();
            int iIORegistryEntryGetChildIterator = IOKit.INSTANCE.IORegistryEntryGetChildIterator(this, str, pointerByReference);
            if (iIORegistryEntryGetChildIterator != 0) {
                throw new IOReturnException(iIORegistryEntryGetChildIterator);
            }
            return new IOIterator(pointerByReference.getValue());
        }

        public IORegistryEntry getChildEntry(String str) {
            PointerByReference pointerByReference = new PointerByReference();
            int iIORegistryEntryGetChildEntry = IOKit.INSTANCE.IORegistryEntryGetChildEntry(this, str, pointerByReference);
            if (iIORegistryEntryGetChildEntry == -536870208) {
                return null;
            }
            if (iIORegistryEntryGetChildEntry != 0) {
                throw new IOReturnException(iIORegistryEntryGetChildEntry);
            }
            return new IORegistryEntry(pointerByReference.getValue());
        }

        public IORegistryEntry getParentEntry(String str) {
            PointerByReference pointerByReference = new PointerByReference();
            int iIORegistryEntryGetParentEntry = IOKit.INSTANCE.IORegistryEntryGetParentEntry(this, str, pointerByReference);
            if (iIORegistryEntryGetParentEntry == -536870208) {
                return null;
            }
            if (iIORegistryEntryGetParentEntry != 0) {
                throw new IOReturnException(iIORegistryEntryGetParentEntry);
            }
            return new IORegistryEntry(pointerByReference.getValue());
        }

        public CoreFoundation.CFTypeRef createCFProperty(CoreFoundation.CFStringRef cFStringRef) {
            return IOKit.INSTANCE.IORegistryEntryCreateCFProperty(this, cFStringRef, CoreFoundation.INSTANCE.CFAllocatorGetDefault(), 0);
        }

        public CoreFoundation.CFMutableDictionaryRef createCFProperties() {
            PointerByReference pointerByReference = new PointerByReference();
            int iIORegistryEntryCreateCFProperties = IOKit.INSTANCE.IORegistryEntryCreateCFProperties(this, pointerByReference, CoreFoundation.INSTANCE.CFAllocatorGetDefault(), 0);
            if (iIORegistryEntryCreateCFProperties != 0) {
                throw new IOReturnException(iIORegistryEntryCreateCFProperties);
            }
            return new CoreFoundation.CFMutableDictionaryRef(pointerByReference.getValue());
        }

        CoreFoundation.CFTypeRef searchCFProperty(String str, CoreFoundation.CFStringRef cFStringRef, int i) {
            return IOKit.INSTANCE.IORegistryEntrySearchCFProperty(this, str, cFStringRef, CoreFoundation.INSTANCE.CFAllocatorGetDefault(), i);
        }

        public String getStringProperty(String str) {
            CoreFoundation.CFStringRef cFStringRefCreateCFString = CoreFoundation.CFStringRef.createCFString(str);
            CoreFoundation.CFTypeRef cFTypeRefCreateCFProperty = createCFProperty(cFStringRefCreateCFString);
            cFStringRefCreateCFString.release();
            if (cFTypeRefCreateCFProperty == null) {
                return null;
            }
            String strStringValue = new CoreFoundation.CFStringRef(cFTypeRefCreateCFProperty.getPointer()).stringValue();
            cFTypeRefCreateCFProperty.release();
            return strStringValue;
        }

        public Long getLongProperty(String str) {
            CoreFoundation.CFStringRef cFStringRefCreateCFString = CoreFoundation.CFStringRef.createCFString(str);
            CoreFoundation.CFTypeRef cFTypeRefCreateCFProperty = createCFProperty(cFStringRefCreateCFString);
            cFStringRefCreateCFString.release();
            if (cFTypeRefCreateCFProperty == null) {
                return null;
            }
            Long lValueOf = Long.valueOf(new CoreFoundation.CFNumberRef(cFTypeRefCreateCFProperty.getPointer()).longValue());
            cFTypeRefCreateCFProperty.release();
            return lValueOf;
        }

        public Integer getIntegerProperty(String str) {
            CoreFoundation.CFStringRef cFStringRefCreateCFString = CoreFoundation.CFStringRef.createCFString(str);
            CoreFoundation.CFTypeRef cFTypeRefCreateCFProperty = createCFProperty(cFStringRefCreateCFString);
            cFStringRefCreateCFString.release();
            if (cFTypeRefCreateCFProperty == null) {
                return null;
            }
            Integer numValueOf = Integer.valueOf(new CoreFoundation.CFNumberRef(cFTypeRefCreateCFProperty.getPointer()).intValue());
            cFTypeRefCreateCFProperty.release();
            return numValueOf;
        }

        public Double getDoubleProperty(String str) {
            CoreFoundation.CFStringRef cFStringRefCreateCFString = CoreFoundation.CFStringRef.createCFString(str);
            CoreFoundation.CFTypeRef cFTypeRefCreateCFProperty = createCFProperty(cFStringRefCreateCFString);
            cFStringRefCreateCFString.release();
            if (cFTypeRefCreateCFProperty == null) {
                return null;
            }
            Double dValueOf = Double.valueOf(new CoreFoundation.CFNumberRef(cFTypeRefCreateCFProperty.getPointer()).doubleValue());
            cFTypeRefCreateCFProperty.release();
            return dValueOf;
        }

        public Boolean getBooleanProperty(String str) {
            CoreFoundation.CFStringRef cFStringRefCreateCFString = CoreFoundation.CFStringRef.createCFString(str);
            CoreFoundation.CFTypeRef cFTypeRefCreateCFProperty = createCFProperty(cFStringRefCreateCFString);
            cFStringRefCreateCFString.release();
            if (cFTypeRefCreateCFProperty == null) {
                return null;
            }
            Boolean boolValueOf = Boolean.valueOf(new CoreFoundation.CFBooleanRef(cFTypeRefCreateCFProperty.getPointer()).booleanValue());
            cFTypeRefCreateCFProperty.release();
            return boolValueOf;
        }

        public byte[] getByteArrayProperty(String str) {
            CoreFoundation.CFStringRef cFStringRefCreateCFString = CoreFoundation.CFStringRef.createCFString(str);
            CoreFoundation.CFTypeRef cFTypeRefCreateCFProperty = createCFProperty(cFStringRefCreateCFString);
            cFStringRefCreateCFString.release();
            if (cFTypeRefCreateCFProperty == null) {
                return null;
            }
            CoreFoundation.CFDataRef cFDataRef = new CoreFoundation.CFDataRef(cFTypeRefCreateCFProperty.getPointer());
            byte[] byteArray = cFDataRef.getBytePtr().getByteArray(0L, cFDataRef.getLength());
            cFTypeRefCreateCFProperty.release();
            return byteArray;
        }
    }

    public static class IOService extends IORegistryEntry {
        public IOService() {
        }

        public IOService(Pointer pointer) {
            super(pointer);
        }
    }

    public static class IOConnect extends IOService {
        public IOConnect() {
        }

        public IOConnect(Pointer pointer) {
            super(pointer);
        }
    }
}
