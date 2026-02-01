package com.sun.jna.platform;

import com.sun.jna.Platform;
import com.sun.jna.platform.unix.X11;
import com.sun.jna.platform.win32.User32;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import kotlin.jvm.internal.ShortCompanionObject;

/* loaded from: classes4.dex */
public class KeyboardUtils {
    static final NativeKeyboardUtils INSTANCE;

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.awt.HeadlessException */
    static {
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException("KeyboardUtils requires a keyboard");
        }
        if (Platform.isWindows()) {
            INSTANCE = new W32KeyboardUtils();
        } else {
            if (Platform.isMac()) {
                INSTANCE = new MacKeyboardUtils();
                throw new UnsupportedOperationException("No support (yet) for " + System.getProperty("os.name"));
            }
            INSTANCE = new X11KeyboardUtils();
        }
    }

    public static boolean isPressed(int i, int i2) {
        return INSTANCE.isPressed(i, i2);
    }

    public static boolean isPressed(int i) {
        return INSTANCE.isPressed(i);
    }

    private static abstract class NativeKeyboardUtils {
        public abstract boolean isPressed(int i, int i2);

        private NativeKeyboardUtils() {
        }

        public boolean isPressed(int i) {
            return isPressed(i, 0);
        }
    }

    private static class W32KeyboardUtils extends NativeKeyboardUtils {
        private int toNative(int i, int i2) {
            if ((i >= 65 && i <= 90) || (i >= 48 && i <= 57)) {
                return i;
            }
            if (i == 16) {
                if ((i2 & 3) != 0) {
                    return 161;
                }
                return (i2 & 2) != 0 ? 160 : 16;
            }
            if (i == 17) {
                if ((i2 & 3) != 0) {
                    return 163;
                }
                return (i2 & 2) != 0 ? 162 : 17;
            }
            if (i != 18) {
                return 0;
            }
            if ((i2 & 3) != 0) {
                return 165;
            }
            return (i2 & 2) != 0 ? 164 : 18;
        }

        private W32KeyboardUtils() {
            super();
        }

        @Override // com.sun.jna.platform.KeyboardUtils.NativeKeyboardUtils
        public boolean isPressed(int i, int i2) {
            return (User32.INSTANCE.GetAsyncKeyState(toNative(i, i2)) & ShortCompanionObject.MIN_VALUE) != 0;
        }
    }

    private static class MacKeyboardUtils extends NativeKeyboardUtils {
        @Override // com.sun.jna.platform.KeyboardUtils.NativeKeyboardUtils
        public boolean isPressed(int i, int i2) {
            return false;
        }

        private MacKeyboardUtils() {
            super();
        }
    }

    private static class X11KeyboardUtils extends NativeKeyboardUtils {
        private int toKeySym(int i, int i2) {
            if (i >= 65 && i <= 90) {
                return i + 32;
            }
            if (i >= 48 && i <= 57) {
                return i;
            }
            if (i == 16) {
                return 65505;
            }
            if (i == 17) {
                if ((i2 & 3) != 0) {
                    return X11.XK_Control_R;
                }
                return 65507;
            }
            if (i == 18) {
                return (i2 & 3) != 0 ? X11.XK_Alt_R : X11.XK_Alt_L;
            }
            if (i == 157) {
                return (i2 & 3) != 0 ? X11.XK_Meta_R : X11.XK_Meta_L;
            }
            return 0;
        }

        private X11KeyboardUtils() {
            super();
        }

        @Override // com.sun.jna.platform.KeyboardUtils.NativeKeyboardUtils
        public boolean isPressed(int i, int i2) {
            X11 x11 = X11.INSTANCE;
            X11.Display displayXOpenDisplay = x11.XOpenDisplay(null);
            if (displayXOpenDisplay == null) {
                throw new Error("Can't open X Display");
            }
            try {
                byte[] bArr = new byte[32];
                x11.XQueryKeymap(displayXOpenDisplay, bArr);
                int keySym = toKeySym(i, i2);
                for (int i3 = 5; i3 < 256; i3++) {
                    if ((bArr[i3 / 8] & (1 << (i3 % 8))) != 0 && x11.XKeycodeToKeysym(displayXOpenDisplay, (byte) i3, 0).intValue() == keySym) {
                        return true;
                    }
                }
                return false;
            } finally {
                x11.XCloseDisplay(displayXOpenDisplay);
            }
        }
    }
}
