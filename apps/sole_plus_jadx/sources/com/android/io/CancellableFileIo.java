package com.android.io;

import com.android.ProgressManagerAdapter;
import com.android.annotations.concurrency.Slow;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* loaded from: classes3.dex */
public class CancellableFileIo {
    @Slow
    public static boolean exists(Path file, LinkOption... options) {
        ProgressManagerAdapter.checkCanceled();
        return Files.exists(file, options);
    }

    @Slow
    public static boolean notExists(Path file, LinkOption... options) {
        ProgressManagerAdapter.checkCanceled();
        return Files.notExists(file, options);
    }

    @Slow
    public static boolean isDirectory(Path file, LinkOption... options) {
        ProgressManagerAdapter.checkCanceled();
        return Files.isDirectory(file, options);
    }

    @Slow
    public static boolean isRegularFile(Path file, LinkOption... options) {
        ProgressManagerAdapter.checkCanceled();
        return Files.isRegularFile(file, options);
    }

    @Slow
    public static boolean isSymbolicLink(Path file) {
        ProgressManagerAdapter.checkCanceled();
        return Files.isSymbolicLink(file);
    }

    @Slow
    public static boolean isReadable(Path file) {
        ProgressManagerAdapter.checkCanceled();
        return Files.isReadable(file);
    }

    @Slow
    public static boolean isWritable(Path file) {
        ProgressManagerAdapter.checkCanceled();
        return Files.isWritable(file);
    }

    @Slow
    public static boolean isExecutable(Path file) {
        ProgressManagerAdapter.checkCanceled();
        return Files.isExecutable(file);
    }

    @Slow
    public static boolean isHidden(Path file) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.isHidden(file);
    }

    @Slow
    public static boolean isSameFile(Path path1, Path path2) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.isSameFile(path1, path2);
    }

    @Slow
    public static long size(Path file) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.size(file);
    }

    @Slow
    public static FileTime getLastModifiedTime(Path file, LinkOption... options) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.getLastModifiedTime(file, options);
    }

    @Slow
    public static Object getAttribute(Path file, String attribute, LinkOption... options) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.getAttribute(file, attribute, options);
    }

    @Slow
    public static <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> cls, LinkOption... linkOptionArr) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return (A) Files.readAttributes(path, cls, linkOptionArr);
    }

    @Slow
    public static Stream<Path> list(Path dir) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.list(dir);
    }

    @Slow
    public static Stream<Path> walk(Path start, FileVisitOption... options) throws IOException {
        return walk(start, Integer.MAX_VALUE, options);
    }

    @Slow
    public static Stream<Path> walk(Path start, int maxDepth, FileVisitOption... options) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.walk(start, maxDepth, options).filter(new Predicate() { // from class: com.android.io.CancellableFileIo$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CancellableFileIo.lambda$walk$0((Path) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$walk$0(Path path) {
        ProgressManagerAdapter.checkCanceled();
        return true;
    }

    @Slow
    public static Path walkFileTree(Path start, Set<FileVisitOption> options, int maxDepth, final FileVisitor<? super Path> visitor) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.walkFileTree(start, options, maxDepth, new FileVisitor<Path>() { // from class: com.android.io.CancellableFileIo.1
            @Override // java.nio.file.FileVisitor
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                ProgressManagerAdapter.checkCanceled();
                return visitor.preVisitDirectory(dir, attrs);
            }

            @Override // java.nio.file.FileVisitor
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                return visitor.visitFile(file, attrs);
            }

            @Override // java.nio.file.FileVisitor
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return visitor.visitFileFailed(file, exc);
            }

            @Override // java.nio.file.FileVisitor
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return visitor.postVisitDirectory(dir, exc);
            }
        });
    }

    @Slow
    public static Path walkFileTree(Path start, FileVisitor<? super Path> visitor) throws IOException {
        return walkFileTree(start, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, visitor);
    }

    @Slow
    public static InputStream newInputStream(Path file, OpenOption... options) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.newInputStream(file, options);
    }

    @Slow
    public static BufferedReader newBufferedReader(Path file) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.newBufferedReader(file);
    }

    @Slow
    public static SeekableByteChannel newByteChannel(Path file, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.newByteChannel(file, options, attrs);
    }

    @Slow
    public static SeekableByteChannel newByteChannel(Path file, OpenOption... options) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.newByteChannel(file, options);
    }

    @Slow
    public static byte[] readAllBytes(Path file) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.readAllBytes(file);
    }

    @Slow
    public static List<String> readAllLines(Path file) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.readAllLines(file, StandardCharsets.UTF_8);
    }

    @Slow
    public static List<String> readAllLines(Path file, Charset cs) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.readAllLines(file, cs);
    }

    @Slow
    public static String readString(Path file) throws IOException {
        return new String(readAllBytes(file), StandardCharsets.UTF_8);
    }

    @Slow
    public static Path readSymbolicLink(Path link) throws IOException {
        ProgressManagerAdapter.checkCanceled();
        return Files.readSymbolicLink(link);
    }
}
