package com.android.utils;

import com.android.SdkConstants;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.FileWriteMode;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import kotlin.io.FilesKt;
import org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes3.dex */
public final class FileUtils {
    private static final Joiner PATH_JOINER = Joiner.on(File.separatorChar);
    private static final Joiner COMMA_SEPARATED_JOINER = Joiner.on(", ");
    private static final Joiner UNIX_NEW_LINE_JOINER = Joiner.on('\n');

    private FileUtils() {
    }

    public static void deletePath(final File path) throws InterruptedException, IOException {
        deleteRecursivelyIfExists(path);
    }

    public static void deleteDirectoryContents(final File directory) throws InterruptedException, IOException {
        Preconditions.checkArgument(directory.isDirectory(), "!directory.isDirectory");
        File[] fileArrListFiles = directory.listFiles();
        Preconditions.checkNotNull(fileArrListFiles);
        for (File file : fileArrListFiles) {
            deletePath(file);
        }
    }

    public static void cleanOutputDir(File path) throws InterruptedException, IOException {
        if (!path.isDirectory()) {
            if (path.exists()) {
                deletePath(path);
            }
            if (!path.mkdirs()) {
                throw new IOException(String.format("Could not create empty folder %s", path));
            }
            return;
        }
        deleteDirectoryContents(path);
    }

    public static void copyFile(File from, File to) throws IOException {
        copyFile(from.toPath(), to.toPath());
    }

    public static void copyFile(Path from, Path to) throws IOException {
        if (System.getProperty("os.name").toLowerCase(Locale.US).contains("windows")) {
            copyFile(from, to, StandardCopyOption.REPLACE_EXISTING);
        } else {
            copyFile(from, to, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static void copyFile(Path from, Path to, CopyOption... options) throws IOException {
        Files.copy(from, to, options);
        setWritable(to);
    }

    private static void setWritable(Path path) {
        File file;
        try {
            file = path.toFile();
        } catch (UnsupportedOperationException unused) {
            file = null;
        }
        if (file == null || file.canWrite()) {
            return;
        }
        file.setWritable(true);
    }

    public static void copyDirectory(File from, File to) throws IOException {
        Preconditions.checkArgument(from.isDirectory(), "Source path is not a directory.");
        Preconditions.checkArgument(!to.exists() || to.isDirectory(), "Destination path exists and is not a directory.");
        mkdirs(to);
        File[] fileArrListFiles = from.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isFile()) {
                    copyFileToDirectory(file, to);
                } else if (file.isDirectory()) {
                    copyDirectoryToDirectory(file, to);
                } else {
                    throw new IllegalArgumentException("Don't know how to copy file " + file.getAbsolutePath());
                }
            }
        }
    }

    public static void copyFileToDirectory(final File from, final File to) throws IOException {
        copyFile(from, new File(to, from.getName()));
    }

    public static void copyDirectoryToDirectory(final File from, final File to) throws IOException {
        copyDirectory(from, new File(to, from.getName()));
    }

