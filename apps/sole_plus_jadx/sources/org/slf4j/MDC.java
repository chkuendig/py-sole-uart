package org.slf4j;

import java.io.Closeable;
import java.util.Deque;
import java.util.Map;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Util;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

/* loaded from: classes6.dex */
public class MDC {
    private static final String MDC_APAPTER_CANNOT_BE_NULL_MESSAGE = "MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA";
    static final String NO_STATIC_MDC_BINDER_URL = "http://www.slf4j.org/codes.html#no_static_mdc_binder";
    static final String NULL_MDCA_URL = "http://www.slf4j.org/codes.html#null_MDCA";
    static MDCAdapter mdcAdapter;

    public static class MDCCloseable implements Closeable {
        private final String key;

        private MDCCloseable(String str) {
            this.key = str;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IllegalArgumentException {
            MDC.remove(this.key);
        }
    }

    private MDC() {
    }

    static {
        SLF4JServiceProvider provider = LoggerFactory.getProvider();
        if (provider != null) {
            mdcAdapter = provider.getMDCAdapter();
            return;
        }
        Util.report("Failed to find provider.");
        Util.report("Defaulting to no-operation MDCAdapter implementation.");
        mdcAdapter = new NOPMDCAdapter();
    }

    public static void put(String str, String str2) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter == null) {
            throw new IllegalStateException(MDC_APAPTER_CANNOT_BE_NULL_MESSAGE);
        }
        mDCAdapter.put(str, str2);
    }

    public static MDCCloseable putCloseable(String str, String str2) throws IllegalArgumentException {
        put(str, str2);
        return new MDCCloseable(str);
    }

    public static String get(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter == null) {
            throw new IllegalStateException(MDC_APAPTER_CANNOT_BE_NULL_MESSAGE);
        }
        return mDCAdapter.get(str);
    }

    public static void remove(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter == null) {
            throw new IllegalStateException(MDC_APAPTER_CANNOT_BE_NULL_MESSAGE);
        }
        mDCAdapter.remove(str);
    }

    public static void clear() {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter == null) {
            throw new IllegalStateException(MDC_APAPTER_CANNOT_BE_NULL_MESSAGE);
        }
        mDCAdapter.clear();
    }

    public static Map<String, String> getCopyOfContextMap() {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter == null) {
            throw new IllegalStateException(MDC_APAPTER_CANNOT_BE_NULL_MESSAGE);
        }
        return mDCAdapter.getCopyOfContextMap();
    }

    public static void setContextMap(Map<String, String> map) {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter == null) {
            throw new IllegalStateException(MDC_APAPTER_CANNOT_BE_NULL_MESSAGE);
        }
        mDCAdapter.setContextMap(map);
    }

    public static MDCAdapter getMDCAdapter() {
        return mdcAdapter;
    }

    public static void pushByKey(String str, String str2) {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter == null) {
            throw new IllegalStateException(MDC_APAPTER_CANNOT_BE_NULL_MESSAGE);
        }
        mDCAdapter.pushByKey(str, str2);
    }

    public static String popByKey(String str) {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter == null) {
            throw new IllegalStateException(MDC_APAPTER_CANNOT_BE_NULL_MESSAGE);
        }
        return mDCAdapter.popByKey(str);
    }

    public Deque<String> getCopyOfDequeByKey(String str) {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter == null) {
            throw new IllegalStateException(MDC_APAPTER_CANNOT_BE_NULL_MESSAGE);
        }
        return mDCAdapter.getCopyOfDequeByKey(str);
    }
}
