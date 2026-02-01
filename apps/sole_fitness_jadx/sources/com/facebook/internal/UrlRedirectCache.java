package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.FileLruCache;
import com.facebook.share.internal.ShareConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

/* compiled from: UrlRedirectCache.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/UrlRedirectCache;", "", "()V", "redirectContentTag", "", ViewHierarchyConstants.TAG_KEY, "urlRedirectFileLruCache", "Lcom/facebook/internal/FileLruCache;", "cacheUriRedirect", "", "fromUri", "Landroid/net/Uri;", "toUri", "clearCache", "getCache", "getRedirectedUri", ShareConstants.MEDIA_URI, "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UrlRedirectCache {
    public static final UrlRedirectCache INSTANCE = new UrlRedirectCache();
    private static final String redirectContentTag;
    private static final String tag;
    private static FileLruCache urlRedirectFileLruCache;

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(UrlRedirectCache.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "UrlRedirectCache";
        }
        tag = simpleName;
        redirectContentTag = simpleName + "_Redirect";
    }

    private UrlRedirectCache() {
    }

    @JvmStatic
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        fileLruCache = urlRedirectFileLruCache;
        if (fileLruCache == null) {
            fileLruCache = new FileLruCache(tag, new FileLruCache.Limits());
        }
        urlRedirectFileLruCache = fileLruCache;
        return fileLruCache;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3, r11) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
    
        com.facebook.internal.Logger.INSTANCE.log(com.facebook.LoggingBehavior.CACHE, 6, com.facebook.internal.UrlRedirectCache.tag, "A loop detected in UrlRedirectCache");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        com.facebook.internal.Utility.closeQuietly(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        return null;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Uri getRedirectedUri(Uri uri) throws Throwable {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3 = null;
        if (uri == null) {
            return null;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
        HashSet hashSet = new HashSet();
        hashSet.add(string);
        try {
            FileLruCache cache = getCache();
            InputStream inputStream = cache.get(string, redirectContentTag);
            inputStreamReader = null;
            boolean z = false;
            while (true) {
                if (inputStream == null) {
                    break;
                }
                z = true;
                try {
                    try {
                        inputStreamReader2 = new InputStreamReader(inputStream);
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader3 = inputStreamReader;
                }
                try {
                    char[] cArr = new char[128];
                    StringBuilder sb = new StringBuilder();
                    for (int i = inputStreamReader2.read(cArr, 0, 128); i > 0; i = inputStreamReader2.read(cArr, 0, 128)) {
                        sb.append(cArr, 0, i);
                    }
                    Utility.closeQuietly(inputStreamReader2);
                    String string2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "urlBuilder.toString()");
                    if (hashSet.contains(string2)) {
                        break;
                    }
                    hashSet.add(string2);
                    inputStreamReader = inputStreamReader2;
                    inputStream = cache.get(string2, redirectContentTag);
                    string = string2;
                } catch (IOException e2) {
                    e = e2;
                    inputStreamReader = inputStreamReader2;
                    Logger.INSTANCE.log(LoggingBehavior.CACHE, 4, tag, "IOException when accessing cache: " + e.getMessage());
                    Utility.closeQuietly(inputStreamReader);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader3 = inputStreamReader2;
                    Utility.closeQuietly(inputStreamReader3);
                    throw th;
                }
            }
            if (z) {
                Uri uri2 = Uri.parse(string);
                Utility.closeQuietly(inputStreamReader);
                return uri2;
            }
        } catch (IOException e3) {
            e = e3;
            inputStreamReader = null;
        } catch (Throwable th3) {
            th = th3;
        }
        Utility.closeQuietly(inputStreamReader);
        return null;
    }

    @JvmStatic
    public static final void cacheUriRedirect(Uri fromUri, Uri toUri) {
        String string;
        Charset charset;
        if (fromUri == null || toUri == null) {
            return;
        }
        OutputStream outputStreamOpenPutStream = null;
        try {
            try {
                FileLruCache cache = getCache();
                String string2 = fromUri.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "fromUri.toString()");
                outputStreamOpenPutStream = cache.openPutStream(string2, redirectContentTag);
                string = toUri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toUri.toString()");
                charset = Charsets.UTF_8;
            } catch (IOException e) {
                Logger.INSTANCE.log(LoggingBehavior.CACHE, 4, tag, "IOException when accessing cache: " + e.getMessage());
            }
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = string.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStreamOpenPutStream.write(bytes);
        } finally {
            Utility.closeQuietly((Closeable) null);
        }
    }

    @JvmStatic
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.INSTANCE.log(LoggingBehavior.CACHE, 5, tag, "clearCache failed " + e.getMessage());
        }
    }
}
