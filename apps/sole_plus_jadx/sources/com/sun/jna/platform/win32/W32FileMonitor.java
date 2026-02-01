package com.sun.jna.platform.win32;

import com.sun.jna.platform.FileMonitor;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public class W32FileMonitor extends FileMonitor {
    private static final int BUFFER_SIZE = 4096;
    private static final Logger LOG = Logger.getLogger(W32FileMonitor.class.getName());
    private static int watcherThreadID;
    private WinNT.HANDLE port;
    private Thread watcher;
    private final Map<File, FileInfo> fileMap = new HashMap();
    private final Map<WinNT.HANDLE, FileInfo> handleMap = new HashMap();
    private boolean disposing = false;

    private int convertMask(int i) {
        int i2 = (i & 1) != 0 ? 64 : 0;
        if ((i & 2) != 0) {
            i2 |= 3;
        }
        if ((i & 4) != 0) {
            i2 |= 16;
        }
        if ((i & 48) != 0) {
            i2 |= 3;
        }
        if ((i & 64) != 0) {
            i2 |= 8;
        }
        if ((i & 8) != 0) {
            i2 |= 32;
        }
        if ((i & 128) != 0) {
            i2 |= 4;
        }
        return (i & 256) != 0 ? i2 | 256 : i2;
    }

    private class FileInfo {
        public final File file;
        public final WinNT.HANDLE handle;
        public final int notifyMask;
        public final boolean recursive;
        public final WinNT.FILE_NOTIFY_INFORMATION info = new WinNT.FILE_NOTIFY_INFORMATION(4096);
        public final IntByReference infoLength = new IntByReference();
        public final WinBase.OVERLAPPED overlapped = new WinBase.OVERLAPPED();

        public FileInfo(File file, WinNT.HANDLE handle, int i, boolean z) {
            this.file = file;
            this.handle = handle;
            this.notifyMask = i;
            this.recursive = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChanges(FileInfo fileInfo) throws IOException {
        FileMonitor.FileEvent fileEvent;
        Kernel32 kernel32 = Kernel32.INSTANCE;
        WinNT.FILE_NOTIFY_INFORMATION next = fileInfo.info;
        next.read();
        do {
            File file = new File(fileInfo.file, next.getFilename());
            int i = next.Action;
            if (i == 0) {
                fileEvent = null;
            } else if (i == 1) {
                fileEvent = new FileMonitor.FileEvent(file, 1);
            } else if (i == 2) {
                fileEvent = new FileMonitor.FileEvent(file, 2);
            } else if (i == 3) {
                fileEvent = new FileMonitor.FileEvent(file, 4);
            } else if (i == 4) {
                fileEvent = new FileMonitor.FileEvent(file, 16);
            } else if (i == 5) {
                fileEvent = new FileMonitor.FileEvent(file, 32);
            } else {
                LOG.log(Level.WARNING, "Unrecognized file action ''{0}''", Integer.valueOf(next.Action));
                fileEvent = null;
            }
            if (fileEvent != null) {
                notify(fileEvent);
            }
            next = next.next();
        } while (next != null);
        if (!fileInfo.file.exists()) {
            unwatch(fileInfo.file);
        } else {
            if (kernel32.ReadDirectoryChangesW(fileInfo.handle, fileInfo.info, fileInfo.info.size(), fileInfo.recursive, fileInfo.notifyMask, fileInfo.infoLength, fileInfo.overlapped, null) || this.disposing) {
                return;
            }
            int iGetLastError = kernel32.GetLastError();
            throw new IOException("ReadDirectoryChangesW failed on " + fileInfo.file + ": '" + Kernel32Util.formatMessageFromLastErrorCode(iGetLastError) + "' (" + iGetLastError + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileInfo waitForChange() {
        FileInfo fileInfo;
        IntByReference intByReference = new IntByReference();
        BaseTSD.ULONG_PTRByReference uLONG_PTRByReference = new BaseTSD.ULONG_PTRByReference();
        if (!Kernel32.INSTANCE.GetQueuedCompletionStatus(this.port, intByReference, uLONG_PTRByReference, new PointerByReference(), -1)) {
            return null;
        }
        synchronized (this) {
            fileInfo = this.handleMap.get(new WinNT.HANDLE(uLONG_PTRByReference.getValue().toPointer()));
        }
        return fileInfo;
    }

    @Override // com.sun.jna.platform.FileMonitor
    protected synchronized void watch(File file, int i, boolean z) throws IOException {
        boolean z2;
        File parentFile;
        if (file.isDirectory()) {
            z2 = z;
            parentFile = file;
        } else {
            parentFile = file.getParentFile();
            z2 = false;
        }
        while (parentFile != null && !parentFile.exists()) {
            parentFile = parentFile.getParentFile();
            z2 = true;
        }
        if (parentFile == null) {
            throw new FileNotFoundException("No ancestor found for " + file);
        }
        Kernel32 kernel32 = Kernel32.INSTANCE;
        WinNT.HANDLE handleCreateFile = kernel32.CreateFile(file.getAbsolutePath(), 1, 7, null, 3, 1107296256, null);
        if (WinBase.INVALID_HANDLE_VALUE.equals(handleCreateFile)) {
            throw new IOException("Unable to open " + file + " (" + kernel32.GetLastError() + ")");
        }
        int iConvertMask = convertMask(i);
        FileInfo fileInfo = new FileInfo(file, handleCreateFile, iConvertMask, z2);
        this.fileMap.put(file, fileInfo);
        this.handleMap.put(handleCreateFile, fileInfo);
        this.port = kernel32.CreateIoCompletionPort(handleCreateFile, this.port, handleCreateFile.getPointer(), 0);
        if (WinBase.INVALID_HANDLE_VALUE.equals(this.port)) {
            throw new IOException("Unable to create/use I/O Completion port for " + file + " (" + kernel32.GetLastError() + ")");
        }
        if (!kernel32.ReadDirectoryChangesW(handleCreateFile, fileInfo.info, fileInfo.info.size(), z2, iConvertMask, fileInfo.infoLength, fileInfo.overlapped, null)) {
            int iGetLastError = kernel32.GetLastError();
            throw new IOException("ReadDirectoryChangesW failed on " + fileInfo.file + ", handle " + handleCreateFile + ": '" + Kernel32Util.formatMessageFromLastErrorCode(iGetLastError) + "' (" + iGetLastError + ")");
        }
        if (this.watcher == null) {
            StringBuilder sbAppend = new StringBuilder().append("W32 File Monitor-");
            int i2 = watcherThreadID;
            watcherThreadID = i2 + 1;
            Thread thread = new Thread(sbAppend.append(i2).toString()) { // from class: com.sun.jna.platform.win32.W32FileMonitor.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        FileInfo fileInfoWaitForChange = W32FileMonitor.this.waitForChange();
                        if (fileInfoWaitForChange != null) {
                            try {
                                W32FileMonitor.this.handleChanges(fileInfoWaitForChange);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            synchronized (W32FileMonitor.this) {
                                if (W32FileMonitor.this.fileMap.isEmpty()) {
                                    W32FileMonitor.this.watcher = null;
                                    return;
                                }
                            }
                        }
                    }
                }
            };
            this.watcher = thread;
            thread.setDaemon(true);
            this.watcher.start();
        }
    }

    @Override // com.sun.jna.platform.FileMonitor
    protected synchronized void unwatch(File file) {
        FileInfo fileInfoRemove = this.fileMap.remove(file);
        if (fileInfoRemove != null) {
            this.handleMap.remove(fileInfoRemove.handle);
            Kernel32.INSTANCE.CloseHandle(fileInfoRemove.handle);
        }
    }

    @Override // com.sun.jna.platform.FileMonitor
    public synchronized void dispose() {
        this.disposing = true;
        Object[] array = this.fileMap.keySet().toArray();
        int i = 0;
        while (!this.fileMap.isEmpty()) {
            unwatch((File) array[i]);
            i++;
        }
        Kernel32 kernel32 = Kernel32.INSTANCE;
        kernel32.PostQueuedCompletionStatus(this.port, 0, null, null);
        kernel32.CloseHandle(this.port);
        this.port = null;
        this.watcher = null;
    }
}
