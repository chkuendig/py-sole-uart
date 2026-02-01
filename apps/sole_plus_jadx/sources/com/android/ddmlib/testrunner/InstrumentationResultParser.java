package com.android.ddmlib.testrunner;

import com.android.ddmlib.Log;
import com.android.ddmlib.MultiLineReceiver;
import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
/* loaded from: classes3.dex */
public class InstrumentationResultParser extends MultiLineReceiver implements IInstrumentationResultParser {
    static final String FATAL_EXCEPTION_MSG = "Fatal exception when running tests";
    static final String INCOMPLETE_RUN_ERR_MSG_PREFIX = "Test run failed to complete";
    static final String INCOMPLETE_TEST_ERR_MSG_POSTFIX = "Check device logcat for details";
    static final String INCOMPLETE_TEST_ERR_MSG_PREFIX = "Test failed to run to completion";
    static final Pattern INSTRUMENTATION_FAILURES_PATTERN = Pattern.compile("There (was|were) (\\d+) failure(.*)", 32);
    static final String INVALID_OUTPUT_ERR_MSG = "Output from instrumentation is missing its time stamp";
    private static final String LOG_TAG = "InstrumentationResultParser";
    static final String NO_TEST_RESULTS_MSG = "No test results";
    private String mCurrentKey;
    private TestResult mCurrentTestResult;
    private StringBuilder mCurrentValue;
    private boolean mInInstrumentationResultKey;
    private Map<String, String> mInstrumentationResultBundle;
    private boolean mIsCancelled;
    private TestResult mLastTestResult;
    private int mNumTestsExpected;
    private int mNumTestsRun;
    private String mOnError;
    private String mStreamError;
    private final Collection<ITestRunListener> mTestListeners;
    private Map<String, String> mTestMetrics;
    private boolean mTestRunFailReported;
    private boolean mTestRunFinished;
    private final String mTestRunName;
    private boolean mTestStartReported;
    private Long mTestTime;

    private static class Prefixes {
        private static final String CODE = "INSTRUMENTATION_CODE: ";
        private static final String ON_ERROR = "onError:";
        private static final String RESULT = "INSTRUMENTATION_RESULT: ";
        private static final String STATUS = "INSTRUMENTATION_STATUS: ";
        private static final String STATUS_ABORTED = "INSTRUMENTATION_ABORTED: ";
        private static final String STATUS_CODE = "INSTRUMENTATION_STATUS_CODE: ";
        private static final String STATUS_FAILED = "INSTRUMENTATION_FAILED: ";
        private static final String TIME_REPORT = "Time: ";

        private Prefixes() {
        }
    }

    private static class TestResult {
        private Integer mCode;
        private String mCurrentTestNumber;
        private Integer mNumTests;
        private String mStackTrace;
        private String mTestClass;
        private String mTestName;

        private TestResult() {
            this.mCode = null;
            this.mTestName = null;
            this.mTestClass = null;
            this.mStackTrace = null;
            this.mNumTests = null;
            this.mCurrentTestNumber = null;
        }

        boolean isComplete() {
            return (this.mCode == null || this.mTestName == null || this.mTestClass == null) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.mTestClass;
            if (str != null) {
                sb.append(str);
                sb.append('#');
            }
            String str2 = this.mTestName;
            if (str2 != null) {
                sb.append(str2);
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return "unknown result";
        }
    }

    public InstrumentationResultParser(String runName, Collection<ITestRunListener> listeners) {
        this.mCurrentTestResult = null;
        this.mLastTestResult = null;
        this.mCurrentKey = null;
        this.mCurrentValue = null;
        this.mTestStartReported = false;
        this.mTestRunFinished = false;
        this.mTestRunFailReported = false;
        this.mTestTime = null;
        this.mIsCancelled = false;
        this.mNumTestsRun = 0;
        this.mNumTestsExpected = 0;
        this.mInInstrumentationResultKey = false;
        this.mStreamError = null;
        this.mOnError = null;
        this.mInstrumentationResultBundle = new LinkedHashMap();
        this.mTestMetrics = new LinkedHashMap();
        this.mTestRunName = runName;
        this.mTestListeners = new ArrayList(listeners);
    }

    public InstrumentationResultParser(String runName, ITestRunListener listener) {
        this(runName, Collections.singletonList(listener));
    }

    @Override // com.android.ddmlib.MultiLineReceiver
    public void processNewLines(String[] lines) {
        for (String str : lines) {
            parse(str);
            Log.v(LOG_TAG, str);
        }
    }

