package com.android.ddmlib.testrunner;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes3.dex */
public class TestResult {
    private Map<String, String> mMetrics;
    private String mStackTrace;
    private long mStartTime;
    private long mEndTime = 0;
    private TestStatus mStatus = TestStatus.INCOMPLETE;

    public enum TestStatus {
        FAILURE,
        PASSED,
        INCOMPLETE,
        ASSUMPTION_FAILURE,
        IGNORED
    }

    public TestResult() {
        this.mStartTime = 0L;
        this.mStartTime = System.currentTimeMillis();
    }

    public TestStatus getStatus() {
        return this.mStatus;
    }

    public String getStackTrace() {
        return this.mStackTrace;
    }

    public Map<String, String> getMetrics() {
        return this.mMetrics;
    }

    public void setMetrics(Map<String, String> metrics) {
        this.mMetrics = metrics;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public void setStartTime(long startTime) {
        this.mStartTime = startTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public TestResult setStatus(TestStatus status) {
        this.mStatus = status;
        return this;
    }

    public void setStackTrace(String trace) {
        this.mStackTrace = trace;
    }

    public void setEndTime(long currentTimeMillis) {
        this.mEndTime = currentTimeMillis;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.mMetrics, this.mStackTrace, this.mStatus});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TestResult testResult = (TestResult) obj;
        return equal(this.mMetrics, testResult.mMetrics) && equal(this.mStackTrace, testResult.mStackTrace) && equal(this.mStatus, testResult.mStatus);
    }

    private static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }
}
