package com.ua.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.webkit.MimeTypeMap;
import com.ua.sdk.NetworkError;
import com.ua.sdk.Ua;
import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public class Precondition {
    public static final String[] IMAGE_EXT = {"jpg", "png", "gif", "jpeg"};

    public static void isInBackground() throws IllegalStateException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot call on main thread.");
        }
    }

    public static void isAuthenticated(AuthenticationManager authenticationManager) throws UaException {
        if (authenticationManager == null) {
            throw new UaException("AuthenticaitonManager is null.");
        }
        if (!authenticationManager.isAuthenticated()) {
            throw new UaException(UaException.Code.NOT_AUTHENTICATED);
        }
    }

    public static void isNotAuthenticated(Ua ua) {
        if (ua.isAuthenticated()) {
            throw new IllegalStateException("Already authenticated.");
        }
    }

    public static void isOnMain() throws IllegalStateException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Must call on main thread.");
        }
    }

    public static <T> T isNotNull(T t) throws NullPointerException {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T isNotNull(T t, String str) throws NullPointerException {
        if (t != null) {
            return t;
        }
        Objects.requireNonNull(str);
        throw new NullPointerException(str + " is null");
    }

    public static int isNotNegative(int i) throws IllegalArgumentException {
        return isNotNegative(i, null);
    }

    public static int isNotNegative(int i, String str) throws IllegalArgumentException {
        String str2;
        if (str == null || str.length() == 0) {
            str2 = "";
        } else {
            str2 = str + " must be a positive number.";
        }
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str2);
    }

    public static int isValidIndex(List<?> list, int i) {
        if (list != null && i >= 0 && i < list.size()) {
            return i;
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + (list == null ? 0 : list.size()));
    }

    public static void check(boolean z, String str) throws IllegalArgumentException {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void isResponseHttpOk(HttpURLConnection httpURLConnection) throws IOException, UaException {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
            } else {
                throw new NetworkError(responseCode, httpURLConnection);
            }
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException unused2) {
            throw new UaException(UaException.Code.UNKNOWN);
        }
    }

    public static void isConnected(Context context) throws UaException {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            throw new UaException(UaException.Code.NOT_CONNECTED);
        }
    }

    public static void isResponseSuccess(HttpURLConnection httpURLConnection) throws IOException, UaException {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode > 299) {
                throw new NetworkError(responseCode, httpURLConnection);
            }
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException unused2) {
            throw new UaException(UaException.Code.UNKNOWN);
        }
    }

    public static void isExpectedResponse(HttpURLConnection httpURLConnection, int i) throws IOException, UaException {
        if (httpURLConnection == null) {
            throw new UaException("connection is null, cannot check response code.");
        }
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == i) {
            } else {
                throw new NetworkError(responseCode, httpURLConnection);
            }
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException unused2) {
            throw new UaException(UaException.Code.UNKNOWN);
        }
    }

    public static void hasImageExtension(File file) throws UaException {
        if (file == null) {
            throw new UaException("file is null");
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(file.getName());
        if (fileExtensionFromUrl != null && !fileExtensionFromUrl.isEmpty()) {
            String lowerCase = fileExtensionFromUrl.toLowerCase();
            int length = IMAGE_EXT.length;
            for (int i = 0; i < length; i++) {
                if (IMAGE_EXT[i].equals(lowerCase)) {
                    return;
                }
            }
        }
        throw new UaException(file.getAbsolutePath() + " not an image.");
    }
}
