package com.android.ddmlib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class FileListingService {
    public static final String DIRECTORY_APP = "app";
    public static final String DIRECTORY_DATA = "data";
    public static final String DIRECTORY_MNT = "mnt";
    public static final String DIRECTORY_SDCARD = "sdcard";
    public static final String DIRECTORY_SYSTEM = "system";
    public static final String DIRECTORY_TEMP = "tmp";
    private static final String FILE_ROOT = "/";
    public static final String FILE_SEPARATOR = "/";
    private static final String PM_FULL_LISTING = "pm list packages -f";
    public static final long REFRESH_RATE = 5000;
    static final long REFRESH_TEST = 4000;
    public static final int TYPE_BLOCK = 3;
    public static final int TYPE_CHARACTER = 4;
    public static final int TYPE_DIRECTORY = 1;
    public static final int TYPE_DIRECTORY_LINK = 2;
    public static final int TYPE_FIFO = 7;
    public static final int TYPE_FILE = 0;
    public static final int TYPE_LINK = 5;
    public static final int TYPE_OTHER = 8;
    public static final int TYPE_SOCKET = 6;
    private IDevice mDevice;
    private FileEntry mRoot;
    private final ArrayList<Thread> mThreadList = new ArrayList<>();
    private static final Pattern sApkPattern = Pattern.compile(".*\\.apk", 2);
    private static final Pattern sPmPattern = Pattern.compile("^package:(.+?)=(.+)$");
    public static final Pattern LS_L_PATTERN = Pattern.compile("^([bcdlsp-][-r][-w][-xsS][-r][-w][-xsS][-r][-w][-xstST])\\s+(?:\\d+\\s+)?(\\S+)\\s+(\\S+)\\s+([\\d\\s,]*)\\s+(\\d{4}-\\d\\d-\\d\\d)\\s+(\\d\\d:\\d\\d)\\s+(.*)$");
    public static final Pattern LS_LD_PATTERN = Pattern.compile("d[rwxs-]{9}\\s+(\\d+\\s+)?\\S+\\s+\\S+\\s+(\\d+\\s+)?[0-9-]{10}\\s+\\d{2}:\\d{2}.*$");

    public interface IListingReceiver {
        void refreshEntry(FileEntry entry);

        void setChildren(FileEntry entry, FileEntry[] children);
    }

    public static final class FileEntry {
        String date;
        String group;
        String info;
        boolean isAppPackage;
        boolean isRoot;
        String name;
        String owner;
        FileEntry parent;
        String permissions;
        String size;
        String time;
        int type;
        private static final Pattern sEscapePattern = Pattern.compile("([\\\\()*+?\"'&$#/\\s])");
        private static Comparator<FileEntry> sEntryComparator = new Comparator<FileEntry>() { // from class: com.android.ddmlib.FileListingService.FileEntry.1
            @Override // java.util.Comparator
            public int compare(FileEntry o1, FileEntry o2) {
                if ((o1 instanceof FileEntry) && (o2 instanceof FileEntry)) {
                    return o1.name.compareTo(o2.name);
                }
                return 0;
            }
        };
        long fetchTime = 0;
        final ArrayList<FileEntry> mChildren = new ArrayList<>();

        public FileEntry(FileEntry parent, String name, int type, boolean isRoot) {
            this.parent = parent;
            this.name = name;
            this.type = type;
            this.isRoot = isRoot;
            checkAppPackageStatus();
        }

        public String getName() {
            return this.name;
        }

        public String getSize() {
            return this.size;
        }

        public int getSizeValue() {
            return Integer.parseInt(this.size);
        }

        public String getDate() {
            return this.date;
        }

        public String getTime() {
            return this.time;
        }

        public String getPermissions() {
            return this.permissions;
        }

        public String getOwner() {
            return this.owner;
        }

        public String getGroup() {
            return this.group;
        }

        public String getInfo() {
            return this.info;
        }

        public String getFullPath() {
            if (this.isRoot) {
                return "/";
            }
            StringBuilder sb = new StringBuilder();
            fillPathBuilder(sb, false);
            return sb.toString();
        }

        public String getFullEscapedPath() {
            StringBuilder sb = new StringBuilder();
            fillPathBuilder(sb, true);
            return sb.toString();
        }

        public String[] getPathSegments() {
            ArrayList<String> arrayList = new ArrayList<>();
            fillPathSegments(arrayList);
            return (String[]) arrayList.toArray(new String[0]);
        }

        public int getType() {
            return this.type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public boolean isDirectory() {
            int i = this.type;
            return i == 1 || i == 2;
        }

        public FileEntry getParent() {
            return this.parent;
        }

        public FileEntry[] getCachedChildren() {
            return (FileEntry[]) this.mChildren.toArray(new FileEntry[0]);
        }

        public FileEntry findChild(String name) {
            Iterator<FileEntry> it = this.mChildren.iterator();
            while (it.hasNext()) {
                FileEntry next = it.next();
                if (next.name.equals(name)) {
                    return next;
                }
            }
            return null;
        }

        public boolean isRoot() {
            return this.isRoot;
        }

        void addChild(FileEntry child) {
            this.mChildren.add(child);
        }

        void setChildren(ArrayList<FileEntry> newChildren) {
            this.mChildren.clear();
            this.mChildren.addAll(newChildren);
        }

        boolean needFetch() {
            return this.fetchTime == 0 || System.currentTimeMillis() - this.fetchTime > FileListingService.REFRESH_TEST;
        }

        public boolean isApplicationPackage() {
            return this.isAppPackage;
        }

        public boolean isAppFileName() {
            return FileListingService.sApkPattern.matcher(this.name).matches();
        }

        protected void fillPathBuilder(StringBuilder pathBuilder, boolean escapePath) {
            if (this.isRoot) {
                return;
            }
            FileEntry fileEntry = this.parent;
            if (fileEntry != null) {
                fileEntry.fillPathBuilder(pathBuilder, escapePath);
            }
            pathBuilder.append("/");
            pathBuilder.append(escapePath ? escape(this.name) : this.name);
        }

        protected void fillPathSegments(ArrayList<String> list) {
            if (this.isRoot) {
                return;
            }
            FileEntry fileEntry = this.parent;
            if (fileEntry != null) {
                fileEntry.fillPathSegments(list);
            }
            list.add(this.name);
        }

        private void checkAppPackageStatus() {
            boolean z = false;
            this.isAppPackage = false;
            String[] pathSegments = getPathSegments();
            if (this.type == 0 && pathSegments.length == 3 && isAppFileName()) {
                if ("app".equals(pathSegments[1]) && (FileListingService.DIRECTORY_SYSTEM.equals(pathSegments[0]) || "data".equals(pathSegments[0]))) {
                    z = true;
                }
                this.isAppPackage = z;
            }
        }

        public static String escape(String entryName) {
            return sEscapePattern.matcher(entryName).replaceAll("\\\\$1");
        }
    }

    private static class LsReceiver extends MultiLineReceiver {
        private FileEntry[] mCurrentChildren;
        private ArrayList<FileEntry> mEntryList;
        private ArrayList<String> mLinkList;
        private FileEntry mParentEntry;

        @Override // com.android.ddmlib.IShellOutputReceiver
        public boolean isCancelled() {
            return false;
        }

        public LsReceiver(FileEntry parentEntry, ArrayList<FileEntry> entryList, ArrayList<String> linkList) {
            this.mParentEntry = parentEntry;
            this.mCurrentChildren = parentEntry.getCachedChildren();
            this.mEntryList = entryList;
            this.mLinkList = linkList;
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
        @Override // com.android.ddmlib.MultiLineReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void processNewLines(java.lang.String[] r17) {
            /*
                Method dump skipped, instructions count: 224
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.ddmlib.FileListingService.LsReceiver.processNewLines(java.lang.String[]):void");
        }

        private FileEntry getExistingEntry(String name) {
            int i = 0;
            while (true) {
                FileEntry[] fileEntryArr = this.mCurrentChildren;
                if (i >= fileEntryArr.length) {
                    return null;
                }
                FileEntry fileEntry = fileEntryArr[i];
                if (fileEntry != null && name.equals(fileEntry.name)) {
                    this.mCurrentChildren[i] = null;
                    return fileEntry;
                }
                i++;
            }
        }

        public void finishLinks(IDevice device, ArrayList<FileEntry> entries) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException {
            final int[] iArr = {0};
            MultiLineReceiver multiLineReceiver = new MultiLineReceiver() { // from class: com.android.ddmlib.FileListingService.LsReceiver.1
                @Override // com.android.ddmlib.IShellOutputReceiver
                public boolean isCancelled() {
                    return false;
                }

                @Override // com.android.ddmlib.MultiLineReceiver
                public void processNewLines(String[] lines) {
                    for (String str : lines) {
                        if (FileListingService.LS_LD_PATTERN.matcher(str).matches()) {
                            int[] iArr2 = iArr;
                            iArr2[0] = iArr2[0] + 1;
                        }
                    }
                }
            };
            Iterator<FileEntry> it = entries.iterator();
            while (it.hasNext()) {
                FileEntry next = it.next();
                if (next.getType() == 5) {
                    iArr[0] = 0;
                    device.executeShellCommand(String.format("ls -l -d %s%s", next.getFullEscapedPath(), "/"), multiLineReceiver);
                    if (iArr[0] > 0) {
                        next.setType(2);
                    }
                }
            }
        }
    }

    public FileListingService(IDevice device) {
        this.mDevice = device;
    }

    public FileEntry getRoot() {
        if (this.mDevice == null) {
            return null;
        }
        if (this.mRoot == null) {
            this.mRoot = new FileEntry(null, "", 1, true);
        }
        return this.mRoot;
    }

    public FileEntry[] getChildren(final FileEntry entry, boolean useCache, final IListingReceiver receiver) {
        if (useCache && !entry.needFetch()) {
            return entry.getCachedChildren();
        }
        if (receiver == null) {
            doLs(entry);
            return entry.getCachedChildren();
        }
        Thread thread = new Thread("ls " + entry.getFullPath()) { // from class: com.android.ddmlib.FileListingService.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                FileListingService.this.doLs(entry);
                IListingReceiver iListingReceiver = receiver;
                FileEntry fileEntry = entry;
                iListingReceiver.setChildren(fileEntry, fileEntry.getCachedChildren());
                FileEntry[] cachedChildren = entry.getCachedChildren();
                if (cachedChildren.length > 0 && cachedChildren[0].isApplicationPackage()) {
                    final HashMap map = new HashMap();
                    for (FileEntry fileEntry2 : cachedChildren) {
                        map.put(fileEntry2.getFullPath(), fileEntry2);
                    }
                    try {
                        FileListingService.this.mDevice.executeShellCommand(FileListingService.PM_FULL_LISTING, new MultiLineReceiver() { // from class: com.android.ddmlib.FileListingService.1.1
                            @Override // com.android.ddmlib.IShellOutputReceiver
                            public boolean isCancelled() {
                                return false;
                            }

                            @Override // com.android.ddmlib.MultiLineReceiver
                            public void processNewLines(String[] lines) {
                                FileEntry fileEntry3;
                                for (String str : lines) {
                                    if (!str.isEmpty()) {
                                        Matcher matcher = FileListingService.sPmPattern.matcher(str);
                                        if (matcher.matches() && (fileEntry3 = (FileEntry) map.get(matcher.group(1))) != null) {
                                            fileEntry3.info = matcher.group(2);
                                            receiver.refreshEntry(fileEntry3);
                                        }
                                    }
                                }
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
                synchronized (FileListingService.this.mThreadList) {
                    FileListingService.this.mThreadList.remove(this);
                    if (!FileListingService.this.mThreadList.isEmpty()) {
                        ((Thread) FileListingService.this.mThreadList.get(0)).start();
                    }
                }
            }
        };
        synchronized (this.mThreadList) {
            this.mThreadList.add(thread);
            if (this.mThreadList.size() == 1) {
                thread.start();
            }
        }
        return null;
    }

    public FileEntry[] getChildrenSync(final FileEntry entry) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException {
        doLsAndThrow(entry);
        return entry.getCachedChildren();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLs(FileEntry entry) {
        try {
            doLsAndThrow(entry);
        } catch (Exception unused) {
        }
    }

    private void doLsAndThrow(FileEntry entry) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException {
        ArrayList<FileEntry> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        try {
            String str = "ls -l " + entry.getFullEscapedPath();
            if (entry.isDirectory()) {
                str = str + "/";
            }
            LsReceiver lsReceiver = new LsReceiver(entry, arrayList, arrayList2);
            this.mDevice.executeShellCommand(str, lsReceiver);
            lsReceiver.finishLinks(this.mDevice, arrayList);
        } finally {
            entry.fetchTime = System.currentTimeMillis();
            Collections.sort(arrayList, FileEntry.sEntryComparator);
            entry.setChildren(arrayList);
        }
    }
}
