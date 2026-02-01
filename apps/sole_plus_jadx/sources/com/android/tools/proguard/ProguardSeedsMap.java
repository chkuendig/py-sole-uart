package com.android.tools.proguard;

import com.google.common.base.Charsets;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class ProguardSeedsMap {
    private final Set<String> classes;
    private final Multimap<String, String> fieldNamesByClass;
    private final Multimap<String, String> methodSpecsByClass;

    private ProguardSeedsMap(Set<String> classes, Multimap<String, String> methodSpecsByClass, Multimap<String, String> fieldNamesByClass) {
        this.classes = ImmutableSet.copyOf((Collection) classes);
        this.methodSpecsByClass = ImmutableMultimap.copyOf(methodSpecsByClass);
        this.fieldNamesByClass = ImmutableMultimap.copyOf(fieldNamesByClass);
    }

    public boolean hasClass(String fqcn) {
        return this.classes.contains(fqcn);
    }

    public boolean hasMethod(String fqcn, String methodNameAndParams) {
        return this.methodSpecsByClass.containsEntry(fqcn, methodNameAndParams);
    }

    public boolean hasField(String fqcn, String fieldName) {
        return this.fieldNamesByClass.containsEntry(fqcn, fieldName);
    }

    public static ProguardSeedsMap parse(Path seedsMap) throws IOException {
        return parse(Files.newBufferedReader(seedsMap, Charsets.UTF_8));
    }

    public static ProguardSeedsMap parse(Reader reader) throws IOException {
        HashSet hashSet = new HashSet();
        ArrayListMultimap arrayListMultimapCreate = ArrayListMultimap.create();
        ArrayListMultimap arrayListMultimapCreate2 = ArrayListMultimap.create();
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    int iIndexOf = line.indexOf(58);
                    if (iIndexOf < 0) {
                        hashSet.add(line.trim());
                    } else {
                        String strTrim = line.substring(0, iIndexOf).trim();
                        String strTrim2 = line.substring(iIndexOf + 1).trim();
                        if (strTrim2.contains("(")) {
                            if (strTrim2.indexOf(32) != -1) {
                                strTrim2 = strTrim2.substring(strTrim2.indexOf(32) + 1);
                            }
                            arrayListMultimapCreate.put(strTrim, strTrim2);
                        } else {
                            arrayListMultimapCreate2.put(strTrim, strTrim2.substring(strTrim2.indexOf(32) + 1));
                        }
                    }
                } else {
                    bufferedReader.close();
                    return new ProguardSeedsMap(hashSet, arrayListMultimapCreate, arrayListMultimapCreate2);
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
    }
}
