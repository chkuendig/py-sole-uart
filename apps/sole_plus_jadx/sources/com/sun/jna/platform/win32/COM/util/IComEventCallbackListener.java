package com.sun.jna.platform.win32.COM.util;

import com.sun.jna.platform.win32.COM.IDispatchCallback;

/* loaded from: classes4.dex */
public interface IComEventCallbackListener {
    void errorReceivingCallbackEvent(String str, Exception exc);

    void setDispatchCallbackListener(IDispatchCallback iDispatchCallback);
}
