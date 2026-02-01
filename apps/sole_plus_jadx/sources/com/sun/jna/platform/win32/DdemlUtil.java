package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.Ddeml;
import com.sun.jna.platform.win32.User32Util;
import com.sun.jna.platform.win32.User32Util.MessageLoopThread.Handler;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.W32APIOptions;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes4.dex */
public abstract class DdemlUtil {

    public interface AdvdataHandler {
        int onAdvdata(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.HDDEDATA hddedata);
    }

    public interface AdvreqHandler {
        Ddeml.HDDEDATA onAdvreq(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, int i3);
    }

    public interface AdvstartHandler {
        boolean onAdvstart(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2);
    }

    public interface AdvstopHandler {
        void onAdvstop(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2);
    }

    public interface ConnectConfirmHandler {
        void onConnectConfirm(int i, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, boolean z);
    }

    public interface ConnectHandler {
        boolean onConnect(int i, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.CONVCONTEXT convcontext, boolean z);
    }

    public interface DisconnectHandler {
        void onDisconnect(int i, Ddeml.HCONV hconv, boolean z);
    }

    public interface ErrorHandler {
        void onError(int i, Ddeml.HCONV hconv, int i2);
    }

    public interface ExecuteHandler {
        int onExecute(int i, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HDDEDATA hddedata);
    }

    public interface IDdeClient extends Closeable {
        void abandonTransactions();

        Pointer accessData(Ddeml.HDDEDATA hddedata, WinDef.DWORDByReference dWORDByReference);

        Ddeml.HDDEDATA addData(Ddeml.HDDEDATA hddedata, Pointer pointer, int i, int i2);

        IDdeConnection connect(Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.CONVCONTEXT convcontext);

        IDdeConnection connect(String str, String str2, Ddeml.CONVCONTEXT convcontext);

        IDdeConnectionList connectList(Ddeml.HSZ hsz, Ddeml.HSZ hsz2, IDdeConnectionList iDdeConnectionList, Ddeml.CONVCONTEXT convcontext);

        IDdeConnectionList connectList(String str, String str2, IDdeConnectionList iDdeConnectionList, Ddeml.CONVCONTEXT convcontext);

        Ddeml.HDDEDATA createDataHandle(Pointer pointer, int i, int i2, Ddeml.HSZ hsz, int i3, int i4);

        Ddeml.HSZ createStringHandle(String str) throws DdemlException;

        boolean enableCallback(int i);

        void freeDataHandle(Ddeml.HDDEDATA hddedata);

        boolean freeStringHandle(Ddeml.HSZ hsz);

        int getData(Ddeml.HDDEDATA hddedata, Pointer pointer, int i, int i2);

        Integer getInstanceIdentitifier();

        int getLastError();

        void initialize(int i) throws DdemlException;

        boolean keepStringHandle(Ddeml.HSZ hsz);

        void nameService(Ddeml.HSZ hsz, int i) throws DdemlException;

        void nameService(String str, int i) throws DdemlException;

        void postAdvise(Ddeml.HSZ hsz, Ddeml.HSZ hsz2);

        void postAdvise(String str, String str2);

        String queryString(Ddeml.HSZ hsz) throws DdemlException;

        void registerAdvReqHandler(AdvreqHandler advreqHandler);

        void registerAdvdataHandler(AdvdataHandler advdataHandler);

        void registerAdvstartHandler(AdvstartHandler advstartHandler);

        void registerAdvstopHandler(AdvstopHandler advstopHandler);

        void registerConnectConfirmHandler(ConnectConfirmHandler connectConfirmHandler);

        void registerConnectHandler(ConnectHandler connectHandler);

        void registerDisconnectHandler(DisconnectHandler disconnectHandler);

        void registerErrorHandler(ErrorHandler errorHandler);

        void registerExecuteHandler(ExecuteHandler executeHandler);

        void registerMonitorHandler(MonitorHandler monitorHandler);

        void registerPokeHandler(PokeHandler pokeHandler);

        void registerRegisterHandler(RegisterHandler registerHandler);

        void registerRequestHandler(RequestHandler requestHandler);

        void registerUnregisterHandler(UnregisterHandler unregisterHandler);

        void registerWildconnectHandler(WildconnectHandler wildconnectHandler);

        void registerXactCompleteHandler(XactCompleteHandler xactCompleteHandler);

        void unaccessData(Ddeml.HDDEDATA hddedata);

        boolean uninitialize();

        void unregisterAdvReqHandler(AdvreqHandler advreqHandler);

        void unregisterAdvdataHandler(AdvdataHandler advdataHandler);

        void unregisterAdvstartHandler(AdvstartHandler advstartHandler);

        void unregisterAdvstopHandler(AdvstopHandler advstopHandler);

        void unregisterConnectConfirmHandler(ConnectConfirmHandler connectConfirmHandler);

        void unregisterConnectHandler(ConnectHandler connectHandler);

        void unregisterDisconnectHandler(DisconnectHandler disconnectHandler);

        void unregisterErrorHandler(ErrorHandler errorHandler);

        void unregisterExecuteHandler(ExecuteHandler executeHandler);

        void unregisterMonitorHandler(MonitorHandler monitorHandler);

        void unregisterPokeHandler(PokeHandler pokeHandler);

        void unregisterRegisterHandler(RegisterHandler registerHandler);

        void unregisterRequestHandler(RequestHandler requestHandler);

        void unregisterUnregisterHandler(UnregisterHandler unregisterHandler);

        void unregisterWildconnectHandler(WildconnectHandler wildconnectHandler);

        void unregisterXactCompleteHandler(XactCompleteHandler xactCompleteHandler);

        IDdeConnection wrap(Ddeml.HCONV hconv);
    }

    public interface IDdeConnection extends Closeable {
        void abandonTransaction(int i);

        void abandonTransactions();

        void advstart(Ddeml.HSZ hsz, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr);

        void advstart(String str, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr);

        void advstop(Ddeml.HSZ hsz, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr);

        void advstop(String str, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr);

        Ddeml.HDDEDATA clientTransaction(Pointer pointer, int i, Ddeml.HSZ hsz, int i2, int i3, int i4, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr);

        Ddeml.HDDEDATA clientTransaction(Pointer pointer, int i, String str, int i2, int i3, int i4, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr);

        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();

        boolean enableCallback(int i);

        void execute(String str, int i, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr);

        Ddeml.HCONV getConv();

        void impersonateClient();

        void poke(Pointer pointer, int i, Ddeml.HSZ hsz, int i2, int i3, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr);

        void poke(Pointer pointer, int i, String str, int i2, int i3, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr);

        Ddeml.CONVINFO queryConvInfo(int i) throws DdemlException;

        void reconnect();

        Ddeml.HDDEDATA request(Ddeml.HSZ hsz, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr);

        Ddeml.HDDEDATA request(String str, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr);

        void setUserHandle(int i, BaseTSD.DWORD_PTR dword_ptr) throws DdemlException;
    }

    public interface IDdeConnectionList extends Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();

        Ddeml.HCONVLIST getHandle();

