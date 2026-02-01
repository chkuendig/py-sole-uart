package com.android.ddmlib;

import com.android.ddmlib.HeapSegment;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.internal.ClientImpl;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes3.dex */
public class ClientData {
    public static final String FEATURE_HPROF = "hprof-heap-dump";
    public static final String FEATURE_HPROF_STREAMING = "hprof-heap-dump-streaming";
    public static final String FEATURE_OPENGL_TRACING = "opengl-tracing";
    public static final String FEATURE_PROFILING = "method-trace-profiling";
    public static final String FEATURE_PROFILING_STREAMING = "method-trace-profiling-streaming";
    public static final String FEATURE_SAMPLING_PROFILER = "method-sample-profiling";
    public static final String FEATURE_VIEW_HIERARCHY = "view-hierarchy";
    public static final String PRE_INITIALIZED = "<pre-initialized>";
    private static final Names UNINITIALIZED = new Names(null, null, null);
    private static IAllocationTrackingHandler sAllocationTrackingHandler;

    @Deprecated
    private static IHprofDumpHandler sHprofDumpHandler;
    private static IMethodProfilingHandler sMethodProfilingHandler;
    private String mAbi;
    private AllocationInfo[] mAllocations;
    private byte[] mAllocationsData;
    private final ClientImpl mClient;
    private String mJvmFlags;
    private int mNativeTotalMemory;

    @Deprecated
    private String mPendingHprofDump;
    private String mPendingMethodProfiling;
    private final int mPid;
    private String mVmIdentifier;
    private String mPackageName = "";
    private Names mClientNames = UNINITIALIZED;
    private boolean mNativeDebuggable = false;
    private final HashSet<String> mFeatures = new HashSet<>();
    private final HeapData mHeapData = new HeapData();
    private final HeapData mNativeHeapData = new HeapData();
    private HprofData mHprofData = null;
    private HashMap<Integer, HeapInfo> mHeapInfoMap = new HashMap<>();
    private ArrayList<NativeLibraryMapInfo> mNativeLibMapInfo = new ArrayList<>();
    private ArrayList<NativeAllocationInfo> mNativeAllocationList = new ArrayList<>();
    private AllocationTrackingStatus mAllocationStatus = AllocationTrackingStatus.UNKNOWN;
    private MethodProfilingStatus mProfilingStatus = MethodProfilingStatus.UNKNOWN;
    private DebuggerStatus mDebuggerInterest = DebuggerStatus.DEFAULT;
    private TreeMap<Integer, ThreadInfo> mThreadMap = new TreeMap<>();

    public enum AllocationTrackingStatus {
        UNKNOWN,
        OFF,
        ON
    }

    public enum DebuggerStatus {
        DEFAULT,
        WAITING,
        ATTACHED,
        ERROR
    }

    public interface IAllocationTrackingHandler {
        void onSuccess(byte[] data, Client client);
    }

    @Deprecated
    public interface IHprofDumpHandler {
        void onEndFailure(Client client, String message);

        void onSuccess(String remoteFilePath, Client client);

        void onSuccess(byte[] data, Client client);
    }

    public interface IMethodProfilingHandler {
        void onEndFailure(Client client, String message);

        void onStartFailure(Client client, String message);

        void onSuccess(String remoteFilePath, Client client);

        void onSuccess(byte[] data, Client client);
    }

    public enum MethodProfilingStatus {
        UNKNOWN,
        OFF,
        TRACER_ON,
        SAMPLER_ON
    }

    public static class HeapData {
        private byte[] mProcessedHeapData;
        private Map<Integer, ArrayList<HeapSegment.HeapSegmentElement>> mProcessedHeapMap;
        private TreeSet<HeapSegment> mHeapSegments = new TreeSet<>();
        private boolean mHeapDataComplete = false;

        public synchronized void clearHeapData() {
            this.mHeapSegments = new TreeSet<>();
            this.mHeapDataComplete = false;
        }

        public synchronized void addHeapData(ByteBuffer data) {
            if (this.mHeapDataComplete) {
                clearHeapData();
            }
            try {
                this.mHeapSegments.add(new HeapSegment(data));
            } catch (BufferUnderflowException unused) {
                System.err.println("Discarding short HPSG data (length " + data.limit() + ")");
            }
        }

        public synchronized void sealHeapData() {
            this.mHeapDataComplete = true;
        }

        public boolean isHeapDataComplete() {
            return this.mHeapDataComplete;
        }

        public Collection<HeapSegment> getHeapSegments() {
            if (isHeapDataComplete()) {
                return this.mHeapSegments;
            }
            return null;
        }

        public void setProcessedHeapData(byte[] heapData) {
            this.mProcessedHeapData = heapData;
        }

        public byte[] getProcessedHeapData() {
            return this.mProcessedHeapData;
        }

