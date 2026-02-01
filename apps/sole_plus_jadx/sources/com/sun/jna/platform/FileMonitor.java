package com.sun.jna.platform;

import com.sun.jna.platform.win32.W32FileMonitor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class FileMonitor {
    public static final int FILE_ACCESSED = 8;
    public static final int FILE_ANY = 511;
    public static final int FILE_ATTRIBUTES_CHANGED = 128;
    public static final int FILE_CREATED = 1;
    public static final int FILE_DELETED = 2;
    public static final int FILE_MODIFIED = 4;
    public static final int FILE_NAME_CHANGED_NEW = 32;
    public static final int FILE_NAME_CHANGED_OLD = 16;
    public static final int FILE_RENAMED = 48;
    public static final int FILE_SECURITY_CHANGED = 256;
    public static final int FILE_SIZE_CHANGED = 64;
    private final Map<File, Integer> watched = new HashMap();
    private List<FileListener> listeners = new ArrayList();

    public interface FileListener {
        void fileChanged(FileEvent fileEvent);
    }

    public abstract void dispose();

    protected abstract void unwatch(File file);

    protected abstract void watch(File file, int i, boolean z) throws IOException;

    public class FileEvent extends EventObject {
        private final File file;
        private final int type;

        public FileEvent(File file, int i) {
            super(FileMonitor.this);
            this.file = file;
            this.type = i;
        }

        public File getFile() {
            return this.file;
        }

        public int getType() {
            return this.type;
        }

        @Override // java.util.EventObject
        public String toString() {
            return "FileEvent: " + this.file + ":" + this.type;
        }
    }

    public void addWatch(File file) throws IOException {
        addWatch(file, 511);
    }

    public void addWatch(File file, int i) throws IOException {
        addWatch(file, i, file.isDirectory());
    }

    public void addWatch(File file, int i, boolean z) throws IOException {
        this.watched.put(file, Integer.valueOf(i));
        watch(file, i, z);
    }

    public void removeWatch(File file) {
        if (this.watched.remove(file) != null) {
            unwatch(file);
        }
    }

    protected void notify(FileEvent fileEvent) {
        Iterator<FileListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().fileChanged(fileEvent);
        }
    }

    public synchronized void addFileListener(FileListener fileListener) {
        ArrayList arrayList = new ArrayList(this.listeners);
        arrayList.add(fileListener);
        this.listeners = arrayList;
    }

    public synchronized void removeFileListener(FileListener fileListener) {
        ArrayList arrayList = new ArrayList(this.listeners);
        arrayList.remove(fileListener);
        this.listeners = arrayList;
    }

    protected void finalize() {
        Iterator<File> it = this.watched.keySet().iterator();
        while (it.hasNext()) {
            removeWatch(it.next());
        }
        dispose();
    }

    private static class Holder {
        public static final FileMonitor INSTANCE;

        private Holder() {
        }

        static {
            String property = System.getProperty("os.name");
            if (property.startsWith("Windows")) {
                INSTANCE = new W32FileMonitor();
                return;
            }
            throw new Error("FileMonitor not implemented for " + property);
        }
    }

    public static FileMonitor getInstance() {
        return Holder.INSTANCE;
    }
}
