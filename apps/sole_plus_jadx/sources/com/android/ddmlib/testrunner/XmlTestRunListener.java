package com.android.ddmlib.testrunner;

import com.android.ddmlib.Log;
import com.android.ddmlib.testrunner.TestResult;
import com.facebook.login.LoginLogger;
import com.google.common.collect.ImmutableMap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.kxml2.io.KXmlSerializer;

/* loaded from: classes3.dex */
public class XmlTestRunListener implements ITestRunListener {
    private static final String ATTR_ASSERTIOMS = "assertions";
    private static final String ATTR_CLASSNAME = "classname";
    private static final String ATTR_ERRORS = "errors";
    private static final String ATTR_FAILURES = "failures";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_SKIPPED = "skipped";
    private static final String ATTR_TESTS = "tests";
    private static final String ATTR_TIME = "time";
    private static final String ERROR = "error";
    private static final String FAILURE = "failure";
    private static final String HOSTNAME = "hostname";
    private static final String LOG_TAG = "XmlResultReporter";
    private static final String PROPERTIES = "properties";
    private static final String PROPERTY = "property";
    private static final String SKIPPED_TAG = "skipped";
    private static final String SYSTEM_ERR = "system-err";
    private static final String TESTCASE = "testcase";
    private static final String TESTSUITE = "testsuite";
    private static final String TEST_RESULT_FILE_PREFIX = "test_result_";
    private static final String TEST_RESULT_FILE_SUFFIX = ".xml";
    private static final String TIMESTAMP = "timestamp";
    private static final String ns = null;
    private String mHostName = "localhost";
    private File mReportDir = new File(System.getProperty("java.io.tmpdir"));
    private String mReportPath = "";
    private TestRunResult mRunResult = new TestRunResult();
    private StringBuilder mSystemError = new StringBuilder();

    public void setReportDir(File file) {
        this.mReportDir = file;
    }

    public void setHostName(String hostName) {
        this.mHostName = hostName;
    }

