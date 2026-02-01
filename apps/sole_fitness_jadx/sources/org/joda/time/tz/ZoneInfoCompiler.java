package org.joda.time.tz;

import com.dyaco.sole.R2;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.LenientChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/* loaded from: classes2.dex */
public class ZoneInfoCompiler {
    static Chronology cLenientISO;
    static DateTimeOfYear cStartOfYear;
    private Map<String, RuleSet> iRuleSets = new HashMap();
    private List<Zone> iZones = new ArrayList();
    private List<String> iGoodLinks = new ArrayList();
    private List<String> iBackLinks = new ArrayList();

    static char parseZoneChar(char c) {
        if (c != 'G') {
            if (c != 'S') {
                if (c != 'U' && c != 'Z' && c != 'g') {
                    if (c != 's') {
                        if (c != 'u' && c != 'z') {
                            return 'w';
                        }
                    }
                }
            }
            return 's';
        }
        return 'u';
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        if ("-?".equals(r9[r3]) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        printUsage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void main(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            printUsage();
            return;
        }
        File file = null;
        int i = 0;
        File file2 = null;
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= strArr.length) {
                break;
            }
            try {
                if ("-src".equals(strArr[i2])) {
                    i2++;
                    file = new File(strArr[i2]);
                } else if ("-dst".equals(strArr[i2])) {
                    i2++;
                    file2 = new File(strArr[i2]);
                } else if (!"-verbose".equals(strArr[i2])) {
                    break;
                } else {
                    z = true;
                }
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                printUsage();
                return;
            }
        }
        if (i2 >= strArr.length) {
            printUsage();
            return;
        }
        File[] fileArr = new File[strArr.length - i2];
        while (i2 < strArr.length) {
            fileArr[i] = file == null ? new File(strArr[i2]) : new File(file, strArr[i2]);
            i2++;
            i++;
        }
        ZoneInfoLogger.set(z);
        new ZoneInfoCompiler().compile(file2, fileArr);
    }

    private static void printUsage() {
        System.out.println("Usage: java org.joda.time.tz.ZoneInfoCompiler <options> <source files>");
        System.out.println("where possible options include:");
        System.out.println("  -src <directory>    Specify where to read source files");
        System.out.println("  -dst <directory>    Specify where to write generated files");
        System.out.println("  -verbose            Output verbosely (default false)");
    }

    static DateTimeOfYear getStartOfYear() {
        if (cStartOfYear == null) {
            cStartOfYear = new DateTimeOfYear();
        }
        return cStartOfYear;
    }

    static Chronology getLenientISOChronology() {
        if (cLenientISO == null) {
            cLenientISO = LenientChronology.getInstance(ISOChronology.getInstanceUTC());
        }
        return cLenientISO;
    }

    static void writeZoneInfoMap(DataOutputStream dataOutputStream, Map<String, DateTimeZone> map) throws IOException {
        HashMap map2 = new HashMap(map.size());
        TreeMap treeMap = new TreeMap();
        short s = 0;
        for (Map.Entry<String, DateTimeZone> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!map2.containsKey(key)) {
                Short shValueOf = Short.valueOf(s);
                map2.put(key, shValueOf);
                treeMap.put(shValueOf, key);
                s = (short) (s + 1);
                if (s == 0) {
                    throw new InternalError("Too many time zone ids");
                }
            }
            String id = entry.getValue().getID();
            if (!map2.containsKey(id)) {
                Short shValueOf2 = Short.valueOf(s);
                map2.put(id, shValueOf2);
                treeMap.put(shValueOf2, id);
                s = (short) (s + 1);
                if (s == 0) {
                    throw new InternalError("Too many time zone ids");
                }
            }
        }
        dataOutputStream.writeShort(treeMap.size());
        Iterator it = treeMap.values().iterator();
        while (it.hasNext()) {
            dataOutputStream.writeUTF((String) it.next());
        }
        dataOutputStream.writeShort(map.size());
        for (Map.Entry<String, DateTimeZone> entry2 : map.entrySet()) {
            dataOutputStream.writeShort(((Short) map2.get(entry2.getKey())).shortValue());
            dataOutputStream.writeShort(((Short) map2.get(entry2.getValue().getID())).shortValue());
        }
    }

    static int parseYear(String str, int i) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (lowerCase.equals("minimum") || lowerCase.equals("min")) {
            return Integer.MIN_VALUE;
        }
        if (lowerCase.equals("maximum") || lowerCase.equals("max")) {
            return Integer.MAX_VALUE;
        }
        return lowerCase.equals("only") ? i : Integer.parseInt(lowerCase);
    }

    static int parseMonth(String str) {
        DateTimeField dateTimeFieldMonthOfYear = ISOChronology.getInstanceUTC().monthOfYear();
        return dateTimeFieldMonthOfYear.get(dateTimeFieldMonthOfYear.set(0L, str, Locale.ENGLISH));
    }

    static int parseDayOfWeek(String str) {
        DateTimeField dateTimeFieldDayOfWeek = ISOChronology.getInstanceUTC().dayOfWeek();
        return dateTimeFieldDayOfWeek.get(dateTimeFieldDayOfWeek.set(0L, str, Locale.ENGLISH));
    }

    static String parseOptional(String str) {
        if (str.equals(HelpFormatter.DEFAULT_OPT_PREFIX)) {
            return null;
        }
        return str;
    }

    static int parseTime(String str) {
        DateTimeFormatter dateTimeFormatterHourMinuteSecondFraction = ISODateTimeFormat.hourMinuteSecondFraction();
        MutableDateTime mutableDateTime = new MutableDateTime(0L, getLenientISOChronology());
        boolean zStartsWith = str.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX);
        if (dateTimeFormatterHourMinuteSecondFraction.parseInto(mutableDateTime, str, zStartsWith ? 1 : 0) == (~(zStartsWith ? 1 : 0))) {
            throw new IllegalArgumentException(str);
        }
        int millis = (int) mutableDateTime.getMillis();
        return zStartsWith ? -millis : millis;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e4, code lost:
    
        r5 = org.joda.time.chrono.ISOChronology.getInstanceUTC().year().set(0, com.dyaco.sole.R2.drawable.program_icon_fittest);
        r3 = org.joda.time.chrono.ISOChronology.getInstanceUTC().year().set(0, com.dyaco.sole.R2.drawable.display_hr1);
        r1 = r13.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0104, code lost:
    
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0106, code lost:
    
        if (r1 < 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0108, code lost:
    
        r8 = r17.previousTransition(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x010e, code lost:
    
        if (r8 == r5) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0112, code lost:
    
        if (r8 >= r3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0115, code lost:
    
        r5 = ((java.lang.Long) r13.get(r1)).longValue() - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0124, code lost:
    
        if (r5 == r8) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0126, code lost:
    
        java.lang.System.out.println("*r* Error in " + r17.getID() + org.apache.commons.lang3.StringUtils.SPACE + new org.joda.time.DateTime(r8, org.joda.time.chrono.ISOChronology.getInstanceUTC()) + " != " + new org.joda.time.DateTime(r5, org.joda.time.chrono.ISOChronology.getInstanceUTC()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0160, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0161, code lost:
    
        r5 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0163, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static boolean test(String str, DateTimeZone dateTimeZone) {
        long jNextTransition;
        String nameKey;
        if (!str.equals(dateTimeZone.getID())) {
            return true;
        }
        long j = ISOChronology.getInstanceUTC().year().set(0L, R2.drawable.display_hr1);
        long j2 = ISOChronology.getInstanceUTC().year().set(0L, R2.drawable.program_icon_fittest);
        int offset = dateTimeZone.getOffset(j);
        int standardOffset = dateTimeZone.getStandardOffset(j);
        String nameKey2 = dateTimeZone.getNameKey(j);
        ArrayList arrayList = new ArrayList();
        while (true) {
            jNextTransition = dateTimeZone.nextTransition(j);
            if (jNextTransition == j || jNextTransition > j2) {
                break;
            }
            int offset2 = dateTimeZone.getOffset(jNextTransition);
            int standardOffset2 = dateTimeZone.getStandardOffset(jNextTransition);
            nameKey = dateTimeZone.getNameKey(jNextTransition);
            if (offset == offset2 && standardOffset == standardOffset2 && nameKey2.equals(nameKey)) {
                System.out.println("*d* Error in " + dateTimeZone.getID() + StringUtils.SPACE + new DateTime(jNextTransition, ISOChronology.getInstanceUTC()));
                return false;
            }
            if (nameKey == null || (nameKey.length() < 3 && !"??".equals(nameKey))) {
                break;
            }
            arrayList.add(Long.valueOf(jNextTransition));
            nameKey2 = nameKey;
            offset = offset2;
            j = jNextTransition;
        }
        System.out.println("*s* Error in " + dateTimeZone.getID() + StringUtils.SPACE + new DateTime(jNextTransition, ISOChronology.getInstanceUTC()) + ", nameKey=" + nameKey);
        return false;
    }

    public Map<String, DateTimeZone> compile(File file, File[] fileArr) throws Throwable {
        if (fileArr != null) {
            for (int i = 0; i < fileArr.length; i++) {
                BufferedReader bufferedReader = null;
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileArr[i]));
                    try {
                        parseDataFile(bufferedReader2, "backward".equals(fileArr[i].getName()));
                        bufferedReader2.close();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        if (file != null) {
            if (!file.exists() && !file.mkdirs()) {
                throw new IOException("Destination directory doesn't exist and cannot be created: " + file);
            }
            if (!file.isDirectory()) {
                throw new IOException("Destination is not a directory: " + file);
            }
        }
        TreeMap treeMap = new TreeMap();
        TreeMap treeMap2 = new TreeMap();
        System.out.println("Writing zoneinfo files");
        for (int i2 = 0; i2 < this.iZones.size(); i2++) {
            Zone zone = this.iZones.get(i2);
            DateTimeZoneBuilder dateTimeZoneBuilder = new DateTimeZoneBuilder();
            zone.addToBuilder(dateTimeZoneBuilder, this.iRuleSets);
            DateTimeZone dateTimeZone = dateTimeZoneBuilder.toDateTimeZone(zone.iName, true);
            if (test(dateTimeZone.getID(), dateTimeZone)) {
                treeMap.put(dateTimeZone.getID(), dateTimeZone);
                treeMap2.put(dateTimeZone.getID(), zone);
                if (file != null) {
                    writeZone(file, dateTimeZoneBuilder, dateTimeZone);
                }
            }
        }
        for (int i3 = 0; i3 < this.iGoodLinks.size(); i3 += 2) {
            String str = this.iGoodLinks.get(i3);
            String str2 = this.iGoodLinks.get(i3 + 1);
            Zone zone2 = (Zone) treeMap2.get(str);
            if (zone2 == null) {
                System.out.println("Cannot find source zone '" + str + "' to link alias '" + str2 + "' to");
            } else {
                DateTimeZoneBuilder dateTimeZoneBuilder2 = new DateTimeZoneBuilder();
                zone2.addToBuilder(dateTimeZoneBuilder2, this.iRuleSets);
                DateTimeZone dateTimeZone2 = dateTimeZoneBuilder2.toDateTimeZone(str2, true);
                if (test(dateTimeZone2.getID(), dateTimeZone2)) {
                    treeMap.put(dateTimeZone2.getID(), dateTimeZone2);
                    if (file != null) {
                        writeZone(file, dateTimeZoneBuilder2, dateTimeZone2);
                    }
                }
                treeMap.put(dateTimeZone2.getID(), dateTimeZone2);
                if (ZoneInfoLogger.verbose()) {
                    System.out.println("Good link: " + str2 + " -> " + str + " revived");
                }
            }
        }
        for (int i4 = 0; i4 < 2; i4++) {
            for (int i5 = 0; i5 < this.iBackLinks.size(); i5 += 2) {
                String str3 = this.iBackLinks.get(i5);
                String str4 = this.iBackLinks.get(i5 + 1);
                DateTimeZone dateTimeZone3 = (DateTimeZone) treeMap.get(str3);
                if (dateTimeZone3 != null) {
                    treeMap.put(str4, dateTimeZone3);
                    if (ZoneInfoLogger.verbose()) {
                        System.out.println("Back link: " + str4 + " -> " + dateTimeZone3.getID());
                    }
                } else if (i4 > 0) {
                    System.out.println("Cannot find time zone '" + str3 + "' to link alias '" + str4 + "' to");
                }
            }
        }
        if (file != null) {
            System.out.println("Writing ZoneInfoMap");
            File file2 = new File(file, "ZoneInfoMap");
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file2));
            try {
                TreeMap treeMap3 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                treeMap3.putAll(treeMap);
                writeZoneInfoMap(dataOutputStream, treeMap3);
            } finally {
                dataOutputStream.close();
            }
        }
        return treeMap;
    }

    private void writeZone(File file, DateTimeZoneBuilder dateTimeZoneBuilder, DateTimeZone dateTimeZone) throws IOException {
        if (ZoneInfoLogger.verbose()) {
            System.out.println("Writing " + dateTimeZone.getID());
        }
        File file2 = new File(file, dateTimeZone.getID());
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            dateTimeZoneBuilder.writeTo(dateTimeZone.getID(), fileOutputStream);
            fileOutputStream.close();
            FileInputStream fileInputStream = new FileInputStream(file2);
            DateTimeZone from = DateTimeZoneBuilder.readFrom(fileInputStream, dateTimeZone.getID());
            fileInputStream.close();
            if (dateTimeZone.equals(from)) {
                return;
            }
            System.out.println("*e* Error in " + dateTimeZone.getID() + ": Didn't read properly from file");
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    public void parseDataFile(BufferedReader bufferedReader, boolean z) throws IOException {
        while (true) {
            Zone zone = null;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    if (zone != null) {
                        this.iZones.add(zone);
                        return;
                    }
                    return;
                }
                String strTrim = line.trim();
                if (strTrim.length() != 0 && strTrim.charAt(0) != '#') {
                    int iIndexOf = line.indexOf(35);
                    if (iIndexOf >= 0) {
                        line = line.substring(0, iIndexOf);
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(line, " \t");
                    if (!Character.isWhitespace(line.charAt(0)) || !stringTokenizer.hasMoreTokens()) {
                        if (zone != null) {
                            this.iZones.add(zone);
                        }
                        if (stringTokenizer.hasMoreTokens()) {
                            String strNextToken = stringTokenizer.nextToken();
                            if (strNextToken.equalsIgnoreCase("Rule")) {
                                Rule rule = new Rule(stringTokenizer);
                                RuleSet ruleSet = this.iRuleSets.get(rule.iName);
                                if (ruleSet == null) {
                                    this.iRuleSets.put(rule.iName, new RuleSet(rule));
                                } else {
                                    ruleSet.addRule(rule);
                                }
                            } else if (strNextToken.equalsIgnoreCase("Zone")) {
                                if (stringTokenizer.countTokens() < 4) {
                                    throw new IllegalArgumentException("Attempting to create a Zone from an incomplete tokenizer");
                                }
                                zone = new Zone(stringTokenizer);
                            } else if (strNextToken.equalsIgnoreCase("Link")) {
                                String strNextToken2 = stringTokenizer.nextToken();
                                String strNextToken3 = stringTokenizer.nextToken();
                                if (z || strNextToken3.equals("US/Pacific-New") || strNextToken3.startsWith("Etc/") || strNextToken3.equals("GMT")) {
                                    this.iBackLinks.add(strNextToken2);
                                    this.iBackLinks.add(strNextToken3);
                                } else {
                                    this.iGoodLinks.add(strNextToken2);
                                    this.iGoodLinks.add(strNextToken3);
                                }
                            } else {
                                System.out.println("Unknown line: " + line);
                            }
                        }
                    } else if (zone != null) {
                        zone.chain(stringTokenizer);
                    }
                }
            }
        }
    }

    static class DateTimeOfYear {
        public final boolean iAdvanceDayOfWeek;
        public final int iDayOfMonth;
        public final int iDayOfWeek;
        public final int iMillisOfDay;
        public final int iMonthOfYear;
        public final char iZoneChar;

        DateTimeOfYear() {
            this.iMonthOfYear = 1;
            this.iDayOfMonth = 1;
            this.iDayOfWeek = 0;
            this.iAdvanceDayOfWeek = false;
            this.iMillisOfDay = 0;
            this.iZoneChar = 'w';
        }

        DateTimeOfYear(StringTokenizer stringTokenizer) throws NumberFormatException {
            int i;
            boolean z;
            int i2;
            int dayOfWeek;
            LocalDate localDate;
            LocalDate localDatePlusDays;
            int time = 0;
            int i3 = 1;
            char zoneChar = 'w';
            if (stringTokenizer.hasMoreTokens()) {
                int month = ZoneInfoCompiler.parseMonth(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    String strNextToken = stringTokenizer.nextToken();
                    if (strNextToken.startsWith("last")) {
                        z = false;
                        dayOfWeek = ZoneInfoCompiler.parseDayOfWeek(strNextToken.substring(4));
                        i2 = -1;
                    } else {
                        try {
                            i2 = Integer.parseInt(strNextToken);
                            dayOfWeek = 0;
                            z = false;
                        } catch (NumberFormatException unused) {
                            int iIndexOf = strNextToken.indexOf(">=");
                            if (iIndexOf > 0) {
                                int i4 = Integer.parseInt(strNextToken.substring(iIndexOf + 2));
                                dayOfWeek = ZoneInfoCompiler.parseDayOfWeek(strNextToken.substring(0, iIndexOf));
                                i2 = i4;
                                z = true;
                            } else {
                                int iIndexOf2 = strNextToken.indexOf("<=");
                                if (iIndexOf2 > 0) {
                                    int i5 = Integer.parseInt(strNextToken.substring(iIndexOf2 + 2));
                                    dayOfWeek = ZoneInfoCompiler.parseDayOfWeek(strNextToken.substring(0, iIndexOf2));
                                    i2 = i5;
                                    z = false;
                                } else {
                                    throw new IllegalArgumentException(strNextToken);
                                }
                            }
                        }
                    }
                    if (stringTokenizer.hasMoreTokens()) {
                        String strNextToken2 = stringTokenizer.nextToken();
                        zoneChar = ZoneInfoCompiler.parseZoneChar(strNextToken2.charAt(strNextToken2.length() - 1));
                        if (!strNextToken2.equals("24:00")) {
                            time = ZoneInfoCompiler.parseTime(strNextToken2);
                        } else if (month == 12 && i2 == 31) {
                            time = ZoneInfoCompiler.parseTime("23:59:59.999");
                        } else {
                            if (i2 == -1) {
                                localDate = new LocalDate(R2.drawable.notification_bg_normal_pressed, month, 1);
                                localDatePlusDays = localDate.plusMonths(1);
                            } else {
                                localDate = new LocalDate(R2.drawable.notification_bg_normal_pressed, month, i2);
                                localDatePlusDays = localDate.plusDays(1);
                            }
                            boolean z2 = (i2 == -1 || dayOfWeek == 0) ? false : true;
                            int monthOfYear = localDatePlusDays.getMonthOfYear();
                            int dayOfMonth = localDatePlusDays.getDayOfMonth();
                            dayOfWeek = dayOfWeek != 0 ? (((dayOfWeek - 1) + 1) % 7) + 1 : dayOfWeek;
                            z = z2;
                            i3 = monthOfYear;
                            i2 = dayOfMonth;
                            i = time;
                            time = dayOfWeek;
                        }
                        i3 = month;
                        i = time;
                        time = dayOfWeek;
                    } else {
                        i3 = month;
                        i = time;
                        time = dayOfWeek;
                    }
                } else {
                    i = 0;
                    z = false;
                    i2 = 1;
                    i3 = month;
                }
            } else {
                i = 0;
                z = false;
                i2 = 1;
            }
            this.iMonthOfYear = i3;
            this.iDayOfMonth = i2;
            this.iDayOfWeek = time;
            this.iAdvanceDayOfWeek = z;
            this.iMillisOfDay = i;
            this.iZoneChar = zoneChar;
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, String str, int i, int i2, int i3) {
            dateTimeZoneBuilder.addRecurringSavings(str, i, i2, i3, this.iZoneChar, this.iMonthOfYear, this.iDayOfMonth, this.iDayOfWeek, this.iAdvanceDayOfWeek, this.iMillisOfDay);
        }

        public void addCutover(DateTimeZoneBuilder dateTimeZoneBuilder, int i) {
            dateTimeZoneBuilder.addCutover(i, this.iZoneChar, this.iMonthOfYear, this.iDayOfMonth, this.iDayOfWeek, this.iAdvanceDayOfWeek, this.iMillisOfDay);
        }

        public String toString() {
            return "MonthOfYear: " + this.iMonthOfYear + StringUtils.LF + "DayOfMonth: " + this.iDayOfMonth + StringUtils.LF + "DayOfWeek: " + this.iDayOfWeek + StringUtils.LF + "AdvanceDayOfWeek: " + this.iAdvanceDayOfWeek + StringUtils.LF + "MillisOfDay: " + this.iMillisOfDay + StringUtils.LF + "ZoneChar: " + this.iZoneChar + StringUtils.LF;
        }
    }

    private static class Rule {
        public final DateTimeOfYear iDateTimeOfYear;
        public final int iFromYear;
        public final String iLetterS;
        public final String iName;
        public final int iSaveMillis;
        public final int iToYear;
        public final String iType;

        Rule(StringTokenizer stringTokenizer) {
            if (stringTokenizer.countTokens() < 6) {
                throw new IllegalArgumentException("Attempting to create a Rule from an incomplete tokenizer");
            }
            this.iName = stringTokenizer.nextToken().intern();
            int year = ZoneInfoCompiler.parseYear(stringTokenizer.nextToken(), 0);
            this.iFromYear = year;
            int year2 = ZoneInfoCompiler.parseYear(stringTokenizer.nextToken(), year);
            this.iToYear = year2;
            if (year2 < year) {
                throw new IllegalArgumentException();
            }
            this.iType = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
            this.iDateTimeOfYear = new DateTimeOfYear(stringTokenizer);
            this.iSaveMillis = ZoneInfoCompiler.parseTime(stringTokenizer.nextToken());
            this.iLetterS = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, String str) {
            this.iDateTimeOfYear.addRecurring(dateTimeZoneBuilder, formatName(str), this.iSaveMillis, this.iFromYear, this.iToYear);
        }

        private String formatName(String str) {
            String strConcat;
            int iIndexOf = str.indexOf(47);
            if (iIndexOf > 0) {
                if (this.iSaveMillis == 0) {
                    return str.substring(0, iIndexOf).intern();
                }
                return str.substring(iIndexOf + 1).intern();
            }
            int iIndexOf2 = str.indexOf("%s");
            if (iIndexOf2 < 0) {
                return str;
            }
            String strSubstring = str.substring(0, iIndexOf2);
            String strSubstring2 = str.substring(iIndexOf2 + 2);
            if (this.iLetterS == null) {
                strConcat = strSubstring.concat(strSubstring2);
            } else {
                strConcat = strSubstring + this.iLetterS + strSubstring2;
            }
            return strConcat.intern();
        }

        public String toString() {
            return "[Rule]\nName: " + this.iName + StringUtils.LF + "FromYear: " + this.iFromYear + StringUtils.LF + "ToYear: " + this.iToYear + StringUtils.LF + "Type: " + this.iType + StringUtils.LF + this.iDateTimeOfYear + "SaveMillis: " + this.iSaveMillis + StringUtils.LF + "LetterS: " + this.iLetterS + StringUtils.LF;
        }
    }

    private static class RuleSet {
        private List<Rule> iRules;

        RuleSet(Rule rule) {
            ArrayList arrayList = new ArrayList();
            this.iRules = arrayList;
            arrayList.add(rule);
        }

        void addRule(Rule rule) {
            if (!rule.iName.equals(this.iRules.get(0).iName)) {
                throw new IllegalArgumentException("Rule name mismatch");
            }
            this.iRules.add(rule);
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, String str) {
            for (int i = 0; i < this.iRules.size(); i++) {
                this.iRules.get(i).addRecurring(dateTimeZoneBuilder, str);
            }
        }
    }

    private static class Zone {
        public final String iFormat;
        public final String iName;
        private Zone iNext;
        public final int iOffsetMillis;
        public final String iRules;
        public final DateTimeOfYear iUntilDateTimeOfYear;
        public final int iUntilYear;

        Zone(StringTokenizer stringTokenizer) {
            this(stringTokenizer.nextToken(), stringTokenizer);
        }

        private Zone(String str, StringTokenizer stringTokenizer) throws NumberFormatException {
            int i;
            this.iName = str.intern();
            this.iOffsetMillis = ZoneInfoCompiler.parseTime(stringTokenizer.nextToken());
            this.iRules = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
            this.iFormat = stringTokenizer.nextToken().intern();
            DateTimeOfYear startOfYear = ZoneInfoCompiler.getStartOfYear();
            if (stringTokenizer.hasMoreTokens()) {
                i = Integer.parseInt(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    startOfYear = new DateTimeOfYear(stringTokenizer);
                }
            } else {
                i = Integer.MAX_VALUE;
            }
            this.iUntilYear = i;
            this.iUntilDateTimeOfYear = startOfYear;
        }

        void chain(StringTokenizer stringTokenizer) {
            Zone zone = this.iNext;
            if (zone != null) {
                zone.chain(stringTokenizer);
            } else {
                this.iNext = new Zone(this.iName, stringTokenizer);
            }
        }

        public void addToBuilder(DateTimeZoneBuilder dateTimeZoneBuilder, Map<String, RuleSet> map) {
            addToBuilder(this, dateTimeZoneBuilder, map);
        }

        private static void addToBuilder(Zone zone, DateTimeZoneBuilder dateTimeZoneBuilder, Map<String, RuleSet> map) {
            while (zone != null) {
                dateTimeZoneBuilder.setStandardOffset(zone.iOffsetMillis);
                String str = zone.iRules;
                if (str == null) {
                    dateTimeZoneBuilder.setFixedSavings(zone.iFormat, 0);
                } else {
                    try {
                        dateTimeZoneBuilder.setFixedSavings(zone.iFormat, ZoneInfoCompiler.parseTime(str));
                    } catch (Exception unused) {
                        RuleSet ruleSet = map.get(zone.iRules);
                        if (ruleSet == null) {
                            throw new IllegalArgumentException("Rules not found: " + zone.iRules);
                        }
                        ruleSet.addRecurring(dateTimeZoneBuilder, zone.iFormat);
                    }
                }
                int i = zone.iUntilYear;
                if (i == Integer.MAX_VALUE) {
                    return;
                }
                zone.iUntilDateTimeOfYear.addCutover(dateTimeZoneBuilder, i);
                zone = zone.iNext;
            }
        }

        public String toString() {
            String str = "[Zone]\nName: " + this.iName + StringUtils.LF + "OffsetMillis: " + this.iOffsetMillis + StringUtils.LF + "Rules: " + this.iRules + StringUtils.LF + "Format: " + this.iFormat + StringUtils.LF + "UntilYear: " + this.iUntilYear + StringUtils.LF + this.iUntilDateTimeOfYear;
            if (this.iNext == null) {
                return str;
            }
            return str + "...\n" + this.iNext.toString();
        }
    }
}