        public void setProcessedHeapMap(Map<Integer, ArrayList<HeapSegment.HeapSegmentElement>> heapMap) {
            this.mProcessedHeapMap = heapMap;
        }

        public Map<Integer, ArrayList<HeapSegment.HeapSegmentElement>> getProcessedHeapMap() {
            return this.mProcessedHeapMap;
        }
    }

    public static class HeapInfo {
        public long bytesAllocated;
        public long maxSizeInBytes;
        public long objectsAllocated;
        public byte reason;
        public long sizeInBytes;
        public long timeStamp;

        public HeapInfo(long maxSizeInBytes, long sizeInBytes, long bytesAllocated, long objectsAllocated, long timeStamp, byte reason) {
            this.maxSizeInBytes = maxSizeInBytes;
            this.sizeInBytes = sizeInBytes;
            this.bytesAllocated = bytesAllocated;
            this.objectsAllocated = objectsAllocated;
            this.timeStamp = timeStamp;
            this.reason = reason;
        }
    }

    public static class HprofData {
        public final byte[] data;
        public final String filename;
        public final Type type;

        public enum Type {
            FILE,
            DATA
        }

        public HprofData(String filename) {
            this.type = Type.FILE;
            this.filename = filename;
            this.data = null;
        }

        public HprofData(byte[] data) {
            this.type = Type.DATA;
            this.data = data;
            this.filename = null;
        }
    }

    public void setHprofData(byte[] data) {
        this.mHprofData = new HprofData(data);
    }

    public void setHprofData(String filename) {
        this.mHprofData = new HprofData(filename);
    }

    public void clearHprofData() {
        this.mHprofData = null;
    }

    public HprofData getHprofData() {
        return this.mHprofData;
    }

    @Deprecated
    public static void setHprofDumpHandler(IHprofDumpHandler handler) {
        sHprofDumpHandler = handler;
    }

    @Deprecated
    public static IHprofDumpHandler getHprofDumpHandler() {
        return sHprofDumpHandler;
    }

    public static void setMethodProfilingHandler(IMethodProfilingHandler handler) {
        sMethodProfilingHandler = handler;
    }

    public static IMethodProfilingHandler getMethodProfilingHandler() {
        return sMethodProfilingHandler;
    }

    @Deprecated
    public static void setAllocationTrackingHandler(IAllocationTrackingHandler handler) {
        sAllocationTrackingHandler = handler;
    }

    @Deprecated
    public static IAllocationTrackingHandler getAllocationTrackingHandler() {
        return sAllocationTrackingHandler;
    }

    public ClientData(ClientImpl client, int pid) {
        this.mClient = client;
        this.mPid = pid;
    }

    public int getPid() {
        return this.mPid;
    }

    public String getVmIdentifier() {
        return this.mVmIdentifier;
    }

    public void setVmIdentifier(String ident) {
        this.mVmIdentifier = ident;
    }

    public String getClientDescription() {
        return this.mClientNames.mProcessName;
    }

    public int getUserId() {
        if (this.mClientNames.mUserId == null) {
            return -1;
        }
        return this.mClientNames.mUserId.intValue();
    }

    public boolean isValidUserId() {
        return this.mClientNames != UNINITIALIZED;
    }

    public String getAbi() {
        return this.mAbi;
    }

    public String getJvmFlags() {
        return this.mJvmFlags;
    }

    public void setNames(Names names) {
        if (names.mProcessName.isEmpty() || PRE_INITIALIZED.equals(names.mProcessName)) {
            return;
        }
        this.mClientNames = names;
    }

    public void setAbi(String abi) {
        this.mAbi = abi;
    }

    public void setJvmFlags(String jvmFlags) {
        this.mJvmFlags = jvmFlags;
    }

    public boolean isNativeDebuggable() {
        return this.mNativeDebuggable;
    }

    public void setNativeDebuggable(boolean nativeDebuggable) {
        this.mNativeDebuggable = nativeDebuggable;
    }

    public DebuggerStatus getDebuggerConnectionStatus() {
        return this.mDebuggerInterest;
    }

    public void setDebuggerConnectionStatus(DebuggerStatus status) {
        this.mDebuggerInterest = status;
    }

    public synchronized void setHeapInfo(int heapId, long maxSizeInBytes, long sizeInBytes, long bytesAllocated, long objectsAllocated, long timeStamp, byte reason) {
        this.mHeapInfoMap.put(Integer.valueOf(heapId), new HeapInfo(maxSizeInBytes, sizeInBytes, bytesAllocated, objectsAllocated, timeStamp, reason));
    }

    public HeapData getVmHeapData() {
        return this.mHeapData;
    }

    public HeapData getNativeHeapData() {
        return this.mNativeHeapData;
    }

