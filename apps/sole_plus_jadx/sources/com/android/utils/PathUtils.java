package com.android.utils;

import com.android.SdkConstants;
import com.android.io.CancellableFileIo;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/* loaded from: classes3.dex */
public final class PathUtils {
    private static final int EMPTY_DIRECTORY_DELETION_ATTEMPTS = 10;

    private PathUtils() {
    }

    public static void deleteRecursivelyIfExists(Path path) throws InterruptedException, IOException {
        if (Files.isDirectory(path, new LinkOption[0]) && !Files.isSymbolicLink(path)) {
            Stream<Path> list = Files.list(path);
            try {
                Iterator<Path> it = list.iterator();
                while (it.hasNext()) {
                    deleteRecursivelyIfExists(it.next());
                }
                if (list != null) {
                    list.close();
                }
            } catch (Throwable th) {
                if (list != null) {
                    try {
                        list.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        int i = 1;
        try {
            try {
                Files.deleteIfExists(path);
            } catch (DirectoryNotEmptyException e) {
                while (i < 10) {
                    try {
                        Thread.sleep(1L);
                        try {
                            Files.deleteIfExists(path);
                            break;
                        } catch (DirectoryNotEmptyException unused) {
                            i++;
                        }
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        throw new IOException(e2);
                    }
                }
                if (i >= 10) {
                    throw new RuntimeException(String.format("Unable to delete directory '%s' after %d attempts", path, Integer.valueOf(i)), e);
                }
            }
        } catch (AccessDeniedException unused2) {
            path.toFile().setWritable(true);
            Files.deleteIfExists(path);
        }
    }

    public static String toSystemIndependentPath(Path path) {
        String string = path.toString();
        return !path.getFileSystem().getSeparator().equals("/") ? string.replace(path.getFileSystem().getSeparator(), "/") : string;
    }

    public static Path createTmpToRemoveOnShutdown(String prefix) throws IOException {
        Path pathCreateTempFile = Files.createTempFile(prefix, "", new FileAttribute[0]);
        addRemovePathHook(pathCreateTempFile);
        return pathCreateTempFile;
    }

    public static Path createTmpDirToRemoveOnShutdown(String prefix) throws IOException {
        Path pathCreateTempDirectory = Files.createTempDirectory(prefix, new FileAttribute[0]);
        addRemovePathHook(pathCreateTempDirectory);
        return pathCreateTempDirectory;
    }

    public static List<Path> getClassPathItems(String classPath) throws IOException {
        Iterable<String> iterableSplit = Splitter.on(File.pathSeparator).split(classPath);
        final ArrayList arrayListNewArrayList = Lists.newArrayList();
        final PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(String.format("glob:**{%s,%s}", SdkConstants.EXT_ZIP, SdkConstants.EXT_JAR));
        Iterator<String> it = iterableSplit.iterator();
        while (it.hasNext()) {
            Path path = Paths.get(it.next(), new String[0]);
            if (Files.isRegularFile(path, new LinkOption[0])) {
                arrayListNewArrayList.add(path);
            } else {
                try {
                    Stream<Path> streamWalk = Files.walk(path, new FileVisitOption[0]);
                    try {
                        Objects.requireNonNull(pathMatcher);
                        Stream<Path> streamFilter = streamWalk.filter(new Predicate() { // from class: com.android.utils.PathUtils$$ExternalSyntheticLambda0
                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj) {
                                return pathMatcher.matches((Path) obj);
                            }
                        });
                        Objects.requireNonNull(arrayListNewArrayList);
                        streamFilter.forEach(new Consumer() { // from class: com.android.utils.PathUtils$$ExternalSyntheticLambda1
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                arrayListNewArrayList.add((Path) obj);
                            }
                        });
                        if (streamWalk != null) {
                            streamWalk.close();
                        }
                    } catch (Throwable th) {
                        if (streamWalk != null) {
                            try {
                                streamWalk.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused) {
                    continue;
                }
            }
        }
        return arrayListNewArrayList;
    }

    public static void addRemovePathHook(final Path path) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() { // from class: com.android.utils.PathUtils$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                PathUtils.lambda$addRemovePathHook$0(path);
            }
        }));
    }

    static /* synthetic */ void lambda$addRemovePathHook$0(Path path) throws InterruptedException {
        try {
            deleteRecursivelyIfExists(path);
        } catch (IOException e) {
            Logger.getLogger(PathUtils.class.getName()).log(Level.WARNING, "Unable to delete " + path, (Throwable) e);
        }
    }

    public static Path createDirectories(Path path) throws IOException {
        if (CancellableFileIo.exists(path, new LinkOption[0])) {
            path = path.toRealPath(new LinkOption[0]);
        }
        return Files.createDirectories(path, new FileAttribute[0]);
    }
}
