package com.android.ddmlib;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class AllocationInfo implements IStackTraceInfo {
    private final int mAllocNumber;
    private final String mAllocatedClass;
    private final int mAllocationSize;
    private final StackTraceElement[] mStackTrace;
    private final short mThreadId;

    public enum SortMode {
        NUMBER,
        SIZE,
        CLASS,
        THREAD,
        ALLOCATION_SITE,
        IN_CLASS,
        IN_METHOD
    }

    public static final class AllocationSorter implements Comparator<AllocationInfo> {
        private SortMode mSortMode = SortMode.SIZE;
        private boolean mDescending = true;

        public void setSortMode(SortMode mode) {
            if (this.mSortMode == mode) {
                this.mDescending = !this.mDescending;
            } else {
                this.mSortMode = mode;
            }
        }

        public void setSortMode(SortMode mode, boolean descending) {
            this.mSortMode = mode;
            this.mDescending = descending;
        }

        public SortMode getSortMode() {
            return this.mSortMode;
        }

        public boolean isDescending() {
            return this.mDescending;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int compare(com.android.ddmlib.AllocationInfo r3, com.android.ddmlib.AllocationInfo r4) {
            /*
                r2 = this;
                int[] r0 = com.android.ddmlib.AllocationInfo.AnonymousClass1.$SwitchMap$com$android$ddmlib$AllocationInfo$SortMode
                com.android.ddmlib.AllocationInfo$SortMode r1 = r2.mSortMode
                int r1 = r1.ordinal()
                r0 = r0[r1]
                r1 = 1
                if (r0 == r1) goto L5b
                r1 = 3
                if (r0 == r1) goto L4e
                r1 = 4
                if (r0 == r1) goto L45
                r1 = 5
                if (r0 == r1) goto L38
                r1 = 6
                if (r0 == r1) goto L2b
                r1 = 7
                if (r0 == r1) goto L1e
                r0 = 0
                goto L64
            L1e:
                java.lang.String r0 = r3.getAllocationSite()
                java.lang.String r1 = r4.getAllocationSite()
                int r0 = compareOptionalString(r0, r1)
                goto L64
            L2b:
                java.lang.String r0 = r3.getFirstTraceMethodName()
                java.lang.String r1 = r4.getFirstTraceMethodName()
                int r0 = compareOptionalString(r0, r1)
                goto L64
            L38:
                java.lang.String r0 = r3.getFirstTraceClassName()
                java.lang.String r1 = r4.getFirstTraceClassName()
                int r0 = compareOptionalString(r0, r1)
                goto L64
            L45:
                short r0 = com.android.ddmlib.AllocationInfo.access$200(r3)
                short r1 = com.android.ddmlib.AllocationInfo.access$200(r4)
                goto L63
            L4e:
                java.lang.String r0 = com.android.ddmlib.AllocationInfo.access$100(r3)
                java.lang.String r1 = com.android.ddmlib.AllocationInfo.access$100(r4)
                int r0 = r0.compareTo(r1)
                goto L64
            L5b:
                int r0 = com.android.ddmlib.AllocationInfo.access$000(r3)
                int r1 = com.android.ddmlib.AllocationInfo.access$000(r4)
            L63:
                int r0 = r0 - r1
            L64:
                if (r0 != 0) goto L70
                int r3 = com.android.ddmlib.AllocationInfo.access$300(r3)
                int r4 = com.android.ddmlib.AllocationInfo.access$300(r4)
                int r0 = r3 - r4
            L70:
                boolean r3 = r2.mDescending
                if (r3 == 0) goto L75
                int r0 = -r0
            L75:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.ddmlib.AllocationInfo.AllocationSorter.compare(com.android.ddmlib.AllocationInfo, com.android.ddmlib.AllocationInfo):int");
        }

        private static int compareOptionalString(String str1, String str2) {
            if (str1 == null) {
                return str2 == null ? 0 : 1;
            }
            if (str2 == null) {
                return -1;
            }
            return str1.compareTo(str2);
        }
    }

    /* renamed from: com.android.ddmlib.AllocationInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$ddmlib$AllocationInfo$SortMode;

        static {
            int[] iArr = new int[SortMode.values().length];
            $SwitchMap$com$android$ddmlib$AllocationInfo$SortMode = iArr;
            try {
                iArr[SortMode.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$ddmlib$AllocationInfo$SortMode[SortMode.SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$ddmlib$AllocationInfo$SortMode[SortMode.CLASS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$android$ddmlib$AllocationInfo$SortMode[SortMode.THREAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$android$ddmlib$AllocationInfo$SortMode[SortMode.IN_CLASS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$android$ddmlib$AllocationInfo$SortMode[SortMode.IN_METHOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$android$ddmlib$AllocationInfo$SortMode[SortMode.ALLOCATION_SITE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    AllocationInfo(int allocNumber, String allocatedClass, int allocationSize, short threadId, StackTraceElement[] stackTrace) {
        this.mAllocNumber = allocNumber;
        this.mAllocatedClass = allocatedClass;
        this.mAllocationSize = allocationSize;
        this.mThreadId = threadId;
        this.mStackTrace = stackTrace;
    }

    public int getAllocNumber() {
        return this.mAllocNumber;
    }

    public String getAllocatedClass() {
        return this.mAllocatedClass;
    }

    public int getSize() {
        return this.mAllocationSize;
    }

    public short getThreadId() {
        return this.mThreadId;
    }

    @Override // com.android.ddmlib.IStackTraceInfo
    public StackTraceElement[] getStackTrace() {
        return this.mStackTrace;
    }

    public int compareTo(AllocationInfo otherAlloc) {
        return otherAlloc.mAllocationSize - this.mAllocationSize;
    }

    public String getAllocationSite() {
        StackTraceElement[] stackTraceElementArr = this.mStackTrace;
        if (stackTraceElementArr.length > 0) {
            return stackTraceElementArr[0].toString();
        }
        return null;
    }

    public String getFirstTraceClassName() {
        StackTraceElement[] stackTraceElementArr = this.mStackTrace;
        if (stackTraceElementArr.length > 0) {
            return stackTraceElementArr[0].getClassName();
        }
        return null;
    }

    public String getFirstTraceMethodName() {
        StackTraceElement[] stackTraceElementArr = this.mStackTrace;
        if (stackTraceElementArr.length > 0) {
            return stackTraceElementArr[0].getMethodName();
        }
        return null;
    }

    public boolean filter(String filter, boolean fullTrace, Locale locale) {
        return allocatedClassMatches(filter, locale) || !getMatchingStackFrames(filter, fullTrace, locale).isEmpty();
    }

    public boolean allocatedClassMatches(String pattern, Locale locale) {
        return this.mAllocatedClass.toLowerCase(locale).contains(pattern.toLowerCase(locale));
    }

    public List<String> getMatchingStackFrames(String filter, boolean fullTrace, Locale locale) {
        String lowerCase = filter.toLowerCase(locale);
        StackTraceElement[] stackTraceElementArr = this.mStackTrace;
        if (stackTraceElementArr.length > 0) {
            int length = fullTrace ? stackTraceElementArr.length : 1;
            ArrayList arrayListNewArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(length);
            for (int i = 0; i < length; i++) {
                String string = this.mStackTrace[i].toString();
                if (string.toLowerCase(locale).contains(lowerCase)) {
                    arrayListNewArrayListWithExpectedSize.add(string);
                }
            }
            return arrayListNewArrayListWithExpectedSize;
        }
        return Collections.emptyList();
    }
}
