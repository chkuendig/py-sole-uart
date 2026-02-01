package com.android.ddmlib.testrunner;

import com.android.ddmlib.Log;
import com.android.ddmlib.testrunner.TestResult;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class TestRunResult implements ITestRunListener {
    private static final String LOG_TAG = "TestRunResult";
    private Map<TestIdentifier, TestResult> mTestResults = new LinkedHashMap();
    private Map<String, String> mRunMetrics = new HashMap();
    private boolean mIsRunComplete = false;
    private long mElapsedTime = 0;
    private int[] mStatusCounts = new int[TestResult.TestStatus.values().length];
    private boolean mIsCountDirty = true;
    private String mRunFailureError = null;
    private boolean mAggregateMetrics = false;
    private String mTestRunName = "not started";

    public void setAggregateMetrics(boolean metricAggregation) {
        this.mAggregateMetrics = metricAggregation;
    }

    public String getName() {
        return this.mTestRunName;
    }

    public Map<TestIdentifier, TestResult> getTestResults() {
        return this.mTestResults;
    }

    public Map<String, String> getRunMetrics() {
        return this.mRunMetrics;
    }

    public Set<TestIdentifier> getCompletedTests() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<TestIdentifier, TestResult> entry : getTestResults().entrySet()) {
            if (!entry.getValue().getStatus().equals(TestResult.TestStatus.INCOMPLETE)) {
                linkedHashSet.add(entry.getKey());
            }
        }
        return linkedHashSet;
    }

    public boolean isRunFailure() {
        return this.mRunFailureError != null;
    }

    public boolean isRunComplete() {
        return this.mIsRunComplete;
    }

    public void setRunComplete(boolean runComplete) {
        this.mIsRunComplete = runComplete;
    }

    public int getNumTestsInState(TestResult.TestStatus status) {
        if (this.mIsCountDirty) {
            int i = 0;
            while (true) {
                int[] iArr = this.mStatusCounts;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = 0;
                i++;
            }
            for (TestResult testResult : this.mTestResults.values()) {
                int[] iArr2 = this.mStatusCounts;
                int iOrdinal = testResult.getStatus().ordinal();
                iArr2[iOrdinal] = iArr2[iOrdinal] + 1;
            }
            this.mIsCountDirty = false;
        }
        return this.mStatusCounts[status.ordinal()];
    }

    public int getNumTests() {
        return this.mTestResults.size();
    }

    public int getNumCompleteTests() {
        return getNumTests() - getNumTestsInState(TestResult.TestStatus.INCOMPLETE);
    }

    public boolean hasFailedTests() {
        return getNumAllFailedTests() > 0;
    }

    public int getNumAllFailedTests() {
        return getNumTestsInState(TestResult.TestStatus.FAILURE);
    }

    public long getElapsedTime() {
        return this.mElapsedTime;
    }

    public String getRunFailureMessage() {
        return this.mRunFailureError;
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testRunStarted(String runName, int testCount) {
        this.mTestRunName = runName;
        this.mIsRunComplete = false;
        this.mRunFailureError = null;
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testStarted(TestIdentifier test) {
        testStarted(test, System.currentTimeMillis());
    }

    void testStarted(TestIdentifier test, long startTime) {
        TestResult testResult = new TestResult();
        testResult.setStartTime(startTime);
        addTestResult(test, testResult);
    }

    private void addTestResult(TestIdentifier test, TestResult testResult) {
        this.mIsCountDirty = true;
        this.mTestResults.put(test, testResult);
    }

    private void updateTestResult(TestIdentifier test, TestResult.TestStatus status, String trace) {
        TestResult testResult = this.mTestResults.get(test);
        if (testResult == null) {
            Log.d(LOG_TAG, String.format("received test event without test start for %s", test));
            testResult = new TestResult();
        }
        testResult.setStatus(status);
        testResult.setStackTrace(trace);
        addTestResult(test, testResult);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testFailed(TestIdentifier test, String trace) {
        updateTestResult(test, TestResult.TestStatus.FAILURE, trace);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testAssumptionFailure(TestIdentifier test, String trace) {
        updateTestResult(test, TestResult.TestStatus.ASSUMPTION_FAILURE, trace);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testIgnored(TestIdentifier test) {
        updateTestResult(test, TestResult.TestStatus.IGNORED, null);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testEnded(TestIdentifier test, Map<String, String> testMetrics) {
        testEnded(test, System.currentTimeMillis(), testMetrics);
    }

    void testEnded(TestIdentifier test, long endTime, Map<String, String> testMetrics) {
        TestResult testResult = this.mTestResults.get(test);
        if (testResult == null) {
            testResult = new TestResult();
        }
        if (testResult.getStatus().equals(TestResult.TestStatus.INCOMPLETE)) {
            testResult.setStatus(TestResult.TestStatus.PASSED);
        }
        testResult.setEndTime(endTime);
        testResult.setMetrics(testMetrics);
        addTestResult(test, testResult);
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testRunFailed(String errorMessage) {
        this.mRunFailureError = errorMessage;
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testRunStopped(long elapsedTime) {
        this.mElapsedTime += elapsedTime;
        this.mIsRunComplete = true;
    }

    @Override // com.android.ddmlib.testrunner.ITestRunListener
    public void testRunEnded(long elapsedTime, Map<String, String> runMetrics) {
        if (this.mAggregateMetrics) {
            for (Map.Entry<String, String> entry : runMetrics.entrySet()) {
                this.mRunMetrics.put(entry.getKey(), combineValues(this.mRunMetrics.get(entry.getKey()), entry.getValue()));
            }
        } else {
            this.mRunMetrics.putAll(runMetrics);
        }
        this.mElapsedTime += elapsedTime;
        this.mIsRunComplete = true;
    }

    private String combineValues(String existingValue, String newValue) {
        if (existingValue != null) {
            try {
                try {
                    return Long.toString(Long.valueOf(Long.parseLong(existingValue)).longValue() + Long.valueOf(Long.parseLong(newValue)).longValue());
                } catch (NumberFormatException unused) {
                }
            } catch (NumberFormatException unused2) {
                return Double.toString(Double.valueOf(Double.parseDouble(existingValue)).doubleValue() + Double.valueOf(Double.parseDouble(newValue)).doubleValue());
            }
        }
        return newValue;
    }

    public String getTextSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Total tests %d, ", Integer.valueOf(getNumTests())));
        for (TestResult.TestStatus testStatus : TestResult.TestStatus.values()) {
            int numTestsInState = getNumTestsInState(testStatus);
            if (numTestsInState > 0) {
                sb.append(String.format("%s %d, ", testStatus.toString().toLowerCase(), Integer.valueOf(numTestsInState)));
            }
        }
        return sb.toString();
    }
}
