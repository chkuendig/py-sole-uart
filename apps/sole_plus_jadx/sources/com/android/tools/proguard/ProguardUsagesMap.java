package com.android.tools.proguard;

import androidx.health.connect.client.records.SexualActivityRecord;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Charsets;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import io.ktor.client.utils.CacheControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes3.dex */
public class ProguardUsagesMap {
    private static ImmutableSet<String> modifiers = ImmutableSet.of("abstract", "final", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, CacheControl.PRIVATE, SexualActivityRecord.Protection.PROTECTED, "public", "strictfp", "static", "synchronized", FacebookRequestErrorClassification.KEY_TRANSIENT, "volatile");
    private final Set<String> classes;
    private final Multimap<String, String> fieldsByClass;
    private final Multimap<String, String> methodsByClass;

    private ProguardUsagesMap(Set<String> classes, Multimap<String, String> methodsByClass, Multimap<String, String> fieldsByClass) {
        this.classes = ImmutableSet.copyOf((Collection) classes);
        this.methodsByClass = ImmutableMultimap.copyOf(methodsByClass);
        this.fieldsByClass = ImmutableMultimap.copyOf(fieldsByClass);
    }

    public Collection<String> getClasses() {
        return this.classes;
    }

    public Multimap<String, String> getMethodsByClass() {
        return this.methodsByClass;
    }

    public Multimap<String, String> getFieldsByClass() {
        return this.fieldsByClass;
    }

    public boolean hasClass(String fqcn) {
        return this.classes.contains(fqcn);
    }

    public boolean hasMethod(String fqcn, String methodSig) {
        return this.methodsByClass.containsEntry(fqcn, methodSig);
    }

    public boolean hasField(String fqcn, String fieldName) {
        return this.fieldsByClass.containsEntry(fqcn, fieldName);
    }

    public static ProguardUsagesMap parse(Path usageFile) throws IOException {
        return parse(Files.newBufferedReader(usageFile, Charsets.UTF_8));
    }

    public static ProguardUsagesMap parse(Reader reader) throws IOException {
        String line;
        HashSet hashSet = new HashSet();
        ArrayListMultimap arrayListMultimapCreate = ArrayListMultimap.create();
        ArrayListMultimap arrayListMultimapCreate2 = ArrayListMultimap.create();
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            String strSubstring = null;
            while (true) {
                try {
                    line = bufferedReader.readLine();
                    if (line != null) {
                        String strTrim = line.trim();
                        if (!line.isEmpty() && strTrim.charAt(0) != '#') {
                            if (Character.isWhitespace(line.charAt(0))) {
                                if (strSubstring == null) {
                                    throw new IOException("Unexpected format for proguard usages map. Encountered method or field with unknown class at line: " + strTrim);
                                }
                                String strSubstring2 = strTrim.substring(strTrim.lastIndexOf(58) + 1);
                                if (strSubstring2.contains("(")) {
                                    arrayListMultimapCreate.put(strSubstring, getMethodSpec(strSubstring2));
                                } else {
                                    arrayListMultimapCreate2.put(strSubstring, getFieldName(strSubstring2));
                                }
                            } else if (line.endsWith(":")) {
                                strSubstring = line.substring(0, line.length() - 1);
                            }
                        }
                    } else {
                        bufferedReader.close();
                        return new ProguardUsagesMap(hashSet, arrayListMultimapCreate, arrayListMultimapCreate2);
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            hashSet.add(line);
        }
    }

    private static String getFieldName(String line) throws IOException {
        int iLastIndexOf = line.lastIndexOf(32, line.lastIndexOf(32) - 1);
        if (iLastIndexOf < 0) {
            iLastIndexOf = 0;
        }
        if (iLastIndexOf < 0 || iLastIndexOf == line.length() - 1) {
            throw new IOException("Unexpected field specification in proguard usages map: " + line);
        }
        return line.substring(iLastIndexOf + 1);
    }

    private static String getMethodSpec(String line) {
        return ((String) Arrays.stream(line.split(" ")).filter(new Predicate() { // from class: com.android.tools.proguard.ProguardUsagesMap$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ProguardUsagesMap.lambda$getMethodSpec$0((String) obj);
            }
        }).collect(Collectors.joining(" "))).trim();
    }

    static /* synthetic */ boolean lambda$getMethodSpec$0(String str) {
        return !modifiers.contains(str);
    }
}