    private void parse(String line) {
        if (line.startsWith("INSTRUMENTATION_STATUS_CODE: ")) {
            submitCurrentKeyValue();
            this.mInInstrumentationResultKey = false;
            parseStatusCode(line);
            return;
        }
        if (line.startsWith("INSTRUMENTATION_STATUS: ")) {
            submitCurrentKeyValue();
            this.mInInstrumentationResultKey = false;
            parseKey(line, "INSTRUMENTATION_STATUS: ".length());
            return;
        }
        if (line.startsWith("INSTRUMENTATION_RESULT: ")) {
            submitCurrentKeyValue();
            this.mInInstrumentationResultKey = true;
            parseKey(line, "INSTRUMENTATION_RESULT: ".length());
            return;
        }
        if (line.startsWith("INSTRUMENTATION_FAILED: ") || line.startsWith("INSTRUMENTATION_CODE: ")) {
            submitCurrentKeyValue();
            this.mInInstrumentationResultKey = false;
            this.mTestRunFinished = true;
            return;
        }
        if (line.startsWith("Time: ")) {
            parseTime(line);
            return;
        }
        if (line.startsWith("onError:")) {
            this.mOnError = line;
            return;
        }
        if (line.startsWith("INSTRUMENTATION_ABORTED: ")) {
            if (this.mOnError == null) {
                this.mOnError = line;
                return;
            }
            return;
        }
        StringBuilder sb = this.mCurrentValue;
        if (sb != null) {
            sb.append("\r\n");
            this.mCurrentValue.append(line);
        } else {
            if (line.trim().isEmpty()) {
                return;
            }
            Log.d(LOG_TAG, "unrecognized line " + line);
        }
    }

    private void submitCurrentKeyValue() {
        StringBuilder sb;
        if (this.mCurrentKey == null || (sb = this.mCurrentValue) == null) {
            return;
        }
        String string = sb.toString();
        if (this.mInInstrumentationResultKey) {
            if (!IInstrumentationResultParser.StatusKeys.KNOWN_KEYS.contains(this.mCurrentKey)) {
                this.mInstrumentationResultBundle.put(this.mCurrentKey, string);
            } else if (this.mCurrentKey.equals(IInstrumentationResultParser.StatusKeys.SHORTMSG)) {
                handleTestRunFailed(String.format("Instrumentation run failed due to '%1$s'", string));
            } else if (IInstrumentationResultParser.StatusKeys.STREAM.equals(this.mCurrentKey) && string != null && (string.contains(FATAL_EXCEPTION_MSG) || INSTRUMENTATION_FAILURES_PATTERN.matcher(string.trim()).matches())) {
                this.mStreamError = string.trim();
            }
        } else {
            TestResult currentTestInfo = getCurrentTestInfo();
            if (this.mCurrentKey.equals("class")) {
                currentTestInfo.mTestClass = string.trim();
            } else if (this.mCurrentKey.equals("test")) {
                currentTestInfo.mTestName = string.trim();
            } else if (this.mCurrentKey.equals(IInstrumentationResultParser.StatusKeys.NUMTESTS)) {
                try {
                    currentTestInfo.mNumTests = Integer.valueOf(Integer.parseInt(string));
                } catch (NumberFormatException unused) {
                    Log.w(LOG_TAG, "Unexpected integer number of tests, received " + string);
                }
            } else if (this.mCurrentKey.equals(IInstrumentationResultParser.StatusKeys.ERROR)) {
                handleTestRunFailed(string);
            } else if (this.mCurrentKey.equals(IInstrumentationResultParser.StatusKeys.STACK)) {
                currentTestInfo.mStackTrace = string;
            } else if (IInstrumentationResultParser.StatusKeys.CURRENT.equals(this.mCurrentKey)) {
                currentTestInfo.mCurrentTestNumber = string;
            } else if (!IInstrumentationResultParser.StatusKeys.KNOWN_KEYS.contains(this.mCurrentKey) && this.mTestMetrics.put(this.mCurrentKey, string) != null) {
                Log.d(LOG_TAG, String.format("Received a duplicate metric key '%s' which value will be overridden.", this.mCurrentKey));
            }
        }
        this.mCurrentKey = null;
        this.mCurrentValue = null;
    }

    private Map<String, String> getAndResetTestMetrics() {
        Map<String, String> map = this.mTestMetrics;
        this.mTestMetrics = new HashMap();
        return map;
    }

    private TestResult getCurrentTestInfo() {
        if (this.mCurrentTestResult == null) {
            this.mCurrentTestResult = new TestResult();
        }
        return this.mCurrentTestResult;
    }

    private void clearCurrentTestInfo() {
        this.mLastTestResult = this.mCurrentTestResult;
        this.mCurrentTestResult = null;
    }

    private void parseKey(String line, int keyStartPos) {
        int iIndexOf = line.indexOf(61, keyStartPos);
        if (iIndexOf != -1) {
            this.mCurrentKey = line.substring(keyStartPos, iIndexOf).trim();
            parseValue(line, iIndexOf + 1);
        }
    }

