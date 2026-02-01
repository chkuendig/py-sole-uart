package com.android.ddmlib.testrunner;

import com.android.ddmlib.IShellOutputReceiver;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public interface IInstrumentationResultParser extends IShellOutputReceiver {

    public static class SessionResultCodes {
        public static final int ERROR = 0;
        public static final int FINISHED = -1;
    }

    public static class StatusCodes {
        public static final int ASSUMPTION_FAILURE = -4;
        public static final int ERROR = -1;
        public static final int FAILURE = -2;
        public static final int IGNORED = -3;
        public static final int IN_PROGRESS = 2;
        public static final int OK = 0;
        public static final int START = 1;

        public static boolean isTerminalState(int statusCode) {
            return statusCode <= 0;
        }
    }

    void cancel();

    void handleTestRunFailed(String errorMsg);

    public static class StatusKeys {
        public static final String CLASS = "class";
        public static final String CURRENT = "current";
        public static final String DDMLIB_LOGCAT = "com.android.ddmlib.testrunner.logcat";
        public static final String ERROR = "Error";
        public static final String ID = "id";
        public static final Set<String> KNOWN_KEYS;
        public static final String NUMTESTS = "numtests";
        public static final String SHORTMSG = "shortMsg";
        public static final String STACK = "stack";
        public static final String STREAM = "stream";
        public static final String TEST = "test";

        static {
            HashSet hashSet = new HashSet();
            KNOWN_KEYS = hashSet;
            hashSet.add("test");
            hashSet.add("class");
            hashSet.add(STACK);
            hashSet.add(NUMTESTS);
            hashSet.add(ERROR);
            hashSet.add(SHORTMSG);
            hashSet.add(STREAM);
            hashSet.add(CURRENT);
            hashSet.add("id");
            hashSet.add(DDMLIB_LOGCAT);
        }
    }
}
