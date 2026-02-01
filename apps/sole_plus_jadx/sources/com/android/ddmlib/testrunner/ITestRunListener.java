package com.android.ddmlib.testrunner;

import java.util.Map;

/* loaded from: classes3.dex */
public interface ITestRunListener {
    void testAssumptionFailure(TestIdentifier test, String trace);

    void testEnded(TestIdentifier test, Map<String, String> testMetrics);

    void testFailed(TestIdentifier test, String trace);

    void testIgnored(TestIdentifier test);

    void testRunEnded(long elapsedTime, Map<String, String> runMetrics);

    void testRunFailed(String errorMessage);

    void testRunStarted(String runName, int testCount);

    @Deprecated
    void testRunStopped(long elapsedTime);

    void testStarted(TestIdentifier test);
}