    public TestRunResult getRunResult() {
        return this.mRunResult;
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testRunStarted(String runName, int numTests) {
        TestRunResult testRunResult = new TestRunResult();
        this.mRunResult = testRunResult;
        testRunResult.testRunStarted(runName, numTests);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testStarted(TestIdentifier test) {
        this.mRunResult.testStarted(test);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testFailed(TestIdentifier test, String trace) {
        this.mRunResult.testFailed(test, trace);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testAssumptionFailure(TestIdentifier test, String trace) {
        this.mRunResult.testAssumptionFailure(test, trace);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testIgnored(TestIdentifier test) {
        this.mRunResult.testIgnored(test);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testEnded(TestIdentifier test, Map<String, String> testMetrics) {
        this.mRunResult.testEnded(test, testMetrics);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testRunFailed(String errorMessage) {
        this.mRunResult.testRunFailed(errorMessage);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testRunStopped(long elapsedTime) {
        this.mRunResult.testRunStopped(elapsedTime);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testRunEnded(long elapsedTime, Map<String, String> runMetrics) throws Throwable {
        this.mRunResult.testRunEnded(elapsedTime, runMetrics);
        generateDocument(this.mReportDir, elapsedTime);
    }

    private void generateDocument(File reportDir, long elapsedTime) throws Throwable {
        OutputStream outputStreamCreateOutputResultStream;
        String timestamp = getTimestamp();
        OutputStream outputStream = null;
        try {
            try {
                try {
                    outputStreamCreateOutputResultStream = createOutputResultStream(reportDir);
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                KXmlSerializer kXmlSerializer = new KXmlSerializer();
                kXmlSerializer.setOutput(outputStreamCreateOutputResultStream, "UTF-8");
                kXmlSerializer.startDocument("UTF-8", null);
                kXmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                printTestResults(kXmlSerializer, timestamp, elapsedTime);
                kXmlSerializer.endDocument();
                Log.logAndDisplay(Log.LogLevel.INFO, LOG_TAG, String.format("XML test result file generated at %s. %s", getAbsoluteReportPath(), this.mRunResult.getTextSummary()));
            } catch (IOException unused2) {
                outputStream = outputStreamCreateOutputResultStream;
                Log.e(LOG_TAG, "Failed to generate report data");
                if (outputStream != null) {
                    outputStream.close();
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStreamCreateOutputResultStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
            if (outputStreamCreateOutputResultStream != null) {
                outputStreamCreateOutputResultStream.close();
            }
        } catch (IOException unused4) {
        }
    }

    private String getAbsoluteReportPath() {
        return this.mReportPath;
    }

    String getTimestamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        simpleDateFormat.setLenient(true);
        return simpleDateFormat.format(new Date());
    }

    public String getSystemError() {
        return this.mSystemError.toString();
    }

    public void addSystemError(String systemError) {
        this.mSystemError.append(systemError);
    }

    protected File getResultFile(File reportDir) throws IOException {
        File fileCreateTempFile = File.createTempFile(TEST_RESULT_FILE_PREFIX, ".xml", reportDir);
        Log.i(LOG_TAG, String.format("Created xml report file at %s", fileCreateTempFile.getAbsolutePath()));
        return fileCreateTempFile;
    }

    OutputStream createOutputResultStream(File reportDir) throws IOException {
        File resultFile = getResultFile(reportDir);
        this.mReportPath = resultFile.getAbsolutePath();
        return new BufferedOutputStream(new FileOutputStream(resultFile));
    }

    protected String getTestSuiteName() {
        return this.mRunResult.getName();
    }

    void printTestResults(KXmlSerializer serializer, String timestamp, long elapsedTime) throws IOException {
        String str = ns;
        serializer.startTag(str, TESTSUITE);
        String testSuiteName = getTestSuiteName();
        if (testSuiteName != null) {
            serializer.attribute(str, "name", testSuiteName);
        }
        serializer.attribute(str, ATTR_TESTS, Integer.toString(this.mRunResult.getNumTests()));
        serializer.attribute(str, ATTR_FAILURES, Integer.toString(this.mRunResult.getNumAllFailedTests()));
        serializer.attribute(str, ATTR_ERRORS, "0");
        serializer.attribute(str, LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, Integer.toString(this.mRunResult.getNumTestsInState(TestResult.TestStatus.IGNORED)));
        serializer.attribute(str, ATTR_TIME, Double.toString(elapsedTime / 1000.0d));
        serializer.attribute(str, "timestamp", timestamp);
        serializer.attribute(str, HOSTNAME, this.mHostName);
        serializer.startTag(str, PROPERTIES);
        for (Map.Entry<String, String> entry : getPropertiesAttributes().entrySet()) {
            String str2 = ns;
            serializer.startTag(str2, "property");
            serializer.attribute(str2, "name", entry.getKey());
            serializer.attribute(str2, "value", entry.getValue());
            serializer.endTag(str2, "property");
        }
        serializer.endTag(ns, PROPERTIES);
        for (Map.Entry<TestIdentifier, TestResult> entry2 : this.mRunResult.getTestResults().entrySet()) {
            print(serializer, entry2.getKey(), entry2.getValue());
        }
        String systemError = getSystemError();
        if (!systemError.isEmpty()) {
            String str3 = ns;
            serializer.startTag(str3, SYSTEM_ERR);
            serializer.text(systemError);
            serializer.endTag(str3, SYSTEM_ERR);
        }
        serializer.endTag(ns, TESTSUITE);
    }

    protected Map<String, String> getPropertiesAttributes() {
        return ImmutableMap.of();
    }

    protected String getTestName(TestIdentifier testId) {
        return testId.getTestName();
    }

    void print(KXmlSerializer serializer, TestIdentifier testId, TestResult testResult) throws IOException {
        String str = ns;
        serializer.startTag(str, TESTCASE);
        serializer.attribute(str, "name", getTestName(testId));
        serializer.attribute(str, "classname", testId.getClassName());
        serializer.attribute(str, ATTR_TIME, Double.toString((testResult.getEndTime() - testResult.getStartTime()) / 1000.0d));
        int i = AnonymousClass1.$SwitchMap$com$android$ddmlib$testrunner$TestResult$TestStatus[testResult.getStatus().ordinal()];
        if (i == 1) {
            printFailedTest(serializer, "failure", testResult.getStackTrace());
        } else if (i == 2) {
            printFailedTest(serializer, LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, testResult.getStackTrace());
        } else if (i == 3) {
            serializer.startTag(str, LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED);
            serializer.endTag(str, LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED);
        }
        serializer.endTag(str, TESTCASE);
    }

    /* renamed from: com.android.ddmlib.testrunner.XmlTestRunListener$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$ddmlib$testrunner$TestResult$TestStatus;

        static {
            int[] iArr = new int[TestResult.TestStatus.values().length];
            $SwitchMap$com$android$ddmlib$testrunner$TestResult$TestStatus = iArr;
            try {
                iArr[TestResult.TestStatus.FAILURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$ddmlib$testrunner$TestResult$TestStatus[TestResult.TestStatus.ASSUMPTION_FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$ddmlib$testrunner$TestResult$TestStatus[TestResult.TestStatus.IGNORED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void printFailedTest(KXmlSerializer serializer, String tag, String stack) throws IOException {
        String str = ns;
        serializer.startTag(str, tag);
        serializer.text(sanitize(stack));
        serializer.endTag(str, tag);
    }

    private String sanitize(String text) {
        return text.replace("\u0000", "<\\0>");
    }
}
