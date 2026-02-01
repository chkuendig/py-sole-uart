package com.android.ddmlib.log;

import com.android.ddmlib.log.EventContainer;
import com.android.ddmlib.log.EventValueDescription;
import com.android.ddmlib.log.LogReceiver;

/* loaded from: classes3.dex */
final class GcEventContainer extends EventContainer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int GC_EVENT_TAG = 20001;
    private long actualSize;
    private long allowedSize;
    private long bytesAllocated;
    private long bytesFreed;
    private long dlmallocFootprint;
    private long externalBytesAllocated;
    private long externalLimit;
    private long gcTime;
    private long mallinfoTotalAllocatedSpace;
    private long objectsAllocated;
    private long objectsFreed;
    private String processId;
    private long softLimit;
    private long zActualSize;
    private long zAllowedSize;
    private long zBytesAllocated;
    private long zObjectsAllocated;

    private static long float12ToInt(int f12) {
        return (f12 & 511) << ((f12 >>> 9) * 4);
    }

    GcEventContainer(LogReceiver.LogEntry entry, int tag, Object data) {
        super(entry, tag, data);
        init(data);
    }

    GcEventContainer(int tag, int pid, int tid, int sec, int nsec, Object data) {
        super(tag, pid, tid, sec, nsec, data);
        init(data);
    }

    private void init(Object data) {
        if (data instanceof Object[]) {
            Object[] objArr = (Object[]) data;
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (obj instanceof Long) {
                    parseDvmHeapInfo(((Long) obj).longValue(), i);
                }
            }
        }
    }

    @Override // com.android.ddmlib.log.EventContainer
    public EventContainer.EventValueType getType() {
        return EventContainer.EventValueType.LIST;
    }

    @Override // com.android.ddmlib.log.EventContainer
    public boolean testValue(int index, Object value, EventContainer.CompareMethod compareMethod) throws InvalidTypeException {
        if (index == 0) {
            if (!(value instanceof String)) {
                throw new InvalidTypeException();
            }
        } else if (!(value instanceof Long)) {
            throw new InvalidTypeException();
        }
        switch (AnonymousClass1.$SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[compareMethod.ordinal()]) {
            case 1:
                if (index == 0) {
                    return this.processId.equals(value);
                }
                return getValueAsLong(index) == ((Long) value).longValue();
            case 2:
                return getValueAsLong(index) <= ((Long) value).longValue();
            case 3:
                return getValueAsLong(index) < ((Long) value).longValue();
            case 4:
                return getValueAsLong(index) >= ((Long) value).longValue();
            case 5:
                return getValueAsLong(index) > ((Long) value).longValue();
            case 6:
                return (((Long) value).longValue() & getValueAsLong(index)) != 0;
            default:
                throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: com.android.ddmlib.log.GcEventContainer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod;

        static {
            int[] iArr = new int[EventContainer.CompareMethod.values().length];
            $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod = iArr;
            try {
                iArr[EventContainer.CompareMethod.EQUAL_TO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[EventContainer.CompareMethod.LESSER_THAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[EventContainer.CompareMethod.LESSER_THAN_STRICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[EventContainer.CompareMethod.GREATER_THAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[EventContainer.CompareMethod.GREATER_THAN_STRICT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[EventContainer.CompareMethod.BIT_CHECK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.android.ddmlib.log.EventContainer
    public Object getValue(int valueIndex) {
        if (valueIndex == 0) {
            return this.processId;
        }
        try {
            return Long.valueOf(getValueAsLong(valueIndex));
        } catch (InvalidTypeException unused) {
            return null;
        }
    }

    @Override // com.android.ddmlib.log.EventContainer
    public double getValueAsDouble(int valueIndex) throws InvalidTypeException {
        return getValueAsLong(valueIndex);
    }

    @Override // com.android.ddmlib.log.EventContainer
    public String getValueAsString(int valueIndex) {
        if (valueIndex == 0) {
            return this.processId;
        }
        try {
            return Long.toString(getValueAsLong(valueIndex));
        } catch (InvalidTypeException unused) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    static EventValueDescription[] getValueDescriptions() {
        try {
            return new EventValueDescription[]{new EventValueDescription("Process Name", EventContainer.EventValueType.STRING), new EventValueDescription("GC Time", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.MILLISECONDS), new EventValueDescription("Freed Objects", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.OBJECTS), new EventValueDescription("Freed Bytes", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("Soft Limit", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("Actual Size (aggregate)", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("Allowed Size (aggregate)", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("Allocated Objects (aggregate)", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.OBJECTS), new EventValueDescription("Allocated Bytes (aggregate)", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("Actual Size", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("Allowed Size", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("Allocated Objects", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.OBJECTS), new EventValueDescription("Allocated Bytes", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("Actual Size (zygote)", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("Allowed Size (zygote)", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("Allocated Objects (zygote)", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.OBJECTS), new EventValueDescription("Allocated Bytes (zygote)", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("External Allocation Limit", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("External Bytes Allocated", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("dlmalloc Footprint", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES), new EventValueDescription("Malloc Info: Total Allocated Space", EventContainer.EventValueType.LONG, EventValueDescription.ValueType.BYTES)};
        } catch (InvalidValueTypeException unused) {
            return null;
        }
    }

    private void parseDvmHeapInfo(long data, int index) {
        if (index == 0) {
            this.gcTime = float12ToInt((int) ((data >> 12) & 4095));
            this.bytesFreed = float12ToInt((int) (data & 4095));
            byte[] bArr = new byte[8];
            put64bitsToArray(data, bArr, 0);
            this.processId = new String(bArr, 0, 5);
            return;
        }
        if (index == 1) {
            this.objectsFreed = float12ToInt((int) ((data >> 48) & 4095));
            this.actualSize = float12ToInt((int) ((data >> 36) & 4095));
            this.allowedSize = float12ToInt((int) ((data >> 24) & 4095));
            this.objectsAllocated = float12ToInt((int) ((data >> 12) & 4095));
            this.bytesAllocated = float12ToInt((int) (data & 4095));
            return;
        }
        if (index == 2) {
            this.softLimit = float12ToInt((int) ((data >> 48) & 4095));
            this.zActualSize = float12ToInt((int) ((data >> 36) & 4095));
            this.zAllowedSize = float12ToInt((int) ((data >> 24) & 4095));
            this.zObjectsAllocated = float12ToInt((int) ((data >> 12) & 4095));
            this.zBytesAllocated = float12ToInt((int) (data & 4095));
            return;
        }
        if (index != 3) {
            return;
        }
        this.dlmallocFootprint = float12ToInt((int) ((data >> 36) & 4095));
        this.mallinfoTotalAllocatedSpace = float12ToInt((int) ((data >> 24) & 4095));
        this.externalLimit = float12ToInt((int) ((data >> 12) & 4095));
        this.externalBytesAllocated = float12ToInt((int) (data & 4095));
    }

    private static void put64bitsToArray(long value, byte[] dest, int offset) {
        dest[offset + 7] = (byte) (255 & value);
        dest[offset + 6] = (byte) ((65280 & value) >> 8);
        dest[offset + 5] = (byte) ((16711680 & value) >> 16);
        dest[offset + 4] = (byte) ((4278190080L & value) >> 24);
        dest[offset + 3] = (byte) ((1095216660480L & value) >> 32);
        dest[offset + 2] = (byte) ((280375465082880L & value) >> 40);
        dest[offset + 1] = (byte) ((71776119061217280L & value) >> 48);
        dest[offset] = (byte) ((value & (-72057594037927936L)) >> 56);
    }

    private long getValueAsLong(int valueIndex) throws InvalidTypeException {
        long j;
        long j2;
        switch (valueIndex) {
            case 0:
                throw new InvalidTypeException();
            case 1:
                return this.gcTime;
            case 2:
                return this.objectsFreed;
            case 3:
                return this.bytesFreed;
            case 4:
                return this.softLimit;
            case 5:
                return this.actualSize;
            case 6:
                return this.allowedSize;
            case 7:
                return this.objectsAllocated;
            case 8:
                return this.bytesAllocated;
            case 9:
                j = this.actualSize;
                j2 = this.zActualSize;
                break;
            case 10:
                j = this.allowedSize;
                j2 = this.zAllowedSize;
                break;
            case 11:
                j = this.objectsAllocated;
                j2 = this.zObjectsAllocated;
                break;
            case 12:
                j = this.bytesAllocated;
                j2 = this.zBytesAllocated;
                break;
            case 13:
                return this.zActualSize;
            case 14:
                return this.zAllowedSize;
            case 15:
                return this.zObjectsAllocated;
            case 16:
                return this.zBytesAllocated;
            case 17:
                return this.externalLimit;
            case 18:
                return this.externalBytesAllocated;
            case 19:
                return this.dlmallocFootprint;
            case 20:
                return this.mallinfoTotalAllocatedSpace;
            default:
                throw new ArrayIndexOutOfBoundsException();
        }
        return j - j2;
    }
}