    public static void copyDirectoryContentToDirectory(final File from, final File to) throws IOException {
        Preconditions.checkArgument(from.isDirectory(), "Source path is not a directory.");
        File[] fileArrListFiles = from.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    File file2 = new File(to, FilesKt.toRelativeString(file, from));
                    com.google.common.io.Files.createParentDirs(file2);
                    mkdirs(file2);
                    copyDirectoryContentToDirectory(file, file2);
                } else if (file.isFile()) {
                    File file3 = new File(to, FilesKt.toRelativeString(file.getParentFile(), from));
                    com.google.common.io.Files.createParentDirs(file3);
                    mkdirs(file3);
                    copyFileToDirectory(file, file3);
                }
            }
        }
    }

    public static File mkdirs(File folder) {
        if (folder.mkdirs() || folder.isDirectory()) {
            return folder;
        }
        throw new RuntimeException("Cannot create directory " + folder);
    }

    public static void delete(File file) throws IOException {
        Files.delete(file.toPath());
    }

    public static void deleteIfExists(File file) throws IOException {
        Files.deleteIfExists(file.toPath());
    }

    public static void deleteRecursivelyIfExists(File file) throws InterruptedException, IOException {
        PathUtils.deleteRecursivelyIfExists(file.toPath());
    }

    public static void renameTo(File file, File to) throws IOException {
        if (!file.renameTo(to)) {
            throw new IOException("Failed to rename " + file.getAbsolutePath() + " to " + to);
        }
    }

    public static File join(File dir, String... paths) {
        return paths.length == 0 ? dir : new File(dir, PATH_JOINER.join(paths));
    }

    public static File join(File dir, Iterable<String> paths) {
        return new File(dir, PATH_JOINER.join(removeEmpty(paths)));
    }

    public static String join(String... paths) {
        return PATH_JOINER.join(removeEmpty(Lists.newArrayList(paths)));
    }

    public static String join(Iterable<String> paths) {
        return PATH_JOINER.join(paths);
    }

    private static Iterable<String> removeEmpty(Iterable<String> input) {
        return (Iterable) Lists.newArrayList(input).stream().filter(new Predicate() { // from class: com.android.utils.FileUtils$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return FileUtils.lambda$removeEmpty$0((String) obj);
            }
        }).collect(Collectors.toList());
    }

    static /* synthetic */ boolean lambda$removeEmpty$0(String str) {
        return !str.isEmpty();
    }

    public static String loadFileWithUnixLineSeparators(File file) throws IOException {
        return UNIX_NEW_LINE_JOINER.join(com.google.common.io.Files.readLines(file, Charsets.UTF_8));
    }

    public static String toSystemDependentPath(String path) {
        return File.separatorChar != '/' ? path.replace('/', File.separatorChar) : path;
    }

    public static String escapeSystemDependentCharsIfNecessary(String path) {
        return File.separatorChar == '\\' ? path.replace("\\", "\\\\") : path;
    }

    public static String toSystemIndependentPath(String path) {
        return File.separatorChar != '/' ? path.replace(File.separatorChar, '/') : path;
    }

    public static String toExportableSystemDependentPath(File file) {
        if (File.separatorChar != '/' && !file.getAbsolutePath().startsWith("\\\\?\\")) {
            return "\\\\?\\" + file.getAbsolutePath();
        }
        return file.getAbsolutePath();
    }

    public static String sha1(File file) throws IOException {
        return Hashing.sha1().hashBytes(com.google.common.io.Files.toByteArray(file)).toString();
    }

    public static FluentIterable<File> getAllFiles(File dir) {
        return FluentIterable.from(com.google.common.io.Files.fileTraverser().depthFirstPreOrder((Traverser<File>) dir)).filter(com.google.common.io.Files.isFile());
    }

    public static String getNamesAsCommaSeparatedList(Iterable<File> files) {
        return COMMA_SEPARATED_JOINER.join(Iterables.transform(files, new Function() { // from class: com.android.utils.FileUtils$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ((File) obj).getName();
            }
        }));
    }

    public static String sanitizeFileName(String input) {
        return input.replaceAll("[:\\\\/*\"?|<>']", "_");
    }

    public static String getDirectoryNameForJar(File inputFile) {
        HashCode hashCodeHashString = Hashing.sha1().hashString(inputFile.getAbsolutePath(), Charsets.UTF_16LE);
        String nameWithoutExtension = com.google.common.io.Files.getNameWithoutExtension(inputFile.getName());
        if (nameWithoutExtension.equals(SdkConstants.FD_CLASSES_OUTPUT) && inputFile.getAbsolutePath().contains("exploded-aar")) {
            File parentFile = inputFile.getParentFile().getParentFile();
            File parentFile2 = parentFile.getParentFile();
            nameWithoutExtension = Joiner.on(SignatureVisitor.SUPER).join(parentFile2.getParentFile().getName(), parentFile2.getName(), parentFile.getName());
        }
        return nameWithoutExtension + "_" + hashCodeHashString.toString();
    }

    public static void createFile(File file, String content) throws IOException {
        Preconditions.checkArgument(!file.exists(), "%s exists already.", file);
        writeToFile(file, content);
    }

    public static void writeToFile(File file, String content) throws IOException {
        com.google.common.io.Files.createParentDirs(file);
        com.google.common.io.Files.asCharSink(file, StandardCharsets.UTF_8, new FileWriteMode[0]).write(content);
    }

    public static List<File> find(File base, final Pattern pattern) {
        Preconditions.checkArgument(base.isDirectory(), "'%s' must be a directory.", base.getAbsolutePath());
        return FluentIterable.from(com.google.common.io.Files.fileTraverser().depthFirstPreOrder((Traverser<File>) base)).filter(new com.google.common.base.Predicate() { // from class: com.android.utils.FileUtils$$ExternalSyntheticLambda3
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                return pattern.matcher(FileUtils.toSystemIndependentPath(((File) obj).getPath())).find();
            }
        }).toList();
    }

    public static Optional<File> find(File base, final String name) {
        Preconditions.checkArgument(base.isDirectory(), "'%s' must be a directory.", base.getAbsolutePath());
        return FluentIterable.from(com.google.common.io.Files.fileTraverser().depthFirstPreOrder((Traverser<File>) base)).filter(new com.google.common.base.Predicate() { // from class: com.android.utils.FileUtils$$ExternalSyntheticLambda2
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                return name.equals(((File) obj).getName());
            }
        }).last();
    }

    public static String joinFilePaths(Iterable<File> files) {
        return Joiner.on(File.pathSeparatorChar).join(Iterables.transform(files, new Function() { // from class: com.android.utils.FileUtils$$ExternalSyntheticLambda1
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ((File) obj).getAbsolutePath();
            }
        }));
    }

    public static boolean parentDirExists(File file) throws IOException {
        try {
            File canonicalFile = file.getCanonicalFile();
            return canonicalFile.getParentFile() != null && canonicalFile.getParentFile().exists();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static boolean isFileInDirectory(File fileOrDir, File baseDir) {
        try {
            String string = baseDir.toPath().relativize(fileOrDir.toPath()).toString();
            return (string.isEmpty() || string.startsWith("..")) ? false : true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean isSameFile(File file1, File file2) {
        try {
            if (file1.exists() && file2.exists()) {
                return Files.isSameFile(file1.toPath(), file2.toPath());
            }
            return file1.getCanonicalFile().equals(file2.getCanonicalFile());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static FileSystem createZipFilesystem(Path archive) throws IOException {
        return FileSystems.newFileSystem(URI.create("jar:" + archive.toUri().toString()), (Map<String, ?>) Collections.emptyMap());
    }
}
