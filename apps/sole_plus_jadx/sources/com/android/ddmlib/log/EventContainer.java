package com.android.ddmlib.log;

import com.android.SdkConstants;
import com.android.ddmlib.log.LogReceiver;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class EventContainer {
    private Object mData;
    public int mTag;
    public int nsec;
    public int pid;
    public int sec;
    public int tid;

    public enum CompareMethod {
        EQUAL_TO("equals", "=="),
        LESSER_THAN("less than or equals to", "<="),
        LESSER_THAN_STRICT("less than", "<"),
        GREATER_THAN("greater than or equals to", ">="),
        GREATER_THAN_STRICT("greater than", ">"),
        BIT_CHECK("bit check", "&");

        private final String mName;
        private final String mTestString;

        CompareMethod(String name, String testString) {
            this.mName = name;
            this.mTestString = testString;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mName;
        }

        public String testString() {
            return this.mTestString;
        }
    }

    public enum EventValueType {
        UNKNOWN(0),
        INT(1),
        LONG(2),
        STRING(3),
        LIST(4),
        TREE(5);

        private static final Pattern STORAGE_PATTERN = Pattern.compile("^(\\d+)@(.*)$");
        private int mValue;

        static EventValueType getEventValueType(int value) {
            for (EventValueType eventValueType : values()) {
                if (eventValueType.mValue == value) {
                    return eventValueType;
                }
            }
            return null;
        }

        public static String getStorageString(Object object) {
            if (object instanceof String) {
                return STRING.mValue + SdkConstants.PREFIX_RESOURCE_REF + object;
            }
            if (object instanceof Integer) {
                return INT.mValue + SdkConstants.PREFIX_RESOURCE_REF + object.toString();
            }
            if (object instanceof Long) {
                return LONG.mValue + SdkConstants.PREFIX_RESOURCE_REF + object.toString();
            }
            return null;
        }

        public static Object getObjectFromStorageString(String value) {
            Matcher matcher = STORAGE_PATTERN.matcher(value);
            if (matcher.matches()) {
                try {
                    EventValueType eventValueType = getEventValueType(Integer.parseInt(matcher.group(1)));
                    if (eventValueType == null) {
                        return null;
                    }
                    int i = AnonymousClass1.$SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[eventValueType.ordinal()];
                    if (i == 1) {
                        return matcher.group(2);
                    }
                    if (i == 2) {
                        return Integer.valueOf(matcher.group(2));
                    }
                    if (i == 3) {
                        return Long.valueOf(matcher.group(2));
                    }
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }

        public int getValue() {
            return this.mValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase(Locale.US);
        }

        EventValueType(int value) {
            this.mValue = value;
        }
    }

    EventContainer(LogReceiver.LogEntry entry, int tag, Object data) {
        getType(data);
        this.mTag = tag;
        this.mData = data;
        this.pid = entry.pid;
        this.tid = entry.tid;
        this.sec = entry.sec;
        this.nsec = entry.nsec;
    }

    EventContainer(int tag, int pid, int tid, int sec, int nsec, Object data) {
        getType(data);
        this.mTag = tag;
        this.mData = data;
        this.pid = pid;
        this.tid = tid;
        this.sec = sec;
        this.nsec = nsec;
    }

    public final Integer getInt() throws InvalidTypeException {
        if (getType(this.mData) == EventValueType.INT) {
            return (Integer) this.mData;
        }
        throw new InvalidTypeException();
    }

    public final Long getLong() throws InvalidTypeException {
        if (getType(this.mData) == EventValueType.LONG) {
            return (Long) this.mData;
        }
        throw new InvalidTypeException();
    }

    public final String getString() throws InvalidTypeException {
        if (getType(this.mData) == EventValueType.STRING) {
            return (String) this.mData;
        }
        throw new InvalidTypeException();
    }

    public Object getValue(int valueIndex) {
        return getValue(this.mData, valueIndex, true);
    }

    public double getValueAsDouble(int valueIndex) throws InvalidTypeException {
        return getValueAsDouble(this.mData, valueIndex, true);
    }

    public String getValueAsString(int valueIndex) throws InvalidTypeException {
        return getValueAsString(this.mData, valueIndex, true);
    }

    public EventValueType getType() {
        return getType(this.mData);
    }

    public final EventValueType getType(Object data) {
        if (data instanceof Integer) {
            return EventValueType.INT;
        }
        if (data instanceof Long) {
            return EventValueType.LONG;
        }
        if (data instanceof String) {
            return EventValueType.STRING;
        }
        if (data instanceof Object[]) {
            for (Object obj : (Object[]) data) {
                EventValueType type = getType(obj);
                if (type == EventValueType.LIST || type == EventValueType.TREE) {
                    return EventValueType.TREE;
                }
            }
            return EventValueType.LIST;
        }
        return EventValueType.UNKNOWN;
    }

    public boolean testValue(int index, Object value, CompareMethod compareMethod) throws InvalidTypeException {
        EventValueType type = getType(this.mData);
        if (index > 0 && type != EventValueType.LIST) {
            throw new InvalidTypeException();
        }
        Object obj = this.mData;
        if (type == EventValueType.LIST) {
            obj = ((Object[]) this.mData)[index];
        }
        if (!obj.getClass().equals(value.getClass())) {
            throw new InvalidTypeException();
        }
        switch (AnonymousClass1.$SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[compareMethod.ordinal()]) {
            case 1:
                return obj.equals(value);
            case 2:
                if (obj instanceof Integer) {
                    return ((Integer) obj).compareTo((Integer) value) <= 0;
                }
                if (obj instanceof Long) {
                    return ((Long) obj).compareTo((Long) value) <= 0;
                }
                throw new InvalidTypeException();
            case 3:
                if (obj instanceof Integer) {
                    return ((Integer) obj).compareTo((Integer) value) < 0;
                }
                if (obj instanceof Long) {
                    return ((Long) obj).compareTo((Long) value) < 0;
                }
                throw new InvalidTypeException();
            case 4:
                if (obj instanceof Integer) {
                    return ((Integer) obj).compareTo((Integer) value) >= 0;
                }
                if (obj instanceof Long) {
                    return ((Long) obj).compareTo((Long) value) >= 0;
                }
                throw new InvalidTypeException();
            case 5:
                if (obj instanceof Integer) {
                    return ((Integer) obj).compareTo((Integer) value) > 0;
                }
                if (obj instanceof Long) {
                    return ((Long) obj).compareTo((Long) value) > 0;
                }
                throw new InvalidTypeException();
            case 6:
                if (obj instanceof Integer) {
                    return (((Integer) obj).intValue() & ((Integer) value).intValue()) != 0;
                }
                if (obj instanceof Long) {
                    return (((Long) value).longValue() & ((Long) obj).longValue()) != 0;
                }
                throw new InvalidTypeException();
            default:
                throw new InvalidTypeException();
        }
    }

    /* renamed from: com.android.ddmlib.log.EventContainer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod;
        static final /* synthetic */ int[] $SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType;

        static {
            int[] iArr = new int[CompareMethod.values().length];
            $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod = iArr;
            try {
                iArr[CompareMethod.EQUAL_TO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[CompareMethod.LESSER_THAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[CompareMethod.LESSER_THAN_STRICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[CompareMethod.GREATER_THAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[CompareMethod.GREATER_THAN_STRICT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$CompareMethod[CompareMethod.BIT_CHECK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[EventValueType.values().length];
            $SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType = iArr2;
            try {
                iArr2[EventValueType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[EventValueType.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[EventValueType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[EventValueType.LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private Object getValue(Object data, int valueIndex, boolean recursive) {
        int i = AnonymousClass1.$SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[getType(data).ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return data;
        }
        if (i == 4 && recursive) {
            Object[] objArr = (Object[]) data;
            if (valueIndex >= 0 && valueIndex < objArr.length) {
                return getValue(objArr[valueIndex], valueIndex, false);
            }
        }
        return null;
    }

    private double getValueAsDouble(Object data, int valueIndex, boolean recursive) throws InvalidTypeException {
        int i = AnonymousClass1.$SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[getType(data).ordinal()];
        if (i == 1) {
            throw new InvalidTypeException();
        }
        if (i == 2) {
            return ((Integer) data).doubleValue();
        }
        if (i == 3) {
            return ((Long) data).doubleValue();
        }
        if (i == 4 && recursive) {
            Object[] objArr = (Object[]) data;
            if (valueIndex >= 0 && valueIndex < objArr.length) {
                return getValueAsDouble(objArr[valueIndex], valueIndex, false);
            }
        }
        throw new InvalidTypeException();
    }

    private String getValueAsString(Object data, int valueIndex, boolean recursive) throws InvalidTypeException {
        EventValueType type = getType(data);
        int i = AnonymousClass1.$SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[type.ordinal()];
        if (i == 1) {
            return (String) data;
        }
        if (i == 2) {
            return data.toString();
        }
        if (i == 3) {
            return data.toString();
        }
        if (i == 4) {
            if (recursive) {
                Object[] objArr = (Object[]) data;
                if (valueIndex >= 0 && valueIndex < objArr.length) {
                    return getValueAsString(objArr[valueIndex], valueIndex, false);
                }
            } else {
                throw new InvalidTypeException("getValueAsString() doesn't support EventValueType.TREE");
            }
        }
        throw new InvalidTypeException("getValueAsString() unsupported type:" + type);
    }
}