    private void parseValue(String line, int valueStartPos) {
        StringBuilder sb = new StringBuilder();
        this.mCurrentValue = sb;
        sb.append(line.substring(valueStartPos));
    }

    private void parseStatusCode(String line) {
        String strTrim = line.substring("INSTRUMENTATION_STATUS_CODE: ".length()).trim();
        TestResult currentTestInfo = getCurrentTestInfo();
        currentTestInfo.mCode = -1;
        try {
            currentTestInfo.mCode = Integer.valueOf(Integer.parseInt(strTrim));
        } catch (NumberFormatException unused) {
            Log.w(LOG_TAG, "Expected integer status code, received: " + strTrim);
            currentTestInfo.mCode = -1;
        }
        if (currentTestInfo.mCode.intValue() != 2) {
            reportResult(currentTestInfo);
            clearCurrentTestInfo();
        }
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public boolean isCancelled() {
        return this.mIsCancelled;
    }

    @Override // com.android.ddmlib.testrunner.IInstrumentationResultParser
    public void cancel() {
        this.mIsCancelled = true;
    }

    private void reportResult(TestResult testInfo) {
        if (!testInfo.isComplete()) {
            Log.w(LOG_TAG, "invalid instrumentation status bundle " + testInfo.toString());
            return;
        }
        reportTestRunStarted(testInfo);
        TestIdentifier testIdentifier = new TestIdentifier(testInfo.mTestClass, testInfo.mTestName);
        int iIntValue = testInfo.mCode.intValue();
        if (iIntValue == -4) {
            Map<String, String> andResetTestMetrics = getAndResetTestMetrics();
            for (ITestRunListener iTestRunListener : this.mTestListeners) {
                iTestRunListener.testAssumptionFailure(testIdentifier, getTrace(testInfo));
                iTestRunListener.testEnded(testIdentifier, andResetTestMetrics);
            }
            this.mNumTestsRun++;
            return;
        }
        if (iIntValue == -3) {
            Map<String, String> andResetTestMetrics2 = getAndResetTestMetrics();
            for (ITestRunListener iTestRunListener2 : this.mTestListeners) {
                iTestRunListener2.testIgnored(testIdentifier);
                iTestRunListener2.testEnded(testIdentifier, andResetTestMetrics2);
            }
            this.mNumTestsRun++;
            return;
        }
        if (iIntValue == -2) {
            if (this.mLastTestResult.mCurrentTestNumber != null && this.mLastTestResult.mCurrentTestNumber.equals(this.mCurrentTestResult.mCurrentTestNumber) && this.mLastTestResult.mStackTrace != null) {
                Log.e(LOG_TAG, String.format("Ignoring repeated failed event for %s. Stack: %s", this.mCurrentTestResult.toString(), this.mCurrentTestResult.mStackTrace));
                return;
            }
            Map<String, String> andResetTestMetrics3 = getAndResetTestMetrics();
            for (ITestRunListener iTestRunListener3 : this.mTestListeners) {
                iTestRunListener3.testFailed(testIdentifier, getTrace(testInfo));
                iTestRunListener3.testEnded(testIdentifier, andResetTestMetrics3);
            }
            this.mNumTestsRun++;
            return;
        }
        if (iIntValue == -1) {
            Map<String, String> andResetTestMetrics4 = getAndResetTestMetrics();
            for (ITestRunListener iTestRunListener4 : this.mTestListeners) {
                iTestRunListener4.testFailed(testIdentifier, getTrace(testInfo));
                iTestRunListener4.testEnded(testIdentifier, andResetTestMetrics4);
            }
            this.mNumTestsRun++;
            return;
        }
        if (iIntValue == 0) {
            Map<String, String> andResetTestMetrics5 = getAndResetTestMetrics();
            Iterator<ITestRunListener> it = this.mTestListeners.iterator();
            while (it.hasNext()) {
                it.next().testEnded(testIdentifier, andResetTestMetrics5);
            }
            this.mNumTestsRun++;
            return;
        }
        if (iIntValue == 1) {
            Iterator<ITestRunListener> it2 = this.mTestListeners.iterator();
            while (it2.hasNext()) {
                it2.next().testStarted(testIdentifier);
            }
        } else {
            Map<String, String> andResetTestMetrics6 = getAndResetTestMetrics();
            Log.e(LOG_TAG, "Unknown status code received: " + testInfo.mCode);
            Iterator<ITestRunListener> it3 = this.mTestListeners.iterator();
            while (it3.hasNext()) {
                it3.next().testEnded(testIdentifier, andResetTestMetrics6);
            }
            this.mNumTestsRun++;
        }
    }

    private void reportTestRunStarted(TestResult testInfo) {
        if (this.mTestStartReported || testInfo.mNumTests == null) {
            return;
        }
        Iterator<ITestRunListener> it = this.mTestListeners.iterator();
        while (it.hasNext()) {
            it.next().testRunStarted(this.mTestRunName, testInfo.mNumTests.intValue());
        }
        this.mNumTestsExpected = testInfo.mNumTests.intValue();
        this.mTestStartReported = true;
    }

    private String getTrace(TestResult testInfo) {
        if (testInfo.mStackTrace != null) {
            return testInfo.mStackTrace;
        }
        Log.e(LOG_TAG, "Could not find stack trace for failed test ");
        return new Throwable("Unknown failure").toString();
    }

    private void parseTime(String line) {
        Matcher matcher = Pattern.compile(String.format("%s\\s*([\\d\\,]*[\\d\\.]+)", "Time: ")).matcher(line);
        if (matcher.find()) {
            try {
                this.mTestTime = Long.valueOf((long) (NumberFormat.getInstance().parse(matcher.group(1)).floatValue() * 1000.0f));
                return;
            } catch (ParseException unused) {
                Log.w(LOG_TAG, String.format("Unexpected time format %1$s", line));
                return;
            }
        }
        Log.w(LOG_TAG, String.format("Unexpected time format %1$s", line));
    }

    @Override // com.android.ddmlib.testrunner.IInstrumentationResultParser
    public void handleTestRunFailed(String errorMsg) {
        Log.i(LOG_TAG, String.format("test run failed: '%1$s'", errorMsg));
        String str = this.mOnError;
        if (str != null) {
            errorMsg = String.format("%s. %s", errorMsg, str);
        } else {
            String str2 = this.mStreamError;
            if (str2 != null) {
                errorMsg = String.format("%s. %s", errorMsg, str2);
            }
        }
        TestResult testResult = this.mLastTestResult;
        if (testResult != null && testResult.isComplete() && 1 == this.mLastTestResult.mCode.intValue()) {
            TestIdentifier testIdentifier = new TestIdentifier(this.mLastTestResult.mTestClass, this.mLastTestResult.mTestName);
            for (ITestRunListener iTestRunListener : this.mTestListeners) {
                iTestRunListener.testFailed(testIdentifier, String.format("%1$s. Reason: '%2$s'. %3$s", INCOMPLETE_TEST_ERR_MSG_PREFIX, errorMsg, INCOMPLETE_TEST_ERR_MSG_POSTFIX));
                iTestRunListener.testEnded(testIdentifier, getAndResetTestMetrics());
            }
        }
        for (ITestRunListener iTestRunListener2 : this.mTestListeners) {
            if (!this.mTestStartReported) {
                iTestRunListener2.testRunStarted(this.mTestRunName, 0);
            }
            iTestRunListener2.testRunFailed(errorMsg);
            if (this.mTestTime == null) {
                this.mTestTime = 0L;
            }
            iTestRunListener2.testRunEnded(this.mTestTime.longValue(), this.mInstrumentationResultBundle);
        }
        this.mOnError = null;
        this.mTestStartReported = true;
        this.mTestRunFailReported = true;
    }

    @Override // com.android.ddmlib.MultiLineReceiver
    public void done() {
        super.done();
        if (this.mTestRunFailReported) {
            return;
        }
        handleOutputDone();
    }

    private void handleOutputDone() {
        String str;
        boolean z = this.mTestStartReported;
        if (!z && !this.mTestRunFinished) {
            handleTestRunFailed(NO_TEST_RESULTS_MSG);
            return;
        }
        int i = this.mNumTestsExpected;
        if (i > this.mNumTestsRun) {
            String str2 = String.format("%1$s. Expected %2$d tests, received %3$d", INCOMPLETE_RUN_ERR_MSG_PREFIX, Integer.valueOf(i), Integer.valueOf(this.mNumTestsRun));
            if (this.mTestRunFinished) {
                str2 = String.format(Locale.US, "Instrumentation reported numtests=%d but only ran %d", Integer.valueOf(this.mNumTestsExpected), Integer.valueOf(this.mNumTestsRun));
            }
            handleTestRunFailed(str2);
            return;
        }
        if (!z) {
            Iterator<ITestRunListener> it = this.mTestListeners.iterator();
            while (it.hasNext()) {
                it.next().testRunStarted(this.mTestRunName, 0);
            }
        }
        if (this.mTestTime == null) {
            this.mTestTime = 0L;
        }
        for (ITestRunListener iTestRunListener : this.mTestListeners) {
            if (!this.mTestRunFailReported && (str = this.mStreamError) != null && str.contains(FATAL_EXCEPTION_MSG)) {
                iTestRunListener.testRunFailed(this.mStreamError.trim());
            }
            iTestRunListener.testRunEnded(this.mTestTime.longValue(), this.mInstrumentationResultBundle);
        }
    }
}
