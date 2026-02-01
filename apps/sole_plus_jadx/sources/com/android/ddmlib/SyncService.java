package com.android.ddmlib;

import com.android.ddmlib.AdbHelper;
import com.android.ddmlib.FileListingService;
import com.android.ddmlib.SyncException;
import com.android.ddmlib.utils.ArrayHelper;
import com.android.ddmlib.utils.FilePermissionUtil;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes3.dex */
public class SyncService implements AutoCloseable {
    private static final int REMOTE_PATH_MAX_LENGTH = 1024;
    private static final int SYNC_DATA_MAX = 65536;
    private static final int S_IFBLK = 24576;
    private static final int S_IFCHR = 8192;
    private static final int S_IFDIR = 16384;
    private static final int S_IFIFO = 4096;
    private static final int S_IFLNK = 40960;
    private static final int S_IFREG = 32768;
    private static final int S_ISOCK = 49152;
    private InetSocketAddress mAddress;
    private byte[] mBuffer;
    private SocketChannel mChannel;
    private IDevice mDevice;
    private static final byte[] ID_OKAY = {79, 75, 65, 89};
    private static final byte[] ID_FAIL = {70, 65, 73, 76};
    private static final byte[] ID_STAT = {83, 84, 65, 84};
    private static final byte[] ID_RECV = {82, 69, 67, 86};
    private static final byte[] ID_DATA = {68, 65, 84, 65};
    private static final byte[] ID_DONE = {68, 79, 78, 69};
    private static final byte[] ID_SEND = {83, 69, 78, 68};
    private static final NullSyncProgressMonitor sNullSyncProgressMonitor = new NullSyncProgressMonitor();

    public interface ISyncProgressMonitor {
        void advance(int work);

        boolean isCanceled();

        void start(int totalWork);

        void startSubTask(String name);

        void stop();
    }

    private static int getFileType(int mode) {
        if ((mode & S_ISOCK) == S_ISOCK) {
            return 6;
        }
        if ((mode & S_IFLNK) == S_IFLNK) {
            return 5;
        }
        if ((mode & 32768) == 32768) {
            return 0;
        }
        if ((mode & S_IFBLK) == S_IFBLK) {
            return 3;
        }
        if ((mode & 16384) == 16384) {
            return 1;
        }
        if ((mode & 8192) == 8192) {
            return 4;
        }
        return (mode & 4096) == 4096 ? 7 : 8;
    }

    public static class FileStat {
        private final Date myLastModified;
        private final int myMode;
        private final int mySize;

        public FileStat(int mode, int size, int lastModifiedSecs) {
            this.myMode = mode;
            this.mySize = size;
            this.myLastModified = new Date(lastModifiedSecs * 1000);
        }

        public int getMode() {
            return this.myMode;
        }

        public int getSize() {
            return this.mySize;
        }

        public Date getLastModified() {
            return this.myLastModified;
        }
    }

    private static class NullSyncProgressMonitor implements ISyncProgressMonitor {
        @Override // com.android.ddmlib.SyncService.ISyncProgressMonitor
        public void advance(int work) {
        }

        @Override // com.android.ddmlib.SyncService.ISyncProgressMonitor
        public boolean isCanceled() {
            return false;
        }

        @Override // com.android.ddmlib.SyncService.ISyncProgressMonitor
        public void start(int totalWork) {
        }

        @Override // com.android.ddmlib.SyncService.ISyncProgressMonitor
        public void startSubTask(String name) {
        }

        @Override // com.android.ddmlib.SyncService.ISyncProgressMonitor
        public void stop() {
        }

        private NullSyncProgressMonitor() {
        }
    }

    public SyncService(InetSocketAddress address, IDevice device) {
        this.mAddress = address;
        this.mDevice = device;
    }

