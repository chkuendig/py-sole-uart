package org.joda.time.tz;

import com.dyaco.sole.custom.PostUtil;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public class ZoneInfoProvider implements Provider {
    private final File iFileDir;
    private final ClassLoader iLoader;
    private final String iResourcePath;
    private final Set<String> iZoneInfoKeys;
    private final Map<String, Object> iZoneInfoMap;

    public ZoneInfoProvider(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("No file directory provided");
        }
        if (!file.exists()) {
            throw new IOException("File directory doesn't exist: " + file);
        }
        if (!file.isDirectory()) {
            throw new IOException("File doesn't refer to a directory: " + file);
        }
        this.iFileDir = file;
        this.iResourcePath = null;
        this.iLoader = null;
        Map<String, Object> mapLoadZoneInfoMap = loadZoneInfoMap(openResource("ZoneInfoMap"));
        this.iZoneInfoMap = mapLoadZoneInfoMap;
        this.iZoneInfoKeys = Collections.unmodifiableSortedSet(new TreeSet(mapLoadZoneInfoMap.keySet()));
    }

    public ZoneInfoProvider(String str) throws IOException {
        this(str, null, false);
    }

    public ZoneInfoProvider(String str, ClassLoader classLoader) throws IOException {
        this(str, classLoader, true);
    }

    private ZoneInfoProvider(String str, ClassLoader classLoader, boolean z) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("No resource path provided");
        }
        if (!str.endsWith("/")) {
            str = str + '/';
        }
        this.iFileDir = null;
        this.iResourcePath = str;
        if (classLoader == null && !z) {
            classLoader = getClass().getClassLoader();
        }
        this.iLoader = classLoader;
        Map<String, Object> mapLoadZoneInfoMap = loadZoneInfoMap(openResource("ZoneInfoMap"));
        this.iZoneInfoMap = mapLoadZoneInfoMap;
        this.iZoneInfoKeys = Collections.unmodifiableSortedSet(new TreeSet(mapLoadZoneInfoMap.keySet()));
    }

    @Override // org.joda.time.tz.Provider
    public DateTimeZone getZone(String str) {
        Object obj;
        if (str == null || (obj = this.iZoneInfoMap.get(str)) == null) {
            return null;
        }
        if (obj instanceof SoftReference) {
            DateTimeZone dateTimeZone = (DateTimeZone) ((SoftReference) obj).get();
            return dateTimeZone != null ? dateTimeZone : loadZoneData(str);
        }
        if (str.equals(obj)) {
            return loadZoneData(str);
        }
        return getZone((String) obj);
    }

    @Override // org.joda.time.tz.Provider
    public Set<String> getAvailableIDs() {
        return this.iZoneInfoKeys;
    }

    protected void uncaughtException(Exception exc) {
        exc.printStackTrace();
    }

    private InputStream openResource(String str) throws IOException {
        if (this.iFileDir != null) {
            return new FileInputStream(new File(this.iFileDir, str));
        }
        final String strConcat = this.iResourcePath.concat(str);
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: org.joda.time.tz.ZoneInfoProvider.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public InputStream run() {
                if (ZoneInfoProvider.this.iLoader != null) {
                    return ZoneInfoProvider.this.iLoader.getResourceAsStream(strConcat);
                }
                return ClassLoader.getSystemResourceAsStream(strConcat);
            }
        });
        if (inputStream != null) {
            return inputStream;
        }
        StringBuilder sb = new StringBuilder(40);
        sb.append("Resource not found: \"");
        sb.append(strConcat);
        sb.append("\" ClassLoader: ");
        ClassLoader classLoader = this.iLoader;
        sb.append(classLoader != null ? classLoader.toString() : PostUtil.POST_TYPE_SYSTEM);
        throw new IOException(sb.toString());
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x001a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:9:0x001a */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private DateTimeZone loadZoneData(String str) throws Throwable {
        InputStream inputStreamOpenResource;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            try {
                inputStreamOpenResource = openResource(str);
                try {
                    DateTimeZone from = DateTimeZoneBuilder.readFrom(inputStreamOpenResource, str);
                    this.iZoneInfoMap.put(str, new SoftReference(from));
                    if (inputStreamOpenResource != null) {
                        try {
                            inputStreamOpenResource.close();
                        } catch (IOException unused) {
                        }
                    }
                    return from;
                } catch (IOException e) {
                    e = e;
                    uncaughtException(e);
                    this.iZoneInfoMap.remove(str);
                    if (inputStreamOpenResource != null) {
                        try {
                            inputStreamOpenResource.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStreamOpenResource = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    private static Map<String, Object> loadZoneInfoMap(InputStream inputStream) throws IOException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            readZoneInfoMap(dataInputStream, concurrentHashMap);
            concurrentHashMap.put("UTC", new SoftReference(DateTimeZone.UTC));
            return concurrentHashMap;
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private static void readZoneInfoMap(DataInputStream dataInputStream, Map<String, Object> map) throws IOException {
        int unsignedShort = dataInputStream.readUnsignedShort();
        String[] strArr = new String[unsignedShort];
        for (int i = 0; i < unsignedShort; i++) {
            strArr[i] = dataInputStream.readUTF().intern();
        }
        int unsignedShort2 = dataInputStream.readUnsignedShort();
        for (int i2 = 0; i2 < unsignedShort2; i2++) {
            try {
                map.put(strArr[dataInputStream.readUnsignedShort()], strArr[dataInputStream.readUnsignedShort()]);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IOException("Corrupt zone info map");
            }
        }
    }
}