    public synchronized Iterator<Integer> getVmHeapIds() {
        return this.mHeapInfoMap.keySet().iterator();
    }

    public synchronized HeapInfo getVmHeapInfo(int heapId) {
        return this.mHeapInfoMap.get(Integer.valueOf(heapId));
    }

    public synchronized void addThread(int threadId, String threadName) {
        this.mThreadMap.put(Integer.valueOf(threadId), new ThreadInfo(threadId, threadName));
    }

    public synchronized void removeThread(int threadId) {
        this.mThreadMap.remove(Integer.valueOf(threadId));
    }

    public synchronized ThreadInfo[] getThreads() {
        return (ThreadInfo[]) this.mThreadMap.values().toArray(new ThreadInfo[0]);
    }

    public synchronized ThreadInfo getThread(int threadId) {
        return this.mThreadMap.get(Integer.valueOf(threadId));
    }

    public synchronized void clearThreads() {
        this.mThreadMap.clear();
    }

    public synchronized List<NativeAllocationInfo> getNativeAllocationList() {
        return Collections.unmodifiableList(this.mNativeAllocationList);
    }

    public synchronized void addNativeAllocation(NativeAllocationInfo allocInfo) {
        this.mNativeAllocationList.add(allocInfo);
    }

    public synchronized void clearNativeAllocationInfo() {
        this.mNativeAllocationList.clear();
    }

    public synchronized int getTotalNativeMemory() {
        return this.mNativeTotalMemory;
    }

    public synchronized void setTotalNativeMemory(int totalMemory) {
        this.mNativeTotalMemory = totalMemory;
    }

    public synchronized void addNativeLibraryMapInfo(long startAddr, long endAddr, String library) {
        this.mNativeLibMapInfo.add(new NativeLibraryMapInfo(startAddr, endAddr, library));
    }

    public synchronized List<NativeLibraryMapInfo> getMappedNativeLibraries() {
        return Collections.unmodifiableList(this.mNativeLibMapInfo);
    }

    public synchronized void setAllocationStatus(AllocationTrackingStatus status) {
        this.mAllocationStatus = status;
    }

    public synchronized AllocationTrackingStatus getAllocationStatus() {
        return this.mAllocationStatus;
    }

    public synchronized void setAllocationsData(byte[] data) {
        this.mAllocationsData = data;
    }

    public synchronized byte[] getAllocationsData() {
        return this.mAllocationsData;
    }

    @Deprecated
    synchronized void setAllocations(AllocationInfo[] allocs) {
        this.mAllocations = allocs;
    }

    public synchronized AllocationInfo[] getAllocations() {
        byte[] bArr = this.mAllocationsData;
        if (bArr == null) {
            return null;
        }
        return AllocationsParser.parse(ByteBuffer.wrap(bArr));
    }

    public void addFeature(String feature) {
        this.mFeatures.add(feature);
    }

    public boolean hasFeature(String feature) {
        return this.mFeatures.contains(feature);
    }

    @Deprecated
    public void setPendingHprofDump(String pendingHprofDump) {
        this.mPendingHprofDump = pendingHprofDump;
    }

    @Deprecated
    public String getPendingHprofDump() {
        return this.mPendingHprofDump;
    }

    @Deprecated
    public boolean hasPendingHprofDump() {
        return this.mPendingHprofDump != null;
    }

    public synchronized void setMethodProfilingStatus(MethodProfilingStatus status) {
        this.mProfilingStatus = status;
    }

    public synchronized MethodProfilingStatus getMethodProfilingStatus() {
        return this.mProfilingStatus;
    }

    public void setPendingMethodProfiling(String pendingMethodProfiling) {
        this.mPendingMethodProfiling = pendingMethodProfiling;
    }

    public String getPendingMethodProfiling() {
        return this.mPendingMethodProfiling;
    }

    public String getPackageName() {
        if (this.mClient.getDevice().supportsFeature(IDevice.Feature.REAL_PKG_NAME)) {
            return this.mClientNames.mPackageName;
        }
        if (this.mClientNames.mProcessName == null) {
            return null;
        }
        int iIndexOf = this.mClientNames.mProcessName.indexOf(58);
        if (iIndexOf == -1) {
            return this.mClientNames.mProcessName;
        }
        return this.mClientNames.mProcessName.substring(0, iIndexOf);
    }

    public String getDataDir() {
        String packageName = getPackageName();
        if (isValidUserId() && getUserId() > 0) {
            return String.format("/data/user/%d/%s", Integer.valueOf(getUserId()), packageName);
        }
        return "/data/data/" + packageName;
    }

    public static class Names {
        public final String mPackageName;
        public final String mProcessName;
        public final Integer mUserId;

        public Names(String processName, Integer id2, String packageName) {
            this.mProcessName = processName;
            this.mUserId = id2;
            this.mPackageName = packageName;
        }
    }
}
