package com.android.ddmlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public interface Client {
    public static final int CHANGE_DEBUGGER_STATUS = 2;
    public static final int CHANGE_HEAP_ALLOCATIONS = 512;
    public static final int CHANGE_HEAP_ALLOCATION_STATUS = 1024;
    public static final int CHANGE_HEAP_DATA = 64;
    public static final int CHANGE_HEAP_MODE = 32;
    public static final int CHANGE_HPROF = 4096;
    public static final int CHANGE_INFO = 7;
    public static final int CHANGE_METHOD_PROFILING_STATUS = 2048;
    public static final int CHANGE_NAME = 1;
    public static final int CHANGE_NATIVE_HEAP_DATA = 128;
    public static final int CHANGE_PORT = 4;
    public static final int CHANGE_THREAD_DATA = 16;
    public static final int CHANGE_THREAD_MODE = 8;
    public static final int CHANGE_THREAD_STACKTRACE = 256;
    public static final int SERVER_PROTOCOL_VERSION = 1;

    void captureView(String viewRoot, String view, DebugViewDumpHandler handler) throws IOException;

    void dumpDisplayList(String viewRoot, String view) throws IOException;

    void dumpViewHierarchy(String viewRoot, boolean skipChildren, boolean includeProperties, boolean useV2, DebugViewDumpHandler handler) throws IOException;

    void enableAllocationTracker(boolean enabled);

    void executeGarbageCollector();

    ClientData getClientData();

    int getDebuggerListenPort();

    IDevice getDevice();

    boolean isDdmAware();

    boolean isDebuggerAttached();

    boolean isValid();

    void kill();

    void listViewRoots(DebugViewDumpHandler replyHandler) throws IOException;

    void notifyVmMirrorExited();

    void requestAllocationDetails();

    void startMethodTracer() throws IOException;

    void startSamplingProfiler(int samplingInterval, TimeUnit timeUnit) throws IOException;

    void stopMethodTracer() throws IOException;

    void stopSamplingProfiler() throws IOException;
}
