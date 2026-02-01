package com.android.ddmlib.log;

import com.android.ddmlib.log.EventContainer;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class EventValueDescription {
    private EventContainer.EventValueType mEventValueType;
    private String mName;
    private ValueType mValueType;

    public enum ValueType {
        NOT_APPLICABLE(0),
        OBJECTS(1),
        BYTES(2),
        MILLISECONDS(3),
        ALLOCATIONS(4),
        ID(5),
        PERCENT(6);

        private int mValue;

        public void checkType(EventContainer.EventValueType type) throws InvalidValueTypeException {
            if (type != EventContainer.EventValueType.INT && type != EventContainer.EventValueType.LONG && this != NOT_APPLICABLE) {
                throw new InvalidValueTypeException(String.format("%1$s doesn't support type %2$s", type, this));
            }
        }

        public static ValueType getValueType(int value) {
            for (ValueType valueType : values()) {
                if (valueType.mValue == value) {
                    return valueType;
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

        ValueType(int value) {
            this.mValue = value;
        }
    }

    EventValueDescription(String name, EventContainer.EventValueType type) {
        this.mName = name;
        this.mEventValueType = type;
        if (type == EventContainer.EventValueType.INT || this.mEventValueType == EventContainer.EventValueType.LONG) {
            this.mValueType = ValueType.BYTES;
        } else {
            this.mValueType = ValueType.NOT_APPLICABLE;
        }
    }

    EventValueDescription(String name, EventContainer.EventValueType type, ValueType valueType) throws InvalidValueTypeException {
        this.mName = name;
        this.mEventValueType = type;
        this.mValueType = valueType;
        valueType.checkType(type);
    }

    public String getName() {
        return this.mName;
    }

    public EventContainer.EventValueType getEventValueType() {
        return this.mEventValueType;
    }

    public ValueType getValueType() {
        return this.mValueType;
    }

    public String toString() {
        if (this.mValueType != ValueType.NOT_APPLICABLE) {
            return String.format("%1$s (%2$s, %3$s)", this.mName, this.mEventValueType.toString(), this.mValueType.toString());
        }
        return String.format("%1$s (%2$s)", this.mName, this.mEventValueType.toString());
    }

    /* renamed from: com.android.ddmlib.log.EventValueDescription$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType;

        static {
            int[] iArr = new int[EventContainer.EventValueType.values().length];
            $SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType = iArr;
            try {
                iArr[EventContainer.EventValueType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[EventContainer.EventValueType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[EventContainer.EventValueType.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[EventContainer.EventValueType.LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public boolean checkForType(Object value) {
        int i = AnonymousClass1.$SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[this.mEventValueType.ordinal()];
        if (i == 1) {
            return value instanceof Integer;
        }
        if (i == 2) {
            return value instanceof Long;
        }
        if (i == 3) {
            return value instanceof String;
        }
        if (i != 4) {
            return false;
        }
        return value instanceof Object[];
    }

    public Object getObjectFromString(String value) {
        int i = AnonymousClass1.$SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[this.mEventValueType.ordinal()];
        if (i == 1) {
            try {
                return Integer.valueOf(value);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        if (i == 2) {
            try {
                return Long.valueOf(value);
            } catch (NumberFormatException unused2) {
                return null;
            }
        }
        if (i != 3) {
            return null;
        }
        return value;
    }
}