    public boolean openSync() throws IOException, TimeoutException, AdbCommandRejectedException {
        try {
            SocketChannel socketChannelOpen = SocketChannel.open(this.mAddress);
            this.mChannel = socketChannelOpen;
            socketChannelOpen.configureBlocking(false);
            AdbHelper.setDevice(this.mChannel, this.mDevice);
            AdbHelper.write(this.mChannel, AdbHelper.formAdbRequest("sync:"), -1, DdmPreferences.getTimeOut());
            AdbHelper.AdbResponse adbResponse = AdbHelper.readAdbResponse(this.mChannel, false);
            if (adbResponse.okay) {
                return true;
            }
            Log.w("ddms", "Got unhappy response from ADB sync req: " + adbResponse.message);
            this.mChannel.close();
            this.mChannel = null;
            return false;
        } catch (TimeoutException e) {
            SocketChannel socketChannel = this.mChannel;
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException unused) {
                }
                this.mChannel = null;
            }
            throw e;
        } catch (IOException e2) {
            SocketChannel socketChannel2 = this.mChannel;
            if (socketChannel2 != null) {
                try {
                    socketChannel2.close();
                } catch (IOException unused2) {
                }
                this.mChannel = null;
            }
            throw e2;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        SocketChannel socketChannel = this.mChannel;
        if (socketChannel != null) {
            try {
                socketChannel.close();
            } catch (IOException unused) {
            }
            this.mChannel = null;
        }
    }

    public static ISyncProgressMonitor getNullProgressMonitor() {
        return sNullSyncProgressMonitor;
    }

    public void pull(FileListingService.FileEntry[] entries, String localPath, ISyncProgressMonitor monitor) throws Throwable {
        File file = new File(localPath);
        if (!file.exists()) {
            throw new SyncException(SyncException.SyncError.NO_DIR_TARGET);
        }
        if (!file.isDirectory()) {
            throw new SyncException(SyncException.SyncError.TARGET_IS_FILE);
        }
        FileListingService fileListingService = new FileListingService(this.mDevice);
        monitor.start(getTotalRemoteFileSize(entries, fileListingService));
        doPull(entries, localPath, fileListingService, monitor);
        monitor.stop();
    }

    public void pullFile(FileListingService.FileEntry remote, String localFilename, ISyncProgressMonitor monitor) throws Throwable {
        monitor.start(remote.getSizeValue());
        doPullFile(remote.getFullPath(), localFilename, monitor);
        monitor.stop();
    }

    public void pullFile(String remoteFilepath, String localFilename, ISyncProgressMonitor monitor) throws Throwable {
        FileStat fileStatStatFile = statFile(remoteFilepath);
        if (fileStatStatFile != null && fileStatStatFile.getMode() == 0) {
            throw new SyncException(SyncException.SyncError.NO_REMOTE_OBJECT);
        }
        monitor.start(0);
        doPullFile(remoteFilepath, localFilename, monitor);
        if (fileStatStatFile != null) {
            FileTime fileTimeFromMillis = FileTime.fromMillis(fileStatStatFile.getLastModified().getTime());
            Path path = Paths.get(localFilename, new String[0]);
            Files.setAttribute(path, "lastAccessTime", fileTimeFromMillis, new LinkOption[0]);
            Files.setAttribute(path, "lastModifiedTime", fileTimeFromMillis, new LinkOption[0]);
        }
        monitor.stop();
    }

    public void push(String[] local, FileListingService.FileEntry remote, ISyncProgressMonitor monitor) throws Throwable {
        if (!remote.isDirectory()) {
            throw new SyncException(SyncException.SyncError.REMOTE_IS_FILE);
        }
        push(local, remote.getFullPath(), monitor);
    }

    public void push(String[] local, String remote, ISyncProgressMonitor monitor) throws Throwable {
        ArrayList arrayList = new ArrayList();
        for (String str : local) {
            arrayList.add(new File(str));
        }
        File[] fileArr = (File[]) arrayList.toArray(new File[0]);
        monitor.start(getTotalLocalFileSize(fileArr));
        doPush(fileArr, remote, monitor);
        monitor.stop();
    }

    public void pushFile(String local, String remote, ISyncProgressMonitor monitor) throws Throwable {
        File file = new File(local);
        if (!file.exists()) {
            throw new SyncException(SyncException.SyncError.NO_LOCAL_FILE);
        }
        if (file.isDirectory()) {
            throw new SyncException(SyncException.SyncError.LOCAL_IS_DIRECTORY);
        }
        monitor.start((int) file.length());
        doPushFile(local, remote, monitor);
        monitor.stop();
    }

    private int getTotalRemoteFileSize(FileListingService.FileEntry[] entries, FileListingService fls) {
        int sizeValue;
        int i = 0;
        for (FileListingService.FileEntry fileEntry : entries) {
            int type = fileEntry.getType();
            if (type == 1) {
                sizeValue = getTotalRemoteFileSize(fls.getChildren(fileEntry, false, null), fls) + 1;
            } else if (type == 0) {
                sizeValue = fileEntry.getSizeValue();
            }
            i += sizeValue;
        }
        return i;
    }

    private int getTotalLocalFileSize(File[] files) {
        int length = 0;
        for (File file : files) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return getTotalLocalFileSize(file.listFiles()) + 1;
                }
                if (file.isFile()) {
                    length = (int) (length + file.length());
                }
            }
        }
        return length;
    }

    private void doPull(FileListingService.FileEntry[] entries, String localPath, FileListingService fileListingService, ISyncProgressMonitor monitor) throws Throwable {
        for (FileListingService.FileEntry fileEntry : entries) {
            if (monitor.isCanceled()) {
                throw new SyncException(SyncException.SyncError.CANCELED);
            }
            int type = fileEntry.getType();
            if (type == 1) {
                monitor.startSubTask(fileEntry.getFullPath());
                String str = localPath + File.separator + fileEntry.getName();
                new File(str).mkdir();
                doPull(fileListingService.getChildren(fileEntry, true, null), str, fileListingService, monitor);
                monitor.advance(1);
            } else if (type == 0) {
                monitor.startSubTask(fileEntry.getFullPath());
                doPullFile(fileEntry.getFullPath(), localPath + File.separator + fileEntry.getName(), monitor);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void doPullFile(java.lang.String r10, java.lang.String r11, com.android.ddmlib.SyncService.ISyncProgressMonitor r12) throws java.lang.Throwable {
        /*
            r9 = this;
            r0 = 8
            byte[] r0 = new byte[r0]
            int r1 = com.android.ddmlib.DdmPreferences.getTimeOut()
            java.nio.charset.Charset r2 = com.android.ddmlib.AdbHelper.DEFAULT_CHARSET
            byte[] r10 = r10.getBytes(r2)
            int r2 = r10.length
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 > r3) goto Ld1
            byte[] r2 = com.android.ddmlib.SyncService.ID_RECV
            byte[] r10 = createFileReq(r2, r10)
            java.nio.channels.SocketChannel r2 = r9.mChannel
            r3 = -1
            com.android.ddmlib.AdbHelper.write(r2, r10, r3, r1)
            java.nio.channels.SocketChannel r10 = r9.mChannel
            long r4 = (long) r1
            com.android.ddmlib.AdbHelper.read(r10, r0, r3, r4)
            byte[] r10 = com.android.ddmlib.SyncService.ID_DATA
            boolean r10 = checkResult(r0, r10)
            if (r10 != 0) goto L42
            byte[] r10 = com.android.ddmlib.SyncService.ID_DONE
            boolean r10 = checkResult(r0, r10)
            if (r10 == 0) goto L36
            goto L42
        L36:
            com.android.ddmlib.SyncException r10 = new com.android.ddmlib.SyncException
            com.android.ddmlib.SyncException$SyncError r11 = com.android.ddmlib.SyncException.SyncError.TRANSFER_PROTOCOL_ERROR
            java.lang.String r12 = r9.readErrorMessage(r0, r1)
            r10.<init>(r11, r12)
            throw r10
        L42:
            java.io.File r10 = new java.io.File
            r10.<init>(r11)
            r11 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> La5 java.io.IOException -> La7
            r2.<init>(r10)     // Catch: java.lang.Throwable -> La5 java.io.IOException -> La7
            r11 = 65536(0x10000, float:9.1835E-41)
            byte[] r6 = new byte[r11]     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
        L51:
            boolean r7 = r12.isCanceled()     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            if (r7 != 0) goto L9b
            byte[] r7 = com.android.ddmlib.SyncService.ID_DONE     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            boolean r7 = checkResult(r0, r7)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            if (r7 == 0) goto L66
            r2.flush()     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            r2.close()
            return
        L66:
            byte[] r7 = com.android.ddmlib.SyncService.ID_DATA     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            boolean r7 = checkResult(r0, r7)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            if (r7 == 0) goto L8f
            r7 = 4
            int r7 = com.android.ddmlib.utils.ArrayHelper.swap32bitFromArray(r0, r7)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            if (r7 > r11) goto L87
            java.nio.channels.SocketChannel r8 = r9.mChannel     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            com.android.ddmlib.AdbHelper.read(r8, r6, r7, r4)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            java.nio.channels.SocketChannel r8 = r9.mChannel     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            com.android.ddmlib.AdbHelper.read(r8, r0, r3, r4)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            r8 = 0
            r2.write(r6, r8, r7)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            r12.advance(r7)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            goto L51
        L87:
            com.android.ddmlib.SyncException r11 = new com.android.ddmlib.SyncException     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            com.android.ddmlib.SyncException$SyncError r12 = com.android.ddmlib.SyncException.SyncError.BUFFER_OVERRUN     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            r11.<init>(r12)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            throw r11     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
        L8f:
            com.android.ddmlib.SyncException r11 = new com.android.ddmlib.SyncException     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            com.android.ddmlib.SyncException$SyncError r12 = com.android.ddmlib.SyncException.SyncError.TRANSFER_PROTOCOL_ERROR     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            java.lang.String r0 = r9.readErrorMessage(r0, r1)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            r11.<init>(r12, r0)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            throw r11     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
        L9b:
            com.android.ddmlib.SyncException r11 = new com.android.ddmlib.SyncException     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            com.android.ddmlib.SyncException$SyncError r12 = com.android.ddmlib.SyncException.SyncError.CANCELED     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            r11.<init>(r12)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
            throw r11     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc9
        La3:
            r11 = move-exception
            goto Laa
        La5:
            r10 = move-exception
            goto Lcb
        La7:
            r12 = move-exception
            r2 = r11
            r11 = r12
        Laa:
            java.lang.String r12 = "ddms"
            java.lang.String r0 = "Failed to open local file %s for writing, Reason: %s"
            java.lang.String r10 = r10.getAbsolutePath()     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> Lc9
            java.lang.Object[] r10 = new java.lang.Object[]{r10, r11}     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r10 = java.lang.String.format(r0, r10)     // Catch: java.lang.Throwable -> Lc9
            com.android.ddmlib.Log.e(r12, r10)     // Catch: java.lang.Throwable -> Lc9
            com.android.ddmlib.SyncException r10 = new com.android.ddmlib.SyncException     // Catch: java.lang.Throwable -> Lc9
            com.android.ddmlib.SyncException$SyncError r11 = com.android.ddmlib.SyncException.SyncError.FILE_WRITE_ERROR     // Catch: java.lang.Throwable -> Lc9
            r10.<init>(r11)     // Catch: java.lang.Throwable -> Lc9
            throw r10     // Catch: java.lang.Throwable -> Lc9
        Lc9:
            r10 = move-exception
            r11 = r2
        Lcb:
            if (r11 == 0) goto Ld0
            r11.close()
        Ld0:
            throw r10
        Ld1:
            com.android.ddmlib.SyncException r10 = new com.android.ddmlib.SyncException
            com.android.ddmlib.SyncException$SyncError r11 = com.android.ddmlib.SyncException.SyncError.REMOTE_PATH_LENGTH
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ddmlib.SyncService.doPullFile(java.lang.String, java.lang.String, com.android.ddmlib.SyncService$ISyncProgressMonitor):void");
    }

    private void doPush(File[] fileArray, String remotePath, ISyncProgressMonitor monitor) throws Throwable {
        for (File file : fileArray) {
            if (monitor.isCanceled()) {
                throw new SyncException(SyncException.SyncError.CANCELED);
            }
            if (file.exists()) {
                if (file.isDirectory()) {
                    String str = remotePath + "/" + file.getName();
                    monitor.startSubTask(str);
                    doPush(file.listFiles(), str, monitor);
                    monitor.advance(1);
                } else if (file.isFile()) {
                    String str2 = remotePath + "/" + file.getName();
                    monitor.startSubTask(str2);
                    doPushFile(file.getAbsolutePath(), str2, monitor);
                }
            }
        }
    }

    private void doPushFile(String localPath, String remotePath, ISyncProgressMonitor monitor) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        int timeOut = DdmPreferences.getTimeOut();
        File file = new File(localPath);
        try {
            byte[] bytes = remotePath.getBytes(AdbHelper.DEFAULT_CHARSET);
            if (bytes.length > 1024) {
                throw new SyncException(SyncException.SyncError.REMOTE_PATH_LENGTH);
            }
            fileInputStream = new FileInputStream(file);
            try {
                AdbHelper.write(this.mChannel, createSendFileReq(ID_SEND, bytes, FilePermissionUtil.getFilePosixPermission(file)), -1, timeOut);
                byte[] bArr = ID_DATA;
                System.arraycopy(bArr, 0, getBuffer(), 0, bArr.length);
                while (!monitor.isCanceled()) {
                    int i = fileInputStream.read(getBuffer(), 8, 65536);
                    if (i != -1) {
                        ArrayHelper.swap32bitsToArray(i, getBuffer(), 4);
                        AdbHelper.write(this.mChannel, getBuffer(), i + 8, timeOut);
                        monitor.advance(i);
                    } else {
                        fileInputStream.close();
                        AdbHelper.write(this.mChannel, createReq(ID_DONE, (int) (file.lastModified() / 1000)), -1, timeOut);
                        byte[] bArr2 = new byte[8];
                        AdbHelper.read(this.mChannel, bArr2, -1, timeOut);
                        if (!checkResult(bArr2, ID_OKAY)) {
                            throw new SyncException(SyncException.SyncError.TRANSFER_PROTOCOL_ERROR, readErrorMessage(bArr2, timeOut));
                        }
                        return;
                    }
                }
                throw new SyncException(SyncException.SyncError.CANCELED);
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    private String readErrorMessage(byte[] result, final int timeOut) throws IOException, TimeoutException {
        int iSwap32bitFromArray;
        if (!checkResult(result, ID_FAIL) || (iSwap32bitFromArray = ArrayHelper.swap32bitFromArray(result, 4)) <= 0) {
            return null;
        }
        AdbHelper.read(this.mChannel, getBuffer(), iSwap32bitFromArray, timeOut);
        String str = new String(getBuffer(), 0, iSwap32bitFromArray);
        Log.e("ddms", "transfer error: ".concat(str));
        return str;
    }

    public FileStat statFile(String path) throws IOException, TimeoutException {
        byte[] bArr = ID_STAT;
        AdbHelper.write(this.mChannel, createFileReq(bArr, path), -1, DdmPreferences.getTimeOut());
        byte[] bArr2 = new byte[16];
        AdbHelper.read(this.mChannel, bArr2, -1, DdmPreferences.getTimeOut());
        if (checkResult(bArr2, bArr)) {
            return new FileStat(ArrayHelper.swap32bitFromArray(bArr2, 4), ArrayHelper.swap32bitFromArray(bArr2, 8), ArrayHelper.swap32bitFromArray(bArr2, 12));
        }
        return null;
    }

    private static byte[] createReq(byte[] command, int value) {
        byte[] bArr = new byte[8];
        System.arraycopy(command, 0, bArr, 0, 4);
        ArrayHelper.swap32bitsToArray(value, bArr, 4);
        return bArr;
    }

    private static byte[] createFileReq(byte[] command, String path) {
        return createFileReq(command, path.getBytes(AdbHelper.DEFAULT_CHARSET));
    }

    private static byte[] createFileReq(byte[] command, byte[] path) {
        byte[] bArr = new byte[path.length + 8];
        System.arraycopy(command, 0, bArr, 0, 4);
        ArrayHelper.swap32bitsToArray(path.length, bArr, 4);
        System.arraycopy(path, 0, bArr, 8, path.length);
        return bArr;
    }

    private static byte[] createSendFileReq(byte[] command, byte[] path, int mode) {
        byte[] bytes = ("," + (mode & 511)).getBytes(AdbHelper.DEFAULT_CHARSET);
        byte[] bArr = new byte[path.length + 8 + bytes.length];
        System.arraycopy(command, 0, bArr, 0, 4);
        ArrayHelper.swap32bitsToArray(path.length + bytes.length, bArr, 4);
        System.arraycopy(path, 0, bArr, 8, path.length);
        System.arraycopy(bytes, 0, bArr, path.length + 8, bytes.length);
        return bArr;
    }

    private static boolean checkResult(byte[] result, byte[] code) {
        return result[0] == code[0] && result[1] == code[1] && result[2] == code[2] && result[3] == code[3];
    }

    private byte[] getBuffer() {
        if (this.mBuffer == null) {
            this.mBuffer = new byte[NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST];
        }
        return this.mBuffer;
    }
}