        IDdeConnection queryNextServer(IDdeConnection iDdeConnection);
    }

    public interface MonitorHandler {
        void onMonitor(int i, Ddeml.HDDEDATA hddedata, int i2);
    }

    public interface PokeHandler {
        int onPoke(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.HDDEDATA hddedata);
    }

    public interface RegisterHandler {
        void onRegister(int i, Ddeml.HSZ hsz, Ddeml.HSZ hsz2);
    }

    public interface RequestHandler {
        Ddeml.HDDEDATA onRequest(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2);
    }

    public interface UnregisterHandler {
        void onUnregister(int i, Ddeml.HSZ hsz, Ddeml.HSZ hsz2);
    }

    public interface WildconnectHandler {
        List<Ddeml.HSZPAIR> onWildconnect(int i, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.CONVCONTEXT convcontext, boolean z);
    }

    public interface XactCompleteHandler {
        void onXactComplete(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.HDDEDATA hddedata, BaseTSD.ULONG_PTR ulong_ptr, BaseTSD.ULONG_PTR ulong_ptr2);
    }

    public static class StandaloneDdeClient implements IDdeClient, Closeable {
        private final IDdeClient clientDelegate;
        private final IDdeClient ddeClient;
        private final User32Util.MessageLoopThread messageLoop;

        public StandaloneDdeClient() {
            User32Util.MessageLoopThread messageLoopThread = new User32Util.MessageLoopThread();
            this.messageLoop = messageLoopThread;
            DdeClient ddeClient = new DdeClient();
            this.ddeClient = ddeClient;
            this.clientDelegate = (IDdeClient) Proxy.newProxyInstance(StandaloneDdeClient.class.getClassLoader(), new Class[]{IDdeClient.class}, new MessageLoopWrapper(messageLoopThread, (IDdeClient) Proxy.newProxyInstance(StandaloneDdeClient.class.getClassLoader(), new Class[]{IDdeClient.class}, messageLoopThread.new Handler(ddeClient))));
            messageLoopThread.setDaemon(true);
            messageLoopThread.start();
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public Integer getInstanceIdentitifier() {
            return this.ddeClient.getInstanceIdentitifier();
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void initialize(int i) throws DdemlException {
            this.clientDelegate.initialize(i);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public Ddeml.HSZ createStringHandle(String str) throws DdemlException {
            return this.clientDelegate.createStringHandle(str);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void nameService(Ddeml.HSZ hsz, int i) throws DdemlException {
            this.clientDelegate.nameService(hsz, i);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public int getLastError() {
            return this.clientDelegate.getLastError();
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public IDdeConnection connect(Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.CONVCONTEXT convcontext) {
            return this.clientDelegate.connect(hsz, hsz2, convcontext);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public String queryString(Ddeml.HSZ hsz) throws DdemlException {
            return this.clientDelegate.queryString(hsz);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public Ddeml.HDDEDATA createDataHandle(Pointer pointer, int i, int i2, Ddeml.HSZ hsz, int i3, int i4) {
            return this.clientDelegate.createDataHandle(pointer, i, i2, hsz, i3, i4);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void freeDataHandle(Ddeml.HDDEDATA hddedata) {
            this.clientDelegate.freeDataHandle(hddedata);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public Ddeml.HDDEDATA addData(Ddeml.HDDEDATA hddedata, Pointer pointer, int i, int i2) {
            return this.clientDelegate.addData(hddedata, pointer, i, i2);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public int getData(Ddeml.HDDEDATA hddedata, Pointer pointer, int i, int i2) {
            return this.clientDelegate.getData(hddedata, pointer, i, i2);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public Pointer accessData(Ddeml.HDDEDATA hddedata, WinDef.DWORDByReference dWORDByReference) {
            return this.clientDelegate.accessData(hddedata, dWORDByReference);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unaccessData(Ddeml.HDDEDATA hddedata) {
            this.clientDelegate.unaccessData(hddedata);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void postAdvise(Ddeml.HSZ hsz, Ddeml.HSZ hsz2) {
            this.clientDelegate.postAdvise(hsz, hsz2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.clientDelegate.uninitialize();
            this.messageLoop.exit();
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public boolean freeStringHandle(Ddeml.HSZ hsz) {
            return this.clientDelegate.freeStringHandle(hsz);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public boolean keepStringHandle(Ddeml.HSZ hsz) {
            return this.clientDelegate.keepStringHandle(hsz);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void abandonTransactions() {
            this.clientDelegate.abandonTransactions();
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public IDdeConnectionList connectList(Ddeml.HSZ hsz, Ddeml.HSZ hsz2, IDdeConnectionList iDdeConnectionList, Ddeml.CONVCONTEXT convcontext) {
            return this.clientDelegate.connectList(hsz, hsz2, iDdeConnectionList, convcontext);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public boolean enableCallback(int i) {
            return this.clientDelegate.enableCallback(i);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public IDdeConnection wrap(Ddeml.HCONV hconv) {
            return this.clientDelegate.wrap(hconv);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public IDdeConnection connect(String str, String str2, Ddeml.CONVCONTEXT convcontext) {
            return this.clientDelegate.connect(str, str2, convcontext);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public boolean uninitialize() {
            return this.clientDelegate.uninitialize();
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void postAdvise(String str, String str2) {
            this.clientDelegate.postAdvise(str, str2);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public IDdeConnectionList connectList(String str, String str2, IDdeConnectionList iDdeConnectionList, Ddeml.CONVCONTEXT convcontext) {
            return this.clientDelegate.connectList(str, str2, iDdeConnectionList, convcontext);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void nameService(String str, int i) throws DdemlException {
            this.clientDelegate.nameService(str, i);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerAdvstartHandler(AdvstartHandler advstartHandler) {
            this.clientDelegate.registerAdvstartHandler(advstartHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterAdvstartHandler(AdvstartHandler advstartHandler) {
            this.clientDelegate.unregisterAdvstartHandler(advstartHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerAdvstopHandler(AdvstopHandler advstopHandler) {
            this.clientDelegate.registerAdvstopHandler(advstopHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterAdvstopHandler(AdvstopHandler advstopHandler) {
            this.clientDelegate.unregisterAdvstopHandler(advstopHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerConnectHandler(ConnectHandler connectHandler) {
            this.clientDelegate.registerConnectHandler(connectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterConnectHandler(ConnectHandler connectHandler) {
            this.clientDelegate.unregisterConnectHandler(connectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerAdvReqHandler(AdvreqHandler advreqHandler) {
            this.clientDelegate.registerAdvReqHandler(advreqHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterAdvReqHandler(AdvreqHandler advreqHandler) {
            this.clientDelegate.unregisterAdvReqHandler(advreqHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerRequestHandler(RequestHandler requestHandler) {
            this.clientDelegate.registerRequestHandler(requestHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterRequestHandler(RequestHandler requestHandler) {
            this.clientDelegate.unregisterRequestHandler(requestHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerWildconnectHandler(WildconnectHandler wildconnectHandler) {
            this.clientDelegate.registerWildconnectHandler(wildconnectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterWildconnectHandler(WildconnectHandler wildconnectHandler) {
            this.clientDelegate.unregisterWildconnectHandler(wildconnectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerAdvdataHandler(AdvdataHandler advdataHandler) {
            this.clientDelegate.registerAdvdataHandler(advdataHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterAdvdataHandler(AdvdataHandler advdataHandler) {
            this.clientDelegate.unregisterAdvdataHandler(advdataHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerExecuteHandler(ExecuteHandler executeHandler) {
            this.clientDelegate.registerExecuteHandler(executeHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterExecuteHandler(ExecuteHandler executeHandler) {
            this.clientDelegate.unregisterExecuteHandler(executeHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerPokeHandler(PokeHandler pokeHandler) {
            this.clientDelegate.registerPokeHandler(pokeHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterPokeHandler(PokeHandler pokeHandler) {
            this.clientDelegate.unregisterPokeHandler(pokeHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerConnectConfirmHandler(ConnectConfirmHandler connectConfirmHandler) {
            this.clientDelegate.registerConnectConfirmHandler(connectConfirmHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterConnectConfirmHandler(ConnectConfirmHandler connectConfirmHandler) {
            this.clientDelegate.unregisterConnectConfirmHandler(connectConfirmHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerDisconnectHandler(DisconnectHandler disconnectHandler) {
            this.clientDelegate.registerDisconnectHandler(disconnectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterDisconnectHandler(DisconnectHandler disconnectHandler) {
            this.clientDelegate.unregisterDisconnectHandler(disconnectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerErrorHandler(ErrorHandler errorHandler) {
            this.clientDelegate.registerErrorHandler(errorHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterErrorHandler(ErrorHandler errorHandler) {
            this.clientDelegate.unregisterErrorHandler(errorHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerRegisterHandler(RegisterHandler registerHandler) {
            this.clientDelegate.registerRegisterHandler(registerHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterRegisterHandler(RegisterHandler registerHandler) {
            this.clientDelegate.unregisterRegisterHandler(registerHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerXactCompleteHandler(XactCompleteHandler xactCompleteHandler) {
            this.clientDelegate.registerXactCompleteHandler(xactCompleteHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterXactCompleteHandler(XactCompleteHandler xactCompleteHandler) {
            this.clientDelegate.unregisterXactCompleteHandler(xactCompleteHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerUnregisterHandler(UnregisterHandler unregisterHandler) {
            this.clientDelegate.registerUnregisterHandler(unregisterHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterUnregisterHandler(UnregisterHandler unregisterHandler) {
            this.clientDelegate.unregisterUnregisterHandler(unregisterHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerMonitorHandler(MonitorHandler monitorHandler) {
            this.clientDelegate.registerMonitorHandler(monitorHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterMonitorHandler(MonitorHandler monitorHandler) {
            this.clientDelegate.unregisterMonitorHandler(monitorHandler);
        }
    }

    private static class MessageLoopWrapper implements InvocationHandler {
        private final Object delegate;
        private final User32Util.MessageLoopThread loopThread;

        public MessageLoopWrapper(User32Util.MessageLoopThread messageLoopThread, Object obj) {
            this.loopThread = messageLoopThread;
            this.delegate = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Exception {
            Class cls;
            try {
                Object objInvoke = method.invoke(this.delegate, objArr);
                if (objInvoke instanceof IDdeConnection) {
                    cls = IDdeConnection.class;
                } else if (objInvoke instanceof IDdeConnectionList) {
                    cls = IDdeConnectionList.class;
                } else {
                    cls = objInvoke instanceof IDdeClient ? IDdeClient.class : null;
                }
                return (cls == null || !method.getReturnType().isAssignableFrom(cls)) ? objInvoke : wrap(objInvoke, cls);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause instanceof Exception) {
                    throw ((Exception) cause);
                }
                throw e;
            }
        }

        private <V> V wrap(V v, Class cls) throws IllegalArgumentException {
            User32Util.MessageLoopThread messageLoopThread = this.loopThread;
            messageLoopThread.getClass();
            return (V) Proxy.newProxyInstance(StandaloneDdeClient.class.getClassLoader(), new Class[]{cls}, new MessageLoopWrapper(this.loopThread, Proxy.newProxyInstance(StandaloneDdeClient.class.getClassLoader(), new Class[]{cls}, messageLoopThread.new Handler(v))));
        }
    }

    public static class DdeConnection implements IDdeConnection {
        private final IDdeClient client;
        private Ddeml.HCONV conv;

        public DdeConnection(IDdeClient iDdeClient, Ddeml.HCONV hconv) {
            this.conv = hconv;
            this.client = iDdeClient;
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public Ddeml.HCONV getConv() {
            return this.conv;
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void abandonTransaction(int i) {
            if (!Ddeml.INSTANCE.DdeAbandonTransaction(this.client.getInstanceIdentitifier().intValue(), this.conv, i)) {
                throw DdemlException.create(this.client.getLastError());
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void abandonTransactions() {
            if (!Ddeml.INSTANCE.DdeAbandonTransaction(this.client.getInstanceIdentitifier().intValue(), this.conv, 0)) {
                throw DdemlException.create(this.client.getLastError());
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public Ddeml.HDDEDATA clientTransaction(Pointer pointer, int i, Ddeml.HSZ hsz, int i2, int i3, int i4, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr) throws DdemlException {
            WinDef.DWORDByReference dWORDByReference2 = (i4 == -1 && dWORDByReference == null) ? new WinDef.DWORDByReference() : dWORDByReference;
            Ddeml.HDDEDATA hddedataDdeClientTransaction = Ddeml.INSTANCE.DdeClientTransaction(pointer, i, this.conv, hsz, i2, i3, i4, dWORDByReference2);
            if (hddedataDdeClientTransaction == null) {
                throw DdemlException.create(this.client.getLastError());
            }
            if (dword_ptr != null) {
                if (i4 != -1) {
                    setUserHandle(-1, dword_ptr);
                } else {
                    setUserHandle(dWORDByReference2.getValue().intValue(), dword_ptr);
                }
            }
            return hddedataDdeClientTransaction;
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public Ddeml.HDDEDATA clientTransaction(Pointer pointer, int i, String str, int i2, int i3, int i4, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr) throws Throwable {
            Ddeml.HSZ hsz = null;
            try {
                Ddeml.HSZ hszCreateStringHandle = this.client.createStringHandle(str);
                try {
                    Ddeml.HDDEDATA hddedataClientTransaction = clientTransaction(pointer, i, hszCreateStringHandle, i2, i3, i4, dWORDByReference, dword_ptr);
                    this.client.freeStringHandle(hszCreateStringHandle);
                    return hddedataClientTransaction;
                } catch (Throwable th) {
                    th = th;
                    hsz = hszCreateStringHandle;
                    this.client.freeStringHandle(hsz);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void poke(Pointer pointer, int i, Ddeml.HSZ hsz, int i2, int i3, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr) throws DdemlException {
            clientTransaction(pointer, i, hsz, i2, Ddeml.XTYP_POKE, i3, dWORDByReference, dword_ptr);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void poke(Pointer pointer, int i, String str, int i2, int i3, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr) throws Throwable {
            Ddeml.HSZ hszCreateStringHandle;
            Ddeml.HSZ hsz = null;
            try {
                hszCreateStringHandle = this.client.createStringHandle(str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                poke(pointer, i, hszCreateStringHandle, i2, i3, dWORDByReference, dword_ptr);
                this.client.freeStringHandle(hszCreateStringHandle);
            } catch (Throwable th2) {
                th = th2;
                hsz = hszCreateStringHandle;
                this.client.freeStringHandle(hsz);
                throw th;
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public Ddeml.HDDEDATA request(Ddeml.HSZ hsz, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr) {
            return clientTransaction(Pointer.NULL, 0, hsz, i, 8368, i2, dWORDByReference, dword_ptr);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public Ddeml.HDDEDATA request(String str, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr) {
            Ddeml.HSZ hszCreateStringHandle = null;
            try {
                hszCreateStringHandle = this.client.createStringHandle(str);
                return request(hszCreateStringHandle, i, i2, dWORDByReference, dword_ptr);
            } finally {
                this.client.freeStringHandle(hszCreateStringHandle);
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void execute(String str, int i, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr) throws DdemlException {
            Memory memory = new Memory((str.length() * 2) + 2);
            memory.setWideString(0L, str);
            clientTransaction(memory, (int) memory.size(), (Ddeml.HSZ) null, 0, Ddeml.XTYP_EXECUTE, i, dWORDByReference, dword_ptr);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void advstart(Ddeml.HSZ hsz, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr) throws DdemlException {
            clientTransaction(Pointer.NULL, 0, hsz, i, Ddeml.XTYP_ADVSTART, i2, dWORDByReference, dword_ptr);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void advstart(String str, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr) {
            Ddeml.HSZ hszCreateStringHandle = null;
            try {
                hszCreateStringHandle = this.client.createStringHandle(str);
                advstart(hszCreateStringHandle, i, i2, dWORDByReference, dword_ptr);
            } finally {
                this.client.freeStringHandle(hszCreateStringHandle);
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void advstop(Ddeml.HSZ hsz, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr) throws DdemlException {
            clientTransaction(Pointer.NULL, 0, hsz, i, Ddeml.XTYP_ADVSTOP, i2, dWORDByReference, dword_ptr);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void advstop(String str, int i, int i2, WinDef.DWORDByReference dWORDByReference, BaseTSD.DWORD_PTR dword_ptr) {
            Ddeml.HSZ hszCreateStringHandle = null;
            try {
                hszCreateStringHandle = this.client.createStringHandle(str);
                advstop(hszCreateStringHandle, i, i2, dWORDByReference, dword_ptr);
            } finally {
                this.client.freeStringHandle(hszCreateStringHandle);
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void impersonateClient() {
            if (!Ddeml.INSTANCE.DdeImpersonateClient(this.conv)) {
                throw DdemlException.create(this.client.getLastError());
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!Ddeml.INSTANCE.DdeDisconnect(this.conv)) {
                throw DdemlException.create(this.client.getLastError());
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void reconnect() {
            Ddeml.HCONV hconvDdeReconnect = Ddeml.INSTANCE.DdeReconnect(this.conv);
            if (hconvDdeReconnect != null) {
                this.conv = hconvDdeReconnect;
                return;
            }
            throw DdemlException.create(this.client.getLastError());
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public boolean enableCallback(int i) {
            boolean zDdeEnableCallback = Ddeml.INSTANCE.DdeEnableCallback(this.client.getInstanceIdentitifier().intValue(), this.conv, i);
            if (zDdeEnableCallback || i != 2) {
                return zDdeEnableCallback;
            }
            throw DdemlException.create(this.client.getLastError());
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public void setUserHandle(int i, BaseTSD.DWORD_PTR dword_ptr) throws DdemlException {
            if (!Ddeml.INSTANCE.DdeSetUserHandle(this.conv, i, dword_ptr)) {
                throw DdemlException.create(this.client.getLastError());
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnection
        public Ddeml.CONVINFO queryConvInfo(int i) throws DdemlException {
            Ddeml.CONVINFO convinfo = new Ddeml.CONVINFO();
            convinfo.cb = convinfo.size();
            convinfo.ConvCtxt.cb = convinfo.ConvCtxt.size();
            convinfo.write();
            if (Ddeml.INSTANCE.DdeQueryConvInfo(this.conv, i, convinfo) != 0) {
                return convinfo;
            }
            throw DdemlException.create(this.client.getLastError());
        }
    }

    public static class DdeConnectionList implements IDdeConnectionList {
        private final IDdeClient client;
        private final Ddeml.HCONVLIST convList;

        public DdeConnectionList(IDdeClient iDdeClient, Ddeml.HCONVLIST hconvlist) {
            this.convList = hconvlist;
            this.client = iDdeClient;
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnectionList
        public Ddeml.HCONVLIST getHandle() {
            return this.convList;
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnectionList
        public IDdeConnection queryNextServer(IDdeConnection iDdeConnection) {
            Ddeml.HCONV hconvDdeQueryNextServer = Ddeml.INSTANCE.DdeQueryNextServer(this.convList, iDdeConnection != null ? iDdeConnection.getConv() : null);
            if (hconvDdeQueryNextServer != null) {
                return new DdeConnection(this.client, hconvDdeQueryNextServer);
            }
            return null;
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeConnectionList, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!Ddeml.INSTANCE.DdeDisconnectList(this.convList)) {
                throw DdemlException.create(this.client.getLastError());
            }
        }
    }

    public static class DdeClient implements IDdeClient {
        private final DdeAdapter ddeAdapter = new DdeAdapter();
        private Integer idInst;

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public Integer getInstanceIdentitifier() {
            return this.idInst;
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void initialize(int i) throws DdemlException {
            WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
            Integer numValueOf = Integer.valueOf(Ddeml.INSTANCE.DdeInitialize(dWORDByReference, this.ddeAdapter, i, 0));
            if (numValueOf.intValue() != 0) {
                throw DdemlException.create(numValueOf.intValue());
            }
            Integer numValueOf2 = Integer.valueOf(dWORDByReference.getValue().intValue());
            this.idInst = numValueOf2;
            DdeAdapter ddeAdapter = this.ddeAdapter;
            if (ddeAdapter instanceof DdeAdapter) {
                ddeAdapter.setInstanceIdentifier(numValueOf2.intValue());
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public Ddeml.HSZ createStringHandle(String str) throws DdemlException {
            if (str == null) {
                return null;
            }
            Ddeml.HSZ hszDdeCreateStringHandle = Ddeml.INSTANCE.DdeCreateStringHandle(this.idInst.intValue(), str, W32APIOptions.DEFAULT_OPTIONS == W32APIOptions.UNICODE_OPTIONS ? 1200 : 1004);
            if (hszDdeCreateStringHandle != null) {
                return hszDdeCreateStringHandle;
            }
            throw DdemlException.create(getLastError());
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void nameService(Ddeml.HSZ hsz, int i) throws DdemlException {
            if (Ddeml.INSTANCE.DdeNameService(this.idInst.intValue(), hsz, new Ddeml.HSZ(), i) == null) {
                throw DdemlException.create(getLastError());
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void nameService(String str, int i) throws Throwable {
            Ddeml.HSZ hszCreateStringHandle;
            try {
                hszCreateStringHandle = createStringHandle(str);
                try {
                    nameService(hszCreateStringHandle, i);
                    freeStringHandle(hszCreateStringHandle);
                } catch (Throwable th) {
                    th = th;
                    freeStringHandle(hszCreateStringHandle);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                hszCreateStringHandle = null;
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public int getLastError() {
            return Ddeml.INSTANCE.DdeGetLastError(this.idInst.intValue());
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public IDdeConnection connect(Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.CONVCONTEXT convcontext) {
            Ddeml.HCONV hconvDdeConnect = Ddeml.INSTANCE.DdeConnect(this.idInst.intValue(), hsz, hsz2, convcontext);
            if (hconvDdeConnect == null) {
                throw DdemlException.create(getLastError());
            }
            return new DdeConnection(this, hconvDdeConnect);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public IDdeConnection connect(String str, String str2, Ddeml.CONVCONTEXT convcontext) throws Throwable {
            Ddeml.HSZ hszCreateStringHandle;
            Ddeml.HSZ hszCreateStringHandle2 = null;
            try {
                hszCreateStringHandle = createStringHandle(str);
                try {
                    hszCreateStringHandle2 = createStringHandle(str2);
                    IDdeConnection iDdeConnectionConnect = connect(hszCreateStringHandle, hszCreateStringHandle2, convcontext);
                    freeStringHandle(hszCreateStringHandle2);
                    freeStringHandle(hszCreateStringHandle);
                    return iDdeConnectionConnect;
                } catch (Throwable th) {
                    th = th;
                    freeStringHandle(hszCreateStringHandle2);
                    freeStringHandle(hszCreateStringHandle);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                hszCreateStringHandle = null;
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public String queryString(Ddeml.HSZ hsz) throws DdemlException {
            int i;
            int i2;
            if (W32APIOptions.DEFAULT_OPTIONS == W32APIOptions.UNICODE_OPTIONS) {
                i = 1200;
                i2 = 2;
            } else {
                i = 1004;
                i2 = 1;
            }
            int i3 = i;
            Memory memory = new Memory(i2 * 257);
            try {
                Ddeml.INSTANCE.DdeQueryString(this.idInst.intValue(), hsz, memory, 256, i3);
                if (W32APIOptions.DEFAULT_OPTIONS == W32APIOptions.UNICODE_OPTIONS) {
                    return memory.getWideString(0L);
                }
                return memory.getString(0L);
            } finally {
                memory.valid();
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public Ddeml.HDDEDATA createDataHandle(Pointer pointer, int i, int i2, Ddeml.HSZ hsz, int i3, int i4) {
            Ddeml.HDDEDATA hddedataDdeCreateDataHandle = Ddeml.INSTANCE.DdeCreateDataHandle(this.idInst.intValue(), pointer, i, i2, hsz, i3, i4);
            if (hddedataDdeCreateDataHandle != null) {
                return hddedataDdeCreateDataHandle;
            }
            throw DdemlException.create(getLastError());
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void freeDataHandle(Ddeml.HDDEDATA hddedata) {
            if (!Ddeml.INSTANCE.DdeFreeDataHandle(hddedata)) {
                throw DdemlException.create(getLastError());
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public Ddeml.HDDEDATA addData(Ddeml.HDDEDATA hddedata, Pointer pointer, int i, int i2) {
            Ddeml.HDDEDATA hddedataDdeAddData = Ddeml.INSTANCE.DdeAddData(hddedata, pointer, i, i2);
            if (hddedataDdeAddData != null) {
                return hddedataDdeAddData;
            }
            throw DdemlException.create(getLastError());
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public int getData(Ddeml.HDDEDATA hddedata, Pointer pointer, int i, int i2) {
            int iDdeGetData = Ddeml.INSTANCE.DdeGetData(hddedata, pointer, i, i2);
            int lastError = getLastError();
            if (lastError == 0) {
                return iDdeGetData;
            }
            throw DdemlException.create(lastError);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public Pointer accessData(Ddeml.HDDEDATA hddedata, WinDef.DWORDByReference dWORDByReference) {
            Pointer pointerDdeAccessData = Ddeml.INSTANCE.DdeAccessData(hddedata, dWORDByReference);
            if (pointerDdeAccessData != null) {
                return pointerDdeAccessData;
            }
            throw DdemlException.create(getLastError());
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unaccessData(Ddeml.HDDEDATA hddedata) {
            if (!Ddeml.INSTANCE.DdeUnaccessData(hddedata)) {
                throw DdemlException.create(getLastError());
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void postAdvise(Ddeml.HSZ hsz, Ddeml.HSZ hsz2) {
            if (!Ddeml.INSTANCE.DdePostAdvise(this.idInst.intValue(), hsz, hsz2)) {
                throw DdemlException.create(getLastError());
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void postAdvise(String str, String str2) throws Throwable {
            Ddeml.HSZ hsz;
            Ddeml.HSZ hszCreateStringHandle = null;
            try {
                Ddeml.HSZ hszCreateStringHandle2 = createStringHandle(str);
                try {
                    hszCreateStringHandle = createStringHandle(str2);
                    postAdvise(hszCreateStringHandle2, hszCreateStringHandle);
                    freeStringHandle(hszCreateStringHandle2);
                    freeStringHandle(hszCreateStringHandle);
                } catch (Throwable th) {
                    th = th;
                    Ddeml.HSZ hsz2 = hszCreateStringHandle;
                    hszCreateStringHandle = hszCreateStringHandle2;
                    hsz = hsz2;
                    freeStringHandle(hszCreateStringHandle);
                    freeStringHandle(hsz);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                hsz = null;
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public boolean freeStringHandle(Ddeml.HSZ hsz) {
            if (hsz == null) {
                return true;
            }
            return Ddeml.INSTANCE.DdeFreeStringHandle(this.idInst.intValue(), hsz);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public boolean keepStringHandle(Ddeml.HSZ hsz) {
            return Ddeml.INSTANCE.DdeKeepStringHandle(this.idInst.intValue(), hsz);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void abandonTransactions() {
            if (!Ddeml.INSTANCE.DdeAbandonTransaction(this.idInst.intValue(), null, 0)) {
                throw DdemlException.create(getLastError());
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public IDdeConnectionList connectList(Ddeml.HSZ hsz, Ddeml.HSZ hsz2, IDdeConnectionList iDdeConnectionList, Ddeml.CONVCONTEXT convcontext) {
            Ddeml.HCONVLIST hconvlistDdeConnectList = Ddeml.INSTANCE.DdeConnectList(this.idInst.intValue(), hsz, hsz2, iDdeConnectionList != null ? iDdeConnectionList.getHandle() : null, convcontext);
            if (hconvlistDdeConnectList == null) {
                throw DdemlException.create(getLastError());
            }
            return new DdeConnectionList(this, hconvlistDdeConnectList);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public IDdeConnectionList connectList(String str, String str2, IDdeConnectionList iDdeConnectionList, Ddeml.CONVCONTEXT convcontext) throws Throwable {
            Ddeml.HSZ hszCreateStringHandle;
            Ddeml.HSZ hszCreateStringHandle2 = null;
            try {
                hszCreateStringHandle = createStringHandle(str);
                try {
                    hszCreateStringHandle2 = createStringHandle(str2);
                    IDdeConnectionList iDdeConnectionListConnectList = connectList(hszCreateStringHandle, hszCreateStringHandle2, iDdeConnectionList, convcontext);
                    freeStringHandle(hszCreateStringHandle2);
                    freeStringHandle(hszCreateStringHandle);
                    return iDdeConnectionListConnectList;
                } catch (Throwable th) {
                    th = th;
                    freeStringHandle(hszCreateStringHandle2);
                    freeStringHandle(hszCreateStringHandle);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                hszCreateStringHandle = null;
            }
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public boolean enableCallback(int i) {
            boolean zDdeEnableCallback = Ddeml.INSTANCE.DdeEnableCallback(this.idInst.intValue(), null, i);
            if (zDdeEnableCallback || i == 2 || getLastError() == 0) {
                return zDdeEnableCallback;
            }
            throw DdemlException.create(getLastError());
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public boolean uninitialize() {
            return Ddeml.INSTANCE.DdeUninitialize(this.idInst.intValue());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            uninitialize();
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public IDdeConnection wrap(Ddeml.HCONV hconv) {
            return new DdeConnection(this, hconv);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterDisconnectHandler(DisconnectHandler disconnectHandler) {
            this.ddeAdapter.unregisterDisconnectHandler(disconnectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerAdvstartHandler(AdvstartHandler advstartHandler) {
            this.ddeAdapter.registerAdvstartHandler(advstartHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterAdvstartHandler(AdvstartHandler advstartHandler) {
            this.ddeAdapter.unregisterAdvstartHandler(advstartHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerAdvstopHandler(AdvstopHandler advstopHandler) {
            this.ddeAdapter.registerAdvstopHandler(advstopHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterAdvstopHandler(AdvstopHandler advstopHandler) {
            this.ddeAdapter.unregisterAdvstopHandler(advstopHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerConnectHandler(ConnectHandler connectHandler) {
            this.ddeAdapter.registerConnectHandler(connectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterConnectHandler(ConnectHandler connectHandler) {
            this.ddeAdapter.unregisterConnectHandler(connectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerAdvReqHandler(AdvreqHandler advreqHandler) {
            this.ddeAdapter.registerAdvReqHandler(advreqHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterAdvReqHandler(AdvreqHandler advreqHandler) {
            this.ddeAdapter.unregisterAdvReqHandler(advreqHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerRequestHandler(RequestHandler requestHandler) {
            this.ddeAdapter.registerRequestHandler(requestHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterRequestHandler(RequestHandler requestHandler) {
            this.ddeAdapter.unregisterRequestHandler(requestHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerWildconnectHandler(WildconnectHandler wildconnectHandler) {
            this.ddeAdapter.registerWildconnectHandler(wildconnectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterWildconnectHandler(WildconnectHandler wildconnectHandler) {
            this.ddeAdapter.unregisterWildconnectHandler(wildconnectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerAdvdataHandler(AdvdataHandler advdataHandler) {
            this.ddeAdapter.registerAdvdataHandler(advdataHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterAdvdataHandler(AdvdataHandler advdataHandler) {
            this.ddeAdapter.unregisterAdvdataHandler(advdataHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerExecuteHandler(ExecuteHandler executeHandler) {
            this.ddeAdapter.registerExecuteHandler(executeHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterExecuteHandler(ExecuteHandler executeHandler) {
            this.ddeAdapter.unregisterExecuteHandler(executeHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerPokeHandler(PokeHandler pokeHandler) {
            this.ddeAdapter.registerPokeHandler(pokeHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterPokeHandler(PokeHandler pokeHandler) {
            this.ddeAdapter.unregisterPokeHandler(pokeHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerConnectConfirmHandler(ConnectConfirmHandler connectConfirmHandler) {
            this.ddeAdapter.registerConnectConfirmHandler(connectConfirmHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterConnectConfirmHandler(ConnectConfirmHandler connectConfirmHandler) {
            this.ddeAdapter.unregisterConnectConfirmHandler(connectConfirmHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerDisconnectHandler(DisconnectHandler disconnectHandler) {
            this.ddeAdapter.registerDisconnectHandler(disconnectHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerErrorHandler(ErrorHandler errorHandler) {
            this.ddeAdapter.registerErrorHandler(errorHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterErrorHandler(ErrorHandler errorHandler) {
            this.ddeAdapter.unregisterErrorHandler(errorHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerRegisterHandler(RegisterHandler registerHandler) {
            this.ddeAdapter.registerRegisterHandler(registerHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterRegisterHandler(RegisterHandler registerHandler) {
            this.ddeAdapter.unregisterRegisterHandler(registerHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerXactCompleteHandler(XactCompleteHandler xactCompleteHandler) {
            this.ddeAdapter.registerXactCompleteHandler(xactCompleteHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterXactCompleteHandler(XactCompleteHandler xactCompleteHandler) {
            this.ddeAdapter.xactCompleteXactCompleteHandler(xactCompleteHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerUnregisterHandler(UnregisterHandler unregisterHandler) {
            this.ddeAdapter.registerUnregisterHandler(unregisterHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterUnregisterHandler(UnregisterHandler unregisterHandler) {
            this.ddeAdapter.unregisterUnregisterHandler(unregisterHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void registerMonitorHandler(MonitorHandler monitorHandler) {
            this.ddeAdapter.registerMonitorHandler(monitorHandler);
        }

        @Override // com.sun.jna.platform.win32.DdemlUtil.IDdeClient
        public void unregisterMonitorHandler(MonitorHandler monitorHandler) {
            this.ddeAdapter.unregisterMonitorHandler(monitorHandler);
        }
    }

    public static class DdeAdapter implements Ddeml.DdeCallback {
        private static final Logger LOG = Logger.getLogger(DdeAdapter.class.getName());
        private int idInst;
        private final List<AdvstartHandler> advstartHandler = new CopyOnWriteArrayList();
        private final List<AdvstopHandler> advstopHandler = new CopyOnWriteArrayList();
        private final List<ConnectHandler> connectHandler = new CopyOnWriteArrayList();
        private final List<AdvreqHandler> advReqHandler = new CopyOnWriteArrayList();
        private final List<RequestHandler> requestHandler = new CopyOnWriteArrayList();
        private final List<WildconnectHandler> wildconnectHandler = new CopyOnWriteArrayList();
        private final List<AdvdataHandler> advdataHandler = new CopyOnWriteArrayList();
        private final List<ExecuteHandler> executeHandler = new CopyOnWriteArrayList();
        private final List<PokeHandler> pokeHandler = new CopyOnWriteArrayList();
        private final List<ConnectConfirmHandler> connectConfirmHandler = new CopyOnWriteArrayList();
        private final List<DisconnectHandler> disconnectHandler = new CopyOnWriteArrayList();
        private final List<ErrorHandler> errorHandler = new CopyOnWriteArrayList();
        private final List<RegisterHandler> registerHandler = new CopyOnWriteArrayList();
        private final List<XactCompleteHandler> xactCompleteHandler = new CopyOnWriteArrayList();
        private final List<UnregisterHandler> unregisterHandler = new CopyOnWriteArrayList();
        private final List<MonitorHandler> monitorHandler = new CopyOnWriteArrayList();

        public static class BlockException extends RuntimeException {
        }

        public void setInstanceIdentifier(int i) {
            this.idInst = i;
        }

        @Override // com.sun.jna.platform.win32.Ddeml.DdeCallback
        public WinDef.PVOID ddeCallback(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.HDDEDATA hddedata, BaseTSD.ULONG_PTR ulong_ptr, BaseTSD.ULONG_PTR ulong_ptr2) {
            boolean z = true;
            boolean z2 = false;
            try {
                switch (i) {
                    case Ddeml.XTYP_ADVSTART /* 4144 */:
                        return new WinDef.PVOID(Pointer.createConstant(new WinDef.BOOL(onAdvstart(i, i2, hconv, hsz, hsz2)).intValue()));
                    case Ddeml.XTYP_CONNECT /* 4194 */:
                        Ddeml.CONVCONTEXT convcontext = ulong_ptr.toPointer() != null ? new Ddeml.CONVCONTEXT(new Pointer(ulong_ptr.longValue())) : null;
                        if (ulong_ptr2 != null && ulong_ptr2.intValue() != 0) {
                            z2 = true;
                        }
                        return new WinDef.PVOID(Pointer.createConstant(new WinDef.BOOL(onConnect(i, hsz, hsz2, convcontext, z2)).intValue()));
                    case 8226:
                        Ddeml.HDDEDATA hddedataOnAdvreq = onAdvreq(i, i2, hconv, hsz, hsz2, ulong_ptr.intValue() & 65535);
                        if (hddedataOnAdvreq == null) {
                            return new WinDef.PVOID();
                        }
                        return new WinDef.PVOID(hddedataOnAdvreq.getPointer());
                    case 8368:
                        Ddeml.HDDEDATA hddedataOnRequest = onRequest(i, i2, hconv, hsz, hsz2);
                        if (hddedataOnRequest == null) {
                            return new WinDef.PVOID();
                        }
                        return new WinDef.PVOID(hddedataOnRequest.getPointer());
                    case 8418:
                        Ddeml.HSZPAIR[] hszpairArrOnWildconnect = onWildconnect(i, hsz, hsz2, ulong_ptr.toPointer() != null ? new Ddeml.CONVCONTEXT(new Pointer(ulong_ptr.longValue())) : null, (ulong_ptr2 == null || ulong_ptr2.intValue() == 0) ? false : true);
                        if (hszpairArrOnWildconnect != null && hszpairArrOnWildconnect.length != 0) {
                            int size = 0;
                            for (Ddeml.HSZPAIR hszpair : hszpairArrOnWildconnect) {
                                hszpair.write();
                                size += hszpair.size();
                            }
                            return new WinDef.PVOID(Ddeml.INSTANCE.DdeCreateDataHandle(this.idInst, hszpairArrOnWildconnect[0].getPointer(), size, 0, null, i2, 0).getPointer());
                        }
                        return new WinDef.PVOID();
                    case 16400:
                        return new WinDef.PVOID(Pointer.createConstant(onAdvdata(i, i2, hconv, hsz, hsz2, hddedata)));
                    case Ddeml.XTYP_EXECUTE /* 16464 */:
                        int iOnExecute = onExecute(i, hconv, hsz, hddedata);
                        Ddeml.INSTANCE.DdeFreeDataHandle(hddedata);
                        return new WinDef.PVOID(Pointer.createConstant(iOnExecute));
                    case Ddeml.XTYP_POKE /* 16528 */:
                        return new WinDef.PVOID(Pointer.createConstant(onPoke(i, i2, hconv, hsz, hsz2, hddedata)));
                    case 32770:
                        onError(i, hconv, (int) (ulong_ptr2.longValue() & WebSocketProtocol.PAYLOAD_SHORT_MAX));
                        break;
                    case Ddeml.XTYP_ADVSTOP /* 32832 */:
                        onAdvstop(i, i2, hconv, hsz, hsz2);
                        break;
                    case Ddeml.XTYP_CONNECT_CONFIRM /* 32882 */:
                        if (ulong_ptr2 != null && ulong_ptr2.intValue() != 0) {
                            z2 = true;
                        }
                        onConnectConfirm(i, hconv, hsz, hsz2, z2);
                        break;
                    case Ddeml.XTYP_XACT_COMPLETE /* 32896 */:
                        onXactComplete(i, i2, hconv, hsz, hsz2, hddedata, ulong_ptr, ulong_ptr2);
                        break;
                    case Ddeml.XTYP_REGISTER /* 32930 */:
                        onRegister(i, hsz, hsz2);
                        break;
                    case Ddeml.XTYP_DISCONNECT /* 32962 */:
                        if (ulong_ptr2 == null || ulong_ptr2.intValue() == 0) {
                            z = false;
                        }
                        onDisconnect(i, hconv, z);
                        break;
                    case Ddeml.XTYP_UNREGISTER /* 32978 */:
                        onUnregister(i, hsz, hsz2);
                        break;
                    case Ddeml.XTYP_MONITOR /* 33010 */:
                        onMonitor(i, hddedata, ulong_ptr2.intValue());
                        break;
                    default:
                        LOG.log(Level.FINE, String.format("Not implemented Operation - Transaction type: 0x%X (%s)", Integer.valueOf(i), null));
                        break;
                }
            } catch (BlockException unused) {
                return new WinDef.PVOID(Pointer.createConstant(-1));
            } catch (Throwable th) {
                LOG.log(Level.WARNING, "Exception in DDECallback", th);
            }
            return new WinDef.PVOID();
        }

        public void registerAdvstartHandler(AdvstartHandler advstartHandler) {
            this.advstartHandler.add(advstartHandler);
        }

        public void unregisterAdvstartHandler(AdvstartHandler advstartHandler) {
            this.advstartHandler.remove(advstartHandler);
        }

        private boolean onAdvstart(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2) {
            Iterator<AdvstartHandler> it = this.advstartHandler.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next().onAdvstart(i, i2, hconv, hsz, hsz2)) {
                    z = true;
                }
            }
            return z;
        }

        public void registerAdvstopHandler(AdvstopHandler advstopHandler) {
            this.advstopHandler.add(advstopHandler);
        }

        public void unregisterAdvstopHandler(AdvstopHandler advstopHandler) {
            this.advstopHandler.remove(advstopHandler);
        }

        private void onAdvstop(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2) {
            Iterator<AdvstopHandler> it = this.advstopHandler.iterator();
            while (it.hasNext()) {
                it.next().onAdvstop(i, i2, hconv, hsz, hsz2);
            }
        }

        public void registerConnectHandler(ConnectHandler connectHandler) {
            this.connectHandler.add(connectHandler);
        }

        public void unregisterConnectHandler(ConnectHandler connectHandler) {
            this.connectHandler.remove(connectHandler);
        }

        private boolean onConnect(int i, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.CONVCONTEXT convcontext, boolean z) {
            Iterator<ConnectHandler> it = this.connectHandler.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                if (it.next().onConnect(i, hsz, hsz2, convcontext, z)) {
                    z2 = true;
                }
            }
            return z2;
        }

        public void registerAdvReqHandler(AdvreqHandler advreqHandler) {
            this.advReqHandler.add(advreqHandler);
        }

        public void unregisterAdvReqHandler(AdvreqHandler advreqHandler) {
            this.advReqHandler.remove(advreqHandler);
        }

        private Ddeml.HDDEDATA onAdvreq(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, int i3) {
            Iterator<AdvreqHandler> it = this.advReqHandler.iterator();
            while (it.hasNext()) {
                Ddeml.HDDEDATA hddedataOnAdvreq = it.next().onAdvreq(i, i2, hconv, hsz, hsz2, i3);
                if (hddedataOnAdvreq != null) {
                    return hddedataOnAdvreq;
                }
            }
            return null;
        }

        public void registerRequestHandler(RequestHandler requestHandler) {
            this.requestHandler.add(requestHandler);
        }

        public void unregisterRequestHandler(RequestHandler requestHandler) {
            this.requestHandler.remove(requestHandler);
        }

        private Ddeml.HDDEDATA onRequest(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2) {
            Iterator<RequestHandler> it = this.requestHandler.iterator();
            while (it.hasNext()) {
                Ddeml.HDDEDATA hddedataOnRequest = it.next().onRequest(i, i2, hconv, hsz, hsz2);
                if (hddedataOnRequest != null) {
                    return hddedataOnRequest;
                }
            }
            return null;
        }

        public void registerWildconnectHandler(WildconnectHandler wildconnectHandler) {
            this.wildconnectHandler.add(wildconnectHandler);
        }

        public void unregisterWildconnectHandler(WildconnectHandler wildconnectHandler) {
            this.wildconnectHandler.remove(wildconnectHandler);
        }

        private Ddeml.HSZPAIR[] onWildconnect(int i, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.CONVCONTEXT convcontext, boolean z) {
            ArrayList arrayList = new ArrayList(1);
            Iterator<WildconnectHandler> it = this.wildconnectHandler.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().onWildconnect(i, hsz, hsz2, convcontext, z));
            }
            return (Ddeml.HSZPAIR[]) arrayList.toArray(new Ddeml.HSZPAIR[0]);
        }

        public void registerAdvdataHandler(AdvdataHandler advdataHandler) {
            this.advdataHandler.add(advdataHandler);
        }

        public void unregisterAdvdataHandler(AdvdataHandler advdataHandler) {
            this.advdataHandler.remove(advdataHandler);
        }

        private int onAdvdata(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.HDDEDATA hddedata) {
            Iterator<AdvdataHandler> it = this.advdataHandler.iterator();
            while (it.hasNext()) {
                int iOnAdvdata = it.next().onAdvdata(i, i2, hconv, hsz, hsz2, hddedata);
                if (iOnAdvdata != 0) {
                    return iOnAdvdata;
                }
            }
            return 0;
        }

        public void registerExecuteHandler(ExecuteHandler executeHandler) {
            this.executeHandler.add(executeHandler);
        }

        public void unregisterExecuteHandler(ExecuteHandler executeHandler) {
            this.executeHandler.remove(executeHandler);
        }

        private int onExecute(int i, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HDDEDATA hddedata) {
            Iterator<ExecuteHandler> it = this.executeHandler.iterator();
            while (it.hasNext()) {
                int iOnExecute = it.next().onExecute(i, hconv, hsz, hddedata);
                if (iOnExecute != 0) {
                    return iOnExecute;
                }
            }
            return 0;
        }

        public void registerPokeHandler(PokeHandler pokeHandler) {
            this.pokeHandler.add(pokeHandler);
        }

        public void unregisterPokeHandler(PokeHandler pokeHandler) {
            this.pokeHandler.remove(pokeHandler);
        }

        private int onPoke(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.HDDEDATA hddedata) {
            Iterator<PokeHandler> it = this.pokeHandler.iterator();
            while (it.hasNext()) {
                int iOnPoke = it.next().onPoke(i, i2, hconv, hsz, hsz2, hddedata);
                if (iOnPoke != 0) {
                    return iOnPoke;
                }
            }
            return 0;
        }

        public void registerConnectConfirmHandler(ConnectConfirmHandler connectConfirmHandler) {
            this.connectConfirmHandler.add(connectConfirmHandler);
        }

        public void unregisterConnectConfirmHandler(ConnectConfirmHandler connectConfirmHandler) {
            this.connectConfirmHandler.remove(connectConfirmHandler);
        }

        private void onConnectConfirm(int i, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, boolean z) {
            Iterator<ConnectConfirmHandler> it = this.connectConfirmHandler.iterator();
            while (it.hasNext()) {
                it.next().onConnectConfirm(i, hconv, hsz, hsz2, z);
            }
        }

        public void registerDisconnectHandler(DisconnectHandler disconnectHandler) {
            this.disconnectHandler.add(disconnectHandler);
        }

        public void unregisterDisconnectHandler(DisconnectHandler disconnectHandler) {
            this.disconnectHandler.remove(disconnectHandler);
        }

        private void onDisconnect(int i, Ddeml.HCONV hconv, boolean z) {
            Iterator<DisconnectHandler> it = this.disconnectHandler.iterator();
            while (it.hasNext()) {
                it.next().onDisconnect(i, hconv, z);
            }
        }

        public void registerErrorHandler(ErrorHandler errorHandler) {
            this.errorHandler.add(errorHandler);
        }

        public void unregisterErrorHandler(ErrorHandler errorHandler) {
            this.errorHandler.remove(errorHandler);
        }

        private void onError(int i, Ddeml.HCONV hconv, int i2) {
            Iterator<ErrorHandler> it = this.errorHandler.iterator();
            while (it.hasNext()) {
                it.next().onError(i, hconv, i2);
            }
        }

        public void registerRegisterHandler(RegisterHandler registerHandler) {
            this.registerHandler.add(registerHandler);
        }

        public void unregisterRegisterHandler(RegisterHandler registerHandler) {
            this.registerHandler.remove(registerHandler);
        }

        private void onRegister(int i, Ddeml.HSZ hsz, Ddeml.HSZ hsz2) {
            Iterator<RegisterHandler> it = this.registerHandler.iterator();
            while (it.hasNext()) {
                it.next().onRegister(i, hsz, hsz2);
            }
        }

        public void registerXactCompleteHandler(XactCompleteHandler xactCompleteHandler) {
            this.xactCompleteHandler.add(xactCompleteHandler);
        }

        public void xactCompleteXactCompleteHandler(XactCompleteHandler xactCompleteHandler) {
            this.xactCompleteHandler.remove(xactCompleteHandler);
        }

        private void onXactComplete(int i, int i2, Ddeml.HCONV hconv, Ddeml.HSZ hsz, Ddeml.HSZ hsz2, Ddeml.HDDEDATA hddedata, BaseTSD.ULONG_PTR ulong_ptr, BaseTSD.ULONG_PTR ulong_ptr2) {
            Iterator<XactCompleteHandler> it = this.xactCompleteHandler.iterator();
            while (it.hasNext()) {
                it.next().onXactComplete(i, i2, hconv, hsz, hsz2, hddedata, ulong_ptr, ulong_ptr2);
            }
        }

        public void registerUnregisterHandler(UnregisterHandler unregisterHandler) {
            this.unregisterHandler.add(unregisterHandler);
        }

        public void unregisterUnregisterHandler(UnregisterHandler unregisterHandler) {
            this.unregisterHandler.remove(unregisterHandler);
        }

        private void onUnregister(int i, Ddeml.HSZ hsz, Ddeml.HSZ hsz2) {
            Iterator<UnregisterHandler> it = this.unregisterHandler.iterator();
            while (it.hasNext()) {
                it.next().onUnregister(i, hsz, hsz2);
            }
        }

        public void registerMonitorHandler(MonitorHandler monitorHandler) {
            this.monitorHandler.add(monitorHandler);
        }

        public void unregisterMonitorHandler(MonitorHandler monitorHandler) {
            this.monitorHandler.remove(monitorHandler);
        }

        private void onMonitor(int i, Ddeml.HDDEDATA hddedata, int i2) {
            Iterator<MonitorHandler> it = this.monitorHandler.iterator();
            while (it.hasNext()) {
                it.next().onMonitor(i, hddedata, i2);
            }
        }
    }

    public static class DdemlException extends RuntimeException {
        private static final Map<Integer, String> ERROR_CODE_MAP;
        private final int errorCode;

        static {
            HashMap map = new HashMap();
            for (Field field : Ddeml.class.getFields()) {
                String name = field.getName();
                if (name.startsWith("DMLERR_") && !name.equals("DMLERR_FIRST") && !name.equals("DMLERR_LAST")) {
                    try {
                        map.put(Integer.valueOf(field.getInt(null)), name);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalArgumentException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
            ERROR_CODE_MAP = Collections.unmodifiableMap(map);
        }

        public static DdemlException create(int i) {
            String str = ERROR_CODE_MAP.get(Integer.valueOf(i));
            if (str == null) {
                str = "";
            }
            return new DdemlException(i, String.format("%s (Code: 0x%X)", str, Integer.valueOf(i)));
        }

        public DdemlException(int i, String str) {
            super(str);
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }
}
