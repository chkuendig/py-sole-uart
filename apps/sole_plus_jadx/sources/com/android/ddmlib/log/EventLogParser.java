package com.android.ddmlib.log;

import com.android.SdkConstants;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.Log;
import com.android.ddmlib.MultiLineReceiver;
import com.android.ddmlib.log.EventContainer;
import com.android.ddmlib.log.EventValueDescription;
import com.android.ddmlib.log.LogReceiver;
import com.android.ddmlib.utils.ArrayHelper;
import com.google.common.base.Charsets;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class EventLogParser {
    private static final String EVENT_TAG_MAP_FILE = "/system/etc/event-log-tags";
    private static final int EVENT_TYPE_INT = 0;
    private static final int EVENT_TYPE_LIST = 3;
    private static final int EVENT_TYPE_LONG = 1;
    private static final int EVENT_TYPE_STRING = 2;
    private final TreeMap<Integer, String> mTagMap = new TreeMap<>();
    private final TreeMap<Integer, EventValueDescription[]> mValueDescriptionMap = new TreeMap<>();
    private static final Pattern PATTERN_SIMPLE_TAG = Pattern.compile("^(\\d+)\\s+([A-Za-z0-9_]+)\\s*$");
    private static final Pattern PATTERN_TAG_WITH_DESC = Pattern.compile("^(\\d+)\\s+([A-Za-z0-9_]+)\\s*(.*)\\s*$");
    private static final Pattern PATTERN_DESCRIPTION = Pattern.compile("\\(([A-Za-z0-9_\\s]+)\\|(\\d+)(\\|\\d+){0,1}\\)");
    private static final Pattern TEXT_LOG_LINE = Pattern.compile("(\\d\\d)-(\\d\\d)\\s(\\d\\d):(\\d\\d):(\\d\\d).(\\d{3})\\s+I/([a-zA-Z0-9_]+)\\s*\\(\\s*(\\d+)\\):\\s+(.*)");

    public boolean init(IDevice device) {
        try {
            device.executeShellCommand("cat /system/etc/event-log-tags", new MultiLineReceiver() { // from class: com.android.ddmlib.log.EventLogParser.1
                @Override // com.android.ddmlib.IShellOutputReceiver
                public boolean isCancelled() {
                    return false;
                }

                @Override // com.android.ddmlib.MultiLineReceiver
                public void processNewLines(String[] lines) throws NumberFormatException {
                    for (String str : lines) {
                        EventLogParser.this.processTagLine(str);
                    }
                }
            });
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean init(String[] tagFileContent) throws NumberFormatException {
        for (String str : tagFileContent) {
            processTagLine(str);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean init(java.lang.String r4) throws java.lang.Throwable {
        /*
            r3 = this;
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L27
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L27
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L27
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L27
        Lb:
            java.lang.String r4 = r1.readLine()     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L1e
            if (r4 == 0) goto L14
            r3.processTagLine(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L1e
        L14:
            if (r4 != 0) goto Lb
            r1.close()     // Catch: java.io.IOException -> L19
        L19:
            r4 = 1
            return r4
        L1b:
            r4 = move-exception
            r0 = r1
            goto L21
        L1e:
            r0 = r1
            goto L27
        L20:
            r4 = move-exception
        L21:
            if (r0 == 0) goto L26
            r0.close()     // Catch: java.io.IOException -> L26
        L26:
            throw r4
        L27:
            if (r0 == 0) goto L2c
            r0.close()     // Catch: java.io.IOException -> L2c
        L2c:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ddmlib.log.EventLogParser.init(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processTagLine(String line) throws NumberFormatException {
        EventValueDescription[] eventValueDescriptionArrProcessDescription;
        if (line.isEmpty() || line.charAt(0) == '#') {
            return;
        }
        Matcher matcher = PATTERN_TAG_WITH_DESC.matcher(line);
        if (matcher.matches()) {
            try {
                int i = Integer.parseInt(matcher.group(1));
                String strGroup = matcher.group(2);
                if (strGroup != null && this.mTagMap.get(Integer.valueOf(i)) == null) {
                    this.mTagMap.put(Integer.valueOf(i), strGroup);
                }
                if (i == 20001) {
                    this.mValueDescriptionMap.put(Integer.valueOf(i), GcEventContainer.getValueDescriptions());
                    return;
                }
                String strGroup2 = matcher.group(3);
                if (strGroup2 == null || strGroup2.isEmpty() || (eventValueDescriptionArrProcessDescription = processDescription(strGroup2)) == null) {
                    return;
                }
                this.mValueDescriptionMap.put(Integer.valueOf(i), eventValueDescriptionArrProcessDescription);
                return;
            } catch (NumberFormatException unused) {
                return;
            }
        }
        Matcher matcher2 = PATTERN_SIMPLE_TAG.matcher(line);
        if (matcher2.matches()) {
            int i2 = Integer.parseInt(matcher2.group(1));
            String strGroup3 = matcher2.group(2);
            if (strGroup3 == null || this.mTagMap.get(Integer.valueOf(i2)) != null) {
                return;
            }
            this.mTagMap.put(Integer.valueOf(i2), strGroup3);
        }
    }

    private EventValueDescription[] processDescription(String description) {
        String[] strArrSplit = description.split("\\s*,\\s*");
        ArrayList arrayList = new ArrayList();
        for (String str : strArrSplit) {
            Matcher matcher = PATTERN_DESCRIPTION.matcher(str);
            if (matcher.matches()) {
                try {
                    String strGroup = matcher.group(1);
                    EventContainer.EventValueType eventValueType = EventContainer.EventValueType.getEventValueType(Integer.parseInt(matcher.group(2)));
                    String strGroup2 = matcher.group(3);
                    if (strGroup2 != null && !strGroup2.isEmpty()) {
                        arrayList.add(new EventValueDescription(strGroup, eventValueType, EventValueDescription.ValueType.getValueType(Integer.parseInt(strGroup2.substring(1)))));
                    } else {
                        arrayList.add(new EventValueDescription(strGroup, eventValueType));
                    }
                } catch (InvalidValueTypeException | NumberFormatException unused) {
                }
            } else {
                Log.e("EventLogParser", String.format("Can't parse %1$s", description));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (EventValueDescription[]) arrayList.toArray(new EventValueDescription[0]);
    }

    public EventContainer parse(LogReceiver.LogEntry entry) {
        Object array;
        if (entry.len < 4) {
            return null;
        }
        int iSwap32bitFromArray = ArrayHelper.swap32bitFromArray(entry.data, 0);
        if (this.mTagMap.get(Integer.valueOf(iSwap32bitFromArray)) == null) {
            Log.e("EventLogParser", String.format("unknown tag number: %1$d", Integer.valueOf(iSwap32bitFromArray)));
        }
        ArrayList arrayList = new ArrayList();
        if (parseBinaryEvent(entry.data, 4, arrayList) == -1) {
            return null;
        }
        if (arrayList.size() == 1) {
            array = arrayList.get(0);
        } else {
            array = arrayList.toArray();
        }
        if (iSwap32bitFromArray == 20001) {
            return new GcEventContainer(entry, iSwap32bitFromArray, array);
        }
        return new EventContainer(entry, iSwap32bitFromArray, array);
    }

    public EventContainer parse(String textLogLine) throws NumberFormatException {
        int iIntValue;
        if (textLogLine.isEmpty()) {
            return null;
        }
        Matcher matcher = TEXT_LOG_LINE.matcher(textLogLine);
        if (matcher.matches()) {
            try {
                int i = Integer.parseInt(matcher.group(1));
                int i2 = Integer.parseInt(matcher.group(2));
                int i3 = Integer.parseInt(matcher.group(3));
                int i4 = Integer.parseInt(matcher.group(4));
                int i5 = Integer.parseInt(matcher.group(5));
                int i6 = Integer.parseInt(matcher.group(6));
                Calendar calendar = Calendar.getInstance();
                calendar.set(calendar.get(1), i - 1, i2, i3, i4, i5);
                int iFloor = (int) Math.floor(calendar.getTimeInMillis() / 1000);
                int i7 = i6 * 1000000;
                String strGroup = matcher.group(7);
                Iterator<Map.Entry<Integer, String>> it = this.mTagMap.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        iIntValue = -1;
                        break;
                    }
                    Map.Entry<Integer, String> next = it.next();
                    if (strGroup.equals(next.getValue())) {
                        iIntValue = next.getKey().intValue();
                        break;
                    }
                }
                if (iIntValue == -1) {
                    return null;
                }
                int i8 = Integer.parseInt(matcher.group(8));
                Object textData = parseTextData(matcher.group(9), iIntValue);
                if (textData == null) {
                    return null;
                }
                if (iIntValue == 20001) {
                    return new GcEventContainer(iIntValue, i8, -1, iFloor, i7, textData);
                }
                return new EventContainer(iIntValue, i8, -1, iFloor, i7, textData);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public Map<Integer, String> getTagMap() {
        return this.mTagMap;
    }

    public Map<Integer, EventValueDescription[]> getEventInfoMap() {
        return this.mValueDescriptionMap;
    }

    private static int parseBinaryEvent(byte[] eventData, int dataOffset, ArrayList<Object> list) {
        int i;
        if (eventData.length - dataOffset < 1) {
            return -1;
        }
        int i2 = dataOffset + 1;
        byte b = eventData[dataOffset];
        if (b == 0) {
            if (eventData.length - i2 < 4) {
                return -1;
            }
            i = dataOffset + 5;
            list.add(Integer.valueOf(ArrayHelper.swap32bitFromArray(eventData, i2)));
        } else if (b == 1) {
            if (eventData.length - i2 < 8) {
                return -1;
            }
            i = dataOffset + 9;
            list.add(Long.valueOf(ArrayHelper.swap64bitFromArray(eventData, i2)));
        } else if (b == 2) {
            if (eventData.length - i2 < 4) {
                return -1;
            }
            int iSwap32bitFromArray = ArrayHelper.swap32bitFromArray(eventData, i2);
            int i3 = dataOffset + 5;
            if (eventData.length - i3 < iSwap32bitFromArray) {
                return -1;
            }
            list.add(new String(eventData, i3, iSwap32bitFromArray, Charsets.UTF_8));
            i = i3 + iSwap32bitFromArray;
        } else if (b == 3) {
            if (eventData.length - i2 < 1) {
                return -1;
            }
            i = dataOffset + 2;
            byte b2 = eventData[i2];
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < b2; i4++) {
                int binaryEvent = parseBinaryEvent(eventData, i, arrayList);
                if (binaryEvent == -1) {
                    return binaryEvent;
                }
                i += binaryEvent;
            }
            list.add(arrayList.toArray());
        } else {
            Log.e("EventLogParser", String.format("Unknown binary event type %1$d", Integer.valueOf(b)));
            return -1;
        }
        return i - dataOffset;
    }

    private Object parseTextData(String data, int tagValue) {
        EventValueDescription[] eventValueDescriptionArr = this.mValueDescriptionMap.get(Integer.valueOf(tagValue));
        if (eventValueDescriptionArr == null) {
            return null;
        }
        if (eventValueDescriptionArr.length == 1) {
            return getObjectFromString(data, eventValueDescriptionArr[0].getEventValueType());
        }
        if (!data.startsWith("[") || !data.endsWith("]")) {
            return null;
        }
        String[] strArrSplit = data.substring(1, data.length() - 1).split(",");
        if (tagValue == 20001) {
            return new Object[]{getObjectFromString(strArrSplit[0], EventContainer.EventValueType.LONG), getObjectFromString(strArrSplit[1], EventContainer.EventValueType.LONG)};
        }
        if (strArrSplit.length != eventValueDescriptionArr.length) {
            return null;
        }
        Object[] objArr = new Object[strArrSplit.length];
        for (int i = 0; i < eventValueDescriptionArr.length; i++) {
            Object objectFromString = getObjectFromString(strArrSplit[i], eventValueDescriptionArr[i].getEventValueType());
            if (objectFromString == null) {
                return null;
            }
            objArr[i] = objectFromString;
        }
        return objArr;
    }

    /* renamed from: com.android.ddmlib.log.EventLogParser$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
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
        }
    }

    private Object getObjectFromString(String value, EventContainer.EventValueType type) {
        try {
            int i = AnonymousClass2.$SwitchMap$com$android$ddmlib$log$EventContainer$EventValueType[type.ordinal()];
            if (i == 1) {
                return Integer.valueOf(value);
            }
            if (i == 2) {
                return Long.valueOf(value);
            }
            if (i != 3) {
                return null;
            }
            return value;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public void saveTags(String filePath) throws Throwable {
        FileOutputStream fileOutputStream;
        Throwable th;
        String string;
        File file = new File(filePath);
        file.createNewFile();
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th2) {
            fileOutputStream = null;
            th = th2;
        }
        try {
            for (Integer num : this.mTagMap.keySet()) {
                String str = this.mTagMap.get(num);
                EventValueDescription[] eventValueDescriptionArr = this.mValueDescriptionMap.get(num);
                if (eventValueDescriptionArr != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.format("%1$d %2$s", num, str));
                    boolean z = true;
                    for (EventValueDescription eventValueDescription : eventValueDescriptionArr) {
                        if (z) {
                            sb.append(" (");
                            z = false;
                        } else {
                            sb.append(",(");
                        }
                        sb.append(eventValueDescription.getName());
                        sb.append(SdkConstants.VALUE_DELIMITER_PIPE);
                        sb.append(eventValueDescription.getEventValueType().getValue());
                        sb.append(SdkConstants.VALUE_DELIMITER_PIPE);
                        sb.append(eventValueDescription.getValueType().getValue());
                        sb.append("|)");
                    }
                    sb.append("\n");
                    string = sb.toString();
                } else {
                    string = String.format("%1$d %2$s\n", num, str);
                }
                fileOutputStream.write(string.getBytes());
            }
            fileOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
