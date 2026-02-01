package io.ktor.util;

import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Path.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0007\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\t*\u00020\nH\u0002\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u000e"}, d2 = {"combineSafe", "Ljava/io/File;", "dir", "relativePath", "dropLeadingTopDirs", "", "path", "", "isPathSeparator", "", "", "isPathSeparatorOrDot", "normalizeAndRelativize", "notRooted", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PathKt {
    private static final boolean isPathSeparator(char c) {
        return c == '\\' || c == '/';
    }

    public static final File combineSafe(File file, String relativePath) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        return combineSafe(file, new File(relativePath));
    }

    public static final File normalizeAndRelativize(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return dropLeadingTopDirs(notRooted(FilesKt.normalize(file)));
    }

    private static final File combineSafe(File file, File file2) {
        File fileNormalizeAndRelativize = normalizeAndRelativize(file2);
        if (FilesKt.startsWith(fileNormalizeAndRelativize, "..")) {
            throw new IllegalArgumentException("Bad relative path " + file2);
        }
        if (fileNormalizeAndRelativize.isAbsolute()) {
            throw new IllegalStateException(("Bad relative path " + file2).toString());
        }
        return new File(file, fileNormalizeAndRelativize.getPath());
    }

    private static final File notRooted(File file) {
        String strSubstring;
        if (!FilesKt.isRooted(file)) {
            return file;
        }
        File file2 = file;
        while (true) {
            File parentFile = file2.getParentFile();
            if (parentFile == null) {
                break;
            }
            file2 = parentFile;
        }
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        String strDrop = StringsKt.drop(path, file2.getName().length());
        int length = strDrop.length();
        int i = 0;
        while (true) {
            if (i < length) {
                char cCharAt = strDrop.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    strSubstring = strDrop.substring(i);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                    break;
                }
                i++;
            } else {
                strSubstring = "";
                break;
            }
        }
        return new File(strSubstring);
    }

    public static final int dropLeadingTopDirs(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        int length = path.length() - 1;
        int i = 0;
        while (i <= length) {
            char cCharAt = path.charAt(i);
            if (isPathSeparator(cCharAt)) {
                i++;
            } else {
                if (cCharAt != '.') {
                    return i;
                }
                if (i == length) {
                    return i + 1;
                }
                char cCharAt2 = path.charAt(i + 1);
                if (isPathSeparator(cCharAt2)) {
                    i += 2;
                } else {
                    if (cCharAt2 != '.') {
                        return i;
                    }
                    int i2 = i + 2;
                    if (i2 == path.length()) {
                        i = i2;
                    } else {
                        if (!isPathSeparator(path.charAt(i2))) {
                            return i;
                        }
                        i += 3;
                    }
                }
            }
        }
        return i;
    }

    private static final boolean isPathSeparatorOrDot(char c) {
        return c == '.' || isPathSeparator(c);
    }

    private static final File dropLeadingTopDirs(File file) {
        String path = file.getPath();
        if (path == null) {
            path = "";
        }
        int iDropLeadingTopDirs = dropLeadingTopDirs(path);
        if (iDropLeadingTopDirs == 0) {
            return file;
        }
        if (iDropLeadingTopDirs >= file.getPath().length()) {
            return new File(".");
        }
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "path");
        String strSubstring = path2.substring(iDropLeadingTopDirs);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return new File(strSubstring);
    }
}
