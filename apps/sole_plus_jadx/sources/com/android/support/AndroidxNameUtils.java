package com.android.support;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class AndroidxNameUtils {
    static final ImmutableMap<String, String> ANDROIDX_COORDINATES_MAPPING;
    static final ImmutableMap<String, String> ANDROIDX_FULL_CLASS_MAPPING;
    static final ImmutableList<String> ANDROIDX_OLD_PKGS;
    static final ImmutableMap<String, String> ANDROIDX_PKG_MAPPING;
    static final String ANDROID_ARCH_PKG = "android.arch.";
    static final String ANDROID_DATABINDING_PKG = "android.databinding.";
    static final String ANDROID_SUPPORT_PKG = "android.support.";
    private static final Logger LOG = Logger.getLogger(AndroidxName.class.getName());

    static {
        final ImmutableMap.Builder builder = ImmutableMap.builder();
        final ImmutableMap.Builder builder2 = ImmutableMap.builder();
        final ImmutableMap.Builder builder3 = ImmutableMap.builder();
        try {
            AndroidxMigrationParserKt.parseMigrationFile(new MigrationParserVisitor() { // from class: com.android.support.AndroidxNameUtils.1
                @Override // com.android.support.MigrationParserVisitor
                public void visitGradleCoordinateUpgrade(String groupName, String artifactName, String newBaseVersion) {
                }

                @Override // com.android.support.MigrationParserVisitor
                public void visitGradleCoordinate(String oldGroupName, String oldArtifactName, String newGroupName, String newArtifactName, String newBaseVersion) {
                    builder3.put(oldGroupName + ":" + oldArtifactName, newGroupName + ":" + newArtifactName);
                }

                @Override // com.android.support.MigrationParserVisitor
                public void visitClass(String old, String newName) {
                    builder.put(old, newName);
                }

                @Override // com.android.support.MigrationParserVisitor
                public void visitPackage(String old, String newName) {
                    builder2.put(old, newName);
                }
            });
        } catch (Throwable th) {
            LOG.severe("Error loading androidx migration mapping: " + th.getLocalizedMessage());
        }
        ANDROIDX_FULL_CLASS_MAPPING = builder.build();
        ImmutableMap<String, String> immutableMapBuild = builder2.build();
        ANDROIDX_PKG_MAPPING = immutableMapBuild;
        ANDROIDX_OLD_PKGS = Ordering.from(new Comparator() { // from class: com.android.support.AndroidxNameUtils$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Ints.compare(((String) obj2).length(), ((String) obj).length());
            }
        }).immutableSortedCopy(immutableMapBuild.keySet());
        ANDROIDX_COORDINATES_MAPPING = builder3.build();
    }

    static String getPackageMapping(String oldPkgName, boolean strictChecking) {
        int size = ANDROIDX_OLD_PKGS.size();
        for (int i = 0; i < size; i++) {
            String str = ANDROIDX_OLD_PKGS.get(i);
            if (oldPkgName.startsWith(str)) {
                return ANDROIDX_PKG_MAPPING.get(str) + oldPkgName.substring(str.length());
            }
        }
        if (strictChecking) {
            Logger logger = LOG;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine("support library package not found: " + oldPkgName);
            }
        }
        return oldPkgName;
    }

    public static Collection<String> getAllAndroidxCoordinates() {
        return ANDROIDX_COORDINATES_MAPPING.values();
    }

    public static String getCoordinateMapping(String coordinate) {
        return ANDROIDX_COORDINATES_MAPPING.getOrDefault(coordinate, coordinate);
    }

    public static String getVersionedCoordinateMapping(String coordinate) {
        String[] strArrSplit = coordinate.split(":");
        if (strArrSplit.length < 3) {
            return coordinate;
        }
        String orDefault = ANDROIDX_COORDINATES_MAPPING.getOrDefault(strArrSplit[0] + ":" + strArrSplit[1], null);
        return orDefault == null ? coordinate : orDefault + ":+";
    }

    public static String getNewName(String oldName) {
        int iIndexOf = oldName.indexOf(36);
        if (iIndexOf != -1) {
            return getNewName(oldName.substring(0, iIndexOf)) + oldName.substring(iIndexOf);
        }
        String str = ANDROIDX_FULL_CLASS_MAPPING.get(oldName);
        if (str != null) {
            return str;
        }
        int iLastIndexOf = oldName.lastIndexOf(46) + 1;
        return getPackageMapping(oldName.substring(0, iLastIndexOf), false) + oldName.substring(iLastIndexOf);
    }
}
