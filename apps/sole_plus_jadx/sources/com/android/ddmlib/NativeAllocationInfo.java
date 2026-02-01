package com.android.ddmlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class NativeAllocationInfo {
    public static final String ALLOCATIONS_KW = "Allocations:";
    public static final String BEGIN_STACKTRACE_KW = "BeginStacktrace:";
    public static final String END_STACKTRACE_KW = "EndStacktrace";
    private static final List<String> FILTERED_LIBRARIES = Arrays.asList("libc.so", "libc_malloc_debug_leak.so");
    private static final List<Pattern> FILTERED_METHOD_NAME_PATTERNS = Arrays.asList(Pattern.compile("malloc", 2), Pattern.compile("calloc", 2), Pattern.compile("realloc", 2), Pattern.compile("operator new", 2), Pattern.compile("memalign", 2));
    private static final int FLAG_MASK = Integer.MIN_VALUE;
    private static final int FLAG_ZYGOTE_CHILD = Integer.MIN_VALUE;
    public static final String SIZE_KW = "Size:";
    public static final String TOTAL_SIZE_KW = "TotalSize:";
    private int mAllocations;
    private final boolean mIsZygoteChild;
    private final int mSize;
    private final ArrayList<Long> mStackCallAddresses = new ArrayList<>();
    private ArrayList<NativeStackCallInfo> mResolvedStackCall = null;
    private boolean mIsStackCallResolved = false;

    public NativeAllocationInfo(int size, int allocations) {
        this.mSize = Integer.MAX_VALUE & size;
        this.mIsZygoteChild = (size & Integer.MIN_VALUE) != 0;
        this.mAllocations = allocations;
    }

    public void addStackCallAddress(long address) {
        this.mStackCallAddresses.add(Long.valueOf(address));
    }

    public int getSize() {
        return this.mSize;
    }

    public boolean isZygoteChild() {
        return this.mIsZygoteChild;
    }

    public int getAllocationCount() {
        return this.mAllocations;
    }

    public boolean isStackCallResolved() {
        return this.mIsStackCallResolved;
    }

    public List<Long> getStackCallAddresses() {
        return this.mStackCallAddresses;
    }

    public synchronized void setResolvedStackCall(List<NativeStackCallInfo> resolvedStackCall) {
        ArrayList<NativeStackCallInfo> arrayList = this.mResolvedStackCall;
        if (arrayList == null) {
            this.mResolvedStackCall = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        this.mResolvedStackCall.addAll(resolvedStackCall);
        this.mIsStackCallResolved = !this.mResolvedStackCall.isEmpty();
    }

    public synchronized List<NativeStackCallInfo> getResolvedStackCall() {
        if (!this.mIsStackCallResolved) {
            return null;
        }
        return this.mResolvedStackCall;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NativeAllocationInfo) {
            NativeAllocationInfo nativeAllocationInfo = (NativeAllocationInfo) obj;
            if (this.mSize == nativeAllocationInfo.mSize && this.mAllocations == nativeAllocationInfo.mAllocations) {
                return stackEquals(nativeAllocationInfo);
            }
        }
        return false;
    }

    public boolean stackEquals(NativeAllocationInfo mi) {
        if (this.mStackCallAddresses.size() != mi.mStackCallAddresses.size()) {
            return false;
        }
        int size = this.mStackCallAddresses.size();
        for (int i = 0; i < size; i++) {
            if (this.mStackCallAddresses.get(i).longValue() != mi.mStackCallAddresses.get(i).longValue()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = ((((527 + this.mSize) * 31) + this.mAllocations) * 31) + this.mStackCallAddresses.size();
        Iterator<Long> it = this.mStackCallAddresses.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            size = (size * 31) + ((int) (jLongValue ^ (jLongValue >>> 32)));
        }
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Allocations: ");
        sb.append(this.mAllocations);
        sb.append("\nSize: ");
        sb.append(this.mSize);
        sb.append("\nTotalSize: ");
        sb.append(this.mSize * this.mAllocations);
        sb.append('\n');
        if (this.mResolvedStackCall != null) {
            sb.append("BeginStacktrace:\n");
            Iterator<NativeStackCallInfo> it = this.mResolvedStackCall.iterator();
            while (it.hasNext()) {
                NativeStackCallInfo next = it.next();
                long address = next.getAddress();
                if (address != 0) {
                    if (next.getLineNumber() != -1) {
                        sb.append(String.format("\t%1$08x\t%2$s --- %3$s --- %4$s:%5$d\n", Long.valueOf(address), next.getLibraryName(), next.getMethodName(), next.getSourceFile(), Integer.valueOf(next.getLineNumber())));
                    } else {
                        sb.append(String.format("\t%1$08x\t%2$s --- %3$s --- %4$s\n", Long.valueOf(address), next.getLibraryName(), next.getMethodName(), next.getSourceFile()));
                    }
                }
            }
            sb.append("EndStacktrace\n");
        }
        return sb.toString();
    }

    public synchronized NativeStackCallInfo getRelevantStackCallInfo() {
        ArrayList<NativeStackCallInfo> arrayList;
        if (this.mIsStackCallResolved && (arrayList = this.mResolvedStackCall) != null) {
            Iterator<NativeStackCallInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                NativeStackCallInfo next = it.next();
                if (isRelevantLibrary(next.getLibraryName()) && isRelevantMethod(next.getMethodName())) {
                    return next;
                }
            }
            if (!this.mResolvedStackCall.isEmpty()) {
                return this.mResolvedStackCall.get(0);
            }
        }
        return null;
    }

    private boolean isRelevantLibrary(String libPath) {
        Iterator<String> it = FILTERED_LIBRARIES.iterator();
        while (it.hasNext()) {
            if (libPath.endsWith(it.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean isRelevantMethod(String methodName) {
        Iterator<Pattern> it = FILTERED_METHOD_NAME_PATTERNS.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(methodName).find()) {
                return false;
            }
        }
        return true;
    }
}
